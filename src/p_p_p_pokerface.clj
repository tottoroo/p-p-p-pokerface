(ns p-p-p-pokerface)

(def replacements {\T 10 \J 11 \Q 12 \K 13 \A 14})

(defn rank [card]
  (let [[fst _] card]
    (if (Character/isDigit fst)
      (Integer/valueOf (str fst))
      (replacements fst))
    ))

(defn suit [card]
  (let [[_ snd] card]
    (str snd)))

(defn pair? [hand]
  (if
    (some #(= 2%) (vals (frequencies (map rank hand))))
      true
      false))

(defn three-of-a-kind? [hand]
  (if
    (some #(= 3%) (vals (frequencies (map rank hand))))
      true
      false))

(defn four-of-a-kind? [hand]
  (if
    (some #(= 4%) (vals (frequencies (map rank hand))))
      true
      false))

(defn flush? [hand]
  (if (= (count (set (map suit hand))) 1)
    true
    false))

(defn full-house? [hand]
  (if (and (three-of-a-kind? hand) (pair? hand))
    true
    false))

(defn two-pairs? [hand]
  (map pair? hand))

(defn straight? [hand]
  nil)

(defn straight-flush? [hand]
  nil)

(defn value [hand]
  nil)
