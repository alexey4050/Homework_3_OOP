import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        LinkedContainer<String> stringLinkedCars = new LinkedContainer<>();
        stringLinkedCars.addLast("Volga");
        stringLinkedCars.addFirst("Nissan");
        stringLinkedCars.addLast("Toyota");
        stringLinkedCars.addLast("Suzuki");
        stringLinkedCars.addLast("BMV");
        System.out.println(stringLinkedCars.size());
        System.out.println("Первая марка машины в списке: " + stringLinkedCars.getElementByIndex(0));
        System.out.println("_______________с начала списка_______________________");
        

        for(String item : stringLinkedCars){
            System.out.println(item);
        }
        LinkedContainer<Integer>integerLinkedEnginePower = new LinkedContainer<>();
        integerLinkedEnginePower.addLast(123);
        integerLinkedEnginePower.addFirst(86);
        integerLinkedEnginePower.addLast(205);
        integerLinkedEnginePower.addLast(138);
        integerLinkedEnginePower.addLast( 180);
        System.out.println("-----------------с конца списка-------------");
        Iterator iterator = integerLinkedEnginePower.descendingIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}