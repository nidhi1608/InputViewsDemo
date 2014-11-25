package com.example.inputviewsdemo;

import org.apache.http.Header;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;


public class MainActivity extends Activity {
	//ProgressBar progress;
	Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS); 
        setContentView(R.layout.activity_main);
        //progress = (ProgressBar) findViewById(R.id.progressBar1);
        btn = (Button) findViewById(R.id.button1);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    public void onGo(View v) {
    	//progress.setVisibility(View.VISIBLE);
    	setProgressBarIndeterminateVisibility(true); 
    	btn.setVisibility(View.INVISIBLE);
    	
    	AsyncHttpClient client = new AsyncHttpClient();
    	client.get("http://yahoo.com", new AsyncHttpResponseHandler() {
			
			@Override
			public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
				Toast.makeText(getBaseContext(), "Done", Toast.LENGTH_LONG).show();
				//progress.setVisibility(View.INVISIBLE);	
				setProgressBarIndeterminateVisibility(false); 
				btn.setVisibility(View.VISIBLE);
			}
			
			@Override
			public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
				// TODO Auto-generated method stub
				Toast.makeText(getBaseContext(), "fail", Toast.LENGTH_LONG).show();
			}
		});
    }
}
