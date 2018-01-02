package td95.quang.appmockup.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Arrays;

import retrofit2.Call;
import td95.quang.appmockup.Constants;
import td95.quang.appmockup.R;
import td95.quang.appmockup.service.core.ApiClient;
import td95.quang.appmockup.service.core.DataCallBack;
import td95.quang.appmockup.service.response.AccessToken;
import td95.quang.appmockup.utils.HeaderUtils;
import td95.quang.appmockup.utils.SharePreferencesUtils;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {
    private Button mBtnFbLogin;
    private Button mBtnGGLogin;
    private CallbackManager callbackManager;
    private SharePreferencesUtils sharePreferencesUtils;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callbackManager = CallbackManager.Factory.create();
        sharePreferencesUtils = SharePreferencesUtils.getInstance(this);


        addControl();
        addEvent();
    }

    private void addEvent() {
        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        login();
                    }

                    @Override
                    public void onCancel() {
                        Toast.makeText(MainActivity.this, "onCancel", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        Toast.makeText(MainActivity.this, "onError", Toast.LENGTH_SHORT).show();
                    }
                });

        mBtnFbLogin.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                LoginManager.getInstance().logInWithReadPermissions(MainActivity.this, Arrays.asList("public_profile", "user_friends"));
            }
        });
        mBtnGGLogin.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                LoginManager.getInstance().logInWithReadPermissions(MainActivity.this, Arrays.asList("public_profile", "user_friends"));
            }
        });

    }


    private void addControl() {
        mBtnFbLogin = (Button) findViewById(R.id.btnFbLogin);
        mBtnGGLogin = (Button) findViewById(R.id.btnGgLogin);
    }


    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }


    private void login() {
        getAccessToken();
    }

    private void getAccessToken() {
        Call<AccessToken> call = ApiClient.getService().login(HeaderUtils.buildHeaders(), "admin", "gKHu5Nw828apo3Y", "password");
        call.enqueue(new DataCallBack<AccessToken>() {
            @Override public void onSuccess(AccessToken response) {
                sharePreferencesUtils.putString(Constants.KEY_ACCESS_TOKEN, response.getAccessToken());
                startHomeActivity();
            }

            @Override public void onError(String error) {
                Toast.makeText(MainActivity.this, "sorry, I cannot login now", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void startHomeActivity() {
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }


    @Override public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
