package assignment.com.earthquakemonitor.Network.Interface;

import java.util.List;

import assignment.com.earthquakemonitor.Model.DataModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {
    @GET("all_hour.geojson")
    Call<DataModel> getData();
}
