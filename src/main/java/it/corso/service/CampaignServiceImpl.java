package it.corso.service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.node.ObjectNode;
import it.corso.dao.CampaignDao;
import it.corso.dao.UserDao;
import it.corso.dto.CampaignSingleUserDto;
import it.corso.helper.ResponseManager;
import it.corso.model.Campaign;
import it.corso.model.User;


@Service
public class CampaignServiceImpl implements CampaignService {

	@Autowired
	private UserDao userDao;
	
	private ModelMapper mapper = new ModelMapper();
	
	@Autowired
	private CampaignDao campaignDao;
	
	@Autowired
	private ResponseManager responseManager;
	
	@Override
	public ObjectNode campaignRegistration(Campaign campaign, String token) {
		
	    User user = userDao.findByAuthToken(token);
	    
	    if (user == null) 
	        return responseManager.getResponse(401, "Not Authorized");
	    
	    String profileType = user.getProfileType();
	    Date startDate = campaign.getStart();
	    Date endDate = campaign.getEnd();
	    Date currentDate = new Date();
	    
	    if ("Business".equals(profileType)) {
	        if (!startDate.after(currentDate) && endDate.after(currentDate)) {
	            campaign.setUser(user);
	            campaign.setStatus("Attivata");
	        } else if (startDate.after(currentDate)) {
	        	campaign.setStatus("Programmata");
	        } else {
	            campaign.setUser(user);
	            campaign.setStatus("Terminata");
	        }
	        
	        campaignDao.save(campaign);
	        return responseManager.getResponse(201, "Campaign registered");
	    } else 
	        return responseManager.getResponse(401, "Not Authorized: Only Business users can register campaigns");
	}

	@Override
	public List<CampaignSingleUserDto> getCampaign(String token) {
		
		List<CampaignSingleUserDto> campaignsDto = new ArrayList<>();
        User user = userDao.findByAuthToken(token);
        
        if(user == null)
            return campaignsDto;
        
		List<Campaign> allCampaigns = (List<Campaign>) campaignDao.findAll();
		List<Campaign> campaigns = new ArrayList<>();
		
		allCampaigns.forEach(c -> {
            if(c.getUser().getId() == user.getId())
            	campaigns.add(c);
            });

		campaigns.forEach(c -> campaignsDto.add(mapper.map(c, CampaignSingleUserDto.class)));
        
        return campaignsDto;
	}
}