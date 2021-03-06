(ns wc-api-clj.v3.orders
  "Helper functions to communicate with the WooCommerce REST API's orders endpoints.
  These functions need authentication by `consumer_key` and `consumer_secret`.</br>
  https://woocommerce.github.io/woocommerce-rest-api-docs/#orders"
  (:require [wc-api-clj.core :as woo]
            [wc-api-clj.util :as util]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Orders REST API v3 helper functions ;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn create-order
  "Create order(s)."
  [{:keys [url consumer_key consumer_secret body exception insecure]}]
  (try (woo/post-req {:siteurl url
                      :uri "/wp-json/wc/v3/orders"
                      :username consumer_key
                      :password consumer_secret
                      :body body
                      :exception (not (not exception))
                      :insecure (not (not insecure))})
       (catch clojure.lang.ExceptionInfo e (str (.getMessage e)))))

(defn get-order-by-id
  "Retrieve an order by the order's ID."
  [{:keys [url consumer_key consumer_secret order exception insecure]}]
  (try (woo/get-req {:siteurl url
                     :uri (str "/wp-json/wc/v3/orders/" order)
                     :username consumer_key
                     :password consumer_secret
                     :exception (not (not exception))
                     :insecure (not (not insecure))})
       (catch clojure.lang.ExceptionInfo e (str (.getMessage e)))))

(defn get-orders
  "Retrieve all orders."
  [{:keys [url consumer_key consumer_secret exception insecure]}]
  (try (woo/get-req {:siteurl url
                     :uri "/wp-json/wc/v3/orders/"
                     :username consumer_key
                     :password consumer_secret
                     :exception (not (not exception))
                     :insecure (not (not insecure))})
       (catch clojure.lang.ExceptionInfo e (str (.getMessage e)))))

(defn update-order-by-id
  "Update an order by the order's ID."
  [{:keys [url consumer_key consumer_secret order body exception insecure]}]
  (try (woo/post-req {:siteurl url
                      :uri (str "/wp-json/wc/v3/orders/" order)
                      :username consumer_key
                      :password consumer_secret
                      :body body
                      :exception (not (not exception))
                      :insecure (not (not insecure))})
       (catch clojure.lang.ExceptionInfo e (str (.getMessage e)))))

(defn delete-order-by-id
  "Delete an order by the order's ID."
  [{:keys [url consumer_key consumer_secret order exception insecure]}]
  (try (woo/delete-req {:siteurl url
                        :uri (str "/wp-json/wc/v3/orders/" order (util/edn-to-query-str {:force true}))
                        :username consumer_key
                        :password consumer_secret
                        :exception (not (not exception))
                        :insecure (not (not insecure))})
       (catch clojure.lang.ExceptionInfo e (str (.getMessage e)))))

(defn orders-batch-operations
  "CRUD multiple products in a batch."
  [{:keys [url consumer_key consumer_secret body exception insecure]}]
  (try (woo/post-req {:siteurl url
                      :uri "/wp-json/wc/v3/orders/batch"
                      :username consumer_key
                      :password consumer_secret
                      :body body
                      :exception (not (not exception))
                      :insecure (not (not insecure))})
       (catch clojure.lang.ExceptionInfo e (str (.getMessage e)))))
