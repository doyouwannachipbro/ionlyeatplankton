(ns ionlyeatplankton.ui
  (:use [ionlyeatplankton.board :as board]
        [clojure.string :only (join)]))

(declare show-row create-rows show-cell)

(defn show-board [board]
  (doseq [row (interpose "---|---|---" (create-rows board))]
    (println row)))

(defn- show-row [row]
    (str " " (join " | " (map show-cell row)) " "))

(defn- create-rows [board]
  (map show-row (into [] (partition (width board) board))))

(defn- show-cell [cell]
  (cond
    (= ionlyeatplankton.board.Mark (type cell))
      (do (if (= :X (.mark cell))
            "X"
            "O"))
    :else cell))
