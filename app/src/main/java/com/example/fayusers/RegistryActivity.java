package com.example.fayusers;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class RegistryActivity extends AppCompatActivity {

    private EditText et_name, et_lastname, et_mail, et_pass, et_birthday;
    private RadioButton rb_female, rb_male;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registry);
        et_name=(EditText)findViewById(R.id.txt_rname);
        et_lastname=(EditText)findViewById(R.id.txt_rlastname);
        et_mail=(EditText)findViewById(R.id.txt_remail);
        et_pass=(EditText)findViewById(R.id.txt_rpass);
        et_birthday=(EditText)findViewById(R.id.txt_birthdate);
        rb_female=(RadioButton)findViewById(R.id.rb_female);
        rb_male=(RadioButton)findViewById(R.id.rb_male);

    }

    //Registry Button
    public void Registry(View view){
        UserSQLite user = new UserSQLite(this, "Fay", null, 1);
        SQLiteDatabase Base= user.getWritableDatabase();

        String rname=et_name.getText().toString();
        String rlastname=et_lastname.getText().toString();
        String rmail=et_mail.getText().toString();
        String rpass=et_pass.getText().toString();
        String rdate=et_birthday.getText().toString();
        String gender="";

        //RB saber genero
        if (rb_female.isChecked() == true) {
            gender="Femenino";
        }else if (rb_male.isChecked() ==true) {
            gender="Masculino";
        }
        //validación simple de campos
        if (!rname.isEmpty() && !rlastname.isEmpty() && !rmail.isEmpty() && !rpass.isEmpty() && !rdate.isEmpty()){
            ContentValues registry = new ContentValues();
            //Si son distintos de vacío, realiza el registro
            registry.put("name",rname);
            registry.put("lastname",rlastname);
            registry.put("email",rmail);
            registry.put("password",rpass);
            registry.put("gender", gender);
            registry.put("birthday", rdate);
            //inserta y cierra
            Base.insert("users", null, registry);
            Base.close();


            Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show();
            et_name.setText("");
            et_lastname.setText("");
            et_mail.setText("");
            et_pass.setText("");
            et_birthday.setText("");

        } else {
            Toast.makeText(this,"Debes llenar todos los campos", Toast.LENGTH_LONG).show();
        }


    }

    //Back Button
    public void Back(View view){
        Intent back= new Intent(this,MainActivity.class);
        startActivity(back);
    }
}
