package az.code.dekor_bizden.file;

import az.code.dekor_bizden.config.AppConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.UUID;

@Service
@Slf4j
public class FileService {

    @Autowired
    AppConfiguration appConfiguration;



    public String  writeBase64EncodedStringToFile(String cover_img) throws IOException {
        Tika tika = new Tika();
        String fileName = generateRandomName();
        File target = new File(appConfiguration.getUploadPath()+"/"+fileName);
        OutputStream outputStream = new FileOutputStream(target);
        byte[] base64encoded = Base64.getDecoder().decode(cover_img);
        String fileType = tika.detect(base64encoded);
        if (fileType.equalsIgnoreCase("image/png") || fileType.equalsIgnoreCase("image/jpg") || fileType.equalsIgnoreCase("image/jpeg")|| fileType.equalsIgnoreCase("image/png") ||fileType.equalsIgnoreCase("image/jfif")){
            outputStream.write(base64encoded);
            outputStream.close();
            return fileName;
        }
        else {
            throw new IllegalArgumentException("file type error");
        }


    }

    public String generateRandomName(){
        return UUID.randomUUID().toString().replace("-","");
    }

    public void deleteFile(String oldImageName) {
        if (oldImageName == null){
            return;
        }
        try {
            Files.deleteIfExists(Paths.get(appConfiguration.getUploadPath()+"/"+oldImageName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
