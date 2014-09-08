## What is this ?

This repo contains solutions for coding challenges on http://hackergym.com. 

For each question, there are multiple solutions available in Java. In addition, all solutions come with extensive unit tests that test for correctness and common pitfalls and edge cases. 

More importantly, each solution contains placeholders for you own custom solution. You can add your own solutions to these placeholders and all the unit tests will automatically run on it and verify it's correctness. 


## How to use this ?

The best way to use this repo is along with http://hackergym.com. 

We recommend that you go through each question using the simulated environment on the website. Then, if you have a better solution and want to verify it use this repo to run our unit tests against it. 


## How to set up

First you need to install JDK 8 from [here](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html). 

After the installation do the following to make sure you have the correct version: 

```
$ javac -version
```

Now download the zip/tar file from top of this page and unzip it. Then follow the instructions below for your favorite java development tool. 

### Command Line

From the extracted folder: 

```
$ cd JavaSolutions/
$ ./gradlew
$ ./gradlew test

```
This will run all the unit tests against the code. 

You can use the ``./gradlew`` to run any task inlcuding build and test.

### Eclipse

First install Gradle from Eclipse Marketplace: ``Help -> Eclipse MarketPlace`` : 

![image](https://s3-us-west-2.amazonaws.com/hackergym-images/0.gif):

Now set you project java version to 1.8: ``Project -> Properties`` : 

![image](https://s3-us-west-2.amazonaws.com/hackergym-images/1.gif)

Having installed the Gradle plugin, import the project as a Gradle project: ``File -> Import``

![image](https://s3-us-west-2.amazonaws.com/hackergym-images/2.gif)

Finally, open the Gradle Task view and run with test: ``Window -> Show View -> Other`` 

![image](https://s3-us-west-2.amazonaws.com/hackergym-images/3.gif)

This will run all of the unit tests on the solutions. 


### IntellijIDEA

First install The Gradle Plugin:``IntelliJ IDEA -> Preferences -> plugins``
 
![image](https://s3-us-west-2.amazonaws.com/hackergym-images/I1.gif)

Now import the project: ``File -> Import Project`` 
![image](https://s3-us-west-2.amazonaws.com/hackergym-images/I2.gif)

Now set you JDK to 1.8: ``File -> Project Structure``
![image](https://s3-us-west-2.amazonaws.com/hackergym-images/I3.gif)

Make sure that ``Project Language level`` is set to 8.0 and also that your ```Project SDK`` is pointing to your JDK 8 installation. 

Finally, Run the Gradle Task window and run the test task: ```view -> Tool Windows -> Gradle```:

![image](https://s3-us-west-2.amazonaws.com/hackergym-images/I4.gif)


##Project Structure

Under the ``src`` folder there are two standard folders: 

* 	``src/main/java`` : Contains the actual code for solutions. Each topic has its own package and the name of the classes correspond with the name of the questions on http://hackergym.com
* 	``src/test/java`` : Contains the unit tests for solutions. The name of the packages and classes correspond with the packages and classess under ``src/main/java``

##How to Add your Custom Solutions

If you go under each problem, you will see a section describing the problem and a method as soon as the class begins. The method usually has a big comment block saying "Your Custom Solution". All you need to do is to remove the existing line of code in that method and write your own solution there.  

![image](https://s3-us-west-2.amazonaws.com/hackergym-images/CustomSolution.png)

Once you are done, you can run the unit tests against your solution using one of the approaches explained above. 

![image](https://s3-us-west-2.amazonaws.com/hackergym-images/UnitTests.png)

Unit tests will be run against your custom solution. These unit tests contain the word Custom in them so that they are easy to spot. 

##What's next
HackerGym gets updates every week with a new batch of questions. So check the repo frequently so that you don't miss new questions. 

##Support
If you have any trouble setting up your environment or see a wrong solution, contact team@hackergym.com or open an issue [here](https://github.com/Fathalian/HackerGymContent/issues). 

If you have better solutions, want to modify existing solutions, or have a solution in other languages fork the repo and send us a pull request. We will merge your changes as soon as possible. 

##License
**MIT LICENSE**

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
