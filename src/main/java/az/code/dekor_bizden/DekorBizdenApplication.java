package az.code.dekor_bizden;

import az.code.dekor_bizden.entities.MasaDekor;
import az.code.dekor_bizden.services.MasaDekorService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class DekorBizdenApplication {

    @Value("${a.fuad:test}")
    static String parol;

    public static void main(String[] args) {
        SpringApplication.run(DekorBizdenApplication.class, args);


    }

//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**");
//            }
//        };
//    }

    @Bean
    @Profile("dev")
    CommandLineRunner createInitialMasaDekor(MasaDekorService masaDekorService){
        return (args) -> {
            System.out.println("PAROL ========"+parol);

            for (int i = 0; i <0; i++) {
                MasaDekor masaDekor = new MasaDekor();
                masaDekor.setTitle("Lorrem"+i);
                masaDekor.setDescription("Lorem Ipsum is simply dummy text of the stry's standard dummy text ever since the 1500s");
                masaDekor.setPrice(123+i);
                masaDekor.setItemCode("S"+i);
                masaDekor.setType("standart");
                masaDekor.setGuest_count(15+i);
//                masaDekor.setCover_img("/Users/fuadhajiyev/Desktop/test.png");
                masaDekorService.save(masaDekor);
            }
        };
    }

}
