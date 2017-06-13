package com.sinapsissoft.video;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.MediaController;
import android.widget.VideoView;

import com.sinapsissoft.video.class_app.General;
import com.sinapsissoft.video.dto.DtoVideo;

public class VideoFullScreenActivity extends AppCompatActivity {
    private VideoView videoView;
    private DtoVideo dtoVideo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_full_screen);
        loadView();
    }
    private void loadView(){
        dtoVideo=General.DTO_VIDEO;
        loadVideo();
    }

    private void loadVideo() {
        videoView = (VideoView)findViewById(R.id.full_video);
        videoView.setMediaController(new MediaController(this));
        videoView.setVideoURI(Uri.parse(dtoVideo.getsUri()));
        videoView.seekTo(General.iSECONDS);
        videoView.start();

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            General.iSECONDS = videoView.getCurrentPosition();
        }
        return super.onKeyDown(keyCode, event);
    }

}
