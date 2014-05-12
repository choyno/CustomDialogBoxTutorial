package com.example.gsonparsetutorial;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.androidquery.AQuery;

public class MainActivity extends Activity {

	private AQuery aq;
	Dialog dialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		aq = new AQuery(this);

		aq.id(R.id.button1).clicked(this, "buttonClicked");
		aq.id(R.id.button2).clicked(this, "buttonDialog");
	}

	public void buttonClicked(View v) {
		String value = aq.id(R.id.textView1).getTag().toString();

		Log.d("hello", value);
		if (value.equals("google")) {
			aq.id(R.id.textView1).text("Yahoo").tag("yahoo");
		} else {
			aq.id(R.id.textView1).text("Google").tag("google");
		}
	}

	public void buttonDialog(View view) {

		final Context context = view.getContext();

		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		final View formElementsView = inflater.inflate(R.layout.custom_dialog,
				null, false);

		dialog = new AlertDialog.Builder(context)
				.setView(formElementsView).show(); 
		
		  Button aboutUser = ( Button ) formElementsView.findViewById( R.id.btn_yes );
          
		  aboutUser .setOnClickListener( new View.OnClickListener()
          {
              public void onClick( View v )
              {  
            		dialog.cancel();
              }
          });

	}
	
	public void sample(){
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
