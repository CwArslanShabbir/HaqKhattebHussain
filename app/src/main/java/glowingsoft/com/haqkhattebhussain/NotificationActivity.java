package glowingsoft.com.haqkhattebhussain;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

public class NotificationActivity extends AppCompatActivity {
ImageView back_to_homeActivity;
    ListView notificationListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        back_to_homeActivity= (ImageView) findViewById(R.id.back_to_homeActivity);
        back_to_homeActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
