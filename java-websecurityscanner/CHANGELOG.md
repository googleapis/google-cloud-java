# Changelog

## [2.4.0](https://github.com/googleapis/google-cloud-java/compare/google-cloud-websecurityscanner-v2.3.0...google-cloud-websecurityscanner-v2.4.0) (2022-10-10)


### Features

* [analyticsdata] add `subject_to_thresholding` field to `ResponseMetadata` type ([#8545](https://github.com/googleapis/google-cloud-java/issues/8545)) ([8fdc6c1](https://github.com/googleapis/google-cloud-java/commit/8fdc6c1f10f88f30f4d1407579d645f75366b4cf))
* [websecurityscanner] added NO_STARTING_URL_FOUND_FOR_MANAGED_SCAN to ScanRunWarningTrace.Code ([#8306](https://github.com/googleapis/google-cloud-java/issues/8306)) ([94651cd](https://github.com/googleapis/google-cloud-java/commit/94651cdf2d3bd2936e51444baa2beb40d7094bbe))
* add `tokens_per_project_per_hour` field to `PropertyQuota` type ([8fdc6c1](https://github.com/googleapis/google-cloud-java/commit/8fdc6c1f10f88f30f4d1407579d645f75366b4cf))
* create release please configuration ([41b97e6](https://github.com/googleapis/google-cloud-java/commit/41b97e6d0d38a54fbabf51a3069bf1473c48f730))


### Bug Fixes

* Added fix to return a list of the endpoints that encountered errors during crawl, along with the specific error message when the starting URL returns Http errors ([94651cd](https://github.com/googleapis/google-cloud-java/commit/94651cdf2d3bd2936e51444baa2beb40d7094bbe))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.2 ([#8325](https://github.com/googleapis/google-cloud-java/issues/8325)) ([01f492b](https://github.com/googleapis/google-cloud-java/commit/01f492be424acdb90edb23ba66656aeff7cf39eb))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.4 ([#8528](https://github.com/googleapis/google-cloud-java/issues/8528)) ([bd36199](https://github.com/googleapis/google-cloud-java/commit/bd361998ac4eb7c78eef3b3eac39aef31a0cf44e))
* **deps:** update dependency com.google.cloud:libraries-bom to v26.1.1 ([#8254](https://github.com/googleapis/google-cloud-java/issues/8254)) ([e4760da](https://github.com/googleapis/google-cloud-java/commit/e4760da4ac8fa6fa91bc82b90b83d0518eca2692))
* GoogleAccount is deprecated ([94651cd](https://github.com/googleapis/google-cloud-java/commit/94651cdf2d3bd2936e51444baa2beb40d7094bbe))
* owl-bot-staging should not be commited ([#8337](https://github.com/googleapis/google-cloud-java/issues/8337)) ([c9bb4a9](https://github.com/googleapis/google-cloud-java/commit/c9bb4a97aa19032b78c86c951fe9920f24ac4eec))


### Documentation

* [websecurityscanner] Publish Scan Run logging proto for documentation ([#8245](https://github.com/googleapis/google-cloud-java/issues/8245)) ([f2bbd02](https://github.com/googleapis/google-cloud-java/commit/f2bbd0205200ad2b7d012b49512d647d6e16e1a2))


### Dependencies

* reverting renovate bot pull requests ([#8417](https://github.com/googleapis/google-cloud-java/issues/8417)) ([8f0c60b](https://github.com/googleapis/google-cloud-java/commit/8f0c60bde446acccc665eb7894723632eefc3503))

## [2.2.4](https://github.com/googleapis/java-websecurityscanner/compare/v2.2.3...v2.2.4) (2022-09-15)


### Documentation

* Publish Scan Run logging proto for documentation ([#739](https://github.com/googleapis/java-websecurityscanner/issues/739)) ([fe9f602](https://github.com/googleapis/java-websecurityscanner/commit/fe9f60296cdb7cf8fe921597f36892a72056ff00))


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.2 ([#742](https://github.com/googleapis/java-websecurityscanner/issues/742)) ([799689f](https://github.com/googleapis/java-websecurityscanner/commit/799689fca1fd2d336b64a44ab469f678656e3c67))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.3 ([#746](https://github.com/googleapis/java-websecurityscanner/issues/746)) ([758d749](https://github.com/googleapis/java-websecurityscanner/commit/758d749e5ca6980d160e531b41af21ace21e2a77))
* Update dependency joda-time:joda-time to v2.11.1 ([#738](https://github.com/googleapis/java-websecurityscanner/issues/738)) ([493d770](https://github.com/googleapis/java-websecurityscanner/commit/493d770ebb615ba78bb7b412f9463b2513ccfb92))

## [2.2.3](https://github.com/googleapis/java-websecurityscanner/compare/v2.2.2...v2.2.3) (2022-08-16)


### Dependencies

* update dependency joda-time:joda-time to v2.11.0 ([#730](https://github.com/googleapis/java-websecurityscanner/issues/730)) ([1bacd21](https://github.com/googleapis/java-websecurityscanner/commit/1bacd219c92fd6e844d4a94437242272eee15065))

## [2.2.2](https://github.com/googleapis/java-websecurityscanner/compare/v2.2.1...v2.2.2) (2022-08-11)


### Bug Fixes

* google-auth-library-oauth2-http is runtime scope ([#727](https://github.com/googleapis/java-websecurityscanner/issues/727)) ([da91ff1](https://github.com/googleapis/java-websecurityscanner/commit/da91ff1fa317148d27bf24b1ccfbed40ba0af6ae))

## [2.2.1](https://github.com/googleapis/java-websecurityscanner/compare/v2.2.0...v2.2.1) (2022-08-02)


### Bug Fixes

* enable longpaths support for windows test ([#1485](https://github.com/googleapis/java-websecurityscanner/issues/1485)) ([#716](https://github.com/googleapis/java-websecurityscanner/issues/716)) ([d4577a8](https://github.com/googleapis/java-websecurityscanner/commit/d4577a8d95a149c65028c0de08d53f0530e89567))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v3 ([#722](https://github.com/googleapis/java-websecurityscanner/issues/722)) ([db65ad5](https://github.com/googleapis/java-websecurityscanner/commit/db65ad50391ee40fd08bc40b6b1884e331a3df9f))

## [2.2.0](https://github.com/googleapis/java-websecurityscanner/compare/v2.1.1...v2.2.0) (2022-07-01)


### Features

* Enable REST transport for most of Java and Go clients ([#703](https://github.com/googleapis/java-websecurityscanner/issues/703)) ([206caf1](https://github.com/googleapis/java-websecurityscanner/commit/206caf16ec6efea09966e214fe9547639687ffae))

## [2.1.1](https://github.com/googleapis/java-websecurityscanner/compare/v2.1.0...v2.1.1) (2022-06-23)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.13.0 ([#702](https://github.com/googleapis/java-websecurityscanner/issues/702)) ([ff57f17](https://github.com/googleapis/java-websecurityscanner/commit/ff57f178f80cddc3a1ade56fbed1154d325e8581))

## [2.1.0](https://github.com/googleapis/java-websecurityscanner/compare/v2.0.15...v2.1.0) (2022-05-19)


### Features

* add build scripts for native image testing in Java 17 ([#1440](https://github.com/googleapis/java-websecurityscanner/issues/1440)) ([#690](https://github.com/googleapis/java-websecurityscanner/issues/690)) ([b56beb0](https://github.com/googleapis/java-websecurityscanner/commit/b56beb09f3fd970436d623df50bedac663243c2b))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.11.0 ([#689](https://github.com/googleapis/java-websecurityscanner/issues/689)) ([7db2b81](https://github.com/googleapis/java-websecurityscanner/commit/7db2b812adf9ce872b1c4da6eb4b480221e228cc))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.12.0 ([#691](https://github.com/googleapis/java-websecurityscanner/issues/691)) ([4cc70a0](https://github.com/googleapis/java-websecurityscanner/commit/4cc70a0d3c22e18a8621b40f98b5de062540f303))

### [2.0.15](https://github.com/googleapis/java-websecurityscanner/compare/v2.0.14...v2.0.15) (2022-04-15)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.10.0 ([#675](https://github.com/googleapis/java-websecurityscanner/issues/675)) ([7754d04](https://github.com/googleapis/java-websecurityscanner/commit/7754d04daeb8400f764152be9ee565a64bddbf42))

### [2.0.14](https://github.com/googleapis/java-websecurityscanner/compare/v2.0.13...v2.0.14) (2022-03-29)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.9.0 ([#669](https://github.com/googleapis/java-websecurityscanner/issues/669)) ([41941a2](https://github.com/googleapis/java-websecurityscanner/commit/41941a2f523b1b46a349bd1678b19386b00ec3fa))

### [2.0.13](https://github.com/googleapis/java-websecurityscanner/compare/v2.0.12...v2.0.13) (2022-03-22)


### Dependencies

* update dependency joda-time:joda-time to v2.10.14 ([#665](https://github.com/googleapis/java-websecurityscanner/issues/665)) ([5da3b8f](https://github.com/googleapis/java-websecurityscanner/commit/5da3b8f9841c35bc04b04ae2ce2a1ac103ae33e3))

### [2.0.12](https://github.com/googleapis/java-websecurityscanner/compare/v2.0.11...v2.0.12) (2022-03-02)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.8.0 ([#655](https://github.com/googleapis/java-websecurityscanner/issues/655)) ([e353dc1](https://github.com/googleapis/java-websecurityscanner/commit/e353dc1da056605bc547936e105ed701a8f19a3b))

### [2.0.11](https://github.com/googleapis/java-websecurityscanner/compare/v2.0.10...v2.0.11) (2022-02-11)


### Dependencies

* update actions/github-script action to v6 ([#642](https://github.com/googleapis/java-websecurityscanner/issues/642)) ([e459ce8](https://github.com/googleapis/java-websecurityscanner/commit/e459ce856f48ae87bc2301af225e46bdaddc8682))

### [2.0.10](https://github.com/googleapis/java-websecurityscanner/compare/v2.0.9...v2.0.10) (2022-02-03)


### Dependencies

* **java:** update actions/github-script action to v5 ([#1339](https://github.com/googleapis/java-websecurityscanner/issues/1339)) ([#630](https://github.com/googleapis/java-websecurityscanner/issues/630)) ([582eefe](https://github.com/googleapis/java-websecurityscanner/commit/582eefefd9d8c6742b78599fb8086fa31612b857))
* update actions/github-script action to v5 ([#629](https://github.com/googleapis/java-websecurityscanner/issues/629)) ([09e163a](https://github.com/googleapis/java-websecurityscanner/commit/09e163af215f1a3c26d8d0a1c14e15f4029643ff))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.7.0 ([#632](https://github.com/googleapis/java-websecurityscanner/issues/632)) ([6fcb5db](https://github.com/googleapis/java-websecurityscanner/commit/6fcb5db17b70f4312f2ce1a43bd7ca2b72bc4a2c))

### [2.0.9](https://www.github.com/googleapis/java-websecurityscanner/compare/v2.0.8...v2.0.9) (2022-01-07)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.6.0 ([#615](https://www.github.com/googleapis/java-websecurityscanner/issues/615)) ([9a6caa7](https://www.github.com/googleapis/java-websecurityscanner/commit/9a6caa7525e210398879b39b09e2a8563bfefe79))

### [2.0.8](https://www.github.com/googleapis/java-websecurityscanner/compare/v2.0.7...v2.0.8) (2021-12-06)


### Bug Fixes

* **java:** add -ntp flag to native image testing command ([#1299](https://www.github.com/googleapis/java-websecurityscanner/issues/1299)) ([#606](https://www.github.com/googleapis/java-websecurityscanner/issues/606)) ([0e0e9e9](https://www.github.com/googleapis/java-websecurityscanner/commit/0e0e9e97dfa4d985b9dbcedd8f9d3d9fefd2b392))
* **java:** java 17 dependency arguments ([#1266](https://www.github.com/googleapis/java-websecurityscanner/issues/1266)) ([#588](https://www.github.com/googleapis/java-websecurityscanner/issues/588)) ([fa8929e](https://www.github.com/googleapis/java-websecurityscanner/commit/fa8929e89ee22969e634ea542ab0e9a8bacb3bb6))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.5.0 ([#599](https://www.github.com/googleapis/java-websecurityscanner/issues/599)) ([daa2ced](https://www.github.com/googleapis/java-websecurityscanner/commit/daa2cedba128b16b65ae790ba10b08b79b199c3d))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.5.1 ([#605](https://www.github.com/googleapis/java-websecurityscanner/issues/605)) ([9e7f508](https://www.github.com/googleapis/java-websecurityscanner/commit/9e7f508d90e7d00c06a0e0fa3a86d1840690ffd9))
* update dependency joda-time:joda-time to v2.10.13 ([#590](https://www.github.com/googleapis/java-websecurityscanner/issues/590)) ([c458038](https://www.github.com/googleapis/java-websecurityscanner/commit/c458038155eb36c4c58251b3d2fd1841eae3e715))

### [2.0.7](https://www.github.com/googleapis/java-websecurityscanner/compare/v2.0.6...v2.0.7) (2021-10-20)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.4.0 ([#583](https://www.github.com/googleapis/java-websecurityscanner/issues/583)) ([56ba2e7](https://www.github.com/googleapis/java-websecurityscanner/commit/56ba2e76abda1683e3a4aaf020f2b2687f9b10f6))
* update dependency joda-time:joda-time to v2.10.12 ([#577](https://www.github.com/googleapis/java-websecurityscanner/issues/577)) ([ab574b9](https://www.github.com/googleapis/java-websecurityscanner/commit/ab574b946c118bf2363dfc170cfb4a66877949a5))

### [2.0.6](https://www.github.com/googleapis/java-websecurityscanner/compare/v2.0.5...v2.0.6) (2021-09-24)


### Dependencies

* update dependency joda-time:joda-time to v2.10.11 ([#567](https://www.github.com/googleapis/java-websecurityscanner/issues/567)) ([4018c5a](https://www.github.com/googleapis/java-websecurityscanner/commit/4018c5a6415c936e2d73076e918d5d9c893d2826))

### [2.0.5](https://www.github.com/googleapis/java-websecurityscanner/compare/v2.0.4...v2.0.5) (2021-09-22)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.3.0 ([#562](https://www.github.com/googleapis/java-websecurityscanner/issues/562)) ([ceb73f3](https://www.github.com/googleapis/java-websecurityscanner/commit/ceb73f3fe50a8056a6bab4f74e97f43609bf8653))

### [2.0.4](https://www.github.com/googleapis/java-websecurityscanner/compare/v2.0.3...v2.0.4) (2021-09-14)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.2.1 ([#555](https://www.github.com/googleapis/java-websecurityscanner/issues/555)) ([6b92d44](https://www.github.com/googleapis/java-websecurityscanner/commit/6b92d44b3ce03071e838f6e20b1b7bdd8d7f19b4))

### [2.0.3](https://www.github.com/googleapis/java-websecurityscanner/compare/v2.0.2...v2.0.3) (2021-08-31)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.2.0 ([#537](https://www.github.com/googleapis/java-websecurityscanner/issues/537)) ([b4c0e35](https://www.github.com/googleapis/java-websecurityscanner/commit/b4c0e35cd64316b04dc10c896e5c4fea53978e31))

### [2.0.2](https://www.github.com/googleapis/java-websecurityscanner/compare/v2.0.1...v2.0.2) (2021-08-23)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.1.0 ([#526](https://www.github.com/googleapis/java-websecurityscanner/issues/526)) ([3081dda](https://www.github.com/googleapis/java-websecurityscanner/commit/3081dda09b2d8e23e1ad0d7600d2b02f1ee4a85a))

### [2.0.1](https://www.github.com/googleapis/java-websecurityscanner/compare/v2.0.0...v2.0.1) (2021-08-11)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.0.1 ([#515](https://www.github.com/googleapis/java-websecurityscanner/issues/515)) ([f32d841](https://www.github.com/googleapis/java-websecurityscanner/commit/f32d841df8d765484cc288b5a6288da81ec3c531))

## [2.0.0](https://www.github.com/googleapis/java-websecurityscanner/compare/v1.2.2...v2.0.0) (2021-08-10)


### ⚠ BREAKING CHANGES

* release gapic-generator-java v2.0.0 (#509)

### Features

* release gapic-generator-java v2.0.0 ([#509](https://www.github.com/googleapis/java-websecurityscanner/issues/509)) ([cd8382f](https://www.github.com/googleapis/java-websecurityscanner/commit/cd8382f48f35385030d98f07bea51cce4979b593))


### Bug Fixes

* Add shopt -s nullglob to dependencies script ([#491](https://www.github.com/googleapis/java-websecurityscanner/issues/491)) ([2aa4c15](https://www.github.com/googleapis/java-websecurityscanner/commit/2aa4c15293126fb501fdcb4c1e646003a7797fcb))
* Update dependencies.sh to not break on mac ([#480](https://www.github.com/googleapis/java-websecurityscanner/issues/480)) ([2cfa1f1](https://www.github.com/googleapis/java-websecurityscanner/commit/2cfa1f10a600081095b493ce6d3b1c584c5e20d2))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2 ([#510](https://www.github.com/googleapis/java-websecurityscanner/issues/510)) ([55de604](https://www.github.com/googleapis/java-websecurityscanner/commit/55de604d1daa41d07796c0880d73b59c59b8bc6b))

### [1.2.2](https://www.github.com/googleapis/java-websecurityscanner/compare/v1.2.1...v1.2.2) (2021-07-01)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.4.0 ([#484](https://www.github.com/googleapis/java-websecurityscanner/issues/484)) ([ec74ae5](https://www.github.com/googleapis/java-websecurityscanner/commit/ec74ae5c8261e2090de79f6d2bd71d7678cba688))

### [1.2.1](https://www.github.com/googleapis/java-websecurityscanner/compare/v1.2.0...v1.2.1) (2021-06-04)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.3.0 ([#470](https://www.github.com/googleapis/java-websecurityscanner/issues/470)) ([d013313](https://www.github.com/googleapis/java-websecurityscanner/commit/d013313548c6f13858adab4ccac93479b6fb8d38))

## [1.2.0](https://www.github.com/googleapis/java-websecurityscanner/compare/v1.1.6...v1.2.0) (2021-05-26)


### Features

* add `gcf-owl-bot[bot]` to `ignoreAuthors` ([#459](https://www.github.com/googleapis/java-websecurityscanner/issues/459)) ([52492f6](https://www.github.com/googleapis/java-websecurityscanner/commit/52492f60681c64da05a044482d679d103539f0a2))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.2.0 ([#458](https://www.github.com/googleapis/java-websecurityscanner/issues/458)) ([4e5633f](https://www.github.com/googleapis/java-websecurityscanner/commit/4e5633fa067b5e5f6ed45fb735de0eac050615e6))

### [1.1.6](https://www.github.com/googleapis/java-websecurityscanner/compare/v1.1.5...v1.1.6) (2021-05-11)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.1.0 ([#449](https://www.github.com/googleapis/java-websecurityscanner/issues/449)) ([7ff96e2](https://www.github.com/googleapis/java-websecurityscanner/commit/7ff96e217d0903237cff8ab5812071e41b661b57))

### [1.1.5](https://www.github.com/googleapis/java-websecurityscanner/compare/v1.1.4...v1.1.5) (2021-04-23)


### Bug Fixes

* release scripts from issuing overlapping phases ([#429](https://www.github.com/googleapis/java-websecurityscanner/issues/429)) ([6bcc6cd](https://www.github.com/googleapis/java-websecurityscanner/commit/6bcc6cd78046c2258a3d25de60c297c3699e1a5f))
* typo ([#426](https://www.github.com/googleapis/java-websecurityscanner/issues/426)) ([2c8250b](https://www.github.com/googleapis/java-websecurityscanner/commit/2c8250bdbc2c800ebd13eed3e1cebcc7439580cf))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.21.1 ([#432](https://www.github.com/googleapis/java-websecurityscanner/issues/432)) ([c547e0c](https://www.github.com/googleapis/java-websecurityscanner/commit/c547e0c81a2ddf35ae38b2c076a1df9bc91062eb))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1 ([#435](https://www.github.com/googleapis/java-websecurityscanner/issues/435)) ([1ea6cc2](https://www.github.com/googleapis/java-websecurityscanner/commit/1ea6cc2c41a82007195d970d3f0fce97d4243d21))

### [1.1.4](https://www.github.com/googleapis/java-websecurityscanner/compare/v1.1.3...v1.1.4) (2021-04-09)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.21.0 ([#416](https://www.github.com/googleapis/java-websecurityscanner/issues/416)) ([cbfbabc](https://www.github.com/googleapis/java-websecurityscanner/commit/cbfbabc565e975e630a837f1db0273bb0c29081e))

### [1.1.3](https://www.github.com/googleapis/java-websecurityscanner/compare/v1.1.2...v1.1.3) (2021-03-11)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.20.1 ([#401](https://www.github.com/googleapis/java-websecurityscanner/issues/401)) ([27bb85f](https://www.github.com/googleapis/java-websecurityscanner/commit/27bb85fbd8ce941a732f00acbbf883983b44081b))

### [1.1.2](https://www.github.com/googleapis/java-websecurityscanner/compare/v1.1.1...v1.1.2) (2021-02-25)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.20.0 ([#387](https://www.github.com/googleapis/java-websecurityscanner/issues/387)) ([fc6a058](https://www.github.com/googleapis/java-websecurityscanner/commit/fc6a058f927ade5f2d2a7137d653a335cc6ecbb0))

### [1.1.1](https://www.github.com/googleapis/java-websecurityscanner/compare/v1.1.0...v1.1.1) (2021-02-23)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.19.0 ([#377](https://www.github.com/googleapis/java-websecurityscanner/issues/377)) ([2f1d026](https://www.github.com/googleapis/java-websecurityscanner/commit/2f1d026fd398fd38e9f24c38ea9330f1d50a4b13))

## [1.1.0](https://www.github.com/googleapis/java-websecurityscanner/compare/v1.0.10...v1.1.0) (2021-02-16)


### Features

* generate sample code in the Java microgenerator ([#360](https://www.github.com/googleapis/java-websecurityscanner/issues/360)) ([61ac100](https://www.github.com/googleapis/java-websecurityscanner/commit/61ac100f8f8ce7ab8c30bf0450dc7903e9bdb38b))

### [1.0.10](https://www.github.com/googleapis/java-websecurityscanner/compare/v1.0.9...v1.0.10) (2021-01-14)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.18.0 ([#339](https://www.github.com/googleapis/java-websecurityscanner/issues/339)) ([5292d22](https://www.github.com/googleapis/java-websecurityscanner/commit/5292d22e6f3cd01de9b40c18ac1ef7257aa77d22))

### [1.0.9](https://www.github.com/googleapis/java-websecurityscanner/compare/v1.0.8...v1.0.9) (2020-12-15)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.17.0 ([#323](https://www.github.com/googleapis/java-websecurityscanner/issues/323)) ([dc24479](https://www.github.com/googleapis/java-websecurityscanner/commit/dc244797540779aa341076190cac5d61523c2b49))

### [1.0.8](https://www.github.com/googleapis/java-websecurityscanner/compare/v1.0.7...v1.0.8) (2020-12-14)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.16.1 ([#318](https://www.github.com/googleapis/java-websecurityscanner/issues/318)) ([a95ff70](https://www.github.com/googleapis/java-websecurityscanner/commit/a95ff70bd6b02738c8fedc6ab02dc0c5526c10d3))

### [1.0.7](https://www.github.com/googleapis/java-websecurityscanner/compare/v1.0.6...v1.0.7) (2020-12-02)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.16.0 ([#307](https://www.github.com/googleapis/java-websecurityscanner/issues/307)) ([cc45081](https://www.github.com/googleapis/java-websecurityscanner/commit/cc45081730b48ce35cff7d9bfd6dbf69294a8996))

### [1.0.6](https://www.github.com/googleapis/java-websecurityscanner/compare/v1.0.5...v1.0.6) (2020-11-17)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.15.0 ([#291](https://www.github.com/googleapis/java-websecurityscanner/issues/291)) ([998b871](https://www.github.com/googleapis/java-websecurityscanner/commit/998b871c103e8f97b32fe5a66bda0dba12c2dfe7))

### [1.0.5](https://www.github.com/googleapis/java-websecurityscanner/compare/v1.0.4...v1.0.5) (2020-11-02)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.14.1 ([#279](https://www.github.com/googleapis/java-websecurityscanner/issues/279)) ([5a5dd51](https://www.github.com/googleapis/java-websecurityscanner/commit/5a5dd51506291574d6149ce5f1fb282f6f6fda99))

### [1.0.4](https://www.github.com/googleapis/java-websecurityscanner/compare/v1.0.3...v1.0.4) (2020-10-28)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.12.1 ([#255](https://www.github.com/googleapis/java-websecurityscanner/issues/255)) ([5781fb2](https://www.github.com/googleapis/java-websecurityscanner/commit/5781fb2f0a5cb3e98715e7147ccd8e29a51441b0))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.13.0 ([#260](https://www.github.com/googleapis/java-websecurityscanner/issues/260)) ([76de6af](https://www.github.com/googleapis/java-websecurityscanner/commit/76de6afd391814715ad3d31ace1090249a43400c))
* update dependency joda-time:joda-time to v2.10.8 ([#262](https://www.github.com/googleapis/java-websecurityscanner/issues/262)) ([10681fa](https://www.github.com/googleapis/java-websecurityscanner/commit/10681fafaf69219f616f43060bfafa5c72f82275))

### [1.0.3](https://www.github.com/googleapis/java-websecurityscanner/compare/v1.0.2...v1.0.3) (2020-10-09)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.10.2 ([#237](https://www.github.com/googleapis/java-websecurityscanner/issues/237)) ([a8e052a](https://www.github.com/googleapis/java-websecurityscanner/commit/a8e052aed422645a28a75debfec8e32e9e8abdbc))

### [1.0.2](https://www.github.com/googleapis/java-websecurityscanner/compare/v1.0.1...v1.0.2) (2020-09-23)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.10.0 ([#223](https://www.github.com/googleapis/java-websecurityscanner/issues/223)) ([2952fb2](https://www.github.com/googleapis/java-websecurityscanner/commit/2952fb265a50ae7359eabe824ec6c5e5d42332c7))

### [1.0.1](https://www.github.com/googleapis/java-websecurityscanner/compare/v1.0.0...v1.0.1) (2020-09-22)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.9.0 ([#207](https://www.github.com/googleapis/java-websecurityscanner/issues/207)) ([d22b4a9](https://www.github.com/googleapis/java-websecurityscanner/commit/d22b4a98477ca5018ece8951eccb49f91fa26fc8))

## [1.0.0](https://www.github.com/googleapis/java-websecurityscanner/compare/v0.118.0...v1.0.0) (2020-08-10)


### Features

* promote to 1.0.0 ([#189](https://www.github.com/googleapis/java-websecurityscanner/issues/189)) ([6b4ac1f](https://www.github.com/googleapis/java-websecurityscanner/commit/6b4ac1f6353ce7dcafee890d7dc1f893f969fe17))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.2 ([#181](https://www.github.com/googleapis/java-websecurityscanner/issues/181)) ([f82f3fe](https://www.github.com/googleapis/java-websecurityscanner/commit/f82f3fe14cc3bf14dcd097c9e2d57813b0fadda4))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.6 ([#184](https://www.github.com/googleapis/java-websecurityscanner/issues/184)) ([ed58c5a](https://www.github.com/googleapis/java-websecurityscanner/commit/ed58c5a433652a089fef162d19a1536f0da0f724))

## [0.118.0](https://www.github.com/googleapis/java-websecurityscanner/compare/v0.117.0...v0.118.0) (2020-06-22)


### Features

* **deps:** adopt flatten plugin and google-cloud-shared-dependencies ([#166](https://www.github.com/googleapis/java-websecurityscanner/issues/166)) ([e3871d0](https://www.github.com/googleapis/java-websecurityscanner/commit/e3871d022e448a2847f292d7123e7504cc2f7112))


### Bug Fixes

* migrate retry settings to grpc_service_config ([#169](https://www.github.com/googleapis/java-websecurityscanner/issues/169)) ([ef27c8e](https://www.github.com/googleapis/java-websecurityscanner/commit/ef27c8e5076ed8d84561ccd3fd35b470bfaf6127))

## [0.117.0](https://www.github.com/googleapis/java-websecurityscanner/compare/v0.116.3...v0.117.0) (2020-06-16)


### Features

* **v1:** add v1 client ([#154](https://www.github.com/googleapis/java-websecurityscanner/issues/154)) ([36a3086](https://www.github.com/googleapis/java-websecurityscanner/commit/36a3086b24a232ed0cdca2978c8f582149a402c7))


### Bug Fixes

* restore GAPIC v2 retry configs ([#134](https://www.github.com/googleapis/java-websecurityscanner/issues/134)) ([2bb7717](https://www.github.com/googleapis/java-websecurityscanner/commit/2bb7717a3544d39a317cca23c7da65e3595a7ae3))


### Dependencies

* update core dependencies to v1.57.0 ([#156](https://www.github.com/googleapis/java-websecurityscanner/issues/156)) ([98abf96](https://www.github.com/googleapis/java-websecurityscanner/commit/98abf96adc8f1b5f4643b39b3b60c07b7fda82ee))
* update dependency com.google.api:api-common to v1.9.1 ([#139](https://www.github.com/googleapis/java-websecurityscanner/issues/139)) ([86a1d68](https://www.github.com/googleapis/java-websecurityscanner/commit/86a1d68f96bed45c566c3c929302af369a8d3c75))
* update dependency com.google.api:api-common to v1.9.2 ([#145](https://www.github.com/googleapis/java-websecurityscanner/issues/145)) ([95a6cad](https://www.github.com/googleapis/java-websecurityscanner/commit/95a6cad03c90a27bda02edcdec648512b95783e1))
* update dependency com.google.api.grpc:proto-google-common-protos to v1.18.0 ([#128](https://www.github.com/googleapis/java-websecurityscanner/issues/128)) ([ee875e8](https://www.github.com/googleapis/java-websecurityscanner/commit/ee875e848549a791c2e112e3a24a08365300b7ca))
* update dependency com.google.guava:guava-bom to v29 ([#106](https://www.github.com/googleapis/java-websecurityscanner/issues/106)) ([59b7d90](https://www.github.com/googleapis/java-websecurityscanner/commit/59b7d90af3a1f7a03cccbf507e6972fdc41970bb))
* update dependency com.google.protobuf:protobuf-java to v3.12.0 ([#132](https://www.github.com/googleapis/java-websecurityscanner/issues/132)) ([27549c9](https://www.github.com/googleapis/java-websecurityscanner/commit/27549c9d906dafd700ce439fe54c3ee246be3bfe))
* update dependency com.google.protobuf:protobuf-java to v3.12.2 ([#137](https://www.github.com/googleapis/java-websecurityscanner/issues/137)) ([965c65d](https://www.github.com/googleapis/java-websecurityscanner/commit/965c65dfb7888a408136ef3548a55570a917f806))
* update dependency io.grpc:grpc-bom to v1.29.0 ([#118](https://www.github.com/googleapis/java-websecurityscanner/issues/118)) ([b6aef72](https://www.github.com/googleapis/java-websecurityscanner/commit/b6aef72aa651fa37cd20aafd6d5bbe54b7d4308a))
* update dependency io.grpc:grpc-bom to v1.30.0 ([#149](https://www.github.com/googleapis/java-websecurityscanner/issues/149)) ([ad993e7](https://www.github.com/googleapis/java-websecurityscanner/commit/ad993e71b538db2fe9370bb72a900eb99d055353))
* update dependency joda-time:joda-time to v2.10.6 ([#123](https://www.github.com/googleapis/java-websecurityscanner/issues/123)) ([adb0645](https://www.github.com/googleapis/java-websecurityscanner/commit/adb064543ed116bb72cc3cfbd1e2c85d535db36d))
* update dependency org.threeten:threetenbp to v1.4.4 ([#124](https://www.github.com/googleapis/java-websecurityscanner/issues/124)) ([5b7d5a8](https://www.github.com/googleapis/java-websecurityscanner/commit/5b7d5a81a303b8aa57e04945da7ae2c6a9f4056d))

### [0.116.3](https://www.github.com/googleapis/java-websecurityscanner/compare/v0.116.2...v0.116.3) (2020-04-06)


### Dependencies

* update core dependencies ([#73](https://www.github.com/googleapis/java-websecurityscanner/issues/73)) ([553bb82](https://www.github.com/googleapis/java-websecurityscanner/commit/553bb82db048ba7d0dbf64265ea8ebf96862b79b))
* update core dependencies to v1.54.0 ([#70](https://www.github.com/googleapis/java-websecurityscanner/issues/70)) ([30970d8](https://www.github.com/googleapis/java-websecurityscanner/commit/30970d8ded7daf9206196f1ff18b5772d5f4ce5b))
* update dependency com.google.api:api-common to v1.9.0 ([#90](https://www.github.com/googleapis/java-websecurityscanner/issues/90)) ([64b753a](https://www.github.com/googleapis/java-websecurityscanner/commit/64b753ae1694632be3734f78170c130386266593))
* update dependency com.google.cloud.samples:shared-configuration to v1.0.13 ([#89](https://www.github.com/googleapis/java-websecurityscanner/issues/89)) ([9836ad7](https://www.github.com/googleapis/java-websecurityscanner/commit/9836ad7092f2d068fef4222cd5467905eb3a3dbf))
* update dependency com.google.protobuf:protobuf-java to v3.11.4 ([a46c3a6](https://www.github.com/googleapis/java-websecurityscanner/commit/a46c3a62d98b4a6d17932e36c16757c2918a91e0))
* update dependency io.grpc:grpc-bom to v1.27.1 ([b6cba28](https://www.github.com/googleapis/java-websecurityscanner/commit/b6cba28f5ed9f047e7b0845a89e2420107d104e4))
* update dependency io.grpc:grpc-bom to v1.27.2 ([a36651f](https://www.github.com/googleapis/java-websecurityscanner/commit/a36651fbf72861134ccc6b661c035f0314f782c1))
* update dependency org.threeten:threetenbp to v1.4.3 ([#83](https://www.github.com/googleapis/java-websecurityscanner/issues/83)) ([6d35df9](https://www.github.com/googleapis/java-websecurityscanner/commit/6d35df9eacf874c82b6e765e299c79664bb54eb5))
* update google-core ([#72](https://www.github.com/googleapis/java-websecurityscanner/issues/72)) ([7c3b17f](https://www.github.com/googleapis/java-websecurityscanner/commit/7c3b17fb1fcbec7b9e664fd94269543febd47165))


### Documentation

* **regen:** update sample code to set total timeout, add API client header test ([8a15cf6](https://www.github.com/googleapis/java-websecurityscanner/commit/8a15cf639e2cd5e051e772d269828dc6eed043d0))

### [0.116.2](https://www.github.com/googleapis/java-websecurityscanner/compare/v0.116.1...v0.116.2) (2020-02-04)


### Dependencies

* update core dependencies ([#48](https://www.github.com/googleapis/java-websecurityscanner/issues/48)) ([cb91f73](https://www.github.com/googleapis/java-websecurityscanner/commit/cb91f730762d8b0c7207442d5987e88a6e6f3603))
* update core dependencies to v1.53.0 ([#40](https://www.github.com/googleapis/java-websecurityscanner/issues/40)) ([521cab6](https://www.github.com/googleapis/java-websecurityscanner/commit/521cab6df116cbd0f772c376350b6ed5c303bca1))
* update core dependencies to v1.53.1 ([#50](https://www.github.com/googleapis/java-websecurityscanner/issues/50)) ([6dba753](https://www.github.com/googleapis/java-websecurityscanner/commit/6dba7533ba71d60ecaf748fa0b8a793d77be2c92))
* update dependency com.google.guava:guava-bom to v28.2-android ([#32](https://www.github.com/googleapis/java-websecurityscanner/issues/32)) ([d2befdf](https://www.github.com/googleapis/java-websecurityscanner/commit/d2befdfbabafae5af513a2fe3437976863eeab9a))
* update dependency com.google.protobuf:protobuf-java to v3.11.3 ([#52](https://www.github.com/googleapis/java-websecurityscanner/issues/52)) ([aa27b64](https://www.github.com/googleapis/java-websecurityscanner/commit/aa27b642bd5b614c1cc7b9211f67be489b0ada52))
* update dependency org.threeten:threetenbp to v1.4.1 ([33dabdc](https://www.github.com/googleapis/java-websecurityscanner/commit/33dabdc980c32a66c0c1e2602cbc63f07de5608d))


### Documentation

* **regen:** fix javadoc return annotation ([#46](https://www.github.com/googleapis/java-websecurityscanner/issues/46)) ([4976f47](https://www.github.com/googleapis/java-websecurityscanner/commit/4976f472ea140940502327530baa17004ad37070))

### [0.116.1](https://www.github.com/googleapis/java-websecurityscanner/compare/v0.116.0...v0.116.1) (2020-01-07)


### Dependencies

* update dependency com.google.auth:google-auth-library-bom to v0.19.0 ([#23](https://www.github.com/googleapis/java-websecurityscanner/issues/23)) ([6ccd676](https://www.github.com/googleapis/java-websecurityscanner/commit/6ccd6762c46f4ff1acb747686c9c9ef0f3aa9fea))
* update dependency com.google.protobuf:protobuf-java to v3.11.1 ([558ab30](https://www.github.com/googleapis/java-websecurityscanner/commit/558ab300173e4e0eaab25b82ed3f553b6543fcd6))
* update dependency io.grpc:grpc-bom to v1.26.0 ([#29](https://www.github.com/googleapis/java-websecurityscanner/issues/29)) ([59071bf](https://www.github.com/googleapis/java-websecurityscanner/commit/59071bf3eb7a54ddc07c0e8070874eb6127f4fcd))
* update gax.version to v1.52.0 ([#21](https://www.github.com/googleapis/java-websecurityscanner/issues/21)) ([5d57b43](https://www.github.com/googleapis/java-websecurityscanner/commit/5d57b43e919d18a8e0ab3ca0f52cd3ea064af55c))


### Documentation

* **regen:** updated javadocs from protoc update ([#22](https://www.github.com/googleapis/java-websecurityscanner/issues/22)) ([cb13e1b](https://www.github.com/googleapis/java-websecurityscanner/commit/cb13e1b76aa2e29a16ed2b528c535ec70f67b34b))

## [0.116.0](https://www.github.com/googleapis/java-websecurityscanner/compare/0.115.0...v0.116.0) (2019-10-25)


### Features

* make repo releasable, add parent/bom ([#1](https://www.github.com/googleapis/java-websecurityscanner/issues/1)) ([ed44eb5](https://www.github.com/googleapis/java-websecurityscanner/commit/ed44eb5538b2202577c885017ac8a3bc06e9be08))


### Dependencies

* update dependency io.grpc:grpc-bom to v1.24.1 ([f66d759](https://www.github.com/googleapis/java-websecurityscanner/commit/f66d7598e568c6c4a9ee717824e78e5db04d10fc))
* update dependency joda-time:joda-time to v2.10.5 ([#7](https://www.github.com/googleapis/java-websecurityscanner/issues/7)) ([3f13f43](https://www.github.com/googleapis/java-websecurityscanner/commit/3f13f4336d5d4d8b402dd15db4fc8a7fbbb4099c))
* update gax.version to v1.49.1 ([e5b3084](https://www.github.com/googleapis/java-websecurityscanner/commit/e5b3084fa45ac7c993b498048b7f0baadd3d6f66))
