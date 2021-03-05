package com.github.originalblackhole.core.impl;

import com.github.originalblackhole.model.Point;
import com.github.originalblackhole.core.PicService;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PicServiceImpl extends AbstractCommonService implements PicService {

    @Override
    public Point findPic(int x1, int y1, int x2, int y2, String picName, String deltaColor, double sim, int dir) {
        int intX = 0, intY = 0;
        Point point = new Point(-1,-1);
        Variant[] var = new Variant[10];
        var[0] = new Variant(x1);
        var[1] = new Variant(y1);
        var[2] = new Variant(x2);
        var[3] = new Variant(y2);
        var[4] = new Variant(picName);
        var[5] = new Variant(deltaColor);
        var[6] = new Variant(sim);
        var[7] = new Variant(dir);
        var[8] = new Variant(intX,true);
        var[9] = new Variant(intY,true);
        Dispatch.call(com, "FindPic",var);
        if(var[8].getInt() >= 0 && var[9].getInt() >= 0){
            point.setX(var[8].getInt());
            point.setY(var[9].getInt());
        }
        return point;
    }


}
