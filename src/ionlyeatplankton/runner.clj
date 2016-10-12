(ns ionlyeatplankton.runner
  (:use [ionlyeatplankton.ui :as ui]
        [ionlyeatplankton.players]
        [ionlyeatplankton.game :as game]
        [ionlyeatplankton.board :as board])
  (:import (ionlyeatplankton.game Game)))

(declare play-game)

(defn start []
  (ui/show-welcome)
  (ui/show-game-choice-menu)
  (let [new-game (Game. (create-board 3) [human human])]
    (show-winner (winner (.board (play-game new-game))))))

(defn- play-game [game]
  (let [gamestate (game/game-state game)]
    (if (= :inplay gamestate)
      (do (ui/show-board (.board game))
          (recur (Game. (board/mark (.board game) (get-move game) (current-player game))
                        (reverse (.players game)))))
      (do (show-board (.board game)) game))))
