package se.mah.arproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Gallery;
import android.widget.Toast;

import com.qualcomm.QCARSamples.ImageTargets.*;

public class Companion extends Activity implements OnClickListener {

	private Gallery gallery;
	private Button ARbtn;
	private int x = 304;
	private int y = 304;
	RelativeLayout borderImg;
	public Boolean isOpen_pic5 = true;
	public Boolean isOpen_pic0 = true;
	
	 private SensorManager mSm;
	 private Sensor startAR;
	
	private Integer[] imageIDs = { 
			R.drawable.pic1, 
			R.drawable.textbox_1,
			R.drawable.pic2, 
			R.drawable.textbox_2, 
			R.drawable.pic3,
			R.drawable.pic4, 
			R.drawable.pic5, 
			R.drawable.textbox };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.guide);
		
		//Sensor
        mSm = (SensorManager) getSystemService(SENSOR_SERVICE);
        startAR = mSm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSm.registerListener(listener, startAR,
                                SensorManager.SENSOR_DELAY_NORMAL);
        //

		// Image Gallery
		gallery = (Gallery) findViewById(R.id.gallery1);
		ARbtn = (Button) findViewById(R.id.btnARMode_guide);
		ARbtn.setOnClickListener(this);
		
		gallery.setSpacing(16);
		gallery.setAdapter(new ImageAdapter(this));
		gallery.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView parent, View v, int position,long id) {
				switch (position) {

				case 0:
					
					Toast.makeText(getBaseContext(),
							"pic" + (position + 1) + " selected",
							Toast.LENGTH_SHORT).show();
					View child_0 = gallery.getChildAt((position + 1)
							- gallery.getFirstVisiblePosition());
					isOpen_pic0 = !isOpen_pic0;
					if (isOpen_pic0) {
						child_0.setVisibility(View.GONE);

					} else
						child_0.setVisibility(View.VISIBLE);

					break;

				case 1:
					Toast.makeText(getBaseContext(),
							"pic" + (position + 1) + " selected",
							Toast.LENGTH_SHORT).show();
					break;

				case 2:
					Toast.makeText(getBaseContext(),
							"pic" + (position + 1) + " selected",
							Toast.LENGTH_SHORT).show();
					break;

				case 3:
					Toast.makeText(getBaseContext(),
							"pic" + (position + 1) + " selected",
							Toast.LENGTH_SHORT).show();
					break;

				case 6:
					Toast.makeText(getBaseContext(),
							"pic" + (position + 1) + " selected",
							Toast.LENGTH_SHORT).show();
					View child = gallery.getChildAt((position + 1)
							- gallery.getFirstVisiblePosition());
					isOpen_pic5 = !isOpen_pic5;
					if (isOpen_pic5)
						child.setVisibility(View.GONE);
					else
						child.setVisibility(View.VISIBLE);
					break;

				}

				// sets the image under the gallery--try to make it to a
				// Dialogwindow with text also
				// image.setImageResource(imageIDs[position]);

				// set text connected to image
				// text.setText(dinoTextInfoIDs[position]);

				// Toast.makeText(getBaseContext(), "pic" + (position + 1) +
				// " selected", Toast.LENGTH_SHORT).show();
			}
		});

	}

	public void onClick(View v) {
		if (v.getId() == R.id.btnARMode_guide) {
			Intent intent = new Intent(this, ImageTargets.class);
			startActivity(intent);

		}

	}
	SensorEventListener listener = new SensorEventListener() {
		 
        public void onSensorChanged(SensorEvent event) {
            // float[] values = event.values;
            // Log.i("sensor", "rotation" + values);
 
            Sensor mySensor = event.sensor;
 
            if (mySensor.getType() == Sensor.TYPE_ACCELEROMETER) {
               // float rX = event.values[0];
                //float rY = event.values[1];
                float rZ = event.values[2];
                //tv14.setText("RV(x)= " + rX);
                //tv15.setText("RV(y) = " + rY);
                //tv16.setText("RV z = " + rZ + "\n");
                // turn to the right
 
                if(event.values[2] < 2 && event.values[2] > 1){
                    Intent intent = new Intent(getApplicationContext(), ImageTargets.class);
                    startActivity(intent);
                }
            }
        }
         
      
        public void onDestroy(){
            mSm.unregisterListener(listener);
            }
 
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            // TODO Auto-generated method stub
        }
    };

	/***************************************************************************/
	// ///-----Gallery class
	public class ImageAdapter extends BaseAdapter {
		Context context;

		public ImageAdapter(Context c) {
			context = c;
			TypedArray a = obtainStyledAttributes(R.styleable.Gallery1);
			a.recycle();
		}

		// returns the number of images
		public int getCount() {
			return imageIDs.length;
		}

		// returns the item
		public Object getItem(int position) {
			return position;
		}

		public long getItemId(int position) {
			return position;
		}

		// returns an imageVIew view
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageView;
			if (convertView == null) {
				imageView = new ImageView(context);
				imageView.setImageResource(imageIDs[position]);
				imageView.setScaleType(ImageView.ScaleType.FIT_XY);
				if (position == 1 || position == 3 || position == 7) imageView.setLayoutParams(new Gallery.LayoutParams(624, 304));
				else imageView.setLayoutParams(new Gallery.LayoutParams(x, y));
			} 
			else imageView = (ImageView) convertView;
			return imageView;
		}
	}

}
