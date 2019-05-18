package com.notalent.bookstore.config;

import com.notalent.bookstore.util.FileUtils;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;
import java.io.File;

/**
 * 文件上传配置
 * @author noTalent
 * @version 1.0
 * 2019.05.19
 */
@Configuration
public class MultipartConfig {

    private static final long MAX_FILE_SIEZ = 2097152;

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        String location = FileUtils.FILE_URL + FileUtils.UPLOAD_URL;
        File file = new File(location);
        if (!file.exists()) {
            file.mkdirs();
        }
        factory.setLocation(location);
        // 文件大小限制2MB
        factory.setMaxFileSize(DataSize.ofBytes(MAX_FILE_SIEZ));
        // 文件请求限制2MB
        factory.setMaxRequestSize(DataSize.ofBytes(MAX_FILE_SIEZ));
        return factory.createMultipartConfig();
    }

}
