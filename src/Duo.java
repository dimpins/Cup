import java.util.ArrayList;

public class Duo {
    private final ArrayList<Integer> list = new ArrayList<>();                 //лист для хранения пары (изменить нельзя)

    public Duo(int a, int b) {                         //конструктор для заноса пары
        list.add(a);
        list.add(b);
    }

    public ArrayList<Integer> getList() {
        return list;
    }

    public boolean isContainsOneNumber(Duo duo) {               //проверка на наличие одного из двух чисел в другой паре
        int a = duo.getList().get(0);
        int b = duo.getList().get(1);
        return list.contains(a) || list.contains(b);            //если есть хоть одно число, то true
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
