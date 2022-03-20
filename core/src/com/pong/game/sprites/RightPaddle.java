package com.pong.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.pong.game.PongGame;

public final class RightPaddle extends Paddle {

    public RightPaddle(int x, int y) {
        super(x, y);
    }

    @Override
    public void update() {
        float boundary = (PongGame.HEIGHT - this.getTexture().getHeight());
        this.getBounds().setPosition(this.getPosition().x, this.getPosition().y);

        if (this.getPosition().y < 0) {
            this.getPosition().y = 0f;
        }

        if (this.getPosition().y > boundary) {
            this.getPosition().y = boundary;
        }

        // Using UP and DOWN keyboard arrow keys to control right paddle
        if (Gdx.input.isKeyPressed(Input.Keys.UP) && this.getPosition().y < boundary) {
            this.getPosition().y += 20;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && this.getPosition().y > 0) {
            this.getPosition().y -= 20;
        }
    }
}
