package assignment.com.earthquakemonitor.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DataModel {

    @SerializedName("type")
    private String type;
    @SerializedName("metadata")
    private MetadataModel metadata;
    @SerializedName("features")
    private ArrayList<FeatureModel> features;
    @SerializedName("bbox")
    private ArrayList<String> bBox;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MetadataModel getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataModel metadata) {
        this.metadata = metadata;
    }

    public ArrayList<FeatureModel> getFeatures() {
        return features;
    }

    public void setFeatures(ArrayList<FeatureModel> features) {
        this.features = features;
    }

    public ArrayList<String> getbBox() {
        return bBox;
    }

    public void setbBox(ArrayList<String> bBox) {
        this.bBox = bBox;
    }
}
