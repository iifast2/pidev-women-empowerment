package com.pidevteam.controller;

import com.pidevteam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.pidevteam.entity.User;
import java.net.URI;


@RestController
public class QRCodeController {

    private static String codeText;
    private static String codeTextx = "";

    @Autowired
    UserService userService;

    /*
            ( GET REQUEST ) :
               http://localhost:8080/genrateAndDownloadQRCode/SILVER_IMAGE_PATH/350/350
    */

    private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/QRCode.png";

    private static final String GOLD_IMAGE_PATH = "i.imgur.com/XtkkmCb.png";
    private static final String SILVER_IMAGE_PATH = "i.imgur.com/7gPz14Y.png";
    private static final String BRONZE_IMAGE_PATH = "i.imgur.com/FmSQbn0.png";




    public static String getSilverImagePath()  {


if ( codeText == SILVER_IMAGE_PATH){

            codeTextx = SILVER_IMAGE_PATH;
        }
else if (codeText == BRONZE_IMAGE_PATH)
            {
                codeTextx = BRONZE_IMAGE_PATH;
            }
else{
        codeTextx = GOLD_IMAGE_PATH;
        }
            return codeTextx; }


    @GetMapping(value = "/genrateAndDownloadQRCode/{codeTextx}/{width}/{height}")
    public void download(
            @PathVariable("codeTextx") String codeTextx,
            @PathVariable("width") Integer width,
            @PathVariable("height") Integer height)

        throws Exception {
        QRCodeGenerator.generateQRCodeImage(codeTextx, width, height, QR_CODE_IMAGE_PATH);
    }


    ///////////////////////////////////////////////////////////////
    @GetMapping(value = "/genrateQRCode/{codeText}/{width}/{height}")
    public ResponseEntity<byte[]> generateQRCode(
            @PathVariable("codeText") String codeText,
            @PathVariable("width") Integer width,
            @PathVariable("height") Integer height)

    throws Exception {

        return ResponseEntity.status(HttpStatus.OK).body(QRCodeGenerator.getQRCodeImage(codeText, width, height));
    }

}









// private static final String GOLD_IMAGE_PATH = "./src/main/mybadges/goldbadge.png";
//private static final String SILVER_IMAGE_PATH = "i.imgur.com/lTZHFRk.png";
// private static final String BRONZE_IMAGE_PATH = "file:///C:/Users/medaminebt/Downloads/SPRING%20QR%20CODE%20BADGES/GOLD%20BADGE.png";
//private static final String uploaduri = "https://api.anonfiles.com/v2/QR_CODE_IMAGE_PATH/username4321/info";
// private static final String SILVER_IMAGE_PATH = "i.imgur.com/lTZHFRk.png";

//https://imgur.com/a/8oOyZcv
//  GOLD : i.imgur.com/XtkkmCb.png
// SILVER : i.imgur.com/7gPz14Y.png
// BRONZE : i.imgur.com/FmSQbn0.png

