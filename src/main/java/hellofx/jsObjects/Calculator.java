package hellofx.jsObjects;

import hellofx.calculatorLogic.service.CalculatorService;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;


public class Calculator {
        CalculatorService calculatorService;
    public Calculator() {
        calculatorService = new CalculatorService();
        calculatorService.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent workerStateEvent) {
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                System.out.println("The result is...");
                a.setContentText((String) workerStateEvent.getSource().getValue());
                a.show();
            }
        });
    }
    public void calculate(String name){
        System.out.println("...");
        calculatorService.setMath_expression(name);
        calculatorService.start();//Just to show that the app did not crash
    }
}
