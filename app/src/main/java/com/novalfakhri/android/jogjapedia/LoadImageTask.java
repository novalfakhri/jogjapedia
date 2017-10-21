package com.novalfakhri.android.jogjapedia;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;

/**
 * Created by Toshiba on 8/12/2017.
 */

public class LoadImageTask extends AsyncTask<String, Void, Bitmap> {

    private ImageView bitMapImage;

    public LoadImageTask(ImageView bitMapImage) {
        this.bitMapImage = bitMapImage;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        String urldisplay = params[0];
        Bitmap bitMap = null;
        try {
            InputStream inputStream = new java.net.URL(urldisplay).openStream();
            bitMap = BitmapFactory.decodeStream(inputStream);
            inputStream.close();

        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return bitMap;
    }

    protected void onPostExecute(Bitmap result) {
        bitMapImage.setImageBitmap(result);
    }

}