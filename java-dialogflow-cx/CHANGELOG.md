# Changelog

## [0.7.0](https://www.github.com/googleapis/java-dialogflow-cx/compare/v0.6.1...v0.7.0) (2021-05-31)


### Features

* add `gcf-owl-bot[bot]` to `ignoreAuthors` ([#217](https://www.github.com/googleapis/java-dialogflow-cx/issues/217)) ([b53b2f2](https://www.github.com/googleapis/java-dialogflow-cx/commit/b53b2f222680b46f87943f9ab7099070910fc1b1))
* add export / import flow API ([b29dfea](https://www.github.com/googleapis/java-dialogflow-cx/commit/b29dfea9e09d6852caf78eacdc45a7feb0c79370))
* add support for service directory webhooks ([#210](https://www.github.com/googleapis/java-dialogflow-cx/issues/210)) ([0ae811a](https://www.github.com/googleapis/java-dialogflow-cx/commit/0ae811ac66d6720d5d6d13eda8b124a2bf8f14a2))
* added API for continuous test ([#220](https://www.github.com/googleapis/java-dialogflow-cx/issues/220)) ([b96fc92](https://www.github.com/googleapis/java-dialogflow-cx/commit/b96fc9250224f72fa8a59c711e088b1b399ab277))
* added fallback option when restoring an agent ([#164](https://www.github.com/googleapis/java-dialogflow-cx/issues/164)) ([d38deef](https://www.github.com/googleapis/java-dialogflow-cx/commit/d38deefc49b6fd2bd805748c4046691dbeb3964d))
* added fallback option when restoring an agent ([#166](https://www.github.com/googleapis/java-dialogflow-cx/issues/166)) ([f745beb](https://www.github.com/googleapis/java-dialogflow-cx/commit/f745beb41ed7844909c7acd43235a490faefc619))
* allow to disable webhook invocation per request ([#156](https://www.github.com/googleapis/java-dialogflow-cx/issues/156)) ([17ff978](https://www.github.com/googleapis/java-dialogflow-cx/commit/17ff97848778900c946b13cca420cd7fd7d60a5d))
* allow to disable webhook invocation per request ([#158](https://www.github.com/googleapis/java-dialogflow-cx/issues/158)) ([60e5204](https://www.github.com/googleapis/java-dialogflow-cx/commit/60e520467e609a110467053bae2642c2a4b9e956))
* Expose supported languages of the agent ([#205](https://www.github.com/googleapis/java-dialogflow-cx/issues/205)) ([b29dfea](https://www.github.com/googleapis/java-dialogflow-cx/commit/b29dfea9e09d6852caf78eacdc45a7feb0c79370))
* include original user query in WebhookRequest and add GetTextCaseresult API ([#169](https://www.github.com/googleapis/java-dialogflow-cx/issues/169)) ([43cdc98](https://www.github.com/googleapis/java-dialogflow-cx/commit/43cdc986d04472760a42f61e8318090bd5565052))
* support setting current_page to resume sessions; expose transition_route_groups in flows and language_code in webhook ([#173](https://www.github.com/googleapis/java-dialogflow-cx/issues/173)) ([ac7eec7](https://www.github.com/googleapis/java-dialogflow-cx/commit/ac7eec7204eaa25bc4dd061d4006c6a34a71415b))


### Bug Fixes

* release scripts from issuing overlapping phases ([#180](https://www.github.com/googleapis/java-dialogflow-cx/issues/180)) ([7d4e099](https://www.github.com/googleapis/java-dialogflow-cx/commit/7d4e099dfe6081d5fa72c807241fe0df7be8e851))
* typo ([#178](https://www.github.com/googleapis/java-dialogflow-cx/issues/178)) ([ef6800b](https://www.github.com/googleapis/java-dialogflow-cx/commit/ef6800bbfa0cc9027bffad6aaacccb1902d182c1))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.20.1 ([#163](https://www.github.com/googleapis/java-dialogflow-cx/issues/163)) ([a3f793c](https://www.github.com/googleapis/java-dialogflow-cx/commit/a3f793c61aa6a08947c9c2ddcd1d45a276d40e68))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.21.0 ([#175](https://www.github.com/googleapis/java-dialogflow-cx/issues/175)) ([45f31e7](https://www.github.com/googleapis/java-dialogflow-cx/commit/45f31e7068457c00a90bebd7be9620319d2634a7))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.21.1 ([#181](https://www.github.com/googleapis/java-dialogflow-cx/issues/181)) ([7067d39](https://www.github.com/googleapis/java-dialogflow-cx/commit/7067d39be16f5a248c8bfb1f881404a052e5da28))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1 ([#202](https://www.github.com/googleapis/java-dialogflow-cx/issues/202)) ([a55e7af](https://www.github.com/googleapis/java-dialogflow-cx/commit/a55e7af7c5ab337d4db25b646ba50e5ab4290d47))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.1.0 ([#212](https://www.github.com/googleapis/java-dialogflow-cx/issues/212)) ([8d6c4ef](https://www.github.com/googleapis/java-dialogflow-cx/commit/8d6c4efeb97e35056f1cd83870e1e0c3c8f07699))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.2.0 ([#216](https://www.github.com/googleapis/java-dialogflow-cx/issues/216)) ([79e5071](https://www.github.com/googleapis/java-dialogflow-cx/commit/79e507163cc166663d4678e22141e82e0df3cf9b))


### Documentation

* clarified experiment length ([f745beb](https://www.github.com/googleapis/java-dialogflow-cx/commit/f745beb41ed7844909c7acd43235a490faefc619))
* clarified experiment length ([d38deef](https://www.github.com/googleapis/java-dialogflow-cx/commit/d38deefc49b6fd2bd805748c4046691dbeb3964d))
* Update docs on Pages, Session, Version, etc. ([b29dfea](https://www.github.com/googleapis/java-dialogflow-cx/commit/b29dfea9e09d6852caf78eacdc45a7feb0c79370))
* **v3beta1:** clarified documentation for security settings ([f42002c](https://www.github.com/googleapis/java-dialogflow-cx/commit/f42002ce744e96c80902a4476806496d155652a2))
* **v3beta1:** clarified documentation for session parameters ([f42002c](https://www.github.com/googleapis/java-dialogflow-cx/commit/f42002ce744e96c80902a4476806496d155652a2))
* **v3:** clarified documentation for security settings ([#215](https://www.github.com/googleapis/java-dialogflow-cx/issues/215)) ([f42002c](https://www.github.com/googleapis/java-dialogflow-cx/commit/f42002ce744e96c80902a4476806496d155652a2))
* **v3:** clarified documentation for session parameters ([f42002c](https://www.github.com/googleapis/java-dialogflow-cx/commit/f42002ce744e96c80902a4476806496d155652a2))

### [0.6.1](https://www.github.com/googleapis/java-dialogflow-cx/compare/v0.6.0...v0.6.1) (2021-02-25)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.20.0 ([#151](https://www.github.com/googleapis/java-dialogflow-cx/issues/151)) ([394b190](https://www.github.com/googleapis/java-dialogflow-cx/commit/394b190114942e03d4b9ca92cd9c9f1bf1f7c958))

## [0.6.0](https://www.github.com/googleapis/java-dialogflow-cx/compare/v0.5.0...v0.6.0) (2021-02-25)


### Features

* add experiment and security settings API docs: update comments on parameters and agent ([#124](https://www.github.com/googleapis/java-dialogflow-cx/issues/124)) ([06ee69a](https://www.github.com/googleapis/java-dialogflow-cx/commit/06ee69ac49cdd2f0cc6316e7613d120434dfb65f))
* Add new Experiment service ([a79149b](https://www.github.com/googleapis/java-dialogflow-cx/commit/a79149b73f3c74b7d35ec230702fc9f61c2ede3b))
* added support for test cases and agent validation ([#141](https://www.github.com/googleapis/java-dialogflow-cx/issues/141)) ([a79149b](https://www.github.com/googleapis/java-dialogflow-cx/commit/a79149b73f3c74b7d35ec230702fc9f61c2ede3b))
* Support transition route group coverage for Test Cases ([a79149b](https://www.github.com/googleapis/java-dialogflow-cx/commit/a79149b73f3c74b7d35ec230702fc9f61c2ede3b))
* supports SentimentAnalysisResult in webhook request ([a79149b](https://www.github.com/googleapis/java-dialogflow-cx/commit/a79149b73f3c74b7d35ec230702fc9f61c2ede3b))


### Bug Fixes

* don't log downloads ([#143](https://www.github.com/googleapis/java-dialogflow-cx/issues/143)) ([7cfb674](https://www.github.com/googleapis/java-dialogflow-cx/commit/7cfb6749ede7e7b01d606e83b6ac414466d23378))
* RunTestCase http template. PHP REST client lib can be generated ([a79149b](https://www.github.com/googleapis/java-dialogflow-cx/commit/a79149b73f3c74b7d35ec230702fc9f61c2ede3b))
* update repo name ([#138](https://www.github.com/googleapis/java-dialogflow-cx/issues/138)) ([5a6c5d1](https://www.github.com/googleapis/java-dialogflow-cx/commit/5a6c5d127d298c4d3acd5fdf13839c17b9f64d08))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.19.0 ([#127](https://www.github.com/googleapis/java-dialogflow-cx/issues/127)) ([0452e5c](https://www.github.com/googleapis/java-dialogflow-cx/commit/0452e5cc405d1fadf4d76f20d92db79375da7cd6))


### Documentation

* fix languages link ([#146](https://www.github.com/googleapis/java-dialogflow-cx/issues/146)) ([89f5b49](https://www.github.com/googleapis/java-dialogflow-cx/commit/89f5b49f8b973f626dbe76286b6cf8273d447837))
* generate sample code in the Java microgenerator ([a79149b](https://www.github.com/googleapis/java-dialogflow-cx/commit/a79149b73f3c74b7d35ec230702fc9f61c2ede3b))
* minor doc update on redact field in intent.proto and page.proto ([a79149b](https://www.github.com/googleapis/java-dialogflow-cx/commit/a79149b73f3c74b7d35ec230702fc9f61c2ede3b))
* minor updates in wording ([a79149b](https://www.github.com/googleapis/java-dialogflow-cx/commit/a79149b73f3c74b7d35ec230702fc9f61c2ede3b))
* test cases doc update ([a79149b](https://www.github.com/googleapis/java-dialogflow-cx/commit/a79149b73f3c74b7d35ec230702fc9f61c2ede3b))

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
