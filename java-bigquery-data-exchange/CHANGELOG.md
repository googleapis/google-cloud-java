# Changelog

## [1.0.0](https://github.com/googleapis/google-cloud-java/compare/google-cloud-bigquery-data-exchange-v0.3.2...google-cloud-bigquery-data-exchange-v1.0.0) (2022-10-12)


### ⚠ BREAKING CHANGES

* refactor references to Category message
* refresh current dataexchange/v1beta1/* directory to include recent change in protos. Removed common directory and use local enum Category

### Features

* [analyticsdata] add `subject_to_thresholding` field to `ResponseMetadata` type ([#8545](https://github.com/googleapis/google-cloud-java/issues/8545)) ([8fdc6c1](https://github.com/googleapis/google-cloud-java/commit/8fdc6c1f10f88f30f4d1407579d645f75366b4cf))
* [analyticshub] update BigQuery Analytics Hub API v1beta1 client ([#8263](https://github.com/googleapis/google-cloud-java/issues/8263)) ([3301e6d](https://github.com/googleapis/google-cloud-java/commit/3301e6d0580d281242123225b798e3533c1a0e9e))
* add `tokens_per_project_per_hour` field to `PropertyQuota` type ([8fdc6c1](https://github.com/googleapis/google-cloud-java/commit/8fdc6c1f10f88f30f4d1407579d645f75366b4cf))


### Bug Fixes

* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.2 ([#8325](https://github.com/googleapis/google-cloud-java/issues/8325)) ([01f492b](https://github.com/googleapis/google-cloud-java/commit/01f492be424acdb90edb23ba66656aeff7cf39eb))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.4 ([#8528](https://github.com/googleapis/google-cloud-java/issues/8528)) ([bd36199](https://github.com/googleapis/google-cloud-java/commit/bd361998ac4eb7c78eef3b3eac39aef31a0cf44e))
* owl-bot-staging should not be commited ([#8337](https://github.com/googleapis/google-cloud-java/issues/8337)) ([c9bb4a9](https://github.com/googleapis/google-cloud-java/commit/c9bb4a97aa19032b78c86c951fe9920f24ac4eec))
* refactor references to Category message ([3301e6d](https://github.com/googleapis/google-cloud-java/commit/3301e6d0580d281242123225b798e3533c1a0e9e))
* revert reverting [Many APIs] Update WORKSPACE files for rules_gapic, gax_java, generator_java versions ([#8340](https://github.com/googleapis/google-cloud-java/issues/8340)) ([dedef71](https://github.com/googleapis/google-cloud-java/commit/dedef71f600e85b1c38e7110f5ffd44bf2ba32b4))


### Documentation

* improve proto documentation. ([3301e6d](https://github.com/googleapis/google-cloud-java/commit/3301e6d0580d281242123225b798e3533c1a0e9e))


### Dependencies

* reverting renovate bot pull requests ([#8417](https://github.com/googleapis/google-cloud-java/issues/8417)) ([8f0c60b](https://github.com/googleapis/google-cloud-java/commit/8f0c60bde446acccc665eb7894723632eefc3503))

## [0.3.2](https://github.com/googleapis/java-bigquery-data-exchange/compare/v0.3.1...v0.3.2) (2022-08-09)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v3 ([#43](https://github.com/googleapis/java-bigquery-data-exchange/issues/43)) ([94c6e1b](https://github.com/googleapis/java-bigquery-data-exchange/commit/94c6e1bdbce3b6995eab60d06e4e5bf95451f858))

## [0.3.1](https://github.com/googleapis/java-bigquery-data-exchange/compare/v0.3.0...v0.3.1) (2022-07-13)


### Bug Fixes

* enable longpaths support for windows test ([#1485](https://github.com/googleapis/java-bigquery-data-exchange/issues/1485)) ([#36](https://github.com/googleapis/java-bigquery-data-exchange/issues/36)) ([f6f08ad](https://github.com/googleapis/java-bigquery-data-exchange/commit/f6f08ad559a90634fa006984f0546fefdf0afde3))

## [0.3.0](https://github.com/googleapis/java-bigquery-data-exchange/compare/v0.2.1...v0.3.0) (2022-07-01)


### Features

* Enable REST transport for most of Java and Go clients ([#25](https://github.com/googleapis/java-bigquery-data-exchange/issues/25)) ([96e8975](https://github.com/googleapis/java-bigquery-data-exchange/commit/96e89758fe9995bc39700d8a8e9668edc018f63b))

## [0.2.1](https://github.com/googleapis/java-bigquery-data-exchange/compare/v0.2.0...v0.2.1) (2022-06-23)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.13.0 ([#24](https://github.com/googleapis/java-bigquery-data-exchange/issues/24)) ([0cd9c18](https://github.com/googleapis/java-bigquery-data-exchange/commit/0cd9c18b557b8b02a909a3ee356f93149b9cd6a2))

## [0.2.0](https://github.com/googleapis/java-bigquery-data-exchange/compare/v0.1.0...v0.2.0) (2022-05-19)


### Features

* add build scripts for native image testing in Java 17 ([#1440](https://github.com/googleapis/java-bigquery-data-exchange/issues/1440)) ([#16](https://github.com/googleapis/java-bigquery-data-exchange/issues/16)) ([94ad977](https://github.com/googleapis/java-bigquery-data-exchange/commit/94ad9773b3f9e84c24506bfa8cdb867e935c3bc4))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.11.0 ([#15](https://github.com/googleapis/java-bigquery-data-exchange/issues/15)) ([fa9386d](https://github.com/googleapis/java-bigquery-data-exchange/commit/fa9386dd9117cf2817d8c8e2931267518189e8cd))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.12.0 ([#18](https://github.com/googleapis/java-bigquery-data-exchange/issues/18)) ([d35e054](https://github.com/googleapis/java-bigquery-data-exchange/commit/d35e054e376f1981ed526cfc13390d442504397d))

## 0.1.0 (2022-05-03)


### Features

* initial generation ([7a1b115](https://github.com/googleapis/java-bigquery-data-exchange/commit/7a1b11580c4f448dcc25d2fc44c980776891bc16))
* initial generation ([0c51c95](https://github.com/googleapis/java-bigquery-data-exchange/commit/0c51c95d55e289971e94f1e375247c556938d09e))
