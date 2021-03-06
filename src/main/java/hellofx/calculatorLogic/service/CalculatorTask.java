package hellofx.calculatorLogic.service;


import hellofx.calculatorLogic.ExpressionParser;
import javafx.concurrent.Task;

public class CalculatorTask extends Task<String> {
    private ExpressionParser expressionParser;
    private String math_Expression;

    @Override
    protected String call() throws Exception {
        expressionParser = new ExpressionParser(math_Expression);
        double result = expressionParser.parse();
        updateMessage(result + "");
        return  result + "";
    }

    // setters
    public void setMath_Expression(String math_Expression) {
        this.math_Expression = math_Expression;
    }

}
