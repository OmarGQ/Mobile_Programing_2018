package com.example.omarxv.pract_7_oigq;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Actualizar extends Activity {

    String[] califs = {"0", "10", "20", "30", "40", "50", "60", "70", "80", "90", "100",};
    EditText editN, editCa;
    String nom ="";
    int radE, radJ, radD;
    RadioGroup rgE, rgJ, rgD;
    RadioButton radE1, radE2, radJ1, radJ2, radD1, radD2;
    boolean flRd1 = false, flRd2 = false, flRd3 = false, capOrAc = false;
    int calif = 0;
    Button capAc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(this));
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_actualizar);
        super.onCreate(savedInstanceState);
        editN = findViewById(R.id.etN);
        editN.setText("");
        editCa = findViewById(R.id.etC);
        editCa.setText("");
        rgE = findViewById(R.id.rg1);
        rgJ = findViewById(R.id.rg2);
        rgD = findViewById(R.id.rg3);
        radE1 = findViewById(R.id.rdE1);
        radE2 = findViewById(R.id.rdE2);
        radJ1 = findViewById(R.id.rdJ1);
        radJ2 = findViewById(R.id.rdJ2);
        radD1 = findViewById(R.id.rdD1);
        radD2 = findViewById(R.id.rdD2);
        capAc = findViewById(R.id.btCapAc);
        rgE.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                flRd1 = true;
                if(checkedId == R.id.rdE1){
                    radE = 1;
                }
                else if(checkedId == R.id.rdE2){
                    radE = 0;
                }
            }
        });
        rgJ.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                flRd2 = true;
                if(checkedId == R.id.rdJ1){
                    radJ = 1;
                }
                else if(checkedId == R.id.rdJ2){
                    radJ = 0;
                }
            }
        });
        rgD.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                flRd3 = true;
                if(checkedId == R.id.rdD1){
                    radD = 1;
                }
                else if(checkedId == R.id.rdD2){
                    rgD.clearCheck();
                    Toast.makeText(getMe(), "Error, opcion no disponible", Toast.LENGTH_SHORT).show();
                }
            }
        });
        editCa.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(i== EditorInfo.IME_ACTION_DONE){
                    if(Integer.parseInt(editCa.getText().toString()) < 70){
                        Toast.makeText(getMe(), "porfavor", Toast.LENGTH_SHORT).show();
                        editCa.setText("");
                        calif = 0;
                    }

                }
                return false;
            }
        });
        capAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!capOrAc){
                    actuBus(v);
                }else{
                    actuCap(v);
                }
            }
        });
    }
    @SuppressLint("SetTextI18n")
    public void actuCap(View v){
        nom = editN.getText().toString();
        calif = Integer.parseInt(editCa.getText().toString());
        if(nom.matches("") || calif == 0 || !flRd1 || !flRd2 || !flRd3){
            Toast.makeText(this, "Porfavor rellene todos los campos", Toast.LENGTH_SHORT).show();
        }
        else{
            AdminSQLiteOpenHelper admin2 = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
            SQLiteDatabase bd2 = admin2.getWritableDatabase();
            bd2.execSQL("DELETE FROM encuesta WHERE nombre = '"+editN.getText().toString()+"'");
            bd2.close();
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
            SQLiteDatabase bd = admin.getWritableDatabase();
            ContentValues registro = new ContentValues();
            registro.put("nombre", nom);
            registro.put("erectil", radE);
            registro.put("dinero", radD);
            registro.put("japo", radJ);
            registro.put("calif", calif);
            bd.insert("encuesta", null, registro);
            bd.close();
            editN.setText("");
            editCa.setText("");
            rgE.clearCheck();
            rgJ.clearCheck();
            rgD.clearCheck();
            capAc.setText("BUSCAR");
            capOrAc = false;
            Toast.makeText(this, "Los datos se han capturado satisfactoriamente", Toast.LENGTH_SHORT).show();
        }
    }
    @SuppressLint("SetTextI18n")
    public void actuBus(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        Cursor fila = bd.rawQuery("select * from encuesta where nombre='"+editN.getText().toString()+"'", null);
        if(fila.moveToFirst())  {
            rgE.setVisibility(View.VISIBLE);
            rgJ.setVisibility(View.VISIBLE);
            rgD.setVisibility(View.VISIBLE);
            editCa.setVisibility(View.VISIBLE);
            if(fila.getInt(2) == 1){
                radE1.toggle();
            }
            else{
                radE2.toggle();
            }
            if(fila.getInt(3) == 1){
                radJ1.toggle();
            }
            else{
                radJ2.toggle();
            }
            if(fila.getInt(4) == 1){
                radD1.toggle();
            }
            else{
                radD2.toggle();
            }
            editCa.setText(fila.getString(5));
            capOrAc = true;
            capAc.setText("ACTUALIZAR");
        }  else
            Toast.makeText(this, "No existe un artículo con dicho código", Toast.LENGTH_SHORT).show();
        bd.close();
    }
    public Actualizar getMe(){
        return this;
    }
    public void salirCap(View v){
        finish();
    }
}
