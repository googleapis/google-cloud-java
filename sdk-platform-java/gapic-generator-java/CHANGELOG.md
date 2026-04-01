# Changelog

## [2.12.0](https://github.com/googleapis/gapic-generator-java/compare/v2.11.0...v2.12.0) (2022-12-09)


### Features

* Add scripts to release gapic-generator-java as jar ([#1111](https://github.com/googleapis/gapic-generator-java/issues/1111)) ([7941cc5](https://github.com/googleapis/gapic-generator-java/commit/7941cc5d7b3aca732d27b4f00eae18a145f8c459))


### Bug Fixes

* Sonar coverage for non-standard directory structure ([#1108](https://github.com/googleapis/gapic-generator-java/issues/1108)) ([60dc190](https://github.com/googleapis/gapic-generator-java/commit/60dc1904676b1ede343b84998658eca2e20cc56a))


### Dependencies

* Explicitly declare dependencies instead of using shared-dependencies-bom ([#1115](https://github.com/googleapis/gapic-generator-java/issues/1115)) ([402d565](https://github.com/googleapis/gapic-generator-java/commit/402d565e318b31199f3765b3bf82528fb189255d))

## [2.11.0](https://github.com/googleapis/gapic-generator-java/compare/v2.10.3...v2.11.0) (2022-11-30)


### Features

* **ast:** Array expressions ([#1080](https://github.com/googleapis/gapic-generator-java/issues/1080)) ([bd9532c](https://github.com/googleapis/gapic-generator-java/commit/bd9532c6663f2e8f9d9978cd0a3cffde821960ec))


### Bug Fixes

* **ast:** Add import generation for annotations on VariableExpr ([#1076](https://github.com/googleapis/gapic-generator-java/issues/1076)) ([f5d5524](https://github.com/googleapis/gapic-generator-java/commit/f5d5524e626f26ef53d4ae6c02118ef70ace205a))
* **deps:** Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.6 ([#1088](https://github.com/googleapis/gapic-generator-java/issues/1088)) ([0e75338](https://github.com/googleapis/gapic-generator-java/commit/0e75338dcb083c4cccd35d8682ba9cbe4e314ef8))
* Support testing nested argument method signatures and 'double' field assertions ([#1094](https://github.com/googleapis/gapic-generator-java/issues/1094)) ([4bf419f](https://github.com/googleapis/gapic-generator-java/commit/4bf419f764e2ecfdac9caf03968f40a8cd564655))

## [2.10.3](https://github.com/googleapis/gapic-generator-java/compare/v2.10.2...v2.10.3) (2022-11-01)


### Bug Fixes

* Fix REST transport client creation generated javadoc sample ([#1077](https://github.com/googleapis/gapic-generator-java/issues/1077)) ([9ac0ca8](https://github.com/googleapis/gapic-generator-java/commit/9ac0ca80b09077f7880f0029b5d7b090a10a10b8))
* Fixes regionTag breakage ([#1068](https://github.com/googleapis/gapic-generator-java/issues/1068)) ([bed9f72](https://github.com/googleapis/gapic-generator-java/commit/bed9f721fbafb5f2e974b6f43f8455f2fdb581f7))

## [2.10.2](https://github.com/googleapis/gapic-generator-java/compare/v2.10.1...v2.10.2) (2022-10-24)


### Bug Fixes

* **deps:** Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.5 ([#1063](https://github.com/googleapis/gapic-generator-java/issues/1063)) ([80ed62c](https://github.com/googleapis/gapic-generator-java/commit/80ed62cf6aff395d150e394a44fb60da37e9a6ae))
* Update regionTag to use service name ([#1047](https://github.com/googleapis/gapic-generator-java/issues/1047)) ([68b33c2](https://github.com/googleapis/gapic-generator-java/commit/68b33c23948ffe7a2bf6acd53731d786257f6bd1))

## [2.10.1](https://github.com/googleapis/gapic-generator-java/compare/v2.10.0...v2.10.1) (2022-10-20)


### Bug Fixes

* **deps:** Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.2 ([#1035](https://github.com/googleapis/gapic-generator-java/issues/1035)) ([f76634a](https://github.com/googleapis/gapic-generator-java/commit/f76634af8497ef2977376af570d175eb0fe91e6f))
* **deps:** Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.3 ([#1039](https://github.com/googleapis/gapic-generator-java/issues/1039)) ([9d25e47](https://github.com/googleapis/gapic-generator-java/commit/9d25e477126db35efd111a2b8ee76332b549ce91))
* **deps:** Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.4 ([#1050](https://github.com/googleapis/gapic-generator-java/issues/1050)) ([3b052e2](https://github.com/googleapis/gapic-generator-java/commit/3b052e27bb704124ae3214dd3e8708f8e32afe6c))
* **deps:** Update dependency org.yaml:snakeyaml to v1.32 ([#1037](https://github.com/googleapis/gapic-generator-java/issues/1037)) ([b520aa0](https://github.com/googleapis/gapic-generator-java/commit/b520aa0d35407daf96123d63c3112b9f29715115))
* **deps:** Update dependency org.yaml:snakeyaml to v1.33 ([#1043](https://github.com/googleapis/gapic-generator-java/issues/1043)) ([67a5dc5](https://github.com/googleapis/gapic-generator-java/commit/67a5dc5e4dd3302ececd212dd047f5731c4bf74d))
* Get numeric value for Enum fields if it is configured as query param or path param ([#1042](https://github.com/googleapis/gapic-generator-java/issues/1042)) ([0fdfa67](https://github.com/googleapis/gapic-generator-java/commit/0fdfa67fec84e1983c12b10c7b7ae7a0efa80f4d))
* Update sample region tag to parse host instead of proto package ([#1040](https://github.com/googleapis/gapic-generator-java/issues/1040)) ([01c14d4](https://github.com/googleapis/gapic-generator-java/commit/01c14d41d4195963c0ed46f310360f39eec6d420))

## [2.10.0](https://github.com/googleapis/gapic-generator-java/compare/v2.9.0...v2.10.0) (2022-09-06)


### Features

* Add support for rest numeric enums. ([#1020](https://github.com/googleapis/gapic-generator-java/issues/1020)) ([0a89829](https://github.com/googleapis/gapic-generator-java/commit/0a898299a6adb28dec6ce2af762827a434242311))
* **ast:** Extend support for annotation named parameters ([#1012](https://github.com/googleapis/gapic-generator-java/issues/1012)) ([5d3ff75](https://github.com/googleapis/gapic-generator-java/commit/5d3ff75db429d6dd43b0c3fc5dd4bfcb5ad06ae4))
* Update autogenerated snippet disclaimer ([#1029](https://github.com/googleapis/gapic-generator-java/issues/1029)) ([16f26f6](https://github.com/googleapis/gapic-generator-java/commit/16f26f63aa61b4ac4d42a1548a868fc1dd49c0eb))


### Bug Fixes

* **ast:** Removed lambda void return type check ([#1019](https://github.com/googleapis/gapic-generator-java/issues/1019)) ([317eff6](https://github.com/googleapis/gapic-generator-java/commit/317eff6cc3f5dc46896465d47a0d5135ed8dd0d2))
* **bazel:** Do not emit empty rm commands ([#1027](https://github.com/googleapis/gapic-generator-java/issues/1027)) ([7064f4c](https://github.com/googleapis/gapic-generator-java/commit/7064f4c6095f47895ec86712b5a3c73a66a76e3c))
* **bazel:** Do not print current working directory ([#1028](https://github.com/googleapis/gapic-generator-java/issues/1028)) ([5d94f1d](https://github.com/googleapis/gapic-generator-java/commit/5d94f1dc0fad961774f884e6cb1dc210f925f57d))
* **deps:** Update dependency com.google.cloud ([27a8aa2](https://github.com/googleapis/gapic-generator-java/commit/27a8aa21766589c044a2f2db2b46e20e4321cf59))
* **deps:** Update dependency com.google.cloud ([883fafa](https://github.com/googleapis/gapic-generator-java/commit/883fafa409e74a3943f147e01c7a100e9336e4a9))
* **deps:** Update dependency org.yaml ([56fd1ea](https://github.com/googleapis/gapic-generator-java/commit/56fd1ea51c949fa87ced1a5680b5542953097914))

## [2.9.0](https://github.com/googleapis/gapic-generator-java/compare/v2.8.3...v2.9.0) (2022-07-11)


### Features

* **ast:** add support for LambdaExpr to infer type from return expr type ([#1011](https://github.com/googleapis/gapic-generator-java/issues/1011)) ([a179558](https://github.com/googleapis/gapic-generator-java/commit/a1795582948d6c721544b920c86a4642df3b39a0))

## [2.8.3](https://github.com/googleapis/gapic-generator-java/compare/v2.8.2...v2.8.3) (2022-06-27)


### Bug Fixes

* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v2.13.0 ([#1009](https://github.com/googleapis/gapic-generator-java/issues/1009)) ([9dcc470](https://github.com/googleapis/gapic-generator-java/commit/9dcc4705ba429ed63468033711b2043386ab5dd3))
* Fix mixin mock service and gradle build generation ([#1010](https://github.com/googleapis/gapic-generator-java/issues/1010)) ([d896e6e](https://github.com/googleapis/gapic-generator-java/commit/d896e6e1b052a9da5ef1304220ec88017a24991d))
* make `BetaApi` the `getHttpJsonOperationsClient()` in case of multitransport clients ([#1007](https://github.com/googleapis/gapic-generator-java/issues/1007)) ([badd554](https://github.com/googleapis/gapic-generator-java/commit/badd5544d1cd7e03e8c1b282aac4954acb1bb5f0))

## [2.8.2](https://github.com/googleapis/gapic-generator-java/compare/v2.8.1...v2.8.2) (2022-06-14)


### Bug Fixes

* Fix typo in generated comment ([#1006](https://github.com/googleapis/gapic-generator-java/issues/1006)) ([14e76e7](https://github.com/googleapis/gapic-generator-java/commit/14e76e73802ec05f2fe4a820ab10c2dbf7321c6d))
* Remove HttpMethod compile time dependency from genrated HttpJson stubs ([#1004](https://github.com/googleapis/gapic-generator-java/issues/1004)) ([e5988a0](https://github.com/googleapis/gapic-generator-java/commit/e5988a0e4900efd1943e942f445f1e86fdd6b05c))

## [2.8.1](https://github.com/googleapis/gapic-generator-java/compare/v2.8.0...v2.8.1) (2022-06-09)


### Bug Fixes

* More REST transport fixes ([#1003](https://github.com/googleapis/gapic-generator-java/issues/1003)) ([2bed7cf](https://github.com/googleapis/gapic-generator-java/commit/2bed7cf4f4168977ccb413125c6bcb43422061fd))
* Multiple REST transport related fixes ([#997](https://github.com/googleapis/gapic-generator-java/issues/997)) ([61e2e96](https://github.com/googleapis/gapic-generator-java/commit/61e2e9660fa62536163982f3241fcc479973e163))
* use correct paginated field name ([#1001](https://github.com/googleapis/gapic-generator-java/issues/1001)) ([7f186b5](https://github.com/googleapis/gapic-generator-java/commit/7f186b551f14cc14a503b552ef73c52d9e491628))

## [2.8.0](https://github.com/googleapis/gapic-generator-java/compare/v2.7.0...v2.8.0) (2022-05-21)


### Features

* Add support for additional_bindings ([#993](https://github.com/googleapis/gapic-generator-java/issues/993)) ([ce58c18](https://github.com/googleapis/gapic-generator-java/commit/ce58c181691d0be826634d1bd8373f07c1295156))


### Bug Fixes

* [REGAPIC] Fix repeated fields handling for query parameters ([#989](https://github.com/googleapis/gapic-generator-java/issues/989)) ([f7ceab9](https://github.com/googleapis/gapic-generator-java/commit/f7ceab9ee53b34b2114b77bb4bebb693ad6989a7))
* [REGAPIC] Fix snake_case nested resource names in generated unit tests ([#990](https://github.com/googleapis/gapic-generator-java/issues/990)) ([b8e3ae4](https://github.com/googleapis/gapic-generator-java/commit/b8e3ae4c0ebe98d757acb079987d96b281aec1f5))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v2.11.0 ([#995](https://github.com/googleapis/gapic-generator-java/issues/995)) ([df7e08e](https://github.com/googleapis/gapic-generator-java/commit/df7e08ebdf76b8dfb4b9961d3c8670f8e95c788c))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v2.12.0 ([#996](https://github.com/googleapis/gapic-generator-java/issues/996)) ([4673e52](https://github.com/googleapis/gapic-generator-java/commit/4673e5206b4535d2e691b5c0b8cffaa5b35c4ca1))
* Fix `BetaApi` annotaiton usage for REST transport and clean `BetaApi` for default stubs in all transports ([#987](https://github.com/googleapis/gapic-generator-java/issues/987)) ([d22b966](https://github.com/googleapis/gapic-generator-java/commit/d22b966703644ea150b9ceee6df39cde17cf8df4))

## [2.7.0](https://github.com/googleapis/gapic-generator-java/compare/v2.6.1...v2.7.0) (2022-04-29)


### Features

* Add add autogenerated javadoc sample for selecting REST transport over gRPC ([#983](https://github.com/googleapis/gapic-generator-java/issues/983)) ([051713d](https://github.com/googleapis/gapic-generator-java/commit/051713dec7706713900b8708e3a6b9ab0639438e))
* inline disclaimer comment, use Sample/RegionTag, collect GapicClass samples (pt 2) ([#970](https://github.com/googleapis/gapic-generator-java/issues/970)) ([f8b3616](https://github.com/googleapis/gapic-generator-java/commit/f8b36168372118d6ed639263bae192647912ed43))
* SampleComposer, Sample, Region Tag (pt1) ([#933](https://github.com/googleapis/gapic-generator-java/issues/933)) ([b7cf105](https://github.com/googleapis/gapic-generator-java/commit/b7cf105764bdc6c0a952e7b2705a454bbce3eadf))
* write samples to file (pt3) ([#980](https://github.com/googleapis/gapic-generator-java/issues/980)) ([04a6665](https://github.com/googleapis/gapic-generator-java/commit/04a66659f3724d125206b09ad6cf9544d064e8ae))


### Bug Fixes

* allow empty services and java keywords as a method names ([#985](https://github.com/googleapis/gapic-generator-java/issues/985)) ([e37893c](https://github.com/googleapis/gapic-generator-java/commit/e37893c37e333c947b75f55b1974045509d171d4))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v2.10.0 ([#982](https://github.com/googleapis/gapic-generator-java/issues/982)) ([9e863f8](https://github.com/googleapis/gapic-generator-java/commit/9e863f8b7b0407cb1a58aba5952f54b56d15167f))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v2.8.0 ([#959](https://github.com/googleapis/gapic-generator-java/issues/959)) ([0ca7a21](https://github.com/googleapis/gapic-generator-java/commit/0ca7a21df4fbae041e96b97a7235eff01195f429))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v2.9.0 ([#973](https://github.com/googleapis/gapic-generator-java/issues/973)) ([8fa9f07](https://github.com/googleapis/gapic-generator-java/commit/8fa9f07123e5b2837ce2cd7fc6cf8bbed43ae2ae))
* **deps:** update dependency junit:junit to v4.13.2 ([#940](https://github.com/googleapis/gapic-generator-java/issues/940)) ([09c69f7](https://github.com/googleapis/gapic-generator-java/commit/09c69f723fd868d767b88467ed3c496461876c75))
* **deps:** update dependency org.yaml:snakeyaml to v1.30 ([#946](https://github.com/googleapis/gapic-generator-java/issues/946)) ([996c8c3](https://github.com/googleapis/gapic-generator-java/commit/996c8c38bc7d9e5730bdaf99fdd5b20aee5cd9b8))
* setups for manually runs single JUnit test ([7ab9ae3](https://github.com/googleapis/gapic-generator-java/commit/7ab9ae30d71e755877061596bfba8f6c87e0f66b))
* Update copyright to 2022 for newly generated files. ([#951](https://github.com/googleapis/gapic-generator-java/issues/951)) ([a6ad7d9](https://github.com/googleapis/gapic-generator-java/commit/a6ad7d9988fc9e42b371082130e3b7f6bab75719))

### [2.6.1](https://github.com/googleapis/gapic-generator-java/compare/v2.6.0...v2.6.1) (2022-02-11)


### Bug Fixes

* Routing annotation was not recognized on parsing protos ([#928](https://github.com/googleapis/gapic-generator-java/issues/928)) ([2ce9f42](https://github.com/googleapis/gapic-generator-java/commit/2ce9f42ce23e91ff4f559d6a44be57df9f97eb46))

## [2.6.0](https://github.com/googleapis/gapic-generator-java/compare/v2.5.0...v2.6.0) (2022-01-28)


### Features

* Support explicit dynamic routing header ([#887](https://github.com/googleapis/gapic-generator-java/issues/887)) ([bcc1bdb](https://github.com/googleapis/gapic-generator-java/commit/bcc1bdb5fdf57d8843a03318d746df7d8392d848))


### Bug Fixes

* increase default memory for Gradle builds on generated libraries ([#907](https://github.com/googleapis/gapic-generator-java/issues/907)) ([d210aa1](https://github.com/googleapis/gapic-generator-java/commit/d210aa193d45ba5fbdea6ae5f31e471401c27cb7))

## [2.5.0](https://github.com/googleapis/gapic-generator-java/compare/v2.4.1...v2.5.0) (2022-01-22)


### Features

* add server streaming support for REST transport ([#902](https://github.com/googleapis/gapic-generator-java/issues/902)) ([3b2dec6](https://github.com/googleapis/gapic-generator-java/commit/3b2dec6adf46823eeb6859e93362e63f00d84ffc))
* make generated test values comply with url path template ([#903](https://github.com/googleapis/gapic-generator-java/issues/903)) ([bfb35cd](https://github.com/googleapis/gapic-generator-java/commit/bfb35cd31c05b5fbd2ea8073bcdcfdd3496bca12))

### [2.4.1](https://github.com/googleapis/gapic-generator-java/compare/v2.4.0...v2.4.1) (2022-01-14)


### Bug Fixes

* expose extra deps transitively to library users ([#899](https://github.com/googleapis/gapic-generator-java/issues/899)) ([8fa2660](https://github.com/googleapis/gapic-generator-java/commit/8fa2660022cf65ebed011165378683173989332b))
* fix broken Gradle allJars task on generated libs ([#901](https://github.com/googleapis/gapic-generator-java/issues/901)) ([e990105](https://github.com/googleapis/gapic-generator-java/commit/e99010596d85f891a738de71be3b5fb9c857594a))

## [2.4.0](https://github.com/googleapis/gapic-generator-java/compare/v2.3.1...v2.4.0) (2022-01-11)


### Features

* add `install` "alias" for local publication ([#897](https://github.com/googleapis/gapic-generator-java/issues/897)) ([662d1ba](https://github.com/googleapis/gapic-generator-java/commit/662d1ba2dab831a7927159b85c196caf28f13cc7))

### [2.3.1](https://www.github.com/googleapis/gapic-generator-java/compare/v2.3.0...v2.3.1) (2022-01-10)


### Bug Fixes

* fix Gradle build error for sourcesJar task on generated libs ([#894](https://www.github.com/googleapis/gapic-generator-java/issues/894)) ([1060a1a](https://www.github.com/googleapis/gapic-generator-java/commit/1060a1af874d9be3f89c567635630f5ad6f8e830))

## [2.3.0](https://www.github.com/googleapis/gapic-generator-java/compare/v2.2.4...v2.3.0) (2022-01-06)


### Features

* support Java 9+ compilation of generated libs ([#889](https://www.github.com/googleapis/gapic-generator-java/issues/889)) ([83552c4](https://www.github.com/googleapis/gapic-generator-java/commit/83552c45611c5a79533d6872bf8824cc686e480d))

### [2.2.4](https://www.github.com/googleapis/gapic-generator-java/compare/v2.2.3...v2.2.4) (2022-01-04)


### Bug Fixes

* add missing dependencies in Gradle for "self-service" library generation ([#884](https://www.github.com/googleapis/gapic-generator-java/issues/884)) ([3adac5e](https://www.github.com/googleapis/gapic-generator-java/commit/3adac5e2898e40a1e5395ab65db037c26a4f7e1b))

### [2.2.3](https://www.github.com/googleapis/gapic-generator-java/compare/v2.2.2...v2.2.3) (2021-12-06)


### Bug Fixes

* **deps:** upgrade gax to 2.7.1, protobuf to 3.19.1, grpc to 1.42.1, and truth to 1.1.2, upgrade Bazel in GitHub Actions, and fix build error ([#877](https://www.github.com/googleapis/gapic-generator-java/issues/877)) ([1597707](https://www.github.com/googleapis/gapic-generator-java/commit/1597707e8d525f8abaa058bc0fdcbd3a825032c9))

### [2.2.2](https://www.github.com/googleapis/gapic-generator-java/compare/v2.2.1...v2.2.2) (2021-11-05)


### Bug Fixes

* **resnames:** ensure determinstic code generation ([#865](https://www.github.com/googleapis/gapic-generator-java/issues/865)) ([680874d](https://www.github.com/googleapis/gapic-generator-java/commit/680874dcf84a5c31abc5948fa59f2cb38f14d80c))
* revert gradle version used for generated assembly packages (bazel rules) ([#872](https://www.github.com/googleapis/gapic-generator-java/issues/872)) ([4e73c9a](https://www.github.com/googleapis/gapic-generator-java/commit/4e73c9aefa3527a0b28c0d32255accf679218b81))
* Use parent type instead of child_type in method doc sample ([#862](https://www.github.com/googleapis/gapic-generator-java/issues/862)) ([6a39c7f](https://www.github.com/googleapis/gapic-generator-java/commit/6a39c7f54180154f393e88196c79cc9ebba38e52))

### [2.2.1](https://www.github.com/googleapis/gapic-generator-java/compare/v2.2.0...v2.2.1) (2021-10-25)


### Bug Fixes

* gax batching regression ([#863](https://www.github.com/googleapis/gapic-generator-java/issues/863)) ([3a6f168](https://www.github.com/googleapis/gapic-generator-java/commit/3a6f168322962d1b54ed37ff258e228e4b2f33ed))

## [2.2.0](https://www.github.com/googleapis/gapic-generator-java/compare/v2.1.0...v2.2.0) (2021-10-09)


### Features

* Add REST AIP-151 LRO suport ([cb1b534](https://www.github.com/googleapis/gapic-generator-java/commit/cb1b534701b95781e5195e57eacf6d0abff252bf))
* enable self signed JWT for http ([#850](https://www.github.com/googleapis/gapic-generator-java/issues/850)) ([aba0ec0](https://www.github.com/googleapis/gapic-generator-java/commit/aba0ec00dc912400e1c0457d971d8f4120c5d03a))
* Implement DIREGAPIC LRO annotations ([#832](https://www.github.com/googleapis/gapic-generator-java/issues/832)) ([d7b29e0](https://www.github.com/googleapis/gapic-generator-java/commit/d7b29e05d7cfda1eb1a3b09d7ad7d625cab4bde1))
* REGAPIC initial implementation ([#824](https://www.github.com/googleapis/gapic-generator-java/issues/824)) ([fdcfe70](https://www.github.com/googleapis/gapic-generator-java/commit/fdcfe705b5fb42e11dfd511ccf7fdee40bcba131))
* REGAPIC Multitransport implementation (grpc+rest) ([#833](https://www.github.com/googleapis/gapic-generator-java/issues/833)) ([445daf4](https://www.github.com/googleapis/gapic-generator-java/commit/445daf472b337520f108b485abfdbe8b20b16b01))


### Bug Fixes

* [bazel] fix rest transport handling in assembly rule ([#835](https://www.github.com/googleapis/gapic-generator-java/issues/835)) ([92f7c1c](https://www.github.com/googleapis/gapic-generator-java/commit/92f7c1cf7b343947a64943fd7ee7ffb4d67a9d5a))
* DIREGAPIC LRO generated tests logic ([#838](https://www.github.com/googleapis/gapic-generator-java/issues/838)) ([8ae8e6f](https://www.github.com/googleapis/gapic-generator-java/commit/8ae8e6f111d0f3849986cd0445d6003601ced148))
* fix diregapic-lro logic ([#834](https://www.github.com/googleapis/gapic-generator-java/issues/834)) ([957f69a](https://www.github.com/googleapis/gapic-generator-java/commit/957f69a0dc063e77b5e49da28f0a6d9a4a6c3bdb))

## [2.1.0](https://www.github.com/googleapis/gapic-generator-java/compare/v2.0.1...v2.1.0) (2021-08-17)


### Features

* enable self signed jwt for gapic clients ([#794](https://www.github.com/googleapis/gapic-generator-java/issues/794)) ([1b7ee1e](https://www.github.com/googleapis/gapic-generator-java/commit/1b7ee1e3911e1c8ecab9a94d68d7a59b437d2449))

### [2.0.1](https://www.github.com/googleapis/gapic-generator-java/compare/v2.0.0...v2.0.1) (2021-08-06)


### Bug Fixes

* bring back unused resnames for Ads ([#821](https://www.github.com/googleapis/gapic-generator-java/issues/821)) ([7fa135c](https://www.github.com/googleapis/gapic-generator-java/commit/7fa135c9aa60c9cb15880e098d36ea81b95ea488))
* **resnames:** ensure deterministic resname order for samplegen ([#813](https://www.github.com/googleapis/gapic-generator-java/issues/813)) ([c4709df](https://www.github.com/googleapis/gapic-generator-java/commit/c4709df5d8ed9f0074f7e25df5db93e9d9b35749))

## [2.0.0](https://www.github.com/googleapis/gapic-generator-java/compare/v1.0.17...v2.0.0) (2021-08-03)


### ⚠ BREAKING CHANGES

* remove Exception, unused resname classes for Java major version bump (#814)

### Features

* Lambda-ize single-method anon classes (Java 8+) ([#815](https://www.github.com/googleapis/gapic-generator-java/issues/815)) ([19b661c](https://www.github.com/googleapis/gapic-generator-java/commit/19b661cc78757e37ce93bae96eb81cb4ac32658b))
* remove Exception, unused resname classes for Java major version bump ([#814](https://www.github.com/googleapis/gapic-generator-java/issues/814)) ([8abece2](https://www.github.com/googleapis/gapic-generator-java/commit/8abece20dd20e9ac8134df04301ce5b6e2ab76ad))

### [1.0.17](https://www.github.com/googleapis/gapic-generator-java/compare/v1.0.16...v1.0.17) (2021-08-02)


### Features

* **ast:** Add support for multi-catch blocks [ggj] ([#811](https://www.github.com/googleapis/gapic-generator-java/issues/811)) ([55ef1a6](https://www.github.com/googleapis/gapic-generator-java/commit/55ef1a63427683538e48050333eedb0666635568))
* **ast:** Add support for Throwable causes [ggj] ([#801](https://www.github.com/googleapis/gapic-generator-java/issues/801)) ([7fdeece](https://www.github.com/googleapis/gapic-generator-java/commit/7fdeeced7642fefdfdc5c6e898661c72fe9d78a8))
* **ast:** support throwing all kinds of expressions ([#810](https://www.github.com/googleapis/gapic-generator-java/issues/810)) ([0817650](https://www.github.com/googleapis/gapic-generator-java/commit/0817650b35487f32d7987ba718ce71fc7551e3a0))


### Bug Fixes

* (rest transport) Add `@BetaApi` to the generated `TransportServiceFactory` class and lro-specific method ([#787](https://www.github.com/googleapis/gapic-generator-java/issues/787)) ([ebe1aef](https://www.github.com/googleapis/gapic-generator-java/commit/ebe1aefbe860a41aabd8ced5268ccc6c7efdf791))
* prevent hanging by call backgroundResources.close() on stub.close() [ggj] ([#804](https://www.github.com/googleapis/gapic-generator-java/issues/804)) ([428db97](https://www.github.com/googleapis/gapic-generator-java/commit/428db97c1534255a60530a8ed6137efc17ed56f4))
* **resnames:** fallback to fully-qualified Object name upon proto typing conflicts [ggj] ([#803](https://www.github.com/googleapis/gapic-generator-java/issues/803)) ([e654bfb](https://www.github.com/googleapis/gapic-generator-java/commit/e654bfb936b571af2546f550c9a1589f8ad63d67))



### [1.0.16](https://www.github.com/googleapis/gapic-generator-java/compare/v1.0.15...v1.0.16) (2021-06-30)


### Bug Fixes

* **bazel:** Eradicate monolith deps from Java µgen repo ([#778](https://www.github.com/googleapis/gapic-generator-java/issues/778)) ([86f2472](https://www.github.com/googleapis/gapic-generator-java/commit/86f2472963f020127ef6ff92be6241d12e2273af))
* **build:** Update googleapis-discovery hash to fix compute integration test ([#782](https://www.github.com/googleapis/gapic-generator-java/issues/782)) ([46bb19a](https://www.github.com/googleapis/gapic-generator-java/commit/46bb19a7ee61da86b4be6d87a71f3cd210e753d2))
* **protoc:** Mirror protoc's field name conflict resolution logic in client generation ([#781](https://www.github.com/googleapis/gapic-generator-java/issues/781)) ([9432979](https://www.github.com/googleapis/gapic-generator-java/commit/9432979bab59f48c8645fa47d752cdd470d4a682))

### [1.0.15](https://www.github.com/googleapis/gapic-generator-java/compare/v1.0.14...v1.0.15) (2021-06-22)


### Features

* Implement field presence support for DIREGAPIC ([#774](https://www.github.com/googleapis/gapic-generator-java/issues/774)) ([c820361](https://www.github.com/googleapis/gapic-generator-java/commit/c82036105d299b0a1192cd0def5e68253e4f542c))


### Bug Fixes

* **service.yaml:** Remove allowlist restriction ([#776](https://www.github.com/googleapis/gapic-generator-java/issues/776)) ([8f42efd](https://www.github.com/googleapis/gapic-generator-java/commit/8f42efdb92d606a768a524517fe949c4f9112025))


### Miscellaneous Chores

* release 1.0.15 ([f752478](https://www.github.com/googleapis/gapic-generator-java/commit/f75247845344540a94c4efcd416f34f96ea0c2a3))

### [1.0.14](https://www.github.com/googleapis/gapic-generator-java/compare/v1.0.13...v1.0.14) (2021-06-17)


### Features

* Add DIREGAPIC-specific pagination ([#767](https://www.github.com/googleapis/gapic-generator-java/issues/767)) ([1294c29](https://www.github.com/googleapis/gapic-generator-java/commit/1294c298f50cc4474ae562e6a07f37a5f94fe5b8))


### Bug Fixes

* **bazel:** Remove monolith rule deps from the Java µgen Bazel rules ([#764](https://www.github.com/googleapis/gapic-generator-java/issues/764)) ([bff3efc](https://www.github.com/googleapis/gapic-generator-java/commit/bff3efc25e43692ea5b6e769c20d25d5b9a1e3d2))



### [1.0.13](https://www.github.com/googleapis/gapic-generator-java/compare/v1.0.12...v1.0.13) (2021-06-16)


### Bug Fixes

* **resnames:** Fix resname builder name conflicts in ctor with this assignment ([#769](https://www.github.com/googleapis/gapic-generator-java/issues/769)) ([edac844](https://www.github.com/googleapis/gapic-generator-java/commit/edac8447d74c43ab0db963a37f66e1029ab19f0c))

### [1.0.12](https://www.github.com/googleapis/gapic-generator-java/compare/v1.0.11...v1.0.12) (2021-06-10)


### Features

* add mtls support ([#672](https://www.github.com/googleapis/gapic-generator-java/issues/672)) ([1e24893](https://www.github.com/googleapis/gapic-generator-java/commit/1e24893a65daf8ef067e331364c591ac973b5e02))


### Bug Fixes

* **mocks:** Use java.lang.Object if there are protos named 'Object' ([#760](https://www.github.com/googleapis/gapic-generator-java/issues/760)) ([2a7064b](https://www.github.com/googleapis/gapic-generator-java/commit/2a7064b88fe26586bd8aed43b7a7d28c7e974ec0))
* **resnames:** Use anon resname classes when only wildcards are present ([#763](https://www.github.com/googleapis/gapic-generator-java/issues/763)) ([f0ecead](https://www.github.com/googleapis/gapic-generator-java/commit/f0ecead9f1cc645cdbb7f61cdfc820c7df95355d))


### Miscellaneous Chores

* release 1.0.12 ([02eab0e](https://www.github.com/googleapis/gapic-generator-java/commit/02eab0ec61260048a2684119cfd4fa2172f3a637))

### [1.0.11](https://www.github.com/googleapis/gapic-generator-java/compare/v1.0.10...v1.0.11) (2021-06-07)


### Features

* DIREGAPIC initial implementation ([#746](https://www.github.com/googleapis/gapic-generator-java/issues/746)) ([81f6737](https://www.github.com/googleapis/gapic-generator-java/commit/81f6737359ac6ce5ee2b42ab4f755fbb05a3cf28))


### Bug Fixes

* **bazel:** ensure integration tests diff files recursively ([#745](https://www.github.com/googleapis/gapic-generator-java/issues/745)) ([ddc75f9](https://www.github.com/googleapis/gapic-generator-java/commit/ddc75f9f3b84d0ea50638a79a63d40cf551211e2))
* **resnames:** filter out mixin services from resname pkg candidates ([#751](https://www.github.com/googleapis/gapic-generator-java/issues/751)) ([72fa76f](https://www.github.com/googleapis/gapic-generator-java/commit/72fa76f27379a74a143b1735f60ae3e00da4c1a6))
* **tests:** Ensure deterministic field ordering in test classes ([#743](https://www.github.com/googleapis/gapic-generator-java/issues/743)) ([fdb705b](https://www.github.com/googleapis/gapic-generator-java/commit/fdb705b0a39443fb0b7679d879f27e0aa1c36b67))
* **tests:** handle Java 11 set ordering differences for RPCs and fields in test/mock classes ([#750](https://www.github.com/googleapis/gapic-generator-java/issues/750)) ([eaf4592](https://www.github.com/googleapis/gapic-generator-java/commit/eaf4592e139fbc42810e7f60dc9967320195bf85))


### [1.0.10](https://www.github.com/googleapis/gapic-generator-java/compare/v1.0.9...v1.0.10) (2021-05-26)


### Miscellaneous Chores

* Pre-DIREGAPIC refactoring ([04c2faa](https://github.com/googleapis/gapic-generator-java/commit/04c2faa191a9b5a10b92392fe8482279c4404803))

### [1.0.9](https://www.github.com/googleapis/gapic-generator-java/compare/v1.0.8...v1.0.9) (2021-05-26)


### Features

* add AST support for lambdas ([#736](https://www.github.com/googleapis/gapic-generator-java/issues/736)) ([9ced678](https://www.github.com/googleapis/gapic-generator-java/commit/9ced6780c7a6b9934dd548002602618566a539d6))


### Bug Fixes

* Support enums in proto HTTP annotations ([#733](https://www.github.com/googleapis/gapic-generator-java/issues/733)) ([f5c7b86](https://www.github.com/googleapis/gapic-generator-java/commit/f5c7b86b43ad71ffe47d8ba039155db601638e1f))
* Support PubSub's _deleted-topic_ pattern ([#739](https://www.github.com/googleapis/gapic-generator-java/issues/739)) ([7d8c62d](https://www.github.com/googleapis/gapic-generator-java/commit/7d8c62d8e8922a3589e631299ecb0287bc41ba2d))


### [1.0.8](https://www.github.com/googleapis/gapic-generator-java/compare/v1.0.7...v1.0.8) (2021-05-24)


### Miscellaneous Chores

* DIREGAPIC refactoring ([ae17e7e](https://github.com/googleapis/gapic-generator-java/commit/ae17e7e9a272b422176962d896e387496b1806e8))

### [1.0.7](https://www.github.com/googleapis/gapic-generator-java/compare/v1.0.6...v1.0.7) (2021-05-21)


### Bug Fixes

* Add PubSub to service.yaml / mixin allowlist ([#729](https://www.github.com/googleapis/gapic-generator-java/issues/729)) ([e7f6d33](https://www.github.com/googleapis/gapic-generator-java/commit/e7f6d33051e335504b05c402d3b98c387a9f0daf))


### [1.0.6](https://www.github.com/googleapis/gapic-generator-java/compare/v1.0.5...v1.0.6) (2021-05-19)


### Bug Fixes

* **mixins:** Gate mixin RPC on HTTP rules, add yaml doc/http overrides ([#727](https://www.github.com/googleapis/gapic-generator-java/issues/727)) ([229da5d](https://www.github.com/googleapis/gapic-generator-java/commit/229da5d94cf7db060abf3ea006a20d1ade804597))

### [1.0.5](https://www.github.com/googleapis/gapic-generator-java/compare/v1.0.4...v1.0.5) (2021-05-17)


### Bug Fixes

* **types:** Reorder nested types for legacy protos w/ java_outer_class in one file ([#724](https://www.github.com/googleapis/gapic-generator-java/issues/724)) ([925356d](https://www.github.com/googleapis/gapic-generator-java/commit/925356d659aed4b8550ce526f1772a706661c246))

### [1.0.4](https://www.github.com/googleapis/gapic-generator-java/compare/v1.0.3...v1.0.4) (2021-05-13)


### Bug Fixes

* **types:** Use fully-qualified message type names ([#723](https://www.github.com/googleapis/gapic-generator-java/issues/723)) ([8a5c36c](https://www.github.com/googleapis/gapic-generator-java/commit/8a5c36ccce7540940ec7a4bf8751971c3741d89d))
* Use the right composers in deprecation unit tests ([#715](https://www.github.com/googleapis/gapic-generator-java/issues/715)) ([2318136](https://www.github.com/googleapis/gapic-generator-java/commit/2318136e49060c3212abfd6337e2c3ceb2c2fc69))

### [1.0.3](https://www.github.com/googleapis/gapic-generator-java/compare/v1.0.2...v1.0.3) (2021-04-07)


### Bug Fixes

* Comment typo in Parser.java ([#701](https://www.github.com/googleapis/gapic-generator-java/issues/701)) ([685feff](https://www.github.com/googleapis/gapic-generator-java/commit/685feff32bf16484895ed86121282360b3e2dab3))

### [1.0.2](https://www.github.com/googleapis/gapic-generator-java/compare/v1.0.1...v1.0.2) (2021-03-14)


### Bug Fixes

* add request with default value in regular paged callable method ([#690](https://www.github.com/googleapis/gapic-generator-java/issues/690)) ([cc8ce77](https://www.github.com/googleapis/gapic-generator-java/commit/cc8ce778f07577eb3ed4cc9d07ac25511b0f1acd))
* **mixins:** handle unit tests for mixin pagination methods ([#691](https://www.github.com/googleapis/gapic-generator-java/issues/691)) ([edd7443](https://www.github.com/googleapis/gapic-generator-java/commit/edd7443d16e5c9389de16e6235fe884f9b996cf6))
* **sample code:** Update client samples in  KMS goldens ([#697](https://www.github.com/googleapis/gapic-generator-java/issues/697)) ([3777196](https://www.github.com/googleapis/gapic-generator-java/commit/3777196f0225a8b28203f1c225a67ea56b8728d3))

### [1.0.1](https://www.github.com/googleapis/gapic-generator-java/compare/v1.0.0...v1.0.1) (2021-03-03)


### Bug Fixes

* **codegen:** Bump license year in generated file headers ([#685](https://www.github.com/googleapis/gapic-generator-java/issues/685)) ([d1b3032](https://www.github.com/googleapis/gapic-generator-java/commit/d1b3032d54bc75e2f4e1b954f7215cff1069110e))
* **metadata:** gate metadata file-gen on a CLI flag ([#684](https://www.github.com/googleapis/gapic-generator-java/issues/684)) ([738bf8a](https://www.github.com/googleapis/gapic-generator-java/commit/738bf8a95125cbdd33cb0f762afb415844bf9426))
* **mixins:** enable codegen for standalone mixin APIs, add IAM integ test ([#679](https://www.github.com/googleapis/gapic-generator-java/issues/679)) ([bbde184](https://www.github.com/googleapis/gapic-generator-java/commit/bbde184b4d5a6085a6f18fd8120bd79207f67c5d))
* **mixins:** enable RPC overrides to clobber mixed-in RPCs ([#678](https://www.github.com/googleapis/gapic-generator-java/issues/678)) ([0645de4](https://www.github.com/googleapis/gapic-generator-java/commit/0645de476d131be20839f74ba83b53483d0d0b6d))

## [1.0.0](https://www.github.com/googleapis/gapic-generator-java/compare/v0.0.21...v1.0.0) (2021-03-01)


### Bug Fixes

* add common srcs to test, check test targets only in codecov ([#669](https://www.github.com/googleapis/gapic-generator-java/issues/669)) ([f81ed0b](https://www.github.com/googleapis/gapic-generator-java/commit/f81ed0bdede477c51cd6755b5050933319a442c9))
* **release:** update gax-java to 1.62.0 ([#675](https://www.github.com/googleapis/gapic-generator-java/issues/675)) ([51ed181](https://www.github.com/googleapis/gapic-generator-java/commit/51ed181f9fa2747604054214db79e1f2398b1dac))
