# Changelog

### [2.1.1](https://www.github.com/googleapis/java-channel/compare/v2.1.0...v2.1.1) (2021-05-11)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.1.0 ([#91](https://www.github.com/googleapis/java-channel/issues/91)) ([60ce7f7](https://www.github.com/googleapis/java-channel/commit/60ce7f785ac999dc9fd70659020a21e54784ff9b))

## [2.1.0](https://www.github.com/googleapis/java-channel/compare/v2.0.1...v2.1.0) (2021-04-23)


### Features

* Added legacy_sku field to TransferableSku ([3e0defe](https://www.github.com/googleapis/java-channel/commit/3e0defedb743a243e78fc307ae325ab939056dde))
* Adding customer level pubsub events for primary domain verification and primary domain change ([3e0defe](https://www.github.com/googleapis/java-channel/commit/3e0defedb743a243e78fc307ae325ab939056dde))
* addition of billing_account field on Plan ([#56](https://www.github.com/googleapis/java-channel/issues/56)) ([fdc2ad6](https://www.github.com/googleapis/java-channel/commit/fdc2ad62d253f36dcd55c0f3bb69138f4dea29cd))
* Enabled support for boolean as an allowed parameter value ([3e0defe](https://www.github.com/googleapis/java-channel/commit/3e0defedb743a243e78fc307ae325ab939056dde))
* **generator:** update protoc to v3.15.3 ([#54](https://www.github.com/googleapis/java-channel/issues/54)) ([bcece47](https://www.github.com/googleapis/java-channel/commit/bcece4727fd0f832a29b0f293b1f983cf0af0d8f))


### Bug Fixes

* release scripts from issuing overlapping phases ([#74](https://www.github.com/googleapis/java-channel/issues/74)) ([72667e2](https://www.github.com/googleapis/java-channel/commit/72667e228ddfa96f9e9965b7b63cf2258a3627e3))
* typo ([#72](https://www.github.com/googleapis/java-channel/issues/72)) ([dc27217](https://www.github.com/googleapis/java-channel/commit/dc27217a2e32d20c83784dc69bff24598dae25a3))


### Documentation

* clarification that valid address lines are required for all customers ([fdc2ad6](https://www.github.com/googleapis/java-channel/commit/fdc2ad62d253f36dcd55c0f3bb69138f4dea29cd))
* Update documentation comments to match tone and style with the rest of Cloud documentation ([#69](https://www.github.com/googleapis/java-channel/issues/69)) ([3e0defe](https://www.github.com/googleapis/java-channel/commit/3e0defedb743a243e78fc307ae325ab939056dde))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.20.1 ([#61](https://www.github.com/googleapis/java-channel/issues/61)) ([b532007](https://www.github.com/googleapis/java-channel/commit/b532007fd7afbf0b905e3432a02401b8feaef4a5))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.21.0 ([#70](https://www.github.com/googleapis/java-channel/issues/70)) ([93fde13](https://www.github.com/googleapis/java-channel/commit/93fde137961babee0b099e2e8d8ebcb1c2b1d5c9))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.21.1 ([#75](https://www.github.com/googleapis/java-channel/issues/75)) ([5686118](https://www.github.com/googleapis/java-channel/commit/5686118e7c2b3477d5d1081cfb512b655412418a))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1 ([#79](https://www.github.com/googleapis/java-channel/issues/79)) ([84f0ac3](https://www.github.com/googleapis/java-channel/commit/84f0ac3e8a5f81f1c73beb816f04b64142bc59b7))

### [2.0.1](https://www.github.com/googleapis/java-channel/compare/v2.0.0...v2.0.1) (2021-02-25)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.20.0 ([#50](https://www.github.com/googleapis/java-channel/issues/50)) ([4e08077](https://www.github.com/googleapis/java-channel/commit/4e08077673eae901d28c21237efd4b9c97f66184))

## [1.1.0](https://www.github.com/googleapis/java-channel/compare/v1.0.1...v1.1.0) (2021-02-24)


### ⚠ BREAKING CHANGES

* TransferableSkus field deprecation. Okay to make this change since no clients are using the libraries that were released just last week. The fields were supposed to be deprecated but missed. We have communicated to clients about this change.

### Features

* deprecate TransferableSkus field ([#44](https://www.github.com/googleapis/java-channel/issues/44)) ([3acf948](https://www.github.com/googleapis/java-channel/commit/3acf94818273c3676b0df6cae063ab977b8f0fef))

### [1.0.1](https://www.github.com/googleapis/java-channel/compare/v1.0.0...v1.0.1) (2021-02-19)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.19.0 ([#39](https://www.github.com/googleapis/java-channel/issues/39)) ([b84dabc](https://www.github.com/googleapis/java-channel/commit/b84dabc81ec852f540d1023bc5ed0bcf7e6ba06b))

## [1.0.0](https://www.github.com/googleapis/java-channel/compare/v0.1.0...v1.0.0) (2021-01-29)


### Features

* promote to 1.0.0 ([#13](https://www.github.com/googleapis/java-channel/issues/13)) ([afe5c34](https://www.github.com/googleapis/java-channel/commit/afe5c34c439964b099667c7d77487eb05b6eab1b))

## 0.1.0 (2021-01-29)


### Features

* initial code generation ([5d89a95](https://www.github.com/googleapis/java-channel/commit/5d89a952119d550f5f31d76ac6caee9c915f6318))


### Bug Fixes

* resolve dependency issue ([#9](https://www.github.com/googleapis/java-channel/issues/9)) ([971cf4e](https://www.github.com/googleapis/java-channel/commit/971cf4e6af1315b5035ffbd8b3c221d894336d1e))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.18.0 ([#5](https://www.github.com/googleapis/java-channel/issues/5)) ([29d193a](https://www.github.com/googleapis/java-channel/commit/29d193a573f51ad120358d33b65f223a8a439831))
