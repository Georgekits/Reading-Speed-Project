# Reading-Speed-Project
Threads and Callables

Description

This project designs a java program that counts the number of characters in a large word file.
It basically compares runtime (System.nanoTime ()) between two versions of the same function:

    -->Counting a number of characters by serially running a String array (1 thread).
    -->Calculate number of characters using concurrent calculation in a String. It will break the array into more pieces
    and assign the same code to each thread (1 thread for each piece).
    
The file used for the project can be downloaded from:

    --> https://archive.org/download/2015_reddit_comments_corpus/reddit_data/2008/RC_2008-07.bz2
