# Changelog

## [0.14.7](https://github.com/googleapis/google-cloud-java/compare/google-analytics-data-v0.14.6...google-analytics-data-v0.14.7) (2022-09-28)


### Bug Fixes

* **deps:** update dependency com.google.analytics:google-analytics-data-parent to v0.14.4 ([#8267](https://github.com/googleapis/google-cloud-java/issues/8267)) ([76f459f](https://github.com/googleapis/google-cloud-java/commit/76f459fde8a606abed28b6c1dfd084e4bc584fdc))
* **deps:** update dependency com.google.api.grpc:grpc-google-analytics-data-v1alpha to v0.14.4 ([#8268](https://github.com/googleapis/google-cloud-java/issues/8268)) ([013c75d](https://github.com/googleapis/google-cloud-java/commit/013c75d1adfc5380af531527760c3fe03c93bb1a))
* **deps:** update dependency com.google.api.grpc:grpc-google-analytics-data-v1beta to v0.14.4 ([#8269](https://github.com/googleapis/google-cloud-java/issues/8269)) ([c5b4236](https://github.com/googleapis/google-cloud-java/commit/c5b4236b4c047540994eb5bf115e90403e6d3e1a))
* **deps:** update dependency com.google.api.grpc:proto-google-analytics-data-v1alpha to v0.14.4 ([#8278](https://github.com/googleapis/google-cloud-java/issues/8278)) ([c46135a](https://github.com/googleapis/google-cloud-java/commit/c46135a64382ba304c38c30329a1f1b9d15af143))
* **deps:** update dependency com.google.api.grpc:proto-google-analytics-data-v1beta to v0.14.4 ([#8279](https://github.com/googleapis/google-cloud-java/issues/8279)) ([97841fa](https://github.com/googleapis/google-cloud-java/commit/97841fa661aa6395a831e6089a52a52a69e93137))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.2 ([#8325](https://github.com/googleapis/google-cloud-java/issues/8325)) ([01f492b](https://github.com/googleapis/google-cloud-java/commit/01f492be424acdb90edb23ba66656aeff7cf39eb))
* **deps:** update dependency com.google.cloud:libraries-bom to v26.1.1 ([#8254](https://github.com/googleapis/google-cloud-java/issues/8254)) ([e4760da](https://github.com/googleapis/google-cloud-java/commit/e4760da4ac8fa6fa91bc82b90b83d0518eca2692))
* owl-bot-staging should not be commited ([#8337](https://github.com/googleapis/google-cloud-java/issues/8337)) ([c9bb4a9](https://github.com/googleapis/google-cloud-java/commit/c9bb4a97aa19032b78c86c951fe9920f24ac4eec))
* revert reverting [Many APIs] Update WORKSPACE files for rules_gapic, gax_java, generator_java versions ([#8340](https://github.com/googleapis/google-cloud-java/issues/8340)) ([dedef71](https://github.com/googleapis/google-cloud-java/commit/dedef71f600e85b1c38e7110f5ffd44bf2ba32b4))


### Dependencies

* reverting renovate bot pull requests ([#8417](https://github.com/googleapis/google-cloud-java/issues/8417)) ([8f0c60b](https://github.com/googleapis/google-cloud-java/commit/8f0c60bde446acccc665eb7894723632eefc3503))

## [0.14.3](https://github.com/googleapis/java-analytics-data/compare/v0.14.2...v0.14.3) (2022-08-09)


### Dependencies

* update dependency com.google.auth:google-auth-library-oauth2-http to v1.8.1 ([#525](https://github.com/googleapis/java-analytics-data/issues/525)) ([94c015d](https://github.com/googleapis/java-analytics-data/commit/94c015dc36960093476eed77e53dc1fea0c0f693))
* update dependency com.google.auth:google-auth-library-oauth2-http to v1.9.0 ([#533](https://github.com/googleapis/java-analytics-data/issues/533)) ([396a4a3](https://github.com/googleapis/java-analytics-data/commit/396a4a3cd60f06a381e362cb467b61cb03ef3be0))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v3 ([#530](https://github.com/googleapis/java-analytics-data/issues/530)) ([84d1523](https://github.com/googleapis/java-analytics-data/commit/84d1523bfbc315307aeb2b886d88ad863c770368))

## [0.14.2](https://github.com/googleapis/java-analytics-data/compare/v0.14.1...v0.14.2) (2022-07-13)


### Bug Fixes

* enable longpaths support for windows test ([#1485](https://github.com/googleapis/java-analytics-data/issues/1485)) ([#521](https://github.com/googleapis/java-analytics-data/issues/521)) ([8eb30ca](https://github.com/googleapis/java-analytics-data/commit/8eb30ca273b009e05e64b05f83a736a2113b8151))

## [0.14.1](https://github.com/googleapis/java-analytics-data/compare/v0.14.0...v0.14.1) (2022-07-01)


### Dependencies

* update dependency com.google.auth:google-auth-library-oauth2-http to v1.8.0 ([#511](https://github.com/googleapis/java-analytics-data/issues/511)) ([1ba0b23](https://github.com/googleapis/java-analytics-data/commit/1ba0b233425dbbc69e102ed6d25eb0aafab9041c))

## [0.14.0](https://github.com/googleapis/java-analytics-data/compare/v0.13.0...v0.14.0) (2022-07-01)


### ⚠ BREAKING CHANGES

* rename the `funnel_filter` field of the `FunnelFilterExpression` type to `funnel_field_filter`
* rename the type `FunnelFilter` to `FunnelFieldFilter` (#505)

### Features

* Add Java REST transport to analytics, servicecontrol, servicemanagement, serviceusage and langauge APIs ([c864df4](https://github.com/googleapis/java-analytics-data/commit/c864df4d54144195c83948ff695c6c8b671f5807))


### Bug Fixes

* rename the `funnel_filter` field of the `FunnelFilterExpression` type to `funnel_field_filter` ([c864df4](https://github.com/googleapis/java-analytics-data/commit/c864df4d54144195c83948ff695c6c8b671f5807))
* rename the type `FunnelFilter` to `FunnelFieldFilter` ([#505](https://github.com/googleapis/java-analytics-data/issues/505)) ([c864df4](https://github.com/googleapis/java-analytics-data/commit/c864df4d54144195c83948ff695c6c8b671f5807))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.13.0 ([#508](https://github.com/googleapis/java-analytics-data/issues/508)) ([14d8684](https://github.com/googleapis/java-analytics-data/commit/14d86842eb1a67b9144fe2c48ac4e6a92689ef69))

## [0.13.0](https://github.com/googleapis/java-analytics-data/compare/v0.12.0...v0.13.0) (2022-05-19)


### Features

* add build scripts for native image testing in Java 17 ([#1440](https://github.com/googleapis/java-analytics-data/issues/1440)) ([#496](https://github.com/googleapis/java-analytics-data/issues/496)) ([63d3433](https://github.com/googleapis/java-analytics-data/commit/63d3433a0864f1ce9b807c39361f87cada9b48fd))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.12.0 ([#500](https://github.com/googleapis/java-analytics-data/issues/500)) ([4307f11](https://github.com/googleapis/java-analytics-data/commit/4307f112950508a4912e78aa57c31232e4ce3eae))

## [0.12.0](https://github.com/googleapis/java-analytics-data/compare/v0.11.10...v0.12.0) (2022-05-19)


### Features

* add `runFunnelReport` method to the Alpha version of the Data API ([#490](https://github.com/googleapis/java-analytics-data/issues/490)) ([1969fee](https://github.com/googleapis/java-analytics-data/commit/1969feecac73306525a79e39b7098fdb2a5a05d2))


### Dependencies

* update dependency com.google.auth:google-auth-library-oauth2-http to v1.7.0 ([#492](https://github.com/googleapis/java-analytics-data/issues/492)) ([c09d6a3](https://github.com/googleapis/java-analytics-data/commit/c09d6a3e7bba0ec26ac02e4d1ea928bd7ab64bcb))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.11.0 ([#493](https://github.com/googleapis/java-analytics-data/issues/493)) ([5e5cc70](https://github.com/googleapis/java-analytics-data/commit/5e5cc70bf5ae8d30061a46b50d37347b576650f7))

### [0.11.10](https://github.com/googleapis/java-analytics-data/compare/v0.11.9...v0.11.10) (2022-04-15)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.10.0 ([#478](https://github.com/googleapis/java-analytics-data/issues/478)) ([0346b09](https://github.com/googleapis/java-analytics-data/commit/0346b09955c53309cc4d34497f5f075f73c78a8e))

### [0.11.9](https://github.com/googleapis/java-analytics-data/compare/v0.11.8...v0.11.9) (2022-03-29)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.9.0 ([#459](https://github.com/googleapis/java-analytics-data/issues/459)) ([19ff7fb](https://github.com/googleapis/java-analytics-data/commit/19ff7fb0e2100a7e71d27ce8163540419594a5c2))

### [0.11.8](https://github.com/googleapis/java-analytics-data/compare/v0.11.7...v0.11.8) (2022-03-22)


### Dependencies

* update actions/checkout action to v3 ([#435](https://github.com/googleapis/java-analytics-data/issues/435)) ([35cc323](https://github.com/googleapis/java-analytics-data/commit/35cc32386e17f1b8e8c5116e4453fac8076451b6))

### [0.11.7](https://github.com/googleapis/java-analytics-data/compare/v0.11.6...v0.11.7) (2022-03-21)


### Dependencies

* **sample:** using newer google-analytics-data in snippet ([#452](https://github.com/googleapis/java-analytics-data/issues/452)) ([74446cf](https://github.com/googleapis/java-analytics-data/commit/74446cf387d1f7ef3e1b61cd3a85e0700a874b2d))

### [0.11.6](https://github.com/googleapis/java-analytics-data/compare/v0.11.5...v0.11.6) (2022-03-17)


### Dependencies

* update dependency com.google.auth:google-auth-library-oauth2-http to v1.6.0 ([#448](https://github.com/googleapis/java-analytics-data/issues/448)) ([d07834d](https://github.com/googleapis/java-analytics-data/commit/d07834d29e78493a18b881aee6545f05139388f8))

### [0.11.5](https://github.com/googleapis/java-analytics-data/compare/v0.11.4...v0.11.5) (2022-03-02)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.8.0 ([#436](https://github.com/googleapis/java-analytics-data/issues/436)) ([ea835bc](https://github.com/googleapis/java-analytics-data/commit/ea835bc760850556d731a6adcb41f72a76645cf0))

### [0.11.4](https://github.com/googleapis/java-analytics-data/compare/v0.11.3...v0.11.4) (2022-03-01)


### Dependencies

* update actions/setup-java action to v3 ([#423](https://github.com/googleapis/java-analytics-data/issues/423)) ([9b0c521](https://github.com/googleapis/java-analytics-data/commit/9b0c521b26422dfeb12695b761583851967f5222))

### [0.11.3](https://github.com/googleapis/java-analytics-data/compare/v0.11.2...v0.11.3) (2022-02-28)


### Dependencies

* update dependency com.google.auth:google-auth-library-oauth2-http to v1.5.3 ([#421](https://github.com/googleapis/java-analytics-data/issues/421)) ([99a3382](https://github.com/googleapis/java-analytics-data/commit/99a33829b10b1f56be86690b4218a7ccc7970f0e))

### [0.11.2](https://github.com/googleapis/java-analytics-data/compare/v0.11.1...v0.11.2) (2022-02-11)


### Dependencies

* update actions/github-script action to v6 ([#412](https://github.com/googleapis/java-analytics-data/issues/412)) ([831d07f](https://github.com/googleapis/java-analytics-data/commit/831d07fbe3dff2d7d2519a7c13e977d08dbedcaf))

### [0.11.1](https://github.com/googleapis/java-analytics-data/compare/v0.11.0...v0.11.1) (2022-02-08)


### Dependencies

* **java:** update actions/github-script action to v5 ([#1339](https://github.com/googleapis/java-analytics-data/issues/1339)) ([#400](https://github.com/googleapis/java-analytics-data/issues/400)) ([6784822](https://github.com/googleapis/java-analytics-data/commit/67848224b156a1f4f6a156deb2446604213d9303))
* update dependency com.google.auth:google-auth-library-oauth2-http to v1.4.0 ([#399](https://github.com/googleapis/java-analytics-data/issues/399)) ([7b37e6c](https://github.com/googleapis/java-analytics-data/commit/7b37e6c9ce37e8a9e511c6db8a05aa7d705190d8))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.7.0 ([#402](https://github.com/googleapis/java-analytics-data/issues/402)) ([2c6e3d7](https://github.com/googleapis/java-analytics-data/commit/2c6e3d73bed5fe0cff44061dd1ce7e7f80df4ecc))

## [0.11.0](https://www.github.com/googleapis/java-analytics-data/compare/v0.10.2...v0.11.0) (2022-01-07)


### Features

* add the `schema_restriction_response` field to the `ResponseMetaData` type that contains the schema restrictions actively enforced in creating a report ([#361](https://www.github.com/googleapis/java-analytics-data/issues/361)) ([dba107a](https://www.github.com/googleapis/java-analytics-data/commit/dba107ad76ad5e5ff54c446073f54e39a6ec926a))


### Bug Fixes

* **java:** add -ntp flag to native image testing command ([#1299](https://www.github.com/googleapis/java-analytics-data/issues/1299)) ([#378](https://www.github.com/googleapis/java-analytics-data/issues/378)) ([fd890a0](https://www.github.com/googleapis/java-analytics-data/commit/fd890a019ef695eef15325479b88ab98153c6ce3))
* **java:** java 17 dependency arguments ([#1266](https://www.github.com/googleapis/java-analytics-data/issues/1266)) ([#359](https://www.github.com/googleapis/java-analytics-data/issues/359)) ([96f478d](https://www.github.com/googleapis/java-analytics-data/commit/96f478dd732fa3967b095e28dfaa641ddb458c0f))
* **java:** run Maven in plain console-friendly mode ([#1301](https://www.github.com/googleapis/java-analytics-data/issues/1301)) ([#382](https://www.github.com/googleapis/java-analytics-data/issues/382)) ([96a079f](https://www.github.com/googleapis/java-analytics-data/commit/96a079fbe2b7e31d2f516e80a555a0e6d594717e))
* remove classes for all v1alpha methods ([#345](https://www.github.com/googleapis/java-analytics-data/issues/345)) ([d323fb9](https://www.github.com/googleapis/java-analytics-data/commit/d323fb980cb25be22eb9988e4587c4abaff06681))


### Documentation

* fix docstring formatting ([#368](https://www.github.com/googleapis/java-analytics-data/issues/368)) ([ab58086](https://www.github.com/googleapis/java-analytics-data/commit/ab5808656c6d2ca197e4649764ad64c070d338eb))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.5.0 ([#370](https://www.github.com/googleapis/java-analytics-data/issues/370)) ([bfe02e1](https://www.github.com/googleapis/java-analytics-data/commit/bfe02e118f69477cc06cf614ae9b447e026543e6))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.5.1 ([#377](https://www.github.com/googleapis/java-analytics-data/issues/377)) ([28c9ebc](https://www.github.com/googleapis/java-analytics-data/commit/28c9ebce442d56b2e5ecab10a5306fa7e91fb535))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.6.0 ([#386](https://www.github.com/googleapis/java-analytics-data/issues/386)) ([c7d78d0](https://www.github.com/googleapis/java-analytics-data/commit/c7d78d096b985202e9c0240de53c9f15a4ade5f2))

### [0.10.2](https://www.github.com/googleapis/java-analytics-data/compare/v0.10.1...v0.10.2) (2021-10-19)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.4.0 ([#353](https://www.github.com/googleapis/java-analytics-data/issues/353)) ([45294d9](https://www.github.com/googleapis/java-analytics-data/commit/45294d9183e0cd646d3ab7de68049fd1f0f1d4a6))

### [0.10.1](https://www.github.com/googleapis/java-analytics-data/compare/v0.10.0...v0.10.1) (2021-09-22)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.3.0 ([#338](https://www.github.com/googleapis/java-analytics-data/issues/338)) ([9d17e92](https://www.github.com/googleapis/java-analytics-data/commit/9d17e92ffcf46cfeb18b52475c1b70f5b9385c4b))

## [0.10.0](https://www.github.com/googleapis/java-analytics-data/compare/v0.9.2...v0.10.0) (2021-09-14)


### Features

* Remove use of deprecated gradle command in java README ([#1196](https://www.github.com/googleapis/java-analytics-data/issues/1196)) ([#319](https://www.github.com/googleapis/java-analytics-data/issues/319)) ([a9738c2](https://www.github.com/googleapis/java-analytics-data/commit/a9738c250bc6fe00b647d0b62ad001a3f9e04fa1))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.2.0 ([#322](https://www.github.com/googleapis/java-analytics-data/issues/322)) ([a274776](https://www.github.com/googleapis/java-analytics-data/commit/a27477683a4dedb04b4189b0ddeda54d1f303cb0))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.2.1 ([#332](https://www.github.com/googleapis/java-analytics-data/issues/332)) ([f3fc6b7](https://www.github.com/googleapis/java-analytics-data/commit/f3fc6b7613ef41597178d0f964fae7d873bb2e1d))

### [0.9.2](https://www.github.com/googleapis/java-analytics-data/compare/v0.9.1...v0.9.2) (2021-08-23)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.1.0 ([#313](https://www.github.com/googleapis/java-analytics-data/issues/313)) ([cff72c2](https://www.github.com/googleapis/java-analytics-data/commit/cff72c267b46faa01382d6e9a649cf6f119ffa30))

### [0.9.1](https://www.github.com/googleapis/java-analytics-data/compare/v0.9.0...v0.9.1) (2021-08-12)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.0.1 ([#307](https://www.github.com/googleapis/java-analytics-data/issues/307)) ([10a3888](https://www.github.com/googleapis/java-analytics-data/commit/10a3888d7c2b259b84bfa96de15fef3f38ed0bd5))

## [0.9.0](https://www.github.com/googleapis/java-analytics-data/compare/v0.8.0...v0.9.0) (2021-08-06)


### ⚠ BREAKING CHANGES

* release gapic-generator-java v2.0.0 (#300)

### Features

* add `minute_ranges` field to `RunRealtimeReportRequest` object which can be used to specify the time range (in minutes) for realtime report queries ([#233](https://www.github.com/googleapis/java-analytics-data/issues/233)) ([f99488a](https://www.github.com/googleapis/java-analytics-data/commit/f99488a8630de5cd201ea524027d3cacf0b4b08f))
* release gapic-generator-java v2.0.0 ([#300](https://www.github.com/googleapis/java-analytics-data/issues/300)) ([3f26958](https://www.github.com/googleapis/java-analytics-data/commit/3f269581a86dece46234a47075c74d8883ebaef3))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2 ([#301](https://www.github.com/googleapis/java-analytics-data/issues/301)) ([4172163](https://www.github.com/googleapis/java-analytics-data/commit/4172163883152f300fc69609f0c67b9dc66edae6))

## [0.8.0](https://www.github.com/googleapis/java-analytics-data/compare/v0.7.1...v0.8.0) (2021-07-15)


### Features

* add `gcf-owl-bot[bot]` to `ignoreAuthors` ([#213](https://www.github.com/googleapis/java-analytics-data/issues/213)) ([4791520](https://www.github.com/googleapis/java-analytics-data/commit/479152031b0f2963191c387a8500d83fddaf6624))
* add `kind` field which is used to distinguish between response types feat: add `potentially_thresholded_requests_per_hour` field to `PropertyQuota` ([#182](https://www.github.com/googleapis/java-analytics-data/issues/182)) ([8b30dcd](https://www.github.com/googleapis/java-analytics-data/commit/8b30dcd3132fd5a43955dda3f4c4aaddac2d0035))
* add `potentially_thresholded_requests_per_hour` field to `PropertyQuota` ([c1d3e02](https://www.github.com/googleapis/java-analytics-data/commit/c1d3e02456af734220c88fce4b67e8702583cf1a))
* add kind field which is used to distinguish between responsetypes ([c1d3e02](https://www.github.com/googleapis/java-analytics-data/commit/c1d3e02456af734220c88fce4b67e8702583cf1a))


### Bug Fixes

* Add `shopt -s nullglob` to dependencies script ([#1130](https://www.github.com/googleapis/java-analytics-data/issues/1130)) ([#228](https://www.github.com/googleapis/java-analytics-data/issues/228)) ([f4ea7d3](https://www.github.com/googleapis/java-analytics-data/commit/f4ea7d32ba63a60401940968d00e15ac31f7409c))
* owlbot post-processor should generate README ([#1154](https://www.github.com/googleapis/java-analytics-data/issues/1154)) ([#234](https://www.github.com/googleapis/java-analytics-data/issues/234)) ([89cd9b5](https://www.github.com/googleapis/java-analytics-data/commit/89cd9b51a892cadee81932c3562264c5c6f2a0f8)), closes [#1146](https://www.github.com/googleapis/java-analytics-data/issues/1146) [#1147](https://www.github.com/googleapis/java-analytics-data/issues/1147)
* release scripts from issuing overlapping phases ([#196](https://www.github.com/googleapis/java-analytics-data/issues/196)) ([a17287f](https://www.github.com/googleapis/java-analytics-data/commit/a17287fe5ce6b76f4a55d340c77fba11c9c459b8))
* typo ([#194](https://www.github.com/googleapis/java-analytics-data/issues/194)) ([e62c6ef](https://www.github.com/googleapis/java-analytics-data/commit/e62c6ef3069442fd32727609215521478a07e8ca))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.21.1 ([#197](https://www.github.com/googleapis/java-analytics-data/issues/197)) ([4aba8fa](https://www.github.com/googleapis/java-analytics-data/commit/4aba8fa114b46ca1eefd64f63a5ffe9f1d726dd2))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1 ([#201](https://www.github.com/googleapis/java-analytics-data/issues/201)) ([46af6c8](https://www.github.com/googleapis/java-analytics-data/commit/46af6c80d0c838dcec27087e585c83f7eca50eda))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.1.0 ([#209](https://www.github.com/googleapis/java-analytics-data/issues/209)) ([f15138c](https://www.github.com/googleapis/java-analytics-data/commit/f15138c30e675f56a47480e76ead95193286669e))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.2.0 ([#212](https://www.github.com/googleapis/java-analytics-data/issues/212)) ([f34f92b](https://www.github.com/googleapis/java-analytics-data/commit/f34f92b0869cbd87b7f8909d1a5335e4adbb4851))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.3.0 ([#221](https://www.github.com/googleapis/java-analytics-data/issues/221)) ([1edc82e](https://www.github.com/googleapis/java-analytics-data/commit/1edc82e2a151692805472f87c550df7f0321b190))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.4.0 ([#229](https://www.github.com/googleapis/java-analytics-data/issues/229)) ([f3e97ab](https://www.github.com/googleapis/java-analytics-data/commit/f3e97ab77a5b09879ade1b49fdac067ede5d6a88))

### [0.7.1](https://www.github.com/googleapis/java-analytics-data/compare/v0.7.0...v0.7.1) (2021-04-09)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.21.0 ([#186](https://www.github.com/googleapis/java-analytics-data/issues/186)) ([c7ce3e7](https://www.github.com/googleapis/java-analytics-data/commit/c7ce3e791811a7f6740f7961ccc1831c875d3186))

## [0.7.0](https://www.github.com/googleapis/java-analytics-data/compare/v0.6.0...v0.7.0) (2021-03-16)


### ⚠ BREAKING CHANGES

* rename the 'page_size', 'page_token', 'total_size' fields to 'limit', 'offset' and 'row_count' respectively (#170)

### Features

* **generator:** update protoc to v3.15.3 ([#163](https://www.github.com/googleapis/java-analytics-data/issues/163)) ([b1852d4](https://www.github.com/googleapis/java-analytics-data/commit/b1852d4c78b4d9aa49d0b8c5bd3b9a5d2cc5fdb6))


### Bug Fixes

* rename the 'page_size', 'page_token', 'total_size' fields to 'limit', 'offset' and 'row_count' respectively ([#170](https://www.github.com/googleapis/java-analytics-data/issues/170)) ([cfd43f0](https://www.github.com/googleapis/java-analytics-data/commit/cfd43f0a854379ad2161c1af8a709ebfb96196bd))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.20.1 ([#171](https://www.github.com/googleapis/java-analytics-data/issues/171)) ([6d06098](https://www.github.com/googleapis/java-analytics-data/commit/6d0609886aca2ae74b3e5d6f840110e93fe95adc))

## [0.6.0](https://www.github.com/googleapis/java-analytics-data/compare/v0.5.5...v0.6.0) (2021-02-26)


### Features

* add v1beta client ([#158](https://www.github.com/googleapis/java-analytics-data/issues/158)) ([545cca0](https://www.github.com/googleapis/java-analytics-data/commit/545cca098dd4a054d3110761347cfe3aabc41ccd))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.20.0 ([#159](https://www.github.com/googleapis/java-analytics-data/issues/159)) ([009ac70](https://www.github.com/googleapis/java-analytics-data/commit/009ac70ab39adf5b0edad5fe80799dc5a51eb7f8))

### [0.5.5](https://www.github.com/googleapis/java-analytics-data/compare/v0.5.4...v0.5.5) (2021-02-22)


### Bug Fixes

* don't log downloads ([#152](https://www.github.com/googleapis/java-analytics-data/issues/152)) ([e173782](https://www.github.com/googleapis/java-analytics-data/commit/e17378207bf50ccd1b5f931481cf1c894908fe25))


### Documentation

* generate sample code in the Java microgenerator ([#135](https://www.github.com/googleapis/java-analytics-data/issues/135)) ([0470fd1](https://www.github.com/googleapis/java-analytics-data/commit/0470fd12172a87ff90d279775b1931e48ece51d0))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.19.0 ([#153](https://www.github.com/googleapis/java-analytics-data/issues/153)) ([535c757](https://www.github.com/googleapis/java-analytics-data/commit/535c757a963f8e771f892244421dfb364a96256f))

### [0.5.4](https://www.github.com/googleapis/java-analytics-data/compare/v0.5.3...v0.5.4) (2021-01-14)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.18.0 ([#119](https://www.github.com/googleapis/java-analytics-data/issues/119)) ([9d4fae0](https://www.github.com/googleapis/java-analytics-data/commit/9d4fae0fd65e6533e3cb70cba54fc08d75d8b725))

### [0.5.3](https://www.github.com/googleapis/java-analytics-data/compare/v0.5.2...v0.5.3) (2020-12-15)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.17.0 ([#112](https://www.github.com/googleapis/java-analytics-data/issues/112)) ([224e55b](https://www.github.com/googleapis/java-analytics-data/commit/224e55bd24bbe0a946e0859a9b16a3923851a13e))

### [0.5.2](https://www.github.com/googleapis/java-analytics-data/compare/v0.5.1...v0.5.2) (2020-12-14)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.16.1 ([4f26986](https://www.github.com/googleapis/java-analytics-data/commit/4f269863aaa3c4b3ed746474784858dce4bb9a74))

### [0.5.1](https://www.github.com/googleapis/java-analytics-data/compare/v0.5.0...v0.5.1) (2020-12-02)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.16.0 ([#100](https://www.github.com/googleapis/java-analytics-data/issues/100)) ([cc53daf](https://www.github.com/googleapis/java-analytics-data/commit/cc53daf914a11481c1848d5d813dfd4a776bc177))

## [0.5.0](https://www.github.com/googleapis/java-analytics-data/compare/v0.4.0...v0.5.0) (2020-11-12)


### ⚠ BREAKING CHANGES

* GetUniversalMetadata method removed from the API, GetMetadata method should be used instead feat: reporting requests now support date ranges longer than one year docs: minor documentation updates (#89)

### Bug Fixes

* GetUniversalMetadata method removed from the API, GetMetadata method should be used instead feat: reporting requests now support date ranges longer than one year docs: minor documentation updates ([#89](https://www.github.com/googleapis/java-analytics-data/issues/89)) ([e3b69f6](https://www.github.com/googleapis/java-analytics-data/commit/e3b69f6ae443113244cd333e518d6fa79da4488c))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.15.0 ([#87](https://www.github.com/googleapis/java-analytics-data/issues/87)) ([04ad0c9](https://www.github.com/googleapis/java-analytics-data/commit/04ad0c9815ec03e00e1c6db120db7a3d049dbfb3))

## [0.4.0](https://www.github.com/googleapis/java-analytics-data/compare/v0.3.0...v0.4.0) (2020-11-04)


### Features

* added RunRealtimeReport method that returns a customized report of realtime event data for a GA4 property docs: minor documentation updates ([#80](https://www.github.com/googleapis/java-analytics-data/issues/80)) ([815fe2e](https://www.github.com/googleapis/java-analytics-data/commit/815fe2ed8456feef0d972f5610cf4ae73657a9fe))


### Documentation

* App+Web properties renamed to GA4 ([#78](https://www.github.com/googleapis/java-analytics-data/issues/78)) ([6a49d40](https://www.github.com/googleapis/java-analytics-data/commit/6a49d40411b4b51ba74e2632e736f239d933c6e5))

## [0.3.0](https://www.github.com/googleapis/java-analytics-data/compare/v0.2.1...v0.3.0) (2020-10-31)


### Features

* added GetMetadata method for metadata including custom dimensions and metrics. ([#65](https://www.github.com/googleapis/java-analytics-data/issues/65)) ([609457a](https://www.github.com/googleapis/java-analytics-data/commit/609457a68abaf439803bf9f3e147cb27b21e4853))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.14.1 ([#74](https://www.github.com/googleapis/java-analytics-data/issues/74)) ([a43d65d](https://www.github.com/googleapis/java-analytics-data/commit/a43d65dad4f7adb7c39e7110a9f8d1c181b2ea14))

### [0.2.1](https://www.github.com/googleapis/java-analytics-data/compare/v0.2.0...v0.2.1) (2020-10-22)


### Documentation

* added a sample ([#53](https://www.github.com/googleapis/java-analytics-data/issues/53)) ([e3b5d97](https://www.github.com/googleapis/java-analytics-data/commit/e3b5d976993df0f254a72d16babe83ba76de9d46))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.12.1 ([#59](https://www.github.com/googleapis/java-analytics-data/issues/59)) ([2cb6de2](https://www.github.com/googleapis/java-analytics-data/commit/2cb6de2b56dd51758358d04b036c7f1b24b5d2dc))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.13.0 ([#62](https://www.github.com/googleapis/java-analytics-data/issues/62)) ([8f2101e](https://www.github.com/googleapis/java-analytics-data/commit/8f2101e13f35b01abfd283b065d19163c3a58c24))

## [0.2.0](https://www.github.com/googleapis/java-analytics-data/compare/v0.1.1...v0.2.0) (2020-10-12)


### ⚠ BREAKING CHANGES

* DimensionHeader renamed to PivotDimensionHeader

### Features

* GetMetadata method renamed to GetUniversalMetdata docs: documentation updates ([#40](https://www.github.com/googleapis/java-analytics-data/issues/40)) ([7931f8f](https://www.github.com/googleapis/java-analytics-data/commit/7931f8ff01dad7b0d3bf5dec334b40ff4b372e5b))
* rename DimensionHeader to PivotDimensionHeader, add TYPE_SECONDS, TYPE_CURRENCY to MetricType ([#21](https://www.github.com/googleapis/java-analytics-data/issues/21)) ([fcdd02a](https://www.github.com/googleapis/java-analytics-data/commit/fcdd02a90e80a35801195c8f193d7d280ed21276))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.10.0 ([#33](https://www.github.com/googleapis/java-analytics-data/issues/33)) ([a209bdc](https://www.github.com/googleapis/java-analytics-data/commit/a209bdc956ddd5f6805717dd4915d870a21bac13))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.10.2 ([#41](https://www.github.com/googleapis/java-analytics-data/issues/41)) ([38ec38f](https://www.github.com/googleapis/java-analytics-data/commit/38ec38f03eed5f34f42087e023eaa306546ae4f6))

### [0.1.1](https://www.github.com/googleapis/java-analytics-data/compare/v0.1.0...v0.1.1) (2020-09-21)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.9.0 ([#15](https://www.github.com/googleapis/java-analytics-data/issues/15)) ([8b8ff79](https://www.github.com/googleapis/java-analytics-data/commit/8b8ff792dc4a683f5dd76a8567e22d0a58c6c485))

## 0.1.0 (2020-08-28)


### Features

* initial code generation ([0ac2ab2](https://www.github.com/googleapis/java-analytics-data/commit/0ac2ab28087be281328851ed06460c024ed19e5a))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.6 ([#5](https://www.github.com/googleapis/java-analytics-data/issues/5)) ([a3ac1b3](https://www.github.com/googleapis/java-analytics-data/commit/a3ac1b37621e5ee1e1c9580ab29905a603a8587d))
