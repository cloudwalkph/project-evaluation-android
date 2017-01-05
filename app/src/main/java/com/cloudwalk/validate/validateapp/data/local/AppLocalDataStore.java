package com.cloudwalk.validate.validateapp.data.local;

import com.pushtorefresh.storio.contentresolver.StorIOContentResolver;

import java.util.List;

/**
 * Created by nkmcheng on 03/01/2017.
 */

public class AppLocalDataStore {

    private StorIOContentResolver mStorIOContentResolver;

    public void savePostToDatabase(List posts) {
        mStorIOContentResolver.put().objects(posts).prepare().executeAsBlocking();
    }

    public void saveEmployeeToDatabase(List employees) {
        mStorIOContentResolver.put().objects(employees).prepare().executeAsBlocking();
    }
}
