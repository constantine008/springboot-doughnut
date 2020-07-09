package com.benefitj.examples.controller;


import com.benefitj.aop.AopIgnore;
import com.benefitj.aop.AopWebPointCut;
import com.benefitj.event.EventBusPoster;
import com.benefitj.event.RawEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AopWebPointCut
@RestController
@RequestMapping("/simple")
public class SimpleController {

  @Autowired
  private EventBusPoster poster;

  @GetMapping
  public ResponseEntity<?> get(String id) {
    poster.postSync(RawEvent.of(id));
    return ResponseEntity.ok("id ==>: " + id);
  }

  @AopIgnore
  @GetMapping("/notPrint")
  public ResponseEntity<?> notPrint(String id) {
    return ResponseEntity.ok("id ==>: " + id);
  }

}
