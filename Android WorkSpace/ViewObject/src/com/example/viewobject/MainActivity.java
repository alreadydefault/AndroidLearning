package com.example.viewobject;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements OnClickListener{
	
	private TextView textView1;
	private Button button1;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //获得activity_main.xml中的LinearLayout对象
        LinearLayout mainLinearLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.activity_main, null);
       //设置当前容器视图
        setContentView(mainLinearLayout);
        textView1 = (TextView) findViewById(R.id.textview1);
        button1 = (Button) findViewById(R.id.button1);
        textView1.setText("第一个TextView");
        //设置按钮的单击事件类的对象实例
        button1.setOnClickListener(this);
        //获得test.xml中的LinearLayout对象
        LinearLayout testLinearLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.test, mainLinearLayout);
        //如果使用以下代码，需要将inflate方法的第二个参数设置为null
        //mainLinearLayout.addView(testLinearLayout);
        //创建新的视图对象
        EditText editText = new EditText(this);
        //将EditText对象设置成可输入多行文本
        editText.setSingleLine(false);
        //设置EditText控件文本的默认对齐方式为左对齐
        editText.setGravity(Gravity.LEFT);
        //将EditText对象添加到mainLinearLayout对象中，并通过LayoutParams对象指定EditText的高度和宽度
        testLinearLayout.addView(editText, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        
    }

    //按钮的单击事件方法
	@Override
	public void onClick(View v) {
		// 在单击事件中，不断调整textView1中文本对齐方式
		int value = textView1.getGravity() & 0x07;
		if (value == Gravity.LEFT) {
			textView1.setGravity(Gravity.CENTER_HORIZONTAL);
		}
		else if (value == Gravity.CENTER_HORIZONTAL) {
			textView1.setGravity(Gravity.RIGHT);
		}
		else if (value == Gravity.RIGHT) {
			textView1.setGravity(Gravity.LEFT);
		}
	}
}
