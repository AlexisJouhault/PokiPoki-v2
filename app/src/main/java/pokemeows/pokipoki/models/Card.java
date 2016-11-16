package pokemeows.pokipoki.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Toshiba on 9/11/2016.
 */

public class Card implements Comparable<Card>, Parcelable {

    @SerializedName("name") private String name;
    @SerializedName("id") private String id;
    @SerializedName("imageUrl") private String imageUrl;
    @SerializedName("number") private String number;

    protected Card(Parcel in) {
        name = in.readString();
        id = in.readString();
        imageUrl = in.readString();
        number = in.readString();
    }

    public static final Creator<Card> CREATOR = new Creator<Card>() {
        @Override
        public Card createFromParcel(Parcel in) {
            return new Card(in);
        }

        @Override
        public Card[] newArray(int size) {
            return new Card[size];
        }
    };

    public String getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(id);
        dest.writeString(imageUrl);
        dest.writeString(number);
    }

    @Override
    public int compareTo(@NonNull Card another) {
        int myNumber = getNumberFromString(this.getNumber().toCharArray());
        int anotherNumber = getNumberFromString(another.getNumber().toCharArray());
        if (myNumber < anotherNumber) {
            return -1;
        } else if (myNumber > anotherNumber) {
            return 1;
        }
        return 0;
    }

    private int getNumberFromString(char[] string) {
        int endCut;
        int startCut = -1;

        for (endCut = 0; endCut < string.length; endCut++) {
            if (string[endCut] >= '0' && string[endCut] <= '9') {
                if (startCut == -1) {
                    startCut = endCut;
                }
            } else if (startCut != -1) {
                break;
            }
        }
        int outOfSet = 0;
        if (startCut != 0) {
            outOfSet = 1000;
        }
        String numberString = new String(string);
        numberString = numberString.substring(startCut, endCut);
        return Integer.parseInt(numberString) + outOfSet;
    }
}
