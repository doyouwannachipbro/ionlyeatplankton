(ns ionlyeatplankton.computer
  (:use [ionlyeatplankton.board]))

(declare best-move choose-random-corner score-move opponent opponent-score score)

(defn get-best-move [board mark]
  (Thread/sleep 500)
  (if (= (count (available-moves board)) (size board))
      (choose-random-corner board)
      (last (best-move board mark))))

(defn- best-move [board player]
  (let [scoredMoves (map (fn [move] (score-move board player move)) (available-moves board))]
    (reduce (fn [[score move] [best-score best-move]]
              (if (>= score best-score)
                [score move]
                [best-score best-move])) [-100 -1] scoredMoves)))

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
  (let [width (width board) size (size board)]
  (first (shuffle [0 (- width 1) (- size width) (- size 1)]))))