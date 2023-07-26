package com.example.textile_app;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

public class rfunction extends AsyncTask<String, Void, String> {

    Context context;
    AlertDialog alertDialog;

    rfunction(Context context) {
        this.context = context;
    }


    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String registrationURL = "http://192.168.254.5/textile/registration.php";
        if (type.equals("Registration")) {
            try {
                String firmname = params[1];
                String gst = params[2];
                String firstname = params[3];
                String lastname = params[4];
                String email = params[5];
                String phonenumber = params[6];
                String password = params[7];
                String cpassword = params[8];
                String pancard = params[9];
                String address = params[10];
                String pincode = params[11];
                String dob = params[12];
                String doa = params[13];

                URL url = new URL(registrationURL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String postData = URLEncoder.encode("firmname", "UTF-8") + "=" + URLEncoder.encode(firmname, "UTF-8") + "&" +
                        URLEncoder.encode("gst", "UTF-8") + "=" + URLEncoder.encode(gst, "UTF-8") + "&" +
                        URLEncoder.encode("firstname", "UTF-8") + "=" + URLEncoder.encode(firstname, "UTF-8") + "&" +
                        URLEncoder.encode("lastname", "UTF-8") + "=" + URLEncoder.encode(lastname, "UTF-8") + "&" +
                        URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&" +
                        URLEncoder.encode("phonenumber", "UTF-8") + "=" + URLEncoder.encode(phonenumber, "UTF-8") + "&" +
                        URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8") + "&" +
                        URLEncoder.encode("cpassword", "UTF-8") + "=" + URLEncoder.encode(cpassword, "UTF-8") + "&" +
                        URLEncoder.encode("pancard", "UTF-8") + "=" + URLEncoder.encode(pancard, "UTF-8") + "&" +
                        URLEncoder.encode("address", "UTF-8") + "=" + URLEncoder.encode(address, "UTF-8") + "&" +
                        URLEncoder.encode("pincode", "UTF-8") + "=" + URLEncoder.encode(pincode, "UTF-8") + "&" +
                        URLEncoder.encode("dob", "UTF-8") + "=" + URLEncoder.encode(dob, "UTF-8") + "&" +
                        URLEncoder.encode("doa", "UTF-8") + "=" + URLEncoder.encode(doa, "UTF-8");


                bufferedWriter.write(postData);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                String result = "";
                String line = "";

                while ((line = bufferedReader.readLine()) != null) {
                    result = result + line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Registration status");
    }

    @Override
    protected void onPostExecute(String result) {
        if (result.equals("registration successful")) {
            alertDialog.setMessage(result);
            alertDialog.setButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    Intent intent = new Intent(context, login.class);
                    context.startActivity(intent);

                }
            });
            alertDialog.show();
//            Intent intent = new Intent(context, login.class);
//            context.startActivity(intent);


        } else {
            alertDialog.setMessage(result);
            alertDialog.setButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    alertDialog.dismiss();
                }
            });
            alertDialog.show();
        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}

