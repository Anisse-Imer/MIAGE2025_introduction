package fr.upjv.com.example.miage2025_introduction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ThirdActivity extends AppCompatActivity {

    private Button quitActivityButton;

    private String login;
    private String pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        this.quitActivityButton = findViewById(R.id.id_quit_thirdactivity);
        quitActivityButton.setOnClickListener(
                View -> {
                    Intent intent = new Intent();
                    intent.putExtra("login_key", this.login);
                    intent.putExtra("pwd_key", this.pwd);
                    setResult(RESULT_OK, intent);
                    finish();
                }
        );

        Intent intent = getIntent();
        Bundle extractedBundle = intent.getExtras();
        this.login = extractedBundle.getString("login_key", "login_empty");
        this.pwd = extractedBundle.getString("pwd_key", "pwd_empty");

        Toast.makeText(this,  this.login + " : " + this.pwd, Toast.LENGTH_SHORT).show();
    }
}