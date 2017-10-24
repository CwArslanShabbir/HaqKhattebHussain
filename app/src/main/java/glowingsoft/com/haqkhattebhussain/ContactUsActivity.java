package glowingsoft.com.haqkhattebhussain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ContactUsActivity extends AppCompatActivity {
Button viewMapBtnOne,viewMapBtnTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        viewMapBtnOne = (Button) findViewById(R.id.viewMapBtnOne);
        viewMapBtnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ContactUsActivity.this, "View Map 1", Toast.LENGTH_SHORT).show();
            }
        });

        viewMapBtnTwo = (Button) findViewById(R.id.viewMapBtnTwo);
        viewMapBtnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ContactUsActivity.this, "View Map 2", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
