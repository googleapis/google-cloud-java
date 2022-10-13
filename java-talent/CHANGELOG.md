# Changelog

## [2.4.6](https://github.com/googleapis/java-talent/compare/v2.4.5...v2.4.6) (2022-10-05)


### Bug Fixes

* update protobuf to v3.21.7 ([63dbf29](https://github.com/googleapis/java-talent/commit/63dbf29c2333b44f9d29b065f8888f081efd4e80))

## [2.4.5](https://github.com/googleapis/java-talent/compare/v2.4.4...v2.4.5) (2022-10-03)


### Dependencies

* Update dependency certifi to v2022.9.24 ([#841](https://github.com/googleapis/java-talent/issues/841)) ([18e85c4](https://github.com/googleapis/java-talent/commit/18e85c4bb512ae0e1f56a84c63ff93556cb847bc))
* Update dependency charset-normalizer to v2.1.1 ([#845](https://github.com/googleapis/java-talent/issues/845)) ([978e0ed](https://github.com/googleapis/java-talent/commit/978e0ed48fcebc258bcefd1d2968cc45836863f7))
* Update dependency click to v8.1.3 ([#846](https://github.com/googleapis/java-talent/issues/846)) ([b6faeaa](https://github.com/googleapis/java-talent/commit/b6faeaa9832d025c0e19649e3bdc29757e3d1db8))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.4 ([#866](https://github.com/googleapis/java-talent/issues/866)) ([b6c1fa1](https://github.com/googleapis/java-talent/commit/b6c1fa1b6c39b2df297ac047bb2ec6e1d752d579))
* Update dependency gcp-releasetool to v1.8.8 ([#842](https://github.com/googleapis/java-talent/issues/842)) ([a99dade](https://github.com/googleapis/java-talent/commit/a99dade46b1148d6349b8fa12b9ecda9241d18c9))
* Update dependency google-api-core to v2.10.1 ([#847](https://github.com/googleapis/java-talent/issues/847)) ([8b5cd96](https://github.com/googleapis/java-talent/commit/8b5cd965a57aab0484fb06dc529eedc4a5108ed5))
* Update dependency google-auth to v2.12.0 ([#848](https://github.com/googleapis/java-talent/issues/848)) ([6b753c6](https://github.com/googleapis/java-talent/commit/6b753c6caf2acd9715e556b613c5ae9088506aa3))
* Update dependency google-cloud-core to v2.3.2 ([#843](https://github.com/googleapis/java-talent/issues/843)) ([f41762f](https://github.com/googleapis/java-talent/commit/f41762f4980ef6239c0be1358cad3624c6b100b6))
* Update dependency google-cloud-storage to v2.5.0 ([#849](https://github.com/googleapis/java-talent/issues/849)) ([6c5a1f6](https://github.com/googleapis/java-talent/commit/6c5a1f6373edf58b9e693ef00084fe89db0c6cdf))
* Update dependency googleapis-common-protos to v1.56.4 ([#844](https://github.com/googleapis/java-talent/issues/844)) ([180d97b](https://github.com/googleapis/java-talent/commit/180d97b04f551abec43dfa39f0f2a510bbe46fe8))
* Update dependency importlib-metadata to v4.12.0 ([#851](https://github.com/googleapis/java-talent/issues/851)) ([62289d0](https://github.com/googleapis/java-talent/commit/62289d0b2ae13c022bec124053ad9ce553d2e034))
* Update dependency jeepney to v0.8.0 ([#852](https://github.com/googleapis/java-talent/issues/852)) ([bfcd7c3](https://github.com/googleapis/java-talent/commit/bfcd7c3537596b58e78439a516073bb3a9dfa164))

## [2.4.4](https://github.com/googleapis/java-talent/compare/v2.4.3...v2.4.4) (2022-09-15)


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.3 ([#833](https://github.com/googleapis/java-talent/issues/833)) ([0cb0031](https://github.com/googleapis/java-talent/commit/0cb0031d8d9f92e1273637dca714e81fce03b405))

## [2.4.3](https://github.com/googleapis/java-talent/compare/v2.4.2...v2.4.3) (2022-09-09)


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.2 ([#827](https://github.com/googleapis/java-talent/issues/827)) ([21871bb](https://github.com/googleapis/java-talent/commit/21871bb611ba1329ec4d61024858219b9336566c))

## [2.4.2](https://github.com/googleapis/java-talent/compare/v2.4.1...v2.4.2) (2022-08-09)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v3 ([#816](https://github.com/googleapis/java-talent/issues/816)) ([49f244d](https://github.com/googleapis/java-talent/commit/49f244dbd3beacc2877b62076b2ec50cc86acb8d))

## [2.4.1](https://github.com/googleapis/java-talent/compare/v2.4.0...v2.4.1) (2022-07-13)


### Bug Fixes

* enable longpaths support for windows test ([#1485](https://github.com/googleapis/java-talent/issues/1485)) ([#809](https://github.com/googleapis/java-talent/issues/809)) ([e10def1](https://github.com/googleapis/java-talent/commit/e10def1784434cae08d2c4cc7b3799bee2c08cd7))

## [2.4.0](https://github.com/googleapis/java-talent/compare/v2.3.0...v2.4.0) (2022-07-01)


### Features

* Add a new operator on companyDisplayNames filter to further support fuzzy match by treating input value as a multi word token ([#788](https://github.com/googleapis/java-talent/issues/788)) ([872f37c](https://github.com/googleapis/java-talent/commit/872f37c10396cad1f1a7e999043154b8b3d00bf7))
* Add a new option TELECOMMUTE_JOBS_EXCLUDED under enum TelecommutePreference to completely filter out the telecommute jobs in response ([872f37c](https://github.com/googleapis/java-talent/commit/872f37c10396cad1f1a7e999043154b8b3d00bf7))


### Bug Fixes

* update gapic-generator-java with mock service generation fixes ([#794](https://github.com/googleapis/java-talent/issues/794)) ([a631d74](https://github.com/googleapis/java-talent/commit/a631d74d650f2259a1d937db3e0b7b3a2db4d5d3))


### Documentation

* Deprecate option TELECOMMUTE_EXCLUDED under enum TelecommutePreference ([872f37c](https://github.com/googleapis/java-talent/commit/872f37c10396cad1f1a7e999043154b8b3d00bf7))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.13.0 ([#797](https://github.com/googleapis/java-talent/issues/797)) ([e08cf8b](https://github.com/googleapis/java-talent/commit/e08cf8b6f01c77522f052938e2c6b93cb251e4f9))

## [2.3.0](https://github.com/googleapis/java-talent/compare/v2.2.10...v2.3.0) (2022-05-19)


### Features

* add build scripts for native image testing in Java 17 ([#1440](https://github.com/googleapis/java-talent/issues/1440)) ([#786](https://github.com/googleapis/java-talent/issues/786)) ([07f9035](https://github.com/googleapis/java-talent/commit/07f90359dd0391bd36f0f6bc795f3511b3070fcb))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.12.0 ([#785](https://github.com/googleapis/java-talent/issues/785)) ([e59604c](https://github.com/googleapis/java-talent/commit/e59604ce843b1b0553a3b436e0f875719963dfae))

### [2.2.10](https://github.com/googleapis/java-talent/compare/v2.2.9...v2.2.10) (2022-04-15)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.10.0 ([#770](https://github.com/googleapis/java-talent/issues/770)) ([11f143b](https://github.com/googleapis/java-talent/commit/11f143b63b7a0895fa344163833a8eb1b8fd5676))

### [2.2.9](https://github.com/googleapis/java-talent/compare/v2.2.8...v2.2.9) (2022-03-29)


### Documentation

* Added functionality in the companyDisplayNames filter to support fuzzy matching ([#760](https://github.com/googleapis/java-talent/issues/760)) ([3002a5e](https://github.com/googleapis/java-talent/commit/3002a5e7b24f9965462b9bd4d23a320713de541f))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.9.0 ([#764](https://github.com/googleapis/java-talent/issues/764)) ([fa1cc3c](https://github.com/googleapis/java-talent/commit/fa1cc3c9c9198bc66ef7b124f8ab361bb83de88c))

### [2.2.8](https://github.com/googleapis/java-talent/compare/v2.2.7...v2.2.8) (2022-03-02)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.8.0 ([#750](https://github.com/googleapis/java-talent/issues/750)) ([4bdac1b](https://github.com/googleapis/java-talent/commit/4bdac1b99d413569c60c86e38c4979cb2f454f78))

### [2.2.7](https://github.com/googleapis/java-talent/compare/v2.2.6...v2.2.7) (2022-02-28)


### Dependencies

* update actions/setup-java action to v3 ([#741](https://github.com/googleapis/java-talent/issues/741)) ([cfb4349](https://github.com/googleapis/java-talent/commit/cfb4349b1f3115dec23057edee753ee10d63592a))

### [2.2.6](https://github.com/googleapis/java-talent/compare/v2.2.5...v2.2.6) (2022-02-11)


### Dependencies

* update actions/github-script action to v6 ([#729](https://github.com/googleapis/java-talent/issues/729)) ([cedbfcc](https://github.com/googleapis/java-talent/commit/cedbfcc60ce090c18c64b6ded868922b16699dc8))

### [2.2.5](https://github.com/googleapis/java-talent/compare/v2.2.4...v2.2.5) (2022-02-03)


### Dependencies

* **java:** update actions/github-script action to v5 ([#1339](https://github.com/googleapis/java-talent/issues/1339)) ([#715](https://github.com/googleapis/java-talent/issues/715)) ([0bef5f3](https://github.com/googleapis/java-talent/commit/0bef5f3c648c7618b3c2161ad98221c251689521))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.7.0 ([#717](https://github.com/googleapis/java-talent/issues/717)) ([ba20fd8](https://github.com/googleapis/java-talent/commit/ba20fd896da7ac6e4dfac136110d289327961276))

### [2.2.4](https://www.github.com/googleapis/java-talent/compare/v2.2.3...v2.2.4) (2022-01-07)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.6.0 ([#701](https://www.github.com/googleapis/java-talent/issues/701)) ([90892a1](https://www.github.com/googleapis/java-talent/commit/90892a1d78d0d2346310fba7b862a130d7d864d2))

### [2.2.3](https://www.github.com/googleapis/java-talent/compare/v2.2.2...v2.2.3) (2021-12-03)


### Bug Fixes

* **java:** java 17 dependency arguments ([#1266](https://www.github.com/googleapis/java-talent/issues/1266)) ([#662](https://www.github.com/googleapis/java-talent/issues/662)) ([b63808d](https://www.github.com/googleapis/java-talent/commit/b63808d1e1353627b2c3d75fca3c1db3653739d2))
* **samples:** Move to java-docs-samples-testing ([#673](https://www.github.com/googleapis/java-talent/issues/673)) ([1bfd919](https://www.github.com/googleapis/java-talent/commit/1bfd9198381a4aa25725ea0499bf6ed79f9c8688))


### Documentation

* fix docstring formatting ([#665](https://www.github.com/googleapis/java-talent/issues/665)) ([08f322f](https://www.github.com/googleapis/java-talent/commit/08f322f6523e6e1849f16af1e9e9d505dbac129c))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.5.0 ([#674](https://www.github.com/googleapis/java-talent/issues/674)) ([cf1ecf0](https://www.github.com/googleapis/java-talent/commit/cf1ecf0a3d2039bb30c46ae89de58f3b53d51feb))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.5.1 ([#681](https://www.github.com/googleapis/java-talent/issues/681)) ([c5971ba](https://www.github.com/googleapis/java-talent/commit/c5971ba538a4356177709757b473e74d801249f0))

### [2.2.2](https://www.github.com/googleapis/java-talent/compare/v2.2.1...v2.2.2) (2021-10-20)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.4.0 ([#655](https://www.github.com/googleapis/java-talent/issues/655)) ([6d79b68](https://www.github.com/googleapis/java-talent/commit/6d79b683f620bf58f8fe4043c91b7b046c2ef1c7))

### [2.2.1](https://www.github.com/googleapis/java-talent/compare/v2.2.0...v2.2.1) (2021-09-22)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.3.0 ([#623](https://www.github.com/googleapis/java-talent/issues/623)) ([df3676b](https://www.github.com/googleapis/java-talent/commit/df3676bf6b5d143387de5d6fad0edcfc48d0ec08))

## [2.2.0](https://www.github.com/googleapis/java-talent/compare/v2.1.2...v2.2.0) (2021-09-20)


### Features

* Added a new `KeywordMatchMode` field to support more keyword matching options ([#616](https://www.github.com/googleapis/java-talent/issues/616)) ([0265721](https://www.github.com/googleapis/java-talent/commit/02657217f52f459c39bf0d48a4afee1d637d23c8))

### [2.1.2](https://www.github.com/googleapis/java-talent/compare/v2.1.1...v2.1.2) (2021-09-14)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.2.1 ([#611](https://www.github.com/googleapis/java-talent/issues/611)) ([af71f67](https://www.github.com/googleapis/java-talent/commit/af71f675174fa8a0208a937a0940b9089ebba6fc))

### [2.1.1](https://www.github.com/googleapis/java-talent/compare/v2.1.0...v2.1.1) (2021-08-31)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.2.0 ([#598](https://www.github.com/googleapis/java-talent/issues/598)) ([354a3f0](https://www.github.com/googleapis/java-talent/commit/354a3f0823e954f7b838ef1c3bcae4cd48654cf9))

## [2.1.0](https://www.github.com/googleapis/java-talent/compare/v2.0.2...v2.1.0) (2021-08-25)


### Features

* Add new commute methods in Search APIs ([#581](https://www.github.com/googleapis/java-talent/issues/581)) ([d62a468](https://www.github.com/googleapis/java-talent/commit/d62a468d7c76a719285ed0d8ad0c084293ff402d))
* Add new histogram type 'publish_time_in_day' ([d62a468](https://www.github.com/googleapis/java-talent/commit/d62a468d7c76a719285ed0d8ad0c084293ff402d))
* Support filtering by requisitionId is ListJobs API ([d62a468](https://www.github.com/googleapis/java-talent/commit/d62a468d7c76a719285ed0d8ad0c084293ff402d))

### [2.0.2](https://www.github.com/googleapis/java-talent/compare/v2.0.1...v2.0.2) (2021-08-23)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.1.0 ([#584](https://www.github.com/googleapis/java-talent/issues/584)) ([adbf7ba](https://www.github.com/googleapis/java-talent/commit/adbf7bafbf9f77d83dd62e338c10e0f2728cc2e5))

### [2.0.1](https://www.github.com/googleapis/java-talent/compare/v2.0.0...v2.0.1) (2021-08-11)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.0.1 ([#574](https://www.github.com/googleapis/java-talent/issues/574)) ([d4bc8ba](https://www.github.com/googleapis/java-talent/commit/d4bc8bae5c87c32d5a8d13b1fedd5de1f1d36a9c))

## [2.0.0](https://www.github.com/googleapis/java-talent/compare/v1.2.2...v2.0.0) (2021-08-06)


### ⚠ BREAKING CHANGES

* release gapic-generator-java v2.0.0 (#567)

### Features

* release gapic-generator-java v2.0.0 ([#567](https://www.github.com/googleapis/java-talent/issues/567)) ([fc04ee9](https://www.github.com/googleapis/java-talent/commit/fc04ee9502a944b84f3c3c77f0f5581b695131d0))
* remove empty proto BatchProto.java ([#556](https://www.github.com/googleapis/java-talent/issues/556)) ([725d0f7](https://www.github.com/googleapis/java-talent/commit/725d0f7f77f39c212f61d8d1403bfd3bc3f4a1b6))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2 ([#568](https://www.github.com/googleapis/java-talent/issues/568)) ([45e91c7](https://www.github.com/googleapis/java-talent/commit/45e91c74f48a6334cd8e77359f978d3217303250))

### [1.2.2](https://www.github.com/googleapis/java-talent/compare/v1.2.1...v1.2.2) (2021-07-02)


### Bug Fixes

* Add `shopt -s nullglob` to dependencies script ([#539](https://www.github.com/googleapis/java-talent/issues/539)) ([5065856](https://www.github.com/googleapis/java-talent/commit/50658564fdd5707ba1acd4ae1651a6de8ea9bc26))
* Update dependencies.sh to not break on mac ([#535](https://www.github.com/googleapis/java-talent/issues/535)) ([c017880](https://www.github.com/googleapis/java-talent/commit/c01788067488284fed6c4d4fba2608a0b023fc71))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.4.0 ([#543](https://www.github.com/googleapis/java-talent/issues/543)) ([0c4d59a](https://www.github.com/googleapis/java-talent/commit/0c4d59a2f6fcb8659f0915068fa87d798ebcbb50))

### [1.2.1](https://www.github.com/googleapis/java-talent/compare/v1.2.0...v1.2.1) (2021-06-04)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.3.0 ([#526](https://www.github.com/googleapis/java-talent/issues/526)) ([984f5a6](https://www.github.com/googleapis/java-talent/commit/984f5a6c230c255ae27aedf1667587a01f176e5f))

## [1.2.0](https://www.github.com/googleapis/java-talent/compare/v1.1.3...v1.2.0) (2021-05-26)


### Features

* add `gcf-owl-bot[bot]` to `ignoreAuthors` ([#514](https://www.github.com/googleapis/java-talent/issues/514)) ([e35e0e7](https://www.github.com/googleapis/java-talent/commit/e35e0e7bcf6ecf2accf789668a833c88f1db7535))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.2.0 ([#513](https://www.github.com/googleapis/java-talent/issues/513)) ([3c9a807](https://www.github.com/googleapis/java-talent/commit/3c9a8072040dc508ca58cd574c62b2c27f0305d7))

### [1.1.3](https://www.github.com/googleapis/java-talent/compare/v1.1.2...v1.1.3) (2021-05-11)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.1.0 ([#502](https://www.github.com/googleapis/java-talent/issues/502)) ([b58c096](https://www.github.com/googleapis/java-talent/commit/b58c096947d8eabfa87698d09a579b21251c2033))

### [1.1.2](https://www.github.com/googleapis/java-talent/compare/v1.1.1...v1.1.2) (2021-04-23)


### Bug Fixes

* release scripts from issuing overlapping phases ([#465](https://www.github.com/googleapis/java-talent/issues/465)) ([7db2ed4](https://www.github.com/googleapis/java-talent/commit/7db2ed48ed1eefe8d6894ce93dbb37eec76d4c0d))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.21.1 ([#469](https://www.github.com/googleapis/java-talent/issues/469)) ([4b06052](https://www.github.com/googleapis/java-talent/commit/4b060527d56a3a5759412daaac51a1ae4ecaa2ff))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1 ([#490](https://www.github.com/googleapis/java-talent/issues/490)) ([0773346](https://www.github.com/googleapis/java-talent/commit/07733463f5fc7af891cd96ecccaa7cc1178dde31))

### [1.1.1](https://www.github.com/googleapis/java-talent/compare/v1.1.0...v1.1.1) (2021-04-09)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.21.0 ([#454](https://www.github.com/googleapis/java-talent/issues/454)) ([b0b3dc1](https://www.github.com/googleapis/java-talent/commit/b0b3dc13f17e82e3dde7468c3ef91f63e0de91b0))

## [1.1.0](https://www.github.com/googleapis/java-talent/compare/v1.0.8...v1.1.0) (2021-03-11)


### Features

* **generator:** update protoc to v3.15.3 ([#431](https://www.github.com/googleapis/java-talent/issues/431)) ([7185c41](https://www.github.com/googleapis/java-talent/commit/7185c411214ff5b9c590bac67c974212c4aab937))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.20.1 ([#441](https://www.github.com/googleapis/java-talent/issues/441)) ([fb2388d](https://www.github.com/googleapis/java-talent/commit/fb2388d86b9fdd20e66e40672c7efd9253ab3d3a))

### [1.0.8](https://www.github.com/googleapis/java-talent/compare/v1.0.7...v1.0.8) (2021-02-25)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.20.0 ([#426](https://www.github.com/googleapis/java-talent/issues/426)) ([03a5c19](https://www.github.com/googleapis/java-talent/commit/03a5c1913fc47f8f5b45c821316e5b7d9f264661))

### [1.0.7](https://www.github.com/googleapis/java-talent/compare/v1.0.6...v1.0.7) (2021-02-22)


### Documentation

* generate sample code in the Java microgenerator ([#409](https://www.github.com/googleapis/java-talent/issues/409)) ([09e4423](https://www.github.com/googleapis/java-talent/commit/09e44234121af299286afa597632c772fd66f8d0))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.19.0 ([#417](https://www.github.com/googleapis/java-talent/issues/417)) ([a6fbf2b](https://www.github.com/googleapis/java-talent/commit/a6fbf2bcc1550014a0e093231ce2030d18ddb35a))

### [1.0.6](https://www.github.com/googleapis/java-talent/compare/v1.0.5...v1.0.6) (2021-01-14)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.18.0 ([#385](https://www.github.com/googleapis/java-talent/issues/385)) ([a6e449f](https://www.github.com/googleapis/java-talent/commit/a6e449ff915f2f3f45e61e527eaa29af4b5ecacc))

### [1.0.5](https://www.github.com/googleapis/java-talent/compare/v1.0.4...v1.0.5) (2020-12-15)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.17.0 ([#371](https://www.github.com/googleapis/java-talent/issues/371)) ([fd0735b](https://www.github.com/googleapis/java-talent/commit/fd0735b0011b344b7e3e1d04ae6e592c1a763202))

### [1.0.4](https://www.github.com/googleapis/java-talent/compare/v1.0.3...v1.0.4) (2020-12-14)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.16.1 ([#366](https://www.github.com/googleapis/java-talent/issues/366)) ([f230282](https://www.github.com/googleapis/java-talent/commit/f2302823f796a3d8aac42d30175b68773e2440d2))

### [1.0.3](https://www.github.com/googleapis/java-talent/compare/v1.0.2...v1.0.3) (2020-12-02)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.16.0 ([#357](https://www.github.com/googleapis/java-talent/issues/357)) ([a40ff9a](https://www.github.com/googleapis/java-talent/commit/a40ff9acb4ed1340efe48e5afbd29bd34469e1ea))

### [1.0.2](https://www.github.com/googleapis/java-talent/compare/v1.0.1...v1.0.2) (2020-11-13)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.15.0 ([#332](https://www.github.com/googleapis/java-talent/issues/332)) ([3c80868](https://www.github.com/googleapis/java-talent/commit/3c8086802b5f13cbbcd7f58e3628de92c1e51f85))

### [1.0.1](https://www.github.com/googleapis/java-talent/compare/v1.0.0...v1.0.1) (2020-10-31)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.14.1 ([#318](https://www.github.com/googleapis/java-talent/issues/318)) ([8534678](https://www.github.com/googleapis/java-talent/commit/853467851a4050a946d27963e1332a27c7fd25d5))

## [1.0.0](https://www.github.com/googleapis/java-talent/compare/v0.39.4...v1.0.0) (2020-10-27)


### Features

* promote to 1.0.0 ([#308](https://www.github.com/googleapis/java-talent/issues/308)) ([736a31c](https://www.github.com/googleapis/java-talent/commit/736a31c489bf9af91c24091a81a1d72af1d6d463)), closes [#16](https://www.github.com/googleapis/java-talent/issues/16)

### [0.39.4](https://www.github.com/googleapis/java-talent/compare/v0.39.3...v0.39.4) (2020-10-21)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.13.0 ([#293](https://www.github.com/googleapis/java-talent/issues/293)) ([d4a491a](https://www.github.com/googleapis/java-talent/commit/d4a491af435b0e03f03f04b4f88485d486330ad1))

### [0.39.3](https://www.github.com/googleapis/java-talent/compare/v0.39.2...v0.39.3) (2020-10-19)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.12.1 ([#286](https://www.github.com/googleapis/java-talent/issues/286)) ([b57fd16](https://www.github.com/googleapis/java-talent/commit/b57fd167acfbd8004fab2525e74e4e3ce699972e))

### [0.39.2](https://www.github.com/googleapis/java-talent/compare/v0.39.1...v0.39.2) (2020-10-15)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.11.0 ([#276](https://www.github.com/googleapis/java-talent/issues/276)) ([bbbcaf7](https://www.github.com/googleapis/java-talent/commit/bbbcaf72968908676fb3fb25c56844943c0d901d))

### [0.39.1](https://www.github.com/googleapis/java-talent/compare/v0.39.0...v0.39.1) (2020-10-12)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.10.2 ([#265](https://www.github.com/googleapis/java-talent/issues/265)) ([5f74f5a](https://www.github.com/googleapis/java-talent/commit/5f74f5ac7e0a8293fcac38ae8db2bc660a45d329))

## [0.39.0](https://www.github.com/googleapis/java-talent/compare/v0.38.1...v0.39.0) (2020-10-01)


### ⚠ BREAKING CHANGES

* **v4:** remove commute enums CYCLING/WALKING from Job Search v4 API (#259)

### Features

* **v4:** remove commute enums CYCLING/WALKING from Job Search v4 API ([#259](https://www.github.com/googleapis/java-talent/issues/259)) ([3bf5f9c](https://www.github.com/googleapis/java-talent/commit/3bf5f9c30f656447da25ac483779c8c222389b34))

### [0.38.1](https://www.github.com/googleapis/java-talent/compare/v0.38.0...v0.38.1) (2020-09-23)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.10.0 ([#248](https://www.github.com/googleapis/java-talent/issues/248)) ([d0603b6](https://www.github.com/googleapis/java-talent/commit/d0603b6a252a65ac014536988c025bdcc19323bf))

## [0.38.0](https://www.github.com/googleapis/java-talent/compare/v0.37.0...v0.38.0) (2020-09-14)


### Features

* **v4:** add v4 client ([#230](https://www.github.com/googleapis/java-talent/issues/230)) ([9319d35](https://www.github.com/googleapis/java-talent/commit/9319d350c6c57e32307eb021fddf5985fdfffeb1))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.9.0 ([#225](https://www.github.com/googleapis/java-talent/issues/225)) ([9c77265](https://www.github.com/googleapis/java-talent/commit/9c7726524ceef3f1a777dcacccb9d3f5c9070986))

## [0.37.0](https://www.github.com/googleapis/java-talent/compare/v0.36.1...v0.37.0) (2020-08-10)


### ⚠ BREAKING CHANGES

* The default `of` methods of CompanyName and JobName have changed. This should not happen again, but to insulate yourself, please use the specific `of[Named Type]Name()`

### Features

* **deps:** adopt flatten plugin and google-cloud-shared-dependencies ([#195](https://www.github.com/googleapis/java-talent/issues/195)) ([0c4c8a5](https://www.github.com/googleapis/java-talent/commit/0c4c8a58a75e227ae9fcca135dab732f4ce06f44))


### Bug Fixes

* migrate retry settings to grpc_service_config ([#194](https://www.github.com/googleapis/java-talent/issues/194)) ([dd16f4c](https://www.github.com/googleapis/java-talent/commit/dd16f4cc1f4413f283bcc0855185c0c4e4114b16))
* reorder Company and Job resources in talent API to be consistent with old gapic config ([#143](https://www.github.com/googleapis/java-talent/issues/143)) ([e300534](https://www.github.com/googleapis/java-talent/commit/e3005343192bdb7519af9ed179afbe43ecc26902))


### Dependencies

* update dependency com.google.api:api-common to v1.9.1 ([#167](https://www.github.com/googleapis/java-talent/issues/167)) ([d96c2a7](https://www.github.com/googleapis/java-talent/commit/d96c2a7bf2cf95c4b6da25ff25d56758dff61fa3))
* update dependency com.google.api:api-common to v1.9.2 ([#175](https://www.github.com/googleapis/java-talent/issues/175)) ([ff9aa1f](https://www.github.com/googleapis/java-talent/commit/ff9aa1f1b854a7d498129456c0d1a5295c251c5b))
* update dependency com.google.api.grpc:proto-google-common-protos to v1.18.0 ([#157](https://www.github.com/googleapis/java-talent/issues/157)) ([83aebab](https://www.github.com/googleapis/java-talent/commit/83aebab68461f4ec0c50b492f66fac0205eb9d54))
* update dependency com.google.cloud:google-cloud-core to v1.93.5 ([#168](https://www.github.com/googleapis/java-talent/issues/168)) ([1ebe368](https://www.github.com/googleapis/java-talent/commit/1ebe368840d470e7c633eaeb9c79a1ad40c53947))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.2 ([#205](https://www.github.com/googleapis/java-talent/issues/205)) ([c9fe2ef](https://www.github.com/googleapis/java-talent/commit/c9fe2ef4b868f752d5d104df97590d0f15377468))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.6 ([af2dd96](https://www.github.com/googleapis/java-talent/commit/af2dd96cbe4aed9b7b6a97f34f796db958e8713a))
* update dependency com.google.guava:guava-bom to v29 ([#134](https://www.github.com/googleapis/java-talent/issues/134)) ([f7c95b3](https://www.github.com/googleapis/java-talent/commit/f7c95b3af542f453c0999da1895977c9475df9ad))
* update dependency com.google.protobuf:protobuf-java to v3.12.0 ([#161](https://www.github.com/googleapis/java-talent/issues/161)) ([55d07fd](https://www.github.com/googleapis/java-talent/commit/55d07fdf5cac41ef00e4266096202cb3c462f9ae))
* update dependency com.google.protobuf:protobuf-java to v3.12.2 ([#165](https://www.github.com/googleapis/java-talent/issues/165)) ([e6ebce7](https://www.github.com/googleapis/java-talent/commit/e6ebce7d6d84ec87f4fec078dbd9c831ac4ebe28))
* update dependency io.grpc:grpc-bom to v1.29.0 ([#148](https://www.github.com/googleapis/java-talent/issues/148)) ([26de0d1](https://www.github.com/googleapis/java-talent/commit/26de0d1e818107190f738f529e76662a4af8e86a))
* update dependency io.grpc:grpc-bom to v1.30.0 ([#180](https://www.github.com/googleapis/java-talent/issues/180)) ([7983067](https://www.github.com/googleapis/java-talent/commit/7983067e04480c7d7a311aa77163ab4fad7901d5))
* update dependency org.threeten:threetenbp to v1.4.4 ([#153](https://www.github.com/googleapis/java-talent/issues/153)) ([cb4a4a0](https://www.github.com/googleapis/java-talent/commit/cb4a4a0ae78c35a49749e3713a49d9fdbf2fb067))


### Documentation

* Remove a broken link from the documentation. ([#176](https://www.github.com/googleapis/java-talent/issues/176)) ([025c736](https://www.github.com/googleapis/java-talent/commit/025c736f5ff89f517e5b038d68af6dfd1640665f))

### [0.36.1](https://www.github.com/googleapis/java-talent/compare/v0.36.0...v0.36.1) (2020-04-07)


### Dependencies

* update core dependencies ([#85](https://www.github.com/googleapis/java-talent/issues/85)) ([5b4c2b0](https://www.github.com/googleapis/java-talent/commit/5b4c2b0717b551043d348c1d45369dc13b79be23))
* update dependency com.google.cloud:google-cloud-core to v1.93.4 ([#124](https://www.github.com/googleapis/java-talent/issues/124)) ([27af148](https://www.github.com/googleapis/java-talent/commit/27af1488441347441a98ac857a34b63d9dacf34b))
* update dependency org.threeten:threetenbp to v1.4.3 ([#101](https://www.github.com/googleapis/java-talent/issues/101)) ([d51ce92](https://www.github.com/googleapis/java-talent/commit/d51ce925a7c33c868a2de26df16b1b6c4dd67c22))

## [0.36.0](https://www.github.com/googleapis/java-talent/compare/v0.35.2...v0.36.0) (2020-03-27)


### ⚠ BREAKING CHANGES

* use `TenantName` for resources in place of `TenantOrProjectName`
* adopt the new multi-pattern resource names (#88)

### Features

* adopt the new multi-pattern resource names ([#88](https://www.github.com/googleapis/java-talent/issues/88)) ([0a8a4c9](https://www.github.com/googleapis/java-talent/commit/0a8a4c9141e5b024ab4106975690f6b3f1c91bf3))
* resource name change ([#106](https://www.github.com/googleapis/java-talent/issues/106)) ([2c44fa8](https://www.github.com/googleapis/java-talent/commit/2c44fa85b84cb8b64715a784b9c960a0ac23065c))


### Bug Fixes

* undeprecate resource name classes until multi-pattern resources are available ([#83](https://www.github.com/googleapis/java-talent/issues/83)) ([c6ac9f8](https://www.github.com/googleapis/java-talent/commit/c6ac9f825e122cd4805f51ae5ef3fc9e2185ca1b))


### Dependencies

* update core dependencies ([#84](https://www.github.com/googleapis/java-talent/issues/84)) ([2824acd](https://www.github.com/googleapis/java-talent/commit/2824acd3d725f7a2b2c246dad5140e248ceb318c))
* update dependency com.google.api:api-common to v1.9.0 ([#108](https://www.github.com/googleapis/java-talent/issues/108)) ([3e9cd1f](https://www.github.com/googleapis/java-talent/commit/3e9cd1fbd46f00d83dd5cedcce487644ba7eb465))
* update dependency com.google.cloud:google-cloud-core to v1.92.5 ([bd15e46](https://www.github.com/googleapis/java-talent/commit/bd15e4646a653e0951999a35336c472bc3c1661c))
* update dependency com.google.protobuf:protobuf-java to v3.11.4 ([e6ca466](https://www.github.com/googleapis/java-talent/commit/e6ca46662f9f78760fde934e23deaa1d4582d604))
* update dependency io.grpc:grpc-bom to v1.27.1 ([b9a488d](https://www.github.com/googleapis/java-talent/commit/b9a488d3356e772131a427934011d5f4543fac2c))


### Documentation

* **regen:** update generate proto documentation ([#86](https://www.github.com/googleapis/java-talent/issues/86)) ([3e2a860](https://www.github.com/googleapis/java-talent/commit/3e2a860d3d10cb46dcbe97582afc0b283d591f01))
* **regen:** update sample code to set total timeout, add API client header test ([10922f4](https://www.github.com/googleapis/java-talent/commit/10922f4c050ea3a54e57c30d5963d95e749228dd))

### [0.35.2](https://www.github.com/googleapis/java-talent/compare/v0.35.1...v0.35.2) (2020-02-04)


### Dependencies

* update core dependencies ([#44](https://www.github.com/googleapis/java-talent/issues/44)) ([4e82be0](https://www.github.com/googleapis/java-talent/commit/4e82be00d52d92e2aabe7f758acc76deae63e01e))
* update core dependencies ([#62](https://www.github.com/googleapis/java-talent/issues/62)) ([017cd38](https://www.github.com/googleapis/java-talent/commit/017cd389dbbf6ddd5496d8a50b972dbe0eda07dc))
* update dependency com.google.guava:guava-bom to v28.2-android ([#58](https://www.github.com/googleapis/java-talent/issues/58)) ([4ff4c95](https://www.github.com/googleapis/java-talent/commit/4ff4c958429b3b1316564a77e0a1f6ae0de67e00))
* update dependency com.google.protobuf:protobuf-java to v3.11.3 ([#64](https://www.github.com/googleapis/java-talent/issues/64)) ([0e28cb5](https://www.github.com/googleapis/java-talent/commit/0e28cb5a343dc025041c0209e582c7ea2b82ec11))
* update dependency org.threeten:threetenbp to v1.4.1 ([8bcbfd3](https://www.github.com/googleapis/java-talent/commit/8bcbfd3d2b946f5a5ce815fe52eb853744ec6484))


### Documentation

* **regen:** regenerate with proto annotations ([#57](https://www.github.com/googleapis/java-talent/issues/57)) ([99802da](https://www.github.com/googleapis/java-talent/commit/99802dae34d7d68351c421b08a805f0873b267f2))

### [0.35.1](https://www.github.com/googleapis/java-talent/compare/v0.35.0...v0.35.1) (2020-01-07)


### Bug Fixes

* **regen:** fix proto imports ([a041dcb](https://www.github.com/googleapis/java-talent/commit/a041dcb5536f88d58fe0c5a40af3c485aa88a2a3))


### Dependencies

* update core dependencies ([#40](https://www.github.com/googleapis/java-talent/issues/40)) ([ca49c14](https://www.github.com/googleapis/java-talent/commit/ca49c14fec70b4a7d8efd685012d36bfc624b8bd))
* update dependency com.google.cloud:google-cloud-core to v1.91.3 ([#30](https://www.github.com/googleapis/java-talent/issues/30)) ([64b68a5](https://www.github.com/googleapis/java-talent/commit/64b68a585e6a0150d62ef8894155f438d4110b68))
* update dependency com.google.protobuf:protobuf-java to v3.11.0 ([#24](https://www.github.com/googleapis/java-talent/issues/24)) ([b260115](https://www.github.com/googleapis/java-talent/commit/b2601157720d10719017fa777e6bb74b7d2b66b2))
* update dependency com.google.protobuf:protobuf-java to v3.11.1 ([#26](https://www.github.com/googleapis/java-talent/issues/26)) ([edb4674](https://www.github.com/googleapis/java-talent/commit/edb4674475a7f95f731539e1bfd8f65cf3540ee1))
* update dependency io.grpc:grpc-bom to v1.26.0 ([#37](https://www.github.com/googleapis/java-talent/issues/37)) ([fe32498](https://www.github.com/googleapis/java-talent/commit/fe32498dd982171d355493e97da8c889230fba08))
* update dependency junit:junit to v4.13 ([#43](https://www.github.com/googleapis/java-talent/issues/43)) ([a1dc3e1](https://www.github.com/googleapis/java-talent/commit/a1dc3e12444cb87844d669912a9600f7b20a4c62))
* update gax.version to v1.51.0 ([#28](https://www.github.com/googleapis/java-talent/issues/28)) ([e77f43a](https://www.github.com/googleapis/java-talent/commit/e77f43a7fe2adc97b3f76550ede29271d0dc2f2b))


### Documentation

* **regen:** update generated javadoc ([#32](https://www.github.com/googleapis/java-talent/issues/32)) ([f4bc974](https://www.github.com/googleapis/java-talent/commit/f4bc9744c0f375c93e136dfaba85c66523d233ea))
* **regen:** update javadoc from protoc update ([#38](https://www.github.com/googleapis/java-talent/issues/38)) ([7b9dcbe](https://www.github.com/googleapis/java-talent/commit/7b9dcbe66b1004d97960381dd956add0c36e07a9))

## [0.35.0](https://www.github.com/googleapis/java-talent/compare/v0.34.0...v0.35.0) (2019-11-12)


### Features

* add queryLanguageCode to JobQuery ([#9](https://www.github.com/googleapis/java-talent/issues/9)) ([1e2f981](https://www.github.com/googleapis/java-talent/commit/1e2f981ebd39f96b4c0d50f3b3908f63bdd6424b))


### Documentation

* mark jobs as required for BatchUpdateJobsRequest ([#15](https://www.github.com/googleapis/java-talent/issues/15)) ([b098490](https://www.github.com/googleapis/java-talent/commit/b0984906ece41add04c47136fb8c6579284cffe2))

## [0.34.0](https://www.github.com/googleapis/java-talent/compare/0.33.0...v0.34.0) (2019-10-25)


### Features

* make repo releasable, add parent/bom ([#1](https://www.github.com/googleapis/java-talent/issues/1)) ([10e2798](https://www.github.com/googleapis/java-talent/commit/10e279856608b8cec7ef4c84f0d1acea4e5a44ad))


### Dependencies

* update dependency io.grpc:grpc-bom to v1.24.1 ([#3](https://www.github.com/googleapis/java-talent/issues/3)) ([241d7c5](https://www.github.com/googleapis/java-talent/commit/241d7c5b196bd25f19f06a2f20d05bc4afb487e6))
* update gax.version to v1.49.1 ([#5](https://www.github.com/googleapis/java-talent/issues/5)) ([d89a745](https://www.github.com/googleapis/java-talent/commit/d89a745b4b2c871e2bc297dc86afb1694fb26616))
