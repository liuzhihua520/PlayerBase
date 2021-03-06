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

package com.kk.taurus.playerbase.adapter;

import com.kk.taurus.playerbase.inter.IDataAdapter;
import com.kk.taurus.playerbase.setting.VideoData;

import java.util.List;

/**
 * Created by Taurus on 2017/4/19.
 */

public abstract class BaseVideoDataAdapter<V> implements IDataAdapter<VideoData> {

    protected List<V> mModels;
    protected boolean loop;
    protected int mIndex;
    protected int mPreIndex;

    public BaseVideoDataAdapter(List<V> models, int startIndex){
        this.mModels = models;
        this.mIndex = startIndex;
    }

    @Override
    public VideoData getPlayEntity() {
        V v = getItemModel();
        return modelTransEntity(v);
    }

    @Override
    public VideoData getPlayEntity(int index) {
        V v = getItemModel(index);
        return modelTransEntity(v);
    }

    @Override
    public VideoData getLoopNextPlayEntity() {
        int index = nextIndex();
        V v = getItemModel(index);
        return modelTransEntity(v);
    }

    @Override
    public int getIndex() {
        return mIndex;
    }

    @Override
    public int getPreIndex() {
        return mPreIndex;
    }

    @Override
    public void setIndex(int index) {
        this.mPreIndex = mIndex;
        this.mIndex = index;
    }

    protected int nextIndex(){
        if(getCount() > 0){
            mPreIndex = mIndex;
            mIndex++;
            mIndex = mIndex%getCount();
            return mIndex;
        }
        return -1;
    }

    public V getItemModel(){
        if(getCount() > 0)
            return mModels.get(mIndex);
        return null;
    }

    public V getItemModel(int index){
        if(getCount() > 0 && index < getCount())
            return mModels.get(index);
        return null;
    }

    protected abstract VideoData modelTransEntity(V model);

    @Override
    public int getCount() {
        if(mModels==null)
            return 0;
        return mModels.size();
    }

    @Override
    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
