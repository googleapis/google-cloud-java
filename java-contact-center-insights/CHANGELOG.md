# Changelog

### [2.1.3](https://www.github.com/googleapis/java-contact-center-insights/compare/v2.1.2...v2.1.3) (2021-10-20)


### Dependencies

* update dependency com.google.cloud:google-cloud-pubsub to v1.114.7 ([#119](https://www.github.com/googleapis/java-contact-center-insights/issues/119)) ([fd027e2](https://www.github.com/googleapis/java-contact-center-insights/commit/fd027e220ea849247aff67cd360ca313014096b8))

### [2.1.2](https://www.github.com/googleapis/java-contact-center-insights/compare/v2.1.1...v2.1.2) (2021-10-19)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.4.0 ([#115](https://www.github.com/googleapis/java-contact-center-insights/issues/115)) ([64963a9](https://www.github.com/googleapis/java-contact-center-insights/commit/64963a98113e348587f615cf4230404d91c0f85e))

### [2.1.1](https://www.github.com/googleapis/java-contact-center-insights/compare/v2.1.0...v2.1.1) (2021-10-06)


### Dependencies

* update dependency com.google.cloud:google-cloud-pubsub to v1.114.6 ([#108](https://www.github.com/googleapis/java-contact-center-insights/issues/108)) ([da9a533](https://www.github.com/googleapis/java-contact-center-insights/commit/da9a53368e229c1f3ec30443ee62709cdc0423f0))

## [2.1.0](https://www.github.com/googleapis/java-contact-center-insights/compare/v2.0.0...v2.1.0) (2021-10-04)


### Features

* add metadata from dialogflow related to transcript segment ([#103](https://www.github.com/googleapis/java-contact-center-insights/issues/103)) ([7b4e2a3](https://www.github.com/googleapis/java-contact-center-insights/commit/7b4e2a39f973a40117646af5f7eaad5967e3c02f))
* deprecate issue_matches ([#104](https://www.github.com/googleapis/java-contact-center-insights/issues/104)) ([8649d26](https://www.github.com/googleapis/java-contact-center-insights/commit/8649d26244b282bad5aed44b163d38aa790a1f42))
* display_name is the display name for the assigned issue ([#60](https://www.github.com/googleapis/java-contact-center-insights/issues/60)) ([b84ae88](https://www.github.com/googleapis/java-contact-center-insights/commit/b84ae882940a4a592398b98be57ca883a978c676))
* filter is used to filter conversations used for issue model training feat: update_time is used to indicate when the phrase matcher was updated ([#91](https://www.github.com/googleapis/java-contact-center-insights/issues/91)) ([2ce0ec9](https://www.github.com/googleapis/java-contact-center-insights/commit/2ce0ec9912df34a47689951640022fdc2362fe12))
* Remove use of deprecated gradle command in java README ([#1196](https://www.github.com/googleapis/java-contact-center-insights/issues/1196)) ([#61](https://www.github.com/googleapis/java-contact-center-insights/issues/61)) ([f7abb3a](https://www.github.com/googleapis/java-contact-center-insights/commit/f7abb3ae97565d92818d793e8d4d6f14a025bb3e))


### Dependencies

* update dependency com.google.cloud:google-cloud-pubsub to v1.114.4 ([#92](https://www.github.com/googleapis/java-contact-center-insights/issues/92)) ([97996b1](https://www.github.com/googleapis/java-contact-center-insights/commit/97996b114c58b54b0e6e315e177065f54f99a5f8))
* update dependency com.google.cloud:google-cloud-pubsub to v1.114.5 ([#100](https://www.github.com/googleapis/java-contact-center-insights/issues/100)) ([a70dd43](https://www.github.com/googleapis/java-contact-center-insights/commit/a70dd4390847a1980cb498ae09058f9314f06326))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.0.1 ([#52](https://www.github.com/googleapis/java-contact-center-insights/issues/52)) ([07f27be](https://www.github.com/googleapis/java-contact-center-insights/commit/07f27bea882450575639eff7c03a8e31c2fe18a1))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.1.0 ([#56](https://www.github.com/googleapis/java-contact-center-insights/issues/56)) ([7c1232b](https://www.github.com/googleapis/java-contact-center-insights/commit/7c1232b4182b5a83e3fdc13ab24f69ecd9b07446))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.2.0 ([#63](https://www.github.com/googleapis/java-contact-center-insights/issues/63)) ([1cb9a14](https://www.github.com/googleapis/java-contact-center-insights/commit/1cb9a14f37c2dc38f67716a49aef47d072ab51be))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.2.1 ([#85](https://www.github.com/googleapis/java-contact-center-insights/issues/85)) ([7075fc9](https://www.github.com/googleapis/java-contact-center-insights/commit/7075fc965a79d6f94401d070a988e865c2e8c9aa))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.3.0 ([#96](https://www.github.com/googleapis/java-contact-center-insights/issues/96)) ([214475c](https://www.github.com/googleapis/java-contact-center-insights/commit/214475c4cff721ac8d6c6a561ba55f2ea0dcceab))

## [2.0.0](https://www.github.com/googleapis/java-contact-center-insights/compare/v1.0.0...v2.0.0) (2021-08-09)


### ⚠ BREAKING CHANGES

* update CCAI Insights protos. BREAKING_CHANGE: change nesting of Conversation.Transcript.Participant to ConversationParticipant and remove AnnotationBoundary.time_offset (#33)
* release gapic-generator-java v2.0.0 (#47)

### Features

* release gapic-generator-java v2.0.0 ([#47](https://www.github.com/googleapis/java-contact-center-insights/issues/47)) ([19d5ad3](https://www.github.com/googleapis/java-contact-center-insights/commit/19d5ad38a6337f1ac2bc722a0f0ef4bc2ab336d3))
* update CCAI Insights protos. BREAKING_CHANGE: change nesting of Conversation.Transcript.Participant to ConversationParticipant and remove AnnotationBoundary.time_offset ([#33](https://www.github.com/googleapis/java-contact-center-insights/issues/33)) ([57c5ff5](https://www.github.com/googleapis/java-contact-center-insights/commit/57c5ff5d4c9b464ca5bff91aa5dd2917cde3d67a))


### Bug Fixes

* owlbot post-processor should generate README ([#1154](https://www.github.com/googleapis/java-contact-center-insights/issues/1154)) ([#29](https://www.github.com/googleapis/java-contact-center-insights/issues/29)) ([2895d64](https://www.github.com/googleapis/java-contact-center-insights/commit/2895d645305381c904d441e2c275a4e2b8e8f08b)), closes [#1146](https://www.github.com/googleapis/java-contact-center-insights/issues/1146) [#1147](https://www.github.com/googleapis/java-contact-center-insights/issues/1147)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2 ([#46](https://www.github.com/googleapis/java-contact-center-insights/issues/46)) ([cc93735](https://www.github.com/googleapis/java-contact-center-insights/commit/cc9373572a41b26de9b7684760b3e6f9704fecdf))

## [1.0.0](https://www.github.com/googleapis/java-contact-center-insights/compare/v0.1.0...v1.0.0) (2021-07-12)


### Features

* promote to 1.0.0 ([#25](https://www.github.com/googleapis/java-contact-center-insights/issues/25)) ([f74d86c](https://www.github.com/googleapis/java-contact-center-insights/commit/f74d86c39ae3cd576bd4a4942d729ea8ec49a7e1))


### Bug Fixes

* Add `shopt -s nullglob` to dependencies script ([#1130](https://www.github.com/googleapis/java-contact-center-insights/issues/1130)) ([#22](https://www.github.com/googleapis/java-contact-center-insights/issues/22)) ([0feb7bc](https://www.github.com/googleapis/java-contact-center-insights/commit/0feb7bc37e9874a9b57df54a65302ad8c61ccc9d))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.4.0 ([#24](https://www.github.com/googleapis/java-contact-center-insights/issues/24)) ([9676d88](https://www.github.com/googleapis/java-contact-center-insights/commit/9676d889faf8938872adc569f1a91d5ad48eb90e))

## 0.1.0 (2021-06-09)


### Features

* initial client generation ([437f5f8](https://www.github.com/googleapis/java-contact-center-insights/commit/437f5f81ca1281ce7096208905ef0fa74422afd6))


### Dependencies

* update google-cloud-shared-config and google-cloud-shared-dependencies ([#2](https://www.github.com/googleapis/java-contact-center-insights/issues/2)) ([37e6a61](https://www.github.com/googleapis/java-contact-center-insights/commit/37e6a61df48366384ff1268e67958f6c92b01027))
