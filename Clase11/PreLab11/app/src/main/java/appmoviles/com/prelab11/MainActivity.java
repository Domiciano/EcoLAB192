package appmoviles.com.prelab11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText nombre;
    EditText correo;
    EditText plan;
    EditText password;
    EditText repassword;
    Button registrarme;
    Button yatengocuenta;


    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();

        nombre = findViewById(R.id.nombre);
        correo = findViewById(R.id.correo);
        plan = findViewById(R.id.plan);
        password = findViewById(R.id.password);
        repassword = findViewById(R.id.repassword);

        registrarme = findViewById(R.id.registrarme);
        yatengocuenta = findViewById(R.id.yatengocuenta);

        registrarme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String A = password.getText().toString();
                String B = repassword.getText().toString();
                if(A.equals(B)){
                    auth.createUserWithEmailAndPassword(correo.getText().toString(),
                            password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Intent i = new Intent(getApplicationContext(), ProfileActivity.class);
                                startActivity(i);
                            }else{
                                Toast.makeText(getApplicationContext(), "ERROR: " + task.getException(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }



                //auth.signInWithEmailAndPassword();

                //auth.signOut();

            }
        });

        yatengocuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

    }
}
