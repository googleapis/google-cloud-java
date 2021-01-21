# Google Channel Services Client for Java

Java idiomatic client for [Channel Services][product-docs].


- [Product Documentation][product-docs]

## Authentication

See the [Authentication][authentication] section in the base directory's README.

### Prerequisites

You will need a [Google Cloud Platform Console][developer-console] project with the Channel Services enabled.
You will need to [enable billing][enable-billing] to use Google Channel Services.
[Follow these instructions][create-project] to get your project set up. You will also need to set up the local development environment by
[installing the Google Cloud SDK][cloud-sdk] and running the following commands in command line:
`gcloud auth login` and `gcloud config set project [YOUR PROJECT ID]`.

### Installation and setup

You'll need to obtain the `google-cloud-channel` library.  See the Quickstart section
to add `google-cloud-channel` as a dependency in your code.

## About Channel Services

With [Channel Services][product-docs], Google Cloud partners and resellers have 
a single unified resale platform, with a unified resale catalog, customer management,
order management, billing management, policy and authorization management, and cost 
management.

## Troubleshooting

To get help, follow the instructions in the [shared Troubleshooting document][troubleshooting].

## Transport

Channel Services uses gRPC for the transport layer.

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



[product-docs]: https://cloud.google.com/channel/docs
[stability-image]: https://img.shields.io/badge/stability-beta-yellow
[authentication]: https://github.com/googleapis/google-cloud-java#authentication
[developer-console]: https://console.developers.google.com/
[create-project]: https://cloud.google.com/resource-manager/docs/creating-managing-projects
[cloud-sdk]: https://cloud.google.com/sdk/
[troubleshooting]: https://github.com/googleapis/google-cloud-common/blob/master/troubleshooting/readme.md#troubleshooting
[contributing]: https://github.com/googleapis/java-channel/blob/master/CONTRIBUTING.md
[code-of-conduct]: https://github.com/googleapis/java-channel/blob/master/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[license]: https://github.com/googleapis/java-channel/blob/master/LICENSE
[enable-billing]: https://cloud.google.com/apis/docs/getting-started#enabling_billing
[enable-api]: https://console.cloud.google.com/flows/enableapi?apiid=channel.googleapis.com
[libraries-bom]: https://github.com/GoogleCloudPlatform/cloud-opensource-java/wiki/The-Google-Cloud-Platform-Libraries-BOM
[shell_img]: https://gstatic.com/cloudssh/images/open-btn.png
