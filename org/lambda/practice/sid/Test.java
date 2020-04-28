package org.lambda.practice.sid;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Test {
    List<Apples> consumedResult = new ArrayList<>();
    List<Apples> listOfApples = Arrays.asList(
        new Apples("Red", 1, 12),
        new Apples("Red", 2, 13),
        new Apples("Blue", 1, 10),
        new Apples("Blue", 2, 111)
    );
    public static void main(String[] args){
        Test t = new Test();
           
            System.out.println(t.listOfApples);
            System.out.println(t.filterByColos(t.listOfApples, t.filterByColorp));
            System.out.println(t.filterByColorAndWeight(t.listOfApples, t.filterByColorAndWeightp));
            System.out.println(t.filterByColorAndPrice(t.listOfApples, t.filterByColorAndPricep));
            
            System.out.println(t.consumeRes(t.listOfApples, t.consumeAndChangeAndAdd));
            System.out.println(t.funcApplesLength(t.listOfApples, t.returnLen));
        
    }


    public List<Apples> filterByColos( List<Apples> smpl, Predicate<Apples> p ){
        List<Apples> res = new ArrayList<>();
        for (Apples ap : smpl) {
            if(p.test(ap)){
                res.add(ap);
            }
        }
        return res;
    }

    public List<Apples> filterByColorAndWeight(List<Apples> smpl,Predicate<Apples> p){
        List<Apples> res = new ArrayList<>();
        for (Apples ap : smpl) {
            if(p.test(ap)){
                res.add(ap);
            }
        }        
        return res;
    }

    public List<Apples> filterByColorAndPrice(List<Apples> smpl, Predicate<Apples> p){
        List<Apples> res = new ArrayList<>();
        for (Apples ap : smpl) {
            if(p.test(ap)){
                res.add(ap);
            }
        }
        return res;
    }

    public List<Apples> consumeRes(List<Apples> smpl,  Consumer<Apples> c){
       
        for (Apples ap : smpl) {
            c.accept(ap);
        }
        return consumedResult;
    }

    public List<Integer> funcApplesLength(List<Apples> smpl,  Function<Apples, Integer> f){
        List<Integer> res = new ArrayList<>();
        for (Apples ap : smpl) {
            res.add(f.apply(ap));
        }
        return res;
    }


    Predicate<Apples> filterByColorp = (a) -> a.getColor() == "Red" ;
    Predicate<Apples> filterByColorAndWeightp = (a) -> a.getColor() == "Red" && a.getWeight() > 11;
    Predicate<Apples> filterByColorAndPricep =(a) -> a.getColor() == "Blue" && a.getPrice() > 1;


    Consumer<Apples> consumeAndChangeAndAdd = (a) -> {
        a.setPrice(13); this.consumedResult.add(a);
    };

    Function<Apples, Integer> returnLen = (a) -> {return a.getColor().length();};


    /**
     *  All the lambda expressions we’ve shown so far used only their arguments inside their
        body. But lambda expressions are also allowed to use free variables (variables that aren’t
        the parameters and are defined in an outer scope) like anonymous classes can.
        They’re called capturing lambdas. For example, the following lambda captures the vari-
        able portNumber:
        int portNumber = 1337;
        Runnable r = () -> System.out.println(portNumber);

        Nonetheless, there’s a small twist. There are some restrictions on what you can do with
        these variables. Lambdas are allowed to capture (to reference in their bodies)
        instance variables and static variables without restrictions. But when local variables are
        captured, they have to be explicitly declared final or be effectively final . Lambda
        expressions can capture local variables that are assigned to only once. (Note: captur-
        ing an instance variable can be seen as capturing the final local variable this.)

        Instance variables are stored on the heap, whereas local variables live on the
        stack. If a lambda could access the local variable directly and the lambda was used in a
        thread, then the thread using the lambda could try to access the variable after the
        thread that allocated the variable had deallocated it. Hence, Java implements access to
        a free local variable as access to a copy of it, rather than access to the original variable.
        This makes no difference if the local variable is assigned to only once—hence the
        restriction.

     */
}
