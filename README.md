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
<img src="https://user-images.githubusercontent.com/74976200/145113291-2cfa948a-bb45-4130-b92e-5522bd520059.png" width="500">  
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
| GenericArrayList | 5000 | 263μs | 10 | 202μs | 6166μs | 105μs | 
| GenericLinkedList | 5000 | 445μs | 10 | 270μs | 105137μs | 44μs |   

<sub>The above table shows the summarized output for all executions. The full console output is shown below.</sub>

It is important to point out here that the performance of the GenericArrayList can be tuned significantly by increasing the starting size of the buffer. When the buffer does not need to be resized, the GenericArrayList will have faster adds. It was left small in the example code to make testing easier - but this requires growth to happen more often, and from a smaller base.

When it comes to Big O here are some of the more common time complexity possibilities:
1. O(1): Executes in the same time regardless of the size of the input
1. O(n): Executes linearly and proportionally to the size of the input
1. O(n²): Performance is directly proportional to the square of the size of the input (ex: nested iterations, loops)

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
GenericArrayList:addElementsToArray() - run 1 - time taken: 800 μs.  
GenericArrayList:addElementsToArray() - run 2 - time taken: 483 μs.  
GenericArrayList:addElementsToArray() - run 3 - time taken: 427 μs.  
GenericArrayList:addElementsToArray() - run 4 - time taken: 391 μs.  
GenericArrayList:addElementsToArray() - run 5 - time taken: 414 μs.  
GenericArrayList:addElementsToArray() - run 6 - time taken: 524 μs.  
GenericArrayList:addElementsToArray() - run 7 - time taken: 472 μs.  
GenericArrayList:addElementsToArray() - run 8 - time taken: 443 μs.  
GenericArrayList:addElementsToArray() - run 9 - time taken: 626 μs.  
GenericArrayList:addElementsToArray() - run 10 - time taken: 466 μs.  
GenericArrayList:addElementsToArray() - run 11 - time taken: 401 μs.  
GenericArrayList:addElementsToArray() - run 12 - time taken: 406 μs.  
GenericArrayList:addElementsToArray() - run 13 - time taken: 387 μs.  
GenericArrayList:addElementsToArray() - run 14 - time taken: 317 μs.  
GenericArrayList:addElementsToArray() - run 15 - time taken: 192 μs.  
GenericArrayList:addElementsToArray() - run 16 - time taken: 252 μs.  
GenericArrayList:addElementsToArray() - run 17 - time taken: 189 μs.  
GenericArrayList:addElementsToArray() - run 18 - time taken: 218 μs.  
GenericArrayList:addElementsToArray() - run 19 - time taken: 222 μs.  
GenericArrayList:addElementsToArray() - run 20 - time taken: 211 μs.  
GenericArrayList:addElementsToArray() - run 21 - time taken: 269 μs.  
GenericArrayList:addElementsToArray() - run 22 - time taken: 279 μs.  
GenericArrayList:addElementsToArray() - run 23 - time taken: 184 μs.  
GenericArrayList:addElementsToArray() - run 24 - time taken: 192 μs.  
GenericArrayList:addElementsToArray() - run 25 - time taken: 168 μs.  
GenericArrayList:addElementsToArray() - run 26 - time taken: 176 μs.  
GenericArrayList:addElementsToArray() - run 27 - time taken: 156 μs.  
GenericArrayList:addElementsToArray() - run 28 - time taken: 129 μs.  
GenericArrayList:addElementsToArray() - run 29 - time taken: 138 μs.  
GenericArrayList:addElementsToArray() - run 30 - time taken: 161 μs.  
GenericArrayList:addElementsToArray() - run 31 - time taken: 178 μs.  
GenericArrayList:addElementsToArray() - run 32 - time taken: 149 μs.  
GenericArrayList:addElementsToArray() - run 33 - time taken: 162 μs.  
GenericArrayList:addElementsToArray() - run 34 - time taken: 195 μs.  
GenericArrayList:addElementsToArray() - run 35 - time taken: 200 μs.  
GenericArrayList:addElementsToArray() - run 36 - time taken: 201 μs.  
GenericArrayList:addElementsToArray() - run 37 - time taken: 150 μs.  
GenericArrayList:addElementsToArray() - run 38 - time taken: 172 μs.  
GenericArrayList:addElementsToArray() - run 39 - time taken: 194 μs.  
GenericArrayList:addElementsToArray() - run 40 - time taken: 164 μs.  
GenericArrayList:addElementsToArray() - run 41 - time taken: 190 μs.  
GenericArrayList:addElementsToArray() - run 42 - time taken: 158 μs.  
GenericArrayList:addElementsToArray() - run 43 - time taken: 179 μs.  
GenericArrayList:addElementsToArray() - run 44 - time taken: 174 μs.  
GenericArrayList:addElementsToArray() - run 45 - time taken: 122 μs.  
GenericArrayList:addElementsToArray() - run 46 - time taken: 164 μs.  
GenericArrayList:addElementsToArray() - run 47 - time taken: 156 μs.  
GenericArrayList:addElementsToArray() - run 48 - time taken: 303 μs.  
GenericArrayList:addElementsToArray() - run 49 - time taken: 138 μs.  
GenericArrayList:addElementsToArray() - run 50 - time taken: 139 μs.  
GenericArrayList:addElementsToArray() - average: 263μs


LinkedList:addElementsToArray()  - run 1 - time taken: 2465 μs.  
LinkedList:addElementsToArray()  - run 2 - time taken: 482 μs.  
LinkedList:addElementsToArray()  - run 3 - time taken: 346 μs.  
LinkedList:addElementsToArray()  - run 4 - time taken: 346 μs.  
LinkedList:addElementsToArray()  - run 5 - time taken: 354 μs.  
LinkedList:addElementsToArray()  - run 6 - time taken: 438 μs.  
LinkedList:addElementsToArray()  - run 7 - time taken: 401 μs.  
LinkedList:addElementsToArray()  - run 8 - time taken: 377 μs.  
LinkedList:addElementsToArray()  - run 9 - time taken: 415 μs.  
LinkedList:addElementsToArray()  - run 10 - time taken: 356 μs.  
LinkedList:addElementsToArray()  - run 11 - time taken: 546 μs.  
LinkedList:addElementsToArray()  - run 12 - time taken: 426 μs.  
LinkedList:addElementsToArray()  - run 13 - time taken: 483 μs.  
LinkedList:addElementsToArray()  - run 14 - time taken: 451 μs.  
LinkedList:addElementsToArray()  - run 15 - time taken: 423 μs.  
LinkedList:addElementsToArray()  - run 16 - time taken: 440 μs.  
LinkedList:addElementsToArray()  - run 17 - time taken: 490 μs.  
LinkedList:addElementsToArray()  - run 18 - time taken: 503 μs.  
LinkedList:addElementsToArray()  - run 19 - time taken: 445 μs.  
LinkedList:addElementsToArray()  - run 20 - time taken: 445 μs.  
LinkedList:addElementsToArray()  - run 21 - time taken: 431 μs.  
LinkedList:addElementsToArray()  - run 22 - time taken: 486 μs.  
LinkedList:addElementsToArray()  - run 23 - time taken: 459 μs.  
LinkedList:addElementsToArray()  - run 24 - time taken: 357 μs.  
LinkedList:addElementsToArray()  - run 25 - time taken: 422 μs.  
LinkedList:addElementsToArray()  - run 26 - time taken: 415 μs.  
LinkedList:addElementsToArray()  - run 27 - time taken: 396 μs.  
LinkedList:addElementsToArray()  - run 28 - time taken: 392 μs.  
LinkedList:addElementsToArray()  - run 29 - time taken: 423 μs.  
LinkedList:addElementsToArray()  - run 30 - time taken: 341 μs.  
LinkedList:addElementsToArray()  - run 31 - time taken: 310 μs.  
LinkedList:addElementsToArray()  - run 32 - time taken: 403 μs.  
LinkedList:addElementsToArray()  - run 33 - time taken: 535 μs.  
LinkedList:addElementsToArray()  - run 34 - time taken: 438 μs.  
LinkedList:addElementsToArray()  - run 35 - time taken: 1460 μs.  
LinkedList:addElementsToArray()  - run 36 - time taken: 557 μs.  
LinkedList:addElementsToArray()  - run 37 - time taken: 442 μs.  
LinkedList:addElementsToArray()  - run 38 - time taken: 491 μs.  
LinkedList:addElementsToArray()  - run 39 - time taken: 247 μs.  
LinkedList:addElementsToArray()  - run 40 - time taken: 211 μs.  
LinkedList:addElementsToArray()  - run 41 - time taken: 216 μs.  
LinkedList:addElementsToArray()  - run 42 - time taken: 287 μs.  
LinkedList:addElementsToArray()  - run 43 - time taken: 284 μs.  
LinkedList:addElementsToArray()  - run 44 - time taken: 213 μs.  
LinkedList:addElementsToArray()  - run 45 - time taken: 250 μs.  
LinkedList:addElementsToArray()  - run 46 - time taken: 251 μs.  
LinkedList:addElementsToArray()  - run 47 - time taken: 246 μs.  
LinkedList:addElementsToArray()  - run 48 - time taken: 223 μs.  
LinkedList:addElementsToArray()  - run 49 - time taken: 212 μs.  
LinkedList:addElementsToArray()  - run 50 - time taken: 229 μs.  
LinkedList:addElementsToArray() - average: 445 μs

**rotate comparisons**
GenericArrayList:rotate(10)  - run 1 - time taken: 684 μs.  
GenericArrayList:rotate(10)  - run 2 - time taken: 617 μs.  
GenericArrayList:rotate(10)  - run 3 - time taken: 527 μs.  
GenericArrayList:rotate(10)  - run 4 - time taken: 307 μs.  
GenericArrayList:rotate(10)  - run 5 - time taken: 191 μs.  
GenericArrayList:rotate(10)  - run 6 - time taken: 165 μs.  
GenericArrayList:rotate(10)  - run 7 - time taken: 168 μs.  
GenericArrayList:rotate(10)  - run 8 - time taken: 181 μs.  
GenericArrayList:rotate(10)  - run 9 - time taken: 170 μs.  
GenericArrayList:rotate(10)  - run 10 - time taken: 165 μs.  
GenericArrayList:rotate(10)  - run 11 - time taken: 165 μs.  
GenericArrayList:rotate(10)  - run 12 - time taken: 196 μs.  
GenericArrayList:rotate(10)  - run 13 - time taken: 183 μs.  
GenericArrayList:rotate(10)  - run 14 - time taken: 190 μs.  
GenericArrayList:rotate(10)  - run 15 - time taken: 183 μs.  
GenericArrayList:rotate(10)  - run 16 - time taken: 154 μs.  
GenericArrayList:rotate(10)  - run 17 - time taken: 160 μs.  
GenericArrayList:rotate(10)  - run 18 - time taken: 154 μs.  
GenericArrayList:rotate(10)  - run 19 - time taken: 164 μs.  
GenericArrayList:rotate(10)  - run 20 - time taken: 160 μs.  
GenericArrayList:rotate(10)  - run 21 - time taken: 253 μs.  
GenericArrayList:rotate(10)  - run 22 - time taken: 166 μs.  
GenericArrayList:rotate(10)  - run 23 - time taken: 177 μs.  
GenericArrayList:rotate(10)  - run 24 - time taken: 159 μs.  
GenericArrayList:rotate(10)  - run 25 - time taken: 164 μs.  
GenericArrayList:rotate(10)  - run 26 - time taken: 167 μs.  
GenericArrayList:rotate(10)  - run 27 - time taken: 162 μs.  
GenericArrayList:rotate(10)  - run 28 - time taken: 174 μs.  
GenericArrayList:rotate(10)  - run 29 - time taken: 155 μs.  
GenericArrayList:rotate(10)  - run 30 - time taken: 158 μs.  
GenericArrayList:rotate(10)  - run 31 - time taken: 155 μs.  
GenericArrayList:rotate(10)  - run 32 - time taken: 156 μs.  
GenericArrayList:rotate(10)  - run 33 - time taken: 158 μs.  
GenericArrayList:rotate(10)  - run 34 - time taken: 215 μs.  
GenericArrayList:rotate(10)  - run 35 - time taken: 161 μs.  
GenericArrayList:rotate(10)  - run 36 - time taken: 177 μs.  
GenericArrayList:rotate(10)  - run 37 - time taken: 167 μs.  
GenericArrayList:rotate(10)  - run 38 - time taken: 167 μs.  
GenericArrayList:rotate(10)  - run 39 - time taken: 192 μs.  
GenericArrayList:rotate(10)  - run 40 - time taken: 165 μs.  
GenericArrayList:rotate(10)  - run 41 - time taken: 180 μs.  
GenericArrayList:rotate(10)  - run 42 - time taken: 186 μs.  
GenericArrayList:rotate(10)  - run 43 - time taken: 201 μs.  
GenericArrayList:rotate(10)  - run 44 - time taken: 175 μs.  
GenericArrayList:rotate(10)  - run 45 - time taken: 179 μs.  
GenericArrayList:rotate(10)  - run 46 - time taken: 158 μs.  
GenericArrayList:rotate(10)  - run 47 - time taken: 175 μs.  
GenericArrayList:rotate(10)  - run 48 - time taken: 187 μs.  
GenericArrayList:rotate(10)  - run 49 - time taken: 179 μs.  
GenericArrayList:rotate(10)  - run 50 - time taken: 163 μs.  
GenericArrayList:rotate(10) - average: 202 μs.  


GenericLinkedList:rotate(10)  - run 1 - time taken: 860 μs.  
GenericLinkedList:rotate(10)  - run 2 - time taken: 272 μs.  
GenericLinkedList:rotate(10)  - run 3 - time taken: 230 μs.  
GenericLinkedList:rotate(10)  - run 4 - time taken: 223 μs.  
GenericLinkedList:rotate(10)  - run 5 - time taken: 219 μs.  
GenericLinkedList:rotate(10)  - run 6 - time taken: 218 μs.  
GenericLinkedList:rotate(10)  - run 7 - time taken: 218 μs.  
GenericLinkedList:rotate(10)  - run 8 - time taken: 220 μs.  
GenericLinkedList:rotate(10)  - run 9 - time taken: 764 μs.  
GenericLinkedList:rotate(10)  - run 10 - time taken: 462 μs.  
GenericLinkedList:rotate(10)  - run 11 - time taken: 3029 μs.  
GenericLinkedList:rotate(10)  - run 12 - time taken: 187 μs.  
GenericLinkedList:rotate(10)  - run 13 - time taken: 180 μs.  
GenericLinkedList:rotate(10)  - run 14 - time taken: 182 μs.  
GenericLinkedList:rotate(10)  - run 15 - time taken: 178 μs.  
GenericLinkedList:rotate(10)  - run 16 - time taken: 178 μs.  
GenericLinkedList:rotate(10)  - run 17 - time taken: 180 μs.  
GenericLinkedList:rotate(10)  - run 18 - time taken: 178 μs.  
GenericLinkedList:rotate(10)  - run 19 - time taken: 178 μs.  
GenericLinkedList:rotate(10)  - run 20 - time taken: 178 μs.  
GenericLinkedList:rotate(10)  - run 21 - time taken: 167 μs.  
GenericLinkedList:rotate(10)  - run 22 - time taken: 183 μs.  
GenericLinkedList:rotate(10)  - run 23 - time taken: 166 μs.  
GenericLinkedList:rotate(10)  - run 24 - time taken: 164 μs.  
GenericLinkedList:rotate(10)  - run 25 - time taken: 164 μs.  
GenericLinkedList:rotate(10)  - run 26 - time taken: 177 μs.  
GenericLinkedList:rotate(10)  - run 27 - time taken: 188 μs.  
GenericLinkedList:rotate(10)  - run 28 - time taken: 183 μs.  
GenericLinkedList:rotate(10)  - run 29 - time taken: 187 μs.  
GenericLinkedList:rotate(10)  - run 30 - time taken: 166 μs.  
GenericLinkedList:rotate(10)  - run 31 - time taken: 166 μs.  
GenericLinkedList:rotate(10)  - run 32 - time taken: 171 μs.  
GenericLinkedList:rotate(10)  - run 33 - time taken: 174 μs.  
GenericLinkedList:rotate(10)  - run 34 - time taken: 184 μs.  
GenericLinkedList:rotate(10)  - run 35 - time taken: 172 μs.  
GenericLinkedList:rotate(10)  - run 36 - time taken: 168 μs.  
GenericLinkedList:rotate(10)  - run 37 - time taken: 191 μs.  
GenericLinkedList:rotate(10)  - run 38 - time taken: 182 μs.  
GenericLinkedList:rotate(10)  - run 39 - time taken: 173 μs.  
GenericLinkedList:rotate(10)  - run 40 - time taken: 167 μs.  
GenericLinkedList:rotate(10)  - run 41 - time taken: 167 μs.  
GenericLinkedList:rotate(10)  - run 42 - time taken: 169 μs.  
GenericLinkedList:rotate(10)  - run 43 - time taken: 168 μs.  
GenericLinkedList:rotate(10)  - run 44 - time taken: 169 μs.  
GenericLinkedList:rotate(10)  - run 45 - time taken: 189 μs.  
GenericLinkedList:rotate(10)  - run 46 - time taken: 167 μs.  
GenericLinkedList:rotate(10)  - run 47 - time taken: 168 μs.  
GenericLinkedList:rotate(10)  - run 48 - time taken: 170 μs.  
GenericLinkedList:rotate(10)  - run 49 - time taken: 167 μs.  
GenericLinkedList:rotate(10)  - run 50 - time taken: 167 μs.  
GenericLinkedList:rotate(10) - average: 270 μs.  

**collection rotate**
GenericArrayList:rotateCollection(10)  - run 1 - time taken: 14484 μs.  
GenericArrayList:rotateCollection(10)  - run 2 - time taken: 6274 μs.  
GenericArrayList:rotateCollection(10)  - run 3 - time taken: 6100 μs.  
GenericArrayList:rotateCollection(10)  - run 4 - time taken: 6106 μs.  
GenericArrayList:rotateCollection(10)  - run 5 - time taken: 5831 μs.  
GenericArrayList:rotateCollection(10)  - run 6 - time taken: 5719 μs.  
GenericArrayList:rotateCollection(10)  - run 7 - time taken: 5703 μs.  
GenericArrayList:rotateCollection(10)  - run 8 - time taken: 5552 μs.  
GenericArrayList:rotateCollection(10)  - run 9 - time taken: 6220 μs.  
GenericArrayList:rotateCollection(10)  - run 10 - time taken: 5782 μs.  
GenericArrayList:rotateCollection(10)  - run 11 - time taken: 5598 μs.  
GenericArrayList:rotateCollection(10)  - run 12 - time taken: 5801 μs.  
GenericArrayList:rotateCollection(10)  - run 13 - time taken: 5773 μs.  
GenericArrayList:rotateCollection(10)  - run 14 - time taken: 6110 μs.  
GenericArrayList:rotateCollection(10)  - run 15 - time taken: 6326 μs.  
GenericArrayList:rotateCollection(10)  - run 16 - time taken: 5936 μs.  
GenericArrayList:rotateCollection(10)  - run 17 - time taken: 5794 μs.  
GenericArrayList:rotateCollection(10)  - run 18 - time taken: 5816 μs.  
GenericArrayList:rotateCollection(10)  - run 19 - time taken: 5600 μs.  
GenericArrayList:rotateCollection(10)  - run 20 - time taken: 5938 μs.  
GenericArrayList:rotateCollection(10)  - run 21 - time taken: 5612 μs.  
GenericArrayList:rotateCollection(10)  - run 22 - time taken: 5837 μs.  
GenericArrayList:rotateCollection(10)  - run 23 - time taken: 8463 μs.  
GenericArrayList:rotateCollection(10)  - run 24 - time taken: 8764 μs.  
GenericArrayList:rotateCollection(10)  - run 25 - time taken: 6123 μs.  
GenericArrayList:rotateCollection(10)  - run 26 - time taken: 5533 μs.  
GenericArrayList:rotateCollection(10)  - run 27 - time taken: 6591 μs.  
GenericArrayList:rotateCollection(10)  - run 28 - time taken: 5854 μs.  
GenericArrayList:rotateCollection(10)  - run 29 - time taken: 6176 μs.  
GenericArrayList:rotateCollection(10)  - run 30 - time taken: 5797 μs.  
GenericArrayList:rotateCollection(10)  - run 31 - time taken: 5913 μs.  
GenericArrayList:rotateCollection(10)  - run 32 - time taken: 5922 μs.  
GenericArrayList:rotateCollection(10)  - run 33 - time taken: 5980 μs.  
GenericArrayList:rotateCollection(10)  - run 34 - time taken: 5826 μs.  
GenericArrayList:rotateCollection(10)  - run 35 - time taken: 5681 μs.  
GenericArrayList:rotateCollection(10)  - run 36 - time taken: 5597 μs.  
GenericArrayList:rotateCollection(10)  - run 37 - time taken: 5776 μs.  
GenericArrayList:rotateCollection(10)  - run 38 - time taken: 5662 μs.  
GenericArrayList:rotateCollection(10)  - run 39 - time taken: 5689 μs.  
GenericArrayList:rotateCollection(10)  - run 40 - time taken: 6166 μs.  
GenericArrayList:rotateCollection(10)  - run 41 - time taken: 6422 μs.  
GenericArrayList:rotateCollection(10)  - run 42 - time taken: 5945 μs.  
GenericArrayList:rotateCollection(10)  - run 43 - time taken: 7164 μs.  
GenericArrayList:rotateCollection(10)  - run 44 - time taken: 5682 μs.  
GenericArrayList:rotateCollection(10)  - run 45 - time taken: 5772 μs.  
GenericArrayList:rotateCollection(10)  - run 46 - time taken: 5424 μs.  
GenericArrayList:rotateCollection(10)  - run 47 - time taken: 5416 μs.  
GenericArrayList:rotateCollection(10)  - run 48 - time taken: 5924 μs.  
GenericArrayList:rotateCollection(10)  - run 49 - time taken: 5653 μs.  
GenericArrayList:rotateCollection(10)  - run 50 - time taken: 5492 μs.  
GenericArrayList:rotateCollection(10) - average: 6166 μs.  


GenericLinkedList:rotateCollection(10)  - run 1 - time taken: 124721 μs.  
GenericLinkedList:rotateCollection(10)  - run 2 - time taken: 115424 μs.  
GenericLinkedList:rotateCollection(10)  - run 3 - time taken: 110583 μs.  
GenericLinkedList:rotateCollection(10)  - run 4 - time taken: 107406 μs.  
GenericLinkedList:rotateCollection(10)  - run 5 - time taken: 108726 μs.  
GenericLinkedList:rotateCollection(10)  - run 6 - time taken: 107707 μs.  
GenericLinkedList:rotateCollection(10)  - run 7 - time taken: 102804 μs.  
GenericLinkedList:rotateCollection(10)  - run 8 - time taken: 102972 μs.  
GenericLinkedList:rotateCollection(10)  - run 9 - time taken: 103001 μs.  
GenericLinkedList:rotateCollection(10)  - run 10 - time taken: 105034 μs.  
GenericLinkedList:rotateCollection(10)  - run 11 - time taken: 103496 μs.  
GenericLinkedList:rotateCollection(10)  - run 12 - time taken: 105021 μs.  
GenericLinkedList:rotateCollection(10)  - run 13 - time taken: 103573 μs.  
GenericLinkedList:rotateCollection(10)  - run 14 - time taken: 102851 μs.  
GenericLinkedList:rotateCollection(10)  - run 15 - time taken: 102998 μs.  
GenericLinkedList:rotateCollection(10)  - run 16 - time taken: 103204 μs.  
GenericLinkedList:rotateCollection(10)  - run 17 - time taken: 102737 μs.  
GenericLinkedList:rotateCollection(10)  - run 18 - time taken: 103501 μs.  
GenericLinkedList:rotateCollection(10)  - run 19 - time taken: 103011 μs.  
GenericLinkedList:rotateCollection(10)  - run 20 - time taken: 106620 μs.  
GenericLinkedList:rotateCollection(10)  - run 21 - time taken: 103246 μs.  
GenericLinkedList:rotateCollection(10)  - run 22 - time taken: 102791 μs.  
GenericLinkedList:rotateCollection(10)  - run 23 - time taken: 103455 μs.  
GenericLinkedList:rotateCollection(10)  - run 24 - time taken: 102896 μs.  
GenericLinkedList:rotateCollection(10)  - run 25 - time taken: 103291 μs.  
GenericLinkedList:rotateCollection(10)  - run 26 - time taken: 105838 μs.  
GenericLinkedList:rotateCollection(10)  - run 27 - time taken: 105255 μs.  
GenericLinkedList:rotateCollection(10)  - run 28 - time taken: 103167 μs.  
GenericLinkedList:rotateCollection(10)  - run 29 - time taken: 108361 μs.  
GenericLinkedList:rotateCollection(10)  - run 30 - time taken: 107893 μs.  
GenericLinkedList:rotateCollection(10)  - run 31 - time taken: 103844 μs.  
GenericLinkedList:rotateCollection(10)  - run 32 - time taken: 104793 μs.  
GenericLinkedList:rotateCollection(10)  - run 33 - time taken: 103018 μs.  
GenericLinkedList:rotateCollection(10)  - run 34 - time taken: 104917 μs.  
GenericLinkedList:rotateCollection(10)  - run 35 - time taken: 105893 μs.  
GenericLinkedList:rotateCollection(10)  - run 36 - time taken: 103577 μs.  
GenericLinkedList:rotateCollection(10)  - run 37 - time taken: 102993 μs.  
GenericLinkedList:rotateCollection(10)  - run 38 - time taken: 102933 μs.  
GenericLinkedList:rotateCollection(10)  - run 39 - time taken: 103923 μs.  
GenericLinkedList:rotateCollection(10)  - run 40 - time taken: 107012 μs.  
GenericLinkedList:rotateCollection(10)  - run 41 - time taken: 103293 μs.  
GenericLinkedList:rotateCollection(10)  - run 42 - time taken: 104811 μs.  
GenericLinkedList:rotateCollection(10)  - run 43 - time taken: 103205 μs.  
GenericLinkedList:rotateCollection(10)  - run 44 - time taken: 103743 μs.  
GenericLinkedList:rotateCollection(10)  - run 45 - time taken: 104121 μs.  
GenericLinkedList:rotateCollection(10)  - run 46 - time taken: 103032 μs.  
GenericLinkedList:rotateCollection(10)  - run 47 - time taken: 102808 μs.  
GenericLinkedList:rotateCollection(10)  - run 48 - time taken: 103386 μs.  
GenericLinkedList:rotateCollection(10)  - run 49 - time taken: 106910 μs.  
GenericLinkedList:rotateCollection(10)  - run 50 - time taken: 107062 μs.  
GenericLinkedList:rotateCollection(10) - average: 105137 μs.  

**collection rotate2**
GenericArrayList:rotateCollection2(10)  - run 1 - time taken: 218 μs.  
GenericArrayList:rotateCollection2(10)  - run 2 - time taken: 81 μs.  
GenericArrayList:rotateCollection2(10)  - run 3 - time taken: 68 μs.  
GenericArrayList:rotateCollection2(10)  - run 4 - time taken: 76 μs.  
GenericArrayList:rotateCollection2(10)  - run 5 - time taken: 88 μs.  
GenericArrayList:rotateCollection2(10)  - run 6 - time taken: 728 μs.  
GenericArrayList:rotateCollection2(10)  - run 7 - time taken: 149 μs.  
GenericArrayList:rotateCollection2(10)  - run 8 - time taken: 103 μs.  
GenericArrayList:rotateCollection2(10)  - run 9 - time taken: 81 μs.  
GenericArrayList:rotateCollection2(10)  - run 10 - time taken: 97 μs.  
GenericArrayList:rotateCollection2(10)  - run 11 - time taken: 84 μs.  
GenericArrayList:rotateCollection2(10)  - run 12 - time taken: 99 μs.  
GenericArrayList:rotateCollection2(10)  - run 13 - time taken: 80 μs.  
GenericArrayList:rotateCollection2(10)  - run 14 - time taken: 105 μs.  
GenericArrayList:rotateCollection2(10)  - run 15 - time taken: 89 μs.  
GenericArrayList:rotateCollection2(10)  - run 16 - time taken: 102 μs.  
GenericArrayList:rotateCollection2(10)  - run 17 - time taken: 80 μs.  
GenericArrayList:rotateCollection2(10)  - run 18 - time taken: 97 μs.  
GenericArrayList:rotateCollection2(10)  - run 19 - time taken: 80 μs.  
GenericArrayList:rotateCollection2(10)  - run 20 - time taken: 96 μs.  
GenericArrayList:rotateCollection2(10)  - run 21 - time taken: 80 μs.  
GenericArrayList:rotateCollection2(10)  - run 22 - time taken: 98 μs.  
GenericArrayList:rotateCollection2(10)  - run 23 - time taken: 81 μs.  
GenericArrayList:rotateCollection2(10)  - run 24 - time taken: 97 μs.  
GenericArrayList:rotateCollection2(10)  - run 25 - time taken: 81 μs.  
GenericArrayList:rotateCollection2(10)  - run 26 - time taken: 107 μs.  
GenericArrayList:rotateCollection2(10)  - run 27 - time taken: 81 μs.  
GenericArrayList:rotateCollection2(10)  - run 28 - time taken: 99 μs.  
GenericArrayList:rotateCollection2(10)  - run 29 - time taken: 80 μs.  
GenericArrayList:rotateCollection2(10)  - run 30 - time taken: 97 μs.  
GenericArrayList:rotateCollection2(10)  - run 31 - time taken: 80 μs.  
GenericArrayList:rotateCollection2(10)  - run 32 - time taken: 97 μs.  
GenericArrayList:rotateCollection2(10)  - run 33 - time taken: 80 μs.  
GenericArrayList:rotateCollection2(10)  - run 34 - time taken: 99 μs.  
GenericArrayList:rotateCollection2(10)  - run 35 - time taken: 91 μs.  
GenericArrayList:rotateCollection2(10)  - run 36 - time taken: 135 μs.  
GenericArrayList:rotateCollection2(10)  - run 37 - time taken: 80 μs.  
GenericArrayList:rotateCollection2(10)  - run 38 - time taken: 97 μs.  
GenericArrayList:rotateCollection2(10)  - run 39 - time taken: 80 μs.  
GenericArrayList:rotateCollection2(10)  - run 40 - time taken: 71 μs.  
GenericArrayList:rotateCollection2(10)  - run 41 - time taken: 58 μs.  
GenericArrayList:rotateCollection2(10)  - run 42 - time taken: 117 μs.  
GenericArrayList:rotateCollection2(10)  - run 43 - time taken: 149 μs.  
GenericArrayList:rotateCollection2(10)  - run 44 - time taken: 119 μs.  
GenericArrayList:rotateCollection2(10)  - run 45 - time taken: 61 μs.  
GenericArrayList:rotateCollection2(10)  - run 46 - time taken: 95 μs.  
GenericArrayList:rotateCollection2(10)  - run 47 - time taken: 56 μs.  
GenericArrayList:rotateCollection2(10)  - run 48 - time taken: 70 μs.  
GenericArrayList:rotateCollection2(10)  - run 49 - time taken: 57 μs.  
GenericArrayList:rotateCollection2(10)  - run 50 - time taken: 70 μs.  
GenericArrayList:rotateCollection2(10) - average: 105 μs.  


GenericLinkedList:rotateCollection2(10)  - run 1 - time taken: 57 μs.  
GenericLinkedList:rotateCollection2(10)  - run 2 - time taken: 43 μs.  
GenericLinkedList:rotateCollection2(10)  - run 3 - time taken: 43 μs.  
GenericLinkedList:rotateCollection2(10)  - run 4 - time taken: 43 μs.  
GenericLinkedList:rotateCollection2(10)  - run 5 - time taken: 43 μs.  
GenericLinkedList:rotateCollection2(10)  - run 6 - time taken: 43 μs.  
GenericLinkedList:rotateCollection2(10)  - run 7 - time taken: 43 μs.  
GenericLinkedList:rotateCollection2(10)  - run 8 - time taken: 43 μs.  
GenericLinkedList:rotateCollection2(10)  - run 9 - time taken: 43 μs.  
GenericLinkedList:rotateCollection2(10)  - run 10 - time taken: 43 μs.  
GenericLinkedList:rotateCollection2(10)  - run 11 - time taken: 43 μs.  
GenericLinkedList:rotateCollection2(10)  - run 12 - time taken: 43 μs.  
GenericLinkedList:rotateCollection2(10)  - run 13 - time taken: 43 μs.  
GenericLinkedList:rotateCollection2(10)  - run 14 - time taken: 43 μs.  
GenericLinkedList:rotateCollection2(10)  - run 15 - time taken: 43 μs.  
GenericLinkedList:rotateCollection2(10)  - run 16 - time taken: 43 μs.  
GenericLinkedList:rotateCollection2(10)  - run 17 - time taken: 43 μs.  
GenericLinkedList:rotateCollection2(10)  - run 18 - time taken: 43 μs.  
GenericLinkedList:rotateCollection2(10)  - run 19 - time taken: 43 μs.  
GenericLinkedList:rotateCollection2(10)  - run 20 - time taken: 44 μs.  
GenericLinkedList:rotateCollection2(10)  - run 21 - time taken: 43 μs.  
GenericLinkedList:rotateCollection2(10)  - run 22 - time taken: 43 μs.  
GenericLinkedList:rotateCollection2(10)  - run 23 - time taken: 43 μs.  
GenericLinkedList:rotateCollection2(10)  - run 24 - time taken: 43 μs.  
GenericLinkedList:rotateCollection2(10)  - run 25 - time taken: 43 μs.  
GenericLinkedList:rotateCollection2(10)  - run 26 - time taken: 43 μs.  
GenericLinkedList:rotateCollection2(10)  - run 27 - time taken: 43 μs.  
GenericLinkedList:rotateCollection2(10)  - run 28 - time taken: 43 μs.  
GenericLinkedList:rotateCollection2(10)  - run 29 - time taken: 44 μs.  
GenericLinkedList:rotateCollection2(10)  - run 30 - time taken: 45 μs.  
GenericLinkedList:rotateCollection2(10)  - run 31 - time taken: 48 μs.  
GenericLinkedList:rotateCollection2(10)  - run 32 - time taken: 46 μs.  
GenericLinkedList:rotateCollection2(10)  - run 33 - time taken: 47 μs.  
GenericLinkedList:rotateCollection2(10)  - run 34 - time taken: 48 μs.  
GenericLinkedList:rotateCollection2(10)  - run 35 - time taken: 47 μs.  
GenericLinkedList:rotateCollection2(10)  - run 36 - time taken: 45 μs.  
GenericLinkedList:rotateCollection2(10)  - run 37 - time taken: 47 μs.  
GenericLinkedList:rotateCollection2(10)  - run 38 - time taken: 47 μs.  
GenericLinkedList:rotateCollection2(10)  - run 39 - time taken: 48 μs.  
GenericLinkedList:rotateCollection2(10)  - run 40 - time taken: 46 μs.  
GenericLinkedList:rotateCollection2(10)  - run 41 - time taken: 46 μs.  
GenericLinkedList:rotateCollection2(10)  - run 42 - time taken: 46 μs.  
GenericLinkedList:rotateCollection2(10)  - run 43 - time taken: 46 μs.  
GenericLinkedList:rotateCollection2(10)  - run 44 - time taken: 46 μs.  
GenericLinkedList:rotateCollection2(10)  - run 45 - time taken: 46 μs.  
GenericLinkedList:rotateCollection2(10)  - run 46 - time taken: 45 μs.  
GenericLinkedList:rotateCollection2(10)  - run 47 - time taken: 46 μs.  
GenericLinkedList:rotateCollection2(10)  - run 48 - time taken: 46 μs.  
GenericLinkedList:rotateCollection2(10)  - run 49 - time taken: 44 μs.  
GenericLinkedList:rotateCollection2(10)  - run 50 - time taken: 44 μs.  
GenericArrayList:rotateCollection2(10) - average: 44 μs.  

Process finished with exit code 0
```
