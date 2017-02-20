Google Cloud Java Client for Resource Manager
=============================================

Java idiomatic client for [Google Cloud Resource Manager] (https://cloud.google.com/resource-manager/).

[![Build Status](https://travis-ci.org/GoogleCloudPlatform/google-cloud-java.svg?branch=master)](https://travis-ci.org/GoogleCloudPlatform/google-cloud-java)
[![Coverage Status](https://coveralls.io/repos/GoogleCloudPlatform/google-cloud-java/badge.svg?branch=master)](https://coveralls.io/r/GoogleCloudPlatform/google-cloud-java?branch=master)
[![Maven](https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-resourcemanager.svg)]( https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-resourcemanager.svg)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/9da006ad7c3a4fe1abd142e77c003917)](https://www.codacy.com/app/mziccard/google-cloud-java)
[![Dependency Status](https://www.versioneye.com/user/projects/56bd8ee72a29ed002d2b0969/badge.svg?style=flat)](https://www.versioneye.com/user/projects/56bd8ee72a29ed002d2b0969)

-  [Homepage] (https://googlecloudplatform.github.io/google-cloud-java/)
-  [API Documentation] (https://googlecloudplatform.github.io/google-cloud-java/apidocs/index.html?com/google/cloud/resourcemanager/package-summary.html)

> Note: This client is a work-in-progress, and may occasionally
> make backwards-incompatible changes.

Quickstart
----------
If you are using Maven, add this to your pom.xml file
```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-resourcemanager</artifactId>
  <version>0.9.2-alpha</version>
</dependency>
```
If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-resourcemanager:0.9.2-alpha'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-resourcemanager" % "0.9.2-alpha"
```

Example Application
--------------------
[`ResourceManagerExample`](../google-cloud-examples/src/main/java/com/google/cloud/examples/resourcemanager/ResourceManagerExample.java) is a simple command line interface for the Cloud Resource Manager.  Read more about using the application on the [`ResourceManagerExample` docs page](https://googlecloudplatform.github.io/google-cloud-java/apidocs/?com/google/cloud/examples/resourcemanager/ResourceManagerExample.html).

Authentication
--------------

Unlike other `google-cloud` service libraries, `google-cloud-resourcemanager` only accepts Google Cloud SDK credentials at this time. If you are having trouble authenticating, it may be that you have other types of credentials that override your Google Cloud SDK credentials. See more about Google Cloud SDK credentials and credential precedence in the global README's [Authentication section](https://github.com/GoogleCloudPlatform/google-cloud-java#authentication).

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

See the ``google-cloud`` API [Resource Manager documentation][resourcemanager-api] to learn how to interact
with the Cloud Resource Manager using this client Library.

Getting Started
---------------
#### Prerequisites
You will need to set up the local development environment by [installing the Google Cloud SDK](https://cloud.google.com/sdk/) and running the following command in command line: `gcloud auth login`.

> Note: You don't need a project ID to use this service. If you have a project ID set in the Google Cloud SDK, you can unset it by typing `gcloud config unset project` in command line.

#### Installation and setup
You'll need to obtain the `google-cloud-resourcemanager` library.  See the [Quickstart](#quickstart) section to add `google-cloud-resourcemanager` as a dependency in your code.

#### Creating an authorized service object
To make authenticated requests to Google Cloud Resource Manager, you must create a service object
with Google Cloud SDK credentials. You can then make API calls by calling methods on the Resource
Manager service object. The simplest way to authenticate is to use
[Application Default Credentials](https://developers.google.com/identity/protocols/application-default-credentials).
These credentials are automatically inferred from your environment, so you only need the following
code to create your service object:

```java
import com.google.cloud.resourcemanager.ResourceManager;
import com.google.cloud.resourcemanager.ResourceManagerOptions;

ResourceManager resourceManager = ResourceManagerOptions.getDefaultInstance().getService();
```

#### Getting a specific project
You can load a project if you know it's project ID and have read permissions to the project.
To get a project, add the following import at the top of your file:

```java
import com.google.cloud.resourcemanager.Project;
```

Then use the following code to get the project:

```java
String projectId = "my-globally-unique-project-id"; // Change to a unique project ID
Project project = resourceManager.get(projectId);
```

#### Creating a project
All you need to create a project is a globally unique project ID. You can also optionally attach a
non-unique name and labels to your project. Read more about naming guidelines for project IDs,
names, and labels [here](https://cloud.google.com/resource-manager/reference/rest/v1beta1/projects).
To create a project, add the following imports at the top of your file:

```java
import com.google.cloud.resourcemanager.Project;
import com.google.cloud.resourcemanager.ProjectInfo;
```

Then add the following code to create a project (be sure to change `projectId` to your own unique
project ID).

```java
String projectId = "my-globally-unique-project-id"; // Change to a unique project ID
Project project = resourceManager.create(ProjectInfo.newBuilder(projectId).build());
```

Note that the return value from `create` is a `Project` that includes additional read-only
information, like creation time, project number, and lifecycle state. Read more about these fields
on the [Projects page](https://cloud.google.com/resource-manager/reference/rest/v1beta1/projects).
`Project`, a subclass of `ProjectInfo`, adds a layer of service-related functionality over
`ProjectInfo`.

#### Editing a project
To edit a project, create a new `ProjectInfo` object and pass it in to the `Project.replace` method.
For example, to add a label to a project to denote that it's launch status is "in development", add
the following code:

```java
Project newProject = project.toBuilder()
    .addLabel("launch-status", "in-development")
    .build()
    .replace();
```

Note that the values of the project you pass in to `replace` overwrite the server's values for
non-read-only fields, namely `projectName` and `labels`. For example, if you create a project with
`projectName` "some-project-name" and subsequently call replace using a `ProjectInfo` object that
didn't set the `projectName`, then the server will unset the project's name. The server ignores any
attempted changes to the read-only fields `projectNumber`, `lifecycleState`, and `createTime`.
The `projectId` cannot change.

#### Listing all projects
Suppose that we want a list of all projects for which we have read permissions. Add the following
import:

```java
import java.util.Iterator;
```

Then add the following code to print a list of projects you can view:

```java
Iterator<Project> projectIterator = resourceManager.list().iterateAll();
System.out.println("Projects I can view:");
while (projectIterator.hasNext()) {
  System.out.println(projectIterator.next().getProjectId());
}
```

#### Managing IAM Policies
You can edit [Google Cloud IAM](https://cloud.google.com/iam/) (Identity and Access Management)
policies on the project-level using this library as well. We recommend using the read-modify-write
pattern to make policy changes.  This entails reading the project's current policy, updating it
locally, and then sending the modified policy for writing, as shown in the snippet below. First,
add these imports:

```java
import com.google.cloud.Identity;
import com.google.cloud.Policy;
import com.google.cloud.Role;
```

Assuming you have completed the steps above to create the `ResourceManager` service object and load
a project from the server, you just need to add the following code:

```java
// Get the project's policy
Policy policy = project.getPolicy();

// Add a viewer
Policy.Builder modifiedPolicy = policy.toBuilder();
Identity newViewer = Identity.user("<insert user's email address here>");
modifiedPolicy.addIdentity(Role.viewer(), newViewer);

// Write policy
Policy updatedPolicy = project.replacePolicy(modifiedPolicy.build());
```

Note that the policy you pass in to `replacePolicy` overwrites the original policy. For example, if
the original policy has two bindings and you call `replacePolicy` with a new policy containing only
one binding, the two original bindings are lost.

#### Complete source code

We put together all the code shown above into three programs. The programs assume that you are
running from your own desktop and used the Google Cloud SDK to authenticate yourself.

The first program creates a project if it does not exist. Complete source code can be found at
[GetOrCreateProject.java](../google-cloud-examples/src/main/java/com/google/cloud/examples/resourcemanager/snippets/GetOrCreateProject.java).

The second program updates a project if it exists and lists all projects the user has permission to
view. Complete source code can be found at
[UpdateAndListProjects.java](../google-cloud-examples/src/main/java/com/google/cloud/examples/resourcemanager/snippets/UpdateAndListProjects.java).

The third program modifies the IAM policy associated with a project using the read-modify-write
pattern.  Complete source code can be found at
[ModifyPolicy.java](../google-cloud-examples/src/main/java/com/google/cloud/examples/resourcemanager/snippets/ModifyPolicy.java)

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


[CONTRIBUTING]:https://github.com/GoogleCloudPlatform/google-cloud-java/blob/master/CONTRIBUTING.md
[LICENSE]: https://github.com/GoogleCloudPlatform/google-cloud-java/blob/master/LICENSE
[TESTING]: https://github.com/GoogleCloudPlatform/google-cloud-java/blob/master/TESTING.md#testing-code-that-uses-resource-manager
[cloud-platform]: https://cloud.google.com/
[cloud-resourcemanager]: https://cloud.google.com/resource-manager/docs
[resourcemanager-api]: https://googlecloudplatform.github.io/google-cloud-java/apidocs/index.html?com/google/cloud/resourcemanager/package-summary.html

