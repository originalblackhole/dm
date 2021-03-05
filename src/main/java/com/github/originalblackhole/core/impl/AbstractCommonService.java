package com.github.originalblackhole.core.impl;

import com.github.originalblackhole.common.LastErrorEnum;
import com.github.originalblackhole.core.CommonService;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractCommonService implements CommonService {

    protected Dispatch com;

    private ActiveXComponent dm;

    public AbstractCommonService() {
        dm = new ActiveXComponent("dm.dmsoft");
        com = dm.getObject();
        //this.setPath(".\\path");
        this.setPath("/");
    }

    @Override
    public String getPath() {
        return Dispatch.call(com, "GetPath").toString();
    }

    @Override
    public boolean setPath(String path) {
        Variant variant = Dispatch.call(com, "SetPath",path);
        if(variant != null && variant.toString().equals("1")){
            return true;
        }
        return false;
    }

    @Override
    public Long getLastError() {
        return Long.parseLong(Dispatch.call(com, "GetLastError").toString());
    }

    @Override
    public String getMessage(int code) {
        return LastErrorEnum.getMessage(code);
    }

    @Override
    public String getBasePath() {
        return Dispatch.call(com, "GetLastError").toString();
    }

    @Override
    public Long getDmCount() {
        return Long.parseLong(Dispatch.call(com, "GetDmCount").toString());
    }

    @Override
    public Long getId() {
        return Long.parseLong(Dispatch.call(com, "GetID").toString());
    }

    @Override
    public Long reg(String regCode, String verInfo) {
        return Long.parseLong(Dispatch.call(com, "Reg",regCode,verInfo).toString());
    }

    @Override
    public Long regEx(String regCode, String verInfo, String ip) {
        return Long.parseLong(Dispatch.call(com, "RegEx",regCode,verInfo,ip).toString());
    }

    @Override
    public Long regExNoMac(String regCode, String verInfo, String ip) {
        return Long.parseLong(Dispatch.call(com, "RegExNoMac",regCode,verInfo,ip).toString());
    }

    @Override
    public Long regNoMac(String regCode, String verInfo) {
        return Long.parseLong(Dispatch.call(com, "RegNoMac",regCode,verInfo).toString());
    }

    @Override
    public Long setDisplayInput(String mode) {
        return Long.parseLong(Dispatch.call(com, "SetDisplayInput",mode).toString());
    }

    @Override
    public Long setEnumWindowDelay(Long delay) {
        return Long.parseLong(Dispatch.call(com, "SetEnumWindowDelay",delay).toString());
    }

    @Override
    public Long setShowErrorMsg(int show) {
        return Long.parseLong(Dispatch.call(com, "SetShowErrorMsg",show).toString());
    }

    @Override
    public Long speedNormalGraphic(int enable) {
        return Long.parseLong(Dispatch.call(com, "SpeedNormalGraphic",enable).toString());
    }

    @Override
    public String getVersion() {
        return Dispatch.call(com, "Ver").toString();
    }

    @Override
    public Long dmGuard(int enable, String type) {
        return Long.parseLong(Dispatch.call(com, "DmGuard",enable,type).toString());
    }

    @Override
    public Long unLoadDriver() {
        return Long.parseLong(Dispatch.call(com, "UnLoadDriver").toString());
    }
}
