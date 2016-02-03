# De-Bruijn Sequence
A friend brought me a 4-digit code-locked present. My first thought was to brute-force the keypad. This would require entering 10,000 sequences of 4 numbers [0000..9999]. I thought there must be a better solution. This is how I got to De-Bruijn Sequences. 

De-Bruijn Sequence is a long sequence of symbols over a predefined alphabet that produces all the permutation of specified length.

The De-Bruijn sequence of length 4 on the numeric alphabet [0..9] is 10,003 digits long, which means that I need to do only (?) 10,003 keypresses and not 40,000. That's a nice improvement!

The code in this repo is for checking De-Bruijn sequence for correctness by converting a De-Bruijn Sequence into a stream of permutations and validating that all the possible permutations are included.

(My freind didn't use any terminating symbol like # or *. That would have made this effort useless)

Now I have to build a robotic device that can do the keypresses automatically... ;-)
