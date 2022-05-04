package com.pidevteam.controller;



import com.pidevteam.entity.Certificat;
import com.pidevteam.service.CertificatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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

    //-----------upload certif in static server--------
    @PostMapping("/uploadimg/{id}")
    public Certificat uploadImg(@RequestParam("file")MultipartFile file,@PathVariable("id") Long id) throws IOException {

        String Path_Directory="C:\\Users\\HaninePC\\Documents\\Pi-Version\\v2\\src\\main\\resources\\Certif";
        Files.copy(file.getInputStream(), Paths.get(Path_Directory+ File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
        String msg;
        Certificat certificat=certificatService.findById(id);

        certificat.setPath(String.valueOf(Paths.get(Path_Directory+ File.separator+file.getOriginalFilename()))) ;
        //  certificat.setPath("hello");
        return certificatService.update(certificat);
        //  return msg= "successfully img is uploaded "+certificat.getPath();
    }

//------------------------- QR Code --------------------------
//----------------where the Qr code will be save--------------


    private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/QRCode.png";


    @GetMapping(value = "/genrateAndDownloadQRCode/{width}/{height}/{id}")
    public void download(

            @PathVariable("width") Integer width,
            @PathVariable("height") Integer height,@PathVariable("id") Long id)
            throws Exception {

        Certificat certificat=certificatService.findById(id);
        String path= certificat.getPath();

        certificatService.generateQRCodeImage(path, width, height, QR_CODE_IMAGE_PATH);
    }





}
