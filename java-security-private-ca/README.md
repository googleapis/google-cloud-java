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
  <version>2.5.4</version>
</dependency>
```

If you are using Gradle without BOM, add this to your dependencies:

```Groovy
implementation 'com.google.cloud:google-cloud-security-private-ca:2.5.4'
```

If you are using SBT, add this to your dependencies:

```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-security-private-ca" % "2.5.4"
```

## Authentication

See the [Authentication][authentication] section in the base directory's README.

## Authorization

The client application making API calls must be granted [authorization scopes][auth-scopes] required for the desired Certificate Authority Service APIs, and the authenticated principal must have the [IAM role(s)][predefined-iam-roles] required to access GCP resources using the Certificate Authority Service API calls.

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

Samples are in the [`samples/`](https://github.com/googleapis/java-security-private-ca/tree/main/samples) directory.

| Sample                      | Source Code                       | Try it |
| --------------------------- | --------------------------------- | ------ |
| Activate Subordinate Ca | [source code](https://github.com/googleapis/java-security-private-ca/blob/main/samples/snippets/cloud-client/src/main/java/privateca/ActivateSubordinateCa.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-security-private-ca&page=editor&open_in_editor=samples/snippets/cloud-client/src/main/java/privateca/ActivateSubordinateCa.java) |
| Create Ca Pool | [source code](https://github.com/googleapis/java-security-private-ca/blob/main/samples/snippets/cloud-client/src/main/java/privateca/CreateCaPool.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-security-private-ca&page=editor&open_in_editor=samples/snippets/cloud-client/src/main/java/privateca/CreateCaPool.java) |
| Create Certificate | [source code](https://github.com/googleapis/java-security-private-ca/blob/main/samples/snippets/cloud-client/src/main/java/privateca/CreateCertificate.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-security-private-ca&page=editor&open_in_editor=samples/snippets/cloud-client/src/main/java/privateca/CreateCertificate.java) |
| Create Certificate Authority | [source code](https://github.com/googleapis/java-security-private-ca/blob/main/samples/snippets/cloud-client/src/main/java/privateca/CreateCertificateAuthority.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-security-private-ca&page=editor&open_in_editor=samples/snippets/cloud-client/src/main/java/privateca/CreateCertificateAuthority.java) |
| Create Certificate Template | [source code](https://github.com/googleapis/java-security-private-ca/blob/main/samples/snippets/cloud-client/src/main/java/privateca/CreateCertificateTemplate.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-security-private-ca&page=editor&open_in_editor=samples/snippets/cloud-client/src/main/java/privateca/CreateCertificateTemplate.java) |
| Create Certificate_CSR | [source code](https://github.com/googleapis/java-security-private-ca/blob/main/samples/snippets/cloud-client/src/main/java/privateca/CreateCertificate_CSR.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-security-private-ca&page=editor&open_in_editor=samples/snippets/cloud-client/src/main/java/privateca/CreateCertificate_CSR.java) |
| Create Subordinate Ca | [source code](https://github.com/googleapis/java-security-private-ca/blob/main/samples/snippets/cloud-client/src/main/java/privateca/CreateSubordinateCa.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-security-private-ca&page=editor&open_in_editor=samples/snippets/cloud-client/src/main/java/privateca/CreateSubordinateCa.java) |
| Delete Ca Pool | [source code](https://github.com/googleapis/java-security-private-ca/blob/main/samples/snippets/cloud-client/src/main/java/privateca/DeleteCaPool.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-security-private-ca&page=editor&open_in_editor=samples/snippets/cloud-client/src/main/java/privateca/DeleteCaPool.java) |
| Delete Certificate Authority | [source code](https://github.com/googleapis/java-security-private-ca/blob/main/samples/snippets/cloud-client/src/main/java/privateca/DeleteCertificateAuthority.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-security-private-ca&page=editor&open_in_editor=samples/snippets/cloud-client/src/main/java/privateca/DeleteCertificateAuthority.java) |
| Delete Certificate Template | [source code](https://github.com/googleapis/java-security-private-ca/blob/main/samples/snippets/cloud-client/src/main/java/privateca/DeleteCertificateTemplate.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-security-private-ca&page=editor&open_in_editor=samples/snippets/cloud-client/src/main/java/privateca/DeleteCertificateTemplate.java) |
| Disable Certificate Authority | [source code](https://github.com/googleapis/java-security-private-ca/blob/main/samples/snippets/cloud-client/src/main/java/privateca/DisableCertificateAuthority.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-security-private-ca&page=editor&open_in_editor=samples/snippets/cloud-client/src/main/java/privateca/DisableCertificateAuthority.java) |
| Enable Certificate Authority | [source code](https://github.com/googleapis/java-security-private-ca/blob/main/samples/snippets/cloud-client/src/main/java/privateca/EnableCertificateAuthority.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-security-private-ca&page=editor&open_in_editor=samples/snippets/cloud-client/src/main/java/privateca/EnableCertificateAuthority.java) |
| Filter Certificates | [source code](https://github.com/googleapis/java-security-private-ca/blob/main/samples/snippets/cloud-client/src/main/java/privateca/FilterCertificates.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-security-private-ca&page=editor&open_in_editor=samples/snippets/cloud-client/src/main/java/privateca/FilterCertificates.java) |
| List Ca Pools | [source code](https://github.com/googleapis/java-security-private-ca/blob/main/samples/snippets/cloud-client/src/main/java/privateca/ListCaPools.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-security-private-ca&page=editor&open_in_editor=samples/snippets/cloud-client/src/main/java/privateca/ListCaPools.java) |
| List Certificate Authorities | [source code](https://github.com/googleapis/java-security-private-ca/blob/main/samples/snippets/cloud-client/src/main/java/privateca/ListCertificateAuthorities.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-security-private-ca&page=editor&open_in_editor=samples/snippets/cloud-client/src/main/java/privateca/ListCertificateAuthorities.java) |
| List Certificate Templates | [source code](https://github.com/googleapis/java-security-private-ca/blob/main/samples/snippets/cloud-client/src/main/java/privateca/ListCertificateTemplates.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-security-private-ca&page=editor&open_in_editor=samples/snippets/cloud-client/src/main/java/privateca/ListCertificateTemplates.java) |
| List Certificates | [source code](https://github.com/googleapis/java-security-private-ca/blob/main/samples/snippets/cloud-client/src/main/java/privateca/ListCertificates.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-security-private-ca&page=editor&open_in_editor=samples/snippets/cloud-client/src/main/java/privateca/ListCertificates.java) |
| Monitor Certificate Authority | [source code](https://github.com/googleapis/java-security-private-ca/blob/main/samples/snippets/cloud-client/src/main/java/privateca/MonitorCertificateAuthority.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-security-private-ca&page=editor&open_in_editor=samples/snippets/cloud-client/src/main/java/privateca/MonitorCertificateAuthority.java) |
| Revoke Certificate | [source code](https://github.com/googleapis/java-security-private-ca/blob/main/samples/snippets/cloud-client/src/main/java/privateca/RevokeCertificate.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-security-private-ca&page=editor&open_in_editor=samples/snippets/cloud-client/src/main/java/privateca/RevokeCertificate.java) |
| Undelete Certificate Authority | [source code](https://github.com/googleapis/java-security-private-ca/blob/main/samples/snippets/cloud-client/src/main/java/privateca/UndeleteCertificateAuthority.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-security-private-ca&page=editor&open_in_editor=samples/snippets/cloud-client/src/main/java/privateca/UndeleteCertificateAuthority.java) |
| Update Ca Pool_Issuance Policy | [source code](https://github.com/googleapis/java-security-private-ca/blob/main/samples/snippets/cloud-client/src/main/java/privateca/UpdateCaPool_IssuancePolicy.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-security-private-ca&page=editor&open_in_editor=samples/snippets/cloud-client/src/main/java/privateca/UpdateCaPool_IssuancePolicy.java) |
| Update Certificate Authority | [source code](https://github.com/googleapis/java-security-private-ca/blob/main/samples/snippets/cloud-client/src/main/java/privateca/UpdateCertificateAuthority.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-security-private-ca&page=editor&open_in_editor=samples/snippets/cloud-client/src/main/java/privateca/UpdateCertificateAuthority.java) |
| Update Certificate Template | [source code](https://github.com/googleapis/java-security-private-ca/blob/main/samples/snippets/cloud-client/src/main/java/privateca/UpdateCertificateTemplate.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-security-private-ca&page=editor&open_in_editor=samples/snippets/cloud-client/src/main/java/privateca/UpdateCertificateTemplate.java) |



## Troubleshooting

To get help, follow the instructions in the [shared Troubleshooting document][troubleshooting].

## Transport

Certificate Authority Service uses gRPC for the transport layer.

## Supported Java Versions

Java 8 or above is required for using this client.

Google's Java client libraries,
[Google Cloud Client Libraries][cloudlibs]
and
[Google Cloud API Libraries][apilibs],
follow the
[Oracle Java SE support roadmap][oracle]
(see the Oracle Java SE Product Releases section).

### For new development

In general, new feature development occurs with support for the lowest Java
LTS version covered by  Oracle's Premier Support (which typically lasts 5 years
from initial General Availability). If the minimum required JVM for a given
library is changed, it is accompanied by a [semver][semver] major release.

Java 11 and (in September 2021) Java 17 are the best choices for new
development.

### Keeping production systems current

Google tests its client libraries with all current LTS versions covered by
Oracle's Extended Support (which typically lasts 8 years from initial
General Availability).

#### Legacy support

Google's client libraries support legacy versions of Java runtimes with long
term stable libraries that don't receive feature updates on a best efforts basis
as it may not be possible to backport all patches.

Google provides updates on a best efforts basis to apps that continue to use
Java 7, though apps might need to upgrade to current versions of the library
that supports their JVM.

#### Where to find specific information

The latest versions and the supported Java versions are identified on
the individual GitHub repository `github.com/GoogleAPIs/java-SERVICENAME`
and on [google-cloud-java][g-c-j].

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
Java 8 | [![Kokoro CI][kokoro-badge-image-2]][kokoro-badge-link-2]
Java 8 OSX | [![Kokoro CI][kokoro-badge-image-3]][kokoro-badge-link-3]
Java 8 Windows | [![Kokoro CI][kokoro-badge-image-4]][kokoro-badge-link-4]
Java 11 | [![Kokoro CI][kokoro-badge-image-5]][kokoro-badge-link-5]

Java is a registered trademark of Oracle and/or its affiliates.

[product-docs]: https://cloud.google.com/certificate-authority-service/docs
[javadocs]: https://cloud.google.com/java/docs/reference/google-cloud-security-private-ca/latest/history
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
[stability-image]: https://img.shields.io/badge/stability-stable-green
[maven-version-image]: https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-security-private-ca.svg
[maven-version-link]: https://search.maven.org/search?q=g:com.google.cloud%20AND%20a:google-cloud-security-private-ca&core=gav
[authentication]: https://github.com/googleapis/google-cloud-java#authentication
[auth-scopes]: https://developers.google.com/identity/protocols/oauth2/scopes
[predefined-iam-roles]: https://cloud.google.com/iam/docs/understanding-roles#predefined_roles
[iam-policy]: https://cloud.google.com/iam/docs/overview#cloud-iam-policy
[developer-console]: https://console.developers.google.com/
[create-project]: https://cloud.google.com/resource-manager/docs/creating-managing-projects
[cloud-sdk]: https://cloud.google.com/sdk/
[troubleshooting]: https://github.com/googleapis/google-cloud-common/blob/main/troubleshooting/readme.md#troubleshooting
[contributing]: https://github.com/googleapis/java-security-private-ca/blob/main/CONTRIBUTING.md
[code-of-conduct]: https://github.com/googleapis/java-security-private-ca/blob/main/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[license]: https://github.com/googleapis/java-security-private-ca/blob/main/LICENSE
[enable-billing]: https://cloud.google.com/apis/docs/getting-started#enabling_billing
[enable-api]: https://console.cloud.google.com/flows/enableapi?apiid=security-privateca.googleapis.com
[libraries-bom]: https://github.com/GoogleCloudPlatform/cloud-opensource-java/wiki/The-Google-Cloud-Platform-Libraries-BOM
[shell_img]: https://gstatic.com/cloudssh/images/open-btn.png

[semver]: https://semver.org/
[cloudlibs]: https://cloud.google.com/apis/docs/client-libraries-explained
[apilibs]: https://cloud.google.com/apis/docs/client-libraries-explained#google_api_client_libraries
[oracle]: https://www.oracle.com/java/technologies/java-se-support-roadmap.html
[g-c-j]: http://github.com/googleapis/google-cloud-java
