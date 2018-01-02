package td95.quang.appmockup.service.core;

import android.content.Context;


/**
 * A configure is used to create {@link ApiClient}.
 *
 */
public class ApiConfig {
    private Context context;
    private String baseUrl;

    public ApiConfig(Context context, String baseUrl) {
        this.context = context;
        this.baseUrl = baseUrl;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
