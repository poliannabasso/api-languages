package com.demo.api.languages;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LanguageController {

    @Autowired
    private LanguageRepository languageRepository;

    @GetMapping("/languages")
    public List<Language> listLanguages() {
        return languageRepository.findAll();
    }

    @GetMapping("/languages/{id}")
    public Language findById(@PathVariable String id) {
        return languageRepository.findById(id).get();
    }

    @PostMapping("/languages")
    @ResponseStatus(HttpStatus.CREATED)
    public Language createLanguage(@RequestBody Language language) {
        return languageRepository.save(language);
    }

    @PutMapping("/languages/{id}")
    public Language updateLanguage(@PathVariable String id, @RequestBody Language language) {
        Language newLanguage = findById(id);
        newLanguage.setTitle(language.getTitle());
        newLanguage.setUrl(language.getUrl());
        newLanguage.setRank(language.getRank());
        return languageRepository.save(newLanguage);
    }

    @DeleteMapping("/languages/{id}")
    public void deleteLanguage(@PathVariable String id) {
        languageRepository.delete(findById(id));
    }
}
