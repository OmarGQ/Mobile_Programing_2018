package com.example.omarxv.pract_7_oigq;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Buscar extends Activity {
    private EditText et2;
    private TextView tv10, tv12, tv14, tv16, tv18;
    String d1, d2, d3, d4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_buscar);
        //Thread.setDefaultUncaughtExceptionHandler(new com.example.omarxv.pract_7_oigq.ExceptionHandler(this));
        et2=(EditText)findViewById(R.id.et2);
        tv10=(TextView)findViewById(R.id.tv10);
        tv12=(TextView)findViewById(R.id.tv12);
        tv14=(TextView)findViewById(R.id.tv14);
        tv16=(TextView)findViewById(R.id.tv16);
        tv18=(TextView)findViewById(R.id.tv18);

    }
    public void consulta(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String user = et2.getText().toString();
        Cursor fila = bd.rawQuery("select * from encuesta where nombre='"+user+"'", null);
        if (fila.moveToFirst())  {
            int i1=(fila.getInt(2));
            if(i1==0)
                d1="no";
            else
                d1="si";
            int i2=(fila.getInt(3));
            if(i2==0)
                d2="no";
            else
                d2="si";
            int i3=(fila.getInt(4));
            if(i3==0)
                d3="no";
            else
                d3="si";
            d4=(fila.getString(5));
            tv10.setText(fila.getString(1));
            tv12.setText(d1);
            tv14.setText(d2);
            tv16.setText(d3);
            tv18.setText(d4);
        }  else
            Toast.makeText(this, "No existe un artículo con dicho código", Toast.LENGTH_SHORT).show();
        bd.close();
    }
}
