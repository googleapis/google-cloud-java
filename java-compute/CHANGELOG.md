# Changelog

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
