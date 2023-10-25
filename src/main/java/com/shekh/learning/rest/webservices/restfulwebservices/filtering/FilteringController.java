package com.shekh.learning.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public StaticFilterBean filtering() {
        return new StaticFilterBean("value 1", "value 2", "value 3");
    }

    @GetMapping("/filtering-list")
    public List<StaticFilterBean> filteringList() {
        return Arrays.asList(
                new StaticFilterBean("value 1a", "value 2a", "value 3a"),
                new StaticFilterBean("value 1b", "value 2b", "value 3b"),
                new StaticFilterBean("value 1c", "value 2c", "value 3c"),
                new StaticFilterBean("value 1d", "value 2d", "value 3d"),
                new StaticFilterBean("value 1e", "value 2e", "value 3e")
        );
    }

    @GetMapping("/filtering-dynamic")
    public MappingJacksonValue dynamicFiltering() {
        DynamicFilterBean bean = new DynamicFilterBean("value 1", "value 2", "value 3");

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(bean);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("DynamicFilterBeanFilter", filter);
        mappingJacksonValue.setFilters(filterProvider);

        return mappingJacksonValue;
    }

    @GetMapping("/filtering-list-dynamic")
    public MappingJacksonValue dynamicFilteringList() {
        List<DynamicFilterBean> list = Arrays.asList(
                new DynamicFilterBean("value 1a", "value 2a", "value 3a"),
                new DynamicFilterBean("value 1b", "value 2b", "value 3b"),
                new DynamicFilterBean("value 1c", "value 2c", "value 3c"),
                new DynamicFilterBean("value 1d", "value 2d", "value 3d"),
                new DynamicFilterBean("value 1e", "value 2e", "value 3e")
        );

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("DynamicFilterBeanFilter", filter);
        mappingJacksonValue.setFilters(filterProvider);

        return mappingJacksonValue;
    }
}
