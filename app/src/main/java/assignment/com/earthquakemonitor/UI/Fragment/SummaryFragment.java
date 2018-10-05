package assignment.com.earthquakemonitor.UI.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import assignment.com.earthquakemonitor.Adapter.RecyclerItemClickListener;
import assignment.com.earthquakemonitor.Adapter.SummaryRecyclerViewAdapter;
import assignment.com.earthquakemonitor.AppController;
import assignment.com.earthquakemonitor.Model.DataModel;
import assignment.com.earthquakemonitor.Model.FeatureModel;
import assignment.com.earthquakemonitor.Network.APIClient;
import assignment.com.earthquakemonitor.Network.Interface.APIInterface;
import assignment.com.earthquakemonitor.R;
import assignment.com.earthquakemonitor.UI.Activity.DetailsActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SummaryFragment extends Fragment {

    private RecyclerView rvSummary;
    private ArrayList<FeatureModel> featureModelItems;
    private DataModel dataModel;
    private SummaryRecyclerViewAdapter summaryRecyclerViewAdapter;
    private SwipeRefreshLayout swipeView;

    private APIInterface apiInterface;

    public static SummaryFragment getInstance() {
        SummaryFragment fragment = new SummaryFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_summary, container, false);

        apiInterface = APIClient.getClient().create(APIInterface.class);

        swipeView = (SwipeRefreshLayout) view.findViewById(R.id.swiperefresh);

        swipeView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                                           @Override
                                           public void onRefresh() {
                                               swipeView.setRefreshing(true);
                                               fetchData();
                                           }
                                       });


        rvSummary = view.findViewById(R.id.rvSummary);
        rvSummary.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        rvSummary.addItemDecoration(new DividerItemDecoration(this.getActivity(), DividerItemDecoration.VERTICAL));

        rvSummary.addOnItemTouchListener(new RecyclerItemClickListener(this.getActivity(), rvSummary, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                Intent intent= new Intent(SummaryFragment.this.getActivity(), DetailsActivity.class);
                intent.putExtra(AppController.INTENT_KEY_FEATURE_DATA, featureModelItems.get(position));
                intent.putExtra(AppController.INTENT_KEY_FEATURE_DATA_GEOMETRY, featureModelItems.get(position).getGeometry());
                intent.putExtra(AppController.INTENT_KEY_FEATURE_DATA_PROPERTIES, featureModelItems.get(position).getProperties());
                startActivity(intent);

            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));

        fetchData();

        return view;
    }

    private void fetchData() {
        AppController.showProgressDialog(this.getActivity());

        Call<DataModel> call = apiInterface.getData();

        call.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                AppController.dismissProgressDialog();
                swipeView.setRefreshing(false);

                dataModel = response.body();

                if(dataModel!=null) {
                    loadData();
                } else {
                    onFailure(call, null);
                }

            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {
                AppController.dismissProgressDialog();
                swipeView.setRefreshing(false);
                Toast.makeText(SummaryFragment.this.getActivity(), "An error occurred, Please try again", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void loadData() {
        featureModelItems = dataModel.getFeatures();
        summaryRecyclerViewAdapter= new SummaryRecyclerViewAdapter(this.getActivity(), featureModelItems);
        rvSummary.setAdapter(summaryRecyclerViewAdapter);
    }

    public void refreshData() {
        fetchData();
    }
}
