package td95.quang.appmockup.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharePreferencesUtils {
    private static SharePreferencesUtils mAppPreference;
    private SharedPreferences mSharedPreferences;

    public static SharePreferencesUtils getInstance(Context context) {
        if (mAppPreference == null) {
            mAppPreference = new SharePreferencesUtils();
            mAppPreference.mSharedPreferences = context.getSharedPreferences("AppMockup", 0);
        }
        return mAppPreference;
    }

    public void putString(String key, String value) {
        Editor editor = this.mSharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public void putInt(String key, int value) {
        Editor editor = this.mSharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public void putBoolean(String key, boolean value) {
        Editor editor = this.mSharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public String getString(String key, String defaults) {
        return this.mSharedPreferences.getString(key, defaults);
    }

    public int getInt(String key, int defaults) {
        return this.mSharedPreferences.getInt(key, defaults);
    }

    public boolean getBoolean(String key, boolean defaults) {
        return this.mSharedPreferences.getBoolean(key, defaults);
    }
}
