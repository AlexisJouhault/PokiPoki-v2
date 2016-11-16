package pokemeows.pokipoki.models.responses;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import pokemeows.pokipoki.models.Card;

/**
 * Created by Toshiba on 9/11/2016.
 */

public class CardsResponse implements Parcelable {

    @SerializedName("cardList") List<Card> cardList;

    protected CardsResponse(Parcel in) {
        cardList = in.createTypedArrayList(Card.CREATOR);
    }

    public static final Creator<CardsResponse> CREATOR = new Creator<CardsResponse>() {
        @Override
        public CardsResponse createFromParcel(Parcel in) {
            return new CardsResponse(in);
        }

        @Override
        public CardsResponse[] newArray(int size) {
            return new CardsResponse[size];
        }
    };

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(cardList);
    }
}