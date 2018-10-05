package assignment.com.earthquakemonitor.Model;

import com.google.gson.annotations.SerializedName;

public class MetadataModel {

    @SerializedName("generated")
    private String generated;
    @SerializedName("url")
    private String url;
    @SerializedName("title")
    private String title;
    @SerializedName("status")
    private Integer status;
    @SerializedName("api")
    private String api;
    @SerializedName("count")
    private Integer count;

    public String getGenerated() {
        return generated;
    }

    public void setGenerated(String generated) {
        this.generated = generated;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public int getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
