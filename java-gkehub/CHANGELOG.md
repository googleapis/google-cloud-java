# Changelog

### [0.5.3](https://www.github.com/googleapis/java-gkehub/compare/v0.5.2...v0.5.3) (2021-12-06)


### Bug Fixes

* **java:** add -ntp flag to native image testing command ([#1299](https://www.github.com/googleapis/java-gkehub/issues/1299)) ([#159](https://www.github.com/googleapis/java-gkehub/issues/159)) ([ffa9bc2](https://www.github.com/googleapis/java-gkehub/commit/ffa9bc2011582611417603e9a73774061f0b36c9))
* **java:** java 17 dependency arguments ([#1266](https://www.github.com/googleapis/java-gkehub/issues/1266)) ([#143](https://www.github.com/googleapis/java-gkehub/issues/143)) ([8d5ff8a](https://www.github.com/googleapis/java-gkehub/commit/8d5ff8a1496b6d5c19dce009f4c19597675db52f))
* remove location proto ([b7e6196](https://www.github.com/googleapis/java-gkehub/commit/b7e619699e1e55a51daef7f0d5d1a752eaa8235e))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.5.0 ([#152](https://www.github.com/googleapis/java-gkehub/issues/152)) ([52f5781](https://www.github.com/googleapis/java-gkehub/commit/52f5781336e5aae1a67ccf9251624ad9776643e4))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.5.1 ([#158](https://www.github.com/googleapis/java-gkehub/issues/158)) ([b7e6196](https://www.github.com/googleapis/java-gkehub/commit/b7e619699e1e55a51daef7f0d5d1a752eaa8235e))

### [0.5.2](https://www.github.com/googleapis/java-gkehub/compare/v0.5.1...v0.5.2) (2021-10-19)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.4.0 ([#138](https://www.github.com/googleapis/java-gkehub/issues/138)) ([0ce199b](https://www.github.com/googleapis/java-gkehub/commit/0ce199b36199f2208baecbf5e1af61e4557ed62b))

### [0.5.1](https://www.github.com/googleapis/java-gkehub/compare/v0.5.0...v0.5.1) (2021-09-22)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.3.0 ([#126](https://www.github.com/googleapis/java-gkehub/issues/126)) ([38d59dd](https://www.github.com/googleapis/java-gkehub/commit/38d59ddd0bba24aae36cde15970b4ebd33e3524f))

## [0.5.0](https://www.github.com/googleapis/java-gkehub/compare/v0.4.0...v0.5.0) (2021-09-14)


### Features

* Add `OnPremCluster` and `MultiCloudCluster` as `GkeCluster` equivalent field ([1beaef5](https://www.github.com/googleapis/java-gkehub/commit/1beaef52df97c981d7aced51b64e146dab46c60d))
* Add `OnPremCluster` and `MultiCloudCluster` as `GkeCluster` equivalent field ([#108](https://www.github.com/googleapis/java-gkehub/issues/108)) ([b9e9611](https://www.github.com/googleapis/java-gkehub/commit/b9e96116bff0c782d43755cb9489d29b63dacb82))
* Add request_id under `DeleteMembershipRequest` and `UpdateMembershipRequest` ([#103](https://www.github.com/googleapis/java-gkehub/issues/103)) ([1beaef5](https://www.github.com/googleapis/java-gkehub/commit/1beaef52df97c981d7aced51b64e146dab46c60d))
* Move `GkeCluster` under oneof ([b9e9611](https://www.github.com/googleapis/java-gkehub/commit/b9e96116bff0c782d43755cb9489d29b63dacb82))
* Remove use of deprecated gradle command in java README ([#1196](https://www.github.com/googleapis/java-gkehub/issues/1196)) ([#107](https://www.github.com/googleapis/java-gkehub/issues/107)) ([59bd4e3](https://www.github.com/googleapis/java-gkehub/commit/59bd4e363b34d3f5755f1d12000a73dbd22901a7))


### Bug Fixes

* Move `GkeCluster` under oneof ([1beaef5](https://www.github.com/googleapis/java-gkehub/commit/1beaef52df97c981d7aced51b64e146dab46c60d))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.0.1 ([#97](https://www.github.com/googleapis/java-gkehub/issues/97)) ([89ef34a](https://www.github.com/googleapis/java-gkehub/commit/89ef34a629e2c629983e97c69e9b97e0bf81857a))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.1.0 ([#101](https://www.github.com/googleapis/java-gkehub/issues/101)) ([14ebe56](https://www.github.com/googleapis/java-gkehub/commit/14ebe56abd9eae08c9a179fdc220a82d39a39e91))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.2.0 ([#110](https://www.github.com/googleapis/java-gkehub/issues/110)) ([332fb25](https://www.github.com/googleapis/java-gkehub/commit/332fb25ba8f5a4398dff6e1a78296b187d640855))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.2.1 ([#120](https://www.github.com/googleapis/java-gkehub/issues/120)) ([9245359](https://www.github.com/googleapis/java-gkehub/commit/9245359d3125a0daa6a24c941ddd81f36c75f0a1))

## [0.4.0](https://www.github.com/googleapis/java-gkehub/compare/v0.3.0...v0.4.0) (2021-08-10)


### ⚠ BREAKING CHANGES

* release gapic-generator-java v2.0.0 (#92)

### Features

* release gapic-generator-java v2.0.0 ([#92](https://www.github.com/googleapis/java-gkehub/issues/92)) ([ee1e841](https://www.github.com/googleapis/java-gkehub/commit/ee1e8412b62c7c2d4c8ce1e4756dd6a174ba481f))


### Bug Fixes

* owlbot post-processor should generate README ([#1154](https://www.github.com/googleapis/java-gkehub/issues/1154)) ([#76](https://www.github.com/googleapis/java-gkehub/issues/76)) ([f11632a](https://www.github.com/googleapis/java-gkehub/commit/f11632aa69da36b409a507634b63f979af423618)), closes [#1146](https://www.github.com/googleapis/java-gkehub/issues/1146) [#1147](https://www.github.com/googleapis/java-gkehub/issues/1147)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2 ([#93](https://www.github.com/googleapis/java-gkehub/issues/93)) ([0f194a7](https://www.github.com/googleapis/java-gkehub/commit/0f194a73231ff99a218a7057b1612170a4f0ad4d))

## [0.3.0](https://www.github.com/googleapis/java-gkehub/compare/v0.2.1...v0.3.0) (2021-07-14)


### Features

* added v1alpha messages and client for gkehub ([ecf6634](https://www.github.com/googleapis/java-gkehub/commit/ecf6634b487555412649bb715500871905fd48c6))
* added v1beta, v1 messages and client for gkehub ([ecf6634](https://www.github.com/googleapis/java-gkehub/commit/ecf6634b487555412649bb715500871905fd48c6))


### Bug Fixes

* Add `shopt -s nullglob` to dependencies script ([#1130](https://www.github.com/googleapis/java-gkehub/issues/1130)) ([#64](https://www.github.com/googleapis/java-gkehub/issues/64)) ([b0c235d](https://www.github.com/googleapis/java-gkehub/commit/b0c235d612de4beb604f2c2e3771748c60e3a3e2))
* add missing dependency configmanagement.proto, cloudauditlogging.proto, metering.proto, multiclusteringress.proto, servicemesh.proto to v1alpha client ([ecf6634](https://www.github.com/googleapis/java-gkehub/commit/ecf6634b487555412649bb715500871905fd48c6))
* add missing dependency configmanagement.proto, metering.proto, multiclusteringress.proto to v1beta client ([ecf6634](https://www.github.com/googleapis/java-gkehub/commit/ecf6634b487555412649bb715500871905fd48c6))
* add missing dependency configmanagement.proto, multiclusteringress.proto to v1 client ([#72](https://www.github.com/googleapis/java-gkehub/issues/72)) ([ecf6634](https://www.github.com/googleapis/java-gkehub/commit/ecf6634b487555412649bb715500871905fd48c6))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.4.0 ([#68](https://www.github.com/googleapis/java-gkehub/issues/68)) ([cdd5a08](https://www.github.com/googleapis/java-gkehub/commit/cdd5a08ea44c287aeb07dce816c88461d4bf94aa))

### [0.2.1](https://www.github.com/googleapis/java-gkehub/compare/v0.2.0...v0.2.1) (2021-06-04)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.3.0 ([#51](https://www.github.com/googleapis/java-gkehub/issues/51)) ([1627fdd](https://www.github.com/googleapis/java-gkehub/commit/1627fdd9e3461f2142e101552c2835956b70d2e1))

## [0.2.0](https://www.github.com/googleapis/java-gkehub/compare/v0.1.0...v0.2.0) (2021-05-26)


### Features

* add `gcf-owl-bot[bot]` to `ignoreAuthors` ([#43](https://www.github.com/googleapis/java-gkehub/issues/43)) ([ccf84e6](https://www.github.com/googleapis/java-gkehub/commit/ccf84e6f85e655f48b67bbeb068dacb531d11f81))


### Bug Fixes

* release scripts from issuing overlapping phases ([#28](https://www.github.com/googleapis/java-gkehub/issues/28)) ([488becc](https://www.github.com/googleapis/java-gkehub/commit/488beccdf89574ce309ef3f7fd0790665bf2c21d))
* typo ([#26](https://www.github.com/googleapis/java-gkehub/issues/26)) ([fe9f389](https://www.github.com/googleapis/java-gkehub/commit/fe9f3898c0c148d94243eaa8712a135ad29d396e))


### Documentation

* update README ([#16](https://www.github.com/googleapis/java-gkehub/issues/16)) ([6a2bc22](https://www.github.com/googleapis/java-gkehub/commit/6a2bc22b344720259ebbaf9b886d2d5b280c5a15))
* update README ([#19](https://www.github.com/googleapis/java-gkehub/issues/19)) ([b074555](https://www.github.com/googleapis/java-gkehub/commit/b07455531dccf9e70e302056f2ac210eb291457e))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.21.0 ([#24](https://www.github.com/googleapis/java-gkehub/issues/24)) ([57eda90](https://www.github.com/googleapis/java-gkehub/commit/57eda909afb7095f219c55c5fb6b488367e19b90))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.21.1 ([#29](https://www.github.com/googleapis/java-gkehub/issues/29)) ([be96b8b](https://www.github.com/googleapis/java-gkehub/commit/be96b8bffa7fee6b9d68988fe14164bfc0ab6b5e))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1 ([#33](https://www.github.com/googleapis/java-gkehub/issues/33)) ([bf1bb55](https://www.github.com/googleapis/java-gkehub/commit/bf1bb559b3b92db55d299caa612948f113d39d39))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.1.0 ([#39](https://www.github.com/googleapis/java-gkehub/issues/39)) ([0e94e75](https://www.github.com/googleapis/java-gkehub/commit/0e94e7503472aee1edbfccc679af7bd6554ca81f))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.2.0 ([#42](https://www.github.com/googleapis/java-gkehub/issues/42)) ([d82d9dd](https://www.github.com/googleapis/java-gkehub/commit/d82d9dd410f1e770d392dfc7a1e1f4ec5dc2f86a))

## 0.1.0 (2021-03-15)


### Features

* initial code generation ([5baf642](https://www.github.com/googleapis/java-gkehub/commit/5baf6427cf1725553c92cc10dda1bcce45e33e51))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.20.1 ([#5](https://www.github.com/googleapis/java-gkehub/issues/5)) ([49ce588](https://www.github.com/googleapis/java-gkehub/commit/49ce588e52c6112a9cc6c536546e9efb85ec44bd))
