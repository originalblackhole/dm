package com.github.originalblackhole.common;

import java.util.HashMap;
import java.util.Map;

public class KeyMapper {

    private static  Map<String,String> keyMap = new HashMap<>();

    static {
        keyMap.put("1","49");keyMap.put("2","50");keyMap.put("3","51");keyMap.put("4","52");keyMap.put("5","53");keyMap.put("6","54");
        keyMap.put("7","55");keyMap.put("8","56");keyMap.put("9","57");keyMap.put("0","48");keyMap.put("-","189");keyMap.put("=","187");
        keyMap.put("back","8");

        keyMap.put("a","65");keyMap.put("b","66");keyMap.put("c","67");keyMap.put("d","68");keyMap.put("e","69");keyMap.put("f","70");
        keyMap.put("g","71");keyMap.put("h","72");keyMap.put("i","73");keyMap.put("j","74");keyMap.put("k","75");keyMap.put("l","76");
        keyMap.put("m","77");keyMap.put("n","78");keyMap.put("o","79");keyMap.put("p","80");keyMap.put("q","81");keyMap.put("r","82");
        keyMap.put("s","83");keyMap.put("t","84");keyMap.put("u","85");keyMap.put("v","86");keyMap.put("w","87");keyMap.put("x","88");
        keyMap.put("y","89");keyMap.put("z","90");

        keyMap.put("ctrl","17");keyMap.put("alt","18");keyMap.put("shift","16");keyMap.put("win","91");keyMap.put("space","32");keyMap.put("cap","20");
        keyMap.put("tab","9");keyMap.put("~","192");keyMap.put("esc","27");keyMap.put("enter","13");

        keyMap.put("up","38");keyMap.put("down","40");keyMap.put("left","37");keyMap.put("right","39");keyMap.put("option","93");

        keyMap.put("print","44");keyMap.put("delete","46");keyMap.put("home","36");keyMap.put("end","35");keyMap.put("pgup","33");keyMap.put("pgdn","34");

        keyMap.put("f1","112");keyMap.put("f2","113");keyMap.put("f3","114");keyMap.put("f4","115");keyMap.put("f5","116");keyMap.put("f6","117");
        keyMap.put("f7","118");keyMap.put("f8","119");keyMap.put("f9","120");keyMap.put("f10","121");keyMap.put("f11","122");keyMap.put("f12","123");

        keyMap.put("[","219");keyMap.put("]","221");keyMap.put("\\","220");keyMap.put(";","186");keyMap.put("'","122");keyMap.put(",","188");
        keyMap.put(".","190");keyMap.put("/","191");

    }

    public static Map<String,String> getKeyMapper(){
        return keyMap;
    }
}
