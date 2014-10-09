package com.example.currency_converter;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity implements OnItemSelectedListener {
	
	EditText edittext_tl;
	Spinner spinner_currency;
	TextView textview_show;
	Button button_click;
	TextView textview_result;
	float tl;
	String choosen;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Log.v("MainActivity","Oncreate method");
		
		edittext_tl = (EditText) findViewById(R.id.editText_tl);
		spinner_currency = (Spinner) findViewById(R.id.spinner_currency);
		textview_show = (TextView) findViewById(R.id.textView1);
		textview_result = (TextView) findViewById(R.id.textView2);
		
		ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.currency_array, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner_currency.setAdapter(adapter);
		
		spinner_currency.setOnItemSelectedListener(this);
		button_click = (Button) findViewById(R.id.button1);
		
		button_click.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(choosen.equals("Dollar")){
					textview_show.setText("1 Dollar = 2.26742 TL" );
					tl = Float.parseFloat(edittext_tl.getText().toString());
					textview_result.setText((tl * 0.441439) + "$");
				}
				else if (choosen.equals("Euro")) {
					textview_show.setText("1 Euro = 2.87425 TL" );
					tl = Float.parseFloat(edittext_tl.getText().toString());
					textview_result.setText((tl * 0.347663) + "€");
				}
				else{
					textview_show.setText("1gr GOLD = 89.16 TL");
					tl = Float.parseFloat(edittext_tl.getText().toString());
					textview_result.setText((tl * 0.0112157) + "gr");
				}
			}
		});
	}



	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		choosen = spinner_currency.getItemAtPosition(position).toString();
		if(choosen.equals("Dollar")){
			textview_show.setText("1 Dollar = 2.26742 TL" );
		}
		else if (choosen.equals("Euro")) {
			textview_show.setText("1 Euro = 2.87425 TL" );
		}
		else{
			textview_show.setText("1gr GOLD = 89.16 TL");
		}
	}



	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.d("MainActivity", "onStart method");
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.d("MainActivity", "onResume method");
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.d("MainActivity", "onPause method");
	}
	 
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.d("MainActiviy", "onStop method");
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.v("Mainactiviy", "onDestroy method");
	}
	
	
	
}
