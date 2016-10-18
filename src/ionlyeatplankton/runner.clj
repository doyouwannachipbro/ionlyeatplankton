(ns ionlyeatplankton.runner
  (:require [ionlyeatplankton.ui :refer :all :as ui]
            [ionlyeatplankton.game :refer :all :as game]
            [ionlyeatplankton.board :refer :all :as board])
  (:import [ionlyeatplankton.game Game]))

(declare setup-game play-game make-move end-game restart)

(defn start []
  (play-game (create-game 3 (setup-game))))

(defn- setup-game []
  (ui/show-welcome)
  (ui/show-game-choice-menu)
  (ui/get-number 4))

(defn- play-game [game]
  (if (= :inplay (state (.board game)))
    (recur (make-move game))
    (end-game (.board game))))

(defn- make-move [game]
  (ui/show-board (.board game))
  (take-turn game))

(defn- end-game [board]
  (show-board board)
  (if (= :winner (state board))
    (ui/show-winner (winner board))
    (ui/show-draw))
  (restart))

(defn- restart []
  (ui/show-restart-query)
  (if (= "y" (ui/get-line))
    (do (ui/show-restart-confirm)
        (ui/clear-screen)
        (start))))

