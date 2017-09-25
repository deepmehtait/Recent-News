package adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.List;

import deepmehtait.com.recentnews.R;
import modals.Docs;
import utils.Constants;
import utils.HumanTime;

/**
 * Created by deepmetha on 9/24/17.
 */

public class searchResultAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Docs> dos;
    Context ctx;
    final int HAS_IMAGE = 0;
    final int NO_IMAGE = 1;

    public searchResultAdapter(List<Docs> docs, Context context) {
        this.dos = docs;
        this.ctx = context;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case HAS_IMAGE: {
                View v1 = inflater.inflate(R.layout.news_view_2, parent, false);
                viewHolder = new ImageViewHolder(v1);
                break;
            }
            case NO_IMAGE: {
                View v2 = inflater.inflate(R.layout.news_view_1, parent, false);
                viewHolder = new noImageViewHolder(v2);
            }
            default: {
                
            }
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case HAS_IMAGE: {
                ImageViewHolder vh1 = (ImageViewHolder) holder;
                configureImageViewHolder(vh1, position);
            }
            case NO_IMAGE: {
               // noImageViewHolder vh2 = (noImageViewHolder) holder;
               // configureNoImageViewHolder(vh2, position);
            }
        }

    }

    private void configureNoImageViewHolder(noImageViewHolder vh2, int position) {
        Docs ds = dos.get(position);
        vh2.getNews_view_1_tv().setText(ds.getHeadline().getPrint_headline());
        long ms = 0;
        try {
            ms = (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+SSSS").parse(ds.getPub_date()).getTime());
            vh2.getTimeAgo().setText(HumanTime.getTimeAgo(ms, ctx));
        } catch (Exception e) {

        }

    }

    private void configureImageViewHolder(ImageViewHolder vh1, int position) {
        Docs ds = dos.get(position);
        vh1.getNews_view_2_tv().setText(ds.getHeadline().getPrint_headline());
        Glide.with(ctx).load(Constants.IMAGE_URL_BASE + ds.getMultimedia().get(0).getUrl()).centerCrop().error(R.drawable.noimg)
                .into(vh1.getImageView2());
        long ms = 0;
        try {
            ms = (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+SSSS").parse(ds.getPub_date()).getTime());
            vh1.getTimeAgo2().setText(HumanTime.getTimeAgo(ms, ctx));
        } catch (Exception e) {

        }
    }

    @Override
    public int getItemCount() {
        return this.dos.size();
    }
    @Override
    public int getItemViewType(int position) {
        if (dos.get(position).getMultimedia().size() > 0) {
            return HAS_IMAGE;
        } else if (dos.get(position).getMultimedia().size() == 0){
            return NO_IMAGE;
        }
        return -1;
    }

    public class noImageViewHolder extends RecyclerView.ViewHolder {


        TextView news_view_1_tv;
        TextView timeAgo;
        public noImageViewHolder(View itemView) {
            super(itemView);
            news_view_1_tv = (TextView) itemView.findViewById(R.id.news_view_1_tv);
            timeAgo = (TextView) itemView.findViewById(R.id.timeAgo);
        }
        public TextView getNews_view_1_tv() {
            return news_view_1_tv;
        }

        public void setNews_view_1_tv(TextView news_view_1_tv) {
            this.news_view_1_tv = news_view_1_tv;
        }

        public TextView getTimeAgo() {
            return timeAgo;
        }

        public void setTimeAgo(TextView timeAgo) {
            this.timeAgo = timeAgo;
        }


    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {

        TextView timeAgo2;
        TextView news_view_2_tv;
        ImageView imageView2;
        public ImageViewHolder(View itemView) {
            super(itemView);
            timeAgo2 = (TextView) itemView.findViewById(R.id.timeAgo2);
            news_view_2_tv = (TextView) itemView.findViewById(R.id.news_view_2_tv);
            imageView2 = (ImageView) itemView.findViewById(R.id.imageView2);
        }

        public TextView getTimeAgo2() {
            return timeAgo2;
        }

        public void setTimeAgo2(TextView timeAgo2) {
            this.timeAgo2 = timeAgo2;
        }

        public TextView getNews_view_2_tv() {
            return news_view_2_tv;
        }

        public void setNews_view_2_tv(TextView news_view_2_tv) {
            this.news_view_2_tv = news_view_2_tv;
        }

        public ImageView getImageView2() {
            return imageView2;
        }

        public void setImageView2(ImageView imageView2) {
            this.imageView2 = imageView2;
        }
    }
}
