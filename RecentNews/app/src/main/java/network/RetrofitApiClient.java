package network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import utils.Constants;

/**
 * Created by deepmetha on 9/23/17.
 */

public class RetrofitApiClient {
    public static Retrofit retrofit = null;

    public static Retrofit getRetrofitApiClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
