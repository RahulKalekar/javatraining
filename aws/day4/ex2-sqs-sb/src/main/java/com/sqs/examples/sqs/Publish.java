
package com.sqs.examples.sqs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.awspring.cloud.sqs.operations.SqsTemplate;

@RestController("")
public class Publish {

	@Autowired
	@Qualifier("publish")
	private SqsTemplate sqs;

	@Value("${sqs.url}")
	private String sqsUrl;

	@PostMapping("/publish/{msg}")
	public ResponseEntity<String> postMessage(@PathVariable("msg") String message) {
		sqs.send(sqsUrl, message);
		return new ResponseEntity<>("Message Published", HttpStatus.OK);
	}

}
