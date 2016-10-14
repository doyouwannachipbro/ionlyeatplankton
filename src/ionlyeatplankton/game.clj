(ns ionlyeatplankton.game
  (:require [ionlyeatplankton.board :refer :all]
            [ionlyeatplankton.ui :refer :all]
            [ionlyeatplankton.computer :refer :all]
            [ionlyeatplankton.players :refer :all]))

(declare count-marks current-player)

(defrecord Game [board players])

(defn take-turn [game]
  ((first (.players game)) (.board game) (current-player game)))

(defn current-player [game]
  (let [num-x (count-marks X (.board game)) num-o (count-marks O (.board game))]
    (if (< num-o num-x)
      O
      X)))

(defn- count-marks [mark game]
  (count (filter (partial = mark) game)))
