# Changelog

## [2.5.0](https://github.com/googleapis/java-securitycenter/compare/v2.4.0...v2.5.0) (2022-03-03)


### Features

* Add BigQuery export APIs that help you enable writing new/updated findings from  Security Command Center to a BigQuery table in near-real time. You can then integrate the data into existing workflows and create custom analyses. You can enable thi... ([#769](https://github.com/googleapis/java-securitycenter/issues/769)) ([b4641d8](https://github.com/googleapis/java-securitycenter/commit/b4641d8f54a43d4cb2746846b60b817027479755))


### Documentation

* Update documentation for the Finding resource field "project_display_name" ([#760](https://github.com/googleapis/java-securitycenter/issues/760)) ([2d4fb45](https://github.com/googleapis/java-securitycenter/commit/2d4fb45c9e101ea4c959f0fa432d3f515db7d379))
* Update documentation for the Mute fields on Findings ([2d4fb45](https://github.com/googleapis/java-securitycenter/commit/2d4fb45c9e101ea4c959f0fa432d3f515db7d379))


### Dependencies

* update actions/github-script action to v6 ([#756](https://github.com/googleapis/java-securitycenter/issues/756)) ([9fda568](https://github.com/googleapis/java-securitycenter/commit/9fda56897f82d236b9ca0f7bd6e922d813ca8e7a))
* update dependency com.google.cloud:google-cloud-pubsub to v1.115.2 ([#748](https://github.com/googleapis/java-securitycenter/issues/748)) ([330195a](https://github.com/googleapis/java-securitycenter/commit/330195a4a7d146170f0ec4c9cbcaf661715fc340))
* update dependency com.google.cloud:google-cloud-pubsub to v1.115.5 ([#772](https://github.com/googleapis/java-securitycenter/issues/772)) ([ef57ca0](https://github.com/googleapis/java-securitycenter/commit/ef57ca098acac3913bfd503f68f4b0f913b7a515))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.8.0 ([#768](https://github.com/googleapis/java-securitycenter/issues/768)) ([80d33d3](https://github.com/googleapis/java-securitycenter/commit/80d33d3a14cd8582bbd1a1cb307d303ac5fe6455))
* update dependency com.google.protobuf:protobuf-java-util to v3.19.4 ([#724](https://github.com/googleapis/java-securitycenter/issues/724)) ([c955858](https://github.com/googleapis/java-securitycenter/commit/c955858eb60845ad96c31550f9d2686e82ab708a))

## [2.4.0](https://github.com/googleapis/java-securitycenter/compare/v2.3.2...v2.4.0) (2022-02-03)


### Features

* Release the access field in the v1 finding proto, which represents an access event tied to the finding ([#744](https://github.com/googleapis/java-securitycenter/issues/744)) ([94f600d](https://github.com/googleapis/java-securitycenter/commit/94f600dd9b5adf1990c6ba8789e391700a7ca4ad))


### Dependencies

* **java:** update actions/github-script action to v5 ([#1339](https://github.com/googleapis/java-securitycenter/issues/1339)) ([#742](https://github.com/googleapis/java-securitycenter/issues/742)) ([7361505](https://github.com/googleapis/java-securitycenter/commit/7361505b7fd4021daf33a7472458c17c97ed6c2e))
* update actions/github-script action to v5 ([#741](https://github.com/googleapis/java-securitycenter/issues/741)) ([3138f0c](https://github.com/googleapis/java-securitycenter/commit/3138f0c8f0369782decaed49164588862c855908))
* update dependency com.google.cloud:google-cloud-pubsub to v1.115.1 ([#730](https://github.com/googleapis/java-securitycenter/issues/730)) ([2a0b4cd](https://github.com/googleapis/java-securitycenter/commit/2a0b4cda8fd1c489cd983db02e3452623e8c7e3c))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.7.0 ([#743](https://github.com/googleapis/java-securitycenter/issues/743)) ([b2c717e](https://github.com/googleapis/java-securitycenter/commit/b2c717e843f795ca7fd2b910ba55c5e74eb33b0e))


### Documentation

* added more clarification around what event_time means on a v1 finding ([94f600d](https://github.com/googleapis/java-securitycenter/commit/94f600dd9b5adf1990c6ba8789e391700a7ca4ad))

### [2.3.2](https://www.github.com/googleapis/java-securitycenter/compare/v2.3.1...v2.3.2) (2022-01-07)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.6.0 ([#725](https://www.github.com/googleapis/java-securitycenter/issues/725)) ([7ea7a58](https://www.github.com/googleapis/java-securitycenter/commit/7ea7a58d305ebf10a8d2fb374be8f261e4fcbe05))

### [2.3.1](https://www.github.com/googleapis/java-securitycenter/compare/v2.3.0...v2.3.1) (2021-12-07)


### Dependencies

* update dependency com.google.cloud:google-cloud-pubsub to v1.115.0 ([#714](https://www.github.com/googleapis/java-securitycenter/issues/714)) ([2e02da2](https://www.github.com/googleapis/java-securitycenter/commit/2e02da268fb584fde02e25c68c8fb55304894b29))

## [2.3.0](https://www.github.com/googleapis/java-securitycenter/compare/v2.2.0...v2.3.0) (2021-12-06)


### Features

* Added a new API method UpdateExternalSystem, which enables updating a finding w/ external system metadata. External systems are a child resource under finding, and are housed on the finding itself, and can also be filtered on in Notifications, th... ([#705](https://www.github.com/googleapis/java-securitycenter/issues/705)) ([73ee05e](https://www.github.com/googleapis/java-securitycenter/commit/73ee05ef049b42cf05d8ab9ccd2f7cd9cb3d49e3))
* Added mute related APIs, proto messages and fields ([#702](https://www.github.com/googleapis/java-securitycenter/issues/702)) ([5b88a33](https://www.github.com/googleapis/java-securitycenter/commit/5b88a33193d2eaba1e1b03bba42271211f61b2de))
* Added resource type and display_name field to the FindingResult, and supported them in the filter for ListFindings and GroupFindings. Also added display_name to the resource which is surfaced in NotificationMessage ([#693](https://www.github.com/googleapis/java-securitycenter/issues/693)) ([bf8f477](https://www.github.com/googleapis/java-securitycenter/commit/bf8f4774bb18da8568d1dacefa09900a54007e62))


### Bug Fixes

* **java:** add -ntp flag to native image testing command ([#1299](https://www.github.com/googleapis/java-securitycenter/issues/1299)) ([#711](https://www.github.com/googleapis/java-securitycenter/issues/711)) ([88d9aa6](https://www.github.com/googleapis/java-securitycenter/commit/88d9aa6ea93f0c0802c3adb6a479c727c6680b6d))
* **java:** java 17 dependency arguments ([#1266](https://www.github.com/googleapis/java-securitycenter/issues/1266)) ([#688](https://www.github.com/googleapis/java-securitycenter/issues/688)) ([ae4bc65](https://www.github.com/googleapis/java-securitycenter/commit/ae4bc65147b692b6237eb9683e698258857374bb))


### Documentation

* fix docstring formatting ([#698](https://www.github.com/googleapis/java-securitycenter/issues/698)) ([ccf2673](https://www.github.com/googleapis/java-securitycenter/commit/ccf2673592aab31731db307c20b4779809a1547a))
* fix docstring formatting ([#704](https://www.github.com/googleapis/java-securitycenter/issues/704)) ([9508222](https://www.github.com/googleapis/java-securitycenter/commit/950822299d7adcaf123992d0a668a37c901b96a2))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.5.0 ([#701](https://www.github.com/googleapis/java-securitycenter/issues/701)) ([3f862c6](https://www.github.com/googleapis/java-securitycenter/commit/3f862c6263b382d5012909a6979715a2dac4ea7d))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.5.1 ([#710](https://www.github.com/googleapis/java-securitycenter/issues/710)) ([6a02612](https://www.github.com/googleapis/java-securitycenter/commit/6a02612320a2e888cc317be08eb55a0a6a0fdea7))
* update dependency com.google.protobuf:protobuf-java-util to v3.19.0 ([#686](https://www.github.com/googleapis/java-securitycenter/issues/686)) ([dfa655f](https://www.github.com/googleapis/java-securitycenter/commit/dfa655fb3cf91d81f7175cf32e0fe7ac7f425e74))
* update dependency com.google.protobuf:protobuf-java-util to v3.19.1 ([#699](https://www.github.com/googleapis/java-securitycenter/issues/699)) ([5c9f5f0](https://www.github.com/googleapis/java-securitycenter/commit/5c9f5f0f7aa9e7e6112f102caa65671604db4efa))

## [2.2.0](https://www.github.com/googleapis/java-securitycenter/compare/v2.1.7...v2.2.0) (2021-10-20)


### Features

* add `google/api/routing.proto` ([#658](https://www.github.com/googleapis/java-securitycenter/issues/658)) ([2397ab2](https://www.github.com/googleapis/java-securitycenter/commit/2397ab275e0458b7ab759aa71ced083a728cbe49))
* Added vulnerability field to the finding feat: Added type field to the resource which is surfaced in NotificationMessage ([#676](https://www.github.com/googleapis/java-securitycenter/issues/676)) ([2240296](https://www.github.com/googleapis/java-securitycenter/commit/224029671d195514a58314c62c53911f1c0a8716))
* publish `routing.proto` containing the `google.api.RoutingRule` annotation feat: add Bazel rules wrapping `routing.proto` ([#677](https://www.github.com/googleapis/java-securitycenter/issues/677)) ([c40cfe9](https://www.github.com/googleapis/java-securitycenter/commit/c40cfe982dc0971341f4227b40a2c992df9603d8))


### Dependencies

* update dependency com.google.cloud:google-cloud-pubsub to v1.114.7 ([#682](https://www.github.com/googleapis/java-securitycenter/issues/682)) ([b9416c1](https://www.github.com/googleapis/java-securitycenter/commit/b9416c19efadea3fc0a7e6f9afa6c7d9d8b38cea))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.4.0 ([#683](https://www.github.com/googleapis/java-securitycenter/issues/683)) ([7880367](https://www.github.com/googleapis/java-securitycenter/commit/78803678005cc2534d4215348300ea9cb6791f61))

### [2.1.7](https://www.github.com/googleapis/java-securitycenter/compare/v2.1.6...v2.1.7) (2021-10-06)


### Dependencies

* update dependency com.google.cloud:google-cloud-pubsub to v1.114.6 ([#670](https://www.github.com/googleapis/java-securitycenter/issues/670)) ([f49aec7](https://www.github.com/googleapis/java-securitycenter/commit/f49aec785809bdbc082b0c2576cc3c3b492fc670))
* update dependency com.google.protobuf:protobuf-java-util to v3.18.1 ([#669](https://www.github.com/googleapis/java-securitycenter/issues/669)) ([620e1df](https://www.github.com/googleapis/java-securitycenter/commit/620e1df18c1f22a4cf442b4835e2056cc6ba1a85))

### [2.1.6](https://www.github.com/googleapis/java-securitycenter/compare/v2.1.5...v2.1.6) (2021-09-29)


### Dependencies

* update dependency com.google.cloud:google-cloud-pubsub to v1.114.5 ([#661](https://www.github.com/googleapis/java-securitycenter/issues/661)) ([a748606](https://www.github.com/googleapis/java-securitycenter/commit/a748606774b6f6fe17aeb39837c9b4661570cc05))

### [2.1.5](https://www.github.com/googleapis/java-securitycenter/compare/v2.1.4...v2.1.5) (2021-09-22)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.3.0 ([#654](https://www.github.com/googleapis/java-securitycenter/issues/654)) ([beb04f6](https://www.github.com/googleapis/java-securitycenter/commit/beb04f66792e9c844aa973833d0e7ab845b14e9b))

### [2.1.4](https://www.github.com/googleapis/java-securitycenter/compare/v2.1.3...v2.1.4) (2021-09-20)


### Dependencies

* update dependency com.google.cloud:google-cloud-pubsub to v1.114.4 ([#648](https://www.github.com/googleapis/java-securitycenter/issues/648)) ([cea016c](https://www.github.com/googleapis/java-securitycenter/commit/cea016c340bb1bdc06dbbf912c47d7084d547200))

### [2.1.3](https://www.github.com/googleapis/java-securitycenter/compare/v2.1.2...v2.1.3) (2021-09-15)


### Dependencies

* update dependency com.google.protobuf:protobuf-java-util to v3.18.0 ([#644](https://www.github.com/googleapis/java-securitycenter/issues/644)) ([acd6825](https://www.github.com/googleapis/java-securitycenter/commit/acd68257f8c6ece399185bdd63bf789e4919ae1a))

### [2.1.2](https://www.github.com/googleapis/java-securitycenter/compare/v2.1.1...v2.1.2) (2021-09-14)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.2.1 ([#639](https://www.github.com/googleapis/java-securitycenter/issues/639)) ([565810b](https://www.github.com/googleapis/java-securitycenter/commit/565810b597e9cb88b4ef8ce8fc3f05294793dc19))

### [2.1.1](https://www.github.com/googleapis/java-securitycenter/compare/v2.1.0...v2.1.1) (2021-09-03)


### Dependencies

* update dependency com.google.cloud:google-cloud-pubsub to v1.114.3 ([#627](https://www.github.com/googleapis/java-securitycenter/issues/627)) ([3cb5f4c](https://www.github.com/googleapis/java-securitycenter/commit/3cb5f4c1a3200ac5648ef8e3be01e50d998219bb))

## [2.1.0](https://www.github.com/googleapis/java-securitycenter/compare/v2.0.2...v2.1.0) (2021-09-01)


### Features

* generate java files for error_reason.proto, bigquery_audit_metadata.proto and localized_text.proto ([#616](https://www.github.com/googleapis/java-securitycenter/issues/616)) ([dacada4](https://www.github.com/googleapis/java-securitycenter/commit/dacada43de25debb7b44cc613f2e95f6b79eafa7))
* Remove use of deprecated gradle command in java README ([#1196](https://www.github.com/googleapis/java-securitycenter/issues/1196)) ([#618](https://www.github.com/googleapis/java-securitycenter/issues/618)) ([16f63df](https://www.github.com/googleapis/java-securitycenter/commit/16f63dfc93e36599d0c02eefad38d153c3b2315d))


### Dependencies

* update dependency com.google.cloud:google-cloud-pubsub to v1.114.1 ([#611](https://www.github.com/googleapis/java-securitycenter/issues/611)) ([8fc790b](https://www.github.com/googleapis/java-securitycenter/commit/8fc790b3ca2a6f0952c08d7578927fa7a8b51227))
* update dependency com.google.cloud:google-cloud-pubsub to v1.114.2 ([#622](https://www.github.com/googleapis/java-securitycenter/issues/622)) ([85cc9a2](https://www.github.com/googleapis/java-securitycenter/commit/85cc9a20f204319a443b549cf14ce100f1304662))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.2.0 ([#620](https://www.github.com/googleapis/java-securitycenter/issues/620)) ([3141953](https://www.github.com/googleapis/java-securitycenter/commit/31419536b9718a86849a2ba7578b6487ae437bd9))

### [2.0.2](https://www.github.com/googleapis/java-securitycenter/compare/v2.0.1...v2.0.2) (2021-08-23)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.1.0 ([#608](https://www.github.com/googleapis/java-securitycenter/issues/608)) ([11c85ca](https://www.github.com/googleapis/java-securitycenter/commit/11c85ca746be5e9880b8149e1bea3a70f01f89b5))

### [2.0.1](https://www.github.com/googleapis/java-securitycenter/compare/v2.0.0...v2.0.1) (2021-08-12)


### Dependencies

* update dependency com.google.cloud:google-cloud-pubsub to v1.113.7 ([#597](https://www.github.com/googleapis/java-securitycenter/issues/597)) ([77ece06](https://www.github.com/googleapis/java-securitycenter/commit/77ece060e3bfc2d3728fb076420cc94f14654ce2))
* update dependency com.google.cloud:google-cloud-pubsub to v1.114.0 ([#600](https://www.github.com/googleapis/java-securitycenter/issues/600)) ([2b89260](https://www.github.com/googleapis/java-securitycenter/commit/2b8926093e33fdc5180e688ae5ab63a0d136529d))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.0.1 ([#598](https://www.github.com/googleapis/java-securitycenter/issues/598)) ([3f52233](https://www.github.com/googleapis/java-securitycenter/commit/3f52233b1f5e458ad329436abc8c9e926fbf0aec))

## [2.0.0](https://www.github.com/googleapis/java-securitycenter/compare/v1.6.4...v2.0.0) (2021-08-10)


### ⚠ BREAKING CHANGES

* release gapic-generator-java v2.0.0 (#589)

### Features

* add finding_class and indicator fields in Finding ([#579](https://www.github.com/googleapis/java-securitycenter/issues/579)) ([6747a44](https://www.github.com/googleapis/java-securitycenter/commit/6747a44e5cbcc1ed1307b7b53d0553c6efcfcc1c))
* release gapic-generator-java v2.0.0 ([#589](https://www.github.com/googleapis/java-securitycenter/issues/589)) ([38c3102](https://www.github.com/googleapis/java-securitycenter/commit/38c3102f2609375192445e9984afc15b0a51f0fa))


### Bug Fixes

* Add shopt -s nullglob to dependencies script ([#556](https://www.github.com/googleapis/java-securitycenter/issues/556)) ([8014dd0](https://www.github.com/googleapis/java-securitycenter/commit/8014dd073e9d8ecc3cb589b9f4f3e8e740af7ae0))


### Dependencies

* update dependency com.google.cloud:google-cloud-pubsub to v1.113.6 ([#593](https://www.github.com/googleapis/java-securitycenter/issues/593)) ([849cb1c](https://www.github.com/googleapis/java-securitycenter/commit/849cb1c1718e492175aad707b879b394496b566c))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2 ([#590](https://www.github.com/googleapis/java-securitycenter/issues/590)) ([facfaae](https://www.github.com/googleapis/java-securitycenter/commit/facfaaefe07e00ca19513fc12a0817c31a74acad))

### [1.6.4](https://www.github.com/googleapis/java-securitycenter/compare/v1.6.3...v1.6.4) (2021-07-06)


### Dependencies

* update dependency com.google.cloud:google-cloud-pubsub to v1.113.4 ([#548](https://www.github.com/googleapis/java-securitycenter/issues/548)) ([7ec9cbe](https://www.github.com/googleapis/java-securitycenter/commit/7ec9cbe9d5917e4cbdad41a65772a07e658b8276))
* update dependency com.google.cloud:google-cloud-pubsub to v1.113.5 ([#557](https://www.github.com/googleapis/java-securitycenter/issues/557)) ([7393f8e](https://www.github.com/googleapis/java-securitycenter/commit/7393f8e52e382aca3616967b819118dd124067b5))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.4.0 ([#551](https://www.github.com/googleapis/java-securitycenter/issues/551)) ([60886b9](https://www.github.com/googleapis/java-securitycenter/commit/60886b91938218f3a2ddd29a7082953c2ca483e3))
* update dependency com.google.protobuf:protobuf-java-util to v3.17.3 ([#536](https://www.github.com/googleapis/java-securitycenter/issues/536)) ([4ec2592](https://www.github.com/googleapis/java-securitycenter/commit/4ec2592edd8cbb7430dd3005e5366b404ef219da))

### [1.6.3](https://www.github.com/googleapis/java-securitycenter/compare/v1.6.2...v1.6.3) (2021-06-15)


### Bug Fixes

* Update dependencies.sh to not break on mac ([#541](https://www.github.com/googleapis/java-securitycenter/issues/541)) ([87a8fef](https://www.github.com/googleapis/java-securitycenter/commit/87a8fefdd6145fd223bedcc12df98dfdb206bcf6))


### Documentation

* remove unused region tags ([#407](https://www.github.com/googleapis/java-securitycenter/issues/407)) ([ce983f3](https://www.github.com/googleapis/java-securitycenter/commit/ce983f33d2492e8db6eca1cb1f357f40f6ceeac7))
* update currently supported Finding filter fields ([#537](https://www.github.com/googleapis/java-securitycenter/issues/537)) ([75eb8a6](https://www.github.com/googleapis/java-securitycenter/commit/75eb8a6e4e68a348e06ed42483a6674367bf6edb))


### Dependencies

* update dependency com.google.cloud:google-cloud-pubsub to v1.113.3 ([#535](https://www.github.com/googleapis/java-securitycenter/issues/535)) ([2cc66ba](https://www.github.com/googleapis/java-securitycenter/commit/2cc66ba13197f0ef95cdad6555c3d46086dab2b5))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.3.0 ([#530](https://www.github.com/googleapis/java-securitycenter/issues/530)) ([eb3a2f0](https://www.github.com/googleapis/java-securitycenter/commit/eb3a2f09798b63819ed4e244f6f4b93f5fcc3254))

### [1.6.2](https://www.github.com/googleapis/java-securitycenter/compare/v1.6.1...v1.6.2) (2021-06-03)


### Dependencies

* update dependency com.google.protobuf:protobuf-java-util to v3.17.2 ([#523](https://www.github.com/googleapis/java-securitycenter/issues/523)) ([54389df](https://www.github.com/googleapis/java-securitycenter/commit/54389dfbf12fa58423e75d00781cbf706aa939bd))

### [1.6.1](https://www.github.com/googleapis/java-securitycenter/compare/v1.6.0...v1.6.1) (2021-06-02)


### Dependencies

* update dependency com.google.cloud:google-cloud-pubsub to v1.113.0 ([#517](https://www.github.com/googleapis/java-securitycenter/issues/517)) ([220d00c](https://www.github.com/googleapis/java-securitycenter/commit/220d00c43e52b47784586d6408bcf2f369b6ef91))

## [1.6.0](https://www.github.com/googleapis/java-securitycenter/compare/v1.5.1...v1.6.0) (2021-05-31)


### Features

* add gcf-owl-bot[bot] to ignoreAuthors ([#513](https://www.github.com/googleapis/java-securitycenter/issues/513)) ([a2b3195](https://www.github.com/googleapis/java-securitycenter/commit/a2b3195808bbddcb947474743fe3d8c5092e649b))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.2.0 ([#503](https://www.github.com/googleapis/java-securitycenter/issues/503)) ([1d1ab0e](https://www.github.com/googleapis/java-securitycenter/commit/1d1ab0e3a86d9dfb2d76f192670e45cc7c0350b1))
* update dependency com.google.protobuf:protobuf-java-util to v3.17.1 ([#506](https://www.github.com/googleapis/java-securitycenter/issues/506)) ([ce6370e](https://www.github.com/googleapis/java-securitycenter/commit/ce6370ee42591800719428d8f602600b12cd2d10))

### [1.5.1](https://www.github.com/googleapis/java-securitycenter/compare/v1.5.0...v1.5.1) (2021-05-14)


### Dependencies

* update dependency com.google.cloud:google-cloud-pubsub to v1.112.5 ([#493](https://www.github.com/googleapis/java-securitycenter/issues/493)) ([d3f2b21](https://www.github.com/googleapis/java-securitycenter/commit/d3f2b214a4852158bb21373c7c869bc5711aea84))

## [1.5.0](https://www.github.com/googleapis/java-securitycenter/compare/v1.4.2...v1.5.0) (2021-05-14)


### Features

* add canonical_name and folder fields  ([#489](https://www.github.com/googleapis/java-securitycenter/issues/489)) ([75015df](https://www.github.com/googleapis/java-securitycenter/commit/75015df270e1ee837c2bd76c458da460d90b4ee0))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.1.0 ([#486](https://www.github.com/googleapis/java-securitycenter/issues/486)) ([31f05a4](https://www.github.com/googleapis/java-securitycenter/commit/31f05a410ef5c9bb3ab165429755d2e3da3ba53a))
* update dependency com.google.protobuf:protobuf-java-util to v3.17.0 ([#480](https://www.github.com/googleapis/java-securitycenter/issues/480)) ([54124d2](https://www.github.com/googleapis/java-securitycenter/commit/54124d2f8f610013d567c3fe6d47c844cae6e049))

### [1.4.2](https://www.github.com/googleapis/java-securitycenter/compare/v1.4.1...v1.4.2) (2021-04-24)


### Bug Fixes

* release scripts from issuing overlapping phases ([#448](https://www.github.com/googleapis/java-securitycenter/issues/448)) ([6516758](https://www.github.com/googleapis/java-securitycenter/commit/65167588563e151adea23c5fe52e56332989aeed))
* typo ([#444](https://www.github.com/googleapis/java-securitycenter/issues/444)) ([8cf20d4](https://www.github.com/googleapis/java-securitycenter/commit/8cf20d454bf1f0b04a6c4f46cddba2b9603ea74f))


### Dependencies

* update dependency com.google.cloud:google-cloud-pubsub to v1.112.1 ([#443](https://www.github.com/googleapis/java-securitycenter/issues/443)) ([2176794](https://www.github.com/googleapis/java-securitycenter/commit/21767947e7461e60b179ee1a516a08c88d37de70))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.21.1 ([#451](https://www.github.com/googleapis/java-securitycenter/issues/451)) ([636161d](https://www.github.com/googleapis/java-securitycenter/commit/636161d01594cb077c2151e3c791afb6c069b1f9))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1 ([#468](https://www.github.com/googleapis/java-securitycenter/issues/468)) ([81f841b](https://www.github.com/googleapis/java-securitycenter/commit/81f841becb6a5d270155df076f66ec04e32b060f))

### [1.4.1](https://www.github.com/googleapis/java-securitycenter/compare/v1.4.0...v1.4.1) (2021-04-12)


### Dependencies

* update dependency com.google.cloud:google-cloud-pubsub to v1.112.0 ([#423](https://www.github.com/googleapis/java-securitycenter/issues/423)) ([dc5c47a](https://www.github.com/googleapis/java-securitycenter/commit/dc5c47aef8525ca009a3dd5d7e06a1868f7049cb))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.21.0 ([#436](https://www.github.com/googleapis/java-securitycenter/issues/436)) ([9af7c29](https://www.github.com/googleapis/java-securitycenter/commit/9af7c292d565a4c579317f1e06db4e47b614b3de))
* update dependency com.google.protobuf:protobuf-java-util to v3.15.8 ([#402](https://www.github.com/googleapis/java-securitycenter/issues/402)) ([d0480e2](https://www.github.com/googleapis/java-securitycenter/commit/d0480e2644baa0419ddeb3404591dde28e92fb9c))

## [1.4.0](https://www.github.com/googleapis/java-securitycenter/compare/v1.3.8...v1.4.0) (2021-03-11)


### Features

* **generator:** update protoc to v3.15.3 ([#406](https://www.github.com/googleapis/java-securitycenter/issues/406)) ([f0da610](https://www.github.com/googleapis/java-securitycenter/commit/f0da61032a9bb91f20f6fb6f5594e89f2f39e646))


### Dependencies

* update dependency com.google.cloud:google-cloud-pubsub to v1.111.3 ([#401](https://www.github.com/googleapis/java-securitycenter/issues/401)) ([d292fe4](https://www.github.com/googleapis/java-securitycenter/commit/d292fe47b30d1595cc587f18ae41968c3dd9c5ab))
* update dependency com.google.cloud:google-cloud-pubsub to v1.111.4 ([#405](https://www.github.com/googleapis/java-securitycenter/issues/405)) ([5725930](https://www.github.com/googleapis/java-securitycenter/commit/57259303c5d3646e513351ac8344d2d866ab3f28))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.20.1 ([#417](https://www.github.com/googleapis/java-securitycenter/issues/417)) ([cdb6263](https://www.github.com/googleapis/java-securitycenter/commit/cdb626306bbb62b4e54718b7fc644e25c2efe8ca))

### [1.3.8](https://www.github.com/googleapis/java-securitycenter/compare/v1.3.7...v1.3.8) (2021-02-25)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.20.0 ([#397](https://www.github.com/googleapis/java-securitycenter/issues/397)) ([9fa150d](https://www.github.com/googleapis/java-securitycenter/commit/9fa150d1d7901a681d5a2174e68334b80b941c6c))

### [1.3.7](https://www.github.com/googleapis/java-securitycenter/compare/v1.3.6...v1.3.7) (2021-02-22)


### Bug Fixes

* deprecate files in v1beta1 that will be removed in next release ([#355](https://www.github.com/googleapis/java-securitycenter/issues/355)) ([aa91762](https://www.github.com/googleapis/java-securitycenter/commit/aa91762ced3587472ab00094105b2d0372fc508f))


### Documentation

* generate sample code in the Java microgenerator ([#371](https://www.github.com/googleapis/java-securitycenter/issues/371)) ([a81156a](https://www.github.com/googleapis/java-securitycenter/commit/a81156ad157694b6a206b65da5c6e9d15528219f))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.19.0 ([#382](https://www.github.com/googleapis/java-securitycenter/issues/382)) ([1d0e168](https://www.github.com/googleapis/java-securitycenter/commit/1d0e168521f2cd81f908be1b2e1eab9b3bf85ed1))

### [1.3.6](https://www.github.com/googleapis/java-securitycenter/compare/v1.3.5...v1.3.6) (2021-02-05)


### Bug Fixes

* update repo name ([#368](https://www.github.com/googleapis/java-securitycenter/issues/368)) ([bde7a99](https://www.github.com/googleapis/java-securitycenter/commit/bde7a996396ce82833e0a380b7aec06e065617ea))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.18.0 ([#349](https://www.github.com/googleapis/java-securitycenter/issues/349)) ([6e6583f](https://www.github.com/googleapis/java-securitycenter/commit/6e6583f7a5788ba082257fe82b006988de3ec37b))

### [1.3.5](https://www.github.com/googleapis/java-securitycenter/compare/v1.3.4...v1.3.5) (2020-12-16)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.17.0 ([#335](https://www.github.com/googleapis/java-securitycenter/issues/335)) ([27365c7](https://www.github.com/googleapis/java-securitycenter/commit/27365c713b3376ac66e16196decca679894f25ec))

### [1.3.4](https://www.github.com/googleapis/java-securitycenter/compare/v1.3.3...v1.3.4) (2020-12-14)


### Documentation

* Wrap samples with future prefix ([#325](https://www.github.com/googleapis/java-securitycenter/issues/325)) ([3239d29](https://www.github.com/googleapis/java-securitycenter/commit/3239d29654eb7e09fb7a5a6393cbb57aa7a9a58f))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.16.1 ([#330](https://www.github.com/googleapis/java-securitycenter/issues/330)) ([5a253a6](https://www.github.com/googleapis/java-securitycenter/commit/5a253a60210cb28102e178ee16d543b77566caff))

### [1.3.3](https://www.github.com/googleapis/java-securitycenter/compare/v1.3.2...v1.3.3) (2020-12-02)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.16.0 ([#317](https://www.github.com/googleapis/java-securitycenter/issues/317)) ([5749635](https://www.github.com/googleapis/java-securitycenter/commit/574963527d22387443bcb3f38f968a88f3e26941))

### [1.3.2](https://www.github.com/googleapis/java-securitycenter/compare/v1.3.1...v1.3.2) (2020-11-12)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.15.0 ([#301](https://www.github.com/googleapis/java-securitycenter/issues/301)) ([49c6f7d](https://www.github.com/googleapis/java-securitycenter/commit/49c6f7d6f3e90477990c6ab6119e1d8ddb435c59))

### [1.3.1](https://www.github.com/googleapis/java-securitycenter/compare/v1.3.0...v1.3.1) (2020-11-02)


### Documentation

* updated description of finding severity field ([#237](https://www.github.com/googleapis/java-securitycenter/issues/237)) ([574b243](https://www.github.com/googleapis/java-securitycenter/commit/574b2435657b828e5e5264f9900fe1c201d7b357))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.10.0 ([#248](https://www.github.com/googleapis/java-securitycenter/issues/248)) ([7c232b6](https://www.github.com/googleapis/java-securitycenter/commit/7c232b6a8c51f3e30d705ac7a39900d583a18c7e))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.10.2 ([#260](https://www.github.com/googleapis/java-securitycenter/issues/260)) ([c4e6e4f](https://www.github.com/googleapis/java-securitycenter/commit/c4e6e4fae440b9d0e2979ffe20b6076889938523))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.12.1 ([#273](https://www.github.com/googleapis/java-securitycenter/issues/273)) ([edde418](https://www.github.com/googleapis/java-securitycenter/commit/edde418137829b57dc55d65c3ca8603a20963926))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.13.0 ([#276](https://www.github.com/googleapis/java-securitycenter/issues/276)) ([ddde42a](https://www.github.com/googleapis/java-securitycenter/commit/ddde42ab266c3a2bafc843b020f335a8953b1fcb))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.14.1 ([#291](https://www.github.com/googleapis/java-securitycenter/issues/291)) ([25e09ce](https://www.github.com/googleapis/java-securitycenter/commit/25e09cecbde01db980057fa07cba19b0026700f0))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.9.0 ([#232](https://www.github.com/googleapis/java-securitycenter/issues/232)) ([a53c6dd](https://www.github.com/googleapis/java-securitycenter/commit/a53c6dde0610941a463c2a631e8e6c04dfdf8581))

## [1.3.0](https://www.github.com/googleapis/java-securitycenter/compare/v1.2.0...v1.3.0) (2020-08-19)


### Features

* added field severity to findings ([#216](https://www.github.com/googleapis/java-securitycenter/issues/216)) ([03213c8](https://www.github.com/googleapis/java-securitycenter/commit/03213c8db94335cb0c7db325b02757103e1c4fdd))


### Documentation

* clarified that event_time can also be considered as the "update time" for a Finding ([#224](https://www.github.com/googleapis/java-securitycenter/issues/224)) ([a3721cb](https://www.github.com/googleapis/java-securitycenter/commit/a3721cbf9d204597938c4887b432f568676b44f0))

## [1.2.0](https://www.github.com/googleapis/java-securitycenter/compare/v1.1.0...v1.2.0) (2020-08-10)


### Features

* **v1beta1:** migrate to gapic v2 - SourceName -> ResourceName ([#203](https://www.github.com/googleapis/java-securitycenter/issues/203)) ([4a88b5a](https://www.github.com/googleapis/java-securitycenter/commit/4a88b5a1b415b60e87fd0c9c8e1725cd61176479))


### Bug Fixes

* migrate to grpc_service_config ([#200](https://www.github.com/googleapis/java-securitycenter/issues/200)) ([7813a66](https://www.github.com/googleapis/java-securitycenter/commit/7813a6696e4cca71f53f6042c062ec19b2f63780))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.2 ([#194](https://www.github.com/googleapis/java-securitycenter/issues/194)) ([b17809b](https://www.github.com/googleapis/java-securitycenter/commit/b17809bf2d595af90782dda81dc7bc90a8a61a24))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.3 ([#198](https://www.github.com/googleapis/java-securitycenter/issues/198)) ([04158c2](https://www.github.com/googleapis/java-securitycenter/commit/04158c218955efcd85b1009cae71ac94884f85cb))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.6 ([#208](https://www.github.com/googleapis/java-securitycenter/issues/208)) ([9cf4964](https://www.github.com/googleapis/java-securitycenter/commit/9cf4964cb09196694b21705abf0c794e45dc587d))

## [1.1.0](https://www.github.com/googleapis/java-securitycenter/compare/v1.0.0...v1.1.0) (2020-06-22)


### Features

* **deps:** adopt flatten plugin and google-cloud-shared-dependencies ([#181](https://www.github.com/googleapis/java-securitycenter/issues/181)) ([f11d67b](https://www.github.com/googleapis/java-securitycenter/commit/f11d67bc730214d3170929e4e8872ea23ab8099f))


### Documentation

* specify allowed fields for UpdateNotificationConfig ([#174](https://www.github.com/googleapis/java-securitycenter/issues/174)) ([2bdf201](https://www.github.com/googleapis/java-securitycenter/commit/2bdf20193d74f4d33e7519f12afe027cc23e4647))

## [1.0.0](https://www.github.com/googleapis/java-securitycenter/compare/v0.122.0...v1.0.0) (2020-06-12)


### Features

* promote to GA ([#166](https://www.github.com/googleapis/java-securitycenter/issues/166)) ([8ce6f89](https://www.github.com/googleapis/java-securitycenter/commit/8ce6f892400cb4a4fdc5d7f9fcd2b8b7c3a157aa))


### Dependencies

* update core dependencies to v1.57.0 ([#169](https://www.github.com/googleapis/java-securitycenter/issues/169)) ([2ea4381](https://www.github.com/googleapis/java-securitycenter/commit/2ea4381b98c5b49bd6f634294c811e2ba670dee3))

## [0.122.0](https://www.github.com/googleapis/java-securitycenter/compare/v0.121.0...v0.122.0) (2020-06-11)


### ⚠ BREAKING CHANGES

* **v1p1beta1:** Removed 'having' as a field in the List and Group Finding and Asset requests.
* remove legacy resource name (#125)

### Features

* remove legacy resource name ([#125](https://www.github.com/googleapis/java-securitycenter/issues/125)) ([d5f88f6](https://www.github.com/googleapis/java-securitycenter/commit/d5f88f6c8c0b182170c405ccaa8f6159fecb4a86))
* **v1p1beta1:** add `resource` to NotificationMessage, remove `having` from list requests ([#161](https://www.github.com/googleapis/java-securitycenter/issues/161)) ([e9c6709](https://www.github.com/googleapis/java-securitycenter/commit/e9c670944e25e6cf24394bdd8dbee7a94ae40846))


### Dependencies

* update dependency com.google.api:api-common to v1.9.1 ([#146](https://www.github.com/googleapis/java-securitycenter/issues/146)) ([ffba078](https://www.github.com/googleapis/java-securitycenter/commit/ffba078dd1da6ad9f78e5c4425f212892eac081f))
* update dependency com.google.api:api-common to v1.9.2 ([#153](https://www.github.com/googleapis/java-securitycenter/issues/153)) ([cfb9e30](https://www.github.com/googleapis/java-securitycenter/commit/cfb9e30815ae07d472e327f30f8a069961a2a813))
* update dependency com.google.api.grpc:proto-google-common-protos to v1.18.0 ([#135](https://www.github.com/googleapis/java-securitycenter/issues/135)) ([760ebf4](https://www.github.com/googleapis/java-securitycenter/commit/760ebf4cf4bd26b10451113bd7141f8303cf238f))
* update dependency com.google.guava:guava-bom to v29 ([#109](https://www.github.com/googleapis/java-securitycenter/issues/109)) ([00a1471](https://www.github.com/googleapis/java-securitycenter/commit/00a1471f0b32e08b9a0bd6fd9c3ff86a510c8d97))
* update dependency com.google.protobuf:protobuf-java to v3.12.0 ([#139](https://www.github.com/googleapis/java-securitycenter/issues/139)) ([213bb0e](https://www.github.com/googleapis/java-securitycenter/commit/213bb0e685eaf36b7ad730425a89e37098dc3f63))
* update dependency com.google.protobuf:protobuf-java to v3.12.2 ([#144](https://www.github.com/googleapis/java-securitycenter/issues/144)) ([455344f](https://www.github.com/googleapis/java-securitycenter/commit/455344f8ac059d845cf481e59007d43e8b06bfa3))
* update dependency io.grpc:grpc-bom to v1.29.0 ([#124](https://www.github.com/googleapis/java-securitycenter/issues/124)) ([24fee0e](https://www.github.com/googleapis/java-securitycenter/commit/24fee0eef8d80ba3eb6999a315a18cbb458bdf53))
* update dependency io.grpc:grpc-bom to v1.30.0 ([#157](https://www.github.com/googleapis/java-securitycenter/issues/157)) ([b97deb9](https://www.github.com/googleapis/java-securitycenter/commit/b97deb90aad2cf0e71480aa91dbe760cd1c5cf70))
* update dependency org.threeten:threetenbp to v1.4.4 ([#129](https://www.github.com/googleapis/java-securitycenter/issues/129)) ([5d62223](https://www.github.com/googleapis/java-securitycenter/commit/5d62223fc6c56a04aee99a8239914c650b4e3c9a))

## [0.121.0](https://www.github.com/googleapis/java-securitycenter/compare/v0.120.0...v0.121.0) (2020-04-09)


### ⚠ BREAKING CHANGES

* convert resource names to multipattern resource names (#99)

### Features

* convert resource names to multipattern resource names ([#99](https://www.github.com/googleapis/java-securitycenter/issues/99)) ([04de9cc](https://www.github.com/googleapis/java-securitycenter/commit/04de9cc1b6539b189729707ba527efe5653e0fe3)), closes [#95](https://www.github.com/googleapis/java-securitycenter/issues/95) [#95](https://www.github.com/googleapis/java-securitycenter/issues/95) [#98](https://www.github.com/googleapis/java-securitycenter/issues/98) [#98](https://www.github.com/googleapis/java-securitycenter/issues/98) [#8203](https://www.github.com/googleapis/java-securitycenter/issues/8203) [#8203](https://www.github.com/googleapis/java-securitycenter/issues/8203) [#8203](https://www.github.com/googleapis/java-securitycenter/issues/8203) [#79](https://www.github.com/googleapis/java-securitycenter/issues/79) [#79](https://www.github.com/googleapis/java-securitycenter/issues/79)


### Dependencies

* update core dependencies ([#79](https://www.github.com/googleapis/java-securitycenter/issues/79)) ([85b7dda](https://www.github.com/googleapis/java-securitycenter/commit/85b7dda6e29d5b8e761198858a0523535283f9aa))
* update dependency com.google.api:api-common to v1.9.0 ([#98](https://www.github.com/googleapis/java-securitycenter/issues/98)) ([08ea9c7](https://www.github.com/googleapis/java-securitycenter/commit/08ea9c703b2e4ea1e8e8d59fbdc70ca6cc2d8bf2))
* update dependency org.threeten:threetenbp to v1.4.3 ([#92](https://www.github.com/googleapis/java-securitycenter/issues/92)) ([a44f985](https://www.github.com/googleapis/java-securitycenter/commit/a44f985b089604ff4f6d6fcbe363f2a38a75fc73))

## [0.120.0](https://www.github.com/googleapis/java-securitycenter/compare/v0.119.0...v0.120.0) (2020-03-10)


### ⚠ BREAKING CHANGES

* update the Iam methods to use ResourceName (#74)

### Features

* update the Iam methods to use ResourceName ([#74](https://www.github.com/googleapis/java-securitycenter/issues/74)) ([cc5c709](https://www.github.com/googleapis/java-securitycenter/commit/cc5c709eb35228fe8093b611ef8ede4f2bf76f7c))
* **v1:** add Notifications API ([#78](https://www.github.com/googleapis/java-securitycenter/issues/78)) ([7909b8e](https://www.github.com/googleapis/java-securitycenter/commit/7909b8e59bbfcdf96512034298e9315e9603d2cd))


### Dependencies

* update core dependencies to v1.54.0 ([#76](https://www.github.com/googleapis/java-securitycenter/issues/76)) ([a0fdb5c](https://www.github.com/googleapis/java-securitycenter/commit/a0fdb5c96c17ceea535cf935b2e8d26052936a02))
* update dependency com.google.protobuf:protobuf-java to v3.11.4 ([ad734b5](https://www.github.com/googleapis/java-securitycenter/commit/ad734b57d316e70f338069912ca1bc3599935f24))
* update dependency io.grpc:grpc-bom to v1.27.1 ([6a6d921](https://www.github.com/googleapis/java-securitycenter/commit/6a6d9214f86d63058360d55cf511cd29c398d77b))
* update dependency io.grpc:grpc-bom to v1.27.2 ([#75](https://www.github.com/googleapis/java-securitycenter/issues/75)) ([29bdbae](https://www.github.com/googleapis/java-securitycenter/commit/29bdbae5c7c7227a3364f2239dcc52d48c7b8e50))

## [0.119.0](https://www.github.com/googleapis/java-securitycenter/compare/v0.118.1...v0.119.0) (2020-02-12)


### Features

* add v1p1beta1 client ([#59](https://www.github.com/googleapis/java-securitycenter/issues/59)) ([66f66b6](https://www.github.com/googleapis/java-securitycenter/commit/66f66b632a917e3a6e68be9bfd5eead50265eb89))


### Documentation

* **regen:** update sample code to set total timeout, add API client header test ([36e7eee](https://www.github.com/googleapis/java-securitycenter/commit/36e7eee5c3d886c02cef9b07c852012ea88bf3f8))

### [0.118.1](https://www.github.com/googleapis/java-securitycenter/compare/v0.118.0...v0.118.1) (2020-02-04)


### Dependencies

* update core dependencies to v1.53.0 ([#42](https://www.github.com/googleapis/java-securitycenter/issues/42)) ([56e659a](https://www.github.com/googleapis/java-securitycenter/commit/56e659a46e51e20c44f44e41b8f38797edc2c346))
* update core dependencies to v1.53.1 ([#51](https://www.github.com/googleapis/java-securitycenter/issues/51)) ([d18ed6e](https://www.github.com/googleapis/java-securitycenter/commit/d18ed6e85742d93ec60c2ba18a8935d8a4465bc7))
* update dependency com.google.guava:guava-bom to v28.2-android ([#32](https://www.github.com/googleapis/java-securitycenter/issues/32)) ([8a56a06](https://www.github.com/googleapis/java-securitycenter/commit/8a56a06158a55f97f60094f140d0d2d82683bb06))
* update dependency com.google.protobuf:protobuf-java to v3.11.3 ([#53](https://www.github.com/googleapis/java-securitycenter/issues/53)) ([99055ee](https://www.github.com/googleapis/java-securitycenter/commit/99055ee6b7b02b7a1106cfedc8a4911bb857ff2c))
* update dependency io.grpc:grpc-bom to v1.27.0 ([#49](https://www.github.com/googleapis/java-securitycenter/issues/49)) ([ed85e84](https://www.github.com/googleapis/java-securitycenter/commit/ed85e8413f9154efb776455b5bf4636b16bd32c0))
* update dependency org.threeten:threetenbp to v1.4.1 ([#43](https://www.github.com/googleapis/java-securitycenter/issues/43)) ([9f9eca9](https://www.github.com/googleapis/java-securitycenter/commit/9f9eca9df1e8fbb058d502a1fa92019f2abb2a2d))

## [0.118.0](https://www.github.com/googleapis/java-securitycenter/compare/v0.117.0...v0.118.0) (2020-01-07)


### Features

* add Resource to ListFindingsResult ([#27](https://www.github.com/googleapis/java-securitycenter/issues/27)) ([66d9b4a](https://www.github.com/googleapis/java-securitycenter/commit/66d9b4a8a3dabbaf72c2180995ef9ffe4da37aba))


### Dependencies

* update dependency com.google.protobuf:protobuf-java to v3.11.1 ([e371031](https://www.github.com/googleapis/java-securitycenter/commit/e3710312812e8e157462eab859b6a3738c226537))
* update dependency io.grpc:grpc-bom to v1.26.0 ([#26](https://www.github.com/googleapis/java-securitycenter/issues/26)) ([0a961e4](https://www.github.com/googleapis/java-securitycenter/commit/0a961e4f4862e705595445b028184b594477d398))
* update gax.version to v1.52.0 ([#20](https://www.github.com/googleapis/java-securitycenter/issues/20)) ([3368530](https://www.github.com/googleapis/java-securitycenter/commit/336853087782ff5cd8baa150858a898ff10c5f41))


### Documentation

* **regen:** update generated javadoc ([#21](https://www.github.com/googleapis/java-securitycenter/issues/21)) ([e9297db](https://www.github.com/googleapis/java-securitycenter/commit/e9297dbb5995e13b4eecd39daa545329a0da1407))

## [0.117.0](https://www.github.com/googleapis/java-securitycenter/compare/0.116.0...v0.117.0) (2019-11-13)


### Features

* make repo releasable, add parent/bom ([#1](https://www.github.com/googleapis/java-securitycenter/issues/1)) ([ffc733c](https://www.github.com/googleapis/java-securitycenter/commit/ffc733ce4a8229a37f3941060e824794d1357641))


### Dependencies

* update dependency io.grpc:grpc-bom to v1.24.1 ([#3](https://www.github.com/googleapis/java-securitycenter/issues/3)) ([d640385](https://www.github.com/googleapis/java-securitycenter/commit/d640385b81b269bbc892d35662d91bec27ff2681))
* update gax.version to v1.49.1 ([#5](https://www.github.com/googleapis/java-securitycenter/issues/5)) ([935dcad](https://www.github.com/googleapis/java-securitycenter/commit/935dcad9ac4ba48ef542f755cc0b4cad47dcad96))
