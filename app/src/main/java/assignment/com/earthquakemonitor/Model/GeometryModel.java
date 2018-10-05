package assignment.com.earthquakemonitor.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GeometryModel implements Parcelable{

    @SerializedName("type")
    private String type;
    @SerializedName("coordinates")
    private ArrayList<String> coordinates;
    @SerializedName("id")
    private String id;

    public GeometryModel() {

    }

    protected GeometryModel(Parcel in) {
        type = in.readString();
        coordinates = in.createStringArrayList();
        id = in.readString();
    }

    public static final Creator<GeometryModel> CREATOR = new Creator<GeometryModel>() {
        @Override
        public GeometryModel createFromParcel(Parcel in) {
            return new GeometryModel(in);
        }

        @Override
        public GeometryModel[] newArray(int size) {
            return new GeometryModel[size];
        }
    };

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<String> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(ArrayList<String> coordinates) {
        this.coordinates = coordinates;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(type);
        parcel.writeStringList(coordinates);
        parcel.writeString(id);
    }
}
