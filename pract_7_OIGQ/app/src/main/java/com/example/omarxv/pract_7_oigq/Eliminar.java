package com.example.omarxv.pract_7_oigq;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Eliminar extends Activity {
    private EditText et2;
    private TextView tv12, tv14, tv16, tv18;
    private Button bt4, bt5;
    String d1, d2, d3, d4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);
        et2=(EditText)findViewById(R.id.et2);
        tv12=(TextView)findViewById(R.id.tv12);
        tv14=(TextView)findViewById(R.id.tv14);
        tv16=(TextView)findViewById(R.id.tv16);
        tv18=(TextView)findViewById(R.id.tv18);
        bt4=(Button)findViewById(R.id.bt4);
        bt5=(Button)findViewById(R.id.bt5);
        bt4.setEnabled(false);
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
            tv12.setText(d1);
            tv14.setText(d2);
            tv16.setText(d3);
            tv18.setText(d4);
            bt4.setEnabled(true);
            bt5.setEnabled(false);
        }  else
            Toast.makeText(this, "No existe una encuesta con dicho nombre", Toast.LENGTH_SHORT).show();
        bd.close();
    }

    public void delete (View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String user= et2.getText().toString();
        int cant = bd.delete("encuesta", "nombre='"+user+"'", null);
        bd.close();
        et2.setText("");
        tv12.setText("");
        tv14.setText("");
        tv16.setText("");
        tv18.setText("");
        bt4.setEnabled(false);
        bt5.setEnabled(true);
        if (cant == 1)
            Toast.makeText(this, "Se borró la encuesta", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "No se logro borrar", Toast.LENGTH_SHORT).show();
    }
}
