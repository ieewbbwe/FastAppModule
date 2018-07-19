package com.mobile_core.base.bean.personal;

import android.os.Parcel;
import android.os.Parcelable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;


/**
 * Created by picher on 2018/7/19.
 * Describe：
 */
@Entity
public class TokenModel implements Parcelable {

    @Id(autoincrement = true)
    private Long tid;

    @Property
    private String token;
    @Property
    private long timestamp;



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.tid);
        dest.writeString(this.token);
        dest.writeLong(this.timestamp);
    }

    public Long getTid() {
        return this.tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public TokenModel() {
    }

    protected TokenModel(Parcel in) {
        this.tid = (Long) in.readValue(Long.class.getClassLoader());
        this.token = in.readString();
        this.timestamp = in.readLong();
    }

    @Generated(hash = 1888302132)
    public TokenModel(Long tid, String token, long timestamp) {
        this.tid = tid;
        this.token = token;
        this.timestamp = timestamp;
    }

    public static final Creator<TokenModel> CREATOR = new Creator<TokenModel>() {
        @Override
        public TokenModel createFromParcel(Parcel source) {
            return new TokenModel(source);
        }

        @Override
        public TokenModel[] newArray(int size) {
            return new TokenModel[size];
        }
    };
}

