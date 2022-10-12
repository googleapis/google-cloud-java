# Changelog

## [1.13.0](https://github.com/googleapis/google-cloud-java/compare/google-cloud-compute-v1.12.1...google-cloud-compute-v1.13.0) (2022-10-12)


### Features

* [analyticsdata] add `subject_to_thresholding` field to `ResponseMetadata` type ([#8545](https://github.com/googleapis/google-cloud-java/issues/8545)) ([8fdc6c1](https://github.com/googleapis/google-cloud-java/commit/8fdc6c1f10f88f30f4d1407579d645f75366b4cf))
* [compute] Update Compute Engine API to revision 20220831 ([#729](https://github.com/googleapis/google-cloud-java/issues/729)) ([#8401](https://github.com/googleapis/google-cloud-java/issues/8401)) ([25ca88b](https://github.com/googleapis/google-cloud-java/commit/25ca88b5e5e4542d2b0166d544c8c01e033991bd))
* add `tokens_per_project_per_hour` field to `PropertyQuota` type ([8fdc6c1](https://github.com/googleapis/google-cloud-java/commit/8fdc6c1f10f88f30f4d1407579d645f75366b4cf))


### Bug Fixes

* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.2 ([#8325](https://github.com/googleapis/google-cloud-java/issues/8325)) ([01f492b](https://github.com/googleapis/google-cloud-java/commit/01f492be424acdb90edb23ba66656aeff7cf39eb))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.4 ([#8528](https://github.com/googleapis/google-cloud-java/issues/8528)) ([bd36199](https://github.com/googleapis/google-cloud-java/commit/bd361998ac4eb7c78eef3b3eac39aef31a0cf44e))
* owl-bot-staging should not be commited ([#8337](https://github.com/googleapis/google-cloud-java/issues/8337)) ([c9bb4a9](https://github.com/googleapis/google-cloud-java/commit/c9bb4a97aa19032b78c86c951fe9920f24ac4eec))
* revert reverting [Many APIs] Update WORKSPACE files for rules_gapic, gax_java, generator_java versions ([#8340](https://github.com/googleapis/google-cloud-java/issues/8340)) ([dedef71](https://github.com/googleapis/google-cloud-java/commit/dedef71f600e85b1c38e7110f5ffd44bf2ba32b4))


### Dependencies

* reverting renovate bot pull requests ([#8417](https://github.com/googleapis/google-cloud-java/issues/8417)) ([8f0c60b](https://github.com/googleapis/google-cloud-java/commit/8f0c60bde446acccc665eb7894723632eefc3503))

## [1.12.1](https://github.com/googleapis/java-compute/compare/v1.12.0...v1.12.1) (2022-09-15)


### Bug Fixes

* **java:** Exclude unused dependencies from gax-grpc ([#721](https://github.com/googleapis/java-compute/issues/721)) ([4da7a1f](https://github.com/googleapis/java-compute/commit/4da7a1f10bb37ff923a20c23f2e7d123e199b10c))


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.2 ([#724](https://github.com/googleapis/java-compute/issues/724)) ([2b41e83](https://github.com/googleapis/java-compute/commit/2b41e8393293b9be22bad1dae87e3a4b0ea9bbf7))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.3 ([#727](https://github.com/googleapis/java-compute/issues/727)) ([63bfcce](https://github.com/googleapis/java-compute/commit/63bfcce4c520c4886fbd263d53245e3e8553a253))

## [1.12.0](https://github.com/googleapis/java-compute/compare/v1.11.0...v1.12.0) (2022-08-05)


### Features

* Update Compute Engine API to revision 20220720 ([#723](https://github.com/googleapis/java-compute/issues/723)) ([#713](https://github.com/googleapis/java-compute/issues/713)) ([cd2a10a](https://github.com/googleapis/java-compute/commit/cd2a10a655b6eae29dc5a11e321b933450c2e9a9))


### Bug Fixes

* enable longpaths support for windows test ([#1485](https://github.com/googleapis/java-compute/issues/1485)) ([#706](https://github.com/googleapis/java-compute/issues/706)) ([c943699](https://github.com/googleapis/java-compute/commit/c94369944f612a4d39162c933ce4f5b678d7274c))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v3 ([#711](https://github.com/googleapis/java-compute/issues/711)) ([63c37c7](https://github.com/googleapis/java-compute/commit/63c37c7aad5e254b2ca7c654fe4f8587c2e7e84f))

## [1.11.0](https://github.com/googleapis/java-compute/compare/v1.10.0...v1.11.0) (2022-06-30)


### Features

* Update Compute Engine API to revision 20220526 ([#722](https://github.com/googleapis/java-compute/issues/722)) ([12389d0](https://github.com/googleapis/java-compute/commit/12389d0f9b0ba66954e25ab5454d2c1581aa21db))


### Bug Fixes

* **compute:** remove proto3_optional from parent_id ([#712](https://github.com/googleapis/java-compute/issues/712)) ([12389d0](https://github.com/googleapis/java-compute/commit/12389d0f9b0ba66954e25ab5454d2c1581aa21db))
* **compute:** replace missing REQUIRED for parent_id ([#711](https://github.com/googleapis/java-compute/issues/711)) ([12389d0](https://github.com/googleapis/java-compute/commit/12389d0f9b0ba66954e25ab5454d2c1581aa21db))
* **compute:** revert proto3_optional, required removal on parent_id ([#714](https://github.com/googleapis/java-compute/issues/714)) ([12389d0](https://github.com/googleapis/java-compute/commit/12389d0f9b0ba66954e25ab5454d2c1581aa21db))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.13.0 ([#697](https://github.com/googleapis/java-compute/issues/697)) ([a35c03b](https://github.com/googleapis/java-compute/commit/a35c03ba110f922161914419b4fbbe1d590cf697))

## [1.10.0](https://github.com/googleapis/java-compute/compare/v1.9.1...v1.10.0) (2022-05-24)


### Features

* add build scripts for native image testing in Java 17 ([#1440](https://github.com/googleapis/java-compute/issues/1440)) ([#691](https://github.com/googleapis/java-compute/issues/691)) ([6e1de08](https://github.com/googleapis/java-compute/commit/6e1de08694caa3ad45c5a41ed5e09ec87a837c95))


### Bug Fixes

* Add gax-grpc dependency for native image configurations ([#688](https://github.com/googleapis/java-compute/issues/688)) ([c4fc952](https://github.com/googleapis/java-compute/commit/c4fc952177a197ab7550163a482c244f2266298d))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.12.0 ([#690](https://github.com/googleapis/java-compute/issues/690)) ([c1e7193](https://github.com/googleapis/java-compute/commit/c1e7193a8771899ee0db397f7dd72002bcbd23a1))

### [1.9.1](https://github.com/googleapis/java-compute/compare/v1.9.0...v1.9.1) (2022-04-15)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.10.0 ([#674](https://github.com/googleapis/java-compute/issues/674)) ([8f0fc09](https://github.com/googleapis/java-compute/commit/8f0fc09eda4370bde0c7f3035e3eef4e697fedaf))

## [1.9.0](https://github.com/googleapis/java-compute/compare/v1.8.1...v1.9.0) (2022-04-11)


### Features

* update compute API to revision 20220322 ([#710](https://github.com/googleapis/java-compute/issues/710)) ([#669](https://github.com/googleapis/java-compute/issues/669)) ([b6daf94](https://github.com/googleapis/java-compute/commit/b6daf94c257912d2460407998f2a9ed43fc44491))

### [1.8.1](https://github.com/googleapis/java-compute/compare/v1.8.0...v1.8.1) (2022-03-29)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.9.0 ([#664](https://github.com/googleapis/java-compute/issues/664)) ([51bed73](https://github.com/googleapis/java-compute/commit/51bed736252c2a44270b1bff56967df3ff65e796))

## [1.8.0](https://github.com/googleapis/java-compute/compare/v1.7.2...v1.8.0) (2022-03-03)


### Features

* update compute API to revision 20220112 ([#641](https://github.com/googleapis/java-compute/issues/641)) ([5345e39](https://github.com/googleapis/java-compute/commit/5345e390185f6bf7338c1ed4425e5fffa3f73b8a))


### Dependencies

* update actions/setup-java action to v3 ([#653](https://github.com/googleapis/java-compute/issues/653)) ([83d6dfd](https://github.com/googleapis/java-compute/commit/83d6dfdc8e125450e4fd554be1218dca527d520b))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.8.0 ([#657](https://github.com/googleapis/java-compute/issues/657)) ([d897b43](https://github.com/googleapis/java-compute/commit/d897b439fa7428a2c247334629ff4955fc57d784))

### [1.7.2](https://github.com/googleapis/java-compute/compare/v1.7.1...v1.7.2) (2022-02-11)


### Dependencies

* update actions/github-script action to v6 ([#643](https://github.com/googleapis/java-compute/issues/643)) ([82ed9e7](https://github.com/googleapis/java-compute/commit/82ed9e75a1bc15404c2cd8d5d9bcfc360364a57d))

### [1.7.1](https://github.com/googleapis/java-compute/compare/v1.7.0...v1.7.1) (2022-02-04)


### Dependencies

* **java:** update actions/github-script action to v5 ([#1339](https://github.com/googleapis/java-compute/issues/1339)) ([#625](https://github.com/googleapis/java-compute/issues/625)) ([d8f5f3d](https://github.com/googleapis/java-compute/commit/d8f5f3d7aea4f5b6d786058b895b7b010a37f043))
* update actions/github-script action to v5 ([#624](https://github.com/googleapis/java-compute/issues/624)) ([39ca3be](https://github.com/googleapis/java-compute/commit/39ca3be0e4a5e9a5a951da0188b294cb437990bc))
* update dependency com.google.api.grpc:proto-google-cloud-compute-v1 to v1.7.0 ([#617](https://github.com/googleapis/java-compute/issues/617)) ([b44e0b1](https://github.com/googleapis/java-compute/commit/b44e0b12667abd07dcaac9a39f7925d57cea1b96))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.7.0 ([#626](https://github.com/googleapis/java-compute/issues/626)) ([660ca0f](https://github.com/googleapis/java-compute/commit/660ca0fa1966c939d359a3e17b32bb8e95b39cbd))

## [1.7.0](https://github.com/googleapis/java-compute/compare/v1.6.1...v1.7.0) (2022-01-11)


### Features

* promote to GA ([#613](https://github.com/googleapis/java-compute/issues/613)) ([70c0534](https://github.com/googleapis/java-compute/commit/70c05347beff2d11491e606bb88340771821ca55))

### [1.6.1](https://www.github.com/googleapis/java-compute/compare/v1.6.0...v1.6.1) (2022-01-07)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.6.0 ([#600](https://www.github.com/googleapis/java-compute/issues/600)) ([254fded](https://www.github.com/googleapis/java-compute/commit/254fded80cc28e18ff4a05fb0741c8f372c5e5f7))

## [1.6.0](https://www.github.com/googleapis/java-compute/compare/v1.5.0...v1.6.0) (2021-12-07)


### Features

* Introduce automatic LRO polling, integrate latest compute API definitions ([#583](https://www.github.com/googleapis/java-compute/issues/583)) ([90f7b41](https://www.github.com/googleapis/java-compute/commit/90f7b41dfc91a45981786a2eeed2f21bf82febeb))
* Introduce automatic LRO polling; all LRO methods now return `OperationFuture<>` instead of `Operation` and poling is done automatically; calling `cancel()` on the future will cancel polling but not the operation itself on the server side. ([90f7b41](https://www.github.com/googleapis/java-compute/commit/90f7b41dfc91a45981786a2eeed2f21bf82febeb))


### Bug Fixes

* **java:** java 17 dependency arguments ([#571](https://www.github.com/googleapis/java-compute/issues/571)) ([b280ec0](https://www.github.com/googleapis/java-compute/commit/b280ec0781b13ae479c21202bfbc4c7c90d5868f))
* rename `IPProtocol` to `IPProtocolEnum` ([90f7b41](https://www.github.com/googleapis/java-compute/commit/90f7b41dfc91a45981786a2eeed2f21bf82febeb))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.5.0 ([#579](https://www.github.com/googleapis/java-compute/issues/579)) ([54bbe3a](https://www.github.com/googleapis/java-compute/commit/54bbe3a5c5e3c2d86fa6cde9182fae2349641f2e))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.5.1 ([#586](https://www.github.com/googleapis/java-compute/issues/586)) ([100e21f](https://www.github.com/googleapis/java-compute/commit/100e21ffedc6b4a92b668985b09e1aa9afd5f3c8))

## [1.5.0](https://www.github.com/googleapis/java-compute/compare/v1.4.4...v1.5.0) (2021-10-21)


### Features

* Introduce Native Image testing build script changes ([#565](https://www.github.com/googleapis/java-compute/issues/565)) ([5a64dbe](https://www.github.com/googleapis/java-compute/commit/5a64dbecf89748ceee879ac6681fbfec373ea384))
* Populate compute proto with extended_operations annotations ([#563](https://www.github.com/googleapis/java-compute/issues/563)) ([9311680](https://www.github.com/googleapis/java-compute/commit/93116806dad1cff882354c16f70fb0fb810801b0))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.4.0 ([#566](https://www.github.com/googleapis/java-compute/issues/566)) ([e221882](https://www.github.com/googleapis/java-compute/commit/e2218823e6f74bfbfbb2a78f7431fa14020c7e4c))

### [1.4.4](https://www.github.com/googleapis/java-compute/compare/v1.4.3...v1.4.4) (2021-09-22)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.3.0 ([#545](https://www.github.com/googleapis/java-compute/issues/545)) ([a5c38d2](https://www.github.com/googleapis/java-compute/commit/a5c38d258180331d668458f36abedde2da55b057))

### [1.4.3](https://www.github.com/googleapis/java-compute/compare/v1.4.2...v1.4.3) (2021-09-14)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.2.1 ([#539](https://www.github.com/googleapis/java-compute/issues/539)) ([3a1cb72](https://www.github.com/googleapis/java-compute/commit/3a1cb727712851ce1ca1025795a3cbe52b681dc0))

### [1.4.2](https://www.github.com/googleapis/java-compute/compare/v1.4.1...v1.4.2) (2021-08-31)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.2.0 ([#523](https://www.github.com/googleapis/java-compute/issues/523)) ([24066f5](https://www.github.com/googleapis/java-compute/commit/24066f51c51ce4634880f0db7b3291dbc2ab07cf))

### [1.4.1](https://www.github.com/googleapis/java-compute/compare/v1.4.0...v1.4.1) (2021-08-23)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.1.0 ([#515](https://www.github.com/googleapis/java-compute/issues/515)) ([12c6bc9](https://www.github.com/googleapis/java-compute/commit/12c6bc9a890959c29f4545b7b784b940d6d2f28f))

## [1.4.0](https://www.github.com/googleapis/java-compute/compare/v1.3.0...v1.4.0) (2021-08-11)

### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2 ([#503](https://www.github.com/googleapis/java-compute/issues/503)) ([e5f6245](https://www.github.com/googleapis/java-compute/commit/e5f6245d85a14ff60d6959d9691ba0cd8f96be12))
