(ns example-client.core
  (:require [reagent.dom :as r-dom]
            [re-frame.core :as rf]
            [example-client.subs]
            [example-client.views :as views]
            [example-client.events]))

(defn mount-root []
  (rf/clear-subscription-cache!)
  (r-dom/render [views/main-panel]
                (.getElementById js/document "app")))

(defn init []
  (rf/dispatch-sync [:events/initialize-db])
  (mount-root))