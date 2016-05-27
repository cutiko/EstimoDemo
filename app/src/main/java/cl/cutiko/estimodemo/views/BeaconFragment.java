package cl.cutiko.estimodemo.views;


import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cl.cutiko.estimodemo.BeaconApplication;
import cl.cutiko.estimodemo.R;

public class BeaconFragment extends Fragment {

    private RelativeLayout beaconContainer;
    private TextView beaconName, beaconDistance;

    public BeaconFragment() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mainView = inflater.inflate(R.layout.fragment_beacon, container, false);
        beaconContainer = (RelativeLayout) mainView.findViewById(R.id.beaconContainer);
        beaconName = (TextView) mainView.findViewById(R.id.beaconName);
        beaconDistance = (TextView) mainView.findViewById(R.id.beaconDistance);
        return mainView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    protected void beaconDataHandler(String key, double distance) {
        if (beaconContainer.getVisibility() == View.GONE) {
            beaconContainer.setVisibility(View.VISIBLE);
            beaconName.setText(key);
            beaconDistance.setText(String.valueOf(distance));
        } else {
            beaconDistance.setText(String.valueOf(distance));
        }
    }
}
