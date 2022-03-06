package esprit.tn.theteam_api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.social.connect.*;

import org.springframework.social.connect.mem.InMemoryUsersConnectionRepository;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.facebook.api.Facebook;

import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;

import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;

import javax.activation.DataSource;
import javax.inject.Inject;
import javax.inject.Scope;

@Configuration

public class SocialConfig {

final String id = "111038088172153";
    @Bean
    public InMemoryUsersConnectionRepository connectionFactoryLocator() {
        ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();


        registry.addConnectionFactory(new FacebookConnectionFactory(

                (facebookClientId),(facebookClientSecret)
        ));

        return new InMemoryUsersConnectionRepository(registry);
    }


    private String facebookClientId="478213183797034";


    private String facebookClientSecret="09b936600fc4aaf766e24c1ce1f66920";

@Bean
 public Facebook create(){
     FacebookConnectionFactory connectionFactory = new FacebookConnectionFactory(facebookClientId, facebookClientSecret);
     OAuth2Operations op = connectionFactory.getOAuthOperations();
     System.out.println("token"+op.authenticateClient().getAccessToken() +"                       ");
     OAuth2Parameters params = new OAuth2Parameters();


     Facebook facebook = new FacebookTemplate("EAAGy7q7ydyoBAHuWccjdcb3dNCQz8zCncuEFQnNKYRZBiI7DEjKFa8ouGqJi2tzDJMxI8FbTEXh9E5IykOhoV3EBrr71yZB7RSMx2oqTuFPSnXSRDRmiZB5n6pdxp4jg7WlU5uevwpx9ZCHgARPkoJTyeKrtZAWapmEdm1NZB5ZCXXsYVHlaLeUOx1dgZAZAUiYwsoXcMbcrgEzYWFtq9GQJ7");
     System.out.println("application name "+facebook.getApplicationNamespace()+"isAuthorized"+facebook.isAuthorized());
     return facebook;

    }
    @Bean
    public ConnectionRepository getApCnxRepo(){
     //   System.out.println("cffqfff"+create().getApplicationNamespace());

        return connectionFactoryLocator().createConnectionRepository(id);
    }
//
//    @Bean
//    public User getUser(){
//        OAuth2Operations oauth = new FacebookConnectionFactory("478213183797034", "09b936600fc4aaf766e24c1ce1f66920").getOAuthOperations();
//        String appToken = oauth.authenticateClient().getAccessToken();
//        Facebook facebook = new FacebookTemplate(appToken);
//        String idU = "100077978868568";
//        User user = facebook.fetchObject(idU, User.class);
//        return  user ;
//    }
////@Bean
////public Facebook getFacebook(){
////        return getApCnxRepo().findPrimaryConnection(Facebook.class).getApi();
////    }
//
//


}
