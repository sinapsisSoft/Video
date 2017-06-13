package com.sinapsissoft.video.dto;

/**
 * Created by DIEGOH on 6/13/2017.
 */

public class DtoVideo {
    private String sUri;
    private boolean bLooping;
    private boolean bStartPlay;

    public DtoVideo(String sUri, boolean bLooping, boolean bStartPlay) {
        this.sUri = sUri;
        this.bLooping = bLooping;
        this.bStartPlay = bStartPlay;
    }

    public String getsUri() {
        return sUri;
    }

    public void setsUri(String sUri) {
        this.sUri = sUri;
    }

    public boolean isbLooping() {
        return bLooping;
    }

    public void setbLooping(boolean bLooping) {
        this.bLooping = bLooping;
    }

    public boolean isbStartPlay() {
        return bStartPlay;
    }

    public void setbStartPlay(boolean bStartPlay) {
        this.bStartPlay = bStartPlay;
    }
}
