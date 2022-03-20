package com.pong.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.pong.game.PongGame;
import com.pong.game.states.PlayState;
import com.pong.game.states.State;

public final class Ball extends Sprite {

    private final Texture texture = new Texture("game/ball.png");
    private final Vector2 position;
    private final Rectangle bounds;
    private boolean moveUp;
    private boolean moveRight;
    private final float speed;

    @Override
    public Texture getTexture() {
        return this.texture;
    }

    @Override
    public Vector2 getPosition() {
        return this.position;
    }

    @Override
    public Rectangle getBounds() {
        return this.bounds;
    }

    public Ball() {
        this.position = new Vector2((float)(PongGame.WIDTH / 2), (float)(PongGame.HEIGHT / 2));
        this.bounds = new Rectangle(this.getPosition().x, this.getPosition().y, 20.0F, 20.0F);
        this.moveUp = true;
        this.moveRight = true;
        this.speed = 225; // adjust speed to complicate the game
    }

    public final void update(float dt, State state, LeftPaddle leftPaddle, RightPaddle rightPaddle) {
        
        this.getBounds().setPosition(this.getPosition().x, this.getPosition().y);
        
        if (this.getBounds().overlaps(leftPaddle.getBounds())) {
            this.moveRight = true;
        }

        if (this.getBounds().overlaps(rightPaddle.getBounds())) {
            this.moveRight = false;
        }

        this.moveY(this.speed * dt);
        this.moveX(this.speed * dt, (PlayState) state);
    }

    private void moveY(float speed) {
        if (this.moveUp) {
            this.position.y += speed;
        }
        else {
            this.position.y -= speed;
        }
        if (this.moveUp && this.position.y > PongGame.HEIGHT - this.getTexture().getHeight() / (float)2 ) {
            this.moveUp = false;
        }
        if (!this.moveUp && this.getPosition().y < 0) {
            this.moveUp = true;
        }
    }


    private void moveX(float speed, PlayState state) {
        if (this.moveRight) {
            this.getPosition().x += speed;
        }
        else {
            this.getPosition().x -= speed;
        }

        if (this.getPosition().x > PongGame.WIDTH - this.getTexture().getWidth() / (float)2) {
            this.getPosition().x = PongGame.WIDTH / (float)2;
            this.getPosition().y = PongGame.HEIGHT / (float)2;
            this.moveRight = false;
            this.moveUp = !this.moveUp;
            state.countLeftScore();
        }

        if (this.getPosition().x < 0) {
            this.getPosition().x = PongGame.WIDTH / (float)2;
            this.getPosition().y = PongGame.HEIGHT / (float)2;
            this.moveRight = true;
            this.moveUp = !this.moveUp;
            state.countRightScore();
        }

    }
}
