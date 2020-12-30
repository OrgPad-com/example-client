(ns example-client.subs
  (:require [re-frame.core :as rf]))

(rf/reg-sub
  ::name
  (fn [db]
    (:name db)))

(rf/reg-sub
  :current-color
  (fn [db]
    (:current-color db)))

(rf/reg-sub
  :title-color
  (fn [db]
    (:title-color db)))