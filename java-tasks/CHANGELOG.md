# Changelog

### [1.29.1](https://www.github.com/googleapis/java-tasks/compare/v1.29.0...v1.29.1) (2020-04-07)


### Dependencies

* update core dependencies ([#85](https://www.github.com/googleapis/java-tasks/issues/85)) ([1e11179](https://www.github.com/googleapis/java-tasks/commit/1e1117928283eae2cea43f4c790d4746428b06a1))
* update dependency com.google.cloud:google-cloud-core to v1.93.4 ([#112](https://www.github.com/googleapis/java-tasks/issues/112)) ([fc45f81](https://www.github.com/googleapis/java-tasks/commit/fc45f81f40df4ab5f92d2bd35804b7161becad55))
* update dependency org.threeten:threetenbp to v1.4.3 ([#94](https://www.github.com/googleapis/java-tasks/issues/94)) ([5015798](https://www.github.com/googleapis/java-tasks/commit/5015798f9ef98aa6f698fd600ed2911a490283d3))

## [1.29.0](https://www.github.com/googleapis/java-tasks/compare/v1.28.2...v1.29.0) (2020-03-30)


### Features

* **regen:** add StackdriverLoggingConfig to Queue ([1ffe5bc](https://www.github.com/googleapis/java-tasks/commit/1ffe5bc2086312272b79ec451feaeeb01f163626)), closes [#71](https://www.github.com/googleapis/java-tasks/issues/71)


### Dependencies

* update core dependencies ([#71](https://www.github.com/googleapis/java-tasks/issues/71)) ([a578f22](https://www.github.com/googleapis/java-tasks/commit/a578f229f93560329f96aea6e2446d5278a6cd5f))
* update core dependencies ([#84](https://www.github.com/googleapis/java-tasks/issues/84)) ([b672c21](https://www.github.com/googleapis/java-tasks/commit/b672c21a89fb69da73fc80bf41355f926061afde))
* update dependency com.google.api:api-common to v1.9.0 ([#103](https://www.github.com/googleapis/java-tasks/issues/103)) ([f330679](https://www.github.com/googleapis/java-tasks/commit/f330679ebff1a1cf2bd0ed5dcbd91ef1efe54f2d))
* update dependency com.google.protobuf:protobuf-java to v3.11.4 ([83c7274](https://www.github.com/googleapis/java-tasks/commit/83c7274c220a83ad1c66aa9affa42f32d62b3450))


### Documentation

* **regen:** update sample code to set total timeout, add API client header test ([#70](https://www.github.com/googleapis/java-tasks/issues/70)) ([ea4926d](https://www.github.com/googleapis/java-tasks/commit/ea4926d7c9930cc0e19d084b8645711da8987963))

### [1.28.2](https://www.github.com/googleapis/java-tasks/compare/v1.28.1...v1.28.2) (2020-02-06)


### Bug Fixes

* getIamSettings, testIamSettings, deleteTaskSettings marked as idempotent for retries ([#66](https://www.github.com/googleapis/java-tasks/issues/66)) ([8029bdd](https://www.github.com/googleapis/java-tasks/commit/8029bdd723483c79ff72c7786ba4a7b319e9b447))

### [1.28.1](https://www.github.com/googleapis/java-tasks/compare/v1.28.0...v1.28.1) (2020-02-04)


### Bug Fixes

* **regen:** deleteQueue marked as idempotent for retry settings ([#49](https://www.github.com/googleapis/java-tasks/issues/49)) ([58af13c](https://www.github.com/googleapis/java-tasks/commit/58af13c1c7b236127f9b6b9515eb7aa75945971b))
* **regen:** deleteQueue marked as idempotent for retry settings ([#51](https://www.github.com/googleapis/java-tasks/issues/51)) ([2782770](https://www.github.com/googleapis/java-tasks/commit/2782770088bee28f612cbfd1dd4a3b5782af90d9))


### Dependencies

* update core dependencies ([#41](https://www.github.com/googleapis/java-tasks/issues/41)) ([f7edec5](https://www.github.com/googleapis/java-tasks/commit/f7edec5193e0f192901f7f02f0b5554150d27c7a))
* update core dependencies ([#59](https://www.github.com/googleapis/java-tasks/issues/59)) ([23ae53f](https://www.github.com/googleapis/java-tasks/commit/23ae53fd64bee612d82a8d21abbd7fedd983b9d5))
* update dependency com.google.guava:guava-bom to v28.2-android ([#39](https://www.github.com/googleapis/java-tasks/issues/39)) ([af017bf](https://www.github.com/googleapis/java-tasks/commit/af017bfb8aec0a21401beeab4374e77de12e88c8))
* update dependency com.google.protobuf:protobuf-java to v3.11.3 ([#61](https://www.github.com/googleapis/java-tasks/issues/61)) ([cbb810a](https://www.github.com/googleapis/java-tasks/commit/cbb810aa4bea7ceb1ac2785704fd6809306a8157))
* update dependency org.threeten:threetenbp to v1.4.1 ([#52](https://www.github.com/googleapis/java-tasks/issues/52)) ([18267bd](https://www.github.com/googleapis/java-tasks/commit/18267bdf980f3bb0f5dd6275540ad4f4f8e6019e))

## [1.28.0](https://www.github.com/googleapis/java-tasks/compare/v1.27.0...v1.28.0) (2020-01-08)


### Features

* **regen:** adds ResourceName overloads for get/set/testIamPolicy methods ([#24](https://www.github.com/googleapis/java-tasks/issues/24)) ([0a8b3b5](https://www.github.com/googleapis/java-tasks/commit/0a8b3b5ef6f3a93454c59039201bfd54d27192eb))


### Dependencies

* update core dependencies ([#37](https://www.github.com/googleapis/java-tasks/issues/37)) ([57f9c1e](https://www.github.com/googleapis/java-tasks/commit/57f9c1ec08f7f83fac4205506d489c4e8cf5759c))
* update dependency com.google.protobuf:protobuf-java to v3.11.1 ([#25](https://www.github.com/googleapis/java-tasks/issues/25)) ([0e87fb5](https://www.github.com/googleapis/java-tasks/commit/0e87fb511de2b898cbdf2a25902081790771aa9d))
* update dependency io.grpc:grpc-bom to v1.26.0 ([#32](https://www.github.com/googleapis/java-tasks/issues/32)) ([b40f2f3](https://www.github.com/googleapis/java-tasks/commit/b40f2f3739e0cef165dec74260191ca548bf3696))
* update gax.version to v1.51.0 ([#26](https://www.github.com/googleapis/java-tasks/issues/26)) ([cb113e5](https://www.github.com/googleapis/java-tasks/commit/cb113e520ab99ebde9b74b66b2897aeb6a590881))

## [1.27.0](https://www.github.com/googleapis/java-tasks/compare/v1.26.0...v1.27.0) (2019-11-11)


### Features

* add HttpRequest tasks ([#14](https://www.github.com/googleapis/java-tasks/issues/14)) ([df89d67](https://www.github.com/googleapis/java-tasks/commit/df89d677e2a012ded5e41004ebd9b6a9f4b64b66))


### Dependencies

* update dependency io.grpc:grpc-bom to v1.25.0 ([#10](https://www.github.com/googleapis/java-tasks/issues/10)) ([0a65b44](https://www.github.com/googleapis/java-tasks/commit/0a65b44692ba157fdd7af53f7aa02ff8068522ba))
* update gax.version to v1.50.1 ([#13](https://www.github.com/googleapis/java-tasks/issues/13)) ([6a80a7a](https://www.github.com/googleapis/java-tasks/commit/6a80a7a0e12c864e4dca8d2bbfa6c75c35fedecc))

## [1.26.0](https://www.github.com/googleapis/java-tasks/compare/v0.90.0...v1.26.0) (2019-10-25)


### Features

* make repo releasable, add parent ([#1](https://www.github.com/googleapis/java-tasks/issues/1)) ([2a930d1](https://www.github.com/googleapis/java-tasks/commit/2a930d1a2692f6de97f36fdc5a8c734b76443777))
* move google cloud tasks ([956cc05](https://www.github.com/googleapis/java-tasks/commit/956cc0526863c80bb281ebc26251914d1146547f))


### Dependencies

* update dependency io.grpc:grpc-bom to v1.24.1 ([#4](https://www.github.com/googleapis/java-tasks/issues/4)) ([4234dca](https://www.github.com/googleapis/java-tasks/commit/4234dca96f7f98bda051772b701cfb3d8e7ff89f))
* update gax.version to v1.49.1 ([#5](https://www.github.com/googleapis/java-tasks/issues/5)) ([8dae3a9](https://www.github.com/googleapis/java-tasks/commit/8dae3a9d25f0753eca5697b6782e3d1769b688f3))
