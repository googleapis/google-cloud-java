# Changelog

## [0.118.0](https://www.github.com/googleapis/java-compute/compare/0.117.0...v0.118.0) (2020-04-09)


### ⚠ BREAKING CHANGES

* change pagination return type for listManagedInstances (#107)
* bool includeAllScopes added as a required parameter to aggregatedList* methods
* add wait methods for OperationClients, add PacketMirroringClient (#69)

### Features

* add ExchangedPeeringRoute, mode to AutoscalingPolicy, recommendedSize to Autoscaler ([#45](https://www.github.com/googleapis/java-compute/issues/45)) ([64c8b48](https://www.github.com/googleapis/java-compute/commit/64c8b48b84e19a6217cc2869a2cb7bb360b317c5))
* add Image#storageLocationsList() ([#28](https://www.github.com/googleapis/java-compute/issues/28)) ([9b161e1](https://www.github.com/googleapis/java-compute/commit/9b161e1bd40bb77fcdf2c8902b8c7a52328a91af))
* add includeAllScopes to aggregatedList* methods ([#94](https://www.github.com/googleapis/java-compute/issues/94)) ([141904f](https://www.github.com/googleapis/java-compute/commit/141904f5833401b99442e5e3b347a589389861c2))
* add LogConfig, Network to BackendService, add ApplyUpdate for InstanceGroupManager, RegionInstanceGroupManager ([#78](https://www.github.com/googleapis/java-compute/issues/78)) ([7abe892](https://www.github.com/googleapis/java-compute/commit/7abe89228087a6a5bc88e591e04bcc2e5ee68149))
* add wait methods for OperationClients, add PacketMirroringClient ([#69](https://www.github.com/googleapis/java-compute/issues/69)) ([50cb4a9](https://www.github.com/googleapis/java-compute/commit/50cb4a98cb36fcd3bf4bdd5d16ab17f9d391bf98))
* make repo releasable ([#1](https://www.github.com/googleapis/java-compute/issues/1)) ([e6d81a1](https://www.github.com/googleapis/java-compute/commit/e6d81a11c2b51d9f4f3a5a2a357fc26fdd3b0004))


### Bug Fixes

* change pagination return type for listManagedInstances ([#107](https://www.github.com/googleapis/java-compute/issues/107)) ([c9d783e](https://www.github.com/googleapis/java-compute/commit/c9d783efcb721445235dc496ffd83d37c43a2403)), closes [#97](https://www.github.com/googleapis/java-compute/issues/97) [#97](https://www.github.com/googleapis/java-compute/issues/97) [#105](https://www.github.com/googleapis/java-compute/issues/105) [#105](https://www.github.com/googleapis/java-compute/issues/105)


### Dependencies

* update core ([#101](https://www.github.com/googleapis/java-compute/issues/101)) ([8525c1c](https://www.github.com/googleapis/java-compute/commit/8525c1c0453fda71cda2b61bb6b0e915d20ee504))
* update core dependencies ([#106](https://www.github.com/googleapis/java-compute/issues/106)) ([f08ded5](https://www.github.com/googleapis/java-compute/commit/f08ded51fc90992ea2a04a0cc3b7f252c522bbe7))
* update core dependencies ([#47](https://www.github.com/googleapis/java-compute/issues/47)) ([a0accdd](https://www.github.com/googleapis/java-compute/commit/a0accddc4f08e734acf9cd0fdf568f08ae5d562e))
* update core dependencies ([#57](https://www.github.com/googleapis/java-compute/issues/57)) ([eef4be4](https://www.github.com/googleapis/java-compute/commit/eef4be45430aa9eec506b610b2a396a74dbc41ce))
* update core dependencies ([#66](https://www.github.com/googleapis/java-compute/issues/66)) ([7f1f5fa](https://www.github.com/googleapis/java-compute/commit/7f1f5fab6013c254a7502369182aed90e27b7794))
* update core dependencies ([#70](https://www.github.com/googleapis/java-compute/issues/70)) ([e733296](https://www.github.com/googleapis/java-compute/commit/e73329610530dca8b61945be6ed7701a4ceaaa8b))
* update core dependencies ([#76](https://www.github.com/googleapis/java-compute/issues/76)) ([26ecbd9](https://www.github.com/googleapis/java-compute/commit/26ecbd9929954538c60e7d07251c30a3081f0711))
* update core dependencies ([#82](https://www.github.com/googleapis/java-compute/issues/82)) ([5adbc75](https://www.github.com/googleapis/java-compute/commit/5adbc75ecdd37d78e1f960071419c34cdc3f0941))
* update core dependencies to v1.92.1 ([#51](https://www.github.com/googleapis/java-compute/issues/51)) ([3bc4658](https://www.github.com/googleapis/java-compute/commit/3bc4658f24dafc2452a3661035e326a09d4bb864))
* update core dependencies to v1.93.1 ([#77](https://www.github.com/googleapis/java-compute/issues/77)) ([002632a](https://www.github.com/googleapis/java-compute/commit/002632addcbf45509492664347c6cccf806ac854))
* update core transport dependencies ([#73](https://www.github.com/googleapis/java-compute/issues/73)) ([a435fe2](https://www.github.com/googleapis/java-compute/commit/a435fe2b7ef4f77ec1539af94085366bb2785eaf))
* update dependency com.google.api-client:google-api-client-bom to v1.30.7 ([#38](https://www.github.com/googleapis/java-compute/issues/38)) ([26006d8](https://www.github.com/googleapis/java-compute/commit/26006d8d6b071df9f98e73f8ec98cfd7028c3242))
* update dependency com.google.api-client:google-api-client-bom to v1.30.8 ([#67](https://www.github.com/googleapis/java-compute/issues/67)) ([93041a5](https://www.github.com/googleapis/java-compute/commit/93041a581cd44b23afb085962b3eb56e9b34051b))
* update dependency com.google.api:api-common to v1.9.0 ([#92](https://www.github.com/googleapis/java-compute/issues/92)) ([ed41ffe](https://www.github.com/googleapis/java-compute/commit/ed41ffedcd1a26707e3c33346cf50f111441cb81))
* update dependency com.google.apis:google-api-services-compute to v1-rev20200114-1.30.8 ([#72](https://www.github.com/googleapis/java-compute/issues/72)) ([c397120](https://www.github.com/googleapis/java-compute/commit/c397120efc6e84c71bf8c76ce18888afd61fca14))
* update dependency com.google.apis:google-api-services-compute to v1-rev20200120-1.30.9 ([#79](https://www.github.com/googleapis/java-compute/issues/79)) ([f9dce18](https://www.github.com/googleapis/java-compute/commit/f9dce18fa61f808dc71e29f2e6b689303ac0b60e))
* update dependency com.google.apis:google-api-services-compute to v1-rev20200302-1.30.9 ([#88](https://www.github.com/googleapis/java-compute/issues/88)) ([d420ae8](https://www.github.com/googleapis/java-compute/commit/d420ae820477a89a4879158f3d3e58b6dc2e0f8c))
* update dependency com.google.apis:google-api-services-compute to v1-rev20200311-1.30.9 ([#108](https://www.github.com/googleapis/java-compute/issues/108)) ([4892008](https://www.github.com/googleapis/java-compute/commit/48920086e8c5e28624147cb9cda8e3e1a4b1820e))
* update dependency com.google.cloud:google-cloud-storage to v1.103.1 ([#64](https://www.github.com/googleapis/java-compute/issues/64)) ([cb5b802](https://www.github.com/googleapis/java-compute/commit/cb5b80262b143a788030e22856734128bb64a95e))
* update dependency com.google.cloud:google-cloud-storage to v1.105.0 ([#75](https://www.github.com/googleapis/java-compute/issues/75)) ([584b637](https://www.github.com/googleapis/java-compute/commit/584b6371773190053963d4423ff11a7cdb3d9bad))
* update dependency com.google.cloud:google-cloud-storage to v1.105.1 ([#81](https://www.github.com/googleapis/java-compute/issues/81)) ([3374fb3](https://www.github.com/googleapis/java-compute/commit/3374fb3eccd5634e462d0d22013616b2a6f8c76a))
* update dependency com.google.guava:guava-bom to v28.2-android ([be76015](https://www.github.com/googleapis/java-compute/commit/be7601584804383521eaff2f4fbc8fa787852567))
* update dependency com.google.http-client:google-http-client-bom to v1.33.0 ([#12](https://www.github.com/googleapis/java-compute/issues/12)) ([e9d9b64](https://www.github.com/googleapis/java-compute/commit/e9d9b64d49d821cd87a0ae8ae0c932b9ff067e2a))
* update dependency com.google.http-client:google-http-client-bom to v1.34.0 ([#35](https://www.github.com/googleapis/java-compute/issues/35)) ([e7fac53](https://www.github.com/googleapis/java-compute/commit/e7fac535b070cf1ac49698ef9cc229bc1b46e9aa))
* update dependency com.google.http-client:google-http-client-bom to v1.34.1 ([#63](https://www.github.com/googleapis/java-compute/issues/63)) ([f1c89b7](https://www.github.com/googleapis/java-compute/commit/f1c89b78539f8d10ff046c26e5ec6cd324511ae3))
* update dependency com.google.oauth-client:google-oauth-client-bom to v1.30.5 ([#36](https://www.github.com/googleapis/java-compute/issues/36)) ([14ebd10](https://www.github.com/googleapis/java-compute/commit/14ebd1023261c424c54303d680a1555b1bb1c104))
* update dependency com.google.oauth-client:google-oauth-client-bom to v1.30.6 ([#80](https://www.github.com/googleapis/java-compute/issues/80)) ([8fb22b0](https://www.github.com/googleapis/java-compute/commit/8fb22b06d922e1fea4896ee6233ac2c8bfdd5554))
* update dependency io.grpc:grpc-bom to v1.26.0 ([6487ad4](https://www.github.com/googleapis/java-compute/commit/6487ad4586ddd3233e2e62fbf559dfcb8cc60351))
* update dependency org.threeten:threetenbp to v1.4.1 ([758f5c2](https://www.github.com/googleapis/java-compute/commit/758f5c2a2f08024c2f2671cffd0ad3314e41126f))
* update dependency org.threeten:threetenbp to v1.4.2 ([#90](https://www.github.com/googleapis/java-compute/issues/90)) ([5bbe72e](https://www.github.com/googleapis/java-compute/commit/5bbe72e31550f6c897ad983f6dc69945bfaaca63))
* update dependency org.threeten:threetenbp to v1.4.3 ([#104](https://www.github.com/googleapis/java-compute/issues/104)) ([d6a781e](https://www.github.com/googleapis/java-compute/commit/d6a781e48bfd8d520110ebaa432033cf77d1f5d9))


### Documentation

* broken link ([#68](https://www.github.com/googleapis/java-compute/issues/68)) ([d09b7f3](https://www.github.com/googleapis/java-compute/commit/d09b7f322f81e5e12e8682ba5cd1aaba077a9e88))
* regenerate generated javadoc ([#18](https://www.github.com/googleapis/java-compute/issues/18)) ([8d9b351](https://www.github.com/googleapis/java-compute/commit/8d9b351f37fa5416b09d21bbf234e5af628c746f))
