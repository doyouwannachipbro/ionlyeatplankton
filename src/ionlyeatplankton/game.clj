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

(defn- count-marks [mark game]
  (count (filter (partial = mark) game)))

