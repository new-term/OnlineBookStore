package com.example.bookstore;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class jindutiao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    ProgressDialog pd;
    public void showprogress(){
        pd=new ProgressDialog(this);
        pd.setTitle( "任务进行中" );
        pd.setMessage( "请稍后..." );
        pd.setCancelable( true );
        pd.setProgressStyle( ProgressDialog.STYLE_SPINNER );
        pd.show();
    }
    @SuppressLint("HandlerLeak")
    Handler handler=new Handler(  ){
        @Override
        public void handleMessage(Message msg) {//在主线程（UI）
            pd.dismiss();//发送完关闭
        }
    };
    public void onclick(View v){
        showprogress();
        //新建一个子线程
        new Thread(){//new Thread 说明并行进行，在小路跑
            public void run(){
                for(int i=0;i<=3;i++){
                    try{
                        Thread.sleep( 1000 );
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                handler.sendEmptyMessage( 0 );//向主干道发送消息，子线程
            }
        }.start();
    }
}
