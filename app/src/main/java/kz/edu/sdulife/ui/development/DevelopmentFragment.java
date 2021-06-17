package kz.edu.sdulife.ui.development;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import kz.edu.sdulife.databinding.FragmentDevelopmentBinding;

public class DevelopmentFragment extends Fragment {

    private DevelopmentViewModel developmentViewModel;
    private FragmentDevelopmentBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        developmentViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(DevelopmentViewModel.class);

        binding = FragmentDevelopmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textDevelopment;
        developmentViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}