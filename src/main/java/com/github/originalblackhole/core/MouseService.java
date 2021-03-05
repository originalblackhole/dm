package com.github.originalblackhole.core;

import com.github.originalblackhole.model.Point;

public interface MouseService {

    /**
     * 设置当前系统鼠标的精确度开关。
     * 此接口仅仅对MoveR接口起作用
     * @param enable
     *              0 关闭指针精确度开关.
     *              1 打开指针精确度开关. 一般推荐关闭.
     * @return
     */
    Long enableMouseAccuracy(int enable);

    /**
     * 设置系统鼠标的移动速度.如图所示红色区域.
     * 一共分为11个级别. 从1开始,11结束。此接口仅仅对MoveR接口起作用
     * @param speed 鼠标移动速度, 最小1，最大11.  居中为6. 推荐设置为6
     * @return
     */
    Long setMouseSpeed(int speed);

    /**
     * 鼠标相对于上次的位置移动rx,ry.
     * 从6.1548版本开始,如果您要使鼠标移动的距离和指定的rx,ry一致,
     * 最好配合SetMouseSpeed和EnableMouseAccuracy函数来使用
     *
     * @param rx 相对于上次的X偏移
     * @param ry 相对于上次的Y偏移
     * @return
     */
    Long moveR(int rx, int ry);

    /**
     * 鼠标移动到目的点(x,y)
     * @param x
     * @param y
     * @return
     */
    Long moveTo(int x, int y);

    /**
     * 把鼠标移动到目的范围内的任意一点
     * @param x X坐标
     * @param y Y坐标
     * @param w 宽度(从x计算起)
     * @param h 高度(从y计算起)
     * @return
     */
    Point moveToEx(int x, int y, int w, int h);

    /**
     * 模拟鼠标左击
     * @return
     */
    Long leftClick();

    /**
     * 模拟鼠标右击
     * @return
     */
    Long rightClick();

    /**
     * 按住鼠标左键
     * @return
     */
    Long leftDown();

    /**
     * 弹起鼠标左键
     * @return
     */
    Long leftUp();

    /**
     * 获取鼠标位置
     * @return
     */
    Point getCursorPos();

    /**
     * 获取鼠标特征码. 当BindWindow或者BindWindowEx中的mouse参数含有dx.mouse.cursor时，
     * 获取到的是后台鼠标特征，否则是前台鼠标特征
     *
     * @return
     */
    String getCursorShape();

    /**
     * 获取鼠标特征码. 当BindWindow或者BindWindowEx
     * 中的mouse参数含有dx.mouse.cursor时，
     * 获取到的是后台鼠标特征，否则是前台鼠标特征
     *
     * @param type
     *      获取鼠标特征码的方式. 和工具中的方式1 方式2对应.
     *      方式1此参数值为0. 方式2此参数值为1.
     * @return
     *      成功时，返回鼠标特征码
     *      失败时，返回空的串
     */
    String getCursorShapeEx(int type);

    /**
     * 鼠标移动到指定区域随机位置(扩展方法)
     * @param x1 区域的左上X坐标
     * @param y1 区域的左上Y坐标
     * @param x2 区域的右下X坐标
     * @param y2 区域的右下Y坐标
     * @return
     */
    Point moveToRandomLocation(int x1, int y1, int x2, int y2);

}
