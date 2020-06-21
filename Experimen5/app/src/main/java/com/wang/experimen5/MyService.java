package com.wang.experimen5;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class MyService extends Service {
    public MyService() {
    }

    class MyBinder extends Binder{
        private String info1;
        private String info2;
        private String info3;
        private String info4;

        public MyBinder() {
            info1 = "地震源";
            info2 = "美国";
            info3 = "地震等级";
            info4 = "7级";
        }


        public String getInfo1() {
            return info1;
        }

        public void setInfo1(String info1) {
            this.info1 = "地震源";
        }

        public String getInfo2() {
            return info2;
        }

        public void setInfo2(String info2) {
            this.info2 = "美国";
        }

        public String getInfo3() {
            return info3;
        }

        public void setInfo3(String info3) {
            this.info3 = "地震等级";
        }

        public String getInfo4() {
            return info4;
        }

        public void setInfo4(String info4) {
            this.info4 = "7级";
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}
