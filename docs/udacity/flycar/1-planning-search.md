

Q1 - What are the problems with using continuous curves to represent paths through free space (choose all that apply)?

* The number of possible curves is large and approaches infinity for a complex search space.
* Constraints on processing time and computational resources will limit the number of paths you can consider.
* In general, continuous curves are unnecessarily complex representations of the problem.

Q2 - What's the solution / alternative to using continuous curves in your representation of the planning problem?

* Discretize your search space

Q3 - Which of these things do you need in order to completely represent your planning problem (choose all that apply)?

* A state space
* Actions that define how the vehicle can move from state to state
* A start state and a goal state
* Costs associated with each possible action

Q4 - Complete the following sentence: "A partial plan is..."

* A plan that does not yet reach the goal, but that contains a list of states and actions moving away from the start state

A partial plan doesn't need to be a good plan, and doesn't reach the goal, but does constitute a valid list of states and actions the vehicle could take from the start state.



## Partial Plans Explained

Figuring out how many partial plans are possible given a particular search space can be confusing. Here we'll step through the logic of how you can arrive at an answer for the example above.

Given that you can't move off the grid, and you can't move diagonally, from the start location you have three options, up, down or right like this:

## Breadth vs Depth

**Breadth-First Search**

* Always expands shortest plan first
* Finds the shortest path to goal first
* Can be computationaly intensive


**Depth-Firts Search**


* expands last successful action
* requires a bit of luck
* can fail completely




