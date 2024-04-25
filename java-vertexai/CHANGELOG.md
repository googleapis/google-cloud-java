# Changelog

## 1.2.0 (2024-04-25)

### Features

* Update gapic to include system instruction ([#10733](https://github.com/googleapis/google-cloud-java/issues/10733)) ([8340a49](https://github.com/googleapis/google-cloud-java/commit/8340a49755a3c1504765b83f244099a5fbb1cd46))
* check null and empty values for input String ([#10658](https://github.com/googleapis/google-cloud-java/issues/10658)) ([949889d](https://github.com/googleapis/google-cloud-java/commit/949889dd71175601ab5d099f65b1f7656205177e))



## 1.1.0 (2024-04-04)

* No change


## 0.8.0 (2024-03-28)

* No change


## 0.7.0 (2024-03-22)

### Features

* Change the unmodifiable list to immutable list for getHistory
* do not allow null values in Builder's setter and remove model's setters.
* remove GenerateContentConfig
* Make ChatSession and GenerativeModel final
* remove deprecated methods in GenerativeModel and ChatSession
* make client getters in VertexAI private
* remove Transport from GenerativeModel
* Remove vararg scopes in VertexAI
* add fluent API in ChatSession ([#10597](https://github.com/googleapis/google-cloud-java/issues/10597)) ([5c3d93e](https://github.com/googleapis/google-cloud-java/commit/5c3d93eafe76c97e50fc174678743fe59be699af))
* add fluent API in GenerativeModel ([#10585](https://github.com/googleapis/google-cloud-java/issues/10585)) ([8bc8adb](https://github.com/googleapis/google-cloud-java/commit/8bc8adbf0dae047d508ca591c659bfb91dfc02f0))
* Add FunctionDeclarationMaker ([#10592](https://github.com/googleapis/google-cloud-java/issues/10592)) ([a8aa591](https://github.com/googleapis/google-cloud-java/commit/a8aa591431ea79008aa92bba3c68b7dcda038ab6))
* add generateContentAsync methods to GenerativeModel ([#10599](https://github.com/googleapis/google-cloud-java/issues/10599)) ([17b01c6](https://github.com/googleapis/google-cloud-java/commit/17b01c6527090be5553c63986c1dd64caf818187))
* Update Gapic client. ([#10574](https://github.com/googleapis/google-cloud-java/issues/10574)) ([bedcddf](https://github.com/googleapis/google-cloud-java/commit/bedcddfea33aeee8f3d813a0c3250380bb988838))
* make a copy of the list in `ChatSession.setHistory()` ([#10608](https://github.com/googleapis/google-cloud-java/issues/10608)) ([3e3e35a](https://github.com/googleapis/google-cloud-java/commit/3e3e35a5c1184a486f904858f3647c9313bd5b23))
* Update README ([#10607](https://github.com/googleapis/google-cloud-java/issues/10607)) ([05275be](https://github.com/googleapis/google-cloud-java/commit/05275be1b35530c65ac930cdc58096972c275df9))
* Change the unmodifiable list to immutable list for getHistory ([3f68001](https://github.com/googleapis/google-cloud-java/commit/3f68001f3bc85f12d9d801ddb05d18c4790d6689))
* do not allow null values in Builder's setter and remove model's setters. ([a2407ab](https://github.com/googleapis/google-cloud-java/commit/a2407ab756ef22c57c1378d50b55e8920c7b34ae))
* Make ChatSession and GenerativeModel final ([80495ad](https://github.com/googleapis/google-cloud-java/commit/80495ada838c38f42f8aa397b1e57681f46103bb))
* make client getters in VertexAI private ([e8994c7](https://github.com/googleapis/google-cloud-java/commit/e8994c798037a50b5bb0f43f59f08aba37a330f4))
* remove deprecated methods in GenerativeModel and ChatSession ([c54eaa9](https://github.com/googleapis/google-cloud-java/commit/c54eaa9dd86d1ddcdd86110aab468039c3aad903))
* remove GenerateContentConfig ([31f5e12](https://github.com/googleapis/google-cloud-java/commit/31f5e12e889ac03d510de4a5b3dcdae0b2b27d0a))
* remove Transport from GenerativeModel ([f024111](https://github.com/googleapis/google-cloud-java/commit/f024111a400b4409d87871322b866c7611dda63c))
* Remove vararg scopes in VertexAI ([afc367f](https://github.com/googleapis/google-cloud-java/commit/afc367ff21b2bdd60977709bbee4b4a7a22c2fbf))



## 0.6.0 (2024-03-06)

### Features

* add GenerateContentConfig class ([#10413](https://github.com/googleapis/google-cloud-java/issues/10413)) ([04e9574](https://github.com/googleapis/google-cloud-java/commit/04e9574a223cd9c42615bfde18aa6ad3dc551251))
* add GenerateContentConfig to generateContent method ([#10425](https://github.com/googleapis/google-cloud-java/issues/10425)) ([903abf3](https://github.com/googleapis/google-cloud-java/commit/903abf39cae4810be41f2475c63a0fcb0b238bc1))
* add GenerateContentConfig to generateContentStream method ([#10424](https://github.com/googleapis/google-cloud-java/issues/10424)) ([ec9dd00](https://github.com/googleapis/google-cloud-java/commit/ec9dd001c4058871ecf7ff7e3b91633aac3bf17b))
* add GenerateContentConfig to sendMessage method ([#10436](https://github.com/googleapis/google-cloud-java/issues/10436)) ([25d00c7](https://github.com/googleapis/google-cloud-java/commit/25d00c7c4f1a68e45e491715b0d2c07f2ac4618d))
* Mark generateContent variants with GenerationConfig and List&lt;SafetySetting&gt; as deprecated. ([#10474](https://github.com/googleapis/google-cloud-java/issues/10474)) ([7cf463b](https://github.com/googleapis/google-cloud-java/commit/7cf463b7e2d8fe7c3ed467ad8fe2e5dae2904ee7))



## 0.5.0 (2024-02-20)

### Features

* make setApiEndpoint effective for LlmUtilityServiceClient. ([#10385](https://github.com/googleapis/google-cloud-java/issues/10385)) ([b4ec244](https://github.com/googleapis/google-cloud-java/commit/b4ec2449f092e6dca1c9cd169421311579b67777))



## 0.4.0 (2024-02-09)

### Features

* add fromFunctionResponse in PartMaker ([#10272](https://github.com/googleapis/google-cloud-java/issues/10272)) ([20c8252](https://github.com/googleapis/google-cloud-java/commit/20c8252dcc4b093f6d699753ad39f0cdbef1d8ed))
* Remove 'preview' namespace and start using @BetaApi ([#10330](https://github.com/googleapis/google-cloud-java/issues/10330)) ([29b2a36](https://github.com/googleapis/google-cloud-java/commit/29b2a3674bf8f387ecc30d94fdcdc7843cde8e15))
* deprecate varargs scopes in VertexAI ([#10328](https://github.com/googleapis/google-cloud-java/issues/10328)) ([12f9a3c](https://github.com/googleapis/google-cloud-java/commit/12f9a3ce9521cb9ce92db71f21356eaf4519db07))
* Add README section about function-calling ([#10320](https://github.com/googleapis/google-cloud-java/issues/10320)) ([ed92f0d](https://github.com/googleapis/google-cloud-java/commit/ed92f0d295070a598f70b6c19f10b3ffcc04e65c))
* Update javadoc of VertexAI and Transport. ([#10296](https://github.com/googleapis/google-cloud-java/issues/10296)) ([2729b0b](https://github.com/googleapis/google-cloud-java/commit/2729b0b0f82b8bf069707cc3ecac52a6f497c8f5))

