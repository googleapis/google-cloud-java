# Changelog

### [2.1.4](https://www.github.com/googleapis/java-logging/compare/v2.1.3...v2.1.4) (2021-02-22)


### Documentation

* generate sample code in the Java microgenerator ([#423](https://www.github.com/googleapis/java-logging/issues/423)) ([8649f2f](https://www.github.com/googleapis/java-logging/commit/8649f2fa8d8d730422ea426142fba2bf3ebfec94))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.19.0 ([#439](https://www.github.com/googleapis/java-logging/issues/439)) ([9cd8474](https://www.github.com/googleapis/java-logging/commit/9cd8474fdcd313f08216642254d72de9ce1a3214))

### [2.1.3](https://www.github.com/googleapis/java-logging/compare/v2.1.2...v2.1.3) (2021-01-22)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.17.1 ([#390](https://www.github.com/googleapis/java-logging/issues/390)) ([3054f17](https://www.github.com/googleapis/java-logging/commit/3054f17bb23f9ac99e373d5368f5e18b9668b917))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.18.0 ([#392](https://www.github.com/googleapis/java-logging/issues/392)) ([219a7f8](https://www.github.com/googleapis/java-logging/commit/219a7f85d06327fe0bac4b7c1a36bda17bbb3382))

### [2.1.2](https://www.github.com/googleapis/java-logging/compare/v2.1.1...v2.1.2) (2020-12-15)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.17.0 ([#373](https://www.github.com/googleapis/java-logging/issues/373)) ([af43940](https://www.github.com/googleapis/java-logging/commit/af439404fb7786e8bc1856ee4b03796110677c98))

### [2.1.1](https://www.github.com/googleapis/java-logging/compare/v2.1.0...v2.1.1) (2020-12-14)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.16.1 ([84c8865](https://www.github.com/googleapis/java-logging/commit/84c88659d1a47633bcd545609262f71e747aaaed))

## [2.1.0](https://www.github.com/googleapis/java-logging/compare/v2.0.1...v2.1.0) (2020-12-10)


### Features

* add support for k8s_container resource type ([#207](https://www.github.com/googleapis/java-logging/issues/207)) ([233efcc](https://www.github.com/googleapis/java-logging/commit/233efcce7d08cc66088d367b7fb6c104cb2f3a46))
* fix resourceNames ([#24](https://www.github.com/googleapis/java-logging/issues/24)) ([70242d5](https://www.github.com/googleapis/java-logging/commit/70242d525dc3164c043f86d720e9210af40c6af5))
* Makes remaining LogBucket and LogViews methods public ([#336](https://www.github.com/googleapis/java-logging/issues/336)) ([f3472c2](https://www.github.com/googleapis/java-logging/commit/f3472c27c79740cb62f83eaff66bb48f3e4ac723))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.16.0 ([#350](https://www.github.com/googleapis/java-logging/issues/350)) ([ea92588](https://www.github.com/googleapis/java-logging/commit/ea9258838c66be244c440c76f84e5db729661791))


### Documentation

* specify current version ([#356](https://www.github.com/googleapis/java-logging/issues/356)) ([729b650](https://www.github.com/googleapis/java-logging/commit/729b650ff6a5f5022e5e5a32b0ef7b2c1642858f))

### [2.0.1](https://www.github.com/googleapis/java-logging/compare/v2.0.0...v2.0.1) (2020-11-12)


### Dependencies

* update googleapis/code-suggester action to v1.8.1 ([#321](https://www.github.com/googleapis/java-logging/issues/321)) ([cc303c3](https://www.github.com/googleapis/java-logging/commit/cc303c3494cf10dc611ddd1901b2befcf54f32a4))

## [2.0.0](https://www.github.com/googleapis/java-logging/compare/v1.101.2...v2.0.0) (2020-11-11)


### ⚠ BREAKING CHANGES

* previously if the user called listLogEntries API with no parameters, the query would try to retrieve all log entries, taking up time and eventually crashing on projects with high volume logs. The new behavior complies with gcloud: if no timestamp filter was specified, it appends a filter covering last 24 hours.
* remove Start/EndTime from LogSink, Metadata from LogEntry, implement multipattern resource names (#174)

### Features

* add logging bucket destination for log sinks ([#226](https://www.github.com/googleapis/java-logging/issues/226)) ([ef97aae](https://www.github.com/googleapis/java-logging/commit/ef97aae71c550c4501b231c32d6d58746af4d130))
* expose log exclusion apis ([#162](https://www.github.com/googleapis/java-logging/issues/162)) ([0038828](https://www.github.com/googleapis/java-logging/commit/00388289e2dc379b65d790d3af1fc3520b6843e9))
* remove Start/EndTime from LogSink, Metadata from LogEntry, implement multipattern resource names ([#174](https://www.github.com/googleapis/java-logging/issues/174)) ([d3d2370](https://www.github.com/googleapis/java-logging/commit/d3d2370a5b2ffcf012faba0a1b893a2321d58ba0))
* update retry settings ([#201](https://www.github.com/googleapis/java-logging/issues/201)) ([6b9d382](https://www.github.com/googleapis/java-logging/commit/6b9d3824a1dde94ac6c4b05627737d8605340f1f))
* **deps:** adopt flatten plugin and google-cloud-shared-dependencies ([#191](https://www.github.com/googleapis/java-logging/issues/191)) ([e1ece40](https://www.github.com/googleapis/java-logging/commit/e1ece4063dc1f022b043ed3209cfcae3f8323c71))


### Bug Fixes

* add default time range filter for ListLogEntries API ([#304](https://www.github.com/googleapis/java-logging/issues/304)) ([c2f40df](https://www.github.com/googleapis/java-logging/commit/c2f40df6ed815e2229e0381a993e7e94e2e651fc))
* make TransportChannel autocloseable ([#212](https://www.github.com/googleapis/java-logging/issues/212)) ([e4853b1](https://www.github.com/googleapis/java-logging/commit/e4853b180193f8e5a5c1151917a74745b5dd4427))
* remove usage of deprecated newInstance() method ([#203](https://www.github.com/googleapis/java-logging/issues/203)) ([039d9ba](https://www.github.com/googleapis/java-logging/commit/039d9ba17fff6f9851091166eeba1e7c8d0cd4bc))


### Dependencies

* update core dependencies ([#170](https://www.github.com/googleapis/java-logging/issues/170)) ([5ab9181](https://www.github.com/googleapis/java-logging/commit/5ab9181dd0774a631cd6997cb9d15bff1b83592f))
* update dependency com.google.api:api-common to v1.9.2 ([#169](https://www.github.com/googleapis/java-logging/issues/169)) ([288a894](https://www.github.com/googleapis/java-logging/commit/288a894f3ec0bda774b1fbc6c81690a92c387757))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.10.0 ([#254](https://www.github.com/googleapis/java-logging/issues/254)) ([d63b4b4](https://www.github.com/googleapis/java-logging/commit/d63b4b4198235af54ed84d153be8229469690afa))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.10.2 ([#273](https://www.github.com/googleapis/java-logging/issues/273)) ([870d7d7](https://www.github.com/googleapis/java-logging/commit/870d7d72a8938472354008fc9ea11bc36b5789ad))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.13.0 ([#289](https://www.github.com/googleapis/java-logging/issues/289)) ([1488370](https://www.github.com/googleapis/java-logging/commit/148837000588892f8c92a9d9354a3c30f0b0faad))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.14.1 ([#310](https://www.github.com/googleapis/java-logging/issues/310)) ([cc4b57f](https://www.github.com/googleapis/java-logging/commit/cc4b57f2e50df23bd85045fbd4b00462eb77969a))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.15.0 ([#320](https://www.github.com/googleapis/java-logging/issues/320)) ([e97dda7](https://www.github.com/googleapis/java-logging/commit/e97dda77029ed7cde83b4499e417468adc34ef58))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.6 ([#200](https://www.github.com/googleapis/java-logging/issues/200)) ([a4f19e8](https://www.github.com/googleapis/java-logging/commit/a4f19e8afa78ced9de5b2d2f96231373493e4ca8))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.9.0 ([#224](https://www.github.com/googleapis/java-logging/issues/224)) ([506738c](https://www.github.com/googleapis/java-logging/commit/506738c61b1415edff0cec9970e2f7905b661059))
* update dependency com.google.protobuf:protobuf-bom to v3.12.2 ([#168](https://www.github.com/googleapis/java-logging/issues/168)) ([2732f81](https://www.github.com/googleapis/java-logging/commit/2732f81d932410bc3e39d4add76bac542325a575))

### [1.101.2](https://www.github.com/googleapis/java-logging/compare/v1.101.1...v1.101.2) (2020-06-10)


### Bug Fixes

* remove duplicate classes provided by proto-google-common-protos ([#177](https://www.github.com/googleapis/java-logging/issues/177)) ([08d8639](https://www.github.com/googleapis/java-logging/commit/08d86391250642cbe4bac27b3853fe7f40458cdc))


### Dependencies

* update dependency com.google.api.grpc:proto-google-common-protos to v1.18.0 ([#156](https://www.github.com/googleapis/java-logging/issues/156)) ([84a6ccd](https://www.github.com/googleapis/java-logging/commit/84a6ccde0cf01fc0d7c331300abadfcf4e004b7a))
* update dependency com.google.guava:guava-bom to v29 ([#136](https://www.github.com/googleapis/java-logging/issues/136)) ([8c261a0](https://www.github.com/googleapis/java-logging/commit/8c261a0d3386bf3867fda7cc0eac2e6821639359))
* update dependency com.google.http-client:google-http-client-bom to v1.35.0 ([#153](https://www.github.com/googleapis/java-logging/issues/153)) ([181447a](https://www.github.com/googleapis/java-logging/commit/181447a6b33ed34de16926da008e789ac5570043))
* update dependency com.google.protobuf:protobuf-bom to v3.12.0 ([#165](https://www.github.com/googleapis/java-logging/issues/165)) ([62ec11d](https://www.github.com/googleapis/java-logging/commit/62ec11d0f4be627a291567d356b0912d35b00f99))
* update dependency io.grpc:grpc-bom to v1.29.0 ([#149](https://www.github.com/googleapis/java-logging/issues/149)) ([5841918](https://www.github.com/googleapis/java-logging/commit/5841918619873f500efe000d60bd8d3c5f5ab0d8))
* update dependency org.threeten:threetenbp to v1.4.4 ([#151](https://www.github.com/googleapis/java-logging/issues/151)) ([abeac81](https://www.github.com/googleapis/java-logging/commit/abeac81a3117eb42ec3bfa9bfa1b934a303bc90e))

### [1.101.1](https://www.github.com/googleapis/java-logging/compare/v1.101.0...v1.101.1) (2020-04-07)


### Dependencies

* update core dependencies ([#115](https://www.github.com/googleapis/java-logging/issues/115)) ([cc89e00](https://www.github.com/googleapis/java-logging/commit/cc89e00a7a3d6b1339c73f4de7651da0eebdf411))
* update core dependencies to v1.93.4 ([#131](https://www.github.com/googleapis/java-logging/issues/131)) ([77c5cf6](https://www.github.com/googleapis/java-logging/commit/77c5cf6175936c51acaa3e441baf91e629475ae2))
* update dependency org.threeten:threetenbp to v1.4.3 ([#117](https://www.github.com/googleapis/java-logging/issues/117)) ([1a4ad46](https://www.github.com/googleapis/java-logging/commit/1a4ad461f5e2ac3252b9e287bbc9015eae00e0fa))

## [1.101.0](https://www.github.com/googleapis/java-logging/compare/v1.100.0...v1.101.0) (2020-03-25)


### Features

* add CmekSettings options ([#89](https://www.github.com/googleapis/java-logging/issues/89)) ([f76206d](https://www.github.com/googleapis/java-logging/commit/f76206d6d137fec9e73ef7e93a8b77193d71166c))


### Bug Fixes

* **regen:** undeprecate resourcenames until multi-pattern resource names are available ([#108](https://www.github.com/googleapis/java-logging/issues/108)) ([4ca5895](https://www.github.com/googleapis/java-logging/commit/4ca5895f2bb83fcf1c7ecf908aae1c50d9cd89d9))


### Dependencies

* update core dependencies ([#61](https://www.github.com/googleapis/java-logging/issues/61)) ([a73322c](https://www.github.com/googleapis/java-logging/commit/a73322cb0e8f43eb253a4004189f1e4d387dcb1c))
* update core dependencies ([#85](https://www.github.com/googleapis/java-logging/issues/85)) ([5e61aa7](https://www.github.com/googleapis/java-logging/commit/5e61aa7180934af6b63e845f2d172c6e6d08d0ee))
* update core dependencies ([#92](https://www.github.com/googleapis/java-logging/issues/92)) ([4fe64cc](https://www.github.com/googleapis/java-logging/commit/4fe64cc5fa0c680733e42cfc6d40c9e7aaac77a6))
* update core dependencies to v1.93.1 ([#113](https://www.github.com/googleapis/java-logging/issues/113)) ([2d68fe9](https://www.github.com/googleapis/java-logging/commit/2d68fe9a9653d08eec5427f877848cbc25c47c4b))
* update core deps ([#109](https://www.github.com/googleapis/java-logging/issues/109)) ([75d38f1](https://www.github.com/googleapis/java-logging/commit/75d38f1d6d56605f5d446cc581a5abf96256c3f4))
* update dependency com.google.api:api-common to v1.9.0 ([#120](https://www.github.com/googleapis/java-logging/issues/120)) ([87ebf36](https://www.github.com/googleapis/java-logging/commit/87ebf36b455478357ea1c0185584d5813244ade8))
* update dependency com.google.http-client:google-http-client-bom to v1.34.1 ([#81](https://www.github.com/googleapis/java-logging/issues/81)) ([dacc7db](https://www.github.com/googleapis/java-logging/commit/dacc7db6775a5489f1d43467bbece7fd781e14ba))
* update dependency com.google.http-client:google-http-client-bom to v1.34.2 ([#94](https://www.github.com/googleapis/java-logging/issues/94)) ([55f6936](https://www.github.com/googleapis/java-logging/commit/55f6936f9933d17d29ea5244d93b9460837a7c70))
* update dependency com.google.protobuf:protobuf-bom to v3.11.3 ([#87](https://www.github.com/googleapis/java-logging/issues/87)) ([dee31b3](https://www.github.com/googleapis/java-logging/commit/dee31b386b7b930419013a17cb1ae0399d7a5bdf))
* update dependency com.google.protobuf:protobuf-bom to v3.11.4 ([#95](https://www.github.com/googleapis/java-logging/issues/95)) ([954897e](https://www.github.com/googleapis/java-logging/commit/954897e43c746961d69550644f1dd5a2936d50e5))


### Documentation

* **regen:** update sample code to set total timeout, add API client header test ([#91](https://www.github.com/googleapis/java-logging/issues/91)) ([133a762](https://www.github.com/googleapis/java-logging/commit/133a762a93f0bd2725edc5342eada77459c78896))

## [1.100.0](https://www.github.com/googleapis/java-logging/compare/v1.99.0...v1.100.0) (2020-01-23)


### Features

* add label fullStacktrace ([#40](https://www.github.com/googleapis/java-logging/issues/40)) ([43e1953](https://www.github.com/googleapis/java-logging/commit/43e19533f969d0e2a2c0c31669a4de191e8cd67e))


### Bug Fixes

* support for Cloud Run monitored resource ([#78](https://www.github.com/googleapis/java-logging/issues/78)) ([b3c1b68](https://www.github.com/googleapis/java-logging/commit/b3c1b68712060299c9df5928ec011f556b8340ad)), closes [#71](https://www.github.com/googleapis/java-logging/issues/71)


### Dependencies

* update core dependencies ([#54](https://www.github.com/googleapis/java-logging/issues/54)) ([9ae3410](https://www.github.com/googleapis/java-logging/commit/9ae341087e99edce79d30ddc7d8aa33e347f20d5))
* update dependency com.google.http-client:google-http-client-bom to v1.34.0 ([#45](https://www.github.com/googleapis/java-logging/issues/45)) ([6bab25b](https://www.github.com/googleapis/java-logging/commit/6bab25b334405278de3bae6c9c2b3a88d872f9bd))
* update dependency com.google.protobuf:protobuf-java to v3.11.1 ([eb0befc](https://www.github.com/googleapis/java-logging/commit/eb0befc97a838b2c003851973d53e8530b54b7a7))
* update dependency org.threeten:threetenbp to v1.4.1 ([f560dca](https://www.github.com/googleapis/java-logging/commit/f560dca9466ce13a634da430ff2209234f22096e))
* update libraries-bom to 3.3.0 ([#59](https://www.github.com/googleapis/java-logging/issues/59)) ([91c2a4e](https://www.github.com/googleapis/java-logging/commit/91c2a4e993ae2b60cd6c21ec271e805401724cc1))


### Documentation

* **regen:** updated javadocs from protoc update ([#41](https://www.github.com/googleapis/java-logging/issues/41)) ([63d626c](https://www.github.com/googleapis/java-logging/commit/63d626cb458aeb631fe2e87d83141bfb6e50e2d4))

## [1.99.0](https://www.github.com/googleapis/java-logging/compare/1.98.0...v1.99.0) (2019-11-20)


### Features

* make repo releasable, add parent/bom ([#1](https://www.github.com/googleapis/java-logging/issues/1)) ([1249ea7](https://www.github.com/googleapis/java-logging/commit/1249ea764f2531ad7fc6958fc3df47da5bc004d9))


### Dependencies

* update dependency io.grpc:grpc-bom to v1.25.0 ([#7](https://www.github.com/googleapis/java-logging/issues/7)) ([f602d3b](https://www.github.com/googleapis/java-logging/commit/f602d3b9096e6121a3f776ac50615461af826053))
* use google-cloud-core-bom and update to v1.91.3 ([#15](https://www.github.com/googleapis/java-logging/issues/15)) ([f2c9cb8](https://www.github.com/googleapis/java-logging/commit/f2c9cb86ffd6c604b57e8744de19d4b801f2cf00))
