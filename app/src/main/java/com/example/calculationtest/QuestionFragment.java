package com.example.calculationtest;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.calculationtest.databinding.FragmentQuestionBinding;
import com.example.calculationtest.databinding.FragmentTitleBinding;


public class QuestionFragment extends Fragment {


    public QuestionFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        MyViewModel myViewModel;
        myViewModel = new ViewModelProvider(requireActivity(), new SavedStateViewModelFactory(requireActivity().getApplication(), this)).get(MyViewModel.class);
     myViewModel.generator();
     myViewModel.getCurrentScore().setValue(0);
      FragmentQuestionBinding binding;
      binding= DataBindingUtil.inflate(inflater,R.layout.fragment_question,container,false);
      binding.setData(myViewModel);
      binding.setLifecycleOwner(requireActivity());
        StringBuilder builder=new StringBuilder();//穿件一个可变字符串
        binding.button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.append("0");
                binding.textView8.setText(builder.toString());

            }
        });
        binding.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.append("1");   binding.textView8.setText(builder.toString());

            }
        });
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.append("2");   binding.textView8.setText(builder.toString());

            }
        });
        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.append("3");   binding.textView8.setText(builder.toString());

            }
        });
        binding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.append("4");   binding.textView8.setText(builder.toString());

            }
        });
        binding.button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.append("5");   binding.textView8.setText(builder.toString());

            }
        });
        binding.button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.append("6");   binding.textView8.setText(builder.toString());

            }
        });
        binding.button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.append("7");   binding.textView8.setText(builder.toString());

            }
        });
        binding.button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.append("8");   binding.textView8.setText(builder.toString());

            }
        });
        binding.button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.append("9");   binding.textView8.setText(builder.toString());

            }
        });
        binding.buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setLength(0);
                binding.textView8.setText(getString(R.string.input_indicator));
            }
        });
        binding.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (builder.length()==0){
                    builder.append("-1");
                }
                if (Integer.valueOf(builder.toString()).intValue()==myViewModel.getAnswer().getValue()){
                    myViewModel.answerCorrect();
                    builder.setLength(0);
                    binding.textView8.setText(R.string.answer_correct_message);

                }else {
                    NavController controller=Navigation.findNavController(v);
                    if(myViewModel.win_flag){
                        controller.navigate(R.id.action_questionFragment_to_winFragment);
                        myViewModel.win_flag=false;
                        myViewModel.save();
                    }else {
                        controller.navigate(R.id.action_questionFragment_to_lostFragment);
                    }
                }
            }
        });

   return binding.getRoot();

    }
}