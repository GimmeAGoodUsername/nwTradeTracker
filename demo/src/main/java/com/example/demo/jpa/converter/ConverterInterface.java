package com.example.demo.jpa.converter;

public interface ConverterInterface<Entity,Model> {
    public Entity convertToEntity(Model m);
    public Model convertToModel(Entity e);
}
