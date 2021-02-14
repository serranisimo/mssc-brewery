package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.web.model.BeerDto;
import guru.springframework.msscbrewery.service.BeerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("api/v1/beer")
@RestController
public class BeerController {

    private BeerService beerService;

    private static final String REQUEST_MAPPING = "api/v1/beer";

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId){
        return new ResponseEntity<BeerDto>(beerService.getBeerById(beerId), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody BeerDto beerDto) {
         BeerDto savedDto = beerService.saveBeer(beerDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        // Convention returning the path where to access the resource
        httpHeaders.add("Location", REQUEST_MAPPING + "/" + savedDto.getId().toString());
        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<BeerDto> handleUpdate(@PathVariable UUID beerId, @RequestBody BeerDto beerDto) {
        beerService.updateBeer(beerId, beerDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // alternative implementation to the UPDATE method; If further headers are needed, the the UPDATE implementation is preferable
    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDelete(@PathVariable UUID beerId) {
        beerService.deleteBeerById(beerId);
    }

}
