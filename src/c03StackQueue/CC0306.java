package c03StackQueue;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Created by SkinTang on 7/7/17.
 * Animal Shelter:
 * An animal shelter, which holds only dogs and cats,
 * operates on a strictly" first in,  first out" basis.
 * People must adopt either the "oldest" (based on arrival time) of all animals at the shelter,
 * or they can select whether they would prefer a dog or a cat
 * (and will receive the oldest animal of that type).
 * They cannot select which specific animal they would like.
 * Create the data structures to maintain this system and
 * implement operations such as enqueue, dequeueAny, dequeueDog, and dequeueCat.
 * You may use the built-in Linked list data structure.
 *
 * Hints:#22, #56, #63
 */
public class CC0306 {
    class Animal {
        public int id;
        public String type;

        Animal(int id, String type) {
            this.id = id;
            this.type = type;
        }
    }
    private class AnimalShelter {
        private LinkedList<Animal> queue;
        AnimalShelter() {
            this.queue = new LinkedList<>();
        }

        private void enqueue(Animal animal) {
            queue.addLast(animal);
        }

        private Animal dequeueAny() {
            return queue.removeFirst();
        }

        private Animal dequeueDog() {
            return dequeueAnimal("dog");
        }

        private Animal dequeueCat() {
            return dequeueAnimal("cat");
        }

        private Animal dequeueAnimal(String type) {
            Animal returnItem = null;
            Stack<Animal> stack = new Stack<>();
            while (!queue.isEmpty()) {
                Animal top = queue.removeFirst();
                if (top.type.equals(type)) {
                    returnItem = top;
                    break;
                }
                stack.push(top);
            }
            while (!stack.isEmpty()) {
                queue.addFirst(stack.pop());
            }
            if (returnItem == null) {
                throw new NoSuchElementException();
            }
            return returnItem;
        }
    }

    private class AnimalShelterSeparate {
        private LinkedList<Animal> catQueue;
        private LinkedList<Animal> dogQueue;

        AnimalShelterSeparate() {
            catQueue = new LinkedList<>();
            dogQueue = new LinkedList<>();
        }

        public void enqueue(Animal animal) {
            if (animal.type.equals("dog")) {
                dogQueue.addLast(animal);
            } else {
                catQueue.addLast(animal);
            }
        }

        public Animal dequeueAny() {
            if (dogQueue.isEmpty() && catQueue.isEmpty()) {
                return null;
            }
            if (dogQueue.isEmpty()) {
                return catQueue.removeFirst();
            }
            if (catQueue.isEmpty()) {
                return dogQueue.removeFirst();
            }
            Animal catTop = catQueue.removeFirst();
            Animal dogTop = dogQueue.removeFirst();
            if (catTop.id > dogTop.id) {
                catQueue.addFirst(catTop);
                return dogTop;
            }
            dogQueue.addFirst(dogTop);
            return catTop;
        }

        public Animal dequeueDog() {
            return dogQueue.removeFirst();
        }

        public Animal dequeueCat() {
            return catQueue.removeFirst();
        }
    }
}
