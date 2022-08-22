package com.neotica.mvpdemo;

//This will act as a Presenter (Waiter)
public class Presenter {

    //The link between the presenter and the view(MainActivity) is done by Interface

    //link instance
    AppView appView;

    public Presenter(AppView appView) {
        this.appView = appView;
    }

    //linkage between presenter and model
    public Model GetAppFromModel(){

        return new Model("Demo App",999,5);
    }

    //3. Linkage between presenter and MainActivity (Calling the interface)
    public void GetAppDetail(){
        appView.onGetAppName(/*Passing here the result from Model*/ GetAppFromModel().appName);
    }

}