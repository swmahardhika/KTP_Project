/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ktp.praktikum;

import com.ktp.praktikum.exceptions.NonexistentEntityException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author SWMahardhika
 */
@Controller
public class DataController {

    DatadataJpaController datactrl = new DatadataJpaController();
    List<Datadata> newdata = new ArrayList<>();
    //mapping untuk menuju /data
    @RequestMapping("/data")
    
    //mengambil data
    public String getData(Model model) {
        int record = datactrl.getDatadataCount();
        String result = "";
        
        try {
            newdata = datactrl.findDatadataEntities().subList(0, record);
        } catch (Exception e) {
            result = e.getMessage();
        }
        
        model.addAttribute("goData", newdata);
        model.addAttribute("record", record);
        //mengembalikan ke database.html
        return "database";
    }

    //method menambah data
    @PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    
    public String createData(@RequestParam("gambar") MultipartFile file, HttpServletRequest request) throws Exception {
        Datadata d = new Datadata();
        
        //request dr index
        String nama = request.getParameter("nama");
        String tanggal = request.getParameter("tanggal"); 
        Date tgl = new SimpleDateFormat("yyyy-MM-dd").parse(tanggal);
        String kewarganegaraan = request.getParameter("kewarganegaraan");

        d.setNama(nama);
        d.setTanggal(tgl);

        //mengubah format data ke string 
        d.setGambar(Base64.getEncoder().encodeToString(file.getBytes())); 
        d.setKewarganegaraan(kewarganegaraan);
        datactrl.create(d);
        return "redirect:/data";
    }

    //menambah method delete
    @GetMapping(value = "/del/{id}")
    public String deleteData(@PathVariable("id") Integer id) throws NonexistentEntityException {
        DatadataJpaController d = new DatadataJpaController();
        d.destroy(id);
        return "redirect:/data";
    }

    //menambahkan fungsi dari button edit yang ada di edit.html
    @RequestMapping("/edit/{id}")
    public String updateData(@PathVariable("id") int id, Model m) throws Exception {
        Datadata datadata = datactrl.findDatadata(id);
        
        //mengirim data ke html edit
        m.addAttribute("godata", datadata); 
        return "edit";
    }

    //Menambahkan method edit
    @PostMapping(value = "/edit", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String editData(@RequestParam("gambar") MultipartFile file, HttpServletRequest request) throws Exception {
        Datadata d = new Datadata();

        //mengambil request dari index 
        String nama = request.getParameter("nama");
        String tanggal = request.getParameter("tanggal"); 
        String ide = request.getParameter("id");
        String kewarganegaraan = request.getParameter("kewarganegaraan");

        int id = Integer.parseInt(ide);
        d.setId(id);
        d.setNama(nama);
        
        //mengubah format tanggal 
        Date tgl = new SimpleDateFormat("yyyy-MM-dd").parse(tanggal);
        d.setTanggal(tgl);

        //mengubah tipe data di gambar menjadi to string
        d.setGambar(Base64.getEncoder().encodeToString(file.getBytes()));
        d.setKewarganegaraan(kewarganegaraan);

        datactrl.edit(d);
        return "redirect:/data";
    }
}
