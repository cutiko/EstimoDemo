package cl.cutiko.estimodemo;

import android.app.Application;
import android.content.Intent;

import com.estimote.sdk.Beacon;
import com.estimote.sdk.BeaconManager;
import com.estimote.sdk.Region;
import com.estimote.sdk.Utils;

import java.util.List;
import java.util.UUID;

public class BeaconApplication extends Application {

    public static final String BEACON_BROADCAST = "BroadcastBeacon";
    public static final String BEACON_BROADCAST_KEY = "beaconKey";
    public static final String BEACON_BROADCAST_DISTANCE = "beaconDistance";
    private BeaconManager beaconManager;
    private Region region;

    @Override
    public void onCreate() {
        super.onCreate();
        beaconManager = new BeaconManager(getApplicationContext());
        region = new Region("ranged region", UUID.fromString("B9407F30-F5F8-466E-AFF9-25556B57FE6D"), null, null);
        setRangedListener();
    }

    public void startRanging() {
        beaconManager.connect(new BeaconManager.ServiceReadyCallback() {
            @Override
            public void onServiceReady() {
                beaconManager.startRanging(region);
            }
        });
    }

    public void stopRanging() {
        beaconManager.stopRanging(region);
    }

    private void setRangedListener() {
        startRanging();

        beaconManager.setRangingListener(new BeaconManager.RangingListener() {
            @Override
            public void onBeaconsDiscovered(Region region, List<Beacon> beaconList) {
                if (beaconList != null && beaconList.size() > 0) {
                    for (Beacon beacon : beaconList) {
                        String key = String.valueOf(beacon.getMajor()) +":"+ String.valueOf(beacon.getMinor());
                        double distance = Utils.computeAccuracy(beacon);
                        Intent broadCastBeacon = new Intent();
                        broadCastBeacon.setAction(BEACON_BROADCAST);
                        broadCastBeacon.putExtra(BEACON_BROADCAST_KEY, key);
                        broadCastBeacon.putExtra(BEACON_BROADCAST_DISTANCE, distance);
                        sendBroadcast(broadCastBeacon);
                    }
                }
            }
        });
    }
}
