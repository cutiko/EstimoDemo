package cl.cutiko.estimodemo.views;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.estimote.sdk.BeaconManager;
import com.estimote.sdk.Region;

import java.util.ArrayList;
import java.util.List;

import cl.cutiko.estimodemo.BeaconApplication;
import cl.cutiko.estimodemo.R;
import cl.cutiko.estimodemo.adapters.BeaconsAdapter;

public class MainActivity extends AppCompatActivity implements Coordinator {

    private BroadcastReceiver receiver;
    private IntentFilter intentFilter;
    private SelectBeaconFragment selectBeaconFragment;
    private BeaconFragment beaconFragment;

    private String selectedKey = null;

    private List<cl.cutiko.estimodemo.models.Beacon> beacons = new ArrayList<>();
    private List<String> verification = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linkWithChilds();

        setFilter();
        setReceiver();
    }

    private void linkWithChilds(){
        selectBeaconFragment = (SelectBeaconFragment) getSupportFragmentManager().findFragmentById(R.id.selectBeaconFragment);
        beaconFragment = (BeaconFragment) getSupportFragmentManager().findFragmentById(R.id.beaconFragment);
    }

    private void setFilter(){
        intentFilter = new IntentFilter();
        intentFilter.addAction(BeaconApplication.BEACON_BROADCAST);
    }

    private void setReceiver(){
        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent != null) {
                    String action = intent.getAction();
                    if (action != null) {
                        if (BeaconApplication.BEACON_BROADCAST.equals(action)) {
                            handleData(intent.getStringExtra(BeaconApplication.BEACON_BROADCAST_KEY), intent.getDoubleExtra(BeaconApplication.BEACON_BROADCAST_DISTANCE, 0));
                        }
                    }
                }
            }
        };
    }

    private void handleData(String key, double distance){
        Log.d("BEACON_DATA", "key = " + key + "distance = " + String.valueOf(distance));
        if (selectedKey != null) {

        } else {

        }
    }

    @Override
    public void modalTriggered() {
        TextView tv = (TextView) findViewById(R.id.waitPleaseTv);
        tv.setVisibility(View.GONE);
    }

    @Override
    public void beaconSelected(String key) {
        selectedKey = key;
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }
}
