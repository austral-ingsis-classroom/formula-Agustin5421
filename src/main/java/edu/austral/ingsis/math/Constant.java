package edu.austral.ingsis.math;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public final class Constant implements Function {
  private final Double value;

  public Constant(Double value) {
    this.value = value;
  }

  @Override
  public Function solve(Map<String, Double> variablesMap) {
    return this;
  }

  @Override
  public Set<String> getVariables() {
    return Collections.emptySet();
  }

  @Override
  public String getString() {
    if (value == value.intValue()) {
      return String.valueOf(value.intValue());
    }
    return value.toString();
  }

  @Override
  public Double value() {
    return value;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (obj == null || obj.getClass() != this.getClass()) return false;
    var that = (Constant) obj;
    return Objects.equals(this.value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return "Constant[" + "value=" + value + ']';
  }
}
