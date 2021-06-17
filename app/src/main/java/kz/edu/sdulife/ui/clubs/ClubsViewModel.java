package kz.edu.sdulife.ui.clubs;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class ClubsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ClubsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is clubs fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}