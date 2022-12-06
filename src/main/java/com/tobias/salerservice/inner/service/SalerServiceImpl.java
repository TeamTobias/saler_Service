package com.tobias.salerservice.inner.service;

import com.tobias.salerservice.inner.domain.RequestSaler;
import com.tobias.salerservice.inner.domain.Saler;
import com.tobias.salerservice.inner.repository.SalerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class SalerServiceImpl implements SalerService {

    private final SalerRepository salerRepository;

    public Iterable<Saler> getSalersAll() {return salerRepository.findAll();}

    @Transactional
    public void addSaler(RequestSaler requestClient) {

        Saler saler = salerRepository.findById(requestClient.getId());

        if (saler == null) {
            saler = Saler.createClient(requestClient);
            salerRepository.save(saler);
        }
    }

    @Transactional
    public void deleteSaler(int clientId){
        salerRepository.deleteById(clientId);
    }

    public void setSaler(int clientId, RequestSaler requestSaler){
        Saler saler = salerRepository.findById(clientId);
        if(saler!=null){
            saler.setName(requestSaler.getName());
            saler.setNickname(requestSaler.getNickname());
            saler.setEmail(requestSaler.getEmail());
            saler.setGender(requestSaler.getGender());
            saler.setBirth(requestSaler.getBirth());
            saler.setPhone(requestSaler.getPhone());
            salerRepository.save(saler);
        }
    }
}