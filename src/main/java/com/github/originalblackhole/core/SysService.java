package com.github.originalblackhole.core;

public interface SysService {

    /**
     * 延时指定的毫秒,过程中不阻塞UI操作
     * 由于是com组件,调用此函数必须保证调用线程的模型为MTA.否则此函数可能会失效
     *
     * @param mis 毫秒数. 必须大于0.
     * @return
     */
    Long delay(Long mis);

    /**
     * 获取屏幕的宽度
     * @return
     */
    Long getScreenWidth();

    /**
     * 获取屏幕的高度
     * @return
     */
    Long getScreenHeight();

    /**
     * 得到系统的路径
     * @param type
     *             0 : 获取当前路径
     *             1 : 获取系统路径(system32路径)
     *             2 : 获取windows路径(windows所在路径)
     *             3 : 获取临时目录路径(temp)
     *             4 : 获取当前进程(exe)所在的路径
     * @return
     */
    String getDir(int type);

    /**
     * 获取剪贴板的内容
     * @return
     */
    String getClipboard();

    /**
     * 设置剪贴板的内容
     * @param value
     * @return
     */
    Long setClipboard(String value);
}
