package com.github.originalblackhole.core.impl;

import com.github.originalblackhole.core.SysService;
import com.jacob.com.Dispatch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SysServiceImpl extends AbstractCommonService implements SysService {

    @Override
    public Long delay(Long mis) {
        return Long.parseLong(Dispatch.call(com, "Delay",mis).toString());
    }

    @Override
    public Long getScreenWidth() {
        return Long.parseLong(Dispatch.call(com, "GetScreenWidth").toString());
    }

    @Override
    public Long getScreenHeight() {
        return Long.parseLong(Dispatch.call(com, "GetScreenHeight").toString());
    }

    @Override
    public String getDir(int type) {
        return Dispatch.call(com, "GetDir",type).toString();
    }

    @Override
    public String getClipboard() {
        return Dispatch.call(com, "GetClipboard").toString();
    }

    @Override
    public Long setClipboard(String value) {
        return Long.parseLong(Dispatch.call(com, "SetClipboard",value).toString());
    }
}
