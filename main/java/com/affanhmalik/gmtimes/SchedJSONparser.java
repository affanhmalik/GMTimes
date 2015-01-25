package com.affanhmalik.gmtimes;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Affan on 12/12/2014.
 */
public class SchedJSONparser {

    public static DataModel parseFeed(String content) throws JSONException {

//        List<DataModel> datalist = new ArrayList<>();

        DataModel sched = new DataModel();
        JSONObject data = new JSONObject(content);


        JSONArray times = data.getJSONArray("times");
        JSONObject fajr = times.getJSONObject(0);
        JSONObject zuhr = times.getJSONObject(1);
        JSONObject asr = times.getJSONObject(2);
        JSONObject maghrib = times.getJSONObject(3);
        JSONObject isha = times.getJSONObject(4);

        // Testing new method to get dynamic key values
        String[] one = getKeyValue(times.getJSONObject(0));
        String oneKey = one[0];
        String oneValue = one[1];





//        sched.setFajr(fajr.getString("fajr"));
        sched.setZuhr(zuhr.getString("zuhr"));
        sched.setAsr(asr.getString("asr"));
        sched.setMaghrib(maghrib.getString("maghrib"));
        sched.setIsha(isha.getString("isha"));
        sched.setTestKey(oneKey);
        sched.setTestValue(oneValue);

        /*JSONArray times = new JSONArray(data.getString("date"));

        JSONObject fajr = times.getJSONObject(0);
        JSONObject zuhr = times.getJSONObject(1);
        JSONObject asr = times.getJSONObject(2);
        JSONObject maghrib = times.getJSONObject(3);
        JSONObject isha = times.getJSONObject(4);

        sched.setFajr(fajr.getString("Fajr"));
        sched.setZuhr(zuhr.getString("Zuhr"));
        sched.setAsr(asr.getString("Asr"));
        sched.setMaghrib(maghrib.getString("Maghrib"));
        sched.setIsha(isha.getString("Isha"));*/

        return sched;
    }

    private static String[] getKeyValue(JSONObject obj) {

        String[] keyval = new String[2];
        Iterator<String> iter = obj.keys();
        if (iter.hasNext()) {
            String key = iter.next();
            Log.i("Key","This is the key: " + key);
            keyval[0] = key;
            try {
                String val = obj.getString(key);
                keyval[1] = val;
                Log.i("value","This is the value: " + val);
            } catch (JSONException e) {
                // Something went wrong!
            }
        }
        return keyval;
    }


}
