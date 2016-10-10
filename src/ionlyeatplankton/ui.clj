(ns ionlyeatplankton.ui
  (:use [ionlyeatplankton.board :as board]
        [clojure.string :only (join)]))

(declare show-row create-rows show-cell ansi-styles ansi colorize)

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

; These methods break the tests because speclj does not work with colour output

(defn- colorize [text color]
  (str (ansi color) text (ansi :reset)))

(def ^:private ansi-styles
  {:red   "[31m"
   :blue  "[34m"
   :white "[37m"
   :reset "[0m"})

(defn- ansi [style]
  (str \u001b (style ansi-styles)))
