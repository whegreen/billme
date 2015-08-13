package com.theprototypo.billme.ui.chat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.theprototypo.billme.R;
import com.theprototypo.billme.ui.chat.mvp.ChatPresenterImpl;
import com.theprototypo.billme.ui.chat.mvp.ChatView;
import com.theprototypo.billme.ui.chat.mvp.message.Message;
import com.theprototypo.billme.ui.main.chatlistfragment.ChatRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class ChatActivityFragment extends Fragment implements ChatView {

    public ChatPresenterImpl presenter;

    private static final int REQUEST_LOGIN = 0;

    private static final int TYPING_TIMER_LENGTH = 600;

    private RecyclerView mMessagesView;
    private EditText mInputMessageView;
    private List<Message> mMessages = new ArrayList<Message>();
    private RecyclerView.Adapter mAdapter;
    private boolean mTyping = false;
    private Handler mTypingHandler = new Handler();
//    private String mUsername;

    private ImageButton mBillButton;
    private ImageButton mSendButton;

    private String mCurrentMessage;

    private sendButtonState mSendButtonState = sendButtonState.BILL;

    public ChatActivityFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chat, container, false);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mAdapter = new MessageAdapter(activity, mMessages);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);

        presenter = new ChatPresenterImpl(this);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mMessagesView = (RecyclerView) view.findViewById(R.id.messages);
        mMessagesView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mMessagesView.setAdapter(mAdapter);

        mInputMessageView = (EditText) view.findViewById(R.id.message_input);
        mInputMessageView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int id, KeyEvent event) {
                if (id == R.id.send || id == EditorInfo.IME_NULL) {
                    // send from keyboard soft button
                    presenter.sendMessage(((ChatDetailActivity) getActivity()).getUserId(),
                            mInputMessageView.getText().toString(), mSendButtonState);
                    return true;
                }
                return false;
            }
        });

        mInputMessageView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!mTyping) {
                    mTyping = true;
                    presenter.typing();
                }

                mTypingHandler.removeCallbacks(onTypingTimeout);
                mTypingHandler.postDelayed(onTypingTimeout, TYPING_TIMER_LENGTH);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        mSendButton = (ImageButton) view.findViewById(R.id.send_button);
        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentMessage = mInputMessageView.getText().toString();
                if (mCurrentMessage != null || mCurrentMessage != "") {
                    presenter.sendMessage(((ChatDetailActivity)getActivity()).getUserId(),
                            mCurrentMessage, mSendButtonState);
                } else {

                }
            }
        });

        mBillButton = (ImageButton) view.findViewById(R.id.bill_button);
        mBillButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                presenter.
            }
        });

        presenter.loadChat(((ChatDetailActivity)getActivity()).getUserId());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (Activity.RESULT_OK != resultCode) {
            getActivity().finish();
            return;
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_leave) {
//            leave();
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    private void scrollToBottom() {
        mMessagesView.scrollToPosition(mAdapter.getItemCount() - 1);
    }

    private Runnable onTypingTimeout = new Runnable() {
        @Override
        public void run() {
            if (!mTyping) return;
            mTyping = false;
            presenter.typingTimeout();
        }
    };

    // view implementation

    @Override
    public void loadChat(List<Message> list) {
        mMessages = list;
        ((MessageAdapter)mAdapter).setmMessages(mMessages);
        mAdapter.notifyDataSetChanged();
        scrollToBottom();
    }

    @Override
    public void reloadChat() {
        presenter.loadChat(((ChatDetailActivity)getActivity()).getUserId());
    }

    @Override
    public void closeDetailScreen() {

    }

    @Override
    public void showSnackBar() {

    }

    @Override
    public void showToast(String alert) {
        Toast.makeText(getActivity(), alert, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showBlankTextWarning() {

    }

    @Override
    public void showSendBillButton() {

    }

    @Override
    public void showSendMessageButton() {

    }

    @Override
    public void toggleSendButton() {
        String temp = mInputMessageView.getText().toString();
        if (temp.equals("")){
            mSendButton.setVisibility(View.GONE);
            mBillButton.setVisibility(View.VISIBLE);
            mSendButtonState = sendButtonState.BILL;
        }else{
            mSendButton.setVisibility(View.VISIBLE);
            mBillButton.setVisibility(View.GONE);
            mSendButtonState = sendButtonState.MESSAGE;
        }
    }

    @Override
    public void resetInputField() {
        mInputMessageView.setText("");
        enableInputField();
        toggleSendButton();
    }

    @Override
    public void disableInputField() {
        mInputMessageView.setEnabled(false);
    }

    @Override
    public void enableInputField() {
        mInputMessageView.setEnabled(true);
    }
}
