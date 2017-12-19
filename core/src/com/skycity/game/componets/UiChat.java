package com.skycity.game.componets;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class UiChat implements Screen{
    private OrthographicCamera camera;

    private Game g;
    private Batch batch;
    private Texture texture;

    public UiChat(Game g){
        this.g= g;
        Gdx.app.log("Uichat","constructor called");
        camera = new OrthographicCamera();
//        camera.setToOrtho(false, 512, 512);
        batch = new SpriteBatch();
        texture = new Texture(Gdx.files.internal("badlogic.jpg"));
    }


    @Override
    public void show() {

        Gdx.app.log("my Main Screens", "show called");
//        texture = new Texture(Gdx.files.internal("badlogic.jpg")); //** texture is now the main image **//
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
//        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(texture, 300, 300);
//        if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
//            Gdx.app.log("input","enter pressed");
//            g.setScreen(new UiChat(g));
//        }
//        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
//            Gdx.app.log("input","esc pressed");
//            dispose();
//        }
        batch.end();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

        Gdx.app.log("my Main Screens", "hide called");
    }

    @Override
    public void dispose() {
        Gdx.app.log("my Main Screens", "dispose called");
        texture.dispose();
        batch.dispose();
    }
}