package com.laserants.spring_api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laserants.spring_api.models.SucursalModel;
import com.laserants.spring_api.repositories.SucursalRepository;

@Service
public class SucursalService {

    @Autowired
    SucursalRepository sucursalRepository;

    public List<SucursalModel> getAllSucursales() {
        return sucursalRepository.findAll();
    }

    public SucursalModel getSucursalById(Integer id) {
        return sucursalRepository.findById(id).orElse(null);
    }

    public SucursalModel saveSucursal(SucursalModel sucursal) {
        return sucursalRepository.save(sucursal);
    }

    public boolean deleteSucursal(Integer id) {
        if (sucursalRepository.existsById(id)) {
            sucursalRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
