package com.example.myapplication.ui.ViewModel;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.myapplication.data.sources.ContactsDataSource;

public class ContactsViewModel extends AndroidViewModel {
    public ContactsViewModel(@NonNull Application application) {
        super(application);
    }

    public Intent getIntentMakeCall(){
        Uri number = Uri.parse("tel:" + ContactsDataSource.MARIA_NUMBER);
        return new Intent(Intent.ACTION_DIAL, number);
    }
}
