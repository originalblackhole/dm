package com.github.originalblackhole.core.impl;

import com.github.originalblackhole.model.Point;
import com.github.originalblackhole.core.ColorService;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ColorServiceImpl extends AbstractCommonService implements ColorService {

    @Override
    public String getColor(int x, int y) {
        return Dispatch.call(com, "GetColor",x,y).toString();
    }

    @Override
    public String getColorBGR(int x, int y) {
        return Dispatch.call(com, "GetColorBGR",x,y).toString();
    }

    @Override
    public String getColorHSV(int x, int y) {
        return Dispatch.call(com, "GetColorHSV",x,y).toString();
    }

    @Override
    public Point findColor(int x1, int y1, int x2, int y2, String color, double sim, int dir) {
        int intX = 0,intY = 0;
        Point point = new Point(-1,-1);
        Variant[] var = new Variant[9];
        var[0] = new Variant(x1);
        var[1] = new Variant(y1);
        var[2] = new Variant(x2);
        var[3] = new Variant(y2);
        var[4] = new Variant(color);
        var[5] = new Variant(sim);
        var[6] = new Variant(dir);
        var[7] = new Variant(intX,true);
        var[8] = new Variant(intY,true);
        Dispatch.call(com, "FindColor",var);
        if(var[7].getInt() >= 0 && var[8].getInt() >= 0){
            point.setX(var[7].getInt());
            point.setY(var[8].getInt());
        }
        return point;
    }


}
