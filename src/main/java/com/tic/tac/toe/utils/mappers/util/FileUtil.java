package com.tic.tac.toe.utils.mappers.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
@Slf4j
public class FileUtil {

    public String saveFile(MultipartFile multipartFile) throws IOException {
        String fileName = multipartFile.getOriginalFilename();

        try {
            Path path = Paths.get("src" + File.separator + "main" + File.separator + "resources"
                              + File.separator + "file" + File.separator + fileName);

            Files.createDirectories(path.getParent());
            Files.copy(multipartFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

            File file = path.toAbsolutePath().toFile();

            return file.getAbsolutePath();
        }catch (Exception e){
            log.error("Error al guardar archivo" + e.getMessage());
            throw new IOException("Error al guardar archivo");
        }
    }
}
