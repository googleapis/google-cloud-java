# Changelog

## [1.103.0](https://www.github.com/googleapis/java-pubsub/compare/v1.102.1...v1.103.0) (2020-02-20)


### Features

* add randomly generated UUID to outgoing initial streaming pull requests ([#77](https://www.github.com/googleapis/java-pubsub/issues/77)) ([08e77d4](https://www.github.com/googleapis/java-pubsub/commit/08e77d428aa50bb53ed7d5b922e76c2da18ed6d1))
* adding support for dead letter queues ([#60](https://www.github.com/googleapis/java-pubsub/issues/60)) ([f3c93fa](https://www.github.com/googleapis/java-pubsub/commit/f3c93fa8bf0eb8ebda6eea6c6c6a60a36dc69af2))


### Bug Fixes

* ensure all publishes complete before shutting down publisher ([#76](https://www.github.com/googleapis/java-pubsub/issues/76)) ([d0ab525](https://www.github.com/googleapis/java-pubsub/commit/d0ab52576c729091b4cdc72b378a305e102ca180)), closes [#6784](https://www.github.com/googleapis/java-pubsub/issues/6784) [#11](https://www.github.com/googleapis/java-pubsub/issues/11)
* removing delivery attempt attribute when dead lettering is not enabled ([#72](https://www.github.com/googleapis/java-pubsub/issues/72)) ([535854d](https://www.github.com/googleapis/java-pubsub/commit/535854df64234fe491cae1e3db0c96d685ef0800))
* retry streaming subscriber connections on unknown ([#92](https://www.github.com/googleapis/java-pubsub/issues/92)) ([d702a5c](https://www.github.com/googleapis/java-pubsub/commit/d702a5caa2a1da7a160a449fd91681e38c034afc))
* shutdown grpc stubs properly when a subscriber is stopped ([#74](https://www.github.com/googleapis/java-pubsub/issues/74)) ([9bcc433](https://www.github.com/googleapis/java-pubsub/commit/9bcc433e6d167f68256e0ede2a521296dcbc7412)), closes [#6784](https://www.github.com/googleapis/java-pubsub/issues/6784) [#11](https://www.github.com/googleapis/java-pubsub/issues/11)


### Dependencies

* update core dependencies ([#56](https://www.github.com/googleapis/java-pubsub/issues/56)) ([0188a8a](https://www.github.com/googleapis/java-pubsub/commit/0188a8a550d3aeb2626e7398a2802bf1756240d7))
* update dependency com.google.cloud:google-cloud-core to v1.92.5 ([c296feb](https://www.github.com/googleapis/java-pubsub/commit/c296febe426dc9453b050cb21bcb188a4d09ad50))
* update dependency com.google.http-client:google-http-client-bom to v1.34.1 ([#71](https://www.github.com/googleapis/java-pubsub/issues/71)) ([69fc615](https://www.github.com/googleapis/java-pubsub/commit/69fc6155a4490dcad082abf7742b359c0a0ff885))
* update dependency com.google.protobuf:protobuf-java to v3.11.3 ([#79](https://www.github.com/googleapis/java-pubsub/issues/79)) ([0f77732](https://www.github.com/googleapis/java-pubsub/commit/0f77732e751a83f61fe3b6a7e4b745003fc87474))
* update dependency org.threeten:threetenbp to v1.4.1 ([4383d60](https://www.github.com/googleapis/java-pubsub/commit/4383d6064d8a3ef8d0dd9bc8c65e09b48d6f53dc))


### Documentation

* **regen:** update sample code to set total timeout, add API client header test ([8bc23bc](https://www.github.com/googleapis/java-pubsub/commit/8bc23bc3b68a2c3a2a7caa1d9859dfdd1b56c47d))

### [1.102.1](https://www.github.com/googleapis/java-pubsub/compare/v1.102.0...v1.102.1) (2020-01-07)


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v1.92.0 ([4b3c656](https://www.github.com/googleapis/java-pubsub/commit/4b3c656fbc50d5703bf830e2307fa6ba9cbe31cb))
* update dependency com.google.cloud:google-cloud-core to v1.92.1 ([c9345e3](https://www.github.com/googleapis/java-pubsub/commit/c9345e3178d26e2f8872c3cc5173e4cb9fa61675))
* update dependency com.google.errorprone:error_prone_annotations to v2.3.4 ([#13](https://www.github.com/googleapis/java-pubsub/issues/13)) ([a34c50c](https://www.github.com/googleapis/java-pubsub/commit/a34c50c28c0907129f5eb6bf1380b202eabd8c07))
* update dependency com.google.guava:guava-bom to v28.2-android ([9f0a7b2](https://www.github.com/googleapis/java-pubsub/commit/9f0a7b2c390546321393c5ef0ea972167dac5049))
* update dependency io.grpc:grpc-bom to v1.26.0 ([#38](https://www.github.com/googleapis/java-pubsub/issues/38)) ([c09da56](https://www.github.com/googleapis/java-pubsub/commit/c09da568fffde6256a20be5ff77e98d7a0ba044f))

## [1.102.0](https://www.github.com/googleapis/java-pubsub/compare/1.101.0...v1.102.0) (2019-12-04)


### Features

* make repo releasable, add parent/bom ([#3](https://www.github.com/googleapis/java-pubsub/issues/3)) ([53c4030](https://www.github.com/googleapis/java-pubsub/commit/53c403008f891b79438a8b797156a473e47af5d6))


### Bug Fixes

* ordering keys publishing of last batch ([#9](https://www.github.com/googleapis/java-pubsub/issues/9)) ([02c3771](https://www.github.com/googleapis/java-pubsub/commit/02c3771846bec09c93441c490c7928090a8dd71e))


### Dependencies

* update dependency com.google.protobuf:protobuf-java to v3.11.1 ([#14](https://www.github.com/googleapis/java-pubsub/issues/14)) ([575b3d6](https://www.github.com/googleapis/java-pubsub/commit/575b3d624423d61b6475a86e019246d77f9957fe))
