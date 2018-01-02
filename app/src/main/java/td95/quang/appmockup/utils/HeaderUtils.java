package td95.quang.appmockup.utils;

import java.util.HashMap;

/**
 * Quang_TD on 7/16/2017.
 */

public class HeaderUtils {
    public static HashMap<String, String> buildHeaders() {
        HashMap<String, String> headers = new HashMap();
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        return headers;
    }

    public static HashMap<String, String> buildHeaders(String author) {
        HashMap<String, String> headers = new HashMap();
        headers.put("Authorization", author);
        return headers;
    }

    public static HashMap<String, String> buildHeaders(String author, String type) {
        HashMap<String, String> headers = new HashMap();
        headers.put("Authorization", author);
        headers.put("Content-Type", type);
        return headers;
    }
}
