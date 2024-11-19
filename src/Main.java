import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();                        //вводим кол-во человек
        sc.nextLine();
        if(n == 1){
            System.out.println("Нет пар, когда 1 человек");
            return;
        }

        ArrayList<String> listName = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            listName.add(sc.nextLine());               //заполняем их
        }

        ArrayList<Duo> duo = new ArrayList<>();          //лист пар для хранения всех
        for (int i = 0; i < n - 1; i++) {
            for(int j = i+1; j < n; j++) {
                duo.add(new Duo(i, j, listName.get(i), listName.get(j)));            //добавляем пару
            }
        }

        ArrayList<Duo> duoSort = new ArrayList<>();             //листа пар, где не повторяется число больше 1 раза подряд в парах
        duoSort.add(duo.getFirst());                            //заносим первый элемент
        duo.removeFirst();                                      //удаляем из предыдущего списка

        while(!duo.isEmpty()) {                                 //пока не закончатся пары
            boolean isAdded = false;                            //проверка на добавление

            for(int i = 0; i< duo.size(); i++){                                 //ищем пару, которую можно вставить
                if(!duoSort.getLast().isContainsOneNumber(duo.get(i))){         //если можно вставить в конце, вставляем
                    duoSort.add(duo.get(i));
                    duo.remove(i);
                    isAdded = true;
                    break;
                }
            }

            if(!isAdded){                                    //если не вставилось до
                for(int i = 0; i< duo.size(); i++){                                          //ищем пару, которую можно вставить
                    if(!duoSort.getFirst().isContainsOneNumber(duo.get(i))){                 //если можно вставить в начало, вставляем
                        duoSort.addFirst(duo.get(i));
                        duo.remove(i);
                        isAdded = true;
                        break;
                    }
                }
            }

            if(!isAdded){                                                          //если не вставилось до
                for(int i = 1; i < duoSort.size(); i++){                              //ищем место посередине массива, куда можно вставить следующую пару
                    for(int j = 0; j < duo.size(); j++){                              //проверяем все пары
                        if(!duoSort.get(i).isContainsOneNumber(duo.get(j)) &&               //если можно между двумя, вставляем
                                !duoSort.get(i-1).isContainsOneNumber(duo.get(j))){
                            duoSort.add(i, duo.get(j));
                            duo.remove(j);
                            isAdded = true;
                            i = duoSort.size();
                            break;
                        }
                    }
                }
            }

            if(!isAdded){                                    //если не вставилось до, то вставляем в конец
                duoSort.add(duo.getFirst());
                duo.removeFirst();
            }
        }

        System.out.println(duoSort);
    }

}
