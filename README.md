# DADI

<!--
<p align="center">
<img src="https://github.com/Abstract-Aardvarks/DADI/blob/rsvp_button_bugs/DADI_icon.png">
</p>
-->

Continuous Integration:![Build status](https://travis-ci.org/Abstract-Aardvarks/DADI.svg)
Stories to be claimed: [![Stories in Ready](https://badge.waffle.io/Abstract-Aardvarks/DADI.png?label=ready&title=Ready)](https://waffle.io/Abstract-Aardvarks/DADI)
Repo Hits:[![ghit.me](https://ghit.me/badge.svg?repo=Abstract-Aardvarks/DADI)](https://ghit.me/repo/Abstract-Aardvarks/DADI)

<!--
#### [Team Website](http://web.csulb.edu/~jcover/cecs492/index.html)
-->

#### [Build History](https://travis-ci.org/Abstract-Aardvarks/DADI/builds)


Project Throughput:[![Throughput Graph](https://graphs.waffle.io/Abstract-Aardvarks/DADI/throughput.svg)](https://waffle.io/Abstract-Aardvarks/DADI/metrics)

[Issues](https://github.com/Abstract-Aardvarks/DADI/issues) | [Milestones](https://github.com/Abstract-Aardvarks/DADI/milestones) | [Metrics](https://github.com/Abstract-Aardvarks/DADI/graphs/contributors)
___

## About
General info about the DADI
* What does it do?
* Who is the target audience
* what cloud aspects are there?

## Development Environment
___
What tools we use
* Android
* Android studio
* Git
* Github
* Waffle.io
* Hipchat
* GDrive
* Google App engine / amazon aws
* JUnit
* Travis CI
* Java

## Contributing
___

How to contribute to the project

1. Clone repo into local machine
    * **git clone http://github.com/sellnat77/TayBry.git**
2. Build and run (master branch should be clean)
3. checkout new branch
    *  **git checkout -b {branch-name}**
          * -b signifies a brand new branch that represents the new feature
          * Branch names: "name_of_feature-#issue_number"
          * The name of feature should be relative to the issue number you want to claim
          * ex: **git checkout -b adding_login-#12**
4. Add your changes while git adding and git committing often
    * **git checkout...**
    * Open unity and make your necessary code changes
    * **git add -A**
      * Adds all the changed work
    * **git commit -am "Descriptive message explaining what work was done"**
    * make more changes (maybe add more files)
    * **git add -A**
    * **git commit -am "Descriptive message explaining what work was done"**
    * This cycle can and should be repeated numerous times as you develop
5a. If done working but the feature is not closed:
    * **git add -A**
    * **git commit -am "Descriptive message explaining what work was done"**
    * **git push origin {branch_name}**
        * Enter username and password
5b. If done working and your branch closes #issue_number
    * **git add -A**
    * **git commit -am "Description of the changes Fixes #issue_number"**
        * Note: The end of your commit message will close the issue when it gets merged into master
    * **git push origin {branch_name}**
    * On Github, select your branch from the dropdown menu and click the button to create ***New Pull Request***
    * Either replace the pull requests title with ***Fixes #issue_number*** or put ***Fixes #issue_number*** in the body of the pull request
    * Leave a comment using the **@mention** for another team memeber to review the code

## Integration
___
Our integration strategy

The master branch is protected based on the build results from Travis CI, this way we are guaranteed a working build on the master branch. We are implementing the feature branch workflow. A developer will checkout a branch and label it in accordance with the task they plan to achieve. After they have made their changes and commited them to their checked out branch they will initiate an automated build through travis-ci.org; this is done by pushing to their checked out branch. Upon a successful build, they will initiate a pull request which will be reviewed and tested before being merged with the master branch.