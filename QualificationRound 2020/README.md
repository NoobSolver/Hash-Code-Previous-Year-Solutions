Hashcode 2020 solution (Qualification round)
Our solution for the 2020 Google Hashcode qualification round problem with libraries and books.

Hashcode Logo

Results
File	Score
a_example (input | output)	21
b_read_on (input | output)	5,822,900
c_incunabula (input | output)	5,645,747
d_tough_choices (input | output)	4,812,730
e_so_many_books (input | output)	5,019,670
f_libraries_of_the_world (input | output)	5,240,161
Total	26,541,229
The problem
You can find the pdf with the problem here.

Hashcode 2020 problem

Our solution
The code for the solution is in main.py. Our approach was a greedy algorithm.

The solution follows these steps:

Read the input

Calculate a heuristic score for each library with this formula:

library_score = library_books_score / library_signup_days

where library_books_score is calculated like this:

Calculate available days for this library:
library_available_days = all_days - library_signup_days

Count how many books can be scanned in these days:
k = library_available_days * library_maximum_books_scanned_per_day

Get the top k books according to their score and sum their scores. This is the library_books_score.
Sort libraries according to their score

For every library in sorted order:

Count how many books from this library (k) can be scanned, like in steps 2i and 2ii, but now take into account the number of signup days from the previous libraries. So if the previous libraries have taken d total days for the signup, then the formula from the step 2i becomes:
library_available_days = all_days - library_signup_days - d

From the books of this library, except the books that have already been scanned from the previous libraries, get the top k books according to their score and scan them.
Create the output

An improvement
You can find an improvement of this solution (total score: 26,922,702) in this repository:
https://github.com/tipavlos/Hashcode-2020-solution-Qualification-round

Our team
Athanasios Bollas (Thanasis1101)
Dimitrios Sviggas (lookatme3)
Anastasios Temperekidis (Tasos Temp)
Pavlos Tiritiris (tipavlos)
