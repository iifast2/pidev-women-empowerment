//package esprit.tn.theteam_api.controller;
//
//import org.springframework.social.connect.ConnectionRepository;
//import org.springframework.social.facebook.api.Facebook;
//import org.springframework.social.facebook.api.PagedList;
//import org.springframework.social.facebook.api.Post;
//import org.springframework.social.facebook.api.User;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class MainController {
//    private Facebook facebook;
//    private ConnectionRepository connectionRepository;
//
//    public MainController(Facebook facebook, ConnectionRepository connectionRepository) {
//        this.facebook = facebook;
//        this.connectionRepository = connectionRepository;
//    }
//
//    @RequestMapping(value = "/feed", method = RequestMethod.GET)
//    public String feed() {
//
//        if(connectionRepository.findPrimaryConnection(Facebook.class) == null) {
//            return "redirect:/connect/facebook";
//        }
//
//        User userProfile = facebook.userOperations().getUserProfile();
////        model.addAttribute("userProfile", userProfile);
//      PagedList<Post> userFeed = facebook.feedOperations().getFeed();
//     //   model.addAttribute("userFeed", userFeed);
//        return "feed";
//    }
//}