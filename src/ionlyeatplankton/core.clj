(ns ionlyeatplankton.core
  (:gen-class)
  (:require [ionlyeatplankton.runner :refer :all :as runner]))

(defn -main [& args]
  (runner/start))

