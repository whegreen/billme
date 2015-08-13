package com.theprototypo.billme.util.api.user;

import com.theprototypo.billme.util.api.BillMeResponseModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by walesadanto on 26/7/15.
 */
public class GetUserResponseModel extends BillMeResponseModel {

    private List<GetUserResponseData> data = new ArrayList<GetUserResponseData>();

    public List<GetUserResponseData> getData() {
        return data;
    }

    public void setData(List<GetUserResponseData> data) {
        this.data = data;
    }

    public class GetUserResponseData{
        private Integer userId;
        private String firstName;
        private String lastName;
        private Object avaUrl;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         *
         * @return
         * The userId
         */
        public Integer getUserId() {
            return userId;
        }

        /**
         *
         * @param userId
         * The user_id
         */
        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        /**
         *
         * @return
         * The firstName
         */
        public String getFirstName() {
            return firstName;
        }

        /**
         *
         * @param firstName
         * The first_name
         */
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        /**
         *
         * @return
         * The lastName
         */
        public String getLastName() {
            return lastName;
        }

        /**
         *
         * @param lastName
         * The last_name
         */
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        /**
         *
         * @return
         * The avaUrl
         */
        public Object getAvaUrl() {
            return avaUrl;
        }

        /**
         *
         * @param avaUrl
         * The ava_url
         */
        public void setAvaUrl(Object avaUrl) {
            this.avaUrl = avaUrl;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }
    }
}
