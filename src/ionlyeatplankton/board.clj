(ns ionlyeatplankton.board)

(defn create-board [n]
  (vec (range 1 (inc (* n n)))))

(defn size [board]
  (count board))


