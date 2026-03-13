# Changelog

## [2.67.0](https://github.com/googleapis/sdk-platform-java/compare/v2.66.1...v2.67.0) (2026-02-18)


### Features

* **observability:** introduce minimal tracing implementation ([#4105](https://github.com/googleapis/sdk-platform-java/issues/4105)) ([e4e5e89](https://github.com/googleapis/sdk-platform-java/commit/e4e5e893e7a62bd12528e7d448dc2789f71946eb))


### Dependencies

* Upgrade Google-Auth-Library to v1.43.0 ([#4114](https://github.com/googleapis/sdk-platform-java/issues/4114)) ([825298b](https://github.com/googleapis/sdk-platform-java/commit/825298b6bf225bb8536ecab9d788f82f3f8eec4d))
* Upgrade grpc to 1.76.3 ([#4106](https://github.com/googleapis/sdk-platform-java/issues/4106)) ([c6555f5](https://github.com/googleapis/sdk-platform-java/commit/c6555f5f0cd85683db76394271e1f57989cac7d0))

## [2.66.1](https://github.com/googleapis/sdk-platform-java/compare/v2.66.0...v2.66.1) (2026-02-04)


### Documentation

* [common-protos] update reference documentation for `SelectionInput.DROPDOWN` to include dynamic data sources and autosuggestion ([9960262](https://github.com/googleapis/sdk-platform-java/commit/9960262cf248400836c04063e6a701bec2aca1ba))

## [2.66.0](https://github.com/googleapis/sdk-platform-java/compare/v2.65.1...v2.66.0) (2026-01-23)


### Features

* Upgrade protobuf runtime and gen code to 4.33.x ([#4000](https://github.com/googleapis/sdk-platform-java/issues/4000)) ([#4074](https://github.com/googleapis/sdk-platform-java/issues/4074)) ([3e37376](https://github.com/googleapis/sdk-platform-java/commit/3e37376ccaddf42617436471dc9b014974b8e3df))


### Dependencies

* Downgrade opentelemetry to 1.51.0 ([#4075](https://github.com/googleapis/sdk-platform-java/issues/4075)) ([cf65482](https://github.com/googleapis/sdk-platform-java/commit/cf6548232830e0461500d92954050186e255b572))
* update auth library to 1.42.0 ([#4087](https://github.com/googleapis/sdk-platform-java/issues/4087)) ([ad9ee07](https://github.com/googleapis/sdk-platform-java/commit/ad9ee0731a64585ad8ee0f0ac71bece9f6eaf068))
* update googleapis/java-cloud-bom digest to ef3656d ([#3630](https://github.com/googleapis/sdk-platform-java/issues/3630)) ([790bcf0](https://github.com/googleapis/sdk-platform-java/commit/790bcf0542dc8aba5afe2f65e80a74d643b40cfe))
* update http-client to 2.1.0 ([#4086](https://github.com/googleapis/sdk-platform-java/issues/4086)) ([d8bc8f5](https://github.com/googleapis/sdk-platform-java/commit/d8bc8f5d335ffde52a603b47718574858f04f5ee))

## [2.65.1](https://github.com/googleapis/sdk-platform-java/compare/v2.65.0...v2.65.1) (2026-01-13)


### Documentation

* Update docs for GoogleCredentialsProvider#setScopesToApply ([#4057](https://github.com/googleapis/sdk-platform-java/issues/4057)) ([0a9962f](https://github.com/googleapis/sdk-platform-java/commit/0a9962f9945b6018796a808f89a6a3a309d1ca04))

## [2.65.0](https://github.com/googleapis/sdk-platform-java/compare/v2.64.2...v2.65.0) (2026-01-12)


### Features

* add org.json:json to third-party-dependencies pom ([#4047](https://github.com/googleapis/sdk-platform-java/issues/4047)) ([ffa432e](https://github.com/googleapis/sdk-platform-java/commit/ffa432e4e4ae763845afd48b404836c88698bdc0)), closes [#4046](https://github.com/googleapis/sdk-platform-java/issues/4046)
* remove dependency management of graal-sdk ([#4033](https://github.com/googleapis/sdk-platform-java/issues/4033)) ([ad05c34](https://github.com/googleapis/sdk-platform-java/commit/ad05c34e205c09ad035f469170b0c62b4423b748))


### Bug Fixes

* add api_version breadcrumb to client docs ([#4018](https://github.com/googleapis/sdk-platform-java/issues/4018)) ([a2b2179](https://github.com/googleapis/sdk-platform-java/commit/a2b2179874e6a5435001fe201f4eecc2a8e4c531))
* Create a single S2AChannelCredentials per application ([#3989](https://github.com/googleapis/sdk-platform-java/issues/3989)) ([3758b43](https://github.com/googleapis/sdk-platform-java/commit/3758b436d7e80b79ad7d5ea330d8f2bf2f430330))
* provide API to share the same background executor for channel po… ([#4030](https://github.com/googleapis/sdk-platform-java/issues/4030)) ([178182c](https://github.com/googleapis/sdk-platform-java/commit/178182c76c1b35e702215a88adc3ab511dd35a9e))


### Dependencies

* update dependencies.txt for grpc-gcp to 1.9.0  ([#4025](https://github.com/googleapis/sdk-platform-java/issues/4025)) ([b68791d](https://github.com/googleapis/sdk-platform-java/commit/b68791d074c02e02a5ccf2f937a5922749a14f56))
* update google api dependencies ([#3917](https://github.com/googleapis/sdk-platform-java/issues/3917)) ([480cf13](https://github.com/googleapis/sdk-platform-java/commit/480cf13148687c53c4af3da9d48490aeb5bf4b88))
* update google.http-client.version to 2.0.3 ([#4054](https://github.com/googleapis/sdk-platform-java/issues/4054)) ([b9a8c89](https://github.com/googleapis/sdk-platform-java/commit/b9a8c8924e7b03bca8a97e476abfd012b86f6d45))


### Documentation

* Fix retry guide link in javadocs ([#4029](https://github.com/googleapis/sdk-platform-java/issues/4029)) ([b43f77c](https://github.com/googleapis/sdk-platform-java/commit/b43f77c66d93d2423744d0f6d6a0a2a53a06e6d9))

## [2.64.2](https://github.com/googleapis/sdk-platform-java/compare/v2.64.1...v2.64.2) (2025-12-10)


### Bug Fixes

* add per-service api_version to gapic_metadata ([#3984](https://github.com/googleapis/sdk-platform-java/issues/3984)) ([d589306](https://github.com/googleapis/sdk-platform-java/commit/d589306c4ecc12a2a744cb9dfb914ccea8fb34fd))


### Dependencies

* Upgrade auth to 1.41.0. ([#4008](https://github.com/googleapis/sdk-platform-java/issues/4008)) ([833b3e5](https://github.com/googleapis/sdk-platform-java/commit/833b3e54c0f13ac8183a639c4464dcf58fd44096))
* upgrade grpc to 1.76.1 ([#3993](https://github.com/googleapis/sdk-platform-java/issues/3993)) ([958611e](https://github.com/googleapis/sdk-platform-java/commit/958611e23460dba596160f3224d8588afdba6bc2))
* Upgrade grpc to 1.76.2 ([#4006](https://github.com/googleapis/sdk-platform-java/issues/4006)) ([a8060a2](https://github.com/googleapis/sdk-platform-java/commit/a8060a263ba34556b8d4d347a57625849a6859bc))

## [2.64.1](https://github.com/googleapis/sdk-platform-java/compare/v2.64.0...v2.64.1) (2025-11-07)


### Dependencies

* bump opentelemetry.version to 1.52.0 ([#3979](https://github.com/googleapis/sdk-platform-java/issues/3979)) ([764778c](https://github.com/googleapis/sdk-platform-java/commit/764778cd63da247037e65d9a8ec3db93caccc806))

## [2.64.0](https://github.com/googleapis/sdk-platform-java/compare/v2.63.0...v2.64.0) (2025-10-31)


### Features

* [common-protos] Add `Carousel` widget ([1e4a7e5](https://github.com/googleapis/sdk-platform-java/commit/1e4a7e5088c88e5752cc24cbe44b14b3ce409778))
* **librariangen:** add generate package ([#3952](https://github.com/googleapis/sdk-platform-java/issues/3952)) ([2f6c75d](https://github.com/googleapis/sdk-platform-java/commit/2f6c75da3021d030c7a192f1fbb4b30908ef9dad))
* **librariangen:** generate grpc stubs and resource helpers ([#3967](https://github.com/googleapis/sdk-platform-java/issues/3967)) ([452d703](https://github.com/googleapis/sdk-platform-java/commit/452d703b703ab3222fd1a7060ed5e1ac6363322b))


### Dependencies

* Bump grpc-java to v1.76.0 ([#3942](https://github.com/googleapis/sdk-platform-java/issues/3942)) ([ffb557c](https://github.com/googleapis/sdk-platform-java/commit/ffb557ce8f3460f722b27b30af5e470edd93431b))

## [2.63.0](https://github.com/googleapis/sdk-platform-java/compare/v2.62.3...v2.63.0) (2025-10-16)


### Features

* **librariangen:** add bazel package ([#3940](https://github.com/googleapis/sdk-platform-java/issues/3940)) ([feabef3](https://github.com/googleapis/sdk-platform-java/commit/feabef32c4c45be0fb1db3615568365b902ece24))
* **librariangen:** add execv package ([#3932](https://github.com/googleapis/sdk-platform-java/issues/3932)) ([f6b0b47](https://github.com/googleapis/sdk-platform-java/commit/f6b0b47a14eddd9c76540362b5922a5acc56b5d4))
* **librariangen:** add protoc package ([#3935](https://github.com/googleapis/sdk-platform-java/issues/3935)) ([598de06](https://github.com/googleapis/sdk-platform-java/commit/598de0697957ea3b05b1347c0898108648c3d7d1))
* **librariangen:** add request package ([#3933](https://github.com/googleapis/sdk-platform-java/issues/3933)) ([fe44aed](https://github.com/googleapis/sdk-platform-java/commit/fe44aede2aba9627db4aa0397d2ac4de353cea03))
* **librariangen:** scaffold Java language container for Librarian ([#3926](https://github.com/googleapis/sdk-platform-java/issues/3926)) ([29d188d](https://github.com/googleapis/sdk-platform-java/commit/29d188d20e530570f46774b37d88703822774a33))


### Dependencies

* Bump errorprone-annotations to v2.42.0 ([8d6c1f9](https://github.com/googleapis/sdk-platform-java/commit/8d6c1f915ba5f0c4ac9b89120e63dddd62e37a22))
* Bump guava to v33.5.0 ([8d6c1f9](https://github.com/googleapis/sdk-platform-java/commit/8d6c1f915ba5f0c4ac9b89120e63dddd62e37a22))
* Bump j2objc-annotations to v3.1 ([8d6c1f9](https://github.com/googleapis/sdk-platform-java/commit/8d6c1f915ba5f0c4ac9b89120e63dddd62e37a22))
* update google auth library dependencies to v1.40.0 ([#3945](https://github.com/googleapis/sdk-platform-java/issues/3945)) ([1d74663](https://github.com/googleapis/sdk-platform-java/commit/1d7466332b5dc13fde6ed687247873135a5fa919))
* Upgrade Google Http Java Client to v2.0.2 ([#3946](https://github.com/googleapis/sdk-platform-java/issues/3946)) ([7fb4f15](https://github.com/googleapis/sdk-platform-java/commit/7fb4f155eef478c1a66bc2f1fdecd7565d225b3e))

## [2.62.3](https://github.com/googleapis/sdk-platform-java/compare/v2.62.2...v2.62.3) (2025-10-02)


### Bug Fixes

* **mtls:** Fix EndpointContext's determineEndpoint logic to respect env var ([#3912](https://github.com/googleapis/sdk-platform-java/issues/3912)) ([e5948d0](https://github.com/googleapis/sdk-platform-java/commit/e5948d0cf27a2ee0ff03da3541524e0463356629))

## [2.62.2](https://github.com/googleapis/sdk-platform-java/compare/v2.62.1...v2.62.2) (2025-09-18)


### Dependencies

* update google api dependencies ([#3885](https://github.com/googleapis/sdk-platform-java/issues/3885)) ([3694fed](https://github.com/googleapis/sdk-platform-java/commit/3694fed91e65966d074471942bd2e36075ba70d1))
* update google auth library dependencies to v1.39.1 ([#3907](https://github.com/googleapis/sdk-platform-java/issues/3907)) ([e86a4f6](https://github.com/googleapis/sdk-platform-java/commit/e86a4f6535bc43b5382f22e790ccf2c76e8e9b23))

## [2.62.1](https://github.com/googleapis/sdk-platform-java/compare/v2.62.0...v2.62.1) (2025-09-05)


### Dependencies

* Update auth to 1.39.0 ([#3898](https://github.com/googleapis/sdk-platform-java/issues/3898)) ([9a8443d](https://github.com/googleapis/sdk-platform-java/commit/9a8443d71cdbdb7a693b6da08db72edb85490807))

## [2.62.0](https://github.com/googleapis/sdk-platform-java/compare/v2.61.0...v2.62.0) (2025-08-19)


### Features

* Set sampledToLocalTracing flag to true for all gRPC MethodDescriptors ([#3874](https://github.com/googleapis/sdk-platform-java/issues/3874)) ([592e899](https://github.com/googleapis/sdk-platform-java/commit/592e899c516288b0a60b69525ba12d6f29bc6200))

## [2.61.0](https://github.com/googleapis/sdk-platform-java/compare/v2.60.2...v2.61.0) (2025-08-04)


### Features

* **mtls:** Add support for X.509-based mTLS-transport in Java GAX lib ([#3852](https://github.com/googleapis/sdk-platform-java/issues/3852)) ([2d02344](https://github.com/googleapis/sdk-platform-java/commit/2d02344d79f5cfdca7834aa0d6306f1b72a7505a))


### Bug Fixes

* improve error messaging for LRO CancellationException ([#3873](https://github.com/googleapis/sdk-platform-java/issues/3873)) ([9cae675](https://github.com/googleapis/sdk-platform-java/commit/9cae675f0ff44227cea60e6802769e82cce948f2))
* make generation config update logs verbose ([#3764](https://github.com/googleapis/sdk-platform-java/issues/3764)) ([9b1a34b](https://github.com/googleapis/sdk-platform-java/commit/9b1a34b0dd08c0eddcf09ef5d81b225d0942f529))

## [2.60.2](https://github.com/googleapis/sdk-platform-java/compare/v2.60.1...v2.60.2) (2025-07-22)


### Dependencies

* update arrow.version to 17.0.0, auth deps to 1.37.1 and http-client deps to 1.47.1 ([#3863](https://github.com/googleapis/sdk-platform-java/issues/3863)) ([b5bb3ca](https://github.com/googleapis/sdk-platform-java/commit/b5bb3ca6fc08d04e001a3ca83d4aac1627a5c504))

## [2.60.1](https://github.com/googleapis/sdk-platform-java/compare/v2.60.0...v2.60.1) (2025-07-08)


### Bug Fixes

* **hermetic-build:** use public maven metadata for latest version inference ([#3853](https://github.com/googleapis/sdk-platform-java/issues/3853)) ([0be1e96](https://github.com/googleapis/sdk-platform-java/commit/0be1e9670079bcf6a9246d0284e59001c24242ea))

## [2.60.0](https://github.com/googleapis/sdk-platform-java/compare/v2.59.2...v2.60.0) (2025-06-23)


### Features

* handle auto pagination for BigQuery v2 ([#3829](https://github.com/googleapis/sdk-platform-java/issues/3829)) ([025c84c](https://github.com/googleapis/sdk-platform-java/commit/025c84c6c9b8c49a9057a7b3ebd0eb1fab3cda13))


### Dependencies

* update google auth library dependencies to v1.37.1 ([#3846](https://github.com/googleapis/sdk-platform-java/issues/3846)) ([ea1d9e5](https://github.com/googleapis/sdk-platform-java/commit/ea1d9e5d3a0346d71a553216cf2486b3be6dc618))
* update google http client dependencies to v1.47.1 ([#3848](https://github.com/googleapis/sdk-platform-java/issues/3848)) ([a9a39d7](https://github.com/googleapis/sdk-platform-java/commit/a9a39d7f814d1f45188c7b17de685b796c0b5aa7))

## [2.59.2](https://github.com/googleapis/sdk-platform-java/compare/v2.59.1...v2.59.2) (2025-06-17)


### Bug Fixes

* update googleapis commit at Thu Jun 12 02:34:24 UTC 2025 ([f3a5d87](https://github.com/googleapis/sdk-platform-java/commit/f3a5d87ed2b5ab1acddd1bf362d11d6ccf3d22b4))
* update googleapis commit at Thu Jun 12 02:34:24 UTC 2025 ([#3833](https://github.com/googleapis/sdk-platform-java/issues/3833)) ([f3a5d87](https://github.com/googleapis/sdk-platform-java/commit/f3a5d87ed2b5ab1acddd1bf362d11d6ccf3d22b4))

## [2.59.1](https://github.com/googleapis/sdk-platform-java/compare/v2.59.0...v2.59.1) (2025-06-12)


### Bug Fixes

* S2A- Check if a default endpoint has been set ([#3784](https://github.com/googleapis/sdk-platform-java/issues/3784)) ([5b2ab82](https://github.com/googleapis/sdk-platform-java/commit/5b2ab829888631caa382621570910187de45ce1c))


### Dependencies

* update google auth library dependencies to v1.37.0 ([#3830](https://github.com/googleapis/sdk-platform-java/issues/3830)) ([8bf9d3c](https://github.com/googleapis/sdk-platform-java/commit/8bf9d3cbe0be80d0bd15dfb896514103293002e0))

## [2.59.0](https://github.com/googleapis/sdk-platform-java/compare/v2.58.0...v2.59.0) (2025-06-02)


### Features

* add logic to set universe domain to ServiceAccountJwtAccessCredentials ([#3806](https://github.com/googleapis/sdk-platform-java/issues/3806)) ([5b45708](https://github.com/googleapis/sdk-platform-java/commit/5b45708d5ff92aae8e4138a737d294c71e1f235a))
* use debian base image for `java-library-generation` ([#3817](https://github.com/googleapis/sdk-platform-java/issues/3817)) ([94d0b30](https://github.com/googleapis/sdk-platform-java/commit/94d0b30d94d79c74125811bf7353afe917e2fe6c))


### Bug Fixes

* manage graalvm image versions via Hermetic Build templates _only_ ([#3800](https://github.com/googleapis/sdk-platform-java/issues/3800)) ([244c5dc](https://github.com/googleapis/sdk-platform-java/commit/244c5dce9f77d0b431d2ec3ea5b101b07dcc3d70))


### Dependencies

* update dependency com.google.oauth-client:google-oauth-client-bom to v1.39.0 ([#3813](https://github.com/googleapis/sdk-platform-java/issues/3813)) ([196a7ca](https://github.com/googleapis/sdk-platform-java/commit/196a7cab502b5570f458f4cf4b324b99265e368c))
* update google api dependencies ([#3791](https://github.com/googleapis/sdk-platform-java/issues/3791)) ([45ef2e0](https://github.com/googleapis/sdk-platform-java/commit/45ef2e0d595ab71555b0eee780962b08d2f073b6))
* update google auth library dependencies to v1.36.0 ([#3814](https://github.com/googleapis/sdk-platform-java/issues/3814)) ([07f834a](https://github.com/googleapis/sdk-platform-java/commit/07f834a61201639ae771c179a229f7b5f794774d))
* update grpc dependencies to 1.71.0 ([#3807](https://github.com/googleapis/sdk-platform-java/issues/3807)) ([49a7ae5](https://github.com/googleapis/sdk-platform-java/commit/49a7ae50071e75fe0d161a4eb9360a4fe4e6147b))
* Upgrade Protobuf-Java to v3.25.8 ([#3810](https://github.com/googleapis/sdk-platform-java/issues/3810)) ([ab90662](https://github.com/googleapis/sdk-platform-java/commit/ab90662288a2181e16ecfb19c9ebb38fb9e29422))

## [2.58.0](https://github.com/googleapis/sdk-platform-java/compare/v2.57.0...v2.58.0) (2025-05-13)


### Features

* add cloudbuild config to publish image via AR Exit Gate ([#3786](https://github.com/googleapis/sdk-platform-java/issues/3786)) ([5cc8857](https://github.com/googleapis/sdk-platform-java/commit/5cc88577f8c78fcac49bcbcbbc2715eef7bf031d))


### Dependencies

* update google auth library dependencies to v1.35.0 ([#3789](https://github.com/googleapis/sdk-platform-java/issues/3789)) ([93f4c95](https://github.com/googleapis/sdk-platform-java/commit/93f4c951ffb9f9a9b577f6971f47dfacdae7ac4f))
* update google http client dependencies to v1.47.0 ([#3790](https://github.com/googleapis/sdk-platform-java/issues/3790)) ([4478e34](https://github.com/googleapis/sdk-platform-java/commit/4478e345bd935b3c31800648f7786399f46bb4c9))

## [2.57.0](https://github.com/googleapis/sdk-platform-java/compare/v2.56.3...v2.57.0) (2025-05-05)


### Features

* Generate IAM v3beta Client Library ([#3780](https://github.com/googleapis/sdk-platform-java/issues/3780)) ([6fc9656](https://github.com/googleapis/sdk-platform-java/commit/6fc965638ce5df58db0b04726ee0aa3afe99c485))


### Bug Fixes

* Update IAM v3 groupId to the correct value ([#3777](https://github.com/googleapis/sdk-platform-java/issues/3777)) ([6ecbf5f](https://github.com/googleapis/sdk-platform-java/commit/6ecbf5f1c7731536089bdc255200beb85b1c3586))

## [2.56.3](https://github.com/googleapis/sdk-platform-java/compare/v2.56.2...v2.56.3) (2025-05-02)


### Bug Fixes

* Only send mtlsEndpoint if it is non-null ([#3767](https://github.com/googleapis/sdk-platform-java/issues/3767)) ([8f8df7b](https://github.com/googleapis/sdk-platform-java/commit/8f8df7b8eb00adfb49db09e95383a88bdb9eff9e))
* subscribe Airlock Docker image definition to GRPC updates ([#3765](https://github.com/googleapis/sdk-platform-java/issues/3765)) ([d0f43e3](https://github.com/googleapis/sdk-platform-java/commit/d0f43e33951a7c9da0fe2adb122f7c73038e9421))


### Dependencies

* update dependency com.google.errorprone:error_prone_annotations to v2.38.0 ([#3773](https://github.com/googleapis/sdk-platform-java/issues/3773)) ([e16fe65](https://github.com/googleapis/sdk-platform-java/commit/e16fe65fed7dc704fce37dfe6957246407dc6178))
* update gapic-showcase to 36.2 ([#3771](https://github.com/googleapis/sdk-platform-java/issues/3771)) ([15b2577](https://github.com/googleapis/sdk-platform-java/commit/15b2577f67a130d6dbef2ae93da53ab2b49211c7))
* update google auth library dependencies to v1.34.0 ([#3772](https://github.com/googleapis/sdk-platform-java/issues/3772)) ([406a180](https://github.com/googleapis/sdk-platform-java/commit/406a180969f865d13bf0e880db10c1a65f0ba536))
* Update maven-shared-utils to v3.2.1 ([#3768](https://github.com/googleapis/sdk-platform-java/issues/3768)) ([7ec93c3](https://github.com/googleapis/sdk-platform-java/commit/7ec93c3015284ecc0e18e820088ebea5aa6975ff))

## [2.56.2](https://github.com/googleapis/sdk-platform-java/compare/v2.56.1...v2.56.2) (2025-04-23)


### Bug Fixes

* inline version update in kokoro templates ([#3762](https://github.com/googleapis/sdk-platform-java/issues/3762)) ([050aeab](https://github.com/googleapis/sdk-platform-java/commit/050aeab4e84b6333aa1d4658ba62dcc68818c374))
* keep native image templates up to date ([#3759](https://github.com/googleapis/sdk-platform-java/issues/3759)) ([7dffab1](https://github.com/googleapis/sdk-platform-java/commit/7dffab1251268736c9bf05b7d4bfcca06ed6576a))

## [2.56.1](https://github.com/googleapis/sdk-platform-java/compare/v2.56.0...v2.56.1) (2025-04-23)


### Bug Fixes

* match graalvm job names with internal configs ([#3755](https://github.com/googleapis/sdk-platform-java/issues/3755)) ([23b4b12](https://github.com/googleapis/sdk-platform-java/commit/23b4b1277e3675cad1ebaa32c1115e8050501a0d))
* use java 17 in samples.yaml ([#3754](https://github.com/googleapis/sdk-platform-java/issues/3754)) ([2d5c5e2](https://github.com/googleapis/sdk-platform-java/commit/2d5c5e28f56cc4332efd511bf9018c966a7c0458))
* use spotify formatter in hermetic build templates ([#3752](https://github.com/googleapis/sdk-platform-java/issues/3752)) ([65e29da](https://github.com/googleapis/sdk-platform-java/commit/65e29dacaf533be61f2a14cbb8adeea316750911))

## [2.56.0](https://github.com/googleapis/sdk-platform-java/compare/v2.55.1...v2.56.0) (2025-04-18)


### Features

* Selective gapic generation phase II ([#3730](https://github.com/googleapis/sdk-platform-java/issues/3730)) ([64ac2c1](https://github.com/googleapis/sdk-platform-java/commit/64ac2c1df1c3ddd46caaa82dd3553365691b66c6))


### Bug Fixes

* **hermetic-build:** use correct image name in templated graalvm jobs ([#3743](https://github.com/googleapis/sdk-platform-java/issues/3743)) ([29a78d3](https://github.com/googleapis/sdk-platform-java/commit/29a78d3b7b6ac8533790f6a3763cc7f8144826ee))
* plumb mtls endpoint to TransportChannelProvider ([#3673](https://github.com/googleapis/sdk-platform-java/issues/3673)) ([a961459](https://github.com/googleapis/sdk-platform-java/commit/a9614593701d945a58b9e333b99589871f82ef33))


### Dependencies

* add opentelemetry gcp-resources to shared deps ([#3722](https://github.com/googleapis/sdk-platform-java/issues/3722)) ([b1b075d](https://github.com/googleapis/sdk-platform-java/commit/b1b075d0530c7b10dc92cdd9cad0801147b95fc7))

## [2.55.1](https://github.com/googleapis/sdk-platform-java/compare/v2.55.0...v2.55.1) (2025-03-12)


### Dependencies

* revert "deps: update arrow.version to v18.2.0" ([#3694](https://github.com/googleapis/sdk-platform-java/issues/3694)) ([2725744](https://github.com/googleapis/sdk-platform-java/commit/272574489bc40b8b6379e5edb6ea5161b57bd687))

## [2.55.0](https://github.com/googleapis/sdk-platform-java/compare/v2.54.0...v2.55.0) (2025-03-12)


### Features

* generate showcase using docker image ([#3568](https://github.com/googleapis/sdk-platform-java/issues/3568)) ([3857e3f](https://github.com/googleapis/sdk-platform-java/commit/3857e3f6dc633a9adaf29e9770a584419e2f2214))
* next release from main branch is 2.55.0 ([#3668](https://github.com/googleapis/sdk-platform-java/issues/3668)) ([1eda55f](https://github.com/googleapis/sdk-platform-java/commit/1eda55fc5e4cecedba3f8c163db0ce259d180a66))


### Bug Fixes

* remove call credentials from call options if DirectPath ([#3670](https://github.com/googleapis/sdk-platform-java/issues/3670)) ([5ede29c](https://github.com/googleapis/sdk-platform-java/commit/5ede29cc9a3f4c585378b03a1b6c6a1e3eed8231))


### Dependencies

* update arrow.version to v18.2.0 ([#3675](https://github.com/googleapis/sdk-platform-java/issues/3675)) ([5a555e5](https://github.com/googleapis/sdk-platform-java/commit/5a555e5b553b65b0e61517271eafbc3bd7eeb735))

## [2.54.0](https://github.com/googleapis/sdk-platform-java/compare/v2.53.0...v2.54.0) (2025-02-25)


### Features

* add client side logging with slf4j ([#3403](https://github.com/googleapis/sdk-platform-java/issues/3403)) ([fe002fa](https://github.com/googleapis/sdk-platform-java/commit/fe002fab1ab65b29eeb5510d1ba1ef72fa3441b0))


### Bug Fixes

* S2A gRPC flow creates ComputeEngineCredentials via newBuilder. ([#3651](https://github.com/googleapis/sdk-platform-java/issues/3651)) ([29c061e](https://github.com/googleapis/sdk-platform-java/commit/29c061e8a18b9a416262986f11c5148ea6fec9b2))


### Dependencies

* update dependency ch.qos.logback:logback-core to v1.3.15 [security] ([#3654](https://github.com/googleapis/sdk-platform-java/issues/3654)) ([093d867](https://github.com/googleapis/sdk-platform-java/commit/093d867eb5dcdcc08ece434598f96a6dff760326))
* update google api dependencies ([#3631](https://github.com/googleapis/sdk-platform-java/issues/3631)) ([48db2a1](https://github.com/googleapis/sdk-platform-java/commit/48db2a10e3ef46ad9ddf23378613a550172f63af))
* update google auth library dependencies to v1.33.1 ([#3656](https://github.com/googleapis/sdk-platform-java/issues/3656)) ([f7877a5](https://github.com/googleapis/sdk-platform-java/commit/f7877a5b278d3487cb50a1e942f6ff6268121069))
* update google http client dependencies to v1.46.3 ([#3657](https://github.com/googleapis/sdk-platform-java/issues/3657)) ([9d5b3b5](https://github.com/googleapis/sdk-platform-java/commit/9d5b3b5ae6a18fbc8445025fa9ec1abe00b7f7cc))
* update grpc to 1.70.0 ([#3641](https://github.com/googleapis/sdk-platform-java/issues/3641)) ([ad26cf9](https://github.com/googleapis/sdk-platform-java/commit/ad26cf98548e325c99edb263baf8fe1a7696e634))
* update grpc to 1.70.0 (missed update) ([#3658](https://github.com/googleapis/sdk-platform-java/issues/3658)) ([6ca0599](https://github.com/googleapis/sdk-platform-java/commit/6ca05994f6be40344b21befb8cdabb0766a835d0))
* Update opentelemetry-semconv to v1.29.0-alpha ([#3635](https://github.com/googleapis/sdk-platform-java/issues/3635)) ([49ac09d](https://github.com/googleapis/sdk-platform-java/commit/49ac09d263daad8ceb2e14a623db242339880670))


### Documentation

* update showcase readme ([#3659](https://github.com/googleapis/sdk-platform-java/issues/3659)) ([0ddf073](https://github.com/googleapis/sdk-platform-java/commit/0ddf0738a8ef74f5676a3bf76c306837d14988e0))

## [2.53.0](https://github.com/googleapis/sdk-platform-java/compare/v2.52.0...v2.53.0) (2025-02-10)


### Features

* enable DirectPath bound token in InstantiatingGrpcChannelProvider ([#3572](https://github.com/googleapis/sdk-platform-java/issues/3572)) ([5080495](https://github.com/googleapis/sdk-platform-java/commit/5080495d5aa65e69f67a86ee54e1ee103b42d1ef))
* Enable MTLS_S2A bound token by default for gRPC S2A enabled flows ([#3591](https://github.com/googleapis/sdk-platform-java/issues/3591)) ([81e21f2](https://github.com/googleapis/sdk-platform-java/commit/81e21f2ef98c9b0776d9bcffb13db667a8a885e6))
* migrate away from deprecated graal-sdk dependency to use nativeimage ([#2706](https://github.com/googleapis/sdk-platform-java/issues/2706)) ([757801a](https://github.com/googleapis/sdk-platform-java/commit/757801aba582fd6224fc8504a3236568eef8a417))


### Bug Fixes

* Avoid creating message string prematurely for streaming calls ([#3622](https://github.com/googleapis/sdk-platform-java/issues/3622)) ([f805e70](https://github.com/googleapis/sdk-platform-java/commit/f805e7009add0d9512c70956569ea00f11fa42f9))


### Dependencies

* update dependency com.google.code.gson:gson to v2.12.0 ([#3595](https://github.com/googleapis/sdk-platform-java/issues/3595)) ([1f1b119](https://github.com/googleapis/sdk-platform-java/commit/1f1b119cc5ff13e6821285347da089e1297372b3))
* update dependency com.google.code.gson:gson to v2.12.0 ([#3596](https://github.com/googleapis/sdk-platform-java/issues/3596)) ([af62f53](https://github.com/googleapis/sdk-platform-java/commit/af62f5317cac2fd163aee305f9347ae3f2fb729f))
* update dependency com.google.code.gson:gson to v2.12.1 ([#3599](https://github.com/googleapis/sdk-platform-java/issues/3599)) ([18917ee](https://github.com/googleapis/sdk-platform-java/commit/18917ee918763d40603fc307ec0a446561d10601))
* update dependency com.google.code.gson:gson to v2.12.1 ([#3600](https://github.com/googleapis/sdk-platform-java/issues/3600)) ([3f82836](https://github.com/googleapis/sdk-platform-java/commit/3f828360d32ae9d4a2015b623b5747c407520417))
* update dependency commons-codec:commons-codec to v1.18.0 ([#3590](https://github.com/googleapis/sdk-platform-java/issues/3590)) ([cd46ba5](https://github.com/googleapis/sdk-platform-java/commit/cd46ba5e2105c5c009e4700a9c8da65f94e7b79a))
* update dependency io.netty:netty-tcnative-boringssl-static to v2.0.70.final ([#3623](https://github.com/googleapis/sdk-platform-java/issues/3623)) ([a4d1f95](https://github.com/googleapis/sdk-platform-java/commit/a4d1f95e6803966313478f382918c39038a4728b))
* update dependency lxml to v5.3.1 ([#3624](https://github.com/googleapis/sdk-platform-java/issues/3624)) ([5407646](https://github.com/googleapis/sdk-platform-java/commit/5407646c3010f65ea55941694e3f05d1fef02a53))
* update dependency net.bytebuddy:byte-buddy to v1.17.0 ([#3582](https://github.com/googleapis/sdk-platform-java/issues/3582)) ([54d99e9](https://github.com/googleapis/sdk-platform-java/commit/54d99e9f2826d372eb305b65be08033baf0f2f16))
* update dependency org.checkerframework:checker-qual to v3.49.0 ([#3604](https://github.com/googleapis/sdk-platform-java/issues/3604)) ([390cffa](https://github.com/googleapis/sdk-platform-java/commit/390cffa28f39273bc99c9083deb998da8c9d4e83))
* update dependency org.graalvm.sdk:nativeimage to v24.1.2 ([#3597](https://github.com/googleapis/sdk-platform-java/issues/3597)) ([9d151c4](https://github.com/googleapis/sdk-platform-java/commit/9d151c422557749c5a61fad0ffaa0216b807cbdc))
* update docker.io/library/maven:3.9.9-eclipse-temurin-11-alpine docker digest to 456f60c ([#3607](https://github.com/googleapis/sdk-platform-java/issues/3607)) ([c2d2768](https://github.com/googleapis/sdk-platform-java/commit/c2d276857f6ca0e86c91e15af5e08a737bd1510b))
* update docker.io/library/maven:3.9.9-eclipse-temurin-11-alpine docker digest to d323c2b ([#3601](https://github.com/googleapis/sdk-platform-java/issues/3601)) ([ed35c23](https://github.com/googleapis/sdk-platform-java/commit/ed35c23d99bd9ebbd8840bb34a8a023de10e38cc))
* update docker.io/library/python docker tag to v3.13.2 ([#3615](https://github.com/googleapis/sdk-platform-java/issues/3615)) ([ba007c2](https://github.com/googleapis/sdk-platform-java/commit/ba007c2f9ce63a9837e87f98241cabd7bf94f082))
* update docker.io/library/python:3.13.1-alpine3.20 docker digest to 7788ec8 ([#3586](https://github.com/googleapis/sdk-platform-java/issues/3586)) ([a24d1ba](https://github.com/googleapis/sdk-platform-java/commit/a24d1bad2a9480b1f4ebdc938f589bfe0306257a))
* update google api dependencies ([#3584](https://github.com/googleapis/sdk-platform-java/issues/3584)) ([08f2b7b](https://github.com/googleapis/sdk-platform-java/commit/08f2b7b472ad399f61b669a9d1f283211b142cc9))
* update google auth library dependencies to v1.32.0 ([#3611](https://github.com/googleapis/sdk-platform-java/issues/3611)) ([9436eb0](https://github.com/googleapis/sdk-platform-java/commit/9436eb0c479af55a55ac465410b036887bc13d71))
* update google auth library dependencies to v1.32.1 ([#3618](https://github.com/googleapis/sdk-platform-java/issues/3618)) ([88c78e2](https://github.com/googleapis/sdk-platform-java/commit/88c78e205888ed792ed0a4a78979534d6bfddf9b))
* update google http client dependencies to v1.46.1 ([#3616](https://github.com/googleapis/sdk-platform-java/issues/3616)) ([2462105](https://github.com/googleapis/sdk-platform-java/commit/24621051c28eddada2499c6bf9830bbc77c45706))
* update googleapis/java-cloud-bom digest to 47ad868 ([#3608](https://github.com/googleapis/sdk-platform-java/issues/3608)) ([2bcf9e0](https://github.com/googleapis/sdk-platform-java/commit/2bcf9e0acba526a38b0beae1cfe9f3520cd64552))
* update googleapis/java-cloud-bom digest to 514a644 ([#3602](https://github.com/googleapis/sdk-platform-java/issues/3602)) ([172d4da](https://github.com/googleapis/sdk-platform-java/commit/172d4da07b7f06494327d9f7406c605ce8e577db))
* update googleapis/java-cloud-bom digest to 7752ecd ([#3603](https://github.com/googleapis/sdk-platform-java/issues/3603)) ([06be924](https://github.com/googleapis/sdk-platform-java/commit/06be9247e756aa47a90a249232288fd14fafa4b8))
* update netty dependencies to v4.1.117.final ([#3581](https://github.com/googleapis/sdk-platform-java/issues/3581)) ([2734dc0](https://github.com/googleapis/sdk-platform-java/commit/2734dc01c83cac661f48bf2587184fbadf88281e))
* update netty dependencies to v4.1.118.final ([#3625](https://github.com/googleapis/sdk-platform-java/issues/3625)) ([16ff6bd](https://github.com/googleapis/sdk-platform-java/commit/16ff6bd68a43646ced530d0abbbc02962917bdfa))
* update netty dependencies to v4.1.118.final ([#3626](https://github.com/googleapis/sdk-platform-java/issues/3626)) ([316c425](https://github.com/googleapis/sdk-platform-java/commit/316c42546a4aab60aa1ac0fc4eeae22be8d9889f))
* Update OpenTelemetry semantic convention packages in the shared dependencies ([#3402](https://github.com/googleapis/sdk-platform-java/issues/3402)) ([0e69784](https://github.com/googleapis/sdk-platform-java/commit/0e69784af6825cd55ac6ce1ee74e42af6c9f94f5))
* update opentelemetry-java monorepo to v1.46.0 ([#3585](https://github.com/googleapis/sdk-platform-java/issues/3585)) ([ac214be](https://github.com/googleapis/sdk-platform-java/commit/ac214bed8fb657142da821d897fbbf2ca7d1fc12))
* update opentelemetry-java monorepo to v1.47.0 ([#3619](https://github.com/googleapis/sdk-platform-java/issues/3619)) ([66901df](https://github.com/googleapis/sdk-platform-java/commit/66901df3b0bd7cfb8a25d72aa52cd8505f1bfafa))
* update repo-automation-bots digest to 35eff2c ([#3609](https://github.com/googleapis/sdk-platform-java/issues/3609)) ([b962a01](https://github.com/googleapis/sdk-platform-java/commit/b962a01918e56bfc5ca928aa9a5e29a311e71a38))
* update repo-automation-bots digest to 3a68a9c ([#3620](https://github.com/googleapis/sdk-platform-java/issues/3620)) ([1d79552](https://github.com/googleapis/sdk-platform-java/commit/1d795525a6a30ae30bcac40dec903cd7cc743711))

## [2.52.0](https://github.com/googleapis/sdk-platform-java/compare/v2.51.1...v2.52.0) (2025-01-24)


### Features

* add support for new setAllowHardBoundTokens field. ([#3467](https://github.com/googleapis/sdk-platform-java/issues/3467)) ([38431a2](https://github.com/googleapis/sdk-platform-java/commit/38431a290ed55174599be0927be32daaa1c49d56))
* revert [#3400](https://github.com/googleapis/sdk-platform-java/issues/3400): reintroduce experimental S2A integration in client libraries grpc transport ([#3548](https://github.com/googleapis/sdk-platform-java/issues/3548)) ([65a0f11](https://github.com/googleapis/sdk-platform-java/commit/65a0f11d2c8bebade9518ff338103e92a332252c))


### Dependencies

* update dependency com.google.api-client:google-api-client-bom to v2.7.2 ([#3578](https://github.com/googleapis/sdk-platform-java/issues/3578)) ([f6e5ad9](https://github.com/googleapis/sdk-platform-java/commit/f6e5ad90aced32f8a738b2e52b30fcfa02c7af4b))
* update dependency commons-codec:commons-codec to v1.17.2 ([#3557](https://github.com/googleapis/sdk-platform-java/issues/3557)) ([07ce801](https://github.com/googleapis/sdk-platform-java/commit/07ce801599479020629ce726afb9c06b2f711093))
* update dependency gitpython to v3.1.44 ([#3559](https://github.com/googleapis/sdk-platform-java/issues/3559)) ([e924db0](https://github.com/googleapis/sdk-platform-java/commit/e924db06590648ad40b5b3aa0f6269084270064b))
* update dependency org.checkerframework:checker-qual to v3.48.4 ([#3560](https://github.com/googleapis/sdk-platform-java/issues/3560)) ([a4726e9](https://github.com/googleapis/sdk-platform-java/commit/a4726e9d96e9f54d839b6822a6372b1905839b6d))
* update dependency smmap to v5.0.2 ([#3561](https://github.com/googleapis/sdk-platform-java/issues/3561)) ([6cd5d0d](https://github.com/googleapis/sdk-platform-java/commit/6cd5d0dfa4c5cd981b2d27771ca4b681ef415c63))
* update docker.io/library/alpine docker tag to v3.21.1 ([#3551](https://github.com/googleapis/sdk-platform-java/issues/3551)) ([edd5a4c](https://github.com/googleapis/sdk-platform-java/commit/edd5a4c04db6b16cb005301d4dbcd3f8c28b7537))
* update docker.io/library/alpine docker tag to v3.21.2 ([#3580](https://github.com/googleapis/sdk-platform-java/issues/3580)) ([f577ecd](https://github.com/googleapis/sdk-platform-java/commit/f577ecd044fc30dbeb2209292ecc6dcfdedaa758))
* update docker.io/library/maven:3.9.9-eclipse-temurin-11-alpine docker digest to 9a259c6 ([#3554](https://github.com/googleapis/sdk-platform-java/issues/3554)) ([eb2cbd6](https://github.com/googleapis/sdk-platform-java/commit/eb2cbd6515ded9278ffd0dae92af80b321e95c25))
* update docker.io/library/python:3.13.1-alpine3.20 docker digest to 9ab3b6e ([#3555](https://github.com/googleapis/sdk-platform-java/issues/3555)) ([40a74fe](https://github.com/googleapis/sdk-platform-java/commit/40a74fe322b9cc4fc50919e17472c617dd331e86))
* update google auth library dependencies to v1.31.0 ([#3577](https://github.com/googleapis/sdk-platform-java/issues/3577)) ([7fa879a](https://github.com/googleapis/sdk-platform-java/commit/7fa879a0e795094d481c090123d612f0e3a3968e))
* update googleapis/java-cloud-bom digest to c7c443f ([#3579](https://github.com/googleapis/sdk-platform-java/issues/3579)) ([fcf40b7](https://github.com/googleapis/sdk-platform-java/commit/fcf40b72d43346e43d78d1e87060be6e621e9d52))
* update repo-automation-bots digest to 0a12b5d ([#3464](https://github.com/googleapis/sdk-platform-java/issues/3464)) ([b9c9d21](https://github.com/googleapis/sdk-platform-java/commit/b9c9d212ea57598de5ddf2e4ead2ee323c5a8135))

## [2.51.1](https://github.com/googleapis/sdk-platform-java/compare/v2.51.0...v2.51.1) (2025-01-08)


### Dependencies

* update dependency com.google.guava:guava to v33.4.0-jre ([#3473](https://github.com/googleapis/sdk-platform-java/issues/3473)) ([453b897](https://github.com/googleapis/sdk-platform-java/commit/453b897aabf9a7abdb59e9ea18ac8f8196b9792a))
* update dependency com.google.guava:guava-bom to v33.4.0-jre ([#3545](https://github.com/googleapis/sdk-platform-java/issues/3545)) ([07eb10e](https://github.com/googleapis/sdk-platform-java/commit/07eb10e848d73a2e8d1d39018e2ec31b881653c8))
* update dependency com.google.oauth-client:google-oauth-client-bom to v1.37.0 ([#3471](https://github.com/googleapis/sdk-platform-java/issues/3471)) ([1f1c369](https://github.com/googleapis/sdk-platform-java/commit/1f1c369633f0ae9b5b512a2908befdcd1c9cb952))
* update dependency net.bytebuddy:byte-buddy to v1.15.11 ([#3468](https://github.com/googleapis/sdk-platform-java/issues/3468)) ([fde27db](https://github.com/googleapis/sdk-platform-java/commit/fde27db7f7959953cf480abfa62dc7dc58ac445e))
* update google api dependencies ([#3461](https://github.com/googleapis/sdk-platform-java/issues/3461)) ([12d9ff2](https://github.com/googleapis/sdk-platform-java/commit/12d9ff26e6ab905e6230703a671e188690ec1322))
* update googleapis/java-cloud-bom digest to 03f6dcd ([#3465](https://github.com/googleapis/sdk-platform-java/issues/3465)) ([67f5ea2](https://github.com/googleapis/sdk-platform-java/commit/67f5ea23f50eaf57925cdf34d51c7b0bfcc67cf3))
* update junit5 monorepo to v5.11.4 ([#3470](https://github.com/googleapis/sdk-platform-java/issues/3470)) ([164ebac](https://github.com/googleapis/sdk-platform-java/commit/164ebac30632ca8fd688781b4aaecc5eab932f77))
* update netty dependencies to v4.1.116.final ([#3543](https://github.com/googleapis/sdk-platform-java/issues/3543)) ([d4fa54d](https://github.com/googleapis/sdk-platform-java/commit/d4fa54d8b25afeacc4c9675f4763a3bff311f595))
* update repo-automation-bots digest to 8b7d94b ([#3458](https://github.com/googleapis/sdk-platform-java/issues/3458)) ([59f9e0a](https://github.com/googleapis/sdk-platform-java/commit/59f9e0a3a101d5425b0c751b39e6b784466e16b8))


### Documentation

* update development guide ([#3480](https://github.com/googleapis/sdk-platform-java/issues/3480)) ([9a65386](https://github.com/googleapis/sdk-platform-java/commit/9a65386dfc3146de4f9b36962caae2df0662ac98))

## [2.51.0](https://github.com/googleapis/sdk-platform-java/compare/v2.50.0...v2.51.0) (2024-12-12)


### Features

* [iam] add ResourcePolicyMember to google/iam/v1 ([b8e2859](https://github.com/googleapis/sdk-platform-java/commit/b8e28597774d778fc6b79354edbfacbbd76015af))


### Bug Fixes

* [#3381](https://github.com/googleapis/sdk-platform-java/issues/3381) ([75dcb96](https://github.com/googleapis/sdk-platform-java/commit/75dcb96b799990bec9998b420463aa782fb65661))
* graalvm missing build time class when using protobuf 4.x ([#3438](https://github.com/googleapis/sdk-platform-java/issues/3438)) ([f0236cf](https://github.com/googleapis/sdk-platform-java/commit/f0236cfc102cf7ce06e1f733a4f40a50133d6b24))
* return all library names if repo-level parameter changes ([#3379](https://github.com/googleapis/sdk-platform-java/issues/3379)) ([75dcb96](https://github.com/googleapis/sdk-platform-java/commit/75dcb96b799990bec9998b420463aa782fb65661)), closes [#3381](https://github.com/googleapis/sdk-platform-java/issues/3381)


### Dependencies

* update dependency com.fasterxml.jackson:jackson-bom to v2.18.2 ([#3422](https://github.com/googleapis/sdk-platform-java/issues/3422)) ([fdc3a54](https://github.com/googleapis/sdk-platform-java/commit/fdc3a5427836fcc5e9052fed736c178d7e7bdf18))
* update dependency com.google.api-client:google-api-client-bom to v2.7.1 ([#3450](https://github.com/googleapis/sdk-platform-java/issues/3450)) ([35f1310](https://github.com/googleapis/sdk-platform-java/commit/35f1310cde638c89cf6680282e82f442821afe65))
* update dependency com.google.auth:google-auth-library-oauth2-http to v1.30.0 ([#3428](https://github.com/googleapis/sdk-platform-java/issues/3428)) ([78cbff1](https://github.com/googleapis/sdk-platform-java/commit/78cbff1af55fb804400df5307b0df464936e0bae))
* update dependency com.google.errorprone:error_prone_annotations to v2.36.0 ([#3425](https://github.com/googleapis/sdk-platform-java/issues/3425)) ([52dcc0d](https://github.com/googleapis/sdk-platform-java/commit/52dcc0d7aa525a18329a56fefe8a3b97efd6b1d3))
* update dependency com.google.errorprone:error_prone_annotations to v2.36.0 ([#3426](https://github.com/googleapis/sdk-platform-java/issues/3426)) ([77dd85d](https://github.com/googleapis/sdk-platform-java/commit/77dd85d5cc7ad39d5dbbb5bab3bb17863fc8b9c9))
* update dependency dev.cel:cel to v0.8.0 ([#3429](https://github.com/googleapis/sdk-platform-java/issues/3429)) ([79cde20](https://github.com/googleapis/sdk-platform-java/commit/79cde2028c2ec307001c6bedd4310a78d04f379e))
* update dependency io.github.java-diff-utils:java-diff-utils to v4.15 ([#3430](https://github.com/googleapis/sdk-platform-java/issues/3430)) ([91fd5cb](https://github.com/googleapis/sdk-platform-java/commit/91fd5cb4aaf6ca02a0f73d664c0dbe283d13e989))
* update dependency net.bytebuddy:byte-buddy to v1.15.10 ([#3298](https://github.com/googleapis/sdk-platform-java/issues/3298)) ([7b503de](https://github.com/googleapis/sdk-platform-java/commit/7b503dead0c8142630a5b05142e1e8a07f7300c3))
* update dependency org.checkerframework:checker-qual to v3.48.3 ([#3278](https://github.com/googleapis/sdk-platform-java/issues/3278)) ([c5fd1b4](https://github.com/googleapis/sdk-platform-java/commit/c5fd1b4e201de5d042c3e0999ab74ad2a1bd6c17))
* update dependency org.easymock:easymock to v5.5.0 ([#3431](https://github.com/googleapis/sdk-platform-java/issues/3431)) ([3c22f5e](https://github.com/googleapis/sdk-platform-java/commit/3c22f5e8dc73d867689df3f63c97580c908dfeb5))
* update dependency packaging to v24.2 ([#3432](https://github.com/googleapis/sdk-platform-java/issues/3432)) ([c1e7c81](https://github.com/googleapis/sdk-platform-java/commit/c1e7c81b68e46a6a7e350cc3d857df48254e337b))
* update docker.io/library/alpine docker tag to v3.21.0 ([#3433](https://github.com/googleapis/sdk-platform-java/issues/3433)) ([c8318c2](https://github.com/googleapis/sdk-platform-java/commit/c8318c243857242f155d9a78b3a4ff24e31a1b7e))
* update docker.io/library/alpine:3.20.3 docker digest to 1e42bbe ([#3417](https://github.com/googleapis/sdk-platform-java/issues/3417)) ([0f4ef19](https://github.com/googleapis/sdk-platform-java/commit/0f4ef19b9fa30155fa7630b7b5b95495da646043))
* update docker.io/library/maven:3.9.9-eclipse-temurin-11-alpine docker digest to 3bab9f2 ([#3447](https://github.com/googleapis/sdk-platform-java/issues/3447)) ([ccf7eac](https://github.com/googleapis/sdk-platform-java/commit/ccf7eacf19c70e1063fc4e15d6340bc0d6c6dac0))
* update docker.io/library/maven:3.9.9-eclipse-temurin-11-alpine docker digest to cdfb386 ([#3418](https://github.com/googleapis/sdk-platform-java/issues/3418)) ([2559ff8](https://github.com/googleapis/sdk-platform-java/commit/2559ff8998f1cc8f1cb279a02520ad9ee7bac776))
* update docker.io/library/python docker tag to v3.13.1 ([#3434](https://github.com/googleapis/sdk-platform-java/issues/3434)) ([feefd27](https://github.com/googleapis/sdk-platform-java/commit/feefd2788ac7447f2778bb971f5d752d93ef3b0e))
* update google api dependencies ([#3435](https://github.com/googleapis/sdk-platform-java/issues/3435)) ([3a1e8f2](https://github.com/googleapis/sdk-platform-java/commit/3a1e8f214a28b514956a6f4ce3857fe89856c4a0))
* update google auth library dependencies to v1.30.1 ([#3453](https://github.com/googleapis/sdk-platform-java/issues/3453)) ([d7b7dd9](https://github.com/googleapis/sdk-platform-java/commit/d7b7dd98314de957b048c9ddb70ad3089f39fc63))
* update google http client dependencies to v1.45.2 ([#3394](https://github.com/googleapis/sdk-platform-java/issues/3394)) ([f8ee892](https://github.com/googleapis/sdk-platform-java/commit/f8ee89227ac6b095b186db8c81d067aa5af9bc66))
* update google http client dependencies to v1.45.3 ([#3454](https://github.com/googleapis/sdk-platform-java/issues/3454)) ([a112559](https://github.com/googleapis/sdk-platform-java/commit/a112559ef0ac4f70d53dcc7ba1c5eaa73b6cc3c1))
* update google.cloud.opentelemetry.version to v0.33.0 ([#3436](https://github.com/googleapis/sdk-platform-java/issues/3436)) ([e519626](https://github.com/googleapis/sdk-platform-java/commit/e519626e2dc538ff8291f94b699e54b37d50d6a4))
* update googleapis/java-cloud-bom digest to 93740d5 ([#3280](https://github.com/googleapis/sdk-platform-java/issues/3280)) ([f987db5](https://github.com/googleapis/sdk-platform-java/commit/f987db5dc8bc0f5f8bd7805a2596e13055343cc0))
* update grpc dependencies to v1.68.2 ([#3420](https://github.com/googleapis/sdk-platform-java/issues/3420)) ([6d0a169](https://github.com/googleapis/sdk-platform-java/commit/6d0a169065b99c00e88592c1caa608447e0fc4e8))
* update grpc dependencies to v1.69.0 ([#3451](https://github.com/googleapis/sdk-platform-java/issues/3451)) ([0effb37](https://github.com/googleapis/sdk-platform-java/commit/0effb371f88fd7c911861ab7aca7d67c52cc4ad0))
* update junit5 monorepo to v5.11.3 ([#3310](https://github.com/googleapis/sdk-platform-java/issues/3310)) ([4e33f2b](https://github.com/googleapis/sdk-platform-java/commit/4e33f2b8ff9e169e96f59683a21bb08dc086c110))
* update netty dependencies ([#3423](https://github.com/googleapis/sdk-platform-java/issues/3423)) ([22ea7b5](https://github.com/googleapis/sdk-platform-java/commit/22ea7b533241660aba124062b0a5d6a5cbfcef7b))
* update opentelemetry-java monorepo to v1.44.1 ([#3437](https://github.com/googleapis/sdk-platform-java/issues/3437)) ([66b85da](https://github.com/googleapis/sdk-platform-java/commit/66b85da86faef954274d4208f074ca52ad4aebc4))
* update opentelemetry-java monorepo to v1.45.0 ([#3439](https://github.com/googleapis/sdk-platform-java/issues/3439)) ([d29475a](https://github.com/googleapis/sdk-platform-java/commit/d29475a7ad89e96026f3c710e331976902a161b7))
* update repo-automation-bots digest to 6662ddc ([#3421](https://github.com/googleapis/sdk-platform-java/issues/3421)) ([dec5de0](https://github.com/googleapis/sdk-platform-java/commit/dec5de0e628ad9be6bd5fb8d768d50918c2edab7))
* update repo-automation-bots digest to 8230b4e ([#3448](https://github.com/googleapis/sdk-platform-java/issues/3448)) ([e53199b](https://github.com/googleapis/sdk-platform-java/commit/e53199be9632c2f8cc6a94ba25f3aa3567d63ffa))
* update repo-automation-bots digest to ae0a72f ([#3452](https://github.com/googleapis/sdk-platform-java/issues/3452)) ([331bacf](https://github.com/googleapis/sdk-platform-java/commit/331bacf1b222d9282e116c4b829140407d9b9127))
* update repo-automation-bots digest to f3fbbab ([#3419](https://github.com/googleapis/sdk-platform-java/issues/3419)) ([343a029](https://github.com/googleapis/sdk-platform-java/commit/343a029a75e7e325f069e0e2aebb131d79a26901))


### Documentation

* explain default generation config in `README.md` ([#3388](https://github.com/googleapis/sdk-platform-java/issues/3388)) ([2ac86de](https://github.com/googleapis/sdk-platform-java/commit/2ac86de1baf263e92cb442b970a86350d54bbca5))
* hermetic build README syntax fix ([#3391](https://github.com/googleapis/sdk-platform-java/issues/3391)) ([cf32e72](https://github.com/googleapis/sdk-platform-java/commit/cf32e72d83c06d1d36e1eea01afc37bee5766455))

## [2.50.0](https://github.com/googleapis/sdk-platform-java/compare/v2.49.0...v2.50.0) (2024-11-14)


### Features

* Add experimental S2A integration in client libraries grpc transport ([#3326](https://github.com/googleapis/sdk-platform-java/issues/3326)) ([1138ca6](https://github.com/googleapis/sdk-platform-java/commit/1138ca682cd47d6164ceaa47803bfe2f68b1bc14))
* enable selective generation based on service config include list ([#3323](https://github.com/googleapis/sdk-platform-java/issues/3323)) ([0cddadb](https://github.com/googleapis/sdk-platform-java/commit/0cddadb8ad3eddfffa356a479964d8a720937503))
* introduce `java.time` to java-core ([#3330](https://github.com/googleapis/sdk-platform-java/issues/3330)) ([f202c3b](https://github.com/googleapis/sdk-platform-java/commit/f202c3b550936168b9876860853876aa6d51c6a1))
* Update Gapic-Generator to generate libraries using `java.time` methods ([#3321](https://github.com/googleapis/sdk-platform-java/issues/3321)) ([b21c9a4](https://github.com/googleapis/sdk-platform-java/commit/b21c9a42121c22a1ab229d2d485265c271305110))


### Bug Fixes

* Fix flaky test ScheduledRetryingExecutorTest.testCancelOuterFutureAfterStart ([#3335](https://github.com/googleapis/sdk-platform-java/issues/3335)) ([e73740d](https://github.com/googleapis/sdk-platform-java/commit/e73740dbdb21d7c28908554fe3725504dc8ce84b))
* httpjson callables to trace attempts (started, failed) ([#3300](https://github.com/googleapis/sdk-platform-java/issues/3300)) ([15a64ee](https://github.com/googleapis/sdk-platform-java/commit/15a64ee2e63165e50fd07b2b3a40f0d2ef2edfe2))
* instantiate GaxProperties at build time to ensure we get the protobuf version ([#3365](https://github.com/googleapis/sdk-platform-java/issues/3365)) ([bb2a3be](https://github.com/googleapis/sdk-platform-java/commit/bb2a3be87291ae718ac0e8538025a0867a6b6ff6))
* protobuf version not always getting set in headers ([#3322](https://github.com/googleapis/sdk-platform-java/issues/3322)) ([7f6e470](https://github.com/googleapis/sdk-platform-java/commit/7f6e470fea1673a5cf50fe3b49263615a172afde))
* use BuildKit instead of legacy builder to build the Hermetic Build images ([#3338](https://github.com/googleapis/sdk-platform-java/issues/3338)) ([222fb45](https://github.com/googleapis/sdk-platform-java/commit/222fb452e00bd195ad51389ea308993a7e1bc956))


### Dependencies

* update google auth library dependencies to v1.30.0 ([#3367](https://github.com/googleapis/sdk-platform-java/issues/3367)) ([a31c682](https://github.com/googleapis/sdk-platform-java/commit/a31c68232584bf90bc00ace8310adeab8fa26add))
* update grpc dependencies to v1.68.1 ([#3240](https://github.com/googleapis/sdk-platform-java/issues/3240)) ([c8e3941](https://github.com/googleapis/sdk-platform-java/commit/c8e3941ef6f5bd1236f5ceedfd488e5113928471))


### Documentation

* fix list num ([#3356](https://github.com/googleapis/sdk-platform-java/issues/3356)) ([b7d6296](https://github.com/googleapis/sdk-platform-java/commit/b7d62968cd837a7addc06da8b9bc2131c36c7fbc))
* **hermetic-build:** indicate usage of Docker Buildkit in development guide ([#3337](https://github.com/googleapis/sdk-platform-java/issues/3337)) ([01e742d](https://github.com/googleapis/sdk-platform-java/commit/01e742de49e151efbd903808a859f595f99bc8de))
* modify hermetic build docs ([#3331](https://github.com/googleapis/sdk-platform-java/issues/3331)) ([25023af](https://github.com/googleapis/sdk-platform-java/commit/25023afad8f483a3eae8846c4bc1fbe2c7a260c5))

## [2.49.0](https://github.com/googleapis/sdk-platform-java/compare/v2.48.0...v2.49.0) (2024-10-25)


### Features

* Move release note generation to a sub module ([#3299](https://github.com/googleapis/sdk-platform-java/issues/3299)) ([7d6d66a](https://github.com/googleapis/sdk-platform-java/commit/7d6d66a161db5edc538aec065405954acf4434c5))


### Bug Fixes

* add additional potential exceptions when retrieving protobuf manifest file to get version ([#3315](https://github.com/googleapis/sdk-platform-java/issues/3315)) ([ef9e518](https://github.com/googleapis/sdk-platform-java/commit/ef9e5189740ea5be46ad0d51c2ff554cd99ac162))


### Dependencies

* update dependency com.google.errorprone:error_prone_annotations to v2.35.1 ([#3316](https://github.com/googleapis/sdk-platform-java/issues/3316)) ([d7c290f](https://github.com/googleapis/sdk-platform-java/commit/d7c290f3e49c8ec7c480229e2c8ae38fcdcd99f6))

## [2.48.0](https://github.com/googleapis/sdk-platform-java/compare/v2.47.0...v2.48.0) (2024-10-22)


### Features

* **gax:** add protobuf version tracking to headers ([#3199](https://github.com/googleapis/sdk-platform-java/issues/3199)) ([40c19b1](https://github.com/googleapis/sdk-platform-java/commit/40c19b1aad71da176aeafbba32a0a4b51b5a4366))
* selectively generate libraries ([#3290](https://github.com/googleapis/sdk-platform-java/issues/3290)) ([dfe1a50](https://github.com/googleapis/sdk-platform-java/commit/dfe1a50ec857cc2998bcbfbc2d8af6801f0ae260))


### Bug Fixes

* generator setting incorrect name/class for sample due to region tag (2nd attempt) ([#3293](https://github.com/googleapis/sdk-platform-java/issues/3293)) ([771bd0e](https://github.com/googleapis/sdk-platform-java/commit/771bd0e9cb306e430dc15e79a189648830101865))


### Dependencies

* update dependency com.google.errorprone:error_prone_annotations to v2.34.0 ([#3303](https://github.com/googleapis/sdk-platform-java/issues/3303)) ([5b01274](https://github.com/googleapis/sdk-platform-java/commit/5b0127480ac1358b183d971e432939779f1238ad))
* update dependency com.google.errorprone:error_prone_annotations to v2.34.0 ([#3304](https://github.com/googleapis/sdk-platform-java/issues/3304)) ([5bd6c9c](https://github.com/googleapis/sdk-platform-java/commit/5bd6c9ceaab11f96c6e50ca8ce9c66c1c1369d5c))
* update google api dependencies ([#3282](https://github.com/googleapis/sdk-platform-java/issues/3282)) ([a9eac85](https://github.com/googleapis/sdk-platform-java/commit/a9eac851c57989ab45c4e1b28171ea043506bcd9))
* update google auth library dependencies to v1.29.0 ([#3302](https://github.com/googleapis/sdk-platform-java/issues/3302)) ([e64eda2](https://github.com/googleapis/sdk-platform-java/commit/e64eda231bc3a1a32d56eb5269ae8d3c53ed26de))

## [2.47.0](https://github.com/googleapis/sdk-platform-java/compare/v2.46.1...v2.47.0) (2024-10-04)


### Features

* **gax:** add API key authentication to ClientSettings ([#3137](https://github.com/googleapis/sdk-platform-java/issues/3137)) ([df08956](https://github.com/googleapis/sdk-platform-java/commit/df08956a26fa63b287241f3a37058c689c34d245))
* **gax:** append cred-type header for auth metrics ([#3186](https://github.com/googleapis/sdk-platform-java/issues/3186)) ([ca3ec24](https://github.com/googleapis/sdk-platform-java/commit/ca3ec24f506f0d43623a92ba0eed908f874fe488))


### Bug Fixes

* address incorrect universe domain validation when quota project id is set ([#3257](https://github.com/googleapis/sdk-platform-java/issues/3257)) ([6e70c37](https://github.com/googleapis/sdk-platform-java/commit/6e70c3705280576278a790a4228476ac996ef9da)), closes [#3256](https://github.com/googleapis/sdk-platform-java/issues/3256)
* Disable automatically retrieving Universe Domain from Metadata Server ([#3272](https://github.com/googleapis/sdk-platform-java/issues/3272)) ([f4402bf](https://github.com/googleapis/sdk-platform-java/commit/f4402bfa717831507e9e54d057d11ff69594e46b))


### Dependencies

* update dependency com.fasterxml.jackson:jackson-bom to v2.18.0 ([#3248](https://github.com/googleapis/sdk-platform-java/issues/3248)) ([821e83d](https://github.com/googleapis/sdk-platform-java/commit/821e83d8cef94594f8c8e832c40e319c232cb1b9))
* update dependency com.google.errorprone:error_prone_annotations to v2.33.0 ([#3265](https://github.com/googleapis/sdk-platform-java/issues/3265)) ([94450a9](https://github.com/googleapis/sdk-platform-java/commit/94450a9699d94a078e5f5fa106f4d1ce4282a605))
* update dependency com.google.errorprone:error_prone_annotations to v2.33.0 ([#3266](https://github.com/googleapis/sdk-platform-java/issues/3266)) ([8235463](https://github.com/googleapis/sdk-platform-java/commit/8235463dc2bc05382359d09702be55e2063f4908))
* update dependency com.google.guava:guava to v33.3.1-jre ([#3228](https://github.com/googleapis/sdk-platform-java/issues/3228)) ([4e76207](https://github.com/googleapis/sdk-platform-java/commit/4e762078a59e6fd92453bb5a1395730f6f442524))
* update dependency net.bytebuddy:byte-buddy to v1.15.3 ([#3246](https://github.com/googleapis/sdk-platform-java/issues/3246)) ([2aad71d](https://github.com/googleapis/sdk-platform-java/commit/2aad71dda5fe2bb0cdbe823392cccb36cfea6abb))
* update google api dependencies ([#3242](https://github.com/googleapis/sdk-platform-java/issues/3242)) ([02aae9d](https://github.com/googleapis/sdk-platform-java/commit/02aae9d919b5c7170eb88d08d0ee79f71a0c5762))
* update google auth library dependencies to v1.28.0 ([#3267](https://github.com/googleapis/sdk-platform-java/issues/3267)) ([6d85864](https://github.com/googleapis/sdk-platform-java/commit/6d85864779ae61cecddc3eaa9d8991ed4053a253))
* update googleapis/java-cloud-bom digest to 0cd97b7 ([#3260](https://github.com/googleapis/sdk-platform-java/issues/3260)) ([2d54a5d](https://github.com/googleapis/sdk-platform-java/commit/2d54a5d2825e0956c76f68e22426bbb7665fdb12))
* update grpc dependencies to v1.67.1 ([#3258](https://github.com/googleapis/sdk-platform-java/issues/3258)) ([e08906c](https://github.com/googleapis/sdk-platform-java/commit/e08906cd86146bfa4f62bbc5e507bf04a0956a37))
* update grpc dependencies to v1.67.1 in dependencies.properties ([#3279](https://github.com/googleapis/sdk-platform-java/issues/3279)) ([5b46e70](https://github.com/googleapis/sdk-platform-java/commit/5b46e7036d65f350c21a5c922997b4d38532f994))
* update junit5 monorepo to v5.11.2 ([#3276](https://github.com/googleapis/sdk-platform-java/issues/3276)) ([6b10f94](https://github.com/googleapis/sdk-platform-java/commit/6b10f94c56e8769ff41bb58c77b8c45dafeacc45))
* update netty dependencies to v4.1.114.final ([#3263](https://github.com/googleapis/sdk-platform-java/issues/3263)) ([8bd83d9](https://github.com/googleapis/sdk-platform-java/commit/8bd83d9ed0794f2aa2f771d6f28d492ecb98500f))

## [2.46.1](https://github.com/googleapis/sdk-platform-java/compare/v2.46.0...v2.46.1) (2024-09-25)


### Dependencies

* update dependency black to v24.8.0 ([#3234](https://github.com/googleapis/sdk-platform-java/issues/3234)) ([73d803b](https://github.com/googleapis/sdk-platform-java/commit/73d803b0dddca82a32c1789a9f92bc48431850aa))
* update dependency lxml to v5.3.0 ([#3237](https://github.com/googleapis/sdk-platform-java/issues/3237)) ([ee2d05a](https://github.com/googleapis/sdk-platform-java/commit/ee2d05a1d7cb03615ba190802e4e720be2955345))
* update dependency net.bytebuddy:byte-buddy to v1.15.2 ([#3235](https://github.com/googleapis/sdk-platform-java/issues/3235)) ([a7781a6](https://github.com/googleapis/sdk-platform-java/commit/a7781a6ab3a052f60a51b4d1d06464553dcd6b5c))
* update dependency pyyaml to v6.0.2 ([#3231](https://github.com/googleapis/sdk-platform-java/issues/3231)) ([ce60bdf](https://github.com/googleapis/sdk-platform-java/commit/ce60bdf2c95ce3e9e549f1a9a2eb788424e3d454))
* update dependency watchdog to v4.0.2 ([#3232](https://github.com/googleapis/sdk-platform-java/issues/3232)) ([ab0976b](https://github.com/googleapis/sdk-platform-java/commit/ab0976b196afb3ff67aca17f121d01bb511375c3))
* update google api dependencies ([#3224](https://github.com/googleapis/sdk-platform-java/issues/3224)) ([4803738](https://github.com/googleapis/sdk-platform-java/commit/4803738938bf7f602baca025b4bdfbef13f6202e))
* update google.cloud.opentelemetry.version to v0.32.0 ([#3225](https://github.com/googleapis/sdk-platform-java/issues/3225)) ([69e3e38](https://github.com/googleapis/sdk-platform-java/commit/69e3e38a680cfb5fc9dbcb1fea67d39c89945bdd))
* update grpc dependencies to v1.68.0 ([#3220](https://github.com/googleapis/sdk-platform-java/issues/3220)) ([f6e30a5](https://github.com/googleapis/sdk-platform-java/commit/f6e30a57816affeb1802d3266b6166ec174a06ee))
* update junit5 monorepo to v5.11.1 ([#3236](https://github.com/googleapis/sdk-platform-java/issues/3236)) ([8b42993](https://github.com/googleapis/sdk-platform-java/commit/8b42993767c6bba36f396156a5e84217d83c7c57))

## [2.46.0](https://github.com/googleapis/sdk-platform-java/compare/v2.45.0...v2.46.0) (2024-09-23)


### Features

* expose property in GrpcTransportChannel if it uses direct path. ([#3170](https://github.com/googleapis/sdk-platform-java/issues/3170)) ([9a432f7](https://github.com/googleapis/sdk-platform-java/commit/9a432f7ce042fb2470ca99817200e0ff82a83c39))
* generate a GAPIC library from api definition ([#3208](https://github.com/googleapis/sdk-platform-java/issues/3208)) ([b6b5d7b](https://github.com/googleapis/sdk-platform-java/commit/b6b5d7bbe2743034def0859105da146134d9b1b0))
* Metrics tracer addAttribute map overload ([#3202](https://github.com/googleapis/sdk-platform-java/issues/3202)) ([1a988df](https://github.com/googleapis/sdk-platform-java/commit/1a988df22f7e3d15ce6b121bf26897c59ab468e4))


### Bug Fixes

* generate pr description with repo level change ([#3182](https://github.com/googleapis/sdk-platform-java/issues/3182)) ([edd2168](https://github.com/googleapis/sdk-platform-java/commit/edd2168fdc7ba7ea9ae328736cb5d39adf950929))


### Dependencies

* update dependency com.google.errorprone:error_prone_annotations to v2.32.0 ([#3192](https://github.com/googleapis/sdk-platform-java/issues/3192)) ([b280706](https://github.com/googleapis/sdk-platform-java/commit/b28070686ed1360084cd95beb622b78966f4960c))
* update dependency com.google.errorprone:error_prone_annotations to v2.32.0 ([#3193](https://github.com/googleapis/sdk-platform-java/issues/3193)) ([ed0cd17](https://github.com/googleapis/sdk-platform-java/commit/ed0cd1729b6b964d730a8c5f38589939aab3fd8a))
* update dependency filelock to v3.16.1 ([#3210](https://github.com/googleapis/sdk-platform-java/issues/3210)) ([703ac3d](https://github.com/googleapis/sdk-platform-java/commit/703ac3d0b73d5388d60b910bcd26bcde6327a0a3))
* update dependency idna to v3.10 ([#3201](https://github.com/googleapis/sdk-platform-java/issues/3201)) ([211c3ec](https://github.com/googleapis/sdk-platform-java/commit/211c3ecdec1a088267dc3c2765f5eb3835496c9b))
* update dependency org.threeten:threetenbp to v1.7.0 ([#3205](https://github.com/googleapis/sdk-platform-java/issues/3205)) ([c88a722](https://github.com/googleapis/sdk-platform-java/commit/c88a722c09080b18ecbb9ba94dec56f152de5eb9))
* update dependency org.threeten:threetenbp to v1.7.0 ([#3206](https://github.com/googleapis/sdk-platform-java/issues/3206)) ([3e9fbac](https://github.com/googleapis/sdk-platform-java/commit/3e9fbacf65411521c87e67f3dd33f392276e8200))
* update dependency platformdirs to v4.3.3 ([#3200](https://github.com/googleapis/sdk-platform-java/issues/3200)) ([b62b05d](https://github.com/googleapis/sdk-platform-java/commit/b62b05de5295484b48b36fcbf9b94887184d05d4))
* update dependency platformdirs to v4.3.6 ([#3209](https://github.com/googleapis/sdk-platform-java/issues/3209)) ([227ffa5](https://github.com/googleapis/sdk-platform-java/commit/227ffa5a841c29b91f848453e8be2accf44041f3))
* update dependency urllib3 to v2.2.3 ([#3194](https://github.com/googleapis/sdk-platform-java/issues/3194)) ([f69d511](https://github.com/googleapis/sdk-platform-java/commit/f69d511d89a50d88bb45fd113611e4f94886696b))
* update dependency virtualenv to v20.26.5 ([#3212](https://github.com/googleapis/sdk-platform-java/issues/3212)) ([d3ef97a](https://github.com/googleapis/sdk-platform-java/commit/d3ef97a5b9f5252a1e503b638261746a7cf4dc77))
* update google api dependencies ([#3183](https://github.com/googleapis/sdk-platform-java/issues/3183)) ([02eea8d](https://github.com/googleapis/sdk-platform-java/commit/02eea8d62e5e2d019a97545429346810e00bcaa6))
* update google auth library dependencies to v1.26.0 ([#3216](https://github.com/googleapis/sdk-platform-java/issues/3216)) ([0b369e9](https://github.com/googleapis/sdk-platform-java/commit/0b369e9ba6551eae6d2041ce430912b56ae9b394))
* update google auth library dependencies to v1.27.0 ([#3221](https://github.com/googleapis/sdk-platform-java/issues/3221)) ([a3cb9e7](https://github.com/googleapis/sdk-platform-java/commit/a3cb9e75839ceb811f9e264073758691068e4a95))
* update googleapis/java-cloud-bom digest to 06f632d ([#3198](https://github.com/googleapis/sdk-platform-java/issues/3198)) ([49dcd35](https://github.com/googleapis/sdk-platform-java/commit/49dcd3535fc2836df3a5d7b1665051cd54d09f29))
* update googleapis/java-cloud-bom digest to e7d8909 ([#3207](https://github.com/googleapis/sdk-platform-java/issues/3207)) ([de497ee](https://github.com/googleapis/sdk-platform-java/commit/de497ee716a4fd0ab3bc64d66c1dc24af11c0368))
* update opentelemetry-java monorepo to v1.42.1 ([#3189](https://github.com/googleapis/sdk-platform-java/issues/3189)) ([38117d8](https://github.com/googleapis/sdk-platform-java/commit/38117d8b92930abc6e6922a4c46654d02e823f67))
* Upgrade Protobuf-Java to v3.25.5 ([#3217](https://github.com/googleapis/sdk-platform-java/issues/3217)) ([860c1bc](https://github.com/googleapis/sdk-platform-java/commit/860c1bcfc213fe7b21969c80282c8c08637cd3ba))

## [2.45.0](https://github.com/googleapis/sdk-platform-java/compare/v2.44.0...v2.45.0) (2024-09-09)


### Features

* add Batcher#close(timeout) and Batcher#cancelOutstanding ([#3141](https://github.com/googleapis/sdk-platform-java/issues/3141)) ([b5a92e4](https://github.com/googleapis/sdk-platform-java/commit/b5a92e4495b33ad797f9a071a97828460dacd80f))
* add full RetrySettings sample code to Settings classes ([#3056](https://github.com/googleapis/sdk-platform-java/issues/3056)) ([8fe3a2d](https://github.com/googleapis/sdk-platform-java/commit/8fe3a2d4cfac5d038bcf12afe849c9182073920e))
* add toString to futures returned by operations ([#3140](https://github.com/googleapis/sdk-platform-java/issues/3140)) ([afecb8c](https://github.com/googleapis/sdk-platform-java/commit/afecb8c43c48067931b3fed78cf2eec55d983f9c))
* bake gapic-generator-java into the hermetic build docker image ([#3067](https://github.com/googleapis/sdk-platform-java/issues/3067)) ([a372e82](https://github.com/googleapis/sdk-platform-java/commit/a372e82ad322e409cd49196e96abee62cbc567ea))


### Bug Fixes

* **gax:** prevent truncation/overflow when converting time values ([#3095](https://github.com/googleapis/sdk-platform-java/issues/3095)) ([699074e](https://github.com/googleapis/sdk-platform-java/commit/699074e2db06c4d6d7ebfa235cc2aaeee695fdb4))


### Dependencies

* add opentelemetry exporter-metrics and shared-resoucemapping to shared dependencies ([#3078](https://github.com/googleapis/sdk-platform-java/issues/3078)) ([fc8d80d](https://github.com/googleapis/sdk-platform-java/commit/fc8d80d11182259c0c15d36c6427db5ba316735d))
* update dependency certifi to v2024.8.30 ([#3150](https://github.com/googleapis/sdk-platform-java/issues/3150)) ([c18b705](https://github.com/googleapis/sdk-platform-java/commit/c18b705149d32ecfbfd298c0a414dba067b6a7a9))
* update dependency com.google.api-client:google-api-client-bom to v2.7.0 ([#3151](https://github.com/googleapis/sdk-platform-java/issues/3151)) ([5f43e43](https://github.com/googleapis/sdk-platform-java/commit/5f43e43351ee26ee3729218c0dfe282f20c9053b))
* update dependency com.google.errorprone:error_prone_annotations to v2.31.0 ([#3153](https://github.com/googleapis/sdk-platform-java/issues/3153)) ([3071509](https://github.com/googleapis/sdk-platform-java/commit/307150935e3b9e1000570f869e5ad14901fd0513))
* update dependency com.google.errorprone:error_prone_annotations to v2.31.0 ([#3154](https://github.com/googleapis/sdk-platform-java/issues/3154)) ([335ee63](https://github.com/googleapis/sdk-platform-java/commit/335ee63577616eecdbd1d3ccd0526393eb0e50be))
* update dependency com.google.guava:guava to v33.3.0-jre ([#3119](https://github.com/googleapis/sdk-platform-java/issues/3119)) ([41174b0](https://github.com/googleapis/sdk-platform-java/commit/41174b04a5d4e5cff02dab95d5249e21b8d80496))
* update dependency dev.cel:cel to v0.7.1 ([#3155](https://github.com/googleapis/sdk-platform-java/issues/3155)) ([b1ddd16](https://github.com/googleapis/sdk-platform-java/commit/b1ddd16158d30aa7716caa4ec408bf45bb3a7a69))
* update dependency filelock to v3.16.0 ([#3175](https://github.com/googleapis/sdk-platform-java/issues/3175)) ([6681113](https://github.com/googleapis/sdk-platform-java/commit/6681113f1e71c9d0aa4fe0e9d641bf06ccc93f88))
* update dependency idna to v3.8 ([#3156](https://github.com/googleapis/sdk-platform-java/issues/3156)) ([82f5326](https://github.com/googleapis/sdk-platform-java/commit/82f5326b3f6b94a87009f58f8599780ebfdf77c2))
* update dependency io.netty:netty-tcnative-boringssl-static to v2.0.66.final ([#3148](https://github.com/googleapis/sdk-platform-java/issues/3148)) ([a7efaa8](https://github.com/googleapis/sdk-platform-java/commit/a7efaa8a06c016878ba8083ddbf4588506f7653e))
* update dependency net.bytebuddy:byte-buddy to v1.15.1 ([#3115](https://github.com/googleapis/sdk-platform-java/issues/3115)) ([0e06c5f](https://github.com/googleapis/sdk-platform-java/commit/0e06c5f51f13b5de6dab18391d9738ed7c9452ff))
* update dependency org.apache.commons:commons-lang3 to v3.17.0 ([#3157](https://github.com/googleapis/sdk-platform-java/issues/3157)) ([8d3b9fd](https://github.com/googleapis/sdk-platform-java/commit/8d3b9fd1f1872a10635a3e82a2be75c5b964d582))
* update dependency org.checkerframework:checker-qual to v3.47.0 ([#3166](https://github.com/googleapis/sdk-platform-java/issues/3166)) ([365674d](https://github.com/googleapis/sdk-platform-java/commit/365674d51bee846aeb0aab2491659d59e48b7512))
* update dependency org.yaml:snakeyaml to v2.3 ([#3158](https://github.com/googleapis/sdk-platform-java/issues/3158)) ([e67ea9a](https://github.com/googleapis/sdk-platform-java/commit/e67ea9af7d2334d225f75eef2dd24490ee90a442))
* update dependency platformdirs to v4.3.2 ([#3176](https://github.com/googleapis/sdk-platform-java/issues/3176)) ([4f2f9e0](https://github.com/googleapis/sdk-platform-java/commit/4f2f9e027d1413e1beca1092c20e2e542227ca28))
* update dependency virtualenv to v20.26.4 ([#3177](https://github.com/googleapis/sdk-platform-java/issues/3177)) ([080e078](https://github.com/googleapis/sdk-platform-java/commit/080e07879d9493a0f1ad53b1c44c181805ef1d25))
* update google api dependencies ([#3118](https://github.com/googleapis/sdk-platform-java/issues/3118)) ([67342ea](https://github.com/googleapis/sdk-platform-java/commit/67342ea9f11643f02bf215193f7c760d7a05ca2e))
* update google auth library dependencies to v1.25.0 ([#3168](https://github.com/googleapis/sdk-platform-java/issues/3168)) ([715884a](https://github.com/googleapis/sdk-platform-java/commit/715884ab21c0b3bb526f280ffb100d3f621a5c6c))
* update google http client dependencies to v1.45.0 ([#3159](https://github.com/googleapis/sdk-platform-java/issues/3159)) ([a3fe612](https://github.com/googleapis/sdk-platform-java/commit/a3fe612476904f34afdf0009fbd53d58aac5ad85))
* update googleapis/java-cloud-bom digest to 6626f91 ([#3147](https://github.com/googleapis/sdk-platform-java/issues/3147)) ([658e40e](https://github.com/googleapis/sdk-platform-java/commit/658e40e7b7f1673b8f82c537a255aa0c294ee4aa))
* update junit5 monorepo to v5.11.0 ([#3111](https://github.com/googleapis/sdk-platform-java/issues/3111)) ([6bf84c8](https://github.com/googleapis/sdk-platform-java/commit/6bf84c86ffa3cbc74691ab8de82d69fb0eb75bf9))
* update netty dependencies to v4.1.113.final ([#3165](https://github.com/googleapis/sdk-platform-java/issues/3165)) ([9b5957d](https://github.com/googleapis/sdk-platform-java/commit/9b5957da2e584569dea523ebcb1af47d49e7a749))
* update opentelemetry-java monorepo to v1.42.0 ([#3172](https://github.com/googleapis/sdk-platform-java/issues/3172)) ([413c44e](https://github.com/googleapis/sdk-platform-java/commit/413c44e1dbe466b68eb8a5a62b707c2e9544ffaf))


### Documentation

* Update DEVELOPMENT.md ([#3126](https://github.com/googleapis/sdk-platform-java/issues/3126)) ([92bdf4e](https://github.com/googleapis/sdk-platform-java/commit/92bdf4e19a8c3df365c067142a7aa112a004be20))

## [2.44.0](https://github.com/googleapis/sdk-platform-java/compare/v2.43.0...v2.44.0) (2024-08-16)


### Features

* update ErrorDetails to allow unpacking arbitrary messages ([#3073](https://github.com/googleapis/sdk-platform-java/issues/3073)) ([6913db5](https://github.com/googleapis/sdk-platform-java/commit/6913db5c64e35ec8925c25a04ebd6d529895c4fe))


### Bug Fixes

* Generator callable generation is based on method type ([#3075](https://github.com/googleapis/sdk-platform-java/issues/3075)) ([c21a013](https://github.com/googleapis/sdk-platform-java/commit/c21a0139cccb9001951cab81f4c5ffe3ae51d7c5))
* improve warnings for Direct Path xDS set via env ([#3019](https://github.com/googleapis/sdk-platform-java/issues/3019)) ([7a26115](https://github.com/googleapis/sdk-platform-java/commit/7a26115078d23e430e190c62556c014c440fcab2))


### Dependencies

* update dependency argcomplete to v3.5.0 ([#3099](https://github.com/googleapis/sdk-platform-java/issues/3099)) ([0654a28](https://github.com/googleapis/sdk-platform-java/commit/0654a289b745e153e4f41b02cbdc180e3ca9a231))
* update dependency black to v24.8.0 ([#3082](https://github.com/googleapis/sdk-platform-java/issues/3082)) ([a864f62](https://github.com/googleapis/sdk-platform-java/commit/a864f622023e096f207cf6fe3321f92d1b9f4560))
* update dependency com.google.crypto.tink:tink to v1.14.1 ([#3083](https://github.com/googleapis/sdk-platform-java/issues/3083)) ([c13b63e](https://github.com/googleapis/sdk-platform-java/commit/c13b63e1e4b391650eb6a0949d1fbc2319a28de6))
* update dependency com.google.errorprone:error_prone_annotations to v2.30.0 ([#3100](https://github.com/googleapis/sdk-platform-java/issues/3100)) ([a10ef54](https://github.com/googleapis/sdk-platform-java/commit/a10ef54fcd86c321bf15acd4fe5fa96f9937d318))
* update dependency com.google.errorprone:error_prone_annotations to v2.30.0 ([#3101](https://github.com/googleapis/sdk-platform-java/issues/3101)) ([9bff64f](https://github.com/googleapis/sdk-platform-java/commit/9bff64f416c3eb046cca30ff974a9e9c4b5cebd2))
* update dependency lxml to v5.3.0 ([#3102](https://github.com/googleapis/sdk-platform-java/issues/3102)) ([4e145b1](https://github.com/googleapis/sdk-platform-java/commit/4e145b128b1b964346fc7c1c874d57d9eedc00d2))
* update dependency org.apache.commons:commons-lang3 to v3.16.0 ([#3103](https://github.com/googleapis/sdk-platform-java/issues/3103)) ([95c9508](https://github.com/googleapis/sdk-platform-java/commit/95c9508bd9a20f82687c80def38e510fc539eec3))
* update dependency org.checkerframework:checker-qual to v3.46.0 ([#3081](https://github.com/googleapis/sdk-platform-java/issues/3081)) ([2431920](https://github.com/googleapis/sdk-platform-java/commit/243192089386122c255a4296761775ec80a1fcd0))
* update dependency org.easymock:easymock to v5.4.0 ([#3079](https://github.com/googleapis/sdk-platform-java/issues/3079)) ([182ae50](https://github.com/googleapis/sdk-platform-java/commit/182ae507f9323e5a5861b240e976a0127d1eea04))
* update dependency pyyaml to v6.0.2 ([#3086](https://github.com/googleapis/sdk-platform-java/issues/3086)) ([f847e45](https://github.com/googleapis/sdk-platform-java/commit/f847e45c19d45be57d59e9d6887047d2c12b8267))
* update dependency watchdog to v4.0.2 ([#3094](https://github.com/googleapis/sdk-platform-java/issues/3094)) ([f1c75a1](https://github.com/googleapis/sdk-platform-java/commit/f1c75a15f2462644a58e4a836db6c51cca4ba0a1))
* update google api dependencies ([#3071](https://github.com/googleapis/sdk-platform-java/issues/3071)) ([c5abe90](https://github.com/googleapis/sdk-platform-java/commit/c5abe907ed063f86571634b2df67bca5a6334abf))
* update google auth library dependencies to v1.24.1 ([#3109](https://github.com/googleapis/sdk-platform-java/issues/3109)) ([62acdd6](https://github.com/googleapis/sdk-platform-java/commit/62acdd6f1246c8bd95eec4a53f8cd1896e48ae53))
* update googleapis/java-cloud-bom digest to a98202d ([#3097](https://github.com/googleapis/sdk-platform-java/issues/3097)) ([bb216ae](https://github.com/googleapis/sdk-platform-java/commit/bb216ae8834f5ea169ebfd9a790743680edec053))
* update googleapis/java-cloud-bom digest to ad905cc ([#3080](https://github.com/googleapis/sdk-platform-java/issues/3080)) ([250b26c](https://github.com/googleapis/sdk-platform-java/commit/250b26c5af6f8c78eec94a4c3a42d3a72e06b1e5))
* update grpc dependencies to v1.66.0 ([#3104](https://github.com/googleapis/sdk-platform-java/issues/3104)) ([b63b643](https://github.com/googleapis/sdk-platform-java/commit/b63b643b7f6067278406fe56c125f8497aec108f))
* update opentelemetry-java monorepo to v1.41.0 ([#3105](https://github.com/googleapis/sdk-platform-java/issues/3105)) ([7364916](https://github.com/googleapis/sdk-platform-java/commit/7364916ec5f997d93c668c34e77eef8b9c77d9a5))
* update protobuf to 3.25.4 ([#3113](https://github.com/googleapis/sdk-platform-java/issues/3113)) ([2b271fc](https://github.com/googleapis/sdk-platform-java/commit/2b271fcd7e5db7f1cab3c5210e8137288497f09f))
* update slf4j monorepo to v2.0.16 ([#3098](https://github.com/googleapis/sdk-platform-java/issues/3098)) ([c13f932](https://github.com/googleapis/sdk-platform-java/commit/c13f93264a0fe6643b343fa7a72bd4a59856c3e1))


### Documentation

* Update the Javadoc of ObsoleteApi.java ([#3088](https://github.com/googleapis/sdk-platform-java/issues/3088)) ([0ef6619](https://github.com/googleapis/sdk-platform-java/commit/0ef66196744e21fc3b4e2553d817c0dea5efe127))

## [2.43.0](https://github.com/googleapis/sdk-platform-java/compare/v2.42.0...v2.43.0) (2024-07-25)


### Features

* add `transport` option to `generation_config.yaml` ([#3052](https://github.com/googleapis/sdk-platform-java/issues/3052)) ([3b1a915](https://github.com/googleapis/sdk-platform-java/commit/3b1a91551ab6bbaf6a46950e1677c15cdd70d2e9))
* get released version from versions.txt to render `README.md` ([#3007](https://github.com/googleapis/sdk-platform-java/issues/3007)) ([99bb2b3](https://github.com/googleapis/sdk-platform-java/commit/99bb2b339eadd480dcc1753d4ba3aeda3b5c64de))
* Introduce java.time to Gax-Java ([#1872](https://github.com/googleapis/sdk-platform-java/issues/1872)) ([308aeaf](https://github.com/googleapis/sdk-platform-java/commit/308aeafc9f04795d2e1df8206c84689b11c4323a))
* Mark `getDefaultEndpoint()` with @ObsoleteApi ([#2347](https://github.com/googleapis/sdk-platform-java/issues/2347)) ([e46648f](https://github.com/googleapis/sdk-platform-java/commit/e46648f112a149f967783539d30b4c44474b39fe))
* parse `BUILD.bzel` to determine whether a commit that only changed `BUILD.bazel` is a qualified commit ([#2937](https://github.com/googleapis/sdk-platform-java/issues/2937)) ([502f801](https://github.com/googleapis/sdk-platform-java/commit/502f80101dec191befb660a1aba6d0c354758c18))


### Bug Fixes

* Fix:  ([d996c2d](https://github.com/googleapis/sdk-platform-java/commit/d996c2dfb4b1cb115e0a2cd117eebd8a4ab41cad))
* `BaseApiTracer` to noop on attemptFailed via overloaded method call ([#3016](https://github.com/googleapis/sdk-platform-java/issues/3016)) ([2fc938a](https://github.com/googleapis/sdk-platform-java/commit/2fc938a819f4a2da9cfd25d2d306b62f53fa1f91))
* Generator to skip generation for empty services. ([#3051](https://github.com/googleapis/sdk-platform-java/issues/3051)) ([ff2c485](https://github.com/googleapis/sdk-platform-java/commit/ff2c48543940bb0ceb78392b0f5af67568823002))
* restore hermetic build image publication ([#2952](https://github.com/googleapis/sdk-platform-java/issues/2952)) ([97a6d67](https://github.com/googleapis/sdk-platform-java/commit/97a6d678569b7d8768ff83fe5370d8966a06ca95))


### Dependencies

* update dependency com.fasterxml.jackson:jackson-bom to v2.17.2 ([#3028](https://github.com/googleapis/sdk-platform-java/issues/3028)) ([d16f9d1](https://github.com/googleapis/sdk-platform-java/commit/d16f9d114a75fb8a77dfc39edf6fe2aa2f967704))
* update dependency com.google.cloud.opentelemetry:detector-resources-support to v0.30.0 ([#2975](https://github.com/googleapis/sdk-platform-java/issues/2975)) ([b3ec93f](https://github.com/googleapis/sdk-platform-java/commit/b3ec93f1925ff5a92b47200a61303e5561dbb1b8))
* update dependency com.google.cloud.opentelemetry:detector-resources-support to v0.31.0 ([#3044](https://github.com/googleapis/sdk-platform-java/issues/3044)) ([6bd07dc](https://github.com/googleapis/sdk-platform-java/commit/6bd07dc9fb589c72cf7b86bb2e0137687e1f61f2))
* update dependency com.google.errorprone:error_prone_annotations to v2.29.2 ([#3058](https://github.com/googleapis/sdk-platform-java/issues/3058)) ([8ea0868](https://github.com/googleapis/sdk-platform-java/commit/8ea0868e9e67a4c58075b98de0cf7b51635ea2f8))
* update dependency com.google.errorprone:error_prone_annotations to v2.29.2 ([#3059](https://github.com/googleapis/sdk-platform-java/issues/3059)) ([81b23dc](https://github.com/googleapis/sdk-platform-java/commit/81b23dc88eeff492f6cef6328ce3b5d32992f500))
* update dependency com.google.guava:guava to v33.2.1-jre ([#3027](https://github.com/googleapis/sdk-platform-java/issues/3027)) ([12ee456](https://github.com/googleapis/sdk-platform-java/commit/12ee456727d0cd9d86aeadd65e633b5d7abb3d50))
* update dependency commons-codec:commons-codec to v1.17.1 ([#3049](https://github.com/googleapis/sdk-platform-java/issues/3049)) ([58d94b7](https://github.com/googleapis/sdk-platform-java/commit/58d94b795db06fa76099c871501d2a1f7465633b))
* update dependency dev.cel:cel to v0.6.0 ([#3050](https://github.com/googleapis/sdk-platform-java/issues/3050)) ([bc332d9](https://github.com/googleapis/sdk-platform-java/commit/bc332d95919c0a1909e43f4ab7c7fe4db406697e))
* update dependency net.bytebuddy:byte-buddy to v1.14.18 ([#3029](https://github.com/googleapis/sdk-platform-java/issues/3029)) ([8799cf6](https://github.com/googleapis/sdk-platform-java/commit/8799cf602a3204a4adeaf4f48000979e49107959))
* update dependency org.apache.commons:commons-lang3 to v3.15.0 ([#3060](https://github.com/googleapis/sdk-platform-java/issues/3060)) ([2538334](https://github.com/googleapis/sdk-platform-java/commit/2538334aff96a4ad70a26bac2141d3235856b1a1))
* update dependency org.checkerframework:checker-qual to v3.45.0 ([#2988](https://github.com/googleapis/sdk-platform-java/issues/2988)) ([4edd216](https://github.com/googleapis/sdk-platform-java/commit/4edd216163662008ee1060b6eb82ca673045826f))
* update google api dependencies ([#2951](https://github.com/googleapis/sdk-platform-java/issues/2951)) ([c16f6c9](https://github.com/googleapis/sdk-platform-java/commit/c16f6c95636b4997861ef3914b06f7819a8bd69a))
* update google auth library dependencies to v1.24.0 ([#3039](https://github.com/googleapis/sdk-platform-java/issues/3039)) ([98b5bd7](https://github.com/googleapis/sdk-platform-java/commit/98b5bd7d2ddb98c7e52bffd0b93c5661a1c9d39b))
* update googleapis/java-cloud-bom digest to 47c5dbc ([#2974](https://github.com/googleapis/sdk-platform-java/issues/2974)) ([57623f0](https://github.com/googleapis/sdk-platform-java/commit/57623f08441969e0ff0170a72779fb8425ff6592))
* update grpc dependencies to v1.65.1 ([#3061](https://github.com/googleapis/sdk-platform-java/issues/3061)) ([27497e2](https://github.com/googleapis/sdk-platform-java/commit/27497e215cda4e8ad17fce2faa794b600edfc4cd))
* update junit5 monorepo to v5.10.3 ([#2963](https://github.com/googleapis/sdk-platform-java/issues/2963)) ([bc55fe1](https://github.com/googleapis/sdk-platform-java/commit/bc55fe1fe55876ee3b4843cefb05ee401c323865))
* update netty dependencies to v4.1.112.final ([#3057](https://github.com/googleapis/sdk-platform-java/issues/3057)) ([5af127b](https://github.com/googleapis/sdk-platform-java/commit/5af127be3d9dadcdf0d9a5519ce6ad3b2e3bb481))
* update opentelemetry-java monorepo to v1.40.0 ([#3035](https://github.com/googleapis/sdk-platform-java/issues/3035)) ([5c31c42](https://github.com/googleapis/sdk-platform-java/commit/5c31c4211993f25d2c352ef8f3e085187bc5fd30))
* Use Gapic-Showcase v0.35.1 ([#3018](https://github.com/googleapis/sdk-platform-java/issues/3018)) ([43773f0](https://github.com/googleapis/sdk-platform-java/commit/43773f0cf2418051b2c0e6245100973b8ce2152e))


### Documentation

* add support option to 'new issue' choices ([#3055](https://github.com/googleapis/sdk-platform-java/issues/3055)) ([6a2a17d](https://github.com/googleapis/sdk-platform-java/commit/6a2a17d1d84da9d45a4be6675ea6ca0235b42c99))

## [2.42.0](https://github.com/googleapis/sdk-platform-java/compare/v2.41.0...v2.42.0) (2024-06-25)


### Features

* Allow Adding Client Level Attributes to MetricsTracerFactory ([#2614](https://github.com/googleapis/sdk-platform-java/issues/2614)) ([f122c6f](https://github.com/googleapis/sdk-platform-java/commit/f122c6f3beebd005a257fe687cf018baf7673b63))
* gapic-generator-java to perform a no-op when no services are detected ([#2460](https://github.com/googleapis/sdk-platform-java/issues/2460)) ([c0b5646](https://github.com/googleapis/sdk-platform-java/commit/c0b56462a1550c3720a3e5d0b11dcc1a21add7ef))
* Make Layout Parser generally available in V1 ([e508ae6](https://github.com/googleapis/sdk-platform-java/commit/e508ae69e13455ba2f5c325e0c33d9ff2704e3b1))
* populate `.repo-metadata.json` from highest version ([#2890](https://github.com/googleapis/sdk-platform-java/issues/2890)) ([f587541](https://github.com/googleapis/sdk-platform-java/commit/f58754178d16e5054326d78d1d372efe1408fa5e))
* push SNAPSHOT versions of the hermetic build docker image ([#2888](https://github.com/googleapis/sdk-platform-java/issues/2888)) ([81df866](https://github.com/googleapis/sdk-platform-java/commit/81df8660f85785ac7f8ff07ba7686caa0bfd583d))


### Bug Fixes

* **deps:** update the Java code generator (gapic-generator-java) to 1.2.3 ([e508ae6](https://github.com/googleapis/sdk-platform-java/commit/e508ae69e13455ba2f5c325e0c33d9ff2704e3b1))
* Expose Gax meter name ([#2865](https://github.com/googleapis/sdk-platform-java/issues/2865)) ([6c5d6ce](https://github.com/googleapis/sdk-platform-java/commit/6c5d6cee7d5034dfc20c43a520d6321689299f21))
* Move the logic of getting systemProductName from static block to static method ([#2874](https://github.com/googleapis/sdk-platform-java/issues/2874)) ([536f1eb](https://github.com/googleapis/sdk-platform-java/commit/536f1eb6658b44794e9dbba7d9536ecfade84cc3))
* Update default Otel Attribute from method_name to method ([#2833](https://github.com/googleapis/sdk-platform-java/issues/2833)) ([af10a9e](https://github.com/googleapis/sdk-platform-java/commit/af10a9ef26a5fd9f24fc5341d144b8ee00ff3d00))


### Dependencies

* update dependency com.google.auto.value:auto-value to v1.11.0 ([#2842](https://github.com/googleapis/sdk-platform-java/issues/2842)) ([dd27fdf](https://github.com/googleapis/sdk-platform-java/commit/dd27fdf03ed756799212ba34a99568b234e13a2a))
* update dependency com.google.auto.value:auto-value-annotations to v1.11.0 ([#2843](https://github.com/googleapis/sdk-platform-java/issues/2843)) ([bf8e67f](https://github.com/googleapis/sdk-platform-java/commit/bf8e67f3f4c582b7584b6811eb2ae6cb46f8c90e))
* update dependency com.google.cloud:grpc-gcp to v1.6.1 ([#2943](https://github.com/googleapis/sdk-platform-java/issues/2943)) ([9f16b40](https://github.com/googleapis/sdk-platform-java/commit/9f16b403807a97d8e620aeb5feb74dc4e14367e1))
* update dependency org.checkerframework:checker-qual to v3.44.0 ([#2848](https://github.com/googleapis/sdk-platform-java/issues/2848)) ([7a99c50](https://github.com/googleapis/sdk-platform-java/commit/7a99c508695e342e10e011dea9bbab371df61ac4))
* update dependency org.easymock:easymock to v5.3.0 ([#2871](https://github.com/googleapis/sdk-platform-java/issues/2871)) ([c243f7d](https://github.com/googleapis/sdk-platform-java/commit/c243f7dbea5441620364cd51f1829f2690628661))
* update google api dependencies ([#2846](https://github.com/googleapis/sdk-platform-java/issues/2846)) ([b5ef698](https://github.com/googleapis/sdk-platform-java/commit/b5ef6983f8474c8444caf650116fb34b2e602636))
* update googleapis/java-cloud-bom digest to 17cc5ec ([#2882](https://github.com/googleapis/sdk-platform-java/issues/2882)) ([d6abd8e](https://github.com/googleapis/sdk-platform-java/commit/d6abd8e0aa37de42038c47e262020a7dd9090907))
* update netty dependencies to v4.1.111.final ([#2877](https://github.com/googleapis/sdk-platform-java/issues/2877)) ([b5f10b9](https://github.com/googleapis/sdk-platform-java/commit/b5f10b94a16e065aba5d5abe6c0348be87ecf01b))
* update opentelemetry-java monorepo to v1.39.0 ([#2863](https://github.com/googleapis/sdk-platform-java/issues/2863)) ([9d1f3a8](https://github.com/googleapis/sdk-platform-java/commit/9d1f3a8cd7478df6068b9171c8dc8eb65dc70313))

## [2.41.0](https://github.com/googleapis/sdk-platform-java/compare/v2.40.1...v2.41.0) (2024-05-31)


### Features

* add a github client ([#2747](https://github.com/googleapis/sdk-platform-java/issues/2747)) ([f8ea0a0](https://github.com/googleapis/sdk-platform-java/commit/f8ea0a086ddff10a2484a1e2ea249d4832a02f34))
* generate proto-only repository ([#2720](https://github.com/googleapis/sdk-platform-java/issues/2720)) ([f7a5161](https://github.com/googleapis/sdk-platform-java/commit/f7a5161b637cbefe922b655582f5604e080f51e5))


### Bug Fixes

* [#2785](https://github.com/googleapis/sdk-platform-java/issues/2785). ([599f5da](https://github.com/googleapis/sdk-platform-java/commit/599f5da13b3e640387a2917b64d6c888167c41f6))


### Dependencies

* update dependency com.google.api-client:google-api-client-bom to v2.6.0 ([#2782](https://github.com/googleapis/sdk-platform-java/issues/2782)) ([5bc8928](https://github.com/googleapis/sdk-platform-java/commit/5bc89283ba4d9b2cb09c782b1bcc2ce3166650ce))
* update dependency com.google.cloud.opentelemetry:detector-resources-support to v0.29.0 ([#2831](https://github.com/googleapis/sdk-platform-java/issues/2831)) ([6c1dbfc](https://github.com/googleapis/sdk-platform-java/commit/6c1dbfc2526d9146e551efdbfb62d4add6393ee2))
* update dependency com.google.code.gson:gson to v2.11.0 ([#2786](https://github.com/googleapis/sdk-platform-java/issues/2786)) ([91f3254](https://github.com/googleapis/sdk-platform-java/commit/91f3254357944410c9b7fd3ef64a17b6da059ffe))
* update dependency com.google.code.gson:gson to v2.11.0 ([#2787](https://github.com/googleapis/sdk-platform-java/issues/2787)) ([e81893c](https://github.com/googleapis/sdk-platform-java/commit/e81893c72d1c4ae2fcc05b0ad3a1c5b772bd1715))
* update dependency com.google.errorprone:error_prone_annotations to v2.28.0 ([#2835](https://github.com/googleapis/sdk-platform-java/issues/2835)) ([b8f11b1](https://github.com/googleapis/sdk-platform-java/commit/b8f11b174bc384b9c7bc4c350d869493ba251c67))
* update dependency com.google.errorprone:error_prone_annotations to v2.28.0 ([#2838](https://github.com/googleapis/sdk-platform-java/issues/2838)) ([5c46f3f](https://github.com/googleapis/sdk-platform-java/commit/5c46f3f1ec1a2cdeaec85da91e87b8408c60e488))
* update dependency net.bytebuddy:byte-buddy to v1.14.16 ([#2797](https://github.com/googleapis/sdk-platform-java/issues/2797)) ([dfedafc](https://github.com/googleapis/sdk-platform-java/commit/dfedafc37ff31450663296f69cf91718a0a68557))
* update dependency net.bytebuddy:byte-buddy to v1.14.17 ([#2828](https://github.com/googleapis/sdk-platform-java/issues/2828)) ([6eb9041](https://github.com/googleapis/sdk-platform-java/commit/6eb90416f2d2bb36bf453f02c6cbf4f66c7adf59))
* update dependency org.checkerframework:checker-qual to v3.43.0 ([#2730](https://github.com/googleapis/sdk-platform-java/issues/2730)) ([b7fa736](https://github.com/googleapis/sdk-platform-java/commit/b7fa736327a1535c347aa516d00b2a41e2a8d143))
* update dependency requests to v2.32.0 [security] ([#2791](https://github.com/googleapis/sdk-platform-java/issues/2791)) ([c2ea6cc](https://github.com/googleapis/sdk-platform-java/commit/c2ea6ccf4f0e3b2547c030dbcc6bb003b70f8b9b))
* update dependency watchdog to v4.0.1 ([#2800](https://github.com/googleapis/sdk-platform-java/issues/2800)) ([d5771dd](https://github.com/googleapis/sdk-platform-java/commit/d5771dd4cdbc7a11a06eae6170cf85c0119d2443))
* update google api dependencies ([#2672](https://github.com/googleapis/sdk-platform-java/issues/2672)) ([6643536](https://github.com/googleapis/sdk-platform-java/commit/66435369822a32cb36cdb67cf4a897071f6ab844))
* update google http client dependencies to v1.44.2 ([#2783](https://github.com/googleapis/sdk-platform-java/issues/2783)) ([dee7e00](https://github.com/googleapis/sdk-platform-java/commit/dee7e00515b2eb7d5df31790f67150fa7de82f32))
* update googleapis/java-cloud-bom digest to 59c776b ([#2827](https://github.com/googleapis/sdk-platform-java/issues/2827)) ([03b3eb4](https://github.com/googleapis/sdk-platform-java/commit/03b3eb4dcc75f50f3097c4eeda8f2f62ebcc04ba))
* update netty dependencies to v4.1.110.final ([#2796](https://github.com/googleapis/sdk-platform-java/issues/2796)) ([d1aaa68](https://github.com/googleapis/sdk-platform-java/commit/d1aaa68fc8455f1b200bb152895aaa4a6849dafc))

## [2.40.1](https://github.com/googleapis/sdk-platform-java/compare/v2.40.0...v2.40.1) (2024-05-15)


### Bug Fixes

* [common-protos] An existing method `UpdateVehicleLocation` is ([7f96074](https://github.com/googleapis/sdk-platform-java/commit/7f96074859cd22289fe3ba464e8878d8b228e51c))
* [common-protos] An existing method `UpdateVehicleLocation` is removed from service `VehicleService` ([#2751](https://github.com/googleapis/sdk-platform-java/issues/2751)) ([7f96074](https://github.com/googleapis/sdk-platform-java/commit/7f96074859cd22289fe3ba464e8878d8b228e51c))
* [iam] An existing method `UpdateVehicleLocation` is removed from ([4a1ae7b](https://github.com/googleapis/sdk-platform-java/commit/4a1ae7b0b87a3dcc10834d7d2a1f0cd1975f0736))
* [iam] An existing method `UpdateVehicleLocation` is removed from service `VehicleService` ([#2752](https://github.com/googleapis/sdk-platform-java/issues/2752)) ([4a1ae7b](https://github.com/googleapis/sdk-platform-java/commit/4a1ae7b0b87a3dcc10834d7d2a1f0cd1975f0736))
* do not populate repo level change while removing library ([#2740](https://github.com/googleapis/sdk-platform-java/issues/2740)) ([43e62b9](https://github.com/googleapis/sdk-platform-java/commit/43e62b998958abd4ca96b83800380c9696ff693f))
* only append `.api.grpc` suffix to group id if the artifact id starts with `proto-` or `grpc-` ([#2731](https://github.com/googleapis/sdk-platform-java/issues/2731)) ([8e87b2e](https://github.com/googleapis/sdk-platform-java/commit/8e87b2e9a28a1797efb2eea531d25094b4438e0d))
* opentelemetry-bom to be in third-party-dependencies BOM ([#2736](https://github.com/googleapis/sdk-platform-java/issues/2736)) ([4ecc89b](https://github.com/googleapis/sdk-platform-java/commit/4ecc89bfff1a83e501b2fdc5a04bba47d83a7c00))
* prepare to generate grafeas ([#2761](https://github.com/googleapis/sdk-platform-java/issues/2761)) ([1114f18](https://github.com/googleapis/sdk-platform-java/commit/1114f1863bf5ae15ee56631fd824a2269e91746d))
* Replace deprecated protobuf methods. ([#2764](https://github.com/googleapis/sdk-platform-java/issues/2764)) ([986c090](https://github.com/googleapis/sdk-platform-java/commit/986c090a043f06ef98c9787cedf3c89cf7365017))


### Dependencies

* update dependency black to v24.4.2 ([#2660](https://github.com/googleapis/sdk-platform-java/issues/2660)) ([1cbb681](https://github.com/googleapis/sdk-platform-java/commit/1cbb681f3f395afee4be63cd6b96fefda7083d97))
* update dependency com.fasterxml.jackson:jackson-bom to v2.17.1 ([#2732](https://github.com/googleapis/sdk-platform-java/issues/2732)) ([891b01d](https://github.com/googleapis/sdk-platform-java/commit/891b01d0d35384df3269cdd8b37102b2587c9188))
* update dependency com.google.cloud:grpc-gcp to v1.6.0 ([#2767](https://github.com/googleapis/sdk-platform-java/issues/2767)) ([a39aa07](https://github.com/googleapis/sdk-platform-java/commit/a39aa07d013c9c097ad93fd68cf97da1c7d9ff03))
* update dependency com.google.errorprone:error_prone_annotations to v2.27.1 ([#2708](https://github.com/googleapis/sdk-platform-java/issues/2708)) ([4d7d246](https://github.com/googleapis/sdk-platform-java/commit/4d7d246e821797155792c5f1ad0c1704ec2766d4))
* update dependency com.google.errorprone:error_prone_annotations to v2.27.1 ([#2709](https://github.com/googleapis/sdk-platform-java/issues/2709)) ([4e31d7d](https://github.com/googleapis/sdk-platform-java/commit/4e31d7dd917c76229c3cfe18b0f98d561c9f7d3b))
* update dependency com.google.oauth-client:google-oauth-client-bom to v1.36.0 ([#2768](https://github.com/googleapis/sdk-platform-java/issues/2768)) ([22b7398](https://github.com/googleapis/sdk-platform-java/commit/22b7398f07a77935c0c002c78e8e30dca5979652))
* update dependency commons-codec:commons-codec to v1.17.0 ([#2710](https://github.com/googleapis/sdk-platform-java/issues/2710)) ([b87356c](https://github.com/googleapis/sdk-platform-java/commit/b87356c1d80559fd5ca85ee0edfa3e5f24db6b17))
* update dependency jinja2 to v3.1.4 [security] ([#2742](https://github.com/googleapis/sdk-platform-java/issues/2742)) ([d67eaf8](https://github.com/googleapis/sdk-platform-java/commit/d67eaf85c409dc7cf653dfb6d753d39a77292135))
* update dependency lxml to v5.2.2 ([#2766](https://github.com/googleapis/sdk-platform-java/issues/2766)) ([df7e211](https://github.com/googleapis/sdk-platform-java/commit/df7e211e534516f9596e230598b70fdbfdea1ac3))
* update dependency markupsafe to v2.1.5 ([#2657](https://github.com/googleapis/sdk-platform-java/issues/2657)) ([805baf8](https://github.com/googleapis/sdk-platform-java/commit/805baf87cfd70bb74b345cff93a6a6e02ade3dd7))
* update dependency net.bytebuddy:byte-buddy to v1.14.15 ([#2753](https://github.com/googleapis/sdk-platform-java/issues/2753)) ([a472620](https://github.com/googleapis/sdk-platform-java/commit/a4726206146a503822f685caa1e4d04273b738dc))
* update dependency platformdirs to v4.2.1 ([#2662](https://github.com/googleapis/sdk-platform-java/issues/2662)) ([dbdcc91](https://github.com/googleapis/sdk-platform-java/commit/dbdcc91e91ca19eca7c098b6131e3faa90f3386e))
* update googleapis/java-cloud-bom digest to db4265f ([#2755](https://github.com/googleapis/sdk-platform-java/issues/2755)) ([908db6f](https://github.com/googleapis/sdk-platform-java/commit/908db6f453b1915e2fd4097d5cf639f054829c39))
* update googleapis/java-cloud-bom digest to f3c611a ([#2700](https://github.com/googleapis/sdk-platform-java/issues/2700)) ([d254e9b](https://github.com/googleapis/sdk-platform-java/commit/d254e9bd67ec12802158d48f3c06dc618e0df903))
* update opentelemetry-java monorepo to v1.38.0 ([#2769](https://github.com/googleapis/sdk-platform-java/issues/2769)) ([0a5c7c4](https://github.com/googleapis/sdk-platform-java/commit/0a5c7c4075ee986028535c424e4a62458a25f8d2))

## [2.40.0](https://github.com/googleapis/sdk-platform-java/compare/v2.39.0...v2.40.0) (2024-05-02)


### Features

* [common-protos] add `Weight` to common types for Shopping APIs to be used for accounts bundle ([#2699](https://github.com/googleapis/sdk-platform-java/issues/2699)) ([5bb9770](https://github.com/googleapis/sdk-platform-java/commit/5bb97700ddcef1b0494808b1e7d8029d92c74d13))
* add a CLI tool to validate generation configuration  ([#2691](https://github.com/googleapis/sdk-platform-java/issues/2691)) ([f2ce524](https://github.com/googleapis/sdk-platform-java/commit/f2ce52478a03048b9daffc3fc535f12cf2a9f856))
* Parser to consume the api-versioning value from proto ([#2630](https://github.com/googleapis/sdk-platform-java/issues/2630)) ([40711fd](https://github.com/googleapis/sdk-platform-java/commit/40711fd69468a2021108bb5fba00bb02ac4bb19f))
* Update Gapic generator and Gax to emit api-versioning via header ([#2671](https://github.com/googleapis/sdk-platform-java/issues/2671)) ([e63d1b4](https://github.com/googleapis/sdk-platform-java/commit/e63d1b49159be07f0bb32bfe9d15c8445ac883c8))


### Bug Fixes

* change folder prefix for adding headers ([#2688](https://github.com/googleapis/sdk-platform-java/issues/2688)) ([4e92be8](https://github.com/googleapis/sdk-platform-java/commit/4e92be8885af8633ea5b3371c43be9423a0f95ef))
* Log HttpJson's async thread pool core size ([#2697](https://github.com/googleapis/sdk-platform-java/issues/2697)) ([34b4bc3](https://github.com/googleapis/sdk-platform-java/commit/34b4bc3362f3c30bd77f5a59c3cb3aea36358eee))
* replace `cfg = "host"` with `cfg = "exec"` ([#2637](https://github.com/googleapis/sdk-platform-java/issues/2637)) ([6d673f3](https://github.com/googleapis/sdk-platform-java/commit/6d673f39dc10b072ba6012fecc17deb22136650e))
* Return resolved endpoint from StubSettings' Builder ([#2715](https://github.com/googleapis/sdk-platform-java/issues/2715)) ([32c9995](https://github.com/googleapis/sdk-platform-java/commit/32c99953496fe3e0ab47c67aad4117c242d1c798))


### Dependencies

* Make opentelemetry-api an optional dependency. ([#2681](https://github.com/googleapis/sdk-platform-java/issues/2681)) ([3967a19](https://github.com/googleapis/sdk-platform-java/commit/3967a19e8b68c3a95cf1ced737f3a1aa73b02e93))
* update dependency absl-py to v2.1.0 ([#2659](https://github.com/googleapis/sdk-platform-java/issues/2659)) ([cae6d79](https://github.com/googleapis/sdk-platform-java/commit/cae6d79ed29fd9e64abe4e9390a46b1f9f1d305f))
* update dependency gitpython to v3.1.43 ([#2656](https://github.com/googleapis/sdk-platform-java/issues/2656)) ([208bef4](https://github.com/googleapis/sdk-platform-java/commit/208bef468b11d49e85d4df4008d99c7a2de9233c))
* update dependency lxml to v5.2.1 ([#2661](https://github.com/googleapis/sdk-platform-java/issues/2661)) ([b95ad49](https://github.com/googleapis/sdk-platform-java/commit/b95ad49834e0422e79f884b42cf5c81c89bb25fb))
* update dependency net.bytebuddy:byte-buddy to v1.14.14 ([#2703](https://github.com/googleapis/sdk-platform-java/issues/2703)) ([87069bc](https://github.com/googleapis/sdk-platform-java/commit/87069bc9618704e2607aeae486d8481e4454dc17))
* update dependency typing to v3.10.0.0 ([#2663](https://github.com/googleapis/sdk-platform-java/issues/2663)) ([7fb5653](https://github.com/googleapis/sdk-platform-java/commit/7fb565324427a98948c6d253066b734a4b5832bc))
* update gapic-showcase to v0.33.0 ([#2653](https://github.com/googleapis/sdk-platform-java/issues/2653)) ([0a71cbf](https://github.com/googleapis/sdk-platform-java/commit/0a71cbf7092279c50f9f5114b79d8c674cdef997))


### Documentation

* Add contributing guidelines to PR and issue templates ([#2682](https://github.com/googleapis/sdk-platform-java/issues/2682)) ([42526dc](https://github.com/googleapis/sdk-platform-java/commit/42526dc03e00a2e01e8f7a075817560089f378ee))

## [2.39.0](https://github.com/googleapis/sdk-platform-java/compare/v2.38.1...v2.39.0) (2024-04-18)


### Features

* add `libraries_bom_version` to generation configuration  ([#2639](https://github.com/googleapis/sdk-platform-java/issues/2639)) ([56c7ca5](https://github.com/googleapis/sdk-platform-java/commit/56c7ca51d4ca99629251e0aa9cac316eb349c974))
* Add ChannelPoolSettings Getter for gRPC's ChannelProvider ([#2612](https://github.com/googleapis/sdk-platform-java/issues/2612)) ([d0c5191](https://github.com/googleapis/sdk-platform-java/commit/d0c5191525d5d157812cae9551fc15bb70caab7e))
* add config change ([#2604](https://github.com/googleapis/sdk-platform-java/issues/2604)) ([8312706](https://github.com/googleapis/sdk-platform-java/commit/8312706db6352fca05a5858b513e88f162e5de0b))
* add entry point ([#2616](https://github.com/googleapis/sdk-platform-java/issues/2616)) ([b19fa33](https://github.com/googleapis/sdk-platform-java/commit/b19fa3373d3fa17531d627d4581d154374a231ff))
* add generation config comparator ([#2587](https://github.com/googleapis/sdk-platform-java/issues/2587)) ([a94c2f0](https://github.com/googleapis/sdk-platform-java/commit/a94c2f0e8a99f0ddf17106cbc8117cefe6b0e127))
* Add JavadocJar Task to build.gradle for self service libraries ([#2593](https://github.com/googleapis/sdk-platform-java/issues/2593)) ([993f5ac](https://github.com/googleapis/sdk-platform-java/commit/993f5acf91de3a9d2c7f9fdb10ea47387b240554))
* Client/StubSettings' getEndpoint() returns the resolved endpoint ([#2440](https://github.com/googleapis/sdk-platform-java/issues/2440)) ([4942bc1](https://github.com/googleapis/sdk-platform-java/commit/4942bc17e9c7261242ba3d03d85cd8b131ca2e5e))
* generate selected libraries ([#2598](https://github.com/googleapis/sdk-platform-java/issues/2598)) ([739ddbb](https://github.com/googleapis/sdk-platform-java/commit/739ddbbbc662f43e46b9f420bbae685de9b3dbc6))
* Validate the Universe Domain inside Java-Core ([#2592](https://github.com/googleapis/sdk-platform-java/issues/2592)) ([35d789f](https://github.com/googleapis/sdk-platform-java/commit/35d789fdf488feff41d4bdaa5992013450954870))


### Bug Fixes

* add main to `generate_repo.py` ([#2607](https://github.com/googleapis/sdk-platform-java/issues/2607)) ([fedeb32](https://github.com/googleapis/sdk-platform-java/commit/fedeb3237b6d25245f4d770ec105bd538dfee405))
* correct deep-remove and deep-preserve regexes ([#2572](https://github.com/googleapis/sdk-platform-java/issues/2572)) ([4c7fd88](https://github.com/googleapis/sdk-platform-java/commit/4c7fd880a90d08448db366bde40d0d385b45f75e))
* first attempt should use the min of RPC timeout and total timeout ([#2641](https://github.com/googleapis/sdk-platform-java/issues/2641)) ([0349232](https://github.com/googleapis/sdk-platform-java/commit/034923277750171418d74060e225ffd68ef38bf2))
* remove duplicated calls to AutoValue builders ([#2636](https://github.com/googleapis/sdk-platform-java/issues/2636)) ([53a3727](https://github.com/googleapis/sdk-platform-java/commit/53a3727e4a9548bf0417d4ee6ed3e9ab571642ed))
* remove unnecessary slf4j and AbstractGoogleClientRequest native image configs ([0cb7d0e](https://github.com/googleapis/sdk-platform-java/commit/0cb7d0e0c03f2dd2853a86d67c9529a50ed8238f))
* remove unnecessary slf4j and AbstractGoogleClientRequest native image configs ([#2628](https://github.com/googleapis/sdk-platform-java/issues/2628)) ([0cb7d0e](https://github.com/googleapis/sdk-platform-java/commit/0cb7d0e0c03f2dd2853a86d67c9529a50ed8238f))


### Dependencies

* update arrow.version to v15.0.2 ([#2589](https://github.com/googleapis/sdk-platform-java/issues/2589)) ([777acf3](https://github.com/googleapis/sdk-platform-java/commit/777acf3df4b5379cd8a8cf52b844203dd514ee24))
* update dependency com.google.cloud.opentelemetry:detector-resources-support to v0.28.0 ([#2649](https://github.com/googleapis/sdk-platform-java/issues/2649)) ([e4ed176](https://github.com/googleapis/sdk-platform-java/commit/e4ed1765f3dbb950d498df307d79577abf71a66a))
* update dependency gitpython to v3.1.41 [security] ([#2625](https://github.com/googleapis/sdk-platform-java/issues/2625)) ([e41bd8f](https://github.com/googleapis/sdk-platform-java/commit/e41bd8f00ffcb271b2a008364f334693d9dfdc9d))
* update dependency net.bytebuddy:byte-buddy to v1.14.13 ([#2646](https://github.com/googleapis/sdk-platform-java/issues/2646)) ([73ac5a4](https://github.com/googleapis/sdk-platform-java/commit/73ac5a4bfe05ac11a121664f52a4013cb4bb33a9))
* update dependency org.threeten:threeten-extra to v1.8.0 ([#2650](https://github.com/googleapis/sdk-platform-java/issues/2650)) ([226325a](https://github.com/googleapis/sdk-platform-java/commit/226325a5b7c93c1ad1b4af5da4283e369887fa42))
* update dependency org.threeten:threetenbp to v1.6.9 ([#2602](https://github.com/googleapis/sdk-platform-java/issues/2602)) ([371753e](https://github.com/googleapis/sdk-platform-java/commit/371753ebbd83d703f314dd5f4e34e16c255836c6))
* update dependency org.threeten:threetenbp to v1.6.9 ([#2665](https://github.com/googleapis/sdk-platform-java/issues/2665)) ([8935bc8](https://github.com/googleapis/sdk-platform-java/commit/8935bc87307e73101df72a85f98a8ec1bdde0c14))
* update google api dependencies ([#2584](https://github.com/googleapis/sdk-platform-java/issues/2584)) ([cd20604](https://github.com/googleapis/sdk-platform-java/commit/cd20604f3128d2efc1802065c63b6663186ce3af))
* update googleapis/java-cloud-bom digest to 7071341 ([#2608](https://github.com/googleapis/sdk-platform-java/issues/2608)) ([8d74140](https://github.com/googleapis/sdk-platform-java/commit/8d7414029984c073e9bae2952971d2337dbf81ab))
* update netty dependencies to v4.1.109.final ([#2597](https://github.com/googleapis/sdk-platform-java/issues/2597)) ([8990693](https://github.com/googleapis/sdk-platform-java/commit/8990693abf157a1adf2723c6db1bce71a5efa810))
* update opentelemetry-java monorepo to v1.37.0 ([#2652](https://github.com/googleapis/sdk-platform-java/issues/2652)) ([f8fa2e9](https://github.com/googleapis/sdk-platform-java/commit/f8fa2e9f7316f17f1e753a74a6839d9e331c010a))
* update protobuf dependencies to v3.25.3 ([#2491](https://github.com/googleapis/sdk-platform-java/issues/2491)) ([b0e5041](https://github.com/googleapis/sdk-platform-java/commit/b0e5041ff0fafaf900a7cf1929f0d85fc582a0d7))
* update slf4j monorepo to v2.0.13 ([#2647](https://github.com/googleapis/sdk-platform-java/issues/2647)) ([f030e29](https://github.com/googleapis/sdk-platform-java/commit/f030e29b1538ad28ad9628ec03d8e3eb2f21d6c2))

## [2.38.1](https://github.com/googleapis/sdk-platform-java/compare/v2.38.0...v2.38.1) (2024-03-15)


### Bug Fixes

* **deps:** add detector-resource-support dependencies ([#2559](https://github.com/googleapis/sdk-platform-java/issues/2559)) ([53f2c85](https://github.com/googleapis/sdk-platform-java/commit/53f2c85ff700e114ca88ab74360733144581b861))
* Update shopping and chat common protos. ([#2580](https://github.com/googleapis/sdk-platform-java/issues/2580)) ([f472756](https://github.com/googleapis/sdk-platform-java/commit/f472756590215308305bbb370097e300439f168b))


### Dependencies

* update google api dependencies ([#2582](https://github.com/googleapis/sdk-platform-java/issues/2582)) ([dd03d93](https://github.com/googleapis/sdk-platform-java/commit/dd03d9378c6efbaf7a0785f235461cc5951c50d2))

## [2.38.0](https://github.com/googleapis/sdk-platform-java/compare/v2.37.0...v2.38.0) (2024-03-15)


### Features

* [common-protos] add `api_version` extension to `ServiceOptions`, for collaborative versioning ([d343be9](https://github.com/googleapis/sdk-platform-java/commit/d343be9416d2521145a8c5d1e8abea6203ff6214))
* [common-protos] add `api_version` extension to `ServiceOptions`, for collaborative versioning ([#2551](https://github.com/googleapis/sdk-platform-java/issues/2551)) ([d343be9](https://github.com/googleapis/sdk-platform-java/commit/d343be9416d2521145a8c5d1e8abea6203ff6214))
* add `ErrorReason.LOCATION_POLICY_VIOLATED` enum value ([d343be9](https://github.com/googleapis/sdk-platform-java/commit/d343be9416d2521145a8c5d1e8abea6203ff6214))
* add `ErrorReason.LOCATION_POLICY_VIOLATED` enum value ([d343be9](https://github.com/googleapis/sdk-platform-java/commit/d343be9416d2521145a8c5d1e8abea6203ff6214))
* add `Publishing.rest_reference_documentation_uri` to aid client library publication ([d343be9](https://github.com/googleapis/sdk-platform-java/commit/d343be9416d2521145a8c5d1e8abea6203ff6214))
* add `Publishing.rest_reference_documentation_uri` to aid client library publication ([d343be9](https://github.com/googleapis/sdk-platform-java/commit/d343be9416d2521145a8c5d1e8abea6203ff6214))
* Add shopping and chat common protos. ([#2553](https://github.com/googleapis/sdk-platform-java/issues/2553)) ([5f2d4e7](https://github.com/googleapis/sdk-platform-java/commit/5f2d4e73ec5511613a97f463e28567487f47cd44)), closes [#2018](https://github.com/googleapis/sdk-platform-java/issues/2018)
* get PR description from googleapis commits ([#2531](https://github.com/googleapis/sdk-platform-java/issues/2531)) ([c2ea697](https://github.com/googleapis/sdk-platform-java/commit/c2ea697fdfd9127a203524424e93e1d32ae2b8fa))
* Introduce OpenTelemetry Metrics Recording ([#2500](https://github.com/googleapis/sdk-platform-java/issues/2500)) ([b936580](https://github.com/googleapis/sdk-platform-java/commit/b936580e905716a7fdf78d9219eb55889ee9274e))
* skip build only commit ([#2555](https://github.com/googleapis/sdk-platform-java/issues/2555)) ([180c8a9](https://github.com/googleapis/sdk-platform-java/commit/180c8a964893b3dc8e40c51adc4d76e570a87e04))
* Universe Domain Environment Variable Support ([#2485](https://github.com/googleapis/sdk-platform-java/issues/2485)) ([1463d64](https://github.com/googleapis/sdk-platform-java/commit/1463d645edf96087335618542f7bbca722a97b71))


### Dependencies

* normalize dependencies ([#2574](https://github.com/googleapis/sdk-platform-java/issues/2574)) ([6622238](https://github.com/googleapis/sdk-platform-java/commit/66222380977e7cba3a7951fba6102481af130d2e))
* update arrow.version to v15.0.1 ([#2565](https://github.com/googleapis/sdk-platform-java/issues/2565)) ([b2c3f6a](https://github.com/googleapis/sdk-platform-java/commit/b2c3f6a0bb6bd33063516060851ebbae628c8fed))
* update dependency com.fasterxml.jackson:jackson-bom to v2.17.0 ([#2564](https://github.com/googleapis/sdk-platform-java/issues/2564)) ([40ae7f9](https://github.com/googleapis/sdk-platform-java/commit/40ae7f9a628ec7b34b5b001ffc54d49e4059dd81))
* update dependency com.google.api-client:google-api-client-bom to v2.4.0 ([#2570](https://github.com/googleapis/sdk-platform-java/issues/2570)) ([f60441f](https://github.com/googleapis/sdk-platform-java/commit/f60441ff4c1fb530ac27a8c492cd1b45196ea13c))
* update dependency com.google.errorprone:error_prone_annotations to v2.26.1 ([#2530](https://github.com/googleapis/sdk-platform-java/issues/2530)) ([7c1aaab](https://github.com/googleapis/sdk-platform-java/commit/7c1aaabb0ef5f3664b6065b89ca74a1075ab74c7))
* update dependency com.google.errorprone:error_prone_annotations to v2.26.1 ([#2532](https://github.com/googleapis/sdk-platform-java/issues/2532)) ([447b4e1](https://github.com/googleapis/sdk-platform-java/commit/447b4e1d8a9079506bde78ab7ec0831a90e19b82))
* update dependency io.netty:netty-tcnative-boringssl-static to v2.0.65.final ([#2547](https://github.com/googleapis/sdk-platform-java/issues/2547)) ([46e0e0f](https://github.com/googleapis/sdk-platform-java/commit/46e0e0f1d5b0f9d70a9d5cff67a692e802f8992a))
* update dependency net.bytebuddy:byte-buddy to v1.14.12 ([#2522](https://github.com/googleapis/sdk-platform-java/issues/2522)) ([edfec32](https://github.com/googleapis/sdk-platform-java/commit/edfec3232c99591093a8d9f9a9ff43edeb9878e9))
* update google api dependencies ([#2484](https://github.com/googleapis/sdk-platform-java/issues/2484)) ([92e91bc](https://github.com/googleapis/sdk-platform-java/commit/92e91bc0d91a2619a87abf9b072229a3ab3f4d91))
* update google api dependencies ([#2538](https://github.com/googleapis/sdk-platform-java/issues/2538)) ([d9355cf](https://github.com/googleapis/sdk-platform-java/commit/d9355cf5e6751de8bb8a7ff7e101b7f52425e19a))
* update googleapis/java-cloud-bom digest to 3f93d58 ([#2499](https://github.com/googleapis/sdk-platform-java/issues/2499)) ([5fd4d5e](https://github.com/googleapis/sdk-platform-java/commit/5fd4d5e3a9f864064587eec4d11b14b3c037efcf))
* update googleapis/java-cloud-bom digest to 659764f ([#2545](https://github.com/googleapis/sdk-platform-java/issues/2545)) ([d6c8be6](https://github.com/googleapis/sdk-platform-java/commit/d6c8be6e7da262ecc1ac61fbc052af24c59d94ef))
* update netty dependencies ([#2480](https://github.com/googleapis/sdk-platform-java/issues/2480)) ([40753c3](https://github.com/googleapis/sdk-platform-java/commit/40753c3ca3d0d3d6e83bfd38764071a57c9e7c8b))
* update opentelemetry-java monorepo to v1.35.0 ([#2477](https://github.com/googleapis/sdk-platform-java/issues/2477)) ([3ecefff](https://github.com/googleapis/sdk-platform-java/commit/3ecefff9f1e458119db24da729094b5a1ca22279))
* update opentelemetry-java monorepo to v1.36.0 ([#2550](https://github.com/googleapis/sdk-platform-java/issues/2550)) ([9669c21](https://github.com/googleapis/sdk-platform-java/commit/9669c21d4e01017b4aa65abc0fb1e80de31ff0c6))
* update opentelemetry-java monorepo to v1.36.0 ([#2573](https://github.com/googleapis/sdk-platform-java/issues/2573)) ([f5f201e](https://github.com/googleapis/sdk-platform-java/commit/f5f201e9846c46f6e7241a15674d28711fe984f4))
* update slf4j monorepo to v2.0.12 ([#2481](https://github.com/googleapis/sdk-platform-java/issues/2481)) ([363a354](https://github.com/googleapis/sdk-platform-java/commit/363a3549b2bda040e55ec59ef21010b6c99a021e))


### Documentation

* minor tweaks to various comments ([d343be9](https://github.com/googleapis/sdk-platform-java/commit/d343be9416d2521145a8c5d1e8abea6203ff6214))
* minor tweaks to various comments ([d343be9](https://github.com/googleapis/sdk-platform-java/commit/d343be9416d2521145a8c5d1e8abea6203ff6214))

## [2.37.0](https://github.com/googleapis/sdk-platform-java/compare/v2.36.0...v2.37.0) (2024-02-29)


### Features

* improve batching summary errors ([#2509](https://github.com/googleapis/sdk-platform-java/issues/2509)) ([d6964a4](https://github.com/googleapis/sdk-platform-java/commit/d6964a4cfda60ef7c5f1871b215a9cf222361e7e))


### Bug Fixes

* adjust release please config to reflect file location change. ([#2524](https://github.com/googleapis/sdk-platform-java/issues/2524)) ([1e5af1e](https://github.com/googleapis/sdk-platform-java/commit/1e5af1e651a079220b8a63952b7dbc68586d9b7d))

## [2.36.0](https://github.com/googleapis/sdk-platform-java/compare/v2.35.0...v2.36.0) (2024-02-29)


### Features

* check library_name is unique among libraries ([#2490](https://github.com/googleapis/sdk-platform-java/issues/2490)) ([8123f0b](https://github.com/googleapis/sdk-platform-java/commit/8123f0b15970c76b08086d8988de14e1ed58a77e))


### Bug Fixes

* cleanup @BetaApi from Resource Name Builder Methods  ([#2450](https://github.com/googleapis/sdk-platform-java/issues/2450)) ([6e8d098](https://github.com/googleapis/sdk-platform-java/commit/6e8d09845610401665556118cd78c7229c46d426)), closes [#2099](https://github.com/googleapis/sdk-platform-java/issues/2099)
* Fix watchdog to start with WAITING state ([#2468](https://github.com/googleapis/sdk-platform-java/issues/2468)) ([dedc40f](https://github.com/googleapis/sdk-platform-java/commit/dedc40fb451633b11be10013b74a91053e155620))
* ignore comment in BUILD ([#2492](https://github.com/googleapis/sdk-platform-java/issues/2492)) ([6ca20e5](https://github.com/googleapis/sdk-platform-java/commit/6ca20e529a86561cdc935d0d44dd971de3b9e4b2))
* remove @BetaApi from ApiFutures and ApiService ([#2454](https://github.com/googleapis/sdk-platform-java/issues/2454)) ([f59e717](https://github.com/googleapis/sdk-platform-java/commit/f59e717402d00bc953648e1e780dd84dda7915b3)), closes [#2098](https://github.com/googleapis/sdk-platform-java/issues/2098)


### Dependencies

* grandfathering the dependencies for java-pubsublite and java-bigquery ([#2504](https://github.com/googleapis/sdk-platform-java/issues/2504)) ([9ceab23](https://github.com/googleapis/sdk-platform-java/commit/9ceab23144ba7a9ca9114d585376e09587fd1bee))
* update dependency gradle to v7.6.4 ([#2474](https://github.com/googleapis/sdk-platform-java/issues/2474)) ([607dc59](https://github.com/googleapis/sdk-platform-java/commit/607dc59f8eb5a70f8807c4d5f7d0745438842381))
* update dependency org.graalvm.sdk:graal-sdk to v22.3.5 ([#2475](https://github.com/googleapis/sdk-platform-java/issues/2475)) ([2de487b](https://github.com/googleapis/sdk-platform-java/commit/2de487b34c43fee3b81e4af7a2dfe4f2eb6418ac))
* update grpc dependencies to v1.62.2 ([#2506](https://github.com/googleapis/sdk-platform-java/issues/2506)) ([f438603](https://github.com/googleapis/sdk-platform-java/commit/f4386038766c2381e141d7073959cc6bde896efb))


### Documentation

* Add contribution guidelines. ([#2045](https://github.com/googleapis/sdk-platform-java/issues/2045)) ([9939b43](https://github.com/googleapis/sdk-platform-java/commit/9939b43dce041c75405cea66a0dde171d991d3eb))

## [2.35.0](https://github.com/googleapis/sdk-platform-java/compare/v2.34.0...v2.35.0) (2024-02-13)


### Features

* add `generate_repo.py` ([#2431](https://github.com/googleapis/sdk-platform-java/issues/2431)) ([47b632a](https://github.com/googleapis/sdk-platform-java/commit/47b632aa011874abe04212168ccc74dae50f5fbe))
* move synthtool templates to `library_generation/owlbot` ([#2443](https://github.com/googleapis/sdk-platform-java/issues/2443)) ([5c95472](https://github.com/googleapis/sdk-platform-java/commit/5c95472ffd9085a6eac3d227f96c0b25097c60ec))


### Bug Fixes

* Apiary Host returns user set host if set ([#2455](https://github.com/googleapis/sdk-platform-java/issues/2455)) ([5f17e62](https://github.com/googleapis/sdk-platform-java/commit/5f17e62a7b0f10035205ec4197b8f77388b059f8))
* Cancel the Timeout Task for HttpJson ([#2360](https://github.com/googleapis/sdk-platform-java/issues/2360)) ([b177d9e](https://github.com/googleapis/sdk-platform-java/commit/b177d9e40fd7107bbed67506da0acb021c8f346d))


### Dependencies

* update dependency commons-codec:commons-codec to v1.16.1 ([#2473](https://github.com/googleapis/sdk-platform-java/issues/2473)) ([8c6e91d](https://github.com/googleapis/sdk-platform-java/commit/8c6e91df765b4e42d0d4de77eaf73936fa43895a))
* update google api dependencies ([#2469](https://github.com/googleapis/sdk-platform-java/issues/2469)) ([ad4d4e6](https://github.com/googleapis/sdk-platform-java/commit/ad4d4e65c0afae0e13905fe78b8ea711253dcab3))
* update google auth library dependencies to v1.23.0 ([#2466](https://github.com/googleapis/sdk-platform-java/issues/2466)) ([349a5d3](https://github.com/googleapis/sdk-platform-java/commit/349a5d3b6e31e6184f71d3470a406b2e78eb0775))
* update google auth library dependencies to v1.23.0 ([#2476](https://github.com/googleapis/sdk-platform-java/issues/2476)) ([6c9127c](https://github.com/googleapis/sdk-platform-java/commit/6c9127cf177ed1965ac2d7823808c9f4a835a44f))
* update google http client dependencies to v1.44.1 ([#2467](https://github.com/googleapis/sdk-platform-java/issues/2467)) ([87d1435](https://github.com/googleapis/sdk-platform-java/commit/87d143569e3e2fee5050a905b1841995fc20c528))
* update googleapis/java-cloud-bom digest to ac9893c ([#2472](https://github.com/googleapis/sdk-platform-java/issues/2472)) ([7fff34a](https://github.com/googleapis/sdk-platform-java/commit/7fff34ab3a8e6e0a77b638be81d67fcb4f061686))
* update grpc dependencies to v1.61.1 ([#2463](https://github.com/googleapis/sdk-platform-java/issues/2463)) ([9ec575b](https://github.com/googleapis/sdk-platform-java/commit/9ec575bae059a96ed3d68af4abc372031d9c4dc7))

## [2.34.0](https://github.com/googleapis/sdk-platform-java/compare/v2.33.0...v2.34.0) (2024-01-31)


### Features

* autopopulate fields in the request ([#2353](https://github.com/googleapis/sdk-platform-java/issues/2353)) ([b28235a](https://github.com/googleapis/sdk-platform-java/commit/b28235ab20fd174deddafc0426b8d20352af6e85))
* enable generation with postprocessing of multiple service versions ([#2342](https://github.com/googleapis/sdk-platform-java/issues/2342)) ([363e35e](https://github.com/googleapis/sdk-platform-java/commit/363e35e46e41c88b810e4b0672906f73cb7c38b6))
* MetricsTracer implementation ([#2421](https://github.com/googleapis/sdk-platform-java/issues/2421)) ([5c291e8](https://github.com/googleapis/sdk-platform-java/commit/5c291e8786b8e976979ec2e26b13f0327333bb02))
* move new client script ([#2333](https://github.com/googleapis/sdk-platform-java/issues/2333)) ([acdde47](https://github.com/googleapis/sdk-platform-java/commit/acdde47445916dd306ce8b91489fab45c9c2ef50))


### Bug Fixes

* Endpoint resolution uses user set endpoint from ClientSettings ([#2429](https://github.com/googleapis/sdk-platform-java/issues/2429)) ([46b0a85](https://github.com/googleapis/sdk-platform-java/commit/46b0a857eaa4484c5f1ebe1170338fc90a994375))
* Move direct path misconfiguration log to before creating the first channel ([#2430](https://github.com/googleapis/sdk-platform-java/issues/2430)) ([9916540](https://github.com/googleapis/sdk-platform-java/commit/99165403902ff91ecb0b14b858333855e7a10c60))

## [2.33.0](https://github.com/googleapis/sdk-platform-java/compare/v2.32.0...v2.33.0) (2024-01-24)


### Features

* Introduce interfaces for metrics instrumentation ([#2403](https://github.com/googleapis/sdk-platform-java/issues/2403)) ([3c61b14](https://github.com/googleapis/sdk-platform-java/commit/3c61b14fef87c735ea2ed382f8510b29176a4279))


### Bug Fixes

* Verify Universe Domain's DirectPath Compatibility after Endpoint Resolution ([#2412](https://github.com/googleapis/sdk-platform-java/issues/2412)) ([e2de93b](https://github.com/googleapis/sdk-platform-java/commit/e2de93bb7051039e8a96128b9eacc0f2ea3a1205))

## [2.32.0](https://github.com/googleapis/sdk-platform-java/compare/v2.31.0...v2.32.0) (2024-01-19)


### Features

* Do not set the default endpoint in StubSettings ([97ae228](https://github.com/googleapis/sdk-platform-java/commit/97ae228a262738e09ddf7b4dab95bb81a4f8860a))
* Numeric enums in routing headers ([#2328](https://github.com/googleapis/sdk-platform-java/issues/2328)) ([4d043de](https://github.com/googleapis/sdk-platform-java/commit/4d043deeaf096a093e54c5c7b07e408f38647296))
* StubSettings' `getEndpoint()` will return the service's pre-configured endpoint if there are no user configurations ([97ae228](https://github.com/googleapis/sdk-platform-java/commit/97ae228a262738e09ddf7b4dab95bb81a4f8860a))
* Validate the Universe Domain ([#2330](https://github.com/googleapis/sdk-platform-java/issues/2330)) ([097bc93](https://github.com/googleapis/sdk-platform-java/commit/097bc93c39d10d8ff08eb8fb3a378bbe6d96c1ac))


### Bug Fixes

* adjust release-please configs for cloudbuild yaml updates ([#2351](https://github.com/googleapis/sdk-platform-java/issues/2351)) ([ed16261](https://github.com/googleapis/sdk-platform-java/commit/ed16261ac8c90fe588026e30d62d948e7ca1af13))
* DirectPath non-default SA requires creds ([#2281](https://github.com/googleapis/sdk-platform-java/issues/2281)) ([c7d614a](https://github.com/googleapis/sdk-platform-java/commit/c7d614acd9be75b0aa3d365eed9ef4db41419906))
* format method types and table in Client Overview ([#2361](https://github.com/googleapis/sdk-platform-java/issues/2361)) ([7436995](https://github.com/googleapis/sdk-platform-java/commit/743699504039c110a1490276ddef809f57716e24))


### Dependencies

* update dependency com.fasterxml.jackson:jackson-bom to v2.16.1 ([#2386](https://github.com/googleapis/sdk-platform-java/issues/2386)) ([1160f95](https://github.com/googleapis/sdk-platform-java/commit/1160f95d16b1dd0627772a9e8f9c7c8cae7e9c55))
* update dependency com.google.errorprone:error_prone_annotations to v2.24.1 ([#2390](https://github.com/googleapis/sdk-platform-java/issues/2390)) ([d533760](https://github.com/googleapis/sdk-platform-java/commit/d5337600d95f226bbb3f328ebdb7eb41cd2cb43a))
* update dependency com.google.errorprone:error_prone_annotations to v2.24.1 ([#2391](https://github.com/googleapis/sdk-platform-java/issues/2391)) ([98b7f3e](https://github.com/googleapis/sdk-platform-java/commit/98b7f3ebcb46430fda53d0d656fcc090ed73654e))
* update dependency com.google.oauth-client:google-oauth-client-bom to v1.35.0 ([#2392](https://github.com/googleapis/sdk-platform-java/issues/2392)) ([4b78ac7](https://github.com/googleapis/sdk-platform-java/commit/4b78ac7a8e7a8e6844516c30ac8b112a44cfcc9c))
* update dependency io.perfmark:perfmark-api to v0.27.0 ([#2388](https://github.com/googleapis/sdk-platform-java/issues/2388)) ([42808ba](https://github.com/googleapis/sdk-platform-java/commit/42808baab2f949bfda2abdb109560033f9e34da3))
* update dependency io.perfmark:perfmark-api to v0.27.0 ([#2389](https://github.com/googleapis/sdk-platform-java/issues/2389)) ([51241f7](https://github.com/googleapis/sdk-platform-java/commit/51241f77bc71769c482d12c47cf82c2f32d0be30))
* update dependency net.bytebuddy:byte-buddy to v1.14.11 ([#2387](https://github.com/googleapis/sdk-platform-java/issues/2387)) ([07b8ee6](https://github.com/googleapis/sdk-platform-java/commit/07b8ee6d93c42299617de768946ba48e2049dbf9))
* update dependency org.checkerframework:checker-qual to v3.42.0 ([#2287](https://github.com/googleapis/sdk-platform-java/issues/2287)) ([7c4eb80](https://github.com/googleapis/sdk-platform-java/commit/7c4eb80c2faf1b2d9e0a1bc10acffe4a8d2d7d28))
* update gapic-showcase to v0.30.0 ([#2354](https://github.com/googleapis/sdk-platform-java/issues/2354)) ([762c125](https://github.com/googleapis/sdk-platform-java/commit/762c125abadb5e56682224c9f1587c71e5c6e653))
* update google api dependencies ([#2382](https://github.com/googleapis/sdk-platform-java/issues/2382)) ([92bbe61](https://github.com/googleapis/sdk-platform-java/commit/92bbe6123090a9c66a0d6a688484612a069fd9de))
* update googleapis/java-cloud-bom digest to 8bc17e9 ([#2376](https://github.com/googleapis/sdk-platform-java/issues/2376)) ([bddd4ea](https://github.com/googleapis/sdk-platform-java/commit/bddd4ea81c0ce2d53c7968fbe55eb0755a3dfee8))
* update grpc dependencies to v1.61.0 ([#2383](https://github.com/googleapis/sdk-platform-java/issues/2383)) ([af15bd1](https://github.com/googleapis/sdk-platform-java/commit/af15bd1ef06456fea983a8e44b3dc78d30751125))
* update netty dependencies to v4.1.105.final ([#2302](https://github.com/googleapis/sdk-platform-java/issues/2302)) ([1563a55](https://github.com/googleapis/sdk-platform-java/commit/1563a550f820063881c1e1ab87aa79fb47ca667c))
* update protobuf dependencies to v3.25.2 ([#2378](https://github.com/googleapis/sdk-platform-java/issues/2378)) ([836e7b8](https://github.com/googleapis/sdk-platform-java/commit/836e7b86eecf61552f203e26dff04359ed27bde2))
* update slf4j monorepo to v2.0.11 ([#2381](https://github.com/googleapis/sdk-platform-java/issues/2381)) ([9e758b7](https://github.com/googleapis/sdk-platform-java/commit/9e758b792615c0bc4d784e8c33d4f90fcc1566ee))

## [2.31.0](https://github.com/googleapis/sdk-platform-java/compare/v2.30.0...v2.31.0) (2024-01-04)


### Features

* [common-protos,common-protos] add auto_populated_fields to google.api.MethodSettings ([#2273](https://github.com/googleapis/sdk-platform-java/issues/2273)) ([d9be11c](https://github.com/googleapis/sdk-platform-java/commit/d9be11c7a127452c5e5ef871854a4a65c68b1b34))
* add auto_populated_fields to google.api.MethodSettings ([d9be11c](https://github.com/googleapis/sdk-platform-java/commit/d9be11c7a127452c5e5ef871854a4a65c68b1b34))
* add parsing of autopopulated fields from serviceyaml ([#2312](https://github.com/googleapis/sdk-platform-java/issues/2312)) ([4f535a7](https://github.com/googleapis/sdk-platform-java/commit/4f535a7829f98fe79053e62e22deaf91a97ab917))
* Add Universe Domain to ClientSettings ([#2331](https://github.com/googleapis/sdk-platform-java/issues/2331)) ([1bddac5](https://github.com/googleapis/sdk-platform-java/commit/1bddac5f91b5b7742c6082da2ae0c6667523aaa4))
* Add Universe Domain to Java-Core ([#2329](https://github.com/googleapis/sdk-platform-java/issues/2329)) ([586ac9f](https://github.com/googleapis/sdk-platform-java/commit/586ac9f668e0ae647e3ef233458d2c754959f6e5))
* Full Endpoint Resolution from EndpointContext ([#2313](https://github.com/googleapis/sdk-platform-java/issues/2313)) ([f499ced](https://github.com/googleapis/sdk-platform-java/commit/f499ced28a562cbb3ea49f14a4fa16eb6a8173cc))
* move Java Owlbot into this repository for postprocessing ([#2282](https://github.com/googleapis/sdk-platform-java/issues/2282)) ([f8969d2](https://github.com/googleapis/sdk-platform-java/commit/f8969d2b5b50b338967802436bac8d21c3656e07))
* new artifact for sdk-platform-java configs.  ([#2315](https://github.com/googleapis/sdk-platform-java/issues/2315)) ([99e5195](https://github.com/googleapis/sdk-platform-java/commit/99e51953f319c97b225a0209b093367fa440f9d3))
* Parse Host Service Name ([#2300](https://github.com/googleapis/sdk-platform-java/issues/2300)) ([8822f3b](https://github.com/googleapis/sdk-platform-java/commit/8822f3b514bdddf028c12db7a773e80fa4f4f3a1))
* Structs mapper utility ([#2278](https://github.com/googleapis/sdk-platform-java/issues/2278)) ([da6607b](https://github.com/googleapis/sdk-platform-java/commit/da6607b17130ab045640618d505fda915ddb8e49))
* unmanaged dependency check ([#2223](https://github.com/googleapis/sdk-platform-java/issues/2223)) ([3439691](https://github.com/googleapis/sdk-platform-java/commit/34396919b6c58f85af26650a7d3d429d9b4e9008))


### Bug Fixes

* format proto comments in Client Overview ([#2280](https://github.com/googleapis/sdk-platform-java/issues/2280)) ([4029fbd](https://github.com/googleapis/sdk-platform-java/commit/4029fbdd9ab060ef55382b1890f323f85fe3ceef))
* re-enable checkstyle in sdk-platform-java-config ([#2335](https://github.com/googleapis/sdk-platform-java/issues/2335)) ([285bdb1](https://github.com/googleapis/sdk-platform-java/commit/285bdb101194740a7a9618565679b7be01c70f43))


### Dependencies

* update google api dependencies ([#2277](https://github.com/googleapis/sdk-platform-java/issues/2277)) ([4bc45bd](https://github.com/googleapis/sdk-platform-java/commit/4bc45bd3c525714acc3866ce47943f91d860f8d2))
* update googleapis/java-cloud-bom digest to 3fe0c17 ([#2286](https://github.com/googleapis/sdk-platform-java/issues/2286)) ([c7de93e](https://github.com/googleapis/sdk-platform-java/commit/c7de93e6a6e08b663041e98eaab9cb5449d51b9f))
* update grpc dependencies to v1.60.0 ([#2288](https://github.com/googleapis/sdk-platform-java/issues/2288)) ([c8bf058](https://github.com/googleapis/sdk-platform-java/commit/c8bf05813cb8968447572df5622cf497510bca34))

## [2.30.0](https://github.com/googleapis/sdk-platform-java/compare/v2.29.0...v2.30.0) (2023-11-29)


### Features

* update javadocs for Client classes to include table of methods ([#2114](https://github.com/googleapis/sdk-platform-java/issues/2114)) ([c81cd0f](https://github.com/googleapis/sdk-platform-java/commit/c81cd0ffb95df7fc6d52629c770254aea60ff4fd))


### Bug Fixes

* confirm owlbot-copy succeeeded to transfer java files ([#2235](https://github.com/googleapis/sdk-platform-java/issues/2235)) ([94d1dd2](https://github.com/googleapis/sdk-platform-java/commit/94d1dd24e38b348a9727f231d6d9aa4e8635144e))
* improve information on CancellationException for LROs ([#2236](https://github.com/googleapis/sdk-platform-java/issues/2236)) ([741e40c](https://github.com/googleapis/sdk-platform-java/commit/741e40ceb0b7d5e0eceb8a90a52acf57648c0066))
* owlbot-cli image sha to be locked (hermetic) ([#2252](https://github.com/googleapis/sdk-platform-java/issues/2252)) ([6c4c236](https://github.com/googleapis/sdk-platform-java/commit/6c4c2364c1798642a19c8208c09c9becd562012d))


### Dependencies

* update dependency com.fasterxml.jackson:jackson-bom to v2.16.0 ([#2259](https://github.com/googleapis/sdk-platform-java/issues/2259)) ([4eef7ec](https://github.com/googleapis/sdk-platform-java/commit/4eef7ec8311cf196253143fdaa46ccdb6c8fc153))
* update dependency com.google.cloud:grpc-gcp to v1.5.0 ([#2265](https://github.com/googleapis/sdk-platform-java/issues/2265)) ([964a649](https://github.com/googleapis/sdk-platform-java/commit/964a649838b9b58c2ae40e6d7da205a9ffd17b90))
* update dependency com.google.errorprone:error_prone_annotations to v2.23.0 ([#2182](https://github.com/googleapis/sdk-platform-java/issues/2182)) ([5116f3d](https://github.com/googleapis/sdk-platform-java/commit/5116f3dcd93759220b450ebfd0a1535cb56e6e30))
* update dependency com.googlecode.maven-download-plugin:download-maven-plugin to v1.7.1 ([#2151](https://github.com/googleapis/sdk-platform-java/issues/2151)) ([cbe1bb1](https://github.com/googleapis/sdk-platform-java/commit/cbe1bb11548c791cde32d3c5b237977fa486f11a))
* update dependency cryptography to v41.0.7 ([#2255](https://github.com/googleapis/sdk-platform-java/issues/2255)) ([a98ea5c](https://github.com/googleapis/sdk-platform-java/commit/a98ea5cccc8dc8e4015473a9529f3cd066ad7913))
* update dependency net.bytebuddy:byte-buddy to v1.14.10 ([#2256](https://github.com/googleapis/sdk-platform-java/issues/2256)) ([094f263](https://github.com/googleapis/sdk-platform-java/commit/094f2639e74e483658b567ceb7125079caed7e34))
* update dependency org.apache.commons:commons-lang3 to v3.14.0 ([#2260](https://github.com/googleapis/sdk-platform-java/issues/2260)) ([03dc96b](https://github.com/googleapis/sdk-platform-java/commit/03dc96bb5f48e38436812eb882255695d256d69f))
* update dependency org.checkerframework:checker-qual to v3.40.0 ([#2221](https://github.com/googleapis/sdk-platform-java/issues/2221)) ([c3fcfbd](https://github.com/googleapis/sdk-platform-java/commit/c3fcfbd44656f7589527642056f46c21be8019a5))
* update dependency pyasn1 to v0.5.1 ([#2262](https://github.com/googleapis/sdk-platform-java/issues/2262)) ([4bfa6cf](https://github.com/googleapis/sdk-platform-java/commit/4bfa6cf7c347d8068b6cbf94788cd057686afb12))
* update google api dependencies ([#2219](https://github.com/googleapis/sdk-platform-java/issues/2219)) ([877cb2a](https://github.com/googleapis/sdk-platform-java/commit/877cb2a14a3dd9abe26b1c3a4652811c1770ccdc))
* update googleapis/java-cloud-bom digest to ab98a49 ([#2231](https://github.com/googleapis/sdk-platform-java/issues/2231)) ([67a2c94](https://github.com/googleapis/sdk-platform-java/commit/67a2c947fe6ee4bb3478b873a92d5e7c66eaa3b7))
* update grpc dependencies to v1.59.1 ([#2263](https://github.com/googleapis/sdk-platform-java/issues/2263)) ([fdb1559](https://github.com/googleapis/sdk-platform-java/commit/fdb1559013e6c2f6c6638c8ed6a078a92314f803))
* update guava monorepo ([#2139](https://github.com/googleapis/sdk-platform-java/issues/2139)) ([b861f19](https://github.com/googleapis/sdk-platform-java/commit/b861f19a824353da8f585151924813d9197b3c9b))
* update netty dependencies to v4.1.101.final ([#2257](https://github.com/googleapis/sdk-platform-java/issues/2257)) ([2733fcf](https://github.com/googleapis/sdk-platform-java/commit/2733fcf8baf33f6129cccec3f6b3a305e68ad947))
* update protobuf dependencies to v3.25.0 ([#2222](https://github.com/googleapis/sdk-platform-java/issues/2222)) ([445477f](https://github.com/googleapis/sdk-platform-java/commit/445477f7fec3a6d4be9df4c9cf3f01c007307645))
* update protobuf dependencies to v3.25.1 ([#2242](https://github.com/googleapis/sdk-platform-java/issues/2242)) ([faea6c4](https://github.com/googleapis/sdk-platform-java/commit/faea6c4414977fb5e5d7d2abc3604e01d27731c1))


### Documentation

* Update RetrySettings javadocs to include polling ([#1863](https://github.com/googleapis/sdk-platform-java/issues/1863)) ([3c9cb06](https://github.com/googleapis/sdk-platform-java/commit/3c9cb061c8cee59dd1072bd415c32110ecf10517))

## [2.29.0](https://github.com/googleapis/sdk-platform-java/compare/v2.28.0...v2.29.0) (2023-10-31)


### Features

* `generate_library.sh` with postprocessing ([#1951](https://github.com/googleapis/sdk-platform-java/issues/1951)) ([39b9f0e](https://github.com/googleapis/sdk-platform-java/commit/39b9f0e956b7967d118873ee2e365fe6a02a029b))


### Dependencies

* update dependency cryptography to v41.0.5 ([#2206](https://github.com/googleapis/sdk-platform-java/issues/2206)) ([6d1f84a](https://github.com/googleapis/sdk-platform-java/commit/6d1f84a7923573346fbfbfa3107a3da4c0a19bfe))
* update dependency google-auth to v2.23.4 ([#2217](https://github.com/googleapis/sdk-platform-java/issues/2217)) ([f1ee04d](https://github.com/googleapis/sdk-platform-java/commit/f1ee04d902000c5f8dd6a9c51dea57c9de01a25e))
* update dependency google-cloud-storage to v2.13.0 ([#2216](https://github.com/googleapis/sdk-platform-java/issues/2216)) ([1af12a8](https://github.com/googleapis/sdk-platform-java/commit/1af12a8881c2036d4ddb844c061b5f6b17e991d9))
* update google api dependencies ([#2187](https://github.com/googleapis/sdk-platform-java/issues/2187)) ([448b0d1](https://github.com/googleapis/sdk-platform-java/commit/448b0d1eea5c4bd5f89176315c21cf7d49bc1af5))
* update googleapis/java-cloud-bom digest to 41d86db ([#2205](https://github.com/googleapis/sdk-platform-java/issues/2205)) ([9152f24](https://github.com/googleapis/sdk-platform-java/commit/9152f24e7aafa165326205b12d3709c61c842a3f))
* update googleapis/java-cloud-bom digest to b8394a1 ([#2201](https://github.com/googleapis/sdk-platform-java/issues/2201)) ([f9957df](https://github.com/googleapis/sdk-platform-java/commit/f9957df04bc00d72e1a26dfd5c4c4805172d58d7))
* update googleapis/java-cloud-bom digest to d06156f ([#2200](https://github.com/googleapis/sdk-platform-java/issues/2200)) ([097e37e](https://github.com/googleapis/sdk-platform-java/commit/097e37e560646ed47925e3620c5a490a78889ec7))
* update googleapis/java-cloud-bom digest to e896c4e ([#2198](https://github.com/googleapis/sdk-platform-java/issues/2198)) ([15a796f](https://github.com/googleapis/sdk-platform-java/commit/15a796f718e7e27991d27a337223314addb0375a))
* update graal-sdk to 22.3.3 in bazel dependencies file ([#2209](https://github.com/googleapis/sdk-platform-java/issues/2209)) ([25957d3](https://github.com/googleapis/sdk-platform-java/commit/25957d3b8cc0424d5b1ac293e771a15f0fc54721))
* update grpc dependencies to v1.59.0 ([#2211](https://github.com/googleapis/sdk-platform-java/issues/2211)) ([7dafa8d](https://github.com/googleapis/sdk-platform-java/commit/7dafa8d452615e5ac5dd5fbb95e645a1ce4a9226))

## [2.28.0](https://github.com/googleapis/sdk-platform-java/compare/v2.27.0...v2.28.0) (2023-10-19)


### Features

* Add gapic options as inputs to `generate_library.sh` ([#2121](https://github.com/googleapis/sdk-platform-java/issues/2121)) ([b17d8a1](https://github.com/googleapis/sdk-platform-java/commit/b17d8a12575b273b4536b42c37bf61b321fc0e5a))
* Log DirectPath misconfiguration ([#2105](https://github.com/googleapis/sdk-platform-java/issues/2105)) ([860ae76](https://github.com/googleapis/sdk-platform-java/commit/860ae7646a985786966af55c5d3be35981e0fab1))
* Replace graal version declarion with properties placeholder ([#2120](https://github.com/googleapis/sdk-platform-java/issues/2120)) ([e5247ba](https://github.com/googleapis/sdk-platform-java/commit/e5247ba61eb4c2e543bab79110eaba3766a8264f))


### Bug Fixes

* Make sure outstanding RPCs count in ChannelPool can not go negative ([#2185](https://github.com/googleapis/sdk-platform-java/issues/2185)) ([d2d624d](https://github.com/googleapis/sdk-platform-java/commit/d2d624def3d72ecdaa3fdf7e2a92fd29d39ff1aa))


### Dependencies

* Update dependency attrs to v22.2.0 ([#2146](https://github.com/googleapis/sdk-platform-java/issues/2146)) ([49d7f55](https://github.com/googleapis/sdk-platform-java/commit/49d7f55df0efd1ebf4ec074a8b9c23324de69149))
* Update dependency cffi to v1.16.0 ([#2147](https://github.com/googleapis/sdk-platform-java/issues/2147)) ([db37d5b](https://github.com/googleapis/sdk-platform-java/commit/db37d5ba609adf571c75f9f2f51c39b7453b862b))
* Update dependency charset-normalizer to v2.1.1 ([#2148](https://github.com/googleapis/sdk-platform-java/issues/2148)) ([759e957](https://github.com/googleapis/sdk-platform-java/commit/759e957a1a3738218a6e360660d340cb99a3268e))
* Update dependency com.fasterxml.jackson:jackson-bom to v2.15.3 ([#2136](https://github.com/googleapis/sdk-platform-java/issues/2136)) ([be25555](https://github.com/googleapis/sdk-platform-java/commit/be2555565c91580df0b81ae09ad2cda8ef5a40a7))
* Update dependency com.google.auto.value:auto-value to v1.10.4 ([#2137](https://github.com/googleapis/sdk-platform-java/issues/2137)) ([5edca8b](https://github.com/googleapis/sdk-platform-java/commit/5edca8b542e767cc9a9a899420f2707a5c91e1e7))
* Update dependency com.google.auto.value:auto-value-annotations to v1.10.4 ([#2138](https://github.com/googleapis/sdk-platform-java/issues/2138)) ([705c358](https://github.com/googleapis/sdk-platform-java/commit/705c358804767419f742978185fa9a93e622a1da))
* Update dependency com.google.errorprone:error_prone_annotations to v2.22.0 ([#2130](https://github.com/googleapis/sdk-platform-java/issues/2130)) ([805daf1](https://github.com/googleapis/sdk-platform-java/commit/805daf1a9967f63b747624dd4098d78a80c083bf))
* Update dependency com.google.errorprone:error_prone_annotations to v2.22.0 ([#2145](https://github.com/googleapis/sdk-platform-java/issues/2145)) ([f936331](https://github.com/googleapis/sdk-platform-java/commit/f9363315f20f27237324a5797ba20a0097283410))
* Update dependency commons-codec:commons-codec to v1.16.0 ([#2152](https://github.com/googleapis/sdk-platform-java/issues/2152)) ([0cf3440](https://github.com/googleapis/sdk-platform-java/commit/0cf34408d97c5d7dd63ea941de27b64a95e35524))
* Update dependency cryptography to v41.0.4 [security] ([#2109](https://github.com/googleapis/sdk-platform-java/issues/2109)) ([e2f57f2](https://github.com/googleapis/sdk-platform-java/commit/e2f57f2fe20c920eafb0306ea51c8205e371d972))
* Update dependency gcp-releasetool to v1.16.0 ([#2111](https://github.com/googleapis/sdk-platform-java/issues/2111)) ([69d1259](https://github.com/googleapis/sdk-platform-java/commit/69d12593dfbd0d69d2bd79df8d42def42eccb892))
* Update dependency google-api-core to v2.12.0 ([#2153](https://github.com/googleapis/sdk-platform-java/issues/2153)) ([8c1baf5](https://github.com/googleapis/sdk-platform-java/commit/8c1baf59fac515b10698b1548a7104e8ef82cd1e))
* Update dependency google-auth to v2.23.3 ([#2154](https://github.com/googleapis/sdk-platform-java/issues/2154)) ([3645fed](https://github.com/googleapis/sdk-platform-java/commit/3645fed46926cf4f402e4986749db55b86fab6b6))
* Update dependency google-cloud-core to v2.3.3 ([#2113](https://github.com/googleapis/sdk-platform-java/issues/2113)) ([c8194cf](https://github.com/googleapis/sdk-platform-java/commit/c8194cf29dfee221d87aaaca13983794ad089433))
* Update dependency google-cloud-storage to v2.12.0 ([#2155](https://github.com/googleapis/sdk-platform-java/issues/2155)) ([0ec9027](https://github.com/googleapis/sdk-platform-java/commit/0ec902795ae36ff16890a1c02c07b2b977dfed14))
* Update dependency google-crc32c to v1.5.0 ([#2157](https://github.com/googleapis/sdk-platform-java/issues/2157)) ([6556ed5](https://github.com/googleapis/sdk-platform-java/commit/6556ed588bad9901592949ce5674ac2894102bd2))
* Update dependency google-resumable-media to v2.6.0 ([#2161](https://github.com/googleapis/sdk-platform-java/issues/2161)) ([87dd6f2](https://github.com/googleapis/sdk-platform-java/commit/87dd6f2862dbd82fe267008306e841c4e9bb5af2))
* Update dependency googleapis-common-protos to v1.61.0 ([#2156](https://github.com/googleapis/sdk-platform-java/issues/2156)) ([f7fd515](https://github.com/googleapis/sdk-platform-java/commit/f7fd515b00ff615cbd7b86c8471b2a1d8a1ce2ee))
* Update dependency gradle to v7.6.3 ([#2115](https://github.com/googleapis/sdk-platform-java/issues/2115)) ([cd9748d](https://github.com/googleapis/sdk-platform-java/commit/cd9748d4a62b843080c107309c15d6894eb0eb28))
* Update dependency importlib-metadata to v4.13.0 ([#2162](https://github.com/googleapis/sdk-platform-java/issues/2162)) ([ac6e3d5](https://github.com/googleapis/sdk-platform-java/commit/ac6e3d5bbeab2dbf35aefc14b20217119e99460d))
* Update dependency jeepney to v0.8.0 ([#2165](https://github.com/googleapis/sdk-platform-java/issues/2165)) ([59744b5](https://github.com/googleapis/sdk-platform-java/commit/59744b56409564dab142f24533672b1fa9726313))
* Update dependency jinja2 to v3.1.2 ([#2166](https://github.com/googleapis/sdk-platform-java/issues/2166)) ([c7ac765](https://github.com/googleapis/sdk-platform-java/commit/c7ac765237c7bbed041e7b15b040625f411eee5c))
* Update dependency markupsafe to v2.1.3 ([#2168](https://github.com/googleapis/sdk-platform-java/issues/2168)) ([ea26b1a](https://github.com/googleapis/sdk-platform-java/commit/ea26b1aedcdb4eb08449194b111b00e07c2c0d02))
* Update dependency net.bytebuddy:byte-buddy to v1.14.9 ([#2116](https://github.com/googleapis/sdk-platform-java/issues/2116)) ([e0ad3e6](https://github.com/googleapis/sdk-platform-java/commit/e0ad3e678ac9a42cb4c9a6111e8da750a2294ba6))
* Update dependency org.apache.commons:commons-lang3 to v3.13.0 ([#2131](https://github.com/googleapis/sdk-platform-java/issues/2131)) ([c066286](https://github.com/googleapis/sdk-platform-java/commit/c066286ef3da2f8587d44d2b3d60db63be24875a))
* Update dependency org.checkerframework:checker-qual to v3.39.0 ([#2158](https://github.com/googleapis/sdk-platform-java/issues/2158)) ([dfe2bbc](https://github.com/googleapis/sdk-platform-java/commit/dfe2bbcd6079ab0b28f091bc132dfc27c9ab98c0))
* Update dependency org.easymock:easymock to v5.2.0 ([#2159](https://github.com/googleapis/sdk-platform-java/issues/2159)) ([8daf145](https://github.com/googleapis/sdk-platform-java/commit/8daf1452351aa0df2e282676a69e90c3743b4edf))
* Update dependency org.yaml:snakeyaml to v2.2 ([#2160](https://github.com/googleapis/sdk-platform-java/issues/2160)) ([0664bf6](https://github.com/googleapis/sdk-platform-java/commit/0664bf6e578861197abd3ed31148d7db27b8eb53))
* Update dependency protobuf to v3.20.3 ([#2169](https://github.com/googleapis/sdk-platform-java/issues/2169)) ([669d369](https://github.com/googleapis/sdk-platform-java/commit/669d3698cb76471cd0c9c6a398fb7b3d848d1571))
* Update dependency pyasn1 to v0.5.0 ([#2170](https://github.com/googleapis/sdk-platform-java/issues/2170)) ([a842045](https://github.com/googleapis/sdk-platform-java/commit/a842045c71cdf88975505c90b5915eba321f0a65))
* Update dependency pyasn1-modules to v0.3.0 ([#2171](https://github.com/googleapis/sdk-platform-java/issues/2171)) ([4abbf85](https://github.com/googleapis/sdk-platform-java/commit/4abbf858712b1f629df8b19a9007d1a09451e5e2))
* Update dependency pyjwt to v2.8.0 ([#2172](https://github.com/googleapis/sdk-platform-java/issues/2172)) ([875146e](https://github.com/googleapis/sdk-platform-java/commit/875146eb3c1ac3cb1953980825f79c75c3251ea6))
* Update dependency pyparsing to v3.1.1 ([#2173](https://github.com/googleapis/sdk-platform-java/issues/2173)) ([caac831](https://github.com/googleapis/sdk-platform-java/commit/caac8316a12aa0d8b7ef5f57912727a1abfc3151))
* Update dependency typing-extensions to v4.8.0 ([#2174](https://github.com/googleapis/sdk-platform-java/issues/2174)) ([1a8f7a4](https://github.com/googleapis/sdk-platform-java/commit/1a8f7a446665b6fe03dd98856734ec48b59e080f))
* Update dependency urllib3 to v1.26.17 [security] ([#2110](https://github.com/googleapis/sdk-platform-java/issues/2110)) ([5f40056](https://github.com/googleapis/sdk-platform-java/commit/5f40056fdb5d62e59744d43dd149d5da20979e59))
* Update dependency urllib3 to v1.26.18 ([#2177](https://github.com/googleapis/sdk-platform-java/issues/2177)) ([9683111](https://github.com/googleapis/sdk-platform-java/commit/9683111627bca74ed0d123caf37ff0993c71d2ea))
* Update dependency zipp to v3.17.0 ([#2175](https://github.com/googleapis/sdk-platform-java/issues/2175)) ([1700c59](https://github.com/googleapis/sdk-platform-java/commit/1700c597a74f906689a3a53e023ac094c9deeaff))
* Update google api dependencies ([#2132](https://github.com/googleapis/sdk-platform-java/issues/2132)) ([bd4ae4f](https://github.com/googleapis/sdk-platform-java/commit/bd4ae4fab88a421ad93e597f99cabb7997f91e1d))
* Update google auth library dependencies to v1.20.0 ([#2142](https://github.com/googleapis/sdk-platform-java/issues/2142)) ([ce59ed8](https://github.com/googleapis/sdk-platform-java/commit/ce59ed8be29a6b05f7c999bf48cb4d442fc2294a))
* Update googleapis/java-cloud-bom digest to 4b9b60d ([#2178](https://github.com/googleapis/sdk-platform-java/issues/2178)) ([6a8972e](https://github.com/googleapis/sdk-platform-java/commit/6a8972ea287f665d82046b8314887edee27a6c1a))
* Update googleapis/java-cloud-bom digest to a0bfee4 ([#2181](https://github.com/googleapis/sdk-platform-java/issues/2181)) ([88bccd9](https://github.com/googleapis/sdk-platform-java/commit/88bccd9e4b6c3245c0fae7e142954155bf373274))
* Update googleapis/java-cloud-bom digest to e485c2f ([#2134](https://github.com/googleapis/sdk-platform-java/issues/2134)) ([97f97c6](https://github.com/googleapis/sdk-platform-java/commit/97f97c6063f91183af260d875d58958f4bba658b))
* Update netty dependencies ([#2141](https://github.com/googleapis/sdk-platform-java/issues/2141)) ([fedc7b9](https://github.com/googleapis/sdk-platform-java/commit/fedc7b921f5415b2d51d3147ef1aaebf1b75ccdb))
* Update protobuf dependencies to v3.24.4 ([#2118](https://github.com/googleapis/sdk-platform-java/issues/2118)) ([7b3f4b9](https://github.com/googleapis/sdk-platform-java/commit/7b3f4b97b013a32f171bd8a365d6d712b94b3849))

## [2.27.0](https://github.com/googleapis/sdk-platform-java/compare/v2.26.1...v2.27.0) (2023-10-06)


### Features

* [common-protos] public google.api.FieldInfo type and extension ([#2037](https://github.com/googleapis/sdk-platform-java/issues/2037)) ([f2b8280](https://github.com/googleapis/sdk-platform-java/commit/f2b828005e6b21a2af0e646bb8cc6d0f8c39d4e4))
* Generate proto-only library ([#2046](https://github.com/googleapis/sdk-platform-java/issues/2046)) ([f9ac8fb](https://github.com/googleapis/sdk-platform-java/commit/f9ac8fb0020372be4b62d5dffe7e1b73a1ac493f))
* More logging for ChannelPool shutdown ([#2070](https://github.com/googleapis/sdk-platform-java/issues/2070)) ([b8365c2](https://github.com/googleapis/sdk-platform-java/commit/b8365c2a0c56db1ee286c582cd9ebe31a3d614e8))


### Dependencies

* Bumping java-shared-config to 1.5.8 ([#2072](https://github.com/googleapis/sdk-platform-java/issues/2072)) ([fa5e937](https://github.com/googleapis/sdk-platform-java/commit/fa5e937e98ad19b997f8c0e11cd03e61f707f3fe))

## [2.26.1](https://github.com/googleapis/sdk-platform-java/compare/v2.26.0...v2.26.1) (2023-09-25)


### Bug Fixes

* Add Geo common protos to Bazel test dependencies. ([#2033](https://github.com/googleapis/sdk-platform-java/issues/2033)) ([625ecc5](https://github.com/googleapis/sdk-platform-java/commit/625ecc503a6b193716820681aafe0f2daf16d4c4))

## [2.26.0](https://github.com/googleapis/sdk-platform-java/compare/v2.25.0...v2.26.0) (2023-09-21)


### Features

* Filter out `*gapic.legacy.yaml` when parsing `java_gapic_opts` ([#2015](https://github.com/googleapis/sdk-platform-java/issues/2015)) ([1ad5ec0](https://github.com/googleapis/sdk-platform-java/commit/1ad5ec0c2d99e41f4fddf9ed131c6dc9bffe17b4))
* Generate showcase without post-processing ([#1935](https://github.com/googleapis/sdk-platform-java/issues/1935)) ([7218d80](https://github.com/googleapis/sdk-platform-java/commit/7218d8035946c350d7857fede93d32df3b2b8a86))
* Hermetic build OS detection ([#1988](https://github.com/googleapis/sdk-platform-java/issues/1988)) ([4fc844e](https://github.com/googleapis/sdk-platform-java/commit/4fc844ee0ffdaae26ef3d32c18bbe7604da5c16f))
* Hermetic build scripts to use a single output/generation folder ([#1987](https://github.com/googleapis/sdk-platform-java/issues/1987)) ([f5efb0e](https://github.com/googleapis/sdk-platform-java/commit/f5efb0edb097980db95832469188c754ec3f1779))
* Search gapic additional protos in `BUILD.bazel` ([#2004](https://github.com/googleapis/sdk-platform-java/issues/2004)) ([ed16ac7](https://github.com/googleapis/sdk-platform-java/commit/ed16ac74ab8430ee0def437147298d7d88da6b0c))


### Bug Fixes

* **hermetic-build:** Obtain gapic-generator-java locally on release branch ([#2023](https://github.com/googleapis/sdk-platform-java/issues/2023)) ([f3088d5](https://github.com/googleapis/sdk-platform-java/commit/f3088d55478ab049110d8c2e67ff1dd056a5e71d))
* Showcase update goal fix ([#2002](https://github.com/googleapis/sdk-platform-java/issues/2002)) ([47811f7](https://github.com/googleapis/sdk-platform-java/commit/47811f79848d6efd9dda8b3e8e4286dc3045423f))
* Skip generating `grpc-*` directory if transport is `rest` ([#1979](https://github.com/googleapis/sdk-platform-java/issues/1979)) ([9c0316b](https://github.com/googleapis/sdk-platform-java/commit/9c0316bfed890ed7d8e40340a3510d2058dc5d71))


### Documentation

* Add repo-metadata.json files for modules we publish Cloud RAD d… ([#2003](https://github.com/googleapis/sdk-platform-java/issues/2003)) ([2212ba3](https://github.com/googleapis/sdk-platform-java/commit/2212ba300c215b00cf852fd3d8615f3d3c3458e1))


### Dependencies

* Update protobuf dependencies to v3.24.3 ([#2020](https://github.com/googleapis/sdk-platform-java/issues/2020)) ([2b45049](https://github.com/googleapis/sdk-platform-java/commit/2b45049fd6fbd38acded8ae900ef4b530a441bdf))

## [2.25.0](https://github.com/googleapis/sdk-platform-java/compare/v2.24.0...v2.25.0) (2023-09-08)


### Features

* [common-protos,common-protos] add new FieldBehavior value IDENTIFIER ([#1937](https://github.com/googleapis/sdk-platform-java/issues/1937)) ([24ae2a3](https://github.com/googleapis/sdk-platform-java/commit/24ae2a3e0237fb2821ea07ccdd874c92ead598a2))
* Add `generate_library.sh` without post processing ([#1916](https://github.com/googleapis/sdk-platform-java/issues/1916)) ([ffc058a](https://github.com/googleapis/sdk-platform-java/commit/ffc058a08c523b3811b021ec1bc30201452a36c9))
* Adding vendor and vendor information in header ([#1963](https://github.com/googleapis/sdk-platform-java/issues/1963)) ([ed44aa7](https://github.com/googleapis/sdk-platform-java/commit/ed44aa785f8e21ad07aed984220db6e30e07a6c6))
* Introduce @ObsoleteApi ([#1887](https://github.com/googleapis/sdk-platform-java/issues/1887)) ([5df1aa3](https://github.com/googleapis/sdk-platform-java/commit/5df1aa3733852aaeed068080f6b48047e89dc799))


### Bug Fixes

* Remove -H:-RunReachabilityHandlersConcurrently ([#1892](https://github.com/googleapis/sdk-platform-java/issues/1892)) ([9cc52e1](https://github.com/googleapis/sdk-platform-java/commit/9cc52e1e788e4196c9e83ad5d8a9487042ae707e))
* Use && in equals check to avoid possible NPE ([#1927](https://github.com/googleapis/sdk-platform-java/issues/1927)) ([815567c](https://github.com/googleapis/sdk-platform-java/commit/815567ca4085702ecee8fc95603574cd52d6c57d))


### Documentation

* [iam] Minor formatting ([#1902](https://github.com/googleapis/sdk-platform-java/issues/1902)) ([5ec1142](https://github.com/googleapis/sdk-platform-java/commit/5ec1142458a46ae1c561f608b2ef7ac18ab0bafd))

## [2.24.0](https://github.com/googleapis/sdk-platform-java/compare/v2.23.1...v2.24.0) (2023-08-01)


### Features

* [common-protos] Add a proto message to describe the `resource_type` and `resource_permission` for an API method ([#1878](https://github.com/googleapis/sdk-platform-java/issues/1878)) ([3e27ca9](https://github.com/googleapis/sdk-platform-java/commit/3e27ca9763e9639fb00b99bdef9cf95aacd33897))

## [2.23.1](https://github.com/googleapis/sdk-platform-java/compare/v2.23.0...v2.23.1) (2023-07-19)


### Bug Fixes

* Resource name class deduplication ([#1854](https://github.com/googleapis/sdk-platform-java/issues/1854)) ([08eca7d](https://github.com/googleapis/sdk-platform-java/commit/08eca7de7e80c6f242a23a9d76659e0a413c896f))
* Use bindings for resolving multi pattern resources ([#1818](https://github.com/googleapis/sdk-platform-java/issues/1818)) ([1352fab](https://github.com/googleapis/sdk-platform-java/commit/1352fab654052e670df6d5c8718fcc6e06ef086c))


### Dependencies

* Auto-value version 1.10.2 ([#1859](https://github.com/googleapis/sdk-platform-java/issues/1859)) ([54843c9](https://github.com/googleapis/sdk-platform-java/commit/54843c95e0f0e2d004b14e82650c01026bf2ad70))
* Bump grpc version to 1.56.1 ([1fcdd89](https://github.com/googleapis/sdk-platform-java/commit/1fcdd893240a7e5da293c6a26df193131577bbdd))
* Bump jackson version to 2.15.2 ([bde81d8](https://github.com/googleapis/sdk-platform-java/commit/bde81d8c6f15130f51ea4e2d9805de3c0a21ae39))

## [2.23.0](https://github.com/googleapis/sdk-platform-java/compare/v2.22.0...v2.23.0) (2023-07-07)


### Features

* Support GDC-H Credentials  ([#1642](https://github.com/googleapis/sdk-platform-java/issues/1642)) ([26da0d3](https://github.com/googleapis/sdk-platform-java/commit/26da0d3fb882e4f11c1cc43a81d34eb500c2c0cf))


### Bug Fixes

* [gapic-generator-java] handle response and metadata type ambiguity in LRO parsing ([#1726](https://github.com/googleapis/sdk-platform-java/issues/1726)) ([1ace494](https://github.com/googleapis/sdk-platform-java/commit/1ace49499175f2509062edb2fa5098e6cf8035d6))
* Abstract batch resource and add method to determine if batch should be flushed ([#1790](https://github.com/googleapis/sdk-platform-java/issues/1790)) ([4c74107](https://github.com/googleapis/sdk-platform-java/commit/4c741077d614093d08665e9ddd83fb0e332b7881))


### Dependencies

* Bump grpc-java version to 1.55.3 ([1ff8cc0](https://github.com/googleapis/sdk-platform-java/commit/1ff8cc017bfb567933713ceeb06502f5eec9eaa6))
* Bump guava version to 32.1.1-jre ([016e84d](https://github.com/googleapis/sdk-platform-java/commit/016e84d17febd68e2aa028cba40e2781a383f7ff))
* Bump j2obc-annotations version to 2.8 ([4f45313](https://github.com/googleapis/sdk-platform-java/commit/4f4531373f313a7d68c2b9bfd5b0f1f71b21128f))
* Update google-auth-java-library to 1.19.0 ([#1815](https://github.com/googleapis/sdk-platform-java/issues/1815)) ([41007a9](https://github.com/googleapis/sdk-platform-java/commit/41007a9efbd4cf08a5f933c23e01fce6cf2efac7))

## [2.22.0](https://github.com/googleapis/sdk-platform-java/compare/v2.21.0...v2.22.0) (2023-06-22)


### Features

* Dynamically determine protobuf version in build.gradle ([#1753](https://github.com/googleapis/sdk-platform-java/issues/1753)) ([6de5110](https://github.com/googleapis/sdk-platform-java/commit/6de51100965b8b6a1c252ec06b10993486de7d44))
* GA Gax HttpJson ([#1264](https://github.com/googleapis/sdk-platform-java/issues/1264)) ([9f15fea](https://github.com/googleapis/sdk-platform-java/commit/9f15fea139e9b49ae32e6a4923085f9aca9c3115))


### Bug Fixes

* Update grpc to 1.55.1 in dependencies.properties ([#1794](https://github.com/googleapis/sdk-platform-java/issues/1794)) ([4df4450](https://github.com/googleapis/sdk-platform-java/commit/4df445067484454455512c8f7de0055c0ae21434))

## [2.21.0](https://github.com/googleapis/sdk-platform-java/compare/v2.20.1...v2.21.0) (2023-06-06)


### Features

* Dynamic Routing Headers for HttpJson ([#1667](https://github.com/googleapis/sdk-platform-java/issues/1667)) ([003b993](https://github.com/googleapis/sdk-platform-java/commit/003b993f7ad7cae8ae8c101e0ff147e517dcd83e))
* Implement awaitTermination() for MangedHttpJsonChannel ([#1677](https://github.com/googleapis/sdk-platform-java/issues/1677)) ([dea8426](https://github.com/googleapis/sdk-platform-java/commit/dea8426a85b53d08d3c8d317a1af4312889b1a3d))


### Bug Fixes

* [gapic-generator-java] align writer behavior for nested types ([#1709](https://github.com/googleapis/sdk-platform-java/issues/1709)) ([a21ffe8](https://github.com/googleapis/sdk-platform-java/commit/a21ffe88f880c0b3c6b5b512cd4d0741d9620dd3))
* [gapic-generator-java] update year to 2023 in generated license headers ([#1720](https://github.com/googleapis/sdk-platform-java/issues/1720)) ([ef4a7ff](https://github.com/googleapis/sdk-platform-java/commit/ef4a7ff91b259f0b650cc06bd664eadca7bd17c9))
* Update the return type of setWaitTimeout for convience ([#1751](https://github.com/googleapis/sdk-platform-java/issues/1751)) ([f1927a5](https://github.com/googleapis/sdk-platform-java/commit/f1927a53306ee28186074e6cb03a933a0cdffc1f))


### Dependencies

* Update dependency com.google.auth:google-auth-library-credentials and google-auth-library-oauth2-http to v1.17.0 ([#1756](https://github.com/googleapis/sdk-platform-java/issues/1756)) ([f583258](https://github.com/googleapis/sdk-platform-java/commit/f58325893b6ab306adbe4047b6dfc438de133ac7))
* Update protobuf dependencies to v3.23.2 ([#1755](https://github.com/googleapis/sdk-platform-java/issues/1755)) ([55ecbc3](https://github.com/googleapis/sdk-platform-java/commit/55ecbc35cbd735b8f4aab48e02e080d79828d70c))

## [2.20.1](https://github.com/googleapis/sdk-platform-java/compare/v2.20.0...v2.20.1) (2023-05-25)


### Bug Fixes

* Allow quota project to be used in combination with null credentials ([#1688](https://github.com/googleapis/sdk-platform-java/issues/1688)) ([cb07bd4](https://github.com/googleapis/sdk-platform-java/commit/cb07bd405b448fbef51367d1b03d4fe9eab54504))

## [2.20.0](https://github.com/googleapis/sdk-platform-java/compare/v2.19.0...v2.20.0) (2023-05-24)


### Features

* Create additional tag on release for google-cloud-shared-dependencies ([#1692](https://github.com/googleapis/sdk-platform-java/issues/1692)) ([c0ea245](https://github.com/googleapis/sdk-platform-java/commit/c0ea24588de744a46600fcf6f0f3c6414549e12d))
* Make stream wait timeout a first class citizen ([#1473](https://github.com/googleapis/sdk-platform-java/issues/1473)) ([bc8a4ad](https://github.com/googleapis/sdk-platform-java/commit/bc8a4ad864f4d6f2b9d98e5fe296320fea19e74b))


### Bug Fixes

* Fix release tag workflow to fetch all tags first ([#1700](https://github.com/googleapis/sdk-platform-java/issues/1700)) ([99b0c96](https://github.com/googleapis/sdk-platform-java/commit/99b0c967fbed22967cd072825de403ed9bac0209))
* Update tag workflow ([#1699](https://github.com/googleapis/sdk-platform-java/issues/1699)) ([a988fe7](https://github.com/googleapis/sdk-platform-java/commit/a988fe7dcfc8568c9256c22b5df907b16e5eea5a))


### Dependencies

* Update protobuf dependencies to v3.23.1 and gprc to 1.55.1 ([#1698](https://github.com/googleapis/sdk-platform-java/issues/1698)) ([1f56175](https://github.com/googleapis/sdk-platform-java/commit/1f561754ed9e797f639cbdfabe070b86b645281b))
* Update showcase version to 0.28.1 ([#1673](https://github.com/googleapis/sdk-platform-java/issues/1673)) ([9a120e9](https://github.com/googleapis/sdk-platform-java/commit/9a120e98524018fa54ae5dcbe2fb0f524c2a0f1b))

## [2.19.0](https://github.com/googleapis/gapic-generator-java/compare/v2.18.0...v2.19.0) (2023-05-09)


### Features

* [common-protos] .NET library settings (for generator behavior tweaks) ([7479758](https://github.com/googleapis/gapic-generator-java/commit/7479758bcc7c7631b01a2a06d149429852cc3900))
* [common-protos] add GEO, SHOPPING, GENERATIVE_AI client orgs ([7479758](https://github.com/googleapis/gapic-generator-java/commit/7479758bcc7c7631b01a2a06d149429852cc3900))
* [common-protos] Log Analytics features of the Cloud Logging API ([#1573](https://github.com/googleapis/gapic-generator-java/issues/1573)) ([7479758](https://github.com/googleapis/gapic-generator-java/commit/7479758bcc7c7631b01a2a06d149429852cc3900))
* Add an option to enable DirectPath xDS ([#1643](https://github.com/googleapis/gapic-generator-java/issues/1643)) ([4054bc6](https://github.com/googleapis/gapic-generator-java/commit/4054bc668daf797a8fce798843e0ec4cda669faa))
* Add ConfigServiceV2.CreateBucketAsync method for creating Log Buckets asynchronously ([7479758](https://github.com/googleapis/gapic-generator-java/commit/7479758bcc7c7631b01a2a06d149429852cc3900))
* Add ConfigServiceV2.CreateLink method for creating linked datasets for Log Analytics Buckets ([7479758](https://github.com/googleapis/gapic-generator-java/commit/7479758bcc7c7631b01a2a06d149429852cc3900))
* Add ConfigServiceV2.DeleteLink method for deleting linked datasets ([7479758](https://github.com/googleapis/gapic-generator-java/commit/7479758bcc7c7631b01a2a06d149429852cc3900))
* Add ConfigServiceV2.GetLink methods for describing linked datasets ([7479758](https://github.com/googleapis/gapic-generator-java/commit/7479758bcc7c7631b01a2a06d149429852cc3900))
* Add ConfigServiceV2.ListLinks method for listing linked datasets ([7479758](https://github.com/googleapis/gapic-generator-java/commit/7479758bcc7c7631b01a2a06d149429852cc3900))
* Add ConfigServiceV2.UpdateBucketAsync method for creating Log Buckets asynchronously ([7479758](https://github.com/googleapis/gapic-generator-java/commit/7479758bcc7c7631b01a2a06d149429852cc3900))
* Add LogBucket.analytics_enabled field that specifies whether Log Bucket's Analytics features are enabled ([7479758](https://github.com/googleapis/gapic-generator-java/commit/7479758bcc7c7631b01a2a06d149429852cc3900))
* Add LogBucket.index_configs field that contains a list of Log Bucket's indexed fields and related configuration data ([7479758](https://github.com/googleapis/gapic-generator-java/commit/7479758bcc7c7631b01a2a06d149429852cc3900))
* Remove directpath enable env ([#1657](https://github.com/googleapis/gapic-generator-java/issues/1657)) ([47851e8](https://github.com/googleapis/gapic-generator-java/commit/47851e877c868ddd6c3eb368591b4e6b635e21c1))


### Bug Fixes

* Unary Callables Deadline values respect the TotalTimeout in RetrySettings ([#1603](https://github.com/googleapis/gapic-generator-java/issues/1603)) ([d2fe520](https://github.com/googleapis/gapic-generator-java/commit/d2fe5203c4db1f8ddfd5a9566e6259b53441348a))


### Dependencies

* Update dependency org.graalvm.sdk:graal-sdk to v22.3.2 ([6107ff3](https://github.com/googleapis/gapic-generator-java/commit/6107ff316c544e4acb1d808a2ddaf9a805f9d7e7))


### Documentation

* [common-protos] mark ReservationResourceUsage field as deprecated ([7479758](https://github.com/googleapis/gapic-generator-java/commit/7479758bcc7c7631b01a2a06d149429852cc3900))
* [common-protos] use deprecated=true for deprecated fields ([7479758](https://github.com/googleapis/gapic-generator-java/commit/7479758bcc7c7631b01a2a06d149429852cc3900))
* Documentation for the Log Analytics features of the Cloud Logging API ([7479758](https://github.com/googleapis/gapic-generator-java/commit/7479758bcc7c7631b01a2a06d149429852cc3900))
* Fix new_issue_uri comment ([7479758](https://github.com/googleapis/gapic-generator-java/commit/7479758bcc7c7631b01a2a06d149429852cc3900))
* Separate paragraphs in linear/exponential distributions ([7479758](https://github.com/googleapis/gapic-generator-java/commit/7479758bcc7c7631b01a2a06d149429852cc3900))

## [2.18.0](https://github.com/googleapis/gapic-generator-java/compare/v2.17.0...v2.18.0) (2023-04-25)


### Features

* **deps:** Add gapic-generator-java to bom ([#1645](https://github.com/googleapis/gapic-generator-java/issues/1645)) ([3e85c4b](https://github.com/googleapis/gapic-generator-java/commit/3e85c4b0e7c7e7fe1df14f2ace6130ac85039368))


### Bug Fixes

* Unescape Java keyword field names when generating HttpJson unit tests. ([#1654](https://github.com/googleapis/gapic-generator-java/issues/1654)) ([5fd79ea](https://github.com/googleapis/gapic-generator-java/commit/5fd79ea433d74d27d6115d91e2e0947e7b247b5d))

## [2.17.0](https://github.com/googleapis/gapic-generator-java/compare/v2.16.0...v2.17.0) (2023-04-11)


### Features

* Add `FunctionalInterface` annotation ([#1515](https://github.com/googleapis/gapic-generator-java/issues/1515)) ([66c0509](https://github.com/googleapis/gapic-generator-java/commit/66c05093b5c56208c3f785e9cf0f5b50f5ad16d4))
* Add stream method for `ServerStream` ([#1575](https://github.com/googleapis/gapic-generator-java/issues/1575)) ([e38c8ec](https://github.com/googleapis/gapic-generator-java/commit/e38c8ec4c2fca131c91e264c7b3e2cad9243a6e5))
* Add stream methods for `Page` ([#1425](https://github.com/googleapis/gapic-generator-java/issues/1425)) ([cf0e01a](https://github.com/googleapis/gapic-generator-java/commit/cf0e01a47258c46a1b4431920b8d7cd24ae9b801))


### Bug Fixes

* Add javadoc for `ApiFutures` ([#1609](https://github.com/googleapis/gapic-generator-java/issues/1609)) ([4bb0a5e](https://github.com/googleapis/gapic-generator-java/commit/4bb0a5e3ce78878841e87a47cd457995ea9ed87e))
* **deps:** Remove unnecessary auto-value in api-common-java ([#1621](https://github.com/googleapis/gapic-generator-java/issues/1621)) ([ffeb820](https://github.com/googleapis/gapic-generator-java/commit/ffeb820ab5a530ca0f8a91d873b07b4ebaea320b))


### Dependencies

* Update dependency cryptography to v39.0.2 ([#1592](https://github.com/googleapis/gapic-generator-java/issues/1592)) ([74cf36e](https://github.com/googleapis/gapic-generator-java/commit/74cf36e628a7f0d2e00c3bf1426be9b8089df8af))
* Update dependency gcp-docuploader to v0.6.5 ([#1593](https://github.com/googleapis/gapic-generator-java/issues/1593)) ([501ee9c](https://github.com/googleapis/gapic-generator-java/commit/501ee9c61bd3f0091bf07d0e60c1dcd2319d1a17))
* Update dependency google-cloud-core to v2.3.2 ([#1595](https://github.com/googleapis/gapic-generator-java/issues/1595)) ([335a104](https://github.com/googleapis/gapic-generator-java/commit/335a104d4846623a25497f5650ea553d5cca677a))
* Update dependency net.bytebuddy:byte-buddy to v1.14.3 ([#1567](https://github.com/googleapis/gapic-generator-java/issues/1567)) ([a270ceb](https://github.com/googleapis/gapic-generator-java/commit/a270cebfeb8d1bb2270cef93f19c44935ed980cf))
* Update dependency org.threeten:threetenbp to v1.6.8 ([#1590](https://github.com/googleapis/gapic-generator-java/issues/1590)) ([26d1c3e](https://github.com/googleapis/gapic-generator-java/commit/26d1c3e511c6fa3a353c3205c06fa8dad6019715))
* Update dependency org.threeten:threetenbp to v1.6.8 ([#1591](https://github.com/googleapis/gapic-generator-java/issues/1591)) ([c3bed81](https://github.com/googleapis/gapic-generator-java/commit/c3bed81d540db51aaaa6e057133efa96b0f814a8))
* Update dependency urllib3 to v1.26.15 ([#1596](https://github.com/googleapis/gapic-generator-java/issues/1596)) ([3288fb3](https://github.com/googleapis/gapic-generator-java/commit/3288fb323d957b182bf246540f9f17157afc5285))
* Update google api dependencies ([#1578](https://github.com/googleapis/gapic-generator-java/issues/1578)) ([c537aba](https://github.com/googleapis/gapic-generator-java/commit/c537aba9d1c6cd4ecdcdc7ce0914a6c605c58b68))

## [2.16.0](https://github.com/googleapis/gapic-generator-java/compare/v2.15.3...v2.16.0) (2023-03-28)


### Features

* [common-protos] add audit_context.proto Bazel targets ([#1493](https://github.com/googleapis/gapic-generator-java/issues/1493)) ([408dba8](https://github.com/googleapis/gapic-generator-java/commit/408dba8fcfa1cbc87acf9bf6fce29ae7e7af739e))
* Install compatibility check ([#1508](https://github.com/googleapis/gapic-generator-java/issues/1508)) ([960067a](https://github.com/googleapis/gapic-generator-java/commit/960067ab60702b50e386cbc413aee2614eebf6d0))


### Bug Fixes

* **deps:** Update dependency com.google.api:gapic-generator-java-bom to v2.15.3 ([#9217](https://github.com/googleapis/gapic-generator-java/issues/9217)) ([4b6157c](https://github.com/googleapis/gapic-generator-java/commit/4b6157c482113ecec02959ad9b84242b116f3f43))
* **deps:** Update dependency com.google.http-client:google-http-client-bom to v1.43.1 ([#9213](https://github.com/googleapis/gapic-generator-java/issues/9213)) ([5d1a0e5](https://github.com/googleapis/gapic-generator-java/commit/5d1a0e54f4681ef8ff55df1da517f9a3876c57bc))
* Fix race condition in GrpcDirectStreamController ([#1537](https://github.com/googleapis/gapic-generator-java/issues/1537)) ([17d133b](https://github.com/googleapis/gapic-generator-java/commit/17d133bd625a9fe203019514aedf63e9fdad97f8))
* Use UTF-8 as default charset for HttpJson requests ([#1477](https://github.com/googleapis/gapic-generator-java/issues/1477)) ([79d986b](https://github.com/googleapis/gapic-generator-java/commit/79d986bd35b49a819dc875cfec69ec8685517930)), closes [#1437](https://github.com/googleapis/gapic-generator-java/issues/1437)
* Validate paths and check additionalPathTemplates ([#1522](https://github.com/googleapis/gapic-generator-java/issues/1522)) ([5173014](https://github.com/googleapis/gapic-generator-java/commit/5173014b041001bf6c95209404f31db39347717d))


### Dependencies

* Update dependency com.google.cloud:google-iam-policy to v1.11.0 ([#1505](https://github.com/googleapis/gapic-generator-java/issues/1505)) ([56a1104](https://github.com/googleapis/gapic-generator-java/commit/56a11046f4349f97e3c272a92cd75acfb5c9e74c))
* Update dependency org.threeten:threetenbp to v1.6.6 ([#1543](https://github.com/googleapis/gapic-generator-java/issues/1543)) ([4afc5d8](https://github.com/googleapis/gapic-generator-java/commit/4afc5d80b9a89f0b3241ce62a2348894afd34e1b))
* Update dependency org.threeten:threetenbp to v1.6.6 ([#1544](https://github.com/googleapis/gapic-generator-java/issues/1544)) ([4591e5b](https://github.com/googleapis/gapic-generator-java/commit/4591e5bb8aa99acb1719422313ca3f53345a52dd))
* Update dependency org.threeten:threetenbp to v1.6.7 ([#1550](https://github.com/googleapis/gapic-generator-java/issues/1550)) ([1df3dd2](https://github.com/googleapis/gapic-generator-java/commit/1df3dd255e4af0028f9010267a45e1cf82a85f31))
* Update dependency org.threeten:threetenbp to v1.6.7 ([#1551](https://github.com/googleapis/gapic-generator-java/issues/1551)) ([b11395d](https://github.com/googleapis/gapic-generator-java/commit/b11395dd113555e91897ca78f4eaf7277c870892))
* Update google api dependencies ([#1526](https://github.com/googleapis/gapic-generator-java/issues/1526)) ([750d4f5](https://github.com/googleapis/gapic-generator-java/commit/750d4f5e489ce517d9b9a09969038556c112ebeb))
* Update netty dependencies to v4.1.90.final ([#1490](https://github.com/googleapis/gapic-generator-java/issues/1490)) ([894ba37](https://github.com/googleapis/gapic-generator-java/commit/894ba379201fe1fa8afe80ad58d17b69554b82d5))


### Documentation

* Update steps to generate a library locally ([#1539](https://github.com/googleapis/gapic-generator-java/issues/1539)) ([0ed1359](https://github.com/googleapis/gapic-generator-java/commit/0ed1359f7e07a6d231e562ef6cc9426319286bee))

## [2.15.3](https://github.com/googleapis/gapic-generator-java/compare/v2.15.2...v2.15.3) (2023-03-14)


### Bug Fixes

* Allow custom HttpRules for REST LROs ([#1288](https://github.com/googleapis/gapic-generator-java/issues/1288)) ([f8ccd2a](https://github.com/googleapis/gapic-generator-java/commit/f8ccd2a1428f96f0ff3231247964c272144b8dc9))


### Dependencies

* Update actions/checkout action to v3 ([#1365](https://github.com/googleapis/gapic-generator-java/issues/1365)) ([84036c7](https://github.com/googleapis/gapic-generator-java/commit/84036c706620a6c7aef05aeaa5969e7dd0b4674b))
* Update dependency com.google.api.grpc:grpc-google-common-protos to v2.14.2 ([#1451](https://github.com/googleapis/gapic-generator-java/issues/1451)) ([9566040](https://github.com/googleapis/gapic-generator-java/commit/95660400209c114a460a7d4170da4f093e6e3526))
* Update dependency com.google.api.grpc:grpc-google-iam-v1 to v1.9.2 ([#1452](https://github.com/googleapis/gapic-generator-java/issues/1452)) ([b30359b](https://github.com/googleapis/gapic-generator-java/commit/b30359bd2a35c3f267b58748012d080bf3f1edf8))
* Update dependency com.google.code.gson:gson to v2.10.1 ([#1443](https://github.com/googleapis/gapic-generator-java/issues/1443)) ([0ccf457](https://github.com/googleapis/gapic-generator-java/commit/0ccf457a774bd3dbe3b101d82222bdc39f6e5b0e))
* Update dependency com.google.errorprone:error_prone_annotations to v2.18.0 ([#1459](https://github.com/googleapis/gapic-generator-java/issues/1459)) ([2671dcf](https://github.com/googleapis/gapic-generator-java/commit/2671dcf9131591acaa96d474412ce414fef54a6f))
* Update dependency io.grpc:grpc-core to v1.53.0 ([#1463](https://github.com/googleapis/gapic-generator-java/issues/1463)) ([6762df6](https://github.com/googleapis/gapic-generator-java/commit/6762df6e121382545cc6da1375553f3de79acb2d))
* Update dependency io.perfmark:perfmark-api to v0.26.0 ([#1465](https://github.com/googleapis/gapic-generator-java/issues/1465)) ([174f3d8](https://github.com/googleapis/gapic-generator-java/commit/174f3d82408e569028ba5c025b1bc9823e8cdb93))
* Update dependency net.bytebuddy:byte-buddy to v1.14.1 ([#1467](https://github.com/googleapis/gapic-generator-java/issues/1467)) ([c0d851a](https://github.com/googleapis/gapic-generator-java/commit/c0d851a2afde63b07a620771177c6eb2cf29dc25))
* Update dependency net.bytebuddy:byte-buddy to v1.14.2 ([#1481](https://github.com/googleapis/gapic-generator-java/issues/1481)) ([cbceed2](https://github.com/googleapis/gapic-generator-java/commit/cbceed21237a5dba62cc318ad0c1903a8d7768f3))
* Update dependency org.apache.commons:commons-lang3 to v3.12.0 ([#1468](https://github.com/googleapis/gapic-generator-java/issues/1468)) ([2506b91](https://github.com/googleapis/gapic-generator-java/commit/2506b91196f8cbf7f7297af15e01529e7ee51270))
* Update dependency org.graalvm.sdk:graal-sdk to v22.3.1 ([#1444](https://github.com/googleapis/gapic-generator-java/issues/1444)) ([edb5d12](https://github.com/googleapis/gapic-generator-java/commit/edb5d12689400d0a127b240fc68f12c00e7db0a8))
* Update dependency org.threeten:threetenbp to v1.6.5 ([#1446](https://github.com/googleapis/gapic-generator-java/issues/1446)) ([842b9e3](https://github.com/googleapis/gapic-generator-java/commit/842b9e398caa6ea273d790c0bc577e7ec22cad39))
* Update google api dependencies ([#1470](https://github.com/googleapis/gapic-generator-java/issues/1470)) ([e1667f1](https://github.com/googleapis/gapic-generator-java/commit/e1667f1a0eee9a3b9977eae6ee2ae27e06185ad9))
* Update google auth library dependencies to v1.16.0 ([#1471](https://github.com/googleapis/gapic-generator-java/issues/1471)) ([de67f4e](https://github.com/googleapis/gapic-generator-java/commit/de67f4e2c772ecb1b4a8f7a3d58c5bce564cf788))
* Update google http client dependencies to v1.43.0 ([#1472](https://github.com/googleapis/gapic-generator-java/issues/1472)) ([524eddb](https://github.com/googleapis/gapic-generator-java/commit/524eddb17488701d0217ee270cdba804b2f8d09b))
* Update google http client dependencies to v1.43.1 ([#1487](https://github.com/googleapis/gapic-generator-java/issues/1487)) ([da52fdd](https://github.com/googleapis/gapic-generator-java/commit/da52fdd34c6c1c9d329ff6d1834eee2311ed80c6))
* Update netty dependencies ([#1448](https://github.com/googleapis/gapic-generator-java/issues/1448)) ([97079ef](https://github.com/googleapis/gapic-generator-java/commit/97079ef6b0115d7ed14ffd6060d63b03c0cbd4fd))

## [2.15.2](https://github.com/googleapis/gapic-generator-java/compare/v2.15.1...v2.15.2) (2023-02-28)


### Bug Fixes

* Change the default scope of gax from implementation to api in auto-generated gradle files for self-service client libraries. ([#1374](https://github.com/googleapis/gapic-generator-java/issues/1374)) ([eee7573](https://github.com/googleapis/gapic-generator-java/commit/eee757347a93f75e767870c90814322b29ed5275))


### Dependencies

* Update dependency com.google.http-client:google-http-client-bom to v1.43.0 ([#1377](https://github.com/googleapis/gapic-generator-java/issues/1377)) ([df3e35f](https://github.com/googleapis/gapic-generator-java/commit/df3e35f862724b4465a886f716afa8dd0b23d27f))
* Update dependency gradle to v7.6.1 ([#1376](https://github.com/googleapis/gapic-generator-java/issues/1376)) ([5d61dcb](https://github.com/googleapis/gapic-generator-java/commit/5d61dcb1ef504ba0553c9ae33faab363b5650f4f))

## [2.15.1](https://github.com/googleapis/gapic-generator-java/compare/v2.15.0...v2.15.1) (2023-02-15)


### Bug Fixes

* **batcher:** Exceptions in unaryCaller bubble up ([#1166](https://github.com/googleapis/gapic-generator-java/issues/1166)) ([bcf5ed8](https://github.com/googleapis/gapic-generator-java/commit/bcf5ed856d664f84fa033cee0cc27fb57b97b678))
* **deps:** Update dependency com.google.auth:google-auth-library-bom to v1.16.0 ([#1355](https://github.com/googleapis/gapic-generator-java/issues/1355)) ([b7de1bc](https://github.com/googleapis/gapic-generator-java/commit/b7de1bc260a641e0c0ca717a33d61fbaa8a2fcf6))
* **deps:** Update dependency io.grpc:grpc-bom to v1.53.0 ([#1345](https://github.com/googleapis/gapic-generator-java/issues/1345)) ([1e82422](https://github.com/googleapis/gapic-generator-java/commit/1e824223afa0b8a62e9e50ae38cc73e8036e6348))
* Use pkg_tar from rules_pkg ([#1303](https://github.com/googleapis/gapic-generator-java/issues/1303)) ([fbae565](https://github.com/googleapis/gapic-generator-java/commit/fbae565291aee092acab3df86de858aea129b670))

## [2.15.0](https://github.com/googleapis/gapic-generator-java/compare/v2.14.0...v2.15.0) (2023-02-02)


### Features

* Do not generate Service REST code if there are no matching RPC in a Service ([#1236](https://github.com/googleapis/gapic-generator-java/issues/1236)) ([9c06bc9](https://github.com/googleapis/gapic-generator-java/commit/9c06bc95b9aac869bf21c343cbb4b857aa25b593))


### Bug Fixes

* **ast:** Update import generation to cover annotation parameters ([#1229](https://github.com/googleapis/gapic-generator-java/issues/1229)) ([bdf12b0](https://github.com/googleapis/gapic-generator-java/commit/bdf12b0df91446abac8cb1bf2d361bb886eb91a2))
* **deps:** Update dependency com.google.auth:google-auth-library-bom to v1.15.0 ([#1278](https://github.com/googleapis/gapic-generator-java/issues/1278)) ([f80861b](https://github.com/googleapis/gapic-generator-java/commit/f80861ba0518be2b9774b3235535f4bd3a27216a))
* **java:** Initialize netty-shaded at run-time and add reflection configurations for netty classes ([#1290](https://github.com/googleapis/gapic-generator-java/issues/1290)) ([b7ca95f](https://github.com/googleapis/gapic-generator-java/commit/b7ca95f12dfe8287c133e09534be1fc46882ce6c))
* Support mvn fmt:check and fmt:format ([#1266](https://github.com/googleapis/gapic-generator-java/issues/1266)) ([c96a2e7](https://github.com/googleapis/gapic-generator-java/commit/c96a2e7cf647cf245199c33ad989c8050208646e))

## [2.14.0](https://github.com/googleapis/gapic-generator-java/compare/v2.13.0...v2.14.0) (2023-01-19)


### Features

* Add callable getters for non-eligible or non-enabled REST methods ([#1211](https://github.com/googleapis/gapic-generator-java/issues/1211)) ([84a1355](https://github.com/googleapis/gapic-generator-java/commit/84a1355a6db4754404196f153958359f9ba55437))
* Add the google.rpc.context.AuditContext and google.rpc.http message to the open source ([#1248](https://github.com/googleapis/gapic-generator-java/issues/1248)) ([1538ad8](https://github.com/googleapis/gapic-generator-java/commit/1538ad8e88db7e03ed14337b83c0ddfae287538e))
* Update JavaDoc to use [@return](https://github.com/return) ([#1233](https://github.com/googleapis/gapic-generator-java/issues/1233)) ([d13d3c3](https://github.com/googleapis/gapic-generator-java/commit/d13d3c381bb64e1833cbc443a12781084e89494b))


### Bug Fixes

* Add native image reflect-config.json to gax-grpc ([#1251](https://github.com/googleapis/gapic-generator-java/issues/1251)) ([ff2d118](https://github.com/googleapis/gapic-generator-java/commit/ff2d118341dfc95f34bcf114b005625d2fc930f6))
* **deps:** Update dependency com.google.api:api-common to v2.4.0 ([#1228](https://github.com/googleapis/gapic-generator-java/issues/1228)) ([422315e](https://github.com/googleapis/gapic-generator-java/commit/422315ef0ee35740a2772eaa59cfc757ee499e28))
* **deps:** Update dependency com.google.code.gson:gson to v2.10.1 ([#1219](https://github.com/googleapis/gapic-generator-java/issues/1219)) ([5a3aed2](https://github.com/googleapis/gapic-generator-java/commit/5a3aed2a8f9a89657d5a8ea858b668ff6ab92b96))
* **deps:** Update dependency com.google.errorprone:error_prone_annotations to v2.18.0 ([#1231](https://github.com/googleapis/gapic-generator-java/issues/1231)) ([746cc9d](https://github.com/googleapis/gapic-generator-java/commit/746cc9d28809636afdecc85833a2122ec4fbeb76))
* **deps:** Update dependency com.google.errorprone:error_prone_annotations to v2.18.0 ([#1232](https://github.com/googleapis/gapic-generator-java/issues/1232)) ([467ea48](https://github.com/googleapis/gapic-generator-java/commit/467ea485a32bcb3e9c0f69274edfd66a595e70d8))
* **deps:** Update dependency io.grpc:grpc-bom to v1.52.1 ([#1240](https://github.com/googleapis/gapic-generator-java/issues/1240)) ([89e0fa2](https://github.com/googleapis/gapic-generator-java/commit/89e0fa2f4efdc48a5d6dbd59706beeae4793f3f3))
* **deps:** Update dependency io.grpc:grpc-protobuf to v1.52.1 ([#1241](https://github.com/googleapis/gapic-generator-java/issues/1241)) ([f30d96c](https://github.com/googleapis/gapic-generator-java/commit/f30d96c9b9333c48e2d0067af1324bc9447f3580))
* **deps:** Update dependency io.grpc:grpc-stub to v1.52.1 ([#1242](https://github.com/googleapis/gapic-generator-java/issues/1242)) ([44cef75](https://github.com/googleapis/gapic-generator-java/commit/44cef75afc94516632d1e7e04beffa2a2c7c56d0))
* **deps:** Update dependency org.graalvm.sdk:graal-sdk to v22.3.1 ([#1252](https://github.com/googleapis/gapic-generator-java/issues/1252)) ([328f4e1](https://github.com/googleapis/gapic-generator-java/commit/328f4e1fb82fb3e413725f0b5a27e05fc45a800d))
* Handle cancel in ReleasingClientCall and rethrow the exception in start ([#1221](https://github.com/googleapis/gapic-generator-java/issues/1221)) ([8a61249](https://github.com/googleapis/gapic-generator-java/commit/8a6124950ba51f79f0a42afd20f758e937002b35))
* Rename gapic-parent-pom to groupId to google.cloud.api ([#1238](https://github.com/googleapis/gapic-generator-java/issues/1238)) ([7e6e750](https://github.com/googleapis/gapic-generator-java/commit/7e6e75062eacad157c92c7c9063dcb1899a9953d))

## [2.13.0](https://github.com/googleapis/gapic-generator-java/compare/v2.12.0...v2.13.0) (2023-01-06)


### Features

* Parent pom and gapic-generator-java-bom ([#1170](https://github.com/googleapis/gapic-generator-java/issues/1170)) ([4dd5fcf](https://github.com/googleapis/gapic-generator-java/commit/4dd5fcf7b817c56bcfd90c3977bf003f212fbddf))
* Use gapic-generator-java jar in the client library generation process ([#918](https://github.com/googleapis/gapic-generator-java/issues/918)) ([0051f49](https://github.com/googleapis/gapic-generator-java/commit/0051f4939727ca818509332d78ba8fbbe98ea2c8))


### Bug Fixes

* **deps:** Update dependency com.google.auth:google-auth-library-oauth2-http to v1.14.0 ([#1183](https://github.com/googleapis/gapic-generator-java/issues/1183)) ([45fd2cb](https://github.com/googleapis/gapic-generator-java/commit/45fd2cbf4713ef070b7a78133169668541a14e74))
* **deps:** Update dependency com.google.auto.value:auto-value-annotations to v1.10.1 ([#1184](https://github.com/googleapis/gapic-generator-java/issues/1184)) ([e2e01a0](https://github.com/googleapis/gapic-generator-java/commit/e2e01a01b7b222f629ddb3b57fe2537a5d3906de))
* **deps:** Update dependency com.google.cloud:google-iam-policy to v1.6.22 ([#1145](https://github.com/googleapis/gapic-generator-java/issues/1145)) ([83f3aec](https://github.com/googleapis/gapic-generator-java/commit/83f3aec3d920bca422b12f91f007081d49d0c4cb))
* **deps:** Update dependency com.google.cloud:libraries-bom to v26.2.0 ([#1185](https://github.com/googleapis/gapic-generator-java/issues/1185)) ([83766f1](https://github.com/googleapis/gapic-generator-java/commit/83766f1c180b756e58bf8c147ea697fbe51a4d13))
* **deps:** Update dependency com.google.errorprone:error_prone_annotations to v2.17.0 - abandoned ([#1205](https://github.com/googleapis/gapic-generator-java/issues/1205)) ([031fff6](https://github.com/googleapis/gapic-generator-java/commit/031fff6f99694b6035c134fe96b7bef1a6143111))
* **deps:** Update dependency com.google.errorprone:error_prone_annotations to v2.17.0 ([#1202](https://github.com/googleapis/gapic-generator-java/issues/1202)) ([c9a35b9](https://github.com/googleapis/gapic-generator-java/commit/c9a35b9eb04e1db8b30a81547afb170947f630ec))
* **deps:** Update dependency com.google.guava:guava to v31.1-jre ([#1146](https://github.com/googleapis/gapic-generator-java/issues/1146)) ([e70f7f6](https://github.com/googleapis/gapic-generator-java/commit/e70f7f6d6e13ab6ddb2a91d378ddd2b286e8902b))
* **deps:** Update dependency com.google.protobuf:protobuf-bom to v3.21.12 ([#1116](https://github.com/googleapis/gapic-generator-java/issues/1116)) ([41a220c](https://github.com/googleapis/gapic-generator-java/commit/41a220c227195c159fd408b8df07df7f3e7332cd))
* **deps:** Update dependency com.google.protobuf:protobuf-java to v3.21.12 ([#1155](https://github.com/googleapis/gapic-generator-java/issues/1155)) ([ddb7edf](https://github.com/googleapis/gapic-generator-java/commit/ddb7edfa261540927db240363d3ec5715db2b3db))
* **deps:** Update dependency io.grpc:grpc-bom to v1.51.1 ([#1137](https://github.com/googleapis/gapic-generator-java/issues/1137)) ([582c796](https://github.com/googleapis/gapic-generator-java/commit/582c796ee9dacc3a127aef0821c40afd8eb537ef))
* **deps:** Update dependency io.grpc:grpc-bom to v1.51.1 ([#1157](https://github.com/googleapis/gapic-generator-java/issues/1157)) ([7528b45](https://github.com/googleapis/gapic-generator-java/commit/7528b45fb2e8a5046c931dc28619ef17143810ed))
* **deps:** Update dependency io.grpc:grpc-protobuf to v1.51.1 ([#1158](https://github.com/googleapis/gapic-generator-java/issues/1158)) ([14081a1](https://github.com/googleapis/gapic-generator-java/commit/14081a1048d030748abeb200b26e6ca9add7ba8e))
* **deps:** Update dependency io.grpc:grpc-stub to v1.51.1 ([#1159](https://github.com/googleapis/gapic-generator-java/issues/1159)) ([8745b57](https://github.com/googleapis/gapic-generator-java/commit/8745b570a033563a44e0d8f9763c2a03e2fa77b2))
* **deps:** Update dependency jacoco to v0.8.8 ([#1204](https://github.com/googleapis/gapic-generator-java/issues/1204)) ([8c5e17b](https://github.com/googleapis/gapic-generator-java/commit/8c5e17ba325b7711f9ba9501992ab48e736ffc18))
* **deps:** Update dependency org.mockito:mockito-core to v4.10.0 ([#1186](https://github.com/googleapis/gapic-generator-java/issues/1186)) ([1d791fb](https://github.com/googleapis/gapic-generator-java/commit/1d791fb932052b9e72ec5aabd0cb2fde36ed7a55))
* **deps:** Update dependency org.mockito:mockito-core to v4.11.0 ([#1200](https://github.com/googleapis/gapic-generator-java/issues/1200)) ([25c7b26](https://github.com/googleapis/gapic-generator-java/commit/25c7b266edf1d2e1332bab8fbfe28486cb237ed6))
* **deps:** Update dependency org.threeten:threetenbp to v1.6.5 ([#1160](https://github.com/googleapis/gapic-generator-java/issues/1160)) ([53be6b7](https://github.com/googleapis/gapic-generator-java/commit/53be6b7cfd0928675518cf5ba4784ce57c973993))
* Focus 'Running the Plugin' documentation on googleapis, not showcase ([#1196](https://github.com/googleapis/gapic-generator-java/issues/1196)) ([d58b2e5](https://github.com/googleapis/gapic-generator-java/commit/d58b2e53238d42477ac246eefe9166192618180a))


### Documentation

* Development with local gapic-generator-java ([#1132](https://github.com/googleapis/gapic-generator-java/issues/1132)) ([079d830](https://github.com/googleapis/gapic-generator-java/commit/079d830a234bb6923f3b71894f40fd0fc31649e6))
* Development with local gapic-generator-java ([#1132](https://github.com/googleapis/gapic-generator-java/issues/1132)) ([cbb9dce](https://github.com/googleapis/gapic-generator-java/commit/cbb9dce85438942f7b4f1b163756e311f54d75ea))

## [2.12.0](https://github.com/googleapis/gapic-generator-java/compare/v2.11.0...v2.12.0) (2022-12-09)


### Features

* Add scripts to release gapic-generator-java as jar ([#1111](https://github.com/googleapis/gapic-generator-java/issues/1111)) ([7941cc5](https://github.com/googleapis/gapic-generator-java/commit/7941cc5d7b3aca732d27b4f00eae18a145f8c459))


### Bug Fixes

* Sonar coverage for non-standard directory structure ([#1108](https://github.com/googleapis/gapic-generator-java/issues/1108)) ([60dc190](https://github.com/googleapis/gapic-generator-java/commit/60dc1904676b1ede343b84998658eca2e20cc56a))


### Dependencies

* Explicitly declare dependencies instead of using shared-dependencies-bom ([#1115](https://github.com/googleapis/gapic-generator-java/issues/1115)) ([402d565](https://github.com/googleapis/gapic-generator-java/commit/402d565e318b31199f3765b3bf82528fb189255d))

## [2.11.0](https://github.com/googleapis/gapic-generator-java/compare/v2.10.3...v2.11.0) (2022-11-30)


### Features

* **ast:** Array expressions ([#1080](https://github.com/googleapis/gapic-generator-java/issues/1080)) ([bd9532c](https://github.com/googleapis/gapic-generator-java/commit/bd9532c6663f2e8f9d9978cd0a3cffde821960ec))


### Bug Fixes

* **ast:** Add import generation for annotations on VariableExpr ([#1076](https://github.com/googleapis/gapic-generator-java/issues/1076)) ([f5d5524](https://github.com/googleapis/gapic-generator-java/commit/f5d5524e626f26ef53d4ae6c02118ef70ace205a))
* **deps:** Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.6 ([#1088](https://github.com/googleapis/gapic-generator-java/issues/1088)) ([0e75338](https://github.com/googleapis/gapic-generator-java/commit/0e75338dcb083c4cccd35d8682ba9cbe4e314ef8))
* Support testing nested argument method signatures and 'double' field assertions ([#1094](https://github.com/googleapis/gapic-generator-java/issues/1094)) ([4bf419f](https://github.com/googleapis/gapic-generator-java/commit/4bf419f764e2ecfdac9caf03968f40a8cd564655))

## [2.10.3](https://github.com/googleapis/gapic-generator-java/compare/v2.10.2...v2.10.3) (2022-11-01)


### Bug Fixes

* Fix REST transport client creation generated javadoc sample ([#1077](https://github.com/googleapis/gapic-generator-java/issues/1077)) ([9ac0ca8](https://github.com/googleapis/gapic-generator-java/commit/9ac0ca80b09077f7880f0029b5d7b090a10a10b8))
* Fixes regionTag breakage ([#1068](https://github.com/googleapis/gapic-generator-java/issues/1068)) ([bed9f72](https://github.com/googleapis/gapic-generator-java/commit/bed9f721fbafb5f2e974b6f43f8455f2fdb581f7))

## [2.10.2](https://github.com/googleapis/gapic-generator-java/compare/v2.10.1...v2.10.2) (2022-10-24)


### Bug Fixes

* **deps:** Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.5 ([#1063](https://github.com/googleapis/gapic-generator-java/issues/1063)) ([80ed62c](https://github.com/googleapis/gapic-generator-java/commit/80ed62cf6aff395d150e394a44fb60da37e9a6ae))
* Update regionTag to use service name ([#1047](https://github.com/googleapis/gapic-generator-java/issues/1047)) ([68b33c2](https://github.com/googleapis/gapic-generator-java/commit/68b33c23948ffe7a2bf6acd53731d786257f6bd1))

## [2.10.1](https://github.com/googleapis/gapic-generator-java/compare/v2.10.0...v2.10.1) (2022-10-20)


### Bug Fixes

* **deps:** Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.2 ([#1035](https://github.com/googleapis/gapic-generator-java/issues/1035)) ([f76634a](https://github.com/googleapis/gapic-generator-java/commit/f76634af8497ef2977376af570d175eb0fe91e6f))
* **deps:** Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.3 ([#1039](https://github.com/googleapis/gapic-generator-java/issues/1039)) ([9d25e47](https://github.com/googleapis/gapic-generator-java/commit/9d25e477126db35efd111a2b8ee76332b549ce91))
* **deps:** Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.4 ([#1050](https://github.com/googleapis/gapic-generator-java/issues/1050)) ([3b052e2](https://github.com/googleapis/gapic-generator-java/commit/3b052e27bb704124ae3214dd3e8708f8e32afe6c))
* **deps:** Update dependency org.yaml:snakeyaml to v1.32 ([#1037](https://github.com/googleapis/gapic-generator-java/issues/1037)) ([b520aa0](https://github.com/googleapis/gapic-generator-java/commit/b520aa0d35407daf96123d63c3112b9f29715115))
* **deps:** Update dependency org.yaml:snakeyaml to v1.33 ([#1043](https://github.com/googleapis/gapic-generator-java/issues/1043)) ([67a5dc5](https://github.com/googleapis/gapic-generator-java/commit/67a5dc5e4dd3302ececd212dd047f5731c4bf74d))
* Get numeric value for Enum fields if it is configured as query param or path param ([#1042](https://github.com/googleapis/gapic-generator-java/issues/1042)) ([0fdfa67](https://github.com/googleapis/gapic-generator-java/commit/0fdfa67fec84e1983c12b10c7b7ae7a0efa80f4d))
* Update sample region tag to parse host instead of proto package ([#1040](https://github.com/googleapis/gapic-generator-java/issues/1040)) ([01c14d4](https://github.com/googleapis/gapic-generator-java/commit/01c14d41d4195963c0ed46f310360f39eec6d420))

## [2.10.0](https://github.com/googleapis/gapic-generator-java/compare/v2.9.0...v2.10.0) (2022-09-06)


### Features

* Add support for rest numeric enums. ([#1020](https://github.com/googleapis/gapic-generator-java/issues/1020)) ([0a89829](https://github.com/googleapis/gapic-generator-java/commit/0a898299a6adb28dec6ce2af762827a434242311))
* **ast:** Extend support for annotation named parameters ([#1012](https://github.com/googleapis/gapic-generator-java/issues/1012)) ([5d3ff75](https://github.com/googleapis/gapic-generator-java/commit/5d3ff75db429d6dd43b0c3fc5dd4bfcb5ad06ae4))
* Update autogenerated snippet disclaimer ([#1029](https://github.com/googleapis/gapic-generator-java/issues/1029)) ([16f26f6](https://github.com/googleapis/gapic-generator-java/commit/16f26f63aa61b4ac4d42a1548a868fc1dd49c0eb))


### Bug Fixes

* **ast:** Removed lambda void return type check ([#1019](https://github.com/googleapis/gapic-generator-java/issues/1019)) ([317eff6](https://github.com/googleapis/gapic-generator-java/commit/317eff6cc3f5dc46896465d47a0d5135ed8dd0d2))
* **bazel:** Do not emit empty rm commands ([#1027](https://github.com/googleapis/gapic-generator-java/issues/1027)) ([7064f4c](https://github.com/googleapis/gapic-generator-java/commit/7064f4c6095f47895ec86712b5a3c73a66a76e3c))
* **bazel:** Do not print current working directory ([#1028](https://github.com/googleapis/gapic-generator-java/issues/1028)) ([5d94f1d](https://github.com/googleapis/gapic-generator-java/commit/5d94f1dc0fad961774f884e6cb1dc210f925f57d))
* **deps:** Update dependency com.google.cloud ([27a8aa2](https://github.com/googleapis/gapic-generator-java/commit/27a8aa21766589c044a2f2db2b46e20e4321cf59))
* **deps:** Update dependency com.google.cloud ([883fafa](https://github.com/googleapis/gapic-generator-java/commit/883fafa409e74a3943f147e01c7a100e9336e4a9))
* **deps:** Update dependency org.yaml ([56fd1ea](https://github.com/googleapis/gapic-generator-java/commit/56fd1ea51c949fa87ced1a5680b5542953097914))

## [2.9.0](https://github.com/googleapis/gapic-generator-java/compare/v2.8.3...v2.9.0) (2022-07-11)


### Features

* **ast:** add support for LambdaExpr to infer type from return expr type ([#1011](https://github.com/googleapis/gapic-generator-java/issues/1011)) ([a179558](https://github.com/googleapis/gapic-generator-java/commit/a1795582948d6c721544b920c86a4642df3b39a0))

## [2.8.3](https://github.com/googleapis/gapic-generator-java/compare/v2.8.2...v2.8.3) (2022-06-27)


### Bug Fixes

* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v2.13.0 ([#1009](https://github.com/googleapis/gapic-generator-java/issues/1009)) ([9dcc470](https://github.com/googleapis/gapic-generator-java/commit/9dcc4705ba429ed63468033711b2043386ab5dd3))
* Fix mixin mock service and gradle build generation ([#1010](https://github.com/googleapis/gapic-generator-java/issues/1010)) ([d896e6e](https://github.com/googleapis/gapic-generator-java/commit/d896e6e1b052a9da5ef1304220ec88017a24991d))
* make `BetaApi` the `getHttpJsonOperationsClient()` in case of multitransport clients ([#1007](https://github.com/googleapis/gapic-generator-java/issues/1007)) ([badd554](https://github.com/googleapis/gapic-generator-java/commit/badd5544d1cd7e03e8c1b282aac4954acb1bb5f0))

## [2.8.2](https://github.com/googleapis/gapic-generator-java/compare/v2.8.1...v2.8.2) (2022-06-14)


### Bug Fixes

* Fix typo in generated comment ([#1006](https://github.com/googleapis/gapic-generator-java/issues/1006)) ([14e76e7](https://github.com/googleapis/gapic-generator-java/commit/14e76e73802ec05f2fe4a820ab10c2dbf7321c6d))
* Remove HttpMethod compile time dependency from genrated HttpJson stubs ([#1004](https://github.com/googleapis/gapic-generator-java/issues/1004)) ([e5988a0](https://github.com/googleapis/gapic-generator-java/commit/e5988a0e4900efd1943e942f445f1e86fdd6b05c))

## [2.8.1](https://github.com/googleapis/gapic-generator-java/compare/v2.8.0...v2.8.1) (2022-06-09)


### Bug Fixes

* More REST transport fixes ([#1003](https://github.com/googleapis/gapic-generator-java/issues/1003)) ([2bed7cf](https://github.com/googleapis/gapic-generator-java/commit/2bed7cf4f4168977ccb413125c6bcb43422061fd))
* Multiple REST transport related fixes ([#997](https://github.com/googleapis/gapic-generator-java/issues/997)) ([61e2e96](https://github.com/googleapis/gapic-generator-java/commit/61e2e9660fa62536163982f3241fcc479973e163))
* use correct paginated field name ([#1001](https://github.com/googleapis/gapic-generator-java/issues/1001)) ([7f186b5](https://github.com/googleapis/gapic-generator-java/commit/7f186b551f14cc14a503b552ef73c52d9e491628))

## [2.8.0](https://github.com/googleapis/gapic-generator-java/compare/v2.7.0...v2.8.0) (2022-05-21)


### Features

* Add support for additional_bindings ([#993](https://github.com/googleapis/gapic-generator-java/issues/993)) ([ce58c18](https://github.com/googleapis/gapic-generator-java/commit/ce58c181691d0be826634d1bd8373f07c1295156))


### Bug Fixes

* [REGAPIC] Fix repeated fields handling for query parameters ([#989](https://github.com/googleapis/gapic-generator-java/issues/989)) ([f7ceab9](https://github.com/googleapis/gapic-generator-java/commit/f7ceab9ee53b34b2114b77bb4bebb693ad6989a7))
* [REGAPIC] Fix snake_case nested resource names in generated unit tests ([#990](https://github.com/googleapis/gapic-generator-java/issues/990)) ([b8e3ae4](https://github.com/googleapis/gapic-generator-java/commit/b8e3ae4c0ebe98d757acb079987d96b281aec1f5))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v2.11.0 ([#995](https://github.com/googleapis/gapic-generator-java/issues/995)) ([df7e08e](https://github.com/googleapis/gapic-generator-java/commit/df7e08ebdf76b8dfb4b9961d3c8670f8e95c788c))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v2.12.0 ([#996](https://github.com/googleapis/gapic-generator-java/issues/996)) ([4673e52](https://github.com/googleapis/gapic-generator-java/commit/4673e5206b4535d2e691b5c0b8cffaa5b35c4ca1))
* Fix `BetaApi` annotaiton usage for REST transport and clean `BetaApi` for default stubs in all transports ([#987](https://github.com/googleapis/gapic-generator-java/issues/987)) ([d22b966](https://github.com/googleapis/gapic-generator-java/commit/d22b966703644ea150b9ceee6df39cde17cf8df4))

## [2.7.0](https://github.com/googleapis/gapic-generator-java/compare/v2.6.1...v2.7.0) (2022-04-29)


### Features

* Add add autogenerated javadoc sample for selecting REST transport over gRPC ([#983](https://github.com/googleapis/gapic-generator-java/issues/983)) ([051713d](https://github.com/googleapis/gapic-generator-java/commit/051713dec7706713900b8708e3a6b9ab0639438e))
* inline disclaimer comment, use Sample/RegionTag, collect GapicClass samples (pt 2) ([#970](https://github.com/googleapis/gapic-generator-java/issues/970)) ([f8b3616](https://github.com/googleapis/gapic-generator-java/commit/f8b36168372118d6ed639263bae192647912ed43))
* SampleComposer, Sample, Region Tag (pt1) ([#933](https://github.com/googleapis/gapic-generator-java/issues/933)) ([b7cf105](https://github.com/googleapis/gapic-generator-java/commit/b7cf105764bdc6c0a952e7b2705a454bbce3eadf))
* write samples to file (pt3) ([#980](https://github.com/googleapis/gapic-generator-java/issues/980)) ([04a6665](https://github.com/googleapis/gapic-generator-java/commit/04a66659f3724d125206b09ad6cf9544d064e8ae))


### Bug Fixes

* allow empty services and java keywords as a method names ([#985](https://github.com/googleapis/gapic-generator-java/issues/985)) ([e37893c](https://github.com/googleapis/gapic-generator-java/commit/e37893c37e333c947b75f55b1974045509d171d4))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v2.10.0 ([#982](https://github.com/googleapis/gapic-generator-java/issues/982)) ([9e863f8](https://github.com/googleapis/gapic-generator-java/commit/9e863f8b7b0407cb1a58aba5952f54b56d15167f))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v2.8.0 ([#959](https://github.com/googleapis/gapic-generator-java/issues/959)) ([0ca7a21](https://github.com/googleapis/gapic-generator-java/commit/0ca7a21df4fbae041e96b97a7235eff01195f429))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v2.9.0 ([#973](https://github.com/googleapis/gapic-generator-java/issues/973)) ([8fa9f07](https://github.com/googleapis/gapic-generator-java/commit/8fa9f07123e5b2837ce2cd7fc6cf8bbed43ae2ae))
* **deps:** update dependency junit:junit to v4.13.2 ([#940](https://github.com/googleapis/gapic-generator-java/issues/940)) ([09c69f7](https://github.com/googleapis/gapic-generator-java/commit/09c69f723fd868d767b88467ed3c496461876c75))
* **deps:** update dependency org.yaml:snakeyaml to v1.30 ([#946](https://github.com/googleapis/gapic-generator-java/issues/946)) ([996c8c3](https://github.com/googleapis/gapic-generator-java/commit/996c8c38bc7d9e5730bdaf99fdd5b20aee5cd9b8))
* setups for manually runs single JUnit test ([7ab9ae3](https://github.com/googleapis/gapic-generator-java/commit/7ab9ae30d71e755877061596bfba8f6c87e0f66b))
* Update copyright to 2022 for newly generated files. ([#951](https://github.com/googleapis/gapic-generator-java/issues/951)) ([a6ad7d9](https://github.com/googleapis/gapic-generator-java/commit/a6ad7d9988fc9e42b371082130e3b7f6bab75719))

### [2.6.1](https://github.com/googleapis/gapic-generator-java/compare/v2.6.0...v2.6.1) (2022-02-11)


### Bug Fixes

* Routing annotation was not recognized on parsing protos ([#928](https://github.com/googleapis/gapic-generator-java/issues/928)) ([2ce9f42](https://github.com/googleapis/gapic-generator-java/commit/2ce9f42ce23e91ff4f559d6a44be57df9f97eb46))

## [2.6.0](https://github.com/googleapis/gapic-generator-java/compare/v2.5.0...v2.6.0) (2022-01-28)


### Features

* Support explicit dynamic routing header ([#887](https://github.com/googleapis/gapic-generator-java/issues/887)) ([bcc1bdb](https://github.com/googleapis/gapic-generator-java/commit/bcc1bdb5fdf57d8843a03318d746df7d8392d848))


### Bug Fixes

* increase default memory for Gradle builds on generated libraries ([#907](https://github.com/googleapis/gapic-generator-java/issues/907)) ([d210aa1](https://github.com/googleapis/gapic-generator-java/commit/d210aa193d45ba5fbdea6ae5f31e471401c27cb7))

## [2.5.0](https://github.com/googleapis/gapic-generator-java/compare/v2.4.1...v2.5.0) (2022-01-22)


### Features

* add server streaming support for REST transport ([#902](https://github.com/googleapis/gapic-generator-java/issues/902)) ([3b2dec6](https://github.com/googleapis/gapic-generator-java/commit/3b2dec6adf46823eeb6859e93362e63f00d84ffc))
* make generated test values comply with url path template ([#903](https://github.com/googleapis/gapic-generator-java/issues/903)) ([bfb35cd](https://github.com/googleapis/gapic-generator-java/commit/bfb35cd31c05b5fbd2ea8073bcdcfdd3496bca12))

### [2.4.1](https://github.com/googleapis/gapic-generator-java/compare/v2.4.0...v2.4.1) (2022-01-14)


### Bug Fixes

* expose extra deps transitively to library users ([#899](https://github.com/googleapis/gapic-generator-java/issues/899)) ([8fa2660](https://github.com/googleapis/gapic-generator-java/commit/8fa2660022cf65ebed011165378683173989332b))
* fix broken Gradle allJars task on generated libs ([#901](https://github.com/googleapis/gapic-generator-java/issues/901)) ([e990105](https://github.com/googleapis/gapic-generator-java/commit/e99010596d85f891a738de71be3b5fb9c857594a))

## [2.4.0](https://github.com/googleapis/gapic-generator-java/compare/v2.3.1...v2.4.0) (2022-01-11)


### Features

* add `install` "alias" for local publication ([#897](https://github.com/googleapis/gapic-generator-java/issues/897)) ([662d1ba](https://github.com/googleapis/gapic-generator-java/commit/662d1ba2dab831a7927159b85c196caf28f13cc7))

### [2.3.1](https://www.github.com/googleapis/gapic-generator-java/compare/v2.3.0...v2.3.1) (2022-01-10)


### Bug Fixes

* fix Gradle build error for sourcesJar task on generated libs ([#894](https://www.github.com/googleapis/gapic-generator-java/issues/894)) ([1060a1a](https://www.github.com/googleapis/gapic-generator-java/commit/1060a1af874d9be3f89c567635630f5ad6f8e830))

## [2.3.0](https://www.github.com/googleapis/gapic-generator-java/compare/v2.2.4...v2.3.0) (2022-01-06)


### Features

* support Java 9+ compilation of generated libs ([#889](https://www.github.com/googleapis/gapic-generator-java/issues/889)) ([83552c4](https://www.github.com/googleapis/gapic-generator-java/commit/83552c45611c5a79533d6872bf8824cc686e480d))

### [2.2.4](https://www.github.com/googleapis/gapic-generator-java/compare/v2.2.3...v2.2.4) (2022-01-04)


### Bug Fixes

* add missing dependencies in Gradle for "self-service" library generation ([#884](https://www.github.com/googleapis/gapic-generator-java/issues/884)) ([3adac5e](https://www.github.com/googleapis/gapic-generator-java/commit/3adac5e2898e40a1e5395ab65db037c26a4f7e1b))

### [2.2.3](https://www.github.com/googleapis/gapic-generator-java/compare/v2.2.2...v2.2.3) (2021-12-06)


### Bug Fixes

* **deps:** upgrade gax to 2.7.1, protobuf to 3.19.1, grpc to 1.42.1, and truth to 1.1.2, upgrade Bazel in GitHub Actions, and fix build error ([#877](https://www.github.com/googleapis/gapic-generator-java/issues/877)) ([1597707](https://www.github.com/googleapis/gapic-generator-java/commit/1597707e8d525f8abaa058bc0fdcbd3a825032c9))

### [2.2.2](https://www.github.com/googleapis/gapic-generator-java/compare/v2.2.1...v2.2.2) (2021-11-05)


### Bug Fixes

* **resnames:** ensure determinstic code generation ([#865](https://www.github.com/googleapis/gapic-generator-java/issues/865)) ([680874d](https://www.github.com/googleapis/gapic-generator-java/commit/680874dcf84a5c31abc5948fa59f2cb38f14d80c))
* revert gradle version used for generated assembly packages (bazel rules) ([#872](https://www.github.com/googleapis/gapic-generator-java/issues/872)) ([4e73c9a](https://www.github.com/googleapis/gapic-generator-java/commit/4e73c9aefa3527a0b28c0d32255accf679218b81))
* Use parent type instead of child_type in method doc sample ([#862](https://www.github.com/googleapis/gapic-generator-java/issues/862)) ([6a39c7f](https://www.github.com/googleapis/gapic-generator-java/commit/6a39c7f54180154f393e88196c79cc9ebba38e52))

### [2.2.1](https://www.github.com/googleapis/gapic-generator-java/compare/v2.2.0...v2.2.1) (2021-10-25)


### Bug Fixes

* gax batching regression ([#863](https://www.github.com/googleapis/gapic-generator-java/issues/863)) ([3a6f168](https://www.github.com/googleapis/gapic-generator-java/commit/3a6f168322962d1b54ed37ff258e228e4b2f33ed))

## [2.2.0](https://www.github.com/googleapis/gapic-generator-java/compare/v2.1.0...v2.2.0) (2021-10-09)


### Features

* Add REST AIP-151 LRO suport ([cb1b534](https://www.github.com/googleapis/gapic-generator-java/commit/cb1b534701b95781e5195e57eacf6d0abff252bf))
* enable self signed JWT for http ([#850](https://www.github.com/googleapis/gapic-generator-java/issues/850)) ([aba0ec0](https://www.github.com/googleapis/gapic-generator-java/commit/aba0ec00dc912400e1c0457d971d8f4120c5d03a))
* Implement DIREGAPIC LRO annotations ([#832](https://www.github.com/googleapis/gapic-generator-java/issues/832)) ([d7b29e0](https://www.github.com/googleapis/gapic-generator-java/commit/d7b29e05d7cfda1eb1a3b09d7ad7d625cab4bde1))
* REGAPIC initial implementation ([#824](https://www.github.com/googleapis/gapic-generator-java/issues/824)) ([fdcfe70](https://www.github.com/googleapis/gapic-generator-java/commit/fdcfe705b5fb42e11dfd511ccf7fdee40bcba131))
* REGAPIC Multitransport implementation (grpc+rest) ([#833](https://www.github.com/googleapis/gapic-generator-java/issues/833)) ([445daf4](https://www.github.com/googleapis/gapic-generator-java/commit/445daf472b337520f108b485abfdbe8b20b16b01))


### Bug Fixes

* [bazel] fix rest transport handling in assembly rule ([#835](https://www.github.com/googleapis/gapic-generator-java/issues/835)) ([92f7c1c](https://www.github.com/googleapis/gapic-generator-java/commit/92f7c1cf7b343947a64943fd7ee7ffb4d67a9d5a))
* DIREGAPIC LRO generated tests logic ([#838](https://www.github.com/googleapis/gapic-generator-java/issues/838)) ([8ae8e6f](https://www.github.com/googleapis/gapic-generator-java/commit/8ae8e6f111d0f3849986cd0445d6003601ced148))
* fix diregapic-lro logic ([#834](https://www.github.com/googleapis/gapic-generator-java/issues/834)) ([957f69a](https://www.github.com/googleapis/gapic-generator-java/commit/957f69a0dc063e77b5e49da28f0a6d9a4a6c3bdb))

## [2.1.0](https://www.github.com/googleapis/gapic-generator-java/compare/v2.0.1...v2.1.0) (2021-08-17)


### Features

* enable self signed jwt for gapic clients ([#794](https://www.github.com/googleapis/gapic-generator-java/issues/794)) ([1b7ee1e](https://www.github.com/googleapis/gapic-generator-java/commit/1b7ee1e3911e1c8ecab9a94d68d7a59b437d2449))

### [2.0.1](https://www.github.com/googleapis/gapic-generator-java/compare/v2.0.0...v2.0.1) (2021-08-06)


### Bug Fixes

* bring back unused resnames for Ads ([#821](https://www.github.com/googleapis/gapic-generator-java/issues/821)) ([7fa135c](https://www.github.com/googleapis/gapic-generator-java/commit/7fa135c9aa60c9cb15880e098d36ea81b95ea488))
* **resnames:** ensure deterministic resname order for samplegen ([#813](https://www.github.com/googleapis/gapic-generator-java/issues/813)) ([c4709df](https://www.github.com/googleapis/gapic-generator-java/commit/c4709df5d8ed9f0074f7e25df5db93e9d9b35749))

## [2.0.0](https://www.github.com/googleapis/gapic-generator-java/compare/v1.0.17...v2.0.0) (2021-08-03)


### ⚠ BREAKING CHANGES

* remove Exception, unused resname classes for Java major version bump (#814)

### Features

* Lambda-ize single-method anon classes (Java 8+) ([#815](https://www.github.com/googleapis/gapic-generator-java/issues/815)) ([19b661c](https://www.github.com/googleapis/gapic-generator-java/commit/19b661cc78757e37ce93bae96eb81cb4ac32658b))
* remove Exception, unused resname classes for Java major version bump ([#814](https://www.github.com/googleapis/gapic-generator-java/issues/814)) ([8abece2](https://www.github.com/googleapis/gapic-generator-java/commit/8abece20dd20e9ac8134df04301ce5b6e2ab76ad))

### [1.0.17](https://www.github.com/googleapis/gapic-generator-java/compare/v1.0.16...v1.0.17) (2021-08-02)


### Features

* **ast:** Add support for multi-catch blocks [ggj] ([#811](https://www.github.com/googleapis/gapic-generator-java/issues/811)) ([55ef1a6](https://www.github.com/googleapis/gapic-generator-java/commit/55ef1a63427683538e48050333eedb0666635568))
* **ast:** Add support for Throwable causes [ggj] ([#801](https://www.github.com/googleapis/gapic-generator-java/issues/801)) ([7fdeece](https://www.github.com/googleapis/gapic-generator-java/commit/7fdeeced7642fefdfdc5c6e898661c72fe9d78a8))
* **ast:** support throwing all kinds of expressions ([#810](https://www.github.com/googleapis/gapic-generator-java/issues/810)) ([0817650](https://www.github.com/googleapis/gapic-generator-java/commit/0817650b35487f32d7987ba718ce71fc7551e3a0))


### Bug Fixes

* (rest transport) Add `@BetaApi` to the generated `TransportServiceFactory` class and lro-specific method ([#787](https://www.github.com/googleapis/gapic-generator-java/issues/787)) ([ebe1aef](https://www.github.com/googleapis/gapic-generator-java/commit/ebe1aefbe860a41aabd8ced5268ccc6c7efdf791))
* prevent hanging by call backgroundResources.close() on stub.close() [ggj] ([#804](https://www.github.com/googleapis/gapic-generator-java/issues/804)) ([428db97](https://www.github.com/googleapis/gapic-generator-java/commit/428db97c1534255a60530a8ed6137efc17ed56f4))
* **resnames:** fallback to fully-qualified Object name upon proto typing conflicts [ggj] ([#803](https://www.github.com/googleapis/gapic-generator-java/issues/803)) ([e654bfb](https://www.github.com/googleapis/gapic-generator-java/commit/e654bfb936b571af2546f550c9a1589f8ad63d67))



### [1.0.16](https://www.github.com/googleapis/gapic-generator-java/compare/v1.0.15...v1.0.16) (2021-06-30)


### Bug Fixes

* **bazel:** Eradicate monolith deps from Java µgen repo ([#778](https://www.github.com/googleapis/gapic-generator-java/issues/778)) ([86f2472](https://www.github.com/googleapis/gapic-generator-java/commit/86f2472963f020127ef6ff92be6241d12e2273af))
* **build:** Update googleapis-discovery hash to fix compute integration test ([#782](https://www.github.com/googleapis/gapic-generator-java/issues/782)) ([46bb19a](https://www.github.com/googleapis/gapic-generator-java/commit/46bb19a7ee61da86b4be6d87a71f3cd210e753d2))
* **protoc:** Mirror protoc's field name conflict resolution logic in client generation ([#781](https://www.github.com/googleapis/gapic-generator-java/issues/781)) ([9432979](https://www.github.com/googleapis/gapic-generator-java/commit/9432979bab59f48c8645fa47d752cdd470d4a682))

### [1.0.15](https://www.github.com/googleapis/gapic-generator-java/compare/v1.0.14...v1.0.15) (2021-06-22)


### Features

* Implement field presence support for DIREGAPIC ([#774](https://www.github.com/googleapis/gapic-generator-java/issues/774)) ([c820361](https://www.github.com/googleapis/gapic-generator-java/commit/c82036105d299b0a1192cd0def5e68253e4f542c))


### Bug Fixes

* **service.yaml:** Remove allowlist restriction ([#776](https://www.github.com/googleapis/gapic-generator-java/issues/776)) ([8f42efd](https://www.github.com/googleapis/gapic-generator-java/commit/8f42efdb92d606a768a524517fe949c4f9112025))


### Miscellaneous Chores

* release 1.0.15 ([f752478](https://www.github.com/googleapis/gapic-generator-java/commit/f75247845344540a94c4efcd416f34f96ea0c2a3))

### [1.0.14](https://www.github.com/googleapis/gapic-generator-java/compare/v1.0.13...v1.0.14) (2021-06-17)


### Features

* Add DIREGAPIC-specific pagination ([#767](https://www.github.com/googleapis/gapic-generator-java/issues/767)) ([1294c29](https://www.github.com/googleapis/gapic-generator-java/commit/1294c298f50cc4474ae562e6a07f37a5f94fe5b8))


### Bug Fixes

* **bazel:** Remove monolith rule deps from the Java µgen Bazel rules ([#764](https://www.github.com/googleapis/gapic-generator-java/issues/764)) ([bff3efc](https://www.github.com/googleapis/gapic-generator-java/commit/bff3efc25e43692ea5b6e769c20d25d5b9a1e3d2))



### [1.0.13](https://www.github.com/googleapis/gapic-generator-java/compare/v1.0.12...v1.0.13) (2021-06-16)


### Bug Fixes

* **resnames:** Fix resname builder name conflicts in ctor with this assignment ([#769](https://www.github.com/googleapis/gapic-generator-java/issues/769)) ([edac844](https://www.github.com/googleapis/gapic-generator-java/commit/edac8447d74c43ab0db963a37f66e1029ab19f0c))

### [1.0.12](https://www.github.com/googleapis/gapic-generator-java/compare/v1.0.11...v1.0.12) (2021-06-10)


### Features

* add mtls support ([#672](https://www.github.com/googleapis/gapic-generator-java/issues/672)) ([1e24893](https://www.github.com/googleapis/gapic-generator-java/commit/1e24893a65daf8ef067e331364c591ac973b5e02))


### Bug Fixes

* **mocks:** Use java.lang.Object if there are protos named 'Object' ([#760](https://www.github.com/googleapis/gapic-generator-java/issues/760)) ([2a7064b](https://www.github.com/googleapis/gapic-generator-java/commit/2a7064b88fe26586bd8aed43b7a7d28c7e974ec0))
* **resnames:** Use anon resname classes when only wildcards are present ([#763](https://www.github.com/googleapis/gapic-generator-java/issues/763)) ([f0ecead](https://www.github.com/googleapis/gapic-generator-java/commit/f0ecead9f1cc645cdbb7f61cdfc820c7df95355d))


### Miscellaneous Chores

* release 1.0.12 ([02eab0e](https://www.github.com/googleapis/gapic-generator-java/commit/02eab0ec61260048a2684119cfd4fa2172f3a637))

### [1.0.11](https://www.github.com/googleapis/gapic-generator-java/compare/v1.0.10...v1.0.11) (2021-06-07)


### Features

* DIREGAPIC initial implementation ([#746](https://www.github.com/googleapis/gapic-generator-java/issues/746)) ([81f6737](https://www.github.com/googleapis/gapic-generator-java/commit/81f6737359ac6ce5ee2b42ab4f755fbb05a3cf28))


### Bug Fixes

* **bazel:** ensure integration tests diff files recursively ([#745](https://www.github.com/googleapis/gapic-generator-java/issues/745)) ([ddc75f9](https://www.github.com/googleapis/gapic-generator-java/commit/ddc75f9f3b84d0ea50638a79a63d40cf551211e2))
* **resnames:** filter out mixin services from resname pkg candidates ([#751](https://www.github.com/googleapis/gapic-generator-java/issues/751)) ([72fa76f](https://www.github.com/googleapis/gapic-generator-java/commit/72fa76f27379a74a143b1735f60ae3e00da4c1a6))
* **tests:** Ensure deterministic field ordering in test classes ([#743](https://www.github.com/googleapis/gapic-generator-java/issues/743)) ([fdb705b](https://www.github.com/googleapis/gapic-generator-java/commit/fdb705b0a39443fb0b7679d879f27e0aa1c36b67))
* **tests:** handle Java 11 set ordering differences for RPCs and fields in test/mock classes ([#750](https://www.github.com/googleapis/gapic-generator-java/issues/750)) ([eaf4592](https://www.github.com/googleapis/gapic-generator-java/commit/eaf4592e139fbc42810e7f60dc9967320195bf85))


### [1.0.10](https://www.github.com/googleapis/gapic-generator-java/compare/v1.0.9...v1.0.10) (2021-05-26)


### Miscellaneous Chores

* Pre-DIREGAPIC refactoring ([04c2faa](https://github.com/googleapis/gapic-generator-java/commit/04c2faa191a9b5a10b92392fe8482279c4404803))

### [1.0.9](https://www.github.com/googleapis/gapic-generator-java/compare/v1.0.8...v1.0.9) (2021-05-26)


### Features

* add AST support for lambdas ([#736](https://www.github.com/googleapis/gapic-generator-java/issues/736)) ([9ced678](https://www.github.com/googleapis/gapic-generator-java/commit/9ced6780c7a6b9934dd548002602618566a539d6))


### Bug Fixes

* Support enums in proto HTTP annotations ([#733](https://www.github.com/googleapis/gapic-generator-java/issues/733)) ([f5c7b86](https://www.github.com/googleapis/gapic-generator-java/commit/f5c7b86b43ad71ffe47d8ba039155db601638e1f))
* Support PubSub's _deleted-topic_ pattern ([#739](https://www.github.com/googleapis/gapic-generator-java/issues/739)) ([7d8c62d](https://www.github.com/googleapis/gapic-generator-java/commit/7d8c62d8e8922a3589e631299ecb0287bc41ba2d))


### [1.0.8](https://www.github.com/googleapis/gapic-generator-java/compare/v1.0.7...v1.0.8) (2021-05-24)


### Miscellaneous Chores

* DIREGAPIC refactoring ([ae17e7e](https://github.com/googleapis/gapic-generator-java/commit/ae17e7e9a272b422176962d896e387496b1806e8))

### [1.0.7](https://www.github.com/googleapis/gapic-generator-java/compare/v1.0.6...v1.0.7) (2021-05-21)


### Bug Fixes

* Add PubSub to service.yaml / mixin allowlist ([#729](https://www.github.com/googleapis/gapic-generator-java/issues/729)) ([e7f6d33](https://www.github.com/googleapis/gapic-generator-java/commit/e7f6d33051e335504b05c402d3b98c387a9f0daf))


### [1.0.6](https://www.github.com/googleapis/gapic-generator-java/compare/v1.0.5...v1.0.6) (2021-05-19)


### Bug Fixes

* **mixins:** Gate mixin RPC on HTTP rules, add yaml doc/http overrides ([#727](https://www.github.com/googleapis/gapic-generator-java/issues/727)) ([229da5d](https://www.github.com/googleapis/gapic-generator-java/commit/229da5d94cf7db060abf3ea006a20d1ade804597))

### [1.0.5](https://www.github.com/googleapis/gapic-generator-java/compare/v1.0.4...v1.0.5) (2021-05-17)


### Bug Fixes

* **types:** Reorder nested types for legacy protos w/ java_outer_class in one file ([#724](https://www.github.com/googleapis/gapic-generator-java/issues/724)) ([925356d](https://www.github.com/googleapis/gapic-generator-java/commit/925356d659aed4b8550ce526f1772a706661c246))

### [1.0.4](https://www.github.com/googleapis/gapic-generator-java/compare/v1.0.3...v1.0.4) (2021-05-13)


### Bug Fixes

* **types:** Use fully-qualified message type names ([#723](https://www.github.com/googleapis/gapic-generator-java/issues/723)) ([8a5c36c](https://www.github.com/googleapis/gapic-generator-java/commit/8a5c36ccce7540940ec7a4bf8751971c3741d89d))
* Use the right composers in deprecation unit tests ([#715](https://www.github.com/googleapis/gapic-generator-java/issues/715)) ([2318136](https://www.github.com/googleapis/gapic-generator-java/commit/2318136e49060c3212abfd6337e2c3ceb2c2fc69))

### [1.0.3](https://www.github.com/googleapis/gapic-generator-java/compare/v1.0.2...v1.0.3) (2021-04-07)


### Bug Fixes

* Comment typo in Parser.java ([#701](https://www.github.com/googleapis/gapic-generator-java/issues/701)) ([685feff](https://www.github.com/googleapis/gapic-generator-java/commit/685feff32bf16484895ed86121282360b3e2dab3))

### [1.0.2](https://www.github.com/googleapis/gapic-generator-java/compare/v1.0.1...v1.0.2) (2021-03-14)


### Bug Fixes

* add request with default value in regular paged callable method ([#690](https://www.github.com/googleapis/gapic-generator-java/issues/690)) ([cc8ce77](https://www.github.com/googleapis/gapic-generator-java/commit/cc8ce778f07577eb3ed4cc9d07ac25511b0f1acd))
* **mixins:** handle unit tests for mixin pagination methods ([#691](https://www.github.com/googleapis/gapic-generator-java/issues/691)) ([edd7443](https://www.github.com/googleapis/gapic-generator-java/commit/edd7443d16e5c9389de16e6235fe884f9b996cf6))
* **sample code:** Update client samples in  KMS goldens ([#697](https://www.github.com/googleapis/gapic-generator-java/issues/697)) ([3777196](https://www.github.com/googleapis/gapic-generator-java/commit/3777196f0225a8b28203f1c225a67ea56b8728d3))

### [1.0.1](https://www.github.com/googleapis/gapic-generator-java/compare/v1.0.0...v1.0.1) (2021-03-03)


### Bug Fixes

* **codegen:** Bump license year in generated file headers ([#685](https://www.github.com/googleapis/gapic-generator-java/issues/685)) ([d1b3032](https://www.github.com/googleapis/gapic-generator-java/commit/d1b3032d54bc75e2f4e1b954f7215cff1069110e))
* **metadata:** gate metadata file-gen on a CLI flag ([#684](https://www.github.com/googleapis/gapic-generator-java/issues/684)) ([738bf8a](https://www.github.com/googleapis/gapic-generator-java/commit/738bf8a95125cbdd33cb0f762afb415844bf9426))
* **mixins:** enable codegen for standalone mixin APIs, add IAM integ test ([#679](https://www.github.com/googleapis/gapic-generator-java/issues/679)) ([bbde184](https://www.github.com/googleapis/gapic-generator-java/commit/bbde184b4d5a6085a6f18fd8120bd79207f67c5d))
* **mixins:** enable RPC overrides to clobber mixed-in RPCs ([#678](https://www.github.com/googleapis/gapic-generator-java/issues/678)) ([0645de4](https://www.github.com/googleapis/gapic-generator-java/commit/0645de476d131be20839f74ba83b53483d0d0b6d))

## [1.0.0](https://www.github.com/googleapis/gapic-generator-java/compare/v0.0.21...v1.0.0) (2021-03-01)


### Bug Fixes

* add common srcs to test, check test targets only in codecov ([#669](https://www.github.com/googleapis/gapic-generator-java/issues/669)) ([f81ed0b](https://www.github.com/googleapis/gapic-generator-java/commit/f81ed0bdede477c51cd6755b5050933319a442c9))
* **release:** update gax-java to 1.62.0 ([#675](https://www.github.com/googleapis/gapic-generator-java/issues/675)) ([51ed181](https://www.github.com/googleapis/gapic-generator-java/commit/51ed181f9fa2747604054214db79e1f2398b1dac))
