package com.example.davidarisz.restaurant;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CategoriesRequest implements Response.Listener<JSONObject>, Response.ErrorListener {
    Context context;
    Callback activity;

    public interface Callback {
        void gotCategories(ArrayList<String> categories);
        void gotCategoriesError(String message);
    }

    public CategoriesRequest(Context con) {
        context = con;
    }

    public void getCategories(Callback activity) {
        String url = "https://resto.mprog.nl/categories";
        RequestQueue queue = Volley.newRequestQueue(context);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, this, this);
        queue.add(jsonObjectRequest);

        this.activity = activity;
    }

    public void getMenus(Callback activity) {
        String url = "https://resto.mprog.nl/menu";
        RequestQueue queue = Volley.newRequestQueue(context);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, this, this);
        queue.add(jsonObjectRequest);

        this.activity = activity;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        if (error.getMessage() == null)
            Toast.makeText(context, "Timeout error :(", Toast.LENGTH_SHORT).show();
        else Toast.makeText(context, "Timeout error :(", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResponse(JSONObject response) {

        Log.d("response", response.toString());
        JSONArray values;
        ArrayList arrayList = new ArrayList();

        try {
            values = response.getJSONArray("categories");

            for (int i = 0; i < values.length(); i++) {
//                String categories = (values.get(i)).toString();
                String categories = values.getString(i);

                arrayList.add(categories);
                Log.d("category", categories);
            }

            activity.gotCategories(arrayList);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
