package itchetumal.edu.mx.serviciosocial.centroinnovacion;

/**
 * Created by PC07 on 29/04/2015.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.view.View.OnClickListener;


public class Activity_Lugares extends Activity implements OnClickListener {

    private ImageButton bandera;
    private ImageButton pescador;
    private ImageButton mestizaje;
    private ImageButton renacimiento;
    int id_imagen = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugares);

        ImageButton bandera = (ImageButton)findViewById(R.id.imgBandera);
        bandera.setOnClickListener(this);
        ImageButton pescador = (ImageButton)findViewById(R.id.imgPescador);
        pescador.setOnClickListener(this);
        ImageButton mestizaje = (ImageButton)findViewById(R.id.imgMestizaje);
        mestizaje.setOnClickListener(this);
        ImageButton renacimiento = (ImageButton)findViewById(R.id.imgRenacimiento);
        renacimiento.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgMestizaje:
                id_imagen = 1;
                Intent myIntent1 = new Intent(this, Lugar_Informacion.class);
               myIntent1.putExtra("id_imagen", id_imagen);
                startActivity(myIntent1);
                break;
            case R.id.imgBandera:
               id_imagen = 2;
                Intent myIntent2 = new Intent(this, Lugar_Informacion.class);
                myIntent2.putExtra("id_imagen", id_imagen);
                startActivity(myIntent2);
                break;
            case R.id.imgRenacimiento:
               id_imagen = 3;
                Intent myIntent3 = new Intent(this, Lugar_Informacion.class);
                myIntent3.putExtra("id_imagen", id_imagen);
                startActivity(myIntent3);
                break;
            case R.id.imgPescador:
                id_imagen = 4;
                Intent myIntent4 = new Intent(this, Lugar_Informacion.class);
               myIntent4.putExtra("id_imagen", id_imagen);
                startActivity(myIntent4);
                break;


        }


    }
}

