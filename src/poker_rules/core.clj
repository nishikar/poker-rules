(ns poker-rules.core
  (:gen-class))


(defn is_flush
  ""
  [suits]
  (= (count (set suits)) 1))


(defn is_n_of_a_kind
  ""
  [rank_frequencies n]
  (contains? (set (vals rank_frequencies)) n))


(defn is_full_house
  ""
  [rank_frequencies]
  (def fv (set (vals rank_frequencies)))
  (and (contains? fv 3) (contains? fv 2)))


(defn is_n_pair
  ""
  [rank_frequencies n]
  (def ff (frequencies (vals rank_frequencies)))
  (= (ff 2) n))


(defn is_straight 
  ""
  [ranks]
  (def sr (sort ranks))
  (if (= (- (nth sr 4) (nth sr 0)) 4)
    true
    (and (= (nth sr 0) 1) (= (nth sr 1) 10) (= (nth sr 2) 11) (= (nth sr 3) 12) (= (nth sr 4) 13)))
  )


(defn is_straight_flush
  ""
  [ranks suits]
  (and (is_straight ranks) (is_flush suits)))


(defn -main
  ""
  [& args]
  (def ranks [1 1 5 5 13])
  ;;(def ranks [1 13 10 11 12])
  (def suits [1 1 1 1 1])
  (def rank_frequencies (frequencies ranks))
  (println (is_n_of_a_kind rank_frequencies 4))
  (println (is_full_house rank_frequencies))
  (println (is_flush suits))
  (println (is_n_pair rank_frequencies 2))
  (println (is_straight ranks))
  (println (is_straight_flush ranks suits)))
