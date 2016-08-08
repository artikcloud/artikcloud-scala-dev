ARTIK Cloud Scala SDK
==========================

[![Build Status](https://travis-ci.org/artikcloud/artikcloud-scala.svg?branch=master)](https://travis-ci.org/artikcloud/artikcloud-scala)

This SDK helps you connect your Scala applications to ARTIK Cloud. It exposes a number of methods to easily execute REST API calls to ARTIK Cloud.

Prerequisites
-------------

 * [Maven](http://maven.apache.org/) or [Maven Integration for Eclipse](https://www.eclipse.org/m2e/)
 * JavaSE 1.7 or above
 * Scala 2.10 or above

The SDK was developed with Maven and tested with Scala 2.11.6. Building Maven will fetch the correct libraries. You might be able to build the SDK in a different environment and we would be happy to hear about your (success) stories.

Installation
---------------------

You can generate the SDK libraries using one of the following ways. 

If using Maven command line,
- run "mvn clean install -DskipTests" in the root directory of the repository to install to your local Maven repository.

If using Eclipse with the Scala IDE Plugin, 
- import the SDK library project as "Existing Maven Projects".
- right click the project, and choose "Run As" then "Maven install"

Use the Libraries
---------------------

After the generation succeeds, you can use the generated libraries in one of the following ways depending on your scenario:

- To use them in your Maven project, modify `pom.xml` file in your project to add dependency to artikcloud-scala-2.x.x.jar under `target` of the imported Maven project as following

~~~
<dependency>
    <groupId>cloud.artik</groupId>
    <artifactId>artikcloud-scala</artifactId>
    <version>2.0.0</version>
    <scope>compile</scope>
</dependency>
~~~

Usage
------

Peek into [tests](https://github.com/artikcloud/artikcloud-scala/tree/master/src/test/scala/cloud/artik/api) for examples about how to use the SDK.

In addition, you can look at our tutorial and sample applications. These will give you a good overview of what you can do and how to do it. 

More about ARTIK Cloud
---------------------

If you are not familiar with ARTIK Cloud, we have extensive documentation at https://developer.artik.cloud/documentation

The full ARTIK Cloud API specification can be found at https://developer.artik.cloud/documentation/api-reference/

Check out advanced sample applications at https://developer.artik.cloud/documentation/samples/

To create and manage your services and devices on ARTIK Cloud, create an account at https://developer.artik.cloud

Also see the ARTIK Cloud blog for tutorials, updates, and more: http://artik.io/blog/cloud

Licence and Copyright
---------------------

Licensed under the Apache License. See [LICENSE](https://github.com/artikcloud/artikcloud-scala/blob/master/LICENSE).

Copyright (c) 2016 Samsung Electronics Co., Ltd.
