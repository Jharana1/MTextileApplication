package com.example.textile_app;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
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

public class addFunction extends AsyncTask<String, Void, String> {

    Context context;
    AlertDialog alertDialog;
    public static String PREFS_NAME ="MyPrefsFile";



    public  addFunction(Context context)
    {
        this.context = context;
    }


    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String addURL = "http://192.168.254.5/textile/addcart.php";
        if(type.equals("Add"))
        {
            try {
                String catalogue = params[1];
                String design = params[2];
                String image = params[3];
                String email = params[4];
                URL url = new URL(addURL);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String postData = URLEncoder.encode("catalogue","UTF-8")+"="+URLEncoder.encode(catalogue,"UTF-8")+"&"+
                        URLEncoder.encode("design","UTF-8")+"="+URLEncoder.encode(design,"UTF-8")+"&"+
                        URLEncoder.encode("image","UTF-8")+"="+URLEncoder.encode(image,"UTF-8")+"&"+
                        URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8");
                bufferedWriter.write(postData);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
                String result = "";
                String line = "";

                while((line = bufferedReader.readLine())!=null)
                {
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
        alertDialog.setTitle("Add to cart status");
    }

    @Override
    protected void onPostExecute(String result)
    {
        if (result.equals("Added to cart")) {
            alertDialog.setMessage(result);
            alertDialog.show();
//            Intent intent = new Intent(context, MainActivity.class);
//            context.startActivity(intent);

        } else {
            alertDialog.setMessage("Try again");
            alertDialog.show();
        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}


