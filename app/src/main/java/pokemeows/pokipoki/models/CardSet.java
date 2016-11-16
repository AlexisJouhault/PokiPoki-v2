package pokemeows.pokipoki.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Toshiba on 9/11/2016.
 */

public class CardSet implements Parcelable {

    @SerializedName("code") private String code;
    @SerializedName("name") private String name;
    @SerializedName("series") private String series;
    @SerializedName("totalCards") private int totalCards;
    @SerializedName("standardLegal") private boolean standardLegal;
    @SerializedName("releaseDate") private String releaseDate;

    protected CardSet(Parcel in) {
        code = in.readString();
        name = in.readString();
        series = in.readString();
        totalCards = in.readInt();
        standardLegal = in.readByte() != 0;
        releaseDate = in.readString();
    }

    public static final Creator<CardSet> CREATOR = new Creator<CardSet>() {
        @Override
        public CardSet createFromParcel(Parcel in) {
            return new CardSet(in);
        }

        @Override
        public CardSet[] newArray(int size) {
            return new CardSet[size];
        }
    };

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getSeries() {
        return series;
    }

    public boolean isStandardLegal() {
        return standardLegal;
    }

    public int getTotalCards() {
        return totalCards;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(code);
        dest.writeString(name);
        dest.writeString(series);
        dest.writeInt(totalCards);
        dest.writeByte((byte) (standardLegal ? 1 : 0));
        dest.writeString(releaseDate);
    }
}
