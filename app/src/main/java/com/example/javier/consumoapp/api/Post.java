package com.example.javier.consumoapp.api;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by javier on 17/06/17.
 */

public class Post extends RealmObject {


    @SerializedName("userId")
    private Integer mUserId;

    @PrimaryKey
    @SerializedName("id")
    private Integer mId;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("body")
    private String mBody;

    public Integer getmUserId() {
        return mUserId;
    }

    public void setmUserId(Integer mUserId) {
        this.mUserId = mUserId;
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmBody() {
        return mBody;
    }

    public void setmBody(String mBody) {
        this.mBody = mBody;
    }

    @Override
    public String toString() {
        return "Post{" +
                "userId:"+ mUserId +
                "id:" + mId +
                "title:" + mTitle +
                "body:" + mBody +
                "}";
    }
}
