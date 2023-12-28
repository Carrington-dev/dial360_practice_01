package za.co.transcend.dial360;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.chaos.view.PinView;
import com.hbb20.CountryCodePicker;


public class MainActivity extends AppCompatActivity {

    EditText emailEdittext, passwordEditText;
    CountryCodePicker countryCodePicker;
    PinView otpPinView;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        otpPinView = findViewById(R.id.pinview);
        emailEdittext = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        countryCodePicker = findViewById(R.id.ccp);
        button = findViewById(R.id.submit_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(emailEdittext.getText());
                System.out.println(passwordEditText.getText());
                System.out.println(countryCodePicker.getSelectedCountryName());
                System.out.println(countryCodePicker.getSelectedCountryCodeWithPlus());
                System.out.println(countryCodePicker.getSelectedCountryCode());
                String myCountry = countryCodePicker.getSelectedCountryName();
                Toast.makeText(MainActivity.this, emailEdittext.getText() + " " + myCountry + " " + passwordEditText.getText(), Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, otpPinView.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}