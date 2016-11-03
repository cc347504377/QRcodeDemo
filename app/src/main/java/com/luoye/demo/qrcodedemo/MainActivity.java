package com.luoye.demo.qrcodedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.xys.libzxing.zxing.activity.CaptureActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);
        scan();
    }
    //扫描二维码
    //https://cli.im/text?2dd0d2b267ea882d797f03abf5b97d88二维码生成网站
    public void scan() {
        startActivityForResult(new Intent(this, CaptureActivity.class),0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode==RESULT_OK){
            Bundle bundle = data.getExtras();
            if (bundle != null) {
                String result=bundle.getString("result");
                textView.setText(result);
            }
        }

    }
}
