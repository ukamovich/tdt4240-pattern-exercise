package com.pong.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Paddle extends Sprite {

    private final Vector2 position;
    private final Texture texture;
    private final Rectangle bounds;
    private final int speed;

    public Paddle(int x, int y) {
        this.position = new Vector2((float) x, (float) y);
        this.texture = new Texture("game/paddle.png");
        this.bounds = new Rectangle(this.getPosition().x, this.getPosition().y, (float) this.getTexture().getWidth(), (float)this.getTexture().getHeight());
        this.speed = 20;
    }

    @Override
    public Vector2 getPosition() {
        return this.position;
    }

    @Override
    public Texture getTexture() {
        return this.texture;
    }

    @Override
    public Rectangle getBounds() {
        return this.bounds;
    }

    public final int getSpeed() {
        return this.speed;
    }

    public abstract void update();

}
