(ns ionlyeatplankton.board
  (:use [clojure.math.numeric-tower :only (sqrt) :as math]))

(defn create-board [n]
  (vec (range 1 (inc (* n n)))))

(defn size [board]
  (count board))

(defn width [board]
  (math/sqrt (count board)))

