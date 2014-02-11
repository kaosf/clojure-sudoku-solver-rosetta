# Clojure Sudoku Solver

## Usage

Launch REPL by `lein repl` and input following code;

```clj
user> (ns sudoku)
sudoku> (load "solver")

sudoku> (solve2 [
          3 9 4 0 0 2 6 7 0
          0 0 0 3 0 0 4 0 0
          5 0 0 6 9 0 0 2 0
          0 4 5 0 0 0 9 0 0
          6 0 0 0 0 0 0 0 7
          0 0 7 0 0 0 5 8 0
          0 1 0 0 6 7 0 0 8
          0 0 9 0 0 8 0 0 0
          0 2 6 4 0 0 7 3 5])
3  9  4   8  5  2   6  7  1
2  6  8   3  7  1   4  5  9
5  7  1   6  9  4   8  2  3

1  4  5   7  8  3   9  6  2
6  8  2   9  4  5   3  1  7
9  3  7   1  2  6   5  8  4

4  1  3   5  6  7   2  9  8
7  5  9   2  3  8   1  4  6
8  2  6   4  1  9   7  3  5


nil
```

## References

* [Sudoku - Rosetta Code](http://rosettacode.org/wiki/Sudoku#Clojure)

## Tips

How to print "stack-trace"

```clj
(require 'clojure.stacktrace)
(clojure.stacktrace/print-stack-trace *e 10)
```

ref. [clojureのreplでstacktraceを見る - エンジニアですよ！](http://totem3.hatenablog.jp/entry/2013/10/22/055734)

## License

[MIT](http://opensource.org/licenses/MIT)

Copyright 2014 ka
