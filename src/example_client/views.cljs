(ns example-client.views
  (:require [re-frame.core :as rf]
            [example-client.subs :as subs]))

(def ^:private player-symbol
  {:player1 {:symbol "X"
             :color  "red"}
   :player2 {:symbol "O"
             :color "blue"}})

(defn- field [x y]
  (let [player @(rf/subscribe [:subs/field [x y]])
        {:keys [symbol color]} (player-symbol player)]
    [:div.field {:style    {:color color}
                 :on-click (when-not player
                             #(rf/dispatch [:events/turn [x y]]))} symbol]))

(defn main-panel []
  (let [current-player @(rf/subscribe [:subs/current-player])
        winner @(rf/subscribe [:subs/winner])]
    [:div
     (if winner
       [:div "Winner is " winner]
       [:div "Current player:" current-player])
     [:div.grid
      (for [x (range 3)
            y (range 3)]
        ^{:key (str x y)} [field x y])]
     [:div {:style {:padding-top 10}}
      [:button {:type     "button"
                :on-click #(rf/dispatch [:events/initialize-db])}
       "Reset!"]]]))
