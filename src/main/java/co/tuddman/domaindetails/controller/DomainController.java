package co.tuddman.domaindetails.controller;

import java.util.List;
import java.util.UUID;

import co.tuddman.domaindetails.db.DomainRepository;
import co.tuddman.domaindetails.model.Domain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
public class DomainController {

    @Autowired
    private DomainRepository repo;

    private static final String urlTemplate = "https://%s.onion";

    private String formatUrl(String url) {
        return String.format(urlTemplate, url);
    }

    // GET All Domains.
    // TODO: replace with summary statistics about collected domains.
    @GetMapping("/domains")
    @ResponseBody
    public List<Domain> getAllDomains() {
        return repo.findAll();
    }

    // GET Single Domain Details via url
    @GetMapping("/domains/{url}")
    @ResponseBody
    public Domain getDomainDetails(@PathVariable(name="url", required=false) String url) {
        return repo.findByUrl(url);
    }

    // Create a new record for a domain
    @PostMapping("/domains")
    @ResponseBody
    public Domain createNewDomain(@Valid @RequestBody Domain domain) {
        return repo.save(domain);
    }

    // Update an existing domain
    @PutMapping("/domains/{url}")
    @ResponseBody
    public Domain updateDomain(@PathVariable(value = "url") String url, @Valid @RequestBody Domain domain) {
        Domain d = repo.findByUrl(url);

        d.setNotes(domain.getNotes());
        Domain updated = repo.save(d);
        return updated;
    }

}