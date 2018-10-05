package assignment.com.earthquakemonitor;

import android.Manifest;
import android.app.Activity;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AppController extends Application {

    public static final String BASE_URL = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/";
    public static final String API_BASE_URL = BASE_URL + "summary/";

    public static ProgressDialog progressDialog;

    public static final String INTENT_KEY_FEATURE_DATA = "featureData";
    public static final String INTENT_KEY_FEATURE_DATA_GEOMETRY = "featureDataGeometry";
    public static final String INTENT_KEY_FEATURE_DATA_PROPERTIES = "featureDataProperties";


    public static void checkPermissions(Activity activity) {

        ArrayList<String> arrPerm = new ArrayList<>();
        arrPerm.add(Manifest.permission.INTERNET);


        if (!arrPerm.isEmpty()) {
            String[] permissions = new String[arrPerm.size()];
            permissions = arrPerm.toArray(permissions);
            ActivityCompat.requestPermissions(activity, permissions, 1);
        }
    }

    public static boolean checkPermission(Activity activity, String permission) {
        int res = activity.checkCallingOrSelfPermission(permission);
        return (res == PackageManager.PERMISSION_GRANTED);
    }

    public static void showProgressDialog(Context context) {

        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        progressDialog.show();
    }

    public static void dismissProgressDialog() {
        progressDialog.dismiss();
    }

    public static String getString(String str) {
        if(str==null) {
            return "";
        }
        return str;
    }

    public static String getTime(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dateString = formatter.format(new Date(Long.parseLong(date)));
        return dateString;
    }

}
