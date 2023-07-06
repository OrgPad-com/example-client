(defproject example-client "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [org.clojure/clojurescript "1.11.60"
                  :exclusions [com.google.javascript/closure-compiler-unshaded
                               org.clojure/google-closure-library]]
                 [thheller/shadow-cljs "2.24.1"]
                 [reagent "1.2.0"]
                 [re-frame "1.3.0"]
                 [garden "1.3.10"]]

  :plugins [[lein-garden "0.3.0"]]

  :garden {:builds [{:id           "example-client"
                     :source-paths ["src"]
                     :stylesheet   example-client.css/styles
                     :compiler     {:output-to     "resources/public/css/site.css"
                                    :pretty-print? true}}]}

  :min-lein-version "2.5.3"

  :source-paths ["src"]

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"]


  :less {:source-paths ["less"]
         :target-path  "resources/public/css"}

  :aliases {"dev"  ["with-profile" "dev" "run" "-m" "shadow.cljs.devtools.cli" "watch" "app"]
            "prod" ["with-profile" "prod" "run" "-m" "shadow.cljs.devtools.cli" "release" "app"]}

  :profiles
  {:dev
   {:dependencies [[binaryage/devtools "0.9.10"]]}

   :prod { }
   })
