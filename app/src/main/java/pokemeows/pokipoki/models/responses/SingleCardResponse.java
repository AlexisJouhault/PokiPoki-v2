package pokemeows.pokipoki.models.responses;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import pokemeows.pokipoki.models.Card;

/**
 * Created by Toshiba on 9/11/2016.
 */

public class SingleCardResponse implements Parcelable {

    @SerializedName("card") private Card card;

    protected SingleCardResponse(Parcel in) {
        card = in.readParcelable(Card.class.getClassLoader());
    }

    public static final Creator<SingleCardResponse> CREATOR = new Creator<SingleCardResponse>() {
        @Override
        public SingleCardResponse createFromParcel(Parcel in) {
            return new SingleCardResponse(in);
        }

        @Override
        public SingleCardResponse[] newArray(int size) {
            return new SingleCardResponse[size];
        }
    };

    public Card getCard() {
        return card;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(card, flags);
    }
}
