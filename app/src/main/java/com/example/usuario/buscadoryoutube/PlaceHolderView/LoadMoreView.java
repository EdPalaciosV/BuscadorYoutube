package com.example.usuario.buscadoryoutube.PlaceHolderView;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.example.usuario.buscadoryoutube.POJO.MisItem;
import com.example.usuario.buscadoryoutube.R;
import com.mindorks.placeholderview.InfinitePlaceHolderView;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.infinite.LoadMore;

import java.util.List;

@Layout(R.layout.load_more_items)
public class LoadMoreView {
    public static final int LOAD_VIEW_SET_COUNT = 6;

    private InfinitePlaceHolderView mLoadMoreView;
    private List<MisItem> items;
    private Context contextVista;
    public LoadMoreView(Context contextVista,InfinitePlaceHolderView mLoadMoreView, List<MisItem> items) {
        this.contextVista=contextVista;
        this.mLoadMoreView = mLoadMoreView;
        this.items = items;
    }

    @LoadMore
    private void onLoadMore() {
        Log.d("DEBUG", "onLoadMore");
        new ForcedWaitedLoading();
    }

    class ForcedWaitedLoading implements Runnable {
        public ForcedWaitedLoading() {

            new Thread(this).start();
        }

        @Override
        public void run() {

            try {
                Thread.currentThread().sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            new Handler(Looper.getMainLooper()).post(new Runnable() {

                @Override
                public void run() {
                    int count = mLoadMoreView.getViewCount();

                    for (int i = count;
                         i < (count - 1 + LoadMoreView.LOAD_VIEW_SET_COUNT) && items.size() > i;
                         i++){

                        mLoadMoreView.addView(new ItemView(contextVista,mLoadMoreView.getContext(),items.get(i)));

                        if (i==items.size()-1)
                        {
                            mLoadMoreView.noMoreToLoad();
                            break;
                        }
                    }
                    mLoadMoreView.loadingDone();
                }

            });
        }

    }

}


