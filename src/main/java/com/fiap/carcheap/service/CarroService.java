package com.fiap.carcheap.service;

import com.fiap.carcheap.controller.request.CarroUpdateRequest;
import com.fiap.carcheap.exception.CarroNotFoundException;
import com.fiap.carcheap.repository.CarroRepository;
import com.fiap.carcheap.repository.entity.Carro;
import com.fiap.carcheap.repository.entity.enums.StatusCarroEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import static com.fiap.carcheap.repository.entity.enums.ClassificacaoCarroEnum.ECONOMICO;
import static com.fiap.carcheap.repository.entity.enums.ClassificacaoCarroEnum.PREMIUM;

@Slf4j
@Service
public class CarroService {
    @Autowired
    private CarroRepository repo;

    public Collection<Carro> findAll() {
        return repo.findAll();
    }

    public Optional<Carro> findById(String id) {
        var carroOp = repo.findById(UUID.fromString(id));

        if (carroOp.isEmpty()) throw new CarroNotFoundException();

        return carroOp;
    }

    public Carro save(Carro carro) {
        carro.setClassificacao((carro.getVr_venda() > 100000) ? PREMIUM : ECONOMICO);
        carro.setStatus(StatusCarroEnum.DISPONIVEL);
        carro = repo.save(carro);
        return carro;
    }

    public Carro update(String id, CarroUpdateRequest request) {
        var carroOp = repo.findById(UUID.fromString(id));

        if (carroOp.isEmpty()) throw new CarroNotFoundException();

        var carro = carroOp.get();
        carro.setVr_venda(request.getValorVenda());
        return repo.save(carro);
    }

    public void delete(String id) {
        var carro = findById(id).get();
       carro.setStatus(StatusCarroEnum.INDISPONIVEL);
       repo.save(carro);
    }
}
