package com.u063.graph.agsl;

import android.content.res.Resources;
import android.graphics.RuntimeShader;

import com.u063.graph.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RuntimeShaderCreator {
    private RuntimeShader runtimeShader;
    private int id;
    private String res = "";
    private BufferedReader inp;
    public RuntimeShaderCreator(InputStream inputStream){
        this.id = id;
        inp = new BufferedReader(new InputStreamReader(inputStream));
    }
    public String getRes(){
        Resources resources = Resources.getSystem();
        //BufferedReader inp = new BufferedReader(new InputStreamReader(resources.openRawResource(R.raw.graph)));
        String str = "";
        while (true) {
            try {
                if ((str = inp.readLine()) == null) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            res+=str;
        }
        return res;
    }
}
