package fragments;

import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.customtabs.CustomTabsIntent;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import deepmehtait.com.recentnews.R;
import modals.Docs;
import modals.TopNews;
import network.RetrofitApiClient;
import network.RetrofitInterface;
import pl.tajchert.waitingdots.DotsTextView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import utils.AppStatus;
import utils.CalanderDates;
import utils.Constants;
import utils.HumanTime;

/**
 * Created by deepmetha on 9/23/17.
 */

public class TopStories extends Fragment {
    RetrofitInterface retrofitInterface;
    MenuItem miActionProgressItem;
    DotsTextView dotsTextView;
    String WebViewUrl;
    Docs currentDocument;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view;
        view = inflater.inflate(R.layout.viewpager_top_stories, null);
        final ImageView imageView = (ImageView) view.findViewById(R.id.topStoriesImageView);
        final TextView textView = (TextView) view.findViewById(R.id.topStoriesTextView);
        final TextView topStoriesAgo = (TextView) view.findViewById(R.id.topStoriesAgo);
        dotsTextView = (DotsTextView) view.findViewById(R.id.dots);
        dotsTextView.showAndPlay();
        WebViewUrl = new String ();
        currentDocument = new Docs();
        retrofitInterface = RetrofitApiClient.getRetrofitApiClient().create(RetrofitInterface.class);
        String searchString = "source:(\"The New York Times\")";
        Log.d("dates", CalanderDates.getYearMonthDateString());
        Call<TopNews> call = retrofitInterface.getTopNews(Constants.NY_API_KEY, searchString, CalanderDates.getYearMonthDateString());
        if (AppStatus.getInstance(view.getContext()).isOnline()) {
            call.enqueue(new Callback<TopNews>() {
                @Override
                public void onResponse(Call<TopNews> call, Response<TopNews> response) {
                    Log.d("response", "" + response.body());
                    if (response.isSuccessful()) {
                        TopNews tp = response.body();
                        List<Docs> docs = tp.getResponse().getDocs();
                        for (int i = 0; i < docs.size(); i++) {
                            if (docs.get(i).getMultimedia().size() > 0) {
                                currentDocument = docs.get(i);
                                textView.setText(docs.get(i).getHeadline().getMain());
                                WebViewUrl = docs.get(i).getWeb_url();
                                long ms = 0;
                                try {
                                    ms = (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+SSSS").parse(docs.get(i).getPub_date()).getTime());
                                    topStoriesAgo.setText(HumanTime.getTimeAgo(ms, view.getContext()));
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                Glide.with(view.getContext()).load(Constants.IMAGE_URL_BASE + docs.get(i).getMultimedia().get(0).getUrl()).centerCrop().error(R.drawable.noimg)
                                        .into(imageView);
                                dotsTextView.hideAndStop();
                                break;
                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<TopNews> call, Throwable t) {
                    Log.d("tech top", t.getMessage());
                }
            });

        } else {
            Snackbar.make(view.findViewById(R.id.topStoreisRR), "No Internet Connection", Snackbar.LENGTH_LONG)
                    .show();
        }
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("image Clic", "webVuew uro " + WebViewUrl);
                if (currentDocument.getWeb_url() != null) {
                    CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                    builder.setToolbarColor(ContextCompat.getColor(view.getContext(), R.color.accent));
                    builder.addDefaultShareMenuItem();
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_share);
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_TEXT, currentDocument.getWeb_url()+ " " + currentDocument.getHeadline().getPrint_headline());
                    int requestCode = 100;

                    PendingIntent pendingIntent = PendingIntent.getActivity(view.getContext(),
                            requestCode,
                            intent,
                            PendingIntent.FLAG_UPDATE_CURRENT);
                    builder.setActionButton(bitmap, "Share Link", pendingIntent, true);
                    CustomTabsIntent customTabsIntent = builder.build();

                    customTabsIntent.launchUrl(view.getContext(), Uri.parse(WebViewUrl));
                }
            }
        });
        Glide.with(view.getContext()).load("http://www.nytimes.com/images/2017/09/24/sports/24warriors-1/merlin-to-scoop-127804586-696858-articleLarge.jpg").centerCrop()
                .into(imageView);
        textView.setText("Stephen Curry, on a ‘Surreal Day,’ Confronts a Presidential Snub");
        String dateString = "2017-09-24T00:36:41+0000";
        Date date;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+SSSS");
        try {
            date = sdf.parse(dateString);
            long millis = date.getTime();
            Log.d("time", "" + HumanTime.getTimeAgo(millis, view.getContext()));
            topStoriesAgo.setText("10 min ago");

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return view;
    }

}
