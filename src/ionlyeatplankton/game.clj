(ns ionlyeatplankton.game
  (:use [ionlyeatplankton.board]
        [ionlyeatplankton.ui]
        [ionlyeatplankton.players]))

(declare count-marks)

(defrecord Game [board players])

(defn get-move [game]
  (cond
    (= :human (first (.players game))) (dec (get-number 9))
    (= :computer (first (.players game))) 1
    :else 5))

(defn current-player [game]
  (let [num-x (count-marks X (.board game)) num-o (count-marks O (.board game))]
    (if (< num-o num-x)
      O
      X)))

(defmulti game-state (fn [game] [(full? (.board game)) (winner (.board game))]))

(defmethod game-state [true (or X O)] [game] :winner)
(defmethod game-state [false (or X O)] [game] :winner)
(defmethod game-state [true :no-winner] [game] :draw)
(defmethod game-state [false :no-winner] [game] :inplay)

(defn- count-marks [mark game]
  (count (filter (partial = mark) game)))
