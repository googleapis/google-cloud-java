# Changelog

## [2.4.0](https://github.com/googleapis/google-cloud-java/compare/google-cloud-assured-workloads-v2.3.0...google-cloud-assured-workloads-v2.4.0) (2022-10-13)


### Features

* [analyticsdata] add `subject_to_thresholding` field to `ResponseMetadata` type ([#8545](https://github.com/googleapis/google-cloud-java/issues/8545)) ([8fdc6c1](https://github.com/googleapis/google-cloud-java/commit/8fdc6c1f10f88f30f4d1407579d645f75366b4cf))
* [assuredworkloads] add apis for AssuredWorkload monitoring feature and to restrict allowed resources ([#8497](https://github.com/googleapis/google-cloud-java/issues/8497)) ([7e2cc1f](https://github.com/googleapis/google-cloud-java/commit/7e2cc1fa4bca6d0db7f7232d786a80fd0453170c))
* [assuredworkloads] Add compliant_but_disallowed_services field to the v1beta1 Workload proto ([#8283](https://github.com/googleapis/google-cloud-java/issues/8283)) ([5514be6](https://github.com/googleapis/google-cloud-java/commit/5514be6efc3cc6b293cfd0cc960b068dc7c59fd8))
* add `tokens_per_project_per_hour` field to `PropertyQuota` type ([8fdc6c1](https://github.com/googleapis/google-cloud-java/commit/8fdc6c1f10f88f30f4d1407579d645f75366b4cf))


### Bug Fixes

* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.2 ([#8325](https://github.com/googleapis/google-cloud-java/issues/8325)) ([01f492b](https://github.com/googleapis/google-cloud-java/commit/01f492be424acdb90edb23ba66656aeff7cf39eb))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.4 ([#8528](https://github.com/googleapis/google-cloud-java/issues/8528)) ([bd36199](https://github.com/googleapis/google-cloud-java/commit/bd361998ac4eb7c78eef3b3eac39aef31a0cf44e))
* owl-bot-staging should not be commited ([#8337](https://github.com/googleapis/google-cloud-java/issues/8337)) ([c9bb4a9](https://github.com/googleapis/google-cloud-java/commit/c9bb4a97aa19032b78c86c951fe9920f24ac4eec))
* revert reverting [Many APIs] Update WORKSPACE files for rules_gapic, gax_java, generator_java versions ([#8340](https://github.com/googleapis/google-cloud-java/issues/8340)) ([dedef71](https://github.com/googleapis/google-cloud-java/commit/dedef71f600e85b1c38e7110f5ffd44bf2ba32b4))


### Dependencies

* reverting renovate bot pull requests ([#8417](https://github.com/googleapis/google-cloud-java/issues/8417)) ([8f0c60b](https://github.com/googleapis/google-cloud-java/commit/8f0c60bde446acccc665eb7894723632eefc3503))


### Documentation

* regenerate java-gke-connect-gateway generated samples ([#8569](https://github.com/googleapis/google-cloud-java/issues/8569)) ([f6506b9](https://github.com/googleapis/google-cloud-java/commit/f6506b92183cc9f1851c9f06778736b38b58f47d))

## [2.3.0](https://github.com/googleapis/java-assured-workloads/compare/v2.2.1...v2.3.0) (2022-10-03)


### Features

* Add apis for AssuredWorkload monitoring feature and to restrict allowed resources ([#485](https://github.com/googleapis/java-assured-workloads/issues/485)) ([8524235](https://github.com/googleapis/java-assured-workloads/commit/852423579c1be78b8463e3be69a12d90bb9d76fe))

## [2.2.1](https://github.com/googleapis/java-assured-workloads/compare/v2.2.0...v2.2.1) (2022-10-03)


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.4 ([#486](https://github.com/googleapis/java-assured-workloads/issues/486)) ([6732c36](https://github.com/googleapis/java-assured-workloads/commit/6732c36872d4a10d40f1172cd22b5bf2b61331dc))

## [2.2.0](https://github.com/googleapis/java-assured-workloads/compare/v2.1.0...v2.2.0) (2022-09-15)


### Features

* Add compliant_but_disallowed_services field to the v1beta1 Workload proto ([#476](https://github.com/googleapis/java-assured-workloads/issues/476)) ([99b72cd](https://github.com/googleapis/java-assured-workloads/commit/99b72cdf8d8e37014ebde8cd77c0557d7da23944))
* Updated v1beta1 analyzeWorkloadMove documentation ([#473](https://github.com/googleapis/java-assured-workloads/issues/473)) ([ad0ba84](https://github.com/googleapis/java-assured-workloads/commit/ad0ba843fadaa1629a4ea13dd0cff1cc797dec7f))


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.2 ([#478](https://github.com/googleapis/java-assured-workloads/issues/478)) ([518155d](https://github.com/googleapis/java-assured-workloads/commit/518155da34e6c707321a1e76dde2e2929a94822b))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.3 ([#480](https://github.com/googleapis/java-assured-workloads/issues/480)) ([4f07128](https://github.com/googleapis/java-assured-workloads/commit/4f07128cea08e7b8f91cfe1b1f51bd39e51bc8b4))

## [2.1.0](https://github.com/googleapis/java-assured-workloads/compare/v2.0.1...v2.1.0) (2022-08-09)


### Features

* Updated the method signature of analyzeWorkloadMove for v1beta API to accept project as source. AnalyzeWorkloadMove now also returns information about org policy differences between the project and target folder ([#463](https://github.com/googleapis/java-assured-workloads/issues/463)) ([07f3ff5](https://github.com/googleapis/java-assured-workloads/commit/07f3ff5896a92a1ed60414614987ad7273434124))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v3 ([#466](https://github.com/googleapis/java-assured-workloads/issues/466)) ([6564dd0](https://github.com/googleapis/java-assured-workloads/commit/6564dd05621706511b5d421ac992a3f57824f732))

## [2.0.1](https://github.com/googleapis/java-assured-workloads/compare/v2.0.0...v2.0.1) (2022-07-13)


### Bug Fixes

* enable longpaths support for windows test ([#1485](https://github.com/googleapis/java-assured-workloads/issues/1485)) ([#458](https://github.com/googleapis/java-assured-workloads/issues/458)) ([4bcf11d](https://github.com/googleapis/java-assured-workloads/commit/4bcf11d618503e4902283d0bac5bf2c50a0191d4))

## [2.0.0](https://github.com/googleapis/java-assured-workloads/compare/v1.1.0...v2.0.0) (2022-07-01)


### ⚠ BREAKING CHANGES

* proto file name is changed from assuredworkloads_v1beta1.proto to assuredworkloads.proto

### Features

* Enable REST transport for most of Java and Go clients ([#448](https://github.com/googleapis/java-assured-workloads/issues/448)) ([9ccf283](https://github.com/googleapis/java-assured-workloads/commit/9ccf283f7221c66cd31dd479997050b1e827b48c))
* ITAR June Preview Launch ([#453](https://github.com/googleapis/java-assured-workloads/issues/453)) ([bf926c7](https://github.com/googleapis/java-assured-workloads/commit/bf926c7d26e2cb82b92f9d40a235c71d0ca70772))
* Removed _v1beta1 suffix from proto file names ([#443](https://github.com/googleapis/java-assured-workloads/issues/443)) ([f034f3d](https://github.com/googleapis/java-assured-workloads/commit/f034f3d6274fe486fc99cbbc37fe4571dc383e55))


### Bug Fixes

* update gapic-generator-java with mock service generation fixes ([#450](https://github.com/googleapis/java-assured-workloads/issues/450)) ([a6c6d15](https://github.com/googleapis/java-assured-workloads/commit/a6c6d1549acfb179c1295d2359064670d52ed1a4))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.13.0 ([#447](https://github.com/googleapis/java-assured-workloads/issues/447)) ([23477f6](https://github.com/googleapis/java-assured-workloads/commit/23477f60013e1d00dd49bcd91daa6560169dcc3c))

## [1.1.0](https://github.com/googleapis/java-assured-workloads/compare/v1.0.4...v1.1.0) (2022-05-24)


### Features

* add build scripts for native image testing in Java 17 ([#1440](https://github.com/googleapis/java-assured-workloads/issues/1440)) ([#438](https://github.com/googleapis/java-assured-workloads/issues/438)) ([67a3c7e](https://github.com/googleapis/java-assured-workloads/commit/67a3c7e274eb2b8ca832f7139fbd593b0babab76))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.12.0 ([#437](https://github.com/googleapis/java-assured-workloads/issues/437)) ([549a6e0](https://github.com/googleapis/java-assured-workloads/commit/549a6e0607186c9e6abb1658bcdac56f92500df4))

### [1.0.4](https://github.com/googleapis/java-assured-workloads/compare/v1.0.3...v1.0.4) (2022-04-15)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.10.0 ([#425](https://github.com/googleapis/java-assured-workloads/issues/425)) ([32e57ee](https://github.com/googleapis/java-assured-workloads/commit/32e57eeec6cfb77a06e6f17109d5c614ba392e3d))

### [1.0.3](https://github.com/googleapis/java-assured-workloads/compare/v1.0.2...v1.0.3) (2022-03-29)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.9.0 ([#420](https://github.com/googleapis/java-assured-workloads/issues/420)) ([005ec06](https://github.com/googleapis/java-assured-workloads/commit/005ec06d7564bba78c9616b3de92c8ac9fa763a5))

### [1.0.2](https://github.com/googleapis/java-assured-workloads/compare/v1.0.1...v1.0.2) (2022-03-02)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.8.0 ([#412](https://github.com/googleapis/java-assured-workloads/issues/412)) ([e5f1e59](https://github.com/googleapis/java-assured-workloads/commit/e5f1e591163615f8c49fa1839b27aa2dcb3b764f))

### [1.0.1](https://github.com/googleapis/java-assured-workloads/compare/v1.0.0...v1.0.1) (2022-02-11)


### Dependencies

* update actions/github-script action to v6 ([#399](https://github.com/googleapis/java-assured-workloads/issues/399)) ([3c5c44f](https://github.com/googleapis/java-assured-workloads/commit/3c5c44f1d89154c32983f9f61673cbbd4ae449b7))

## [1.0.0](https://github.com/googleapis/java-assured-workloads/compare/v0.8.0...v1.0.0) (2022-02-03)


### Features

* promote to GA ([#385](https://github.com/googleapis/java-assured-workloads/issues/385)) ([079376f](https://github.com/googleapis/java-assured-workloads/commit/079376fce67f02fc4f20957770ab9446abf07cc5))


### Dependencies

* **java:** update actions/github-script action to v5 ([#1339](https://github.com/googleapis/java-assured-workloads/issues/1339)) ([#388](https://github.com/googleapis/java-assured-workloads/issues/388)) ([f149440](https://github.com/googleapis/java-assured-workloads/commit/f149440fcb28b62b410d33205f6d2a6fc311d635))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.7.0 ([#390](https://github.com/googleapis/java-assured-workloads/issues/390)) ([482fd03](https://github.com/googleapis/java-assured-workloads/commit/482fd03184c305b9f1847dd4d127ce4f7abf4f1b))

## [0.8.0](https://www.github.com/googleapis/java-assured-workloads/compare/v0.7.2...v0.8.0) (2022-01-07)


### Features

* EU Regions and Support With Sovereign Controls ([#367](https://www.github.com/googleapis/java-assured-workloads/issues/367)) ([5ec571c](https://www.github.com/googleapis/java-assured-workloads/commit/5ec571c9b437a44b12c7909387c7e87e7bed0ebd))


### Bug Fixes

* **java:** run Maven in plain console-friendly mode ([#1301](https://www.github.com/googleapis/java-assured-workloads/issues/1301)) ([#371](https://www.github.com/googleapis/java-assured-workloads/issues/371)) ([354bef1](https://www.github.com/googleapis/java-assured-workloads/commit/354bef1f67e2c75ca40356538a9d880ff98eb4ea))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.6.0 ([#374](https://www.github.com/googleapis/java-assured-workloads/issues/374)) ([eae7eec](https://www.github.com/googleapis/java-assured-workloads/commit/eae7eec5c5c35b358b54a5b19d94cdc6ef0819cf))

### [0.7.2](https://www.github.com/googleapis/java-assured-workloads/compare/v0.7.1...v0.7.2) (2021-12-06)


### Bug Fixes

* **java:** add -ntp flag to native image testing command ([#1299](https://www.github.com/googleapis/java-assured-workloads/issues/1299)) ([#364](https://www.github.com/googleapis/java-assured-workloads/issues/364)) ([eeb8c10](https://www.github.com/googleapis/java-assured-workloads/commit/eeb8c1046c6ffd46fb53012421b865d1c31456c3))
* **java:** java 17 dependency arguments ([#1266](https://www.github.com/googleapis/java-assured-workloads/issues/1266)) ([#348](https://www.github.com/googleapis/java-assured-workloads/issues/348)) ([e76620e](https://www.github.com/googleapis/java-assured-workloads/commit/e76620ed19fae9393d8ded3aeaf9e9f57cd31703))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.5.0 ([#358](https://www.github.com/googleapis/java-assured-workloads/issues/358)) ([aa3b0a1](https://www.github.com/googleapis/java-assured-workloads/commit/aa3b0a1131b9d585904a1bb2657fba9a1a13b719))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.5.1 ([#363](https://www.github.com/googleapis/java-assured-workloads/issues/363)) ([d206024](https://www.github.com/googleapis/java-assured-workloads/commit/d2060248e688db405076f37cba611333ba704c05))

### [0.7.1](https://www.github.com/googleapis/java-assured-workloads/compare/v0.7.0...v0.7.1) (2021-10-19)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.4.0 ([#342](https://www.github.com/googleapis/java-assured-workloads/issues/342)) ([cbe7877](https://www.github.com/googleapis/java-assured-workloads/commit/cbe7877feb6b5fdd60e016df789da2a0413ed16f))

## [0.7.0](https://www.github.com/googleapis/java-assured-workloads/compare/v0.6.0...v0.7.0) (2021-09-27)


### Features

* assuredworkloads v1 public protos ([#327](https://www.github.com/googleapis/java-assured-workloads/issues/327)) ([8367a63](https://www.github.com/googleapis/java-assured-workloads/commit/8367a63846b7b98654b00c29dcd64d7435fcfd39))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.3.0 ([#331](https://www.github.com/googleapis/java-assured-workloads/issues/331)) ([f9053ee](https://www.github.com/googleapis/java-assured-workloads/commit/f9053eec594249a5e3a74cfd51ac2e234cdca25a))

## [0.6.0](https://www.github.com/googleapis/java-assured-workloads/compare/v0.5.2...v0.6.0) (2021-09-14)


### Features

* Add Canada Regions And Support compliance regime ([#308](https://www.github.com/googleapis/java-assured-workloads/issues/308)) ([d949e0e](https://www.github.com/googleapis/java-assured-workloads/commit/d949e0e940752265388e9e60a973430e301e8a78))
* display_name is added to ResourceSettings ([d949e0e](https://www.github.com/googleapis/java-assured-workloads/commit/d949e0e940752265388e9e60a973430e301e8a78))
* Remove use of deprecated gradle command in java README ([#1196](https://www.github.com/googleapis/java-assured-workloads/issues/1196)) ([#309](https://www.github.com/googleapis/java-assured-workloads/issues/309)) ([872e8e6](https://www.github.com/googleapis/java-assured-workloads/commit/872e8e620024b0bee075439dad8e51aabd94e882))
* resource_settings is added to CreateWorkloadOperationMetadata ([d949e0e](https://www.github.com/googleapis/java-assured-workloads/commit/d949e0e940752265388e9e60a973430e301e8a78))
* ResourceType CONSUMER_FOLDER and KEYRING are added ([d949e0e](https://www.github.com/googleapis/java-assured-workloads/commit/d949e0e940752265388e9e60a973430e301e8a78))


### Bug Fixes

* billing_account is now optional in Workload ([d949e0e](https://www.github.com/googleapis/java-assured-workloads/commit/d949e0e940752265388e9e60a973430e301e8a78))
* ResourceType CONSUMER_PROJECT is deprecated ([d949e0e](https://www.github.com/googleapis/java-assured-workloads/commit/d949e0e940752265388e9e60a973430e301e8a78))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.2.0 ([#311](https://www.github.com/googleapis/java-assured-workloads/issues/311)) ([281a61a](https://www.github.com/googleapis/java-assured-workloads/commit/281a61a6004aaaf709b0250526e2372fc65a1195))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.2.1 ([#319](https://www.github.com/googleapis/java-assured-workloads/issues/319)) ([faa1336](https://www.github.com/googleapis/java-assured-workloads/commit/faa133609cd87a7806c734620350b90a6242f02e))

## [0.6.0](https://www.github.com/googleapis/java-assured-workloads/compare/v0.5.2...v0.6.0) (2021-09-14)


### Features

* Add Canada Regions And Support compliance regime ([#308](https://www.github.com/googleapis/java-assured-workloads/issues/308)) ([d949e0e](https://www.github.com/googleapis/java-assured-workloads/commit/d949e0e940752265388e9e60a973430e301e8a78))
* display_name is added to ResourceSettings ([d949e0e](https://www.github.com/googleapis/java-assured-workloads/commit/d949e0e940752265388e9e60a973430e301e8a78))
* Remove use of deprecated gradle command in java README ([#1196](https://www.github.com/googleapis/java-assured-workloads/issues/1196)) ([#309](https://www.github.com/googleapis/java-assured-workloads/issues/309)) ([872e8e6](https://www.github.com/googleapis/java-assured-workloads/commit/872e8e620024b0bee075439dad8e51aabd94e882))
* resource_settings is added to CreateWorkloadOperationMetadata ([d949e0e](https://www.github.com/googleapis/java-assured-workloads/commit/d949e0e940752265388e9e60a973430e301e8a78))
* ResourceType CONSUMER_FOLDER and KEYRING are added ([d949e0e](https://www.github.com/googleapis/java-assured-workloads/commit/d949e0e940752265388e9e60a973430e301e8a78))


### Bug Fixes

* billing_account is now optional in Workload ([d949e0e](https://www.github.com/googleapis/java-assured-workloads/commit/d949e0e940752265388e9e60a973430e301e8a78))
* ResourceType CONSUMER_PROJECT is deprecated ([d949e0e](https://www.github.com/googleapis/java-assured-workloads/commit/d949e0e940752265388e9e60a973430e301e8a78))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.2.0 ([#311](https://www.github.com/googleapis/java-assured-workloads/issues/311)) ([281a61a](https://www.github.com/googleapis/java-assured-workloads/commit/281a61a6004aaaf709b0250526e2372fc65a1195))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.2.1 ([#319](https://www.github.com/googleapis/java-assured-workloads/issues/319)) ([faa1336](https://www.github.com/googleapis/java-assured-workloads/commit/faa133609cd87a7806c734620350b90a6242f02e))

### [0.5.2](https://www.github.com/googleapis/java-assured-workloads/compare/v0.5.1...v0.5.2) (2021-08-23)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.1.0 ([#301](https://www.github.com/googleapis/java-assured-workloads/issues/301)) ([7dfacdd](https://www.github.com/googleapis/java-assured-workloads/commit/7dfacdd120621b57df423365239cb335ff4fa699))

### [0.5.1](https://www.github.com/googleapis/java-assured-workloads/compare/v0.5.0...v0.5.1) (2021-08-12)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.0.1 ([#294](https://www.github.com/googleapis/java-assured-workloads/issues/294)) ([6ec4dff](https://www.github.com/googleapis/java-assured-workloads/commit/6ec4dff6a83bb586d3bfa2085a63a06f3000d3b0))

## [0.5.0](https://www.github.com/googleapis/java-assured-workloads/compare/v0.4.1...v0.5.0) (2021-08-09)


### ⚠ BREAKING CHANGES

* release gapic-generator-java v2.0.0 (#288)

### Features

* Add EU Regions And Support compliance regime ([#280](https://www.github.com/googleapis/java-assured-workloads/issues/280)) ([66e6aa9](https://www.github.com/googleapis/java-assured-workloads/commit/66e6aa9d76007ac88761cd8d3a90eb7e9056314f))
* release gapic-generator-java v2.0.0 ([#288](https://www.github.com/googleapis/java-assured-workloads/issues/288)) ([c3fb37b](https://www.github.com/googleapis/java-assured-workloads/commit/c3fb37b76c730c08b6a718caac9f494844c01559))


### Bug Fixes

* owlbot post-processor should generate README ([#1154](https://www.github.com/googleapis/java-assured-workloads/issues/1154)) ([#253](https://www.github.com/googleapis/java-assured-workloads/issues/253)) ([1443667](https://www.github.com/googleapis/java-assured-workloads/commit/1443667562ed961664035d6c725534973e64f69a)), closes [#1146](https://www.github.com/googleapis/java-assured-workloads/issues/1146) [#1147](https://www.github.com/googleapis/java-assured-workloads/issues/1147)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2 ([#289](https://www.github.com/googleapis/java-assured-workloads/issues/289)) ([f3d01d8](https://www.github.com/googleapis/java-assured-workloads/commit/f3d01d89551d686206e5d4603450b2611db3178e))

### [0.4.1](https://www.github.com/googleapis/java-assured-workloads/compare/v0.4.0...v0.4.1) (2021-07-01)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.4.0 ([#245](https://www.github.com/googleapis/java-assured-workloads/issues/245)) ([61ad2be](https://www.github.com/googleapis/java-assured-workloads/commit/61ad2be99270be4f2fafa922da5393151637bbb3))

## [0.4.0](https://www.github.com/googleapis/java-assured-workloads/compare/v0.3.2...v0.4.0) (2021-06-23)


### Features

* Add 'resource_settings' field to provide custom properties (ids) for the provisioned projects ([#196](https://www.github.com/googleapis/java-assured-workloads/issues/196)) ([74290c4](https://www.github.com/googleapis/java-assured-workloads/commit/74290c48c4e3f45cdab2722f9b84fc5fecdc4d72))
* add `gcf-owl-bot[bot]` to `ignoreAuthors` ([#226](https://www.github.com/googleapis/java-assured-workloads/issues/226)) ([aa47373](https://www.github.com/googleapis/java-assured-workloads/commit/aa47373d1384e876ec8f5affe0ebe511e75b612c))
* add HIPAA and HITRUST compliance regimes ([#199](https://www.github.com/googleapis/java-assured-workloads/issues/199)) ([ade2142](https://www.github.com/googleapis/java-assured-workloads/commit/ade2142a127abe6af89d177b99e5737102048672))


### Bug Fixes

* Add `shopt -s nullglob` to dependencies script ([#1130](https://www.github.com/googleapis/java-assured-workloads/issues/1130)) ([#241](https://www.github.com/googleapis/java-assured-workloads/issues/241)) ([accfe9b](https://www.github.com/googleapis/java-assured-workloads/commit/accfe9b9b3185d73e44a02f61a5f4c7d5159f964))
* release scripts from issuing overlapping phases ([#210](https://www.github.com/googleapis/java-assured-workloads/issues/210)) ([5259316](https://www.github.com/googleapis/java-assured-workloads/commit/5259316954f32c6aece20bee0d66bceb1c854338))
* typo ([#208](https://www.github.com/googleapis/java-assured-workloads/issues/208)) ([717be88](https://www.github.com/googleapis/java-assured-workloads/commit/717be889a31625d283afce85cfa40dc04e2b6442))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.21.0 ([#205](https://www.github.com/googleapis/java-assured-workloads/issues/205)) ([dacb240](https://www.github.com/googleapis/java-assured-workloads/commit/dacb240d3740f52c3b58847091a7d3dd1ebf1af7))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.21.1 ([#211](https://www.github.com/googleapis/java-assured-workloads/issues/211)) ([04a854e](https://www.github.com/googleapis/java-assured-workloads/commit/04a854e599adb02b64f553ebdf59af29d79530db))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1 ([#214](https://www.github.com/googleapis/java-assured-workloads/issues/214)) ([a1b6697](https://www.github.com/googleapis/java-assured-workloads/commit/a1b6697a51347eabecf9e6f0e2f9eecf75ec2774))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.1.0 ([#222](https://www.github.com/googleapis/java-assured-workloads/issues/222)) ([1bf4802](https://www.github.com/googleapis/java-assured-workloads/commit/1bf48020447b3404e0a02b561416f17f799f534f))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.2.0 ([#225](https://www.github.com/googleapis/java-assured-workloads/issues/225)) ([812753c](https://www.github.com/googleapis/java-assured-workloads/commit/812753c0e6ef01c199c48d0d40de1e939b3dacfb))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.3.0 ([#231](https://www.github.com/googleapis/java-assured-workloads/issues/231)) ([f7bc33c](https://www.github.com/googleapis/java-assured-workloads/commit/f7bc33c3c422600baead459892abea9c356ec7f9))

### [0.3.2](https://www.github.com/googleapis/java-assured-workloads/compare/v0.3.1...v0.3.2) (2021-03-17)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.20.1 ([#190](https://www.github.com/googleapis/java-assured-workloads/issues/190)) ([5018f2e](https://www.github.com/googleapis/java-assured-workloads/commit/5018f2eca505a9f1e014f9e8a3b4cfedc11dcd57))

### [0.3.1](https://www.github.com/googleapis/java-assured-workloads/compare/v0.3.0...v0.3.1) (2021-02-25)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.20.0 ([#181](https://www.github.com/googleapis/java-assured-workloads/issues/181)) ([3369ac1](https://www.github.com/googleapis/java-assured-workloads/commit/3369ac15512815fa7d574719a726d76c4cf655ef))

## [0.3.0](https://www.github.com/googleapis/java-assured-workloads/compare/v0.2.2...v0.3.0) (2021-02-24)


### Features

* add US_REGIONAL_ACCESS to create workloads with compliance regime ([#154](https://www.github.com/googleapis/java-assured-workloads/issues/154)) ([afe69be](https://www.github.com/googleapis/java-assured-workloads/commit/afe69be2ff36bcf0c0a248d7660fb190f7be2e1e))
* generate sample code in the Java microgenerator ([#170](https://www.github.com/googleapis/java-assured-workloads/issues/170)) ([61624c6](https://www.github.com/googleapis/java-assured-workloads/commit/61624c6652c6ccc77be61eb07b214f6a303671f5))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.19.0 ([#175](https://www.github.com/googleapis/java-assured-workloads/issues/175)) ([8122a56](https://www.github.com/googleapis/java-assured-workloads/commit/8122a5694591c6d7e5d905443a6d6842ec86a940))

### [0.2.2](https://www.github.com/googleapis/java-assured-workloads/compare/v0.2.1...v0.2.2) (2021-01-14)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.18.0 ([#150](https://www.github.com/googleapis/java-assured-workloads/issues/150)) ([08b999a](https://www.github.com/googleapis/java-assured-workloads/commit/08b999a1ad5505dfbd9532528e00e4b823a7b48c))

### [0.2.1](https://www.github.com/googleapis/java-assured-workloads/compare/v0.2.0...v0.2.1) (2020-12-15)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.17.0 ([#142](https://www.github.com/googleapis/java-assured-workloads/issues/142)) ([baeb02f](https://www.github.com/googleapis/java-assured-workloads/commit/baeb02faf95a5f8696162226a6d4aab8bf5f9edb))

## [0.2.0](https://www.github.com/googleapis/java-assured-workloads/compare/v0.1.4...v0.2.0) (2020-12-14)


### Features

* **v1beta1:** add provisioned_resources_parent and kms_settings to Workload ([#124](https://www.github.com/googleapis/java-assured-workloads/issues/124)) ([ca9e772](https://www.github.com/googleapis/java-assured-workloads/commit/ca9e77206ac70df0a5a800fee00a45b5427cba1c))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.15.0 ([#121](https://www.github.com/googleapis/java-assured-workloads/issues/121)) ([95bab45](https://www.github.com/googleapis/java-assured-workloads/commit/95bab4539244e30950251ca24ae7df3f75dc379b))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.16.0 ([#132](https://www.github.com/googleapis/java-assured-workloads/issues/132)) ([b49b319](https://www.github.com/googleapis/java-assured-workloads/commit/b49b319ef90a02da2cb7dcc762aa84f09624e0ce))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.16.1 ([a267605](https://www.github.com/googleapis/java-assured-workloads/commit/a26760597bbf90b0212a98f9b48a7bb326a0dbe7))

### [0.1.4](https://www.github.com/googleapis/java-assured-workloads/compare/v0.1.3...v0.1.4) (2020-11-02)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.14.1 ([#85](https://www.github.com/googleapis/java-assured-workloads/issues/85)) ([5570b1e](https://www.github.com/googleapis/java-assured-workloads/commit/5570b1e2a4c7ff89a44d6cbfc6d7d0540d3c35f5))

### [0.1.3](https://www.github.com/googleapis/java-assured-workloads/compare/v0.1.2...v0.1.3) (2020-10-21)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.13.0 ([#51](https://www.github.com/googleapis/java-assured-workloads/issues/51)) ([71f129d](https://www.github.com/googleapis/java-assured-workloads/commit/71f129d5a5d5a138ebdd2628d29fd355870a36cc))

### [0.1.2](https://www.github.com/googleapis/java-assured-workloads/compare/v0.1.1...v0.1.2) (2020-10-19)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.12.1 ([#40](https://www.github.com/googleapis/java-assured-workloads/issues/40)) ([98150d0](https://www.github.com/googleapis/java-assured-workloads/commit/98150d068ff5d5097e8df23fe10e0aa0904dcbc3))

### [0.1.1](https://www.github.com/googleapis/java-assured-workloads/compare/v0.1.0...v0.1.1) (2020-10-09)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.10.2 ([#24](https://www.github.com/googleapis/java-assured-workloads/issues/24)) ([e96e5c2](https://www.github.com/googleapis/java-assured-workloads/commit/e96e5c2da5a24c90eab952dc52df70d0da41288f))

## 0.1.0 (2020-09-23)


### Features

* initial code generation ([cb2c4c4](https://www.github.com/googleapis/java-assured-workloads/commit/cb2c4c47c25e8220729c5d22fccc3994f296ce71))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.10.0 ([#14](https://www.github.com/googleapis/java-assured-workloads/issues/14)) ([22dc723](https://www.github.com/googleapis/java-assured-workloads/commit/22dc723bc23226a00caf603f895b1d5999c95ad9))
