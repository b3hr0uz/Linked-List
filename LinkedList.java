public class LinkedList<Anything> {
	// the Node class is a inner class used (only) by the LinkedList class
	class Node {
		private Anything data;
		Node next;

		public Node(Anything a, Node n) {
			data = a;
			next = n;
		}
	}

	Node first;
	int length;

	public LinkedList() {
		first = null;
		length = 0;
	}

	public boolean isEmpty() {
		return (first == null);
	}

	public void addFirst(Anything d) {
		/*
		 * These two lines can be reduced to the single line which follows 
		 * Node temp =first; 
		 * first = new Node(d,temp);
		 */
		first = new Node(d, first);
		length++;
	}

	public int size() {
		return length;
	}

	public void clear() {
		first = null;
		length = 0;
	}

	public boolean contains(Anything value) {
		for (Node curr = first; curr != null; curr = curr.next) {
			if (value.equals(curr.data)) {
				return true;
			}
		}
		return false;
	}

	public Anything get(int index) {
		if (index < 0 || index >= length) {
			System.out.println("Index of " + index + " out of range");
			return null;
		}

		Node curr = first;
		for (int i = 0; i < index; i++)
			curr = curr.next;
		return curr.data;
	}

	public boolean remove(Anything m) {
		Node curr = first;
		Node lastVisited = null;

		while (curr != null) {
			if (m.equals(curr.data)) {
				length--;
				if (curr != first) {
					lastVisited.next = curr.next;
				} else {
					first = first.next;
				}
				return true;
			}

			lastVisited = curr;
			curr = curr.next;
		}
		return false;
	}

	public String toString() {
		StringBuilder result = new StringBuilder(); // String result = "";
		for (Node curr = first; curr != null; curr = curr.next)
			result.append(curr.data + "->"); // result = result + curr.data + "->";
		result.append("[null]");
		return result.toString(); // return result + "[null]";
	}
	

	public Anything getFirst() {
		if (first == null) {
			System.out.println("List is empty.");
			return null;
		}
			return first.data;
	}

	public Anything getLast() {
		if (first == null) {
			System.out.println("List is empty.");
			return null;
		}
			Node curr = first;
			while (curr.next != null)
				curr = curr.next;

			return curr.data;
	}

	public void add(Anything value) {
		Node temp = new Node(value, null);
        if (first == null) {
            first = temp;
        } else {
            Node curr = first;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = temp;
        }
        length++;
		
	}

	public void addAfter(int index, Anything value) {
		 if (index < 0 || index >= length) {
	            System.out.println("Index of " + index + " out of range");
	            return;
	        }

	        Node temp = new Node(value, null);
	        Node curr = first;
	        for (int i = 0; i < index; i++)
	            curr = curr.next;

	        temp.next = curr.next;
	        curr.next = temp;
	        length++;
	}

    public Anything set(int index, Anything newValue) {
        if (index < 0 || index >= length) {
            System.out.println("Index of " + index + " out of range");
            return null;
        }

        Node curr = first;
        for (int i = 0; i < index; i++)
            curr = curr.next;
        
        Anything oldValue = curr.data;
        curr.data = newValue;
        return oldValue;
    }

    public void removeAll(Anything value) {
        Node curr = first;
        Node lastVisited = null;

        while (curr != null) {
            if (value.equals(curr.data)) {
                length--;
                if (curr != first) {
                    lastVisited.next = curr.next;
                } else {
                    first = first.next;
                }
            } else {
                lastVisited = curr;
            }
            curr = curr.next;
        }
    }

    public int lastIndex(Anything value) {
        int lastIndex = -1;
        int currentIndex = 0;
        Node curr = first;

        while (curr != null) {
            if (value.equals(curr.data))
                lastIndex = currentIndex;

            curr = curr.next;
            currentIndex++;
        }

        return lastIndex;
    }

    public LinkedList<Anything> clone() {
        LinkedList<Anything> cloneList = new LinkedList<>();
        Node curr = first;

        while (curr != null) {
            cloneList.add(curr.data);
            curr = curr.next;
        }

        return cloneList;
    }

    public Node reverseList() {
        if (first == null || first.next == null)
            return first;

        Node prev = null;
        Node current = first;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        first = prev;
        return first;
    }

    // equals() method has not been updated to consider the reversed list as equal.
    // The equals() method compares the elements in the same order,
    // which is not valid when comparing the reversed list.
    // Override to compare the contents of the lists instead of their order.
    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (this == obj) 
            return true;
        

        if (obj == null || getClass() != obj.getClass())
            return false;

        LinkedList<?> other = (LinkedList<?>) obj;

        if (length != other.length)
            return false;

        Node curr1 = first;
		Node curr2 = (LinkedList<Anything>.Node) other.first;

        while (curr1 != null && curr2 != null) {
            if (!curr1.data.equals(curr2.data)) 
                return false;
            
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        return true;
    }


	public static void main(String[] args) {
		// Here you can create some lists (use lists of Strings
		// to test) and thoroughly test each of your new methods

		LinkedList<String> list1 = new LinkedList<String>();
        LinkedList<String> list2 = new LinkedList<String>();
        list1.addFirst("node1");
        System.out.println("1-element list: " + list1);
        list2.addFirst("node3"); list2.addFirst("node2"); list2.addFirst("node1");
        System.out.println("2-element list: " + list2);
        
        System.out.println("\nTesting size...");
        System.out.println(list1.size());
        System.out.println(list1.size()==1?"PASSED":"**FAILED**");
        System.out.println(list2.size() );
        System.out.println(list2.size()==3?"PASSED":"**FAILED**");
   
        System.out.println("\nTesting getFirst...");
        System.out.println(list1.size() + " " + list1);
        System.out.println(list1.getFirst().equals("node1")?"PASSED":"**FAILED**");
        System.out.println(list2.size() + " " + list2);
        System.out.println(list2.getFirst().equals("node1")?"PASSED":"**FAILED**");
        
        System.out.println("\nTesting getLast...");
        System.out.println(list1.size() + " " + list1);
        System.out.println(list1.getLast().equals("node1")?"PASSED":"**FAILED**");
        System.out.println(list1.size() + " " + list1);
        System.out.println(list2.size() + " " + list2);
        System.out.println(list2.getLast().equals("node3")?"PASSED":"**FAILED**");
        System.out.println(list2.size() + " " + list2);
      
        System.out.println("\nTesting add...");
        LinkedList<String> list3 = new LinkedList<String>();
        LinkedList<String> list4 = new LinkedList<String>();
        list3.add("node1"); list3.add("node2"); list3.add("node3");
        System.out.println("3-element list: " + list3);
        list4.add("node1"); list4.add("node2"); list4.add("node3"); list4.add("node4");
        System.out.println("4-element list: " + list4);
                
        System.out.println("\nTesting addAfter...");
        LinkedList<String> other = new LinkedList<String>();
        other.add("one");
        other.add("two");
        other.add("three");
        other.add("four");
        System.out.println(other.size() + " " + other);
        other.addAfter(2,"three.5");
        System.out.println((other.get(3).equals("three.5")?"PASSED":"**FAILED**"));
        System.out.println(other.size() + " " + other);
        
        System.out.println("\nTesting set...");
        LinkedList<String> test = new LinkedList<String>();
        System.out.println("  empty list test = " + ((test.set(2,"bad") == null)?"PASSED":"**FAILED**"));
        test.addFirst("Mark");
        test.addFirst("Sohaib");
        test.addFirst("Salman");
        System.out.println("  return value test = " + ((test.set(1,"Nora")).equals("Sohaib")?"PASSED":"**FAILED**"));
        System.out.println("  non-empty test = " + ((test.get(0).equals("Salman") && test.get(1).equals("Nora") &&
                           test.get(2).equals("Mark"))?"PASSED":"**FAILED**"));
        
        System.out.println("\nTesting lastIndex...");
        System.out.println((test.lastIndex("Salman")==0)?"PASSED":"**FAILED**");
        test.add("Mark");
        System.out.println((test.lastIndex("Mark")==3)?"PASSED":"**FAILED**");
        test.add("Beh");
        System.out.println((test.lastIndex("Beh")==4)?"PASSED":"**FAILED**");
      
        System.out.println("\nTesting clone...");
        LinkedList<String> empty = new LinkedList<String>();
        list1 = empty.clone();
        System.out.println("  empty list test = " + (list1.isEmpty()?"PASSED":"**FAILED**"));
        LinkedList<String> another = other.clone();
        System.out.println(another.size() + " " + another);
        System.out.println("  making sure nodes not shared...");
        other.remove("two");
        System.out.println(other.size() + " " + other);
        System.out.println(another.size() + " " + another);
        
        System.out.println("\nTesting removeAll...");
        //time for you to write some tests!
        System.out.println(test.size() + " " + test);
        test.removeAll("Beh");
        System.out.println(test.size() + " " + test);
        test.removeAll("Mark");
        System.out.println(test.size() + " " + test);
        test.removeAll("Jafar");
        System.out.println(test.size() + " " + test);
        
        System.out.println("\nTesting reverse...");
        LinkedList<String> list8 = new LinkedList<String>();
        list8.add("node1"); 
        list8.add("node2"); 
        list8.add("node3");
        list8.add("node4");
        list8.add("node5");
        list8.add("node6");
        list8.add("node7");
        list8.add("node8");
        list8.add("node9");
        list8.add("node10");
        LinkedList<String> list9 = new LinkedList<String>();
        list9.add("node10"); 
        list9.add("node9"); 
        list9.add("node8");
        list9.add("node7");
        list9.add("node6");
        list9.add("node5");
        list9.add("node4");
        list9.add("node3");
        list9.add("node2");
        list9.add("node1");
        System.out.println(list8.size() + " " + list8);
        System.out.println(list9.size() + " " + list9);
        System.out.println();
        
        list8.reverseList();
        System.out.println(list8.size() + " " + list8);
        System.out.println(list9.size() + " " + list9);
        System.out.println("Reverse " + (list9.equals(list8)?"PASSED":"**FAILED**")); 
	}
	
}