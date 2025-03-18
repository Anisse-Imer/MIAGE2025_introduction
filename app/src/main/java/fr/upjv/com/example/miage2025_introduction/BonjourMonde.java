package fr.upjv.com.example.miage2025_introduction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BonjourMonde extends AppCompatActivity {

    private ActivityResultLauncher<Intent> myLauncher;
    private Button switchSecondaryPageButton;

    private Button switchThirdActivityButton;
    private EditText loginEditText;
    private EditText pwdEditText;

    private void gestionClickButton2() {
        Log.i("MON BEAU LOG", "Magix 2");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_bonjour_monde);
        this.switchSecondaryPageButton = findViewById(R.id.id_switch_secondary_page_button);
        this.switchThirdActivityButton = findViewById(R.id.id_thirdactivity_button);

        this.myLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                resultat -> {
                    String message;
                    if(resultat.getResultCode() == RESULT_OK)
                        message = "resulat true";
                    else
                        message = "resultat false";
                    Toast.makeText(BonjourMonde.this, "BonjourMonde - result:code : " + message, Toast.LENGTH_SHORT).show();
                }
        );

        this.switchSecondaryPageButton.setOnClickListener(
                View -> {
                    Intent intent = new Intent(BonjourMonde.this, SecondaryActivity.class);

                    this.loginEditText = findViewById(R.id.id_login_editext);
                    this.pwdEditText = findViewById(R.id.id_pwd_editext);
                    String inputLogin = loginEditText.getText().toString();
                    String inputPwd = pwdEditText.getText().toString();

                    Bundle bundle = new Bundle();
                    bundle.putString("login_key", inputLogin);
                    bundle.putString("pwd_key", inputPwd);
                    intent.putExtras(bundle);

                    startActivity(intent);
                }
        );
        this.switchThirdActivityButton.setOnClickListener(
                View -> {
                    Intent intent = new Intent(BonjourMonde.this, ThirdActivity.class);
                    this.loginEditText = findViewById(R.id.id_login_editext);
                    this.pwdEditText = findViewById(R.id.id_pwd_editext);
                    String inputLogin = loginEditText.getText().toString();
                    String inputPwd = pwdEditText.getText().toString();
                    Bundle bundle = new Bundle();
                    bundle.putString("login_key", inputLogin);
                    bundle.putString("pwd_key", inputPwd);
                    intent.putExtras(bundle);
                    this.myLauncher.launch(intent);
                }
        );
    }
}
