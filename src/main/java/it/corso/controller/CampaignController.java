package it.corso.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.node.ObjectNode;
import it.corso.dto.CampaignSingleUserDto;
import it.corso.model.Campaign;
import it.corso.service.CampaignService;

@RestController
@RequestMapping("social/campaign")
@CrossOrigin(origins = {"*"})
public class CampaignController {

	@Autowired
	private CampaignService campaignService;
	
	// endpoint #1: campagna registration | localhost:8080/social/campaign/reg
	@PostMapping("/reg/{tkn}")
	public ResponseEntity<ObjectNode> campaignRegistration(
		@RequestBody Campaign campaign,
		@PathVariable("tkn") String token)
	{
		ObjectNode response = campaignService.campaignRegistration(campaign, token);
		return new ResponseEntity<ObjectNode>(response, HttpStatusCode.valueOf(response.get("code").asInt()));
	}
	
	// endpoint #2: campagna registration | localhost:8080/social/campaign/get
	@GetMapping("/get/{tkn}")
	public ResponseEntity<List<CampaignSingleUserDto>> getCampaigns(@PathVariable("tkn") String token){
		List<CampaignSingleUserDto> response = campaignService.getCampaign(token);
		
		return new ResponseEntity<List<CampaignSingleUserDto>>(response, HttpStatus.OK);
	}
}
