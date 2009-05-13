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
		
        //ボタンを作って文字とクリック時の処理を設定
    	Button bButton = (Button)findViewById(R.id.bButton);
        
        /*XMLで定義せずプログラムの中でする場合
        Button bButton = new Button(this);
    	bButton.setText("爆発しろ！");
    	*/

        //MediaPlayerオブジェクトmpを作っておく
        //final修飾しないとonClickから参照できないらしい
        //R.raw.soundは「res/raw」に入れたWaveファイル。
        //raw内にsoundという名前のwaveファイルを置けば動くはず
       	final MediaPlayer mp = MediaPlayer.create(this, R.raw.sound);
        
    	//クリック時の処理を定義　cf.http://www.javadrive.jp/android/button/index3.html
       	//バージョン1.0のSDKではstart();の中にprepare();が含まれる、らしい　ドキュメント参照
       	bButton.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		mp.seekTo(0);				//連打対策として爆発音の0秒に戻す
        		mp.start();					//爆発音スタート
            }
        });
       	
        }
}