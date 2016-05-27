package cl.cutiko.estimodemo.views;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.cutiko.estimodemo.R;

public class BeaconFragment extends Fragment {

    private Coordinator coordinator;

    public BeaconFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_beacon, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        coordinator = (Coordinator) context;
    }
}
