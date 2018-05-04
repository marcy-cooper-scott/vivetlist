package com.vivetlist.main.controller;

import com.vivetlist.main.models.Medicine;
import com.vivetlist.main.models.User;
import com.vivetlist.main.repos.MedicineRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MedicineController {

    MedicineRepo medicineRepo;

    MedicineController(MedicineRepo medicineRepo){
        this.medicineRepo = medicineRepo;
    }

    @GetMapping("/medicines/create")
    public String createMed(Model model){
        model.addAttribute("medicine", new Medicine());
        return "medicines/create";
    }

    @PostMapping("/medicines/create")
    public String insertMed(@ModelAttribute Medicine med, Model model){
       medicineRepo.save(med);
    }

    @GetMapping("/medicines/{id}/edit")
    public String editMed(@PathVariable long id, Model model){
        model.addAttribute("medicine", medicineRepo.findOne(id));
        return"medicines/edit";
    }

    @PostMapping("/medicines/{id}/edit")
    public String handleEdit(@PathVariable long id, @ModelAttribute Medicine med){
        Medicine origMed = medicineRepo.findOne(id);
        origMed.setMedicine_name(med.getMedicine_name());
        origMed.setNotes(med.getNotes());
        origMed.setRefill_date(med.getRefill_date());
        medicineRepo.save(origMed);
        return "redirect:/mylist";
    }

    @PostMapping("/medicines/delete")
    public String deleteMed(@ModelAttribute Medicine med){
        medicineRepo.delete(med);
        return "redirect:/mylist";
    }
}
