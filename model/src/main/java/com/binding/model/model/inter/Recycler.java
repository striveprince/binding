package com.binding.model.model.inter;

import android.databinding.ViewDataBinding;

import com.binding.model.adapter.AdapterHandle;

/**
 * Created by apple on 2017/7/28.
 */

public interface Recycler<Binding extends ViewDataBinding> extends Inflate<Binding>,Event{
    boolean areItemsTheSame(Parse parseRecycler);
    boolean areContentsTheSame(Parse parseRecycler);
//    void respond(@AdapterHandle int type,int status,Object...args);
    void check(boolean check);
}
