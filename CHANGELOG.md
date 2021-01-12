# Changelog

### [1.8.2](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.8.1...v1.8.2) (2021-01-12)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.17.1 ([#778](https://www.github.com/googleapis/java-bigquerystorage/issues/778)) ([b4099d0](https://www.github.com/googleapis/java-bigquerystorage/commit/b4099d0bcd80a650d491996b3dc3def81bdd97ef))

### [1.8.1](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.8.0...v1.8.1) (2021-01-11)


### Dependencies

* update dependency com.fasterxml.jackson.core:jackson-core to v2.12.1 ([#770](https://www.github.com/googleapis/java-bigquerystorage/issues/770)) ([2f276bd](https://www.github.com/googleapis/java-bigquerystorage/commit/2f276bdf254a06f38a87d9ab93bd73334dd19927))

## [1.8.0](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.7.2...v1.8.0) (2021-01-05)


### Features

* add default stream support for StreamWriter ([#744](https://www.github.com/googleapis/java-bigquerystorage/issues/744)) ([248ab73](https://www.github.com/googleapis/java-bigquerystorage/commit/248ab73eebb9feda94e7e29de591a70c91a064c1))
* better default stream support in client library ([#750](https://www.github.com/googleapis/java-bigquerystorage/issues/750)) ([488f258](https://www.github.com/googleapis/java-bigquerystorage/commit/488f2589a793ef9efcab64a9bed9af05f5b1620d)), closes [#749](https://www.github.com/googleapis/java-bigquerystorage/issues/749) [#746](https://www.github.com/googleapis/java-bigquerystorage/issues/746)
* remove IgnoreUnknownFields support on JsonStreamWriter ([#757](https://www.github.com/googleapis/java-bigquerystorage/issues/757)) ([0988105](https://www.github.com/googleapis/java-bigquerystorage/commit/09881051a98f7d1675c3ec0850ef36dbe2ffa481))
* updates to Write API v1beta2 public interface, migrate to Java microgenerator ([#728](https://www.github.com/googleapis/java-bigquerystorage/issues/728)) ([2fc5968](https://www.github.com/googleapis/java-bigquerystorage/commit/2fc59689dfe64be6c23104493f690f476a0cda7f))


### Bug Fixes

* An extra test that is still calling old JsonStreamWriter append ([#760](https://www.github.com/googleapis/java-bigquerystorage/issues/760)) ([af72e6e](https://www.github.com/googleapis/java-bigquerystorage/commit/af72e6e9b4100e4f47fad4139437a04aa3ee7535))
* enable tests that are disabled due to breaking change and stop ignoring ALREADY_EXISTED error ([#748](https://www.github.com/googleapis/java-bigquerystorage/issues/748)) ([8caf5a2](https://www.github.com/googleapis/java-bigquerystorage/commit/8caf5a26baf865c55405363f9d78756bce2d5219))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v1.126.3 ([#739](https://www.github.com/googleapis/java-bigquerystorage/issues/739)) ([29f2bac](https://www.github.com/googleapis/java-bigquerystorage/commit/29f2bacb49e977d2e2007123c0c935add264cbc0))

### [1.7.2](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.7.1...v1.7.2) (2020-12-15)


### Bug Fixes

* Disable Breaking change related code site ([#731](https://www.github.com/googleapis/java-bigquerystorage/issues/731)) ([d180293](https://www.github.com/googleapis/java-bigquerystorage/commit/d180293b47484c6257ae065f7ea2a5a6be8a5383))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.17.0 ([#735](https://www.github.com/googleapis/java-bigquerystorage/issues/735)) ([131d7a7](https://www.github.com/googleapis/java-bigquerystorage/commit/131d7a7626adebf9a0c97ffb2b0183a55086b5f7))

### [1.7.1](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.7.0...v1.7.1) (2020-12-14)


### Bug Fixes

* a build break caused by breaking change. ([#729](https://www.github.com/googleapis/java-bigquerystorage/issues/729)) ([a1b1c8e](https://www.github.com/googleapis/java-bigquerystorage/commit/a1b1c8edce87a8d33faf1067f617e3f47c4afc45))
* A test race in JsonStreamWriterTest  ([#722](https://www.github.com/googleapis/java-bigquerystorage/issues/722)) ([35fe606](https://www.github.com/googleapis/java-bigquerystorage/commit/35fe606e43a47dfe844666bf3e385f9c2e582977))
* Add special type tests for Json writer and fix some type mapping issues ([#725](https://www.github.com/googleapis/java-bigquerystorage/issues/725)) ([ab6213c](https://www.github.com/googleapis/java-bigquerystorage/commit/ab6213c244162c74242d3aaf543bfcf9b2eb4405))
* Temporally disable test/code where breaking change is used to help pushing out the breaking change in unreleased Beta ([#727](https://www.github.com/googleapis/java-bigquerystorage/issues/727)) ([38c95c2](https://www.github.com/googleapis/java-bigquerystorage/commit/38c95c23459eb9c4a7215b1a3cb5243165f79815))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.16.1 ([d70bc3e](https://www.github.com/googleapis/java-bigquerystorage/commit/d70bc3e211ec579129ba53679572b49187f6b6e5))

## [1.7.0](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.6.7...v1.7.0) (2020-12-09)


### Features

* v1beta2 manual client library for BigQueryWrite ([#714](https://www.github.com/googleapis/java-bigquerystorage/issues/714)) ([53a9c3a](https://www.github.com/googleapis/java-bigquerystorage/commit/53a9c3aaf7e6a17d10ceecaf9cef5eb3e81a58ee))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v1.126.0 ([#708](https://www.github.com/googleapis/java-bigquerystorage/issues/708)) ([24a98c8](https://www.github.com/googleapis/java-bigquerystorage/commit/24a98c88b5531210efa8ba7b474f89d9b790df16))
* update dependency com.google.cloud:google-cloud-bigquery to v1.126.1 ([#716](https://www.github.com/googleapis/java-bigquerystorage/issues/716)) ([03aa545](https://www.github.com/googleapis/java-bigquerystorage/commit/03aa5455baf29e10b5938829f340ce865574453d))

### [1.6.7](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.6.6...v1.6.7) (2020-12-03)


### Dependencies

* update dependency org.apache.avro:avro to v1.10.1 ([#703](https://www.github.com/googleapis/java-bigquerystorage/issues/703)) ([9b5480a](https://www.github.com/googleapis/java-bigquerystorage/commit/9b5480af03b104c8b3c76e88534e39644570296a))

### [1.6.6](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.6.5...v1.6.6) (2020-12-02)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.16.0 ([#696](https://www.github.com/googleapis/java-bigquerystorage/issues/696)) ([dae7ee0](https://www.github.com/googleapis/java-bigquerystorage/commit/dae7ee00839c0f1fce728c19d8974d49a5f4805d))

### [1.6.5](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.6.4...v1.6.5) (2020-12-02)


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v1.125.0 ([#682](https://www.github.com/googleapis/java-bigquerystorage/issues/682)) ([978b304](https://www.github.com/googleapis/java-bigquerystorage/commit/978b30429bd7daa4f462f2bcc5a4feacb0a63c5a))

### [1.6.4](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.6.3...v1.6.4) (2020-11-16)


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v1.124.6 ([#676](https://www.github.com/googleapis/java-bigquerystorage/issues/676)) ([3f3d665](https://www.github.com/googleapis/java-bigquerystorage/commit/3f3d6651ecd8193580091ab51fc3aaa19e879dec))

### [1.6.3](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.6.2...v1.6.3) (2020-11-12)


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v1.124.5 ([#666](https://www.github.com/googleapis/java-bigquerystorage/issues/666)) ([eeccba7](https://www.github.com/googleapis/java-bigquerystorage/commit/eeccba734676aaa873e59b1ebf86726b04e48747))

### [1.6.2](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.6.1...v1.6.2) (2020-11-11)


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v1.124.4 ([#653](https://www.github.com/googleapis/java-bigquerystorage/issues/653)) ([48fb650](https://www.github.com/googleapis/java-bigquerystorage/commit/48fb6502884c0df6c962a7e2be841110e1b6c9ee))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.15.0 ([#662](https://www.github.com/googleapis/java-bigquerystorage/issues/662)) ([6cf80d8](https://www.github.com/googleapis/java-bigquerystorage/commit/6cf80d87f3766359eda172324249bbe6c0461111))

### [1.6.1](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.6.0...v1.6.1) (2020-11-01)


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v1.124.0 ([#644](https://www.github.com/googleapis/java-bigquerystorage/issues/644)) ([1f08141](https://www.github.com/googleapis/java-bigquerystorage/commit/1f08141e865322ea71c5cccfe459eb089d364ee8))
* update dependency com.google.cloud:google-cloud-bigquery to v1.124.1 ([#648](https://www.github.com/googleapis/java-bigquerystorage/issues/648)) ([8077e9f](https://www.github.com/googleapis/java-bigquerystorage/commit/8077e9f31385ad770585d7d611e4b42f21aa1673))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.14.1 ([#650](https://www.github.com/googleapis/java-bigquerystorage/issues/650)) ([8bc7210](https://www.github.com/googleapis/java-bigquerystorage/commit/8bc72109956c9b26d5ab53ea777d196c267b1681))

## [1.6.0](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.5.6...v1.6.0) (2020-10-27)


### Features

* bigquery Write API V1Beta2 public interface. ([#637](https://www.github.com/googleapis/java-bigquerystorage/issues/637)) ([bb21e7b](https://www.github.com/googleapis/java-bigquerystorage/commit/bb21e7bc2b206e7720855d032889f4bc45121f9a))


### Bug Fixes

* remove stream ttl in client library, since there is no very clear TTL defined. ([#627](https://www.github.com/googleapis/java-bigquerystorage/issues/627)) ([2ae69b6](https://www.github.com/googleapis/java-bigquerystorage/commit/2ae69b640adc48b79f0aab71c215eb3ef055a34c))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v1.123.1 ([#632](https://www.github.com/googleapis/java-bigquerystorage/issues/632)) ([7b5fc9b](https://www.github.com/googleapis/java-bigquerystorage/commit/7b5fc9b917035ca3b419b71abb0f9d6a4ca59950))
* update dependency com.google.cloud:google-cloud-bigquery to v1.123.2 ([#633](https://www.github.com/googleapis/java-bigquerystorage/issues/633)) ([bf6260e](https://www.github.com/googleapis/java-bigquerystorage/commit/bf6260ebe01d040e42f3eb4b3b8262054f9316bf))

### [1.5.6](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.5.5...v1.5.6) (2020-10-20)


### Bug Fixes

* Due to backend issues resolved, we no longer need to wait for 5 seconds between reconnection ([#610](https://www.github.com/googleapis/java-bigquerystorage/issues/610)) ([f536fc7](https://www.github.com/googleapis/java-bigquerystorage/commit/f536fc7c998ac7d6c54e7d8b3bb7f9a2d6b5626b))
* test failure due to message start appending entity ([#609](https://www.github.com/googleapis/java-bigquerystorage/issues/609)) ([63b1762](https://www.github.com/googleapis/java-bigquerystorage/commit/63b17629c62bb06f2651e914ff2988def5107ae7))


### Dependencies

* update arrow.version to v2 ([#613](https://www.github.com/googleapis/java-bigquerystorage/issues/613)) ([4b07ee2](https://www.github.com/googleapis/java-bigquerystorage/commit/4b07ee26fea5b58fbf18f342c3e9d5220361d45e))
* update dependency com.google.cloud:google-cloud-bigquery to v1.123.0 ([#618](https://www.github.com/googleapis/java-bigquerystorage/issues/618)) ([d565550](https://www.github.com/googleapis/java-bigquerystorage/commit/d56555042f886b81eb74701f3ed87cf4fea2fc72))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.11.0 ([#601](https://www.github.com/googleapis/java-bigquerystorage/issues/601)) ([0527f44](https://www.github.com/googleapis/java-bigquerystorage/commit/0527f447826e2829801bbdfcd6db55b6e79acb32))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.12.1 ([#615](https://www.github.com/googleapis/java-bigquerystorage/issues/615)) ([dfc6436](https://www.github.com/googleapis/java-bigquerystorage/commit/dfc6436353ec2a00cd4ecb3c47503757177e33a9))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.13.0 ([#619](https://www.github.com/googleapis/java-bigquerystorage/issues/619)) ([4a24bf8](https://www.github.com/googleapis/java-bigquerystorage/commit/4a24bf881109d84318a3911a71cbff2657a61f7d))
* update dependency com.google.truth:truth to v1.1 ([#617](https://www.github.com/googleapis/java-bigquerystorage/issues/617)) ([bcab936](https://www.github.com/googleapis/java-bigquerystorage/commit/bcab936673226f771dcfd77f07066d67b64e08dd))
* update dependency junit:junit to v4.13.1 ([#598](https://www.github.com/googleapis/java-bigquerystorage/issues/598)) ([a732ae0](https://www.github.com/googleapis/java-bigquerystorage/commit/a732ae00dff2dde67478e0eb02308096ba6dc192))

### [1.5.5](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.5.4...v1.5.5) (2020-10-09)


### Bug Fixes

* exception tests ([#586](https://www.github.com/googleapis/java-bigquerystorage/issues/586)) ([4e3ad9b](https://www.github.com/googleapis/java-bigquerystorage/commit/4e3ad9bf65190b7e68902e4e62ecfd5c3b80d795))
* remove apache commons lang ([#585](https://www.github.com/googleapis/java-bigquerystorage/issues/585)) ([1c85e8f](https://www.github.com/googleapis/java-bigquerystorage/commit/1c85e8fbf5b2b4e2073c72a86efd83812cabac37))


### Dependencies

* update dependency com.fasterxml.jackson.core:jackson-core to v2.11.3 ([#580](https://www.github.com/googleapis/java-bigquerystorage/issues/580)) ([8d800fa](https://www.github.com/googleapis/java-bigquerystorage/commit/8d800fac7c7dbf1d44cdfa350779be87970a10da))
* update dependency com.google.cloud:google-cloud-bigquery to v1.122.0 ([#579](https://www.github.com/googleapis/java-bigquerystorage/issues/579)) ([0bf5220](https://www.github.com/googleapis/java-bigquerystorage/commit/0bf5220009360ac7ccba6463d32b842bc9158c7b))
* update dependency com.google.cloud:google-cloud-bigquery to v1.122.1 ([#588](https://www.github.com/googleapis/java-bigquerystorage/issues/588)) ([496205e](https://www.github.com/googleapis/java-bigquerystorage/commit/496205e43e10b91fadbf958fcc9135210ff98ca4))
* update dependency com.google.cloud:google-cloud-bigquery to v1.122.2 ([#593](https://www.github.com/googleapis/java-bigquerystorage/issues/593)) ([abe21f0](https://www.github.com/googleapis/java-bigquerystorage/commit/abe21f02f811391259ebe921fff194a3a0394032))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.10.1 ([#589](https://www.github.com/googleapis/java-bigquerystorage/issues/589)) ([e89c92b](https://www.github.com/googleapis/java-bigquerystorage/commit/e89c92bf2b88d4020d31fba707ed69d78e9b74bc))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.10.2 ([#592](https://www.github.com/googleapis/java-bigquerystorage/issues/592)) ([33c460f](https://www.github.com/googleapis/java-bigquerystorage/commit/33c460fa0658307696dbdc7f381ede8df933b0cb))

### [1.5.4](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.5.3...v1.5.4) (2020-09-24)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.10.0 ([#563](https://www.github.com/googleapis/java-bigquerystorage/issues/563)) ([d78ed84](https://www.github.com/googleapis/java-bigquerystorage/commit/d78ed84d72c4bb4ded5aa3f33a3e709aa5d88629))

### [1.5.3](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.5.2...v1.5.3) (2020-09-22)


### Documentation

* changes without context ([#538](https://www.github.com/googleapis/java-bigquerystorage/issues/538)) ([50bb618](https://www.github.com/googleapis/java-bigquerystorage/commit/50bb618ca736a7a9a1262bbf2d2ad75b70d3cd53))


### Dependencies

* update arrow-vector to v1 ([#551](https://www.github.com/googleapis/java-bigquerystorage/issues/551)) ([5cdf42c](https://www.github.com/googleapis/java-bigquerystorage/commit/5cdf42cf8cad0a6d30b7072142a7698fafafa8d9))
* update dependency com.google.cloud:google-cloud-bigquery to v1.120.0 ([#549](https://www.github.com/googleapis/java-bigquerystorage/issues/549)) ([e8dea03](https://www.github.com/googleapis/java-bigquerystorage/commit/e8dea0362de56698a9c3072837e75b31026dd82c))

### [1.5.2](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.5.1...v1.5.2) (2020-09-21)


### Bug Fixes

* geo type accepted change from bytes to string ([#523](https://www.github.com/googleapis/java-bigquerystorage/issues/523)) ([94e6394](https://www.github.com/googleapis/java-bigquerystorage/commit/94e63941e305c64d50829b520594a7e411b15e82))
* update schema compat check with backend type changes ([#522](https://www.github.com/googleapis/java-bigquerystorage/issues/522)) ([2fcae4f](https://www.github.com/googleapis/java-bigquerystorage/commit/2fcae4fda0bb899efa84aba377073da556ec59d0))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v1.117.1 ([#514](https://www.github.com/googleapis/java-bigquerystorage/issues/514)) ([2689689](https://www.github.com/googleapis/java-bigquerystorage/commit/26896896fc3b3342363e191a2e7ffcca6ee291c1))
* update dependency com.google.cloud:google-cloud-bigquery to v1.117.2 ([#529](https://www.github.com/googleapis/java-bigquerystorage/issues/529)) ([74c1854](https://www.github.com/googleapis/java-bigquerystorage/commit/74c1854fbc5e7fea164b7945cb5770c2063032da))
* update dependency com.google.cloud:google-cloud-bigquery to v1.118.0 ([#530](https://www.github.com/googleapis/java-bigquerystorage/issues/530)) ([ffdbf2a](https://www.github.com/googleapis/java-bigquerystorage/commit/ffdbf2a4f763fe0cb9c47dcaafa44a497426bc11))
* update dependency com.google.cloud:google-cloud-bigquery to v1.119.0 ([#532](https://www.github.com/googleapis/java-bigquerystorage/issues/532)) ([f005d93](https://www.github.com/googleapis/java-bigquerystorage/commit/f005d93a14df16afff6b0ee6797d2b23da21ebcb))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.9.0 ([#517](https://www.github.com/googleapis/java-bigquerystorage/issues/517)) ([91899a9](https://www.github.com/googleapis/java-bigquerystorage/commit/91899a94617628a27437c72ce702aff91e101ecc))

### [1.5.1](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.5.0...v1.5.1) (2020-08-31)


### Bug Fixes

* temporarily disable reporting to unblock releases ([#506](https://www.github.com/googleapis/java-bigquerystorage/issues/506)) ([042cb41](https://www.github.com/googleapis/java-bigquerystorage/commit/042cb414ab29cc4143a728e211f95fa5c0cfa1a0))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v1.117.0 ([#508](https://www.github.com/googleapis/java-bigquerystorage/issues/508)) ([15dea1b](https://www.github.com/googleapis/java-bigquerystorage/commit/15dea1b31a57bef6ebc2d7c306b06f186026c10a))

## [1.5.0](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.4.1...v1.5.0) (2020-08-19)


### Features

* Add a flushAll() method that will flush all the inflight request and make sure all responses returned ([#492](https://www.github.com/googleapis/java-bigquerystorage/issues/492)) ([6134818](https://www.github.com/googleapis/java-bigquerystorage/commit/6134818f7bc5ada324a78d5c048bb2eeb83f8ca8))
* add JsonWriterCache.java and added JsonWriterCache in DirectWriter to allow JsonWrites ([#489](https://www.github.com/googleapis/java-bigquerystorage/issues/489)) ([34193b8](https://www.github.com/googleapis/java-bigquerystorage/commit/34193b88bcf64b97dbcde2183e7587fa44923d4b))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v1.116.10 ([#483](https://www.github.com/googleapis/java-bigquerystorage/issues/483)) ([285b6f8](https://www.github.com/googleapis/java-bigquerystorage/commit/285b6f846753f387800d2787746ddb43de67a4b7))

### [1.4.1](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.4.0...v1.4.1) (2020-08-10)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.6 ([#477](https://www.github.com/googleapis/java-bigquerystorage/issues/477)) ([f5faba6](https://www.github.com/googleapis/java-bigquerystorage/commit/f5faba6702ca76c102d15cacd72809cc10699eac))

## [1.4.0](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.3.1...v1.4.0) (2020-08-07)


### Features

* add JsonStreamWriter ([#475](https://www.github.com/googleapis/java-bigquerystorage/issues/475)) ([341bf99](https://www.github.com/googleapis/java-bigquerystorage/commit/341bf99d47d788ebabaa1ce775d1a4f527ee46b0))


### Bug Fixes

* enum value conflict in generated ProtoSchema descriptor. ([#469](https://www.github.com/googleapis/java-bigquerystorage/issues/469)) ([3e1382f](https://www.github.com/googleapis/java-bigquerystorage/commit/3e1382f247de5e6ee8727130280e34fa01d3c088)), closes [#464](https://www.github.com/googleapis/java-bigquerystorage/issues/464)


### Dependencies

* update dependency com.fasterxml.jackson.core:jackson-core to v2.11.2 ([#461](https://www.github.com/googleapis/java-bigquerystorage/issues/461)) ([36b368a](https://www.github.com/googleapis/java-bigquerystorage/commit/36b368a14bb7d45f92af23bc0dd6fe08ad79b085))
* update dependency com.google.cloud:google-cloud-bigquery to v1.116.9 ([#473](https://www.github.com/googleapis/java-bigquerystorage/issues/473)) ([b4ba055](https://www.github.com/googleapis/java-bigquerystorage/commit/b4ba055a809dbe414e8e19d377b8257d0b5446d6))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.5 ([#467](https://www.github.com/googleapis/java-bigquerystorage/issues/467)) ([35c65d4](https://www.github.com/googleapis/java-bigquerystorage/commit/35c65d466d44d01e6f7626ef7cf1aa0e9f3ff0f3))

### [1.3.1](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.3.0...v1.3.1) (2020-07-31)


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v1.116.7 ([#441](https://www.github.com/googleapis/java-bigquerystorage/issues/441)) ([abc1971](https://www.github.com/googleapis/java-bigquerystorage/commit/abc197169b5f04e0eafb486db0d9038903cefe61))

## [1.3.0](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.2.1...v1.3.0) (2020-07-21)


### Features

* Adding JsonToProtoMessage.java ([#400](https://www.github.com/googleapis/java-bigquerystorage/issues/400)) ([200da6d](https://www.github.com/googleapis/java-bigquerystorage/commit/200da6d66e82eaabceeae56e4ff3d1b8e112bd8d))
* re-generated to pick up changes from googleapis. ([#435](https://www.github.com/googleapis/java-bigquerystorage/issues/435)) ([bdf35e0](https://www.github.com/googleapis/java-bigquerystorage/commit/bdf35e08987ffdf49f7545131cd0dba56ff72bd9)), closes [#436](https://www.github.com/googleapis/java-bigquerystorage/issues/436)

### [1.2.1](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.2.0...v1.2.1) (2020-07-20)


### Bug Fixes

* ProtoSchemaConver's problem when converting fields reference same… ([#428](https://www.github.com/googleapis/java-bigquerystorage/issues/428)) ([1ce2621](https://www.github.com/googleapis/java-bigquerystorage/commit/1ce2621fe633f29c57bc4f4df84b2bcc2c57bdb8))

## [1.2.0](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.1.1...v1.2.0) (2020-07-16)


### Features

* add 'Received Rst Stream' to automatic retry strings ([#419](https://www.github.com/googleapis/java-bigquerystorage/issues/419)) ([1584bdb](https://www.github.com/googleapis/java-bigquerystorage/commit/1584bdbf5820a378d844d333e8546b6a26b3c643))


### Bug Fixes

* BQTableSchemaToProtobufDescriptor will now only generate lower-cased fieldnames in the protobuf descriptor ([#415](https://www.github.com/googleapis/java-bigquerystorage/issues/415)) ([4672939](https://www.github.com/googleapis/java-bigquerystorage/commit/46729398eee0f728c3de731f803580342fbe787f))

### [1.1.1](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.1.0...v1.1.1) (2020-07-14)


### Bug Fixes

* BQTableSchemaToProtoDescriptor change type mapping ([#402](https://www.github.com/googleapis/java-bigquerystorage/issues/402)) ([413d6f0](https://www.github.com/googleapis/java-bigquerystorage/commit/413d6f03f288fa21511daaa3442fc1fde9ca246f))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v1.116.6 ([#407](https://www.github.com/googleapis/java-bigquerystorage/issues/407)) ([d0aa73d](https://www.github.com/googleapis/java-bigquerystorage/commit/d0aa73d0fe6233878935ad510bb5d648764872cd))

## [1.1.0](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.0.0...v1.1.0) (2020-07-10)


### Features

* add two new fields, ignoreUnknownFields in AppendRowsRequest and update_schema in AppendRowsResponse. ([#389](https://www.github.com/googleapis/java-bigquerystorage/issues/389)) ([3e9d4c8](https://www.github.com/googleapis/java-bigquerystorage/commit/3e9d4c8abae73b25894d330a99e4213057777bc8))
* Added BQSchemaToProtoDescriptor.java ([#395](https://www.github.com/googleapis/java-bigquerystorage/issues/395)) ([c3a9542](https://www.github.com/googleapis/java-bigquerystorage/commit/c3a9542b146c2a95bd69e6bb940e02f72354141c))


### Dependencies

* update dependency com.fasterxml.jackson.core:jackson-core to v2.11.1 ([#383](https://www.github.com/googleapis/java-bigquerystorage/issues/383)) ([004e78b](https://www.github.com/googleapis/java-bigquerystorage/commit/004e78be6e5de02ce83ef95e5a40c0f23f4b11a0))
* update dependency com.google.cloud:google-cloud-bigquery to v1.116.4 ([#404](https://www.github.com/googleapis/java-bigquerystorage/issues/404)) ([dd56e6c](https://www.github.com/googleapis/java-bigquerystorage/commit/dd56e6c2e9fca51d569a700b4d0bb9527b1e347c))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.2 ([#393](https://www.github.com/googleapis/java-bigquerystorage/issues/393)) ([4d3bce6](https://www.github.com/googleapis/java-bigquerystorage/commit/4d3bce618f39b44048ee20ed47b1cd61354117ad))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.3 ([#405](https://www.github.com/googleapis/java-bigquerystorage/issues/405)) ([01c59e2](https://www.github.com/googleapis/java-bigquerystorage/commit/01c59e26c6c5f8bc42112aa89a90da5786343efc))
* update dependency org.apache.avro:avro to v1.10.0 ([#392](https://www.github.com/googleapis/java-bigquerystorage/issues/392)) ([25dd6d5](https://www.github.com/googleapis/java-bigquerystorage/commit/25dd6d54e129cfb4e0f87f9f05abe4314a01a0dd))

## [1.0.0](https://www.github.com/googleapis/java-bigquerystorage/compare/v0.134.1...v1.0.0) (2020-06-23)


### Features

* promote to GA ([#374](https://www.github.com/googleapis/java-bigquerystorage/issues/374)) ([9d2b891](https://www.github.com/googleapis/java-bigquerystorage/commit/9d2b8916315ae106a8b24c74f786bb2e5dea10e5))

### [0.134.1](https://www.github.com/googleapis/java-bigquerystorage/compare/v0.134.0...v0.134.1) (2020-06-22)


### Bug Fixes

* BQ Numeric is compatible with double and float protobuf types ([#367](https://www.github.com/googleapis/java-bigquerystorage/issues/367)) ([1b2f110](https://www.github.com/googleapis/java-bigquerystorage/commit/1b2f1103d83502836dbc2d6a0d5659e44cd9836d))
* Renamed SchemaCompact.java to SchemaCompatibility.java ([#362](https://www.github.com/googleapis/java-bigquerystorage/issues/362)) ([d3f4787](https://www.github.com/googleapis/java-bigquerystorage/commit/d3f47877003d24aabe76c5ddf4c78a70a4d86a03))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v1.116.3 ([#361](https://www.github.com/googleapis/java-bigquerystorage/issues/361)) ([e88095f](https://www.github.com/googleapis/java-bigquerystorage/commit/e88095f45b48b781eca2ee572fcb841ef8a430ee))

## [0.134.0](https://www.github.com/googleapis/java-bigquerystorage/compare/v0.133.4...v0.134.0) (2020-06-18)


### Features

* Added schema compatibility check functionality (SchemaCompact.java) ([#339](https://www.github.com/googleapis/java-bigquerystorage/issues/339)) ([bc2d8cc](https://www.github.com/googleapis/java-bigquerystorage/commit/bc2d8cc82adeeddb21aeb9845e0883d369101513))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.8.1 ([#346](https://www.github.com/googleapis/java-bigquerystorage/issues/346)) ([9db4c47](https://www.github.com/googleapis/java-bigquerystorage/commit/9db4c475118b03b323b4dc502ec0634692e9dea3))

### [0.133.4](https://www.github.com/googleapis/java-bigquerystorage/compare/v0.133.3...v0.133.4) (2020-06-11)


### Bug Fixes

* make awaitTermination and shutdown protected, since we already have close() method, it is confusing to have 3 shutdown methods ([#330](https://www.github.com/googleapis/java-bigquerystorage/issues/330)) ([8856288](https://www.github.com/googleapis/java-bigquerystorage/commit/88562883051fa1d856818d4ff47fcc020e0452de))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v1.116.2 ([#334](https://www.github.com/googleapis/java-bigquerystorage/issues/334)) ([a611756](https://www.github.com/googleapis/java-bigquerystorage/commit/a611756faea308c7e6714d8eecdb6a295ccb3e6a))

### [0.133.3](https://www.github.com/googleapis/java-bigquerystorage/compare/v0.133.2...v0.133.3) (2020-06-04)


### Bug Fixes

* add retry logic for readrows v1beta1 ([#314](https://www.github.com/googleapis/java-bigquerystorage/issues/314)) ([5290cec](https://www.github.com/googleapis/java-bigquerystorage/commit/5290cec444eaf1a21bcea543ac002276b82957e8))
* add retry logic for readrows v1beta2 ([#315](https://www.github.com/googleapis/java-bigquerystorage/issues/315)) ([cf1ab06](https://www.github.com/googleapis/java-bigquerystorage/commit/cf1ab06b4324219d2558bef6d30389dbf5d37ab7))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v1.116.1 ([#321](https://www.github.com/googleapis/java-bigquerystorage/issues/321)) ([c08116b](https://www.github.com/googleapis/java-bigquerystorage/commit/c08116b0fdabe256635bc8ba96b2c307f33a3998))
* update libraries-bom version ([dd21613](https://www.github.com/googleapis/java-bigquerystorage/commit/dd216134b98816f4b3cc6bd036eab01ebf04df35))


### Documentation

* **samples:** add codeowners file ([#317](https://www.github.com/googleapis/java-bigquerystorage/issues/317)) ([fc351c7](https://www.github.com/googleapis/java-bigquerystorage/commit/fc351c702ab0674f668a396559e18898f4653fdb))
* **samples:** add samples ([#309](https://www.github.com/googleapis/java-bigquerystorage/issues/309)) ([f142827](https://www.github.com/googleapis/java-bigquerystorage/commit/f142827253f7262f1d47d4c557c92076e1fa5fbe))

### [0.133.2](https://www.github.com/googleapis/java-bigquerystorage/compare/v0.133.1...v0.133.2) (2020-05-28)


### Documentation

* **samples:** migrate samples into client ([#308](https://www.github.com/googleapis/java-bigquerystorage/issues/308)) ([c2161fb](https://www.github.com/googleapis/java-bigquerystorage/commit/c2161fbccb6043b0fec7b25eb3de1a0f4f61e7a1))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.7.0 ([#302](https://www.github.com/googleapis/java-bigquerystorage/issues/302)) ([5d22cb0](https://www.github.com/googleapis/java-bigquerystorage/commit/5d22cb09c85c7f4f8cf4f999e23747ac636023ab))

### [0.133.1](https://www.github.com/googleapis/java-bigquerystorage/compare/v0.133.0...v0.133.1) (2020-05-27)


### Bug Fixes

* add retry logic for readrows ([#263](https://www.github.com/googleapis/java-bigquerystorage/issues/263)) ([50345b6](https://www.github.com/googleapis/java-bigquerystorage/commit/50345b653d59209b7912b56b76c6d41e289ecb30))


### Dependencies

* bump shared-deps version and add back certain test deps ([#300](https://www.github.com/googleapis/java-bigquerystorage/issues/300)) ([edfa26b](https://www.github.com/googleapis/java-bigquerystorage/commit/edfa26bb5bfa506004a6d3e39775f9f66b956db9))
* update dependency com.google.cloud:google-cloud-bigquery to v1.115.1 ([#294](https://www.github.com/googleapis/java-bigquerystorage/issues/294)) ([75a08c3](https://www.github.com/googleapis/java-bigquerystorage/commit/75a08c3683fde88264d310f965a0c973b54dfd9e))
* update dependency com.google.cloud:google-cloud-bigquery to v1.116.0 ([#296](https://www.github.com/googleapis/java-bigquerystorage/issues/296)) ([d243ece](https://www.github.com/googleapis/java-bigquerystorage/commit/d243ece29dd1494531f623b69e609fb833e970dc))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.4.0 ([#291](https://www.github.com/googleapis/java-bigquerystorage/issues/291)) ([20b2963](https://www.github.com/googleapis/java-bigquerystorage/commit/20b2963bbf315951d1607bee63a7aa083cdb6c86))

## [0.133.0](https://www.github.com/googleapis/java-bigquerystorage/compare/v0.132.0...v0.133.0) (2020-05-15)


### Features

* Add flush API to StreamWriter ([#278](https://www.github.com/googleapis/java-bigquerystorage/issues/278)) ([f617259](https://www.github.com/googleapis/java-bigquerystorage/commit/f61725995fdc905581dca1109f30afed54d2da8e))


### Bug Fixes

* try to make test run a bit faster, and update some logs. ([#279](https://www.github.com/googleapis/java-bigquerystorage/issues/279)) ([4749b85](https://www.github.com/googleapis/java-bigquerystorage/commit/4749b8516b8f5802091eb21fa349b1c5c58fb48a))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v1.115.0 ([#283](https://www.github.com/googleapis/java-bigquerystorage/issues/283)) ([873d787](https://www.github.com/googleapis/java-bigquerystorage/commit/873d78765eafed471f175d02450c4a107a801219))

## [0.132.0](https://www.github.com/googleapis/java-bigquerystorage/compare/v0.131.2...v0.132.0) (2020-05-13)


### Features

* add a Flush API to enable finer grained data commit needs for dataflow. ([#272](https://www.github.com/googleapis/java-bigquerystorage/issues/272)) ([b1c827f](https://www.github.com/googleapis/java-bigquerystorage/commit/b1c827f8d60f747ce71e2288935439b7c16c0076))


### Documentation

* update CONTRIBUTING.md to include code formatting ([#534](https://www.github.com/googleapis/java-bigquerystorage/issues/534)) ([#273](https://www.github.com/googleapis/java-bigquerystorage/issues/273)) ([9f071d0](https://www.github.com/googleapis/java-bigquerystorage/commit/9f071d006972f40992284fff1f39162d5b521c5e))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v1.114.0 ([#269](https://www.github.com/googleapis/java-bigquerystorage/issues/269)) ([d71e6b7](https://www.github.com/googleapis/java-bigquerystorage/commit/d71e6b7166bc17579c33400c443ef7c5eec7ee8c))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.3.1 ([#274](https://www.github.com/googleapis/java-bigquerystorage/issues/274)) ([9c9471a](https://www.github.com/googleapis/java-bigquerystorage/commit/9c9471a141db069b40e93d76d5632c5cf8ab6257))

### [0.131.2](https://www.github.com/googleapis/java-bigquerystorage/compare/v0.131.1...v0.131.2) (2020-05-08)


### Bug Fixes

* Avoid setting error on response future twice ([#261](https://www.github.com/googleapis/java-bigquerystorage/issues/261)) ([35ef0ed](https://www.github.com/googleapis/java-bigquerystorage/commit/35ef0ed80d55fd4ca015e3a9b6b631d3d893aa1a))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.3.0 ([#256](https://www.github.com/googleapis/java-bigquerystorage/issues/256)) ([252440a](https://www.github.com/googleapis/java-bigquerystorage/commit/252440a84d45d9c13e468e7b59fe4702499143a9))

### [0.131.1](https://www.github.com/googleapis/java-bigquerystorage/compare/v0.131.0...v0.131.1) (2020-05-04)


### Bug Fixes

* flaky writeapi manual client tests ([#238](https://www.github.com/googleapis/java-bigquerystorage/issues/238)) ([89c8623](https://www.github.com/googleapis/java-bigquerystorage/commit/89c8623e082cacdc8e0843bffb67da4dc8b79df3))
* more writeapi manual client test issues ([#241](https://www.github.com/googleapis/java-bigquerystorage/issues/241)) ([65c5ec9](https://www.github.com/googleapis/java-bigquerystorage/commit/65c5ec9c27e901b1633402d5fbbbbb83f956ed97))

## [0.131.0](https://www.github.com/googleapis/java-bigquerystorage/compare/v0.130.0...v0.131.0) (2020-04-28)


### Features

* integrate gapic generator change in googleapis ([#220](https://www.github.com/googleapis/java-bigquerystorage/issues/220)) ([1565dc0](https://www.github.com/googleapis/java-bigquerystorage/commit/1565dc08515d4665b812d86223765f5cf9629b16))


### Bug Fixes

* several StreamWriter issues ([#213](https://www.github.com/googleapis/java-bigquerystorage/issues/213)) ([b803863](https://www.github.com/googleapis/java-bigquerystorage/commit/b80386394f3082e9695712343f37afc4d29df76f))


### Dependencies

* update dependency com.fasterxml.jackson.core:jackson-core to v2.11.0 ([#224](https://www.github.com/googleapis/java-bigquerystorage/issues/224)) ([87d5248](https://www.github.com/googleapis/java-bigquerystorage/commit/87d52483b7bca906df16b4432a0d7bdde6c23726))
* update dependency com.google.cloud:google-cloud-bigquery to v1.111.1 ([#210](https://www.github.com/googleapis/java-bigquerystorage/issues/210)) ([d898a61](https://www.github.com/googleapis/java-bigquerystorage/commit/d898a61f1c48e763e37a234364ee1a590187e8ec))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.2.0 ([#207](https://www.github.com/googleapis/java-bigquerystorage/issues/207)) ([ae29920](https://www.github.com/googleapis/java-bigquerystorage/commit/ae299204422ecb0b98747c96a2e9eac2fa1fbd14))
* update dependency com.google.truth:truth to v1 ([#199](https://www.github.com/googleapis/java-bigquerystorage/issues/199)) ([440d85b](https://www.github.com/googleapis/java-bigquerystorage/commit/440d85bff1930835e1b4d0c13eeb2ce8209d658f))

## [0.130.0](https://www.github.com/googleapis/java-bigquerystorage/compare/v0.129.0...v0.130.0) (2020-04-20)


### Features

* use shared-dependencies bom and add flatten to grpc and proto modules ([#186](https://www.github.com/googleapis/java-bigquerystorage/issues/186)) ([532a698](https://www.github.com/googleapis/java-bigquerystorage/commit/532a698193542b0a5db03d2e29a415082f2de95b))

## [0.129.0](https://www.github.com/googleapis/java-bigquerystorage/compare/v0.128.1...v0.129.0) (2020-04-16)


### Features

* Direct writer ([#165](https://www.github.com/googleapis/java-bigquerystorage/issues/165)) ([ed718c1](https://www.github.com/googleapis/java-bigquerystorage/commit/ed718c14289a3ea41f6ef7cccd8b00d7c7c0ba6c))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v1.110.1 ([#155](https://www.github.com/googleapis/java-bigquerystorage/issues/155)) ([a0b0cfd](https://www.github.com/googleapis/java-bigquerystorage/commit/a0b0cfd69bd0e26c0ae3748dd9fe35431bf41b2d))
* update dependency com.google.guava:guava-bom to v29 ([#166](https://www.github.com/googleapis/java-bigquerystorage/issues/166)) ([81c87d6](https://www.github.com/googleapis/java-bigquerystorage/commit/81c87d67332033da8f998dd281954fe362f590f2))

### [0.128.1](https://www.github.com/googleapis/java-bigquerystorage/compare/v0.128.0...v0.128.1) (2020-04-07)


### Bug Fixes

* waitForTermination in the manual client [#140](https://www.github.com/googleapis/java-bigquerystorage/issues/140) ([#141](https://www.github.com/googleapis/java-bigquerystorage/issues/141)) ([bdb8e0f](https://www.github.com/googleapis/java-bigquerystorage/commit/bdb8e0f6b0b8ab9b1e2e92d6e41ea3298964dd3e))


### Dependencies

* update core dependencies ([#149](https://www.github.com/googleapis/java-bigquerystorage/issues/149)) ([dbe270f](https://www.github.com/googleapis/java-bigquerystorage/commit/dbe270fb3b1ff28d231e5d401ce2b140bec4f68d))
* update dependency org.threeten:threetenbp to v1.4.3 ([#144](https://www.github.com/googleapis/java-bigquerystorage/issues/144)) ([c1f2731](https://www.github.com/googleapis/java-bigquerystorage/commit/c1f27318ebb127980ff8ced2551610095dcfdf9e))

## [0.128.0](https://www.github.com/googleapis/java-bigquerystorage/compare/v0.127.0...v0.128.0) (2020-04-04)


### Features

* add flatten plugin ([#117](https://www.github.com/googleapis/java-bigquerystorage/issues/117)) ([c01bbc7](https://www.github.com/googleapis/java-bigquerystorage/commit/c01bbc7df8d89c6b0b5b3e7f53b541c4575ed119))
* re-generated  to pick up changes in the API or client library generator. ([#134](https://www.github.com/googleapis/java-bigquerystorage/issues/134)) ([0541775](https://www.github.com/googleapis/java-bigquerystorage/commit/054177514fc63f5c84bcca8d71b953f06b1807ca)), closes [#112](https://www.github.com/googleapis/java-bigquerystorage/issues/112) [#112](https://www.github.com/googleapis/java-bigquerystorage/issues/112) [#132](https://www.github.com/googleapis/java-bigquerystorage/issues/132) [#132](https://www.github.com/googleapis/java-bigquerystorage/issues/132) [#122](https://www.github.com/googleapis/java-bigquerystorage/issues/122) [#122](https://www.github.com/googleapis/java-bigquerystorage/issues/122)

## [0.127.0](https://www.github.com/googleapis/java-bigquerystorage/compare/v0.126.0...v0.127.0) (2020-04-03)


### Features

* create manual client for Write API ([#112](https://www.github.com/googleapis/java-bigquerystorage/issues/112)) ([98851e9](https://www.github.com/googleapis/java-bigquerystorage/commit/98851e96f7c20228cf888e4a847ac98f3da2e4b7))
* proto converter library ([#100](https://www.github.com/googleapis/java-bigquerystorage/issues/100)) ([8fbb80e](https://www.github.com/googleapis/java-bigquerystorage/commit/8fbb80eccdfafe8ffd5ff24fe04132878d09d9ae))


### Dependencies

* update core dependencies ([#98](https://www.github.com/googleapis/java-bigquerystorage/issues/98)) ([0983575](https://www.github.com/googleapis/java-bigquerystorage/commit/09835752000a99f1cef113cc0808b0c7c907c190))
* update core dependencies to v1.55.0 ([#127](https://www.github.com/googleapis/java-bigquerystorage/issues/127)) ([99cedf9](https://www.github.com/googleapis/java-bigquerystorage/commit/99cedf926a7b51f58dbec6539ecba350a5e5b845))
* update dependency com.google.api:api-common to v1.9.0 ([#126](https://www.github.com/googleapis/java-bigquerystorage/issues/126)) ([27db090](https://www.github.com/googleapis/java-bigquerystorage/commit/27db090caf065c68f724f0457df47b83a186e91c))
* update dependency com.google.cloud:google-cloud-bigquery to v1.109.0 ([#114](https://www.github.com/googleapis/java-bigquerystorage/issues/114)) ([f5b48d8](https://www.github.com/googleapis/java-bigquerystorage/commit/f5b48d85f4561e31b01b614d4395c4c3b1d65ed4))
* update dependency com.google.cloud:google-cloud-bigquery to v1.110.0 ([#115](https://www.github.com/googleapis/java-bigquerystorage/issues/115)) ([9b20371](https://www.github.com/googleapis/java-bigquerystorage/commit/9b20371be163ed69cdb2260023afb9512102d4d5))
* update dependency com.google.cloud:google-cloud-core to v1.93.3 ([#104](https://www.github.com/googleapis/java-bigquerystorage/issues/104)) ([519bd1e](https://www.github.com/googleapis/java-bigquerystorage/commit/519bd1ed7cfa7ba4bd4f370cf05b50e85256ac2a))
* update dependency com.google.cloud.samples:shared-configuration to v1.0.13 ([#123](https://www.github.com/googleapis/java-bigquerystorage/issues/123)) ([819dc70](https://www.github.com/googleapis/java-bigquerystorage/commit/819dc70ac8cc6688cea5276a2ec2af323b26d55d))
* update dependency io.grpc:grpc-bom to v1.28.1 ([#132](https://www.github.com/googleapis/java-bigquerystorage/issues/132)) ([711c5c7](https://www.github.com/googleapis/java-bigquerystorage/commit/711c5c793e992098f96f7683f4e9643ee7424d81))
* update dependency org.threeten:threetenbp to v1.4.2 ([#113](https://www.github.com/googleapis/java-bigquerystorage/issues/113)) ([09451c1](https://www.github.com/googleapis/java-bigquerystorage/commit/09451c11fbdc9ab1bb32f41a90970cab3c9589ab))


### Documentation

* **regen:** fix closing backtick in docs ([#109](https://www.github.com/googleapis/java-bigquerystorage/issues/109)) ([98f3cb2](https://www.github.com/googleapis/java-bigquerystorage/commit/98f3cb2065e8fdb3de263fa8288278e37d6160b3))

## [0.126.0](https://www.github.com/googleapis/java-bigquerystorage/compare/v0.125.0...v0.126.0) (2020-03-09)


### Features

* re-generated  to pick up changes in the API or client library generator. ([#85](https://www.github.com/googleapis/java-bigquerystorage/issues/85)) ([e3f4087](https://www.github.com/googleapis/java-bigquerystorage/commit/e3f40879dfda7c2dac1cf16b23605912174e2601))
* re-generated  to pick up changes in the API or client library generator. ([#95](https://www.github.com/googleapis/java-bigquerystorage/issues/95)) ([7e760a4](https://www.github.com/googleapis/java-bigquerystorage/commit/7e760a4d2782ec1674b0d3da72ba2eeed4d101a1))
* re-generated  to pick up changes in the API or client library generator. ([#97](https://www.github.com/googleapis/java-bigquerystorage/issues/97)) ([c1f1854](https://www.github.com/googleapis/java-bigquerystorage/commit/c1f1854bbe4362449b0afd427e88ab9414cd8fac))


### Dependencies

* update core dependencies ([#89](https://www.github.com/googleapis/java-bigquerystorage/issues/89)) ([bdf1385](https://www.github.com/googleapis/java-bigquerystorage/commit/bdf13853a8abd791c4a376284a5afeed1d2afbd8))
* update dependency com.fasterxml.jackson.core:jackson-core to v2.10.3 ([#92](https://www.github.com/googleapis/java-bigquerystorage/issues/92)) ([551d024](https://www.github.com/googleapis/java-bigquerystorage/commit/551d02482c8694d32e465acccbf8de6ae515d3c8))
* update dependency com.google.cloud:google-cloud-bigquery to v1.107.0 ([#82](https://www.github.com/googleapis/java-bigquerystorage/issues/82)) ([96e55ee](https://www.github.com/googleapis/java-bigquerystorage/commit/96e55ee322a9fcb0b05f3a942eefc48e5f1233d0))
* update dependency com.google.cloud:google-cloud-bigquery to v1.108.0 ([#91](https://www.github.com/googleapis/java-bigquerystorage/issues/91)) ([aa7b8b8](https://www.github.com/googleapis/java-bigquerystorage/commit/aa7b8b84236261b1c88367851cbffe3126d81a50))
* update dependency com.google.cloud:google-cloud-bigquery to v1.108.1 ([#96](https://www.github.com/googleapis/java-bigquerystorage/issues/96)) ([11b4418](https://www.github.com/googleapis/java-bigquerystorage/commit/11b44186007dd7eb15f3daf5d559c705003e8709))
* update dependency com.google.cloud:google-cloud-core to v1.93.1 ([#93](https://www.github.com/googleapis/java-bigquerystorage/issues/93)) ([aa10c59](https://www.github.com/googleapis/java-bigquerystorage/commit/aa10c59ea155eec8de8433dbb8ef924327bf60a2))
* update dependency io.grpc:grpc-bom to v1.27.2 ([#88](https://www.github.com/googleapis/java-bigquerystorage/issues/88)) ([cdba693](https://www.github.com/googleapis/java-bigquerystorage/commit/cdba693add40b7571a43b4b0c5ca8a772e0333c5))

## [0.125.0](https://www.github.com/googleapis/java-bigquerystorage/compare/v0.124.0...v0.125.0) (2020-02-18)


### Features

* add ArrowSerializationOptions to TableReadOptions ([#76](https://www.github.com/googleapis/java-bigquerystorage/issues/76)) ([df5d4cb](https://www.github.com/googleapis/java-bigquerystorage/commit/df5d4cba8f599ad60abc1266f75f63ffaa1d03e1))
* re-generated  to pick up changes in the API or client library generator. ([#70](https://www.github.com/googleapis/java-bigquerystorage/issues/70)) ([3631965](https://www.github.com/googleapis/java-bigquerystorage/commit/363196550f5d5a7381ec88e3404d334475fe430e))
* re-generated  to pick up changes in the API or client library generator. ([#74](https://www.github.com/googleapis/java-bigquerystorage/issues/74)) ([a41f1a7](https://www.github.com/googleapis/java-bigquerystorage/commit/a41f1a7bcffc1d2076ecbf4647eb2e128ba595be))


### Dependencies

* update dependency com.google.cloud:google-cloud-core to v1.92.5 ([#73](https://www.github.com/googleapis/java-bigquerystorage/issues/73)) ([a822658](https://www.github.com/googleapis/java-bigquerystorage/commit/a822658649c1c306933ea97d466f254b391622eb))
* update dependency com.google.protobuf:protobuf-java to v3.11.4 ([#79](https://www.github.com/googleapis/java-bigquerystorage/issues/79)) ([2c1c640](https://www.github.com/googleapis/java-bigquerystorage/commit/2c1c64074d0012b9b3c9d729278f643e5fde1658))
* update dependency io.grpc:grpc-bom to v1.27.1 ([#78](https://www.github.com/googleapis/java-bigquerystorage/issues/78)) ([c4814dc](https://www.github.com/googleapis/java-bigquerystorage/commit/c4814dc0900e95828ae296ff44e4fa4b40daa6cd))
* update dependency org.apache.avro:avro to v1.9.2 ([#77](https://www.github.com/googleapis/java-bigquerystorage/issues/77)) ([8f8fa6a](https://www.github.com/googleapis/java-bigquerystorage/commit/8f8fa6ae7163a295c3586c575751a6481341dc6b))

## [0.124.0](https://www.github.com/googleapis/java-bigquerystorage/compare/v0.123.0...v0.124.0) (2020-02-07)


### Features

* add an enhanced layer for BigQuery Storage v1 client ([#66](https://www.github.com/googleapis/java-bigquerystorage/issues/66)) ([43fc284](https://www.github.com/googleapis/java-bigquerystorage/commit/43fc284e00ddbc9a018d734e3f6f09c82ebd92d4))
* add v1 integration tests ([#68](https://www.github.com/googleapis/java-bigquerystorage/issues/68)) ([8e7ac15](https://www.github.com/googleapis/java-bigquerystorage/commit/8e7ac1511b9f9eaea417e6761848e4735039a831))

## [0.123.0](https://www.github.com/googleapis/java-bigquerystorage/compare/v0.122.0...v0.123.0) (2020-02-06)


### Features

* v1 client generation ([#64](https://www.github.com/googleapis/java-bigquerystorage/issues/64)) ([902156d](https://www.github.com/googleapis/java-bigquerystorage/commit/902156d576845499e3eeedeff44c47d67e228098))

## [0.122.0](https://www.github.com/googleapis/java-bigquerystorage/compare/v0.121.0...v0.122.0) (2020-02-05)


### Features

* re-generated  to pick up changes in the API or client library generator. ([#49](https://www.github.com/googleapis/java-bigquerystorage/issues/49)) ([00d8ccb](https://www.github.com/googleapis/java-bigquerystorage/commit/00d8ccbfd26effcb2e5e3be3cd242202a65e43b8))
* re-generated  to pick up changes in the API or client library generator. ([#59](https://www.github.com/googleapis/java-bigquerystorage/issues/59)) ([f63b305](https://www.github.com/googleapis/java-bigquerystorage/commit/f63b3051fbd8defb4f7be7c00fd504f137a67897))


### Bug Fixes

* track v1alpha2 versions ([#58](https://www.github.com/googleapis/java-bigquerystorage/issues/58)) ([4271524](https://www.github.com/googleapis/java-bigquerystorage/commit/4271524956faea6ccc888d750afba4160e1fd453))


### Documentation

* update libraries-bom ([#54](https://www.github.com/googleapis/java-bigquerystorage/issues/54)) ([abf05eb](https://www.github.com/googleapis/java-bigquerystorage/commit/abf05ebe09ac8f71f3b59e5f8473fe3d56f4242e))

## [0.121.0](https://www.github.com/googleapis/java-bigquerystorage/compare/v0.120.1...v0.121.0) (2020-02-03)


### Features

* add an enhanced layer for BigQuery Storage v1beta2 client ([#48](https://www.github.com/googleapis/java-bigquerystorage/issues/48)) ([9496158](https://www.github.com/googleapis/java-bigquerystorage/commit/949615823c5bb12ef749639d7337f6341973ddbf))
* add integration tests for v1beta2 BigQuery Storage API ([#50](https://www.github.com/googleapis/java-bigquerystorage/issues/50)) ([bd37cf3](https://www.github.com/googleapis/java-bigquerystorage/commit/bd37cf385fe666702224d20aed1ad087d7346d57))
* add v1beta2, v1alpha2 clients ([#44](https://www.github.com/googleapis/java-bigquerystorage/issues/44)) ([8c124a2](https://www.github.com/googleapis/java-bigquerystorage/commit/8c124a2fb4d73808b8e0f9267d5422658807a9d2))


### Dependencies

* bump dependency versions ([#53](https://www.github.com/googleapis/java-bigquerystorage/issues/53)) ([b6418b4](https://www.github.com/googleapis/java-bigquerystorage/commit/b6418b45771fb8861a0743b0bf5bb55a5a5b4e78))
* update core dependencies ([#17](https://www.github.com/googleapis/java-bigquerystorage/issues/17)) ([c17786e](https://www.github.com/googleapis/java-bigquerystorage/commit/c17786ef94ffb05818d2d7ebb7958bf661f93896))
* update dependency com.google.guava:guava-bom to v28.2-android ([#20](https://www.github.com/googleapis/java-bigquerystorage/issues/20)) ([24bf682](https://www.github.com/googleapis/java-bigquerystorage/commit/24bf682c2fcacc8245800ed55881d4c88e1d748e))
* update dependency org.threeten:threetenbp to v1.4.1 ([617db50](https://www.github.com/googleapis/java-bigquerystorage/commit/617db50f70095fa574e2fb5316dfa7b5e609bd5e))

## [0.120.0](https://www.github.com/googleapis/java-bigquerystorage/compare/0.120.0-beta...v0.120.0) (2020-01-07)


### Dependencies

* update dependency junit:junit to v4.13 ([#21](https://www.github.com/googleapis/java-bigquerystorage/issues/21)) ([190ad2a](https://www.github.com/googleapis/java-bigquerystorage/commit/190ad2ab6996603a8b022ddc54dbb3195907e564))


### Documentation

* **regen:** javadoc proto class changes from protoc update ([#9](https://www.github.com/googleapis/java-bigquerystorage/issues/9)) ([d371b4a](https://www.github.com/googleapis/java-bigquerystorage/commit/d371b4a5b4d1cb343cb00d645e263fe62b5ecbd2))
