# SixDegreeOfSeparation


Six Degree of Separation:

The following program has been based on the famous problem of
Six degrees of separation. The idea that claims that all people on average are six, or fewer, social connections away from each other.
Also known as the 6 Handshakes rule. As a result, a chain of "a friend of a friend" statements can be made to connect any two people in a maximum of six steps.

Firstly, we are going to build the graph. I found it convenient to represent my graph with adjency list, menanig each node in the graph, represented here as "Actor" will have an overview of the Actors, She/He had played at the same movie. The data used to construct the
graph comes from this date base -> [[http://imdb.com/].

Our first task goes mainly to find how far two actors are connected throughout the movies they have played at.
The idea behid this exercise, goes mainly in putting on practice the knowledge acquired of the various algorithms, learned for graphs. In this particular case, the algorithm I have chosen to solve the problem, is known as Breath-Depth-Search, a very popular algorithm to traverse graphs. 

As mentioned above I am mainly interested on findinig the minnimun steps to the target. 
We know there are two differnt algorithms that traverses the graph. These two are: DFS and BFS. After evaluating what we want to achive, we recognise BFS is a more suitable algorithm to solve the problem. Therefore we go for the implementation of BFS. 
Which indeed gives a time complexity of O(|V|+|E|).


For the second task. we want to implement the famous dijkstra algorithm, which is used to find the shorthest path between two nodes.
