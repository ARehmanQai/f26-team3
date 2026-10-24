package f2_Team3.Event.Crew.service;

import f2_Team3.Event.Crew.entity.Provider;
import f2_Team3.Event.Crew.repository.ProviderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderService {

    private final ProviderRepository providerRepository;

    public ProviderService(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    public Provider createProvider(Provider provider) {
        return providerRepository.save(provider);
    }

    public List<Provider> getAllProviders() {
        return providerRepository.findAll();
    }

    public Provider getProviderById(Long id) {
        return providerRepository.findById(id)
                .orElseThrow(() ->
                        new NotFoundException("Provider not found: " + id));
    }

    public Provider updateProvider(Long id, Provider updatedProvider) {
        Provider provider = getProviderById(id);

        provider.setName(updatedProvider.getName());
        provider.setEmail(updatedProvider.getEmail());
        provider.setPassword(updatedProvider.getPassword());
        provider.setServiceArea(updatedProvider.getServiceArea());
        provider.setServiceType(updatedProvider.getServiceType());
        provider.setPhoneNumber(updatedProvider.getPhoneNumber());
        provider.setProviderType(updatedProvider.getProviderType());

        return providerRepository.save(provider);
    }
}