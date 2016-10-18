(ns ionlyeatplankton.computer
  (:require [ionlyeatplankton.board :refer :all :as board]
            [ionlyeatplankton.ui :refer [show-computer-thinking] :as ui]))

(declare best-move choose-random-corner score-move opponent opponent-score score add-delay)

(defn get-best-move [board mark]
  (add-delay 600)
  (if (= (count (board/available-moves board)) (board/size board))
    (choose-random-corner board)
    (last (best-move board mark))))

(defn add-delay [time]
  (ui/show-computer-thinking)
  (Thread/sleep time))

(defn- best-move [board player]
  (let [scoredMoves (map (fn [move] (score-move board player move)) (available-moves board))]
    (apply max-key first (reverse scoredMoves))))

(def best-move (memoize best-move))

(defn- score-move [board player move]
  (let [next-board (mark board move player)
        scored-move (score next-board)]
    (case (state next-board)
      :draw [0 move]
      :inplay [(- (opponent-score next-board player)) move]
      :winner (if (= (winner next-board) player) [scored-move move] [(- scored-move) move]))))

(defn- opponent-score [board player]
  (let [[score _] (best-move board (opponent player))]
    score))

(defn- score [board]
  (+ (count (available-moves board)) 50))

(defn- opponent [mark]
  (case (.mark mark)
    :X O
    :O X))

(defn- choose-random-corner [board]
  (let [width (board/width board)
        size (board/size board)]
    (first (shuffle [0 (dec width) (- size width) (dec size)]))))
