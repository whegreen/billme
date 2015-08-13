package com.theprototypo.billme.util.api.chat;

import com.theprototypo.billme.util.api.BillMeResponseModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by walesadanto on 26/7/15.
 */
public class PutChatResponseModel extends BillMeResponseModel {

    private List<PutResponseData> data = new ArrayList<PutResponseData>();

    public List<PutResponseData> getData() {
        return data;
    }

    public void setData(List<PutResponseData> data) {
        this.data = data;
    }

    public class PutResponseData {

            private Integer contentId;
            private Integer contentChatId;
            private Integer contentUserId;
            private String contentValue;
            private String contentDate;
            private Integer contentStatus;
            private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

            public Map<String, Object> getAdditionalProperties() {
                return this.additionalProperties;
            }

            public void setAdditionalProperty(String name, Object value) {
                this.additionalProperties.put(name, value);
            }
    }

}
