package com.skycity.game.componets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import static com.skycity.game.core.Config.*;


public class UIChat {
    private boolean isHide;

    private TextField textField;
    private Skin skin;

    public UIChat(){
        isHide =false;
        skin = new Skin(Gdx.files.internal("clean-crispy-ui.json"));
        textField = new TextField("",skin);
        textField.setSize(SCREEN_WIDTH-40,22);
        textField.setPosition(20,20);
    }

    public TextField getTextField() {
        return textField;
    }

    public void show(){
        isHide=false;
    }

    public void hide(){
        isHide=true;
    }

    public void draw(Batch batch, float parentAlpha) {
        if(isHide){
            return;
        }else {
            textField.draw(batch,parentAlpha);
        }
    }


    public void dispose(){
        skin.dispose();
    }
}
