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

(defmulti game-state (fn [game] [(full? game) (winner game)]))

(defmethod game-state [true (or X O)] [game] :winner)
(defmethod game-state [false (or X O)] [game] :winner)
(defmethod game-state [true :no-winner] [game] :draw)
(defmethod game-state [false :no-winner] [game] :inplay)

(defn- count-marks [mark game]
  (count (filter (partial = mark) game)))

