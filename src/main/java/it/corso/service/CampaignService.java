package it.corso.service;
import java.util.List;
import com.fasterxml.jackson.databind.node.ObjectNode;
import it.corso.dto.CampaignSingleUserDto;
import it.corso.model.Campaign;


public interface CampaignService {

	ObjectNode campaignRegistration(Campaign campaign, String token);
	List<CampaignSingleUserDto> getCampaign(String token);
}
