# Changelog

## [1.5.0](https://github.com/googleapis/google-cloud-java/compare/google-cloud-network-management-v1.4.2...google-cloud-network-management-v1.5.0) (2022-10-10)


### Features

* [analyticsdata] add `subject_to_thresholding` field to `ResponseMetadata` type ([#8545](https://github.com/googleapis/google-cloud-java/issues/8545)) ([8fdc6c1](https://github.com/googleapis/google-cloud-java/commit/8fdc6c1f10f88f30f4d1407579d645f75366b4cf))
* add `tokens_per_project_per_hour` field to `PropertyQuota` type ([8fdc6c1](https://github.com/googleapis/google-cloud-java/commit/8fdc6c1f10f88f30f4d1407579d645f75366b4cf))
* create release please configuration ([41b97e6](https://github.com/googleapis/google-cloud-java/commit/41b97e6d0d38a54fbabf51a3069bf1473c48f730))


### Bug Fixes

* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.2 ([#8325](https://github.com/googleapis/google-cloud-java/issues/8325)) ([01f492b](https://github.com/googleapis/google-cloud-java/commit/01f492be424acdb90edb23ba66656aeff7cf39eb))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.4 ([#8528](https://github.com/googleapis/google-cloud-java/issues/8528)) ([bd36199](https://github.com/googleapis/google-cloud-java/commit/bd361998ac4eb7c78eef3b3eac39aef31a0cf44e))
* owl-bot-staging should not be commited ([#8337](https://github.com/googleapis/google-cloud-java/issues/8337)) ([c9bb4a9](https://github.com/googleapis/google-cloud-java/commit/c9bb4a97aa19032b78c86c951fe9920f24ac4eec))


### Dependencies

* reverting renovate bot pull requests ([#8417](https://github.com/googleapis/google-cloud-java/issues/8417)) ([8f0c60b](https://github.com/googleapis/google-cloud-java/commit/8f0c60bde446acccc665eb7894723632eefc3503))

## [1.4.2](https://github.com/googleapis/java-network-management/compare/v1.4.1...v1.4.2) (2022-09-15)


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.3 ([#216](https://github.com/googleapis/java-network-management/issues/216)) ([60f12d1](https://github.com/googleapis/java-network-management/commit/60f12d191cd59f1d41778c7982ddba79b8386df0))

## [1.4.1](https://github.com/googleapis/java-network-management/compare/v1.4.0...v1.4.1) (2022-09-09)


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.2 ([#212](https://github.com/googleapis/java-network-management/issues/212)) ([83d2f16](https://github.com/googleapis/java-network-management/commit/83d2f16b71217f43b951ed7858c7cda5a638a4c2))

## [1.4.0](https://github.com/googleapis/java-network-management/compare/v1.3.1...v1.4.0) (2022-08-09)


### Features

* add destination egress location field to the probing details ([a746f0a](https://github.com/googleapis/java-network-management/commit/a746f0af79d0f48e7a1137b3d799762a3cdbcf90))
* add fields to support Cloud functions ([a746f0a](https://github.com/googleapis/java-network-management/commit/a746f0af79d0f48e7a1137b3d799762a3cdbcf90))
* add new abort cause and new route next hop type ([a746f0a](https://github.com/googleapis/java-network-management/commit/a746f0af79d0f48e7a1137b3d799762a3cdbcf90))
* add new abort cause to the abort info ([a746f0a](https://github.com/googleapis/java-network-management/commit/a746f0af79d0f48e7a1137b3d799762a3cdbcf90))
* add new deliver targets and drop causes for Private Service Connect ([#195](https://github.com/googleapis/java-network-management/issues/195)) ([a746f0a](https://github.com/googleapis/java-network-management/commit/a746f0af79d0f48e7a1137b3d799762a3cdbcf90))
* add new next hop type to the route info ([a746f0a](https://github.com/googleapis/java-network-management/commit/a746f0af79d0f48e7a1137b3d799762a3cdbcf90))
* add source telemetry agent URI to the endpoint info ([a746f0a](https://github.com/googleapis/java-network-management/commit/a746f0af79d0f48e7a1137b3d799762a3cdbcf90))


### Documentation

* update several comments ([a746f0a](https://github.com/googleapis/java-network-management/commit/a746f0af79d0f48e7a1137b3d799762a3cdbcf90))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v3 ([#202](https://github.com/googleapis/java-network-management/issues/202)) ([a8e211a](https://github.com/googleapis/java-network-management/commit/a8e211a67ae080ace35d7e246993648dbac49fb3))

## [1.3.1](https://github.com/googleapis/java-network-management/compare/v1.3.0...v1.3.1) (2022-07-13)


### Bug Fixes

* enable longpaths support for windows test ([#1485](https://github.com/googleapis/java-network-management/issues/1485)) ([#196](https://github.com/googleapis/java-network-management/issues/196)) ([3fc0e47](https://github.com/googleapis/java-network-management/commit/3fc0e47323600ca303821b02eb1f83d75afdf81b))

## [1.3.0](https://github.com/googleapis/java-network-management/compare/v1.2.1...v1.3.0) (2022-06-30)


### Features

* Enable REST transport for most of Java and Go clients ([6366fb2](https://github.com/googleapis/java-network-management/commit/6366fb2b1a473e4b53fde504b94b8a047e6dc28c))
* introduce a projects_missing_permissions field in the AbortInfo structure ([6366fb2](https://github.com/googleapis/java-network-management/commit/6366fb2b1a473e4b53fde504b94b8a047e6dc28c))


### Bug Fixes

* update gapic-generator-java with mock service generation fixes ([#184](https://github.com/googleapis/java-network-management/issues/184)) ([6366fb2](https://github.com/googleapis/java-network-management/commit/6366fb2b1a473e4b53fde504b94b8a047e6dc28c))

## [1.2.1](https://github.com/googleapis/java-network-management/compare/v1.2.0...v1.2.1) (2022-06-23)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.13.0 ([#183](https://github.com/googleapis/java-network-management/issues/183)) ([5873104](https://github.com/googleapis/java-network-management/commit/5873104fe4dd288755b58f699a64b4d324c3dafd))

## [1.2.0](https://github.com/googleapis/java-network-management/compare/v1.1.12...v1.2.0) (2022-05-19)


### Features

* add build scripts for native image testing in Java 17 ([#1440](https://github.com/googleapis/java-network-management/issues/1440)) ([#175](https://github.com/googleapis/java-network-management/issues/175)) ([b6ed623](https://github.com/googleapis/java-network-management/commit/b6ed623a6b0b607063f0e3f95bddd0ebd8dcbc9e))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.12.0 ([#174](https://github.com/googleapis/java-network-management/issues/174)) ([2c2531d](https://github.com/googleapis/java-network-management/commit/2c2531d985d389f02da9fe400cbd07ecb2c1dd96))

### [1.1.12](https://github.com/googleapis/java-network-management/compare/v1.1.11...v1.1.12) (2022-04-22)


### Bug Fixes

* fixing failed release ([#165](https://github.com/googleapis/java-network-management/issues/165)) ([49cf9eb](https://github.com/googleapis/java-network-management/commit/49cf9eb99ef105253024cd19188623b722b69996))

### [1.1.11](https://github.com/googleapis/java-network-management/compare/v1.1.10...v1.1.11) (2022-04-15)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.10.0 ([#157](https://github.com/googleapis/java-network-management/issues/157)) ([7f6ec6d](https://github.com/googleapis/java-network-management/commit/7f6ec6d8c37cffee19b167d065fbf20eed07e4ad))

### [1.1.10](https://github.com/googleapis/java-network-management/compare/v1.1.9...v1.1.10) (2022-03-29)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.9.0 ([#152](https://github.com/googleapis/java-network-management/issues/152)) ([7551635](https://github.com/googleapis/java-network-management/commit/7551635ad47b286dd94d15271be878a83b6aaae6))

### [1.1.9](https://github.com/googleapis/java-network-management/compare/v1.1.8...v1.1.9) (2022-03-02)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.8.0 ([#143](https://github.com/googleapis/java-network-management/issues/143)) ([f54a5d3](https://github.com/googleapis/java-network-management/commit/f54a5d3c4e0c5b48cb24728d68dad252b3de7109))

### [1.1.8](https://github.com/googleapis/java-network-management/compare/v1.1.7...v1.1.8) (2022-02-28)


### Dependencies

* update actions/setup-java action to v3 ([#136](https://github.com/googleapis/java-network-management/issues/136)) ([0a0df2e](https://github.com/googleapis/java-network-management/commit/0a0df2ef2dd97025693517ed85c76f81f820a208))

### [1.1.7](https://github.com/googleapis/java-network-management/compare/v1.1.6...v1.1.7) (2022-02-11)


### Dependencies

* update actions/github-script action to v6 ([#128](https://github.com/googleapis/java-network-management/issues/128)) ([8f9909d](https://github.com/googleapis/java-network-management/commit/8f9909d41f7aeee95239140b4fdf8ef19e844ac0))

### [1.1.6](https://github.com/googleapis/java-network-management/compare/v1.1.5...v1.1.6) (2022-02-03)


### Dependencies

* **java:** update actions/github-script action to v5 ([#1339](https://github.com/googleapis/java-network-management/issues/1339)) ([#117](https://github.com/googleapis/java-network-management/issues/117)) ([91bdd2c](https://github.com/googleapis/java-network-management/commit/91bdd2c79b609117bb8c3dd2e0028105ae8110b7))
* update actions/github-script action to v5 ([#115](https://github.com/googleapis/java-network-management/issues/115)) ([c932958](https://github.com/googleapis/java-network-management/commit/c932958681205192afc20385f8347b0992dd8fd2))
* update actions/setup-java action to v2 ([#116](https://github.com/googleapis/java-network-management/issues/116)) ([c52ae2a](https://github.com/googleapis/java-network-management/commit/c52ae2af19744a197397d670135c33907b289e78))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.7.0 ([#119](https://github.com/googleapis/java-network-management/issues/119)) ([108718d](https://github.com/googleapis/java-network-management/commit/108718d73ce4c8809d7712e84fb85067571803eb))

### [1.1.5](https://www.github.com/googleapis/java-network-management/compare/v1.1.4...v1.1.5) (2022-01-07)


### Bug Fixes

* **java:** add -ntp flag to native image testing command ([#1299](https://www.github.com/googleapis/java-network-management/issues/1299)) ([#97](https://www.github.com/googleapis/java-network-management/issues/97)) ([8d3057c](https://www.github.com/googleapis/java-network-management/commit/8d3057c64c352fa26344606bae30aa03ffb21fed))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.6.0 ([#103](https://www.github.com/googleapis/java-network-management/issues/103)) ([ca45e37](https://www.github.com/googleapis/java-network-management/commit/ca45e37bf001365f7a1702b052cb8d758c572f39))

### [1.1.4](https://www.github.com/googleapis/java-network-management/compare/v1.1.3...v1.1.4) (2021-12-03)


### Bug Fixes

* **java:** java 17 dependency arguments ([#1266](https://www.github.com/googleapis/java-network-management/issues/1266)) ([#79](https://www.github.com/googleapis/java-network-management/issues/79)) ([369d655](https://www.github.com/googleapis/java-network-management/commit/369d655e06f104a6fa08867e2e5a61b4e0ecd00b))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.5.0 ([#88](https://www.github.com/googleapis/java-network-management/issues/88)) ([4372d19](https://www.github.com/googleapis/java-network-management/commit/4372d19607a3b062dd1032127dcee2c9f9cbc2d8))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.5.1 ([#94](https://www.github.com/googleapis/java-network-management/issues/94)) ([213ccec](https://www.github.com/googleapis/java-network-management/commit/213ccec43904143388f9fd2e08db6790e75b3be4))

### [1.1.3](https://www.github.com/googleapis/java-network-management/compare/v1.1.2...v1.1.3) (2021-10-19)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.4.0 ([#74](https://www.github.com/googleapis/java-network-management/issues/74)) ([7fe73fa](https://www.github.com/googleapis/java-network-management/commit/7fe73fa26a447d7c637aef9a649b794b662351d0))

### [1.1.2](https://www.github.com/googleapis/java-network-management/compare/v1.1.1...v1.1.2) (2021-09-22)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.3.0 ([#62](https://www.github.com/googleapis/java-network-management/issues/62)) ([b25a94e](https://www.github.com/googleapis/java-network-management/commit/b25a94ea0a762ee26ddd56bf5294eae54332f6ca))

### [1.1.1](https://www.github.com/googleapis/java-network-management/compare/v1.1.0...v1.1.1) (2021-09-14)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.2.1 ([#56](https://www.github.com/googleapis/java-network-management/issues/56)) ([882010f](https://www.github.com/googleapis/java-network-management/commit/882010f9a5af31fa555971fbc21a114b070fdc52))

## [1.1.0](https://www.github.com/googleapis/java-network-management/compare/v1.0.0...v1.1.0) (2021-09-03)


### Features

* Remove use of deprecated gradle command in java README ([#1196](https://www.github.com/googleapis/java-network-management/issues/1196)) ([#43](https://www.github.com/googleapis/java-network-management/issues/43)) ([d773a95](https://www.github.com/googleapis/java-network-management/commit/d773a957fd1a31504a2f410e38fa63eb715b11cb))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.0.1 ([#35](https://www.github.com/googleapis/java-network-management/issues/35)) ([17e2158](https://www.github.com/googleapis/java-network-management/commit/17e2158d1fdc6a076220ea5f220c96517f5fd9b0))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.1.0 ([#39](https://www.github.com/googleapis/java-network-management/issues/39)) ([fa1e318](https://www.github.com/googleapis/java-network-management/commit/fa1e3180bec2c03a89eaac8be6bf04ba8e6665d3))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.2.0 ([#45](https://www.github.com/googleapis/java-network-management/issues/45)) ([50d62f5](https://www.github.com/googleapis/java-network-management/commit/50d62f54a47cbd977c80550b7ab7d947a2fce7f0))

## [1.0.0](https://www.github.com/googleapis/java-network-management/compare/v0.1.0...v1.0.0) (2021-08-10)


### ⚠ BREAKING CHANGES

* release gapic-generator-java v2.0.0 (#28)

### Features

* promote to 1.0.0 ([#32](https://www.github.com/googleapis/java-network-management/issues/32)) ([98769b6](https://www.github.com/googleapis/java-network-management/commit/98769b678900d852f2b81f62d8090f66ba3660ec))
* release gapic-generator-java v2.0.0 ([#28](https://www.github.com/googleapis/java-network-management/issues/28)) ([2103482](https://www.github.com/googleapis/java-network-management/commit/21034826643dd874f2008093694f4f78ba08b05b))


### Bug Fixes

* owlbot post-processor should generate README ([#1154](https://www.github.com/googleapis/java-network-management/issues/1154)) ([#14](https://www.github.com/googleapis/java-network-management/issues/14)) ([08fb15b](https://www.github.com/googleapis/java-network-management/commit/08fb15bb06d206ba8df72deaee26100d7b3a5dc4)), closes [#1146](https://www.github.com/googleapis/java-network-management/issues/1146) [#1147](https://www.github.com/googleapis/java-network-management/issues/1147)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2 ([#29](https://www.github.com/googleapis/java-network-management/issues/29)) ([a17091e](https://www.github.com/googleapis/java-network-management/commit/a17091e97062e15e869c0eaaf3f84c41f3074294))

## 0.1.0 (2021-07-08)


### Features

* initial generation ([25428b6](https://www.github.com/googleapis/java-network-management/commit/25428b6619765b1a9c77d22c4e0383ddb7b78fbe))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.4.0 ([#8](https://www.github.com/googleapis/java-network-management/issues/8)) ([2e929be](https://www.github.com/googleapis/java-network-management/commit/2e929becfb0908b389446414a83c337af46b2c1d))
