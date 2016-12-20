package com.zhafa467.boosterdemo.common;

import com.zhafa467.boosterdemo.R;

/**
 * Created by fan zhang on 16/12/20.
 */

public class InvestorTypeScheme {
    public static final int NONE = -1;
    public static final int[] DEFENSIVE = new int[]{R.drawable.pic_cgf, NONE, NONE};
    public static final int[] CONSERVATIVE = new int[]{R.drawable.pic_dsf, R.drawable.pic_mf, NONE};
    public static final int[] BALANCED = new int[]{R.drawable.pic_bf, NONE, NONE};
    public static final int[] BALANCED_GROWTH = new int[]{R.drawable.pic_bgf, NONE, NONE};
    public static final int[] GROWTH = new int[]{R.drawable.pic_hgf, NONE, NONE};
    public static final int[] AGGRESSIVE_GROWTH = new int[]{R.drawable.pic_hgf, NONE, NONE};
}
