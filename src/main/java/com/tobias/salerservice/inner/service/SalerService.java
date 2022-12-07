package com.tobias.salerservice.inner.service;

import com.tobias.salerservice.inner.domain.RequestSaler;
import com.tobias.salerservice.inner.domain.Saler;

public interface SalerService {
    void addSaler(RequestSaler client);
    Iterable<Saler> getSalersAll();
    void deleteSaler(int id);
    void setSaler(int clientId, RequestSaler client);

    Saler getSaler(int salerId);
}
