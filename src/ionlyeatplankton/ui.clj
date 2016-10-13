(ns ionlyeatplankton.ui
  (:use [ionlyeatplankton.board :as board]
        [clojure.string :only (join)]))

(declare show-row create-rows show-cell ansi-styles ansi colorize add-indexes)

(defn show-board [board]
  (doseq [row (interpose "---|---|---" (create-rows board))]
    (println row)))

(defn show-welcome []
  (println "Welcome to TicTacToe\n"))

(defn show-game-choice-menu []
  (println (str "Please choose the game type:\n"
                "1) Human vs Human\n"
                "2) Human vs Computer\n"
                "3) Computer vs Human\n"
                "4) Computer vs Computer\n")))

(defn show-invalid-selection []
  (println "Please make a selection from the options presented"))

(defn show-move-instructions []
  (println "Mark the board by selecting a number from 1-9\n"))

(defn show-draw []
  (println "It's a draw!"))

(defn show-winner [mark]
  (println (str (name (.mark mark)) " is the winner!")))

(defn show-restart []
  (println "Press 'y' to play again, or any other key to exit."))

(defn clear-screen []
  (println "\033[H\033[2J"))

(defn get-number [max]
   (let [input (clojure.string/trim (read-line))]
     (if (not (contains? (set (map str (range 1 (inc max)))) input))
       (show-invalid-selection)
       (read-string input))))

;;; private methods

(defn- show-row [row]
    (str " " (join " | " (map show-cell row)) " "))

(defn- create-rows [board]
  (map show-row (into [] (partition (width board) (add-indexes board)))))

(defn- add-indexes [board]
  (map-indexed (fn [index value] (vector (inc index) value)) board))

(defn- show-cell [cell]
  (cond
    (= ionlyeatplankton.board.Mark (type (last cell)))
      (do (if (= :X (.mark (last cell)))
        (colorize "X" :red)
        (colorize "O" :blue)))
    :else (colorize (first cell) :white)))

(defn- colorize [text color]
  (str (ansi color) text (ansi :reset)))

(def ^:private ansi-styles
  {:red   "[31m"
   :blue  "[34m"
   :white "[37m"
   :reset "[0m"})

(defn- ansi [style]
  (str \u001b (style ansi-styles)))
