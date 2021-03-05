package com.github.originalblackhole.common;

import java.util.stream.Stream;

public enum LastErrorEnum {

    SUCCESS(0,"成功"),
    ERROR_1(-1,"表示你使用了绑定里的收费功能，但是没注册，无法使用"),
    ERROR_2(-2,"使用模式0 2 时出现，因为目标窗口有保护. 常见于win7以上系统.或者有安全软件拦截插件.解决办法: 关闭所有安全软件，然后再重新尝试. 如果还不行就可以肯定是目标窗口有特殊保护"),
    ERROR_3(-3,"使用模式0 2 时出现，可能目标窗口有保护，也可能是异常错误. 可以尝试换绑定模式或许可以解决"),
    ERROR_4(-4,"使用模式101 103时出现，这是异常错误"),
    ERROR_5(-5,"使用模式101 103时出现, 这个错误的解决办法就是关闭目标窗口，重新打开再绑定即可. 也可能是运行脚本的进程没有管理员权限"),
    ERROR_6(-6,"被安全软件拦截。典型的是金山.360等. 如果是360关闭即可。 如果是金山，必须卸载，关闭是没用的"),
    ERROR_7(-7,"使用模式101 103时出现,异常错误. 还有可能是安全软件的问题，比如360等。尝试卸载360"),
    ERROR_8(-8,"使用模式101 103时出现, 目标进程可能有保护,也可能是插件版本过老，试试新的或许可以解决. -8可以尝试使用DmGuard中的np2盾配合"),
    ERROR_9(-9,"使用模式101 103时出现,异常错误. 还有可能是安全软件的问题，比如360等。尝试卸载360"),
    ERROR_10(-10,"使用模式101 103时出现, 目标进程可能有保护,也可能是插件版本过老，试试新的或许可以解决. -8可以尝试使用DmGuard中的np2盾配合"),
    ERROR_11(-11,"使用模式101 103时出现, 目标进程有保护. 告诉我解决"),
    ERROR_12(-12,"使用模式101 103时出现, 目标进程有保护. 告诉我解决"),
    ERROR_13(-13,"使用模式101 103时出现, 目标进程有保护. 或者是因为上次的绑定没有解绑导致。 尝试在绑定前调用ForceUnBindWindow"),
    ERROR_14(-14,"可能系统缺少部分DLL,尝试安装d3d. 或者是鼠标或者键盘使用了dx.mouse.api或者dx.keypad.api，但实际系统没有插鼠标和键盘. 也有可能是图色中有dx.graphic.3d之类的,但相应的图色被占用,比如全屏D3D程序"),
    ERROR_15(-15,""),
    ERROR_16(-16,"可能使用了绑定模式 0 和 101，然后可能指定了一个子窗口.导致不支持.可以换模式2或者103来尝试. 另外也可以考虑使用父窗口或者顶级窗口.来避免这个错误。还有可能是目标窗口没有正常解绑 然后再次绑定的时候"),
    ERROR_17(-17,"模式101 103时出现. 这个是异常错误. 告诉我解决"),
    ERROR_18(-18,"句柄无效"),
    ERROR_19(-19,"使用模式0 11 101时出现,这是异常错误,告诉我解决"),
    ERROR_20(-20,"使用模式101 103 时出现,说明目标进程里没有解绑，并且子绑定达到了最大. 尝试在返回这个错误时，调用ForceUnBindWindow来强制解除绑定"),
    ERROR_21(-21,"使用模式101 103 时出现,说明目标进程里没有解绑. 尝试在返回这个错误时，调用ForceUnBindWindow来强制解除绑定"),
    ERROR_22(-22,"使用模式0 2,绑定64位进程窗口时出现,因为安全软件拦截插件释放的EXE文件导致"),
    ERROR_23(-23,"使用模式0 2,绑定64位进程窗口时出现,因为安全软件拦截插件释放的DLL文件导致"),
    ERROR_24(-24,"使用模式0 2,绑定64位进程窗口时出现,因为安全软件拦截插件运行释放的EXE"),
    ERROR_25(-25,"使用模式0 2,绑定64位进程窗口时出现,因为安全软件拦截插件运行释放的EXE"),
    ERROR_26(-26,"使用模式0 2,绑定64位进程窗口时出现, 因为目标窗口有保护. 常见于win7以上系统.或者有安全软件拦截插件.解决办法: 关闭所有安全软件，然后再重新尝试. 如果还不行就可以肯定是目标窗口有特殊保护"),
    ERROR_27(-27,"绑定64位进程窗口时出现，因为使用了不支持的模式，目前暂时只支持模式0 2 101 103"),
    ERROR_28(-28,"绑定32位进程窗口时出现，因为使用了不支持的模式，目前暂时只支持模式0 2 101 103"),
    ERROR_100(-100,"调用读写内存函数后，发现无效的窗口句柄"),
    ERROR_101(-101,"读写内存函数失败"),
    ERROR_200(-200,"AsmCall失败");

    private Integer code;

    private String message;

    LastErrorEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static String getMessage(Integer code) {
        return Stream.of(values()).filter(e -> e.getCode().equals(code)).findFirst().orElse(null).getMessage();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
