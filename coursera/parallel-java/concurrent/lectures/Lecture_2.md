

Question 1
Consider the following example
algorithm, taken from the lecture video: 

    Thread 1 {
        MYBAL = MYBAL - 100
        FAMILY(W1) = FAMILY(R1) + 100
    }
    
    Thread 2 {
        FAMILY(W2) = FAMILY(R2) - 100
        DBAL = DBAL + 100
    }

We denote the read and write for FAMILY in thread 1 as R1 and W1, and the read
and write for FAMILY in thread 2 as R2 and W2. Which of the following is not a
possible ordering of reads and writes for the family’s account balance (FAMILY)?

C. R2, W1, R1, W2

Q2
Consider the following example
algorithm, taken from the lecture video:

    Thread 1 {
        MYBAL = MYBAL - 100
        FAMILY(W1) = FAMILY(R1) + 100
    }
    
    Thread 2 {
        FAMILY(W2) = FAMILY(R2) - 100
        DBAL = DBAL + 100
    }

The beginning balance of the FAMILY account is 1000. 
We denote the read and write for FAMILY in
thread 1 as R1 and W1, and the read and write for
FAMILY in thread 2 as R2
and W2. Which of the following is not a possible
value that the family account can end up with?

800

.
Question 3

Assume
we have the doubly-linked list shown below. Using object-based isolation, which
sets of object deletions can occur simultaneously? 

    A -> B -> C -> D -> E -> F

A. (A, D)
D. (B, E)

Question 4
Assume we are using the provided
bank transaction code. We have six accounts: A, B, C, D, E, F We make eight
transfers, all asynchronously:

1. $100 from A to B 1
2. $50 from B to C 2
3. $30 from B to C 3
4. $20 from B to A 4
5. $70 from D to A 2
6. $40 from B to D 5
7. $30 from E to D 1
8. $20 from D to F 3

Each
transaction requires one computation step worth of time, but multiple
transactions can run in parallel in the same computation step. Given enough
processors, what is the minimum number of computation steps needed to run these
eight transactions without causing a data race?

5

Q5
3

Q6
C. It depends on which vertex is selected to start the tree.

Q7
A.   
The string is null

Q8
B.    Any value between 0 and 1000.

Q9

B.	A and C, but not also B

C.	B and C, but not also A 
    
Q10
A.   
D and E, but not also F
