package com.example.api.resource;


import com.example.api.data.Country;
import com.example.api.repository.CountryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/country")
@Service
public class CountryResource {

    @Autowired
    private CountryRepository countryRepository;

    @PostMapping
    @RequestMapping(method = RequestMethod.POST)
    public Country adicionar(@Valid @RequestBody Country country) {
        return countryRepository.save(country);
    }

    @GetMapping
    public List<Country> listar() {
        return countryRepository.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable("id") Long id, @Valid @RequestBody Country countryData) {
        Country country = countryRepository.findById(id).orElse(null);
        if (country != null) {
            if (id != countryData.getId()){
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("id is not correct");
            }

            //Copy all properties, ignore id
            BeanUtils.copyProperties(countryData, country, "id");
            //Update data
            return ResponseEntity.ok(countryRepository.save(country));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Country not found");
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> remover(@PathVariable Long id){
        Country country = countryRepository.findById(id).orElse(null);

        if (country == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Country not found");
        }
        countryRepository.delete(country);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Country deleted successfully");

    }
}
