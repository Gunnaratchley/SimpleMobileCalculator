package edu.uark.ahnelson.simplecalculator;

public class CalculatorModel {

    private Double mOperand1;
    private Double mOperand2;
    private Operator mOperator;
    private Double mResult;

    public CalculatorModel() {
        mOperand1 = 0.0;
        mOperand2 = 0.0;
        mResult = 0.0;
        mOperator = Operator.ADD;
    }

    public Double getResult() {
        return mResult;
    }

    public void setOperand1(Double mOperand1) {
        this.mOperand1 = mOperand1;
    }

    public void setOperand2(Double mOperand2) {
        this.mOperand2 = mOperand2;
    }

    public void setOperator(Operator mOperator) {
        this.mOperator = mOperator;
    }

    public void calculate(){
        switch (mOperator){
            case ADD:
                mResult = mOperand1 + mOperand2;
                break;
            case SUB:
                mResult = mOperand1 - mOperand2;
                 break;
            case MUL:
                mResult = mOperand1 * mOperand2;
                break;
            case DIV:
                mResult = mOperand1/mOperand2;
                break;
            default:
                break;
        }
    }


}
