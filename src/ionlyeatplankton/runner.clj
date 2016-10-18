(ns ionlyeatplankton.runner
  (:require [ionlyeatplankton.ui :refer :all :as ui]
            [ionlyeatplankton.game :refer :all :as game])
  (:import [ionlyeatplankton.game Game]))

(declare setup-game play-game play-turn end-game restart)

(defn start []
  (play-game (game/create-game 3 (setup-game))))

(defn- setup-game []
  (ui/show-welcome)
  (ui/show-game-choice-menu)
  (ui/get-number 4))

(defn- play-game [game]
  (if (game/inplay? game)
    (recur (play-turn game))
    (end-game game)))

(defn- play-turn [game]
  (ui/show-board (.board game))
  (game/take-turn game))

(defn- end-game [game]
  (ui/show-board (.board game))
  (if (game/has-winner? game)
    (ui/show-winner (game/get-winner game))
    (ui/show-draw))
  (restart))

(defn- restart []
  (ui/show-restart-query)
  (if (= "y" (ui/get-line))
    (do (ui/show-restart-confirm)
        (ui/clear-screen)
        (start))))

