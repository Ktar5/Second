package com.ktar5.second;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Camera;

public class MouseListener implements InputProcessor {
    private SecondManager secondManager;
    private Camera camera;

    public MouseListener(SecondManager secondManager, Camera camera){
        this.secondManager = secondManager;
        this.camera = camera;
    }

    @Override
    public boolean keyDown(int keycode) {
        secondManager.onClick();
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        System.out.println(screenX + " " + screenY);
        secondManager.onClick();
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
