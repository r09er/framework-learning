package com.r09er.es.service;

import com.r09er.es.entity.Country;
import com.r09er.es.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author roger
 * @date 2020/3/19
 */
@Service
public class CountryService {

    @Autowired
    CountryRepository countrySearchRepository;

    public Page<Country> getCountryByName(String name) {
        Page<Country> countrys = countrySearchRepository.findCountryByName("测试",  PageRequest.of(0, 10));
        return countrys;
    }
}
