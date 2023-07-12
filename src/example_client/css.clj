(ns example-client.css)

(def styles
  (list
    [:.game {:display :flex
             :flex-direction :column}]
    [:.board {:display               :grid
              :grid-template-columns [["1fr" "1fr" "1fr"]]
              :grid-template-rows    [["1fr" "1fr" "1fr"]]
              :width                 "100px"
              :height                "100px"
              :border                "1px solid"}]
    [:.field {:display          :flex
              :margin           "4px"
              :align-self       "center"
              :justify-self     "center"
              :background-color "lightgray"
              :width            "20px"
              :height           "20px"}]
    [:.reset {:background-color "skyblue"
              :padding "5px"}]))