(ns ionlyeatplankton.game
  (:use [ionlyeatplankton.board]
        [ionlyeatplankton.ui]
        [ionlyeatplankton.computer]
        [ionlyeatplankton.players]))

(declare count-marks)

(defrecord Game [board players])

(defn get-move [game]
  (cond
    (= :human (first (.players game))) (dec (get-number (count (.board game))))
    (= :computer (first (.players game))) (get-best-move (.board game))
    :else 5))

(defn current-player [game]
  (let [num-x (count-marks X (.board game)) num-o (count-marks O (.board game))]
    (if (< num-o num-x)
      O
      X)))

(defn- count-marks [mark game]
  (count (filter (partial = mark) game)))
