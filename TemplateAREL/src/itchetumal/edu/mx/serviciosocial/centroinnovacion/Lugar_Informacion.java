package itchetumal.edu.mx.serviciosocial.centroinnovacion;

import android.app.Activity;

import android.os.Bundle;

import android.util.Log;
import android.widget.Button;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.HttpEntity;

import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;

import android.os.AsyncTask;

import android.widget.TextView;
import android.widget.Toast;
/**
 * Created by PC07 on 06/05/2015.
 */
@SuppressLint("InlinedApi")
public class Lugar_Informacion extends Activity {


    private TextView txtId;
    private TextView txtNombre;
    private TextView txtUbicacion;
    private TextView txtInagurado;
    private TextView txtGobernador;
    private TextView txtDescripcion;
    private TextView txtEscultor;
    private List<Lugares> listaLugares;
    private int posicion = 0;
    private Button mostrar;
    int id_imagen = 0;
    private String jsonResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.informacion);

        txtId = (TextView) findViewById(R.id.idDatos);
        txtNombre = (TextView) findViewById(R.id.txtNombre);
        txtUbicacion = (TextView) findViewById(R.id.txtUbicacion);
        txtInagurado = (TextView) findViewById(R.id.txtInaguracion);
        txtGobernador = (TextView) findViewById(R.id.txtGobernador);
        txtDescripcion = (TextView) findViewById(R.id.txtDescripcion);
        txtEscultor = (TextView) findViewById(R.id.txtEscultor);
        listaLugares = new ArrayList<Lugares>();

        Bundle bundle = getIntent().getExtras();
        id_imagen = bundle.getInt("id_imagen");
        Toast.makeText(this, "Imagen id " + id_imagen, Toast.LENGTH_LONG).show();

        new DoPost().execute();


    }

    class DoPost extends AsyncTask<String, String, String> {

        /**
         * getting All barrafrias from url
         */
        @Override
        protected String doInBackground(String... args) {


            String URL = "http://192.168.10.108/Turismo/recibe.php";
            try {
                HttpClient httpclient = new DefaultHttpClient();
                HttpPost httppost = new HttpPost(URL);
                List<NameValuePair> params = new ArrayList<NameValuePair>();

                params.add(new BasicNameValuePair("id_imagen", String.valueOf(id_imagen)));

                String text;
                httppost.setEntity(new UrlEncodedFormEntity(params));
                HttpResponse response = httpclient.execute(httppost);

                HttpEntity entity = response.getEntity();
                text = EntityUtils.toString(entity);
                Log.e("optrewsz", text);
                String id="",nom="",ubic="",ina="",gob="", des="",escul="";


                String[] numerosComoArray = text.split("<br>");
                for (int i = 0; i < numerosComoArray.length; i++) {

                    id = numerosComoArray[0];
                    nom = numerosComoArray[1];
                    ubic= numerosComoArray[2];
                    ina= numerosComoArray[3];
                    gob= numerosComoArray[4];
                    des= numerosComoArray[5];
                    escul= numerosComoArray[6];

                }
                Log.e("Exam", id+" "+nom+" "+ubic);
                txtId.setText(id);
                txtNombre.setText(nom);
                txtUbicacion.setText(ubic);
                txtInagurado.setText(ina);
                txtGobernador.setText(gob);
                txtDescripcion.setText(des);
                txtEscultor.setText(escul);



            } catch (Exception e) {
                Log.e("errorCosa", e.toString());

            }

            return null;

        }
    }
}





