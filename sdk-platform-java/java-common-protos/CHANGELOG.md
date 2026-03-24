# Changelog

## [2.11.0](https://github.com/googleapis/java-common-protos/compare/v2.10.0...v2.11.0) (2022-11-21)


### Features

* Added google.api.Service.publishing and client libraries settings ([#481](https://github.com/googleapis/java-common-protos/issues/481)) ([d805f7e](https://github.com/googleapis/java-common-protos/commit/d805f7e16cdc3634ee377278221c2ac83f3a93e8))
* Next release from main branch is 2.11.0 ([#475](https://github.com/googleapis/java-common-protos/issues/475)) ([b641e49](https://github.com/googleapis/java-common-protos/commit/b641e497ca90d4b5d6136e1f84769d1301a7bdd9))


### Dependencies

* Update dependency io.grpc:grpc-bom to v1.51.0 ([#483](https://github.com/googleapis/java-common-protos/issues/483)) ([f2550c4](https://github.com/googleapis/java-common-protos/commit/f2550c4bdb0ea94f2876f63b12bde9f63031d820))
* Update dependency io.grpc:grpc-protobuf to v1.51.0 ([#484](https://github.com/googleapis/java-common-protos/issues/484)) ([c2cde01](https://github.com/googleapis/java-common-protos/commit/c2cde010a89123375518340819b420358e192302))
* Update dependency io.grpc:grpc-stub to v1.51.0 ([#485](https://github.com/googleapis/java-common-protos/issues/485)) ([873e01a](https://github.com/googleapis/java-common-protos/commit/873e01a40327939812cb75185b0a8dbb2eae8a47))

## [2.10.0](https://github.com/googleapis/java-common-protos/compare/v2.9.6...v2.10.0) (2022-11-04)


### Features

* Add FirstPartyAppMetadata to the BigQueryAuditMetadata proto, it contains metadata about requests originating from Google apps, such as Google Sheets ([86a868f](https://github.com/googleapis/java-common-protos/commit/86a868fd3925ec91e6acb7282195df8b5ad0f372))
* Add PolicyViolation to the AuditLog proto, this will only be present when access is denied due to Organization Policy. It describes why access is denied ([#456](https://github.com/googleapis/java-common-protos/issues/456)) ([86a868f](https://github.com/googleapis/java-common-protos/commit/86a868fd3925ec91e6acb7282195df8b5ad0f372))
* Added new events to BigQueryAuditMetadata such as UnlinkDataset and RowAccessPolicyCreation ([86a868f](https://github.com/googleapis/java-common-protos/commit/86a868fd3925ec91e6acb7282195df8b5ad0f372))


### Documentation

* Updated multiple comments ([86a868f](https://github.com/googleapis/java-common-protos/commit/86a868fd3925ec91e6acb7282195df8b5ad0f372))


### Dependencies

* Update dependency com.google.protobuf:protobuf-bom to v3.21.8 ([#461](https://github.com/googleapis/java-common-protos/issues/461)) ([7f94cb8](https://github.com/googleapis/java-common-protos/commit/7f94cb874aa0dd618eb47ab85a85dfe7cdcfbf81))
* Update dependency com.google.protobuf:protobuf-bom to v3.21.9 ([#469](https://github.com/googleapis/java-common-protos/issues/469)) ([965c1a1](https://github.com/googleapis/java-common-protos/commit/965c1a1fad3a37124ce7692bd4ae247771234bea))
* Update dependency com.google.protobuf:protobuf-java to v3.21.8 ([#462](https://github.com/googleapis/java-common-protos/issues/462)) ([185feb3](https://github.com/googleapis/java-common-protos/commit/185feb3813e54beaeb536d568644b26391470219))
* Update dependency com.google.protobuf:protobuf-java to v3.21.9 ([#470](https://github.com/googleapis/java-common-protos/issues/470)) ([499bcac](https://github.com/googleapis/java-common-protos/commit/499bcacc83141fb2fcb1b84c5942dfb53d316c22))
* Update dependency io.grpc:grpc-bom to v1.50.0 ([#458](https://github.com/googleapis/java-common-protos/issues/458)) ([37fae19](https://github.com/googleapis/java-common-protos/commit/37fae1934006613914e8123cde69c8f82158fd12))
* Update dependency io.grpc:grpc-bom to v1.50.2 ([#463](https://github.com/googleapis/java-common-protos/issues/463)) ([9f5407d](https://github.com/googleapis/java-common-protos/commit/9f5407db1a44d331a881739d410fa67df39e3e71))
* Update dependency io.grpc:grpc-protobuf to v1.50.0 ([#459](https://github.com/googleapis/java-common-protos/issues/459)) ([3f7c015](https://github.com/googleapis/java-common-protos/commit/3f7c0152e774bba00371f11e51efce9ca0cfa466))
* Update dependency io.grpc:grpc-protobuf to v1.50.2 ([#464](https://github.com/googleapis/java-common-protos/issues/464)) ([2910c5e](https://github.com/googleapis/java-common-protos/commit/2910c5e862440d37e672646e2c7845eb39a3002c))
* Update dependency io.grpc:grpc-stub to v1.50.0 ([#460](https://github.com/googleapis/java-common-protos/issues/460)) ([a056a8a](https://github.com/googleapis/java-common-protos/commit/a056a8a111974fe0c8312effcfe33da5b50c2100))
* Update dependency io.grpc:grpc-stub to v1.50.2 ([#465](https://github.com/googleapis/java-common-protos/issues/465)) ([5d6780c](https://github.com/googleapis/java-common-protos/commit/5d6780cfcfdd7e65beb89a7e7c7dd455204901fa))

## [2.9.6](https://github.com/googleapis/java-common-protos/compare/v2.9.5...v2.9.6) (2022-10-02)


### Dependencies

* Update dependency io.grpc:grpc-bom to v1.49.2 ([#448](https://github.com/googleapis/java-common-protos/issues/448)) ([70b435b](https://github.com/googleapis/java-common-protos/commit/70b435b006ec2b00b86491f10a6f53e689b9739c))
* Update dependency io.grpc:grpc-protobuf to v1.49.2 ([#449](https://github.com/googleapis/java-common-protos/issues/449)) ([fddd7a9](https://github.com/googleapis/java-common-protos/commit/fddd7a932c46462e1d7845d95260523aa10a9b8a))
* Update dependency io.grpc:grpc-stub to v1.49.2 ([#450](https://github.com/googleapis/java-common-protos/issues/450)) ([abbe6cc](https://github.com/googleapis/java-common-protos/commit/abbe6cc897a555d0a3814b9f4bf959fc5856333e))

## [2.9.5](https://github.com/googleapis/java-common-protos/compare/v2.9.4...v2.9.5) (2022-09-30)


### Dependencies

* Update dependency cachetools to v5 ([#439](https://github.com/googleapis/java-common-protos/issues/439)) ([d06e7f3](https://github.com/googleapis/java-common-protos/commit/d06e7f32a38d8cc6bf53da73d3a2516502525afb))
* Update dependency click to v8.1.3 ([#425](https://github.com/googleapis/java-common-protos/issues/425)) ([52e0472](https://github.com/googleapis/java-common-protos/commit/52e0472c4040b8e7be4f5c6f08f9cd93a86a69f6))
* Update dependency com.google.protobuf:protobuf-bom to v3.21.7 ([#444](https://github.com/googleapis/java-common-protos/issues/444)) ([bd3cc8e](https://github.com/googleapis/java-common-protos/commit/bd3cc8e46144d0e6d3fab60d9c0250749b81e5e9))
* Update dependency com.google.protobuf:protobuf-java to v3.21.7 ([#445](https://github.com/googleapis/java-common-protos/issues/445)) ([b649c95](https://github.com/googleapis/java-common-protos/commit/b649c95a455763bb71569cc111dbee842e39caae))
* Update dependency gcp-releasetool to v1.8.8 ([#423](https://github.com/googleapis/java-common-protos/issues/423)) ([48f448f](https://github.com/googleapis/java-common-protos/commit/48f448f711e3079339576d0b4b7940ae41bd6662))
* Update dependency google-api-core to v2.10.1 ([#426](https://github.com/googleapis/java-common-protos/issues/426)) ([ba6479a](https://github.com/googleapis/java-common-protos/commit/ba6479a7bfb37cfa11035ed904ed70b80b4555cb))
* Update dependency google-auth to v2.12.0 ([#427](https://github.com/googleapis/java-common-protos/issues/427)) ([db61fd7](https://github.com/googleapis/java-common-protos/commit/db61fd720ee9ac4aa27348344d6331bfb36259d6))
* Update dependency google-cloud-core to v2.3.2 ([#424](https://github.com/googleapis/java-common-protos/issues/424)) ([67c3c5b](https://github.com/googleapis/java-common-protos/commit/67c3c5bab83a33bfc5bf2f5918141389788eadbc))
* Update dependency google-cloud-storage to v2.5.0 ([#428](https://github.com/googleapis/java-common-protos/issues/428)) ([c84f880](https://github.com/googleapis/java-common-protos/commit/c84f8809a856854dcc21db3a16e4dea13b8ce51e))
* Update dependency google-crc32c to v1.5.0 ([#429](https://github.com/googleapis/java-common-protos/issues/429)) ([f296a84](https://github.com/googleapis/java-common-protos/commit/f296a8456f09606f1889bfd50f332b6149712058))
* Update dependency importlib-metadata to v4.12.0 ([#430](https://github.com/googleapis/java-common-protos/issues/430)) ([3065768](https://github.com/googleapis/java-common-protos/commit/3065768cd1b045f69a188eaa3fb2124a570a6872))
* Update dependency jeepney to v0.8.0 ([#431](https://github.com/googleapis/java-common-protos/issues/431)) ([05adbf4](https://github.com/googleapis/java-common-protos/commit/05adbf42df18e6dacd19bc4f2f375a83f5aa9507))
* Update dependency jinja2 to v3.1.2 ([#432](https://github.com/googleapis/java-common-protos/issues/432)) ([d04dedd](https://github.com/googleapis/java-common-protos/commit/d04dedd8b5f185ad59d2fccad28510e9c9bd1d1a))
* Update dependency keyring to v23.9.3 ([#442](https://github.com/googleapis/java-common-protos/issues/442)) ([8fe91e7](https://github.com/googleapis/java-common-protos/commit/8fe91e7c0a8c5d24e79c11ab997c01915690ba15))
* Update dependency markupsafe to v2.1.1 ([#433](https://github.com/googleapis/java-common-protos/issues/433)) ([ac10325](https://github.com/googleapis/java-common-protos/commit/ac10325a3ef909d8c60f185c5b327894995ab23e))
* Update dependency protobuf to v3.20.2 ([#434](https://github.com/googleapis/java-common-protos/issues/434)) ([2ee3681](https://github.com/googleapis/java-common-protos/commit/2ee3681fef9bf7e1d6fce2fe6112d16a8780bb97))
* Update dependency protobuf to v4 ([#440](https://github.com/googleapis/java-common-protos/issues/440)) ([8a5b536](https://github.com/googleapis/java-common-protos/commit/8a5b53679997ec03c0f9696dbed290a36f7a2200))
* Update dependency pyjwt to v2.5.0 ([#435](https://github.com/googleapis/java-common-protos/issues/435)) ([a1428ad](https://github.com/googleapis/java-common-protos/commit/a1428ad3bcc985646101b5593e08f1c633338c0d))
* Update dependency requests to v2.28.1 ([#436](https://github.com/googleapis/java-common-protos/issues/436)) ([05f5abf](https://github.com/googleapis/java-common-protos/commit/05f5abfc0f8746546ffef4cb1d008b32ad09c612))
* Update dependency typing-extensions to v4.3.0 ([#437](https://github.com/googleapis/java-common-protos/issues/437)) ([8980eb2](https://github.com/googleapis/java-common-protos/commit/8980eb2056c7472a7ca9afb6d2ecb8fa77b8b493))
* Update dependency zipp to v3.8.1 ([#438](https://github.com/googleapis/java-common-protos/issues/438)) ([a5e5fbc](https://github.com/googleapis/java-common-protos/commit/a5e5fbcde2252aa5a694e880387bc65171ac4070))

## [2.9.4](https://github.com/googleapis/java-common-protos/compare/v2.9.3...v2.9.4) (2022-09-28)


### Dependencies

* Update dependency certifi to v2022.9.24 ([#418](https://github.com/googleapis/java-common-protos/issues/418)) ([40f5dec](https://github.com/googleapis/java-common-protos/commit/40f5decf9cab5294b1e3d7622fd15beb6c5f34c5))
* Update dependency charset-normalizer to v2.1.1 ([#420](https://github.com/googleapis/java-common-protos/issues/420)) ([db48320](https://github.com/googleapis/java-common-protos/commit/db48320fb793522eb57dddab71576b6851d09bf4))
* Update dependency googleapis-common-protos to v1.56.4 ([#419](https://github.com/googleapis/java-common-protos/issues/419)) ([ca70ae5](https://github.com/googleapis/java-common-protos/commit/ca70ae5b1d7f9c2d3f2a631074acd7e80873f552))

## [2.9.3](https://github.com/googleapis/java-common-protos/compare/v2.9.2...v2.9.3) (2022-09-20)


### Dependencies

* Update dependency com.google.protobuf:protobuf-bom to v3.21.3 ([#393](https://github.com/googleapis/java-common-protos/issues/393)) ([f056dbe](https://github.com/googleapis/java-common-protos/commit/f056dbea9d92c92af9d4bffb8442704e4f3480e4))
* Update dependency com.google.protobuf:protobuf-bom to v3.21.4 ([#397](https://github.com/googleapis/java-common-protos/issues/397)) ([35f20b9](https://github.com/googleapis/java-common-protos/commit/35f20b942487f0500fa7919ddd9dd34e2a98da68))
* Update dependency com.google.protobuf:protobuf-bom to v3.21.5 ([#402](https://github.com/googleapis/java-common-protos/issues/402)) ([5279823](https://github.com/googleapis/java-common-protos/commit/5279823ab40a011b38003859d888ea48799bf86f))
* Update dependency com.google.protobuf:protobuf-bom to v3.21.6 ([#410](https://github.com/googleapis/java-common-protos/issues/410)) ([2ae81dc](https://github.com/googleapis/java-common-protos/commit/2ae81dcfe53630b422ab3d81785f9cab4ccd997e))
* Update dependency com.google.protobuf:protobuf-java to v3.21.3 ([#394](https://github.com/googleapis/java-common-protos/issues/394)) ([ada3199](https://github.com/googleapis/java-common-protos/commit/ada31991b01ff3bcc342b9c8f7e0aaf95b21ab66))
* Update dependency com.google.protobuf:protobuf-java to v3.21.4 ([#398](https://github.com/googleapis/java-common-protos/issues/398)) ([f6be516](https://github.com/googleapis/java-common-protos/commit/f6be516c23202d2502c25473ccf8bba009948cde))
* Update dependency com.google.protobuf:protobuf-java to v3.21.5 ([#403](https://github.com/googleapis/java-common-protos/issues/403)) ([89f8ae8](https://github.com/googleapis/java-common-protos/commit/89f8ae82df4fe608f58c6190324a3cec7441cf81))
* Update dependency com.google.protobuf:protobuf-java to v3.21.6 ([#411](https://github.com/googleapis/java-common-protos/issues/411)) ([764e5d9](https://github.com/googleapis/java-common-protos/commit/764e5d94828b6f4d02bc5d646496340fdada0f25))
* Update dependency io.grpc:grpc-bom to v1.49.0 and guava to 31.1-android ([#390](https://github.com/googleapis/java-common-protos/issues/390)) ([08d00ec](https://github.com/googleapis/java-common-protos/commit/08d00ec4ab8f9979f4a6b92f76e9666f045f9953))
* Update dependency io.grpc:grpc-bom to v1.49.1 ([#412](https://github.com/googleapis/java-common-protos/issues/412)) ([d4b66a0](https://github.com/googleapis/java-common-protos/commit/d4b66a03b49b16069ee0c0922448748620cc5745))
* Update dependency io.grpc:grpc-protobuf to v1.48.0 ([#391](https://github.com/googleapis/java-common-protos/issues/391)) ([171b4bf](https://github.com/googleapis/java-common-protos/commit/171b4bf8bd69ebd8111b0a2b6896282dbfa0525f))
* Update dependency io.grpc:grpc-protobuf to v1.48.1 ([#400](https://github.com/googleapis/java-common-protos/issues/400)) ([7c96c90](https://github.com/googleapis/java-common-protos/commit/7c96c908a819eef24c92cf9d65966e04825708d3))
* Update dependency io.grpc:grpc-protobuf to v1.49.0 ([#406](https://github.com/googleapis/java-common-protos/issues/406)) ([da8e116](https://github.com/googleapis/java-common-protos/commit/da8e116d60c17322c2a01de78a42f8e9d4498035))
* Update dependency io.grpc:grpc-protobuf to v1.49.1 ([#413](https://github.com/googleapis/java-common-protos/issues/413)) ([ab55975](https://github.com/googleapis/java-common-protos/commit/ab5597592c9eb86e4dcc81fa61a67a43d5edcb2a))
* Update dependency io.grpc:grpc-stub to v1.48.0 ([#392](https://github.com/googleapis/java-common-protos/issues/392)) ([7d404a0](https://github.com/googleapis/java-common-protos/commit/7d404a051ee53933c9f64a7e77cca589a2fd7ceb))
* Update dependency io.grpc:grpc-stub to v1.48.1 ([#401](https://github.com/googleapis/java-common-protos/issues/401)) ([60ae3bc](https://github.com/googleapis/java-common-protos/commit/60ae3bc53f0a3b2afc32e9b7be8789efb2b551da))
* Update dependency io.grpc:grpc-stub to v1.49.0 ([#407](https://github.com/googleapis/java-common-protos/issues/407)) ([bedb226](https://github.com/googleapis/java-common-protos/commit/bedb226200ab92d1336652c2c02101796d7c7262))
* Update dependency io.grpc:grpc-stub to v1.49.1 ([#414](https://github.com/googleapis/java-common-protos/issues/414)) ([d209727](https://github.com/googleapis/java-common-protos/commit/d20972705f275919eef3bc69f99f2d1cbfb7d026))

## [2.9.2](https://github.com/googleapis/java-common-protos/compare/v2.9.1...v2.9.2) (2022-07-13)


### Bug Fixes

* enable longpaths support for windows test ([#1485](https://github.com/googleapis/java-common-protos/issues/1485)) ([#386](https://github.com/googleapis/java-common-protos/issues/386)) ([fec7bed](https://github.com/googleapis/java-common-protos/commit/fec7bedbd0c3ac1d02de851616222b7189e5ed98))

## [2.9.1](https://github.com/googleapis/java-common-protos/compare/v2.9.0...v2.9.1) (2022-06-27)


### Dependencies

* update dependency com.google.protobuf:protobuf-bom to v3.21.2 ([#378](https://github.com/googleapis/java-common-protos/issues/378)) ([0c19c03](https://github.com/googleapis/java-common-protos/commit/0c19c03e9de22e11493e4d4d1ebca11063cf6926))
* update dependency com.google.protobuf:protobuf-java to v3.21.2 ([#379](https://github.com/googleapis/java-common-protos/issues/379)) ([ab6d1db](https://github.com/googleapis/java-common-protos/commit/ab6d1dbb2b7dd2fc8e4675087505f7da766f1a55))

## [2.9.0](https://github.com/googleapis/java-common-protos/compare/v2.8.3...v2.9.0) (2022-06-06)


### Features

* add build scripts for native image testing in Java 17 ([#1440](https://github.com/googleapis/java-common-protos/issues/1440)) ([#368](https://github.com/googleapis/java-common-protos/issues/368)) ([0b58c8c](https://github.com/googleapis/java-common-protos/commit/0b58c8c234513f82e7057ad7aa0c1d82b6bb9761))
* next release from main branch is 2.9.0 ([#354](https://github.com/googleapis/java-common-protos/issues/354)) ([1858e4f](https://github.com/googleapis/java-common-protos/commit/1858e4f90299ab6ae2fa937cd9c033c238540336))


### Dependencies

* update dependency com.google.protobuf:protobuf-bom to v3.20.1 ([#360](https://github.com/googleapis/java-common-protos/issues/360)) ([83fc812](https://github.com/googleapis/java-common-protos/commit/83fc812f71ca8870d3875f6fab3cdc4a3d91f8df))
* update dependency com.google.protobuf:protobuf-bom to v3.21.0 ([#369](https://github.com/googleapis/java-common-protos/issues/369)) ([b011a05](https://github.com/googleapis/java-common-protos/commit/b011a055c437395aac5fdf3fa32208f6dd958d69))
* update dependency com.google.protobuf:protobuf-bom to v3.21.1 ([#371](https://github.com/googleapis/java-common-protos/issues/371)) ([5f5c43a](https://github.com/googleapis/java-common-protos/commit/5f5c43a1ebc96a862b5881545f676b297526dde6))
* update dependency com.google.protobuf:protobuf-java to v3.20.1 ([#361](https://github.com/googleapis/java-common-protos/issues/361)) ([2423c08](https://github.com/googleapis/java-common-protos/commit/2423c08c1726ecfeba02edf19a9da4c8e4c9426f))
* update dependency com.google.protobuf:protobuf-java to v3.21.0 ([#370](https://github.com/googleapis/java-common-protos/issues/370)) ([de8d5f1](https://github.com/googleapis/java-common-protos/commit/de8d5f1a6486b01b5145460391161e8882f18b68))
* update dependency com.google.protobuf:protobuf-java to v3.21.1 ([#372](https://github.com/googleapis/java-common-protos/issues/372)) ([c9723c5](https://github.com/googleapis/java-common-protos/commit/c9723c5b6dd2ab386672b737ca26349c6a4e7731))
* update dependency io.grpc:grpc-bom to v1.46.0 ([#362](https://github.com/googleapis/java-common-protos/issues/362)) ([8222c0f](https://github.com/googleapis/java-common-protos/commit/8222c0ff268d2bbdaa1f591f0b840f099f421c5e))
* update dependency io.grpc:grpc-bom to v1.47.0 ([#373](https://github.com/googleapis/java-common-protos/issues/373)) ([71d07af](https://github.com/googleapis/java-common-protos/commit/71d07afa1ebb52d0cb95fac0529d343501a5c7a3))
* update dependency io.grpc:grpc-protobuf to v1.46.0 ([#363](https://github.com/googleapis/java-common-protos/issues/363)) ([c03a2b7](https://github.com/googleapis/java-common-protos/commit/c03a2b77a3bb7e637f8cce961fa23322bc977a29))
* update dependency io.grpc:grpc-protobuf to v1.47.0 ([#374](https://github.com/googleapis/java-common-protos/issues/374)) ([003fae8](https://github.com/googleapis/java-common-protos/commit/003fae815194859bae8724123925ab55774ba475))
* update dependency io.grpc:grpc-stub to v1.46.0 ([#364](https://github.com/googleapis/java-common-protos/issues/364)) ([0bc45a5](https://github.com/googleapis/java-common-protos/commit/0bc45a5254a21cd5eb0582abf9fe2fc7a54d45c7))
* update dependency io.grpc:grpc-stub to v1.47.0 ([#375](https://github.com/googleapis/java-common-protos/issues/375)) ([c27d218](https://github.com/googleapis/java-common-protos/commit/c27d218b4684ab378e631b3da4970f433929db68))

### [2.8.3](https://github.com/googleapis/java-common-protos/compare/v2.8.2...v2.8.3) (2022-04-12)


### Dependencies

* reverting protobuf java to 3.19 in pom.xml ([#351](https://github.com/googleapis/java-common-protos/issues/351)) ([3e8a624](https://github.com/googleapis/java-common-protos/commit/3e8a6249cc91d0ff4153563240f6ef18086c68ab))

### [2.8.2](https://github.com/googleapis/java-common-protos/compare/v2.8.1...v2.8.2) (2022-04-11)


### Dependencies

* revert protobuf to 3.19 ([#348](https://github.com/googleapis/java-common-protos/issues/348)) ([80b5ef6](https://github.com/googleapis/java-common-protos/commit/80b5ef6221a4bce5a15f4bde7ae0f964ab72452a))

### [2.8.1](https://github.com/googleapis/java-common-protos/compare/v2.8.0...v2.8.1) (2022-04-07)


### Dependencies

* update dependency com.google.protobuf:protobuf-bom to v3.20.0 ([#342](https://github.com/googleapis/java-common-protos/issues/342)) ([9314088](https://github.com/googleapis/java-common-protos/commit/931408869a86c05929496c27deafba8191f16518))
* update dependency com.google.protobuf:protobuf-java to v3.20.0 ([#343](https://github.com/googleapis/java-common-protos/issues/343)) ([7c1b0db](https://github.com/googleapis/java-common-protos/commit/7c1b0dbe597790514064c6923c278c1020037471))
* update dependency io.grpc:grpc-bom to v1.45.1 ([#339](https://github.com/googleapis/java-common-protos/issues/339)) ([4d713c3](https://github.com/googleapis/java-common-protos/commit/4d713c3cc3e071a858a1f10bb522a69c1cec9e22))
* update dependency io.grpc:grpc-protobuf to v1.45.1 ([#340](https://github.com/googleapis/java-common-protos/issues/340)) ([db951fb](https://github.com/googleapis/java-common-protos/commit/db951fbae45d249da9ba7ba44018da3043d0172a))
* update dependency io.grpc:grpc-stub to v1.45.1 ([#341](https://github.com/googleapis/java-common-protos/issues/341)) ([b661805](https://github.com/googleapis/java-common-protos/commit/b661805d37fe107d0bafc7fbabc1667cde6a1018))

## [2.8.0](https://github.com/googleapis/java-common-protos/compare/v2.7.4...v2.8.0) (2022-03-11)


### Features

* KMS configuration in settings ([#322](https://github.com/googleapis/java-common-protos/issues/322)) ([14ca04e](https://github.com/googleapis/java-common-protos/commit/14ca04e78d547cc643f419984747781c8915a261))


### Dependencies

* update dependency io.grpc:grpc-bom to v1.45.0 ([#323](https://github.com/googleapis/java-common-protos/issues/323)) ([ac71fd9](https://github.com/googleapis/java-common-protos/commit/ac71fd90e50498386c559b1e764c948677696ab9))
* update dependency io.grpc:grpc-protobuf to v1.44.1 ([#324](https://github.com/googleapis/java-common-protos/issues/324)) ([7be56a8](https://github.com/googleapis/java-common-protos/commit/7be56a87aadcbebc98d3136d8c7f4a54a8fe802d))
* update dependency io.grpc:grpc-protobuf to v1.45.0 ([#336](https://github.com/googleapis/java-common-protos/issues/336)) ([4bbd7a5](https://github.com/googleapis/java-common-protos/commit/4bbd7a5d8a57b0f171893e7f1ece6bee9f778f4e))
* update dependency io.grpc:grpc-stub to v1.44.1 ([#325](https://github.com/googleapis/java-common-protos/issues/325)) ([bf00d6a](https://github.com/googleapis/java-common-protos/commit/bf00d6a3067df2a6f057be601b27b29accc9d0fb))
* update dependency io.grpc:grpc-stub to v1.45.0 ([#335](https://github.com/googleapis/java-common-protos/issues/335)) ([3dd8e8f](https://github.com/googleapis/java-common-protos/commit/3dd8e8f4f9c56e4673b428b4ff43dfc30475c50c))

### [2.7.4](https://github.com/googleapis/java-common-protos/compare/v2.7.3...v2.7.4) (2022-02-11)


### Dependencies

* update actions/github-script action to v6 ([#319](https://github.com/googleapis/java-common-protos/issues/319)) ([a148f4d](https://github.com/googleapis/java-common-protos/commit/a148f4d5ae8a825b8cc3d4bcb1b33d1e94856689))

### [2.7.3](https://github.com/googleapis/java-common-protos/compare/v2.7.2...v2.7.3) (2022-02-08)


### Dependencies

* update dependency com.google.protobuf:protobuf-bom to v3.19.4 ([#309](https://github.com/googleapis/java-common-protos/issues/309)) ([c656ba3](https://github.com/googleapis/java-common-protos/commit/c656ba38e791cc3a72007299e51a68677e4d8857))
* update dependency com.google.protobuf:protobuf-java to v3.19.4 ([#308](https://github.com/googleapis/java-common-protos/issues/308)) ([effc391](https://github.com/googleapis/java-common-protos/commit/effc39190e46d421100cbc46926f4c032a8c3a28))

### [2.7.2](https://github.com/googleapis/java-common-protos/compare/v2.7.1...v2.7.2) (2022-01-27)


### Dependencies

* **java:** update actions/github-script action to v5 ([#1339](https://github.com/googleapis/java-common-protos/issues/1339)) ([#302](https://github.com/googleapis/java-common-protos/issues/302)) ([f958511](https://github.com/googleapis/java-common-protos/commit/f958511d71d0a0977ce54a5d66cb5f59fd141455))
* update dependency com.google.protobuf:protobuf-bom to v3.19.3 ([#297](https://github.com/googleapis/java-common-protos/issues/297)) ([97a806d](https://github.com/googleapis/java-common-protos/commit/97a806d0bcc1c411a5e7df496fbdd856f8e8ff1d))
* update dependency com.google.protobuf:protobuf-java to v3.19.3 ([#296](https://github.com/googleapis/java-common-protos/issues/296)) ([e53db58](https://github.com/googleapis/java-common-protos/commit/e53db5802c86070af4bd97835bbc850b1aecf7fe))
* update dependency io.grpc:grpc-bom to v1.43.2 ([#290](https://github.com/googleapis/java-common-protos/issues/290)) ([4bdf68a](https://github.com/googleapis/java-common-protos/commit/4bdf68ad19e1b4408f8e76ff9cf0287ed5a72622))
* update dependency io.grpc:grpc-bom to v1.44.0 ([#306](https://github.com/googleapis/java-common-protos/issues/306)) ([7041764](https://github.com/googleapis/java-common-protos/commit/70417647603bbffd541164c6e4dc593bb85d374a))
* update dependency io.grpc:grpc-protobuf to v1.43.2 ([#291](https://github.com/googleapis/java-common-protos/issues/291)) ([6832de8](https://github.com/googleapis/java-common-protos/commit/6832de8953d49e17c97cae9b714a353a0e085288))
* update dependency io.grpc:grpc-protobuf to v1.44.0 ([#304](https://github.com/googleapis/java-common-protos/issues/304)) ([db429bf](https://github.com/googleapis/java-common-protos/commit/db429bfd7325e7f908851eaa920058f2faadc3e1))
* update dependency io.grpc:grpc-stub to v1.43.2 ([#289](https://github.com/googleapis/java-common-protos/issues/289)) ([89c245a](https://github.com/googleapis/java-common-protos/commit/89c245a37ce8b62dc3cbd35f9fd07785f64d35b2))
* update dependency io.grpc:grpc-stub to v1.44.0 ([#305](https://github.com/googleapis/java-common-protos/issues/305)) ([a085bac](https://github.com/googleapis/java-common-protos/commit/a085bace22b154648f28baa81979804f75245c5d))

### [2.7.1](https://www.github.com/googleapis/java-common-protos/compare/v2.7.0...v2.7.1) (2022-01-05)


### Bug Fixes

* **java:** add -ntp flag to native image testing command ([#1299](https://www.github.com/googleapis/java-common-protos/issues/1299)) ([#272](https://www.github.com/googleapis/java-common-protos/issues/272)) ([5683ab6](https://www.github.com/googleapis/java-common-protos/commit/5683ab6b0e59ec252fe1d812ddcf7d682ce55bff))
* **java:** run Maven in plain console-friendly mode ([#1301](https://www.github.com/googleapis/java-common-protos/issues/1301)) ([#283](https://www.github.com/googleapis/java-common-protos/issues/283)) ([82343cc](https://www.github.com/googleapis/java-common-protos/commit/82343cc4aec4ee8b6ddee0b7febfc1e1aac94b4b))


### Dependencies

* update dependency com.google.protobuf:protobuf-bom to v3.19.2 ([#285](https://www.github.com/googleapis/java-common-protos/issues/285)) ([44bb642](https://www.github.com/googleapis/java-common-protos/commit/44bb6421b74ae78b00f890ec319269a891079c60))
* update dependency com.google.protobuf:protobuf-java to v3.19.2 ([#286](https://www.github.com/googleapis/java-common-protos/issues/286)) ([b94f86e](https://www.github.com/googleapis/java-common-protos/commit/b94f86e75260fb00c932fc416fff9c2db6bdb4d3))
* update dependency io.grpc:grpc-bom to v1.43.1 ([#276](https://www.github.com/googleapis/java-common-protos/issues/276)) ([381ec12](https://www.github.com/googleapis/java-common-protos/commit/381ec12454d2179cd46bf290727dce4aace293d6))
* update dependency io.grpc:grpc-protobuf to v1.43.1 ([#277](https://www.github.com/googleapis/java-common-protos/issues/277)) ([c757b6e](https://www.github.com/googleapis/java-common-protos/commit/c757b6e38ff90e5a669155fcf4256ea2a0f88b00))
* update dependency io.grpc:grpc-stub to v1.43.1 ([#278](https://www.github.com/googleapis/java-common-protos/issues/278)) ([702448d](https://www.github.com/googleapis/java-common-protos/commit/702448d6c9c5a592ebc96deb240d56a516c45e85))

## [2.7.0](https://www.github.com/googleapis/java-common-protos/compare/v2.6.0...v2.7.0) (2021-12-01)


### Features

* add Location proto ([#270](https://www.github.com/googleapis/java-common-protos/issues/270)) ([2e2c8dd](https://www.github.com/googleapis/java-common-protos/commit/2e2c8dd798524df1d0b81f2e809d38c1dd5f744d))
* Introduce Native Image testing build script changes ([#249](https://www.github.com/googleapis/java-common-protos/issues/249)) ([c2fa55a](https://www.github.com/googleapis/java-common-protos/commit/c2fa55a07150dc3e80bdc65948b610f851e87b90))
* next release from main branch is 2.7.0 ([#246](https://www.github.com/googleapis/java-common-protos/issues/246)) ([6a113a3](https://www.github.com/googleapis/java-common-protos/commit/6a113a3afdfee35c4c3af0606bbecc81828c85f0))


### Dependencies

* update dependency com.google.protobuf:protobuf-bom to v3.19.1 ([#251](https://www.github.com/googleapis/java-common-protos/issues/251)) ([a5dd0ab](https://www.github.com/googleapis/java-common-protos/commit/a5dd0ab11989e6e3577f938f42f429203a545b92))
* update dependency com.google.protobuf:protobuf-java to v3.19.1 ([#250](https://www.github.com/googleapis/java-common-protos/issues/250)) ([044a495](https://www.github.com/googleapis/java-common-protos/commit/044a4959423eca8481f723748dbf1919803ec55d))
* update dependency io.grpc:grpc-bom to v1.42.0 ([#258](https://www.github.com/googleapis/java-common-protos/issues/258)) ([dfc00e1](https://www.github.com/googleapis/java-common-protos/commit/dfc00e1857c4428255f6e852eacc6cab338bbf1b))
* update dependency io.grpc:grpc-bom to v1.42.1 ([#264](https://www.github.com/googleapis/java-common-protos/issues/264)) ([68fa087](https://www.github.com/googleapis/java-common-protos/commit/68fa087cafd92bbffd37eee6e3aacbf933886885))
* update dependency io.grpc:grpc-protobuf to v1.42.0 ([#259](https://www.github.com/googleapis/java-common-protos/issues/259)) ([6df71fa](https://www.github.com/googleapis/java-common-protos/commit/6df71facf9f5bb6c36d70cf85571fdee6648299e))
* update dependency io.grpc:grpc-protobuf to v1.42.1 ([#265](https://www.github.com/googleapis/java-common-protos/issues/265)) ([671a4cc](https://www.github.com/googleapis/java-common-protos/commit/671a4ccf8c56b1b12a5be7eba504758fa450be3b))
* update dependency io.grpc:grpc-stub to v1.42.0 ([#260](https://www.github.com/googleapis/java-common-protos/issues/260)) ([b15e723](https://www.github.com/googleapis/java-common-protos/commit/b15e7237e1aac5fe4f925f9300b792d11f1eb41c))
* update dependency io.grpc:grpc-stub to v1.42.1 ([#266](https://www.github.com/googleapis/java-common-protos/issues/266)) ([3b8a1ba](https://www.github.com/googleapis/java-common-protos/commit/3b8a1ba8444fde34ba59b6843463daab86833e35))

## [2.6.0](https://www.github.com/googleapis/java-common-protos/compare/v2.5.1...v2.6.0) (2021-10-14)


### Features

* add API classes for routing information ([#241](https://www.github.com/googleapis/java-common-protos/issues/241)) ([d1136e1](https://www.github.com/googleapis/java-common-protos/commit/d1136e139cd74bef717a73b3a8fc3b82055ab18e))


### Dependencies

* update dependency com.google.protobuf:protobuf-bom to v3.18.1 ([#237](https://www.github.com/googleapis/java-common-protos/issues/237)) ([e6da4bb](https://www.github.com/googleapis/java-common-protos/commit/e6da4bb3ba18fa39eae1fbe04c65b866097e5801))
* update dependency com.google.protobuf:protobuf-java to v3.18.1 ([#238](https://www.github.com/googleapis/java-common-protos/issues/238)) ([92ec21a](https://www.github.com/googleapis/java-common-protos/commit/92ec21ae83951a6b05da343c5f4bf3e8b9942b6d))
* update dependency io.grpc:grpc-bom to v1.41.0 and com.google.guava:guava to v31 ([#244](https://www.github.com/googleapis/java-common-protos/issues/244)) ([f0c638a](https://www.github.com/googleapis/java-common-protos/commit/f0c638a178e8ee02883f6570110f614f154f4814))

### [2.5.1](https://www.github.com/googleapis/java-common-protos/compare/v2.5.0...v2.5.1) (2021-09-24)


### Dependencies

* update dependency com.google.protobuf:protobuf-bom to v3.18.0 ([#224](https://www.github.com/googleapis/java-common-protos/issues/224)) ([7b41003](https://www.github.com/googleapis/java-common-protos/commit/7b4100372c2f614c929f27f1659d9d1b6bd7d716))
* update dependency com.google.protobuf:protobuf-java to v3.18.0 ([#225](https://www.github.com/googleapis/java-common-protos/issues/225)) ([9205c62](https://www.github.com/googleapis/java-common-protos/commit/9205c625308f82c4a2bf512b20b81bb5484a5ae9))
* update dependency io.grpc:grpc-protobuf to v1.41.0 ([#228](https://www.github.com/googleapis/java-common-protos/issues/228)) ([484e5c1](https://www.github.com/googleapis/java-common-protos/commit/484e5c111a7030693fb6462ac3e4b8928ddca3f3))
* update dependency io.grpc:grpc-stub to v1.41.0 ([#229](https://www.github.com/googleapis/java-common-protos/issues/229)) ([82de6a1](https://www.github.com/googleapis/java-common-protos/commit/82de6a18804e4c88b6f10422b2781a869aa61078))

## [2.5.0](https://www.github.com/googleapis/java-common-protos/compare/v2.4.1...v2.5.0) (2021-08-30)


### Features

* remove unused common_resources.proto ([#214](https://www.github.com/googleapis/java-common-protos/issues/214)) ([a72f73f](https://www.github.com/googleapis/java-common-protos/commit/a72f73fbd2936bf1ec52f3c1d395033bf7d06161))


### Dependencies

* update dependency com.google.protobuf:protobuf-java to v3.17.3 ([#211](https://www.github.com/googleapis/java-common-protos/issues/211)) ([5b14ce1](https://www.github.com/googleapis/java-common-protos/commit/5b14ce1f3af13c3f3afb919fe531f8ef5d70dccd))
* update dependency io.grpc:grpc-protobuf to v1.40.1 ([#212](https://www.github.com/googleapis/java-common-protos/issues/212)) ([a36de72](https://www.github.com/googleapis/java-common-protos/commit/a36de7220b35377bfb7240d0de2113d9fbad4372))
* update dependency io.grpc:grpc-stub to v1.40.1 ([#213](https://www.github.com/googleapis/java-common-protos/issues/213)) ([da18683](https://www.github.com/googleapis/java-common-protos/commit/da1868310827cbdf18fc600e8952e1b5dd835e2c))

### [2.4.1](https://www.github.com/googleapis/java-common-protos/compare/v2.4.0...v2.4.1) (2021-08-27)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-config to v1 ([#206](https://www.github.com/googleapis/java-common-protos/issues/206)) ([df8410e](https://www.github.com/googleapis/java-common-protos/commit/df8410e87f48e3d3585131e892767138a9dfe5fa))

## [2.4.0](https://www.github.com/googleapis/java-common-protos/compare/v2.3.2...v2.4.0) (2021-08-26)


### Features

* add new FieldBehavior NON_EMPTY_DEFAULT ([#191](https://www.github.com/googleapis/java-common-protos/issues/191)) ([acb2206](https://www.github.com/googleapis/java-common-protos/commit/acb2206e4dbe0b94c4ebbbe6bd924a258469f836))
* Add the `principal` field to the ServiceAccountDelegationInfo proto ([#183](https://www.github.com/googleapis/java-common-protos/issues/183)) ([b558909](https://www.github.com/googleapis/java-common-protos/commit/b558909b0355e5878e4785b76105735e2ca25422))
* generate java files for extended_operations.proto ([#200](https://www.github.com/googleapis/java-common-protos/issues/200)) ([fec9c81](https://www.github.com/googleapis/java-common-protos/commit/fec9c8140c1a03f823d69a787b8c1f59d45879a6))


### Bug Fixes

* Add `shopt -s nullglob` to dependencies script ([#189](https://www.github.com/googleapis/java-common-protos/issues/189)) ([89605e8](https://www.github.com/googleapis/java-common-protos/commit/89605e8edb10bb3ab3aaaa49a4cefba3fa590953))
* Update dependencies.sh to not break on mac ([#186](https://www.github.com/googleapis/java-common-protos/issues/186)) ([ae73232](https://www.github.com/googleapis/java-common-protos/commit/ae7323289c966d7690fcfcf672e19a58797be3df))


### Documentation

* modify some field level comments with new details and examples ([b558909](https://www.github.com/googleapis/java-common-protos/commit/b558909b0355e5878e4785b76105735e2ca25422))


### Dependencies

* update dependency com.google.protobuf:protobuf-bom to v3.17.3 ([#185](https://www.github.com/googleapis/java-common-protos/issues/185)) ([6f1b209](https://www.github.com/googleapis/java-common-protos/commit/6f1b209f32d8ee3ae38e9051f29d464fca507c84))
* update dependency io.grpc:grpc-bom to v1.38.1 ([#187](https://www.github.com/googleapis/java-common-protos/issues/187)) ([1086c1c](https://www.github.com/googleapis/java-common-protos/commit/1086c1cb870e49bc4b68992d293176909bc58a2d))

### [2.3.2](https://www.github.com/googleapis/java-common-protos/compare/v2.3.1...v2.3.2) (2021-06-03)


### Dependencies

* update dependency com.google.protobuf:protobuf-bom to v3.17.2 ([#180](https://www.github.com/googleapis/java-common-protos/issues/180)) ([9740ade](https://www.github.com/googleapis/java-common-protos/commit/9740ade8b3d7cd9947f7afeb5bf4261363e959a2))

### [2.3.1](https://www.github.com/googleapis/java-common-protos/compare/v2.3.0...v2.3.1) (2021-05-26)


### Dependencies

* update dependency com.google.protobuf:protobuf-bom to v3.17.1 ([#175](https://www.github.com/googleapis/java-common-protos/issues/175)) ([16e63af](https://www.github.com/googleapis/java-common-protos/commit/16e63afb82eda6d25e277beafb4094ac39148cb0))

## [2.3.0](https://www.github.com/googleapis/java-common-protos/compare/v2.2.2...v2.3.0) (2021-05-20)


### Features

* update protos in the repo from googleapis ([#169](https://www.github.com/googleapis/java-common-protos/issues/169)) ([abd8291](https://www.github.com/googleapis/java-common-protos/commit/abd8291f0983f3412b3a259444845530163f6643)), closes [#134](https://www.github.com/googleapis/java-common-protos/issues/134)

### [2.2.2](https://www.github.com/googleapis/java-common-protos/compare/v2.2.1...v2.2.2) (2021-05-19)


### Dependencies

* update dependency io.grpc:grpc-bom to v1.38.0 ([#164](https://www.github.com/googleapis/java-common-protos/issues/164)) ([7710d09](https://www.github.com/googleapis/java-common-protos/commit/7710d091a47499100525253ac575d4249a5818e5))

### [2.2.1](https://www.github.com/googleapis/java-common-protos/compare/v2.2.0...v2.2.1) (2021-05-14)


### Dependencies

* update dependency com.google.protobuf:protobuf-bom to v3.17.0 ([#160](https://www.github.com/googleapis/java-common-protos/issues/160)) ([c0f7e07](https://www.github.com/googleapis/java-common-protos/commit/c0f7e074749aa962f7c0035d6c3f25d876403765))

## [2.2.0](https://www.github.com/googleapis/java-common-protos/compare/v2.1.0...v2.2.0) (2021-05-12)


### Features

* **generator:** update protoc to v3.15.3 ([#123](https://www.github.com/googleapis/java-common-protos/issues/123)) ([6e4c513](https://www.github.com/googleapis/java-common-protos/commit/6e4c513c736d03deddd4d61d98969a866e2a2600))
* introduce google.type.Decimal ([#133](https://www.github.com/googleapis/java-common-protos/issues/133)) ([2602033](https://www.github.com/googleapis/java-common-protos/commit/2602033ac638869765c331a6431940302c0a9147))
* Publish visibility.proto ([#148](https://www.github.com/googleapis/java-common-protos/issues/148)) ([70a872e](https://www.github.com/googleapis/java-common-protos/commit/70a872e3cdf3141d745028f4774574019c2eb7df))


### Bug Fixes

* correct maven artifact metadata ([#145](https://www.github.com/googleapis/java-common-protos/issues/145)) ([15f5c4a](https://www.github.com/googleapis/java-common-protos/commit/15f5c4a51124ce2d193f3947c1ef63710e25e7af)), closes [#72](https://www.github.com/googleapis/java-common-protos/issues/72)
* release scripts from issuing overlapping phases ([#142](https://www.github.com/googleapis/java-common-protos/issues/142)) ([36fedec](https://www.github.com/googleapis/java-common-protos/commit/36fedec9122adf95dfc4171311d4161867f8c8a6))
* typo ([#140](https://www.github.com/googleapis/java-common-protos/issues/140)) ([e05c3f9](https://www.github.com/googleapis/java-common-protos/commit/e05c3f9ada5fe444dd782dd7297b210e6c617b10))


### Documentation

* correct label format for monitored_resource and log_entry labels for managed monitored_resource should not have forward slash labels for log_entry should not have forward slash ([#128](https://www.github.com/googleapis/java-common-protos/issues/128)) ([05cfd8c](https://www.github.com/googleapis/java-common-protos/commit/05cfd8ca8f574502aa66b5be491eaaf7c1a01539))


### Dependencies

* update dependency com.google.protobuf:protobuf-bom to v3.15.6 ([#122](https://www.github.com/googleapis/java-common-protos/issues/122)) ([3fe8289](https://www.github.com/googleapis/java-common-protos/commit/3fe8289816924b9d4fdcefa49f225fc456c44064))
* update dependency com.google.protobuf:protobuf-bom to v3.15.8 ([#137](https://www.github.com/googleapis/java-common-protos/issues/137)) ([e3315de](https://www.github.com/googleapis/java-common-protos/commit/e3315debecbfd08db73b9c7303e0760024ff7504))
* update dependency com.google.protobuf:protobuf-bom to v3.16.0 ([#152](https://www.github.com/googleapis/java-common-protos/issues/152)) ([fe2b858](https://www.github.com/googleapis/java-common-protos/commit/fe2b8584a72cd8ca2adeb311f2a4b5cd2b642983))
* update dependency io.grpc:grpc-bom to v1.37.0 ([#131](https://www.github.com/googleapis/java-common-protos/issues/131)) ([5f6476a](https://www.github.com/googleapis/java-common-protos/commit/5f6476a8d3c88f97aa033b95b65d65b9a2de1421))

## [2.1.0](https://www.github.com/googleapis/java-common-protos/compare/v2.0.1...v2.1.0) (2021-02-24)


### Features

* Add `ErrorReason` enum from `google.api.error_reason` for Google API and minor proto updates. ([528a2ae](https://www.github.com/googleapis/java-common-protos/commit/528a2ae726e9a63a49e4850078f28a14431c033f))
* add Interval, Month, PhoneNumber type protos ([#80](https://www.github.com/googleapis/java-common-protos/issues/80)) ([696083b](https://www.github.com/googleapis/java-common-protos/commit/696083b83bd3ba906d13cfdd50846971a74b165f))
* Add the `UNORDERED_LIST` enum value for `google.api.field_behavior`. ([#95](https://www.github.com/googleapis/java-common-protos/issues/95)) ([51d6ae0](https://www.github.com/googleapis/java-common-protos/commit/51d6ae0b02c9c7dd32cf55dd0a67181a3f8618fe))
* Enhance the AttributeContext semantics, and other comments update ([#113](https://www.github.com/googleapis/java-common-protos/issues/113)) ([528a2ae](https://www.github.com/googleapis/java-common-protos/commit/528a2ae726e9a63a49e4850078f28a14431c033f))


### Documentation

* changes "may" to preferred "might" ([efb1726](https://www.github.com/googleapis/java-common-protos/commit/efb17264f970dcaecb3e59664c99e413baa8bc8f))
* regenerate javadocs from protos ([#69](https://www.github.com/googleapis/java-common-protos/issues/69)) ([1759fe7](https://www.github.com/googleapis/java-common-protos/commit/1759fe7650869500e0d7b712fe8ef1bcc346d27a))
* update generated logging type javadoc ([#87](https://www.github.com/googleapis/java-common-protos/issues/87)) ([9f122e8](https://www.github.com/googleapis/java-common-protos/commit/9f122e82982d96c91343ee6c082f1687570fa15b))
* Update inclusive language in the documentation. Also other latest doc updates. ([#78](https://www.github.com/googleapis/java-common-protos/issues/78)) ([fda2e7b](https://www.github.com/googleapis/java-common-protos/commit/fda2e7be4961ef27fc0908f5dffd63b6248f0507))
* Updates "unit" description: changes "KBy" to "kBy" ([#99](https://www.github.com/googleapis/java-common-protos/issues/99)) ([efb1726](https://www.github.com/googleapis/java-common-protos/commit/efb17264f970dcaecb3e59664c99e413baa8bc8f))
* updates an "http" link to "https" ([efb1726](https://www.github.com/googleapis/java-common-protos/commit/efb17264f970dcaecb3e59664c99e413baa8bc8f))


### Dependencies

* update dependency com.google.guava:guava to v30.1-android ([#96](https://www.github.com/googleapis/java-common-protos/issues/96)) ([ad6beb6](https://www.github.com/googleapis/java-common-protos/commit/ad6beb636c6fbd6ede923db4b2132cc2b1c2b5b3))
* update dependency com.google.protobuf:protobuf-bom to v3.14.0 ([#86](https://www.github.com/googleapis/java-common-protos/issues/86)) ([ad85e3a](https://www.github.com/googleapis/java-common-protos/commit/ad85e3a9e0becdb0873a3aa474bb45ecbe02b7d6))
* update dependency com.google.protobuf:protobuf-bom to v3.15.0 ([#116](https://www.github.com/googleapis/java-common-protos/issues/116)) ([8e48b28](https://www.github.com/googleapis/java-common-protos/commit/8e48b28797d00b61b3ecfa2eb2a75aa4fe6d9dd9))
* update dependency com.google.protobuf:protobuf-bom to v3.15.2 ([#118](https://www.github.com/googleapis/java-common-protos/issues/118)) ([5e7415a](https://www.github.com/googleapis/java-common-protos/commit/5e7415aa6b05dac3080a29d3e9e01b949c9bc864))
* update dependency io.grpc:grpc-bom to v1.35.0 ([#93](https://www.github.com/googleapis/java-common-protos/issues/93)) ([6243d5b](https://www.github.com/googleapis/java-common-protos/commit/6243d5b733a1ec83860a5b5e4e3fc307c9ae52dd))
* update dependency io.grpc:grpc-bom to v1.36.0 ([#119](https://www.github.com/googleapis/java-common-protos/issues/119)) ([9eb9d03](https://www.github.com/googleapis/java-common-protos/commit/9eb9d03f69cdb4bf6ed8243ba253441fdd982ff1))

### [2.0.1](https://www.github.com/googleapis/java-common-protos/compare/v2.0.0...v2.0.1) (2020-11-02)


### Dependencies

* update dependency com.google.guava:guava to v30 ([#68](https://www.github.com/googleapis/java-common-protos/issues/68)) ([744f4a7](https://www.github.com/googleapis/java-common-protos/commit/744f4a72fc373440c4ac5fa5e8b85152ca8385be))
* update dependency io.grpc:grpc-bom to v1.33.1 ([#67](https://www.github.com/googleapis/java-common-protos/issues/67)) ([b729eb3](https://www.github.com/googleapis/java-common-protos/commit/b729eb3ca99aa510c3bb31fa5225a0f5d18edfd0))

## [2.0.0](https://www.github.com/googleapis/java-common-protos/compare/v1.18.1...v2.0.0) (2020-10-15)


### ⚠ BREAKING CHANGES

* `features` removed from Endpoint

### Features

* remove `features` from Endpoint. add service_root_url to Documentation add UNIMPLEMENTED, PRELAUNCH LaunchStage values add monitoried_resource_types to MetricDescriptor ([#35](https://www.github.com/googleapis/java-common-protos/issues/35)) ([cdd4e56](https://www.github.com/googleapis/java-common-protos/commit/cdd4e5633b1e4f5dc199ddc513ea7f238d2150d5))


### Dependencies

* update dependency com.google.protobuf:protobuf-bom to v3.12.4 ([#19](https://www.github.com/googleapis/java-common-protos/issues/19)) ([8d43144](https://www.github.com/googleapis/java-common-protos/commit/8d43144f2512a566005f8ae9ef0819fd9c165d39))
* update dependency com.google.protobuf:protobuf-bom to v3.13.0 ([#26](https://www.github.com/googleapis/java-common-protos/issues/26)) ([a51daab](https://www.github.com/googleapis/java-common-protos/commit/a51daab546f84d6ef3ed1d457d304f3ec986afd9))
* update dependency io.grpc:grpc-bom to v1.31.1 ([#16](https://www.github.com/googleapis/java-common-protos/issues/16)) ([a0b20f1](https://www.github.com/googleapis/java-common-protos/commit/a0b20f1d9bf787f3cc6c4634f13fcd6e895a69e1))
* update dependency io.grpc:grpc-bom to v1.32.1 ([#31](https://www.github.com/googleapis/java-common-protos/issues/31)) ([3dc5426](https://www.github.com/googleapis/java-common-protos/commit/3dc54267e1d166d28351113f4374b25eec7b5714))
* update dependency io.grpc:grpc-bom to v1.32.2 ([#56](https://www.github.com/googleapis/java-common-protos/issues/56)) ([1e62ad5](https://www.github.com/googleapis/java-common-protos/commit/1e62ad5229b0e3387d6af0512bd043c59782109f))

### [1.18.1](https://www.github.com/googleapis/java-common-protos/compare/v1.18.0...v1.18.1) (2020-08-11)


### Dependencies

* update dependency com.google.protobuf:protobuf-bom to v3.12.0 ([#8](https://www.github.com/googleapis/java-common-protos/issues/8)) ([cb0fcd9](https://www.github.com/googleapis/java-common-protos/commit/cb0fcd9f74ca51220d3b9e4b330575920732dfa1))
* update dependency com.google.protobuf:protobuf-bom to v3.12.2 ([#10](https://www.github.com/googleapis/java-common-protos/issues/10)) ([d1e68f6](https://www.github.com/googleapis/java-common-protos/commit/d1e68f6733737f31cad7855ffee10000ec37f73a))
* update dependency io.grpc:grpc-bom to v1.30.0 ([#12](https://www.github.com/googleapis/java-common-protos/issues/12)) ([67a5c0f](https://www.github.com/googleapis/java-common-protos/commit/67a5c0f695eefd0dca740544089a338cfecb700f))

## [1.18.0](https://www.github.com/googleapis/java-common-protos/compare/v1.17.0...v1.18.0) (2020-05-04)


### Features

* add DateTime/TimeOfDay protos ([#1](https://www.github.com/googleapis/java-common-protos/issues/1)) ([e33500c](https://www.github.com/googleapis/java-common-protos/commit/e33500c45789ece6f5f3b29d37a127bdc767dde0))
