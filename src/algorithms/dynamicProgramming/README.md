Dynamic Programming
- Memoization: caching the call to function to skip executing it again and return the cached value
- Tabulation

Memoization Recipe
- make it work
    - visualize the problem as tree
    - implement the tree using recursion
    - test it
- make it efficient
    - add memo object
    - add a base case to return memo values
    - store return values into memo