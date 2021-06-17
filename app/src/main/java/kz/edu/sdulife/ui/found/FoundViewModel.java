package kz.edu.sdulife.ui.found;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class FoundViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public FoundViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is found fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}