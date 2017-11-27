# Turing Machine (only multiplication)

**A easy implementation of the turing machine**

More about the turing machine: <https://en.wikipedia.org/wiki/Turing_machine>

*Fork me on Github: <https://github.com/pandermatt/turing-machine>*

## Demo

<iframe width="560" height="315" src="https://www.youtube.com/embed/aHOqqASOnk4" frameborder="0" gesture="media" allowfullscreen></iframe>

![Demo](demo.gif)

### Keynote

[Keynote (in german)](https://github.com/pandermatt/turing-machine/blob/master/keynote.tpp)

Made with [TPP](https://github.com/cbbrowne/tpp)

## Implementation

* with Java
* 3 Tapes
```
//Tapes on first run
Tape 1: [0, 0, 0, 1, 0, 0]  //3*2
Tape 2: [ ]
Tape 3: [ ]
```
* Step Mode 🐢  and Fast Mode 🐇

## How to run

- Multiplication: `2*6`
- Step Mode 🐢: shows every step 
    - `1` enable step mode
    - `0` disable step mode
- Fast Mode 🐇: disable all `System.out.println`
    - `1` enable fast mode
    - `0` disable fast mode
- Infinity Tape ⏩
    - `1` print as infinity tape
    - `0` print only content
- Timeout ⏰
    - timeout between the step
```
java Main [multiplication] [step mode] [fast mode] [infinity tape] [timeout]

java Main "2*6" 1
```

## Contributors

- [Stefan Brunner](https://github.com/thecoder95)
- Ralph Meier
- [Pascal Andermatt](https://github.com/pandermatt)
