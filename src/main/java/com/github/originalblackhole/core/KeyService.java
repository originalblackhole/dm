package com.github.originalblackhole.core;

public interface KeyService {

    /**
     * 按下指定的虚拟键码
     *
     * @param code 虚拟按键码 49(相当按下"a"键)
     * @return
     */
    Long keyPress(int code);

    /**
     * 按下指定的键码(扩展方法)
     *
     * @param key 按键 如"a"
     * @return
     */
    Long keyPress(String key);

    /**
     * 根据指定的字符串序列，依次按顺序按下其中的字符.
     * @param key_str 需要按下的字符串序列. 比如"1234","abcd","7389,1462"等.
     * @param delay 每按下一个按键，需要延时多久. 单位毫秒.这个值越大，按的速度越慢。
     * @return
     */
    Long keyPressStr(String key_str,long delay);

    /**
     * 按住指定的虚拟键码
     * @param vkCode
     * @return
     */
    Long keyDown(int vkCode);

    /**
     * 按住指定的键码
     * @param vkCode 字符串描述的键码. 大小写无所谓
     * @return
     */
    Long keyDownChar(String vkCode);

    /**
     * 弹起来虚拟键vkCode
     * @param vkCode
     * @return
     */
    Long keyUp(int vkCode);

    /**
     * 弹起来虚拟键vkCode
     * @param vkCode 字符串描述的键码. 大小写无所谓
     * @return
     */
    Long keyUpChar(String vkCode);
}
