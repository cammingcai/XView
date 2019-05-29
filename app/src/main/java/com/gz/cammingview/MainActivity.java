package com.gz.cammingview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private CanvasView canvasView;
    private Button btn;
    private CammingView cammingView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        canvasView = findViewById(R.id.canvas);
        cammingView = findViewById(R.id.cv);
        btn = findViewById(R.id.btn);
        this.canvasView.setDrawer(CanvasView.Drawer.PEN);               // Use Pen Tool
//        this.canvasView.setDrawer(CanvasView.Drawer.LINE);              // Draw Line
//        this.canvasView.setDrawer(CanvasView.Drawer.RECTANGLE);         // Draw Rectangle
//        this.canvasView.setDrawer(CanvasView.Drawer.CIRCLE);            // Draw Circle
//        this.canvasView.setDrawer(CanvasView.Drawer.ELLIPSE);           // Draw Ellipse (Oval)
//        this.canvasView.setDrawer(CanvasView.Drawer.QUADRATIC_BEZIER);  // Draw Quadratic Bezier


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  cammingView.setImageBitmap(canvasView.getBitmap());\
                canvasView.setMode(CanvasView.Mode.ERASER);
                Log.i("aaaaaa",canvasView.getMode()+"");

            }
        });

    }
}
