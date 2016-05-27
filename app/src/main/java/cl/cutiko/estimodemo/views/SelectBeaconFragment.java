package cl.cutiko.estimodemo.views;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.cutiko.estimodemo.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class SelectBeaconFragment extends Fragment {

    private View mainView;

    public SelectBeaconFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mainView = inflater.inflate(R.layout.fragment_select_beacon, container, false);
        return mainView;
    }

    private void modalTrigger(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            }
        }, 3000);
    }

}
