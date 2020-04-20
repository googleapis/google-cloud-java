# Changelog

## [0.120.0](https://www.github.com/googleapis/java-containeranalysis/compare/v0.119.2...v0.120.0) (2020-04-20)


### ⚠ BREAKING CHANGES

* This is binary breaking change as the method signatures for the IAM methods have been relaxed from IamResourceName to com.google.api.resourcenames.ResourceName (its parent).

### Features

* switch to ResourceName for IAM methods ([#125](https://www.github.com/googleapis/java-containeranalysis/issues/125)) ([3946bd5](https://www.github.com/googleapis/java-containeranalysis/commit/3946bd5e5787bd2f8c3933b00c386b854def2f8b))


### Dependencies

* update core dependencies ([#87](https://www.github.com/googleapis/java-containeranalysis/issues/87)) ([3abbb33](https://www.github.com/googleapis/java-containeranalysis/commit/3abbb334894c342874d77d2b316f89869ab492c7))
* update dependency com.google.api:api-common to v1.9.0 ([#106](https://www.github.com/googleapis/java-containeranalysis/issues/106)) ([af917ba](https://www.github.com/googleapis/java-containeranalysis/commit/af917ba80ee61970d2e682b20fd344f087181479))
* update dependency com.google.guava:guava-bom to v29 ([#119](https://www.github.com/googleapis/java-containeranalysis/issues/119)) ([e620ae3](https://www.github.com/googleapis/java-containeranalysis/commit/e620ae3385573a6780f2b0433209645afbce2f85))
* update dependency io.grafeas:grafeas to v0.24.1 ([#115](https://www.github.com/googleapis/java-containeranalysis/issues/115)) ([53d1a94](https://www.github.com/googleapis/java-containeranalysis/commit/53d1a94f3944ca396378cfaffdc7eb7d18f4a577))
* update dependency org.threeten:threetenbp to v1.4.3 ([#96](https://www.github.com/googleapis/java-containeranalysis/issues/96)) ([3056889](https://www.github.com/googleapis/java-containeranalysis/commit/3056889586566e2f72025cf4072b8516151f1381))

### [0.119.2](https://www.github.com/googleapis/java-containeranalysis/compare/v0.119.1...v0.119.2) (2020-03-11)


### Bug Fixes

* undeprecate resource name classes until multi-pattern resources are available ([#81](https://www.github.com/googleapis/java-containeranalysis/issues/81)) ([552f4dd](https://www.github.com/googleapis/java-containeranalysis/commit/552f4dd67ea0de9c9994b3eb7d2e8cf4be5f9c8c))


### Dependencies

* update core dependencies to v1.54.0 ([#78](https://www.github.com/googleapis/java-containeranalysis/issues/78)) ([073714c](https://www.github.com/googleapis/java-containeranalysis/commit/073714c2f9d603adf1c044c5c0733ab5fb3a03c7))
* update dependency com.google.protobuf:protobuf-java to v3.11.4 ([6ebbfc3](https://www.github.com/googleapis/java-containeranalysis/commit/6ebbfc37cdfdd774feee4976d55649c427a5fb94))
* update dependency com.google.protobuf:protobuf-java-util to v3.11.4 ([#69](https://www.github.com/googleapis/java-containeranalysis/issues/69)) ([0c9c542](https://www.github.com/googleapis/java-containeranalysis/commit/0c9c542b68792ba7eff9c6bc791d1a6c62452cbb))
* update dependency io.grpc:grpc-bom to v1.27.1 ([d853e83](https://www.github.com/googleapis/java-containeranalysis/commit/d853e83c8b8ffc992dbb429683d38dd3076d34d2))
* update dependency io.grpc:grpc-bom to v1.27.2 ([113bc0c](https://www.github.com/googleapis/java-containeranalysis/commit/113bc0c54f42f8daad400e2950677ce746504d79))
* update java-core ([#80](https://www.github.com/googleapis/java-containeranalysis/issues/80)) ([b9f172e](https://www.github.com/googleapis/java-containeranalysis/commit/b9f172ea97845c74d06c2eb039f09a7e7a9ed006))


### Documentation

* **regen:** update sample code to set total timeout, add API client header test ([8966c44](https://www.github.com/googleapis/java-containeranalysis/commit/8966c449b68dbfee7935873b3b29b35b87324e02))

### [0.119.1](https://www.github.com/googleapis/java-containeranalysis/compare/v0.119.0...v0.119.1) (2020-02-04)


### Dependencies

* update core dependencies ([#46](https://www.github.com/googleapis/java-containeranalysis/issues/46)) ([2859125](https://www.github.com/googleapis/java-containeranalysis/commit/285912557f79306dbc9d79afe1f6c48f0ee51794))
* update core dependencies to v1.53.1 ([#57](https://www.github.com/googleapis/java-containeranalysis/issues/57)) ([b315e5e](https://www.github.com/googleapis/java-containeranalysis/commit/b315e5e6671253e6a55f0b763cffef18633b120b))
* update dependency com.google.guava:guava-bom to v28.2-android ([#35](https://www.github.com/googleapis/java-containeranalysis/issues/35)) ([46ccda8](https://www.github.com/googleapis/java-containeranalysis/commit/46ccda8e7d9427fd2cc4d96a1d52b67354eb2129))
* update dependency com.google.protobuf:protobuf-java to v3.11.3 ([#59](https://www.github.com/googleapis/java-containeranalysis/issues/59)) ([9ddc63f](https://www.github.com/googleapis/java-containeranalysis/commit/9ddc63f902a54874a767adebb385447b6671f226))
* update dependency com.google.protobuf:protobuf-java-util to v3.11.3 ([#60](https://www.github.com/googleapis/java-containeranalysis/issues/60)) ([39d14f8](https://www.github.com/googleapis/java-containeranalysis/commit/39d14f813d1793afed56b5bcad4e27008d25b283))
* update dependency io.grafeas:grafeas to v0.24.0 ([#47](https://www.github.com/googleapis/java-containeranalysis/issues/47)) ([fb2541b](https://www.github.com/googleapis/java-containeranalysis/commit/fb2541b39aa05afd2adae7b77140b6e770ec88de))
* update dependency org.threeten:threetenbp to v1.4.1 ([ea0bfd3](https://www.github.com/googleapis/java-containeranalysis/commit/ea0bfd38b8192fd7ab3e90a069e42679dc5d3ba1))


### Documentation

* **regen:** updated required field documentation for v1beta1 client ([#55](https://www.github.com/googleapis/java-containeranalysis/issues/55)) ([cd9330a](https://www.github.com/googleapis/java-containeranalysis/commit/cd9330af20e3ae09865cdef0c33eaa71908b22e9))

## [0.119.0](https://www.github.com/googleapis/java-containeranalysis/compare/v0.118.0...v0.119.0) (2020-01-07)


### Features

* add WindowsDetail to v1beta1 vulnerability ([#31](https://www.github.com/googleapis/java-containeranalysis/issues/31)) ([450696d](https://www.github.com/googleapis/java-containeranalysis/commit/450696d16a94aae7ab3f24678bfbee5ae103d3e7))


### Dependencies

* update dependency io.grpc:grpc-bom to v1.26.0 ([fc2d3ca](https://www.github.com/googleapis/java-containeranalysis/commit/fc2d3ca0d8eb0fb31ade4a6f941006f01e8b796e))
* update gax.version to v1.52.0 ([#25](https://www.github.com/googleapis/java-containeranalysis/issues/25)) ([736032b](https://www.github.com/googleapis/java-containeranalysis/commit/736032b0fd5ad313336bf7eb5dc60ec32e199160))


### Documentation

* **regen:** updated docs from protoc update ([#24](https://www.github.com/googleapis/java-containeranalysis/issues/24)) ([bbbd3a2](https://www.github.com/googleapis/java-containeranalysis/commit/bbbd3a2c53832b42c56e478f376db170e2afe975))

## [0.118.0](https://www.github.com/googleapis/java-containeranalysis/compare/0.117.0...v0.118.0) (2019-12-05)


### Features

* make repo releasable, add parent/bom ([#1](https://www.github.com/googleapis/java-containeranalysis/issues/1)) ([94539e1](https://www.github.com/googleapis/java-containeranalysis/commit/94539e1d7353578c974d460373cdec891472d769))


### Dependencies

* update dependency io.grafeas:grafeas to v0.21.0 ([#8](https://www.github.com/googleapis/java-containeranalysis/issues/8)) ([7372e8d](https://www.github.com/googleapis/java-containeranalysis/commit/7372e8dad9d55fb4fb6d0729a117fbb1bcd02faf))
* update dependency io.grafeas:grafeas to v0.22.0 ([#12](https://www.github.com/googleapis/java-containeranalysis/issues/12)) ([327ee1f](https://www.github.com/googleapis/java-containeranalysis/commit/327ee1f120d000854889e6af7c68e5d4a63740ce))
* update dependency io.grafeas:grafeas to v0.23.0 ([#22](https://www.github.com/googleapis/java-containeranalysis/issues/22)) ([0229bfa](https://www.github.com/googleapis/java-containeranalysis/commit/0229bfaada79bc95726052e7e748e785b85e5fe3))
* update gax.version to v1.51.0 ([#19](https://www.github.com/googleapis/java-containeranalysis/issues/19)) ([25fa0cf](https://www.github.com/googleapis/java-containeranalysis/commit/25fa0cff6491f0f2632f7ce336422b05a44741d0))
* update protobuf packages to v3.11.1 ([#18](https://www.github.com/googleapis/java-containeranalysis/issues/18)) ([af06d1f](https://www.github.com/googleapis/java-containeranalysis/commit/af06d1ff8e44ac0c377ca37efd8c781219839218))
