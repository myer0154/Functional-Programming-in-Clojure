(ns one-function-to-rule-them-all)

(defn concat-elements [a-seq]
  (reduce concat [] a-seq))

(defn str-cat [a-seq]
  (if (empty? a-seq)
    ""
    (let [add-space (fn [string1 string2]
                      (str string1 " " string2))]
      (reduce add-space a-seq))))

(defn my-interpose [x a-seq]
  (if (empty? a-seq)
    '()
    (let [add-spacer (fn [a b]
                       (conj a x b))]
      (reduce add-spacer [(first a-seq)] (rest a-seq)))))

(defn my-count [a-seq]
  (let [seq-count (fn [n elem]
                    (if (nil? elem)
                      n
                      (inc n)))]
    (reduce seq-count 0 a-seq)))

(defn my-reverse [a-seq]
  (if (empty? a-seq)
    '()
    (reduce conj '() a-seq)))

(defn min-max-element [a-seq]
  (if (empty? a-seq)
    []
    (let [track-min-max (fn [[min max] elem]
                          (let [[min max]
                                (if (< elem min)
                                  [elem max]
                                  [min max])]
                            (if (> elem max)
                              [min elem]
                              [min max])))]
      (reduce track-min-max [(first a-seq) (first a-seq)] a-seq))))

(defn insert [sorted-seq n]
  (cond
    (empty? sorted-seq)       (seq [n])
    (< n (first sorted-seq))  (apply conj [] n sorted-seq)
    :else (loop [a-seq sorted-seq
           new-seq []]
      (if (empty? a-seq)
        new-seq
        (cond
          (and (<= (first a-seq) n) (empty? (rest a-seq)))
            (conj new-seq (first a-seq) n)
          (and (<= (first a-seq) n) (>= (first (rest a-seq)) n))
            (apply conj new-seq (first a-seq) n (rest a-seq))
          :else (recur (rest a-seq) (conj new-seq (first a-seq))))))))


(defn insertion-sort [a-seq]
  [:-])

(defn parity [a-seq]
  [:-])

(defn minus [x]
  :-)

(defn count-params [x]
  :-)

(defn my-* [x]
  :-)

(defn pred-and [x]
  (fn [x] :-))

(defn my-map [f a-seq]
  [:-])