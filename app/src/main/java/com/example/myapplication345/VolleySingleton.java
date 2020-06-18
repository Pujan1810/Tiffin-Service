package com.example.myapplication345;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.Collection;

public class VolleySingleton  {


    private static VolleySingleton mInstance;
    private final Context mCtx;
    private RequestQueue mRequestQueue;

    private VolleySingleton(Context context) {
        mCtx = context;
        mRequestQueue = (RequestQueue) getRequestQueue();
    }


    public static synchronized VolleySingleton getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new VolleySingleton(context);
        }
        return mInstance;
    }


    public <T> void addToRequestQueue(Request<T> req)
    {
        getRequestQueue().add(req);
    }

    private <T> RequestQueue getRequestQueue() {


        if (mRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }


        return mRequestQueue;
    }




}

