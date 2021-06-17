package kz.edu.sdulife.ui.announcement;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class AnnouncementViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AnnouncementViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is announcement fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}