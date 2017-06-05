# shoe-store-testing

This project is an automated test suite of the Manheim shoe store. It uses a a Clojure binding for Selenium Webdriver called [webica](https://github.com/tmarble/webica).

## Installation

1. Install [Leiningen](https://leiningen.org/)
2. Clone this library.
3. On line 15 of the core_test.clj file, be sure to only uncomment the line which corresponds to the running operating system.
If this isn't done correctly, the browsers won't run.


## Usage

1. To run automated tests using command prompt, run ```lein test``` in the project root directory

## Possible Problems

Currently, this project is only tested on Windows 10. I have not tried testing this through any other operating system just yet, so I can't guarantee that the other web drivers will work. I will test on a Mac once I finish getting core functionality developed. 

There are also problems with running the Gecko Driver. It's able to be run, but no commands seem to be getting through besides start-firefox and quit.

## License

Copyright © 2017 Paul Nguyen

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
