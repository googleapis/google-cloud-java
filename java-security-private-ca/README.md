# Google Certificate Authority Service Client for Java

Java idiomatic client for [Certificate Authority Service][product-docs].

[![Maven][maven-version-image]][maven-version-link]
![Stability][stability-image]

- [Product Documentation][product-docs]
- [Client Library Documentation][javadocs]

## Quickstart


If you are using Maven, add this to your pom.xml file:

```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-security-private-ca</artifactId>
  <version>1.0.0</version>
</dependency>
```

If you are using Gradle without BOM, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-security-private-ca:1.0.0'
```

If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-security-private-ca" % "1.0.0"
```

## Authentication

See the [Authentication][authentication] section in the base directory's README.

## Getting Started

### Prerequisites

You will need a [Google Cloud Platform Console][developer-console] project with the Certificate Authority Service [API enabled][enable-api].
You will need to [enable billing][enable-billing] to use Google Certificate Authority Service.
[Follow these instructions][create-project] to get your project set up. You will also need to set up the local development environment by
[installing the Google Cloud SDK][cloud-sdk] and running the following commands in command line:
`gcloud auth login` and `gcloud config set project [YOUR PROJECT ID]`.

### Installation and setup

You'll need to obtain the `google-cloud-security-private-ca` library.  See the [Quickstart](#quickstart) section
to add `google-cloud-security-private-ca` as a dependency in your code.

## About Certificate Authority Service


[Certificate Authority Service][product-docs] simplifies the deployment and management of private CAs without managing infrastructure.

See the [Certificate Authority Service client library docs][javadocs] to learn how to
use this Certificate Authority Service Client Library.





## Samples

Samples are in the [`samples/`](https://github.com/googleapis/java-security-private-ca/tree/master/samples) directory. The samples' `README.md`
has instructions for running the samples.

| Sample                      | Source Code                       | Try it |
| --------------------------- | --------------------------------- | ------ |
| Create Ca Pool | [source code](https://github.com/googleapis/java-security-private-ca/blob/master/samples/snippets/cloud-client/src/main/java/privateca/CreateCaPool.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-security-private-ca&page=editor&open_in_editor=samples/snippets/cloud-client/src/main/java/privateca/CreateCaPool.java) |
| Create Certificate | [source code](https://github.com/googleapis/java-security-private-ca/blob/master/samples/snippets/cloud-client/src/main/java/privateca/CreateCertificate.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-security-private-ca&page=editor&open_in_editor=samples/snippets/cloud-client/src/main/java/privateca/CreateCertificate.java) |
| Create Certificate Authority | [source code](https://github.com/googleapis/java-security-private-ca/blob/master/samples/snippets/cloud-client/src/main/java/privateca/CreateCertificateAuthority.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-security-private-ca&page=editor&open_in_editor=samples/snippets/cloud-client/src/main/java/privateca/CreateCertificateAuthority.java) |
| Delete Ca Pool | [source code](https://github.com/googleapis/java-security-private-ca/blob/master/samples/snippets/cloud-client/src/main/java/privateca/DeleteCaPool.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-security-private-ca&page=editor&open_in_editor=samples/snippets/cloud-client/src/main/java/privateca/DeleteCaPool.java) |
| Delete Certificate Authority | [source code](https://github.com/googleapis/java-security-private-ca/blob/master/samples/snippets/cloud-client/src/main/java/privateca/DeleteCertificateAuthority.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-security-private-ca&page=editor&open_in_editor=samples/snippets/cloud-client/src/main/java/privateca/DeleteCertificateAuthority.java) |
| Disable Certificate Authority | [source code](https://github.com/googleapis/java-security-private-ca/blob/master/samples/snippets/cloud-client/src/main/java/privateca/DisableCertificateAuthority.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-security-private-ca&page=editor&open_in_editor=samples/snippets/cloud-client/src/main/java/privateca/DisableCertificateAuthority.java) |
| Enable Certificate Authority | [source code](https://github.com/googleapis/java-security-private-ca/blob/master/samples/snippets/cloud-client/src/main/java/privateca/EnableCertificateAuthority.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-security-private-ca&page=editor&open_in_editor=samples/snippets/cloud-client/src/main/java/privateca/EnableCertificateAuthority.java) |
| List Ca Pools | [source code](https://github.com/googleapis/java-security-private-ca/blob/master/samples/snippets/cloud-client/src/main/java/privateca/ListCaPools.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-security-private-ca&page=editor&open_in_editor=samples/snippets/cloud-client/src/main/java/privateca/ListCaPools.java) |
| List Certificate Authorities | [source code](https://github.com/googleapis/java-security-private-ca/blob/master/samples/snippets/cloud-client/src/main/java/privateca/ListCertificateAuthorities.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-security-private-ca&page=editor&open_in_editor=samples/snippets/cloud-client/src/main/java/privateca/ListCertificateAuthorities.java) |
| List Certificates | [source code](https://github.com/googleapis/java-security-private-ca/blob/master/samples/snippets/cloud-client/src/main/java/privateca/ListCertificates.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-security-private-ca&page=editor&open_in_editor=samples/snippets/cloud-client/src/main/java/privateca/ListCertificates.java) |
| Revoke Certificate | [source code](https://github.com/googleapis/java-security-private-ca/blob/master/samples/snippets/cloud-client/src/main/java/privateca/RevokeCertificate.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-security-private-ca&page=editor&open_in_editor=samples/snippets/cloud-client/src/main/java/privateca/RevokeCertificate.java) |



## Troubleshooting

To get help, follow the instructions in the [shared Troubleshooting document][troubleshooting].

## Transport

Certificate Authority Service uses gRPC for the transport layer.

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

[product-docs]: https://cloud.google.com/certificate-authority-service/docs
[javadocs]: https://googleapis.dev/java/google-cloud-security-private-ca/latest/index.html
[kokoro-badge-image-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-security-private-ca/java7.svg
[kokoro-badge-link-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-security-private-ca/java7.html
[kokoro-badge-image-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-security-private-ca/java8.svg
[kokoro-badge-link-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-security-private-ca/java8.html
[kokoro-badge-image-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-security-private-ca/java8-osx.svg
[kokoro-badge-link-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-security-private-ca/java8-osx.html
[kokoro-badge-image-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-security-private-ca/java8-win.svg
[kokoro-badge-link-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-security-private-ca/java8-win.html
[kokoro-badge-image-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-security-private-ca/java11.svg
[kokoro-badge-link-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-security-private-ca/java11.html
[stability-image]: https://img.shields.io/badge/stability-ga-green
[maven-version-image]: https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-security-private-ca.svg
[maven-version-link]: https://search.maven.org/search?q=g:com.google.cloud%20AND%20a:google-cloud-security-private-ca&core=gav
[authentication]: https://github.com/googleapis/google-cloud-java#authentication
[developer-console]: https://console.developers.google.com/
[create-project]: https://cloud.google.com/resource-manager/docs/creating-managing-projects
[cloud-sdk]: https://cloud.google.com/sdk/
[troubleshooting]: https://github.com/googleapis/google-cloud-common/blob/master/troubleshooting/readme.md#troubleshooting
[contributing]: https://github.com/googleapis/java-security-private-ca/blob/master/CONTRIBUTING.md
[code-of-conduct]: https://github.com/googleapis/java-security-private-ca/blob/master/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[license]: https://github.com/googleapis/java-security-private-ca/blob/master/LICENSE
[enable-billing]: https://cloud.google.com/apis/docs/getting-started#enabling_billing
[enable-api]: https://console.cloud.google.com/flows/enableapi?apiid=security-privateca.googleapis.com
[libraries-bom]: https://github.com/GoogleCloudPlatform/cloud-opensource-java/wiki/The-Google-Cloud-Platform-Libraries-BOM
[shell_img]: https://gstatic.com/cloudssh/images/open-btn.png
