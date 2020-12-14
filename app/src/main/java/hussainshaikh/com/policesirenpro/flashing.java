package hussainshaikh.com.policesirenpro;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.animation.Animation;
import android.widget.ImageView;

public class flashing extends AppCompatActivity {
    ImageView imageViewLightFlashing;
    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashing);
        getSupportActionBar().hide();

       imageViewLightFlashing = (ImageView) findViewById(R.id.imageViewActivity);

       startSiren();
       startLights();

    }

    public void  startSiren(){
        mediaPlayer = MediaPlayer.create(this,R.raw.police_siren);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);
    }

    @SuppressLint("WrongConstant")
    public void startLights(){
        ObjectAnimator anim = ObjectAnimator.ofInt(imageViewLightFlashing,"BackgroundColor", Color.RED,Color.BLUE);
        anim.setDuration(120);
        anim.setEvaluator(new ArgbEvaluator());
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        anim.start();
    }

    @Override
    public void onBackPressed() {
        mediaPlayer.stop();
        super.onBackPressed();
    }
}