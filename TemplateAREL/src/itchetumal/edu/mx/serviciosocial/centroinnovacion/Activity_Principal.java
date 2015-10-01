package itchetumal.edu.mx.serviciosocial.centroinnovacion;

import android.app.Activity;
import android.content.Intent;
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



public class Activity_Principal extends Activity implements OnClickListener {
	private LinearLayout b_back;
	private CustomGeoPoi poi;
	//Variables a utilizar
	private ProgressBar progress;
	public Boolean custom = true;
	private DataSource data = DataSource.DEFAULT_FILES;
	private Boolean preload=true;
	private Boolean map = true;
	private Boolean list = true;
	private Boolean teleport = true;
	private Language lan=Language.ES;
	private Button bt_launch;
	private Button btnIniciarAplicacion;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnIniciarAplicacion=(Button)findViewById(R.id.btnIniciar);
		btnIniciarAplicacion.setOnClickListener(this);


		progress=(ProgressBar)this.findViewById(R.id.progressBar);
		bt_launch = (Button) this.findViewById(R.id.launch);
		bt_launch.setOnClickListener(this);


	}

	@Override
	public void onClick(View v) {

		if (v == btnIniciarAplicacion){
				Intent myIntent1 = new Intent(this, Activity_Lugares.class);
				startActivity(myIntent1);
		}
		if(v == bt_launch) {
			if (custom) {
				new VisionCore(this.getApplicationContext(), false);
				VisionCore.core.ar=new MyARManager(map,list,teleport);
				VisionCore.core.ar.setPrefixForImages("demo_");
				VisionCore.core.configuration=new VisionConfiguration();
				VisionCore.core.configuration.setRadarPosition(VisionConfiguration.RADAR_POSITION_RIGHT);
				VisionCore.core.configuration.showAppLogo(false);
				switch(lan){
					case EN:
						VisionCore.core.configuration.setLanguage("_en");
						break;
					case ES:
						VisionCore.core.configuration.setLanguage("_es");
						break;
				}
				new LoadCustomDataTask().execute();
			}else {
				new VisionCore(this.getApplicationContext(), true);
				VisionCore.core.ar.setPrefixForImages("");
				VisionCore.core.configuration.setRadarPosition(VisionConfiguration.RADAR_POSITION_LEFT);
				VisionCore.core.configuration.showAppLogo(true);
				switch(lan) {
					case EN:
						VisionCore.core.configuration.setLanguage("_en");
						break;
					case ES:
						VisionCore.core.configuration.setLanguage("_es");
						break;
				}
			}
		}
	}

	private class LoadDataTask extends AsyncTask<Void, Void, Void> {

		public LoadDataTask() {

		}

		protected void onPreExecute() {
			progress.setVisibility(View.VISIBLE);
		}

		@Override
		protected void onPostExecute(Void response) {
			VisionCore.startAR(Activity_Principal.this);
			progress.setVisibility(View.GONE);
		}

		@Override
		protected Void doInBackground(Void... params) {
			switch (data) {
				case DEFAULT_FILES:
					VisionCore.core.loadData(Activity_Principal.this);
					break;
				case DEMO_FILES:
					VisionCore.core.model.categoriesFrom = "file_categories";
					VisionCore.core.model.poisFrom = "file_pois";
					VisionCore.core.loadData(Activity_Principal.this);
					break;
				case WEB_FILES:
					VisionCore.core.model.categoriesFrom = "http://dl.dropbox.com/u/2251236/vision/file_categories";
					VisionCore.core.model.poisFrom = "https://dl.dropbox.com/u/2251236/vision/file_pois";
					VisionCore.core.loadData(Activity_Principal.this);
					break;
				case GENERATED_DATA:
					break;
			}
			return null;
		}

	}

	private class LoadCustomDataTask extends AsyncTask<Void, Void, Void> {

		public LoadCustomDataTask() {

		}

		protected void onPreExecute() {
			progress.setVisibility(View.VISIBLE);
		}

		@Override
		protected void onPostExecute(Void response) {
			VisionCore.startAR(Activity_Principal.this);
			progress.setVisibility(View.GONE);
		}

		@Override
		protected Void doInBackground(Void... params) {
			if(preload){
				VisionCore.core.model=new MyModelManagerPreload();
				VisionCore.core.model.categoriesFrom = "my_custom_categories";
				VisionCore.core.model.poisFrom = "my_custom_pois";
				VisionCore.core.model.loadPoisContinouosly = false;
				VisionCore.core.loadData(Activity_Principal.this);
			}
			else{
				VisionCore.core.model=new MyModelManager();
				VisionCore.core.model.loadPoisContinouosly = true;
				VisionCore.core.loadData(Activity_Principal.this);
			}

			return null;
		}
	}
}

