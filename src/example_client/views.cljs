(ns example-client.views
  (:require [re-frame.core :as rf]
            [example-client.subs :as subs]))

(def colors
  {:blue  {:button-color    "navy"
           :button-bg-color "lightblue"}
   :red   {:button-color    "red"
           :button-bg-color "lightsalmon"}
   :green {:button-color    "darkgreen"
           :button-bg-color "lightgreen"}
   :pink  {:button-color    "purple"
           :button-bg-color "pink"}})

(defn- tlacitko
  []
  (let [current-color @(rf/subscribe [:current-color])
        {:keys [button-color button-bg-color]} (colors current-color)]
    [:div.button {:on-click #(rf/dispatch [:button/toggle-colors])
                  :style    {:background-color button-bg-color
                             :color            button-color
                             :font-weight      "bold"
                             :display          "inline-block"
                             :padding          5
                             :border           (str "1px solid " button-color)}}
     "Tlačítko"]))

(defn main-panel []
  (let [name (rf/subscribe [::subs/name])
        title-color @(rf/subscribe [:title-color ])]
    [:div
     [:h1 {:style {:color title-color}}
      "This is an example application for " @name]
     "Feel free to do some experiments to get used to it!"
     [:div
      [tlacitko]]
     [:input {:value title-color
              :on-change #(rf/dispatch [:update-title-color
                                        (-> % .-target .-value)])}]]))
