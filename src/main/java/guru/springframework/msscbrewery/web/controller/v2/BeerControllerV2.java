package guru.springframework.msscbrewery.web.controller.v2;

import guru.springframework.msscbrewery.service.v2.BeerServiceV2;
import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Validated // For Method Input validation
@RequestMapping("api/v2/beer")
@RestController
public class BeerControllerV2 {

    private BeerServiceV2 beerService;

    private static final String REQUEST_MAPPING = "api/v2/beer";

    public BeerControllerV2(BeerServiceV2 beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDtoV2> getBeer(@NotNull @PathVariable("beerId") UUID beerId) {
        return new ResponseEntity<BeerDtoV2>(beerService.getBeerById(beerId), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity handlePost( @Valid @NotNull @RequestBody BeerDtoV2 BeerDtoV2) {
        BeerDtoV2 savedDto = beerService.saveBeer(BeerDtoV2);
        HttpHeaders httpHeaders = new HttpHeaders();
        // Convention returning the path where to access the resource
        httpHeaders.add("Location", REQUEST_MAPPING + "/" + savedDto.getId().toString());
        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<BeerDtoV2> handleUpdate(@PathVariable UUID beerId, @Valid @RequestBody BeerDtoV2 BeerDtoV2) {
        beerService.updateBeer(beerId, BeerDtoV2);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // alternative implementation to the UPDATE method; If further headers are needed, the the UPDATE implementation is preferable
    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDelete(@PathVariable UUID beerId) {
        beerService.deleteBeerById(beerId);
    }

}
