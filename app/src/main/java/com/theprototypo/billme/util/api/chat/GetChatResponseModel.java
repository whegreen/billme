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
public class GetChatResponseModel extends BillMeResponseModel {

    private List<GetResponseData> data = new ArrayList<GetResponseData>();

    public List<GetResponseData> getData() {
        return data;
    }

    public void setData(List<GetResponseData> data) {
        this.data = data;
    }

    public class GetResponseData {

        @SerializedName("content_id")
        @Expose
        private Integer contentId;
        @SerializedName("content_chat_id")
        @Expose
        private Integer contentChatId;
        @SerializedName("content_user_id")
        @Expose
        private Integer contentUserId;
        @SerializedName("content_value")
        @Expose
        private String contentValue;
        @SerializedName("content_date")
        @Expose
        private String contentDate;
        @SerializedName("content_status")
        @Expose
        private Integer contentStatus;
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

        /**
         *
         * @return
         * The contentId
         */
        public Integer getContentId() {
            return contentId;
        }

        /**
         *
         * @param contentId
         * The content_id
         */
        public void setContentId(Integer contentId) {
            this.contentId = contentId;
        }

        /**
         *
         * @return
         * The contentChatId
         */
        public Integer getContentChatId() {
            return contentChatId;
        }

        /**
         *
         * @param contentChatId
         * The content_chat_id
         */
        public void setContentChatId(Integer contentChatId) {
            this.contentChatId = contentChatId;
        }

        /**
         *
         * @return
         * The contentUserId
         */
        public Integer getContentUserId() {
            return contentUserId;
        }

        /**
         *
         * @param contentUserId
         * The content_user_id
         */
        public void setContentUserId(Integer contentUserId) {
            this.contentUserId = contentUserId;
        }

        /**
         *
         * @return
         * The contentValue
         */
        public String getContentValue() {
            return contentValue;
        }

        /**
         *
         * @param contentValue
         * The content_value
         */
        public void setContentValue(String contentValue) {
            this.contentValue = contentValue;
        }

        /**
         *
         * @return
         * The contentDate
         */
        public String getContentDate() {
            return contentDate;
        }

        /**
         *
         * @param contentDate
         * The content_date
         */
        public void setContentDate(String contentDate) {
            this.contentDate = contentDate;
        }

        /**
         *
         * @return
         * The contentStatus
         */
        public Integer getContentStatus() {
            return contentStatus;
        }

        /**
         *
         * @param contentStatus
         * The content_status
         */
        public void setContentStatus(Integer contentStatus) {
            this.contentStatus = contentStatus;
        }

        /**
         *
         * @return
         * The chatId
         */
        public Integer getChatId() {
            return chatId;
        }

        /**
         *
         * @param chatId
         * The chat_id
         */
        public void setChatId(Integer chatId) {
            this.chatId = chatId;
        }

        /**
         *
         * @return
         * The chatUser1
         */
        public Integer getChatUser1() {
            return chatUser1;
        }

        /**
         *
         * @param chatUser1
         * The chat_user_1
         */
        public void setChatUser1(Integer chatUser1) {
            this.chatUser1 = chatUser1;
        }

        /**
         *
         * @return
         * The chatUser2
         */
        public Integer getChatUser2() {
            return chatUser2;
        }

        /**
         *
         * @param chatUser2
         * The chat_user_2
         */
        public void setChatUser2(Integer chatUser2) {
            this.chatUser2 = chatUser2;
        }

        /**
         *
         * @return
         * The chatCreatedDate
         */
        public String getChatCreatedDate() {
            return chatCreatedDate;
        }

        /**
         *
         * @param chatCreatedDate
         * The chat_created_date
         */
        public void setChatCreatedDate(String chatCreatedDate) {
            this.chatCreatedDate = chatCreatedDate;
        }

        /**
         *
         * @return
         * The chatUpdatedDate
         */
        public String getChatUpdatedDate() {
            return chatUpdatedDate;
        }

        /**
         *
         * @param chatUpdatedDate
         * The chat_updated_date
         */
        public void setChatUpdatedDate(String chatUpdatedDate) {
            this.chatUpdatedDate = chatUpdatedDate;
        }

        /**
         *
         * @return
         * The chatLastContent
         */
        public String getChatLastContent() {
            return chatLastContent;
        }

        /**
         *
         * @param chatLastContent
         * The chat_last_content
         */
        public void setChatLastContent(String chatLastContent) {
            this.chatLastContent = chatLastContent;
        }

        /**
         *
         * @return
         * The chatReadStatus
         */
        public Integer getChatReadStatus() {
            return chatReadStatus;
        }

        /**
         *
         * @param chatReadStatus
         * The chat_read_status
         */
        public void setChatReadStatus(Integer chatReadStatus) {
            this.chatReadStatus = chatReadStatus;
        }

        /**
         *
         * @return
         * The chatUrl
         */
        public String getChatUrl() {
            return chatUrl;
        }

        /**
         *
         * @param chatUrl
         * The chat_url
         */
        public void setChatUrl(String chatUrl) {
            this.chatUrl = chatUrl;
        }

    }
}
