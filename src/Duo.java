import java.util.ArrayList;

public class Duo {
    private final ArrayList<String> listName = new ArrayList<>();                 //лист для хранения пары (изменить нельзя)
    private final ArrayList<Integer> listIndex = new ArrayList<>();

    public Duo(int a, int b, String name, String name1) {                         //конструктор для заноса пары
        listIndex.add(a);
        listIndex.add(b);
        listName.add(name);
        listName.add(name1);
    }

    public ArrayList<Integer> getListIndex() {
        return listIndex;
    }

    public boolean isContainsOneNumber(Duo duo) {               //проверка на наличие одного из двух чисел в другой паре
        int a = duo.getListIndex().getFirst();
        int b = duo.getListIndex().getLast();
        return listIndex.contains(a) || listIndex.contains(b);            //если есть хоть одно число, то true
    }

    @Override
    public String toString() {
        return listName.toString();
    }
}
