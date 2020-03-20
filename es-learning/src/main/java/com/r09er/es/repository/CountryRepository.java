package com.r09er.es.repository;

import com.r09er.es.entity.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author roger
 * @date 2020/3/19
 */
public interface CountryRepository extends ElasticsearchRepository<Country, Long> {
    List<Country> findCountryByName(String name);

    Page<Country> findCountryByName(String name, Pageable pageable);

    Country findCountryById(String name);

}