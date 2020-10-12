# Changelog

### [1.108.4](https://www.github.com/googleapis/java-pubsub/compare/v1.108.3...v1.108.4) (2020-10-12)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.10.2 ([#377](https://www.github.com/googleapis/java-pubsub/issues/377)) ([5e76466](https://www.github.com/googleapis/java-pubsub/commit/5e7646640c28b019dbfbd4073420f9358993ef85))

### [1.108.3](https://www.github.com/googleapis/java-pubsub/compare/v1.108.2...v1.108.3) (2020-10-02)


### Bug Fixes

* ensure proper cleanup of publisher in tests ([#310](https://www.github.com/googleapis/java-pubsub/issues/310)) ([b2b2f86](https://www.github.com/googleapis/java-pubsub/commit/b2b2f8694b925aad95e891cbd0d89426989fec59))
* Ensure that messages that are in pending batches for an ordering key are canceled when a previous publish for the ordering keys fails ([#366](https://www.github.com/googleapis/java-pubsub/issues/366)) ([7cdf8bc](https://www.github.com/googleapis/java-pubsub/commit/7cdf8bcf71a6c141f8b751b41fb2e055a75a4022))
* make subscriberIT test less flaky ([#340](https://www.github.com/googleapis/java-pubsub/issues/340)) ([5d4f534](https://www.github.com/googleapis/java-pubsub/commit/5d4f5345b13171a47f022d34d39609c2f4329069))
* Only check keyHasError if ordering key is non-empty ([#367](https://www.github.com/googleapis/java-pubsub/issues/367)) ([8b2d0b7](https://www.github.com/googleapis/java-pubsub/commit/8b2d0b73a46e6b91795ad05a8dd0f626249c4f30))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.10.0 ([#357](https://www.github.com/googleapis/java-pubsub/issues/357)) ([3b3616c](https://www.github.com/googleapis/java-pubsub/commit/3b3616c524059fb8a87bf30a66c481000046132a))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.9.0 ([#337](https://www.github.com/googleapis/java-pubsub/issues/337)) ([8cf77ee](https://www.github.com/googleapis/java-pubsub/commit/8cf77ee3b31356f342942a9ffaa61db2d0686769))

### [1.108.2](https://www.github.com/googleapis/java-pubsub/compare/v1.108.1...v1.108.2) (2020-08-21)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.5 ([#303](https://www.github.com/googleapis/java-pubsub/issues/303)) ([28ef9ea](https://www.github.com/googleapis/java-pubsub/commit/28ef9ea8cd78391a37023df6a0dcdbd1ba8432f1))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.6 ([#313](https://www.github.com/googleapis/java-pubsub/issues/313)) ([6fc0a4f](https://www.github.com/googleapis/java-pubsub/commit/6fc0a4fceddd420ac8539e0aa98975a01546250d))

### [1.108.1](https://www.github.com/googleapis/java-pubsub/compare/v1.108.0...v1.108.1) (2020-08-04)


### Bug Fixes

* add header providers to PublisherStubSettings ([#294](https://www.github.com/googleapis/java-pubsub/issues/294)) ([6bd5016](https://www.github.com/googleapis/java-pubsub/commit/6bd5016dafe85c7af92a44a8e9a34b2fcb95e64d))
* if a flow control setting is not provided use zero ([#292](https://www.github.com/googleapis/java-pubsub/issues/292)) ([d56155b](https://www.github.com/googleapis/java-pubsub/commit/d56155b640d13fa78d28031862aabe4814ce201d))
* Make error message more clear about where ordering must be enabled when publishing ([#293](https://www.github.com/googleapis/java-pubsub/issues/293)) ([f54ed02](https://www.github.com/googleapis/java-pubsub/commit/f54ed0284a9c7e1a337481e13388397adfa33abf))


### Documentation

* remove experimental warning for ordering keys properties. ([#297](https://www.github.com/googleapis/java-pubsub/issues/297)) ([3fa5164](https://www.github.com/googleapis/java-pubsub/commit/3fa516496315b882da7ffbbc230a3e69acf08a48))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.3 ([#282](https://www.github.com/googleapis/java-pubsub/issues/282)) ([744c268](https://www.github.com/googleapis/java-pubsub/commit/744c2687d50c79ff8556d455aab60928ab2f790c))

## [1.108.0](https://www.github.com/googleapis/java-pubsub/compare/v1.107.0...v1.108.0) (2020-07-09)


### Features

* **deps:** adopt flatten plugin and google-cloud-shared-dependencies ([#259](https://www.github.com/googleapis/java-pubsub/issues/259)) ([6b0947b](https://www.github.com/googleapis/java-pubsub/commit/6b0947b0c142691a16190b7d15da136936517e5a))
* implement max duration per ack extension ([#211](https://www.github.com/googleapis/java-pubsub/issues/211)) ([1427b8c](https://www.github.com/googleapis/java-pubsub/commit/1427b8ced4d7f75e4cb1b57dd898b18f0d232d19))
* regenerated to pick up doc changes ([#246](https://www.github.com/googleapis/java-pubsub/issues/246)) ([a5f45ac](https://www.github.com/googleapis/java-pubsub/commit/a5f45ac0ad493856cd5e1743b8df4fc6d70c5ca9))
* Send streaming pull flow control settings to server ([#267](https://www.github.com/googleapis/java-pubsub/issues/267)) ([9c750c8](https://www.github.com/googleapis/java-pubsub/commit/9c750c8e4899ae994a788c5323fc456ac5d7aa38))


### Dependencies

* update autovalue.version to v1.7.3 ([#244](https://www.github.com/googleapis/java-pubsub/issues/244)) ([6af6682](https://www.github.com/googleapis/java-pubsub/commit/6af6682a5c52af1b929634fe210ef342c5625fda))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.1 ([#247](https://www.github.com/googleapis/java-pubsub/issues/247)) ([fbceaed](https://www.github.com/googleapis/java-pubsub/commit/fbceaed9701811e3c818fe5696f04936ec447b96))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.2 ([#274](https://www.github.com/googleapis/java-pubsub/issues/274)) ([b101905](https://www.github.com/googleapis/java-pubsub/commit/b101905dedcaff4a50c7d3c6097fcb5c0e48310c))

## [1.107.0](https://www.github.com/googleapis/java-pubsub/compare/v1.106.0...v1.107.0) (2020-06-09)


### Features

* add detach subscription rpc ([#216](https://www.github.com/googleapis/java-pubsub/issues/216)) ([09866b0](https://www.github.com/googleapis/java-pubsub/commit/09866b0d36e2dd1c994b4c91807d71552b65c8e1))
* regenerated to pick up changes in the API or client library generator ([#185](https://www.github.com/googleapis/java-pubsub/issues/185)) ([16624f8](https://www.github.com/googleapis/java-pubsub/commit/16624f88ad19ccaf2ea074a62242496be103659f)), closes [#533](https://www.github.com/googleapis/java-pubsub/issues/533) [#535](https://www.github.com/googleapis/java-pubsub/issues/535) [#534](https://www.github.com/googleapis/java-pubsub/issues/534)


### Bug Fixes

* update ignored diffs ([#206](https://www.github.com/googleapis/java-pubsub/issues/206)) ([240e141](https://www.github.com/googleapis/java-pubsub/commit/240e141a8b4f8e4d4e252672bb4ae4d091dde453)), closes [#6784](https://www.github.com/googleapis/java-pubsub/issues/6784) [#11](https://www.github.com/googleapis/java-pubsub/issues/11)


### Dependencies

* bump shared-deps version and add back certain test deps ([#218](https://www.github.com/googleapis/java-pubsub/issues/218)) ([49ecc69](https://www.github.com/googleapis/java-pubsub/commit/49ecc69fb6a63abf6a83f82f2820ff386cdaf5fb))
* remove grpc test dep since it's now in shared-deps ([#220](https://www.github.com/googleapis/java-pubsub/issues/220)) ([28ab521](https://www.github.com/googleapis/java-pubsub/commit/28ab5211c344d60743c3cb11f568c8f2a4e2c040))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.6.0 ([#219](https://www.github.com/googleapis/java-pubsub/issues/219)) ([c6fc69d](https://www.github.com/googleapis/java-pubsub/commit/c6fc69d47dea6f3833a9a2945d27ed3f9e310c52))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.7.0 ([#221](https://www.github.com/googleapis/java-pubsub/issues/221)) ([89eae9a](https://www.github.com/googleapis/java-pubsub/commit/89eae9a6c3dc585926f85fc0de2b80f7dbfedb42))
* update dependency com.google.errorprone:error_prone_annotations to v2.4.0 ([#225](https://www.github.com/googleapis/java-pubsub/issues/225)) ([f375ecb](https://www.github.com/googleapis/java-pubsub/commit/f375ecbbd66e518a25c1d0459ba0634121ddced1))

## [1.106.0](https://www.github.com/googleapis/java-pubsub/compare/v1.105.1...v1.106.0) (2020-05-20)


### Features

* implement google-cloud-shared-dependencies BOM ([#198](https://www.github.com/googleapis/java-pubsub/issues/198)) ([55bdc26](https://www.github.com/googleapis/java-pubsub/commit/55bdc2647f4f9949d015497ed4a35c24a3ecdfab))
* set up repo for samples ([#196](https://www.github.com/googleapis/java-pubsub/issues/196)) ([3e1b136](https://www.github.com/googleapis/java-pubsub/commit/3e1b1360250ed8fa91b9fa6f36bc1d051aa38e2c))


### Documentation

* **fix:** update client documentation link ([#192](https://www.github.com/googleapis/java-pubsub/issues/192)) ([e6f0533](https://www.github.com/googleapis/java-pubsub/commit/e6f053399c45d02c7d641c4b2a84bff96b634e34))


### Dependencies

* update autovalue.version to v1.7.2 ([#184](https://www.github.com/googleapis/java-pubsub/issues/184)) ([040ff0b](https://www.github.com/googleapis/java-pubsub/commit/040ff0b7ce0a323a0e1ee575eb1c021dd644608b))
* update dependency com.google.protobuf:protobuf-java to v3.12.0 ([#188](https://www.github.com/googleapis/java-pubsub/issues/188)) ([87e036e](https://www.github.com/googleapis/java-pubsub/commit/87e036ed6929dfa8f6d8e2eb099833276aa17a91))

### [1.105.1](https://www.github.com/googleapis/java-pubsub/compare/v1.105.0...v1.105.1) (2020-05-07)


### Bug Fixes

* changing integration test push endpoint to be valid https ([#170](https://www.github.com/googleapis/java-pubsub/issues/170)) ([71f15a4](https://www.github.com/googleapis/java-pubsub/commit/71f15a4a90475c8e82c6cc6393d4232228273656)), closes [#6784](https://www.github.com/googleapis/java-pubsub/issues/6784) [#11](https://www.github.com/googleapis/java-pubsub/issues/11)


### Dependencies

* update autovalue.version to v1.7.1 ([#173](https://www.github.com/googleapis/java-pubsub/issues/173)) ([77884f8](https://www.github.com/googleapis/java-pubsub/commit/77884f8c816bb189a1d5ecad3ab860b19df2804d))
* update dependency com.google.api.grpc:proto-google-common-protos to v1.18.0 ([#176](https://www.github.com/googleapis/java-pubsub/issues/176)) ([486ed41](https://www.github.com/googleapis/java-pubsub/commit/486ed4130a17a0fa411a30e7c48bd04082e68458))
* update dependency com.google.guava:guava-bom to v29 ([#146](https://www.github.com/googleapis/java-pubsub/issues/146)) ([16f1dbb](https://www.github.com/googleapis/java-pubsub/commit/16f1dbb3226af119cdbc234e8672608244d0a7fd))
* update dependency com.google.http-client:google-http-client-bom to v1.35.0 ([#169](https://www.github.com/googleapis/java-pubsub/issues/169)) ([6346042](https://www.github.com/googleapis/java-pubsub/commit/6346042b09c5f7e302f75ad8e48cc2d08b6f8e64))
* update dependency io.grpc:grpc-bom to v1.29.0 ([#162](https://www.github.com/googleapis/java-pubsub/issues/162)) ([b883b45](https://www.github.com/googleapis/java-pubsub/commit/b883b452676eeb7bd5a178cd1bb357e965a26ee8))
* update dependency org.threeten:threetenbp to v1.4.4 ([#167](https://www.github.com/googleapis/java-pubsub/issues/167)) ([78ead3a](https://www.github.com/googleapis/java-pubsub/commit/78ead3a69ce493fdf57a372c1e135e71b8b5cb7c))

## [1.105.0](https://www.github.com/googleapis/java-pubsub/compare/v1.104.1...v1.105.0) (2020-04-13)


### Features

* add interfaces for cloud pubsub publishers and subscribers ([#134](https://www.github.com/googleapis/java-pubsub/issues/134)) ([89fcc88](https://www.github.com/googleapis/java-pubsub/commit/89fcc8848cc7d421e8dde9b7dca28a6940d8386f))


### Documentation

* update libraries-bom ([#140](https://www.github.com/googleapis/java-pubsub/issues/140)) ([d8239bd](https://www.github.com/googleapis/java-pubsub/commit/d8239bdc080d0ef595bac90451485b1d3d50f266))

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
