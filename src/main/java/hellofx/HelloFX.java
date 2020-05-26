
package hellofx;


import hellofx.jsObjects.Calculator;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;


public class HelloFX extends Application {
        private WebView webView;
        private WebEngine webEngine;

    public void start(Stage stage) {
        ProgressBar progressBar = new ProgressBar();
        stage.setTitle("JavaFX WebView Example");
        webView = new WebView();
        webEngine = webView.getEngine();
        webEngine.load(HelloFX.class.getResource("index.html").toExternalForm());
        webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {
            @Override
            public void changed(ObservableValue<? extends Worker.State> observableValue, Worker.State state, Worker.State t1) {
                System.out.println("Bridge js");
                JSObject script = (JSObject) webEngine.executeScript("window");
                script.setMember("calculator", new Calculator());
            }
        });
        Scene scene = new Scene(webView, 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}