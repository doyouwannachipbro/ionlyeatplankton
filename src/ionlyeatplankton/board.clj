(ns ionlyeatplankton.board
  (:use [clojure.math.numeric-tower :only (sqrt) :as math]))

(declare isMark? isEmpty?)

(deftype Mark [mark])
(def X (Mark. :X))
(def O (Mark. :O))
(def EMPTY :EMPTY)

(defn create-board [n]
  (vec (repeat (* n n) EMPTY)))

(defn mark [position mark board]
  (assoc board position mark))

(defn size [board]
  (count board))

(defn width [board]
  (math/sqrt (count board)))

(defn full? [board]
  (every? isMark? board))

(defn to-vector [board]
  board)

(defn available-moves [board]
  (map first (filter (comp isEmpty? last) (map-indexed vector board))))

(defn winner? [board]
   distinct (partition (width board) board))

(defn- isMark? [cell]
  (= (type cell) Mark))

(defn- isEmpty? [cell]
  (= cell EMPTY))
