# Deux-Priority-Queues

Two funky ways to implement priority queues

First one doesn't have explicit links: 
I implemented this with an array, supporting these operations:

a) Insert(Insert), delete the maximum(deleteMax), and delete the minimum(deleteMin). 

b) Find the maximum(findMax) and find the minimum(findMin). Both are in constant time.

c) Resize

The second one has explicit links:
Implemented using a heap-ordered binary tree, using a triply linked structure instead of an array. 

There are three links per node: two to traverse down the tree and one to traverse up the tree. 

Both PQ's are optimized! :)
