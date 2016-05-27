package cl.cutiko.estimodemo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import cl.cutiko.estimodemo.R;
import cl.cutiko.estimodemo.models.Beacon;

/**
 * Created by cutiko on 21-05-16.
 */
public class BeaconsAdapter extends ArrayAdapter<Beacon>{

    public BeaconsAdapter(Context context, int resource, List<Beacon> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater vi = LayoutInflater.from(parent.getContext());
        ViewHolder holder;
        if (convertView == null) {
            convertView = vi.inflate(R.layout.list_item_beacon ,parent,false);
            holder = new ViewHolder();
            holder.beaconKey = (TextView) convertView.findViewById(R.id.beaconKey);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Beacon beacon = (Beacon) getItem(position);

        holder.beaconKey.setText(beacon.getKey());

        return convertView;
    }

    private class ViewHolder {
        TextView beaconKey;
    }
}
