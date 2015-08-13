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

package com.theprototypo.billme.ui.chat;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.theprototypo.billme.R;
import com.theprototypo.billme.ui.chat.mvp.ChatView;
import com.theprototypo.billme.ui.chat.mvp.message.Message;

import java.util.List;

public class ChatDetailActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "user_name";
    public static final String EXTRA_AVATAR = "avatar_url";
    public static final String EXTRA_ID = "user_id";
    public static final String EXTRA_BALANCE = "balance";
    public String userId;
    public String balance;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        final String name = intent.getStringExtra(EXTRA_NAME);
        final String avatarUrl = intent.getStringExtra(EXTRA_AVATAR);
        userId = Integer.toString(intent.getIntExtra(EXTRA_ID, 0));
        balance = intent.getStringExtra(EXTRA_BALANCE);

        setContentView(R.layout.activity_detail);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(name);

        loadBackdrop(avatarUrl);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void loadBackdrop(String avatarUrl) {
        final ImageView imageView = (ImageView) findViewById(R.id.backdrop);
        Glide.with(this).load(avatarUrl).centerCrop().into(imageView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sample_actions, menu);
        return true;
    }

    public String getUserId() {
        return userId;
    }

    public String getBalance() {
        return balance;
    }
}
