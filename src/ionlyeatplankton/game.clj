(ns ionlyeatplankton.game
  (:use [ionlyeatplankton.board]))

(declare count-marks)

(defn create-game [board]
  board)

(defn current-player [game]
  (let [num-x (count-marks X game) num-o (count-marks O game)]
    (if (< num-o num-x)
    O
    X)))

(defmulti game-state (fn [game] [(full? game) (type (winner game))]))
(defmethod game-state [true ionlyeatplankton.board.Mark] [game] :winner)
(defmethod game-state [false ionlyeatplankton.board.Mark] [game] :winner)
(defmethod game-state [true clojure.lang.Keyword] [game] :draw)
(defmethod game-state [false clojure.lang.Keyword] [game] :inplay)

(defn- count-marks [mark game]
  (count (filter (partial = mark) game)))

