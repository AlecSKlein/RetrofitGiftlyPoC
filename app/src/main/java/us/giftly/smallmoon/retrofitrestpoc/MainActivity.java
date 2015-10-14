package us.giftly.smallmoon.retrofitrestpoc;

import android.app.ProgressDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import models.User;
import models.UserResult;
import rest.RestClient;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;


public class MainActivity extends ActionBarActivity {

    private UserAdapter adapter;
    List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView = (ListView) findViewById(R.id.listView);
        users = new ArrayList<User>();
        System.out.println("Before dialog");
        final ProgressDialog dialog = ProgressDialog.show(this, "", "loading...");
        RestClient.GiftlyApiInterface service = RestClient.getClient();
        Call<User> callAlso = service.registerUser(new User("Alec@gmail.com", "Alec", "Klein", "password"));
        callAlso.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Response<User> response) {
                dialog.dismiss();
                Log.d("MainActivity", "Status Code = " + response.code());
                System.out.println("Dialog dismissed, success?");
                if (response.isSuccess()) {
                    System.out.println("Success");
                }
            }

            @Override
            public void onFailure(Throwable t) {
                dialog.dismiss();
                System.out.println("Dialog dismissed, failure");
                System.out.println(t.toString());
            }
        });
/*
        Call<UserResult> call = service.getUsers();
        call.enqueue(new Callback<UserResult>() {
            @Override
            public void onResponse(Response<UserResult> response) {
                dialog.dismiss();
                Log.d("MainActivity", "Status Code = " + response.code());
                if (response.isSuccess()) {
                    System.out.println("Success");

                    // request successful (status code 200, 201)
                    UserResult result = response.body();
                    System.out.println("response = " + new Gson().toJson(result));
                    //users = result.getUsers();
                    //Log.d("MainActivity", "Items = " + users.size());
                    //adapter = new UserAdapter(MainActivity.this, users);
                    //listView.setAdapter(adapter);

                } else {
                    // response received but request not successful (like 400,401,403 etc)
                    //Handle errors
                }
            }

            @Override
            public void onFailure(Throwable t) {
                dialog.dismiss();
                System.out.println("Dialog dismissed, failure");
                System.out.println(t.toString());
            }
        });
*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
