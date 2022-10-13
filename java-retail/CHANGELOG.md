# Changelog

## [2.6.0](https://github.com/googleapis/google-cloud-java/compare/google-cloud-retail-v2.5.2...google-cloud-retail-v2.6.0) (2022-10-13)


### Features

* [analyticsdata] add `subject_to_thresholding` field to `ResponseMetadata` type ([#8545](https://github.com/googleapis/google-cloud-java/issues/8545)) ([8fdc6c1](https://github.com/googleapis/google-cloud-java/commit/8fdc6c1f10f88f30f4d1407579d645f75366b4cf))
* [retail] release Model Services to v2beta version ([#8284](https://github.com/googleapis/google-cloud-java/issues/8284)) ([5f742f9](https://github.com/googleapis/google-cloud-java/commit/5f742f913f48c47c8ba3eeeb3e08adc162b288db))
* add `tokens_per_project_per_hour` field to `PropertyQuota` type ([8fdc6c1](https://github.com/googleapis/google-cloud-java/commit/8fdc6c1f10f88f30f4d1407579d645f75366b4cf))
* add local inventories info to the Product resource ([5f742f9](https://github.com/googleapis/google-cloud-java/commit/5f742f913f48c47c8ba3eeeb3e08adc162b288db))
* create release please configuration ([41b97e6](https://github.com/googleapis/google-cloud-java/commit/41b97e6d0d38a54fbabf51a3069bf1473c48f730))
* deprecate unused facet_spec field of Control in v2beta version ([5f742f9](https://github.com/googleapis/google-cloud-java/commit/5f742f913f48c47c8ba3eeeb3e08adc162b288db))
* deprecate unused page_token field of PredictionRequest in v2beta version ([5f742f9](https://github.com/googleapis/google-cloud-java/commit/5f742f913f48c47c8ba3eeeb3e08adc162b288db))
* release BatchRemoveCatalogAttributes API to v2beta version ([5f742f9](https://github.com/googleapis/google-cloud-java/commit/5f742f913f48c47c8ba3eeeb3e08adc162b288db))
* release diversity_type for ServingConfig in v2beta version ([5f742f9](https://github.com/googleapis/google-cloud-java/commit/5f742f913f48c47c8ba3eeeb3e08adc162b288db))
* release ExactSearchableOption for attribute config to v2beta version ([5f742f9](https://github.com/googleapis/google-cloud-java/commit/5f742f913f48c47c8ba3eeeb3e08adc162b288db))


### Bug Fixes

* **deps:** update dependency com.google.cloud:google-cloud-bigquery to v2.15.0 ([#8231](https://github.com/googleapis/google-cloud-java/issues/8231)) ([2c0b9ad](https://github.com/googleapis/google-cloud-java/commit/2c0b9ad05b4ff658ac7a08bde6637653825d2802))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.2 ([#8325](https://github.com/googleapis/google-cloud-java/issues/8325)) ([01f492b](https://github.com/googleapis/google-cloud-java/commit/01f492be424acdb90edb23ba66656aeff7cf39eb))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.4 ([#8528](https://github.com/googleapis/google-cloud-java/issues/8528)) ([bd36199](https://github.com/googleapis/google-cloud-java/commit/bd361998ac4eb7c78eef3b3eac39aef31a0cf44e))
* **deps:** update dependency com.google.cloud:libraries-bom to v26.1.1 ([#8254](https://github.com/googleapis/google-cloud-java/issues/8254)) ([e4760da](https://github.com/googleapis/google-cloud-java/commit/e4760da4ac8fa6fa91bc82b90b83d0518eca2692))
* owl-bot-staging should not be commited ([#8337](https://github.com/googleapis/google-cloud-java/issues/8337)) ([c9bb4a9](https://github.com/googleapis/google-cloud-java/commit/c9bb4a97aa19032b78c86c951fe9920f24ac4eec))


### Documentation

* improve documentation for Fullfillment and Inventory API in ProductService ([5f742f9](https://github.com/googleapis/google-cloud-java/commit/5f742f913f48c47c8ba3eeeb3e08adc162b288db))
* improve documentation of SearchRequest for Search Personalization ([5f742f9](https://github.com/googleapis/google-cloud-java/commit/5f742f913f48c47c8ba3eeeb3e08adc162b288db))
* minor documentation fixes and improvements ([5f742f9](https://github.com/googleapis/google-cloud-java/commit/5f742f913f48c47c8ba3eeeb3e08adc162b288db))


### Dependencies

* reverting renovate bot pull requests ([#8417](https://github.com/googleapis/google-cloud-java/issues/8417)) ([8f0c60b](https://github.com/googleapis/google-cloud-java/commit/8f0c60bde446acccc665eb7894723632eefc3503))

## [2.5.2](https://github.com/googleapis/java-retail/compare/v2.5.1...v2.5.2) (2022-10-06)


### Dependencies

* Update dependency com.google.cloud:google-cloud-bigquery to v2.17.0 ([#578](https://github.com/googleapis/java-retail/issues/578)) ([ebb21ca](https://github.com/googleapis/java-retail/commit/ebb21ca6bff55085fba676e2315d235a9f3d7896))
* Update dependency com.google.cloud:google-cloud-storage to v2.13.0 ([#581](https://github.com/googleapis/java-retail/issues/581)) ([c0451a3](https://github.com/googleapis/java-retail/commit/c0451a3194ae273ea6fe133a6fa96ff953b80282))

## [2.5.1](https://github.com/googleapis/java-retail/compare/v2.5.0...v2.5.1) (2022-10-03)


### Bug Fixes

* **samples:** Bug fix for removing buckets from bq. ([#548](https://github.com/googleapis/java-retail/issues/548)) ([c407fe3](https://github.com/googleapis/java-retail/commit/c407fe3581a39598d86eb968b2650c8e8f4e8063))
* **samples:** Bug fix for setup script ([#549](https://github.com/googleapis/java-retail/issues/549)) ([abc4b3e](https://github.com/googleapis/java-retail/commit/abc4b3eab3ae664ceeb4de54b3623406aac85950))
* **samples:** Lro added out-of-order step. ([#539](https://github.com/googleapis/java-retail/issues/539)) ([2befbb1](https://github.com/googleapis/java-retail/commit/2befbb1349131345488890ad33eb20ba91692f1b))
* **samples:** Removed delays on LRO ([#527](https://github.com/googleapis/java-retail/issues/527)) ([934c6b4](https://github.com/googleapis/java-retail/commit/934c6b4dd259e18d1aee88abbffd4b88d1b70343))
* **samples:** Replaced your-project-id with default. ([#541](https://github.com/googleapis/java-retail/issues/541)) ([f1b2397](https://github.com/googleapis/java-retail/commit/f1b23977282b213029533756449213d591673f62))
* **samples:** Updating both json files. ([#540](https://github.com/googleapis/java-retail/issues/540)) ([22386d5](https://github.com/googleapis/java-retail/commit/22386d50f0cf66449236562e241bce212ada70ea))


### Dependencies

* Update dependency cachetools to v5 ([#566](https://github.com/googleapis/java-retail/issues/566)) ([95ea349](https://github.com/googleapis/java-retail/commit/95ea3490140be099b54deaa0ff74ad4659869a92))
* Update dependency certifi to v2022.9.24 ([#568](https://github.com/googleapis/java-retail/issues/568)) ([45253be](https://github.com/googleapis/java-retail/commit/45253be7a091375b790bb229a9ca55a65b4a3f32))
* Update dependency charset-normalizer to v2.1.1 ([#556](https://github.com/googleapis/java-retail/issues/556)) ([f244afc](https://github.com/googleapis/java-retail/commit/f244afcf0a27c84a489ed3621201b9e18d168cdb))
* Update dependency com.google.cloud:google-cloud-bigquery to v2.16.1 ([#542](https://github.com/googleapis/java-retail/issues/542)) ([e9e88d3](https://github.com/googleapis/java-retail/commit/e9e88d3014f1e35655b76e0f834889a37ac02f00))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.4 ([#577](https://github.com/googleapis/java-retail/issues/577)) ([a963dc6](https://github.com/googleapis/java-retail/commit/a963dc6cf0b4ef93ee5bf411cf5f97a98062e633))
* Update dependency com.google.cloud:google-cloud-storage to v2.12.0 ([#543](https://github.com/googleapis/java-retail/issues/543)) ([24386db](https://github.com/googleapis/java-retail/commit/24386db488f724d4e10965cd25605f3af2ed403a))
* Update dependency gcp-releasetool to v1.8.8 ([#569](https://github.com/googleapis/java-retail/issues/569)) ([45a7e22](https://github.com/googleapis/java-retail/commit/45a7e22e2793aa21b9044865944e28d436cfa9d6))
* Update dependency google-api-core to v2.10.1 ([#558](https://github.com/googleapis/java-retail/issues/558)) ([8712708](https://github.com/googleapis/java-retail/commit/8712708260b380e4856a34aa03434448190ce5dd))
* Update dependency google-auth to v2.11.1 ([#570](https://github.com/googleapis/java-retail/issues/570)) ([0b4e3a5](https://github.com/googleapis/java-retail/commit/0b4e3a5d1b0fecdeffc9c1f160ea9b08fe220300))
* Update dependency google-cloud-core to v2.3.2 ([#554](https://github.com/googleapis/java-retail/issues/554)) ([98db758](https://github.com/googleapis/java-retail/commit/98db758b0b9d12281b150a341790eecd4d5664a2))
* Update dependency google-cloud-storage to v2.5.0 ([#559](https://github.com/googleapis/java-retail/issues/559)) ([01ddcf9](https://github.com/googleapis/java-retail/commit/01ddcf9b16dce0ab80430ac20938ff4b9216b382))
* Update dependency google-crc32c to v1.5.0 ([#560](https://github.com/googleapis/java-retail/issues/560)) ([e877900](https://github.com/googleapis/java-retail/commit/e87790009c7f5b3bf131f1db04ad97713b6b6c8c))
* Update dependency googleapis-common-protos to v1.56.4 ([#555](https://github.com/googleapis/java-retail/issues/555)) ([1cb27b3](https://github.com/googleapis/java-retail/commit/1cb27b3ee903c2104911c27217b78bd9cacea26a))
* Update dependency importlib-metadata to v4.12.0 ([#561](https://github.com/googleapis/java-retail/issues/561)) ([9f4d04b](https://github.com/googleapis/java-retail/commit/9f4d04b23e909829b129f2acc2d6061e8894a20f))
* Update dependency jeepney to v0.8.0 ([#571](https://github.com/googleapis/java-retail/issues/571)) ([5ca90a0](https://github.com/googleapis/java-retail/commit/5ca90a04c6f0c8de9f90675b6ef91612701a15d8))
* Update dependency jinja2 to v3.1.2 ([#572](https://github.com/googleapis/java-retail/issues/572)) ([0cf30ee](https://github.com/googleapis/java-retail/commit/0cf30eee9ba1256164255444344b4be5d09a5143))
* Update dependency keyring to v23.9.3 ([#573](https://github.com/googleapis/java-retail/issues/573)) ([ab772da](https://github.com/googleapis/java-retail/commit/ab772dafca75ae557b8f2558e32da6899082b2c0))
* Update dependency markupsafe to v2.1.1 ([#553](https://github.com/googleapis/java-retail/issues/553)) ([fce0ade](https://github.com/googleapis/java-retail/commit/fce0ade246a75dc35b05e106f1b7f5aa73fc516e))
* Update dependency protobuf to v3.20.2 ([#574](https://github.com/googleapis/java-retail/issues/574)) ([7fa228e](https://github.com/googleapis/java-retail/commit/7fa228eb669cb0b59e64ca0d2e8641e01df05a9e))
* Update dependency protobuf to v4 ([#567](https://github.com/googleapis/java-retail/issues/567)) ([cf6be4c](https://github.com/googleapis/java-retail/commit/cf6be4ceff0cd39af95b8e0201aa1657579b21a0))
* Update dependency pyjwt to v2.5.0 ([#562](https://github.com/googleapis/java-retail/issues/562)) ([96ec337](https://github.com/googleapis/java-retail/commit/96ec337e1ec00811b23f1f509156749d2a062301))
* Update dependency requests to v2.28.1 ([#563](https://github.com/googleapis/java-retail/issues/563)) ([8bd27c1](https://github.com/googleapis/java-retail/commit/8bd27c1a264132f932701ae5b5f14b6540bdb8a1))
* Update dependency typing-extensions to v4.3.0 ([#564](https://github.com/googleapis/java-retail/issues/564)) ([7c0cd75](https://github.com/googleapis/java-retail/commit/7c0cd7590d9d52acf7c82ecc1cbd8df85ba5e7ca))
* Update dependency zipp to v3.8.1 ([#565](https://github.com/googleapis/java-retail/issues/565)) ([4c30271](https://github.com/googleapis/java-retail/commit/4c302718f919d231d02fa5415a45825aab38fe18))

## [2.5.0](https://github.com/googleapis/java-retail/compare/v2.4.0...v2.5.0) (2022-09-16)


### Features

* add local inventories info to the Product resource ([8204fbc](https://github.com/googleapis/java-retail/commit/8204fbc29ced51d83d3624a6b79ea34a60d5ca2a))
* release AttributesConfig APIs to v2 version ([8204fbc](https://github.com/googleapis/java-retail/commit/8204fbc29ced51d83d3624a6b79ea34a60d5ca2a))
* release CompletionConfig APIs to v2 version ([8204fbc](https://github.com/googleapis/java-retail/commit/8204fbc29ced51d83d3624a6b79ea34a60d5ca2a))
* Release Control and ServingConfig serivces to v2 version ([#522](https://github.com/googleapis/java-retail/issues/522)) ([8204fbc](https://github.com/googleapis/java-retail/commit/8204fbc29ced51d83d3624a6b79ea34a60d5ca2a))


### Bug Fixes

* **samples:** Removed add time from lro. ([#530](https://github.com/googleapis/java-retail/issues/530)) ([541e280](https://github.com/googleapis/java-retail/commit/541e280c72ff411302cc6917b527c2cdeeddccd6))
* **samples:** Removed env variables and buckets from creating bq. ([#526](https://github.com/googleapis/java-retail/issues/526)) ([67152a6](https://github.com/googleapis/java-retail/commit/67152a6c35a5ad291cb7190f2a3af4a241ad78da))
* **samples:** Removed region tags ([#531](https://github.com/googleapis/java-retail/issues/531)) ([2d0dd5c](https://github.com/googleapis/java-retail/commit/2d0dd5c50f9373ea0eac42d857b2409eb84b0028))


### Documentation

* Improved documentation for Fullfillment and Inventory API in ProductService ([8204fbc](https://github.com/googleapis/java-retail/commit/8204fbc29ced51d83d3624a6b79ea34a60d5ca2a))
* minor documentation format and typo fixes ([8204fbc](https://github.com/googleapis/java-retail/commit/8204fbc29ced51d83d3624a6b79ea34a60d5ca2a))
* **samples:** Refactoring events package ([#481](https://github.com/googleapis/java-retail/issues/481)) ([20d2539](https://github.com/googleapis/java-retail/commit/20d25397433ae050ecefc47c5ccabfcca6f7ad44))
* **samples:** Refactoring product package ([#480](https://github.com/googleapis/java-retail/issues/480)) ([0c39897](https://github.com/googleapis/java-retail/commit/0c39897a694bc2c5c253276a035147f7e19c7596))


### Dependencies

* Update dependency com.google.cloud:google-cloud-bigquery to v2.14.5 ([#503](https://github.com/googleapis/java-retail/issues/503)) ([435df1b](https://github.com/googleapis/java-retail/commit/435df1b78daa7813be97e6b0810bc5f1dee284ed))
* Update dependency com.google.cloud:google-cloud-bigquery to v2.14.6 ([#519](https://github.com/googleapis/java-retail/issues/519)) ([9c37ee3](https://github.com/googleapis/java-retail/commit/9c37ee35321855921646520b1a8281b20a205154))
* Update dependency com.google.cloud:google-cloud-bigquery to v2.14.7 ([#523](https://github.com/googleapis/java-retail/issues/523)) ([0da80f8](https://github.com/googleapis/java-retail/commit/0da80f870fe0b7ccd3b3d66489fc0af588e65663))
* Update dependency com.google.cloud:google-cloud-bigquery to v2.15.0 ([#524](https://github.com/googleapis/java-retail/issues/524)) ([ecb986a](https://github.com/googleapis/java-retail/commit/ecb986ad5be8246740504683f5fc9d8d1fcd89b9))
* Update dependency com.google.cloud:google-cloud-bigquery to v2.16.0 ([#535](https://github.com/googleapis/java-retail/issues/535)) ([e7fa004](https://github.com/googleapis/java-retail/commit/e7fa004c9ff6c106bd5512c6cc11833a33635ce3))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.2 ([#533](https://github.com/googleapis/java-retail/issues/533)) ([6236b06](https://github.com/googleapis/java-retail/commit/6236b06c17885439f47a2811b388119c1a045147))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.3 ([#538](https://github.com/googleapis/java-retail/issues/538)) ([ab71781](https://github.com/googleapis/java-retail/commit/ab717817de6798ad9eebb5c6df537b13b9281f45))
* Update dependency com.google.cloud:google-cloud-storage to v2.11.3 ([#511](https://github.com/googleapis/java-retail/issues/511)) ([364b3d4](https://github.com/googleapis/java-retail/commit/364b3d47ae6f8fca85dad8c775cda1354b5fc413))

## [2.4.0](https://github.com/googleapis/java-retail/compare/v2.3.0...v2.4.0) (2022-08-09)


### Features

* allow adding labels in search requests ([70ae250](https://github.com/googleapis/java-retail/commit/70ae25069bac1244e50bcaabc98962e3a8471de6))
* allow adding labels in search requests ([70ae250](https://github.com/googleapis/java-retail/commit/70ae25069bac1244e50bcaabc98962e3a8471de6))
* allow disabling spell check in search requests ([70ae250](https://github.com/googleapis/java-retail/commit/70ae25069bac1244e50bcaabc98962e3a8471de6))
* allow disabling spell check in search requests ([70ae250](https://github.com/googleapis/java-retail/commit/70ae25069bac1244e50bcaabc98962e3a8471de6))
* allow enabling recommendation filtering on custom attributes ([70ae250](https://github.com/googleapis/java-retail/commit/70ae25069bac1244e50bcaabc98962e3a8471de6))
* allow enabling recommendation filtering on custom attributes ([70ae250](https://github.com/googleapis/java-retail/commit/70ae25069bac1244e50bcaabc98962e3a8471de6))
* allow returning min/max values on search numeric facets ([70ae250](https://github.com/googleapis/java-retail/commit/70ae25069bac1244e50bcaabc98962e3a8471de6))
* allow returning min/max values on search numeric facets ([70ae250](https://github.com/googleapis/java-retail/commit/70ae25069bac1244e50bcaabc98962e3a8471de6))
* allow skiping default branch protection when doing product full import ([70ae250](https://github.com/googleapis/java-retail/commit/70ae25069bac1244e50bcaabc98962e3a8471de6))
* allow to return min/max values on search numeric facets ([70ae250](https://github.com/googleapis/java-retail/commit/70ae25069bac1244e50bcaabc98962e3a8471de6))
* allow to use serving configs as an alias of placements ([70ae250](https://github.com/googleapis/java-retail/commit/70ae25069bac1244e50bcaabc98962e3a8471de6))
* allow using serving configs as an alias of placements ([70ae250](https://github.com/googleapis/java-retail/commit/70ae25069bac1244e50bcaabc98962e3a8471de6))
* allow using serving configs as an alias of placements ([70ae250](https://github.com/googleapis/java-retail/commit/70ae25069bac1244e50bcaabc98962e3a8471de6))
* new model service to manage recommendation models ([#497](https://github.com/googleapis/java-retail/issues/497)) ([70ae250](https://github.com/googleapis/java-retail/commit/70ae25069bac1244e50bcaabc98962e3a8471de6))
* return output BigQuery table on product / event export response ([70ae250](https://github.com/googleapis/java-retail/commit/70ae25069bac1244e50bcaabc98962e3a8471de6))
* return output BigQuery table on product / event export response ([70ae250](https://github.com/googleapis/java-retail/commit/70ae25069bac1244e50bcaabc98962e3a8471de6))
* support case insensitive match on search facets ([70ae250](https://github.com/googleapis/java-retail/commit/70ae25069bac1244e50bcaabc98962e3a8471de6))
* support case insensitive match on search facets ([70ae250](https://github.com/googleapis/java-retail/commit/70ae25069bac1244e50bcaabc98962e3a8471de6))
* support case insensitive match on search facets ([70ae250](https://github.com/googleapis/java-retail/commit/70ae25069bac1244e50bcaabc98962e3a8471de6))


### Bug Fixes

* enable longpaths support for windows test ([#1485](https://github.com/googleapis/java-retail/issues/1485)) ([#487](https://github.com/googleapis/java-retail/issues/487)) ([aebd3d2](https://github.com/googleapis/java-retail/commit/aebd3d29de1a46313626a9167ed2129e0de99c06))


### Documentation

* keep the API doc up-to-date with recent changes ([70ae250](https://github.com/googleapis/java-retail/commit/70ae25069bac1244e50bcaabc98962e3a8471de6))
* keep the API doc up-to-date with recent changes ([70ae250](https://github.com/googleapis/java-retail/commit/70ae25069bac1244e50bcaabc98962e3a8471de6))
* keep the API doc up-to-date with recent changes ([70ae250](https://github.com/googleapis/java-retail/commit/70ae25069bac1244e50bcaabc98962e3a8471de6))
* **samples:** Refactoring product package (CRUD) ([#417](https://github.com/googleapis/java-retail/issues/417)) ([6b1973d](https://github.com/googleapis/java-retail/commit/6b1973d68830ee93f860f6e9312655518ae082fa))
* **samples:** Refactoring search package ([#415](https://github.com/googleapis/java-retail/issues/415)) ([ae435e0](https://github.com/googleapis/java-retail/commit/ae435e0a2b25c329409002517d0619e5e38a71ea))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v3 ([#499](https://github.com/googleapis/java-retail/issues/499)) ([9aff3a0](https://github.com/googleapis/java-retail/commit/9aff3a0c65cc26b75fd7e3a37b3d70f1c9bb6f92))
* update dependency com.google.cloud:google-cloud-storage to v2.10.0 ([#504](https://github.com/googleapis/java-retail/issues/504)) ([82db98b](https://github.com/googleapis/java-retail/commit/82db98bb13443e3548d4c149145a2700e5e0ff2d))
* update dependency com.google.cloud:google-cloud-storage to v2.11.0 ([#507](https://github.com/googleapis/java-retail/issues/507)) ([911ff65](https://github.com/googleapis/java-retail/commit/911ff65bf29ffaa3e53f480223f808c005410b52))
* update dependency com.google.cloud:google-cloud-storage to v2.11.1 ([#509](https://github.com/googleapis/java-retail/issues/509)) ([c6a7c65](https://github.com/googleapis/java-retail/commit/c6a7c6508559befd56071fc0c57adbded7e1f0da))
* update dependency com.google.cloud:google-cloud-storage to v2.11.2 ([#510](https://github.com/googleapis/java-retail/issues/510)) ([d532bff](https://github.com/googleapis/java-retail/commit/d532bff899659d7f0222dd26e04e08dbd1f3cd66))
* update dependency com.google.code.gson:gson to v2.9.1 ([#500](https://github.com/googleapis/java-retail/issues/500)) ([2af1d50](https://github.com/googleapis/java-retail/commit/2af1d507833c88a2debbb17ae808df3074f33a98))

## [2.3.0](https://github.com/googleapis/java-retail/compare/v2.2.4...v2.3.0) (2022-07-01)


### Features

* Enable REST transport for most of Java and Go clients ([#471](https://github.com/googleapis/java-retail/issues/471)) ([d5cd803](https://github.com/googleapis/java-retail/commit/d5cd803431a014def402683310f400f2e7d4b1a6))


### Bug Fixes

* update gapic-generator-java with mock service generation fixes ([#475](https://github.com/googleapis/java-retail/issues/475)) ([5090d6d](https://github.com/googleapis/java-retail/commit/5090d6d63e4d66f916d950274f164c762f59f6ff))

## [2.2.4](https://github.com/googleapis/java-retail/compare/v2.2.3...v2.2.4) (2022-06-23)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.13.0 ([#470](https://github.com/googleapis/java-retail/issues/470)) ([ce87e1c](https://github.com/googleapis/java-retail/commit/ce87e1cfd8c4aa537730d287a39bede78f50801f))

## [2.2.3](https://github.com/googleapis/java-retail/compare/v2.2.2...v2.2.3) (2022-06-22)


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v2.13.4 ([#467](https://github.com/googleapis/java-retail/issues/467)) ([f9b3845](https://github.com/googleapis/java-retail/commit/f9b38451284e889e22af87683b4fb1023e584e71))

## [2.2.2](https://github.com/googleapis/java-retail/compare/v2.2.1...v2.2.2) (2022-06-21)


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v2.13.3 ([#464](https://github.com/googleapis/java-retail/issues/464)) ([25091f3](https://github.com/googleapis/java-retail/commit/25091f3223d623bc916e84a70e3da3512a721aac))

## [2.2.1](https://github.com/googleapis/java-retail/compare/v2.2.0...v2.2.1) (2022-06-13)


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v2.13.2 ([#454](https://github.com/googleapis/java-retail/issues/454)) ([d5e56ad](https://github.com/googleapis/java-retail/commit/d5e56addf98b636ac3d64b5ea040eb61a29916cd))
* update dependency com.google.cloud:google-cloud-storage to v2.8.0 ([#456](https://github.com/googleapis/java-retail/issues/456)) ([56a85fd](https://github.com/googleapis/java-retail/commit/56a85fd1ea1feef2cac57206c8219ad4953564dd))

## [2.2.0](https://github.com/googleapis/java-retail/compare/v2.1.0...v2.2.0) (2022-06-07)


### Features

* add v2alpha/v2beta clients ([#452](https://github.com/googleapis/java-retail/issues/452)) ([35a598d](https://github.com/googleapis/java-retail/commit/35a598dbac1ba909e87c70934651e9b463b6286b))
* allow users to disable spell check in search requests ([#449](https://github.com/googleapis/java-retail/issues/449)) ([5e19c6d](https://github.com/googleapis/java-retail/commit/5e19c6d4df49d14cd37d7489a9bb5161ebd78645))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v2.12.0 ([#446](https://github.com/googleapis/java-retail/issues/446)) ([62d951e](https://github.com/googleapis/java-retail/commit/62d951e9ba3e33ad66215e593e1f4e40d8e4ba70))
* update dependency com.google.cloud:google-cloud-bigquery to v2.13.1 ([#448](https://github.com/googleapis/java-retail/issues/448)) ([a031d67](https://github.com/googleapis/java-retail/commit/a031d677a2d9087527388e448a94da3144b9e8ed))
* update dependency com.google.cloud:google-cloud-storage to v2.7.1 ([#444](https://github.com/googleapis/java-retail/issues/444)) ([91a264d](https://github.com/googleapis/java-retail/commit/91a264d8c019e6fb42d2cb26c0f49c08c59a98d0))
* update dependency com.google.cloud:google-cloud-storage to v2.7.2 ([#447](https://github.com/googleapis/java-retail/issues/447)) ([5ff519b](https://github.com/googleapis/java-retail/commit/5ff519b1a4ff7d20d685c4db5d0217ac900025a7))

## [2.1.0](https://github.com/googleapis/java-retail/compare/v2.0.19...v2.1.0) (2022-05-19)


### Features

* add build scripts for native image testing in Java 17 ([#1440](https://github.com/googleapis/java-retail/issues/1440)) ([#440](https://github.com/googleapis/java-retail/issues/440)) ([4df8b26](https://github.com/googleapis/java-retail/commit/4df8b26f56c46baefc3e1f13fc9635cc54604ade))


### Documentation

* **samples:** Retail. Prediction samples ([#412](https://github.com/googleapis/java-retail/issues/412)) ([025f04f](https://github.com/googleapis/java-retail/commit/025f04fb663274c9388e6a73ebdb47d5c7cb5730))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v2.11.0 ([#431](https://github.com/googleapis/java-retail/issues/431)) ([3f1060d](https://github.com/googleapis/java-retail/commit/3f1060d92804fc5a2401f200bacbe8bbb6986283))
* update dependency com.google.cloud:google-cloud-bigquery to v2.11.1 ([#437](https://github.com/googleapis/java-retail/issues/437)) ([4a526c0](https://github.com/googleapis/java-retail/commit/4a526c0335eb3d5af1f3d47bb753e1a047d4c886))
* update dependency com.google.cloud:google-cloud-bigquery to v2.11.2 ([#438](https://github.com/googleapis/java-retail/issues/438)) ([2d12e00](https://github.com/googleapis/java-retail/commit/2d12e005e537ecb20798ee84478b246cf646225e))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.12.0 ([#439](https://github.com/googleapis/java-retail/issues/439)) ([96103b8](https://github.com/googleapis/java-retail/commit/96103b8d22554bb5ab432b66556d6df884de2053))

### [2.0.19](https://github.com/googleapis/java-retail/compare/v2.0.18...v2.0.19) (2022-04-19)


### Documentation

* **samples:** the bash scripts for environment setup are added ([#392](https://github.com/googleapis/java-retail/issues/392)) ([a20b6fb](https://github.com/googleapis/java-retail/commit/a20b6fb321131074761d0e4277433eb3c86c7b7c))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v2.10.10 ([#407](https://github.com/googleapis/java-retail/issues/407)) ([ad0f7ad](https://github.com/googleapis/java-retail/commit/ad0f7ad434ef433991dfefcda9cba6a505a1f403))
* update dependency com.google.cloud:google-cloud-bigquery to v2.10.7 ([#402](https://github.com/googleapis/java-retail/issues/402)) ([89e94f5](https://github.com/googleapis/java-retail/commit/89e94f5446c9ad8b4866e50040c75b381671eacc))
* update dependency com.google.cloud:google-cloud-bigquery to v2.10.8 ([#403](https://github.com/googleapis/java-retail/issues/403)) ([12f61a1](https://github.com/googleapis/java-retail/commit/12f61a1ca19d15e1605984aa5bce25d6a0d63702))
* update dependency com.google.cloud:google-cloud-bigquery to v2.10.9 ([#405](https://github.com/googleapis/java-retail/issues/405)) ([6506ebc](https://github.com/googleapis/java-retail/commit/6506ebcd590b9056e2f4509341ac958635e2ac80))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.10.0 ([#404](https://github.com/googleapis/java-retail/issues/404)) ([269629d](https://github.com/googleapis/java-retail/commit/269629daccd231f9b395086146736575b64e01ae))
* update dependency com.google.cloud:google-cloud-storage to v2.6.1 ([#406](https://github.com/googleapis/java-retail/issues/406)) ([d35579c](https://github.com/googleapis/java-retail/commit/d35579c88ecbbdeb24ace6068c7d2782d8cd11fa))

### [2.0.18](https://github.com/googleapis/java-retail/compare/v2.0.17...v2.0.18) (2022-04-01)


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v2.10.5 ([#394](https://github.com/googleapis/java-retail/issues/394)) ([cc32c15](https://github.com/googleapis/java-retail/commit/cc32c1535e37e1ecfe143f59fb0ed08ca886445f))
* update dependency com.google.cloud:google-cloud-storage to v2.6.0 ([#391](https://github.com/googleapis/java-retail/issues/391)) ([e955b4b](https://github.com/googleapis/java-retail/commit/e955b4be6d06e4474ea3a67211c9e739086312f6))

### [2.0.17](https://github.com/googleapis/java-retail/compare/v2.0.16...v2.0.17) (2022-03-29)


### Documentation

* users can self enroll retail search feature on cloud console ([#377](https://github.com/googleapis/java-retail/issues/377)) ([783cb9e](https://github.com/googleapis/java-retail/commit/783cb9e32d617bf6cd2ce3aacc66b3d6eb920ce1))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v2.10.4 ([#382](https://github.com/googleapis/java-retail/issues/382)) ([c1de86a](https://github.com/googleapis/java-retail/commit/c1de86a6104582b93934a93419aae14f1a140417))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.9.0 ([#384](https://github.com/googleapis/java-retail/issues/384)) ([9854a34](https://github.com/googleapis/java-retail/commit/9854a342dd88a3d5f84126773dadaf429af8e4f0))
* update dependency com.google.cloud:google-cloud-storage to v2.5.0 ([#378](https://github.com/googleapis/java-retail/issues/378)) ([ab0d3a8](https://github.com/googleapis/java-retail/commit/ab0d3a8e916fc8651ac4bba3f5593b832c042567))
* update dependency com.google.cloud:google-cloud-storage to v2.5.1 ([#385](https://github.com/googleapis/java-retail/issues/385)) ([764f23f](https://github.com/googleapis/java-retail/commit/764f23f4b83e756eefe0a30dd6294f676efeccff))

### [2.0.16](https://github.com/googleapis/java-retail/compare/v2.0.15...v2.0.16) (2022-03-25)


### Dependencies

* update actions/checkout action to v3 ([#311](https://github.com/googleapis/java-retail/issues/311)) ([45f45c1](https://github.com/googleapis/java-retail/commit/45f45c1fbbbfb53843301bb42c9900f015a0c7e1))
* update dependency com.google.cloud:google-cloud-bigquery to v2.10.2 ([#375](https://github.com/googleapis/java-retail/issues/375)) ([3e4d951](https://github.com/googleapis/java-retail/commit/3e4d9510bab8ae8ab97e12bf1a37fd5040f30254))

### [2.0.15](https://github.com/googleapis/java-retail/compare/v2.0.14...v2.0.15) (2022-03-21)


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v2.10.1 ([#370](https://github.com/googleapis/java-retail/issues/370)) ([c9367d5](https://github.com/googleapis/java-retail/commit/c9367d51909f36427ed778ec8c4e582765e5e2ea))

### [2.0.14](https://github.com/googleapis/java-retail/compare/v2.0.13...v2.0.14) (2022-03-16)


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v2.10.0 ([#361](https://github.com/googleapis/java-retail/issues/361)) ([34fb542](https://github.com/googleapis/java-retail/commit/34fb5428fcbeb23776d506630b340a1a4df7dffb))

### [2.0.13](https://github.com/googleapis/java-retail/compare/v2.0.12...v2.0.13) (2022-03-09)


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v2.9.4 ([#351](https://github.com/googleapis/java-retail/issues/351)) ([2685a82](https://github.com/googleapis/java-retail/commit/2685a8204114658de54981a84ab297a6a5b87cbb))
* update dependency com.google.cloud:google-cloud-storage to v2.4.5 ([#329](https://github.com/googleapis/java-retail/issues/329)) ([002a240](https://github.com/googleapis/java-retail/commit/002a2400b5fb7e1c4947915fe9b1ab8adbb5e30a))

### [2.0.12](https://github.com/googleapis/java-retail/compare/v2.0.11...v2.0.12) (2022-03-08)


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v2.9.3 ([#322](https://github.com/googleapis/java-retail/issues/322)) ([571af55](https://github.com/googleapis/java-retail/commit/571af55e64f10d4b0b9f6f58d2806b10eed1f60c))
* update dependency com.google.cloud:google-cloud-storage to v2.4.4 ([#323](https://github.com/googleapis/java-retail/issues/323)) ([bbd9526](https://github.com/googleapis/java-retail/commit/bbd952667da77bbf601d929f881ea9968d09398f))
* update dependency com.google.code.gson:gson to v2.9.0 ([#324](https://github.com/googleapis/java-retail/issues/324)) ([f0c348d](https://github.com/googleapis/java-retail/commit/f0c348d1d407c80b9553c850a94998d54d3e05f5))

### [2.0.11](https://github.com/googleapis/java-retail/compare/v2.0.10...v2.0.11) (2022-03-02)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.8.0 ([#313](https://github.com/googleapis/java-retail/issues/313)) ([b64721b](https://github.com/googleapis/java-retail/commit/b64721bbeb6a4625e305589c96b23443a48a2baa))

### [2.0.10](https://github.com/googleapis/java-retail/compare/v2.0.9...v2.0.10) (2022-02-28)


### Dependencies

* update actions/setup-java action to v3 ([#306](https://github.com/googleapis/java-retail/issues/306)) ([a506bcb](https://github.com/googleapis/java-retail/commit/a506bcbf4d982ef35be1f0914c9cce46c441cbe8))

### [2.0.9](https://github.com/googleapis/java-retail/compare/v2.0.8...v2.0.9) (2022-02-11)


### Dependencies

* update actions/github-script action to v6 ([#292](https://github.com/googleapis/java-retail/issues/292)) ([f512efd](https://github.com/googleapis/java-retail/commit/f512efd91cf6cfece63a2bfbcdfcdcb6fb68c1db))

### [2.0.8](https://github.com/googleapis/java-retail/compare/v2.0.7...v2.0.8) (2022-02-03)


### Dependencies

* **java:** update actions/github-script action to v5 ([#1339](https://github.com/googleapis/java-retail/issues/1339)) ([#272](https://github.com/googleapis/java-retail/issues/272)) ([14ba816](https://github.com/googleapis/java-retail/commit/14ba816df244116263397c8da9b2a18b4c7f43d3))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.7.0 ([#275](https://github.com/googleapis/java-retail/issues/275)) ([51a2492](https://github.com/googleapis/java-retail/commit/51a2492e4b862af408999ff5473984299e0b68a1))

### [2.0.7](https://www.github.com/googleapis/java-retail/compare/v2.0.6...v2.0.7) (2022-01-07)


### Bug Fixes

* **java:** add -ntp flag to native image testing command ([#1299](https://www.github.com/googleapis/java-retail/issues/1299)) ([#250](https://www.github.com/googleapis/java-retail/issues/250)) ([dd942ab](https://www.github.com/googleapis/java-retail/commit/dd942ab9d8efd582f5c83c259c5ca6e0225c88a5))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.6.0 ([#258](https://www.github.com/googleapis/java-retail/issues/258)) ([81f1a09](https://www.github.com/googleapis/java-retail/commit/81f1a0936e779e67d39aa4d68f19b99bea90a819))

### [2.0.6](https://www.github.com/googleapis/java-retail/compare/v2.0.5...v2.0.6) (2021-12-03)


### Bug Fixes

* **java:** java 17 dependency arguments ([#1266](https://www.github.com/googleapis/java-retail/issues/1266)) ([#233](https://www.github.com/googleapis/java-retail/issues/233)) ([c1f98d1](https://www.github.com/googleapis/java-retail/commit/c1f98d13edcd946b607e73a1328cbe2b9b827ecc))


### Documentation

* fix docstring formatting ([#234](https://www.github.com/googleapis/java-retail/issues/234)) ([510d7b6](https://www.github.com/googleapis/java-retail/commit/510d7b6bb87811fac75ad4c18c620672fdd1b9b7))
* Keep the API doc up-to-date ([#226](https://www.github.com/googleapis/java-retail/issues/226)) ([49dbdde](https://www.github.com/googleapis/java-retail/commit/49dbddea8144fad949b6d2a21f391057e68e3bc0))
* Keep the API doc up-to-date feat: update grpc service config settings to reflect correct API deadlines ([#246](https://www.github.com/googleapis/java-retail/issues/246)) ([328e806](https://www.github.com/googleapis/java-retail/commit/328e80629af57988001dab68aacd896f1fbc2804))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.5.0 ([#243](https://www.github.com/googleapis/java-retail/issues/243)) ([dd2e912](https://www.github.com/googleapis/java-retail/commit/dd2e9122a32c389e0a19480691c968523932c333))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.5.1 ([#249](https://www.github.com/googleapis/java-retail/issues/249)) ([b0b527a](https://www.github.com/googleapis/java-retail/commit/b0b527afed836af846dcef83d374d9be3ac62ca9))

### [2.0.5](https://www.github.com/googleapis/java-retail/compare/v2.0.4...v2.0.5) (2021-10-20)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.4.0 ([#227](https://www.github.com/googleapis/java-retail/issues/227)) ([81a2c7b](https://www.github.com/googleapis/java-retail/commit/81a2c7b17087a7260e0191b8800bc0c6a0bfd736))

### [2.0.4](https://www.github.com/googleapis/java-retail/compare/v2.0.3...v2.0.4) (2021-09-23)


### Documentation

* Keep the API doc up-to-date ([#193](https://www.github.com/googleapis/java-retail/issues/193)) ([c5570be](https://www.github.com/googleapis/java-retail/commit/c5570bee6912cfe59d93aae069cf6c0a8e3ef199))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.3.0 ([#211](https://www.github.com/googleapis/java-retail/issues/211)) ([029663e](https://www.github.com/googleapis/java-retail/commit/029663eae531dffb3dbf563bc84f5413ba3dcc4d))

### [2.0.3](https://www.github.com/googleapis/java-retail/compare/v2.0.2...v2.0.3) (2021-09-14)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.2.1 ([#203](https://www.github.com/googleapis/java-retail/issues/203)) ([6a9e7c6](https://www.github.com/googleapis/java-retail/commit/6a9e7c65b80fa09a18d2bf5f5ea9c803c87041a9))

### [2.0.2](https://www.github.com/googleapis/java-retail/compare/v2.0.1...v2.0.2) (2021-09-01)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.2.0 ([#188](https://www.github.com/googleapis/java-retail/issues/188)) ([198b273](https://www.github.com/googleapis/java-retail/commit/198b2734ea2cef43c9b9662cbdb6b4f9251c895c))

### [2.0.1](https://www.github.com/googleapis/java-retail/compare/v2.0.0...v2.0.1) (2021-08-23)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.1.0 ([#180](https://www.github.com/googleapis/java-retail/issues/180)) ([266e881](https://www.github.com/googleapis/java-retail/commit/266e881ce869e216e98530679b803dcd487b77ef))

## [2.0.0](https://www.github.com/googleapis/java-retail/compare/v1.2.1...v2.0.0) (2021-08-12)


### ⚠ BREAKING CHANGES

* release gapic-generator-java v2.0.0 (#169)

### Features

* release gapic-generator-java v2.0.0 ([#169](https://www.github.com/googleapis/java-retail/issues/169)) ([0134460](https://www.github.com/googleapis/java-retail/commit/01344601a46bb54597564cb7d10670e8d99fd47b))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.0.1 ([#170](https://www.github.com/googleapis/java-retail/issues/170)) ([dbdbd64](https://www.github.com/googleapis/java-retail/commit/dbdbd64f15166bb3585e25cd96df787a34b3ae98))


### Documentation

* Remove HTML tags from Cloud Retail API library docs ([0134460](https://www.github.com/googleapis/java-retail/commit/01344601a46bb54597564cb7d10670e8d99fd47b))
* **retail:** Quote several literal expressions for better rendering ([0134460](https://www.github.com/googleapis/java-retail/commit/01344601a46bb54597564cb7d10670e8d99fd47b))

### [1.2.1](https://www.github.com/googleapis/java-retail/compare/v1.2.0...v1.2.1) (2021-08-10)


### Documentation

* remove remaining private links ([#159](https://www.github.com/googleapis/java-retail/issues/159)) ([ec44deb](https://www.github.com/googleapis/java-retail/commit/ec44deba3072f4c7043e051690c4fb37bb535864))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2 ([#161](https://www.github.com/googleapis/java-retail/issues/161)) ([0004c12](https://www.github.com/googleapis/java-retail/commit/0004c12c593e0d40f9b72abff6dc4d0a54d9d9c7))

## [1.2.0](https://www.github.com/googleapis/java-retail/compare/v1.1.2...v1.2.0) (2021-07-30)


### Features

* **v2:** add restricted Retail Search features ([#150](https://www.github.com/googleapis/java-retail/issues/150)) ([a9aedea](https://www.github.com/googleapis/java-retail/commit/a9aedeabd7903db8ca3bbc46fe8ece674590cd77))

### [1.1.2](https://www.github.com/googleapis/java-retail/compare/v1.1.1...v1.1.2) (2021-07-01)


### Bug Fixes

* Add `shopt -s nullglob` to dependencies script ([#136](https://www.github.com/googleapis/java-retail/issues/136)) ([453eab9](https://www.github.com/googleapis/java-retail/commit/453eab9120265d4f965ff1057c4b6afadac6c7d8))
* Update dependencies.sh to not break on mac ([#132](https://www.github.com/googleapis/java-retail/issues/132)) ([af58fc2](https://www.github.com/googleapis/java-retail/commit/af58fc222938aa55ec664cf065bd12f533674eb1))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.4.0 ([#137](https://www.github.com/googleapis/java-retail/issues/137)) ([eb6b413](https://www.github.com/googleapis/java-retail/commit/eb6b4134e9b2a7288c7127201e05a107d7d4e962))

### [1.1.1](https://www.github.com/googleapis/java-retail/compare/v1.1.0...v1.1.1) (2021-06-04)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.3.0 ([#123](https://www.github.com/googleapis/java-retail/issues/123)) ([eee38c5](https://www.github.com/googleapis/java-retail/commit/eee38c51a201901e6eb872c3029f5434af6b85d7))

## [1.1.0](https://www.github.com/googleapis/java-retail/compare/v1.0.3...v1.1.0) (2021-05-31)


### Features

* add `gcf-owl-bot[bot]` to `ignoreAuthors` ([#112](https://www.github.com/googleapis/java-retail/issues/112)) ([bad144d](https://www.github.com/googleapis/java-retail/commit/bad144d492edd2ad99171169971c399772bbe0c6))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.2.0 ([#111](https://www.github.com/googleapis/java-retail/issues/111)) ([e885558](https://www.github.com/googleapis/java-retail/commit/e885558f6171195c586ad6e06a34fd877c00fda4))

### [1.0.3](https://www.github.com/googleapis/java-retail/compare/v1.0.2...v1.0.3) (2021-05-14)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.1.0 ([#104](https://www.github.com/googleapis/java-retail/issues/104)) ([3c85c8f](https://www.github.com/googleapis/java-retail/commit/3c85c8fa37977748cdef93e982d0ebf4b865c2b2))

### [1.0.2](https://www.github.com/googleapis/java-retail/compare/v1.0.1...v1.0.2) (2021-04-24)


### Bug Fixes

* release scripts from issuing overlapping phases ([#90](https://www.github.com/googleapis/java-retail/issues/90)) ([83796e2](https://www.github.com/googleapis/java-retail/commit/83796e2b12a4b1ff2d09d4e18d7008ccc9acd0f6))
* typo ([#87](https://www.github.com/googleapis/java-retail/issues/87)) ([f3176fe](https://www.github.com/googleapis/java-retail/commit/f3176fe4430fdc81b29b231ec74c6ad7169676bb))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.21.1 ([#91](https://www.github.com/googleapis/java-retail/issues/91)) ([9b6a29d](https://www.github.com/googleapis/java-retail/commit/9b6a29de7e087cb42a1ecf461c2341bc2d8ae985))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1 ([#94](https://www.github.com/googleapis/java-retail/issues/94)) ([1e0f975](https://www.github.com/googleapis/java-retail/commit/1e0f975715227decfc0bb2802b735bded51c92a5))

### [1.0.1](https://www.github.com/googleapis/java-retail/compare/v1.0.0...v1.0.1) (2021-04-09)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.21.0 ([#76](https://www.github.com/googleapis/java-retail/issues/76)) ([cac5274](https://www.github.com/googleapis/java-retail/commit/cac527450b5e047dbe5b9f943fa1f1aea77bc209))

## [1.0.0](https://www.github.com/googleapis/java-retail/compare/v0.2.1...v1.0.0) (2021-04-09)


### Features

* **generator:** update protoc to v3.15.3 ([#60](https://www.github.com/googleapis/java-retail/issues/60)) ([97118ec](https://www.github.com/googleapis/java-retail/commit/97118ec9a7f9c030191d132a80a637aea33a3fde))
* promote to 1.0.0 ([#74](https://www.github.com/googleapis/java-retail/issues/74)) ([5603176](https://www.github.com/googleapis/java-retail/commit/5603176e8683962b1677ca5f77fd4dc5bc125d91))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.20.1 ([#66](https://www.github.com/googleapis/java-retail/issues/66)) ([1433926](https://www.github.com/googleapis/java-retail/commit/1433926dd30e6ac2e30a98556d33ac5968bc4ec7))

### [0.2.1](https://www.github.com/googleapis/java-retail/compare/v0.2.0...v0.2.1) (2021-02-25)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.20.0 ([#54](https://www.github.com/googleapis/java-retail/issues/54)) ([f04501f](https://www.github.com/googleapis/java-retail/commit/f04501fdac508979e2bc5c575a012ad3ba14098c))

## [0.2.0](https://www.github.com/googleapis/java-retail/compare/v0.1.1...v0.2.0) (2021-02-25)


### Features

* generate sample code in the Java microgenerator ([#41](https://www.github.com/googleapis/java-retail/issues/41)) ([45ecc84](https://www.github.com/googleapis/java-retail/commit/45ecc842a347a5078a86aa2e4a5de7c8ca2e014e))


### Documentation

* Put resource paths in code spans and use absolute URLs ([#27](https://www.github.com/googleapis/java-retail/issues/27)) ([d21a378](https://www.github.com/googleapis/java-retail/commit/d21a378edeb5b4ed5822aa9fc1d9af2cd71bcf33))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.19.0 ([#50](https://www.github.com/googleapis/java-retail/issues/50)) ([0ca8a72](https://www.github.com/googleapis/java-retail/commit/0ca8a72b896d63d2da372684c7fbaf502018afbc))

### [0.1.1](https://www.github.com/googleapis/java-retail/compare/v0.1.0...v0.1.1) (2021-01-14)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.18.0 ([#22](https://www.github.com/googleapis/java-retail/issues/22)) ([6fec0f0](https://www.github.com/googleapis/java-retail/commit/6fec0f0c19c0b931a45a263abee99634ba787cd3))

## 0.1.0 (2021-01-05)


### Features

* initial code generation ([d946135](https://www.github.com/googleapis/java-retail/commit/d94613560cd813173d22574c5fd301f95c7d3de7))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.17.0 ([#5](https://www.github.com/googleapis/java-retail/issues/5)) ([22eb70e](https://www.github.com/googleapis/java-retail/commit/22eb70e2289f7abb5469f0c08e4d3d8a662b83ff))
