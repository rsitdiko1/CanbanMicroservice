package collections;

import dto.Task;
import exceptions.SomethingWentWrongException;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TaskStack<T extends Task> {
    private final int stackSize;
    private List<T> list = new LinkedList<>();

    public TaskStack(int size){
        stackSize = size;
    }

    public void push(T task) {
        if (list.size() < stackSize) {
            list.add(task);
        } else if (list.size() == stackSize) {
            list.remove(0);
            list.add(task);
        } else {
            throw new SomethingWentWrongException("Something wrong with SpecialStack");
        }
    }

    public List<T> getReversedOrder(){
        List<T> copy = new LinkedList<>(list);
        Collections.reverse(copy);
        return copy;
    }

    public List<T> getStraightOrder(){
        return list;
    }

    public void removeAll(){
        list.clear();
    }
}
