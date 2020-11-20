# Changelog

### [1.105.2](https://www.github.com/googleapis/java-datastore/compare/v1.105.1...v1.105.2) (2020-11-20)


### Dependencies

* update dependency com.google.oauth-client:google-oauth-client to v1.31.2 ([#265](https://www.github.com/googleapis/java-datastore/issues/265)) ([3f165c7](https://www.github.com/googleapis/java-datastore/commit/3f165c7843b7241340eae8e9ad391357e36df237))

### [1.105.1](https://www.github.com/googleapis/java-datastore/compare/v1.105.0...v1.105.1) (2020-11-16)


### Documentation

* update google cloud libraries-bom ([#236](https://www.github.com/googleapis/java-datastore/issues/236)) ([7325fa0](https://www.github.com/googleapis/java-datastore/commit/7325fa0ba489efe31a58f64c2d3e2b55cd156822))
* update libraries-bom ([#220](https://www.github.com/googleapis/java-datastore/issues/220)) ([593fc66](https://www.github.com/googleapis/java-datastore/commit/593fc662e11ea446cd3fc7864cfa9a1b75480fba))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.13.0 ([#243](https://www.github.com/googleapis/java-datastore/issues/243)) ([d275db8](https://www.github.com/googleapis/java-datastore/commit/d275db8e3f14783acfebb9dff7347a871dcd9727))
* update dependency com.google.oauth-client:google-oauth-client to v1.31.1 ([#244](https://www.github.com/googleapis/java-datastore/issues/244)) ([b984e36](https://www.github.com/googleapis/java-datastore/commit/b984e360ccaf30f55b239f831430256f3231036f))
* update google-cloud-shared-dependencies to 0.15.0 ([#259](https://www.github.com/googleapis/java-datastore/issues/259)) ([d6c68e7](https://www.github.com/googleapis/java-datastore/commit/d6c68e7e09f5e5728f2f082d5e95503df04a2ec2))

## [1.105.0](https://www.github.com/googleapis/java-datastore/compare/v1.104.0...v1.105.0) (2020-09-01)


### Features

* **deps:** adopt flatten plugin and google-cloud-shared-dependencies ([#174](https://www.github.com/googleapis/java-datastore/issues/174)) ([8618c18](https://www.github.com/googleapis/java-datastore/commit/8618c1848e71424fa164fee9d8b7b53641b6b823))


### Bug Fixes

* query result start with startCursor if specified ([#207](https://www.github.com/googleapis/java-datastore/issues/207)) ([023229a](https://www.github.com/googleapis/java-datastore/commit/023229a15edbbe773bd03410ed0784aba248ad6e))


### Dependencies

* remove direct declaration of google-auth-library-oauth2-http ([#184](https://www.github.com/googleapis/java-datastore/issues/184)) ([4fa4df4](https://www.github.com/googleapis/java-datastore/commit/4fa4df40d63d7fbce023d6231830dcc296c29dd1))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.2 ([#187](https://www.github.com/googleapis/java-datastore/issues/187)) ([941bea0](https://www.github.com/googleapis/java-datastore/commit/941bea016f1ce4e1c1fd027b1671f950e9c52160))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.3 ([#191](https://www.github.com/googleapis/java-datastore/issues/191)) ([a89eb08](https://www.github.com/googleapis/java-datastore/commit/a89eb08be1cd9689d38b8b67c472cc928e3549c1))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.4 ([#196](https://www.github.com/googleapis/java-datastore/issues/196)) ([7214e0a](https://www.github.com/googleapis/java-datastore/commit/7214e0ae224633e2effc023d10494e0164a8f9dc))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.6 ([#199](https://www.github.com/googleapis/java-datastore/issues/199)) ([6a959d3](https://www.github.com/googleapis/java-datastore/commit/6a959d3f7ca75ba5da1d1c4cb509593d3be39e98))
* update dependency com.google.oauth-client:google-oauth-client to v1.31.0 ([#186](https://www.github.com/googleapis/java-datastore/issues/186)) ([16bfb9a](https://www.github.com/googleapis/java-datastore/commit/16bfb9a0127f4969a796ad95cc11cf2b8b92d0f3))


### Documentation

* libraries-bom 8.1.0 ([#200](https://www.github.com/googleapis/java-datastore/issues/200)) ([9425972](https://www.github.com/googleapis/java-datastore/commit/9425972905d1e370192eeb3bbfe837f5a7fb25cf))
* update libraries-bom ([#211](https://www.github.com/googleapis/java-datastore/issues/211)) ([9407c4a](https://www.github.com/googleapis/java-datastore/commit/9407c4afec3de6e18c96c24872269e61c8ad40fb))

## [1.104.0](https://www.github.com/googleapis/java-datastore/compare/v1.103.0...v1.104.0) (2020-06-17)


### Features

* add opencensus tracing/stats support for Datastore RPC operations ([#130](https://www.github.com/googleapis/java-datastore/issues/130)) ([5aee52f](https://www.github.com/googleapis/java-datastore/commit/5aee52f5013d6780e523e0c6d7d00a1826b83b9b))
* add support to customize gcloud command of LocalDatastoreHelper ([#137](https://www.github.com/googleapis/java-datastore/issues/137)) ([976d979](https://www.github.com/googleapis/java-datastore/commit/976d9791572117dc703d8d7d6963bdd6603ecd63))


### Bug Fixes

* fix version number in changelog to correctly reflect what was released to maven central ([#145](https://www.github.com/googleapis/java-datastore/issues/145)) ([c509a2a](https://www.github.com/googleapis/java-datastore/commit/c509a2a4229f864edef8681677d73f3c7be1101f))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.0 ([#161](https://www.github.com/googleapis/java-datastore/issues/161)) ([39c8d72](https://www.github.com/googleapis/java-datastore/commit/39c8d723b318d08ca494b71167eaa80b1df6423d))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.1 ([#163](https://www.github.com/googleapis/java-datastore/issues/163)) ([7bfa07e](https://www.github.com/googleapis/java-datastore/commit/7bfa07eb3a7cf84fcf3e19f6a33914162fa28499))

## [1.103.0](https://www.github.com/googleapis/java-datastore/compare/v1.102.4...v1.103.0) (2020-06-02)


### Features

* add flatten plugin to client and proto modules ([#108](https://www.github.com/googleapis/java-datastore/issues/108)) ([fb3566d](https://www.github.com/googleapis/java-datastore/commit/fb3566d31600b9ed629a2daa46c5202a894181b2))
* Create CODEOWNERS ([#122](https://www.github.com/googleapis/java-datastore/issues/122)) ([8082369](https://www.github.com/googleapis/java-datastore/commit/80823698416bbe08e2d22fbc81ec3709ad2552c8))
* implement google-cloud-shared-dependencies BOM ([#135](https://www.github.com/googleapis/java-datastore/issues/135)) ([72e29ff](https://www.github.com/googleapis/java-datastore/commit/72e29ff3460b12436e76d445aad7b8ae0e4ee82d))


### Bug Fixes

* update retry logic for operations that can be associated with a transaction ([#144](https://www.github.com/googleapis/java-datastore/issues/144)) ([82ee74e](https://www.github.com/googleapis/java-datastore/commit/82ee74ed4487f90f97856bc766edb53b66474378))


### Dependencies

* bump shared-deps version and add back certain test deps ([#139](https://www.github.com/googleapis/java-datastore/issues/139)) ([660f216](https://www.github.com/googleapis/java-datastore/commit/660f216302fedaf2f5fe0f4c76cdab8fca65cbd1))
* update core transport dependencies to v1.35.0 ([#114](https://www.github.com/googleapis/java-datastore/issues/114)) ([cad3bfb](https://www.github.com/googleapis/java-datastore/commit/cad3bfbbe739ab3ed5ebea89bee620ef8bbefd95))
* update dependency com.google.api.grpc:proto-google-common-protos to v1.18.0 ([#117](https://www.github.com/googleapis/java-datastore/issues/117)) ([b484256](https://www.github.com/googleapis/java-datastore/commit/b484256c30ac9117eb82688c801966b6ace856df))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.6.0 ([#140](https://www.github.com/googleapis/java-datastore/issues/140)) ([712779c](https://www.github.com/googleapis/java-datastore/commit/712779c4a25bd5f74b9557931a84bd4a812279c7))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.7.0 ([#142](https://www.github.com/googleapis/java-datastore/issues/142)) ([e1a5a65](https://www.github.com/googleapis/java-datastore/commit/e1a5a65d2ae2d45c4871e3e7b2e9089ad5cdc542))
* update dependency com.google.guava:guava-bom to v29 ([#95](https://www.github.com/googleapis/java-datastore/issues/95)) ([32d5e37](https://www.github.com/googleapis/java-datastore/commit/32d5e37f244969ba980cd94a8eaa8165b368ebc6))
* update dependency com.google.protobuf:protobuf-java to v3.12.0 ([#127](https://www.github.com/googleapis/java-datastore/issues/127)) ([8a310f3](https://www.github.com/googleapis/java-datastore/commit/8a310f313e53fac802ca75ea539fc4656337c6ee))
* update dependency io.grpc:grpc-bom to v1.29.0 ([#110](https://www.github.com/googleapis/java-datastore/issues/110)) ([ad6b880](https://www.github.com/googleapis/java-datastore/commit/ad6b8803d4cd55fa37ba57fd3edafad256c41aed))
* update dependency org.threeten:threetenbp to v1.4.4 ([#112](https://www.github.com/googleapis/java-datastore/issues/112)) ([41d571d](https://www.github.com/googleapis/java-datastore/commit/41d571d1e18f1400f7975a6e82646417ed39ee84))


### Documentation

* fix java doc link of LocalDatastoreHelper#stop ([#126](https://www.github.com/googleapis/java-datastore/issues/126)) ([ed9b895](https://www.github.com/googleapis/java-datastore/commit/ed9b895d57db302a731e38bc6708310baa69cd67))
* update CONTRIBUTING.md to include code formatting ([#534](https://www.github.com/googleapis/java-datastore/issues/534)) ([#124](https://www.github.com/googleapis/java-datastore/issues/124)) ([147197d](https://www.github.com/googleapis/java-datastore/commit/147197d0655a509a11f906e95d5f81d57193c562))

### [1.101.4](https://www.github.com/googleapis/java-datastore/compare/v1.101.3...v1.101.4) (2020-04-08)


### Dependencies

* update core dependencies ([#64](https://www.github.com/googleapis/java-datastore/issues/64)) ([ce0fd11](https://www.github.com/googleapis/java-datastore/commit/ce0fd116dbc5de69ae4526d95cd8014eaf2da1a0))
* update core dependencies ([#86](https://www.github.com/googleapis/java-datastore/issues/86)) ([8394595](https://www.github.com/googleapis/java-datastore/commit/83945955b6bc6f915d321d190a2b6349fa52b597))
* update core dependencies to v1.93.3 ([#67](https://www.github.com/googleapis/java-datastore/issues/67)) ([3286a38](https://www.github.com/googleapis/java-datastore/commit/3286a38b3f4176f0b83a9a4230fba2c431c86047))
* update core dependencies to v1.93.4 ([#90](https://www.github.com/googleapis/java-datastore/issues/90)) ([9707cd4](https://www.github.com/googleapis/java-datastore/commit/9707cd41ac0b43bee048bb2386ab2484ced0e57b))
* update dependency com.google.api:api-common to v1.9.0 ([#80](https://www.github.com/googleapis/java-datastore/issues/80)) ([ce0726b](https://www.github.com/googleapis/java-datastore/commit/ce0726ba9ded67f48c4c11403f4f59b0dc30a5b7))
* update dependency com.google.api:gax-bom to v1.55.0 ([#83](https://www.github.com/googleapis/java-datastore/issues/83)) ([b67b962](https://www.github.com/googleapis/java-datastore/commit/b67b962d0883433ae9aea909886aa5b5d988e78c))
* update dependency com.google.cloud.samples:shared-configuration to v1.0.13 ([#76](https://www.github.com/googleapis/java-datastore/issues/76)) ([1ecf942](https://www.github.com/googleapis/java-datastore/commit/1ecf942228f963b947732381e44b0a25a4d24d6b))
* update dependency com.google.oauth-client:google-oauth-client to v1.30.6 ([#60](https://www.github.com/googleapis/java-datastore/issues/60)) ([e355d0f](https://www.github.com/googleapis/java-datastore/commit/e355d0f8ac86601099d8d3570f786d5a3880b968))
* update dependency org.threeten:threetenbp to v1.4.2 ([#73](https://www.github.com/googleapis/java-datastore/issues/73)) ([13c867a](https://www.github.com/googleapis/java-datastore/commit/13c867a4135ae024d0eb6af602ee50daf8ad30ff))
* update dependency org.threeten:threetenbp to v1.4.3 ([#88](https://www.github.com/googleapis/java-datastore/issues/88)) ([75a7254](https://www.github.com/googleapis/java-datastore/commit/75a7254a65e1d97a7bc8fae0f812ffebea060b60))

### [1.101.3](https://www.github.com/googleapis/java-datastore/compare/v1.101.2...v1.101.3) (2020-02-28)


### Bug Fixes

* flakey ITDatastoreTest#testSkippedResults ([#46](https://www.github.com/googleapis/java-datastore/issues/46)) ([3035ef2](https://www.github.com/googleapis/java-datastore/commit/3035ef2b6bf659bc847c4cf0a963a1f3badd68c7)), closes [#18](https://www.github.com/googleapis/java-datastore/issues/18)


### Dependencies

* update core dependencies ([#57](https://www.github.com/googleapis/java-datastore/issues/57)) ([34e94b1](https://www.github.com/googleapis/java-datastore/commit/34e94b15c670aea011503e8b6835301959ac0152))
* update core transport dependencies to v1.34.2 ([#44](https://www.github.com/googleapis/java-datastore/issues/44)) ([42e7e63](https://www.github.com/googleapis/java-datastore/commit/42e7e6349ac9a6ae9134f2bd1149a50f498a917e))
* update dependency com.google.protobuf:protobuf-java to v3.11.4 ([#48](https://www.github.com/googleapis/java-datastore/issues/48)) ([f78d0bd](https://www.github.com/googleapis/java-datastore/commit/f78d0bda15cce4e9639c582beab45a58d19d2a38))
* update dependency io.grpc:grpc-bom to v1.27.1 ([#45](https://www.github.com/googleapis/java-datastore/issues/45)) ([ef6ca5b](https://www.github.com/googleapis/java-datastore/commit/ef6ca5bb0dc7311253980d5bbef2d88a510d85cc))
* update dependency io.grpc:grpc-bom to v1.27.2 ([#55](https://www.github.com/googleapis/java-datastore/issues/55)) ([dea7ec2](https://www.github.com/googleapis/java-datastore/commit/dea7ec20c603be9890f06a78fa17396299232a20))
* update truth 1.0 -> 1.0.1 ([#58](https://www.github.com/googleapis/java-datastore/issues/58)) ([2af29c5](https://www.github.com/googleapis/java-datastore/commit/2af29c5c5fb13921f79e6b8b68fff0c82be29402))

### [1.101.2](https://www.github.com/googleapis/java-datastore/compare/v1.101.1...v1.101.2) (2020-02-13)


### Bug Fixes

* bom version tag miss configured ([#42](https://www.github.com/googleapis/java-datastore/issues/42)) ([6af084f](https://www.github.com/googleapis/java-datastore/commit/6af084face9afa7ee1fa8dec2a96419e7f4db706))

### [1.101.1](https://www.github.com/googleapis/java-datastore/compare/1.101.0...v1.101.1) (2020-02-11)


### Bug Fixes

* remove error_prone_annotations exclusion rules from poms ([#31](https://www.github.com/googleapis/java-datastore/issues/31)) ([b659cfa](https://www.github.com/googleapis/java-datastore/commit/b659cfa6992f6327b4b0d9f0414d51c4a70d8557))
* remove temporary added animal-sniffer-annotations exclusion rule from pom ([#16](https://www.github.com/googleapis/java-datastore/issues/16)) ([fde0a9f](https://www.github.com/googleapis/java-datastore/commit/fde0a9fcf38c74143b896a6e6b282047d7dadb6f)), closes [#3](https://www.github.com/googleapis/java-datastore/issues/3)


### Dependencies

* update core dependencies ([4481c27](https://www.github.com/googleapis/java-datastore/commit/4481c27e941b6ba17b69bc84ab4ae700d57ac92f))
* update core dependencies to v1.92.5 ([#36](https://www.github.com/googleapis/java-datastore/issues/36)) ([028b669](https://www.github.com/googleapis/java-datastore/commit/028b6690ba4b75aa0691f7b999792f333fea1d8d))
* update dependency com.google.cloud:google-cloud-shared-config to v0.4.0 ([#25](https://www.github.com/googleapis/java-datastore/issues/25)) ([657c69b](https://www.github.com/googleapis/java-datastore/commit/657c69bab7296c57575c24e96b208427e6791d1f))
* update dependency com.google.protobuf:protobuf-java to v3.11.3 ([#32](https://www.github.com/googleapis/java-datastore/issues/32)) ([6b3a930](https://www.github.com/googleapis/java-datastore/commit/6b3a930e0ed9c389ce5bedbf33dcd7a0a40227d3))
* update dependency junit:junit to v4.13 ([#13](https://www.github.com/googleapis/java-datastore/issues/13)) ([174158b](https://www.github.com/googleapis/java-datastore/commit/174158bac4fad21563fdd209b39e377c48bd8efe))
* update dependency org.threeten:threetenbp to v1.4.1 ([#28](https://www.github.com/googleapis/java-datastore/issues/28)) ([d6d74a1](https://www.github.com/googleapis/java-datastore/commit/d6d74a19e735e55ccf84dc5f0961f44cd71fc183))
