package com.pong.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pong.game.PongGame;
import com.pong.game.sprites.Ball;
import com.pong.game.sprites.LeftPaddle;
import com.pong.game.sprites.RightPaddle;



public final class PlayState extends State {

    private final LeftPaddle leftPaddle;
    private final RightPaddle rightPaddle;
    private final Ball ball;
    private int scoreLeft;
    private int scoreRight;
    private String winnerStr;
    private final BitmapFont font;
    private final BitmapFont defaultFont;
    private final float fontScale;


    public PlayState(GameStateManager gsm) {
        super(gsm);
        int margin = 15;
        this.leftPaddle = new LeftPaddle(margin, margin);
        this.rightPaddle = new RightPaddle(PongGame.WIDTH - this.leftPaddle.getTexture().getWidth() - margin, margin);
        this.ball = new Ball();


        //this.resetBtn = new Button(PongGame.WIDTH / 2 - 32, PongGame.HEIGHT / 3, "menu/playbtn.png");
        scoreLeft = 0;
        scoreRight =0;
        this.winnerStr = "";
        this.defaultFont = new BitmapFont();
        this.font = new BitmapFont(Gdx.files.internal("fonts/krungthep.fnt"));
        this.fontScale = 0.2f;

    }

    @Override
    public void handleInput() {
        // handle game restart by touching
        if (Gdx.input.justTouched()) {
            gsm.set(new PlayState(gsm));
            dispose();
        }
    }

    @Override
    public void update(float dt) {

        this.handleInput();
        this.leftPaddle.update();
        this.rightPaddle.update();
        this.ball.update(dt, this, this.leftPaddle, rightPaddle);
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.begin();
        Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);

        float fontWidth;
        float fontX;
        float fontY;

        if (this.winnerStr != "") {
            this.defaultFont.setColor(Color.WHITE);
            this.defaultFont.draw(spriteBatch, this.winnerStr, 240, 250);

        } else {
            fontWidth = (new GlyphLayout(this.font, (this.scoreLeft + " : " + this.scoreRight))).width;
            spriteBatch.draw(this.rightPaddle.getTexture(), this.rightPaddle.getPosition().x, this.rightPaddle.getPosition().y);
            spriteBatch.draw(this.leftPaddle.getTexture(), this.leftPaddle.getPosition().x, this.leftPaddle.getPosition().y);
            spriteBatch.draw(this.ball.getTexture(), this.ball.getPosition().x, this.ball.getPosition().y, 20.0f, 20.0f);
            fontX = ((float)PongGame.WIDTH - fontWidth) / (float)2;
            fontY = (float)PongGame.HEIGHT - (float)30;
            this.font.getData().setScale(this.fontScale);
            this.font.setColor(Color.WHITE);
            this.font.draw(spriteBatch, (this.scoreLeft + " : " + this.scoreRight), fontX, fontY);
        }
        spriteBatch.end();
    }

    public final void countRightScore() {
        this.scoreRight++;
        if (this.scoreRight >= 2) {
            this.winnerStr = "Right player won. Tap anywhere to start over.";
        }
    }

    public final void countLeftScore() {
        this.scoreLeft++;
        if (this.scoreLeft >= 2) {
            this.winnerStr = "Left player won. Tap anywhere to start over.";
        }
    }

    @Override
    public void dispose() {
        font.dispose();
        defaultFont.dispose();
    }
}
