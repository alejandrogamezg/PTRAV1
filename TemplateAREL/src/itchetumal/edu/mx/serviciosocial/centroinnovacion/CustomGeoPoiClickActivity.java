package itchetumal.edu.mx.serviciosocial.centroinnovacion;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.geomobile.arcore.VisionConfiguration;
import com.geomobile.arcore.VisionCore;
import com.geomobile.arcore.utils.VisionUtils;

public class CustomGeoPoiClickActivity extends Activity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_custom_poi_click);


	}
}