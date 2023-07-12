(ns example-client.views
  (:require [re-frame.core :as rf]))

(def symbols
  {:player1 "X"
   :player2 "O"})

(def color
  {:player1 "salmon"
   :player2 "skyblue"})

(defn field [x y]
  (let [val @(rf/subscribe [:field x y])]
    [:div.field {:style {:background-color (color val)}
                 :on-click (when-not val
                             #(rf/dispatch [:field x y]))}
     (symbols val)]))

(defn board
  []
  [:div.board
   (for [y (range 3)
         x (range 3)]
     [field x y])])

(defn reset []
  [:div.reset {:on-click #(rf/dispatch [:reset])} "Reset"])

(defn state []
  (let [won @(rf/subscribe [:won])]
    (when won
      [:div "Congratulation: " (name won)])))

(defn main-panel []
  [:div.game
   [reset]
   [state]
   [board]])
