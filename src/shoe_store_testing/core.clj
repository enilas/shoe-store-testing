(ns shoe-store-testing.core
  (:require [clojure.java.io :as io]))

(def months ["January", "February", "March", "April", "May", "June", "July", "August",
             "September", "October", "November", "December"])

(defn sanitize-file-location
  "Transformations in the path URL to allow for valid classpath access."
  [path-url]
  ;Replace %20 with space character
  (clojure.string/replace path-url #"%20" " "))

(defn configure
  [system-os]
  (if (= system-os :linux64)
    (do (System/setProperty "webdriver.chrome.driver"
                            (sanitize-file-location (.getPath (io/resource "linux64/chromedriver"))))
        (System/setProperty "webdriver.firefox.driver"
                            (sanitize-file-location (.getPath (io/resource "linux64/geckodriver"))))))
  (if (= system-os :win32)
    (do (System/setProperty "webdriver.chrome.driver"
                            (sanitize-file-location (.getPath (io/resource "win32/chromedriver.exe"))))
        (System/setProperty "webdriver.firefox.driver"
                            (sanitize-file-location (.getPath (io/resource "win32/geckodriver.exe"))))))
  (if (= system-os :macosx)
    (do (System/setProperty "webdriver.chrome.driver"
                            (sanitize-file-location (.getPath (io/resource "macosx/chromedriver"))))
        (System/setProperty "webdriver.firefox.driver"
                            (sanitize-file-location (.getPath (io/resource "macosx/geckodriver")))))))