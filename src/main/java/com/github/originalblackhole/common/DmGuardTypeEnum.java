package com.github.originalblackhole.common;

import java.util.stream.Stream;

public enum DmGuardTypeEnum {

    DM_GUARD_NP(1,"np","这个是防止NP检测(这个盾已经过时,不建议使用)"),
    DM_GUARD_MEMORY(2,"memory","这个保护内存系列接口和汇编接口可以正常运行. (此模式需要加载驱动)"),
    DM_GUARD_MEMORY2(3,"memory2","这个保护内存系列接口和汇编接口可以正常运行. (此模式需要加载驱动)"),
    DM_GUARD_MEMOR3(4,"memory3","这个保护内存系列接口和汇编接口可以正常运行.pid表示要操作内存的进程ID," +
            "指定了以后,所有内存系列接口仅能对此pid进程进行操作,其他进程无效. 但此盾速度较快。" +
            "addr_start表示起始地址(此参数可以忽略),addr_end表示结束地址(此参数可以忽略). 另外，" +
            "如果你发现有地址读写不到，可以尝试重新调用一次此盾.此盾是对指定的PID，指定的地址范围做快照. (此模式需要加载驱动)"),
    DM_GUARD_MEMORY4(5,"memory4","这个保护内存系列接口和汇编接口可以正常运行. (此模式需要加载驱动)"),
    DM_GUARD_DISPLAY2(6,"display2","同display,但此模式用在一些极端的场合. 比如用任何截图软件也无法截图时，可以考虑这个盾"),
    DM_GUARD_DISPLAY3(7,"display3","此盾可以保护当前进程指定的窗口(和子窗口)，无法被用正常手段截图. hwnd是必选参数. 并且必须是顶级窗口." +
            " 此盾有限制,具体查看下方的备注"),
    DM_GUARD_BLOCK(8,"block","保护指定进程不被非法访问. pid为可选参数.如果不指定pid，默认保护当前进程,另种实现方式." +
            "（此模式需要加载驱动,另外此盾在64位系统下无法隐藏驱动,调用后会让驱动无法隐藏,所以64位系统下,不太建议使用此盾)"),
    DM_GUARD_B2(9,"b2","保护指定进程不被非法访问. pid为可选参数.如果不指定pid，默认保护当前进程,另种实现方式.(此模式需要加载驱动)," +
            "另外,b2盾有副作用，会导致任何和音频输出的函数无声音(比如，Play和Beep函数，或者类似此函数实现的方式. " +
            "解决办法是另外创建一个进程用来播放音乐). 另外要特别注意，个别系统上，会出现保护进程退出时，导致系统蓝屏，" +
            "解决办法是在进程结束前，关闭b2盾即可"),
    DM_GUARD_B3(10,"b3","保护指定进程不被非法访问. pid为可选参数.如果不指定pid，默认保护当前进程,另种实现方式.(此模式需要加载驱动)," +
            "另外,b3盾有副作用，会导致无法创建线程，无法结束线程,无法操作某些系统API(比如打开文件对话框)，无法绑定目标窗口等等,解决办法是，" +
            "临时关闭b3，进行你的操作,然后再打开b3"),
    DM_GUARD_F1(11,"f1","把当前进程伪装成pid指定的进程，可以保护进程路径无法被获取到.如果省略pid参数，则伪装成svchost.exe进程. (此模式需要加载驱动)," +
            "另外，简单游平台专用版本无法使用此盾，原因是和简单游有冲突。   还有，使用此盾后，别人无法获取到你的进程的真实路径，但自己也同样无法获取，" +
            "所以如果要获取真实路径，请务必在获取到路径后保存，再调用此盾. pid参数如果有效，那必须是一个真实存在的pid,否则会失败.如果被伪装的进程关闭了，" +
            "那么当前进程也会立刻失去伪装. 还有最重要的一点，伪装的进程和目的进程，占用内存要差不多，最好目的进程占用内存要大于被伪装进程，" +
            "否则可能会导致进程崩溃!!!  有些编译平台编译出的程序,貌似开这个盾会导致异常，可以尝试f2盾"),
    DM_GUARD_F2(12,"f2","把protect_process伪装成target_process运行. 此盾会加载target_process运行,然后用protect_process来替换target_process," +
            "从而达到伪装自身的目的.此盾不加载驱动 (使用此盾后，别人无法获取到你的进程的真实路径，但自己也同样无法获取，所以如果要获取真实路径，"),
    DM_GUARD_D1(13,"d1","阻止指定的dll加载到本进程.这里的dll_name不区分大小写. 具体调用方法看下面的例子"),
    DM_GUARD_PHIDE(14,"phide","隐藏指定进程,保护指定进程以及进程内的窗口不被非法访问. pid为可选参数.如果不指定pid，默认保护当前进程." +
            "(此模式需要加载驱动,普通版本仅支持32位系统)"),
    DM_GUARD_PHIDE2(15,"phide2","同phide. 只是进程不隐藏(可在任务管理器中操作) (此模式需要加载驱动,普通版本仅支持32位系统)"),
    DM_GUARD_PHIDE3(16,"phide3","只隐藏进程(在任务管理器看不到),但不保护进程和窗口. (此模式需要加载驱动,普通版本仅支持32位系统)"),
    DM_GUARD_HM(17,"hm","防止当前进程中的指定模块被非法访问. module为模块名(为0表示EXE模块),比如dm.dll 。 unlink取0或者1，1表示是否把模块在进程模块链表中擦除," +
            "0表示不擦除.(此模式需要加载驱动)"),
    DM_GUARD_INJECT(18,"inject","注入指定的DLL到指定的进程中. 具体参数含义根据mode决定.(此模式需要加载驱动)"),
    DM_GUARD_CL(19,"cl","关闭指定进程中，对象名字中含有name的句柄. pid表示进程PID. type表示需要关闭的句柄类型. 比如Section Event Mutant等. " +
            "具体的类型可以用pchunter查看" +"name表示需要查找的对象名. 注意type和name都是大小写敏感的");

    private Integer code;

    private String value;

    private String message;

    DmGuardTypeEnum(Integer code, String value,String message) {
        this.code = code;
        this.value = value;
        this.message = message;
    }

    public static DmGuardTypeEnum getEnum(Integer code) {
        return Stream.of(values()).filter(e -> e.getCode().equals(code)).findFirst().orElse(null);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
