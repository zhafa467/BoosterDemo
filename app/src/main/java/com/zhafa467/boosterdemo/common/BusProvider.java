package com.zhafa467.boosterdemo.common;

import com.squareup.otto.Bus;

/**
 * Created by fan zhang on 16/12/21.
 */

public class BusProvider {
    private static Bus bus;

    public static Bus getBus() {
        if (bus == null)
            bus = new Bus();
        return bus;
    }
}
