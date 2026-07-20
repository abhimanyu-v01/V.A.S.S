package com.toji.sandsim.engine;

import javafx.scene.canvas.GraphicsContext;

public interface GameLoop {
    void update(double deltaSeconds);
    void render(GraphicsContext gc);
}
