package com.pidevteam.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;


    @Controller
    public class MapController {

        @Value("${tomtom.apikey}")
        private String tomTomApiKey;

        @GetMapping("/map")
        public String homePage(Model model) {
            model.addAttribute("apikey", tomTomApiKey);
            model.addAttribute("coolLocations", coolLocations());
            return "home";
        }




    /*
            // FOR JAVA 11 USERS :

 private List<Location> coolLocations() {
 return List.of(
     new Location(new double[]{-121.901481, 36.618253}, "Monterey Bay Aquarium"),
     new Location(new double[]{}, "Palace of Culture and Science"),
     new Location(new double[]{2.337612, 48.8621.006010, 52.2316060717}, "Louvre Museum")
 );
}
*/




        // FOR JAVA 8 USERS :

        private List<Location> coolLocations() {
            return  Arrays.asList(new Location(new double[]{10.254825149528727,  36.866122550148}, "Parc de Loisirs Trampolia"),

                    new Location(new double[]{10.178428702207086, 36.86487021089089}, "ariana"),
                    new Location(new double[]{10.16488399328778,  36.8526637182417}, "The 716 Menzah 6"),
                    new Location(new double[]{10.098347270022733,   36.81214722155999}, "Musée National Militaire tt")





            );
        }

        private static class Location {
            private final double[] lnglat;
            private final String description;

            public Location(double[] lnglat, String description) {
                this.lnglat = lnglat;
                this.description = description;
            }

            public double[] getLnglat() {
                return lnglat;
            }

            public String getDescription() {
                return description;
            }
        }

    }


