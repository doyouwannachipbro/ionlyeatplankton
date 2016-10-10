(ns ionlyeatplankton.ui
  (:use [ionlyeatplankton.board]
        [clojure.string :only (join)]))

(defn- show-row [row]
  (str " " (join " | " row) " "))

(defn create-rows [board]
  (map show-row (into [] (partition (width board) board))))

(defn show-board [board]
  (doseq [row (interpose "-----------" (create-rows board))]
    (println row)))


