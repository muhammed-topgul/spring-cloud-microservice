package com.muhammedtopgul.ticketservice.repository.es;

/*
 * created by Muhammed Topgul
 * on 08/06/2021
 * at 23:37
 */

import com.muhammedtopgul.ticketservice.entity.es.TicketElasticEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketElasticRepository extends ElasticsearchRepository<TicketElasticEntity, String> {
}
