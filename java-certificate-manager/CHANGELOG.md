# Changelog

## [0.6.0](https://github.com/googleapis/google-cloud-java/compare/google-cloud-certificate-manager-v0.5.3...google-cloud-certificate-manager-v0.6.0) (2022-10-10)


### Features

* [analyticsdata] add `subject_to_thresholding` field to `ResponseMetadata` type ([#8545](https://github.com/googleapis/google-cloud-java/issues/8545)) ([8fdc6c1](https://github.com/googleapis/google-cloud-java/commit/8fdc6c1f10f88f30f4d1407579d645f75366b4cf))
* [certificatemanager] added support for Private Trust to Certificate Manager API ([#8502](https://github.com/googleapis/google-cloud-java/issues/8502)) ([6eef995](https://github.com/googleapis/google-cloud-java/commit/6eef9953a3f6f094dbf258c9a3abfe6ad30efa26))
* add `tokens_per_project_per_hour` field to `PropertyQuota` type ([8fdc6c1](https://github.com/googleapis/google-cloud-java/commit/8fdc6c1f10f88f30f4d1407579d645f75366b4cf))


### Bug Fixes

* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.2 ([#8325](https://github.com/googleapis/google-cloud-java/issues/8325)) ([01f492b](https://github.com/googleapis/google-cloud-java/commit/01f492be424acdb90edb23ba66656aeff7cf39eb))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.4 ([#8528](https://github.com/googleapis/google-cloud-java/issues/8528)) ([bd36199](https://github.com/googleapis/google-cloud-java/commit/bd361998ac4eb7c78eef3b3eac39aef31a0cf44e))
* owl-bot-staging should not be commited ([#8337](https://github.com/googleapis/google-cloud-java/issues/8337)) ([c9bb4a9](https://github.com/googleapis/google-cloud-java/commit/c9bb4a97aa19032b78c86c951fe9920f24ac4eec))
* revert reverting [Many APIs] Update WORKSPACE files for rules_gapic, gax_java, generator_java versions ([#8340](https://github.com/googleapis/google-cloud-java/issues/8340)) ([dedef71](https://github.com/googleapis/google-cloud-java/commit/dedef71f600e85b1c38e7110f5ffd44bf2ba32b4))


### Dependencies

* reverting renovate bot pull requests ([#8417](https://github.com/googleapis/google-cloud-java/issues/8417)) ([8f0c60b](https://github.com/googleapis/google-cloud-java/commit/8f0c60bde446acccc665eb7894723632eefc3503))

## [0.5.2](https://github.com/googleapis/java-certificate-manager/compare/v0.5.1...v0.5.2) (2022-09-15)


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.3 ([#80](https://github.com/googleapis/java-certificate-manager/issues/80)) ([a7a4c1c](https://github.com/googleapis/java-certificate-manager/commit/a7a4c1c2751a0a77ceae9fba3905626baa65feb9))

## [0.5.1](https://github.com/googleapis/java-certificate-manager/compare/v0.5.0...v0.5.1) (2022-09-10)


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.2 ([#75](https://github.com/googleapis/java-certificate-manager/issues/75)) ([8f21f5c](https://github.com/googleapis/java-certificate-manager/commit/8f21f5c8bc508df8ea4b01ffcabe8e1987aa4e4d))

## [0.5.0](https://github.com/googleapis/java-certificate-manager/compare/v0.4.1...v0.5.0) (2022-08-05)


### ⚠ BREAKING CHANGES

* Removed resource definition of Compute API resources and incorrect resource references that used them (#58)

### Bug Fixes

* Removed resource definition of Compute API resources and incorrect resource references that used them ([#58](https://github.com/googleapis/java-certificate-manager/issues/58)) ([f3c48b4](https://github.com/googleapis/java-certificate-manager/commit/f3c48b404d9f305e08d0621d849786ffff829493))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v3 ([#66](https://github.com/googleapis/java-certificate-manager/issues/66)) ([93e3a01](https://github.com/googleapis/java-certificate-manager/commit/93e3a0143ae1aa82ac02d8f7b90a1ff2579f4781))

## [0.4.1](https://github.com/googleapis/java-certificate-manager/compare/v0.4.0...v0.4.1) (2022-07-13)


### Bug Fixes

* enable longpaths support for windows test ([#1485](https://github.com/googleapis/java-certificate-manager/issues/1485)) ([#60](https://github.com/googleapis/java-certificate-manager/issues/60)) ([44d24e1](https://github.com/googleapis/java-certificate-manager/commit/44d24e100b995f71903b25571cfa4a5564ad0bec))

## [0.4.0](https://github.com/googleapis/java-certificate-manager/compare/v0.3.1...v0.4.0) (2022-06-30)


### Features

* Enable REST transport for most of Java and Go clients ([#48](https://github.com/googleapis/java-certificate-manager/issues/48)) ([f910bef](https://github.com/googleapis/java-certificate-manager/commit/f910bef5e7a3d8651ad105070a10d074c12238cc))


### Bug Fixes

* update gapic-generator-java with mock service generation fixes ([#54](https://github.com/googleapis/java-certificate-manager/issues/54)) ([707eedc](https://github.com/googleapis/java-certificate-manager/commit/707eedc49999e5411f63072242722b16edba5dae))

## [0.3.1](https://github.com/googleapis/java-certificate-manager/compare/v0.3.0...v0.3.1) (2022-06-23)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.13.0 ([#47](https://github.com/googleapis/java-certificate-manager/issues/47)) ([639d5c8](https://github.com/googleapis/java-certificate-manager/commit/639d5c8737169399aaf93fb1b68da74d79abb9b3))

## [0.3.0](https://github.com/googleapis/java-certificate-manager/compare/v0.2.0...v0.3.0) (2022-05-19)


### Features

* add build scripts for native image testing in Java 17 ([#1440](https://github.com/googleapis/java-certificate-manager/issues/1440)) ([#38](https://github.com/googleapis/java-certificate-manager/issues/38)) ([33cf428](https://github.com/googleapis/java-certificate-manager/commit/33cf4281d0b6da27b42a7b8269de9198e4e66b91))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.11.0 ([#37](https://github.com/googleapis/java-certificate-manager/issues/37)) ([175c882](https://github.com/googleapis/java-certificate-manager/commit/175c88218ea5110d5465ab15c5c4603c53af52e3))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.12.0 ([#40](https://github.com/googleapis/java-certificate-manager/issues/40)) ([47fc9bf](https://github.com/googleapis/java-certificate-manager/commit/47fc9bfc3ca88966a527c713e6b8eba99ae01835))

## [0.2.0](https://github.com/googleapis/java-certificate-manager/compare/v0.1.1...v0.2.0) (2022-04-15)


### ⚠ BREAKING CHANGES

* Updated resource patterns to comply with https://google.aip.dev/123#annotating-resource-types (#24)

### Bug Fixes

* Updated resource patterns to comply with https://google.aip.dev/123#annotating-resource-types ([#24](https://github.com/googleapis/java-certificate-manager/issues/24)) ([56aec63](https://github.com/googleapis/java-certificate-manager/commit/56aec63d62c8c4b9459ff4c927adabaa49e78e0c))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.10.0 ([#27](https://github.com/googleapis/java-certificate-manager/issues/27)) ([c43930c](https://github.com/googleapis/java-certificate-manager/commit/c43930c1f769b49785b970d0c1927fa8d5fbe4bf))

### [0.1.1](https://github.com/googleapis/java-certificate-manager/compare/v0.1.0...v0.1.1) (2022-03-29)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.9.0 ([#20](https://github.com/googleapis/java-certificate-manager/issues/20)) ([7ecf994](https://github.com/googleapis/java-certificate-manager/commit/7ecf99424648eebfe66304e15665e73d273814c3))

## 0.1.0 (2022-03-07)


### Features

* initial generation ([44c02ed](https://github.com/googleapis/java-certificate-manager/commit/44c02ed11efa25eab0028286ba428f815c2f5307))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.8.0 ([023144f](https://github.com/googleapis/java-certificate-manager/commit/023144f1d3fc2331c51f32ad1f7a6f916280bcc0))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.8.0 ([023144f](https://github.com/googleapis/java-certificate-manager/commit/023144f1d3fc2331c51f32ad1f7a6f916280bcc0))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.8.0 ([2515d89](https://github.com/googleapis/java-certificate-manager/commit/2515d897add17d34c627fe6acad6dc9ae46535a2))
