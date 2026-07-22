package com.toji.sandsim.engine;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Window extends Application {

    public static GameLoop loop;
    public static int width = 800;
    public static int height = 450;
    public static String title = "V.A.S.S";

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(width, height);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Pane root = new Pane(canvas);
        stage.setScene(new Scene(root, width, height));
        stage.setTitle(title);
        stage.show();

        final long[] lastTime = {System.nanoTime()};

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                double dt = (now - lastTime[0]) / 1_000_000_000.0;
                lastTime[0] = now;

                loop.update(dt);
                loop.render(gc);
            }
        }.start();
    }
}
