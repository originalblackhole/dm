package com.github.originalblackhole.core;

import com.github.originalblackhole.common.WindowState;

public interface WindowService {

    /**
     * 查找符合类名或者标题名的顶层可见窗口
     *
     * @param clz 窗口类名，如果为空，则匹配所有. 这里的匹配是模糊匹配
     * @param title 窗口标题,如果为空，则匹配所有.这里的匹配是模糊匹配.
     * @return
     */
    Long findWindow(String clz,String title);

    /**
     * 查找符合类名或者标题名的顶层可见窗口,
     * 如果指定了parent,则在parent的第一层子窗口中查找
     *
     * @param parent 父窗口句柄，如果为空，则匹配所有顶层窗口
     * @param clz 窗口类名，如果为空，则匹配所有. 这里的匹配是模糊匹配.
     * @param title 窗口标题,如果为空，则匹配所有. 这里的匹配是模糊匹配
     * @return
     */
    Long findWindowEx(int parent,String clz,String title);

    /**
     * 获取鼠标指向的可见窗口句柄,可以获取到按键自带的插件无法获取到的句柄
     * @return
     */
    Long getMousePointWindow();

    /**
     * 绑定指定的窗口,并指定这个窗口的屏幕颜色获取方式,
     * 鼠标仿真模式,键盘仿真模式,以及模式设定,高级用户可以参考BindWindowEx更加灵活强大
     * @param hwnd 指定的窗口句柄
     * @param display 屏幕颜色获取方式
     * @param mouse 鼠标仿真模式
     * @param keypad 键盘仿真模式
     * @param mode 模式
     * @return
     */
    Long bindWindow(Long hwnd, String display, String mouse, String keypad, int mode);

    /**
     * 绑定指定的窗口,并指定这个窗口的屏幕颜色获取方式,
     * 鼠标仿真模式,键盘仿真模式 高级用户使用
     *
     * @param hwnd 指定的窗口句柄
     * @param display 屏幕颜色获取方式
     * @param mouse 鼠标仿真模式
     * @param keypad 键盘仿真模式
     * @param pub 公共属性 dx模式共有
     * @param mode 模式
     * @return
     */
    Long bindWindowEx(Long hwnd, String display, String mouse, String keypad, String pub, int mode);

    /**
     * 强制解除绑定窗口,并释放系统资源
     * @param hwnd 需要强制解除绑定的窗口句柄
     * @return
     */
    Long forceUnBindWindow(Long hwnd);

    /**
     * 设置窗口的状态
     * @param hwnd 指定的窗口句柄
     * @param windowState
     * @return
     */
    Long setWindowState(Long hwnd, WindowState windowState);

}
