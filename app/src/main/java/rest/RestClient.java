package rest;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Response;

import java.io.IOException;

import models.User;
import models.UserResult;
import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * Created by Alec on 10/8/2015.
 */
public class RestClient {
    private static GiftlyApiInterface giftlyApiInterface;
    private static String baseUrl = "http://192.168.1.252:5000";

    public static GiftlyApiInterface getClient(){
        if(giftlyApiInterface == null) {
            OkHttpClient okClient = new OkHttpClient();
            okClient.interceptors().add(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Response response = chain.proceed(chain.request());
                    return response;
                }
            });

            Retrofit client = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverter(String.class, new ToStringConverter())
                    .client(okClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            giftlyApiInterface = client.create(GiftlyApiInterface.class);
        }
        return giftlyApiInterface ;
    }

    public interface GiftlyApiInterface {
        @Headers("User-Agent: Giftly-App")
        @GET("/api/user/getusers")
        Call<UserResult> getUsers();

        @POST("/api/user/registeruser")
        Call<User> registerUser(@Body User user);
    }
}
