# Changelog

## [1.105.0](https://www.github.com/googleapis/java-bigquery/compare/v1.104.0...v1.105.0) (2020-01-28)


### Features

* add new sample - Load: Column Based Time Partitioning ([#119](https://www.github.com/googleapis/java-bigquery/issues/119)) ([6e1eef6](https://www.github.com/googleapis/java-bigquery/commit/6e1eef6124108371b89137529f1c42a1a1d16578))
* add new sample - Tables: Relax column query append ([#115](https://www.github.com/googleapis/java-bigquery/issues/115)) ([1a1480f](https://www.github.com/googleapis/java-bigquery/commit/1a1480f5079c964dd492126557742340e0b6ef6e))
* new sample - Get Model ([#124](https://www.github.com/googleapis/java-bigquery/issues/124)) ([a03670b](https://www.github.com/googleapis/java-bigquery/commit/a03670b3ba19c7805712f09754435e422228abd6))
* new sample - Models: List model resources contained in a dataset ([#125](https://www.github.com/googleapis/java-bigquery/issues/125)) ([3a62206](https://www.github.com/googleapis/java-bigquery/commit/3a62206639f50e9d4ae18cc407303cad0c4a6ddb))


### Bug Fixes

* **debug:** add debug statement to StandardTableDefinition ([#128](https://www.github.com/googleapis/java-bigquery/issues/128)) ([0d4092d](https://www.github.com/googleapis/java-bigquery/commit/0d4092d6ee864d84705819305d045ce89aba8149))


### Dependencies

* update core transport dependencies to v1.34.1 ([#129](https://www.github.com/googleapis/java-bigquery/issues/129)) ([fbbba31](https://www.github.com/googleapis/java-bigquery/commit/fbbba31d67b7670115333a123aabcba77dbd9ad3))

## [1.104.0](https://www.github.com/googleapis/java-bigquery/compare/v1.103.0...v1.104.0) (2020-01-23)


### Features

* add new sample - Table: Create clustered table ([#120](https://www.github.com/googleapis/java-bigquery/issues/120)) ([93f6cc2](https://www.github.com/googleapis/java-bigquery/commit/93f6cc24b77d3492361b4e026fbe6b639f373a12))
* add range partitioning field to tableslist ([#114](https://www.github.com/googleapis/java-bigquery/issues/114)) ([069240f](https://www.github.com/googleapis/java-bigquery/commit/069240fc4ebfc54d39d84fc3a9cc31d093cfa70a))
* new sample - load: GCS parquet replace existing table ([#101](https://www.github.com/googleapis/java-bigquery/issues/101)) ([c423c91](https://www.github.com/googleapis/java-bigquery/commit/c423c91f7689bfc29a94b452842077e2622c621a))
* new sample - Query: Clustered Table ([#121](https://www.github.com/googleapis/java-bigquery/issues/121)) ([df59cc7](https://www.github.com/googleapis/java-bigquery/commit/df59cc70c9507bf65781118a1938e5fd4701bb83))
* new sample - Table: Column Based Time Partitioning ([#118](https://www.github.com/googleapis/java-bigquery/issues/118)) ([eafa6ba](https://www.github.com/googleapis/java-bigquery/commit/eafa6ba8224aec093836e1a7d85ec32176ad7475))
* new sample - Tables: Delete table ([#90](https://www.github.com/googleapis/java-bigquery/issues/90)) ([8a1caa6](https://www.github.com/googleapis/java-bigquery/commit/8a1caa64d139c937e3e2d2dfc10a64e87c240ddc))
* new sample - Tables: Relax column ([#89](https://www.github.com/googleapis/java-bigquery/issues/89)) ([6f95631](https://www.github.com/googleapis/java-bigquery/commit/6f9563160670a7cd2a75afe9774e91180c867206))
* sample - add col load append ([#112](https://www.github.com/googleapis/java-bigquery/issues/112)) ([833b953](https://www.github.com/googleapis/java-bigquery/commit/833b953aad618e88089c7e3487416c5650cc2ccc))
* sample - Get dataset properties ([#98](https://www.github.com/googleapis/java-bigquery/issues/98)) ([743bc0a](https://www.github.com/googleapis/java-bigquery/commit/743bc0a552875b773becbd517a063e29193a6b49))
* sample - query with named params ([#116](https://www.github.com/googleapis/java-bigquery/issues/116)) ([ecec2f7](https://www.github.com/googleapis/java-bigquery/commit/ecec2f73fb43311538e92944341fed51c199cde0))
* sample - query with positional params ([#117](https://www.github.com/googleapis/java-bigquery/issues/117)) ([a5df219](https://www.github.com/googleapis/java-bigquery/commit/a5df219186d80e86d61c13aef6b052fe726a5df6))
* sample - run a legacy SQL query ([#97](https://www.github.com/googleapis/java-bigquery/issues/97)) ([7fedacd](https://www.github.com/googleapis/java-bigquery/commit/7fedacdc5c924de8b25aac59d00018704e0d5af8))


### Dependencies

* update core dependencies ([#107](https://www.github.com/googleapis/java-bigquery/issues/107)) ([bd3a862](https://www.github.com/googleapis/java-bigquery/commit/bd3a862c37b6d8d899ba3443e90a6eed53a70dd4))
* update core dependencies ([#93](https://www.github.com/googleapis/java-bigquery/issues/93)) ([f95b179](https://www.github.com/googleapis/java-bigquery/commit/f95b1798f6a09ff03b195ae7540f9395386c0ea5))
* update dependency com.google.apis:google-api-services-bigquery to v2-rev20191211-1.30.3 ([#105](https://www.github.com/googleapis/java-bigquery/issues/105)) ([8eedb54](https://www.github.com/googleapis/java-bigquery/commit/8eedb5490f78333c9af97279a68120850c057f2a))
* update dependency com.google.cloud:libraries-bom to v3.3.0 ([#108](https://www.github.com/googleapis/java-bigquery/issues/108)) ([c15afb9](https://www.github.com/googleapis/java-bigquery/commit/c15afb9459896790d11d4f3c7e5473104eb6bea8))
* update dependency com.google.cloud:libraries-bom to v3.4.0 ([#113](https://www.github.com/googleapis/java-bigquery/issues/113)) ([772516a](https://www.github.com/googleapis/java-bigquery/commit/772516ae174e75c93894a1283e446095bc1e398b))
* update dependency com.google.truth:truth to v1.0.1 ([#103](https://www.github.com/googleapis/java-bigquery/issues/103)) ([f41a53c](https://www.github.com/googleapis/java-bigquery/commit/f41a53c33942cba59242f515906ec57503549122))
* update dependency junit:junit to v4.13 ([#109](https://www.github.com/googleapis/java-bigquery/issues/109)) ([c36a547](https://www.github.com/googleapis/java-bigquery/commit/c36a547bd2c75da48571fd3f6f91d33a590f9744))
* update dependency org.threeten:threetenbp to v1.4.1 ([88b420e](https://www.github.com/googleapis/java-bigquery/commit/88b420ea817807bdbe25f803f98352fa5a7d6ba4))

## [1.103.0](https://www.github.com/googleapis/java-bigquery/compare/1.102.0...v1.103.0) (2020-01-08)


### Features

* add kokoro jobs for samples module ([#61](https://www.github.com/googleapis/java-bigquery/issues/61)) ([f59dbf4](https://www.github.com/googleapis/java-bigquery/commit/f59dbf439788137ae4fe5215687c47b287b64ab9))
* add samples ([#44](https://www.github.com/googleapis/java-bigquery/issues/44)) ([d3e5e12](https://www.github.com/googleapis/java-bigquery/commit/d3e5e12f2dfa6524ed2311df1449a5ea7a1fc2e1))
* add StandardSQLTypeName factory methods to Field ([#43](https://www.github.com/googleapis/java-bigquery/issues/43)) ([9b37941](https://www.github.com/googleapis/java-bigquery/commit/9b379413e9e5850060d0fbd02ab9797c574f9a44))
* migrate bigquery from google-cloud-java, add bom ([#3](https://www.github.com/googleapis/java-bigquery/issues/3)) ([91b79f6](https://www.github.com/googleapis/java-bigquery/commit/91b79f608ad4743f895c3f9324153cb70065a28c))
* migrate BQ Java samples from java-docs-samples to client lib ([#22](https://www.github.com/googleapis/java-bigquery/issues/22)) ([f0bdc4d](https://www.github.com/googleapis/java-bigquery/commit/f0bdc4dda5d2078dbf2ef84d7f7bbe09561504a8))
* new sample - Tables: Add empty column ([#85](https://www.github.com/googleapis/java-bigquery/issues/85)) ([b8e4c18](https://www.github.com/googleapis/java-bigquery/commit/b8e4c1845c43b96b40cbebb0016c987919f781fe))
* new sample - Tables: Copy multiple tables ([#76](https://www.github.com/googleapis/java-bigquery/issues/76)) ([2476419](https://www.github.com/googleapis/java-bigquery/commit/2476419df9be7b2f52cdd098383c0622c669d046))
* remove unused bom from project ([#37](https://www.github.com/googleapis/java-bigquery/issues/37)) ([c534e75](https://www.github.com/googleapis/java-bigquery/commit/c534e7588dcce120d413fce58794f8b31efce6ba))
* update samples ([#52](https://www.github.com/googleapis/java-bigquery/issues/52)) ([ac9f589](https://www.github.com/googleapis/java-bigquery/commit/ac9f5899ae44e81887e8b4b0d3f6229e942f8d54))
* use libraries-bom for samples ([#38](https://www.github.com/googleapis/java-bigquery/issues/38)) ([f519da2](https://www.github.com/googleapis/java-bigquery/commit/f519da2034586f28de87dbb01ee920d0eb737fa3))


### Bug Fixes

* parentjobid in listjobs ([#20](https://www.github.com/googleapis/java-bigquery/issues/20)) ([1b0b21b](https://www.github.com/googleapis/java-bigquery/commit/1b0b21b7dae97507bfcb449ed78fabff636747f5))


### Dependencies

* re-generated  to pick up changes in the API or client library generator. ([#36](https://www.github.com/googleapis/java-bigquery/issues/36)) ([1712195](https://www.github.com/googleapis/java-bigquery/commit/1712195900c65be051a94e3ab143e4289a287f34))
* update core dependencies to v1.92.1 ([#66](https://www.github.com/googleapis/java-bigquery/issues/66)) ([9c48bb6](https://www.github.com/googleapis/java-bigquery/commit/9c48bb6bc6ae78338e1b14e0508ab524c24978f3))
* update dependencies ([#46](https://www.github.com/googleapis/java-bigquery/issues/46)) ([fd8ce1a](https://www.github.com/googleapis/java-bigquery/commit/fd8ce1ad6fc8e485b568d65ff6f2cd404a0aec91)), closes [#31](https://www.github.com/googleapis/java-bigquery/issues/31) [#35](https://www.github.com/googleapis/java-bigquery/issues/35) [#30](https://www.github.com/googleapis/java-bigquery/issues/30)
* update dependency com.google.cloud:google-cloud-storage to v1.103.0 ([#80](https://www.github.com/googleapis/java-bigquery/issues/80)) ([70c2bbb](https://www.github.com/googleapis/java-bigquery/commit/70c2bbb9eba99e60b958c231e36e09436f9ec624))
* update dependency com.google.guava:guava-bom to v28.2-android ([866659a](https://www.github.com/googleapis/java-bigquery/commit/866659a6e6fd5ee87135552a5798b04b0ad4e87b))
* update dependency com.google.http-client:google-http-client to v1.33.0 ([#8](https://www.github.com/googleapis/java-bigquery/issues/8)) ([d4e28cf](https://www.github.com/googleapis/java-bigquery/commit/d4e28cfcbf71e0ca6037e420b84f7b9dfdcf3be2))
* update dependency com.google.http-client:google-http-client-jackson2 to v1.33.0 ([#9](https://www.github.com/googleapis/java-bigquery/issues/9)) ([ec4a6eb](https://www.github.com/googleapis/java-bigquery/commit/ec4a6ebbf03f1c6ac51027e63f0e198222a830b6))
* update dependency io.grpc:grpc-bom to v1.26.0 ([#49](https://www.github.com/googleapis/java-bigquery/issues/49)) ([3f213c2](https://www.github.com/googleapis/java-bigquery/commit/3f213c29ebc437ec79c04553db8b2675efb3aa54))
* update dependency junit:junit to v4.13 ([#63](https://www.github.com/googleapis/java-bigquery/issues/63)) ([f52e42e](https://www.github.com/googleapis/java-bigquery/commit/f52e42ec5cc55eaaa6b257fcea8eef99f15628cf))


### Documentation

* Update libraries-bom version ([#73](https://www.github.com/googleapis/java-bigquery/issues/73)) ([e967e10](https://www.github.com/googleapis/java-bigquery/commit/e967e10267514dfbac7013cac61f22b74d52b2b8))
