Live Demo
=========

|http://gwt-angular.asayama.com/|
---------------------------------

The demo application gwt-angular-site demonstrates the usage of gwt-angular API in a live application. The demo application uses Twitter's [Bootstrap](http://getbootstrap.com) as the view framework.


Getting Started
===============

### Building the project
You will need the following build and package management tools to build GWT Angular project.

* [npm](https://www.npmjs.com/)
* [bower](http://bower.io)
* jdk
* [maven](http://maven.apache.org)

Install bower if you have not done so yet.

```
npm install -g bower
```

If you are running the above command from a restricted account, and, if you do have access to privileged account, you may have to execute the above command using `sudo`.

Set up maven on your machine, and then execute the following commands to build the project.

```
git clone https://github.com/kyoken74/gwt-angular-site.git
cd gwt-angular-site
mvn clean install
```

### Running the Live Demo
gwt-angular-site contains the source code for our Live Demo site.

If you have a JEE container, you can simply deploy the following WAR 
artifact to your server after building the project.
```
gwt-angular-site/gwt-angular-web/target/gwt-angular.war
```

If you have a web server, you can expand the above WAR file, and deploy the extracted code to your web server's htdocs area. You can discard the `META-INF` and `WEB-INF` directories, because they are only relevant to JEE containers.

```
gwt-angular.war
	/site
	/index.html
```

If you plan to run the site for development, please note that only SuperDevMode is supported. HostedMode (DevMode) is not supported. You can set up the SuperDevMode for gwt-angular-web project.

Main Class
```
com.google.gwt.dev.codeserver.CodeServer
```

Main Argument 
```
-src src/test/java com.asayama.gwt.angular.site.SuperDevMode
```

Required JAR

```
gwt-codeserver.jar
```


Thanks
======
I'd like to thank the following entities and individuals.

- GitHub for Hosting the GIT repository
- Sonatype for Hosting the binary artifacts
