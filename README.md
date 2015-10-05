# PeopleAndroid
Projeto de definição arquitetural para o Android. Contendo Dagger2, Otto, Retrofit, EasyAdapter, Lombok e outros frameworks agilizando o desenvolvimento na plataforma.

Para poder deixar funcionando, altere o arquivo que define a autenticação com seu usuário e senha CI&T. Deste jeito conseguirá logar e obter os dados do People :)


    @Singleton
    @Provides
    public String getBasicAuth() {
        return "Basic " + Base64.encodeToString(String.format("%s:%s", "MEU USUARIO", "MINHA SENHA").getBytes(),
                Base64.NO_WRAP);
    }
