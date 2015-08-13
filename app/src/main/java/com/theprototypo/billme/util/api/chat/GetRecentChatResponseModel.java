package com.theprototypo.billme.util.api.chat;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.theprototypo.billme.util.api.BillMeResponseModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by walesadanto on 27/7/15.
 */
public class GetRecentChatResponseModel extends BillMeResponseModel{

    private List<GetRecentResponseData> data = new ArrayList<GetRecentResponseData>();

    public List<GetRecentResponseData> getData() {
        return data;
    }

    public void setData(List<GetRecentResponseData> data) {
        this.data = data;
    }

    public class GetRecentResponseData {
        @SerializedName("chat_id")
        @Expose
        private Integer chatId;
        @SerializedName("chat_user_1")
        @Expose
        private Integer chatUser1;
        @SerializedName("chat_user_2")
        @Expose
        private Integer chatUser2;
        @SerializedName("chat_created_date")
        @Expose
        private String chatCreatedDate;
        @SerializedName("chat_updated_date")
        @Expose
        private String chatUpdatedDate;
        @SerializedName("chat_last_content")
        @Expose
        private String chatLastContent;
        @SerializedName("chat_read_status")
        @Expose
        private Integer chatReadStatus;
        @SerializedName("chat_url")
        @Expose
        private String chatUrl;
        @SerializedName("user_id")
        @Expose
        private Integer userId;
        @SerializedName("user_firstname")
        @Expose
        private String userFirstname;
        @SerializedName("user_lastname")
        @Expose
        private String userLastname;
        @SerializedName("ava_url")
        @Expose
        private String avaUrl;
        @SerializedName("balance")
        @Expose
        private String balance;

        /**
         * @return The chatId
         */
        public Integer getChatId() {
            return chatId;
        }

        /**
         * @param chatId The chat_id
         */
        public void setChatId(Integer chatId) {
            this.chatId = chatId;
        }

        /**
         * @return The chatUser1
         */
        public Integer getChatUser1() {
            return chatUser1;
        }

        /**
         * @param chatUser1 The chat_user_1
         */
        public void setChatUser1(Integer chatUser1) {
            this.chatUser1 = chatUser1;
        }

        /**
         * @return The chatUser2
         */
        public Integer getChatUser2() {
            return chatUser2;
        }

        /**
         * @param chatUser2 The chat_user_2
         */
        public void setChatUser2(Integer chatUser2) {
            this.chatUser2 = chatUser2;
        }

        /**
         * @return The chatCreatedDate
         */
        public String getChatCreatedDate() {
            return chatCreatedDate;
        }

        /**
         * @param chatCreatedDate The chat_created_date
         */
        public void setChatCreatedDate(String chatCreatedDate) {
            this.chatCreatedDate = chatCreatedDate;
        }

        /**
         * @return The chatUpdatedDate
         */
        public String getChatUpdatedDate() {
            return chatUpdatedDate;
        }

        /**
         * @param chatUpdatedDate The chat_updated_date
         */
        public void setChatUpdatedDate(String chatUpdatedDate) {
            this.chatUpdatedDate = chatUpdatedDate;
        }

        /**
         * @return The chatLastContent
         */
        public String getChatLastContent() {
            return chatLastContent;
        }

        /**
         * @param chatLastContent The chat_last_content
         */
        public void setChatLastContent(String chatLastContent) {
            this.chatLastContent = chatLastContent;
        }

        /**
         * @return The chatReadStatus
         */
        public Integer getChatReadStatus() {
            return chatReadStatus;
        }

        /**
         * @param chatReadStatus The chat_read_status
         */
        public void setChatReadStatus(Integer chatReadStatus) {
            this.chatReadStatus = chatReadStatus;
        }

        /**
         * @return The chatUrl
         */
        public String getChatUrl() {
            return chatUrl;
        }

        /**
         * @param chatUrl The chat_url
         */
        public void setChatUrl(String chatUrl) {
            this.chatUrl = chatUrl;
        }

        /**
         * @return The userId
         */
        public Integer getUserId() {
            return userId;
        }

        /**
         * @param userId The user_id
         */
        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        /**
         * @return The userFirstname
         */
        public String getUserFirstname() {
            return userFirstname;
        }

        /**
         * @param userFirstname The user_firstname
         */
        public void setUserFirstname(String userFirstname) {
            this.userFirstname = userFirstname;
        }

        /**
         * @return The userLastname
         */
        public String getUserLastname() {
            return userLastname;
        }

        /**
         * @param userLastname The user_lastname
         */
        public void setUserLastname(String userLastname) {
            this.userLastname = userLastname;
        }

        public String getAvaUrl() {
            return avaUrl;
        }

        public void setAvaUrl(String avaUrl) {
            this.avaUrl = avaUrl;
        }

        public String getBalance() {
            return balance;
        }

        public void setBalance(String balance) {
            this.balance = balance;
        }
    }

}
