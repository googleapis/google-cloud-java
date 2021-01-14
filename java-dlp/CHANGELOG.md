# Changelog

### [2.2.6](https://www.github.com/googleapis/java-dlp/compare/v2.2.5...v2.2.6) (2021-01-14)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.18.0 ([#399](https://www.github.com/googleapis/java-dlp/issues/399)) ([9761941](https://www.github.com/googleapis/java-dlp/commit/97619410a08a2b3cecc38f2aa650164ef6f4a696))

### [2.2.5](https://www.github.com/googleapis/java-dlp/compare/v2.2.4...v2.2.5) (2021-01-06)


### Dependencies

* update dependency com.google.cloud:google-cloud-pubsub to v1.110.3 ([#390](https://www.github.com/googleapis/java-dlp/issues/390)) ([76b67ec](https://www.github.com/googleapis/java-dlp/commit/76b67ecdb1a95979399a496a536f10f91a1aebc3))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.17.0 ([#381](https://www.github.com/googleapis/java-dlp/issues/381)) ([e064751](https://www.github.com/googleapis/java-dlp/commit/e0647511d3cc143936d5f33df2b254c93d039540))

### [2.2.4](https://www.github.com/googleapis/java-dlp/compare/v2.2.3...v2.2.4) (2020-12-14)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.16.1 ([#376](https://www.github.com/googleapis/java-dlp/issues/376)) ([163bb4e](https://www.github.com/googleapis/java-dlp/commit/163bb4e6447513aa6d3df681fa074b7ac3c05e6f))

### [2.2.3](https://www.github.com/googleapis/java-dlp/compare/v2.2.2...v2.2.3) (2020-12-08)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.16.0 ([#365](https://www.github.com/googleapis/java-dlp/issues/365)) ([1156bc7](https://www.github.com/googleapis/java-dlp/commit/1156bc7d0a203f6110d007727834358b1a48a8ea))

### [2.2.2](https://www.github.com/googleapis/java-dlp/compare/v2.2.1...v2.2.2) (2020-11-17)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.15.0 ([#346](https://www.github.com/googleapis/java-dlp/issues/346)) ([3acd318](https://www.github.com/googleapis/java-dlp/commit/3acd318e84ac13a44a2c53d171e129857c4ea51b))

### [2.2.1](https://www.github.com/googleapis/java-dlp/compare/v2.2.0...v2.2.1) (2020-10-31)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.14.1 ([#332](https://www.github.com/googleapis/java-dlp/issues/332)) ([7dd78c4](https://www.github.com/googleapis/java-dlp/commit/7dd78c4b65b8948a9a9e3158c44c44f3617d5f25))

## [2.2.0](https://www.github.com/googleapis/java-dlp/compare/v2.1.0...v2.2.0) (2020-10-31)


### Features

* retrieve job config for risk analysis jobs. docs: clarify timespan config for BigQuery and Datastore ([#302](https://www.github.com/googleapis/java-dlp/issues/302)) ([58d12e2](https://www.github.com/googleapis/java-dlp/commit/58d12e261665c5beee897b71498b8c2a980e81ba))


### Bug Fixes

* flaky testInspectStringMultipleRulesPatientRule ([#264](https://www.github.com/googleapis/java-dlp/issues/264)) ([f8dda41](https://www.github.com/googleapis/java-dlp/commit/f8dda413972df0e348440ffd76d453536731c2bd))


### Documentation

* correct the links for parent fields ([#274](https://www.github.com/googleapis/java-dlp/issues/274)) ([44e6c76](https://www.github.com/googleapis/java-dlp/commit/44e6c769f536b6333cc1535329c503e4051e0445))
* expand parent field format, and BigQuery sampling options. Also describing which transformations are allowed for ReidentifyContent API calls, and the custom alphabet allowed for format-preserving encryption (FPE). ([#266](https://www.github.com/googleapis/java-dlp/issues/266)) ([9a10739](https://www.github.com/googleapis/java-dlp/commit/9a10739284127974c669bd3580ebe29a8f8316a4))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.10.0 ([#287](https://www.github.com/googleapis/java-dlp/issues/287)) ([680692f](https://www.github.com/googleapis/java-dlp/commit/680692f82f84249467767e75dcfe00457a98351d))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.10.2 ([#298](https://www.github.com/googleapis/java-dlp/issues/298)) ([4bf3dc4](https://www.github.com/googleapis/java-dlp/commit/4bf3dc4b29c1d937eeaf72418e19ce9adbe631d5))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.12.1 ([#315](https://www.github.com/googleapis/java-dlp/issues/315)) ([b00c1a3](https://www.github.com/googleapis/java-dlp/commit/b00c1a312bfef30f831f2b1d3c9b063cb9dba8d5))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.13.0 ([#320](https://www.github.com/googleapis/java-dlp/issues/320)) ([a836cbd](https://www.github.com/googleapis/java-dlp/commit/a836cbd9057f363d9e5129c1be847ad35723209f))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.9.0 ([#263](https://www.github.com/googleapis/java-dlp/issues/263)) ([56feeb2](https://www.github.com/googleapis/java-dlp/commit/56feeb23faf5fafebeadf98a8a75ac4b64630336))

## [2.1.0](https://www.github.com/googleapis/java-dlp/compare/v2.0.0...v2.1.0) (2020-08-10)


### Features

* add CSV and TSV to file types ([#232](https://www.github.com/googleapis/java-dlp/issues/232)) ([2f44354](https://www.github.com/googleapis/java-dlp/commit/2f44354fb6ebc7feaf1723b3fc287703dd6bea89))


### Bug Fixes

* migrate dlp/v2 to grpc_service_config ([#231](https://www.github.com/googleapis/java-dlp/issues/231)) ([e558868](https://www.github.com/googleapis/java-dlp/commit/e558868cd52c1f6f81cec647a46903b9cf562686))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.2 ([#228](https://www.github.com/googleapis/java-dlp/issues/228)) ([e252739](https://www.github.com/googleapis/java-dlp/commit/e25273959b8e6369266d79c3c947697063c22509))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.3 ([#233](https://www.github.com/googleapis/java-dlp/issues/233)) ([96530e4](https://www.github.com/googleapis/java-dlp/commit/96530e4d11bfbc5298559c4790ff55a1730f810a))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.6 ([#240](https://www.github.com/googleapis/java-dlp/issues/240)) ([f96525e](https://www.github.com/googleapis/java-dlp/commit/f96525e2b7fc8b2469f69d8f0049fd3d6393e8a8))

## [2.0.0](https://www.github.com/googleapis/java-dlp/compare/v1.1.4...v2.0.0) (2020-06-22)


### ⚠ BREAKING CHANGES

* Location name helpers have been removed in preparation for regionalization support. Please use a parent string directly instead.

### Features

* add WORD and PDF file type enums and new MetadataLocation proto ([#176](https://www.github.com/googleapis/java-dlp/issues/176)) ([12aeb68](https://www.github.com/googleapis/java-dlp/commit/12aeb68a7626eecccc877bdc993e89150991718c)), closes [#533](https://www.github.com/googleapis/java-dlp/issues/533) [#535](https://www.github.com/googleapis/java-dlp/issues/535)
* **deps:** adopt flatten plugin and google-cloud-shared-dependencies ([#212](https://www.github.com/googleapis/java-dlp/issues/212)) ([8039912](https://www.github.com/googleapis/java-dlp/commit/8039912581d117e07c96f64440b8b4c2263296fc))


### Bug Fixes

* change routing to remove location parameter in preparation for the addition of regional support ([#178](https://www.github.com/googleapis/java-dlp/issues/178)) ([4be3740](https://www.github.com/googleapis/java-dlp/commit/4be3740cf5fc967b7ba84a53c9d568f0d8502308))


### Dependencies

* update dependency com.google.api:api-common to v1.9.1 ([#187](https://www.github.com/googleapis/java-dlp/issues/187)) ([ef3a106](https://www.github.com/googleapis/java-dlp/commit/ef3a106e19a2e3b7fc62fe7e1ad7fac476168d09))
* update dependency com.google.api:api-common to v1.9.2 ([#194](https://www.github.com/googleapis/java-dlp/issues/194)) ([1584607](https://www.github.com/googleapis/java-dlp/commit/1584607c7e36d3a074dea94d3b6ff2a242f8e9c9))
* update dependency com.google.api.grpc:proto-google-common-protos to v1.18.0 ([#173](https://www.github.com/googleapis/java-dlp/issues/173)) ([a1b65d4](https://www.github.com/googleapis/java-dlp/commit/a1b65d4fb390533ba5a92d03bfe482455ef43163))
* update dependency com.google.protobuf:protobuf-java to v3.12.0 ([#180](https://www.github.com/googleapis/java-dlp/issues/180)) ([546af1c](https://www.github.com/googleapis/java-dlp/commit/546af1cd30706075872e9ebe2bdb0dcc1387cb80))
* update dependency com.google.protobuf:protobuf-java to v3.12.2 ([#185](https://www.github.com/googleapis/java-dlp/issues/185)) ([4cf7620](https://www.github.com/googleapis/java-dlp/commit/4cf76208bc70e1ac6e02757fb7c7c41dad4cc381))
* update dependency io.grpc:grpc-bom to v1.30.0 ([#198](https://www.github.com/googleapis/java-dlp/issues/198)) ([0701b8f](https://www.github.com/googleapis/java-dlp/commit/0701b8f3fc11ddd3b159d7584e90736f98d594a4))


### Documentation

* regenerate with fixed URLs and new protoc ([#192](https://www.github.com/googleapis/java-dlp/issues/192)) ([16d6d74](https://www.github.com/googleapis/java-dlp/commit/16d6d7486b36ccbfeca3c026226848fc55b0004a))

### [1.1.4](https://www.github.com/googleapis/java-dlp/compare/v1.1.3...v1.1.4) (2020-05-01)


### Bug Fixes

* replace all retry configs removed during GAPIC config migration ([#165](https://www.github.com/googleapis/java-dlp/issues/165)) ([02da00e](https://www.github.com/googleapis/java-dlp/commit/02da00e9410fb26a00148c5723afa55bffe4e1c3))


### Dependencies

* update dependency io.grpc:grpc-bom to v1.29.0 ([#157](https://www.github.com/googleapis/java-dlp/issues/157)) ([a237797](https://www.github.com/googleapis/java-dlp/commit/a237797960a893fd311f146900d4503ca8074fdc))
* update dependency org.threeten:threetenbp to v1.4.4 ([#159](https://www.github.com/googleapis/java-dlp/issues/159)) ([c42b4e0](https://www.github.com/googleapis/java-dlp/commit/c42b4e07acaeaf4948ae0b8ff434ac9178c951d9))

### [1.1.3](https://www.github.com/googleapis/java-dlp/compare/v1.1.2...v1.1.3) (2020-04-20)


### Dependencies

* update dependency com.google.guava:guava-bom to v29 ([#134](https://www.github.com/googleapis/java-dlp/issues/134)) ([02c8daf](https://www.github.com/googleapis/java-dlp/commit/02c8dafce8ba362db32a2d26a5b8ad3f5c0b272d))

### [1.1.2](https://www.github.com/googleapis/java-dlp/compare/v1.1.1...v1.1.2) (2020-04-10)


### Documentation

* **v2:** regenerate documentation from protos ([#129](https://www.github.com/googleapis/java-dlp/issues/129)) ([69517fc](https://www.github.com/googleapis/java-dlp/commit/69517fc9587b91ba970d49c6afd620aabf6ce2c7)), closes [#123](https://www.github.com/googleapis/java-dlp/issues/123) [#123](https://www.github.com/googleapis/java-dlp/issues/123) [#94](https://www.github.com/googleapis/java-dlp/issues/94) [#105](https://www.github.com/googleapis/java-dlp/issues/105) [#475](https://www.github.com/googleapis/java-dlp/issues/475) [#475](https://www.github.com/googleapis/java-dlp/issues/475) [#465](https://www.github.com/googleapis/java-dlp/issues/465) [#465](https://www.github.com/googleapis/java-dlp/issues/465) [#476](https://www.github.com/googleapis/java-dlp/issues/476) [#476](https://www.github.com/googleapis/java-dlp/issues/476)

### [1.1.1](https://www.github.com/googleapis/java-dlp/compare/v1.1.0...v1.1.1) (2020-04-07)


### Dependencies

* update core dependencies ([#94](https://www.github.com/googleapis/java-dlp/issues/94)) ([88d8307](https://www.github.com/googleapis/java-dlp/commit/88d83071de1ce2251af5c69691221e26c9526618))
* update dependency org.threeten:threetenbp to v1.4.3 ([#105](https://www.github.com/googleapis/java-dlp/issues/105)) ([b636547](https://www.github.com/googleapis/java-dlp/commit/b63654725c1e22a3c1e0ee46b33bfbd71a65c99c))

## [1.1.0](https://www.github.com/googleapis/java-dlp/compare/v1.0.1...v1.1.0) (2020-03-30)


### Features

* **v2:** add HybridInspect RPCs, add missing fields to Finding ([#97](https://www.github.com/googleapis/java-dlp/issues/97)) ([6d511b1](https://www.github.com/googleapis/java-dlp/commit/6d511b1a06834a50d3cbca4d7701ed817425b584))


### Bug Fixes

* undeprecate resource name classes until multi-pattern resources are available ([#92](https://www.github.com/googleapis/java-dlp/issues/92)) ([972b63b](https://www.github.com/googleapis/java-dlp/commit/972b63b755a456087777e5f84da77c6c7995d7fa))


### Dependencies

* update core ([#91](https://www.github.com/googleapis/java-dlp/issues/91)) ([d468c44](https://www.github.com/googleapis/java-dlp/commit/d468c4424c7f5c14cfb3b5bab1959e2930e2cbf0))
* update core dependencies to v1.54.0 ([#89](https://www.github.com/googleapis/java-dlp/issues/89)) ([b25fb80](https://www.github.com/googleapis/java-dlp/commit/b25fb80e5b34ba3a91225d23599324e90e5eaee6))
* update dependency com.google.api:api-common to v1.9.0 ([#113](https://www.github.com/googleapis/java-dlp/issues/113)) ([a360c76](https://www.github.com/googleapis/java-dlp/commit/a360c76e0c171d99510cdb20da083e6ab5dc9def))
* update dependency com.google.protobuf:protobuf-java to v3.11.4 ([4a82db8](https://www.github.com/googleapis/java-dlp/commit/4a82db8acbd2672cb79c3c287a4bb3709602079e))
* update dependency io.grpc:grpc-bom to v1.27.1 ([640ef5f](https://www.github.com/googleapis/java-dlp/commit/640ef5f7869190de4954c3ed6627b3be0df0810b))
* update dependency io.grpc:grpc-bom to v1.27.2 ([772b048](https://www.github.com/googleapis/java-dlp/commit/772b04812d61e534c1c5966e215e086c7744c6e9))


### Documentation

* **regen:** update sample code to set total timeout, add API client header test ([991e966](https://www.github.com/googleapis/java-dlp/commit/991e9660b36014339db0a5d6265b565d1492bc90))

### [1.0.1](https://www.github.com/googleapis/java-dlp/compare/v1.0.0...v1.0.1) (2020-02-04)


### Dependencies

* update core dependencies to v1.53.1 ([4b066eb](https://www.github.com/googleapis/java-dlp/commit/4b066eb6bc9f50ae00334f17d05062bfa2e7269a))
* update dependency com.google.guava:guava-bom to v28.2-android ([#44](https://www.github.com/googleapis/java-dlp/issues/44)) ([afe03d2](https://www.github.com/googleapis/java-dlp/commit/afe03d20eafc4d55c6be4b55f96cab813575a5dd))
* update dependency com.google.protobuf:protobuf-java to v3.11.3 ([#70](https://www.github.com/googleapis/java-dlp/issues/70)) ([687810b](https://www.github.com/googleapis/java-dlp/commit/687810b6eca528e7620f1d130c6511cc58841b2f))
* update dependency io.grpc:grpc-bom to v1.27.0 ([#64](https://www.github.com/googleapis/java-dlp/issues/64)) ([4276306](https://www.github.com/googleapis/java-dlp/commit/4276306319a13804cd4961f5a3671152a3c768c2))

## [1.0.0](https://www.github.com/googleapis/java-dlp/compare/v0.118.1...v1.0.0) (2020-01-24)


### Features

* promote to GA ([#62](https://www.github.com/googleapis/java-dlp/issues/62)) ([b36db26](https://www.github.com/googleapis/java-dlp/commit/b36db2641c56598ed504c03565a52bc4539c16c2))


### Dependencies

* update core dependencies to v1.53.0 ([#53](https://www.github.com/googleapis/java-dlp/issues/53)) ([67089da](https://www.github.com/googleapis/java-dlp/commit/67089da1668f7ad749e5535bec65917f1781661e))
* update dependency org.threeten:threetenbp to v1.4.1 ([#55](https://www.github.com/googleapis/java-dlp/issues/55)) ([2c52f4d](https://www.github.com/googleapis/java-dlp/commit/2c52f4d6f25790b9863433b47e5770a7d8d4ae96))


### Documentation

* **regen:** fix javadoc return annotation ([#60](https://www.github.com/googleapis/java-dlp/issues/60)) ([f557c55](https://www.github.com/googleapis/java-dlp/commit/f557c55ed3d7435d48847c1ff58e6575c0d16435))
* **regen:** regenerate protos with updated docs ([#54](https://www.github.com/googleapis/java-dlp/issues/54)) ([76ee474](https://www.github.com/googleapis/java-dlp/commit/76ee4741d2385b7a65ff70d163989907e318c079))

### [0.118.1](https://www.github.com/googleapis/java-dlp/compare/v0.118.0...v0.118.1) (2020-01-07)


### Dependencies

* update dependency io.grpc:grpc-bom to v1.26.0 ([b5e0cd0](https://www.github.com/googleapis/java-dlp/commit/b5e0cd051e8280efe81fd44ad304e9e73c73035d))
* update gax.version to v1.52.0 ([#37](https://www.github.com/googleapis/java-dlp/issues/37)) ([466bd34](https://www.github.com/googleapis/java-dlp/commit/466bd3437e636774ad2ddc445a0e48067475f55c))


### Documentation

* **regen:** updated javadocs from protoc update ([#36](https://www.github.com/googleapis/java-dlp/issues/36)) ([e07135c](https://www.github.com/googleapis/java-dlp/commit/e07135c7aa9750a1c8e5d66d89094232a9c6c0a9))

## [0.118.0](https://www.github.com/googleapis/java-dlp/compare/v0.117.0...v0.118.0) (2019-12-09)


### Features

* add location_id in preparation for regionalization ([#30](https://www.github.com/googleapis/java-dlp/issues/30)) ([2fdfe30](https://www.github.com/googleapis/java-dlp/commit/2fdfe30a2b6b60e61fa380a5a14d2c4618c9546b))


### Dependencies

* update dependency com.google.protobuf:protobuf-java to v3.11.0 ([#29](https://www.github.com/googleapis/java-dlp/issues/29)) ([b7d2322](https://www.github.com/googleapis/java-dlp/commit/b7d2322d57f8e77fcda109b2cdcf4234f88b2906))
* update dependency com.google.protobuf:protobuf-java to v3.11.1 ([#32](https://www.github.com/googleapis/java-dlp/issues/32)) ([796e0c7](https://www.github.com/googleapis/java-dlp/commit/796e0c74188e9c158dfd3dc192b890c0280d3ea3))
* update gax.version to v1.51.0 ([#33](https://www.github.com/googleapis/java-dlp/issues/33)) ([2ff3c3e](https://www.github.com/googleapis/java-dlp/commit/2ff3c3e5e4b46863be9e27b83cf06013796481e8))

## [0.117.0](https://www.github.com/googleapis/java-dlp/compare/v0.116.0...v0.117.0) (2019-11-12)


### Features

* add PublishToStackdriver option to Action ([#20](https://www.github.com/googleapis/java-dlp/issues/20)) ([b3b3a1c](https://www.github.com/googleapis/java-dlp/commit/b3b3a1c5df1395808fb3373a616b67f74168f07f))

## [0.116.0](https://www.github.com/googleapis/java-dlp/compare/0.115.0...v0.116.0) (2019-10-25)


### Features

* make repo releasable, add parent/bom ([#1](https://www.github.com/googleapis/java-dlp/issues/1)) ([808b8af](https://www.github.com/googleapis/java-dlp/commit/808b8aff07d7abc23953ddf358c9fc60a845ac8f))


### Dependencies

* update dependency com.google.api.grpc:proto-google-common-protos to v1.17.0 ([#2](https://www.github.com/googleapis/java-dlp/issues/2)) ([d2d5002](https://www.github.com/googleapis/java-dlp/commit/d2d500221762b29b87e55177a7a2fa01a13d91c7))
* update dependency io.grpc:grpc-bom to v1.24.1 ([19dd8c6](https://www.github.com/googleapis/java-dlp/commit/19dd8c69170c3bbfa24f80e71761d318af25ff4a))
* update gax.version to v1.49.0 ([#5](https://www.github.com/googleapis/java-dlp/issues/5)) ([558446b](https://www.github.com/googleapis/java-dlp/commit/558446ba6bd6fe655c687db83ea557e8d1e0a8e9))
* update gax.version to v1.49.1 ([a355765](https://www.github.com/googleapis/java-dlp/commit/a355765ca2396685b7a29077bdf8486988e1155d))
