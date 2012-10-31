package se.mah.arproject;

import com.qualcomm.QCARSamples.ImageTargets.*;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.copy_of_main_ourproject);
		
		//The AR mode
		ImageTargets myImageTarget = new ImageTargets();
		//Guide/CompanionMode
		Companion myCompanion = new Companion();
		// sets the first image from left as a button
		
		// so it goes to the companion class
		/*
		ImageView imageView = (ImageView) findViewById(R.id.imgView1);
		imageView.setOnClickListener(this);
		ImageView imageView2 = (ImageView)findViewById(R.id.imgView2);
		imageView2.setOnClickListener(this);
		ImageView imageView3 = (ImageView) findViewById(R.id.imgView3);
		imageView3.setOnClickListener(this);
		ImageView imageView4 = (ImageView)findViewById(R.id.imgView4);
		imageView4.setOnClickListener(this);
		*/
		Button btnGuide = (Button)findViewById(R.id.btnGuide);
		btnGuide.setOnClickListener(this);
		Button btnARmode = (Button)findViewById(R.id.btnARmode_home);
		btnARmode.setOnClickListener(this);
	}


	public void onClick(View v) {
		// /going to CompanionMode
		/*
		if (v.getId() == R.id.imgView1) {
			Intent intent = new Intent(this, Companion.class);
			startActivity(intent);
		}*/
		if(v.getId() == R.id.btnGuide){
			Intent intent = new Intent(this, Companion.class);
			startActivity(intent);
		}
		//Animation
		if(v.getId() == R.id.imgView2){
			
		}
		//Webb?
		if(v.getId() == R.id.imgView3){
			
		}
		///AR-MODE
		/*
		if(v.getId() == R.id.imgView4){
			Intent intent = new Intent(this, ImageTargets.class);
			startActivity(intent);
		}*/
		
		if(v.getId() == R.id.btnARmode_home){
			Intent intent = new Intent(this, ImageTargets.class);
			startActivity(intent);
		}
	}
}
