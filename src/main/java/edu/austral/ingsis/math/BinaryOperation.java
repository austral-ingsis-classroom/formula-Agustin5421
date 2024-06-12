package edu.austral.ingsis.math;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;

public class BinaryOperation implements Complex {

  private final Function left;
  private final Function right;
  private final BiFunction<Double, Double, Double> operation;
  private final String operatorSymbol;

  public BinaryOperation(Function left, Function right, BiFunction<Double, Double, Double> operation, String operatorSymbol) {
    this.left = left;
    this.right = right;
    this.operation = operation;
    this.operatorSymbol = operatorSymbol;
  }

  @Override
  public Function solve(Map<String, Double> variablesMap) {
    Double leftValue = left.solve(variablesMap).value();
    Double rightValue = right.solve(variablesMap).value();
    return new Constant(operation.apply(leftValue, rightValue));
  }

  @Override
  public Function getLeft() {
    return left;
  }

  @Override
  public Function getRight() {
    return right;
  }

  @Override
  public String getString() {
    String leftString = left.getString();
    String rightString = right.getString();
    if (left instanceof Complex){
      leftString = "(" + leftString + ")";
    }
    if (right instanceof Complex) {
        rightString = "(" + rightString + ")";
    }
    return leftString + " " + operatorSymbol + " " + rightString;
  }

  @Override
  public Double value() {
    throw new UnsupportedOperationException();
  }

  @Override
  public Set<String> getVariables() {
    Set<String> variables = new HashSet<>(left.getVariables());
    variables.addAll(right.getVariables());
    return variables;
  }

}
