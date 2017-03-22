package com.example.adrian.mymvvmexample.jsonplaceholder.interactor;

import android.util.Log;

import com.example.adrian.mymvvmexample.jsonplaceholder.model.Album;
import com.example.adrian.mymvvmexample.jsonplaceholder.service.AlbumService;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

public class AlbumInteractorImpl implements AlbumInteractor {

    private static final String TAG = AlbumInteractorImpl.class.getName();

    private Observer<List<Album>> albumListObserver;
    private Observer<Album> albumObserver;

    private AlbumService albumService;

    public AlbumInteractorImpl(AlbumService albumService) {
        this.albumService = albumService;

        createAlbumListObserver();
        createAlbumObserver();
    }
    private void createAlbumListObserver() {
        Log.i(TAG, "createAlbumListObserver ...");

        albumListObserver = new Observer<List<Album>>() {
            @Override
            public void onCompleted() {
                Log.i(TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "onError");
                e.printStackTrace();
            }

            @Override
            public void onNext(List<Album> albums) {
                Log.i(TAG, "onNext");
                Log.i(TAG, albums.toString());
            }
        };
    }

    private void createAlbumObserver() {
        Log.i(TAG, "createAlbumObserver ...");

        albumObserver = new Observer<Album>() {
            @Override
            public void onCompleted() {
                Log.i(TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "onError");
                e.printStackTrace();
            }

            @Override
            public void onNext(Album album) {
                Log.i(TAG, "onNext");
                Log.i(TAG, album.toString());
            }
        };
    }

    @Override
    public void findAllAlbum() {
        albumService.findAllAlbum()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(albumListObserver);
    }


}
