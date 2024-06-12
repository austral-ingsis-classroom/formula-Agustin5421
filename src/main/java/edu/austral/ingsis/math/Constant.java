package edu.austral.ingsis.math;

public class Constant implements Function {
      private final Double value;

      public Constant(Double value) {
     this.value = value;
      }

      @Override
      public Function solve() {
     return this;
      }

      @Override
      public Double getValue() {
     return value;
      }

      @Override
      public String getString() {
     return value.toString();
      }
}
