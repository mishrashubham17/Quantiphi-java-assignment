//Q1
import java.util.*;

public class Ran {

    public static void main(String[] args) {
        
        List<String> argList = Arrays.asList(args);
        Collections.shuffle(argList);
        argList.stream()
        .forEach(e->System.out.format("%s ",e));
        for (String arg: argList) {
            System.out.format("%s ", arg);
        }

        System.out.println();
    }
}

//Q2
import java.util.*;

public class FindDups {

    static final Comparator<String> IGNORE_CASE_ORDER
            = new Comparator<String>() {
        public int compare(String s1, String s2) {
            return s1.compareToIgnoreCase(s2);
        }
    };

    public static void main(String[] args) {
        
        SortedSet<String> s = new TreeSet<String>(IGNORE_CASE_ORDER);
        for (String a : args) {
            s.add(a);
        }
        System.out.println(s.size() + " distinct words: " + s);
    }
}
//Q3
import java.util.*;

public class ListTrim {
    static void listTrim(List<String> strings) {
        for (ListIterator<String> lit = strings.listIterator(); lit.hasNext(); ) {
            lit.set(lit.next().trim());
        }
    }

    public static void main(String[] args) {
        List<String> l = Arrays.asList(" red ", " white ", " blue ");
        listTrim(l);
        for (String s : l) {
            System.out.format("\"%s\"%n", s);
        }
    }
}
//Q4
//     1 Whimsical Toys Inc (WTI) needs to record the names of all its employees. Every month, an employee will be chosen at random from these records to receive a free toy.
//     Ans) use a list 

//     2) WTI has decided that each new product will be named after an employee — but only first names will be used, and each name will be used only once. Prepare a list of unique first names.
//     Ans) Use a Set.

//    3)WTI decides that it only wants to use the most popular names for its toys. Count up the number of employees who have each first name.
//     Ans) Use a Map

//     4)WTI acquires season tickets for the local lacrosse team, to be shared by employees. Create a waiting list for this popular sport.
//     Ans) Use a Queue.