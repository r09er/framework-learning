package com.r09er.es.service;

import com.r09er.es.entity.Country;
import com.r09er.es.repository.CountryRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author roger
 * @date 2020/3/19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class CountryServiceTest {

    @Autowired
    private CountryService countryService;
    @Autowired
    private CountryRepository countryRepository;


    @Test
    void saveCountry() {
        Country country = new Country();
        country.setName("中国");
        countryRepository.save(country);
        Country country1 = new Country();
        country1.setName("美国");
        countryRepository.save(country1);
    }

    @Test
    public void testDel(){
        countryRepository.deleteAll();
    }

    @Test
    void getCountryByName() {
        Page<Country> countryList = countryRepository.findCountryByName("国", PageRequest.of(0, 10));
        System.out.println(countryList.getContent());
    }
}