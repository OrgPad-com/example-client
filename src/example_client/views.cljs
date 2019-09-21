(ns example-client.views
  (:require [re-frame.core :as re-frame]
            [example-client.subs :as subs]))

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div
     [:h1 "This is an example application for " @name]
     "Feel free to do some experiments to get used to it!"]))
