# Google Resource Manager API Client for Java

Java idiomatic client for [Resource Manager API][product-docs].

[![Maven][maven-version-image]][maven-version-link]
![Stability][stability-image]

- [Product Documentation][product-docs]
- [Client Library Documentation][javadocs]

> Note: This client is a work-in-progress, and may occasionally
> make backwards-incompatible changes.

## Quickstart

If you are using Maven with [BOM][libraries-bom], add this to your pom.xml file
```xml
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>com.google.cloud</groupId>
      <artifactId>libraries-bom</artifactId>
      <version>16.1.0</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>

<dependencies>
  <dependency>
    <groupId>com.google.cloud</groupId>
    <artifactId>google-cloud-resourcemanager</artifactId>
  </dependency>

```

If you are using Maven without BOM, add this to your dependencies:

```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-resourcemanager</artifactId>
  <version>0.118.5-alpha</version>
</dependency>

```

If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-resourcemanager:0.118.5-alpha'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-resourcemanager" % "0.118.5-alpha"
```

## Authentication

See the [Authentication][authentication] section in the base directory's README.

## Getting Started

### Prerequisites

You will need a [Google Cloud Platform Console][developer-console] project with the Resource Manager API [API enabled][enable-api].

[Follow these instructions][create-project] to get your project set up. You will also need to set up the local development environment by
[installing the Google Cloud SDK][cloud-sdk] and running the following commands in command line:
`gcloud auth login` and `gcloud config set project [YOUR PROJECT ID]`.

### Installation and setup

You'll need to obtain the `google-cloud-resourcemanager` library.  See the [Quickstart](#quickstart) section
to add `google-cloud-resourcemanager` as a dependency in your code.

## About Resource Manager API


[Resource Manager API][product-docs] enables you to programmatically manage resources by project, folder, and organization.

See the [Resource Manager API client library docs][javadocs] to learn how to
use this Resource Manager API Client Library.


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
You can load a project if you know its project ID and have read permissions to the project.
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
[GetOrCreateProject.java](https://github.com/googleapis/google-cloud-java/blob/master/google-cloud-examples/src/main/java/com/google/cloud/examples/resourcemanager/snippets/GetOrCreateProject.java).

The second program updates a project if it exists and lists all projects the user has permission to
view. Complete source code can be found at
[UpdateAndListProjects.java](https://github.com/googleapis/google-cloud-java/blob/master/google-cloud-examples/src/main/java/com/google/cloud/examples/resourcemanager/snippets/UpdateAndListProjects.java).

The third program modifies the IAM policy associated with a project using the read-modify-write
pattern.  Complete source code can be found at
[ModifyPolicy.java](https://github.com/googleapis/google-cloud-java/blob/master/google-cloud-examples/src/main/java/com/google/cloud/examples/resourcemanager/snippets/ModifyPolicy.java)




## Troubleshooting

To get help, follow the instructions in the [shared Troubleshooting document][troubleshooting].

## Transport

Resource Manager API uses HTTP/JSON for the transport layer.

## Java Versions

Java 7 or above is required for using this client.

## Versioning


This library follows [Semantic Versioning](http://semver.org/).


It is currently in major version zero (``0.y.z``), which means that anything may change at any time
and the public API should not be considered stable.

## Contributing


Contributions to this library are always welcome and highly encouraged.

See [CONTRIBUTING][contributing] for more information how to get started.

Please note that this project is released with a Contributor Code of Conduct. By participating in
this project you agree to abide by its terms. See [Code of Conduct][code-of-conduct] for more
information.

## License

Apache 2.0 - See [LICENSE][license] for more information.

## CI Status

Java Version | Status
------------ | ------
Java 7 | [![Kokoro CI][kokoro-badge-image-1]][kokoro-badge-link-1]
Java 8 | [![Kokoro CI][kokoro-badge-image-2]][kokoro-badge-link-2]
Java 8 OSX | [![Kokoro CI][kokoro-badge-image-3]][kokoro-badge-link-3]
Java 8 Windows | [![Kokoro CI][kokoro-badge-image-4]][kokoro-badge-link-4]
Java 11 | [![Kokoro CI][kokoro-badge-image-5]][kokoro-badge-link-5]

Java is a registered trademark of Oracle and/or its affiliates.

[product-docs]: https://cloud.google.com/resource-manager
[javadocs]: https://googleapis.dev/java/google-cloud-resourcemanager/latest/
[kokoro-badge-image-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-resourcemanager/java7.svg
[kokoro-badge-link-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-resourcemanager/java7.html
[kokoro-badge-image-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-resourcemanager/java8.svg
[kokoro-badge-link-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-resourcemanager/java8.html
[kokoro-badge-image-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-resourcemanager/java8-osx.svg
[kokoro-badge-link-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-resourcemanager/java8-osx.html
[kokoro-badge-image-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-resourcemanager/java8-win.svg
[kokoro-badge-link-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-resourcemanager/java8-win.html
[kokoro-badge-image-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-resourcemanager/java11.svg
[kokoro-badge-link-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-resourcemanager/java11.html
[stability-image]: https://img.shields.io/badge/stability-alpha-orange
[maven-version-image]: https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-resourcemanager.svg
[maven-version-link]: https://search.maven.org/search?q=g:com.google.cloud%20AND%20a:google-cloud-resourcemanager&core=gav
[authentication]: https://github.com/googleapis/google-cloud-java#authentication
[developer-console]: https://console.developers.google.com/
[create-project]: https://cloud.google.com/resource-manager/docs/creating-managing-projects
[cloud-sdk]: https://cloud.google.com/sdk/
[troubleshooting]: https://github.com/googleapis/google-cloud-common/blob/master/troubleshooting/readme.md#troubleshooting
[contributing]: https://github.com/googleapis/java-resourcemanager/blob/master/CONTRIBUTING.md
[code-of-conduct]: https://github.com/googleapis/java-resourcemanager/blob/master/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[license]: https://github.com/googleapis/java-resourcemanager/blob/master/LICENSE

[enable-api]: https://console.cloud.google.com/flows/enableapi?apiid=cloudresourcemanager.googleapis.com
[libraries-bom]: https://github.com/GoogleCloudPlatform/cloud-opensource-java/wiki/The-Google-Cloud-Platform-Libraries-BOM
[shell_img]: https://gstatic.com/cloudssh/images/open-btn.png
