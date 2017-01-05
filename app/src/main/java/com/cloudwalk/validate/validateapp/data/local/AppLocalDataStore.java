package com.cloudwalk.validate.validateapp.data.local;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.cloudwalk.validate.validateapp.data.AppDataStore;
import com.cloudwalk.validate.validateapp.data.local.models.DatabaseContract;
import com.pushtorefresh.storio.contentresolver.ContentResolverTypeMapping;
import com.pushtorefresh.storio.contentresolver.StorIOContentResolver;
import com.pushtorefresh.storio.contentresolver.impl.DefaultStorIOContentResolver;
import com.cloudwalk.validate.validateapp.data.local.models.DatabaseContract.Post;
import com.pushtorefresh.storio.contentresolver.queries.Query;

import java.util.List;
import java.util.Observable;

import javax.inject.Inject;

/**
 * Created by nkmcheng on 03/01/2017.
 */

public class AppLocalDataStore {

    private StorIOContentResolver mStorIOContentResolver;

    public void savePostToDatabase(List posts) {
        mStorIOContentResolver.put().objects(posts).prepare().executeAsBlocking();
    }
}
