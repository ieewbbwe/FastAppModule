package com.mobile_core.base.bean.personal;

import android.os.Parcel;
import android.os.Parcelable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

/**
 * Created by picher on 2018/7/19.
 * Describe：
 */
@Entity(nameInDb = "profile_tb")
public class ProfileModel implements Parcelable {

    @Id(autoincrement = true)
    private Long uid;

    private Long tid;
    @ToOne(joinProperty = "tid")
    private TokenModel token;
    @Property
    private String accountId;
    @Property
    private String imageUrl;
    @Property
    private String displayName;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 476315025)
    private transient ProfileModelDao myDao;


    @Generated(hash = 1626972281)
    public ProfileModel(Long uid, Long tid, String accountId, String imageUrl,
            String displayName) {
        this.uid = uid;
        this.tid = tid;
        this.accountId = accountId;
        this.imageUrl = imageUrl;
        this.displayName = displayName;
    }

    @Generated(hash = 607837135)
    public ProfileModel() {
    }

    @Generated(hash = 2059307683)
    private transient Long token__resolvedKey;


    public Long getUid() {
        return this.uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getTid() {
        return this.tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 175313468)
    public TokenModel getToken() {
        Long __key = this.tid;
        if (token__resolvedKey == null || !token__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TokenModelDao targetDao = daoSession.getTokenModelDao();
            TokenModel tokenNew = targetDao.load(__key);
            synchronized (this) {
                token = tokenNew;
                token__resolvedKey = __key;
            }
        }
        return token;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 2022154280)
    public void setToken(TokenModel token) {
        synchronized (this) {
            this.token = token;
            tid = token == null ? null : token.getTid();
            token__resolvedKey = tid;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.uid);
        dest.writeValue(this.tid);
        dest.writeParcelable(this.token, flags);
        dest.writeString(this.accountId);
        dest.writeString(this.imageUrl);
        dest.writeString(this.displayName);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1634764816)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getProfileModelDao() : null;
    }

    protected ProfileModel(Parcel in) {
        this.uid = (Long) in.readValue(Long.class.getClassLoader());
        this.tid = (Long) in.readValue(Long.class.getClassLoader());
        this.token = in.readParcelable(TokenModel.class.getClassLoader());
        this.accountId = in.readString();
        this.imageUrl = in.readString();
        this.displayName = in.readString();
    }

    public static final Creator<ProfileModel> CREATOR = new Creator<ProfileModel>() {
        @Override
        public ProfileModel createFromParcel(Parcel source) {
            return new ProfileModel(source);
        }

        @Override
        public ProfileModel[] newArray(int size) {
            return new ProfileModel[size];
        }
    };
}
