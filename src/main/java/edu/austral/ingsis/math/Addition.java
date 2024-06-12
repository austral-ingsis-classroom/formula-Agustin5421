package edu.austral.ingsis.math;

public class Addition implements Function {

  private final Function left;
  private final Function right;

  public Addition(Function left, Function right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public Function solve() {
    return new Constant(left.solve().getValue() + right.solve().getValue());
  }

  @Override
  public String getString() {
    return left.getString() + " + " + right.getString();
  }

  @Override
  public Double getValue() {
    throw new UnsupportedOperationException();
  }

}
