# Changelog

## [2.9.0](https://github.com/googleapis/java-bigtable/compare/v2.8.0...v2.9.0) (2022-06-30)


### Features

* add built-in metric constants ([#1243](https://github.com/googleapis/java-bigtable/issues/1243)) ([b1fc00a](https://github.com/googleapis/java-bigtable/commit/b1fc00aa09129185b4e4db8edb9c4af2dbfd1ec8))
* **generated:** Add storage_utilization_gib_per_node to Autoscaling target ([a4c6621](https://github.com/googleapis/java-bigtable/commit/a4c662153c98f8043059a068a66d784761b7c2cb))
* **generated:** Cloud Bigtable Undelete Table service and message proto files ([a4c6621](https://github.com/googleapis/java-bigtable/commit/a4c662153c98f8043059a068a66d784761b7c2cb))
* update tracers to use built in metrics ([#1244](https://github.com/googleapis/java-bigtable/issues/1244)) ([df77560](https://github.com/googleapis/java-bigtable/commit/df77560debadec8b3aecc08e95a58558c418df86))


### Bug Fixes

* fix flaky test ([#1293](https://github.com/googleapis/java-bigtable/issues/1293)) ([146c824](https://github.com/googleapis/java-bigtable/commit/146c824962b48b2023ddb93d92e4a61297722f0f))
* remove the shaded profile from root pom ([#1274](https://github.com/googleapis/java-bigtable/issues/1274)) ([5eafcc3](https://github.com/googleapis/java-bigtable/commit/5eafcc3be3986692e64c95dcfc0d675208f2218c))
* rename HeaderTracer callables to BigtableTracer callables ([#1276](https://github.com/googleapis/java-bigtable/issues/1276)) ([e0bd6c9](https://github.com/googleapis/java-bigtable/commit/e0bd6c922ed2adfc8d6dddeced84cb87fc9f2e91))
* rename response observer and callbacks ([#1291](https://github.com/googleapis/java-bigtable/issues/1291)) ([2705a47](https://github.com/googleapis/java-bigtable/commit/2705a477f70247f16401901be9e0cd38733bdd2f))


### Documentation

* **sample:** update README for native image sample ([#1281](https://github.com/googleapis/java-bigtable/issues/1281)) ([4a3a2c9](https://github.com/googleapis/java-bigtable/commit/4a3a2c947642678c3011db616ebe7cbaed677f96))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.13.0 ([#1285](https://github.com/googleapis/java-bigtable/issues/1285)) ([1dc7787](https://github.com/googleapis/java-bigtable/commit/1dc77879ea51fd397b75020a16728adec72f1b9b))
* update dependency org.graalvm.buildtools:junit-platform-native to v0.9.12 ([#1283](https://github.com/googleapis/java-bigtable/issues/1283)) ([ba7844a](https://github.com/googleapis/java-bigtable/commit/ba7844acb6a4a3c47f1fc12b426f517b7fe3e55e))
* update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.12 ([#1284](https://github.com/googleapis/java-bigtable/issues/1284)) ([75d0066](https://github.com/googleapis/java-bigtable/commit/75d006601e51263786f38b445a9cc6f08cbee403))

## [2.8.0](https://github.com/googleapis/java-bigtable/compare/v2.7.0...v2.8.0) (2022-05-27)


### Features

* split emulator into core without deps and a higher level wrapper with grpc helpers ([#1264](https://github.com/googleapis/java-bigtable/issues/1264)) ([6fdc2c1](https://github.com/googleapis/java-bigtable/commit/6fdc2c1a33e140466734debed22d50a7be726d87))


### Bug Fixes

* **java:** enable skipped tests for Native Image testing  ([#1234](https://github.com/googleapis/java-bigtable/issues/1234)) ([560a501](https://github.com/googleapis/java-bigtable/commit/560a5018087c6cdc46e2c6150e6ed41075007177))

## [2.7.0](https://github.com/googleapis/java-bigtable/compare/v2.6.2...v2.7.0) (2022-05-20)


### Features

* (generated) Add ListHotTablets API method and protobufs ([f127f1a](https://github.com/googleapis/java-bigtable/commit/f127f1a05647c8fb2c9becf07753c302957bd571))
* (generated) AuditConfig for IAM v1 ([f127f1a](https://github.com/googleapis/java-bigtable/commit/f127f1a05647c8fb2c9becf07753c302957bd571))
* add build scripts for native image testing in Java 17 ([#1440](https://github.com/googleapis/java-bigtable/issues/1440)) ([#1255](https://github.com/googleapis/java-bigtable/issues/1255)) ([2e0bf19](https://github.com/googleapis/java-bigtable/commit/2e0bf193e3abaf2cfdc6208c41e7d8b928e92dc7))
* next release from main branch is v2.7.0 ([22acfc4](https://github.com/googleapis/java-bigtable/commit/22acfc405e23ccfeeeedcce6992f887d48d22bd5))


### Documentation

* Remove the limitation of all clusters in a CMEK instance must use the same key ([f127f1a](https://github.com/googleapis/java-bigtable/commit/f127f1a05647c8fb2c9becf07753c302957bd571))
* **sample:** remove unused native-image-support dependency ([#1237](https://github.com/googleapis/java-bigtable/issues/1237)) ([520670e](https://github.com/googleapis/java-bigtable/commit/520670ee1456f83368cc9843d594ad7af2117e76))
* Update `cpu_utilization_percent` limit ([f127f1a](https://github.com/googleapis/java-bigtable/commit/f127f1a05647c8fb2c9becf07753c302957bd571))


### Dependencies

* update dependency com.google.cloud:google-cloud-gcloud-maven-plugin to v0.1.5 ([#1249](https://github.com/googleapis/java-bigtable/issues/1249)) ([9fb02d6](https://github.com/googleapis/java-bigtable/commit/9fb02d6c3ab7d3d5d8b168418e47a65114b7deb1))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.11.0 ([#1253](https://github.com/googleapis/java-bigtable/issues/1253)) ([86a1e0e](https://github.com/googleapis/java-bigtable/commit/86a1e0e14b18101717143b0a01e4025a6540dbc2))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.12.0 ([#1256](https://github.com/googleapis/java-bigtable/issues/1256)) ([d4b05a4](https://github.com/googleapis/java-bigtable/commit/d4b05a4992dd016c389fc10c0ba509497e201d21))

### [2.6.2](https://github.com/googleapis/java-bigtable/compare/v2.6.1...v2.6.2) (2022-04-15)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.10.0 ([#1221](https://github.com/googleapis/java-bigtable/issues/1221)) ([acdaa33](https://github.com/googleapis/java-bigtable/commit/acdaa33dbfd91fdf892673ad164016a35e88d695))
* update dependency com.google.cloud:native-image-support to v0.13.1 ([#1222](https://github.com/googleapis/java-bigtable/issues/1222)) ([a14de82](https://github.com/googleapis/java-bigtable/commit/a14de8249d81f01355a87a8bc351bd6bc949c04b))

### [2.6.1](https://github.com/googleapis/java-bigtable/compare/v2.6.0...v2.6.1) (2022-03-29)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.9.0 ([#1212](https://github.com/googleapis/java-bigtable/issues/1212)) ([e38841c](https://github.com/googleapis/java-bigtable/commit/e38841c17c2a03e3b4dee73bd452c46c622736c1))
* update dependency com.google.cloud:native-image-support to v0.12.10 ([#1203](https://github.com/googleapis/java-bigtable/issues/1203)) ([a62a104](https://github.com/googleapis/java-bigtable/commit/a62a1048f0f2e9090405fc6311ca706762d1534e))
* update dependency com.google.cloud:native-image-support to v0.12.11 ([#1210](https://github.com/googleapis/java-bigtable/issues/1210)) ([2c5090c](https://github.com/googleapis/java-bigtable/commit/2c5090cf1ad19b966dc2819be2e724dc991149b9))
* update dependency com.google.cloud:native-image-support to v0.12.7 ([#1196](https://github.com/googleapis/java-bigtable/issues/1196)) ([476da07](https://github.com/googleapis/java-bigtable/commit/476da07ecead27c3f260b4e312bbb4eb035b4d3e))
* update dependency com.google.cloud:native-image-support to v0.12.8 ([#1201](https://github.com/googleapis/java-bigtable/issues/1201)) ([d9fd936](https://github.com/googleapis/java-bigtable/commit/d9fd936e97ca362c5868b6aeca2617c2688bc009))
* update dependency com.google.cloud:native-image-support to v0.12.9 ([#1202](https://github.com/googleapis/java-bigtable/issues/1202)) ([29c6005](https://github.com/googleapis/java-bigtable/commit/29c60059b7e231b014f0f8862d48dd0b071fbf8a))
* update dependency org.graalvm.buildtools:junit-platform-native to v0.9.11 ([#1207](https://github.com/googleapis/java-bigtable/issues/1207)) ([f2a01dc](https://github.com/googleapis/java-bigtable/commit/f2a01dc30c67ae6ae41e7f9733281ed182b6e836))
* update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.11 ([#1208](https://github.com/googleapis/java-bigtable/issues/1208)) ([9f93af3](https://github.com/googleapis/java-bigtable/commit/9f93af3eb1463427dc4cc57a860bf7a76ab3f2de))

## [2.6.0](https://github.com/googleapis/java-bigtable/compare/v2.5.3...v2.6.0) (2022-03-03)


### Features

* add WarmAndPing request for channel priming ([#1178](https://github.com/googleapis/java-bigtable/issues/1178)) ([385ab33](https://github.com/googleapis/java-bigtable/commit/385ab33d12479a9d2b1b66babef9b9b5846b902a))


### Documentation

* **sample:** Add sample for native image support in Bigtable ([#1165](https://github.com/googleapis/java-bigtable/issues/1165)) ([143aaee](https://github.com/googleapis/java-bigtable/commit/143aaee42e1b59d125250982dbeb34a31d906e30))


### Dependencies

* update actions/github-script action to v6 ([#1170](https://github.com/googleapis/java-bigtable/issues/1170)) ([5790bdf](https://github.com/googleapis/java-bigtable/commit/5790bdf875d27e6194f1753ff66d208f65488716))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.8.0 ([#1186](https://github.com/googleapis/java-bigtable/issues/1186)) ([74cafca](https://github.com/googleapis/java-bigtable/commit/74cafcae4a562b87f1664b8844794a2e68c97625))
* update dependency com.google.cloud:native-image-support to v0.12.4 ([#1175](https://github.com/googleapis/java-bigtable/issues/1175)) ([9cc6fbc](https://github.com/googleapis/java-bigtable/commit/9cc6fbc7de22303e17492824971fcc52fb041254))
* update dependency com.google.cloud:native-image-support to v0.12.5 ([#1183](https://github.com/googleapis/java-bigtable/issues/1183)) ([b025b34](https://github.com/googleapis/java-bigtable/commit/b025b343af0b9309558f530dc0765bf2b4c4d588))
* update dependency com.google.cloud:native-image-support to v0.12.6 ([#1187](https://github.com/googleapis/java-bigtable/issues/1187)) ([b110d65](https://github.com/googleapis/java-bigtable/commit/b110d650edd38a1866f6c2168c78ec8e31b528c2))
* update dependency org.graalvm.buildtools:native-maven-plugin to v0.9.10 ([#1174](https://github.com/googleapis/java-bigtable/issues/1174)) ([7ff5fa7](https://github.com/googleapis/java-bigtable/commit/7ff5fa712b6dcbbd3c721c8babb8ed4e1c7dad17))

### [2.5.3](https://github.com/googleapis/java-bigtable/compare/v2.5.2...v2.5.3) (2022-02-08)


### Bug Fixes

* integration tests ([#1161](https://github.com/googleapis/java-bigtable/issues/1161)) ([8b00b5f](https://github.com/googleapis/java-bigtable/commit/8b00b5fb5b4e3a1ada514b0bdc60fd744833bd01))

### [2.5.2](https://github.com/googleapis/java-bigtable/compare/v2.5.1...v2.5.2) (2022-01-31)


### Bug Fixes

* UpdateAppProfileRequest equals and hashcode should build proto ([#1142](https://github.com/googleapis/java-bigtable/issues/1142)) ([c9f1ed8](https://github.com/googleapis/java-bigtable/commit/c9f1ed8a5fdf44487a8c56388b35067ecfc4daea))


### Dependencies

* **java:** update actions/github-script action to v5 ([#1339](https://github.com/googleapis/java-bigtable/issues/1339)) ([#1147](https://github.com/googleapis/java-bigtable/issues/1147)) ([9bfcccf](https://github.com/googleapis/java-bigtable/commit/9bfcccfd76d2a03412cf9fe8c115874f15a95c57))
* update actions/github-script action to v5 ([#1146](https://github.com/googleapis/java-bigtable/issues/1146)) ([9b2c918](https://github.com/googleapis/java-bigtable/commit/9b2c918c3fad38d3b26d141b53f6dc037a23bed7))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.7.0 ([#1150](https://github.com/googleapis/java-bigtable/issues/1150)) ([744e483](https://github.com/googleapis/java-bigtable/commit/744e4830238b6ebe7bab6115ff26600b0c150b62))

### [2.5.1](https://www.github.com/googleapis/java-bigtable/compare/v2.5.0...v2.5.1) (2022-01-07)


### Bug Fixes

* Revert "fix: remove stats from javadoc" ([#1118](https://www.github.com/googleapis/java-bigtable/issues/1118)) ([ba8f344](https://www.github.com/googleapis/java-bigtable/commit/ba8f344d19163627553a0a268742af2a1a792db5))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.6.0 ([#1124](https://www.github.com/googleapis/java-bigtable/issues/1124)) ([55ebf69](https://www.github.com/googleapis/java-bigtable/commit/55ebf6932bbe93e8b7635a7550320099eb4fbe93))

## [2.5.0](https://www.github.com/googleapis/java-bigtable/compare/v2.4.0...v2.5.0) (2022-01-05)


### Features

* add batch throttled ms metric ([#888](https://www.github.com/googleapis/java-bigtable/issues/888)) ([0d197a5](https://www.github.com/googleapis/java-bigtable/commit/0d197a5ab9b7ccd20091c1c6c4a794586d6a51dc))
* ARM support for gcloud bigtable emulator ([#1094](https://www.github.com/googleapis/java-bigtable/issues/1094)) ([d3cb4a4](https://www.github.com/googleapis/java-bigtable/commit/d3cb4a4e03ae0f7e065bfee06ac8e3b86b447a4a))


### Bug Fixes

* align ip version preference for the wrapped  emulator ([#1052](https://www.github.com/googleapis/java-bigtable/issues/1052)) ([9dc93c5](https://www.github.com/googleapis/java-bigtable/commit/9dc93c5c9372f1501006e2d3a3a7affecd65fb8e))
* remove stats from javadoc ([#1108](https://www.github.com/googleapis/java-bigtable/issues/1108)) ([33fe7fe](https://www.github.com/googleapis/java-bigtable/commit/33fe7fe162cf84339e1887b052e446ef0aaf19d6))
* remove tracking latency from channel priming requests ([#1082](https://www.github.com/googleapis/java-bigtable/issues/1082)) ([bd873bc](https://www.github.com/googleapis/java-bigtable/commit/bd873bc82f0b210312fd442678c801758291935e))

## [2.4.0](https://www.github.com/googleapis/java-bigtable/compare/v2.3.1...v2.4.0) (2021-12-07)


### Features

* cluster autoscaling ([#1092](https://www.github.com/googleapis/java-bigtable/issues/1092)) ([fa4fe14](https://www.github.com/googleapis/java-bigtable/commit/fa4fe149a6a59600afe75f805f2503d3b45e5032))

### [2.3.1](https://www.github.com/googleapis/java-bigtable/compare/v2.3.0...v2.3.1) (2021-12-03)


### Bug Fixes

* add placeholder class for bigtable-stats ([#1075](https://www.github.com/googleapis/java-bigtable/issues/1075)) ([9d9f575](https://www.github.com/googleapis/java-bigtable/commit/9d9f57556216becfeb302bfaf5a4f35a9b73b611))
* add status label to gfe metrics ([#1077](https://www.github.com/googleapis/java-bigtable/issues/1077)) ([777549e](https://www.github.com/googleapis/java-bigtable/commit/777549e6ac64a03c9bd67d6b5a5cf4819ba8656f))
* make placeholder class public ([#1085](https://www.github.com/googleapis/java-bigtable/issues/1085)) ([879377a](https://www.github.com/googleapis/java-bigtable/commit/879377a03b86aa9a1f1035245c290ec78501b2cd))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.5.1 ([#1087](https://www.github.com/googleapis/java-bigtable/issues/1087)) ([f290ce7](https://www.github.com/googleapis/java-bigtable/commit/f290ce74f6b803b8c5786e8b4c69b9efa6995c59))

## [2.3.0](https://www.github.com/googleapis/java-bigtable/compare/v2.2.0...v2.3.0) (2021-11-16)


### Features

* configure branch 2.2.x as a release branch ([#1044](https://www.github.com/googleapis/java-bigtable/issues/1044)) ([68e8790](https://www.github.com/googleapis/java-bigtable/commit/68e8790f61b90ce2b5e7479b3d23e2f964199d3e))
* send attempt and timestamp in headers ([#935](https://www.github.com/googleapis/java-bigtable/issues/935)) ([de3b476](https://www.github.com/googleapis/java-bigtable/commit/de3b476d4acd644d1e5bc782dc697ce5b145992e))


### Bug Fixes

* **java:** java 17 dependency arguments ([#1046](https://www.github.com/googleapis/java-bigtable/issues/1046)) ([422efa0](https://www.github.com/googleapis/java-bigtable/commit/422efa0289b232118b446224c5e084fe3bc19491))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.5.0 ([#1064](https://www.github.com/googleapis/java-bigtable/issues/1064)) ([5b72aa9](https://www.github.com/googleapis/java-bigtable/commit/5b72aa96bab018f4b5b1b565a6487dbb45ccd323))

## [2.2.0](https://www.github.com/googleapis/java-bigtable/compare/v2.1.4...v2.2.0) (2021-10-20)


### Features

* app profile multi cluster routing support with specified cluster ids ([#961](https://www.github.com/googleapis/java-bigtable/issues/961)) ([f4c5c32](https://www.github.com/googleapis/java-bigtable/commit/f4c5c32c05d244a9ce7c3a4386ba9396c65f227e))


### Bug Fixes

* fix typo in rst stream message ([#1029](https://www.github.com/googleapis/java-bigtable/issues/1029)) ([50e6860](https://www.github.com/googleapis/java-bigtable/commit/50e686094c316560864c30a0295b3ed3f655c765))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.4.0 ([#1038](https://www.github.com/googleapis/java-bigtable/issues/1038)) ([d3efb29](https://www.github.com/googleapis/java-bigtable/commit/d3efb29df8461caddd3917fc42afa50961723a7d))

### [2.1.4](https://www.github.com/googleapis/java-bigtable/compare/v2.1.3...v2.1.4) (2021-09-22)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.3.0 ([#1020](https://www.github.com/googleapis/java-bigtable/issues/1020)) ([272f044](https://www.github.com/googleapis/java-bigtable/commit/272f0443501c502abf1b061414fb2435a9ad7952))

### [2.1.3](https://www.github.com/googleapis/java-bigtable/compare/v2.1.2...v2.1.3) (2021-09-21)


### Dependencies

* migrate to mockito-core 3.12.4 ([#1008](https://www.github.com/googleapis/java-bigtable/issues/1008)) ([d9f19db](https://www.github.com/googleapis/java-bigtable/commit/d9f19db82f82615e4476462f9c34da7841169838))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.2.1 ([#1010](https://www.github.com/googleapis/java-bigtable/issues/1010)) ([a54a021](https://www.github.com/googleapis/java-bigtable/commit/a54a02135f30e3337812938f5794b293ee6535c6))

### [2.1.2](https://www.github.com/googleapis/java-bigtable/compare/v2.1.1...v2.1.2) (2021-09-13)


### Bug Fixes

* parallel execution and verbose grpc logs ([#1004](https://www.github.com/googleapis/java-bigtable/issues/1004)) ([dd5164d](https://www.github.com/googleapis/java-bigtable/commit/dd5164dc9de7f060bb0dab79820cb43ac434d703))


### Reverts

* temporary workaround for maven wildcard excludes ([#989](https://www.github.com/googleapis/java-bigtable/issues/989)) ([148a928](https://www.github.com/googleapis/java-bigtable/commit/148a928e3f8f6d1e2ee1d1b119ca820d676802fd))

### [2.1.1](https://www.github.com/googleapis/java-bigtable/compare/v2.1.0...v2.1.1) (2021-09-01)


### Dependencies

* update dependency com.google.cloud:google-cloud-conformance-tests to v0.2.0 ([#971](https://www.github.com/googleapis/java-bigtable/issues/971)) ([5c614d5](https://www.github.com/googleapis/java-bigtable/commit/5c614d58dd527a7fd36d32f201138a35e95a0577))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.2.0 ([#975](https://www.github.com/googleapis/java-bigtable/issues/975)) ([e5bb52e](https://www.github.com/googleapis/java-bigtable/commit/e5bb52eead42e8b351a7469529837d8b509b8332))

## [2.1.0](https://www.github.com/googleapis/java-bigtable/compare/v2.0.1...v2.1.0) (2021-08-25)


### Features

* publish new fields to support cluster group routing ([#958](https://www.github.com/googleapis/java-bigtable/issues/958)) ([09b31bd](https://www.github.com/googleapis/java-bigtable/commit/09b31bd9032dc36071cb8d32fc5cb6d4d85878e1))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.1.0 ([#962](https://www.github.com/googleapis/java-bigtable/issues/962)) ([a013e77](https://www.github.com/googleapis/java-bigtable/commit/a013e777af0fb2945099c178832fccd14b33398f))

### [2.0.1](https://www.github.com/googleapis/java-bigtable/compare/v2.0.0...v2.0.1) (2021-08-11)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.0.1 ([#948](https://www.github.com/googleapis/java-bigtable/issues/948)) ([31a7cb6](https://www.github.com/googleapis/java-bigtable/commit/31a7cb60321429497ca29f02119e7a2c1b0d614f))

## [2.0.0](https://www.github.com/googleapis/java-bigtable/compare/v1.27.3...v2.0.0) (2021-08-09)


### ⚠ BREAKING CHANGES

* release gapic-generator-java v2.0.0 (#938)
* update java compile to 1.8 (update google-cloud-shared-config … (#939)

### Features

* gapic-generator-java v1.0.12, mtls support ([#871](https://www.github.com/googleapis/java-bigtable/issues/871)) ([3ec05d4](https://www.github.com/googleapis/java-bigtable/commit/3ec05d4dff8ee3799dd799ecf659610de031564a))
* release gapic-generator-java v2.0.0 ([#938](https://www.github.com/googleapis/java-bigtable/issues/938)) ([d2456e4](https://www.github.com/googleapis/java-bigtable/commit/d2456e4b014f714c87ff5ad414b5fabd0631e912))
* update java compile to 1.8 (update google-cloud-shared-config … ([#939](https://www.github.com/googleapis/java-bigtable/issues/939)) ([57cddee](https://www.github.com/googleapis/java-bigtable/commit/57cddee445dec91a8bb96127ee7db947a1e13a7d))


### Dependencies

* fix UpperBoundsDep check for checker-qual ([#941](https://www.github.com/googleapis/java-bigtable/issues/941)) ([1d7c224](https://www.github.com/googleapis/java-bigtable/commit/1d7c224bd46f8ab576645e5d722ac595ab875406))

### [1.27.3](https://www.github.com/googleapis/java-bigtable/compare/v1.27.2...v1.27.3) (2021-07-19)


### Bug Fixes

* client.close() should wait until the channels are terminated before shutting down the executor ([#916](https://www.github.com/googleapis/java-bigtable/issues/916)) ([914f0cc](https://www.github.com/googleapis/java-bigtable/commit/914f0cc4a928974e14b2ab49b848f757862ad140))

### [1.27.2](https://www.github.com/googleapis/java-bigtable/compare/v1.27.1...v1.27.2) (2021-07-01)


### Bug Fixes

* jwt authentication on batch-bigtable.googleapis.com ([#892](https://www.github.com/googleapis/java-bigtable/issues/892)) ([d2ca9c6](https://www.github.com/googleapis/java-bigtable/commit/d2ca9c62f3fcb9c79c97ef8a73bad3a0e7555afc))

### [1.27.1](https://www.github.com/googleapis/java-bigtable/compare/v1.27.0...v1.27.1) (2021-06-30)


### Bug Fixes

* Add `shopt -s nullglob` to dependencies script ([#884](https://www.github.com/googleapis/java-bigtable/issues/884)) ([8b971a2](https://www.github.com/googleapis/java-bigtable/commit/8b971a2510685be336b0dd19fc048905b56906e3))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.4.0 ([#889](https://www.github.com/googleapis/java-bigtable/issues/889)) ([8b6754f](https://www.github.com/googleapis/java-bigtable/commit/8b6754fb1fbdca43a327e3f253be076eb0c2cd2f))

## [1.27.0](https://www.github.com/googleapis/java-bigtable/compare/v1.26.1...v1.27.0) (2021-06-22)


### Features

* all setting timeouts for batchers + fix handling of timeouts for point reads ([#861](https://www.github.com/googleapis/java-bigtable/issues/861)) ([c145ceb](https://www.github.com/googleapis/java-bigtable/commit/c145ceb592f04f94a09be815feff87e0c64e8e7d))
* call setting timeouts for batchers ([#877](https://www.github.com/googleapis/java-bigtable/issues/877)) ([0f3654d](https://www.github.com/googleapis/java-bigtable/commit/0f3654d726dbb45b4a12ef98f872612e49b9a263))


### Bug Fixes

* Update dependencies.sh to not break on mac ([#873](https://www.github.com/googleapis/java-bigtable/issues/873)) ([9e6b85d](https://www.github.com/googleapis/java-bigtable/commit/9e6b85deffff15961d12eb8b656210b5e12d8162))


### Reverts

* Revert "feat: promote stream wait timeouts to deadlines for point reads" ([#876](https://www.github.com/googleapis/java-bigtable/issues/876)) ([4614912](https://www.github.com/googleapis/java-bigtable/commit/4614912b6ea76c9057b1a4cbf869eb3145bce18f))


### Documentation

* fix connection pool size for samples ([#880](https://www.github.com/googleapis/java-bigtable/issues/880)) ([d0d1aa3](https://www.github.com/googleapis/java-bigtable/commit/d0d1aa3195c0d63242254eece3e92e9ad078069b))

### [1.26.1](https://www.github.com/googleapis/java-bigtable/compare/v1.26.0...v1.26.1) (2021-06-07)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.3.0 ([#857](https://www.github.com/googleapis/java-bigtable/issues/857)) ([fd2bf65](https://www.github.com/googleapis/java-bigtable/commit/fd2bf656629e21e01e9a877c00eaed018889cc37))
* update truth-proto-extension to 1.1.3 and exclude protobuf-java from its dependencies ([#854](https://www.github.com/googleapis/java-bigtable/issues/854)) ([e7773ee](https://www.github.com/googleapis/java-bigtable/commit/e7773eed9f34ab4d104df5c09aefb5a302ab4186))

## [1.26.0](https://www.github.com/googleapis/java-bigtable/compare/v1.25.0...v1.26.0) (2021-06-03)


### Features

* promote stream wait timeouts to deadlines for point reads ([#848](https://www.github.com/googleapis/java-bigtable/issues/848)) ([9b3c601](https://www.github.com/googleapis/java-bigtable/commit/9b3c6013fef396fcc923e53c13f73a03a48c9c02))


### Bug Fixes

* add back in extraFiles and fix file path ([#833](https://www.github.com/googleapis/java-bigtable/issues/833)) ([f914954](https://www.github.com/googleapis/java-bigtable/commit/f91495474cb34e1f178d9362ab0251d364079f6d))
* exclude protobuf from conformance-tests ([#845](https://www.github.com/googleapis/java-bigtable/issues/845)) ([1d89191](https://www.github.com/googleapis/java-bigtable/commit/1d89191a2453b5565aafe72367329eddb36ea90a))
* Fix the race condition in decay average ([#850](https://www.github.com/googleapis/java-bigtable/issues/850)) ([66a9c9e](https://www.github.com/googleapis/java-bigtable/commit/66a9c9ebc520dd20c336a5cf4040912138137be6))
* revert conformance test version ([#846](https://www.github.com/googleapis/java-bigtable/issues/846)) ([b23b0d7](https://www.github.com/googleapis/java-bigtable/commit/b23b0d7a7d8a2b9bed1cdabce420cb6568cf82ef))


### Dependencies

* update dependency com.google.cloud:google-cloud-conformance-tests to v0.1.1 ([#852](https://www.github.com/googleapis/java-bigtable/issues/852)) ([e1c951c](https://www.github.com/googleapis/java-bigtable/commit/e1c951c549bf455cdd6e997756d9464a1e06dad2))

## [1.25.0](https://www.github.com/googleapis/java-bigtable/compare/v1.24.1...v1.25.0) (2021-05-19)


### Features

* add `gcf-owl-bot[bot]` to `ignoreAuthors` ([#815](https://www.github.com/googleapis/java-bigtable/issues/815)) ([ea558b0](https://www.github.com/googleapis/java-bigtable/commit/ea558b05b369c6131f94e471e5652866a037b948))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.2.0 ([#814](https://www.github.com/googleapis/java-bigtable/issues/814)) ([1299d72](https://www.github.com/googleapis/java-bigtable/commit/1299d727066e0aa24319b99d438503ea0cf60d86))

### [1.24.1](https://www.github.com/googleapis/java-bigtable/compare/v1.24.0...v1.24.1) (2021-05-11)


### Bug Fixes

* filter limit constant ([#787](https://www.github.com/googleapis/java-bigtable/issues/787)) ([04f8ad4](https://www.github.com/googleapis/java-bigtable/commit/04f8ad463d1fa9efe0ab941ee5f3d0794baed814))
* fix flaky test ([#798](https://www.github.com/googleapis/java-bigtable/issues/798)) ([83e0e8c](https://www.github.com/googleapis/java-bigtable/commit/83e0e8cf2cdbc143c10ce0f8b053096d61d5686f))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.1.0 ([#805](https://www.github.com/googleapis/java-bigtable/issues/805)) ([a498687](https://www.github.com/googleapis/java-bigtable/commit/a498687d15dd9af35c57b0df6d08c87ef36833da))


### Documentation

* update the comments in Cloud Bigtable RestoreTable API to reflect the new API capability ([#804](https://www.github.com/googleapis/java-bigtable/issues/804)) ([f5e5d5a](https://www.github.com/googleapis/java-bigtable/commit/f5e5d5ac196529d5b070ef5fd8118038fec2e2de))

## [1.24.0](https://www.github.com/googleapis/java-bigtable/compare/v1.23.2...v1.24.0) (2021-04-30)


### Features

* allow restore backup to different instance ([#515](https://www.github.com/googleapis/java-bigtable/issues/515)) ([8a5e60e](https://www.github.com/googleapis/java-bigtable/commit/8a5e60e8ed116d36810cc4059539228768726912)), closes [#789](https://www.github.com/googleapis/java-bigtable/issues/789)

### [1.23.2](https://www.github.com/googleapis/java-bigtable/compare/v1.23.1...v1.23.2) (2021-04-23)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1 ([#781](https://www.github.com/googleapis/java-bigtable/issues/781)) ([dbf856f](https://www.github.com/googleapis/java-bigtable/commit/dbf856f93942cbec48433821da8e5a96e61a9d7e))

### [1.23.1](https://www.github.com/googleapis/java-bigtable/compare/v1.23.0...v1.23.1) (2021-04-20)


### Bug Fixes

* **docs:** correct docs for CUSTOMER_MANAGED_ENCRYPTION ([#737](https://www.github.com/googleapis/java-bigtable/issues/737)) ([b3bb7f7](https://www.github.com/googleapis/java-bigtable/commit/b3bb7f77610e48e849766a6e9dbacb98fc3f9811))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.21.1 ([#741](https://www.github.com/googleapis/java-bigtable/issues/741)) ([cfdd0cd](https://www.github.com/googleapis/java-bigtable/commit/cfdd0cd760f9273e644cddc492d9c4d5327498e7))

## [1.23.0](https://www.github.com/googleapis/java-bigtable/compare/v1.22.0...v1.23.0) (2021-04-13)


### Features

* dynamic flow control ([#721](https://www.github.com/googleapis/java-bigtable/issues/721)) ([b61c5ce](https://www.github.com/googleapis/java-bigtable/commit/b61c5ce5de9cbe2a93a4ea95bad03585069b85bb))


### Bug Fixes

* change clusterId in Cmek test ([#716](https://www.github.com/googleapis/java-bigtable/issues/716)) ([67ef155](https://www.github.com/googleapis/java-bigtable/commit/67ef15591d49d51728c769eb54a1167b15524aa1))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.21.0 ([#717](https://www.github.com/googleapis/java-bigtable/issues/717)) ([dfc2efd](https://www.github.com/googleapis/java-bigtable/commit/dfc2efda536bb5db209b7c50114b417edd7af5cd))

## [1.22.0](https://www.github.com/googleapis/java-bigtable/compare/v1.21.3...v1.22.0) (2021-04-06)


### Features

* add CMEK Support  ([#656](https://www.github.com/googleapis/java-bigtable/issues/656)) ([2821902](https://www.github.com/googleapis/java-bigtable/commit/2821902b34ae04596771a9fc5e2b62d5c24a7253))


### Dependencies

* update autovalue.version to v1.8 ([#703](https://www.github.com/googleapis/java-bigtable/issues/703)) ([13e7796](https://www.github.com/googleapis/java-bigtable/commit/13e7796d96222fe0181771d160d12a3da7f0a7a7))
* update dependency com.google.truth.extensions:truth-proto-extension to v1.1.2 ([#704](https://www.github.com/googleapis/java-bigtable/issues/704)) ([3fa8b00](https://www.github.com/googleapis/java-bigtable/commit/3fa8b0069d58a5705f11fac481ddcd4ad7d447f4))

### [1.21.3](https://www.github.com/googleapis/java-bigtable/compare/v1.21.2...v1.21.3) (2021-04-01)


### Dependencies

* update dependency com.google.errorprone:error_prone_annotations to v2.6.0 ([#693](https://www.github.com/googleapis/java-bigtable/issues/693)) ([831d044](https://www.github.com/googleapis/java-bigtable/commit/831d044f31c7643b34df4f23765d521e8f68035d))

### [1.21.2](https://www.github.com/googleapis/java-bigtable/compare/v1.21.1...v1.21.2) (2021-03-22)


### Dependencies

* update autovalue.version to v1.7.5 ([#684](https://www.github.com/googleapis/java-bigtable/issues/684)) ([75baa79](https://www.github.com/googleapis/java-bigtable/commit/75baa79e94c31e1694c3e29ea2f1ed42dbc60eb8))

### [1.21.1](https://www.github.com/googleapis/java-bigtable/compare/v1.21.0...v1.21.1) (2021-03-15)


### Bug Fixes

* **retry:** restore grpc_service_config for CreateBackup and {Restore,Snapshot}Table ([#667](https://www.github.com/googleapis/java-bigtable/issues/667)) ([121f071](https://www.github.com/googleapis/java-bigtable/commit/121f07159c2715368cb53753ba39d70d1d25efb8))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.20.1 ([#671](https://www.github.com/googleapis/java-bigtable/issues/671)) ([6ba3bf3](https://www.github.com/googleapis/java-bigtable/commit/6ba3bf3a642bd5b7ecf2a86a821ede0f2bae084f))

## [1.21.0](https://www.github.com/googleapis/java-bigtable/compare/v1.20.1...v1.21.0) (2021-03-02)


### Features

* **generator:** update protoc to v3.15.3 ([#654](https://www.github.com/googleapis/java-bigtable/issues/654)) ([4b0c59a](https://www.github.com/googleapis/java-bigtable/commit/4b0c59a17d668e724fb79369ad7a6f7fbbb31d89))
* migrate to java microgenerator ([#629](https://www.github.com/googleapis/java-bigtable/issues/629)) ([60d17dc](https://www.github.com/googleapis/java-bigtable/commit/60d17dc1d0a0a568a8bdd3bcc1e7491c17142af3))
* publish new fields for CMEK support ([#646](https://www.github.com/googleapis/java-bigtable/issues/646)) ([e039386](https://www.github.com/googleapis/java-bigtable/commit/e039386898b82f7b03f5a4064c5dcca0fdd3f330))


### Dependencies

* update dependency com.google.cloud:google-cloud-gcloud-maven-plugin to v0.1.2 ([#652](https://www.github.com/googleapis/java-bigtable/issues/652)) ([71a8fd7](https://www.github.com/googleapis/java-bigtable/commit/71a8fd7fe55bd40ad32963ffdfc06999be2ff7fc))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.20.0 ([#653](https://www.github.com/googleapis/java-bigtable/issues/653)) ([c5049c1](https://www.github.com/googleapis/java-bigtable/commit/c5049c1f988e0f4465d9d805fd092087bfa69fdc))

### [1.20.1](https://www.github.com/googleapis/java-bigtable/compare/v1.20.0...v1.20.1) (2021-02-22)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.19.0 ([#640](https://www.github.com/googleapis/java-bigtable/issues/640)) ([bf1f49f](https://www.github.com/googleapis/java-bigtable/commit/bf1f49fbff344510501b9b836771d9cfab4defcd))

## [1.20.0](https://www.github.com/googleapis/java-bigtable/compare/v1.19.2...v1.20.0) (2021-02-05)


### Features

* Surface the server-timing metric ([#535](https://www.github.com/googleapis/java-bigtable/issues/535)) ([8240779](https://www.github.com/googleapis/java-bigtable/commit/8240779434a602dc8b2bf90dbe539c5d7470d850))


### Bug Fixes

* fix MetricTracerTest to rebase on head ([#581](https://www.github.com/googleapis/java-bigtable/issues/581)) ([23e97cb](https://www.github.com/googleapis/java-bigtable/commit/23e97cb308403b35fbe972b08048d0e59423e694))
* fix MutateRowsAttemptCallable to avoid NPE in MetricTracer ([#557](https://www.github.com/googleapis/java-bigtable/issues/557)) ([8d71020](https://www.github.com/googleapis/java-bigtable/commit/8d7102003b54757b64fd598290301d3b24fd9c29))
* Retry "received rst stream" ([#586](https://www.github.com/googleapis/java-bigtable/issues/586)) ([b09a21c](https://www.github.com/googleapis/java-bigtable/commit/b09a21c1dd1a05b68bfd3a0134089ba32dca1774))
* update repo name ([#615](https://www.github.com/googleapis/java-bigtable/issues/615)) ([bb3ed6d](https://www.github.com/googleapis/java-bigtable/commit/bb3ed6dcbadbd70dbd9c68152c8d93c4cefd4dcb))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.17.1 ([#590](https://www.github.com/googleapis/java-bigtable/issues/590)) ([5035ad0](https://www.github.com/googleapis/java-bigtable/commit/5035ad0db01a9247634137050698c30da29722a6))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.18.0 ([#592](https://www.github.com/googleapis/java-bigtable/issues/592)) ([c58b73a](https://www.github.com/googleapis/java-bigtable/commit/c58b73a7d70c8da1581ac06d77b5e362648a0868))
* update dependency com.google.errorprone:error_prone_annotations to v2.5.0 ([#591](https://www.github.com/googleapis/java-bigtable/issues/591)) ([dfa4da7](https://www.github.com/googleapis/java-bigtable/commit/dfa4da75e5ac81cc941177462326f7c38f18bacd))
* update dependency com.google.errorprone:error_prone_annotations to v2.5.1 ([#594](https://www.github.com/googleapis/java-bigtable/issues/594)) ([ea599a1](https://www.github.com/googleapis/java-bigtable/commit/ea599a10e2e4fdbaf56c45b74fbb1ea5a708a7f2))


### Documentation

* Expand hello world snippet to show how to access specific cells ([#516](https://www.github.com/googleapis/java-bigtable/issues/516)) ([a9001a8](https://www.github.com/googleapis/java-bigtable/commit/a9001a88f338fc2acf6bc48927765f29819124ee))
* Update stackdriver examples for tracing and stats ([#613](https://www.github.com/googleapis/java-bigtable/issues/613)) ([3e8af74](https://www.github.com/googleapis/java-bigtable/commit/3e8af747b329f6656a410160e8da14fd8227c8fc))
* use autogenerated readme functionality and regenerate ([#568](https://www.github.com/googleapis/java-bigtable/issues/568)) ([844e5be](https://www.github.com/googleapis/java-bigtable/commit/844e5beb6230df6ca220935056aae7f6e73d2bc0))

### [1.19.2](https://www.github.com/googleapis/java-bigtable/compare/v1.19.1...v1.19.2) (2020-12-15)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.17.0 ([#566](https://www.github.com/googleapis/java-bigtable/issues/566)) ([7c8e32b](https://www.github.com/googleapis/java-bigtable/commit/7c8e32b33c701cdf701384ad60986bc96ec4684a))

### [1.19.1](https://www.github.com/googleapis/java-bigtable/compare/v1.19.0...v1.19.1) (2020-12-14)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.16.1 ([1c4ceda](https://www.github.com/googleapis/java-bigtable/commit/1c4ceda740157569fb95f7eeb9ddc0cf780cd038))

## [1.19.0](https://www.github.com/googleapis/java-bigtable/compare/v1.18.1...v1.19.0) (2020-12-03)


### Features

* attempt DirectPath by default ([#544](https://www.github.com/googleapis/java-bigtable/issues/544)) ([2043063](https://www.github.com/googleapis/java-bigtable/commit/20430636f10445e32834f44b902dd506b0bdadf8))

### [1.18.1](https://www.github.com/googleapis/java-bigtable/compare/v1.18.0...v1.18.1) (2020-12-02)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.16.0 ([#546](https://www.github.com/googleapis/java-bigtable/issues/546)) ([070bda2](https://www.github.com/googleapis/java-bigtable/commit/070bda21b9ec93bb187626eeb46e7212951a9ebf))

## [1.18.0](https://www.github.com/googleapis/java-bigtable/compare/v1.17.3...v1.18.0) (2020-11-13)


### Features

* **autogenerated:** Update BigtableTableAdmin GetIamPolicy to include the additional binding for Backup, Change DeleteAppProfileRequest.ignore_warnings to REQUIRED. ([#530](https://www.github.com/googleapis/java-bigtable/issues/530)) ([8c16fa4](https://www.github.com/googleapis/java-bigtable/commit/8c16fa4c5290f67c43392953095bd759c2505bdb))


### Bug Fixes

* make keepalive params a bit conservative ([#528](https://www.github.com/googleapis/java-bigtable/issues/528)) ([f5f66c9](https://www.github.com/googleapis/java-bigtable/commit/f5f66c9ce019a6a24ddfe1efc0141835f5a02f34))

### [1.17.3](https://www.github.com/googleapis/java-bigtable/compare/v1.17.2...v1.17.3) (2020-11-11)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.15.0 ([#521](https://www.github.com/googleapis/java-bigtable/issues/521)) ([ed300d0](https://www.github.com/googleapis/java-bigtable/commit/ed300d09c6fffb012981789256f13c4893ce02b1))

### [1.17.2](https://www.github.com/googleapis/java-bigtable/compare/v1.17.1...v1.17.2) (2020-11-10)


### Bug Fixes

* readRowSettings use manual readRows settings instead of gapics ([#494](https://www.github.com/googleapis/java-bigtable/issues/494)) ([0ef7c5d](https://www.github.com/googleapis/java-bigtable/commit/0ef7c5d4aacacd2030a52efc148ead457719a927))


### Reverts

* Revert "feat: attemp DirectPath by default (#467)" (#520) ([b33b0fc](https://www.github.com/googleapis/java-bigtable/commit/b33b0fc1b5478934298db317c1168c1e9dc20599)), closes [#467](https://www.github.com/googleapis/java-bigtable/issues/467) [#520](https://www.github.com/googleapis/java-bigtable/issues/520)

### [1.17.1](https://www.github.com/googleapis/java-bigtable/compare/v1.17.0...v1.17.1) (2020-10-31)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.14.1 ([#505](https://www.github.com/googleapis/java-bigtable/issues/505)) ([ab6284d](https://www.github.com/googleapis/java-bigtable/commit/ab6284d16f24f8197d90c43f1e37416c53287b4c))

## [1.17.0](https://www.github.com/googleapis/java-bigtable/compare/v1.16.2...v1.17.0) (2020-10-23)


### Features

* attemp DirectPath by default ([#467](https://www.github.com/googleapis/java-bigtable/issues/467)) ([89c622d](https://www.github.com/googleapis/java-bigtable/commit/89c622da6038067892687af3edafae743465eda7))
* backup level IAM ([#450](https://www.github.com/googleapis/java-bigtable/issues/450)) ([f38a8ec](https://www.github.com/googleapis/java-bigtable/commit/f38a8ecdc6164d081ef96f748ea37bd62b29b419))
* Implement toString for Bigtable*Settings ([#488](https://www.github.com/googleapis/java-bigtable/issues/488)) ([4d821f8](https://www.github.com/googleapis/java-bigtable/commit/4d821f85ceb237c8e449243ff8c80fb94e22ad51))


### Bug Fixes

* Make refreshing channel compatible with BigtableDataClientFactory ([#474](https://www.github.com/googleapis/java-bigtable/issues/474)) ([fc74164](https://www.github.com/googleapis/java-bigtable/commit/fc741645536e01fac772136bc8346f73ff95e600))


### Documentation

* fix formatting ([#476](https://www.github.com/googleapis/java-bigtable/issues/476)) ([eb24569](https://www.github.com/googleapis/java-bigtable/commit/eb24569e53f9d2b7fde50748c840c2c11f3f3c80))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.12.1 ([#475](https://www.github.com/googleapis/java-bigtable/issues/475)) ([9e56edf](https://www.github.com/googleapis/java-bigtable/commit/9e56edfa7b0a78f14518a99130a7b319c5873be4))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.13.0 ([#484](https://www.github.com/googleapis/java-bigtable/issues/484)) ([aad648f](https://www.github.com/googleapis/java-bigtable/commit/aad648fec16b122092d394350822da742a2d7aa0))
* update dependency com.google.truth:truth to v1.1 ([#483](https://www.github.com/googleapis/java-bigtable/issues/483)) ([cca1e0e](https://www.github.com/googleapis/java-bigtable/commit/cca1e0e16f2ec0cc887d81c1844f5395ce08b6ea))

### [1.16.2](https://www.github.com/googleapis/java-bigtable/compare/v1.16.1...v1.16.2) (2020-10-14)


### Dependencies

* update dependency com.google.cloud:google-cloud-conformance-tests to v0.0.13 ([#459](https://www.github.com/googleapis/java-bigtable/issues/459)) ([a7824ea](https://www.github.com/googleapis/java-bigtable/commit/a7824ea99abe2ea0f1336662db5addd60632598a))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.11.0 ([#460](https://www.github.com/googleapis/java-bigtable/issues/460)) ([d2d806c](https://www.github.com/googleapis/java-bigtable/commit/d2d806c615f819bbaf575bfadcce26b2473bb77d))

### [1.16.1](https://www.github.com/googleapis/java-bigtable/compare/v1.16.0...v1.16.1) (2020-10-08)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.10.2 ([#452](https://www.github.com/googleapis/java-bigtable/issues/452)) ([c211c1c](https://www.github.com/googleapis/java-bigtable/commit/c211c1c988cc4805d3fe68853836ec3acb495578))

## [1.16.0](https://www.github.com/googleapis/java-bigtable/compare/v1.15.0...v1.16.0) (2020-10-06)


### Features

* add keepalive changes in java client library ([#409](https://www.github.com/googleapis/java-bigtable/issues/409)) ([edbcde1](https://www.github.com/googleapis/java-bigtable/commit/edbcde1a5b22317319803cb57401252aac6d580d))
* include User agent ([#404](https://www.github.com/googleapis/java-bigtable/issues/404)) ([0cd71b5](https://www.github.com/googleapis/java-bigtable/commit/0cd71b59305cd7a336c223faff68402a8bee4639))


### Bug Fixes

* **test:** Clean up tests ([#439](https://www.github.com/googleapis/java-bigtable/issues/439)) ([c5c881b](https://www.github.com/googleapis/java-bigtable/commit/c5c881bb956860a393c2a7f34d0d790a23d270af))
* Add documentation to bulkReadRows that each batch will process t… ([#410](https://www.github.com/googleapis/java-bigtable/issues/410)) ([71dc8e3](https://www.github.com/googleapis/java-bigtable/commit/71dc8e3419fbb49d48bb7a3fd984d24e24661c81))
* Filters should be serializable ([#397](https://www.github.com/googleapis/java-bigtable/issues/397)) ([57edfde](https://www.github.com/googleapis/java-bigtable/commit/57edfde5eace28d50ec777e14589c9747616f0a8))
* RowCells are not actually serializeable ([#407](https://www.github.com/googleapis/java-bigtable/issues/407)) ([39e17cc](https://www.github.com/googleapis/java-bigtable/commit/39e17cc17c438f2d665875f9ff2b2cdf984e37b7))


### Dependencies

* update dependency com.google.cloud:google-cloud-conformance-tests to v0.0.12 ([#415](https://www.github.com/googleapis/java-bigtable/issues/415)) ([7b3713a](https://www.github.com/googleapis/java-bigtable/commit/7b3713a8935b2f0b1ca57d189e9e0363506b28a1))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.10.0 ([#428](https://www.github.com/googleapis/java-bigtable/issues/428)) ([373032e](https://www.github.com/googleapis/java-bigtable/commit/373032e93b838cbc0ccab7dc45cd61b3b973542a))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.10.1 ([#443](https://www.github.com/googleapis/java-bigtable/issues/443)) ([939fefa](https://www.github.com/googleapis/java-bigtable/commit/939fefa819d09885489d9faeedadc74ee2b0e1b9))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.9.1 ([#427](https://www.github.com/googleapis/java-bigtable/issues/427)) ([5175e28](https://www.github.com/googleapis/java-bigtable/commit/5175e28f5ce69f6fb3ed14131c1cfd26dbc47bb9))

## [1.15.0](https://www.github.com/googleapis/java-bigtable/compare/v1.14.0...v1.15.0) (2020-09-01)


### Features

* extend channel priming logic to also send fake requests ([#398](https://www.github.com/googleapis/java-bigtable/issues/398)) ([6f1ead2](https://www.github.com/googleapis/java-bigtable/commit/6f1ead2097150a87cb9712bcf35c6eaa9d57440c))
* **deps:** adopt flatten plugin and google-cloud-shared-dependencies ([#350](https://www.github.com/googleapis/java-bigtable/issues/350)) ([2298596](https://www.github.com/googleapis/java-bigtable/commit/2298596dab8a1ef87c0f48d3abe8bc3955417eb1))


### Bug Fixes

* temporarily disable reporting to unblock releases ([#395](https://www.github.com/googleapis/java-bigtable/issues/395)) ([a56a0f8](https://www.github.com/googleapis/java-bigtable/commit/a56a0f8c9caf675b68d02587b042e1feeb261ccb))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.6 ([#377](https://www.github.com/googleapis/java-bigtable/issues/377)) ([bdae336](https://www.github.com/googleapis/java-bigtable/commit/bdae336074d80815dcaaf8c71befafc0ed66c079))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.9.0 ([#402](https://www.github.com/googleapis/java-bigtable/issues/402)) ([08f7d84](https://www.github.com/googleapis/java-bigtable/commit/08f7d84333c6a74bf03e0a57707b878a29400dd4))

## [1.14.0](https://www.github.com/googleapis/java-bigtable/compare/v1.13.1...v1.14.0) (2020-07-20)


### Features

* Cloud Bigtable Managed Backup Implementation ([#305](https://www.github.com/googleapis/java-bigtable/issues/305)) ([9e3307a](https://www.github.com/googleapis/java-bigtable/commit/9e3307a4872d3bae3c04e7857a9eb4859151965e))

### [1.13.1](https://www.github.com/googleapis/java-bigtable/compare/v1.13.0...v1.13.1) (2020-07-10)


### Reverts

* Revert "fix: change app_profile_id to the correct header app_profile (#318)" (#335) ([200cfac](https://www.github.com/googleapis/java-bigtable/commit/200cfac9b68be9882943765b06de7c0644daf53d)), closes [#318](https://www.github.com/googleapis/java-bigtable/issues/318) [#335](https://www.github.com/googleapis/java-bigtable/issues/335)


### Dependencies

* update autovalue.version to v1.7.3 ([#341](https://www.github.com/googleapis/java-bigtable/issues/341)) ([071d0fe](https://www.github.com/googleapis/java-bigtable/commit/071d0feac03b5077b088a09244fe863aa111c231))
* update autovalue.version to v1.7.4 ([#365](https://www.github.com/googleapis/java-bigtable/issues/365)) ([18ba73d](https://www.github.com/googleapis/java-bigtable/commit/18ba73da3e6f1035699dc885109f90ffb160cb4e))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.6.0 ([#325](https://www.github.com/googleapis/java-bigtable/issues/325)) ([6fc5b7b](https://www.github.com/googleapis/java-bigtable/commit/6fc5b7b1f13c5326001cc7bcecbf4918a8505d26))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.7.0 ([#326](https://www.github.com/googleapis/java-bigtable/issues/326)) ([2aab7a8](https://www.github.com/googleapis/java-bigtable/commit/2aab7a8ec8775ab67e0277fd1785ee4735e1521d))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.1 ([#343](https://www.github.com/googleapis/java-bigtable/issues/343)) ([f0314a1](https://www.github.com/googleapis/java-bigtable/commit/f0314a13841cff495cc3424805a0aaf19bcc71d0))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.2 ([#362](https://www.github.com/googleapis/java-bigtable/issues/362)) ([1c37f5d](https://www.github.com/googleapis/java-bigtable/commit/1c37f5df35e4a317ac339e5d5b3cd50acf8e8c5a))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.3 ([#366](https://www.github.com/googleapis/java-bigtable/issues/366)) ([ade8b36](https://www.github.com/googleapis/java-bigtable/commit/ade8b362d66378e6b1ba75c6c04558e4437080a9))
* update dependency com.google.errorprone:error_prone_annotations to v2.4.0 ([#328](https://www.github.com/googleapis/java-bigtable/issues/328)) ([b9e5e83](https://www.github.com/googleapis/java-bigtable/commit/b9e5e832791b728d5931e1fe4546d01ffb4903d1))
* update protobuf.version to v3.12.2 ([#320](https://www.github.com/googleapis/java-bigtable/issues/320)) ([d5cf1d4](https://www.github.com/googleapis/java-bigtable/commit/d5cf1d4a62f9782c18a2d7ebb48d137426f84d5b))
* use google-cloud-shared-dependencies in bigtable deps bom ([#324](https://www.github.com/googleapis/java-bigtable/issues/324)) ([8f76fc8](https://www.github.com/googleapis/java-bigtable/commit/8f76fc8e7d326ed7837070cf496a2f20d4c7485e))

## [1.13.0](https://www.github.com/googleapis/java-bigtable/compare/v1.12.2...v1.13.0) (2020-05-27)


### Features

* adding utility to transform protobuf into model object ([#299](https://www.github.com/googleapis/java-bigtable/issues/299)) ([00f6d2d](https://www.github.com/googleapis/java-bigtable/commit/00f6d2da4179eb3f4f55a1fe1da04047697c5999))
* expose new API with ReadRowsRequest in EnhancedBigtableStub ([#276](https://www.github.com/googleapis/java-bigtable/issues/276)) ([394efe4](https://www.github.com/googleapis/java-bigtable/commit/394efe459ebe34030bf1d09116eebb4ec4f311e9))
* Update opencensus metrics to include bigtable resource ids and rpc level metrics ([#214](https://www.github.com/googleapis/java-bigtable/issues/214)) ([7214ef6](https://www.github.com/googleapis/java-bigtable/commit/7214ef6853fc6892401b55bd1beeccbe896e4f33))


### Bug Fixes

* bigtable v2 retry config settings to disable streaming RPC retries ([#315](https://www.github.com/googleapis/java-bigtable/issues/315)) ([a7e43f0](https://www.github.com/googleapis/java-bigtable/commit/a7e43f07dc0b93c6702992d45444e815200bf202))
* change app_profile_id to the correct header app_profile ([#318](https://www.github.com/googleapis/java-bigtable/issues/318)) ([237b15d](https://www.github.com/googleapis/java-bigtable/commit/237b15d14b420005d32f227e1a76e7d308db0a42))


### Dependencies

* update autovalue.version to v1.7.2 ([#306](https://www.github.com/googleapis/java-bigtable/issues/306)) ([bc215c5](https://www.github.com/googleapis/java-bigtable/commit/bc215c5883b16727c28893b4a13b3387f0a04ac9))
* update dependency com.google.api:api-common to v1.9.1 ([#316](https://www.github.com/googleapis/java-bigtable/issues/316)) ([482603a](https://www.github.com/googleapis/java-bigtable/commit/482603acd4c3db461b0e5f489a8c55213b9f3326))
* update dependency com.google.cloud:google-cloud-conformance-tests to v0.0.11 ([#307](https://www.github.com/googleapis/java-bigtable/issues/307)) ([50a19a6](https://www.github.com/googleapis/java-bigtable/commit/50a19a6aded1b313390ff78b52d9ffc4f4cc7fdd))
* update dependency com.google.cloud:google-cloud-core-bom to v1.93.5 ([#317](https://www.github.com/googleapis/java-bigtable/issues/317)) ([7f61f90](https://www.github.com/googleapis/java-bigtable/commit/7f61f903abc16554c88850061faf03e6b8beb3b9))
* update protobuf.version to v3.12.1 ([#308](https://www.github.com/googleapis/java-bigtable/issues/308)) ([99e3a95](https://www.github.com/googleapis/java-bigtable/commit/99e3a95d456bb79841720e8ecbdcb0d47017535e))


### Documentation

* **fix:** update client documentation link ([#312](https://www.github.com/googleapis/java-bigtable/issues/312)) ([7e04c7a](https://www.github.com/googleapis/java-bigtable/commit/7e04c7a69a80d71303ce62b4320153facd3cfad8))

### [1.12.2](https://www.github.com/googleapis/java-bigtable/compare/v1.12.1...v1.12.2) (2020-05-11)


### Bug Fixes

* set x-goog-api-client as internal header ([#293](https://www.github.com/googleapis/java-bigtable/issues/293)) ([3b58a4f](https://www.github.com/googleapis/java-bigtable/commit/3b58a4fa82e7a1e003bf119ce3b8b52b6eb52e47))

### [1.12.1](https://www.github.com/googleapis/java-bigtable/compare/v1.12.0...v1.12.1) (2020-05-08)


### Bug Fixes

* add missing api-client header ([#290](https://www.github.com/googleapis/java-bigtable/issues/290)) ([656684b](https://www.github.com/googleapis/java-bigtable/commit/656684b7f0fff003bb582977beb828f83da9a135))

## [1.12.0](https://www.github.com/googleapis/java-bigtable/compare/v1.11.0...v1.12.0) (2020-05-06)


### Features

* add more context to row merging errors ([#281](https://www.github.com/googleapis/java-bigtable/issues/281)) ([d88547c](https://www.github.com/googleapis/java-bigtable/commit/d88547cb55e9e2df09471df62074165266847c6d))


### Bug Fixes

* **build:** fix version update flag in samples pom.xml ([#285](https://www.github.com/googleapis/java-bigtable/issues/285)) ([6a1f970](https://www.github.com/googleapis/java-bigtable/commit/6a1f9701574fcdd41bc8300115e21ebe31b6f426))


### Dependencies

* update autovalue.version to v1.7.1 ([#278](https://www.github.com/googleapis/java-bigtable/issues/278)) ([e2f4e9e](https://www.github.com/googleapis/java-bigtable/commit/e2f4e9e84277dd242bf2fc454ab3243ff557f1ca))
* update core dependencies ([#215](https://www.github.com/googleapis/java-bigtable/issues/215)) ([ad7aab4](https://www.github.com/googleapis/java-bigtable/commit/ad7aab435aa31541535e4e202f01a79484f007a5))
* update core dependencies for google-cloud-core and gax ([#240](https://www.github.com/googleapis/java-bigtable/issues/240)) ([8f384f4](https://www.github.com/googleapis/java-bigtable/commit/8f384f48e984c69b10a515d15324227b40130d83))
* update dependency com.google.api:api-common to v1.9.0 ([#231](https://www.github.com/googleapis/java-bigtable/issues/231)) ([9a0f983](https://www.github.com/googleapis/java-bigtable/commit/9a0f9838c9a96ae1108da36f79bf1a4cdf4b5749))
* update dependency com.google.api:gax-bom to v1.55.0 ([#234](https://www.github.com/googleapis/java-bigtable/issues/234)) ([f910a32](https://www.github.com/googleapis/java-bigtable/commit/f910a32abef5b24a093c1ecef71d47811c458b41))
* update dependency com.google.cloud:google-cloud-conformance-tests to v0.0.10 ([#271](https://www.github.com/googleapis/java-bigtable/issues/271)) ([2bf6195](https://www.github.com/googleapis/java-bigtable/commit/2bf6195e8c215b8a6a72b66711fb24e98f3ab5a2))
* update dependency com.google.cloud:google-cloud-conformance-tests to v0.0.8 ([#216](https://www.github.com/googleapis/java-bigtable/issues/216)) ([423cb6b](https://www.github.com/googleapis/java-bigtable/commit/423cb6b395aa67986993f7d6c9dbd588e93faca6))
* update dependency com.google.cloud:google-cloud-conformance-tests to v0.0.9 ([#230](https://www.github.com/googleapis/java-bigtable/issues/230)) ([a84c689](https://www.github.com/googleapis/java-bigtable/commit/a84c689150990fe39ccc8055941ffb237cd499f5))
* update dependency com.google.cloud:google-cloud-core-bom to v1.93.3 ([#219](https://www.github.com/googleapis/java-bigtable/issues/219)) ([92f2755](https://www.github.com/googleapis/java-bigtable/commit/92f2755ca3b5218daa286556ce2c8b2f5b79fad6))
* update dependency com.google.cloud.samples:shared-configuration to v1.0.15 ([#246](https://www.github.com/googleapis/java-bigtable/issues/246)) ([3348210](https://www.github.com/googleapis/java-bigtable/commit/33482104496856dc849fe9858c429266a6caf4da))
* update dependency com.google.guava:guava-bom to v29 ([#244](https://www.github.com/googleapis/java-bigtable/issues/244)) ([0f7bd45](https://www.github.com/googleapis/java-bigtable/commit/0f7bd45bf15ebe25e2b5dd75134885e43b2604f0))
* update dependency com.google.http-client:google-http-client-bom to v1.35.0 ([#272](https://www.github.com/googleapis/java-bigtable/issues/272)) ([af0874b](https://www.github.com/googleapis/java-bigtable/commit/af0874bcbab22366514b89d8e567cbeeed4789f8))
* update dependency io.grpc:grpc-bom to v1.28.1 ([#236](https://www.github.com/googleapis/java-bigtable/issues/236)) ([4a72205](https://www.github.com/googleapis/java-bigtable/commit/4a72205018b39d71cfa54466fe44630c0e4202aa))
* update dependency io.grpc:grpc-bom to v1.29.0 ([#267](https://www.github.com/googleapis/java-bigtable/issues/267)) ([2e6393b](https://www.github.com/googleapis/java-bigtable/commit/2e6393b2bf4899ab603dfc6de9128df76d4ecb2d))
* update dependency org.threeten:threetenbp to v1.4.2 ([#225](https://www.github.com/googleapis/java-bigtable/issues/225)) ([5b94b02](https://www.github.com/googleapis/java-bigtable/commit/5b94b02ddc53c98d4a59e5457bdecc949d177c84))
* update dependency org.threeten:threetenbp to v1.4.3 ([#237](https://www.github.com/googleapis/java-bigtable/issues/237)) ([86fab5c](https://www.github.com/googleapis/java-bigtable/commit/86fab5cb90b1ca83c494f6787ca9d10d930ca1ff))
* update dependency org.threeten:threetenbp to v1.4.4 ([#270](https://www.github.com/googleapis/java-bigtable/issues/270)) ([6eba2af](https://www.github.com/googleapis/java-bigtable/commit/6eba2aff251fd3930a971d6270f297d449f21320))
* update google.common-protos.version to v1.18.0 ([#279](https://www.github.com/googleapis/java-bigtable/issues/279)) ([1571dd9](https://www.github.com/googleapis/java-bigtable/commit/1571dd939c24484309b8f484f73f29e602fce27c))
* update opencensus.version to v0.26.0 ([#223](https://www.github.com/googleapis/java-bigtable/issues/223)) ([1a00982](https://www.github.com/googleapis/java-bigtable/commit/1a00982eead27d3e3b13bc0c3942459618408e53))

## [1.11.0](https://www.github.com/googleapis/java-bigtable/compare/v1.10.0...v1.11.0) (2020-03-03)


### Features

* add row exists api ([#190](https://www.github.com/googleapis/java-bigtable/issues/190)) ([d141c3d](https://www.github.com/googleapis/java-bigtable/commit/d141c3d597cbd682050b78bb3828fd4d8c96a7c3))


### Dependencies

* update core dependencies ([#183](https://www.github.com/googleapis/java-bigtable/issues/183)) ([674bb73](https://www.github.com/googleapis/java-bigtable/commit/674bb73fa8a37233ba8f8d336e6e4be72a91f3a0))
* update dependency com.google.api:gax-bom to v1.54.0 ([#208](https://www.github.com/googleapis/java-bigtable/issues/208)) ([16cb625](https://www.github.com/googleapis/java-bigtable/commit/16cb62576058cb4124b98445f90b1afed012fd86))
* update dependency com.google.cloud:google-cloud-conformance-tests to v0.0.5 ([#180](https://www.github.com/googleapis/java-bigtable/issues/180)) ([687335b](https://www.github.com/googleapis/java-bigtable/commit/687335b97c1db121a5aa2681bbddd9c0b733d9c4))
* update dependency com.google.cloud:google-cloud-conformance-tests to v0.0.6 ([#207](https://www.github.com/googleapis/java-bigtable/issues/207)) ([6e803e9](https://www.github.com/googleapis/java-bigtable/commit/6e803e9ffdf70ace27d31caf3ba428a9017c1799))
* update dependency com.google.cloud:google-cloud-conformance-tests to v0.0.7 ([#210](https://www.github.com/googleapis/java-bigtable/issues/210)) ([9988811](https://www.github.com/googleapis/java-bigtable/commit/9988811e32eecee357c81beecab4199708b700fa))
* update dependency com.google.cloud:google-cloud-core-bom to v1.92.3 ([#179](https://www.github.com/googleapis/java-bigtable/issues/179)) ([7b896dd](https://www.github.com/googleapis/java-bigtable/commit/7b896dd60eb44e14d862789e9f8a15c113a235c8))
* update dependency com.google.cloud:google-cloud-core-bom to v1.92.5 ([279b64c](https://www.github.com/googleapis/java-bigtable/commit/279b64ca03da9e3f42e1468ea4f2b0a28f4ac939))
* update dependency com.google.cloud:google-cloud-core-bom to v1.93.0 ([#209](https://www.github.com/googleapis/java-bigtable/issues/209)) ([86905bf](https://www.github.com/googleapis/java-bigtable/commit/86905bfe12e7ea251c3eafafe328f87d7687bf4e))
* update dependency com.google.cloud:google-cloud-core-bom to v1.93.1 ([#211](https://www.github.com/googleapis/java-bigtable/issues/211)) ([a4596b5](https://www.github.com/googleapis/java-bigtable/commit/a4596b5db8d79bd86dfa33c7ae280a7227928398))
* update dependency com.google.http-client:google-http-client-bom to v1.34.1 ([#175](https://www.github.com/googleapis/java-bigtable/issues/175)) ([c25e8aa](https://www.github.com/googleapis/java-bigtable/commit/c25e8aa509796c33af4c53ffb68d7e40e6dbc237))
* update dependency com.google.http-client:google-http-client-bom to v1.34.2 ([#201](https://www.github.com/googleapis/java-bigtable/issues/201)) ([72c6d52](https://www.github.com/googleapis/java-bigtable/commit/72c6d527ce52d3fcc4f8340dcb2ded6035993260))
* update dependency io.grpc:grpc-bom to v1.27.0 ([#177](https://www.github.com/googleapis/java-bigtable/issues/177)) ([c8ab8a6](https://www.github.com/googleapis/java-bigtable/commit/c8ab8a6f94d7017f0ab0c7e2d23b99ba4388afd4))
* update dependency io.grpc:grpc-bom to v1.27.1 ([#200](https://www.github.com/googleapis/java-bigtable/issues/200)) ([c622be3](https://www.github.com/googleapis/java-bigtable/commit/c622be3fb3e2034b3834c38881015b04f01c2859))
* update dependency io.grpc:grpc-bom to v1.27.2 ([#206](https://www.github.com/googleapis/java-bigtable/issues/206)) ([33a609a](https://www.github.com/googleapis/java-bigtable/commit/33a609a0cdc32cdcbf42b04597a476b144849bce))
* update opencensus.version to v0.25.0 ([#198](https://www.github.com/googleapis/java-bigtable/issues/198)) ([1a36da2](https://www.github.com/googleapis/java-bigtable/commit/1a36da2c7e397650e6cac3172b9a9fcc953796ff))
* update protobuf.version to v3.11.3 ([#187](https://www.github.com/googleapis/java-bigtable/issues/187)) ([f38e3e3](https://www.github.com/googleapis/java-bigtable/commit/f38e3e37a51121b55faf91737bbb3cee36baa23a))
* update protobuf.version to v3.11.4 ([#202](https://www.github.com/googleapis/java-bigtable/issues/202)) ([f9b4438](https://www.github.com/googleapis/java-bigtable/commit/f9b44388cdb32af12314a00ab420278e29969d76))


### Documentation

* **regen:** update sample code to set total timeout, add API client header test ([f3be131](https://www.github.com/googleapis/java-bigtable/commit/f3be131923a86359be541b53627b15bda8ed407e))
* readme note for gke deployment configuration ([#185](https://www.github.com/googleapis/java-bigtable/issues/185)) ([0afa13a](https://www.github.com/googleapis/java-bigtable/commit/0afa13ae8df95119acc482ec79e204abd1bc333e))

## [1.10.0](https://www.github.com/googleapis/java-bigtable/compare/v1.9.1...v1.10.0) (2020-01-27)


### Features

* introducing bulk read API through Batcher ([#99](https://www.github.com/googleapis/java-bigtable/issues/99)) ([e87179e](https://www.github.com/googleapis/java-bigtable/commit/e87179ebe1e53b7962a940a9aba761da8047e7e4))


### Dependencies

* update dependency com.google.auth:google-auth-library-bom to v0.20.0 ([#168](https://www.github.com/googleapis/java-bigtable/issues/168)) ([8d69936](https://www.github.com/googleapis/java-bigtable/commit/8d69936e0d3cdba0085b363852e85fcb9eeb9dab))
* update dependency com.google.cloud:google-cloud-conformance-tests to v0.0.4 ([#157](https://www.github.com/googleapis/java-bigtable/issues/157)) ([abbc6c8](https://www.github.com/googleapis/java-bigtable/commit/abbc6c8c0ffbe1dcf88c14b1e70fe3150c61c582))
* update dependency com.google.cloud:google-cloud-core-bom to v1.92.2 ([#147](https://www.github.com/googleapis/java-bigtable/issues/147)) ([f3462b1](https://www.github.com/googleapis/java-bigtable/commit/f3462b119aa154f116e55f95e25171c482e08f8a))
* update dependency com.google.truth:truth to v1.0.1 ([#156](https://www.github.com/googleapis/java-bigtable/issues/156)) ([f767feb](https://www.github.com/googleapis/java-bigtable/commit/f767febcd3bf913bbb2e5421fa716a13a7b4a33b))
* update dependency org.threeten:threetenbp to v1.4.1 ([#153](https://www.github.com/googleapis/java-bigtable/issues/153)) ([f92da32](https://www.github.com/googleapis/java-bigtable/commit/f92da32e4834fe44148000f127b2962ecb94a67a))


### Documentation

* synth updates to javadoc and kokoro build configs ([d6275a7](https://www.github.com/googleapis/java-bigtable/commit/d6275a7877d98f5794ec7d400c10b2dce89167f0))

### [1.9.1](https://www.github.com/googleapis/java-bigtable/compare/v1.9.0...v1.9.1) (2020-01-09)


### Dependencies

* upgrade gax to 1.53.0 ([#145](https://www.github.com/googleapis/java-bigtable/issues/145)) ([c3fc40d](https://www.github.com/googleapis/java-bigtable/commit/c3fc40df4358bd68cddcfc6f0a3fedb74dcdf465))

## [1.9.0](https://www.github.com/googleapis/java-bigtable/compare/v1.8.0...v1.9.0) (2020-01-06)


### Features

* add BigtableDataClientFactory to create lightweight data clients ([#112](https://www.github.com/googleapis/java-bigtable/issues/112)) ([d6bfd30](https://www.github.com/googleapis/java-bigtable/commit/d6bfd30ea9484b7433a048bdaad66153ffaa6a79))
* introduce google-cloud-bigtable-deps-bom ([#130](https://www.github.com/googleapis/java-bigtable/issues/130)) ([9289a13](https://www.github.com/googleapis/java-bigtable/commit/9289a13203b009930507c858ed14326768174c28))


### Dependencies

* update core dependencies to v1.92.1 ([#132](https://www.github.com/googleapis/java-bigtable/issues/132)) ([da1e6c6](https://www.github.com/googleapis/java-bigtable/commit/da1e6c61770c934644588f8a9933f6f68bd35ad1))
* update dependency com.google.guava:guava-bom to v28.2-android ([2905528](https://www.github.com/googleapis/java-bigtable/commit/2905528eac8f39e2aa39ca5bca13c6aba33f178b))
* update dependency io.grpc:grpc-bom to v1.26.0 ([#121](https://www.github.com/googleapis/java-bigtable/issues/121)) ([82a5094](https://www.github.com/googleapis/java-bigtable/commit/82a50943e454a3e8a23f002128d842eb98458b51))
* update dependency junit:junit to v4.13 ([#131](https://www.github.com/googleapis/java-bigtable/issues/131)) ([d4f46fd](https://www.github.com/googleapis/java-bigtable/commit/d4f46fd7118f2037a58bae2c467ff11449ee4dfc))


### Documentation

* update README to include CI Status ([#125](https://www.github.com/googleapis/java-bigtable/issues/125)) ([1e4987b](https://www.github.com/googleapis/java-bigtable/commit/1e4987b8baaa7e0dfd3905e6acf643788d5c722c))

## [1.8.0](https://www.github.com/googleapis/java-bigtable/compare/v1.7.1...v1.8.0) (2019-12-17)


### Features

* add implementation of ChannelPrimer to establish connection to GFE and integrate into bigtable client ([#115](https://www.github.com/googleapis/java-bigtable/issues/115)) ([276f942](https://www.github.com/googleapis/java-bigtable/commit/276f942dd2e668600347a59496525a589d7560da))
* update filter to accept an exact timestamp for better accessibility ([#92](https://www.github.com/googleapis/java-bigtable/issues/92)) ([e25758b](https://www.github.com/googleapis/java-bigtable/commit/e25758b3164618ac16d57fffe6ba0e4175229960))


### Dependencies

* update gax.version to v1.51.0 ([#105](https://www.github.com/googleapis/java-bigtable/issues/105)) ([dcdd0c3](https://www.github.com/googleapis/java-bigtable/commit/dcdd0c347f10802be57c4f7267c2b82c59ea2278))
* upgrade gax to 1.52.0, google-cloud-core to 1.92.0 ([#118](https://www.github.com/googleapis/java-bigtable/issues/118)) ([c106497](https://www.github.com/googleapis/java-bigtable/commit/c1064977eff3889e4f8b6ba8ab44a08f6f96ae1f))

### [1.7.1](https://www.github.com/googleapis/java-bigtable/compare/v1.7.0...v1.7.1) (2019-11-13)


### Dependencies

* update gax.version to v1.50.1 ([#72](https://www.github.com/googleapis/java-bigtable/issues/72)) ([eb44a19](https://www.github.com/googleapis/java-bigtable/commit/eb44a19ccaed342b84dec80048802641dfd6609e))

## [1.7.0](https://www.github.com/googleapis/java-bigtable/compare/v1.6.0...v1.7.0) (2019-11-07)


### Features

* add bom ([#50](https://www.github.com/googleapis/java-bigtable/issues/50)) ([f4dd552](https://www.github.com/googleapis/java-bigtable/commit/f4dd552ea00044babe1273e322b8a330f093b2b0))


### Bug Fixes

* align version numbers for proto and grpc versions ([#52](https://www.github.com/googleapis/java-bigtable/issues/52)) ([dbfa73a](https://www.github.com/googleapis/java-bigtable/commit/dbfa73a1a336d0afb03e7755d17786216199a851))
* fix maven test configs to make sure admin tests don't clobber data tests ([#47](https://www.github.com/googleapis/java-bigtable/issues/47)) ([18576f5](https://www.github.com/googleapis/java-bigtable/commit/18576f55c34dbdc4c0ac79639dbc1dbf1ce7affe))
* fix regression in batch#close silently ignoring entry failures by upgrading to gax to 1.50.0 ([#67](https://www.github.com/googleapis/java-bigtable/issues/67)) ([5aa8769](https://www.github.com/googleapis/java-bigtable/commit/5aa87697a5e8860993a14f4ac42d675c66b3d0ff))
* handle recovery failures during stream reframing failure ([#46](https://www.github.com/googleapis/java-bigtable/issues/46)) ([a16cb88](https://www.github.com/googleapis/java-bigtable/commit/a16cb8864c0c8be26d34e71dbf261dbfc5e09bac))
* Prevent integration tests from different profiles from trampling each other ([#69](https://www.github.com/googleapis/java-bigtable/issues/69)) ([638615a](https://www.github.com/googleapis/java-bigtable/commit/638615ae09ec2d311e82d89ea7a78137911f4eb4))
* use proper scope for DirectPath transitive dependencies ([#59](https://www.github.com/googleapis/java-bigtable/issues/59)) ([1d1c4de](https://www.github.com/googleapis/java-bigtable/commit/1d1c4deb34a85836da2aed7b07359ff923b09835))


### Documentation

* cleanup links to java-bigtable and javadoc ([#56](https://www.github.com/googleapis/java-bigtable/issues/56)) ([846a44f](https://www.github.com/googleapis/java-bigtable/commit/846a44fbf9ebd5691a431e79a09a049aea5fd4f0))

## [1.6.0](https://www.github.com/googleapis/java-bigtable/compare/1.5.0...v1.6.0) (2019-10-24)


### Features

* Add Experimental DirectPath support ([#8](https://www.github.com/googleapis/java-bigtable/issues/8)) ([2dd5105](https://www.github.com/googleapis/java-bigtable/commit/2dd5105559f6f61f9780b11e44bccbd2c08d68ae))


### Dependencies

* update gax.version to v1.49.1 ([a138a0f](https://www.github.com/googleapis/java-bigtable/commit/a138a0f8f42ede72d5cd30536cef4e78e5de5843))
* upgrade threeten to 1.4 ([#33](https://www.github.com/googleapis/java-bigtable/issues/33)) ([554170b](https://www.github.com/googleapis/java-bigtable/commit/554170b929ec63155d0e840039e75b323dad1709))
