package kz.edu.sdulife.view.home.profile;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;

import kz.edu.sdulife.BuildConfig;
import kz.edu.sdulife.R;
import kz.edu.sdulife.adapter.ProfileAdapter;
import kz.edu.sdulife.common.BaseFragment;
import kz.edu.sdulife.listener.ProfileListener;
import kz.edu.sdulife.model.ProfileItem;
import kz.edu.sdulife.view.home.news.NewsFragment;
import kz.edu.sdulife.view.home.news.tab_layout.FoundsFragment;
import kz.edu.sdulife.view.home.news.tab_layout.NewsTabFragment;
import kz.edu.sdulife.view.login.SignInActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends BaseFragment {
    boolean switch_on = false;
    TextView toolbar_text,app_version,app_version_code;
    RecyclerView profile_rec;
    ProfileAdapter profileAdapter;
    Button log_out;
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

        log_out = view.findViewById(R.id.log_out);
        nestedScrollView = view.findViewById(R.id.nes_scroll_view);
        app_version = view.findViewById(R.id.app_version);
        app_version_code = view.findViewById(R.id.app_version_code);
        toolbar_text = view.findViewById(R.id.toolbar_title);
        toolbar_text.setText("Profile");
        app_version.setText(BuildConfig.VERSION_NAME);
        app_version_code.setText("(" + BuildConfig.VERSION_CODE + ")" );




        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(SignInActivity.class);
            }
        });


        ProfileListener listener = new ProfileListener() {
            @Override
            public void onClick(int position) {
                int count = 0;
                switch (position){
//                    case 9:openFragment(new FoundsFragment());
//                    break;
                    case 10:
                        LottieAnimationView isSwitched = (LottieAnimationView) view.findViewById(R.id.switch_icon);
                        isSwitched.setSpeed(3f);
                        System.out.println(isSwitched);
                        isSwitched.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (switch_on){
                                    isSwitched.setMinAndMaxProgress(0.5f, 1.0f);
                                    isSwitched.playAnimation();
                                    switch_on = false;
                                }
                                else{
                                    isSwitched.setMinAndMaxProgress(0.0f, 0.5f);
                                    isSwitched.playAnimation();
                                    switch_on = true;
                                }
                            }
                        });
                        break;

                }
            }
        };

        ArrayList<ProfileItem> list = new ArrayList<>();

        //General Information - start
        list.add(new ProfileItem(0,"GENERAL INFORMATION"));
        list.add(new ProfileItem(1,"Full Name","Zhamshid Irisbayev"));
        list.add(new ProfileItem(1,"Id number","180103263"));
        list.add(new ProfileItem(1,"Speciality","Information Systems"));
        list.add(new ProfileItem(1,"Birthday","17.03.2001"));

        list.add(new ProfileItem(0,"CONTACTS"));
        list.add(new ProfileItem(1,"Phone","+7 771 973 17 17"));
        list.add(new ProfileItem(1,"Email","180103263@stu.sdu.edu.kz"));

        list.add(new ProfileItem(0,"ACCOUNT SETTINGS"));
        list.add(new ProfileItem(2,"Language",R.drawable.ic_arrow_right));
        list.add(new ProfileItem(3,"Notifications",R.raw.switch_anim));

        list.add(new ProfileItem(0,"TOOLS"));
        list.add(new ProfileItem(2,"About",R.drawable.ic_arrow_right));
        list.add(new ProfileItem(2,"Contacts",R.drawable.ic_arrow_right));



        profileAdapter = new ProfileAdapter(list,listener, getContext());
        profile_rec.setAdapter(profileAdapter);
        profile_rec.setLayoutManager(new LinearLayoutManager(getContext()));
        //General Information - end





        return view;
    }
}