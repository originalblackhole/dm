package com.github.originalblackhole.core.impl;

import com.github.originalblackhole.common.WindowState;
import com.github.originalblackhole.core.WindowService;
import com.jacob.com.Dispatch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class WindowServiceImpl extends AbstractCommonService implements WindowService {

    @Override
    public Long findWindow(String clz, String title) {
        return Long.parseLong(Dispatch.call(com, "FindWindow",clz,title).toString());
    }

    @Override
    public Long findWindowEx(int parent, String clz, String title) {
        return Long.parseLong(Dispatch.call(com, "FindWindowEx",parent,clz,title).toString());
    }

    @Override
    public Long getMousePointWindow() {
        return Long.parseLong(Dispatch.call(com, "GetMousePointWindow").toString());
    }

    @Override
    public Long bindWindow(Long hwnd, String display, String mouse, String keypad, int mode) {
        return Long.parseLong(Dispatch.call(com, "BindWindow",hwnd,display,mouse,keypad,mode).toString());
    }

    @Override
    public Long bindWindowEx(Long hwnd, String display, String mouse, String keypad, String pub, int mode) {
        return Long.parseLong(Dispatch.call(com, "BindWindowEx",hwnd,display,mouse,keypad,pub,mode).toString());
    }

    @Override
    public Long forceUnBindWindow(Long hwnd) {
        return Long.parseLong(Dispatch.call(com, "ForceUnBindWindow",hwnd).toString());
    }

    @Override
    public Long setWindowState(Long hwnd, WindowState windowState) {
        return Long.parseLong(Dispatch.call(com, "SetWindowState",hwnd,windowState.getCode()).toString());
    }
}
