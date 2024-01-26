# Changelog

## [1.126.2](https://github.com/googleapis/java-pubsub/compare/v1.126.1...v1.126.2) (2024-01-26)


### Bug Fixes

* **deps:** Update the Java code generator (gapic-generator-java) to 2.32.0 ([#1875](https://github.com/googleapis/java-pubsub/issues/1875)) ([0aac3e4](https://github.com/googleapis/java-pubsub/commit/0aac3e4c9c5671ce8f3b98056cc3710cd5ca9d07))


### Dependencies

* Update dependency com.google.cloud:google-cloud-bigquery to v2.37.0 ([#1878](https://github.com/googleapis/java-pubsub/issues/1878)) ([16dee8b](https://github.com/googleapis/java-pubsub/commit/16dee8bce115f59d8518ca1ae0e39dd87d81f802))

## [1.126.1](https://github.com/googleapis/java-pubsub/compare/v1.126.0...v1.126.1) (2024-01-25)


### Dependencies

* Update dependency com.google.cloud:google-cloud-bigquery to v2.36.0 ([#1840](https://github.com/googleapis/java-pubsub/issues/1840)) ([8c5117d](https://github.com/googleapis/java-pubsub/commit/8c5117d02511acd5469d863ea483f6e765e29292))
* Update dependency com.google.cloud:google-cloud-core to v2.30.0 ([#1853](https://github.com/googleapis/java-pubsub/issues/1853)) ([db36def](https://github.com/googleapis/java-pubsub/commit/db36deff6a4187cb98ddd68259efd6034762060e))
* Update dependency com.google.cloud:google-cloud-core to v2.31.0 ([#1872](https://github.com/googleapis/java-pubsub/issues/1872)) ([06db9a0](https://github.com/googleapis/java-pubsub/commit/06db9a05a80b2d7f38aefff2d5e0b33e3fa1a2c9))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.22.0 ([#1865](https://github.com/googleapis/java-pubsub/issues/1865)) ([f4c6f51](https://github.com/googleapis/java-pubsub/commit/f4c6f5112e8285264a497b3a141c31f77fea6ee2))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.23.0 ([#1873](https://github.com/googleapis/java-pubsub/issues/1873)) ([0d445f1](https://github.com/googleapis/java-pubsub/commit/0d445f173574433aed2770d9cc949672221b839e))
* Update dependency com.google.cloud:google-cloud-storage to v2.32.0 ([#1857](https://github.com/googleapis/java-pubsub/issues/1857)) ([d673e55](https://github.com/googleapis/java-pubsub/commit/d673e55e69f60f5a6f6bae10e2f62d7fd0dfa89f))
* Update dependency com.google.cloud:google-cloud-storage to v2.32.1 ([#1874](https://github.com/googleapis/java-pubsub/issues/1874)) ([adae8a4](https://github.com/googleapis/java-pubsub/commit/adae8a4aadb08532076fd02710d0e41336ec096c))
* Update dependency com.google.protobuf:protobuf-java-util to v3.25.2 ([#1858](https://github.com/googleapis/java-pubsub/issues/1858)) ([8fa6354](https://github.com/googleapis/java-pubsub/commit/8fa635427927e1859332896b8373abccd5881949))

## [1.126.0](https://github.com/googleapis/java-pubsub/compare/v1.125.13...v1.126.0) (2024-01-13)


### Features

* Add `use_table_schema` field to BigQueryConfig ([#1838](https://github.com/googleapis/java-pubsub/issues/1838)) ([8653f4f](https://github.com/googleapis/java-pubsub/commit/8653f4f3dbd61466b8ea05b342c5f66c9e536cf1))


### Bug Fixes

* **deps:** Update the Java code generator (gapic-generator-java) to 2.31.0 ([#1855](https://github.com/googleapis/java-pubsub/issues/1855)) ([7e733d2](https://github.com/googleapis/java-pubsub/commit/7e733d20093e0cd492758dd1ff3efc3a72eb1e0c))
* Swap writer and reader schema to correct places in sample ([#1849](https://github.com/googleapis/java-pubsub/issues/1849)) ([1c79ad7](https://github.com/googleapis/java-pubsub/commit/1c79ad7336f51ffd4e177be5c2f2a7de902b47b8))
* Temporarily remove publisher tests causing timeouts ([#1860](https://github.com/googleapis/java-pubsub/issues/1860)) ([a8fa24d](https://github.com/googleapis/java-pubsub/commit/a8fa24d7185d5345e746f8e2563afffe08f3bd6e))
* Use message ordering enabled property that comes with streaming pull responses ([#1851](https://github.com/googleapis/java-pubsub/issues/1851)) ([d816138](https://github.com/googleapis/java-pubsub/commit/d8161380e232fd4be408e6298827423907a027fb))


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.21.0 ([#1854](https://github.com/googleapis/java-pubsub/issues/1854)) ([b36825b](https://github.com/googleapis/java-pubsub/commit/b36825bf476f8bf83a7ca594932e03d06bc05f07))
* Update dependency com.google.cloud:google-cloud-storage to v2.30.1 ([#1841](https://github.com/googleapis/java-pubsub/issues/1841)) ([d6f1352](https://github.com/googleapis/java-pubsub/commit/d6f1352ec3debe106ba238343c0c05b9278dc964))

## [1.125.13](https://github.com/googleapis/java-pubsub/compare/v1.125.12...v1.125.13) (2023-11-30)


### Dependencies

* Update dependency com.google.cloud:google-cloud-core to v2.28.0 ([#1830](https://github.com/googleapis/java-pubsub/issues/1830)) ([8990b7c](https://github.com/googleapis/java-pubsub/commit/8990b7ca7cfbb08cd117f59bbf18c67dd1e7fb18))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.20.0 ([#1831](https://github.com/googleapis/java-pubsub/issues/1831)) ([d188af8](https://github.com/googleapis/java-pubsub/commit/d188af8815927b409f72c968cbd6a8685976d08b))
* Update dependency com.google.protobuf:protobuf-java-util to v3.25.1 ([#1816](https://github.com/googleapis/java-pubsub/issues/1816)) ([e4f2b26](https://github.com/googleapis/java-pubsub/commit/e4f2b2605b17024f983a8ccf50ed19d169c15d90))

## [1.125.12](https://github.com/googleapis/java-pubsub/compare/v1.125.11...v1.125.12) (2023-11-21)


### Bug Fixes

* Concurrent modification of processing receievd messages ([#1807](https://github.com/googleapis/java-pubsub/issues/1807)) ([d162126](https://github.com/googleapis/java-pubsub/commit/d16212627b0d9b6616e0a9b20af2c430e2f6b36f))


### Dependencies

* Update dependency com.google.cloud:google-cloud-bigquery to v2.34.2 ([#1821](https://github.com/googleapis/java-pubsub/issues/1821)) ([c21ba1a](https://github.com/googleapis/java-pubsub/commit/c21ba1a51acf3411e7f9793f579a103ee1d36f38))
* Update dependency com.google.cloud:google-cloud-storage to v2.29.1 ([#1817](https://github.com/googleapis/java-pubsub/issues/1817)) ([e179b94](https://github.com/googleapis/java-pubsub/commit/e179b94b7034fbb6c10775b0fe469ab129c0d6c8))
* Update dependency org.junit.vintage:junit-vintage-engine to v5.10.1 ([#1819](https://github.com/googleapis/java-pubsub/issues/1819)) ([af84aa3](https://github.com/googleapis/java-pubsub/commit/af84aa3f5434d3e8ff2122b72cae0fc1c7323742))

## [1.125.11](https://github.com/googleapis/java-pubsub/compare/v1.125.10...v1.125.11) (2023-11-01)


### Dependencies

* Update dependency com.google.cloud:google-cloud-core to v2.27.0 ([#1810](https://github.com/googleapis/java-pubsub/issues/1810)) ([edd89f3](https://github.com/googleapis/java-pubsub/commit/edd89f36061cd1518f81eb7b33e42cf5c35c659d))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.19.0 ([#1811](https://github.com/googleapis/java-pubsub/issues/1811)) ([d671bcb](https://github.com/googleapis/java-pubsub/commit/d671bcb9b0e6c425eb33bdafea9c20b543020363))

## [1.125.10](https://github.com/googleapis/java-pubsub/compare/v1.125.9...v1.125.10) (2023-10-31)


### Dependencies

* Update dependency com.google.cloud:google-cloud-storage to v2.29.0 ([#1800](https://github.com/googleapis/java-pubsub/issues/1800)) ([8c43cc2](https://github.com/googleapis/java-pubsub/commit/8c43cc2443f333c646c27cee4ee70434167213ba))


### Documentation

* Adding a GCS subscription example ([#1762](https://github.com/googleapis/java-pubsub/issues/1762)) ([3ce824c](https://github.com/googleapis/java-pubsub/commit/3ce824c78c7eaf37fc3bc0ed2a4b3b1d952ed9bc))
* Renaming the CreateUnwrappedPushSubscription File ([#1794](https://github.com/googleapis/java-pubsub/issues/1794)) ([3264290](https://github.com/googleapis/java-pubsub/commit/326429092ac73d184b5e887ce5107220f96199b7))

## [1.125.9](https://github.com/googleapis/java-pubsub/compare/v1.125.8...v1.125.9) (2023-10-27)


### Dependencies

* Update dependency com.google.cloud:google-cloud-bigquery to v2.34.0 ([#1795](https://github.com/googleapis/java-pubsub/issues/1795)) ([670daf1](https://github.com/googleapis/java-pubsub/commit/670daf1c74242dfa54e9747924d094cbcaac4d37))

## [1.125.8](https://github.com/googleapis/java-pubsub/compare/v1.125.7...v1.125.8) (2023-10-23)


### Dependencies

* Update dependency com.google.cloud:google-cloud-core to v2.26.0 ([#1780](https://github.com/googleapis/java-pubsub/issues/1780)) ([2d38175](https://github.com/googleapis/java-pubsub/commit/2d381751b51cb69b6ab248ee56fe9ce5bf7f5cd5))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.18.0 ([#1781](https://github.com/googleapis/java-pubsub/issues/1781)) ([5b6cb15](https://github.com/googleapis/java-pubsub/commit/5b6cb15ce9f459061875329ba1fc6d4b84909666))
* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.28 ([#1782](https://github.com/googleapis/java-pubsub/issues/1782)) ([c9be478](https://github.com/googleapis/java-pubsub/commit/c9be478c3558928fc603c81fc07c4d8ba6d853b4))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.28 ([#1783](https://github.com/googleapis/java-pubsub/issues/1783)) ([5e39b79](https://github.com/googleapis/java-pubsub/commit/5e39b799d5d7b41325f9564a6044c0f0b4b05fdc))


### Documentation

* Modified some descriptions ([#1773](https://github.com/googleapis/java-pubsub/issues/1773)) ([17bd055](https://github.com/googleapis/java-pubsub/commit/17bd05512ba71083eb898a3ff8c5dc53c9bbb08d))

## [1.125.7](https://github.com/googleapis/java-pubsub/compare/v1.125.6...v1.125.7) (2023-10-17)


### Dependencies

* Update dependency com.google.cloud:google-cloud-bigquery to v2.33.2 ([#1770](https://github.com/googleapis/java-pubsub/issues/1770)) ([db73af7](https://github.com/googleapis/java-pubsub/commit/db73af7bca53faae2e135ec9a1899e36ac19025c))

## [1.125.6](https://github.com/googleapis/java-pubsub/compare/v1.125.5...v1.125.6) (2023-10-10)


### Dependencies

* Update dependency com.google.cloud:google-cloud-bigquery to v2.33.1 ([#1756](https://github.com/googleapis/java-pubsub/issues/1756)) ([239f474](https://github.com/googleapis/java-pubsub/commit/239f474fefd2313a6842c63c4202d835008647e3))
* Update dependency com.google.cloud:google-cloud-core to v2.25.0 ([#1764](https://github.com/googleapis/java-pubsub/issues/1764)) ([72404ea](https://github.com/googleapis/java-pubsub/commit/72404eabcc3695b8072091587515562d852a6108))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.17.0 ([#1765](https://github.com/googleapis/java-pubsub/issues/1765)) ([a447292](https://github.com/googleapis/java-pubsub/commit/a447292d07ae1d9b03866dbdd9549c1b10564b28))
* Update dependency com.google.protobuf:protobuf-java-util to v3.24.4 ([#1760](https://github.com/googleapis/java-pubsub/issues/1760)) ([10a64c6](https://github.com/googleapis/java-pubsub/commit/10a64c6b872a14decf3a799ebd985395358dc32c))

## [1.125.5](https://github.com/googleapis/java-pubsub/compare/v1.125.4...v1.125.5) (2023-09-28)


### Dependencies

* Update gapic-generator-java to 2.26.0 ([935849c](https://github.com/googleapis/java-pubsub/commit/935849cedbb70a0821be56828dd0abeccbccc21c))

## [1.125.4](https://github.com/googleapis/java-pubsub/compare/v1.125.3...v1.125.4) (2023-09-28)


### Dependencies

* Update dependency com.google.cloud:google-cloud-bigquery to v2.33.0 ([#1750](https://github.com/googleapis/java-pubsub/issues/1750)) ([bcbfcd0](https://github.com/googleapis/java-pubsub/commit/bcbfcd0dd65c2ca0f20d3579109728737f1292bc))

## [1.125.3](https://github.com/googleapis/java-pubsub/compare/v1.125.2...v1.125.3) (2023-09-27)


### Dependencies

* Update dependency com.google.cloud:google-cloud-core to v2.24.1 ([#1737](https://github.com/googleapis/java-pubsub/issues/1737)) ([48a4432](https://github.com/googleapis/java-pubsub/commit/48a44321ad34edd8c297ccc57445ec36916171cb))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.16.1 ([#1738](https://github.com/googleapis/java-pubsub/issues/1738)) ([e2cf7c1](https://github.com/googleapis/java-pubsub/commit/e2cf7c110b72dff695a46a972687a595216934e6))
* Update dependency org.apache.avro:avro to v1.11.3 ([#1740](https://github.com/googleapis/java-pubsub/issues/1740)) ([971b35f](https://github.com/googleapis/java-pubsub/commit/971b35f5d26263ef3c1d83b6282680ac1608c032))
* Update dependency org.xerial.snappy:snappy-java to v1.1.10.4 [security] ([#1742](https://github.com/googleapis/java-pubsub/issues/1742)) ([70ba500](https://github.com/googleapis/java-pubsub/commit/70ba500cc014cb9d0e1799997aa0682239b97cde))
* Update dependency org.xerial.snappy:snappy-java to v1.1.10.5 ([#1746](https://github.com/googleapis/java-pubsub/issues/1746)) ([a4b1994](https://github.com/googleapis/java-pubsub/commit/a4b199414cad5cb061330832b2bf2a8bbe76bcbd))

## [1.125.2](https://github.com/googleapis/java-pubsub/compare/v1.125.1...v1.125.2) (2023-09-18)


### Dependencies

* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.27 ([#1730](https://github.com/googleapis/java-pubsub/issues/1730)) ([687a855](https://github.com/googleapis/java-pubsub/commit/687a855580a9c8fe7f0d4a8952cb3ca46ff6f736))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.27 ([#1731](https://github.com/googleapis/java-pubsub/issues/1731)) ([403b7e7](https://github.com/googleapis/java-pubsub/commit/403b7e72c275464a67f6998bb975d95026a8480d))

## [1.125.1](https://github.com/googleapis/java-pubsub/compare/v1.125.0...v1.125.1) (2023-09-14)


### Dependencies

* Update actions/checkout action to v4 - abandoned ([#1719](https://github.com/googleapis/java-pubsub/issues/1719)) ([b82f15a](https://github.com/googleapis/java-pubsub/commit/b82f15a099f3366620f5e22764b043911ebd88d1))
* Update dependency com.google.cloud:google-cloud-bigquery to v2.32.0 ([#1725](https://github.com/googleapis/java-pubsub/issues/1725)) ([f40f09a](https://github.com/googleapis/java-pubsub/commit/f40f09a185c035cc03b6be6ec62f880da9f7b377))

## [1.125.0](https://github.com/googleapis/java-pubsub/compare/v1.124.2...v1.125.0) (2023-09-12)


### Features

* Receipt modack ([#1540](https://github.com/googleapis/java-pubsub/issues/1540)) ([74d8da9](https://github.com/googleapis/java-pubsub/commit/74d8da97c42b672e3f9f26b9a535d6bac948a402))


### Bug Fixes

* Make retry policy back off more aggressively for RPCs that retry RESOURCE_EXHAUSTD ([#1704](https://github.com/googleapis/java-pubsub/issues/1704)) ([f61e7e0](https://github.com/googleapis/java-pubsub/commit/f61e7e0e2895a90e30ecf4dcbfa8c70022947d9e))


### Dependencies

* Update actions/checkout action to v4 ([#1712](https://github.com/googleapis/java-pubsub/issues/1712)) ([404c492](https://github.com/googleapis/java-pubsub/commit/404c492823306c1448c62383b9ea88cf9e43b970))
* Update dependency com.google.cloud:google-cloud-bigquery to v2.31.2 ([#1713](https://github.com/googleapis/java-pubsub/issues/1713)) ([32cb43c](https://github.com/googleapis/java-pubsub/commit/32cb43cce40f7a39602eb7d9b39a88eb229fc4ef))
* Update dependency com.google.cloud:google-cloud-core to v2.23.0 ([#1717](https://github.com/googleapis/java-pubsub/issues/1717)) ([929f778](https://github.com/googleapis/java-pubsub/commit/929f778e341aefe61206e55de828bf5a86e4efd3))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.15.0 ([#1718](https://github.com/googleapis/java-pubsub/issues/1718)) ([0eeaa19](https://github.com/googleapis/java-pubsub/commit/0eeaa19a640513e80d595ca7c4016e26fc30871b))
* Update dependency com.google.protobuf:protobuf-java-util to v3.24.3 ([#1698](https://github.com/googleapis/java-pubsub/issues/1698)) ([1157fbf](https://github.com/googleapis/java-pubsub/commit/1157fbff92204eae55bb24ad803f0b8e1336ac10))
* Update dependency org.easymock:easymock to v5.2.0 ([#1711](https://github.com/googleapis/java-pubsub/issues/1711)) ([313f6dd](https://github.com/googleapis/java-pubsub/commit/313f6dd8b82fbc57df066615e285325969b6d2e4))
* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.25 ([#1709](https://github.com/googleapis/java-pubsub/issues/1709)) ([1cc8a53](https://github.com/googleapis/java-pubsub/commit/1cc8a53a416acdd5f9cd4fc598f2f5f182a2ad44))
* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.26 ([#1715](https://github.com/googleapis/java-pubsub/issues/1715)) ([f2cc75f](https://github.com/googleapis/java-pubsub/commit/f2cc75f960521e8be50cf354e00024d66fb8f7fb))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.25 ([#1710](https://github.com/googleapis/java-pubsub/issues/1710)) ([9764c3f](https://github.com/googleapis/java-pubsub/commit/9764c3f740cd726ad09cef82039561bd145fbe0c))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.26 ([#1716](https://github.com/googleapis/java-pubsub/issues/1716)) ([6c9e949](https://github.com/googleapis/java-pubsub/commit/6c9e9493ec7aeaa0711ad2155fa6a549937284df))

## [1.124.2](https://github.com/googleapis/java-pubsub/compare/v1.124.1...v1.124.2) (2023-08-15)


### Bug Fixes

* Update Publish retry backoff settings ([#1686](https://github.com/googleapis/java-pubsub/issues/1686)) ([63a74d9](https://github.com/googleapis/java-pubsub/commit/63a74d98fdee56a98819d135a676a67fcc24961a))


### Dependencies

* Update dependency com.google.cloud:google-cloud-bigquery to v2.31.1 ([#1697](https://github.com/googleapis/java-pubsub/issues/1697)) ([9e90790](https://github.com/googleapis/java-pubsub/commit/9e907901e0f5f78adfffb3e61974e9f8fd756f96))
* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.24 ([#1695](https://github.com/googleapis/java-pubsub/issues/1695)) ([ec64036](https://github.com/googleapis/java-pubsub/commit/ec640361a471111001f22667fa7e38123b731025))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.24 ([#1696](https://github.com/googleapis/java-pubsub/issues/1696)) ([cc9ae19](https://github.com/googleapis/java-pubsub/commit/cc9ae19865c0ece3789a8c2fa22afb5fbd306dc9))

## [1.124.1](https://github.com/googleapis/java-pubsub/compare/v1.124.0...v1.124.1) (2023-08-03)


### Dependencies

* Update dependency com.google.cloud:google-cloud-core to v2.22.0 ([#1687](https://github.com/googleapis/java-pubsub/issues/1687)) ([220f318](https://github.com/googleapis/java-pubsub/commit/220f3181562a848cd786cc0126e8e3ad382787c7))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.14.0 ([#1688](https://github.com/googleapis/java-pubsub/issues/1688)) ([0ded9f1](https://github.com/googleapis/java-pubsub/commit/0ded9f172af637db5d4302b146a24ecdd5b1bde2))

## [1.124.0](https://github.com/googleapis/java-pubsub/compare/v1.123.20...v1.124.0) (2023-07-27)


### Features

* Setup 1.123.x lts branch ([#1676](https://github.com/googleapis/java-pubsub/issues/1676)) ([a60b887](https://github.com/googleapis/java-pubsub/commit/a60b88772d69d367f90bbe61bc4e157338193b0f))


### Documentation

* Clarified where ordering_key will be written if write_metadata is set ([#1675](https://github.com/googleapis/java-pubsub/issues/1675)) ([462746c](https://github.com/googleapis/java-pubsub/commit/462746cfbf9b712118b67349f2f4f4cebf45932a))

## [1.123.20](https://github.com/googleapis/java-pubsub/compare/v1.123.19...v1.123.20) (2023-07-25)


### Dependencies

* Update dependency com.google.cloud:google-cloud-bigquery to v2.31.0 ([#1671](https://github.com/googleapis/java-pubsub/issues/1671)) ([c51d396](https://github.com/googleapis/java-pubsub/commit/c51d39688464c51ffdb046368b4f8e926360d72e))

## [1.123.19](https://github.com/googleapis/java-pubsub/compare/v1.123.18...v1.123.19) (2023-07-25)


### Dependencies

* Update dependency com.google.cloud:google-cloud-bigquery to v2.30.1 ([#1656](https://github.com/googleapis/java-pubsub/issues/1656)) ([4fe4bc4](https://github.com/googleapis/java-pubsub/commit/4fe4bc49d82753e3e185f0a2c4694d80e48808f7))
* Update dependency com.google.cloud:google-cloud-core to v2.21.1 ([#1662](https://github.com/googleapis/java-pubsub/issues/1662)) ([e10292c](https://github.com/googleapis/java-pubsub/commit/e10292c16f24870a91584f716545ff210302a7bc))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.13.1 ([#1663](https://github.com/googleapis/java-pubsub/issues/1663)) ([50f4ff1](https://github.com/googleapis/java-pubsub/commit/50f4ff10140699a02d1ec550b05ff6d1aa39c762))
* Update dependency org.junit.vintage:junit-vintage-engine to v5.10.0 ([#1666](https://github.com/googleapis/java-pubsub/issues/1666)) ([d8712a3](https://github.com/googleapis/java-pubsub/commit/d8712a31459b8f9497dff7a866c8a8795ca60af9))
* Update dependency org.xerial.snappy:snappy-java to v1.1.10.3 ([#1665](https://github.com/googleapis/java-pubsub/issues/1665)) ([ad1c515](https://github.com/googleapis/java-pubsub/commit/ad1c5157eadc4bf2d43b7dc332ac4150d732912d))

## [1.123.18](https://github.com/googleapis/java-pubsub/compare/v1.123.17...v1.123.18) (2023-07-17)


### Documentation

* Tightened requirements on cloud storage subscription filename suffixes ([#1639](https://github.com/googleapis/java-pubsub/issues/1639)) ([34a182a](https://github.com/googleapis/java-pubsub/commit/34a182a1655c843cd728850b278ba2e9ce9a5680))


### Dependencies

* Update dependency com.google.cloud:google-cloud-core to v2.21.0 ([#1650](https://github.com/googleapis/java-pubsub/issues/1650)) ([69879d4](https://github.com/googleapis/java-pubsub/commit/69879d4c9d7a220f9c5a38b144d49e71ad3b94d0))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.13.0 ([#1651](https://github.com/googleapis/java-pubsub/issues/1651)) ([83fdbe2](https://github.com/googleapis/java-pubsub/commit/83fdbe2435d8fa03b5648272a794874ff910fcb6))
* Update dependency com.google.protobuf:protobuf-java-util to v3.23.4 ([#1649](https://github.com/googleapis/java-pubsub/issues/1649)) ([9f9c5ca](https://github.com/googleapis/java-pubsub/commit/9f9c5ca2abddde274c79cf36bf2aea91b7b8b455))
* Update dependency org.apache.avro:avro to v1.11.2 ([#1646](https://github.com/googleapis/java-pubsub/issues/1646)) ([5859fe4](https://github.com/googleapis/java-pubsub/commit/5859fe4c6540fa577942f38e117798d3c3cdc498))
* Update dependency org.xerial.snappy:snappy-java to v1.1.10.2 ([#1654](https://github.com/googleapis/java-pubsub/issues/1654)) ([05445f0](https://github.com/googleapis/java-pubsub/commit/05445f0ccf1cd78a604ec267d7a146cdd1770c59))

## [1.123.17](https://github.com/googleapis/java-pubsub/compare/v1.123.16...v1.123.17) (2023-06-26)


### Dependencies

* Update dependency com.google.cloud:google-cloud-bigquery to v2.29.0 ([#1633](https://github.com/googleapis/java-pubsub/issues/1633)) ([20096e7](https://github.com/googleapis/java-pubsub/commit/20096e7b64f9b62051f51ad28aa49b95f78b3e6b))

## [1.123.16](https://github.com/googleapis/java-pubsub/compare/v1.123.15...v1.123.16) (2023-06-26)


### Dependencies

* Update dependency com.google.protobuf:protobuf-java-util to v3.23.3 ([#1634](https://github.com/googleapis/java-pubsub/issues/1634)) ([2481c4b](https://github.com/googleapis/java-pubsub/commit/2481c4b8799bbe78542b4a8dd6c2484be08f30a1))

## [1.123.15](https://github.com/googleapis/java-pubsub/compare/v1.123.14...v1.123.15) (2023-06-22)


### Bug Fixes

* Fixing the shutdown logic for streaming subscriber connection ([#1613](https://github.com/googleapis/java-pubsub/issues/1613)) ([09aff9c](https://github.com/googleapis/java-pubsub/commit/09aff9c59bab646c0bae857f3bca9dc8e9eeebd1))


### Documentation

* Adding pubsub emulator example ([#1602](https://github.com/googleapis/java-pubsub/issues/1602)) ([8ded110](https://github.com/googleapis/java-pubsub/commit/8ded11041c63f1f75f0612c081ba6b476b6b89b8))


### Dependencies

* Update dependency com.google.cloud:google-cloud-bigquery to v2.27.0 ([#1599](https://github.com/googleapis/java-pubsub/issues/1599)) ([3b4b7d0](https://github.com/googleapis/java-pubsub/commit/3b4b7d0522d8eb136800dd546acb8880b8b28e9e))
* Update dependency com.google.cloud:google-cloud-bigquery to v2.27.1 ([#1614](https://github.com/googleapis/java-pubsub/issues/1614)) ([a974e08](https://github.com/googleapis/java-pubsub/commit/a974e08b45d49ca275c19a4e94e66b4b831a0fad))
* Update dependency com.google.cloud:google-cloud-bigquery to v2.28.0 ([#1626](https://github.com/googleapis/java-pubsub/issues/1626)) ([a4a02b4](https://github.com/googleapis/java-pubsub/commit/a4a02b4fd0a3827c3e321c56223731f0a828e8c5))
* Update dependency com.google.cloud:google-cloud-core to v2.20.0 ([#1629](https://github.com/googleapis/java-pubsub/issues/1629)) ([5f88f4f](https://github.com/googleapis/java-pubsub/commit/5f88f4f5f6fd1c8f2c0e7523b6919a6a477d785c))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.12.0 ([#1630](https://github.com/googleapis/java-pubsub/issues/1630)) ([b444a9d](https://github.com/googleapis/java-pubsub/commit/b444a9d825300519681a205a833ae9d816e89cf2))
* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.23 ([#1623](https://github.com/googleapis/java-pubsub/issues/1623)) ([b5f8e49](https://github.com/googleapis/java-pubsub/commit/b5f8e4961dd473c98641d8b78c958db1e0e8d01e))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.23 ([#1624](https://github.com/googleapis/java-pubsub/issues/1624)) ([68ada24](https://github.com/googleapis/java-pubsub/commit/68ada243897a763e04d4858ad052050e09326371))
* Update dependency org.xerial.snappy:snappy-java to v1.1.10.1 - abandoned ([#1616](https://github.com/googleapis/java-pubsub/issues/1616)) ([48ec282](https://github.com/googleapis/java-pubsub/commit/48ec282753f8068df135cee55febe5dba97be1b5))
* Update dependency org.xerial.snappy:snappy-java to v1.1.10.1 [security] ([#1620](https://github.com/googleapis/java-pubsub/issues/1620)) ([a1cb267](https://github.com/googleapis/java-pubsub/commit/a1cb2673f5e6556472a87a0fb2acbc3e0ddfd933))

## [1.123.14](https://github.com/googleapis/java-pubsub/compare/v1.123.13...v1.123.14) (2023-06-12)


### Dependencies

* Update dependency com.google.cloud:google-cloud-core to v2.19.0 ([#1604](https://github.com/googleapis/java-pubsub/issues/1604)) ([7ac609e](https://github.com/googleapis/java-pubsub/commit/7ac609e44c20db73460fe39919439c3a2b597454))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.11.0 ([#1605](https://github.com/googleapis/java-pubsub/issues/1605)) ([077ac04](https://github.com/googleapis/java-pubsub/commit/077ac04214be23f6693734c157925a5607ada869))

## [1.123.13](https://github.com/googleapis/java-pubsub/compare/v1.123.12...v1.123.13) (2023-05-30)


### Dependencies

* Update dependency com.google.cloud:google-cloud-bigquery to v2.26.0 ([#1582](https://github.com/googleapis/java-pubsub/issues/1582)) ([a7c09b7](https://github.com/googleapis/java-pubsub/commit/a7c09b763845fc78e5382f79365467d4bdb8a24d))
* Update dependency com.google.cloud:google-cloud-bigquery to v2.26.1 ([#1585](https://github.com/googleapis/java-pubsub/issues/1585)) ([e2c37bf](https://github.com/googleapis/java-pubsub/commit/e2c37bfcee74a6f95cc3c15cf1f9d3d1602b77ff))
* Update dependency com.google.cloud:google-cloud-core to v2.18.1 ([#1591](https://github.com/googleapis/java-pubsub/issues/1591)) ([1637f0d](https://github.com/googleapis/java-pubsub/commit/1637f0db2a89b20d28a6812b6abb4f36bfd46f80))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.10.0 ([#1592](https://github.com/googleapis/java-pubsub/issues/1592)) ([a6be7b7](https://github.com/googleapis/java-pubsub/commit/a6be7b7870ba776fd9b39a0b16d45ba51fcc8ad6))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.10.1 ([#1594](https://github.com/googleapis/java-pubsub/issues/1594)) ([52263ce](https://github.com/googleapis/java-pubsub/commit/52263ce63d4cbda649121e465f4bdc78bbfa8e44))
* Update dependency org.xerial.snappy:snappy-java to v1.1.10.0 ([#1590](https://github.com/googleapis/java-pubsub/issues/1590)) ([338f31f](https://github.com/googleapis/java-pubsub/commit/338f31f96deb09fe93e1306986a7887d285a9d06))

## [1.123.12](https://github.com/googleapis/java-pubsub/compare/v1.123.11...v1.123.12) (2023-05-12)


### Dependencies

* Update dependency com.google.cloud:google-cloud-bigquery to v2.25.0 ([#1566](https://github.com/googleapis/java-pubsub/issues/1566)) ([7e63280](https://github.com/googleapis/java-pubsub/commit/7e632806b83b5c849ea50fdf3085b2db7bdbeff3))
* Update dependency com.google.cloud:google-cloud-core to v2.17.0 ([#1574](https://github.com/googleapis/java-pubsub/issues/1574)) ([9c80f14](https://github.com/googleapis/java-pubsub/commit/9c80f1493a5149a76b55d9f1d178684e1b5dde80))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.9.0 ([#1576](https://github.com/googleapis/java-pubsub/issues/1576)) ([03a027f](https://github.com/googleapis/java-pubsub/commit/03a027fb2619444511d25ef7100c7ac850c1dca1))
* Update dependency org.easymock:easymock to v5.1.0 ([#1448](https://github.com/googleapis/java-pubsub/issues/1448)) ([5ad86fe](https://github.com/googleapis/java-pubsub/commit/5ad86fe783a2fcdfe6102a9916c65b1c4139b3da))
* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.22 ([#1570](https://github.com/googleapis/java-pubsub/issues/1570)) ([bbe9a8b](https://github.com/googleapis/java-pubsub/commit/bbe9a8b6594a0e6b777ceb3b97e8d625446e34e4))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.22 ([#1571](https://github.com/googleapis/java-pubsub/issues/1571)) ([e7b62d3](https://github.com/googleapis/java-pubsub/commit/e7b62d35aa3c73f55a474d406da094ded02d07f1))
* Update dependency org.xerial.snappy:snappy-java to v1.1.9.0 - abandoned ([#1471](https://github.com/googleapis/java-pubsub/issues/1471)) ([1620e00](https://github.com/googleapis/java-pubsub/commit/1620e00cf1632699fa37a78059dfb86e707dbccc))
* Update dependency org.xerial.snappy:snappy-java to v1.1.9.1 ([#1572](https://github.com/googleapis/java-pubsub/issues/1572)) ([1ec2fec](https://github.com/googleapis/java-pubsub/commit/1ec2feca66ab8b29edf8f9dd0d4b8df8261e709a))

## [1.123.11](https://github.com/googleapis/java-pubsub/compare/v1.123.10...v1.123.11) (2023-04-27)


### Dependencies

* Update dependency com.google.cloud:google-cloud-core to v2.15.0 ([#1558](https://github.com/googleapis/java-pubsub/issues/1558)) ([acf0a4f](https://github.com/googleapis/java-pubsub/commit/acf0a4f1b893b5be19167e87b958e722e53b2aee))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.8.0 ([#1561](https://github.com/googleapis/java-pubsub/issues/1561)) ([13bfd09](https://github.com/googleapis/java-pubsub/commit/13bfd09a9ba81e725a61f2b36c5d38fabcd8df56))
* Update dependency org.junit.vintage:junit-vintage-engine to v5.9.3 ([#1563](https://github.com/googleapis/java-pubsub/issues/1563)) ([c2329d2](https://github.com/googleapis/java-pubsub/commit/c2329d289d3447e72904d20e9c89065b59d7e6de))

## [1.123.10](https://github.com/googleapis/java-pubsub/compare/v1.123.9...v1.123.10) (2023-04-17)


### Dependencies

* Update dependency com.google.cloud:google-cloud-bigquery to v2.24.5 ([#1555](https://github.com/googleapis/java-pubsub/issues/1555)) ([7d81b06](https://github.com/googleapis/java-pubsub/commit/7d81b063465f23b1779c2137bc1706dafdaea042))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.7.0 ([#1551](https://github.com/googleapis/java-pubsub/issues/1551)) ([bccf566](https://github.com/googleapis/java-pubsub/commit/bccf566c6072aa34ebad451880835625217f9fe4))

## [1.123.9](https://github.com/googleapis/java-pubsub/compare/v1.123.8...v1.123.9) (2023-04-13)


### Dependencies

* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.21 ([#1547](https://github.com/googleapis/java-pubsub/issues/1547)) ([e78f210](https://github.com/googleapis/java-pubsub/commit/e78f210c9b72b0b9fb561ef8f41eb1aa2d8be4d7))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.21 ([#1548](https://github.com/googleapis/java-pubsub/issues/1548)) ([42957f8](https://github.com/googleapis/java-pubsub/commit/42957f8c93a07c7db5e3f007644b9508ef9dfe73))

## [1.123.8](https://github.com/googleapis/java-pubsub/compare/v1.123.7...v1.123.8) (2023-04-04)


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.6.0 ([#1541](https://github.com/googleapis/java-pubsub/issues/1541)) ([828db7c](https://github.com/googleapis/java-pubsub/commit/828db7cfde91284db019b85552d64ca92e8ebe07))

## [1.123.7](https://github.com/googleapis/java-pubsub/compare/v1.123.6...v1.123.7) (2023-03-21)


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.5.0 ([#1532](https://github.com/googleapis/java-pubsub/issues/1532)) ([d63fba7](https://github.com/googleapis/java-pubsub/commit/d63fba73d5ea445144f625f7b67622351694c818))

## [1.123.6](https://github.com/googleapis/java-pubsub/compare/v1.123.5...v1.123.6) (2023-03-14)


### Dependencies

* Update dependency com.google.cloud:google-cloud-bigquery to v2.23.2 ([#1512](https://github.com/googleapis/java-pubsub/issues/1512)) ([60e889e](https://github.com/googleapis/java-pubsub/commit/60e889e587511cc948af440be7733dc4af531dd1))

## [1.123.5](https://github.com/googleapis/java-pubsub/compare/v1.123.4...v1.123.5) (2023-03-03)


### Dependencies

* Update dependency com.google.cloud:google-cloud-core to v2.12.0 ([#1509](https://github.com/googleapis/java-pubsub/issues/1509)) ([6f70d8a](https://github.com/googleapis/java-pubsub/commit/6f70d8a96577ac93647f4d13adc6b31889efeddf))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.4.0 ([#1510](https://github.com/googleapis/java-pubsub/issues/1510)) ([0d0ece7](https://github.com/googleapis/java-pubsub/commit/0d0ece70f1527932abb04d9719de68a1367c5881))

## [1.123.4](https://github.com/googleapis/java-pubsub/compare/v1.123.3...v1.123.4) (2023-02-22)


### Dependencies

* Update dependency com.google.cloud:google-cloud-bigquery to v2.23.0 ([#1496](https://github.com/googleapis/java-pubsub/issues/1496)) ([713d727](https://github.com/googleapis/java-pubsub/commit/713d727db447f02e3c6cc7dfbb656fcebba54121))

## [1.123.3](https://github.com/googleapis/java-pubsub/compare/v1.123.2...v1.123.3) (2023-02-22)


### Dependencies

* Update dependency com.google.cloud:google-cloud-bigquery to v2.21.0 ([#1470](https://github.com/googleapis/java-pubsub/issues/1470)) ([105c293](https://github.com/googleapis/java-pubsub/commit/105c2933d3f71389e2629e4871767199fe53f7f4))
* Update dependency com.google.cloud:google-cloud-bigquery to v2.22.0 ([#1489](https://github.com/googleapis/java-pubsub/issues/1489)) ([665436c](https://github.com/googleapis/java-pubsub/commit/665436cb9a0900fd62a6197e73baecf13de21597))
* Update dependency com.google.cloud:google-cloud-core to v2.10.0 ([#1464](https://github.com/googleapis/java-pubsub/issues/1464)) ([8cab4e2](https://github.com/googleapis/java-pubsub/commit/8cab4e2f0b8455a30aa71a7915a836730ee7f059))
* Update dependency com.google.cloud:google-cloud-core to v2.11.0 ([#1490](https://github.com/googleapis/java-pubsub/issues/1490)) ([c42474a](https://github.com/googleapis/java-pubsub/commit/c42474a8c1a98e7533edef47acf9c7210b99a56e))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.3.0 ([#1491](https://github.com/googleapis/java-pubsub/issues/1491)) ([e5e3227](https://github.com/googleapis/java-pubsub/commit/e5e32273a515cf9ce22ffffb58a8f7a252556526))
* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.20 ([#1484](https://github.com/googleapis/java-pubsub/issues/1484)) ([8206d12](https://github.com/googleapis/java-pubsub/commit/8206d129d819617a3dd8ebdab531d3fc7b7289f1))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.20 ([#1485](https://github.com/googleapis/java-pubsub/issues/1485)) ([d0e9b2a](https://github.com/googleapis/java-pubsub/commit/d0e9b2a8197f91029ae26fdec7e88f7ca38dab79))

## [1.123.2](https://github.com/googleapis/java-pubsub/compare/v1.123.1...v1.123.2) (2023-02-06)


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.2.0 ([#1474](https://github.com/googleapis/java-pubsub/issues/1474)) ([5fccae4](https://github.com/googleapis/java-pubsub/commit/5fccae49f912a24c14d144fdcc9617d5a5ae110a))

## [1.123.1](https://github.com/googleapis/java-pubsub/compare/v1.123.0...v1.123.1) (2023-01-20)


### Dependencies

* Update dependency com.google.cloud:google-cloud-bigquery to v2.20.2 ([#1441](https://github.com/googleapis/java-pubsub/issues/1441)) ([a675556](https://github.com/googleapis/java-pubsub/commit/a67555664a070eb03b6f8bb7115e32e2b9d9a11a))
* Update dependency com.google.cloud:google-cloud-core to v2.9.2 ([#1449](https://github.com/googleapis/java-pubsub/issues/1449)) ([e68c9e0](https://github.com/googleapis/java-pubsub/commit/e68c9e0e0808c441e04049154fb0c44f42fed562))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.1.2 ([#1463](https://github.com/googleapis/java-pubsub/issues/1463)) ([e9e6649](https://github.com/googleapis/java-pubsub/commit/e9e664951b027979969e983c7e525aff6e4ddc68))
* Update dependency com.google.protobuf:protobuf-java-util to v3.21.12 ([#1437](https://github.com/googleapis/java-pubsub/issues/1437)) ([88f7a99](https://github.com/googleapis/java-pubsub/commit/88f7a991c43e6358ccc3ad248473400a2a0e50e8))
* Update dependency org.junit.vintage:junit-vintage-engine to v5.9.2 ([#1451](https://github.com/googleapis/java-pubsub/issues/1451)) ([054572a](https://github.com/googleapis/java-pubsub/commit/054572a86ecc2cedcdbcf3eae8c9fb07caed504a))

## [1.123.0](https://github.com/googleapis/java-pubsub/compare/v1.122.2...v1.123.0) (2023-01-10)


### Features

* Add schema evolution methods and fields ([#1384](https://github.com/googleapis/java-pubsub/issues/1384)) ([746a6e0](https://github.com/googleapis/java-pubsub/commit/746a6e040eb94d73bfbaece051d08c60c9885326))


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.1.1 ([#1450](https://github.com/googleapis/java-pubsub/issues/1450)) ([2dcbcad](https://github.com/googleapis/java-pubsub/commit/2dcbcadfa56282733ab7998ec9cf360f0a71eaca))

## [1.122.2](https://github.com/googleapis/java-pubsub/compare/v1.122.1...v1.122.2) (2022-12-15)


### Dependencies

* Update dependency com.google.cloud:google-cloud-core to v2.9.0 ([#1435](https://github.com/googleapis/java-pubsub/issues/1435)) ([786c493](https://github.com/googleapis/java-pubsub/commit/786c49303bc196e548b00ef0cf39d766e8fd71a8))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.1.0 ([#1436](https://github.com/googleapis/java-pubsub/issues/1436)) ([a40337b](https://github.com/googleapis/java-pubsub/commit/a40337b493454d20a12f70b7817de7b0f2584b84))

## [1.122.1](https://github.com/googleapis/java-pubsub/compare/v1.122.0...v1.122.1) (2022-12-02)


### Dependencies

* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.19 ([#1428](https://github.com/googleapis/java-pubsub/issues/1428)) ([bfa9c3d](https://github.com/googleapis/java-pubsub/commit/bfa9c3d5f8f7b0d3103fe5d398ed3f753e1bedca))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.19 ([#1429](https://github.com/googleapis/java-pubsub/issues/1429)) ([d3c44e7](https://github.com/googleapis/java-pubsub/commit/d3c44e77532068e53d7d64dd182295ab6b9644bd))

## [1.122.0](https://github.com/googleapis/java-pubsub/compare/v1.121.1...v1.122.0) (2022-12-01)


### Features

* Next release from main branch is 1.122.0 ([#1409](https://github.com/googleapis/java-pubsub/issues/1409)) ([dad2c82](https://github.com/googleapis/java-pubsub/commit/dad2c82cc22ed40def105514a4bc8446375dc70e))


### Dependencies

* Update dependency com.google.protobuf:protobuf-java-util to v3.21.10 ([#1425](https://github.com/googleapis/java-pubsub/issues/1425)) ([39c22cb](https://github.com/googleapis/java-pubsub/commit/39c22cb99dadd1dea874e0a57cf2c9fb0dd67328))

## [1.121.1](https://github.com/googleapis/java-pubsub/compare/v1.121.0...v1.121.1) (2022-11-21)


### Dependencies

* Update dependency com.google.cloud:google-cloud-bigquery to v2.18.0 ([#1375](https://github.com/googleapis/java-pubsub/issues/1375)) ([b6ada4e](https://github.com/googleapis/java-pubsub/commit/b6ada4e06397d785b6747bd989fe6cd9d6e76801))
* Update dependency com.google.cloud:google-cloud-bigquery to v2.19.1 ([#1416](https://github.com/googleapis/java-pubsub/issues/1416)) ([e140a49](https://github.com/googleapis/java-pubsub/commit/e140a4975a5bff4c73254784409f4f3dda27db09))
* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.18 ([#1413](https://github.com/googleapis/java-pubsub/issues/1413)) ([b3fb828](https://github.com/googleapis/java-pubsub/commit/b3fb828480f491e4275adf0b6367aeb51ac0569e))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.18 ([#1414](https://github.com/googleapis/java-pubsub/issues/1414)) ([74d2dc3](https://github.com/googleapis/java-pubsub/commit/74d2dc3329f6d4e33c977fa1e73df1aca278b9b3))

## [1.121.0](https://github.com/googleapis/java-pubsub/compare/v1.120.25...v1.121.0) (2022-11-16)


### Features

* Next release from main branch is 1.121.0 ([#1406](https://github.com/googleapis/java-pubsub/issues/1406)) ([1b25b0e](https://github.com/googleapis/java-pubsub/commit/1b25b0e01a7b1068dbebaa5d6516419c11e31b96))


### Dependencies

* Update dependency com.google.cloud:google-cloud-core to v2.8.28 ([#1399](https://github.com/googleapis/java-pubsub/issues/1399)) ([ec1cae8](https://github.com/googleapis/java-pubsub/commit/ec1cae87596921078478ed96a22b9ca5b138f729))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.6 ([#1395](https://github.com/googleapis/java-pubsub/issues/1395)) ([a3c32ea](https://github.com/googleapis/java-pubsub/commit/a3c32eadb8e6d4ce730f2f2d1f8960ccd6269ecb))

## [1.120.25](https://github.com/googleapis/java-pubsub/compare/v1.120.24...v1.120.25) (2022-11-09)


### Dependencies

* Update dependency com.google.cloud:google-cloud-core to v2.8.27 ([#1391](https://github.com/googleapis/java-pubsub/issues/1391)) ([dd9f1c3](https://github.com/googleapis/java-pubsub/commit/dd9f1c366c9aa5f78dccc01a4dc3e2ee42290be3))
* Update dependency com.google.protobuf:protobuf-java-util to v3.21.9 ([#1370](https://github.com/googleapis/java-pubsub/issues/1370)) ([8b753a4](https://github.com/googleapis/java-pubsub/commit/8b753a452a3f778402b61565d38a9a2ce90f084a))
* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.17 ([#1389](https://github.com/googleapis/java-pubsub/issues/1389)) ([6def6bb](https://github.com/googleapis/java-pubsub/commit/6def6bbff8c31af6a008fee89654a13b0db1550f))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.17 ([#1388](https://github.com/googleapis/java-pubsub/issues/1388)) ([0924923](https://github.com/googleapis/java-pubsub/commit/0924923039e30716d66ad8ca519fbdae88946807))

## [1.120.24](https://github.com/googleapis/java-pubsub/compare/v1.120.23...v1.120.24) (2022-10-28)


### Bug Fixes

* Adding an explicit check to prevent empty publishes ([#1376](https://github.com/googleapis/java-pubsub/issues/1376)) ([689d7da](https://github.com/googleapis/java-pubsub/commit/689d7da1fee7c7def401ba114feef3607cd12cf5))

## [1.120.23](https://github.com/googleapis/java-pubsub/compare/v1.120.22...v1.120.23) (2022-10-27)


### Dependencies

* Update dependency com.google.cloud:google-cloud-core to v2.8.22 ([#1361](https://github.com/googleapis/java-pubsub/issues/1361)) ([0355868](https://github.com/googleapis/java-pubsub/commit/03558680b9fb6493c2c3f1f4b65d8a35668b440f))
* Update dependency com.google.cloud:google-cloud-core to v2.8.24 ([#1368](https://github.com/googleapis/java-pubsub/issues/1368)) ([9776aad](https://github.com/googleapis/java-pubsub/commit/9776aad7391544b1e0bd2fbe8576180206943bef))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.5 ([#1362](https://github.com/googleapis/java-pubsub/issues/1362)) ([d32c591](https://github.com/googleapis/java-pubsub/commit/d32c591af87b66d8ca9df599ad18183aae31bf15))
* Update dependency com.google.protobuf:protobuf-java-util to v3.21.8 ([#1356](https://github.com/googleapis/java-pubsub/issues/1356)) ([dc1e0ca](https://github.com/googleapis/java-pubsub/commit/dc1e0ca44c3668d7c9e780d50261dd81ce1d4ee9))
* Update dependency org.easymock:easymock to v5.0.1 ([#1365](https://github.com/googleapis/java-pubsub/issues/1365)) ([2a807a5](https://github.com/googleapis/java-pubsub/commit/2a807a5b319ed3821da7dac84e4cb4923d07fed7))
* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.16 ([#1358](https://github.com/googleapis/java-pubsub/issues/1358)) ([226e105](https://github.com/googleapis/java-pubsub/commit/226e1050b0b643cea46bad7cf77d2a9e8857fb02))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.16 ([#1359](https://github.com/googleapis/java-pubsub/issues/1359)) ([3f10227](https://github.com/googleapis/java-pubsub/commit/3f10227cfd7d9029e92e7575771544c7e4b4dd67))

## [1.120.22](https://github.com/googleapis/java-pubsub/compare/v1.120.21...v1.120.22) (2022-10-18)


### Dependencies

* Update dependency org.easymock:easymock to v5 ([#1350](https://github.com/googleapis/java-pubsub/issues/1350)) ([1e88543](https://github.com/googleapis/java-pubsub/commit/1e88543393ac16a79288c80d3561f7e5c50f11af))
* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.15 ([#1351](https://github.com/googleapis/java-pubsub/issues/1351)) ([2af7579](https://github.com/googleapis/java-pubsub/commit/2af757971fd54855936ad95e0cd3f6ab13d50edc))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.15 ([#1352](https://github.com/googleapis/java-pubsub/issues/1352)) ([379e39b](https://github.com/googleapis/java-pubsub/commit/379e39bdb6ed3cd50c5f034fb5ecd40905b43bda))

## [1.120.21](https://github.com/googleapis/java-pubsub/compare/v1.120.20...v1.120.21) (2022-10-14)


### Dependencies

* Update dependency com.google.cloud:google-cloud-bigquery to v2.17.0 ([#1334](https://github.com/googleapis/java-pubsub/issues/1334)) ([d2edb44](https://github.com/googleapis/java-pubsub/commit/d2edb4457a5a5fdee006b34b1de265b7e73a26e1))
* Update dependency com.google.cloud:google-cloud-bigquery to v2.17.1 ([#1340](https://github.com/googleapis/java-pubsub/issues/1340)) ([2b9c2e8](https://github.com/googleapis/java-pubsub/commit/2b9c2e8af4f83dd8d51272a0539c7ade05041a68))
* Update dependency com.google.cloud:google-cloud-core to v2.8.21 ([#1341](https://github.com/googleapis/java-pubsub/issues/1341)) ([d219a56](https://github.com/googleapis/java-pubsub/commit/d219a56de3c5a3e5455c3ca063bf0e363a4c476a))
* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.14 ([#1296](https://github.com/googleapis/java-pubsub/issues/1296)) ([00f61aa](https://github.com/googleapis/java-pubsub/commit/00f61aab905300986945bb67a8737779c3f72da6))

## [1.120.20](https://github.com/googleapis/java-pubsub/compare/v1.120.19...v1.120.20) (2022-10-05)


### Bug Fixes

* update protobuf to v3.21.7 ([7c3ea60](https://github.com/googleapis/java-pubsub/commit/7c3ea6016e4288beab722a0c53c5ea132794e2bd))

## [1.120.19](https://github.com/googleapis/java-pubsub/compare/v1.120.18...v1.120.19) (2022-10-03)


### Dependencies

* Update dependency cachetools to v5 ([#1324](https://github.com/googleapis/java-pubsub/issues/1324)) ([72b6d5f](https://github.com/googleapis/java-pubsub/commit/72b6d5f7ce6b464c1f1653699178e989c7eb6a75))
* Update dependency certifi to v2022.9.24 ([#1303](https://github.com/googleapis/java-pubsub/issues/1303)) ([dc05237](https://github.com/googleapis/java-pubsub/commit/dc052371a1a83a194cb0098f93a8e8dd57d8e5d4))
* Update dependency charset-normalizer to v2.1.1 ([#1308](https://github.com/googleapis/java-pubsub/issues/1308)) ([fedf2e1](https://github.com/googleapis/java-pubsub/commit/fedf2e1f98bf77de6d6cac18e745819e8250df57))
* Update dependency click to v8.1.3 ([#1309](https://github.com/googleapis/java-pubsub/issues/1309)) ([0ddcb5b](https://github.com/googleapis/java-pubsub/commit/0ddcb5b324ecc4e3a8cc98bc2ef0d210061a79d5))
* Update dependency com.google.cloud:google-cloud-core to v2.8.15 ([#1299](https://github.com/googleapis/java-pubsub/issues/1299)) ([11f220c](https://github.com/googleapis/java-pubsub/commit/11f220ca32bf82c87746837e12ae878ee9578704))
* Update dependency com.google.cloud:google-cloud-core to v2.8.16 ([#1301](https://github.com/googleapis/java-pubsub/issues/1301)) ([186c794](https://github.com/googleapis/java-pubsub/commit/186c79497057847aa577b47d169e3535274b0a2d))
* Update dependency com.google.cloud:google-cloud-core to v2.8.17 ([#1326](https://github.com/googleapis/java-pubsub/issues/1326)) ([361a2f2](https://github.com/googleapis/java-pubsub/commit/361a2f2ae44098d280c1244479954638d4321a69))
* Update dependency com.google.cloud:google-cloud-core to v2.8.18 ([#1328](https://github.com/googleapis/java-pubsub/issues/1328)) ([ae23532](https://github.com/googleapis/java-pubsub/commit/ae23532092c80e3b4abe8e1b51f2ef67bb991428))
* Update dependency com.google.cloud:google-cloud-core to v2.8.20 ([#1329](https://github.com/googleapis/java-pubsub/issues/1329)) ([c37b88e](https://github.com/googleapis/java-pubsub/commit/c37b88e209dd1d58035385676d7c1dfca0da2c4e))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.4 ([#1330](https://github.com/googleapis/java-pubsub/issues/1330)) ([0f6cc6c](https://github.com/googleapis/java-pubsub/commit/0f6cc6c01e6afeb717487e7435575d243bd0203d))
* Update dependency com.google.protobuf:protobuf-java-util to v3.21.7 ([#1327](https://github.com/googleapis/java-pubsub/issues/1327)) ([6355eb0](https://github.com/googleapis/java-pubsub/commit/6355eb0ed1fa94a36fbb0169e4b6dc7faed165ff))
* Update dependency gcp-releasetool to v1.8.8 ([#1304](https://github.com/googleapis/java-pubsub/issues/1304)) ([1c7c6eb](https://github.com/googleapis/java-pubsub/commit/1c7c6eb10a184919d36f7738f4594cd7aff9f87b))
* Update dependency google-api-core to v2.10.1 ([#1310](https://github.com/googleapis/java-pubsub/issues/1310)) ([14725f2](https://github.com/googleapis/java-pubsub/commit/14725f248082c4397b0058d25984a61a9bf2c5c9))
* Update dependency google-auth to v2.11.1 ([#1305](https://github.com/googleapis/java-pubsub/issues/1305)) ([a6954d1](https://github.com/googleapis/java-pubsub/commit/a6954d1cf17cb0247e5e153001ec983fb957b410))
* Update dependency google-auth to v2.12.0 ([#1313](https://github.com/googleapis/java-pubsub/issues/1313)) ([ffcebe4](https://github.com/googleapis/java-pubsub/commit/ffcebe43542d4ab3b2cea1c2dcb5e6b345c4905b))
* Update dependency google-cloud-core to v2.3.2 ([#1306](https://github.com/googleapis/java-pubsub/issues/1306)) ([fbb4460](https://github.com/googleapis/java-pubsub/commit/fbb44605794a350889ae300f697b76ed9ff41af2))
* Update dependency importlib-metadata to v4.12.0 ([#1314](https://github.com/googleapis/java-pubsub/issues/1314)) ([e319df0](https://github.com/googleapis/java-pubsub/commit/e319df0bce76b1d8ba25b410225377d624070926))
* Update dependency jeepney to v0.8.0 ([#1315](https://github.com/googleapis/java-pubsub/issues/1315)) ([5ed336e](https://github.com/googleapis/java-pubsub/commit/5ed336ef0b29fa89a1a508fbc2d3870b5ecff6d3))
* Update dependency jinja2 to v3.1.2 ([#1316](https://github.com/googleapis/java-pubsub/issues/1316)) ([14ecdc6](https://github.com/googleapis/java-pubsub/commit/14ecdc6f3492e404957f1b16744a4928198d9e92))
* Update dependency keyring to v23.9.3 ([#1317](https://github.com/googleapis/java-pubsub/issues/1317)) ([3e783d4](https://github.com/googleapis/java-pubsub/commit/3e783d47e8face65ef33b5bc7ca0bf7f0e35ca02))
* Update dependency markupsafe to v2.1.1 ([#1318](https://github.com/googleapis/java-pubsub/issues/1318)) ([ecd9c76](https://github.com/googleapis/java-pubsub/commit/ecd9c76e2a9cce5c7f9dd6e9a8b84f748f69666a))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.14 ([#1297](https://github.com/googleapis/java-pubsub/issues/1297)) ([7e7ce60](https://github.com/googleapis/java-pubsub/commit/7e7ce60533386afdcd1b313603c468125ad0cb7d))
* Update dependency protobuf to v3.20.2 ([#1319](https://github.com/googleapis/java-pubsub/issues/1319)) ([f5123fa](https://github.com/googleapis/java-pubsub/commit/f5123fa69ec7ac191d13c86823d105332853d944))
* Update dependency pyjwt to v2.5.0 ([#1320](https://github.com/googleapis/java-pubsub/issues/1320)) ([a568462](https://github.com/googleapis/java-pubsub/commit/a568462b971908eb3424c9bbb5f49a6543c80fd3))
* Update dependency requests to v2.28.1 ([#1321](https://github.com/googleapis/java-pubsub/issues/1321)) ([41b105a](https://github.com/googleapis/java-pubsub/commit/41b105a798aa9bcf2ce7ccde34efe119e76d963b))
* Update dependency typing-extensions to v4.3.0 ([#1322](https://github.com/googleapis/java-pubsub/issues/1322)) ([288cd7e](https://github.com/googleapis/java-pubsub/commit/288cd7eaf90e219c735a89822e3858085e8423fd))
* Update dependency zipp to v3.8.1 ([#1323](https://github.com/googleapis/java-pubsub/issues/1323)) ([e78a284](https://github.com/googleapis/java-pubsub/commit/e78a284cf07b9bac56087bbbb9f940ee976a3b4a))

## [1.120.18](https://github.com/googleapis/java-pubsub/compare/v1.120.17...v1.120.18) (2022-09-21)


### Dependencies

* Update dependency com.google.cloud:google-cloud-core to v2.8.13 ([#1288](https://github.com/googleapis/java-pubsub/issues/1288)) ([708a1df](https://github.com/googleapis/java-pubsub/commit/708a1df692b64d86915133ac4ae87e45f4d669d8))
* Update dependency com.google.cloud:google-cloud-core to v2.8.14 ([#1291](https://github.com/googleapis/java-pubsub/issues/1291)) ([1c479de](https://github.com/googleapis/java-pubsub/commit/1c479de525a28fc323697d9a4e92f6ee3215a18f))
* Update dependency org.junit.vintage:junit-vintage-engine to v5.9.1 ([#1289](https://github.com/googleapis/java-pubsub/issues/1289)) ([216ba7d](https://github.com/googleapis/java-pubsub/commit/216ba7db4f0fab29c4bf9fc785387b23f64beb5e))

## [1.120.17](https://github.com/googleapis/java-pubsub/compare/v1.120.16...v1.120.17) (2022-09-20)


### Dependencies

* Update dependency com.google.cloud:google-cloud-bigquery to v2.16.1 ([#1281](https://github.com/googleapis/java-pubsub/issues/1281)) ([aca8ee9](https://github.com/googleapis/java-pubsub/commit/aca8ee98dc74ecc53045f7b84326d85406163338))
* Update dependency com.google.cloud:google-cloud-core to v2.8.12 ([#1278](https://github.com/googleapis/java-pubsub/issues/1278)) ([4ae1156](https://github.com/googleapis/java-pubsub/commit/4ae115666ba195dca90171a7e1ff81bb6cfcf123))
* Update dependency com.google.protobuf:protobuf-java-util to v3.21.6 ([#1277](https://github.com/googleapis/java-pubsub/issues/1277)) ([a5aa281](https://github.com/googleapis/java-pubsub/commit/a5aa281787b7a92516ebcc7654d419d9cbd5abc3))

## [1.120.16](https://github.com/googleapis/java-pubsub/compare/v1.120.15...v1.120.16) (2022-09-15)


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.3 ([#1279](https://github.com/googleapis/java-pubsub/issues/1279)) ([654ea40](https://github.com/googleapis/java-pubsub/commit/654ea400f5df0b2544f4b668e1f5ee72f3ea54d2))

## [1.120.15](https://github.com/googleapis/java-pubsub/compare/v1.120.14...v1.120.15) (2022-09-13)


### Dependencies

* Update dependency com.google.cloud:google-cloud-bigquery to v2.16.0 ([#1271](https://github.com/googleapis/java-pubsub/issues/1271)) ([439215a](https://github.com/googleapis/java-pubsub/commit/439215aaee1572859d323139c7a86e086a331486))

## [1.120.14](https://github.com/googleapis/java-pubsub/compare/v1.120.13...v1.120.14) (2022-09-10)


### Dependencies

* Update dependency com.google.cloud:google-cloud-bigquery to v2.15.0 ([#1259](https://github.com/googleapis/java-pubsub/issues/1259)) ([257cb8f](https://github.com/googleapis/java-pubsub/commit/257cb8f1b38a885dc4c8fb473a79fee1f01a2b57))
* Update dependency com.google.cloud:google-cloud-core to v2.8.10 ([#1258](https://github.com/googleapis/java-pubsub/issues/1258)) ([37e0034](https://github.com/googleapis/java-pubsub/commit/37e0034660855fc327d3843f8aa78bcda03fe158))
* Update dependency com.google.cloud:google-cloud-core to v2.8.11 ([#1264](https://github.com/googleapis/java-pubsub/issues/1264)) ([a19bc7a](https://github.com/googleapis/java-pubsub/commit/a19bc7a6bd54a9223575c23df1cac7b2583eb61a))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.2 ([#1265](https://github.com/googleapis/java-pubsub/issues/1265)) ([52da9da](https://github.com/googleapis/java-pubsub/commit/52da9dae19399e03af8d20c0c29aa600b7e31ed3))

## [1.120.13](https://github.com/googleapis/java-pubsub/compare/v1.120.12...v1.120.13) (2022-08-24)


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v2.14.7 ([#1254](https://github.com/googleapis/java-pubsub/issues/1254)) ([775c993](https://github.com/googleapis/java-pubsub/commit/775c99353d96bcbc0704626999a7af79cf0e557f))

## [1.120.12](https://github.com/googleapis/java-pubsub/compare/v1.120.11...v1.120.12) (2022-08-18)


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v2.14.4 ([#1242](https://github.com/googleapis/java-pubsub/issues/1242)) ([08cfe80](https://github.com/googleapis/java-pubsub/commit/08cfe805e71831e040f63755acde17ec45c21418))
* update dependency com.google.cloud:google-cloud-bigquery to v2.14.6 ([#1245](https://github.com/googleapis/java-pubsub/issues/1245)) ([7f933ee](https://github.com/googleapis/java-pubsub/commit/7f933ee35055c608e9f5b72251583060943a79ea))
* update dependency com.google.cloud:google-cloud-core to v2.8.9 ([#1250](https://github.com/googleapis/java-pubsub/issues/1250)) ([7c8fd41](https://github.com/googleapis/java-pubsub/commit/7c8fd4183523b876983c89d4b7994746b11964c3))
* update dependency com.google.protobuf:protobuf-java-util to v3.21.5 ([#1243](https://github.com/googleapis/java-pubsub/issues/1243)) ([37eaff8](https://github.com/googleapis/java-pubsub/commit/37eaff859422bb215ace202ffd0adf8a651dadb5))

## [1.120.11](https://github.com/googleapis/java-pubsub/compare/v1.120.10...v1.120.11) (2022-08-06)


### Bug Fixes

* fix dependency declaration to properly include runtime scope ([#1238](https://github.com/googleapis/java-pubsub/issues/1238)) ([e9a4ce5](https://github.com/googleapis/java-pubsub/commit/e9a4ce59fdf3773fa41698579984af525a277f38))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v2.14.2 ([#1235](https://github.com/googleapis/java-pubsub/issues/1235)) ([e2af6c3](https://github.com/googleapis/java-pubsub/commit/e2af6c358ef9e7a0d35179bc4a7c793bbc6a0960))
* update dependency com.google.cloud:google-cloud-bigquery to v2.14.3 ([#1236](https://github.com/googleapis/java-pubsub/issues/1236)) ([399e8d7](https://github.com/googleapis/java-pubsub/commit/399e8d71d5b4aed2fa48e8cba2dce963d25693e3))

## [1.120.10](https://github.com/googleapis/java-pubsub/compare/v1.120.9...v1.120.10) (2022-08-04)


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v2.8.8 ([#1231](https://github.com/googleapis/java-pubsub/issues/1231)) ([9d13dd8](https://github.com/googleapis/java-pubsub/commit/9d13dd8bc43e24815884dde421409136958d4b0f))

## [1.120.9](https://github.com/googleapis/java-pubsub/compare/v1.120.8...v1.120.9) (2022-08-03)


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v2.8.7 ([#1227](https://github.com/googleapis/java-pubsub/issues/1227)) ([e967b2c](https://github.com/googleapis/java-pubsub/commit/e967b2c393a601c7e9dfba33ec2f19ef6e9757c1))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.1 ([#1226](https://github.com/googleapis/java-pubsub/issues/1226)) ([8fab566](https://github.com/googleapis/java-pubsub/commit/8fab566e2b0ff726bd9a1dff842b11f5c6c9b00b))

## [1.120.8](https://github.com/googleapis/java-pubsub/compare/v1.120.7...v1.120.8) (2022-08-02)


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v2.8.6 ([#1222](https://github.com/googleapis/java-pubsub/issues/1222)) ([55eebf5](https://github.com/googleapis/java-pubsub/commit/55eebf55785a700a67dc3a97b21837acf14d9a64))

## [1.120.7](https://github.com/googleapis/java-pubsub/compare/v1.120.6...v1.120.7) (2022-08-01)


### Bug Fixes

* Updated log level from WARNING -> INFO for EOD failures ([#1218](https://github.com/googleapis/java-pubsub/issues/1218)) ([8782533](https://github.com/googleapis/java-pubsub/commit/8782533204fcc312c1063763f5073db83c72382f))

## [1.120.6](https://github.com/googleapis/java-pubsub/compare/v1.120.5...v1.120.6) (2022-08-01)


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v2.14.1 ([#1215](https://github.com/googleapis/java-pubsub/issues/1215)) ([5667492](https://github.com/googleapis/java-pubsub/commit/56674928f2e671487c8d4c0dad4e45368da47e0e))
* update dependency com.google.cloud:google-cloud-core to v2.8.5 ([#1213](https://github.com/googleapis/java-pubsub/issues/1213)) ([5db0c2c](https://github.com/googleapis/java-pubsub/commit/5db0c2cafcf27a80ac4e18c623fc22c2af252774))
* update dependency com.google.protobuf:protobuf-java-util to v3.21.4 ([#1214](https://github.com/googleapis/java-pubsub/issues/1214)) ([bfc53d9](https://github.com/googleapis/java-pubsub/commit/bfc53d9fb616b4ee22e2c39dbaf1eed7354142a7))
* update dependency org.apache.avro:avro to v1.11.1 ([#1210](https://github.com/googleapis/java-pubsub/issues/1210)) ([fafcded](https://github.com/googleapis/java-pubsub/commit/fafcdede6b4e5ef5098b8b04a53d9e42b59cda3d))

## [1.120.5](https://github.com/googleapis/java-pubsub/compare/v1.120.4...v1.120.5) (2022-07-30)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v3 ([#1207](https://github.com/googleapis/java-pubsub/issues/1207)) ([d355509](https://github.com/googleapis/java-pubsub/commit/d355509be963b7d2c357d2c9dd3f97eaa5fd8717))

## [1.120.4](https://github.com/googleapis/java-pubsub/compare/v1.120.3...v1.120.4) (2022-07-29)


### Bug Fixes

* updating return types of ack/nack futures to be consistent with publish ([#1204](https://github.com/googleapis/java-pubsub/issues/1204)) ([6e73ab9](https://github.com/googleapis/java-pubsub/commit/6e73ab9618f61ee1915e52abe3b80e356bc3c13f))

## [1.120.3](https://github.com/googleapis/java-pubsub/compare/v1.120.2...v1.120.3) (2022-07-27)


### Dependencies

* update dependency org.junit.vintage:junit-vintage-engine to v5.9.0 ([#1201](https://github.com/googleapis/java-pubsub/issues/1201)) ([f18e562](https://github.com/googleapis/java-pubsub/commit/f18e5628f54b0ae6858cd046a11824a1698c50c6))

## [1.120.2](https://github.com/googleapis/java-pubsub/compare/v1.120.1...v1.120.2) (2022-07-25)


### Bug Fixes

* enable longpaths support for windows test ([#1485](https://github.com/googleapis/java-pubsub/issues/1485)) ([#1191](https://github.com/googleapis/java-pubsub/issues/1191)) ([c4b8d90](https://github.com/googleapis/java-pubsub/commit/c4b8d90a158a3360d626df8ca6378212e09f5a47))
* PubSubMessage leak on MessageDispatcher ([#1197](https://github.com/googleapis/java-pubsub/issues/1197)) ([1b8c440](https://github.com/googleapis/java-pubsub/commit/1b8c440fccc51dc2291c43b2972b1f5c08dfd65a))


### Dependencies

* update dependency org.graalvm.buildtools:junit-platform-native to v0.9.13 ([#1189](https://github.com/googleapis/java-pubsub/issues/1189)) ([0d96f8e](https://github.com/googleapis/java-pubsub/commit/0d96f8e2006c145de039d2f00c5eb1d8830eae3d))
* update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.13 ([#1190](https://github.com/googleapis/java-pubsub/issues/1190)) ([c604080](https://github.com/googleapis/java-pubsub/commit/c6040802bcf97d063e2b91cdb5fa7fe3c3e3b807))

## [1.120.1](https://github.com/googleapis/java-pubsub/compare/v1.120.0...v1.120.1) (2022-07-11)


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v2.13.8 ([#1179](https://github.com/googleapis/java-pubsub/issues/1179)) ([5fc8f86](https://github.com/googleapis/java-pubsub/commit/5fc8f86b30cafaba1acde6f1f807b345e3b3b953))
* update dependency com.google.cloud:google-cloud-core to v2.8.1 ([#1178](https://github.com/googleapis/java-pubsub/issues/1178)) ([0052a6c](https://github.com/googleapis/java-pubsub/commit/0052a6c093030eaefa412cb0a8e35787a9b35c01))
* update dependency com.google.protobuf:protobuf-java-util to v3.21.2 ([#1176](https://github.com/googleapis/java-pubsub/issues/1176)) ([8ffe189](https://github.com/googleapis/java-pubsub/commit/8ffe189170e58cab1de630c41cab6cd8346f98b0))

## [1.120.0](https://github.com/googleapis/java-pubsub/compare/v1.119.1...v1.120.0) (2022-06-30)


### Features

* Enable REST transport for most of Java and Go clients ([#1162](https://github.com/googleapis/java-pubsub/issues/1162)) ([c8ebb13](https://github.com/googleapis/java-pubsub/commit/c8ebb1319b7714c03308d8e7af53912b6b6a0d44))


### Documentation

* **sample:** clean up README of native image sample ([#1166](https://github.com/googleapis/java-pubsub/issues/1166)) ([890987c](https://github.com/googleapis/java-pubsub/commit/890987c0b285c9c5a5224f676e070ceefb90fe02))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v2.13.5 ([#1172](https://github.com/googleapis/java-pubsub/issues/1172)) ([51f4da0](https://github.com/googleapis/java-pubsub/commit/51f4da048e298e6184e9a6bf931a9f1307534c61))
* update dependency com.google.cloud:google-cloud-bigquery to v2.13.6 ([#1175](https://github.com/googleapis/java-pubsub/issues/1175)) ([9385452](https://github.com/googleapis/java-pubsub/commit/938545266b6b15f93fe82aa253b55ca4d4fd7e22))
* update dependency com.google.cloud:google-cloud-core to v2.8.0 ([#1171](https://github.com/googleapis/java-pubsub/issues/1171)) ([4b7888f](https://github.com/googleapis/java-pubsub/commit/4b7888f582752982e2c9e1fd03472f5172fa9910))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.13.0 ([#1173](https://github.com/googleapis/java-pubsub/issues/1173)) ([925be09](https://github.com/googleapis/java-pubsub/commit/925be095bd8a227f4b49d357dcd386b4149a86f9))
* update dependency org.graalvm.buildtools:junit-platform-native to v0.9.12 ([#1169](https://github.com/googleapis/java-pubsub/issues/1169)) ([e8e93e6](https://github.com/googleapis/java-pubsub/commit/e8e93e6c47e2c0a3546453a3aa23263ff3878a55))
* update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.12 ([#1170](https://github.com/googleapis/java-pubsub/issues/1170)) ([1327e89](https://github.com/googleapis/java-pubsub/commit/1327e89e2e491afe0b05fb458bbea296a8ae101f))

## [1.119.1](https://github.com/googleapis/java-pubsub/compare/v1.119.0...v1.119.1) (2022-06-06)


### Dependencies

* update dependency com.google.protobuf:protobuf-java-util to v3.21.0 ([#1152](https://github.com/googleapis/java-pubsub/issues/1152)) ([d015371](https://github.com/googleapis/java-pubsub/commit/d015371c91e22a1c03494da37a2523110c3437e0))
* update dependency com.google.protobuf:protobuf-java-util to v3.21.1 ([#1154](https://github.com/googleapis/java-pubsub/issues/1154)) ([61aeecf](https://github.com/googleapis/java-pubsub/commit/61aeecf6c40ad0b9aa93ea48acc8cca0fe4e3764))

## [1.119.0](https://github.com/googleapis/java-pubsub/compare/v1.118.0...v1.119.0) (2022-05-23)


### Features

* add BigQuery configuration for subscriptions ([#1133](https://github.com/googleapis/java-pubsub/issues/1133)) ([6f271db](https://github.com/googleapis/java-pubsub/commit/6f271db0feadcd338e2c5a0735e3828df5327772))
* add build scripts for native image testing in Java 17 ([#1440](https://github.com/googleapis/java-pubsub/issues/1440)) ([#1145](https://github.com/googleapis/java-pubsub/issues/1145)) ([2f89017](https://github.com/googleapis/java-pubsub/commit/2f89017c4a9737d0db1456b0b9903ec07a9392e8))


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v2.7.1 ([#1141](https://github.com/googleapis/java-pubsub/issues/1141)) ([851a119](https://github.com/googleapis/java-pubsub/commit/851a1190725d381232270bd80f6b82929f680f5f))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.11.0 ([#1142](https://github.com/googleapis/java-pubsub/issues/1142)) ([3cf6d82](https://github.com/googleapis/java-pubsub/commit/3cf6d82f85bdb49f8b5a4f9805506e8a2fafc53c))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.12.0 ([#1148](https://github.com/googleapis/java-pubsub/issues/1148)) ([b5b004b](https://github.com/googleapis/java-pubsub/commit/b5b004b69a0d1154f51233e1e47facc1cd13c716))

## [1.118.0](https://github.com/googleapis/java-pubsub/compare/v1.117.0...v1.118.0) (2022-05-18)


### Features

* creating java backport ([#1120](https://github.com/googleapis/java-pubsub/issues/1120)) ([d88f417](https://github.com/googleapis/java-pubsub/commit/d88f4175356b0fdeb0697cfb1a7e6cd83ac0b7a5))
* next release from main branch is 1.118.0 ([#1127](https://github.com/googleapis/java-pubsub/issues/1127)) ([67605a7](https://github.com/googleapis/java-pubsub/commit/67605a7efb36da5b9e123efb8fe69c58d4cfcbfd))


### Bug Fixes

* Too many leases ([#1135](https://github.com/googleapis/java-pubsub/issues/1135)) ([c9bcec5](https://github.com/googleapis/java-pubsub/commit/c9bcec531bf175684306e50eaf7ef96ee60cba78))

## [1.117.0](https://github.com/googleapis/java-pubsub/compare/v1.116.4...v1.117.0) (2022-05-10)


### Features

* Adding grpc compression support for publisher client ([#1000](https://github.com/googleapis/java-pubsub/issues/1000)) ([4ad1a3f](https://github.com/googleapis/java-pubsub/commit/4ad1a3fc6e334b6b4efe2167dbe6976c5b5625a6))
* AuditConfig for IAM v1 ([a1c9b74](https://github.com/googleapis/java-pubsub/commit/a1c9b7448494f50736b9eb5864d49d38a7936280))


### Bug Fixes

* added exactly once delivery files to owlbot config ([#1106](https://github.com/googleapis/java-pubsub/issues/1106)) ([bb6f105](https://github.com/googleapis/java-pubsub/commit/bb6f105873f94faf564773d821b8d5d01bac94ca))
* adding BetaApi annotation on AckReplyConsumerWithResponse for Exactly Once Delivery ([#1097](https://github.com/googleapis/java-pubsub/issues/1097)) ([0e89054](https://github.com/googleapis/java-pubsub/commit/0e890546727657ddb5cb23e58d9c57dd65d978f2))
* removed beta api annotation for ordering keys ([#1094](https://github.com/googleapis/java-pubsub/issues/1094)) ([3f140fb](https://github.com/googleapis/java-pubsub/commit/3f140fbacf3a157b503b081e7c6964a60ae09466))


### Dependencies

* error_prone_annotations from the shared deps BOM ([#1102](https://github.com/googleapis/java-pubsub/issues/1102)) ([3bb2bec](https://github.com/googleapis/java-pubsub/commit/3bb2bec6534e97b2ee84ac5271819f3aea568a85))
* update dependency com.google.protobuf:protobuf-java-util to v3.20.1 ([#1100](https://github.com/googleapis/java-pubsub/issues/1100)) ([063b7aa](https://github.com/googleapis/java-pubsub/commit/063b7aa3e10fc4f74278fc36c73af8ac68dce26d))


### Documentation

* **sample:** remove unused native-image-support dependency ([#1103](https://github.com/googleapis/java-pubsub/issues/1103)) ([e7d9000](https://github.com/googleapis/java-pubsub/commit/e7d9000cd0c236d5ff222e13ca3bc25911aa9bd9))

### [1.116.4](https://github.com/googleapis/java-pubsub/compare/v1.116.3...v1.116.4) (2022-04-19)


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v2.6.1 ([#1084](https://github.com/googleapis/java-pubsub/issues/1084)) ([b1c4d89](https://github.com/googleapis/java-pubsub/commit/b1c4d899e98fc58bdcd6a38b4544497e65ca591d))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.10.0 ([#1085](https://github.com/googleapis/java-pubsub/issues/1085)) ([4826dcb](https://github.com/googleapis/java-pubsub/commit/4826dcb4ce80e165a4c2c7e65a8d6931ebb0abc9))
* update dependency com.google.cloud:native-image-support to v0.13.1 ([#1086](https://github.com/googleapis/java-pubsub/issues/1086)) ([98c7b2b](https://github.com/googleapis/java-pubsub/commit/98c7b2be08e80744b6bc8e38c327e3874b755df9))
* update dependency com.google.errorprone:error_prone_annotations to v2.12.1 ([#1080](https://github.com/googleapis/java-pubsub/issues/1080)) ([d13bd94](https://github.com/googleapis/java-pubsub/commit/d13bd94074740b870c90a216715dfe18bbd6c248))
* update dependency com.google.errorprone:error_prone_annotations to v2.13.0 ([#1083](https://github.com/googleapis/java-pubsub/issues/1083)) ([3b8cbcb](https://github.com/googleapis/java-pubsub/commit/3b8cbcbee1b7451adcdf1305d90960f682889c44))
* update dependency com.google.errorprone:error_prone_annotations to v2.13.1 ([#1087](https://github.com/googleapis/java-pubsub/issues/1087)) ([34121f0](https://github.com/googleapis/java-pubsub/commit/34121f0d9943735a231d4c1e045df4f7e822268e))
* update dependency com.google.protobuf:protobuf-java-util to v3.20.0 ([#1078](https://github.com/googleapis/java-pubsub/issues/1078)) ([b064d6c](https://github.com/googleapis/java-pubsub/commit/b064d6ca8b2b1e6e083dc273073b3734d434ef8c))

### [1.116.3](https://github.com/googleapis/java-pubsub/compare/v1.116.2...v1.116.3) (2022-03-29)


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v2.5.11 ([#1070](https://github.com/googleapis/java-pubsub/issues/1070)) ([662e2ec](https://github.com/googleapis/java-pubsub/commit/662e2ec8c4130c237bcfc61efe2e42a9912c8df0))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.9.0 ([#1072](https://github.com/googleapis/java-pubsub/issues/1072)) ([56f9e91](https://github.com/googleapis/java-pubsub/commit/56f9e91b3accdf59b077771141fd42d09ebecdf1))
* update dependency com.google.cloud:native-image-support to v0.12.11 ([#1071](https://github.com/googleapis/java-pubsub/issues/1071)) ([82f4501](https://github.com/googleapis/java-pubsub/commit/82f4501b84ea97b2903f51d8cae2011c1b96abf4))

### [1.116.2](https://github.com/googleapis/java-pubsub/compare/v1.116.1...v1.116.2) (2022-03-24)


### Dependencies

* update dependency org.graalvm.buildtools:junit-platform-native to v0.9.11 ([#1064](https://github.com/googleapis/java-pubsub/issues/1064)) ([3ebcc5e](https://github.com/googleapis/java-pubsub/commit/3ebcc5e262bf420fd2ba36f26d8b6350b56f989d))
* update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.11 ([#1065](https://github.com/googleapis/java-pubsub/issues/1065)) ([d1ce9c6](https://github.com/googleapis/java-pubsub/commit/d1ce9c6cc9fc9c8030c117bff1b0d2d8e317107c))

### [1.116.1](https://github.com/googleapis/java-pubsub/compare/v1.116.0...v1.116.1) (2022-03-22)


### Bug Fixes

* added a maximum metadata size when creating the subscriber ([#1061](https://github.com/googleapis/java-pubsub/issues/1061)) ([3a8c83b](https://github.com/googleapis/java-pubsub/commit/3a8c83b973a1dfbae2ca037125574d74034218ce))
* Removed EnableExactlyOnceDelivery from Builders ([#1052](https://github.com/googleapis/java-pubsub/issues/1052)) ([9add538](https://github.com/googleapis/java-pubsub/commit/9add53894981d862ac1348d0b641e472b3b3aa79))


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v2.5.10 ([#1057](https://github.com/googleapis/java-pubsub/issues/1057)) ([0b7d19f](https://github.com/googleapis/java-pubsub/commit/0b7d19fe39326c36152267e4d2a13a2b51530ac2))
* update dependency com.google.cloud:google-cloud-core to v2.5.8 ([#1050](https://github.com/googleapis/java-pubsub/issues/1050)) ([c7551d6](https://github.com/googleapis/java-pubsub/commit/c7551d621343eac4476a16579763e3aab7f71ea9))
* update dependency com.google.cloud:google-cloud-core to v2.5.9 ([#1054](https://github.com/googleapis/java-pubsub/issues/1054)) ([5b3227f](https://github.com/googleapis/java-pubsub/commit/5b3227f4013a5121a3db34702f90be5a9ba41748))
* update dependency com.google.cloud:native-image-support to v0.12.10 ([#1058](https://github.com/googleapis/java-pubsub/issues/1058)) ([af2b364](https://github.com/googleapis/java-pubsub/commit/af2b3640eb22e8e78f5beea07a73e2b3127cce71))
* update dependency com.google.cloud:native-image-support to v0.12.7 ([#1042](https://github.com/googleapis/java-pubsub/issues/1042)) ([fd52aa8](https://github.com/googleapis/java-pubsub/commit/fd52aa8ffaa4d7cb8e0ad19bb6993b5616eb81df))
* update dependency com.google.cloud:native-image-support to v0.12.8 ([#1051](https://github.com/googleapis/java-pubsub/issues/1051)) ([da2d3fa](https://github.com/googleapis/java-pubsub/commit/da2d3fa91fe4f07455fbe0aa3ccac15e456666c7))
* update dependency com.google.cloud:native-image-support to v0.12.9 ([#1053](https://github.com/googleapis/java-pubsub/issues/1053)) ([6e97d52](https://github.com/googleapis/java-pubsub/commit/6e97d5222994dc567bc24ab3457f3431ed000134))
* update dependency org.graalvm.buildtools:junit-platform-native to v0.9.10 ([#1043](https://github.com/googleapis/java-pubsub/issues/1043)) ([5884bdf](https://github.com/googleapis/java-pubsub/commit/5884bdfafc5ee621935b620e763ca6c0adf67ff7))
* update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.10 ([#1044](https://github.com/googleapis/java-pubsub/issues/1044)) ([158e7f8](https://github.com/googleapis/java-pubsub/commit/158e7f884660a312b7168cecfa85cf594071a7be))


### Documentation

* **sample:** Add sample for Native Image support in Pub/Sub ([#1026](https://github.com/googleapis/java-pubsub/issues/1026)) ([a4fa69b](https://github.com/googleapis/java-pubsub/commit/a4fa69b99f34304f7ee7a56fb3c633f018905f09))
* **sample:** use Java 8 for native image sample ([#1060](https://github.com/googleapis/java-pubsub/issues/1060)) ([2d5c010](https://github.com/googleapis/java-pubsub/commit/2d5c0109fe797698749d2c198cbb5a8a1a9d11dc))

## [1.116.0](https://github.com/googleapis/java-pubsub/compare/v1.115.5...v1.116.0) (2022-03-04)


### Features

* exactly once support v3 ([#1022](https://github.com/googleapis/java-pubsub/issues/1022)) ([02ed621](https://github.com/googleapis/java-pubsub/commit/02ed621f5ca6c96e1bb63cd9a5ed137896313c4f))


### Bug Fixes

* removing misspelled field, add correctly spelled field ([#1011](https://github.com/googleapis/java-pubsub/issues/1011)) ([2e8b681](https://github.com/googleapis/java-pubsub/commit/2e8b68111c1d50a5322ad1fdc5d3b93561090e98))


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v2.5.4 ([#1017](https://github.com/googleapis/java-pubsub/issues/1017)) ([55c53e3](https://github.com/googleapis/java-pubsub/commit/55c53e34448a0fda7c4ea1fb087bd2dc2dc8e163))
* update dependency com.google.cloud:google-cloud-core to v2.5.6 ([#1038](https://github.com/googleapis/java-pubsub/issues/1038)) ([c319f59](https://github.com/googleapis/java-pubsub/commit/c319f59f26973dbb0b88f9ccd6c60b3e480392a8))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.8.0 ([#1035](https://github.com/googleapis/java-pubsub/issues/1035)) ([10dba36](https://github.com/googleapis/java-pubsub/commit/10dba36088a54860061d5435ac51ef7101eec891))

### [1.115.5](https://github.com/googleapis/java-pubsub/compare/v1.115.4...v1.115.5) (2022-02-11)


### Dependencies

* update actions/github-script action to v6 ([#1010](https://github.com/googleapis/java-pubsub/issues/1010)) ([04ee4c9](https://github.com/googleapis/java-pubsub/commit/04ee4c98bd2c09bbb58bc73c501386c2e7fc927d))
* update dependency com.google.cloud:google-cloud-core to v2.5.3 ([#1008](https://github.com/googleapis/java-pubsub/issues/1008)) ([0eacfb0](https://github.com/googleapis/java-pubsub/commit/0eacfb0b54f82cf05aa3d100a59d11c5fe0c40ae))

### [1.115.4](https://github.com/googleapis/java-pubsub/compare/v1.115.3...v1.115.4) (2022-02-10)


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v2.5.1 ([#1004](https://github.com/googleapis/java-pubsub/issues/1004)) ([8f6879b](https://github.com/googleapis/java-pubsub/commit/8f6879b8021bf8e6b351249a0352fd0537110fcd))

### [1.115.3](https://github.com/googleapis/java-pubsub/compare/v1.115.2...v1.115.3) (2022-02-08)


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v2.5.0 ([#995](https://github.com/googleapis/java-pubsub/issues/995)) ([3b3b90a](https://github.com/googleapis/java-pubsub/commit/3b3b90ad1cf520fa8cdfea180002745789ebfce9))

### [1.115.2](https://github.com/googleapis/java-pubsub/compare/v1.115.1...v1.115.2) (2022-02-03)


### Dependencies

* **java:** update actions/github-script action to v5 ([#1339](https://github.com/googleapis/java-pubsub/issues/1339)) ([#984](https://github.com/googleapis/java-pubsub/issues/984)) ([9a1cc0e](https://github.com/googleapis/java-pubsub/commit/9a1cc0eaf344e2f9cded1c331b0e71543f20ef65))
* update dependency com.google.cloud:google-cloud-core to v2.4.0 ([#986](https://github.com/googleapis/java-pubsub/issues/986)) ([8cdf7a0](https://github.com/googleapis/java-pubsub/commit/8cdf7a0b1dffa1c01e9c739d79af552e6b42796e))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.7.0 ([#988](https://github.com/googleapis/java-pubsub/issues/988)) ([8993760](https://github.com/googleapis/java-pubsub/commit/89937606134be8e0eb8b7669c6243f1f3b8a9aad))
* update dependency com.google.errorprone:error_prone_annotations to v2.11.0 ([#983](https://github.com/googleapis/java-pubsub/issues/983)) ([abcbb32](https://github.com/googleapis/java-pubsub/commit/abcbb32e442948ff4637df8b657a7f8a0abd3062))
* update dependency com.google.protobuf:protobuf-java-util to v3.19.3 ([#973](https://github.com/googleapis/java-pubsub/issues/973)) ([13a9f96](https://github.com/googleapis/java-pubsub/commit/13a9f9645661324cc26b23b9eca5d833bf9d089f))
* update dependency com.google.protobuf:protobuf-java-util to v3.19.4 ([#987](https://github.com/googleapis/java-pubsub/issues/987)) ([ff71dc7](https://github.com/googleapis/java-pubsub/commit/ff71dc73c9950973512920073a0f0491527a0678))

### [1.115.1](https://www.github.com/googleapis/java-pubsub/compare/v1.115.0...v1.115.1) (2022-01-07)


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v2.3.4 ([#955](https://www.github.com/googleapis/java-pubsub/issues/955)) ([b39ecd5](https://www.github.com/googleapis/java-pubsub/commit/b39ecd5db18c99461206b287eb403199eea7a654))
* update dependency com.google.cloud:google-cloud-core to v2.3.5 ([#959](https://www.github.com/googleapis/java-pubsub/issues/959)) ([5efec45](https://www.github.com/googleapis/java-pubsub/commit/5efec45e1761b642bcef309a45de4342e0f553f7))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.6.0 ([#957](https://www.github.com/googleapis/java-pubsub/issues/957)) ([b562ce8](https://www.github.com/googleapis/java-pubsub/commit/b562ce8550d227d99352df17c5c01221153f94fd))
* update dependency com.google.protobuf:protobuf-java-util to v3.19.2 ([#954](https://www.github.com/googleapis/java-pubsub/issues/954)) ([a1ac149](https://www.github.com/googleapis/java-pubsub/commit/a1ac1491f0c682da6d84e69477823d2446a9c475))

## [1.115.0](https://www.github.com/googleapis/java-pubsub/compare/v1.114.7...v1.115.0) (2021-12-05)


### Features

* creating java backport ([#895](https://www.github.com/googleapis/java-pubsub/issues/895)) ([51b01e2](https://www.github.com/googleapis/java-pubsub/commit/51b01e254a4be87a8a779fbc5da697c70920d82f))


### Bug Fixes

* **java:** java 17 dependency arguments ([#1266](https://www.github.com/googleapis/java-pubsub/issues/1266)) ([#888](https://www.github.com/googleapis/java-pubsub/issues/888)) ([ed3ae2f](https://www.github.com/googleapis/java-pubsub/commit/ed3ae2fb0a0c72073f6bae5dc4111424740fd883))


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v2.3.0 ([#913](https://www.github.com/googleapis/java-pubsub/issues/913)) ([adfd456](https://www.github.com/googleapis/java-pubsub/commit/adfd4562a8041d71af65cd98cf1d17b881e35dd3))
* update dependency com.google.cloud:google-cloud-core to v2.3.1 ([#927](https://www.github.com/googleapis/java-pubsub/issues/927)) ([9fcc996](https://www.github.com/googleapis/java-pubsub/commit/9fcc9965284f6a57dc79f31eb96a2e430cef72e4))
* update dependency com.google.cloud:google-cloud-core to v2.3.2 ([#941](https://www.github.com/googleapis/java-pubsub/issues/941)) ([41f881b](https://www.github.com/googleapis/java-pubsub/commit/41f881b2d075f9ee730f5eaf24885146d9fadccf))
* update dependency com.google.cloud:google-cloud-core to v2.3.3 ([#943](https://www.github.com/googleapis/java-pubsub/issues/943)) ([df3a5fe](https://www.github.com/googleapis/java-pubsub/commit/df3a5fecd4d87ae79cba312109242146b84f9e55))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.5.0 ([#919](https://www.github.com/googleapis/java-pubsub/issues/919)) ([4adf335](https://www.github.com/googleapis/java-pubsub/commit/4adf335b78ce6b13af22c3c3a64c4ea1a24f05cd))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.5.1 ([#942](https://www.github.com/googleapis/java-pubsub/issues/942)) ([44cdcf5](https://www.github.com/googleapis/java-pubsub/commit/44cdcf5d3f1815654b9b255c1096e290a7db9030))
* update dependency com.google.errorprone:error_prone_annotations to v2.10.0 ([#901](https://www.github.com/googleapis/java-pubsub/issues/901)) ([8733144](https://www.github.com/googleapis/java-pubsub/commit/8733144854aaebfec0cd5f03ab14d820c6d22c0e))
* update dependency com.google.protobuf:protobuf-java-util to v3.19.1 ([#885](https://www.github.com/googleapis/java-pubsub/issues/885)) ([d0a02a9](https://www.github.com/googleapis/java-pubsub/commit/d0a02a9f320b254a3e4ef60bfff47a6bb3a2427f))
* update dependency org.apache.avro:avro to v1.11.0 ([#894](https://www.github.com/googleapis/java-pubsub/issues/894)) ([b7ba1a8](https://www.github.com/googleapis/java-pubsub/commit/b7ba1a871c4c26f50d87b41c2627b6e6aef63b3c))
* update gson to 2.8.9 ([ec97e93](https://www.github.com/googleapis/java-pubsub/commit/ec97e93ae53666d5c5cad71821f12cefa4fbaf2e))

### [1.114.7](https://www.github.com/googleapis/java-pubsub/compare/v1.114.6...v1.114.7) (2021-10-19)


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v2.1.8 ([#877](https://www.github.com/googleapis/java-pubsub/issues/877)) ([c76329b](https://www.github.com/googleapis/java-pubsub/commit/c76329b06f2f620662f4fe4ffefa897daea8703b))
* update dependency com.google.cloud:google-cloud-core to v2.2.0 ([#881](https://www.github.com/googleapis/java-pubsub/issues/881)) ([1eb4a1f](https://www.github.com/googleapis/java-pubsub/commit/1eb4a1f0a7d318b88cd04f4aefd3191f289e8a0f))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.4.0 ([#882](https://www.github.com/googleapis/java-pubsub/issues/882)) ([2c367bb](https://www.github.com/googleapis/java-pubsub/commit/2c367bb22860cbbfa57fca70a436919ac6aa8084))

### [1.114.6](https://www.github.com/googleapis/java-pubsub/compare/v1.114.5...v1.114.6) (2021-10-05)


### Dependencies

* update dependency com.google.protobuf:protobuf-java-util to v3.18.1 ([#870](https://www.github.com/googleapis/java-pubsub/issues/870)) ([5188e39](https://www.github.com/googleapis/java-pubsub/commit/5188e39a13b97d9fa943c89d9082f58afa3d9d98))

### [1.114.5](https://www.github.com/googleapis/java-pubsub/compare/v1.114.4...v1.114.5) (2021-09-27)


### Bug Fixes

* do not block forever if message size > flow control limits ([#847](https://www.github.com/googleapis/java-pubsub/issues/847)) ([f4ca4b2](https://www.github.com/googleapis/java-pubsub/commit/f4ca4b2d12730d5cef64d6f986b140de2c51147d))
* reset resource ids before test retries ([#852](https://www.github.com/googleapis/java-pubsub/issues/852)) ([3769e53](https://www.github.com/googleapis/java-pubsub/commit/3769e53225e1c4e32a1a0d5179c2a333258d69a8))


### Documentation

* **samples:** add readme ([#849](https://www.github.com/googleapis/java-pubsub/issues/849)) ([66135cf](https://www.github.com/googleapis/java-pubsub/commit/66135cf20c4d3c3ffc881b52f0273a14881ac97b))


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v2.1.5 ([#854](https://www.github.com/googleapis/java-pubsub/issues/854)) ([374b8c3](https://www.github.com/googleapis/java-pubsub/commit/374b8c3f25aedd9ebdbb0d8075a201c482dadd40))
* update dependency com.google.cloud:google-cloud-core to v2.1.6 ([#855](https://www.github.com/googleapis/java-pubsub/issues/855)) ([9fabfc3](https://www.github.com/googleapis/java-pubsub/commit/9fabfc3177ebb08082557803801ade0e12e2e36d))
* update dependency com.google.cloud:google-cloud-core to v2.1.7 ([#858](https://www.github.com/googleapis/java-pubsub/issues/858)) ([2cd94b5](https://www.github.com/googleapis/java-pubsub/commit/2cd94b57529f683465c8fd969cbf4a435d214b60))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.3.0 ([#856](https://www.github.com/googleapis/java-pubsub/issues/856)) ([ab47c15](https://www.github.com/googleapis/java-pubsub/commit/ab47c15a92978fbc994ed2db02ad1f24ed640fd0))

### [1.114.4](https://www.github.com/googleapis/java-pubsub/compare/v1.114.3...v1.114.4) (2021-09-17)


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v2.1.4 ([#835](https://www.github.com/googleapis/java-pubsub/issues/835)) ([2ab94ab](https://www.github.com/googleapis/java-pubsub/commit/2ab94abdc18c010496c50827c1f2eff02dae68e0))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.2.1 ([#836](https://www.github.com/googleapis/java-pubsub/issues/836)) ([39770c9](https://www.github.com/googleapis/java-pubsub/commit/39770c9a6641273e4839b758d67ecbf2abd3a63f))
* update dependency com.google.protobuf:protobuf-java-util to v3.18.0 ([#841](https://www.github.com/googleapis/java-pubsub/issues/841)) ([f5d515c](https://www.github.com/googleapis/java-pubsub/commit/f5d515c718c39dcfb5bf9375e624c1b1c28eb892))

### [1.114.3](https://www.github.com/googleapis/java-pubsub/compare/v1.114.2...v1.114.3) (2021-08-31)


### Bug Fixes

* Set publish timeouts to be consistent with desired values ([#820](https://www.github.com/googleapis/java-pubsub/issues/820)) ([826dc10](https://www.github.com/googleapis/java-pubsub/commit/826dc10f5bb373e88b06d390fc2029960a2cad7c))


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v2.1.2 ([#823](https://www.github.com/googleapis/java-pubsub/issues/823)) ([cc0786f](https://www.github.com/googleapis/java-pubsub/commit/cc0786f0c8e8c88df15563204953ff8870244fd5))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.2.0 ([#824](https://www.github.com/googleapis/java-pubsub/issues/824)) ([32623af](https://www.github.com/googleapis/java-pubsub/commit/32623af172e367b61a5bcb10c0001d5488b1e772))

### [1.114.2](https://www.github.com/googleapis/java-pubsub/compare/v1.114.1...v1.114.2) (2021-08-24)


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v2.1.1 ([#813](https://www.github.com/googleapis/java-pubsub/issues/813)) ([e7b0c3c](https://www.github.com/googleapis/java-pubsub/commit/e7b0c3c002e816027c945cac4487394cefd26892))

### [1.114.1](https://www.github.com/googleapis/java-pubsub/compare/v1.114.0...v1.114.1) (2021-08-23)


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v2.1.0 ([#806](https://www.github.com/googleapis/java-pubsub/issues/806)) ([744eacd](https://www.github.com/googleapis/java-pubsub/commit/744eacd007c9de224790b75eb5c060acaf6245ec))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.1.0 ([#807](https://www.github.com/googleapis/java-pubsub/issues/807)) ([e88ff93](https://www.github.com/googleapis/java-pubsub/commit/e88ff93b0fc476f27221d9e5e4c81811a26815ac))

## [1.114.0](https://www.github.com/googleapis/java-pubsub/compare/v1.113.9...v1.114.0) (2021-08-23)


### Features

* add topic retention support ([#803](https://www.github.com/googleapis/java-pubsub/issues/803)) ([898faf8](https://www.github.com/googleapis/java-pubsub/commit/898faf810276901c4ea878278ec55b80664098f7))


### Dependencies

* update dependency com.google.errorprone:error_prone_annotations to v2.9.0 ([#797](https://www.github.com/googleapis/java-pubsub/issues/797)) ([70bb91d](https://www.github.com/googleapis/java-pubsub/commit/70bb91d7a5cbb6da82837d7bd42a08b4b4fe648e))

### [1.113.9](https://www.github.com/googleapis/java-pubsub/compare/v1.113.8...v1.113.9) (2021-08-11)


### Dependencies

* update dependency com.google.api.grpc:grpc-google-cloud-pubsub-v1 to v1.96.0 ([#786](https://www.github.com/googleapis/java-pubsub/issues/786)) ([57c3c2b](https://www.github.com/googleapis/java-pubsub/commit/57c3c2bfd467fd02a03ec581d9254fe3c9c68f8b))
* update dependency com.google.api.grpc:proto-google-cloud-pubsub-v1 to v1.96.0 ([#787](https://www.github.com/googleapis/java-pubsub/issues/787)) ([7940378](https://www.github.com/googleapis/java-pubsub/commit/7940378db1394e3c5631ec854fa57b35cfb12094))
* update dependency com.google.cloud:google-cloud-core to v2.0.5 ([#783](https://www.github.com/googleapis/java-pubsub/issues/783)) ([de3d475](https://www.github.com/googleapis/java-pubsub/commit/de3d47544bfe370330dd6b569927cf77204201bf))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.0.1 ([#788](https://www.github.com/googleapis/java-pubsub/issues/788)) ([5d39f85](https://www.github.com/googleapis/java-pubsub/commit/5d39f850040a2c60c5c87a7669f924121e0b8b0a))

### [1.113.8](https://www.github.com/googleapis/java-pubsub/compare/v1.113.7...v1.113.8) (2021-08-11)


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v2.0.4 ([#772](https://www.github.com/googleapis/java-pubsub/issues/772)) ([37cb279](https://www.github.com/googleapis/java-pubsub/commit/37cb2797cfce84e53b56b37de19c9b467eca91c4))

### [1.113.7](https://www.github.com/googleapis/java-pubsub/compare/v1.113.6...v1.113.7) (2021-08-11)


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v2.0.3 ([#768](https://www.github.com/googleapis/java-pubsub/issues/768)) ([2ba610b](https://www.github.com/googleapis/java-pubsub/commit/2ba610bb1134b43c641608364248c794eec5a295))

### [1.113.6](https://www.github.com/googleapis/java-pubsub/compare/v1.113.5...v1.113.6) (2021-08-06)


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v2 ([#759](https://www.github.com/googleapis/java-pubsub/issues/759)) ([9afc2a3](https://www.github.com/googleapis/java-pubsub/commit/9afc2a3d0b94cf71feda5fed23841bdb7814f422))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2 ([#762](https://www.github.com/googleapis/java-pubsub/issues/762)) ([ee939c2](https://www.github.com/googleapis/java-pubsub/commit/ee939c2166ec3dfea0e6132f6198e3a7693659a1))
* update dependency com.google.errorprone:error_prone_annotations to v2.8.0 ([#745](https://www.github.com/googleapis/java-pubsub/issues/745)) ([554d602](https://www.github.com/googleapis/java-pubsub/commit/554d60273b53ab4a06b13fa0c39b13e3c3e815e1))
* update dependency com.google.errorprone:error_prone_annotations to v2.8.1 ([#758](https://www.github.com/googleapis/java-pubsub/issues/758)) ([09650e4](https://www.github.com/googleapis/java-pubsub/commit/09650e4d1201be0c738b8853d9271084c808c2be))

### [1.113.5](https://www.github.com/googleapis/java-pubsub/compare/v1.113.4...v1.113.5) (2021-07-02)


### Bug Fixes

* Add `shopt -s nullglob` to dependencies script ([#724](https://www.github.com/googleapis/java-pubsub/issues/724)) ([25840d6](https://www.github.com/googleapis/java-pubsub/commit/25840d60c62123b71c64e3b2fea2b33d4c4c2fb4))


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v1.95.3 ([#725](https://www.github.com/googleapis/java-pubsub/issues/725)) ([ae3b284](https://www.github.com/googleapis/java-pubsub/commit/ae3b2840eb25458d054c25a3c9879a8a5aa8883a))
* update dependency com.google.cloud:google-cloud-core to v1.95.4 ([#730](https://www.github.com/googleapis/java-pubsub/issues/730)) ([b6453b3](https://www.github.com/googleapis/java-pubsub/commit/b6453b3026184e757a6f29c1baeece14ca4cc4f2))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.4.0 ([#732](https://www.github.com/googleapis/java-pubsub/issues/732)) ([78b26c0](https://www.github.com/googleapis/java-pubsub/commit/78b26c0de4a11b88295c2861917ee354e2793bf8))

### [1.113.4](https://www.github.com/googleapis/java-pubsub/compare/v1.113.3...v1.113.4) (2021-06-22)


### Bug Fixes

* allow retries for subscriber unary rpcs ([#721](https://www.github.com/googleapis/java-pubsub/issues/721)) ([3f0a6d2](https://www.github.com/googleapis/java-pubsub/commit/3f0a6d2474dcbac604991c45298c7b89fefa27a7))
* Update dependencies.sh to not break on mac ([#718](https://www.github.com/googleapis/java-pubsub/issues/718)) ([0ebad0a](https://www.github.com/googleapis/java-pubsub/commit/0ebad0a2c92f00126d9c00aec1af3c73333c3a31))

### [1.113.3](https://www.github.com/googleapis/java-pubsub/compare/v1.113.2...v1.113.3) (2021-06-09)


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v1.95.2 ([#707](https://www.github.com/googleapis/java-pubsub/issues/707)) ([60c7a68](https://www.github.com/googleapis/java-pubsub/commit/60c7a68fefd54525958c3b195142d8613405f5d2))

### [1.113.2](https://www.github.com/googleapis/java-pubsub/compare/v1.113.1...v1.113.2) (2021-06-09)


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v1.95.1 ([#701](https://www.github.com/googleapis/java-pubsub/issues/701)) ([c91e208](https://www.github.com/googleapis/java-pubsub/commit/c91e208efd04218dd5dd4f69743307375c8d6f06))
* update dependency com.google.protobuf:protobuf-java-util to v3.17.3 ([#700](https://www.github.com/googleapis/java-pubsub/issues/700)) ([60f9b8d](https://www.github.com/googleapis/java-pubsub/commit/60f9b8d950d20a7b5a0fccad082d9014cd44d20c))

### [1.113.1](https://www.github.com/googleapis/java-pubsub/compare/v1.113.0...v1.113.1) (2021-06-07)


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v1.95.0 ([#691](https://www.github.com/googleapis/java-pubsub/issues/691)) ([bc75411](https://www.github.com/googleapis/java-pubsub/commit/bc754112599c744374f95237bb7e9b8b4d374531))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.3.0 ([#692](https://www.github.com/googleapis/java-pubsub/issues/692)) ([1ba00a2](https://www.github.com/googleapis/java-pubsub/commit/1ba00a2da7ecd8447a182ae2f9c644c7b01fe8bd))
* update dependency com.google.protobuf:protobuf-java-util to v3.17.2 ([#690](https://www.github.com/googleapis/java-pubsub/issues/690)) ([2ac440c](https://www.github.com/googleapis/java-pubsub/commit/2ac440cbb55dd24d5783fb74b77b5dfc97aed951))

## [1.113.0](https://www.github.com/googleapis/java-pubsub/compare/v1.112.5...v1.113.0) (2021-05-31)


### Features

* add `gcf-owl-bot[bot]` to `ignoreAuthors` ([#673](https://www.github.com/googleapis/java-pubsub/issues/673)) ([51dfca3](https://www.github.com/googleapis/java-pubsub/commit/51dfca3049f87e8bc1163c03eaef0556be3eefdf))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.2.0 ([#672](https://www.github.com/googleapis/java-pubsub/issues/672)) ([2cc9ec5](https://www.github.com/googleapis/java-pubsub/commit/2cc9ec5f1418f23a89129bdfc038dcf461097b88))
* update dependency com.google.errorprone:error_prone_annotations to v2.7.1 ([#667](https://www.github.com/googleapis/java-pubsub/issues/667)) ([885be5c](https://www.github.com/googleapis/java-pubsub/commit/885be5c37992b8b1175c55b407db0f833241a0d1))
* update dependency com.google.protobuf:protobuf-java-util to v3.17.1 ([#679](https://www.github.com/googleapis/java-pubsub/issues/679)) ([e7ef708](https://www.github.com/googleapis/java-pubsub/commit/e7ef7088999f60dc8bd5268c0315a8e1e4639ae0))

### [1.112.5](https://www.github.com/googleapis/java-pubsub/compare/v1.112.4...v1.112.5) (2021-05-14)


### Dependencies

* update dependency com.google.protobuf:protobuf-java-util to v3.17.0 ([#660](https://www.github.com/googleapis/java-pubsub/issues/660)) ([5f33acf](https://www.github.com/googleapis/java-pubsub/commit/5f33acf204bd5d3a62eb06fc64a4ad779458ed82))

### [1.112.4](https://www.github.com/googleapis/java-pubsub/compare/v1.112.3...v1.112.4) (2021-05-12)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.1.0 ([#651](https://www.github.com/googleapis/java-pubsub/issues/651)) ([96ab1d4](https://www.github.com/googleapis/java-pubsub/commit/96ab1d4ea484215fb951704d0d2f0dbbf2802544))
* update dependency com.google.protobuf:protobuf-java-util to v3.16.0 ([#647](https://www.github.com/googleapis/java-pubsub/issues/647)) ([7fcc503](https://www.github.com/googleapis/java-pubsub/commit/7fcc503a790d28f3d07e07c0ca286a1ee031f38b))

### [1.112.3](https://www.github.com/googleapis/java-pubsub/compare/v1.112.2...v1.112.3) (2021-04-26)


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v1.94.8 ([#624](https://www.github.com/googleapis/java-pubsub/issues/624)) ([e1d6632](https://www.github.com/googleapis/java-pubsub/commit/e1d663262b618223d021f8304718f4b939423002))

### [1.112.2](https://www.github.com/googleapis/java-pubsub/compare/v1.112.1...v1.112.2) (2021-04-24)


### Bug Fixes

* release scripts from issuing overlapping phases ([#610](https://www.github.com/googleapis/java-pubsub/issues/610)) ([70246e8](https://www.github.com/googleapis/java-pubsub/commit/70246e8fd24c7e85b0384d99bd3895094383ff5e))
* typo ([#603](https://www.github.com/googleapis/java-pubsub/issues/603)) ([60b087d](https://www.github.com/googleapis/java-pubsub/commit/60b087d2e2afbadaff5dd0a3b946d46b61acbf95))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.21.1 ([#614](https://www.github.com/googleapis/java-pubsub/issues/614)) ([61e2ea1](https://www.github.com/googleapis/java-pubsub/commit/61e2ea112a4d44219adb20f087e7847114be4261))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1 ([#626](https://www.github.com/googleapis/java-pubsub/issues/626)) ([a9884a9](https://www.github.com/googleapis/java-pubsub/commit/a9884a9beede67ce90616be2f1bdd7da1aa6f867))
* update dependency org.easymock:easymock to v4.3 ([#612](https://www.github.com/googleapis/java-pubsub/issues/612)) ([b08e816](https://www.github.com/googleapis/java-pubsub/commit/b08e81604341381543b13f68bb0695c55d0a7575))

### [1.112.1](https://www.github.com/googleapis/java-pubsub/compare/v1.112.0...v1.112.1) (2021-04-12)


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v1.94.6 ([#590](https://www.github.com/googleapis/java-pubsub/issues/590)) ([902b149](https://www.github.com/googleapis/java-pubsub/commit/902b149b04d5d74b84051c4b09e54b14df20f6a2))
* update dependency com.google.cloud:google-cloud-core to v1.94.7 ([#597](https://www.github.com/googleapis/java-pubsub/issues/597)) ([312966d](https://www.github.com/googleapis/java-pubsub/commit/312966d58c494864d57821ed1a75c84fd3de1aab))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.21.0 ([#592](https://www.github.com/googleapis/java-pubsub/issues/592)) ([f81b792](https://www.github.com/googleapis/java-pubsub/commit/f81b7929659b03d620789fef5dfc9e8fcb418c66))
* update dependency com.google.errorprone:error_prone_annotations to v2.6.0 ([#585](https://www.github.com/googleapis/java-pubsub/issues/585)) ([8316bce](https://www.github.com/googleapis/java-pubsub/commit/8316bced8cf506a470c2f07cc578eda86305dd4e))
* update dependency com.google.protobuf:protobuf-java-util to v3.15.7 ([#586](https://www.github.com/googleapis/java-pubsub/issues/586)) ([616e77d](https://www.github.com/googleapis/java-pubsub/commit/616e77df843a70edf7d5d972156b2e2371d928e4))
* update dependency com.google.protobuf:protobuf-java-util to v3.15.8 ([#589](https://www.github.com/googleapis/java-pubsub/issues/589)) ([8adde2d](https://www.github.com/googleapis/java-pubsub/commit/8adde2d6741c8bc264f00e34255368ef527aa9ce))
* update dependency org.apache.avro:avro to v1.10.2 ([#575](https://www.github.com/googleapis/java-pubsub/issues/575)) ([acd0c19](https://www.github.com/googleapis/java-pubsub/commit/acd0c1953aa4728699a03566632f4b1bf8bbe177))

## [1.112.0](https://www.github.com/googleapis/java-pubsub/compare/v1.111.4...v1.112.0) (2021-03-16)


### Features

* expose default client configs ([#541](https://www.github.com/googleapis/java-pubsub/issues/541)) ([01e6daf](https://www.github.com/googleapis/java-pubsub/commit/01e6dafb569a37c661463b79f5afbfba4f6d188d))


### Bug Fixes

* properly shutdown subscriber stub on permanent streaming pull failure ([#539](https://www.github.com/googleapis/java-pubsub/issues/539)) ([adbcc0c](https://www.github.com/googleapis/java-pubsub/commit/adbcc0c6777e35eae24b538e6c48f9ef7485a786))
* update MessageDispatcher to not extend deadlines of messages which arrive early to 60s ([#570](https://www.github.com/googleapis/java-pubsub/issues/570)) ([e174e20](https://www.github.com/googleapis/java-pubsub/commit/e174e2043f64563f4d2868537aeb90d948233166))


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v1.94.3 ([#566](https://www.github.com/googleapis/java-pubsub/issues/566)) ([3f23ac6](https://www.github.com/googleapis/java-pubsub/commit/3f23ac6cda00814f74f2c435dd8a05b70ac69d27))
* update dependency com.google.cloud:google-cloud-core to v1.94.4 ([#568](https://www.github.com/googleapis/java-pubsub/issues/568)) ([21886d3](https://www.github.com/googleapis/java-pubsub/commit/21886d39cdc2a33275c2061578c877b0fa6aee98))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.20.1 ([#564](https://www.github.com/googleapis/java-pubsub/issues/564)) ([0aa4521](https://www.github.com/googleapis/java-pubsub/commit/0aa452121b2fa769221b41c8c1323f3b31b599d1))
* update dependency com.google.protobuf:protobuf-java-util to v3.15.5 ([#559](https://www.github.com/googleapis/java-pubsub/issues/559)) ([74e6a92](https://www.github.com/googleapis/java-pubsub/commit/74e6a92ca88f006e0fe1a68144ba0cb30a1d140c))
* update dependency com.google.protobuf:protobuf-java-util to v3.15.6 ([#569](https://www.github.com/googleapis/java-pubsub/issues/569)) ([b6e299f](https://www.github.com/googleapis/java-pubsub/commit/b6e299f6d13dab7d5b2e8c575021371485878bb2))


### Documentation

* Remove experimental note for schema APIs ([#560](https://www.github.com/googleapis/java-pubsub/issues/560)) ([4b98556](https://www.github.com/googleapis/java-pubsub/commit/4b98556e550802135cfb87d8984f0deec57e8c2e))

### [1.111.4](https://www.github.com/googleapis/java-pubsub/compare/v1.111.3...v1.111.4) (2021-02-26)


### Dependencies

* update dependency com.google.protobuf:protobuf-java-util to v3.15.3 ([#546](https://www.github.com/googleapis/java-pubsub/issues/546)) ([3c10d2c](https://www.github.com/googleapis/java-pubsub/commit/3c10d2cf7cb8fab1c2dad8e80ea8ad7723e4e899))

### [1.111.3](https://www.github.com/googleapis/java-pubsub/compare/v1.111.2...v1.111.3) (2021-02-25)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.20.0 ([#542](https://www.github.com/googleapis/java-pubsub/issues/542)) ([ff9dc0d](https://www.github.com/googleapis/java-pubsub/commit/ff9dc0d5becf281aea855eeb0d246e938ed5e09c))

### [1.111.2](https://www.github.com/googleapis/java-pubsub/compare/v1.111.1...v1.111.2) (2021-02-24)


### Dependencies

* update dependency com.google.protobuf:protobuf-java-util to v3.15.2 ([#524](https://www.github.com/googleapis/java-pubsub/issues/524)) ([b5e07a8](https://www.github.com/googleapis/java-pubsub/commit/b5e07a866f096744feafc6187bcb022669f5fa26))

### [1.111.1](https://www.github.com/googleapis/java-pubsub/compare/v1.111.0...v1.111.1) (2021-02-23)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.19.0 ([#515](https://www.github.com/googleapis/java-pubsub/issues/515)) ([073c3b8](https://www.github.com/googleapis/java-pubsub/commit/073c3b84965a4225d735743d5f4e540330cf26b7))

## [1.111.0](https://www.github.com/googleapis/java-pubsub/compare/v1.110.3...v1.111.0) (2021-02-02)


### Features

* add schema service to gapic ([#494](https://www.github.com/googleapis/java-pubsub/issues/494)) ([23952bf](https://www.github.com/googleapis/java-pubsub/commit/23952bfb728f64efaeaa2862f2f56f873260ca3e))


### Bug Fixes

* adding deprecated tags to deprecated methods ([#472](https://www.github.com/googleapis/java-pubsub/issues/472)) ([91b5152](https://www.github.com/googleapis/java-pubsub/commit/91b5152ba9942e9ce4cfd2051e4b8b358b465601))
* fix flakiness in subscriberIT integration test ([#476](https://www.github.com/googleapis/java-pubsub/issues/476)) ([d981b4e](https://www.github.com/googleapis/java-pubsub/commit/d981b4ec7ba905898fcc5e17453166d9d995bdb4))


### Documentation

* Document potentially unexpected blocking behavior of publish() method ([#370](https://www.github.com/googleapis/java-pubsub/issues/370)) ([18b3a2f](https://www.github.com/googleapis/java-pubsub/commit/18b3a2f77816b55cf605447b382a2f1bd42e0880))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.18.0 ([#482](https://www.github.com/googleapis/java-pubsub/issues/482)) ([260eca5](https://www.github.com/googleapis/java-pubsub/commit/260eca5ea34296d3722707ce7199845c6f2e8526))
* update dependency com.google.errorprone:error_prone_annotations to v2.5.1 ([#484](https://www.github.com/googleapis/java-pubsub/issues/484)) ([44b6780](https://www.github.com/googleapis/java-pubsub/commit/44b6780022bbc2e1cf40be82932a34e5d8e08650))

### [1.110.3](https://www.github.com/googleapis/java-pubsub/compare/v1.110.2...v1.110.3) (2020-12-15)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.17.0 ([#466](https://www.github.com/googleapis/java-pubsub/issues/466)) ([e96ae16](https://www.github.com/googleapis/java-pubsub/commit/e96ae16afa7829a087129abccd94a2dafcf25e9a))

### [1.110.2](https://www.github.com/googleapis/java-pubsub/compare/v1.110.1...v1.110.2) (2020-12-14)


### Bug Fixes

* `setParallelPullCount` documentation ([#459](https://www.github.com/googleapis/java-pubsub/issues/459)) ([b399f60](https://www.github.com/googleapis/java-pubsub/commit/b399f60cf324ab21c15697bd697902aa1fde3e80))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.16.1 ([#462](https://www.github.com/googleapis/java-pubsub/issues/462)) ([1326484](https://www.github.com/googleapis/java-pubsub/commit/13264848f5124d7ad388c1cd1423447aab2aa512))

### [1.110.1](https://www.github.com/googleapis/java-pubsub/compare/v1.110.0...v1.110.1) (2020-12-02)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.16.0 ([#452](https://www.github.com/googleapis/java-pubsub/issues/452)) ([6f8d0bb](https://www.github.com/googleapis/java-pubsub/commit/6f8d0bbbfe1b05541e916520c1dfb715ccce03b0))

## [1.110.0](https://www.github.com/googleapis/java-pubsub/compare/v1.109.0...v1.110.0) (2020-11-24)


### Features

* make the stream ack deadline congruent with maxDurationPerAckExtension ([#447](https://www.github.com/googleapis/java-pubsub/issues/447)) ([c63dc25](https://www.github.com/googleapis/java-pubsub/commit/c63dc255dff55982fca2e4cf0e955c47614dc291))

## [1.109.0](https://www.github.com/googleapis/java-pubsub/compare/v1.108.7...v1.109.0) (2020-11-17)


### Features

* Enable server side flow control by default with the option to turn it off ([#426](https://www.github.com/googleapis/java-pubsub/issues/426)) ([14ac8d7](https://www.github.com/googleapis/java-pubsub/commit/14ac8d7e10ef6fbecdb21cb80ef496686d20e8f3))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.15.0 ([#430](https://www.github.com/googleapis/java-pubsub/issues/430)) ([991cb43](https://www.github.com/googleapis/java-pubsub/commit/991cb430794b5d95d47477e0113b71db313ebebe))

### [1.108.7](https://www.github.com/googleapis/java-pubsub/compare/v1.108.6...v1.108.7) (2020-11-02)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.14.1 ([#417](https://www.github.com/googleapis/java-pubsub/issues/417)) ([fc388c0](https://www.github.com/googleapis/java-pubsub/commit/fc388c0d452957a617f8ce7288830392cdd40693))

### [1.108.6](https://www.github.com/googleapis/java-pubsub/compare/v1.108.5...v1.108.6) (2020-10-22)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.13.0 ([#400](https://www.github.com/googleapis/java-pubsub/issues/400)) ([bd3d400](https://www.github.com/googleapis/java-pubsub/commit/bd3d400b11a0677bcd3ca2bf8cd5d7fd0fbf59bc))

### [1.108.5](https://www.github.com/googleapis/java-pubsub/compare/v1.108.4...v1.108.5) (2020-10-19)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.12.1 ([#392](https://www.github.com/googleapis/java-pubsub/issues/392)) ([1a0d7e9](https://www.github.com/googleapis/java-pubsub/commit/1a0d7e98a40298b139cfddbd9e044dc541296ab5))

### [1.108.4](https://www.github.com/googleapis/java-pubsub/compare/v1.108.3...v1.108.4) (2020-10-12)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.10.2 ([#377](https://www.github.com/googleapis/java-pubsub/issues/377)) ([5e76466](https://www.github.com/googleapis/java-pubsub/commit/5e7646640c28b019dbfbd4073420f9358993ef85))

### [1.108.3](https://www.github.com/googleapis/java-pubsub/compare/v1.108.2...v1.108.3) (2020-10-02)


### Bug Fixes

* ensure proper cleanup of publisher in tests ([#310](https://www.github.com/googleapis/java-pubsub/issues/310)) ([b2b2f86](https://www.github.com/googleapis/java-pubsub/commit/b2b2f8694b925aad95e891cbd0d89426989fec59))
* Ensure that messages that are in pending batches for an ordering key are canceled when a previous publish for the ordering keys fails ([#366](https://www.github.com/googleapis/java-pubsub/issues/366)) ([7cdf8bc](https://www.github.com/googleapis/java-pubsub/commit/7cdf8bcf71a6c141f8b751b41fb2e055a75a4022))
* make subscriberIT test less flaky ([#340](https://www.github.com/googleapis/java-pubsub/issues/340)) ([5d4f534](https://www.github.com/googleapis/java-pubsub/commit/5d4f5345b13171a47f022d34d39609c2f4329069))
* Only check keyHasError if ordering key is non-empty ([#367](https://www.github.com/googleapis/java-pubsub/issues/367)) ([8b2d0b7](https://www.github.com/googleapis/java-pubsub/commit/8b2d0b73a46e6b91795ad05a8dd0f626249c4f30))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.10.0 ([#357](https://www.github.com/googleapis/java-pubsub/issues/357)) ([3b3616c](https://www.github.com/googleapis/java-pubsub/commit/3b3616c524059fb8a87bf30a66c481000046132a))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.9.0 ([#337](https://www.github.com/googleapis/java-pubsub/issues/337)) ([8cf77ee](https://www.github.com/googleapis/java-pubsub/commit/8cf77ee3b31356f342942a9ffaa61db2d0686769))

### [1.108.2](https://www.github.com/googleapis/java-pubsub/compare/v1.108.1...v1.108.2) (2020-08-21)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.5 ([#303](https://www.github.com/googleapis/java-pubsub/issues/303)) ([28ef9ea](https://www.github.com/googleapis/java-pubsub/commit/28ef9ea8cd78391a37023df6a0dcdbd1ba8432f1))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.6 ([#313](https://www.github.com/googleapis/java-pubsub/issues/313)) ([6fc0a4f](https://www.github.com/googleapis/java-pubsub/commit/6fc0a4fceddd420ac8539e0aa98975a01546250d))

### [1.108.1](https://www.github.com/googleapis/java-pubsub/compare/v1.108.0...v1.108.1) (2020-08-04)


### Bug Fixes

* add header providers to PublisherStubSettings ([#294](https://www.github.com/googleapis/java-pubsub/issues/294)) ([6bd5016](https://www.github.com/googleapis/java-pubsub/commit/6bd5016dafe85c7af92a44a8e9a34b2fcb95e64d))
* if a flow control setting is not provided use zero ([#292](https://www.github.com/googleapis/java-pubsub/issues/292)) ([d56155b](https://www.github.com/googleapis/java-pubsub/commit/d56155b640d13fa78d28031862aabe4814ce201d))
* Make error message more clear about where ordering must be enabled when publishing ([#293](https://www.github.com/googleapis/java-pubsub/issues/293)) ([f54ed02](https://www.github.com/googleapis/java-pubsub/commit/f54ed0284a9c7e1a337481e13388397adfa33abf))


### Documentation

* remove experimental warning for ordering keys properties. ([#297](https://www.github.com/googleapis/java-pubsub/issues/297)) ([3fa5164](https://www.github.com/googleapis/java-pubsub/commit/3fa516496315b882da7ffbbc230a3e69acf08a48))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.3 ([#282](https://www.github.com/googleapis/java-pubsub/issues/282)) ([744c268](https://www.github.com/googleapis/java-pubsub/commit/744c2687d50c79ff8556d455aab60928ab2f790c))

## [1.108.0](https://www.github.com/googleapis/java-pubsub/compare/v1.107.0...v1.108.0) (2020-07-09)


### Features

* **deps:** adopt flatten plugin and google-cloud-shared-dependencies ([#259](https://www.github.com/googleapis/java-pubsub/issues/259)) ([6b0947b](https://www.github.com/googleapis/java-pubsub/commit/6b0947b0c142691a16190b7d15da136936517e5a))
* implement max duration per ack extension ([#211](https://www.github.com/googleapis/java-pubsub/issues/211)) ([1427b8c](https://www.github.com/googleapis/java-pubsub/commit/1427b8ced4d7f75e4cb1b57dd898b18f0d232d19))
* regenerated to pick up doc changes ([#246](https://www.github.com/googleapis/java-pubsub/issues/246)) ([a5f45ac](https://www.github.com/googleapis/java-pubsub/commit/a5f45ac0ad493856cd5e1743b8df4fc6d70c5ca9))
* Send streaming pull flow control settings to server ([#267](https://www.github.com/googleapis/java-pubsub/issues/267)) ([9c750c8](https://www.github.com/googleapis/java-pubsub/commit/9c750c8e4899ae994a788c5323fc456ac5d7aa38))


### Dependencies

* update autovalue.version to v1.7.3 ([#244](https://www.github.com/googleapis/java-pubsub/issues/244)) ([6af6682](https://www.github.com/googleapis/java-pubsub/commit/6af6682a5c52af1b929634fe210ef342c5625fda))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.1 ([#247](https://www.github.com/googleapis/java-pubsub/issues/247)) ([fbceaed](https://www.github.com/googleapis/java-pubsub/commit/fbceaed9701811e3c818fe5696f04936ec447b96))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.2 ([#274](https://www.github.com/googleapis/java-pubsub/issues/274)) ([b101905](https://www.github.com/googleapis/java-pubsub/commit/b101905dedcaff4a50c7d3c6097fcb5c0e48310c))

## [1.107.0](https://www.github.com/googleapis/java-pubsub/compare/v1.106.0...v1.107.0) (2020-06-09)


### Features

* add detach subscription rpc ([#216](https://www.github.com/googleapis/java-pubsub/issues/216)) ([09866b0](https://www.github.com/googleapis/java-pubsub/commit/09866b0d36e2dd1c994b4c91807d71552b65c8e1))
* regenerated to pick up changes in the API or client library generator ([#185](https://www.github.com/googleapis/java-pubsub/issues/185)) ([16624f8](https://www.github.com/googleapis/java-pubsub/commit/16624f88ad19ccaf2ea074a62242496be103659f)), closes [#533](https://www.github.com/googleapis/java-pubsub/issues/533) [#535](https://www.github.com/googleapis/java-pubsub/issues/535) [#534](https://www.github.com/googleapis/java-pubsub/issues/534)


### Bug Fixes

* update ignored diffs ([#206](https://www.github.com/googleapis/java-pubsub/issues/206)) ([240e141](https://www.github.com/googleapis/java-pubsub/commit/240e141a8b4f8e4d4e252672bb4ae4d091dde453)), closes [#6784](https://www.github.com/googleapis/java-pubsub/issues/6784) [#11](https://www.github.com/googleapis/java-pubsub/issues/11)


### Dependencies

* bump shared-deps version and add back certain test deps ([#218](https://www.github.com/googleapis/java-pubsub/issues/218)) ([49ecc69](https://www.github.com/googleapis/java-pubsub/commit/49ecc69fb6a63abf6a83f82f2820ff386cdaf5fb))
* remove grpc test dep since it's now in shared-deps ([#220](https://www.github.com/googleapis/java-pubsub/issues/220)) ([28ab521](https://www.github.com/googleapis/java-pubsub/commit/28ab5211c344d60743c3cb11f568c8f2a4e2c040))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.6.0 ([#219](https://www.github.com/googleapis/java-pubsub/issues/219)) ([c6fc69d](https://www.github.com/googleapis/java-pubsub/commit/c6fc69d47dea6f3833a9a2945d27ed3f9e310c52))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.7.0 ([#221](https://www.github.com/googleapis/java-pubsub/issues/221)) ([89eae9a](https://www.github.com/googleapis/java-pubsub/commit/89eae9a6c3dc585926f85fc0de2b80f7dbfedb42))
* update dependency com.google.errorprone:error_prone_annotations to v2.4.0 ([#225](https://www.github.com/googleapis/java-pubsub/issues/225)) ([f375ecb](https://www.github.com/googleapis/java-pubsub/commit/f375ecbbd66e518a25c1d0459ba0634121ddced1))

## [1.106.0](https://www.github.com/googleapis/java-pubsub/compare/v1.105.1...v1.106.0) (2020-05-20)


### Features

* implement google-cloud-shared-dependencies BOM ([#198](https://www.github.com/googleapis/java-pubsub/issues/198)) ([55bdc26](https://www.github.com/googleapis/java-pubsub/commit/55bdc2647f4f9949d015497ed4a35c24a3ecdfab))
* set up repo for samples ([#196](https://www.github.com/googleapis/java-pubsub/issues/196)) ([3e1b136](https://www.github.com/googleapis/java-pubsub/commit/3e1b1360250ed8fa91b9fa6f36bc1d051aa38e2c))


### Documentation

* **fix:** update client documentation link ([#192](https://www.github.com/googleapis/java-pubsub/issues/192)) ([e6f0533](https://www.github.com/googleapis/java-pubsub/commit/e6f053399c45d02c7d641c4b2a84bff96b634e34))


### Dependencies

* update autovalue.version to v1.7.2 ([#184](https://www.github.com/googleapis/java-pubsub/issues/184)) ([040ff0b](https://www.github.com/googleapis/java-pubsub/commit/040ff0b7ce0a323a0e1ee575eb1c021dd644608b))
* update dependency com.google.protobuf:protobuf-java to v3.12.0 ([#188](https://www.github.com/googleapis/java-pubsub/issues/188)) ([87e036e](https://www.github.com/googleapis/java-pubsub/commit/87e036ed6929dfa8f6d8e2eb099833276aa17a91))

### [1.105.1](https://www.github.com/googleapis/java-pubsub/compare/v1.105.0...v1.105.1) (2020-05-07)


### Bug Fixes

* changing integration test push endpoint to be valid https ([#170](https://www.github.com/googleapis/java-pubsub/issues/170)) ([71f15a4](https://www.github.com/googleapis/java-pubsub/commit/71f15a4a90475c8e82c6cc6393d4232228273656)), closes [#6784](https://www.github.com/googleapis/java-pubsub/issues/6784) [#11](https://www.github.com/googleapis/java-pubsub/issues/11)


### Dependencies

* update autovalue.version to v1.7.1 ([#173](https://www.github.com/googleapis/java-pubsub/issues/173)) ([77884f8](https://www.github.com/googleapis/java-pubsub/commit/77884f8c816bb189a1d5ecad3ab860b19df2804d))
* update dependency com.google.api.grpc:proto-google-common-protos to v1.18.0 ([#176](https://www.github.com/googleapis/java-pubsub/issues/176)) ([486ed41](https://www.github.com/googleapis/java-pubsub/commit/486ed4130a17a0fa411a30e7c48bd04082e68458))
* update dependency com.google.guava:guava-bom to v29 ([#146](https://www.github.com/googleapis/java-pubsub/issues/146)) ([16f1dbb](https://www.github.com/googleapis/java-pubsub/commit/16f1dbb3226af119cdbc234e8672608244d0a7fd))
* update dependency com.google.http-client:google-http-client-bom to v1.35.0 ([#169](https://www.github.com/googleapis/java-pubsub/issues/169)) ([6346042](https://www.github.com/googleapis/java-pubsub/commit/6346042b09c5f7e302f75ad8e48cc2d08b6f8e64))
* update dependency io.grpc:grpc-bom to v1.29.0 ([#162](https://www.github.com/googleapis/java-pubsub/issues/162)) ([b883b45](https://www.github.com/googleapis/java-pubsub/commit/b883b452676eeb7bd5a178cd1bb357e965a26ee8))
* update dependency org.threeten:threetenbp to v1.4.4 ([#167](https://www.github.com/googleapis/java-pubsub/issues/167)) ([78ead3a](https://www.github.com/googleapis/java-pubsub/commit/78ead3a69ce493fdf57a372c1e135e71b8b5cb7c))

## [1.105.0](https://www.github.com/googleapis/java-pubsub/compare/v1.104.1...v1.105.0) (2020-04-13)


### Features

* add interfaces for cloud pubsub publishers and subscribers ([#134](https://www.github.com/googleapis/java-pubsub/issues/134)) ([89fcc88](https://www.github.com/googleapis/java-pubsub/commit/89fcc8848cc7d421e8dde9b7dca28a6940d8386f))


### Documentation

* update libraries-bom ([#140](https://www.github.com/googleapis/java-pubsub/issues/140)) ([d8239bd](https://www.github.com/googleapis/java-pubsub/commit/d8239bdc080d0ef595bac90451485b1d3d50f266))

### [1.104.1](https://www.github.com/googleapis/java-pubsub/compare/v1.104.0...v1.104.1) (2020-04-08)


### Dependencies

* update core dependencies ([#127](https://www.github.com/googleapis/java-pubsub/issues/127)) ([33c9293](https://www.github.com/googleapis/java-pubsub/commit/33c9293fbb7de6de6861c4b2c3e3e79fb9e57e7b))
* update dependency com.google.cloud:google-cloud-core to v1.93.4 ([#129](https://www.github.com/googleapis/java-pubsub/issues/129)) ([78c0216](https://www.github.com/googleapis/java-pubsub/commit/78c021628c86317d3893f2797ccc5039cffd453a))
* update dependency org.threeten:threetenbp to v1.4.3 ([#128](https://www.github.com/googleapis/java-pubsub/issues/128)) ([54650dd](https://www.github.com/googleapis/java-pubsub/commit/54650dd6115f055d8a66c164017d1a038552dfac))

## [1.104.0](https://www.github.com/googleapis/java-pubsub/compare/v1.103.1...v1.104.0) (2020-04-02)


### Features

* Add flow control support to publisher ([#119](https://www.github.com/googleapis/java-pubsub/issues/119)) ([fdd9434](https://www.github.com/googleapis/java-pubsub/commit/fdd943433cface4bc6634f74aa12afa6e471f3a3))
* add TopicName ([#113](https://www.github.com/googleapis/java-pubsub/issues/113)) ([4558c34](https://www.github.com/googleapis/java-pubsub/commit/4558c3430901cdaec12a43e06ea4fafaa01c08e0))


### Bug Fixes

* Re-generated  to pick up changes in the API or client library generator. ([#104](https://www.github.com/googleapis/java-pubsub/issues/104)) ([0e366c3](https://www.github.com/googleapis/java-pubsub/commit/0e366c35580116fcd6aa40caadedd95be07bdd87))


### Dependencies

* update core dependencies ([#105](https://www.github.com/googleapis/java-pubsub/issues/105)) ([5639f63](https://www.github.com/googleapis/java-pubsub/commit/5639f6321e1506fdf803f5de58f2c7fdf5afb448))
* update core dependencies to v1.55.0 ([#122](https://www.github.com/googleapis/java-pubsub/issues/122)) ([3ea1202](https://www.github.com/googleapis/java-pubsub/commit/3ea1202dbe13b60cfdc14c2855e878e190a52199))
* update dependency com.google.api:api-common to v1.9.0 ([#121](https://www.github.com/googleapis/java-pubsub/issues/121)) ([30a1dee](https://www.github.com/googleapis/java-pubsub/commit/30a1deecbecf63d1629ae93407658865518febce))
* update dependency org.threeten:threetenbp to v1.4.2 ([#116](https://www.github.com/googleapis/java-pubsub/issues/116)) ([e7c007b](https://www.github.com/googleapis/java-pubsub/commit/e7c007b917618e75f9c8fecd2475f31c7eba0817))
* update opencensus.version to v0.26.0 ([#115](https://www.github.com/googleapis/java-pubsub/issues/115)) ([26aec5d](https://www.github.com/googleapis/java-pubsub/commit/26aec5d7ee45bec5b39b6cbe67122a6e5944268e))

### [1.103.1](https://www.github.com/googleapis/java-pubsub/compare/v1.103.0...v1.103.1) (2020-03-03)


### Bug Fixes

* add a default value for max outstanding request bytes flow control setting ([#96](https://www.github.com/googleapis/java-pubsub/issues/96)) ([4a6046c](https://www.github.com/googleapis/java-pubsub/commit/4a6046c2b03ad1d7e08d6e6dc0d1817cbffc5283))
* remove deprecated tag that was added prematurely ([#97](https://www.github.com/googleapis/java-pubsub/issues/97)) ([fbb87ef](https://www.github.com/googleapis/java-pubsub/commit/fbb87ef0d493fc9e375e860b52dd6a9b99e3cf00))


### Dependencies

* update core dependencies ([#100](https://www.github.com/googleapis/java-pubsub/issues/100)) ([8323b31](https://www.github.com/googleapis/java-pubsub/commit/8323b31b9349065f1798120b6ffdaff3372f8552))
* update dependency com.google.cloud:google-cloud-core to v1.93.1 ([#102](https://www.github.com/googleapis/java-pubsub/issues/102)) ([33b12df](https://www.github.com/googleapis/java-pubsub/commit/33b12df2e8c54ac404aeabd97ef71404611f3e3b))
* update dependency com.google.http-client:google-http-client-bom to v1.34.2 ([19fde3a](https://www.github.com/googleapis/java-pubsub/commit/19fde3ab100c4910c4d998fbf0e5380ad7732f90))
* update dependency com.google.protobuf:protobuf-java to v3.11.4 ([e49a861](https://www.github.com/googleapis/java-pubsub/commit/e49a8615147779d9dab07661e7586395ffa26d1f))
* update dependency io.grpc:grpc-bom to v1.27.1 ([013b0c3](https://www.github.com/googleapis/java-pubsub/commit/013b0c3e4ee09926efc88f43dde6d6265fb41171))
* update dependency org.easymock:easymock to v4 ([#39](https://www.github.com/googleapis/java-pubsub/issues/39)) ([f803bee](https://www.github.com/googleapis/java-pubsub/commit/f803bee1292fb6e1961dabb25dca17c7c2bd5a04))
* update opencensus.version to v0.25.0 ([#85](https://www.github.com/googleapis/java-pubsub/issues/85)) ([aeca5d4](https://www.github.com/googleapis/java-pubsub/commit/aeca5d413ae46dc9153c4db0135e594a426a7375))


### Documentation

* **regen:** switch to proto annotations ([#90](https://www.github.com/googleapis/java-pubsub/issues/90)) ([63c147a](https://www.github.com/googleapis/java-pubsub/commit/63c147a9250c7b07cb9c8cc7b086a68e0631a37d))

## [1.103.0](https://www.github.com/googleapis/java-pubsub/compare/v1.102.1...v1.103.0) (2020-02-20)


### Features

* add randomly generated UUID to outgoing initial streaming pull requests ([#77](https://www.github.com/googleapis/java-pubsub/issues/77)) ([08e77d4](https://www.github.com/googleapis/java-pubsub/commit/08e77d428aa50bb53ed7d5b922e76c2da18ed6d1))
* adding support for dead letter queues ([#60](https://www.github.com/googleapis/java-pubsub/issues/60)) ([f3c93fa](https://www.github.com/googleapis/java-pubsub/commit/f3c93fa8bf0eb8ebda6eea6c6c6a60a36dc69af2))


### Bug Fixes

* ensure all publishes complete before shutting down publisher ([#76](https://www.github.com/googleapis/java-pubsub/issues/76)) ([d0ab525](https://www.github.com/googleapis/java-pubsub/commit/d0ab52576c729091b4cdc72b378a305e102ca180)), closes [#6784](https://www.github.com/googleapis/java-pubsub/issues/6784) [#11](https://www.github.com/googleapis/java-pubsub/issues/11)
* removing delivery attempt attribute when dead lettering is not enabled ([#72](https://www.github.com/googleapis/java-pubsub/issues/72)) ([535854d](https://www.github.com/googleapis/java-pubsub/commit/535854df64234fe491cae1e3db0c96d685ef0800))
* retry streaming subscriber connections on unknown ([#92](https://www.github.com/googleapis/java-pubsub/issues/92)) ([d702a5c](https://www.github.com/googleapis/java-pubsub/commit/d702a5caa2a1da7a160a449fd91681e38c034afc))
* shutdown grpc stubs properly when a subscriber is stopped ([#74](https://www.github.com/googleapis/java-pubsub/issues/74)) ([9bcc433](https://www.github.com/googleapis/java-pubsub/commit/9bcc433e6d167f68256e0ede2a521296dcbc7412)), closes [#6784](https://www.github.com/googleapis/java-pubsub/issues/6784) [#11](https://www.github.com/googleapis/java-pubsub/issues/11)


### Dependencies

* update core dependencies ([#56](https://www.github.com/googleapis/java-pubsub/issues/56)) ([0188a8a](https://www.github.com/googleapis/java-pubsub/commit/0188a8a550d3aeb2626e7398a2802bf1756240d7))
* update dependency com.google.cloud:google-cloud-core to v1.92.5 ([c296feb](https://www.github.com/googleapis/java-pubsub/commit/c296febe426dc9453b050cb21bcb188a4d09ad50))
* update dependency com.google.http-client:google-http-client-bom to v1.34.1 ([#71](https://www.github.com/googleapis/java-pubsub/issues/71)) ([69fc615](https://www.github.com/googleapis/java-pubsub/commit/69fc6155a4490dcad082abf7742b359c0a0ff885))
* update dependency com.google.protobuf:protobuf-java to v3.11.3 ([#79](https://www.github.com/googleapis/java-pubsub/issues/79)) ([0f77732](https://www.github.com/googleapis/java-pubsub/commit/0f77732e751a83f61fe3b6a7e4b745003fc87474))
* update dependency org.threeten:threetenbp to v1.4.1 ([4383d60](https://www.github.com/googleapis/java-pubsub/commit/4383d6064d8a3ef8d0dd9bc8c65e09b48d6f53dc))


### Documentation

* **regen:** update sample code to set total timeout, add API client header test ([8bc23bc](https://www.github.com/googleapis/java-pubsub/commit/8bc23bc3b68a2c3a2a7caa1d9859dfdd1b56c47d))

### [1.102.1](https://www.github.com/googleapis/java-pubsub/compare/v1.102.0...v1.102.1) (2020-01-07)


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v1.92.0 ([4b3c656](https://www.github.com/googleapis/java-pubsub/commit/4b3c656fbc50d5703bf830e2307fa6ba9cbe31cb))
* update dependency com.google.cloud:google-cloud-core to v1.92.1 ([c9345e3](https://www.github.com/googleapis/java-pubsub/commit/c9345e3178d26e2f8872c3cc5173e4cb9fa61675))
* update dependency com.google.errorprone:error_prone_annotations to v2.3.4 ([#13](https://www.github.com/googleapis/java-pubsub/issues/13)) ([a34c50c](https://www.github.com/googleapis/java-pubsub/commit/a34c50c28c0907129f5eb6bf1380b202eabd8c07))
* update dependency com.google.guava:guava-bom to v28.2-android ([9f0a7b2](https://www.github.com/googleapis/java-pubsub/commit/9f0a7b2c390546321393c5ef0ea972167dac5049))
* update dependency io.grpc:grpc-bom to v1.26.0 ([#38](https://www.github.com/googleapis/java-pubsub/issues/38)) ([c09da56](https://www.github.com/googleapis/java-pubsub/commit/c09da568fffde6256a20be5ff77e98d7a0ba044f))

## [1.102.0](https://www.github.com/googleapis/java-pubsub/compare/1.101.0...v1.102.0) (2019-12-04)


### Features

* make repo releasable, add parent/bom ([#3](https://www.github.com/googleapis/java-pubsub/issues/3)) ([53c4030](https://www.github.com/googleapis/java-pubsub/commit/53c403008f891b79438a8b797156a473e47af5d6))


### Bug Fixes

* ordering keys publishing of last batch ([#9](https://www.github.com/googleapis/java-pubsub/issues/9)) ([02c3771](https://www.github.com/googleapis/java-pubsub/commit/02c3771846bec09c93441c490c7928090a8dd71e))


### Dependencies

* update dependency com.google.protobuf:protobuf-java to v3.11.1 ([#14](https://www.github.com/googleapis/java-pubsub/issues/14)) ([575b3d6](https://www.github.com/googleapis/java-pubsub/commit/575b3d624423d61b6475a86e019246d77f9957fe))
