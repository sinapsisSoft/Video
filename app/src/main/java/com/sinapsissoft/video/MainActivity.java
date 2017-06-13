package com.sinapsissoft.video;





import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.sinapsissoft.video.class_app.General;
import com.sinapsissoft.video.dto.DtoVideo;

import layout.VideoFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadView();
    }
    private void loadView(){
        loadData();

        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container_fragment,new VideoFragment(),"NewFragmentTag");
        transaction.addToBackStack(null);
        transaction.commit();


    }
    private void loadData(){
        General.DTO_VIDEO=new DtoVideo("android.resource://"+getPackageName()+"/"+R.raw.ateroesclerosis,false,false);
    }
}
