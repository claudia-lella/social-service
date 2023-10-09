package it.corso.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.corso.model.CampaignPattern;
import it.corso.service.CampaignPatternService;

@RestController
@RequestMapping("social/campaign_pattern")
@CrossOrigin(origins = {"*"})
public class CampaignPatternController {

	@Autowired
	private CampaignPatternService campaignPatternService;
	
	// endpoint 1 localhost:8080/social/campaign_pattern/get
	@GetMapping("/get")
	public ResponseEntity<List<CampaignPattern>> getAllPatterns(){
		List<CampaignPattern> response = campaignPatternService.getCampaignPatterns();
				
		return new ResponseEntity<List<CampaignPattern>>(response, HttpStatus.OK);
	}
}
