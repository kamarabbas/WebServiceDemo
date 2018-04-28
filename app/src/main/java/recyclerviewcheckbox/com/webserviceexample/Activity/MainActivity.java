package recyclerviewcheckbox.com.webserviceexample.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.androidnetworking.AndroidNetworking;

import recyclerviewcheckbox.com.webserviceexample.R;

public class MainActivity extends AppCompatActivity {

    private Button btnPostExample,btnGetExample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        AndroidNetworking.initialize(getApplicationContext());


        btnGetExample = findViewById( R.id.btnGetExample );
        btnPostExample = findViewById( R.id.btnPostExample );

        btnPostExample.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent( MainActivity.this,PostAPIActivity.class );
                startActivity( intent );
            }
        } );

        btnGetExample.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this,GetAPIActivity.class );
                startActivity( intent );
            }
        } );

    }
}
