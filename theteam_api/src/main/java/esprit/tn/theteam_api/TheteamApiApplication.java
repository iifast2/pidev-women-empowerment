package esprit.tn.theteam_api;

import esprit.tn.theteam_api.proprety.FileStorageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.social.facebook.api.Facebook;

import javax.annotation.PostConstruct;


@EnableAspectJAutoProxy
//@EnableSwagger2
@SpringBootApplication
@EnableConfigurationProperties({FileStorageProperties.class})

public class TheteamApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TheteamApiApplication.class, args);
    }
//    @Autowired
//    SocialConfig socialConfig;
//    @PostConstruct()
//    public  void init (){
//        System.out.println(   socialConfig.getApi().findPrimaryConnection(Facebook.class).getApi().getApplicationNamespace() );
//    }
}
