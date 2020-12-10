# Changelog

### [1.95.5](https://www.github.com/googleapis/java-translate/compare/v1.95.4...v1.95.5) (2020-12-08)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.16.0 ([#359](https://www.github.com/googleapis/java-translate/issues/359)) ([bef5e20](https://www.github.com/googleapis/java-translate/commit/bef5e201246cd50e13032f1b41e8f1b2cc78a238))

### [1.95.4](https://www.github.com/googleapis/java-translate/compare/v1.95.3...v1.95.4) (2020-11-17)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.15.0 ([#344](https://www.github.com/googleapis/java-translate/issues/344)) ([4512295](https://www.github.com/googleapis/java-translate/commit/4512295413e5b21127a3180621d710c1e164e81e))

### [1.95.3](https://www.github.com/googleapis/java-translate/compare/v1.95.2...v1.95.3) (2020-10-30)


### Bug Fixes

* increase batch translate timeout to 300 ([#274](https://www.github.com/googleapis/java-translate/issues/274)) ([75736fe](https://www.github.com/googleapis/java-translate/commit/75736fe03ee1298ee153ce9baeb8c81ec82df8a0))
* use setModel as rest api already support it ([#330](https://www.github.com/googleapis/java-translate/issues/330)) ([de5b5a8](https://www.github.com/googleapis/java-translate/commit/de5b5a80fb9e42cf698fd101cffd34474eda0ce9))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.13.0 ([#318](https://www.github.com/googleapis/java-translate/issues/318)) ([41293ce](https://www.github.com/googleapis/java-translate/commit/41293ce8a0e6cb410ba0f4a80a8027bc5ee49b3d))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.9.0 ([#281](https://www.github.com/googleapis/java-translate/issues/281)) ([e028946](https://www.github.com/googleapis/java-translate/commit/e02894607fea4edaa04486709a0e438a5f5beb20))
* update dependency com.google.cloud:google-cloud-storage to v1.113.2 ([#277](https://www.github.com/googleapis/java-translate/issues/277)) ([ed76cd5](https://www.github.com/googleapis/java-translate/commit/ed76cd53a5a2db0214b1c0986009c7cee7428384))

### [1.95.2](https://www.github.com/googleapis/java-translate/compare/v1.95.1...v1.95.2) (2020-08-21)


### Dependencies

* update dependency com.google.apis:google-api-services-translate to v2-rev20170525-1.30.10 ([#245](https://www.github.com/googleapis/java-translate/issues/245)) ([ac1d2fd](https://www.github.com/googleapis/java-translate/commit/ac1d2fdb1be8d4a04ba00bab3389e067c9e3061d))

### [1.95.1](https://www.github.com/googleapis/java-translate/compare/v1.95.0...v1.95.1) (2020-08-10)


### Bug Fixes

* replace get("model") with translationPb.getModel() ([#242](https://www.github.com/googleapis/java-translate/issues/242)) ([97f9664](https://www.github.com/googleapis/java-translate/commit/97f966404a115a5acb36c85fddb71a5b7c72b2e8)), closes [#240](https://www.github.com/googleapis/java-translate/issues/240)
* use rest api for detect and listSupportedLanguages ([#243](https://www.github.com/googleapis/java-translate/issues/243)) ([448f307](https://www.github.com/googleapis/java-translate/commit/448f307cb5f88ae171680442589e1d19d9a4e189)), closes [#241](https://www.github.com/googleapis/java-translate/issues/241)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.2 ([#237](https://www.github.com/googleapis/java-translate/issues/237)) ([6befa32](https://www.github.com/googleapis/java-translate/commit/6befa32053912c84629d973a668b10316fdfde1b))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.3 ([#244](https://www.github.com/googleapis/java-translate/issues/244)) ([5ec2720](https://www.github.com/googleapis/java-translate/commit/5ec27208fcfbf09c603070aa4722cb3b8d0e77dc))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.6 ([#254](https://www.github.com/googleapis/java-translate/issues/254)) ([f595652](https://www.github.com/googleapis/java-translate/commit/f59565262faf8893962d6bb673d1dc5ece87f15a))


### Documentation

* corrects spelling of build dependency adds backticks in docstring to smooth doc generation ([#251](https://www.github.com/googleapis/java-translate/issues/251)) ([8e39d83](https://www.github.com/googleapis/java-translate/commit/8e39d8384b4b6f6ebf9823f6087a7aedb356d5e5))

## [1.95.0](https://www.github.com/googleapis/java-translate/compare/v1.94.5...v1.95.0) (2020-06-23)


### Features

* **deps:** adopt flatten plugin and google-cloud-shared-dependencies ([#220](https://www.github.com/googleapis/java-translate/issues/220)) ([e2af685](https://www.github.com/googleapis/java-translate/commit/e2af68575cd22523d44ffdc5e7e36cd0eaf331e3))


### Bug Fixes

* migrate to grpc_service_config ([#228](https://www.github.com/googleapis/java-translate/issues/228)) ([516440b](https://www.github.com/googleapis/java-translate/commit/516440b6175e4832b400a74481b580ef07df40c2))
* restore GAPIC v2 retry configs ([#188](https://www.github.com/googleapis/java-translate/issues/188)) ([92d4eaa](https://www.github.com/googleapis/java-translate/commit/92d4eaafba966a443e4366d32516d17ef0081826))


### Dependencies

* update core dependencies to v1.93.5 ([#195](https://www.github.com/googleapis/java-translate/issues/195)) ([9ea3bcc](https://www.github.com/googleapis/java-translate/commit/9ea3bcc14ecfa82d79afad13cd618c7fcdeddd6e))
* update dependency com.google.api:api-common to v1.9.1 ([#194](https://www.github.com/googleapis/java-translate/issues/194)) ([224dd18](https://www.github.com/googleapis/java-translate/commit/224dd18065ae5fe6d014a66aa31815fbcb57fcc0))
* update dependency com.google.api:api-common to v1.9.2 ([#202](https://www.github.com/googleapis/java-translate/issues/202)) ([10ebc9a](https://www.github.com/googleapis/java-translate/commit/10ebc9ac50cdf5d817fee9510b1bdecaa16850db))
* update dependency com.google.api.grpc:proto-google-common-protos to v1.18.0 ([#182](https://www.github.com/googleapis/java-translate/issues/182)) ([3bf0c6b](https://www.github.com/googleapis/java-translate/commit/3bf0c6bf445f2a3ea91f598bb2c8385295b6a3e3))
* update dependency com.google.guava:guava-bom to v29 ([#141](https://www.github.com/googleapis/java-translate/issues/141)) ([ca6a29f](https://www.github.com/googleapis/java-translate/commit/ca6a29fb0ad417a15fe3111a9d79b29ba67e6905))
* update dependency com.google.http-client:google-http-client-bom to v1.35.0 ([#178](https://www.github.com/googleapis/java-translate/issues/178)) ([3da16ec](https://www.github.com/googleapis/java-translate/commit/3da16ecb1aa4b5ba12223cd6148a9e44332e0e16))
* update dependency com.google.protobuf:protobuf-bom to v3.12.1 ([#186](https://www.github.com/googleapis/java-translate/issues/186)) ([ec26b9e](https://www.github.com/googleapis/java-translate/commit/ec26b9ed4c546cc1da68654617ac6904d62a1e09))
* update dependency com.google.protobuf:protobuf-bom to v3.12.2 ([#196](https://www.github.com/googleapis/java-translate/issues/196)) ([84ff951](https://www.github.com/googleapis/java-translate/commit/84ff951fdd77e1ab2ab38c713fbe66c9c7f7c2c2))
* update dependency io.grpc:grpc-bom to v1.29.0 ([#172](https://www.github.com/googleapis/java-translate/issues/172)) ([71f424d](https://www.github.com/googleapis/java-translate/commit/71f424d44fdaaf927937c96e3d2a169adb4c73ce))
* update dependency io.grpc:grpc-bom to v1.30.0 ([#206](https://www.github.com/googleapis/java-translate/issues/206)) ([3e46b1e](https://www.github.com/googleapis/java-translate/commit/3e46b1e935f908186ad80e0a35ecf51068b8a295))
* update dependency org.threeten:threetenbp to v1.4.4 ([#177](https://www.github.com/googleapis/java-translate/issues/177)) ([d99012f](https://www.github.com/googleapis/java-translate/commit/d99012f6c3accfc243925c86630c851d6669c391))

### [1.94.5](https://www.github.com/googleapis/java-translate/compare/v1.94.4...v1.94.5) (2020-04-07)


### Dependencies

* update core dependencies ([#108](https://www.github.com/googleapis/java-translate/issues/108)) ([1e13f1e](https://www.github.com/googleapis/java-translate/commit/1e13f1e5662c07dd5039b79e891ead9376bdd01a))
* update core dependencies to v1.93.4 ([#132](https://www.github.com/googleapis/java-translate/issues/132)) ([3e06897](https://www.github.com/googleapis/java-translate/commit/3e0689719c951159557e1623b6b109ad87766d75))
* update dependency com.google.api:api-common to v1.9.0 ([#124](https://www.github.com/googleapis/java-translate/issues/124)) ([b943de4](https://www.github.com/googleapis/java-translate/commit/b943de4c6fdbd185bb60339407d884e6caf0fadc))
* update dependency com.google.cloud.samples:shared-configuration to v1.0.13 ([#123](https://www.github.com/googleapis/java-translate/issues/123)) ([2d5310e](https://www.github.com/googleapis/java-translate/commit/2d5310ebabfde09044d8e9291c05cab6cdf26152))
* update dependency org.threeten:threetenbp to v1.4.3 ([#117](https://www.github.com/googleapis/java-translate/issues/117)) ([89eec93](https://www.github.com/googleapis/java-translate/commit/89eec93f57fe1b21307a5e6d8876b16ec7b660df))

### [1.94.4](https://www.github.com/googleapis/java-translate/compare/v1.94.3...v1.94.4) (2020-03-06)


### Dependencies

* update core dependencies ([#100](https://www.github.com/googleapis/java-translate/issues/100)) ([fdb06de](https://www.github.com/googleapis/java-translate/commit/fdb06de1b06208c15e5a6fb82ac6462350d6822c))
* update core dependencies to v1.92.5 ([#87](https://www.github.com/googleapis/java-translate/issues/87)) ([8281291](https://www.github.com/googleapis/java-translate/commit/8281291cf265852843d2b80ffe0ac3b37978e9fe))
* update core dependencies to v1.93.1 ([#102](https://www.github.com/googleapis/java-translate/issues/102)) ([800ebcf](https://www.github.com/googleapis/java-translate/commit/800ebcf527c67f98d4afab4c325266166bc9feac))
* update dependency com.google.apis:google-api-services-translate to v2-rev20170525-1.30.8 ([#89](https://www.github.com/googleapis/java-translate/issues/89)) ([7279d77](https://www.github.com/googleapis/java-translate/commit/7279d777abc25a4d9977bbbc8a34e5aea1926afe))
* update dependency com.google.apis:google-api-services-translate to v2-rev20170525-1.30.9 ([#103](https://www.github.com/googleapis/java-translate/issues/103)) ([583ca43](https://www.github.com/googleapis/java-translate/commit/583ca43c4394b9548761eeda15063b4065b15f0c))
* update dependency com.google.http-client:google-http-client-bom to v1.34.2 ([6d5d6fb](https://www.github.com/googleapis/java-translate/commit/6d5d6fb023775f37ec1e061f1dd946a1503c2b18))
* update dependency com.google.protobuf:protobuf-bom to v3.11.4 ([2ea6cf9](https://www.github.com/googleapis/java-translate/commit/2ea6cf903430db2d51d89d47555cfba76173562d))
* update dependency io.grpc:grpc-bom to v1.27.1 ([ad74651](https://www.github.com/googleapis/java-translate/commit/ad746518e292d14004e67863916a0e1691dca1eb))
* update dependency io.grpc:grpc-bom to v1.27.2 ([db15663](https://www.github.com/googleapis/java-translate/commit/db156637e95efd75d5a997178e7f4eda2d396d1d))


### Documentation

* **regen:** update sample code to set total timeout, add API client header test ([c1fcecb](https://www.github.com/googleapis/java-translate/commit/c1fcecb0902cf90cb7070a2412d41f12da6d0e90))

### [1.94.3](https://www.github.com/googleapis/java-translate/compare/v1.94.2...v1.94.3) (2020-02-03)


### Dependencies

* update core dependencies ([#59](https://www.github.com/googleapis/java-translate/issues/59)) ([1cd4ec0](https://www.github.com/googleapis/java-translate/commit/1cd4ec01e168f6b8e98e3584ab487ce6fbdbf19e))
* update core dependencies ([#78](https://www.github.com/googleapis/java-translate/issues/78)) ([ad0d669](https://www.github.com/googleapis/java-translate/commit/ad0d66957947f26339331f5f065b744480dfc87d))
* update dependency com.google.guava:guava-bom to v28.2-android ([#57](https://www.github.com/googleapis/java-translate/issues/57)) ([542b507](https://www.github.com/googleapis/java-translate/commit/542b5073b1599e4df70d95fedd5f58c72481ad0d))
* update dependency com.google.http-client:google-http-client-bom to v1.34.1 ([#75](https://www.github.com/googleapis/java-translate/issues/75)) ([afae548](https://www.github.com/googleapis/java-translate/commit/afae548adb906f3a53971e639c6bbae3d704487e))
* update dependency com.google.protobuf:protobuf-bom to v3.11.3 ([#80](https://www.github.com/googleapis/java-translate/issues/80)) ([166ac50](https://www.github.com/googleapis/java-translate/commit/166ac50bafa19e97f92b9c44cb38a606dd584bd3))
* update dependency org.threeten:threetenbp to v1.4.1 ([2c1ac0a](https://www.github.com/googleapis/java-translate/commit/2c1ac0a47042817e2856fd714a9deba3e67f6d00))

### [1.94.2](https://www.github.com/googleapis/java-translate/compare/v1.94.1...v1.94.2) (2020-01-07)


### Dependencies

* update core dependencies ([#55](https://www.github.com/googleapis/java-translate/issues/55)) ([328b4d3](https://www.github.com/googleapis/java-translate/commit/328b4d38428497a734abc1b333e336c26523ff4b))
* update dependency com.google.auth:google-auth-library-bom to v0.19.0 ([#44](https://www.github.com/googleapis/java-translate/issues/44)) ([c38a9d8](https://www.github.com/googleapis/java-translate/commit/c38a9d8b33294abd59485569a7b2e2b5ff8d38dd))
* update dependency com.google.http-client:google-http-client-bom to v1.34.0 ([#46](https://www.github.com/googleapis/java-translate/issues/46)) ([4a50694](https://www.github.com/googleapis/java-translate/commit/4a50694307d218e37f02601534b4dece8a0da94e))
* update dependency com.google.protobuf:protobuf-java to v3.11.1 ([894fffc](https://www.github.com/googleapis/java-translate/commit/894fffc3ecd6df1f37feb5203e1368c87cf586c4))


### Documentation

* **regen:** updated javadocs from protoc update ([#43](https://www.github.com/googleapis/java-translate/issues/43)) ([23c923b](https://www.github.com/googleapis/java-translate/commit/23c923b4ff9ea7ac4825259c42c5f2a3e7d76ac9))

### [1.94.1](https://www.github.com/googleapis/java-translate/compare/v1.94.0...v1.94.1) (2019-11-22)


### Dependencies

* update gax.version to v1.50.1 ([#29](https://www.github.com/googleapis/java-translate/issues/29)) ([0264cf6](https://www.github.com/googleapis/java-translate/commit/0264cf6b5669bf1fea392fe27c3d5dfd31e44b0e))

## [1.94.0](https://www.github.com/googleapis/java-translate/compare/1.93.0...v1.94.0) (2019-10-23)


### Features

* add listGlossaries overload ([#8](https://www.github.com/googleapis/java-translate/issues/8)) ([df828d4](https://www.github.com/googleapis/java-translate/commit/df828d49fe0c1c80cd9c862504c931aa2e3260aa))
* add parent pom and bom ([#2](https://www.github.com/googleapis/java-translate/issues/2)) ([e74d2bc](https://www.github.com/googleapis/java-translate/commit/e74d2bcdbf9729d02d4fb9afa65030a177778259))
* add v3 client ([#10](https://www.github.com/googleapis/java-translate/issues/10)) ([c4d945f](https://www.github.com/googleapis/java-translate/commit/c4d945f9026cbd4d39c01f4c2f96aee1e26da4da))


### Bug Fixes

* bom pom.xml syntax error ([#11](https://www.github.com/googleapis/java-translate/issues/11)) ([5a591e4](https://www.github.com/googleapis/java-translate/commit/5a591e471c56cf9fd4d6207b93d13c93b83a8d96))
* include translate-bom module ([#9](https://www.github.com/googleapis/java-translate/issues/9)) ([486430f](https://www.github.com/googleapis/java-translate/commit/486430fad462ed4b4dd8f1f16aeb6f55e740252f))


### Dependencies

* update dependency com.google.auth:google-auth-library-bom to v0.18.0 ([#15](https://www.github.com/googleapis/java-translate/issues/15)) ([e9e06d7](https://www.github.com/googleapis/java-translate/commit/e9e06d7931aa086517e549b3c87f0475642931bb))
* update dependency io.grpc:grpc-bom to v1.24.1 ([f291cd9](https://www.github.com/googleapis/java-translate/commit/f291cd907fcd85bd5ae08e94c8279f8a2efb983c))
* update gax.version to v1.49.1 ([881b2d4](https://www.github.com/googleapis/java-translate/commit/881b2d48fd5227be944687d9da98031e59e5e247))
* update google.core.version to v1.91.2 ([#6](https://www.github.com/googleapis/java-translate/issues/6)) ([67c0a63](https://www.github.com/googleapis/java-translate/commit/67c0a63fbf25bf656ea38aef884db130d15e5376))
* update google.core.version to v1.91.3 ([#23](https://www.github.com/googleapis/java-translate/issues/23)) ([d591c9d](https://www.github.com/googleapis/java-translate/commit/d591c9d8494c37ad4f50788836b37c2e4725aaba))


### Documentation

* cleanup README badges ([#22](https://www.github.com/googleapis/java-translate/issues/22)) ([1217596](https://www.github.com/googleapis/java-translate/commit/121759617c28c5ea4552aab8fd0dc3160e1413d7))
