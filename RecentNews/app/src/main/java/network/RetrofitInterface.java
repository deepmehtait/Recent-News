package network;

import modals.TopNews;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import utils.Constants;

/**
 * Created by deepmetha on 9/23/17.
 */

public interface RetrofitInterface {

    @GET(Constants.ARTICLE_SEARCH)
    Call<TopNews> getTopNews(@Query("api-key") String api_key, @Query("fq") String fq, @Query("begin_date") String begin_date);
}
