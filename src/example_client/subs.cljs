(ns example-client.subs
  (:require [re-frame.core :as rf]))

(rf/reg-sub
  :subs/current-player
  (fn [db]
    (:current-player db)))

(rf/reg-sub
  :subs/winner
  (fn [db]
    (:winner db)))

(rf/reg-sub
  :subs/position
  (fn [db]
    (:position db)))

(rf/reg-sub
  :subs/field
  :<- [:subs/position]
  (fn [position [_ [x y]]]
    (position [x y])))