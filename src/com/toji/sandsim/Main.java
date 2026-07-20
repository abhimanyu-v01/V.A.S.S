package com.toji.sandsim;

import com.toji.sandsim.engine.GameLoop;
import com.toji.sandsim.engine.Window;
import javafx.application.Application;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Main {
    public static void main(String[] args) {

        // This isn't your sim yet, just proof the pipeline (window -> loop -> draw) works.
        GameLoop testLoop = new GameLoop() {
            double x = 0;
            double speed = 200; // pixels per second

            @Override
            public void update(double dt) {
                x += speed * dt;
                if (x > 600 || x < 0) speed = -speed;
            }

            @Override
            public void render(GraphicsContext gc) {
                gc.setFill(Color.BLACK);
                gc.fillRect(0, 0, 800, 600);

                gc.setFill(Color.ORANGE);
                gc.fillRect(400, x, 40, 40);
            }
        };

        Window.loop = testLoop;
        Application.launch(Window.class, args);
    }
}
