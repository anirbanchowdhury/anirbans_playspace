package com.anicompany.fixtures;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Anirban on 4/27/2014.
 */
public class BaseSlim {
    public List<Object> list(Object... objs) {
        LinkedList<Object> result = new LinkedList<Object>();

        for (Object current : objs)
            result.add(current);

        return result;
    }
}
