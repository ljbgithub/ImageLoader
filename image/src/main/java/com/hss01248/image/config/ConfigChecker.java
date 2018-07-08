package com.hss01248.image.config;

import android.text.TextUtils;

import java.io.File;

/**
 * Created by huangshuisheng on 2018/3/22.
 */

public class ConfigChecker {
    public static boolean check(SingleConfig config) {
        if (!checkImageSource(config)) {
            return false;
        }
        adjustWidthAndHeight(config);
        return true;
    }

    /*
    根据view上设置的宽高来决定最终的resize option
     */
    private static void adjustWidthAndHeight(SingleConfig config) {

    }

    private static boolean checkImageSource(SingleConfig config) {
        if (!TextUtils.isEmpty(config.getUrl())) {
            return true;
        }
        if (!TextUtils.isEmpty(config.getFilePath())) {
            File file = new File(config.getFilePath());
            if (file.exists()) {
                return true;
            }
        }
        if (!TextUtils.isEmpty(config.getContentProvider())) {
            return true;
        }

        if (config.getResId() != 0) {
            return true;
        }

        return false;
    }
}
