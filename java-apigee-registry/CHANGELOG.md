# Changelog

## [0.4.0](https://github.com/googleapis/google-cloud-java/compare/google-cloud-apigee-registry-v0.3.1...google-cloud-apigee-registry-v0.4.0) (2022-10-12)


### Features

* [analyticsdata] add `subject_to_thresholding` field to `ResponseMetadata` type ([#8545](https://github.com/googleapis/google-cloud-java/issues/8545)) ([8fdc6c1](https://github.com/googleapis/google-cloud-java/commit/8fdc6c1f10f88f30f4d1407579d645f75366b4cf))
* add `tokens_per_project_per_hour` field to `PropertyQuota` type ([8fdc6c1](https://github.com/googleapis/google-cloud-java/commit/8fdc6c1f10f88f30f4d1407579d645f75366b4cf))


### Bug Fixes

* [apigee-registry] additional error codes added to service configuration for retry ([#8272](https://github.com/googleapis/google-cloud-java/issues/8272)) ([a048a4e](https://github.com/googleapis/google-cloud-java/commit/a048a4e953bde5559b86fd2bff247423f34893f3))
* **deps:** update dependency com.google.api.grpc:grpc-google-cloud-apigee-registry-v1 to v0.3.0 ([#8259](https://github.com/googleapis/google-cloud-java/issues/8259)) ([ee8eba8](https://github.com/googleapis/google-cloud-java/commit/ee8eba80d5080b95b9ad8c8870004c75e1a8d3c7))
* **deps:** update dependency com.google.api.grpc:proto-google-cloud-apigee-registry-v1 to v0.3.0 ([#8261](https://github.com/googleapis/google-cloud-java/issues/8261)) ([bab91a7](https://github.com/googleapis/google-cloud-java/commit/bab91a7aca2c308fd3c20570ecea12b66ec3c0d9))
* **deps:** update dependency com.google.cloud:google-cloud-apigee-registry-parent to v0.3.0 ([#8262](https://github.com/googleapis/google-cloud-java/issues/8262)) ([e05d63e](https://github.com/googleapis/google-cloud-java/commit/e05d63e7754fe88d54ba4692394cd77f316b9218))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.2 ([#8325](https://github.com/googleapis/google-cloud-java/issues/8325)) ([01f492b](https://github.com/googleapis/google-cloud-java/commit/01f492be424acdb90edb23ba66656aeff7cf39eb))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.4 ([#8528](https://github.com/googleapis/google-cloud-java/issues/8528)) ([bd36199](https://github.com/googleapis/google-cloud-java/commit/bd361998ac4eb7c78eef3b3eac39aef31a0cf44e))
* owl-bot-staging should not be commited ([#8337](https://github.com/googleapis/google-cloud-java/issues/8337)) ([c9bb4a9](https://github.com/googleapis/google-cloud-java/commit/c9bb4a97aa19032b78c86c951fe9920f24ac4eec))
* revert reverting [Many APIs] Update WORKSPACE files for rules_gapic, gax_java, generator_java versions ([#8340](https://github.com/googleapis/google-cloud-java/issues/8340)) ([dedef71](https://github.com/googleapis/google-cloud-java/commit/dedef71f600e85b1c38e7110f5ffd44bf2ba32b4))


### Dependencies

* reverting renovate bot pull requests ([#8417](https://github.com/googleapis/google-cloud-java/issues/8417)) ([8f0c60b](https://github.com/googleapis/google-cloud-java/commit/8f0c60bde446acccc665eb7894723632eefc3503))

## [0.3.0](https://github.com/googleapis/java-apigee-registry/compare/v0.2.2...v0.3.0) (2022-08-22)


### Features

* added support for `force` field for API and API version deletion ([#35](https://github.com/googleapis/java-apigee-registry/issues/35)) ([01d3a88](https://github.com/googleapis/java-apigee-registry/commit/01d3a88d30ba74ca090b823d1003e21d192baef2))

## [0.2.2](https://github.com/googleapis/java-apigee-registry/compare/v0.2.1...v0.2.2) (2022-08-09)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v3 ([#26](https://github.com/googleapis/java-apigee-registry/issues/26)) ([fa06925](https://github.com/googleapis/java-apigee-registry/commit/fa069254108fa6a6c9d2ec6daddbf8982d5aae52))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.1 ([#29](https://github.com/googleapis/java-apigee-registry/issues/29)) ([62ad9c6](https://github.com/googleapis/java-apigee-registry/commit/62ad9c69ee3d591062f1a9dc2197284be566e7e1))

## [0.2.1](https://github.com/googleapis/java-apigee-registry/compare/v0.2.0...v0.2.1) (2022-07-13)


### Bug Fixes

* enable longpaths support for windows test ([#1485](https://github.com/googleapis/java-apigee-registry/issues/1485)) ([#20](https://github.com/googleapis/java-apigee-registry/issues/20)) ([3a18bee](https://github.com/googleapis/java-apigee-registry/commit/3a18bee5b0048c87592ae53f03bef28a28f01273))

## [0.2.0](https://github.com/googleapis/java-apigee-registry/compare/v0.1.1...v0.2.0) (2022-07-01)


### Features

* Enable REST transport for most of Java and Go clients ([#7](https://github.com/googleapis/java-apigee-registry/issues/7)) ([463630a](https://github.com/googleapis/java-apigee-registry/commit/463630a9abc53132b6d38552784074e95f9a51db))


### Bug Fixes

* update gapic-generator-java with mock service generation fixes ([#14](https://github.com/googleapis/java-apigee-registry/issues/14)) ([6078cde](https://github.com/googleapis/java-apigee-registry/commit/6078cdef003e503b5ea36ab1d5154608b088c02a))

## [0.1.1](https://github.com/googleapis/java-apigee-registry/compare/v0.1.0...v0.1.1) (2022-06-23)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.13.0 ([#6](https://github.com/googleapis/java-apigee-registry/issues/6)) ([f8ceba2](https://github.com/googleapis/java-apigee-registry/commit/f8ceba29e32778f95cbd0b7800cfb1036eb26cec))

## 0.1.0 (2022-06-14)


### Features

* initial generation ([15af9fe](https://github.com/googleapis/java-apigee-registry/commit/15af9fec12fa6cb6d5d8da2215735b16ff442312))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-config to v1.5.0 ([270b181](https://github.com/googleapis/java-apigee-registry/commit/270b18179fc5bfa6edca52a3e7b6e96d3b258661))
