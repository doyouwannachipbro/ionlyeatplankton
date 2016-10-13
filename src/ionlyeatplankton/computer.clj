(ns ionlyeatplankton.computer
  (:use [ionlyeatplankton.board]))

(defn get-best-move [board]
  (first (available-moves board)))
