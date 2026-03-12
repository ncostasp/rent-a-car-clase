package service;

import model.Model;
import repository.ModelRepository;
import repository.IModelRepository;

import java.util.ArrayList;

public class ModelServiceImpl implements IModelService{

    private IModelRepository repository;


    public ModelServiceImpl() {
        repository = ModelRepository.getModelRepository();
    }

    public void add(String name, int pricePerDay) {
        Model model = new Model(name, pricePerDay);
        repository.add(model);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public ArrayList findAll() {
        return repository.findAll();
    }


    public Model findById(Long id) {
        return repository.findById(id);
    }


    public void update(Long id, String name, int pricePerDay) {
        Model model = new Model(id, name, pricePerDay);
        repository.update(model);
    }


}
