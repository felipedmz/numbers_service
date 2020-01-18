package com.number.restservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class NumberController {

	/*@PostMapping("/check")
	public BigInteger check(@RequestBody Number numberToCheck) {
		return numberToCheck.getValue();
	}*/

	@GetMapping("/check/{value}")
	public ResponseEntity<Number> isPerfectNumber(@PathVariable String value) {
		try {
			return new ResponseEntity<>(new Number(Integer.parseInt(value)), HttpStatus.OK);
		} catch (NumberFormatException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Enter a valid integer.", e);
		}
	}

}
