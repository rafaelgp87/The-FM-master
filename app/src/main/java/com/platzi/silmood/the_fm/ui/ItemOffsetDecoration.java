package com.platzi.silmood.the_fm.ui;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.DimenRes;
import android.support.annotation.IntegerRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <p/>
 * Created by Pedro Hernández on 07/2015.
 */

public class ItemOffsetDecoration extends RecyclerView.ItemDecoration{


    private int mItemOffset;

    public ItemOffsetDecoration (int itemOffset){
        mItemOffset = itemOffset;
    }

    public ItemOffsetDecoration (@NonNull Context context, @IntegerRes int itemOffsetId){
        int itemOffsetDp = context.getResources().getInteger(itemOffsetId);
        mItemOffset = setupDimensions(context.getResources().getDisplayMetrics(), itemOffsetDp);
    }

    private int setupDimensions(DisplayMetrics metrics, int offsetDp) {
        return  offsetDp * (metrics.densityDpi / 160);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.set(mItemOffset,mItemOffset,mItemOffset,mItemOffset);
    }
}
