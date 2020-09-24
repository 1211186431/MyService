package com.example.myservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        String n1 = intent.getStringExtra("num1");
        String n2 = intent.getStringExtra("num2");
        String n3 = intent.getStringExtra("fu_hao");
        int num1=Integer.parseInt(n1);
        int num2=Integer.parseInt(n2);
        int num3=0;
        switch (n3){
            case "+":
                num3=num1+num2;
                break;
            case "-":
                num3=num1-num2;
                break;
            case "*":
                num3=num1*num2;
                break;
            case "/":
                num3=num1/num2;
                break;
            default:break;
        }
        Log.v("Tag",num3+"");
        intent.putExtra("num3",num3);
        return super.onStartCommand(intent, flags, startId);
    }
}
