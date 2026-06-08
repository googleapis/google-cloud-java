# Changelog

All notable changes to the BigQuery JDBC driver (`google-cloud-bigquery-jdbc`) will be documented in this file.

## [0.10.0](https://github.com/googleapis/google-cloud-java/compare/v1.85.0...v1.86.0) (2026-05-05)

### Features

* Per connection logs - Add BigQueryJdbcMdc (#12833) ([f562667](https://github.com/googleapis/google-cloud-java/commit/f562667366260fd488ab149ec3e8b67b0bb350f3))
* Per connection logs - Add PerConnectionFileHandler (#12899) ([5846197](https://github.com/googleapis/google-cloud-java/commit/5846197cc28a700964914d32cfbf90bfee3b37a8))
* Integrate the PerConnectionFileHandler with BigQueryJdbcRootLogger (#12933) ([2e56184](https://github.com/googleapis/google-cloud-java/commit/2e56184849a0888256a48ace191a870287ce1fef))
* Bypass dry-run job for read-only tokens. (#12961) ([cd57169](https://github.com/googleapis/google-cloud-java/commit/cd571691f5aaadbd3bfa7ee2dfad5414cef6127c2))

### Bug Fixes

* optimize formatter in BigQueryJdbcRootLogger (#12877) ([4233faf](https://github.com/googleapis/google-cloud-java/commit/4233fafb2118ad28f89c996899a52b37d48c79eb))
* enhance logging with caller inference and explicit exception tracking (#12903) ([ce4969b](https://github.com/googleapis/google-cloud-java/commit/ce4969b81e18a165d2c6cb245a8073923ab92567))
* Log exception messages - part 2 (#12907) ([5215b11](https://github.com/googleapis/google-cloud-java/commit/5215b119726f124ff9228dcfe86ebca54f7915ae))
* Log exception messages - part 3 (#12920) ([45b572f](https://github.com/googleapis/google-cloud-java/commit/45b572fae59d9448d9d8c5561be3735496142154))
* support Service Account Impersonation in ADC (#12967) ([8ce183c](https://github.com/googleapis/google-cloud-java/commit/8ce183cf802f1abadb809bfe733d904570980968))
* metadata methods & getSqlTypeName for struct (#12947) ([37555fb](https://github.com/googleapis/google-cloud-java/commit/37555fb09f209bbeb8f32f1661d83a7548175411))
* add default OAuth client id/secret (#12946) ([9b5c4fa](https://github.com/googleapis/google-cloud-java/commit/9b5c4fa3bff718170b63c1cc404e4dd4cacfbbdc))

### Refactors & Chores

* helper tools (#12973) ([856febf](https://github.com/googleapis/google-cloud-java/commit/856febf3773601e998a1cc61c397fad13c2bc084))
* switch connection identifier to UUID (#12957) ([99b1894](https://github.com/googleapis/google-cloud-java/commit/99b1894e99f86f11d043b18dc7441d00fb54e245))
* enhance exception messages to include chained exception message (#12996) ([c7f44aa](https://github.com/googleapis/google-cloud-java/commit/c7f44aa067c2eeef6ed5e7cbe7e0530555b74a06))

---

## [0.9.0](https://github.com/googleapis/google-cloud-java/compare/v1.84.0...v1.85.0) (2026-04-13)

### Bug Fixes

* Revert DatabaseMetaData field to be non-static in BigQueryConnection (#12778) ([ac69c8d](https://github.com/googleapis/google-cloud-java/commit/ac69c8d9041121b7bdd1f7cb7b6b0d2f182ba138)) _(First released in v1.85.1 patch)_
* add Google Driver scope to all credential types (#12847) ([5c890f8](https://github.com/googleapis/google-cloud-java/commit/5c890f80f7f7ffef1d099104f605298486fe636d)) _(First released in v1.85.1 patch)_
* lazily instantiate Statement in BigQueryDatabaseMetaData (#12752) ([72e5508](https://github.com/googleapis/google-cloud-java/commit/72e5508669ea48cde28f02adfeedfb05cd73fc57)) _(First released in v1.85.0)_

---

## [0.8.0](https://github.com/googleapis/google-cloud-java/compare/v1.82.0...v1.84.0) (2026-04-12)

### Refactors & Chores

* move extended test suite to monorepo (#12696) ([9b455b9](https://github.com/googleapis/google-cloud-java/commit/9b455b9e0f70997f2e92a891146f1e9be96bbfd7))
* chore(jdbc bq): makefile commands to run standalone IT tests (#12666) ([91eb471](https://github.com/googleapis/google-cloud-java/commit/91eb471c21d687e09f7505997d6220f9480eb5da))
* change uber jar bundling rules (#12195) ([ed0ac75](https://github.com/googleapis/google-cloud-java/commit/ed0ac7548078c8d16f2386e0645d73c1ba8bd995))

---

## [0.7.0](https://github.com/googleapis/google-cloud-java/compare/v1.82.0...a35f1c267d8) (2026-04-07)

### Bug Fixes

* ensure getMoreResults() always moves the cursor (#12353) ([ac1f0f4](https://github.com/googleapis/google-cloud-java/commit/ac1f0f44f92cdddb1aad7d0852a11203465fe874))
* allow & ignore unknown parameters (#12352) ([2332ff1](https://github.com/googleapis/google-cloud-java/commit/2332ff1036116903ee5dab3e71c44950995fab61))

---

## [0.6.0](https://github.com/googleapis/google-cloud-java/compare/v1.81.0...v1.82.0) (2026-03-20)

### Bug Fixes

* unshade BQ SDK in uber jar (#12078) ([c4cabde](https://github.com/googleapis/google-cloud-java/commit/c4cabdee72c3abf9d1a0675d5092d0c5658dafc5))

### Refactors & Chores

* migrate to junit5 (#12079) ([b1c6fad](https://github.com/googleapis/google-cloud-java/commit/b1c6fada37977c24c41c2d22303037b019d5abbe))
* Add integration test suites (#12102) ([b1cdcb5](https://github.com/googleapis/google-cloud-java/commit/b1cdcb55ec8858aaba94115c896b2fa843d18584))
* fix docker environment commands (#12107) ([353f577](https://github.com/googleapis/google-cloud-java/commit/353f577073952a848675805d410eea04e5a8288a))

---

## [0.5.0](https://github.com/googleapis/google-cloud-java/compare/11426bebb2f...v1.81.0) (2026-03-12)

### Refactors & Chores

* BQ JDBC presubmit & nightly (#12062) ([f541ef6](https://github.com/googleapis/google-cloud-java/commit/f541ef67adef0aa180740c184a89292e1c1bea66))
* match the file tree of 8ce5f4d4284 java-bigquery migration to monorepo ([11426be](https://github.com/googleapis/google-cloud-java/commit/11426bebb2ff87e005dca47c534f2d8e446a693d))

---

## [0.4.0](https://github.com/googleapis/java-bigquery/compare/v2.59.0...v2.60.0) (2026-02-27) _(Released in split repository java-bigquery)_

### Features

* enforce strict JDBC URL parsing and sync `DataSource` properties (#4107) ([53fcbcf](https://github.com/googleapis/google-cloud-java/commit/53fcbcf59596d5d0c2d2e9aa5072016ebb1087c1))
* centralize connection properties from `BigQueryConnection` and `DataSource` (#4116) ([1b2a116](https://github.com/googleapis/google-cloud-java/commit/1b2a1162ef7f37591862930d67bbc092daf817b0))

### Bug Fixes

* various perf improvements (#4114) ([eeb73b1](https://github.com/googleapis/google-cloud-java/commit/eeb73b1efa4eb4b46a542a285ce68687b26d7de2))

### Refactors & Chores

* add console logs during tests (#4130) ([ccdf939](https://github.com/googleapis/google-cloud-java/commit/ccdf93910ebbc58f8bf6bd636ca81473b5564d2f))

---

## [0.3.0](https://github.com/googleapis/java-bigquery/compare/v2.58.0...v2.59.0) (2026-02-12) _(Released in split repository java-bigquery)_

### Features

* add retry mechanism for storage api (#4100) ([00a6539](https://github.com/googleapis/google-cloud-java/commit/00a653991dd746fead63586cb734d802ae9bbcd5))

---

## [0.2.0](https://github.com/googleapis/java-bigquery/compare/v2.57.2...v2.58.0) (2026-01-26) _(Released in split repository java-bigquery)_

### Features

* enable gRPC Keep-Alive for Storage Read API (#4093) ([63b0ec5](https://github.com/googleapis/google-cloud-java/commit/63b0ec5fda2794beff54d6ba50bc8ae01f2bcdbf))
* add `RequestReason` connection property (#4094) ([b4463ee](https://github.com/googleapis/google-cloud-java/commit/b4463ee276edd8321e92b5b6ce96d8116842f5ee))
* add `HttpTransportOptions` timeout configuration (#4089) ([8b74a8d](https://github.com/googleapis/google-cloud-java/commit/8b74a8d5253e3f34c60c9927c95b704d61783540))

### Bug Fixes

* return null for invalid URLs in `connect()` to comply with JDBC spec (#4086) ([6f43754](https://github.com/googleapis/google-cloud-java/commit/6f43754e29320dbc39fb199cdb63276218c4bef6))
* avoid String.format in log calls (#4096) ([8c4528a](https://github.com/googleapis/google-cloud-java/commit/8c4528a5f1ae905c9995a90aeec6c9f29ac445ea))

### Refactors & Chores

* add readme for `google-cloud-bigquery-jdbc` (#4071) ([47bf46d](https://github.com/googleapis/google-cloud-java/commit/47bf46dac409b1c835679267f5c16d3d9cd7e39b))
* shade bq sdk in jdbc 'all' package (#4092) ([dcb7747](https://github.com/googleapis/google-cloud-java/commit/dcb7747a07bc5fdb480936c02d00df9152d4f2af))

---

## [0.1.0](https://github.com/googleapis/java-bigquery/commit/ffb0fdfbbb8ed08c8e221e68544f3076e90c0039) (2026-01-19) _(Initial preview in split repository release v2.57.2)_

### Refactors & Chores

* move Google JDBC driver code (#4050) ([c3a1b78](https://github.com/googleapis/google-cloud-java/commit/c3a1b787e63c6e75805956f9abca8d93186424ab))
* moving helper scripts & simplify dependencies (#4062) ([e9bc501](https://github.com/googleapis/google-cloud-java/commit/e9bc501db0403e1cd293f74c98867b04ed2b0b24))
* JDBC presubmit & nightly pipelines (#4066) ([bd4d8ea](https://github.com/googleapis/google-cloud-java/commit/bd4d8ea255d4c2b8e20666124b0c41c347fba800))
* add nightly JAR build (#4076) ([c48a7d7](https://github.com/googleapis/google-cloud-java/commit/c48a7d790632156fc7c9d92c37cb2ae7d3e6bb8a))
