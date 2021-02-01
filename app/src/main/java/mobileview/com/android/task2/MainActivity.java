package mobileview.com.android.task2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText phoneNumber;
    private Button buttonCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneNumber = findViewById(R.id.a_editText_phone);
        buttonCheck = findViewById(R.id.a_button_test);

        buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String toastMessage;
                boolean isValid =  isNumberValid();

                if (isValid) {
                    toastMessage = "Valid";
                } else {
                    toastMessage = "Invalid";
                }
                Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean isNumberValid() {

        String phoneNumberString = String.valueOf(phoneNumber.getText());
        boolean isNumber = TextUtils.isDigitsOnly(phoneNumberString);
        boolean isValid = false;

        if (isNumber) {
            if (phoneNumberString.length() == 10) {
                isValid = true;
            }
        }
        return isValid;

    }
}