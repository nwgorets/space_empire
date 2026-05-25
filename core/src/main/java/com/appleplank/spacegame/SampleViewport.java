package com.appleplank.spacegame;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class SampleViewport extends FitViewport {
    
    public SampleViewport(int x, int y) {
        super(x, y);
    }


    public void update (int screenWidth, int screenHeight, boolean centerCamera) {
        Vector2 scaled = getScaling().apply(getWorldWidth(), getWorldHeight(), screenWidth, screenHeight);
		int viewportWidth = Math.round(scaled.x);
		int viewportHeight = Math.round(scaled.y);

		// Center.
		setScreenBounds(200, 0, viewportWidth, viewportHeight);

		apply(centerCamera);
    }
}
