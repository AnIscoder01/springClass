package com.example.springfirst1.Controllers;

import com.example.springfirst1.Services.ProviderService;
import com.example.springfirst1.entity.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProviderController {
    @Autowired
    ProviderService providerService;

    @RequestMapping("/addProvider")
    public String addProvider(Model model) {
        Provider provider = new Provider();
        model.addAttribute("ProviderForm", provider);
        return "new_provider";
    }

    @RequestMapping(value="/saveProvider",method = RequestMethod.POST)
    public String saveProvider(@ModelAttribute("ProviderForm") Provider provider) {
        providerService.createProvider(provider);
        return "redirect:/allProviders";
    }

    @RequestMapping("/allProviders")
    public String listProviders(Model model) {
        List<Provider> listProviders = providerService.getAllProviders();
        model.addAttribute("listProvider", listProviders);
        return "liste_providers";
    }

    @GetMapping("/deleteProvider/{id}")
    public String deleteProvider(@PathVariable int id) {
        providerService.deleteProviderById(id);
        return "redirect:/allProviders";
    }

    @GetMapping("editProvider/{id}")
    public String editProvider(@PathVariable int id, Model model) {
        Provider provider = providerService.getProviderById(id);
        model.addAttribute("provider", provider);
        return "update_provider";
    }
    @PostMapping("/updateProvider/{id}")
    public String updateProvider(@PathVariable int id, Provider provider) {
        providerService.updateProvider(provider);
        return "redirect:/allProviders";
    }
}
