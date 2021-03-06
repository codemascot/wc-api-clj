(ns wc-api-clj.util-test
  (:require [clojure.test :refer :all]
            [clojure.data.json :as json]
            [wc-api-clj.util :as util]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Testing Utility Functions ;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(deftest is-url-utility-function-test
  (testing "Testing `is-url` utility functions."
    (is (= true (util/is-url "https://www.example.com/")))
    (is (= true (util/is-url "https://www.example.com")))
    (is (= true (util/is-url "https://example.com/")))
    (is (= true (util/is-url "https://example.com")))
    (is (= true (util/is-url "http://www.example.com/")))
    (is (= true (util/is-url "http://www.example.com")))
    (is (= true (util/is-url "http://example.com/")))
    (is (= true (util/is-url "http://example.com")))
    (is (= false (util/is-url "www.example.com/")))
    (is (= false (util/is-url "www.example.com")))
    (is (= false (util/is-url "example.com/")))
    (is (= false (util/is-url "example.com")))
    (is (= false (util/is-url "http://www.example.com///")))
    (is (= false (util/is-url "http://www.example.com//")))
    (is (= false (util/is-url "http://example.com///")))
    (is (= false (util/is-url "http://example.com//")))))

(deftest edn-to-query-str-utility-function-test
  (testing "Testing `edn-to-query-str` utility functions."
    (is (= "?force=true&id=34&post_type=page"
           (util/edn-to-query-str {:force true :id 34 :post_type "page"})))))
