package com.example.adrian.mymvvmexample.jsonplaceholder.interactor;

import android.util.Log;

import com.example.adrian.mymvvmexample.jsonplaceholder.model.Comment;
import com.example.adrian.mymvvmexample.jsonplaceholder.service.CommentService;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

public class CommentInteractorImpl implements CommentInteractor {

    private static final String TAG = CommentInteractorImpl.class.getName();

    private CommentService commentService;

    private Observer<List<Comment>> commentListObserver;
    private Observer<Comment> commentObserver;

    public CommentInteractorImpl(CommentService commentService) {
        this.commentService = commentService;

        createAlbumListObserver();
        createAlbumObserver();
    }

    private void createAlbumListObserver() {
        Log.i(TAG, "createAlbumListObserver ...");

        commentListObserver = new Observer<List<Comment>>() {
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
            public void onNext(List<Comment> comments) {
                Log.i(TAG, "onNext");
                Log.i(TAG, comments.toString());
            }
        };
    }

    private void createAlbumObserver() {
        Log.i(TAG, "createAlbumObserver ...");

        commentObserver = new Observer<Comment>() {
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
            public void onNext(Comment comment) {
                Log.i(TAG, "onNext");
                Log.i(TAG, comment.toString());
            }
        };
    }

    @Override
    public void findAllComment() {
        commentService.findAllComment()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(commentListObserver);
    }

}
