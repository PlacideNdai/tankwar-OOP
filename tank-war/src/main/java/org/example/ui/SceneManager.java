
package org.example.ui;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneManager {
    private static Stage mainStage;

    public static void init(Stage stage){
        mainStage = stage;
    }

    public static void switchSceneTo(Scene scene){
        mainStage.setScene(scene);
        mainStage.show();
    }
    
}
