package com.women.spring.controller;



import com.women.spring.model.Certificat;
import com.women.spring.model.Formation;
import com.women.spring.service.CertificatService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Certificat")
public class CertificatExportController {

@Autowired
CertificatService certificatService;



    @PostMapping("/save")
    public Certificat save(@RequestBody Certificat certificat ) throws MessagingException {

        return certificatService.save(certificat);
    }

//----send mail--
    @GetMapping("/sendmail/{id}")
    public Certificat sendmail(@PathVariable("id") Long id){

         String email= certificatService.findById(id).getUser().getEmail();

            certificatService.sendSimpleEmail(email,
                    "Congratulations, you passed your exam.\n" +
                      "Now you can get your certification\n" +
                            "\n" +

                            "\n" +
                            "thank you",
                    "Certification"
             );

        return certificatService.findById(id);
    }

    @PutMapping
    public Certificat update(@RequestBody Certificat certificat) {
        return certificatService.update(certificat);
    }

    @GetMapping("/find/{id}")
    public Certificat  findById(@PathVariable("id") Long id) {
        return certificatService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        certificatService.delete(id);
    }

    @GetMapping()
    public List<Certificat> findAll() {
        return certificatService.findAll();
    }


//------------------------- QR Code --------------------------
//----------------where the Qr code will be save--------------
    private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/QRCode.png";
    private static final String SILVER_IMAGE_PATH = "https://imgur.com/a/OmKccsm";

    @GetMapping(value = "/genrateAndDownloadQRCode/{codeText}/{width}/{height}")
    public void download(
            @PathVariable("codeText") String codeText,
            @PathVariable("width") Integer width,
            @PathVariable("height") Integer height)
            throws Exception {
        certificatService.generateQRCodeImage(SILVER_IMAGE_PATH, width, height, QR_CODE_IMAGE_PATH);
    }

    @GetMapping(value = "/genrateQRCode/{codeText}/{width}/{height}")
    public ResponseEntity<byte[]> generateQRCode(
            @PathVariable("codeText") String codeText,
            @PathVariable("width") Integer width,
            @PathVariable("height") Integer height)
            throws Exception {

        return ResponseEntity.status(HttpStatus.OK).body(certificatService.getQRCodeImage(codeText, width, height));
    }

//-------------------generate pdf
    public CertificatExportController(CertificatService pdfGeneratorService) {
        this.certificatService = pdfGeneratorService;
    }

    @GetMapping("/pdf/generate/{id}/{idf}")
    public void generatePDF(HttpServletResponse response,@PathVariable("id") Long id,@PathVariable("idf") Long idf) throws IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        this.certificatService.export(response,id,idf);
    }
}
