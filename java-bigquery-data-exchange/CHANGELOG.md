# Changelog

## [0.4.0](https://github.com/googleapis/java-bigquery-data-exchange/compare/v0.3.2...v0.4.0) (2022-10-03)


### ⚠ BREAKING CHANGES

* refactor references to Category message
* refresh current dataexchange/v1beta1/* directory to include recent change in protos. Removed common directory and use local enum Category

### Features

* Update BigQuery Analytics Hub API v1beta1 client ([#51](https://github.com/googleapis/java-bigquery-data-exchange/issues/51)) ([cfb8e38](https://github.com/googleapis/java-bigquery-data-exchange/commit/cfb8e383205fea659ef358bc6665aa54324a2904))


### Bug Fixes

* refactor references to Category message ([cfb8e38](https://github.com/googleapis/java-bigquery-data-exchange/commit/cfb8e383205fea659ef358bc6665aa54324a2904))


### Documentation

* improve proto documentation. ([cfb8e38](https://github.com/googleapis/java-bigquery-data-exchange/commit/cfb8e383205fea659ef358bc6665aa54324a2904))


### Dependencies

* Update dependency cachetools to v5 ([#79](https://github.com/googleapis/java-bigquery-data-exchange/issues/79)) ([fd60b52](https://github.com/googleapis/java-bigquery-data-exchange/commit/fd60b5209de9273708c4f5e710ba696ba4df6b76))
* Update dependency certifi to v2022.9.24 ([#59](https://github.com/googleapis/java-bigquery-data-exchange/issues/59)) ([9564874](https://github.com/googleapis/java-bigquery-data-exchange/commit/9564874e9991003d13e8029e678e4c61336d40af))
* Update dependency charset-normalizer to v2.1.1 ([#63](https://github.com/googleapis/java-bigquery-data-exchange/issues/63)) ([6fb196b](https://github.com/googleapis/java-bigquery-data-exchange/commit/6fb196bab017b88acdb48c636b6ce4c19395ed2a))
* Update dependency click to v8.1.3 ([#64](https://github.com/googleapis/java-bigquery-data-exchange/issues/64)) ([56f9ab3](https://github.com/googleapis/java-bigquery-data-exchange/commit/56f9ab3c2746c7792153f21d3b505969656aa80c))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.2 ([#54](https://github.com/googleapis/java-bigquery-data-exchange/issues/54)) ([8b9e87e](https://github.com/googleapis/java-bigquery-data-exchange/commit/8b9e87eec9fa9d652bd7227c22ab1405cbae271a))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.3 ([#56](https://github.com/googleapis/java-bigquery-data-exchange/issues/56)) ([b4f07f8](https://github.com/googleapis/java-bigquery-data-exchange/commit/b4f07f8dc7a620661c377180f4a1cdc6a11e191e))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.4 ([#83](https://github.com/googleapis/java-bigquery-data-exchange/issues/83)) ([82ed8ae](https://github.com/googleapis/java-bigquery-data-exchange/commit/82ed8aea9b7e2e3ccbbea433ad17066ba15d7606))
* Update dependency gcp-releasetool to v1.8.8 ([#60](https://github.com/googleapis/java-bigquery-data-exchange/issues/60)) ([aaa8d8b](https://github.com/googleapis/java-bigquery-data-exchange/commit/aaa8d8baaba76199fe86b79fb081401006b37344))
* Update dependency google-api-core to v2.10.1 ([#65](https://github.com/googleapis/java-bigquery-data-exchange/issues/65)) ([05088de](https://github.com/googleapis/java-bigquery-data-exchange/commit/05088decf4803dd430b0901a897df10e9e7bfb4a))
* Update dependency google-auth to v2.12.0 ([#66](https://github.com/googleapis/java-bigquery-data-exchange/issues/66)) ([dfd2f18](https://github.com/googleapis/java-bigquery-data-exchange/commit/dfd2f18607195a6313666d0b5aa230bff0463c4f))
* Update dependency google-cloud-core to v2.3.2 ([#61](https://github.com/googleapis/java-bigquery-data-exchange/issues/61)) ([a4d5dea](https://github.com/googleapis/java-bigquery-data-exchange/commit/a4d5dea35a2c5f5877bb1d95d99f3fe755a99175))
* Update dependency google-cloud-storage to v2.5.0 ([#67](https://github.com/googleapis/java-bigquery-data-exchange/issues/67)) ([4a3f1f9](https://github.com/googleapis/java-bigquery-data-exchange/commit/4a3f1f91a2c13e6a1e7988666a4db7ecbe8b56c0))
* Update dependency google-crc32c to v1.5.0 ([#68](https://github.com/googleapis/java-bigquery-data-exchange/issues/68)) ([4122c26](https://github.com/googleapis/java-bigquery-data-exchange/commit/4122c268ff3b61cf93b2f0291cd499510623aa4d))
* Update dependency googleapis-common-protos to v1.56.4 ([#62](https://github.com/googleapis/java-bigquery-data-exchange/issues/62)) ([ad2cb71](https://github.com/googleapis/java-bigquery-data-exchange/commit/ad2cb7107c99ed511f0d79808b5e988dd0eccf9a))
* Update dependency importlib-metadata to v4.12.0 ([#69](https://github.com/googleapis/java-bigquery-data-exchange/issues/69)) ([820d3cb](https://github.com/googleapis/java-bigquery-data-exchange/commit/820d3cb1c7420872c4a1838be6f51079ad24af13))
* Update dependency jeepney to v0.8.0 ([#74](https://github.com/googleapis/java-bigquery-data-exchange/issues/74)) ([1f36787](https://github.com/googleapis/java-bigquery-data-exchange/commit/1f367874d06b58aadfe495d73ad8d29bdbd19d68))
* Update dependency jinja2 to v3.1.2 ([#75](https://github.com/googleapis/java-bigquery-data-exchange/issues/75)) ([b627e95](https://github.com/googleapis/java-bigquery-data-exchange/commit/b627e95ce83aca08d9cdd53a73251670e2cff69f))
* Update dependency keyring to v23.9.3 ([#76](https://github.com/googleapis/java-bigquery-data-exchange/issues/76)) ([ee37d61](https://github.com/googleapis/java-bigquery-data-exchange/commit/ee37d613fc80fe13bcbf3a7694543b62e37f3027))
* Update dependency markupsafe to v2.1.1 ([#70](https://github.com/googleapis/java-bigquery-data-exchange/issues/70)) ([c45c8dd](https://github.com/googleapis/java-bigquery-data-exchange/commit/c45c8dd82d166d1ec3e525e187f4deca52b94e92))
* Update dependency protobuf to v3.20.2 ([#71](https://github.com/googleapis/java-bigquery-data-exchange/issues/71)) ([bbc2674](https://github.com/googleapis/java-bigquery-data-exchange/commit/bbc2674ba77949bd6542eaa7a8b5f5f607bffe08))
* Update dependency protobuf to v4 ([#80](https://github.com/googleapis/java-bigquery-data-exchange/issues/80)) ([b195e15](https://github.com/googleapis/java-bigquery-data-exchange/commit/b195e1569d3d31b778db7a21ca068096d98593f1))
* Update dependency pyjwt to v2.5.0 ([#72](https://github.com/googleapis/java-bigquery-data-exchange/issues/72)) ([f31f728](https://github.com/googleapis/java-bigquery-data-exchange/commit/f31f72852374aa9252d11f1d5a59566e8cfed1a6))
* Update dependency requests to v2.28.1 ([#73](https://github.com/googleapis/java-bigquery-data-exchange/issues/73)) ([6d6f91b](https://github.com/googleapis/java-bigquery-data-exchange/commit/6d6f91b7e79aceb581c0097f10a9890ad4da0759))
* Update dependency typing-extensions to v4.3.0 ([#77](https://github.com/googleapis/java-bigquery-data-exchange/issues/77)) ([05d3130](https://github.com/googleapis/java-bigquery-data-exchange/commit/05d3130cfa624a50cac0077bde04bf7bb9af8b29))
* Update dependency zipp to v3.8.1 ([#78](https://github.com/googleapis/java-bigquery-data-exchange/issues/78)) ([3f47711](https://github.com/googleapis/java-bigquery-data-exchange/commit/3f4771166af12303946eab478c2ad70b07f94666))

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
