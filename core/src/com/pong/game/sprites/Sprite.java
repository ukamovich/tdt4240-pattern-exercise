package com.pong.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Sprite {

    public abstract Texture getTexture();
    public abstract Vector2 getPosition();
    public abstract Rectangle getBounds();

}
