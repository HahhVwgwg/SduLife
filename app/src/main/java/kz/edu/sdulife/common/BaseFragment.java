package kz.edu.sdulife.common;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

import kz.edu.sdulife.R;

public class BaseFragment extends Fragment {
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    public void openFragment(Fragment fragment){

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_layout,fragment)
                .commit();
    }


    public void showMessage(String s){
        Toast.makeText(getContext(), s ,Toast.LENGTH_SHORT).show();
    }




    public void openActivity(Class className){

        Intent intent = new Intent(getContext() ,className);
        startActivity(intent);getActivity().finish();

//        getFragmentManager()
//                .beginTransaction()
//                .replace(R.id.fragment_layout,fragment)
//                .commit();
    }

}
