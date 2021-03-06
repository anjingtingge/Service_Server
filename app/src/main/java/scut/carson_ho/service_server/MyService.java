package scut.carson_ho.service_server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;



/**
 * Created by Carson_Ho on 16/11/8.
 */
public class MyService extends Service {
     String ss="11";

    // 实例化AIDL的Stub类(Binder的子类)
    AIDL_Service1.Stub mBinder = new AIDL_Service1.Stub() {

        //重写接口里定义的方法
        @Override
        public void AIDL_Service() throws RemoteException {
            System.out.println("客户端通过AIDL与远程后台成功通信");
        }
    };



//如果用startService()方法启动Service，OnStartCommand方法能够执行；
   // 如果用bindService（）方法启动Service，OnstartCommand方法就不能够执行了。
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        System.out.println("执行了onStartCommand()");
        return super.onStartCommand(intent, flags, startId);


    }

    @Override
    public void onCreate() {
        super.onCreate();

        System.out.println("执行了onCreat()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("执行了onDestory()");
    }

    //在onBind()返回Stub类实例
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
    //接收数据
        ss = intent.getStringExtra("data");
        System.out.println(ss);

        return mBinder;
    }




    @Override
    public boolean onUnbind(Intent intent) {
        System.out.println("执行了onUnbind()");
        return super.onUnbind(intent);
    }

}
