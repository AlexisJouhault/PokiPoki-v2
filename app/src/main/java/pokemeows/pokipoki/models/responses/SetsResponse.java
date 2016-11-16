package pokemeows.pokipoki.models.responses;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import pokemeows.pokipoki.models.CardSet;

/**
 * Created by Toshiba on 9/11/2016.
 */

public class SetsResponse implements Parcelable {

    @SerializedName("setList") private List<CardSet> setList;

    protected SetsResponse(Parcel in) {
        setList = in.createTypedArrayList(CardSet.CREATOR);
    }

    public static final Creator<SetsResponse> CREATOR = new Creator<SetsResponse>() {
        @Override
        public SetsResponse createFromParcel(Parcel in) {
            return new SetsResponse(in);
        }

        @Override
        public SetsResponse[] newArray(int size) {
            return new SetsResponse[size];
        }
    };

    public List<CardSet> getSetList() {
        return setList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(setList);
    }
}
