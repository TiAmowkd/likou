package com.ballot.rigging.server;

import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @Auther: wkd
 * @Date: 2019/12/20 15:16
 * @Description:
 */
class FileServiceTest {

    @Test
    void fileHandle() throws IOException {
        FileService fileService = new FileService();

        // TODO 此处替换为本地文件的地址全路径
        String filePath = "F:/SignTemplate.docx";

        // 通过lambda表达式，打印文件内容
        fileService.fileHandleService(filePath, System.out::println);

       /* String a = "aaddddd";*/
//        Consumer<String> consumer = String::length;

    }
}