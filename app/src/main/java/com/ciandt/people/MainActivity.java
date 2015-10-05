package com.ciandt.people;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.ciandt.people.application.App;
import com.ciandt.people.application.PeopleComponent;
import com.ciandt.people.task.ListPeopleEvent;
import com.ciandt.people.task.PeopleAsyncTask;
import com.ciandt.people.ui.PersonViewHolder;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import javax.inject.Inject;

import uk.co.ribot.easyadapter.EasyAdapter;

public class MainActivity extends AppCompatActivity {

    @Inject
    Bus bus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PeopleComponent g = ((App) getApplication()).graph();
        PeopleAsyncTask task = new PeopleAsyncTask(g);

        g.inject(this);

        bus.register(this);
        task.execute();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bus.unregister(this);
    }

    @Subscribe
    public void onListResult(ListPeopleEvent event) {
        ListView listView = (ListView) this.findViewById(R.id.listView);
        listView.setAdapter(new EasyAdapter<>(this, PersonViewHolder.class, event.getList()));
    }

}
