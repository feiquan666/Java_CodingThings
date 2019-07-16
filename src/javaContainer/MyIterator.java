package javaContainer;
import org.junit.Test;
import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

import java.util.*;

public class MyIterator {

    @Test
    public void test_myIterator(){
        List<Pet> pets = Pets.arrayList(12);
        Iterator<Pet> petIterator = pets.iterator();
        while (petIterator.hasNext()){
            Pet pet = petIterator.next();
            System.out.print(pet.id() + ":" + pet + " ");
        }
        System.out.println();
        for(Pet pet:pets){
            System.out.print(pet.id() + ":" + pet + " ");
        }
        System.out.println();
        petIterator = pets.iterator();
        for(int  i = 0; i < 6; i++){
            petIterator.next();
            petIterator.remove();
        }
        System.out.println(pets);
    }

    @Test
    public void test_display(){
        List<Pet> pets = Pets.arrayList(8);
        List<Pet> pets1 = new LinkedList<>(pets);
        Set<Pet> pets2 = new HashSet<>(pets);
        Set<Pet> pets3 = new TreeSet<>(pets);
        display(pets.iterator());
        display(pets1.iterator());
        display(pets2.iterator());
        display(pets3.iterator());
    }
    @Test
    public void test_listIterator(){
        List<Pet> pets = Pets.arrayList(8);
        ListIterator<Pet> petListIterator = pets.listIterator();
        while (petListIterator.hasNext()){
            System.out.print(petListIterator.next() + ", " + petListIterator.nextIndex() + ", "
                    + petListIterator.previousIndex() + ";");
        }
        System.out.println();
        while (petListIterator.hasPrevious()){
            System.out.print(petListIterator.previous().id() + " ");
        }
        System.out.println();
        System.out.println(pets);
        petListIterator = pets.listIterator(3);
        while (petListIterator.hasNext()){
            petListIterator.next();
            petListIterator.set(Pets.randomPet());
        }
        System.out.println(pets);
        Object o = new Object();
        o.equals(1);
    }

    private void display(Iterator<Pet> petIterator){
        while (petIterator.hasNext()){
            Pet pet = petIterator.next();
            System.out.print(pet.id() + " " + pet + " ");
        }
        System.out.println();
    }
}
