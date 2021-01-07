# Google Cloud Gaming Client for Java

Java idiomatic client for [Cloud Gaming][product-docs].

[![Maven][maven-version-image]][maven-version-link]
![Stability][stability-image]

- [Product Documentation][product-docs]
- [Client Library Documentation][javadocs]

## Quickstart


If you are using Maven, add this to your pom.xml file:

```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-game-servers</artifactId>
  <version>1.0.5</version>
</dependency>
```

If you are using Gradle without BOM, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-game-servers:1.0.5'
```

If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-game-servers" % "1.0.5"
```

## Authentication

See the [Authentication][authentication] section in the base directory's README.

## Getting Started

### Prerequisites

You will need a [Google Cloud Platform Console][developer-console] project with the Cloud Gaming [API enabled][enable-api].

[Follow these instructions][create-project] to get your project set up. You will also need to set up the local development environment by
[installing the Google Cloud SDK][cloud-sdk] and running the following commands in command line:
`gcloud auth login` and `gcloud config set project [YOUR PROJECT ID]`.

### Installation and setup

You'll need to obtain the `google-cloud-game-servers` library.  See the [Quickstart](#quickstart) section
to add `google-cloud-game-servers` as a dependency in your code.

## About Cloud Gaming


[Cloud Gaming][product-docs] provides access to the Game Services API.

See the [Cloud Gaming client library docs][javadocs] to learn how to
use this Cloud Gaming Client Library.





## Samples

Samples are in the [`samples/`](https://github.com/googleapis/java-game-servers/tree/master/samples) directory. The samples' `README.md`
has instructions for running the samples.

| Sample                      | Source Code                       | Try it |
| --------------------------- | --------------------------------- | ------ |
| Create Cluster | [source code](https://github.com/googleapis/java-game-servers/blob/master/samples/snippets/src/main/java/com/example/gameservices/clusters/CreateCluster.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-game-servers&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/gameservices/clusters/CreateCluster.java) |
| Delete Cluster | [source code](https://github.com/googleapis/java-game-servers/blob/master/samples/snippets/src/main/java/com/example/gameservices/clusters/DeleteCluster.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-game-servers&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/gameservices/clusters/DeleteCluster.java) |
| Get Cluster | [source code](https://github.com/googleapis/java-game-servers/blob/master/samples/snippets/src/main/java/com/example/gameservices/clusters/GetCluster.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-game-servers&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/gameservices/clusters/GetCluster.java) |
| List Clusters | [source code](https://github.com/googleapis/java-game-servers/blob/master/samples/snippets/src/main/java/com/example/gameservices/clusters/ListClusters.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-game-servers&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/gameservices/clusters/ListClusters.java) |
| Update Cluster | [source code](https://github.com/googleapis/java-game-servers/blob/master/samples/snippets/src/main/java/com/example/gameservices/clusters/UpdateCluster.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-game-servers&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/gameservices/clusters/UpdateCluster.java) |
| Create Deployment | [source code](https://github.com/googleapis/java-game-servers/blob/master/samples/snippets/src/main/java/com/example/gameservices/deployments/CreateDeployment.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-game-servers&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/gameservices/deployments/CreateDeployment.java) |
| Delete Deployment | [source code](https://github.com/googleapis/java-game-servers/blob/master/samples/snippets/src/main/java/com/example/gameservices/deployments/DeleteDeployment.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-game-servers&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/gameservices/deployments/DeleteDeployment.java) |
| Get Deployment | [source code](https://github.com/googleapis/java-game-servers/blob/master/samples/snippets/src/main/java/com/example/gameservices/deployments/GetDeployment.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-game-servers&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/gameservices/deployments/GetDeployment.java) |
| List Deployments | [source code](https://github.com/googleapis/java-game-servers/blob/master/samples/snippets/src/main/java/com/example/gameservices/deployments/ListDeployments.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-game-servers&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/gameservices/deployments/ListDeployments.java) |
| Update Deployment | [source code](https://github.com/googleapis/java-game-servers/blob/master/samples/snippets/src/main/java/com/example/gameservices/deployments/UpdateDeployment.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-game-servers&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/gameservices/deployments/UpdateDeployment.java) |
| Create Realm | [source code](https://github.com/googleapis/java-game-servers/blob/master/samples/snippets/src/main/java/com/example/gameservices/realms/CreateRealm.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-game-servers&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/gameservices/realms/CreateRealm.java) |
| Delete Realm | [source code](https://github.com/googleapis/java-game-servers/blob/master/samples/snippets/src/main/java/com/example/gameservices/realms/DeleteRealm.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-game-servers&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/gameservices/realms/DeleteRealm.java) |
| Get Realm | [source code](https://github.com/googleapis/java-game-servers/blob/master/samples/snippets/src/main/java/com/example/gameservices/realms/GetRealm.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-game-servers&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/gameservices/realms/GetRealm.java) |
| List Realms | [source code](https://github.com/googleapis/java-game-servers/blob/master/samples/snippets/src/main/java/com/example/gameservices/realms/ListRealms.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-game-servers&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/gameservices/realms/ListRealms.java) |
| Update Realm | [source code](https://github.com/googleapis/java-game-servers/blob/master/samples/snippets/src/main/java/com/example/gameservices/realms/UpdateRealm.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-game-servers&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/gameservices/realms/UpdateRealm.java) |



## Troubleshooting

To get help, follow the instructions in the [shared Troubleshooting document][troubleshooting].

## Transport

Cloud Gaming uses gRPC for the transport layer.

## Java Versions

Java 7 or above is required for using this client.

## Versioning


This library follows [Semantic Versioning](http://semver.org/).


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

[product-docs]: https://cloud.google.com/docs/games/products/
[javadocs]: https://googleapis.dev/java/google-cloud-game-servers/latest/
[kokoro-badge-image-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-game-servers/java7.svg
[kokoro-badge-link-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-game-servers/java7.html
[kokoro-badge-image-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-game-servers/java8.svg
[kokoro-badge-link-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-game-servers/java8.html
[kokoro-badge-image-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-game-servers/java8-osx.svg
[kokoro-badge-link-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-game-servers/java8-osx.html
[kokoro-badge-image-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-game-servers/java8-win.svg
[kokoro-badge-link-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-game-servers/java8-win.html
[kokoro-badge-image-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-game-servers/java11.svg
[kokoro-badge-link-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-game-servers/java11.html
[stability-image]: https://img.shields.io/badge/stability-ga-green
[maven-version-image]: https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-game-servers.svg
[maven-version-link]: https://search.maven.org/search?q=g:com.google.cloud%20AND%20a:google-cloud-game-servers&core=gav
[authentication]: https://github.com/googleapis/google-cloud-java#authentication
[developer-console]: https://console.developers.google.com/
[create-project]: https://cloud.google.com/resource-manager/docs/creating-managing-projects
[cloud-sdk]: https://cloud.google.com/sdk/
[troubleshooting]: https://github.com/googleapis/google-cloud-common/blob/master/troubleshooting/readme.md#troubleshooting
[contributing]: https://github.com/googleapis/java-game-servers/blob/master/CONTRIBUTING.md
[code-of-conduct]: https://github.com/googleapis/java-game-servers/blob/master/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[license]: https://github.com/googleapis/java-game-servers/blob/master/LICENSE

[enable-api]: https://console.cloud.google.com/flows/enableapi?apiid=gameservices.googleapis.com
[libraries-bom]: https://github.com/GoogleCloudPlatform/cloud-opensource-java/wiki/The-Google-Cloud-Platform-Libraries-BOM
[shell_img]: https://gstatic.com/cloudssh/images/open-btn.png
