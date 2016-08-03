package ccr.eventbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class Activity1 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        EventBus.getDefault().register(this);


        findViewById(R.id.tvMessage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity2();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onPause() {
        super.onPause();
    }


    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Subscribe
    public void onEventReturnFromActivity2(MessageActivityEvent messageActivityEvent) {
        Log.d("Trong", messageActivityEvent.getMessage());
        ((TextView) findViewById(R.id.tvMessage)).setText(messageActivityEvent.getMessage());
    }

    private void startActivity2() {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }
}
