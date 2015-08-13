package com.theprototypo.billme.ui.chat;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.theprototypo.billme.R;
import com.theprototypo.billme.ui.chat.mvp.message.Message;

import java.util.List;

/**
 * Created by walesadanto on 25/6/15.
 */
public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {

    private List<com.theprototypo.billme.ui.chat.mvp.message.Message> mMessages;
    private int[] mUsernameColors;

    public MessageAdapter(Context context, List<com.theprototypo.billme.ui.chat.mvp.message.Message> messages) {
        mMessages = messages;
        mUsernameColors = context.getResources().getIntArray(R.array.username_colors);
    }

    public void setmMessages(List<Message> mMessages) {
        this.mMessages = mMessages;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layout = -1;
        switch (viewType) {
            case com.theprototypo.billme.ui.chat.mvp.message.Message.TYPE_MESSAGE:
                layout = R.layout.chat_item_message;
                break;
            case Message.TYPE_LOG:
                layout = R.layout.chat_item_log;
                break;
            case Message.TYPE_ACTION:
                layout = R.layout.chat_item_action;
                break;
        }
        View v = LayoutInflater
                .from(parent.getContext())
                .inflate(layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Message message = mMessages.get(position);
        viewHolder.setMessage(message.getMessage());
        viewHolder.setUsername(message.getUsername());
    }

    @Override
    public int getItemCount() {
        return mMessages.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mMessages.get(position).getType();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mUsernameView;
        private TextView mMessageView;

        public ViewHolder(View itemView) {
            super(itemView);

            mUsernameView = (TextView) itemView.findViewById(R.id.username);
            mMessageView = (TextView) itemView.findViewById(R.id.message);
        }

        public void setUsername(String username) {
            if (null == mUsernameView) return;
            mUsernameView.setText(username);
            mUsernameView.setTextColor(getUsernameColor(username));
        }

        public void setMessage(String message) {
            if (null == mMessageView) return;
            mMessageView.setText(message);
        }

        private int getUsernameColor(String username) {
            int hash = 7;
            for (int i = 0, len = username.length(); i < len; i++) {
                hash = username.codePointAt(i) + (hash << 5) - hash;
            }
            int index = Math.abs(hash % mUsernameColors.length);
            return mUsernameColors[index];
        }
    }
}
