# Changelog

### [1.104.1](https://www.github.com/googleapis/java-pubsub/compare/v1.104.0...v1.104.1) (2020-04-08)


### Dependencies

* update core dependencies ([#127](https://www.github.com/googleapis/java-pubsub/issues/127)) ([33c9293](https://www.github.com/googleapis/java-pubsub/commit/33c9293fbb7de6de6861c4b2c3e3e79fb9e57e7b))
* update dependency com.google.cloud:google-cloud-core to v1.93.4 ([#129](https://www.github.com/googleapis/java-pubsub/issues/129)) ([78c0216](https://www.github.com/googleapis/java-pubsub/commit/78c021628c86317d3893f2797ccc5039cffd453a))
* update dependency org.threeten:threetenbp to v1.4.3 ([#128](https://www.github.com/googleapis/java-pubsub/issues/128)) ([54650dd](https://www.github.com/googleapis/java-pubsub/commit/54650dd6115f055d8a66c164017d1a038552dfac))

## [1.104.0](https://www.github.com/googleapis/java-pubsub/compare/v1.103.1...v1.104.0) (2020-04-02)


### Features

* Add flow control support to publisher ([#119](https://www.github.com/googleapis/java-pubsub/issues/119)) ([fdd9434](https://www.github.com/googleapis/java-pubsub/commit/fdd943433cface4bc6634f74aa12afa6e471f3a3))
* add TopicName ([#113](https://www.github.com/googleapis/java-pubsub/issues/113)) ([4558c34](https://www.github.com/googleapis/java-pubsub/commit/4558c3430901cdaec12a43e06ea4fafaa01c08e0))


### Bug Fixes

* Re-generated  to pick up changes in the API or client library generator. ([#104](https://www.github.com/googleapis/java-pubsub/issues/104)) ([0e366c3](https://www.github.com/googleapis/java-pubsub/commit/0e366c35580116fcd6aa40caadedd95be07bdd87))


### Dependencies

* update core dependencies ([#105](https://www.github.com/googleapis/java-pubsub/issues/105)) ([5639f63](https://www.github.com/googleapis/java-pubsub/commit/5639f6321e1506fdf803f5de58f2c7fdf5afb448))
* update core dependencies to v1.55.0 ([#122](https://www.github.com/googleapis/java-pubsub/issues/122)) ([3ea1202](https://www.github.com/googleapis/java-pubsub/commit/3ea1202dbe13b60cfdc14c2855e878e190a52199))
* update dependency com.google.api:api-common to v1.9.0 ([#121](https://www.github.com/googleapis/java-pubsub/issues/121)) ([30a1dee](https://www.github.com/googleapis/java-pubsub/commit/30a1deecbecf63d1629ae93407658865518febce))
* update dependency org.threeten:threetenbp to v1.4.2 ([#116](https://www.github.com/googleapis/java-pubsub/issues/116)) ([e7c007b](https://www.github.com/googleapis/java-pubsub/commit/e7c007b917618e75f9c8fecd2475f31c7eba0817))
* update opencensus.version to v0.26.0 ([#115](https://www.github.com/googleapis/java-pubsub/issues/115)) ([26aec5d](https://www.github.com/googleapis/java-pubsub/commit/26aec5d7ee45bec5b39b6cbe67122a6e5944268e))

### [1.103.1](https://www.github.com/googleapis/java-pubsub/compare/v1.103.0...v1.103.1) (2020-03-03)


### Bug Fixes

* add a default value for max outstanding request bytes flow control setting ([#96](https://www.github.com/googleapis/java-pubsub/issues/96)) ([4a6046c](https://www.github.com/googleapis/java-pubsub/commit/4a6046c2b03ad1d7e08d6e6dc0d1817cbffc5283))
* remove deprecated tag that was added prematurely ([#97](https://www.github.com/googleapis/java-pubsub/issues/97)) ([fbb87ef](https://www.github.com/googleapis/java-pubsub/commit/fbb87ef0d493fc9e375e860b52dd6a9b99e3cf00))


### Dependencies

* update core dependencies ([#100](https://www.github.com/googleapis/java-pubsub/issues/100)) ([8323b31](https://www.github.com/googleapis/java-pubsub/commit/8323b31b9349065f1798120b6ffdaff3372f8552))
* update dependency com.google.cloud:google-cloud-core to v1.93.1 ([#102](https://www.github.com/googleapis/java-pubsub/issues/102)) ([33b12df](https://www.github.com/googleapis/java-pubsub/commit/33b12df2e8c54ac404aeabd97ef71404611f3e3b))
* update dependency com.google.http-client:google-http-client-bom to v1.34.2 ([19fde3a](https://www.github.com/googleapis/java-pubsub/commit/19fde3ab100c4910c4d998fbf0e5380ad7732f90))
* update dependency com.google.protobuf:protobuf-java to v3.11.4 ([e49a861](https://www.github.com/googleapis/java-pubsub/commit/e49a8615147779d9dab07661e7586395ffa26d1f))
* update dependency io.grpc:grpc-bom to v1.27.1 ([013b0c3](https://www.github.com/googleapis/java-pubsub/commit/013b0c3e4ee09926efc88f43dde6d6265fb41171))
* update dependency org.easymock:easymock to v4 ([#39](https://www.github.com/googleapis/java-pubsub/issues/39)) ([f803bee](https://www.github.com/googleapis/java-pubsub/commit/f803bee1292fb6e1961dabb25dca17c7c2bd5a04))
* update opencensus.version to v0.25.0 ([#85](https://www.github.com/googleapis/java-pubsub/issues/85)) ([aeca5d4](https://www.github.com/googleapis/java-pubsub/commit/aeca5d413ae46dc9153c4db0135e594a426a7375))


### Documentation

* **regen:** switch to proto annotations ([#90](https://www.github.com/googleapis/java-pubsub/issues/90)) ([63c147a](https://www.github.com/googleapis/java-pubsub/commit/63c147a9250c7b07cb9c8cc7b086a68e0631a37d))

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
