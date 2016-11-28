# ngordnet

Josh Hug's UC Berkeley 61B course of Spring 2015.

This program analyzes the evolution of the English language used in written texts over time. It uses a small subset of Google's Ngram viewer: https://books.google.com/ngrams.

# Data:

A subset of The Ngram dataset provided by Google.
creativecommons.org/licenses/by/3.0/legalcode

The WordNet dataset provided by Princeton University.
wordnet.princeton.edu/wordnet/license/

The data sets can be downloaded from:
www.cs.berkeley.edu/~hug/p1data.zip

Frameworks:
Apache 2.0 open source xChart library by Xeiam.

# Run:
Run NgordnetUI class.

Use 'help' for a listing of the commands.

Make sure data is placed in the same directory as the ngordnet folder.




* The YearlyRecordProcessor interface found in the ngordnet package is for the process method. This method takes a YearlyRecord object (data structure that stores all of the words found in a given year and the number of times each word is found).

* The process method can be overwritten.
