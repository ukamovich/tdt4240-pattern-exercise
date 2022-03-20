package com.pong.game.sprites;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.pong.game.PongGame;

public final class LeftPaddle extends Paddle {

    public LeftPaddle(int x, int y) {
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

        // Using W and S keyboard keys to control left paddle
        if (Gdx.input.isKeyPressed(Input.Keys.W) && this.getPosition().y < boundary) {
            this.getPosition().y += 20;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.S) && this.getPosition().y > 0) {
            this.getPosition().y -= 20;
        }
    }
}
