package com.theprototypo.billme.main.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.theprototypo.billme.R;
import com.theprototypo.billme.detail.ChatDetailActivity;
import com.theprototypo.billme.main.mvp.Friend;

import java.util.List;

/**
 * Created by walesadanto on 2/7/15.
 */
public class SimpleStringRecyclerViewAdapter extends RecyclerView.Adapter<SimpleStringRecyclerViewAdapter.ViewHolder> {

    private final TypedValue mTypedValue = new TypedValue();
    private int mBackground;
    private List<Friend> mFriends;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // TODO : refactor to friend class
        public String mBoundString;
        public String mBoundAvatar;

        public final View mView;
        public final ImageView mImageView;
        public final TextView mTextView;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mImageView = (ImageView) view.findViewById(R.id.avatar);
            mTextView = (TextView) view.findViewById(android.R.id.text1);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTextView.getText();
        }
    }

    public Friend getValueAt(int position) {
        return mFriends.get(position);
    }

    public SimpleStringRecyclerViewAdapter(Context context, List<Friend> friends) {
        context.getTheme().resolveAttribute(R.attr.selectableItemBackground, mTypedValue, true);
        mBackground = mTypedValue.resourceId;
        mFriends = friends;
    }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item, parent, false);
            view.setBackgroundResource(mBackground);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mBoundString = mFriends.get(position).getName();
            holder.mBoundAvatar= mFriends.get(position).getAvatar_url();
            holder.mTextView.setText(mFriends.get(position).getName());

            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, ChatDetailActivity.class);
                    intent.putExtra(ChatDetailActivity.EXTRA_NAME, holder.mBoundString);
                    intent.putExtra(ChatDetailActivity.EXTRA_AVATAR, holder.mBoundAvatar);

                    context.startActivity(intent);
                }
            });

            Glide.with(holder.mImageView.getContext())
                    .load(mFriends.get(position).getAvatar_url())
                    .fitCenter()
                    .into(holder.mImageView);
        }

        @Override
        public int getItemCount() {
            return mFriends.size();
        }
    }

