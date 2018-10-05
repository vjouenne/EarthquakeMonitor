package assignment.com.earthquakemonitor.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import assignment.com.earthquakemonitor.AppController;
import assignment.com.earthquakemonitor.Model.DataModel;
import assignment.com.earthquakemonitor.Model.FeatureModel;
import assignment.com.earthquakemonitor.Network.APIClient;
import assignment.com.earthquakemonitor.Network.Interface.APIInterface;
import assignment.com.earthquakemonitor.R;

public class SummaryRecyclerViewAdapter extends RecyclerView.Adapter<SummaryRecyclerViewAdapter.ViewHolder> {

    private ArrayList<FeatureModel> itemList;
    private Context context;
    private APIInterface apiInterface;

    public SummaryRecyclerViewAdapter(Context context, ArrayList<FeatureModel> itemList) {
        this.context = context;
        this.itemList = itemList;
        apiInterface = APIClient.getClient().create(APIInterface.class);
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_summary_list_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.tvPlace.setText(AppController.getString(itemList.get(position).getProperties().getPlace()));
        holder.tvMag.setText(AppController.getString(itemList.get(position).getProperties().getMag() + ""));

        Float mag= itemList.get(position).getProperties().getMag();

        if(mag!=null) {
            holder.clMain.setBackgroundColor(getMagColor(mag));
        }

    }

    private int getMagColor(Float mag) {

        int color= Color.parseColor("#ffffff");

        if(mag>=0.0 && mag<0.99) {
            color = Color.parseColor("#0CFF00");
        } else  if(mag>0.99 && mag<2.99) {
            color = Color.parseColor("#0FDC05");
        } else  if(mag>2.99 && mag<5.99) {
            color = Color.parseColor("#EEE818");
        } else  if(mag>5.99 && mag<8.99) {
            color = Color.parseColor("#F19F48");
        } else  if(mag>8.99) {
            color = Color.parseColor("#FF4D00");
        }

        return color;

    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ConstraintLayout clMain;
        public TextView tvPlace;
        public TextView tvMag;

        public ViewHolder(View itemView) {
            super(itemView);
            clMain = (ConstraintLayout) itemView.findViewById(R.id.clMain);
            tvPlace = (TextView) itemView.findViewById(R.id.tvPlace);
            tvMag = (TextView) itemView.findViewById(R.id.tvMag);

        }
    }
}
