package td95.quang.appmockup.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Quang_TD on 7/16/2017.
 */

public class News implements Parcelable {
    @SerializedName("Id")
    private int id;
    @SerializedName("Title")
    private String title;
    @SerializedName("CreatedDate")
    private Date date;
    @SerializedName("Body")
    private String body;
    @SerializedName("Avatar")
    private String Avatar;

    private long time;

    protected News(Parcel in) {
        id = in.readInt();
        title = in.readString();
        body = in.readString();
        Avatar = in.readString();
        time = in.readLong();
    }

    public static final Creator<News> CREATOR = new Creator<News>() {
        @Override
        public News createFromParcel(Parcel in) {
            return new News(in);
        }

        @Override
        public News[] newArray(int size) {
            return new News[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        if (date == null) date = new Date(time);
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String avatar) {
        Avatar = avatar;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override public int describeContents() {
        return 0;
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(body);
        dest.writeString(Avatar);
        dest.writeLong(time);
    }
}
