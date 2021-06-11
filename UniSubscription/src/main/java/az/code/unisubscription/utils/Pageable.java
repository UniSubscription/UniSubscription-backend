package az.code.unisubscription.utils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * represents generic pagination dto
 * @param <T>
 */
public class Pageable<T> {
    public Pageable(List<T> items, int index, int size){
        System.out.println("AAAAAAAAAAAAAAa");
        this.index = index;
        this.total = (int) Math.ceil(items.size() / (double) size);
        this.items = items.stream().skip((index-1)*size).limit(size).collect(Collectors.toList());
        this.hasPrevious = index > 1;
        this.hasNext = index < total;
    }

    private List<T> items;
    private int total;
    private int index;
    private boolean hasNext;
    private boolean hasPrevious;

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public boolean isHasPrevious() {
        return hasPrevious;
    }

    public void setHasPrevious(boolean hasPrevious) {
        this.hasPrevious = hasPrevious;
    }

}
