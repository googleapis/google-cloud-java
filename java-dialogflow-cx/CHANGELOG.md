# Changelog

## [0.5.0](https://www.github.com/googleapis/java-dialogflow-cx/compare/v0.4.1...v0.5.0) (2020-12-15)


### Features

* allowed custom to specify webhook headers through query parameters ([#109](https://www.github.com/googleapis/java-dialogflow-cx/issues/109)) ([329b306](https://www.github.com/googleapis/java-dialogflow-cx/commit/329b306505d291dc9f7b3e9832adf20d0abc30a8))


### Bug Fixes

* change location in IT to be 'global' ([#103](https://www.github.com/googleapis/java-dialogflow-cx/issues/103)) ([4053872](https://www.github.com/googleapis/java-dialogflow-cx/commit/405387236262b9d04b074304f78f1cc1da4b662b))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.16.1 ([e0830ab](https://www.github.com/googleapis/java-dialogflow-cx/commit/e0830ab54843fce058aa9bdcf0e228e7c5b827fb))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.17.0 ([#114](https://www.github.com/googleapis/java-dialogflow-cx/issues/114)) ([772e3e6](https://www.github.com/googleapis/java-dialogflow-cx/commit/772e3e616d169e7ca496d80a49b46d272169ada8))

### [0.4.1](https://www.github.com/googleapis/java-dialogflow-cx/compare/v0.4.0...v0.4.1) (2020-12-02)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.16.0 ([#96](https://www.github.com/googleapis/java-dialogflow-cx/issues/96)) ([a3522ae](https://www.github.com/googleapis/java-dialogflow-cx/commit/a3522ae87ffdc09d26a6b97669b6bb2f86df5eb9))

## [0.4.0](https://www.github.com/googleapis/java-dialogflow-cx/compare/v0.3.1...v0.4.0) (2020-11-13)


### Features

* add v3 client ([#74](https://www.github.com/googleapis/java-dialogflow-cx/issues/74)) ([f1c6142](https://www.github.com/googleapis/java-dialogflow-cx/commit/f1c614229b458d18d1f631edb9a69b087a8ebbba))
* expose matched event in Sessions API. ([#83](https://www.github.com/googleapis/java-dialogflow-cx/issues/83)) ([22344ef](https://www.github.com/googleapis/java-dialogflow-cx/commit/22344ef0df7361dcb56b0b34d369b30b5bf482bd))

### [0.3.1](https://www.github.com/googleapis/java-dialogflow-cx/compare/v0.3.0...v0.3.1) (2020-11-11)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.15.0 ([#76](https://www.github.com/googleapis/java-dialogflow-cx/issues/76)) ([4f0bff4](https://www.github.com/googleapis/java-dialogflow-cx/commit/4f0bff488e4155e1ad1255503c497db932d4d7d8))

## [0.3.0](https://www.github.com/googleapis/java-dialogflow-cx/compare/v0.2.0...v0.3.0) (2020-11-09)


### ⚠ BREAKING CHANGES

* remove empty proto classes GcsProto and InteractiveVoiceResponseProto (#69)

### Bug Fixes

* remove empty proto classes GcsProto and InteractiveVoiceResponseProto ([#69](https://www.github.com/googleapis/java-dialogflow-cx/issues/69)) ([b62ff2d](https://www.github.com/googleapis/java-dialogflow-cx/commit/b62ff2d17c505f2846f83928e7b359d8d9617712))

## [0.2.0](https://www.github.com/googleapis/java-dialogflow-cx/compare/v0.1.2...v0.2.0) (2020-10-31)


### ⚠ BREAKING CHANGES

* removed enable_spell_correction from `NluSettings`

### Features

* added labels field and description field into Intent and Dtmf input to QueryInput ([#62](https://www.github.com/googleapis/java-dialogflow-cx/issues/62)) ([3220b26](https://www.github.com/googleapis/java-dialogflow-cx/commit/3220b26bba46fd83486df2bfd1603f0c770cdae6))
* Remove flow level spell correction setting. feat: Change LRO response for ImportAgent from Empty to ImportAgentResponse, to include the created agent name. feat: Add parameter flag into page and intent parameters. feat: Add `allow_playback_interruption` to OutputAudioText to make it have feature parity with Text message type. feat: Enable sentiment analysis feature. feat: Enable EventInput. feat: Enable `trigger_event` in MatchIntentResponse. docs: Add documentation for sessions. ([#42](https://www.github.com/googleapis/java-dialogflow-cx/issues/42)) ([77f6650](https://www.github.com/googleapis/java-dialogflow-cx/commit/77f66504b74069e65eca3e2afddd495565c064af))


### Documentation

* clarified wording for restore APIs and query input ([#48](https://www.github.com/googleapis/java-dialogflow-cx/issues/48)) ([aac888c](https://www.github.com/googleapis/java-dialogflow-cx/commit/aac888cc0f977dad6b4dfb18111736020669a44d))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.12.1 ([#54](https://www.github.com/googleapis/java-dialogflow-cx/issues/54)) ([dbb09fc](https://www.github.com/googleapis/java-dialogflow-cx/commit/dbb09fc10f93be932f8408afb294c0fd9fa1579e))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.13.0 ([#57](https://www.github.com/googleapis/java-dialogflow-cx/issues/57)) ([bd56a97](https://www.github.com/googleapis/java-dialogflow-cx/commit/bd56a97904f6d7f9f64684060b808a74306f4d2f))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.14.1 ([#64](https://www.github.com/googleapis/java-dialogflow-cx/issues/64)) ([e45660d](https://www.github.com/googleapis/java-dialogflow-cx/commit/e45660d4acf0147979c1058cfc25a91bc9725653))

### [0.1.2](https://www.github.com/googleapis/java-dialogflow-cx/compare/v0.1.1...v0.1.2) (2020-10-08)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.10.2 ([#40](https://www.github.com/googleapis/java-dialogflow-cx/issues/40)) ([e76a54c](https://www.github.com/googleapis/java-dialogflow-cx/commit/e76a54c3b4056c68af415697b2848d7ac4c97bd8))

### [0.1.1](https://www.github.com/googleapis/java-dialogflow-cx/compare/v0.1.0...v0.1.1) (2020-09-23)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.10.0 ([#31](https://www.github.com/googleapis/java-dialogflow-cx/issues/31)) ([7a51730](https://www.github.com/googleapis/java-dialogflow-cx/commit/7a51730e2b48ab2d37f108cc56ff07338e942bac))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.9.0 ([#17](https://www.github.com/googleapis/java-dialogflow-cx/issues/17)) ([f0b8c30](https://www.github.com/googleapis/java-dialogflow-cx/commit/f0b8c309cbd7cf3dc79a68a06d0bb39e5102389e))

## 0.1.0 (2020-08-26)


### Features

* (a) Add additional binding for session with environment. (b) Allow force delete entity types and webhooks. ([#6](https://www.github.com/googleapis/java-dialogflow-cx/issues/6)) ([b0b0a70](https://www.github.com/googleapis/java-dialogflow-cx/commit/b0b0a7074e30be01ce2f750d6a49cb242e7e1a99))
* initial code generation ([2334a83](https://www.github.com/googleapis/java-dialogflow-cx/commit/2334a83a56615cb11b73369ab47b214caaa72201))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.6 ([#4](https://www.github.com/googleapis/java-dialogflow-cx/issues/4)) ([e1e7f44](https://www.github.com/googleapis/java-dialogflow-cx/commit/e1e7f44f690c488dfabaa602a84dca2ae4d209c5))
