package se.mah.arproject;

import android.content.Context;
import android.util.Log;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qualcomm.QCARSamples.ImageTargets.*;

public class Slider extends LinearLayout{

	Boolean isOpen = true;
	TextView Texte = (TextView)findViewById(R.id.DescText1);
	
	public Slider(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public boolean toggle() {
		//Animation de transition.
		TranslateAnimation animation = null;
		
		// On passe de ouvert � ferm� (ou vice versa)
		isOpen = !isOpen;
		
		
		// Si le menu est d�j� ouvert
		if (isOpen) 
		{
			// Animation de translation du bas vers le haut
			
			animation = new TranslateAnimation(-Texte.getHeight(), 0.0f,
					0.0f, 0.0f);
			
		} else
		{
			// Sinon, animation de translation du haut vers le bas
			Log.d("Slider", "2");
			animation = new TranslateAnimation(0.0f, -Texte.getHeight(), 
					0.0f,0.0f );
			
		}
		
		// On d�termine la dur�e de l'animation
		animation.setDuration(500);
		// On ajoute un effet d'acc�l�ration
		animation.setInterpolator(new AccelerateInterpolator());
		// Enfin, on lance l'animation
		startAnimation(animation);
		
		return isOpen;
	}
}
