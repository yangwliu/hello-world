package com.csu.controller;

import com.csu.model.Production;
import com.csu.service.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(path = "/productions")
public class ProductionController {

  @Autowired
  private ProductionService productionService;

  @GetMapping(produces = APPLICATION_JSON_UTF8_VALUE)
  public Collection<Production> getCourses() {
    return productionService.getAllProductions();
  }

  @GetMapping(path = "/{code}", produces = APPLICATION_JSON_UTF8_VALUE)
  public Production getCourse(@PathVariable String code) {
    return productionService.getProductionByCode(code);
  }
}
