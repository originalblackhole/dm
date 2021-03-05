package com.github.originalblackhole.core.impl;

import com.github.originalblackhole.common.util.StrUtils;
import com.github.originalblackhole.model.Point;
import com.github.originalblackhole.core.MouseService;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MouseServiceImpl extends AbstractCommonService implements MouseService {


    @Override
    public Long enableMouseAccuracy(int enable) {
        return Long.parseLong(Dispatch.call(com, "EnableMouseAccuracy",enable).toString());
    }

    @Override
    public Long setMouseSpeed(int speed) {
        return Long.parseLong(Dispatch.call(com, "SetMouseSpeed",speed).toString());
    }

    @Override
    public Long moveR(int rx, int ry) {
        return null;
    }

    @Override
    public Long moveTo(int x, int y) {
        return Long.parseLong(Dispatch.call(com, "MoveTo",x,y).toString());
    }

    @Override
    public Point moveToEx(int x, int y, int w, int h) {
        String result = Dispatch.call(com, "MoveToEx",x,y,w,h).toString();
        if(result.equals("")){
            return new Point(-1,-1);
        }
        double inX = Double.parseDouble(result.split(",")[0]);
        double inY = Double.parseDouble(result.split(",")[1]);
        return new Point(inX,inY);
    }

    @Override
    public Long leftClick() {
        return Long.parseLong(Dispatch.call(com, "LeftClick").toString());
    }

    @Override
    public Long rightClick() {
        return Long.parseLong(Dispatch.call(com, "RightClick").toString());
    }

    @Override
    public Long leftDown() {
        return Long.parseLong(Dispatch.call(com, "LeftDown").toString());
    }

    @Override
    public Long leftUp() {
        return Long.parseLong(Dispatch.call(com, "LeftUp").toString());
    }

    @Override
    public Point getCursorPos() {
        int x = 0,y = 0;
        Variant[] var = new Variant[2];
        var[0] = new Variant(x,true);
        var[1] = new Variant(y,true);
        //Dispatch.call(com, "GetCursorPos",var).toString();
        //Dispatch.call(com, "GetCursorPos",var[0],var[1]).toString();
        if(Long.parseLong(Dispatch.call(com, "GetCursorPos",var[0],var[1]).toString()) == 1){
        //if(Long.parseLong(Dispatch.call(com, "GetCursorPos",var).toString()) == 1){
            //log.info("x | {},y | {}",var[0].getInt(),var[1].getInt());
            log.info("var | {}",var);
        }else {
            log.error("getCursorPos fail | {}",this.getMessage(this.getLastError().intValue()));
        }

        return new Point(Double.parseDouble(var[0].toString()),Double.parseDouble(var[1].toString()));
    }

    @Override
    public String getCursorShape() {
        return Dispatch.call(com, "GetCursorShape").toString();
    }

    @Override
    public String getCursorShapeEx(int type) {
        return Dispatch.call(com, "GetCursorShapeEx",type).toString();
    }

    @Override
    public Point moveToRandomLocation(int x1, int y1, int x2, int y2) {
        int x = StrUtils.createRandom(x1,x2);
        int y = StrUtils.createRandom(y1,y2);
        this.moveTo(x,y);
        return new Point(x,y);
    }
}
