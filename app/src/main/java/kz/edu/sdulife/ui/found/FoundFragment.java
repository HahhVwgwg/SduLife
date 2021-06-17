package kz.edu.sdulife.ui.found;

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

import kz.edu.sdulife.databinding.FragmentFoundBinding;

public class FoundFragment extends Fragment {

    private FoundViewModel foundViewModel;
    private FragmentFoundBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        foundViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(FoundViewModel.class);

        binding = FragmentFoundBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textFound;
        foundViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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