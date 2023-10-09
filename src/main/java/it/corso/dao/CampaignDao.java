package it.corso.dao;

import org.springframework.data.repository.CrudRepository;

import it.corso.model.Campaign;

public interface CampaignDao extends CrudRepository<Campaign, Integer> {

}
