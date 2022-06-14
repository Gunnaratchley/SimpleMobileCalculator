package edu.uark.ahnelson.simplecalculator;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SimpleCalculatorView#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SimpleCalculatorView extends Fragment {

    private TextView tvResult;
    private SimpleCalculatorPresenter mPresenter;

    public SimpleCalculatorView() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment SimpleCalculatorView.
     */
    // TODO: Rename and change types and number of parameters
    public static SimpleCalculatorView newInstance() {
        SimpleCalculatorView fragment = new SimpleCalculatorView();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_simple_calculator_view, container, false);
        tvResult = root.findViewById(R.id.tvResult);
        Button btnDosmething = (Button)root.findViewById(R.id.btnDoSomething);
        btnDosmething.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mPresenter != null){
                    mPresenter.notifyButtonClicked();
                }
            }
        });
        return root;
    }

    public void setPresenter(SimpleCalculatorPresenter presenter){
        mPresenter = presenter;
    }

    public void setTvResult(String result){
        if(tvResult!= null)
            tvResult.setText(result);
    }
}