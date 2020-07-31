(ns example-client.events
  (:require [re-frame.core :as rf]
            [example-client.db :as db]))

(rf/reg-event-db
  :events/initialize-db
  (fn [_ _]
    db/default-db))
