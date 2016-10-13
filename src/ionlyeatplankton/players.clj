(ns ionlyeatplankton.players)

(def human :human)
(def computer :computer)

(defn choose-game [selection]
  (case selection
    1 [human human]
    2 [human computer]
    3 [computer human]
    4 [computer computer]))
