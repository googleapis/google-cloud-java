# Changelog

## [2.4.0](https://github.com/googleapis/google-cloud-java/compare/google-cloud-game-servers-v2.3.4...google-cloud-game-servers-v2.4.0) (2022-10-12)


### Features

* [analyticsdata] add `subject_to_thresholding` field to `ResponseMetadata` type ([#8545](https://github.com/googleapis/google-cloud-java/issues/8545)) ([8fdc6c1](https://github.com/googleapis/google-cloud-java/commit/8fdc6c1f10f88f30f4d1407579d645f75366b4cf))
* add `tokens_per_project_per_hour` field to `PropertyQuota` type ([8fdc6c1](https://github.com/googleapis/google-cloud-java/commit/8fdc6c1f10f88f30f4d1407579d645f75366b4cf))
* create release please configuration ([41b97e6](https://github.com/googleapis/google-cloud-java/commit/41b97e6d0d38a54fbabf51a3069bf1473c48f730))


### Bug Fixes

* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.2 ([#8325](https://github.com/googleapis/google-cloud-java/issues/8325)) ([01f492b](https://github.com/googleapis/google-cloud-java/commit/01f492be424acdb90edb23ba66656aeff7cf39eb))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.4 ([#8528](https://github.com/googleapis/google-cloud-java/issues/8528)) ([bd36199](https://github.com/googleapis/google-cloud-java/commit/bd361998ac4eb7c78eef3b3eac39aef31a0cf44e))
* **deps:** update dependency com.google.cloud:libraries-bom to v26.1.1 ([#8254](https://github.com/googleapis/google-cloud-java/issues/8254)) ([e4760da](https://github.com/googleapis/google-cloud-java/commit/e4760da4ac8fa6fa91bc82b90b83d0518eca2692))
* owl-bot-staging should not be commited ([#8337](https://github.com/googleapis/google-cloud-java/issues/8337)) ([c9bb4a9](https://github.com/googleapis/google-cloud-java/commit/c9bb4a97aa19032b78c86c951fe9920f24ac4eec))


### Dependencies

* reverting renovate bot pull requests ([#8417](https://github.com/googleapis/google-cloud-java/issues/8417)) ([8f0c60b](https://github.com/googleapis/google-cloud-java/commit/8f0c60bde446acccc665eb7894723632eefc3503))

## [2.3.3](https://github.com/googleapis/java-game-servers/compare/v2.3.2...v2.3.3) (2022-09-15)


### Bug Fixes

* Ignore samples tests ([#707](https://github.com/googleapis/java-game-servers/issues/707)) ([154c39b](https://github.com/googleapis/java-game-servers/commit/154c39b93f241d11deeb3f1df31ba2480755f73c))


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.2 ([#712](https://github.com/googleapis/java-game-servers/issues/712)) ([9a042a3](https://github.com/googleapis/java-game-servers/commit/9a042a39d44fff3f582f4070e77f98e9881fb1e1))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.3 ([#714](https://github.com/googleapis/java-game-servers/issues/714)) ([2c6cc77](https://github.com/googleapis/java-game-servers/commit/2c6cc775383940e1871386ddaa99c6065f882af7))

## [2.3.2](https://github.com/googleapis/java-game-servers/compare/v2.3.1...v2.3.2) (2022-08-09)


### Bug Fixes

* Ignore ITSystemTest ([#700](https://github.com/googleapis/java-game-servers/issues/700)) ([1666f2a](https://github.com/googleapis/java-game-servers/commit/1666f2aa0c4c4c191383e9980558273a55775fdd))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v3 ([#697](https://github.com/googleapis/java-game-servers/issues/697)) ([501fd45](https://github.com/googleapis/java-game-servers/commit/501fd456b65df9f47c94a05937112846997854b3))
* update dependency com.google.code.gson:gson to v2.9.1 ([#698](https://github.com/googleapis/java-game-servers/issues/698)) ([bcff637](https://github.com/googleapis/java-game-servers/commit/bcff637badeb83a5c2548a61d14d14ce700cf14a))

## [2.3.1](https://github.com/googleapis/java-game-servers/compare/v2.3.0...v2.3.1) (2022-07-13)


### Bug Fixes

* enable longpaths support for windows test ([#1485](https://github.com/googleapis/java-game-servers/issues/1485)) ([#691](https://github.com/googleapis/java-game-servers/issues/691)) ([971dfa0](https://github.com/googleapis/java-game-servers/commit/971dfa0842cc05d2ed7a7c4e99a6b5bfc1f02f8f))

## [2.3.0](https://github.com/googleapis/java-game-servers/compare/v2.2.1...v2.3.0) (2022-07-01)


### Features

* Enable REST transport for most of Java and Go clients ([#676](https://github.com/googleapis/java-game-servers/issues/676)) ([aa517be](https://github.com/googleapis/java-game-servers/commit/aa517bef9cb58d15eb22cf80d24fce2d8bd8090d))


### Bug Fixes

* update gapic-generator-java with mock service generation fixes ([#682](https://github.com/googleapis/java-game-servers/issues/682)) ([8866d04](https://github.com/googleapis/java-game-servers/commit/8866d0413d6c4bc33e078971e5c2d38f8016b7d1))

## [2.2.1](https://github.com/googleapis/java-game-servers/compare/v2.2.0...v2.2.1) (2022-06-23)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.13.0 ([#675](https://github.com/googleapis/java-game-servers/issues/675)) ([033df87](https://github.com/googleapis/java-game-servers/commit/033df872c866469dcd6e4aa29cee9ae433c3a611))

## [2.2.0](https://github.com/googleapis/java-game-servers/compare/v2.1.10...v2.2.0) (2022-05-24)


### Features

* add build scripts for native image testing in Java 17 ([#1440](https://github.com/googleapis/java-game-servers/issues/1440)) ([#666](https://github.com/googleapis/java-game-servers/issues/666)) ([66945b8](https://github.com/googleapis/java-game-servers/commit/66945b8c2125412377ae3ec1e67561e638e1629c))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.12.0 ([#665](https://github.com/googleapis/java-game-servers/issues/665)) ([9de6361](https://github.com/googleapis/java-game-servers/commit/9de636195fd8aee4a8f9de4a689ae06ceab2a739))

### [2.1.10](https://github.com/googleapis/java-game-servers/compare/v2.1.9...v2.1.10) (2022-04-15)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.10.0 ([#652](https://github.com/googleapis/java-game-servers/issues/652)) ([a02499b](https://github.com/googleapis/java-game-servers/commit/a02499b18601908c24332b94ed37df2b6c4901c5))

### [2.1.9](https://github.com/googleapis/java-game-servers/compare/v2.1.8...v2.1.9) (2022-03-29)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.9.0 ([#646](https://github.com/googleapis/java-game-servers/issues/646)) ([9be55f4](https://github.com/googleapis/java-game-servers/commit/9be55f4ff242831804904b92f7f14502ea407bbf))

### [2.1.8](https://github.com/googleapis/java-game-servers/compare/v2.1.7...v2.1.8) (2022-03-03)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.8.0 ([#635](https://github.com/googleapis/java-game-servers/issues/635)) ([daad2c5](https://github.com/googleapis/java-game-servers/commit/daad2c5a425a9d264de1d76fb12afba58c6df79e))

### [2.1.7](https://github.com/googleapis/java-game-servers/compare/v2.1.6...v2.1.7) (2022-03-01)


### Dependencies

* update actions/github-script action to v6 ([#619](https://github.com/googleapis/java-game-servers/issues/619)) ([dd2f367](https://github.com/googleapis/java-game-servers/commit/dd2f367d2215af5dfb12d5a1124287c68d09758d))
* update actions/setup-java action to v3 ([#628](https://github.com/googleapis/java-game-servers/issues/628)) ([c8a2408](https://github.com/googleapis/java-game-servers/commit/c8a24087377edf587cec4b989ed21b6306b66236))
* update dependency com.google.code.gson:gson to v2.9.0 ([#621](https://github.com/googleapis/java-game-servers/issues/621)) ([555b4b4](https://github.com/googleapis/java-game-servers/commit/555b4b4fddc7329d4f92885cea1a8481c476b914))

### [2.1.6](https://github.com/googleapis/java-game-servers/compare/v2.1.5...v2.1.6) (2022-02-02)


### Dependencies

* **java:** update actions/github-script action to v5 ([#1339](https://github.com/googleapis/java-game-servers/issues/1339)) ([#605](https://github.com/googleapis/java-game-servers/issues/605)) ([69942ea](https://github.com/googleapis/java-game-servers/commit/69942ea8b3e277c49538a16c787d35dd3f16587c))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.7.0 ([#607](https://github.com/googleapis/java-game-servers/issues/607)) ([5b51195](https://github.com/googleapis/java-game-servers/commit/5b51195c849613ed556c288ffd3ca6a14507beaa))

### [2.1.5](https://www.github.com/googleapis/java-game-servers/compare/v2.1.4...v2.1.5) (2022-01-07)


### Bug Fixes

* **java:** add -ntp flag to native image testing command ([#1299](https://www.github.com/googleapis/java-game-servers/issues/1299)) ([#583](https://www.github.com/googleapis/java-game-servers/issues/583)) ([bc985e7](https://www.github.com/googleapis/java-game-servers/commit/bc985e756088f9527f0354b9afb628698c997cc5))
* **java:** run Maven in plain console-friendly mode ([#1301](https://www.github.com/googleapis/java-game-servers/issues/1301)) ([#590](https://www.github.com/googleapis/java-game-servers/issues/590)) ([6adec6d](https://www.github.com/googleapis/java-game-servers/commit/6adec6d1e37fb365ef2c52c306313fc5283f43ad))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.6.0 ([#593](https://www.github.com/googleapis/java-game-servers/issues/593)) ([3d1e176](https://www.github.com/googleapis/java-game-servers/commit/3d1e176dd08077b524d5010952a3b4d0a509bc35))

### [2.1.4](https://www.github.com/googleapis/java-game-servers/compare/v2.1.3...v2.1.4) (2021-12-03)


### Bug Fixes

* **java:** java 17 dependency arguments ([#1266](https://www.github.com/googleapis/java-game-servers/issues/1266)) ([#560](https://www.github.com/googleapis/java-game-servers/issues/560)) ([2ee33c5](https://www.github.com/googleapis/java-game-servers/commit/2ee33c5b338c2623e36350c6cca97138371c9841))


### Documentation

* fix docstring formatting ([#566](https://www.github.com/googleapis/java-game-servers/issues/566)) ([bdc90dc](https://www.github.com/googleapis/java-game-servers/commit/bdc90dcd9371f9e6a2cf6a0742f3dd7bf0d2b423))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.5.0 ([#572](https://www.github.com/googleapis/java-game-servers/issues/572)) ([445ea87](https://www.github.com/googleapis/java-game-servers/commit/445ea875fbce09394c3c24582d8615210ba67f43))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.5.1 ([#580](https://www.github.com/googleapis/java-game-servers/issues/580)) ([d86b652](https://www.github.com/googleapis/java-game-servers/commit/d86b652d60e321bcb26a7728c1350fb9ed9b2dc3))
* update dependency com.google.code.gson:gson to v2.8.9 ([#563](https://www.github.com/googleapis/java-game-servers/issues/563)) ([507ae0d](https://www.github.com/googleapis/java-game-servers/commit/507ae0d42664fbeb734461f1d4154d1b3736ff10))

### [2.1.3](https://www.github.com/googleapis/java-game-servers/compare/v2.1.2...v2.1.3) (2021-10-19)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.4.0 ([#555](https://www.github.com/googleapis/java-game-servers/issues/555)) ([e524c3b](https://www.github.com/googleapis/java-game-servers/commit/e524c3beafe97899693c5c23277166a43325319a))

### [2.1.2](https://www.github.com/googleapis/java-game-servers/compare/v2.1.1...v2.1.2) (2021-09-22)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.3.0 ([#542](https://www.github.com/googleapis/java-game-servers/issues/542)) ([3eb0c57](https://www.github.com/googleapis/java-game-servers/commit/3eb0c5746d945b59278dbdc0ca93276feab02165))

### [2.1.1](https://www.github.com/googleapis/java-game-servers/compare/v2.1.0...v2.1.1) (2021-09-14)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.2.1 ([#535](https://www.github.com/googleapis/java-game-servers/issues/535)) ([b6d6409](https://www.github.com/googleapis/java-game-servers/commit/b6d64095e6591654dd1b32638f4808c79ffc3ef3))

## [2.1.0](https://www.github.com/googleapis/java-game-servers/compare/v2.0.3...v2.1.0) (2021-08-31)


### Features

* Remove use of deprecated gradle command in java README ([#1196](https://www.github.com/googleapis/java-game-servers/issues/1196)) ([#519](https://www.github.com/googleapis/java-game-servers/issues/519)) ([dbdc5ed](https://www.github.com/googleapis/java-game-servers/commit/dbdc5ed7b324dfc7d50fa128b484755333995696))
* support version reporting API ([#520](https://www.github.com/googleapis/java-game-servers/issues/520)) ([a4906a5](https://www.github.com/googleapis/java-game-servers/commit/a4906a5c76afef56bd28c67a120b47a219551bdb))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.2.0 ([#523](https://www.github.com/googleapis/java-game-servers/issues/523)) ([6bd5d24](https://www.github.com/googleapis/java-game-servers/commit/6bd5d247acefdb4715fe5eea9a3fbdaa8365bbc9))

### [2.0.3](https://www.github.com/googleapis/java-game-servers/compare/v2.0.2...v2.0.3) (2021-08-24)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.1.0 ([#509](https://www.github.com/googleapis/java-game-servers/issues/509)) ([0883c31](https://www.github.com/googleapis/java-game-servers/commit/0883c3135c312fdbd4fb2c59242a688516c0c3f9))

### [2.0.2](https://www.github.com/googleapis/java-game-servers/compare/v2.0.1...v2.0.2) (2021-08-23)


### Dependencies

* update dependency com.google.code.gson:gson to v2.8.8 ([#506](https://www.github.com/googleapis/java-game-servers/issues/506)) ([ec5a649](https://www.github.com/googleapis/java-game-servers/commit/ec5a6496aa93a92ea3f7de462314cb25cc7f6fbd))

### [2.0.1](https://www.github.com/googleapis/java-game-servers/compare/v2.0.0...v2.0.1) (2021-08-12)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.0.1 ([#497](https://www.github.com/googleapis/java-game-servers/issues/497)) ([d5a2b18](https://www.github.com/googleapis/java-game-servers/commit/d5a2b181f99cb64fa82af81bc45791913d2e01ff))

## [2.0.0](https://www.github.com/googleapis/java-game-servers/compare/v1.2.2...v2.0.0) (2021-08-06)


### ⚠ BREAKING CHANGES

* release gapic-generator-java v2.0.0 (#491)

### Features

* release gapic-generator-java v2.0.0 ([#491](https://www.github.com/googleapis/java-game-servers/issues/491)) ([bb0f811](https://www.github.com/googleapis/java-game-servers/commit/bb0f81177249ce8e1ff92dba1b0d07d9a514cdd8))


### Bug Fixes

* owlbot post-processor should generate README ([#1154](https://www.github.com/googleapis/java-game-servers/issues/1154)) ([#472](https://www.github.com/googleapis/java-game-servers/issues/472)) ([eceedcb](https://www.github.com/googleapis/java-game-servers/commit/eceedcbd69d4d3bb46cb797c89a627a4005e1139)), closes [#1146](https://www.github.com/googleapis/java-game-servers/issues/1146) [#1147](https://www.github.com/googleapis/java-game-servers/issues/1147)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2 ([#492](https://www.github.com/googleapis/java-game-servers/issues/492)) ([f9ae97e](https://www.github.com/googleapis/java-game-servers/commit/f9ae97ef8b8cc1301e1093a2b48c3352e87a7b02))

### [1.2.2](https://www.github.com/googleapis/java-game-servers/compare/v1.2.1...v1.2.2) (2021-07-01)


### Bug Fixes

* Add `shopt -s nullglob` to dependencies script ([#1130](https://www.github.com/googleapis/java-game-servers/issues/1130)) ([#460](https://www.github.com/googleapis/java-game-servers/issues/460)) ([53869b4](https://www.github.com/googleapis/java-game-servers/commit/53869b47f2a49a6cc7fbe6f76428d6c88b637958))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.4.0 ([#463](https://www.github.com/googleapis/java-game-servers/issues/463)) ([002a9a2](https://www.github.com/googleapis/java-game-servers/commit/002a9a22c596530bbd595db1b5f4906a18f35f63))

### [1.2.1](https://www.github.com/googleapis/java-game-servers/compare/v1.2.0...v1.2.1) (2021-06-04)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.3.0 ([#447](https://www.github.com/googleapis/java-game-servers/issues/447)) ([32d2e32](https://www.github.com/googleapis/java-game-servers/commit/32d2e3206c587232a9d8d1553d167f8b2a6d9363))

## [1.2.0](https://www.github.com/googleapis/java-game-servers/compare/v1.1.3...v1.2.0) (2021-05-26)


### Features

* add `gcf-owl-bot[bot]` to `ignoreAuthors` ([#435](https://www.github.com/googleapis/java-game-servers/issues/435)) ([767a89c](https://www.github.com/googleapis/java-game-servers/commit/767a89cf82aa0a6e7dde9472cde0cd2493fd1b37))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.2.0 ([#434](https://www.github.com/googleapis/java-game-servers/issues/434)) ([b32a45b](https://www.github.com/googleapis/java-game-servers/commit/b32a45bec1537f384b53ce867083aa087b8bf0d3))
* update dependency com.google.code.gson:gson to v2.8.7 ([#441](https://www.github.com/googleapis/java-game-servers/issues/441)) ([4480384](https://www.github.com/googleapis/java-game-servers/commit/4480384d40550027f381ef8b51355e1896736d17))

### [1.1.3](https://www.github.com/googleapis/java-game-servers/compare/v1.1.2...v1.1.3) (2021-05-11)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.1.0 ([#427](https://www.github.com/googleapis/java-game-servers/issues/427)) ([26c4692](https://www.github.com/googleapis/java-game-servers/commit/26c469224bca3e7086a232b047be3bb30d6d1207))

### [1.1.2](https://www.github.com/googleapis/java-game-servers/compare/v1.1.1...v1.1.2) (2021-04-23)


### Bug Fixes

* release scripts from issuing overlapping phases ([#403](https://www.github.com/googleapis/java-game-servers/issues/403)) ([e7a4131](https://www.github.com/googleapis/java-game-servers/commit/e7a4131c48545ddfe9ccf7fbe92d5e261c0250c6))
* typo ([#400](https://www.github.com/googleapis/java-game-servers/issues/400)) ([b3940a4](https://www.github.com/googleapis/java-game-servers/commit/b3940a40dbd62ee02f6f3bb5313f906c11afa75e))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.21.1 ([#406](https://www.github.com/googleapis/java-game-servers/issues/406)) ([7063bce](https://www.github.com/googleapis/java-game-servers/commit/7063bcefe774e5222f7fac13da3a87659b68852a))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1 ([#414](https://www.github.com/googleapis/java-game-servers/issues/414)) ([ebd2b20](https://www.github.com/googleapis/java-game-servers/commit/ebd2b208bacab56fd7c51dcd101cf453ad9beb41))

### [1.1.1](https://www.github.com/googleapis/java-game-servers/compare/v1.1.0...v1.1.1) (2021-04-09)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.21.0 ([#391](https://www.github.com/googleapis/java-game-servers/issues/391)) ([592a969](https://www.github.com/googleapis/java-game-servers/commit/592a9692f8aedb4d3b3c5a15af9f7e0581f740e4))

## [1.1.0](https://www.github.com/googleapis/java-game-servers/compare/v1.0.9...v1.1.0) (2021-03-11)


### Features

* **generator:** update protoc to v3.15.3 ([#370](https://www.github.com/googleapis/java-game-servers/issues/370)) ([e8a47a9](https://www.github.com/googleapis/java-game-servers/commit/e8a47a97563e750be3b4808487c9d3b2f8751ee9))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.20.1 ([#379](https://www.github.com/googleapis/java-game-servers/issues/379)) ([edff170](https://www.github.com/googleapis/java-game-servers/commit/edff170d971da73cdee8f9dbc931fb7ec25e58f7))

### [1.0.9](https://www.github.com/googleapis/java-game-servers/compare/v1.0.8...v1.0.9) (2021-02-25)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.20.0 ([#366](https://www.github.com/googleapis/java-game-servers/issues/366)) ([58ae9ec](https://www.github.com/googleapis/java-game-servers/commit/58ae9ec8ab443b434d77f7a4e714f827f710bbff))

### [1.0.8](https://www.github.com/googleapis/java-game-servers/compare/v1.0.7...v1.0.8) (2021-02-24)


### Documentation

* generate sample code in the javadocs ([#355](https://www.github.com/googleapis/java-game-servers/issues/355)) ([c4aa1fd](https://www.github.com/googleapis/java-game-servers/commit/c4aa1fd5f83ad13eba5c2833698a8827e61ddc51))

### [1.0.7](https://www.github.com/googleapis/java-game-servers/compare/v1.0.6...v1.0.7) (2021-02-19)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.19.0 ([#349](https://www.github.com/googleapis/java-game-servers/issues/349)) ([7b37f81](https://www.github.com/googleapis/java-game-servers/commit/7b37f813b49698d2f93794ec82268f744e35b421))

### [1.0.6](https://www.github.com/googleapis/java-game-servers/compare/v1.0.5...v1.0.6) (2021-01-14)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.18.0 ([#317](https://www.github.com/googleapis/java-game-servers/issues/317)) ([58d9be6](https://www.github.com/googleapis/java-game-servers/commit/58d9be6df3703904b2812f9c4645e4b5347b1d8b))

### [1.0.5](https://www.github.com/googleapis/java-game-servers/compare/v1.0.4...v1.0.5) (2020-12-15)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.17.0 ([#306](https://www.github.com/googleapis/java-game-servers/issues/306)) ([0fc38a3](https://www.github.com/googleapis/java-game-servers/commit/0fc38a33d7cf300f40719f61675d0f4d24dbeacb))

### [1.0.4](https://www.github.com/googleapis/java-game-servers/compare/v1.0.3...v1.0.4) (2020-12-14)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.16.1 ([c873244](https://www.github.com/googleapis/java-game-servers/commit/c8732442938ee391f30e4af5d5214b215cd4a94d))

### [1.0.3](https://www.github.com/googleapis/java-game-servers/compare/v1.0.2...v1.0.3) (2020-12-02)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.16.0 ([#291](https://www.github.com/googleapis/java-game-servers/issues/291)) ([d46b3f6](https://www.github.com/googleapis/java-game-servers/commit/d46b3f60fc92f87f035795556150b8189a628b31))

### [1.0.2](https://www.github.com/googleapis/java-game-servers/compare/v1.0.1...v1.0.2) (2020-11-17)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.15.0 ([#275](https://www.github.com/googleapis/java-game-servers/issues/275)) ([865021e](https://www.github.com/googleapis/java-game-servers/commit/865021eaa6b056898ce5bb717bc6866145262ddb))

### [1.0.1](https://www.github.com/googleapis/java-game-servers/compare/v1.0.0...v1.0.1) (2020-11-04)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.14.1 ([#266](https://www.github.com/googleapis/java-game-servers/issues/266)) ([d84f99a](https://www.github.com/googleapis/java-game-servers/commit/d84f99a54ed2855e53b5aa554967c2177da15753))

## [1.0.0](https://www.github.com/googleapis/java-game-servers/compare/v0.21.2...v1.0.0) (2020-10-27)


### Features

* promote to 1.0.0 ([#229](https://www.github.com/googleapis/java-game-servers/issues/229)) ([589ce6b](https://www.github.com/googleapis/java-game-servers/commit/589ce6b78a408c62193fc704397a54929fc31997))

### [0.21.2](https://www.github.com/googleapis/java-game-servers/compare/v0.21.1...v0.21.2) (2020-10-22)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.13.0 ([#231](https://www.github.com/googleapis/java-game-servers/issues/231)) ([0e917b5](https://www.github.com/googleapis/java-game-servers/commit/0e917b56f3ef5c7d3ae1b3614418b97ae51f6fe1))

### [0.21.1](https://www.github.com/googleapis/java-game-servers/compare/v0.21.0...v0.21.1) (2020-09-22)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.9.0 ([#206](https://www.github.com/googleapis/java-game-servers/issues/206)) ([4a76fd3](https://www.github.com/googleapis/java-game-servers/commit/4a76fd3ac34b725011c6ff1aaf0f645c812aa507))

## [0.21.0](https://www.github.com/googleapis/java-game-servers/compare/v0.20.0...v0.21.0) (2020-08-07)


### Features

* **v1:** add v1 client ([#190](https://www.github.com/googleapis/java-game-servers/issues/190)) ([c7a1fd1](https://www.github.com/googleapis/java-game-servers/commit/c7a1fd197cdd26c62897c3a6ccb2860b3419fd88))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.6 ([3adb6ab](https://www.github.com/googleapis/java-game-servers/commit/3adb6ab925afccc47c5a5201e1c0d1e313e29e3c))

## [0.20.0](https://www.github.com/googleapis/java-game-servers/compare/v0.19.1...v0.20.0) (2020-07-22)


### ⚠ BREAKING CHANGES

* remove v1alpha client (#177)

### Features

* **deps:** adopt flatten plugin and google-cloud-shared-dependencies ([#159](https://www.github.com/googleapis/java-game-servers/issues/159)) ([871c822](https://www.github.com/googleapis/java-game-servers/commit/871c8220f663daf99947dcc6fcb885beec3b62cd))
* add v1beta client ([#176](https://www.github.com/googleapis/java-game-servers/issues/176)) ([d818dd4](https://www.github.com/googleapis/java-game-servers/commit/d818dd45282989d7f437466e2b6378b27a820a7c))
* remove v1alpha client ([#177](https://www.github.com/googleapis/java-game-servers/issues/177)) ([948776f](https://www.github.com/googleapis/java-game-servers/commit/948776f3975770a5e7f2d2bec1435e8727bd2638))


### Dependencies

* update dependency com.google.api:api-common to v1.9.1 ([#138](https://www.github.com/googleapis/java-game-servers/issues/138)) ([6e0743e](https://www.github.com/googleapis/java-game-servers/commit/6e0743e1b0d0e064d6e80e48ae7b4bb54ef3a5af))
* update dependency com.google.api:api-common to v1.9.2 ([#143](https://www.github.com/googleapis/java-game-servers/issues/143)) ([0a794e9](https://www.github.com/googleapis/java-game-servers/commit/0a794e9f4a0c880d00bf6be7f92a709115631294))
* update dependency com.google.api.grpc:proto-google-common-protos to v1.18.0 ([#129](https://www.github.com/googleapis/java-game-servers/issues/129)) ([9bd660b](https://www.github.com/googleapis/java-game-servers/commit/9bd660be9f5dcad15850c26d1401f47fc7c37c98))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.2 ([#171](https://www.github.com/googleapis/java-game-servers/issues/171)) ([043e1c0](https://www.github.com/googleapis/java-game-servers/commit/043e1c05b791d9057e3095cca5a073d99764d5b5))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.3 ([#173](https://www.github.com/googleapis/java-game-servers/issues/173)) ([eeb1a1b](https://www.github.com/googleapis/java-game-servers/commit/eeb1a1b5b559f1e3f52bccb3e894cfcfde8b5648))
* update dependency com.google.guava:guava-bom to v29 ([#107](https://www.github.com/googleapis/java-game-servers/issues/107)) ([5d8453f](https://www.github.com/googleapis/java-game-servers/commit/5d8453f9cc18b55a6dcec181e1c43b23593bb634))
* update dependency com.google.protobuf:protobuf-java to v3.12.0 ([#132](https://www.github.com/googleapis/java-game-servers/issues/132)) ([3976e6f](https://www.github.com/googleapis/java-game-servers/commit/3976e6fa0706939307673ebd014abddbb7e1c318))
* update dependency com.google.protobuf:protobuf-java to v3.12.2 ([#136](https://www.github.com/googleapis/java-game-servers/issues/136)) ([3722284](https://www.github.com/googleapis/java-game-servers/commit/3722284784dbcdadc9f688de7c9db5492e740dd4))
* update dependency io.grpc:grpc-bom to v1.29.0 ([#121](https://www.github.com/googleapis/java-game-servers/issues/121)) ([1a3260b](https://www.github.com/googleapis/java-game-servers/commit/1a3260bd287d63402fa94ee7418748f821c7c5da))
* update dependency io.grpc:grpc-bom to v1.30.0 ([#147](https://www.github.com/googleapis/java-game-servers/issues/147)) ([a715575](https://www.github.com/googleapis/java-game-servers/commit/a7155750469f762e54b8ef0fce44db56a76c3fe0))
* update dependency org.threeten:threetenbp to v1.4.4 ([#125](https://www.github.com/googleapis/java-game-servers/issues/125)) ([ce50084](https://www.github.com/googleapis/java-game-servers/commit/ce50084b59e665c995eeb2db2684f080e326eff3))

### [0.19.1](https://www.github.com/googleapis/java-gameservices/compare/v0.19.0...v0.19.1) (2020-04-07)


### Dependencies

* update core dependencies ([#76](https://www.github.com/googleapis/java-gameservices/issues/76)) ([b9dfc85](https://www.github.com/googleapis/java-gameservices/commit/b9dfc8525ca9ef3487deedde9539e4ecf7aa65e0))
* update core dependencies to v1.54.0 ([#72](https://www.github.com/googleapis/java-gameservices/issues/72)) ([9c449af](https://www.github.com/googleapis/java-gameservices/commit/9c449afea1f7fd1b2fb44be195776885419739fc))
* update dependency com.google.api:api-common to v1.9.0 ([#94](https://www.github.com/googleapis/java-gameservices/issues/94)) ([103e32f](https://www.github.com/googleapis/java-gameservices/commit/103e32f96a8e26fcdb0a9aae6011c73fbebb162e))
* update dependency com.google.protobuf:protobuf-java to v3.11.4 ([f720e0f](https://www.github.com/googleapis/java-gameservices/commit/f720e0f3bc3265e3856c3c6ade9b5a1b05121eef))
* update dependency io.grpc:grpc-bom to v1.27.1 ([7307dc4](https://www.github.com/googleapis/java-gameservices/commit/7307dc46cb6fb508b2b1f0f625fed283bb1462ea))
* update dependency io.grpc:grpc-bom to v1.27.2 ([16c1fb3](https://www.github.com/googleapis/java-gameservices/commit/16c1fb306fe9fcc286305b2bc80359efa4484ed5))
* update dependency org.threeten:threetenbp to v1.4.3 ([#85](https://www.github.com/googleapis/java-gameservices/issues/85)) ([024a3e4](https://www.github.com/googleapis/java-gameservices/commit/024a3e41ceb83f391da73fd9c03def3eb9a8c0c6))


### Documentation

* **regen:** update sample code to set total timeout, add API client header test ([5e6527e](https://www.github.com/googleapis/java-gameservices/commit/5e6527e276775896087917f61776ffcf09878ded))

## [0.19.0](https://www.github.com/googleapis/java-gameservices/compare/v0.18.1...v0.19.0) (2020-02-04)


### ⚠ BREAKING CHANGES

* remove ScalingPolicyService, AllocationPolicyService, regenerate v1alpha client (#46)

### Features

* remove ScalingPolicyService, AllocationPolicyService, regenerate v1alpha client ([#46](https://www.github.com/googleapis/java-gameservices/issues/46)) ([81afe64](https://www.github.com/googleapis/java-gameservices/commit/81afe6486bbf8faa2879f8b5d5df89141c772739))


### Dependencies

* update core dependencies to v1.53.0 ([#42](https://www.github.com/googleapis/java-gameservices/issues/42)) ([67aa2d7](https://www.github.com/googleapis/java-gameservices/commit/67aa2d74655dce8b9ffa267df689cf1d4ca39b13))
* update core dependencies to v1.53.1 ([#50](https://www.github.com/googleapis/java-gameservices/issues/50)) ([c62108b](https://www.github.com/googleapis/java-gameservices/commit/c62108bc7a63d338d2848dc394f5e6b892559fa1))
* update dependency com.google.guava:guava-bom to v28.2-android ([#35](https://www.github.com/googleapis/java-gameservices/issues/35)) ([abbaa90](https://www.github.com/googleapis/java-gameservices/commit/abbaa9061771c320e614d7e351d219e57765f861))
* update dependency com.google.protobuf:protobuf-java to v3.11.3 ([#52](https://www.github.com/googleapis/java-gameservices/issues/52)) ([9967d38](https://www.github.com/googleapis/java-gameservices/commit/9967d384abba97f90463d7151690c9e9e728fd93))
* update dependency io.grpc:grpc-bom to v1.27.0 ([#47](https://www.github.com/googleapis/java-gameservices/issues/47)) ([ed3dc9e](https://www.github.com/googleapis/java-gameservices/commit/ed3dc9e00710d4dea36f0140ee138fccb0c3f0e1))
* update dependency org.threeten:threetenbp to v1.4.1 ([5cd7ecf](https://www.github.com/googleapis/java-gameservices/commit/5cd7ecf19c47a747b96c8cca3af005f6a226b231))

### [0.18.1](https://www.github.com/googleapis/java-gameservices/compare/v0.18.0...v0.18.1) (2020-01-03)


### Dependencies

* update dependency com.google.protobuf:protobuf-java to v3.11.1 ([b6ba2b1](https://www.github.com/googleapis/java-gameservices/commit/b6ba2b119f7c8dd29248a5998d6fb04bf4424d5b))
* update dependency io.grpc:grpc-bom to v1.26.0 ([#31](https://www.github.com/googleapis/java-gameservices/issues/31)) ([72425d9](https://www.github.com/googleapis/java-gameservices/commit/72425d92ec72677a83dc36a5c8d99b30595ac4f7))
* update gax.version to v1.52.0 ([#26](https://www.github.com/googleapis/java-gameservices/issues/26)) ([76daba9](https://www.github.com/googleapis/java-gameservices/commit/76daba944b5a5e883e812f9116fcce95db16b7ed))

## [0.18.0](https://www.github.com/googleapis/java-gameservices/compare/v0.17.0...v0.18.0) (2019-11-18)


### ⚠ BREAKING CHANGES

* add gke_cluster_reference; buffer_size_percentage is now an int (#18)

### Features

* add gke_cluster_reference; buffer_size_percentage is now an int ([#18](https://www.github.com/googleapis/java-gameservices/issues/18)) ([4414980](https://www.github.com/googleapis/java-gameservices/commit/4414980b948fa37203f05d03e95f2b1c885f783b))

## [0.17.0](https://www.github.com/googleapis/java-gameservices/compare/0.16.0...v0.17.0) (2019-10-28)


### Features

* make repo releasable, add parent/bom ([#1](https://www.github.com/googleapis/java-gameservices/issues/1)) ([8021bae](https://www.github.com/googleapis/java-gameservices/commit/8021baeb8521b5d11aa55a02b0c5d432e70d982d))


### Dependencies

* update dependency io.grpc:grpc-bom to v1.24.1 ([aa6521f](https://www.github.com/googleapis/java-gameservices/commit/aa6521f939014837fc2c31e9e579437616940e3f))
* update gax.version to v1.49.1 ([56d3170](https://www.github.com/googleapis/java-gameservices/commit/56d317064821c43d0c66c4831fd6f7a8eaf52fa8))
