package recyclerviewcheckbox.com.webserviceexample.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import recyclerviewcheckbox.com.webserviceexample.Model.GetCreditCardModel;
import recyclerviewcheckbox.com.webserviceexample.R;

public class PostAPIActivity extends AppCompatActivity {

    private Button btnUsingGson,btnGetManual;
    private ArrayList<GetCreditCardModel.DataBean> alCrediCard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_post_api );

        getIds();
        setListner();



    }

    private void setListner() {
        btnUsingGson.setOnClickListener( onClickListener );
        btnGetManual.setOnClickListener( onClickListener );
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnGetManual:
                    callForgotPassword();
                    break;
                case R.id.btnUsingGson:
                    callGetCrediCard();
                    break;
            }
        }
    };

    private void callGetCrediCard() {
        try {
            JSONObject objectCreditCard = new JSONObject();
            objectCreditCard.put( "UserId", "85893");
            objectCreditCard.put( "Mode", "ChechCreditCardDetails");


            AndroidNetworking.post("YOUR LIVE URL")
                    .addJSONObjectBody(objectCreditCard) // posting json
                    .setTag("test")
                    .setPriority( Priority.HIGH)
                    .build()
                    .getAsJSONObject(new JSONObjectRequestListener() {
                        @Override
                        public void onResponse(JSONObject response) {

//                            //Manuall get Data
//                            try {
//                                JSONArray arrayData = response.getJSONArray( "data" );
//
//                                for (int i = 0; i <arrayData.length() ; i++) {
//                                    JSONObject object = arrayData.getJSONObject(i);
//                                    String strtExp = object.getString( "Expiry");
//                                }
//                            }catch (Exception e){
//                                e.printStackTrace();
//                            }
//
//
                            //Using GSON library.
                            GetCreditCardModel creditCardModel = new Gson().fromJson(String .valueOf(response),GetCreditCardModel.class);
                            alCrediCard = new ArrayList<>();
                            alCrediCard.addAll( creditCardModel.getData());

                        }
                        @Override
                        public void onError(ANError error) {
                            // handle error
                        }
                    });

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void callForgotPassword() {
        try {
            JSONObject objectForgotPassword = new JSONObject();
            objectForgotPassword.put( "Email", "sakib@gmail.com");

            AndroidNetworking.post("YOUR LIVE URL")
                    .addJSONObjectBody(objectForgotPassword) // posting json
                    .setTag("test")
                    .setPriority( Priority.HIGH)
                    .build()
                    .getAsJSONObject(new JSONObjectRequestListener() {
                        @Override
                        public void onResponse(JSONObject response) {
                            // do anything with response

                            try {
                                String message = response.getString( "message");
                                Toast.makeText( PostAPIActivity.this,message ,Toast.LENGTH_LONG ).show();


                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }
                        @Override
                        public void onError(ANError error) {
                            // handle error
                        }
                    });

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    private void getIds() {
        btnGetManual = findViewById( R.id.btnGetManual );
        btnUsingGson = findViewById( R.id.btnUsingGson );
    }



}
