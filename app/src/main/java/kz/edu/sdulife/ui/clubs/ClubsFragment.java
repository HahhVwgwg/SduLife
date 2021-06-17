package kz.edu.sdulife.ui.clubs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;

import kz.edu.sdulife.databinding.FragmentClubsBinding;

public class ClubsFragment extends Fragment {

    private ClubsViewModel clubsViewModel;
    private FragmentClubsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        clubsViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(ClubsViewModel.class);

        binding = FragmentClubsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textClubs;
        clubsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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