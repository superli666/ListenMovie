package com.lzx.listenmovieapp.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.widget.Toast;

/**
 * @author :Road
 * @ClassName: ToastUtil
 * @Description: Toast帮助类
 */
public class ToastUtil {
    /**
     * 上次使用时间
     */
    private static long mLastClickTime = 0;
    /**
     * 间隔时间
     */
    private static final long TIMELONG = 1500;
    /**
     * 上次提示内容
     */
    private static int mStrId = 0;
    /**
     * 上次提示内容
     */
    private static String mStrTip = "";

    /**
     * @return
     */
    public static void MyToast(Context context, int tipId) {
        long time = System.currentTimeMillis();
        long timeD = time - mLastClickTime;
        Log.d("Double-Click Time", timeD + "");
        if (timeD > TIMELONG) {
            Toast.makeText(context, tipId, Toast.LENGTH_SHORT).show();
            mStrId = tipId;
            mLastClickTime = time;
            return;
        }
        if (mStrId != tipId) {
            Toast.makeText(context, tipId, Toast.LENGTH_SHORT).show();
            mStrId = tipId;
            mLastClickTime = time;
        }
    }

    /**
     * @return
     */
    public static void MyToast(Context context, String strTip) {
        long time = System.currentTimeMillis();
        long timeD = time - mLastClickTime;
        Log.d("Double-Click Time", timeD + "");
        if (timeD > TIMELONG) {
            Toast.makeText(context, strTip, Toast.LENGTH_SHORT).show();
            mStrTip = strTip;
            mLastClickTime = time;
            return;
        }
        if (!mStrTip.equals(strTip)) {
            Toast.makeText(context, strTip, Toast.LENGTH_SHORT).show();
            mStrTip = strTip;
            mLastClickTime = time;
        }
    }

    /**
     * 对话框
     */
    public static void showMessageOKCancel(String message, Context context, String positiveText, String negativeText, DialogInterface.OnClickListener okListener) {
        if (positiveText.isEmpty()) positiveText = "是";
        if (negativeText.isEmpty()) negativeText = "否";
        new AlertDialog.Builder(context)
                .setMessage(message)
                .setPositiveButton(positiveText, okListener)
                .setNegativeButton(negativeText, null)
                .create()
                .show();
    }
}
