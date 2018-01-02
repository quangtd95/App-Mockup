package td95.quang.appmockup.service;


import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Query;
import td95.quang.appmockup.service.response.AccessToken;
import td95.quang.appmockup.model.News;
import td95.quang.appmockup.service.response.NewsResponse;

/**
 * A interface uses to request API.
 */
public interface ApiService {

    /**
     * 1. Login
     */
    @FormUrlEncoded
    @POST("/api/oauth2/token")
    Call<AccessToken> login(@HeaderMap Map<String, String> map, @Field("username") String userName, @Field("password") String password, @Field("grant_type") String grantType);

    @GET("/api/newsapi/get_list_news")
    Call<NewsResponse> getLastNews(@HeaderMap Map<String, String> map, @Query("keyWord") String keyWord, @Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

}
