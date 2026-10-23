package f2_Team3.Event.Crew.controller;

import f2_Team3.Event.Crew.entity.Provider;
import f2_Team3.Event.Crew.service.ProviderService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/providers")
public class ProviderController {

    private final ProviderService providerService;

    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @PostMapping
    public ResponseEntity<Provider> createProvider(@Valid @RequestBody Provider provider) {

        Provider created = providerService.createProvider(provider);

        return ResponseEntity.created(URI.create("/api/providers/" + created.getId())).body(created);
    }

    @GetMapping
    public ResponseEntity<List<Provider>> getAllProviders() {
        return ResponseEntity.ok(providerService.getAllProviders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Provider> getProviderById(@PathVariable Long id) {

        return ResponseEntity.ok(providerService.getProviderById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Provider> updateProvider(@PathVariable Long id,@Valid @RequestBody Provider provider) {

        return ResponseEntity.ok(providerService.updateProvider(id, provider));
    }
}