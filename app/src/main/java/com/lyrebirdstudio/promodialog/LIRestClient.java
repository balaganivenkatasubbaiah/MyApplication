package com.lyrebirdstudio.promodialog;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.ResponseHandlerInterface;

public class LIRestClient {
    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void downloadFile(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(url, params, (ResponseHandlerInterface) responseHandler);
    }

    public static void downloadJSON(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(url, params, (ResponseHandlerInterface) responseHandler);
    }
}
