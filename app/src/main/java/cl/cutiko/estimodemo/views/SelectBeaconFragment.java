package cl.cutiko.estimodemo.views;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cl.cutiko.estimodemo.R;
import cl.cutiko.estimodemo.adapters.BeaconsAdapter;
import cl.cutiko.estimodemo.models.Beacon;


/**
 * A simple {@link Fragment} subclass.
 */
public class SelectBeaconFragment extends Fragment {

    private Coordinator coordinator;
    private Dialog modal;
    private BeaconsAdapter beaconsAdapter;
    private List<Beacon> beacons = new ArrayList<>();
    private List<String> validation = new ArrayList<>();

    public SelectBeaconFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        setModal();
        modalTrigger();

        return inflater.inflate(R.layout.fragment_select_beacon, container, false);
    }

    private void setModal(){
        modal = new Dialog(getContext());
        modal.requestWindowFeature(Window.FEATURE_NO_TITLE);
        modal.setCancelable(false);
        modal.setContentView(R.layout.modal_selection_beacon);

        ListView listView = (ListView) modal.findViewById(R.id.modalBeaconList);
        beaconsAdapter = new BeaconsAdapter(getContext(), R.layout.list_item_beacon, beacons);
        listView.setAdapter(beaconsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                coordinator.beaconSelected(beaconsAdapter.getItem(position).getKey());
                modal.dismiss();
            }
        });

    }

    private void modalTrigger(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                coordinator.modalTriggered();
                modal.show();
            }
        }, 3000);
    }

    protected void refreshAdapter(String key) {
        if (!validation.contains(key)) {
            validation.add(key);
            beacons.add(new Beacon(key));
            beaconsAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        coordinator = (Coordinator) context;
    }
}
