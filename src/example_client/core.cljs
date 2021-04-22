(ns example-client.core
  (:require [reagent.core :as r]
            [re-frame.core :as rf]
            [example-client.events :as events]
            [example-client.views :as views]))

(defn mount-root []
  (rf/clear-subscription-cache!)
  (r/render [views/main-panel]
            (.getElementById js/document "app")))

(defn init []
  (rf/dispatch-sync [:events/initialize-db])
  (mount-root))
