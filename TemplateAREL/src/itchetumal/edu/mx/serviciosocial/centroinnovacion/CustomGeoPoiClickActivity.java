package itchetumal.edu.mx.serviciosocial.centroinnovacion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.geomobile.arcore.VisionCore;
import com.geomobile.arcore.utils.VisionUtils;


public class CustomGeoPoiClickActivity extends Activity implements OnClickListener{
	
	private LinearLayout b_back;
	private CustomGeoPoi poi;
	private Button bottonRA;
	
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_custom_poi_click);
		
		poi=(CustomGeoPoi)VisionCore.core.model.getSelectedPoi();
		
		b_back=(LinearLayout)this.findViewById(R.id.buttonBack);
		b_back.setBackgroundDrawable(VisionUtils.getStateListDrawable("vision_button_topleftcorner"));
		b_back.setOnClickListener(this);
		
		bottonRA = (Button)findViewById(R.id.btnVisionRA);
		bottonRA.setOnClickListener(this);
		
		TextView title=(TextView)this.findViewById(R.id.title);
		title.setText(poi.getTitle());
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v == b_back){
			finish();
		}else if(v == bottonRA){
			Intent ra = new Intent(this, Activity_Metaio.class);
	        startActivity(ra);
		}
	}
}
