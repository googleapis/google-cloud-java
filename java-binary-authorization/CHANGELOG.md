# Changelog

## [1.3.0](https://github.com/googleapis/google-cloud-java/compare/google-cloud-binary-authorization-v1.2.8...google-cloud-binary-authorization-v1.3.0) (2022-10-12)


### Features

* [analyticsdata] add `subject_to_thresholding` field to `ResponseMetadata` type ([#8545](https://github.com/googleapis/google-cloud-java/issues/8545)) ([8fdc6c1](https://github.com/googleapis/google-cloud-java/commit/8fdc6c1f10f88f30f4d1407579d645f75366b4cf))
* add `tokens_per_project_per_hour` field to `PropertyQuota` type ([8fdc6c1](https://github.com/googleapis/google-cloud-java/commit/8fdc6c1f10f88f30f4d1407579d645f75366b4cf))


### Bug Fixes

* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.2 ([#8325](https://github.com/googleapis/google-cloud-java/issues/8325)) ([01f492b](https://github.com/googleapis/google-cloud-java/commit/01f492be424acdb90edb23ba66656aeff7cf39eb))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.4 ([#8528](https://github.com/googleapis/google-cloud-java/issues/8528)) ([bd36199](https://github.com/googleapis/google-cloud-java/commit/bd361998ac4eb7c78eef3b3eac39aef31a0cf44e))
* owl-bot-staging should not be commited ([#8337](https://github.com/googleapis/google-cloud-java/issues/8337)) ([c9bb4a9](https://github.com/googleapis/google-cloud-java/commit/c9bb4a97aa19032b78c86c951fe9920f24ac4eec))
* revert reverting [Many APIs] Update WORKSPACE files for rules_gapic, gax_java, generator_java versions ([#8340](https://github.com/googleapis/google-cloud-java/issues/8340)) ([dedef71](https://github.com/googleapis/google-cloud-java/commit/dedef71f600e85b1c38e7110f5ffd44bf2ba32b4))


### Dependencies

* reverting renovate bot pull requests ([#8417](https://github.com/googleapis/google-cloud-java/issues/8417)) ([8f0c60b](https://github.com/googleapis/google-cloud-java/commit/8f0c60bde446acccc665eb7894723632eefc3503))

## [1.2.7](https://github.com/googleapis/java-binary-authorization/compare/v1.2.6...v1.2.7) (2022-09-20)


### Dependencies

* Update dependency io.grafeas:grafeas to v2.4.5 ([#269](https://github.com/googleapis/java-binary-authorization/issues/269)) ([8a9a66d](https://github.com/googleapis/java-binary-authorization/commit/8a9a66dcc9fd417fcaaa3d06c432a6e4a2f50347))

## [1.2.6](https://github.com/googleapis/java-binary-authorization/compare/v1.2.5...v1.2.6) (2022-09-15)


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.3 ([#266](https://github.com/googleapis/java-binary-authorization/issues/266)) ([0ab7733](https://github.com/googleapis/java-binary-authorization/commit/0ab77337543942c8bdd5e9ae554790ca826931a8))

## [1.2.5](https://github.com/googleapis/java-binary-authorization/compare/v1.2.4...v1.2.5) (2022-09-10)


### Dependencies

* Update dependency io.grafeas:grafeas to v2.4.4 ([#261](https://github.com/googleapis/java-binary-authorization/issues/261)) ([398de26](https://github.com/googleapis/java-binary-authorization/commit/398de26209ee8d1caad5fc949a76f97a94dfd88a))

## [1.2.4](https://github.com/googleapis/java-binary-authorization/compare/v1.2.3...v1.2.4) (2022-09-09)


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.2 ([#258](https://github.com/googleapis/java-binary-authorization/issues/258)) ([4c82113](https://github.com/googleapis/java-binary-authorization/commit/4c821131fc5a8aed8f9e86231115c6f1d283b512))

## [1.2.3](https://github.com/googleapis/java-binary-authorization/compare/v1.2.2...v1.2.3) (2022-08-11)


### Bug Fixes

* grafeas is runtime scope ([#251](https://github.com/googleapis/java-binary-authorization/issues/251)) ([f76e876](https://github.com/googleapis/java-binary-authorization/commit/f76e876facc17319638bbc4b87f19941a5acc707))

## [1.2.2](https://github.com/googleapis/java-binary-authorization/compare/v1.2.1...v1.2.2) (2022-08-04)


### Bug Fixes

* enable longpaths support for windows test ([#1485](https://github.com/googleapis/java-binary-authorization/issues/1485)) ([#242](https://github.com/googleapis/java-binary-authorization/issues/242)) ([8a01271](https://github.com/googleapis/java-binary-authorization/commit/8a01271a54b1160e22cfae302debe2e441cd6485))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v3 ([#247](https://github.com/googleapis/java-binary-authorization/issues/247)) ([3e9ea1f](https://github.com/googleapis/java-binary-authorization/commit/3e9ea1fb7924148601cef4788cfe7d36543939b3))

## [1.2.1](https://github.com/googleapis/java-binary-authorization/compare/v1.2.0...v1.2.1) (2022-07-11)


### Dependencies

* update dependency io.grafeas:grafeas to v2.4.0 ([#238](https://github.com/googleapis/java-binary-authorization/issues/238)) ([1854de1](https://github.com/googleapis/java-binary-authorization/commit/1854de1c74be723deab967e15708de1b20aaaa94))

## [1.2.0](https://github.com/googleapis/java-binary-authorization/compare/v1.1.1...v1.2.0) (2022-07-01)


### Features

* Adds a pod_namespace field to pod events created by Continuous Validation, to distinguish pods with the same name that run in different namespaces ([#227](https://github.com/googleapis/java-binary-authorization/issues/227)) ([4755125](https://github.com/googleapis/java-binary-authorization/commit/4755125936bcf5931ea01e01e9fc6af3a7c1c309))
* Enable REST transport for most of Java and Go clients ([#230](https://github.com/googleapis/java-binary-authorization/issues/230)) ([ca507e6](https://github.com/googleapis/java-binary-authorization/commit/ca507e6aca8a35467d95038d7554c0c5f357315a))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.13.0 ([#229](https://github.com/googleapis/java-binary-authorization/issues/229)) ([c5d1f10](https://github.com/googleapis/java-binary-authorization/commit/c5d1f103196a5d538e115d48f3873901fa0a065a))
* update dependency io.grafeas:grafeas to v2.3.1 ([#231](https://github.com/googleapis/java-binary-authorization/issues/231)) ([7374554](https://github.com/googleapis/java-binary-authorization/commit/73745540d6187af67f8fdd1029485a860c45d7a7))

### [1.1.1](https://github.com/googleapis/java-binary-authorization/compare/v1.1.0...v1.1.1) (2022-05-26)


### Dependencies

* update dependency io.grafeas:grafeas to v2.3.0 ([#217](https://github.com/googleapis/java-binary-authorization/issues/217)) ([901141f](https://github.com/googleapis/java-binary-authorization/commit/901141fe7bb7250a14b1f8fd76d66b2be2331d45))

## [1.1.0](https://github.com/googleapis/java-binary-authorization/compare/v1.0.9...v1.1.0) (2022-05-23)


### Features

* add build scripts for native image testing in Java 17 ([#1440](https://github.com/googleapis/java-binary-authorization/issues/1440)) ([#215](https://github.com/googleapis/java-binary-authorization/issues/215)) ([ba4ef80](https://github.com/googleapis/java-binary-authorization/commit/ba4ef80044ffcabba2d711ca2cb0e2c44ebbaded))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.12.0 ([#214](https://github.com/googleapis/java-binary-authorization/issues/214)) ([5d78ffc](https://github.com/googleapis/java-binary-authorization/commit/5d78ffc34c861786e73eb212f879065a6d7acf4a))

### [1.0.9](https://github.com/googleapis/java-binary-authorization/compare/v1.0.8...v1.0.9) (2022-04-18)


### Dependencies

* update dependency io.grafeas:grafeas to v2.2.4 ([#204](https://github.com/googleapis/java-binary-authorization/issues/204)) ([fc7b2e7](https://github.com/googleapis/java-binary-authorization/commit/fc7b2e780fe7f50ba308fa1dbdd7b664d82d595b))

### [1.0.8](https://github.com/googleapis/java-binary-authorization/compare/v1.0.7...v1.0.8) (2022-04-15)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.10.0 ([#201](https://github.com/googleapis/java-binary-authorization/issues/201)) ([16f72c6](https://github.com/googleapis/java-binary-authorization/commit/16f72c626da902a9bb37f6254361b8598bd78dc5))

### [1.0.7](https://github.com/googleapis/java-binary-authorization/compare/v1.0.6...v1.0.7) (2022-04-08)


### Dependencies

* update dependency io.grafeas:grafeas to v2.2.3 ([#195](https://github.com/googleapis/java-binary-authorization/issues/195)) ([f1e6d1d](https://github.com/googleapis/java-binary-authorization/commit/f1e6d1da541d3fe271cb7ee8a615a9570eb152d8))

### [1.0.6](https://github.com/googleapis/java-binary-authorization/compare/v1.0.5...v1.0.6) (2022-03-29)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.9.0 ([#191](https://github.com/googleapis/java-binary-authorization/issues/191)) ([ae597c5](https://github.com/googleapis/java-binary-authorization/commit/ae597c542da60fc292fe1d204ccef07ad23221f7))

### [1.0.5](https://github.com/googleapis/java-binary-authorization/compare/v1.0.4...v1.0.5) (2022-03-24)


### Dependencies

* update actions/checkout action to v3 ([#176](https://github.com/googleapis/java-binary-authorization/issues/176)) ([426f970](https://github.com/googleapis/java-binary-authorization/commit/426f9702ca98b4758ffe9c44f3fc4ca0f83ef92d))

### [1.0.4](https://github.com/googleapis/java-binary-authorization/compare/v1.0.3...v1.0.4) (2022-03-08)


### Dependencies

* update dependency io.grafeas:grafeas to v2.2.2 ([#183](https://github.com/googleapis/java-binary-authorization/issues/183)) ([6b442fa](https://github.com/googleapis/java-binary-authorization/commit/6b442faa0b0e565094885cce27dec91fa2c65633))

### [1.0.3](https://github.com/googleapis/java-binary-authorization/compare/v1.0.2...v1.0.3) (2022-03-02)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.8.0 ([#178](https://github.com/googleapis/java-binary-authorization/issues/178)) ([6bff3c1](https://github.com/googleapis/java-binary-authorization/commit/6bff3c1e1b62f5f3d9b8470a5db211086e414dfa))

### [1.0.2](https://github.com/googleapis/java-binary-authorization/compare/v1.0.1...v1.0.2) (2022-02-28)


### Dependencies

* update actions/setup-java action to v3 ([#171](https://github.com/googleapis/java-binary-authorization/issues/171)) ([c2b4c8e](https://github.com/googleapis/java-binary-authorization/commit/c2b4c8e1ae4dcca04f045b00fd005e4d27ab6b09))
* update dependency io.grafeas:grafeas to v2.2.1 ([#170](https://github.com/googleapis/java-binary-authorization/issues/170)) ([d4bce7e](https://github.com/googleapis/java-binary-authorization/commit/d4bce7eabf6f25a4d9fe044b1ffd1d2ed7b03434))

### [1.0.1](https://github.com/googleapis/java-binary-authorization/compare/v1.0.0...v1.0.1) (2022-02-11)


### Dependencies

* update actions/github-script action to v6 ([#163](https://github.com/googleapis/java-binary-authorization/issues/163)) ([ea8ee5c](https://github.com/googleapis/java-binary-authorization/commit/ea8ee5c3c26a1c2558c2d7d2d414a60686e39c8a))

## [1.0.0](https://github.com/googleapis/java-binary-authorization/compare/v0.4.1...v1.0.0) (2022-02-03)


### Features

* promote to GA ([#147](https://github.com/googleapis/java-binary-authorization/issues/147)) ([f64e755](https://github.com/googleapis/java-binary-authorization/commit/f64e75577b3cb30db219ee19134e7d02abf0ecc3))


### Dependencies

* **java:** update actions/github-script action to v5 ([#1339](https://github.com/googleapis/java-binary-authorization/issues/1339)) ([#151](https://github.com/googleapis/java-binary-authorization/issues/151)) ([6ef4a2c](https://github.com/googleapis/java-binary-authorization/commit/6ef4a2ca0a4673ae5b0788d28e45bafe6d361803))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.7.0 ([#154](https://github.com/googleapis/java-binary-authorization/issues/154)) ([010fea6](https://github.com/googleapis/java-binary-authorization/commit/010fea6e7fda31e4c9bc5642560340831337d3ae))
* update dependency io.grafeas:grafeas to v2.2.0 ([#138](https://github.com/googleapis/java-binary-authorization/issues/138)) ([1d0e567](https://github.com/googleapis/java-binary-authorization/commit/1d0e567bee55a6eff0daa831449e3f090a22981b))

### [0.4.1](https://www.github.com/googleapis/java-binary-authorization/compare/v0.4.0...v0.4.1) (2022-01-07)


### Bug Fixes

* **java:** run Maven in plain console-friendly mode ([#1301](https://www.github.com/googleapis/java-binary-authorization/issues/1301)) ([#131](https://www.github.com/googleapis/java-binary-authorization/issues/131)) ([0fd5b44](https://www.github.com/googleapis/java-binary-authorization/commit/0fd5b4439f807c37f56695c63b81693be8e5fbc1))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.6.0 ([#134](https://www.github.com/googleapis/java-binary-authorization/issues/134)) ([cc6736a](https://www.github.com/googleapis/java-binary-authorization/commit/cc6736a38ecbb1d0ec96b8a1f0b6ca828f9ed1c9))

## [0.4.0](https://www.github.com/googleapis/java-binary-authorization/compare/v0.3.3...v0.4.0) (2021-12-06)


### Features

* add new admission rule types to Policy feat: update SignatureAlgorithm enum to match algorithm names in KMS feat: add SystemPolicyV1Beta1 service ([#112](https://www.github.com/googleapis/java-binary-authorization/issues/112)) ([fceee93](https://www.github.com/googleapis/java-binary-authorization/commit/fceee93149a3576c32cbca171882910f05fd7e2d))
* binaryauthorization v1 public protos ([#90](https://www.github.com/googleapis/java-binary-authorization/issues/90)) ([f5315fc](https://www.github.com/googleapis/java-binary-authorization/commit/f5315fcb4761ac78e0b66945a8ee3b6d6f5e85eb))


### Bug Fixes

* **java:** add -ntp flag to native image testing command ([#1299](https://www.github.com/googleapis/java-binary-authorization/issues/1299)) ([#126](https://www.github.com/googleapis/java-binary-authorization/issues/126)) ([1fd688a](https://www.github.com/googleapis/java-binary-authorization/commit/1fd688a59ed534255191e4b8ab2753a4750e2e8c))
* **java:** java 17 dependency arguments ([#1266](https://www.github.com/googleapis/java-binary-authorization/issues/1266)) ([#107](https://www.github.com/googleapis/java-binary-authorization/issues/107)) ([47a899b](https://www.github.com/googleapis/java-binary-authorization/commit/47a899b73033fd800d7671bd6d9d7e5575831ab8))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.5.0 ([#118](https://www.github.com/googleapis/java-binary-authorization/issues/118)) ([6f13f2a](https://www.github.com/googleapis/java-binary-authorization/commit/6f13f2ac75045e07ce127a6423f69e9224b1721e))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.5.1 ([#124](https://www.github.com/googleapis/java-binary-authorization/issues/124)) ([c75a6ac](https://www.github.com/googleapis/java-binary-authorization/commit/c75a6ac8ac2393d630046e69a3626ce64301dac9))
* update dependency io.grafeas:grafeas to v2.1.0 ([#108](https://www.github.com/googleapis/java-binary-authorization/issues/108)) ([1853da6](https://www.github.com/googleapis/java-binary-authorization/commit/1853da6f67619f4f74db0948e82685f2147d18ae))
* update dependency io.grafeas:grafeas to v2.1.1 ([#109](https://www.github.com/googleapis/java-binary-authorization/issues/109)) ([1ebd94b](https://www.github.com/googleapis/java-binary-authorization/commit/1ebd94b6cbf7518f806db8fd8c846507173a4c8b))
* update dependency io.grafeas:grafeas to v2.1.2 ([#119](https://www.github.com/googleapis/java-binary-authorization/issues/119)) ([f38a45b](https://www.github.com/googleapis/java-binary-authorization/commit/f38a45bac205d85251c9c968d39dd0d4a10c0e57))
* update dependency io.grafeas:grafeas to v2.1.3 ([#125](https://www.github.com/googleapis/java-binary-authorization/issues/125)) ([1bc6eb9](https://www.github.com/googleapis/java-binary-authorization/commit/1bc6eb94978eae34a5e1a28a1d9067fad47596de))

### [0.3.3](https://www.github.com/googleapis/java-binary-authorization/compare/v0.3.2...v0.3.3) (2021-10-19)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.4.0 ([#101](https://www.github.com/googleapis/java-binary-authorization/issues/101)) ([3f592b5](https://www.github.com/googleapis/java-binary-authorization/commit/3f592b5bd92410c7afa40e166ea26012cad26648))

### [0.3.2](https://www.github.com/googleapis/java-binary-authorization/compare/v0.3.1...v0.3.2) (2021-09-22)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.3.0 ([#87](https://www.github.com/googleapis/java-binary-authorization/issues/87)) ([e801b46](https://www.github.com/googleapis/java-binary-authorization/commit/e801b46bc4862105f99ae95424fe393fb08e9a61))

### [0.3.1](https://www.github.com/googleapis/java-binary-authorization/compare/v0.3.0...v0.3.1) (2021-09-14)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.2.1 ([#80](https://www.github.com/googleapis/java-binary-authorization/issues/80)) ([9043edc](https://www.github.com/googleapis/java-binary-authorization/commit/9043edc5244823b6b6dacd38e5f346cdc963cf5d))

## [0.3.0](https://www.github.com/googleapis/java-binary-authorization/compare/v0.2.2...v0.3.0) (2021-09-10)


### Features

* Remove use of deprecated gradle command in java README ([#1196](https://www.github.com/googleapis/java-binary-authorization/issues/1196)) ([#65](https://www.github.com/googleapis/java-binary-authorization/issues/65)) ([8cb0da3](https://www.github.com/googleapis/java-binary-authorization/commit/8cb0da37f9c387a79c9255bca3402ec22643ded8))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.2.0 ([#69](https://www.github.com/googleapis/java-binary-authorization/issues/69)) ([4843a90](https://www.github.com/googleapis/java-binary-authorization/commit/4843a904a0e402ed6ae9677e940faec9f1d1f71e))

### [0.2.2](https://www.github.com/googleapis/java-binary-authorization/compare/v0.2.1...v0.2.2) (2021-08-23)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.1.0 ([#59](https://www.github.com/googleapis/java-binary-authorization/issues/59)) ([4a04949](https://www.github.com/googleapis/java-binary-authorization/commit/4a04949edb28e1db63b565d07b30d2308d2ad4f2))

### [0.2.1](https://www.github.com/googleapis/java-binary-authorization/compare/v0.2.0...v0.2.1) (2021-08-12)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.0.1 ([#53](https://www.github.com/googleapis/java-binary-authorization/issues/53)) ([dfdd993](https://www.github.com/googleapis/java-binary-authorization/commit/dfdd9932eee97318d4aa74b45106b83faedd323f))

## [0.2.0](https://www.github.com/googleapis/java-binary-authorization/compare/v0.1.1...v0.2.0) (2021-08-09)


### ⚠ BREAKING CHANGES

* release gapic-generator-java v2.0.0 (#47)

### Features

* release gapic-generator-java v2.0.0 ([#47](https://www.github.com/googleapis/java-binary-authorization/issues/47)) ([6e8fd4b](https://www.github.com/googleapis/java-binary-authorization/commit/6e8fd4b1fb93b8075af8c2536655e7d213c1622a))


### Bug Fixes

* Add `shopt -s nullglob` to dependencies script ([#1130](https://www.github.com/googleapis/java-binary-authorization/issues/1130)) ([#26](https://www.github.com/googleapis/java-binary-authorization/issues/26)) ([0b7ea96](https://www.github.com/googleapis/java-binary-authorization/commit/0b7ea968aedb1824a84e1a9abd35feae17ee3b3b))
* owlbot post-processor should generate README ([#1154](https://www.github.com/googleapis/java-binary-authorization/issues/1154)) ([#31](https://www.github.com/googleapis/java-binary-authorization/issues/31)) ([d40ffa2](https://www.github.com/googleapis/java-binary-authorization/commit/d40ffa289be02aa3e6bcfe9c50d688e2905addd1)), closes [#1146](https://www.github.com/googleapis/java-binary-authorization/issues/1146) [#1147](https://www.github.com/googleapis/java-binary-authorization/issues/1147)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.4.0 ([#28](https://www.github.com/googleapis/java-binary-authorization/issues/28)) ([4dda105](https://www.github.com/googleapis/java-binary-authorization/commit/4dda105fe56704810a5157afd17af47aadb4e67e))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2 ([#48](https://www.github.com/googleapis/java-binary-authorization/issues/48)) ([c069652](https://www.github.com/googleapis/java-binary-authorization/commit/c06965200207f3784ff1517c8e5da7275649d254))


### Documentation

* Replace "global policy" with "system policy" in Binary Authorization documentation ([#45](https://www.github.com/googleapis/java-binary-authorization/issues/45)) ([7ee7f88](https://www.github.com/googleapis/java-binary-authorization/commit/7ee7f88b06bd51c018f7e43b28b415b069d92ccd))

### [0.1.1](https://www.github.com/googleapis/java-binary-authorization/compare/v0.1.0...v0.1.1) (2021-06-09)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.3.0 ([#16](https://www.github.com/googleapis/java-binary-authorization/issues/16)) ([5221465](https://www.github.com/googleapis/java-binary-authorization/commit/522146545b9f56a65a87a282f7bb057c626a6b47))

## 0.1.0 (2021-06-03)


### Features

* initial generation ([24afde1](https://www.github.com/googleapis/java-binary-authorization/commit/24afde139af21fbe16d6b8ebe949ab3b3dfd66d5))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.21.1 ([#8](https://www.github.com/googleapis/java-binary-authorization/issues/8)) ([b041dc9](https://www.github.com/googleapis/java-binary-authorization/commit/b041dc9dec1919fabb3110a6480543f6dbf3c0b6))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1 ([#10](https://www.github.com/googleapis/java-binary-authorization/issues/10)) ([4ae303c](https://www.github.com/googleapis/java-binary-authorization/commit/4ae303c0e43747dc6dcc2619b82b7889d8dd9028))
