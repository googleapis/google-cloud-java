# Changelog

### [0.10.1](https://www.github.com/googleapis/java-analytics-data/compare/v0.10.0...v0.10.1) (2021-09-22)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.3.0 ([#338](https://www.github.com/googleapis/java-analytics-data/issues/338)) ([9d17e92](https://www.github.com/googleapis/java-analytics-data/commit/9d17e92ffcf46cfeb18b52475c1b70f5b9385c4b))

## [0.10.0](https://www.github.com/googleapis/java-analytics-data/compare/v0.9.2...v0.10.0) (2021-09-14)


### Features

* Remove use of deprecated gradle command in java README ([#1196](https://www.github.com/googleapis/java-analytics-data/issues/1196)) ([#319](https://www.github.com/googleapis/java-analytics-data/issues/319)) ([a9738c2](https://www.github.com/googleapis/java-analytics-data/commit/a9738c250bc6fe00b647d0b62ad001a3f9e04fa1))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.2.0 ([#322](https://www.github.com/googleapis/java-analytics-data/issues/322)) ([a274776](https://www.github.com/googleapis/java-analytics-data/commit/a27477683a4dedb04b4189b0ddeda54d1f303cb0))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.2.1 ([#332](https://www.github.com/googleapis/java-analytics-data/issues/332)) ([f3fc6b7](https://www.github.com/googleapis/java-analytics-data/commit/f3fc6b7613ef41597178d0f964fae7d873bb2e1d))

### [0.9.2](https://www.github.com/googleapis/java-analytics-data/compare/v0.9.1...v0.9.2) (2021-08-23)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.1.0 ([#313](https://www.github.com/googleapis/java-analytics-data/issues/313)) ([cff72c2](https://www.github.com/googleapis/java-analytics-data/commit/cff72c267b46faa01382d6e9a649cf6f119ffa30))

### [0.9.1](https://www.github.com/googleapis/java-analytics-data/compare/v0.9.0...v0.9.1) (2021-08-12)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.0.1 ([#307](https://www.github.com/googleapis/java-analytics-data/issues/307)) ([10a3888](https://www.github.com/googleapis/java-analytics-data/commit/10a3888d7c2b259b84bfa96de15fef3f38ed0bd5))

## [0.9.0](https://www.github.com/googleapis/java-analytics-data/compare/v0.8.0...v0.9.0) (2021-08-06)


### ⚠ BREAKING CHANGES

* release gapic-generator-java v2.0.0 (#300)

### Features

* add `minute_ranges` field to `RunRealtimeReportRequest` object which can be used to specify the time range (in minutes) for realtime report queries ([#233](https://www.github.com/googleapis/java-analytics-data/issues/233)) ([f99488a](https://www.github.com/googleapis/java-analytics-data/commit/f99488a8630de5cd201ea524027d3cacf0b4b08f))
* release gapic-generator-java v2.0.0 ([#300](https://www.github.com/googleapis/java-analytics-data/issues/300)) ([3f26958](https://www.github.com/googleapis/java-analytics-data/commit/3f269581a86dece46234a47075c74d8883ebaef3))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2 ([#301](https://www.github.com/googleapis/java-analytics-data/issues/301)) ([4172163](https://www.github.com/googleapis/java-analytics-data/commit/4172163883152f300fc69609f0c67b9dc66edae6))

## [0.8.0](https://www.github.com/googleapis/java-analytics-data/compare/v0.7.1...v0.8.0) (2021-07-15)


### Features

* add `gcf-owl-bot[bot]` to `ignoreAuthors` ([#213](https://www.github.com/googleapis/java-analytics-data/issues/213)) ([4791520](https://www.github.com/googleapis/java-analytics-data/commit/479152031b0f2963191c387a8500d83fddaf6624))
* add `kind` field which is used to distinguish between response types feat: add `potentially_thresholded_requests_per_hour` field to `PropertyQuota` ([#182](https://www.github.com/googleapis/java-analytics-data/issues/182)) ([8b30dcd](https://www.github.com/googleapis/java-analytics-data/commit/8b30dcd3132fd5a43955dda3f4c4aaddac2d0035))
* add `potentially_thresholded_requests_per_hour` field to `PropertyQuota` ([c1d3e02](https://www.github.com/googleapis/java-analytics-data/commit/c1d3e02456af734220c88fce4b67e8702583cf1a))
* add kind field which is used to distinguish between responsetypes ([c1d3e02](https://www.github.com/googleapis/java-analytics-data/commit/c1d3e02456af734220c88fce4b67e8702583cf1a))


### Bug Fixes

* Add `shopt -s nullglob` to dependencies script ([#1130](https://www.github.com/googleapis/java-analytics-data/issues/1130)) ([#228](https://www.github.com/googleapis/java-analytics-data/issues/228)) ([f4ea7d3](https://www.github.com/googleapis/java-analytics-data/commit/f4ea7d32ba63a60401940968d00e15ac31f7409c))
* owlbot post-processor should generate README ([#1154](https://www.github.com/googleapis/java-analytics-data/issues/1154)) ([#234](https://www.github.com/googleapis/java-analytics-data/issues/234)) ([89cd9b5](https://www.github.com/googleapis/java-analytics-data/commit/89cd9b51a892cadee81932c3562264c5c6f2a0f8)), closes [#1146](https://www.github.com/googleapis/java-analytics-data/issues/1146) [#1147](https://www.github.com/googleapis/java-analytics-data/issues/1147)
* release scripts from issuing overlapping phases ([#196](https://www.github.com/googleapis/java-analytics-data/issues/196)) ([a17287f](https://www.github.com/googleapis/java-analytics-data/commit/a17287fe5ce6b76f4a55d340c77fba11c9c459b8))
* typo ([#194](https://www.github.com/googleapis/java-analytics-data/issues/194)) ([e62c6ef](https://www.github.com/googleapis/java-analytics-data/commit/e62c6ef3069442fd32727609215521478a07e8ca))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.21.1 ([#197](https://www.github.com/googleapis/java-analytics-data/issues/197)) ([4aba8fa](https://www.github.com/googleapis/java-analytics-data/commit/4aba8fa114b46ca1eefd64f63a5ffe9f1d726dd2))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1 ([#201](https://www.github.com/googleapis/java-analytics-data/issues/201)) ([46af6c8](https://www.github.com/googleapis/java-analytics-data/commit/46af6c80d0c838dcec27087e585c83f7eca50eda))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.1.0 ([#209](https://www.github.com/googleapis/java-analytics-data/issues/209)) ([f15138c](https://www.github.com/googleapis/java-analytics-data/commit/f15138c30e675f56a47480e76ead95193286669e))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.2.0 ([#212](https://www.github.com/googleapis/java-analytics-data/issues/212)) ([f34f92b](https://www.github.com/googleapis/java-analytics-data/commit/f34f92b0869cbd87b7f8909d1a5335e4adbb4851))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.3.0 ([#221](https://www.github.com/googleapis/java-analytics-data/issues/221)) ([1edc82e](https://www.github.com/googleapis/java-analytics-data/commit/1edc82e2a151692805472f87c550df7f0321b190))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.4.0 ([#229](https://www.github.com/googleapis/java-analytics-data/issues/229)) ([f3e97ab](https://www.github.com/googleapis/java-analytics-data/commit/f3e97ab77a5b09879ade1b49fdac067ede5d6a88))

### [0.7.1](https://www.github.com/googleapis/java-analytics-data/compare/v0.7.0...v0.7.1) (2021-04-09)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.21.0 ([#186](https://www.github.com/googleapis/java-analytics-data/issues/186)) ([c7ce3e7](https://www.github.com/googleapis/java-analytics-data/commit/c7ce3e791811a7f6740f7961ccc1831c875d3186))

## [0.7.0](https://www.github.com/googleapis/java-analytics-data/compare/v0.6.0...v0.7.0) (2021-03-16)


### ⚠ BREAKING CHANGES

* rename the 'page_size', 'page_token', 'total_size' fields to 'limit', 'offset' and 'row_count' respectively (#170)

### Features

* **generator:** update protoc to v3.15.3 ([#163](https://www.github.com/googleapis/java-analytics-data/issues/163)) ([b1852d4](https://www.github.com/googleapis/java-analytics-data/commit/b1852d4c78b4d9aa49d0b8c5bd3b9a5d2cc5fdb6))


### Bug Fixes

* rename the 'page_size', 'page_token', 'total_size' fields to 'limit', 'offset' and 'row_count' respectively ([#170](https://www.github.com/googleapis/java-analytics-data/issues/170)) ([cfd43f0](https://www.github.com/googleapis/java-analytics-data/commit/cfd43f0a854379ad2161c1af8a709ebfb96196bd))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.20.1 ([#171](https://www.github.com/googleapis/java-analytics-data/issues/171)) ([6d06098](https://www.github.com/googleapis/java-analytics-data/commit/6d0609886aca2ae74b3e5d6f840110e93fe95adc))

## [0.6.0](https://www.github.com/googleapis/java-analytics-data/compare/v0.5.5...v0.6.0) (2021-02-26)


### Features

* add v1beta client ([#158](https://www.github.com/googleapis/java-analytics-data/issues/158)) ([545cca0](https://www.github.com/googleapis/java-analytics-data/commit/545cca098dd4a054d3110761347cfe3aabc41ccd))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.20.0 ([#159](https://www.github.com/googleapis/java-analytics-data/issues/159)) ([009ac70](https://www.github.com/googleapis/java-analytics-data/commit/009ac70ab39adf5b0edad5fe80799dc5a51eb7f8))

### [0.5.5](https://www.github.com/googleapis/java-analytics-data/compare/v0.5.4...v0.5.5) (2021-02-22)


### Bug Fixes

* don't log downloads ([#152](https://www.github.com/googleapis/java-analytics-data/issues/152)) ([e173782](https://www.github.com/googleapis/java-analytics-data/commit/e17378207bf50ccd1b5f931481cf1c894908fe25))


### Documentation

* generate sample code in the Java microgenerator ([#135](https://www.github.com/googleapis/java-analytics-data/issues/135)) ([0470fd1](https://www.github.com/googleapis/java-analytics-data/commit/0470fd12172a87ff90d279775b1931e48ece51d0))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.19.0 ([#153](https://www.github.com/googleapis/java-analytics-data/issues/153)) ([535c757](https://www.github.com/googleapis/java-analytics-data/commit/535c757a963f8e771f892244421dfb364a96256f))

### [0.5.4](https://www.github.com/googleapis/java-analytics-data/compare/v0.5.3...v0.5.4) (2021-01-14)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.18.0 ([#119](https://www.github.com/googleapis/java-analytics-data/issues/119)) ([9d4fae0](https://www.github.com/googleapis/java-analytics-data/commit/9d4fae0fd65e6533e3cb70cba54fc08d75d8b725))

### [0.5.3](https://www.github.com/googleapis/java-analytics-data/compare/v0.5.2...v0.5.3) (2020-12-15)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.17.0 ([#112](https://www.github.com/googleapis/java-analytics-data/issues/112)) ([224e55b](https://www.github.com/googleapis/java-analytics-data/commit/224e55bd24bbe0a946e0859a9b16a3923851a13e))

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
