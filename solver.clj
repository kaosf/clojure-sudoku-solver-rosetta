(ns sudoku)

(defn retrieve [grid x y]
  (get (get grid y) x))

(defn store [grid x y n]
  (assoc grid y (assoc (get grid y) x n)))

(defn coordinates [grid x y]
  (let [n (.intValue (Math/sqrt (count grid)))
        zx (* n (quot x n))
        zy (* n (quot y n))]
    (for [x (range zx (+ zx n)) y (range zy (+ zy n))]
      [x y])))

(defn compatible? [grid x y n]
  (or
    (= n (retrieve grid x y))
    (and
      (zero? (retrieve grid x y))
      (every? #(and (not= n (retrieve grid % y)) (not= n (retrieve grid x %))) (range (count grid)))
      (every? #(not= n (retrieve grid (first %) (second %))) (coordinates grid x y)))))

(defn print-grid [grid]
  (doseq [y (range (count grid))]
    (doseq [x (range (count grid))]
      (print (retrieve grid x y) " ")
      (if (= (rem x 3) 2) (print " ")))
    (println)
    (if (= (rem y 3) 2) (println)))
  (println))

(defn solve [grid x y]
  (let [m (count grid)]
    (if (= y m)
      (print-grid grid)
      (doseq [n (range 1 (inc m))]
        (when (compatible? grid x y n)
          (let [new-grid (store grid x y n)]
            (if (= x (dec m))
              (solve new-grid 0 (inc y))
              (solve new-grid (inc x) y))))))))

(defn solve2 [grid]
  (solve
    (vec (map vec (partition 9 grid)))
    0 0))
