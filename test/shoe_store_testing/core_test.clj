(ns shoe-store-testing.core-test
  (:require [clojure.test :refer :all]
            [shoe-store-testing.core :refer :all]
            [webica.core :as w :refer [sleep]]
            [webica.by :as by]
            [webica.chrome-driver :as chrome]
            [webica.firefox-driver :as firefox]
            [webica.remote-web-driver :as browser]
            [webica.web-driver :as driver]
            [webica.web-driver-wait :as wait]
            [webica.web-element :as element]))

;; Uncomment whichever line corresponds with the running operating system
(def system-os
  {:os :win32})
  ;{:os :linux64})
  ;{:os :macosx})

(defn pull-descriptions
  "Pulls shoe_description text."
  []
  (let [shoe-descriptions (browser/find-elements-by-class-name "shoe_description")]
    (for [description shoe-descriptions]
      (element/get-text description))))

(defn pull-pictures
  "Pulls shoe_picture image."
  []
  (let [shoe-pictures (browser/find-elements-by-class-name "shoe_image")]
    (for [image shoe-pictures]
      (.toString (element/get-size image)))))

(defn pull-prices
  "Pulls shoe_price text."
  []
  (let [shoe-prices (browser/find-elements-by-class-name "shoe_price")]
    (for [price shoe-prices]
      (element/get-text price))))

(defn test-display
  "Tests the display of each shoe result."
  []
  ;; Checking to see if any individual box contains a blank value.
  (is (not-any? clojure.string/blank? (pull-descriptions)) "At least one description is missing.")
  ;; If the shoe_image returns a size of 0,0 then that means the image is not able to be seen.
  (is (nil? (some #{"(0, 0)"} (pull-pictures))) "At least one picture is missing.")
  (is (not-any? clojure.string/blank? (pull-prices)) "At least one price is missing.")
  ;; Checking to see if the whole collection returns nothing.
  (is (not-empty (pull-descriptions)))
  (is (not-empty (pull-pictures)))
  (is (not-empty (pull-prices))))


(deftest configure-test
  (testing "Should set system properties according to OS."
    (configure (:os system-os))
    (is (not-empty (System/getProperty "webdriver.chrome.driver")) "Chrome driver not found.")
    (is (not-empty (System/getProperty "webdriver.firefox.driver")) "Firefox driver not found.")
    (is (not-empty (System/getProperty "webdriver.gecko.driver")) "Firefox/Gecko driver not set.")))

(deftest start-browser-test
  (testing "Chrome browser should launch and close appropriately."
    (configure (:os system-os))
    (chrome/start-chrome)
    (wait/instance 10)
    (is (not (nil? (browser/instance))))
    (chrome/quit))
  (Thread/sleep 500)
  (testing "Firefox browser should launch and close appropriately."
    (firefox/start-firefox)
    (Thread/sleep 10)
    (is (not (nil? (browser/instance))))
    (firefox/quit)))

(defn january-display-test
  []
  (testing "Should return Description, Picture, and Pricing for January."
    (browser/get "http://shoestore-manheim.rhcloud.com/months/january")
    (wait/instance 10)
    (test-display)))

(deftest january-email-test
  (testing "Should receive successful message when e-mail is submitted."))

(deftest january-browser-test
  (testing "Testing browser compatibility for January."
    (let [_ (chrome/start-chrome)]
      (january-display-test)
      (chrome/quit))))


(defn february-display-test
  []
  (testing "Should return Description, Picture, and Pricing for February."
    (browser/get "http://shoestore-manheim.rhcloud.com/months/february")
    (wait/instance 10)
    (test-display)))

(defn march-display-test
  []
  (testing "Should return Description, Picture, and Pricing for March."
    (browser/get "http://shoestore-manheim.rhcloud.com/months/march")
    (wait/instance 10)
    (test-display)))

(defn april-display-test
  []
  (testing "Should return Description, Picture, and Pricing for April."
    (browser/get "http://shoestore-manheim.rhcloud.com/months/april")
    (wait/instance 10)
    (test-display)))

(defn may-display-test
  []
  (testing "Should return Description, Picture, and Pricing for May."
    (browser/get "http://shoestore-manheim.rhcloud.com/months/may")
    (wait/instance 10)
    (test-display)))

(defn june-display-test
  []
  (testing "Should return Description, Picture, and Pricing for June."
    (browser/get "http://shoestore-manheim.rhcloud.com/months/june")
    (wait/instance 10)
    (test-display)))

(defn july-display-test
  []
  (testing "Should return Description, Picture, and Pricing for July."
    (browser/get "http://shoestore-manheim.rhcloud.com/months/july")
    (wait/instance 10)
    (test-display)))

(defn august-display-test
  []
  (testing "Should return Description, Picture, and Pricing for August."
    (browser/get "http://shoestore-manheim.rhcloud.com/months/august")
    (wait/instance 10)
    (test-display)))

(defn september-display-test
  []
  (testing "Should return Description, Picture, and Pricing for September."
    (browser/get "http://shoestore-manheim.rhcloud.com/months/september")
    (wait/instance 10)
    (test-display)))

(defn october-display-test
  []
  (testing "Should return Description, Picture, and Pricing for October."
    (browser/get "http://shoestore-manheim.rhcloud.com/months/october")
    (wait/instance 10)
    (test-display)))

(defn november-display-test
  []
  (testing "Should return Description, Picture, and Pricing for November."
    (browser/get "http://shoestore-manheim.rhcloud.com/months/november")
    (wait/instance 10)
    (test-display)))

(defn december-display-test
  []
  (testing "Should return Description, Picture, and Pricing for December."
    (browser/get "http://shoestore-manheim.rhcloud.com/months/december")
    (wait/instance 10)
    (test-display)
    (browser/quit)))