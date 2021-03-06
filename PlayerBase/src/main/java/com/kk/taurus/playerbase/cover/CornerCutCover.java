/*
 * Copyright 2017 jiajunhui<junhui_jia@163.com>
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.kk.taurus.playerbase.cover;

import android.content.Context;
import android.view.View;

import com.kk.taurus.playerbase.cover.base.BaseCover;
import com.kk.taurus.playerbase.inter.ICover;
import com.kk.taurus.playerbase.view.CornerCutView;

/**
 * Created by Taurus on 2017/3/31.
 */

public class CornerCutCover extends BaseCover {

    public static final String KEY = "corner_cut_cover";
    private CornerCutView mCornerView;

    public CornerCutCover(Context context){
        super(context);
    }

    @Override
    protected void setDefaultGone() {

    }

    @Override
    protected void findView() {

    }

    public void setCornerBgColor(int color){
        mCornerView.setCornerBgColor(color);
    }

    public void setCornerRadius(int radius){
        mCornerView.setCornerRadius(radius);
    }

    @Override
    public View initCoverLayout(Context context) {
        return mCornerView = new CornerCutView(context);
    }

    @Override
    public int getCoverLevel() {
        return ICover.COVER_LEVEL_HIGH;
    }

}
