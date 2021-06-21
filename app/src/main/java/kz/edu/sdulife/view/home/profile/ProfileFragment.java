package kz.edu.sdulife.view.home.profile;

import android.os.Bundle;

import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.ArrayList;

import kz.edu.sdulife.R;
import kz.edu.sdulife.adapter.ProfileAdapter;
import kz.edu.sdulife.model.ProfileItem;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {
    TextView toolbar_text;
    RecyclerView profile_rec,contact_rec,account_stn_rec;
    ProfileAdapter profileAdapter;
    NestedScrollView nestedScrollView;

//    ArrayList<ProfileItem> list = new ArrayList<>();
//
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_profile, container, false);
        profile_rec = (RecyclerView)view.findViewById(R.id.profile_recyclerview);
        contact_rec = (RecyclerView)view.findViewById(R.id.contacts_rec);
        account_stn_rec = (RecyclerView)view.findViewById(R.id.account_stn_rec);
        nestedScrollView = view.findViewById(R.id.nes_scroll_view);

        toolbar_text = view.findViewById(R.id.toolbar_title);
        toolbar_text.setText("Profile");

        ArrayList<ProfileItem> list = new ArrayList<>();
        ArrayList<ProfileItem> list1 = new ArrayList<>();
        ArrayList<ProfileItem> list2 = new ArrayList<>();

        //General Information - start
        list.add(new ProfileItem("Full Name","Zhamshid Irisbayev"));
        list.add(new ProfileItem("Id number","180103263"));
        list.add(new ProfileItem("Speciality","Information Systems"));
        list.add(new ProfileItem("Birthday","17.03.2001"));
        profileAdapter = new ProfileAdapter(list, getContext());
        profile_rec.setAdapter(profileAdapter);
        profile_rec.setLayoutManager(new LinearLayoutManager(getContext()));
        //General Information - end

        //Contacts - start
        list1.add(new ProfileItem("Phone","+7 771 973 17 17"));
        list1.add(new ProfileItem("Email","180103263@stu.sdu.edu.kz"));
        profileAdapter = new ProfileAdapter(list1, getContext());
        contact_rec.setAdapter(profileAdapter);
        contact_rec.setLayoutManager(new LinearLayoutManager(getContext()));
        //Contacts - end


        return view;
    }
}