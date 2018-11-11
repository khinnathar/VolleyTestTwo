package com.khin.volleytesttwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Response.ErrorListener, Response.Listener<String> {
    TextView tvResponse;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResponse=(TextView)findViewById(R.id.tvResponse);
        button=(Button)findViewById(R.id.btnShow);


        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        String url="https://www.google.com";
        StringRequest stringRequest=new StringRequest(Request.Method.GET,url, (Response.Listener<String>) this,this);
        requestQueue.add(stringRequest);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        tvResponse.setText("this do not work");
    }

    @Override
    public void onResponse(String response) {
        tvResponse.setText("Response is: "+ response.substring(0,500));

    }
}
