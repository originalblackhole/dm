package com.github.originalblackhole.core;

public interface CommonService {

    /**
     * 设置全局路径,设置了此路径后,
     * 所有接口调用中,相关的文件都相对于此路径.
     * 比如图片,字库等.
     * @param path
     * @return
     */

    boolean setPath(String path);

    /**
     * 获取全局路径.(可用于调试)
     * @return 返回当前设置的全局路径
     */
    String getPath();

    /**
     * 获取插件命令的最后错误
     * @return
     */
    Long getLastError();

    /**
     * 获取插件命令的最后错误信息
     * @param code
     * @return
     */
    String getMessage(int code);

    /**
     * 获取注册在系统中的dm.dll的路径
     * @return 返回dm.dll所在路径
     */
    String getBasePath();

    /**
     * 返回当前进程已经创建的dm对象个数
     * 收费功能需要注册
     * @return
     */
    Long getDmCount();

    /**
     * 返回当前大漠对象的ID值，
     * 这个值对于每个对象是唯一存在的。
     * 可以用来判定两个大漠对象是否一致.
     * @return 当前对象的ID值
     */
    Long getId();

    /**
     * 非简单游平台使用，调用此函数来注册，
     * 从而使用插件的高级功能.推荐使用此函数
     * @param reg_code 注册码
     * @param ver_info 版本附加信息
     * @return
     */
    Long reg(String reg_code, String ver_info);

    /**
     * 非简单游平台使用，调用此函数来注册，
     * 从而使用插件的高级功能.
     * 可以根据指定的IP列表来注册. 新手不建议使用!
     * @return @see RegEnum
     */
    /**
     *
     * @param reg_code 注册码
     * @param ver_info 版本附加信息
     * @param ip
     *           插件注册的ip地址.可以用|来组合,
     *           依次对ip中的地址进行注册，直到成功. ip地址列表在VIP群中获取
     * @return @see RegEnum
     */
    Long regEx(String reg_code, String ver_info, String ip);

    /**
     * 调用此函数来注册，从而使用插件的高级功能.
     * 可以根据指定的IP列表来注册.新手不建议使用!
     * 此函数同RegEx函数的不同在于,此函数用于注册的机器码是不带mac地址的
     * @param reg_code 注册码
     * @param ver_info 版本附加信息
     * @param ip
     *          插件注册的ip地址.可以用|来组合,依次对ip中的地址进行注册，
     *          直到成功. ip地址列表在VIP群中获取.
     * @return @see RegEnum
     */
    Long regExNoMac(String reg_code, String ver_info, String ip);

    /**
     * 调用此函数来注册，从而使用插件的高级功能.推荐使用此函数.
     * 新手不建议使用! 此函数同Reg函数的不同在于,
     * 此函数用于注册的机器码是不带mac地址的.
     * @param reg_code 注册码
     * @param ver_info 版本附加信息
     * @return @see RegEnum
     */
    Long regNoMac(String reg_code, String ver_info);

    /**
     * 设定图色的获取方式，默认是显示器或者后台窗口
     * (具体参考BindWindow)
     * @param mode 图色输入模式
     *  1、screen 默认的模式，表示使用显示器或者后台窗口
     *  2、pic:file 指定输入模式为指定的图片,如果使用了这个模式，则所有和图色相关的函数
     *  3、mem:addr,size
     *     指定输入模式为指定的图片,此图片在内存当中. addr为图像内存地址,size为图像内存大小.
     *     如果使用了这个模式，则所有和图色相关的函数,均视为对此图片进行处理.
     *     比如文字识别 查找图片 颜色 等等一切图色函数.
     *
     * 返回值:
     * @return
     */
    Long setDisplayInput(String mode);

    /**
     *  设置EnumWindow  EnumWindowByProcess  EnumWindowSuper FindWindow
     *  以及FindWindowEx的最长延时. 内部默认超时是10秒
     * @param delay 单位毫秒
     * @return
     */
    Long setEnumWindowDelay(Long delay);

    /**
     * 设置是否弹出错误信息,默认是打开
     * @param show 0表示不打开,1表示打开
     * @return
     */
    Long setShowErrorMsg(int show);

    /**
     * 设置是否对前台图色进行加速. (默认是关闭).
     * (对于不绑定，或者绑定图色为normal生效)( 仅对WIN8以上系统有效)
     * @param enable 0 : 关闭  1 : 打开
     * @return
     */
    Long speedNormalGraphic(int enable);

    /**
     *  返回当前插件版本号
     * @return
     */
    String getVersion();

    /**
     * 针对部分检测措施的保护盾.前面有五角星的表示同时支持32位和64位,否则就仅支持64位.
     * 驱动功能支持的系统版本号为(win7/win8/win8.1/win10(10240)/win10(10586)
     * /win10(14393)/win10(15063)/win10(16299)/win10(17134)
     * 不支持所有的预览版本,仅仅支持正式版本
     * @param enable
     *              0 表示关闭保护盾(仅仅对memory memory2 memory3 b2 b3起作用)
     *              1 表示打开保护盾
     * @param type
     * @return
     */
    Long dmGuard(int enable, String type);

    /**
     *  卸载插件相关的所有驱动. 仅对64位系统的驱动生效
     *  此接口一般不建议使用. 除非你真的知道自己在干什么
     *
     * @return
     */
    Long unLoadDriver();
}
