# SoftwareCA2

---

| Question        | Answer           | 
| ------------- |-------------| 
| Name and/or student ID     | Ronan Farrell / L00170333 | 
| List of known bugs and/or omissions  | No bugs, everything completed.   | 
| Link to github repo (optional) | https://github.com/ronanj2/SoftwareCA2/      |
| Any other info that you might deem important. | Excellent test coverage, everything working, infix calculator handles double operands e.g. (2*-1) | 

---

###  Assessment Overview
Data structures and algorithms.

### Sources
The source code files can be found here: https://github.com/ronanj2/SoftwareCA2/tree/main/src/main/java/com/student/l00170333
and the tests can be found here: https://github.com/ronanj2/SoftwareCA2/tree/main/src/test/java/com/student/l00170333

---

### Test Coverage
We have excellent test coverage with all classes and methods covered.  
<img src="https://user-images.githubusercontent.com/74976200/145305197-a27717c9-d665-44f7-a94d-f241e8e8a4e3.png" width="500">  
<sub>Figure 1 - Test Coverage </sub>

A test coverage report can be found in the out directory here: https://github.com/ronanj2/SoftwareCA2/tree/main/out/coverage - This report can be opened in a browser and will provide coloured overlay showing the classes/methods/lines covered.

---
### JavaDoc
JavaDoc has been generated and pushed to the /docs directory. 
After cloning this repo, you can view docs by browsing to the index file located here: https://github.com/ronanj2/SoftwareCA2/tree/main/docs

---

### Requirement 5_2: Analysis of rotate() methods
In order to measure the performance of the different arrays, I created two java files here: https://github.com/ronanj2/SoftwareCA2/tree/main/src/main/java/com/student/l00170333/rotateAnalysis

I then created lists with 5000 elements and rotated them a distance of 10 through the different rotate methods. To improve the accuracy of the results, and to negate any 'once off' fluctations, I repeated each test 50 times. The average timings for each method is shown in the table below. In general, the GenericArrayList performs much better than our GenericLinkedList. The rotate2 methods vastly outperform GenericCollections.rotate.


| IList | No. elements | Add | Rotate Distance | IList.rotate() | GenericCollections.rotate() | GenericCollections.rotate2() | 
| --- | --- | --- | --- | --- | --- | --- | 
| GenericArrayList | 5000 | 263??s | 10 | 202??s | 6166??s | 105??s | 
| GenericLinkedList | 5000 | 445??s | 10 | 270??s | 105137??s | 44??s |   

<sub>The above table shows the summarized output for all executions. The full console output is shown below.</sub>

It is important to point out here that the performance of the GenericArrayList can be tuned significantly by increasing the starting size of the buffer. When the buffer does not need to be resized, the GenericArrayList will have faster adds. It was left small in the example code to make testing easier - but this requires growth to happen more often, and from a smaller base.

When it comes to Big O here are some of the more common time complexity possibilities:
1. O(1): Executes in the same time regardless of the size of the input
1. O(n): Executes linearly and proportionally to the size of the input
1. O(n??): Performance is directly proportional to the square of the size of the input (ex: nested iterations, loops)

We must note here that big-O complexity describes asymptotic behaviour and may not reflect actual implementation speed. It describes how the cost of each operation grows with the size of the list, not the speed of each operation.


#### Comparing GenericArrayList & GenericLinkedList

|  | GenericArrayList | GenericLinkedList | 
| --- | --- | --- | 
| Accessing Elements | O(1) | O(n) | 
| Insert/Remove from beginning | O(n) | O(1) | 
| Insert/Remove from end | O(1) | O(n) | 
| Insert/Remove from middle | O(n) | O(n) | 

In GenericArrayList accessing an element takes constant time O(1) and adding an element takes O(n) time [worst case]* (As said previously the worst can be mitigated by using a suitable initial buffer size). In GenericLinkedList adding an element takes O(n) time and accessing also takes O(n) time but GenericLinkedList uses more memory than ArrayList.

In GenericLinkedList, it allows for constant-time insertions or removals using iterators, but only sequential access of elements. In other words, we can walk the list forwards or backwards, but finding a position in the list takes time proportional to the size of the list. During rotate we remove elements from the end O(n) and add to the beginning O(1).

From our analysis, (and especially when tweaking the initial buffer size), our GenericArrayList outperformed the GenericLinkedList, particularly over larger data sets and greater rotation distances.

Here is the full output of the comparison.
```console

**addElementsToArray comparisons**
GenericArrayList:addElementsToArray() - run 1 - time taken: 800 ??s.  
GenericArrayList:addElementsToArray() - run 2 - time taken: 483 ??s.  
GenericArrayList:addElementsToArray() - run 3 - time taken: 427 ??s.  
GenericArrayList:addElementsToArray() - run 4 - time taken: 391 ??s.  
GenericArrayList:addElementsToArray() - run 5 - time taken: 414 ??s.  
GenericArrayList:addElementsToArray() - run 6 - time taken: 524 ??s.  
GenericArrayList:addElementsToArray() - run 7 - time taken: 472 ??s.  
GenericArrayList:addElementsToArray() - run 8 - time taken: 443 ??s.  
GenericArrayList:addElementsToArray() - run 9 - time taken: 626 ??s.  
GenericArrayList:addElementsToArray() - run 10 - time taken: 466 ??s.  
GenericArrayList:addElementsToArray() - run 11 - time taken: 401 ??s.  
GenericArrayList:addElementsToArray() - run 12 - time taken: 406 ??s.  
GenericArrayList:addElementsToArray() - run 13 - time taken: 387 ??s.  
GenericArrayList:addElementsToArray() - run 14 - time taken: 317 ??s.  
GenericArrayList:addElementsToArray() - run 15 - time taken: 192 ??s.  
GenericArrayList:addElementsToArray() - run 16 - time taken: 252 ??s.  
GenericArrayList:addElementsToArray() - run 17 - time taken: 189 ??s.  
GenericArrayList:addElementsToArray() - run 18 - time taken: 218 ??s.  
GenericArrayList:addElementsToArray() - run 19 - time taken: 222 ??s.  
GenericArrayList:addElementsToArray() - run 20 - time taken: 211 ??s.  
GenericArrayList:addElementsToArray() - run 21 - time taken: 269 ??s.  
GenericArrayList:addElementsToArray() - run 22 - time taken: 279 ??s.  
GenericArrayList:addElementsToArray() - run 23 - time taken: 184 ??s.  
GenericArrayList:addElementsToArray() - run 24 - time taken: 192 ??s.  
GenericArrayList:addElementsToArray() - run 25 - time taken: 168 ??s.  
GenericArrayList:addElementsToArray() - run 26 - time taken: 176 ??s.  
GenericArrayList:addElementsToArray() - run 27 - time taken: 156 ??s.  
GenericArrayList:addElementsToArray() - run 28 - time taken: 129 ??s.  
GenericArrayList:addElementsToArray() - run 29 - time taken: 138 ??s.  
GenericArrayList:addElementsToArray() - run 30 - time taken: 161 ??s.  
GenericArrayList:addElementsToArray() - run 31 - time taken: 178 ??s.  
GenericArrayList:addElementsToArray() - run 32 - time taken: 149 ??s.  
GenericArrayList:addElementsToArray() - run 33 - time taken: 162 ??s.  
GenericArrayList:addElementsToArray() - run 34 - time taken: 195 ??s.  
GenericArrayList:addElementsToArray() - run 35 - time taken: 200 ??s.  
GenericArrayList:addElementsToArray() - run 36 - time taken: 201 ??s.  
GenericArrayList:addElementsToArray() - run 37 - time taken: 150 ??s.  
GenericArrayList:addElementsToArray() - run 38 - time taken: 172 ??s.  
GenericArrayList:addElementsToArray() - run 39 - time taken: 194 ??s.  
GenericArrayList:addElementsToArray() - run 40 - time taken: 164 ??s.  
GenericArrayList:addElementsToArray() - run 41 - time taken: 190 ??s.  
GenericArrayList:addElementsToArray() - run 42 - time taken: 158 ??s.  
GenericArrayList:addElementsToArray() - run 43 - time taken: 179 ??s.  
GenericArrayList:addElementsToArray() - run 44 - time taken: 174 ??s.  
GenericArrayList:addElementsToArray() - run 45 - time taken: 122 ??s.  
GenericArrayList:addElementsToArray() - run 46 - time taken: 164 ??s.  
GenericArrayList:addElementsToArray() - run 47 - time taken: 156 ??s.  
GenericArrayList:addElementsToArray() - run 48 - time taken: 303 ??s.  
GenericArrayList:addElementsToArray() - run 49 - time taken: 138 ??s.  
GenericArrayList:addElementsToArray() - run 50 - time taken: 139 ??s.  
GenericArrayList:addElementsToArray() - average: 263??s


LinkedList:addElementsToArray()  - run 1 - time taken: 2465 ??s.  
LinkedList:addElementsToArray()  - run 2 - time taken: 482 ??s.  
LinkedList:addElementsToArray()  - run 3 - time taken: 346 ??s.  
LinkedList:addElementsToArray()  - run 4 - time taken: 346 ??s.  
LinkedList:addElementsToArray()  - run 5 - time taken: 354 ??s.  
LinkedList:addElementsToArray()  - run 6 - time taken: 438 ??s.  
LinkedList:addElementsToArray()  - run 7 - time taken: 401 ??s.  
LinkedList:addElementsToArray()  - run 8 - time taken: 377 ??s.  
LinkedList:addElementsToArray()  - run 9 - time taken: 415 ??s.  
LinkedList:addElementsToArray()  - run 10 - time taken: 356 ??s.  
LinkedList:addElementsToArray()  - run 11 - time taken: 546 ??s.  
LinkedList:addElementsToArray()  - run 12 - time taken: 426 ??s.  
LinkedList:addElementsToArray()  - run 13 - time taken: 483 ??s.  
LinkedList:addElementsToArray()  - run 14 - time taken: 451 ??s.  
LinkedList:addElementsToArray()  - run 15 - time taken: 423 ??s.  
LinkedList:addElementsToArray()  - run 16 - time taken: 440 ??s.  
LinkedList:addElementsToArray()  - run 17 - time taken: 490 ??s.  
LinkedList:addElementsToArray()  - run 18 - time taken: 503 ??s.  
LinkedList:addElementsToArray()  - run 19 - time taken: 445 ??s.  
LinkedList:addElementsToArray()  - run 20 - time taken: 445 ??s.  
LinkedList:addElementsToArray()  - run 21 - time taken: 431 ??s.  
LinkedList:addElementsToArray()  - run 22 - time taken: 486 ??s.  
LinkedList:addElementsToArray()  - run 23 - time taken: 459 ??s.  
LinkedList:addElementsToArray()  - run 24 - time taken: 357 ??s.  
LinkedList:addElementsToArray()  - run 25 - time taken: 422 ??s.  
LinkedList:addElementsToArray()  - run 26 - time taken: 415 ??s.  
LinkedList:addElementsToArray()  - run 27 - time taken: 396 ??s.  
LinkedList:addElementsToArray()  - run 28 - time taken: 392 ??s.  
LinkedList:addElementsToArray()  - run 29 - time taken: 423 ??s.  
LinkedList:addElementsToArray()  - run 30 - time taken: 341 ??s.  
LinkedList:addElementsToArray()  - run 31 - time taken: 310 ??s.  
LinkedList:addElementsToArray()  - run 32 - time taken: 403 ??s.  
LinkedList:addElementsToArray()  - run 33 - time taken: 535 ??s.  
LinkedList:addElementsToArray()  - run 34 - time taken: 438 ??s.  
LinkedList:addElementsToArray()  - run 35 - time taken: 1460 ??s.  
LinkedList:addElementsToArray()  - run 36 - time taken: 557 ??s.  
LinkedList:addElementsToArray()  - run 37 - time taken: 442 ??s.  
LinkedList:addElementsToArray()  - run 38 - time taken: 491 ??s.  
LinkedList:addElementsToArray()  - run 39 - time taken: 247 ??s.  
LinkedList:addElementsToArray()  - run 40 - time taken: 211 ??s.  
LinkedList:addElementsToArray()  - run 41 - time taken: 216 ??s.  
LinkedList:addElementsToArray()  - run 42 - time taken: 287 ??s.  
LinkedList:addElementsToArray()  - run 43 - time taken: 284 ??s.  
LinkedList:addElementsToArray()  - run 44 - time taken: 213 ??s.  
LinkedList:addElementsToArray()  - run 45 - time taken: 250 ??s.  
LinkedList:addElementsToArray()  - run 46 - time taken: 251 ??s.  
LinkedList:addElementsToArray()  - run 47 - time taken: 246 ??s.  
LinkedList:addElementsToArray()  - run 48 - time taken: 223 ??s.  
LinkedList:addElementsToArray()  - run 49 - time taken: 212 ??s.  
LinkedList:addElementsToArray()  - run 50 - time taken: 229 ??s.  
LinkedList:addElementsToArray() - average: 445 ??s

**rotate comparisons**
GenericArrayList:rotate(10)  - run 1 - time taken: 684 ??s.  
GenericArrayList:rotate(10)  - run 2 - time taken: 617 ??s.  
GenericArrayList:rotate(10)  - run 3 - time taken: 527 ??s.  
GenericArrayList:rotate(10)  - run 4 - time taken: 307 ??s.  
GenericArrayList:rotate(10)  - run 5 - time taken: 191 ??s.  
GenericArrayList:rotate(10)  - run 6 - time taken: 165 ??s.  
GenericArrayList:rotate(10)  - run 7 - time taken: 168 ??s.  
GenericArrayList:rotate(10)  - run 8 - time taken: 181 ??s.  
GenericArrayList:rotate(10)  - run 9 - time taken: 170 ??s.  
GenericArrayList:rotate(10)  - run 10 - time taken: 165 ??s.  
GenericArrayList:rotate(10)  - run 11 - time taken: 165 ??s.  
GenericArrayList:rotate(10)  - run 12 - time taken: 196 ??s.  
GenericArrayList:rotate(10)  - run 13 - time taken: 183 ??s.  
GenericArrayList:rotate(10)  - run 14 - time taken: 190 ??s.  
GenericArrayList:rotate(10)  - run 15 - time taken: 183 ??s.  
GenericArrayList:rotate(10)  - run 16 - time taken: 154 ??s.  
GenericArrayList:rotate(10)  - run 17 - time taken: 160 ??s.  
GenericArrayList:rotate(10)  - run 18 - time taken: 154 ??s.  
GenericArrayList:rotate(10)  - run 19 - time taken: 164 ??s.  
GenericArrayList:rotate(10)  - run 20 - time taken: 160 ??s.  
GenericArrayList:rotate(10)  - run 21 - time taken: 253 ??s.  
GenericArrayList:rotate(10)  - run 22 - time taken: 166 ??s.  
GenericArrayList:rotate(10)  - run 23 - time taken: 177 ??s.  
GenericArrayList:rotate(10)  - run 24 - time taken: 159 ??s.  
GenericArrayList:rotate(10)  - run 25 - time taken: 164 ??s.  
GenericArrayList:rotate(10)  - run 26 - time taken: 167 ??s.  
GenericArrayList:rotate(10)  - run 27 - time taken: 162 ??s.  
GenericArrayList:rotate(10)  - run 28 - time taken: 174 ??s.  
GenericArrayList:rotate(10)  - run 29 - time taken: 155 ??s.  
GenericArrayList:rotate(10)  - run 30 - time taken: 158 ??s.  
GenericArrayList:rotate(10)  - run 31 - time taken: 155 ??s.  
GenericArrayList:rotate(10)  - run 32 - time taken: 156 ??s.  
GenericArrayList:rotate(10)  - run 33 - time taken: 158 ??s.  
GenericArrayList:rotate(10)  - run 34 - time taken: 215 ??s.  
GenericArrayList:rotate(10)  - run 35 - time taken: 161 ??s.  
GenericArrayList:rotate(10)  - run 36 - time taken: 177 ??s.  
GenericArrayList:rotate(10)  - run 37 - time taken: 167 ??s.  
GenericArrayList:rotate(10)  - run 38 - time taken: 167 ??s.  
GenericArrayList:rotate(10)  - run 39 - time taken: 192 ??s.  
GenericArrayList:rotate(10)  - run 40 - time taken: 165 ??s.  
GenericArrayList:rotate(10)  - run 41 - time taken: 180 ??s.  
GenericArrayList:rotate(10)  - run 42 - time taken: 186 ??s.  
GenericArrayList:rotate(10)  - run 43 - time taken: 201 ??s.  
GenericArrayList:rotate(10)  - run 44 - time taken: 175 ??s.  
GenericArrayList:rotate(10)  - run 45 - time taken: 179 ??s.  
GenericArrayList:rotate(10)  - run 46 - time taken: 158 ??s.  
GenericArrayList:rotate(10)  - run 47 - time taken: 175 ??s.  
GenericArrayList:rotate(10)  - run 48 - time taken: 187 ??s.  
GenericArrayList:rotate(10)  - run 49 - time taken: 179 ??s.  
GenericArrayList:rotate(10)  - run 50 - time taken: 163 ??s.  
GenericArrayList:rotate(10) - average: 202 ??s.  


GenericLinkedList:rotate(10)  - run 1 - time taken: 860 ??s.  
GenericLinkedList:rotate(10)  - run 2 - time taken: 272 ??s.  
GenericLinkedList:rotate(10)  - run 3 - time taken: 230 ??s.  
GenericLinkedList:rotate(10)  - run 4 - time taken: 223 ??s.  
GenericLinkedList:rotate(10)  - run 5 - time taken: 219 ??s.  
GenericLinkedList:rotate(10)  - run 6 - time taken: 218 ??s.  
GenericLinkedList:rotate(10)  - run 7 - time taken: 218 ??s.  
GenericLinkedList:rotate(10)  - run 8 - time taken: 220 ??s.  
GenericLinkedList:rotate(10)  - run 9 - time taken: 764 ??s.  
GenericLinkedList:rotate(10)  - run 10 - time taken: 462 ??s.  
GenericLinkedList:rotate(10)  - run 11 - time taken: 3029 ??s.  
GenericLinkedList:rotate(10)  - run 12 - time taken: 187 ??s.  
GenericLinkedList:rotate(10)  - run 13 - time taken: 180 ??s.  
GenericLinkedList:rotate(10)  - run 14 - time taken: 182 ??s.  
GenericLinkedList:rotate(10)  - run 15 - time taken: 178 ??s.  
GenericLinkedList:rotate(10)  - run 16 - time taken: 178 ??s.  
GenericLinkedList:rotate(10)  - run 17 - time taken: 180 ??s.  
GenericLinkedList:rotate(10)  - run 18 - time taken: 178 ??s.  
GenericLinkedList:rotate(10)  - run 19 - time taken: 178 ??s.  
GenericLinkedList:rotate(10)  - run 20 - time taken: 178 ??s.  
GenericLinkedList:rotate(10)  - run 21 - time taken: 167 ??s.  
GenericLinkedList:rotate(10)  - run 22 - time taken: 183 ??s.  
GenericLinkedList:rotate(10)  - run 23 - time taken: 166 ??s.  
GenericLinkedList:rotate(10)  - run 24 - time taken: 164 ??s.  
GenericLinkedList:rotate(10)  - run 25 - time taken: 164 ??s.  
GenericLinkedList:rotate(10)  - run 26 - time taken: 177 ??s.  
GenericLinkedList:rotate(10)  - run 27 - time taken: 188 ??s.  
GenericLinkedList:rotate(10)  - run 28 - time taken: 183 ??s.  
GenericLinkedList:rotate(10)  - run 29 - time taken: 187 ??s.  
GenericLinkedList:rotate(10)  - run 30 - time taken: 166 ??s.  
GenericLinkedList:rotate(10)  - run 31 - time taken: 166 ??s.  
GenericLinkedList:rotate(10)  - run 32 - time taken: 171 ??s.  
GenericLinkedList:rotate(10)  - run 33 - time taken: 174 ??s.  
GenericLinkedList:rotate(10)  - run 34 - time taken: 184 ??s.  
GenericLinkedList:rotate(10)  - run 35 - time taken: 172 ??s.  
GenericLinkedList:rotate(10)  - run 36 - time taken: 168 ??s.  
GenericLinkedList:rotate(10)  - run 37 - time taken: 191 ??s.  
GenericLinkedList:rotate(10)  - run 38 - time taken: 182 ??s.  
GenericLinkedList:rotate(10)  - run 39 - time taken: 173 ??s.  
GenericLinkedList:rotate(10)  - run 40 - time taken: 167 ??s.  
GenericLinkedList:rotate(10)  - run 41 - time taken: 167 ??s.  
GenericLinkedList:rotate(10)  - run 42 - time taken: 169 ??s.  
GenericLinkedList:rotate(10)  - run 43 - time taken: 168 ??s.  
GenericLinkedList:rotate(10)  - run 44 - time taken: 169 ??s.  
GenericLinkedList:rotate(10)  - run 45 - time taken: 189 ??s.  
GenericLinkedList:rotate(10)  - run 46 - time taken: 167 ??s.  
GenericLinkedList:rotate(10)  - run 47 - time taken: 168 ??s.  
GenericLinkedList:rotate(10)  - run 48 - time taken: 170 ??s.  
GenericLinkedList:rotate(10)  - run 49 - time taken: 167 ??s.  
GenericLinkedList:rotate(10)  - run 50 - time taken: 167 ??s.  
GenericLinkedList:rotate(10) - average: 270 ??s.  

**collection rotate**
GenericArrayList:rotateCollection(10)  - run 1 - time taken: 14484 ??s.  
GenericArrayList:rotateCollection(10)  - run 2 - time taken: 6274 ??s.  
GenericArrayList:rotateCollection(10)  - run 3 - time taken: 6100 ??s.  
GenericArrayList:rotateCollection(10)  - run 4 - time taken: 6106 ??s.  
GenericArrayList:rotateCollection(10)  - run 5 - time taken: 5831 ??s.  
GenericArrayList:rotateCollection(10)  - run 6 - time taken: 5719 ??s.  
GenericArrayList:rotateCollection(10)  - run 7 - time taken: 5703 ??s.  
GenericArrayList:rotateCollection(10)  - run 8 - time taken: 5552 ??s.  
GenericArrayList:rotateCollection(10)  - run 9 - time taken: 6220 ??s.  
GenericArrayList:rotateCollection(10)  - run 10 - time taken: 5782 ??s.  
GenericArrayList:rotateCollection(10)  - run 11 - time taken: 5598 ??s.  
GenericArrayList:rotateCollection(10)  - run 12 - time taken: 5801 ??s.  
GenericArrayList:rotateCollection(10)  - run 13 - time taken: 5773 ??s.  
GenericArrayList:rotateCollection(10)  - run 14 - time taken: 6110 ??s.  
GenericArrayList:rotateCollection(10)  - run 15 - time taken: 6326 ??s.  
GenericArrayList:rotateCollection(10)  - run 16 - time taken: 5936 ??s.  
GenericArrayList:rotateCollection(10)  - run 17 - time taken: 5794 ??s.  
GenericArrayList:rotateCollection(10)  - run 18 - time taken: 5816 ??s.  
GenericArrayList:rotateCollection(10)  - run 19 - time taken: 5600 ??s.  
GenericArrayList:rotateCollection(10)  - run 20 - time taken: 5938 ??s.  
GenericArrayList:rotateCollection(10)  - run 21 - time taken: 5612 ??s.  
GenericArrayList:rotateCollection(10)  - run 22 - time taken: 5837 ??s.  
GenericArrayList:rotateCollection(10)  - run 23 - time taken: 8463 ??s.  
GenericArrayList:rotateCollection(10)  - run 24 - time taken: 8764 ??s.  
GenericArrayList:rotateCollection(10)  - run 25 - time taken: 6123 ??s.  
GenericArrayList:rotateCollection(10)  - run 26 - time taken: 5533 ??s.  
GenericArrayList:rotateCollection(10)  - run 27 - time taken: 6591 ??s.  
GenericArrayList:rotateCollection(10)  - run 28 - time taken: 5854 ??s.  
GenericArrayList:rotateCollection(10)  - run 29 - time taken: 6176 ??s.  
GenericArrayList:rotateCollection(10)  - run 30 - time taken: 5797 ??s.  
GenericArrayList:rotateCollection(10)  - run 31 - time taken: 5913 ??s.  
GenericArrayList:rotateCollection(10)  - run 32 - time taken: 5922 ??s.  
GenericArrayList:rotateCollection(10)  - run 33 - time taken: 5980 ??s.  
GenericArrayList:rotateCollection(10)  - run 34 - time taken: 5826 ??s.  
GenericArrayList:rotateCollection(10)  - run 35 - time taken: 5681 ??s.  
GenericArrayList:rotateCollection(10)  - run 36 - time taken: 5597 ??s.  
GenericArrayList:rotateCollection(10)  - run 37 - time taken: 5776 ??s.  
GenericArrayList:rotateCollection(10)  - run 38 - time taken: 5662 ??s.  
GenericArrayList:rotateCollection(10)  - run 39 - time taken: 5689 ??s.  
GenericArrayList:rotateCollection(10)  - run 40 - time taken: 6166 ??s.  
GenericArrayList:rotateCollection(10)  - run 41 - time taken: 6422 ??s.  
GenericArrayList:rotateCollection(10)  - run 42 - time taken: 5945 ??s.  
GenericArrayList:rotateCollection(10)  - run 43 - time taken: 7164 ??s.  
GenericArrayList:rotateCollection(10)  - run 44 - time taken: 5682 ??s.  
GenericArrayList:rotateCollection(10)  - run 45 - time taken: 5772 ??s.  
GenericArrayList:rotateCollection(10)  - run 46 - time taken: 5424 ??s.  
GenericArrayList:rotateCollection(10)  - run 47 - time taken: 5416 ??s.  
GenericArrayList:rotateCollection(10)  - run 48 - time taken: 5924 ??s.  
GenericArrayList:rotateCollection(10)  - run 49 - time taken: 5653 ??s.  
GenericArrayList:rotateCollection(10)  - run 50 - time taken: 5492 ??s.  
GenericArrayList:rotateCollection(10) - average: 6166 ??s.  


GenericLinkedList:rotateCollection(10)  - run 1 - time taken: 124721 ??s.  
GenericLinkedList:rotateCollection(10)  - run 2 - time taken: 115424 ??s.  
GenericLinkedList:rotateCollection(10)  - run 3 - time taken: 110583 ??s.  
GenericLinkedList:rotateCollection(10)  - run 4 - time taken: 107406 ??s.  
GenericLinkedList:rotateCollection(10)  - run 5 - time taken: 108726 ??s.  
GenericLinkedList:rotateCollection(10)  - run 6 - time taken: 107707 ??s.  
GenericLinkedList:rotateCollection(10)  - run 7 - time taken: 102804 ??s.  
GenericLinkedList:rotateCollection(10)  - run 8 - time taken: 102972 ??s.  
GenericLinkedList:rotateCollection(10)  - run 9 - time taken: 103001 ??s.  
GenericLinkedList:rotateCollection(10)  - run 10 - time taken: 105034 ??s.  
GenericLinkedList:rotateCollection(10)  - run 11 - time taken: 103496 ??s.  
GenericLinkedList:rotateCollection(10)  - run 12 - time taken: 105021 ??s.  
GenericLinkedList:rotateCollection(10)  - run 13 - time taken: 103573 ??s.  
GenericLinkedList:rotateCollection(10)  - run 14 - time taken: 102851 ??s.  
GenericLinkedList:rotateCollection(10)  - run 15 - time taken: 102998 ??s.  
GenericLinkedList:rotateCollection(10)  - run 16 - time taken: 103204 ??s.  
GenericLinkedList:rotateCollection(10)  - run 17 - time taken: 102737 ??s.  
GenericLinkedList:rotateCollection(10)  - run 18 - time taken: 103501 ??s.  
GenericLinkedList:rotateCollection(10)  - run 19 - time taken: 103011 ??s.  
GenericLinkedList:rotateCollection(10)  - run 20 - time taken: 106620 ??s.  
GenericLinkedList:rotateCollection(10)  - run 21 - time taken: 103246 ??s.  
GenericLinkedList:rotateCollection(10)  - run 22 - time taken: 102791 ??s.  
GenericLinkedList:rotateCollection(10)  - run 23 - time taken: 103455 ??s.  
GenericLinkedList:rotateCollection(10)  - run 24 - time taken: 102896 ??s.  
GenericLinkedList:rotateCollection(10)  - run 25 - time taken: 103291 ??s.  
GenericLinkedList:rotateCollection(10)  - run 26 - time taken: 105838 ??s.  
GenericLinkedList:rotateCollection(10)  - run 27 - time taken: 105255 ??s.  
GenericLinkedList:rotateCollection(10)  - run 28 - time taken: 103167 ??s.  
GenericLinkedList:rotateCollection(10)  - run 29 - time taken: 108361 ??s.  
GenericLinkedList:rotateCollection(10)  - run 30 - time taken: 107893 ??s.  
GenericLinkedList:rotateCollection(10)  - run 31 - time taken: 103844 ??s.  
GenericLinkedList:rotateCollection(10)  - run 32 - time taken: 104793 ??s.  
GenericLinkedList:rotateCollection(10)  - run 33 - time taken: 103018 ??s.  
GenericLinkedList:rotateCollection(10)  - run 34 - time taken: 104917 ??s.  
GenericLinkedList:rotateCollection(10)  - run 35 - time taken: 105893 ??s.  
GenericLinkedList:rotateCollection(10)  - run 36 - time taken: 103577 ??s.  
GenericLinkedList:rotateCollection(10)  - run 37 - time taken: 102993 ??s.  
GenericLinkedList:rotateCollection(10)  - run 38 - time taken: 102933 ??s.  
GenericLinkedList:rotateCollection(10)  - run 39 - time taken: 103923 ??s.  
GenericLinkedList:rotateCollection(10)  - run 40 - time taken: 107012 ??s.  
GenericLinkedList:rotateCollection(10)  - run 41 - time taken: 103293 ??s.  
GenericLinkedList:rotateCollection(10)  - run 42 - time taken: 104811 ??s.  
GenericLinkedList:rotateCollection(10)  - run 43 - time taken: 103205 ??s.  
GenericLinkedList:rotateCollection(10)  - run 44 - time taken: 103743 ??s.  
GenericLinkedList:rotateCollection(10)  - run 45 - time taken: 104121 ??s.  
GenericLinkedList:rotateCollection(10)  - run 46 - time taken: 103032 ??s.  
GenericLinkedList:rotateCollection(10)  - run 47 - time taken: 102808 ??s.  
GenericLinkedList:rotateCollection(10)  - run 48 - time taken: 103386 ??s.  
GenericLinkedList:rotateCollection(10)  - run 49 - time taken: 106910 ??s.  
GenericLinkedList:rotateCollection(10)  - run 50 - time taken: 107062 ??s.  
GenericLinkedList:rotateCollection(10) - average: 105137 ??s.  

**collection rotate2**
GenericArrayList:rotateCollection2(10)  - run 1 - time taken: 218 ??s.  
GenericArrayList:rotateCollection2(10)  - run 2 - time taken: 81 ??s.  
GenericArrayList:rotateCollection2(10)  - run 3 - time taken: 68 ??s.  
GenericArrayList:rotateCollection2(10)  - run 4 - time taken: 76 ??s.  
GenericArrayList:rotateCollection2(10)  - run 5 - time taken: 88 ??s.  
GenericArrayList:rotateCollection2(10)  - run 6 - time taken: 728 ??s.  
GenericArrayList:rotateCollection2(10)  - run 7 - time taken: 149 ??s.  
GenericArrayList:rotateCollection2(10)  - run 8 - time taken: 103 ??s.  
GenericArrayList:rotateCollection2(10)  - run 9 - time taken: 81 ??s.  
GenericArrayList:rotateCollection2(10)  - run 10 - time taken: 97 ??s.  
GenericArrayList:rotateCollection2(10)  - run 11 - time taken: 84 ??s.  
GenericArrayList:rotateCollection2(10)  - run 12 - time taken: 99 ??s.  
GenericArrayList:rotateCollection2(10)  - run 13 - time taken: 80 ??s.  
GenericArrayList:rotateCollection2(10)  - run 14 - time taken: 105 ??s.  
GenericArrayList:rotateCollection2(10)  - run 15 - time taken: 89 ??s.  
GenericArrayList:rotateCollection2(10)  - run 16 - time taken: 102 ??s.  
GenericArrayList:rotateCollection2(10)  - run 17 - time taken: 80 ??s.  
GenericArrayList:rotateCollection2(10)  - run 18 - time taken: 97 ??s.  
GenericArrayList:rotateCollection2(10)  - run 19 - time taken: 80 ??s.  
GenericArrayList:rotateCollection2(10)  - run 20 - time taken: 96 ??s.  
GenericArrayList:rotateCollection2(10)  - run 21 - time taken: 80 ??s.  
GenericArrayList:rotateCollection2(10)  - run 22 - time taken: 98 ??s.  
GenericArrayList:rotateCollection2(10)  - run 23 - time taken: 81 ??s.  
GenericArrayList:rotateCollection2(10)  - run 24 - time taken: 97 ??s.  
GenericArrayList:rotateCollection2(10)  - run 25 - time taken: 81 ??s.  
GenericArrayList:rotateCollection2(10)  - run 26 - time taken: 107 ??s.  
GenericArrayList:rotateCollection2(10)  - run 27 - time taken: 81 ??s.  
GenericArrayList:rotateCollection2(10)  - run 28 - time taken: 99 ??s.  
GenericArrayList:rotateCollection2(10)  - run 29 - time taken: 80 ??s.  
GenericArrayList:rotateCollection2(10)  - run 30 - time taken: 97 ??s.  
GenericArrayList:rotateCollection2(10)  - run 31 - time taken: 80 ??s.  
GenericArrayList:rotateCollection2(10)  - run 32 - time taken: 97 ??s.  
GenericArrayList:rotateCollection2(10)  - run 33 - time taken: 80 ??s.  
GenericArrayList:rotateCollection2(10)  - run 34 - time taken: 99 ??s.  
GenericArrayList:rotateCollection2(10)  - run 35 - time taken: 91 ??s.  
GenericArrayList:rotateCollection2(10)  - run 36 - time taken: 135 ??s.  
GenericArrayList:rotateCollection2(10)  - run 37 - time taken: 80 ??s.  
GenericArrayList:rotateCollection2(10)  - run 38 - time taken: 97 ??s.  
GenericArrayList:rotateCollection2(10)  - run 39 - time taken: 80 ??s.  
GenericArrayList:rotateCollection2(10)  - run 40 - time taken: 71 ??s.  
GenericArrayList:rotateCollection2(10)  - run 41 - time taken: 58 ??s.  
GenericArrayList:rotateCollection2(10)  - run 42 - time taken: 117 ??s.  
GenericArrayList:rotateCollection2(10)  - run 43 - time taken: 149 ??s.  
GenericArrayList:rotateCollection2(10)  - run 44 - time taken: 119 ??s.  
GenericArrayList:rotateCollection2(10)  - run 45 - time taken: 61 ??s.  
GenericArrayList:rotateCollection2(10)  - run 46 - time taken: 95 ??s.  
GenericArrayList:rotateCollection2(10)  - run 47 - time taken: 56 ??s.  
GenericArrayList:rotateCollection2(10)  - run 48 - time taken: 70 ??s.  
GenericArrayList:rotateCollection2(10)  - run 49 - time taken: 57 ??s.  
GenericArrayList:rotateCollection2(10)  - run 50 - time taken: 70 ??s.  
GenericArrayList:rotateCollection2(10) - average: 105 ??s.  


GenericLinkedList:rotateCollection2(10)  - run 1 - time taken: 57 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 2 - time taken: 43 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 3 - time taken: 43 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 4 - time taken: 43 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 5 - time taken: 43 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 6 - time taken: 43 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 7 - time taken: 43 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 8 - time taken: 43 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 9 - time taken: 43 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 10 - time taken: 43 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 11 - time taken: 43 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 12 - time taken: 43 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 13 - time taken: 43 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 14 - time taken: 43 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 15 - time taken: 43 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 16 - time taken: 43 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 17 - time taken: 43 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 18 - time taken: 43 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 19 - time taken: 43 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 20 - time taken: 44 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 21 - time taken: 43 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 22 - time taken: 43 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 23 - time taken: 43 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 24 - time taken: 43 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 25 - time taken: 43 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 26 - time taken: 43 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 27 - time taken: 43 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 28 - time taken: 43 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 29 - time taken: 44 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 30 - time taken: 45 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 31 - time taken: 48 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 32 - time taken: 46 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 33 - time taken: 47 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 34 - time taken: 48 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 35 - time taken: 47 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 36 - time taken: 45 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 37 - time taken: 47 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 38 - time taken: 47 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 39 - time taken: 48 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 40 - time taken: 46 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 41 - time taken: 46 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 42 - time taken: 46 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 43 - time taken: 46 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 44 - time taken: 46 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 45 - time taken: 46 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 46 - time taken: 45 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 47 - time taken: 46 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 48 - time taken: 46 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 49 - time taken: 44 ??s.  
GenericLinkedList:rotateCollection2(10)  - run 50 - time taken: 44 ??s.  
GenericArrayList:rotateCollection2(10) - average: 44 ??s.  

Process finished with exit code 0
```
