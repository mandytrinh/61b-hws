public class LinkedListDeque<genericType>
{
    public class Node
    {
        public Node prev;
        public genericType item;
        public Node next;

        public Node(Node p, genericType i, Node n)
        {
            prev = p;
            item = i;
            next = n;
        }
    }

    private Node sentinel;
    private int size;

    /* Creates an empty linked list deque
        With sentinel node that points at itself; previous is itself; next is itself */
    public LinkedListDeque()
    {
        size = 0;
        sentinel = new Node(sentinel, null, sentinel);
    }

    // Returns true if deque is empty, false otherwise
    public boolean isEmpty()
    {
        return size == 0;
    }

    /* Returns the number of items in the Deque.
        Must take constant time */

    public int size()
    {
        return size;
    }

    /*  Adds an item to the front of the Deque.
        Must not involve any looping or recursion & take constant time */
    public void addFirst(genericType x)
    {
        if (this.isEmpty())
        {
            Node first = new Node(sentinel, x, sentinel);
            sentinel.prev = first;
            sentinel.next = first;
        }
        else
        {
            Node oldFirst = sentinel.next;
            Node newFirst = new Node(sentinel, x, oldFirst);
            oldFirst.prev = newFirst;
            sentinel.next = newFirst;
        }
        size += 1;
    }

    /* Adds an item to the back of the Deque.
       Must not involve any looping or recursion */

    public void addLast(genericType x)
    {
        if (this.isEmpty())
        {
            Node last = new Node(sentinel, x, sentinel);
            sentinel.next = last;
            sentinel.prev = last;
        }
        else
        {
            Node oldLast = sentinel.prev;
            Node newLast = new Node(oldLast, x, sentinel);
            oldLast.next = newLast;
            sentinel.prev = newLast;
        }
        size += 1;
    }

    /* Removes and returns the item at the front of the Deque.
        If no such item exists, returns null.*/

     public genericType removeFirst()
     {
         if (isEmpty())
         {
             return null;
         }
         Node firstNode = sentinel.next;
         genericType itemInFirstNode = firstNode.item;

         Node secondNode = firstNode.next;
         sentinel.next = secondNode; //breaks link to 1st node & make sentinel points to 2nd node
         secondNode.prev = sentinel; //balance & make the 2nd's (new 1st's) prev point to sentinel

         size = size - 1;
         firstNode = null; // destroy reference for garbage collection
         return itemInFirstNode;
     }

     /* Removes and returns the item at the back of the Deque.
        If no such item exists, returns null.
        This is the mirror of the removeFirst method */

    public genericType removeLast()
    {
        if (isEmpty())
        {
            return null;
        }
        Node lastNode = sentinel.prev;
        genericType itemInLastNode = lastNode.item;

        Node secondToLastNode = lastNode.prev;
        sentinel.prev = secondToLastNode;
        secondToLastNode.next = sentinel;

        size = size - 1;
        lastNode = null;
        return itemInLastNode;
    }

    /* Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null.
     Must be non destructive: i.e not alter the deque!
     */
    public genericType get(int index)
    {
        if (isEmpty())
        {
            return null;
        }
        if (size == 1 && index == 0)
        {
            Node onlyNode = sentinel.next;
            return onlyNode.item;
        }
        if (index > 0)
        {
            int counter = 0;
            Node currentNode = sentinel.next;
            while (index > counter)
            {
                currentNode = currentNode.next;
                counter = counter + 1;
            }
            return currentNode.item;
        }
        return null;
    }

    private genericType recursiveHelper(int index, Node node)
    {
        if (index == 0)
        {
            return node.item;
        }
        return recursiveHelper(index - 1, node.next);
    }

    public genericType getRecursive(int index)
    {
        if (isEmpty() || index >= size)
        {
            return null;
        }
        Node firstNode = sentinel.next;
        return recursiveHelper(index, firstNode);
    }
    // Prints the items in the Deque from first to last, separated by a space
    public void printDeque()
    {
        Node currentNode = sentinel.next;
        while (currentNode != sentinel)
        {
            System.out.print(currentNode.item + " ");
            currentNode = currentNode.next;
        }

    }

}