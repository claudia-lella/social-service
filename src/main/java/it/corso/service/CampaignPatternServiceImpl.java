package it.corso.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.CampaignPatternDao;
import it.corso.model.CampaignPattern;

@Service
public class CampaignPatternServiceImpl implements CampaignPatternService {
	
	@Autowired
	private CampaignPatternDao campaignPatternDao;

	@Override
	public List<CampaignPattern> getCampaignPatterns() {

		return (List<CampaignPattern>) campaignPatternDao.findAll();
	}

}
