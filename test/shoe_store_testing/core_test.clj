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

(defn submit-email-inputs
  "Inputs notification_email_input text boxes."
  [month]
  (let [reminder-email-inputs (browser/find-elements-by-class-name "remind_email_input")]))

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

(deftest january-browser-test
  (testing "Testing browser compatibility for January."
    (let [_ (chrome/start-chrome)]
      (browser/get "http://shoestore-manheim.rhcloud.com/months/january")
      (wait/instance 10)
      (test-display)
      (submit-email-inputs "january")
      (chrome/quit))))


(deftest february-browser-test
  []
  (testing "Should return Description, Picture, and Pricing for February."
    (let [_ (chrome/start-chrome)]
      (browser/get "http://shoestore-manheim.rhcloud.com/months/february")
      (wait/instance 10)
      (test-display)
      (submit-email-inputs "february")
      (chrome/quit))))

(deftest march-browser-test
  []
  (testing "Should return Description, Picture, and Pricing for March."
    (let [_ (chrome/start-chrome)]
      (browser/get "http://shoestore-manheim.rhcloud.com/months/march")
      (wait/instance 10)
      (test-display)
      (chrome/quit))))

(deftest april-browser-test
  []
  (testing "Should return Description, Picture, and Pricing for April."
    (let [_ (chrome/start-chrome)]
      (browser/get "http://shoestore-manheim.rhcloud.com/months/april")
      (wait/instance 10)
      (test-display)
      (chrome/quit))))

(deftest may-browser-test
  []
  (testing "Should return Description, Picture, and Pricing for May."
    (let [_ (chrome/start-chrome)]
      (browser/get "http://shoestore-manheim.rhcloud.com/months/may")
      (wait/instance 10)
      (test-display)
      (chrome/quit))))

(deftest june-browser-test
  []
  (testing "Should return Description, Picture, and Pricing for June."
    (let [_ (chrome/start-chrome)]
      (browser/get "http://shoestore-manheim.rhcloud.com/months/june")
      (wait/instance 10)
      (test-display)
      (chrome/quit))))

(deftest july-browser-test
  []
  (testing "Should return Description, Picture, and Pricing for July."
    (let [_ (chrome/start-chrome)]
      (browser/get "http://shoestore-manheim.rhcloud.com/months/july")
      (wait/instance 10)
      (test-display)
      (chrome/quit))))

(deftest august-browser-test
  []
  (testing "Should return Description, Picture, and Pricing for August."
    (let [_ (chrome/start-chrome)]
      (browser/get "http://shoestore-manheim.rhcloud.com/months/august")
      (wait/instance 10)
      (test-display)
      (chrome/quit))))

(deftest september-browser-test
  []
  (testing "Should return Description, Picture, and Pricing for September."
    (let [_ (chrome/start-chrome)]
      (browser/get "http://shoestore-manheim.rhcloud.com/months/september")
      (wait/instance 10)
      (test-display)
      (chrome/quit))))

(deftest october-browser-test
  []
  (testing "Should return Description, Picture, and Pricing for October."
    (let [_ (chrome/start-chrome)]
      (browser/get "http://shoestore-manheim.rhcloud.com/months/october")
      (wait/instance 10)
      (test-display)
      (chrome/quit))))

(deftest november-browser-test
  []
  (testing "Should return Description, Picture, and Pricing for November."
    (let [_ (chrome/start-chrome)]
      (browser/get "http://shoestore-manheim.rhcloud.com/months/november")
      (wait/instance 10)
      (test-display)
      (chrome/quit))))

(deftest december-display-test
  []
  (testing "Should return Description, Picture, and Pricing for December."
    (let [_ (chrome/start-chrome)]
      (browser/get "http://shoestore-manheim.rhcloud.com/months/december")
      (wait/instance 10)
      (test-display)
      (chrome/quit))))