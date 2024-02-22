//import java.util.*;

public class ListTest
{
    public static void main(String[] args)
    {
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

        list8.reverseList();
        System.out.println(list8.size() + " " + list8);
        System.out.println(list9.size() + " " + list9);
        System.out.println("Reverse " + (list9.equals(list8)?"PASSED":"**FAILED**"));

    

    }
}
