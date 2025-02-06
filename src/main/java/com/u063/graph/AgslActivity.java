package com.u063.graph;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RuntimeShader;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.u063.graph.agsl.RuntimeShaderCreator;

public class AgslActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(new draw(this));
    }
    class draw extends View{
        public draw(Context context) {
            super(context);
        }
        @Override
        @SuppressLint({"NewApi", "LocalSuppress,DrawAllocation"})
        protected void onDraw(Canvas canvas){
            Paint paint = new Paint();
            RuntimeShaderCreator runtimeShaderCreator = new RuntimeShaderCreator(this.getResources().openRawResource(R.raw.graph));
            RuntimeShader runtimeShader = new RuntimeShader(runtimeShaderCreator.getRes());
            float[] graphInt = new float[512];
            for(int i=0; i<512; i++){
                graphInt[i]=i;
            }

            runtimeShader.setFloatUniform("graphInt",graphInt);
            runtimeShader.setIntUniform("wx",getWidth());
            runtimeShader.setIntUniform("wy",getHeight());
            paint.setShader(runtimeShader);
            canvas.drawPaint(paint);
        }
    }
}
