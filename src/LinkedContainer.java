import java.util.Iterator;

public class LinkedContainer <E> implements Linked<E>, Iterable<E>, DescendingIterator<E>{
    private Node<E> firstNode;
    private Node<E> lastNode;
    private  int size = 0;
    public LinkedContainer(){
        lastNode = new Node<>(null, firstNode, null);
        firstNode = new Node<>(null, null, lastNode);
    }

    @Override
    public void addLast(E e) {
        Node<E> prev = lastNode;
        prev.setCurrentElement(e);
        lastNode = new Node<>(null, prev, null );
        prev.setNextElement(lastNode);
        size++;
    }

    @Override
    public void addFirst(E e) {
        Node<E> next = firstNode;
        next.setCurrentElement(e);
        firstNode = new Node<>(null, null, next);
        next.setPrevElement(firstNode);
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E getElementByIndex(int counter) {
        Node<E> target = firstNode.getNextElement();
        for(int i = 0; i < counter; i++){
            target = getNextElement(target);
        }
        return target.getCurrentElement();
    }
    private Node<E> getNextElement(Node<E> current){
        return current.getNextElement();
    }
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int counter = 0;
            @Override
            public boolean hasNext() {
                return counter < size;
            }

            @Override
            public E next() {
                return getElementByIndex(counter++);
            }
        };
    }
    @Override
    public Iterator<E> descendingIterator() {
        return new Iterator<E>() {
            int counter = size - 1;
            @Override
            public boolean hasNext() {
                return counter >= 0;
            }
            @Override
            public E next() {
                return getElementByIndex(counter--);
            }
        };
    }

    private  class Node<E>{
        private E currentElement;
        private Node<E> nextElement;
        private Node<E> prevElement;

        public Node(E currentElement,  Node<E> prevElement, Node<E> nextElement) {
            this.currentElement = currentElement;
            this.nextElement = nextElement;
            this.prevElement = prevElement;
        }

        public E getCurrentElement() {
            return currentElement;
        }

        public Node<E> getNextElement() {
            return nextElement;
        }

        public Node<E> getPrevElement() {
            return prevElement;
        }

        public void setCurrentElement(E currentElement) {
            this.currentElement = currentElement;
        }

        public void setNextElement(Node<E> nextElement) {
            this.nextElement = nextElement;
        }

        public void setPrevElement(Node<E> prevElement) {
            this.prevElement = prevElement;
        }
    }
}

