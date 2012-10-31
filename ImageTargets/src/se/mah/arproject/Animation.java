package se.mah.arproject;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import com.qualcomm.QCARSamples.ImageTargets.*;

public class Animation extends Activity implements OnClickListener {

	TextView DescTexte;
	TextView DescTexte1;
	Button Btn_1;
	Button Btn_2;
	Button Btn_3;
	Boolean isOpen = false;
	Boolean isOpen_1 = false;
	Slider slider;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_animation);
		DescTexte = (TextView) findViewById(R.id.DescText);
		DescTexte1 = (TextView) findViewById(R.id.DescText1);
		Btn_1 = (Button) findViewById(R.id.Btn_1);
		Btn_2 = (Button) findViewById(R.id.Btn_2);
		Btn_3 = (Button) findViewById(R.id.Btn_3);
		Btn_1.setOnClickListener(this);
		Btn_2.setOnClickListener(this);
		Btn_3.setOnClickListener(this);
		slider = new Slider(this);

	}

	public void onClick(View v) {
		switch (v.getId()) {

		case R.id.Btn_1:
			isOpen = !isOpen;
			if (isOpen == true)
				DescTexte.setVisibility(View.VISIBLE);
			else
				DescTexte.setVisibility(View.GONE);
			break;

		case R.id.Btn_2:
			// slider.toggle();
			isOpen_1 = !isOpen_1;
			if (isOpen_1 == false) {
				android.view.animation.Animation animation = AnimationUtils.loadAnimation(this, R.anim.slider_reverse);
				animation.reset();
				DescTexte1.startAnimation(animation);
				DescTexte1.setVisibility(View.VISIBLE);
			}
			else
			{
				android.view.animation.Animation animation = AnimationUtils.loadAnimation(this, R.anim.slider_anim);
				DescTexte1.startAnimation(animation);
				animation.setAnimationListener(new AnimationListener(){

					public void onAnimationEnd(
							android.view.animation.Animation animation) {
						// TODO Auto-generated method stub
						animation.reset();
						DescTexte1.setVisibility(View.GONE);
						
					}
					public void onAnimationRepeat(
							android.view.animation.Animation animation) {
						// TODO Auto-generated method stub
						
					}
					public void onAnimationStart(
							android.view.animation.Animation animation) {
						// TODO Auto-generated method stub
						
						
					}
					
				});
			}
			break;

		case R.id.Btn_3:

			break;
		}
	}
}
