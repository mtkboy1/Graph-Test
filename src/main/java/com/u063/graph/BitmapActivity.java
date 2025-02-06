package com.u063.graph;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class BitmapActivity extends AppCompatActivity {
    Bitmap bm;
    ArrayList<Integer> graphInt = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.bitmap_activity);
        bm = Bitmap.createBitmap(1920,1080, Bitmap.Config.ARGB_8888);
        payLoad();
        createGraph();
        ImageView img = findViewById(R.id.graph);
        img.setImageBitmap(bm);
    }
    public void payLoad(){
        for(int i=0; i<512; i++){
            graphInt.add(i);
        }
    }
    private void createGraph(){
        int large = 0;
        for(int i=0; i<graphInt.size(); i++){
            if(large<graphInt.get(i)){
                large=graphInt.get(i);
            }
        }
        float stepy = (float) bm.getHeight() /large;
        float stepx = (float) bm.getWidth()/graphInt.size();
        for(int i=0; i<graphInt.size(); i++){
            for(float x=i*stepx; x<(i+1)*stepx; x++){
                for(float y=0; y<stepy*graphInt.get(i); y++){
                    bm.setPixel((int) Math.abs(x),(int) Math.abs(bm.getHeight()-1-y), Color.BLACK);
                    //Log.e("",""+x+" . "+y);
                }
            }
        }
    }
}
