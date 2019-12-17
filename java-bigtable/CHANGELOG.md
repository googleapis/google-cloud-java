# Changelog

## [1.8.0](https://www.github.com/googleapis/java-bigtable/compare/v1.7.1...v1.8.0) (2019-12-17)


### Features

* add implementation of ChannelPrimer to establish connection to GFE and integrate into bigtable client ([#115](https://www.github.com/googleapis/java-bigtable/issues/115)) ([276f942](https://www.github.com/googleapis/java-bigtable/commit/276f942dd2e668600347a59496525a589d7560da))
* update filter to accept an exact timestamp for better accessibility ([#92](https://www.github.com/googleapis/java-bigtable/issues/92)) ([e25758b](https://www.github.com/googleapis/java-bigtable/commit/e25758b3164618ac16d57fffe6ba0e4175229960))


### Dependencies

* update gax.version to v1.51.0 ([#105](https://www.github.com/googleapis/java-bigtable/issues/105)) ([dcdd0c3](https://www.github.com/googleapis/java-bigtable/commit/dcdd0c347f10802be57c4f7267c2b82c59ea2278))
* upgrade gax to 1.52.0, google-cloud-core to 1.92.0 ([#118](https://www.github.com/googleapis/java-bigtable/issues/118)) ([c106497](https://www.github.com/googleapis/java-bigtable/commit/c1064977eff3889e4f8b6ba8ab44a08f6f96ae1f))

### [1.7.1](https://www.github.com/googleapis/java-bigtable/compare/v1.7.0...v1.7.1) (2019-11-13)


### Dependencies

* update gax.version to v1.50.1 ([#72](https://www.github.com/googleapis/java-bigtable/issues/72)) ([eb44a19](https://www.github.com/googleapis/java-bigtable/commit/eb44a19ccaed342b84dec80048802641dfd6609e))

## [1.7.0](https://www.github.com/googleapis/java-bigtable/compare/v1.6.0...v1.7.0) (2019-11-07)


### Features

* add bom ([#50](https://www.github.com/googleapis/java-bigtable/issues/50)) ([f4dd552](https://www.github.com/googleapis/java-bigtable/commit/f4dd552ea00044babe1273e322b8a330f093b2b0))


### Bug Fixes

* align version numbers for proto and grpc versions ([#52](https://www.github.com/googleapis/java-bigtable/issues/52)) ([dbfa73a](https://www.github.com/googleapis/java-bigtable/commit/dbfa73a1a336d0afb03e7755d17786216199a851))
* fix maven test configs to make sure admin tests don't clobber data tests ([#47](https://www.github.com/googleapis/java-bigtable/issues/47)) ([18576f5](https://www.github.com/googleapis/java-bigtable/commit/18576f55c34dbdc4c0ac79639dbc1dbf1ce7affe))
* fix regression in batch#close silently ignoring entry failures by upgrading to gax to 1.50.0 ([#67](https://www.github.com/googleapis/java-bigtable/issues/67)) ([5aa8769](https://www.github.com/googleapis/java-bigtable/commit/5aa87697a5e8860993a14f4ac42d675c66b3d0ff))
* handle recovery failures during stream reframing failure ([#46](https://www.github.com/googleapis/java-bigtable/issues/46)) ([a16cb88](https://www.github.com/googleapis/java-bigtable/commit/a16cb8864c0c8be26d34e71dbf261dbfc5e09bac))
* Prevent integration tests from different profiles from trampling each other ([#69](https://www.github.com/googleapis/java-bigtable/issues/69)) ([638615a](https://www.github.com/googleapis/java-bigtable/commit/638615ae09ec2d311e82d89ea7a78137911f4eb4))
* use proper scope for DirectPath transitive dependencies ([#59](https://www.github.com/googleapis/java-bigtable/issues/59)) ([1d1c4de](https://www.github.com/googleapis/java-bigtable/commit/1d1c4deb34a85836da2aed7b07359ff923b09835))


### Documentation

* cleanup links to java-bigtable and javadoc ([#56](https://www.github.com/googleapis/java-bigtable/issues/56)) ([846a44f](https://www.github.com/googleapis/java-bigtable/commit/846a44fbf9ebd5691a431e79a09a049aea5fd4f0))

## [1.6.0](https://www.github.com/googleapis/java-bigtable/compare/1.5.0...v1.6.0) (2019-10-24)


### Features

* Add Experimental DirectPath support ([#8](https://www.github.com/googleapis/java-bigtable/issues/8)) ([2dd5105](https://www.github.com/googleapis/java-bigtable/commit/2dd5105559f6f61f9780b11e44bccbd2c08d68ae))


### Dependencies

* update gax.version to v1.49.1 ([a138a0f](https://www.github.com/googleapis/java-bigtable/commit/a138a0f8f42ede72d5cd30536cef4e78e5de5843))
* upgrade threeten to 1.4 ([#33](https://www.github.com/googleapis/java-bigtable/issues/33)) ([554170b](https://www.github.com/googleapis/java-bigtable/commit/554170b929ec63155d0e840039e75b323dad1709))
