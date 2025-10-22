# Changelog

## [2.68.0](https://github.com/googleapis/java-bigtable/compare/v2.67.1...v2.68.0) (2025-10-22)


### Features

* Add Type API updates needed to support structured keys in materialized views ([469290e](https://github.com/googleapis/java-bigtable/commit/469290eb188ce7155abc81d4fec9dd8319851cd9))


### Bug Fixes

* Add ReadRows/SampleRowKeys bindings for materialized views ([469290e](https://github.com/googleapis/java-bigtable/commit/469290eb188ce7155abc81d4fec9dd8319851cd9))
* **deps:** Update the Java code generator (gapic-generator-java) to 2.62.3 ([469290e](https://github.com/googleapis/java-bigtable/commit/469290eb188ce7155abc81d4fec9dd8319851cd9))
* **deps:** Update the Java code generator (gapic-generator-java) to 2.63.0 ([ed6c03f](https://github.com/googleapis/java-bigtable/commit/ed6c03ff50f42a06472f5be781b68937f48228d1))
* Don't use String.format in Preconditions messages ([#2691](https://github.com/googleapis/java-bigtable/issues/2691)) ([62a1812](https://github.com/googleapis/java-bigtable/commit/62a18128d8ec65484509dde6cd0c2b0322890cc9))
* Fixed the bigtableadmin API name for snippet region tags and possibly other GAPIC attributes ([469290e](https://github.com/googleapis/java-bigtable/commit/469290eb188ce7155abc81d4fec9dd8319851cd9))


### Dependencies

* Update shared dependencies ([#2697](https://github.com/googleapis/java-bigtable/issues/2697)) ([611ad20](https://github.com/googleapis/java-bigtable/commit/611ad208359e3c1f2e675d5e4e8c8ade3616b02b))

## [2.67.1](https://github.com/googleapis/java-bigtable/compare/v2.67.0...v2.67.1) (2025-10-08)


### Dependencies

* Update shared dependencies ([#2686](https://github.com/googleapis/java-bigtable/issues/2686)) ([d7eaa02](https://github.com/googleapis/java-bigtable/commit/d7eaa02d89a63d9f9197d26e430267eff200b126))

## [2.67.0](https://github.com/googleapis/java-bigtable/compare/v2.66.0...v2.67.0) (2025-09-24)


### Features

* Idle channel eviction ([#2651](https://github.com/googleapis/java-bigtable/issues/2651)) ([70c05c9](https://github.com/googleapis/java-bigtable/commit/70c05c9c09a63c53818384d2a66c622c9b95e00e))
* Load balancing options for BigtableChannelPool ([#2667](https://github.com/googleapis/java-bigtable/issues/2667)) ([5adaa84](https://github.com/googleapis/java-bigtable/commit/5adaa84d80df08779da7c36a50de4632049cfe96))


### Bug Fixes

* Add missing break; to PROTO and ENUM value type check ([#2672](https://github.com/googleapis/java-bigtable/issues/2672)) ([337e432](https://github.com/googleapis/java-bigtable/commit/337e4325f6cb5d11309ec5f33550d47d97cbe3c3))
* Remove beta api annotation for query paginator ([#2660](https://github.com/googleapis/java-bigtable/issues/2660)) ([f68a1fa](https://github.com/googleapis/java-bigtable/commit/f68a1fae49b701d1fb9942e2af2fa84a1e5b508a))


### Dependencies

* Update shared dependencies ([#2679](https://github.com/googleapis/java-bigtable/issues/2679)) ([a5b8260](https://github.com/googleapis/java-bigtable/commit/a5b82609c365ae4792ed822e59039c1a046ef3ff))

## [2.66.0](https://github.com/googleapis/java-bigtable/compare/v2.65.1...v2.66.0) (2025-09-10)


### Features

* Add support for Proto and Enum types ([#2662](https://github.com/googleapis/java-bigtable/issues/2662)) ([da3065d](https://github.com/googleapis/java-bigtable/commit/da3065db331be191fdf9e06be71e45c7832574ea))


### Dependencies

* Update dependency com.google.cloud:sdk-platform-java-config to v3.52.1 ([#2668](https://github.com/googleapis/java-bigtable/issues/2668)) ([06ac93e](https://github.com/googleapis/java-bigtable/commit/06ac93e810830f9c04920b488d9a10af8995a6f3))

## [2.65.1](https://github.com/googleapis/java-bigtable/compare/v2.65.0...v2.65.1) (2025-08-27)


### Dependencies

* Update shared dependencies ([#2664](https://github.com/googleapis/java-bigtable/issues/2664)) ([841318b](https://github.com/googleapis/java-bigtable/commit/841318b2248dcda89d8482bc2e84c838bd8be8d0))

## [2.65.0](https://github.com/googleapis/java-bigtable/compare/v2.64.0...v2.65.0) (2025-08-12)


### Features

* **bigtable:** Lower the value for max rpc channels as channel resize is slow (1m, 2 channel) ([#2656](https://github.com/googleapis/java-bigtable/issues/2656)) ([d8055c1](https://github.com/googleapis/java-bigtable/commit/d8055c1fb75a616cda1503b92d7cddb9da47d42b))

## [2.64.0](https://github.com/googleapis/java-bigtable/compare/v2.63.0...v2.64.0) (2025-08-08)


### Features

* Add tags field to Instance proto (stable branch) ([089d527](https://github.com/googleapis/java-bigtable/commit/089d52700c225015fabfaa763163c5874b96d830))


### Bug Fixes

* **deps:** Update the Java code generator (gapic-generator-java) to 2.61.0 ([089d527](https://github.com/googleapis/java-bigtable/commit/089d52700c225015fabfaa763163c5874b96d830))


### Dependencies

* Update shared dependencies ([#2654](https://github.com/googleapis/java-bigtable/issues/2654)) ([4b706f4](https://github.com/googleapis/java-bigtable/commit/4b706f4f76a8152556aa99656b440adb30f37a4c))

## [2.63.0](https://github.com/googleapis/java-bigtable/compare/v2.62.0...v2.63.0) (2025-07-30)


### Features

* Add Idempotency to Cloud Bigtable MutateRowsRequest API ([bc58b4f](https://github.com/googleapis/java-bigtable/commit/bc58b4f31ef457bd322f270b044735e4b62d298f))
* Add port as a parameter for the bigtable emulator ([#2645](https://github.com/googleapis/java-bigtable/issues/2645)) ([5acd3dc](https://github.com/googleapis/java-bigtable/commit/5acd3dc01c36072bd28248d560c5d923c34b1817))
* Add type support for Proto and Enum ([bc58b4f](https://github.com/googleapis/java-bigtable/commit/bc58b4f31ef457bd322f270b044735e4b62d298f))
* Publish Proto and Enum types to CBT data API ([ace12d5](https://github.com/googleapis/java-bigtable/commit/ace12d53fe9f4d3779b2b1a2aed69ceeedd11600))
* Selective GAPIC autogeneration for Python Bigtable Admin ([e219c38](https://github.com/googleapis/java-bigtable/commit/e219c387487673869fb8bb55a5060bdc9d37bbcb))


### Bug Fixes

* **deps:** Update the Java code generator (gapic-generator-java) to 2.60.2 ([e219c38](https://github.com/googleapis/java-bigtable/commit/e219c387487673869fb8bb55a5060bdc9d37bbcb))
* Update routing_parameters.path_template ([e219c38](https://github.com/googleapis/java-bigtable/commit/e219c387487673869fb8bb55a5060bdc9d37bbcb))


### Dependencies

* Update sdk-platorm-java-config to 3.50.2 ([#2646](https://github.com/googleapis/java-bigtable/issues/2646)) ([03e6961](https://github.com/googleapis/java-bigtable/commit/03e6961e758a9a0c39cb168c73c853328c14bfd1))


### Documentation

* Sync generated comments from the API Protos ([bc58b4f](https://github.com/googleapis/java-bigtable/commit/bc58b4f31ef457bd322f270b044735e4b62d298f))

## [2.62.0](https://github.com/googleapis/java-bigtable/compare/v2.61.0...v2.62.0) (2025-07-15)


### Features

* Add Idempotency to Cloud Bigtable MutateRowRequest API ([b5acca6](https://github.com/googleapis/java-bigtable/commit/b5acca6ac4f1eec420adb27bc77aa1bda0ec2dca))
* Add SchemaBundles API ([b5acca6](https://github.com/googleapis/java-bigtable/commit/b5acca6ac4f1eec420adb27bc77aa1bda0ec2dca))
* **bigtable:** Add schema bundle support ([#2619](https://github.com/googleapis/java-bigtable/issues/2619)) ([7d7b9a9](https://github.com/googleapis/java-bigtable/commit/7d7b9a966d3ef7b7a0ef3f82038ab73f4d791427))
* Next release from main branch is 2.62.0 ([#2621](https://github.com/googleapis/java-bigtable/issues/2621)) ([202b211](https://github.com/googleapis/java-bigtable/commit/202b21102e71da71ff56f19a12d8a00a59cd8107))


### Dependencies

* Minor cleanup ([#2623](https://github.com/googleapis/java-bigtable/issues/2623)) ([7b230e8](https://github.com/googleapis/java-bigtable/commit/7b230e86902b5733c06e45fad90da76653ee1096))
* Update shared dependencies ([#2616](https://github.com/googleapis/java-bigtable/issues/2616)) ([eb7cfd5](https://github.com/googleapis/java-bigtable/commit/eb7cfd526aa999c614b7b8285d32759e2739ff9a))

## [2.61.0](https://github.com/googleapis/java-bigtable/compare/v2.60.0...v2.61.0) (2025-06-27)


### Features

* Add getter for universe domain in JwtCredentialsWithAudience ([#2598](https://github.com/googleapis/java-bigtable/issues/2598)) ([9ad66b1](https://github.com/googleapis/java-bigtable/commit/9ad66b129923500cdeb794fc2e4570ad8b1d92fd))


### Bug Fixes

* Add name elements for the POM.xml files ([a873719](https://github.com/googleapis/java-bigtable/commit/a873719e7e32a0cd21dc259911a193520f20797e))
* Populate table id for materialized view ([#2610](https://github.com/googleapis/java-bigtable/issues/2610)) ([50c3fe2](https://github.com/googleapis/java-bigtable/commit/50c3fe2ffe66acaba8cb408dc3b1a4d13a4a2556))


### Dependencies

* Update shared dependencies ([#2605](https://github.com/googleapis/java-bigtable/issues/2605)) ([4cc7246](https://github.com/googleapis/java-bigtable/commit/4cc7246ff8e2e0e26d2edc0aee8866a32ec1c8ab))

## [2.60.0](https://github.com/googleapis/java-bigtable/compare/v2.59.0...v2.60.0) (2025-06-06)


### Features

* Improve error message on malformed struct ([#2592](https://github.com/googleapis/java-bigtable/issues/2592)) ([7f5fdf0](https://github.com/googleapis/java-bigtable/commit/7f5fdf094c5fe140807ce6abcea0b891462ba809))
* Run ExecuteQuery conformance tests ([#2557](https://github.com/googleapis/java-bigtable/issues/2557)) ([0bbc083](https://github.com/googleapis/java-bigtable/commit/0bbc083b9e798e5b557f3ffe7090b45e66c9ada5))


### Bug Fixes

* **deps:** Update the Java code generator (gapic-generator-java) to 2.59.0 ([65782aa](https://github.com/googleapis/java-bigtable/commit/65782aaf89ad78aafd7f5928e81e513c3016b471))
* Ensure that multiple instances of a client in the same process dont clobber each other ([#2590](https://github.com/googleapis/java-bigtable/issues/2590)) ([8d3dca4](https://github.com/googleapis/java-bigtable/commit/8d3dca43224179829829bcf91972610c666b130b))


### Dependencies

* Update shared dependencies ([#2587](https://github.com/googleapis/java-bigtable/issues/2587)) ([8ec0339](https://github.com/googleapis/java-bigtable/commit/8ec033994f20b2b3aea0dfcdaffbdd1c6d19fdad))

## [2.59.0](https://github.com/googleapis/java-bigtable/compare/v2.58.2...v2.59.0) (2025-05-16)


### Features

* **bigtable:** Add DeletionProtection support for Logical Views ([#2539](https://github.com/googleapis/java-bigtable/issues/2539)) ([d9ba32b](https://github.com/googleapis/java-bigtable/commit/d9ba32b8e5792ceed054f67c58f5622e153e87d6))


### Dependencies

* Update googleapis/sdk-platform-java action to v2.58.0 ([#2581](https://github.com/googleapis/java-bigtable/issues/2581)) ([c9b0289](https://github.com/googleapis/java-bigtable/commit/c9b028902dc8aae9552181d65c9743be09d45ecf))
* Update shared dependencies ([#2584](https://github.com/googleapis/java-bigtable/issues/2584)) ([ba82675](https://github.com/googleapis/java-bigtable/commit/ba82675c25dbe12443ac5ef48464dcb3f8c8894c))

## [2.58.2](https://github.com/googleapis/java-bigtable/compare/v2.58.1...v2.58.2) (2025-05-08)


### Bug Fixes

* Use service name as the default audience ([#2579](https://github.com/googleapis/java-bigtable/issues/2579)) ([af6d7bd](https://github.com/googleapis/java-bigtable/commit/af6d7bd28d9d7a4ebb90825a9b4b8a73d63172f6))


### Dependencies

* Update shared dependencies ([#2565](https://github.com/googleapis/java-bigtable/issues/2565)) ([043f11b](https://github.com/googleapis/java-bigtable/commit/043f11b16948c338096d9407de1e99f02656169e))

## [2.58.1](https://github.com/googleapis/java-bigtable/compare/v2.58.0...v2.58.1) (2025-04-28)


### Bug Fixes

* Close otel instance ([#2571](https://github.com/googleapis/java-bigtable/issues/2571)) ([422fe26](https://github.com/googleapis/java-bigtable/commit/422fe26f3aae30fe74de80fad3848707452d6646))

## [2.58.0](https://github.com/googleapis/java-bigtable/compare/v2.57.3...v2.58.0) (2025-04-28)


### Features

* Add deletion_protection support for LVs ([43c97a3](https://github.com/googleapis/java-bigtable/commit/43c97a3f430ee4ee90d46b3685ae50f13949831c))
* **bigtable:** Add integration tests for Materialized/Logical Views ([#2518](https://github.com/googleapis/java-bigtable/issues/2518)) ([4d3a7e6](https://github.com/googleapis/java-bigtable/commit/4d3a7e675b60ba6a3225a45b7463edff279f9bc4))


### Bug Fixes

* **deps:** Update the Java code generator (gapic-generator-java) to 2.56.2 ([43c97a3](https://github.com/googleapis/java-bigtable/commit/43c97a3f430ee4ee90d46b3685ae50f13949831c))
* Fix retry info algorithm setting ([#2562](https://github.com/googleapis/java-bigtable/issues/2562)) ([c424ccb](https://github.com/googleapis/java-bigtable/commit/c424ccba72a191609dc726ed67d03f0d330015fc))
* Use universe domain when creating the monitoring client ([#2570](https://github.com/googleapis/java-bigtable/issues/2570)) ([3b51e12](https://github.com/googleapis/java-bigtable/commit/3b51e1206a4f83078625705ed8d8a899839af1a9))

## [2.57.3](https://github.com/googleapis/java-bigtable/compare/v2.57.2...v2.57.3) (2025-04-01)


### Bug Fixes

* Remove debug messages ([#2552](https://github.com/googleapis/java-bigtable/issues/2552)) ([6359834](https://github.com/googleapis/java-bigtable/commit/63598346ca39767d59d254fce2c718d1258e27d5))

## [2.57.2](https://github.com/googleapis/java-bigtable/compare/v2.57.1...v2.57.2) (2025-03-31)


### Bug Fixes

* Library should released as 2.57.2 ([#2549](https://github.com/googleapis/java-bigtable/issues/2549)) ([58d0bbd](https://github.com/googleapis/java-bigtable/commit/58d0bbdcb983e3b5ee403edf45c4e98a6eb8dc16))

## [2.57.1](https://github.com/googleapis/java-bigtable/compare/v2.57.0...v2.57.1) (2025-03-24)


### Bug Fixes

* Handling of totalTimeout on sql plan refresh ([#2541](https://github.com/googleapis/java-bigtable/issues/2541)) ([bf49cf9](https://github.com/googleapis/java-bigtable/commit/bf49cf93f9a3b9cbdb155bb6cbb7a9f763b6f738))

## [2.57.0](https://github.com/googleapis/java-bigtable/compare/v2.56.0...v2.57.0) (2025-03-24)


### Features

* Add PreparedStatement and update ExecuteQuery API to use it ([#2534](https://github.com/googleapis/java-bigtable/issues/2534)) ([49d4d09](https://github.com/googleapis/java-bigtable/commit/49d4d09fd16a1eb4eb566227a049bca2aaaa61e3))

## [2.56.0](https://github.com/googleapis/java-bigtable/compare/v2.55.0...v2.56.0) (2025-03-18)


### Features

* **bigtable:** Add support for Logical Views in Admin API ([#2519](https://github.com/googleapis/java-bigtable/issues/2519)) ([6dac3fd](https://github.com/googleapis/java-bigtable/commit/6dac3fd6443e94674af88a1dc97bedd9b3b0c834))
* **bigtable:** Add support for Materialized Views in Admin API ([#2511](https://github.com/googleapis/java-bigtable/issues/2511)) ([55cd719](https://github.com/googleapis/java-bigtable/commit/55cd719df277a2ae1988c7cd53286558ad86835b))


### Bug Fixes

* **deps:** Update the Java code generator (gapic-generator-java) to 2.55.1 ([7992af0](https://github.com/googleapis/java-bigtable/commit/7992af08b4eb2f408ecb739a73fbdc36ca7af2b5))


### Dependencies

* Sdk-platform-java-config 3.45.1 ([#2517](https://github.com/googleapis/java-bigtable/issues/2517)) ([b2af258](https://github.com/googleapis/java-bigtable/commit/b2af258ed72d29644c8bd1079b1d0f223206d75b))

## [2.55.0](https://github.com/googleapis/java-bigtable/compare/v2.54.0...v2.55.0) (2025-03-11)


### Features

* Add MaterializedViewName to ReadRows and SampleRowKeys ([1763c6e](https://github.com/googleapis/java-bigtable/commit/1763c6e9304010ed4034e1ddd03fdb94bca615dc))
* Add MaterializedViews and LogicalViews APIs ([1763c6e](https://github.com/googleapis/java-bigtable/commit/1763c6e9304010ed4034e1ddd03fdb94bca615dc))
* Add MaterializedViews and LogicalViews APIs ([7340527](https://github.com/googleapis/java-bigtable/commit/73405272c3fc77ca81c1df7cce1b8d889d4a96c4))
* Add PrepareQuery api and update ExecuteQuery to support it ([1763c6e](https://github.com/googleapis/java-bigtable/commit/1763c6e9304010ed4034e1ddd03fdb94bca615dc))
* **bigtable:** Add support for data APIs for materialized views ([#2508](https://github.com/googleapis/java-bigtable/issues/2508)) ([6310a63](https://github.com/googleapis/java-bigtable/commit/6310a631be3345f97d73b50f3b458fe40b071286))
* **large-row-skip:** Added large-row-skip-callable with configurable rowadapter ([#2509](https://github.com/googleapis/java-bigtable/issues/2509)) ([ba193ef](https://github.com/googleapis/java-bigtable/commit/ba193ef771f913e6e6a1aca630fe52d0921ee077))
* Next release from main branch is 2.55.0 ([#2506](https://github.com/googleapis/java-bigtable/issues/2506)) ([4e45837](https://github.com/googleapis/java-bigtable/commit/4e458378cc25a4dc5ac3fd1362626d89f0138186))
* Publish row_key_schema fields in table proto and relevant admin APIs to setup a table with a row_key_schema ([7340527](https://github.com/googleapis/java-bigtable/commit/73405272c3fc77ca81c1df7cce1b8d889d4a96c4))


### Bug Fixes

* **deps:** Update the Java code generator (gapic-generator-java) to 2.54.0 ([91e4369](https://github.com/googleapis/java-bigtable/commit/91e4369d280c09fd2d1b4b5dd88809b6da01b0f8))


### Documentation

* Fixed formatting of resource path strings ([7340527](https://github.com/googleapis/java-bigtable/commit/73405272c3fc77ca81c1df7cce1b8d889d4a96c4))

## [2.54.0](https://github.com/googleapis/java-bigtable/compare/v2.53.0...v2.54.0) (2025-02-28)


### Features

* Next release from main branch is 2.54.0 ([#2498](https://github.com/googleapis/java-bigtable/issues/2498)) ([f967ded](https://github.com/googleapis/java-bigtable/commit/f967deda8b68091dcc417b6c51f451abd36696f1))


### Dependencies

* Update shared dependencies ([#2493](https://github.com/googleapis/java-bigtable/issues/2493)) ([e1d09e7](https://github.com/googleapis/java-bigtable/commit/e1d09e7d03365d844e957d043e21d71948f98d04))

## [2.53.0](https://github.com/googleapis/java-bigtable/compare/v2.52.0...v2.53.0) (2025-02-21)


### Features

* Skip large rows ([#2482](https://github.com/googleapis/java-bigtable/issues/2482)) ([cd7f82e](https://github.com/googleapis/java-bigtable/commit/cd7f82e4b66dc3c34262c73b26afc2fdfd1deed7))

## [2.52.0](https://github.com/googleapis/java-bigtable/compare/v2.51.2...v2.52.0) (2025-02-14)


### Features

* Automated backups are supported in the admin client ([#2472](https://github.com/googleapis/java-bigtable/issues/2472)) ([48633e6](https://github.com/googleapis/java-bigtable/commit/48633e6160593c84f42a02f348ec18c3d1521ef0))


### Bug Fixes

* **deps:** Update the Java code generator (gapic-generator-java) to 2.53.0 ([47ca299](https://github.com/googleapis/java-bigtable/commit/47ca29931699cae87d640185ad31e4b61c0bb212))
* Extend timeouts for check consistency ([47ca299](https://github.com/googleapis/java-bigtable/commit/47ca29931699cae87d640185ad31e4b61c0bb212))


### Dependencies

* Update dependency com.google.cloud:gapic-libraries-bom to v1.52.0 ([#2490](https://github.com/googleapis/java-bigtable/issues/2490)) ([ca25d4e](https://github.com/googleapis/java-bigtable/commit/ca25d4eb6c7333d1a77d2c99b1bb95c2a2f710c1))
* Update dependency com.google.cloud:sdk-platform-java-config to v3.43.0 ([#2481](https://github.com/googleapis/java-bigtable/issues/2481)) ([deb1f79](https://github.com/googleapis/java-bigtable/commit/deb1f79c6efa223f6c2f780724ec9386f44f018a))

## [2.51.2](https://github.com/googleapis/java-bigtable/compare/v2.51.1...v2.51.2) (2025-02-03)


### Bug Fixes

* Add known conformance test failures ([#2474](https://github.com/googleapis/java-bigtable/issues/2474)) ([15488fe](https://github.com/googleapis/java-bigtable/commit/15488fe6cfe05e84c4b6d65565150ee7277a60e7))


### Dependencies

* Update shared dependencies ([#2473](https://github.com/googleapis/java-bigtable/issues/2473)) ([4d6d419](https://github.com/googleapis/java-bigtable/commit/4d6d41988c8e4b92b01851ab7ab52183254e8798))

## [2.51.1](https://github.com/googleapis/java-bigtable/compare/v2.51.0...v2.51.1) (2025-01-10)


### Dependencies

* Update dependency com.google.cloud:gapic-libraries-bom to v1.50.0 ([#2464](https://github.com/googleapis/java-bigtable/issues/2464)) ([d63dd43](https://github.com/googleapis/java-bigtable/commit/d63dd4333e94f8ad32f260315e44b622db157002))
* Update dependency com.google.cloud:sdk-platform-java-config to v3.41.1 ([#2461](https://github.com/googleapis/java-bigtable/issues/2461)) ([ed24b4c](https://github.com/googleapis/java-bigtable/commit/ed24b4c0aebc2666850f103f551128f02c2ba2ae))
* Update googleapis/sdk-platform-java action to v2.51.1 ([#2460](https://github.com/googleapis/java-bigtable/issues/2460)) ([35c979f](https://github.com/googleapis/java-bigtable/commit/35c979fff1d1194cc241f90057245de78cd5f010))

## [2.51.0](https://github.com/googleapis/java-bigtable/compare/v2.50.0...v2.51.0) (2024-12-17)


### Features

* Introduce `java.time` ([#2415](https://github.com/googleapis/java-bigtable/issues/2415)) ([bb96c3e](https://github.com/googleapis/java-bigtable/commit/bb96c3e395793ba324cf658bb4c985d4315cf781))


### Bug Fixes

* **deps:** Update the Java code generator (gapic-generator-java) to 2.51.0 ([a5444a5](https://github.com/googleapis/java-bigtable/commit/a5444a545ec61a1520716dfafb6f62b7e39df1c7))
* Move resource detection to the first export to avoid slow start ([#2450](https://github.com/googleapis/java-bigtable/issues/2450)) ([cec010a](https://github.com/googleapis/java-bigtable/commit/cec010aa64f2b190f8e742915be41baae2ad2083))


### Dependencies

* Update sdk-platform-java dependencies ([#2448](https://github.com/googleapis/java-bigtable/issues/2448)) ([825e717](https://github.com/googleapis/java-bigtable/commit/825e717e9d8ae3853d7509d0849b58f2c47c9803))

## [2.50.0](https://github.com/googleapis/java-bigtable/compare/v2.49.0...v2.50.0) (2024-12-06)


### Features

* Add support for Row Affinity app profiles ([#2341](https://github.com/googleapis/java-bigtable/issues/2341)) ([cb4d60e](https://github.com/googleapis/java-bigtable/commit/cb4d60e8ce2079a270739ad91efb05cbb1ff74f8))

## [2.49.0](https://github.com/googleapis/java-bigtable/compare/v2.48.0...v2.49.0) (2024-12-03)


### Features

* Add support for table deletion protection ([#2430](https://github.com/googleapis/java-bigtable/issues/2430)) ([687b6df](https://github.com/googleapis/java-bigtable/commit/687b6df14b743358e8207cda26022dfc75338d55))


### Bug Fixes

* Allow factory to export to different projects ([#2374](https://github.com/googleapis/java-bigtable/issues/2374)) ([06b912c](https://github.com/googleapis/java-bigtable/commit/06b912cc5d63436757008e79edfa8286b2ccac18))
* Send priming requests on the channel directly ([#2435](https://github.com/googleapis/java-bigtable/issues/2435)) ([b76698d](https://github.com/googleapis/java-bigtable/commit/b76698dfb2c8552185f34e01e924ecc80798ba4f))

## [2.48.0](https://github.com/googleapis/java-bigtable/compare/v2.47.0...v2.48.0) (2024-11-19)


### Features

* Enable trailer optimization by default ([#2421](https://github.com/googleapis/java-bigtable/issues/2421)) ([7b2c4e4](https://github.com/googleapis/java-bigtable/commit/7b2c4e45dce828f506dac16ffc2b71995564a477))


### Bug Fixes

* **deps:** Update the Java code generator (gapic-generator-java) to 2.50.0 ([6b35b47](https://github.com/googleapis/java-bigtable/commit/6b35b478e10efce77d95bffcd7a64e84e1bcc5b0))
* Make client side metrics tag in sync with server ([#2401](https://github.com/googleapis/java-bigtable/issues/2401)) ([bba4183](https://github.com/googleapis/java-bigtable/commit/bba41837febc10e9507afc7117e2e4ec2d15fb11))


### Dependencies

* Revert downgrade grpc to 1.67.1 [#2366](https://github.com/googleapis/java-bigtable/issues/2366) ([#2414](https://github.com/googleapis/java-bigtable/issues/2414)) ([710fa52](https://github.com/googleapis/java-bigtable/commit/710fa52a05ce4fc81ee8e980d87e0ca86676219f))
* Update dependency com.google.cloud:gapic-libraries-bom to v1.48.0 ([#2422](https://github.com/googleapis/java-bigtable/issues/2422)) ([2088a39](https://github.com/googleapis/java-bigtable/commit/2088a399bd8b71e98035cc475637f41d5873082d))
* Update sdk-platform-java dependencies ([#2418](https://github.com/googleapis/java-bigtable/issues/2418)) ([c12bb01](https://github.com/googleapis/java-bigtable/commit/c12bb01a6c5be0a72285db0505407f3e1c2534fb))

## [2.47.0](https://github.com/googleapis/java-bigtable/compare/v2.46.0...v2.47.0) (2024-11-13)


### Features

* Add an experimental feature to skip waiting for trailers for unary ops ([#2404](https://github.com/googleapis/java-bigtable/issues/2404)) ([cf58f26](https://github.com/googleapis/java-bigtable/commit/cf58f260fd7d3cb0dee4fee8e2d43367db6eadb1))
* Add internal "deadline remaining" client side metric [#2341](https://github.com/googleapis/java-bigtable/issues/2341) ([#2370](https://github.com/googleapis/java-bigtable/issues/2370)) ([75d4105](https://github.com/googleapis/java-bigtable/commit/75d4105e0376dbe5810d6b96d71daa74b85e68ce))


### Bug Fixes

* Simplify remaining deadline metric impl ([#2410](https://github.com/googleapis/java-bigtable/issues/2410)) ([9796d57](https://github.com/googleapis/java-bigtable/commit/9796d57b60d928d3390e4ad311d5704dcbe808ec))

## [2.46.0](https://github.com/googleapis/java-bigtable/compare/v2.45.1...v2.46.0) (2024-10-29)


### Features

* Test proxy support SSL backend ([#2381](https://github.com/googleapis/java-bigtable/issues/2381)) ([3cbf4ab](https://github.com/googleapis/java-bigtable/commit/3cbf4abe79d61daba0704abfccfb5558b026e6b7))


### Bug Fixes

* Fix client blocking latency ([#2346](https://github.com/googleapis/java-bigtable/issues/2346)) ([3801961](https://github.com/googleapis/java-bigtable/commit/380196174fb9b8cd97beb79d4faf49b30561be7f))
* Fix first response latencies ([#2382](https://github.com/googleapis/java-bigtable/issues/2382)) ([8b2953e](https://github.com/googleapis/java-bigtable/commit/8b2953ed9c69c23b3e0c5c35d0538dc83f9dad80))


### Dependencies

* Update sdk-platform-java dependencies ([#2384](https://github.com/googleapis/java-bigtable/issues/2384)) ([81d7215](https://github.com/googleapis/java-bigtable/commit/81d72150b60d29e4e2ac17c6cb1fbdc89be0e16e))

## [2.45.1](https://github.com/googleapis/java-bigtable/compare/v2.45.0...v2.45.1) (2024-10-14)


### Bug Fixes

* **deps:** Update the Java code generator (gapic-generator-java) to 2.47.0 ([cdc2cc7](https://github.com/googleapis/java-bigtable/commit/cdc2cc7e085af42a2078373098b5f8ef8c752ea7))


### Dependencies

* Update sdk-platform-java dependencies ([#2378](https://github.com/googleapis/java-bigtable/issues/2378)) ([2499a3c](https://github.com/googleapis/java-bigtable/commit/2499a3cd5e0d0404666c7f9cf0c74f9edb90d894))

## [2.45.0](https://github.com/googleapis/java-bigtable/compare/v2.44.1...v2.45.0) (2024-10-03)


### Features

* Add support for Cloud Bigtable Node Scaling Factor for CBT Clusters ([caf879c](https://github.com/googleapis/java-bigtable/commit/caf879cb4086d74bd4571662510014b27e6113a7))


### Bug Fixes

* **deps:** Update the Java code generator (gapic-generator-java) to 2.46.1 ([caf879c](https://github.com/googleapis/java-bigtable/commit/caf879cb4086d74bd4571662510014b27e6113a7))
* Support override monitoring endpoint ([#2364](https://github.com/googleapis/java-bigtable/issues/2364)) ([a341eb8](https://github.com/googleapis/java-bigtable/commit/a341eb8530d959edabac0282c52c3e928abf733d))


### Dependencies

* Downgrade grpc to 1.67.1 ([#2366](https://github.com/googleapis/java-bigtable/issues/2366)) ([1baecb3](https://github.com/googleapis/java-bigtable/commit/1baecb3f6cd34a1daab632c322a1fb415efb9895))
* Update dependency com.google.cloud:gapic-libraries-bom to v1.45.0 ([#2363](https://github.com/googleapis/java-bigtable/issues/2363)) ([9d24c45](https://github.com/googleapis/java-bigtable/commit/9d24c45b389f2edef0b02f6a8c3badbca2fd3946))

## [2.44.1](https://github.com/googleapis/java-bigtable/compare/v2.44.0...v2.44.1) (2024-09-26)


### Bug Fixes

* Add RetryCallable to the callable chain ([#2348](https://github.com/googleapis/java-bigtable/issues/2348)) ([0330d77](https://github.com/googleapis/java-bigtable/commit/0330d77ac29d47e8610ddd23c324a55d1f9912cb))
* Pass deadline through ExecuteQuery RetrySettings ([#2355](https://github.com/googleapis/java-bigtable/issues/2355)) ([6bc9820](https://github.com/googleapis/java-bigtable/commit/6bc98202897cebe09be8a4a78316cf5463106866))
* Time based flakiness in execute query deadline test ([#2358](https://github.com/googleapis/java-bigtable/issues/2358)) ([b474173](https://github.com/googleapis/java-bigtable/commit/b474173a778cba273d2713e667000c5633de75bd))


### Dependencies

* Update dependency com.google.cloud:sdk-platform-java-config to v3.36.1 ([#2351](https://github.com/googleapis/java-bigtable/issues/2351)) ([40c428e](https://github.com/googleapis/java-bigtable/commit/40c428ec8e8cccb4dc3bb10d6674c94e9527e797))

## [2.44.0](https://github.com/googleapis/java-bigtable/compare/v2.43.0...v2.44.0) (2024-09-16)


### Features

* Add APIs to enable hot backups ([#2313](https://github.com/googleapis/java-bigtable/issues/2313)) ([6d004cd](https://github.com/googleapis/java-bigtable/commit/6d004cd0809d02eeff05d5e90faf5e145f13d11e))
* Add support for awaiting Data Boost ([#2329](https://github.com/googleapis/java-bigtable/issues/2329)) ([8556574](https://github.com/googleapis/java-bigtable/commit/85565742645537d1b55a1a52521d2ccf44b4d00c))


### Dependencies

* Update shared dependencies ([#2337](https://github.com/googleapis/java-bigtable/issues/2337)) ([dc65bd5](https://github.com/googleapis/java-bigtable/commit/dc65bd5a39cfe0c25a6b955f9f4d9367df334211))

## [2.43.0](https://github.com/googleapis/java-bigtable/compare/v2.42.0...v2.43.0) (2024-08-22)


### Features

* Add fields and the BackupType proto for Hot Backups ([#2300](https://github.com/googleapis/java-bigtable/issues/2300)) ([acaa3ff](https://github.com/googleapis/java-bigtable/commit/acaa3ff26ab0d317362e2be65ac5edcf803b13a1))
* Allow non default service account in DirectPath ([#2312](https://github.com/googleapis/java-bigtable/issues/2312)) ([09d0f23](https://github.com/googleapis/java-bigtable/commit/09d0f23032488dfa55c7a4c1c571a4f36bd94728))
* **bigtable:** Remove deprecated Bytes from BigEndianBytesEncoding ([#2309](https://github.com/googleapis/java-bigtable/issues/2309)) ([32f244f](https://github.com/googleapis/java-bigtable/commit/32f244f13d0c8571654d314310a4756fe275d609))
* Enable hermetic library generation ([#2234](https://github.com/googleapis/java-bigtable/issues/2234)) ([169aea5](https://github.com/googleapis/java-bigtable/commit/169aea5c43485a8d13ed53f57495609c142944df))


### Bug Fixes

* Add missing call to EqualsTester#testEquals ([#2307](https://github.com/googleapis/java-bigtable/issues/2307)) ([8b49f9c](https://github.com/googleapis/java-bigtable/commit/8b49f9ce84871f0f423f5837785604c3119ccd88))


### Dependencies

* Update shared dependencies ([#2314](https://github.com/googleapis/java-bigtable/issues/2314)) ([ab392ee](https://github.com/googleapis/java-bigtable/commit/ab392ee8d0c4535b5d3f31b3e111cbc41b399dd9))

## [2.42.0](https://github.com/googleapis/java-bigtable/compare/v2.41.0...v2.42.0) (2024-08-06)


### Features

* Support float32, float64, and array type query params ([#2297](https://github.com/googleapis/java-bigtable/issues/2297)) ([a65640e](https://github.com/googleapis/java-bigtable/commit/a65640e285950d02136544bac913b2852cfe0274))


### Bug Fixes

* Adapt toString tests to introduction of java.time in gax  ([93f66a7](https://github.com/googleapis/java-bigtable/commit/93f66a70371f8095fd5c001a977d71e5622be46d))


### Dependencies

* Update shared dependencies ([93f66a7](https://github.com/googleapis/java-bigtable/commit/93f66a70371f8095fd5c001a977d71e5622be46d))

## [2.41.0](https://github.com/googleapis/java-bigtable/compare/v2.40.0...v2.41.0) (2024-07-24)


### Features

* Add MergeToCell to Mutation APIs ([#2279](https://github.com/googleapis/java-bigtable/issues/2279)) ([0ce8a2a](https://github.com/googleapis/java-bigtable/commit/0ce8a2a38703233da58208655f41f6e81e03576e))
* Add support for MergeToCell API ([#2258](https://github.com/googleapis/java-bigtable/issues/2258)) ([191d15c](https://github.com/googleapis/java-bigtable/commit/191d15c5284dbb702e11669931272877bf05f44e))
* Add support for new functions ([#2287](https://github.com/googleapis/java-bigtable/issues/2287)) ([dd6583a](https://github.com/googleapis/java-bigtable/commit/dd6583a22504385b7a1f7dc91b3bc3d2500ea0c5))
* Create new environment variable to toggle directpath scoped to cloud bigtable. ([#2261](https://github.com/googleapis/java-bigtable/issues/2261)) ([9062944](https://github.com/googleapis/java-bigtable/commit/9062944610277eb7ae77f395dc79ce94239c5bee))
* Implement ExecuteQuery API for SQL support ([#2280](https://github.com/googleapis/java-bigtable/issues/2280)) ([25218e8](https://github.com/googleapis/java-bigtable/commit/25218e8cc46f9a51d4b6515afdb8931e574b0bb1))


### Dependencies

* Update dependency com.google.truth.extensions:truth-proto-extension to v1.4.4 ([#2282](https://github.com/googleapis/java-bigtable/issues/2282)) ([d00a9e0](https://github.com/googleapis/java-bigtable/commit/d00a9e01b2b329f3bae50f48a15692d87ad0f3bf))

## [2.40.0](https://github.com/googleapis/java-bigtable/compare/v2.39.5...v2.40.0) (2024-06-28)


### Features

* Add String type with Utf8Raw encoding to Bigtable API ([#2191](https://github.com/googleapis/java-bigtable/issues/2191)) ([e7f03fc](https://github.com/googleapis/java-bigtable/commit/e7f03fc7d252a7ff6c76a8e6e0a9e6ad3dcbd9d5))


### Bug Fixes

* Add getServiceName() to EnhancedBigTableStubSettings ([#2256](https://github.com/googleapis/java-bigtable/issues/2256)) ([da703db](https://github.com/googleapis/java-bigtable/commit/da703db25f6702b263dbd8ded0cb0fd3422efe31))
* Remove grpclb ([#2033](https://github.com/googleapis/java-bigtable/issues/2033)) ([7355375](https://github.com/googleapis/java-bigtable/commit/735537571a147bfdd2a986664ff7905c8f5dc3db))


### Dependencies

* Update dependency com.google.truth.extensions:truth-proto-extension to v1.4.3 ([#2268](https://github.com/googleapis/java-bigtable/issues/2268)) ([4573220](https://github.com/googleapis/java-bigtable/commit/45732201880a13eeced3d0332bd172aae0f73dbe))
* Update dependency org.junit.vintage:junit-vintage-engine to v5.10.3 ([#2269](https://github.com/googleapis/java-bigtable/issues/2269)) ([69fef96](https://github.com/googleapis/java-bigtable/commit/69fef968937f4d2e4cc479279a09d7b0bed6c5a2))
* Update shared dependencies ([#2265](https://github.com/googleapis/java-bigtable/issues/2265)) ([61014ca](https://github.com/googleapis/java-bigtable/commit/61014ca89318743cf0cc0bae97a7f875bc5243ab))

## [2.39.5](https://github.com/googleapis/java-bigtable/compare/v2.39.4...v2.39.5) (2024-06-10)


### Bug Fixes

* Make change stream unknown mod error more actionable ([#1938](https://github.com/googleapis/java-bigtable/issues/1938)) ([e7ba045](https://github.com/googleapis/java-bigtable/commit/e7ba045967e837129adcf979ac13cd9097fab56c))
* Rate limiting should be ineffective when RateLimitInfo is not present ([#2243](https://github.com/googleapis/java-bigtable/issues/2243)) ([a0ec901](https://github.com/googleapis/java-bigtable/commit/a0ec901a84d8d5a2729772d165e2b305d4663824))


### Dependencies

* Update shared dependencies ([#2252](https://github.com/googleapis/java-bigtable/issues/2252)) ([0131eb3](https://github.com/googleapis/java-bigtable/commit/0131eb33d09f0c4cb7b4984efed257f6d72b0100))

## [2.39.4](https://github.com/googleapis/java-bigtable/compare/v2.39.3...v2.39.4) (2024-05-28)


### Dependencies

* Update dependency org.graalvm.buildtools:junit-platform-native to v0.10.2 ([#2236](https://github.com/googleapis/java-bigtable/issues/2236)) ([2609103](https://github.com/googleapis/java-bigtable/commit/26091035ed42cfd2945092d0c909dbf9bb6fae28))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.10.2 ([#2237](https://github.com/googleapis/java-bigtable/issues/2237)) ([6728931](https://github.com/googleapis/java-bigtable/commit/6728931ca904e2a2fb53f7b9e9115a9c3edd38df))
* Update shared dependencies ([#2235](https://github.com/googleapis/java-bigtable/issues/2235)) ([8d38150](https://github.com/googleapis/java-bigtable/commit/8d3815023f7fa1c8103cb8ab02d8f71cd8a7a85e))

## [2.39.3](https://github.com/googleapis/java-bigtable/compare/v2.39.2...v2.39.3) (2024-05-21)


### Bug Fixes

* Retry INTERNAL retriable auth errors ([#2239](https://github.com/googleapis/java-bigtable/issues/2239)) ([4cdb6da](https://github.com/googleapis/java-bigtable/commit/4cdb6da8920cd3346a9d79d67432cef588d93bb0))

## [2.39.2](https://github.com/googleapis/java-bigtable/compare/v2.39.1...v2.39.2) (2024-05-09)


### Dependencies

* Update shared dependencies ([#2221](https://github.com/googleapis/java-bigtable/issues/2221)) ([17f7a9a](https://github.com/googleapis/java-bigtable/commit/17f7a9af3991c4744256bbfb0533d9390cada23d))

## [2.39.1](https://github.com/googleapis/java-bigtable/compare/v2.39.0...v2.39.1) (2024-05-08)


### Bug Fixes

* Batch time series data when exporting client-side metric ([#2222](https://github.com/googleapis/java-bigtable/issues/2222)) ([1f9f169](https://github.com/googleapis/java-bigtable/commit/1f9f1698339ae470d821963e1037e0132016d216))
* Remove stale module from bom ([#2218](https://github.com/googleapis/java-bigtable/issues/2218)) ([7145864](https://github.com/googleapis/java-bigtable/commit/7145864868b3f7df69f9b2db7a822f9faf903f33))

## [2.39.0](https://github.com/googleapis/java-bigtable/compare/v2.38.0...v2.39.0) (2024-04-29)


### Features

* Admin API changes for databoost ([#2181](https://github.com/googleapis/java-bigtable/issues/2181)) ([3b1886b](https://github.com/googleapis/java-bigtable/commit/3b1886bea79525505e41124b41985f37c490c97e))


### Dependencies

* Update dependency com.google.cloud:gapic-libraries-bom to v1.36.0 ([#2215](https://github.com/googleapis/java-bigtable/issues/2215)) ([5a9259e](https://github.com/googleapis/java-bigtable/commit/5a9259e3c861f1ed13c84e0bb024ddda3e1dc147))
* Update shared dependencies ([#2190](https://github.com/googleapis/java-bigtable/issues/2190)) ([3f37d8d](https://github.com/googleapis/java-bigtable/commit/3f37d8da8b51a3fea56d1c462b9500ee2c244973))

## [2.38.0](https://github.com/googleapis/java-bigtable/compare/v2.37.0...v2.38.0) (2024-04-15)


### Features

* Add Data Boost configurations to admin API ([f29c5bb](https://github.com/googleapis/java-bigtable/commit/f29c5bba08daffe2721454db1714f6ea6f47fc66))
* Add feature flag for client side metrics ([#2179](https://github.com/googleapis/java-bigtable/issues/2179)) ([f29c5bb](https://github.com/googleapis/java-bigtable/commit/f29c5bba08daffe2721454db1714f6ea6f47fc66))
* Migrate to OTEL and enable metrics by default ([#2166](https://github.com/googleapis/java-bigtable/issues/2166)) ([1682939](https://github.com/googleapis/java-bigtable/commit/168293937cc7f438a3ec2dee46805aa8e12089c4))


### Bug Fixes

* Add more error handling ([#2203](https://github.com/googleapis/java-bigtable/issues/2203)) ([c2a63f7](https://github.com/googleapis/java-bigtable/commit/c2a63f7627f2aa6e2e51ec3e185abfa5234ad3e4))
* Fix export to log detect resource errors ([#2197](https://github.com/googleapis/java-bigtable/issues/2197)) ([d32fbb7](https://github.com/googleapis/java-bigtable/commit/d32fbb78bbde2ad04103ab7b2c1176a6df72d0a3))

## [2.37.0](https://github.com/googleapis/java-bigtable/compare/v2.36.0...v2.37.0) (2024-03-27)


### Features

* Add admin APIs for AuthorizedView ([#2175](https://github.com/googleapis/java-bigtable/issues/2175)) ([13d1df3](https://github.com/googleapis/java-bigtable/commit/13d1df3910e3041b57485a09317f717932b21727))
* Support AuthorizedView in bigtable data client  ([#2177](https://github.com/googleapis/java-bigtable/issues/2177)) ([4b255d0](https://github.com/googleapis/java-bigtable/commit/4b255d0160b0ea30a4ab6453ccae278f40d32ee2))


### Bug Fixes

* Update the accounting of partial batch mutations ([#2149](https://github.com/googleapis/java-bigtable/issues/2149)) ([4158094](https://github.com/googleapis/java-bigtable/commit/4158094c34c85b1540197256f98e8880962fb13d))


### Dependencies

* Update shared dependencies ([#2174](https://github.com/googleapis/java-bigtable/issues/2174)) ([f313f14](https://github.com/googleapis/java-bigtable/commit/f313f1410f28df15438d83acaa74b715c752abdd))

## [2.36.0](https://github.com/googleapis/java-bigtable/compare/v2.35.1...v2.36.0) (2024-03-13)


### Features

* Add models for type APIs ([#2160](https://github.com/googleapis/java-bigtable/issues/2160)) ([8277ea8](https://github.com/googleapis/java-bigtable/commit/8277ea828491d39b9c3c2e67c1a03927e2a744d9))
* Publish new bigtable APIs for types and aggregates ([#2158](https://github.com/googleapis/java-bigtable/issues/2158)) ([430dffe](https://github.com/googleapis/java-bigtable/commit/430dffe0ff5916d9c3d7cfd7d35ca13514fd8934))

## [2.35.1](https://github.com/googleapis/java-bigtable/compare/v2.35.0...v2.35.1) (2024-03-07)


### Dependencies

* Update shared dependencies ([#2140](https://github.com/googleapis/java-bigtable/issues/2140)) ([a6c9f9b](https://github.com/googleapis/java-bigtable/commit/a6c9f9bc7781535d80c4a44cb350052d6771b2e0))

## [2.35.0](https://github.com/googleapis/java-bigtable/compare/v2.34.0...v2.35.0) (2024-03-05)


### Features

* Add authorized view bindings to Cloud Bigtable data APIs and messages ([#2144](https://github.com/googleapis/java-bigtable/issues/2144)) ([ae89709](https://github.com/googleapis/java-bigtable/commit/ae89709514921f7f362b7bf6057ec2f01e50046d))


### Bug Fixes

* Per-connection metrics issue when using a different Bigtable project ([#2143](https://github.com/googleapis/java-bigtable/issues/2143)) ([8dbd680](https://github.com/googleapis/java-bigtable/commit/8dbd680abc1ad13ad33981c67f8349f63432b7ea))

## [2.34.0](https://github.com/googleapis/java-bigtable/compare/v2.33.0...v2.34.0) (2024-02-21)


### Features

* Add the export logic for per-connection error rate metric ([#2121](https://github.com/googleapis/java-bigtable/issues/2121)) ([d053f2d](https://github.com/googleapis/java-bigtable/commit/d053f2dc98eb8576f33471d728c6fbf32d537ece))
* Create the backbone of counting errors per connection each minute. ([#2094](https://github.com/googleapis/java-bigtable/issues/2094)) ([7d27816](https://github.com/googleapis/java-bigtable/commit/7d27816b959a06412f59f49023611f0bca8e3536))


### Dependencies

* Update actions/setup-java action to v4 ([#2106](https://github.com/googleapis/java-bigtable/issues/2106)) ([a694296](https://github.com/googleapis/java-bigtable/commit/a694296a76faefe31585aabc9dce0adcf4a342bf))
* Update dependency com.google.cloud:gapic-libraries-bom to v1.30.0 ([#2126](https://github.com/googleapis/java-bigtable/issues/2126)) ([f613bd0](https://github.com/googleapis/java-bigtable/commit/f613bd0dd449d218a0d8b6d20344155f9762cfb1))
* Update dependency com.google.cloud:sdk-platform-java-config to v3.25.0 ([#2113](https://github.com/googleapis/java-bigtable/issues/2113)) ([ba1973e](https://github.com/googleapis/java-bigtable/commit/ba1973e20c4cbb9be778840cc202eb7e4daf04f4))
* Update dependency com.google.truth.extensions:truth-proto-extension to v1.4.1 ([#2119](https://github.com/googleapis/java-bigtable/issues/2119)) ([0a7ad66](https://github.com/googleapis/java-bigtable/commit/0a7ad66fa9e2c1858f51c25d1ea01b26da0b944f))
* Update dependency org.graalvm.buildtools:junit-platform-native to v0.10.1 ([#2122](https://github.com/googleapis/java-bigtable/issues/2122)) ([99ec284](https://github.com/googleapis/java-bigtable/commit/99ec28425c2caac6a992cb7edd83f2029cce92ec))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.10.1 ([#2123](https://github.com/googleapis/java-bigtable/issues/2123)) ([12d961a](https://github.com/googleapis/java-bigtable/commit/12d961aad5d15feb27a7996de8b9a626fcdfbc5b))

## [2.33.0](https://github.com/googleapis/java-bigtable/compare/v2.32.0...v2.33.0) (2024-02-12)


### Features

* Define the metrics for collecting per connection error count. ([#2088](https://github.com/googleapis/java-bigtable/issues/2088)) ([b212bbf](https://github.com/googleapis/java-bigtable/commit/b212bbfcfb2d8c2e2fdc2fc3609976c8a462f677))


### Bug Fixes

* Deflake Backup integration tests due to deleteBackup timeouts ([#2105](https://github.com/googleapis/java-bigtable/issues/2105)) ([0948da7](https://github.com/googleapis/java-bigtable/commit/0948da7885958556c85ce333cf13b36896ddc154))
* Extend timeouts for deleting snapshots, backups and tables ([#2108](https://github.com/googleapis/java-bigtable/issues/2108)) ([df1d307](https://github.com/googleapis/java-bigtable/commit/df1d307255abbe77050c2c24f934b13bb82eb212))


### Dependencies

* **autogen:** Set packed = false on field_behavior extension ([#2101](https://github.com/googleapis/java-bigtable/issues/2101)) ([7c438c6](https://github.com/googleapis/java-bigtable/commit/7c438c603f3893946f73b2d69f2e0901ac9b044a))
* Update actions/setup-java action to v4 ([#2099](https://github.com/googleapis/java-bigtable/issues/2099)) ([a6c7c77](https://github.com/googleapis/java-bigtable/commit/a6c7c779df39b151202d765728c853a7bdcd3d18))
* Update dependency com.google.cloud:gapic-libraries-bom to v1.29.0 ([#2109](https://github.com/googleapis/java-bigtable/issues/2109)) ([ef88519](https://github.com/googleapis/java-bigtable/commit/ef8851976898f595f53bbc239d4f1731893d924b))
* Update dependency com.google.cloud:sdk-platform-java-config to v3.24.0 ([#2085](https://github.com/googleapis/java-bigtable/issues/2085)) ([3851a5e](https://github.com/googleapis/java-bigtable/commit/3851a5e7db5ae3d3c1d29e6f97fc37815c8b70d1))
* Update dependency org.graalvm.buildtools:junit-platform-native to v0.10.0 ([#2091](https://github.com/googleapis/java-bigtable/issues/2091)) ([2516a09](https://github.com/googleapis/java-bigtable/commit/2516a095c8305a4193bbadf6c08395f6d718e1d0))
* Update protobuf to 25.2 in WORKSPACE ([#2086](https://github.com/googleapis/java-bigtable/issues/2086)) ([3eafcee](https://github.com/googleapis/java-bigtable/commit/3eafcee16f7a5e357fc8617120ee875d32fc415d))

## [2.32.0](https://github.com/googleapis/java-bigtable/compare/v2.31.0...v2.32.0) (2024-01-25)


### Features

* Append version to the client name in client-side metrics. ([#2062](https://github.com/googleapis/java-bigtable/issues/2062)) ([9a0cdc8](https://github.com/googleapis/java-bigtable/commit/9a0cdc8cb8e2c52fde403eb316d28bf99c55a1e7))


### Bug Fixes

* **deps:** Update the Java code generator (gapic-generator-java) to 2.32.0 ([#2060](https://github.com/googleapis/java-bigtable/issues/2060)) ([c218ac3](https://github.com/googleapis/java-bigtable/commit/c218ac3571360c85171dac71b915ad6776d97589))


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.23.0 ([#2076](https://github.com/googleapis/java-bigtable/issues/2076)) ([5d1079c](https://github.com/googleapis/java-bigtable/commit/5d1079c2d1ced39b656773ff17743cb4e08a6126))
* Update dependency com.google.truth.extensions:truth-proto-extension to v1.3.0 ([#2058](https://github.com/googleapis/java-bigtable/issues/2058)) ([1622a9f](https://github.com/googleapis/java-bigtable/commit/1622a9f34d6818952eb283eba01992dc48a9df25))
* Update shared dependencies ([#2056](https://github.com/googleapis/java-bigtable/issues/2056)) ([f73ba40](https://github.com/googleapis/java-bigtable/commit/f73ba4099b497a78f82a1ad61b91035380955c21))

## [2.31.0](https://github.com/googleapis/java-bigtable/compare/v2.30.0...v2.31.0) (2024-01-12)


### Features

* Add a flag to add / remove routing cookie from callable chain ([#2032](https://github.com/googleapis/java-bigtable/issues/2032)) ([201e631](https://github.com/googleapis/java-bigtable/commit/201e631f893b1edacdd5760c1d180b212dc9e38a))
* Adding feature flags for routing cookie and retry info ([#2031](https://github.com/googleapis/java-bigtable/issues/2031)) ([08c5bf1](https://github.com/googleapis/java-bigtable/commit/08c5bf1fd76258387135c8c3abe75f13bcdcc1f6))
* Count row merging errors as internal errors ([#2045](https://github.com/googleapis/java-bigtable/issues/2045)) ([fc7845b](https://github.com/googleapis/java-bigtable/commit/fc7845bd4cefca05bccc4dc3a9f727fd20f5adf6))
* Enable feature flag when setting is enabled ([#2043](https://github.com/googleapis/java-bigtable/issues/2043)) ([e0d90db](https://github.com/googleapis/java-bigtable/commit/e0d90db67b3ea52d833f7d6bcd78e3f7e91ff301))
* Handle retry info so client respect the delay server sets ([#2026](https://github.com/googleapis/java-bigtable/issues/2026)) ([f1b7fc7](https://github.com/googleapis/java-bigtable/commit/f1b7fc79ad3fd9006e430e48430331b360bb22e3))


### Bug Fixes

* **deps:** Update the Java code generator (gapic-generator-java) to 2.31.0 ([#2044](https://github.com/googleapis/java-bigtable/issues/2044)) ([d9042a5](https://github.com/googleapis/java-bigtable/commit/d9042a567f284424efb4af69f757883c9781dce3))
* Fix RetryInfo algorithm and tests ([#2041](https://github.com/googleapis/java-bigtable/issues/2041)) ([dad7517](https://github.com/googleapis/java-bigtable/commit/dad751736112323c578b3c90d9587fc182105747))


### Dependencies

* Update dependency com.google.cloud:gapic-libraries-bom to v1.27.0 ([#2030](https://github.com/googleapis/java-bigtable/issues/2030)) ([a492d02](https://github.com/googleapis/java-bigtable/commit/a492d02bdc52cb81d8804a4d7cd363b5807bdd47))
* Update dependency com.google.truth.extensions:truth-proto-extension to v1.2.0 ([#2035](https://github.com/googleapis/java-bigtable/issues/2035)) ([46e1e03](https://github.com/googleapis/java-bigtable/commit/46e1e0335f9969fa1b60acdf17e9b8abbc312ca2))

## [2.30.0](https://github.com/googleapis/java-bigtable/compare/v2.29.1...v2.30.0) (2023-12-05)


### Features

* Client sends routing cookie back to server ([#1888](https://github.com/googleapis/java-bigtable/issues/1888)) ([4c73abd](https://github.com/googleapis/java-bigtable/commit/4c73abd2f4a07808b591dd9178e87715d2f3008d))


### Dependencies

* Update dependency org.junit.vintage:junit-vintage-engine to v5.10.1 ([#1990](https://github.com/googleapis/java-bigtable/issues/1990)) ([7ad70e3](https://github.com/googleapis/java-bigtable/commit/7ad70e3abc1af7dfab715386978bf14f02b34e5d))
* Update shared dependencies ([#2016](https://github.com/googleapis/java-bigtable/issues/2016)) ([4e49dff](https://github.com/googleapis/java-bigtable/commit/4e49dffa72db8dd04e75ca86178d875fab6f566b))

## [2.29.1](https://github.com/googleapis/java-bigtable/compare/v2.29.0...v2.29.1) (2023-11-07)


### Bug Fixes

* Add getPageSize() to QueryPaginator ([42a7e36](https://github.com/googleapis/java-bigtable/commit/42a7e36ae5902c08ed3a1b553bec645291f1778a))


### Dependencies

* Update shared dependencies ([#1985](https://github.com/googleapis/java-bigtable/issues/1985)) ([0d1f620](https://github.com/googleapis/java-bigtable/commit/0d1f6203dd2317fa877e31c113bdca1e8174a492))

## [2.29.0](https://github.com/googleapis/java-bigtable/compare/v2.28.0...v2.29.0) (2023-10-26)


### Features

* Add APIs to enable request priorities ([#1959](https://github.com/googleapis/java-bigtable/issues/1959)) ([befd140](https://github.com/googleapis/java-bigtable/commit/befd1402a0f324b365b72e3b237d33d2f3fe8bbc))


### Dependencies

* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.28 ([#1966](https://github.com/googleapis/java-bigtable/issues/1966)) ([8fb09e5](https://github.com/googleapis/java-bigtable/commit/8fb09e53a3d85273578ba26c522931047b249333))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.28 ([#1967](https://github.com/googleapis/java-bigtable/issues/1967)) ([117e0ec](https://github.com/googleapis/java-bigtable/commit/117e0ec546343798cbc69eb23fef539de0b8bb8d))
* Update shared dependencies ([#1964](https://github.com/googleapis/java-bigtable/issues/1964)) ([bf5a9b7](https://github.com/googleapis/java-bigtable/commit/bf5a9b774f79005ee9980a12931597ddc1ec5bb3))

## [2.28.0](https://github.com/googleapis/java-bigtable/compare/v2.27.4...v2.28.0) (2023-10-12)


### Features

* Add support for Cloud Bigtable Request Priorities in App Profiles ([#1954](https://github.com/googleapis/java-bigtable/issues/1954)) ([8822571](https://github.com/googleapis/java-bigtable/commit/88225717b870032b8892123262d2529ba1dbd481))
* Add test profile to push metrics to test environment ([#1921](https://github.com/googleapis/java-bigtable/issues/1921)) ([2104315](https://github.com/googleapis/java-bigtable/commit/210431523ce54029db846a0d6777d5e417e039dd))


### Dependencies

* Update shared dependencies ([#1955](https://github.com/googleapis/java-bigtable/issues/1955)) ([f29717e](https://github.com/googleapis/java-bigtable/commit/f29717e3f1af03a78ce9468cdafa8c09dfb1b216))

## [2.27.4](https://github.com/googleapis/java-bigtable/compare/v2.27.3...v2.27.4) (2023-09-29)


### Dependencies

* Update dependency com.google.cloud:gapic-libraries-bom to v1.21.0 ([#1942](https://github.com/googleapis/java-bigtable/issues/1942)) ([f8d533f](https://github.com/googleapis/java-bigtable/commit/f8d533f4dcfd60a3eac9656bdc7339ac25f06fad))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.16.1 ([#1933](https://github.com/googleapis/java-bigtable/issues/1933)) ([159636a](https://github.com/googleapis/java-bigtable/commit/159636ac82e7bb19b425075a006ee98a39af1d57))

## [2.27.3](https://github.com/googleapis/java-bigtable/compare/v2.27.2...v2.27.3) (2023-09-29)


### Bug Fixes

* A rare race condition in the row merger ([#1939](https://github.com/googleapis/java-bigtable/issues/1939)) ([fccd710](https://github.com/googleapis/java-bigtable/commit/fccd7100578da3e2ee2a315c6e956c06dbf41668))


### Dependencies

* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.27 ([#1919](https://github.com/googleapis/java-bigtable/issues/1919)) ([56d6b40](https://github.com/googleapis/java-bigtable/commit/56d6b40b9f874ec4ad78618c1cf0d365ddc9276b))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.27 ([#1920](https://github.com/googleapis/java-bigtable/issues/1920)) ([ca1dd5b](https://github.com/googleapis/java-bigtable/commit/ca1dd5b258c7fa5cfd90811dc8b9492c19d1f104))
* Update gapic-generator-java to 2.26.0 ([#1936](https://github.com/googleapis/java-bigtable/issues/1936)) ([15cd486](https://github.com/googleapis/java-bigtable/commit/15cd4868ff807513914095a3758134eaa14f0ea3))

## [2.27.2](https://github.com/googleapis/java-bigtable/compare/v2.27.1...v2.27.2) (2023-09-13)


### Bug Fixes

* Check that all bulk mutation entries are accounted for ([#1907](https://github.com/googleapis/java-bigtable/issues/1907)) ([9ad8a00](https://github.com/googleapis/java-bigtable/commit/9ad8a00ec4f10a75952fa566a7effc980936dee1))
* Set wait timeout on watchdog ([#1913](https://github.com/googleapis/java-bigtable/issues/1913)) ([f8ba6fe](https://github.com/googleapis/java-bigtable/commit/f8ba6fe554dd02bb99fb03859cc5c8b04561b0c3))


### Dependencies

* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.26 ([#1896](https://github.com/googleapis/java-bigtable/issues/1896)) ([dfc4231](https://github.com/googleapis/java-bigtable/commit/dfc4231af9b74a4d5db3beaf26dd611a27cc6a67))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.26 ([#1897](https://github.com/googleapis/java-bigtable/issues/1897)) ([d446856](https://github.com/googleapis/java-bigtable/commit/d4468560db62f2102c404b3907cd5ae76d1e08b6))
* Update shared dependencies ([#1901](https://github.com/googleapis/java-bigtable/issues/1901)) ([96f2690](https://github.com/googleapis/java-bigtable/commit/96f2690e219714e497208e8be5e46b7f38340625))

## [2.27.1](https://github.com/googleapis/java-bigtable/compare/v2.27.0...v2.27.1) (2023-09-12)


### Bug Fixes

* Aggregate batching throttling latency per attempt and reset it between ([#1905](https://github.com/googleapis/java-bigtable/issues/1905)) ([e6cc5f6](https://github.com/googleapis/java-bigtable/commit/e6cc5f615630d15b717df1056ceed98f21f2297b))
* Make sure to propagate the response when throttling is enabled ([#1908](https://github.com/googleapis/java-bigtable/issues/1908)) ([f743187](https://github.com/googleapis/java-bigtable/commit/f7431871ba4ea64351fc5710089f8308e91d7978))


### Dependencies

* Update the Java code generator (gapic-generator-java) to 2.25.0 ([#1902](https://github.com/googleapis/java-bigtable/issues/1902)) ([f4fe6a0](https://github.com/googleapis/java-bigtable/commit/f4fe6a054194f68da1d7a548dec7a1cec68c1a2c))

## [2.27.0](https://github.com/googleapis/java-bigtable/compare/v2.26.0...v2.27.0) (2023-08-17)


### Features

* Copy backup API support ([#1398](https://github.com/googleapis/java-bigtable/issues/1398)) ([558a408](https://github.com/googleapis/java-bigtable/commit/558a408f5fa0566652df923799cf9f7bc03f7194))
* Publish CopyBackup protos to external customers ([#1883](https://github.com/googleapis/java-bigtable/issues/1883)) ([d6e934f](https://github.com/googleapis/java-bigtable/commit/d6e934fc71e1c1dd4e13492d2f6c4688b6b0d59d))

## [2.26.0](https://github.com/googleapis/java-bigtable/compare/v2.25.1...v2.26.0) (2023-08-09)


### Features

* Add last_scanned_row_key feature ([#1856](https://github.com/googleapis/java-bigtable/issues/1856)) ([ef30dde](https://github.com/googleapis/java-bigtable/commit/ef30dde4bdbedb8f04feb0604d66c95309468a2e))
* Enable last_scanned_row_responses feature flag ([#1862](https://github.com/googleapis/java-bigtable/issues/1862)) ([c2288c9](https://github.com/googleapis/java-bigtable/commit/c2288c9f1f97571b7b12394a4697ebf5abfc5cfc))
* Setup 2.25.x lts branch ([#1866](https://github.com/googleapis/java-bigtable/issues/1866)) ([220cf4b](https://github.com/googleapis/java-bigtable/commit/220cf4b142adeb63802e27fb5effdb343f832563))


### Bug Fixes

* Fix batcher metric labels ([#1829](https://github.com/googleapis/java-bigtable/issues/1829)) ([6245c12](https://github.com/googleapis/java-bigtable/commit/6245c12b37d8c1398cdfd497129a6fc1ef767508))


### Dependencies

* Update dependency com.google.cloud:google-cloud-monitoring-bom to v3.24.0 ([#1878](https://github.com/googleapis/java-bigtable/issues/1878)) ([0de458d](https://github.com/googleapis/java-bigtable/commit/0de458d919cdef4284da98b830c26027b9ae8941))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.14.0 ([#1873](https://github.com/googleapis/java-bigtable/issues/1873)) ([bb83064](https://github.com/googleapis/java-bigtable/commit/bb830647358e66bddc392e0cffbe7e63a7036ce6))
* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.24 ([#1876](https://github.com/googleapis/java-bigtable/issues/1876)) ([d397c33](https://github.com/googleapis/java-bigtable/commit/d397c337ab17d000a331bade8fca8b49f5f2355e))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.24 ([#1877](https://github.com/googleapis/java-bigtable/issues/1877)) ([1a8be60](https://github.com/googleapis/java-bigtable/commit/1a8be60a20498d6fa321841fa561ab7c3d9fe9a2))

## [2.25.1](https://github.com/googleapis/java-bigtable/compare/v2.25.0...v2.25.1) (2023-07-25)


### Bug Fixes

* Update the readRow attempt timeouts to be inline with unary rpcs instead of scans ([#1834](https://github.com/googleapis/java-bigtable/issues/1834)) ([168c33e](https://github.com/googleapis/java-bigtable/commit/168c33e3135755cc5a1105f18bf93ade5e1219dc))


### Dependencies

* Update dependency org.junit.vintage:junit-vintage-engine to v5.10.0 ([#1847](https://github.com/googleapis/java-bigtable/issues/1847)) ([825faaa](https://github.com/googleapis/java-bigtable/commit/825faaad93a5062e6f34ff699cc02701b69e56ab))
* Update shared dependencies ([#1845](https://github.com/googleapis/java-bigtable/issues/1845)) ([88e1892](https://github.com/googleapis/java-bigtable/commit/88e18922b4e1da398c51441aff014bca5f3bb746))
* Update the Java code generator (gapic-generator-java) to 2.23.1 ([#1846](https://github.com/googleapis/java-bigtable/issues/1846)) ([78fd837](https://github.com/googleapis/java-bigtable/commit/78fd837987780c62137354fbbe41e71050948405))

## [2.25.0](https://github.com/googleapis/java-bigtable/compare/v2.24.1...v2.25.0) (2023-07-14)


### Features

* Change stream retention to create and update table ([#1823](https://github.com/googleapis/java-bigtable/issues/1823)) ([05fca58](https://github.com/googleapis/java-bigtable/commit/05fca581d4225769cc581e26e679e6bca105055b))


### Bug Fixes

* Fix batch mutation limit ([#1808](https://github.com/googleapis/java-bigtable/issues/1808)) ([ed24d4f](https://github.com/googleapis/java-bigtable/commit/ed24d4fdc67c6d0af66ea055ba1ad7f7c037a361))
* Update default sample row key attempt timeout to 5 min ([#1827](https://github.com/googleapis/java-bigtable/issues/1827)) ([2f363ef](https://github.com/googleapis/java-bigtable/commit/2f363ef3636c2810c322bb5978cc586f8aec2ef2))


### Documentation

* Fix formatting for reversed order field example ([#1836](https://github.com/googleapis/java-bigtable/issues/1836)) ([10a0426](https://github.com/googleapis/java-bigtable/commit/10a0426f580b86b26541b95a778bb8b7f6562383))
* Increase the maximum retention period for a Cloud Bigtable backup from 30 days to 90 days ([#1826](https://github.com/googleapis/java-bigtable/issues/1826)) ([159fe38](https://github.com/googleapis/java-bigtable/commit/159fe3857735c9061672fc951388215edb0a324c))


### Dependencies

* Update dependency com.google.cloud:google-cloud-monitoring-bom to v3.22.0 ([#1838](https://github.com/googleapis/java-bigtable/issues/1838)) ([fba2c49](https://github.com/googleapis/java-bigtable/commit/fba2c49e9e71209289497f53868aa561c0fba7a3))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.13.0 ([#1833](https://github.com/googleapis/java-bigtable/issues/1833)) ([cb160af](https://github.com/googleapis/java-bigtable/commit/cb160af8e66ec6693ed0d3286c654a93094b68a3))

## [2.24.1](https://github.com/googleapis/java-bigtable/compare/v2.24.0...v2.24.1) (2023-06-27)


### Bug Fixes

* Remove javadoc external link configuration ([#1815](https://github.com/googleapis/java-bigtable/issues/1815)) ([9c71a93](https://github.com/googleapis/java-bigtable/commit/9c71a934f8354477b0e229b83047c8203d4ab978))

## [2.24.0](https://github.com/googleapis/java-bigtable/compare/v2.23.3...v2.24.0) (2023-06-27)


### Features

* Add experimental reverse scan for public preview ([#1809](https://github.com/googleapis/java-bigtable/issues/1809)) ([f4f2e2e](https://github.com/googleapis/java-bigtable/commit/f4f2e2ebac535372ebfb8ebd60ca78f0f7ca010b))
* Reverse scans public preview ([#1711](https://github.com/googleapis/java-bigtable/issues/1711)) ([176360f](https://github.com/googleapis/java-bigtable/commit/176360f2689966dccbe95c401cf2bfe9ca64f274))


### Dependencies

* Update dependency com.google.truth.extensions:truth-proto-extension to v1.1.5 ([#1801](https://github.com/googleapis/java-bigtable/issues/1801)) ([a8961e8](https://github.com/googleapis/java-bigtable/commit/a8961e8f45f5cb2812c185a68a8892bed958ae6a))
* Update dependency kr.motd.maven:os-maven-plugin to v1.7.1 ([#1792](https://github.com/googleapis/java-bigtable/issues/1792)) ([80acca0](https://github.com/googleapis/java-bigtable/commit/80acca0922060e932dedd31e8079f432b7de9785))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.23 ([#1800](https://github.com/googleapis/java-bigtable/issues/1800)) ([a9172c4](https://github.com/googleapis/java-bigtable/commit/a9172c4570a053d28ab90232b98ab716cc8b6f80))
* Update shared dependencies to 3.12.0, monitoring to 3.21.0, update renovate config ([#1807](https://github.com/googleapis/java-bigtable/issues/1807)) ([12fc8cd](https://github.com/googleapis/java-bigtable/commit/12fc8cded38d64c9e4d997d83ff8cdbffe373120))

## [2.23.3](https://github.com/googleapis/java-bigtable/compare/v2.23.2...v2.23.3) (2023-06-08)


### Bug Fixes

* Set wait timeout and update default attempt timeout to 30 minutes ([#1779](https://github.com/googleapis/java-bigtable/issues/1779)) ([11019b8](https://github.com/googleapis/java-bigtable/commit/11019b87fe32b5b9c9f2d947ffd9191b56120381))


### Dependencies

* Update dependency com.google.cloud:google-cloud-monitoring-bom to v3.20.0 ([#1785](https://github.com/googleapis/java-bigtable/issues/1785)) ([8ddd370](https://github.com/googleapis/java-bigtable/commit/8ddd370bf747bcc7ad7ccb6f00cc5ef188fa3511))
* Update gapic-generator-java to 2.21.0 ([#1760](https://github.com/googleapis/java-bigtable/issues/1760)) ([05545f8](https://github.com/googleapis/java-bigtable/commit/05545f87692c05c22d17e431551b4a5f91475286))
* Update shared dependencies to 3.11.0 ([#1783](https://github.com/googleapis/java-bigtable/issues/1783)) ([96aaa2a](https://github.com/googleapis/java-bigtable/commit/96aaa2a5a5a70feeb8ff0fd20b9dfc4a8a464bb7))

## [2.23.2](https://github.com/googleapis/java-bigtable/compare/v2.23.1...v2.23.2) (2023-05-30)


### Documentation

* **samples:** Add bigtable filter snippet ([#1762](https://github.com/googleapis/java-bigtable/issues/1762)) ([48a6ed0](https://github.com/googleapis/java-bigtable/commit/48a6ed028a56302d6dc6554b2ecdabc8fbdb68cf))
* **samples:** Remove client initialization as the snippets are not used standalone ([#1768](https://github.com/googleapis/java-bigtable/issues/1768)) ([a6ac97c](https://github.com/googleapis/java-bigtable/commit/a6ac97c08a851977a76e82fddb16690cff17a1fe))


### Dependencies

* Update dependency com.google.cloud:google-cloud-monitoring-bom to v3.19.0 ([#1769](https://github.com/googleapis/java-bigtable/issues/1769)) ([956c851](https://github.com/googleapis/java-bigtable/commit/956c851b5d7dadb44c589a3f982e603d0a768105))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.10.1 ([#1767](https://github.com/googleapis/java-bigtable/issues/1767)) ([901b88f](https://github.com/googleapis/java-bigtable/commit/901b88f56c7b97bc08826604ed80120f07f04a64))
* Update dependency com.google.truth.extensions:truth-proto-extension to v1.1.4 ([#1770](https://github.com/googleapis/java-bigtable/issues/1770)) ([a94a522](https://github.com/googleapis/java-bigtable/commit/a94a522a1fa4c67245f1827d8f8137cbfdbd5a45))
* Update doclet version to v1.9.0 ([#1761](https://github.com/googleapis/java-bigtable/issues/1761)) ([a5d4215](https://github.com/googleapis/java-bigtable/commit/a5d42159643c652a9625fee620fe5ee8dee7fa2e))

## [2.23.1](https://github.com/googleapis/java-bigtable/compare/v2.23.0...v2.23.1) (2023-05-11)


### Dependencies

* Update dependency com.google.cloud:google-cloud-monitoring-bom to v3.18.0 ([#1749](https://github.com/googleapis/java-bigtable/issues/1749)) ([1d7d391](https://github.com/googleapis/java-bigtable/commit/1d7d39145eefc5cbf6d015fd60a4d49441f88d1f))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.9.0 ([#1744](https://github.com/googleapis/java-bigtable/issues/1744)) ([60df07f](https://github.com/googleapis/java-bigtable/commit/60df07fcfa653291d9e5882cf3386f13813e2883))
* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.22 ([#1746](https://github.com/googleapis/java-bigtable/issues/1746)) ([86ea9db](https://github.com/googleapis/java-bigtable/commit/86ea9db830f6d5f7dc0b08886bce084b4650d281))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.22 ([#1747](https://github.com/googleapis/java-bigtable/issues/1747)) ([caa4462](https://github.com/googleapis/java-bigtable/commit/caa44627d6a124d1a58d85a510962c8a7caee69b))

## [2.23.0](https://github.com/googleapis/java-bigtable/compare/v2.22.0...v2.23.0) (2023-05-09)


### Features

* Resizing channel pool size based on the work load ([#1271](https://github.com/googleapis/java-bigtable/issues/1271)) ([7fb1a09](https://github.com/googleapis/java-bigtable/commit/7fb1a09224e1ea05cfec6eb35deaba670d1d82d2))


### Documentation

* Clean up BetaApi annotations from built in metrics API ([#1741](https://github.com/googleapis/java-bigtable/issues/1741)) ([c2fbd04](https://github.com/googleapis/java-bigtable/commit/c2fbd04eb64ddcfe7ea0f234f22d0691094646a4))

## [2.22.0](https://github.com/googleapis/java-bigtable/compare/v2.21.0...v2.22.0) (2023-05-02)


### Features

* Add APIs to enable batch write flow control ([#1730](https://github.com/googleapis/java-bigtable/issues/1730)) ([b518d68](https://github.com/googleapis/java-bigtable/commit/b518d6851429db640e80ab78b3f827bb334f5409))
* Add rate limiting callable ([#1729](https://github.com/googleapis/java-bigtable/issues/1729)) ([ee0da11](https://github.com/googleapis/java-bigtable/commit/ee0da11664d978e808d1088a419cdbd2270da147))
* Send feature flag when flow control is enabled ([#1731](https://github.com/googleapis/java-bigtable/issues/1731)) ([ba147c3](https://github.com/googleapis/java-bigtable/commit/ba147c3520be27f4f3e622f3ef69fab716895dbe))


### Bug Fixes

* Add feature flag proto to BUILD file ([#1726](https://github.com/googleapis/java-bigtable/issues/1726)) ([7e5c646](https://github.com/googleapis/java-bigtable/commit/7e5c646031de22c42bb3dd81774ccd6762bd91ed))

## [2.21.0](https://github.com/googleapis/java-bigtable/compare/v2.20.4...v2.21.0) (2023-04-27)


### Features

* Track the latency a request is queued on the grpc channel ([#1604](https://github.com/googleapis/java-bigtable/issues/1604)) ([bf3e7dd](https://github.com/googleapis/java-bigtable/commit/bf3e7dd58170bd058cedba8eea69b8c412ae68d3))


### Dependencies

* Update dependency com.google.cloud:google-cloud-monitoring-bom to v3.17.0 ([#1722](https://github.com/googleapis/java-bigtable/issues/1722)) ([c6f7767](https://github.com/googleapis/java-bigtable/commit/c6f776730bd1d78489be69d09744782e8b46c9b0))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.8.0 ([#1720](https://github.com/googleapis/java-bigtable/issues/1720)) ([aa230b5](https://github.com/googleapis/java-bigtable/commit/aa230b5be4e282ccaa506d360ce95fdbe58ed4bb))

## [2.20.4](https://github.com/googleapis/java-bigtable/compare/v2.20.3...v2.20.4) (2023-04-17)


### Documentation

* Make delete examples consistent with other languages ([#1710](https://github.com/googleapis/java-bigtable/issues/1710)) ([2d80188](https://github.com/googleapis/java-bigtable/commit/2d80188c65f454e037b758426b8747b5992db0de))


### Dependencies

* Update actions/setup-go action to v4 ([#1700](https://github.com/googleapis/java-bigtable/issues/1700)) ([1fd13ba](https://github.com/googleapis/java-bigtable/commit/1fd13ba9fdfa0322ee419f405c92ebe3979d85c7))
* Update dependency com.google.cloud:google-cloud-monitoring-bom to v3.16.0 ([#1712](https://github.com/googleapis/java-bigtable/issues/1712)) ([f3bb088](https://github.com/googleapis/java-bigtable/commit/f3bb088cd670805e5c6975e7154ee7e1e320acc6))
* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.21 ([#1704](https://github.com/googleapis/java-bigtable/issues/1704)) ([d60c946](https://github.com/googleapis/java-bigtable/commit/d60c94630f60d01241eecf9e3061ed197435b55e))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.21 ([#1705](https://github.com/googleapis/java-bigtable/issues/1705)) ([8f3d69d](https://github.com/googleapis/java-bigtable/commit/8f3d69d2498a7c0b5f760a40054e17d07502764d))
* Update shared dependencies ([#1703](https://github.com/googleapis/java-bigtable/issues/1703)) ([076b411](https://github.com/googleapis/java-bigtable/commit/076b411b3c834c4ed1b98551f08befab78743c8f))
* Upgrade maven-enforcer-plugin to 3.3.0, remove duplicate entry in pom ([#1702](https://github.com/googleapis/java-bigtable/issues/1702)) ([392fc69](https://github.com/googleapis/java-bigtable/commit/392fc697b9b75d172ba5bfd98ead45a6074c47f7))

## [2.20.3](https://github.com/googleapis/java-bigtable/compare/v2.20.2...v2.20.3) (2023-04-03)


### Dependencies

* Upgrade shared dependencies to 3.6.0 and monitoring to 3.15.0 ([#1688](https://github.com/googleapis/java-bigtable/issues/1688)) ([c0bad0d](https://github.com/googleapis/java-bigtable/commit/c0bad0d637179e0e8ed80e9716203ae8f11e5cb4))

## [2.20.2](https://github.com/googleapis/java-bigtable/compare/v2.20.1...v2.20.2) (2023-03-29)


### Bug Fixes

* Higher application blocking latency precision ([#1676](https://github.com/googleapis/java-bigtable/issues/1676)) ([45ce93b](https://github.com/googleapis/java-bigtable/commit/45ce93bb52112391b9c3a90f10f51279839bea1b))
* Make ChangeStreamRecord interface serializable ([#1685](https://github.com/googleapis/java-bigtable/issues/1685)) ([b97badb](https://github.com/googleapis/java-bigtable/commit/b97badbaa30588c578bfacc8183e77baaa656bd9))
* Mark readRow requests as unary operations ([#1679](https://github.com/googleapis/java-bigtable/issues/1679)) ([f88bb67](https://github.com/googleapis/java-bigtable/commit/f88bb67a7a63450b8cd29f01660cf677ddfe436c))

## [2.20.1](https://github.com/googleapis/java-bigtable/compare/v2.20.0...v2.20.1) (2023-03-21)


### Bug Fixes

* If new_partitions is size 0, do not enforce size check ([#1673](https://github.com/googleapis/java-bigtable/issues/1673)) ([07bcfd9](https://github.com/googleapis/java-bigtable/commit/07bcfd9a0967f781fb8e5e0d764654dbf7bcda91))


### Dependencies

* Update dependency com.google.cloud:google-cloud-monitoring-bom to v3.14.0 ([#1668](https://github.com/googleapis/java-bigtable/issues/1668)) ([06f9615](https://github.com/googleapis/java-bigtable/commit/06f96156705a2a7897a31d11dad864afe94de693))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.5.0 ([#1670](https://github.com/googleapis/java-bigtable/issues/1670)) ([74cebf3](https://github.com/googleapis/java-bigtable/commit/74cebf3a5ab58f3fd3ae95583ba2421b733deda8))

## [2.20.0](https://github.com/googleapis/java-bigtable/compare/v2.19.2...v2.20.0) (2023-03-02)


### Features

* Add getNewPartitions method to CloseStream for Bigtable ChangeStream ([#1655](https://github.com/googleapis/java-bigtable/issues/1655)) ([8847fed](https://github.com/googleapis/java-bigtable/commit/8847fed7f77ce4715c197ca1cfcc3108e0fa1004))
* Add new_partitions field for CloseStream for Cloud Bigtable ChangeStream ([#1654](https://github.com/googleapis/java-bigtable/issues/1654)) ([0e283bf](https://github.com/googleapis/java-bigtable/commit/0e283bff0a12f5e4da8b0975d4bd747229c3780c))


### Bug Fixes

* Fix StackOverflow in ChangeStreamStateMachine due to excessive mods ([#1648](https://github.com/googleapis/java-bigtable/issues/1648)) ([9e11106](https://github.com/googleapis/java-bigtable/commit/9e1110600dc64defcd9143753f45b5b8226aa339))
* Use org.threeten.bp.Duration for ReadChangeStreamQuery::heartbeatDura… ([#1652](https://github.com/googleapis/java-bigtable/issues/1652)) ([87261a9](https://github.com/googleapis/java-bigtable/commit/87261a977d6fc7877d7d253c67ea34c264f63f7c))


### Dependencies

* Update dependency com.google.cloud:google-cloud-monitoring-bom to v3.13.0 ([#1656](https://github.com/googleapis/java-bigtable/issues/1656)) ([1c632ec](https://github.com/googleapis/java-bigtable/commit/1c632ec63987958e469e2b5861c29724c5cb8970))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.4.0 ([#1657](https://github.com/googleapis/java-bigtable/issues/1657)) ([c7a3e29](https://github.com/googleapis/java-bigtable/commit/c7a3e29dc717e2fa3d9b15f1ae9fb9f795d6f78a))

## [2.19.2](https://github.com/googleapis/java-bigtable/compare/v2.19.1...v2.19.2) (2023-02-21)


### Bug Fixes

* Change types for Cloud Bigtable Changestream methods ([#1639](https://github.com/googleapis/java-bigtable/issues/1639)) ([908d70f](https://github.com/googleapis/java-bigtable/commit/908d70fdfa22e563031e2d8780b574ee7350cadc))


### Dependencies

* Update shared deps to 3.3.0 and monitoring to 3.12.0 ([#1643](https://github.com/googleapis/java-bigtable/issues/1643)) ([1a54fbf](https://github.com/googleapis/java-bigtable/commit/1a54fbf22490e5a83df0b0d73dc4b30472175102))

## [2.19.1](https://github.com/googleapis/java-bigtable/compare/v2.19.0...v2.19.1) (2023-02-16)


### Bug Fixes

* Change the return type of Heartbeat::getEstimatedLowWatermark to long ([#1631](https://github.com/googleapis/java-bigtable/issues/1631)) ([a101494](https://github.com/googleapis/java-bigtable/commit/a101494909226114fd951c94348878bf38453793))
* Fix connectivity error count calculation ([#1632](https://github.com/googleapis/java-bigtable/issues/1632)) ([0803785](https://github.com/googleapis/java-bigtable/commit/0803785694874001a6ffbfe3245e84a23cb905ae))
* **test:** Fix flaky test ([#1633](https://github.com/googleapis/java-bigtable/issues/1633)) ([fc29cd3](https://github.com/googleapis/java-bigtable/commit/fc29cd35101fd6a6262aea8648bc06bd20ce3d10))


### Dependencies

* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.20 ([#1626](https://github.com/googleapis/java-bigtable/issues/1626)) ([0865023](https://github.com/googleapis/java-bigtable/commit/08650238a806367c94072b51029010272c966148))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.20 ([#1627](https://github.com/googleapis/java-bigtable/issues/1627)) ([782e81f](https://github.com/googleapis/java-bigtable/commit/782e81f6e64c1d8015fddf2219d590c77217584d))

## [2.19.0](https://github.com/googleapis/java-bigtable/compare/v2.18.4...v2.19.0) (2023-02-10)


### Features

* Support Cloud Bigtable Changestream ([#1569](https://github.com/googleapis/java-bigtable/issues/1569)) ([c7b4fdf](https://github.com/googleapis/java-bigtable/commit/c7b4fdf70f02b89f178a130d7fdcfcf8b2a6b790))


### Bug Fixes

* Modify ConvertExceptionCallable to retry on Goaway ([#1588](https://github.com/googleapis/java-bigtable/issues/1588)) ([cf752ea](https://github.com/googleapis/java-bigtable/commit/cf752eaf3b5fb2cddb11a2fbb5acb5a72c9862c2))


### Documentation

* Fix javadoc code example for awaitOptimizeRestoredTableAsync ([#1617](https://github.com/googleapis/java-bigtable/issues/1617)) ([8b23bb9](https://github.com/googleapis/java-bigtable/commit/8b23bb93d40dbfd9591c7d7546216e2543f9f418))

## [2.18.4](https://github.com/googleapis/java-bigtable/compare/v2.18.3...v2.18.4) (2023-02-06)


### Dependencies

* Update dependency com.google.cloud:google-cloud-monitoring-bom to v3.11.0 ([#1609](https://github.com/googleapis/java-bigtable/issues/1609)) ([88be13e](https://github.com/googleapis/java-bigtable/commit/88be13e2db9635e124ed169850a18fc968895f2b))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.2.0 ([#1610](https://github.com/googleapis/java-bigtable/issues/1610)) ([15db117](https://github.com/googleapis/java-bigtable/commit/15db11712956410636fffcc827c971181fcad2ee))

## [2.18.3](https://github.com/googleapis/java-bigtable/compare/v2.18.2...v2.18.3) (2023-01-24)


### Bug Fixes

* Make channel priming work with batch endpoint ([#1600](https://github.com/googleapis/java-bigtable/issues/1600)) ([133c7e5](https://github.com/googleapis/java-bigtable/commit/133c7e50a5a84e880f23cfc7ed88ea2250a2994d))

## [2.18.2](https://github.com/googleapis/java-bigtable/compare/v2.18.1...v2.18.2) (2023-01-24)


### Dependencies

* Update dependency com.google.cloud:google-cloud-monitoring-bom to v3.10.0 ([#1597](https://github.com/googleapis/java-bigtable/issues/1597)) ([1724d4e](https://github.com/googleapis/java-bigtable/commit/1724d4ee6b63085b035082bd299668ceadd8bd01))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.1.2 ([#1595](https://github.com/googleapis/java-bigtable/issues/1595)) ([e466191](https://github.com/googleapis/java-bigtable/commit/e466191ef8562b767218dcd4811a271ec6e98257))

## [2.18.1](https://github.com/googleapis/java-bigtable/compare/v2.18.0...v2.18.1) (2023-01-17)


### Dependencies

* Update dependency com.google.cloud:google-cloud-monitoring-bom to v3.9.0 ([#1579](https://github.com/googleapis/java-bigtable/issues/1579)) ([70c0500](https://github.com/googleapis/java-bigtable/commit/70c050001379214d5577a896e280d04101891a08))

## [2.18.0](https://github.com/googleapis/java-bigtable/compare/v2.17.1...v2.18.0) (2023-01-12)


### Features

* Enable channel priming by default ([#1555](https://github.com/googleapis/java-bigtable/issues/1555)) ([303959c](https://github.com/googleapis/java-bigtable/commit/303959cc88e8cf164a45026d79de67e3f58d09fe))


### Bug Fixes

* Call attemptStarted method with the request ([#1562](https://github.com/googleapis/java-bigtable/issues/1562)) ([325f09c](https://github.com/googleapis/java-bigtable/commit/325f09c9e257d53871a9071e6bfcbb0887298641))
* Defer instance admin api errors to RPC time rather then client construction time ([#1576](https://github.com/googleapis/java-bigtable/issues/1576)) ([06a0ced](https://github.com/googleapis/java-bigtable/commit/06a0ced03dbac91145bac6d5d01f327c3ff4a83f))


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.1.1 ([#1572](https://github.com/googleapis/java-bigtable/issues/1572)) ([a68fb80](https://github.com/googleapis/java-bigtable/commit/a68fb8028a338b937b4baf8c50fad1080e137849))
* Update dependency org.junit.vintage:junit-vintage-engine to v5.9.2 ([#1573](https://github.com/googleapis/java-bigtable/issues/1573)) ([e1362aa](https://github.com/googleapis/java-bigtable/commit/e1362aa4e47b2da089b21a8cfd124d7e935af8de))

## [2.17.1](https://github.com/googleapis/java-bigtable/compare/v2.17.0...v2.17.1) (2022-12-13)


### Dependencies

* Update dependency com.google.cloud:google-cloud-monitoring-bom to v3.8.0 ([#1548](https://github.com/googleapis/java-bigtable/issues/1548)) ([48f136d](https://github.com/googleapis/java-bigtable/commit/48f136dc1422d601d5470a33763e37514cf620de))

## [2.17.0](https://github.com/googleapis/java-bigtable/compare/v2.16.0...v2.17.0) (2022-12-07)


### Features

* Add a query paginator ([#1530](https://github.com/googleapis/java-bigtable/issues/1530)) ([5c8e1f6](https://github.com/googleapis/java-bigtable/commit/5c8e1f656b15177ecef4709b9e502cef58cca479))
* Add test proxy to java-bigtable client ([#1498](https://github.com/googleapis/java-bigtable/issues/1498)) ([132b4e4](https://github.com/googleapis/java-bigtable/commit/132b4e4fe340ca316de8eef2e2133b6dabd9dec3))
* Implement cross-project table restore ([#1536](https://github.com/googleapis/java-bigtable/issues/1536)) ([335977c](https://github.com/googleapis/java-bigtable/commit/335977c499b1776c8fa861d13195ffc49e468e0a))
* Next release from main branch is 2.17.0 ([#1514](https://github.com/googleapis/java-bigtable/issues/1514)) ([4fc6a93](https://github.com/googleapis/java-bigtable/commit/4fc6a93a25362df7bc107d48f94e1c00b6bd608d))


### Dependencies

* Update dependency com.google.cloud:google-cloud-monitoring-bom … ([#1531](https://github.com/googleapis/java-bigtable/issues/1531)) ([ee98338](https://github.com/googleapis/java-bigtable/commit/ee9833835a84cee202b142950b28704db682ac0c))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.1.0 ([#1539](https://github.com/googleapis/java-bigtable/issues/1539)) ([3244cef](https://github.com/googleapis/java-bigtable/commit/3244cefd4d77a44bab6ccaa8f5c03e3d31575625))
* Update dependency kr.motd.maven:os-maven-plugin to v1.7.1 ([#1518](https://github.com/googleapis/java-bigtable/issues/1518)) ([8309681](https://github.com/googleapis/java-bigtable/commit/830968109a3754a12bd0bc92674fe42ae529b924))
* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.19 ([#1537](https://github.com/googleapis/java-bigtable/issues/1537)) ([7f7c478](https://github.com/googleapis/java-bigtable/commit/7f7c478a2163c46d10ed39ea3c1b046f971d4569))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.19 ([#1538](https://github.com/googleapis/java-bigtable/issues/1538)) ([9d3df57](https://github.com/googleapis/java-bigtable/commit/9d3df57d7bfeafd9cbcf56ecd58b52cc1b14ba7b))

## [2.16.0](https://github.com/googleapis/java-bigtable/compare/v2.15.1...v2.16.0) (2022-11-11)


### Features

* Remove proto ReadEfficiencyStats ([#1455](https://github.com/googleapis/java-bigtable/issues/1455)) ([f6b243d](https://github.com/googleapis/java-bigtable/commit/f6b243db39c0370f0d9a4e47e553cfe62493b240))


### Bug Fixes

* Fix metric client settings ([#1509](https://github.com/googleapis/java-bigtable/issues/1509)) ([38ac115](https://github.com/googleapis/java-bigtable/commit/38ac115af07432e9c178064b59729a0b358105cd))

## [2.15.1](https://github.com/googleapis/java-bigtable/compare/v2.15.0...v2.15.1) (2022-11-08)


### Bug Fixes

* Call record attempt compeletion on permanent failures ([#1502](https://github.com/googleapis/java-bigtable/issues/1502)) ([f409c47](https://github.com/googleapis/java-bigtable/commit/f409c4769b526b38590671178c007a9c57f9c182))
* Fix the connectivity error count caculation ([#1401](https://github.com/googleapis/java-bigtable/issues/1401)) ([1f8cfd7](https://github.com/googleapis/java-bigtable/commit/1f8cfd722c749a8d3e30572fbdda6a2e3594d7a6))
* Only record retry count when it's &gt; 0 ([#1488](https://github.com/googleapis/java-bigtable/issues/1488)) ([445a667](https://github.com/googleapis/java-bigtable/commit/445a66737b45835444b26261b6f017f7fc278f45))


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.6 ([#1501](https://github.com/googleapis/java-bigtable/issues/1501)) ([8f61c64](https://github.com/googleapis/java-bigtable/commit/8f61c64aba815a942daae17ccb024d325c03df8a))
* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.17 ([#1495](https://github.com/googleapis/java-bigtable/issues/1495)) ([1b7c21a](https://github.com/googleapis/java-bigtable/commit/1b7c21abc793db0e4706f119e934eecdcfce9994))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.17 ([#1496](https://github.com/googleapis/java-bigtable/issues/1496)) ([74779e3](https://github.com/googleapis/java-bigtable/commit/74779e3621c9893bf3a84dc68ddcb624785c8d71))

## [2.15.0](https://github.com/googleapis/java-bigtable/compare/v2.14.1...v2.15.0) (2022-10-26)


### Features

* Add apis for Mutation and RowMutationEntry ([#1454](https://github.com/googleapis/java-bigtable/issues/1454)) ([a86934f](https://github.com/googleapis/java-bigtable/commit/a86934f4f70e1998e7368688df8695a4bac7006e))


### Bug Fixes

* Catch all throwables so version mismatch won't hang the client ([#1402](https://github.com/googleapis/java-bigtable/issues/1402)) ([c03b8a4](https://github.com/googleapis/java-bigtable/commit/c03b8a4245beab7258b8ed8ec76153e6a0275211))
* Fix attempt status tag for metrics ([#1477](https://github.com/googleapis/java-bigtable/issues/1477)) ([e54cf7d](https://github.com/googleapis/java-bigtable/commit/e54cf7d61128049cea2817b409a8524636b4a6cf))
* Rename metric names to match the external name ([#1479](https://github.com/googleapis/java-bigtable/issues/1479)) ([28ca7c3](https://github.com/googleapis/java-bigtable/commit/28ca7c310d9a157529555ab6865f89802161443b))
* Set a longer timeout to wait for callbacks to be executed ([#1478](https://github.com/googleapis/java-bigtable/issues/1478)) ([0d9ff6a](https://github.com/googleapis/java-bigtable/commit/0d9ff6ab3bd5bf853f1d371312036b14c924ae5e))


### Dependencies

* Update dependency com.google.cloud:google-cloud-monitoring-bom to v3.5.0 ([#1464](https://github.com/googleapis/java-bigtable/issues/1464)) ([d8e58a5](https://github.com/googleapis/java-bigtable/commit/d8e58a5d88de7ea249d7bc141f1ac65592088da6))
* Update dependency com.google.cloud:google-cloud-monitoring-bom to v3.6.0 ([#1476](https://github.com/googleapis/java-bigtable/issues/1476)) ([331dcfb](https://github.com/googleapis/java-bigtable/commit/331dcfbd06ab578cfe9673ca70cab1f6abd5ddcd))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.5 ([#1470](https://github.com/googleapis/java-bigtable/issues/1470)) ([557a4fb](https://github.com/googleapis/java-bigtable/commit/557a4fbed77157c3ccfc3e84a0c952b647844f9b))
* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.15 ([#1462](https://github.com/googleapis/java-bigtable/issues/1462)) ([69540cb](https://github.com/googleapis/java-bigtable/commit/69540cb2df25d5fb716e81e7513930b01c310b72))
* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.16 ([#1467](https://github.com/googleapis/java-bigtable/issues/1467)) ([53599ca](https://github.com/googleapis/java-bigtable/commit/53599caa0f92bad1365adbc4b58a1dcb1e8a393e))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.15 ([#1463](https://github.com/googleapis/java-bigtable/issues/1463)) ([a6612f9](https://github.com/googleapis/java-bigtable/commit/a6612f90cd4a0ec9589ca797ff3a42d23478a6e6))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.16 ([#1468](https://github.com/googleapis/java-bigtable/issues/1468)) ([fe0ddb1](https://github.com/googleapis/java-bigtable/commit/fe0ddb1b183cfdf368c2387a645a613bbfd52a69))

## [2.14.1](https://github.com/googleapis/java-bigtable/compare/v2.14.0...v2.14.1) (2022-10-05)


### Dependencies

* Update dependency com.google.cloud:google-cloud-monitoring-bom to v3.4.6 ([#1450](https://github.com/googleapis/java-bigtable/issues/1450)) ([96b1e80](https://github.com/googleapis/java-bigtable/commit/96b1e80af5e17689a84318e9a797195cde3dab45))

## [2.14.0](https://github.com/googleapis/java-bigtable/compare/v2.13.0...v2.14.0) (2022-10-03)


### Features

* Publish the RequestStats proto ([#1400](https://github.com/googleapis/java-bigtable/issues/1400)) ([e989200](https://github.com/googleapis/java-bigtable/commit/e989200980510b14d602925df7430e01bc2f8db7))


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.4 ([#1446](https://github.com/googleapis/java-bigtable/issues/1446)) ([81034c5](https://github.com/googleapis/java-bigtable/commit/81034c51722d973cf5545feb33665b4e08265303))

## [2.13.0](https://github.com/googleapis/java-bigtable/compare/v2.12.0...v2.13.0) (2022-09-27)


### Features

* Add gRPC RLS dependency ([#1248](https://github.com/googleapis/java-bigtable/issues/1248)) ([e829b92](https://github.com/googleapis/java-bigtable/commit/e829b923d97a00dcb55a14b0877bec2c8cf5ece2))


### Bug Fixes

* Add a UUID in the task value ([#1430](https://github.com/googleapis/java-bigtable/issues/1430)) ([3bfc7bc](https://github.com/googleapis/java-bigtable/commit/3bfc7bc246488a37b4470e3a75ffdd34f6761804))


### Dependencies

* Update dependency com.google.cloud:google-cloud-monitoring-bom to v3.4.5 ([#1406](https://github.com/googleapis/java-bigtable/issues/1406)) ([d906729](https://github.com/googleapis/java-bigtable/commit/d906729a4bb9a51907bf4879e8d063d5103565ac))
* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.14 ([#1411](https://github.com/googleapis/java-bigtable/issues/1411)) ([ef7d741](https://github.com/googleapis/java-bigtable/commit/ef7d7419293f9f046dcf941148a86da713feae17))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.14 ([#1412](https://github.com/googleapis/java-bigtable/issues/1412)) ([dcae319](https://github.com/googleapis/java-bigtable/commit/dcae3195871b78aa6e102c4bc570b18c303c7760))
* Update dependency org.junit.vintage:junit-vintage-engine to v5.9.1 ([#1409](https://github.com/googleapis/java-bigtable/issues/1409)) ([c1e195d](https://github.com/googleapis/java-bigtable/commit/c1e195d4e0470b30d97231c44b09fcb5c4881514))

## [2.12.0](https://github.com/googleapis/java-bigtable/compare/v2.11.2...v2.12.0) (2022-09-15)


### Features

* **generated:** Publish CBT deletion_protection field in Table, UpdateTableRequest, and UpdateTable API ([f1f3f05](https://github.com/googleapis/java-bigtable/commit/f1f3f05ae2dc84a8dc853eb5467fbd157b7293c3))


### Dependencies

* Update dependency com.google.cloud:google-cloud-monitoring-bom to v3.4.3 ([#1386](https://github.com/googleapis/java-bigtable/issues/1386)) ([f460373](https://github.com/googleapis/java-bigtable/commit/f460373eb74776fae1787b74392b508643e6139f))
* Update dependency com.google.cloud:google-cloud-monitoring-bom to v3.4.3 ([#1387](https://github.com/googleapis/java-bigtable/issues/1387)) ([e339cb1](https://github.com/googleapis/java-bigtable/commit/e339cb186289fa53a0d65c3d77fb7edbae737882))
* Update dependency com.google.cloud:google-cloud-monitoring-bom to v3.4.4 ([#1395](https://github.com/googleapis/java-bigtable/issues/1395)) ([a2db183](https://github.com/googleapis/java-bigtable/commit/a2db183dea46cd83ea70bb89848e0579b9c61fac))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.2 ([#1384](https://github.com/googleapis/java-bigtable/issues/1384)) ([ee3b256](https://github.com/googleapis/java-bigtable/commit/ee3b256a62c2665e2c4230d9acfc14c3d5c2aebf))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.3 ([#1393](https://github.com/googleapis/java-bigtable/issues/1393)) ([df6c6c7](https://github.com/googleapis/java-bigtable/commit/df6c6c79715ecc7b99e026ce8dfa8645765fc9d5))

## [2.11.2](https://github.com/googleapis/java-bigtable/compare/v2.11.1...v2.11.2) (2022-09-07)


### Bug Fixes

* Make cloud-monitoring a runtime dependency ([#1371](https://github.com/googleapis/java-bigtable/issues/1371)) ([930d043](https://github.com/googleapis/java-bigtable/commit/930d0439086d2b43735f9583175adf0626952c9b))


### Dependencies

* Update dependency com.google.cloud:google-cloud-monitoring-bom to v3.4.2 ([#1373](https://github.com/googleapis/java-bigtable/issues/1373)) ([43b8052](https://github.com/googleapis/java-bigtable/commit/43b80523cc00932a414702ad96cfd86984c0f649))
* Update dependency com.google.cloud:google-cloud-monitoring-bom to v3.4.2 ([#1374](https://github.com/googleapis/java-bigtable/issues/1374)) ([4174f0d](https://github.com/googleapis/java-bigtable/commit/4174f0dc1b61f954ccd1c2fcf88066179a4d430b))

## [2.11.1](https://github.com/googleapis/java-bigtable/compare/v2.11.0...v2.11.1) (2022-08-26)


### Bug Fixes

* reset a measure map everytime the stats are recorded ([#1364](https://github.com/googleapis/java-bigtable/issues/1364)) ([1683365](https://github.com/googleapis/java-bigtable/commit/1683365938178bb61b1e9c871f1971449ee942c2))

## [2.11.0](https://github.com/googleapis/java-bigtable/compare/v2.10.3...v2.11.0) (2022-08-17)


### Features

* add stackdriver exporter ([#1247](https://github.com/googleapis/java-bigtable/issues/1247)) ([7ce915e](https://github.com/googleapis/java-bigtable/commit/7ce915e34c1ccce30bee78bda9e024a620cde737))


### Dependencies

* update dependency com.google.cloud:google-cloud-monitoring-bom to v3.4.1 ([#1352](https://github.com/googleapis/java-bigtable/issues/1352)) ([f8d97e5](https://github.com/googleapis/java-bigtable/commit/f8d97e557318eab214f3d916c029bfa153cf7455))

## [2.10.3](https://github.com/googleapis/java-bigtable/compare/v2.10.2...v2.10.3) (2022-08-08)


### Bug Fixes

* declaring 2 http libraries as runtime ([#1341](https://github.com/googleapis/java-bigtable/issues/1341)) ([8071de6](https://github.com/googleapis/java-bigtable/commit/8071de6235a6c1aa5873902ca55beaa2a8d64276))

## [2.10.2](https://github.com/googleapis/java-bigtable/compare/v2.10.1...v2.10.2) (2022-08-03)


### Bug Fixes

* add a ReadFirstRow callable to set future in onComplete ([#1326](https://github.com/googleapis/java-bigtable/issues/1326)) ([cb539b5](https://github.com/googleapis/java-bigtable/commit/cb539b50d98ec2a8538ce4691b2639426ca95464))
* The metadata could be returned in trailer or header depends on i… ([#1337](https://github.com/googleapis/java-bigtable/issues/1337)) ([c4b8c03](https://github.com/googleapis/java-bigtable/commit/c4b8c03ece7b3f6ec2cea42ff0ca5ac617528060))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v3 ([#1328](https://github.com/googleapis/java-bigtable/issues/1328)) ([bee0ca0](https://github.com/googleapis/java-bigtable/commit/bee0ca036ab6e711f6069159364f6d3b691e6bfd))
* upgrade shared config to 1.5.3, exclude google-http-client and google-http-client-gson from gax in google-cloud-bigtable-stats ([#1336](https://github.com/googleapis/java-bigtable/issues/1336)) ([98b3349](https://github.com/googleapis/java-bigtable/commit/98b33498d85325d22737fb4bd66826519e96755a))

## [2.10.1](https://github.com/googleapis/java-bigtable/compare/v2.10.0...v2.10.1) (2022-08-01)


### Bug Fixes

* retry rst stream in mutations ([#1327](https://github.com/googleapis/java-bigtable/issues/1327)) ([1a5b3a2](https://github.com/googleapis/java-bigtable/commit/1a5b3a215b5388678241cadec26a962a512157ac))


### Dependencies

* update dependency org.junit.vintage:junit-vintage-engine to v5.9.0 ([#1323](https://github.com/googleapis/java-bigtable/issues/1323)) ([7655747](https://github.com/googleapis/java-bigtable/commit/76557476744a6404b9df30c97c59f0a7e38a1ed8))

## [2.10.0](https://github.com/googleapis/java-bigtable/compare/v2.9.0...v2.10.0) (2022-07-26)


### Features

* add response protos ([#1246](https://github.com/googleapis/java-bigtable/issues/1246)) ([52d59ce](https://github.com/googleapis/java-bigtable/commit/52d59ce18fb5536a17a5cb59da39e563e4afede4))
* add response_params proto to clients ([#1303](https://github.com/googleapis/java-bigtable/issues/1303)) ([93edfe1](https://github.com/googleapis/java-bigtable/commit/93edfe1e43dcfefda6bba3e9ee53ed80eaf2e5c2))
* add storage utilization gib per node for autoscaling ([#1317](https://github.com/googleapis/java-bigtable/issues/1317)) ([5282589](https://github.com/googleapis/java-bigtable/commit/52825891af0e4ec2dd76c0c6fa1379a98a77a08f))
* use PingAndWarm request for channel priming ([#1179](https://github.com/googleapis/java-bigtable/issues/1179)) ([6629821](https://github.com/googleapis/java-bigtable/commit/6629821ea3200d3a5b93c9d45aab6d57485fcebf))


### Bug Fixes

* enable integration test for google-cloud-bigtable-stats ([#1311](https://github.com/googleapis/java-bigtable/issues/1311)) ([7c77879](https://github.com/googleapis/java-bigtable/commit/7c7787998b164ceb55472c0d06c083a835e5d000))
* fix race condition in BuiltinMetricsTracer ([#1320](https://github.com/googleapis/java-bigtable/issues/1320)) ([644454a](https://github.com/googleapis/java-bigtable/commit/644454a9723da359677052b7a4b9201e91e9a78a))
* ignore repackaged files to fix clirr ([#1300](https://github.com/googleapis/java-bigtable/issues/1300)) ([99b67ba](https://github.com/googleapis/java-bigtable/commit/99b67ba5b1625686ac7802a6e40dafc2edceade0))


### Dependencies

* update dependency org.graalvm.buildtools:junit-platform-native to v0.9.13 ([#1306](https://github.com/googleapis/java-bigtable/issues/1306)) ([ddae354](https://github.com/googleapis/java-bigtable/commit/ddae3540fd68e8f79d94d49c96c5685e1bad2f66))
* update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.13 ([#1307](https://github.com/googleapis/java-bigtable/issues/1307)) ([c0740fe](https://github.com/googleapis/java-bigtable/commit/c0740fe30c5cd2bdf6dedf901e2fdb9a84ce64a1))

## [2.9.0](https://github.com/googleapis/java-bigtable/compare/v2.8.0...v2.9.0) (2022-06-30)


### Features

* add built-in metric constants ([#1243](https://github.com/googleapis/java-bigtable/issues/1243)) ([b1fc00a](https://github.com/googleapis/java-bigtable/commit/b1fc00aa09129185b4e4db8edb9c4af2dbfd1ec8))
* **generated:** Add storage_utilization_gib_per_node to Autoscaling target ([a4c6621](https://github.com/googleapis/java-bigtable/commit/a4c662153c98f8043059a068a66d784761b7c2cb))
* **generated:** Cloud Bigtable Undelete Table service and message proto files ([a4c6621](https://github.com/googleapis/java-bigtable/commit/a4c662153c98f8043059a068a66d784761b7c2cb))
* update tracers to use built in metrics ([#1244](https://github.com/googleapis/java-bigtable/issues/1244)) ([df77560](https://github.com/googleapis/java-bigtable/commit/df77560debadec8b3aecc08e95a58558c418df86))


### Bug Fixes

* fix flaky test ([#1293](https://github.com/googleapis/java-bigtable/issues/1293)) ([146c824](https://github.com/googleapis/java-bigtable/commit/146c824962b48b2023ddb93d92e4a61297722f0f))
* remove the shaded profile from root pom ([#1274](https://github.com/googleapis/java-bigtable/issues/1274)) ([5eafcc3](https://github.com/googleapis/java-bigtable/commit/5eafcc3be3986692e64c95dcfc0d675208f2218c))
* rename HeaderTracer callables to BigtableTracer callables ([#1276](https://github.com/googleapis/java-bigtable/issues/1276)) ([e0bd6c9](https://github.com/googleapis/java-bigtable/commit/e0bd6c922ed2adfc8d6dddeced84cb87fc9f2e91))
* rename response observer and callbacks ([#1291](https://github.com/googleapis/java-bigtable/issues/1291)) ([2705a47](https://github.com/googleapis/java-bigtable/commit/2705a477f70247f16401901be9e0cd38733bdd2f))


### Documentation

* **sample:** update README for native image sample ([#1281](https://github.com/googleapis/java-bigtable/issues/1281)) ([4a3a2c9](https://github.com/googleapis/java-bigtable/commit/4a3a2c947642678c3011db616ebe7cbaed677f96))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.13.0 ([#1285](https://github.com/googleapis/java-bigtable/issues/1285)) ([1dc7787](https://github.com/googleapis/java-bigtable/commit/1dc77879ea51fd397b75020a16728adec72f1b9b))
* update dependency org.graalvm.buildtools:junit-platform-native to v0.9.12 ([#1283](https://github.com/googleapis/java-bigtable/issues/1283)) ([ba7844a](https://github.com/googleapis/java-bigtable/commit/ba7844acb6a4a3c47f1fc12b426f517b7fe3e55e))
* update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.12 ([#1284](https://github.com/googleapis/java-bigtable/issues/1284)) ([75d0066](https://github.com/googleapis/java-bigtable/commit/75d006601e51263786f38b445a9cc6f08cbee403))

## [2.8.0](https://github.com/googleapis/java-bigtable/compare/v2.7.0...v2.8.0) (2022-05-27)


### Features

* split emulator into core without deps and a higher level wrapper with grpc helpers ([#1264](https://github.com/googleapis/java-bigtable/issues/1264)) ([6fdc2c1](https://github.com/googleapis/java-bigtable/commit/6fdc2c1a33e140466734debed22d50a7be726d87))


### Bug Fixes

* **java:** enable skipped tests for Native Image testing  ([#1234](https://github.com/googleapis/java-bigtable/issues/1234)) ([560a501](https://github.com/googleapis/java-bigtable/commit/560a5018087c6cdc46e2c6150e6ed41075007177))

## [2.7.0](https://github.com/googleapis/java-bigtable/compare/v2.6.2...v2.7.0) (2022-05-20)


### Features

* (generated) Add ListHotTablets API method and protobufs ([f127f1a](https://github.com/googleapis/java-bigtable/commit/f127f1a05647c8fb2c9becf07753c302957bd571))
* (generated) AuditConfig for IAM v1 ([f127f1a](https://github.com/googleapis/java-bigtable/commit/f127f1a05647c8fb2c9becf07753c302957bd571))
* add build scripts for native image testing in Java 17 ([#1440](https://github.com/googleapis/java-bigtable/issues/1440)) ([#1255](https://github.com/googleapis/java-bigtable/issues/1255)) ([2e0bf19](https://github.com/googleapis/java-bigtable/commit/2e0bf193e3abaf2cfdc6208c41e7d8b928e92dc7))
* next release from main branch is v2.7.0 ([22acfc4](https://github.com/googleapis/java-bigtable/commit/22acfc405e23ccfeeeedcce6992f887d48d22bd5))


### Documentation

* Remove the limitation of all clusters in a CMEK instance must use the same key ([f127f1a](https://github.com/googleapis/java-bigtable/commit/f127f1a05647c8fb2c9becf07753c302957bd571))
* **sample:** remove unused native-image-support dependency ([#1237](https://github.com/googleapis/java-bigtable/issues/1237)) ([520670e](https://github.com/googleapis/java-bigtable/commit/520670ee1456f83368cc9843d594ad7af2117e76))
* Update `cpu_utilization_percent` limit ([f127f1a](https://github.com/googleapis/java-bigtable/commit/f127f1a05647c8fb2c9becf07753c302957bd571))


### Dependencies

* update dependency com.google.cloud:google-cloud-gcloud-maven-plugin to v0.1.5 ([#1249](https://github.com/googleapis/java-bigtable/issues/1249)) ([9fb02d6](https://github.com/googleapis/java-bigtable/commit/9fb02d6c3ab7d3d5d8b168418e47a65114b7deb1))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.11.0 ([#1253](https://github.com/googleapis/java-bigtable/issues/1253)) ([86a1e0e](https://github.com/googleapis/java-bigtable/commit/86a1e0e14b18101717143b0a01e4025a6540dbc2))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.12.0 ([#1256](https://github.com/googleapis/java-bigtable/issues/1256)) ([d4b05a4](https://github.com/googleapis/java-bigtable/commit/d4b05a4992dd016c389fc10c0ba509497e201d21))

### [2.6.2](https://github.com/googleapis/java-bigtable/compare/v2.6.1...v2.6.2) (2022-04-15)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.10.0 ([#1221](https://github.com/googleapis/java-bigtable/issues/1221)) ([acdaa33](https://github.com/googleapis/java-bigtable/commit/acdaa33dbfd91fdf892673ad164016a35e88d695))
* update dependency com.google.cloud:native-image-support to v0.13.1 ([#1222](https://github.com/googleapis/java-bigtable/issues/1222)) ([a14de82](https://github.com/googleapis/java-bigtable/commit/a14de8249d81f01355a87a8bc351bd6bc949c04b))

### [2.6.1](https://github.com/googleapis/java-bigtable/compare/v2.6.0...v2.6.1) (2022-03-29)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.9.0 ([#1212](https://github.com/googleapis/java-bigtable/issues/1212)) ([e38841c](https://github.com/googleapis/java-bigtable/commit/e38841c17c2a03e3b4dee73bd452c46c622736c1))
* update dependency com.google.cloud:native-image-support to v0.12.10 ([#1203](https://github.com/googleapis/java-bigtable/issues/1203)) ([a62a104](https://github.com/googleapis/java-bigtable/commit/a62a1048f0f2e9090405fc6311ca706762d1534e))
* update dependency com.google.cloud:native-image-support to v0.12.11 ([#1210](https://github.com/googleapis/java-bigtable/issues/1210)) ([2c5090c](https://github.com/googleapis/java-bigtable/commit/2c5090cf1ad19b966dc2819be2e724dc991149b9))
* update dependency com.google.cloud:native-image-support to v0.12.7 ([#1196](https://github.com/googleapis/java-bigtable/issues/1196)) ([476da07](https://github.com/googleapis/java-bigtable/commit/476da07ecead27c3f260b4e312bbb4eb035b4d3e))
* update dependency com.google.cloud:native-image-support to v0.12.8 ([#1201](https://github.com/googleapis/java-bigtable/issues/1201)) ([d9fd936](https://github.com/googleapis/java-bigtable/commit/d9fd936e97ca362c5868b6aeca2617c2688bc009))
* update dependency com.google.cloud:native-image-support to v0.12.9 ([#1202](https://github.com/googleapis/java-bigtable/issues/1202)) ([29c6005](https://github.com/googleapis/java-bigtable/commit/29c60059b7e231b014f0f8862d48dd0b071fbf8a))
* update dependency org.graalvm.buildtools:junit-platform-native to v0.9.11 ([#1207](https://github.com/googleapis/java-bigtable/issues/1207)) ([f2a01dc](https://github.com/googleapis/java-bigtable/commit/f2a01dc30c67ae6ae41e7f9733281ed182b6e836))
* update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.11 ([#1208](https://github.com/googleapis/java-bigtable/issues/1208)) ([9f93af3](https://github.com/googleapis/java-bigtable/commit/9f93af3eb1463427dc4cc57a860bf7a76ab3f2de))

## [2.6.0](https://github.com/googleapis/java-bigtable/compare/v2.5.3...v2.6.0) (2022-03-03)


### Features

* add WarmAndPing request for channel priming ([#1178](https://github.com/googleapis/java-bigtable/issues/1178)) ([385ab33](https://github.com/googleapis/java-bigtable/commit/385ab33d12479a9d2b1b66babef9b9b5846b902a))


### Documentation

* **sample:** Add sample for native image support in Bigtable ([#1165](https://github.com/googleapis/java-bigtable/issues/1165)) ([143aaee](https://github.com/googleapis/java-bigtable/commit/143aaee42e1b59d125250982dbeb34a31d906e30))


### Dependencies

* update actions/github-script action to v6 ([#1170](https://github.com/googleapis/java-bigtable/issues/1170)) ([5790bdf](https://github.com/googleapis/java-bigtable/commit/5790bdf875d27e6194f1753ff66d208f65488716))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.8.0 ([#1186](https://github.com/googleapis/java-bigtable/issues/1186)) ([74cafca](https://github.com/googleapis/java-bigtable/commit/74cafcae4a562b87f1664b8844794a2e68c97625))
* update dependency com.google.cloud:native-image-support to v0.12.4 ([#1175](https://github.com/googleapis/java-bigtable/issues/1175)) ([9cc6fbc](https://github.com/googleapis/java-bigtable/commit/9cc6fbc7de22303e17492824971fcc52fb041254))
* update dependency com.google.cloud:native-image-support to v0.12.5 ([#1183](https://github.com/googleapis/java-bigtable/issues/1183)) ([b025b34](https://github.com/googleapis/java-bigtable/commit/b025b343af0b9309558f530dc0765bf2b4c4d588))
* update dependency com.google.cloud:native-image-support to v0.12.6 ([#1187](https://github.com/googleapis/java-bigtable/issues/1187)) ([b110d65](https://github.com/googleapis/java-bigtable/commit/b110d650edd38a1866f6c2168c78ec8e31b528c2))
* update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.10 ([#1174](https://github.com/googleapis/java-bigtable/issues/1174)) ([7ff5fa7](https://github.com/googleapis/java-bigtable/commit/7ff5fa712b6dcbbd3c721c8babb8ed4e1c7dad17))

### [2.5.3](https://github.com/googleapis/java-bigtable/compare/v2.5.2...v2.5.3) (2022-02-08)


### Bug Fixes

* integration tests ([#1161](https://github.com/googleapis/java-bigtable/issues/1161)) ([8b00b5f](https://github.com/googleapis/java-bigtable/commit/8b00b5fb5b4e3a1ada514b0bdc60fd744833bd01))

### [2.5.2](https://github.com/googleapis/java-bigtable/compare/v2.5.1...v2.5.2) (2022-01-31)


### Bug Fixes

* UpdateAppProfileRequest equals and hashcode should build proto ([#1142](https://github.com/googleapis/java-bigtable/issues/1142)) ([c9f1ed8](https://github.com/googleapis/java-bigtable/commit/c9f1ed8a5fdf44487a8c56388b35067ecfc4daea))


### Dependencies

* **java:** update actions/github-script action to v5 ([#1339](https://github.com/googleapis/java-bigtable/issues/1339)) ([#1147](https://github.com/googleapis/java-bigtable/issues/1147)) ([9bfcccf](https://github.com/googleapis/java-bigtable/commit/9bfcccfd76d2a03412cf9fe8c115874f15a95c57))
* update actions/github-script action to v5 ([#1146](https://github.com/googleapis/java-bigtable/issues/1146)) ([9b2c918](https://github.com/googleapis/java-bigtable/commit/9b2c918c3fad38d3b26d141b53f6dc037a23bed7))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.7.0 ([#1150](https://github.com/googleapis/java-bigtable/issues/1150)) ([744e483](https://github.com/googleapis/java-bigtable/commit/744e4830238b6ebe7bab6115ff26600b0c150b62))

### [2.5.1](https://www.github.com/googleapis/java-bigtable/compare/v2.5.0...v2.5.1) (2022-01-07)


### Bug Fixes

* Revert "fix: remove stats from javadoc" ([#1118](https://www.github.com/googleapis/java-bigtable/issues/1118)) ([ba8f344](https://www.github.com/googleapis/java-bigtable/commit/ba8f344d19163627553a0a268742af2a1a792db5))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.6.0 ([#1124](https://www.github.com/googleapis/java-bigtable/issues/1124)) ([55ebf69](https://www.github.com/googleapis/java-bigtable/commit/55ebf6932bbe93e8b7635a7550320099eb4fbe93))

## [2.5.0](https://www.github.com/googleapis/java-bigtable/compare/v2.4.0...v2.5.0) (2022-01-05)


### Features

* add batch throttled ms metric ([#888](https://www.github.com/googleapis/java-bigtable/issues/888)) ([0d197a5](https://www.github.com/googleapis/java-bigtable/commit/0d197a5ab9b7ccd20091c1c6c4a794586d6a51dc))
* ARM support for gcloud bigtable emulator ([#1094](https://www.github.com/googleapis/java-bigtable/issues/1094)) ([d3cb4a4](https://www.github.com/googleapis/java-bigtable/commit/d3cb4a4e03ae0f7e065bfee06ac8e3b86b447a4a))


### Bug Fixes

* align ip version preference for the wrapped  emulator ([#1052](https://www.github.com/googleapis/java-bigtable/issues/1052)) ([9dc93c5](https://www.github.com/googleapis/java-bigtable/commit/9dc93c5c9372f1501006e2d3a3a7affecd65fb8e))
* remove stats from javadoc ([#1108](https://www.github.com/googleapis/java-bigtable/issues/1108)) ([33fe7fe](https://www.github.com/googleapis/java-bigtable/commit/33fe7fe162cf84339e1887b052e446ef0aaf19d6))
* remove tracking latency from channel priming requests ([#1082](https://www.github.com/googleapis/java-bigtable/issues/1082)) ([bd873bc](https://www.github.com/googleapis/java-bigtable/commit/bd873bc82f0b210312fd442678c801758291935e))

## [2.4.0](https://www.github.com/googleapis/java-bigtable/compare/v2.3.1...v2.4.0) (2021-12-07)


### Features

* cluster autoscaling ([#1092](https://www.github.com/googleapis/java-bigtable/issues/1092)) ([fa4fe14](https://www.github.com/googleapis/java-bigtable/commit/fa4fe149a6a59600afe75f805f2503d3b45e5032))

### [2.3.1](https://www.github.com/googleapis/java-bigtable/compare/v2.3.0...v2.3.1) (2021-12-03)


### Bug Fixes

* add placeholder class for bigtable-stats ([#1075](https://www.github.com/googleapis/java-bigtable/issues/1075)) ([9d9f575](https://www.github.com/googleapis/java-bigtable/commit/9d9f57556216becfeb302bfaf5a4f35a9b73b611))
* add status label to gfe metrics ([#1077](https://www.github.com/googleapis/java-bigtable/issues/1077)) ([777549e](https://www.github.com/googleapis/java-bigtable/commit/777549e6ac64a03c9bd67d6b5a5cf4819ba8656f))
* make placeholder class public ([#1085](https://www.github.com/googleapis/java-bigtable/issues/1085)) ([879377a](https://www.github.com/googleapis/java-bigtable/commit/879377a03b86aa9a1f1035245c290ec78501b2cd))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.5.1 ([#1087](https://www.github.com/googleapis/java-bigtable/issues/1087)) ([f290ce7](https://www.github.com/googleapis/java-bigtable/commit/f290ce74f6b803b8c5786e8b4c69b9efa6995c59))

## [2.3.0](https://www.github.com/googleapis/java-bigtable/compare/v2.2.0...v2.3.0) (2021-11-16)


### Features

* configure branch 2.2.x as a release branch ([#1044](https://www.github.com/googleapis/java-bigtable/issues/1044)) ([68e8790](https://www.github.com/googleapis/java-bigtable/commit/68e8790f61b90ce2b5e7479b3d23e2f964199d3e))
* send attempt and timestamp in headers ([#935](https://www.github.com/googleapis/java-bigtable/issues/935)) ([de3b476](https://www.github.com/googleapis/java-bigtable/commit/de3b476d4acd644d1e5bc782dc697ce5b145992e))


### Bug Fixes

* **java:** java 17 dependency arguments ([#1046](https://www.github.com/googleapis/java-bigtable/issues/1046)) ([422efa0](https://www.github.com/googleapis/java-bigtable/commit/422efa0289b232118b446224c5e084fe3bc19491))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.5.0 ([#1064](https://www.github.com/googleapis/java-bigtable/issues/1064)) ([5b72aa9](https://www.github.com/googleapis/java-bigtable/commit/5b72aa96bab018f4b5b1b565a6487dbb45ccd323))

## [2.2.0](https://www.github.com/googleapis/java-bigtable/compare/v2.1.4...v2.2.0) (2021-10-20)


### Features

* app profile multi cluster routing support with specified cluster ids ([#961](https://www.github.com/googleapis/java-bigtable/issues/961)) ([f4c5c32](https://www.github.com/googleapis/java-bigtable/commit/f4c5c32c05d244a9ce7c3a4386ba9396c65f227e))


### Bug Fixes

* fix typo in rst stream message ([#1029](https://www.github.com/googleapis/java-bigtable/issues/1029)) ([50e6860](https://www.github.com/googleapis/java-bigtable/commit/50e686094c316560864c30a0295b3ed3f655c765))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.4.0 ([#1038](https://www.github.com/googleapis/java-bigtable/issues/1038)) ([d3efb29](https://www.github.com/googleapis/java-bigtable/commit/d3efb29df8461caddd3917fc42afa50961723a7d))

### [2.1.4](https://www.github.com/googleapis/java-bigtable/compare/v2.1.3...v2.1.4) (2021-09-22)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.3.0 ([#1020](https://www.github.com/googleapis/java-bigtable/issues/1020)) ([272f044](https://www.github.com/googleapis/java-bigtable/commit/272f0443501c502abf1b061414fb2435a9ad7952))

### [2.1.3](https://www.github.com/googleapis/java-bigtable/compare/v2.1.2...v2.1.3) (2021-09-21)


### Dependencies

* migrate to mockito-core 3.12.4 ([#1008](https://www.github.com/googleapis/java-bigtable/issues/1008)) ([d9f19db](https://www.github.com/googleapis/java-bigtable/commit/d9f19db82f82615e4476462f9c34da7841169838))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.2.1 ([#1010](https://www.github.com/googleapis/java-bigtable/issues/1010)) ([a54a021](https://www.github.com/googleapis/java-bigtable/commit/a54a02135f30e3337812938f5794b293ee6535c6))

### [2.1.2](https://www.github.com/googleapis/java-bigtable/compare/v2.1.1...v2.1.2) (2021-09-13)


### Bug Fixes

* parallel execution and verbose grpc logs ([#1004](https://www.github.com/googleapis/java-bigtable/issues/1004)) ([dd5164d](https://www.github.com/googleapis/java-bigtable/commit/dd5164dc9de7f060bb0dab79820cb43ac434d703))


### Reverts

* temporary workaround for maven wildcard excludes ([#989](https://www.github.com/googleapis/java-bigtable/issues/989)) ([148a928](https://www.github.com/googleapis/java-bigtable/commit/148a928e3f8f6d1e2ee1d1b119ca820d676802fd))

### [2.1.1](https://www.github.com/googleapis/java-bigtable/compare/v2.1.0...v2.1.1) (2021-09-01)


### Dependencies

* update dependency com.google.cloud:google-cloud-conformance-tests to v0.2.0 ([#971](https://www.github.com/googleapis/java-bigtable/issues/971)) ([5c614d5](https://www.github.com/googleapis/java-bigtable/commit/5c614d58dd527a7fd36d32f201138a35e95a0577))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.2.0 ([#975](https://www.github.com/googleapis/java-bigtable/issues/975)) ([e5bb52e](https://www.github.com/googleapis/java-bigtable/commit/e5bb52eead42e8b351a7469529837d8b509b8332))

## [2.1.0](https://www.github.com/googleapis/java-bigtable/compare/v2.0.1...v2.1.0) (2021-08-25)


### Features

* publish new fields to support cluster group routing ([#958](https://www.github.com/googleapis/java-bigtable/issues/958)) ([09b31bd](https://www.github.com/googleapis/java-bigtable/commit/09b31bd9032dc36071cb8d32fc5cb6d4d85878e1))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.1.0 ([#962](https://www.github.com/googleapis/java-bigtable/issues/962)) ([a013e77](https://www.github.com/googleapis/java-bigtable/commit/a013e777af0fb2945099c178832fccd14b33398f))

### [2.0.1](https://www.github.com/googleapis/java-bigtable/compare/v2.0.0...v2.0.1) (2021-08-11)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.0.1 ([#948](https://www.github.com/googleapis/java-bigtable/issues/948)) ([31a7cb6](https://www.github.com/googleapis/java-bigtable/commit/31a7cb60321429497ca29f02119e7a2c1b0d614f))

## [2.0.0](https://www.github.com/googleapis/java-bigtable/compare/v1.27.3...v2.0.0) (2021-08-09)


### ⚠ BREAKING CHANGES

* release gapic-generator-java v2.0.0 (#938)
* update java compile to 1.8 (update google-cloud-shared-config … (#939)

### Features

* gapic-generator-java v1.0.12, mtls support ([#871](https://www.github.com/googleapis/java-bigtable/issues/871)) ([3ec05d4](https://www.github.com/googleapis/java-bigtable/commit/3ec05d4dff8ee3799dd799ecf659610de031564a))
* release gapic-generator-java v2.0.0 ([#938](https://www.github.com/googleapis/java-bigtable/issues/938)) ([d2456e4](https://www.github.com/googleapis/java-bigtable/commit/d2456e4b014f714c87ff5ad414b5fabd0631e912))
* update java compile to 1.8 (update google-cloud-shared-config … ([#939](https://www.github.com/googleapis/java-bigtable/issues/939)) ([57cddee](https://www.github.com/googleapis/java-bigtable/commit/57cddee445dec91a8bb96127ee7db947a1e13a7d))


### Dependencies

* fix UpperBoundsDep check for checker-qual ([#941](https://www.github.com/googleapis/java-bigtable/issues/941)) ([1d7c224](https://www.github.com/googleapis/java-bigtable/commit/1d7c224bd46f8ab576645e5d722ac595ab875406))

### [1.27.3](https://www.github.com/googleapis/java-bigtable/compare/v1.27.2...v1.27.3) (2021-07-19)


### Bug Fixes

* client.close() should wait until the channels are terminated before shutting down the executor ([#916](https://www.github.com/googleapis/java-bigtable/issues/916)) ([914f0cc](https://www.github.com/googleapis/java-bigtable/commit/914f0cc4a928974e14b2ab49b848f757862ad140))

### [1.27.2](https://www.github.com/googleapis/java-bigtable/compare/v1.27.1...v1.27.2) (2021-07-01)


### Bug Fixes

* jwt authentication on batch-bigtable.googleapis.com ([#892](https://www.github.com/googleapis/java-bigtable/issues/892)) ([d2ca9c6](https://www.github.com/googleapis/java-bigtable/commit/d2ca9c62f3fcb9c79c97ef8a73bad3a0e7555afc))

### [1.27.1](https://www.github.com/googleapis/java-bigtable/compare/v1.27.0...v1.27.1) (2021-06-30)


### Bug Fixes

* Add `shopt -s nullglob` to dependencies script ([#884](https://www.github.com/googleapis/java-bigtable/issues/884)) ([8b971a2](https://www.github.com/googleapis/java-bigtable/commit/8b971a2510685be336b0dd19fc048905b56906e3))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.4.0 ([#889](https://www.github.com/googleapis/java-bigtable/issues/889)) ([8b6754f](https://www.github.com/googleapis/java-bigtable/commit/8b6754fb1fbdca43a327e3f253be076eb0c2cd2f))

## [1.27.0](https://www.github.com/googleapis/java-bigtable/compare/v1.26.1...v1.27.0) (2021-06-22)


### Features

* all setting timeouts for batchers + fix handling of timeouts for point reads ([#861](https://www.github.com/googleapis/java-bigtable/issues/861)) ([c145ceb](https://www.github.com/googleapis/java-bigtable/commit/c145ceb592f04f94a09be815feff87e0c64e8e7d))
* call setting timeouts for batchers ([#877](https://www.github.com/googleapis/java-bigtable/issues/877)) ([0f3654d](https://www.github.com/googleapis/java-bigtable/commit/0f3654d726dbb45b4a12ef98f872612e49b9a263))


### Bug Fixes

* Update dependencies.sh to not break on mac ([#873](https://www.github.com/googleapis/java-bigtable/issues/873)) ([9e6b85d](https://www.github.com/googleapis/java-bigtable/commit/9e6b85deffff15961d12eb8b656210b5e12d8162))


### Reverts

* Revert "feat: promote stream wait timeouts to deadlines for point reads" ([#876](https://www.github.com/googleapis/java-bigtable/issues/876)) ([4614912](https://www.github.com/googleapis/java-bigtable/commit/4614912b6ea76c9057b1a4cbf869eb3145bce18f))


### Documentation

* fix connection pool size for samples ([#880](https://www.github.com/googleapis/java-bigtable/issues/880)) ([d0d1aa3](https://www.github.com/googleapis/java-bigtable/commit/d0d1aa3195c0d63242254eece3e92e9ad078069b))

### [1.26.1](https://www.github.com/googleapis/java-bigtable/compare/v1.26.0...v1.26.1) (2021-06-07)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.3.0 ([#857](https://www.github.com/googleapis/java-bigtable/issues/857)) ([fd2bf65](https://www.github.com/googleapis/java-bigtable/commit/fd2bf656629e21e01e9a877c00eaed018889cc37))
* update truth-proto-extension to 1.1.3 and exclude protobuf-java from its dependencies ([#854](https://www.github.com/googleapis/java-bigtable/issues/854)) ([e7773ee](https://www.github.com/googleapis/java-bigtable/commit/e7773eed9f34ab4d104df5c09aefb5a302ab4186))

## [1.26.0](https://www.github.com/googleapis/java-bigtable/compare/v1.25.0...v1.26.0) (2021-06-03)


### Features

* promote stream wait timeouts to deadlines for point reads ([#848](https://www.github.com/googleapis/java-bigtable/issues/848)) ([9b3c601](https://www.github.com/googleapis/java-bigtable/commit/9b3c6013fef396fcc923e53c13f73a03a48c9c02))


### Bug Fixes

* add back in extraFiles and fix file path ([#833](https://www.github.com/googleapis/java-bigtable/issues/833)) ([f914954](https://www.github.com/googleapis/java-bigtable/commit/f91495474cb34e1f178d9362ab0251d364079f6d))
* exclude protobuf from conformance-tests ([#845](https://www.github.com/googleapis/java-bigtable/issues/845)) ([1d89191](https://www.github.com/googleapis/java-bigtable/commit/1d89191a2453b5565aafe72367329eddb36ea90a))
* Fix the race condition in decay average ([#850](https://www.github.com/googleapis/java-bigtable/issues/850)) ([66a9c9e](https://www.github.com/googleapis/java-bigtable/commit/66a9c9ebc520dd20c336a5cf4040912138137be6))
* revert conformance test version ([#846](https://www.github.com/googleapis/java-bigtable/issues/846)) ([b23b0d7](https://www.github.com/googleapis/java-bigtable/commit/b23b0d7a7d8a2b9bed1cdabce420cb6568cf82ef))


### Dependencies

* update dependency com.google.cloud:google-cloud-conformance-tests to v0.1.1 ([#852](https://www.github.com/googleapis/java-bigtable/issues/852)) ([e1c951c](https://www.github.com/googleapis/java-bigtable/commit/e1c951c549bf455cdd6e997756d9464a1e06dad2))

## [1.25.0](https://www.github.com/googleapis/java-bigtable/compare/v1.24.1...v1.25.0) (2021-05-19)


### Features

* add `gcf-owl-bot[bot]` to `ignoreAuthors` ([#815](https://www.github.com/googleapis/java-bigtable/issues/815)) ([ea558b0](https://www.github.com/googleapis/java-bigtable/commit/ea558b05b369c6131f94e471e5652866a037b948))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.2.0 ([#814](https://www.github.com/googleapis/java-bigtable/issues/814)) ([1299d72](https://www.github.com/googleapis/java-bigtable/commit/1299d727066e0aa24319b99d438503ea0cf60d86))

### [1.24.1](https://www.github.com/googleapis/java-bigtable/compare/v1.24.0...v1.24.1) (2021-05-11)


### Bug Fixes

* filter limit constant ([#787](https://www.github.com/googleapis/java-bigtable/issues/787)) ([04f8ad4](https://www.github.com/googleapis/java-bigtable/commit/04f8ad463d1fa9efe0ab941ee5f3d0794baed814))
* fix flaky test ([#798](https://www.github.com/googleapis/java-bigtable/issues/798)) ([83e0e8c](https://www.github.com/googleapis/java-bigtable/commit/83e0e8cf2cdbc143c10ce0f8b053096d61d5686f))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.1.0 ([#805](https://www.github.com/googleapis/java-bigtable/issues/805)) ([a498687](https://www.github.com/googleapis/java-bigtable/commit/a498687d15dd9af35c57b0df6d08c87ef36833da))


### Documentation

* update the comments in Cloud Bigtable RestoreTable API to reflect the new API capability ([#804](https://www.github.com/googleapis/java-bigtable/issues/804)) ([f5e5d5a](https://www.github.com/googleapis/java-bigtable/commit/f5e5d5ac196529d5b070ef5fd8118038fec2e2de))

## [1.24.0](https://www.github.com/googleapis/java-bigtable/compare/v1.23.2...v1.24.0) (2021-04-30)


### Features

* allow restore backup to different instance ([#515](https://www.github.com/googleapis/java-bigtable/issues/515)) ([8a5e60e](https://www.github.com/googleapis/java-bigtable/commit/8a5e60e8ed116d36810cc4059539228768726912)), closes [#789](https://www.github.com/googleapis/java-bigtable/issues/789)

### [1.23.2](https://www.github.com/googleapis/java-bigtable/compare/v1.23.1...v1.23.2) (2021-04-23)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1 ([#781](https://www.github.com/googleapis/java-bigtable/issues/781)) ([dbf856f](https://www.github.com/googleapis/java-bigtable/commit/dbf856f93942cbec48433821da8e5a96e61a9d7e))

### [1.23.1](https://www.github.com/googleapis/java-bigtable/compare/v1.23.0...v1.23.1) (2021-04-20)


### Bug Fixes

* **docs:** correct docs for CUSTOMER_MANAGED_ENCRYPTION ([#737](https://www.github.com/googleapis/java-bigtable/issues/737)) ([b3bb7f7](https://www.github.com/googleapis/java-bigtable/commit/b3bb7f77610e48e849766a6e9dbacb98fc3f9811))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.21.1 ([#741](https://www.github.com/googleapis/java-bigtable/issues/741)) ([cfdd0cd](https://www.github.com/googleapis/java-bigtable/commit/cfdd0cd760f9273e644cddc492d9c4d5327498e7))

## [1.23.0](https://www.github.com/googleapis/java-bigtable/compare/v1.22.0...v1.23.0) (2021-04-13)


### Features

* dynamic flow control ([#721](https://www.github.com/googleapis/java-bigtable/issues/721)) ([b61c5ce](https://www.github.com/googleapis/java-bigtable/commit/b61c5ce5de9cbe2a93a4ea95bad03585069b85bb))


### Bug Fixes

* change clusterId in Cmek test ([#716](https://www.github.com/googleapis/java-bigtable/issues/716)) ([67ef155](https://www.github.com/googleapis/java-bigtable/commit/67ef15591d49d51728c769eb54a1167b15524aa1))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.21.0 ([#717](https://www.github.com/googleapis/java-bigtable/issues/717)) ([dfc2efd](https://www.github.com/googleapis/java-bigtable/commit/dfc2efda536bb5db209b7c50114b417edd7af5cd))

## [1.22.0](https://www.github.com/googleapis/java-bigtable/compare/v1.21.3...v1.22.0) (2021-04-06)


### Features

* add CMEK Support  ([#656](https://www.github.com/googleapis/java-bigtable/issues/656)) ([2821902](https://www.github.com/googleapis/java-bigtable/commit/2821902b34ae04596771a9fc5e2b62d5c24a7253))


### Dependencies

* update autovalue.version to v1.8 ([#703](https://www.github.com/googleapis/java-bigtable/issues/703)) ([13e7796](https://www.github.com/googleapis/java-bigtable/commit/13e7796d96222fe0181771d160d12a3da7f0a7a7))
* update dependency com.google.truth.extensions:truth-proto-extension to v1.1.2 ([#704](https://www.github.com/googleapis/java-bigtable/issues/704)) ([3fa8b00](https://www.github.com/googleapis/java-bigtable/commit/3fa8b0069d58a5705f11fac481ddcd4ad7d447f4))

### [1.21.3](https://www.github.com/googleapis/java-bigtable/compare/v1.21.2...v1.21.3) (2021-04-01)


### Dependencies

* update dependency com.google.errorprone:error_prone_annotations to v2.6.0 ([#693](https://www.github.com/googleapis/java-bigtable/issues/693)) ([831d044](https://www.github.com/googleapis/java-bigtable/commit/831d044f31c7643b34df4f23765d521e8f68035d))

### [1.21.2](https://www.github.com/googleapis/java-bigtable/compare/v1.21.1...v1.21.2) (2021-03-22)


### Dependencies

* update autovalue.version to v1.7.5 ([#684](https://www.github.com/googleapis/java-bigtable/issues/684)) ([75baa79](https://www.github.com/googleapis/java-bigtable/commit/75baa79e94c31e1694c3e29ea2f1ed42dbc60eb8))

### [1.21.1](https://www.github.com/googleapis/java-bigtable/compare/v1.21.0...v1.21.1) (2021-03-15)


### Bug Fixes

* **retry:** restore grpc_service_config for CreateBackup and {Restore,Snapshot}Table ([#667](https://www.github.com/googleapis/java-bigtable/issues/667)) ([121f071](https://www.github.com/googleapis/java-bigtable/commit/121f07159c2715368cb53753ba39d70d1d25efb8))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.20.1 ([#671](https://www.github.com/googleapis/java-bigtable/issues/671)) ([6ba3bf3](https://www.github.com/googleapis/java-bigtable/commit/6ba3bf3a642bd5b7ecf2a86a821ede0f2bae084f))

## [1.21.0](https://www.github.com/googleapis/java-bigtable/compare/v1.20.1...v1.21.0) (2021-03-02)


### Features

* **generator:** update protoc to v3.15.3 ([#654](https://www.github.com/googleapis/java-bigtable/issues/654)) ([4b0c59a](https://www.github.com/googleapis/java-bigtable/commit/4b0c59a17d668e724fb79369ad7a6f7fbbb31d89))
* migrate to java microgenerator ([#629](https://www.github.com/googleapis/java-bigtable/issues/629)) ([60d17dc](https://www.github.com/googleapis/java-bigtable/commit/60d17dc1d0a0a568a8bdd3bcc1e7491c17142af3))
* publish new fields for CMEK support ([#646](https://www.github.com/googleapis/java-bigtable/issues/646)) ([e039386](https://www.github.com/googleapis/java-bigtable/commit/e039386898b82f7b03f5a4064c5dcca0fdd3f330))


### Dependencies

* update dependency com.google.cloud:google-cloud-gcloud-maven-plugin to v0.1.2 ([#652](https://www.github.com/googleapis/java-bigtable/issues/652)) ([71a8fd7](https://www.github.com/googleapis/java-bigtable/commit/71a8fd7fe55bd40ad32963ffdfc06999be2ff7fc))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.20.0 ([#653](https://www.github.com/googleapis/java-bigtable/issues/653)) ([c5049c1](https://www.github.com/googleapis/java-bigtable/commit/c5049c1f988e0f4465d9d805fd092087bfa69fdc))

### [1.20.1](https://www.github.com/googleapis/java-bigtable/compare/v1.20.0...v1.20.1) (2021-02-22)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.19.0 ([#640](https://www.github.com/googleapis/java-bigtable/issues/640)) ([bf1f49f](https://www.github.com/googleapis/java-bigtable/commit/bf1f49fbff344510501b9b836771d9cfab4defcd))

## [1.20.0](https://www.github.com/googleapis/java-bigtable/compare/v1.19.2...v1.20.0) (2021-02-05)


### Features

* Surface the server-timing metric ([#535](https://www.github.com/googleapis/java-bigtable/issues/535)) ([8240779](https://www.github.com/googleapis/java-bigtable/commit/8240779434a602dc8b2bf90dbe539c5d7470d850))


### Bug Fixes

* fix MetricTracerTest to rebase on head ([#581](https://www.github.com/googleapis/java-bigtable/issues/581)) ([23e97cb](https://www.github.com/googleapis/java-bigtable/commit/23e97cb308403b35fbe972b08048d0e59423e694))
* fix MutateRowsAttemptCallable to avoid NPE in MetricTracer ([#557](https://www.github.com/googleapis/java-bigtable/issues/557)) ([8d71020](https://www.github.com/googleapis/java-bigtable/commit/8d7102003b54757b64fd598290301d3b24fd9c29))
* Retry "received rst stream" ([#586](https://www.github.com/googleapis/java-bigtable/issues/586)) ([b09a21c](https://www.github.com/googleapis/java-bigtable/commit/b09a21c1dd1a05b68bfd3a0134089ba32dca1774))
* update repo name ([#615](https://www.github.com/googleapis/java-bigtable/issues/615)) ([bb3ed6d](https://www.github.com/googleapis/java-bigtable/commit/bb3ed6dcbadbd70dbd9c68152c8d93c4cefd4dcb))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.17.1 ([#590](https://www.github.com/googleapis/java-bigtable/issues/590)) ([5035ad0](https://www.github.com/googleapis/java-bigtable/commit/5035ad0db01a9247634137050698c30da29722a6))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.18.0 ([#592](https://www.github.com/googleapis/java-bigtable/issues/592)) ([c58b73a](https://www.github.com/googleapis/java-bigtable/commit/c58b73a7d70c8da1581ac06d77b5e362648a0868))
* update dependency com.google.errorprone:error_prone_annotations to v2.5.0 ([#591](https://www.github.com/googleapis/java-bigtable/issues/591)) ([dfa4da7](https://www.github.com/googleapis/java-bigtable/commit/dfa4da75e5ac81cc941177462326f7c38f18bacd))
* update dependency com.google.errorprone:error_prone_annotations to v2.5.1 ([#594](https://www.github.com/googleapis/java-bigtable/issues/594)) ([ea599a1](https://www.github.com/googleapis/java-bigtable/commit/ea599a10e2e4fdbaf56c45b74fbb1ea5a708a7f2))


### Documentation

* Expand hello world snippet to show how to access specific cells ([#516](https://www.github.com/googleapis/java-bigtable/issues/516)) ([a9001a8](https://www.github.com/googleapis/java-bigtable/commit/a9001a88f338fc2acf6bc48927765f29819124ee))
* Update stackdriver examples for tracing and stats ([#613](https://www.github.com/googleapis/java-bigtable/issues/613)) ([3e8af74](https://www.github.com/googleapis/java-bigtable/commit/3e8af747b329f6656a410160e8da14fd8227c8fc))
* use autogenerated readme functionality and regenerate ([#568](https://www.github.com/googleapis/java-bigtable/issues/568)) ([844e5be](https://www.github.com/googleapis/java-bigtable/commit/844e5beb6230df6ca220935056aae7f6e73d2bc0))

### [1.19.2](https://www.github.com/googleapis/java-bigtable/compare/v1.19.1...v1.19.2) (2020-12-15)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.17.0 ([#566](https://www.github.com/googleapis/java-bigtable/issues/566)) ([7c8e32b](https://www.github.com/googleapis/java-bigtable/commit/7c8e32b33c701cdf701384ad60986bc96ec4684a))

### [1.19.1](https://www.github.com/googleapis/java-bigtable/compare/v1.19.0...v1.19.1) (2020-12-14)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.16.1 ([1c4ceda](https://www.github.com/googleapis/java-bigtable/commit/1c4ceda740157569fb95f7eeb9ddc0cf780cd038))

## [1.19.0](https://www.github.com/googleapis/java-bigtable/compare/v1.18.1...v1.19.0) (2020-12-03)


### Features

* attempt DirectPath by default ([#544](https://www.github.com/googleapis/java-bigtable/issues/544)) ([2043063](https://www.github.com/googleapis/java-bigtable/commit/20430636f10445e32834f44b902dd506b0bdadf8))

### [1.18.1](https://www.github.com/googleapis/java-bigtable/compare/v1.18.0...v1.18.1) (2020-12-02)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.16.0 ([#546](https://www.github.com/googleapis/java-bigtable/issues/546)) ([070bda2](https://www.github.com/googleapis/java-bigtable/commit/070bda21b9ec93bb187626eeb46e7212951a9ebf))

## [1.18.0](https://www.github.com/googleapis/java-bigtable/compare/v1.17.3...v1.18.0) (2020-11-13)


### Features

* **autogenerated:** Update BigtableTableAdmin GetIamPolicy to include the additional binding for Backup, Change DeleteAppProfileRequest.ignore_warnings to REQUIRED. ([#530](https://www.github.com/googleapis/java-bigtable/issues/530)) ([8c16fa4](https://www.github.com/googleapis/java-bigtable/commit/8c16fa4c5290f67c43392953095bd759c2505bdb))


### Bug Fixes

* make keepalive params a bit conservative ([#528](https://www.github.com/googleapis/java-bigtable/issues/528)) ([f5f66c9](https://www.github.com/googleapis/java-bigtable/commit/f5f66c9ce019a6a24ddfe1efc0141835f5a02f34))

### [1.17.3](https://www.github.com/googleapis/java-bigtable/compare/v1.17.2...v1.17.3) (2020-11-11)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.15.0 ([#521](https://www.github.com/googleapis/java-bigtable/issues/521)) ([ed300d0](https://www.github.com/googleapis/java-bigtable/commit/ed300d09c6fffb012981789256f13c4893ce02b1))

### [1.17.2](https://www.github.com/googleapis/java-bigtable/compare/v1.17.1...v1.17.2) (2020-11-10)


### Bug Fixes

* readRowSettings use manual readRows settings instead of gapics ([#494](https://www.github.com/googleapis/java-bigtable/issues/494)) ([0ef7c5d](https://www.github.com/googleapis/java-bigtable/commit/0ef7c5d4aacacd2030a52efc148ead457719a927))


### Reverts

* Revert "feat: attemp DirectPath by default (#467)" (#520) ([b33b0fc](https://www.github.com/googleapis/java-bigtable/commit/b33b0fc1b5478934298db317c1168c1e9dc20599)), closes [#467](https://www.github.com/googleapis/java-bigtable/issues/467) [#520](https://www.github.com/googleapis/java-bigtable/issues/520)

### [1.17.1](https://www.github.com/googleapis/java-bigtable/compare/v1.17.0...v1.17.1) (2020-10-31)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.14.1 ([#505](https://www.github.com/googleapis/java-bigtable/issues/505)) ([ab6284d](https://www.github.com/googleapis/java-bigtable/commit/ab6284d16f24f8197d90c43f1e37416c53287b4c))

## [1.17.0](https://www.github.com/googleapis/java-bigtable/compare/v1.16.2...v1.17.0) (2020-10-23)


### Features

* attemp DirectPath by default ([#467](https://www.github.com/googleapis/java-bigtable/issues/467)) ([89c622d](https://www.github.com/googleapis/java-bigtable/commit/89c622da6038067892687af3edafae743465eda7))
* backup level IAM ([#450](https://www.github.com/googleapis/java-bigtable/issues/450)) ([f38a8ec](https://www.github.com/googleapis/java-bigtable/commit/f38a8ecdc6164d081ef96f748ea37bd62b29b419))
* Implement toString for Bigtable*Settings ([#488](https://www.github.com/googleapis/java-bigtable/issues/488)) ([4d821f8](https://www.github.com/googleapis/java-bigtable/commit/4d821f85ceb237c8e449243ff8c80fb94e22ad51))


### Bug Fixes

* Make refreshing channel compatible with BigtableDataClientFactory ([#474](https://www.github.com/googleapis/java-bigtable/issues/474)) ([fc74164](https://www.github.com/googleapis/java-bigtable/commit/fc741645536e01fac772136bc8346f73ff95e600))


### Documentation

* fix formatting ([#476](https://www.github.com/googleapis/java-bigtable/issues/476)) ([eb24569](https://www.github.com/googleapis/java-bigtable/commit/eb24569e53f9d2b7fde50748c840c2c11f3f3c80))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.12.1 ([#475](https://www.github.com/googleapis/java-bigtable/issues/475)) ([9e56edf](https://www.github.com/googleapis/java-bigtable/commit/9e56edfa7b0a78f14518a99130a7b319c5873be4))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.13.0 ([#484](https://www.github.com/googleapis/java-bigtable/issues/484)) ([aad648f](https://www.github.com/googleapis/java-bigtable/commit/aad648fec16b122092d394350822da742a2d7aa0))
* update dependency com.google.truth:truth to v1.1 ([#483](https://www.github.com/googleapis/java-bigtable/issues/483)) ([cca1e0e](https://www.github.com/googleapis/java-bigtable/commit/cca1e0e16f2ec0cc887d81c1844f5395ce08b6ea))

### [1.16.2](https://www.github.com/googleapis/java-bigtable/compare/v1.16.1...v1.16.2) (2020-10-14)


### Dependencies

* update dependency com.google.cloud:google-cloud-conformance-tests to v0.0.13 ([#459](https://www.github.com/googleapis/java-bigtable/issues/459)) ([a7824ea](https://www.github.com/googleapis/java-bigtable/commit/a7824ea99abe2ea0f1336662db5addd60632598a))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.11.0 ([#460](https://www.github.com/googleapis/java-bigtable/issues/460)) ([d2d806c](https://www.github.com/googleapis/java-bigtable/commit/d2d806c615f819bbaf575bfadcce26b2473bb77d))

### [1.16.1](https://www.github.com/googleapis/java-bigtable/compare/v1.16.0...v1.16.1) (2020-10-08)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.10.2 ([#452](https://www.github.com/googleapis/java-bigtable/issues/452)) ([c211c1c](https://www.github.com/googleapis/java-bigtable/commit/c211c1c988cc4805d3fe68853836ec3acb495578))

## [1.16.0](https://www.github.com/googleapis/java-bigtable/compare/v1.15.0...v1.16.0) (2020-10-06)


### Features

* add keepalive changes in java client library ([#409](https://www.github.com/googleapis/java-bigtable/issues/409)) ([edbcde1](https://www.github.com/googleapis/java-bigtable/commit/edbcde1a5b22317319803cb57401252aac6d580d))
* include User agent ([#404](https://www.github.com/googleapis/java-bigtable/issues/404)) ([0cd71b5](https://www.github.com/googleapis/java-bigtable/commit/0cd71b59305cd7a336c223faff68402a8bee4639))


### Bug Fixes

* **test:** Clean up tests ([#439](https://www.github.com/googleapis/java-bigtable/issues/439)) ([c5c881b](https://www.github.com/googleapis/java-bigtable/commit/c5c881bb956860a393c2a7f34d0d790a23d270af))
* Add documentation to bulkReadRows that each batch will process t… ([#410](https://www.github.com/googleapis/java-bigtable/issues/410)) ([71dc8e3](https://www.github.com/googleapis/java-bigtable/commit/71dc8e3419fbb49d48bb7a3fd984d24e24661c81))
* Filters should be serializable ([#397](https://www.github.com/googleapis/java-bigtable/issues/397)) ([57edfde](https://www.github.com/googleapis/java-bigtable/commit/57edfde5eace28d50ec777e14589c9747616f0a8))
* RowCells are not actually serializeable ([#407](https://www.github.com/googleapis/java-bigtable/issues/407)) ([39e17cc](https://www.github.com/googleapis/java-bigtable/commit/39e17cc17c438f2d665875f9ff2b2cdf984e37b7))


### Dependencies

* update dependency com.google.cloud:google-cloud-conformance-tests to v0.0.12 ([#415](https://www.github.com/googleapis/java-bigtable/issues/415)) ([7b3713a](https://www.github.com/googleapis/java-bigtable/commit/7b3713a8935b2f0b1ca57d189e9e0363506b28a1))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.10.0 ([#428](https://www.github.com/googleapis/java-bigtable/issues/428)) ([373032e](https://www.github.com/googleapis/java-bigtable/commit/373032e93b838cbc0ccab7dc45cd61b3b973542a))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.10.1 ([#443](https://www.github.com/googleapis/java-bigtable/issues/443)) ([939fefa](https://www.github.com/googleapis/java-bigtable/commit/939fefa819d09885489d9faeedadc74ee2b0e1b9))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.9.1 ([#427](https://www.github.com/googleapis/java-bigtable/issues/427)) ([5175e28](https://www.github.com/googleapis/java-bigtable/commit/5175e28f5ce69f6fb3ed14131c1cfd26dbc47bb9))

## [1.15.0](https://www.github.com/googleapis/java-bigtable/compare/v1.14.0...v1.15.0) (2020-09-01)


### Features

* extend channel priming logic to also send fake requests ([#398](https://www.github.com/googleapis/java-bigtable/issues/398)) ([6f1ead2](https://www.github.com/googleapis/java-bigtable/commit/6f1ead2097150a87cb9712bcf35c6eaa9d57440c))
* **deps:** adopt flatten plugin and google-cloud-shared-dependencies ([#350](https://www.github.com/googleapis/java-bigtable/issues/350)) ([2298596](https://www.github.com/googleapis/java-bigtable/commit/2298596dab8a1ef87c0f48d3abe8bc3955417eb1))


### Bug Fixes

* temporarily disable reporting to unblock releases ([#395](https://www.github.com/googleapis/java-bigtable/issues/395)) ([a56a0f8](https://www.github.com/googleapis/java-bigtable/commit/a56a0f8c9caf675b68d02587b042e1feeb261ccb))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.6 ([#377](https://www.github.com/googleapis/java-bigtable/issues/377)) ([bdae336](https://www.github.com/googleapis/java-bigtable/commit/bdae336074d80815dcaaf8c71befafc0ed66c079))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.9.0 ([#402](https://www.github.com/googleapis/java-bigtable/issues/402)) ([08f7d84](https://www.github.com/googleapis/java-bigtable/commit/08f7d84333c6a74bf03e0a57707b878a29400dd4))

## [1.14.0](https://www.github.com/googleapis/java-bigtable/compare/v1.13.1...v1.14.0) (2020-07-20)


### Features

* Cloud Bigtable Managed Backup Implementation ([#305](https://www.github.com/googleapis/java-bigtable/issues/305)) ([9e3307a](https://www.github.com/googleapis/java-bigtable/commit/9e3307a4872d3bae3c04e7857a9eb4859151965e))

### [1.13.1](https://www.github.com/googleapis/java-bigtable/compare/v1.13.0...v1.13.1) (2020-07-10)


### Reverts

* Revert "fix: change app_profile_id to the correct header app_profile (#318)" (#335) ([200cfac](https://www.github.com/googleapis/java-bigtable/commit/200cfac9b68be9882943765b06de7c0644daf53d)), closes [#318](https://www.github.com/googleapis/java-bigtable/issues/318) [#335](https://www.github.com/googleapis/java-bigtable/issues/335)


### Dependencies

* update autovalue.version to v1.7.3 ([#341](https://www.github.com/googleapis/java-bigtable/issues/341)) ([071d0fe](https://www.github.com/googleapis/java-bigtable/commit/071d0feac03b5077b088a09244fe863aa111c231))
* update autovalue.version to v1.7.4 ([#365](https://www.github.com/googleapis/java-bigtable/issues/365)) ([18ba73d](https://www.github.com/googleapis/java-bigtable/commit/18ba73da3e6f1035699dc885109f90ffb160cb4e))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.6.0 ([#325](https://www.github.com/googleapis/java-bigtable/issues/325)) ([6fc5b7b](https://www.github.com/googleapis/java-bigtable/commit/6fc5b7b1f13c5326001cc7bcecbf4918a8505d26))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.7.0 ([#326](https://www.github.com/googleapis/java-bigtable/issues/326)) ([2aab7a8](https://www.github.com/googleapis/java-bigtable/commit/2aab7a8ec8775ab67e0277fd1785ee4735e1521d))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.1 ([#343](https://www.github.com/googleapis/java-bigtable/issues/343)) ([f0314a1](https://www.github.com/googleapis/java-bigtable/commit/f0314a13841cff495cc3424805a0aaf19bcc71d0))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.2 ([#362](https://www.github.com/googleapis/java-bigtable/issues/362)) ([1c37f5d](https://www.github.com/googleapis/java-bigtable/commit/1c37f5df35e4a317ac339e5d5b3cd50acf8e8c5a))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.3 ([#366](https://www.github.com/googleapis/java-bigtable/issues/366)) ([ade8b36](https://www.github.com/googleapis/java-bigtable/commit/ade8b362d66378e6b1ba75c6c04558e4437080a9))
* update dependency com.google.errorprone:error_prone_annotations to v2.4.0 ([#328](https://www.github.com/googleapis/java-bigtable/issues/328)) ([b9e5e83](https://www.github.com/googleapis/java-bigtable/commit/b9e5e832791b728d5931e1fe4546d01ffb4903d1))
* update protobuf.version to v3.12.2 ([#320](https://www.github.com/googleapis/java-bigtable/issues/320)) ([d5cf1d4](https://www.github.com/googleapis/java-bigtable/commit/d5cf1d4a62f9782c18a2d7ebb48d137426f84d5b))
* use google-cloud-shared-dependencies in bigtable deps bom ([#324](https://www.github.com/googleapis/java-bigtable/issues/324)) ([8f76fc8](https://www.github.com/googleapis/java-bigtable/commit/8f76fc8e7d326ed7837070cf496a2f20d4c7485e))

## [1.13.0](https://www.github.com/googleapis/java-bigtable/compare/v1.12.2...v1.13.0) (2020-05-27)


### Features

* adding utility to transform protobuf into model object ([#299](https://www.github.com/googleapis/java-bigtable/issues/299)) ([00f6d2d](https://www.github.com/googleapis/java-bigtable/commit/00f6d2da4179eb3f4f55a1fe1da04047697c5999))
* expose new API with ReadRowsRequest in EnhancedBigtableStub ([#276](https://www.github.com/googleapis/java-bigtable/issues/276)) ([394efe4](https://www.github.com/googleapis/java-bigtable/commit/394efe459ebe34030bf1d09116eebb4ec4f311e9))
* Update opencensus metrics to include bigtable resource ids and rpc level metrics ([#214](https://www.github.com/googleapis/java-bigtable/issues/214)) ([7214ef6](https://www.github.com/googleapis/java-bigtable/commit/7214ef6853fc6892401b55bd1beeccbe896e4f33))


### Bug Fixes

* bigtable v2 retry config settings to disable streaming RPC retries ([#315](https://www.github.com/googleapis/java-bigtable/issues/315)) ([a7e43f0](https://www.github.com/googleapis/java-bigtable/commit/a7e43f07dc0b93c6702992d45444e815200bf202))
* change app_profile_id to the correct header app_profile ([#318](https://www.github.com/googleapis/java-bigtable/issues/318)) ([237b15d](https://www.github.com/googleapis/java-bigtable/commit/237b15d14b420005d32f227e1a76e7d308db0a42))


### Dependencies

* update autovalue.version to v1.7.2 ([#306](https://www.github.com/googleapis/java-bigtable/issues/306)) ([bc215c5](https://www.github.com/googleapis/java-bigtable/commit/bc215c5883b16727c28893b4a13b3387f0a04ac9))
* update dependency com.google.api:api-common to v1.9.1 ([#316](https://www.github.com/googleapis/java-bigtable/issues/316)) ([482603a](https://www.github.com/googleapis/java-bigtable/commit/482603acd4c3db461b0e5f489a8c55213b9f3326))
* update dependency com.google.cloud:google-cloud-conformance-tests to v0.0.11 ([#307](https://www.github.com/googleapis/java-bigtable/issues/307)) ([50a19a6](https://www.github.com/googleapis/java-bigtable/commit/50a19a6aded1b313390ff78b52d9ffc4f4cc7fdd))
* update dependency com.google.cloud:google-cloud-core-bom to v1.93.5 ([#317](https://www.github.com/googleapis/java-bigtable/issues/317)) ([7f61f90](https://www.github.com/googleapis/java-bigtable/commit/7f61f903abc16554c88850061faf03e6b8beb3b9))
* update protobuf.version to v3.12.1 ([#308](https://www.github.com/googleapis/java-bigtable/issues/308)) ([99e3a95](https://www.github.com/googleapis/java-bigtable/commit/99e3a95d456bb79841720e8ecbdcb0d47017535e))


### Documentation

* **fix:** update client documentation link ([#312](https://www.github.com/googleapis/java-bigtable/issues/312)) ([7e04c7a](https://www.github.com/googleapis/java-bigtable/commit/7e04c7a69a80d71303ce62b4320153facd3cfad8))

### [1.12.2](https://www.github.com/googleapis/java-bigtable/compare/v1.12.1...v1.12.2) (2020-05-11)


### Bug Fixes

* set x-goog-api-client as internal header ([#293](https://www.github.com/googleapis/java-bigtable/issues/293)) ([3b58a4f](https://www.github.com/googleapis/java-bigtable/commit/3b58a4fa82e7a1e003bf119ce3b8b52b6eb52e47))

### [1.12.1](https://www.github.com/googleapis/java-bigtable/compare/v1.12.0...v1.12.1) (2020-05-08)


### Bug Fixes

* add missing api-client header ([#290](https://www.github.com/googleapis/java-bigtable/issues/290)) ([656684b](https://www.github.com/googleapis/java-bigtable/commit/656684b7f0fff003bb582977beb828f83da9a135))

## [1.12.0](https://www.github.com/googleapis/java-bigtable/compare/v1.11.0...v1.12.0) (2020-05-06)


### Features

* add more context to row merging errors ([#281](https://www.github.com/googleapis/java-bigtable/issues/281)) ([d88547c](https://www.github.com/googleapis/java-bigtable/commit/d88547cb55e9e2df09471df62074165266847c6d))


### Bug Fixes

* **build:** fix version update flag in samples pom.xml ([#285](https://www.github.com/googleapis/java-bigtable/issues/285)) ([6a1f970](https://www.github.com/googleapis/java-bigtable/commit/6a1f9701574fcdd41bc8300115e21ebe31b6f426))


### Dependencies

* update autovalue.version to v1.7.1 ([#278](https://www.github.com/googleapis/java-bigtable/issues/278)) ([e2f4e9e](https://www.github.com/googleapis/java-bigtable/commit/e2f4e9e84277dd242bf2fc454ab3243ff557f1ca))
* update core dependencies ([#215](https://www.github.com/googleapis/java-bigtable/issues/215)) ([ad7aab4](https://www.github.com/googleapis/java-bigtable/commit/ad7aab435aa31541535e4e202f01a79484f007a5))
* update core dependencies for google-cloud-core and gax ([#240](https://www.github.com/googleapis/java-bigtable/issues/240)) ([8f384f4](https://www.github.com/googleapis/java-bigtable/commit/8f384f48e984c69b10a515d15324227b40130d83))
* update dependency com.google.api:api-common to v1.9.0 ([#231](https://www.github.com/googleapis/java-bigtable/issues/231)) ([9a0f983](https://www.github.com/googleapis/java-bigtable/commit/9a0f9838c9a96ae1108da36f79bf1a4cdf4b5749))
* update dependency com.google.api:gax-bom to v1.55.0 ([#234](https://www.github.com/googleapis/java-bigtable/issues/234)) ([f910a32](https://www.github.com/googleapis/java-bigtable/commit/f910a32abef5b24a093c1ecef71d47811c458b41))
* update dependency com.google.cloud:google-cloud-conformance-tests to v0.0.10 ([#271](https://www.github.com/googleapis/java-bigtable/issues/271)) ([2bf6195](https://www.github.com/googleapis/java-bigtable/commit/2bf6195e8c215b8a6a72b66711fb24e98f3ab5a2))
* update dependency com.google.cloud:google-cloud-conformance-tests to v0.0.8 ([#216](https://www.github.com/googleapis/java-bigtable/issues/216)) ([423cb6b](https://www.github.com/googleapis/java-bigtable/commit/423cb6b395aa67986993f7d6c9dbd588e93faca6))
* update dependency com.google.cloud:google-cloud-conformance-tests to v0.0.9 ([#230](https://www.github.com/googleapis/java-bigtable/issues/230)) ([a84c689](https://www.github.com/googleapis/java-bigtable/commit/a84c689150990fe39ccc8055941ffb237cd499f5))
* update dependency com.google.cloud:google-cloud-core-bom to v1.93.3 ([#219](https://www.github.com/googleapis/java-bigtable/issues/219)) ([92f2755](https://www.github.com/googleapis/java-bigtable/commit/92f2755ca3b5218daa286556ce2c8b2f5b79fad6))
* update dependency com.google.cloud.samples:shared-configuration to v1.0.15 ([#246](https://www.github.com/googleapis/java-bigtable/issues/246)) ([3348210](https://www.github.com/googleapis/java-bigtable/commit/33482104496856dc849fe9858c429266a6caf4da))
* update dependency com.google.guava:guava-bom to v29 ([#244](https://www.github.com/googleapis/java-bigtable/issues/244)) ([0f7bd45](https://www.github.com/googleapis/java-bigtable/commit/0f7bd45bf15ebe25e2b5dd75134885e43b2604f0))
* update dependency com.google.http-client:google-http-client-bom to v1.35.0 ([#272](https://www.github.com/googleapis/java-bigtable/issues/272)) ([af0874b](https://www.github.com/googleapis/java-bigtable/commit/af0874bcbab22366514b89d8e567cbeeed4789f8))
* update dependency io.grpc:grpc-bom to v1.28.1 ([#236](https://www.github.com/googleapis/java-bigtable/issues/236)) ([4a72205](https://www.github.com/googleapis/java-bigtable/commit/4a72205018b39d71cfa54466fe44630c0e4202aa))
* update dependency io.grpc:grpc-bom to v1.29.0 ([#267](https://www.github.com/googleapis/java-bigtable/issues/267)) ([2e6393b](https://www.github.com/googleapis/java-bigtable/commit/2e6393b2bf4899ab603dfc6de9128df76d4ecb2d))
* update dependency org.threeten:threetenbp to v1.4.2 ([#225](https://www.github.com/googleapis/java-bigtable/issues/225)) ([5b94b02](https://www.github.com/googleapis/java-bigtable/commit/5b94b02ddc53c98d4a59e5457bdecc949d177c84))
* update dependency org.threeten:threetenbp to v1.4.3 ([#237](https://www.github.com/googleapis/java-bigtable/issues/237)) ([86fab5c](https://www.github.com/googleapis/java-bigtable/commit/86fab5cb90b1ca83c494f6787ca9d10d930ca1ff))
* update dependency org.threeten:threetenbp to v1.4.4 ([#270](https://www.github.com/googleapis/java-bigtable/issues/270)) ([6eba2af](https://www.github.com/googleapis/java-bigtable/commit/6eba2aff251fd3930a971d6270f297d449f21320))
* update google.common-protos.version to v1.18.0 ([#279](https://www.github.com/googleapis/java-bigtable/issues/279)) ([1571dd9](https://www.github.com/googleapis/java-bigtable/commit/1571dd939c24484309b8f484f73f29e602fce27c))
* update opencensus.version to v0.26.0 ([#223](https://www.github.com/googleapis/java-bigtable/issues/223)) ([1a00982](https://www.github.com/googleapis/java-bigtable/commit/1a00982eead27d3e3b13bc0c3942459618408e53))

## [1.11.0](https://www.github.com/googleapis/java-bigtable/compare/v1.10.0...v1.11.0) (2020-03-03)


### Features

* add row exists api ([#190](https://www.github.com/googleapis/java-bigtable/issues/190)) ([d141c3d](https://www.github.com/googleapis/java-bigtable/commit/d141c3d597cbd682050b78bb3828fd4d8c96a7c3))


### Dependencies

* update core dependencies ([#183](https://www.github.com/googleapis/java-bigtable/issues/183)) ([674bb73](https://www.github.com/googleapis/java-bigtable/commit/674bb73fa8a37233ba8f8d336e6e4be72a91f3a0))
* update dependency com.google.api:gax-bom to v1.54.0 ([#208](https://www.github.com/googleapis/java-bigtable/issues/208)) ([16cb625](https://www.github.com/googleapis/java-bigtable/commit/16cb62576058cb4124b98445f90b1afed012fd86))
* update dependency com.google.cloud:google-cloud-conformance-tests to v0.0.5 ([#180](https://www.github.com/googleapis/java-bigtable/issues/180)) ([687335b](https://www.github.com/googleapis/java-bigtable/commit/687335b97c1db121a5aa2681bbddd9c0b733d9c4))
* update dependency com.google.cloud:google-cloud-conformance-tests to v0.0.6 ([#207](https://www.github.com/googleapis/java-bigtable/issues/207)) ([6e803e9](https://www.github.com/googleapis/java-bigtable/commit/6e803e9ffdf70ace27d31caf3ba428a9017c1799))
* update dependency com.google.cloud:google-cloud-conformance-tests to v0.0.7 ([#210](https://www.github.com/googleapis/java-bigtable/issues/210)) ([9988811](https://www.github.com/googleapis/java-bigtable/commit/9988811e32eecee357c81beecab4199708b700fa))
* update dependency com.google.cloud:google-cloud-core-bom to v1.92.3 ([#179](https://www.github.com/googleapis/java-bigtable/issues/179)) ([7b896dd](https://www.github.com/googleapis/java-bigtable/commit/7b896dd60eb44e14d862789e9f8a15c113a235c8))
* update dependency com.google.cloud:google-cloud-core-bom to v1.92.5 ([279b64c](https://www.github.com/googleapis/java-bigtable/commit/279b64ca03da9e3f42e1468ea4f2b0a28f4ac939))
* update dependency com.google.cloud:google-cloud-core-bom to v1.93.0 ([#209](https://www.github.com/googleapis/java-bigtable/issues/209)) ([86905bf](https://www.github.com/googleapis/java-bigtable/commit/86905bfe12e7ea251c3eafafe328f87d7687bf4e))
* update dependency com.google.cloud:google-cloud-core-bom to v1.93.1 ([#211](https://www.github.com/googleapis/java-bigtable/issues/211)) ([a4596b5](https://www.github.com/googleapis/java-bigtable/commit/a4596b5db8d79bd86dfa33c7ae280a7227928398))
* update dependency com.google.http-client:google-http-client-bom to v1.34.1 ([#175](https://www.github.com/googleapis/java-bigtable/issues/175)) ([c25e8aa](https://www.github.com/googleapis/java-bigtable/commit/c25e8aa509796c33af4c53ffb68d7e40e6dbc237))
* update dependency com.google.http-client:google-http-client-bom to v1.34.2 ([#201](https://www.github.com/googleapis/java-bigtable/issues/201)) ([72c6d52](https://www.github.com/googleapis/java-bigtable/commit/72c6d527ce52d3fcc4f8340dcb2ded6035993260))
* update dependency io.grpc:grpc-bom to v1.27.0 ([#177](https://www.github.com/googleapis/java-bigtable/issues/177)) ([c8ab8a6](https://www.github.com/googleapis/java-bigtable/commit/c8ab8a6f94d7017f0ab0c7e2d23b99ba4388afd4))
* update dependency io.grpc:grpc-bom to v1.27.1 ([#200](https://www.github.com/googleapis/java-bigtable/issues/200)) ([c622be3](https://www.github.com/googleapis/java-bigtable/commit/c622be3fb3e2034b3834c38881015b04f01c2859))
* update dependency io.grpc:grpc-bom to v1.27.2 ([#206](https://www.github.com/googleapis/java-bigtable/issues/206)) ([33a609a](https://www.github.com/googleapis/java-bigtable/commit/33a609a0cdc32cdcbf42b04597a476b144849bce))
* update opencensus.version to v0.25.0 ([#198](https://www.github.com/googleapis/java-bigtable/issues/198)) ([1a36da2](https://www.github.com/googleapis/java-bigtable/commit/1a36da2c7e397650e6cac3172b9a9fcc953796ff))
* update protobuf.version to v3.11.3 ([#187](https://www.github.com/googleapis/java-bigtable/issues/187)) ([f38e3e3](https://www.github.com/googleapis/java-bigtable/commit/f38e3e37a51121b55faf91737bbb3cee36baa23a))
* update protobuf.version to v3.11.4 ([#202](https://www.github.com/googleapis/java-bigtable/issues/202)) ([f9b4438](https://www.github.com/googleapis/java-bigtable/commit/f9b44388cdb32af12314a00ab420278e29969d76))


### Documentation

* **regen:** update sample code to set total timeout, add API client header test ([f3be131](https://www.github.com/googleapis/java-bigtable/commit/f3be131923a86359be541b53627b15bda8ed407e))
* readme note for gke deployment configuration ([#185](https://www.github.com/googleapis/java-bigtable/issues/185)) ([0afa13a](https://www.github.com/googleapis/java-bigtable/commit/0afa13ae8df95119acc482ec79e204abd1bc333e))

## [1.10.0](https://www.github.com/googleapis/java-bigtable/compare/v1.9.1...v1.10.0) (2020-01-27)


### Features

* introducing bulk read API through Batcher ([#99](https://www.github.com/googleapis/java-bigtable/issues/99)) ([e87179e](https://www.github.com/googleapis/java-bigtable/commit/e87179ebe1e53b7962a940a9aba761da8047e7e4))


### Dependencies

* update dependency com.google.auth:google-auth-library-bom to v0.20.0 ([#168](https://www.github.com/googleapis/java-bigtable/issues/168)) ([8d69936](https://www.github.com/googleapis/java-bigtable/commit/8d69936e0d3cdba0085b363852e85fcb9eeb9dab))
* update dependency com.google.cloud:google-cloud-conformance-tests to v0.0.4 ([#157](https://www.github.com/googleapis/java-bigtable/issues/157)) ([abbc6c8](https://www.github.com/googleapis/java-bigtable/commit/abbc6c8c0ffbe1dcf88c14b1e70fe3150c61c582))
* update dependency com.google.cloud:google-cloud-core-bom to v1.92.2 ([#147](https://www.github.com/googleapis/java-bigtable/issues/147)) ([f3462b1](https://www.github.com/googleapis/java-bigtable/commit/f3462b119aa154f116e55f95e25171c482e08f8a))
* update dependency com.google.truth:truth to v1.0.1 ([#156](https://www.github.com/googleapis/java-bigtable/issues/156)) ([f767feb](https://www.github.com/googleapis/java-bigtable/commit/f767febcd3bf913bbb2e5421fa716a13a7b4a33b))
* update dependency org.threeten:threetenbp to v1.4.1 ([#153](https://www.github.com/googleapis/java-bigtable/issues/153)) ([f92da32](https://www.github.com/googleapis/java-bigtable/commit/f92da32e4834fe44148000f127b2962ecb94a67a))


### Documentation

* synth updates to javadoc and kokoro build configs ([d6275a7](https://www.github.com/googleapis/java-bigtable/commit/d6275a7877d98f5794ec7d400c10b2dce89167f0))

### [1.9.1](https://www.github.com/googleapis/java-bigtable/compare/v1.9.0...v1.9.1) (2020-01-09)


### Dependencies

* upgrade gax to 1.53.0 ([#145](https://www.github.com/googleapis/java-bigtable/issues/145)) ([c3fc40d](https://www.github.com/googleapis/java-bigtable/commit/c3fc40df4358bd68cddcfc6f0a3fedb74dcdf465))

## [1.9.0](https://www.github.com/googleapis/java-bigtable/compare/v1.8.0...v1.9.0) (2020-01-06)


### Features

* add BigtableDataClientFactory to create lightweight data clients ([#112](https://www.github.com/googleapis/java-bigtable/issues/112)) ([d6bfd30](https://www.github.com/googleapis/java-bigtable/commit/d6bfd30ea9484b7433a048bdaad66153ffaa6a79))
* introduce google-cloud-bigtable-deps-bom ([#130](https://www.github.com/googleapis/java-bigtable/issues/130)) ([9289a13](https://www.github.com/googleapis/java-bigtable/commit/9289a13203b009930507c858ed14326768174c28))


### Dependencies

* update core dependencies to v1.92.1 ([#132](https://www.github.com/googleapis/java-bigtable/issues/132)) ([da1e6c6](https://www.github.com/googleapis/java-bigtable/commit/da1e6c61770c934644588f8a9933f6f68bd35ad1))
* update dependency com.google.guava:guava-bom to v28.2-android ([2905528](https://www.github.com/googleapis/java-bigtable/commit/2905528eac8f39e2aa39ca5bca13c6aba33f178b))
* update dependency io.grpc:grpc-bom to v1.26.0 ([#121](https://www.github.com/googleapis/java-bigtable/issues/121)) ([82a5094](https://www.github.com/googleapis/java-bigtable/commit/82a50943e454a3e8a23f002128d842eb98458b51))
* update dependency junit:junit to v4.13 ([#131](https://www.github.com/googleapis/java-bigtable/issues/131)) ([d4f46fd](https://www.github.com/googleapis/java-bigtable/commit/d4f46fd7118f2037a58bae2c467ff11449ee4dfc))


### Documentation

* update README to include CI Status ([#125](https://www.github.com/googleapis/java-bigtable/issues/125)) ([1e4987b](https://www.github.com/googleapis/java-bigtable/commit/1e4987b8baaa7e0dfd3905e6acf643788d5c722c))

## [1.8.0](https://www.github.com/googleapis/java-bigtable/compare/v1.7.1...v1.8.0) (2019-12-17)


### Features

* add implementation of ChannelPrimer to establish connection to GFE and integrate into bigtable client ([#115](https://www.github.com/googleapis/java-bigtable/issues/115)) ([276f942](https://www.github.com/googleapis/java-bigtable/commit/276f942dd2e668600347a59496525a589d7560da))
* update filter to accept an exact timestamp for better accessibility ([#92](https://www.github.com/googleapis/java-bigtable/issues/92)) ([e25758b](https://www.github.com/googleapis/java-bigtable/commit/e25758b3164618ac16d57fffe6ba0e4175229960))


### Dependencies

* update gax.version to v1.51.0 ([#105](https://www.github.com/googleapis/java-bigtable/issues/105)) ([dcdd0c3](https://www.github.com/googleapis/java-bigtable/commit/dcdd0c347f10802be57c4f7267c2b82c59ea2278))
* upgrade gax to 1.52.0, google-cloud-core to 1.92.0 ([#118](https://www.github.com/googleapis/java-bigtable/issues/118)) ([c106497](https://www.github.com/googleapis/java-bigtable/commit/c1064977eff3889e4f8b6ba8ab44a08f6f96ae1f))

### [1.7.1](https://www.github.com/googleapis/java-bigtable/compare/v1.7.0...v1.7.1) (2019-11-13)


### Dependencies

* update gax.version to v1.50.1 ([#72](https://www.github.com/googleapis/java-bigtable/issues/72)) ([eb44a19](https://www.github.com/googleapis/java-bigtable/commit/eb44a19ccaed342b84dec80048802641dfd6609e))

## [1.7.0](https://www.github.com/googleapis/java-bigtable/compare/v1.6.0...v1.7.0) (2019-11-07)


### Features

* add bom ([#50](https://www.github.com/googleapis/java-bigtable/issues/50)) ([f4dd552](https://www.github.com/googleapis/java-bigtable/commit/f4dd552ea00044babe1273e322b8a330f093b2b0))


### Bug Fixes

* align version numbers for proto and grpc versions ([#52](https://www.github.com/googleapis/java-bigtable/issues/52)) ([dbfa73a](https://www.github.com/googleapis/java-bigtable/commit/dbfa73a1a336d0afb03e7755d17786216199a851))
* fix maven test configs to make sure admin tests don't clobber data tests ([#47](https://www.github.com/googleapis/java-bigtable/issues/47)) ([18576f5](https://www.github.com/googleapis/java-bigtable/commit/18576f55c34dbdc4c0ac79639dbc1dbf1ce7affe))
* fix regression in batch#close silently ignoring entry failures by upgrading to gax to 1.50.0 ([#67](https://www.github.com/googleapis/java-bigtable/issues/67)) ([5aa8769](https://www.github.com/googleapis/java-bigtable/commit/5aa87697a5e8860993a14f4ac42d675c66b3d0ff))
* handle recovery failures during stream reframing failure ([#46](https://www.github.com/googleapis/java-bigtable/issues/46)) ([a16cb88](https://www.github.com/googleapis/java-bigtable/commit/a16cb8864c0c8be26d34e71dbf261dbfc5e09bac))
* Prevent integration tests from different profiles from trampling each other ([#69](https://www.github.com/googleapis/java-bigtable/issues/69)) ([638615a](https://www.github.com/googleapis/java-bigtable/commit/638615ae09ec2d311e82d89ea7a78137911f4eb4))
* use proper scope for DirectPath transitive dependencies ([#59](https://www.github.com/googleapis/java-bigtable/issues/59)) ([1d1c4de](https://www.github.com/googleapis/java-bigtable/commit/1d1c4deb34a85836da2aed7b07359ff923b09835))


### Documentation

* cleanup links to java-bigtable and javadoc ([#56](https://www.github.com/googleapis/java-bigtable/issues/56)) ([846a44f](https://www.github.com/googleapis/java-bigtable/commit/846a44fbf9ebd5691a431e79a09a049aea5fd4f0))

## [1.6.0](https://www.github.com/googleapis/java-bigtable/compare/1.5.0...v1.6.0) (2019-10-24)


### Features

* Add Experimental DirectPath support ([#8](https://www.github.com/googleapis/java-bigtable/issues/8)) ([2dd5105](https://www.github.com/googleapis/java-bigtable/commit/2dd5105559f6f61f9780b11e44bccbd2c08d68ae))


### Dependencies

* update gax.version to v1.49.1 ([a138a0f](https://www.github.com/googleapis/java-bigtable/commit/a138a0f8f42ede72d5cd30536cef4e78e5de5843))
* upgrade threeten to 1.4 ([#33](https://www.github.com/googleapis/java-bigtable/issues/33)) ([554170b](https://www.github.com/googleapis/java-bigtable/commit/554170b929ec63155d0e840039e75b323dad1709))
