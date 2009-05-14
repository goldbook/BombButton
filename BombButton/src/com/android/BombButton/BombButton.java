package com.android.BombButton;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class BombButton extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// ボタンを作る
		Button bButton = (Button) findViewById(R.id.bButton);

		//メディアプレイヤー
		final MediaPlayer mp = MediaPlayer.create(this, R.raw.sound);

		// クリックされた時のイベント　cf.http://www.javadrive.jp/android/button/index3.html
		bButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				mp.seekTo(0);	//0秒へ戻る。連打対策
				mp.start();		//再生開始
			}
		});

	}
}