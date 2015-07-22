/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.theprototypo.billme.ui.main.friendlistfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.theprototypo.billme.R;
import com.theprototypo.billme.ui.main.SimpleStringRecyclerViewAdapter;
import com.theprototypo.billme.ui.main.friendlistfragment.mvp.FriendListInteractorImpl;
import com.theprototypo.billme.ui.main.friendlistfragment.mvp.FriendListPresenter;
import com.theprototypo.billme.ui.main.friendlistfragment.mvp.FriendListPresenterImpl;
import com.theprototypo.billme.ui.main.friendlistfragment.mvp.FriendListView;
import com.theprototypo.billme.util.api.APICallListener;
import com.theprototypo.billme.util.common.MockAPI;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class FriendListFragment extends Fragment implements APICallListener, FriendListView {

    List<Friend> friendList = new ArrayList<>();

    private FriendListPresenter presenter;

    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        recyclerView = (RecyclerView) inflater.inflate(
                R.layout.fragment_friend_list, container, false);
        setupRecyclerView();
        getFriendList();
        return recyclerView;
    }

    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(new SimpleStringRecyclerViewAdapter(getActivity(), friendList));
    }

    private List<String> getRandomSublist(String[] array, int amount) {
        ArrayList<String> list = new ArrayList<>(amount);
        Random random = new Random();
        while (list.size() < amount) {
            list.add(array[random.nextInt(array.length)]);
        }
        return list;
    }

    private void getFriendList(){

        MockAPI.callMockAPI(getActivity().getBaseContext(), "chats/getRecentChatList", new Callback<Object>() {
            @Override
            public void success(Object o, Response response) {
//                JsonArray array = ((JSONObject)o).get("data").getAsJsonArray();
                JsonArray array = (JsonArray) o;
                Gson gson = new Gson();
                Type listType = new TypeToken<List<Friend>>() {}.getType();
                friendList= gson.fromJson(array.toString(), listType);

                setupRecyclerView();
                onAPICallSucceed();
            }

            @Override
            public void failure(RetrofitError error) {
                onAPICallFailed();
            }
        });

//        APICallManager.getInstance().getFriends(new Callback<JsonObject>() {
//            @Override
//            public void success(JsonObject jsonObject, Response response) {
//                JsonArray array = jsonObject.get("data").getAsJsonArray();
//                Gson gson = new Gson();
//
//                Type listType = new TypeToken<List<Friend>>() {}.getType();
//
//                friendList= gson.fromJson(array.toString(), listType);
//
//                setupRecyclerView();
//                onAPICallSucceed();
//            }
//
//            @Override
//            public void failure(RetrofitError error) {
//                onAPICallFailed();
//            }
//        });

    }

    @Override
    public void onAPICallSucceed() {

    }

    @Override
    public void onAPICallFailed() {

    }
}
