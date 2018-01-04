package com.skycity.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.skycity.game.SkyCity;
import com.skycity.game.componets.Hud;
import com.skycity.game.core.Assets;
import com.skycity.game.core.Config;

import static com.skycity.game.core.Config.SCREEN_HEIGHT;
import static com.skycity.game.core.Config.SCREEN_WIDTH;


/**
 * 游戏主屏
 */
public class GameState extends BaseState {

    private Hud hud;

    private OrthographicCamera mapCamera;
    private OrthogonalTiledMapRenderer renderer;
    private Viewport gamePort;



    public GameState(SkyCity skyCity) {
        super(skyCity);
        hud = new Hud(skyCity.batch);

        mapCamera = new OrthographicCamera(SCREEN_WIDTH,SCREEN_HEIGHT);
        gamePort =new FitViewport(SCREEN_WIDTH,SCREEN_HEIGHT,mapCamera);

        renderer = new OrthogonalTiledMapRenderer(Assets.getInstance().getTiledMap(),skyCity.batch);
        mapCamera.position.set(gamePort.getScreenWidth()/2,gamePort.getScreenHeight()/2,0);

        renderer.setView(mapCamera);

    }

    /**
     * 更新屏幕摄像机
     * @param delta
     */
    void update(float delta){
        handle(delta);
        mapCamera.update();
    }

    private void handle(float delta) {
        if(Gdx.input.isKeyJustPressed(Config.Keys.MOVE_RIGHT)){
            mapCamera.position.x += delta;

        }
    }

    @Override
    public void show() {

    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        gamePort.setScreenSize(width,height);
    }

    @Override
    public void render(float delta) {
        update(delta);
        cleanScreen();
        skyCity.batch.setProjectionMatrix(mapCamera.combined);
        renderer.render();
        hud.render();
    }


    @Override
    public void hide() {
        super.hide();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
