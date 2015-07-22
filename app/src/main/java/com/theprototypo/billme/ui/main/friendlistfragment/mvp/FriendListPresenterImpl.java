package com.theprototypo.billme.ui.main.friendlistfragment.mvp;

/**
 * Created by walesadanto on 15/7/15.
 */
public class FriendListPresenterImpl implements FriendListPresenter{

    private FriendListInteractor interactor;
    private FriendListView view;

    public FriendListPresenterImpl(FriendListView view){
        this.view = view;
        this.interactor = new FriendListInteractorImpl();
    }


}
