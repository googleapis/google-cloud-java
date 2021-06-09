# Changelog

## [1.0.0](https://www.github.com/googleapis/java-aiplatform/compare/v0.4.1...v1.0.0) (2021-06-09)


### ⚠ BREAKING CHANGES

* remove display_name from FeatureStore

### Features

* add `gcf-owl-bot[bot]` to `ignoreAuthors` ([#362](https://www.github.com/googleapis/java-aiplatform/issues/362)) ([778f54a](https://www.github.com/googleapis/java-aiplatform/commit/778f54afcf852da2cdb371fc1b2303ce54589e02))
* add aiplatform API Vizier service ([fee522f](https://www.github.com/googleapis/java-aiplatform/commit/fee522f6184de7ae89c1cc471142fbab44116aff))
* add featurestore, index, metadata, monitoring, pipeline, and tensorboard services to aiplatform v1beta1 ([#341](https://www.github.com/googleapis/java-aiplatform/issues/341)) ([ca54151](https://www.github.com/googleapis/java-aiplatform/commit/ca541512ffd89f43d236eab8a657f7b8f4bade3d))
* add invalid_row_count to ImportFeatureValuesResponse and ImportFeatureValuesOperationMetadata ([d73ec5a](https://www.github.com/googleapis/java-aiplatform/commit/d73ec5afeb71ce752dbec975ac7562b92ef2ceef))
* adds enhanced protos for time series forecasting ([#356](https://www.github.com/googleapis/java-aiplatform/issues/356)) ([d73ec5a](https://www.github.com/googleapis/java-aiplatform/commit/d73ec5afeb71ce752dbec975ac7562b92ef2ceef))
* promote to 1.0.0 ([#402](https://www.github.com/googleapis/java-aiplatform/issues/402)) ([b22d40b](https://www.github.com/googleapis/java-aiplatform/commit/b22d40ba091698eb14ed9f421a8749ba62a1c6fd))
* remove unsupported accelerator types ([fee522f](https://www.github.com/googleapis/java-aiplatform/commit/fee522f6184de7ae89c1cc471142fbab44116aff))
* removes unneeded protos and files from v1beta1 ([#198](https://www.github.com/googleapis/java-aiplatform/issues/198)) ([5c0de9f](https://www.github.com/googleapis/java-aiplatform/commit/5c0de9f6ac27685170644f467610dc89d2f0e34b))


### Bug Fixes

* configuring timeouts for aiplatform v1 methods ([fee522f](https://www.github.com/googleapis/java-aiplatform/commit/fee522f6184de7ae89c1cc471142fbab44116aff))
* release scripts from issuing overlapping phases ([#245](https://www.github.com/googleapis/java-aiplatform/issues/245)) ([43ec06b](https://www.github.com/googleapis/java-aiplatform/commit/43ec06bd4809bc97dda6f5a913452381389541d1))
* remove display_name from FeatureStore ([d73ec5a](https://www.github.com/googleapis/java-aiplatform/commit/d73ec5afeb71ce752dbec975ac7562b92ef2ceef))


### Documentation

* changes product name to 'Vertex AI' ([#367](https://www.github.com/googleapis/java-aiplatform/issues/367)) ([0141e15](https://www.github.com/googleapis/java-aiplatform/commit/0141e15e6cdd0428d65ebd99842ee66fd917d627))
* changes product name to 'Vertex AI' ([#397](https://www.github.com/googleapis/java-aiplatform/issues/397)) ([348a87f](https://www.github.com/googleapis/java-aiplatform/commit/348a87fb714f7be84befe57d461857b0409a804f))
* correct link to fieldmask ([0141e15](https://www.github.com/googleapis/java-aiplatform/commit/0141e15e6cdd0428d65ebd99842ee66fd917d627))
* removes tinyurl links ([348a87f](https://www.github.com/googleapis/java-aiplatform/commit/348a87fb714f7be84befe57d461857b0409a804f))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.21.1 ([#253](https://www.github.com/googleapis/java-aiplatform/issues/253)) ([f8e020f](https://www.github.com/googleapis/java-aiplatform/commit/f8e020f7750511bfc3358dd44d465c03d9becf62))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1 ([#329](https://www.github.com/googleapis/java-aiplatform/issues/329)) ([591c274](https://www.github.com/googleapis/java-aiplatform/commit/591c274ff3ffca5e0d964148eaeebaca5551ecaa))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.1.0 ([#346](https://www.github.com/googleapis/java-aiplatform/issues/346)) ([d2aec6c](https://www.github.com/googleapis/java-aiplatform/commit/d2aec6c92e56362a5bfb2601dc1558bc081f3dae))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.2.0 ([#361](https://www.github.com/googleapis/java-aiplatform/issues/361)) ([e1506a8](https://www.github.com/googleapis/java-aiplatform/commit/e1506a804d82f1289c60a9d5056f20df1cd6c11f))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.3.0 ([#398](https://www.github.com/googleapis/java-aiplatform/issues/398)) ([dafca5d](https://www.github.com/googleapis/java-aiplatform/commit/dafca5d9fc1c0d77fc0c3f26c08c6827e53492a3))
* update dependency com.google.cloud:google-cloud-storage to v1.113.16 ([#334](https://www.github.com/googleapis/java-aiplatform/issues/334)) ([5659ceb](https://www.github.com/googleapis/java-aiplatform/commit/5659cebd87fd1ccd730a817049c05865b8ce240c))
* update dependency com.google.cloud:google-cloud-storage to v1.114.0 ([#349](https://www.github.com/googleapis/java-aiplatform/issues/349)) ([596eb79](https://www.github.com/googleapis/java-aiplatform/commit/596eb795a30cfe319daed0dde7492ea55b1737a2))
* update dependency com.google.cloud:google-cloud-storage to v1.115.0 ([#396](https://www.github.com/googleapis/java-aiplatform/issues/396)) ([8e2f7cc](https://www.github.com/googleapis/java-aiplatform/commit/8e2f7cc9b83fbd2f3cc326f1370b27d30cde636a))
* update dependency com.google.code.gson:gson to v2.8.7 ([#382](https://www.github.com/googleapis/java-aiplatform/issues/382)) ([90bfc56](https://www.github.com/googleapis/java-aiplatform/commit/90bfc56459cf1da02b9c6efde01791742b5e5161))

### [0.4.1](https://www.github.com/googleapis/java-aiplatform/compare/v0.4.0...v0.4.1) (2021-04-15)


### Dependencies

* update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.4.0 ([#210](https://www.github.com/googleapis/java-aiplatform/issues/210)) ([931c3bb](https://www.github.com/googleapis/java-aiplatform/commit/931c3bbfa9fa523a3152d2a9a885ae62b3fca65b))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.21.0 ([#227](https://www.github.com/googleapis/java-aiplatform/issues/227)) ([6be4f2c](https://www.github.com/googleapis/java-aiplatform/commit/6be4f2c5a69efa17a00db7664c2d4e772fb2d637))
* update dependency com.google.cloud:google-cloud-storage to v1.113.15 ([#232](https://www.github.com/googleapis/java-aiplatform/issues/232)) ([7f56ead](https://www.github.com/googleapis/java-aiplatform/commit/7f56ead94e1d6eeb605891c898c5051e0045fbdf))

## [0.4.0](https://www.github.com/googleapis/java-aiplatform/compare/v0.3.0...v0.4.0) (2021-03-12)


### Features

* add encryption_spec to aiplatform v1beta1 ([#176](https://www.github.com/googleapis/java-aiplatform/issues/176)) ([faff19b](https://www.github.com/googleapis/java-aiplatform/commit/faff19b2820146d6cf49525f49ae187449171641))


### Dependencies

* update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.3.0 ([#189](https://www.github.com/googleapis/java-aiplatform/issues/189)) ([5bdf3d0](https://www.github.com/googleapis/java-aiplatform/commit/5bdf3d04f365cb27446456e6df2a691ce1441434))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.20.1 ([#203](https://www.github.com/googleapis/java-aiplatform/issues/203)) ([761e878](https://www.github.com/googleapis/java-aiplatform/commit/761e878b02eb0268b16d1325749d399e66a487df))
* update dependency com.google.cloud:google-cloud-storage to v1.113.12 ([#186](https://www.github.com/googleapis/java-aiplatform/issues/186)) ([3fae117](https://www.github.com/googleapis/java-aiplatform/commit/3fae117a6c9d73d292b879c05ba849f0846af73d))
* update dependency com.google.cloud:google-cloud-storage to v1.113.14 ([#202](https://www.github.com/googleapis/java-aiplatform/issues/202)) ([767cf1d](https://www.github.com/googleapis/java-aiplatform/commit/767cf1d9624e65970f30094484bbc571bd8c858b))

## [0.3.0](https://www.github.com/googleapis/java-aiplatform/compare/v0.2.0...v0.3.0) (2021-02-26)


### Features

* add encryption_spec to aiplatform v1beta1  ([#167](https://www.github.com/googleapis/java-aiplatform/issues/167)) ([f1523a2](https://www.github.com/googleapis/java-aiplatform/commit/f1523a2be87331d2298d740da041eb5275fb4813))
* add encryption_spec to aiplatform v1beta1 ([#155](https://www.github.com/googleapis/java-aiplatform/issues/155)) ([fbeb273](https://www.github.com/googleapis/java-aiplatform/commit/fbeb273ac6e21ca01a39de3b4964cf28cc441efd))
* updates library for v1 service ([#157](https://www.github.com/googleapis/java-aiplatform/issues/157)) ([587b2fa](https://www.github.com/googleapis/java-aiplatform/commit/587b2fab293ca50fe42512569cf35997f9099269))


### Bug Fixes

* reduces image object detection test resource file size ([#154](https://www.github.com/googleapis/java-aiplatform/issues/154)) ([8cf8cc6](https://www.github.com/googleapis/java-aiplatform/commit/8cf8cc6b36e127c8dfdc9677906195c49065c7ea))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.18.0 ([#131](https://www.github.com/googleapis/java-aiplatform/issues/131)) ([d56e6ab](https://www.github.com/googleapis/java-aiplatform/commit/d56e6ab0c7022ef508c96ba04330b1926a08088d))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.19.0 ([#172](https://www.github.com/googleapis/java-aiplatform/issues/172)) ([871e976](https://www.github.com/googleapis/java-aiplatform/commit/871e9761e560b2220d9e3611f48d58c0091b966e))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.20.0 ([#184](https://www.github.com/googleapis/java-aiplatform/issues/184)) ([e79f59d](https://www.github.com/googleapis/java-aiplatform/commit/e79f59d4d46b7193eed00032b349b86c14213825))
* update dependency com.google.cloud:google-cloud-storage to v1.113.10 ([#164](https://www.github.com/googleapis/java-aiplatform/issues/164)) ([c49ac84](https://www.github.com/googleapis/java-aiplatform/commit/c49ac8463d342c141cf59af5c19f1ef7f28fd8a5))
* update dependency com.google.cloud:google-cloud-storage to v1.113.11 ([#175](https://www.github.com/googleapis/java-aiplatform/issues/175)) ([74efed2](https://www.github.com/googleapis/java-aiplatform/commit/74efed25aba13f526b3745baeb9b1146c3a6c357))
* update dependency com.google.cloud:google-cloud-storage to v1.113.9 ([#132](https://www.github.com/googleapis/java-aiplatform/issues/132)) ([bc8826a](https://www.github.com/googleapis/java-aiplatform/commit/bc8826aea48191fea3a2a392f2beaaa192edc777))


### Documentation

* updates prediction to new hostname ([#173](https://www.github.com/googleapis/java-aiplatform/issues/173)) ([ea1afeb](https://www.github.com/googleapis/java-aiplatform/commit/ea1afeba05cc830a30c27032e8b71b270183656e))

## [0.2.0](https://www.github.com/googleapis/java-aiplatform/compare/v0.1.0...v0.2.0) (2021-01-07)


### Features

* add enhanced types for library ([#74](https://www.github.com/googleapis/java-aiplatform/issues/74)) ([7835807](https://www.github.com/googleapis/java-aiplatform/commit/783580731c9699266ca79b0ed50b035696921abf))
* adds ValueConverter utility and demo samples ([#108](https://www.github.com/googleapis/java-aiplatform/issues/108)) ([cf0b763](https://www.github.com/googleapis/java-aiplatform/commit/cf0b763ab3c43449090b4621a8f7e9a97ada4bc6))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.16.0 ([#102](https://www.github.com/googleapis/java-aiplatform/issues/102)) ([f0145cd](https://www.github.com/googleapis/java-aiplatform/commit/f0145cd5c32f961ae2e8c9eb688c37ed5722eaeb))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.16.1 ([#113](https://www.github.com/googleapis/java-aiplatform/issues/113)) ([e2d8e42](https://www.github.com/googleapis/java-aiplatform/commit/e2d8e42b9237f7a7c22826101f05c58bc26e2923))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.17.0 ([#116](https://www.github.com/googleapis/java-aiplatform/issues/116)) ([f8a115a](https://www.github.com/googleapis/java-aiplatform/commit/f8a115a4ea2423bd9d39e79a6d55d5e253bf763e))

## 0.1.0 (2020-11-12)


### ⚠ BREAKING CHANGES

* sampled_shapley_attribution moved into a oneof in explanation.proto. field min renamed to min_value in ExplanationMetadata.InputMetadata.FeatureValueDomain in explanation_metadata.proto. field max renamed to max_value in ExplanationMetadata.InputMetadata.FeatureValueDomain in explanation_metadata.proto.

### Features

* aiplatform v1beta1 regeneration  ([#43](https://www.github.com/googleapis/java-aiplatform/issues/43)) ([64b027c](https://www.github.com/googleapis/java-aiplatform/commit/64b027cbcd51995c87fc530909fde799d52789dc))
* initial code generation ([a5494b0](https://www.github.com/googleapis/java-aiplatform/commit/a5494b0e45f6e1eef50ce80fa3482d8e5afc58dd))


### Documentation

* fix generated typos ([#49](https://www.github.com/googleapis/java-aiplatform/issues/49)) ([bbb67ad](https://www.github.com/googleapis/java-aiplatform/commit/bbb67ada1eddc0c7ca34080a70c3fc8da58ac481))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.10.0 ([#3](https://www.github.com/googleapis/java-aiplatform/issues/3)) ([ac5f6f7](https://www.github.com/googleapis/java-aiplatform/commit/ac5f6f79a3baf0cf3d1058d17758b21a87b3793b))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.10.2 ([#28](https://www.github.com/googleapis/java-aiplatform/issues/28)) ([ddcc914](https://www.github.com/googleapis/java-aiplatform/commit/ddcc914bd66bbef724ebf4af54aca0be3bee9b06))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.12.1 ([#32](https://www.github.com/googleapis/java-aiplatform/issues/32)) ([ee6a621](https://www.github.com/googleapis/java-aiplatform/commit/ee6a6217770b73ae3c9d230f02c978b83d419323))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.13.0 ([#34](https://www.github.com/googleapis/java-aiplatform/issues/34)) ([3de26d4](https://www.github.com/googleapis/java-aiplatform/commit/3de26d48b297f1bb7229a9ed3ca4edd4d66473cb))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.14.1 ([#42](https://www.github.com/googleapis/java-aiplatform/issues/42)) ([d550f43](https://www.github.com/googleapis/java-aiplatform/commit/d550f436bbd6dec93357d8b9647829ddd90a50dc))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.15.0 ([#56](https://www.github.com/googleapis/java-aiplatform/issues/56)) ([270c331](https://www.github.com/googleapis/java-aiplatform/commit/270c331619d30447b48d1e7216bfc2a5a7c4599b))
* update dependency com.google.cloud:google-cloud-storage to v1.113.2 ([#38](https://www.github.com/googleapis/java-aiplatform/issues/38)) ([b3a04e1](https://www.github.com/googleapis/java-aiplatform/commit/b3a04e135aee8415d4d67d6967273bace0991a64))
