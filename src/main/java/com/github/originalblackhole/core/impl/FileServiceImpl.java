package com.github.originalblackhole.core.impl;

import com.github.originalblackhole.core.FileService;
import com.jacob.com.Dispatch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FileServiceImpl extends AbstractCommonService implements FileService {

    @Override
    public Long deleteFolder(String folder) {
        return Long.parseLong(Dispatch.call(com, "DeleteFolder",folder).toString());
    }

}
