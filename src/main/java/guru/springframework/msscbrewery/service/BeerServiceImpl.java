package guru.springframework.msscbrewery.service;

import guru.springframework.msscbrewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID()).beerName("Pale Ale Cat").beerStyle("Pale Ale").build();
    }

    @Override
    public BeerDto saveBeer(BeerDto beerDto) {
        return BeerDto.builder().id(UUID.randomUUID()).beerName(beerDto.getBeerName()).build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {
        // TODO: IMPLEMENTATION ONLY RELEVANT WITH A PERSISTENCE LAYER
        log.debug("Updating beer {} - {}", beerId, beerDto);

    }

    @Override
    public void deleteBeerById(UUID beerId) {
        // TODO: IMPLEMENTATION ONLY RELEVANT WITH A PERSISTENCE LAYER
        log.debug("Deleting beer..." + beerId);
    }
}
