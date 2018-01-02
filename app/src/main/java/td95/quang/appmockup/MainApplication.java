package td95.quang.appmockup;

import android.app.Application;

import td95.quang.appmockup.service.core.ApiClient;
import td95.quang.appmockup.service.core.ApiConfig;
import td95.quang.appmockup.utils.CommonUtils;

/**
 * Quang_TD on 7/16/2017.
 */

public class MainApplication extends Application {
    @Override public void onCreate() {
        super.onCreate();
        createService();
        CommonUtils.printKeyHash(this);
    }

    private void createService() {
        ApiConfig apiConfig = new ApiConfig(this, getString(R.string.url_base));
        ApiClient.getInstance().init(apiConfig);
    }
}
