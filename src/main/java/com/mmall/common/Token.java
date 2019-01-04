package com.mmall.common;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author LiuZX liuzhixiang
 * DATE   2018/9/25
 */

public class Token {

    private static Cache<Integer, String> cache = CacheBuilder.newBuilder()
            .maximumSize(1000)
            .maximumWeight(10000)
            .weigher((key, value) -> {
                if (Integer.parseInt(key.toString()) == 10000) {
                    return 10000;
                }
                return 0;
            })
            .expireAfterAccess(30, TimeUnit.MINUTES)
            .build();

    public static String getCache(Integer key) {
        try {
            return cache.get(key, () -> "null");
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
}
