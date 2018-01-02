package td95.quang.appmockup.service.core;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;




public abstract class DataCallBack<T> implements Callback<T>{
    public abstract void onSuccess(T response);
    public abstract void onError(String error);

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        onSuccess(response.body());
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
//        onError(GlobalDef.ERROR_NETWORK);
    }
}
