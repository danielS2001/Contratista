package com.example.contratista;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class RegistroActivity extends AppCompatActivity {
    private Button btnCancel;
    private Button btnLimpiar;
    private EditText txtNombre, txtCorreo, txtTelefono;
    private Spinner spnVocacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        iniciar();

        ArrayAdapter<String> Adaptador=new ArrayAdapter<String>(RegistroActivity.this,android.R.layout.simple_expandable_list_item_1,getResources().getStringArray(R.array.vocaciones));
        spnVocacion.setAdapter(Adaptador);
        spnVocacion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,int i, long l) {
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }});

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder confirmar = new AlertDialog.Builder(RegistroActivity.this);
                confirmar.setTitle("¿Cancelar el registro?");
                confirmar.setMessage("¿Está seguro de que desea regresar a la pantalla inicial?");
                confirmar.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                confirmar.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                confirmar.show();
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtNombre.setText("");
                txtCorreo.setText("");
                txtTelefono.setText("");
            }
        });
    }

    private void iniciar() {
        btnCancel = (Button) findViewById(R.id.btnCancel);
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtCorreo = (EditText) findViewById(R.id.txtCorreo);
        txtTelefono = (EditText) findViewById(R.id.txtTelefono);

        spnVocacion = (Spinner) findViewById(R.id.spnVocacion);
    }
}