package com.example.fayusers;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText name, pass;
    private Cursor registry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=(EditText)findViewById(R.id.txt_name);
        pass=(EditText)findViewById(R.id.txt_pass);
    }
    //Login button b_log
    public void Logeo(View view) {
        UserSQLite user = new UserSQLite(this, "Fay", null, 1);
        SQLiteDatabase Base= user.getReadableDatabase();

            String email = name.getText().toString();
            String password = pass.getText().toString();
        if (!email.isEmpty() && !password.isEmpty()) {
            registry = Base.rawQuery("Select email, password from users where email='" + email + "' and password='" + password + "'", null);
            //Evalúa si el cursor tiene registros
            if (registry.moveToFirst() == true) {
                //Obtiene los valores y se almcacenan en la variable
                String em = registry.getString(0);
                String pass = registry.getString(1);
                //Compara datos
                if (email.equals(em) && password.equals(pass)) {

                    Intent home = new Intent(this, HomeActivity.class);
                    startActivity(home);

                }
            } else {

                Toast.makeText(this, "Datos no registrados, por favor registrese IT'S FREE!!", Toast.LENGTH_SHORT).show();
            }
        }else{

            Toast.makeText(this,"Debes llenar todos los campos", Toast.LENGTH_LONG).show();
        }

    }

    //Next Button
    public void Next(View view) {
        Intent next = new Intent(this, RegistryActivity.class);
        startActivity(next);
    }

}
