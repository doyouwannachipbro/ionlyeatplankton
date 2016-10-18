(ns ionlyeatplankton.board
  (:require [clojure.math.numeric-tower :only (sqrt) :as math]))

(declare isMark? isEmpty? get-winning-mark combos rows columns diagonals get-diagonal winning-combination?)

(deftype Mark [mark])
(def X (Mark. :X))
(def O (Mark. :O))
(def ? :EMPTY)

(defn create-board [n]
  (vec (repeat (* n n) ?)))

(defn mark [board position mark]
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

(defn winner [board]
  (let [winning-mark (get-winning-mark board)]
    (if (= Mark (type winning-mark))
      winning-mark
      :no-winner)))

(defn state [board]
  (let [[full win-state] [(full? board) (winner board)]]
    (cond
      (= Mark (type win-state)) :winner
      (= full true) :draw
      :else :inplay)))

(defn- get-winning-mark [board]
  (first (distinct (flatten (filter winning-combination? (combos board))))))

(defn- winning-combination? [row]
  (or (every? #{X} row) (every? #{O} row)))

(defn- combos [board]
  (let [rows (rows board)]
    (reduce into [] [rows (columns rows) (diagonals rows)])))

(defn- rows [board]
  (partition (width board) board))

(defn- columns [rows]
  (apply map vector rows))

(defn- diagonals [rows]
  (vector
    (get-diagonal rows)
    (get-diagonal (map reverse rows))))

(defn- get-diagonal [rows]
  (map-indexed (fn [index row] (get (vec row) index)) rows))

(defn- isMark? [cell]
  (= (type cell) Mark))

(defn- isEmpty? [cell]
  (= cell ?))
