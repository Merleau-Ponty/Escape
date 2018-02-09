package technique;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.LinkedHashMap;

/**
 * Created by sarradin on 05/02/2018.
 */

public class HashMapAdapter extends BaseAdapter {

    private LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
    private String[] mapKeys;

    //Constructeur de l'Adapteur pour HashMap
    //sera utile pour le classement : afficher le nom de l'équipe + le score
    public HashMapAdapter(LinkedHashMap<String, String> data){
        map  = data;
        mapKeys = map.keySet().toArray(new String[data.size()]);
    }

    @Override
    public int getCount() {
        return map.size();
    }

    @Override
    public Object getItem(int position) {
        return map.get(mapKeys[position]);
    }

    @Override
    public long getItemId(int arg0) {
        return arg0;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        String key = mapKeys[pos];
        String Value = getItem(pos).toString();


        return convertView;
    }
}
