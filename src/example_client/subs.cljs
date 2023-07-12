(ns example-client.subs
  (:require [re-frame.core :as rf]))

(rf/reg-sub
  :board
  (fn [db]
    (:board db)))

(rf/reg-sub
  :field
  (fn [_]
    (rf/subscribe [:board]))
  (fn [board [_ x y]]
    (get board [x y])))

(rf/reg-sub
  :won
  (fn [db]
    (:won db)))