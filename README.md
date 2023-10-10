# BDD-Framework-MobileAutomation
BDD framework for mobile automation

Arevo - Mobile Automation Test Suite
This code based for Android and iOS mobile automation.

Prerequisites
Client Machine
The following tools are pre-requisite to run the test suite.

NodeJS - Install the latest node version. This is required to install appium node module.
Appium - Node module globally installed using npm install -g appium
Java 11 - Developers typically use sdkman to manage Java versions on their machines. This is not required but recommended.
Android Studio - Download and install from the Android Developer Site. This will install Android SDK.
After installing the above the tools, the following environment variables should be added in your bash profile (~/.bash_profile). The automation test suite uses environment values to find the tool's location.

JAVA_HOME
ANDROID_HOME
NODE_HOME
APPIUM_HOME
IOS_APP_LOCATION
Example configuration given below, adjust paths as required.

export JAVA_HOME=/Users/your.user/.sdkman/candidates/java/current
export ANDROID_HOME=/Users/your.user/Library/Android/sdk
export APPIUM_HOME=/usr/local/lib/node_modules/appium/build/lib
export NODE_HOME=/usr/local/bin/node
export IOS_APP_LOCATION=/Users/your.user/Library/Developer/Xcode/DerivedData/your.app.folder/Build/Products/Arevo-Staging-iphonesimulator/Arevo.app
Note: IOS_APP_LOCATION settings required to load the app into simulator or device. This will make sure fresh app will be loaded for each test.

Emulator/Physical Device
The emulator or physical device you are using for testing must be running and have the application pre-installed. Ensure that the application and
bundle IDs etc that are configured in config.properties match the app that is installed on the phone.

Running the Project
IDE
Clone the repository and open as maven project in Android studio or IntelliJ
Right-click on the testng.xml or testng_ios.xml to run the test suite
CLI
Install maven in you machine using brew install maven
After maven installation use the command mvn -v to know the java version used by maven, it should display Java version 11 and below.
use the command mvn test to execute the test suite from the command prompt. By default it executes android test suite using the default parameter.
use the command mvn test -DsuiteXmlFile=testng.xml to run android test suite.
use the command mvn test -DsuiteXmlFile=testing_ios.xml to run ios test suite.
