# Changelog

### [1.126.4](https://www.github.com/googleapis/java-bigquery/compare/v1.126.3...v1.126.4) (2021-01-12)


### Dependencies

* update dependency com.google.cloud:google-cloud-bigtable to v1.19.2 ([#1035](https://www.github.com/googleapis/java-bigquery/issues/1035)) ([239975b](https://www.github.com/googleapis/java-bigquery/commit/239975b318e513c93fdf42a2699bb019089459ed))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.17.1 ([#1056](https://www.github.com/googleapis/java-bigquery/issues/1056)) ([be89a1b](https://www.github.com/googleapis/java-bigquery/commit/be89a1bffcd59d0b171dde86f118714a4ba31d08))
* update dependency com.google.cloud:google-cloud-storage to v1.113.8 ([#1046](https://www.github.com/googleapis/java-bigquery/issues/1046)) ([c3e9348](https://www.github.com/googleapis/java-bigquery/commit/c3e934809eddfdf6e191f50acf97e8670a80865b))
* update dependency com.google.oauth-client:google-oauth-client-jetty to v1.31.4 ([#1055](https://www.github.com/googleapis/java-bigquery/issues/1055)) ([8dd66e6](https://www.github.com/googleapis/java-bigquery/commit/8dd66e69c78febb00aa2f8f9028817f6d4735e79))

### [1.126.3](https://www.github.com/googleapis/java-bigquery/compare/v1.126.2...v1.126.3) (2020-12-15)


### Dependencies

* update dependency com.google.cloud:google-cloud-bigtable to v1.19.1 ([#1025](https://www.github.com/googleapis/java-bigquery/issues/1025)) ([1c6e90d](https://www.github.com/googleapis/java-bigquery/commit/1c6e90d9e2fe13d99ab7fe1c9999c6050371a5d9))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.17.0 ([#1026](https://www.github.com/googleapis/java-bigquery/issues/1026)) ([12e2c38](https://www.github.com/googleapis/java-bigquery/commit/12e2c382f6749c3baa54119e404725eea58da907))

### [1.126.2](https://www.github.com/googleapis/java-bigquery/compare/v1.126.1...v1.126.2) (2020-12-14)


### Documentation

* **samples:** add missing region tag ([#1014](https://www.github.com/googleapis/java-bigquery/issues/1014)) ([1999950](https://www.github.com/googleapis/java-bigquery/commit/1999950da0e784b72c4dbe749ceb56d750cea1b3))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.16.1 ([#1020](https://www.github.com/googleapis/java-bigquery/issues/1020)) ([aa52928](https://www.github.com/googleapis/java-bigquery/commit/aa5292844fc64642b32a4a823338acf8e61549b0))
* update dependency com.google.cloud:google-cloud-storage to v1.113.6 ([#1017](https://www.github.com/googleapis/java-bigquery/issues/1017)) ([b62e8f2](https://www.github.com/googleapis/java-bigquery/commit/b62e8f208ae4741e7ba6df41c6c90a8192f84aee))

### [1.126.1](https://www.github.com/googleapis/java-bigquery/compare/v1.126.0...v1.126.1) (2020-12-09)


### Dependencies

* update dependency com.google.cloud:google-cloud-storage to v1.113.5 ([#1007](https://www.github.com/googleapis/java-bigquery/issues/1007)) ([479ae98](https://www.github.com/googleapis/java-bigquery/commit/479ae98a22df32d257d13ef7d9aad4888ddacfdf))

## [1.126.0](https://www.github.com/googleapis/java-bigquery/compare/v1.125.2...v1.126.0) (2020-12-05)


### Features

* set requestId for fast query path in QueryRequestInfo instead of QueryJobConfiguration ([#987](https://www.github.com/googleapis/java-bigquery/issues/987)) ([e2cd4f6](https://www.github.com/googleapis/java-bigquery/commit/e2cd4f63ccc543e144f90e06eaadb2e96ce94943))

### [1.125.2](https://www.github.com/googleapis/java-bigquery/compare/v1.125.1...v1.125.2) (2020-12-04)


### Dependencies

* update dependency com.google.apis:google-api-services-bigquery to v2-rev20201030-1.31.0 ([#995](https://www.github.com/googleapis/java-bigquery/issues/995)) ([8968b44](https://www.github.com/googleapis/java-bigquery/commit/8968b44ceb9fa9a199257a5cb8434069d4fdc4b6))
* update dependency com.google.cloud:google-cloud-bigtable to v1.19.0 ([#993](https://www.github.com/googleapis/java-bigquery/issues/993)) ([fc87746](https://www.github.com/googleapis/java-bigquery/commit/fc8774698be60ea567a4d0be5cc3c2a57a75bd99))

### [1.125.1](https://www.github.com/googleapis/java-bigquery/compare/v1.125.0...v1.125.1) (2020-12-02)


### Bug Fixes

* update listPartitions() to support tables from other projects ([#974](https://www.github.com/googleapis/java-bigquery/issues/974)) ([1739d57](https://www.github.com/googleapis/java-bigquery/commit/1739d57c59cfb6b90ccf3fcc9c07d1449fc17238))


### Documentation

* **samples:** add alter materialized view ([#979](https://www.github.com/googleapis/java-bigquery/issues/979)) ([37c0632](https://www.github.com/googleapis/java-bigquery/commit/37c0632500366006aecab18b21a10bf8956c4b6c))
* **samples:** add create external table using hivepartitioningoptions ([#969](https://www.github.com/googleapis/java-bigquery/issues/969)) ([3994be6](https://www.github.com/googleapis/java-bigquery/commit/3994be62b63b4b56944499c10b42d77ced4ab33c))
* **samples:** add create iam policy for table ([#975](https://www.github.com/googleapis/java-bigquery/issues/975)) ([0cfc98b](https://www.github.com/googleapis/java-bigquery/commit/0cfc98bffc9970d3275cc233d59c621ddbb6aea6))
* **samples:** add create materialized view ([#977](https://www.github.com/googleapis/java-bigquery/issues/977)) ([155e688](https://www.github.com/googleapis/java-bigquery/commit/155e6882aebdb4ac93e1e78baac0579ca7e11bd1))
* **samples:** add delete materialized view ([#980](https://www.github.com/googleapis/java-bigquery/issues/980)) ([022cb99](https://www.github.com/googleapis/java-bigquery/commit/022cb99b486d27c91f478353ab47df4b8e184e4a))
* **samples:** add export model ([#970](https://www.github.com/googleapis/java-bigquery/issues/970)) ([2edad15](https://www.github.com/googleapis/java-bigquery/commit/2edad15764f144268f1bd3052d1d0ac069a2f377))
* **samples:** add query materialized view ([#978](https://www.github.com/googleapis/java-bigquery/issues/978)) ([cf36b82](https://www.github.com/googleapis/java-bigquery/commit/cf36b82ef9bc0849a87b717c099321915a76b967))
* **samples:** add update iam policy for table ([#976](https://www.github.com/googleapis/java-bigquery/issues/976)) ([aeecac9](https://www.github.com/googleapis/java-bigquery/commit/aeecac905911dbe1ee534f0e5eeef2705a0cb6b3))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigtable to v1.18.1 ([#989](https://www.github.com/googleapis/java-bigquery/issues/989)) ([bbf4fe2](https://www.github.com/googleapis/java-bigquery/commit/bbf4fe2565b1676567f28d720b255696328c08cc))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.16.0 ([#988](https://www.github.com/googleapis/java-bigquery/issues/988)) ([3cc0d94](https://www.github.com/googleapis/java-bigquery/commit/3cc0d94888f649a16495f66e80ebf95093730b1a))

## [1.125.0](https://www.github.com/googleapis/java-bigquery/compare/v1.124.7...v1.125.0) (2020-11-19)


### Features

* add BIGNUMERIC support ([#703](https://www.github.com/googleapis/java-bigquery/issues/703)) ([718ec2a](https://www.github.com/googleapis/java-bigquery/commit/718ec2ae25150dceef8fb9bc3e2fcf6238fc2220))

### [1.124.7](https://www.github.com/googleapis/java-bigquery/compare/v1.124.6...v1.124.7) (2020-11-16)


### Dependencies

* update dependency com.google.cloud:google-cloud-bigtable to v1.18.0 ([#949](https://www.github.com/googleapis/java-bigquery/issues/949)) ([6adc55f](https://www.github.com/googleapis/java-bigquery/commit/6adc55f1f3277cc3bdac8d98069dc0dab8744d39))
* update dependency com.google.cloud:google-cloud-storage to v1.113.4 ([#951](https://www.github.com/googleapis/java-bigquery/issues/951)) ([5fddfad](https://www.github.com/googleapis/java-bigquery/commit/5fddfad89049c706b5c1b2bc092da498f8c5e5a6))

### [1.124.6](https://www.github.com/googleapis/java-bigquery/compare/v1.124.5...v1.124.6) (2020-11-13)


### Bug Fixes

* make sure to fall back to old query path when query job is incomplete ([#941](https://www.github.com/googleapis/java-bigquery/issues/941)) ([bd7d85c](https://www.github.com/googleapis/java-bigquery/commit/bd7d85c489cd260feeabbdc9ecbb8dcdc8d9ae77))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigtable to v1.17.3 ([#936](https://www.github.com/googleapis/java-bigquery/issues/936)) ([0b34a50](https://www.github.com/googleapis/java-bigquery/commit/0b34a5095b2bad4ac02b3d40937dd1a3ab3f2154))

### [1.124.5](https://www.github.com/googleapis/java-bigquery/compare/v1.124.4...v1.124.5) (2020-11-11)


### Dependencies

* update dependency com.google.cloud:google-cloud-bigtable to v1.17.2 ([#930](https://www.github.com/googleapis/java-bigquery/issues/930)) ([eab190f](https://www.github.com/googleapis/java-bigquery/commit/eab190f4f68e9d2a33b203d35d0d064c6c755f2f))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.15.0 ([#929](https://www.github.com/googleapis/java-bigquery/issues/929)) ([321357c](https://www.github.com/googleapis/java-bigquery/commit/321357ce41bc67be3009c27b4999b1d7cb4ecfee))

### [1.124.4](https://www.github.com/googleapis/java-bigquery/compare/v1.124.3...v1.124.4) (2020-11-10)


### Dependencies

* update dependency com.google.cloud:google-cloud-storage to v1.113.3 ([#923](https://www.github.com/googleapis/java-bigquery/issues/923)) ([ececddf](https://www.github.com/googleapis/java-bigquery/commit/ececddf32294f7884350d7e99f4eb3d493744ed2))

### [1.124.3](https://www.github.com/googleapis/java-bigquery/compare/v1.124.2...v1.124.3) (2020-11-10)


### Dependencies

* update dependency com.google.apis:google-api-services-bigquery to v2-rev20201030-1.30.10 ([#917](https://www.github.com/googleapis/java-bigquery/issues/917)) ([3d55b36](https://www.github.com/googleapis/java-bigquery/commit/3d55b365d3b737290b4e9b2c11e69ae67711a1d3))
* update dependency com.google.cloud:google-cloud-bigtable to v1.17.1 ([#906](https://www.github.com/googleapis/java-bigquery/issues/906)) ([07a8e28](https://www.github.com/googleapis/java-bigquery/commit/07a8e2812ed4d1b6bde2fba55462f8df5c7993ef))
* update dependency com.google.oauth-client:google-oauth-client-java6 to v1.31.2 ([#912](https://www.github.com/googleapis/java-bigquery/issues/912)) ([fd584e3](https://www.github.com/googleapis/java-bigquery/commit/fd584e3f84b1d726850e098ad509cab1e6735191))
* update dependency com.google.oauth-client:google-oauth-client-jetty to v1.31.2 ([#913](https://www.github.com/googleapis/java-bigquery/issues/913)) ([1ca3e90](https://www.github.com/googleapis/java-bigquery/commit/1ca3e9022354f2f5c96df004208979eabace90df))

### [1.124.2](https://www.github.com/googleapis/java-bigquery/compare/v1.124.1...v1.124.2) (2020-10-31)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.14.1 ([#897](https://www.github.com/googleapis/java-bigquery/issues/897)) ([b2cc174](https://www.github.com/googleapis/java-bigquery/commit/b2cc174640d227d617c7671ec4d074b3facf735e))

### [1.124.1](https://www.github.com/googleapis/java-bigquery/compare/v1.124.0...v1.124.1) (2020-10-30)


### Bug Fixes

* nullpointerexception for listroutines and listmodels ([#890](https://www.github.com/googleapis/java-bigquery/issues/890)) ([9e5c7c7](https://www.github.com/googleapis/java-bigquery/commit/9e5c7c7a6a0e32ce145a727bcdc1493e149f3b14))


### Dependencies

* update dependency com.google.apis:google-api-services-bigquery to v2-rev20201022-1.30.10 ([#892](https://www.github.com/googleapis/java-bigquery/issues/892)) ([ea4f45e](https://www.github.com/googleapis/java-bigquery/commit/ea4f45e00de6f8da8352f5a85513996475960f7c))

## [1.124.0](https://www.github.com/googleapis/java-bigquery/compare/v1.123.2...v1.124.0) (2020-10-29)


### Features

* add acl for routine ([#875](https://www.github.com/googleapis/java-bigquery/issues/875)) ([b031447](https://www.github.com/googleapis/java-bigquery/commit/b031447d691de51678a0654c27b0f621672dd52a))


### Bug Fixes

* **samples:** dataset getcreatetime ([#866](https://www.github.com/googleapis/java-bigquery/issues/866)) ([992baaf](https://www.github.com/googleapis/java-bigquery/commit/992baaf85ae2904bb5900cfdfce6b447fd301b3b))


### Dependencies

* update dependency com.google.cloud:google-cloud-storage to v1.113.2 ([#871](https://www.github.com/googleapis/java-bigquery/issues/871)) ([66551c3](https://www.github.com/googleapis/java-bigquery/commit/66551c3955ec9ba58e5b7b3204539ff4cde07298))


### Documentation

* **samples:** fix typo ([#884](https://www.github.com/googleapis/java-bigquery/issues/884)) ([97573b5](https://www.github.com/googleapis/java-bigquery/commit/97573b574a84a1504baf3ad0fb0d30a321842a14))

### [1.123.2](https://www.github.com/googleapis/java-bigquery/compare/v1.123.1...v1.123.2) (2020-10-23)


### Dependencies

* update dependency com.google.cloud:google-cloud-bigtable to v1.17.0 ([#860](https://www.github.com/googleapis/java-bigquery/issues/860)) ([825575e](https://www.github.com/googleapis/java-bigquery/commit/825575eed83312e94d1417cf5e1d286bd843c347))

### [1.123.1](https://www.github.com/googleapis/java-bigquery/compare/v1.123.0...v1.123.1) (2020-10-23)


### Dependencies

* update dependency com.google.apis:google-api-services-bigquery to v2-rev20201015-1.30.10 ([#851](https://www.github.com/googleapis/java-bigquery/issues/851)) ([439eea9](https://www.github.com/googleapis/java-bigquery/commit/439eea95390b72e5aa84ddd9c208475074cf821c))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.13.0 ([#834](https://www.github.com/googleapis/java-bigquery/issues/834)) ([16a105b](https://www.github.com/googleapis/java-bigquery/commit/16a105bdcfbe61e78d79743aa216f281cf57040a))


### Documentation

* **samples:** add export query results to Amazon S3 sample and IT ([#853](https://www.github.com/googleapis/java-bigquery/issues/853)) ([5358620](https://www.github.com/googleapis/java-bigquery/commit/53586207c300002f6bbad3d67f4441729b109f8a))
* **samples:** create and query Amazon s3 data using external table ([#835](https://www.github.com/googleapis/java-bigquery/issues/835)) ([53a56be](https://www.github.com/googleapis/java-bigquery/commit/53a56be8b0878edbc4bc5dd67ed63b48c96d3899))

## [1.123.0](https://www.github.com/googleapis/java-bigquery/compare/v1.122.2...v1.123.0) (2020-10-20)


### Features

* add requirePartitionFilter field in HivePartitioningOptions ([#803](https://www.github.com/googleapis/java-bigquery/issues/803)) ([193c886](https://www.github.com/googleapis/java-bigquery/commit/193c8860d3a21e56b6ebe77240bd4eee3d19ee72))


### Bug Fixes

* fix start index with page size for list rows ([#793](https://www.github.com/googleapis/java-bigquery/issues/793)) ([71e7d48](https://www.github.com/googleapis/java-bigquery/commit/71e7d4804e1facfb921892dc702adaec35e47cd0))
* schema and totalRows for duplicate request ids ([#804](https://www.github.com/googleapis/java-bigquery/issues/804)) ([f2799dd](https://www.github.com/googleapis/java-bigquery/commit/f2799dd9a4323460843aa6df7ac7c2f092c7f1b3))


### Documentation

* **samples:** add omni create aws dataset ([#821](https://www.github.com/googleapis/java-bigquery/issues/821)) ([477a8e3](https://www.github.com/googleapis/java-bigquery/commit/477a8e39ce85408c745ebcc72a136b31edf66f05))
* **samples:** add omni create external table ([#823](https://www.github.com/googleapis/java-bigquery/issues/823)) ([fc3cf2a](https://www.github.com/googleapis/java-bigquery/commit/fc3cf2a4151e154e5240938579b50183242db1d8))


### Dependencies

* update core transport dependencies to v1.31.1 ([#811](https://www.github.com/googleapis/java-bigquery/issues/811)) ([27a86a0](https://www.github.com/googleapis/java-bigquery/commit/27a86a06de63fef62b63307e0e01060e91efe0f6))
* update dependency com.google.apis:google-api-services-bigquery to v2-rev20201007-1.30.10 ([#812](https://www.github.com/googleapis/java-bigquery/issues/812)) ([89f34c6](https://www.github.com/googleapis/java-bigquery/commit/89f34c6cd282d402a64e87614953491df3f1cdbe))
* update dependency com.google.cloud:google-cloud-bigtable to v1.16.2 ([#813](https://www.github.com/googleapis/java-bigquery/issues/813)) ([791bf25](https://www.github.com/googleapis/java-bigquery/commit/791bf253c7828daaf04fe5bec0ae8798e12dc2bc))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.12.1 ([#827](https://www.github.com/googleapis/java-bigquery/issues/827)) ([afe3b18](https://www.github.com/googleapis/java-bigquery/commit/afe3b185f26b1755b8c46bfb344b9041ee9641e7))
* update jmh.version to v1.26 ([#815](https://www.github.com/googleapis/java-bigquery/issues/815)) ([e5fd40f](https://www.github.com/googleapis/java-bigquery/commit/e5fd40fdc6de483a0f063cde83af1a6e23173c29))

### [1.122.2](https://www.github.com/googleapis/java-bigquery/compare/v1.122.1...v1.122.2) (2020-10-08)


### Bug Fixes

* bigquery exception get reason and message ([#788](https://www.github.com/googleapis/java-bigquery/issues/788)) ([d783c3a](https://www.github.com/googleapis/java-bigquery/commit/d783c3a2baf80da2aa48c6be555904bd3c33bb1a))


### Documentation

* **samples:** add query external bigtable using permanent table ([#764](https://www.github.com/googleapis/java-bigquery/issues/764)) ([257edfc](https://www.github.com/googleapis/java-bigquery/commit/257edfc14ef09efc4474eb5aba08ccf4d7c199c0))
* **samples:** add query external bigtable using temp table ([#763](https://www.github.com/googleapis/java-bigquery/issues/763)) ([fed28c7](https://www.github.com/googleapis/java-bigquery/commit/fed28c78ca4b70569d5148e67522b0f39321b306))

### [1.122.1](https://www.github.com/googleapis/java-bigquery/compare/v1.122.0...v1.122.1) (2020-10-06)


### Bug Fixes

* request id for fast query path ([#781](https://www.github.com/googleapis/java-bigquery/issues/781)) ([15dc9f0](https://www.github.com/googleapis/java-bigquery/commit/15dc9f0a95ebe3d97f8cbc5413f6c740f5f20241))

## [1.122.0](https://www.github.com/googleapis/java-bigquery/compare/v1.121.0...v1.122.0) (2020-10-01)


### Features

* add connectionId support for external data sources ([#776](https://www.github.com/googleapis/java-bigquery/issues/776)) ([dcd7daa](https://www.github.com/googleapis/java-bigquery/commit/dcd7daa15d8f820affc9c155ba6d7a9a4c15066d))

## [1.121.0](https://www.github.com/googleapis/java-bigquery/compare/v1.120.0...v1.121.0) (2020-10-01)


### Features

* add case insensitive for fields get by name ([#775](https://www.github.com/googleapis/java-bigquery/issues/775)) ([fcea662](https://www.github.com/googleapis/java-bigquery/commit/fcea66290c2079a6b5f7f9fc340ad706ca30cabd))
* use bigquery exception ([#749](https://www.github.com/googleapis/java-bigquery/issues/749)) ([84d6632](https://www.github.com/googleapis/java-bigquery/commit/84d6632dbbdb9ccaf4afba545ec94a1156a989a2))


### Bug Fixes

* nullpointer exception when executionerror is null ([#754](https://www.github.com/googleapis/java-bigquery/issues/754)) ([03bda1b](https://www.github.com/googleapis/java-bigquery/commit/03bda1bf79169bf0fca3ee12c1c3dfeb19c2e102))


### Dependencies

* update dependency com.google.apis:google-api-services-bigquery to v2-rev20200916-1.30.10 ([#768](https://www.github.com/googleapis/java-bigquery/issues/768)) ([6f8911a](https://www.github.com/googleapis/java-bigquery/commit/6f8911a356daf3dec79431491e40b1bfa1c20d4d))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.10.0 ([#769](https://www.github.com/googleapis/java-bigquery/issues/769)) ([49dbbba](https://www.github.com/googleapis/java-bigquery/commit/49dbbba8d1726e7277eb0ad8e168ff0a480daf0e))
* update dependency com.google.cloud:google-cloud-storage to v1.113.1 ([#770](https://www.github.com/googleapis/java-bigquery/issues/770)) ([34f30ec](https://www.github.com/googleapis/java-bigquery/commit/34f30ec2fea28e053fdb32d766749c8d6d0e115c))


### Documentation

* update clustering field docstrings ([#774](https://www.github.com/googleapis/java-bigquery/issues/774)) ([58e2e4e](https://www.github.com/googleapis/java-bigquery/commit/58e2e4ee8c4f3bf8391bbc1e2ff07b63e6247c69))
* **samples:** add region tag for auth snippet ([#760](https://www.github.com/googleapis/java-bigquery/issues/760)) ([9709c9e](https://www.github.com/googleapis/java-bigquery/commit/9709c9e401a512b6ab8e3ded52420597e30c7b0c))
* **samples:** fix flaky test case for undelete table ([#757](https://www.github.com/googleapis/java-bigquery/issues/757)) ([85b7069](https://www.github.com/googleapis/java-bigquery/commit/85b70691cc380beeafa839be4f10ec513342389f))

## [1.120.0](https://www.github.com/googleapis/java-bigquery/compare/v1.119.0...v1.120.0) (2020-09-22)


### Features

* sql fast path impl ([#509](https://www.github.com/googleapis/java-bigquery/issues/509)) ([64a7d65](https://www.github.com/googleapis/java-bigquery/commit/64a7d65ff97152c49194f507562266c1ba6f0f3b)), closes [google-cloud-bigquery/src/main/java/com/google/cloud/bigquery/BigQueryException.java#L69-L71](https://www.github.com/google-cloud-bigquery/src/main/java/com/google/cloud/bigquery/BigQueryException.java/issues/L69-L71) [#L69](https://www.github.com/googleapis/java-bigquery/issues/L69)

## [1.119.0](https://www.github.com/googleapis/java-bigquery/compare/v1.118.0...v1.119.0) (2020-09-17)


### Features

* add additional time partitioning intervals ([#737](https://www.github.com/googleapis/java-bigquery/issues/737)) ([a57dbdf](https://www.github.com/googleapis/java-bigquery/commit/a57dbdf96440bc7e51443efb99b007ac42cd481b))

## [1.118.0](https://www.github.com/googleapis/java-bigquery/compare/v1.117.2...v1.118.0) (2020-09-17)


### Features

* **bigquery:** explicitly ask for dense responses from HTTP backend ([#739](https://www.github.com/googleapis/java-bigquery/issues/739)) ([8c92c99](https://www.github.com/googleapis/java-bigquery/commit/8c92c9919b278bdb128be963391fc1870e69e343))


### Bug Fixes

* throw jobexception for invalid multiple statements query ([#732](https://www.github.com/googleapis/java-bigquery/issues/732)) ([2a0d86d](https://www.github.com/googleapis/java-bigquery/commit/2a0d86d2d07dd706fb7d943da6ebd5c9ac98dfca))

### [1.117.2](https://www.github.com/googleapis/java-bigquery/compare/v1.117.1...v1.117.2) (2020-09-15)


### Bug Fixes

* get recordvalue by field name ([#718](https://www.github.com/googleapis/java-bigquery/issues/718)) ([b3f59b1](https://www.github.com/googleapis/java-bigquery/commit/b3f59b1e1215d93a3b7048149c88318f2a074f79))


### Dependencies

* update dependency com.google.apis:google-api-services-bigquery to v2-rev20200827-1.30.10 ([#722](https://www.github.com/googleapis/java-bigquery/issues/722)) ([dcb8671](https://www.github.com/googleapis/java-bigquery/commit/dcb86719f11fe2b75113974ada13bae20150aa49))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.9.0 ([#715](https://www.github.com/googleapis/java-bigquery/issues/715)) ([b75b95b](https://www.github.com/googleapis/java-bigquery/commit/b75b95b7ca338da0900c53856c280c9acc140cd5))
* update dependency com.google.cloud:google-cloud-storage to v1.113.0 ([#723](https://www.github.com/googleapis/java-bigquery/issues/723)) ([fb6d543](https://www.github.com/googleapis/java-bigquery/commit/fb6d5430b9f6e1285e7fa0102c78d9c4dd07c599))
* update jmh.version to v1.25.2 ([#720](https://www.github.com/googleapis/java-bigquery/issues/720)) ([9afba31](https://www.github.com/googleapis/java-bigquery/commit/9afba319a62f54ee766d2476f5bd2ee91b3ba762))

### [1.117.1](https://www.github.com/googleapis/java-bigquery/compare/v1.117.0...v1.117.1) (2020-08-28)


### Bug Fixes

* npe for destination table ([#699](https://www.github.com/googleapis/java-bigquery/issues/699)) ([863c9e1](https://www.github.com/googleapis/java-bigquery/commit/863c9e1d7da8a63154677fb32954e2048dd48e9e))


### Dependencies

* update dependency com.google.apis:google-api-services-bigquery to v2-rev20200818-1.30.10 ([#705](https://www.github.com/googleapis/java-bigquery/issues/705)) ([127414c](https://www.github.com/googleapis/java-bigquery/commit/127414c4f2cb7ea50dfc0f5cbfcb7f581cf67e63))
* update dependency com.google.cloud:google-cloud-storage to v1.112.0 ([#708](https://www.github.com/googleapis/java-bigquery/issues/708)) ([0be6a2b](https://www.github.com/googleapis/java-bigquery/commit/0be6a2b8ba47a912d8af7326ebc910d02393f6f5))
* update jmh.version to v1.25.1 ([#698](https://www.github.com/googleapis/java-bigquery/issues/698)) ([e3a021b](https://www.github.com/googleapis/java-bigquery/commit/e3a021b24cbcdfe23617da1662f438fb2d8699fb))

## [1.117.0](https://www.github.com/googleapis/java-bigquery/compare/v1.116.10...v1.117.0) (2020-08-25)


### Features

* add jmh benchmark module ([#686](https://www.github.com/googleapis/java-bigquery/issues/686)) ([a0e760f](https://www.github.com/googleapis/java-bigquery/commit/a0e760fbb1f5a9b169045ceba2dcf682d4736995))
* support for Table ACLs ([#653](https://www.github.com/googleapis/java-bigquery/issues/653)) ([f0e67d8](https://www.github.com/googleapis/java-bigquery/commit/f0e67d8a63fdfe62bcd285c3bbb04cae79386229))


### Bug Fixes

* temporarily disable reporting to unblock releases ([#692](https://www.github.com/googleapis/java-bigquery/issues/692)) ([c1f5533](https://www.github.com/googleapis/java-bigquery/commit/c1f5533ee25907cad5fbae589b5dd08418e3f42b))


### Dependencies

* update dependency com.google.apis:google-api-services-bigquery to v2-rev20200805-1.30.10 ([#672](https://www.github.com/googleapis/java-bigquery/issues/672)) ([3e578f4](https://www.github.com/googleapis/java-bigquery/commit/3e578f4337e2d0c41237294ea7889d9efd0eddb0))
* update jmh.version to v1.25 ([#690](https://www.github.com/googleapis/java-bigquery/issues/690)) ([44f7632](https://www.github.com/googleapis/java-bigquery/commit/44f7632feaeb1e1de8a1f68db972c48786e244de))


### Documentation

* update samples README.md ([#667](https://www.github.com/googleapis/java-bigquery/issues/667)) ([60d904b](https://www.github.com/googleapis/java-bigquery/commit/60d904b1fc4625f490f9357c486bfe5ef4f36f2c))
* **samples:** add samples lint job and fix lint issues ([#684](https://www.github.com/googleapis/java-bigquery/issues/684)) ([f08becc](https://www.github.com/googleapis/java-bigquery/commit/f08beccecd00f792c33ac3d2e29a696bd9411fb6))
* **samples:** fix checkstyle errors ([#682](https://www.github.com/googleapis/java-bigquery/issues/682)) ([fe5abc0](https://www.github.com/googleapis/java-bigquery/commit/fe5abc054c5eb7907ef58d5aa3285b3f10211aa4)), closes [#681](https://www.github.com/googleapis/java-bigquery/issues/681)

### [1.116.10](https://www.github.com/googleapis/java-bigquery/compare/v1.116.9...v1.116.10) (2020-08-11)


### Documentation

* **samples:** add query external sheet permanent table ([#658](https://www.github.com/googleapis/java-bigquery/issues/658)) ([6488cd1](https://www.github.com/googleapis/java-bigquery/commit/6488cd1ef914b2c87fa823511126a51cc27712fa))
* **samples:** add query external sheet temp table ([#659](https://www.github.com/googleapis/java-bigquery/issues/659)) ([9044050](https://www.github.com/googleapis/java-bigquery/commit/904405039a2d4dbb865451d7b1ac9257cc54efd2))
* **samples:** add relax column load append ([#657](https://www.github.com/googleapis/java-bigquery/issues/657)) ([511e9d7](https://www.github.com/googleapis/java-bigquery/commit/511e9d7580c7ddcda6734dd5f0ad012035bc77d5))
* remove outdated readme content ([#666](https://www.github.com/googleapis/java-bigquery/issues/666)) ([349e111](https://www.github.com/googleapis/java-bigquery/commit/349e11163773b22deae3dfb0ed4373f717711b79))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.6 ([#661](https://www.github.com/googleapis/java-bigquery/issues/661)) ([df3788a](https://www.github.com/googleapis/java-bigquery/commit/df3788a2ba9223bd99c56b6e76fbc6b0ab2b302a))

### [1.116.9](https://www.github.com/googleapis/java-bigquery/compare/v1.116.8...v1.116.9) (2020-08-07)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.5 ([#654](https://www.github.com/googleapis/java-bigquery/issues/654)) ([cb1b8c4](https://www.github.com/googleapis/java-bigquery/commit/cb1b8c4d6bd739d2f803e96d8b32dcd02fb643ae))


### Documentation

* **samples:** add load csv autodetect data from gcs ([#655](https://www.github.com/googleapis/java-bigquery/issues/655)) ([497ddf4](https://www.github.com/googleapis/java-bigquery/commit/497ddf41a0faeef4d896fc7f8e3e78b2c295d4a0))
* **samples:** add undelete table ([#638](https://www.github.com/googleapis/java-bigquery/issues/638)) ([e799bb3](https://www.github.com/googleapis/java-bigquery/commit/e799bb39022b6914678b085a000132d2fbca4a7f))
* **samples:** fix region tag for bigquery_relax_column_query_append ([#651](https://www.github.com/googleapis/java-bigquery/issues/651)) ([319b982](https://www.github.com/googleapis/java-bigquery/commit/319b982a8a50f592c244301b6431352b140ee50d))

### [1.116.8](https://www.github.com/googleapis/java-bigquery/compare/v1.116.7...v1.116.8) (2020-08-04)


### Reverts

* Revert "docs(samples): add undelete table (#611)" (#620) ([e28abed](https://www.github.com/googleapis/java-bigquery/commit/e28abed3cd414cc7432ea188eacde8b53b7819e3)), closes [#611](https://www.github.com/googleapis/java-bigquery/issues/611) [#620](https://www.github.com/googleapis/java-bigquery/issues/620)


### Dependencies

* update dependency com.google.apis:google-api-services-bigquery to v2-rev20200719-1.30.10 ([#602](https://www.github.com/googleapis/java-bigquery/issues/602)) ([8dc5bc3](https://www.github.com/googleapis/java-bigquery/commit/8dc5bc3851124b340a3454ce4df54ff44ac44379))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.4 ([#639](https://www.github.com/googleapis/java-bigquery/issues/639)) ([46f929b](https://www.github.com/googleapis/java-bigquery/commit/46f929b1ac9a4a731c98e83b444d29573ab8572d))


### Documentation

* **samples:** add authorized view tutorial ([#637](https://www.github.com/googleapis/java-bigquery/issues/637)) ([91cdf72](https://www.github.com/googleapis/java-bigquery/commit/91cdf72efc93dc9fcf06a25b06ef227fa43359ed))
* **samples:** add delete dataset and contents ([#629](https://www.github.com/googleapis/java-bigquery/issues/629)) ([209d035](https://www.github.com/googleapis/java-bigquery/commit/209d035c66fe776ad31db848d4d1b7c669f73595))
* **samples:** add load json table with overwrite data from gcs ([#582](https://www.github.com/googleapis/java-bigquery/issues/582)) ([f127475](https://www.github.com/googleapis/java-bigquery/commit/f127475100a307970a0af5227d367d790b434775))
* **samples:** add load orc file and overwrite data into a table from gcs ([#584](https://www.github.com/googleapis/java-bigquery/issues/584)) ([b3621df](https://www.github.com/googleapis/java-bigquery/commit/b3621df78f2c06cefdb637048dd91e11dbf8256f))
* **samples:** add query disable cache ([#595](https://www.github.com/googleapis/java-bigquery/issues/595)) ([8ef8db2](https://www.github.com/googleapis/java-bigquery/commit/8ef8db2e2fbcbff5136b18423746b25384a082ef))
* **samples:** add query dry run ([#587](https://www.github.com/googleapis/java-bigquery/issues/587)) ([55cd52c](https://www.github.com/googleapis/java-bigquery/commit/55cd52cf5e0f06afcbb7c1d961daca04cc5fe7a9))
* **samples:** add query legacy large results ([#594](https://www.github.com/googleapis/java-bigquery/issues/594)) ([4787dd0](https://www.github.com/googleapis/java-bigquery/commit/4787dd07202b6312b1a25957fee6a14e500dce48))
* **samples:** add query on external table from gcs ([#588](https://www.github.com/googleapis/java-bigquery/issues/588)) ([64bed25](https://www.github.com/googleapis/java-bigquery/commit/64bed2591daefed7bb8c8f93aa0a3d748a41a20d))
* **samples:** add query on external temp table from gcs ([#593](https://www.github.com/googleapis/java-bigquery/issues/593)) ([ef757ad](https://www.github.com/googleapis/java-bigquery/commit/ef757ad44dcc2745f2d07b799a1af63166d79d4f))
* **samples:** add query pagination ([#596](https://www.github.com/googleapis/java-bigquery/issues/596)) ([918c8bd](https://www.github.com/googleapis/java-bigquery/commit/918c8bd78d3654120f18db49058085c321c05819))
* **samples:** add query partitioned table ([#597](https://www.github.com/googleapis/java-bigquery/issues/597)) ([055ebc0](https://www.github.com/googleapis/java-bigquery/commit/055ebc09b36afc278a728d5ce1af5362ea0b5794))
* **samples:** add query script ([#605](https://www.github.com/googleapis/java-bigquery/issues/605)) ([ca07302](https://www.github.com/googleapis/java-bigquery/commit/ca073025b8d156bf9e76656fb36f49a5f81927c9))
* **samples:** add query total rows ([#609](https://www.github.com/googleapis/java-bigquery/issues/609)) ([0da5fd1](https://www.github.com/googleapis/java-bigquery/commit/0da5fd16747445819212741dd55c224b867f1629))
* **samples:** add query with arrays parameters ([#603](https://www.github.com/googleapis/java-bigquery/issues/603)) ([1eeffe6](https://www.github.com/googleapis/java-bigquery/commit/1eeffe6c8cc6cf131137cfadef46782012d6e47f))
* **samples:** add query with name types parameters ([#633](https://www.github.com/googleapis/java-bigquery/issues/633)) ([082f1a2](https://www.github.com/googleapis/java-bigquery/commit/082f1a2c2aeeaf1243681bee921fc54328969728))
* **samples:** add query with positional type parameters ([#634](https://www.github.com/googleapis/java-bigquery/issues/634)) ([208883c](https://www.github.com/googleapis/java-bigquery/commit/208883c2205abeeaee6c5162253eefc569fcba78))
* **samples:** add query with timestamp parameters ([#604](https://www.github.com/googleapis/java-bigquery/issues/604)) ([0abdd90](https://www.github.com/googleapis/java-bigquery/commit/0abdd902ec4a6758be4aed91b16a3df0c0afbd94))
* **samples:** add table exists ([#610](https://www.github.com/googleapis/java-bigquery/issues/610)) ([db9eef7](https://www.github.com/googleapis/java-bigquery/commit/db9eef76c066ba2b57fe2b6f64d6c966474b9071))
* **samples:** add undelete table ([#611](https://www.github.com/googleapis/java-bigquery/issues/611)) ([6c763d5](https://www.github.com/googleapis/java-bigquery/commit/6c763d58f2f13f52a44983b56b74b300a17468cc))
* **samples:** add update dataset partition expiration ([#612](https://www.github.com/googleapis/java-bigquery/issues/612)) ([720b5ac](https://www.github.com/googleapis/java-bigquery/commit/720b5acfe2f9f46eebb18b6e5d0db881b0ad7e2a))
* **samples:** add update model description ([#617](https://www.github.com/googleapis/java-bigquery/issues/617)) ([a8cb797](https://www.github.com/googleapis/java-bigquery/commit/a8cb797ab9f758c1af74faa84e8f71bf76a69223))
* **samples:** add update routine ([#618](https://www.github.com/googleapis/java-bigquery/issues/618)) ([a889800](https://www.github.com/googleapis/java-bigquery/commit/a889800b16483a85400198b2cb261d95afb2c69b))
* **samples:** add update table cmek ([#619](https://www.github.com/googleapis/java-bigquery/issues/619)) ([31cc937](https://www.github.com/googleapis/java-bigquery/commit/31cc9375c78156643b03374fddeb7aab4b26b4f3))
* **samples:** add update table require partition filter ([#624](https://www.github.com/googleapis/java-bigquery/issues/624)) ([29272bb](https://www.github.com/googleapis/java-bigquery/commit/29272bb9a3238b2f0dab2e44b23db6909d3809a2))
* **samples:** load orc file into a table from gcs ([#583](https://www.github.com/googleapis/java-bigquery/issues/583)) ([cbb1902](https://www.github.com/googleapis/java-bigquery/commit/cbb1902e1e3d7017b1cd9be0e51243e5840ace96))
* **samples:** update view query ([#625](https://www.github.com/googleapis/java-bigquery/issues/625)) ([8d71720](https://www.github.com/googleapis/java-bigquery/commit/8d717202ed36f55dd141ba45243f2dc30b597d99))

### [1.116.7](https://www.github.com/googleapis/java-bigquery/compare/v1.116.6...v1.116.7) (2020-07-21)


### Bug Fixes

* **sample:** region tag ([#544](https://www.github.com/googleapis/java-bigquery/issues/544)) ([f7f6e73](https://www.github.com/googleapis/java-bigquery/commit/f7f6e73ef82924fb0f7cbae5c871f1cd27620cc6))


### Documentation

* **samples:** add auth user flow and query ([#478](https://www.github.com/googleapis/java-bigquery/issues/478)) ([65dffac](https://www.github.com/googleapis/java-bigquery/commit/65dffac6af316d0baca5cfbd2b3dd3fae323549d))
* **samples:** add create view ddl ([#558](https://www.github.com/googleapis/java-bigquery/issues/558)) ([9253218](https://www.github.com/googleapis/java-bigquery/commit/925321881cde3edd187a9a442a26eb508535744a))
* **samples:** add extract compressed table ([#538](https://www.github.com/googleapis/java-bigquery/issues/538)) ([3f129a6](https://www.github.com/googleapis/java-bigquery/commit/3f129a6a4fff2162d1aef5ba29b4fa6246793d97))
* **samples:** add get dataset labels ([#539](https://www.github.com/googleapis/java-bigquery/issues/539)) ([563157c](https://www.github.com/googleapis/java-bigquery/commit/563157cc40727cb7cb9aed16dfbb956a668ead51))
* **samples:** add get table labels ([#540](https://www.github.com/googleapis/java-bigquery/issues/540)) ([a6d9491](https://www.github.com/googleapis/java-bigquery/commit/a6d94913f74a6b4d29e9314a0652a9e3fa30aed9))
* **samples:** add grant view access ([#563](https://www.github.com/googleapis/java-bigquery/issues/563)) ([0c092e0](https://www.github.com/googleapis/java-bigquery/commit/0c092e06cdf47882a38901e8e4814afa87c7eba4))
* **samples:** add insert rows without rowids in a table ([#573](https://www.github.com/googleapis/java-bigquery/issues/573)) ([b07dee3](https://www.github.com/googleapis/java-bigquery/commit/b07dee31e4b6fec8bf05f23ed52006829dbdbc4a))
* **samples:** add list dataset by label ([#555](https://www.github.com/googleapis/java-bigquery/issues/555)) ([a0d7bea](https://www.github.com/googleapis/java-bigquery/commit/a0d7beab025a2895f0efc1e9888594e386a0a1b3))
* **samples:** add list jobs ([#554](https://www.github.com/googleapis/java-bigquery/issues/554)) ([b87cecf](https://www.github.com/googleapis/java-bigquery/commit/b87cecff3f41339b20382b26381c38c4d7150305))
* **samples:** add list routines ([#546](https://www.github.com/googleapis/java-bigquery/issues/546)) ([2cd81d4](https://www.github.com/googleapis/java-bigquery/commit/2cd81d4fb616588e9ed966f6dd32cd4615d305c4))
* **samples:** add load avro table with truncate from gcs ([#567](https://www.github.com/googleapis/java-bigquery/issues/567)) ([fa998ba](https://www.github.com/googleapis/java-bigquery/commit/fa998baa32437a5e39670c5c7399c0945de56d52))
* **samples:** add load json file from gcs into a table ([#568](https://www.github.com/googleapis/java-bigquery/issues/568)) ([3d65821](https://www.github.com/googleapis/java-bigquery/commit/3d658210650d2849c86df96dccd3587e95a6f4a6))
* **samples:** add load json file from gcs into a table with autodetect schema ([#569](https://www.github.com/googleapis/java-bigquery/issues/569)) ([259d470](https://www.github.com/googleapis/java-bigquery/commit/259d470ecadc9f384920164c8a2f45643cff130a))
* **samples:** add load json table with encryption key from gcs ([#575](https://www.github.com/googleapis/java-bigquery/issues/575)) ([2ac556e](https://www.github.com/googleapis/java-bigquery/commit/2ac556e2707b3088446353ca03d9a8d08b6d66e2))
* **samples:** add load table from gcs using avro file ([#564](https://www.github.com/googleapis/java-bigquery/issues/564)) ([219f7a9](https://www.github.com/googleapis/java-bigquery/commit/219f7a978ab83421917ec4eb0295af38f4a9dd04))
* **samples:** add query destination table with encryption key ([#576](https://www.github.com/googleapis/java-bigquery/issues/576)) ([29b8a7f](https://www.github.com/googleapis/java-bigquery/commit/29b8a7f179bf1fcd125f211353ef95021c0142d8))
* **samples:** add region tag for oauth dependencies ([#570](https://www.github.com/googleapis/java-bigquery/issues/570)) ([8ed6bd6](https://www.github.com/googleapis/java-bigquery/commit/8ed6bd679761744bed7f4dcb4f66bf6f37119154))
* correct comment ([#553](https://www.github.com/googleapis/java-bigquery/issues/553)) ([48cdc92](https://www.github.com/googleapis/java-bigquery/commit/48cdc92b6f1e128b4f0c8c25cd9ea907ab77bd93))


### Dependencies

* update core transport dependencies to v1.31.0 ([#565](https://www.github.com/googleapis/java-bigquery/issues/565)) ([5fd73ee](https://www.github.com/googleapis/java-bigquery/commit/5fd73eeb5b5d8c91154c23642737c9ece37b1750))

### [1.116.6](https://www.github.com/googleapis/java-bigquery/compare/v1.116.5...v1.116.6) (2020-07-10)


### Dependencies

* update dependency com.google.apis:google-api-services-bigquery to v2-rev20200625-1.30.10 ([#533](https://www.github.com/googleapis/java-bigquery/issues/533)) ([d5b4b49](https://www.github.com/googleapis/java-bigquery/commit/d5b4b496b062c6c7f402503524732381915fd688))
* update dependency com.google.cloud:google-cloud-storage to v1.111.2 ([#531](https://www.github.com/googleapis/java-bigquery/issues/531)) ([9b2aeb4](https://www.github.com/googleapis/java-bigquery/commit/9b2aeb4d729b0719e19fcc054eabb08527dd4ac2))

### [1.116.5](https://www.github.com/googleapis/java-bigquery/compare/v1.116.4...v1.116.5) (2020-07-10)


### Bug Fixes

* handle malformed backend responses. ([#522](https://www.github.com/googleapis/java-bigquery/issues/522)) ([64de23a](https://www.github.com/googleapis/java-bigquery/commit/64de23a95736ffaaae7a05e0fd2c6f5f8c5c3665))


### Documentation

* **samples:** add label dataset ([#526](https://www.github.com/googleapis/java-bigquery/issues/526)) ([d775818](https://www.github.com/googleapis/java-bigquery/commit/d775818bda5c3a9c310ce7747f575200ce72fd9d))
* **samples:** add label table ([#527](https://www.github.com/googleapis/java-bigquery/issues/527)) ([d7cf47d](https://www.github.com/googleapis/java-bigquery/commit/d7cf47d1a1f6eda47637e49983086d79ed1cd7ac))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.3 ([#523](https://www.github.com/googleapis/java-bigquery/issues/523)) ([82341cb](https://www.github.com/googleapis/java-bigquery/commit/82341cbb12ad6f5e020b5ba15701f66f0cbbfa19))

### [1.116.4](https://www.github.com/googleapis/java-bigquery/compare/v1.116.3...v1.116.4) (2020-07-08)


### Dependencies

* update dependency com.google.apis:google-api-services-bigquery to v2-rev20200617-1.30.9 ([#500](https://www.github.com/googleapis/java-bigquery/issues/500)) ([8b6457c](https://www.github.com/googleapis/java-bigquery/commit/8b6457c010121a4c031611c2a896aa9147012ca3))
* update dependency com.google.apis:google-api-services-bigquery to v2-rev20200625-1.30.9 ([#517](https://www.github.com/googleapis/java-bigquery/issues/517)) ([a0540e4](https://www.github.com/googleapis/java-bigquery/commit/a0540e4792818853a502bf56b363b26a60c5f5d9))
* update dependency com.google.cloud:google-cloud-storage to v1.110.0 ([#465](https://www.github.com/googleapis/java-bigquery/issues/465)) ([c4e6848](https://www.github.com/googleapis/java-bigquery/commit/c4e68486769bddb515023758e73eea5491b35e61))
* update dependency com.google.cloud:google-cloud-storage to v1.111.0 ([#484](https://www.github.com/googleapis/java-bigquery/issues/484)) ([a880fe2](https://www.github.com/googleapis/java-bigquery/commit/a880fe2b39f443b2e5e29d6288098c3db33fc6b5))
* update shared-dependencies and google-cloud-storage versions ([#505](https://www.github.com/googleapis/java-bigquery/issues/505)) ([8961842](https://www.github.com/googleapis/java-bigquery/commit/896184203dd3e4ccc6bd245bea7e2288f4e5b8cb))


### Documentation

* **samples:** add cancel job ([#487](https://www.github.com/googleapis/java-bigquery/issues/487)) ([fdea80e](https://www.github.com/googleapis/java-bigquery/commit/fdea80e17bddfc32a4541f240a25de5a3be01ef5))
* **samples:** add copy cmek table ([#513](https://www.github.com/googleapis/java-bigquery/issues/513)) ([f356c71](https://www.github.com/googleapis/java-bigquery/commit/f356c715bd1783df389b0fb66a7bb8747375765c))
* **samples:** add create and delete routine ([#493](https://www.github.com/googleapis/java-bigquery/issues/493)) ([99c324c](https://www.github.com/googleapis/java-bigquery/commit/99c324c60a7825da7259a3173ee6b776d0c76825))
* **samples:** add create cmek table ([#511](https://www.github.com/googleapis/java-bigquery/issues/511)) ([b5fd40f](https://www.github.com/googleapis/java-bigquery/commit/b5fd40fe1c826bfae96b19b797a3b5943762a22e))
* **samples:** add create job ([#470](https://www.github.com/googleapis/java-bigquery/issues/470)) ([e63f06e](https://www.github.com/googleapis/java-bigquery/commit/e63f06eeaa18386a8489b41cdad8d2c8e63fc146))
* **samples:** add create routine ddl ([#495](https://www.github.com/googleapis/java-bigquery/issues/495)) ([f955408](https://www.github.com/googleapis/java-bigquery/commit/f9554087f71cb830fde9598150d433d603e5be22))
* **samples:** add create table without schema ([#488](https://www.github.com/googleapis/java-bigquery/issues/488)) ([9232370](https://www.github.com/googleapis/java-bigquery/commit/9232370ff8c8755c9404ea319d9d9c9a397dd407))
* **samples:** add create view ([#497](https://www.github.com/googleapis/java-bigquery/issues/497)) ([09cf7f1](https://www.github.com/googleapis/java-bigquery/commit/09cf7f1a937c6c66b65ddc92cff1c29df63e6162))
* **samples:** add dataset exists ([#492](https://www.github.com/googleapis/java-bigquery/issues/492)) ([2a10616](https://www.github.com/googleapis/java-bigquery/commit/2a106160e8d24bd1ebbd25bb8dd012a46ba1d7e4))
* **samples:** add delete label on a dataset ([#515](https://www.github.com/googleapis/java-bigquery/issues/515)) ([a0edebb](https://www.github.com/googleapis/java-bigquery/commit/a0edebb4da976c6a4a0553f18c6e749f9190aa15))
* **samples:** add delete label on a table ([#516](https://www.github.com/googleapis/java-bigquery/issues/516)) ([9c1b82a](https://www.github.com/googleapis/java-bigquery/commit/9c1b82a208d80c03d4330fda5382b54e7c8f06c6))
* **samples:** add get job ([#503](https://www.github.com/googleapis/java-bigquery/issues/503)) ([3c1884b](https://www.github.com/googleapis/java-bigquery/commit/3c1884b9f78c4f365dab662b7cfed0e1a253cb2d))
* **samples:** add get routine ([#504](https://www.github.com/googleapis/java-bigquery/issues/504)) ([dbe4d30](https://www.github.com/googleapis/java-bigquery/commit/dbe4d30691dcc8e607e58fe6c97b40f3a2091012))
* **samples:** add get view ([#508](https://www.github.com/googleapis/java-bigquery/issues/508)) ([38b7ab2](https://www.github.com/googleapis/java-bigquery/commit/38b7ab2ba4a5797cb489714209465f5a9710c8da))
* **samples:** add insert data types ([#479](https://www.github.com/googleapis/java-bigquery/issues/479)) ([12a2bea](https://www.github.com/googleapis/java-bigquery/commit/12a2bea2c65d80a1c401cb65f3d826eb07fc3037))
* **samples:** add query batch ([#469](https://www.github.com/googleapis/java-bigquery/issues/469)) ([0ffbac3](https://www.github.com/googleapis/java-bigquery/commit/0ffbac349cc27ce72b06e05723e45a973b69cef1))

### [1.116.3](https://www.github.com/googleapis/java-bigquery/compare/v1.116.2...v1.116.3) (2020-06-18)


### Documentation

* **samples:** add create and delete model ([#462](https://www.github.com/googleapis/java-bigquery/issues/462)) ([df6479f](https://www.github.com/googleapis/java-bigquery/commit/df6479f2243193e692313790cbb1720d0279d47a))
* **samples:** add create range partition table ([#458](https://www.github.com/googleapis/java-bigquery/issues/458)) ([68140d5](https://www.github.com/googleapis/java-bigquery/commit/68140d5e463304253a5cc28e6dae9cc73d1bf8d1))
* **samples:** add query ([#463](https://www.github.com/googleapis/java-bigquery/issues/463)) ([e5db01c](https://www.github.com/googleapis/java-bigquery/commit/e5db01cac9309d0d2da819276d69af017c367929))


### Dependencies

* update dependency com.google.apis:google-api-services-bigquery to v2-rev20200603-1.30.9 ([#447](https://www.github.com/googleapis/java-bigquery/issues/447)) ([f53559e](https://www.github.com/googleapis/java-bigquery/commit/f53559e376ff8ebcca7440b977c02feb9b52a64b))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.1 ([#448](https://www.github.com/googleapis/java-bigquery/issues/448)) ([8af668e](https://www.github.com/googleapis/java-bigquery/commit/8af668e2b5e9028cabe70740ea1baa624d35b7c0))
* update dependency com.google.cloud:google-cloud-storage to v1.109.1 ([#453](https://www.github.com/googleapis/java-bigquery/issues/453)) ([01dd6be](https://www.github.com/googleapis/java-bigquery/commit/01dd6be4f8894d11124f6e68545aa3b3b3ee14d8))

### [1.116.2](https://www.github.com/googleapis/java-bigquery/compare/v1.116.1...v1.116.2) (2020-06-09)


### Documentation

* **samples:** add load CSV from GCS sample ([#426](https://www.github.com/googleapis/java-bigquery/issues/426)) ([3810366](https://www.github.com/googleapis/java-bigquery/commit/3810366451097a7f14db11504103865540ac242a))
* **samples:** add load CSV from GCS to overwrite table sample ([#428](https://www.github.com/googleapis/java-bigquery/issues/428)) ([21a3606](https://www.github.com/googleapis/java-bigquery/commit/21a3606f5fb65287f808b12a6fef65817c8a8ba6))
* **samples:** add update table using dml query sample ([#424](https://www.github.com/googleapis/java-bigquery/issues/424)) ([3902ba1](https://www.github.com/googleapis/java-bigquery/commit/3902ba1cf0d8a88d3e6f30b6606067503487c77d)), closes [#413](https://www.github.com/googleapis/java-bigquery/issues/413)
* **samples:** added copy table and accompanying test ([#414](https://www.github.com/googleapis/java-bigquery/issues/414)) ([de0d97f](https://www.github.com/googleapis/java-bigquery/commit/de0d97f2f940c9cf507d19c5595e1a0e819ef19c))
* **samples:** added extract to json and accompanying test ([#416](https://www.github.com/googleapis/java-bigquery/issues/416)) ([16a956d](https://www.github.com/googleapis/java-bigquery/commit/16a956db0aa545df84f7885ffb4425460cf55a16))
* **samples:** adding browse table sample and test ([#422](https://www.github.com/googleapis/java-bigquery/issues/422)) ([dff4e5f](https://www.github.com/googleapis/java-bigquery/commit/dff4e5f86764b1c779c2ef131182483e2ffa1c1b))
* **samples:** adding destination query sample and test ([#418](https://www.github.com/googleapis/java-bigquery/issues/418)) ([0f50961](https://www.github.com/googleapis/java-bigquery/commit/0f50961aaf1092f3ecc4e02fa9cebb50f6d45e90))
* **samples:** adding simple query example for completeness ([#417](https://www.github.com/googleapis/java-bigquery/issues/417)) ([59426df](https://www.github.com/googleapis/java-bigquery/commit/59426df912f743b7927deb562366b625aba6f087))
* **samples:** rename extract table json to extract table csv ([#415](https://www.github.com/googleapis/java-bigquery/issues/415)) ([c1f21e6](https://www.github.com/googleapis/java-bigquery/commit/c1f21e6c16df40bb3c71610f9d5b4fb4855b28fb))


### Dependencies

* update dependency com.google.apis:google-api-services-bigquery to v2-rev20200523-1.30.9 ([#409](https://www.github.com/googleapis/java-bigquery/issues/409)) ([d30c823](https://www.github.com/googleapis/java-bigquery/commit/d30c823c5a604b195f17d8ac33894107cdee967e))

### [1.116.1](https://www.github.com/googleapis/java-bigquery/compare/v1.116.0...v1.116.1) (2020-06-01)


### Dependencies

* remove google-cloud-core classiier=test since it is managed by … ([#396](https://www.github.com/googleapis/java-bigquery/issues/396)) ([bafd8ae](https://www.github.com/googleapis/java-bigquery/commit/bafd8ae780121ee968bca7b3eb68bb0f0a438124))
* restrict -annotation deps ([#402](https://www.github.com/googleapis/java-bigquery/issues/402)) ([db41581](https://www.github.com/googleapis/java-bigquery/commit/db4158186b99d0bed68fd70bef5918b1820e5dd1))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.6.0 ([#392](https://www.github.com/googleapis/java-bigquery/issues/392)) ([3f13ccb](https://www.github.com/googleapis/java-bigquery/commit/3f13ccbbf1ca8f179c48a69c8e456bdf45c43af5))
* update shared-deps and add back certain test deps ([#390](https://www.github.com/googleapis/java-bigquery/issues/390)) ([7e21be2](https://www.github.com/googleapis/java-bigquery/commit/7e21be2506cdaf065cd32e3aed403890929b93e7))


### Documentation

* **samples:** Convert tightly coupled local variable inside of method into method arguments ([#386](https://www.github.com/googleapis/java-bigquery/issues/386)) ([7c02cd3](https://www.github.com/googleapis/java-bigquery/commit/7c02cd3ca7238d24bb2914ae2262a3b2e2d4bda7)), closes [#387](https://www.github.com/googleapis/java-bigquery/issues/387)
* **samples:** Convert tightly coupled local variable involved options inside of method into method arguments ([#393](https://www.github.com/googleapis/java-bigquery/issues/393)) ([a11f3cb](https://www.github.com/googleapis/java-bigquery/commit/a11f3cb4733215a9c4a65936b05f9cc2ed75656f)), closes [#394](https://www.github.com/googleapis/java-bigquery/issues/394)
* **samples:** Fix flaky test ([#397](https://www.github.com/googleapis/java-bigquery/issues/397)) ([64847d1](https://www.github.com/googleapis/java-bigquery/commit/64847d1e5137e811e7f462fc058908fa9fcc55fb))
* **samples:** update revierwers for samples module changes ([#401](https://www.github.com/googleapis/java-bigquery/issues/401)) ([69b9d84](https://www.github.com/googleapis/java-bigquery/commit/69b9d8417d5b910286aaa855f4a83fc151a81cec))

## [1.116.0](https://www.github.com/googleapis/java-bigquery/compare/v1.115.1...v1.116.0) (2020-05-21)


### Features

* remove autovalue profile as it has moved to shared-config ([#370](https://www.github.com/googleapis/java-bigquery/issues/370)) ([57982a0](https://www.github.com/googleapis/java-bigquery/commit/57982a052c7849becbadbed773f951f0e7870a56))


### Bug Fixes

* error message for get routine ([#372](https://www.github.com/googleapis/java-bigquery/issues/372)) ([5966733](https://www.github.com/googleapis/java-bigquery/commit/596673346f9b5540cece041e63019227522062be))

### [1.115.1](https://www.github.com/googleapis/java-bigquery/compare/v1.115.0...v1.115.1) (2020-05-19)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.4.0 ([#362](https://www.github.com/googleapis/java-bigquery/issues/362)) ([7a256f7](https://www.github.com/googleapis/java-bigquery/commit/7a256f734aab3a26a8290a66b11cbcb91fe05d7a))


### Documentation

* **samples:** Added UpdateTableDescription example. ([#360](https://www.github.com/googleapis/java-bigquery/issues/360)) ([96d2c87](https://www.github.com/googleapis/java-bigquery/commit/96d2c87bf087f980106f57ffaac0933274c84b96))

## [1.115.0](https://www.github.com/googleapis/java-bigquery/compare/v1.114.0...v1.115.0) (2020-05-13)


### Features

* add extract model for extractjobconfiguration ([#227](https://www.github.com/googleapis/java-bigquery/issues/227)) ([9e8cd76](https://www.github.com/googleapis/java-bigquery/commit/9e8cd76759e584d743a1d5c310d8cd7299b3a39d))
* add labels for writechannelconfiguration ([#347](https://www.github.com/googleapis/java-bigquery/issues/347)) ([7dbd0df](https://www.github.com/googleapis/java-bigquery/commit/7dbd0df6e46a0760c28925ea65eed9c306c22f21))


### Dependencies

* update dependency com.google.apis:google-api-services-bigquery to v2-rev20200429-1.30.9 ([#349](https://www.github.com/googleapis/java-bigquery/issues/349)) ([cf276d0](https://www.github.com/googleapis/java-bigquery/commit/cf276d02fe4006dc8b8e7fa3f6d062587bf626fa))
* update dependency com.google.auto.service:auto-service-annotations to v1.0-rc7 ([#352](https://www.github.com/googleapis/java-bigquery/issues/352)) ([f66c082](https://www.github.com/googleapis/java-bigquery/commit/f66c08200c1b7847bfe8b5036ae3c89f4ed9aefa))
* update dependency com.google.auto.value:auto-value to v1.7.2 ([#350](https://www.github.com/googleapis/java-bigquery/issues/350)) ([a6ae45f](https://www.github.com/googleapis/java-bigquery/commit/a6ae45f11a5fca33d066d08b0975e0b9c1c4fca9))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.3.1 ([#351](https://www.github.com/googleapis/java-bigquery/issues/351)) ([002d863](https://www.github.com/googleapis/java-bigquery/commit/002d863c88916f196685f06d16822f6824a7eb84))


### Documentation

* update CONTRIBUTING.md to include code formatting ([#534](https://www.github.com/googleapis/java-bigquery/issues/534)) ([#346](https://www.github.com/googleapis/java-bigquery/issues/346)) ([df0c3e6](https://www.github.com/googleapis/java-bigquery/commit/df0c3e6767890e1b1cc164a6d06ce4fabc8edd7a))

## [1.114.0](https://www.github.com/googleapis/java-bigquery/compare/v1.113.0...v1.114.0) (2020-05-11)


### Features

* add hourly partitioning support ([#336](https://www.github.com/googleapis/java-bigquery/issues/336)) ([90f9980](https://www.github.com/googleapis/java-bigquery/commit/90f998040bbca5882ac3dbcdb4b157f26f48eb01))

## [1.113.0](https://www.github.com/googleapis/java-bigquery/compare/v1.112.0...v1.113.0) (2020-05-05)


### Features

* switch to use java-shared-deps ([#323](https://www.github.com/googleapis/java-bigquery/issues/323)) ([091a6a9](https://www.github.com/googleapis/java-bigquery/commit/091a6a99a955ae116d61c9cc2663a63cee81e18c))

## [1.112.0](https://www.github.com/googleapis/java-bigquery/compare/v1.111.3...v1.112.0) (2020-05-05)


### Features

* add support connection properties for job and query ([#320](https://www.github.com/googleapis/java-bigquery/issues/320)) ([dcd3663](https://www.github.com/googleapis/java-bigquery/commit/dcd366373f5804da1e8226c110e89c3de5749926))


### Dependencies

* update dependency com.google.api.grpc:proto-google-common-protos to v1.18.0 ([#318](https://www.github.com/googleapis/java-bigquery/issues/318)) ([3dade31](https://www.github.com/googleapis/java-bigquery/commit/3dade31ce828322753dd40f90e2e019cad40f83a))
* update dependency com.google.cloud:google-cloud-storage to v1.108.0 ([#317](https://www.github.com/googleapis/java-bigquery/issues/317)) ([63563e6](https://www.github.com/googleapis/java-bigquery/commit/63563e646e85a6caa1eb28819be9fad0083100d7))

### [1.111.3](https://www.github.com/googleapis/java-bigquery/compare/v1.111.2...v1.111.3) (2020-05-04)


### Bug Fixes

* null type in timepartitioning frompb ([#305](https://www.github.com/googleapis/java-bigquery/issues/305)) ([6315842](https://www.github.com/googleapis/java-bigquery/commit/6315842dfa62a433a1ba507b861cf96a3d7cb03d))


### Dependencies

* update dependency com.google.apis:google-api-services-bigquery to v2-rev20200415-1.30.9 ([#307](https://www.github.com/googleapis/java-bigquery/issues/307)) ([fccb0b4](https://www.github.com/googleapis/java-bigquery/commit/fccb0b4d08b41e4836ac9490befca47306f14afd))
* update dependency com.google.auto.value:auto-value to v1.7.1 ([#308](https://www.github.com/googleapis/java-bigquery/issues/308)) ([5a0ed06](https://www.github.com/googleapis/java-bigquery/commit/5a0ed060eb2c966092af66bfae2896ea8af70c7e))

### [1.111.2](https://www.github.com/googleapis/java-bigquery/compare/v1.111.1...v1.111.2) (2020-04-29)


### Dependencies

* update core transport dependencies to v1.35.0 ([#298](https://www.github.com/googleapis/java-bigquery/issues/298)) ([95f9443](https://www.github.com/googleapis/java-bigquery/commit/95f9443fad2f561df8f8108c3e323729d8195d46))
* update dependency org.threeten:threetenbp to v1.4.4 ([#293](https://www.github.com/googleapis/java-bigquery/issues/293)) ([21d0c58](https://www.github.com/googleapis/java-bigquery/commit/21d0c588d61ded31cb45ff10bf7824f8203c9314))

### [1.111.1](https://www.github.com/googleapis/java-bigquery/compare/v1.111.0...v1.111.1) (2020-04-22)


### Dependencies

* fix build errors ([#286](https://www.github.com/googleapis/java-bigquery/issues/286)) ([4b478b0](https://www.github.com/googleapis/java-bigquery/commit/4b478b0fc21d31472939dceece4ba059a8a0ea16))
* update dependency io.grpc:grpc-bom to v1.29.0 ([#284](https://www.github.com/googleapis/java-bigquery/issues/284)) ([e72a99f](https://www.github.com/googleapis/java-bigquery/commit/e72a99f225176d18d308bef2c8cc69a18390a3ce))

## [1.111.0](https://www.github.com/googleapis/java-bigquery/compare/v1.110.1...v1.111.0) (2020-04-16)


### Features

* add flatten plugin ([#276](https://www.github.com/googleapis/java-bigquery/issues/276)) ([f7e89ab](https://www.github.com/googleapis/java-bigquery/commit/f7e89abe440b27bf05adea7ec0a89d8eec6ceac5))


### Bug Fixes

* fieldvalue gettimestamp ([#279](https://www.github.com/googleapis/java-bigquery/issues/279)) ([4478a23](https://www.github.com/googleapis/java-bigquery/commit/4478a230a130cab45735e198a204fc9163b5a00e)), closes [#16](https://www.github.com/googleapis/java-bigquery/issues/16)


### Dependencies

* update dependency com.google.cloud:google-cloud-storage to v1.107.0 ([#273](https://www.github.com/googleapis/java-bigquery/issues/273)) ([6ef0502](https://www.github.com/googleapis/java-bigquery/commit/6ef0502ebb9ba56c896e028ca884efadbdce3303))
* update dependency com.google.guava:guava-bom to v29 ([#267](https://www.github.com/googleapis/java-bigquery/issues/267)) ([a115c6b](https://www.github.com/googleapis/java-bigquery/commit/a115c6b5ed2c391f4837936f28467b67f323900a))

### [1.110.1](https://www.github.com/googleapis/java-bigquery/compare/v1.110.0...v1.110.1) (2020-04-06)


### Dependencies

* update core dependencies to v1.55.0 ([#250](https://www.github.com/googleapis/java-bigquery/issues/250)) ([caeaebf](https://www.github.com/googleapis/java-bigquery/commit/caeaebfcaa804e70c9a13370339509d7a1b281c7))
* update core dependencies to v1.56.0 ([#258](https://www.github.com/googleapis/java-bigquery/issues/258)) ([1c85a6b](https://www.github.com/googleapis/java-bigquery/commit/1c85a6b3d7c64bd5d774b78a182baf728fc110b5))
* update core dependencies to v1.93.4 ([#259](https://www.github.com/googleapis/java-bigquery/issues/259)) ([07b3091](https://www.github.com/googleapis/java-bigquery/commit/07b30916f8ab2b8680eedea14f73c94a4329343c))
* update dependency com.google.api:api-common to v1.9.0 ([#246](https://www.github.com/googleapis/java-bigquery/issues/246)) ([783f1ad](https://www.github.com/googleapis/java-bigquery/commit/783f1ade581b3930f5585a30b4c1c278762e0d9d))
* update dependency com.google.apis:google-api-services-bigquery to v2-rev20200324-1.30.9 ([#252](https://www.github.com/googleapis/java-bigquery/issues/252)) ([0570d13](https://www.github.com/googleapis/java-bigquery/commit/0570d13c4c168842480b8f83c03d4b19ed88050d))
* update dependency com.google.cloud.samples:shared-configuration to v1.0.13 ([#243](https://www.github.com/googleapis/java-bigquery/issues/243)) ([4c62001](https://www.github.com/googleapis/java-bigquery/commit/4c620018288b36d7e8743c0ace37ef25397d1060))
* update dependency io.grpc:grpc-bom to v1.28.1 ([#254](https://www.github.com/googleapis/java-bigquery/issues/254)) ([546861d](https://www.github.com/googleapis/java-bigquery/commit/546861d5e73624efe18b6ca04286720ef74ceed5))
* update dependency org.threeten:threetenbp to v1.4.3 ([#256](https://www.github.com/googleapis/java-bigquery/issues/256)) ([b0457f0](https://www.github.com/googleapis/java-bigquery/commit/b0457f04bbf2a2528b2672d4ea5889d064a123b2))

## [1.110.0](https://www.github.com/googleapis/java-bigquery/compare/v1.109.0...v1.110.0) (2020-03-20)


### Features

* add support for Hive partitioning options when creating external tables ([#235](https://www.github.com/googleapis/java-bigquery/issues/235)) ([#236](https://www.github.com/googleapis/java-bigquery/issues/236)) ([ccc2bb3](https://www.github.com/googleapis/java-bigquery/commit/ccc2bb3de28a36e3791d5441c8bdea2333877ee8))

## [1.109.0](https://www.github.com/googleapis/java-bigquery/compare/v1.108.1...v1.109.0) (2020-03-20)


### Features

* add materialize view ([#174](https://www.github.com/googleapis/java-bigquery/issues/174)) ([d33b645](https://www.github.com/googleapis/java-bigquery/commit/d33b64594f9b3217b0fc89d255618b558a9d45e8))
* add struct query parameters ([#223](https://www.github.com/googleapis/java-bigquery/issues/223)) ([c1997dd](https://www.github.com/googleapis/java-bigquery/commit/c1997ddaca825acd94aafb15fef65c1c272d3284))
* expose hivepartitioningoptions ([#233](https://www.github.com/googleapis/java-bigquery/issues/233)) ([6213ea9](https://www.github.com/googleapis/java-bigquery/commit/6213ea98c7b58634c11ffd13e925482a3627c5dc))


### Dependencies

* update core dependencies ([#218](https://www.github.com/googleapis/java-bigquery/issues/218)) ([3573899](https://www.github.com/googleapis/java-bigquery/commit/3573899485431f57703c2dc1615df79a3a37d075))
* update core dependencies to v1.93.3 ([#224](https://www.github.com/googleapis/java-bigquery/issues/224)) ([0338e39](https://www.github.com/googleapis/java-bigquery/commit/0338e397f61fc87d048f2869e5ee5bba2e584caa))
* update dependency com.google.apis:google-api-services-bigquery to v2-rev20191211-1.30.9 ([#212](https://www.github.com/googleapis/java-bigquery/issues/212)) ([8475bd9](https://www.github.com/googleapis/java-bigquery/commit/8475bd9e39b5ec0ebbb43ab12beba43de3bff139))
* update dependency com.google.cloud:google-cloud-storage to v1.105.1 ([#216](https://www.github.com/googleapis/java-bigquery/issues/216)) ([f4a1199](https://www.github.com/googleapis/java-bigquery/commit/f4a11991ae129ef1da2764b163d82838e59737ac))
* update dependency com.google.cloud:google-cloud-storage to v1.105.2 ([#220](https://www.github.com/googleapis/java-bigquery/issues/220)) ([42f6529](https://www.github.com/googleapis/java-bigquery/commit/42f6529d54abdc91111187d026bd256905d7c83d))
* update dependency com.google.cloud:google-cloud-storage to v1.106.0 ([#226](https://www.github.com/googleapis/java-bigquery/issues/226)) ([b78aa00](https://www.github.com/googleapis/java-bigquery/commit/b78aa00519c8af7777ef9015364d6b0259296170))
* update dependency com.google.cloud.samples:shared-configuration to v1.0.12 ([#210](https://www.github.com/googleapis/java-bigquery/issues/210)) ([40a96a0](https://www.github.com/googleapis/java-bigquery/commit/40a96a0dcea2ec56e50479d92d02b58c8972ac36))
* update dependency org.threeten:threetenbp to v1.4.2 ([#237](https://www.github.com/googleapis/java-bigquery/issues/237)) ([ec6328e](https://www.github.com/googleapis/java-bigquery/commit/ec6328ec22e844a9db2a156a7c4e3e4f166cc2b6))

### [1.108.1](https://www.github.com/googleapis/java-bigquery/compare/v1.108.0...v1.108.1) (2020-03-03)


### Dependencies

* update core dependencies to v1.93.1 ([#208](https://www.github.com/googleapis/java-bigquery/issues/208)) ([cea38ba](https://www.github.com/googleapis/java-bigquery/commit/cea38bad185017fd27c4c1b43c17caa709519f8b))
* update dependency com.google.cloud:google-cloud-storage to v1.105.0 ([#201](https://www.github.com/googleapis/java-bigquery/issues/201)) ([1c64193](https://www.github.com/googleapis/java-bigquery/commit/1c641935a89d9702c688b1ba71964607d7f4e353))

## [1.108.0](https://www.github.com/googleapis/java-bigquery/compare/v1.107.0...v1.108.0) (2020-02-28)


### Features

* expose requirepartitionfilter field in table ([#158](https://www.github.com/googleapis/java-bigquery/issues/158)) ([3e51ea0](https://www.github.com/googleapis/java-bigquery/commit/3e51ea02bb9a40c4d20b31a5435954c4d087f26d))
* re-generated  to pick up changes in the API or client library generator. ([#188](https://www.github.com/googleapis/java-bigquery/issues/188)) ([2720b12](https://www.github.com/googleapis/java-bigquery/commit/2720b12f536ad363d9884b5082b7e238183a95e9))


### Dependencies

* update core dependencies ([#196](https://www.github.com/googleapis/java-bigquery/issues/196)) ([0c5bb7f](https://www.github.com/googleapis/java-bigquery/commit/0c5bb7feb6d24ffb2c87ab433c52aaf4b0aa1b91))

## [1.107.0](https://www.github.com/googleapis/java-bigquery/compare/v1.106.0...v1.107.0) (2020-02-19)


### Features

* expose location field of model ([#175](https://www.github.com/googleapis/java-bigquery/issues/175)) ([646c2b4](https://www.github.com/googleapis/java-bigquery/commit/646c2b43b2ccbc609e0d5b85a7e4fbf502bb1243))
* expose slotms field in querystage ([#172](https://www.github.com/googleapis/java-bigquery/issues/172)) ([4a82b3c](https://www.github.com/googleapis/java-bigquery/commit/4a82b3cd1aa821d72efc7046329db075c10ae344))


### Bug Fixes

* allUsers access ([#178](https://www.github.com/googleapis/java-bigquery/issues/178)) ([7464e23](https://www.github.com/googleapis/java-bigquery/commit/7464e234c00da047a06744eef6c7f281d90217cd))


### Dependencies

* update core dependencies to v1.92.5 ([#162](https://www.github.com/googleapis/java-bigquery/issues/162)) ([6ea4141](https://www.github.com/googleapis/java-bigquery/commit/6ea41413aed3d6cc81b9c4995a21f1017e268c74))
* update core transport dependencies to v1.34.2 ([#168](https://www.github.com/googleapis/java-bigquery/issues/168)) ([c35069d](https://www.github.com/googleapis/java-bigquery/commit/c35069d4e91939e51f2101f2b8f93d2f67c089c5))
* update dependency com.google.apis:google-api-services-bigquery to v2-rev20191211-1.30.8 ([#161](https://www.github.com/googleapis/java-bigquery/issues/161)) ([54872ba](https://www.github.com/googleapis/java-bigquery/commit/54872ba95ff0903817df217dfa6da883d43e6ace))
* update dependency com.google.cloud:libraries-bom to v4 ([#159](https://www.github.com/googleapis/java-bigquery/issues/159)) ([95e4ff0](https://www.github.com/googleapis/java-bigquery/commit/95e4ff068dd8650ec0acebbe23e958c6e361ed36))
* update dependency com.google.cloud:libraries-bom to v4.0.1 ([#167](https://www.github.com/googleapis/java-bigquery/issues/167)) ([633ea52](https://www.github.com/googleapis/java-bigquery/commit/633ea52ddc3677e8091c1f69283a864929227a17))
* update dependency com.google.cloud:libraries-bom to v4.1.0 ([#170](https://www.github.com/googleapis/java-bigquery/issues/170)) ([6acedda](https://www.github.com/googleapis/java-bigquery/commit/6aceddad33da3055b24a8ae0420c25d85cfb09fb))
* update dependency com.google.protobuf:protobuf-java to v3.11.4 ([#171](https://www.github.com/googleapis/java-bigquery/issues/171)) ([6f292f5](https://www.github.com/googleapis/java-bigquery/commit/6f292f52728992bfeb511b97b1dd778e1ef8db2c))
* update dependency io.grpc:grpc-bom to v1.27.1 ([#169](https://www.github.com/googleapis/java-bigquery/issues/169)) ([5212b2f](https://www.github.com/googleapis/java-bigquery/commit/5212b2f892074be36204fa9ef3e2dff7474828eb))


### Documentation

* broken links ([#154](https://www.github.com/googleapis/java-bigquery/issues/154)) ([e060aba](https://www.github.com/googleapis/java-bigquery/commit/e060aba2ed030a13e50f5e0f5597b3e04ad9c292))

## [1.106.0](https://www.github.com/googleapis/java-bigquery/compare/v1.105.0...v1.106.0) (2020-02-03)


### Features

* re-generated  to pick up changes in the API or client library generator. ([#146](https://www.github.com/googleapis/java-bigquery/issues/146)) ([8b5a2e2](https://www.github.com/googleapis/java-bigquery/commit/8b5a2e23fbc043d323ce1e07f40ceb2886ec7697))


### Bug Fixes

* missing fields in tablefield ([#143](https://www.github.com/googleapis/java-bigquery/issues/143)) ([1f719fb](https://www.github.com/googleapis/java-bigquery/commit/1f719fb5dda9bd0198004c9622614ab469d1b2ea))


### Dependencies

* bump hamcrest dep version and artifactId ([#136](https://www.github.com/googleapis/java-bigquery/issues/136)) ([fc255cd](https://www.github.com/googleapis/java-bigquery/commit/fc255cd320735b24b1105d0512d6e1d20f95d031))
* update core dependencies ([#122](https://www.github.com/googleapis/java-bigquery/issues/122)) ([41ec3a7](https://www.github.com/googleapis/java-bigquery/commit/41ec3a7773b546b49b9983a6fee73d7581b9b9d6))
* update core dependencies ([#144](https://www.github.com/googleapis/java-bigquery/issues/144)) ([c6622b8](https://www.github.com/googleapis/java-bigquery/commit/c6622b814a84e8b05ad35e87e9bf55611fb8bb28))
* update dependency com.google.cloud:google-cloud-storage to v1.103.1 ([#130](https://www.github.com/googleapis/java-bigquery/issues/130)) ([e30b3d7](https://www.github.com/googleapis/java-bigquery/commit/e30b3d7701d3d255fe5e32d6b25a5b28f7fd94e0))
* update dependency com.google.protobuf:protobuf-java to v3.11.3 ([#147](https://www.github.com/googleapis/java-bigquery/issues/147)) ([e619233](https://www.github.com/googleapis/java-bigquery/commit/e619233c9309a4b2f16f117017df53ec997b898e))

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
