package edu.uark.ahnelson.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Path;
import android.os.Bundle;


public class SimpleCalculatorActivity extends AppCompatActivity implements SimpleCalculatorPresenter{

    private CalculatorModel calculatorModel;
    private SimpleCalculatorView simpleCalculatorView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void onResume(){
        super.onResume();
         simpleCalculatorView = (SimpleCalculatorView) getSupportFragmentManager()
                .findFragmentById(R.id.fragmentContainerView);
        if(simpleCalculatorView == null){
            simpleCalculatorView = SimpleCalculatorView.newInstance();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.fragmentContainerView,simpleCalculatorView);
            transaction.commit();
        }
        startPresenter();
    }

    @Override
    public void startPresenter() {
        calculatorModel = new CalculatorModel();
        simpleCalculatorView.setPresenter(this);

    }

    @Override
    public void notifyButtonClicked() {
        calculatorModel.setOperand1(5.5);
        calculatorModel.setOperand2(2.7);
        calculatorModel.setOperator(Operator.ADD);
        calculatorModel.calculate();
        simpleCalculatorView.setTvResult("5.5 + 2.7 = " + calculatorModel.getResult().toString());
    }

}