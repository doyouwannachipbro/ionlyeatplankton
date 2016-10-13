(ns ionlyeatplankton.runner
  (:use [ionlyeatplankton.ui :as ui]
        [ionlyeatplankton.players]
        [ionlyeatplankton.game :as game]
        [ionlyeatplankton.board :as board])
  (:import (ionlyeatplankton.game Game)))

(declare setup-game play-game make-move end-game restart)

(defn start []
  (let [new-game (Game. (create-board 3) (choose-game (setup-game)))]
    (play-game new-game)))

(defn- play-game [game]
  (if (= :inplay (game-state game))
     (recur (make-move game))
     (end-game game)))

(defn- setup-game []
  (ui/show-welcome)
  (ui/show-game-choice-menu)
  (ui/get-number 4))

(defn- make-move [game]
  (ui/show-board (.board game))
  (Game. (board/mark (.board game) (get-move game) (current-player game))
                       (reverse (.players game))))

(defn- end-game [game]
  (show-board (.board game))
  (if (= :winner (game-state game))
    (ui/show-winner (winner (.board game)))
    (ui/show-draw))
  (restart))

(defn- restart []
  (ui/show-restart-query)
  (if (= "y" (ui/get-line))
    (do (ui/show-restart-confirm)
        (ui/clear-screen)
        (start))))

