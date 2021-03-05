package com.github.originalblackhole.core.impl;

import com.github.originalblackhole.core.OcrService;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OcrServiceImpl extends AbstractCommonService implements OcrService {

    @Override
    public Long setDict(int index, String file) {
        return Long.parseLong(Dispatch.call(com, "SetDict",index,file).toString());
    }

    @Override
    public Long useDict(String index) {
        return Long.parseLong(Dispatch.call(com, "UseDict",index).toString());
    }

    @Override
    public String ocr(int x1, int y1, int x2, int y2, String colorFormat, double sim) {
        Variant[] var = new Variant[6];
        var[0] = new Variant(x1);
        var[1] = new Variant(y1);
        var[2] = new Variant(x2);
        var[3] = new Variant(y2);
        var[4] = new Variant(colorFormat);
        var[5] = new Variant(sim);
        //return Dispatch.call(com, "Ocr",x1,y1,x2,y2,colorFormat,sim).toString();
        return Dispatch.call(com, "Ocr",var).toString();
    }
}
