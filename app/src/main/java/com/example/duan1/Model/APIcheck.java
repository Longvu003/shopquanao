package com.example.duan1.Model;

import com.google.gson.annotations.SerializedName;

public class APIcheck {
        @SerializedName("success")
        private boolean success;

        @SerializedName("message")
        private String message;

        public boolean isSuccess() {
            return success;
        }

        public String getMessage() {
            return message;
        }


}
