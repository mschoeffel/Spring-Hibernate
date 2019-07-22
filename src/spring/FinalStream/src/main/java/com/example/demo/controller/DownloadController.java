package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@RestController
@RequestMapping("/api")
public class DownloadController {

    private final Logger logger = LoggerFactory.getLogger(DownloadController.class);

    @GetMapping(value = "/download", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StreamingResponseBody> download(HttpServletResponse response) {

        response.setContentType("application/zip");
        response.setHeader("Content-Disposition", "attachment;filename=sample.zip");

        StreamingResponseBody stream = out -> {

            logger.info("Stream started.");
            File directory = ResourceUtils.getFile("classpath:sample");
            try (ZipOutputStream zipOutputStream = new ZipOutputStream(response.getOutputStream())) {
                if (directory.exists() && directory.isDirectory()) {
                    try {
                        for (File file : Objects.requireNonNull(directory.listFiles())) {
                            logger.info("File: " + file.getName() + " will now be zipped.");
                            try (InputStream inputStream = new FileInputStream(file)) {
                                ZipEntry zipEntry = new ZipEntry(file.getName());
                                zipOutputStream.putNextEntry(zipEntry);
                                byte[] bytes = new byte[1024];
                                int length;
                                while ((length = inputStream.read(bytes)) >= 0) {
                                    zipOutputStream.write(bytes, 0, length);
                                }
                                inputStream.close();
                                logger.info("File: " + file.getName() + " finished zipping.");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        zipOutputStream.close();
                    } catch (IOException e) {
                        logger.error("Exception while reading and streaming data {} ", e);
                    }
                }
            }
            logger.info("Stream finished.");
        };
        logger.info("steaming response {} ", stream);
        return new ResponseEntity(stream, HttpStatus.OK);
    }
}
