# Changelog

### [0.9.2](https://www.github.com/googleapis/java-shared-config/compare/v0.9.1...v0.9.2) (2020-07-02)


### Dependencies

* update dependency org.apache.maven.surefire:surefire-junit47 to v3.0.0-M5 ([#180](https://www.github.com/googleapis/java-shared-config/issues/180)) ([802d9c5](https://www.github.com/googleapis/java-shared-config/commit/802d9c528d34b386face69ca75a014ce57fc3ac1))

### [0.9.1](https://www.github.com/googleapis/java-shared-config/compare/v0.9.0...v0.9.1) (2020-07-01)


### Bug Fixes

* maven-dependency-plugin configuration breaking downstream config ([#174](https://www.github.com/googleapis/java-shared-config/issues/174)) ([507217f](https://www.github.com/googleapis/java-shared-config/commit/507217fe509cd4f16eb50c8075ab43229238e08d))


### Documentation

* change Devsite output path to /java/docs/reference ([#176](https://www.github.com/googleapis/java-shared-config/issues/176)) ([8b98af5](https://www.github.com/googleapis/java-shared-config/commit/8b98af54bf503d97bb86b6d02a5c4301b39384e1))

## [0.9.0](https://www.github.com/googleapis/java-shared-config/compare/v0.8.1...v0.9.0) (2020-06-25)


### Features

* add ignore rule for javax annotations to handle error in java11 ([#171](https://www.github.com/googleapis/java-shared-config/issues/171)) ([cd635ad](https://www.github.com/googleapis/java-shared-config/commit/cd635ad6e8e5d71ac3a30e7656eb788027f1c370))

### [0.8.1](https://www.github.com/googleapis/java-shared-config/compare/v0.8.0...v0.8.1) (2020-06-15)


### Bug Fixes

* bump flatten plugin version to fix missing version in profile section issue ([#159](https://www.github.com/googleapis/java-shared-config/issues/159)) ([5b34939](https://www.github.com/googleapis/java-shared-config/commit/5b349399a590b589718b7049f66c82ee38742372))

## [0.8.0](https://www.github.com/googleapis/java-shared-config/compare/v0.7.0...v0.8.0) (2020-06-10)


### Features

* revert "feat: mark auto-value-annotations scope as provided" ([#154](https://www.github.com/googleapis/java-shared-config/issues/154)) ([88afb4e](https://www.github.com/googleapis/java-shared-config/commit/88afb4e7c57cb6e00929c098135314a926d9da30))

## [0.7.0](https://www.github.com/googleapis/java-shared-config/compare/v0.6.0...v0.7.0) (2020-06-10)


### Features

* mark auto-value-annotations scope as provided ([#151](https://www.github.com/googleapis/java-shared-config/issues/151)) ([44ea4cb](https://www.github.com/googleapis/java-shared-config/commit/44ea4cbbf92b4ad35ffaffb7a01a1bce05063daf))


### Bug Fixes

* lock the google-java-format version used by formatter plugin ([#149](https://www.github.com/googleapis/java-shared-config/issues/149)) ([d58c054](https://www.github.com/googleapis/java-shared-config/commit/d58c05437a4ea8767db2bebfcc405ec77aeb9705))

## [0.6.0](https://www.github.com/googleapis/java-shared-config/compare/v0.5.0...v0.6.0) (2020-05-19)


### Features

* add new configuration necessary to support auto-value ([#136](https://www.github.com/googleapis/java-shared-config/issues/136)) ([c14689b](https://www.github.com/googleapis/java-shared-config/commit/c14689b8791c173687f719d73156a989aedd7ba6))

## [0.5.0](https://www.github.com/googleapis/java-shared-config/compare/v0.4.0...v0.5.0) (2020-04-07)


### Features

* add ban duplicate classes rule ([#126](https://www.github.com/googleapis/java-shared-config/issues/126)) ([e38a7cc](https://www.github.com/googleapis/java-shared-config/commit/e38a7cc949396f8f5696e62cd060e0c076047b8d))
* add devsite javadoc profile ([#121](https://www.github.com/googleapis/java-shared-config/issues/121)) ([7f452fb](https://www.github.com/googleapis/java-shared-config/commit/7f452fb6c5704f6ce0f731085479a28fb99ebcb9))
* add maven flatten plugin ([#127](https://www.github.com/googleapis/java-shared-config/issues/127)) ([fb00799](https://www.github.com/googleapis/java-shared-config/commit/fb00799c416d324d68da5b660a26f7ef595c26d9))


### Bug Fixes

* declare com.coveo:fmt-maven-plugin version/configuration ([#90](https://www.github.com/googleapis/java-shared-config/issues/90)) ([5cf71a6](https://www.github.com/googleapis/java-shared-config/commit/5cf71a6ed699907082756e70c2fdee6ad3632f38))


### Dependencies

* update dependency com.google.cloud.samples:shared-configuration to v1.0.13 ([#118](https://www.github.com/googleapis/java-shared-config/issues/118)) ([58ae69e](https://www.github.com/googleapis/java-shared-config/commit/58ae69eb5ba037963cdaed0c2b0e30663bc873eb))
* update dependency com.puppycrawl.tools:checkstyle to v8.29 ([f62292d](https://www.github.com/googleapis/java-shared-config/commit/f62292dab75699a75f8a7d499fe2ccfb7ee93783))
* update dependency org.apache.maven.plugins:maven-antrun-plugin to v1.8 ([#124](https://www.github.com/googleapis/java-shared-config/issues/124)) ([a681536](https://www.github.com/googleapis/java-shared-config/commit/a68153643400c3f3b5c5959cda4dc3b552336427))
* update dependency org.apache.maven.plugins:maven-dependency-plugin to v3.1.2 ([#107](https://www.github.com/googleapis/java-shared-config/issues/107)) ([c9b096b](https://www.github.com/googleapis/java-shared-config/commit/c9b096b81b1f4f8dc2d1302f259f0321722e1ca5))
* update dependency org.apache.maven.plugins:maven-site-plugin to v3.9.0 ([#103](https://www.github.com/googleapis/java-shared-config/issues/103)) ([abe7140](https://www.github.com/googleapis/java-shared-config/commit/abe714060e858c70a83888fb34438c45d97b1168))
* update dependency org.codehaus.mojo:build-helper-maven-plugin to v3.1.0 ([#101](https://www.github.com/googleapis/java-shared-config/issues/101)) ([ac69572](https://www.github.com/googleapis/java-shared-config/commit/ac69572be76e4462fdf65fa6e7f0935c3d51d827))

## [0.4.0](https://www.github.com/googleapis/java-shared-config/compare/v0.3.1...v0.4.0) (2020-01-08)


### Features

* add new enable-integration-tests profile ([#75](https://www.github.com/googleapis/java-shared-config/issues/75)) ([836c442](https://www.github.com/googleapis/java-shared-config/commit/836c44294a3cae9ea38b1464431ebac1bef6633d))

### [0.3.1](https://www.github.com/googleapis/java-shared-config/compare/v0.3.0...v0.3.1) (2020-01-03)


### Bug Fixes

* use surefire-junit47 provider for surefire/failsafe plugins ([#81](https://www.github.com/googleapis/java-shared-config/issues/81)) ([d3bc105](https://www.github.com/googleapis/java-shared-config/commit/d3bc1057731787578188397dceca58c1389dec08))


### Dependencies

* update dependency org.apache.maven.plugins:maven-enforcer-plugin to v3.0.0-m3 ([#72](https://www.github.com/googleapis/java-shared-config/issues/72)) ([fc10148](https://www.github.com/googleapis/java-shared-config/commit/fc1014801fc17ec26474594ac420fe5c64e7a692))
* update dependency org.apache.maven.plugins:maven-failsafe-plugin to v3.0.0-m4 ([#64](https://www.github.com/googleapis/java-shared-config/issues/64)) ([9ae5d78](https://www.github.com/googleapis/java-shared-config/commit/9ae5d7875bf9a286459ef06a60d35a1f93be971e))
* update dependency org.apache.maven.plugins:maven-source-plugin to v3.2.1 ([#78](https://www.github.com/googleapis/java-shared-config/issues/78)) ([9eb9daf](https://www.github.com/googleapis/java-shared-config/commit/9eb9daf0cf48f19755e1c35e41707d59a8d10a25))
* update dependency org.apache.maven.plugins:maven-surefire-plugin to v3.0.0-m4 ([#65](https://www.github.com/googleapis/java-shared-config/issues/65)) ([48e8ea9](https://www.github.com/googleapis/java-shared-config/commit/48e8ea9dec3587b08a766d27260c9f9a313f6148))
* update dependency org.apache.maven.surefire:surefire-junit4 to v3.0.0-m4 ([#66](https://www.github.com/googleapis/java-shared-config/issues/66)) ([b1086d5](https://www.github.com/googleapis/java-shared-config/commit/b1086d58de1056650906380768fc3c5635d724be))

## [0.3.0](https://www.github.com/googleapis/java-shared-config/compare/v0.2.1...v0.3.0) (2019-11-14)


### Features

* add profile which allows the use of snapshots ([#38](https://www.github.com/googleapis/java-shared-config/issues/38)) ([678d898](https://www.github.com/googleapis/java-shared-config/commit/678d8984fb6663191a2ec1691db723ccf60b0c23))


### Bug Fixes

* bump release staging timeout to 15 minutes ([#42](https://www.github.com/googleapis/java-shared-config/issues/42)) ([3261d94](https://www.github.com/googleapis/java-shared-config/commit/3261d948b6ea941bc81d8c5347d8a37332e5159e))
* only look at src/main and src/test for checkstyle ([#56](https://www.github.com/googleapis/java-shared-config/issues/56)) ([00bbe4c](https://www.github.com/googleapis/java-shared-config/commit/00bbe4cb3ce0c760a7a7a40d7cd10449b2268c43))
* remove autovalue profiles ([#62](https://www.github.com/googleapis/java-shared-config/issues/62)) ([07258db](https://www.github.com/googleapis/java-shared-config/commit/07258dbbc12baa549ac7a3314c7efd3f77703558))


### Dependencies

* update dependency org.apache.maven.plugins:maven-jar-plugin to v3.2.0 ([#59](https://www.github.com/googleapis/java-shared-config/issues/59)) ([ab2f4ba](https://www.github.com/googleapis/java-shared-config/commit/ab2f4ba6b4522e34a277017f9e5bc56bcedab823))
* update dependency org.apache.maven.plugins:maven-source-plugin to v3.2.0 ([#60](https://www.github.com/googleapis/java-shared-config/issues/60)) ([8621c23](https://www.github.com/googleapis/java-shared-config/commit/8621c23260e3751dfc14510d2035fa55685d2d10))
* update dependency org.jacoco:jacoco-maven-plugin to v0.8.5 ([#46](https://www.github.com/googleapis/java-shared-config/issues/46)) ([f2fcc2f](https://www.github.com/googleapis/java-shared-config/commit/f2fcc2f4ba259cda43daeb62b23c943c4c87ac7c))

### [0.2.1](https://www.github.com/googleapis/java-shared-config/compare/v0.2.0...v0.2.1) (2019-10-08)


### Bug Fixes

* specify surefire-junit4 build dependency for offline tests ([#37](https://www.github.com/googleapis/java-shared-config/issues/37)) ([f93f18e](https://www.github.com/googleapis/java-shared-config/commit/f93f18e))

## [0.2.0](https://www.github.com/googleapis/java-shared-config/compare/v0.1.4...v0.2.0) (2019-10-07)


### Features

* enable clirr-maven-plugin ([#34](https://www.github.com/googleapis/java-shared-config/issues/34)) ([48cb08e](https://www.github.com/googleapis/java-shared-config/commit/48cb08e))

### [0.1.3](https://www.github.com/googleapis/java-shared-config/compare/v0.1.2...v0.1.3) (2019-09-20)


### Bug Fixes

* add autovalue profiles ([#26](https://www.github.com/googleapis/java-shared-config/issues/26)) ([895bd68](https://www.github.com/googleapis/java-shared-config/commit/895bd68))
