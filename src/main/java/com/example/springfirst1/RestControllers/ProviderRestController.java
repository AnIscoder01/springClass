package com.example.springfirst1.RestControllers;

import com.example.springfirst1.Services.ProviderService;
import com.example.springfirst1.entity.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/provider")
public class ProviderRestController {
    @Autowired
    ProviderService providerService;

    @PostMapping("/save")
    public Provider createProvider(@RequestBody Provider provider) {
        return providerService.createProvider(provider);
    }

    @GetMapping("/all")
    public List<Provider> getAllProviders() {
        return providerService.getAllProviders();
    }

    @GetMapping("/getOne/{id}")
    public Provider getProvider(@PathVariable int id) {
        return providerService.getProviderById(id);
    }

    @PutMapping("/update/{id}")
    public Provider updateProvider(@PathVariable int id, @RequestBody Provider provider) {
        Provider existingProvider = providerService.getProviderById(id);

        if (existingProvider != null) {
            provider.setId(id);
            return providerService.updateProvider(provider);
        } else {
            throw new RuntimeException("Provider not found");
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProvider(@PathVariable int id) {
        providerService.deleteProviderById(id);
    }
}
