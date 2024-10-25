package com.example.springfirst1.Services;

import com.example.springfirst1.Repository.ProviderRepository;
import com.example.springfirst1.entity.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderService {
    @Autowired
    ProviderRepository providerRepository;

    public Provider createProvider(Provider provider) {
        return providerRepository.save(provider);
    }

    public List<Provider> getAllProviders() {
        return providerRepository.findAll();
    }

    public Provider getProviderById(int id) {
        return providerRepository.findById(id).get();
    }

    public Provider updateProvider(Provider provider) {
        return providerRepository.saveAndFlush(provider);
    }

    public void deleteProviderById(int id) {
        providerRepository.deleteById(id);
    }
}
