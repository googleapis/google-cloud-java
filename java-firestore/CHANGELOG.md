# Changelog

## [3.30.3](https://github.com/googleapis/java-firestore/compare/v3.30.2...v3.30.3) (2025-01-11)


### Bug Fixes

* **deps:** Update the Java code generator (gapic-generator-java) to 2.51.1 ([f6fcbf1](https://github.com/googleapis/java-firestore/commit/f6fcbf10485317ff370d9698947f3bbf2ae63cfb))
* Sort document reference by long type id ([#1945](https://github.com/googleapis/java-firestore/issues/1945)) ([c38e3ad](https://github.com/googleapis/java-firestore/commit/c38e3adc08e50a7946523aa0ba4ef46943cf2b85))


### Dependencies

* Update dependency com.diffplug.spotless:spotless-maven-plugin to v2.44.1 ([#1969](https://github.com/googleapis/java-firestore/issues/1969)) ([7a4813b](https://github.com/googleapis/java-firestore/commit/7a4813b2e5c6be246f7f6a312afba78d76ff3927))
* Update dependency com.google.api.grpc:proto-google-cloud-trace-v1 to v2.55.0 ([#1961](https://github.com/googleapis/java-firestore/issues/1961)) ([5c62282](https://github.com/googleapis/java-firestore/commit/5c6228215e1c40de420c765e6aecb81a312e7954))
* Update dependency com.google.cloud:google-cloud-trace to v2.55.0 ([#1962](https://github.com/googleapis/java-firestore/issues/1962)) ([d8144b5](https://github.com/googleapis/java-firestore/commit/d8144b55ba68b79fafd4f5a3a6a640d959caf2be))
* Update dependency com.google.cloud:sdk-platform-java-config to v3.41.1 ([#1970](https://github.com/googleapis/java-firestore/issues/1970)) ([bbf75cc](https://github.com/googleapis/java-firestore/commit/bbf75cc4b7421ddab8ac5538fc0084218a4e3a1b))
* Update googleapis/sdk-platform-java action to v2.51.1 ([#1968](https://github.com/googleapis/java-firestore/issues/1968)) ([9f318b0](https://github.com/googleapis/java-firestore/commit/9f318b030637a8e354e4d10651ea2d4073098c2a))

## [3.30.2](https://github.com/googleapis/java-firestore/compare/v3.30.1...v3.30.2) (2024-12-13)


### Bug Fixes

* **deps:** Update the Java code generator (gapic-generator-java) to 2.51.0 ([c623c1d](https://github.com/googleapis/java-firestore/commit/c623c1da37f83febe4492e2acb8908f297a210f3))


### Dependencies

* Update dependency com.google.cloud:sdk-platform-java-config to v3.41.0 ([#1954](https://github.com/googleapis/java-firestore/issues/1954)) ([888d705](https://github.com/googleapis/java-firestore/commit/888d705cda06103d6defaa17e3d3fd8b9e535f54))
* Update googleapis/sdk-platform-java action to v2.51.0 ([#1952](https://github.com/googleapis/java-firestore/issues/1952)) ([9826cba](https://github.com/googleapis/java-firestore/commit/9826cbac81038ca445dc534b392124eac0095742))

## [3.30.1](https://github.com/googleapis/java-firestore/compare/v3.30.0...v3.30.1) (2024-12-09)


### Bug Fixes

* BulkWriter flush logic ([#1778](https://github.com/googleapis/java-firestore/issues/1778)) ([627619d](https://github.com/googleapis/java-firestore/commit/627619d33a051f6709a563b7375ebe39956f9ebf))


### Dependencies

* Update opentelemetry.version to v1.45.0 ([#1947](https://github.com/googleapis/java-firestore/issues/1947)) ([5bb839c](https://github.com/googleapis/java-firestore/commit/5bb839cdab3e8f5d4214a2fbce07f9ed34e769ca))

## [3.30.0](https://github.com/googleapis/java-firestore/compare/v3.29.1...v3.30.0) (2024-11-26)


### Features

* Introduce `java.time` variables and methods ([#1935](https://github.com/googleapis/java-firestore/issues/1935)) ([6c94910](https://github.com/googleapis/java-firestore/commit/6c949106ed25690bcc9e7f73c6459130ed83b9b9))


### Dependencies

* Update dependency com.google.api.grpc:proto-google-cloud-trace-v1 to v2.54.0 ([#1937](https://github.com/googleapis/java-firestore/issues/1937)) ([0a90abc](https://github.com/googleapis/java-firestore/commit/0a90abcefdc154cbafd27a0c7c9b991c1b144b1b))
* Update dependency com.google.cloud:google-cloud-trace to v2.54.0 ([#1933](https://github.com/googleapis/java-firestore/issues/1933)) ([622b742](https://github.com/googleapis/java-firestore/commit/622b74230dd6da5196f4173f2a1113cc0e2da44b))
* Update dependency org.apache.beam:beam-runners-direct-java to v2.61.0 ([#1939](https://github.com/googleapis/java-firestore/issues/1939)) ([4823bdd](https://github.com/googleapis/java-firestore/commit/4823bddf2552f90303b292a6c1e985cb21e6581d))

## [3.29.1](https://github.com/googleapis/java-firestore/compare/v3.29.0...v3.29.1) (2024-11-18)


### Bug Fixes

* **deps:** Update the Java code generator (gapic-generator-java) to 2.50.0 ([aef5ec5](https://github.com/googleapis/java-firestore/commit/aef5ec5c0da68a4bb438100faf9884e000e8a1d1))


### Dependencies

* Update dependency com.google.cloud:sdk-platform-java-config to v3.40.0 ([#1928](https://github.com/googleapis/java-firestore/issues/1928)) ([8b6bc9a](https://github.com/googleapis/java-firestore/commit/8b6bc9afba31d3938fbdcda0e5c9616dfd7daa2a))
* Update googleapis/sdk-platform-java action to v2.50.0 ([#1927](https://github.com/googleapis/java-firestore/issues/1927)) ([700ed0a](https://github.com/googleapis/java-firestore/commit/700ed0ac7ceae1b9c40c919ad9e7342f3bdb85a3))

## [3.29.0](https://github.com/googleapis/java-firestore/compare/v3.28.0...v3.29.0) (2024-11-13)


### Bug Fixes

* Drop the setTracingEnabled flag from Options (@BetaApi change)  ([#1869](https://github.com/googleapis/java-firestore/issues/1869)) ([712d57e](https://github.com/googleapis/java-firestore/commit/712d57e05da8de41850d94fa19eb253cf3020c0f))
* Improve error messages in tests ([#1855](https://github.com/googleapis/java-firestore/issues/1855)) ([cb5f9d6](https://github.com/googleapis/java-firestore/commit/cb5f9d6f481c9c839a387579bf60742b7c2c0508))
* Make StreamableQuery#internalStream package-private to avoid documentation and prevent clirr errors ([593acc3](https://github.com/googleapis/java-firestore/commit/593acc3614f86bdf42387eac5ef8d7ce14dbbec8))


### Dependencies

* Update opentelemetry.version to v1.44.1 ([#1924](https://github.com/googleapis/java-firestore/issues/1924)) ([68deeac](https://github.com/googleapis/java-firestore/commit/68deeac02eabb927ba8b91c77f3be8471ba66718))

## [3.28.0](https://github.com/googleapis/java-firestore/compare/v3.27.4...v3.28.0) (2024-10-29)


### Features

* Improve Logging ([#1892](https://github.com/googleapis/java-firestore/issues/1892)) ([e74457a](https://github.com/googleapis/java-firestore/commit/e74457a1448189978e791fb3efe76d5fe8370ff7))


### Dependencies

* Update dependency com.google.api.grpc:proto-google-cloud-trace-v1 to v2.53.0 ([#1913](https://github.com/googleapis/java-firestore/issues/1913)) ([cbaa7a7](https://github.com/googleapis/java-firestore/commit/cbaa7a7c44c82a173194e3c36289bc6b867b93b7))
* Update dependency com.google.cloud:google-cloud-trace to v2.53.0 ([#1914](https://github.com/googleapis/java-firestore/issues/1914)) ([d3834e1](https://github.com/googleapis/java-firestore/commit/d3834e10b509b3d5c0e1a55318001f9eb80e7f45))

## [3.27.4](https://github.com/googleapis/java-firestore/compare/v3.27.3...v3.27.4) (2024-10-28)


### Bug Fixes

* Add the deprecation notice for tracing enable/disable option. ([#1866](https://github.com/googleapis/java-firestore/issues/1866)) ([d213245](https://github.com/googleapis/java-firestore/commit/d213245a77b42eca110ef579a0c9fa7108357717))
* **deps:** Update the Java code generator (gapic-generator-java) to 2.49.0 ([0bd75f1](https://github.com/googleapis/java-firestore/commit/0bd75f11587a55eb380b094f2900f2f847a7a103))


### Dependencies

* Update beam.version to v2.60.0 ([#1894](https://github.com/googleapis/java-firestore/issues/1894)) ([434e6e0](https://github.com/googleapis/java-firestore/commit/434e6e0b9a738f9ac08788dbf5dd94a0678733aa))
* Update googleapis/sdk-platform-java action to v2.48.0 ([#1899](https://github.com/googleapis/java-firestore/issues/1899)) ([eaf3c0c](https://github.com/googleapis/java-firestore/commit/eaf3c0cfe3dd4dce8afeb9fbb8e2455492c31443))
* Update sdk-platform-java dependencies ([#1901](https://github.com/googleapis/java-firestore/issues/1901)) ([a698223](https://github.com/googleapis/java-firestore/commit/a698223668a5886c65f00760051b8e022d18559c))
* Update sdk-platform-java dependencies ([#1906](https://github.com/googleapis/java-firestore/issues/1906)) ([d70f77a](https://github.com/googleapis/java-firestore/commit/d70f77a85c2e17930626674ff292713a276d71ce))

## [3.27.3](https://github.com/googleapis/java-firestore/compare/v3.27.2...v3.27.3) (2024-10-16)


### Dependencies

* Update opentelemetry.version to v1.43.0 ([#1884](https://github.com/googleapis/java-firestore/issues/1884)) ([f07ac99](https://github.com/googleapis/java-firestore/commit/f07ac990fece6d59d898419d1cca0b2a91a64248))

## [3.27.2](https://github.com/googleapis/java-firestore/compare/v3.27.1...v3.27.2) (2024-10-10)


### Dependencies

* Update dependency com.google.api.grpc:proto-google-cloud-trace-v1 to v2.52.0 ([#1879](https://github.com/googleapis/java-firestore/issues/1879)) ([33cdd41](https://github.com/googleapis/java-firestore/commit/33cdd41949739d37c66830d9b85757d19dbbe31e))
* Update dependency com.google.cloud:google-cloud-trace to v2.52.0 ([#1880](https://github.com/googleapis/java-firestore/issues/1880)) ([2827f77](https://github.com/googleapis/java-firestore/commit/2827f777bf08bdda3599f1a81193e6957533aa19))
* Update dependency com.google.cloud.opentelemetry:exporter-trace to v0.33.0 ([#1876](https://github.com/googleapis/java-firestore/issues/1876)) ([b3fba1f](https://github.com/googleapis/java-firestore/commit/b3fba1f58317e00573f37060bd082283ce9ec2ed))

## [3.27.1](https://github.com/googleapis/java-firestore/compare/v3.27.0...v3.27.1) (2024-10-07)


### Bug Fixes

* **deps:** Update the Java code generator (gapic-generator-java) to 2.47.0 ([c606cea](https://github.com/googleapis/java-firestore/commit/c606ceaccd61cede8799d12b074682a15a03ccff))
* Update to Java 11, since runtime doesn't support 8. ([#1867](https://github.com/googleapis/java-firestore/issues/1867)) ([723c7cc](https://github.com/googleapis/java-firestore/commit/723c7ccc783b2f56ca72867cd741df197a9f68d7))


### Dependencies

* Update dependency com.google.cloud:sdk-platform-java-config to v3.37.0 ([#1871](https://github.com/googleapis/java-firestore/issues/1871)) ([8503a3e](https://github.com/googleapis/java-firestore/commit/8503a3e6badc31eaae4d318925097d010d9d73e4))
* Update googleapis/sdk-platform-java action to v2.47.0 ([#1870](https://github.com/googleapis/java-firestore/issues/1870)) ([971b164](https://github.com/googleapis/java-firestore/commit/971b164104fe072255a26dfaa4e93958fb43b706))

## [3.27.0](https://github.com/googleapis/java-firestore/compare/v3.26.5...v3.27.0) (2024-10-02)


### Features

* Add support for vector search with Query#findNearest ([#1827](https://github.com/googleapis/java-firestore/issues/1827)) ([4ad463a](https://github.com/googleapis/java-firestore/commit/4ad463a6932b90ca0cb3dd015b2543ffbf850eb9))


### Dependencies

* Update googleapis/sdk-platform-java action to v2.46.1 ([#1862](https://github.com/googleapis/java-firestore/issues/1862)) ([f35bcdb](https://github.com/googleapis/java-firestore/commit/f35bcdbfced37438379b969efe071958b6ac94a0))

## [3.26.5](https://github.com/googleapis/java-firestore/compare/v3.26.4...v3.26.5) (2024-09-30)


### Bug Fixes

* **deps:** Update the Java code generator (gapic-generator-java) to 2.46.1 ([f9ddf32](https://github.com/googleapis/java-firestore/commit/f9ddf32e6a9c071d5008b101523b83ffbacf712e))


### Dependencies

* Update dependency com.google.api.grpc:proto-google-cloud-trace-v1 to v2.51.0 ([#1852](https://github.com/googleapis/java-firestore/issues/1852)) ([1efbb10](https://github.com/googleapis/java-firestore/commit/1efbb10c20b7cb3e696b14867b1149d83cb53a16))
* Update dependency com.google.cloud:google-cloud-trace to v2.51.0 ([#1853](https://github.com/googleapis/java-firestore/issues/1853)) ([e674b7a](https://github.com/googleapis/java-firestore/commit/e674b7a77915a5f55582ee54f5304ea958e274b4))

## [3.26.4](https://github.com/googleapis/java-firestore/compare/v3.26.3...v3.26.4) (2024-09-27)


### Features

* Java record serialization/deserialization ([#1842](https://github.com/googleapis/java-firestore/issues/1842)) ([aff93bf](https://github.com/googleapis/java-firestore/commit/aff93bfbf1d39188a050f4423bddd26a1390dad8))


### Bug Fixes

* Fix clirr check failure ([#1841](https://github.com/googleapis/java-firestore/issues/1841)) ([b8b995f](https://github.com/googleapis/java-firestore/commit/b8b995f543de95fb35d6568570b625ddcccfdb6a))


### Dependencies

* Update dependency com.google.cloud:sdk-platform-java-config to v3.36.0 ([#1843](https://github.com/googleapis/java-firestore/issues/1843)) ([4ef02c3](https://github.com/googleapis/java-firestore/commit/4ef02c34c03c00c924aadeee281b3d1a5f523234))
* Update dependency com.google.cloud:sdk-platform-java-config to v3.36.1 ([#1847](https://github.com/googleapis/java-firestore/issues/1847)) ([7415278](https://github.com/googleapis/java-firestore/commit/74152785d92b866a8bc39b908e9079c446abf894))
* Update dependency com.google.cloud.opentelemetry:exporter-trace to v0.32.0 ([#1845](https://github.com/googleapis/java-firestore/issues/1845)) ([310d680](https://github.com/googleapis/java-firestore/commit/310d68093b29584e13d1f651a981768225d1c716))
* Update dependency ubuntu to v24 ([#1848](https://github.com/googleapis/java-firestore/issues/1848)) ([c60fb51](https://github.com/googleapis/java-firestore/commit/c60fb51c213fd81907138825651f12fe598fdce8))

## [3.26.3](https://github.com/googleapis/java-firestore/compare/v3.26.2...v3.26.3) (2024-09-18)


### Bug Fixes

* Revert "Feat: Record serialization/deserialization" ([61073e3](https://github.com/googleapis/java-firestore/commit/61073e37c5f7a9dff12b450667f8c759edbf713d))

## [3.26.2](https://github.com/googleapis/java-firestore/compare/v3.26.1...v3.26.2) (2024-09-17)


### Features

* Record serialization/deserialization ([#1706](https://github.com/googleapis/java-firestore/issues/1706)) ([f5613b4](https://github.com/googleapis/java-firestore/commit/f5613b4ecb46c61cd7c24ae55606a63f92303360))


### Bug Fixes

* Remove race condition in test. ([#1826](https://github.com/googleapis/java-firestore/issues/1826)) ([791281e](https://github.com/googleapis/java-firestore/commit/791281e4693f4e9cf2ff052dadf71a2479c6a979))

## [3.26.1](https://github.com/googleapis/java-firestore/compare/v3.26.0...v3.26.1) (2024-09-16)


### Dependencies

* Update dependency com.google.api.grpc:proto-google-cloud-trace-v1 to v2.49.0 ([#1818](https://github.com/googleapis/java-firestore/issues/1818)) ([c651a6f](https://github.com/googleapis/java-firestore/commit/c651a6ffda59597fce70558ea38681b1f7be3354))
* Update dependency com.google.cloud:google-cloud-trace to v2.49.0 ([#1819](https://github.com/googleapis/java-firestore/issues/1819)) ([9279409](https://github.com/googleapis/java-firestore/commit/9279409f0441fc4105825fc464806c2fb530ae0e))

## [3.26.0](https://github.com/googleapis/java-firestore/compare/v3.25.1...v3.26.0) (2024-09-12)


### Features

* Add additional Firestore query snippets ([#1790](https://github.com/googleapis/java-firestore/issues/1790)) ([4099e5b](https://github.com/googleapis/java-firestore/commit/4099e5b3a97d9b40277b88a16b8e682e2f2acbf1))


### Dependencies

* Update beam.version ([#1794](https://github.com/googleapis/java-firestore/issues/1794)) ([0737ada](https://github.com/googleapis/java-firestore/commit/0737adaf0f990f5ad62a4cac00b490503b804302))
* Update beam.version to v2.59.0 ([#1813](https://github.com/googleapis/java-firestore/issues/1813)) ([0264e23](https://github.com/googleapis/java-firestore/commit/0264e231909562bd54e8f48e74e9a9e1469ecb5d))
* Update dependency com.google.api.grpc:proto-google-cloud-trace-v1 to v2.48.0 ([#1800](https://github.com/googleapis/java-firestore/issues/1800)) ([1c7c12f](https://github.com/googleapis/java-firestore/commit/1c7c12f915e76f25652adbad0864c5c7d810e268))
* Update dependency com.google.cloud:google-cloud-trace to v2.48.0 ([#1801](https://github.com/googleapis/java-firestore/issues/1801)) ([3d9082c](https://github.com/googleapis/java-firestore/commit/3d9082c2ee04c2e99facac2e5c0f664e33216f08))
* Update dependency com.google.cloud:sdk-platform-java-config to v3.35.0 ([#1810](https://github.com/googleapis/java-firestore/issues/1810)) ([f4010e3](https://github.com/googleapis/java-firestore/commit/f4010e3dafe5696a6a5dbf16b18327ffb672e9ee))
* Update dependency org.apache.commons:commons-lang3 to v3.17.0 ([#1792](https://github.com/googleapis/java-firestore/issues/1792)) ([61b9810](https://github.com/googleapis/java-firestore/commit/61b981008cd882f8c4dabaa71cef843b607c9e2c))
* Update opentelemetry.version to v1.42.1 ([#1809](https://github.com/googleapis/java-firestore/issues/1809)) ([cb821d9](https://github.com/googleapis/java-firestore/commit/cb821d981517e318dad4469957d9993c759f56e4))

## [3.25.1](https://github.com/googleapis/java-firestore/compare/v3.25.0...v3.25.1) (2024-08-20)


### Dependencies

* Update dependency com.google.cloud:sdk-platform-java-config to v3.34.0 ([#1795](https://github.com/googleapis/java-firestore/issues/1795)) ([abb3f7f](https://github.com/googleapis/java-firestore/commit/abb3f7fb25844b0a2b7c9eb2132c17eadb3c528a))
* Update opentelemetry.version to v1.41.0 ([#1793](https://github.com/googleapis/java-firestore/issues/1793)) ([165aae9](https://github.com/googleapis/java-firestore/commit/165aae94f2628255f84e68eac08ecef75967a237))

## [3.25.0](https://github.com/googleapis/java-firestore/compare/v3.24.3...v3.25.0) (2024-08-12)


### Features

* Add support for the VectorValue type ([#1716](https://github.com/googleapis/java-firestore/issues/1716)) ([81bfa0d](https://github.com/googleapis/java-firestore/commit/81bfa0daeb4b75b2b964e8480a9baae711540e02))
* Expose the proto changes to support `FindNearest.distance_result_field` parameter and the `FindNearest.distance_threshold` parameter ([6456d85](https://github.com/googleapis/java-firestore/commit/6456d855b2eef93869fcb06e39246a6ada589948))

## [3.24.3](https://github.com/googleapis/java-firestore/compare/v3.24.2...v3.24.3) (2024-08-06)


### Dependencies

* Update dependency com.google.api.grpc:proto-google-cloud-trace-v1 to v2.47.0 ([#1774](https://github.com/googleapis/java-firestore/issues/1774)) ([222629a](https://github.com/googleapis/java-firestore/commit/222629a97da72cfb32e9da6280896d3cee09885c))
* Update dependency com.google.cloud:google-cloud-trace to v2.47.0 ([#1775](https://github.com/googleapis/java-firestore/issues/1775)) ([d3c2744](https://github.com/googleapis/java-firestore/commit/d3c274427d08a7e4ccbcdaa387645adc201360a5))

## [3.24.2](https://github.com/googleapis/java-firestore/compare/v3.24.1...v3.24.2) (2024-07-29)


### Dependencies

* Update dependency com.google.cloud:sdk-platform-java-config to v3.33.0 ([#1762](https://github.com/googleapis/java-firestore/issues/1762)) ([76090ce](https://github.com/googleapis/java-firestore/commit/76090ce87a4614c9416a1738fe5edbd07f40e440))

## [3.24.1](https://github.com/googleapis/java-firestore/compare/v3.24.0...v3.24.1) (2024-07-22)


### Dependencies

* Update dependency com.google.api.grpc:proto-google-cloud-trace-v1 to v1.4.2 ([#1749](https://github.com/googleapis/java-firestore/issues/1749)) ([b20371a](https://github.com/googleapis/java-firestore/commit/b20371a62fa261b50a4522786d4f91a5fac01487))
* Update dependency com.google.api.grpc:proto-google-cloud-trace-v1 to v2 ([#1755](https://github.com/googleapis/java-firestore/issues/1755)) ([fb71213](https://github.com/googleapis/java-firestore/commit/fb712130e51327a71d0c90f6f3cda76398ec9e0a))
* Update dependency com.google.cloud:google-cloud-trace to v2 ([#1756](https://github.com/googleapis/java-firestore/issues/1756)) ([f6989d8](https://github.com/googleapis/java-firestore/commit/f6989d89211849cd301e799406f59283b8162ea9))
* Update dependency com.google.cloud.opentelemetry:exporter-trace to v0.31.0 ([#1750](https://github.com/googleapis/java-firestore/issues/1750)) ([7219bb3](https://github.com/googleapis/java-firestore/commit/7219bb3f0e98462faeb8d7e24f1aedad4cd2de15))
* Update opentelemetry.version to v1.40.0 ([#1753](https://github.com/googleapis/java-firestore/issues/1753)) ([23ce20b](https://github.com/googleapis/java-firestore/commit/23ce20b08d8da195cf32036de4e73cee831225ef))

## [3.24.0](https://github.com/googleapis/java-firestore/compare/v3.23.1...v3.24.0) (2024-07-18)


### Features

* Tracing using OpenTelemetry ([#1728](https://github.com/googleapis/java-firestore/issues/1728)) ([00dc240](https://github.com/googleapis/java-firestore/commit/00dc2403d2a5a5b6809762010a716f17541204e0))


### Dependencies

* Update dependency org.apache.commons:commons-lang3 to v3.15.0 ([#1745](https://github.com/googleapis/java-firestore/issues/1745)) ([05a6f73](https://github.com/googleapis/java-firestore/commit/05a6f73f259050520880d670e5ab997d12e8cafb))

## [3.23.1](https://github.com/googleapis/java-firestore/compare/v3.23.0...v3.23.1) (2024-07-10)


### Dependencies

* Update dependency com.android.tools.metalava:metalava to v1.0.0-alpha11 ([#1736](https://github.com/googleapis/java-firestore/issues/1736)) ([649d7b4](https://github.com/googleapis/java-firestore/commit/649d7b43424201168bf64a38d923b423d731f100))

## [3.23.0](https://github.com/googleapis/java-firestore/compare/v3.22.0...v3.23.0) (2024-07-10)


### Features

* Enable hermetic library generation ([#1697](https://github.com/googleapis/java-firestore/issues/1697)) ([85e66df](https://github.com/googleapis/java-firestore/commit/85e66df5fc51f9aaafe71f784773b9107671c477))


### Bug Fixes

* Correct hermetic library generation script path ([#1727](https://github.com/googleapis/java-firestore/issues/1727)) ([172d224](https://github.com/googleapis/java-firestore/commit/172d224aa767a69e9c02419bb48f506a1861c787))

## [3.22.0](https://github.com/googleapis/java-firestore/compare/v3.21.6...v3.22.0) (2024-06-27)


### Features

* Add bulk delete api ([#1704](https://github.com/googleapis/java-firestore/issues/1704)) ([5ef6254](https://github.com/googleapis/java-firestore/commit/5ef625456afbee781951d2a5c6a9c2548feea92e))


### Dependencies

* Update dependency org.junit.vintage:junit-vintage-engine to v5.10.3 ([#1722](https://github.com/googleapis/java-firestore/issues/1722)) ([c4627a4](https://github.com/googleapis/java-firestore/commit/c4627a4e664d67d5b34a27d791cd0c06ee789f85))

## [3.21.6](https://github.com/googleapis/java-firestore/compare/v3.21.5...v3.21.6) (2024-06-26)


### Dependencies

* Update beam.version to v2.57.0 ([#1715](https://github.com/googleapis/java-firestore/issues/1715)) ([d8dcd5b](https://github.com/googleapis/java-firestore/commit/d8dcd5b93ce41c1bb985a3fd626f93ea3981880a))

## [3.21.5](https://github.com/googleapis/java-firestore/compare/v3.21.4...v3.21.5) (2024-06-25)


### Dependencies

* Update dependency com.google.cloud:sdk-platform-java-config to v3.32.0 ([#1710](https://github.com/googleapis/java-firestore/issues/1710)) ([2906472](https://github.com/googleapis/java-firestore/commit/2906472816001d4ffdc21f3b94a36de7d925f6dc))

## [3.21.4](https://github.com/googleapis/java-firestore/compare/v3.21.3...v3.21.4) (2024-06-10)


### Bug Fixes

* Migrate off GeneratedMessageV3 ([#1692](https://github.com/googleapis/java-firestore/issues/1692)) ([44c26e9](https://github.com/googleapis/java-firestore/commit/44c26e978d01242b7ad468adab96958f6fa0a34f))


### Dependencies

* Update dependency com.google.cloud:sdk-platform-java-config to v3.31.0 ([#1699](https://github.com/googleapis/java-firestore/issues/1699)) ([ef7349a](https://github.com/googleapis/java-firestore/commit/ef7349aa11d10392c8b4afab693dd731fcd3c43d))

## [3.21.3](https://github.com/googleapis/java-firestore/compare/v3.21.2...v3.21.3) (2024-05-17)


### Dependencies

* Update dependency org.graalvm.buildtools:junit-platform-native to v0.10.2 ([#1685](https://github.com/googleapis/java-firestore/issues/1685)) ([d3f329f](https://github.com/googleapis/java-firestore/commit/d3f329fa4d1b0e833843090cdc7adc27c6bb2505))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.10.2 ([#1686](https://github.com/googleapis/java-firestore/issues/1686)) ([bafebb8](https://github.com/googleapis/java-firestore/commit/bafebb8b69f9ccf8166ce5cd218f3346b0e647b9))

## [3.21.2](https://github.com/googleapis/java-firestore/compare/v3.21.1...v3.21.2) (2024-05-16)


### Dependencies

* Update dependency com.google.cloud:sdk-platform-java-config to v3.30.1 ([#1681](https://github.com/googleapis/java-firestore/issues/1681)) ([9fb8531](https://github.com/googleapis/java-firestore/commit/9fb853147d5af34a3ec7e68317be8e588a7cae91))

## [3.21.1](https://github.com/googleapis/java-firestore/compare/v3.21.0...v3.21.1) (2024-05-03)


### Bug Fixes

* Add configurable to run tests against different firestore backends ([#1659](https://github.com/googleapis/java-firestore/issues/1659)) ([a60d2a3](https://github.com/googleapis/java-firestore/commit/a60d2a3622a7193844f150a005bfb89204fc43af))


### Dependencies

* Update beam.version to v2.56.0 ([#1669](https://github.com/googleapis/java-firestore/issues/1669)) ([a4b4d1d](https://github.com/googleapis/java-firestore/commit/a4b4d1dc3e5b13209efb288f0cead7bcea2013e0))
* Update dependency com.google.cloud:sdk-platform-java-config to v3.30.0 ([#1670](https://github.com/googleapis/java-firestore/issues/1670)) ([5bcbf88](https://github.com/googleapis/java-firestore/commit/5bcbf88b1174d5e2615f66d9997be76481842131))

## [3.21.0](https://github.com/googleapis/java-firestore/compare/v3.20.2...v3.21.0) (2024-04-26)


### Features

* Add Vector Index API ([4964982](https://github.com/googleapis/java-firestore/commit/496498271b31a878910c17954350673beade2bef))
* Add VectorSearch API ([4964982](https://github.com/googleapis/java-firestore/commit/496498271b31a878910c17954350673beade2bef))


### Bug Fixes

* **deps:** Update the Java code generator (gapic-generator-java) to 2.39.0 ([#1629](https://github.com/googleapis/java-firestore/issues/1629)) ([4964982](https://github.com/googleapis/java-firestore/commit/496498271b31a878910c17954350673beade2bef))


### Documentation

* Allow 14 week backup retention for Firestore daily backups ([4964982](https://github.com/googleapis/java-firestore/commit/496498271b31a878910c17954350673beade2bef))
* Correct BackupSchedule recurrence docs that mentioned specific time of day ([4964982](https://github.com/googleapis/java-firestore/commit/496498271b31a878910c17954350673beade2bef))

## [3.20.2](https://github.com/googleapis/java-firestore/compare/v3.20.1...v3.20.2) (2024-04-19)


### Dependencies

* Update dependency com.google.cloud:sdk-platform-java-config to v3.29.0 ([#1652](https://github.com/googleapis/java-firestore/issues/1652)) ([1e3b0b9](https://github.com/googleapis/java-firestore/commit/1e3b0b9dde920d18311de226a52652ef71a6a180))

## [3.20.1](https://github.com/googleapis/java-firestore/compare/v3.20.0...v3.20.1) (2024-04-18)


### Dependencies

* Update beam.version to v2.55.1 ([#1643](https://github.com/googleapis/java-firestore/issues/1643)) ([88ce6c3](https://github.com/googleapis/java-firestore/commit/88ce6c3c1855c527243fcdf236d8210e8ecb3610))

## [3.20.0](https://github.com/googleapis/java-firestore/compare/v3.19.3...v3.20.0) (2024-03-26)


### Features

* Query Profiling ([#1609](https://github.com/googleapis/java-firestore/issues/1609)) ([55b1a49](https://github.com/googleapis/java-firestore/commit/55b1a49ad3b75835b6b4f8a1cfd8d665c1a56968))


### Dependencies

* Update beam.version to v2.55.0 ([#1631](https://github.com/googleapis/java-firestore/issues/1631)) ([bdb2e43](https://github.com/googleapis/java-firestore/commit/bdb2e4314d2eacdff69b538876e69e7007427925))

## [3.19.3](https://github.com/googleapis/java-firestore/compare/v3.19.2...v3.19.3) (2024-03-21)


### Dependencies

* Update dependency com.google.cloud:sdk-platform-java-config to v3.28.1 ([#1625](https://github.com/googleapis/java-firestore/issues/1625)) ([f390946](https://github.com/googleapis/java-firestore/commit/f39094608151df51f32a8f91717eee5840a2d4d2))

## [3.19.2](https://github.com/googleapis/java-firestore/compare/v3.19.1...v3.19.2) (2024-03-18)


### Dependencies

* Update dependency com.google.cloud:sdk-platform-java-config to v3.28.1 ([#1617](https://github.com/googleapis/java-firestore/issues/1617)) ([44d5e8d](https://github.com/googleapis/java-firestore/commit/44d5e8d9e6e05c9119dd5a5fdfc51ebba27c71c9))

## [3.19.1](https://github.com/googleapis/java-firestore/compare/v3.19.0...v3.19.1) (2024-03-15)


### Dependencies

* Update dependency com.google.cloud:sdk-platform-java-config to v3.28.0 ([#1612](https://github.com/googleapis/java-firestore/issues/1612)) ([06fa74e](https://github.com/googleapis/java-firestore/commit/06fa74e5fbaf1bbc74ab8d220356ad2c6ab4b7ac))

## [3.19.0](https://github.com/googleapis/java-firestore/compare/v3.18.0...v3.19.0) (2024-03-15)


### Features

* A new message `Backup` is added ([#1611](https://github.com/googleapis/java-firestore/issues/1611)) ([434a55b](https://github.com/googleapis/java-firestore/commit/434a55b478fc617c2ec892a30d3eb1ce027ac54f))
* Add ExplainMetrics field to RunAggregationQueryResponse ([f275b16](https://github.com/googleapis/java-firestore/commit/f275b1603225895e2673131191b4c15927e3bdcd))
* Add ExplainMetrics field to RunQueryResponse ([f275b16](https://github.com/googleapis/java-firestore/commit/f275b1603225895e2673131191b4c15927e3bdcd))
* Add ExplainOptions field to RunAggregationQueryRequest ([f275b16](https://github.com/googleapis/java-firestore/commit/f275b1603225895e2673131191b4c15927e3bdcd))
* Add ExplainOptions field to RunQueryRequest ([f275b16](https://github.com/googleapis/java-firestore/commit/f275b1603225895e2673131191b4c15927e3bdcd))
* Add new types ExplainOptions, ExplainMetrics, PlanSummary, ExecutionStats ([#1608](https://github.com/googleapis/java-firestore/issues/1608)) ([f275b16](https://github.com/googleapis/java-firestore/commit/f275b1603225895e2673131191b4c15927e3bdcd))


### Bug Fixes

* Update DocFX profile ([#1603](https://github.com/googleapis/java-firestore/issues/1603)) ([0a2eb16](https://github.com/googleapis/java-firestore/commit/0a2eb1640e1d4fb13d05bc489ace5a773a0b9a78))

## [3.18.0](https://github.com/googleapis/java-firestore/compare/v3.17.1...v3.18.0) (2024-03-04)


### Features

* `Instant` support ([#1586](https://github.com/googleapis/java-firestore/issues/1586)) ([77a9bfc](https://github.com/googleapis/java-firestore/commit/77a9bfc9c501eeb10ee97f91b0b0b97e92f2c71d))


### Bug Fixes

* **deps:** Update the Java code generator (gapic-generator-java) to 2.37.0 ([#1597](https://github.com/googleapis/java-firestore/issues/1597)) ([7574dfd](https://github.com/googleapis/java-firestore/commit/7574dfd1c73c73c3de7cf3235e55ed20190991b8))
* Only override built-in retry settings when the customer provides them. ([#1588](https://github.com/googleapis/java-firestore/issues/1588)) ([103c37a](https://github.com/googleapis/java-firestore/commit/103c37a92764930480149f288fd9350a829d4953))


### Dependencies

* Update dependency com.google.cloud:sdk-platform-java-config to v3.27.0 ([#1596](https://github.com/googleapis/java-firestore/issues/1596)) ([2672d71](https://github.com/googleapis/java-firestore/commit/2672d7173b2bd5723beb7fa1be4d3e2bf1ec0e9c))

## [3.17.1](https://github.com/googleapis/java-firestore/compare/v3.17.0...v3.17.1) (2024-02-22)


### Dependencies

* Update dependency org.graalvm.buildtools:junit-platform-native to v0.10.1 ([#1576](https://github.com/googleapis/java-firestore/issues/1576)) ([f45af23](https://github.com/googleapis/java-firestore/commit/f45af236c0b74ab2507e232ed2c3e6c2d9363360))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.10.1 ([#1577](https://github.com/googleapis/java-firestore/issues/1577)) ([396d06b](https://github.com/googleapis/java-firestore/commit/396d06bfa6e0353ddf02c4309a220f10020ca90c))

## [3.17.0](https://github.com/googleapis/java-firestore/compare/v3.16.3...v3.17.0) (2024-02-15)


### Features

* Add an API method for reordering firewall policies ([#1572](https://github.com/googleapis/java-firestore/issues/1572)) ([60d8ab1](https://github.com/googleapis/java-firestore/commit/60d8ab167e56806a9ef66d904f6d11f6b45b4ef9))


### Bug Fixes

* Transactions with `readTime` will omit begin and commit transaction requests, and instead pass `readTime` on individual read requests. ([#1565](https://github.com/googleapis/java-firestore/issues/1565)) ([d5fb01a](https://github.com/googleapis/java-firestore/commit/d5fb01ad99a04f7e1ac8327eb14931db0307b13a))


### Dependencies

* Update beam.version to v2.54.0 ([#1571](https://github.com/googleapis/java-firestore/issues/1571)) ([e0d4daa](https://github.com/googleapis/java-firestore/commit/e0d4daafcf7f37f399c2e7a32a69429c451f8ee9))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.25.0 ([#1567](https://github.com/googleapis/java-firestore/issues/1567)) ([b6c1531](https://github.com/googleapis/java-firestore/commit/b6c1531abd2f2075ec3eb925682d65a23298dc29))

## [3.16.3](https://github.com/googleapis/java-firestore/compare/v3.16.2...v3.16.3) (2024-02-05)


### Dependencies

* Update dependency org.junit.vintage:junit-vintage-engine to v5.10.2 ([#1559](https://github.com/googleapis/java-firestore/issues/1559)) ([502cf05](https://github.com/googleapis/java-firestore/commit/502cf0594c030460db5f7d44c08ea0e9398ad2ac))

## [3.16.2](https://github.com/googleapis/java-firestore/compare/v3.16.1...v3.16.2) (2024-02-01)


### Bug Fixes

* Remove QueryMode field from RunAggregationQueryRequest ([32b539c](https://github.com/googleapis/java-firestore/commit/32b539c2431f437ec556923864f967a487c32552))
* Remove QueryMode field from RunQueryRequest ([32b539c](https://github.com/googleapis/java-firestore/commit/32b539c2431f437ec556923864f967a487c32552))
* Remove ResultSetStats field from RunAggregationQueryResponse ([32b539c](https://github.com/googleapis/java-firestore/commit/32b539c2431f437ec556923864f967a487c32552))
* Remove ResultSetStats field from RunQueryResponse ([32b539c](https://github.com/googleapis/java-firestore/commit/32b539c2431f437ec556923864f967a487c32552))
* Remove types QueryMode, QueryPlan, ResultSetStats ([32b539c](https://github.com/googleapis/java-firestore/commit/32b539c2431f437ec556923864f967a487c32552))


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.24.0 ([#1551](https://github.com/googleapis/java-firestore/issues/1551)) ([6874143](https://github.com/googleapis/java-firestore/commit/68741438c7a7fe50da2a72cb9688947ccccf7638))
* Update dependency org.graalvm.buildtools:junit-platform-native to v0.10.0 ([#1553](https://github.com/googleapis/java-firestore/issues/1553)) ([701d820](https://github.com/googleapis/java-firestore/commit/701d82078df9e7cff902072abcc6767a67bde3d6))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.10.0 ([#1554](https://github.com/googleapis/java-firestore/issues/1554)) ([581da1f](https://github.com/googleapis/java-firestore/commit/581da1f963ac951b5ca2d5b9edc2ad8a9f189ca6))

## [3.16.1](https://github.com/googleapis/java-firestore/compare/v3.16.0...v3.16.1) (2024-01-25)


### Bug Fixes

* `internalStream` should handle duplicate `onComplete`s. ([#1523](https://github.com/googleapis/java-firestore/issues/1523)) ([b3067d7](https://github.com/googleapis/java-firestore/commit/b3067d7b382ea5c4c9124a12a701abe2f7289503))
* Allow an explicit MustExist precondition for update ([#1542](https://github.com/googleapis/java-firestore/issues/1542)) ([46e09aa](https://github.com/googleapis/java-firestore/commit/46e09aad7f6689d4dfe82bd284905d52edda4364))
* **deps:** Update the Java code generator (gapic-generator-java) to 2.32.0 ([#1534](https://github.com/googleapis/java-firestore/issues/1534)) ([2281320](https://github.com/googleapis/java-firestore/commit/2281320fd924a1d6c259a493ce703a51f0cd8a03))
* Make rollback best effort. ([#1515](https://github.com/googleapis/java-firestore/issues/1515)) ([4c39af5](https://github.com/googleapis/java-firestore/commit/4c39af50d6d416440164fc5d5360f3912cd8f01b))
* Thread safe UpdateBuilder ([#1537](https://github.com/googleapis/java-firestore/issues/1537)) ([f9cdab5](https://github.com/googleapis/java-firestore/commit/f9cdab5885bd1d500c6fc412eb3090cea9347d0e))


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.22.0 ([#1535](https://github.com/googleapis/java-firestore/issues/1535)) ([04c0e07](https://github.com/googleapis/java-firestore/commit/04c0e0736ddcd49eb42aacb31e2fc087b2a39754))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.23.0 ([#1544](https://github.com/googleapis/java-firestore/issues/1544)) ([79713bf](https://github.com/googleapis/java-firestore/commit/79713bf0fa376a4d22518ae2f5da9660795d9f89))


### Documentation

* Fix formatting due to unclosed backtick ([#1529](https://github.com/googleapis/java-firestore/issues/1529)) ([3c78fe3](https://github.com/googleapis/java-firestore/commit/3c78fe3c248cb212c6e4f91a5bb7aeb8b9b003b0))
* Rring BulkWriter out of BetaApi status. ([#1513](https://github.com/googleapis/java-firestore/issues/1513)) ([c2812f7](https://github.com/googleapis/java-firestore/commit/c2812f7cb72257512ffecc98ec1bdb1109d7d044))

## [3.16.0](https://github.com/googleapis/java-firestore/compare/v3.15.7...v3.16.0) (2024-01-10)


### Features

* Add DeleteDatabase API and delete protection ([#1508](https://github.com/googleapis/java-firestore/issues/1508)) ([81a1b48](https://github.com/googleapis/java-firestore/commit/81a1b48bae2398f13d0081ea203d8dbac2e74987))
* Add new types QueryMode, QueryPlan, ResultSetStats ([#1516](https://github.com/googleapis/java-firestore/issues/1516)) ([3060e86](https://github.com/googleapis/java-firestore/commit/3060e868e467a9ef8399f9d15bd91cc819e7bf05))
* Expose Firestore namespace ID fields in import/export APIs to stable ([21ad25f](https://github.com/googleapis/java-firestore/commit/21ad25f75f91527cf9152a0476af385717e5b111))
* Expose Firestore PITR fields in Database to stable ([#1495](https://github.com/googleapis/java-firestore/issues/1495)) ([21ad25f](https://github.com/googleapis/java-firestore/commit/21ad25f75f91527cf9152a0476af385717e5b111))
* Expose Firestore snapshot_time field in export API to stable ([21ad25f](https://github.com/googleapis/java-firestore/commit/21ad25f75f91527cf9152a0476af385717e5b111))
* Logical termination for firestore.getAll(...). ([#1517](https://github.com/googleapis/java-firestore/issues/1517)) ([c6448fc](https://github.com/googleapis/java-firestore/commit/c6448fc6411de01b3453e58bcbfca633e0849166))


### Bug Fixes

* Better error message when Transaction/WriteBatch is modified after commit. ([#1503](https://github.com/googleapis/java-firestore/issues/1503)) ([9693c7b](https://github.com/googleapis/java-firestore/commit/9693c7b46dcb63b0348217ecb7c29b95ecd04191))
* **deps:** Update the Java code generator (gapic-generator-java) to 2.31.0 ([#1520](https://github.com/googleapis/java-firestore/issues/1520)) ([c4c5a0b](https://github.com/googleapis/java-firestore/commit/c4c5a0b5a5f0e428b041c0ace80c1bbed3872564))


### Dependencies

* Update beam.version to v2.53.0 ([#1514](https://github.com/googleapis/java-firestore/issues/1514)) ([7639e0d](https://github.com/googleapis/java-firestore/commit/7639e0d0eefb9df84ab535f61c836d0dfb0ef6cf))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.21.0 ([#1518](https://github.com/googleapis/java-firestore/issues/1518)) ([866b2b4](https://github.com/googleapis/java-firestore/commit/866b2b48ee7acf644dc6355054d7b2ae7e627c13))


### Documentation

* Assorted typo fixes and whitespace updates ([21ad25f](https://github.com/googleapis/java-firestore/commit/21ad25f75f91527cf9152a0476af385717e5b111))
* Remove latin abbreviations from comments. ([#1457](https://github.com/googleapis/java-firestore/issues/1457)) ([1cfa03d](https://github.com/googleapis/java-firestore/commit/1cfa03d36a04f17fba91cc7b1f05a59ee149c7aa))
* Tweak Count API docs ([#1522](https://github.com/googleapis/java-firestore/issues/1522)) ([e25ae13](https://github.com/googleapis/java-firestore/commit/e25ae1391893f26faac9938d49918fcad6a9d0ed))

## [3.15.7](https://github.com/googleapis/java-firestore/compare/v3.15.6...v3.15.7) (2023-12-01)


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.20.0 ([#1490](https://github.com/googleapis/java-firestore/issues/1490)) ([73a85e7](https://github.com/googleapis/java-firestore/commit/73a85e7b39bee9024ec06995c5d2a269ddf61503))

## [3.15.6](https://github.com/googleapis/java-firestore/compare/v3.15.5...v3.15.6) (2023-11-22)


### Dependencies

* Update beam.version to v2.52.0 ([#1480](https://github.com/googleapis/java-firestore/issues/1480)) ([45e33f7](https://github.com/googleapis/java-firestore/commit/45e33f771e012c2ad889466191de03375b7a1e83))
* Update dependency org.apache.commons:commons-lang3 to v3.14.0 ([#1482](https://github.com/googleapis/java-firestore/issues/1482)) ([3ef71f8](https://github.com/googleapis/java-firestore/commit/3ef71f8da4c07a5e9ef3a44e3f30290d20382c10))

## [3.15.5](https://github.com/googleapis/java-firestore/compare/v3.15.4...v3.15.5) (2023-11-14)


### Bug Fixes

* Prevent watch stream from emitting events after close. ([#1471](https://github.com/googleapis/java-firestore/issues/1471)) ([ee3f8c0](https://github.com/googleapis/java-firestore/commit/ee3f8c0c6e2c8aff64f429e8eea649cc6614c74f))


### Dependencies

* Update actions/github-script action to v7 ([#1473](https://github.com/googleapis/java-firestore/issues/1473)) ([1097a0b](https://github.com/googleapis/java-firestore/commit/1097a0b97c1dff40c07b657417db4ac431822619))
* Update actions/github-script action to v7 ([#1475](https://github.com/googleapis/java-firestore/issues/1475)) ([d848d87](https://github.com/googleapis/java-firestore/commit/d848d875738260cde620f5cedfc15bf4dae31aac))

## [3.15.4](https://github.com/googleapis/java-firestore/compare/v3.15.3...v3.15.4) (2023-11-07)


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.19.0 ([#1467](https://github.com/googleapis/java-firestore/issues/1467)) ([a048707](https://github.com/googleapis/java-firestore/commit/a04870759725f03304842373df46f8186861a38f))

## [3.15.3](https://github.com/googleapis/java-firestore/compare/v3.15.2...v3.15.3) (2023-11-06)


### Dependencies

* Update dependency org.junit.vintage:junit-vintage-engine to v5.10.1 ([#1463](https://github.com/googleapis/java-firestore/issues/1463)) ([6180322](https://github.com/googleapis/java-firestore/commit/6180322051a63f537d5d355fecc68fe798b44035))

## [3.15.2](https://github.com/googleapis/java-firestore/compare/v3.15.1...v3.15.2) (2023-10-20)


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.18.0 ([#1450](https://github.com/googleapis/java-firestore/issues/1450)) ([d32d343](https://github.com/googleapis/java-firestore/commit/d32d343ddd4e72c8b434372657a51fc631ba2887))
* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.28 ([#1451](https://github.com/googleapis/java-firestore/issues/1451)) ([a008a69](https://github.com/googleapis/java-firestore/commit/a008a6943f278658be914b3b88f196a30e36deb1))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.28 ([#1452](https://github.com/googleapis/java-firestore/issues/1452)) ([59daefe](https://github.com/googleapis/java-firestore/commit/59daefe4c3b760c4f3c0b0cf00655465859be4ef))

## [3.15.1](https://github.com/googleapis/java-firestore/compare/v3.15.0...v3.15.1) (2023-10-11)


### Dependencies

* Update dependency org.apache.beam:beam-runners-direct-java to v2.51.0 ([#1443](https://github.com/googleapis/java-firestore/issues/1443)) ([738f93a](https://github.com/googleapis/java-firestore/commit/738f93adca3dc42b835c454bf0fc84d87f4bb6b9))

## [3.15.0](https://github.com/googleapis/java-firestore/compare/v3.14.4...v3.15.0) (2023-10-10)


### Features

* Sum and Average aggregations ([#1387](https://github.com/googleapis/java-firestore/issues/1387)) ([afa5c01](https://github.com/googleapis/java-firestore/commit/afa5c0124c98a0a58259e54c9bb054248b4d4104))


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.17.0 ([#1437](https://github.com/googleapis/java-firestore/issues/1437)) ([cd006f9](https://github.com/googleapis/java-firestore/commit/cd006f90db7c57742d57be74ba244cb0f24a4620))

## [3.14.4](https://github.com/googleapis/java-firestore/compare/v3.14.3...v3.14.4) (2023-09-28)


### Bug Fixes

* Add tests for multiple inequality support ([#1392](https://github.com/googleapis/java-firestore/issues/1392)) ([e01b3a1](https://github.com/googleapis/java-firestore/commit/e01b3a1c2489b9cde11543584ab32270960c41ce))


### Dependencies

* Remove unused dependency that is blocking PR 1428 ([#1429](https://github.com/googleapis/java-firestore/issues/1429)) ([73ff8dc](https://github.com/googleapis/java-firestore/commit/73ff8dca20052715ae88e91bd5c322d06dbeccc0))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.16.1 ([#1431](https://github.com/googleapis/java-firestore/issues/1431)) ([38832f9](https://github.com/googleapis/java-firestore/commit/38832f9853019aedbbf04d34a64d007cbff2752f))
* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.27 ([#1425](https://github.com/googleapis/java-firestore/issues/1425)) ([dc26bbb](https://github.com/googleapis/java-firestore/commit/dc26bbb91e291d53597221873d3c0995de3d31a2))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.27 ([#1426](https://github.com/googleapis/java-firestore/issues/1426)) ([5e8b299](https://github.com/googleapis/java-firestore/commit/5e8b2998c90829eccef5d18d50541ba5ea3d74f5))

## [3.14.3](https://github.com/googleapis/java-firestore/compare/v3.14.2...v3.14.3) (2023-09-12)


### Bug Fixes

* Add reflections configs for generated firestore classes ([#1419](https://github.com/googleapis/java-firestore/issues/1419)) ([1c5e09f](https://github.com/googleapis/java-firestore/commit/1c5e09f08f3e8d57152fa7f0fae52ef2cea8331b))


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.15.0 ([#1417](https://github.com/googleapis/java-firestore/issues/1417)) ([3626776](https://github.com/googleapis/java-firestore/commit/3626776483d005ba5d07046eebe25b9c6b39242e))

## [3.14.2](https://github.com/googleapis/java-firestore/compare/v3.14.1...v3.14.2) (2023-09-07)


### Dependencies

* Update beam.version to v2.50.0 ([#1410](https://github.com/googleapis/java-firestore/issues/1410)) ([fa14cad](https://github.com/googleapis/java-firestore/commit/fa14cad1ed9536c97279461af9355eb7674c4a85))
* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.26 ([#1413](https://github.com/googleapis/java-firestore/issues/1413)) ([501af1a](https://github.com/googleapis/java-firestore/commit/501af1ac6d7b62fd6128a1d30cc234c00fc9c592))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.26 ([#1414](https://github.com/googleapis/java-firestore/issues/1414)) ([afb93d2](https://github.com/googleapis/java-firestore/commit/afb93d2ba5e7a300da64bdc98467481c8d0151b7))

## [3.14.1](https://github.com/googleapis/java-firestore/compare/v3.14.0...v3.14.1) (2023-08-25)


### Dependencies

* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.25 ([#1405](https://github.com/googleapis/java-firestore/issues/1405)) ([01720e5](https://github.com/googleapis/java-firestore/commit/01720e5a56645e5e0f4aae83af401256eab2aadb))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.25 ([#1406](https://github.com/googleapis/java-firestore/issues/1406)) ([438ad97](https://github.com/googleapis/java-firestore/commit/438ad974e4e37f60d889ccfe716d2427ebf74ffc))

## [3.14.0](https://github.com/googleapis/java-firestore/compare/v3.13.8...v3.14.0) (2023-08-08)


### Features

* Publish proto definitions for SUM/AVG in Firestore ([#1304](https://github.com/googleapis/java-firestore/issues/1304)) ([b025d11](https://github.com/googleapis/java-firestore/commit/b025d118433b3930b5186621ef852b4219c2274d))


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.14.0 ([#1385](https://github.com/googleapis/java-firestore/issues/1385)) ([d215982](https://github.com/googleapis/java-firestore/commit/d215982730aae862bb0b113887b3ebfc1413d602))
* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.24 ([#1388](https://github.com/googleapis/java-firestore/issues/1388)) ([24be02b](https://github.com/googleapis/java-firestore/commit/24be02b562780a76847608ca18e8ab2aa4d4514e))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.24 ([#1389](https://github.com/googleapis/java-firestore/issues/1389)) ([34e30e0](https://github.com/googleapis/java-firestore/commit/34e30e053e891f2dadcb09e4dc918dca2709c23d))

## [3.13.8](https://github.com/googleapis/java-firestore/compare/v3.13.7...v3.13.8) (2023-07-28)


### Dependencies

* Update dependency org.apache.commons:commons-lang3 to v3.13.0 ([#1380](https://github.com/googleapis/java-firestore/issues/1380)) ([f6f07fb](https://github.com/googleapis/java-firestore/commit/f6f07fbccfcb331d318f66d75a7083695dc21bbb))

## [3.13.7](https://github.com/googleapis/java-firestore/compare/v3.13.6...v3.13.7) (2023-07-27)


### Dependencies

* Update beam.version to v2.49.0 ([#1357](https://github.com/googleapis/java-firestore/issues/1357)) ([6eaf446](https://github.com/googleapis/java-firestore/commit/6eaf44650e6ef8ea0ec68e3a7195519c2f631ed2))

## [3.13.6](https://github.com/googleapis/java-firestore/compare/v3.13.5...v3.13.6) (2023-07-24)


### Dependencies

* Update dependency org.junit.vintage:junit-vintage-engine to v5.10.0 ([#1368](https://github.com/googleapis/java-firestore/issues/1368)) ([188a8e9](https://github.com/googleapis/java-firestore/commit/188a8e9abfa3c500327e45327966e609b12b2267))

## [3.13.5](https://github.com/googleapis/java-firestore/compare/v3.13.4...v3.13.5) (2023-07-20)


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.13.1 ([#1364](https://github.com/googleapis/java-firestore/issues/1364)) ([7dde6ee](https://github.com/googleapis/java-firestore/commit/7dde6ee0b0e39c72665314da25dd9a71aab29e75))

## [3.13.4](https://github.com/googleapis/java-firestore/compare/v3.13.3...v3.13.4) (2023-07-20)


### Bug Fixes

* Remove  'x-goog-request-params' header from GRPC requests due to incorrect format. ([#1358](https://github.com/googleapis/java-firestore/issues/1358)) ([1a1bf5f](https://github.com/googleapis/java-firestore/commit/1a1bf5f101d44b0870b44ddf225ccd66d9c2bbc8))

## [3.13.3](https://github.com/googleapis/java-firestore/compare/v3.13.2...v3.13.3) (2023-07-13)


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.13.0 ([#1351](https://github.com/googleapis/java-firestore/issues/1351)) ([7c11f8a](https://github.com/googleapis/java-firestore/commit/7c11f8a3667ad9bcc217813a7867e0d18760948e))

## [3.13.2](https://github.com/googleapis/java-firestore/compare/v3.13.1...v3.13.2) (2023-06-22)


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.12.0 ([#1338](https://github.com/googleapis/java-firestore/issues/1338)) ([0ef1882](https://github.com/googleapis/java-firestore/commit/0ef18821e1bec0a99da5609f6b894f0c4131f6c5))

## [3.13.1](https://github.com/googleapis/java-firestore/compare/v3.13.0...v3.13.1) (2023-06-21)


### Dependencies

* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.23 ([#1329](https://github.com/googleapis/java-firestore/issues/1329)) ([ea5e78f](https://github.com/googleapis/java-firestore/commit/ea5e78fd136cad86ce439ca0e7338ed84ef1a3d7))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.23 ([#1330](https://github.com/googleapis/java-firestore/issues/1330)) ([63a01e6](https://github.com/googleapis/java-firestore/commit/63a01e6034ed2c6f6f3613da01ca07d6dffb1909))

## [3.13.0](https://github.com/googleapis/java-firestore/compare/v3.12.1...v3.13.0) (2023-06-12)


### Features

* Add toString methods to classes comprising WriteBatch ([#1281](https://github.com/googleapis/java-firestore/issues/1281)) ([9df8028](https://github.com/googleapis/java-firestore/commit/9df80286f350ce35c5ed4b2a44df117b7e241a4a))


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.11.0 ([#1322](https://github.com/googleapis/java-firestore/issues/1322)) ([c2bca72](https://github.com/googleapis/java-firestore/commit/c2bca72f27206eaed813199be7b4944d085246e2))

## [3.12.1](https://github.com/googleapis/java-firestore/compare/v3.12.0...v3.12.1) (2023-06-05)


### Dependencies

* Update beam.version to v2.48.0 ([#1311](https://github.com/googleapis/java-firestore/issues/1311)) ([0a20e1a](https://github.com/googleapis/java-firestore/commit/0a20e1a32a231372313f77c29ecaec3f085fcb6e))

## [3.12.0](https://github.com/googleapis/java-firestore/compare/v3.11.0...v3.12.0) (2023-05-30)


### Features

* Add ApiScope and COLLECTION_RECURSIVE query_scope for Firestore index ([#1300](https://github.com/googleapis/java-firestore/issues/1300)) ([b84a7cd](https://github.com/googleapis/java-firestore/commit/b84a7cd2155484692fc8447c0d27a1cdaa9c8fa1))


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.10.1 ([#1305](https://github.com/googleapis/java-firestore/issues/1305)) ([b734212](https://github.com/googleapis/java-firestore/commit/b734212cec11e51b5219b71725df92b7c722791d))

## [3.11.0](https://github.com/googleapis/java-firestore/compare/v3.10.0...v3.11.0) (2023-05-12)


### Features

* Add bloom filter related proto fields ([#1285](https://github.com/googleapis/java-firestore/issues/1285)) ([9b14c1b](https://github.com/googleapis/java-firestore/commit/9b14c1b69ca5a70cd92feaa41a520e732c0b3cee))


### Dependencies

* Update beam.version to v2.47.0 ([#1292](https://github.com/googleapis/java-firestore/issues/1292)) ([e9f11e8](https://github.com/googleapis/java-firestore/commit/e9f11e86aafaa4a50cca789c7349ac59c4c63ccb))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.9.0 ([#1291](https://github.com/googleapis/java-firestore/issues/1291)) ([6dd0e8f](https://github.com/googleapis/java-firestore/commit/6dd0e8fe93cd1f18a949ffd98a247d7364d9f475))
* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.22 ([#1293](https://github.com/googleapis/java-firestore/issues/1293)) ([e8e5f9b](https://github.com/googleapis/java-firestore/commit/e8e5f9b056c94d68c01b90bf49b1d6908b511ab5))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.22 ([#1294](https://github.com/googleapis/java-firestore/issues/1294)) ([f0ceb7f](https://github.com/googleapis/java-firestore/commit/f0ceb7fc076e43eb62c1a75fa620ee3e510739f4))

## [3.10.0](https://github.com/googleapis/java-firestore/compare/v3.9.6...v3.10.0) (2023-04-27)


### Features

* Add bloom filter related proto fields (only in the preview API surface) ([#1274](https://github.com/googleapis/java-firestore/issues/1274)) ([41909b7](https://github.com/googleapis/java-firestore/commit/41909b712bd0e373218f03ae7e978df1259cfd0d))

## [3.9.6](https://github.com/googleapis/java-firestore/compare/v3.9.5...v3.9.6) (2023-04-26)


### Dependencies

* Update dependency org.junit.vintage:junit-vintage-engine to v5.9.3 ([#1275](https://github.com/googleapis/java-firestore/issues/1275)) ([1f32893](https://github.com/googleapis/java-firestore/commit/1f328937a9e1a1ed5b76400a65580ee79562d1f2))

## [3.9.5](https://github.com/googleapis/java-firestore/compare/v3.9.4...v3.9.5) (2023-04-25)


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.8.0 ([#1268](https://github.com/googleapis/java-firestore/issues/1268)) ([8a92dc9](https://github.com/googleapis/java-firestore/commit/8a92dc915ae30c339a90d0e2fe1afb2cbbb0aa3f))

## [3.9.4](https://github.com/googleapis/java-firestore/compare/v3.9.3...v3.9.4) (2023-04-12)


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.7.0 ([#1257](https://github.com/googleapis/java-firestore/issues/1257)) ([52db039](https://github.com/googleapis/java-firestore/commit/52db039efcc9330897fd0724929573b5d66fbfee))
* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.21 ([#1258](https://github.com/googleapis/java-firestore/issues/1258)) ([12bcf02](https://github.com/googleapis/java-firestore/commit/12bcf0295fc9b1538b97b24ed7d3797fa97f0294))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.21 ([#1259](https://github.com/googleapis/java-firestore/issues/1259)) ([19b5da2](https://github.com/googleapis/java-firestore/commit/19b5da23da2b87b7041446582b9fc8cc08045456))

## [3.9.3](https://github.com/googleapis/java-firestore/compare/v3.9.2...v3.9.3) (2023-03-29)


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.6.0 ([#1247](https://github.com/googleapis/java-firestore/issues/1247)) ([aa098e0](https://github.com/googleapis/java-firestore/commit/aa098e0966d46cf6e2206baab95f4acbfcbfbc92))

## [3.9.2](https://github.com/googleapis/java-firestore/compare/v3.9.1...v3.9.2) (2023-03-20)


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.5.0 ([#1239](https://github.com/googleapis/java-firestore/issues/1239)) ([61b1439](https://github.com/googleapis/java-firestore/commit/61b14391c965b20c49a50e293e2a6f12c7abb5e0))

## [3.9.1](https://github.com/googleapis/java-firestore/compare/v3.9.0...v3.9.1) (2023-03-15)


### Dependencies

* Update beam.version to v2.46.0 ([#1228](https://github.com/googleapis/java-firestore/issues/1228)) ([ffc853f](https://github.com/googleapis/java-firestore/commit/ffc853fa85956dd635c79bdd12b0ae38165cbdbb))

## [3.9.0](https://github.com/googleapis/java-firestore/compare/v3.8.2...v3.9.0) (2023-03-06)


### Features

* Enable `OR` Query support. ([#1007](https://github.com/googleapis/java-firestore/issues/1007)) ([e502cd4](https://github.com/googleapis/java-firestore/commit/e502cd4a91396360815f540d6058291a75e15951))

## [3.8.2](https://github.com/googleapis/java-firestore/compare/v3.8.1...v3.8.2) (2023-03-02)


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.4.0 ([#1219](https://github.com/googleapis/java-firestore/issues/1219)) ([fe84125](https://github.com/googleapis/java-firestore/commit/fe84125054618bb1dbcfa1d648369a8df0120531))

## [3.8.1](https://github.com/googleapis/java-firestore/compare/v3.8.0...v3.8.1) (2023-02-17)


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.3.0 ([#1206](https://github.com/googleapis/java-firestore/issues/1206)) ([a118ce0](https://github.com/googleapis/java-firestore/commit/a118ce07b9af0f1ae16197de7d26a3a035223b20))

## [3.8.0](https://github.com/googleapis/java-firestore/compare/v3.7.10...v3.8.0) (2023-02-15)


### Features

* Add `OR` query support ([#1198](https://github.com/googleapis/java-firestore/issues/1198)) ([566b788](https://github.com/googleapis/java-firestore/commit/566b7884fd462630195dc2ffee79cc5345c80c03))


### Dependencies

* Update beam.version to v2.45.0 ([#1201](https://github.com/googleapis/java-firestore/issues/1201)) ([196a75d](https://github.com/googleapis/java-firestore/commit/196a75d4708ec8b1e61c114ea815a66eb5ab27f4))
* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.20 ([#1196](https://github.com/googleapis/java-firestore/issues/1196)) ([51fe67c](https://github.com/googleapis/java-firestore/commit/51fe67c59d674ea76332f5c0b0fccd9a2c10d39c))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.20 ([#1197](https://github.com/googleapis/java-firestore/issues/1197)) ([a66b8b4](https://github.com/googleapis/java-firestore/commit/a66b8b4e38a8109753769bcbda2dcb2ae8d58692))

## [3.7.10](https://github.com/googleapis/java-firestore/compare/v3.7.9...v3.7.10) (2023-02-06)


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.2.0 ([#1185](https://github.com/googleapis/java-firestore/issues/1185)) ([42c34da](https://github.com/googleapis/java-firestore/commit/42c34dabe3ecb89401967f0f25593cfcfb63bc94))

## [3.7.9](https://github.com/googleapis/java-firestore/compare/v3.7.8...v3.7.9) (2023-01-27)


### Bug Fixes

* **java:** Fix error message returned for  invalid snapshot listener inequality filter ([#1093](https://github.com/googleapis/java-firestore/issues/1093)) ([bf7f4a3](https://github.com/googleapis/java-firestore/commit/bf7f4a3b87311437a364cadaf46da4cb018a28c7))
* **java:** Skip fixing poms for special modules ([#1744](https://github.com/googleapis/java-firestore/issues/1744)) ([#1172](https://github.com/googleapis/java-firestore/issues/1172)) ([222be48](https://github.com/googleapis/java-firestore/commit/222be4882971e5175ae7b9b029cc83047a5a7163))

## [3.7.8](https://github.com/googleapis/java-firestore/compare/v3.7.7...v3.7.8) (2023-01-20)


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.1.2 ([#1174](https://github.com/googleapis/java-firestore/issues/1174)) ([187a9be](https://github.com/googleapis/java-firestore/commit/187a9be1695d21abed12b60b8de2649f7afe54a3))

## [3.7.7](https://github.com/googleapis/java-firestore/compare/v3.7.6...v3.7.7) (2023-01-18)


### Dependencies

* Update beam.version to v2.44.0 ([#1166](https://github.com/googleapis/java-firestore/issues/1166)) ([3364d6e](https://github.com/googleapis/java-firestore/commit/3364d6e859f43145beeab81817db4e524740a00b))

## [3.7.6](https://github.com/googleapis/java-firestore/compare/v3.7.5...v3.7.6) (2023-01-13)


### Dependencies

* Update dependency org.junit.vintage:junit-vintage-engine to v5.9.2 ([#1158](https://github.com/googleapis/java-firestore/issues/1158)) ([418b2bf](https://github.com/googleapis/java-firestore/commit/418b2bfed98f3e88dac63771e4b55f2b157fe184))

## [3.7.5](https://github.com/googleapis/java-firestore/compare/v3.7.4...v3.7.5) (2023-01-13)


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.1.1 ([#1157](https://github.com/googleapis/java-firestore/issues/1157)) ([c7c688b](https://github.com/googleapis/java-firestore/commit/c7c688b1357edfc61f1f86b2c282b80ddb48f2c4))

## [3.7.4](https://github.com/googleapis/java-firestore/compare/v3.7.3...v3.7.4) (2022-12-08)


### Dependencies

* Update multiple dependencies atomically ([#1145](https://github.com/googleapis/java-firestore/issues/1145)) ([36bb40b](https://github.com/googleapis/java-firestore/commit/36bb40b97fb3a2eb44b35437fe0322644dc2bffd))

## [3.7.3](https://github.com/googleapis/java-firestore/compare/v3.7.2...v3.7.3) (2022-11-21)


### Dependencies

* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.18 ([#1132](https://github.com/googleapis/java-firestore/issues/1132)) ([6b57290](https://github.com/googleapis/java-firestore/commit/6b572900bc792c18d8f161fb1d1a01b72a9962d9))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.18 ([#1133](https://github.com/googleapis/java-firestore/issues/1133)) ([8cb45ae](https://github.com/googleapis/java-firestore/commit/8cb45aebb9424187ae4c7ed00cb337b73baac0d7))

## [3.7.2](https://github.com/googleapis/java-firestore/compare/v3.7.1...v3.7.2) (2022-11-18)


### Dependencies

* Update beam.version to v2.43.0 ([#1127](https://github.com/googleapis/java-firestore/issues/1127)) ([ff1df71](https://github.com/googleapis/java-firestore/commit/ff1df71f96b7c6c1fda0e53cdca5097b024d9812))

## [3.7.1](https://github.com/googleapis/java-firestore/compare/v3.7.0...v3.7.1) (2022-11-08)


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.6 ([#1092](https://github.com/googleapis/java-firestore/issues/1092)) ([019840f](https://github.com/googleapis/java-firestore/commit/019840fb0883fb41cdc294f09e35f39745a78cb4))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.17 ([#1087](https://github.com/googleapis/java-firestore/issues/1087)) ([a78be32](https://github.com/googleapis/java-firestore/commit/a78be324ccd0ba2ebff429447b8ce0fe39727360))

## [3.7.0](https://github.com/googleapis/java-firestore/compare/v3.6.0...v3.7.0) (2022-10-22)


### Features

* Add retry logic to COUNT queries ([#1062](https://github.com/googleapis/java-firestore/issues/1062)) ([5789e4b](https://github.com/googleapis/java-firestore/commit/5789e4b57f38e8cab82bc720b28578e86d82a2cc))


### Bug Fixes

* Fix limitToLast queries with cursors ([#1072](https://github.com/googleapis/java-firestore/issues/1072)) ([e9e1548](https://github.com/googleapis/java-firestore/commit/e9e15489112d49a7f8716300ec9af504fcfb5786))


### Dependencies

* Update beam.version to v2.42.0 ([#1066](https://github.com/googleapis/java-firestore/issues/1066)) ([03de01a](https://github.com/googleapis/java-firestore/commit/03de01ab58ab3d312bef63c54b202b8c911cef54))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.5 ([#1071](https://github.com/googleapis/java-firestore/issues/1071)) ([4c3f122](https://github.com/googleapis/java-firestore/commit/4c3f12286424ce7601a106b4338bc89b67ad51fb))
* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.16 ([#1064](https://github.com/googleapis/java-firestore/issues/1064)) ([a7ddc9e](https://github.com/googleapis/java-firestore/commit/a7ddc9e7fe708bd07595973c56fb2e392917915d))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.15 ([#1065](https://github.com/googleapis/java-firestore/issues/1065)) ([d9e7803](https://github.com/googleapis/java-firestore/commit/d9e7803d257b0edfae8648b925e040c7a6fcdb60))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.16 ([#1069](https://github.com/googleapis/java-firestore/issues/1069)) ([97ef50a](https://github.com/googleapis/java-firestore/commit/97ef50a518c5b207b28e0a81022cc96ed4e5e5ae))

## [3.6.0](https://github.com/googleapis/java-firestore/compare/v3.5.0...v3.6.0) (2022-10-04)


### Features

* Count queries (not available for use yet) ([#1033](https://github.com/googleapis/java-firestore/issues/1033)) ([8b60612](https://github.com/googleapis/java-firestore/commit/8b60612f1922a4c377fac357ee7f4304362622f3))
* Make count queries publicly available for use ([#1042](https://github.com/googleapis/java-firestore/issues/1042)) ([1c8d242](https://github.com/googleapis/java-firestore/commit/1c8d2428d94ab8b3c18a8cad14daa2a1e39af369))


### Documentation

* AggregateQuery.java: describe why we ignore subsequent responses ([#1041](https://github.com/googleapis/java-firestore/issues/1041)) ([8150544](https://github.com/googleapis/java-firestore/commit/8150544aee0aa04a5e6239dbc4994ddd056393ba))


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.4 ([#1053](https://github.com/googleapis/java-firestore/issues/1053)) ([9b4c26e](https://github.com/googleapis/java-firestore/commit/9b4c26eac062fa73c8b275978f35c5bfb8cdfc21))
* Update dependency org.graalvm.buildtools:junit-platform-native to v0.9.14 ([#1045](https://github.com/googleapis/java-firestore/issues/1045)) ([04b3861](https://github.com/googleapis/java-firestore/commit/04b3861d874dcd63713e62bd7717097ca8f68a3c))
* Update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.14 ([#1046](https://github.com/googleapis/java-firestore/issues/1046)) ([6631a58](https://github.com/googleapis/java-firestore/commit/6631a58553a12e1f48d060d0b87cfa8683492b94))
* Update dependency org.junit.vintage:junit-vintage-engine to v5.9.1 ([#1039](https://github.com/googleapis/java-firestore/issues/1039)) ([84423f4](https://github.com/googleapis/java-firestore/commit/84423f4db6e35f9d30a34a5bc2d29050380840ec))

## [3.5.0](https://github.com/googleapis/java-firestore/compare/v3.4.2...v3.5.0) (2022-09-16)


### Features

* Add firestore aggregation query apis to the stable googleapis branch ([#1030](https://github.com/googleapis/java-firestore/issues/1030)) ([0e3e2ac](https://github.com/googleapis/java-firestore/commit/0e3e2ac98d1e505e7fe9bb17b2bdb8e7089776cf))


### Dependencies

* Update actions/setup-java action to v3 ([#1031](https://github.com/googleapis/java-firestore/issues/1031)) ([1aae546](https://github.com/googleapis/java-firestore/commit/1aae5463ae781787a529d424be2d145718250781))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.2 ([#1032](https://github.com/googleapis/java-firestore/issues/1032)) ([9b68360](https://github.com/googleapis/java-firestore/commit/9b6836031c7af75e4fc3350f36bef425d97cbfeb))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.3 ([#1034](https://github.com/googleapis/java-firestore/issues/1034)) ([5acd8e4](https://github.com/googleapis/java-firestore/commit/5acd8e415f966a7a902cae6ad324f70377b75528))

## [3.4.2](https://github.com/googleapis/java-firestore/compare/v3.4.1...v3.4.2) (2022-08-24)


### Dependencies

* update beam.version to v2.41.0 ([#1022](https://github.com/googleapis/java-firestore/issues/1022)) ([fb14e2f](https://github.com/googleapis/java-firestore/commit/fb14e2fe0fe20614d1973c3be32f7d108a112028))

## [3.4.1](https://github.com/googleapis/java-firestore/compare/v3.4.0...v3.4.1) (2022-08-19)


### Bug Fixes

* declare gson as runtime rather than test ([#1004](https://github.com/googleapis/java-firestore/issues/1004)) ([e37e997](https://github.com/googleapis/java-firestore/commit/e37e997075288844c2fb1807b166007177ebea2f))

## [3.4.0](https://github.com/googleapis/java-firestore/compare/v3.3.0...v3.4.0) (2022-08-03)


### Features

* Support for Composite Filters. ([#975](https://github.com/googleapis/java-firestore/issues/975)) ([9d0653a](https://github.com/googleapis/java-firestore/commit/9d0653aa5e488af847ae1c8fbbd9ae60bac9149a))


### Bug Fixes

* update gapic-generator-java with mock service generation fixes ([#960](https://github.com/googleapis/java-firestore/issues/960)) ([a9338ff](https://github.com/googleapis/java-firestore/commit/a9338ff8c0039111f1e1da9db460626a7b2c98ec))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v3 ([#1000](https://github.com/googleapis/java-firestore/issues/1000)) ([a3c4ec5](https://github.com/googleapis/java-firestore/commit/a3c4ec5db33fc0217e2d5c9c0799570a0a63a2d0))
* update dependency org.graalvm.buildtools:junit-platform-native to v0.9.12 ([#972](https://github.com/googleapis/java-firestore/issues/972)) ([8cf33b0](https://github.com/googleapis/java-firestore/commit/8cf33b053d784cd2d03ed1d6c37fe17e9f96d677))
* update dependency org.graalvm.buildtools:junit-platform-native to v0.9.13 ([#988](https://github.com/googleapis/java-firestore/issues/988)) ([f8d9496](https://github.com/googleapis/java-firestore/commit/f8d949688e2eba095d008d6a36bb71cc9860fd61))
* update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.13 ([#989](https://github.com/googleapis/java-firestore/issues/989)) ([4c768e3](https://github.com/googleapis/java-firestore/commit/4c768e3939b2820b8c93216df4fc1bd7352253a1))
* update dependency org.junit.vintage:junit-vintage-engine to v5.9.0 ([#997](https://github.com/googleapis/java-firestore/issues/997)) ([d4dd4d8](https://github.com/googleapis/java-firestore/commit/d4dd4d8b9f83f54900eae7ea119e24e0e68c551b))

## [3.3.0](https://github.com/googleapis/java-firestore/compare/v3.2.0...v3.3.0) (2022-07-01)


### Features

* add logical termination for RunQueryResponse ([#956](https://github.com/googleapis/java-firestore/issues/956)) ([1d869c8](https://github.com/googleapis/java-firestore/commit/1d869c8fbe5e4009bbded2fb24f978f7cf48c515))


### Bug Fixes

* add build script for JDK 17 native image testing ([#965](https://github.com/googleapis/java-firestore/issues/965)) ([963e384](https://github.com/googleapis/java-firestore/commit/963e384b254056b6879744ba0b5d69fc0699f0bf))


### Performance Improvements

* Change how proto was called in Query.java ([#970](https://github.com/googleapis/java-firestore/issues/970)) ([f6f6352](https://github.com/googleapis/java-firestore/commit/f6f63520e93d9b3db0a915be58ea3cd37cec68d2))


### Dependencies

* update beam.version to v2.40.0 ([#978](https://github.com/googleapis/java-firestore/issues/978)) ([44276f8](https://github.com/googleapis/java-firestore/commit/44276f84ac927e02105608d81bb198f45793f823))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.13.0 ([#974](https://github.com/googleapis/java-firestore/issues/974)) ([6def73d](https://github.com/googleapis/java-firestore/commit/6def73dbdbdc645d1148b9cc8e390e307a6896d4))
* update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.12 ([#973](https://github.com/googleapis/java-firestore/issues/973)) ([bfb4ec9](https://github.com/googleapis/java-firestore/commit/bfb4ec9f9de6114259328bbe9a14c0cc7fae84c8))

## [3.2.0](https://github.com/googleapis/java-firestore/compare/v3.1.0...v3.2.0) (2022-05-23)


### Features

* enable RunQueryResponse.done ([#942](https://github.com/googleapis/java-firestore/issues/942)) ([055b029](https://github.com/googleapis/java-firestore/commit/055b02930a455c253f443dcbacf935b5c8e37991))


### Documentation

* **sample:** remove unused native-image-support module ([#952](https://github.com/googleapis/java-firestore/issues/952)) ([17c2de9](https://github.com/googleapis/java-firestore/commit/17c2de9594c8ea549ed623ea482420f00fc7b6b6))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.12.0 ([#959](https://github.com/googleapis/java-firestore/issues/959)) ([f1d6b17](https://github.com/googleapis/java-firestore/commit/f1d6b17550556a6e1ce3cd734a5425b94da4aa6d))

## [3.1.0](https://github.com/googleapis/java-firestore/compare/v3.0.21...v3.1.0) (2022-04-21)


### Features

* relocate Firestore native image configuration from java-core ([#941](https://github.com/googleapis/java-firestore/issues/941)) ([900a7a8](https://github.com/googleapis/java-firestore/commit/900a7a855fab436aea3d221139e8c986f188d4be))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.10.0 ([#945](https://github.com/googleapis/java-firestore/issues/945)) ([5b2e318](https://github.com/googleapis/java-firestore/commit/5b2e3189cde0973edb524df88e71f8901f84b136))
* update dependency com.google.cloud:native-image-support to v0.13.1 ([#944](https://github.com/googleapis/java-firestore/issues/944)) ([b3b474f](https://github.com/googleapis/java-firestore/commit/b3b474f44167985b52cb1fb7e7b4c42be1c58112))

### [3.0.21](https://github.com/googleapis/java-firestore/compare/v3.0.20...v3.0.21) (2022-03-30)


### Bug Fixes

* change REST binding for ListDocuments to support root collection ([#900](https://github.com/googleapis/java-firestore/issues/900)) ([aabd4ac](https://github.com/googleapis/java-firestore/commit/aabd4ac4e43e1c58ec25e51117980f4396a3e8d9))
* **java:** move test native image configs to test/resources ([#929](https://github.com/googleapis/java-firestore/issues/929)) ([9ed6c5e](https://github.com/googleapis/java-firestore/commit/9ed6c5ea50c02411df2c94e782caba1954fd1f73))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.9.0 ([#932](https://github.com/googleapis/java-firestore/issues/932)) ([abebae7](https://github.com/googleapis/java-firestore/commit/abebae7fd9fde7d971150ffcfc010eaa7952932d))
* update dependency com.google.cloud:native-image-support to v0.12.11 ([#931](https://github.com/googleapis/java-firestore/issues/931)) ([0e1e3c5](https://github.com/googleapis/java-firestore/commit/0e1e3c598628c13c30cb7a51314d109c2106a678))

### [3.0.20](https://github.com/googleapis/java-firestore/compare/v3.0.19...v3.0.20) (2022-03-24)


### Dependencies

* update dependency org.graalvm.buildtools:junit-platform-native to v0.9.11 ([#923](https://github.com/googleapis/java-firestore/issues/923)) ([43f24b1](https://github.com/googleapis/java-firestore/commit/43f24b12d0c79551f1bc3eb13f3af8c38630f0ca))
* update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.11 ([#924](https://github.com/googleapis/java-firestore/issues/924)) ([70b0d00](https://github.com/googleapis/java-firestore/commit/70b0d001cb4199745e665a9d13731a9ca320ed93))

### [3.0.19](https://github.com/googleapis/java-firestore/compare/v3.0.18...v3.0.19) (2022-03-14)


### Bug Fixes

* **java:** fix native image Kokoro test setup ([#919](https://github.com/googleapis/java-firestore/issues/919)) ([7d905a5](https://github.com/googleapis/java-firestore/commit/7d905a5f2c687c1f099d2d976f9708b605b66a60))


### Dependencies

* update dependency com.google.cloud:native-image-support to v0.12.10 ([#917](https://github.com/googleapis/java-firestore/issues/917)) ([0a650e0](https://github.com/googleapis/java-firestore/commit/0a650e02ff1b0aea7d78b95c743358eff999b8aa))

### [3.0.18](https://github.com/googleapis/java-firestore/compare/v3.0.17...v3.0.18) (2022-03-10)


### Dependencies

* update dependency com.google.cloud:native-image-support to v0.12.9 ([#912](https://github.com/googleapis/java-firestore/issues/912)) ([fedf824](https://github.com/googleapis/java-firestore/commit/fedf824a3bf66e245ef3eb10c85d8209c418d6fa))

### [3.0.17](https://github.com/googleapis/java-firestore/compare/v3.0.16...v3.0.17) (2022-03-09)


### Dependencies

* update dependency com.google.cloud:native-image-support to v0.12.8 ([#909](https://github.com/googleapis/java-firestore/issues/909)) ([2580d8f](https://github.com/googleapis/java-firestore/commit/2580d8fa0fa35d69160c73fadfb3c817e126fc2b))

### [3.0.16](https://github.com/googleapis/java-firestore/compare/v3.0.15...v3.0.16) (2022-03-08)


### Dependencies

* update dependency com.google.cloud:native-image-support to v0.12.7 ([#902](https://github.com/googleapis/java-firestore/issues/902)) ([843dd0e](https://github.com/googleapis/java-firestore/commit/843dd0e9988f26f688c2b73f6a247092b7bea6ef))

### [3.0.15](https://github.com/googleapis/java-firestore/compare/v3.0.14...v3.0.15) (2022-03-02)


### Documentation

* **sample:** Use Java 8 for native image sample ([#893](https://github.com/googleapis/java-firestore/issues/893)) ([5955f54](https://github.com/googleapis/java-firestore/commit/5955f54f49637e4a4d22df34dbcddacfef269d34))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.8.0 ([#895](https://github.com/googleapis/java-firestore/issues/895)) ([bf1951d](https://github.com/googleapis/java-firestore/commit/bf1951d760f4ba431caa18ecbc0505a5d99f2ae2))
* update dependency com.google.cloud:native-image-support to v0.12.6 ([#898](https://github.com/googleapis/java-firestore/issues/898)) ([73606e5](https://github.com/googleapis/java-firestore/commit/73606e5617ff54daf60db720aed1436005d50fb5))

### [3.0.14](https://github.com/googleapis/java-firestore/compare/v3.0.13...v3.0.14) (2022-03-01)


### Bug Fixes

* fix groupID for artifacts ([#890](https://github.com/googleapis/java-firestore/issues/890)) ([bb46bcb](https://github.com/googleapis/java-firestore/commit/bb46bcb5f52b1f5fb4e3fe7acfb7e74b6fc4eb4b))
* **java:** add reflection configuration for native image tests ([#878](https://github.com/googleapis/java-firestore/issues/878)) ([1938113](https://github.com/googleapis/java-firestore/commit/19381131ab3c7a7a458e333de9929336fe4edcc9))


### Dependencies

* update actions/setup-java action to v3 ([#888](https://github.com/googleapis/java-firestore/issues/888)) ([07130f9](https://github.com/googleapis/java-firestore/commit/07130f961091bac19393dd13bff4826584509bd4))
* update dependency com.google.cloud:native-image-support to v0.12.5 ([#889](https://github.com/googleapis/java-firestore/issues/889)) ([5f4ffcb](https://github.com/googleapis/java-firestore/commit/5f4ffcbe6de3081a47a137be06be9ca6f0969ed5))
* update dependency org.graalvm.buildtools:junit-platform-native to v0.9.10 ([#880](https://github.com/googleapis/java-firestore/issues/880)) ([a3a9684](https://github.com/googleapis/java-firestore/commit/a3a96846e33e5ca53038c1d03a1f6734796c773f))

### [3.0.13](https://github.com/googleapis/java-firestore/compare/v3.0.12...v3.0.13) (2022-02-22)


### Bug Fixes

* retry watch on InternalException ([#875](https://github.com/googleapis/java-firestore/issues/875)) ([a76a0fd](https://github.com/googleapis/java-firestore/commit/a76a0fddbcd8996667a4ee239b3d74ee096161c6))


### Documentation

* **sample:** Add sample for native image support in Firestore ([#872](https://github.com/googleapis/java-firestore/issues/872)) ([a01fe88](https://github.com/googleapis/java-firestore/commit/a01fe88f17286a2988a4e4e52d11fc4aa43c5f83))


### Dependencies

* update dependency com.google.cloud:native-image-support to v0.12.4 ([#882](https://github.com/googleapis/java-firestore/issues/882)) ([b2aeb1a](https://github.com/googleapis/java-firestore/commit/b2aeb1a7c8f1baa428f1a718ea145fef77f439fb))
* update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.10 ([#881](https://github.com/googleapis/java-firestore/issues/881)) ([036f7f8](https://github.com/googleapis/java-firestore/commit/036f7f83b1ec4846af91613136cc793c637f43c1))

### [3.0.12](https://github.com/googleapis/java-firestore/compare/v3.0.11...v3.0.12) (2022-02-04)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.7.0 ([#860](https://github.com/googleapis/java-firestore/issues/860)) ([bf48381](https://github.com/googleapis/java-firestore/commit/bf48381a64f17cd615c1bcd0bf7c9ffb473400d9))
* update dependency org.apache.commons:commons-lang3 to v3.12.0 ([#846](https://github.com/googleapis/java-firestore/issues/846)) ([efc73bd](https://github.com/googleapis/java-firestore/commit/efc73bd1949d8214dd6702caa72a70405a6ca059))

### [3.0.11](https://github.com/googleapis/java-firestore/compare/v3.0.10...v3.0.11) (2022-01-27)


### Bug Fixes

* close the Watch stream when we receive an error ([#834](https://github.com/googleapis/java-firestore/issues/834)) ([077c9be](https://github.com/googleapis/java-firestore/commit/077c9be3b265e8cd7df149890986f36db94a9874))

### [3.0.10](https://www.github.com/googleapis/java-firestore/compare/v3.0.9...v3.0.10) (2022-01-07)


### Bug Fixes

* **java:** add -ntp flag to native image testing command ([#829](https://www.github.com/googleapis/java-firestore/issues/829)) ([a0fb54f](https://www.github.com/googleapis/java-firestore/commit/a0fb54fa433d252ad814009cf28a412adad94405))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.6.0 ([#841](https://www.github.com/googleapis/java-firestore/issues/841)) ([ea34d81](https://www.github.com/googleapis/java-firestore/commit/ea34d811d707f02c06b18d10d3e5d41000208cec))

### [3.0.9](https://www.github.com/googleapis/java-firestore/compare/v3.0.8...v3.0.9) (2021-12-03)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.5.1 ([#825](https://www.github.com/googleapis/java-firestore/issues/825)) ([1b8e3a3](https://www.github.com/googleapis/java-firestore/commit/1b8e3a38f722050d917643043bf4a8eb101c4200))

### [3.0.8](https://www.github.com/googleapis/java-firestore/compare/v3.0.7...v3.0.8) (2021-11-16)


### Bug Fixes

* respect total request timeout for Query retries ([#806](https://www.github.com/googleapis/java-firestore/issues/806)) ([feb1921](https://www.github.com/googleapis/java-firestore/commit/feb1921b39fc7630aa6549025c5ffe526e080d54))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.5.0 ([#814](https://www.github.com/googleapis/java-firestore/issues/814)) ([c1f4dac](https://www.github.com/googleapis/java-firestore/commit/c1f4dac67230b77864b4c4a64982cbbd7e28369f))

### [3.0.7](https://www.github.com/googleapis/java-firestore/compare/v3.0.6...v3.0.7) (2021-10-27)


### Bug Fixes

* **java:** java 17 dependency arguments ([#802](https://www.github.com/googleapis/java-firestore/issues/802)) ([ec07294](https://www.github.com/googleapis/java-firestore/commit/ec07294dc67d884a8bd6b0c4c9b9b1cdfb6e95c3))
* set timeouts for BatchGetDocuments/RunQuery ([#799](https://www.github.com/googleapis/java-firestore/issues/799)) ([6cd2a45](https://www.github.com/googleapis/java-firestore/commit/6cd2a4526561a74f1aed355fa8d0405960b34965))

### [3.0.6](https://www.github.com/googleapis/java-firestore/compare/v3.0.5...v3.0.6) (2021-10-19)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.4.0 ([#793](https://www.github.com/googleapis/java-firestore/issues/793)) ([1af36a9](https://www.github.com/googleapis/java-firestore/commit/1af36a9e8eccc5edc4ccfbfd865c2966b0fab366))

### [3.0.5](https://www.github.com/googleapis/java-firestore/compare/v3.0.4...v3.0.5) (2021-09-22)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.3.0 ([#775](https://www.github.com/googleapis/java-firestore/issues/775)) ([35469d6](https://www.github.com/googleapis/java-firestore/commit/35469d6f83a8027f2f54ce16b78141811ff393c3))

### [3.0.4](https://www.github.com/googleapis/java-firestore/compare/v3.0.3...v3.0.4) (2021-09-14)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.2.1 ([#765](https://www.github.com/googleapis/java-firestore/issues/765)) ([e7a6537](https://www.github.com/googleapis/java-firestore/commit/e7a65374525da1b290835f6d6c7ec94d9cbde121))

### [3.0.3](https://www.github.com/googleapis/java-firestore/compare/v3.0.2...v3.0.3) (2021-08-31)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.2.0 ([#753](https://www.github.com/googleapis/java-firestore/issues/753)) ([6744bfa](https://www.github.com/googleapis/java-firestore/commit/6744bfad1dc8a6a4e1da2d3e7cb7cd17514259b7))
* update google-cloud-conformance-tests to 0.2.0 ([#752](https://www.github.com/googleapis/java-firestore/issues/752)) ([135bc6b](https://www.github.com/googleapis/java-firestore/commit/135bc6be06fff41fb8933b63fcde2f247a293b07))

### [3.0.2](https://www.github.com/googleapis/java-firestore/compare/v3.0.1...v3.0.2) (2021-08-23)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.1.0 ([#739](https://www.github.com/googleapis/java-firestore/issues/739)) ([99b5820](https://www.github.com/googleapis/java-firestore/commit/99b5820f28c36ac83c44c6547764c7e41e4a8031))

### [3.0.1](https://www.github.com/googleapis/java-firestore/compare/v3.0.0...v3.0.1) (2021-08-11)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.0.1 ([#728](https://www.github.com/googleapis/java-firestore/issues/728)) ([167683d](https://www.github.com/googleapis/java-firestore/commit/167683deebf4724795b013cc7d8b495239a918a6))

## [3.0.0](https://www.github.com/googleapis/java-firestore/compare/v2.6.2...v3.0.0) (2021-08-09)


### ⚠ BREAKING CHANGES

* update Java compile to 1.8 ([#710](https://github.com/googleapis/java-firestore/pull/710))
* update gapic generator to 2.0.0, java 8 features (#719)

### Features

* update Java compile to 1.8 ([#710](https://github.com/googleapis/java-firestore/pull/710))
* gapic-generator-java v1.0.13, mtls support ([#712](https://www.github.com/googleapis/java-firestore/issues/712)) ([a27dd9c](https://www.github.com/googleapis/java-firestore/commit/a27dd9cb0e2681a15eae754c97255d0d8c86bcae))
* update gapic generator to 2.0.0, java 8 features ([#719](https://www.github.com/googleapis/java-firestore/issues/719)) ([0d5b378](https://www.github.com/googleapis/java-firestore/commit/0d5b378075f3723126c8809f4afcc8fc9f81d611))


### Dependencies

* update shared dependencies to 2.0.0 ([#720](https://www.github.com/googleapis/java-firestore/issues/720)) ([e4f985e](https://www.github.com/googleapis/java-firestore/commit/e4f985e8b17a02f84aa9b100be1aa72f97521763))

### [2.6.2](https://www.github.com/googleapis/java-firestore/compare/v2.6.1...v2.6.2) (2021-07-29)


### Bug Fixes

* Add shopt -s nullglob to dependencies script ([8f4b199](https://www.github.com/googleapis/java-firestore/commit/8f4b199c1dfdf268723e11696733fe5fb6bd5c64))
* Ensures bundles are encoded as UTF8 bytes. ([#695](https://www.github.com/googleapis/java-firestore/issues/695)) ([0946a17](https://www.github.com/googleapis/java-firestore/commit/0946a170a963f50ec77409291c02696f2c416edb))
* lower batch size on BulkWriter retry ([#688](https://www.github.com/googleapis/java-firestore/issues/688)) ([146b21d](https://www.github.com/googleapis/java-firestore/commit/146b21dd6d5772bfd9e023dbf5a1147b29076cdd))
* Update dependencies.sh to not break on mac ([#694](https://www.github.com/googleapis/java-firestore/issues/694)) ([8f4b199](https://www.github.com/googleapis/java-firestore/commit/8f4b199c1dfdf268723e11696733fe5fb6bd5c64))


### Documentation

* began merging variant client samples ([#696](https://www.github.com/googleapis/java-firestore/issues/696)) ([0a10dd8](https://www.github.com/googleapis/java-firestore/commit/0a10dd85de02647a9d08f41d45ebc25ee2689a52))

### [2.6.1](https://www.github.com/googleapis/java-firestore/compare/v2.6.0...v2.6.1) (2021-06-30)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.4.0 ([#680](https://www.github.com/googleapis/java-firestore/issues/680)) ([b8ffcb4](https://www.github.com/googleapis/java-firestore/commit/b8ffcb43d79029f9b2a490fb84e78653c716b367))

## [2.6.0](https://www.github.com/googleapis/java-firestore/compare/v2.5.1...v2.6.0) (2021-06-29)


### Features

* add shutdown() and shutdownNow() ([#673](https://www.github.com/googleapis/java-firestore/issues/673)) ([4f20858](https://www.github.com/googleapis/java-firestore/commit/4f2085887981121316fc046d13e945e6800aaad1))


### Bug Fixes

* handle thrown exceptions in runAsyncTransaction callback ([#671](https://www.github.com/googleapis/java-firestore/issues/671)) ([969f7fd](https://www.github.com/googleapis/java-firestore/commit/969f7fd72b07aa9c916609b73528ff0f17dfaead))

### [2.5.1](https://www.github.com/googleapis/java-firestore/compare/v2.5.0...v2.5.1) (2021-06-22)


### Bug Fixes

* return results from getPartitions() in order ([#653](https://www.github.com/googleapis/java-firestore/issues/653)) ([12d17d1](https://www.github.com/googleapis/java-firestore/commit/12d17d1ac9d7a1c21eca1469164b079de4476633))


### Dependencies

* update dependency com.google.cloud:google-cloud-conformance-tests to v0.1.1 ([#650](https://www.github.com/googleapis/java-firestore/issues/650)) ([b93ca8a](https://www.github.com/googleapis/java-firestore/commit/b93ca8a2b5751c61b3fbe0ca608056e2c0398575))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.3.0 ([#660](https://www.github.com/googleapis/java-firestore/issues/660)) ([0f13fd0](https://www.github.com/googleapis/java-firestore/commit/0f13fd0c0db0208b9f68a57dabcb1e998b4a7b9b))

## [2.5.0](https://www.github.com/googleapis/java-firestore/compare/v2.4.0...v2.5.0) (2021-06-01)


### Features

* add `gcf-owl-bot[bot]` to `ignoreAuthors` ([#641](https://www.github.com/googleapis/java-firestore/issues/641)) ([6f40f0f](https://www.github.com/googleapis/java-firestore/commit/6f40f0fc821d31136686a41e82e4b57d0ad3dede))
* add recursiveDelete() to Firestore ([#622](https://www.github.com/googleapis/java-firestore/issues/622)) ([#649](https://www.github.com/googleapis/java-firestore/issues/649)) ([9ff2f41](https://www.github.com/googleapis/java-firestore/commit/9ff2f41b765c8878c3b3fb7df962f6f1ed537f05))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.2.0 ([#640](https://www.github.com/googleapis/java-firestore/issues/640)) ([9bd881a](https://www.github.com/googleapis/java-firestore/commit/9bd881a5ddd0bdb62396e8b778bf9784c00feba2))

## [2.4.0](https://www.github.com/googleapis/java-firestore/compare/v2.3.0...v2.4.0) (2021-05-17)


### Features

* add buffering layer to BulkWriter ([#611](https://www.github.com/googleapis/java-firestore/issues/611)) ([a7caff2](https://www.github.com/googleapis/java-firestore/commit/a7caff2c15ad8ad4e98165bf4029d9615c079637))


### Bug Fixes

* add flush check in BulkWriter.sendBatchLocked() callback ([#631](https://www.github.com/googleapis/java-firestore/issues/631)) ([ac3db81](https://www.github.com/googleapis/java-firestore/commit/ac3db81741ac74614d9eeae70a3f2eae6dcc9548))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.1.0 ([#626](https://www.github.com/googleapis/java-firestore/issues/626)) ([00dbe33](https://www.github.com/googleapis/java-firestore/commit/00dbe33b426ea1509f9fb72181a36dd1a83b15cc))

## [2.3.0](https://www.github.com/googleapis/java-firestore/compare/v2.2.7...v2.3.0) (2021-04-23)


### Features

* add backoff to BulkWriter ([#600](https://www.github.com/googleapis/java-firestore/issues/600)) ([e295aa5](https://www.github.com/googleapis/java-firestore/commit/e295aa5d20007a513e1647575f6935e243825c4d))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1 ([#607](https://www.github.com/googleapis/java-firestore/issues/607)) ([21e8cde](https://www.github.com/googleapis/java-firestore/commit/21e8cde718b5f2e2f8269d860d0ea3ae810dabdd))

### [2.2.7](https://www.github.com/googleapis/java-firestore/compare/v2.2.6...v2.2.7) (2021-04-20)


### Bug Fixes

* release scripts from issuing overlapping phases ([#595](https://www.github.com/googleapis/java-firestore/issues/595)) ([4372479](https://www.github.com/googleapis/java-firestore/commit/43724796ea940062512370c270f6bedc680b5b6a))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.21.1 ([#597](https://www.github.com/googleapis/java-firestore/issues/597)) ([dbd3d33](https://www.github.com/googleapis/java-firestore/commit/dbd3d331d83fc7b2c4e79946b9921ff158c8b1e9))

### [2.2.6](https://www.github.com/googleapis/java-firestore/compare/v2.2.5...v2.2.6) (2021-04-13)


### Bug Fixes

* Removed Jackson dependency ([#508](https://www.github.com/googleapis/java-firestore/issues/508)) ([7ada73d](https://www.github.com/googleapis/java-firestore/commit/7ada73d3c0a282be8ce2682c2e9c737690d9f891))
* typo ([#587](https://www.github.com/googleapis/java-firestore/issues/587)) ([520ac44](https://www.github.com/googleapis/java-firestore/commit/520ac441bcb7944be378ec6099b9ec4de37844d4))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.21.0 ([#584](https://www.github.com/googleapis/java-firestore/issues/584)) ([c83a222](https://www.github.com/googleapis/java-firestore/commit/c83a222bd602a489552276c5202796db7fadeffa))

### [2.2.5](https://www.github.com/googleapis/java-firestore/compare/v2.2.4...v2.2.5) (2021-03-11)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.20.1 ([#567](https://www.github.com/googleapis/java-firestore/issues/567)) ([7370d21](https://www.github.com/googleapis/java-firestore/commit/7370d21994126d206f51a8c0c1677b5dc0ee030f))

### [2.2.4](https://www.github.com/googleapis/java-firestore/compare/v2.2.3...v2.2.4) (2021-02-25)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.20.0 ([#554](https://www.github.com/googleapis/java-firestore/issues/554)) ([0ae4ea3](https://www.github.com/googleapis/java-firestore/commit/0ae4ea3ce4bdd3a361331615115bdf25928b7da6))

### [2.2.3](https://www.github.com/googleapis/java-firestore/compare/v2.2.2...v2.2.3) (2021-02-19)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.19.0 ([#543](https://www.github.com/googleapis/java-firestore/issues/543)) ([7eed88c](https://www.github.com/googleapis/java-firestore/commit/7eed88c70cfe197a93b88b47db6e4edd89836063))

### [2.2.2](https://www.github.com/googleapis/java-firestore/compare/v2.2.1...v2.2.2) (2021-02-19)


### Bug Fixes

* block close() on the termination of all RPC channels ([#512](https://www.github.com/googleapis/java-firestore/issues/512)) ([67bd06a](https://www.github.com/googleapis/java-firestore/commit/67bd06aac7a53a210e1a5c081929104c43a5d48a))
* **samples:** close firestore instance in test ([#476](https://www.github.com/googleapis/java-firestore/issues/476)) ([fb1cb17](https://www.github.com/googleapis/java-firestore/commit/fb1cb175c06e2782f7cd9cb3bbb9c751e9d33713))

### [2.2.1](https://www.github.com/googleapis/java-firestore/compare/v2.2.0...v2.2.1) (2021-02-02)


### Bug Fixes

* don't throw NPE in DocumentSnapshot.getDate() when value is missing ([#513](https://www.github.com/googleapis/java-firestore/issues/513)) ([a41b07e](https://www.github.com/googleapis/java-firestore/commit/a41b07ea8a02aefb9f2798240dd7ba32589791fe))

## [2.2.0](https://www.github.com/googleapis/java-firestore/compare/v2.1.0...v2.2.0) (2021-01-20)


### Features

* Add bundle proto building ([#271](https://www.github.com/googleapis/java-firestore/issues/271)) ([994835c](https://www.github.com/googleapis/java-firestore/commit/994835c0a3be077404afa60abd4d4685d17fb533))
* add bundle.proto from googleapis/googleapis ([#407](https://www.github.com/googleapis/java-firestore/issues/407)) ([37da386](https://www.github.com/googleapis/java-firestore/commit/37da386875d1b65121e8a9a92b1a000537f07625))
* add CollectionGroup#getPartitions(long) ([#478](https://www.github.com/googleapis/java-firestore/issues/478)) ([bab064e](https://www.github.com/googleapis/java-firestore/commit/bab064edde26325bf0041ffe28d4c63b97a089c5))
* add implicit ordering for startAt(DocumentReference) calls ([#417](https://www.github.com/googleapis/java-firestore/issues/417)) ([aae6dc9](https://www.github.com/googleapis/java-firestore/commit/aae6dc960f7c42830ceed23c65acaad3e457dcff))
* add max/min throttling options to BulkWriterOptions ([#400](https://www.github.com/googleapis/java-firestore/issues/400)) ([27a9397](https://www.github.com/googleapis/java-firestore/commit/27a9397f67e151d723241c80ccb2ec9f1bfbba1c))
* add success and error callbacks to BulkWriter ([#483](https://www.github.com/googleapis/java-firestore/issues/483)) ([3c05037](https://www.github.com/googleapis/java-firestore/commit/3c05037e8fce8d3ce4907fde85bd254fc98ea588))
* Implementation of Firestore Bundle Builder ([#293](https://www.github.com/googleapis/java-firestore/issues/293)) ([fd5ef90](https://www.github.com/googleapis/java-firestore/commit/fd5ef90b6681cc67aeee6c95f3de80267798dcd0))
* Release bundles ([#466](https://www.github.com/googleapis/java-firestore/issues/466)) ([3af065e](https://www.github.com/googleapis/java-firestore/commit/3af065e32b193931c805b576f410ad90124b43a7))


### Bug Fixes

* add @BetaApi, make BulkWriter public, and refactor Executor ([#497](https://www.github.com/googleapis/java-firestore/issues/497)) ([27ff9f6](https://www.github.com/googleapis/java-firestore/commit/27ff9f6dfa92cac9119d2014c24a0759baa44fb7))
* **build:** sample checkstyle violations ([#457](https://www.github.com/googleapis/java-firestore/issues/457)) ([777ecab](https://www.github.com/googleapis/java-firestore/commit/777ecabd1ce12cbc5f4169de6c23a90f98deac06))
* bulkWriter: writing to the same doc doesn't create a new batch ([#394](https://www.github.com/googleapis/java-firestore/issues/394)) ([259ece8](https://www.github.com/googleapis/java-firestore/commit/259ece8511db71ea79cc1a080eb785a15db88756))
* empty commit to trigger release-please ([fcef0d3](https://www.github.com/googleapis/java-firestore/commit/fcef0d302cd0a9339d82db73152289d6f9f67ff2))
* make BulkWriterOptions public ([#502](https://www.github.com/googleapis/java-firestore/issues/502)) ([6ea05be](https://www.github.com/googleapis/java-firestore/commit/6ea05beb3f27337bef910ca64f0e3f32de6b7e98))
* retry Query streams ([#426](https://www.github.com/googleapis/java-firestore/issues/426)) ([3513cd3](https://www.github.com/googleapis/java-firestore/commit/3513cd39ff43d26c8432c05ce20693350539ae8f))
* retry transactions that fail with expired transaction IDs ([#447](https://www.github.com/googleapis/java-firestore/issues/447)) ([5905438](https://www.github.com/googleapis/java-firestore/commit/5905438af6501353e978210808834a26947aae95))
* verify partition count before invoking GetPartition RPC ([#418](https://www.github.com/googleapis/java-firestore/issues/418)) ([2054ae9](https://www.github.com/googleapis/java-firestore/commit/2054ae971083277e1cf81c2b57500c40a6faa0ef))


### Documentation

* **sample:** normalize firestore sample's region tags ([#453](https://www.github.com/googleapis/java-firestore/issues/453)) ([b529245](https://www.github.com/googleapis/java-firestore/commit/b529245c75f770e1b47ca5d9561bab55a7610677))


### Dependencies

* remove explicit version for jackson ([#479](https://www.github.com/googleapis/java-firestore/issues/479)) ([e2aecfe](https://www.github.com/googleapis/java-firestore/commit/e2aecfec51465b8fb3413337a76f9a3de57b8500))
* update dependency com.google.cloud:google-cloud-conformance-tests to v0.0.12 ([#367](https://www.github.com/googleapis/java-firestore/issues/367)) ([2bdd846](https://www.github.com/googleapis/java-firestore/commit/2bdd84693bbd968cafabd0e7ee56d1a9a7dc31ca))
* update dependency com.google.cloud:google-cloud-conformance-tests to v0.0.13 ([#411](https://www.github.com/googleapis/java-firestore/issues/411)) ([e6157b5](https://www.github.com/googleapis/java-firestore/commit/e6157b5cb532e0184125355b12115058e72afa67))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.10.0 ([#383](https://www.github.com/googleapis/java-firestore/issues/383)) ([cb39ee8](https://www.github.com/googleapis/java-firestore/commit/cb39ee820c2f67e22da623f5a6eaa7ee6bf351e2))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.10.2 ([#403](https://www.github.com/googleapis/java-firestore/issues/403)) ([991dd81](https://www.github.com/googleapis/java-firestore/commit/991dd810360e654fca0b53e0611da0cd77febc7c))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.12.1 ([#425](https://www.github.com/googleapis/java-firestore/issues/425)) ([b897ffa](https://www.github.com/googleapis/java-firestore/commit/b897ffa90427a8f597c02c24f80d1d162be48b23))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.13.0 ([#430](https://www.github.com/googleapis/java-firestore/issues/430)) ([0f8f218](https://www.github.com/googleapis/java-firestore/commit/0f8f218678c3ddebb73748c382cab8e38c2f140d))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.14.1 ([#446](https://www.github.com/googleapis/java-firestore/issues/446)) ([e241f8e](https://www.github.com/googleapis/java-firestore/commit/e241f8ebbfdf202f00424177c69962311b37fc88))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.15.0 ([#460](https://www.github.com/googleapis/java-firestore/issues/460)) ([b82fc35](https://www.github.com/googleapis/java-firestore/commit/b82fc3561d1a397438829ab69df24141481369a2))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.16.0 ([#481](https://www.github.com/googleapis/java-firestore/issues/481)) ([ae98824](https://www.github.com/googleapis/java-firestore/commit/ae988245e6d6391c85414e9b6f7ae1b8148c3a6d))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.16.1 ([4ace93c](https://www.github.com/googleapis/java-firestore/commit/4ace93c7be580a8f7870e71cad2dc19bb5fdef29))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.17.0 ([#487](https://www.github.com/googleapis/java-firestore/issues/487)) ([e11e472](https://www.github.com/googleapis/java-firestore/commit/e11e4723bc75727086bee0436492f458def29ff5))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.18.0 ([#495](https://www.github.com/googleapis/java-firestore/issues/495)) ([f78720a](https://www.github.com/googleapis/java-firestore/commit/f78720a155f1294321f05266b9a546bbf2cb9a04))
* update jackson dependencies to v2.11.3 ([#396](https://www.github.com/googleapis/java-firestore/issues/396)) ([2e176e2](https://www.github.com/googleapis/java-firestore/commit/2e176e2f864262f31e6f93705fa7e794023b9649))

## [2.1.0](https://www.github.com/googleapis/java-firestore/compare/v2.0.0...v2.1.0) (2020-09-10)


### Features

* add method to set emulator host programmatically ([#319](https://www.github.com/googleapis/java-firestore/issues/319)) ([#336](https://www.github.com/googleapis/java-firestore/issues/336)) ([97037f4](https://www.github.com/googleapis/java-firestore/commit/97037f42f76e9df3ae458d4e2b04336e64b834c3)), closes [#210](https://www.github.com/googleapis/java-firestore/issues/210) [#190](https://www.github.com/googleapis/java-firestore/issues/190)
* add opencensus tracing support ([#360](https://www.github.com/googleapis/java-firestore/issues/360)) ([edaa539](https://www.github.com/googleapis/java-firestore/commit/edaa5395be0353fb261d954429c624623bc4e346))
* add support for != and NOT_IN queries ([#350](https://www.github.com/googleapis/java-firestore/issues/350)) ([68aff5b](https://www.github.com/googleapis/java-firestore/commit/68aff5b406fb2732951750f3d5f9768df6ee12b5))
* generate protos to add NOT_EQUAL, NOT_IN, IS_NOT_NAN, IS_NOT_NULL query operators ([#343](https://www.github.com/googleapis/java-firestore/issues/343)) ([3fb1b63](https://www.github.com/googleapis/java-firestore/commit/3fb1b631f8dd087f0f3e1c43363e9642f497993a))


### Bug Fixes

* **samples:** re-add maven exec config for Quickstart sample ([#347](https://www.github.com/googleapis/java-firestore/issues/347)) ([4c2329b](https://www.github.com/googleapis/java-firestore/commit/4c2329bf89ffab4bd3060e16e1cf231b7caf4653))
* add support to deserialize to custom Lists and Maps ([#337](https://www.github.com/googleapis/java-firestore/issues/337)) ([dc897e0](https://www.github.com/googleapis/java-firestore/commit/dc897e00a85e745f57f615460b29d17b7dd247c6))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.9.0 ([#352](https://www.github.com/googleapis/java-firestore/issues/352)) ([783d41e](https://www.github.com/googleapis/java-firestore/commit/783d41e167c7c79957faeeebd7a76ab72b5b157d))

## [2.0.0](https://www.github.com/googleapis/java-firestore/compare/v1.35.2...v2.0.0) (2020-08-14)


### New Features

#### Query Partition API

New API and backend RPC which allows for fetching a set of cursor keys for a 
Collection Group Query. Accessible via the new [`CollectionGroup#getPartitions(long,ApiStreamObserver)`](https://googleapis.dev/java/google-cloud-firestore/2.0.0/com/google/cloud/firestore/CollectionGroup.html#getPartitions-long-com.google.api.gax.rpc.ApiStreamObserver-) method. 

#### Read-Only Transaction Options

[`TransactionOptions`](https://googleapis.dev/java/google-cloud-firestore/2.0.0/com/google/cloud/firestore/TransactionOptions.html)
has been refactored to provide the ability to configure options for read-only 
transactions along with the existing configuration for read-write transactions.

This new ability is provided via the new [`TransactionOptions.createReadOnlyOptionsBuilder()`](https://googleapis.dev/java/google-cloud-firestore/2.0.0/com/google/cloud/firestore/TransactionOptions.html#createReadOnlyOptionsBuilder--) 
type safe builder.

Along with the new type safe builder for read-only options, there is a new type 
safe builder for read-write options as well accessible via [`TransactionOptions.createReadWriteOptionsBuilder()`](https://googleapis.dev/java/google-cloud-firestore/2.0.0/com/google/cloud/firestore/TransactionOptions.html#createReadWriteOptionsBuilder--). Each of the existing `TransactionOptions.create(...)`
methods for configuring read-write options has been deprecated in favor of the new builder.

#### EmulatorCredentials

`com.google.cloud.firestore.FirestoreOptions.Builder.FakeCredentials` has been
made static and renamed to `com.google.cloud.firestore.FirestoreOptions.EmulatorCredentials`
allowing instantiation outside `FirestoreOptions.Builder`.

When connecting to the Cloud Firestore Emulator via `FirestoreOptions` rather than
the environment variable `FIRESTORE_EMULATOR_HOST`, a custom credential implementation
must be specified to allow various admin operations in the emulator. Previously
this required users to create their own implementation due to it not being 
possible to construct a `FakeCredential`. As part of this change, `EmulatorCredentials`
is static and therefore able to be constructed from any location.

### Breaking Changes

#### New Firestore Admin Client API Artifact

The Cloud Firestore Admin Client has been migrated to its own maven artifact `com.google.cloud:google-cloud-firestore-admin`
rather than being bundled in `com.google.cloud:google-cloud-firestore`. All 
packages and classes have retained their existing names.

The new artifact is included in the `com.google.cloud:google-cloud-firestore-bom`, 
`com.google.cloud:google-cloud-bom` and `com.google.cloud:libraries-bom` 
artifacts and is accessible by adding the new dependency to your `pom.xml` file:

```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-firestore-admin</artifactId>
</dependency>
```

#### Removal of v1beta1

Cloud Firestore has been GA for some time now, and the `google-cloud-firestore` 
code base has been using the protos and generated classes for the v1 api since 
that time. As such, we will no longer be publishing artifacts for the deprecated
v1beta1 protos. All functionality from v1beta1 is present in v1, and all users
should update any code to use v1.

#### Removal of support for `java.util.Date` in Snapshots

It is no longer possible to configure the ability for `java.util.Date` to be
returned from `DocumentSnapshot.get(FieldPath)` or `DocumentSnapshot.getData()`
for properties which are stored as Timestamps in Cloud Firestore.

The default behavior has been to return `com.google.cloud.Timestamp` by default
for some time, and is now the only option. Any code that is dependent on the old
behavior must be updated to use Timestamps instead of Date.

### Laundry List of Pull Requests

#### ⚠ BREAKING CHANGES

* add support for the Query Partition API (#202)
  * `Firestore#collectionGroup(...)` has a new return type `CollectionGroup` 
    which requires any code that previously used the method be re-compiled to
    pick up the new signature. `CollectionGroup` extends `Query` and as such 
    does not require your code to be updated, only the compiled class files.
* move FirestoreAdminClient and associated classes to new artifact google-cloud-firestore-admin (#311)
* remove deprecated v1beta1 protos and grpc client (#305)
* remove deprecated FirestoreOptions#setTimestampsInSnapshotsEnabled (#308)
* remove deprecated getCollections() methods (#307)
* various renames due to generator changes

#### Features

* add support for read-only transactions in TransactionOptions ([#320](https://www.github.com/googleapis/java-firestore/issues/320)) ([c25dca3](https://www.github.com/googleapis/java-firestore/commit/c25dca3ed6ca0c156ec60569ebc9f3a481bd4fee))
* add support for the Query Partition API ([#202](https://www.github.com/googleapis/java-firestore/issues/202)) ([3996548](https://www.github.com/googleapis/java-firestore/commit/39965489cbc836af573e500d57007c88241d7eb6))


#### Bug Fixes

* refactor FakeCredentials ([#325](https://www.github.com/googleapis/java-firestore/issues/325)) ([269e62c](https://www.github.com/googleapis/java-firestore/commit/269e62c6b8031d48e7f2e282b09b5ffcfadae547)), closes [#190](https://www.github.com/googleapis/java-firestore/issues/190)


#### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.5 ([#322](https://www.github.com/googleapis/java-firestore/issues/322)) ([1b21350](https://www.github.com/googleapis/java-firestore/commit/1b21350c0bc4a21cee2b281f944cbd061b1f8898))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.6 ([#324](https://www.github.com/googleapis/java-firestore/issues/324)) ([b945fdb](https://www.github.com/googleapis/java-firestore/commit/b945fdb04da76a1e007d012c809449c5a43bb990))
* update jackson dependencies to v2.11.2 ([#314](https://www.github.com/googleapis/java-firestore/issues/314)) ([15d68cd](https://www.github.com/googleapis/java-firestore/commit/15d68cd93ac1fd206895fd37155a9ba82b9196ca))


#### Miscellaneous Chores

* enable gapicv2 ([#188](https://www.github.com/googleapis/java-firestore/issues/188)) ([92224bc](https://www.github.com/googleapis/java-firestore/commit/92224bcd52aa88cc6eb1da28747de0535d776a0f))
* move FirestoreAdminClient and associated classes to new artifact google-cloud-firestore-admin ([#311](https://www.github.com/googleapis/java-firestore/issues/311)) ([03ef755](https://www.github.com/googleapis/java-firestore/commit/03ef755dd164e6f1ec749f3f985b913b5ae23d14))
* remove deprecated FirestoreOptions#setTimestampsInSnapshotsEnabled ([#308](https://www.github.com/googleapis/java-firestore/issues/308)) ([7255a42](https://www.github.com/googleapis/java-firestore/commit/7255a42bcee3a6938dd5fafaef3465f948f39600))
* remove deprecated getCollections() methods ([#307](https://www.github.com/googleapis/java-firestore/issues/307)) ([bb4ddf1](https://www.github.com/googleapis/java-firestore/commit/bb4ddf1ce3cc3bd2e06a4ad5097bd18060e4467b))
* remove deprecated v1beta1 protos and grpc client ([#305](https://www.github.com/googleapis/java-firestore/issues/305)) ([96adacb](https://www.github.com/googleapis/java-firestore/commit/96adacbf52ace27e54b7a210d7c73b46922fbcbd))
* add BulkWriter ([#323](https://www.github.com/googleapis/java-firestore/issues/323)) ([e7054df](https://www.github.com/googleapis/java-firestore/commit/e7054df79b4139fdfd0cc6aa0620fbfa1a10a6b0))
* make BulkWriter package private ([#330](https://github.com/googleapis/java-firestore/pull/330)) ([ef0869a](https://github.com/googleapis/java-firestore/commit/ef0869a7fa619bc15fef27ad90d41cb718cb981d))

## [1.35.2](https://www.github.com/googleapis/java-firestore/compare/v1.35.1...v1.35.2) (2020-07-16)


### Bug Fixes

* add Internal#autoId() ([#292](https://www.github.com/googleapis/java-firestore/issues/292)) ([b91c57c](https://www.github.com/googleapis/java-firestore/commit/b91c57c4b2d3e92478ceaa1a39d467c40e1344dc))
* add support for deleting nested fields that contain periods ([#295](https://www.github.com/googleapis/java-firestore/issues/295)) ([84f602e](https://www.github.com/googleapis/java-firestore/commit/84f602ef8be67e5748b77e549d46ea53d0c74335))
* use test credentials when connecting to the Emulator from the Firebase Admin SDK ([#296](https://www.github.com/googleapis/java-firestore/issues/296)) ([a0a6e80](https://www.github.com/googleapis/java-firestore/commit/a0a6e806217693fc62a4cf432354c76e719aa140))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.3 ([#289](https://www.github.com/googleapis/java-firestore/issues/289)) ([2ddb8f1](https://www.github.com/googleapis/java-firestore/commit/2ddb8f133dd3bf31d28bf6bd67cddf8ba2e8846b))

## [1.35.1](https://www.github.com/googleapis/java-firestore/compare/v1.35.0...v1.35.1) (2020-07-01)

### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.2 ([#280](https://www.github.com/googleapis/java-firestore/issues/280)) ([9296f7a](https://www.github.com/googleapis/java-firestore/commit/9296f7a67c6194ea9e75b952d29b0f1aa486d194))
* update jackson dependencies to v2.11.1 ([#272](https://www.github.com/googleapis/java-firestore/issues/272)) ([1065704](https://www.github.com/googleapis/java-firestore/commit/1065704f3e571f3f51b0e9ed13ec67eb7c662b88))
* adopt flatten plugin and google-cloud-shared-dependencies ([#261](https://www.github.com/googleapis/java-firestore/issues/261)) ([78b2ebf](https://www.github.com/googleapis/java-firestore/commit/78b2ebf3c75c774f1ace386fa5f32e76b470ed9c))

## [1.35.0](https://www.github.com/googleapis/java-firestore/compare/v1.34.0...v1.35.0) (2020-06-17)


### Features

* ability to serialize Query to Proto ([#241](https://www.github.com/googleapis/java-firestore/issues/241)) ([bae22e0](https://www.github.com/googleapis/java-firestore/commit/bae22e0839de55e11dda604c3034feaedbbc172a))
* add support for fieldmask to document reference ([#245](https://www.github.com/googleapis/java-firestore/issues/245)) ([4a846b1](https://www.github.com/googleapis/java-firestore/commit/4a846b1f067ad8e462df673ada38589da224fcef))


### Dependencies

* update core dependencies ([#254](https://www.github.com/googleapis/java-firestore/issues/254)) ([9b275ca](https://www.github.com/googleapis/java-firestore/commit/9b275ca5b3f2adbe18be77ea8c86d8446a5833d6))
* update dependency com.google.api:api-common to v1.9.2 ([#238](https://www.github.com/googleapis/java-firestore/issues/238)) ([c47d327](https://www.github.com/googleapis/java-firestore/commit/c47d32705645a76d8f9598aa954dbc3b1c067c73))
* update dependency io.grpc:grpc-bom to v1.30.0 ([#244](https://www.github.com/googleapis/java-firestore/issues/244)) ([b5749d4](https://www.github.com/googleapis/java-firestore/commit/b5749d4e9bac3628da66451fa070c1bf6f852614))

## [1.34.0](https://www.github.com/googleapis/java-firestore/compare/v1.33.0...v1.34.0) (2020-05-29)


### Features

* add support for BigDecimal to CustomClassMapper ([#196](https://www.github.com/googleapis/java-firestore/issues/196)) ([a471f1e](https://www.github.com/googleapis/java-firestore/commit/a471f1eed1e555e95b3d9bcda31ce0277e35a14a))
* Create CODEOWNERS ([#207](https://www.github.com/googleapis/java-firestore/issues/207)) ([cd19eae](https://www.github.com/googleapis/java-firestore/commit/cd19eae68a4898a53c6c3cc8189eab30545a661d))


### Bug Fixes

* add RateLimiter ([#230](https://www.github.com/googleapis/java-firestore/issues/230)) ([47d4a11](https://www.github.com/googleapis/java-firestore/commit/47d4a11625d5888d6f31e494923853a08bb8af77))
* catch null Firestore in system tests ([#215](https://www.github.com/googleapis/java-firestore/issues/215)) ([2a4a7b5](https://www.github.com/googleapis/java-firestore/commit/2a4a7b50d40ff1c165e3d359d5f4eaf929f6ffbc))
* Fields used in whereIn should be equality filters ([#216](https://www.github.com/googleapis/java-firestore/issues/216)) ([4a62633](https://www.github.com/googleapis/java-firestore/commit/4a626333e5af0d70a4dc4853ed373dcf50ea0f4a))
* replace usages of transform proto with update_transform ([#213](https://www.github.com/googleapis/java-firestore/issues/213)) ([46a3c51](https://www.github.com/googleapis/java-firestore/commit/46a3c51386b57f20bd65c564e93181e9ce399e2b))
* support array of references for IN queries ([#211](https://www.github.com/googleapis/java-firestore/issues/211)) ([b376003](https://www.github.com/googleapis/java-firestore/commit/b3760032952529f148065928c3bf13ff73a34edd))


### Dependencies

* update core dependencies to v1.93.5 ([#229](https://www.github.com/googleapis/java-firestore/issues/229)) ([b078213](https://www.github.com/googleapis/java-firestore/commit/b078213209f3936cfe9c9e2cdea040c1262621d4))
* update dependency com.google.api:api-common to v1.9.1 ([#228](https://www.github.com/googleapis/java-firestore/issues/228)) ([7e4568d](https://www.github.com/googleapis/java-firestore/commit/7e4568d8b3f0fc6f591640ccc2d646eb2764e572))
* update dependency com.google.api.grpc:proto-google-common-protos to v1.18.0 ([#204](https://www.github.com/googleapis/java-firestore/issues/204)) ([1e05de4](https://www.github.com/googleapis/java-firestore/commit/1e05de4ecfde055a1c84c2f6dd338604b8580a61))
* update dependency com.google.cloud:google-cloud-conformance-tests to v0.0.10 ([#197](https://www.github.com/googleapis/java-firestore/issues/197)) ([69372af](https://www.github.com/googleapis/java-firestore/commit/69372af7253564691b291766e2bf4d80e9ecc770))
* update dependency com.google.guava:guava-bom to v29 ([#180](https://www.github.com/googleapis/java-firestore/issues/180)) ([3c204b4](https://www.github.com/googleapis/java-firestore/commit/3c204b42ddfbe435ac095368d1e695ed282280bd))
* update dependency io.grpc:grpc-bom to v1.29.0 ([#206](https://www.github.com/googleapis/java-firestore/issues/206)) ([5d8c50f](https://www.github.com/googleapis/java-firestore/commit/5d8c50f105649100abf4fa7a6882bb0469ccbf8f))
* update dependency org.threeten:threetenbp to v1.4.4 ([#194](https://www.github.com/googleapis/java-firestore/issues/194)) ([c867bd5](https://www.github.com/googleapis/java-firestore/commit/c867bd5772aa4a4710c622546e69fdc0f1ca22b6))
* update jackson dependencies to v2.11.0 ([#195](https://www.github.com/googleapis/java-firestore/issues/195)) ([5066812](https://www.github.com/googleapis/java-firestore/commit/50668126e99422cc9498b317c9c76a80a8bf7b30))
* update protobuf.version to v3.12.0 ([#220](https://www.github.com/googleapis/java-firestore/issues/220)) ([2c0b35d](https://www.github.com/googleapis/java-firestore/commit/2c0b35dfc5786b986b5301a00f06177f527496c3))
* update protobuf.version to v3.12.2 ([#226](https://www.github.com/googleapis/java-firestore/issues/226)) ([2eeea19](https://www.github.com/googleapis/java-firestore/commit/2eeea193d7eb54b1efa92b4d5dd996c170048a73))


### Documentation

* update README to include code formatting ([#209](https://www.github.com/googleapis/java-firestore/issues/209)) ([04f8b3b](https://www.github.com/googleapis/java-firestore/commit/04f8b3b0f873c2f1988c184de1e5268e0de9053f))

## [1.33.0](https://www.github.com/googleapis/java-firestore/compare/v1.32.5...v1.33.0) (2020-04-08)


### Features

* add new Firestore.runAsyncTransaction ([#103](https://www.github.com/googleapis/java-firestore/issues/103)) ([b28b660](https://www.github.com/googleapis/java-firestore/commit/b28b66088194f997cca62f759e4201cba3da38b5))
  * __NOTICE__ This change will require any users of the library that implement `com.google.cloud.firestore.Firestore` to have to implement the new runAsyncTransaction methods, and is a binary incompatible change in Java 7. Those users who only use `com.google.cloud.firestore.Firestore` through the instance returned from `FirestoreOptions.getDefaultInstance().getService()` will not have to recompile their code.
* add Query.limitToLast() ([#151](https://www.github.com/googleapis/java-firestore/issues/151)) ([c104615](https://www.github.com/googleapis/java-firestore/commit/c104615210271977a48205a8d8e6acd69acc5fb6))
* base transaction retries on error codes ([#129](https://www.github.com/googleapis/java-firestore/issues/129)) ([00b6eb3](https://www.github.com/googleapis/java-firestore/commit/00b6eb3703c8f4942d6da42b827ecbeeb9a13ef5)), closes [googleapis/nodejs-firestore#953](https://www.github.com/googleapis/nodejs-firestore/issues/953)
* use SecureRandom instead of Random to reduce the chance of auto-id collisions ([#156](https://www.github.com/googleapis/java-firestore/issues/156)) ([0088ee7](https://www.github.com/googleapis/java-firestore/commit/0088ee7b1f0c5bb65d7636de77e2c7f9098978e9))


### Bug Fixes

* add missing @InternalExtensionOnly annotation to com.google.cloud.firestore.Firestore ([#141](https://www.github.com/googleapis/java-firestore/issues/141)) ([d3458cb](https://www.github.com/googleapis/java-firestore/commit/d3458cbdae14e1f623dcb9848dd0fc51b8a8c30f))
* add support for updating an individual field with pojo in all update method ([#136](https://www.github.com/googleapis/java-firestore/issues/136)) ([7d6c2c1](https://www.github.com/googleapis/java-firestore/commit/7d6c2c10be4eb5bf7250de4bb0ea447302464d05))
* mark v1beta1 as deprecated ([#154](https://www.github.com/googleapis/java-firestore/issues/154)) ([495f7f9](https://www.github.com/googleapis/java-firestore/commit/495f7f97405fcd2bff4d09e67ddbeb51615ea843))


### Dependencies

* update core dependencies ([#127](https://www.github.com/googleapis/java-firestore/issues/127)) ([7995db0](https://www.github.com/googleapis/java-firestore/commit/7995db0d4e7ba38e7f28ce200de95c2069dd323e))
* update core dependencies ([#167](https://www.github.com/googleapis/java-firestore/issues/167)) ([11f16fd](https://www.github.com/googleapis/java-firestore/commit/11f16fd2b64dff0e7d97df66af4cfa722ce8f418))
* update core dependencies to v1.55.0 ([#158](https://www.github.com/googleapis/java-firestore/issues/158)) ([f3a20d3](https://www.github.com/googleapis/java-firestore/commit/f3a20d3d35c98c62d78ba6fcd6533878b28b7653))
* update core dependencies to v1.93.3 ([#132](https://www.github.com/googleapis/java-firestore/issues/132)) ([50394e1](https://www.github.com/googleapis/java-firestore/commit/50394e13fe58b86b13e65aea6b80135c3e9cfe44))
* update core dependencies to v1.93.4 ([#168](https://www.github.com/googleapis/java-firestore/issues/168)) ([2118232](https://www.github.com/googleapis/java-firestore/commit/211823214cc4cceea86048e2fe8fbdc4e6571b49))
* update dependency com.google.api:api-common to v1.9.0 ([#153](https://www.github.com/googleapis/java-firestore/issues/153)) ([8ca0ea8](https://www.github.com/googleapis/java-firestore/commit/8ca0ea8d30f3318a89d6efec420b65f2b41dc805))
* update dependency com.google.cloud:google-cloud-conformance-tests to v0.0.8 ([#123](https://www.github.com/googleapis/java-firestore/issues/123)) ([0bbf4b0](https://www.github.com/googleapis/java-firestore/commit/0bbf4b03f722ca45a7c7f5466e19dd490eda94af))
* update dependency com.google.cloud:google-cloud-conformance-tests to v0.0.9 ([#152](https://www.github.com/googleapis/java-firestore/issues/152)) ([d41c41f](https://www.github.com/googleapis/java-firestore/commit/d41c41f6e27d66af133b89155474404fd392245f))
* update dependency com.google.cloud.samples:shared-configuration to v1.0.13 ([#148](https://www.github.com/googleapis/java-firestore/issues/148)) ([6bd8e7f](https://www.github.com/googleapis/java-firestore/commit/6bd8e7fcc126872c635714a6d2edbecbbde55ea8))
* update dependency org.threeten:threetenbp to v1.4.2 ([#142](https://www.github.com/googleapis/java-firestore/issues/142)) ([41b2a9a](https://www.github.com/googleapis/java-firestore/commit/41b2a9a8c556ddcdbe7ef244f0ae0e012546e09c))
* update dependency org.threeten:threetenbp to v1.4.3 ([#165](https://www.github.com/googleapis/java-firestore/issues/165)) ([d8bfa80](https://www.github.com/googleapis/java-firestore/commit/d8bfa801a855a2079fe42cec234a685bc35288a9))

### [1.32.5](https://www.github.com/googleapis/java-firestore/compare/v1.32.4...v1.32.5) (2020-03-05)


### Bug Fixes

* deflake-ify ITSystemTest#queryWatch ([#107](https://www.github.com/googleapis/java-firestore/issues/107)) ([f701c67](https://www.github.com/googleapis/java-firestore/commit/f701c67f9015ca96ca42c40f7e58d95dce70b18e))


### Dependencies

* update core dependencies ([#120](https://www.github.com/googleapis/java-firestore/issues/120)) ([293ba55](https://www.github.com/googleapis/java-firestore/commit/293ba5523bef2310acc91d5d97462c50889b75a8))
* update core dependencies to v1.93.1 ([#124](https://www.github.com/googleapis/java-firestore/issues/124)) ([6ce14ce](https://www.github.com/googleapis/java-firestore/commit/6ce14ce0fe4ff366792c18816f047c217e67f9f3))
* update dependency com.google.cloud:google-cloud-conformance-tests to v0.0.6 ([#118](https://www.github.com/googleapis/java-firestore/issues/118)) ([7dad920](https://www.github.com/googleapis/java-firestore/commit/7dad9207802c6d8e95aad13622735f43118405e1))
* update dependency io.grpc:grpc-bom to v1.27.2 ([#116](https://www.github.com/googleapis/java-firestore/issues/116)) ([83ef310](https://www.github.com/googleapis/java-firestore/commit/83ef31071ab3a26ea6d7a8ab2c0009de227b7ee7))
* update jackson dependencies to v2.10.3 ([#122](https://www.github.com/googleapis/java-firestore/issues/122)) ([85a3ced](https://www.github.com/googleapis/java-firestore/commit/85a3ced134d1752e6bee3b1445d946a51d5925cd))

### [1.32.4](https://www.github.com/googleapis/java-firestore/compare/v1.32.3...v1.32.4) (2020-02-18)


### Bug Fixes

* add cause to transaction errors on transaction commit ([#108](https://www.github.com/googleapis/java-firestore/issues/108)) ([00b3c6f](https://www.github.com/googleapis/java-firestore/commit/00b3c6f933eeb4a11cf4b18ea8c938549121f6c6))
* remove error_prone_annotations exclusion rules from poms ([#97](https://www.github.com/googleapis/java-firestore/issues/97)) ([0f9b474](https://www.github.com/googleapis/java-firestore/commit/0f9b4745f120644e9116a4461372260ce8506160))


### Dependencies

* update core dependencies to v1.92.5 ([#101](https://www.github.com/googleapis/java-firestore/issues/101)) ([e767078](https://www.github.com/googleapis/java-firestore/commit/e767078638e5ef22f753608cb64586f813ffc21b))
* update dependency io.grpc:grpc-bom to v1.27.1 ([#106](https://www.github.com/googleapis/java-firestore/issues/106)) ([46a7c48](https://www.github.com/googleapis/java-firestore/commit/46a7c4855a48d4ada559cf4941fb011ed40a6cf3))
* update opencensus.version to v0.25.0 ([#105](https://www.github.com/googleapis/java-firestore/issues/105)) ([fcdbab3](https://www.github.com/googleapis/java-firestore/commit/fcdbab3856f1b0c0ad81554e381c5158d87e490d))
* update protobuf.version to v3.11.4 ([#109](https://www.github.com/googleapis/java-firestore/issues/109)) ([4f498b4](https://www.github.com/googleapis/java-firestore/commit/4f498b448d6212ea921a2240413e17b86d2fb3d3))


### Documentation

* **regen:** update sample code to set total timeout, add API client header test ([#100](https://www.github.com/googleapis/java-firestore/issues/100)) ([d14a4a1](https://www.github.com/googleapis/java-firestore/commit/d14a4a1e30e4f9651a71ad9c10893b1eef321441))

### [1.32.3](https://www.github.com/googleapis/java-firestore/compare/v1.32.2...v1.32.3) (2020-02-03)


### Dependencies

* update core dependencies ([#89](https://www.github.com/googleapis/java-firestore/issues/89)) ([7593432](https://www.github.com/googleapis/java-firestore/commit/7593432fdeb3ec88dde1400e8517f6bc35372648))
* update dependency com.google.auth:google-auth-library-credentials to v0.20.0 ([#86](https://www.github.com/googleapis/java-firestore/issues/86)) ([f32bd9b](https://www.github.com/googleapis/java-firestore/commit/f32bd9bd23d5caf1f121927df173978b66d61833))
* update dependency com.google.cloud:google-cloud-conformance-tests to v0.0.5 ([#90](https://www.github.com/googleapis/java-firestore/issues/90)) ([f701446](https://www.github.com/googleapis/java-firestore/commit/f701446f7fb4d0b46b49a698171c8b1878d18623))
* update protobuf.version to v3.11.3 ([#94](https://www.github.com/googleapis/java-firestore/issues/94)) ([6155816](https://www.github.com/googleapis/java-firestore/commit/6155816c61ec999ae026884075af053500f5d448))

### [1.32.2](https://www.github.com/googleapis/java-firestore/compare/v1.32.1...v1.32.2) (2020-01-14)


### Dependencies

* update core dependencies ([#63](https://www.github.com/googleapis/java-firestore/issues/63)) ([4c1fb09](https://www.github.com/googleapis/java-firestore/commit/4c1fb091ed001cbebab9c2c16aaa93dd6f6875c8))
* update dependency com.fasterxml.jackson.core:jackson-core to v2.10.2 ([#69](https://www.github.com/googleapis/java-firestore/issues/69)) ([5e296b8](https://www.github.com/googleapis/java-firestore/commit/5e296b8439da390661a3c4eb44452c51fb4bf486))
* update dependency com.fasterxml.jackson.core:jackson-databind to v2.10.2 ([#70](https://www.github.com/googleapis/java-firestore/issues/70)) ([2f3a14b](https://www.github.com/googleapis/java-firestore/commit/2f3a14b075ff90209190319266ce25a5b94fcb31))
* update dependency com.google.cloud:google-cloud-conformance-tests to v0.0.4 ([#82](https://www.github.com/googleapis/java-firestore/issues/82)) ([6050055](https://www.github.com/googleapis/java-firestore/commit/6050055779d8e45f2904efddd8b58a8b9dd43c40))
* update dependency com.google.guava:guava-bom to v28.2-android ([#76](https://www.github.com/googleapis/java-firestore/issues/76)) ([c1dcb9f](https://www.github.com/googleapis/java-firestore/commit/c1dcb9f67b141d06226c1ec0d6661ff3c7d7c09c)), closes [#33](https://www.github.com/googleapis/java-firestore/issues/33)
* update dependency com.google.truth:truth to v1.0.1 ([#81](https://www.github.com/googleapis/java-firestore/issues/81)) ([5d16063](https://www.github.com/googleapis/java-firestore/commit/5d16063587bb3d195b3440ff1b62698b21b111af))
* update dependency org.threeten:threetenbp to v1.4.1 ([#78](https://www.github.com/googleapis/java-firestore/issues/78)) ([0db7256](https://www.github.com/googleapis/java-firestore/commit/0db72560449de74dc92030d84c0116d209f8ba12))

### [1.32.1](https://www.github.com/googleapis/java-firestore/compare/v1.32.0...v1.32.1) (2020-01-02)


### Bug Fixes

* add google-cloud-firestore to bom ([#65](https://www.github.com/googleapis/java-firestore/issues/65)) ([b273a58](https://www.github.com/googleapis/java-firestore/commit/b273a58c714c1d4e9b07bda68fe47aa5496d8456))
* set google-cloud-conformance-tests to test scope ([#44](https://www.github.com/googleapis/java-firestore/issues/44)) ([03983c3](https://www.github.com/googleapis/java-firestore/commit/03983c33228806fcf1fe7d9eaf8240f9d60ad75b))


### Dependencies

* update dependencies ([#51](https://www.github.com/googleapis/java-firestore/issues/51)) ([ce4c37b](https://www.github.com/googleapis/java-firestore/commit/ce4c37b06683a34665cbc963df7fbb5d5112888b)), closes [#49](https://www.github.com/googleapis/java-firestore/issues/49) [#50](https://www.github.com/googleapis/java-firestore/issues/50)
* update dependency com.google.auth:google-auth-library-credentials to v0.19.0 ([#48](https://www.github.com/googleapis/java-firestore/issues/48)) ([d68b457](https://www.github.com/googleapis/java-firestore/commit/d68b45785ec0d948e1c290ce71e698e19574ca28))
* update dependency com.google.cloud:google-cloud-conformance-tests to v0.0.3 ([#55](https://www.github.com/googleapis/java-firestore/issues/55)) ([6e6644f](https://www.github.com/googleapis/java-firestore/commit/6e6644fd6e18032d4a2633e74c17f02259d97759))
* update dependency junit:junit to v4.13 ([#62](https://www.github.com/googleapis/java-firestore/issues/62)) ([7f80e44](https://www.github.com/googleapis/java-firestore/commit/7f80e447a89d27b74730bf89bbcf448e15960ff9))


### Documentation

* bump bom version in README to 3.1.0 ([#47](https://www.github.com/googleapis/java-firestore/issues/47)) ([d8bebb3](https://www.github.com/googleapis/java-firestore/commit/d8bebb3847f24df13b3a2fd5a1fe5aa11348daaf))

## [1.32.0](https://www.github.com/googleapis/java-firestore/compare/1.31.0...v1.32.0) (2019-12-04)


### Features

* **firestore:** allow passing POJOs as field values throughout API reference ([#6843](https://www.github.com/googleapis/java-firestore/issues/6843)) ([180f5a9](https://www.github.com/googleapis/java-firestore/commit/180f5a965ca2ea8b22338d0cc186b3d8d3bb997e))


### Dependencies

* update gax.version to v1.51.0 ([#31](https://www.github.com/googleapis/java-firestore/issues/31)) ([d5125c5](https://www.github.com/googleapis/java-firestore/commit/d5125c57fe02652d0e1b3bb10a2f162ce7317659))
* update protobuf packages to v3.11.0 ([#26](https://www.github.com/googleapis/java-firestore/issues/26)) ([862ebce](https://www.github.com/googleapis/java-firestore/commit/862ebce0c9ef77d90bc16b612a856dbc75265929))
* update protobuf packages to v3.11.1 ([#28](https://www.github.com/googleapis/java-firestore/issues/28)) ([c0c3b2c](https://www.github.com/googleapis/java-firestore/commit/c0c3b2c8b00fdc44dd6235d477538b1c7f085325))
