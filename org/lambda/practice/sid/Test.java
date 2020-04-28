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
            System.out.println(t.filterByColor(t.listOfApples, t.filterByColorp));
            System.out.println(t.filterByColorAndWeight(t.listOfApples, t.filterByColorAndWeightp));
            System.out.println(t.filterByColorAndPrice(t.listOfApples, t.filterByColorAndPricep));
            
            System.out.println(t.consumeRes(t.listOfApples, t.consumeAndChangeAndAdd));
            System.out.println(t.funcApplesLength(t.listOfApples, t.returnLen));
        
    }


    public List<Apples> filterByColor( List<Apples> smpl, Predicate<Apples> p ){
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
}