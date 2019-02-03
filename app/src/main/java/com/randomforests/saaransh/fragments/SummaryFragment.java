package com.randomforests.saaransh.fragments;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.randomforests.saaransh.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * A simple {@link Fragment} subclass.
 */
public class SummaryFragment extends Fragment {

    private String summary;
    TextView noteTextView;
    public SummaryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        summary = getActivity().getIntent().getStringExtra("raw_note");
        try {
            getSummary(summary);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_summary, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (summary!=null) {
            noteTextView = view.findViewById(R.id.notes_summary_text_view);
            noteTextView.setText(summary);
        }
    }



    private void getSummary(final String summary) throws IOException {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection urlConnection = null;
                InputStream inputStream = null;
                URL url = null;
                String jsonResponse;
                try {
                    url = new URL("http://192.168.137.1:5000/sum/" + summary);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                try {
                    urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setReadTimeout(10000 /* milliseconds */);
                    urlConnection.setConnectTimeout(15000 /* milliseconds */);
                    urlConnection.setRequestMethod("GET");
                    urlConnection.connect();

                    // If the request was successful (response code 200),
                    // then read the input stream and parse the response.
                    if (urlConnection.getResponseCode() == 200) {
                        inputStream = urlConnection.getInputStream();
                        jsonResponse = readFromStream(inputStream);
                        Log.d("from server::", jsonResponse);
                    } else {
                        Log.e("summaryfrag", "Error response code: " + urlConnection.getResponseCode());
                    }
                } catch (IOException e) {
                    Log.e("summaryfrag", "Problem retrieving the earthquake JSON results.", e);
                } finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                    if (inputStream != null) {
                        // Closing the input stream could throw an IOException, which is why
                        // the makeHttpRequest(URL url) method signature specifies than an IOException
                        // could be thrown.
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        });
    }
    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }

        return output.toString();
    }
}
