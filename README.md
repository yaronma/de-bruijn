# de-bruijn
A friend brought me a 4-digit code locked present. The first thought was to brute-force the keypad. This would require entering 10,000 sequences of 4 numbers [0000..9999]. I thought there must be a better solution. This is how I got to De-Bruijn Sequences. 

De-Bruijn Sequences are a long sequence of symboles over a predefined alphabet that produce all the permustation for specified length.

The De-Bruijn sequence of length 4 on the numeric alphabet [0..9] is 10,003 long, which means that I need to do only (?) 10,003 keypresses and not 40,000. Than's a nice improvement!

The code in this repo is for checking De-Bruijn sequence for correctness by concerting a De-Bruijn String into a stream of permutations and validating that all the possible permutations are included.

(Luckly my freind didn't use any terminating symbole like # or *. That would have make this effort useless)

Now I have to build a robotic arm that can do the keypresses automativally... ;-)
