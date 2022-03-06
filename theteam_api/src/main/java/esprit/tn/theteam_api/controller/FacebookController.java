package esprit.tn.theteam_api.controller;

import esprit.tn.theteam_api.config.SocialConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller()
@RequestMapping("/facebook")
public class FacebookController {

//    @Autowired
//    SocialConfig socialConfig ;
//@Autowired
//SocialConfig socialConfig ;
//     @Autowired
//
//  //@Qualifier("beanName1")
// private   ConnectionRepository connectionRepository;
    @Autowired

    /*@Qualifier("beanName2")*/
    private  Facebook facebook;

//    public FacebookController( ) {
//     //   this.connectionRepository = socialConfig.getApi();
//        this.facebook = socialConfig.create();
//
//    }


    @GetMapping()
    public PagedList<Post> helloFacebook(Model model) {

       // if (connectionRepository.findPrimaryConnection(Facebook.class) == null) {
        if (!facebook.isAuthorized()){
            return null;
        }

        else {
        //   facebook = connectionRepository.getPrimaryConnection(Facebook.class).getApi();
//            String[] fields = {"id", "name", "birthday", "email", "location", "hometown", "gender", "first_name", "last_name"};
//            User user = facebook.fetchObject("me", User.class, fields);
//            String name = user.getName();
//            String birthday = user.getBirthday();
//            String email = user.getEmail();
//            String gender = user.getGender();
//            String firstname = user.getFirstName();
//            String lastname = user.getLastName();
//            model.addAttribute("name", name);
//            model.addAttribute("birthday", birthday);
//            model.addAttribute("email", email);
//            model.addAttribute("gender", gender);
//            model.addAttribute("firstname", firstname);
//            model.addAttribute("lastname", lastname);
//            model.addAttribute("facebookProfile", facebook.fetchObject("me", User.class, fields));
//            System.out.println(socialConfig.getUser().getBirthday());
            PagedList<Post> feed = facebook.feedOperations().getFeed();

//            FacebookLink link = new FacebookLink("http://www.springsource.org/spring-social",
//                    "Spring Social",
//                    "The Spring Social Project",
//                    "Spring Social is an extension to Spring to enable applications to connect with service providers.");
            System.out.println(feed);
          //  model.addAttribute("feed", feed);
            return feed;
        }
    }
//
//    private final Facebook facebook;
//
//    @Inject
//    public FacebookController(Facebook facebook) {
//        this.facebook = facebook;
//    }
//
//  /*  @Bean
//    public Facebook get(){
//        return  facebook ;
//    }*/
//
//
////    Facebook facebook = connection.getApi();
//
//
//
//
////   @GetMapping ("/ddd")
////   public String get(){
////
////   }
//
//    @RequestMapping(method= RequestMethod.GET )
//    public String helloFb(Model model) {
//     // this.facebook = socialConfig.create();
//
//        if (!facebook.isAuthorized()) {
//            return "redirect:/connect/facebook";
//        }
////        facebook.feedOperations().post("bonjour","jjdj");
//        System.out.println("sss"+facebook.feedOperations().getFeed().toString());
//        System.out.println(facebook.isAuthorized());
////      model.addAttribute(facebook.userOperations().getUserProfile());
////     PagedList homeFeed = facebook.feedOperations().getHomeFeed();
////        model.addAttribute("feed", homeFeed);
//        return "feeds";
//    }
}
