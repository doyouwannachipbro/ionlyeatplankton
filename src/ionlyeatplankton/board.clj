(ns ionlyeatplankton.board
  (:use [clojure.math.numeric-tower :only (sqrt) :as math]))

(deftype Mark [mark])
(def X (Mark. :X))
(def O (Mark. :O))

(defn create-board [n]
  (vec (range 1 (inc (* n n)))))

(defn mark [position mark board]
  (assoc board position mark))

(defn size [board]
  (count board))

(defn width [board]
  (math/sqrt (count board)))

(defn to-vector [board]
  board)
