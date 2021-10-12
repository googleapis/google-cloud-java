# Google Cloud Shared Build Configs

Shared Maven build configuration for Google Cloud Java client libraries.

[![Maven][maven-version-image]][maven-version-link]

## Quickstart

[//]: # ({x-version-update-start:google-cloud-shared-config:released})
If you are using Maven, use this artifact as your project's parent.
```xml
<project>
  <parent>
    <groupId>com.google.cloud</groupId>
    <artifactId>google-cloud-shared-config</artifactId>
    <version>1.1.0</version>
  </parent>
</project>
```
[//]: # ({x-version-update-end})

## Versioning

This library follows [Semantic Versioning](http://semver.org/).

It is currently in major version zero (``0.y.z``), which means that anything may change at any time
and the public API should not be considered stable.

## Contributing

Contributions to this library are always welcome and highly encouraged.

See [CONTRIBUTING.md][contributing] documentation for more information on how to get started.

Please note that this project is released with a Contributor Code of Conduct. By participating in
this project you agree to abide by its terms. See [Code of Conduct][code-of-conduct] for more
information.

## License

Apache 2.0 - See [LICENSE][license] for more information.

[maven-version-image]: https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-shared-config.svg
[maven-version-link]: https://search.maven.org/search?q=g:com.google.cloud%20AND%20a:google-cloud-shared-config&core=gav
[contributing]: https://github.com/googleapis/java-shared-config/blob/main/CONTRIBUTING.md
[code-of-conduct]: https://github.com/googleapis/java-shared-config/blob/main/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[license]: https://github.com/googleapis/java-shared-config/blob/main/LICENSE