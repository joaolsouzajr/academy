
# 1.1 Java Threads
**Lecture Summary**: In this lecture, we learned the concept of threads as 
lower-level building blocks for concurrent programs. 
A unique aspect of Java compared to prior mainstream programming languages is that 
Java included the notions of threads (as instances of the **java.lang.Thread** class) 
in its language definition right from the start.

When an instance of **Thread** is created (via a **new** operation), 
it does not start executing right away; instead, it can only 
start executing when its **start()** method is invoked. 
The statement or computation to be executed by the thread is 
specified as a parameter to the constructor.

The Thread class also includes a wait operation in the form of a **join()** method.
If thread **t0** performs a **t1.join()** call, thread **t0** will be forced 
to wait until thread **t1** completes, after which point it can safely access 
any values computed by thread **t1**. Since there is no restriction on which 
thread can perform a **join** on which other thread, it is possible for a 
programmer to erroneously create a deadlock cycle with **join** operations. 
(A deadlock occurs when two threads wait for each other indefinitely, so that neither can make any progress.)

**Further Reading**:

1. Wikipedia article on [Threads](https://en.wikipedia.org/wiki/Thread_(computing))
2. [Tutorial on Java threads](https://docs.oracle.com/javase/tutorial/essential/concurrency/runthread.html)
3. [Documentation on Thread class in Java 8](https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.html)


## 1.2 Structured Locks

**Lecture Summary:** In this lecture, we learned about structured locks, and how they can be implemented using synchronized\mathtt {synchronized}synchronized statements and methods in Java. Structured locks can be used to enforce mutual exclusion and avoid *data races*, as illustrated by the ``incr()`` method in the ``A.count`` example, and the ``insert()`` and ``remove()`` methods in the the **Buffer** example. A major benefit of structured locks is that their acquire and release operations are implicit, since these operations are automatically performed by the Java runtime environment when entering and exiting the scope of a **synchronized** statement or method, even if an exception is thrown in the middle.

We also learned about **wait()** and **notify()** operations that can be used to block and resume threads that need to wait for specific conditions. For example, a producer thread performing an **insert()** operation on a bounded buffer can call **wait()** when the buffer is full, so that it is only unblocked when a consumer thread performing a **remove()** operation calls **notify()**. Likewise, a consumer thread performing a **remove()** operation on a *bounded buffer* can call **wait()** when the buffer is empty, so that it is only unblocked when a producer thread performing an **insert()** operation calls **notify()**. Structured locks are also referred to as intrinsic locks or monitors.


## Optional Reading:

1. [Tutorial on Intrinsic Locks and Synchronization in Java](https://docs.oracle.com/javase/tutorial/essential/concurrency/locksync.html)
2. [Tutorial on Guarded Blocks in Java](https://docs.oracle.com/javase/tutorial/essential/concurrency/guardmeth.html)
3. Wikipedia article on [Monitors](https://docs.oracle.com/javase/tutorial/essential/concurrency/guardmeth.html)


## 1.3 Unstructured Locks

Lecture Summary: In this lecture, we introduced unstructured locks (which can be obtained in Java by creating instances of **ReentrantLock()**, and used three examples to demonstrate their generality relative to structured locks. The first example showed how explicit **lock()** and **unlock()** operations on unstructured locks can be used to support a hand-over-hand locking pattern that implements a non-nested pairing of lock/unlock operations which cannot be achieved with synchronized statements/methods. The second example showed how the **tryLock()** operations in unstructured locks can enable a thread to check the availability of a lock, and thereby acquire it if it is available or do something else if it is not. The third example illustrated the value of read-write locks (which can be obtained in Java by creating instances of **ReentrantReadWriteLock()**, whereby multiple threads are permitted to acquire a lock *L* in “read mode”, **L.readLock().lock()**, but only one thread is permitted to acquire the lock in “write mode”, **L.writeLock().lock()**.

However, it is also important to remember that the generality and power of unstructured locks is accompanied by an extra responsibility on the part of the programmer, e.g., ensuring that calls to **unlock()** are not forgotten, even in the presence of exceptions.

## Optional Reading:

1. [Tutorial on Lock Objects in Java](https://docs.oracle.com/javase/tutorial/essential/concurrency/newlocks.html)
2. [Documentation on Java’s Lock interfaces](http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/locks/Lock.html)

## 1.4 Liveness

Deadlock
Livelock
