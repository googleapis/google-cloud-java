# Changelog

### [0.5.2](https://www.github.com/googleapis/java-analytics-data/compare/v0.5.1...v0.5.2) (2020-12-14)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.16.1 ([4f26986](https://www.github.com/googleapis/java-analytics-data/commit/4f269863aaa3c4b3ed746474784858dce4bb9a74))

### [0.5.1](https://www.github.com/googleapis/java-analytics-data/compare/v0.5.0...v0.5.1) (2020-12-02)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.16.0 ([#100](https://www.github.com/googleapis/java-analytics-data/issues/100)) ([cc53daf](https://www.github.com/googleapis/java-analytics-data/commit/cc53daf914a11481c1848d5d813dfd4a776bc177))

## [0.5.0](https://www.github.com/googleapis/java-analytics-data/compare/v0.4.0...v0.5.0) (2020-11-12)


### ⚠ BREAKING CHANGES

* GetUniversalMetadata method removed from the API, GetMetadata method should be used instead feat: reporting requests now support date ranges longer than one year docs: minor documentation updates (#89)

### Bug Fixes

* GetUniversalMetadata method removed from the API, GetMetadata method should be used instead feat: reporting requests now support date ranges longer than one year docs: minor documentation updates ([#89](https://www.github.com/googleapis/java-analytics-data/issues/89)) ([e3b69f6](https://www.github.com/googleapis/java-analytics-data/commit/e3b69f6ae443113244cd333e518d6fa79da4488c))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.15.0 ([#87](https://www.github.com/googleapis/java-analytics-data/issues/87)) ([04ad0c9](https://www.github.com/googleapis/java-analytics-data/commit/04ad0c9815ec03e00e1c6db120db7a3d049dbfb3))

## [0.4.0](https://www.github.com/googleapis/java-analytics-data/compare/v0.3.0...v0.4.0) (2020-11-04)


### Features

* added RunRealtimeReport method that returns a customized report of realtime event data for a GA4 property docs: minor documentation updates ([#80](https://www.github.com/googleapis/java-analytics-data/issues/80)) ([815fe2e](https://www.github.com/googleapis/java-analytics-data/commit/815fe2ed8456feef0d972f5610cf4ae73657a9fe))


### Documentation

* App+Web properties renamed to GA4 ([#78](https://www.github.com/googleapis/java-analytics-data/issues/78)) ([6a49d40](https://www.github.com/googleapis/java-analytics-data/commit/6a49d40411b4b51ba74e2632e736f239d933c6e5))

## [0.3.0](https://www.github.com/googleapis/java-analytics-data/compare/v0.2.1...v0.3.0) (2020-10-31)


### Features

* added GetMetadata method for metadata including custom dimensions and metrics. ([#65](https://www.github.com/googleapis/java-analytics-data/issues/65)) ([609457a](https://www.github.com/googleapis/java-analytics-data/commit/609457a68abaf439803bf9f3e147cb27b21e4853))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.14.1 ([#74](https://www.github.com/googleapis/java-analytics-data/issues/74)) ([a43d65d](https://www.github.com/googleapis/java-analytics-data/commit/a43d65dad4f7adb7c39e7110a9f8d1c181b2ea14))

### [0.2.1](https://www.github.com/googleapis/java-analytics-data/compare/v0.2.0...v0.2.1) (2020-10-22)


### Documentation

* added a sample ([#53](https://www.github.com/googleapis/java-analytics-data/issues/53)) ([e3b5d97](https://www.github.com/googleapis/java-analytics-data/commit/e3b5d976993df0f254a72d16babe83ba76de9d46))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.12.1 ([#59](https://www.github.com/googleapis/java-analytics-data/issues/59)) ([2cb6de2](https://www.github.com/googleapis/java-analytics-data/commit/2cb6de2b56dd51758358d04b036c7f1b24b5d2dc))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.13.0 ([#62](https://www.github.com/googleapis/java-analytics-data/issues/62)) ([8f2101e](https://www.github.com/googleapis/java-analytics-data/commit/8f2101e13f35b01abfd283b065d19163c3a58c24))

## [0.2.0](https://www.github.com/googleapis/java-analytics-data/compare/v0.1.1...v0.2.0) (2020-10-12)


### ⚠ BREAKING CHANGES

* DimensionHeader renamed to PivotDimensionHeader

### Features

* GetMetadata method renamed to GetUniversalMetdata docs: documentation updates ([#40](https://www.github.com/googleapis/java-analytics-data/issues/40)) ([7931f8f](https://www.github.com/googleapis/java-analytics-data/commit/7931f8ff01dad7b0d3bf5dec334b40ff4b372e5b))
* rename DimensionHeader to PivotDimensionHeader, add TYPE_SECONDS, TYPE_CURRENCY to MetricType ([#21](https://www.github.com/googleapis/java-analytics-data/issues/21)) ([fcdd02a](https://www.github.com/googleapis/java-analytics-data/commit/fcdd02a90e80a35801195c8f193d7d280ed21276))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.10.0 ([#33](https://www.github.com/googleapis/java-analytics-data/issues/33)) ([a209bdc](https://www.github.com/googleapis/java-analytics-data/commit/a209bdc956ddd5f6805717dd4915d870a21bac13))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.10.2 ([#41](https://www.github.com/googleapis/java-analytics-data/issues/41)) ([38ec38f](https://www.github.com/googleapis/java-analytics-data/commit/38ec38f03eed5f34f42087e023eaa306546ae4f6))

### [0.1.1](https://www.github.com/googleapis/java-analytics-data/compare/v0.1.0...v0.1.1) (2020-09-21)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.9.0 ([#15](https://www.github.com/googleapis/java-analytics-data/issues/15)) ([8b8ff79](https://www.github.com/googleapis/java-analytics-data/commit/8b8ff792dc4a683f5dd76a8567e22d0a58c6c485))

## 0.1.0 (2020-08-28)


### Features

* initial code generation ([0ac2ab2](https://www.github.com/googleapis/java-analytics-data/commit/0ac2ab28087be281328851ed06460c024ed19e5a))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.6 ([#5](https://www.github.com/googleapis/java-analytics-data/issues/5)) ([a3ac1b3](https://www.github.com/googleapis/java-analytics-data/commit/a3ac1b37621e5ee1e1c9580ab29905a603a8587d))
