package com.example.calculationtest;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.calculationtest.databinding.FragmentLostBinding;


public class LostFragment extends Fragment {



    public LostFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      MyViewModel myViewModel;
      myViewModel=new ViewModelProvider(requireActivity(),new SavedStateViewModelFactory(requireActivity().getApplication(),this)).get(MyViewModel.class);
        FragmentLostBinding binding;
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_lost,container,false);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(requireActivity());
       binding.button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Navigation.findNavController(v).navigate(R.id.action_lostFragment_to_titleFragment);
           }
       });
        return binding.getRoot();


    }
}