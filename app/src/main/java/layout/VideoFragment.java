package layout;


import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.sinapsissoft.video.R;
import com.sinapsissoft.video.VideoFullScreenActivity;
import com.sinapsissoft.video.class_app.General;
import com.sinapsissoft.video.dto.DtoVideo;

public class VideoFragment extends Fragment implements View.OnClickListener {

    private VideoView videoView;
    private View view;
    private DtoVideo dtoVideo;
    private ImageView btnImageFullScreen;

    public VideoFragment() {
        // Required empty public constructor
        this.dtoVideo = General.DTO_VIDEO;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_video, container, false);
        loadView();
        loadVideo();
        return view;
    }
    private void loadView(){
        btnImageFullScreen=(ImageView)view.findViewById(R.id.btnImageFullScreen);
        btnImageFullScreen.setOnClickListener(this);
    }

    private void loadVideo() {
        videoView = (VideoView) view.findViewById(R.id.fragment_video);
        videoView.setMediaController(new MediaController(getActivity()));
        videoView.setOnClickListener(this);
        videoView.setVideoURI(Uri.parse(dtoVideo.getsUri()));
        videoView.seekTo(General.iSECONDS);
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(dtoVideo.isbLooping());
            }
        });
        if (dtoVideo.isbStartPlay()) {
            videoView.start();
        } else {
            videoView.pause();
        }

    }
    @Override
    public void onPause() {
        super.onPause();
        General.iSECONDS = videoView.getCurrentPosition();
    }

    @Override
    public void onResume() {
        super.onResume();
        loadVideo();
    }


    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btnImageFullScreen:

                Intent intent=new Intent(getActivity(), VideoFullScreenActivity.class);
                General.iSECONDS=videoView.getCurrentPosition();
                startActivity(intent);

                break;
        }
    }

}
