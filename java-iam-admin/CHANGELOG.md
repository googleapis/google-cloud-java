# Changelog

## [2.0.0](https://github.com/googleapis/google-cloud-java/compare/google-iam-admin-v1.3.0...google-iam-admin-v2.0.0) (2022-10-14)


### ⚠ BREAKING CHANGES

* [iam-admin] replace java_outer_classname option with use_java_stubby_library, add DisableServiceAccountKey and EnableServiceAccountKey, and update comments (#8412)

### Features

* [analyticsdata] add `subject_to_thresholding` field to `ResponseMetadata` type ([#8545](https://github.com/googleapis/google-cloud-java/issues/8545)) ([8fdc6c1](https://github.com/googleapis/google-cloud-java/commit/8fdc6c1f10f88f30f4d1407579d645f75366b4cf))
* [iam-admin] replace java_outer_classname option with use_java_stubby_library, add DisableServiceAccountKey and EnableServiceAccountKey, and update comments ([#8412](https://github.com/googleapis/google-cloud-java/issues/8412)) ([c5e5ef1](https://github.com/googleapis/google-cloud-java/commit/c5e5ef1cd78e33341879d7016ed812c98eded00c))
* add `tokens_per_project_per_hour` field to `PropertyQuota` type ([8fdc6c1](https://github.com/googleapis/google-cloud-java/commit/8fdc6c1f10f88f30f4d1407579d645f75366b4cf))


### Bug Fixes

* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.2 ([#8325](https://github.com/googleapis/google-cloud-java/issues/8325)) ([01f492b](https://github.com/googleapis/google-cloud-java/commit/01f492be424acdb90edb23ba66656aeff7cf39eb))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.4 ([#8528](https://github.com/googleapis/google-cloud-java/issues/8528)) ([bd36199](https://github.com/googleapis/google-cloud-java/commit/bd361998ac4eb7c78eef3b3eac39aef31a0cf44e))
* owl-bot-staging should not be commited ([#8337](https://github.com/googleapis/google-cloud-java/issues/8337)) ([c9bb4a9](https://github.com/googleapis/google-cloud-java/commit/c9bb4a97aa19032b78c86c951fe9920f24ac4eec))


### Dependencies

* reverting renovate bot pull requests ([#8417](https://github.com/googleapis/google-cloud-java/issues/8417)) ([8f0c60b](https://github.com/googleapis/google-cloud-java/commit/8f0c60bde446acccc665eb7894723632eefc3503))

## [1.3.0](https://github.com/googleapis/java-iam-admin/compare/v1.2.5...v1.3.0) (2022-10-03)


### Features

* Replace java_outer_classname option with use_java_stubby_library, add DisableServiceAccountKey and EnableServiceAccountKey, and update comments ([#170](https://github.com/googleapis/java-iam-admin/issues/170)) ([9aac609](https://github.com/googleapis/java-iam-admin/commit/9aac609241998e4f4fdb5373d61f3f2d7c41e4dc))


### Dependencies

* Update dependency cachetools to v5 ([#177](https://github.com/googleapis/java-iam-admin/issues/177)) ([14a70f1](https://github.com/googleapis/java-iam-admin/commit/14a70f15a88be6a374eb2a369d30b363c76c33b9))
* Update dependency certifi to v2022.9.24 ([#179](https://github.com/googleapis/java-iam-admin/issues/179)) ([717d1d4](https://github.com/googleapis/java-iam-admin/commit/717d1d4a2db54db08c8937f4392174eea70aa4a8))
* Update dependency charset-normalizer to v2.1.1 ([#183](https://github.com/googleapis/java-iam-admin/issues/183)) ([f8d5fbf](https://github.com/googleapis/java-iam-admin/commit/f8d5fbf25b2f4a6f49350ac95abbdd9a3323a6af))
* Update dependency click to v8.1.3 ([#184](https://github.com/googleapis/java-iam-admin/issues/184)) ([3dd9f26](https://github.com/googleapis/java-iam-admin/commit/3dd9f26db47093de8ca39f17730b80164fcfad3a))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.4 ([#199](https://github.com/googleapis/java-iam-admin/issues/199)) ([08984e9](https://github.com/googleapis/java-iam-admin/commit/08984e95aec4cb9b82067f63cb305d3948d3199a))
* Update dependency gcp-releasetool to v1.8.8 ([#180](https://github.com/googleapis/java-iam-admin/issues/180)) ([44f56b7](https://github.com/googleapis/java-iam-admin/commit/44f56b7644259d9a1c088dbba0cd9b115ad8d79e))
* Update dependency google-api-core to v2.10.1 ([#185](https://github.com/googleapis/java-iam-admin/issues/185)) ([aff58c8](https://github.com/googleapis/java-iam-admin/commit/aff58c877de0ac542bb5d736b23d066e1b4d3034))
* Update dependency google-auth to v2.12.0 ([#192](https://github.com/googleapis/java-iam-admin/issues/192)) ([77a2b4c](https://github.com/googleapis/java-iam-admin/commit/77a2b4c277b06dd4c89f9dd22a5523b66925d4ee))
* Update dependency google-cloud-core to v2.3.2 ([#181](https://github.com/googleapis/java-iam-admin/issues/181)) ([c6d7cf3](https://github.com/googleapis/java-iam-admin/commit/c6d7cf3f57bf6016b15f7dfb07650066370d1c55))
* Update dependency google-cloud-storage to v2.5.0 ([#193](https://github.com/googleapis/java-iam-admin/issues/193)) ([c653fd5](https://github.com/googleapis/java-iam-admin/commit/c653fd5e1703152235db82c2c3bc432ec4637e37))
* Update dependency google-crc32c to v1.5.0 ([#194](https://github.com/googleapis/java-iam-admin/issues/194)) ([13f53b8](https://github.com/googleapis/java-iam-admin/commit/13f53b8f99b7f9a59e0675c205fcd8030508e703))
* Update dependency googleapis-common-protos to v1.56.4 ([#182](https://github.com/googleapis/java-iam-admin/issues/182)) ([7dd0fad](https://github.com/googleapis/java-iam-admin/commit/7dd0faddae40374794eff395846fe9b9fe98bb18))
* Update dependency importlib-metadata to v4.12.0 ([#195](https://github.com/googleapis/java-iam-admin/issues/195)) ([5b7dbd4](https://github.com/googleapis/java-iam-admin/commit/5b7dbd4e24c75776b60d777d0229b9a9e6c02346))
* Update dependency jeepney to v0.8.0 ([#196](https://github.com/googleapis/java-iam-admin/issues/196)) ([e02b609](https://github.com/googleapis/java-iam-admin/commit/e02b60996650c2d3c261474a1ab912a95a35b9d0))
* Update dependency jinja2 to v3.1.2 ([#186](https://github.com/googleapis/java-iam-admin/issues/186)) ([51e10e0](https://github.com/googleapis/java-iam-admin/commit/51e10e089cea3515c9441432ca2eb6894d1d833c))
* Update dependency keyring to v23.9.3 ([#187](https://github.com/googleapis/java-iam-admin/issues/187)) ([db3f2af](https://github.com/googleapis/java-iam-admin/commit/db3f2af00d57d9048ff481953065fe59ad9b64fa))
* Update dependency markupsafe to v2.1.1 ([#188](https://github.com/googleapis/java-iam-admin/issues/188)) ([b56cd55](https://github.com/googleapis/java-iam-admin/commit/b56cd55a933b70303777c5d6f11291e2db76ddba))
* Update dependency protobuf to v3.20.2 ([#189](https://github.com/googleapis/java-iam-admin/issues/189)) ([210d492](https://github.com/googleapis/java-iam-admin/commit/210d492d34a5794c89ebc0dd8232523641b70e4f))
* Update dependency protobuf to v4 ([#178](https://github.com/googleapis/java-iam-admin/issues/178)) ([5793368](https://github.com/googleapis/java-iam-admin/commit/5793368b1a55f58815e54596f2fa7aba9b5e3c2c))
* Update dependency pyjwt to v2.5.0 ([#190](https://github.com/googleapis/java-iam-admin/issues/190)) ([23049b2](https://github.com/googleapis/java-iam-admin/commit/23049b2655468518ec1b7a97208972dc8f351768))
* Update dependency requests to v2.28.1 ([#191](https://github.com/googleapis/java-iam-admin/issues/191)) ([8ca59d1](https://github.com/googleapis/java-iam-admin/commit/8ca59d1dc61928abf964cf9d5f805c5ddce33154))
* Update dependency typing-extensions to v4.3.0 ([#175](https://github.com/googleapis/java-iam-admin/issues/175)) ([6e24940](https://github.com/googleapis/java-iam-admin/commit/6e2494027fda01b155193188c44d85738a119ae3))
* Update dependency zipp to v3.8.1 ([#176](https://github.com/googleapis/java-iam-admin/issues/176)) ([ed17b74](https://github.com/googleapis/java-iam-admin/commit/ed17b74ffd3acc928560845120c8c0a4ff38843a))

## [1.2.5](https://github.com/googleapis/java-iam-admin/compare/v1.2.4...v1.2.5) (2022-09-15)


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.3 ([#166](https://github.com/googleapis/java-iam-admin/issues/166)) ([c13c4b4](https://github.com/googleapis/java-iam-admin/commit/c13c4b4406f036c181da2f6fa3dfdb615313180c))

## [1.2.4](https://github.com/googleapis/java-iam-admin/compare/v1.2.3...v1.2.4) (2022-09-09)


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.2 ([#162](https://github.com/googleapis/java-iam-admin/issues/162)) ([2e53918](https://github.com/googleapis/java-iam-admin/commit/2e53918c95949c70fbc236f6a4f27e68647576d9))

## [1.2.3](https://github.com/googleapis/java-iam-admin/compare/v1.2.2...v1.2.3) (2022-08-09)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v3 ([#154](https://github.com/googleapis/java-iam-admin/issues/154)) ([cf14dac](https://github.com/googleapis/java-iam-admin/commit/cf14dacfc912bf4842f1ba458ef2db394986bf8b))

## [1.2.2](https://github.com/googleapis/java-iam-admin/compare/v1.2.1...v1.2.2) (2022-07-13)


### Bug Fixes

* enable longpaths support for windows test ([#1485](https://github.com/googleapis/java-iam-admin/issues/1485)) ([#147](https://github.com/googleapis/java-iam-admin/issues/147)) ([0c852fd](https://github.com/googleapis/java-iam-admin/commit/0c852fd01a2375563dcbe25e483ed39f7bb1fd3a))

## [1.2.1](https://github.com/googleapis/java-iam-admin/compare/v1.2.0...v1.2.1) (2022-07-01)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.13.0 ([#138](https://github.com/googleapis/java-iam-admin/issues/138)) ([7027a9f](https://github.com/googleapis/java-iam-admin/commit/7027a9f8437623b54ed2cf73b2f0c44365115f7f))

## [1.2.0](https://github.com/googleapis/java-iam-admin/compare/v1.1.7...v1.2.0) (2022-05-19)


### Features

* add build scripts for native image testing in Java 17 ([#1440](https://github.com/googleapis/java-iam-admin/issues/1440)) ([#131](https://github.com/googleapis/java-iam-admin/issues/131)) ([ec1310f](https://github.com/googleapis/java-iam-admin/commit/ec1310fe1c2b1c6e50aeb8dbd20ba4aa3d3fa297))
* AuditConfig for IAM v1 ([1a2878c](https://github.com/googleapis/java-iam-admin/commit/1a2878c02833b78cc32b2ca1eb425b9946217139))
* next release from main branch is 1.2.0 ([#123](https://github.com/googleapis/java-iam-admin/issues/123)) ([38ec738](https://github.com/googleapis/java-iam-admin/commit/38ec7385b30b92a3fa6698aa9f0ae85238b25e69))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.12.0 ([#130](https://github.com/googleapis/java-iam-admin/issues/130)) ([761fd6e](https://github.com/googleapis/java-iam-admin/commit/761fd6e20de70a2ea7c8de079f2f26fb7ae3676f))

### [1.1.7](https://github.com/googleapis/java-iam-admin/compare/v1.1.6...v1.1.7) (2022-04-15)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.10.0 ([#116](https://github.com/googleapis/java-iam-admin/issues/116)) ([7992ce9](https://github.com/googleapis/java-iam-admin/commit/7992ce9c6ee70eda2951d89c6e19f0a21ae15518))

### [1.1.6](https://github.com/googleapis/java-iam-admin/compare/v1.1.5...v1.1.6) (2022-03-29)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.9.0 ([#110](https://github.com/googleapis/java-iam-admin/issues/110)) ([e1755af](https://github.com/googleapis/java-iam-admin/commit/e1755af8bf8b3c6210e13a495b734bf2173bd17f))

### [1.1.5](https://github.com/googleapis/java-iam-admin/compare/v1.1.4...v1.1.5) (2022-03-03)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.8.0 ([#100](https://github.com/googleapis/java-iam-admin/issues/100)) ([d9aa8a2](https://github.com/googleapis/java-iam-admin/commit/d9aa8a287ade7a3afe62eb2669dd2a9c25aca549))

### [1.1.4](https://github.com/googleapis/java-iam-admin/compare/v1.1.3...v1.1.4) (2022-02-28)


### Dependencies

* update actions/setup-java action to v3 ([#94](https://github.com/googleapis/java-iam-admin/issues/94)) ([0f3c7b9](https://github.com/googleapis/java-iam-admin/commit/0f3c7b96939eb1c1b4903e54f585bc9c309400e1))

### [1.1.3](https://github.com/googleapis/java-iam-admin/compare/v1.1.2...v1.1.3) (2022-02-15)


### Dependencies

* update actions/github-script action to v6 ([#87](https://github.com/googleapis/java-iam-admin/issues/87)) ([d487827](https://github.com/googleapis/java-iam-admin/commit/d487827f8c18f561510d10682b8b39ed7dd6bdd5))

### [1.1.2](https://github.com/googleapis/java-iam-admin/compare/v1.1.1...v1.1.2) (2022-02-03)


### Dependencies

* **java:** update actions/github-script action to v5 ([#1339](https://github.com/googleapis/java-iam-admin/issues/1339)) ([#74](https://github.com/googleapis/java-iam-admin/issues/74)) ([db423b7](https://github.com/googleapis/java-iam-admin/commit/db423b76b2b4cf072d3cd7d13a4f0d0afe05ff40))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.7.0 ([#77](https://github.com/googleapis/java-iam-admin/issues/77)) ([8f53bb1](https://github.com/googleapis/java-iam-admin/commit/8f53bb15faf887b4003cf95a9d3d989dd2da2285))

### [1.1.1](https://www.github.com/googleapis/java-iam-admin/compare/v1.1.0...v1.1.1) (2022-01-07)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.6.0 ([#60](https://www.github.com/googleapis/java-iam-admin/issues/60)) ([dbfad65](https://www.github.com/googleapis/java-iam-admin/commit/dbfad6569004b55ce1505854a3cfaf7b5daaf9ce))

## [1.1.0](https://www.github.com/googleapis/java-iam-admin/compare/v1.0.0...v1.1.0) (2021-12-06)


### Features

* next release from main branch is 1.1.0 ([#29](https://www.github.com/googleapis/java-iam-admin/issues/29)) ([9a41a9e](https://www.github.com/googleapis/java-iam-admin/commit/9a41a9ebb91915adaf2e250cbe1949690a8d8cb3))


### Bug Fixes

* **java:** add -ntp flag to native image testing command ([#1299](https://www.github.com/googleapis/java-iam-admin/issues/1299)) ([#49](https://www.github.com/googleapis/java-iam-admin/issues/49)) ([ad0cadb](https://www.github.com/googleapis/java-iam-admin/commit/ad0cadb375c0ad642178677f6a45cad7c6c54ec5))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.5.0 ([#43](https://www.github.com/googleapis/java-iam-admin/issues/43)) ([f786742](https://www.github.com/googleapis/java-iam-admin/commit/f7867426bf82bcc9418e6688122c280fbbfbbd5b))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.5.1 ([#48](https://www.github.com/googleapis/java-iam-admin/issues/48)) ([71404b1](https://www.github.com/googleapis/java-iam-admin/commit/71404b1bca6885dfd2129d5623364f6fc4441827))

## [1.0.0](https://www.github.com/googleapis/java-iam-admin/compare/v0.1.2...v1.0.0) (2021-10-25)


### Features

* promote to GA ([#26](https://www.github.com/googleapis/java-iam-admin/issues/26)) ([1a3cf11](https://www.github.com/googleapis/java-iam-admin/commit/1a3cf11111a3398f94399f72d5969f159b6bf9b4))

### [0.1.2](https://www.github.com/googleapis/java-iam-admin/compare/v0.1.1...v0.1.2) (2021-10-25)


### Bug Fixes

* **java:** java 17 dependency arguments ([#1266](https://www.github.com/googleapis/java-iam-admin/issues/1266)) ([#23](https://www.github.com/googleapis/java-iam-admin/issues/23)) ([a98ea27](https://www.github.com/googleapis/java-iam-admin/commit/a98ea27b8896b9988195f347dc9fc0e66824d323))

### [0.1.1](https://www.github.com/googleapis/java-iam-admin/compare/v0.1.0...v0.1.1) (2021-10-20)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.4.0 ([#18](https://www.github.com/googleapis/java-iam-admin/issues/18)) ([181884f](https://www.github.com/googleapis/java-iam-admin/commit/181884fcd1c8c9623f91743bdc3a9132fc3fb7f6))

## 0.1.0 (2021-09-30)


### Features

* initial generation ([c7db577](https://www.github.com/googleapis/java-iam-admin/commit/c7db5776ad0b1b5d0b38b61927e19cdb55fd1f1a))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.3.0 ([#8](https://www.github.com/googleapis/java-iam-admin/issues/8)) ([c4e86c8](https://www.github.com/googleapis/java-iam-admin/commit/c4e86c8844934dddd28c0bf12bb425b44b119629))
