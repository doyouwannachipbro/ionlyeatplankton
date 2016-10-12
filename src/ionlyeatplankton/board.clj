(ns ionlyeatplankton.board
  (:use [clojure.math.numeric-tower :only (sqrt) :as math]))

(declare isMark? isEmpty? get-winning-mark combos rows columns diagonals winning-combination?)

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

(defn- get-winning-mark [board]
  (first (distinct (flatten (filter winning-combination? (combos board))))))

(defn- winning-combination? [row]
  (or (every? #{X} row) (every? #{O} row)))

(defn- combos [board]
  (let [rows (rows board)]
    (reduce into [] (vector rows (columns rows) (diagonals rows)))))

(defn- rows [board]
  (partition (width board) board))

(defn- columns [rows]
  (apply map vector rows))

(defn- diagonals [rows]
  (vector
    (map-indexed (fn [index value] (get (vec value) index)) rows)
    (map-indexed (fn [index value] (get (vec (reverse value)) index)) rows)))

(defn- isMark? [cell]
  (= (type cell) Mark))

(defn- isEmpty? [cell]
  (= cell ?))
