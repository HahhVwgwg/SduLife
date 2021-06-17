package kz.edu.sdulife.ui.development;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class DevelopmentViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DevelopmentViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is development fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}