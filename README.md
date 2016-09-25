NSShoppingCary
===========================

Spring MVC MongoDB example also uses angular and bootstrap.

![ScreenShot](https://raw.githubusercontent.com/nsozbay/NSShoppingCart/master/src/main/webapp/img/MainPage1.png)

##Setup
1.  Download and install Spring Tool Suite http://spring.io/tools/sts
2.  Download and install Git http://git-scm.com/downloads
3.  Open STS and create a workspace
4.  Navigate to the workspace folder (terminal or cmd) and run the Git command `git clone https://github.com/nsozbay/NSShoppingCart.git`
5.  Click File -> Import -> General -> Existing Project into Workspace
6.  Click Browse navigate to the workspace and select the `NSShoppingCart` folder
7.  Click finish
8.  Right click on the project -> Maven -> Update Project
9.  Click OK

##Database Setup (Linux)
1.  Download and install MongoDB http://www.mongodb.org/downloads
2.  Start the MongoDb service `sudo service mongodb start`

##Database Setup (Windows)
1.  Download and install MongoDB http://www.mongodb.org/downloads
2.  Create the following folder `C:\data\db`
3.  If MongoDb has not been installed as a service run the MonogoDB demon `mongod.exe`
4.  Run main method in DatabaseInitializer class and this method populates initial data to MongoDb

##Deploy
1. Right click on the project Run As -> Run On Server -> Click Finish (Using the Apache Tomcat 8 Server)
