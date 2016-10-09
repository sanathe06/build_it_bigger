package com.sanath.builditbigger;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.sanath.joke.JokeActivity;
import com.sanath.joke.backend.jokeApi.JokeApi;

import java.io.IOException;

/**
 * Created by sanathnandasiri on 10/8/16.
 */
public class JokeFetchingTask extends AsyncTask<Void, Void, String> {

    private final String TAG = this.getClass().getSimpleName();
    private final Context context;

    private JokeApi jokeApi = null;
    private ProgressDialog progressDialog;

    JokeFetchingTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        showProgress();
    }

    @Override
    protected String doInBackground(Void... voids) {
        if (jokeApi == null) {
            JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });
            jokeApi = builder.build();
        }
        try {
            return jokeApi.getJoke().execute().getData();
        } catch (Exception e) {
            Log.e(TAG, "doInBackground: return error while retrieving joke from api", e);
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        hideProgress();
        if (result != null) {
            Intent intentJoke = new Intent(context, JokeActivity.class);
            intentJoke.putExtra(JokeActivity.INTENT_ARGS_JOKE, result);
            context.startActivity(intentJoke);
        }
    }

    private void hideProgress() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    private void showProgress() {
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(context.getString(R.string.loading_msg));
        progressDialog.show();
    }
}
