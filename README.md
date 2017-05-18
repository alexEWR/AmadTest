**We are using pull requests in order to avoid commits without reviews.**
1) Create new branch for each test or modification
2) Push branch to GitHub
3) Make pull request and share its link to QA team
4) After positive response from reviewer, squash and merge request and delete branch.

**#For running UI tests do the following steps:**
- Install java JDK 1.8 in your system and configurate global JAVA_HOME variable (on Mac, install brew and than execute command in terminal **$brew cask install java**)
- Install Maven 3 in your system and configurate global MAVEN_HOME variable (on Mac: **$brew install maven**)
- Download project to your machine
- Open terminal, navigate to project's folder, execute command **$mvn test** or **$mvn surefire:test**
- Or you can execute it with CI, create Maven Job and add *clean* *test* to goals.

Configuration file **testng.xml** contains list of tests which will be started
Configuration of enviroment and browser placed in src\configs\Config.class
Configuration of Database connection placed in src\utils\DataBaseManager.class

Report will be added to /target/surefire-reports/ 

