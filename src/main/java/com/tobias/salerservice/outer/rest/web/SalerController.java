package com.tobias.salerservice.outer.rest.web;

import com.tobias.salerservice.inner.domain.RequestSaler;
import com.tobias.salerservice.inner.domain.ResponseSaler;
import com.tobias.salerservice.inner.domain.Saler;
import com.tobias.salerservice.inner.service.SalerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class SalerController {

    private final SalerService salerService;

    @GetMapping("/health_check")
    public String status(){
            return "It's Working in Saler CUD Service";
        }

    @PostMapping("/saler/v1")
    public HttpStatus addSaler(@RequestBody RequestSaler requestSaler) {
        salerService.addSaler(requestSaler);
        return HttpStatus.OK;
    }

    @GetMapping("/saler/v1")
    public ResponseEntity<List<ResponseSaler>> allSaler() {
        Iterable<Saler> products = salerService.getSalersAll();
        List<ResponseSaler> result = new ArrayList<>();
        products.forEach(v -> result.add(new ModelMapper().map(v, ResponseSaler.class)));
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @DeleteMapping("/saler/v1/{salerId}")
    public HttpStatus deleteSaler(@PathVariable("salerId") int salerId){
        salerService.deleteSaler(salerId);
        return HttpStatus.OK;
    }

    @PutMapping("/saler/v1/{salerId}")
    public HttpStatus setSaler(@PathVariable("salerId") int salerId,@RequestBody RequestSaler requestSaler){
        salerService.setSaler(salerId, requestSaler);
        return HttpStatus.OK;
    }
}
