# Changelog

## [0.7.0](https://github.com/googleapis/google-cloud-java/compare/google-cloud-bigquerymigration-v0.6.2...google-cloud-bigquerymigration-v0.7.0) (2022-10-17)


### Features

* [analyticsdata] add `subject_to_thresholding` field to `ResponseMetadata` type ([#8545](https://github.com/googleapis/google-cloud-java/issues/8545)) ([8fdc6c1](https://github.com/googleapis/google-cloud-java/commit/8fdc6c1f10f88f30f4d1407579d645f75366b4cf))
* add `tokens_per_project_per_hour` field to `PropertyQuota` type ([8fdc6c1](https://github.com/googleapis/google-cloud-java/commit/8fdc6c1f10f88f30f4d1407579d645f75366b4cf))
* create release please configuration ([41b97e6](https://github.com/googleapis/google-cloud-java/commit/41b97e6d0d38a54fbabf51a3069bf1473c48f730))


### Bug Fixes

* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.2 ([#8325](https://github.com/googleapis/google-cloud-java/issues/8325)) ([01f492b](https://github.com/googleapis/google-cloud-java/commit/01f492be424acdb90edb23ba66656aeff7cf39eb))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.4 ([#8528](https://github.com/googleapis/google-cloud-java/issues/8528)) ([bd36199](https://github.com/googleapis/google-cloud-java/commit/bd361998ac4eb7c78eef3b3eac39aef31a0cf44e))
* owl-bot-staging should not be commited ([#8337](https://github.com/googleapis/google-cloud-java/issues/8337)) ([c9bb4a9](https://github.com/googleapis/google-cloud-java/commit/c9bb4a97aa19032b78c86c951fe9920f24ac4eec))
* revert reverting [Many APIs] Update WORKSPACE files for rules_gapic, gax_java, generator_java versions ([#8340](https://github.com/googleapis/google-cloud-java/issues/8340)) ([dedef71](https://github.com/googleapis/google-cloud-java/commit/dedef71f600e85b1c38e7110f5ffd44bf2ba32b4))


### Dependencies

* reverting renovate bot pull requests ([#8417](https://github.com/googleapis/google-cloud-java/issues/8417)) ([8f0c60b](https://github.com/googleapis/google-cloud-java/commit/8f0c60bde446acccc665eb7894723632eefc3503))

## [0.6.2](https://github.com/googleapis/java-bigquerymigration/compare/v0.6.1...v0.6.2) (2022-10-04)


### Bug Fixes

* update protobuf to v3.21.7 ([556690c](https://github.com/googleapis/java-bigquerymigration/commit/556690c4c18612e2e0b4fcd8e3ed213dc6a674e0))


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.4 ([#172](https://github.com/googleapis/java-bigquerymigration/issues/172)) ([f1d1040](https://github.com/googleapis/java-bigquerymigration/commit/f1d104003fbada0f9e8cc5135d537639d826f6ef))

## [0.6.1](https://github.com/googleapis/java-bigquerymigration/compare/v0.6.0...v0.6.1) (2022-09-27)


### Dependencies

* Update dependency protobuf to v4 ([#167](https://github.com/googleapis/java-bigquerymigration/issues/167)) ([f98be05](https://github.com/googleapis/java-bigquerymigration/commit/f98be05c762ad185dc26c0a411a670e00b206856))

## [0.6.0](https://github.com/googleapis/java-bigquerymigration/compare/v0.5.0...v0.6.0) (2022-09-15)


### Features

* Add MySQL dialect to bigquerymigration v2 client library ([#154](https://github.com/googleapis/java-bigquerymigration/issues/154)) ([e7d9c5f](https://github.com/googleapis/java-bigquerymigration/commit/e7d9c5f1a4ebc3929456349a34a6bf5ecebc39ab))


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.2 ([#160](https://github.com/googleapis/java-bigquerymigration/issues/160)) ([eed9ffb](https://github.com/googleapis/java-bigquerymigration/commit/eed9ffbbf56a982d97bb38a1fec373fffd3b906f))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.3 ([#162](https://github.com/googleapis/java-bigquerymigration/issues/162)) ([9e8c0c6](https://github.com/googleapis/java-bigquerymigration/commit/9e8c0c63282761fd857b85409af798aa39d23981))

## [0.5.0](https://github.com/googleapis/java-bigquerymigration/compare/v0.4.1...v0.5.0) (2022-08-02)


### Features

* Add Presto dialect to bigquerymigration v2 client library ([#143](https://github.com/googleapis/java-bigquerymigration/issues/143)) ([688b685](https://github.com/googleapis/java-bigquerymigration/commit/688b685e9fd3d3d7a15e80d5c11241ffdf473f09))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v3 ([#151](https://github.com/googleapis/java-bigquerymigration/issues/151)) ([0dce6f5](https://github.com/googleapis/java-bigquerymigration/commit/0dce6f58f2e8bddf9569d9578101840d3bee8963))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.1 ([#152](https://github.com/googleapis/java-bigquerymigration/issues/152)) ([8e62b93](https://github.com/googleapis/java-bigquerymigration/commit/8e62b933b42b3087a94e44521830ea0190fc0f15))

## [0.4.1](https://github.com/googleapis/java-bigquerymigration/compare/v0.4.0...v0.4.1) (2022-07-13)


### Bug Fixes

* enable longpaths support for windows test ([#1485](https://github.com/googleapis/java-bigquerymigration/issues/1485)) ([#141](https://github.com/googleapis/java-bigquerymigration/issues/141)) ([f02b160](https://github.com/googleapis/java-bigquerymigration/commit/f02b16058c93f1f89668516c1ef1bfcfc6992bf9))

## [0.4.0](https://github.com/googleapis/java-bigquerymigration/compare/v0.3.0...v0.4.0) (2022-07-01)


### Features

* Add SQL Server dialect to bigquerymigration v2 client library ([8b63a81](https://github.com/googleapis/java-bigquerymigration/commit/8b63a81c45ae9dafd35af5062c6937b26f02eb4d))
* Enable REST transport for most of Java and Go clients ([#131](https://github.com/googleapis/java-bigquerymigration/issues/131)) ([5177118](https://github.com/googleapis/java-bigquerymigration/commit/517711839022f4d82133d049af796db04035b0f2))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.13.0 ([#130](https://github.com/googleapis/java-bigquerymigration/issues/130)) ([be1c61d](https://github.com/googleapis/java-bigquerymigration/commit/be1c61d809b170a6c472bf00c7e126df535fad56))

## [0.3.0](https://github.com/googleapis/java-bigquerymigration/compare/v0.2.4...v0.3.0) (2022-05-19)


### Features

* add build scripts for native image testing in Java 17 ([#1440](https://github.com/googleapis/java-bigquerymigration/issues/1440)) ([#121](https://github.com/googleapis/java-bigquerymigration/issues/121)) ([8f3def9](https://github.com/googleapis/java-bigquerymigration/commit/8f3def9f3f94102ccce665c805b531378238f6b3))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.11.0 ([#120](https://github.com/googleapis/java-bigquerymigration/issues/120)) ([6fb874d](https://github.com/googleapis/java-bigquerymigration/commit/6fb874df8eec83b006f2d85a4759237597241728))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.12.0 ([#123](https://github.com/googleapis/java-bigquerymigration/issues/123)) ([6e4b5ff](https://github.com/googleapis/java-bigquerymigration/commit/6e4b5ffeef235d703cf9b5fa33c20e51955ae69c))

### [0.2.4](https://github.com/googleapis/java-bigquerymigration/compare/v0.2.3...v0.2.4) (2022-04-15)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.10.0 ([#108](https://github.com/googleapis/java-bigquerymigration/issues/108)) ([20cd164](https://github.com/googleapis/java-bigquerymigration/commit/20cd164e2f0046a9b3ee934ed47c9d82a319fcde))

### [0.2.3](https://github.com/googleapis/java-bigquerymigration/compare/v0.2.2...v0.2.3) (2022-03-29)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.9.0 ([#101](https://github.com/googleapis/java-bigquerymigration/issues/101)) ([c4d7c21](https://github.com/googleapis/java-bigquerymigration/commit/c4d7c21e025820adb21a902411bb58a0595d7f3f))

### [0.2.2](https://github.com/googleapis/java-bigquerymigration/compare/v0.2.1...v0.2.2) (2022-03-02)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.8.0 ([#92](https://github.com/googleapis/java-bigquerymigration/issues/92)) ([49487d4](https://github.com/googleapis/java-bigquerymigration/commit/49487d492c4f17a6e8511e805e1a52f577d61a3b))

### [0.2.1](https://github.com/googleapis/java-bigquerymigration/compare/v0.2.0...v0.2.1) (2022-02-11)


### Dependencies

* update actions/github-script action to v6 ([#79](https://github.com/googleapis/java-bigquerymigration/issues/79)) ([ed5438a](https://github.com/googleapis/java-bigquerymigration/commit/ed5438ac9fce82c8646ae1b2d3dcfac6f59287a1))

## [0.2.0](https://github.com/googleapis/java-bigquerymigration/compare/v0.1.4...v0.2.0) (2022-01-31)


### ⚠ BREAKING CHANGES

* Consolidate task details into service API and add orchestration result details BREAKING CHANGE: This change relocates some task proto definitions and updates message fields, necessitating updates to imports. (#64)

### Features

* Consolidate task details into service API and add orchestration result details BREAKING CHANGE: This change relocates some task proto definitions and updates message fields, necessitating updates to imports. ([#64](https://github.com/googleapis/java-bigquerymigration/issues/64)) ([ee2316f](https://github.com/googleapis/java-bigquerymigration/commit/ee2316fc875f8a50290e40145f2523c8f934ae3c))


### Dependencies

* **java:** update actions/github-script action to v5 ([#1339](https://github.com/googleapis/java-bigquerymigration/issues/1339)) ([#69](https://github.com/googleapis/java-bigquerymigration/issues/69)) ([98119cb](https://github.com/googleapis/java-bigquerymigration/commit/98119cb873a681675ba253e9861a7a13b0600d6f))
* update actions/github-script action to v5 ([#67](https://github.com/googleapis/java-bigquerymigration/issues/67)) ([24c16f5](https://github.com/googleapis/java-bigquerymigration/commit/24c16f544b8f0b697486370f1f61ef741bd1632f))
* update actions/setup-java action to v2 ([#68](https://github.com/googleapis/java-bigquerymigration/issues/68)) ([a383904](https://github.com/googleapis/java-bigquerymigration/commit/a383904d1bdb3392f0610d17c785390b33827e7d))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.7.0 ([#70](https://github.com/googleapis/java-bigquerymigration/issues/70)) ([6bddefa](https://github.com/googleapis/java-bigquerymigration/commit/6bddefa4a5012b1022c98647b5eed22ff00ac8a1))

### [0.1.4](https://www.github.com/googleapis/java-bigquerymigration/compare/v0.1.3...v0.1.4) (2022-01-07)


### Bug Fixes

* **java:** add -ntp flag to native image testing command ([#1299](https://www.github.com/googleapis/java-bigquerymigration/issues/1299)) ([#44](https://www.github.com/googleapis/java-bigquerymigration/issues/44)) ([f2b9b81](https://www.github.com/googleapis/java-bigquerymigration/commit/f2b9b8117300dac20480a6f60ceb82c80a73c5b4))
* **java:** Pass missing integration test flags to native image test commands ([#1309](https://www.github.com/googleapis/java-bigquerymigration/issues/1309)) ([#48](https://www.github.com/googleapis/java-bigquerymigration/issues/48)) ([f61d9f2](https://www.github.com/googleapis/java-bigquerymigration/commit/f61d9f2c1e9c2ecfe539c6c0ac2df1885e344176))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.6.0 ([#52](https://www.github.com/googleapis/java-bigquerymigration/issues/52)) ([c7d1e8e](https://www.github.com/googleapis/java-bigquerymigration/commit/c7d1e8e1d901626088b075e6ad19c77162fb9800))

### [0.1.3](https://www.github.com/googleapis/java-bigquerymigration/compare/v0.1.2...v0.1.3) (2021-12-03)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.5.1 ([#40](https://www.github.com/googleapis/java-bigquerymigration/issues/40)) ([99524e6](https://www.github.com/googleapis/java-bigquerymigration/commit/99524e67c07d7ff5b80b181e038524e171655001))

### [0.1.2](https://www.github.com/googleapis/java-bigquerymigration/compare/v0.1.1...v0.1.2) (2021-11-12)


### Bug Fixes

* **java:** java 17 dependency arguments ([#1266](https://www.github.com/googleapis/java-bigquerymigration/issues/1266)) ([#24](https://www.github.com/googleapis/java-bigquerymigration/issues/24)) ([12b2d58](https://www.github.com/googleapis/java-bigquerymigration/commit/12b2d584ef60c8cc211dce144780ecfc3abff73c))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.5.0 ([#33](https://www.github.com/googleapis/java-bigquerymigration/issues/33)) ([822e53b](https://www.github.com/googleapis/java-bigquerymigration/commit/822e53b8fe9484452d8a71c1b392322c59ffced0))

### [0.1.1](https://www.github.com/googleapis/java-bigquerymigration/compare/v0.1.0...v0.1.1) (2021-10-19)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.4.0 ([#19](https://www.github.com/googleapis/java-bigquerymigration/issues/19)) ([b438fcb](https://www.github.com/googleapis/java-bigquerymigration/commit/b438fcbb9aa63791a806f731e7d6fc60ff32cebc))

## 0.1.0 (2021-09-30)


### Features

* generate migration v2alpha ([15032de](https://www.github.com/googleapis/java-bigquerymigration/commit/15032de7799429a4a3324d8ff1bc84891d9ac6ce))
* initial generation ([ff233d8](https://www.github.com/googleapis/java-bigquerymigration/commit/ff233d8e303fb5255d1ac8a515fedb4ea50c939b))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.3.0 ([#7](https://www.github.com/googleapis/java-bigquerymigration/issues/7)) ([9e0ca6b](https://www.github.com/googleapis/java-bigquerymigration/commit/9e0ca6bb7a4f220e0e9b5d7acf3466b85ea98d23))
