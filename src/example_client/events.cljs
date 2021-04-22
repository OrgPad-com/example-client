(ns example-client.events
  (:require [re-frame.core :as rf]
            [example-client.db :as db]))

(rf/reg-event-db
  :events/initialize-db
  (fn [_ _]
    db/default-db))

(defn- line?
  [position [coord :as coords]]
  (and (apply = (map position coords))
       (position coord)))

(defn- win?
  [{:keys [position]}]
  (or (line? position [[0 0] [1 1] [2 2]])
      (line? position [[2 0] [1 1] [0 2]])
      (some (partial line? position)
            (for [x (range 3)]
              [[x 0] [x 1] [x 2]]))
      (some (partial line? position)
            (for [x (range 3)]
              [[0 x] [1 x] [2 x]]))))

(defn- test-win
  [{:keys [position] :as db}]
  (let [winner (win? db)]
    (if winner
      (assoc db :winner winner)
      db)))

(rf/reg-event-db
  :events/turn
  (fn [{:keys [current-player] :as db} [_ [x y]]]
    (-> db (assoc-in [:position [x y]] current-player)
        (assoc :current-player (if (= current-player :player1)
                                 :player2
                                 :player1))
        (test-win))))

