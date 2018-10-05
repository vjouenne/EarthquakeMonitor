package assignment.com.earthquakemonitor.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class FeatureModel implements Parcelable{

    @SerializedName("id")
    private String id;
    @SerializedName("type")
    private String type;
    @SerializedName("properties")
    private PropertiesModel properties;
    @SerializedName("geometry")
    private GeometryModel geometry;

    public FeatureModel() {

    }

    protected FeatureModel(Parcel in) {
        id = in.readString();
        type = in.readString();
    }

    public static final Creator<FeatureModel> CREATOR = new Creator<FeatureModel>() {
        @Override
        public FeatureModel createFromParcel(Parcel in) {
            return new FeatureModel(in);
        }

        @Override
        public FeatureModel[] newArray(int size) {
            return new FeatureModel[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PropertiesModel getProperties() {
        return properties;
    }

    public void setProperties(PropertiesModel properties) {
        this.properties = properties;
    }

    public GeometryModel getGeometry() {
        return geometry;
    }

    public void setGeometry(GeometryModel geometry) {
        this.geometry = geometry;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(type);
    }
}
