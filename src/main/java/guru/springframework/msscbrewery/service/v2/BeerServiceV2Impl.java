package guru.springframework.msscbrewery.service.v2;

import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;
import guru.springframework.msscbrewery.web.model.v2.BeerStyleEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceV2Impl implements BeerServiceV2 {
    @Override
    public BeerDtoV2 getBeerById(UUID beerId) {
        return BeerDtoV2.builder().id(UUID.randomUUID()).beerName("Pale Ale Cat").beerStyle(BeerStyleEnum.ALE).build();
    }

    @Override
    public BeerDtoV2 saveBeer(BeerDtoV2 beerDto) {
        return BeerDtoV2.builder().id(UUID.randomUUID()).beerName(beerDto.getBeerName()).build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDtoV2 beerDto) {
        // TODO: IMPLEMENTATION ONLY RELEVANT WITH A PERSISTENCE LAYER
        log.debug("Updating beer {} - {}", beerId, beerDto);

    }

    @Override
    public void deleteBeerById(UUID beerId) {
        // TODO: IMPLEMENTATION ONLY RELEVANT WITH A PERSISTENCE LAYER
        log.debug("Deleting beer..." + beerId);
    }
}
