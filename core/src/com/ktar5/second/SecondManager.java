package com.ktar5.second;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Disposable;
import lombok.Getter;

import java.time.Clock;
import java.util.Collections;

public class SecondManager implements Disposable {
    private long nextSecond = Clock.systemUTC().millis();
    @Getter
    private long latestDifference = 0;
    @Getter
    private Color screenColor = Color.GREEN;
    private Sound sound;

    public SecondManager() {
        sound = Gdx.audio.newSound(Gdx.files.internal("Click2-Sebastian-759472264.mp3"));
    }

    public void onClick() {
        latestDifference = Clock.systemUTC().millis() - nextSecond;
        nextSecond = System.currentTimeMillis() + 1000;
        float red = MathUtils.lerp(Color.FIREBRICK.r, Color.RED.r, ((float)latestDifference + (float)1000) / (float)2000);
        float green = MathUtils.lerp(Color.FIREBRICK.g, Color.RED.g, ((float)latestDifference + (float)1000) / (float)2000);
        float blue = MathUtils.lerp(Color.FIREBRICK.b, Color.RED.b, ((float)latestDifference + (float)1000) / (float)2000);
        screenColor = new Color(red, green, blue, 255);
        /*
        if (latestDifference > 3) {
            screenColor = Color.RED;
            //System.out.println(Color.RED.r  + " " + Color.RED.g + " " + Color.RED.b);
        } else if (latestDifference < -3) {
            screenColor = Color.FIREBRICK;
            //System.out.println(Color.FIREBRICK.r  + " " + Color.FIREBRICK.g + " " + Color.FIREBRICK.b);
        } else {
            screenColor = Color.GREEN;
            sound.play(1.0f);
        }*/
        if(latestDifference < 3 && latestDifference > -3){
            screenColor = Color.GREEN;
            sound.play(1.0f);
        }
    }


    @Override
    public void dispose() {
        sound.dispose();
    }
}
