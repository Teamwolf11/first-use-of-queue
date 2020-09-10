
package week12;

import java.util.*;

/** This is the app class for first in first out.
 *
 * Whihc is the opposite of a stack.

    @author Mike Cui
*/

public class QueueApp{

//    /** This is the constructor for the QueueApp.
//     * It is basically empty. not really used for anything.
//     * I can't remember why I made a default constructor.
//     */
//    public QueueApp(){
//
//    }//end constructor

    /** This is the main method will handle all stdin.
     * it can add,get,remove,get size, debug,print all
     * the stuff in the queue
     * @param args is the input of what to do
     */
    public static void main(String[] args){
        TwoStackQueue <String>queue= new TwoStackQueue<String>();
        Scanner scan = new Scanner(System.in); //stdin
        while(scan.hasNextLine()){
            String input=scan.nextLine();
            Scanner sc = new Scanner(input);
            String function=sc.next();
            switch(function){
                case "a"://add items a item,item,item,item
                    while(sc.hasNext()){
                        String item;
                        item =  sc.next();
                        queue.add(item);
                    }
                    break;
                case "c"://clear the queue
                    queue.clear();
                    break;
                case "d"://print result of debug
                    System.out.println(queue.debug());
                    break;
                case "g"://get and print the item at the front of the queue
                    if (queue.isEmpty()){
                        //do nothing
                    }else {
                        System.out.println(queue.get());
                    }
                    break;
                case "p":
                    // print out the result of calling
                    // the tostriung method for the queue
                    System.out.println(queue.toString());
                    break;
                case "r"://remove and print eh item from the front of the queue
                    if (queue.isEmpty()){
                        //do nothing
                    }else {
                        System.out.println(queue.remove());
                    }

                    break;

                case "s"://print out the size of the queue
                    System.out.println(queue.size());
                    break;
                default:
                    System.out.println("Not a valid input");
            }//end switch
        }//end while
    }//end main
}//end class queueapp

