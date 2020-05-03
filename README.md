# Algorithms 20290 Code repository 2019/20
This repository is a summary of my work throughout the Spring semester of the Academic year 2019/20 in the module Algorithms COMP20290. It is a combination of the algorithms I worked on during the weekly practical session. These algorithms include sorts, search and compression algorithms.

# Getting Started

### IDE or Text Editor
There are many Java IDE or text editors to choose from, this is up to you based on what you feel comfortable with.<br />
Personally, I prefer Eclipse for Java.<br />
[Downloading and using Eclipse](https://www.eclipse.org/downloads/)<br />

### Running Main.java
Open Eclipse, and create a new Java project.<br />
Right click the newly created src folder.<br />
Click Import..<br />
Click General -> File System -> Next.<br />
Click Browse..<br />
Browse to the folder that contains all the content of the repository.<br />
Select that folder.<br />
Tick all the files.<br />
Click Finish.<br />
Open and run Main.java.<br />

### Result / Basic Testing
Main.java is a class that allows you to access almost all the other classes in this repository, however it doesn't demonstarte all functionality. It provides basic tests for each algorithm to check that its running correctly with the most simple inputs. These operations in Main.java are not timed or analysed, deep analysis is down using the individual main methods for each class, then discussed in the docx for each practical **in red**. <br />

When you run Main.java a menu system pops up, you are promoted to select which program you want to run and test, the tests are all precoded and explained when executed. You can run as many test as you would like, 0 is entered to exit the program.<br />

# Contents
### Overview
- Main.java to quickly run and test all files.
- Each practical has its own java file named after it (Practical 3 and 9 have 2 files each).
- Practical two has its own folder 'Prac2' which contains all the files needed to run it.
- Practical nine has its own folder 'Prac9extras' which contains all the resultant files from running it i.e. bin files
- Each practical has its own filled in .docx file, it includes results analyis and answers to relevant short questions.

### Detailed
#### *Src Folder*
**Main.java**<br />
As explained in "Getting Started" above, Main.java is a class that allows you to access almost all the other classes in this repository, however it doesn't demonstarte all functionality. It provides basic tests for each algorithm to check that its running correctly with the most simple inputs.<br />
**Prac1.java**<br />
Implements the *Russian Peasant* Algorithm and tests it.<br />
**Prac1Doc.docx**<br />
Includes results analysis of the *Russian Peasant* code & relevant answered short questions.<br />
**Prac2Doc.docx**<br />
Includes results analysis of the *ThreeSum* code & relevant answered short questions.<br />
**Prac3a_fib.java**<br />
Implements the *Fibonacci numbers recurively & iteratively* and tests them.<br />
**Prac3b_hanoi.java**<br />
Implements the *Towers of Hanoi* and tests the algorithm.<br />
**Prac3Doc.docx**<br />
Includes results analysis of the *Fibonacci recursive & iterative* ways and the *tower of Hanoi* code & relevant answered short questions.<br />
**Prac4and5and6.java**<br />
Implements a menu based program to run: *Insertion Sort, Selection Sort, Bogo Sort, Merge Sort, Improved Merge Sort, Quick Sort and Improved Quick Sort*. The program allows you to test each sort with different sizes of inputs and times it.<br />
**Prac4Doc.docx**<br />
Includes results analysis of *Insertion Sort, Selection Sort and Bogo Sort* & relevant answered short questions.<br />
**Prac5Doc.docx**<br />
Includes results analysis of *Merge Sort and Improved Merge Sort* & relevant answered short questions.<br />
**Prac6Doc.docx**<br />
Includes results analysis of *Quick Sort and Improved Quick Sort* & relevant answered short questions.<br />
**Prac7.java**<br />
Implements substring seach algorithms: *Brute Force Method* and *Knuth Morris Pratt* Algorithm and tests them.<br />
**Prac7Doc.docx**<br />
Includes results analysis of the *Brute Force Method* and *Knuth Morris Pratt* Algorithm & relevant answered short questions.<br />
**Prac8.java**<br />
Implements a *Trie* using keys and searches for words in it. It is also tested extensively.<br />
**Prac8Doc.docx**<br />
Includes results analysis of the *Trie* code (insertion and search) & relevant answered short questions (Trie by hand).<br />
**Prac9.java**<br />
Implements *Run Length Encoding* algorithm and tests it.<br />
**Prac9b.java**<br />
An algorithm to compress and decompress files.<br />
**Prac9Doc.docx**<br />
Includes results analysis of the *Run Length Encoding* Algorithm & relevant answered short questions. It also includes the results of the file compressions done in Prac9b.java<br />
**BinaryStdIn.java and BinaryStdOut.java**<br />
Needed java files to be able to run *Run Length Encoding*, they support reading and writing binary data into the Standard input/output.<br />

#### *Prac2 Folder*
Includes the two implementations of *ThreeSum* and their dependencies and text files used to run them.<br />
In addition, the same *Prac2Doc.docx* from Src folder is present here.<br />

#### *Prac9extras Folder*
Includes all the dependencies, text files and bins used to run *RunLength.java*. Also includes the generated files in the process of compression/decompression.<br />
In addition, the same *Prac9Doc.docx* from Src folder is present here which elaborates on the results.<br />

#### *Assignment Folder*
**Huffman.java**<br />
The driver code that compresses adnd expands files using the huffman algorithm.<br />
Includes all the dependencies, text files and bins used to run *Huffman.java*, such as *BinaryDump.java, BinaryStdOut.java etc.*.<br /> 

**Other files**<br />
All original, compressed and decompressed files are in the folder. <br />
Compressed files' names end with "_comp", while decompressed end with "_decomp <br />
Includes an *AssignmentDoc.pdf* which elaborates on the results and algorithm build and perfromance.

# Notes
- The detailed tests are done in main in the java files, all you have to do is run them. Main.java *doesn't* include timed/extensive tests, please test each program through its own individual main in its java file.
- The word documents contains:
- - Results analysis of the code for each lab (Graphs, tables, etc.) (**In red**)
- - Some of them contain answered short questions about the relevant topic.


# Author 
Ahmed Jouda

# Acknowledgements
Dr. Mark Matthews lectures and notes<br />
Algorithms 4th Edition by Robert Sedgewick & Kevin Wayne
