package com.alsh.from0to9;

import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.alsh.from0to9.R;

public class Main5Activity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main5);

    WebView myWebView = (WebView) findViewById( R.id.webview );
    WebSettings ws = myWebView.getSettings();
    ws.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
    ws.setJavaScriptEnabled(true);
    ws.setJavaScriptCanOpenWindowsAutomatically(true);

//    Display display = getWindowManager().getDefaultDisplay();
//    Point size = new Point();
//    display.getSize(size);

    DisplayMetrics displayMetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
    //int height = displayMetrics.heightPixels;
    //int width = displayMetrics.widthPixels;

//    String width = Integer.toString(size.x);
//    String height = Integer.toString(size.y);

    String width = Integer.toString(displayMetrics.widthPixels/2,1);
    String height = Integer.toString(displayMetrics.heightPixels/2,1);

    Log.d("YouTube",width+"x"+height);
//    String playVideo= "<html><body><iframe width=\""+width+"\" height=\"" + height + "\" src=\"https://www.youtube.com/embed/HdG2XVd92Fc?rel=0&amp;controls=0&amp;showinfo=0?ecver=1\" frameborder=\"0\" allowfullscreen></iframe></body></html>";

    String playVideo= "<html><body><iframe width=\"100%\" height=\"98%\" src=\"https://www.youtube.com/embed/HdG2XVd92Fc?rel=0&amp;controls=0&amp;showinfo=0?ecver=1\" frameborder=\"0\" allowfullscreen></iframe></body></html>";

    myWebView.loadData(playVideo, "text/html", "utf-8");
  }

  @Override
  protected void onStop() {
    super.onStop();
    this.finish();
  }

  @Override
  public void onBackPressed() {
    Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
    startActivity(intent);
    onStop();
  }
}
