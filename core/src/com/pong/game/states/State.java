package com.pong.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class State {

    protected GameStateManager gsm;

    protected State(GameStateManager gsm) {
        this.gsm = gsm;
    }

    public abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render(SpriteBatch spriteBatch);
    public abstract void dispose();
}