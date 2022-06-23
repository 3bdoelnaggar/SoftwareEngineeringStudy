package practice;

import java.util.HashMap;

public class JavaClass {


    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        HashMap<SinglyLinkedListNode,Integer> map=new HashMap<>();
        SinglyLinkedListNode currnt=head1;
        while(currnt!=null){
            map.put(currnt.getNext(),0);
            currnt=currnt.getNext();
        }

        SinglyLinkedListNode currnt2 = head2;
        while(currnt2.getNext()!=null){
            Integer node= map.get(currnt2);
            if(node!=null){
                return currnt2.getData();
            }else{
                currnt2=currnt2.getNext();
            }
        }

        return -1;




    }
}
