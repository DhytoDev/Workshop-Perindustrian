package com.dhytodev.datakemiskinan;

import android.app.Application;

import com.orm.SugarContext;

/**
 * Created by TRIPOD STUDIO on 6/4/2016.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SugarContext.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        SugarContext.terminate();
    }
}
