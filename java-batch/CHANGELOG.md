# Changelog

## 0.42.0 (2024-04-25)

### Features

* Added optional flag of an existing field `limit`, `consumed`, `carryover` in ResourceAllowance
* add a service_account field to taskGroup for service account support ([a1e72bb](https://github.com/googleapis/google-cloud-java/commit/a1e72bb1f08d20ff2580ccd1b280c77fa49dbdeb))
* Added optional flag of an existing field `limit`, `consumed`, `carryover` in ResourceAllowance ([a1e72bb](https://github.com/googleapis/google-cloud-java/commit/a1e72bb1f08d20ff2580ccd1b280c77fa49dbdeb))
* A comment for field `max_run_duration` in message `.google.cloud.batch.v1alpha.TaskSpec` and `.google.cloud.batch.v1.TaskSpec` is changed ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* add non-negative restriction comment for usage_resource_allowance.spec.limit.limit exposed on v1alpha ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* add non-negative restriction comment for usage_resource_allowance.spec.limit.limit exposed on v1alpha ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* state one Resource Allowance per region per project limitation on v1alpha ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* state one Resource Allowance per region per project limitation on v1alpha ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* update comments on ServiceAccount email and scopes fields ([a1e72bb](https://github.com/googleapis/google-cloud-java/commit/a1e72bb1f08d20ff2580ccd1b280c77fa49dbdeb))



## 0.41.0 (2024-04-04)

* No change


## 0.39.0 (2024-03-28)

### Features

* onboard Resource Allowance API methods on v1alpha ([11b0068](https://github.com/googleapis/google-cloud-java/commit/11b006884eb99a9426cc06c25f1689a7708d4869))



## 0.38.0 (2024-03-22)

### Features

* changed retry settings for UpdateJob ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* changed retry settings for UpdateJob ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))



## 0.37.0 (2024-03-06)

### Features

* Remove UUID specification in comment ([#10408](https://github.com/googleapis/google-cloud-java/issues/10408)) ([391f4f0](https://github.com/googleapis/google-cloud-java/commit/391f4f08da31e026ab7ab08b3118438bac4afd57))



## 0.36.0 (2024-02-20)

### Features

* refine proto comment for run_as_non_root ([#10404](https://github.com/googleapis/google-cloud-java/issues/10404)) ([05acf2d](https://github.com/googleapis/google-cloud-java/commit/05acf2d7f7013851268174810821b0892a9cee5e))



## 0.35.0 (2024-02-09)

* No change


## 0.34.0 (2024-01-23)

### Features

* remove deprecated field enableOslogin ([#10257](https://github.com/googleapis/google-cloud-java/issues/10257))
* remove deprecated field enableOslogin ([#10257](https://github.com/googleapis/google-cloud-java/issues/10257)) ([2da4e3e](https://github.com/googleapis/google-cloud-java/commit/2da4e3e19fba34f129e8d0972cfab6b3a6d4d2f7))
* Polish the field descriptions for enableImageStreaming and CloudLoggingOptions ([#10275](https://github.com/googleapis/google-cloud-java/issues/10275)) ([a95b354](https://github.com/googleapis/google-cloud-java/commit/a95b354af5fa16bf7517876949fd6d1a72aa6b5d))



## 0.33.0 (2024-01-10)

### Features

* Add `tags` field in Job's AllocationPolicy field in v1alpha ([#10206](https://github.com/googleapis/google-cloud-java/issues/10206)) ([4bcdc24](https://github.com/googleapis/google-cloud-java/commit/4bcdc24592c9195de73d65deed36585c0e82db22))



## 0.32.0 (2023-12-12)

* No change


## 0.31.0 (2023-12-04)

### Features

* add a CloudLoggingOption and use_generic_task_monitored_resource fields for users to opt out new batch monitored resource in cloud logging ([#10056](https://github.com/googleapis/google-cloud-java/issues/10056)) ([a9830d9](https://github.com/googleapis/google-cloud-java/commit/a9830d9373cad9d2235ed93a625ebee886ff6ff0))
* add a CloudLoggingOption and use_generic_task_monitored_resource fields for users to opt out new batch monitored resource in cloud logging ([#10073](https://github.com/googleapis/google-cloud-java/issues/10073)) ([5c91759](https://github.com/googleapis/google-cloud-java/commit/5c91759a2067bb7bf8d6ffe26f5aeef07c9cbb0a))

### Dependencies

* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.20.0 ([#10093](https://github.com/googleapis/google-cloud-java/issues/10093)) ([91a4e4e](https://github.com/googleapis/google-cloud-java/commit/91a4e4e20252f667b8fc6bda0d9ceaf947348274))


## 0.30.0 (2023-11-06)

### Features

* update default max parallel tasks per job ([#10011](https://github.com/googleapis/google-cloud-java/issues/10011)) ([4edc21b](https://github.com/googleapis/google-cloud-java/commit/4edc21bc0e54f9b52eb367beac2d438197f23432))

### Dependencies

* **deps:** update dependency com.google.cloud:google-cloud-shared-config to v1.6.1 ([#10014](https://github.com/googleapis/google-cloud-java/issues/10014)) ([7b1b742](https://github.com/googleapis/google-cloud-java/commit/7b1b742dab21139398032549fb03e127b1a03841))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.19.0 ([#10018](https://github.com/googleapis/google-cloud-java/issues/10018)) ([d9b705a](https://github.com/googleapis/google-cloud-java/commit/d9b705aaed8ea4447c7a02d5c54300f8909a30b1))


## 0.29.0 (2023-10-25)

### Features

* expose display_name to batch v1 API ([#9967](https://github.com/googleapis/google-cloud-java/issues/9967)) ([934c929](https://github.com/googleapis/google-cloud-java/commit/934c92940ec76f96aa71b13249a81cde58bab5ee))

### Dependencies

* **deps:** update dependency com.google.cloud:google-cloud-shared-config to v1.6.0 ([#9969](https://github.com/googleapis/google-cloud-java/issues/9969)) ([9e2be39](https://github.com/googleapis/google-cloud-java/commit/9e2be39c5b2d7764421325f65a6d0d06351fcda5))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.18.0 ([#9984](https://github.com/googleapis/google-cloud-java/issues/9984)) ([9814dc0](https://github.com/googleapis/google-cloud-java/commit/9814dc092ad7edb7b1b21f87fa48d76a2423d731))


## 0.28.0 (2023-10-11)

### Features

* add InstancePolicy.reservation field for restricting jobs to a specific reservation ([#9933](https://github.com/googleapis/google-cloud-java/issues/9933)) ([42f3ee5](https://github.com/googleapis/google-cloud-java/commit/42f3ee5cc0fc747bc79e183077bd8e6807e3f9b6))

### Dependencies

* **deps:** update dependency com.google.cloud:google-cloud-shared-config to v1.5.8 ([#9941](https://github.com/googleapis/google-cloud-java/issues/9941)) ([f818d26](https://github.com/googleapis/google-cloud-java/commit/f818d26968e1f19d302da1f1ea0145b2cc496ce0))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.17.0 ([#9942](https://github.com/googleapis/google-cloud-java/issues/9942)) ([2cc7888](https://github.com/googleapis/google-cloud-java/commit/2cc78885d76ae5e7dfc4cc9f3034c25fa22c6cc1))


## 0.27.0 (2023-09-28)

* No change


## 0.25.0 (2023-09-27)

### Features

* update batch PD interface support ([#9888](https://github.com/googleapis/google-cloud-java/issues/9888)) ([8002742](https://github.com/googleapis/google-cloud-java/commit/8002742584f6153931dd2ceda2b03b3d9a7639b9))

### Dependencies

* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.16.0 ([#9866](https://github.com/googleapis/google-cloud-java/issues/9866)) ([aa36b2c](https://github.com/googleapis/google-cloud-java/commit/aa36b2c3c31b817052239fd771a21d20108b2c31))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.16.1 ([#9881](https://github.com/googleapis/google-cloud-java/issues/9881)) ([8a29511](https://github.com/googleapis/google-cloud-java/commit/8a2951166eb0305be040cc0ae38be105c437ba25))


## 0.24.0 (2023-09-11)

### Features

* Add more compute resource API descriptions to match with VM's machine type field ([42b33d5](https://github.com/googleapis/google-cloud-java/commit/42b33d51fa9cdd0c2237825f009198a648e0e9c0))
* add stderr_snippet to indicate the real stderr output by runnables to the execution field of status event ([42b33d5](https://github.com/googleapis/google-cloud-java/commit/42b33d51fa9cdd0c2237825f009198a648e0e9c0))
* Clarify Batch API proto doc about pubsub notifications ([42b33d5](https://github.com/googleapis/google-cloud-java/commit/42b33d51fa9cdd0c2237825f009198a648e0e9c0))
* Revert HTML formats in comments ([42b33d5](https://github.com/googleapis/google-cloud-java/commit/42b33d51fa9cdd0c2237825f009198a648e0e9c0))
* Update description on size_gb in disk field ([42b33d5](https://github.com/googleapis/google-cloud-java/commit/42b33d51fa9cdd0c2237825f009198a648e0e9c0))
* Update description on size_gb in disk field ([#9744](https://github.com/googleapis/google-cloud-java/issues/9744)) ([42b33d5](https://github.com/googleapis/google-cloud-java/commit/42b33d51fa9cdd0c2237825f009198a648e0e9c0))

### Dependencies

* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.15.0 ([#9809](https://github.com/googleapis/google-cloud-java/issues/9809)) ([09dbd85](https://github.com/googleapis/google-cloud-java/commit/09dbd855f683b40a462c4f918511bee4671e0174))


## 0.23.0 (2023-08-08)

### Features

* Add comment to the unsupported order_by field of ListTasksRequest ([#9684](https://github.com/googleapis/google-cloud-java/issues/9684)) ([c27566e](https://github.com/googleapis/google-cloud-java/commit/c27566e930b4165a6a468351021c222d677478c8))
* Clarify Batch API proto doc about pubsub notifications ([#9741](https://github.com/googleapis/google-cloud-java/issues/9741)) ([e580ede](https://github.com/googleapis/google-cloud-java/commit/e580ede1be613ac684f4d24f1c9c6d6a392f00b8))

### Dependencies

* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.14.0 ([#9722](https://github.com/googleapis/google-cloud-java/issues/9722)) ([c7011db](https://github.com/googleapis/google-cloud-java/commit/c7011dbd69189330de1c2946b736cd712d5c1f4e))


## 0.22.0 (2023-07-21)

### Dependencies

* **deps:** update dependency com.google.cloud:google-cloud-shared-config to v1.5.7 ([#9651](https://github.com/googleapis/google-cloud-java/issues/9651)) ([c88d623](https://github.com/googleapis/google-cloud-java/commit/c88d623d12a4342b74e31d6a6a05cde0debe871f))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.13.1 ([#9655](https://github.com/googleapis/google-cloud-java/issues/9655)) ([affebee](https://github.com/googleapis/google-cloud-java/commit/affebeeb37b1cf88ad5964684e1f112cababcab7))


## 0.21.0 (2023-07-11)

### Features

* Add gpu driver version field ([#9609](https://github.com/googleapis/google-cloud-java/issues/9609)) ([79b80a3](https://github.com/googleapis/google-cloud-java/commit/79b80a34531fb60e3bd4e83ba67a3c24019b1229))

### Dependencies

* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.13.0 ([#9622](https://github.com/googleapis/google-cloud-java/issues/9622)) ([3ac3050](https://github.com/googleapis/google-cloud-java/commit/3ac3050250a706e8f9f2d1e435a4983c3cceab82))


## 0.20.0 (2023-06-23)

### Features

* implement minCpuPlatform ([c235f3a](https://github.com/googleapis/google-cloud-java/commit/c235f3a4a2706c5e6a5bee97ebc62aef96d2e3e6))
* Add support for scheduling_policy ([#9542](https://github.com/googleapis/google-cloud-java/issues/9542)) ([c235f3a](https://github.com/googleapis/google-cloud-java/commit/c235f3a4a2706c5e6a5bee97ebc62aef96d2e3e6))

### Dependencies

* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.12.0 ([#9577](https://github.com/googleapis/google-cloud-java/issues/9577)) ([9e9812a](https://github.com/googleapis/google-cloud-java/commit/9e9812a0ba19e5aa82a34f2a3049bb72892544a6))


## [0.5.0](https://github.com/googleapis/google-cloud-java/compare/google-cloud-batch-v0.4.1-SNAPSHOT...google-cloud-batch-v0.5.0) (2022-10-24)


### Features

* [analyticsdata] add `subject_to_thresholding` field to `ResponseMetadata` type ([#8545](https://github.com/googleapis/google-cloud-java/issues/8545)) ([8fdc6c1](https://github.com/googleapis/google-cloud-java/commit/8fdc6c1f10f88f30f4d1407579d645f75366b4cf))
* add `tokens_per_project_per_hour` field to `PropertyQuota` type ([8fdc6c1](https://github.com/googleapis/google-cloud-java/commit/8fdc6c1f10f88f30f4d1407579d645f75366b4cf))


### Bug Fixes

* [batch] mark service_account_email as deprecated ([#8273](https://github.com/googleapis/google-cloud-java/issues/8273)) ([96705cb](https://github.com/googleapis/google-cloud-java/commit/96705cbee07049a75ffadcc601484f914b39f309))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.2 ([#8325](https://github.com/googleapis/google-cloud-java/issues/8325)) ([01f492b](https://github.com/googleapis/google-cloud-java/commit/01f492be424acdb90edb23ba66656aeff7cf39eb))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.4 ([#8528](https://github.com/googleapis/google-cloud-java/issues/8528)) ([bd36199](https://github.com/googleapis/google-cloud-java/commit/bd361998ac4eb7c78eef3b3eac39aef31a0cf44e))
* owl-bot-staging should not be commited ([#8337](https://github.com/googleapis/google-cloud-java/issues/8337)) ([c9bb4a9](https://github.com/googleapis/google-cloud-java/commit/c9bb4a97aa19032b78c86c951fe9920f24ac4eec))
* revert reverting [Many APIs] Update WORKSPACE files for rules_gapic, gax_java, generator_java versions ([#8340](https://github.com/googleapis/google-cloud-java/issues/8340)) ([dedef71](https://github.com/googleapis/google-cloud-java/commit/dedef71f600e85b1c38e7110f5ffd44bf2ba32b4))


### Dependencies

* reverting renovate bot pull requests ([#8417](https://github.com/googleapis/google-cloud-java/issues/8417)) ([8f0c60b](https://github.com/googleapis/google-cloud-java/commit/8f0c60bde446acccc665eb7894723632eefc3503))


### Documentation

* [batch] Refine GPU drivers installation proto description ([#8614](https://github.com/googleapis/google-cloud-java/issues/8614)) ([9d73075](https://github.com/googleapis/google-cloud-java/commit/9d7307579c4427e2482036180a576f1edc11d984))
* removing comment from a deprecated field ([96705cb](https://github.com/googleapis/google-cloud-java/commit/96705cbee07049a75ffadcc601484f914b39f309))

## [0.4.0](https://github.com/googleapis/google-cloud-java/compare/google-cloud-batch-v0.3.2...google-cloud-batch-v0.4.0) (2022-10-17)


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

## [0.3.2](https://github.com/googleapis/java-batch/compare/v0.3.1...v0.3.2) (2022-10-03)


### Documentation

* **samples:** Added basic samples and tests ([#43](https://github.com/googleapis/java-batch/issues/43)) ([62bdc9a](https://github.com/googleapis/java-batch/commit/62bdc9a31d657818110b9d2f4560ee391fd27942))


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.4 ([#77](https://github.com/googleapis/java-batch/issues/77)) ([bf0394e](https://github.com/googleapis/java-batch/commit/bf0394e4a45eaf3a966f7840a69afe0d44faad0a))
* Update dependency google-resumable-media to v2.4.0 ([#74](https://github.com/googleapis/java-batch/issues/74)) ([b05cbba](https://github.com/googleapis/java-batch/commit/b05cbbaa3b28016d0d5f90f2b18d358f2d3bb535))
* Update dependency protobuf to v3.20.3 ([#75](https://github.com/googleapis/java-batch/issues/75)) ([9d639bc](https://github.com/googleapis/java-batch/commit/9d639bc48ecfe9bc278e56574207e9745dc8eea5))

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
