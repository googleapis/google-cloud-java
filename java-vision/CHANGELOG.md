# Changelog

## [3.1.1](https://github.com/googleapis/java-vision/compare/v3.1.0...v3.1.1) (2022-09-16)


### Bug Fixes

* Update IT Test Case Results ([#976](https://github.com/googleapis/java-vision/issues/976)) ([3272c49](https://github.com/googleapis/java-vision/commit/3272c49bbbdd25f53ebca812b84eceaaa160bd84))


### Dependencies

* Update dependency com.google.cloud:google-cloud-core to v2.8.10 ([#977](https://github.com/googleapis/java-vision/issues/977)) ([579608b](https://github.com/googleapis/java-vision/commit/579608b8500d829412d231375c595ec32416f337))
* Update dependency com.google.cloud:google-cloud-core to v2.8.11 ([#980](https://github.com/googleapis/java-vision/issues/980)) ([fe12d4e](https://github.com/googleapis/java-vision/commit/fe12d4ed5868117590ed18063e1942110bb4eda6))
* Update dependency com.google.cloud:google-cloud-core to v2.8.9 ([#973](https://github.com/googleapis/java-vision/issues/973)) ([167bbab](https://github.com/googleapis/java-vision/commit/167bbab7825cd006678525f64f1a76d9f4e86079))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.2 ([#981](https://github.com/googleapis/java-vision/issues/981)) ([ad1e601](https://github.com/googleapis/java-vision/commit/ad1e601f1be075df8ce2e4f587619104526271ab))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.3 ([#985](https://github.com/googleapis/java-vision/issues/985)) ([22b5933](https://github.com/googleapis/java-vision/commit/22b59334fb03ef4657c15dbfbf707133f56c21ad))
* Update dependency com.google.cloud:google-cloud-storage to v2.11.3 ([#964](https://github.com/googleapis/java-vision/issues/964)) ([eefc2b7](https://github.com/googleapis/java-vision/commit/eefc2b72fe980974ad64da1846f769d6efeb336c))
* Update spring.version to v2.7.3 ([#974](https://github.com/googleapis/java-vision/issues/974)) ([2a370a9](https://github.com/googleapis/java-vision/commit/2a370a9dde948155a7c69460b27cd35350883606))

## [3.1.0](https://github.com/googleapis/java-vision/compare/v3.0.2...v3.1.0) (2022-08-09)


### Features

* Add TextDetectionParams.advanced_ocr_options ([#962](https://github.com/googleapis/java-vision/issues/962)) ([62ce19b](https://github.com/googleapis/java-vision/commit/62ce19b72c5cb544819f47b64decc20a9499c6df))


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v2.8.6 ([#955](https://github.com/googleapis/java-vision/issues/955)) ([f245d73](https://github.com/googleapis/java-vision/commit/f245d7396d6e194386f14923e99f921fc535f46e))
* update dependency com.google.cloud:google-cloud-core to v2.8.7 ([#958](https://github.com/googleapis/java-vision/issues/958)) ([8694f43](https://github.com/googleapis/java-vision/commit/8694f43b12956e24a450c91928d94df5496bcfc5))
* update dependency com.google.cloud:google-cloud-core to v2.8.8 ([#960](https://github.com/googleapis/java-vision/issues/960)) ([0737a1f](https://github.com/googleapis/java-vision/commit/0737a1ffcd29e87ca64e064fe43cbb29ec6a1de4))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v3 ([#952](https://github.com/googleapis/java-vision/issues/952)) ([37fdb29](https://github.com/googleapis/java-vision/commit/37fdb29a9364d5423ea2b9e3e4c8ae3cea90d149))
* update dependency com.google.cloud:google-cloud-storage to v2.10.0 ([#956](https://github.com/googleapis/java-vision/issues/956)) ([0100ccb](https://github.com/googleapis/java-vision/commit/0100ccb7c1b299966d9371783457bf91a6ec4ea6))
* update dependency com.google.cloud:google-cloud-storage to v2.11.0 ([#959](https://github.com/googleapis/java-vision/issues/959)) ([0ab0e07](https://github.com/googleapis/java-vision/commit/0ab0e07ae7fdfc4b8f7ee50e60ad7132e20a6f41))
* update dependency com.google.cloud:google-cloud-storage to v2.11.1 ([#961](https://github.com/googleapis/java-vision/issues/961)) ([f6271cb](https://github.com/googleapis/java-vision/commit/f6271cb5a5452f39779ef3f7accc728896e25608))
* update dependency com.google.cloud:google-cloud-storage to v2.11.2 ([#963](https://github.com/googleapis/java-vision/issues/963)) ([7b55995](https://github.com/googleapis/java-vision/commit/7b559956116ea8b4a3bbb6f6d3214e0c4076a2b5))
* update spring.version to v2.7.2 ([#951](https://github.com/googleapis/java-vision/issues/951)) ([c86ad9f](https://github.com/googleapis/java-vision/commit/c86ad9fb00e2d88daec9563873d60893242dfc2d))

## [3.0.2](https://github.com/googleapis/java-vision/compare/v3.0.1...v3.0.2) (2022-07-13)


### Bug Fixes

* enable longpaths support for windows test ([#1485](https://github.com/googleapis/java-vision/issues/1485)) ([#946](https://github.com/googleapis/java-vision/issues/946)) ([d58bf8c](https://github.com/googleapis/java-vision/commit/d58bf8ceb62855e3bfc089f2c7c2332f1f5afa07))

## [3.0.1](https://github.com/googleapis/java-vision/compare/v3.0.0...v3.0.1) (2022-07-01)


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v2.8.1 ([#931](https://github.com/googleapis/java-vision/issues/931)) ([4a80be4](https://github.com/googleapis/java-vision/commit/4a80be4d91900dc7b1d6d6c30cb3482e7624ecdd))

## [3.0.0](https://github.com/googleapis/java-vision/compare/v2.1.4...v3.0.0) (2022-06-28)


### ⚠ BREAKING CHANGES

* BatchAnnotateImagesRequest.requests is required
* Product search related messages and enums changed in an incompatible way
* NormalizedBoundingPoly message removed
* removed fields from SafeSearchAnnotation message

### Features

* Enable REST transport for most of Java and Go clients ([c5d7f0a](https://github.com/googleapis/java-vision/commit/c5d7f0adae7b7a20588847683059108990fc3950))


### Bug Fixes

* BatchAnnotateImagesRequest.requests is required ([c5d7f0a](https://github.com/googleapis/java-vision/commit/c5d7f0adae7b7a20588847683059108990fc3950))
* NormalizedBoundingPoly message removed ([c5d7f0a](https://github.com/googleapis/java-vision/commit/c5d7f0adae7b7a20588847683059108990fc3950))
* Product search related messages and enums changed in an incompatible way ([c5d7f0a](https://github.com/googleapis/java-vision/commit/c5d7f0adae7b7a20588847683059108990fc3950))
* removed fields from SafeSearchAnnotation message ([c5d7f0a](https://github.com/googleapis/java-vision/commit/c5d7f0adae7b7a20588847683059108990fc3950))
* update gapic-generator-java with mock service generation fixes ([#904](https://github.com/googleapis/java-vision/issues/904)) ([c5d7f0a](https://github.com/googleapis/java-vision/commit/c5d7f0adae7b7a20588847683059108990fc3950))

## [2.1.4](https://github.com/googleapis/java-vision/compare/v2.1.3...v2.1.4) (2022-06-27)


### Dependencies

* update spring.version to v2.7.1 ([#925](https://github.com/googleapis/java-vision/issues/925)) ([b03d656](https://github.com/googleapis/java-vision/commit/b03d6560469ef07b459f6380ecdc77e0067f0c3c))

## [2.1.3](https://github.com/googleapis/java-vision/compare/v2.1.2...v2.1.3) (2022-06-23)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.13.0 ([#924](https://github.com/googleapis/java-vision/issues/924)) ([a6173af](https://github.com/googleapis/java-vision/commit/a6173afb0ebd3944b3c90fc6defb046415c0a65c))

## [2.1.2](https://github.com/googleapis/java-vision/compare/v2.1.1...v2.1.2) (2022-06-22)


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v2.8.0 ([#920](https://github.com/googleapis/java-vision/issues/920)) ([ba7d168](https://github.com/googleapis/java-vision/commit/ba7d1689f41b4387ba268137d9a9d70ba6166ca2))

### [2.1.1](https://github.com/googleapis/java-vision/compare/v2.1.0...v2.1.1) (2022-05-25)


### Dependencies

* update dependency com.google.cloud:google-cloud-storage to v2.7.0 ([#913](https://github.com/googleapis/java-vision/issues/913)) ([deac03f](https://github.com/googleapis/java-vision/commit/deac03f12884b9eea8cf1fad748b40e8865ce2c6))

## [2.1.0](https://github.com/googleapis/java-vision/compare/v2.0.29...v2.1.0) (2022-05-19)


### Features

* add build scripts for native image testing in Java 17 ([#1440](https://github.com/googleapis/java-vision/issues/1440)) ([#909](https://github.com/googleapis/java-vision/issues/909)) ([0edc753](https://github.com/googleapis/java-vision/commit/0edc753f7bb7ace905faa8bb7409cbb902d33b76))


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v2.7.1 ([#906](https://github.com/googleapis/java-vision/issues/906)) ([0f0912a](https://github.com/googleapis/java-vision/commit/0f0912a01fbf91ff8365e5a90af5833f478734e3))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.12.0 ([#907](https://github.com/googleapis/java-vision/issues/907)) ([fe00f5e](https://github.com/googleapis/java-vision/commit/fe00f5e0220350c4881ca4451821f13b1b8a8d29))
* update spring.version to v2.7.0 ([#908](https://github.com/googleapis/java-vision/issues/908)) ([9dfefec](https://github.com/googleapis/java-vision/commit/9dfefecb433760ba508303d56659a676dc1f44a2))

### [2.0.29](https://github.com/googleapis/java-vision/compare/v2.0.28...v2.0.29) (2022-05-05)


### Dependencies

* update dependency com.google.cloud:google-cloud-storage to v2.6.1 ([#883](https://github.com/googleapis/java-vision/issues/883)) ([10cd69a](https://github.com/googleapis/java-vision/commit/10cd69a34d26c1bca8115905830aded05f2ea218))
* update spring.version to v2.6.7 ([#888](https://github.com/googleapis/java-vision/issues/888)) ([2f6fb5d](https://github.com/googleapis/java-vision/commit/2f6fb5d123b7a3fd78353982c5570ba03a2e63fe))

### [2.0.28](https://github.com/googleapis/java-vision/compare/v2.0.27...v2.0.28) (2022-04-15)


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v2.6.1 ([#878](https://github.com/googleapis/java-vision/issues/878)) ([4f0fb78](https://github.com/googleapis/java-vision/commit/4f0fb78b94cbf1b36ed767aaca66ea93b2449cad))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.10.0 ([#879](https://github.com/googleapis/java-vision/issues/879)) ([da8fcbd](https://github.com/googleapis/java-vision/commit/da8fcbde46d218c039a9f822d4e22910180b9d78))

### [2.0.27](https://github.com/googleapis/java-vision/compare/v2.0.26...v2.0.27) (2022-04-06)


### Dependencies

* update spring.version to v2.6.6 ([#865](https://github.com/googleapis/java-vision/issues/865)) ([5ae8800](https://github.com/googleapis/java-vision/commit/5ae8800c10f6f6433a5e0d35fbc52a99762acb11))

### [2.0.26](https://github.com/googleapis/java-vision/compare/v2.0.25...v2.0.26) (2022-04-01)


### Dependencies

* update dependency com.google.cloud:google-cloud-storage to v2.6.0 ([#864](https://github.com/googleapis/java-vision/issues/864)) ([ddc5554](https://github.com/googleapis/java-vision/commit/ddc55544f67740efd3c35c040c8c8be4c4b9bdf1))

### [2.0.25](https://github.com/googleapis/java-vision/compare/v2.0.24...v2.0.25) (2022-03-30)


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v2.5.11 ([#860](https://github.com/googleapis/java-vision/issues/860)) ([f631fbe](https://github.com/googleapis/java-vision/commit/f631fbeacf80a11811baf1e910c1442956ecd750))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.9.0 ([#861](https://github.com/googleapis/java-vision/issues/861)) ([944c056](https://github.com/googleapis/java-vision/commit/944c0561c0bcfb8e5cb2a34ce3c70760bd2770d4))
* update dependency com.google.cloud:google-cloud-storage to v2.5.1 ([#859](https://github.com/googleapis/java-vision/issues/859)) ([ef77247](https://github.com/googleapis/java-vision/commit/ef77247919c88a2c8351b34a2e3c78637a89ac89))
* update spring.version to v2.6.5 ([#855](https://github.com/googleapis/java-vision/issues/855)) ([6daa878](https://github.com/googleapis/java-vision/commit/6daa878648be42848c507280745fe63099da7c5e))

### [2.0.24](https://github.com/googleapis/java-vision/compare/v2.0.23...v2.0.24) (2022-03-14)


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v2.5.10 ([#849](https://github.com/googleapis/java-vision/issues/849)) ([c891295](https://github.com/googleapis/java-vision/commit/c89129554c10c251c4e7d0f4a93746de597ae6a7))

### [2.0.23](https://github.com/googleapis/java-vision/compare/v2.0.22...v2.0.23) (2022-03-10)


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v2.5.9 ([#844](https://github.com/googleapis/java-vision/issues/844)) ([65811fa](https://github.com/googleapis/java-vision/commit/65811fab04641db2fbc7d7a4445005265de5f91f))

### [2.0.22](https://github.com/googleapis/java-vision/compare/v2.0.21...v2.0.22) (2022-03-09)


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v2.5.8 ([#840](https://github.com/googleapis/java-vision/issues/840)) ([4b2fe4d](https://github.com/googleapis/java-vision/commit/4b2fe4d96c3be5197881f643328d28dc02de69d2))
* update dependency com.google.cloud:google-cloud-storage to v2.4.5 ([#841](https://github.com/googleapis/java-vision/issues/841)) ([f2add07](https://github.com/googleapis/java-vision/commit/f2add07d7cb0119037bab0462eae7daaf62813eb))

### [2.0.21](https://github.com/googleapis/java-vision/compare/v2.0.20...v2.0.21) (2022-03-03)


### Dependencies

* update dependency com.google.cloud:google-cloud-storage to v2.4.4 ([#832](https://github.com/googleapis/java-vision/issues/832)) ([d9639a6](https://github.com/googleapis/java-vision/commit/d9639a61755fe7d5d1fae36ebb1ecee4724e7af9))
* update dependency org.springframework.boot:spring-boot-maven-plugin to v2.6.4 ([#822](https://github.com/googleapis/java-vision/issues/822)) ([de248e3](https://github.com/googleapis/java-vision/commit/de248e3543008022b5cd76b542243ec1e716b96e))

### [2.0.20](https://github.com/googleapis/java-vision/compare/v2.0.19...v2.0.20) (2022-03-03)


### Dependencies

* update actions/github-script action to v6 ([#814](https://github.com/googleapis/java-vision/issues/814)) ([d9e9e87](https://github.com/googleapis/java-vision/commit/d9e9e87f3022509dde57c67a613537759fd03945))
* update actions/setup-java action to v3 ([#823](https://github.com/googleapis/java-vision/issues/823)) ([d2b64e7](https://github.com/googleapis/java-vision/commit/d2b64e7729ceb41d4957d19e50edd6750e8380c1))
* update dependency com.google.cloud:google-cloud-core to v2.5.0 ([#804](https://github.com/googleapis/java-vision/issues/804)) ([0f17a3f](https://github.com/googleapis/java-vision/commit/0f17a3ff2bb52df0a6122cc81a47e39cb4c9f13b))
* update dependency com.google.cloud:google-cloud-core to v2.5.1 ([#811](https://github.com/googleapis/java-vision/issues/811)) ([75b3a20](https://github.com/googleapis/java-vision/commit/75b3a20f705ca9f8c343001253d79f9a68059cf5))
* update dependency com.google.cloud:google-cloud-core to v2.5.3 ([#812](https://github.com/googleapis/java-vision/issues/812)) ([fda8bb5](https://github.com/googleapis/java-vision/commit/fda8bb5f15d9d6ecc81aed1fb3425726085bcb6f))
* update dependency com.google.cloud:google-cloud-core to v2.5.4 ([#816](https://github.com/googleapis/java-vision/issues/816)) ([db49eb9](https://github.com/googleapis/java-vision/commit/db49eb9f63729c92216518fc16b246c180266cf6))
* update dependency com.google.cloud:google-cloud-core to v2.5.5 ([#825](https://github.com/googleapis/java-vision/issues/825)) ([8b902e8](https://github.com/googleapis/java-vision/commit/8b902e8f3dd2d19f4d05ffe2c2d8655175d95802))
* update dependency com.google.cloud:google-cloud-core to v2.5.6 ([#828](https://github.com/googleapis/java-vision/issues/828)) ([53b9456](https://github.com/googleapis/java-vision/commit/53b94569935da5979aefea6c27e4a6c376736777))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.8.0 ([#829](https://github.com/googleapis/java-vision/issues/829)) ([e27f72f](https://github.com/googleapis/java-vision/commit/e27f72fdc7da7aadea5f645840434a971f66c6d1))
* update dependency com.google.cloud:google-cloud-storage to v2.4.0 ([#803](https://github.com/googleapis/java-vision/issues/803)) ([26e208e](https://github.com/googleapis/java-vision/commit/26e208ea84905dabf0dc3d6ddb9e6bd303f73213))

### [2.0.19](https://github.com/googleapis/java-vision/compare/v2.0.18...v2.0.19) (2022-02-03)


### Dependencies

* **java:** update actions/github-script action to v5 ([#1339](https://github.com/googleapis/java-vision/issues/1339)) ([#795](https://github.com/googleapis/java-vision/issues/795)) ([7ece1c4](https://github.com/googleapis/java-vision/commit/7ece1c4a5d2e2d04a98a7109a0327725a6f5793c))
* update dependency com.google.cloud:google-cloud-core to v2.4.0 ([#797](https://github.com/googleapis/java-vision/issues/797)) ([f9473ad](https://github.com/googleapis/java-vision/commit/f9473adec2b0ecb142925aa312807bb109093f59))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.7.0 ([#798](https://github.com/googleapis/java-vision/issues/798)) ([fe88ad9](https://github.com/googleapis/java-vision/commit/fe88ad99060dc528de398fd7f720bb276408cac0))
* update dependency com.google.cloud:google-cloud-storage to v2.2.3 ([#782](https://github.com/googleapis/java-vision/issues/782)) ([cef8d2e](https://github.com/googleapis/java-vision/commit/cef8d2e84c4af44236405fdefe75ec33faefd48e))
* update dependency com.google.cloud:google-cloud-storage to v2.3.0 ([#792](https://github.com/googleapis/java-vision/issues/792)) ([c74154b](https://github.com/googleapis/java-vision/commit/c74154b76ac3f70443ff9315fc5dba5813a3aedb))
* update spring.version to v2.6.3 ([#768](https://github.com/googleapis/java-vision/issues/768)) ([4949473](https://github.com/googleapis/java-vision/commit/4949473f0205009939a65af3fcff0f5bef7d5e03))

### [2.0.18](https://www.github.com/googleapis/java-vision/compare/v2.0.17...v2.0.18) (2022-01-07)


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v2.3.5 ([#779](https://www.github.com/googleapis/java-vision/issues/779)) ([27e9171](https://www.github.com/googleapis/java-vision/commit/27e9171e2e49bf754e0cafd3acff714776c3c17f))

### [2.0.17](https://www.github.com/googleapis/java-vision/compare/v2.0.16...v2.0.17) (2022-01-07)


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v2.3.4 ([#772](https://www.github.com/googleapis/java-vision/issues/772)) ([2b7e20d](https://www.github.com/googleapis/java-vision/commit/2b7e20d6ba488858d4912e2437c07dcf7a6afe27))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.6.0 ([#775](https://www.github.com/googleapis/java-vision/issues/775)) ([8564164](https://www.github.com/googleapis/java-vision/commit/8564164ec4933da73fdfa01fca17bb7ae8f6e3bb))

### [2.0.16](https://www.github.com/googleapis/java-vision/compare/v2.0.15...v2.0.16) (2021-12-06)


### Dependencies

* update dependency com.google.cloud:google-cloud-storage to v2.2.2 ([#762](https://www.github.com/googleapis/java-vision/issues/762)) ([330eec7](https://www.github.com/googleapis/java-vision/commit/330eec797a4dd40a1bc6b70829233e72f7ef5051))

### [2.0.15](https://www.github.com/googleapis/java-vision/compare/v2.0.14...v2.0.15) (2021-12-06)


### Bug Fixes

* **java:** add -ntp flag to native image testing command ([#1299](https://www.github.com/googleapis/java-vision/issues/1299)) ([#759](https://www.github.com/googleapis/java-vision/issues/759)) ([ab18d6d](https://www.github.com/googleapis/java-vision/commit/ab18d6d06e52bce15d3a97a3c486461b95985009))
* **java:** java 17 dependency arguments ([#1266](https://www.github.com/googleapis/java-vision/issues/1266)) ([#731](https://www.github.com/googleapis/java-vision/issues/731)) ([68a2989](https://www.github.com/googleapis/java-vision/commit/68a29899ce123e54bfa88171a7f9d8526190492c))


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v2.3.0 ([#744](https://www.github.com/googleapis/java-vision/issues/744)) ([55f4984](https://www.github.com/googleapis/java-vision/commit/55f498485a6962785b0b46f2a099aa12dbef16a3))
* update dependency com.google.cloud:google-cloud-core to v2.3.1 ([#746](https://www.github.com/googleapis/java-vision/issues/746)) ([fadf4f7](https://www.github.com/googleapis/java-vision/commit/fadf4f7c1a4ff9befdf59290bce6310ac002b23b))
* update dependency com.google.cloud:google-cloud-core to v2.3.2 ([#756](https://www.github.com/googleapis/java-vision/issues/756)) ([4437d19](https://www.github.com/googleapis/java-vision/commit/4437d1987edef1149efba19146c9828a4ac297ca))
* update dependency com.google.cloud:google-cloud-core to v2.3.3 ([#758](https://www.github.com/googleapis/java-vision/issues/758)) ([9e7cbec](https://www.github.com/googleapis/java-vision/commit/9e7cbeceabecc17d66dea110501ea163b24dbc88))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.5.0 ([#745](https://www.github.com/googleapis/java-vision/issues/745)) ([f56539f](https://www.github.com/googleapis/java-vision/commit/f56539f53e7a24a3b50d0634394010b6b9ea5256))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.5.1 ([#757](https://www.github.com/googleapis/java-vision/issues/757)) ([05ebc83](https://www.github.com/googleapis/java-vision/commit/05ebc83ef19240c55e9ed1bddce753e48120e4ed))
* update dependency com.google.cloud:google-cloud-storage to v2.2.0 ([#735](https://www.github.com/googleapis/java-vision/issues/735)) ([2475605](https://www.github.com/googleapis/java-vision/commit/24756055cc8577bec78cd0de96240ab4f5cefc66))
* update dependency com.google.cloud:google-cloud-storage to v2.2.1 ([#747](https://www.github.com/googleapis/java-vision/issues/747)) ([93b862c](https://www.github.com/googleapis/java-vision/commit/93b862cfc511a51d8194f8086d701c284cfc1903))
* update dependency org.springframework.boot:spring-boot-starter-web to v2.6.1 ([#751](https://www.github.com/googleapis/java-vision/issues/751)) ([12873ab](https://www.github.com/googleapis/java-vision/commit/12873aba676b55ef70edf2870d8ae0a893278c9b))
* update spring.version to v2.5.6 ([#729](https://www.github.com/googleapis/java-vision/issues/729)) ([ab74eab](https://www.github.com/googleapis/java-vision/commit/ab74eab67b51794b9f599e7814af32503e3f8363))
* update spring.version to v2.6.0 ([#749](https://www.github.com/googleapis/java-vision/issues/749)) ([9bfdf6a](https://www.github.com/googleapis/java-vision/commit/9bfdf6a445e92e08d4a36344de0241038d0c2a66))

### [2.0.14](https://www.github.com/googleapis/java-vision/compare/v2.0.13...v2.0.14) (2021-10-20)


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v2.2.0 ([#720](https://www.github.com/googleapis/java-vision/issues/720)) ([79af36f](https://www.github.com/googleapis/java-vision/commit/79af36f1da8ea0f72cbc792dd415a7fe17a0e40f))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.4.0 ([#723](https://www.github.com/googleapis/java-vision/issues/723)) ([d390b4e](https://www.github.com/googleapis/java-vision/commit/d390b4e6aad4f3401c6586535392f84815252f86))
* update dependency com.google.cloud:google-cloud-storage to v2.1.6 ([#708](https://www.github.com/googleapis/java-vision/issues/708)) ([146c717](https://www.github.com/googleapis/java-vision/commit/146c717e3191051d99a9e4d05d5faff8ff46e590))
* update dependency com.google.cloud:google-cloud-storage to v2.1.7 ([#716](https://www.github.com/googleapis/java-vision/issues/716)) ([95f2114](https://www.github.com/googleapis/java-vision/commit/95f21140753ffd95aae586533f980f2f8941600c))
* update dependency com.google.cloud:google-cloud-storage to v2.1.8 ([#722](https://www.github.com/googleapis/java-vision/issues/722)) ([03e95d7](https://www.github.com/googleapis/java-vision/commit/03e95d76be1f3a66aafd67fcf4661ba1fdf49143))
* update dependency com.google.cloud:google-cloud-storage to v2.1.9 ([#724](https://www.github.com/googleapis/java-vision/issues/724)) ([024cbf8](https://www.github.com/googleapis/java-vision/commit/024cbf8bdc0d0eb9baec1769ff3f44356dbb72ab))

### [2.0.13](https://www.github.com/googleapis/java-vision/compare/v2.0.12...v2.0.13) (2021-09-24)


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v2.1.7 ([#702](https://www.github.com/googleapis/java-vision/issues/702)) ([c915e80](https://www.github.com/googleapis/java-vision/commit/c915e80cf6d44acc6c3d1325bb8fb453ab4e8fdf))
* update spring.version to v2.5.5 ([#703](https://www.github.com/googleapis/java-vision/issues/703)) ([eb9ff28](https://www.github.com/googleapis/java-vision/commit/eb9ff282d21035374ad91a8f5a54e14cade6f3f9))

### [2.0.12](https://www.github.com/googleapis/java-vision/compare/v2.0.11...v2.0.12) (2021-09-22)


### Dependencies

* update dependency com.google.cloud:google-cloud-storage to v2.1.5 ([#696](https://www.github.com/googleapis/java-vision/issues/696)) ([1f7d173](https://www.github.com/googleapis/java-vision/commit/1f7d173feb7c42ce3a2bb5d9cf851648b7d60e35))

### [2.0.11](https://www.github.com/googleapis/java-vision/compare/v2.0.10...v2.0.11) (2021-09-22)


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v2.1.6 ([#692](https://www.github.com/googleapis/java-vision/issues/692)) ([e373951](https://www.github.com/googleapis/java-vision/commit/e373951ebdc9372c614740f25ba2ace2b421aca3))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.3.0 ([#693](https://www.github.com/googleapis/java-vision/issues/693)) ([5f1a843](https://www.github.com/googleapis/java-vision/commit/5f1a843ee14543e88cbd6a05df8331911dda82e4))
* update dependency com.google.cloud:google-cloud-storage to v2.1.4 ([#689](https://www.github.com/googleapis/java-vision/issues/689)) ([48bde8c](https://www.github.com/googleapis/java-vision/commit/48bde8c6e06724cd7f5976df6fb54310e4bacfc5))

### [2.0.10](https://www.github.com/googleapis/java-vision/compare/v2.0.9...v2.0.10) (2021-09-20)


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v2.1.4 ([#685](https://www.github.com/googleapis/java-vision/issues/685)) ([03f279a](https://www.github.com/googleapis/java-vision/commit/03f279a25f3060d6569bd170791b5c5973bfbb44))

### [2.0.9](https://www.github.com/googleapis/java-vision/compare/v2.0.8...v2.0.9) (2021-09-15)


### Dependencies

* update dependency com.google.cloud:google-cloud-storage to v2.1.3 ([#681](https://www.github.com/googleapis/java-vision/issues/681)) ([2e23161](https://www.github.com/googleapis/java-vision/commit/2e231617d433aaede89de62816eb0b1d4bcf7994))

### [2.0.8](https://www.github.com/googleapis/java-vision/compare/v2.0.7...v2.0.8) (2021-09-15)


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v2.1.3 ([#674](https://www.github.com/googleapis/java-vision/issues/674)) ([14603b1](https://www.github.com/googleapis/java-vision/commit/14603b10a9cb69b6f3c17a100a5022816b4aef5b))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.2.1 ([#675](https://www.github.com/googleapis/java-vision/issues/675)) ([b87fd54](https://www.github.com/googleapis/java-vision/commit/b87fd54721a491bde0f7d04723512e1854d3f21a))
* update dependency com.google.cloud:google-cloud-storage to v2.1.2 ([#677](https://www.github.com/googleapis/java-vision/issues/677)) ([58bb3b1](https://www.github.com/googleapis/java-vision/commit/58bb3b10286bc754ec6df23d21e80a1075719438))

### [2.0.7](https://www.github.com/googleapis/java-vision/compare/v2.0.6...v2.0.7) (2021-09-03)


### Dependencies

* update dependency com.google.cloud:google-cloud-storage to v2.1.1 ([#662](https://www.github.com/googleapis/java-vision/issues/662)) ([25101ce](https://www.github.com/googleapis/java-vision/commit/25101cec1f0e1842d7f501d67931588cad16ea45))

### [2.0.6](https://www.github.com/googleapis/java-vision/compare/v2.0.5...v2.0.6) (2021-09-01)


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v2.1.2 ([#652](https://www.github.com/googleapis/java-vision/issues/652)) ([e517714](https://www.github.com/googleapis/java-vision/commit/e517714ab1296e394bf87e200c5aea72bb0c4213))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.2.0 ([#654](https://www.github.com/googleapis/java-vision/issues/654)) ([0854ec5](https://www.github.com/googleapis/java-vision/commit/0854ec5235c3bedd7a6bfe98fe5754d54009bfee))
* update dependency com.google.cloud:google-cloud-storage to v2.1.0 ([#646](https://www.github.com/googleapis/java-vision/issues/646)) ([66b1eb5](https://www.github.com/googleapis/java-vision/commit/66b1eb5cc1b0cfd751f7dbaceec1c946f77e1304))

### [2.0.5](https://www.github.com/googleapis/java-vision/compare/v2.0.4...v2.0.5) (2021-08-24)


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v2.1.1 ([#641](https://www.github.com/googleapis/java-vision/issues/641)) ([8f6a86e](https://www.github.com/googleapis/java-vision/commit/8f6a86ea488769ffcfe24cb056aff22b915ad1fa))

### [2.0.4](https://www.github.com/googleapis/java-vision/compare/v2.0.3...v2.0.4) (2021-08-24)


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v2.1.0 ([#634](https://www.github.com/googleapis/java-vision/issues/634)) ([1f56cd5](https://www.github.com/googleapis/java-vision/commit/1f56cd544816a82060c0e8a7bfabb30761b980cf))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.1.0 ([#635](https://www.github.com/googleapis/java-vision/issues/635)) ([eb040fe](https://www.github.com/googleapis/java-vision/commit/eb040fe4485c6d47f24ed407194b96f259e98eb5))

### [2.0.3](https://www.github.com/googleapis/java-vision/compare/v2.0.2...v2.0.3) (2021-08-19)


### Dependencies

* update dependency com.google.cloud:google-cloud-storage to v2.0.2 ([#628](https://www.github.com/googleapis/java-vision/issues/628)) ([13d3f83](https://www.github.com/googleapis/java-vision/commit/13d3f8383f78b98f6069a09902b5a722ca5c41fc))

### [2.0.2](https://www.github.com/googleapis/java-vision/compare/v2.0.1...v2.0.2) (2021-08-19)


### Dependencies

* update spring.version to v2.5.4 ([#581](https://www.github.com/googleapis/java-vision/issues/581)) ([b5a13ec](https://www.github.com/googleapis/java-vision/commit/b5a13ecfd80ccb1122595aef4c07eef6fba16f8b))

### [2.0.1](https://www.github.com/googleapis/java-vision/compare/v2.0.0...v2.0.1) (2021-08-12)


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v2.0.3 ([#611](https://www.github.com/googleapis/java-vision/issues/611)) ([5c47161](https://www.github.com/googleapis/java-vision/commit/5c4716187b3c3450dc277f541dddf9a32b9314a2))
* update dependency com.google.cloud:google-cloud-core to v2.0.5 ([#614](https://www.github.com/googleapis/java-vision/issues/614)) ([ccf1700](https://www.github.com/googleapis/java-vision/commit/ccf1700c629067a378f00c0de6ecbef742e9db71))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.0.1 ([#615](https://www.github.com/googleapis/java-vision/issues/615)) ([ce016d5](https://www.github.com/googleapis/java-vision/commit/ce016d58a10b5e612f4d4dab29180c6678c8a193))
* update dependency com.google.cloud:google-cloud-storage to v2.0.1 ([#616](https://www.github.com/googleapis/java-vision/issues/616)) ([b5ac259](https://www.github.com/googleapis/java-vision/commit/b5ac259fb5e34dfead380afbec3b302c725c5df4))

## [2.0.0](https://www.github.com/googleapis/java-vision/compare/v1.113.7...v2.0.0) (2021-08-10)


### ⚠ BREAKING CHANGES

* release gapic-generator-java v2.0.0 (#600)

### Features

* release gapic-generator-java v2.0.0 ([#600](https://www.github.com/googleapis/java-vision/issues/600)) ([747c5a0](https://www.github.com/googleapis/java-vision/commit/747c5a0a3fa7bca745d6d7aff4d4ecf7f91ac87a))


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v2 ([#599](https://www.github.com/googleapis/java-vision/issues/599)) ([17db6ea](https://www.github.com/googleapis/java-vision/commit/17db6ea599e5929a8e487c8867e67d38f4ae8b28))
* update dependency com.google.cloud:google-cloud-storage to v2 ([#606](https://www.github.com/googleapis/java-vision/issues/606)) ([fe58ac2](https://www.github.com/googleapis/java-vision/commit/fe58ac2fbc0166bad26b90b5a64145fa02350838))
* update dependency org.apache.commons:commons-csv to v1.9.0 ([#598](https://www.github.com/googleapis/java-vision/issues/598)) ([34ea73f](https://www.github.com/googleapis/java-vision/commit/34ea73f3dcd71027a3bf92eae32bbc78126fef77))

### [1.113.7](https://www.github.com/googleapis/java-vision/compare/v1.113.6...v1.113.7) (2021-07-22)


### Dependencies

* update dependency com.google.cloud:google-cloud-storage to v1.118.0 ([#578](https://www.github.com/googleapis/java-vision/issues/578)) ([e3adf9d](https://www.github.com/googleapis/java-vision/commit/e3adf9d43dc7e926e365b137466b24ca096a162e))

### [1.113.6](https://www.github.com/googleapis/java-vision/compare/v1.113.5...v1.113.6) (2021-07-02)


### Bug Fixes

* Add `shopt -s nullglob` to dependencies script ([#562](https://www.github.com/googleapis/java-vision/issues/562)) ([0d833bc](https://www.github.com/googleapis/java-vision/commit/0d833bc80e2833999fd9c4f575fcf792b13b3b18))


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v1.95.4 ([#563](https://www.github.com/googleapis/java-vision/issues/563)) ([af16d73](https://www.github.com/googleapis/java-vision/commit/af16d73ffc83bb1b1dce716e4774a5e87bfbd7a9))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.4.0 ([#568](https://www.github.com/googleapis/java-vision/issues/568)) ([8785c7e](https://www.github.com/googleapis/java-vision/commit/8785c7ef03f02bf60cb9cec7cc4f28d4f0cde52c))
* update dependency com.google.cloud:google-cloud-storage to v1.117.1 ([#567](https://www.github.com/googleapis/java-vision/issues/567)) ([9c2d249](https://www.github.com/googleapis/java-vision/commit/9c2d249a6c9ed08d422beea896741bd63eeb72c0))
* update spring.version to v2.5.2 ([#566](https://www.github.com/googleapis/java-vision/issues/566)) ([932b79b](https://www.github.com/googleapis/java-vision/commit/932b79bae4eb24a8c3a9a54100fc37cc60b93076))

### [1.113.5](https://www.github.com/googleapis/java-vision/compare/v1.113.4...v1.113.5) (2021-06-16)


### Dependencies

* update spring.version to v2.5.1 ([#544](https://www.github.com/googleapis/java-vision/issues/544)) ([3077e01](https://www.github.com/googleapis/java-vision/commit/3077e01e7a47c345b197c206ba72919291b76d79))

### [1.113.4](https://www.github.com/googleapis/java-vision/compare/v1.113.3...v1.113.4) (2021-06-16)


### Dependencies

* update dependency com.google.cloud:google-cloud-storage to v1.116.0 ([#548](https://www.github.com/googleapis/java-vision/issues/548)) ([4250907](https://www.github.com/googleapis/java-vision/commit/4250907dda0fea460454919f17a6f80085b06833))

### [1.113.3](https://www.github.com/googleapis/java-vision/compare/v1.113.2...v1.113.3) (2021-06-15)


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v1.95.2 ([#542](https://www.github.com/googleapis/java-vision/issues/542)) ([6fa168e](https://www.github.com/googleapis/java-vision/commit/6fa168ed43c3c35df5782aa725f0901a1ac0b7bc))

### [1.113.2](https://www.github.com/googleapis/java-vision/compare/v1.113.1...v1.113.2) (2021-06-09)


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v1.95.1 ([#533](https://www.github.com/googleapis/java-vision/issues/533)) ([3d69977](https://www.github.com/googleapis/java-vision/commit/3d69977e63a8e350d4384b983ae5e3f7fabb9200))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.3.0 ([#534](https://www.github.com/googleapis/java-vision/issues/534)) ([b03a16a](https://www.github.com/googleapis/java-vision/commit/b03a16acea77a7657a2444f8fd4261a1f3719b58))

### [1.113.1](https://www.github.com/googleapis/java-vision/compare/v1.113.0...v1.113.1) (2021-06-02)


### Dependencies

* update dependency com.google.cloud:google-cloud-storage to v1.115.0 ([#526](https://www.github.com/googleapis/java-vision/issues/526)) ([d59ee4e](https://www.github.com/googleapis/java-vision/commit/d59ee4e2edb9370719aa81258de29885284220ba))

## [1.113.0](https://www.github.com/googleapis/java-vision/compare/v1.112.3...v1.113.0) (2021-05-31)


### Features

* add `gcf-owl-bot[bot]` to `ignoreAuthors` ([#513](https://www.github.com/googleapis/java-vision/issues/513)) ([50c5c7f](https://www.github.com/googleapis/java-vision/commit/50c5c7f22c3a37e907fc3c607f947bcc9345100e))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.2.0 ([#512](https://www.github.com/googleapis/java-vision/issues/512)) ([daf6ae2](https://www.github.com/googleapis/java-vision/commit/daf6ae2f091c09eb7f0fa0221e1c339aacc25f77))
* update spring.version to v2.5.0 ([#516](https://www.github.com/googleapis/java-vision/issues/516)) ([2fd512b](https://www.github.com/googleapis/java-vision/commit/2fd512b72bf8bbab0280e2a82744213d58ff2954))

### [1.112.3](https://www.github.com/googleapis/java-vision/compare/v1.112.2...v1.112.3) (2021-05-14)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.1.0 ([#502](https://www.github.com/googleapis/java-vision/issues/502)) ([4110847](https://www.github.com/googleapis/java-vision/commit/4110847e02efc2df44eca4deebe3ef215cae21d2))
* update dependency com.google.cloud:google-cloud-storage to v1.114.0 ([#504](https://www.github.com/googleapis/java-vision/issues/504)) ([b83e34b](https://www.github.com/googleapis/java-vision/commit/b83e34ba5279911f9449ef038dc899b165555586))
* update dependency org.springframework.cloud:spring-cloud-gcp-dependencies to v1.2.8.release ([#497](https://www.github.com/googleapis/java-vision/issues/497)) ([7b84b29](https://www.github.com/googleapis/java-vision/commit/7b84b291d0a57730e9075051e6379cc50d2bed6e))

### [1.112.2](https://www.github.com/googleapis/java-vision/compare/v1.112.1...v1.112.2) (2021-04-27)


### Bug Fixes

* release scripts from issuing overlapping phases ([#473](https://www.github.com/googleapis/java-vision/issues/473)) ([022f2be](https://www.github.com/googleapis/java-vision/commit/022f2be0b04d76116ef33adab63fbc0111922ad4))
* typo ([#468](https://www.github.com/googleapis/java-vision/issues/468)) ([d27229c](https://www.github.com/googleapis/java-vision/commit/d27229cf4f3bf0e5e051278dc2d45c2bed4739aa))


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v1.94.8 ([#482](https://www.github.com/googleapis/java-vision/issues/482)) ([0511c89](https://www.github.com/googleapis/java-vision/commit/0511c8965554656a75d37374822b34afe1eb90ba))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.21.1 ([#478](https://www.github.com/googleapis/java-vision/issues/478)) ([736a022](https://www.github.com/googleapis/java-vision/commit/736a0227af58e7be8f47839cfb450a43a4d62793))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1 ([#483](https://www.github.com/googleapis/java-vision/issues/483)) ([c79230b](https://www.github.com/googleapis/java-vision/commit/c79230b2faeec7a18153db3b8569583f20aef160))
* update dependency com.google.cloud:google-cloud-storage to v1.113.16 ([#471](https://www.github.com/googleapis/java-vision/issues/471)) ([ff0cee8](https://www.github.com/googleapis/java-vision/commit/ff0cee8e88277c2064f3bdac46b2bfd95fd825bb))
* update spring.version to v2.4.5 ([#474](https://www.github.com/googleapis/java-vision/issues/474)) ([8753624](https://www.github.com/googleapis/java-vision/commit/87536248f99ad1ab770d1c1d8f766b35fb082fa3))

### [1.112.1](https://www.github.com/googleapis/java-vision/compare/v1.112.0...v1.112.1) (2021-04-12)


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v1.94.7 ([#441](https://www.github.com/googleapis/java-vision/issues/441)) ([d4bbb0a](https://www.github.com/googleapis/java-vision/commit/d4bbb0a8f28aa31b37932266fd9a55149debdffd))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.21.0 ([#459](https://www.github.com/googleapis/java-vision/issues/459)) ([8278417](https://www.github.com/googleapis/java-vision/commit/827841776d2c2824c31faf8828d67072d0b2f544))
* update dependency com.google.cloud:google-cloud-storage to v1.113.14 ([#442](https://www.github.com/googleapis/java-vision/issues/442)) ([36dcc57](https://www.github.com/googleapis/java-vision/commit/36dcc571e68f0b18e0863e7e4e26d22e9038a9f3))
* update dependency net.sourceforge.argparse4j:argparse4j to v0.9.0 ([#455](https://www.github.com/googleapis/java-vision/issues/455)) ([ea40b48](https://www.github.com/googleapis/java-vision/commit/ea40b487d50030959a04f3b4099afc6895ca4dc4))
* update spring.version to v2.4.4 ([#448](https://www.github.com/googleapis/java-vision/issues/448)) ([3db8853](https://www.github.com/googleapis/java-vision/commit/3db8853edda8d4f0f436f608ed92db58eaf90b62))

## [1.112.0](https://www.github.com/googleapis/java-vision/compare/v1.111.1...v1.112.0) (2021-03-11)


### Features

* **generator:** update protoc to v3.15.3 ([#421](https://www.github.com/googleapis/java-vision/issues/421)) ([528806f](https://www.github.com/googleapis/java-vision/commit/528806f9c29bd2e17b0edc92afba9d8eceb0ad93))


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v1.94.2 ([#423](https://www.github.com/googleapis/java-vision/issues/423)) ([62fc0b8](https://www.github.com/googleapis/java-vision/commit/62fc0b83f55ce0222c3a14456c34598c6325df59))
* update dependency com.google.cloud:google-cloud-core to v1.94.3 ([#428](https://www.github.com/googleapis/java-vision/issues/428)) ([3cd7c5f](https://www.github.com/googleapis/java-vision/commit/3cd7c5f117352f607e168423c863455a26f5f44c))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.20.1 ([#437](https://www.github.com/googleapis/java-vision/issues/437)) ([dcf81a8](https://www.github.com/googleapis/java-vision/commit/dcf81a87e0badec5b26f4338c3522fe9779b709a))
* update dependency com.google.cloud:google-cloud-storage to v1.113.12 ([#422](https://www.github.com/googleapis/java-vision/issues/422)) ([502b688](https://www.github.com/googleapis/java-vision/commit/502b688106e41b5227471ae0dc92add1a63a7bf6))
* update dependency com.google.cloud:google-cloud-storage to v1.113.13 ([#436](https://www.github.com/googleapis/java-vision/issues/436)) ([c3e29b7](https://www.github.com/googleapis/java-vision/commit/c3e29b7b39e754e315b68b7a6a8fd6f41d373a54))

### [1.111.1](https://www.github.com/googleapis/java-vision/compare/v1.111.0...v1.111.1) (2021-02-25)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.20.0 ([#417](https://www.github.com/googleapis/java-vision/issues/417)) ([42249d8](https://www.github.com/googleapis/java-vision/commit/42249d89165bbceca783edbbbebe0ede5a299c07))

## [1.111.0](https://www.github.com/googleapis/java-vision/compare/v1.110.10...v1.111.0) (2021-02-22)


### Features

* add LEFT_CHEEK_CENTER and RIGHT_CHEEK_CENTER FaceAnnotation Landmark Types ([#394](https://www.github.com/googleapis/java-vision/issues/394)) ([f760842](https://www.github.com/googleapis/java-vision/commit/f760842e6cbcfe6e370b26f630267fdc557a2687))
* **v1:** add TextDetectionParams.enable_text_detection_confidence_score ([#352](https://www.github.com/googleapis/java-vision/issues/352)) ([2d06685](https://www.github.com/googleapis/java-vision/commit/2d066858963a1f54a2d84071e452e276137d9848))
* **v1:** add TextDetectionParams.enable_text_detection_confidence_score to ImageContext proto so customer can optionally get confidence score for TEXT_DETECTION feature ([2d06685](https://www.github.com/googleapis/java-vision/commit/2d066858963a1f54a2d84071e452e276137d9848))


### Documentation

* generate sample code in the Java microgenerator ([f760842](https://www.github.com/googleapis/java-vision/commit/f760842e6cbcfe6e370b26f630267fdc557a2687))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.18.0 ([#371](https://www.github.com/googleapis/java-vision/issues/371)) ([c9dab62](https://www.github.com/googleapis/java-vision/commit/c9dab62a01cb0c02de0bd24aa268b0d8ee12127c))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.19.0 ([#406](https://www.github.com/googleapis/java-vision/issues/406)) ([c3d6e7b](https://www.github.com/googleapis/java-vision/commit/c3d6e7bd7e544cbf035c903648eb43ee7958d57f))

### [1.110.10](https://www.github.com/googleapis/java-vision/compare/v1.110.9...v1.110.10) (2021-01-06)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.17.0 ([#355](https://www.github.com/googleapis/java-vision/issues/355)) ([e2c2368](https://www.github.com/googleapis/java-vision/commit/e2c2368a5f70ed07fa0395724adb2d3bfb289edb))

### [1.110.9](https://www.github.com/googleapis/java-vision/compare/v1.110.8...v1.110.9) (2020-12-14)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.16.1 ([0b20413](https://www.github.com/googleapis/java-vision/commit/0b20413fb893d20dd63695acd73ef30e1df6b971))

### [1.110.8](https://www.github.com/googleapis/java-vision/compare/v1.110.7...v1.110.8) (2020-12-08)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.16.0 ([#336](https://www.github.com/googleapis/java-vision/issues/336)) ([248b2f2](https://www.github.com/googleapis/java-vision/commit/248b2f25fa4367bbbf089130dc82ea13eaf34737))

### [1.110.7](https://www.github.com/googleapis/java-vision/compare/v1.110.6...v1.110.7) (2020-11-17)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.15.0 ([#316](https://www.github.com/googleapis/java-vision/issues/316)) ([821aebb](https://www.github.com/googleapis/java-vision/commit/821aebb56def0c146b27b9b554d7df16e4f60b03))
* update dependency com.google.cloud:google-cloud-storage to v1.113.4 ([#315](https://www.github.com/googleapis/java-vision/issues/315)) ([c200d62](https://www.github.com/googleapis/java-vision/commit/c200d62a806cbd760d0df7d05620db153286e3ab))

### [1.110.6](https://www.github.com/googleapis/java-vision/compare/v1.110.5...v1.110.6) (2020-11-02)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.14.1 ([#299](https://www.github.com/googleapis/java-vision/issues/299)) ([a919694](https://www.github.com/googleapis/java-vision/commit/a919694fea44d79a730ffe8539de0ed1d51b0122))

### [1.110.5](https://www.github.com/googleapis/java-vision/compare/v1.110.4...v1.110.5) (2020-10-28)


### Dependencies

* update dependency com.google.cloud:google-cloud-storage to v1.113.2 ([#286](https://www.github.com/googleapis/java-vision/issues/286)) ([a57e234](https://www.github.com/googleapis/java-vision/commit/a57e234874bbcb808c5e9ac57e5baf23f736f8bd))

### [1.110.4](https://www.github.com/googleapis/java-vision/compare/v1.110.3...v1.110.4) (2020-10-22)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.13.0 ([#276](https://www.github.com/googleapis/java-vision/issues/276)) ([c71190f](https://www.github.com/googleapis/java-vision/commit/c71190fd2b6fe0cd4d5957ed9bbadf6395dff6ff))

### [1.110.3](https://www.github.com/googleapis/java-vision/compare/v1.110.2...v1.110.3) (2020-10-19)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.12.1 ([#266](https://www.github.com/googleapis/java-vision/issues/266)) ([d0f43cc](https://www.github.com/googleapis/java-vision/commit/d0f43cc79f2bd82bbe9407e018d2914f3272356f))

### [1.110.2](https://www.github.com/googleapis/java-vision/compare/v1.110.1...v1.110.2) (2020-10-08)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.10.2 ([#250](https://www.github.com/googleapis/java-vision/issues/250)) ([cdba42f](https://www.github.com/googleapis/java-vision/commit/cdba42f0eaecda366cd9599b1e51f0811c32266d))

### [1.110.1](https://www.github.com/googleapis/java-vision/compare/v1.110.0...v1.110.1) (2020-09-23)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.10.0 ([#238](https://www.github.com/googleapis/java-vision/issues/238)) ([42c943b](https://www.github.com/googleapis/java-vision/commit/42c943bf340e6ff497be82fcd2ad2e1495d1010f))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.9.0 ([#222](https://www.github.com/googleapis/java-vision/issues/222)) ([f9856ff](https://www.github.com/googleapis/java-vision/commit/f9856ff8bc070dea212e00664a9c10987a50163d))

## [1.100.0](https://www.github.com/googleapis/java-vision/compare/v1.99.3...v1.100.0) (2020-08-10)


### ⚠ BREAKING CHANGES

* **v1p3beta1,v1p4beta:** The breaking changes are as follows. After discussion please see this PR, these seem to be acceptable given that this is a beta API.
* **v1p3beta1,v1p4beta:** The breaking changes are as follows. After discussion please see [this PR](https://github.com/googleapis/gapic-generator/pull/3177), these seem to be acceptable given that this is a beta API.

### Features

* **deps:** adopt flatten plugin and google-cloud-shared-dependencies ([#172](https://www.github.com/googleapis/java-vision/issues/172)) ([6db89ba](https://www.github.com/googleapis/java-vision/commit/6db89bad7313b8508a596af169c2d22b9ff14d59))
* **v1p3beta1,v1p4beta:** breaking resource name changes ([#133](https://www.github.com/googleapis/java-vision/issues/133)) ([b966ca5](https://www.github.com/googleapis/java-vision/commit/b966ca53df480ddd4fb365903fe1464798955e5a))


### Bug Fixes

* migrate retry settings to grpc_service_config ([#171](https://www.github.com/googleapis/java-vision/issues/171)) ([e661954](https://www.github.com/googleapis/java-vision/commit/e66195445b36f6a87be77d6502dc33f123d32eb8))
* restore GAPIC v2 retry configs ([#140](https://www.github.com/googleapis/java-vision/issues/140)) ([b6ef0eb](https://www.github.com/googleapis/java-vision/commit/b6ef0ebad0e6db2cc9db06744417b9e2d98027a6))


### Dependencies

* update core dependencies ([#159](https://www.github.com/googleapis/java-vision/issues/159)) ([5efa57b](https://www.github.com/googleapis/java-vision/commit/5efa57b1daeb2a760dcca8cd3058e94386c414d5))
* update dependency com.google.api:api-common to v1.9.1 ([#147](https://www.github.com/googleapis/java-vision/issues/147)) ([c19a1fd](https://www.github.com/googleapis/java-vision/commit/c19a1fdc7ea5c1538d2f96e4b5b86798517317c9))
* update dependency com.google.api:api-common to v1.9.2 ([#152](https://www.github.com/googleapis/java-vision/issues/152)) ([2ad8ecf](https://www.github.com/googleapis/java-vision/commit/2ad8ecfdd46d8e17029cc4a490093bb6c1aeb2af))
* update dependency com.google.api.grpc:proto-google-common-protos to v1.18.0 ([#132](https://www.github.com/googleapis/java-vision/issues/132)) ([0903c75](https://www.github.com/googleapis/java-vision/commit/0903c7592112ecc6f157c8871f9526e69b965242))
* update dependency com.google.cloud:google-cloud-core to v1.93.5 ([#148](https://www.github.com/googleapis/java-vision/issues/148)) ([eb7bea0](https://www.github.com/googleapis/java-vision/commit/eb7bea0d29c5ab5a094dfa4e59cadd7c6fde0a7b))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.2 ([#184](https://www.github.com/googleapis/java-vision/issues/184)) ([baec0c2](https://www.github.com/googleapis/java-vision/commit/baec0c23972b7de002f5360f4d28876adcd6bd8b))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.6 ([671a8ce](https://www.github.com/googleapis/java-vision/commit/671a8cef44e50fd10330b2a8b7e8f9eab0311f07))
* update dependency com.google.guava:guava-bom to v29 ([#109](https://www.github.com/googleapis/java-vision/issues/109)) ([02771ae](https://www.github.com/googleapis/java-vision/commit/02771aef6fe28fb190b2775fa4a8c4b6f3a69ae1))
* update dependency com.google.protobuf:protobuf-java to v3.12.0 ([#138](https://www.github.com/googleapis/java-vision/issues/138)) ([93372b0](https://www.github.com/googleapis/java-vision/commit/93372b0e3608aa2d48ef21f142804919932e8687))
* update dependency com.google.protobuf:protobuf-java to v3.12.2 ([#146](https://www.github.com/googleapis/java-vision/issues/146)) ([05cbce1](https://www.github.com/googleapis/java-vision/commit/05cbce1fc881c878d37607d2926aeb5ece15d088))
* update dependency io.grpc:grpc-bom to v1.29.0 ([#124](https://www.github.com/googleapis/java-vision/issues/124)) ([cc5a244](https://www.github.com/googleapis/java-vision/commit/cc5a2445a92ce3c1782b5ed2272dc9f91b980686))
* update dependency io.grpc:grpc-bom to v1.30.0 ([#153](https://www.github.com/googleapis/java-vision/issues/153)) ([948d7b9](https://www.github.com/googleapis/java-vision/commit/948d7b92a066119f5c1ef00382f645e8f6568d25))
* update dependency org.threeten:threetenbp to v1.4.4 ([#126](https://www.github.com/googleapis/java-vision/issues/126)) ([5207f4d](https://www.github.com/googleapis/java-vision/commit/5207f4dc9aba330dc4f3219655631994a31c663d))

### [1.99.3](https://www.github.com/googleapis/java-vision/compare/v1.99.2...v1.99.3) (2020-04-07)


### Dependencies

* update core dependencies ([#78](https://www.github.com/googleapis/java-vision/issues/78)) ([716f3e4](https://www.github.com/googleapis/java-vision/commit/716f3e4e98c94407d808f5cf907036a5cb07e64d))
* update dependency com.google.api:api-common to v1.9.0 ([#93](https://www.github.com/googleapis/java-vision/issues/93)) ([1a9fd23](https://www.github.com/googleapis/java-vision/commit/1a9fd23278ae97aac7331ca1d69388a0f48f4365))
* update dependency org.threeten:threetenbp to v1.4.3 ([#86](https://www.github.com/googleapis/java-vision/issues/86)) ([587f530](https://www.github.com/googleapis/java-vision/commit/587f5301e363102006a93e6e57a848de0b3300e5))


### Documentation

* change a relative URL to an absolute URL to fix broken links. ([#99](https://www.github.com/googleapis/java-vision/issues/99)) ([485b00b](https://www.github.com/googleapis/java-vision/commit/485b00b915a479d3f58043d8df15a578f0c78ec5))

### [1.99.2](https://www.github.com/googleapis/java-vision/compare/v1.99.1...v1.99.2) (2020-03-09)


### Dependencies

* update core dependencies ([5a14054](https://www.github.com/googleapis/java-vision/commit/5a14054c2ca762b2e618888d72ca307e79f9a373))
* update core dependencies ([#43](https://www.github.com/googleapis/java-vision/issues/43)) ([8f1b53b](https://www.github.com/googleapis/java-vision/commit/8f1b53bc492cf5904e50c8b42824b0972e0a4fa9))
* update core dependencies ([#52](https://www.github.com/googleapis/java-vision/issues/52)) ([7ca9859](https://www.github.com/googleapis/java-vision/commit/7ca9859f3f3ba4eb64b9983265436e2ee7cc01c1))
* update core libraries ([#72](https://www.github.com/googleapis/java-vision/issues/72)) ([17eba7d](https://www.github.com/googleapis/java-vision/commit/17eba7d95f898f0ea82e3bab153db914263747f4))
* update dependency com.google.cloud:google-cloud-core to v1.93.1 ([#73](https://www.github.com/googleapis/java-vision/issues/73)) ([877c18f](https://www.github.com/googleapis/java-vision/commit/877c18f7e89dce10bc12dbe2645d1586e9e7d79a))
* update dependency com.google.guava:guava-bom to v28.2-android ([#36](https://www.github.com/googleapis/java-vision/issues/36)) ([077a270](https://www.github.com/googleapis/java-vision/commit/077a270bcae5f44bcbe55c176919e2b14f11a907))
* update dependency com.google.protobuf:protobuf-java to v3.11.3 ([#54](https://www.github.com/googleapis/java-vision/issues/54)) ([24cc931](https://www.github.com/googleapis/java-vision/commit/24cc93193be3f586f8998292db68da214f7c47b8))
* update dependency org.threeten:threetenbp to v1.4.1 ([812b893](https://www.github.com/googleapis/java-vision/commit/812b893666753e73f24ef0d2c33916df19cc5bf3))


### Documentation

* **regen:** regenerate v1p1beta1, v1p2beta1, v1p3beta1, v1p4beta1 clients with annotations ([#53](https://www.github.com/googleapis/java-vision/issues/53)) ([02e28c8](https://www.github.com/googleapis/java-vision/commit/02e28c84fc1930ffceb1a344c6d0bf9fd64b604a))
* **regen:** update sample code to set total timeout, add API client header test ([#56](https://www.github.com/googleapis/java-vision/issues/56)) ([8d4bff0](https://www.github.com/googleapis/java-vision/commit/8d4bff08005dd3e8a49bc4b5892373584ce46ab6))

### [1.99.1](https://www.github.com/googleapis/java-vision/compare/v1.99.0...v1.99.1) (2020-01-03)


### Dependencies

* update dependency com.google.protobuf:protobuf-java to v3.11.1 ([#23](https://www.github.com/googleapis/java-vision/issues/23)) ([0716a27](https://www.github.com/googleapis/java-vision/commit/0716a27f6e1f4b728f1f439976c08bbc9da91320))
* update dependency io.grpc:grpc-bom to v1.26.0 ([#32](https://www.github.com/googleapis/java-vision/issues/32)) ([a5dc67c](https://www.github.com/googleapis/java-vision/commit/a5dc67cdb126f83abc7e9bc3cb08dc54ac7ca008))
* update dependency junit:junit to v4.13 ([#37](https://www.github.com/googleapis/java-vision/issues/37)) ([5c45da1](https://www.github.com/googleapis/java-vision/commit/5c45da1b9e588cb5e4071cc02fd4df8eca17bac3))
* update gax.version to v1.51.0 ([#24](https://www.github.com/googleapis/java-vision/issues/24)) ([8445988](https://www.github.com/googleapis/java-vision/commit/8445988bf4d514c827326def363e53ac358bf176))
* update gax.version to v1.52.0 ([#27](https://www.github.com/googleapis/java-vision/issues/27)) ([284cc55](https://www.github.com/googleapis/java-vision/commit/284cc5562c97142903a98d94d94d017803f33c66))


### Documentation

* **regen:** updated docs from protoc update ([#26](https://www.github.com/googleapis/java-vision/issues/26)) ([f9132b6](https://www.github.com/googleapis/java-vision/commit/f9132b68596b5da42897042a12b70abb755080c0))

## [1.99.0](https://www.github.com/googleapis/java-vision/compare/v1.98.1...v1.99.0) (2019-11-14)


### Features

* add celebrity face detection to v1p4beta ([#13](https://www.github.com/googleapis/java-vision/issues/13)) ([3a869f7](https://www.github.com/googleapis/java-vision/commit/3a869f7c5af4e133fd644005c27e058d5f35b4d2))

### [1.98.1](https://www.github.com/googleapis/java-vision/compare/v1.98.0...v1.98.1) (2019-11-12)


### Dependencies

* update gax.version to v1.50.1 ([#9](https://www.github.com/googleapis/java-vision/issues/9)) ([96884d4](https://www.github.com/googleapis/java-vision/commit/96884d419aa5be9b497e8e2f649b47a8bbc26df3))

## [1.98.0](https://www.github.com/googleapis/java-vision/compare/1.97.0...v1.98.0) (2019-10-28)


### Features

* make repo releasable, add parent/bom ([#1](https://www.github.com/googleapis/java-vision/issues/1)) ([7f53533](https://www.github.com/googleapis/java-vision/commit/7f5353381cf8736ff009998d2fe3b5ab3ab038c0))


### Dependencies

* update dependency io.grpc:grpc-bom to v1.24.1 ([#3](https://www.github.com/googleapis/java-vision/issues/3)) ([9698eb0](https://www.github.com/googleapis/java-vision/commit/9698eb09d88aa456c8f78f1206434545b33ad37e))
* update gax.version to v1.49.1 ([#5](https://www.github.com/googleapis/java-vision/issues/5)) ([a69d547](https://www.github.com/googleapis/java-vision/commit/a69d5478cce9809c8ade083b7cd7369276eff509))
