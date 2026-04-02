# Changelog

## [6.112.0](https://github.com/googleapis/java-spanner/compare/v6.111.1...v6.112.0) (2026-03-17)


### Features

* Ability to update credentials on long running client ([#4371](https://github.com/googleapis/java-spanner/issues/4371)) ([e238990](https://github.com/googleapis/java-spanner/commit/e238990077badb063b1b05b0d71f58859434f7ee))
* Add SI, adapt, split point related proto ([7aa4d90](https://github.com/googleapis/java-spanner/commit/7aa4d90cd4f001713ee2b0b5113303a748b237e0))
* **spanner:** Include cache updates and routing hint into BeginTransaction and Commit request/response respectively ([7aa4d90](https://github.com/googleapis/java-spanner/commit/7aa4d90cd4f001713ee2b0b5113303a748b237e0))


### Bug Fixes

* **deps:** Update the Java code generator (gapic-generator-java) to 2.67.0 ([7aa4d90](https://github.com/googleapis/java-spanner/commit/7aa4d90cd4f001713ee2b0b5113303a748b237e0))
* Fix unclosed literal error for consecutive backslashes ([#4387](https://github.com/googleapis/java-spanner/issues/4387)) ([f4884a8](https://github.com/googleapis/java-spanner/commit/f4884a83d15dcff6e246c7db47c8bafc3369a0a3))

## [6.111.1](https://github.com/googleapis/java-spanner/compare/v6.111.0...v6.111.1) (2026-03-03)


### Bug Fixes

* Retry CreateSession also when waitForMinSessions is zero ([#4360](https://github.com/googleapis/java-spanner/issues/4360)) ([9263972](https://github.com/googleapis/java-spanner/commit/92639722793a994032761155013e506c9693b464))


### Dependencies

* Update dependency com.google.cloud:sdk-platform-java-config to v3.57.0 ([#4358](https://github.com/googleapis/java-spanner/issues/4358)) ([1ce4b8e](https://github.com/googleapis/java-spanner/commit/1ce4b8e24bac44c89f742f0afb395ae4c711abfd))
* Update googleapis/sdk-platform-java action to v2.67.0 ([#4359](https://github.com/googleapis/java-spanner/issues/4359)) ([23781d9](https://github.com/googleapis/java-spanner/commit/23781d9f05db66d033d4d9125707a9988e1697db))

## [6.111.0](https://github.com/googleapis/java-spanner/compare/v6.110.0...v6.111.0) (2026-02-13)


### Features

* Add E2E fallback to the spanner client. ([#4282](https://github.com/googleapis/java-spanner/issues/4282)) ([d36bd21](https://github.com/googleapis/java-spanner/commit/d36bd21a09cdd2006e53a43b6984d2a68ea24d3e))


### Bug Fixes

* Rollback transactions that are waiting for tx-id to be returned ([#4342](https://github.com/googleapis/java-spanner/issues/4342)) ([866a8c2](https://github.com/googleapis/java-spanner/commit/866a8c2d23f0d5edee1d98ead7d002b1981d5339))

## [6.110.0](https://github.com/googleapis/java-spanner/compare/v6.109.0...v6.110.0) (2026-02-11)


### Features

* Add gRPC A66/A94 metrics ([#4333](https://github.com/googleapis/java-spanner/issues/4333)) ([485c700](https://github.com/googleapis/java-spanner/commit/485c70046e3e67dac899011580f9c350bdb31a6d))
* ClientContext and secure parameters support ([#4316](https://github.com/googleapis/java-spanner/issues/4316)) ([6356ef2](https://github.com/googleapis/java-spanner/commit/6356ef2ce1ef87898e7bc4a6bc11174f629a9b5b))
* Next release from main branch is 6.110.0 ([#4338](https://github.com/googleapis/java-spanner/issues/4338)) ([95ac7a7](https://github.com/googleapis/java-spanner/commit/95ac7a71463bfca4bb22f2e4ae61da97b97169ce))
* **spanner:** Include cache updates into the ResultSet response ([aa53a43](https://github.com/googleapis/java-spanner/commit/aa53a43bdce6f4215fea8695837ad2c538598896))


### Bug Fixes

* **deps:** Update the Java code generator (gapic-generator-java) to 2.66.1 ([aa53a43](https://github.com/googleapis/java-spanner/commit/aa53a43bdce6f4215fea8695837ad2c538598896))
* Preserve channel configurator for grpc-gcp and add opt-out for gcp OTel metrics ([#4329](https://github.com/googleapis/java-spanner/issues/4329)) ([2565137](https://github.com/googleapis/java-spanner/commit/25651378831fcd98ef48802872fe82a42cfa4942))


### Dependencies

* Update dependency com.google.cloud:sdk-platform-java-config to v3.56.1 ([#4331](https://github.com/googleapis/java-spanner/issues/4331)) ([2fd403f](https://github.com/googleapis/java-spanner/commit/2fd403f3c994b1b038e876be6e58ecadf731d848))

## [6.109.0](https://github.com/googleapis/java-spanner/compare/v6.108.0...v6.109.0) (2026-02-02)


### Features

* Adding Send and Ack Mutation Support for Cloud Spanner Queue ([#4298](https://github.com/googleapis/java-spanner/issues/4298)) ([4b637ac](https://github.com/googleapis/java-spanner/commit/4b637ac0e4d6d696f3da8ae7fbac31c877aceba9))


### Documentation

* Add snippet for ReadLockMode configuration at client and transaction ([#4305](https://github.com/googleapis/java-spanner/issues/4305)) ([0fd4098](https://github.com/googleapis/java-spanner/commit/0fd40983b3bbb2f753e07036cedea9e7b9e26132))

## [6.108.0](https://github.com/googleapis/java-spanner/compare/v6.107.0...v6.108.0) (2026-01-28)


### Features

* Add a ClientContext field to Spanner requests ([da6880e](https://github.com/googleapis/java-spanner/commit/da6880e425b7be55b11ba400046692e7af09bccb))
* Add ChannelFinder server interfaces ([#4293](https://github.com/googleapis/java-spanner/issues/4293)) ([0b7a32e](https://github.com/googleapis/java-spanner/commit/0b7a32e7a24c027387a768a75632022a29562ef6))
* Exposing total CPU related fields in AutoscalingConfig ([da6880e](https://github.com/googleapis/java-spanner/commit/da6880e425b7be55b11ba400046692e7af09bccb))


### Bug Fixes

* **deps:** Update the Java code generator (gapic-generator-java) to 2.66.0 ([da6880e](https://github.com/googleapis/java-spanner/commit/da6880e425b7be55b11ba400046692e7af09bccb))


### Dependencies

* Update dependency com.google.cloud:sdk-platform-java-config to v3.56.0 ([#4313](https://github.com/googleapis/java-spanner/issues/4313)) ([f7d0abc](https://github.com/googleapis/java-spanner/commit/f7d0abc241acb4c58d0ac3c60a7b18f5512275df))
* Update googleapis/sdk-platform-java action to v2.66.0 ([#4314](https://github.com/googleapis/java-spanner/issues/4314)) ([d09a900](https://github.com/googleapis/java-spanner/commit/d09a900e26223eb9d646e33d29fc5692b8aba36a))

## [6.107.0](https://github.com/googleapis/java-spanner/compare/v6.106.0...v6.107.0) (2026-01-16)


### Features

* Add Dynamic Channel Pooling (DCP) support to Connection API ([#4299](https://github.com/googleapis/java-spanner/issues/4299)) ([bba03a4](https://github.com/googleapis/java-spanner/commit/bba03a44dbfbd59288ecd33e3e53276809ad69b1))
* Add SsFormat encoding library ([#4292](https://github.com/googleapis/java-spanner/issues/4292)) ([338a9b1](https://github.com/googleapis/java-spanner/commit/338a9b1409cafedcdef674bdff09a72c3f2cd772))


### Dependencies

* Update dependency com.google.api.grpc:proto-google-cloud-trace-v1 to v2.82.0 ([#4227](https://github.com/googleapis/java-spanner/issues/4227)) ([22bc6cf](https://github.com/googleapis/java-spanner/commit/22bc6cf3431f6e507d384f6e86a36503f1175ee7))
* Update dependency com.google.cloud:google-cloud-monitoring to v3.83.0 ([#4169](https://github.com/googleapis/java-spanner/issues/4169)) ([61ae915](https://github.com/googleapis/java-spanner/commit/61ae915242a3c8a0aa1385bc1367f67df2c209d6))
* Update dependency com.google.cloud:sdk-platform-java-config to v3.55.1 ([#4302](https://github.com/googleapis/java-spanner/issues/4302)) ([52acc0c](https://github.com/googleapis/java-spanner/commit/52acc0c620fec0aa67ecd81d634eec271fe4e429))
* Update dependency net.bytebuddy:byte-buddy to v1.18.4 ([#4244](https://github.com/googleapis/java-spanner/issues/4244)) ([c8e4d91](https://github.com/googleapis/java-spanner/commit/c8e4d912155ab6829498822dcf0783fac5fe2747))
* Update google.cloud.monitoring.version to v3.83.0 ([#4270](https://github.com/googleapis/java-spanner/issues/4270)) ([7ae68c8](https://github.com/googleapis/java-spanner/commit/7ae68c8e889f44f1057310bc45b70c086af9c385))
* Update googleapis/sdk-platform-java action to v2.65.1 ([#4301](https://github.com/googleapis/java-spanner/issues/4301)) ([7d98f4e](https://github.com/googleapis/java-spanner/commit/7d98f4e12843826c18cbb8e0998c8687c94fc3d2))

## [6.106.0](https://github.com/googleapis/java-spanner/compare/v6.105.0...v6.106.0) (2026-01-07)


### Features

* Support SHOW DEFAULT_TRANSACTION_ISOLATION for PG databases ([#4285](https://github.com/googleapis/java-spanner/issues/4285)) ([aec0515](https://github.com/googleapis/java-spanner/commit/aec051514dd3d122a7231eb6d25d1aaec8d90bda))


### Bug Fixes

* Adjust the initial polling delay for ddl operations ([#4275](https://github.com/googleapis/java-spanner/issues/4275)) ([8d36967](https://github.com/googleapis/java-spanner/commit/8d36967d010bed8f5a4a0c32f9ec1b5fe7d33e1d))
* Retry creation of multiplexed session ([#4288](https://github.com/googleapis/java-spanner/issues/4288)) ([735e29e](https://github.com/googleapis/java-spanner/commit/735e29ed394faea9f5e697b5934a1f4895055d56))

## [6.105.0](https://github.com/googleapis/java-spanner/compare/v6.104.0...v6.105.0) (2025-12-16)


### Features

* Add support of dynamic channel pooling ([#4265](https://github.com/googleapis/java-spanner/issues/4265)) ([923a14a](https://github.com/googleapis/java-spanner/commit/923a14aad99ff6fc91868f02d657145dd0f31c18))
* Include RequestID in requests and errors ([#4263](https://github.com/googleapis/java-spanner/issues/4263)) ([afd7d6b](https://github.com/googleapis/java-spanner/commit/afd7d6b008f13d7a4d1a3b7f924122bd41d14b59))
* Make grpc-gcp default enabled ([#4239](https://github.com/googleapis/java-spanner/issues/4239)) ([bb82f9e](https://github.com/googleapis/java-spanner/commit/bb82f9e55c40cac29b090e54be780c2e42545ee1))


### Bug Fixes

* Refine connecitivity metrics to capture RPCs with no response he… ([#4252](https://github.com/googleapis/java-spanner/issues/4252)) ([7b49412](https://github.com/googleapis/java-spanner/commit/7b4941221969f48d077ff459214c7d1e65ef843c))
* Retry as PDML dit not retry Resource limit exceeded ([#4258](https://github.com/googleapis/java-spanner/issues/4258)) ([c735d42](https://github.com/googleapis/java-spanner/commit/c735d42875092b0d1482fe641b99645f288cdf4f)), closes [#4253](https://github.com/googleapis/java-spanner/issues/4253)


### Dependencies

* Update dependency com.google.cloud:sdk-platform-java-config to v3.54.2 ([#4261](https://github.com/googleapis/java-spanner/issues/4261)) ([61dfd62](https://github.com/googleapis/java-spanner/commit/61dfd620637da6ef76b699edbad1095c26b81950))
* Update googleapis/sdk-platform-java action to v2.64.2 ([#4262](https://github.com/googleapis/java-spanner/issues/4262)) ([f9505a9](https://github.com/googleapis/java-spanner/commit/f9505a97bdd9f6da7dd5ab1b60b47f7ed0a70402))

## [6.104.0](https://github.com/googleapis/java-spanner/compare/v6.103.0...v6.104.0) (2025-12-03)


### Features

* Include PostgreSQL error code in exceptions ([#4236](https://github.com/googleapis/java-spanner/issues/4236)) ([5874f8b](https://github.com/googleapis/java-spanner/commit/5874f8b3e65adc3e78832866ebe667cd746e2d7f))


### Bug Fixes

* Backslash at end of string literal was misinterpreted ([#4246](https://github.com/googleapis/java-spanner/issues/4246)) ([477ca51](https://github.com/googleapis/java-spanner/commit/477ca51baf6cd1a0a5773bd53677f64195100ae2))
* Fix transaction tag issue with the blind-write ([#4243](https://github.com/googleapis/java-spanner/issues/4243)) ([cf2ba69](https://github.com/googleapis/java-spanner/commit/cf2ba695cdb4038dc8e3ca3e9859231a2203da60))

## [6.103.0](https://github.com/googleapis/java-spanner/compare/v6.102.1...v6.103.0) (2025-11-17)


### Features

* Add grpc.xds.resource_type label to xDS client metrics ([#4222](https://github.com/googleapis/java-spanner/issues/4222)) ([97bed3c](https://github.com/googleapis/java-spanner/commit/97bed3cf1a9df542acc4685c2ce4dbfa629b2cd3))
* Exposing AutoscalingConfig in InstancePartition ([22edecf](https://github.com/googleapis/java-spanner/commit/22edecf8518844860c3cb47883544efd36cbc311))


### Bug Fixes

* Add env var to allow disabling directpath bound token ([#4189](https://github.com/googleapis/java-spanner/issues/4189)) ([0ca9541](https://github.com/googleapis/java-spanner/commit/0ca95412c778e3478cb66e4bea124396326c6056))
* Allow DML THEN RETURN with retryAbortsInternally=false ([#4225](https://github.com/googleapis/java-spanner/issues/4225)) ([f49cc47](https://github.com/googleapis/java-spanner/commit/f49cc47e663836696ef151738510e68324e139dc))
* **deps:** Update the Java code generator (gapic-generator-java) to 2.64.1 ([22edecf](https://github.com/googleapis/java-spanner/commit/22edecf8518844860c3cb47883544efd36cbc311))
* Remove URL encoding in project name ([#4188](https://github.com/googleapis/java-spanner/issues/4188)) ([abba0c1](https://github.com/googleapis/java-spanner/commit/abba0c1730ea792407bea073ea65da55128cd764))


### Dependencies

* Update actions/checkout action to v5 ([#4166](https://github.com/googleapis/java-spanner/issues/4166)) ([50a56f7](https://github.com/googleapis/java-spanner/commit/50a56f7d47541dd581f7b425df36a080ecc11a74))
* Update all tracing and telemetry dependencies ([#4230](https://github.com/googleapis/java-spanner/issues/4230)) ([d60124c](https://github.com/googleapis/java-spanner/commit/d60124cbe317d4c2489ea35de81943cfd2b8f697))
* Update dependency com.google.api.grpc:proto-google-cloud-trace-v1 to v2.79.0 ([#4172](https://github.com/googleapis/java-spanner/issues/4172)) ([3a329fd](https://github.com/googleapis/java-spanner/commit/3a329fdb2fc68ff9d19717b534dd667f931d51fd))
* Update dependency com.google.auto.value:auto-value-annotations to v1.11.1 ([#4216](https://github.com/googleapis/java-spanner/issues/4216)) ([84150c7](https://github.com/googleapis/java-spanner/commit/84150c73bbed2a6d58408ae0b8bd59709fc751db))
* Update dependency com.google.cloud:google-cloud-trace to v2.79.0 ([#4174](https://github.com/googleapis/java-spanner/issues/4174)) ([3e93ca0](https://github.com/googleapis/java-spanner/commit/3e93ca077b94ad06867e3c9fdfe19527855423a2))
* Update dependency com.google.cloud:sdk-platform-java-config to v3.54.1 ([#4193](https://github.com/googleapis/java-spanner/issues/4193)) ([ad235cf](https://github.com/googleapis/java-spanner/commit/ad235cfc9041f52c2f7b76f67eeaa6c03c5840aa))
* Update dependency commons-cli:commons-cli to v1.11.0 ([#4218](https://github.com/googleapis/java-spanner/issues/4218)) ([33449ba](https://github.com/googleapis/java-spanner/commit/33449baf64a3d5b78fff323737ffeb28c8a9461b))
* Update dependency commons-io:commons-io to v2.21.0 ([#4198](https://github.com/googleapis/java-spanner/issues/4198)) ([1f31169](https://github.com/googleapis/java-spanner/commit/1f3116947069ac11c948b510e6a9a7a8a6aa6061))
* Update dependency net.bytebuddy:byte-buddy to v1.18.1 ([#4214](https://github.com/googleapis/java-spanner/issues/4214)) ([0c1d843](https://github.com/googleapis/java-spanner/commit/0c1d843ad42f213d4d9ec2d98a12e21e991ac010))
* Update dependency net.bytebuddy:byte-buddy-agent to v1.18.1 ([#4215](https://github.com/googleapis/java-spanner/issues/4215)) ([76ce01b](https://github.com/googleapis/java-spanner/commit/76ce01b99e5c1274e9103c27ebc6bbdf482bebcd))
* Update opentelemetry.version to v1.56.0 ([#4167](https://github.com/googleapis/java-spanner/issues/4167)) ([a24f219](https://github.com/googleapis/java-spanner/commit/a24f21930978583a0b8d7d39130fa0fc3fec7b2d))

## [6.102.1](https://github.com/googleapis/java-spanner/compare/v6.102.0...v6.102.1) (2025-10-23)


### Bug Fixes

* **deps:** Update the Java code generator (gapic-generator-java) to 2.63.0 ([c1a8238](https://github.com/googleapis/java-spanner/commit/c1a8238af33a083411f63cf6276eb683ee67ac6a))
* Do a quick check if the application runs on GCP ([#4163](https://github.com/googleapis/java-spanner/issues/4163)) ([b9d7daf](https://github.com/googleapis/java-spanner/commit/b9d7daf000c0fb8b67142c6161bb578cadf49b18))
* Migrate away from GoogleCredentials.fromStream() usages ([#4151](https://github.com/googleapis/java-spanner/issues/4151)) ([94d0474](https://github.com/googleapis/java-spanner/commit/94d0474ace62ea1059e5b69243f0b6eef31ddd06))


### Dependencies

* Update actions/checkout action to v5 ([#4158](https://github.com/googleapis/java-spanner/issues/4158)) ([b32ebcf](https://github.com/googleapis/java-spanner/commit/b32ebcf96bbf696b1eb84204622463fac59be017))
* Update actions/checkout action to v5 ([#4161](https://github.com/googleapis/java-spanner/issues/4161)) ([02a17c6](https://github.com/googleapis/java-spanner/commit/02a17c6e6253e026cb3c6360eb925a322143b518))
* Update dependency com.google.cloud:sdk-platform-java-config to v3.53.0 ([#4178](https://github.com/googleapis/java-spanner/issues/4178)) ([24fe194](https://github.com/googleapis/java-spanner/commit/24fe194fa3595b2ab817b9fc4cd57840250fef1f))
* Update dependency net.bytebuddy:byte-buddy to v1.17.8 ([#4154](https://github.com/googleapis/java-spanner/issues/4154)) ([c911381](https://github.com/googleapis/java-spanner/commit/c911381c2ca9cd46fbeb831c659aaf55f21437f2))
* Update dependency net.bytebuddy:byte-buddy-agent to v1.17.8 ([#4155](https://github.com/googleapis/java-spanner/issues/4155)) ([3075df7](https://github.com/googleapis/java-spanner/commit/3075df714b1787512174b3f18cbc802359d442dc))
* Update googleapis/sdk-platform-java action to v2.63.0 ([#4179](https://github.com/googleapis/java-spanner/issues/4179)) ([5f48191](https://github.com/googleapis/java-spanner/commit/5f481913d60372fccf399c5c0e168b7d0c553ba0))


### Documentation

* Add warning for encoded credential ([#4182](https://github.com/googleapis/java-spanner/issues/4182)) ([92620f9](https://github.com/googleapis/java-spanner/commit/92620f969908a8ba7fcf92d0b350a8c4d05398f8))

## [6.102.0](https://github.com/googleapis/java-spanner/compare/v6.101.1...v6.102.0) (2025-10-08)


### Features

* Add connection property for gRPC interceptor provider ([#4149](https://github.com/googleapis/java-spanner/issues/4149)) ([deb8dff](https://github.com/googleapis/java-spanner/commit/deb8dff6c01c37a3158e8f4a28ef5e821d10092a))
* Support statement_timeout in connection url ([#4103](https://github.com/googleapis/java-spanner/issues/4103)) ([542c6aa](https://github.com/googleapis/java-spanner/commit/542c6aa63bfdd526070f14cb76921dd34527c1f9))


### Bug Fixes

* Automatically set default_sequence_kind for CREATE SEQUENCE ([#4105](https://github.com/googleapis/java-spanner/issues/4105)) ([3beea6a](https://github.com/googleapis/java-spanner/commit/3beea6ac4eb53b70db34e0a2d2e33e56f450c88b))
* **deps:** Update the Java code generator (gapic-generator-java) to 2.62.3 ([7047a3a](https://github.com/googleapis/java-spanner/commit/7047a3ae31aae51e9e23758fe004b93855a0ee4b))


### Dependencies

* Update actions/checkout action to v5 ([#4069](https://github.com/googleapis/java-spanner/issues/4069)) ([4c88eb9](https://github.com/googleapis/java-spanner/commit/4c88eb91a321aa718f957296012f9e7501c7caec))
* Update actions/checkout action to v5 ([#4106](https://github.com/googleapis/java-spanner/issues/4106)) ([14ebdb3](https://github.com/googleapis/java-spanner/commit/14ebdb35c33442c4e0f70d63dce3425edb730525))
* Update actions/setup-java action to v5 ([#4071](https://github.com/googleapis/java-spanner/issues/4071)) ([e23134a](https://github.com/googleapis/java-spanner/commit/e23134a2f864e8abd2890ac3a81ff6b668afbe63))
* Update all dependencies ([#4099](https://github.com/googleapis/java-spanner/issues/4099)) ([b262edc](https://github.com/googleapis/java-spanner/commit/b262edcfc4713bb64986bc4acd3f02b69d3367f8))
* Update dependency com.google.api.grpc:grpc-google-cloud-monitoring-v3 to v3.77.0 ([#4117](https://github.com/googleapis/java-spanner/issues/4117)) ([2451ca2](https://github.com/googleapis/java-spanner/commit/2451ca2abe1dd2de3907b88e8d18beab1a15a634))
* Update dependency com.google.api.grpc:proto-google-cloud-monitoring-v3 to v3.77.0 ([#4143](https://github.com/googleapis/java-spanner/issues/4143)) ([6c9dc26](https://github.com/googleapis/java-spanner/commit/6c9dc26330cf66f196adc2203323a482e08f0325))
* Update dependency com.google.api.grpc:proto-google-cloud-trace-v1 to v2.76.0 ([#4144](https://github.com/googleapis/java-spanner/issues/4144)) ([d566a42](https://github.com/googleapis/java-spanner/commit/d566a4295be018070169ba082a018394a2e60b45))
* Update dependency com.google.cloud:google-cloud-monitoring to v3.77.0 ([#4145](https://github.com/googleapis/java-spanner/issues/4145)) ([8917c05](https://github.com/googleapis/java-spanner/commit/8917c054410e4035d6d4e201e43599d5ddc1fadd))
* Update dependency com.google.cloud:google-cloud-monitoring to v3.77.0 ([#4146](https://github.com/googleapis/java-spanner/issues/4146)) ([4ebea1a](https://github.com/googleapis/java-spanner/commit/4ebea1adf726069084087ce46900f3174658055c))
* Update dependency com.google.cloud:google-cloud-trace to v2.76.0 ([#4147](https://github.com/googleapis/java-spanner/issues/4147)) ([4b1d4af](https://github.com/googleapis/java-spanner/commit/4b1d4af19336e493af38a1e58c95786da3892d34))
* Update dependency com.google.cloud:google-cloud-trace to v2.76.0 ([#4148](https://github.com/googleapis/java-spanner/issues/4148)) ([8f91a89](https://github.com/googleapis/java-spanner/commit/8f91a894771653213b6fcded5795349ad7ea6724))
* Update dependency com.google.cloud:sdk-platform-java-config to v3.52.3 ([#4107](https://github.com/googleapis/java-spanner/issues/4107)) ([8a8a042](https://github.com/googleapis/java-spanner/commit/8a8a042494b092b3dddd0c9606a63197d8a23555))
* Update dependency org.json:json to v20250517 ([#3881](https://github.com/googleapis/java-spanner/issues/3881)) ([5658c83](https://github.com/googleapis/java-spanner/commit/5658c8378aa2e8028d4ef7dfaf94b647f33cd812))
* Update googleapis/sdk-platform-java action to v2.62.3 ([#4108](https://github.com/googleapis/java-spanner/issues/4108)) ([65913ec](https://github.com/googleapis/java-spanner/commit/65913ec0638fec4ea536cf42f8fe25460133f68e))

## [6.101.1](https://github.com/googleapis/java-spanner/compare/v6.101.0...v6.101.1) (2025-09-26)


### Bug Fixes

* Potential NullPointerException in LocalConnectionChecker ([#4092](https://github.com/googleapis/java-spanner/issues/4092)) ([3b9f597](https://github.com/googleapis/java-spanner/commit/3b9f597ba60199a16556824568b24908ce938a69))

## [6.101.0](https://github.com/googleapis/java-spanner/compare/v6.100.0...v6.101.0) (2025-09-26)


### Features

* Add transaction_timeout connection property ([#4056](https://github.com/googleapis/java-spanner/issues/4056)) ([cdc52d4](https://github.com/googleapis/java-spanner/commit/cdc52d49b39c57e7255f4e09fb33a41f4810397d))
* TPC support ([#4055](https://github.com/googleapis/java-spanner/issues/4055)) ([7625cce](https://github.com/googleapis/java-spanner/commit/7625cce9ad48b14a1cff9c2ede86a066ea292bef))


### Bug Fixes

* **deps:** Update the Java code generator (gapic-generator-java) to 2.62.2 ([8d6cbf6](https://github.com/googleapis/java-spanner/commit/8d6cbf6bea9cbd823b8f0070516e34b4d8428e87))
* Potential NullPointerException in Value#hashCode ([#4046](https://github.com/googleapis/java-spanner/issues/4046)) ([74abb34](https://github.com/googleapis/java-spanner/commit/74abb341e2ea42bbf0a2de4ec3e3555335b5fd9f))
* Recalculate remaining statement timeout after retry ([#4053](https://github.com/googleapis/java-spanner/issues/4053)) ([5e26596](https://github.com/googleapis/java-spanner/commit/5e26596f4f9c924260da0908920854d8ddfc626b))


### Dependencies

* Update dependency com.google.cloud:sdk-platform-java-config to v3.52.2 ([#4057](https://github.com/googleapis/java-spanner/issues/4057)) ([d782aff](https://github.com/googleapis/java-spanner/commit/d782aff63ff81e1b760690d4dee3e566028d522e))

## [6.100.0](https://github.com/googleapis/java-spanner/compare/v6.99.0...v6.100.0) (2025-09-11)


### Features

* Read_lock_mode support for connections ([#4031](https://github.com/googleapis/java-spanner/issues/4031)) ([261abb4](https://github.com/googleapis/java-spanner/commit/261abb4b9c5ff00fac2d816a31926b23264657c4))


### Bug Fixes

* **deps:** Update the Java code generator (gapic-generator-java) to 2.62.1 ([e9773a7](https://github.com/googleapis/java-spanner/commit/e9773a7aa27a414d56093b4e09e0f197a07b5980))
* Disable afe_connectivity_error_count metric ([#4041](https://github.com/googleapis/java-spanner/issues/4041)) ([f89c1c0](https://github.com/googleapis/java-spanner/commit/f89c1c0517ba6b895f405b0085b8df41aac952be))
* Skip session delete in case of multiplexed sessions ([#4029](https://github.com/googleapis/java-spanner/issues/4029)) ([8bcb09d](https://github.com/googleapis/java-spanner/commit/8bcb09d141fe986c92ccacbaa9a45302c5c8e79d))


### Dependencies

* Update dependency com.google.cloud:sdk-platform-java-config to v3.52.1 ([#4034](https://github.com/googleapis/java-spanner/issues/4034)) ([13bfa7c](https://github.com/googleapis/java-spanner/commit/13bfa7c68c7ea887e679fb5504dceb85cbb43cb9))


### Documentation

* A comment for field `ranges` in message `.google.spanner.v1.KeySet` is changed ([e9773a7](https://github.com/googleapis/java-spanner/commit/e9773a7aa27a414d56093b4e09e0f197a07b5980))

## [6.99.0](https://github.com/googleapis/java-spanner/compare/v6.98.1...v6.99.0) (2025-08-26)


### Features

* Support read lock mode for R/W transactions ([#4010](https://github.com/googleapis/java-spanner/issues/4010)) ([7d752d6](https://github.com/googleapis/java-spanner/commit/7d752d686e638b6266aab3a5188c01641d2f9adc))


### Bug Fixes

* **deps:** Update the Java code generator (gapic-generator-java) to 2.62.0 ([52c68db](https://github.com/googleapis/java-spanner/commit/52c68db5c75f24a066c2e828ed79917c824f699b))
* GetCommitResponse() should return error if tx has not committed ([#4021](https://github.com/googleapis/java-spanner/issues/4021)) ([a2c179f](https://github.com/googleapis/java-spanner/commit/a2c179f2e7c19d295bdbf9cf1bbd1c5562dd9e21))


### Dependencies

* Update dependency com.google.cloud:sdk-platform-java-config to v3.52.0 ([#4024](https://github.com/googleapis/java-spanner/issues/4024)) ([7e3294f](https://github.com/googleapis/java-spanner/commit/7e3294f6d42bddb4cfff67334118f615c90c3bb7))

## [6.98.1](https://github.com/googleapis/java-spanner/compare/v6.98.0...v6.98.1) (2025-08-11)


### Bug Fixes

* Add missing span.end calls for AsyncTransactionManager ([#4012](https://github.com/googleapis/java-spanner/issues/4012)) ([1a4adb4](https://github.com/googleapis/java-spanner/commit/1a4adb4d70c3a3822fa6bda93d689f2dae1835fa))
* **deps:** Update the Java code generator (gapic-generator-java) to 2.61.0 ([8156ef3](https://github.com/googleapis/java-spanner/commit/8156ef31d93932c14f9fdd13c8c5e5b7ce370ba5))


### Dependencies

* Update dependency com.google.cloud:sdk-platform-java-config to v3.51.0 ([#4013](https://github.com/googleapis/java-spanner/issues/4013)) ([4e90c29](https://github.com/googleapis/java-spanner/commit/4e90c29ce3447d14411368e45a39c7b0965cb40a))

## [6.98.0](https://github.com/googleapis/java-spanner/compare/v6.97.1...v6.98.0) (2025-07-31)


### Features

* Proto changes for an internal api ([675e90b](https://github.com/googleapis/java-spanner/commit/675e90b4582b4fc968118121e6c23ec98ee178e9))
* **spanner:** A new field `snapshot_timestamp` is added to message `.google.spanner.v1.CommitResponse` ([675e90b](https://github.com/googleapis/java-spanner/commit/675e90b4582b4fc968118121e6c23ec98ee178e9))
* Support Exemplar ([#3997](https://github.com/googleapis/java-spanner/issues/3997)) ([fcf0a01](https://github.com/googleapis/java-spanner/commit/fcf0a0182a33f229e865e4593635efaed34d6dac))
* Use multiplex sessions for RW and Partition Ops ([#3996](https://github.com/googleapis/java-spanner/issues/3996)) ([a882204](https://github.com/googleapis/java-spanner/commit/a882204e07a2084b228c14fb37ac53e4e33d0f59))


### Bug Fixes

* **deps:** Update the Java code generator (gapic-generator-java) to 2.60.2 ([675e90b](https://github.com/googleapis/java-spanner/commit/675e90b4582b4fc968118121e6c23ec98ee178e9))


### Dependencies

* Update dependency com.google.cloud:sdk-platform-java-config to v3.50.2 ([#4004](https://github.com/googleapis/java-spanner/issues/4004)) ([986c0e0](https://github.com/googleapis/java-spanner/commit/986c0e07fddecd51cd310a9759ce1d41c1f5c657))

## [6.97.1](https://github.com/googleapis/java-spanner/compare/v6.97.0...v6.97.1) (2025-07-15)


### Dependencies

* Update dependency com.google.cloud:sdk-platform-java-config to v3.50.1 ([#3992](https://github.com/googleapis/java-spanner/issues/3992)) ([69ffd72](https://github.com/googleapis/java-spanner/commit/69ffd7282220b8b12c6b9b64d8856ff88068ffa2))
* Update googleapis/sdk-platform-java action to v2.60.1 ([#3926](https://github.com/googleapis/java-spanner/issues/3926)) ([7001b7f](https://github.com/googleapis/java-spanner/commit/7001b7faaff581e26ec81c4db2c99a1e8726d5eb))

## [6.97.0](https://github.com/googleapis/java-spanner/compare/v6.96.1...v6.97.0) (2025-07-10)


### Features

* Next release from main branch is 6.97.0 ([#3984](https://github.com/googleapis/java-spanner/issues/3984)) ([5651f61](https://github.com/googleapis/java-spanner/commit/5651f6160e1e655f118aa2e7f0203a47cd6914c0))


### Bug Fixes

* Drop max message size ([#3987](https://github.com/googleapis/java-spanner/issues/3987)) ([3eee899](https://github.com/googleapis/java-spanner/commit/3eee89965547dfa49b4282b470f625d43c92f4fd))
* Return non-empty metadata for DataBoost queries ([#3936](https://github.com/googleapis/java-spanner/issues/3936)) ([79c0684](https://github.com/googleapis/java-spanner/commit/79c06848c0ac4eff8410dd3bd63db8675c202d94))

## [6.96.1](https://github.com/googleapis/java-spanner/compare/v6.96.0...v6.96.1) (2025-06-30)


### Bug Fixes

* **deps:** Update the Java code generator (gapic-generator-java) to 2.59.0 ([2836042](https://github.com/googleapis/java-spanner/commit/2836042217fe29bb967fe892bd6b492391ded95c))


### Dependencies

* Update dependency com.google.cloud:sdk-platform-java-config to v3.50.0 ([#3925](https://github.com/googleapis/java-spanner/issues/3925)) ([1372bbd](https://github.com/googleapis/java-spanner/commit/1372bbd82b7828629cbc407b78878469bc477977))

## [6.96.0](https://github.com/googleapis/java-spanner/compare/v6.95.1...v6.96.0) (2025-06-27)


### Features

* Allow JDBC to configure directpath for connection ([#3929](https://github.com/googleapis/java-spanner/issues/3929)) ([d754f1f](https://github.com/googleapis/java-spanner/commit/d754f1f99294d86ec881583f217fa09f291a3d7a))
* Support getOrNull and getOrDefault in Struct ([#3914](https://github.com/googleapis/java-spanner/issues/3914)) ([1dc5a3e](https://github.com/googleapis/java-spanner/commit/1dc5a3ec0ca9ea530e8691df5c2734c0a1ece559))
* Use multiplexed sessions for read-only transactions ([#3917](https://github.com/googleapis/java-spanner/issues/3917)) ([37fdc27](https://github.com/googleapis/java-spanner/commit/37fdc27aab4e71ac141c2a2c979f864e97395a97))


### Bug Fixes

* Allow zero durations to be set for connections ([#3916](https://github.com/googleapis/java-spanner/issues/3916)) ([43ea4fa](https://github.com/googleapis/java-spanner/commit/43ea4fa68eac00801beb8e58c1eb09e9f32e5ce5))


### Documentation

* Add snippet for Repeatable Read configuration at client and transaction ([#3908](https://github.com/googleapis/java-spanner/issues/3908)) ([ff3d212](https://github.com/googleapis/java-spanner/commit/ff3d212c98276c4084f44619916d0444c9652803))
* Update SpannerSample.java to align with best practices ([#3625](https://github.com/googleapis/java-spanner/issues/3625)) ([7bfc62d](https://github.com/googleapis/java-spanner/commit/7bfc62d3d9e57242e0dfddea090208f8c65f0f8e))

## [6.95.1](https://github.com/googleapis/java-spanner/compare/v6.95.0...v6.95.1) (2025-06-06)


### Dependencies

* Update dependency com.google.cloud:sdk-platform-java-config to v3.49.0 ([#3909](https://github.com/googleapis/java-spanner/issues/3909)) ([3de8502](https://github.com/googleapis/java-spanner/commit/3de8502b98ebb90526fc2339e279f9b710816b3b))
* Update googleapis/sdk-platform-java action to v2.59.0 ([#3910](https://github.com/googleapis/java-spanner/issues/3910)) ([aed8bd6](https://github.com/googleapis/java-spanner/commit/aed8bd6d5a0b1e0dfab345e0de68f285e8b8aedb))

## [6.95.0](https://github.com/googleapis/java-spanner/compare/v6.94.0...v6.95.0) (2025-06-05)


### Features

* Enable ALTS hard bound token in DirectPath ([#3904](https://github.com/googleapis/java-spanner/issues/3904)) ([2b0f2ff](https://github.com/googleapis/java-spanner/commit/2b0f2ff214f4b68dd5957bc4280edb713b77a763))
* Enable grpc and afe metrics ([#3896](https://github.com/googleapis/java-spanner/issues/3896)) ([706f794](https://github.com/googleapis/java-spanner/commit/706f794f044c2cb1112cfdae6f379e5f2bc3f26f))
* Last statement sample ([#3830](https://github.com/googleapis/java-spanner/issues/3830)) ([2f62816](https://github.com/googleapis/java-spanner/commit/2f62816b0af9aced1b73e25525f60f8e3e923454))
* **spanner:** Add new change_stream.proto ([f385698](https://github.com/googleapis/java-spanner/commit/f38569865de7465ae9a37b844a9dd983571d3688))


### Bug Fixes

* Directpath_enabled attribute ([#3897](https://github.com/googleapis/java-spanner/issues/3897)) ([53bc510](https://github.com/googleapis/java-spanner/commit/53bc510145921d00bc3df04aa4cf407179ed8d8e))


### Dependencies

* Update dependency io.opentelemetry:opentelemetry-bom to v1.50.0 ([#3887](https://github.com/googleapis/java-spanner/issues/3887)) ([94b879c](https://github.com/googleapis/java-spanner/commit/94b879c8c1848fa0b14dbe8cda8390cfe9e8fce6))

## [6.94.0](https://github.com/googleapis/java-spanner/compare/v6.93.0...v6.94.0) (2025-05-21)


### Features

* Add throughput_mode to UpdateDatabaseDdlRequest to be used by Spanner Migration Tool. See https://github.com/GoogleCloudPlatform/spanner-migration-tool ([3070f1d](https://github.com/googleapis/java-spanner/commit/3070f1db97788c2a55c553ab8a4de3419d1ccf5c))


### Bug Fixes

* **deps:** Update the Java code generator (gapic-generator-java) to 2.58.0 ([3070f1d](https://github.com/googleapis/java-spanner/commit/3070f1db97788c2a55c553ab8a4de3419d1ccf5c))
* Remove trailing semicolons in DDL ([#3879](https://github.com/googleapis/java-spanner/issues/3879)) ([ca3a67d](https://github.com/googleapis/java-spanner/commit/ca3a67db715f398943382df1f8a9979905811ff8))


### Dependencies

* Update dependency com.google.cloud:sdk-platform-java-config to v3.48.0 ([#3869](https://github.com/googleapis/java-spanner/issues/3869)) ([afa17f7](https://github.com/googleapis/java-spanner/commit/afa17f73beab80639467916bc73b5c96305093aa))
* Update dependency com.google.cloud:sdk-platform-java-config to v3.48.0 ([#3880](https://github.com/googleapis/java-spanner/issues/3880)) ([f3b00b6](https://github.com/googleapis/java-spanner/commit/f3b00b663aa897fda1bc21222d29726e6be630cb))
* Update dependency com.google.cloud.opentelemetry:exporter-metrics to v0.34.0 ([#3861](https://github.com/googleapis/java-spanner/issues/3861)) ([676b14f](https://github.com/googleapis/java-spanner/commit/676b14f916dea783b40ddec4061bd7af157b5d98))
* Update dependency commons-io:commons-io to v2.19.0 ([#3863](https://github.com/googleapis/java-spanner/issues/3863)) ([80a6af8](https://github.com/googleapis/java-spanner/commit/80a6af836ca29ec196a2f509831e1d36c557168f))
* Update dependency io.opentelemetry:opentelemetry-bom to v1.50.0 ([#3865](https://github.com/googleapis/java-spanner/issues/3865)) ([ae63050](https://github.com/googleapis/java-spanner/commit/ae6305089b394be0c1eaf8ff7e188711288d87ad))
* Update googleapis/sdk-platform-java action to v2.58.0 ([#3870](https://github.com/googleapis/java-spanner/issues/3870)) ([d1e45fa](https://github.com/googleapis/java-spanner/commit/d1e45fa88bb005529bcfb2a6ff2df44065be0fd2))
* Update opentelemetry.version to v1.50.0 ([#3866](https://github.com/googleapis/java-spanner/issues/3866)) ([f7e09b8](https://github.com/googleapis/java-spanner/commit/f7e09b8148c0e51503255694bd3347c637724b34))


### Documentation

* Add samples for unnamed (positional) parameters ([#3849](https://github.com/googleapis/java-spanner/issues/3849)) ([035cadd](https://github.com/googleapis/java-spanner/commit/035cadd5bb77a8f9f6fb25ac8c8e5a3e186d9a22))

## [6.93.0](https://github.com/googleapis/java-spanner/compare/v6.92.0...v6.93.0) (2025-05-09)


### Features

* Enable AFE and gRPC metrics for DP ([#3852](https://github.com/googleapis/java-spanner/issues/3852)) ([203baae](https://github.com/googleapis/java-spanner/commit/203baae3996378435095cb90e3b2c7ee71a643cd))


### Bug Fixes

* Change server timing duration attribute to float as per w3c ([#3851](https://github.com/googleapis/java-spanner/issues/3851)) ([da8dd8d](https://github.com/googleapis/java-spanner/commit/da8dd8da3171a073d7b450d4413936351a4c1060))
* **deps:** Update the Java code generator (gapic-generator-java) to 2.57.0 ([23b985c](https://github.com/googleapis/java-spanner/commit/23b985c9a04837b0b38f2cfc5d96469e1d664d67))
* Non-ASCII Unicode characters in code ([#3844](https://github.com/googleapis/java-spanner/issues/3844)) ([85a0820](https://github.com/googleapis/java-spanner/commit/85a0820505889ae6482a9e4f845cd53430dd6b44))
* Only close and return sessions once ([#3846](https://github.com/googleapis/java-spanner/issues/3846)) ([32b2373](https://github.com/googleapis/java-spanner/commit/32b2373d62cac3047d9686c56af278c706d7c488))

## [6.92.0](https://github.com/googleapis/java-spanner/compare/v6.91.1...v6.92.0) (2025-04-29)


### Features

* [Internal] client-side metrics for afe latency and connectivity error ([#3819](https://github.com/googleapis/java-spanner/issues/3819)) ([a8dba0a](https://github.com/googleapis/java-spanner/commit/a8dba0a83939fdbbc324f0a7aa6c44180462fa3a))
* Support begin with AbortedException for manager interface ([#3835](https://github.com/googleapis/java-spanner/issues/3835)) ([5783116](https://github.com/googleapis/java-spanner/commit/578311693bed836c8916f4b4ffa0782a468c1af3))


### Bug Fixes

* **deps:** Update the Java code generator (gapic-generator-java) to 2.56.2 ([11bfd90](https://github.com/googleapis/java-spanner/commit/11bfd90daa244dbd31a76bc5a1d2e694e43fa292))


### Dependencies

* Update dependency com.google.cloud:sdk-platform-java-config to v3.46.2 ([#3836](https://github.com/googleapis/java-spanner/issues/3836)) ([2ee7f97](https://github.com/googleapis/java-spanner/commit/2ee7f971f3374b01d22e5a7f8f2483cf60c3363d))

## [6.91.1](https://github.com/googleapis/java-spanner/compare/v6.91.0...v6.91.1) (2025-04-21)


### Bug Fixes

* SkipHint in the internal parser skipped too much ([#3827](https://github.com/googleapis/java-spanner/issues/3827)) ([fbf7b4c](https://github.com/googleapis/java-spanner/commit/fbf7b4c4324c4d565bfe3950ecf80de02c88f16e))

## [6.91.0](https://github.com/googleapis/java-spanner/compare/v6.90.0...v6.91.0) (2025-04-17)


### Features

* [Internal] open telemetry built in metrics for GRPC ([#3709](https://github.com/googleapis/java-spanner/issues/3709)) ([cd76c73](https://github.com/googleapis/java-spanner/commit/cd76c73d838a9ccde2c8c11fc63144a62d76886c))
* Add java sample for the pre-splitting feature ([#3713](https://github.com/googleapis/java-spanner/issues/3713)) ([e97b92e](https://github.com/googleapis/java-spanner/commit/e97b92ea4728bc8f013ff73478de4af9eaa1793b))
* Add TransactionMutationLimitExceededException as cause to SpannerBatchUpdateException ([#3723](https://github.com/googleapis/java-spanner/issues/3723)) ([4cf5261](https://github.com/googleapis/java-spanner/commit/4cf52613c6c8280fdb864f5b8d04f8fb6ea55e16))
* Built in metrics for afe latency and connectivity error ([#3724](https://github.com/googleapis/java-spanner/issues/3724)) ([e13a2f9](https://github.com/googleapis/java-spanner/commit/e13a2f9c5cadd15ab5a565c7dd1c1eec64c09488))
* Support unnamed parameters ([#3820](https://github.com/googleapis/java-spanner/issues/3820)) ([1afd815](https://github.com/googleapis/java-spanner/commit/1afd815869785588dfd03ffc12e381e32c4aa0fe))


### Bug Fixes

* Add default implementations for Interval methods in AbstractStructReader ([#3722](https://github.com/googleapis/java-spanner/issues/3722)) ([97f4544](https://github.com/googleapis/java-spanner/commit/97f45448ecb51bd20699d1f163f78b2a7736b21f))
* Set transaction isolation level had no effect ([#3718](https://github.com/googleapis/java-spanner/issues/3718)) ([b382999](https://github.com/googleapis/java-spanner/commit/b382999f42d1b643472cf3f605f8c6dc839dec19))


### Performance Improvements

* Cache the key used for OTEL traces and metrics ([#3814](https://github.com/googleapis/java-spanner/issues/3814)) ([c5a2045](https://github.com/googleapis/java-spanner/commit/c5a20452ad2ed5a8f1ac12cca4072a86f4457b93))
* Optimize parsing in Connection API ([#3800](https://github.com/googleapis/java-spanner/issues/3800)) ([a2780ed](https://github.com/googleapis/java-spanner/commit/a2780edb3d9d4972c78befd097692f626a6a4bea))
* Qualify statements without removing comments ([#3810](https://github.com/googleapis/java-spanner/issues/3810)) ([d358cb9](https://github.com/googleapis/java-spanner/commit/d358cb96e33bdf6de6528d03c884aa702b40b802))
* Remove all calls to getSqlWithoutComments ([#3822](https://github.com/googleapis/java-spanner/issues/3822)) ([0e1e14c](https://github.com/googleapis/java-spanner/commit/0e1e14c0e8c1f3726c4d3cfd836c580b3b4122d0))

## [6.90.0](https://github.com/googleapis/java-spanner/compare/v6.89.0...v6.90.0) (2025-03-31)


### Features

* Add default_isolation_level connection property ([#3702](https://github.com/googleapis/java-spanner/issues/3702)) ([9472d23](https://github.com/googleapis/java-spanner/commit/9472d23c2b233275e779815f89040323e073a7d1))
* Adds support for Interval datatype in Java client ([#3416](https://github.com/googleapis/java-spanner/issues/3416)) ([8be8f5e](https://github.com/googleapis/java-spanner/commit/8be8f5e6b08c8cf3e5f062e4b985b3ec9c725064))
* Integration test for End to End tracing ([#3691](https://github.com/googleapis/java-spanner/issues/3691)) ([bf1a07a](https://github.com/googleapis/java-spanner/commit/bf1a07a153b1eb899757260b8ac2bc12384e45af))
* Specify isolation level per transaction ([#3704](https://github.com/googleapis/java-spanner/issues/3704)) ([868f30f](https://github.com/googleapis/java-spanner/commit/868f30fde95d07c3fc18feaca64b4d1c3ba6a27d))
* Support PostgreSQL isolation level statements ([#3706](https://github.com/googleapis/java-spanner/issues/3706)) ([dda2e1d](https://github.com/googleapis/java-spanner/commit/dda2e1dec38febdad54b61f588590c7572017ba9))

## [6.89.0](https://github.com/googleapis/java-spanner/compare/v6.88.0...v6.89.0) (2025-03-20)


### Features

* Enable ALTS hard bound token in DirectPath ([#3645](https://github.com/googleapis/java-spanner/issues/3645)) ([42cc961](https://github.com/googleapis/java-spanner/commit/42cc9616fa74c765d5716fd948dc0823df0a07a6))
* Next release from main branch is 6.89.0 ([#3669](https://github.com/googleapis/java-spanner/issues/3669)) ([7a8a29b](https://github.com/googleapis/java-spanner/commit/7a8a29be40258294cafd13b1df7df5ea349a675d))
* Support isolation level REPEATABLE_READ for R/W transactions ([#3670](https://github.com/googleapis/java-spanner/issues/3670)) ([e62f5ab](https://github.com/googleapis/java-spanner/commit/e62f5ab46da8696a8ff0d213f924588612bb4025))


### Bug Fixes

* **deps:** Update the Java code generator (gapic-generator-java) to 2.55.1 ([b959f4c](https://github.com/googleapis/java-spanner/commit/b959f4c8ebb3551796a894b659aa42ba16fb1c39))
* Revert the ALTS bound token enablement ([#3679](https://github.com/googleapis/java-spanner/issues/3679)) ([183c1f0](https://github.com/googleapis/java-spanner/commit/183c1f0e228a927a575596a38a01d63bb8eb6943))


### Performance Improvements

* Get database dialect using multiplexed session ([#3684](https://github.com/googleapis/java-spanner/issues/3684)) ([f641a40](https://github.com/googleapis/java-spanner/commit/f641a40ed515a6559718c2fe2757c322f037d83b))
* Skip gRPC trailers for StreamingRead & ExecuteStreamingSql ([#3661](https://github.com/googleapis/java-spanner/issues/3661)) ([bd4b1f5](https://github.com/googleapis/java-spanner/commit/bd4b1f5b9612f6a4dfd748d735c887f8e46ae106))


### Dependencies

* Update dependency com.google.cloud:sdk-platform-java-config to v3.45.1 ([#3689](https://github.com/googleapis/java-spanner/issues/3689)) ([67188df](https://github.com/googleapis/java-spanner/commit/67188df2be23eef88de8f4febc3ac7208ebdd937))

## [6.88.0](https://github.com/googleapis/java-spanner/compare/v6.87.0...v6.88.0) (2025-02-27)


### Features

* Add a last field in the PartialResultSet ([7c714be](https://github.com/googleapis/java-spanner/commit/7c714be10eb345f2d8f566d752f6de615061c4da))
* Automatically set default sequence kind in JDBC and PGAdapter ([#3658](https://github.com/googleapis/java-spanner/issues/3658)) ([e8abf33](https://github.com/googleapis/java-spanner/commit/e8abf338b85e95f185ab2875a804134523f84de3))
* Default authentication support for external hosts ([#3656](https://github.com/googleapis/java-spanner/issues/3656)) ([ace11d5](https://github.com/googleapis/java-spanner/commit/ace11d5d928fb567b16560263ae95aa9cd916e22))
* **spanner:** A new enum `IsolationLevel` is added ([3fd33ba](https://github.com/googleapis/java-spanner/commit/3fd33ba9c5fab43ed475ed3cff9d60c008843981))
* **spanner:** Add instance partitions field in backup proto ([3fd33ba](https://github.com/googleapis/java-spanner/commit/3fd33ba9c5fab43ed475ed3cff9d60c008843981))


### Bug Fixes

* **deps:** Update the Java code generator (gapic-generator-java) to 2.54.0 ([57497ad](https://github.com/googleapis/java-spanner/commit/57497ad00c62f152f493645f382530cf0eedf19e))


### Dependencies

* Update dependency com.google.cloud:sdk-platform-java-config to v3.44.0 ([#3665](https://github.com/googleapis/java-spanner/issues/3665)) ([3543548](https://github.com/googleapis/java-spanner/commit/35435488f87ebd59179698e8f74578b41eb219da))

## [6.87.0](https://github.com/googleapis/java-spanner/compare/v6.86.0...v6.87.0) (2025-02-20)


### Features

* Add AddSplitPoints API ([a5ebcd3](https://github.com/googleapis/java-spanner/commit/a5ebcd343a67c57d61362cfb0ccb4888f5503681))
* Add option for multiplexed sessions with partitioned operations ([#3635](https://github.com/googleapis/java-spanner/issues/3635)) ([dc89b4d](https://github.com/googleapis/java-spanner/commit/dc89b4d7663f0e40a9169b21243f2d94f2fc5749))
* Add option to indicate that a statement is the last in a transaction ([#3647](https://github.com/googleapis/java-spanner/issues/3647)) ([b04ea80](https://github.com/googleapis/java-spanner/commit/b04ea804cfa9551b4d7c49cd83f0ef1120942423))
* Adding gfe_latencies metric to built-in metrics ([#3490](https://github.com/googleapis/java-spanner/issues/3490)) ([314dadc](https://github.com/googleapis/java-spanner/commit/314dadc31f4a5aa798d45886db7231c1bd8b7a91))
* **spanner:** Support multiplexed session for read-write transactions ([#3608](https://github.com/googleapis/java-spanner/issues/3608)) ([bda78ed](https://github.com/googleapis/java-spanner/commit/bda78edaba827acf974c87c335868a6f8caa38f2))


### Bug Fixes

* **deps:** Update the Java code generator (gapic-generator-java) to 2.53.0 ([20a3d0d](https://github.com/googleapis/java-spanner/commit/20a3d0da41509ffca66c77de6771fc8080930613))
* **spanner:** End spans for read-write methods ([#3629](https://github.com/googleapis/java-spanner/issues/3629)) ([4a1f99c](https://github.com/googleapis/java-spanner/commit/4a1f99c6bb872ffc08e60d3843e4cdfc4efa2690))
* **spanner:** Release resources in TransactionManager ([#3638](https://github.com/googleapis/java-spanner/issues/3638)) ([e0a3e5b](https://github.com/googleapis/java-spanner/commit/e0a3e5bd169e28e349a2dc92f86a2a9b5510f8f6))


### Dependencies

* Update dependency com.google.cloud:sdk-platform-java-config to v3.43.0 ([#3642](https://github.com/googleapis/java-spanner/issues/3642)) ([c12968a](https://github.com/googleapis/java-spanner/commit/c12968a5f6dad95017d9867d96d4f19a26643a07))

## [6.86.0](https://github.com/googleapis/java-spanner/compare/v6.85.0...v6.86.0) (2025-01-31)


### Features

* Add sample for asymmetric autoscaling instances ([#3562](https://github.com/googleapis/java-spanner/issues/3562)) ([3584b81](https://github.com/googleapis/java-spanner/commit/3584b81a27bfcdd071fbf7e0d40dfa840ea88151))
* Support graph and pipe queries in Connection API ([#3586](https://github.com/googleapis/java-spanner/issues/3586)) ([71c3063](https://github.com/googleapis/java-spanner/commit/71c306346d5b3805f55d5698cf8867d5f4ae519e))


### Bug Fixes

* Always add instance-id for built-in metrics ([#3612](https://github.com/googleapis/java-spanner/issues/3612)) ([705b627](https://github.com/googleapis/java-spanner/commit/705b627646f1679b7d1c4c1f86a853872cf8bfd5))
* **deps:** Update the Java code generator (gapic-generator-java) to 2.51.1 ([3e27251](https://github.com/googleapis/java-spanner/commit/3e272510970d1951b74c4ec9425f1a890790ddb3))
* **deps:** Update the Java code generator (gapic-generator-java) to 2.52.0 ([bf69673](https://github.com/googleapis/java-spanner/commit/bf69673886dbe040292214ed6e64997a230441f6))
* **spanner:** Moved mTLSContext configurator from builder to construtor ([#3605](https://github.com/googleapis/java-spanner/issues/3605)) ([ac7c30b](https://github.com/googleapis/java-spanner/commit/ac7c30bfb14bdafc11675c2a120effde4a71c922))


### Dependencies

* Update dependency com.google.cloud:sdk-platform-java-config to v3.42.0 ([#3616](https://github.com/googleapis/java-spanner/issues/3616)) ([2ea59f0](https://github.com/googleapis/java-spanner/commit/2ea59f05225f2dba2effb503e6abddcfdb6fe6ee))
* Update dependency io.opentelemetry:opentelemetry-bom to v1.46.0 ([#3530](https://github.com/googleapis/java-spanner/issues/3530)) ([d505850](https://github.com/googleapis/java-spanner/commit/d5058504b94501cabd75ad5e7030404b63c3f8b4))


### Documentation

* Clarify how async updates can overtake each other ([#3581](https://github.com/googleapis/java-spanner/issues/3581)) ([1be250f](https://github.com/googleapis/java-spanner/commit/1be250fea686f3a41739c9c8aa474ed956b130e4))
* Fix typo timzeone -&gt; timezone ([bf69673](https://github.com/googleapis/java-spanner/commit/bf69673886dbe040292214ed6e64997a230441f6))
* Fixed parameter arguments for AbstractResultSet's Listener's on TransactionMetadata doc ([#3602](https://github.com/googleapis/java-spanner/issues/3602)) ([1f143a4](https://github.com/googleapis/java-spanner/commit/1f143a4b7b899aec8cf58546f7540a41d1c73731))
* **samples:** Add samples and tests for change streams transaction exclusion ([#3098](https://github.com/googleapis/java-spanner/issues/3098)) ([1f81600](https://github.com/googleapis/java-spanner/commit/1f816009abdbfb32bb26686d8fdb2a771216004e))

## [6.85.0](https://github.com/googleapis/java-spanner/compare/v6.84.0...v6.85.0) (2025-01-10)


### Features

* Add gcp client attributes in OpenTelemetry traces ([#3595](https://github.com/googleapis/java-spanner/issues/3595)) ([7893f24](https://github.com/googleapis/java-spanner/commit/7893f2499f6a43e4e80ec78a9f0da5beedb6967a))
* Add LockHint feature ([#3588](https://github.com/googleapis/java-spanner/issues/3588)) ([326442b](https://github.com/googleapis/java-spanner/commit/326442bca41700debcbeb67b6bd11fc36bd4f26d))
* **spanner:** MTLS setup for spanner external host clients ([#3574](https://github.com/googleapis/java-spanner/issues/3574)) ([f8dd152](https://github.com/googleapis/java-spanner/commit/f8dd15272f2a250c5b57c9f2527d03dbd557d717))


### Dependencies

* Update dependency com.google.api.grpc:proto-google-cloud-monitoring-v3 to v3.56.0 ([#3563](https://github.com/googleapis/java-spanner/issues/3563)) ([e4d0b0f](https://github.com/googleapis/java-spanner/commit/e4d0b0ffa2308c8d949630b52c67e3b79c4491fb))
* Update dependency com.google.api.grpc:proto-google-cloud-monitoring-v3 to v3.57.0 ([#3592](https://github.com/googleapis/java-spanner/issues/3592)) ([a7542da](https://github.com/googleapis/java-spanner/commit/a7542daff466226221eeb9a885a2e67a99adb678))
* Update dependency com.google.cloud:sdk-platform-java-config to v3.41.1 ([#3589](https://github.com/googleapis/java-spanner/issues/3589)) ([2cd4238](https://github.com/googleapis/java-spanner/commit/2cd42388370dac004bfd807f6aede3ba45456706))
* Update dependency com.google.cloud.opentelemetry:exporter-trace to v0.33.0 ([#3455](https://github.com/googleapis/java-spanner/issues/3455)) ([70649dc](https://github.com/googleapis/java-spanner/commit/70649dc2f64aa06404893cc6a36716fc366c83e7))
* Update dependency com.google.re2j:re2j to v1.8 ([#3594](https://github.com/googleapis/java-spanner/issues/3594)) ([0f2013d](https://github.com/googleapis/java-spanner/commit/0f2013d66d3fd14e6be019cda6745ddc32032091))
* Update googleapis/sdk-platform-java action to v2.51.1 ([#3591](https://github.com/googleapis/java-spanner/issues/3591)) ([3daa1a0](https://github.com/googleapis/java-spanner/commit/3daa1a0c735000845558a1d3612257a7d0524350))

## [6.84.0](https://github.com/googleapis/java-spanner/compare/v6.83.0...v6.84.0) (2025-01-06)


### Features

* Add support for ARRAY&lt;STRUCT&gt; to CloudCilentExecutor ([#3544](https://github.com/googleapis/java-spanner/issues/3544)) ([6cbaf7e](https://github.com/googleapis/java-spanner/commit/6cbaf7ec6502d04fc0a0c09720e2054bd10bead9))
* Add transaction runner for connections ([#3559](https://github.com/googleapis/java-spanner/issues/3559)) ([5a1be3d](https://github.com/googleapis/java-spanner/commit/5a1be3dedeafa6858502eadc7918820b9cd90f68))
* Exposing InstanceType in Instance configuration (to define PROVISIONED or FREE spanner instance) ([8d295c4](https://github.com/googleapis/java-spanner/commit/8d295c4a4030b4e97b1d653cc3baf412864f3042))
* Improve tracing by adding attributes ([#3576](https://github.com/googleapis/java-spanner/issues/3576)) ([eee333b](https://github.com/googleapis/java-spanner/commit/eee333b51fa69123e011dfbd2a0896fd31ac10dc))
* **spanner:** Add jdbc support for external hosts ([#3536](https://github.com/googleapis/java-spanner/issues/3536)) ([801346a](https://github.com/googleapis/java-spanner/commit/801346a1b2efe7d0144f7442e1568eb5b02ddcbc))


### Bug Fixes

* AsyncTransactionManager did not always close the session ([#3580](https://github.com/googleapis/java-spanner/issues/3580)) ([d9813a0](https://github.com/googleapis/java-spanner/commit/d9813a05240b966f444168d3b8c30da9d27a8cc4))
* Retry specific internal errors ([#3565](https://github.com/googleapis/java-spanner/issues/3565)) ([b9ce1a6](https://github.com/googleapis/java-spanner/commit/b9ce1a6fcbd11373a5cc82807af15c1cca0dd48e))
* Update max_in_use_session at 10 mins interval ([#3570](https://github.com/googleapis/java-spanner/issues/3570)) ([cc1753d](https://github.com/googleapis/java-spanner/commit/cc1753da72b3e508f8fea8a6d19e1ed3f34e3602))


### Dependencies

* Update opentelemetry.version to v1.45.0 ([#3531](https://github.com/googleapis/java-spanner/issues/3531)) ([78c82ed](https://github.com/googleapis/java-spanner/commit/78c82edb4fcc4a5a9a372225ca429038c3b34955))

## [6.83.0](https://github.com/googleapis/java-spanner/compare/v6.82.0...v6.83.0) (2024-12-13)


### Features

* Add Metrics host for built in metrics ([#3519](https://github.com/googleapis/java-spanner/issues/3519)) ([4ed455a](https://github.com/googleapis/java-spanner/commit/4ed455a43edf7ff8d138ce4d40a52d3224383b14))
* Add opt-in for using multiplexed sessions for blind writes ([#3540](https://github.com/googleapis/java-spanner/issues/3540)) ([216f53e](https://github.com/googleapis/java-spanner/commit/216f53e4cbc0150078ece7785da33b342a6ab082))
* Add UUID in Spanner TypeCode enum ([41f83dc](https://github.com/googleapis/java-spanner/commit/41f83dcf046f955ec289d4e976f40a03922054cb))
* Introduce java.time variables and methods ([#3495](https://github.com/googleapis/java-spanner/issues/3495)) ([8a7d533](https://github.com/googleapis/java-spanner/commit/8a7d533ded21b9b94992b68c702c08bb84474e1b))
* **spanner:** Support multiplexed session for Partitioned operations ([#3231](https://github.com/googleapis/java-spanner/issues/3231)) ([4501a3e](https://github.com/googleapis/java-spanner/commit/4501a3ea69a9346e8b95edf6f94ff839b509ec73))
* Support 'set local' for retry_aborts_internally ([#3532](https://github.com/googleapis/java-spanner/issues/3532)) ([331942f](https://github.com/googleapis/java-spanner/commit/331942f51b11660b9de9c8fe8aacd6f60ac254b5))


### Bug Fixes

* **deps:** Update the Java code generator (gapic-generator-java) to 2.51.0 ([41f83dc](https://github.com/googleapis/java-spanner/commit/41f83dcf046f955ec289d4e976f40a03922054cb))


### Dependencies

* Update sdk platform java dependencies ([#3549](https://github.com/googleapis/java-spanner/issues/3549)) ([6235f0f](https://github.com/googleapis/java-spanner/commit/6235f0f2c223718c537addc450fa5910d1500271))

## [6.82.0](https://github.com/googleapis/java-spanner/compare/v6.81.2...v6.82.0) (2024-12-04)


### Features

* Add option for retrying DML as PDML ([#3480](https://github.com/googleapis/java-spanner/issues/3480)) ([b545557](https://github.com/googleapis/java-spanner/commit/b545557b1a27868aeb5115b3947d42db015cc00e))
* Add the last statement option to ExecuteSqlRequest and ExecuteBatchDmlRequest ([76ab801](https://github.com/googleapis/java-spanner/commit/76ab8011b0aa03e5bb98e375595358732cde31b7))


### Bug Fixes

* **deps:** Update the Java code generator (gapic-generator-java) to 2.50.0 ([76ab801](https://github.com/googleapis/java-spanner/commit/76ab8011b0aa03e5bb98e375595358732cde31b7))
* Shutdown built in metrics meter provider ([#3518](https://github.com/googleapis/java-spanner/issues/3518)) ([c935e2e](https://github.com/googleapis/java-spanner/commit/c935e2eff780100273bc35c11458485c9bb05230))
* **spanner:** GetEdition() is returning null for Instance ([#3496](https://github.com/googleapis/java-spanner/issues/3496)) ([77cb585](https://github.com/googleapis/java-spanner/commit/77cb585d57fd30f953b0ffb80be124e3cb1c6f39))


### Dependencies

* Update dependency commons-io:commons-io to v2.18.0 ([#3492](https://github.com/googleapis/java-spanner/issues/3492)) ([5c8b3ad](https://github.com/googleapis/java-spanner/commit/5c8b3ade163b4cdb81a53f5dcf777ebba48ef265))


### Documentation

* Add Multi Region Encryption samples ([#3524](https://github.com/googleapis/java-spanner/issues/3524)) ([316f971](https://github.com/googleapis/java-spanner/commit/316f97146a1fb9f120b642421ec1196be9abddf0))

## [6.81.2](https://github.com/googleapis/java-spanner/compare/v6.81.1...v6.81.2) (2024-11-20)


### Bug Fixes

* Directpath enabled attribute ([#3477](https://github.com/googleapis/java-spanner/issues/3477)) ([ea1ebad](https://github.com/googleapis/java-spanner/commit/ea1ebadd1ef5d2a343e7117828cae71a798c38eb))


### Dependencies

* Update dependency com.google.api.grpc:proto-google-cloud-monitoring-v3 to v3.55.0 ([#3482](https://github.com/googleapis/java-spanner/issues/3482)) ([bf350b0](https://github.com/googleapis/java-spanner/commit/bf350b024592312b0a00a04c2ab6d3d2312ea686))
* Update dependency com.google.api.grpc:proto-google-cloud-trace-v1 to v2.53.0 ([#3454](https://github.com/googleapis/java-spanner/issues/3454)) ([8729b30](https://github.com/googleapis/java-spanner/commit/8729b30a1043a7e77b0277036c70c7c2616d0b47))
* Update dependency com.google.cloud:google-cloud-trace to v2.53.0 ([#3464](https://github.com/googleapis/java-spanner/issues/3464)) ([a507e4c](https://github.com/googleapis/java-spanner/commit/a507e4c89bb59d154881812f10cab02d68325a08))
* Update dependency com.google.cloud:google-cloud-trace to v2.54.0 ([#3488](https://github.com/googleapis/java-spanner/issues/3488)) ([1d1fecf](https://github.com/googleapis/java-spanner/commit/1d1fecf04a4e800c9b756324914cb1feed7c9866))
* Update googleapis/sdk-platform-java action to v2.50.0 ([#3475](https://github.com/googleapis/java-spanner/issues/3475)) ([e992f18](https://github.com/googleapis/java-spanner/commit/e992f18a651ec034b89aa214cb87ec43f33f2f79))
* Update sdk platform java dependencies ([#3476](https://github.com/googleapis/java-spanner/issues/3476)) ([acb6446](https://github.com/googleapis/java-spanner/commit/acb6446cb952bdbc54ca1b6c53dc466c72cb55b0))

## [6.81.1](https://github.com/googleapis/java-spanner/compare/v6.81.0...v6.81.1) (2024-11-11)


### Bug Fixes

* Client built in metrics. Skip export if instance id is null ([#3447](https://github.com/googleapis/java-spanner/issues/3447)) ([8b2e5ef](https://github.com/googleapis/java-spanner/commit/8b2e5ef5bb391e5a4d4df3cb45d6a3f722a8cfbe))
* **spanner:** Avoid blocking thread in AsyncResultSet ([#3446](https://github.com/googleapis/java-spanner/issues/3446)) ([7c82f1c](https://github.com/googleapis/java-spanner/commit/7c82f1c7823d4d529a70c0da231d2593f00b638b))


### Dependencies

* Update dependency com.google.api.grpc:proto-google-cloud-monitoring-v3 to v3.54.0 ([#3437](https://github.com/googleapis/java-spanner/issues/3437)) ([7e28326](https://github.com/googleapis/java-spanner/commit/7e283261961d6435488ed668133dc3bdd238d402))
* Update dependency com.google.cloud:google-cloud-monitoring to v3.54.0 ([#3438](https://github.com/googleapis/java-spanner/issues/3438)) ([fa18894](https://github.com/googleapis/java-spanner/commit/fa188942c506c85f4c628a8b442b0ee2e6cb845f))
* Update dependency com.google.cloud:google-cloud-trace to v2.53.0 ([#3440](https://github.com/googleapis/java-spanner/issues/3440)) ([314eeb8](https://github.com/googleapis/java-spanner/commit/314eeb823e14c386ea6e65caae8c80e908e05600))
* Update dependency io.opentelemetry:opentelemetry-bom to v1.44.1 ([#3452](https://github.com/googleapis/java-spanner/issues/3452)) ([6518eea](https://github.com/googleapis/java-spanner/commit/6518eea2921006f1aa431e02754118e3d3d3b620))
* Update opentelemetry.version to v1.44.1 ([#3451](https://github.com/googleapis/java-spanner/issues/3451)) ([d9b0271](https://github.com/googleapis/java-spanner/commit/d9b0271603dd14c51954532054b134419150625a))


### Documentation

* Update samples' README.md to ensure given ([#3420](https://github.com/googleapis/java-spanner/issues/3420)) ([663a974](https://github.com/googleapis/java-spanner/commit/663a974dc2a52d773deb620b0bc65f0049f63693))

## [6.81.0](https://github.com/googleapis/java-spanner/compare/v6.80.1...v6.81.0) (2024-11-01)


### Features

* Client built in metrics ([#3408](https://github.com/googleapis/java-spanner/issues/3408)) ([6a36103](https://github.com/googleapis/java-spanner/commit/6a3610379d1d0eee741d5ef4b30e811ff5a67bc0))


### Dependencies

* Update dependency com.google.cloud:google-cloud-monitoring to v3.54.0 ([#3439](https://github.com/googleapis/java-spanner/issues/3439)) ([cdec63f](https://github.com/googleapis/java-spanner/commit/cdec63f84ef9b615adf19e4611b2dc223eec687b))

## [6.80.1](https://github.com/googleapis/java-spanner/compare/v6.80.0...v6.80.1) (2024-10-28)


### Dependencies

* Update googleapis/sdk-platform-java action to v2.49.0 ([#3430](https://github.com/googleapis/java-spanner/issues/3430)) ([beb788c](https://github.com/googleapis/java-spanner/commit/beb788c05d099a0c5edeabb7ed63f4a6a7a24c16))
* Update sdk platform java dependencies ([#3431](https://github.com/googleapis/java-spanner/issues/3431)) ([eef03e9](https://github.com/googleapis/java-spanner/commit/eef03e9e5a5ce9d4fcf9728d6b14630bbb99afce))

## [6.80.0](https://github.com/googleapis/java-spanner/compare/v6.79.0...v6.80.0) (2024-10-25)


### Features

* Enabling endToEndTracing support in Connection API ([#3412](https://github.com/googleapis/java-spanner/issues/3412)) ([16cc6ee](https://github.com/googleapis/java-spanner/commit/16cc6eed58cf735026d7757a28f61f29821a14bf))


### Dependencies

* Update dependency com.google.cloud:sdk-platform-java-config to v3.38.0 ([#3424](https://github.com/googleapis/java-spanner/issues/3424)) ([b727453](https://github.com/googleapis/java-spanner/commit/b727453b93d1089f76e1b908255610cc2796da43))
* Update dependency io.opentelemetry:opentelemetry-bom to v1.43.0 ([#3399](https://github.com/googleapis/java-spanner/issues/3399)) ([a755c6c](https://github.com/googleapis/java-spanner/commit/a755c6c2f44cc3eb0f5a54cd58244cebc62b7a4f))
* Update dependency io.opentelemetry:opentelemetry-sdk-testing to v1.43.0 ([#3398](https://github.com/googleapis/java-spanner/issues/3398)) ([693243a](https://github.com/googleapis/java-spanner/commit/693243afae34610441345645f627bf199e8ddb8b))
* Update googleapis/sdk-platform-java action to v2.48.0 ([#3422](https://github.com/googleapis/java-spanner/issues/3422)) ([d5d1f55](https://github.com/googleapis/java-spanner/commit/d5d1f55d7e8e8f9aa89b7ab9e5f5bd0464bf0e1a))


### Documentation

* Fix tracing sample to exit when completed, and use custom monitored resource for export ([#3287](https://github.com/googleapis/java-spanner/issues/3287)) ([ddb65b1](https://github.com/googleapis/java-spanner/commit/ddb65b197a6f311c2bb8ec9856ea968f3a31d62a))

## [6.79.0](https://github.com/googleapis/java-spanner/compare/v6.78.0...v6.79.0) (2024-10-11)


### Features

* Support DML auto-batching in Connection API ([#3386](https://github.com/googleapis/java-spanner/issues/3386)) ([a1ce267](https://github.com/googleapis/java-spanner/commit/a1ce267cbd4d4c5c638ab7fe0dd5dba24bcfab86))


### Dependencies

* Update dependency com.google.api.grpc:proto-google-cloud-monitoring-v3 to v3.53.0 ([#3390](https://github.com/googleapis/java-spanner/issues/3390)) ([a060e92](https://github.com/googleapis/java-spanner/commit/a060e92141d3dad0db1fc5175416e24a191fa326))
* Update dependency com.google.cloud:google-cloud-monitoring to v3.53.0 ([#3391](https://github.com/googleapis/java-spanner/issues/3391)) ([7f0927d](https://github.com/googleapis/java-spanner/commit/7f0927d495966d7a2ef9023d65545bfe1fecc20b))
* Update dependency com.google.cloud:google-cloud-monitoring to v3.53.0 ([#3392](https://github.com/googleapis/java-spanner/issues/3392)) ([fd3e92d](https://github.com/googleapis/java-spanner/commit/fd3e92da940419cd1aed14f770186381d59a2b47))
* Update dependency com.google.cloud:sdk-platform-java-config to v3.37.0 ([#3395](https://github.com/googleapis/java-spanner/issues/3395)) ([8ecb1a9](https://github.com/googleapis/java-spanner/commit/8ecb1a901f94d9d49efb0278516428e379803088))
* Update dependency com.google.cloud.opentelemetry:exporter-metrics to v0.33.0 ([#3388](https://github.com/googleapis/java-spanner/issues/3388)) ([26aa51d](https://github.com/googleapis/java-spanner/commit/26aa51d561c35295dfb7e2867c3b04b79ce6efc9))
* Update dependency com.google.cloud.opentelemetry:exporter-trace to v0.33.0 ([#3389](https://github.com/googleapis/java-spanner/issues/3389)) ([6e34c5a](https://github.com/googleapis/java-spanner/commit/6e34c5a1c20c20a2e994d112f042a59c9b93e1e6))
* Update googleapis/sdk-platform-java action to v2.47.0 ([#3383](https://github.com/googleapis/java-spanner/issues/3383)) ([4f0d693](https://github.com/googleapis/java-spanner/commit/4f0d69316a910c23abcb2a142e59bbaf550ca89c))

## [6.78.0](https://github.com/googleapis/java-spanner/compare/v6.77.0...v6.78.0) (2024-10-11)


### Features

* Define ReplicaComputeCapacity and AsymmetricAutoscalingOption ([f46a6b3](https://github.com/googleapis/java-spanner/commit/f46a6b34383fe45d63b2db912389b26067f3a853))


### Bug Fixes

* **deps:** Update the Java code generator (gapic-generator-java) to 2.47.0 ([139a715](https://github.com/googleapis/java-spanner/commit/139a715d3f617b20a00b0cf4f5819e5a61a87c96))


### Dependencies

* Update dependency com.google.cloud:google-cloud-trace to v2.52.0 ([#3393](https://github.com/googleapis/java-spanner/issues/3393)) ([79453f9](https://github.com/googleapis/java-spanner/commit/79453f9985eda10631cd29ae58c0cedf234c2e18))

## [6.77.0](https://github.com/googleapis/java-spanner/compare/v6.76.0...v6.77.0) (2024-10-02)


### Features

* Add INTERVAL API ([c078ac3](https://github.com/googleapis/java-spanner/commit/c078ac34c3d14b13bbd4a507de4f0013975dca4e))


### Dependencies

* Update dependency com.google.api.grpc:proto-google-cloud-monitoring-v3 to v3.52.0 ([#3291](https://github.com/googleapis/java-spanner/issues/3291)) ([9241063](https://github.com/googleapis/java-spanner/commit/92410638b0ba88f8e89e28bd12dd58830f7aaeb3))
* Update dependency com.google.cloud:google-cloud-monitoring to v3.52.0 ([#3292](https://github.com/googleapis/java-spanner/issues/3292)) ([da27a19](https://github.com/googleapis/java-spanner/commit/da27a1992e40b1b4591f0232f687d8031387e749))
* Update dependency com.google.cloud:google-cloud-monitoring to v3.52.0 ([#3293](https://github.com/googleapis/java-spanner/issues/3293)) ([c6dbdb2](https://github.com/googleapis/java-spanner/commit/c6dbdb255eb4cd231a2dc7cef94bf3353fa7e837))
* Update dependency com.google.cloud:google-cloud-trace to v2.51.0 ([#3294](https://github.com/googleapis/java-spanner/issues/3294)) ([a269747](https://github.com/googleapis/java-spanner/commit/a269747889ea0b2380f07e1efef3b288a9c4fd04))
* Update dependency com.google.cloud:sdk-platform-java-config to v3.36.1 ([#3355](https://github.com/googleapis/java-spanner/issues/3355)) ([5191e71](https://github.com/googleapis/java-spanner/commit/5191e71a83a316b41564ce2604980c8f33135f2f))
* Update dependency com.google.cloud.opentelemetry:exporter-metrics to v0.32.0 ([#3371](https://github.com/googleapis/java-spanner/issues/3371)) ([d5b5ca0](https://github.com/googleapis/java-spanner/commit/d5b5ca0cccc6cf73d759245d2bd72f33c7d39830))
* Update dependency com.google.cloud.opentelemetry:exporter-trace to v0.32.0 ([#3372](https://github.com/googleapis/java-spanner/issues/3372)) ([aa9a71d](https://github.com/googleapis/java-spanner/commit/aa9a71d38dabd8d1974bb553761e93735ade5c26))
* Update dependency commons-io:commons-io to v2.17.0 ([#3349](https://github.com/googleapis/java-spanner/issues/3349)) ([7c21164](https://github.com/googleapis/java-spanner/commit/7c21164f2b8e75afab268f2fb8e132a372ac0d67))
* Update dependency io.opentelemetry:opentelemetry-bom to v1.42.1 ([#3323](https://github.com/googleapis/java-spanner/issues/3323)) ([95dfc02](https://github.com/googleapis/java-spanner/commit/95dfc02ae2d65f99219dcced66cf4e74d1c4975b))
* Update dependency ubuntu to v24 ([#3356](https://github.com/googleapis/java-spanner/issues/3356)) ([042c294](https://github.com/googleapis/java-spanner/commit/042c294cc5f83eebd2e3600cffb165e5b467d63e))
* Update googleapis/sdk-platform-java action to v2.46.1 ([#3354](https://github.com/googleapis/java-spanner/issues/3354)) ([378f5cf](https://github.com/googleapis/java-spanner/commit/378f5cfb08d4e5ee80b21007bfc829de61bfbdbe))
* Update junixsocket.version to v2.10.1 ([#3367](https://github.com/googleapis/java-spanner/issues/3367)) ([5f94915](https://github.com/googleapis/java-spanner/commit/5f94915941c4e4132f8460a04dde0643fa63ab99))
* Update opentelemetry.version to v1.42.1 ([#3330](https://github.com/googleapis/java-spanner/issues/3330)) ([7b05e43](https://github.com/googleapis/java-spanner/commit/7b05e4301953364617691e8ae225cea823e3a323))


### Documentation

* Update comment for PROFILE QueryMode ([c078ac3](https://github.com/googleapis/java-spanner/commit/c078ac34c3d14b13bbd4a507de4f0013975dca4e))

## [6.76.0](https://github.com/googleapis/java-spanner/compare/v6.75.0...v6.76.0) (2024-09-27)


### Features

* Add opt-in flag and ClientInterceptor to propagate trace context for Spanner end to end tracing ([#3162](https://github.com/googleapis/java-spanner/issues/3162)) ([0b7fdaf](https://github.com/googleapis/java-spanner/commit/0b7fdaf1d25e81ca8dd35a0f8d8caa7b77a7e58c))
* Add samples for backup schedule feature APIs. ([#3339](https://github.com/googleapis/java-spanner/issues/3339)) ([8cd5163](https://github.com/googleapis/java-spanner/commit/8cd516351e7859a81f00f17cb5071edbd804ea90))


### Bug Fixes

* **deps:** Update the Java code generator (gapic-generator-java) to 2.46.1 ([1719f44](https://github.com/googleapis/java-spanner/commit/1719f4465841354db3253fd132868394e530a82d))

## [6.75.0](https://github.com/googleapis/java-spanner/compare/v6.74.1...v6.75.0) (2024-09-19)


### Features

* Support multiplexed session for blind write with single use transaction ([#3229](https://github.com/googleapis/java-spanner/issues/3229)) ([b3e2b0f](https://github.com/googleapis/java-spanner/commit/b3e2b0f4892951867715cb7f354c089fca4f050f))

## [6.74.1](https://github.com/googleapis/java-spanner/compare/v6.74.0...v6.74.1) (2024-09-16)


### Bug Fixes

* Use core pool size 1 for maintainer ([#3314](https://github.com/googleapis/java-spanner/issues/3314)) ([cce008d](https://github.com/googleapis/java-spanner/commit/cce008d212535d32da990242973f7f517ca5d6dc))


### Dependencies

* Update dependency com.google.cloud:sdk-platform-java-config to v3.35.0 ([#3329](https://github.com/googleapis/java-spanner/issues/3329)) ([654835f](https://github.com/googleapis/java-spanner/commit/654835f2433b97665c74be9ec80c169ac905a720))

## [6.74.0](https://github.com/googleapis/java-spanner/compare/v6.73.0...v6.74.0) (2024-08-27)


### Features

* **spanner:** Add edition field to the instance proto ([6b7e6ca](https://github.com/googleapis/java-spanner/commit/6b7e6ca109ea9679b5e36598d3c343fa40bff724))


### Documentation

* Change the example timestamps in Spanner Graph java sample code ([#3295](https://github.com/googleapis/java-spanner/issues/3295)) ([b6490b6](https://github.com/googleapis/java-spanner/commit/b6490b6a6ee2b7399431881a5e87b5ef7b577c89))

## [6.73.0](https://github.com/googleapis/java-spanner/compare/v6.72.0...v6.73.0) (2024-08-22)


### Features

* Add option for cancelling queries when closing client ([#3276](https://github.com/googleapis/java-spanner/issues/3276)) ([95da1ed](https://github.com/googleapis/java-spanner/commit/95da1eddbc979f4ce78c9d1ac15bc4c1faba6dca))


### Bug Fixes

* Github workflow vulnerable to script injection ([#3232](https://github.com/googleapis/java-spanner/issues/3232)) ([599255c](https://github.com/googleapis/java-spanner/commit/599255c36d1fbe8317705a7eeb2a9e400c3efd15))
* Make DecodeMode.DIRECT the deafult ([#3280](https://github.com/googleapis/java-spanner/issues/3280)) ([f31a95a](https://github.com/googleapis/java-spanner/commit/f31a95ab105407305e988e86c8f7b0d8654995e0))
* Synchronize lazy ResultSet decoding ([#3267](https://github.com/googleapis/java-spanner/issues/3267)) ([4219cf8](https://github.com/googleapis/java-spanner/commit/4219cf86dba5e44d55f13ab118113f119c92b9e9))


### Dependencies

* Update dependency com.google.cloud:sdk-platform-java-config to v3.34.0 ([#3277](https://github.com/googleapis/java-spanner/issues/3277)) ([c449a91](https://github.com/googleapis/java-spanner/commit/c449a91628b005481996bce5ab449d62496a4d2d))
* Update dependency commons-cli:commons-cli to v1.9.0 ([#3275](https://github.com/googleapis/java-spanner/issues/3275)) ([84790f7](https://github.com/googleapis/java-spanner/commit/84790f7d437e88739487b148bf963f0ac9dc3f96))
* Update dependency io.opentelemetry:opentelemetry-bom to v1.41.0 ([#3269](https://github.com/googleapis/java-spanner/issues/3269)) ([a7458e9](https://github.com/googleapis/java-spanner/commit/a7458e970e4ca55ff3e312b2129e890576145db1))
* Update dependency org.hamcrest:hamcrest to v3 ([#3271](https://github.com/googleapis/java-spanner/issues/3271)) ([fc2e343](https://github.com/googleapis/java-spanner/commit/fc2e343dc06f80617a2cd6f2bea59b0631e70678))
* Update dependency org.junit.vintage:junit-vintage-engine to v5.11.0 ([#3272](https://github.com/googleapis/java-spanner/issues/3272)) ([1bc0c46](https://github.com/googleapis/java-spanner/commit/1bc0c469b99ebf3778592b04dbf175b00bf5b06e))
* Update opentelemetry.version to v1.41.0 ([#3270](https://github.com/googleapis/java-spanner/issues/3270)) ([88f6b56](https://github.com/googleapis/java-spanner/commit/88f6b56fb243bb17b814a7ae150c8f38dced119a))


### Documentation

* Create a few code snippets as examples for using Spanner Graph using Java ([#3234](https://github.com/googleapis/java-spanner/issues/3234)) ([61f0ab7](https://github.com/googleapis/java-spanner/commit/61f0ab7a48bc3e51b830534b1cfa70e40166ec91))

## [6.72.0](https://github.com/googleapis/java-spanner/compare/v6.71.0...v6.72.0) (2024-08-07)


### Features

* Add `RESOURCE_EXHAUSTED` to the list of retryable error codes ([e859b29](https://github.com/googleapis/java-spanner/commit/e859b29ccf4e68b1ab62cffdd4cf197011ba9878))
* Add field order_by in spanner.proto ([e859b29](https://github.com/googleapis/java-spanner/commit/e859b29ccf4e68b1ab62cffdd4cf197011ba9878))
* Add QueryCancellationAction message in executor protos ([e859b29](https://github.com/googleapis/java-spanner/commit/e859b29ccf4e68b1ab62cffdd4cf197011ba9878))
* Add SessionPoolOptions, SpannerOptions protos in executor protos ([e859b29](https://github.com/googleapis/java-spanner/commit/e859b29ccf4e68b1ab62cffdd4cf197011ba9878))
* Add support for multi region encryption config ([e859b29](https://github.com/googleapis/java-spanner/commit/e859b29ccf4e68b1ab62cffdd4cf197011ba9878))
* Enable hermetic library generation ([#3129](https://github.com/googleapis/java-spanner/issues/3129)) ([94b2a86](https://github.com/googleapis/java-spanner/commit/94b2a8610ac02d2b4212c421f03b4e9561ec9949))
* **spanner:** Add samples for instance partitions ([#3221](https://github.com/googleapis/java-spanner/issues/3221)) ([bc48bf2](https://github.com/googleapis/java-spanner/commit/bc48bf212e37441221b3b6c8742b07ff601f6c41))
* **spanner:** Add support for Cloud Spanner Scheduled Backups ([e859b29](https://github.com/googleapis/java-spanner/commit/e859b29ccf4e68b1ab62cffdd4cf197011ba9878))
* **spanner:** Adding `EXPECTED_FULFILLMENT_PERIOD` to the indicate instance creation times (with `FULFILLMENT_PERIOD_NORMAL` or `FULFILLMENT_PERIOD_EXTENDED` ENUM) with the extended instance creation time triggered by On-Demand Capacity Feature ([e859b29](https://github.com/googleapis/java-spanner/commit/e859b29ccf4e68b1ab62cffdd4cf197011ba9878))
* **spanner:** Set manual affinity incase of gRPC-GCP extenstion ([#3215](https://github.com/googleapis/java-spanner/issues/3215)) ([86b306a](https://github.com/googleapis/java-spanner/commit/86b306a4189483a5fd2746052bed817443630567))
* Support Read RPC OrderBy ([#3180](https://github.com/googleapis/java-spanner/issues/3180)) ([735bca5](https://github.com/googleapis/java-spanner/commit/735bca523e4ea53a24929fb2c27d282c41350e91))


### Bug Fixes

* Make sure commitAsync always finishes ([#3216](https://github.com/googleapis/java-spanner/issues/3216)) ([440c88b](https://github.com/googleapis/java-spanner/commit/440c88bd67e1c9d08445fe26b01bf243f7fd1ca4))
* SessionPoolOptions.Builder#toBuilder() skipped useMultiplexedSessions ([#3197](https://github.com/googleapis/java-spanner/issues/3197)) ([027f92c](https://github.com/googleapis/java-spanner/commit/027f92cf32fee8217d2075db61fe0be58d43a40d))


### Dependencies

* Bump sdk-platform-java-config to 3.33.0 ([#3243](https://github.com/googleapis/java-spanner/issues/3243)) ([35907c6](https://github.com/googleapis/java-spanner/commit/35907c63ae981612ba24dd9605db493b5b864217))
* Update dependencies to latest ([#3250](https://github.com/googleapis/java-spanner/issues/3250)) ([d1d566b](https://github.com/googleapis/java-spanner/commit/d1d566b096915a537e0978715c81bfca00e34ceb))
* Update dependency com.google.auto.value:auto-value-annotations to v1.11.0 ([#3191](https://github.com/googleapis/java-spanner/issues/3191)) ([065cd48](https://github.com/googleapis/java-spanner/commit/065cd489964aaee42fffe1e71327906bde907205))
* Update dependency com.google.cloud:google-cloud-trace to v2.47.0 ([#3067](https://github.com/googleapis/java-spanner/issues/3067)) ([e336ab8](https://github.com/googleapis/java-spanner/commit/e336ab81a1d392d56386f9302bf51bf14e385dad))

## [6.71.0](https://github.com/googleapis/java-spanner/compare/v6.70.0...v6.71.0) (2024-07-03)


### Features

* Include thread name in traces ([#3173](https://github.com/googleapis/java-spanner/issues/3173)) ([92b1e07](https://github.com/googleapis/java-spanner/commit/92b1e079e6093bc4a2e7b458c1bbe0f62a0fada9))
* Support multiplexed sessions for RO transactions ([#3141](https://github.com/googleapis/java-spanner/issues/3141)) ([2b8e9ed](https://github.com/googleapis/java-spanner/commit/2b8e9ededc1ea1a5e8d4f90083f2cf862fcc198a))

## [6.70.0](https://github.com/googleapis/java-spanner/compare/v6.69.0...v6.70.0) (2024-06-27)


### Features

* Add field order_by in spanner.proto ([#3064](https://github.com/googleapis/java-spanner/issues/3064)) ([52ee196](https://github.com/googleapis/java-spanner/commit/52ee1967ee3a37fb0482ad8b51c6e77e28b79844))


### Bug Fixes

* Do not end transaction span when rolling back to savepoint ([#3167](https://github.com/googleapis/java-spanner/issues/3167)) ([8ec0cf2](https://github.com/googleapis/java-spanner/commit/8ec0cf2032dece545c9e4d8a794b80d06550b710))
* Remove unused DmlBatch span ([#3147](https://github.com/googleapis/java-spanner/issues/3147)) ([f7891c1](https://github.com/googleapis/java-spanner/commit/f7891c1ca42727c775cdbe91bff8d55191a3d799))


### Dependencies

* Update dependencies ([#3181](https://github.com/googleapis/java-spanner/issues/3181)) ([0c787e6](https://github.com/googleapis/java-spanner/commit/0c787e6fa67d2a259a76bbd2d7f1cfa20a1dbee8))
* Update dependency com.google.cloud:sdk-platform-java-config to v3.32.0 ([#3184](https://github.com/googleapis/java-spanner/issues/3184)) ([9c85a6f](https://github.com/googleapis/java-spanner/commit/9c85a6fabea527253ea40a8970cc9071804d94c4))
* Update dependency commons-cli:commons-cli to v1.8.0 ([#3073](https://github.com/googleapis/java-spanner/issues/3073)) ([36b5340](https://github.com/googleapis/java-spanner/commit/36b5340ef8bf197fbc8ed882f76caff9a6fe84b6))

## [6.69.0](https://github.com/googleapis/java-spanner/compare/v6.68.1...v6.69.0) (2024-06-12)


### Features

* Add option to enable ApiTracer ([#3095](https://github.com/googleapis/java-spanner/issues/3095)) ([a0a4bc5](https://github.com/googleapis/java-spanner/commit/a0a4bc58d4269a8c1e5e76d9a0469f649bb69148))


### Dependencies

* Update dependency com.google.cloud:sdk-platform-java-config to v3.31.0 ([#3159](https://github.com/googleapis/java-spanner/issues/3159)) ([1ee19d1](https://github.com/googleapis/java-spanner/commit/1ee19d19c2db30d79c8741cc5739de1c69fb95f9))

## [6.68.1](https://github.com/googleapis/java-spanner/compare/v6.68.0...v6.68.1) (2024-05-29)


### Bug Fixes

* Make SessionPoolOptions#setUseMultiplexedSession(boolean) package private ([#3130](https://github.com/googleapis/java-spanner/issues/3130)) ([575c3e0](https://github.com/googleapis/java-spanner/commit/575c3e01541e12294dd37a622f0b1dca52d200ba))

## [6.68.0](https://github.com/googleapis/java-spanner/compare/v6.67.0...v6.68.0) (2024-05-27)


### Features

* [java] allow passing libraries_bom_version from env ([#1967](https://github.com/googleapis/java-spanner/issues/1967)) ([#3112](https://github.com/googleapis/java-spanner/issues/3112)) ([7d5a52c](https://github.com/googleapis/java-spanner/commit/7d5a52c19a4b8028b78fc64a10f1ba6127fa6ffe))
* Allow DML batches in transactions to execute analyzeUpdate ([#3114](https://github.com/googleapis/java-spanner/issues/3114)) ([dee7cda](https://github.com/googleapis/java-spanner/commit/dee7cdabe74058434e4d630846f066dc82fdf512))
* **spanner:** Add support for Proto Columns in Connection API ([#3123](https://github.com/googleapis/java-spanner/issues/3123)) ([7e7c814](https://github.com/googleapis/java-spanner/commit/7e7c814045dc84aaa57e7c716b0221e6cb19bcd1))


### Bug Fixes

* Allow getMetadata() calls before calling next() ([#3111](https://github.com/googleapis/java-spanner/issues/3111)) ([39902c3](https://github.com/googleapis/java-spanner/commit/39902c384f3f7f9438252cbee287f2428faf1440))


### Dependencies

* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.10.2 ([#3117](https://github.com/googleapis/java-spanner/issues/3117)) ([ddebbbb](https://github.com/googleapis/java-spanner/commit/ddebbbbeef976f61f23cdd66c5f7c1f412e2f9bd))

## [6.67.0](https://github.com/googleapis/java-spanner/compare/v6.66.0...v6.67.0) (2024-05-22)


### Features

* Add tracing for batchUpdate, executeUpdate, and connections ([#3097](https://github.com/googleapis/java-spanner/issues/3097)) ([45cdcfc](https://github.com/googleapis/java-spanner/commit/45cdcfcde02aa7976b017a90f81c2ccd28658c8f))


### Performance Improvements

* Minor optimizations to the standard query path ([#3101](https://github.com/googleapis/java-spanner/issues/3101)) ([ec820a1](https://github.com/googleapis/java-spanner/commit/ec820a16e2b3cb1a12a15231491b75cd73afaa13))


### Dependencies

* Update dependency com.google.cloud:google-cloud-monitoring to v3.44.0 ([#3099](https://github.com/googleapis/java-spanner/issues/3099)) ([da44e93](https://github.com/googleapis/java-spanner/commit/da44e932a39ac0124b63914f8ea926998c10ea2e))
* Update dependency com.google.cloud:sdk-platform-java-config to v3.30.1 ([#3116](https://github.com/googleapis/java-spanner/issues/3116)) ([d205a73](https://github.com/googleapis/java-spanner/commit/d205a73714786a609673012b771e7a0722b3e1f2))

## [6.66.0](https://github.com/googleapis/java-spanner/compare/v6.65.1...v6.66.0) (2024-05-03)


### Features

* Allow DDL with autocommit=false ([#3057](https://github.com/googleapis/java-spanner/issues/3057)) ([22833ac](https://github.com/googleapis/java-spanner/commit/22833acf9f073271ce0ee10f2b496f3a1d39566a))
* Include stack trace of checked out sessions in exception ([#3092](https://github.com/googleapis/java-spanner/issues/3092)) ([ba6a0f6](https://github.com/googleapis/java-spanner/commit/ba6a0f644b6caa4d2f3aa130c6061341b70957dd))


### Bug Fixes

* Multiplexed session metrics were not included in refactor move ([#3088](https://github.com/googleapis/java-spanner/issues/3088)) ([f3589c4](https://github.com/googleapis/java-spanner/commit/f3589c430b0e84933a91008bb306c26089788357))


### Dependencies

* Update dependency com.google.cloud:sdk-platform-java-config to v3.30.0 ([#3082](https://github.com/googleapis/java-spanner/issues/3082)) ([ddfc98e](https://github.com/googleapis/java-spanner/commit/ddfc98e240fb47ef51075ba4461bf9a98aa25ce0))

## [6.65.1](https://github.com/googleapis/java-spanner/compare/v6.65.0...v6.65.1) (2024-04-30)


### Dependencies

* Update dependency com.google.cloud:google-cloud-monitoring to v3.43.0 ([#3066](https://github.com/googleapis/java-spanner/issues/3066)) ([97b0a93](https://github.com/googleapis/java-spanner/commit/97b0a93469ea1b0f0c9a3413e2364951c2d667d1))


### Documentation

* Add a sample for max commit delays  ([#2941](https://github.com/googleapis/java-spanner/issues/2941)) ([d3b5097](https://github.com/googleapis/java-spanner/commit/d3b50976f8a6687a6dac2f483ae133c026b81cac))

## [6.65.0](https://github.com/googleapis/java-spanner/compare/v6.64.0...v6.65.0) (2024-04-20)


### Features

* Remove grpclb ([#2760](https://github.com/googleapis/java-spanner/issues/2760)) ([1df09d9](https://github.com/googleapis/java-spanner/commit/1df09d9b9189c5527de91189a063ecc15779ac77))
* Support client-side hints for tags and priority ([#3005](https://github.com/googleapis/java-spanner/issues/3005)) ([48828df](https://github.com/googleapis/java-spanner/commit/48828df3489465bb53a18be50808fbd435f3e896)), closes [#2978](https://github.com/googleapis/java-spanner/issues/2978)


### Bug Fixes

* **deps:** Update the Java code generator (gapic-generator-java) to 2.39.0 ([#3001](https://github.com/googleapis/java-spanner/issues/3001)) ([6cec1bf](https://github.com/googleapis/java-spanner/commit/6cec1bf1bb44a52c62c2310447c6a068a88209ea))
* NullPointerException on AbstractReadContext.span ([#3036](https://github.com/googleapis/java-spanner/issues/3036)) ([55732fd](https://github.com/googleapis/java-spanner/commit/55732fd107ac1d3b8c16eee198c904d54d98b2b4))


### Dependencies

* Update dependency com.google.cloud:sdk-platform-java-config to v3.29.0 ([#3045](https://github.com/googleapis/java-spanner/issues/3045)) ([67a6534](https://github.com/googleapis/java-spanner/commit/67a65346d5a01d118d5220230e3bed6db7e79a33))
* Update dependency commons-cli:commons-cli to v1.7.0 ([#3043](https://github.com/googleapis/java-spanner/issues/3043)) ([9fea7a3](https://github.com/googleapis/java-spanner/commit/9fea7a30e90227e735ad3595f4ca58dfb1ca1b93))

## [6.64.0](https://github.com/googleapis/java-spanner/compare/v6.63.0...v6.64.0) (2024-04-12)


### Features

* Add endpoint connection URL property ([#2969](https://github.com/googleapis/java-spanner/issues/2969)) ([c9be29c](https://github.com/googleapis/java-spanner/commit/c9be29c717924d7f4c5acd8fe09ee371d0101642))
* Add PG OID support ([#2736](https://github.com/googleapis/java-spanner/issues/2736)) ([ba2a4af](https://github.com/googleapis/java-spanner/commit/ba2a4afa5c1d64c932e9687d52b15c28d9dd7d91))
* Add SessionPoolOptions, SpannerOptions protos in executor protos ([#2932](https://github.com/googleapis/java-spanner/issues/2932)) ([1673fd7](https://github.com/googleapis/java-spanner/commit/1673fd70df4ebfaa4b5fa07112d152119427699a))
* Support max_commit_delay in Connection API ([#2954](https://github.com/googleapis/java-spanner/issues/2954)) ([a8f1852](https://github.com/googleapis/java-spanner/commit/a8f185261c812e7d6c92cb61ecc1f9c78ba3c4d9))


### Bug Fixes

* Executor framework changes skipped in clirr checks, and added exception for partition methods in admin class ([#3000](https://github.com/googleapis/java-spanner/issues/3000)) ([c2d8e95](https://github.com/googleapis/java-spanner/commit/c2d8e955abddb0117f1b3b94c2d9650d2cf4fdfd))


### Dependencies

* Update actions/checkout action to v4 ([#3006](https://github.com/googleapis/java-spanner/issues/3006)) ([368a9f3](https://github.com/googleapis/java-spanner/commit/368a9f33758961d8e3fd387ec94d380e7c6460cc))
* Update actions/github-script action to v7 ([#3007](https://github.com/googleapis/java-spanner/issues/3007)) ([b0cfea6](https://github.com/googleapis/java-spanner/commit/b0cfea6e73b7293f564357e8d1c8c6bb2e0cf855))
* Update actions/setup-java action to v4 ([#3008](https://github.com/googleapis/java-spanner/issues/3008)) ([d337080](https://github.com/googleapis/java-spanner/commit/d337080089dbd58cb4bf94f2cb5925f627435d39))
* Update dependency com.google.cloud:google-cloud-monitoring to v3.42.0 ([#2997](https://github.com/googleapis/java-spanner/issues/2997)) ([0615beb](https://github.com/googleapis/java-spanner/commit/0615beb806ef62dbbfcc6bbffd082adc9c62372c))
* Update dependency com.google.cloud:google-cloud-trace to v2.41.0 ([#2998](https://github.com/googleapis/java-spanner/issues/2998)) ([f50cd04](https://github.com/googleapis/java-spanner/commit/f50cd04660f480c62ddbd6c8a9e892cd95ec16b0))
* Update dependency commons-io:commons-io to v2.16.1 ([#3020](https://github.com/googleapis/java-spanner/issues/3020)) ([aafd5b9](https://github.com/googleapis/java-spanner/commit/aafd5b9514c14a0dbfd0bf2616990f3c347ac0c6))
* Update opentelemetry.version to v1.37.0 ([#3021](https://github.com/googleapis/java-spanner/issues/3021)) ([8f1ed2a](https://github.com/googleapis/java-spanner/commit/8f1ed2ac20896fb413749bb18652764096f1fb2d))
* Update stcarolas/setup-maven action to v5 ([#3009](https://github.com/googleapis/java-spanner/issues/3009)) ([541acd2](https://github.com/googleapis/java-spanner/commit/541acd23aaf2c9336615406e30618fb65606e6c5))

## [6.63.0](https://github.com/googleapis/java-spanner/compare/v6.62.1...v6.63.0) (2024-03-30)


### Features

* Add support for transaction-level exclusion from change streams ([#2959](https://github.com/googleapis/java-spanner/issues/2959)) ([7ae376a](https://github.com/googleapis/java-spanner/commit/7ae376acea4dce7a0bb4565d6c9bfdbbb75146c6))


### Dependencies

* Update dependency com.google.cloud:google-cloud-monitoring to v3.40.0 ([#2987](https://github.com/googleapis/java-spanner/issues/2987)) ([0a1ffcb](https://github.com/googleapis/java-spanner/commit/0a1ffcb371bdee6e478e3aa53b0a4591055134e3))
* Update dependency com.google.cloud:google-cloud-trace to v2.39.0 ([#2988](https://github.com/googleapis/java-spanner/issues/2988)) ([cf11641](https://github.com/googleapis/java-spanner/commit/cf116412d46c5047167d4dd60ef9c88c3d9c754b))
* Update dependency commons-io:commons-io to v2.16.0 ([#2986](https://github.com/googleapis/java-spanner/issues/2986)) ([4697261](https://github.com/googleapis/java-spanner/commit/46972619f88018bad1b4e05526a618d38e2e0897))

## [6.62.1](https://github.com/googleapis/java-spanner/compare/v6.62.0...v6.62.1) (2024-03-28)


### Dependencies

* Update dependency com.google.cloud:google-cloud-monitoring to v3.39.0 ([#2966](https://github.com/googleapis/java-spanner/issues/2966)) ([a5cb1dd](https://github.com/googleapis/java-spanner/commit/a5cb1ddd065100497d9215eff30d57361d7e84de))
* Update dependency com.google.cloud:google-cloud-trace to v2.38.0 ([#2967](https://github.com/googleapis/java-spanner/issues/2967)) ([b2dc788](https://github.com/googleapis/java-spanner/commit/b2dc788d5a54244d83a192ecac894ff931f884c4))

## [6.62.0](https://github.com/googleapis/java-spanner/compare/v6.61.0...v6.62.0) (2024-03-19)


### Features

* Allow attempt direct path xds via env var ([#2950](https://github.com/googleapis/java-spanner/issues/2950)) ([247a15f](https://github.com/googleapis/java-spanner/commit/247a15f2b8b858143bc906e0619f95a017ffe5c3))
* Next release from main branch is 6.56.0 ([#2929](https://github.com/googleapis/java-spanner/issues/2929)) ([66374b1](https://github.com/googleapis/java-spanner/commit/66374b1c4ed88e01ff60fb8e1b7409e5dbbcb811))


### Bug Fixes

* Return type of max commit delay option. ([#2953](https://github.com/googleapis/java-spanner/issues/2953)) ([6e937ab](https://github.com/googleapis/java-spanner/commit/6e937ab16d130e72d633979c1a76bf7b3edbe7b6))


### Performance Improvements

* Keep comments when searching for params ([#2951](https://github.com/googleapis/java-spanner/issues/2951)) ([b782725](https://github.com/googleapis/java-spanner/commit/b782725b92a2662c42ad35647b23009ad95a99a5))


### Dependencies

* Update dependency com.google.cloud:google-cloud-monitoring to v3.38.0 ([#2942](https://github.com/googleapis/java-spanner/issues/2942)) ([ba665bd](https://github.com/googleapis/java-spanner/commit/ba665bd483ba70f09770d92028355ad499003fed))
* Update dependency com.google.cloud:google-cloud-trace to v2.37.0 ([#2944](https://github.com/googleapis/java-spanner/issues/2944)) ([b5e608e](https://github.com/googleapis/java-spanner/commit/b5e608ef001473ab5575f1619804b351053c57f2))
* Update dependency com.google.cloud:sdk-platform-java-config to v3.28.1 ([#2952](https://github.com/googleapis/java-spanner/issues/2952)) ([1e45237](https://github.com/googleapis/java-spanner/commit/1e45237dd235484a6a279f71ae7e126727382f9c))
* Update opentelemetry.version to v1.36.0 ([#2945](https://github.com/googleapis/java-spanner/issues/2945)) ([e70b035](https://github.com/googleapis/java-spanner/commit/e70b0357543d38b6e9265e04444cec494ebd6885))


### Documentation

* **samples:** Add tag to statement timeout sample ([#2931](https://github.com/googleapis/java-spanner/issues/2931)) ([2392afe](https://github.com/googleapis/java-spanner/commit/2392afed0d25266294e0ce11c6ae32d7307e6830))

## [6.61.0](https://github.com/googleapis/java-spanner/compare/v6.60.1...v6.61.0) (2024-03-04)


### Features

* Support float32 type ([#2894](https://github.com/googleapis/java-spanner/issues/2894)) ([19b7976](https://github.com/googleapis/java-spanner/commit/19b79764294e938ad85d02b7c0662db6ec3afeda))


### Bug Fixes

* Flaky test issue due to AbortedException. ([#2925](https://github.com/googleapis/java-spanner/issues/2925)) ([cd34c1d](https://github.com/googleapis/java-spanner/commit/cd34c1d3ae9a5a36f4d5516dcf7c3667a9cf015a))


### Dependencies

* Update dependency com.google.cloud:sdk-platform-java-config to v3.27.0 ([#2935](https://github.com/googleapis/java-spanner/issues/2935)) ([f8f835a](https://github.com/googleapis/java-spanner/commit/f8f835a9da705605c492e232a58276c39d1d7e6c))
* Update dependency org.json:json to v20240303 ([#2936](https://github.com/googleapis/java-spanner/issues/2936)) ([1d7044e](https://github.com/googleapis/java-spanner/commit/1d7044e97d16f5296b7de020cd24b11cbe2a7df0))


### Documentation

* Samples and tests for backup Admin APIs and overall spanner Admin APIs. ([#2882](https://github.com/googleapis/java-spanner/issues/2882)) ([de13636](https://github.com/googleapis/java-spanner/commit/de1363645e03f46deed5be41f90ddfed72766751))
* Update all public documents to use auto-generated admin clients. ([#2928](https://github.com/googleapis/java-spanner/issues/2928)) ([ccb110a](https://github.com/googleapis/java-spanner/commit/ccb110ad6835557870933c95cfd76580fd317a16))

## [6.60.1](https://github.com/googleapis/java-spanner/compare/v6.60.0...v6.60.1) (2024-02-23)


### Dependencies

* Update dependency com.google.cloud:google-cloud-monitoring to v3.37.0 ([#2920](https://github.com/googleapis/java-spanner/issues/2920)) ([a3441bb](https://github.com/googleapis/java-spanner/commit/a3441bbad546a1aac1349d6e142a4ac8d32d2a90))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.10.0 ([#2861](https://github.com/googleapis/java-spanner/issues/2861)) ([a652c3b](https://github.com/googleapis/java-spanner/commit/a652c3b6ef6d6ed87d581e73a26a5086acdc5f07))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.10.1 ([#2919](https://github.com/googleapis/java-spanner/issues/2919)) ([8800a28](https://github.com/googleapis/java-spanner/commit/8800a2894a1c17bde1a0da3ffcc868f10f7690d5))
* Update dependency org.json:json to v20240205 ([#2913](https://github.com/googleapis/java-spanner/issues/2913)) ([277ed81](https://github.com/googleapis/java-spanner/commit/277ed81a0beb95ea57f95a9660a4a6b6adea645b))
* Update dependency org.junit.vintage:junit-vintage-engine to v5.10.2 ([#2868](https://github.com/googleapis/java-spanner/issues/2868)) ([71a65ec](https://github.com/googleapis/java-spanner/commit/71a65ecee5af63996297f8692d569d2a9acfd8ac))
* Update opentelemetry.version to v1.35.0 ([#2902](https://github.com/googleapis/java-spanner/issues/2902)) ([3286eae](https://github.com/googleapis/java-spanner/commit/3286eaea96a40c6ace8abed22040a637d291b09c))

## [6.60.0](https://github.com/googleapis/java-spanner/compare/v6.59.0...v6.60.0) (2024-02-21)


### Features

* Add an API method for reordering firewall policies ([62319f0](https://github.com/googleapis/java-spanner/commit/62319f032163c4ad3e8771dd5f92e7b8a086b5ee))
* **spanner:** Add field for multiplexed session in spanner.proto ([62319f0](https://github.com/googleapis/java-spanner/commit/62319f032163c4ad3e8771dd5f92e7b8a086b5ee))
* Update TransactionOptions to include new option exclude_txn_from_change_streams ([#2853](https://github.com/googleapis/java-spanner/issues/2853)) ([62319f0](https://github.com/googleapis/java-spanner/commit/62319f032163c4ad3e8771dd5f92e7b8a086b5ee))


### Bug Fixes

* Add ensureDecoded to proto type ([#2897](https://github.com/googleapis/java-spanner/issues/2897)) ([e99b78c](https://github.com/googleapis/java-spanner/commit/e99b78c5d810195d368112eed2b185d2d99e62a9))
* **spanner:** Fix write replace used by dataflow template and import export ([#2901](https://github.com/googleapis/java-spanner/issues/2901)) ([64b9042](https://github.com/googleapis/java-spanner/commit/64b90429d4fe53f8509a3923e046406b4bc5876a))


### Dependencies

* Update dependency com.google.cloud:google-cloud-trace to v2.36.0 ([#2749](https://github.com/googleapis/java-spanner/issues/2749)) ([51a348a](https://github.com/googleapis/java-spanner/commit/51a348a0c2b84106ea763721bed3420a0d07f30a))


### Documentation

* Update comments ([62319f0](https://github.com/googleapis/java-spanner/commit/62319f032163c4ad3e8771dd5f92e7b8a086b5ee))
* Update the comment regarding eligible SQL shapes for PartitionQuery ([62319f0](https://github.com/googleapis/java-spanner/commit/62319f032163c4ad3e8771dd5f92e7b8a086b5ee))

## [6.59.0](https://github.com/googleapis/java-spanner/compare/v6.58.0...v6.59.0) (2024-02-15)


### Features

* Support public methods to use autogenerated admin clients. ([#2878](https://github.com/googleapis/java-spanner/issues/2878)) ([53bcb3e](https://github.com/googleapis/java-spanner/commit/53bcb3eca2e814472c3def24e8e03d47652a8e42))


### Dependencies

* Update dependency com.google.cloud:sdk-platform-java-config to v3.25.0 ([#2888](https://github.com/googleapis/java-spanner/issues/2888)) ([8e2da51](https://github.com/googleapis/java-spanner/commit/8e2da5126263c7acd134fb7fcfeb590ca190ce8e))


### Documentation

* README for OpenTelemetry metrics and traces ([#2880](https://github.com/googleapis/java-spanner/issues/2880)) ([c8632f5](https://github.com/googleapis/java-spanner/commit/c8632f5b2f462420a8c2a1f4308a68a18a414472))
* Samples and tests for database Admin APIs. ([#2775](https://github.com/googleapis/java-spanner/issues/2775)) ([14ae01c](https://github.com/googleapis/java-spanner/commit/14ae01cd82e455a0dc22d7e3bb8c362e541ede12))

## [6.58.0](https://github.com/googleapis/java-spanner/compare/v6.57.0...v6.58.0) (2024-02-08)


### Features

* Open telemetry implementation ([#2770](https://github.com/googleapis/java-spanner/issues/2770)) ([244d6a8](https://github.com/googleapis/java-spanner/commit/244d6a836795bf07dacd6b766436dbd6bf5fa912))
* **spanner:** Support max_commit_delay in Spanner transactions ([#2854](https://github.com/googleapis/java-spanner/issues/2854)) ([e2b7ae6](https://github.com/googleapis/java-spanner/commit/e2b7ae66648ea775c18c71ab353edd6c0f50e7ac))
* Support Directed Read in Connection API ([#2855](https://github.com/googleapis/java-spanner/issues/2855)) ([ee477c2](https://github.com/googleapis/java-spanner/commit/ee477c2e7c509ce4b7c43da3b68c1433c59e46fb))


### Bug Fixes

* Cast for Proto type ([#2862](https://github.com/googleapis/java-spanner/issues/2862)) ([0a95dba](https://github.com/googleapis/java-spanner/commit/0a95dba47681c9c4cc4e41ecfb5dadec6357bff6))
* Ignore UnsupportedOperationException for virtual threads ([#2866](https://github.com/googleapis/java-spanner/issues/2866)) ([aa9ad7f](https://github.com/googleapis/java-spanner/commit/aa9ad7f5a5e2405e8082a542916c3d1fa7d0fa25))
* Use default query options with statement cache ([#2860](https://github.com/googleapis/java-spanner/issues/2860)) ([741e4cf](https://github.com/googleapis/java-spanner/commit/741e4cf4eb51c4635078cfe2c52b7462bd4cbbd8))


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.24.0 ([#2856](https://github.com/googleapis/java-spanner/issues/2856)) ([968877e](https://github.com/googleapis/java-spanner/commit/968877e4eff7da3ff27180c2a6129b04922d1af4))

## [6.57.0](https://github.com/googleapis/java-spanner/compare/v6.56.0...v6.57.0) (2024-01-29)


### Features

* Add FLOAT32 enum to TypeCode ([#2800](https://github.com/googleapis/java-spanner/issues/2800)) ([383fea5](https://github.com/googleapis/java-spanner/commit/383fea5b5dc434621585a1b5cfd128a01780472a))
* Add support for Proto Columns ([#2779](https://github.com/googleapis/java-spanner/issues/2779)) ([30d37dd](https://github.com/googleapis/java-spanner/commit/30d37dd80c91b2dffdfee732677607ce028fb8d2))
* **spanner:** Add proto descriptors for proto and enum types in create/update/get database ddl requests ([#2774](https://github.com/googleapis/java-spanner/issues/2774)) ([4a906bf](https://github.com/googleapis/java-spanner/commit/4a906bf2719c30dcd7371f497a8a28c250db77be))


### Bug Fixes

* Remove google-cloud-spanner-executor from the BOM ([#2844](https://github.com/googleapis/java-spanner/issues/2844)) ([655000a](https://github.com/googleapis/java-spanner/commit/655000a3b0471b279cbcbe8a4a601337e7274ef8))


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.22.0 ([#2785](https://github.com/googleapis/java-spanner/issues/2785)) ([f689f74](https://github.com/googleapis/java-spanner/commit/f689f742d8754134523ed0394b9c1b8256adcae2))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.23.0 ([#2801](https://github.com/googleapis/java-spanner/issues/2801)) ([95f064f](https://github.com/googleapis/java-spanner/commit/95f064f9f60a17de375e532ec6dd78dca0743e79))


### Documentation

* Samples and tests for instance APIs. ([#2768](https://github.com/googleapis/java-spanner/issues/2768)) ([88e24c7](https://github.com/googleapis/java-spanner/commit/88e24c7a7d046056605a2a824450e0153b339c86))

## [6.56.0](https://github.com/googleapis/java-spanner/compare/v6.55.0...v6.56.0) (2024-01-05)


### Features

* Add autoscaling config in the instance to support autoscaling in systests ([#2756](https://github.com/googleapis/java-spanner/issues/2756)) ([99ae565](https://github.com/googleapis/java-spanner/commit/99ae565c5e90a2862b4f195fe64656ba8a05373d))
* Add support for Directed Read options ([#2766](https://github.com/googleapis/java-spanner/issues/2766)) ([26c6c63](https://github.com/googleapis/java-spanner/commit/26c6c634b685bce66ce7caf05057a98e9cc6f5dc))
* Update OwlBot.yaml file to pull autogenerated executor code ([#2754](https://github.com/googleapis/java-spanner/issues/2754)) ([20562d4](https://github.com/googleapis/java-spanner/commit/20562d4d7e62ab20bb1c4e78547b218a9a506f21))


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.21.0 ([#2772](https://github.com/googleapis/java-spanner/issues/2772)) ([173f520](https://github.com/googleapis/java-spanner/commit/173f520f931073c4c6ddf3b3d98d255fb575914f))


### Documentation

* Samples and tests for auto-generated createDatabase and createInstance APIs. ([#2764](https://github.com/googleapis/java-spanner/issues/2764)) ([74a586f](https://github.com/googleapis/java-spanner/commit/74a586f8713ef742d65400da8f04a750316faf78))

## [6.55.0](https://github.com/googleapis/java-spanner/compare/v6.54.0...v6.55.0) (2023-12-01)


### Features

* Add java sample for managed autoscaler ([#2709](https://github.com/googleapis/java-spanner/issues/2709)) ([9ea4f4f](https://github.com/googleapis/java-spanner/commit/9ea4f4fe2925410b3defb4e53f3f0a328cc2e738))


### Bug Fixes

* **deps:** Update the Java code generator (gapic-generator-java) to 2.30.0 ([#2703](https://github.com/googleapis/java-spanner/issues/2703)) ([961aa78](https://github.com/googleapis/java-spanner/commit/961aa7894be41ff87f1b460aa374ee2ed75a163b))


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.20.0 ([#2746](https://github.com/googleapis/java-spanner/issues/2746)) ([12bcabb](https://github.com/googleapis/java-spanner/commit/12bcabbf1ef82b19524400ebe280d9986bf70ea7))
* Update dependency commons-io:commons-io to v2.15.1 ([#2745](https://github.com/googleapis/java-spanner/issues/2745)) ([b9d9571](https://github.com/googleapis/java-spanner/commit/b9d9571dcc2d1d004cd785d79e45754c0ce63a51))

## [6.54.0](https://github.com/googleapis/java-spanner/compare/v6.53.0...v6.54.0) (2023-11-15)


### Features

* Enable session leaks prevention by cleaning up long-running tra… ([#2655](https://github.com/googleapis/java-spanner/issues/2655)) ([faa7e5d](https://github.com/googleapis/java-spanner/commit/faa7e5dff17897b0432bc505b7ed24c33805f418))


### Bug Fixes

* Copy backup issue when backup is done across different instance IDs ([#2732](https://github.com/googleapis/java-spanner/issues/2732)) ([7f6b158](https://github.com/googleapis/java-spanner/commit/7f6b1582770d2270efc9501136afb17a2677eaeb))
* Respect SPANNER_EMULATOR_HOST env var when autoConfigEmulator=true ([#2730](https://github.com/googleapis/java-spanner/issues/2730)) ([9c19934](https://github.com/googleapis/java-spanner/commit/9c19934a6170232f6ac2478ef9bfcdb2914d2562))


### Dependencies

* Update dependency com.google.cloud:google-cloud-trace to v2.30.0 ([#2725](https://github.com/googleapis/java-spanner/issues/2725)) ([8618042](https://github.com/googleapis/java-spanner/commit/8618042bb716d8a6626bacee59f9e6c6f0d50362))

## [6.53.0](https://github.com/googleapis/java-spanner/compare/v6.52.1...v6.53.0) (2023-11-06)


### Features

* Move session lastUseTime parameter from PooledSession to SessionImpl class. Fix updation of the parameter for chained RPCs within one transaction. ([#2704](https://github.com/googleapis/java-spanner/issues/2704)) ([e75a281](https://github.com/googleapis/java-spanner/commit/e75a2818124621a3ab837151a8e1094fa6c3b8f3))
* Rely on graal-sdk version declaration from property in java-shared-config ([#2696](https://github.com/googleapis/java-spanner/issues/2696)) ([cfab83a](https://github.com/googleapis/java-spanner/commit/cfab83ad3bd1a026e0b3da5a4cc2154b0f8c3ddf))


### Bug Fixes

* Prevent illegal negative timeout values into thread sleep() method in ITTransactionManagerTest. ([#2715](https://github.com/googleapis/java-spanner/issues/2715)) ([1c26cf6](https://github.com/googleapis/java-spanner/commit/1c26cf60efa1b98203af9b21a47e37c8fb1e0e97))


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.19.0 ([#2719](https://github.com/googleapis/java-spanner/issues/2719)) ([e320753](https://github.com/googleapis/java-spanner/commit/e320753b2bd125f94775db9c71a4b7803fa49c38))
* Update dependency com.google.cloud:google-cloud-trace to v2.28.0 ([#2670](https://github.com/googleapis/java-spanner/issues/2670)) ([078b7ca](https://github.com/googleapis/java-spanner/commit/078b7ca95548ac984c79d29197032b3f813abbcf))
* Update dependency com.google.cloud:google-cloud-trace to v2.29.0 ([#2714](https://github.com/googleapis/java-spanner/issues/2714)) ([b400eca](https://github.com/googleapis/java-spanner/commit/b400ecabb9fa6f262befa903163746fac2c7c15e))
* Update dependency commons-cli:commons-cli to v1.6.0 ([#2710](https://github.com/googleapis/java-spanner/issues/2710)) ([e3e8f6a](https://github.com/googleapis/java-spanner/commit/e3e8f6ac82d827280299038d3962fe66b110e0c4))
* Update dependency commons-io:commons-io to v2.15.0 ([#2712](https://github.com/googleapis/java-spanner/issues/2712)) ([a5f59aa](https://github.com/googleapis/java-spanner/commit/a5f59aa3e992d0594519983880a29f17301923e7))
* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.28 ([#2692](https://github.com/googleapis/java-spanner/issues/2692)) ([d8a2b02](https://github.com/googleapis/java-spanner/commit/d8a2b02d43a68e04bebb2349af61cc8901ccd667))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.28 ([#2705](https://github.com/googleapis/java-spanner/issues/2705)) ([2b17f09](https://github.com/googleapis/java-spanner/commit/2b17f095a294defa5ea022c243fa750486b7d496))
* Update dependency org.junit.vintage:junit-vintage-engine to v5.10.1 ([#2723](https://github.com/googleapis/java-spanner/issues/2723)) ([9cf6d0e](https://github.com/googleapis/java-spanner/commit/9cf6d0eae5d2a86c89de2d252d0f4a4dab0b54a4))

## [6.52.1](https://github.com/googleapis/java-spanner/compare/v6.52.0...v6.52.1) (2023-10-20)


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.18.0 ([#2691](https://github.com/googleapis/java-spanner/issues/2691)) ([b425021](https://github.com/googleapis/java-spanner/commit/b4250218a500eb1540920ed0023454d06c54d621))

## [6.52.0](https://github.com/googleapis/java-spanner/compare/v6.51.0...v6.52.0) (2023-10-19)


### Features

* Add support for Managed Autoscaler ([#2624](https://github.com/googleapis/java-spanner/issues/2624)) ([e5e6923](https://github.com/googleapis/java-spanner/commit/e5e6923a351670ab237c411bb4a549533dac1b6b))

## [6.51.0](https://github.com/googleapis/java-spanner/compare/v6.50.1...v6.51.0) (2023-10-14)


### Features

* **spanner:** Add autoscaling config to the instance proto ([#2674](https://github.com/googleapis/java-spanner/issues/2674)) ([8d38ca3](https://github.com/googleapis/java-spanner/commit/8d38ca393a6c0f9df18c9d02fa9392e11af01246))


### Bug Fixes

* Always include default client lib header ([#2676](https://github.com/googleapis/java-spanner/issues/2676)) ([74fd174](https://github.com/googleapis/java-spanner/commit/74fd174a84f6f97949b9caaadddf366aafd4a469))

## [6.50.1](https://github.com/googleapis/java-spanner/compare/v6.50.0...v6.50.1) (2023-10-11)


### Bug Fixes

* Noop in case there is no change in  autocommit value for setAutocommit() method ([#2662](https://github.com/googleapis/java-spanner/issues/2662)) ([9f51b64](https://github.com/googleapis/java-spanner/commit/9f51b6445f064439379af752372a3490a2fd5087))


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.17.0 ([#2660](https://github.com/googleapis/java-spanner/issues/2660)) ([96b9dd6](https://github.com/googleapis/java-spanner/commit/96b9dd6b6a0ee7b1a0a1cc58a8880a10799665e6))
* Update dependency commons-io:commons-io to v2.14.0 ([#2649](https://github.com/googleapis/java-spanner/issues/2649)) ([fa1b73c](https://github.com/googleapis/java-spanner/commit/fa1b73c1bf4700be5e8865211817e2bc7cc77119))

## [6.50.0](https://github.com/googleapis/java-spanner/compare/v6.49.0...v6.50.0) (2023-10-09)


### Features

* Support setting core pool size for async API in system property ([#2632](https://github.com/googleapis/java-spanner/issues/2632)) ([e51c55d](https://github.com/googleapis/java-spanner/commit/e51c55d332bacb9d174a24b0d842b2cba4762db8)), closes [#2631](https://github.com/googleapis/java-spanner/issues/2631)


### Dependencies

* Update dependency com.google.cloud:google-cloud-trace to v2.24.0 ([#2577](https://github.com/googleapis/java-spanner/issues/2577)) ([311c2ad](https://github.com/googleapis/java-spanner/commit/311c2ad97311490893f3abf4da5fe4d511c445dd))

## [6.49.0](https://github.com/googleapis/java-spanner/compare/v6.48.0...v6.49.0) (2023-09-28)


### Features

* Add session pool option for modelling a timeout around session acquisition. ([#2641](https://github.com/googleapis/java-spanner/issues/2641)) ([428e294](https://github.com/googleapis/java-spanner/commit/428e294b94392e290921b5c0eda0139c57d3a185))


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.16.1 ([#2637](https://github.com/googleapis/java-spanner/issues/2637)) ([3f48624](https://github.com/googleapis/java-spanner/commit/3f486245f574f3a6abf4d3b9146b51dc92cf5eea))


### Documentation

* Improve timeout and retry sample ([#2630](https://github.com/googleapis/java-spanner/issues/2630)) ([f03ce56](https://github.com/googleapis/java-spanner/commit/f03ce56119e2985286ede15352f19c3cb6f39979))
* Remove reference to returning clauses for Batch DML ([#2644](https://github.com/googleapis/java-spanner/issues/2644)) ([038d8ca](https://github.com/googleapis/java-spanner/commit/038d8cac3fe06ca2dcf0b4e85f5e536b73ce9313))

## [6.48.0](https://github.com/googleapis/java-spanner/compare/v6.47.0...v6.48.0) (2023-09-26)


### Features

* Add support for BatchWriteAtLeastOnce ([#2520](https://github.com/googleapis/java-spanner/issues/2520)) ([8ea7bd1](https://github.com/googleapis/java-spanner/commit/8ea7bd18e92a7c5547d8a33bf46c1e322326447b))


### Bug Fixes

* Retry aborted errors for writeAtLeastOnce ([#2627](https://github.com/googleapis/java-spanner/issues/2627)) ([2addb19](https://github.com/googleapis/java-spanner/commit/2addb1930a7b9ada4a4304a44a36d8ff1397cf9e))


### Dependencies

* Update actions/checkout action to v4 ([#2608](https://github.com/googleapis/java-spanner/issues/2608)) ([59f3e70](https://github.com/googleapis/java-spanner/commit/59f3e7047a0a9578350b37b46395377d7e014763))
* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.27 ([#2574](https://github.com/googleapis/java-spanner/issues/2574)) ([e804a4c](https://github.com/googleapis/java-spanner/commit/e804a4c60f369ca88b804fef182b5afae44bd05e))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.27 ([#2575](https://github.com/googleapis/java-spanner/issues/2575)) ([6fe132a](https://github.com/googleapis/java-spanner/commit/6fe132a7c1458da4fc28c950009d152643ced038))

## [6.47.0](https://github.com/googleapis/java-spanner/compare/v6.46.0...v6.47.0) (2023-09-12)


### Features

* Add devcontainers for enabling github codespaces usage. ([#2605](https://github.com/googleapis/java-spanner/issues/2605)) ([a7d60f1](https://github.com/googleapis/java-spanner/commit/a7d60f13781f87054a1631ca511492c5c8334751))
* Disable dynamic code loading properties by default ([#2606](https://github.com/googleapis/java-spanner/issues/2606)) ([d855ebb](https://github.com/googleapis/java-spanner/commit/d855ebbd2dec11cdd6cdbe326de81115632598cd))


### Bug Fixes

* Add reflection configurations for com.google.rpc classes ([#2617](https://github.com/googleapis/java-spanner/issues/2617)) ([c42460a](https://github.com/googleapis/java-spanner/commit/c42460ae7b6bb5874cc18c7aecff34186dcbff2a))
* Avoid unbalanced session pool creation ([#2442](https://github.com/googleapis/java-spanner/issues/2442)) ([db751ce](https://github.com/googleapis/java-spanner/commit/db751ceebc8b6981d00cd07ce4742196cc1dd50d))


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.15.0 ([#2615](https://github.com/googleapis/java-spanner/issues/2615)) ([ac762fb](https://github.com/googleapis/java-spanner/commit/ac762fbf079db79eab5f2ebee971b850ac89eb11))

## [6.46.0](https://github.com/googleapis/java-spanner/compare/v6.45.3...v6.46.0) (2023-09-06)


### Features

* Adding support for databoost ([#2505](https://github.com/googleapis/java-spanner/issues/2505)) ([dd3e9a0](https://github.com/googleapis/java-spanner/commit/dd3e9a0fe4846edcab9501b71c3d9e0fa24ed75b))
* Support PostgreSQL for autoConfigEmulator ([#2601](https://github.com/googleapis/java-spanner/issues/2601)) ([fbf1df9](https://github.com/googleapis/java-spanner/commit/fbf1df9f3fb12faaead8634b88fd4843cbdedf5b))


### Bug Fixes

* Fix kokoro windows java8 ci ([#2573](https://github.com/googleapis/java-spanner/issues/2573)) ([465df7b](https://github.com/googleapis/java-spanner/commit/465df7bad12fbea7dbcf6dbabb1b29d088c42665))


### Documentation

* Add sample for transaction timeouts ([#2599](https://github.com/googleapis/java-spanner/issues/2599)) ([59cec9b](https://github.com/googleapis/java-spanner/commit/59cec9b9cdad169bd8de8ab7b264b04150dda7fb))

## [6.45.3](https://github.com/googleapis/java-spanner/compare/v6.45.2...v6.45.3) (2023-08-17)


### Bug Fixes

* Use streaming read/query settings for stream retry ([#2579](https://github.com/googleapis/java-spanner/issues/2579)) ([f78b838](https://github.com/googleapis/java-spanner/commit/f78b838e294f9c29bfc34a5d964933657b70417f))

## [6.45.2](https://github.com/googleapis/java-spanner/compare/v6.45.1...v6.45.2) (2023-08-14)


### Bug Fixes

* GetColumnCount would fail for empty partititioned result sets ([#2588](https://github.com/googleapis/java-spanner/issues/2588)) ([9a2f3fc](https://github.com/googleapis/java-spanner/commit/9a2f3fc01748224fc8084fbf2b4a0223426b1603))

## [6.45.1](https://github.com/googleapis/java-spanner/compare/v6.45.0...v6.45.1) (2023-08-11)


### Bug Fixes

* Always allow metadata queries ([#2580](https://github.com/googleapis/java-spanner/issues/2580)) ([ebb17fc](https://github.com/googleapis/java-spanner/commit/ebb17fc8aeac5fc75e4f135f33dba970f2480585))

## [6.45.0](https://github.com/googleapis/java-spanner/compare/v6.44.0...v6.45.0) (2023-08-04)


### Features

* Enable leader aware routing by default in Connection API. This enables its use in the JDBC driver and PGAdapter. The update contains performance optimisations that will reduce the latency of read/write transactions that originate from a region other than the default leader region. ([2a85446](https://github.com/googleapis/java-spanner/commit/2a85446b162b006ce84a86285af1767c879b27ed))
* Enable leader aware routing by default. This update contains performance optimisations that will reduce the latency of read/write transactions that originate from a region other than the default leader region. ([441c1b0](https://github.com/googleapis/java-spanner/commit/441c1b03c3e976c6304a99fefd93b5c4291e5364))
* Long running transaction clean up background task. Adding configuration options for closing inactive transactions. ([#2419](https://github.com/googleapis/java-spanner/issues/2419)) ([423e1a4](https://github.com/googleapis/java-spanner/commit/423e1a4b483798d9683ff9bd232b53d76e09beb0))
* Support partitioned queries + data boost in Connection API ([#2540](https://github.com/googleapis/java-spanner/issues/2540)) ([4e31d04](https://github.com/googleapis/java-spanner/commit/4e31d046f5d80abe8876a729ddba045c70f3261d))


### Bug Fixes

* Apply stream wait timeout ([#2544](https://github.com/googleapis/java-spanner/issues/2544)) ([5a12cd2](https://github.com/googleapis/java-spanner/commit/5a12cd29601253423c5738be5471a036fd0334be))


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.14.0 ([#2562](https://github.com/googleapis/java-spanner/issues/2562)) ([dbd5c75](https://github.com/googleapis/java-spanner/commit/dbd5c75be39262003092ff4a925ed470cc45f8be))
* Update dependency org.openjdk.jmh:jmh-core to v1.37 ([#2565](https://github.com/googleapis/java-spanner/issues/2565)) ([d5c36bf](https://github.com/googleapis/java-spanner/commit/d5c36bfbb67ecb14854944779da6e4dbd93f3559))
* Update dependency org.openjdk.jmh:jmh-generator-annprocess to v1.37 ([#2566](https://github.com/googleapis/java-spanner/issues/2566)) ([73e92d4](https://github.com/googleapis/java-spanner/commit/73e92d42fe6d334b6efa6485246dc67858adb0a9))

## [6.44.0](https://github.com/googleapis/java-spanner/compare/v6.43.2...v6.44.0) (2023-07-27)


### Features

* Enable leader aware routing by default. This update contains performance optimisations that will reduce the latency of read/write transactions that originate from a region other than the default leader region. ([55c93ac](https://github.com/googleapis/java-spanner/commit/55c93acfeb8c2a6e5cc2f99ca20d0b72fbe6f8a4))
* Foreign key on delete cascade ([#2340](https://github.com/googleapis/java-spanner/issues/2340)) ([f659105](https://github.com/googleapis/java-spanner/commit/f6591053db1c38f0e13e35cba2087a68d3ab1b01))


### Bug Fixes

* Add imports used in sample files. ([#2532](https://github.com/googleapis/java-spanner/issues/2532)) ([9a6d3fc](https://github.com/googleapis/java-spanner/commit/9a6d3fcbaa8d44f2e08407252a69beca1e4525b1))


### Documentation

* Fixing errors  ([#2536](https://github.com/googleapis/java-spanner/issues/2536)) ([8aa407f](https://github.com/googleapis/java-spanner/commit/8aa407f3e1b4c6cf66b679e698992a6a5e3034c0))


### Dependencies

* Update dependency com.google.cloud:google-cloud-monitoring to v3.22.0 ([#2525](https://github.com/googleapis/java-spanner/issues/2525)) ([be0db6f](https://github.com/googleapis/java-spanner/commit/be0db6f10509fe3e5f74aa6ca6569552e65cb87a))
* Update dependency com.google.cloud:google-cloud-monitoring to v3.23.0 ([#2542](https://github.com/googleapis/java-spanner/issues/2542)) ([67351dd](https://github.com/googleapis/java-spanner/commit/67351dd2cb557d461421c4a0321ae6d2d0fd9dcb))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.13.1 ([#2537](https://github.com/googleapis/java-spanner/issues/2537)) ([9396d8d](https://github.com/googleapis/java-spanner/commit/9396d8d8b5450dd545687af6c513b7f6c7a6c283))
* Update dependency com.google.cloud:google-cloud-trace to v2.21.0 ([#2526](https://github.com/googleapis/java-spanner/issues/2526)) ([2d95234](https://github.com/googleapis/java-spanner/commit/2d952347e0eb7db42387d8abb91d4b11d51cef9c))
* Update dependency com.google.cloud:google-cloud-trace to v2.22.0 ([#2543](https://github.com/googleapis/java-spanner/issues/2543)) ([47c6a43](https://github.com/googleapis/java-spanner/commit/47c6a430405ebf1c2fe392991e3f4554e9ac37aa))
* Update dependency org.graalvm.sdk:graal-sdk to v22.3.3 ([#2533](https://github.com/googleapis/java-spanner/issues/2533)) ([0806b11](https://github.com/googleapis/java-spanner/commit/0806b116cc6650b353cee26c83929e7bcdcb1c34))
* Update dependency org.junit.vintage:junit-vintage-engine to v5.10.0 ([#2539](https://github.com/googleapis/java-spanner/issues/2539)) ([8801b2b](https://github.com/googleapis/java-spanner/commit/8801b2bf639b7903958668a2274a6e5d457de00a))

## [6.43.2](https://github.com/googleapis/java-spanner/compare/v6.43.1...v6.43.2) (2023-07-09)


### Bug Fixes

* Recognize ABORT statements for PostgreSQL ([#2479](https://github.com/googleapis/java-spanner/issues/2479)) ([da47b0a](https://github.com/googleapis/java-spanner/commit/da47b0aef7a2e03fc9b5e25cf036ef8d8d001672))


### Documentation

* Add background info for session pool ([#2498](https://github.com/googleapis/java-spanner/issues/2498)) ([0bbb1a1](https://github.com/googleapis/java-spanner/commit/0bbb1a1b5ac6b9d4ea061a2f2a4d26c3bd958d7e))


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.13.0 ([#2521](https://github.com/googleapis/java-spanner/issues/2521)) ([bdb2461](https://github.com/googleapis/java-spanner/commit/bdb2461dfa90535241c333d1cfee33afc2b33eca))

## [6.43.1](https://github.com/googleapis/java-spanner/compare/v6.43.0...v6.43.1) (2023-06-26)


### Dependencies

* Update dependency com.google.cloud:google-cloud-monitoring to v3.20.0 ([#2492](https://github.com/googleapis/java-spanner/issues/2492)) ([faa6807](https://github.com/googleapis/java-spanner/commit/faa68073673e789e35b600dab72152591a647dc6))
* Update dependency com.google.cloud:google-cloud-monitoring to v3.21.0 ([#2510](https://github.com/googleapis/java-spanner/issues/2510)) ([f10400b](https://github.com/googleapis/java-spanner/commit/f10400baf2d320991e75794250b9e1b2fb218718))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.12.0.with temp exclusions. ([#2512](https://github.com/googleapis/java-spanner/issues/2512)) ([ce04645](https://github.com/googleapis/java-spanner/commit/ce0464527ef489d351b9086f6bb8922f295f1897))
* Update dependency com.google.cloud:google-cloud-trace to v2.19.0 ([#2493](https://github.com/googleapis/java-spanner/issues/2493)) ([1dc7cea](https://github.com/googleapis/java-spanner/commit/1dc7cea723658c43b8c8d2e085c964371fb72223))
* Update dependency com.google.cloud:google-cloud-trace to v2.20.0 ([#2511](https://github.com/googleapis/java-spanner/issues/2511)) ([2ea52ec](https://github.com/googleapis/java-spanner/commit/2ea52ec1cef2468e6c36b76797a3878f270badaa))
* Update dependency commons-io:commons-io to v2.13.0 ([#2490](https://github.com/googleapis/java-spanner/issues/2490)) ([b087b0e](https://github.com/googleapis/java-spanner/commit/b087b0e813cacb4f08d12815d9371fe9c004ca9e))
* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.23 ([#2500](https://github.com/googleapis/java-spanner/issues/2500)) ([0b794a6](https://github.com/googleapis/java-spanner/commit/0b794a68d57eb990e013fdd05c72eaed868497b0))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.23 ([#2501](https://github.com/googleapis/java-spanner/issues/2501)) ([9db5c78](https://github.com/googleapis/java-spanner/commit/9db5c7850b53fa10d1856d88908d5e8e95467206))
* Update dependency org.json:json to v20230618 ([#2504](https://github.com/googleapis/java-spanner/issues/2504)) ([8a87fee](https://github.com/googleapis/java-spanner/commit/8a87fee19bb2dd41495a15740893375c8778f71a))

## [6.43.0](https://github.com/googleapis/java-spanner/compare/v6.42.3...v6.43.0) (2023-06-07)


### Features

* Delay transaction start option ([#2462](https://github.com/googleapis/java-spanner/issues/2462)) ([f1cbd16](https://github.com/googleapis/java-spanner/commit/f1cbd168a7e5f48206cdfc2d782835cf7ccb8b0d))
* Make administrative request retries optional ([#2476](https://github.com/googleapis/java-spanner/issues/2476)) ([ee6548c](https://github.com/googleapis/java-spanner/commit/ee6548cfa511d6efc99f508290ed0b1ce025a4cc))


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.11.0 ([#2486](https://github.com/googleapis/java-spanner/issues/2486)) ([82400d5](https://github.com/googleapis/java-spanner/commit/82400d5576c3ffe08ff6bb94d8b1a307e2f41662))

## [6.42.3](https://github.com/googleapis/java-spanner/compare/v6.42.2...v6.42.3) (2023-05-31)


### Performance Improvements

* Only capture the call stack if the call is actually async ([#2471](https://github.com/googleapis/java-spanner/issues/2471)) ([ae9c8ad](https://github.com/googleapis/java-spanner/commit/ae9c8add484bc0f7808571cbcffb7b352d6ed739))

## [6.42.2](https://github.com/googleapis/java-spanner/compare/v6.42.1...v6.42.2) (2023-05-30)


### Dependencies

* Update dependency com.google.cloud:google-cloud-monitoring to v3.19.0 ([#2466](https://github.com/googleapis/java-spanner/issues/2466)) ([6de2cf6](https://github.com/googleapis/java-spanner/commit/6de2cf6a2d075b4347d69b9af21ac0cf96413884))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.10.1 ([#2465](https://github.com/googleapis/java-spanner/issues/2465)) ([0a89f49](https://github.com/googleapis/java-spanner/commit/0a89f49cd55311f4cb84a501aa302eab88b46575))
* Update dependency com.google.cloud:google-cloud-trace to v2.18.0 ([#2467](https://github.com/googleapis/java-spanner/issues/2467)) ([45609ed](https://github.com/googleapis/java-spanner/commit/45609ed65e49147077eaaf3eb90ab0c732eef80b))

## [6.42.1](https://github.com/googleapis/java-spanner/compare/v6.42.0...v6.42.1) (2023-05-22)


### Dependencies

* Update dependency commons-io:commons-io to v2.12.0 ([#2439](https://github.com/googleapis/java-spanner/issues/2439)) ([d08b226](https://github.com/googleapis/java-spanner/commit/d08b226d5da6272b2de5f66ee1657d03268e396d))

## [6.42.0](https://github.com/googleapis/java-spanner/compare/v6.41.0...v6.42.0) (2023-05-15)


### Features

* Add support for UpdateDatabase in Cloud Spanner ([#2265](https://github.com/googleapis/java-spanner/issues/2265)) ([2ea06e7](https://github.com/googleapis/java-spanner/commit/2ea06e70a6f22635bcad7b7e4c79d0cf710dc6dc))
* Add support for UpdateDatabase in Cloud Spanner ([#2429](https://github.com/googleapis/java-spanner/issues/2429)) ([09f20bd](https://github.com/googleapis/java-spanner/commit/09f20bd43913a7a01985fd290964d134612c14eb))


### Bug Fixes

* Add error details for INTERNAL error ([#2413](https://github.com/googleapis/java-spanner/issues/2413)) ([ed62aa6](https://github.com/googleapis/java-spanner/commit/ed62aa666ae34cf5e552e19b6b5dc2a8c6609e4e))
* Use javax.annotation.Nonnull in executor framework ([#2414](https://github.com/googleapis/java-spanner/issues/2414)) ([afcc598](https://github.com/googleapis/java-spanner/commit/afcc598e05c75610db8d0adacd4da79b4c124122))


### Dependencies

* Update dependency com.google.cloud:google-cloud-monitoring to v3.18.0 ([#2426](https://github.com/googleapis/java-spanner/issues/2426)) ([05a45f8](https://github.com/googleapis/java-spanner/commit/05a45f81c2c71dd236fa36cc987e78a6aa31b594))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.9.0 ([#2427](https://github.com/googleapis/java-spanner/issues/2427)) ([42dbfe3](https://github.com/googleapis/java-spanner/commit/42dbfe3600b1d482d64c6c4f6865f88db399bae3))
* Update dependency com.google.cloud:google-cloud-trace to v2.17.0 ([#2428](https://github.com/googleapis/java-spanner/issues/2428)) ([6f7fee8](https://github.com/googleapis/java-spanner/commit/6f7fee81233811f5bc002f212c8972ffc6afbe16))
* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.22 ([#2423](https://github.com/googleapis/java-spanner/issues/2423)) ([679bb36](https://github.com/googleapis/java-spanner/commit/679bb366162575c28bab1df9b87d01517ea8d5aa))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.22 ([#2424](https://github.com/googleapis/java-spanner/issues/2424)) ([a72f4ff](https://github.com/googleapis/java-spanner/commit/a72f4ff64cce2e9c746e8f6a9e107cbd72afa67f))
* Update dependency org.graalvm.sdk:graal-sdk to v22.3.2 ([#2391](https://github.com/googleapis/java-spanner/issues/2391)) ([c082a1f](https://github.com/googleapis/java-spanner/commit/c082a1fccb79cf4c001519eba4a75cef30150541))

## [6.41.0](https://github.com/googleapis/java-spanner/compare/v6.40.1...v6.41.0) (2023-04-28)


### Features

* Add TransactionExecutionOptions support to executor. ([#2396](https://github.com/googleapis/java-spanner/issues/2396)) ([8327f21](https://github.com/googleapis/java-spanner/commit/8327f210df86bf681ffed6a78ccc9e8fd899c967))
* Leader Aware Routing ([#2214](https://github.com/googleapis/java-spanner/issues/2214)) ([9695ace](https://github.com/googleapis/java-spanner/commit/9695acee9195b50e525d87700e86d701b1d9eed2))
* Make leak detection configurable for connections ([#2405](https://github.com/googleapis/java-spanner/issues/2405)) ([85213c8](https://github.com/googleapis/java-spanner/commit/85213c8764fcb7fb12df49baaac9bd00e095f269))


### Dependencies

* Update dependency com.google.api.grpc:proto-google-cloud-spanner-executor-v1 to v1.4.0 ([#2395](https://github.com/googleapis/java-spanner/issues/2395)) ([02dc53c](https://github.com/googleapis/java-spanner/commit/02dc53c097bae3f20d7915fecc9c236c4a5f91f9))
* Update dependency com.google.cloud:google-cloud-monitoring to v3.17.0 ([#2406](https://github.com/googleapis/java-spanner/issues/2406)) ([d46097f](https://github.com/googleapis/java-spanner/commit/d46097f9f17d9009d211c8c0f16b3e084f8fdbad))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.8.0 ([#2400](https://github.com/googleapis/java-spanner/issues/2400)) ([b815cb8](https://github.com/googleapis/java-spanner/commit/b815cb88ff29fb5b9a5d7998e765548244f287c1))
* Update dependency com.google.cloud:google-cloud-trace to v2.16.0 ([#2407](https://github.com/googleapis/java-spanner/issues/2407)) ([7993be2](https://github.com/googleapis/java-spanner/commit/7993be25e9f380071cded2fa4c2bf630d760a53e))
* Update dependency org.junit.vintage:junit-vintage-engine to v5.9.3 ([#2401](https://github.com/googleapis/java-spanner/issues/2401)) ([8aa7a1d](https://github.com/googleapis/java-spanner/commit/8aa7a1dbbf484446ae8eed3cb27d16fc65e6de83))

## [6.40.1](https://github.com/googleapis/java-spanner/compare/v6.40.0...v6.40.1) (2023-04-17)


### Dependencies

* Update dependency com.google.cloud:google-cloud-monitoring to v3.16.0 ([#2383](https://github.com/googleapis/java-spanner/issues/2383)) ([5d5c33a](https://github.com/googleapis/java-spanner/commit/5d5c33ae7c01e10112c72777f202187a50b55ac3))
* Update dependency com.google.cloud:google-cloud-trace to v2.15.0 ([#2384](https://github.com/googleapis/java-spanner/issues/2384)) ([6b4ce1f](https://github.com/googleapis/java-spanner/commit/6b4ce1fc7ffd837fab6250e36269589d95f5b8c6))

## [6.40.0](https://github.com/googleapis/java-spanner/compare/v6.39.0...v6.40.0) (2023-04-14)


### Features

* Savepoints ([#2278](https://github.com/googleapis/java-spanner/issues/2278)) ([b02f584](https://github.com/googleapis/java-spanner/commit/b02f58435b97346cc8e08a96635affe8383981bb))


### Performance Improvements

* Remove custom transport executor ([#2366](https://github.com/googleapis/java-spanner/issues/2366)) ([e27dbe5](https://github.com/googleapis/java-spanner/commit/e27dbe5f58229dab208eeeed44d53e741700c814))


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.7.0 ([#2377](https://github.com/googleapis/java-spanner/issues/2377)) ([40402af](https://github.com/googleapis/java-spanner/commit/40402af54f94f16619d018e252181db29ae6855e))
* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.21 ([#2379](https://github.com/googleapis/java-spanner/issues/2379)) ([ae7262d](https://github.com/googleapis/java-spanner/commit/ae7262d37391c0ec2fee1dcbb24899e4fa16ae17))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.21 ([#2380](https://github.com/googleapis/java-spanner/issues/2380)) ([0cb159e](https://github.com/googleapis/java-spanner/commit/0cb159efc97f02b42f064244e3812a0fd3d82db6))

## [6.39.0](https://github.com/googleapis/java-spanner/compare/v6.38.2...v6.39.0) (2023-04-11)


### Features

* Capture stack trace for session checkout is now optional ([#2350](https://github.com/googleapis/java-spanner/issues/2350)) ([6b6427a](https://github.com/googleapis/java-spanner/commit/6b6427a25af25fde944dfc1dd4bf6a6463682caf))

## [6.38.2](https://github.com/googleapis/java-spanner/compare/v6.38.1...v6.38.2) (2023-04-01)


### Dependencies

* Update dependency com.google.cloud:google-cloud-monitoring to v3.15.0 ([#2356](https://github.com/googleapis/java-spanner/issues/2356)) ([e4c001a](https://github.com/googleapis/java-spanner/commit/e4c001a2a78af756213fb28e01c571721e105262))
* Update dependency com.google.cloud:google-cloud-trace to v2.14.0 ([#2357](https://github.com/googleapis/java-spanner/issues/2357)) ([dbb8e66](https://github.com/googleapis/java-spanner/commit/dbb8e669d855c08f48c15c9eafec03a85fa08bca))

## [6.38.1](https://github.com/googleapis/java-spanner/compare/v6.38.0...v6.38.1) (2023-03-29)


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.6.0 ([#2352](https://github.com/googleapis/java-spanner/issues/2352)) ([19175ce](https://github.com/googleapis/java-spanner/commit/19175ce22777ac68f8c825a438c0a2503234aa42))

## [6.38.0](https://github.com/googleapis/java-spanner/compare/v6.37.0...v6.38.0) (2023-03-20)


### Features

* Add option to wait on session pool creation ([#2329](https://github.com/googleapis/java-spanner/issues/2329)) ([ff17244](https://github.com/googleapis/java-spanner/commit/ff17244ee918fa17c96488a0f7081728cda7b342))
* Add PartitionedUpdate support to executor ([#2228](https://github.com/googleapis/java-spanner/issues/2228)) ([2c8ecf6](https://github.com/googleapis/java-spanner/commit/2c8ecf6fee591df95ee4abfa230c3fcf0c34c589))
* Adding support for databoost enabled in PartitionedRead and PartitionedQuery ([#2316](https://github.com/googleapis/java-spanner/issues/2316)) ([f39e4a3](https://github.com/googleapis/java-spanner/commit/f39e4a383cbe720b9814077317940fa3452e2f96))


### Bug Fixes

* Correcting the proto field Id for field data_boost_enabled ([#2328](https://github.com/googleapis/java-spanner/issues/2328)) ([6159d7e](https://github.com/googleapis/java-spanner/commit/6159d7ec49b17f6bc40e1b8c93d1e64198c59dcf))
* Update executeCloudBatchDmlUpdates. ([#2326](https://github.com/googleapis/java-spanner/issues/2326)) ([27ef53c](https://github.com/googleapis/java-spanner/commit/27ef53c8447bd51a56fdfe6b2b206afe234fad80))


### Dependencies

* Update dependency com.google.cloud:google-cloud-monitoring to v3.14.0 ([#2333](https://github.com/googleapis/java-spanner/issues/2333)) ([9c81109](https://github.com/googleapis/java-spanner/commit/9c81109e452d6bae2598cf6cf541a09423a8ed6e))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.5.0 ([#2335](https://github.com/googleapis/java-spanner/issues/2335)) ([5eac2be](https://github.com/googleapis/java-spanner/commit/5eac2beb2ce5eebb61e70428e2ac2e11593fc986))
* Update dependency com.google.cloud:google-cloud-trace to v2.13.0 ([#2334](https://github.com/googleapis/java-spanner/issues/2334)) ([c461ba0](https://github.com/googleapis/java-spanner/commit/c461ba0b1a145cc3e9bee805ec6ad827376e5168))

## [6.37.0](https://github.com/googleapis/java-spanner/compare/v6.36.1...v6.37.0) (2023-03-03)


### Features

* Adding new fields for Serverless analytics ([#2315](https://github.com/googleapis/java-spanner/issues/2315)) ([ce9cd74](https://github.com/googleapis/java-spanner/commit/ce9cd7469e2fed15711a8dffe944934cdaa45ce8))


### Bug Fixes

* Update test certificate name. ([#2300](https://github.com/googleapis/java-spanner/issues/2300)) ([18e76d6](https://github.com/googleapis/java-spanner/commit/18e76d6636c530c9cfc0ac872d72e321e75c990e))


### Dependencies

* Update dependency com.google.api.grpc:proto-google-cloud-spanner-executor-v1 to v1.3.0 ([#2306](https://github.com/googleapis/java-spanner/issues/2306)) ([8372250](https://github.com/googleapis/java-spanner/commit/8372250e0aaae68b0d610d59c1ee88c4dc0d9e8b))
* Update dependency com.google.cloud:google-cloud-monitoring to v3.13.0 ([#2311](https://github.com/googleapis/java-spanner/issues/2311)) ([6ba613b](https://github.com/googleapis/java-spanner/commit/6ba613b44598e48699aca320683e65572a730fc7))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.4.0 ([#2312](https://github.com/googleapis/java-spanner/issues/2312)) ([266c49c](https://github.com/googleapis/java-spanner/commit/266c49cc58beaa935a328599a3e75d3b1fb4988d))
* Update dependency com.google.cloud:google-cloud-trace to v2.12.0 ([#2313](https://github.com/googleapis/java-spanner/issues/2313)) ([e5f76c6](https://github.com/googleapis/java-spanner/commit/e5f76c6598887b616d371b4d0b3551e236e080f8))
* Update dependency org.json:json to v20230227 ([#2310](https://github.com/googleapis/java-spanner/issues/2310)) ([badcc14](https://github.com/googleapis/java-spanner/commit/badcc14182244929042412f97e5a7e05799eea22))

## [6.36.1](https://github.com/googleapis/java-spanner/compare/v6.36.0...v6.36.1) (2023-02-21)


### Bug Fixes

* Prevent illegal negative timeout values into thread sleep() method while retrying exceptions in unit tests. ([#2268](https://github.com/googleapis/java-spanner/issues/2268)) ([ce66098](https://github.com/googleapis/java-spanner/commit/ce66098c7139ea13d5ea91cf6fbceb5c732b392d))


### Dependencies

* Update dependency com.google.api.grpc:proto-google-cloud-spanner-executor-v1 to v1.2.0 ([#2256](https://github.com/googleapis/java-spanner/issues/2256)) ([f0ca86a](https://github.com/googleapis/java-spanner/commit/f0ca86a0858bde84cc38f1ad8fae5f3c4f4f3395))
* Update dependency com.google.cloud:google-cloud-monitoring to v3.12.0 ([#2284](https://github.com/googleapis/java-spanner/issues/2284)) ([0be701a](https://github.com/googleapis/java-spanner/commit/0be701a8b59277f2cfb990a88e4f1dafcbafdd97))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.3.0 ([#2285](https://github.com/googleapis/java-spanner/issues/2285)) ([bb5d5c6](https://github.com/googleapis/java-spanner/commit/bb5d5c66e78812b943a85e0fd888e7021c11bde1))
* Update dependency com.google.cloud:google-cloud-trace to v2.11.0 ([#2286](https://github.com/googleapis/java-spanner/issues/2286)) ([3c80932](https://github.com/googleapis/java-spanner/commit/3c80932d577de0ea108e695d0a4e542fbfc01deb))
* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.20 ([#2280](https://github.com/googleapis/java-spanner/issues/2280)) ([685d1ea](https://github.com/googleapis/java-spanner/commit/685d1ea1c3bf59cd71093a68c260276c605d835f))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.20 ([#2281](https://github.com/googleapis/java-spanner/issues/2281)) ([f2aabc2](https://github.com/googleapis/java-spanner/commit/f2aabc24770d1b9c505dfc96b39fe81c6a0ad5a5))

## [6.36.0](https://github.com/googleapis/java-spanner/compare/v6.35.2...v6.36.0) (2023-02-08)


### Features

* Support UNRECOGNIZED types + decode BYTES columns lazily ([#2219](https://github.com/googleapis/java-spanner/issues/2219)) ([fc721c4](https://github.com/googleapis/java-spanner/commit/fc721c4d30de6ed9e5bc4fbbe0e1e7b79a5c7490))


### Bug Fixes

* **java:** Skip fixing poms for special modules ([#1744](https://github.com/googleapis/java-spanner/issues/1744)) ([#2244](https://github.com/googleapis/java-spanner/issues/2244)) ([e7f4b40](https://github.com/googleapis/java-spanner/commit/e7f4b4016f8c4c7e4fac0b822f5af2cffd181134))


### Dependencies

* Update dependency com.google.cloud:google-cloud-monitoring to v3.11.0 ([#2262](https://github.com/googleapis/java-spanner/issues/2262)) ([d566613](https://github.com/googleapis/java-spanner/commit/d566613442217bdfc69caea7242464fba2647519))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.2.0 ([#2264](https://github.com/googleapis/java-spanner/issues/2264)) ([b5fdbc0](https://github.com/googleapis/java-spanner/commit/b5fdbc0accdaaf1f63c62c1837d72bb378dc8f43))
* Update dependency com.google.cloud:google-cloud-trace to v2.10.0 ([#2263](https://github.com/googleapis/java-spanner/issues/2263)) ([96f0c81](https://github.com/googleapis/java-spanner/commit/96f0c8181aeb8ca75647a783d8b163f371ad937e))

## [6.35.2](https://github.com/googleapis/java-spanner/compare/v6.35.1...v6.35.2) (2023-01-24)


### Dependencies

* Update dependency com.google.cloud:google-cloud-monitoring to v3.10.0 ([#2249](https://github.com/googleapis/java-spanner/issues/2249)) ([d18780e](https://github.com/googleapis/java-spanner/commit/d18780ec0278fc49495939647fe6a2f9e0b4f94e))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.1.2 ([#2246](https://github.com/googleapis/java-spanner/issues/2246)) ([1adaf7c](https://github.com/googleapis/java-spanner/commit/1adaf7cae629ba7b9903d6512adc7b13b6d1208e))
* Update dependency com.google.cloud:google-cloud-trace to v2.9.0 ([#2250](https://github.com/googleapis/java-spanner/issues/2250)) ([3cd5ab0](https://github.com/googleapis/java-spanner/commit/3cd5ab05e1fd24090fd58c2320b6875135e49b69))

## [6.35.1](https://github.com/googleapis/java-spanner/compare/v6.35.0...v6.35.1) (2023-01-18)


### Dependencies

* Update dependency com.google.cloud:google-cloud-monitoring to v3.9.0 ([#2230](https://github.com/googleapis/java-spanner/issues/2230)) ([717f70f](https://github.com/googleapis/java-spanner/commit/717f70f76f915e15a7283b32a83a6f4ac64fc931))
* Update dependency com.google.cloud:google-cloud-trace to v2.8.0 ([#2231](https://github.com/googleapis/java-spanner/issues/2231)) ([557ea16](https://github.com/googleapis/java-spanner/commit/557ea164ebf948cd78f937c6996fd21e9618d3ae))
* Update dependency org.graalvm.sdk:graal-sdk to v22.3.1 ([#2238](https://github.com/googleapis/java-spanner/issues/2238)) ([d5f5237](https://github.com/googleapis/java-spanner/commit/d5f52375394ef617f4fcb823937a374930f941e7))
* Update dependency org.junit.vintage:junit-vintage-engine to v5.9.2 ([#2223](https://github.com/googleapis/java-spanner/issues/2223)) ([3278f91](https://github.com/googleapis/java-spanner/commit/3278f9167b1b2688ed090a7dfd5874e88b8945a5))

## [6.35.0](https://github.com/googleapis/java-spanner/compare/v6.34.1...v6.35.0) (2023-01-12)


### Features

* Add support for new cloud client test framework in google-cloud-spanner-executor ([#2217](https://github.com/googleapis/java-spanner/issues/2217)) ([d75ebc1](https://github.com/googleapis/java-spanner/commit/d75ebc1387de7ba0e0a32dfcdd564392d43ff555))
* **spanner:** Add samples for fine grained access control ([#2172](https://github.com/googleapis/java-spanner/issues/2172)) ([77969e3](https://github.com/googleapis/java-spanner/commit/77969e35feee4dee3460fcdc45227e9a9d924d74))


### Bug Fixes

* Retry on RST_STREAM internal error ([#2111](https://github.com/googleapis/java-spanner/issues/2111)) ([d5372e6](https://github.com/googleapis/java-spanner/commit/d5372e662624831abc694d81acecf797d32d86e3))


### Dependencies

* Update dependency com.google.cloud:google-cloud-monitoring to v3.8.0 ([#2192](https://github.com/googleapis/java-spanner/issues/2192)) ([fe7e755](https://github.com/googleapis/java-spanner/commit/fe7e755a798b584bf79d16d1f419b1ca7f957172))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.1.1 ([#2222](https://github.com/googleapis/java-spanner/issues/2222)) ([7d3bcca](https://github.com/googleapis/java-spanner/commit/7d3bcca4e5846d823106f724fef42d2ef3a1c822))
* Update dependency com.google.cloud:google-cloud-trace to v2.7.0 ([#2193](https://github.com/googleapis/java-spanner/issues/2193)) ([da2b924](https://github.com/googleapis/java-spanner/commit/da2b924e037dd366d171c481c6db799de7cacc22))
* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.19 ([#2180](https://github.com/googleapis/java-spanner/issues/2180)) ([43b54e9](https://github.com/googleapis/java-spanner/commit/43b54e92b4df3ec6474b8ba7fef61b5b613e6ab0))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.19 ([#2181](https://github.com/googleapis/java-spanner/issues/2181)) ([b42eb38](https://github.com/googleapis/java-spanner/commit/b42eb3866e1fd74f9a9ad2a9dc3d100ac0893f38))

## [6.34.1](https://github.com/googleapis/java-spanner/compare/v6.34.0...v6.34.1) (2022-12-13)


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.1.0 ([#2187](https://github.com/googleapis/java-spanner/issues/2187)) ([4d9df2b](https://github.com/googleapis/java-spanner/commit/4d9df2bac3a2dd6c910ba5fdd466ccd43a226c7f))

## [6.34.0](https://github.com/googleapis/java-spanner/compare/v6.33.0...v6.34.0) (2022-12-12)


### Features

* Setting up 6.33.x branch ([#2184](https://github.com/googleapis/java-spanner/issues/2184)) ([e237a21](https://github.com/googleapis/java-spanner/commit/e237a213cf5cb5edc338ca4e5f8ad5dd0593d2d1))


### Bug Fixes

* Remove the statement of session number limits ([#1928](https://github.com/googleapis/java-spanner/issues/1928)) ([ddd0625](https://github.com/googleapis/java-spanner/commit/ddd062527674659ca2ea73e079bca4dee62ca67f)), closes [#1927](https://github.com/googleapis/java-spanner/issues/1927)
* Update samples/snippets pom.xml configuration to avoid fat jar ([#2100](https://github.com/googleapis/java-spanner/issues/2100)) ([19058b4](https://github.com/googleapis/java-spanner/commit/19058b4cd324ce33e8dd52447bde2486c87d4754))
* Use a proper endpoint for DirectPath tests ([#2186](https://github.com/googleapis/java-spanner/issues/2186)) ([4d74a0d](https://github.com/googleapis/java-spanner/commit/4d74a0d8ae48e190c126ab4047b81cca117f4de1))


### Dependencies

* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.18 ([#2171](https://github.com/googleapis/java-spanner/issues/2171)) ([f348780](https://github.com/googleapis/java-spanner/commit/f3487805fe5f976596e94047c3796bc623eeae95))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.18 ([#2145](https://github.com/googleapis/java-spanner/issues/2145)) ([dcdd2c3](https://github.com/googleapis/java-spanner/commit/dcdd2c3b684e38892fac0abbdf06081e9c7d83b2))

## [6.33.0](https://github.com/googleapis/java-spanner/compare/v6.32.0...v6.33.0) (2022-11-17)


### Features

* Adding samples for Jsonb data type ([#2147](https://github.com/googleapis/java-spanner/issues/2147)) ([1112203](https://github.com/googleapis/java-spanner/commit/1112203bd6bde68fcd04ae68a2a31ec88dd5b1ac))
* Analyze update returns param types ([#2156](https://github.com/googleapis/java-spanner/issues/2156)) ([7c5e3da](https://github.com/googleapis/java-spanner/commit/7c5e3da4c128cb9220213db8b3e2291e33566715))
* Support DML with Returning clause in Connection API ([#1978](https://github.com/googleapis/java-spanner/issues/1978)) ([aac20be](https://github.com/googleapis/java-spanner/commit/aac20bedf9ee7a6a2170f87fa88373b7d364ed9f))
* Support PostgreSQL END statement ([#2131](https://github.com/googleapis/java-spanner/issues/2131)) ([4c29c17](https://github.com/googleapis/java-spanner/commit/4c29c17fb35e51fdad99e393a8f6bb57c914dc8a))
* Update transaction.proto to include different lock modes ([#2112](https://github.com/googleapis/java-spanner/issues/2112)) ([d0195b4](https://github.com/googleapis/java-spanner/commit/d0195b45423b73969636bc911980613a46dffa97))


### Dependencies

* Update dependency com.google.cloud:google-cloud-monitoring to v3.7.0 ([#2164](https://github.com/googleapis/java-spanner/issues/2164)) ([82385b8](https://github.com/googleapis/java-spanner/commit/82385b8526e0299e8c85e4435e3c740474de854c))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.6 ([#2150](https://github.com/googleapis/java-spanner/issues/2150)) ([dba545f](https://github.com/googleapis/java-spanner/commit/dba545ff5ebb069a78b42cbffff032d66dc3d062))
* Update dependency com.google.cloud:google-cloud-trace to v2.6.0 ([#2165](https://github.com/googleapis/java-spanner/issues/2165)) ([99f2779](https://github.com/googleapis/java-spanner/commit/99f277974fdcebf587d1e25ad643575e15cee7ff))
* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.17 ([#2144](https://github.com/googleapis/java-spanner/issues/2144)) ([dd24b89](https://github.com/googleapis/java-spanner/commit/dd24b894fd80ccc962a414bb404d9624336f4612))
* Update dependency org.openjdk.jmh:jmh-core to v1.36 ([#2160](https://github.com/googleapis/java-spanner/issues/2160)) ([29f9096](https://github.com/googleapis/java-spanner/commit/29f9096d1a10bfb9eacdbc4d6dbc4bc9c7ed05c1))
* Update dependency org.openjdk.jmh:jmh-generator-annprocess to v1.36 ([#2161](https://github.com/googleapis/java-spanner/issues/2161)) ([9148aa3](https://github.com/googleapis/java-spanner/commit/9148aa37bfb61af25023d56bfcf6d0e735e51b9a))

## [6.32.0](https://github.com/googleapis/java-spanner/compare/v6.31.2...v6.32.0) (2022-10-27)


### Features

* Enable client to server compression ([#2117](https://github.com/googleapis/java-spanner/issues/2117)) ([50f8425](https://github.com/googleapis/java-spanner/commit/50f8425fe9e1db16ed060337d26feccc9a9813e2))
* Increase default number of channels when gRPC-GCP channel pool is enabled ([#1997](https://github.com/googleapis/java-spanner/issues/1997)) ([44f27fc](https://github.com/googleapis/java-spanner/commit/44f27fc90fa3f9f4914574fb0476e971da4c02ff))
* Update result_set.proto to return undeclared parameters in ExecuteSql API ([#2101](https://github.com/googleapis/java-spanner/issues/2101)) ([826eb93](https://github.com/googleapis/java-spanner/commit/826eb9305095db064f52a15dc502bc0e0df9a984))


### Dependencies

* Update dependency com.google.cloud:google-cloud-monitoring to v3.4.6 ([#2093](https://github.com/googleapis/java-spanner/issues/2093)) ([b08db44](https://github.com/googleapis/java-spanner/commit/b08db443229afdc1d49ef9f5e459cade5e2abe90))
* Update dependency com.google.cloud:google-cloud-monitoring to v3.5.0 ([#2113](https://github.com/googleapis/java-spanner/issues/2113)) ([99d825b](https://github.com/googleapis/java-spanner/commit/99d825b18397ff9e8633b89effa05e61159d956f))
* Update dependency com.google.cloud:google-cloud-monitoring to v3.6.0 ([#2125](https://github.com/googleapis/java-spanner/issues/2125)) ([7d86fe4](https://github.com/googleapis/java-spanner/commit/7d86fe40de29311ad65bd382e55f75326d16c4e3))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.5 ([#2122](https://github.com/googleapis/java-spanner/issues/2122)) ([308a65c](https://github.com/googleapis/java-spanner/commit/308a65c3e07e33f82b7ce474e0e95099192bb593))
* Update dependency com.google.cloud:google-cloud-trace to v2.3.7 ([#2094](https://github.com/googleapis/java-spanner/issues/2094)) ([6ec3f3f](https://github.com/googleapis/java-spanner/commit/6ec3f3f585ed5eaecdb09d5fd1eb6c9af3b22555))
* Update dependency com.google.cloud:google-cloud-trace to v2.4.0 ([#2114](https://github.com/googleapis/java-spanner/issues/2114)) ([84347f1](https://github.com/googleapis/java-spanner/commit/84347f1c6a52f3dfe569649f061cb16e2e466f6a))
* Update dependency com.google.cloud:google-cloud-trace to v2.5.0 ([#2126](https://github.com/googleapis/java-spanner/issues/2126)) ([5167928](https://github.com/googleapis/java-spanner/commit/516792809cf976aeab10709ca62503b7f03bb333))
* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.15 ([#2109](https://github.com/googleapis/java-spanner/issues/2109)) ([bf092ad](https://github.com/googleapis/java-spanner/commit/bf092ad7ac86c500e8a445397e192cb8fb0594ae))
* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.16 ([#2119](https://github.com/googleapis/java-spanner/issues/2119)) ([b2d27e8](https://github.com/googleapis/java-spanner/commit/b2d27e8f841cab096d5ccad64a250c7f0b35f670))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.15 ([#2110](https://github.com/googleapis/java-spanner/issues/2110)) ([d28b202](https://github.com/googleapis/java-spanner/commit/d28b202cfc29e8fbbfdf3612b94bab5c2f319419))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.16 ([#2120](https://github.com/googleapis/java-spanner/issues/2120)) ([151cf77](https://github.com/googleapis/java-spanner/commit/151cf778ff76edaee9e849181f72119ffa6cb897))
* Update dependency org.graalvm.sdk:graal-sdk to v22.2.0.1 ([#2102](https://github.com/googleapis/java-spanner/issues/2102)) ([68c2089](https://github.com/googleapis/java-spanner/commit/68c2089101124b9887af57b2697c35a64eb1a51f))
* Update dependency org.graalvm.sdk:graal-sdk to v22.3.0 ([#2116](https://github.com/googleapis/java-spanner/issues/2116)) ([9d6930b](https://github.com/googleapis/java-spanner/commit/9d6930b77ec479e5f517236852244476c23dc5c8))

## [6.31.2](https://github.com/googleapis/java-spanner/compare/v6.31.1...v6.31.2) (2022-10-05)


### Bug Fixes

* update protobuf to v3.21.7 ([ac71008](https://github.com/googleapis/java-spanner/commit/ac71008bf8b1244cb3c5cf4317a0d25d4ffc5bbd))

## [6.31.1](https://github.com/googleapis/java-spanner/compare/v6.31.0...v6.31.1) (2022-10-03)


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.4 ([#2090](https://github.com/googleapis/java-spanner/issues/2090)) ([8f46938](https://github.com/googleapis/java-spanner/commit/8f46938b67e44a7b739dc156dc8a0a89bcb33ef0))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.14 ([#2031](https://github.com/googleapis/java-spanner/issues/2031)) ([c5e9ba1](https://github.com/googleapis/java-spanner/commit/c5e9ba1c1a47faf89c47a9146a97cb6711dce242))

## [6.31.0](https://github.com/googleapis/java-spanner/compare/v6.30.2...v6.31.0) (2022-09-29)


### Features

* Support customer managed instance configurations ([#1742](https://github.com/googleapis/java-spanner/issues/1742)) ([c1c805c](https://github.com/googleapis/java-spanner/commit/c1c805cf6e9c00f2d6796627d919338be1a0599a))


### Dependencies

* Update dependency com.google.cloud:google-cloud-trace to v2.3.4 ([#2027](https://github.com/googleapis/java-spanner/issues/2027)) ([14890ed](https://github.com/googleapis/java-spanner/commit/14890ed8e0df99eba7c2521a196132c78054b6ed))
* Update dependency com.google.cloud:google-cloud-trace to v2.3.5 ([#2083](https://github.com/googleapis/java-spanner/issues/2083)) ([cef4e0a](https://github.com/googleapis/java-spanner/commit/cef4e0ada98ab65020f32836fc0c8ab1ee0c7eed))
* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.14 ([#2030](https://github.com/googleapis/java-spanner/issues/2030)) ([04b59ff](https://github.com/googleapis/java-spanner/commit/04b59ff8a1efaa32082aa4e9567d90b5956810c6))
* Update dependency org.json:json to v20220924 ([#2035](https://github.com/googleapis/java-spanner/issues/2035)) ([a26a14a](https://github.com/googleapis/java-spanner/commit/a26a14a94ac3ca6cd7eabce6826cce3dde27ea66))

## [6.30.2](https://github.com/googleapis/java-spanner/compare/v6.30.1...v6.30.2) (2022-09-21)


### Dependencies

* Update dependency com.google.cloud:google-cloud-monitoring to v3.4.5 ([#2022](https://github.com/googleapis/java-spanner/issues/2022)) ([0536962](https://github.com/googleapis/java-spanner/commit/0536962df9af3feed237f758a560c24fafd81d60))
* Update dependency org.junit.vintage:junit-vintage-engine to v5.9.1 ([#2023](https://github.com/googleapis/java-spanner/issues/2023)) ([3fb4235](https://github.com/googleapis/java-spanner/commit/3fb423571c1128b7cafdc6596d5366268d74f0e4))

## [6.30.1](https://github.com/googleapis/java-spanner/compare/v6.30.0...v6.30.1) (2022-09-20)


### Dependencies

* Update dependency com.google.cloud:google-cloud-monitoring to v3.4.4 ([#2014](https://github.com/googleapis/java-spanner/issues/2014)) ([9cebad4](https://github.com/googleapis/java-spanner/commit/9cebad485afc8b8d94bd4bc1673542a330451fbd))
* Update dependency com.google.cloud:google-cloud-trace to v2.3.3 ([#2004](https://github.com/googleapis/java-spanner/issues/2004)) ([54f9095](https://github.com/googleapis/java-spanner/commit/54f90957544f0798d9872956dbe40ce822d5167d))

## [6.30.0](https://github.com/googleapis/java-spanner/compare/v6.29.1...v6.30.0) (2022-09-16)


### Features

* Add custom instance config operations ([#1999](https://github.com/googleapis/java-spanner/issues/1999)) ([74f9c3b](https://github.com/googleapis/java-spanner/commit/74f9c3bc161748e52fed9af8f9fa26a236dc0140))
* Add gRPC RLS dependency ([#1875](https://github.com/googleapis/java-spanner/issues/1875)) ([31cf06e](https://github.com/googleapis/java-spanner/commit/31cf06e1f145dfaba8c2ed70732b4eb06086e0cc))
* Default transaction isolation ([#1998](https://github.com/googleapis/java-spanner/issues/1998)) ([33aa21c](https://github.com/googleapis/java-spanner/commit/33aa21c09f01cc40d156035d2b63fca03257ef6c))


### Bug Fixes

* Retries of updates in the Connection API ignored analyze mode ([#2010](https://github.com/googleapis/java-spanner/issues/2010)) ([d54f252](https://github.com/googleapis/java-spanner/commit/d54f2521f1629658bc54f67ba549ea199a77c5a8))


### Dependencies

* Update dependency com.google.cloud:google-cloud-monitoring to v3.4.3 ([#2003](https://github.com/googleapis/java-spanner/issues/2003)) ([2f04f18](https://github.com/googleapis/java-spanner/commit/2f04f18f131cf656a94d8b1a78d311d2cc46797e))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.2 ([#2002](https://github.com/googleapis/java-spanner/issues/2002)) ([342190a](https://github.com/googleapis/java-spanner/commit/342190ab06917d0527316802a6c33da4f20213db))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.3 ([#2013](https://github.com/googleapis/java-spanner/issues/2013)) ([16db975](https://github.com/googleapis/java-spanner/commit/16db975fbcbd7ce8aee74b6988bf0d125619675f))

## [6.29.1](https://github.com/googleapis/java-spanner/compare/v6.29.0...v6.29.1) (2022-09-02)


### Dependencies

* Update dependency com.google.cloud ([e90575d](https://github.com/googleapis/java-spanner/commit/e90575dcb30782d6c8f15a5765b487faf4b66d58))

## [6.29.0](https://github.com/googleapis/java-spanner/compare/v6.28.0...v6.29.0) (2022-08-29)


### Features

* add support for db roles list  ([#1916](https://github.com/googleapis/java-spanner/issues/1916)) ([8034c67](https://github.com/googleapis/java-spanner/commit/8034c67af6cfe24e96cc26b1cea51c3405ed98d6))
* add support for PG JSONB data type ([#1964](https://github.com/googleapis/java-spanner/issues/1964)) ([d2b426f](https://github.com/googleapis/java-spanner/commit/d2b426fda2cd1463dfa0719dd80f8346cbef51c6))
* Adds auto-generated CL for googleapis for jsonb ([#1983](https://github.com/googleapis/java-spanner/issues/1983)) ([23e57ff](https://github.com/googleapis/java-spanner/commit/23e57ffc627d0f688fa656887d82f8f1f99f3675))


### Dependencies

* update dependency com.google.cloud:google-cloud-monitoring to v3.4.1 ([#1968](https://github.com/googleapis/java-spanner/issues/1968)) ([e93ab4c](https://github.com/googleapis/java-spanner/commit/e93ab4cc4031ee2300f4e73d7d3a8e41de1bc7ae))
* update dependency com.google.cloud:google-cloud-trace to v2.3.1 ([#1967](https://github.com/googleapis/java-spanner/issues/1967)) ([6479d19](https://github.com/googleapis/java-spanner/commit/6479d19dcca2b3e3df43a2858f5dcaf85685c31f))

## [6.28.0](https://github.com/googleapis/java-spanner/compare/v6.27.0...v6.28.0) (2022-08-11)


### Features

* Add ListDatabaseRoles API to support role based access control ([cb13534](https://github.com/googleapis/java-spanner/commit/cb13534d7ca2e1b581cb4551d0f95834fbf7b640))
* support multiple PostgreSQL transaction options ([#1949](https://github.com/googleapis/java-spanner/issues/1949)) ([8b99f30](https://github.com/googleapis/java-spanner/commit/8b99f30285e4ef68376aa9bfc11617f74e110bf2))


### Bug Fixes

* target new spanner db admin service config ([#1956](https://github.com/googleapis/java-spanner/issues/1956)) ([cb13534](https://github.com/googleapis/java-spanner/commit/cb13534d7ca2e1b581cb4551d0f95834fbf7b640))
* Use the key instead of the value to verify the number of channels created in ChannelUsageTest. ([#1965](https://github.com/googleapis/java-spanner/issues/1965)) ([ea329bb](https://github.com/googleapis/java-spanner/commit/ea329bb57b343c58bab2680b0c9412e51522b90b))


### Dependencies

* update dependency com.google.cloud:google-cloud-monitoring to v3.3.6 ([#1962](https://github.com/googleapis/java-spanner/issues/1962)) ([5bb9844](https://github.com/googleapis/java-spanner/commit/5bb98441d65ba462c49810f980770406df8ca127))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v3 ([#1960](https://github.com/googleapis/java-spanner/issues/1960)) ([327b5f0](https://github.com/googleapis/java-spanner/commit/327b5f069f8fe4625be49c258c721a4db5fb0f6e))
* update dependency org.junit.vintage:junit-vintage-engine to v5.9.0 ([#1959](https://github.com/googleapis/java-spanner/issues/1959)) ([f908626](https://github.com/googleapis/java-spanner/commit/f90862667613280a8c7a2901ba4b5940b0647eb2))

## [6.27.0](https://github.com/googleapis/java-spanner/compare/v6.26.0...v6.27.0) (2022-07-19)


### Features

* Adding new fields for Instance Create Time and Update Time  ([#1913](https://github.com/googleapis/java-spanner/issues/1913)) ([2c71e02](https://github.com/googleapis/java-spanner/commit/2c71e0233333803f271931f6ef471b7eacfa52d7))


### Dependencies

* update dependency com.google.cloud:google-cloud-monitoring to v3.3.1 ([#1933](https://github.com/googleapis/java-spanner/issues/1933)) ([e3d646b](https://github.com/googleapis/java-spanner/commit/e3d646bae4abf2215d44f282d4faf722c638b823))
* update dependency org.graalvm.buildtools:junit-platform-native to v0.9.13 ([#1944](https://github.com/googleapis/java-spanner/issues/1944)) ([765d11b](https://github.com/googleapis/java-spanner/commit/765d11b2e5ee7b1f12d2d27a139f92efbc1caa07))
* update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.13 ([#1945](https://github.com/googleapis/java-spanner/issues/1945)) ([0da75b8](https://github.com/googleapis/java-spanner/commit/0da75b819d6e9d0f7c6850d77656e46b76ddad6d))
* update dependency org.graalvm.sdk:graal-sdk to v22.2.0 ([#1953](https://github.com/googleapis/java-spanner/issues/1953)) ([c7f1040](https://github.com/googleapis/java-spanner/commit/c7f1040d849901194e5672b270ccee7fbc695d17))

## [6.26.0](https://github.com/googleapis/java-spanner/compare/v6.25.7...v6.26.0) (2022-07-13)


### Features

* Adding two new fields for Instance create_time and update_time ([#1908](https://github.com/googleapis/java-spanner/issues/1908)) ([00b3817](https://github.com/googleapis/java-spanner/commit/00b38178e851401e293aa457f7ba5ea593a7b7c5))
* changes to support data, timestamp and arrays in IT tests ([#1840](https://github.com/googleapis/java-spanner/issues/1840)) ([c667653](https://github.com/googleapis/java-spanner/commit/c667653ec380dccbf205e7b419843da11cf4155a))
* Error Details Improvement ([c8a2184](https://github.com/googleapis/java-spanner/commit/c8a2184c51cc92ec35c759eff68e614fc78fb2e6))
* Error Details Improvement ([#1929](https://github.com/googleapis/java-spanner/issues/1929)) ([c8a2184](https://github.com/googleapis/java-spanner/commit/c8a2184c51cc92ec35c759eff68e614fc78fb2e6))


### Bug Fixes

* enable longpaths support for windows test ([#1485](https://github.com/googleapis/java-spanner/issues/1485)) ([#1946](https://github.com/googleapis/java-spanner/issues/1946)) ([fd0b845](https://github.com/googleapis/java-spanner/commit/fd0b84523535ba583a1b56acbea98835191daa06))


### Dependencies

* update dependency com.google.cloud:google-cloud-trace to v2.3.0 ([#1934](https://github.com/googleapis/java-spanner/issues/1934)) ([2813eb2](https://github.com/googleapis/java-spanner/commit/2813eb21c9f168e8dea149e40dac188933c7e2db))

## [6.25.7](https://github.com/googleapis/java-spanner/compare/v6.25.6...v6.25.7) (2022-06-30)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.13.0 ([#1924](https://github.com/googleapis/java-spanner/issues/1924)) ([dde5ee8](https://github.com/googleapis/java-spanner/commit/dde5ee8c5fcef36b415929aa32931dc811036eb4))
* update dependency org.graalvm.buildtools:junit-platform-native to v0.9.12 ([#1906](https://github.com/googleapis/java-spanner/issues/1906)) ([1800cd9](https://github.com/googleapis/java-spanner/commit/1800cd917c26934768296253cbbcf7c91c54afef))

## [6.25.6](https://github.com/googleapis/java-spanner/compare/v6.25.5...v6.25.6) (2022-06-22)


### Bug Fixes

* PostgreSQL parser should not treat \ as an escape char ([#1921](https://github.com/googleapis/java-spanner/issues/1921)) ([260bbe3](https://github.com/googleapis/java-spanner/commit/260bbe3cb78e0583975d7085ae5a95dbfd3efd73)), closes [#1920](https://github.com/googleapis/java-spanner/issues/1920)


### Documentation

* **sample:** relocate native image sample from old repo ([#1758](https://github.com/googleapis/java-spanner/issues/1758)) ([ef187f4](https://github.com/googleapis/java-spanner/commit/ef187f4fccaf1c5550e9f6795228e6c7361030db))


### Dependencies

* update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.11 ([#1907](https://github.com/googleapis/java-spanner/issues/1907)) ([01f8a07](https://github.com/googleapis/java-spanner/commit/01f8a07c64358368615d8c729c7c47c4b2c687fd))
* update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.12 ([#1918](https://github.com/googleapis/java-spanner/issues/1918)) ([be8b50b](https://github.com/googleapis/java-spanner/commit/be8b50b56e51245d941c52445498600025e26ba9))

## [6.25.5](https://github.com/googleapis/java-spanner/compare/v6.25.4...v6.25.5) (2022-05-31)


### Bug Fixes

* add configurations for Explain feature ([#1899](https://github.com/googleapis/java-spanner/issues/1899)) ([86895b7](https://github.com/googleapis/java-spanner/commit/86895b756d963a13f138842a6743ea6d24b7c391))
* gracefully ignore RejectedExecutionException during Connection#close() ([#1887](https://github.com/googleapis/java-spanner/issues/1887)) ([091bd1d](https://github.com/googleapis/java-spanner/commit/091bd1d3757751a29c962e2c0b7f4f8720e06a6a))

### [6.25.4](https://github.com/googleapis/java-spanner/compare/v6.25.3...v6.25.4) (2022-05-26)


### Dependencies

* update dependency org.graalvm.sdk:graal-sdk to v22.1.0.1 ([#1894](https://github.com/googleapis/java-spanner/issues/1894)) ([cddb745](https://github.com/googleapis/java-spanner/commit/cddb745e0b7212225a430d1823e9670eb968f98a))

### [6.25.3](https://github.com/googleapis/java-spanner/compare/v6.25.2...v6.25.3) (2022-05-25)


### Bug Fixes

* add native image configurations for Spanner classes ([#1858](https://github.com/googleapis/java-spanner/issues/1858)) ([92d0292](https://github.com/googleapis/java-spanner/commit/92d02922c23e9445c438b69017634415e05d2d98))

### [6.25.2](https://github.com/googleapis/java-spanner/compare/v6.25.1...v6.25.2) (2022-05-25)


### Dependencies

* update dependency com.google.cloud:google-cloud-monitoring to v3.3.0 ([#1888](https://github.com/googleapis/java-spanner/issues/1888)) ([1b109e9](https://github.com/googleapis/java-spanner/commit/1b109e9fd66c74b70af808eced162a684287200e))
* update dependency com.google.cloud:google-cloud-trace to v2.2.0 ([#1889](https://github.com/googleapis/java-spanner/issues/1889)) ([f89f70e](https://github.com/googleapis/java-spanner/commit/f89f70e95e068998ff5f9e211fa1172c4fe37b94))

### [6.25.1](https://github.com/googleapis/java-spanner/compare/v6.25.0...v6.25.1) (2022-05-23)


### Dependencies

* update dependency org.openjdk.jmh:jmh-generator-annprocess to v1.35 ([#1790](https://github.com/googleapis/java-spanner/issues/1790)) ([d68095b](https://github.com/googleapis/java-spanner/commit/d68095b274bb8ef778176d4ff88d54b607e3de73))

## [6.25.0](https://github.com/googleapis/java-spanner/compare/v6.24.0...v6.25.0) (2022-05-20)


### Features

* add build scripts for native image testing in Java 17 ([#1440](https://github.com/googleapis/java-spanner/issues/1440)) ([#1881](https://github.com/googleapis/java-spanner/issues/1881)) ([993e893](https://github.com/googleapis/java-spanner/commit/993e89365d167e07114ebc352dfa835487045ecb))
* Add support for Explain feature ([#1852](https://github.com/googleapis/java-spanner/issues/1852)) ([01f460e](https://github.com/googleapis/java-spanner/commit/01f460e9fc755c02797c50a50d8dc2df31116268))
* AuditConfig for IAM v1 ([f7437b2](https://github.com/googleapis/java-spanner/commit/f7437b294a7c05f288142626d71c7aff00616c89))
* support analyze DDL statement ([#1879](https://github.com/googleapis/java-spanner/issues/1879)) ([1704ac3](https://github.com/googleapis/java-spanner/commit/1704ac3dbcf959294b6d609b4dce2aa1fa80d594))
* support analyzeUpdate ([#1867](https://github.com/googleapis/java-spanner/issues/1867)) ([2d8cfa4](https://github.com/googleapis/java-spanner/commit/2d8cfa40a22e5b77a39b6ec86552734ec47afbe0))


### Bug Fixes

* ignore errors during Connection.close() ([#1877](https://github.com/googleapis/java-spanner/issues/1877)) ([6ab8ed2](https://github.com/googleapis/java-spanner/commit/6ab8ed236b1393e67a4edc5d430d9535dffbadb5))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.12.0 ([#1880](https://github.com/googleapis/java-spanner/issues/1880)) ([daccd1b](https://github.com/googleapis/java-spanner/commit/daccd1b394a95f59246b36ef91c5d9459b3be577))
* update opencensus.version to v0.31.1 ([#1863](https://github.com/googleapis/java-spanner/issues/1863)) ([2d2b526](https://github.com/googleapis/java-spanner/commit/2d2b526777b918f50511ef57433a809a672ab832))

## [6.24.0](https://github.com/googleapis/java-spanner/compare/v6.23.3...v6.24.0) (2022-05-05)


### Features

* Copy backup samples ([#1802](https://github.com/googleapis/java-spanner/issues/1802)) ([787ccad](https://github.com/googleapis/java-spanner/commit/787ccadcba01193d541bfd1b80b055fb5d4c2bb3))
* support CREATE DATABASE in Connection API ([#1845](https://github.com/googleapis/java-spanner/issues/1845)) ([40110fe](https://github.com/googleapis/java-spanner/commit/40110feb22986c6b5dac6885eae7f0b331aede61))
* support CredentialsProvider in Connection API ([#1869](https://github.com/googleapis/java-spanner/issues/1869)) ([f1d2d3e](https://github.com/googleapis/java-spanner/commit/f1d2d3ef1dbd30c153616c2efcc362c1330705e1))


### Dependencies

* update dependency com.google.cloud:google-cloud-monitoring to v3.2.8 ([#1831](https://github.com/googleapis/java-spanner/issues/1831)) ([088fb50](https://github.com/googleapis/java-spanner/commit/088fb50a673a99e6921503be0f84b8291173240e))
* update dependency com.google.cloud:google-cloud-monitoring to v3.2.9 ([#1851](https://github.com/googleapis/java-spanner/issues/1851)) ([4d6bb2d](https://github.com/googleapis/java-spanner/commit/4d6bb2dd233fba60d213d36f15aead67dff57dec))
* update dependency com.google.cloud:google-cloud-trace to v2.1.11 ([#1799](https://github.com/googleapis/java-spanner/issues/1799)) ([049635d](https://github.com/googleapis/java-spanner/commit/049635d4bc3210bd9ce41444f17c8b9d67af969a))


### Documentation

* add samples for PostgresSQL ([#1781](https://github.com/googleapis/java-spanner/issues/1781)) ([e832298](https://github.com/googleapis/java-spanner/commit/e8322986f158a86cdbb04332a9c49ead79fb2587))

### [6.23.3](https://github.com/googleapis/java-spanner/compare/v6.23.2...v6.23.3) (2022-04-21)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.10.0 ([#1830](https://github.com/googleapis/java-spanner/issues/1830)) ([3c55eb3](https://github.com/googleapis/java-spanner/commit/3c55eb336e77ee1ddfb6c055722697f81419578c))


### Documentation

* add samples for PostgreSQL ([#1700](https://github.com/googleapis/java-spanner/issues/1700)) ([a024483](https://github.com/googleapis/java-spanner/commit/a02448388ba2415d31593a8c81b4430e2264c10c))

### [6.23.2](https://github.com/googleapis/java-spanner/compare/v6.23.1...v6.23.2) (2022-04-11)


### Dependencies

* update dependency com.google.cloud:google-cloud-monitoring to v3.2.7 ([#1810](https://github.com/googleapis/java-spanner/issues/1810)) ([0acb53d](https://github.com/googleapis/java-spanner/commit/0acb53d430a0e7170fccc0cf936de9123d9b1689))
* update dependency org.openjdk.jmh:jmh-core to v1.35 ([#1789](https://github.com/googleapis/java-spanner/issues/1789)) ([3511fe6](https://github.com/googleapis/java-spanner/commit/3511fe6cd1b929b916048dc95ba3c966138730a7))

### [6.23.1](https://github.com/googleapis/java-spanner/compare/v6.23.0...v6.23.1) (2022-03-29)


### Dependencies

* update dependency com.google.cloud:google-cloud-monitoring to v3.2.6 ([#1797](https://github.com/googleapis/java-spanner/issues/1797)) ([48097de](https://github.com/googleapis/java-spanner/commit/48097dec5fd6c748d32cb666f82b8e9bfcfffe46))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.9.0 ([#1791](https://github.com/googleapis/java-spanner/issues/1791)) ([603e91c](https://github.com/googleapis/java-spanner/commit/603e91c7be63caf563d415b6f8b301b5edf7bb5e))

## [6.23.0](https://github.com/googleapis/java-spanner/compare/v6.22.0...v6.23.0) (2022-03-28)


### Features

* Copy Backup Support ([#1778](https://github.com/googleapis/java-spanner/issues/1778)) ([dc79366](https://github.com/googleapis/java-spanner/commit/dc79366f05f28d4b1a68240989b5ad06621e4a01))

## [6.22.0](https://github.com/googleapis/java-spanner/compare/v6.21.2...v6.22.0) (2022-03-25)


### Features

* Cross Region backup proto changes ([#1754](https://github.com/googleapis/java-spanner/issues/1754)) ([6d64104](https://github.com/googleapis/java-spanner/commit/6d641044fae595acaafd6020359598c0efd4551f))
* support PG show transaction isolation level ([#1777](https://github.com/googleapis/java-spanner/issues/1777)) ([111f74c](https://github.com/googleapis/java-spanner/commit/111f74c36776a481452ccb9b631a017cab592189))


### Bug Fixes

* Correct recording values in opencensus measureMap in HeaderInterceptor ([#1726](https://github.com/googleapis/java-spanner/issues/1726)) ([bdb2b89](https://github.com/googleapis/java-spanner/commit/bdb2b89e17fe0957e393aea3a0b2f310158dc1e8))
* return errors from BatchCreateSession to dialect detection ([#1760](https://github.com/googleapis/java-spanner/issues/1760)) ([6550a9d](https://github.com/googleapis/java-spanner/commit/6550a9d64b3e5525085f26bf1344e4524f8d0ffb)), closes [#1759](https://github.com/googleapis/java-spanner/issues/1759)


### Dependencies

* update dependency com.google.cloud:google-cloud-trace to v2.1.7 ([#1748](https://github.com/googleapis/java-spanner/issues/1748)) ([a794387](https://github.com/googleapis/java-spanner/commit/a7943878ccebb2e48431fb50a0e9f3974e21dcfa))
* update dependency com.google.cloud:google-cloud-trace to v2.1.8 ([#1757](https://github.com/googleapis/java-spanner/issues/1757)) ([2b54949](https://github.com/googleapis/java-spanner/commit/2b54949ec5082f1aab4b3b5b46bf0bef94f73d9e))
* update dependency com.google.cloud:google-cloud-trace to v2.1.9 ([#1782](https://github.com/googleapis/java-spanner/issues/1782)) ([d623b7e](https://github.com/googleapis/java-spanner/commit/d623b7e40592fd02e2f08355a002205fbbce14f5))
* update dependency org.json:json to v20220320 ([#1761](https://github.com/googleapis/java-spanner/issues/1761)) ([6eee5eb](https://github.com/googleapis/java-spanner/commit/6eee5ebf5117d59e001e85546bf046970f367505))

### [6.21.2](https://github.com/googleapis/java-spanner/compare/v6.21.1...v6.21.2) (2022-03-10)


### Dependencies

* update dependency com.google.cloud:google-cloud-trace to v2.1.6 ([#1743](https://github.com/googleapis/java-spanner/issues/1743)) ([6b0f813](https://github.com/googleapis/java-spanner/commit/6b0f813c29d580391179d27f5fd3ab7d81a9d43c))

### [6.21.1](https://github.com/googleapis/java-spanner/compare/v6.21.0...v6.21.1) (2022-03-09)


### Dependencies

* update dependency com.google.cloud:google-cloud-trace to v2.1.5 ([#1739](https://github.com/googleapis/java-spanner/issues/1739)) ([b553c03](https://github.com/googleapis/java-spanner/commit/b553c032131a5fe147e48ff031a85b2ee5d982be))

## [6.21.0](https://github.com/googleapis/java-spanner/compare/v6.20.0...v6.21.0) (2022-03-08)


### Features

* parse query parameters in PostgreSQL query ([#1732](https://github.com/googleapis/java-spanner/issues/1732)) ([7357ac6](https://github.com/googleapis/java-spanner/commit/7357ac6e3ddfdfee37e70343a970e7e63fb08bf2))
* Track PG Adapter usage from user-agent headers ([#1711](https://github.com/googleapis/java-spanner/issues/1711)) ([cb640ab](https://github.com/googleapis/java-spanner/commit/cb640abeb8ec9321136b86d5b54e620dba087080))


### Bug Fixes

* annotating some fields as REQUIRED ([#1695](https://github.com/googleapis/java-spanner/issues/1695)) ([8b90b6c](https://github.com/googleapis/java-spanner/commit/8b90b6cce0fd36a1e3ca1c8e0c0f34661ab9c2a3))
* catch ExecutionException for op.getName ([#1729](https://github.com/googleapis/java-spanner/issues/1729)) ([8ea3ac0](https://github.com/googleapis/java-spanner/commit/8ea3ac086371beebd22f04c8c5f74beb8058e84f))
* PostgreSQL supports newline in quoted literals and identifiers ([#1731](https://github.com/googleapis/java-spanner/issues/1731)) ([f403d99](https://github.com/googleapis/java-spanner/commit/f403d99acd21db8d494855d71b5ec410164a5232))


### Dependencies

* update dependency com.google.cloud:google-cloud-monitoring to v3.2.4 ([#1719](https://github.com/googleapis/java-spanner/issues/1719)) ([20336cd](https://github.com/googleapis/java-spanner/commit/20336cd5d3307a48f968587212af38872dec5a50))
* update dependency com.google.cloud:google-cloud-monitoring to v3.2.5 ([#1727](https://github.com/googleapis/java-spanner/issues/1727)) ([92a9f14](https://github.com/googleapis/java-spanner/commit/92a9f148b8dcbd0ac7ca1ff0029ad7c09f577e40))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.8.0 ([#1722](https://github.com/googleapis/java-spanner/issues/1722)) ([9704974](https://github.com/googleapis/java-spanner/commit/9704974a92f56886269e6cbcb1f74528fbe7e73f))
* update dependency com.google.cloud:google-cloud-trace to v2.1.4 ([#1728](https://github.com/googleapis/java-spanner/issues/1728)) ([d193a26](https://github.com/googleapis/java-spanner/commit/d193a26ec46df1b229103ec50c0db9b62d98507a))

## [6.20.0](https://github.com/googleapis/java-spanner/compare/v6.19.1...v6.20.0) (2022-02-22)


### Features

* allows for getting json columns using getValue ([#1699](https://github.com/googleapis/java-spanner/issues/1699)) ([a51973b](https://github.com/googleapis/java-spanner/commit/a51973b1a87c0a57b114892fe39a24caa1458d1d))


### Bug Fixes

* **java:** make system property accessible for native image compilation ([#1694](https://github.com/googleapis/java-spanner/issues/1694)) ([e3fb2b2](https://github.com/googleapis/java-spanner/commit/e3fb2b273f939314d9cdbce539f373d6fc77d0ad))
* use information_schema instead of pg_catalog for dialect detection ([#1708](https://github.com/googleapis/java-spanner/issues/1708)) ([91e157a](https://github.com/googleapis/java-spanner/commit/91e157a6dcd08afd81a4cbddffcb8e02defb8d3a))

### [6.19.1](https://github.com/googleapis/java-spanner/compare/v6.19.0...v6.19.1) (2022-02-18)


### Dependencies

* update dependency com.google.cloud:google-cloud-monitoring to v3.2.3 ([#1698](https://github.com/googleapis/java-spanner/issues/1698)) ([cd4f4ca](https://github.com/googleapis/java-spanner/commit/cd4f4ca3fe870227dceae8c6ab66993477b4bdc4))
* update dependency com.google.cloud:google-cloud-trace to v2.1.3 ([#1684](https://github.com/googleapis/java-spanner/issues/1684)) ([e70e5c4](https://github.com/googleapis/java-spanner/commit/e70e5c4c9c9ce0b8d18f9f1f7d01baf6a97ec264))

## [6.19.0](https://github.com/googleapis/java-spanner/compare/v6.18.0...v6.19.0) (2022-02-16)


### Features

* automatically detect database dialect ([#1677](https://github.com/googleapis/java-spanner/issues/1677)) ([9eccfc4](https://github.com/googleapis/java-spanner/commit/9eccfc441237272b01140c1f3d7da51b2b985554))
* PostgreSQL dialect databases ([#1673](https://github.com/googleapis/java-spanner/issues/1673)) ([5f156f2](https://github.com/googleapis/java-spanner/commit/5f156f2efdb4726679766b385d500a030c24e477))


### Bug Fixes

* allow getting metadata without calling next() ([#1691](https://github.com/googleapis/java-spanner/issues/1691)) ([4cfe74e](https://github.com/googleapis/java-spanner/commit/4cfe74ef780f57747ea1dfef1a7098f809bcb300))
* do not delete session in close method for BatchReadOnlyTransactionImpl ([#1688](https://github.com/googleapis/java-spanner/issues/1688)) ([5dc3e19](https://github.com/googleapis/java-spanner/commit/5dc3e191bee603a7feec29b7d4412646d53d73e4))
* untyped null parameters would cause NPE ([#1680](https://github.com/googleapis/java-spanner/issues/1680)) ([7095f94](https://github.com/googleapis/java-spanner/commit/7095f940638d786745ed6715cf7a221d3e4a41a9)), closes [#1679](https://github.com/googleapis/java-spanner/issues/1679)


### Dependencies

* update dependency com.google.cloud:google-cloud-monitoring to v3.2.2 ([#1666](https://github.com/googleapis/java-spanner/issues/1666)) ([8ea2220](https://github.com/googleapis/java-spanner/commit/8ea22205ea1361012b8f237af9150f320b41cc23))
* update dependency com.google.cloud:google-cloud-trace to v2.1.2 ([#1664](https://github.com/googleapis/java-spanner/issues/1664)) ([4f46635](https://github.com/googleapis/java-spanner/commit/4f46635577f0e754ce271e4aba338b84d34f57dd))

## [6.18.0](https://github.com/googleapis/java-spanner/compare/v6.17.4...v6.18.0) (2022-02-03)


### Features

* add database dialect ([#1657](https://github.com/googleapis/java-spanner/issues/1657)) ([269f090](https://github.com/googleapis/java-spanner/commit/269f090805b366fcd7a7163a6602268b4d143aa4))
* Updating readme with new gfe latency metrics ([#1630](https://github.com/googleapis/java-spanner/issues/1630)) ([d02601a](https://github.com/googleapis/java-spanner/commit/d02601ac73a1b9ab580480c4370ba26260996d8c))


### Dependencies

* **java:** update actions/github-script action to v5 ([#1339](https://github.com/googleapis/java-spanner/issues/1339)) ([#1659](https://github.com/googleapis/java-spanner/issues/1659)) ([203b346](https://github.com/googleapis/java-spanner/commit/203b346e748b78e56aad2246c3970593a7584825))
* update actions/github-script action to v5 ([#1658](https://github.com/googleapis/java-spanner/issues/1658)) ([a2f3790](https://github.com/googleapis/java-spanner/commit/a2f3790c35ecc960b50979caa12f6355f397c127))
* update dependency com.google.cloud:google-cloud-monitoring to v3.2.1 ([#1637](https://github.com/googleapis/java-spanner/issues/1637)) ([73c9434](https://github.com/googleapis/java-spanner/commit/73c94349b56710adc788c3a8440648e7f66f228b))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.7.0 ([#1662](https://github.com/googleapis/java-spanner/issues/1662)) ([ece31c0](https://github.com/googleapis/java-spanner/commit/ece31c0d873ee537b167792dcbe9dc62d783a52d))
* update opencensus.version to v0.31.0 ([#1661](https://github.com/googleapis/java-spanner/issues/1661)) ([1e86a3a](https://github.com/googleapis/java-spanner/commit/1e86a3a4542e6744cb1d8a8dbca36218c147c9f0))

### [6.17.4](https://www.github.com/googleapis/java-spanner/compare/v6.17.3...v6.17.4) (2022-01-07)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.6.0 ([#1632](https://www.github.com/googleapis/java-spanner/issues/1632)) ([c7d4d4d](https://www.github.com/googleapis/java-spanner/commit/c7d4d4d833e9027642a870e5f03cf768c02216e3))
* update dependency com.google.cloud:google-cloud-trace to v2.1.1 ([#1633](https://www.github.com/googleapis/java-spanner/issues/1633)) ([4607c21](https://www.github.com/googleapis/java-spanner/commit/4607c21518a13fd9e48a8876bbfa9f587dbe1823))

### [6.17.3](https://www.github.com/googleapis/java-spanner/compare/v6.17.2...v6.17.3) (2021-12-17)


### Bug Fixes

* re-adds test-jar to bom definition ([#1596](https://www.github.com/googleapis/java-spanner/issues/1596)) ([5accdcd](https://www.github.com/googleapis/java-spanner/commit/5accdcdb163a4f434ba1b47ac4f1ecba92be6f67))


### Dependencies

* bump OpenCensus API to 0.30.0 ([#1598](https://www.github.com/googleapis/java-spanner/issues/1598)) ([b953363](https://www.github.com/googleapis/java-spanner/commit/b953363c531cd2cd7e831d546a30b3bbfab54268))

### [6.17.2](https://www.github.com/googleapis/java-spanner/compare/v6.17.1...v6.17.2) (2021-12-15)


### Dependencies

* update opencensus.version to v0.29.0 ([#1589](https://www.github.com/googleapis/java-spanner/issues/1589)) ([7abf7ff](https://www.github.com/googleapis/java-spanner/commit/7abf7ff9b339eaef499313be17c7cabc169246fb))

### [6.17.1](https://www.github.com/googleapis/java-spanner/compare/v6.17.0...v6.17.1) (2021-12-08)


### Dependencies

* update dependency com.google.cloud:google-cloud-trace to v2.1.0 ([#1574](https://www.github.com/googleapis/java-spanner/issues/1574)) ([eaf2831](https://www.github.com/googleapis/java-spanner/commit/eaf28318f0a8eb5dc3795865de438f1d0e7bd982))

## [6.17.0](https://www.github.com/googleapis/java-spanner/compare/v6.16.0...v6.17.0) (2021-12-06)


### Features

* NaNs in Mutations are equal and have the same hashcode ([#1554](https://www.github.com/googleapis/java-spanner/issues/1554)) ([91a18fc](https://www.github.com/googleapis/java-spanner/commit/91a18fc09a2034959758d38f1278dc93128c7622))


### Dependencies

* update dependency com.google.cloud:google-cloud-monitoring to v3.2.0 ([#1571](https://www.github.com/googleapis/java-spanner/issues/1571)) ([0e0d9f7](https://www.github.com/googleapis/java-spanner/commit/0e0d9f7c45c71dd4e9b5500bb3931e1d399041bc))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.5.1 ([#1570](https://www.github.com/googleapis/java-spanner/issues/1570)) ([563879e](https://www.github.com/googleapis/java-spanner/commit/563879e82e77da0603f1b817190d98cfbee4e81f))
* update dependency org.json:json to v20211205 ([#1572](https://www.github.com/googleapis/java-spanner/issues/1572)) ([59593bd](https://www.github.com/googleapis/java-spanner/commit/59593bd471e7e890b589c9e5a7291a837a88a0e7))

## [6.16.0](https://www.github.com/googleapis/java-spanner/compare/v6.15.2...v6.16.0) (2021-11-15)


### Features

* support RPC priority for JDBC connections and statements ([#1548](https://www.github.com/googleapis/java-spanner/issues/1548)) ([b61a0d4](https://www.github.com/googleapis/java-spanner/commit/b61a0d4db80a689f6f1b2ccf53c9360226890e9d))

### [6.15.2](https://www.github.com/googleapis/java-spanner/compare/v6.15.1...v6.15.2) (2021-11-10)


### Bug Fixes

* **java:** java 17 dependency arguments ([#1537](https://www.github.com/googleapis/java-spanner/issues/1537)) ([0e30ebf](https://www.github.com/googleapis/java-spanner/commit/0e30ebffc63de2de940db1eb807175ec19aa752d))

### [6.15.1](https://www.github.com/googleapis/java-spanner/compare/v6.15.0...v6.15.1) (2021-10-27)


### Dependencies

* upgrade Mockito to version 4.x ([#1498](https://www.github.com/googleapis/java-spanner/issues/1498)) ([09bd561](https://www.github.com/googleapis/java-spanner/commit/09bd56157827119586fd3e0a1ee056bb793d08e3))

## [6.15.0](https://www.github.com/googleapis/java-spanner/compare/v6.14.0...v6.15.0) (2021-10-27)


### Features

* next release from main branch is 6.15.0 ([#1518](https://www.github.com/googleapis/java-spanner/issues/1518)) ([9e5e27e](https://www.github.com/googleapis/java-spanner/commit/9e5e27eee8ba9906900bb2868183b1ec88f19ecf))

## [6.14.0](https://www.github.com/googleapis/java-spanner/compare/v6.13.0...v6.14.0) (2021-10-25)


### Features

* Introduce Native Image testing build script changes ([#1500](https://www.github.com/googleapis/java-spanner/issues/1500)) ([7a034c9](https://www.github.com/googleapis/java-spanner/commit/7a034c9120ffa433f64e67d565c854f1fb3ce9f5))


### Bug Fixes

* **java:** java 17 dependency arguments ([#1512](https://www.github.com/googleapis/java-spanner/issues/1512)) ([4cebefa](https://www.github.com/googleapis/java-spanner/commit/4cebefa1ce6502d48c2e2e0a3a484f60eeed450f))


### Dependencies

* update dependency com.google.cloud:google-cloud-monitoring to v3.1.0 ([#1506](https://www.github.com/googleapis/java-spanner/issues/1506)) ([ea35b27](https://www.github.com/googleapis/java-spanner/commit/ea35b2723fcc8c255ab0e52306e066c689c6a0c6))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.4.0 ([#1501](https://www.github.com/googleapis/java-spanner/issues/1501)) ([d5a37b8](https://www.github.com/googleapis/java-spanner/commit/d5a37b8853fc21a28b6610b2933ed31fcbe206e2))
* update dependency com.google.cloud:google-cloud-trace to v2.0.6 ([#1504](https://www.github.com/googleapis/java-spanner/issues/1504)) ([667b8b1](https://www.github.com/googleapis/java-spanner/commit/667b8b17cc2f8d217ecda0af89bdc668670f3aab))

## [6.13.0](https://www.github.com/googleapis/java-spanner/compare/v6.12.5...v6.13.0) (2021-10-07)


### Features

* expose GFE latency metrics ([#1473](https://www.github.com/googleapis/java-spanner/issues/1473)) ([de82f78](https://www.github.com/googleapis/java-spanner/commit/de82f7809f8585fcbd13e117a2e29e06f1424de4))


### Bug Fixes

* keep track of any BeginTransaction option for a Read ([#1485](https://www.github.com/googleapis/java-spanner/issues/1485)) ([757d6ec](https://www.github.com/googleapis/java-spanner/commit/757d6ecfcceea58e0db7623778dde6f3e5f4b865))


### Dependencies

* update dependency com.google.cloud:google-cloud-monitoring to v3.0.7 ([#1491](https://www.github.com/googleapis/java-spanner/issues/1491)) ([58f0e5a](https://www.github.com/googleapis/java-spanner/commit/58f0e5a6db04d6298ae5d8760f907946ffffbae4))

### [6.12.5](https://www.github.com/googleapis/java-spanner/compare/v6.12.4...v6.12.5) (2021-09-27)


### Bug Fixes

* sessions were not always removed from checkedOutSessions ([#1438](https://www.github.com/googleapis/java-spanner/issues/1438)) ([49360b1](https://www.github.com/googleapis/java-spanner/commit/49360b13e5d8904bfdc09cb4db8c24848debfa0b))


### Dependencies

* update dependency com.google.cloud:google-cloud-monitoring to v3.0.6 ([#1443](https://www.github.com/googleapis/java-spanner/issues/1443)) ([159c026](https://www.github.com/googleapis/java-spanner/commit/159c026a250e6f9d6d583ef3123403a64f817e40))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.3.0 ([#1439](https://www.github.com/googleapis/java-spanner/issues/1439)) ([6bdeddf](https://www.github.com/googleapis/java-spanner/commit/6bdeddf7612964d4d59061d0a7c2956d66619a4b))
* update dependency com.google.cloud:google-cloud-trace to v2.0.5 ([#1459](https://www.github.com/googleapis/java-spanner/issues/1459)) ([2ce9a1b](https://www.github.com/googleapis/java-spanner/commit/2ce9a1bd5cf8edb36b1c4fe57f2d9b304dcd6ccc))

### [6.12.4](https://www.github.com/googleapis/java-spanner/compare/v6.12.3...v6.12.4) (2021-09-16)


### Bug Fixes

* do not serialize unnecessary fields ([#1426](https://www.github.com/googleapis/java-spanner/issues/1426)) ([29209f8](https://www.github.com/googleapis/java-spanner/commit/29209f83d10fa01b5566da66259da95dd60abca0))


### Dependencies

* update dependency com.google.cloud:google-cloud-monitoring to v3.0.5 ([#1431](https://www.github.com/googleapis/java-spanner/issues/1431)) ([32eee0a](https://www.github.com/googleapis/java-spanner/commit/32eee0aa14f0b276673dca7a65e011a509e96453))

### [6.12.3](https://www.github.com/googleapis/java-spanner/compare/v6.12.2...v6.12.3) (2021-09-15)


### Bug Fixes

* drop databases after sample tests ([#1401](https://www.github.com/googleapis/java-spanner/issues/1401)) ([c9f5048](https://www.github.com/googleapis/java-spanner/commit/c9f504829f53bfcff6f78bbbbc447cc8f10f5940))
* fix JSON sample test ([#1417](https://www.github.com/googleapis/java-spanner/issues/1417)) ([dc1f9a9](https://www.github.com/googleapis/java-spanner/commit/dc1f9a92a7562e2585e2762c2749eb3207f67c25))
* revert test category refactoring ([#1419](https://www.github.com/googleapis/java-spanner/issues/1419)) ([fe2ad14](https://www.github.com/googleapis/java-spanner/commit/fe2ad14eae2002552d61e497f9892c96584efc24))


### Dependencies

* update dependency com.google.cloud:google-cloud-monitoring to v3.0.4 ([#1422](https://www.github.com/googleapis/java-spanner/issues/1422)) ([d57d47e](https://www.github.com/googleapis/java-spanner/commit/d57d47eb3086d7352b6f7af1c4cc694de030e3ee))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.2.1 ([#1420](https://www.github.com/googleapis/java-spanner/issues/1420)) ([85b4f31](https://www.github.com/googleapis/java-spanner/commit/85b4f31d065202527ad3220cca9df94d40020e0a))
* update dependency com.google.cloud:google-cloud-trace to v2.0.4 ([#1425](https://www.github.com/googleapis/java-spanner/issues/1425)) ([ce8776a](https://www.github.com/googleapis/java-spanner/commit/ce8776a310f0d53ea2aee738e0d56dc56371fa51))

### [6.12.2](https://www.github.com/googleapis/java-spanner/compare/v6.12.1...v6.12.2) (2021-09-01)


### Dependencies

* update dependency com.google.cloud:google-cloud-monitoring to v3.0.3 ([#1402](https://www.github.com/googleapis/java-spanner/issues/1402)) ([417fc5a](https://www.github.com/googleapis/java-spanner/commit/417fc5a6b19a8be6d8f015a1fb036e89dcaad433))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.2.0 ([#1397](https://www.github.com/googleapis/java-spanner/issues/1397)) ([cc543c7](https://www.github.com/googleapis/java-spanner/commit/cc543c79a7ead75da35dc1bffc9ac7a27ec14443))
* update dependency com.google.cloud:google-cloud-trace to v2.0.3 ([#1399](https://www.github.com/googleapis/java-spanner/issues/1399)) ([2874720](https://www.github.com/googleapis/java-spanner/commit/2874720a5b938edd861a7259164876b25d8cb0bd))

### [6.12.1](https://www.github.com/googleapis/java-spanner/compare/v6.12.0...v6.12.1) (2021-08-25)


### Dependencies

* update dependency com.google.cloud:google-cloud-monitoring to v3.0.2 ([#1372](https://www.github.com/googleapis/java-spanner/issues/1372)) ([8d08076](https://www.github.com/googleapis/java-spanner/commit/8d0807638f91ce8b4e4d56e2cb455e04bd70d82b))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.1.0 ([#1369](https://www.github.com/googleapis/java-spanner/issues/1369)) ([c94ad5b](https://www.github.com/googleapis/java-spanner/commit/c94ad5b99a7a7ac10d06ef651d6519568c57bdd1))
* update dependency com.google.cloud:google-cloud-trace to v2.0.2 ([#1373](https://www.github.com/googleapis/java-spanner/issues/1373)) ([1b7933d](https://www.github.com/googleapis/java-spanner/commit/1b7933d3a440b8c791d1d34fe3cc30c53a2b71e4))

## [6.12.0](https://www.github.com/googleapis/java-spanner/compare/v6.11.1...v6.12.0) (2021-08-24)


### Features

* add support for JSON data type ([#872](https://www.github.com/googleapis/java-spanner/issues/872)) ([d7ff940](https://www.github.com/googleapis/java-spanner/commit/d7ff9409e974602dc9b18f82d6dbd11d96c956bf))
* use dummy emulator-project when no project is set ([#1363](https://www.github.com/googleapis/java-spanner/issues/1363)) ([673855e](https://www.github.com/googleapis/java-spanner/commit/673855eea8c244457ad4c8ac5abe3ad3a0a0cdde)), closes [#1345](https://www.github.com/googleapis/java-spanner/issues/1345)

### [6.11.1](https://www.github.com/googleapis/java-spanner/compare/v6.11.0...v6.11.1) (2021-08-17)


### Dependencies

* update dependency org.openjdk.jmh:jmh-core to v1.33 ([#1338](https://www.github.com/googleapis/java-spanner/issues/1338)) ([fa88b73](https://www.github.com/googleapis/java-spanner/commit/fa88b73e6535d5754e5b10493d76ddb0a33033b1))
* update dependency org.openjdk.jmh:jmh-generator-annprocess to v1.33 ([#1339](https://www.github.com/googleapis/java-spanner/issues/1339)) ([94cfecc](https://www.github.com/googleapis/java-spanner/commit/94cfeccc336e2e56c9eb296b5c7096f575863147))

## [6.11.0](https://www.github.com/googleapis/java-spanner/compare/v6.10.1...v6.11.0) (2021-08-12)


### Features

* release gapic-generator-java v2.0.0 ([#1334](https://www.github.com/googleapis/java-spanner/issues/1334)) ([368fb80](https://www.github.com/googleapis/java-spanner/commit/368fb80e8ae9fd9bee7af81c13bef32b26361877))


### Documentation

* use 'latest' stats package in samples to prevent build failures ([#1313](https://www.github.com/googleapis/java-spanner/issues/1313)) ([6a8351c](https://www.github.com/googleapis/java-spanner/commit/6a8351c9d2cf0fe805b87a611ff1d94d4dba3f87)), closes [#1273](https://www.github.com/googleapis/java-spanner/issues/1273)


### Dependencies

* update dependency com.google.cloud:google-cloud-monitoring to v3 ([#1341](https://www.github.com/googleapis/java-spanner/issues/1341)) ([de7b540](https://www.github.com/googleapis/java-spanner/commit/de7b54094b6bb2928616e2e04215f4ba5b8bc750))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2 ([#1331](https://www.github.com/googleapis/java-spanner/issues/1331)) ([cd1ad7b](https://www.github.com/googleapis/java-spanner/commit/cd1ad7b4cd1716b60f3f96ee953f76c126742788))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.0.1 ([#1344](https://www.github.com/googleapis/java-spanner/issues/1344)) ([300837f](https://www.github.com/googleapis/java-spanner/commit/300837f0a27dab89285895f753aececb8d641da9))
* update dependency com.google.cloud:google-cloud-trace to v2 ([#1342](https://www.github.com/googleapis/java-spanner/issues/1342)) ([d24886b](https://www.github.com/googleapis/java-spanner/commit/d24886b058fd87ea744a4f375fb6affd8f9398d9))

### [6.10.1](https://www.github.com/googleapis/java-spanner/compare/v6.10.0...v6.10.1) (2021-07-21)


### Dependencies

* update dependency com.google.cloud:grpc-gcp to v1.1.0 ([#1306](https://www.github.com/googleapis/java-spanner/issues/1306)) ([fa0c65d](https://www.github.com/googleapis/java-spanner/commit/fa0c65dc31236e05e6b10508281cf58e82ee87ef))

## [6.10.0](https://www.github.com/googleapis/java-spanner/compare/v6.9.1...v6.10.0) (2021-07-19)


### Features

* exposes default leader in database, and leader options / replicas in instance config ([#1283](https://www.github.com/googleapis/java-spanner/issues/1283)) ([d72c2f7](https://www.github.com/googleapis/java-spanner/commit/d72c2f79f8cf0b83da00060587a079ce859c87a2))


### Bug Fixes

* shorten the test instance name ([#1284](https://www.github.com/googleapis/java-spanner/issues/1284)) ([07c3eae](https://www.github.com/googleapis/java-spanner/commit/07c3eae134df0a0a3814e0e7225e14741a269771))


### Dependencies

* update dependency com.google.cloud:google-cloud-trace to v1.4.2 ([#1291](https://www.github.com/googleapis/java-spanner/issues/1291)) ([c4208ed](https://www.github.com/googleapis/java-spanner/commit/c4208ed5992ba5d1525df488a9eff64471fb0030))

### [6.9.1](https://www.github.com/googleapis/java-spanner/compare/v6.9.0...v6.9.1) (2021-07-05)


### Dependencies

* update dependency com.google.cloud:google-cloud-monitoring to v2.3.4 ([#1278](https://www.github.com/googleapis/java-spanner/issues/1278)) ([c692336](https://www.github.com/googleapis/java-spanner/commit/c6923366bc407b45a6bbf736b4a1d8efad8b67b7))

## [6.9.0](https://www.github.com/googleapis/java-spanner/compare/v6.8.0...v6.9.0) (2021-07-05)


### Features

* add support for tagging to Connection API ([#623](https://www.github.com/googleapis/java-spanner/issues/623)) ([5722372](https://www.github.com/googleapis/java-spanner/commit/5722372b7869828e372dec06e80e5b0e7280af61))
* **spanner:** add leader_options to InstanceConfig and default_leader to Database ([#1271](https://www.github.com/googleapis/java-spanner/issues/1271)) ([f257671](https://www.github.com/googleapis/java-spanner/commit/f25767144344f0df67662f1b3ef662902384599a))
* support setting an async executor provider ([#1263](https://www.github.com/googleapis/java-spanner/issues/1263)) ([369c8a7](https://www.github.com/googleapis/java-spanner/commit/369c8a771ec48fa1476236f800b0e8eb5982a33c))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.4.0 ([#1269](https://www.github.com/googleapis/java-spanner/issues/1269)) ([025e162](https://www.github.com/googleapis/java-spanner/commit/025e162813d6321dabe49e32f00934f9ae334e24))

## [6.8.0](https://www.github.com/googleapis/java-spanner/compare/v6.7.0...v6.8.0) (2021-06-29)


### Features

* add gRPC-GCP channel pool as an option ([#1227](https://www.github.com/googleapis/java-spanner/issues/1227)) ([1fa95a9](https://www.github.com/googleapis/java-spanner/commit/1fa95a9993ea8c7a5f943ab39eced4ced4cb87e7))
* spanner JSON type ([#1260](https://www.github.com/googleapis/java-spanner/issues/1260)) ([b2a56c6](https://www.github.com/googleapis/java-spanner/commit/b2a56c68695b6209e20f9f86d83d7c5a0f39c7a8))


### Bug Fixes

* Add `shopt -s nullglob` to dependencies script ([#1256](https://www.github.com/googleapis/java-spanner/issues/1256)) ([d1712f7](https://www.github.com/googleapis/java-spanner/commit/d1712f7c51752c2359045e5eabac8fc0530a2421))

## [6.7.0](https://www.github.com/googleapis/java-spanner/compare/v6.6.1...v6.7.0) (2021-06-21)


### Features

* add support for instance processing units ([#665](https://www.github.com/googleapis/java-spanner/issues/665)) ([9c1c8e9](https://www.github.com/googleapis/java-spanner/commit/9c1c8e90b0e02e26ea3c16def49bb7e07c2b04b1))
* **spanner:** add processing_units to Instance resource ([#1248](https://www.github.com/googleapis/java-spanner/issues/1248)) ([e3c7e8f](https://www.github.com/googleapis/java-spanner/commit/e3c7e8fbdfb5d41a1c418f176679bf5b19f22f83))


### Bug Fixes

* Update dependencies.sh to not break on mac ([#1249](https://www.github.com/googleapis/java-spanner/issues/1249)) ([1e1df84](https://www.github.com/googleapis/java-spanner/commit/1e1df84e74011fb2b665e94b428cfa78102de7fe))

### [6.6.1](https://www.github.com/googleapis/java-spanner/compare/v6.6.0...v6.6.1) (2021-06-10)


### Dependencies

* update dependency com.google.cloud:google-cloud-monitoring to v2.3.3 ([#1241](https://www.github.com/googleapis/java-spanner/issues/1241)) ([9816b3f](https://www.github.com/googleapis/java-spanner/commit/9816b3fe90419486e94a4927f368c8cecfaac424))

## [6.6.0](https://www.github.com/googleapis/java-spanner/compare/v6.5.0...v6.6.0) (2021-06-07)


### Features

* adds query optimizer statistics support ([#385](https://www.github.com/googleapis/java-spanner/issues/385)) ([e294532](https://www.github.com/googleapis/java-spanner/commit/e2945324783bc6d5a7a323578e8dbf00969f3163))
* support encoded credentials in connection URL ([#1223](https://www.github.com/googleapis/java-spanner/issues/1223)) ([43d5d7e](https://www.github.com/googleapis/java-spanner/commit/43d5d7e8d7fc1b0304a6fcf940846fe269fd661a))


### Documentation

* document retry settings in sample ([#1214](https://www.github.com/googleapis/java-spanner/issues/1214)) ([ab4592d](https://www.github.com/googleapis/java-spanner/commit/ab4592d6f5040d0125b2848369c516d01fd38106))


### Dependencies

* update dependency com.google.cloud:google-cloud-monitoring to v2.3.0 ([#1225](https://www.github.com/googleapis/java-spanner/issues/1225)) ([2023839](https://www.github.com/googleapis/java-spanner/commit/2023839cce80de0ff6451a4b6274f5da9b18416f))
* update dependency com.google.cloud:google-cloud-monitoring to v2.3.2 ([#1229](https://www.github.com/googleapis/java-spanner/issues/1229)) ([8a23ad0](https://www.github.com/googleapis/java-spanner/commit/8a23ad047ec7fc4a8a5c8d6292678e579c323eb2))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.3.0 ([#1230](https://www.github.com/googleapis/java-spanner/issues/1230)) ([db64451](https://www.github.com/googleapis/java-spanner/commit/db6445133de143391dbd9da6d3393b0d2736971a))
* update dependency com.google.cloud:google-cloud-trace to v1.4.0 ([#1226](https://www.github.com/googleapis/java-spanner/issues/1226)) ([da4407a](https://www.github.com/googleapis/java-spanner/commit/da4407a60fb2917d1ea8043b57bdff41263af241))
* update dependency com.google.cloud:google-cloud-trace to v1.4.1 ([#1231](https://www.github.com/googleapis/java-spanner/issues/1231)) ([76af3ac](https://www.github.com/googleapis/java-spanner/commit/76af3ace6d6745673006cc1a529d66a74513c615))
* update dependency org.openjdk.jmh:jmh-core to v1.32 ([#1221](https://www.github.com/googleapis/java-spanner/issues/1221)) ([b009c9b](https://www.github.com/googleapis/java-spanner/commit/b009c9b09a9200a674b629cc74a479f8b746e727))
* update dependency org.openjdk.jmh:jmh-generator-annprocess to v1.32 ([#1222](https://www.github.com/googleapis/java-spanner/issues/1222)) ([7ef76a9](https://www.github.com/googleapis/java-spanner/commit/7ef76a910defd6f9cd24191de4eb0c523a294fea))

## [6.5.0](https://www.github.com/googleapis/java-spanner/compare/v6.4.4...v6.5.0) (2021-05-25)


### Features

* add `gcf-owl-bot[bot]` to `ignoreAuthors` ([#1196](https://www.github.com/googleapis/java-spanner/issues/1196)) ([4f6e18d](https://www.github.com/googleapis/java-spanner/commit/4f6e18d9c8afab0acf1b66e2b32a0907008d4ff5))
* add bufferAsync methods ([#1145](https://www.github.com/googleapis/java-spanner/issues/1145)) ([7d6816f](https://www.github.com/googleapis/java-spanner/commit/7d6816f1fd14bcd2c7f91d814855b5d921ba970d))


### Bug Fixes

* stop invoking callback after pausing and cancelling result set ([#1192](https://www.github.com/googleapis/java-spanner/issues/1192)) ([78e6784](https://www.github.com/googleapis/java-spanner/commit/78e678448782d5d16ba43ec7c10ab85b89059d88)), closes [#1191](https://www.github.com/googleapis/java-spanner/issues/1191)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.2.0 ([#1194](https://www.github.com/googleapis/java-spanner/issues/1194)) ([9935066](https://www.github.com/googleapis/java-spanner/commit/99350663fb638d913e803b139d89be597be9ce1d))

### [6.4.4](https://www.github.com/googleapis/java-spanner/compare/v6.4.3...v6.4.4) (2021-05-17)


### Bug Fixes

* re-adds test verifyStatementsInFile ([#1181](https://www.github.com/googleapis/java-spanner/issues/1181)) ([7a715b4](https://www.github.com/googleapis/java-spanner/commit/7a715b429ba2a9561d24ba66404142bdc9de5a4f))

### [6.4.3](https://www.github.com/googleapis/java-spanner/compare/v6.4.2...v6.4.3) (2021-05-16)


### Bug Fixes

* re-adds test utility method for connection ([#1178](https://www.github.com/googleapis/java-spanner/issues/1178)) ([0e0dcb7](https://www.github.com/googleapis/java-spanner/commit/0e0dcb7cdc412e54c26d5e8f0176ac1917fa4c59))

### [6.4.2](https://www.github.com/googleapis/java-spanner/compare/v6.4.1...v6.4.2) (2021-05-14)


### Dependencies

* update dependency com.google.cloud:google-cloud-monitoring to v2.2.3 ([#1170](https://www.github.com/googleapis/java-spanner/issues/1170)) ([3bb6885](https://www.github.com/googleapis/java-spanner/commit/3bb688519774d2865701c6ffea5687513a8c7776))
* update dependency com.google.cloud:google-cloud-trace to v1.3.4 ([#1171](https://www.github.com/googleapis/java-spanner/issues/1171)) ([6faa310](https://www.github.com/googleapis/java-spanner/commit/6faa310a5c7f035c39eeaa65eb73584f535a4aeb))

### [6.4.1](https://www.github.com/googleapis/java-spanner/compare/v6.4.0...v6.4.1) (2021-05-13)


### Documentation

* close Spanner instance when it is no longer needed ([#1116](https://www.github.com/googleapis/java-spanner/issues/1116)) ([85bd0cf](https://www.github.com/googleapis/java-spanner/commit/85bd0cf11eab7b2ec47a082a4c2c0c4d9cea01d4))


### Dependencies

* update dependency com.google.cloud:google-cloud-monitoring to v2.2.2 ([#1158](https://www.github.com/googleapis/java-spanner/issues/1158)) ([63eed2e](https://www.github.com/googleapis/java-spanner/commit/63eed2e66fb063358e8b123ba5f919663b70bbe4))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.1.0 ([#1152](https://www.github.com/googleapis/java-spanner/issues/1152)) ([2e7f18a](https://www.github.com/googleapis/java-spanner/commit/2e7f18a52ef2ed5de6a87169eeefd570844a4c55))
* update dependency org.openjdk.jmh:jmh-core to v1.30 ([#1137](https://www.github.com/googleapis/java-spanner/issues/1137)) ([699a426](https://www.github.com/googleapis/java-spanner/commit/699a4260e3b1a4cf53fc690910aeeadac293e469))
* update dependency org.openjdk.jmh:jmh-core to v1.31 ([#1160](https://www.github.com/googleapis/java-spanner/issues/1160)) ([43a0fb9](https://www.github.com/googleapis/java-spanner/commit/43a0fb97352d928e16ec5138ed2ea494ebaae343))
* update dependency org.openjdk.jmh:jmh-generator-annprocess to v1.30 ([#1138](https://www.github.com/googleapis/java-spanner/issues/1138)) ([ad6649d](https://www.github.com/googleapis/java-spanner/commit/ad6649df03a1a193dd524a84fe9dc1a72ed14e09))
* update dependency org.openjdk.jmh:jmh-generator-annprocess to v1.31 ([#1161](https://www.github.com/googleapis/java-spanner/issues/1161)) ([4d17da2](https://www.github.com/googleapis/java-spanner/commit/4d17da25977dde0cc1032192045d9ee26d3fae09))

## [6.4.0](https://www.github.com/googleapis/java-spanner/compare/v6.3.3...v6.4.0) (2021-04-29)


### Features

* adds getValue to ResultSet ([#1073](https://www.github.com/googleapis/java-spanner/issues/1073)) ([7792c90](https://www.github.com/googleapis/java-spanner/commit/7792c9085a6e4ce1fb9fe2f8df4279f30539d87e))


### Bug Fixes

* allow using case-insensitive user-agent key ([#1110](https://www.github.com/googleapis/java-spanner/issues/1110)) ([f4f9e43](https://www.github.com/googleapis/java-spanner/commit/f4f9e43ce102788b81c032df8da223108e484252))
* check for timeout in connection after last statement finished ([#1086](https://www.github.com/googleapis/java-spanner/issues/1086)) ([aec0b54](https://www.github.com/googleapis/java-spanner/commit/aec0b541672d66fe0c34816b1c1b5a6bdeffccd1)), closes [#1077](https://www.github.com/googleapis/java-spanner/issues/1077)
* check for timeout in connection after last statement finished ([#1086](https://www.github.com/googleapis/java-spanner/issues/1086)) ([51d753c](https://www.github.com/googleapis/java-spanner/commit/51d753c507e7248132eb5d6ea2c4b735542eda49)), closes [#1077](https://www.github.com/googleapis/java-spanner/issues/1077)
* do not keep references to invalidated clients ([#1093](https://www.github.com/googleapis/java-spanner/issues/1093)) ([b4595a6](https://www.github.com/googleapis/java-spanner/commit/b4595a6b52417c716f8e70563bb5a7ef05067707)), closes [#1089](https://www.github.com/googleapis/java-spanner/issues/1089)
* prevent potential NullPointerException in Struct with Array field that contains null elements ([#1107](https://www.github.com/googleapis/java-spanner/issues/1107)) ([c414abb](https://www.github.com/googleapis/java-spanner/commit/c414abb9ec59f8200ba20e08846e442321de76bd)), closes [#1106](https://www.github.com/googleapis/java-spanner/issues/1106)


### Dependencies

* update dependency com.google.cloud:google-cloud-monitoring to v2.2.1 ([#1104](https://www.github.com/googleapis/java-spanner/issues/1104)) ([37ca990](https://www.github.com/googleapis/java-spanner/commit/37ca9905bb150d1791e70103e002261e40261b05))
* update dependency com.google.cloud:google-cloud-trace to v1.3.3 ([#1103](https://www.github.com/googleapis/java-spanner/issues/1103)) ([b4327c0](https://www.github.com/googleapis/java-spanner/commit/b4327c0666bb97d1d591b5ce65a6ecdc51f5a49d))


### Documentation

* fix javadoc for Date type ([#1102](https://www.github.com/googleapis/java-spanner/issues/1102)) ([ce095f7](https://www.github.com/googleapis/java-spanner/commit/ce095f7b0c196e03ea248eeb9c5060f4f430d8c4))
* use default timeout for restore operation ([#1109](https://www.github.com/googleapis/java-spanner/issues/1109)) ([3f3c13e](https://www.github.com/googleapis/java-spanner/commit/3f3c13e7fcbf08b8ab6f0d11d7451b3ae86c9500)), closes [#1019](https://www.github.com/googleapis/java-spanner/issues/1019)

### [6.3.3](https://www.github.com/googleapis/java-spanner/compare/v6.3.2...v6.3.3) (2021-04-24)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1 ([#1095](https://www.github.com/googleapis/java-spanner/issues/1095)) ([a21e0bb](https://www.github.com/googleapis/java-spanner/commit/a21e0bbafad086f29d3c719b9e4a7690c1cac129))

### [6.3.2](https://www.github.com/googleapis/java-spanner/compare/v6.3.1...v6.3.2) (2021-04-20)


### Dependencies

* update dependency com.google.cloud:google-cloud-trace to v1.3.2 ([#1081](https://www.github.com/googleapis/java-spanner/issues/1081)) ([e145c95](https://www.github.com/googleapis/java-spanner/commit/e145c9531d70af6c11be9f682fb52708d0dcb569))

### [6.3.1](https://www.github.com/googleapis/java-spanner/compare/v6.3.0...v6.3.1) (2021-04-20)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.21.1 ([#1074](https://www.github.com/googleapis/java-spanner/issues/1074)) ([ccd8cd1](https://www.github.com/googleapis/java-spanner/commit/ccd8cd1fb96c9d2046cc9c3ec4f35d8e45ebb5f5))

## [6.3.0](https://www.github.com/googleapis/java-spanner/compare/v6.2.1...v6.3.0) (2021-04-19)


### Features

* async work as functional interface ([#1068](https://www.github.com/googleapis/java-spanner/issues/1068)) ([734fb60](https://www.github.com/googleapis/java-spanner/commit/734fb6095819bde94ea482b02a8e77983f2a5449))
* **spanner:** add `progress` field to `UpdateDatabaseDdlMetadata` ([#1063](https://www.github.com/googleapis/java-spanner/issues/1063)) ([7992342](https://www.github.com/googleapis/java-spanner/commit/7992342bffc273ad8249e7564ae9ef51764bf83c))
* transaction callable as functional interface ([#1066](https://www.github.com/googleapis/java-spanner/issues/1066)) ([b036a77](https://www.github.com/googleapis/java-spanner/commit/b036a77196886f16d2738e70f676ccc99a52874c))


### Bug Fixes

* release scripts from issuing overlapping phases ([#1064](https://www.github.com/googleapis/java-spanner/issues/1064)) ([2f6fe5e](https://www.github.com/googleapis/java-spanner/commit/2f6fe5e87cc4c9ae26a6f2867411004a8c2b39fe))


### Dependencies

* update dependency org.openjdk.jmh:jmh-generator-annprocess to v1.29 ([#1014](https://www.github.com/googleapis/java-spanner/issues/1014)) ([81ee9b0](https://www.github.com/googleapis/java-spanner/commit/81ee9b02d5846f6569f588d3b17da4faf2f2dae9))

### [6.2.1](https://www.github.com/googleapis/java-spanner/compare/v6.2.0...v6.2.1) (2021-04-13)


### Dependencies

* update dependency com.google.cloud:google-cloud-monitoring to v2.2.0 ([#1054](https://www.github.com/googleapis/java-spanner/issues/1054)) ([0b59b94](https://www.github.com/googleapis/java-spanner/commit/0b59b946b31c4b5ca95a2c279bdc835f23f1a923))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.21.0 ([#1045](https://www.github.com/googleapis/java-spanner/issues/1045)) ([94dcb46](https://www.github.com/googleapis/java-spanner/commit/94dcb468e807516f07777fc62faff345441ccdf6))
* update dependency com.google.cloud:google-cloud-trace to v1.3.1 ([#1050](https://www.github.com/googleapis/java-spanner/issues/1050)) ([cbb1038](https://www.github.com/googleapis/java-spanner/commit/cbb103846e33210c914f51f64e1e47f32ff775da))

## [6.2.0](https://www.github.com/googleapis/java-spanner/compare/v6.1.0...v6.2.0) (2021-04-07)


### Features

* add support for tagging ([#576](https://www.github.com/googleapis/java-spanner/issues/576)) ([2a9086f](https://www.github.com/googleapis/java-spanner/commit/2a9086fcc7e8caae55f71bf5616b2d0db18681d3))
* Support query hints for DML statements ([#1030](https://www.github.com/googleapis/java-spanner/issues/1030)) ([6a58433](https://www.github.com/googleapis/java-spanner/commit/6a58433919d9f69e91639a1b52cbbc1151ca6804))


### Bug Fixes

* local connection checker ignores exceptions ([#1036](https://www.github.com/googleapis/java-spanner/issues/1036)) ([2d61bc4](https://www.github.com/googleapis/java-spanner/commit/2d61bc410b7c680169129725bcc11069c2390505))

## [6.1.0](https://www.github.com/googleapis/java-spanner/compare/v6.0.0...v6.1.0) (2021-03-31)


### Features

* support RPC priority ([#676](https://www.github.com/googleapis/java-spanner/issues/676)) ([0bc9972](https://www.github.com/googleapis/java-spanner/commit/0bc9972b140d6a3de9c5481a4b73ecba3e139656))


### Bug Fixes

* plain text when testing emulator connection ([#1020](https://www.github.com/googleapis/java-spanner/issues/1020)) ([1e6e23f](https://www.github.com/googleapis/java-spanner/commit/1e6e23f8d64cd16d5e5034c89c65283b3b0cae89))
* retry cancelled error on first statement in transaction ([#999](https://www.github.com/googleapis/java-spanner/issues/999)) ([a95f6f8](https://www.github.com/googleapis/java-spanner/commit/a95f6f8dc21d27133a0150ea8df963e2bc543e40)), closes [#938](https://www.github.com/googleapis/java-spanner/issues/938)
* transaction retries should not timeout ([#1009](https://www.github.com/googleapis/java-spanner/issues/1009)) ([6d9c3b8](https://www.github.com/googleapis/java-spanner/commit/6d9c3b884357ddc4d314ebdfac5fc6dda2de3b49)), closes [#1008](https://www.github.com/googleapis/java-spanner/issues/1008)
* update link and directory ([#1012](https://www.github.com/googleapis/java-spanner/issues/1012)) ([865bf01](https://www.github.com/googleapis/java-spanner/commit/865bf011093341382a2c70f5530e9f7ef58b2d5a))


### Dependencies

* update dependency org.openjdk.jmh:jmh-core to v1.29 ([#1013](https://www.github.com/googleapis/java-spanner/issues/1013)) ([a71079f](https://www.github.com/googleapis/java-spanner/commit/a71079f5bb7f209f6afe6f5bc21a58d39e131086))


### Documentation

* improve error messages ([#1011](https://www.github.com/googleapis/java-spanner/issues/1011)) ([7dacfdc](https://www.github.com/googleapis/java-spanner/commit/7dacfdc7ca1219a0ddf5929d7b46860b46e3c300))
* new libraries-bom ([#1025](https://www.github.com/googleapis/java-spanner/issues/1025)) ([3485252](https://www.github.com/googleapis/java-spanner/commit/3485252ce3d98a01fca1b6a9e1ca031283440b5e))

## [6.0.0](https://www.github.com/googleapis/java-spanner/compare/v5.2.0...v6.0.0) (2021-03-21)


### ⚠ BREAKING CHANGES

* add closeAsync() method to Connection (#984)
* drops support of Java 7 (#946)
* customer-managed encryption keys for Spanner (#666)

### Features

* add closeAsync() method to Connection ([#984](https://www.github.com/googleapis/java-spanner/issues/984)) ([e7ec96e](https://www.github.com/googleapis/java-spanner/commit/e7ec96ec09a9d273d4f576356d3e4c6cbbb6de9e))
* customer-managed encryption keys for Spanner ([#666](https://www.github.com/googleapis/java-spanner/issues/666)) ([8338116](https://www.github.com/googleapis/java-spanner/commit/8338116dffe847931cae1212333af04338ea1d45))
* drops support of Java 7 ([#946](https://www.github.com/googleapis/java-spanner/issues/946)) ([7af1951](https://www.github.com/googleapis/java-spanner/commit/7af19514dfae5f87ba50572d8867568d2c09daab))

## [5.2.0](https://www.github.com/googleapis/java-spanner/compare/v5.1.0...v5.2.0) (2021-03-18)


### Features

* add autoConfigEmulator connection option ([#931](https://www.github.com/googleapis/java-spanner/issues/931)) ([32fdd60](https://www.github.com/googleapis/java-spanner/commit/32fdd606f392bc97dab7f37b1c566b3954839f7e))


### Bug Fixes

* all throwables should be ignored in shutdown hook ([#950](https://www.github.com/googleapis/java-spanner/issues/950)) ([213dddc](https://www.github.com/googleapis/java-spanner/commit/213dddcb4f84e19be2f98115493208e3af819485)), closes [#949](https://www.github.com/googleapis/java-spanner/issues/949)


### Dependencies

* update dependency com.google.cloud:google-cloud-monitoring to v2.1.0 ([#953](https://www.github.com/googleapis/java-spanner/issues/953)) ([f991c87](https://www.github.com/googleapis/java-spanner/commit/f991c875d7ec62d19d048576263c5714d4d48a3f))
* update dependency com.google.cloud:google-cloud-trace to v1.3.0 ([#947](https://www.github.com/googleapis/java-spanner/issues/947)) ([c1d560b](https://www.github.com/googleapis/java-spanner/commit/c1d560ba4e799953aff6ba146f6f1b679a4b75b7))
* update dependency org.openjdk.jmh:jmh-generator-annprocess to v1.28 ([#924](https://www.github.com/googleapis/java-spanner/issues/924)) ([693fe5d](https://www.github.com/googleapis/java-spanner/commit/693fe5d4df3d279edb8f6f7f9879366980fd81d8))

## [5.1.0](https://www.github.com/googleapis/java-spanner/compare/v5.0.0...v5.1.0) (2021-03-10)


### Features

* add client lib token for Liquibase ([#925](https://www.github.com/googleapis/java-spanner/issues/925)) ([0d93d92](https://www.github.com/googleapis/java-spanner/commit/0d93d92fcd7c8bb2ffd3198560c4be3e4afc4990))
* adds samples for PITR ([#837](https://www.github.com/googleapis/java-spanner/issues/837)) ([55fa0cc](https://www.github.com/googleapis/java-spanner/commit/55fa0ccca4faf44da8f9a3553ab4b35574c14830))


### Dependencies

* update dependency com.google.cloud:google-cloud-monitoring to v2.0.14 ([#919](https://www.github.com/googleapis/java-spanner/issues/919)) ([178500c](https://www.github.com/googleapis/java-spanner/commit/178500c7e48cbdeb45f657d9c413e9afdacefbab))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.20.1 ([#944](https://www.github.com/googleapis/java-spanner/issues/944)) ([b74b764](https://www.github.com/googleapis/java-spanner/commit/b74b7648343dc789b60fb2636615f288b6e6c854))
* update dependency org.json:json to v20210307 ([#943](https://www.github.com/googleapis/java-spanner/issues/943)) ([4088981](https://www.github.com/googleapis/java-spanner/commit/4088981314097647e3ed79f2c748545cac6fc34e))
* update dependency org.openjdk.jmh:jmh-core to v1.28 ([#923](https://www.github.com/googleapis/java-spanner/issues/923)) ([b4d6e5a](https://www.github.com/googleapis/java-spanner/commit/b4d6e5ac762393b70b684159d11a55edf8f2fba7))

## [5.0.0](https://www.github.com/googleapis/java-spanner/compare/v4.0.2...v5.0.0) (2021-02-26)


### ⚠ BREAKING CHANGES

* add CommitStats to Connection API (#608)

### Features

* add CommitStats to Connection API ([#608](https://www.github.com/googleapis/java-spanner/issues/608)) ([b2b1191](https://www.github.com/googleapis/java-spanner/commit/b2b1191763cd47ca39849bdf93292ed5ef3e0c8a))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.20.0 ([#917](https://www.github.com/googleapis/java-spanner/issues/917)) ([aca9d45](https://www.github.com/googleapis/java-spanner/commit/aca9d45c4e86c45a75e6b5e0d3794e7ac97bdf1a))
* update dependency com.google.cloud:google-cloud-trace to v1.2.13 ([#918](https://www.github.com/googleapis/java-spanner/issues/918)) ([8843998](https://www.github.com/googleapis/java-spanner/commit/8843998a1c5ddb9228fa16162e0ea13f859f7f35))

### [4.0.2](https://www.github.com/googleapis/java-spanner/compare/v4.0.1...v4.0.2) (2021-02-23)


### Dependencies

* update dependency com.google.cloud:google-cloud-monitoring to v2.0.13 ([#901](https://www.github.com/googleapis/java-spanner/issues/901)) ([10749c7](https://www.github.com/googleapis/java-spanner/commit/10749c7a074d33c853b0f11a0e6c6ee5f09e75c9))
* update dependency com.google.cloud:google-cloud-trace to v1.2.12 ([#896](https://www.github.com/googleapis/java-spanner/issues/896)) ([84ee6e0](https://www.github.com/googleapis/java-spanner/commit/84ee6e0d442a29893e1ac77fa7882ed0407c9a7d))

### [4.0.1](https://www.github.com/googleapis/java-spanner/compare/v4.0.0...v4.0.1) (2021-02-22)


### Bug Fixes

* wrong use of getRetryDelayInMillis() / 1000 in documentation and retry loops ([#885](https://www.github.com/googleapis/java-spanner/issues/885)) ([a55d7ce](https://www.github.com/googleapis/java-spanner/commit/a55d7ce64fff434151c1c3af0796d290e9db7470)), closes [#874](https://www.github.com/googleapis/java-spanner/issues/874)


### Documentation

* Add OpenCensus to OpenTelemetry shim to README ([#879](https://www.github.com/googleapis/java-spanner/issues/879)) ([b58d73d](https://www.github.com/googleapis/java-spanner/commit/b58d73ddb768c0d33d149ed8bc84f5af618514e1))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.19.0 ([#895](https://www.github.com/googleapis/java-spanner/issues/895)) ([e3e2c95](https://www.github.com/googleapis/java-spanner/commit/e3e2c95936f40a7954639a95c84cc9495e318e55))

## [4.0.0](https://www.github.com/googleapis/java-spanner/compare/v3.3.2...v4.0.0) (2021-02-17)


### ⚠ BREAKING CHANGES

* Point In Time Recovery (PITR) (#452)
* add support for CommitStats (#544)

### Features

* add option for returning Spanner commit stats ([#817](https://www.github.com/googleapis/java-spanner/issues/817)) ([80d3585](https://www.github.com/googleapis/java-spanner/commit/80d3585870b81949ec641291e5a88fe391f78e27))
* add support for CommitStats ([#544](https://www.github.com/googleapis/java-spanner/issues/544)) ([44aa384](https://www.github.com/googleapis/java-spanner/commit/44aa384429056dd6c6563351c43fe7dcac451008))
* allow session pool settings in connection url ([#821](https://www.github.com/googleapis/java-spanner/issues/821)) ([e1e9152](https://www.github.com/googleapis/java-spanner/commit/e1e915289755e5f46ba07569d85afda5df5e3f0d))
* generate sample code in the Java microgenerator ([#859](https://www.github.com/googleapis/java-spanner/issues/859)) ([7cdfb82](https://www.github.com/googleapis/java-spanner/commit/7cdfb82b40487600547d0bad92119508161ca689))
* Point In Time Recovery (PITR) ([#452](https://www.github.com/googleapis/java-spanner/issues/452)) ([ab14a5e](https://www.github.com/googleapis/java-spanner/commit/ab14a5ec2dc2b7e2141305b5326f436eb6eee76f))


### Bug Fixes

* allows user-agent header with header provider ([#871](https://www.github.com/googleapis/java-spanner/issues/871)) ([3de7e2a](https://www.github.com/googleapis/java-spanner/commit/3de7e2a91349cac5d79a32d2cda7ca727140f0bf))
* make compiled statements immutable ([#843](https://www.github.com/googleapis/java-spanner/issues/843)) ([118d1b3](https://www.github.com/googleapis/java-spanner/commit/118d1b31f5f7771023766fd72a8229db80f1f5a2))


### Dependencies

* update dependency com.google.cloud:google-cloud-monitoring to v2.0.12 ([#854](https://www.github.com/googleapis/java-spanner/issues/854)) ([58cebd8](https://www.github.com/googleapis/java-spanner/commit/58cebd85a9d82bd1526b9eae98892181f1a022f1))
* update dependency com.google.cloud:google-cloud-trace to v1.2.11 ([#825](https://www.github.com/googleapis/java-spanner/issues/825)) ([49c8c5d](https://www.github.com/googleapis/java-spanner/commit/49c8c5d241803565fa9ff96ba55f3eb00ed5b85e))


### Documentation

* libraries-bom 16.4.0 ([#867](https://www.github.com/googleapis/java-spanner/issues/867)) ([5af3673](https://www.github.com/googleapis/java-spanner/commit/5af36739532037360dfd504a4a0988562550526c))

### [3.3.2](https://www.github.com/googleapis/java-spanner/compare/v3.3.1...v3.3.2) (2021-01-18)


### Bug Fixes

* closes pool maintainer on invalidation ([#784](https://www.github.com/googleapis/java-spanner/issues/784)) ([d122ed9](https://www.github.com/googleapis/java-spanner/commit/d122ed9662c9f01efd7d2a9797b1252f0427089c))
* UNAVAILABLE error on first query could cause transaction to get stuck ([#807](https://www.github.com/googleapis/java-spanner/issues/807)) ([c7dc6e6](https://www.github.com/googleapis/java-spanner/commit/c7dc6e6b11af76cb5db1f160c4466a5d75b524b2)), closes [#799](https://www.github.com/googleapis/java-spanner/issues/799)


### Dependencies

* update opencensus.version to v0.28.3 ([#806](https://www.github.com/googleapis/java-spanner/issues/806)) ([77910a0](https://www.github.com/googleapis/java-spanner/commit/77910a04e0fa42c90064fd533b6c13fe0372fb1e))

### [3.3.1](https://www.github.com/googleapis/java-spanner/compare/v3.3.0...v3.3.1) (2021-01-14)

### ⚠ IMPORTANT: Known issue with this version of the client

Since [v3.0.0](https://github.com/googleapis/java-spanner/releases/tag/v3.0.0), transactions can get stuck if the Spanner backend returns a retryable error when consuming the first record of a read / query in a transaction.

A [fix](https://github.com/googleapis/java-spanner/pull/807) is submitted and available in version [v3.3.2](https://github.com/googleapis/java-spanner/releases/tag/v3.3.2)

**Please use [v3.3.2](https://github.com/googleapis/java-spanner/releases/tag/v3.3.2) instead of this version.**

Apologies for the inconvenience.

### Bug Fixes

* blanks span for session keepAlive traces ([#797](https://www.github.com/googleapis/java-spanner/issues/797)) ([1a86e4f](https://www.github.com/googleapis/java-spanner/commit/1a86e4fd5b6198c300c13eba4d3d9d91c12c43f7))
* mark transaction as invalid if no tx is returned before RS is closed ([#791](https://www.github.com/googleapis/java-spanner/issues/791)) ([e02e5a7](https://www.github.com/googleapis/java-spanner/commit/e02e5a7d95c0e92d9f13640dd2afe5b899f4e56d))
* remove time series before adding it ([#766](https://www.github.com/googleapis/java-spanner/issues/766)) ([90255ea](https://www.github.com/googleapis/java-spanner/commit/90255ea7a1cc70ba4f4ab48551c509f503981540)), closes [#202](https://www.github.com/googleapis/java-spanner/issues/202)
* safeguard against statements errors when requesting tx ([#800](https://www.github.com/googleapis/java-spanner/issues/800)) ([c4776e4](https://www.github.com/googleapis/java-spanner/commit/c4776e42ad4a2795b0bfc6e1a9fb10c40d64a809))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.17.1 ([#794](https://www.github.com/googleapis/java-spanner/issues/794)) ([f0beabb](https://www.github.com/googleapis/java-spanner/commit/f0beabb228a4f555e1bcb1817a14e8074a54ef8c))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.18.0 ([#796](https://www.github.com/googleapis/java-spanner/issues/796)) ([1a71e50](https://www.github.com/googleapis/java-spanner/commit/1a71e503c68eb10ca140fe93f281a0474ddf21d3))

## [3.3.0](https://www.github.com/googleapis/java-spanner/compare/v3.2.1...v3.3.0) (2021-01-07)

### ⚠ IMPORTANT: Known issue with this version of the client

Since [v3.0.0](https://github.com/googleapis/java-spanner/releases/tag/v3.0.0), transactions can get stuck if the Spanner backend returns a retryable error when consuming the first record of a read / query in a transaction.

A [fix](https://github.com/googleapis/java-spanner/pull/807) is submitted and available in version [v3.3.2](https://github.com/googleapis/java-spanner/releases/tag/v3.3.2)

**Please use [v3.3.2](https://github.com/googleapis/java-spanner/releases/tag/v3.3.2) instead of this version.**

Apologies for the inconvenience.

### Features

* attempt DirectPath by default ([#770](https://www.github.com/googleapis/java-spanner/issues/770)) ([dc02244](https://www.github.com/googleapis/java-spanner/commit/dc02244d5ad29715f0c5d4c0ba8070659744c512))


### Bug Fixes

* Set up DirectPath e2e tests correctly ([#780](https://www.github.com/googleapis/java-spanner/issues/780)) ([9b94c6e](https://www.github.com/googleapis/java-spanner/commit/9b94c6ef54776fdb8868acf04e371599b7500d57))

### [3.2.1](https://www.github.com/googleapis/java-spanner/compare/v3.2.0...v3.2.1) (2021-01-06)

### ⚠ IMPORTANT: Known issue with this version of the client

Since [v3.0.0](https://github.com/googleapis/java-spanner/releases/tag/v3.0.0), transactions can get stuck if the Spanner backend returns a retryable error when consuming the first record of a read / query in a transaction.

A [fix](https://github.com/googleapis/java-spanner/pull/807) is submitted and available in version [v3.3.2](https://github.com/googleapis/java-spanner/releases/tag/v3.3.2)

**Please use [v3.3.2](https://github.com/googleapis/java-spanner/releases/tag/v3.3.2) instead of this version.**

Apologies for the inconvenience.

### Bug Fixes

* grpc-alts is used not only in tests ([#761](https://www.github.com/googleapis/java-spanner/issues/761)) ([72d93d5](https://www.github.com/googleapis/java-spanner/commit/72d93d5aa9a301c64c9d572d10211882a359e414))


### Dependencies

* grpc-alts is only used for tests ([#757](https://www.github.com/googleapis/java-spanner/issues/757)) ([c8ef46f](https://www.github.com/googleapis/java-spanner/commit/c8ef46f2637b58cc71d023764cdc11a7414d855f))
* update dependency com.google.cloud:google-cloud-monitoring to v2.0.11 ([#754](https://www.github.com/googleapis/java-spanner/issues/754)) ([ee2de33](https://www.github.com/googleapis/java-spanner/commit/ee2de3356038cef429eb4d3fa67656e68994bc46))


### Documentation

* add sample for timeout for one RPC ([#707](https://www.github.com/googleapis/java-spanner/issues/707)) ([056f54f](https://www.github.com/googleapis/java-spanner/commit/056f54f3cc10d103151fccba569d46796a103591))
* cleanup inner region tags ([#764](https://www.github.com/googleapis/java-spanner/issues/764)) ([90ad9d6](https://www.github.com/googleapis/java-spanner/commit/90ad9d614bc1950f46d148930e06bde93aeb2098))
* documents resume on update database ddl ([#767](https://www.github.com/googleapis/java-spanner/issues/767)) ([aeb255d](https://www.github.com/googleapis/java-spanner/commit/aeb255d2e5998ebb6f3eb7f655f63c957d5d92bd))

## [3.2.0](https://www.github.com/googleapis/java-spanner/compare/v3.1.3...v3.2.0) (2020-12-17)

### ⚠ IMPORTANT: Known issue with this version of the client

Since [v3.0.0](https://github.com/googleapis/java-spanner/releases/tag/v3.0.0), transactions can get stuck if the Spanner backend returns a retryable error when consuming the first record of a read / query in a transaction.

A [fix](https://github.com/googleapis/java-spanner/pull/807) is submitted and available in version [v3.3.2](https://github.com/googleapis/java-spanner/releases/tag/v3.3.2)

**Please use [v3.3.2](https://github.com/googleapis/java-spanner/releases/tag/v3.3.2) instead of this version.**

Apologies for the inconvenience.

### Features

* include client version in user agent header ([#747](https://www.github.com/googleapis/java-spanner/issues/747)) ([fc63bc3](https://www.github.com/googleapis/java-spanner/commit/fc63bc3f1bd9cdd83156cc63548b544188de6592))
* introduce TransactionOptions and UpdateOptions ([#716](https://www.github.com/googleapis/java-spanner/issues/716)) ([5c96fab](https://www.github.com/googleapis/java-spanner/commit/5c96fab6d1c19518d52d0a7f0d634f0526066f03))


### Bug Fixes

* reduce the probability of RESOURCE_EXHAUSTED errors during tests ([#734](https://www.github.com/googleapis/java-spanner/issues/734)) ([cd946d7](https://www.github.com/googleapis/java-spanner/commit/cd946d71501a2af7a2b3bb986ef75272c3ed92e1)), closes [#733](https://www.github.com/googleapis/java-spanner/issues/733)


### Documentation

* homogenize region tags ([#752](https://www.github.com/googleapis/java-spanner/issues/752)) ([2b3775a](https://www.github.com/googleapis/java-spanner/commit/2b3775a02466176695d7b88312b17c1aeedfbc16))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.17.0 ([#751](https://www.github.com/googleapis/java-spanner/issues/751)) ([f52776f](https://www.github.com/googleapis/java-spanner/commit/f52776f3af1c9653bfdd38aa1dac1a0d1e727b7f))
* update dependency com.google.cloud:google-cloud-trace to v1.2.10 ([#759](https://www.github.com/googleapis/java-spanner/issues/759)) ([405c4cc](https://www.github.com/googleapis/java-spanner/commit/405c4cc1af42d4440157438986c8911695ee32d6))

### [3.1.3](https://www.github.com/googleapis/java-spanner/compare/v3.1.2...v3.1.3) (2020-12-14)

### ⚠ IMPORTANT: Known issue with this version of the client

Since [v3.0.0](https://github.com/googleapis/java-spanner/releases/tag/v3.0.0), transactions can get stuck if the Spanner backend returns a retryable error when consuming the first record of a read / query in a transaction.

A [fix](https://github.com/googleapis/java-spanner/pull/807) is submitted and available in version [v3.3.2](https://github.com/googleapis/java-spanner/releases/tag/v3.3.2)

**Please use [v3.3.2](https://github.com/googleapis/java-spanner/releases/tag/v3.3.2) instead of this version.**

Apologies for the inconvenience.

### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.16.1 ([09968d5](https://www.github.com/googleapis/java-spanner/commit/09968d5092268b6ac2083b6914185f5e73d23648))

### [3.1.2](https://www.github.com/googleapis/java-spanner/compare/v3.1.1...v3.1.2) (2020-12-14)

### ⚠ IMPORTANT: Known issue with this version of the client

Since [v3.0.0](https://github.com/googleapis/java-spanner/releases/tag/v3.0.0), transactions can get stuck if the Spanner backend returns a retryable error when consuming the first record of a read / query in a transaction.

A [fix](https://github.com/googleapis/java-spanner/pull/807) is submitted and available in version [v3.3.2](https://github.com/googleapis/java-spanner/releases/tag/v3.3.2)

**Please use [v3.3.2](https://github.com/googleapis/java-spanner/releases/tag/v3.3.2) instead of this version.**

Apologies for the inconvenience.

### Dependencies

* update dependency com.google.cloud:google-cloud-monitoring to v2.0.9 ([#710](https://www.github.com/googleapis/java-spanner/issues/710)) ([37a636d](https://www.github.com/googleapis/java-spanner/commit/37a636d989d2783875065b89141e532064f2647b))

### [3.1.1](https://www.github.com/googleapis/java-spanner/compare/v3.1.0...v3.1.1) (2020-12-10)

### ⚠ IMPORTANT: Known issue with this version of the client

Since [v3.0.0](https://github.com/googleapis/java-spanner/releases/tag/v3.0.0), transactions can get stuck if the Spanner backend returns a retryable error when consuming the first record of a read / query in a transaction.

A [fix](https://github.com/googleapis/java-spanner/pull/807) is submitted and available in version [v3.3.2](https://github.com/googleapis/java-spanner/releases/tag/v3.3.2)

**Please use [v3.3.2](https://github.com/googleapis/java-spanner/releases/tag/v3.3.2) instead of this version.**

Apologies for the inconvenience.

### Dependencies

* update dependency com.google.cloud:google-cloud-trace to v1.2.8 ([#699](https://www.github.com/googleapis/java-spanner/issues/699)) ([e3289bd](https://www.github.com/googleapis/java-spanner/commit/e3289bdf1f5c723c88f4e719c4a7a15f5d131556))

## [3.1.0](https://www.github.com/googleapis/java-spanner/compare/v3.0.5...v3.1.0) (2020-12-10)

### ⚠ IMPORTANT: Known issue with this version of the client

Since [v3.0.0](https://github.com/googleapis/java-spanner/releases/tag/v3.0.0), transactions can get stuck if the Spanner backend returns a retryable error when consuming the first record of a read / query in a transaction.

A [fix](https://github.com/googleapis/java-spanner/pull/807) is submitted and available in version [v3.3.2](https://github.com/googleapis/java-spanner/releases/tag/v3.3.2)

**Please use [v3.3.2](https://github.com/googleapis/java-spanner/releases/tag/v3.3.2) instead of this version.**

Apologies for the inconvenience.

### Features

* allow lenient mode for connection properties ([#671](https://www.github.com/googleapis/java-spanner/issues/671)) ([f6a8ba6](https://www.github.com/googleapis/java-spanner/commit/f6a8ba6baff53ededf890e3f22a8e49402c98775))
* retry admin request limit exceeded error ([#669](https://www.github.com/googleapis/java-spanner/issues/669)) ([3f9f74a](https://www.github.com/googleapis/java-spanner/commit/3f9f74aed52bce681b4bfd10d1006e5fa05b7cc9)), closes [#655](https://www.github.com/googleapis/java-spanner/issues/655)


### Bug Fixes

* fixes changelog of upgrade 2.0.0 ([#672](https://www.github.com/googleapis/java-spanner/issues/672)) ([c035546](https://www.github.com/googleapis/java-spanner/commit/c0355462d839a1e38a4efec9e4019272a76d822f))
* transaction retry could fail if tx contained failed statements ([#688](https://www.github.com/googleapis/java-spanner/issues/688)) ([f78c64e](https://www.github.com/googleapis/java-spanner/commit/f78c64e3e2bee6d6ed1f44a0b2e57249cba0e6d0)), closes [#685](https://www.github.com/googleapis/java-spanner/issues/685)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.16.0 ([#680](https://www.github.com/googleapis/java-spanner/issues/680)) ([81cba9a](https://www.github.com/googleapis/java-spanner/commit/81cba9ade891aa65176d4be137f902651499b05c))
* update dependency com.google.cloud:google-cloud-trace to v1.2.7 ([#646](https://www.github.com/googleapis/java-spanner/issues/646)) ([0e17be0](https://www.github.com/googleapis/java-spanner/commit/0e17be0f81483eba4570faf884388cb43a42d84d))
* update dependency org.openjdk.jmh:jmh-core to v1.27 ([#691](https://www.github.com/googleapis/java-spanner/issues/691)) ([a2e82e4](https://www.github.com/googleapis/java-spanner/commit/a2e82e424802f1544443ee29588bd1fabe3f38c3))
* update dependency org.openjdk.jmh:jmh-generator-annprocess to v1.27 ([#692](https://www.github.com/googleapis/java-spanner/issues/692)) ([bca15c2](https://www.github.com/googleapis/java-spanner/commit/bca15c226a914c8728a6a52083dd1ff074cc97e8))

### [3.0.5](https://www.github.com/googleapis/java-spanner/compare/v3.0.4...v3.0.5) (2020-11-19)

### ⚠ IMPORTANT: Known issue with this version of the client

Since [v3.0.0](https://github.com/googleapis/java-spanner/releases/tag/v3.0.0), transactions can get stuck if the Spanner backend returns a retryable error when consuming the first record of a read / query in a transaction.

A [fix](https://github.com/googleapis/java-spanner/pull/807) is submitted and available in version [v3.3.2](https://github.com/googleapis/java-spanner/releases/tag/v3.3.2)

**Please use [v3.3.2](https://github.com/googleapis/java-spanner/releases/tag/v3.3.2) instead of this version.**

Apologies for the inconvenience.

### Bug Fixes

* delete stale sample databases ([#622](https://www.github.com/googleapis/java-spanner/issues/622)) ([7584baa](https://www.github.com/googleapis/java-spanner/commit/7584baa8b7051764f1055ddb1616069e7d591b64))
* does not generate codeowners ([#631](https://www.github.com/googleapis/java-spanner/issues/631)) ([9e133a9](https://www.github.com/googleapis/java-spanner/commit/9e133a972f648ee804f324bbf55163849cb478b8))
* query could hang transaction if ResultSet#next() is not called ([#643](https://www.github.com/googleapis/java-spanner/issues/643)) ([48f92e3](https://www.github.com/googleapis/java-spanner/commit/48f92e3d1b26644bde62a8d864cec96c3c71687d)), closes [#641](https://www.github.com/googleapis/java-spanner/issues/641)


### Dependencies

* update dependency com.google.cloud:google-cloud-monitoring to v2.0.8 ([#644](https://www.github.com/googleapis/java-spanner/issues/644)) ([447a99b](https://www.github.com/googleapis/java-spanner/commit/447a99b9a6ccdfd3855505fca13e849fb9513943))

### [3.0.4](https://www.github.com/googleapis/java-spanner/compare/v3.0.3...v3.0.4) (2020-11-17)

### ⚠ IMPORTANT: Known issue with this version of the client

Since [v3.0.0](https://github.com/googleapis/java-spanner/releases/tag/v3.0.0), transactions can get stuck if the Spanner backend returns a retryable error when consuming the first record of a read / query in a transaction.

A [fix](https://github.com/googleapis/java-spanner/pull/807) is submitted and available in version [v3.3.2](https://github.com/googleapis/java-spanner/releases/tag/v3.3.2)

**Please use [v3.3.2](https://github.com/googleapis/java-spanner/releases/tag/v3.3.2) instead of this version.**

Apologies for the inconvenience.

### Reverts

* Revert "fix: skip failing backup tests for now" (#634) ([b22cd7d](https://www.github.com/googleapis/java-spanner/commit/b22cd7dfc377a0445534946af29500cee316e6b1)), closes [#634](https://www.github.com/googleapis/java-spanner/issues/634)

### [3.0.3](https://www.github.com/googleapis/java-spanner/compare/v3.0.2...v3.0.3) (2020-11-16)

### ⚠ IMPORTANT: Known issue with this version of the client

Since [v3.0.0](https://github.com/googleapis/java-spanner/releases/tag/v3.0.0), transactions can get stuck if the Spanner backend returns a retryable error when consuming the first record of a read / query in a transaction.

A [fix](https://github.com/googleapis/java-spanner/pull/807) is submitted and available in version [v3.3.2](https://github.com/googleapis/java-spanner/releases/tag/v3.3.2)

**Please use [v3.3.2](https://github.com/googleapis/java-spanner/releases/tag/v3.3.2) instead of this version.**

Apologies for the inconvenience.

### Dependencies

* update dependency org.json:json to v20201115 ([#624](https://www.github.com/googleapis/java-spanner/issues/624)) ([60e31d1](https://www.github.com/googleapis/java-spanner/commit/60e31d1947b6930ec030e1f3170dfbde62833b96))

### [3.0.2](https://www.github.com/googleapis/java-spanner/compare/v3.0.1...v3.0.2) (2020-11-13)

### ⚠ IMPORTANT: Known issue with this version of the client

Since [v3.0.0](https://github.com/googleapis/java-spanner/releases/tag/v3.0.0), transactions can get stuck if the Spanner backend returns a retryable error when consuming the first record of a read / query in a transaction.

A [fix](https://github.com/googleapis/java-spanner/pull/807) is submitted and available in version [v3.3.2](https://github.com/googleapis/java-spanner/releases/tag/v3.3.2)

**Please use [v3.3.2](https://github.com/googleapis/java-spanner/releases/tag/v3.3.2) instead of this version.**

Apologies for the inconvenience.

### Bug Fixes

* adds api spanner team as samples code owners ([#610](https://www.github.com/googleapis/java-spanner/issues/610)) ([35cc56c](https://www.github.com/googleapis/java-spanner/commit/35cc56c375615b26f522b7342916fd30ce826c2d))
* make enums in the Connection API public ([#579](https://www.github.com/googleapis/java-spanner/issues/579)) ([19b1629](https://www.github.com/googleapis/java-spanner/commit/19b1629450a8956b810e27e5d6ab8532dec75267)), closes [#253](https://www.github.com/googleapis/java-spanner/issues/253)
* session retry could cause infinite wait ([#616](https://www.github.com/googleapis/java-spanner/issues/616)) ([8a66d84](https://www.github.com/googleapis/java-spanner/commit/8a66d84edbdaeba6b021d962a9b1984a3d2f40df)), closes [#605](https://www.github.com/googleapis/java-spanner/issues/605)
* updates project / instance for samples tests ([#613](https://www.github.com/googleapis/java-spanner/issues/613)) ([2589e7d](https://www.github.com/googleapis/java-spanner/commit/2589e7d6f400a7b050c21f46a4ab1662baa1cdb7))


### Documentation

* add descriptions for connection URL properties ([#609](https://www.github.com/googleapis/java-spanner/issues/609)) ([34221d7](https://www.github.com/googleapis/java-spanner/commit/34221d7a889c131fb1f797a0f9434deee60d755b))


### Dependencies

* update dependency com.google.cloud:google-cloud-monitoring to v2.0.7 ([#573](https://www.github.com/googleapis/java-spanner/issues/573)) ([5135e50](https://www.github.com/googleapis/java-spanner/commit/5135e50d21417ca9514b47bd1f7eaf3d2d1417ca))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.14.1 ([#567](https://www.github.com/googleapis/java-spanner/issues/567)) ([2e9c133](https://www.github.com/googleapis/java-spanner/commit/2e9c13346423a2e1e2798bec14a1dc8799203235))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.15.0 ([#614](https://www.github.com/googleapis/java-spanner/issues/614)) ([3fa7910](https://www.github.com/googleapis/java-spanner/commit/3fa7910c8e5089cff1c9ed645f160a9e0ddfc351))
* update dependency com.google.cloud:google-cloud-trace to v1.2.6 ([#574](https://www.github.com/googleapis/java-spanner/issues/574)) ([efabe0f](https://www.github.com/googleapis/java-spanner/commit/efabe0f44a5ec92ac07be3c3e964396b613099d1))

### [3.0.1](https://www.github.com/googleapis/java-spanner/compare/v3.0.0...v3.0.1) (2020-10-28)

### ⚠ IMPORTANT: Known issue with this version of the client

Since [v3.0.0](https://github.com/googleapis/java-spanner/releases/tag/v3.0.0), transactions can get stuck if the Spanner backend returns a retryable error when consuming the first record of a read / query in a transaction.

A [fix](https://github.com/googleapis/java-spanner/pull/807) is submitted and available in version [v3.3.2](https://github.com/googleapis/java-spanner/releases/tag/v3.3.2)

**Please use [v3.3.2](https://github.com/googleapis/java-spanner/releases/tag/v3.3.2) instead of this version.**

Apologies for the inconvenience.

### Bug Fixes

* adds assembly descriptor to snippets samples ([#559](https://www.github.com/googleapis/java-spanner/issues/559)) ([d4ae85c](https://www.github.com/googleapis/java-spanner/commit/d4ae85c91c2bda3f46cab8c9f7a4033ddd639c94))
* always delete all backups from an owned test instance ([#557](https://www.github.com/googleapis/java-spanner/issues/557)) ([ff571b0](https://www.github.com/googleapis/java-spanner/commit/ff571b01b9dffdda44a9bd322e04ff04b5b5c57a)), closes [#542](https://www.github.com/googleapis/java-spanner/issues/542)
* fixes the code of conduct document ([#541](https://www.github.com/googleapis/java-spanner/issues/541)) ([7b9d1db](https://www.github.com/googleapis/java-spanner/commit/7b9d1db28b7037d6b18df88f00b9213f2f6dab80))
* SessionNotFound was not retried for AsyncTransactionManager ([#552](https://www.github.com/googleapis/java-spanner/issues/552)) ([5969f83](https://www.github.com/googleapis/java-spanner/commit/5969f8313a4df6ece63ee8f14df98cbc8511f026))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.13.0 ([#521](https://www.github.com/googleapis/java-spanner/issues/521)) ([0f4c017](https://www.github.com/googleapis/java-spanner/commit/0f4c017f112478ffc7dd15b0b234a9c48cd55a6e))

## [3.0.0](https://www.github.com/googleapis/java-spanner/compare/v2.0.2...v3.0.0) (2020-10-23)

### ⚠ IMPORTANT: Known issue with this version of the client

Since [v3.0.0](https://github.com/googleapis/java-spanner/releases/tag/v3.0.0), transactions can get stuck if the Spanner backend returns a retryable error when consuming the first record of a read / query in a transaction.

A [fix](https://github.com/googleapis/java-spanner/pull/807) is submitted and available in version [v3.3.2](https://github.com/googleapis/java-spanner/releases/tag/v3.3.2)

**Please use [v3.3.2](https://github.com/googleapis/java-spanner/releases/tag/v3.3.2) instead of this version.**

Apologies for the inconvenience.

### ⚠ BREAKING CHANGES

* initialize should be protected (#536)
* async connection API (#392)

### Features

* adds options to the write operations ([#531](https://www.github.com/googleapis/java-spanner/issues/531)) ([659719d](https://www.github.com/googleapis/java-spanner/commit/659719deb5a18a87859bc174f5bde1e1147834d8))
* async connection API ([#392](https://www.github.com/googleapis/java-spanner/issues/392)) ([3dd0675](https://www.github.com/googleapis/java-spanner/commit/3dd0675d2d7882d40a6af1e12fda3b4617019870)), closes [#378](https://www.github.com/googleapis/java-spanner/issues/378)
* inline begin transaction ([#325](https://www.github.com/googleapis/java-spanner/issues/325)) ([d08d3de](https://www.github.com/googleapis/java-spanner/commit/d08d3debb6457548bb6b04335b7a2d2227369211)), closes [#515](https://www.github.com/googleapis/java-spanner/issues/515)


### Bug Fixes

* AsyncTransactionManager did not propagate statement errors ([#516](https://www.github.com/googleapis/java-spanner/issues/516)) ([4b8b845](https://www.github.com/googleapis/java-spanner/commit/4b8b8452589d63f6768b971a880a19bde80a9671)), closes [#514](https://www.github.com/googleapis/java-spanner/issues/514)
* AsyncTransactionManager should rollback on close ([#505](https://www.github.com/googleapis/java-spanner/issues/505)) ([c580df8](https://www.github.com/googleapis/java-spanner/commit/c580df8e1175bde293890c2a68e8816951c068d3)), closes [#504](https://www.github.com/googleapis/java-spanner/issues/504)
* close executor when closing pool ([#501](https://www.github.com/googleapis/java-spanner/issues/501)) ([2086746](https://www.github.com/googleapis/java-spanner/commit/208674632b20b37f51b828c1c4cc76c91154952b))
* fixes javadocs for Key ([#532](https://www.github.com/googleapis/java-spanner/issues/532)) ([768c19d](https://www.github.com/googleapis/java-spanner/commit/768c19dc1b9985f7823ec1e4ca92491936062f3b))
* fixes sample tests ([ed0665c](https://www.github.com/googleapis/java-spanner/commit/ed0665c71abbce57a28cb79531783145eccab1fb))
* ignores failing backup operations ([2ad0b7f](https://www.github.com/googleapis/java-spanner/commit/2ad0b7fc6d1369795702484181ee11ecf59a1f8b))
* increase visibility of #get() ([#486](https://www.github.com/googleapis/java-spanner/issues/486)) ([fa6d964](https://www.github.com/googleapis/java-spanner/commit/fa6d9641b7b2a5bb1d00de6b99b0f8bc157245d6))
* initialize should be protected ([#536](https://www.github.com/googleapis/java-spanner/issues/536)) ([5c4c8c5](https://www.github.com/googleapis/java-spanner/commit/5c4c8c58674490ba524b678b409b8b19184af02f))
* remove dependency on commons-lang ([#494](https://www.github.com/googleapis/java-spanner/issues/494)) ([c99294b](https://www.github.com/googleapis/java-spanner/commit/c99294beb43ce1bd67cc3d12e4104641efab6710))


### Dependencies

* update dependency com.google.cloud:google-cloud-monitoring to v2 ([#498](https://www.github.com/googleapis/java-spanner/issues/498)) ([3ab7348](https://www.github.com/googleapis/java-spanner/commit/3ab7348781e56384921d8287a5b5c0725dfed221))
* update dependency com.google.cloud:google-cloud-monitoring to v2.0.5 ([#525](https://www.github.com/googleapis/java-spanner/issues/525)) ([fb874ec](https://www.github.com/googleapis/java-spanner/commit/fb874ec2e1738d569d585d30825a6e9d3de96c66))
* update dependency com.google.cloud:google-cloud-monitoring to v2.0.6 ([#540](https://www.github.com/googleapis/java-spanner/issues/540)) ([ce3bed6](https://www.github.com/googleapis/java-spanner/commit/ce3bed6f5359224c37502331a9f776e29632d3a5))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.10.2 ([#500](https://www.github.com/googleapis/java-spanner/issues/500)) ([eb59929](https://www.github.com/googleapis/java-spanner/commit/eb5992949de326326a6bb02ec75b4a2a65a37b84))
* update dependency com.google.cloud:google-cloud-trace to v1.2.3 ([#496](https://www.github.com/googleapis/java-spanner/issues/496)) ([0595a80](https://www.github.com/googleapis/java-spanner/commit/0595a80d5a6bb09e62ce1b6d101a3a039896c7af))
* update dependency com.google.cloud:google-cloud-trace to v1.2.4 ([#526](https://www.github.com/googleapis/java-spanner/issues/526)) ([1020989](https://www.github.com/googleapis/java-spanner/commit/1020989e1ec1ad7f5185579da58d7a839167f05a))
* update dependency com.google.cloud:google-cloud-trace to v1.2.5 ([#539](https://www.github.com/googleapis/java-spanner/issues/539)) ([eddd6ad](https://www.github.com/googleapis/java-spanner/commit/eddd6ad4e5093ee21290b85f15fa432d071bae59))
* update dependency org.openjdk.jmh:jmh-core to v1.26 ([#506](https://www.github.com/googleapis/java-spanner/issues/506)) ([0f13c4c](https://www.github.com/googleapis/java-spanner/commit/0f13c4c5db37a736e391c002ed2456d78d04a090))
* update dependency org.openjdk.jmh:jmh-generator-annprocess to v1.26 ([#507](https://www.github.com/googleapis/java-spanner/issues/507)) ([600f397](https://www.github.com/googleapis/java-spanner/commit/600f397a37f1808eb387fa3c31be0be5bb076c77))
* update opencensus.version to v0.27.1 ([#497](https://www.github.com/googleapis/java-spanner/issues/497)) ([62fa39a](https://www.github.com/googleapis/java-spanner/commit/62fa39a2fbac6aa667073f16898e6861f0f5ec21))
* update opencensus.version to v0.28.1 ([#533](https://www.github.com/googleapis/java-spanner/issues/533)) ([777f5fc](https://www.github.com/googleapis/java-spanner/commit/777f5fc486de7a54801c9f3f82adca561388ebfe))
* update opencensus.version to v0.28.2 ([#538](https://www.github.com/googleapis/java-spanner/issues/538)) ([e1843ef](https://www.github.com/googleapis/java-spanner/commit/e1843ef38580fecb1f017330f3fa1447028607c7))

### [2.0.2](https://www.github.com/googleapis/java-spanner/compare/v2.0.1...v2.0.2) (2020-10-02)


### Bug Fixes

* improve numeric range checks ([#424](https://www.github.com/googleapis/java-spanner/issues/424)) ([9f26785](https://www.github.com/googleapis/java-spanner/commit/9f2678568be77e82c14632b1c7ffcaafb71e7679))
* ResultSet#close() should not throw exceptions from session creation ([#487](https://www.github.com/googleapis/java-spanner/issues/487)) ([60fb986](https://www.github.com/googleapis/java-spanner/commit/60fb986f8b758a65e20c5315faf85fc0a935d0cc))
* skip failing backup tests for now ([#463](https://www.github.com/googleapis/java-spanner/issues/463)) ([f037f2d](https://www.github.com/googleapis/java-spanner/commit/f037f2d28096cd173ba338a966fd16babe8c697e))
* use credentials key in pool ([#430](https://www.github.com/googleapis/java-spanner/issues/430)) ([28103fb](https://www.github.com/googleapis/java-spanner/commit/28103fb2d6e293d20399ecdfd680be67d9d62a1c))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.10.0 ([#453](https://www.github.com/googleapis/java-spanner/issues/453)) ([e05ee0e](https://www.github.com/googleapis/java-spanner/commit/e05ee0eaa16984393b60fc47f94412e560c36ff1))

### [2.0.1](https://www.github.com/googleapis/java-spanner/compare/v2.0.0...v2.0.1) (2020-09-18)


### Bug Fixes

* do not close delegate rs in callback runnable ([#425](https://www.github.com/googleapis/java-spanner/issues/425)) ([dce3ee7](https://www.github.com/googleapis/java-spanner/commit/dce3ee79664cc528415db08b3268d719ea720ded))
* re-adds method used in internal testing ([#438](https://www.github.com/googleapis/java-spanner/issues/438)) ([c36e41b](https://www.github.com/googleapis/java-spanner/commit/c36e41bfaaf8026d2f6601ed12bfaa0d7a4ea802))

## [2.0.0](https://www.github.com/googleapis/java-spanner/compare/v1.61.0...v2.0.0) (2020-09-16)


### ⚠ BREAKING CHANGES

* Remove Guava ImmutableList from API surface ([#411](https://www.github.com/googleapis/java-spanner/issues/411)) ([b35304e](https://www.github.com/googleapis/java-spanner/commit/b35304ede5c980c3c042b89247058cc5a4ab1488))

### Features

* add lazy initializer ([#423](https://www.github.com/googleapis/java-spanner/issues/423)) ([e8522b9](https://www.github.com/googleapis/java-spanner/commit/e8522b9955c4a19fa7d6297fd463e9d2521dff92))


### Bug Fixes

* fix aborted handling of batchUpdateAsync ([#421](https://www.github.com/googleapis/java-spanner/issues/421)) ([6154008](https://www.github.com/googleapis/java-spanner/commit/61540085c971d7885e4938b486e051a1ed9cf35f))
* uses old version of gax-grpc method ([#426](https://www.github.com/googleapis/java-spanner/issues/426)) ([fe6dc79](https://www.github.com/googleapis/java-spanner/commit/fe6dc796db6aa4c28832457ca54e6952a4b51c7e))


### Miscellaneous Chores

* ensure next release is major ([#428](https://www.github.com/googleapis/java-spanner/issues/428)) ([bdae120](https://www.github.com/googleapis/java-spanner/commit/bdae120fff807df760e7be2b34a559dc995adf7e))

## [1.61.0](https://www.github.com/googleapis/java-spanner/compare/v1.60.0...v1.61.0) (2020-09-09)


### Features

* Add experimental DirectPath support ([#396](https://www.github.com/googleapis/java-spanner/issues/396)) ([46264d1](https://www.github.com/googleapis/java-spanner/commit/46264d11529accde7b520638264732937b2feb03))
* support setting timeout per RPC ([#379](https://www.github.com/googleapis/java-spanner/issues/379)) ([5d115d4](https://www.github.com/googleapis/java-spanner/commit/5d115d49b988b3fc1c59ae41ee53d7c5a83b4d11)), closes [#378](https://www.github.com/googleapis/java-spanner/issues/378)


### Bug Fixes

* iterate over async result set in sync ([#416](https://www.github.com/googleapis/java-spanner/issues/416)) ([45d8419](https://www.github.com/googleapis/java-spanner/commit/45d8419250c904b2f785d6cc5abacf098e5781de))
* remove potential infinite loop in administrative requests ([#398](https://www.github.com/googleapis/java-spanner/issues/398)) ([81d2c76](https://www.github.com/googleapis/java-spanner/commit/81d2c7634edd30efd428846fdbc468aee5406ed5))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.9.0 ([#409](https://www.github.com/googleapis/java-spanner/issues/409)) ([ae43165](https://www.github.com/googleapis/java-spanner/commit/ae43165ba736e17b780ce128d97b9757039275c2))
* update dependency org.openjdk.jmh:jmh-core to v1.25.1 ([#399](https://www.github.com/googleapis/java-spanner/issues/399)) ([52fc363](https://www.github.com/googleapis/java-spanner/commit/52fc3638854116ab87b7e6bdd719134d3108229d))
* update dependency org.openjdk.jmh:jmh-core to v1.25.2 ([#412](https://www.github.com/googleapis/java-spanner/issues/412)) ([86d18cd](https://www.github.com/googleapis/java-spanner/commit/86d18cdcc2d3aa0771e3f331ebb50591ce811113))
* update dependency org.openjdk.jmh:jmh-generator-annprocess to v1.25.2 ([#400](https://www.github.com/googleapis/java-spanner/issues/400)) ([8a40a96](https://www.github.com/googleapis/java-spanner/commit/8a40a96123831ce992d18ecff6e699dbb7ffc82c))


### Documentation

* updates bom and spanner version in readme ([#415](https://www.github.com/googleapis/java-spanner/issues/415)) ([def7fdf](https://www.github.com/googleapis/java-spanner/commit/def7fdf9b11fc0f8e7bacd6be41875b6542f64d5))

## [1.60.0](https://www.github.com/googleapis/java-spanner/compare/v1.59.0...v1.60.0) (2020-08-18)


### Features

* adds clirr check on pre-commit hook ([#388](https://www.github.com/googleapis/java-spanner/issues/388)) ([bd5c93f](https://www.github.com/googleapis/java-spanner/commit/bd5c93f045e06372b2235f3d350bade93bff2c24))
* include SQL statement in error message ([#355](https://www.github.com/googleapis/java-spanner/issues/355)) ([cc5ac48](https://www.github.com/googleapis/java-spanner/commit/cc5ac48232b6e4550b98d213c5877d6ec37b293f))


### Bug Fixes

* enables emulator tests ([#380](https://www.github.com/googleapis/java-spanner/issues/380)) ([f61c6d0](https://www.github.com/googleapis/java-spanner/commit/f61c6d0d332f15826499996a292acc7cbab267a7))
* remove custom timeout and retry settings ([#365](https://www.github.com/googleapis/java-spanner/issues/365)) ([f6afd21](https://www.github.com/googleapis/java-spanner/commit/f6afd213430d3f06d9a72c64a5c37172840fed0e))
* remove unused kokoro files ([#367](https://www.github.com/googleapis/java-spanner/issues/367)) ([6125c7d](https://www.github.com/googleapis/java-spanner/commit/6125c7d221c77f4c42497b72107627ee09312813))
* retry pdml transaction on EOS internal error ([#360](https://www.github.com/googleapis/java-spanner/issues/360)) ([a53d736](https://www.github.com/googleapis/java-spanner/commit/a53d7369bb2a8640ab42e409632b352decbdbf5e))
* sets the project for the integration tests ([#386](https://www.github.com/googleapis/java-spanner/issues/386)) ([c8fa458](https://www.github.com/googleapis/java-spanner/commit/c8fa458f5369a09c780ee38ecc09bd2562e8f987))


### Dependencies

* stop auto updates of commons-lang3 ([#362](https://www.github.com/googleapis/java-spanner/issues/362)) ([8f07ed6](https://www.github.com/googleapis/java-spanner/commit/8f07ed6b44f9c70f56b9ee2e4505c40385337ca7))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.6 ([#374](https://www.github.com/googleapis/java-spanner/issues/374)) ([6f47b8a](https://www.github.com/googleapis/java-spanner/commit/6f47b8a759643f772230df0c2e153338d44f70ce))
* update dependency org.openjdk.jmh:jmh-core to v1.24 ([#375](https://www.github.com/googleapis/java-spanner/issues/375)) ([94f568c](https://www.github.com/googleapis/java-spanner/commit/94f568cf731ba22cac7f0d898d7776a3cc2c178f))
* update dependency org.openjdk.jmh:jmh-core to v1.25 ([#382](https://www.github.com/googleapis/java-spanner/issues/382)) ([ec7888e](https://www.github.com/googleapis/java-spanner/commit/ec7888e1d62cf800bf6ad166d242e89443ddc7aa))
* update dependency org.openjdk.jmh:jmh-generator-annprocess to v1.25 ([#376](https://www.github.com/googleapis/java-spanner/issues/376)) ([8ffdc48](https://www.github.com/googleapis/java-spanner/commit/8ffdc481e15901f78eac592bd8d4bef33ac3378a))

## [1.59.0](https://www.github.com/googleapis/java-spanner/compare/v1.58.0...v1.59.0) (2020-07-16)


### Features

* add support for NUMERIC data type ([#193](https://www.github.com/googleapis/java-spanner/issues/193)) ([b38a91d](https://www.github.com/googleapis/java-spanner/commit/b38a91d8daac264b9dea327d6b31430d9599bd78))
* spanner NUMERIC type ([#349](https://www.github.com/googleapis/java-spanner/issues/349)) ([78c3192](https://www.github.com/googleapis/java-spanner/commit/78c3192266c474fc43277a8bf3f15caa968a0100))


### Bug Fixes

* check if emulator is running if env var is set ([#340](https://www.github.com/googleapis/java-spanner/issues/340)) ([597f501](https://www.github.com/googleapis/java-spanner/commit/597f501803e6d58717a6e3770e6fd3f34454e9a5))
* fix potential unnecessary transaction retry ([#337](https://www.github.com/googleapis/java-spanner/issues/337)) ([1a4f4fd](https://www.github.com/googleapis/java-spanner/commit/1a4f4fd675a1580c87ad1d53c650a20bd2ff4811)), closes [#327](https://www.github.com/googleapis/java-spanner/issues/327)
* respect PDML timeout when using streaming RPC ([#338](https://www.github.com/googleapis/java-spanner/issues/338)) ([d67f108](https://www.github.com/googleapis/java-spanner/commit/d67f108e86925c1296e695db8e78fa82e11fa4fa))
* runs sample tests in java 8 and java 11 ([#345](https://www.github.com/googleapis/java-spanner/issues/345)) ([b547e31](https://www.github.com/googleapis/java-spanner/commit/b547e31d095be3cf1646e0e9c07bfc467ecc3c22))
* set gRPC keep-alive to 120 seconds ([#339](https://www.github.com/googleapis/java-spanner/issues/339)) ([26be103](https://www.github.com/googleapis/java-spanner/commit/26be103da1117c4940550fad1672c66e6edfbdb3))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.3 ([#334](https://www.github.com/googleapis/java-spanner/issues/334)) ([45acd89](https://www.github.com/googleapis/java-spanner/commit/45acd8960c961d48e91a7b1546efa64d9e9ae576))
* update shared config to 0.9.2 ([#328](https://www.github.com/googleapis/java-spanner/issues/328)) ([75df62c](https://www.github.com/googleapis/java-spanner/commit/75df62c0176137fda1d0a9076b83be06f11228ce))

## [1.58.0](https://www.github.com/googleapis/java-spanner/compare/v1.57.0...v1.58.0) (2020-07-07)


### Features

* add async api ([#81](https://www.github.com/googleapis/java-spanner/issues/81)) ([462839b](https://www.github.com/googleapis/java-spanner/commit/462839b625e58e235581b8ba10b398e1d222eaaf))
* support setting compression option ([#192](https://www.github.com/googleapis/java-spanner/issues/192)) ([965e95e](https://www.github.com/googleapis/java-spanner/commit/965e95e70ccd9c62abd6513b0011aab136e48e26))


### Bug Fixes

* set default values for streaming retry ([#316](https://www.github.com/googleapis/java-spanner/issues/316)) ([543373b](https://www.github.com/googleapis/java-spanner/commit/543373b22336be72b10026fda9f0b55939ab94b4))


### Performance Improvements

* use streaming RPC for PDML ([#287](https://www.github.com/googleapis/java-spanner/issues/287)) ([df47c13](https://www.github.com/googleapis/java-spanner/commit/df47c13a4c00bdf5e6eafa01bbb64c12a96d7fb8))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.2 ([#315](https://www.github.com/googleapis/java-spanner/issues/315)) ([3d6fb9f](https://www.github.com/googleapis/java-spanner/commit/3d6fb9fd7dc6b2b5b2ff9935228701ac795c9167))

## [1.57.0](https://www.github.com/googleapis/java-spanner/compare/v1.56.0...v1.57.0) (2020-06-29)


### Features

* **deps:** adopt flatten plugin and google-cloud-shared-dependencies and update ExecutorProvider ([#302](https://www.github.com/googleapis/java-spanner/issues/302)) ([5aef6c3](https://www.github.com/googleapis/java-spanner/commit/5aef6c3f6d3e9564cb8728ad51718feb6b64475a))

## [1.56.0](https://www.github.com/googleapis/java-spanner/compare/v1.55.1...v1.56.0) (2020-06-17)


### Features

* add num_sessions_in_pool metric ([#128](https://www.github.com/googleapis/java-spanner/issues/128)) ([3a7a8ad](https://www.github.com/googleapis/java-spanner/commit/3a7a8ad79f1de3371d32a1298406990cb7bbf5be))


### Bug Fixes

* backend now supports optimizer version for DML ([#252](https://www.github.com/googleapis/java-spanner/issues/252)) ([24b986b](https://www.github.com/googleapis/java-spanner/commit/24b986b03a785f4c5ee978dcdc57f51687701e52))
* include an explicit version for javax-annotations-api ([#261](https://www.github.com/googleapis/java-spanner/issues/261)) ([e256d22](https://www.github.com/googleapis/java-spanner/commit/e256d22f33d5f091ea90ed81c0b0f8600beae96c))
* inconsistent json and yaml spanner configs ([#238](https://www.github.com/googleapis/java-spanner/issues/238)) ([627fdc1](https://www.github.com/googleapis/java-spanner/commit/627fdc13d64ab7b51934d4866ff753f7b08dabe4))
* test allowed a too old staleness ([#214](https://www.github.com/googleapis/java-spanner/issues/214)) ([f4fa6bf](https://www.github.com/googleapis/java-spanner/commit/f4fa6bfca4bb821cbda426c4cb7bf32f091a2913))
* use millis to prevent rounding errors ([#260](https://www.github.com/googleapis/java-spanner/issues/260)) ([22ed458](https://www.github.com/googleapis/java-spanner/commit/22ed45816098f5e50104935b66bc55297ea7f7b7))


### Dependencies

* include test-jar in bom ([#253](https://www.github.com/googleapis/java-spanner/issues/253)) ([4e86a37](https://www.github.com/googleapis/java-spanner/commit/4e86a374aacbcfc34d64809b7d9606f21176f6b9))
* update dependency org.json:json to v20200518 ([#239](https://www.github.com/googleapis/java-spanner/issues/239)) ([e3d7921](https://www.github.com/googleapis/java-spanner/commit/e3d79214ac4d6e72992acdddb7ddeb2148b1ae15))

### [1.55.1](https://www.github.com/googleapis/java-spanner/compare/v1.55.0...v1.55.1) (2020-05-21)


### Bug Fixes

* PDML retry settings were not applied for aborted tx ([#232](https://www.github.com/googleapis/java-spanner/issues/232)) ([308a465](https://www.github.com/googleapis/java-spanner/commit/308a465c768ba6e641c95d8c6efd214637266f50)), closes [#199](https://www.github.com/googleapis/java-spanner/issues/199)
* remove the need for any env var in all tests ([#235](https://www.github.com/googleapis/java-spanner/issues/235)) ([374fb40](https://www.github.com/googleapis/java-spanner/commit/374fb403306612330db58dfa5549205394a08e67))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.4.0 ([#224](https://www.github.com/googleapis/java-spanner/issues/224)) ([2cf04aa](https://www.github.com/googleapis/java-spanner/commit/2cf04aad7edc68baf5c296bda11f66c140abf669))

## [1.55.0](https://www.github.com/googleapis/java-spanner/compare/v1.54.0...v1.55.0) (2020-05-19)


### Features

* mark when a Spanner client is closed ([#198](https://www.github.com/googleapis/java-spanner/issues/198)) ([50cb174](https://www.github.com/googleapis/java-spanner/commit/50cb1744e7ede611758d3ff63b3df77a1d3682eb))


### Bug Fixes

* make it possible to override backups methods ([#195](https://www.github.com/googleapis/java-spanner/issues/195)) ([2d19c25](https://www.github.com/googleapis/java-spanner/commit/2d19c25ba32847d116194565e67e1b1276fcb9f8))
* Partitioned DML timeout was not always respected ([#203](https://www.github.com/googleapis/java-spanner/issues/203)) ([13cb37e](https://www.github.com/googleapis/java-spanner/commit/13cb37e55ddfd1ff4ec22b1dcdc20c4832eee444)), closes [#199](https://www.github.com/googleapis/java-spanner/issues/199)
* partitionedDml stub was not closed ([#213](https://www.github.com/googleapis/java-spanner/issues/213)) ([a2d9a33](https://www.github.com/googleapis/java-spanner/commit/a2d9a33fa31f7467fc2bfbef5a29c4b3f5aea7c8))
* reuse clientId for invalidated databases ([#206](https://www.github.com/googleapis/java-spanner/issues/206)) ([7b4490d](https://www.github.com/googleapis/java-spanner/commit/7b4490dfb61fbc81b5bd6be6c9a663b36b5ce402))
* use nanos to prevent truncation errors ([#204](https://www.github.com/googleapis/java-spanner/issues/204)) ([a608460](https://www.github.com/googleapis/java-spanner/commit/a60846043dc0ca47e1970d8ab99380b6d725c7a9)), closes [#200](https://www.github.com/googleapis/java-spanner/issues/200)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.3.1 ([#190](https://www.github.com/googleapis/java-spanner/issues/190)) ([ad41a0d](https://www.github.com/googleapis/java-spanner/commit/ad41a0d4b0cc6a2c0ae0611c767652f64cfb2fb7))

## [1.54.0](https://www.github.com/googleapis/java-spanner/compare/v1.53.0...v1.54.0) (2020-05-05)


### Features

* **deps:** import shared-dependencies bom and use maven-flatten-plugin ([#172](https://www.github.com/googleapis/java-spanner/issues/172)) ([060a81a](https://www.github.com/googleapis/java-spanner/commit/060a81ac938ef644aefd8c90d026018107742141))


### Bug Fixes

* create filter in correct order ([#180](https://www.github.com/googleapis/java-spanner/issues/180)) ([d80428a](https://www.github.com/googleapis/java-spanner/commit/d80428a5b0291516b2298e2309de09b23e4c387d))
* remove error message checking ([#183](https://www.github.com/googleapis/java-spanner/issues/183)) ([b477322](https://www.github.com/googleapis/java-spanner/commit/b4773223dbeb682c2c8fa9c0a9dea31001dd94d6)), closes [#175](https://www.github.com/googleapis/java-spanner/issues/175)
* set resource type for database parameter of Backup ([#174](https://www.github.com/googleapis/java-spanner/issues/174)) ([bb4d7cf](https://www.github.com/googleapis/java-spanner/commit/bb4d7cf4a363cf4980e22be97d2b5e4267368a7d))
* stop preparing session on most errors ([#181](https://www.github.com/googleapis/java-spanner/issues/181)) ([d0e3d41](https://www.github.com/googleapis/java-spanner/commit/d0e3d41131a7480baee787654b7b9591efae5069)), closes [#177](https://www.github.com/googleapis/java-spanner/issues/177)

## [1.53.0](https://www.github.com/googleapis/java-spanner/compare/v1.52.0...v1.53.0) (2020-04-22)


### Features

* optimize maintainer to let sessions be GC'ed instead of deleted ([#135](https://www.github.com/googleapis/java-spanner/issues/135)) ([d65747c](https://www.github.com/googleapis/java-spanner/commit/d65747cbc704508f6f1bcef6eea53aa411d42ee2))


### Bug Fixes

* assign unique id's per test case ([#129](https://www.github.com/googleapis/java-spanner/issues/129)) ([a553b6d](https://www.github.com/googleapis/java-spanner/commit/a553b6d48c4f5ee2d0583e5b825d73a85f06216e))
* check for not null input for Id classes ([#159](https://www.github.com/googleapis/java-spanner/issues/159)) ([ecf5826](https://www.github.com/googleapis/java-spanner/commit/ecf582670818f32e85f534ec400d0b8d31cf9ca6)), closes [#145](https://www.github.com/googleapis/java-spanner/issues/145)
* clean up test instance if creation failed ([#162](https://www.github.com/googleapis/java-spanner/issues/162)) ([ff571e1](https://www.github.com/googleapis/java-spanner/commit/ff571e16a45fbce692d9bb172749ff15fafe7a9c))
* fix flaky test and remove warnings ([#153](https://www.github.com/googleapis/java-spanner/issues/153)) ([d534e35](https://www.github.com/googleapis/java-spanner/commit/d534e350346b0c9ab8057ede36bc3aac473c0b06)), closes [#146](https://www.github.com/googleapis/java-spanner/issues/146)
* increase test timeout and remove warnings ([#160](https://www.github.com/googleapis/java-spanner/issues/160)) ([63a6bd8](https://www.github.com/googleapis/java-spanner/commit/63a6bd8be08a56d002f58bc2cdb2856ad0dc5fa3)), closes [#158](https://www.github.com/googleapis/java-spanner/issues/158)
* retry non-idempotent long-running RPCs ([#141](https://www.github.com/googleapis/java-spanner/issues/141)) ([4669c02](https://www.github.com/googleapis/java-spanner/commit/4669c02a24e0f7b1d53c9edf5ab7b146b4116960))
* retry restore if blocked by pending restore ([#119](https://www.github.com/googleapis/java-spanner/issues/119)) ([220653d](https://www.github.com/googleapis/java-spanner/commit/220653d8e25c518d0df447bf777a7fcbf04a01ca)), closes [#118](https://www.github.com/googleapis/java-spanner/issues/118)
* StatementParser did not accept multiple query hints ([#170](https://www.github.com/googleapis/java-spanner/issues/170)) ([ef41a6e](https://www.github.com/googleapis/java-spanner/commit/ef41a6e503f218c00c16914aa9c1433d9b26db13)), closes [#163](https://www.github.com/googleapis/java-spanner/issues/163)
* wait for initialization to finish before test ([#161](https://www.github.com/googleapis/java-spanner/issues/161)) ([fe434ff](https://www.github.com/googleapis/java-spanner/commit/fe434ff7068b4b618e70379c224e1c5ab88f6ba1)), closes [#146](https://www.github.com/googleapis/java-spanner/issues/146)


### Performance Improvements

* increase sessions in the pool in batches ([#134](https://www.github.com/googleapis/java-spanner/issues/134)) ([9e5a1cd](https://www.github.com/googleapis/java-spanner/commit/9e5a1cdaacf71147b67681861f063c3276705f44))
* prepare sessions with r/w tx in-process ([#152](https://www.github.com/googleapis/java-spanner/issues/152)) ([2db27ce](https://www.github.com/googleapis/java-spanner/commit/2db27ce048efafaa3c28b097de33518747011465)), closes [#151](https://www.github.com/googleapis/java-spanner/issues/151)


### Dependencies

* update core dependencies ([#109](https://www.github.com/googleapis/java-spanner/issues/109)) ([5753f1f](https://www.github.com/googleapis/java-spanner/commit/5753f1f4fed83df87262404f7a7ba7eedcd366cb))
* update core dependencies ([#132](https://www.github.com/googleapis/java-spanner/issues/132)) ([77c1558](https://www.github.com/googleapis/java-spanner/commit/77c1558652ee00e529674ac3a2dcf3210ef049fa))
* update dependency com.google.api:api-common to v1.9.0 ([#127](https://www.github.com/googleapis/java-spanner/issues/127)) ([b2c744f](https://www.github.com/googleapis/java-spanner/commit/b2c744f01a4d5a8981df5ff900f3536c83265a61))
* update dependency com.google.guava:guava-bom to v29 ([#147](https://www.github.com/googleapis/java-spanner/issues/147)) ([3fe3ae0](https://www.github.com/googleapis/java-spanner/commit/3fe3ae02376af552564c93c766f562d6454b7ac1))
* update dependency io.grpc:grpc-bom to v1.29.0 ([#164](https://www.github.com/googleapis/java-spanner/issues/164)) ([2d2ce5c](https://www.github.com/googleapis/java-spanner/commit/2d2ce5ce4dc8f410ec671e542e144d47f39ab40b))
* update dependency org.threeten:threetenbp to v1.4.3 ([#120](https://www.github.com/googleapis/java-spanner/issues/120)) ([49d1abc](https://www.github.com/googleapis/java-spanner/commit/49d1abcb6c9c48762dcf0fe1466ab107bf67146b))

## [1.52.0](https://www.github.com/googleapis/java-spanner/compare/v1.51.0...v1.52.0) (2020-03-20)


### Features

* add backup support ([#100](https://www.github.com/googleapis/java-spanner/issues/100)) ([ed3874a](https://www.github.com/googleapis/java-spanner/commit/ed3874afcf55fe7381354e03dab3a3b97d7eb520))
* add Backups protos and APIs ([#97](https://www.github.com/googleapis/java-spanner/issues/97)) ([5643c22](https://www.github.com/googleapis/java-spanner/commit/5643c22a4531dac75b9fac5b128eb714a27920a0))


### Bug Fixes

* add client id to metrics to avoid collisions ([#117](https://www.github.com/googleapis/java-spanner/issues/117)) ([338e136](https://www.github.com/googleapis/java-spanner/commit/338e136508edc6745f9371e8a5d66638021bc8d7)), closes [#106](https://www.github.com/googleapis/java-spanner/issues/106)
* ignore added interface methods for generated code ([#101](https://www.github.com/googleapis/java-spanner/issues/101)) ([402cfa1](https://www.github.com/googleapis/java-spanner/commit/402cfa1e1e2994f7bb1b783cf823021b54fb175e)), closes [#99](https://www.github.com/googleapis/java-spanner/issues/99)
* use grpc 1.27.2 to prevent version conflicts ([#105](https://www.github.com/googleapis/java-spanner/issues/105)) ([37b7c88](https://www.github.com/googleapis/java-spanner/commit/37b7c8859e5f35d85bd14ef72662614fd185c020))


### Dependencies

* update core dependencies ([#94](https://www.github.com/googleapis/java-spanner/issues/94)) ([f3ca4c9](https://www.github.com/googleapis/java-spanner/commit/f3ca4c99c3d54f64c5eda11e4a4c076140fdbc6a))
* update opencensus.version to v0.26.0 ([#116](https://www.github.com/googleapis/java-spanner/issues/116)) ([1b8db0b](https://www.github.com/googleapis/java-spanner/commit/1b8db0b407429e02bb1e4c9af839afeed21dac5d))

## [1.51.0](https://www.github.com/googleapis/java-spanner/compare/v1.50.0...v1.51.0) (2020-03-13)


### Features

* add backend query options ([#90](https://www.github.com/googleapis/java-spanner/issues/90)) ([e96e172](https://www.github.com/googleapis/java-spanner/commit/e96e17246bee9691171b46857806d03d1f8e19b4))
* add QueryOptions proto ([#84](https://www.github.com/googleapis/java-spanner/issues/84)) ([eb8fc37](https://www.github.com/googleapis/java-spanner/commit/eb8fc375bbd766f25966aa565e266ed972bbe818))


### Bug Fixes

* never use credentials in combination with plain text ([#98](https://www.github.com/googleapis/java-spanner/issues/98)) ([7eb8d49](https://www.github.com/googleapis/java-spanner/commit/7eb8d49cd6c35d7f757cb89009ad16be601b77c3))


### Dependencies

* update dependency com.google.cloud:google-cloud-core-bom to v1.93.1 ([#91](https://www.github.com/googleapis/java-spanner/issues/91)) ([29d8db8](https://www.github.com/googleapis/java-spanner/commit/29d8db8cfc9d12824b9264d0fb870049a58a9a03))
* update dependency io.opencensus:opencensus-api to v0.25.0 ([#95](https://www.github.com/googleapis/java-spanner/issues/95)) ([57f5fd0](https://www.github.com/googleapis/java-spanner/commit/57f5fd0f3bee4b437f48b6a08ab3174f035c8cca))

## [1.50.0](https://www.github.com/googleapis/java-spanner/compare/v1.49.2...v1.50.0) (2020-02-28)


### Features

* add metrics to capture acquired and released sessions data ([#67](https://www.github.com/googleapis/java-spanner/issues/67)) ([94d0557](https://www.github.com/googleapis/java-spanner/commit/94d05575c37c7c7c7e9d7d3fbaea46c6d2eb6a4d))
* add session timeout metric ([#65](https://www.github.com/googleapis/java-spanner/issues/65)) ([8d84b53](https://www.github.com/googleapis/java-spanner/commit/8d84b53efd2d237e193b68bc36345d338b0cdf20))
* instrument Spanner client with OpenCensus metrics ([#54](https://www.github.com/googleapis/java-spanner/issues/54)) ([d9a00a8](https://www.github.com/googleapis/java-spanner/commit/d9a00a81c454ae793f9687d0e2de2bcc58d96502))


### Bug Fixes

* multiple calls to end of span ([#75](https://www.github.com/googleapis/java-spanner/issues/75)) ([3f32f51](https://www.github.com/googleapis/java-spanner/commit/3f32f51d70ceacbea02439c0f48ad057b10fb570))


### Dependencies

* update core dependencies ([#87](https://www.github.com/googleapis/java-spanner/issues/87)) ([b096651](https://www.github.com/googleapis/java-spanner/commit/b096651ddde940de9929600b31f78f965939139d))
* update dependency com.google.cloud:google-cloud-core-bom to v1.92.5 ([56742c9](https://www.github.com/googleapis/java-spanner/commit/56742c96ff30f444e18a8bbde94ca173123385be))
* update dependency com.google.http-client:google-http-client-bom to v1.34.2 ([#88](https://www.github.com/googleapis/java-spanner/issues/88)) ([628093d](https://www.github.com/googleapis/java-spanner/commit/628093d97877b912f6e4e706d22c2c24ba77a808))
* update dependency com.google.protobuf:protobuf-bom to v3.11.4 ([#77](https://www.github.com/googleapis/java-spanner/issues/77)) ([fb2c683](https://www.github.com/googleapis/java-spanner/commit/fb2c683cf195e7229fe3d61a3332c32298be2625))
* update dependency io.grpc:grpc-bom to v1.27.1 ([054b7e7](https://www.github.com/googleapis/java-spanner/commit/054b7e7091af6b61c7d2ad203688a65bcb18ed0c))
* update opencensus.version to v0.25.0 ([#70](https://www.github.com/googleapis/java-spanner/issues/70)) ([26a3eff](https://www.github.com/googleapis/java-spanner/commit/26a3eff44c7d1f36541440aa7d29fc1d3ae8a4d7))


### Documentation

* **regen:** update sample code to set total timeout, add API client header test ([#66](https://www.github.com/googleapis/java-spanner/issues/66)) ([1178958](https://www.github.com/googleapis/java-spanner/commit/1178958eaec5aa6ea80938ad91dfb0b1a688463d))

### [1.49.2](https://www.github.com/googleapis/java-spanner/compare/v1.49.1...v1.49.2) (2020-02-06)


### Bug Fixes

* stop sending RPCs on InstanceNotFound ([#61](https://www.github.com/googleapis/java-spanner/issues/61)) ([7618ac8](https://www.github.com/googleapis/java-spanner/commit/7618ac8bc32f7d3482bd4a0850be2bce71c33fc3)), closes [#60](https://www.github.com/googleapis/java-spanner/issues/60)
* use default retry settings for aborted tx ([#48](https://www.github.com/googleapis/java-spanner/issues/48)) ([6709552](https://www.github.com/googleapis/java-spanner/commit/6709552653f344537c209eef7f1e9e037a38e849))
* use resource type to identify type of error ([#57](https://www.github.com/googleapis/java-spanner/issues/57)) ([89c3e77](https://www.github.com/googleapis/java-spanner/commit/89c3e77b99b303576c83b2313fc54d8c0e075e18))
* use streaming retry settings for ResumableStreamIterator ([#49](https://www.github.com/googleapis/java-spanner/issues/49)) ([63b33e9](https://www.github.com/googleapis/java-spanner/commit/63b33e93e17303fe8f1fae01cfe44427178baf6c))


### Dependencies

* update core dependencies ([#59](https://www.github.com/googleapis/java-spanner/issues/59)) ([74b6b98](https://www.github.com/googleapis/java-spanner/commit/74b6b983ec275280572a5dcc49ececc94c4a4dce))

### [1.49.1](https://www.github.com/googleapis/java-spanner/compare/v1.49.0...v1.49.1) (2020-01-24)


### Bug Fixes

* stop sending RPCs to deleted database ([#34](https://www.github.com/googleapis/java-spanner/issues/34)) ([11e4a90](https://www.github.com/googleapis/java-spanner/commit/11e4a90e73af8a5baf9aa593daa6192520363398)), closes [#16](https://www.github.com/googleapis/java-spanner/issues/16)


### Performance Improvements

* close sessions async ([#24](https://www.github.com/googleapis/java-spanner/issues/24)) ([ab25087](https://www.github.com/googleapis/java-spanner/commit/ab250871cae51b3f496719d579db5bb6e263d5c3)), closes [#19](https://www.github.com/googleapis/java-spanner/issues/19)
* close sessions async revert revert ([#46](https://www.github.com/googleapis/java-spanner/issues/46)) ([c9864e5](https://www.github.com/googleapis/java-spanner/commit/c9864e58b14bb428e443bf958e7596a94199f629)), closes [#24](https://www.github.com/googleapis/java-spanner/issues/24) [#43](https://www.github.com/googleapis/java-spanner/issues/43) [#24](https://www.github.com/googleapis/java-spanner/issues/24)


### Reverts

* Revert "perf: close sessions async (#24)" (#43) ([809ed88](https://www.github.com/googleapis/java-spanner/commit/809ed8875d65362ef14d27c5382dfe4c1ad9aa1b)), closes [#24](https://www.github.com/googleapis/java-spanner/issues/24) [#43](https://www.github.com/googleapis/java-spanner/issues/43)

## [1.49.0](https://www.github.com/googleapis/java-spanner/compare/v1.48.0...v1.49.0) (2020-01-16)


### Features

* add support for CallCredentials ([#26](https://www.github.com/googleapis/java-spanner/issues/26)) ([1112357](https://www.github.com/googleapis/java-spanner/commit/1112357be1c5fb9c4abfba48989fe8217853876a)), closes [#18](https://www.github.com/googleapis/java-spanner/issues/18)


### Bug Fixes

* add keepalives to GRPC channel ([#11](https://www.github.com/googleapis/java-spanner/issues/11)) ([428a4a6](https://www.github.com/googleapis/java-spanner/commit/428a4a6d3c9e1536a80f1fa9f76f36fe1062a104))


### Dependencies

* mockito scope should be test ([#29](https://www.github.com/googleapis/java-spanner/issues/29)) ([9b0733d](https://www.github.com/googleapis/java-spanner/commit/9b0733d927237d8d16f507a1d0129ddb638df55a))
* update dependency com.google.truth:truth to v1.0.1 ([#35](https://www.github.com/googleapis/java-spanner/issues/35)) ([fa2b471](https://www.github.com/googleapis/java-spanner/commit/fa2b471884c3b805fd6aa56a38d7c1f98c4cb940))
* update dependency org.threeten:threetenbp to v1.4.1 ([c22c831](https://www.github.com/googleapis/java-spanner/commit/c22c831473dd0b18b71e1ea4d000cd34555a3a48))

## [1.48.0](https://www.github.com/googleapis/java-spanner/compare/1.47.0...v1.48.0) (2020-01-10)


### Features

* add public method to get gRPC status code ([#25](https://www.github.com/googleapis/java-spanner/issues/25)) ([2dbe3cf](https://www.github.com/googleapis/java-spanner/commit/2dbe3cf397357de09d24bb57e367bbe947e682f4)), closes [#14](https://www.github.com/googleapis/java-spanner/issues/14)
* make repo releasable, add parent/bom ([#4](https://www.github.com/googleapis/java-spanner/issues/4)) ([f0073ee](https://www.github.com/googleapis/java-spanner/commit/f0073ee8d0aa68161f3071e6a72af376a1db1731))


### Dependencies

* update dependency org.jacoco:jacoco-maven-plugin to v0.8.5 ([#7023](https://www.github.com/googleapis/java-spanner/issues/7023)) ([d8b6438](https://www.github.com/googleapis/java-spanner/commit/d8b6438aa3b881c1c9baff584a74813664be4df8))
