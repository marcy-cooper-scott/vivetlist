package com.vivetlist.main.controller;

import com.vivetlist.main.models.Appointment;
import com.vivetlist.main.models.Medicine;
import com.vivetlist.main.models.Reminder;
import com.vivetlist.main.models.User;
import com.vivetlist.main.repos.MedicineRepo;
import com.vivetlist.main.repos.ReminderRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class MedicineController {

    MedicineRepo medicineRepo;
    ReminderRepo reminderRepo;

    MedicineController(MedicineRepo medicineRepo, ReminderRepo reminderRepo){
        this.medicineRepo = medicineRepo;
        this.reminderRepo = reminderRepo;
    }

    @GetMapping("/medicines/create")
    public String createMed(Model model){
        model.addAttribute("medicine", new Medicine());
        System.out.println("get here");
        return "medicines/create";
    }

//    @PostMapping("/medicines/create")
//    public String insertMed(@ModelAttribute Medicine med, Errors validation, Model model){
//        if(validation.hasErrors()) {
//            model.addAttribute("errors", validation);
//            model.addAttribute("medicine", med);
//            return "medicines/create";
//        }
//        System.out.println("get here too");
//        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        med.setUser(loggedInUser);
//       medicineRepo.save(med);
//       return "redirect:/mylist";
//    }
    @PostMapping("/medicines/create")
    public String insertMed(@ModelAttribute Medicine med, Errors validation, HttpServletRequest request, Model model){
        if(validation.hasErrors()) {
            model.addAttribute("errors", validation);
            model.addAttribute("medicine", med);
            return "medicines/create";
        }
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        med.setUser(loggedInUser);
        medicineRepo.save(med);
        String choice = request.getParameter("choice");
        if (choice.contains("reminder")) {
            return "redirect:/reminders/create";
        }
        return "redirect:/mylist";
    }


    @GetMapping("/medicines/{id}/edit")
    public String editMed(@PathVariable long id, Model model){
        model.addAttribute("medicine", medicineRepo.findOne(id));
        return "medicines/edit";
    }

    @PostMapping("/medicines/{id}/edit")
    public String handleEdit(@PathVariable long id, @ModelAttribute Medicine med){
        Medicine origMed = medicineRepo.findOne(id);
        origMed.setMedicine_name(med.getMedicine_name());
        origMed.setRefill_date(med.getRefill_date());
        origMed.setNotes(med.getNotes());
        medicineRepo.save(origMed);
        return "redirect:/mylist";
    }

    @GetMapping("/medicines/{id}/delete")
    public String deleteMed(@PathVariable long id, @ModelAttribute Medicine med) {
        // grab all the reminders that have this medicine by this user inside
        if (reminderRepo.findAllByMedID(id).isEmpty()) {
            medicineRepo.delete(id);
            return "redirect:/mylist";
        } else {
            List<Reminder> reminders = reminderRepo.findAllByMedID(id);
            reminders.forEach(reminder -> { reminderRepo.delete(reminder.getId()); });
            medicineRepo.delete(id);
            return "redirect:/mylist";
        }
    }
}
