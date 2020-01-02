# Changelog

### [1.92.1](https://www.github.com/googleapis/java-core/compare/v1.92.0...v1.92.1) (2020-01-02)


### Dependencies

* update dependency com.google.errorprone:error_prone_annotations to v2.3.4 ([#105](https://www.github.com/googleapis/java-core/issues/105)) ([52f47c5](https://www.github.com/googleapis/java-core/commit/52f47c5ed84742b4b41417c486bfbb3c817b4a23))
* update dependency com.google.guava:guava-bom to v28.2-android ([#113](https://www.github.com/googleapis/java-core/issues/113)) ([8b11b1a](https://www.github.com/googleapis/java-core/commit/8b11b1a8d452ab823f35509ae42263c4a69f2a5a))
* update dependency com.google.http-client:google-http-client-bom to v1.34.0 ([#98](https://www.github.com/googleapis/java-core/issues/98)) ([d8e946d](https://www.github.com/googleapis/java-core/commit/d8e946dfd3866380406b02ad908925c4250cc34a))
* update dependency com.google.protobuf:protobuf-bom to v3.11.1 ([#106](https://www.github.com/googleapis/java-core/issues/106)) ([6d36434](https://www.github.com/googleapis/java-core/commit/6d364341bc5552e98590f9344b0e2d8cf4e68f0c))
* update dependency io.grpc:grpc-bom to v1.26.0 ([#107](https://www.github.com/googleapis/java-core/issues/107)) ([fca41a7](https://www.github.com/googleapis/java-core/commit/fca41a73fb6ca42eb4014d3cec6b32cc8e97ded9))

## [1.92.0](https://www.github.com/googleapis/java-core/compare/v1.91.3...v1.92.0) (2019-12-13)


### Features

* increase DEFAULT_CHUNK_SIZE to reduce transfer overhead ([#87](https://www.github.com/googleapis/java-core/issues/87)) ([09b327d](https://www.github.com/googleapis/java-core/commit/09b327daf764403b7800180cab79ae3e38815075))
* support setting ServiceOption for quota project ([#92](https://www.github.com/googleapis/java-core/issues/92)) ([6aa4476](https://www.github.com/googleapis/java-core/commit/6aa4476441fd7636dd116516d3bf4b738cf8a8a9))


### Dependencies

* update dependency com.google.api-client:google-api-client-bom to v1.30.5 ([#68](https://www.github.com/googleapis/java-core/issues/68)) ([e1a4047](https://www.github.com/googleapis/java-core/commit/e1a4047fb470ea4f80459ca0bb399f4ab2c7decf))
* update dependency com.google.api:gax-bom to v1.50.1 ([#73](https://www.github.com/googleapis/java-core/issues/73)) ([f493b5b](https://www.github.com/googleapis/java-core/commit/f493b5bbe5945202af6a94fe01407f795014b4a1))
* update dependency com.google.api:gax-bom to v1.51.0 ([#85](https://www.github.com/googleapis/java-core/issues/85)) ([71d0de7](https://www.github.com/googleapis/java-core/commit/71d0de782432814971facb7cbb67acdec5e45f00))
* update dependency com.google.auth:google-auth-library-bom to v0.19.0 ([#93](https://www.github.com/googleapis/java-core/issues/93)) ([b465630](https://www.github.com/googleapis/java-core/commit/b465630023dc87537a02a34fb957be340aeb6078))
* update dependency com.google.http-client:google-http-client-bom to v1.33.0 ([#71](https://www.github.com/googleapis/java-core/issues/71)) ([8f1e690](https://www.github.com/googleapis/java-core/commit/8f1e690611e98855d0eed26d7ef75120bccc862e))
* update dependency io.grpc:grpc-bom to v1.25.0 ([#72](https://www.github.com/googleapis/java-core/issues/72)) ([3a09fc7](https://www.github.com/googleapis/java-core/commit/3a09fc7c4ce73a3c4f144d0cd4da6d29a1664b75))
* update to threetenbp 1.4.0 ([#89](https://www.github.com/googleapis/java-core/issues/89)) ([5128bd4](https://www.github.com/googleapis/java-core/commit/5128bd45bae8cbb8540eccd683f5bba52783feef))

### [1.91.3](https://www.github.com/googleapis/java-core/compare/v1.91.2...v1.91.3) (2019-10-23)


### Bug Fixes

* try to keep autovalue out of the runtime time classpath ([#48](https://www.github.com/googleapis/java-core/issues/48)) ([0988c27](https://www.github.com/googleapis/java-core/commit/0988c27b01461a0b8c02ac0f9def5b409c56980c))


### Dependencies

* update dependency com.google.api:gax-bom to v1.49.1 ([#65](https://www.github.com/googleapis/java-core/issues/65)) ([131a0fd](https://www.github.com/googleapis/java-core/commit/131a0fd52bebdd217bdcb288374127cef7889692))
* update dependency com.google.api.grpc:proto-google-common-protos to v1.17.0 ([#50](https://www.github.com/googleapis/java-core/issues/50)) ([3ba5512](https://www.github.com/googleapis/java-core/commit/3ba55124247b82061781c4ae0acb08cec239afe4))
* update dependency com.google.auth:google-auth-library-bom to v0.18.0 ([#56](https://www.github.com/googleapis/java-core/issues/56)) ([ab25f15](https://www.github.com/googleapis/java-core/commit/ab25f153021f73b5f0ce5cc2cf0b53d42a1871c7))
* update dependency io.grpc:grpc-bom to v1.24.1 ([07fefbb](https://www.github.com/googleapis/java-core/commit/07fefbb38de93c2b3b5095bc5432bc5161bb7094))

### [1.91.2](https://www.github.com/googleapis/java-core/compare/v1.91.1...v1.91.2) (2019-09-30)


### Dependencies

* update dependency com.google.api.grpc:proto-google-iam-v1 to v0.13.0 ([#40](https://www.github.com/googleapis/java-core/issues/40)) ([4f500cc](https://www.github.com/googleapis/java-core/commit/4f500cc))
* update dependency io.grpc:grpc-bom to v1.24.0 ([#39](https://www.github.com/googleapis/java-core/issues/39)) ([7f6f780](https://www.github.com/googleapis/java-core/commit/7f6f780))
* update errorprone to 2.3.3 ([#43](https://www.github.com/googleapis/java-core/issues/43)) ([232694c](https://www.github.com/googleapis/java-core/commit/232694c))

### [1.91.1](https://www.github.com/googleapis/java-core/compare/v1.91.0...v1.91.1) (2019-09-25)


### Dependencies

* update dependency com.google.api-client:google-api-client-bom to v1.30.4 ([#34](https://www.github.com/googleapis/java-core/issues/34)) ([886eda3](https://www.github.com/googleapis/java-core/commit/886eda3))
* update dependency com.google.auth:google-auth-library-bom to v0.17.2 ([#35](https://www.github.com/googleapis/java-core/issues/35)) ([ae44c72](https://www.github.com/googleapis/java-core/commit/ae44c72))
* update dependency com.google.http-client:google-http-client-bom to v1.32.1 ([#31](https://www.github.com/googleapis/java-core/issues/31)) ([4bdf09b](https://www.github.com/googleapis/java-core/commit/4bdf09b))
* update dependency com.google.protobuf:protobuf-bom to v3.10.0 ([#27](https://www.github.com/googleapis/java-core/issues/27)) ([23e4c26](https://www.github.com/googleapis/java-core/commit/23e4c26))
* update guava to 28.1-android ([#32](https://www.github.com/googleapis/java-core/issues/32)) ([0279479](https://www.github.com/googleapis/java-core/commit/0279479))

## [1.91.0](https://www.github.com/googleapis/java-core/compare/v1.90.0...v1.91.0) (2019-09-18)


### Dependencies

* update dependency com.google.api-client:google-api-client-bom to v1.30.3 ([#21](https://www.github.com/googleapis/java-core/issues/21)) ([fcd67f8](https://www.github.com/googleapis/java-core/commit/fcd67f8))
* update opencensus packages to v0.24.0 ([#22](https://www.github.com/googleapis/java-core/issues/22)) ([4b21afa](https://www.github.com/googleapis/java-core/commit/4b21afa))


### Documentation

* fix Kokoro badge link ([19d79d6](https://www.github.com/googleapis/java-core/commit/19d79d6))
* fix README versions and CI Status table ([6e3ccf3](https://www.github.com/googleapis/java-core/commit/6e3ccf3))
* update README with a better project description ([#17](https://www.github.com/googleapis/java-core/issues/17)) ([018d4d5](https://www.github.com/googleapis/java-core/commit/018d4d5))


### Features

* add google-cloud-core-bom artifact ([#13](https://www.github.com/googleapis/java-core/issues/13)) ([3cb19a0](https://www.github.com/googleapis/java-core/commit/3cb19a0))
