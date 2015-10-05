package com.ciandt.people.ui;

import android.view.View;
import android.widget.TextView;

import com.ciandt.people.R;
import com.ciandt.people.entity.People;

import uk.co.ribot.easyadapter.ItemViewHolder;
import uk.co.ribot.easyadapter.PositionInfo;
import uk.co.ribot.easyadapter.annotations.LayoutId;
import uk.co.ribot.easyadapter.annotations.ViewId;

/**
 * Created by snoleto on 03/10/15.
 */
@LayoutId(R.layout.item)
public class PersonViewHolder extends ItemViewHolder<People> {

    @ViewId(R.id.person_name)
    TextView personName;

    @ViewId(R.id.role)
    TextView role;

    //Extend ItemViewHolder and call super(view)
    public PersonViewHolder(View view) {
        super(view);
    }

    //Override onSetValues() to set the values of the items in the views.
    @Override
    public void onSetValues(People person, PositionInfo positionInfo) {
        personName.setText(person.getName());
        role.setText(person.getRole());
    }
}
