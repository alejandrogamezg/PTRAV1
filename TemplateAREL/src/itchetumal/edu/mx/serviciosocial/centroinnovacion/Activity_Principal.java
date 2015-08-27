package itchetumal.edu.mx.serviciosocial.centroinnovacion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class Activity_Principal extends Activity implements OnClickListener {
    private Button btnIniciarAplicacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btnIniciarAplicacion=(Button)findViewById(R.id.btnInicio);
        btnIniciarAplicacion.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnInicio:
                Intent myIntent1 = new Intent(this, Activity_Lugares.class);
                startActivity(myIntent1);
                break;
        }


    }

}
