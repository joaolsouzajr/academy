package edu.coursera.concurrent;

import java.util.concurrent.atomic.AtomicReference;

import static edu.rice.pcdp.PCDP.finish;
import static edu.rice.pcdp.PCDP.async;
import static edu.rice.pcdp.PCDP.forall;

public class Question7 {

    public static void main(String[] args) {
        finish(() -> {
            AtomicReference r = new AtomicReference();
//            async ( () ->{
//                System.out.println(r.get());
//            });
            forall(0, 1000, (i) -> {
                r.compareAndSet(null, i);
            });
            async ( () ->{
                System.out.println(r.get());
            });
        });
    }

}
