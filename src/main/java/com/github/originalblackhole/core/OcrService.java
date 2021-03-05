package com.github.originalblackhole.core;

public interface OcrService {

    /**
     * 设置字库文件
     * 此函数速度很慢，全局初始化时调用一次即可，切换字库用UseDict
     *
     * @param index 字库的序号,取值为0-99,目前最多支持100个字库
     * @param file 字库文件名
     * @return
     */
    Long setDict(int index, String file);

    /**
     * 表示使用哪个字库文件进行识别(index范围:0-99)
     * 设置之后，永久生效，除非再次设定
     * @param index 字库编号(0-99)
     * @return
     */
    Long useDict(String index);

    /**
     * 识别屏幕范围(x1,y1,x2,y2)内符合colorFormat的字符串,
     * 并且相似度为sim,sim取值范围(0.1-1.0),
     * 这个值越大越精确,越大速度越快,越小速度越慢,请斟酌使用!
     * ocr识别之前记得先设置字库
     * @param x1 区域的左上X坐标
     * @param y1 区域的左上Y坐标
     * @param x2 区域的右下X坐标
     * @param y2 区域的右下Y坐标
     * @param colorFormat 颜色格式串. 可以包含换行分隔符,语法是","后加分割字符串.
     *                     具体可以查看下面的示例.注意，RGB和HSV,以及灰度格式都支持.
     * @param sim 相似度,取值范围0.1-1.0
     * @return 返回识别到的字符串
     */
    String ocr(int x1, int y1, int x2, int y2, String colorFormat, double sim);

}
