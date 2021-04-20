package com.epam.jwd.repository;

import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.SimpleFigureFactory;
import com.epam.jwd.repository.impl.FigureStorageCrud;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface StorageCrud extends Iterable<Figure> {

    static StorageCrud newInstance() {
        return FigureStorageCrud.INSTANCE;
    }

    public boolean create(SimpleFigureFactory.FigureType type, Point... points);

    public void multiCreate(SimpleFigureFactory.FigureType type, int count, Point... points);

    public boolean delete(int index);

    public Optional<Figure> findByInd(int index);

    public List<Figure> find(Predicate<Figure> predicate);

    public boolean update(int index, SimpleFigureFactory.FigureType type, Point... points);
}
