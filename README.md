### Prerequisites

* JDK >= 12 installed
* Maven installed

### Installing JDK

Follow instructions on the page: https://openjdk.java.net/install/

### Installing Maven

Command line: 
```bash
brew install maven 
```

Info: https://maven.apache.org/

### Run functional tests

```bash
git clone https://github.com/nsemidotska/uiTestsKomoot.com.git
```

Variant#1
- Open the project using Intellij IDEA;
- Right click on the test folder (src\test\java\tests);
- Click 'Run Tests in "tests"'.

Variant#2
```bash
cd {PROJECT_DIR} && mvn install
```
This command will invoke mvn validate, mvn compile, mvn test, mvn package etc.
For the next execution simple ```mvn test``` would be enough.


### Hardware 
MacBook Pro,
macOS Catalina

