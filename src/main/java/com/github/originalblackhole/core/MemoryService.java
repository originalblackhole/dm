package com.github.originalblackhole.core;

public interface MemoryService {

    /**
     * 读取指定地址的二进制数据
     * @param hwnd 指定搜索的窗口句柄或者进程ID.  默认是窗口句柄. 如果要指定为进程ID,需要调用SetMemoryHwndAsProcessId.
     * @param addr 用字符串来描述地址，类似于CE的地址描述，数值必须是16进制,里面可以用[ ] + -这些符号来描述一个地址。+表示地址加，-表示地址减
     *              模块名必须用<>符号来圈起来
     * @param len  二进制数据的长度
     *
     * 1."4DA678" 最简单的方式，用绝对数值来表示地址
     * 2."<360SE.exe>+DA678" 相对简单的方式，只是这里用模块名来决定模块基址，后面的是偏移
     * 3."[4DA678]+3A" 用绝对数值加偏移，相当于一级指针
     * 4."[<360SE.exe>+DA678]+3A" 用模块定基址的方式，也是一级指针
     * 5."[[[<360SE.exe>+DA678]+3A]+5B]+8" 这个是一个三级指针
     * 总之熟悉CE的人 应该对这个地址描述都很熟悉,我就不多举例了
     *
     * @return 读取到的数值, 以16进制表示的字符串 每个字节以空格相隔 比如"12 34 56 78 ab cd ef"
     */
    String readData(Long hwnd,String addr,int len);

    /**
     * 读取指定地址的二进制数据
     * @param hwnd 指定搜索的窗口句柄或者进程ID.  默认是窗口句柄. 如果要指定为进程ID,需要调用SetMemoryHwndAsProcessId
     * @param addr 地址
     * @param len 二进制数据的长度
     * @return 读取到的数值, 以16进制表示的字符串 每个字节以空格相隔 比如"12 34 56 78 ab cd ef"
     */
    String readDataAddr(Long hwnd,String addr,int len);

    /**
     * 读取指定地址的二进制数据,只不过返回的是内存地址,而不是字符串.适合高级用户.
     * @param hwnd 指定搜索的窗口句柄或者进程ID.  默认是窗口句柄. 如果要指定为进程ID,需要调用SetMemoryHwndAsProcessId
     * @param addr 地址
     * @param len 二进制数据的长度
     * @return 读取到的数值, 以16进制表示的字符串 每个字节以空格相隔 比如"12 34 56 78 ab cd ef"
     */
    Long readDataAddrToBin(Long hwnd,String addr,int len);

    /**
     * 读取指定地址的二进制数据,只不过返回的是内存地址,而不是字符串.适合高级用户.
     * @param hwnd 指定搜索的窗口句柄或者进程ID.  默认是窗口句柄. 如果要指定为进程ID,需要调用SetMemoryHwndAsProcessId
     * @param addr 用字符串来描述地址，类似于CE的地址描述，数值必须是16进制,里面可以用[ ] + -这些符号来描述一个地址。+表示地址加，-表示地址减
     *              模块名必须用<>符号来圈起来
     * @param len 二进制数据的长度
     * @return 读取到的数据指针. 返回0表示读取失败.
     */
    Long readDataToBin(Long hwnd,String addr,int len);

    /**
     * 读取指定地址的双精度浮点数
     * @param hwnd 指定搜索的窗口句柄或者进程ID.  默认是窗口句柄. 如果要指定为进程ID,需要调用SetMemoryHwndAsProcessId.
     * @param addr 用字符串来描述地址，类似于CE的地址描述，数值必须是16进制,里面可以用[ ] + -这些符号来描述一个地址。+表示地址加，-表示地址减
     *              模块名必须用<>符号来圈起来
     * 例如:
     * 1."4DA678" 最简单的方式，用绝对数值来表示地址
     * 2."<360SE.exe>+DA678" 相对简单的方式，只是这里用模块名来决定模块基址，后面的是偏移
     * 3."[4DA678]+3A" 用绝对数值加偏移，相当于一级指针
     * 4."[<360SE.exe>+DA678]+3A" 用模块定基址的方式，也是一级指针
     * 5."[[[<360SE.exe>+DA678]+3A]+5B]+8" 这个是一个三级指针
     * 总之熟悉CE的人 应该对这个地址描述都很熟悉,我就不多举例了
     *
     * @return 读取到的数值
     */
    Double readDouble(Long hwnd,String addr);

    /**
     * 读取指定地址的双精度浮点数
     * @param hwnd 指定搜索的窗口句柄或者进程ID.  默认是窗口句柄. 如果要指定为进程ID,需要调用SetMemoryHwndAsProcessId.
     * @param addr 地址
     * @return 读取到的数值
     */
    Double readDoubleAddr(Long hwnd,String addr);

    /**
     * 读取指定地址的单精度浮点数
     * @param hwnd 指定搜索的窗口句柄或者进程ID.  默认是窗口句柄. 如果要指定为进程ID,需要调用SetMemoryHwndAsProcessId.
     * @param addr 用字符串来描述地址，类似于CE的地址描述，数值必须是16进制,里面可以用[ ] + -这些符号来描述一个地址。+表示地址加，-表示地址减
     *        模块名必须用<>符号来圈起来
     * 例如:
     * 1."4DA678" 最简单的方式，用绝对数值来表示地址
     * 2."<360SE.exe>+DA678" 相对简单的方式，只是这里用模块名来决定模块基址，后面的是偏移
     * 3."[4DA678]+3A" 用绝对数值加偏移，相当于一级指针
     * 4."[<360SE.exe>+DA678]+3A" 用模块定基址的方式，也是一级指针
     * 5."[[[<360SE.exe>+DA678]+3A]+5B]+8" 这个是一个三级指针
     * 总之熟悉CE的人 应该对这个地址描述都很熟悉,我就不多举例了
     * @return
     */
    Float readFloat(Long hwnd,String addr);

    /**
     * 读取指定地址的单精度浮点数
     * @param hwnd 指定搜索的窗口句柄或者进程ID.  默认是窗口句柄. 如果要指定为进程ID,需要调用SetMemoryHwndAsProcessId.
     * @param addr 地址
     * @return 读取到的数值
     */
    Float readFloatAddr(Long hwnd,String addr);

    /**
     * 读取指定地址的整数数值，类型可以是8位，16位  32位 或者64位
     * @param hwnd 读取指定地址的整数数值，类型可以是8位，16位  32位 或者64位
     * @param addr 用字符串来描述地址，类似于CE的地址描述，数值必须是16进制,里面可以用[ ] + -这些符号来描述一个地址。+表示地址加，-表示地址减
     *              模块名必须用<>符号来圈起来
     * 例如:
     * 1."4DA678" 最简单的方式，用绝对数值来表示地址
     * 2."<360SE.exe>+DA678" 相对简单的方式，只是这里用模块名来决定模块基址，后面的是偏移
     * 3."[4DA678]+3A" 用绝对数值加偏移，相当于一级指针
     * 4."[<360SE.exe>+DA678]+3A" 用模块定基址的方式，也是一级指针
     * 5."[[[<360SE.exe>+DA678]+3A]+5B]+8" 这个是一个三级指针
     * 总之熟悉CE的人 应该对这个地址描述都很熟悉,我就不多举例了
     *
     * @param type 整数类型,取值如下
     *              0 : 32位有符号
     *              1 : 16 位有符号
     *              2 : 8位有符号
     *              3 : 64位
     *              4 : 32位无符号
     *              5 : 16位无符号
     *              6 : 8位无符号
     * @return 读取到的数值
     */
    Long readInt(Long hwnd,String addr,int type);

    /**
     * 读取指定地址的整数数值，类型可以是8位，16位 32位 或者64位
     * @param hwnd 指定搜索的窗口句柄或者进程ID.  默认是窗口句柄. 如果要指定为进程ID,需要调用SetMemoryHwndAsProcessId
     * @param addr 地址
     * @param type 整数类型,取值如下
     *              0 : 32位有符号
     *              1 : 16 位有符号
     *              2 : 8位有符号
     *              3 : 64位
     *              4 : 32位无符号
     *              5 : 16位无符号
     *              6 : 8位无符号
     * @return 读取到的数值
     */
    Long readIntAddr(Long hwnd,String addr,int type);

    /**
     * 读取指定地址的字符串，可以是GBK字符串或者是Unicode字符串.(必须事先知道内存区的字符串编码方式)
     * @param hwnd 指定搜索的窗口句柄或者进程ID.  默认是窗口句柄. 如果要指定为进程ID,需要调用SetMemoryHwndAsProcessId.
     * @param addr 用字符串来描述地址，类似于CE的地址描述，数值必须是16进制,里面可以用[ ] + -这些符号来描述一个地址。+表示地址加，-表示地址减
     *              模块名必须用<>符号来圈起来
     * 例如:
     * 1."4DA678" 最简单的方式，用绝对数值来表示地址
     * 2."<360SE.exe>+DA678" 相对简单的方式，只是这里用模块名来决定模块基址，后面的是偏移
     * 3."[4DA678]+3A" 用绝对数值加偏移，相当于一级指针
     * 4."[<360SE.exe>+DA678]+3A" 用模块定基址的方式，也是一级指针
     * 5."[[[<360SE.exe>+DA678]+3A]+5B]+8" 这个是一个三级指针
     * 总之熟悉CE的人 应该对这个地址描述都很熟悉,我就不多举例了
     * @param type 字符串类型,取值如下
     *       0 : GBK字符串
     *       1 : Unicode字符串
     *       2 : UTF8字符串
     * @param len  需要读取的字节数目.如果为0，则自动判定字符串长度.
     * @return 读取到的字符串
     */
    String readString(Long hwnd,String addr,int type,int len);

    /**
     * 读取指定地址的字符串，可以是GBK字符串或者是Unicode字符串.(必须事先知道内存区的字符串编码方式)
     * @param hwnd 指定搜索的窗口句柄或者进程ID.  默认是窗口句柄. 如果要指定为进程ID,需要调用SetMemoryHwndAsProcessId.
     * @param addr 地址
     * @param type 字符串类型,取值如下
     *       0 : GBK字符串
     *       1 : Unicode字符串
     *       2 : UTF8字符串
     * @param len 需要读取的字节数目.如果为0，则自动判定字符串长度.
     * @return 读取到的字符串
     */
    String readStringAddr(Long hwnd,String addr,int type,int len);

    /**
     * 对指定地址写入二进制数据
     * @param hwnd 指定搜索的窗口句柄或者进程ID.  默认是窗口句柄. 如果要指定为进程ID,需要调用SetMemoryHwndAsProcessId.
     * @param addr 用字符串来描述地址，类似于CE的地址描述，数值必须是16进制,里面可以用[ ] + -这些符号来描述一个地址。+表示地址加，-表示地址减
     *              模块名必须用<>符号来圈起来
     * 例如:
     * 1."4DA678" 最简单的方式，用绝对数值来表示地址
     * 2."<360SE.exe>+DA678" 相对简单的方式，只是这里用模块名来决定模块基址，后面的是偏移
     * 3."[4DA678]+3A" 用绝对数值加偏移，相当于一级指针
     * 4."[<360SE.exe>+DA678]+3A" 用模块定基址的方式，也是一级指针
     * 5."[[[<360SE.exe>+DA678]+3A]+5B]+8" 这个是一个三级指针
     * 总之熟悉CE的人 应该对这个地址描述都很熟悉,我就不多举例了
     * @param data 二进制数据，以字符串形式描述，比如"12 34 56 78 90 ab cd"
     * @return 整形数:
     *          0 : 失败
     *          1 : 成功
     */
    Long writeData(Long hwnd,String addr,String data);

    /**
     * 对指定地址写入二进制数据
     * @param hwnd 指定搜索的窗口句柄或者进程ID.  默认是窗口句柄. 如果要指定为进程ID,需要调用SetMemoryHwndAsProcessId
     * @param addr 地址
     * @param data 二进制数据，以字符串形式描述，比如"12 34 56 78 90 ab cd"
     * @return 整形数:
     *          0 : 失败
     *          1 : 成功
     */
    Long writeDataAddr(Long hwnd,Long addr,String data);

    /**
     * 对指定地址写入二进制数据,只不过直接从数据指针获取数据写入,不通过字符串. 适合高级用户.
     * @param hwnd 指定搜索的窗口句柄或者进程ID.  默认是窗口句柄. 如果要指定为进程ID,需要调用SetMemoryHwndAsProcessId.
     * @param addr 地址
     * @param data 数据指针
     * @param len 数据长度
     * @return 整形数:
     *          0 : 失败
     *          1 : 成功
     */
    Long writeDataAddrFromBin(Long hwnd,Long addr,int data,int len);

    /**
     * 对指定地址写入二进制数据,只不过直接从数据指针获取数据写入,不通过字符串. 适合高级用户
     * @param hwnd 指定搜索的窗口句柄或者进程ID.  默认是窗口句柄. 如果要指定为进程ID,需要调用SetMemoryHwndAsProcessId.
     * @param addr 地址 用字符串来描述地址，类似于CE的地址描述，数值必须是16进制,里面可以用[ ] + -这些符号来描述一个地址。+表示地址加，-表示地址减
     *              模块名必须用<>符号来圈起来
     * 例如:
     * 1."4DA678" 最简单的方式，用绝对数值来表示地址
     * 2."<360SE.exe>+DA678" 相对简单的方式，只是这里用模块名来决定模块基址，后面的是偏移
     * 3."[4DA678]+3A" 用绝对数值加偏移，相当于一级指针
     * 4."[<360SE.exe>+DA678]+3A" 用模块定基址的方式，也是一级指针
     * 5."[[[<360SE.exe>+DA678]+3A]+5B]+8" 这个是一个三级指针
     * 总之熟悉CE的人 应该对这个地址描述都很熟悉,我就不多举例了
     * @param data 数据指针
     * @param len 数据长度
     * @return 整形数:
     *          0 : 失败
     *          1 : 成功
     */
    Long writeDataFromBin(Long hwnd,String addr,int data,int len);

    /**
     * 对指定地址写入双精度浮点数
     * @param hwnd 指定搜索的窗口句柄或者进程ID.  默认是窗口句柄. 如果要指定为进程ID,需要调用SetMemoryHwndAsProcessId.
     * @param addr 地址 用字符串来描述地址，类似于CE的地址描述，数值必须是16进制,里面可以用[ ] + -这些符号来描述一个地址。+表示地址加，-表示地址减
     *              模块名必须用<>符号来圈起来
     * 例如:
     * 1."4DA678" 最简单的方式，用绝对数值来表示地址
     * 2."<360SE.exe>+DA678" 相对简单的方式，只是这里用模块名来决定模块基址，后面的是偏移
     * 3."[4DA678]+3A" 用绝对数值加偏移，相当于一级指针
     * 4."[<360SE.exe>+DA678]+3A" 用模块定基址的方式，也是一级指针
     * 5."[[[<360SE.exe>+DA678]+3A]+5B]+8" 这个是一个三级指针
     * 总之熟悉CE的人 应该对这个地址描述都很熟悉,我就不多举例了
     * @param v 双精度浮点数
     * @return 整形数:
     *          0 : 失败
     *          1 : 成功
     */
    Long writeDouble(Long hwnd,String addr,double v);

    /**
     * 对指定地址写入双精度浮点数
     * @param hwnd 指定搜索的窗口句柄或者进程ID.  默认是窗口句柄. 如果要指定为进程ID,需要调用SetMemoryHwndAsProcessId
     * @param addr 地址
     * @param v 双精度浮点数
     * @return 整形数:
     *          0 : 失败
     *          1 : 成功
     */
    Long writeDoubleAddr(Long hwnd,Long addr,double v);

    /**
     * 对指定地址写入单精度浮点数
     * @param hwnd 指定搜索的窗口句柄或者进程ID.  默认是窗口句柄. 如果要指定为进程ID,需要调用SetMemoryHwndAsProcessId.
     * @param addr 地址 用字符串来描述地址，类似于CE的地址描述，数值必须是16进制,里面可以用[ ] + -这些符号来描述一个地址。+表示地址加，-表示地址减
     *              模块名必须用<>符号来圈起来
     * 例如:
     * 1."4DA678" 最简单的方式，用绝对数值来表示地址
     * 2."<360SE.exe>+DA678" 相对简单的方式，只是这里用模块名来决定模块基址，后面的是偏移
     * 3."[4DA678]+3A" 用绝对数值加偏移，相当于一级指针
     * 4."[<360SE.exe>+DA678]+3A" 用模块定基址的方式，也是一级指针
     * 5."[[[<360SE.exe>+DA678]+3A]+5B]+8" 这个是一个三级指针
     * 总之熟悉CE的人 应该对这个地址描述都很熟悉,我就不多举例了
     * @param v 双精度浮点数
     * @return 整形数:
     *          0 : 失败
     *          1 : 成功
     */
    Long writeFloat(Long hwnd,String addr,double v);

    /**
     * 对指定地址写入单精度浮点数
     * @param hwnd 指定搜索的窗口句柄或者进程ID.  默认是窗口句柄. 如果要指定为进程ID,需要调用SetMemoryHwndAsProcessId.
     * @param addr 地址
     * @param v 单精度浮点数
     * @return 整形数:
     *          0 : 失败
     *          1 : 成功
     */
    Long writeFloatAddr(Long hwnd,Long addr,double v);

    /**
     * 对指定地址写入整数数值，类型可以是8位，16位 32位 或者64位
     * @param hwnd 指定搜索的窗口句柄或者进程ID.  默认是窗口句柄. 如果要指定为进程ID,需要调用SetMemoryHwndAsProcessId.
     * @param addr 地址 用字符串来描述地址，类似于CE的地址描述，数值必须是16进制,里面可以用[ ] + -这些符号来描述一个地址。+表示地址加，-表示地址减
     *              模块名必须用<>符号来圈起来
     * 例如:
     * 1."4DA678" 最简单的方式，用绝对数值来表示地址
     * 2."<360SE.exe>+DA678" 相对简单的方式，只是这里用模块名来决定模块基址，后面的是偏移
     * 3."[4DA678]+3A" 用绝对数值加偏移，相当于一级指针
     * 4."[<360SE.exe>+DA678]+3A" 用模块定基址的方式，也是一级指针
     * 5."[[[<360SE.exe>+DA678]+3A]+5B]+8" 这个是一个三级指针
     * 总之熟悉CE的人 应该对这个地址描述都很熟悉,我就不多举例了
     * @param type 整数类型,取值如下
     *          0 : 32位
     *          1 : 16 位
     *          2 : 8位
     *          3 : 64位
     * @param v 整形数值
     * @return 整形数:
     *          0 : 失败
     *          1 : 成功
     */
    Long writeInt(Long hwnd,String addr,int type,int v);

    /**
     * 对指定地址写入整数数值，类型可以是8位，16位 32位 或者64位
     * @param hwnd 对指定地址写入整数数值，类型可以是8位，16位 32位 或者64位
     * @param addr 地址
     * @param type 整数类型,取值如下
     *          0 : 32位
     *          1 : 16 位
     *          2 : 8位
     *          3 : 64位
     * @param v 整形数值
     * @return 整形数:
     *          0 : 失败
     *          1 : 成功
     */
    Long writeIntAddr(Long hwnd,Long addr,int type,int v);

    /**
     * 对指定地址写入字符串，可以是Ascii字符串或者是Unicode字符串
     * @param hwnd 指定搜索的窗口句柄或者进程ID.  默认是窗口句柄. 如果要指定为进程ID,需要调用SetMemoryHwndAsProcessId.
     * @param addr 地址 用字符串来描述地址，类似于CE的地址描述，数值必须是16进制,里面可以用[ ] + -这些符号来描述一个地址。+表示地址加，-表示地址减
     *              模块名必须用<>符号来圈起来
     * 例如:
     * 1."4DA678" 最简单的方式，用绝对数值来表示地址
     * 2."<360SE.exe>+DA678" 相对简单的方式，只是这里用模块名来决定模块基址，后面的是偏移
     * 3."[4DA678]+3A" 用绝对数值加偏移，相当于一级指针
     * 4."[<360SE.exe>+DA678]+3A" 用模块定基址的方式，也是一级指针
     * 5."[[[<360SE.exe>+DA678]+3A]+5B]+8" 这个是一个三级指针
     * 总之熟悉CE的人 应该对这个地址描述都很熟悉,我就不多举例了
     * @param type 字符串类型,取值如下
     *          0 : Ascii字符串
     *          1 : Unicode字符串
     *          2 : UTF8字符串
     * @param v 字符串
     * @return 整形数:
     *          0 : 失败
     *          1 : 成功
     */
    Long writeString(Long hwnd,String addr,int type,String v);

    /**
     * 对指定地址写入字符串，可以是Ascii字符串或者是Unicode字符串
     * @param hwnd 指定搜索的窗口句柄或者进程ID.  默认是窗口句柄. 如果要指定为进程ID,需要调用SetMemoryHwndAsProcessId
     * @param addr 地址
     * @param type 字符串类型,取值如下
     *          0 : Ascii字符串
     *          1 : Unicode字符串
     *          2 : UTF8字符串
     * @param v 字符串
     * @return 整形数:
     *          0 : 失败
     *          1 : 成功
     */
    Long writeStringAddr(Long hwnd,Long addr,int type,String v);
}
