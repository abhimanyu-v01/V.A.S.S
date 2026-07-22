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
            double x = 0, y = 0;
            double xspeed = 100, yspeed = 100; // pixels per second
            double square_size = 40;

            @Override
            public void update(double dt) {
                x += xspeed * dt;
                y += yspeed * dt;
                if (x > Window.height - square_size || x < 0) xspeed = -xspeed;
                if (y > Window.width - square_size || y < 0) yspeed = -yspeed;
            }

            @Override
            public void render(GraphicsContext gc) {
                gc.setFill(Color.BLACK);
                gc.fillRect(0, 0, 1600, 900);

                gc.setFill(Color.ORANGE);
                gc.fillRect(y, x, square_size, square_size);
            }
        };

        Window.loop = testLoop;
        Application.launch(Window.class, args);
    }
}