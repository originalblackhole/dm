package com.github.originalblackhole.core;


import com.github.originalblackhole.model.Point;

public interface PicService {

    /**
     * 查找指定区域内的图片,位图必须是24位色格式,支持透明色,
     * 当图像上下左右4个顶点的颜色一样时,则这个颜色将作为透明色处理.
     * 这个函数可以查找多个图片,只返回第一个找到的X Y坐标
     *
     * @param x1 区域的左上X坐标
     * @param y1 区域的左上Y坐标
     * @param x2 区域的右下X坐标
     * @param y2 区域的右下Y坐标
     * @param picName 图片名,可以是多个图片,比如"test.bmp|test2.bmp|test3.bmp"
     * @param deltaColor 颜色色偏比如"203040" 表示RGB的色偏分别是20 30 40 (这里是16进制表示)
     * @param sim 相似度,取值范围0.1-1.0
     * @param dir 查找方向 0: 从左到右,从上到下 1: 从左到右,从下到上 2: 从右到左,从上到下 3: 从右到左, 从下到上
     * @return Point 坐标  (-1，-1)表示没找到
     */
    Point findPic(int x1, int y1, int x2, int y2, String picName, String deltaColor, double sim, int dir);

}
