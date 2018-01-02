package td95.quang.appmockup.service.response;

import com.google.gson.annotations.SerializedName;

/**
 * Quang_TD on 7/16/2017.
 */

public class AccessToken {
    @SerializedName("access_token")
    private String accessToken;
    @SerializedName("token_type")
    private String tokenType;
    @SerializedName("expires_in")
    private String expriresIn;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getExpriresIn() {
        return expriresIn;
    }

    public void setExpriresIn(String expriresIn) {
        this.expriresIn = expriresIn;
    }
}
