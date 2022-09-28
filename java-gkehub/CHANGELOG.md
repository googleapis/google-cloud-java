# Changelog

## [1.3.5](https://github.com/googleapis/google-cloud-java/compare/google-cloud-gkehub-v1.3.4...google-cloud-gkehub-v1.3.5) (2022-09-28)


### Bug Fixes

* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.2 ([#8325](https://github.com/googleapis/google-cloud-java/issues/8325)) ([01f492b](https://github.com/googleapis/google-cloud-java/commit/01f492be424acdb90edb23ba66656aeff7cf39eb))
* owl-bot-staging should not be commited ([#8337](https://github.com/googleapis/google-cloud-java/issues/8337)) ([c9bb4a9](https://github.com/googleapis/google-cloud-java/commit/c9bb4a97aa19032b78c86c951fe9920f24ac4eec))


### Dependencies

* reverting renovate bot pull requests ([#8417](https://github.com/googleapis/google-cloud-java/issues/8417)) ([8f0c60b](https://github.com/googleapis/google-cloud-java/commit/8f0c60bde446acccc665eb7894723632eefc3503))

## [1.3.2](https://github.com/googleapis/java-gkehub/compare/v1.3.1...v1.3.2) (2022-08-09)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v3 ([#262](https://github.com/googleapis/java-gkehub/issues/262)) ([3014599](https://github.com/googleapis/java-gkehub/commit/3014599c4f8a875c0eb3c6b91bb715fa6e747ae0))

## [1.3.1](https://github.com/googleapis/java-gkehub/compare/v1.3.0...v1.3.1) (2022-07-13)


### Bug Fixes

* enable longpaths support for windows test ([#1485](https://github.com/googleapis/java-gkehub/issues/1485)) ([#256](https://github.com/googleapis/java-gkehub/issues/256)) ([12f8cae](https://github.com/googleapis/java-gkehub/commit/12f8cae5f960e7a0b397241f5bb3c67cda7ac0f9))

## [1.3.0](https://github.com/googleapis/java-gkehub/compare/v1.2.1...v1.3.0) (2022-07-01)


### Features

* add ApplianceCluster as a new membershipEndpoint type ([513887b](https://github.com/googleapis/java-gkehub/commit/513887bb1f89d61da43717c4fcb0b841336afdd2))
* add c++ rules in BUILD file ([513887b](https://github.com/googleapis/java-gkehub/commit/513887bb1f89d61da43717c4fcb0b841336afdd2))
* add ClusterType field in MembershipEndpoint.OnPremCluster ([513887b](https://github.com/googleapis/java-gkehub/commit/513887bb1f89d61da43717c4fcb0b841336afdd2))
* add EdgeCluster as a new membershipEndpoint type ([513887b](https://github.com/googleapis/java-gkehub/commit/513887bb1f89d61da43717c4fcb0b841336afdd2))
* Enable REST transport for most of Java and Go clients ([#237](https://github.com/googleapis/java-gkehub/issues/237)) ([513887b](https://github.com/googleapis/java-gkehub/commit/513887bb1f89d61da43717c4fcb0b841336afdd2))


### Bug Fixes

* update gapic-generator-java with mock service generation fixes ([#249](https://github.com/googleapis/java-gkehub/issues/249)) ([41f6804](https://github.com/googleapis/java-gkehub/commit/41f6804851c718a6714d2d41d0094b1e9cc8136f))

## [1.2.1](https://github.com/googleapis/java-gkehub/compare/v1.2.0...v1.2.1) (2022-06-23)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.13.0 ([#243](https://github.com/googleapis/java-gkehub/issues/243)) ([f512296](https://github.com/googleapis/java-gkehub/commit/f512296c021a891b96af6486d2bb4b8f5665df84))

## [1.2.0](https://github.com/googleapis/java-gkehub/compare/v1.1.2...v1.2.0) (2022-05-24)


### Features

* add build scripts for native image testing in Java 17 ([#1440](https://github.com/googleapis/java-gkehub/issues/1440)) ([#236](https://github.com/googleapis/java-gkehub/issues/236)) ([150b103](https://github.com/googleapis/java-gkehub/commit/150b103d122db7ad5691797ddd25cd01ca43bb7a))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.12.0 ([#235](https://github.com/googleapis/java-gkehub/issues/235)) ([36d67b3](https://github.com/googleapis/java-gkehub/commit/36d67b34fc94fdffdaece8f94c30f0ca92cc321c))

### [1.1.2](https://github.com/googleapis/java-gkehub/compare/v1.1.1...v1.1.2) (2022-04-15)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.10.0 ([#223](https://github.com/googleapis/java-gkehub/issues/223)) ([5a1921b](https://github.com/googleapis/java-gkehub/commit/5a1921bf0dac00b87445ab88f7b2c38fe6e9a426))

### [1.1.1](https://github.com/googleapis/java-gkehub/compare/v1.1.0...v1.1.1) (2022-03-29)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.9.0 ([#218](https://github.com/googleapis/java-gkehub/issues/218)) ([ea26e1a](https://github.com/googleapis/java-gkehub/commit/ea26e1a04c23d556592bf889c0b30ce319df422e))

## [1.1.0](https://github.com/googleapis/java-gkehub/compare/v1.0.1...v1.1.0) (2022-03-08)


### Features

* added support for k8s_version field ([#204](https://github.com/googleapis/java-gkehub/issues/204)) ([c10f8a3](https://github.com/googleapis/java-gkehub/commit/c10f8a3b9e16dacf0b25e4039088d02212a0e10a))


### Documentation

* k8s_version field is not part of resource_options struct ([c10f8a3](https://github.com/googleapis/java-gkehub/commit/c10f8a3b9e16dacf0b25e4039088d02212a0e10a))


### Dependencies

* update actions/setup-java action to v3 ([#205](https://github.com/googleapis/java-gkehub/issues/205)) ([1cfd7b9](https://github.com/googleapis/java-gkehub/commit/1cfd7b98751dc8410f1006a0afca3703465aed03))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.8.0 ([#210](https://github.com/googleapis/java-gkehub/issues/210)) ([da898e4](https://github.com/googleapis/java-gkehub/commit/da898e44ad58b0f66ed6e44bc06689fe6a1abc8c))

### [1.0.1](https://github.com/googleapis/java-gkehub/compare/v1.0.0...v1.0.1) (2022-02-11)


### Dependencies

* update actions/github-script action to v6 ([#196](https://github.com/googleapis/java-gkehub/issues/196)) ([c8a1525](https://github.com/googleapis/java-gkehub/commit/c8a152518d1c1fde5eae874d799d0a9f86db6c37))

## [1.0.0](https://github.com/googleapis/java-gkehub/compare/v0.5.4...v1.0.0) (2022-02-03)


### Features

* promote to GA ([#181](https://github.com/googleapis/java-gkehub/issues/181)) ([cbe1ca6](https://github.com/googleapis/java-gkehub/commit/cbe1ca609fd7dc78dfc7937a7fba74fed527764a))
* add kubernetes_resource field docs: update API annotation


### Bug Fixes

* fix subpackage dependencies in BUILD.bezel ([#186](https://github.com/googleapis/java-gkehub/issues/186)) ([25d0ab4](https://github.com/googleapis/java-gkehub/commit/25d0ab46f8324da7cdd776b553ee89b73627ebf5))
* **java:** run Maven in plain console-friendly mode ([#1301](https://github.com/googleapis/java-gkehub/issues/1301)) ([#164](https://github.com/googleapis/java-gkehub/issues/164)) ([dcb5b93](https://github.com/googleapis/java-gkehub/commit/dcb5b934b2d164330a020d163bcd2e5fa136857b))


### Dependencies

* **java:** update actions/github-script action to v5 ([#1339](https://github.com/googleapis/java-gkehub/issues/1339)) ([#184](https://github.com/googleapis/java-gkehub/issues/184)) ([cede289](https://github.com/googleapis/java-gkehub/commit/cede2896ae30e89369fa08e79a7ebe6e57f1eb5b))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.7.0 ([#187](https://github.com/googleapis/java-gkehub/issues/187)) ([3995bab](https://github.com/googleapis/java-gkehub/commit/3995babe9f8b13772f29672e543eab40cd920687))

### [0.5.4](https://www.github.com/googleapis/java-gkehub/compare/v0.5.3...v0.5.4) (2022-01-07)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.6.0 ([#166](https://www.github.com/googleapis/java-gkehub/issues/166)) ([70d31d7](https://www.github.com/googleapis/java-gkehub/commit/70d31d795140eb6f5d091f808cfbc9f54f362b78))

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
