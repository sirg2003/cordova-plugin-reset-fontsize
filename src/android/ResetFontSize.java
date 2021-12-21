package com.sirg.cordova;

import android.webkit.WebSettings;
import android.webkit.WebView;

import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;

import android.util.Log;

public class ResetFontSize extends CordovaPlugin {
    private static final String LOG_TAG = "ResetFontSize";

    /**
     * @param cordova The context of the main Activity.
     * @param webView The CordovaWebView Cordova is running in.
     */
    @Override
    public void initialize(final CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);

        cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
                WebView wv = (WebView) webView.getView();
                WebSettings ws = wv.getSettings();

                Log.w(LOG_TAG, "[ResetFontSize][loaded] getTextZoom:" + ws.getTextZoom());
                ws.setTextZoom(100);
                Log.w(LOG_TAG, "[ResetFontSize][updated] getTextZoom:" + ws.getTextZoom());

                // for tests
                // Log.w(LOG_TAG, "[ResetFontSize] getDefaultFontSize:" + ws.getDefaultFontSize()); // 16
                // Log.w(LOG_TAG, "[ResetFontSize] getDefaultFixedFontSize:" + ws.getDefaultFixedFontSize()); // 16
                // Log.w(LOG_TAG, "[ResetFontSize] getUseWideViewPort:" + ws.getUseWideViewPort());
                // Log.w(LOG_TAG, "[ResetFontSize] supportZoom:" + ws.supportZoom());

                // ws.setDefaultFontSize(16);
                // ws.setDefaultFixedFontSize(16);
                // wv.setInitialScale(0);
                // wv.setInitialScale(100);
                // ws.setLoadWithOverviewMode(false);
                // ws.setLoadWithOverviewMode(true);
                // ws.setUseWideViewPort(false);
                // ws.setUseWideViewPort(true);
            }
        });
    }
} 