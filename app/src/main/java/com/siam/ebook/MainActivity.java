package com.siam.ebook;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnErrorListener;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;

public class MainActivity extends AppCompatActivity {

    PDFView PDF;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PDF = findViewById(R.id.pdfView);

        PDF.fromAsset("book.pdf")
                .enableSwipe(true)
                .defaultPage(0)
                .swipeHorizontal(true)
                .onLoad(new OnLoadCompleteListener() {
                    @Override
                    public void loadComplete(int i) {
                        Toast.makeText(MainActivity.this, "onLoad", Toast.LENGTH_SHORT).show();
                    }
                })
                .onError(new OnErrorListener() {
                    @Override
                    public void onError(Throwable throwable) {
                        Toast.makeText(MainActivity.this, "onError", Toast.LENGTH_SHORT).show();
                    }
                })
                .load();


    }
}