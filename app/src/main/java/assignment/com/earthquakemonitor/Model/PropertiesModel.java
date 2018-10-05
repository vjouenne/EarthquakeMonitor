package assignment.com.earthquakemonitor.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class PropertiesModel implements Parcelable{

    @SerializedName("mag")
    private Float mag;
    @SerializedName("place")
    private String place;
    @SerializedName("time")
    private String time;
    @SerializedName("updated")
    private String updated;
    @SerializedName("tz")
    private Integer tz;
    @SerializedName("url")
    private String url;
    @SerializedName("detail")
    private String detail;
    @SerializedName("felt")
    private String felt;
    @SerializedName("cdi")
    private String cdi;
    @SerializedName("mmi")
    private String mmi;
    @SerializedName("alert")
    private String alert;
    @SerializedName("status")
    private String status;
    @SerializedName("tsunami")
    private String tsunami;
    @SerializedName("sig")
    private String sig;
    @SerializedName("net")
    private String net;
    @SerializedName("code")
    private String code;
    @SerializedName("ids")
    private String ids;
    @SerializedName("sources")
    private String sources;
    @SerializedName("types")
    private String types;
    @SerializedName("nst")
    private String nst;
    @SerializedName("dmin")
    private String dmin;
    @SerializedName("rms")
    private String rms;
    @SerializedName("gap")
    private String gap;
    @SerializedName("magType")
    private String magType;
    @SerializedName("type")
    private String type;
    @SerializedName("title")
    private String title;

    public PropertiesModel() {

    }

    protected PropertiesModel(Parcel in) {
        if (in.readByte() == 0) {
            mag = null;
        } else {
            mag = in.readFloat();
        }
        place = in.readString();
        time = in.readString();
        updated = in.readString();
        if (in.readByte() == 0) {
            tz = null;
        } else {
            tz = in.readInt();
        }
        url = in.readString();
        detail = in.readString();
        felt = in.readString();
        cdi = in.readString();
        mmi = in.readString();
        alert = in.readString();
        status = in.readString();
        tsunami = in.readString();
        sig = in.readString();
        net = in.readString();
        code = in.readString();
        ids = in.readString();
        sources = in.readString();
        types = in.readString();
        nst = in.readString();
        dmin = in.readString();
        rms = in.readString();
        gap = in.readString();
        magType = in.readString();
        type = in.readString();
        title = in.readString();
    }

    public static final Creator<PropertiesModel> CREATOR = new Creator<PropertiesModel>() {
        @Override
        public PropertiesModel createFromParcel(Parcel in) {
            return new PropertiesModel(in);
        }

        @Override
        public PropertiesModel[] newArray(int size) {
            return new PropertiesModel[size];
        }
    };

    public Float getMag() {
        return mag;
    }

    public void setMag(Float mag) {
        this.mag = mag;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public Integer getTz() {
        return tz;
    }

    public void setTz(Integer tz) {
        this.tz = tz;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTsunami() {
        return tsunami;
    }

    public void setTsunami(String tsunami) {
        this.tsunami = tsunami;
    }

    public String getSig() {
        return sig;
    }

    public void setSig(String sig) {
        this.sig = sig;
    }

    public String getNet() {
        return net;
    }

    public void setNet(String net) {
        this.net = net;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getSources() {
        return sources;
    }

    public void setSources(String sources) {
        this.sources = sources;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getNst() {
        return nst;
    }

    public void setNst(String nst) {
        this.nst = nst;
    }

    public String getDmin() {
        return dmin;
    }

    public void setDmin(String dmin) {
        this.dmin = dmin;
    }

    public String getRms() {
        return rms;
    }

    public void setRms(String rms) {
        this.rms = rms;
    }

    public String getGap() {
        return gap;
    }

    public void setGap(String gap) {
        this.gap = gap;
    }

    public String getMagType() {
        return magType;
    }

    public void setMagType(String magType) {
        this.magType = magType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        if (mag == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeFloat(mag);
        }
        parcel.writeString(place);
        parcel.writeString(time);
        parcel.writeString(updated);
        if (tz == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(tz);
        }
        parcel.writeString(url);
        parcel.writeString(detail);
        parcel.writeString(felt);
        parcel.writeString(cdi);
        parcel.writeString(mmi);
        parcel.writeString(alert);
        parcel.writeString(status);
        parcel.writeString(tsunami);
        parcel.writeString(sig);
        parcel.writeString(net);
        parcel.writeString(code);
        parcel.writeString(ids);
        parcel.writeString(sources);
        parcel.writeString(types);
        parcel.writeString(nst);
        parcel.writeString(dmin);
        parcel.writeString(rms);
        parcel.writeString(gap);
        parcel.writeString(magType);
        parcel.writeString(type);
        parcel.writeString(title);
    }

}
