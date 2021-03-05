package com.github.originalblackhole.core;


import com.github.originalblackhole.model.Point;

public interface ColorService{

    /**
     * 获取(x,y)的颜色,颜色返回格式"RRGGBB",
     * 注意,和按键的颜色格式相反
     *
     * @param x
     * @param y
     * @return
     */
    String getColor(int x,int y);

    /**
     * 获取(x,y)的颜色,颜色返回格式"BBGGRR"
     * @param x
     * @param y
     * @return
     */
    String getColorBGR(int x,int y);

    /**
     * 获取(x,y)的HSV颜色,颜色返回格式"H.S.V"
     * @param x
     * @param y
     * @return
     */
    String getColorHSV(int x,int y);

    /**
     * 查找指定区域内的颜色,颜色格式"RRGGBB-DRDGDB",注意,和按键的颜色格式相反
     *
     * @param x1 区域的左上X坐标
     * @param y1 区域的左上Y坐标
     * @param x2 区域的右下X坐标
     * @param y2 区域的右下Y坐标
     * @param color 颜色 格式为"RRGGBB-DRDGDB",比如"123456-000000|aabbcc-202020".注意，这里只支持RGB颜色
     * @param sim 相似度,取值范围0.1-1.0
     * @param dir 查找方向
     *              0: 从左到右,从上到下
     *              1: 从左到右,从下到上
     *              2: 从右到左,从上到下
     *              3: 从右到左,从下到上
     *              4：从中心往外查找
     *              5: 从上到下,从左到右
     *              6: 从上到下,从右到左
     *              7: 从下到上,从左到右
     *              8: 从下到上,从右到左
     * @return
     */
    Point findColor(int x1, int y1, int x2, int y2, String color, double sim, int dir);
}
