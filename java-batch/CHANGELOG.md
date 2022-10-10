# Changelog

## [0.4.0](https://github.com/googleapis/google-cloud-java/compare/google-cloud-batch-v0.3.2...google-cloud-batch-v0.4.0) (2022-10-10)


### Features

* [analyticsdata] add `subject_to_thresholding` field to `ResponseMetadata` type ([#8545](https://github.com/googleapis/google-cloud-java/issues/8545)) ([8fdc6c1](https://github.com/googleapis/google-cloud-java/commit/8fdc6c1f10f88f30f4d1407579d645f75366b4cf))
* add `tokens_per_project_per_hour` field to `PropertyQuota` type ([8fdc6c1](https://github.com/googleapis/google-cloud-java/commit/8fdc6c1f10f88f30f4d1407579d645f75366b4cf))


### Bug Fixes

* [batch] mark service_account_email as deprecated ([#8273](https://github.com/googleapis/google-cloud-java/issues/8273)) ([96705cb](https://github.com/googleapis/google-cloud-java/commit/96705cbee07049a75ffadcc601484f914b39f309))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.2 ([#8325](https://github.com/googleapis/google-cloud-java/issues/8325)) ([01f492b](https://github.com/googleapis/google-cloud-java/commit/01f492be424acdb90edb23ba66656aeff7cf39eb))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.4 ([#8528](https://github.com/googleapis/google-cloud-java/issues/8528)) ([bd36199](https://github.com/googleapis/google-cloud-java/commit/bd361998ac4eb7c78eef3b3eac39aef31a0cf44e))
* owl-bot-staging should not be commited ([#8337](https://github.com/googleapis/google-cloud-java/issues/8337)) ([c9bb4a9](https://github.com/googleapis/google-cloud-java/commit/c9bb4a97aa19032b78c86c951fe9920f24ac4eec))
* revert reverting [Many APIs] Update WORKSPACE files for rules_gapic, gax_java, generator_java versions ([#8340](https://github.com/googleapis/google-cloud-java/issues/8340)) ([dedef71](https://github.com/googleapis/google-cloud-java/commit/dedef71f600e85b1c38e7110f5ffd44bf2ba32b4))


### Documentation

* removing comment from a deprecated field ([96705cb](https://github.com/googleapis/google-cloud-java/commit/96705cbee07049a75ffadcc601484f914b39f309))


### Dependencies

* reverting renovate bot pull requests ([#8417](https://github.com/googleapis/google-cloud-java/issues/8417)) ([8f0c60b](https://github.com/googleapis/google-cloud-java/commit/8f0c60bde446acccc665eb7894723632eefc3503))

## [0.3.1](https://github.com/googleapis/java-batch/compare/v0.3.0...v0.3.1) (2022-09-28)


### Dependencies

* Update dependency cachetools to v5 ([#62](https://github.com/googleapis/java-batch/issues/62)) ([10f1cc8](https://github.com/googleapis/java-batch/commit/10f1cc8cbcf2d5f443d82363d1c3604e1151f441))
* Update dependency certifi to v2022.9.24 ([#46](https://github.com/googleapis/java-batch/issues/46)) ([16fd4f4](https://github.com/googleapis/java-batch/commit/16fd4f4a658e290cce519c3d72350e3dab86eb62))
* Update dependency charset-normalizer to v2.1.1 ([#50](https://github.com/googleapis/java-batch/issues/50)) ([75906e4](https://github.com/googleapis/java-batch/commit/75906e488c0882d853e1fe63315e96c80cb376d7))
* Update dependency click to v8.1.3 ([#51](https://github.com/googleapis/java-batch/issues/51)) ([3bc6542](https://github.com/googleapis/java-batch/commit/3bc6542e1a7abbcf4f343dc59f02a3aac72e723e))
* Update dependency gcp-releasetool to v1.8.8 ([#47](https://github.com/googleapis/java-batch/issues/47)) ([2175cf4](https://github.com/googleapis/java-batch/commit/2175cf4ffca873cea9da59128489067a9e41bf28))
* Update dependency google-api-core to v2.10.1 ([#52](https://github.com/googleapis/java-batch/issues/52)) ([1684933](https://github.com/googleapis/java-batch/commit/168493370fd14c9eb2180290ff9103666cecd823))
* Update dependency google-auth to v2.12.0 ([#53](https://github.com/googleapis/java-batch/issues/53)) ([ead1241](https://github.com/googleapis/java-batch/commit/ead12418259ef0176de25a00c252d1c0bf41888e))
* Update dependency google-cloud-core to v2.3.2 ([#48](https://github.com/googleapis/java-batch/issues/48)) ([716b8d8](https://github.com/googleapis/java-batch/commit/716b8d8ebe91eb8adab03f1771092c68ffd75e61))
* Update dependency google-cloud-storage to v2.5.0 ([#54](https://github.com/googleapis/java-batch/issues/54)) ([b0e2745](https://github.com/googleapis/java-batch/commit/b0e2745af18d096045c6ebeca6bd5c5ffe668e09))
* Update dependency google-crc32c to v1.5.0 ([#55](https://github.com/googleapis/java-batch/issues/55)) ([a20c8ab](https://github.com/googleapis/java-batch/commit/a20c8ab1f645b4f33322cf6f45a020b049a2c9db))
* Update dependency googleapis-common-protos to v1.56.4 ([#49](https://github.com/googleapis/java-batch/issues/49)) ([62c0202](https://github.com/googleapis/java-batch/commit/62c0202829949b10e2e4ff3add4ccd6f2fafbb3a))
* Update dependency importlib-metadata to v4.12.0 ([#63](https://github.com/googleapis/java-batch/issues/63)) ([3a88cb3](https://github.com/googleapis/java-batch/commit/3a88cb3b120e3016d50444e76f6f429b530c5269))
* Update dependency jeepney to v0.8.0 ([#64](https://github.com/googleapis/java-batch/issues/64)) ([a4c5676](https://github.com/googleapis/java-batch/commit/a4c56762d9a420324b25ff39656f7f0395b5f16a))
* Update dependency jinja2 to v3.1.2 ([#65](https://github.com/googleapis/java-batch/issues/65)) ([3e58704](https://github.com/googleapis/java-batch/commit/3e5870427d17335fd3c09718e6f4b7f30a0852cb))
* Update dependency keyring to v23.9.3 ([#66](https://github.com/googleapis/java-batch/issues/66)) ([3630bdc](https://github.com/googleapis/java-batch/commit/3630bdc13d4f54c3119a502d9b41015842952fb7))
* Update dependency markupsafe to v2.1.1 ([#56](https://github.com/googleapis/java-batch/issues/56)) ([58cf14a](https://github.com/googleapis/java-batch/commit/58cf14a781e701485d9a6725ea007684c7926563))
* Update dependency protobuf to v3.20.2 ([#57](https://github.com/googleapis/java-batch/issues/57)) ([ee2f20d](https://github.com/googleapis/java-batch/commit/ee2f20d01967b4ab6cf5e02f47c94395bac480b8))
* Update dependency protobuf to v4 ([#67](https://github.com/googleapis/java-batch/issues/67)) ([74ab05f](https://github.com/googleapis/java-batch/commit/74ab05f2bc8932ee67c4cd065008ce669a3c4a05))
* Update dependency pyjwt to v2.5.0 ([#58](https://github.com/googleapis/java-batch/issues/58)) ([54bc183](https://github.com/googleapis/java-batch/commit/54bc18356ce1edd5ee1efece4e86164242f1d4cd))
* Update dependency requests to v2.28.1 ([#59](https://github.com/googleapis/java-batch/issues/59)) ([316c948](https://github.com/googleapis/java-batch/commit/316c948b9e744348caf57ca50ecd2f4715796026))
* Update dependency typing-extensions to v4.3.0 ([#60](https://github.com/googleapis/java-batch/issues/60)) ([d0cc0ec](https://github.com/googleapis/java-batch/commit/d0cc0ec46212296513feb6f75e623a0943248793))
* Update dependency zipp to v3.8.1 ([#61](https://github.com/googleapis/java-batch/issues/61)) ([c9443db](https://github.com/googleapis/java-batch/commit/c9443db4847f37671d6451f87d6912f20b36cc53))

## [0.3.0](https://github.com/googleapis/java-batch/compare/v0.2.2...v0.3.0) (2022-09-15)


### Features

* environment variables, disk interfaces ([4f26297](https://github.com/googleapis/java-batch/commit/4f26297dd9d91ad73daa26d4294fd6fabe6f0a48))
* environment variables, disk interfaces ([4f26297](https://github.com/googleapis/java-batch/commit/4f26297dd9d91ad73daa26d4294fd6fabe6f0a48))


### Bug Fixes

* Mark service_account_email as deprecated ([#36](https://github.com/googleapis/java-batch/issues/36)) ([176b6e6](https://github.com/googleapis/java-batch/commit/176b6e6ee8bdb3264a297673b87b5dee74717628))


### Documentation

* removing comment from a deprecated field ([176b6e6](https://github.com/googleapis/java-batch/commit/176b6e6ee8bdb3264a297673b87b5dee74717628))


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.2 ([#38](https://github.com/googleapis/java-batch/issues/38)) ([7d5571a](https://github.com/googleapis/java-batch/commit/7d5571aeca1ae9406e38e6c13070e0c5d17b65ab))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.3 ([#40](https://github.com/googleapis/java-batch/issues/40)) ([fcd0595](https://github.com/googleapis/java-batch/commit/fcd059540e8d5483d008ee86702525462a30d542))

## [0.2.2](https://github.com/googleapis/java-batch/compare/v0.2.1...v0.2.2) (2022-08-09)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v3 ([#25](https://github.com/googleapis/java-batch/issues/25)) ([74aada0](https://github.com/googleapis/java-batch/commit/74aada0cc988793580f912b4d385e5f7b035b755))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.1 ([#28](https://github.com/googleapis/java-batch/issues/28)) ([fd55721](https://github.com/googleapis/java-batch/commit/fd5572145d677fe92c58546e0ebd813576c8dd32))

## [0.2.1](https://github.com/googleapis/java-batch/compare/v0.2.0...v0.2.1) (2022-07-13)


### Bug Fixes

* enable longpaths support for windows test ([#1485](https://github.com/googleapis/java-batch/issues/1485)) ([#18](https://github.com/googleapis/java-batch/issues/18)) ([9a8cd4b](https://github.com/googleapis/java-batch/commit/9a8cd4b17c67f8c93770399a822019f8a6a827ce))

## [0.2.0](https://github.com/googleapis/java-batch/compare/v0.1.1...v0.2.0) (2022-06-30)


### Features

* add client library BUILD rules, API proto option, v1alpha service config file and service YAML file ([ca7e9fa](https://github.com/googleapis/java-batch/commit/ca7e9fa43e64d378edf2fd0917585ab33135fc81))
* Enable REST transport for most of Java and Go clients ([#6](https://github.com/googleapis/java-batch/issues/6)) ([ca7e9fa](https://github.com/googleapis/java-batch/commit/ca7e9fa43e64d378edf2fd0917585ab33135fc81))


### Bug Fixes

* update gapic-generator-java with mock service generation fixes ([#13](https://github.com/googleapis/java-batch/issues/13)) ([4ce5e88](https://github.com/googleapis/java-batch/commit/4ce5e884e0a9cc97affd6076846276f9c81ce78b))

## [0.1.1](https://github.com/googleapis/java-batch/compare/v0.1.0...v0.1.1) (2022-06-23)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.13.0 ([#7](https://github.com/googleapis/java-batch/issues/7)) ([0859548](https://github.com/googleapis/java-batch/commit/08595480c36317bf31af9e56272e580f56667cb5))

## 0.1.0 (2022-06-15)


### Features

* initial generation ([a8574bf](https://github.com/googleapis/java-batch/commit/a8574bffae3ae30e94881d87faf64c494b7a02b4))
