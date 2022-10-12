# Changelog

## [2.8.0](https://github.com/googleapis/google-cloud-java/compare/google-cloud-document-ai-v2.7.4...google-cloud-document-ai-v2.8.0) (2022-10-12)


### Features

* [analyticsdata] add `subject_to_thresholding` field to `ResponseMetadata` type ([#8545](https://github.com/googleapis/google-cloud-java/issues/8545)) ([8fdc6c1](https://github.com/googleapis/google-cloud-java/commit/8fdc6c1f10f88f30f4d1407579d645f75366b4cf))
* add `tokens_per_project_per_hour` field to `PropertyQuota` type ([8fdc6c1](https://github.com/googleapis/google-cloud-java/commit/8fdc6c1f10f88f30f4d1407579d645f75366b4cf))
* create release please configuration ([41b97e6](https://github.com/googleapis/google-cloud-java/commit/41b97e6d0d38a54fbabf51a3069bf1473c48f730))


### Bug Fixes

* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.2 ([#8325](https://github.com/googleapis/google-cloud-java/issues/8325)) ([01f492b](https://github.com/googleapis/google-cloud-java/commit/01f492be424acdb90edb23ba66656aeff7cf39eb))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.4 ([#8528](https://github.com/googleapis/google-cloud-java/issues/8528)) ([bd36199](https://github.com/googleapis/google-cloud-java/commit/bd361998ac4eb7c78eef3b3eac39aef31a0cf44e))
* **deps:** update dependency com.google.cloud:libraries-bom to v26.1.1 ([#8254](https://github.com/googleapis/google-cloud-java/issues/8254)) ([e4760da](https://github.com/googleapis/google-cloud-java/commit/e4760da4ac8fa6fa91bc82b90b83d0518eca2692))
* owl-bot-staging should not be commited ([#8337](https://github.com/googleapis/google-cloud-java/issues/8337)) ([c9bb4a9](https://github.com/googleapis/google-cloud-java/commit/c9bb4a97aa19032b78c86c951fe9920f24ac4eec))


### Dependencies

* reverting renovate bot pull requests ([#8417](https://github.com/googleapis/google-cloud-java/issues/8417)) ([8f0c60b](https://github.com/googleapis/google-cloud-java/commit/8f0c60bde446acccc665eb7894723632eefc3503))

## [2.7.3](https://github.com/googleapis/java-document-ai/compare/v2.7.2...v2.7.3) (2022-09-27)


### Dependencies

* Update dependency jinja2 to v3.1.2 ([#899](https://github.com/googleapis/java-document-ai/issues/899)) ([f8c9a65](https://github.com/googleapis/java-document-ai/commit/f8c9a65e8aab4b9839a7b6d958ffe6e4e0719ff9))
* Update dependency keyring to v23.9.3 ([#900](https://github.com/googleapis/java-document-ai/issues/900)) ([605daeb](https://github.com/googleapis/java-document-ai/commit/605daeb59de6d963ecbe8bb31d908d576ac2a2fd))
* Update dependency markupsafe to v2.1.1 ([#897](https://github.com/googleapis/java-document-ai/issues/897)) ([de3ce6e](https://github.com/googleapis/java-document-ai/commit/de3ce6e6a18ebc81adc6a89063afc645a34aa1ee))
* Update dependency protobuf to v3.20.2 ([#898](https://github.com/googleapis/java-document-ai/issues/898)) ([e1ee0d3](https://github.com/googleapis/java-document-ai/commit/e1ee0d360183c50c7b7d0bcccdff2f41cabcf223))
* Update dependency pyjwt to v2.5.0 ([#901](https://github.com/googleapis/java-document-ai/issues/901)) ([f22b07c](https://github.com/googleapis/java-document-ai/commit/f22b07c0eb75ad15946a1295dda293b477d3e060))
* Update dependency requests to v2.28.1 ([#902](https://github.com/googleapis/java-document-ai/issues/902)) ([b8e7a15](https://github.com/googleapis/java-document-ai/commit/b8e7a157c4df913822af8fda28b6dc523ee54329))

## [2.7.2](https://github.com/googleapis/java-document-ai/compare/v2.7.1...v2.7.2) (2022-09-20)


### Dependencies

* Update dependency com.google.api.grpc:grpc-google-common-protos to v2.9.3 ([#891](https://github.com/googleapis/java-document-ai/issues/891)) ([916c7f1](https://github.com/googleapis/java-document-ai/commit/916c7f17e98f32a5cdd0e89c747d778a005a16ba))

## [2.7.1](https://github.com/googleapis/java-document-ai/compare/v2.7.0...v2.7.1) (2022-09-20)


### Dependencies

* Update dependency com.google.cloud:google-cloud-storage to v2.12.0 ([#883](https://github.com/googleapis/java-document-ai/issues/883)) ([3a75167](https://github.com/googleapis/java-document-ai/commit/3a751672199a65ddc3784282bdc24d95d1608904))

## [2.7.0](https://github.com/googleapis/java-document-ai/compare/v2.6.2...v2.7.0) (2022-09-16)


### Features

* Added Barcode support ([a4a1ecf](https://github.com/googleapis/java-document-ai/commit/a4a1ecfd7f310358176dc506d76622a5ab33720f))
* Added corrected_key_text, correct_value_text to FormField object in document.proto ([a4a1ecf](https://github.com/googleapis/java-document-ai/commit/a4a1ecfd7f310358176dc506d76622a5ab33720f))
* Added field_mask to ProcessRequest object in document_processor_service.proto ([a4a1ecf](https://github.com/googleapis/java-document-ai/commit/a4a1ecfd7f310358176dc506d76622a5ab33720f))
* Added integer_values, float_values and non_present to Entity object in document.proto ([a4a1ecf](https://github.com/googleapis/java-document-ai/commit/a4a1ecfd7f310358176dc506d76622a5ab33720f))
* Added OperationMetadata resource ([a4a1ecf](https://github.com/googleapis/java-document-ai/commit/a4a1ecfd7f310358176dc506d76622a5ab33720f))
* Added parent_ids to Revision object in document.proto ([a4a1ecf](https://github.com/googleapis/java-document-ai/commit/a4a1ecfd7f310358176dc506d76622a5ab33720f))
* Added Processor Management and Processor Version support to v1 library ([a4a1ecf](https://github.com/googleapis/java-document-ai/commit/a4a1ecfd7f310358176dc506d76622a5ab33720f))


### Dependencies

* Update dependency com.google.api.grpc:grpc-google-common-protos to v2.9.2 ([#876](https://github.com/googleapis/java-document-ai/issues/876)) ([7a40a4d](https://github.com/googleapis/java-document-ai/commit/7a40a4d81bd0379b8ed144ebb07069636b25d7c1))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.2 ([#881](https://github.com/googleapis/java-document-ai/issues/881)) ([71c023d](https://github.com/googleapis/java-document-ai/commit/71c023d7ff69013069ef95f3aeb942b20d9c9a88))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.3 ([#882](https://github.com/googleapis/java-document-ai/issues/882)) ([4004115](https://github.com/googleapis/java-document-ai/commit/4004115df394709e94df62983fd460e4bd43691d))
* Update dependency com.google.cloud:google-cloud-storage to v2.11.3 ([#867](https://github.com/googleapis/java-document-ai/issues/867)) ([8f66f32](https://github.com/googleapis/java-document-ai/commit/8f66f32841bc8d57ef902a9348e2e64fa1b3c2d0))

## [2.6.2](https://github.com/googleapis/java-document-ai/compare/v2.6.1...v2.6.2) (2022-08-09)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v3 ([#859](https://github.com/googleapis/java-document-ai/issues/859)) ([9c0325c](https://github.com/googleapis/java-document-ai/commit/9c0325c5edf7ca70518606f8d6e69143c2667e90))
* update dependency com.google.cloud:google-cloud-storage to v2.10.0 ([#862](https://github.com/googleapis/java-document-ai/issues/862)) ([ba331c2](https://github.com/googleapis/java-document-ai/commit/ba331c2d2824135cad561c58ab01e37888ed73c7))
* update dependency com.google.cloud:google-cloud-storage to v2.11.0 ([#864](https://github.com/googleapis/java-document-ai/issues/864)) ([77f7588](https://github.com/googleapis/java-document-ai/commit/77f7588246b0429bab6208f68dc86143780b37e7))
* update dependency com.google.cloud:google-cloud-storage to v2.11.1 ([#865](https://github.com/googleapis/java-document-ai/issues/865)) ([79096be](https://github.com/googleapis/java-document-ai/commit/79096be7c7c99fb9cf727c8b5cce8a7b222e363e))
* update dependency com.google.cloud:google-cloud-storage to v2.11.2 ([#866](https://github.com/googleapis/java-document-ai/issues/866)) ([a4a2f75](https://github.com/googleapis/java-document-ai/commit/a4a2f75093929676dc21072445ce9a9b11b84ba7))

## [2.6.1](https://github.com/googleapis/java-document-ai/compare/v2.6.0...v2.6.1) (2022-07-13)


### Bug Fixes

* enable longpaths support for windows test ([#1485](https://github.com/googleapis/java-document-ai/issues/1485)) ([#853](https://github.com/googleapis/java-document-ai/issues/853)) ([e7d5234](https://github.com/googleapis/java-document-ai/commit/e7d523402aee6b997cee6786abedc529761b91fd))

## [2.6.0](https://github.com/googleapis/java-document-ai/compare/v2.5.2...v2.6.0) (2022-06-30)


### Features

* Enable REST transport for most of Java and Go clients ([#840](https://github.com/googleapis/java-document-ai/issues/840)) ([59f99a7](https://github.com/googleapis/java-document-ai/commit/59f99a7d47adc63811367dd1225cbbd3139bb430))


### Bug Fixes

* update gapic-generator-java with mock service generation fixes ([#846](https://github.com/googleapis/java-document-ai/issues/846)) ([7476317](https://github.com/googleapis/java-document-ai/commit/74763178e522484bc29aa1d82450de18dc56613c))

## [2.5.2](https://github.com/googleapis/java-document-ai/compare/v2.5.1...v2.5.2) (2022-06-23)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.13.0 ([#839](https://github.com/googleapis/java-document-ai/issues/839)) ([6ba683e](https://github.com/googleapis/java-document-ai/commit/6ba683ef5dcf4c2df608dc21661677b6f884ae6b))

## [2.5.1](https://github.com/googleapis/java-document-ai/compare/v2.5.0...v2.5.1) (2022-06-07)


### Dependencies

* update dependency com.google.cloud:google-cloud-storage to v2.7.0 ([#829](https://github.com/googleapis/java-document-ai/issues/829)) ([ecc3e38](https://github.com/googleapis/java-document-ai/commit/ecc3e38e0ab90c90bca5974cde20c54c53349423))

## [2.5.0](https://github.com/googleapis/java-document-ai/compare/v2.4.3...v2.5.0) (2022-05-19)


### Features

* add build scripts for native image testing in Java 17 ([#1440](https://github.com/googleapis/java-document-ai/issues/1440)) ([#825](https://github.com/googleapis/java-document-ai/issues/825)) ([382dc66](https://github.com/googleapis/java-document-ai/commit/382dc662e0604b8337a0c7cac3a3340184354dda))


### Bug Fixes

* mark Document.Entity.type as REQUIRED in all versions ([#817](https://github.com/googleapis/java-document-ai/issues/817)) ([eb329e5](https://github.com/googleapis/java-document-ai/commit/eb329e5414a68d518e34f705d7d680f34cba595f))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.12.0 ([#824](https://github.com/googleapis/java-document-ai/issues/824)) ([dfd5bd6](https://github.com/googleapis/java-document-ai/commit/dfd5bd688b8ed73e3cefc4684d1c75e3f6cab7fc))

### [2.4.3](https://github.com/googleapis/java-document-ai/compare/v2.4.2...v2.4.3) (2022-04-18)


### Dependencies

* update dependency com.google.cloud:google-cloud-storage to v2.6.1 ([#809](https://github.com/googleapis/java-document-ai/issues/809)) ([30525d7](https://github.com/googleapis/java-document-ai/commit/30525d709a51b6ec78ae58d54aa1cc289538f41d))

### [2.4.2](https://github.com/googleapis/java-document-ai/compare/v2.4.1...v2.4.2) (2022-04-15)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.10.0 ([#805](https://github.com/googleapis/java-document-ai/issues/805)) ([7496b00](https://github.com/googleapis/java-document-ai/commit/7496b002917e4566f1fe638071f4d521ea067288))

### [2.4.1](https://github.com/googleapis/java-document-ai/compare/v2.4.0...v2.4.1) (2022-04-01)


### Dependencies

* update dependency com.google.cloud:google-cloud-storage to v2.6.0 ([#797](https://github.com/googleapis/java-document-ai/issues/797)) ([0e9075d](https://github.com/googleapis/java-document-ai/commit/0e9075db567c47e8109b9fe4b435e2db6212cda2))

## [2.4.0](https://github.com/googleapis/java-document-ai/compare/v2.3.1...v2.4.0) (2022-03-29)


### Features

* add `content` field in TextAnchor ([#787](https://github.com/googleapis/java-document-ai/issues/787)) ([a0b46b5](https://github.com/googleapis/java-document-ai/commit/a0b46b5b81e45fe7908e3f8487582e85fddb3dab))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.9.0 ([#794](https://github.com/googleapis/java-document-ai/issues/794)) ([7388098](https://github.com/googleapis/java-document-ai/commit/7388098207f7be76fff2bc9c2900e57eb65e7dfb))
* update dependency com.google.cloud:google-cloud-storage to v2.5.1 ([#792](https://github.com/googleapis/java-document-ai/issues/792)) ([8b1c13a](https://github.com/googleapis/java-document-ai/commit/8b1c13a091276a8e095006de66697c1532a9f4c5))

### [2.3.1](https://github.com/googleapis/java-document-ai/compare/v2.3.0...v2.3.1) (2022-03-09)


### Dependencies

* update dependency com.google.cloud:google-cloud-storage to v2.4.5 ([#782](https://github.com/googleapis/java-document-ai/issues/782)) ([e89bb8f](https://github.com/googleapis/java-document-ai/commit/e89bb8f518a7b5642e1a70bf397c3ae6cfd4581e))

## [2.3.0](https://github.com/googleapis/java-document-ai/compare/v2.2.1...v2.3.0) (2022-03-03)


### Features

* add `symbols` field, and auto-format comments ([54057f6](https://github.com/googleapis/java-document-ai/commit/54057f6d1b14decb1a3b3db8a85e9d6355e2fb4a))
* add `symbols` field, and auto-format comments ([#762](https://github.com/googleapis/java-document-ai/issues/762)) ([54057f6](https://github.com/googleapis/java-document-ai/commit/54057f6d1b14decb1a3b3db8a85e9d6355e2fb4a))
* add question_id field in ReviewDocumentOperationMetadata ([#742](https://github.com/googleapis/java-document-ai/issues/742)) ([388a704](https://github.com/googleapis/java-document-ai/commit/388a704282d7854b38143b2692b90893da040fb8))


### Dependencies

* update actions/github-script action to v6 ([#757](https://github.com/googleapis/java-document-ai/issues/757)) ([3ce8bd6](https://github.com/googleapis/java-document-ai/commit/3ce8bd611e1a6b1000151ac6ce384e57e5f4e34c))
* update actions/setup-java action to v3 ([#767](https://github.com/googleapis/java-document-ai/issues/767)) ([eb6897d](https://github.com/googleapis/java-document-ai/commit/eb6897d0702a79f83c008053d2d8b96611082fe5))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.8.0 ([#773](https://github.com/googleapis/java-document-ai/issues/773)) ([12ce269](https://github.com/googleapis/java-document-ai/commit/12ce269360b478c7777f1282f89ec84a1da5577e))
* update dependency com.google.cloud:google-cloud-storage to v2.4.1 ([#755](https://github.com/googleapis/java-document-ai/issues/755)) ([b76f1c8](https://github.com/googleapis/java-document-ai/commit/b76f1c82d62d1c847669cd759d7ae70b7b6368d6))
* update dependency com.google.cloud:google-cloud-storage to v2.4.2 ([#759](https://github.com/googleapis/java-document-ai/issues/759)) ([e6f6d26](https://github.com/googleapis/java-document-ai/commit/e6f6d26e3cbf7bc4e33a18642a91900355990465))
* update dependency com.google.cloud:google-cloud-storage to v2.4.4 ([#770](https://github.com/googleapis/java-document-ai/issues/770)) ([de6eb16](https://github.com/googleapis/java-document-ai/commit/de6eb1678c098aefc0278e8b8ac800ef43124984))

### [2.2.1](https://github.com/googleapis/java-document-ai/compare/v2.2.0...v2.2.1) (2022-02-08)


### Dependencies

* update dependency com.google.cloud:google-cloud-storage to v2.4.0 ([#745](https://github.com/googleapis/java-document-ai/issues/745)) ([6f8eb8c](https://github.com/googleapis/java-document-ai/commit/6f8eb8c672440e1ab22a5d24ade3894d3bb20c17))

## [2.2.0](https://github.com/googleapis/java-document-ai/compare/v2.1.9...v2.2.0) (2022-02-03)


### Features

* add question_id field in ReviewDocumentOperationMetadata ([#739](https://github.com/googleapis/java-document-ai/issues/739)) ([a6c1b4a](https://github.com/googleapis/java-document-ai/commit/a6c1b4a869981c62843707ce6afb4bb30858790b))


### Dependencies

* **java:** update actions/github-script action to v5 ([#1339](https://github.com/googleapis/java-document-ai/issues/1339)) ([#737](https://github.com/googleapis/java-document-ai/issues/737)) ([2733ea0](https://github.com/googleapis/java-document-ai/commit/2733ea09d73ba3f1594e651919590b58e917704c))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.7.0 ([#740](https://github.com/googleapis/java-document-ai/issues/740)) ([f06e5de](https://github.com/googleapis/java-document-ai/commit/f06e5de507f88352b0ee9abc032319a875f806f9))
* update dependency com.google.cloud:google-cloud-storage to v2.2.3 ([#724](https://github.com/googleapis/java-document-ai/issues/724)) ([db706f8](https://github.com/googleapis/java-document-ai/commit/db706f86fb612c05fd60d17f0338accabd7d1a8d))
* update dependency com.google.cloud:google-cloud-storage to v2.3.0 ([#735](https://github.com/googleapis/java-document-ai/issues/735)) ([fb069e0](https://github.com/googleapis/java-document-ai/commit/fb069e032a08874d434c5a77ab74d7f03318e8e1))

### [2.1.9](https://www.github.com/googleapis/java-document-ai/compare/v2.1.8...v2.1.9) (2022-01-07)


### Bug Fixes

* **java:** add -ntp flag to native image testing command ([#1299](https://www.github.com/googleapis/java-document-ai/issues/1299)) ([#694](https://www.github.com/googleapis/java-document-ai/issues/694)) ([cc0972c](https://www.github.com/googleapis/java-document-ai/commit/cc0972c4a7c98af1658306022535b7cf399cf2c0))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.6.0 ([#720](https://www.github.com/googleapis/java-document-ai/issues/720)) ([90fe12f](https://www.github.com/googleapis/java-document-ai/commit/90fe12f3134311a95b55189a546f9e5e02181c27))
* update dependency com.google.cloud:google-cloud-storage to v2.2.2 ([#696](https://www.github.com/googleapis/java-document-ai/issues/696)) ([077f1d2](https://www.github.com/googleapis/java-document-ai/commit/077f1d224b891bd03bb5c3f5e24c71d671c84787))

### [2.1.8](https://www.github.com/googleapis/java-document-ai/compare/v2.1.7...v2.1.8) (2021-12-03)


### Bug Fixes

* **java:** java 17 dependency arguments ([#1266](https://www.github.com/googleapis/java-document-ai/issues/1266)) ([#670](https://www.github.com/googleapis/java-document-ai/issues/670)) ([936bd04](https://www.github.com/googleapis/java-document-ai/commit/936bd045021e0f6b2eca06d666e691acf6a37dea))


### Documentation

* **samples:** add OCR, form, quality, splitter and specialized processing samples ([#680](https://www.github.com/googleapis/java-document-ai/issues/680)) ([77be893](https://www.github.com/googleapis/java-document-ai/commit/77be89316472c23b3110e612fe4bd785e483c662))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.5.0 ([#683](https://www.github.com/googleapis/java-document-ai/issues/683)) ([35535c7](https://www.github.com/googleapis/java-document-ai/commit/35535c7562065ca4549f29dc8b6129e15beb52ab))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.5.1 ([#691](https://www.github.com/googleapis/java-document-ai/issues/691)) ([9b3e0fa](https://www.github.com/googleapis/java-document-ai/commit/9b3e0fa5badfebc62992ad1eefda03ba47f64990))
* update dependency com.google.cloud:google-cloud-storage to v2.2.0 ([#673](https://www.github.com/googleapis/java-document-ai/issues/673)) ([d9268dd](https://www.github.com/googleapis/java-document-ai/commit/d9268dd3c05c1c202231f306f542b2a4a8442d40))
* update dependency com.google.cloud:google-cloud-storage to v2.2.1 ([#684](https://www.github.com/googleapis/java-document-ai/issues/684)) ([bc2543c](https://www.github.com/googleapis/java-document-ai/commit/bc2543c72fa608ce20528455a42441333b0c87f9))

### [2.1.7](https://www.github.com/googleapis/java-document-ai/compare/v2.1.6...v2.1.7) (2021-10-20)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.4.0 ([#665](https://www.github.com/googleapis/java-document-ai/issues/665)) ([4531a6d](https://www.github.com/googleapis/java-document-ai/commit/4531a6d456fadda0943921f76af059214ea66ce8))
* update dependency com.google.cloud:google-cloud-storage to v2.1.9 ([#664](https://www.github.com/googleapis/java-document-ai/issues/664)) ([9ccba2e](https://www.github.com/googleapis/java-document-ai/commit/9ccba2ee3a04785bca420c292c89ec6941a4b158))

### [2.1.6](https://www.github.com/googleapis/java-document-ai/compare/v2.1.5...v2.1.6) (2021-10-05)


### Dependencies

* update dependency com.google.cloud:google-cloud-storage to v2.1.7 ([#656](https://www.github.com/googleapis/java-document-ai/issues/656)) ([fc6ff9d](https://www.github.com/googleapis/java-document-ai/commit/fc6ff9d39fe15d93be3462013a3fb74f46ad92bd))

### [2.1.5](https://www.github.com/googleapis/java-document-ai/compare/v2.1.4...v2.1.5) (2021-09-29)


### Dependencies

* update dependency com.google.cloud:google-cloud-storage to v2.1.6 ([#645](https://www.github.com/googleapis/java-document-ai/issues/645)) ([949640a](https://www.github.com/googleapis/java-document-ai/commit/949640ac49604c3210963ad14cd7b14ef6620369))

### [2.1.4](https://www.github.com/googleapis/java-document-ai/compare/v2.1.3...v2.1.4) (2021-09-22)


### Dependencies

* update dependency com.google.cloud:google-cloud-storage to v2.1.5 ([#641](https://www.github.com/googleapis/java-document-ai/issues/641)) ([2a79bce](https://www.github.com/googleapis/java-document-ai/commit/2a79bce2645d3ad6083cae99ef0579028ef111c2))

### [2.1.3](https://www.github.com/googleapis/java-document-ai/compare/v2.1.2...v2.1.3) (2021-09-22)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.3.0 ([#639](https://www.github.com/googleapis/java-document-ai/issues/639)) ([d2b2eb9](https://www.github.com/googleapis/java-document-ai/commit/d2b2eb9637be2e446d0cc01e7881ec2abcd3eeef))
* update dependency com.google.cloud:google-cloud-storage to v2.1.3 ([#634](https://www.github.com/googleapis/java-document-ai/issues/634)) ([9056292](https://www.github.com/googleapis/java-document-ai/commit/90562922a99842b5cd7c60323acc7fd908d01742))
* update dependency com.google.cloud:google-cloud-storage to v2.1.4 ([#636](https://www.github.com/googleapis/java-document-ai/issues/636)) ([3b850cf](https://www.github.com/googleapis/java-document-ai/commit/3b850cfd9e85fd33ba551a29547a693ab48461d3))

### [2.1.2](https://www.github.com/googleapis/java-document-ai/compare/v2.1.1...v2.1.2) (2021-09-14)


### Dependencies

* update dependency com.google.cloud:google-cloud-storage to v2.1.2 ([#630](https://www.github.com/googleapis/java-document-ai/issues/630)) ([2b8520d](https://www.github.com/googleapis/java-document-ai/commit/2b8520d1273c1c97254fcbce65d15f28c0b38a25))

### [2.1.1](https://www.github.com/googleapis/java-document-ai/compare/v2.1.0...v2.1.1) (2021-09-14)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.2.1 ([#626](https://www.github.com/googleapis/java-document-ai/issues/626)) ([f21e420](https://www.github.com/googleapis/java-document-ai/commit/f21e420298562afd70310aad58f1d842e6ef4d96))
* update dependency com.google.cloud:google-cloud-storage to v2.1.1 ([#615](https://www.github.com/googleapis/java-document-ai/issues/615)) ([ae98d93](https://www.github.com/googleapis/java-document-ai/commit/ae98d9353da3e06b5d60ca3b573276e130f4595a))

## [2.1.0](https://www.github.com/googleapis/java-document-ai/compare/v2.0.3...v2.1.0) (2021-09-01)


### Features

* Remove use of deprecated gradle command in java README ([#1196](https://www.github.com/googleapis/java-document-ai/issues/1196)) ([#607](https://www.github.com/googleapis/java-document-ai/issues/607)) ([95cb397](https://www.github.com/googleapis/java-document-ai/commit/95cb397a9fd80014304cedb89bff56e4abe2fc80))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.2.0 ([#610](https://www.github.com/googleapis/java-document-ai/issues/610)) ([7c8037d](https://www.github.com/googleapis/java-document-ai/commit/7c8037d54d18fed262f2a19d5b5b2796a8f9862d))
* update dependency com.google.cloud:google-cloud-storage to v2.1.0 ([#603](https://www.github.com/googleapis/java-document-ai/issues/603)) ([dafaf0e](https://www.github.com/googleapis/java-document-ai/commit/dafaf0eb76783e3b3be24d461f697fc6441a0f88))

### [2.0.3](https://www.github.com/googleapis/java-document-ai/compare/v2.0.2...v2.0.3) (2021-08-24)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.1.0 ([#597](https://www.github.com/googleapis/java-document-ai/issues/597)) ([e23cfe7](https://www.github.com/googleapis/java-document-ai/commit/e23cfe7317ed6a31d56d8719ab20c1c6922da315))

### [2.0.2](https://www.github.com/googleapis/java-document-ai/compare/v2.0.1...v2.0.2) (2021-08-19)


### Dependencies

* update dependency com.google.cloud:google-cloud-storage to v2.0.2 ([#594](https://www.github.com/googleapis/java-document-ai/issues/594)) ([dc51e3b](https://www.github.com/googleapis/java-document-ai/commit/dc51e3bc16736c9bf2fbeb1595a2627c4d982fe2))

### [2.0.1](https://www.github.com/googleapis/java-document-ai/compare/v2.0.0...v2.0.1) (2021-08-12)


### Bug Fixes

* Update DocumentUnderstandingService default_host in v1beta2 from a regional endpoint, to non-regional ([#584](https://www.github.com/googleapis/java-document-ai/issues/584)) ([aeb841e](https://www.github.com/googleapis/java-document-ai/commit/aeb841e24c5934a3d4eafad54d2041ab4f8b1d5a))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.0.1 ([#583](https://www.github.com/googleapis/java-document-ai/issues/583)) ([116d929](https://www.github.com/googleapis/java-document-ai/commit/116d929277e1727ef6df9d373dfc4a1eb4661617))
* update dependency com.google.cloud:google-cloud-storage to v2.0.1 ([#585](https://www.github.com/googleapis/java-document-ai/issues/585)) ([fbb2f87](https://www.github.com/googleapis/java-document-ai/commit/fbb2f87252ac22e642ceb365b1eb5b2d03160fbe))

## [2.0.0](https://www.github.com/googleapis/java-document-ai/compare/v1.2.1...v2.0.0) (2021-08-09)


### ⚠ BREAKING CHANGES

* release gapic-generator-java v2.0.0 (#574)

### Features

* release gapic-generator-java v2.0.0 ([#574](https://www.github.com/googleapis/java-document-ai/issues/574)) ([c3418bd](https://www.github.com/googleapis/java-document-ai/commit/c3418bdbddfb99ff80c231500f031d95d4cd067c))


### Bug Fixes

* owlbot post-processor should generate README ([#1154](https://www.github.com/googleapis/java-document-ai/issues/1154)) ([#548](https://www.github.com/googleapis/java-document-ai/issues/548)) ([49bc6cf](https://www.github.com/googleapis/java-document-ai/commit/49bc6cfd1c1f734db488a7d3e5d2d2b9ab2c89d6)), closes [#1146](https://www.github.com/googleapis/java-document-ai/issues/1146) [#1147](https://www.github.com/googleapis/java-document-ai/issues/1147)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2 ([#575](https://www.github.com/googleapis/java-document-ai/issues/575)) ([c0866a0](https://www.github.com/googleapis/java-document-ai/commit/c0866a0caf3996f63de8f4e800da83373b4a9ebe))
* update dependency com.google.cloud:google-cloud-storage to v2 ([#579](https://www.github.com/googleapis/java-document-ai/issues/579)) ([b52532b](https://www.github.com/googleapis/java-document-ai/commit/b52532bc9f50792e2ee16eab6217f6d1051118f8))

### [1.2.1](https://www.github.com/googleapis/java-document-ai/compare/v1.2.0...v1.2.1) (2021-07-14)


### Dependencies

* update dependency com.google.cloud:google-cloud-storage to v1.118.0 ([#543](https://www.github.com/googleapis/java-document-ai/issues/543)) ([9fe6315](https://www.github.com/googleapis/java-document-ai/commit/9fe63150ad0e6ef800a9fef26d8029011663cad7))

## [1.2.0](https://www.github.com/googleapis/java-document-ai/compare/v1.1.1...v1.2.0) (2021-07-02)


### Features

* update document.proto, add the processor management methods ([#515](https://www.github.com/googleapis/java-document-ai/issues/515)) ([f2852ab](https://www.github.com/googleapis/java-document-ai/commit/f2852ab1fb233b12ea4015abbf172b75408ef95e))
* update ReviewDocumentRequest to allow set priority and enable validation ([#527](https://www.github.com/googleapis/java-document-ai/issues/527)) ([f69e920](https://www.github.com/googleapis/java-document-ai/commit/f69e920ffee1de9257691228f72a62c36b410701))


### Bug Fixes

* Add `shopt -s nullglob` to dependencies script ([#1130](https://www.github.com/googleapis/java-document-ai/issues/1130)) ([#526](https://www.github.com/googleapis/java-document-ai/issues/526)) ([363547c](https://www.github.com/googleapis/java-document-ai/commit/363547cf0a58068841f69f37ef1602bdf171fafb))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.4.0 ([#532](https://www.github.com/googleapis/java-document-ai/issues/532)) ([a6d9c6f](https://www.github.com/googleapis/java-document-ai/commit/a6d9c6f265ee03a60491fb1fd15f609785780509))
* update dependency com.google.cloud:google-cloud-storage to v1.117.1 ([#531](https://www.github.com/googleapis/java-document-ai/issues/531)) ([0d5b684](https://www.github.com/googleapis/java-document-ai/commit/0d5b684697c1a9f1a7226267083e0c7a342b7015))

### [1.1.1](https://www.github.com/googleapis/java-document-ai/compare/v1.1.0...v1.1.1) (2021-06-16)


### Dependencies

* update dependency com.google.cloud:google-cloud-storage to v1.116.0 ([#514](https://www.github.com/googleapis/java-document-ai/issues/514)) ([afba115](https://www.github.com/googleapis/java-document-ai/commit/afba115c7545b9b045e3d03f63c3a03f02ef8b31))

## [1.1.0](https://www.github.com/googleapis/java-document-ai/compare/v1.0.0...v1.1.0) (2021-06-15)


### Features

* Move CommonOperationMetadata into a separate proto file for potential reuse ([#502](https://www.github.com/googleapis/java-document-ai/issues/502)) ([aad8db8](https://www.github.com/googleapis/java-document-ai/commit/aad8db8c46e83ec2b488734432d1465711ac0429))
* Move CommonOperationMetadata into a separate proto file for potential reuse ([#505](https://www.github.com/googleapis/java-document-ai/issues/505)) ([481e545](https://www.github.com/googleapis/java-document-ai/commit/481e545d82d7bd292fbed3b90037df87984fcf5d))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.3.0 ([#503](https://www.github.com/googleapis/java-document-ai/issues/503)) ([07cef28](https://www.github.com/googleapis/java-document-ai/commit/07cef28d83cb87814579b37a98e765a342fe2dff))

## [1.0.0](https://www.github.com/googleapis/java-document-ai/compare/v0.8.2...v1.0.0) (2021-05-26)


### Features

* add `gcf-owl-bot[bot]` to `ignoreAuthors` ([#490](https://www.github.com/googleapis/java-document-ai/issues/490)) ([0f2808e](https://www.github.com/googleapis/java-document-ai/commit/0f2808e78337a196108907d19805c77a5278c6b1))
* release 1.0.0 ([#475](https://www.github.com/googleapis/java-document-ai/issues/475)) ([c4cb6ec](https://www.github.com/googleapis/java-document-ai/commit/c4cb6ec92f03a0c57b648780f9967c4affb9e74d))
* Use non-regionalized default host name for documentai.googleapis.com ([#476](https://www.github.com/googleapis/java-document-ai/issues/476)) ([8b0c212](https://www.github.com/googleapis/java-document-ai/commit/8b0c2129d2e827fa671ba939852bdfa33b0434a5))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.2.0 ([#489](https://www.github.com/googleapis/java-document-ai/issues/489)) ([fe100b0](https://www.github.com/googleapis/java-document-ai/commit/fe100b03943f74fb4b883c9d12af49acbe22bd24))

### [0.8.2](https://www.github.com/googleapis/java-document-ai/compare/v0.8.1...v0.8.2) (2021-05-13)


### Dependencies

* update dependency com.google.cloud:google-cloud-storage to v1.114.0 ([#478](https://www.github.com/googleapis/java-document-ai/issues/478)) ([abb2b92](https://www.github.com/googleapis/java-document-ai/commit/abb2b9228ed39e9cf126f98d3f99dccc69a0d6b1))

### [0.8.1](https://www.github.com/googleapis/java-document-ai/compare/v0.8.0...v0.8.1) (2021-05-11)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.1.0 ([#469](https://www.github.com/googleapis/java-document-ai/issues/469)) ([9a0de3c](https://www.github.com/googleapis/java-document-ai/commit/9a0de3c91e753bf7be699267ee803debc17aae4f))

## [0.8.0](https://www.github.com/googleapis/java-document-ai/compare/v0.7.1...v0.8.0) (2021-04-27)


### Features

* add confidence field to the PageAnchor.PageRef in document.proto ([#450](https://www.github.com/googleapis/java-document-ai/issues/450)) ([2843a9d](https://www.github.com/googleapis/java-document-ai/commit/2843a9dba1cf0aa13ecebc8b62687c9ea091079f))
* add confidence field to the PageAnchor.PageRef in document.proto ([#453](https://www.github.com/googleapis/java-document-ai/issues/453)) ([2d0772e](https://www.github.com/googleapis/java-document-ai/commit/2d0772e02bb2ffa2b45f026e121ac36f7b1590b9))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1 ([#452](https://www.github.com/googleapis/java-document-ai/issues/452)) ([952106e](https://www.github.com/googleapis/java-document-ai/commit/952106ebcfa227d552beeb84e3fe816223e899a0))
* update dependency com.google.cloud:google-cloud-storage to v1.113.16 ([#454](https://www.github.com/googleapis/java-document-ai/issues/454)) ([ce87c21](https://www.github.com/googleapis/java-document-ai/commit/ce87c2199576fc98ae252449556255f00f135290))

### [0.7.1](https://www.github.com/googleapis/java-document-ai/compare/v0.7.0...v0.7.1) (2021-04-20)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.21.1 ([#432](https://www.github.com/googleapis/java-document-ai/issues/432)) ([25a8693](https://www.github.com/googleapis/java-document-ai/commit/25a869361ed302ffc741285cb43bd8b7206761ba))

## [0.7.0](https://www.github.com/googleapis/java-document-ai/compare/v0.6.0...v0.7.0) (2021-04-19)


### Features

* generate v1 client ([#421](https://www.github.com/googleapis/java-document-ai/issues/421)) ([01ce144](https://www.github.com/googleapis/java-document-ai/commit/01ce1447e11739371d24e76ef671f925f81d9cc0))


### Bug Fixes

* typo ([#414](https://www.github.com/googleapis/java-document-ai/issues/414)) ([eb7deac](https://www.github.com/googleapis/java-document-ai/commit/eb7deac0853ab31fcb4f21bf488a05e999c04a9b))


### Dependencies

* update dependency com.google.cloud:google-cloud-storage to v1.113.15 ([#416](https://www.github.com/googleapis/java-document-ai/issues/416)) ([70f4511](https://www.github.com/googleapis/java-document-ai/commit/70f45114f95861dc422df6f7e1e998938c784265))

## [0.6.0](https://www.github.com/googleapis/java-document-ai/compare/v0.5.0...v0.6.0) (2021-04-12)


### Features

* add EVAL_SKIPPED value to the Provenance.OperationType enum in document.proto ([#390](https://www.github.com/googleapis/java-document-ai/issues/390)) ([62f71cb](https://www.github.com/googleapis/java-document-ai/commit/62f71cb332a111a86f6147bbec6305fd198b8fca))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.21.0 ([#406](https://www.github.com/googleapis/java-document-ai/issues/406)) ([0e6ed58](https://www.github.com/googleapis/java-document-ai/commit/0e6ed58ede9331c27a8e6bd509334e223b499660))

## [0.5.0](https://www.github.com/googleapis/java-document-ai/compare/v0.4.1...v0.5.0) (2021-03-15)


### ⚠ BREAKING CHANGES

* remove the translation fields in document.proto

### Features

* **generator:** update protoc to v3.15.3 ([#372](https://www.github.com/googleapis/java-document-ai/issues/372)) ([e98fa5a](https://www.github.com/googleapis/java-document-ai/commit/e98fa5a945dfbe41fc9ba52723986dcb2fe66b3e))
* remove the translation fields in document.proto ([#382](https://www.github.com/googleapis/java-document-ai/issues/382)) ([06270f7](https://www.github.com/googleapis/java-document-ai/commit/06270f7b6a8e5e25f776236ee680a096bb842451))
* Update documentai/v1beta3 protos: add support for boolean normalized value ([#358](https://www.github.com/googleapis/java-document-ai/issues/358)) ([2f341a1](https://www.github.com/googleapis/java-document-ai/commit/2f341a10d41f10a35f19eed20c7c6aa891f0569f))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.20.1 ([#383](https://www.github.com/googleapis/java-document-ai/issues/383)) ([b074e0b](https://www.github.com/googleapis/java-document-ai/commit/b074e0b4bf48b6b140cfe30158fde6a5a2ab1dfc))
* update dependency com.google.cloud:google-cloud-storage to v1.113.14 ([#369](https://www.github.com/googleapis/java-document-ai/issues/369)) ([136d117](https://www.github.com/googleapis/java-document-ai/commit/136d1178d13f3a2bd3f93be6106a97f04aa7bcae))

### [0.4.1](https://www.github.com/googleapis/java-document-ai/compare/v0.4.0...v0.4.1) (2021-02-26)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.20.0 ([#365](https://www.github.com/googleapis/java-document-ai/issues/365)) ([f9c5ac7](https://www.github.com/googleapis/java-document-ai/commit/f9c5ac7e904f0fba47fbdf21556aeced5b2478f5))
* update dependency com.google.cloud:google-cloud-storage to v1.113.11 ([#357](https://www.github.com/googleapis/java-document-ai/issues/357)) ([6db90c7](https://www.github.com/googleapis/java-document-ai/commit/6db90c7fbf3b2aca39c050f39043393522fd4b31))

## [0.4.0](https://www.github.com/googleapis/java-document-ai/compare/v0.3.9...v0.4.0) (2021-02-23)


### Features

* Update documentai/v1beta3 protos ([#351](https://www.github.com/googleapis/java-document-ai/issues/351)) ([c752c99](https://www.github.com/googleapis/java-document-ai/commit/c752c99233a04bbc56c739b64a7b6cfd857e7932))


### Documentation

* generate sample code in the Java microgenerator ([#338](https://www.github.com/googleapis/java-document-ai/issues/338)) ([33a1eda](https://www.github.com/googleapis/java-document-ai/commit/33a1eda531d6c5d71a49976fa31bbaf0754cf83a))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.19.0 ([#354](https://www.github.com/googleapis/java-document-ai/issues/354)) ([b5cc196](https://www.github.com/googleapis/java-document-ai/commit/b5cc196ebd9b3fb4c7a2935b4adde9eb111eb140))
* update dependency com.google.cloud:google-cloud-storage to v1.113.10 ([#350](https://www.github.com/googleapis/java-document-ai/issues/350)) ([83c52c9](https://www.github.com/googleapis/java-document-ai/commit/83c52c9dbd63690e3e98d261a4660aa1040b51f0))

### [0.3.9](https://www.github.com/googleapis/java-document-ai/compare/v0.3.8...v0.3.9) (2021-01-14)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.18.0 ([#317](https://www.github.com/googleapis/java-document-ai/issues/317)) ([cf0c350](https://www.github.com/googleapis/java-document-ai/commit/cf0c350d8f625f8e5b6bee055901c017e621fe08))
* update dependency com.google.cloud:google-cloud-storage to v1.113.9 ([#318](https://www.github.com/googleapis/java-document-ai/issues/318)) ([e8c12b1](https://www.github.com/googleapis/java-document-ai/commit/e8c12b112e569aa0f124bc8572d9a38be084e7ef))

### [0.3.8](https://www.github.com/googleapis/java-document-ai/compare/v0.3.7...v0.3.8) (2021-01-07)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.17.0 ([#300](https://www.github.com/googleapis/java-document-ai/issues/300)) ([7f96dc5](https://www.github.com/googleapis/java-document-ai/commit/7f96dc5a4b730ef7e8ed3e9010c4b6a1a15bbea0))
* update dependency com.google.cloud:google-cloud-storage to v1.113.8 ([#293](https://www.github.com/googleapis/java-document-ai/issues/293)) ([142c1cc](https://www.github.com/googleapis/java-document-ai/commit/142c1cce826257d4aa05d703ee0fdf72dd0130e2))

### [0.3.7](https://www.github.com/googleapis/java-document-ai/compare/v0.3.6...v0.3.7) (2020-12-14)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.16.1 ([#295](https://www.github.com/googleapis/java-document-ai/issues/295)) ([7564e4d](https://www.github.com/googleapis/java-document-ai/commit/7564e4db794ca7d9fdac0b32fdb2669c87b47621))

### [0.3.6](https://www.github.com/googleapis/java-document-ai/compare/v0.3.5...v0.3.6) (2020-12-08)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.16.0 ([#283](https://www.github.com/googleapis/java-document-ai/issues/283)) ([590fe47](https://www.github.com/googleapis/java-document-ai/commit/590fe47a98d7cdd12e4819a0942ab807b94332df))

### [0.3.5](https://www.github.com/googleapis/java-document-ai/compare/v0.3.4...v0.3.5) (2020-11-12)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.15.0 ([#265](https://www.github.com/googleapis/java-document-ai/issues/265)) ([eef0fb3](https://www.github.com/googleapis/java-document-ai/commit/eef0fb3931787a20874e77ee67989cddc60b01d6))

### [0.3.4](https://www.github.com/googleapis/java-document-ai/compare/v0.3.3...v0.3.4) (2020-10-31)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.14.1 ([#254](https://www.github.com/googleapis/java-document-ai/issues/254)) ([8dcaf43](https://www.github.com/googleapis/java-document-ai/commit/8dcaf43757667ad314b9f6ce9c67d12b9349934c))

### [0.3.3](https://www.github.com/googleapis/java-document-ai/compare/v0.3.2...v0.3.3) (2020-10-28)


### Dependencies

* update dependency com.google.cloud:google-cloud-storage to v1.113.2 ([#240](https://www.github.com/googleapis/java-document-ai/issues/240)) ([f9fa723](https://www.github.com/googleapis/java-document-ai/commit/f9fa7232e9892835771a86ff83525320ea25d04b))

### [0.3.2](https://www.github.com/googleapis/java-document-ai/compare/v0.3.1...v0.3.2) (2020-10-22)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.12.1 ([#223](https://www.github.com/googleapis/java-document-ai/issues/223)) ([90916aa](https://www.github.com/googleapis/java-document-ai/commit/90916aad15493ce83fd5427f632a756c55213652))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.13.0 ([#227](https://www.github.com/googleapis/java-document-ai/issues/227)) ([a3d8605](https://www.github.com/googleapis/java-document-ai/commit/a3d860512fc9a35737acd939d06518fbf7fd893b))

### [0.3.1](https://www.github.com/googleapis/java-document-ai/compare/v0.3.0...v0.3.1) (2020-10-08)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.10.2 ([#203](https://www.github.com/googleapis/java-document-ai/issues/203)) ([053d920](https://www.github.com/googleapis/java-document-ai/commit/053d920b3863f5cf0a7010e1a73edb226c3dbd55))

## [0.3.0](https://www.github.com/googleapis/java-document-ai/compare/v0.2.4...v0.3.0) (2020-10-01)


### Features

* **v1beta3:** add v1beta3 client ([#191](https://www.github.com/googleapis/java-document-ai/issues/191)) ([7e11d08](https://www.github.com/googleapis/java-document-ai/commit/7e11d08315b73995476bde0a273f2df6cbccc2a4))

### [0.2.4](https://www.github.com/googleapis/java-document-ai/compare/v0.2.3...v0.2.4) (2020-09-23)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.10.0 ([#183](https://www.github.com/googleapis/java-document-ai/issues/183)) ([aca62ea](https://www.github.com/googleapis/java-document-ai/commit/aca62ea8ae229b77f8a7ebc96dba95c1ca7a047b))

### [0.2.3](https://www.github.com/googleapis/java-document-ai/compare/v0.2.2...v0.2.3) (2020-09-23)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.9.0 ([#165](https://www.github.com/googleapis/java-document-ai/issues/165)) ([884df24](https://www.github.com/googleapis/java-document-ai/commit/884df24ab6b1c719b1fb51aa995e4494c7d62cb1))

### [0.2.2](https://www.github.com/googleapis/java-document-ai/compare/v0.2.1...v0.2.2) (2020-08-19)


### Dependencies

* update dependency com.google.cloud:google-cloud-storage to v1.111.2 ([#128](https://www.github.com/googleapis/java-document-ai/issues/128)) ([a15a878](https://www.github.com/googleapis/java-document-ai/commit/a15a8780003b9f48d30f8585e5ac3fd9c8b1adb7))

### [0.2.1](https://www.github.com/googleapis/java-document-ai/compare/v0.2.0...v0.2.1) (2020-08-07)


### Bug Fixes

* update generated retry settings ([#136](https://www.github.com/googleapis/java-document-ai/issues/136)) ([af46f54](https://www.github.com/googleapis/java-document-ai/commit/af46f54f08047a59abe9b8b8b612acca55a429bf))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.2 ([#132](https://www.github.com/googleapis/java-document-ai/issues/132)) ([9b8ccdf](https://www.github.com/googleapis/java-document-ai/commit/9b8ccdfb5617f2a5fd8414e05770978a3fda7294))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.6 ([#137](https://www.github.com/googleapis/java-document-ai/issues/137)) ([e9e3bea](https://www.github.com/googleapis/java-document-ai/commit/e9e3bea39642fbdd13711b34075444594b259b4c))

## [0.2.0](https://www.github.com/googleapis/java-document-ai/compare/v0.1.1...v0.2.0) (2020-06-22)


### Features

* **deps:** adopt flatten plugin and google-cloud-shared-dependencies ([#116](https://www.github.com/googleapis/java-document-ai/issues/116)) ([5b68436](https://www.github.com/googleapis/java-document-ai/commit/5b6843626d22d623060fe2966da3e73463892e5d))


### Bug Fixes

* migrate to grpc_service_config ([#108](https://www.github.com/googleapis/java-document-ai/issues/108)) ([62a5b68](https://www.github.com/googleapis/java-document-ai/commit/62a5b68415ab93fcf64f3755b693c131dd2163f8))


### Dependencies

* update dependency com.google.api:api-common to v1.9.1 ([#89](https://www.github.com/googleapis/java-document-ai/issues/89)) ([94b2454](https://www.github.com/googleapis/java-document-ai/commit/94b245487d05f32ef653c71210f66e9dd8e768b5))
* update dependency com.google.api:api-common to v1.9.2 ([#96](https://www.github.com/googleapis/java-document-ai/issues/96)) ([c77ba1b](https://www.github.com/googleapis/java-document-ai/commit/c77ba1b70e0906a804e9e4666352e9d23f9a1a8b))
* update dependency com.google.api.grpc:proto-google-common-protos to v1.18.0 ([#79](https://www.github.com/googleapis/java-document-ai/issues/79)) ([136c2bb](https://www.github.com/googleapis/java-document-ai/commit/136c2bb5521d1a0fb1ac36dad3ce82a930b898c4))
* update dependency com.google.cloud:google-cloud-storage to v1.108.0 ([#78](https://www.github.com/googleapis/java-document-ai/issues/78)) ([1f9374a](https://www.github.com/googleapis/java-document-ai/commit/1f9374aca432606956062159fbfb070349fa62fa))
* update dependency com.google.guava:guava-bom to v29 ([#54](https://www.github.com/googleapis/java-document-ai/issues/54)) ([f21f5ba](https://www.github.com/googleapis/java-document-ai/commit/f21f5bae14da60379c4daa8860e7d4065d882b9c))
* update dependency com.google.protobuf:protobuf-java to v3.12.0 ([#83](https://www.github.com/googleapis/java-document-ai/issues/83)) ([8be44d3](https://www.github.com/googleapis/java-document-ai/commit/8be44d3c5063a780b18d3eeb17563b78337d98b0))
* update dependency com.google.protobuf:protobuf-java to v3.12.2 ([#87](https://www.github.com/googleapis/java-document-ai/issues/87)) ([09c04e8](https://www.github.com/googleapis/java-document-ai/commit/09c04e895ccd6e871e7dacce6c98a74a5beb7b37))
* update dependency io.grpc:grpc-bom to v1.29.0 ([#69](https://www.github.com/googleapis/java-document-ai/issues/69)) ([348123e](https://www.github.com/googleapis/java-document-ai/commit/348123e0ed1db3b9a16143ecd6cb6bcfeeadbfb9))
* update dependency io.grpc:grpc-bom to v1.30.0 ([#101](https://www.github.com/googleapis/java-document-ai/issues/101)) ([6a17dd4](https://www.github.com/googleapis/java-document-ai/commit/6a17dd48d62e7a96ff3cf4cdc983e9f982b1800b))
* update dependency org.threeten:threetenbp to v1.4.4 ([#71](https://www.github.com/googleapis/java-document-ai/issues/71)) ([cb7f0a6](https://www.github.com/googleapis/java-document-ai/commit/cb7f0a64fe7e90210a85832b659d56e0410e756b))

### [0.1.1](https://www.github.com/googleapis/java-document-ai/compare/v0.1.0...v0.1.1) (2020-04-07)


### Bug Fixes

* **v1beta2:** set default endpoint to us-documentai.googleapis.com ([#44](https://www.github.com/googleapis/java-document-ai/issues/44)) ([1b928a1](https://www.github.com/googleapis/java-document-ai/commit/1b928a1de50f8a8ba141d4c8492cfeda7a3b6c80))


### Dependencies

* update core dependencies ([#10](https://www.github.com/googleapis/java-document-ai/issues/10)) ([aa252ef](https://www.github.com/googleapis/java-document-ai/commit/aa252ef3b3aa3bab3fb99224ac0e4e70d8167266))
* update dependency com.google.api:api-common to v1.9.0 ([#37](https://www.github.com/googleapis/java-document-ai/issues/37)) ([ec3b6cc](https://www.github.com/googleapis/java-document-ai/commit/ec3b6cc5f7b424350d3e79ed478a2a4e7d537124))
* update dependency org.threeten:threetenbp to v1.4.3 ([#29](https://www.github.com/googleapis/java-document-ai/issues/29)) ([ec57073](https://www.github.com/googleapis/java-document-ai/commit/ec5707332800e82aef0735b17451a7c555e4fa92))

## 0.1.0 (2020-03-16)


### Features

* initial generation ([6a2e2ff](https://www.github.com/googleapis/java-document-ai/commit/6a2e2ffb008b0e461ad3ffab48a3536127ae9252))
* **v1beta2:** generate v1beta2 client ([#9](https://www.github.com/googleapis/java-document-ai/issues/9)) ([d3cecae](https://www.github.com/googleapis/java-document-ai/commit/d3cecae0b6c221e17a5c7d40081ffa82d6b21d90))
