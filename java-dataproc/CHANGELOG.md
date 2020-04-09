# Changelog

## [0.122.0](https://www.github.com/googleapis/java-dataproc/compare/v0.121.0...v0.122.0) (2020-04-09)


### Features

* **v1:** add Jobs.SubmitJobAsOperation, SparkR and Presto job types to WorkflowTemplates ([#137](https://www.github.com/googleapis/java-dataproc/issues/137)) ([ac18c87](https://www.github.com/googleapis/java-dataproc/commit/ac18c872f270d1a3248797ceceaf0923375bfc2f))


### Dependencies

* update core dependencies ([#91](https://www.github.com/googleapis/java-dataproc/issues/91)) ([2e8fce0](https://www.github.com/googleapis/java-dataproc/commit/2e8fce05b413f52efa7dc9b0c3d40e19d0d687ab))
* update dependency com.google.cloud:google-cloud-core to v1.93.4 ([#127](https://www.github.com/googleapis/java-dataproc/issues/127)) ([9dd5f1a](https://www.github.com/googleapis/java-dataproc/commit/9dd5f1a28cf735a611a570026e4762137ac4b9e0))
* update dependency org.threeten:threetenbp to v1.4.3 ([#111](https://www.github.com/googleapis/java-dataproc/issues/111)) ([3d7178b](https://www.github.com/googleapis/java-dataproc/commit/3d7178b323615d8ddde92b03349da2ec81aee809))

## [0.121.0](https://www.github.com/googleapis/java-dataproc/compare/v0.120.0...v0.121.0) (2020-04-01)


### ⚠ BREAKING CHANGES

* Please use AutoscalingPolicyName$Builder.setLocation(String)

### Bug Fixes

* AutoscalingPolicyName now uses locations instead of regions ([#118](https://www.github.com/googleapis/java-dataproc/issues/118)) ([48110e6](https://www.github.com/googleapis/java-dataproc/commit/48110e6a7c6426172b81b126001a609650a4f3bd))


### Dependencies

* update dependency com.google.api:api-common to v1.9.0 ([#113](https://www.github.com/googleapis/java-dataproc/issues/113)) ([34b0ec6](https://www.github.com/googleapis/java-dataproc/commit/34b0ec60c21d76217d45b29410c1472ff8869ba0))

## [0.120.0](https://www.github.com/googleapis/java-dataproc/compare/v0.119.0...v0.120.0) (2020-03-13)


### Features

* add LifecycleConfig, ReservationAffinity, SparkRJob, PrestoJob to v1 ([ce4bd91](https://www.github.com/googleapis/java-dataproc/commit/ce4bd9177439ff9431cec1f8e56ee2c07ab75870))


### Dependencies

* update core dependencies ([#89](https://www.github.com/googleapis/java-dataproc/issues/89)) ([0698b62](https://www.github.com/googleapis/java-dataproc/commit/0698b6262729cab28e9e95dc227669fc3f239b42))
* update dependency com.google.cloud:google-cloud-core to v1.92.5 ([574c5c5](https://www.github.com/googleapis/java-dataproc/commit/574c5c55978b3930ac083c941fba4df251959084))
* update dependency com.google.protobuf:protobuf-java to v3.11.4 ([86b32ba](https://www.github.com/googleapis/java-dataproc/commit/86b32baaeee93749e8e50f623ca405bd8167b32a))
* update dependency io.grpc:grpc-bom to v1.27.1 ([cb1e4b7](https://www.github.com/googleapis/java-dataproc/commit/cb1e4b78c58079a6cc82fef62d993cf2b2259b38))


### Documentation

* **regen:** update sample code to set total timeout, add API client header test ([9d7dddc](https://www.github.com/googleapis/java-dataproc/commit/9d7dddc630a1b4c2d1b8330fdefd2297ac802019))
* **regen:** updated docs from proto comments ([#87](https://www.github.com/googleapis/java-dataproc/issues/87)) ([b541715](https://www.github.com/googleapis/java-dataproc/commit/b5417153daf8238fcc0833d6148d2a6ec70e2b99))

## [0.119.0](https://www.github.com/googleapis/java-dataproc/compare/v0.118.1...v0.119.0) (2020-02-04)


### Features

* add AutoscalingPolicyServiceClient ([#66](https://www.github.com/googleapis/java-dataproc/issues/66)) ([b612d8e](https://www.github.com/googleapis/java-dataproc/commit/b612d8e2ce9d133449a9eef8e760fe9f138e5a57))


### Dependencies

* update core dependencies ([#47](https://www.github.com/googleapis/java-dataproc/issues/47)) ([4a7e1de](https://www.github.com/googleapis/java-dataproc/commit/4a7e1de068246efd23129293170efdf417e4645b))
* update core dependencies ([#65](https://www.github.com/googleapis/java-dataproc/issues/65)) ([521d6a2](https://www.github.com/googleapis/java-dataproc/commit/521d6a22d4c0be9af3df46c0b7186cdf13b5b8f9))
* update dependency com.google.guava:guava-bom to v28.2-android ([#45](https://www.github.com/googleapis/java-dataproc/issues/45)) ([231844e](https://www.github.com/googleapis/java-dataproc/commit/231844e6340d251d1d08c745235dd2e87e445af2))
* update dependency com.google.protobuf:protobuf-java to v3.11.3 ([#67](https://www.github.com/googleapis/java-dataproc/issues/67)) ([5321a0f](https://www.github.com/googleapis/java-dataproc/commit/5321a0fecd010fef6895b5f715794dd1f460aec7))
* update dependency org.threeten:threetenbp to v1.4.1 ([d2af17b](https://www.github.com/googleapis/java-dataproc/commit/d2af17b6ee0672b8fa6d03d6f649415098d11127))


### Documentation

* **regen:** fix javadoc return annotation ([#60](https://www.github.com/googleapis/java-dataproc/issues/60)) ([28ff392](https://www.github.com/googleapis/java-dataproc/commit/28ff392d36a7a686750010ca860bf797b07fc312))

### [0.118.1](https://www.github.com/googleapis/java-dataproc/compare/v0.118.0...v0.118.1) (2020-01-07)


### Dependencies

* update core dependencies ([#42](https://www.github.com/googleapis/java-dataproc/issues/42)) ([0f76b61](https://www.github.com/googleapis/java-dataproc/commit/0f76b61bdc53738e941da9fc6987c141bea4df68))
* update dependency io.grpc:grpc-bom to v1.26.0 ([#39](https://www.github.com/googleapis/java-dataproc/issues/39)) ([1156a6b](https://www.github.com/googleapis/java-dataproc/commit/1156a6b21b8fde07a56d4ab4a8c280266ef78249))
* update gax.version to v1.51.0 ([#28](https://www.github.com/googleapis/java-dataproc/issues/28)) ([45314dc](https://www.github.com/googleapis/java-dataproc/commit/45314dc50947d5375378baea07db76020940789f))


### Documentation

* **regen:** updated javadocs from protoc update ([#34](https://www.github.com/googleapis/java-dataproc/issues/34)) ([a87d161](https://www.github.com/googleapis/java-dataproc/commit/a87d1614eeacf5e1b5ff303f8e09ab930737061b))
* **regen:** updated javadocs from protos ([#40](https://www.github.com/googleapis/java-dataproc/issues/40)) ([f174b99](https://www.github.com/googleapis/java-dataproc/commit/f174b992fa65dbade37dc1df210b477d44af6758))

## [0.118.0](https://www.github.com/googleapis/java-dataproc/compare/0.117.0...v0.118.0) (2019-12-05)


### Features

* make repo releasable, add parent/bom ([#1](https://www.github.com/googleapis/java-dataproc/issues/1)) ([e186726](https://www.github.com/googleapis/java-dataproc/commit/e186726a8fd79e44c999e230f2566708d65619de))


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v1.91.3 ([#22](https://www.github.com/googleapis/java-dataproc/issues/22)) ([97c2a37](https://www.github.com/googleapis/java-dataproc/commit/97c2a377f3bdb45984f168b33e476591266ae83f))
* update dependency com.google.protobuf:protobuf-java to v3.11.0 ([#23](https://www.github.com/googleapis/java-dataproc/issues/23)) ([da12d98](https://www.github.com/googleapis/java-dataproc/commit/da12d98d90d17e6b0583ec4849d6282c9d7f910e))
* update dependency com.google.protobuf:protobuf-java to v3.11.1 ([#27](https://www.github.com/googleapis/java-dataproc/issues/27)) ([243abd1](https://www.github.com/googleapis/java-dataproc/commit/243abd18e651ab6a0e6be7c54171f40732e38788))
* update gax.version to v1.50.1 ([#5](https://www.github.com/googleapis/java-dataproc/issues/5)) ([c8aab8a](https://www.github.com/googleapis/java-dataproc/commit/c8aab8a44fe0f7f5848322749c5741ad4810d335))
