# Changelog

## [1.43.0](https://github.com/googleapis/google-auth-library-java/compare/v1.42.1...v1.43.0) (2026-02-10)


### Features

* Next release from main branch is 1.43.0 ([#1887](https://github.com/googleapis/google-auth-library-java/issues/1887)) ([bec0ece](https://github.com/googleapis/google-auth-library-java/commit/bec0ecea8d1064a3467c4329a0d09f7d5705f84d))


### Bug Fixes

* Deserialization checks valid class types for HttpTransportFactory ([#1882](https://github.com/googleapis/google-auth-library-java/issues/1882)) ([76ff74e](https://github.com/googleapis/google-auth-library-java/commit/76ff74e4c810d54763ca34d4f483730c43c329a8))

## [1.42.1](https://github.com/googleapis/google-auth-library-java/compare/v1.42.0...v1.42.1) (2026-01-23)


### Bug Fixes

* Mark GdchCredentialsTestUtil test util class as public ([#1877](https://github.com/googleapis/google-auth-library-java/issues/1877)) ([1868969](https://github.com/googleapis/google-auth-library-java/commit/1868969b2701fe0faa4511c36443666c3aaad534))

## [1.42.0](https://github.com/googleapis/google-auth-library-java/compare/v1.41.0...v1.42.0) (2026-01-23)


### Features

* Update protobuf version to 4.33.2 ([#1875](https://github.com/googleapis/google-auth-library-java/issues/1875)) ([13ddbd1](https://github.com/googleapis/google-auth-library-java/commit/13ddbd1744fb908fb51e8866e5aac291f0e9bada))


### Bug Fixes

* Simplify call to directly retrieve the default service account from MDS ([#1844](https://github.com/googleapis/google-auth-library-java/issues/1844)) ([6efda0b](https://github.com/googleapis/google-auth-library-java/commit/6efda0bc2063b1d1b30de43785d08ec86da1791c))

## [1.41.0](https://github.com/googleapis/google-auth-library-java/compare/v1.40.0...v1.41.0) (2025-12-03)


### Features

* Introduce per-credential specific load methods ([#1827](https://github.com/googleapis/google-auth-library-java/issues/1827)) ([39fdc64](https://github.com/googleapis/google-auth-library-java/commit/39fdc647c2e14d8006a758fa81dbaeff63fed74e))


### Bug Fixes

* Add configurable connect and read timeouts for IdentityPoolCredentials requests ([#1847](https://github.com/googleapis/google-auth-library-java/issues/1847)) ([d6cff60](https://github.com/googleapis/google-auth-library-java/commit/d6cff6048b506896fc960d99fbb4a00e03f23b62))
* Do not retrieve the default SA principal when getting an access token ([#1839](https://github.com/googleapis/google-auth-library-java/issues/1839)) ([a65c22d](https://github.com/googleapis/google-auth-library-java/commit/a65c22da2c93bdf33dcd98ece47ee6668d1ed32c))

## [1.40.0](https://github.com/googleapis/google-auth-library-java/compare/v1.39.1...v1.40.0) (2025-10-14)


### Features

* Add projectId getter to GoogleCredentials ([#1813](https://github.com/googleapis/google-auth-library-java/issues/1813)) ([c3d9ee0](https://github.com/googleapis/google-auth-library-java/commit/c3d9ee09df30a26586b0e834cfda7763fd7854f5))
* Support user defined or json defined scopes for impersonated token ([#1815](https://github.com/googleapis/google-auth-library-java/issues/1815)) ([84fc566](https://github.com/googleapis/google-auth-library-java/commit/84fc566d92f03e648cd82a8860fb191520bb6c7e))


### Dependencies

* Bump guava to v33.5.0 ([#1825](https://github.com/googleapis/google-auth-library-java/issues/1825)) ([79f0a35](https://github.com/googleapis/google-auth-library-java/commit/79f0a353e12a8206584e9031989861ca6abaaf85))

## [1.39.1](https://github.com/googleapis/google-auth-library-java/compare/v1.39.0...v1.39.1) (2025-09-17)


### Documentation

* Additional information for deprecated fromStream() methods. ([#1802](https://github.com/googleapis/google-auth-library-java/issues/1802)) ([a0d873d](https://github.com/googleapis/google-auth-library-java/commit/a0d873db6bf192aad710e17da6127195f253c7e7))

## [1.39.0](https://github.com/googleapis/google-auth-library-java/compare/v1.38.0...v1.39.0) (2025-09-04)


### Features

* Add Credential Information to GoogleCredential classes ([#1791](https://github.com/googleapis/google-auth-library-java/issues/1791)) ([5511913](https://github.com/googleapis/google-auth-library-java/commit/551191340c97497db991ff65994cbb0086490d2a))


### Bug Fixes

* Indicate non-validated external credentials in generic methods ([e7d4380](https://github.com/googleapis/google-auth-library-java/commit/e7d4380ce94bbdd5a879591e0652945262e896aa))


### Dependencies

* Add `com.google.api:api-commons` dependency ([e7d4380](https://github.com/googleapis/google-auth-library-java/commit/e7d4380ce94bbdd5a879591e0652945262e896aa))
* Update `com.google.errorprone:error_prone_annotations` dependency to 2.38.0 ([e7d4380](https://github.com/googleapis/google-auth-library-java/commit/e7d4380ce94bbdd5a879591e0652945262e896aa))

## [1.38.0](https://github.com/googleapis/google-auth-library-java/compare/v1.37.1...v1.38.0) (2025-08-20)


### Features

* Next release from main branch is 1.38.0 ([#1786](https://github.com/googleapis/google-auth-library-java/issues/1786)) ([1669dc8](https://github.com/googleapis/google-auth-library-java/commit/1669dc8b7d23fd7085ea7085b2bb5507a6932920))


### Bug Fixes

* Override toBuilder() for ExternalAccountCredential and subclasses ([#1793](https://github.com/googleapis/google-auth-library-java/issues/1793)) ([a9c3de6](https://github.com/googleapis/google-auth-library-java/commit/a9c3de60a078fd93f1922b4dbcf7570af20150f0))


### Documentation

* Update README with X.509 feature details ([#1790](https://github.com/googleapis/google-auth-library-java/issues/1790)) ([7b51cb3](https://github.com/googleapis/google-auth-library-java/commit/7b51cb3042f278c60ca3d90555f7ebb93e6e8250))

## [1.37.1](https://github.com/googleapis/google-auth-library-java/compare/v1.37.0...v1.37.1) (2025-06-05)


### Bug Fixes

* Correct typo in minExpirationTime variable name ([#1769](https://github.com/googleapis/google-auth-library-java/issues/1769)) ([91e6274](https://github.com/googleapis/google-auth-library-java/commit/91e6274828310e614802ad948ccfc240aebc0873))

## [1.37.0](https://github.com/googleapis/google-auth-library-java/compare/v1.36.0...v1.37.0) (2025-06-04)


### Features

* **mtls:** Introduce DefaultMtlsProviderFactory and SecureConnectProvider ([#1730](https://github.com/googleapis/google-auth-library-java/issues/1730)) ([c9fd1b1](https://github.com/googleapis/google-auth-library-java/commit/c9fd1b1a477329ae336accd151a57795a0c83955))


### Bug Fixes

* Correct capitalization of GitHub ([#1761](https://github.com/googleapis/google-auth-library-java/issues/1761)) ([f79a2e4](https://github.com/googleapis/google-auth-library-java/commit/f79a2e406ef1128f9a222155cad2effc1e69a331))
* Correct extra spaces in README heading ([#1760](https://github.com/googleapis/google-auth-library-java/issues/1760)) ([8d26666](https://github.com/googleapis/google-auth-library-java/commit/8d266669c1fcc007f35948052dc7cb7c53c1a639))
* Correct misspelling of OAuth in comments ([#1762](https://github.com/googleapis/google-auth-library-java/issues/1762)) ([42b9602](https://github.com/googleapis/google-auth-library-java/commit/42b9602886b00b0090e519c79cfc96d9b876ffeb))
* Correct typo in ServiceAccountJwtAccessCredentials.java comment ([#1765](https://github.com/googleapis/google-auth-library-java/issues/1765)) ([3058b06](https://github.com/googleapis/google-auth-library-java/commit/3058b069e474fb06d16926c9313ca1f931934a11))
* Update Javadoc reference in ExternalAccountCredentials ([#1763](https://github.com/googleapis/google-auth-library-java/issues/1763)) ([5eb3659](https://github.com/googleapis/google-auth-library-java/commit/5eb3659c131969e674ea1bb4b84698202befbc9b))


### Documentation

* Duplicate "the" in Javadoc comments ([#1764](https://github.com/googleapis/google-auth-library-java/issues/1764)) ([5f7a084](https://github.com/googleapis/google-auth-library-java/commit/5f7a0841b32c5e03ca1bbf49a7e612725062311b))

## [1.36.0](https://github.com/googleapis/google-auth-library-java/compare/v1.35.0...v1.36.0) (2025-05-28)


### Features

* Support ability to set universe domain in ServiceAccountJwtAccessCredentials ([#1754](https://github.com/googleapis/google-auth-library-java/issues/1754)) ([919ae32](https://github.com/googleapis/google-auth-library-java/commit/919ae320bf5a4f06fd39871bf055b8487ed55d71))


### Bug Fixes

* IdTokenCredentials should fetch license id claim when requested ([#1450](https://github.com/googleapis/google-auth-library-java/issues/1450)) ([c5648a5](https://github.com/googleapis/google-auth-library-java/commit/c5648a55f15a75b1d616fbdc37cd331811e66f3a))
* Update approval_prompt=force to prompt=consent ([#1752](https://github.com/googleapis/google-auth-library-java/issues/1752)) ([4543d04](https://github.com/googleapis/google-auth-library-java/commit/4543d0423775f1e568249eb782b88dc0e6d64a59))

## [1.35.0](https://github.com/googleapis/google-auth-library-java/compare/v1.34.0...v1.35.0) (2025-05-12)


### Features

* Add support for mTLS authentication via X.509 certificates ([#1736](https://github.com/googleapis/google-auth-library-java/issues/1736)) ([b347603](https://github.com/googleapis/google-auth-library-java/commit/b347603db4deabb4eb34ed14b96178c95d3e7b45))
* Return X509 certificate chain as the subject token. ([#1746](https://github.com/googleapis/google-auth-library-java/issues/1746)) ([6d05be8](https://github.com/googleapis/google-auth-library-java/commit/6d05be8e5cecf62ca0952bc3ef23c527c9e0d01d))


### Bug Fixes

* Handle optional fields in ExternalAccountCredentials with null JSON value gracefully ([#1706](https://github.com/googleapis/google-auth-library-java/issues/1706)) ([f1f306d](https://github.com/googleapis/google-auth-library-java/commit/f1f306dffd874741663238283deed173ce02bea9))

## [1.34.0](https://github.com/googleapis/google-auth-library-java/compare/v1.33.1...v1.34.0) (2025-04-29)


### Features

* Implement X509 certificate provider ([#1722](https://github.com/googleapis/google-auth-library-java/issues/1722)) ([4340684](https://github.com/googleapis/google-auth-library-java/commit/4340684fe29c9e9bffa90e88d0b1746f19b623ab))
* Next release from main branch is 1.34.0 ([#1698](https://github.com/googleapis/google-auth-library-java/issues/1698)) ([fe43815](https://github.com/googleapis/google-auth-library-java/commit/fe4381513db1340190c4309a53c6265718682dde))
* Next release from main branch is 1.34.0 ([#1702](https://github.com/googleapis/google-auth-library-java/issues/1702)) ([4507cf9](https://github.com/googleapis/google-auth-library-java/commit/4507cf9e17e7ff40cf142056d3929c87f5742dd1))


### Bug Fixes

* Do not add padding in Client-Side CAB tokens. ([#1728](https://github.com/googleapis/google-auth-library-java/issues/1728)) ([8a75ccd](https://github.com/googleapis/google-auth-library-java/commit/8a75ccd1c09191abd8ebf463bc41810a38e185f5))

## [1.33.1](https://github.com/googleapis/google-auth-library-java/compare/v1.33.0...v1.33.1) (2025-02-25)


### Dependencies

* Update dependency com.google.cloud:google-cloud-shared-config to v1.14.4 ([53a2abc](https://github.com/googleapis/google-auth-library-java/commit/53a2abc5b19e25079113ebff501aebc18efca309))

## [1.33.0](https://github.com/googleapis/google-auth-library-java/compare/v1.32.1...v1.33.0) (2025-02-24)


### Features

* Add client logging with slf4j ([#1586](https://github.com/googleapis/google-auth-library-java/issues/1586)) ([24761d6](https://github.com/googleapis/google-auth-library-java/commit/24761d6cc3590c4b08c56c8c992b740e235b31c5))


### Dependencies

* Update dependency com.google.http-client:google-http-client-bom to v1.46.1 ([96a5ad8](https://github.com/googleapis/google-auth-library-java/commit/96a5ad88a7b187e1a0d472dca06ff39d74804d61))

## [1.32.1](https://github.com/googleapis/google-auth-library-java/compare/v1.32.0...v1.32.1) (2025-02-07)


### Bug Fixes

* Add cab-token-generator module to Auth BOM ([#1662](https://github.com/googleapis/google-auth-library-java/issues/1662)) ([e409b02](https://github.com/googleapis/google-auth-library-java/commit/e409b02b124619ffd6af95890c6ce340b204554a))
* Remove unnecessary nexus-staging-maven-plugin activation ([#1665](https://github.com/googleapis/google-auth-library-java/issues/1665)) ([d138023](https://github.com/googleapis/google-auth-library-java/commit/d138023aae55abb7b36d2bef6b21cd00a2ec4511))


### Dependencies

* Update dependency com.google.http-client:google-http-client-bom to v1.46.0 ([e53c441](https://github.com/googleapis/google-auth-library-java/commit/e53c4415f472594f56c53e92d302f745b96c4fba))


### Documentation

* Update README with client-side CAB instructions ([#1607](https://github.com/googleapis/google-auth-library-java/issues/1607)) ([#1666](https://github.com/googleapis/google-auth-library-java/issues/1666)) ([2996297](https://github.com/googleapis/google-auth-library-java/commit/2996297f54823c43a2bb7c96a634013a79be6fd4))

## [1.32.0](https://github.com/googleapis/google-auth-library-java/compare/v1.31.0...v1.32.0) (2025-02-04)


### Features

* Introduce Client-Side Credential Access Boundary (CAB) functionality ([#1629](https://github.com/googleapis/google-auth-library-java/issues/1629)) ([f481123](https://github.com/googleapis/google-auth-library-java/commit/f4811236018502595987eea8ce5f3fa1c7fdbfaf))


### Bug Fixes

* Handle 404 and non 200 Status Code from MDS Identity Token calls ([#1636](https://github.com/googleapis/google-auth-library-java/issues/1636)) ([152c851](https://github.com/googleapis/google-auth-library-java/commit/152c851bfb90196437f268a6975e66a89985444b))
* Respect token_uri from json in UserCredentials creation. ([#1630](https://github.com/googleapis/google-auth-library-java/issues/1630)) ([f92cc4f](https://github.com/googleapis/google-auth-library-java/commit/f92cc4faf46ab6b0b2b5659fdbbd4c83c1c2f0fe))


### Documentation

* Re-organize the README + Add a section on migrating to GoogleCredentials ([#1644](https://github.com/googleapis/google-auth-library-java/issues/1644)) ([30b26b2](https://github.com/googleapis/google-auth-library-java/commit/30b26b280268530eb46fb85baa1ca808245e8d26))

## [1.31.0](https://github.com/googleapis/google-auth-library-java/compare/v1.30.1...v1.31.0) (2025-01-22)


### Features

* ImpersonatedCredentials to support universe domain for idtoken and signblob ([#1566](https://github.com/googleapis/google-auth-library-java/issues/1566)) ([adc2ff3](https://github.com/googleapis/google-auth-library-java/commit/adc2ff3dcabb79e367d0d66b5b3fd8a51e35bc2b))
* Support transport and binding-enforcement MDS parameters. ([#1558](https://github.com/googleapis/google-auth-library-java/issues/1558)) ([9828a8e](https://github.com/googleapis/google-auth-library-java/commit/9828a8eeb9f144f7c341df0c03282a8790356962))


### Documentation

* Promote use of bill of materials in quickstart documentation ([#1620](https://github.com/googleapis/google-auth-library-java/issues/1620)) ([fc20d9c](https://github.com/googleapis/google-auth-library-java/commit/fc20d9c9d33b7eada964cf41297f8a3e13c27fe1)), closes [#1552](https://github.com/googleapis/google-auth-library-java/issues/1552)

## [1.30.1](https://github.com/googleapis/google-auth-library-java/compare/v1.30.0...v1.30.1) (2024-12-11)


### Bug Fixes

* JSON parsing of S2A addresses. ([#1589](https://github.com/googleapis/google-auth-library-java/issues/1589)) ([9d5ebfe](https://github.com/googleapis/google-auth-library-java/commit/9d5ebfe8870a11d27af3a7c7f3fd9930ab207162))

## [1.30.0](https://github.com/googleapis/google-auth-library-java/compare/v1.29.0...v1.30.0) (2024-11-08)


### Features

* Support querying S2A Addresses from MDS ([#1400](https://github.com/googleapis/google-auth-library-java/issues/1400)) ([df06bd1](https://github.com/googleapis/google-auth-library-java/commit/df06bd1f94d03c4f8807c2adf42d25d29b731531))


### Bug Fixes

* Make it explicit that there is a network call to MDS to get SecureSessionAgentConfig ([#1573](https://github.com/googleapis/google-auth-library-java/issues/1573)) ([18020fe](https://github.com/googleapis/google-auth-library-java/commit/18020fedb855742ee27b6558f5de58d3818c6b48))

## [1.29.0](https://github.com/googleapis/google-auth-library-java/compare/v1.28.0...v1.29.0) (2024-10-22)


### Features

* Service sccount to service account impersonation to support universe domain ([#1528](https://github.com/googleapis/google-auth-library-java/issues/1528)) ([c498ccf](https://github.com/googleapis/google-auth-library-java/commit/c498ccf67755c6ec619cb37962c2c86ae3ec9d4c))


### Bug Fixes

* Make some enum fields final ([#1526](https://github.com/googleapis/google-auth-library-java/issues/1526)) ([8920155](https://github.com/googleapis/google-auth-library-java/commit/89201558db913d9a71b3acccbab8eb0045ada6de))

## [1.28.0](https://github.com/googleapis/google-auth-library-java/compare/v1.27.0...v1.28.0) (2024-10-02)


### Features

* Add metric headers ([#1503](https://github.com/googleapis/google-auth-library-java/issues/1503)) ([7f0c1d3](https://github.com/googleapis/google-auth-library-java/commit/7f0c1d31176f9e634fac3b2c6b06f880a51b5fa6))

## [1.27.0](https://github.com/googleapis/google-auth-library-java/compare/v1.26.0...v1.27.0) (2024-09-20)


### Features

* Add api key credential as client library authorization type ([#1483](https://github.com/googleapis/google-auth-library-java/issues/1483)) ([6401e51](https://github.com/googleapis/google-auth-library-java/commit/6401e51c04fa6bd819e8dff98a62b7f079608a43))

## [1.26.0](https://github.com/googleapis/google-auth-library-java/compare/v1.25.0...v1.26.0) (2024-09-18)


### Features

* Updates UserAuthorizer to support retrieving token response directly with different client auth types ([#1486](https://github.com/googleapis/google-auth-library-java/issues/1486)) ([1651006](https://github.com/googleapis/google-auth-library-java/commit/16510064e861868f649b6bc8fdc54b8a39890812))

## [1.25.0](https://github.com/googleapis/google-auth-library-java/compare/v1.24.1...v1.25.0) (2024-09-03)


### Features

* Support retrieving ID Token from IAM endpoint for ServiceAccountCredentials ([#1433](https://github.com/googleapis/google-auth-library-java/issues/1433)) ([4fcf83e](https://github.com/googleapis/google-auth-library-java/commit/4fcf83e0f96de0e6323b85b9a47119a257b37e90))


### Bug Fixes

* ComputeEngineCredentials.createScoped should invalidate existing AccessToken ([#1428](https://github.com/googleapis/google-auth-library-java/issues/1428)) ([079a065](https://github.com/googleapis/google-auth-library-java/commit/079a06563114e359b74694b78aec687601a2f628))
* Invalidate the SA's AccessToken when createScoped() is called ([#1489](https://github.com/googleapis/google-auth-library-java/issues/1489)) ([f26fee7](https://github.com/googleapis/google-auth-library-java/commit/f26fee78d69fce1aaa00dbd5548f3e0266ee6441))

## [1.24.1](https://github.com/googleapis/google-auth-library-java/compare/v1.24.0...v1.24.1) (2024-08-13)


### Bug Fixes

* Retry sign blob call  with exponential backoff ([#1452](https://github.com/googleapis/google-auth-library-java/issues/1452)) ([d42f30a](https://github.com/googleapis/google-auth-library-java/commit/d42f30acae7c7bd81afbecbfa83ebde5c6db931a))

## [1.24.0](https://github.com/googleapis/google-auth-library-java/compare/v1.23.0...v1.24.0) (2024-07-09)


### Features

* [java] allow passing libraries_bom_version from env ([#1967](https://github.com/googleapis/google-auth-library-java/issues/1967)) ([#1407](https://github.com/googleapis/google-auth-library-java/issues/1407)) ([d92b421](https://github.com/googleapis/google-auth-library-java/commit/d92b421c8fa9c22dda47b49f5ebec7f6ac2658a9))
* Next release from main branch is 1.21.0 ([#1372](https://github.com/googleapis/google-auth-library-java/issues/1372)) ([23c3cbe](https://github.com/googleapis/google-auth-library-java/commit/23c3cbe70fdce49a3075e15ba965739704a87ace))


### Bug Fixes

* Makes default token url universe aware ([#1383](https://github.com/googleapis/google-auth-library-java/issues/1383)) ([e3caf05](https://github.com/googleapis/google-auth-library-java/commit/e3caf05831011dc05d3a8b01ebf79305eda70183))
* Remove Base64 padding in DefaultPKCEProvider ([#1375](https://github.com/googleapis/google-auth-library-java/issues/1375)) ([1405378](https://github.com/googleapis/google-auth-library-java/commit/1405378b05469841a3683bc914f47b92437abcfc))


### Documentation

* Add supplier sections to table of contents ([#1371](https://github.com/googleapis/google-auth-library-java/issues/1371)) ([9e11763](https://github.com/googleapis/google-auth-library-java/commit/9e11763e79127b3691533488482575adef6f73d2))
* Adds docs for supplier based external account credentials ([#1362](https://github.com/googleapis/google-auth-library-java/issues/1362)) ([bd898c6](https://github.com/googleapis/google-auth-library-java/commit/bd898c64875a87414f84ca0787ba6c140e05921b))
* Fix readme documentation for workload custom suppliers. ([#1382](https://github.com/googleapis/google-auth-library-java/issues/1382)) ([75bd749](https://github.com/googleapis/google-auth-library-java/commit/75bd749985e2d507dc48863408067950fcda3ef1))

## [1.23.0](https://github.com/googleapis/google-auth-library-java/compare/v1.22.0...v1.23.0) (2024-02-05)


### Features

* Add context object to pass to supplier functions ([#1363](https://github.com/googleapis/google-auth-library-java/issues/1363)) ([1d9efc7](https://github.com/googleapis/google-auth-library-java/commit/1d9efc78aa6ab24fc2aab5f081240a815c394c95))
* Adds support for user defined subject token suppliers in AWSCredentials and IdentityPoolCredentials ([#1336](https://github.com/googleapis/google-auth-library-java/issues/1336)) ([64ce8a1](https://github.com/googleapis/google-auth-library-java/commit/64ce8a1fbb82cb19e17ca0c6713c7c187078c28b))
* Adds universe domain for DownscopedCredentials and ExternalAccountAuthorizedUserCredentials ([#1355](https://github.com/googleapis/google-auth-library-java/issues/1355)) ([17ef707](https://github.com/googleapis/google-auth-library-java/commit/17ef70748aae4820f10694ae99c82ed7ca89dbce))
* Modify the refresh window to match go/async-token-refresh. Serverless tokens are cached until 4 minutes before expiration, so 4 minutes is the ideal refresh window. ([#1352](https://github.com/googleapis/google-auth-library-java/issues/1352)) ([a7a8d7a](https://github.com/googleapis/google-auth-library-java/commit/a7a8d7a4102b0b7c1b83791947ccb662f060eca7))


### Bug Fixes

* Add missing copyright header ([#1364](https://github.com/googleapis/google-auth-library-java/issues/1364)) ([a24e563](https://github.com/googleapis/google-auth-library-java/commit/a24e5631b8198d988a7b82deab5453e43917b0d2))
* Issue [#1347](https://github.com/googleapis/google-auth-library-java/issues/1347): ExternalAccountCredentials serialization is broken ([#1358](https://github.com/googleapis/google-auth-library-java/issues/1358)) ([e3a2e9c](https://github.com/googleapis/google-auth-library-java/commit/e3a2e9cbdd767c4664d895f98f69d8b742d645f0))
* Refactor compute and cloudshell credentials to pass quota project to base class ([#1284](https://github.com/googleapis/google-auth-library-java/issues/1284)) ([fb75239](https://github.com/googleapis/google-auth-library-java/commit/fb75239ead37b6677a392f38ea2ef2012b3f21e0))

## [1.22.0](https://github.com/googleapis/google-auth-library-java/compare/v1.21.0...v1.22.0) (2024-01-09)


### Features

* Adds universe domain support for compute credentials ([#1346](https://github.com/googleapis/google-auth-library-java/issues/1346)) ([7e26861](https://github.com/googleapis/google-auth-library-java/commit/7e268611d2c2152e84702b1c67ca846902bbe2d5))


### Bug Fixes

* Handle error-prone warnings ([#1334](https://github.com/googleapis/google-auth-library-java/issues/1334)) ([927cad8](https://github.com/googleapis/google-auth-library-java/commit/927cad835567cd6619ca51c97546831b0f13edec))

## [1.21.0](https://github.com/googleapis/google-auth-library-java/compare/v1.20.0...v1.21.0) (2023-12-21)


### Features

* Add code sample and test for getting an access token from an impersonated SA ([#1289](https://github.com/googleapis/google-auth-library-java/issues/1289)) ([826ee40](https://github.com/googleapis/google-auth-library-java/commit/826ee4007d3e0600dfdf42383f56dbcf6cdd4cec))
* Multi universe support, adding universe_domain field ([#1282](https://github.com/googleapis/google-auth-library-java/issues/1282)) ([7eb322e](https://github.com/googleapis/google-auth-library-java/commit/7eb322e3af6bce85774b2a1051242a4b62b53963))


### Bug Fixes

* Remove -Xlint:unchecked, suppress all existing violations, add @CanIgnoreReturnValue ([#1324](https://github.com/googleapis/google-auth-library-java/issues/1324)) ([04dfd40](https://github.com/googleapis/google-auth-library-java/commit/04dfd40c57b89c2d55327d5ea08036d749ebac02))


### Documentation

* Update README.md to link to Cloud authentication documentation rather than AIPs ([98fc7e1](https://github.com/googleapis/google-auth-library-java/commit/98fc7e1f2f551d59811de63eaef0df6bf8e21c2c))

## [1.20.0](https://github.com/googleapis/google-auth-library-java/compare/v1.19.0...v1.20.0) (2023-09-19)


### Features

* Byoid metrics framework ([#1232](https://github.com/googleapis/google-auth-library-java/issues/1232)) ([38bdf60](https://github.com/googleapis/google-auth-library-java/commit/38bdf60189b44171f5d481fa934f4ece60553653))


### Bug Fixes

* Make derived classes of CredentialSource public ([#1236](https://github.com/googleapis/google-auth-library-java/issues/1236)) ([9bb9e0a](https://github.com/googleapis/google-auth-library-java/commit/9bb9e0a67c503415a69f35e390f6c64357fc7be1))


### Documentation

* Update library definitions in README to the latest version ([#1239](https://github.com/googleapis/google-auth-library-java/issues/1239)) ([0c5cff2](https://github.com/googleapis/google-auth-library-java/commit/0c5cff26fc66ad90d2dbccd374c6ead81f66d569))

## [1.19.0](https://github.com/googleapis/google-auth-library-java/compare/v1.18.0...v1.19.0) (2023-06-27)


### Features

* Expose test-jar and mock classes in oauth2 ([12e8db6](https://github.com/googleapis/google-auth-library-java/commit/12e8db6025e0263b801d5385844924a4f5ff7b7e))

## [1.18.0](https://github.com/googleapis/google-auth-library-java/compare/v1.17.1...v1.18.0) (2023-06-16)


### Features

* Introduce a way to pass additional parameters to auhtorization url ([#1134](https://github.com/googleapis/google-auth-library-java/issues/1134)) ([3a2c5d3](https://github.com/googleapis/google-auth-library-java/commit/3a2c5d3d1abf23bce0af7f958240b5f9ee9d1bf8))

## [1.17.1](https://github.com/googleapis/google-auth-library-java/compare/v1.17.0...v1.17.1) (2023-05-25)


### Dependencies

* Update doclet version to v1.9.0 ([#1211](https://github.com/googleapis/google-auth-library-java/issues/1211)) ([8b6e28e](https://github.com/googleapis/google-auth-library-java/commit/8b6e28e00aa609edefceafbb4f2c1dbc10afd6f9))

## [1.17.0](https://github.com/googleapis/google-auth-library-java/compare/v1.16.1...v1.17.0) (2023-05-20)


### Features

* Adds universe_domain to external account creds ([#1199](https://github.com/googleapis/google-auth-library-java/issues/1199)) ([608ee87](https://github.com/googleapis/google-auth-library-java/commit/608ee87c92b3e6c355541b50e39387b03deebdf8))
* Expose method to manually obtain ADC from gcloud CLI well-known… ([#1188](https://github.com/googleapis/google-auth-library-java/issues/1188)) ([2fa9d52](https://github.com/googleapis/google-auth-library-java/commit/2fa9d5211569f802948ed2d1aaf13f7d37f8409c))
* Updating readme for external account authorized user credentials ([#1200](https://github.com/googleapis/google-auth-library-java/issues/1200)) ([bf25574](https://github.com/googleapis/google-auth-library-java/commit/bf255749b7b403cc5f7538f6e901d9089f529fca))


### Bug Fixes

* Do not expose universe_domain yet ([#1206](https://github.com/googleapis/google-auth-library-java/issues/1206)) ([9cce49c](https://github.com/googleapis/google-auth-library-java/commit/9cce49cbba26892e573629b4d11a375eb6ec28fc))
* Improve errors and warnings related to ADC ([#1172](https://github.com/googleapis/google-auth-library-java/issues/1172)) ([6d2251c](https://github.com/googleapis/google-auth-library-java/commit/6d2251cd8e87b018a65a9296bb5c10f487b304cb))
* Marking 503 as retryable for Compute credentials ([#1205](https://github.com/googleapis/google-auth-library-java/issues/1205)) ([8ea9445](https://github.com/googleapis/google-auth-library-java/commit/8ea9445a3b738e74c6fc0b59f593b32ef0df5314))

## [1.16.1](https://github.com/googleapis/google-auth-library-java/compare/v1.16.0...v1.16.1) (2023-04-07)


### Bug Fixes

* Make supporting classes of AwsCredentials serializable ([#1113](https://github.com/googleapis/google-auth-library-java/issues/1113)) ([82bf871](https://github.com/googleapis/google-auth-library-java/commit/82bf871125b8473677a499c979ab9a843972c930))
* Remove AWS credential source validation. ([#1177](https://github.com/googleapis/google-auth-library-java/issues/1177)) ([77a99c9](https://github.com/googleapis/google-auth-library-java/commit/77a99c9cfab3c1ce2db50c92e89fc292efaeb3ab))

## [1.16.0](https://github.com/googleapis/google-auth-library-java/compare/v1.15.0...v1.16.0) (2023-02-15)


### Features

* Add PKCE to 3LO exchange. ([#1146](https://github.com/googleapis/google-auth-library-java/issues/1146)) ([5bf606b](https://github.com/googleapis/google-auth-library-java/commit/5bf606bb8f6d863b44e87587eebf51eaeea4a0ae))


### Bug Fixes

* Create and reuse self signed jwt creds for better performance ([#1154](https://github.com/googleapis/google-auth-library-java/issues/1154)) ([eaaa8e8](https://github.com/googleapis/google-auth-library-java/commit/eaaa8e89cf69d1e0d581443121f315854d52c75f))
* Java doc for DefaultPKCEProvider.java ([#1148](https://github.com/googleapis/google-auth-library-java/issues/1148)) ([154c127](https://github.com/googleapis/google-auth-library-java/commit/154c1279b3ec96cc34a3225e5e78800ccdda927c))
* Removed url pattern validation for google urls in external account credential configurations ([#1150](https://github.com/googleapis/google-auth-library-java/issues/1150)) ([35495b1](https://github.com/googleapis/google-auth-library-java/commit/35495b1207ffe11712ee996d3e305449752fb87c))


### Documentation

* Clarified Maven artifact for HTTP-based clients ([#1136](https://github.com/googleapis/google-auth-library-java/issues/1136)) ([b49fc13](https://github.com/googleapis/google-auth-library-java/commit/b49fc13b10d0e326c7296e2aad7a50ea03e774f5))

## [1.15.0](https://github.com/googleapis/google-auth-library-java/compare/v1.14.0...v1.15.0) (2023-01-25)


### Features

* Adds external account authorized user credentials ([#1129](https://github.com/googleapis/google-auth-library-java/issues/1129)) ([06bf21a](https://github.com/googleapis/google-auth-library-java/commit/06bf21a6ce9478a35907bd6681e53a0e86ffc83f))
* Expose scopes granted by user ([#1107](https://github.com/googleapis/google-auth-library-java/issues/1107)) ([240c26b](https://github.com/googleapis/google-auth-library-java/commit/240c26bf11652e208469c2a6ea2fc2f383343c25))


### Bug Fixes

* AccessToken scopes clean serialization and default as empty list ([#1125](https://github.com/googleapis/google-auth-library-java/issues/1125)) ([f55d41f](https://github.com/googleapis/google-auth-library-java/commit/f55d41fa90750464a37a452ff03a8b811ae93425))
* Enforce Locale.US for AwsRequestSignerTest ([#1111](https://github.com/googleapis/google-auth-library-java/issues/1111)) ([aeb1218](https://github.com/googleapis/google-auth-library-java/commit/aeb12182241e75cba664975a83bbcfa2449fb0f5))
* Ensure both refreshMargin and expirationMargin are set when using OAuth2CredentialsWithRefresh ([#1131](https://github.com/googleapis/google-auth-library-java/issues/1131)) ([326e4a1](https://github.com/googleapis/google-auth-library-java/commit/326e4a15dae72b3806b7a640843d7abc669b19c6))

## [1.14.0](https://github.com/googleapis/google-auth-library-java/compare/v1.13.0...v1.14.0) (2022-12-06)


### Features

* Add GDCH support ([#1087](https://github.com/googleapis/google-auth-library-java/issues/1087)) ([cfafb2d](https://github.com/googleapis/google-auth-library-java/commit/cfafb2d4c8d6ab3179e709ff09fc09e6dbc11a70))
* Adding functional tests for Compute Engine ([#1105](https://github.com/googleapis/google-auth-library-java/issues/1105)) ([6f32ac3](https://github.com/googleapis/google-auth-library-java/commit/6f32ac3d4db91ff05fd7134ad6c788a16ffe44f4))
* Introduce Environment Variable for Quota Project Id ([#1082](https://github.com/googleapis/google-auth-library-java/issues/1082)) ([040acef](https://github.com/googleapis/google-auth-library-java/commit/040acefec507f419f6e4ec4eab9645a6e3888a15))
* Next release from main branch is 1.13.0 ([#1077](https://github.com/googleapis/google-auth-library-java/issues/1077)) ([d56eee0](https://github.com/googleapis/google-auth-library-java/commit/d56eee07911ba65a685ccba585e71061037ea756))


### Bug Fixes

* AwsCredentials should not call metadata server if security creds and region are retrievable through environment vars ([#1100](https://github.com/googleapis/google-auth-library-java/issues/1100)) ([1ff5772](https://github.com/googleapis/google-auth-library-java/commit/1ff57720609fdf27f28b9c543c1ef63b57892593))
* Not loosing the access token when calling UserCredentials#ToBuil… ([#993](https://github.com/googleapis/google-auth-library-java/issues/993)) ([84afdb8](https://github.com/googleapis/google-auth-library-java/commit/84afdb8f8d41e781dc93f04626411e10b35689de))

## [1.13.0](https://github.com/googleapis/google-auth-library-java/compare/v1.12.1...v1.13.0) (2022-11-15)


### Features

* Add smbios check for GCE residency detection ([#1092](https://github.com/googleapis/google-auth-library-java/issues/1092)) ([bfe7d93](https://github.com/googleapis/google-auth-library-java/commit/bfe7d932dbbbaf6b311c387834256519a0d1b9ad))


### Bug Fixes

* Empty string check for aws url validation ([#1089](https://github.com/googleapis/google-auth-library-java/issues/1089)) ([6f177a1](https://github.com/googleapis/google-auth-library-java/commit/6f177a1346ac481f34ab7cf343d552dcd88b7220))
* Validate url domain for aws metadata urls ([#1079](https://github.com/googleapis/google-auth-library-java/issues/1079)) ([31fe461](https://github.com/googleapis/google-auth-library-java/commit/31fe461ac86e92fdff41bb17f0abc9b2a132676c))

## [1.12.1](https://github.com/googleapis/google-auth-library-java/compare/v1.12.0...v1.12.1) (2022-10-18)


### Bug Fixes

* Resolve race condition reported in [#692](https://github.com/googleapis/google-auth-library-java/issues/692) ([#1031](https://github.com/googleapis/google-auth-library-java/issues/1031)) ([87a6606](https://github.com/googleapis/google-auth-library-java/commit/87a66067dff49d68f5b01cfe4c3f755fbf6b44fb))

## [1.12.0](https://github.com/googleapis/google-auth-library-java/compare/v1.11.0...v1.12.0) (2022-10-14)


### Features

* Adding validation for psc endpoints ([#1042](https://github.com/googleapis/google-auth-library-java/issues/1042)) ([b37a565](https://github.com/googleapis/google-auth-library-java/commit/b37a565c6c1e7acb44baf2307c862c9df8be9345))


### Bug Fixes

* Fixed javadoc errors ([#945](https://github.com/googleapis/google-auth-library-java/issues/945)) ([1ddc994](https://github.com/googleapis/google-auth-library-java/commit/1ddc99481ae8b0f0eceb4cb442d5c6614ec8a411))


### Documentation

* **samples:** Modified comments in the samples and minor refactor ([#990](https://github.com/googleapis/google-auth-library-java/issues/990)) ([669ab04](https://github.com/googleapis/google-auth-library-java/commit/669ab042844e46d0503bbd31fd2da92a7963bad5))

## [1.11.0](https://github.com/googleapis/google-auth-library-java/compare/v1.10.0...v1.11.0) (2022-09-08)


### Features

* Adds configurable token lifetime support ([#982](https://github.com/googleapis/google-auth-library-java/issues/982)) ([0198733](https://github.com/googleapis/google-auth-library-java/commit/0198733b9d294cbee95f1170f814fbfe94baa6fc))


### Bug Fixes

* Add retries to public key fetch ([#983](https://github.com/googleapis/google-auth-library-java/issues/983)) ([1200a39](https://github.com/googleapis/google-auth-library-java/commit/1200a39361e2a1767ef95306ba3ece1b749e82a8))
* Add Test to validate 0x20 in token ([#971](https://github.com/googleapis/google-auth-library-java/issues/971)) ([612db0a](https://github.com/googleapis/google-auth-library-java/commit/612db0af3afa70b5400891ba3c7eab18ea5eb6bf))
* Change revoke request from get to post ([#979](https://github.com/googleapis/google-auth-library-java/issues/979)) ([ead58b2](https://github.com/googleapis/google-auth-library-java/commit/ead58b22e04c00ece9f0ea55cbec20d2953f5460))
* Setting the retry count to default value and enabling ioexceptions to retry ([#988](https://github.com/googleapis/google-auth-library-java/issues/988)) ([257071a](https://github.com/googleapis/google-auth-library-java/commit/257071aeb39c4441bd152813d727f83d433f346f))
* Updates IdTokenVerifier so that it does not cache a failed public key response  ([#967](https://github.com/googleapis/google-auth-library-java/issues/967)) ([1f4c9c7](https://github.com/googleapis/google-auth-library-java/commit/1f4c9c77a38fb6dfb751447361af9cf00964f96b))

## [1.10.0](https://github.com/googleapis/google-auth-library-java/compare/v1.9.0...v1.10.0) (2022-08-05)


### Features

* workforce identity federation for pluggable auth ([#959](https://github.com/googleapis/google-auth-library-java/issues/959)) ([7f2c535](https://github.com/googleapis/google-auth-library-java/commit/7f2c535ab7c842a672d6761f4cd80df88e1a37ed))


### Bug Fixes

* updates executable response spec for executable-sourced credentials ([#955](https://github.com/googleapis/google-auth-library-java/issues/955)) ([48ff83d](https://github.com/googleapis/google-auth-library-java/commit/48ff83dc68e29dcae07fdea963cbbe5525f86a89))


### Documentation

* **samples:** added auth samples and tests ([#927](https://github.com/googleapis/google-auth-library-java/issues/927)) ([32c717f](https://github.com/googleapis/google-auth-library-java/commit/32c717fdf1a721f3e7ca3d75f03fcc229923689c))

## [1.9.0](https://github.com/googleapis/google-auth-library-java/compare/v1.8.1...v1.9.0) (2022-08-02)


### Features

* integration tests for pluggable auth ([#939](https://github.com/googleapis/google-auth-library-java/issues/939)) ([22f37aa](https://github.com/googleapis/google-auth-library-java/commit/22f37aa687b7ffb4209a131860ccdd02f6fc4d42))


### Bug Fixes

* expiration time of the ImpersonatedCredentials token depending on the current host's timezone ([#932](https://github.com/googleapis/google-auth-library-java/issues/932)) ([73af08a](https://github.com/googleapis/google-auth-library-java/commit/73af08a1c5f14e18936e9dbd3d1ba29c2675961d))


### Documentation

* update wif documentation with enable-imdsv2 flag ([#940](https://github.com/googleapis/google-auth-library-java/issues/940)) ([acc1ce3](https://github.com/googleapis/google-auth-library-java/commit/acc1ce3603435f1c0cf23b8606af71b05e566f2f))

## [1.8.1](https://github.com/googleapis/google-auth-library-java/compare/v1.8.0...v1.8.1) (2022-07-13)


### Bug Fixes

* enable longpaths support for windows test ([#1485](https://github.com/googleapis/google-auth-library-java/issues/1485)) ([#943](https://github.com/googleapis/google-auth-library-java/issues/943)) ([c21ec6c](https://github.com/googleapis/google-auth-library-java/commit/c21ec6c952b8bb8fb8bc2e2f1b260beb330a3cd2))

## [1.8.0](https://github.com/googleapis/google-auth-library-java/compare/v1.7.0...v1.8.0) (2022-06-27)


### Features

* add build scripts for native image testing in Java 17 ([#1440](https://github.com/googleapis/google-auth-library-java/issues/1440)) ([#923](https://github.com/googleapis/google-auth-library-java/issues/923)) ([bbb51ce](https://github.com/googleapis/google-auth-library-java/commit/bbb51ce7a9265cb991739cd90e1ccf65675d05dc))
* Adds Pluggable Auth support (WIF) ([#908](https://github.com/googleapis/google-auth-library-java/issues/908)) ([c3e8d16](https://github.com/googleapis/google-auth-library-java/commit/c3e8d169704943735c6b3df7bd0187f04fdd9aa5))


### Documentation

* updates README for Pluggable Auth  ([#921](https://github.com/googleapis/google-auth-library-java/issues/921)) ([23716b8](https://github.com/googleapis/google-auth-library-java/commit/23716b82fb3000f5210bb5604127aad7ef52cb76))

## [1.7.0](https://github.com/googleapis/google-auth-library-java/compare/v1.6.0...v1.7.0) (2022-05-12)


### Features

* Add ability to provide PrivateKey as Pkcs8 encoded string [#883](https://github.com/googleapis/google-auth-library-java/issues/883) ([#889](https://github.com/googleapis/google-auth-library-java/issues/889)) ([e0d6996](https://github.com/googleapis/google-auth-library-java/commit/e0d6996ac0db1bf75d92e5aba3eaab512affafe4))
* Add iam endpoint override to ImpersonatedCredentials ([#910](https://github.com/googleapis/google-auth-library-java/issues/910)) ([97bfc4c](https://github.com/googleapis/google-auth-library-java/commit/97bfc4c8ceb199e775784ac3ed4fa992d4d2dcbf))


### Bug Fixes

* update branding in ExternalAccountCredentials ([#893](https://github.com/googleapis/google-auth-library-java/issues/893)) ([0200dbb](https://github.com/googleapis/google-auth-library-java/commit/0200dbb05cff06a333879cf99bac64adaada3239))

## [1.6.0](https://github.com/googleapis/google-auth-library-java/compare/v1.5.3...v1.6.0) (2022-03-15)


### Features

* Add AWS Session Token to Metadata Requests ([#850](https://github.com/googleapis/google-auth-library-java/issues/850)) ([577e9a5](https://github.com/googleapis/google-auth-library-java/commit/577e9a52204b0d6026a302bb7efe2c6162d57945))


### Bug Fixes

* ImmutableSet converted to List for Impersonated Credentials ([#732](https://github.com/googleapis/google-auth-library-java/issues/732)) ([7dcd549](https://github.com/googleapis/google-auth-library-java/commit/7dcd549c4ef0617e657315b7a718368fbd162997))
* update library docs ([#868](https://github.com/googleapis/google-auth-library-java/issues/868)) ([a081015](https://github.com/googleapis/google-auth-library-java/commit/a081015cb72ade91c022b58261c8d253e46a7793))

### [1.5.3](https://github.com/googleapis/google-auth-library-java/compare/v1.5.2...v1.5.3) (2022-02-24)


### Bug Fixes

* **ci:** downgrade nexus-staging-maven-plugin to 1.6.8 ([#874](https://github.com/googleapis/google-auth-library-java/issues/874)) ([fc331d4](https://github.com/googleapis/google-auth-library-java/commit/fc331d466286d99cb3c6aa8977d34fd5f224eff7))

### [1.5.2](https://github.com/googleapis/google-auth-library-java/compare/v1.5.1...v1.5.2) (2022-02-24)


### Bug Fixes

* downgrading nexus staging plugin 1.6.8 ([#871](https://github.com/googleapis/google-auth-library-java/issues/871)) ([e87224c](https://github.com/googleapis/google-auth-library-java/commit/e87224cca10d5d24523a5c3ac1e829fd51089f0c))

### [1.5.1](https://github.com/googleapis/google-auth-library-java/compare/v1.5.0...v1.5.1) (2022-02-22)


### Bug Fixes

* **deps:** update dependency org.apache.maven.plugins:maven-javadoc-plugin to v3.3.2 ([#852](https://github.com/googleapis/google-auth-library-java/issues/852)) ([aa557c7](https://github.com/googleapis/google-auth-library-java/commit/aa557c7545941d712339b4b62a413997a54bcccc))

## [1.5.0](https://github.com/googleapis/google-auth-library-java/compare/v1.4.0...v1.5.0) (2022-02-14)


### Features

* update retries and implement Retryable ([#750](https://github.com/googleapis/google-auth-library-java/issues/750)) ([f9a9b8a](https://github.com/googleapis/google-auth-library-java/commit/f9a9b8ace0199e6b75ed42c7bacfa3be30c34111))


### Dependencies

* **java:** update actions/github-script action to v5 ([#1339](https://github.com/googleapis/google-auth-library-java/issues/1339)) ([#843](https://github.com/googleapis/google-auth-library-java/issues/843)) ([ce44591](https://github.com/googleapis/google-auth-library-java/commit/ce445910198e7b78c9500ab148a1b6b99268185e))

## [1.4.0](https://github.com/googleapis/google-auth-library-java/compare/v1.3.0...v1.4.0) (2022-01-19)


### Features

* setting the audience to always point to google token endpoint ([#833](https://github.com/googleapis/google-auth-library-java/issues/833)) ([33bfe7a](https://github.com/googleapis/google-auth-library-java/commit/33bfe7a788a524324cd9b0a54acc8917f6b75556))


### Bug Fixes

* (WIF) remove erroneous check for the subject token field name for text credential source ([#822](https://github.com/googleapis/google-auth-library-java/issues/822)) ([6d35c68](https://github.com/googleapis/google-auth-library-java/commit/6d35c681cf397ff2a90363184e26ee5850294c41))
* **java:** add -ntp flag to native image testing command ([#1299](https://github.com/googleapis/google-auth-library-java/issues/1299)) ([#807](https://github.com/googleapis/google-auth-library-java/issues/807)) ([aa6654a](https://github.com/googleapis/google-auth-library-java/commit/aa6654a639ea15bcce7c7a6e86f170b1345895f0))
* **java:** run Maven in plain console-friendly mode ([#1301](https://github.com/googleapis/google-auth-library-java/issues/1301)) ([#818](https://github.com/googleapis/google-auth-library-java/issues/818)) ([4df45d0](https://github.com/googleapis/google-auth-library-java/commit/4df45d0d03a973f1beff43d8965c26289f217f22))

## [1.3.0](https://www.github.com/googleapis/google-auth-library-java/compare/v1.2.2...v1.3.0) (2021-11-10)


### Features

* next release from main branch is 1.3.0 ([#780](https://www.github.com/googleapis/google-auth-library-java/issues/780)) ([1149581](https://www.github.com/googleapis/google-auth-library-java/commit/1149581e63267e3553c74ba2114d849c5b24f27b))


### Bug Fixes

* **java:** java 17 dependency arguments ([#1266](https://www.github.com/googleapis/google-auth-library-java/issues/1266)) ([#779](https://www.github.com/googleapis/google-auth-library-java/issues/779)) ([9160a53](https://www.github.com/googleapis/google-auth-library-java/commit/9160a53e6507c1c938795e181c65ad80db1bcf11))
* service account impersonation with workforce credentials ([#770](https://www.github.com/googleapis/google-auth-library-java/issues/770)) ([6449ef0](https://www.github.com/googleapis/google-auth-library-java/commit/6449ef0922053121a6732933ab9e246965fde3b7))

### [1.2.2](https://www.github.com/googleapis/google-auth-library-java/compare/v1.2.1...v1.2.2) (2021-10-20)


### Bug Fixes

* environment variable is "AWS_SESSION_TOKEN" and not "Token" ([#772](https://www.github.com/googleapis/google-auth-library-java/issues/772)) ([c8c3073](https://www.github.com/googleapis/google-auth-library-java/commit/c8c3073790ca2f660eabd2c410b0e295f693040b))

### [1.2.1](https://www.github.com/googleapis/google-auth-library-java/compare/v1.2.0...v1.2.1) (2021-10-11)


### Bug Fixes

* disabling self-signed jwt for domain wide delegation ([#754](https://www.github.com/googleapis/google-auth-library-java/issues/754)) ([ac70a27](https://www.github.com/googleapis/google-auth-library-java/commit/ac70a279bdaf681507d7815264a3f5e92fd2aaa6))

## [1.2.0](https://www.github.com/googleapis/google-auth-library-java/compare/v1.1.0...v1.2.0) (2021-09-30)


### Features

* add support for Workforce Pools ([#729](https://www.github.com/googleapis/google-auth-library-java/issues/729)) ([5f3fed7](https://www.github.com/googleapis/google-auth-library-java/commit/5f3fed79e22f3c2d585c5b03c01791b0f8109929))


### Bug Fixes

* allow empty workforce_pool_user_project ([#752](https://www.github.com/googleapis/google-auth-library-java/issues/752)) ([e1cbce1](https://www.github.com/googleapis/google-auth-library-java/commit/e1cbce1a5cb269c6613bc6d40f06145bd45099c0))
* timing of stale token refreshes on ComputeEngine ([#749](https://www.github.com/googleapis/google-auth-library-java/issues/749)) ([c813d55](https://www.github.com/googleapis/google-auth-library-java/commit/c813d55a78053ecbec1a9640e6c9814da87319eb))
* workforce audience ([#741](https://www.github.com/googleapis/google-auth-library-java/issues/741)) ([a08cacc](https://www.github.com/googleapis/google-auth-library-java/commit/a08cacc7990b9058c8f1af3f9d8d816119562cc4))

## [1.1.0](https://www.github.com/googleapis/google-auth-library-java/compare/v1.0.0...v1.1.0) (2021-08-17)


### Features

* downscoping with credential access boundaries ([#702](https://www.github.com/googleapis/google-auth-library-java/issues/702)) ([aa7ede1](https://www.github.com/googleapis/google-auth-library-java/commit/aa7ede1d1c688ba437798f4204820c0506d5d969))


### Bug Fixes

* add validation for the token URL and service account impersonation URL for Workload Identity Federation ([#717](https://www.github.com/googleapis/google-auth-library-java/issues/717)) ([23cb8ef](https://www.github.com/googleapis/google-auth-library-java/commit/23cb8ef778d012bbd452c1dfdac5f096d1af6c95))


### Documentation

* updates README for downscoping with CAB ([#716](https://www.github.com/googleapis/google-auth-library-java/issues/716)) ([68bceba](https://www.github.com/googleapis/google-auth-library-java/commit/68bceba21c05870f6eb616cc057ddf0521c581b8))

## [1.0.0](https://www.github.com/googleapis/google-auth-library-java/compare/v0.27.0...v1.0.0) (2021-07-28)


### ⚠ BREAKING CHANGES

* updating google-auth-library-java min Java version to 1.8

### Features

* GA release of google-auth-library-java (ver 1.0.0) ([#704](https://www.github.com/googleapis/google-auth-library-java/issues/704)) ([3d9874f](https://www.github.com/googleapis/google-auth-library-java/commit/3d9874f1c91dfa10d6f72d41e922b3f1ec654943))
* updating google-auth-library-java min Java version to 1.8 ([3d9874f](https://www.github.com/googleapis/google-auth-library-java/commit/3d9874f1c91dfa10d6f72d41e922b3f1ec654943))


### Bug Fixes

* Add shopt -s nullglob to dependencies script ([#693](https://www.github.com/googleapis/google-auth-library-java/issues/693)) ([c5aa708](https://www.github.com/googleapis/google-auth-library-java/commit/c5aa7084d9ca817a53cf6bac14d442adeeaeb310))
* Update dependencies.sh to not break on mac ([c5aa708](https://www.github.com/googleapis/google-auth-library-java/commit/c5aa7084d9ca817a53cf6bac14d442adeeaeb310))

## [0.27.0](https://www.github.com/googleapis/google-auth-library-java/compare/v0.26.0...v0.27.0) (2021-07-14)


### Features

* add Id token support for UserCredentials ([#650](https://www.github.com/googleapis/google-auth-library-java/issues/650)) ([5a8f467](https://www.github.com/googleapis/google-auth-library-java/commit/5a8f4676630854c53aa708a9c8b960770067f858))
* add impersonation credentials to ADC  ([#613](https://www.github.com/googleapis/google-auth-library-java/issues/613)) ([b9823f7](https://www.github.com/googleapis/google-auth-library-java/commit/b9823f70d7f3f7461b7de40bee06f5e7ba0e797c))
* Adding functional tests for Service Account  ([#685](https://www.github.com/googleapis/google-auth-library-java/issues/685)) ([dfe118c](https://www.github.com/googleapis/google-auth-library-java/commit/dfe118c261aadf137a3cf47a7acb9892c7a6db4d))
* allow scopes for self signed jwt ([#689](https://www.github.com/googleapis/google-auth-library-java/issues/689)) ([f4980c7](https://www.github.com/googleapis/google-auth-library-java/commit/f4980c77566bbd5ef4c532acb199d7d484dbcd01))

## [0.26.0](https://www.github.com/googleapis/google-auth-library-java/compare/v0.25.5...v0.26.0) (2021-05-20)


### Features

* add `gcf-owl-bot[bot]` to `ignoreAuthors` ([#674](https://www.github.com/googleapis/google-auth-library-java/issues/674)) ([359b20f](https://www.github.com/googleapis/google-auth-library-java/commit/359b20f24f88e09b6b104c61ca63a1b604ea64d2))
* added getter for credentials object in HttpCredentialsAdapter ([#658](https://www.github.com/googleapis/google-auth-library-java/issues/658)) ([5a946ea](https://www.github.com/googleapis/google-auth-library-java/commit/5a946ea5e0d974611f2205f468236db4b931e486))
* enable pre-emptive async oauth token refreshes ([#646](https://www.github.com/googleapis/google-auth-library-java/issues/646)) ([e3f4c7e](https://www.github.com/googleapis/google-auth-library-java/commit/e3f4c7eac0417705553ef8259599ec29fc8ad9b4))
* Returning an issuer claim on request errors ([#656](https://www.github.com/googleapis/google-auth-library-java/issues/656)) ([95d70ae](https://www.github.com/googleapis/google-auth-library-java/commit/95d70ae0f5f4c985455f913ddef14ebe75500656))


### Bug Fixes

* use orginal url as audience for self signed jwt if scheme or host is null ([#642](https://www.github.com/googleapis/google-auth-library-java/issues/642)) ([b4e6f1a](https://www.github.com/googleapis/google-auth-library-java/commit/b4e6f1a0bd17dd31edc85ed4879cea75857fd747))

### [0.25.5](https://www.github.com/googleapis/google-auth-library-java/compare/v0.25.4...v0.25.5) (2021-04-22)


### Dependencies

* update autovalue to 1.8.1 ([#638](https://www.github.com/googleapis/google-auth-library-java/issues/638)) ([62cd356](https://www.github.com/googleapis/google-auth-library-java/commit/62cd3564a93abe3cbbe083ac9b7aaebe4608b4bd))

### [0.25.4](https://www.github.com/googleapis/google-auth-library-java/compare/v0.25.3...v0.25.4) (2021-04-15)


### Bug Fixes

* release scripts from issuing overlapping phases ([#634](https://www.github.com/googleapis/google-auth-library-java/issues/634)) ([b8d851e](https://www.github.com/googleapis/google-auth-library-java/commit/b8d851e1ac97b71e986c9afccca42021be3f9dd1))
* typo ([#632](https://www.github.com/googleapis/google-auth-library-java/issues/632)) ([d860608](https://www.github.com/googleapis/google-auth-library-java/commit/d8606083b6632e26463aac0a0d1e92835d2fbcd0))

### [0.25.3](https://www.github.com/googleapis/google-auth-library-java/compare/v0.25.2...v0.25.3) (2021-04-12)


### Dependencies

* update guava patch ([#628](https://www.github.com/googleapis/google-auth-library-java/issues/628)) ([8ff3207](https://www.github.com/googleapis/google-auth-library-java/commit/8ff320755e44f937590196bcbefa8c9537244af6))

### [0.25.2](https://www.github.com/googleapis/google-auth-library-java/compare/v0.25.1...v0.25.2) (2021-03-18)


### Bug Fixes

* follow up fix service account credentials createScopedRequired ([#605](https://www.github.com/googleapis/google-auth-library-java/issues/605)) ([7ddac43](https://www.github.com/googleapis/google-auth-library-java/commit/7ddac43c418bb8b0cc3fd8d4f9d8752ad65bd842))
* support AWS_DEFAULT_REGION env var ([#599](https://www.github.com/googleapis/google-auth-library-java/issues/599)) ([3d066ee](https://www.github.com/googleapis/google-auth-library-java/commit/3d066ee4755c20e2bd44b234dff71df1c4815aec))

### [0.25.1](https://www.github.com/googleapis/google-auth-library-java/compare/v0.25.0...v0.25.1) (2021-03-18)


### Bug Fixes

* fix service account credentials createScopedRequired ([#601](https://www.github.com/googleapis/google-auth-library-java/issues/601)) ([0614482](https://www.github.com/googleapis/google-auth-library-java/commit/061448209da05ddfc75b40aae495c33d0ee7f1ee))

## [0.25.0](https://www.github.com/googleapis/google-auth-library-java/compare/v0.24.1...v0.25.0) (2021-03-16)


### Features

* add self signed jwt support ([#572](https://www.github.com/googleapis/google-auth-library-java/issues/572)) ([efe103a](https://www.github.com/googleapis/google-auth-library-java/commit/efe103a2e688ca915ec9925a72c49bb2a1b3c3b5))

### [0.24.1](https://www.github.com/googleapis/google-auth-library-java/compare/v0.24.0...v0.24.1) (2021-02-25)


### Dependencies

* update dependency com.google.http-client:google-http-client-bom to v1.39.0 ([#580](https://www.github.com/googleapis/google-auth-library-java/issues/580)) ([88718b0](https://www.github.com/googleapis/google-auth-library-java/commit/88718b0185ee6a3ff1168ac68621be0c5ff0efab))

## [0.24.0](https://www.github.com/googleapis/google-auth-library-java/compare/v0.23.0...v0.24.0) (2021-02-19)


### Features

* add workload identity federation support ([#547](https://www.github.com/googleapis/google-auth-library-java/issues/547)) ([b8dde1e](https://www.github.com/googleapis/google-auth-library-java/commit/b8dde1e43f86a0a00741790c12d73f6cbda6251d))


### Bug Fixes

* don't log downloads ([#576](https://www.github.com/googleapis/google-auth-library-java/issues/576)) ([6181030](https://www.github.com/googleapis/google-auth-library-java/commit/61810306dc0e18500a4a6b2704e00842fbecd879))


### Documentation

* add instructions for using workload identity federation ([#564](https://www.github.com/googleapis/google-auth-library-java/issues/564)) ([2142db3](https://www.github.com/googleapis/google-auth-library-java/commit/2142db314666f298071ae30a7419b00d48d87476))

## [0.23.0](https://www.github.com/googleapis/google-auth-library-java/compare/v0.22.2...v0.23.0) (2021-01-26)


### ⚠ BREAKING CHANGES

* privatize deprecated constructor (#473)

### Features

* allow custom lifespan for impersonated creds ([#515](https://www.github.com/googleapis/google-auth-library-java/issues/515)) ([0707ed4](https://www.github.com/googleapis/google-auth-library-java/commit/0707ed4bbb40fb775f196004ee30f8c695fe662b))
* allow custom scopes for compute engine creds ([#514](https://www.github.com/googleapis/google-auth-library-java/issues/514)) ([edc8d6e](https://www.github.com/googleapis/google-auth-library-java/commit/edc8d6e0e7ca2c6749d026ba42854a09c4879fd6))
* allow set lifetime for service account creds ([#516](https://www.github.com/googleapis/google-auth-library-java/issues/516)) ([427f2d5](https://www.github.com/googleapis/google-auth-library-java/commit/427f2d5610f0e8184a21b24531d2549a68c0b546))
* promote IdToken and JWT features ([#538](https://www.github.com/googleapis/google-auth-library-java/issues/538)) ([b514fe0](https://www.github.com/googleapis/google-auth-library-java/commit/b514fe0cebe5a294e0cf97b7b5349e6a523dc7b2))


### Bug Fixes

* per google style, logger is lower case ([#529](https://www.github.com/googleapis/google-auth-library-java/issues/529)) ([ecfc6a2](https://www.github.com/googleapis/google-auth-library-java/commit/ecfc6a2ea6060e06629b5d422b23b842b917f55e))
* privatize deprecated constructor ([#473](https://www.github.com/googleapis/google-auth-library-java/issues/473)) ([5804ff0](https://www.github.com/googleapis/google-auth-library-java/commit/5804ff03a531268831ac797ab262638a3119c14f))
* remove deprecated methods ([#537](https://www.github.com/googleapis/google-auth-library-java/issues/537)) ([427963e](https://www.github.com/googleapis/google-auth-library-java/commit/427963e04702d8b73eca5ed555539b11bbe97342))
* replace non-precondition use of Preconditions ([#539](https://www.github.com/googleapis/google-auth-library-java/issues/539)) ([f2ab4f1](https://www.github.com/googleapis/google-auth-library-java/commit/f2ab4f14262d54de0fde85494cfd92cf01a30cbe))
* switch to GSON ([#531](https://www.github.com/googleapis/google-auth-library-java/issues/531)) ([1b98d5c](https://www.github.com/googleapis/google-auth-library-java/commit/1b98d5c86fc5e56187c977e7f43c39bb62483d40))
* use default timeout if given 0 for ImpersonatedCredentials ([#527](https://www.github.com/googleapis/google-auth-library-java/issues/527)) ([ec74870](https://www.github.com/googleapis/google-auth-library-java/commit/ec74870c372a33d4157b45bb5d59ad7464fb2238))


### Dependencies

* update dependency com.google.appengine:appengine-api-1.0-sdk to v1.9.84 ([#422](https://www.github.com/googleapis/google-auth-library-java/issues/422)) ([b262c45](https://www.github.com/googleapis/google-auth-library-java/commit/b262c4587b058e6837429ee05f1b6a63620ee598))
* update dependency com.google.guava:guava to v30.1-android ([#522](https://www.github.com/googleapis/google-auth-library-java/issues/522)) ([4090d1c](https://www.github.com/googleapis/google-auth-library-java/commit/4090d1cb50041bceb1cd975d1a9249a412df936f))


### Documentation

* fix wording in jwtWithClaims Javadoc ([#536](https://www.github.com/googleapis/google-auth-library-java/issues/536)) ([af21727](https://www.github.com/googleapis/google-auth-library-java/commit/af21727815263fb5ffc07ede953cf042fac3ac2b))

### [0.22.2](https://www.github.com/googleapis/google-auth-library-java/compare/v0.22.1...v0.22.2) (2020-12-11)


### Bug Fixes

* quotaProjectId should be applied for cached `getRequestMetadata(URI, Executor, RequestMetadataCallback)` ([#509](https://www.github.com/googleapis/google-auth-library-java/issues/509)) ([0a8412f](https://www.github.com/googleapis/google-auth-library-java/commit/0a8412fcf9de4ac568b9f88618e44087dd31b144))

### [0.22.1](https://www.github.com/googleapis/google-auth-library-java/compare/v0.22.0...v0.22.1) (2020-11-05)


### Bug Fixes

* remove 1 hour limit for impersonated token ([#490](https://www.github.com/googleapis/google-auth-library-java/issues/490)) ([927e3d5](https://www.github.com/googleapis/google-auth-library-java/commit/927e3d5598e2d2b06512b27f4210994c65b26f59))


### Dependencies

* update dependency com.google.guava:guava to v30 ([#497](https://www.github.com/googleapis/google-auth-library-java/issues/497)) ([0551649](https://www.github.com/googleapis/google-auth-library-java/commit/055164969d175718ee8f2c0369b84bcddc1d7134))
* update dependency com.google.http-client:google-http-client-bom to v1.38.0 ([#503](https://www.github.com/googleapis/google-auth-library-java/issues/503)) ([46f20bc](https://www.github.com/googleapis/google-auth-library-java/commit/46f20bca8b5951ebea6a963b3affde2b92d403c7))

## [0.22.0](https://www.github.com/googleapis/google-auth-library-java/compare/v0.21.1...v0.22.0) (2020-10-13)


### Features

* add logging at FINE level for each step of ADC ([#435](https://www.github.com/googleapis/google-auth-library-java/issues/435)) ([7d145b2](https://www.github.com/googleapis/google-auth-library-java/commit/7d145b2371033093ea13fd05520c90970a5ef363))


### Documentation

* remove bad javadoc tags ([#478](https://www.github.com/googleapis/google-auth-library-java/issues/478)) ([a329c41](https://www.github.com/googleapis/google-auth-library-java/commit/a329c4171735c3d4ee574978e6c3742b96c01f74))


### Dependencies

* update dependency com.google.http-client:google-http-client-bom to v1.37.0 ([#486](https://www.github.com/googleapis/google-auth-library-java/issues/486)) ([3027fbf](https://www.github.com/googleapis/google-auth-library-java/commit/3027fbfaf017f5aa5a22cc51cd38a522597729c0))

### [0.21.1](https://www.github.com/googleapis/google-auth-library-java/compare/v0.21.0...v0.21.1) (2020-07-07)


### Dependencies

* update google-http-client to 1.36.0 ([#447](https://www.github.com/googleapis/google-auth-library-java/issues/447)) ([b913d19](https://www.github.com/googleapis/google-auth-library-java/commit/b913d194259e4f93bb401a844480f56b48dad3bd)), closes [#446](https://www.github.com/googleapis/google-auth-library-java/issues/446)

## [0.21.0](https://www.github.com/googleapis/google-auth-library-java/compare/v0.20.0...v0.21.0) (2020-06-24)


### Features

* add TokenVerifier class that can verify RS256/ES256 tokens ([#420](https://www.github.com/googleapis/google-auth-library-java/issues/420)) ([5014ac7](https://www.github.com/googleapis/google-auth-library-java/commit/5014ac72a59d877ef95c616d0b33792b9fc70c25))


### Dependencies

* update autovalue packages to v1.7.2 ([#429](https://www.github.com/googleapis/google-auth-library-java/issues/429)) ([5758364](https://www.github.com/googleapis/google-auth-library-java/commit/575836405bd5803d6202bd0018609184d6a15831))
* update dependency com.google.http-client:google-http-client-bom to v1.35.0 ([#427](https://www.github.com/googleapis/google-auth-library-java/issues/427)) ([5494ec0](https://www.github.com/googleapis/google-auth-library-java/commit/5494ec0a73319fb955b3d7ba025aea9607020c4e))
* update Guava to 29.0-android ([#426](https://www.github.com/googleapis/google-auth-library-java/issues/426)) ([0cd3c2e](https://www.github.com/googleapis/google-auth-library-java/commit/0cd3c2ec0aef3ff0f0379b32f9d05126442219b6))

## [0.20.0](https://www.github.com/googleapis/google-auth-library-java/compare/v0.19.0...v0.20.0) (2020-01-15)


### Features

* updated `JwtClaims.Builder` methods to `public` ([#396](https://www.github.com/googleapis/google-auth-library-java/issues/396)) ([9e5de14](https://www.github.com/googleapis/google-auth-library-java/commit/9e5de14263a01d746af2fc192cf1b82a2acff35c))


### Dependencies

* update guava to 28.2-android ([#389](https://www.github.com/googleapis/google-auth-library-java/issues/389)) ([70bd8ff](https://www.github.com/googleapis/google-auth-library-java/commit/70bd8ff15a9b0cb1dab9f350bd49dd60b2da33c7))

## [0.19.0](https://www.github.com/googleapis/google-auth-library-java/compare/v0.18.0...v0.19.0) (2019-12-13)


### Features

* support reading in quotaProjectId for billing ([#383](https://www.github.com/googleapis/google-auth-library-java/issues/383)) ([f38c3c8](https://www.github.com/googleapis/google-auth-library-java/commit/f38c3c84748fadc1591f092edd1974539cf7b644))


### Dependencies

* update appengine-sdk to 1.9.76 ([#366](https://www.github.com/googleapis/google-auth-library-java/issues/366)) ([590883d](https://www.github.com/googleapis/google-auth-library-java/commit/590883d57158275b988b5e6c7f6d608eaa3c08ad))
* update autovalue packages to v1.7 ([#365](https://www.github.com/googleapis/google-auth-library-java/issues/365)) ([42a1694](https://www.github.com/googleapis/google-auth-library-java/commit/42a169463ab3c36552e2eea605571ee9808f346c))
* update dependency com.google.appengine:appengine to v1.9.77 ([#377](https://www.github.com/googleapis/google-auth-library-java/issues/377)) ([c3c950e](https://www.github.com/googleapis/google-auth-library-java/commit/c3c950e7d906aaa4187305a5fd9b05785e19766a))
* update dependency com.google.http-client:google-http-client-bom to v1.33.0 ([#374](https://www.github.com/googleapis/google-auth-library-java/issues/374)) ([af0af50](https://www.github.com/googleapis/google-auth-library-java/commit/af0af5061f4544b8b5bb43c82d2ab66c08143b90))


### Documentation

* remove outdated comment on explicit IP address ([#370](https://www.github.com/googleapis/google-auth-library-java/issues/370)) ([71faa5f](https://www.github.com/googleapis/google-auth-library-java/commit/71faa5f6f26ef2f267743248b828d636d99a9d50))
* xml syntax error in bom/README.md ([#372](https://www.github.com/googleapis/google-auth-library-java/issues/372)) ([ff8606a](https://www.github.com/googleapis/google-auth-library-java/commit/ff8606a608f9261a9714ceda823479f156f65643)), closes [#371](https://www.github.com/googleapis/google-auth-library-java/issues/371)

### [0.18.0](https://www.github.com/googleapis/google-auth-library-java/compare/v0.17.2...v0.18.0) (2019-10-09)


### Bug Fixes

* make JwtClaims.newBuilder() public ([#350](https://www.github.com/googleapis/google-auth-library-java/issues/350)) ([6ab8758](https://www.github.com/googleapis/google-auth-library-java/commit/6ab8758))
* move autovalue into annotation processor path instead of classpath ([#358](https://www.github.com/googleapis/google-auth-library-java/issues/358)) ([a82d348](https://www.github.com/googleapis/google-auth-library-java/commit/a82d348))


### Dependencies

* update Guava to 28.1 ([#353](https://www.github.com/googleapis/google-auth-library-java/issues/353)) ([f4f05be](https://www.github.com/googleapis/google-auth-library-java/commit/f4f05be))


### Documentation

* fix include instructions in google-auth-library-bom README ([#352](https://www.github.com/googleapis/google-auth-library-java/issues/352)) ([f649735](https://www.github.com/googleapis/google-auth-library-java/commit/f649735))

### [0.17.4](https://www.github.com/googleapis/google-auth-library-java/compare/v0.18.0...v0.17.4) (2019-10-08)


### Bug Fixes

* make JwtClaims.newBuilder() public ([#350](https://www.github.com/googleapis/google-auth-library-java/issues/350)) ([6ab8758](https://www.github.com/googleapis/google-auth-library-java/commit/6ab8758))
* move autovalue into annotation processor path instead of classpath ([#358](https://www.github.com/googleapis/google-auth-library-java/issues/358)) ([a82d348](https://www.github.com/googleapis/google-auth-library-java/commit/a82d348))


### Dependencies

* update Guava to 28.1 ([#353](https://www.github.com/googleapis/google-auth-library-java/issues/353)) ([f4f05be](https://www.github.com/googleapis/google-auth-library-java/commit/f4f05be))


### Documentation

* fix include instructions in google-auth-library-bom README ([#352](https://www.github.com/googleapis/google-auth-library-java/issues/352)) ([f649735](https://www.github.com/googleapis/google-auth-library-java/commit/f649735))

### [0.17.2](https://www.github.com/googleapis/google-auth-library-java/compare/v0.17.1...v0.17.2) (2019-09-24)


### Bug Fixes

* typo in BOM dependency ([#345](https://www.github.com/googleapis/google-auth-library-java/issues/345)) ([a1d63bb](https://www.github.com/googleapis/google-auth-library-java/commit/a1d63bb))

### [0.17.1](https://www.github.com/googleapis/google-auth-library-java/compare/v0.17.0...v0.17.1) (2019-08-22)


### Bug Fixes

* allow unset/null privateKeyId for JwtCredentials ([#336](https://www.github.com/googleapis/google-auth-library-java/issues/336)) ([d28a6ed](https://www.github.com/googleapis/google-auth-library-java/commit/d28a6ed))

## [0.17.0](https://www.github.com/googleapis/google-auth-library-java/compare/v0.16.2...v0.17.0) (2019-08-16)


### Bug Fixes

* cleanup unused code and deprecation warnings ([#315](https://www.github.com/googleapis/google-auth-library-java/issues/315)) ([7fd94c0](https://www.github.com/googleapis/google-auth-library-java/commit/7fd94c0))
* Fix declared dependencies from merge issue ([#291](https://www.github.com/googleapis/google-auth-library-java/issues/291)) ([35abf13](https://www.github.com/googleapis/google-auth-library-java/commit/35abf13))
* throw SigningException as documented ([#316](https://www.github.com/googleapis/google-auth-library-java/issues/316)) ([a1ab97c](https://www.github.com/googleapis/google-auth-library-java/commit/a1ab97c))
* typo in ComputeEngineCredentials exception message ([#313](https://www.github.com/googleapis/google-auth-library-java/issues/313)) ([1a16f38](https://www.github.com/googleapis/google-auth-library-java/commit/1a16f38))


### Features

* add Automatic-Module-Name to manifest ([#326](https://www.github.com/googleapis/google-auth-library-java/issues/326)) ([29f58b4](https://www.github.com/googleapis/google-auth-library-java/commit/29f58b4)), closes [#324](https://www.github.com/googleapis/google-auth-library-java/issues/324) [#324](https://www.github.com/googleapis/google-auth-library-java/issues/324)
* add IDTokenCredential support ([#303](https://www.github.com/googleapis/google-auth-library-java/issues/303)) ([a87e3fd](https://www.github.com/googleapis/google-auth-library-java/commit/a87e3fd))
* add JwtCredentials with custom claims ([#290](https://www.github.com/googleapis/google-auth-library-java/issues/290)) ([3f37172](https://www.github.com/googleapis/google-auth-library-java/commit/3f37172))
* allow arbitrary additional claims for JwtClaims ([#331](https://www.github.com/googleapis/google-auth-library-java/issues/331)) ([888c61c](https://www.github.com/googleapis/google-auth-library-java/commit/888c61c))
* Implement ServiceAccountSigner for ImpersonatedCredentials ([#279](https://www.github.com/googleapis/google-auth-library-java/issues/279)) ([70767e3](https://www.github.com/googleapis/google-auth-library-java/commit/70767e3))


### Reverts

* "build: run in debug mode ([#319](https://www.github.com/googleapis/google-auth-library-java/issues/319))" ([#320](https://www.github.com/googleapis/google-auth-library-java/issues/320)) ([de79e14](https://www.github.com/googleapis/google-auth-library-java/commit/de79e14))

## [0.16.2](https://www.github.com/googleapis/google-auth-library-java/compare/v0.16.1...v0.16.2) (2019-06-26)


### Bug Fixes

* Add metadata-flavor header to metadata server ping for compute engine ([#283](https://github.com/googleapis/google-auth-library-java/pull/283))


### Dependencies

* Import http client bom for dependency management ([#268](https://github.com/googleapis/google-auth-library-java/pull/268))


### Documentation

* README section for interop with google-http-client ([#275](https://github.com/googleapis/google-auth-library-java/pull/275))


## [0.16.1](https://www.github.com/googleapis/google-auth-library-java/compare/v0.16.0...v0.16.1) (2019-06-06)


### Dependencies

* Update dependency com.google.http-client:google-http-client to v1.30.1 ([#265](https://github.com/googleapis/google-auth-library-java/pull/265))


## [0.16.0](https://www.github.com/googleapis/google-auth-library-java/compare/v0.15.0...v0.16.0) (2019-06-04)


### Features

* Add google-auth-library-bom artifact ([#256](https://github.com/googleapis/google-auth-library-java/pull/256))


### Dependencies

* Update dependency com.google.http-client:google-http-client to v1.30.0 ([#261](https://github.com/googleapis/google-auth-library-java/pull/261))
* Update dependency com.google.http-client:google-http-client to v1.29.2 ([#259](https://github.com/googleapis/google-auth-library-java/pull/259))
* Update dependency org.sonatype.plugins:nexus-staging-maven-plugin to v1.6.8 ([#257](https://github.com/googleapis/google-auth-library-java/pull/257))
* Update to latest app engine SDK version ([#258](https://github.com/googleapis/google-auth-library-java/pull/258))
* Update dependency org.apache.maven.plugins:maven-source-plugin to v3.1.0 ([#254](https://github.com/googleapis/google-auth-library-java/pull/254))
* Update dependency org.jacoco:jacoco-maven-plugin to v0.8.4 ([#255](https://github.com/googleapis/google-auth-library-java/pull/255))
* Update dependency org.apache.maven.plugins:maven-jar-plugin to v3.1.2 ([#252](https://github.com/googleapis/google-auth-library-java/pull/252))
* Update dependency org.apache.maven.plugins:maven-source-plugin to v2.4 ([#253](https://github.com/googleapis/google-auth-library-java/pull/253))


### Documentation

* Javadoc publish kokoro job uses docpublisher ([#243](https://github.com/googleapis/google-auth-library-java/pull/243))


## [0.15.0](https://www.github.com/googleapis/google-auth-library-java/compare/v0.14.0...v0.15.0) (2019-03-27)


### Bug Fixes

* createScoped: make overload call implementation ([#229](https://github.com/googleapis/google-auth-library-java/pull/229))


### Reverts

* Add back in deprecated methods in ServiceAccountJwtAccessCredentials ([#238](https://github.com/googleapis/google-auth-library-java/pull/238))


## [0.14.0](https://www.github.com/googleapis/google-auth-library-java/compare/v0.13.0...v0.14.0) (2019-03-26)


### Bug Fixes

* update default metadata url ([#230](https://github.com/googleapis/google-auth-library-java/pull/230))
* Remove deprecated methods ([#190](https://github.com/googleapis/google-auth-library-java/pull/190))
* Update Sign Blob API ([#232](https://github.com/googleapis/google-auth-library-java/pull/232))


### Dependencies

* Upgrade http client to 1.29.0. ([#235](https://github.com/googleapis/google-auth-library-java/pull/235))
* update deps ([#234](https://github.com/googleapis/google-auth-library-java/pull/234))


## [0.13.0](https://www.github.com/googleapis/google-auth-library-java/compare/v0.12.0...v0.13.0) (2019-01-17)


### Bug Fixes

* Use OutputStream directly instead of PrintWriter ([#220](https://github.com/googleapis/google-auth-library-java/pull/220))
* Improve log output when detecting GCE ([#214](https://github.com/googleapis/google-auth-library-java/pull/214))


### Features

* Overload GoogleCredentials.createScoped with variadic arguments ([#218](https://github.com/googleapis/google-auth-library-java/pull/218))


### Dependencies

* Update google-http-client version, guava, and maven surefire plugin ([#221](https://github.com/googleapis/google-auth-library-java/pull/221))


## [0.12.0](https://www.github.com/googleapis/google-auth-library-java/compare/v0.11.0...v0.12.0) (2018-12-19)


### Bug Fixes

* Show error message in case of problems with getting access token ([#206](https://github.com/googleapis/google-auth-library-java/pull/206))
* Add note about `NO_GCE_CHECK` to metadata 404 error message ([#205](https://github.com/googleapis/google-auth-library-java/pull/205))


### Features

* Add ImpersonatedCredentials ([#211](https://github.com/googleapis/google-auth-library-java/pull/211))
* Add option to suppress end user credentials warning. ([#207](https://github.com/googleapis/google-auth-library-java/pull/207))


### Dependencies

* Update google-http-java-client dependency to 1.27.0 ([#208](https://github.com/googleapis/google-auth-library-java/pull/208))


### Documentation

* README grammar fix ([#192](https://github.com/googleapis/google-auth-library-java/pull/192))
* Add unstable badge to README ([#184](https://github.com/googleapis/google-auth-library-java/pull/184))
* Update README with instructions on installing the App Engine SDK and running the tests ([#209](https://github.com/googleapis/google-auth-library-java/pull/209))


## [0.11.0](https://www.github.com/googleapis/google-auth-library-java/compare/v0.10.0...v0.11.0) (2018-08-23)


### Bug Fixes

* Update auth token urls (#174)


### Dependencies

* Update dependencies (guava) (#170)
* Bumping google-http-client version to 1.24.1 (#171)


### Documentation

* Documentation for ComputeEngineCredential signing. (#176)
* Fix README link (#169)


## [0.10.0](https://www.github.com/googleapis/google-auth-library-java/compare/v0.9.1...v0.10.0) (2018-06-12)


### Bug Fixes

* Read token_uri from service account JSON (#160)
* Log warning if default credentials uses a user token from gcloud sdk (#166)


### Features

* Add OAuth2Credentials#refreshIfExpired() (#163)
* ComputeEngineCredentials implements ServiceAccountSigner (#141)


### Documentation

* Versionless Javadocs (#164)
* Fix documentation for `getAccessToken()` returning cached value (#162)


## [0.9.1](https://www.github.com/googleapis/google-auth-library-java/compare/v0.9.0...v0.9.1) (2018-04-09)


### Features

* Add caching for JWT tokens (#151)


## [0.9.0](https://www.github.com/googleapis/google-auth-library-java/compare/v0.8.0...v0.9.0) (2017-11-02)


### Bug Fixes

* Fix NPE deserializing ServiceAccountCredentials (#132)


### Features

* Surface cleanup (#136)
* Providing a method to remove CredentialsChangedListeners (#130)
* Implemented in-memory TokenStore and added opportunity to save user credentials into file (#129)


### Documentation

* Fixes comment typos. (#131)


## [0.8.0](https://www.github.com/googleapis/google-auth-library-java/compare/v0.7.1...v0.8.0) (2017-09-08)


### Bug Fixes

* Extracting the project_id field from service account JSON files (#118)
* Fixing an Integer Overflow Issue (#121)
* use metadata server to get credentials for GAE 8 standard environment (#122)


### Features

* Switch OAuth2 HTTP surface to use builder pattern (#123)
* Add builder pattern to AppEngine credentials (#125)


### Documentation

* Fix API Documentation link rendering (#112)


## [0.7.1](https://www.github.com/googleapis/google-auth-library-java/compare/v0.7.0...v0.7.1) (2017-07-14)


### Bug Fixes

* Mitigate occasional failures in looking up Application Default Credentials on a Google Compute Engine (GCE) Virtual Machine (#110)


## [0.7.0](https://www.github.com/googleapis/google-auth-library-java/compare/v0.6.1...v0.7.0) (2017-06-06)


### Bug Fixes

* Retry HTTP errors in `ServiceAccountCredentials.refreshAccessToken()` to avoid propagating failures (#100 addresses #91)


### Features

* Add `GoogleCredentials.createDelegated()` method to allow using domain-wide delegation with service accounts (#102)
* Allow bypassing App Engine credential check using environment variable, to allow Application Default Credentials to detect GCE when running on GAE Flex (#103)
