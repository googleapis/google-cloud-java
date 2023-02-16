# Google Cloud Shared Dependencies

Shared Maven dependencies for Google Cloud Java client libraries.

[![Maven][maven-version-image]][maven-version-link]

## Quickstart

[//]: # ({x-version-update-start:google-cloud-shared-dependencies:released})
If you are using Maven, add this to the `dependencyManagement` section.
```xml
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>com.google.cloud</groupId>
      <artifactId>google-cloud-shared-dependencies</artifactId>
      <version>3.3.0</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>
```
[//]: # ({x-version-update-end})

## Versioning

This library follows [Semantic Versioning](http://semver.org/).

## Contributing

Contributions to this library are always welcome and highly encouraged.

See [CONTRIBUTING.md][contributing] documentation for more information on how to get started.

Please note that this project is released with a Contributor Code of Conduct. By participating in
this project you agree to abide by its terms. See [Code of Conduct][code-of-conduct] for more
information.

## License

Apache 2.0 - See [LICENSE][license] for more information.

[maven-version-image]: https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-shared-dependencies.svg
[maven-version-link]: https://search.maven.org/search?q=g:com.google.cloud%20AND%20a:google-cloud-shared-dependencies&core=gav
[contributing]: https://github.com/googleapis/java-shared-dependencies/blob/main/CONTRIBUTING.md
[code-of-conduct]: https://github.com/googleapis/java-shared-dependencies/blob/main/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[license]: https://github.com/googleapis/java-shared-dependencies/blob/main/LICENSE
