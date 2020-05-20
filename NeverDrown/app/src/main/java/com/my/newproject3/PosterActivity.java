package com.my.newproject3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.graphics.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.text.*;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.SeekBar;
import android.webkit.WebView;
import android.webkit.WebSettings;
import java.util.Timer;
import java.util.TimerTask;

public class PosterActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private Toolbar _toolbar;
	private double x = 0;
	private double y = 0;
	private double p = 0;
	
	private LinearLayout linear7;
	private ScrollView vscroll7;
	private LinearLayout linear17;
	private LinearLayout linear18;
	private TextView textview1;
	private LinearLayout linear19;
	private LinearLayout linear20;
	private SeekBar seekbar1;
	private TextView textview2;
	private WebView webview3;
	
	private TimerTask timer;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.poster);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		_toolbar = (Toolbar) findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		vscroll7 = (ScrollView) findViewById(R.id.vscroll7);
		linear17 = (LinearLayout) findViewById(R.id.linear17);
		linear18 = (LinearLayout) findViewById(R.id.linear18);
		textview1 = (TextView) findViewById(R.id.textview1);
		linear19 = (LinearLayout) findViewById(R.id.linear19);
		linear20 = (LinearLayout) findViewById(R.id.linear20);
		seekbar1 = (SeekBar) findViewById(R.id.seekbar1);
		textview2 = (TextView) findViewById(R.id.textview2);
		webview3 = (WebView) findViewById(R.id.webview3);
		webview3.getSettings().setJavaScriptEnabled(true);
		webview3.getSettings().setSupportZoom(true);
		
		seekbar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged (SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				timer = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								x = seekbar1.getProgress();
							}
						});
					}
				};
				_timer.schedule(timer, (int)(2));
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				y = seekbar1.getProgress();
				if (y > x) {
					p++;
					if (p == 9) {
						p = 1;
					}
					_pos();
				}
				else {
					if (x > y) {
						p--;
						if (p == 0) {
							p = 8;
						}
						_pos();
					}
				}
			}
		});
		
		webview3.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageStarted(WebView _param1, String _param2, Bitmap _param3) {
				final String _url = _param2;
				
				super.onPageStarted(_param1, _param2, _param3);
			}
			
			@Override
			public void onPageFinished(WebView _param1, String _param2) {
				final String _url = _param2;
				
				super.onPageFinished(_param1, _param2);
			}
		});
	}
	private void initializeLogic() {
		p = 1;
		_pos();
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	private void _pos () {
		if (p == 1) {
			linear19.setBackgroundResource(R.drawable.a11);
		}
		if (p == 2) {
			linear19.setBackgroundResource(R.drawable.a22);
		}
		if (p == 3) {
			linear19.setBackgroundResource(R.drawable.a33);
		}
		if (p == 4) {
			linear19.setBackgroundResource(R.drawable.a44);
		}
		if (p == 5) {
			linear19.setBackgroundResource(R.drawable.a57);
		}
		if (p == 6) {
			linear19.setBackgroundResource(R.drawable.a66);
		}
		if (p == 7) {
			linear19.setBackgroundResource(R.drawable.a77);
		}
		if (p == 8) {
			linear19.setBackgroundResource(R.drawable.a89);
		}
		if (p == 9) {
			linear19.setBackgroundResource(R.drawable.a99);
		}
	}
	
	
	private void _post () {
		
	}
	
	
	private void _pic () {
		
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}
