package com.example.b202_26.listsalon.ItemList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.b202_26.listsalon.MainActivity;
import com.example.b202_26.listsalon.R;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;

import static java.util.Arrays.*;

public class LoginActivity extends Activity {
    Button btnloginfacebook;
    Button btnlogin;
    EditText edtusername;
    EditText edtpass;
    CallbackManager callbackManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this.getApplicationContext());
        setContentView(R.layout.login);

//        AccessToken accessToken = AccessToken.getCurrentAccessToken();
//        boolean isLoggedIn = accessToken != null && !accessToken.isExpired();


        anhxa();
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnloginfacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginfacebook();
            }
        });


//        printHashKey(this);

    }

    private void anhxa() {
        btnlogin = (Button) findViewById(R.id.btn_login);
        edtpass = (EditText) findViewById(R.id.edt_pass);
        edtusername = (EditText) findViewById(R.id.edt_username);
        btnloginfacebook = (Button) findViewById(R.id.login_button);
    }


    public void printHashKey(Context pContext) {
        try {
            PackageInfo info = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String hashKey = new String(Base64.encode(md.digest(), 0));
                Log.i("qưereeeeee", "printHashKey() Hash Key: " + hashKey);
            }
        } catch (NoSuchAlgorithmException e) {
            Log.e("qưereeeeee", "printHashKey()", e);
        } catch (Exception e) {
            Log.e("qưereeeeee", "printHashKey()", e);
        }

    }

    public void loginfacebook() {
        callbackManager = CallbackManager.Factory.create();
        // Set permissions
//        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("email", "user_photos", "public_profile"));

        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        Intent intern = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intern);
//                        GraphRequest.newMeRequest(
//                                loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
//                                    @Override
//                                    public void onCompleted(JSONObject json, GraphResponse response) {
//                                        if (response.getError() != null) {
//                                            // handle error
//                                            System.out.println("ERROR");
//                                        } else {
//                                            System.out.println("Success");
//                                            try {
//
//                                                String jsonresult = String.valueOf(json);
//                                                System.out.println("JSON Result" + jsonresult);
//
//                                                String str_email = json.getString("email");
//                                                String str_id = json.getString("id");
//                                                String str_firstname = json.getString("first_name");
//                                                String str_lastname = json.getString("last_name");
//
//                                                Log.d("aadress", str_email + " " + str_firstname);
//
//                                            } catch (JSONException e) {
//                                                e.printStackTrace();
//                                            }
//                                        }
//                                    }
//
//                                }).executeAsync();
                    }

                    @Override
                    public void onCancel() {
                        Log.d("aadress111", "onCancel");
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        Log.d("aadress111", "onError");
                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
