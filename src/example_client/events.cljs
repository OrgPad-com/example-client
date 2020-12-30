(ns example-client.events
  (:require [re-frame.core :as rf]
            [example-client.db :as db]))

(rf/reg-event-db
  ::initialize-db
  (fn [_ _]
    db/default-db))

(def next-color
  {:blue  :red
   :red   :green
   :green :pink
   :pink :blue})

(rf/reg-event-db
  :button/toggle-colors
  (fn [db _]
    (let [current (:current-color db)
          next (next-color current)]
      (assoc db :current-color next))))

(rf/reg-event-db
  :update-title-color
  (fn [db [_ new-title-color]]
    (assoc db :title-color new-title-color)))