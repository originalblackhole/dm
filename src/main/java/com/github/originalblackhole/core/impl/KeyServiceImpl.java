package com.github.originalblackhole.core.impl;

import com.github.originalblackhole.common.KeyMapper;
import com.github.originalblackhole.core.KeyService;
import com.jacob.com.Dispatch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KeyServiceImpl extends AbstractCommonService implements KeyService {


    @Override
    public Long keyPress(int code) {
        return Long.parseLong(Dispatch.call(com, "KeyPress",code).toString());
    }

    @Override
    public Long keyPress(String key) {
        String value = KeyMapper.getKeyMapper().get(key);
        if(value == null){
            log.error("no mapping key was found , please switch keyPress(int core) method | {}", key);
            return 0L;
        }
        return Long.parseLong(Dispatch.call(com, "KeyPress",Integer.parseInt(value)).toString());
    }

    @Override
    public Long keyPressStr(String key_str, long delay) {
        return Long.parseLong(Dispatch.call(com, "KeyPressStr",key_str,delay).toString());
    }

    @Override
    public Long keyDown(int vkCode) {
        return Long.parseLong(Dispatch.call(com, "KeyDown",vkCode).toString());
    }

    @Override
    public Long keyDownChar(String vkCode) {
        return Long.parseLong(Dispatch.call(com, "KeyDownChar",vkCode).toString());
    }

    @Override
    public Long keyUp(int vkCode) {
        return Long.parseLong(Dispatch.call(com, "KeyUp",vkCode).toString());
    }

    @Override
    public Long keyUpChar(String vkCode) {
        return Long.parseLong(Dispatch.call(com, "KeyUpChar",vkCode).toString());
    }
}
