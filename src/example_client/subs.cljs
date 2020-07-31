(ns example-client.subs
  (:require [re-frame.core :as rf]))

(rf/reg-sub
  :subs/name
  (fn [db]
    (:name db)))