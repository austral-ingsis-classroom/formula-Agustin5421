package edu.austral.ingsis.math;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class UnaryOperation implements edu.austral.ingsis.math.Function {

    private final Function<Double, Double> operation;
    private final edu.austral.ingsis.math.Function operand;
    private final String operatorSymbol;

    public UnaryOperation(edu.austral.ingsis.math.Function operand, Function<Double, Double> operation, String operatorSymbol) {
        this.operand = operand;
        this.operation = operation;
        this.operatorSymbol = operatorSymbol;
    }

    @Override
    public edu.austral.ingsis.math.Function solve(Map<String, Double> variablesMap) {
        Double operandValue = operand.solve(variablesMap).value();
        return new Constant(operation.apply(operandValue));
    }

    @Override
    public String getString() {
        String operandString = operand.getString();
        if (operand instanceof Complex) {
            operandString = "(" + operandString + ")";
        }
        return operatorSymbol + "(" + operandString + ")";
    }

    @Override
    public Double value() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<String> getVariables() {
        return operand.getVariables();
    }

    protected edu.austral.ingsis.math.Function getOperand() {
        return operand;
    }
}
