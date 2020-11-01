# SixDegreeOfSeparation


Six Degree of Separation:

The followed program has been based on the famous
Six degrees of separation idea that claims that all people on average are six, or fewer, social connections away from each other.
Also known as the 6 Handshakes rule. As a result, a chain of "a friend of a friend" statements can be made to connect any two people in a maximum of six steps.

Firstly, we are going to build the graph, where we will be implementing our algorithms, to simulate the theory of six dregee separation. The data used to construct the
graph comes from this date base -> [[http://imdb.com/].

First, task goes mainly to find how far two actors are connected, throughout the movies they have played.
The idea behid this exercise, goes mainly in putting on practice the knowledge acquired of the various algorithms, learned for graphs.

For the first task we are interested in findin the closesth path from one actor to another actor throughout the movies they both have played at.
We know that there might be two differnt algorithms, that can traverse the graph, these two are: DFS and BFS. We go for the implementation of BFS. Which indeed gives 
a time complexity of O(|V|+|E|).


For the second task. we want to implement the famous dijkstra algorithm, which is used to find the shorthest path between two nodes.
