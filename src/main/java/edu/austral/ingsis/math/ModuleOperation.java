package edu.austral.ingsis.math;


public class ModuleOperation extends UnaryOperation {

    public ModuleOperation(Function operand) {
        super(operand, Math::abs, "|");
    }

    @Override
    public String getString() {
        String operandString = getOperand().getString();
        return "|" + operandString + "|";
    }


}
