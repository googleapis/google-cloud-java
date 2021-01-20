# Google Talent Solution Client for Java

Java idiomatic client for [Talent Solution][product-docs].

[![Maven][maven-version-image]][maven-version-link]
![Stability][stability-image]

- [Product Documentation][product-docs]
- [Client Library Documentation][javadocs]

## Quickstart

If you are using Maven with [BOM][libraries-bom], add this to your pom.xml file
```xml
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>com.google.cloud</groupId>
      <artifactId>libraries-bom</artifactId>
      <version>16.3.0</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>

<dependencies>
  <dependency>
    <groupId>com.google.cloud</groupId>
    <artifactId>google-cloud-talent</artifactId>
  </dependency>

```

If you are using Maven without BOM, add this to your dependencies:

```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-talent</artifactId>
  <version>1.0.5</version>
</dependency>

```

If you are using Gradle 5.x or later, add this to your dependencies
```Groovy
implementation platform('com.google.cloud:libraries-bom:16.3.0')

compile 'com.google.cloud:google-cloud-talent'
```
If you are using Gradle without BOM, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-talent:1.0.5'
```

If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-talent" % "1.0.5"
```

## Authentication

See the [Authentication][authentication] section in the base directory's README.

## Getting Started

### Prerequisites

You will need a [Google Cloud Platform Console][developer-console] project with the Talent Solution [API enabled][enable-api].
You will need to [enable billing][enable-billing] to use Google Talent Solution.
[Follow these instructions][create-project] to get your project set up. You will also need to set up the local development environment by
[installing the Google Cloud SDK][cloud-sdk] and running the following commands in command line:
`gcloud auth login` and `gcloud config set project [YOUR PROJECT ID]`.

### Installation and setup

You'll need to obtain the `google-cloud-talent` library.  See the [Quickstart](#quickstart) section
to add `google-cloud-talent` as a dependency in your code.

## About Talent Solution


[Talent Solution][product-docs] allows you to transform your job search and candidate matching capabilities with Cloud Talent Solution, designed to support enterprise talent acquisition technology and evolve with your growing needs. This AI solution includes features such as Job Search and Profile Search (Beta) to provide candidates and employers with an enhanced talent acquisition experience. Learn more about Cloud Talent Solution from the product overview page.

See the [Talent Solution client library docs][javadocs] to learn how to
use this Talent Solution Client Library.





## Samples

Samples are in the [`samples/`](https://github.com/googleapis/java-talent/tree/master/samples) directory. The samples' `README.md`
has instructions for running the samples.

| Sample                      | Source Code                       | Try it |
| --------------------------- | --------------------------------- | ------ |
| None | [source code](https://github.com/googleapis/java-talent/blob/master/samples/generated/src/main/java/com/google/cloud/examples/talent/v4beta1/JobSearchAutocompleteJobTitle.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-talent&page=editor&open_in_editor=samples/generated/src/main/java/com/google/cloud/examples/talent/v4beta1/JobSearchAutocompleteJobTitle.java) |
| None | [source code](https://github.com/googleapis/java-talent/blob/master/samples/generated/src/main/java/com/google/cloud/examples/talent/v4beta1/JobSearchBatchCreateJobs.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-talent&page=editor&open_in_editor=samples/generated/src/main/java/com/google/cloud/examples/talent/v4beta1/JobSearchBatchCreateJobs.java) |
| None | [source code](https://github.com/googleapis/java-talent/blob/master/samples/generated/src/main/java/com/google/cloud/examples/talent/v4beta1/JobSearchBatchDeleteJob.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-talent&page=editor&open_in_editor=samples/generated/src/main/java/com/google/cloud/examples/talent/v4beta1/JobSearchBatchDeleteJob.java) |
| None | [source code](https://github.com/googleapis/java-talent/blob/master/samples/generated/src/main/java/com/google/cloud/examples/talent/v4beta1/JobSearchBatchUpdateJobs.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-talent&page=editor&open_in_editor=samples/generated/src/main/java/com/google/cloud/examples/talent/v4beta1/JobSearchBatchUpdateJobs.java) |
| None | [source code](https://github.com/googleapis/java-talent/blob/master/samples/generated/src/main/java/com/google/cloud/examples/talent/v4beta1/JobSearchCommuteSearch.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-talent&page=editor&open_in_editor=samples/generated/src/main/java/com/google/cloud/examples/talent/v4beta1/JobSearchCommuteSearch.java) |
| None | [source code](https://github.com/googleapis/java-talent/blob/master/samples/generated/src/main/java/com/google/cloud/examples/talent/v4beta1/JobSearchCreateClientEvent.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-talent&page=editor&open_in_editor=samples/generated/src/main/java/com/google/cloud/examples/talent/v4beta1/JobSearchCreateClientEvent.java) |
| None | [source code](https://github.com/googleapis/java-talent/blob/master/samples/generated/src/main/java/com/google/cloud/examples/talent/v4beta1/JobSearchCreateCompany.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-talent&page=editor&open_in_editor=samples/generated/src/main/java/com/google/cloud/examples/talent/v4beta1/JobSearchCreateCompany.java) |
| None | [source code](https://github.com/googleapis/java-talent/blob/master/samples/generated/src/main/java/com/google/cloud/examples/talent/v4beta1/JobSearchCreateJob.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-talent&page=editor&open_in_editor=samples/generated/src/main/java/com/google/cloud/examples/talent/v4beta1/JobSearchCreateJob.java) |
| None | [source code](https://github.com/googleapis/java-talent/blob/master/samples/generated/src/main/java/com/google/cloud/examples/talent/v4beta1/JobSearchCreateJobCustomAttributes.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-talent&page=editor&open_in_editor=samples/generated/src/main/java/com/google/cloud/examples/talent/v4beta1/JobSearchCreateJobCustomAttributes.java) |
| None | [source code](https://github.com/googleapis/java-talent/blob/master/samples/generated/src/main/java/com/google/cloud/examples/talent/v4beta1/JobSearchCreateTenant.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-talent&page=editor&open_in_editor=samples/generated/src/main/java/com/google/cloud/examples/talent/v4beta1/JobSearchCreateTenant.java) |
| None | [source code](https://github.com/googleapis/java-talent/blob/master/samples/generated/src/main/java/com/google/cloud/examples/talent/v4beta1/JobSearchCustomRankingSearch.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-talent&page=editor&open_in_editor=samples/generated/src/main/java/com/google/cloud/examples/talent/v4beta1/JobSearchCustomRankingSearch.java) |
| None | [source code](https://github.com/googleapis/java-talent/blob/master/samples/generated/src/main/java/com/google/cloud/examples/talent/v4beta1/JobSearchDeleteCompany.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-talent&page=editor&open_in_editor=samples/generated/src/main/java/com/google/cloud/examples/talent/v4beta1/JobSearchDeleteCompany.java) |
| None | [source code](https://github.com/googleapis/java-talent/blob/master/samples/generated/src/main/java/com/google/cloud/examples/talent/v4beta1/JobSearchDeleteJob.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-talent&page=editor&open_in_editor=samples/generated/src/main/java/com/google/cloud/examples/talent/v4beta1/JobSearchDeleteJob.java) |
| None | [source code](https://github.com/googleapis/java-talent/blob/master/samples/generated/src/main/java/com/google/cloud/examples/talent/v4beta1/JobSearchDeleteTenant.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-talent&page=editor&open_in_editor=samples/generated/src/main/java/com/google/cloud/examples/talent/v4beta1/JobSearchDeleteTenant.java) |
| None | [source code](https://github.com/googleapis/java-talent/blob/master/samples/generated/src/main/java/com/google/cloud/examples/talent/v4beta1/JobSearchGetCompany.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-talent&page=editor&open_in_editor=samples/generated/src/main/java/com/google/cloud/examples/talent/v4beta1/JobSearchGetCompany.java) |
| None | [source code](https://github.com/googleapis/java-talent/blob/master/samples/generated/src/main/java/com/google/cloud/examples/talent/v4beta1/JobSearchGetJob.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-talent&page=editor&open_in_editor=samples/generated/src/main/java/com/google/cloud/examples/talent/v4beta1/JobSearchGetJob.java) |
| None | [source code](https://github.com/googleapis/java-talent/blob/master/samples/generated/src/main/java/com/google/cloud/examples/talent/v4beta1/JobSearchGetTenant.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-talent&page=editor&open_in_editor=samples/generated/src/main/java/com/google/cloud/examples/talent/v4beta1/JobSearchGetTenant.java) |
| None | [source code](https://github.com/googleapis/java-talent/blob/master/samples/generated/src/main/java/com/google/cloud/examples/talent/v4beta1/JobSearchHistogramSearch.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-talent&page=editor&open_in_editor=samples/generated/src/main/java/com/google/cloud/examples/talent/v4beta1/JobSearchHistogramSearch.java) |
| None | [source code](https://github.com/googleapis/java-talent/blob/master/samples/generated/src/main/java/com/google/cloud/examples/talent/v4beta1/JobSearchListCompanies.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-talent&page=editor&open_in_editor=samples/generated/src/main/java/com/google/cloud/examples/talent/v4beta1/JobSearchListCompanies.java) |
| None | [source code](https://github.com/googleapis/java-talent/blob/master/samples/generated/src/main/java/com/google/cloud/examples/talent/v4beta1/JobSearchListJobs.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-talent&page=editor&open_in_editor=samples/generated/src/main/java/com/google/cloud/examples/talent/v4beta1/JobSearchListJobs.java) |
| None | [source code](https://github.com/googleapis/java-talent/blob/master/samples/generated/src/main/java/com/google/cloud/examples/talent/v4beta1/JobSearchListTenants.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-talent&page=editor&open_in_editor=samples/generated/src/main/java/com/google/cloud/examples/talent/v4beta1/JobSearchListTenants.java) |
| Commute Search Jobs | [source code](https://github.com/googleapis/java-talent/blob/master/samples/snippets/src/main/java/com/example/jobs/CommuteSearchJobs.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-talent&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/jobs/CommuteSearchJobs.java) |
| Custom Ranking Search Jobs | [source code](https://github.com/googleapis/java-talent/blob/master/samples/snippets/src/main/java/com/example/jobs/CustomRankingSearchJobs.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-talent&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/jobs/CustomRankingSearchJobs.java) |
| Histogram Search Jobs | [source code](https://github.com/googleapis/java-talent/blob/master/samples/snippets/src/main/java/com/example/jobs/HistogramSearchJobs.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-talent&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/jobs/HistogramSearchJobs.java) |
| Job Search Auto Complete Job Title | [source code](https://github.com/googleapis/java-talent/blob/master/samples/snippets/src/main/java/com/example/jobs/JobSearchAutoCompleteJobTitle.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-talent&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/jobs/JobSearchAutoCompleteJobTitle.java) |
| Job Search Create Client Event | [source code](https://github.com/googleapis/java-talent/blob/master/samples/snippets/src/main/java/com/example/jobs/JobSearchCreateClientEvent.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-talent&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/jobs/JobSearchCreateClientEvent.java) |
| Job Search Create Company | [source code](https://github.com/googleapis/java-talent/blob/master/samples/snippets/src/main/java/com/example/jobs/JobSearchCreateCompany.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-talent&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/jobs/JobSearchCreateCompany.java) |
| Job Search Create Job | [source code](https://github.com/googleapis/java-talent/blob/master/samples/snippets/src/main/java/com/example/jobs/JobSearchCreateJob.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-talent&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/jobs/JobSearchCreateJob.java) |
| Job Search Create Job Custom Attributes | [source code](https://github.com/googleapis/java-talent/blob/master/samples/snippets/src/main/java/com/example/jobs/JobSearchCreateJobCustomAttributes.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-talent&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/jobs/JobSearchCreateJobCustomAttributes.java) |
| Job Search Create Tenant | [source code](https://github.com/googleapis/java-talent/blob/master/samples/snippets/src/main/java/com/example/jobs/JobSearchCreateTenant.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-talent&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/jobs/JobSearchCreateTenant.java) |
| Job Search Delete Company | [source code](https://github.com/googleapis/java-talent/blob/master/samples/snippets/src/main/java/com/example/jobs/JobSearchDeleteCompany.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-talent&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/jobs/JobSearchDeleteCompany.java) |
| Job Search Delete Job | [source code](https://github.com/googleapis/java-talent/blob/master/samples/snippets/src/main/java/com/example/jobs/JobSearchDeleteJob.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-talent&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/jobs/JobSearchDeleteJob.java) |
| Job Search Delete Tenant | [source code](https://github.com/googleapis/java-talent/blob/master/samples/snippets/src/main/java/com/example/jobs/JobSearchDeleteTenant.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-talent&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/jobs/JobSearchDeleteTenant.java) |
| Job Search Get Company | [source code](https://github.com/googleapis/java-talent/blob/master/samples/snippets/src/main/java/com/example/jobs/JobSearchGetCompany.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-talent&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/jobs/JobSearchGetCompany.java) |
| Job Search Get Job | [source code](https://github.com/googleapis/java-talent/blob/master/samples/snippets/src/main/java/com/example/jobs/JobSearchGetJob.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-talent&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/jobs/JobSearchGetJob.java) |
| Job Search Get Tenant | [source code](https://github.com/googleapis/java-talent/blob/master/samples/snippets/src/main/java/com/example/jobs/JobSearchGetTenant.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-talent&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/jobs/JobSearchGetTenant.java) |
| Job Search List Companies | [source code](https://github.com/googleapis/java-talent/blob/master/samples/snippets/src/main/java/com/example/jobs/JobSearchListCompanies.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-talent&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/jobs/JobSearchListCompanies.java) |
| Job Search List Jobs | [source code](https://github.com/googleapis/java-talent/blob/master/samples/snippets/src/main/java/com/example/jobs/JobSearchListJobs.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-talent&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/jobs/JobSearchListJobs.java) |
| Job Search List Tenants | [source code](https://github.com/googleapis/java-talent/blob/master/samples/snippets/src/main/java/com/example/jobs/JobSearchListTenants.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-talent&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/jobs/JobSearchListTenants.java) |



## Troubleshooting

To get help, follow the instructions in the [shared Troubleshooting document][troubleshooting].

## Transport

Talent Solution uses gRPC for the transport layer.

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

[product-docs]: https://cloud.google.com/solutions/talent-solution/
[javadocs]: https://googleapis.dev/java/google-cloud-talent/latest/
[kokoro-badge-image-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-talent/java7.svg
[kokoro-badge-link-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-talent/java7.html
[kokoro-badge-image-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-talent/java8.svg
[kokoro-badge-link-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-talent/java8.html
[kokoro-badge-image-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-talent/java8-osx.svg
[kokoro-badge-link-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-talent/java8-osx.html
[kokoro-badge-image-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-talent/java8-win.svg
[kokoro-badge-link-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-talent/java8-win.html
[kokoro-badge-image-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-talent/java11.svg
[kokoro-badge-link-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-talent/java11.html
[stability-image]: https://img.shields.io/badge/stability-ga-green
[maven-version-image]: https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-talent.svg
[maven-version-link]: https://search.maven.org/search?q=g:com.google.cloud%20AND%20a:google-cloud-talent&core=gav
[authentication]: https://github.com/googleapis/google-cloud-java#authentication
[developer-console]: https://console.developers.google.com/
[create-project]: https://cloud.google.com/resource-manager/docs/creating-managing-projects
[cloud-sdk]: https://cloud.google.com/sdk/
[troubleshooting]: https://github.com/googleapis/google-cloud-common/blob/master/troubleshooting/readme.md#troubleshooting
[contributing]: https://github.com/googleapis/java-talent/blob/master/CONTRIBUTING.md
[code-of-conduct]: https://github.com/googleapis/java-talent/blob/master/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[license]: https://github.com/googleapis/java-talent/blob/master/LICENSE
[enable-billing]: https://cloud.google.com/apis/docs/getting-started#enabling_billing
[enable-api]: https://console.cloud.google.com/flows/enableapi?apiid=jobs.googleapis.com
[libraries-bom]: https://github.com/GoogleCloudPlatform/cloud-opensource-java/wiki/The-Google-Cloud-Platform-Libraries-BOM
[shell_img]: https://gstatic.com/cloudssh/images/open-btn.png
