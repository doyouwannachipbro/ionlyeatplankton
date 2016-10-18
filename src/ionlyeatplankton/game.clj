(ns ionlyeatplankton.game
  (:require [ionlyeatplankton.board :refer :all :as board]
            [ionlyeatplankton.players :refer :all :as players]))

(declare count-marks player-mark player-move)

(defrecord Game [board move-functions])

(defn create-game [board-size game-type]
  (Game. (board/create-board board-size) (players/choose-game game-type)))

(defn take-turn [game]
  (Game. (board/mark (.board game) (player-move game) (player-mark game))
         (reverse (.move-functions game))))

(defn inplay? [game]
  (= :inplay (board/state (.board game))))

(defn has-winner? [game]
  (= :winner (board/state (.board game))))

(defn get-winner [game]
  (winner (.board game)))

(defn- player-mark [game]
  (let [num-x (count-marks X (.board game))
        num-o (count-marks O (.board game))]
    (if (< num-o num-x)
      O
      X)))

(defn- player-move [game]
  ((first (.move-functions game)) (.board game) (player-mark game)))

(defn- count-marks [mark game]
  (count (filter (partial = mark) game)))
