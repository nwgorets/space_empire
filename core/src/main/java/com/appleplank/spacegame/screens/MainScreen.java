package com.appleplank.spacegame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.appleplank.spacegame.Main;
import com.appleplank.spacegame.SampleViewport;

public class MainScreen extends ScreenAdapter {
    private Main main;
    private SpriteBatch batch;
    private Texture texture;
    private TextureRegion testSprite;
    private TextureRegion starSprite;
    private TextureRegion buttonRegion;
    private Stage mainStage;
    private Stage stage1;

    public MainScreen(Main main) {
        this.main = main;
        init();
    }

    @Override
    public void dispose() {
        batch.dispose();
        texture.dispose();
    }

    @Override
    public void resize(int width, int height) {
        mainStage.getViewport().update(width, height, true);
    }

    private void init() {
        batch = new SpriteBatch();
        
        mainStage = new Stage(new SampleViewport(160, 100), batch);

       // mainStage.addActor(hGroup);
        
        texture = new Texture("oryx_lofi_scifi/lofi_scifi_v2_trans.png");
        testSprite = new TextureRegion(texture, 8, 24, 8, 8);
        starSprite = new TextureRegion(texture, 228, 668, 16, 16);
        buttonRegion = new TextureRegion( texture, 56, 520, 8, 8);

        BitmapFont buttonFont = new BitmapFont();
        TextButtonStyle style = new TextButtonStyle();
        style.up = new TextureRegionDrawable(buttonRegion);
        style.down = new TextureRegionDrawable(buttonRegion);
        style.font = buttonFont;

        //stage = new Stage(new SampleViewport(300, 200), batch);
        Button button = new TextButton("Test", style);
        button.setSize(60, 20);
        button.setX(0);
        //stage.addActor(button);

        stage1 = new Stage(new FitViewport(320, 200), batch);
        //Stage stage2 = new Stage(new FitViewport(160, 200), batch);

        //stage1.addActor(button);

        // stage.getViewport().update(10, 10);
        // stage.getViewport().setScreenX(0);
        // stage.getViewport().setScreenY(0);

        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        // Constructs a new OrthographicCamera, using the given viewport width and
        // height
        // Height is multiplied by aspect ratio.
      //  cam = new OrthographicCamera(160, 120 * (h / w));

        // stage.getViewport().setCamera(cam);

      //  cam.position.set((cam.viewportWidth / 2f) - 20, cam.viewportHeight / 2f, 0);
      //  cam.update();

        Image image = new Image(starSprite);
        image.setPosition(10f, 10f);
        Image image2 = new Image(testSprite);
        image2.setPosition(10f, 10f);

        stage1.addActor(image);
        stage1.addActor(button);
        mainStage.addActor(image2);
    }

    @Override
    public void render(float delta) {

        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        mainStage.getViewport().apply();
        mainStage.act(delta);
        mainStage.draw();


        stage1.getViewport().apply();
        stage1.act(delta);
        stage1.draw();

        // shapeR.setProjectionMatrix(stage.getViewport().getCamera().combined);
        // shapeR.begin(ShapeType.Filled);
        // shapeR.setColor(Color.RED);
        // shapeR.rect(0, 0, stage.getViewport().getWorldWidth(), stage.getViewport().getWorldHeight());
        // shapeR.end();

      //  cam.update();
      //.setProjectionMatrix(cam.combined);

        // batch.begin();
        // batch.draw(testSprite, 0, 0);
        // batch.draw(starSprite, 40, 50);
        // batch.end();
    }

}
