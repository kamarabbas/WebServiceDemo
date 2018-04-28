package recyclerviewcheckbox.com.webserviceexample.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import recyclerviewcheckbox.com.webserviceexample.Model.ArticleModel;
import recyclerviewcheckbox.com.webserviceexample.Model.DetailsModel;
import recyclerviewcheckbox.com.webserviceexample.R;

public class GetAPIActivity extends AppCompatActivity {

    private List<DetailsModel.ContactsBean> alDetails;
    private Button btnGetArticle, btnGetDetail;
    private List<ArticleModel.ArticleListBean> alArticle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_get_api );

        getIds();
        setListner();

    }

    private void setListner() {
        try {
            btnGetDetail.setOnClickListener( onClickListener );
            btnGetArticle.setOnClickListener( onClickListener );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getIds() {
        try {
            btnGetDetail = findViewById( R.id.btnGetDetail );
            btnGetArticle = findViewById( R.id.btnGetArticle );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnGetDetail:
                    callDetails();
                    break;
                case R.id.btnGetArticle:
                    callGetArticleDetails();
                    break;

            }
        }
    };

    private void callGetArticleDetails() {
        try {
            AndroidNetworking.get( "http://hmkcode.appspot.com/rest/controller/get.json" )
                    .setTag( "test" )
                    .setPriority( Priority.HIGH )
                    .build()
                    .getAsJSONObject( new JSONObjectRequestListener() {
                        @Override
                        public void onResponse(JSONObject response) {

                            ArticleModel articleListBean = new Gson().fromJson( String.valueOf( response ), ArticleModel.class );

                            alArticle = new ArrayList<>();
                            alArticle.addAll( articleListBean.getArticleList() );

                            for (int i = 0; i < alArticle.size(); i++) {
                                Log.e( "", "name is" + alArticle.get( i ).getTitle() );

                                Toast.makeText( GetAPIActivity.this,"Title is " + alArticle.get( i ).getTitle(), Toast.LENGTH_LONG ).show();


                            }

                        }

                        @Override
                        public void onError(ANError anError) {

                        }
                    } );


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void callDetails() {
        try {
            AndroidNetworking.get( "https://api.androidhive.info/contacts/" )
                    .setPriority( Priority.HIGH )
                    .build()
                    .getAsJSONObject( new JSONObjectRequestListener() {
                        @Override
                        public void onResponse(JSONObject response) {

                            DetailsModel detailsModel = new Gson().fromJson( String.valueOf( response ), DetailsModel.class );

                            alDetails = new ArrayList<>();
                            alDetails.addAll( detailsModel.getContacts() );

                            for (int i = 0; i < alDetails.size(); i++) {
                                Log.e( "", "name is" + alDetails.get( i ).getName() );
                            }

                        }

                        @Override
                        public void onError(ANError anError) {

                        }
                    } );


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
