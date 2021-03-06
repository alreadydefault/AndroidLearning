package com.example.showdatetime;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends ActionBarActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获得两个按钮的实例对象
        Button btnShowDate = (Button) findViewById(R.id.btnShowDate);
        Button btnShowTime = (Button) findViewById(R.id.btnShowTme);
        //为两个按钮添加单击事件
        btnShowDate.setOnClickListener(this);
        btnShowTime.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    private void showDialog(String title,String msg){
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	//设置对话框图标
    	builder.setIcon(android.R.drawable.ic_dialog_info);
    	//设置对话框的标题
    	builder.setTitle(title);
    	//设置对话框显示的信息
    	builder.setMessage(msg);
    	//设置对话框的按钮
    	builder.setPositiveButton("确定", null);
    	//显示对话框
    	builder.create().show();
    }

	@SuppressLint("SimpleDateFormat") @Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btnShowDate:
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			//显示当前时间
			showDialog("当前日期",sdf.format(new Date()));
			break;
		}
		case R.id.btnShowTme:
		{
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			//显示当前时间
			showDialog("当前时间",sdf.format(new Date()));
		}
		}
			
	}
}
