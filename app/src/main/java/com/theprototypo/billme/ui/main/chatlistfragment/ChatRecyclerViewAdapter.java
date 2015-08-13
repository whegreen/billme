package com.theprototypo.billme.ui.main.chatlistfragment;

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
import com.theprototypo.billme.ui.chat.ChatDetailActivity;
import com.theprototypo.billme.util.api.chat.GetRecentChatResponseModel;

import java.util.List;

/**
 * Created by walesadanto on 26/7/15.
 */
public class ChatRecyclerViewAdapter extends RecyclerView.Adapter<ChatRecyclerViewAdapter.ChatViewHolder> {

    private final TypedValue mTypedValue = new TypedValue();
    private int mBackground;
    private List<GetRecentChatResponseModel.GetRecentResponseData> mChats;

    public GetRecentChatResponseModel.GetRecentResponseData getValueAt(int position){
        return mChats.get(position);
    }

    public ChatRecyclerViewAdapter(Context context, List<GetRecentChatResponseModel.GetRecentResponseData> chats){
        context.getTheme().resolveAttribute(android.support.design.R.attr.selectableItemBackground, mTypedValue, true);
        mBackground = mTypedValue.resourceId;
        mChats = chats;
    }

    @Override
    public ChatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        view.setBackgroundResource(mBackground);
        return new ChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ChatViewHolder holder, int position) {

        holder.mTextView.setText(mChats.get(position).getUserFirstname()
                +" "+ mChats.get(position).getUserLastname());
        holder.mTextView2.setText(mChats.get(position).getBalance());
        holder.mBoundAvatar = mChats.get(position).getAvaUrl();
        holder.mBoundUserId = mChats.get(position).getChatUser2();

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, ChatDetailActivity.class);
                intent.putExtra(ChatDetailActivity.EXTRA_NAME, holder.mTextView.getText());
                intent.putExtra(ChatDetailActivity.EXTRA_AVATAR, holder.mBoundAvatar);
                intent.putExtra(ChatDetailActivity.EXTRA_BALANCE, holder.mTextView2.getText());
                intent.putExtra(ChatDetailActivity.EXTRA_ID, holder.mBoundUserId);

                context.startActivity(intent);
            }
        });

        Glide.with(holder.mImageView.getContext())
                .load(mChats.get(position).getAvaUrl())
                .fitCenter()
                .into(holder.mImageView);

    }

    @Override
    public int getItemCount() {
        return mChats.size();
    }


    public static class ChatViewHolder extends RecyclerView.ViewHolder{

        // todo : put some field to be viewed here
        public String text;
        public String mBoundAvatar;
        public int mBoundUserId;

        public final View mView;
        public final ImageView mImageView;
        public final TextView mTextView;
        public final TextView mTextView2;

        public ChatViewHolder(View itemView) {
            super(itemView);
            // todo : do some mapping data here
            mView = itemView;
            mImageView = (ImageView) itemView.findViewById(R.id.avatar);
            mTextView = (TextView) itemView.findViewById(android.R.id.text1);
            mTextView2 = (TextView) itemView.findViewById(android.R.id.text2);
        }
    }
}
