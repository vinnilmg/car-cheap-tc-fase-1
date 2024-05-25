package com.fiap.carcheap.service;

import com.fiap.carcheap.repository.CarroRepository;
import com.fiap.carcheap.repository.entity.Carro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

import static com.fiap.carcheap.repository.entity.enums.ClassificacaoCarroEnum.ECONOMICO;
import static com.fiap.carcheap.repository.entity.enums.ClassificacaoCarroEnum.PREMIUM;

@Service
public class CarroService {

    @Autowired
    private CarroRepository repo;

    public Collection<Carro> findAll() {
        var carros = repo.findAll();
        return carros;
    }

    public Optional<Carro> findById(Long id) {
        var carro = repo.findById(id);
        return carro;
    }

    public Carro save(Carro carro) {
        carro.setClassificacao((carro.getVr_venda() > 100000) ? PREMIUM : ECONOMICO);
        carro = repo.save(carro);
        return carro;
    }

    public Carro update(Long id, Carro carro) {
        Carro buscaCarro = repo.getReferenceById(id);
        buscaCarro.setAnofab(carro.getAnofab());
        buscaCarro.setCor(carro.getCor());
        buscaCarro.setAnomodelo(carro.getAnomodelo());
        buscaCarro.setChassi(carro.getChassi());
        buscaCarro.setEquipamentos(carro.getEquipamentos());
        buscaCarro.setOrigem(carro.getOrigem());
        buscaCarro.setPlaca(carro.getPlaca());
        buscaCarro.setRenavan(carro.getRenavan());
        buscaCarro.setPotencia(carro.getPotencia());
        buscaCarro.setStatus(carro.getStatus());
        buscaCarro.setNr_portas(carro.getNr_portas());
        buscaCarro.setTp_carroceria(carro.getTp_carroceria());
        buscaCarro.setVr_venda(carro.getVr_venda());
        buscaCarro.setVr_original(carro.getVr_original());

        buscaCarro = repo.save(buscaCarro);
        return buscaCarro;
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
