(ns example-client.core
  (:require [reagent.core :as reagent]
            [re-frame.core :as re-frame]
            [example-client.events :as events]
            [example-client.views :as views]))

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn init []
  (re-frame/dispatch-sync [::events/initialize-db])
  (mount-root))
