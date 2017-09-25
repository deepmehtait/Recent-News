package deepmehtait.com.recentnews.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.bumptech.glide.Glide;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import adapters.searchResultAdapter;
import deepmehtait.com.recentnews.R;
import modals.Docs;
import modals.SearchQuery;
import modals.TopNews;
import network.RetrofitApiClient;
import network.RetrofitInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import utils.Constants;
import utils.HumanTime;

public class searchResult extends AppCompatActivity {
    SearchQuery sr;
    RetrofitInterface retrofitInterface;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    List<Docs> searchDocs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        sr = getIntent().getParcelableExtra("searchQuery");
        String articleType = sr.getArticleType();
        String searchText = sr.getSearchText();
        String dateString = sr.getDateString();
        String sortOrder = sr.getSortOrder();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_s);
        searchDocs = new ArrayList<Docs>();
        layoutManager = new LinearLayoutManager(getApplicationContext());
        adapter = new searchResultAdapter(searchDocs, getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        String searchString = searchText+""+articleType+"&sort="+sortOrder;
        retrofitInterface = RetrofitApiClient.getRetrofitApiClient().create(RetrofitInterface.class);
        Call<TopNews> call = retrofitInterface.getTopNews(Constants.NY_API_KEY, searchString, dateString);

        call.enqueue(new Callback<TopNews>() {
            @Override
            public void onResponse(Call<TopNews> call, Response<TopNews> response) {
                Log.d("response", "" + response.body());
                if (response.isSuccessful()) {
                    TopNews tp = response.body();
                    List<Docs> docs = tp.getResponse().getDocs();
                    searchDocs.addAll(docs);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<TopNews> call, Throwable t) {
                Log.d("tech top", t.getMessage());
            }
        });
    }
}
