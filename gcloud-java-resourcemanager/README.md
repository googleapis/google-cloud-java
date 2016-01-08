Google Cloud Java Client for Resource Manager (Alpha)
=============================================

Java idiomatic client for [Google Cloud Resource Manager] (https://cloud.google.com/resource-manager/).

[![Build Status](https://travis-ci.org/GoogleCloudPlatform/gcloud-java.svg?branch=master)](https://travis-ci.org/GoogleCloudPlatform/gcloud-java)
[![Coverage Status](https://coveralls.io/repos/GoogleCloudPlatform/gcloud-java/badge.svg?branch=master)](https://coveralls.io/r/GoogleCloudPlatform/gcloud-java?branch=master)
[![Maven](https://img.shields.io/maven-central/v/com.google.gcloud/gcloud-java-resourcemanager.svg)]( https://img.shields.io/maven-central/v/com.google.gcloud/gcloud-java-resourcemanager.svg)

-  [Homepage] (https://googlecloudplatform.github.io/gcloud-java/)
-  [API Documentation] (http://googlecloudplatform.github.io/gcloud-java/apidocs/index.html?com/google/gcloud/resourcemanager/package-summary.html)

> Note: This client is a work-in-progress, and may occasionally
> make backwards-incompatible changes.

Quickstart
----------
If you are using Maven, add this to your pom.xml file
```xml
<dependency>
  <groupId>com.google.gcloud</groupId>
  <artifactId>gcloud-java-resourcemanager</artifactId>
  <version>0.1.1</version>
</dependency>
```
If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.gcloud:gcloud-java-resourcemanager:0.1.1'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.gcloud" % "gcloud-java-resourcemanager" % "0.1.1"
```

Example Application
--------------------
[`ResourceManagerExample`](https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/gcloud-java-examples/src/main/java/com/google/gcloud/examples/ResourceManagerExample.java) is a simple command line interface for the Cloud Resource Manager.  Read more about using the application on the [`gcloud-java-examples` docs page](http://googlecloudplatform.github.io/gcloud-java/apidocs/?com/google/gcloud/examples/ResourceManagerExample.html).

Authentication
--------------

Unlike other `gcloud-java` service libraries, `gcloud-java-resourcemanager` only accepts Google Cloud SDK credentials at this time. If you are having trouble authenticating, it may be that you have other types of credentials that override your Google Cloud SDK credentials. See more about Google Cloud SDK credentials and credential precedence in the global README's [Authentication section](https://github.com/GoogleCloudPlatform/gcloud-java#authentication).

About Google Cloud Resource Manager
-----------------------------------

Google [Cloud Resource Manager][cloud-resourcemanager] provides a programmatic way to manage your Google Cloud Platform projects. With this API, you can do the following:

* Get a list of all projects associated with an account.
* Create new projects.
* Update existing projects.
* Delete projects.
* Undelete projects that you don't want to delete.

Google Cloud Resource Manager is currently in beta and may occasionally make backwards incompatible changes.

Be sure to activate the Google Cloud Resource Manager API on the Developer's Console to use Resource Manager from your project.

See the ``gcloud-java`` API [Resource Manager documentation][resourcemanager-api] to learn how to interact
with the Cloud Resource Manager using this client Library.

Getting Started
---------------
#### Prerequisites
You will need to set up the local development environment by [installing the Google Cloud SDK](https://cloud.google.com/sdk/) and running the following command in command line: `gcloud auth login`.

> Note: You don't need a project ID to use this service. If you have a project ID set in the Google Cloud SDK, you can unset it by typing `gcloud config unset project` in command line.

#### Installation and setup
You'll need to obtain the `gcloud-java-resourcemanager` library.  See the [Quickstart](#quickstart) section to add `gcloud-java-resourcemanager` as a dependency in your code.

#### Creating an authorized service object
To make authenticated requests to Google Cloud Resource Manager, you must create a service object with Google Cloud SDK credentials. You can then make API calls by calling methods on the Resource Manager service object. The simplest way to authenticate is to use [Application Default Credentials](https://developers.google.com/identity/protocols/application-default-credentials). These credentials are automatically inferred from your environment, so you only need the following code to create your service object:

```java
import com.google.gcloud.resourcemanager.ResourceManager;
import com.google.gcloud.resourcemanager.ResourceManagerOptions;

ResourceManager resourceManager = ResourceManagerOptions.defaultInstance().service();
```

#### Creating a project
All you need to create a project is a globally unique project ID.  You can also optionally attach a non-unique name and labels to your project. Read more about naming guidelines for project IDs, names, and labels [here](https://cloud.google.com/resource-manager/reference/rest/v1beta1/projects). To create a project, add the following import at the top of your file:

```java
import com.google.gcloud.resourcemanager.ProjectInfo;
```

Then add the following code to create a project (be sure to change `myProjectId` to your own unique project ID).

```java
String myProjectId = "my-globally-unique-project-id"; // Change to a unique project ID.
ProjectInfo myProject = resourceManager.create(ProjectInfo.builder(myProjectId).build());
```

Note that the return value from `create` is a `ProjectInfo` that includes additional read-only information, like creation time, project number, and lifecycle state. Read more about these fields on the [Projects page](https://cloud.google.com/resource-manager/reference/rest/v1beta1/projects).

#### Getting a specific project
You can load a project if you know it's project ID and have read permissions to the project. For example, to get the project we just created we can do the following:

```java
ProjectInfo projectFromServer = resourceManager.get(myProjectId);
```

#### Editing a project
To edit a project, create a new `ProjectInfo` object and pass it in to the `ResourceManager.replace` method.

For example, to add a label for the newly created project to denote that it's launch status is "in development", add the following code:

```java
ProjectInfo newProjectInfo = resourceManager.replace(projectFromServer.toBuilder()
    .addLabel("launch-status", "in-development").build());
```

Note that the values of the project you pass in to `replace` overwrite the server's values for non-read-only fields, namely `projectName` and `labels`. For example, if you create a project with `projectName` "some-project-name" and subsequently call replace using a `ProjectInfo` object that didn't set the `projectName`, then the server will unset the project's name. The server ignores any attempted changes to the read-only fields `projectNumber`, `lifecycleState`, and `createTime`. The `projectId` cannot change.

#### Listing all projects
Suppose that we want a list of all projects for which we have read permissions. Add the following import:

```java
import java.util.Iterator;
```

Then add the following code to print a list of projects you can view:

```java
Iterator<ProjectInfo> projectIterator = resourceManager.list().iterateAll();
System.out.println("Projects I can view:");
while (projectIterator.hasNext()) {
  System.out.println(projectIterator.next().projectId());
}
```

#### Complete source code

Here we put together all the code shown above into one program.  This program assumes that you are running from your own desktop and used the Google Cloud SDK to authenticate yourself.

```java
import com.google.gcloud.resourcemanager.ProjectInfo;
import com.google.gcloud.resourcemanager.ResourceManager;
import com.google.gcloud.resourcemanager.ResourceManagerOptions;

import java.util.Iterator;

public class GcloudJavaResourceManagerExample {

  public static void main(String[] args) {
    // Create Resource Manager service object.
    // By default, credentials are inferred from the runtime environment.
    ResourceManager resourceManager = ResourceManagerOptions.defaultInstance().service();

    // Create a project.
    String myProjectId = "my-globally-unique-project-id"; // Change to a unique project ID.
    ProjectInfo myProject = resourceManager.create(ProjectInfo.builder(myProjectId).build());

    // Get a project from the server.
    ProjectInfo projectFromServer = resourceManager.get(myProjectId);
    System.out.println("Got project " + projectFromServer.projectId() + " from the server.");

    // Update a project
    ProjectInfo newProjectInfo = resourceManager.replace(myProject.toBuilder()
        .addLabel("launch-status", "in-development").build());
    System.out.println("Updated the labels of project " + newProjectInfo.projectId()
        + " to be " + newProjectInfo.labels());

    // List all the projects you have permission to view.
    Iterator<ProjectInfo> projectIterator = resourceManager.list().iterateAll();
    System.out.println("Projects I can view:");
    while (projectIterator.hasNext()) {
      System.out.println(projectIterator.next().projectId());
    }
  }
}
```

Java Versions
-------------

Java 7 or above is required for using this client.

Versioning
----------

This library follows [Semantic Versioning] (http://semver.org/).

It is currently in major version zero (``0.y.z``), which means that anything
may change at any time and the public API should not be considered
stable.

Testing
-------

This library has tools to help write tests for code that uses Resource Manager.

See [TESTING] to read more about testing.

Contributing
------------

Contributions to this library are always welcome and highly encouraged.

See [CONTRIBUTING] for more information on how to get started.

License
-------

Apache 2.0 - See [LICENSE] for more information.


[CONTRIBUTING]:https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/CONTRIBUTING.md
[LICENSE]: https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/LICENSE
[TESTING]: https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/TESTING.md#testing-code-that-uses-resource-manager
[cloud-platform]: https://cloud.google.com/
[cloud-resourcemanager]: https://cloud.google.com/resource-manager/docs
[resourcemanager-api]: http://googlecloudplatform.github.io/gcloud-java/apidocs/index.html?com/google/gcloud/resourcemanager/package-summary.html

