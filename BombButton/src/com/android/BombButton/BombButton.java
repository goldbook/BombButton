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
		
        //�{�^��������ĕ����ƃN���b�N���̏�����ݒ�
    	Button bButton = (Button)findViewById(R.id.bButton);
        
        /*XML�Œ�`�����v���O�����̒��ł���ꍇ
        Button bButton = new Button(this);
    	bButton.setText("��������I");
    	*/

        //MediaPlayer�I�u�W�F�N�gmp������Ă���
        //final�C�����Ȃ���onClick����Q�Ƃł��Ȃ��炵��
        //R.raw.sound�́ures/raw�v�ɓ��ꂽWave�t�@�C���B
        //raw����sound�Ƃ������O��wave�t�@�C����u���Γ����͂�
       	final MediaPlayer mp = MediaPlayer.create(this, R.raw.sound);
        
    	//�N���b�N���̏������`�@cf.http://www.javadrive.jp/android/button/index3.html
       	//�o�[�W����1.0��SDK�ł�start();�̒���prepare();���܂܂��A�炵���@�h�L�������g�Q��
       	bButton.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		mp.seekTo(0);				//�A�ő΍�Ƃ��Ĕ�������0�b�ɖ߂�
        		mp.start();					//�������X�^�[�g
            }
        });
       	
        }
}