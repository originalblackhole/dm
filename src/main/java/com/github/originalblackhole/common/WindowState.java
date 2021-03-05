package com.github.originalblackhole.common;

public enum WindowState {
    CLOSE_WINDOW(0,"关闭指定窗口"),
    ACTIVATE_WINDOW(1,"激活指定窗口"),
    MINIMIZE_WINDOW_NO_ACTIVATE(2,"最小化指定窗口,但不激活"),
    MINIMIZE_ACTIVATE_WINDOW(3,"最小化指定窗口,并释放内存,但同时也会激活窗口"),
    MAXIMIZE_ACTIVATE_WINDOW(4,"最大化指定窗口,同时激活窗口"),
    RECOVER_WINDOW_NO_ACTIVATE(5,"恢复指定窗口 ,但不激活"),
    HIDE_WINDOW(6,"隐藏指定窗口"),
    SHOW_WINDOW(7,"显示指定窗口"),
    ISTOP_WINDOW(8,"置顶指定窗口"),
    CANCEL_ISTOP_WINDOW(9,"取消置顶指定窗口"),
    PROHIBIT_WINDOW(10,"禁止指定窗口"),
    CANCEL_PROHIBIT_WINDOW(11,"取消禁止指定窗口"),
    RECOVER_ACTIVATE_WINDOW(12,"恢复并激活指定窗口"),
    FORCE_STOP_WINDOW_PROCESS(13,"强制结束窗口所在进程"),
    TWINKLE_WINDOW(14,"闪烁指定的窗口"),
    GETTING_INPUT_FOCUS_WINDOW(15,"使指定的窗口获取输入焦点");

    private Integer code;

    private String value;

    WindowState(Integer code, String value) {
        this.code = code;
        this.value = value;
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
