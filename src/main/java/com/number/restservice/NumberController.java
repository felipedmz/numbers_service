package com.number.restservice;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class NumberController {

	@RequestMapping(value = "/find", method =  RequestMethod.POST)
    public ResponseEntity<ArrayList> Post(@Valid @RequestBody Interval interval)
    {
        return new ResponseEntity<ArrayList>(interval.findPerfectNumbers(), HttpStatus.OK);
    }

	@GetMapping("/check/{value}")
	public ResponseEntity<Number> isPerfectNumber(@PathVariable String value) {
		try {
			return new ResponseEntity<>(new Number(Integer.parseInt(value)), HttpStatus.OK);
		} catch (NumberFormatException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Enter a valid integer.", e);
		}
	}

}
