package az.code.dekor_bizden.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "az")
public class AppConfiguration {

    private String uploadPath;

}
