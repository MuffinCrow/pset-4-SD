import java.util.NoSuchElementException;

public class SimpleQueue {
    private String[] queue;
    private int capacity;
    private int current = 0;

    public SimpleQueue(int c) {
        if (c < 1) {
            throw new IllegalArgumentException();
        }
        queue = new String[c];
        capacity = c;
    }

    public boolean add(String s) {
        if (s == null) {
            throw new NullPointerException();
        } else if (current >= capacity) {
            throw new IllegalStateException("Queue full");
        }

        queue[current] = s;
        current++;
        return true;
    }

    public void clear() {
        queue = new String[capacity];
        current = 0;
    }

    public boolean contains(String s) {
        for (int i = 0; i < current; i++) {
            if (queue[i] == s) {
                return true;
            }
        }
        return false;
    }

    public String element() {
        if (current == 0) {
            throw new NoSuchElementException();
        }
        return queue[0];
    }

    public boolean offer(String s) {
        if (s == null) {
            throw new NullPointerException();
        }else if (current == capacity) {
            return false;
        }

        queue[current] = s;
        current++;
        return true;
    }

    public String peek() {
        return queue[0];
    }

    public String poll() {
        if (current == 0) {
            return null;
        }

        String temp = queue[0];

        for (int i = 0; i < current; i++) {
            queue[i] = queue[i+1];
        }

        current--;
        return temp;
    }

    public int remainingCapacity() {
        int temp = capacity - current;
        return temp;
    }

    public String remove() {
        if (current == 0) {
            throw new NoSuchElementException();
        }

        String temp = queue[0];

        for (int i = 0; i < current; i++) {
            queue[i] = queue[i+1];
        }

        current--;
        return temp;
    }

    public boolean remove(String s) {
        int count = -1;

        for (int i = 0; i < current; i++) {
            if (queue[i] == s) {
                count = i;
            }
        }

        if (count == -1) {
            return false;
        }

        for (int i = count; i < current; i++) {
            queue[i] = queue[i+1];
        }

        current--;
        return true;
    }

    public int size() {
        return current;
    }

    public String toString() {
        String output = "[";

        for (int i = 0; i < current; i++) {
            output += queue[i];

            if (i < current - 1) {
                output += ", ";
            }
        }

        output += "]";
        return output;
    }
}
