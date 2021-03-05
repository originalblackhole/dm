package com.github.originalblackhole.core.impl;

import com.jacob.com.Dispatch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.github.originalblackhole.core.MemoryService;

@Slf4j
@Service
public class MemoryServiceImpl extends AbstractCommonService implements MemoryService {

    @Override
    public String readData(Long hwnd, String addr, int len) {
        return Dispatch.call(com, "ReadData",hwnd,addr,len).toString();
    }

    @Override
    public String readDataAddr(Long hwnd, String addr, int len) {
        return Dispatch.call(com, "ReadDataAddr",hwnd,addr,len).toString();
    }

    @Override
    public Long readDataAddrToBin(Long hwnd, String addr, int len) {
        return Long.parseLong(Dispatch.call(com, "ReadDataAddrToBin",hwnd,addr,len).toString());
    }

    @Override
    public Long readDataToBin(Long hwnd, String addr, int len) {
        return Long.parseLong(Dispatch.call(com, "ReadDataToBin",hwnd,addr,len).toString());
    }

    @Override
    public Double readDouble(Long hwnd, String addr) {
        return Double.parseDouble(Dispatch.call(com, "ReadDouble",hwnd,addr).toString());
    }

    @Override
    public Double readDoubleAddr(Long hwnd, String addr) {
        return Double.parseDouble(Dispatch.call(com, "ReadDoubleAddr",hwnd,addr).toString());
    }

    @Override
    public Float readFloat(Long hwnd, String addr) {
        return Float.parseFloat(Dispatch.call(com, "ReadFloat",hwnd,addr).toString());
    }

    @Override
    public Float readFloatAddr(Long hwnd, String addr) {
        return Float.parseFloat(Dispatch.call(com, "ReadFloatAddr",hwnd,addr).toString());
    }

    @Override
    public Long readInt(Long hwnd, String addr, int type) {
        return Long.parseLong(Dispatch.call(com, "ReadInt",hwnd,addr,type).toString());
    }

    @Override
    public Long readIntAddr(Long hwnd, String addr, int type) {
        return Long.parseLong(Dispatch.call(com, "ReadIntAddr",hwnd,addr,type).toString());
    }

    @Override
    public String readString(Long hwnd, String addr, int type, int len) {
        return Dispatch.call(com, "ReadString",hwnd,addr,type,len).toString();
    }

    @Override
    public String readStringAddr(Long hwnd, String addr, int type, int len) {
        return Dispatch.call(com, "ReadStringAddr",hwnd,addr,type,len).toString();
    }

    @Override
    public Long writeData(Long hwnd, String addr, String data) {
        return Long.parseLong(Dispatch.call(com, "WriteData",hwnd,addr,data).toString());
    }

    @Override
    public Long writeDataAddr(Long hwnd, Long addr, String data) {
        return Long.parseLong(Dispatch.call(com, "WriteDataAddr",hwnd,addr,data).toString());
    }

    @Override
    public Long writeDataAddrFromBin(Long hwnd, Long addr, int data, int len) {
        return Long.parseLong(Dispatch.call(com, "WriteDataAddrFromBin",hwnd,addr,data,len).toString());
    }

    @Override
    public Long writeDataFromBin(Long hwnd, String addr, int data, int len) {
        return Long.parseLong(Dispatch.call(com, "WriteDataFromBin",hwnd,addr,data,len).toString());
    }

    @Override
    public Long writeDouble(Long hwnd, String addr, double v) {
        return Long.parseLong(Dispatch.call(com, "WriteDouble",hwnd,addr,v).toString());
    }

    @Override
    public Long writeDoubleAddr(Long hwnd, Long addr, double v) {
        return Long.parseLong(Dispatch.call(com, "WriteDoubleAddr",hwnd,addr,v).toString());
    }

    @Override
    public Long writeFloat(Long hwnd, String addr, double v) {
        return Long.parseLong(Dispatch.call(com, "WriteFloat",hwnd,addr,v).toString());
    }

    @Override
    public Long writeFloatAddr(Long hwnd, Long addr, double v) {
        return Long.parseLong(Dispatch.call(com, "WriteFloatAddr",hwnd,addr,v).toString());
    }

    @Override
    public Long writeInt(Long hwnd, String addr, int type, int v) {
        return Long.parseLong(Dispatch.call(com, "WriteInt",hwnd,addr,type,v).toString());
    }

    @Override
    public Long writeIntAddr(Long hwnd, Long addr, int type, int v) {
        return Long.parseLong(Dispatch.call(com, "WriteIntAddr",hwnd,addr,type,v).toString());
    }

    @Override
    public Long writeString(Long hwnd, String addr, int type, String v) {
        return Long.parseLong(Dispatch.call(com, "WriteString",hwnd,addr,type,v).toString());
    }

    @Override
    public Long writeStringAddr(Long hwnd, Long addr, int type, String v) {
        return Long.parseLong(Dispatch.call(com, "WriteStringAddr",hwnd,addr,type,v).toString());
    }

}
