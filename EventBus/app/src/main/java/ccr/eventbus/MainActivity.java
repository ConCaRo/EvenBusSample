package ccr.eventbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction().add(R.id.container1, new Fragment1()).commit();
        }

        EventBus.getDefault().register(this);

    }

    @Subscribe
    public void onEventAddFragment2(MessageFragmentEvent messageFragmentEvent) {
        if(getFragmentManager().findFragmentByTag("idFragment2") == null) {
            getFragmentManager().beginTransaction().add(R.id.container2, new Fragment2(), "idFragment2").commit();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
