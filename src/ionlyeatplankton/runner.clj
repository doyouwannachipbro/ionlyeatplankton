(ns ionlyeatplankton.runner
  (:require [ionlyeatplankton.ui :refer :all :as ui]
            [ionlyeatplankton.game :refer :all :as game])
  (:import [ionlyeatplankton.game Game]))

(declare setup-game play-game make-move end-game restart)

(defn start []
  (play-game (create-game 3 (setup-game))))

(defn- setup-game []
  (ui/show-welcome)
  (ui/show-game-choice-menu)
  (ui/get-number 4))

(defn- play-game [game]
  (if (inplay? game)
    (recur (make-move game))
    (end-game game)))

(defn- make-move [game]
  (ui/show-board (.board game))
  (take-turn game))

(defn- end-game [game]
  (show-board (.board game))
  (if (has-winner? game)
    (ui/show-winner (get-winner game))
    (ui/show-draw))
  (restart))

(defn- restart []
  (ui/show-restart-query)
  (if (= "y" (ui/get-line))
    (do (ui/show-restart-confirm)
        (ui/clear-screen)
        (start))))

