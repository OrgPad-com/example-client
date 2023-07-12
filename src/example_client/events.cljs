(ns example-client.events
  (:require [re-frame.core :as rf]
            [example-client.db :as db]))

(rf/reg-event-db
  :events/initialize-db
  (fn [_ _]
    db/default-db))

(defn row?
  [board y]
  (and (get board [0 y])
       (apply = (map #(get board [% y]) [0 1 2]))))

(defn column?
  [board x]
  (and (get board [x 0])
       (apply = (map #(get board [x %]) [0 1 2]))))

(defn diag?
  [board]
  (and (get board [1 1])
       (or (= (get board [0 0])
              (get board [1 1])
              (get board [2 2]))
           (= (get board [2 0])
              (get board [1 1])
              (get board [0 2])))))

(rf/reg-event-db
  :field
  (fn [{:keys [current-player board won] :as db} [_ x y]]
    (let [updated-board (assoc board [x y] current-player)
          new-won (or (some #(row? updated-board %) [0 1 2])
                      (some #(column? updated-board %) [0 1 2])
                      (diag? updated-board))]
      (if won
        db
        (-> db (assoc :board updated-board)
            (assoc :current-player (if (= current-player :player1)
                                     :player2
                                     :player1))
            (assoc :won (when new-won current-player)))))))

(rf/reg-event-db
  :reset
  (fn [_]
    {:board          {}
     :current-player :player1}))
