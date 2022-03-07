//package esprit.tn.theteam_api.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.*;
//
//import org.springframework.core.env.Environment;
//import org.springframework.social.UserIdSource;
//import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
//import org.springframework.social.config.annotation.EnableSocial;
//import org.springframework.social.config.annotation.SocialConfigurerAdapter;
//import org.springframework.social.connect.*;
//
//import org.springframework.social.connect.mem.InMemoryUsersConnectionRepository;
//import org.springframework.social.connect.support.ConnectionFactoryRegistry;
//import org.springframework.social.connect.web.ReconnectFilter;
//import org.springframework.social.facebook.api.Facebook;
//
//import org.springframework.social.facebook.api.User;
//import org.springframework.social.facebook.api.impl.FacebookTemplate;
//import org.springframework.social.facebook.connect.FacebookConnectionFactory;
//
//import org.springframework.social.oauth2.OAuth2Operations;
//import org.springframework.social.oauth2.OAuth2Parameters;
//
//import javax.activation.DataSource;
//import javax.inject.Inject;
//
//
////@Configuration
//@Configuration
//@PropertySource("classpath:application.properties")
//@EnableSocial
//public class SocialConfig
////{
////
////final String id = "111038088172153";
////    @Bean
////    public InMemoryUsersConnectionRepository connectionFactoryLocator() {
////        ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
////
////
////        registry.addConnectionFactory(new FacebookConnectionFactory(
////
////                (facebookClientId),(facebookClientSecret)
////        ));
////
////        return new InMemoryUsersConnectionRepository(registry);
////    }
////
////
////    private String facebookClientId="478213183797034";
////
////
////    private String facebookClientSecret="09b936600fc4aaf766e24c1ce1f66920";
////
////@Bean
//// public Facebook create(){
////     FacebookConnectionFactory connectionFactory = new FacebookConnectionFactory(facebookClientId, facebookClientSecret);
////     OAuth2Operations op = connectionFactory.getOAuthOperations();
////     System.out.println("token"+op.authenticateClient().getAccessToken() +"                       ");
////     OAuth2Parameters params = new OAuth2Parameters();
////
////
////     Facebook facebook = new FacebookTemplate("EAAGy7q7ydyoBAHuWccjdcb3dNCQz8zCncuEFQnNKYRZBiI7DEjKFa8ouGqJi2tzDJMxI8FbTEXh9E5IykOhoV3EBrr71yZB7RSMx2oqTuFPSnXSRDRmiZB5n6pdxp4jg7WlU5uevwpx9ZCHgARPkoJTyeKrtZAWapmEdm1NZB5ZCXXsYVHlaLeUOx1dgZAZAUiYwsoXcMbcrgEzYWFtq9GQJ7");
////     System.out.println("application name "+facebook.getApplicationNamespace()+"isAuthorized"+facebook.isAuthorized());
////     return facebook;
////
////    }
////    @Bean
////    public ConnectionRepository getApCnxRepo(){
////     //   System.out.println("cffqfff"+create().getApplicationNamespace());
////
////        return connectionFactoryLocator().createConnectionRepository(id);
////    }
//////
//////    @Bean
//////    public User getUser(){
//////        OAuth2Operations oauth = new FacebookConnectionFactory("478213183797034", "09b936600fc4aaf766e24c1ce1f66920").getOAuthOperations();
//////        String appToken = oauth.authenticateClient().getAccessToken();
//////        Facebook facebook = new FacebookTemplate(appToken);
//////        String idU = "100077978868568";
//////        User user = facebook.fetchObject(idU, User.class);
//////        return  user ;
//////    }
////////@Bean
////////public Facebook getFacebook(){
////////        return getApCnxRepo().findPrimaryConnection(Facebook.class).getApi();
////////    }
//////
//////
////
////
////}
//        extends SocialConfigurerAdapter {
//
//    @Override
//    public void addConnectionFactories(ConnectionFactoryConfigurer cfConfig, Environment env) {
//        cfConfig.addConnectionFactory(new FacebookConnectionFactory(env.getProperty("facebook.appKey"), env.getProperty("facebook.appSecret")));
//    }
//
//
//    @Bean
//    public UsersConnectionRepository usersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
//        return new UserConnectionRepositoryImpl(connectionFactoryLocator);
//    }
//
//    @Override
//    @Bean
//    public UserIdSource getUserIdSource() {
//        return new UserIdSource() {
//            @Override
//            public String getUserId() {
//                User user = getUser();
//                if (user == null) {
//                    throw new IllegalStateException("Unable to get a ConnectionRepository: no user signed in");
//                }
//                return user.getId();
//            }
//        };
//    }
//
//    @Bean
//    public ReconnectFilter apiExceptionHandler(UsersConnectionRepository usersConnectionRepository, UserIdSource userIdSource) {
//        return new ReconnectFilter(usersConnectionRepository, userIdSource);
//    }
//
//
//    @Bean
//    @Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
//    public ConnectionRepository connectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
//
//        User user = null ;
//        if (user == null) {
//            throw new IllegalStateException("Unable to get a ConnectionRepository: no user signed in");
//        }
//        return usersConnectionRepository(connectionFactoryLocator).createConnectionRepository(user.getId());
//    }
//
//    @Bean
//    @Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
//    public Facebook facebook(ConnectionRepository repository) {
//        Connection<Facebook> connection = null;
//
//        if (repository != null) {
//            connection = repository.findPrimaryConnection(Facebook.class);
//        }
//
//        return connection != null ? connection.getApi() : null;
//    }
//
//
//}