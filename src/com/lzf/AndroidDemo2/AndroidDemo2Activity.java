package com.lzf.AndroidDemo2;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.VideoView;

public class AndroidDemo2Activity extends Activity {

	private final int VIDEO1 = 11;
	private final int VIDEO2 = 12;
	private final int VIDEO3 = 13;
	private final int VIDEO0 = 10;
	private final int MUSIC1 = 21;
	private final int MUSIC2 = 22;
	private final int MUSIC3 = 23;
	private final int MUSIC0 = 20;

	private int i;

	private RelativeLayout.LayoutParams layoutParams;
	private VideoView videoView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// ≥ı ºªØ
		layoutParams = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.FILL_PARENT,
				RelativeLayout.LayoutParams.FILL_PARENT);
		layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

		videoView = (VideoView) findViewById(R.id.videoPlay);
		videoView.requestFocus();
		videoView.start();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(1, VIDEO1, 1, " ”∆µ1");
		menu.add(1, VIDEO2, 2, " ”∆µ2");
		menu.add(1, VIDEO3, 3, " ”∆µ3");
		menu.add(1, VIDEO0, 4, " ”∆µ∆¥Ω”≤•∑≈");
		menu.add(3, MUSIC1, 6, "“Ù∆µ1");
		menu.add(3, MUSIC2, 7, "“Ù∆µ2");
		menu.add(3, MUSIC3, 8, "“Ù∆µ3");
		menu.add(3, MUSIC0, 9, "“Ù∆µ∆¥Ω”≤•∑≈");
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case VIDEO1:
			play(new int[] { R.raw.v1 });
			break;
		case VIDEO2:
			play(new int[] { R.raw.v2 });
			break;
		case VIDEO3:
			play(new int[] { R.raw.v3 });
			break;
		case VIDEO0:
			play(new int[] { R.raw.v1, R.raw.v2, R.raw.v3 });
			break;
		case MUSIC1:
			play(new int[] { R.raw.m1 });
			break;
		case MUSIC2:
			play(new int[] { R.raw.m2 });
			break;
		case MUSIC3:
			play(new int[] { R.raw.m3 });
			break;
		case MUSIC0:
			play(new int[] { R.raw.m1, R.raw.m2, R.raw.m3 });
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	private void play(final int[] resouceId) {
		videoView.setLayoutParams(layoutParams);
		if (resouceId.length == 1) {
			videoView.setVideoURI(Uri.parse("android.resource://"
					+ getPackageName() + "/" + resouceId[0]));
			videoView.start();
		} else if (resouceId.length > 1) {
			//  ”∆µ∆¥Ω”
			i = 0;
			videoView.setVideoURI(Uri.parse("android.resource://"
					+ getPackageName() + "/" + resouceId[0]));
			videoView.start();
			videoView.setOnCompletionListener(new OnCompletionListener() {

				public void onCompletion(MediaPlayer mp) {
					if (i < resouceId.length - 1) {
						i++;
						videoView.setVideoURI(Uri.parse("android.resource://"
								+ getPackageName() + "/" + resouceId[i]));
						videoView.start();
					}
				}

			});
		}

	}
}