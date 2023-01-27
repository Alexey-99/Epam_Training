package by.koroza.shape.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import by.koroza.shape.entity.AbstractFigure;

public class FigureRepository {
	private static final List<AbstractFigure> figures = new ArrayList<>();

	public static List<AbstractFigure> getFigures() {
		return figures;
	}

	public int size() {
		return figures.size();
	}

	public boolean isEmpty() {
		return figures.isEmpty();
	}

	public boolean contains(Object o) {
		return figures.contains(o);
	}

	public boolean add(AbstractFigure e) {
		return figures.add(e);
	}

	public boolean remove(Object o) {
		return figures.remove(o);
	}

	public boolean addAll(Collection<? extends AbstractFigure> c) {
		return figures.addAll(c);
	}

	public boolean addAll(int index, Collection<? extends AbstractFigure> c) {
		return figures.addAll(index, c);
	}

	public boolean removeAll(Collection<?> c) {
		return figures.removeAll(c);
	}

	public void sort(Comparator<AbstractFigure> c) {
		figures.sort(c);
	}

	public List<AbstractFigure> sortCopy(Comparator<AbstractFigure> c) {
		List<AbstractFigure> figuresCopy = figures;
		figuresCopy.sort(c);
		return figuresCopy;
	}

	public void clear() {
		figures.clear();
	}

	public AbstractFigure get(int index) {
		return figures.get(index);
	}

	public AbstractFigure set(int index, AbstractFigure element) {
		return figures.set(index, element);
	}

	public void add(int index, AbstractFigure element) {
		figures.add(index, element);
	}

	public AbstractFigure remove(int index) {
		return figures.remove(index);
	}

	public int indexOf(Object o) {
		return figures.indexOf(o);
	}

	public void forEach(Consumer<? super AbstractFigure> action) {
		figures.forEach(action);
	}

	public List<? extends AbstractFigure> query(TriangleSpecification specification) {
		List<AbstractFigure> resultList = new ArrayList<>();
		for (AbstractFigure figure : figures) {
			if (specification.specify(figure)) {
				resultList.add(figure);
			}
		}
		return resultList;
	}

	public List<? extends AbstractFigure> queryStream(TriangleSpecification specification) {
		return figures.stream().filter(specification::specify).toList();

	}

	@Override
	public boolean equals(Object o) {
		return figures.equals(o);
	}

	@Override
	public int hashCode() {
		return figures.hashCode();
	}

	@Override
	public String toString() {
		return figures.toString();
	}
}