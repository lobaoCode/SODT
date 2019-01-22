package br.com.bigwolf.service;

import br.com.bigwolf.dao.Dao;
import br.com.bigwolf.domain.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmpresaServiceImpl implements iService<Empresa>{

    @Autowired
    private Dao<Empresa> dao;

    @Override
    public void save(Empresa obj) {
        dao.save(obj);
    }

    @Override
    public void update(int id, Empresa obj) {
        obj.setId(id);
        dao.update(obj);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override @Transactional(readOnly = true)
    public Empresa findById(int id) {
        return dao.findById(id);
    }

    @Override @Transactional(readOnly = true)
    public List<Empresa> findAll() {
        return dao.findAll();
    }

}
