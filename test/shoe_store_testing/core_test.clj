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

(deftest configure-test
  (testing "Should set system properties according to OS."
    (configure (:os system-os))
    (is (not-empty (System/getProperty "webdriver.chrome.driver")) "Chrome driver not found.")
    (is (not-empty (System/getProperty "webdriver.firefox.driver")) "Firefox driver not found.")))

(deftest start-browser-test
  (testing "Chrome browser should launch and close appropriately."
    (chrome/start-chrome)
    (wait/instance 10)
    (is (not (nil? (browser/instance))))
    (chrome/quit))
  (testing "Firefox browser should launch and close appropriately."
    (firefox/start-firefox)
    (wait/instance 10)
    (is (not (nil? (browser/instance))))
    (firefox/quit)))

(deftest january-test
  (testing "Should return Description, Picture, and Pricing for January."))

(deftest february-test
  (testing "Should return Description, Picture, and Pricing for February."))

(deftest march-test
  (testing "Should return Description, Picture, and Pricing for March."))

(deftest april-test
  (testing "Should return Description, Picture, and Pricing for April."))

(deftest may-test
  (testing "Should return Description, Picture, and Pricing for May."))

(deftest june-test
  (testing "Should return Description, Picture, and Pricing for June."))

(deftest july-test
  (testing "Should return Description, Picture, and Pricing for July."))

(deftest august-test
  (testing "Should return Description, Picture, and Pricing for August."))

(deftest september-test
  (testing "Should return Description, Picture, and Pricing for September."))

(deftest october-test
  (testing "Should return Description, Picture, and Pricing for October."))

(deftest november-test
  (testing "Should return Description, Picture, and Pricing for November."))

(deftest december-test
  (testing "Should return Description, Picture, and Pricing for December."))
