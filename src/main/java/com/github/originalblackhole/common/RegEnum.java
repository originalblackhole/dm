package com.github.originalblackhole.common;

import java.util.stream.Stream;

public enum RegEnum {

    CANNOT_CONNECT(-1,"无法连接网络,(可能防火墙拦截,如果可以正常访问大漠插件网站，那就可以肯定是被防火墙拦截)"),
    PROCESS_RUN_ERROR(-2,"进程没有以管理员方式运行. (出现在win7 win8 vista 2008.建议关闭uac)"),
    FAIL(0,"失败 (未知错误)"),
    SUCCESS(1,"成功"),
    NOT_SUFFICIENT_FUNDS(2,"余额不足"),
    BINDING_NOT_SUFFICIENT_FUNDS(3,"绑定了本机器，但是账户余额不足50元"),
    REGISTRATION_CODE_ERROR(4,"注册码错误"),
    IP_IN_BLACKLIST(5,"你的机器或者IP在黑名单列表中或者不在白名单列表中."),
    ILLEGAL_USE(6,"非法使用插件."),
    ILLEGAL_USE_BANNED(7,"你的帐号因为非法使用被封禁. （如果是在虚拟机中使用插件，必须使用Reg或者RegEx，不能使用RegNoMac或者RegExNoMac,否则可能会造成封号，或者封禁机器）"),
    IP_ILLEGAL_USE(77,"机器码或者IP因为非法使用，而被封禁. （如果是在虚拟机中使用插件，必须使用Reg或者RegEx，不能使用RegNoMac或者RegExNoMac,否则可能会造成封号，或者封禁机器）\n"+
                   "封禁是全局的，如果使用了别人的软件导致77，也一样会导致所有注册码均无法注册。解决办法是更换IP，更换MAC."),
    VERSION_INFORMATION_TOO_LONG(-8,"版本附加信息长度超过了20"),
    VERSION_INFORMATION_LLEGAL_LETTERS(-9,"版本附加信息里包含了非法字母"),
    LLEGAL_PARAMETER_IP(-10,"非法的参数ip");

    private Integer code;

    private String value;

    RegEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public static RegEnum getEnum(Integer code) {
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
