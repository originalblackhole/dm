package com.github.originalblackhole.common;

import java.util.stream.Stream;

public enum DmGuardErrorEnum {
    NOT_SUPPORT_TYPE(0,"不支持的保护盾类型"),
    SUCCESS(1,"成功"),
    NOT_SUPPORT_32_BIT(-1,"32位平台不支持"),
    DRIVE_RELEASE_FAILURE(-2,"驱动释放失败"),
    DRIVER_LOAD_FAILURE(-3,"驱动加载失败,可能是权限不够. 参考UAC权限设置.或者是被安全软件拦截. 如果是在64位系统下返回此错误，需要安装补丁KB3033929"),
    PATH_NOT_ACCESSIBLE(-555,"f2盾的返回值, protect_process路径无法访问"),
    UNABLE_CREATE_PROCESS(-666,"f2盾的返回值, target_process无法创建进程.(可能路径错误?)"),
    OTHER_ERROR(-777,"f2盾的返回值,其它异常错误."),
    ABNORMAL_ERROR_1(-4,"异常错误"),
    ABNORMAL_ERROR_2(-5,"异常错误"),
    OTHER_ERROR_3(-6,"异常错误"),
    SYS_NOT_SUPPORT(-7,"一般是系统版不支持导致,用winver可以查看系统内部版本号. 驱动只支持正式发布的版本，所有预览版本都不支持"),
    OTHER_ERROR_4(-8,"异常错误"),
    PARAMETER_ERROR(-9,"表示参数错误"),
    FUNCTIONAL_FAILURE(-10,"表示此盾的功能失败了"),
    ALLOCATED_MEMORY(-11,"表示分配内存失败"),
    INVALID_WINDOW_HANDLE(-14,"无效的窗口句柄"),
    ;

    private Integer code;

    private String value;

    DmGuardErrorEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public static DmGuardErrorEnum getEnum(Integer code) {
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
