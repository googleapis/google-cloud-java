# Changelog

## [2.23.0](https://github.com/googleapis/java-bigquerystorage/compare/v2.22.0...v2.23.0) (2022-10-03)


### Features

* return list of row errors from append ([df7c6e9](https://github.com/googleapis/java-bigquerystorage/commit/df7c6e9816d43eac196d77604bc99db6115de670))


### Bug Fixes

* return row-level error information via an AppendSerializtionError exception ([df7c6e9](https://github.com/googleapis/java-bigquerystorage/commit/df7c6e9816d43eac196d77604bc99db6115de670))

## [2.22.0](https://github.com/googleapis/java-bigquerystorage/compare/v2.21.0...v2.22.0) (2022-09-29)


### Features

* Add a new specific exception about json data has unknown field ([#1792](https://github.com/googleapis/java-bigquerystorage/issues/1792)) ([18f93c1](https://github.com/googleapis/java-bigquerystorage/commit/18f93c124334464a951b3d3065bdf11bbda13dac))
* Add cache for location in stream writer, and trigger that when location is not presented ([#1804](https://github.com/googleapis/java-bigquerystorage/issues/1804)) ([c24c14f](https://github.com/googleapis/java-bigquerystorage/commit/c24c14f14b1a6f8249f55630d51e3cadd500c1ad))
* Add close() to multiplexing client ([#1788](https://github.com/googleapis/java-bigquerystorage/issues/1788)) ([6b3a974](https://github.com/googleapis/java-bigquerystorage/commit/6b3a97491bf718333ae7c085f9b10723d8b24388))
* Add fully managed schema support on json writer ([#1794](https://github.com/googleapis/java-bigquerystorage/issues/1794)) ([b6b515f](https://github.com/googleapis/java-bigquerystorage/commit/b6b515f57a0f6956c9d9f902a5e3e16edc845a48))
* Add more retry error code to the sample ([#1805](https://github.com/googleapis/java-bigquerystorage/issues/1805)) ([4bf67bc](https://github.com/googleapis/java-bigquerystorage/commit/4bf67bcf0de2d370f0b04d8df236d30466b91598))
* Add multiplexing client core algorithm and basic testing, plus fix a tiny bug in fake server ([#1787](https://github.com/googleapis/java-bigquerystorage/issues/1787)) ([1bb8e26](https://github.com/googleapis/java-bigquerystorage/commit/1bb8e262941f570d7f2de60123ec5a6a0cf43600))
* Add multiplexing support to connection worker.  ([#1784](https://github.com/googleapis/java-bigquerystorage/issues/1784)) ([a869a1d](https://github.com/googleapis/java-bigquerystorage/commit/a869a1d8baba3cc0f6046d661c6f52ec12a3f12d))
* Add support for flexible column name in JsonStreamWriter ([#1786](https://github.com/googleapis/java-bigquerystorage/issues/1786)) ([694abbb](https://github.com/googleapis/java-bigquerystorage/commit/694abbb43bf2970cd81803521c349dc31a38f484))
* Add two fine logs that would allow Datastream to look into the stuck issue ([#1791](https://github.com/googleapis/java-bigquerystorage/issues/1791)) ([745ceb4](https://github.com/googleapis/java-bigquerystorage/commit/745ceb46dec5922efe394773028532dcd84a4f9b))
* Always pass a null bigquery client lib to StreamWriter ([#1795](https://github.com/googleapis/java-bigquerystorage/issues/1795)) ([eec50c1](https://github.com/googleapis/java-bigquerystorage/commit/eec50c14e1dff84ae9a3e70f9d08d27b9e225e55))
* Bug fix for checking write_stream field but proto might not contain the field to unblock the release ([#1806](https://github.com/googleapis/java-bigquerystorage/issues/1806)) ([9791d69](https://github.com/googleapis/java-bigquerystorage/commit/9791d693c75367bec6451ebf65ae4ea3347bf50f))
* Client unknown fields drives writer refreshment ([#1797](https://github.com/googleapis/java-bigquerystorage/issues/1797)) ([d8aaed5](https://github.com/googleapis/java-bigquerystorage/commit/d8aaed522b9de487539165ea662465e5a96222f1))
* ExecutorProvider can now be replaced ([#1770](https://github.com/googleapis/java-bigquerystorage/issues/1770)) ([6380f71](https://github.com/googleapis/java-bigquerystorage/commit/6380f713b8f42fa3a58df2750ea2cf3b7397d29c)), closes [#1769](https://github.com/googleapis/java-bigquerystorage/issues/1769)
* Fix some todos and reject stream writer if it's created with mixed behavior of passed in client or not ([#1803](https://github.com/googleapis/java-bigquerystorage/issues/1803)) ([1a69192](https://github.com/googleapis/java-bigquerystorage/commit/1a69192e2ffc6475a7e4b67c5a452f1c0e8aaddc))
* Minor tune after offline testing  ([#1807](https://github.com/googleapis/java-bigquerystorage/issues/1807)) ([694a870](https://github.com/googleapis/java-bigquerystorage/commit/694a870bac623ef038168a4358b9d73972077edb))
* Populate location info if we already called GetWriteStream ([#1802](https://github.com/googleapis/java-bigquerystorage/issues/1802)) ([5f43103](https://github.com/googleapis/java-bigquerystorage/commit/5f4310321e7f90385f7ef5c32e3e5395f719d0ca))
* Some fixes for multiplexing client  ([#1798](https://github.com/googleapis/java-bigquerystorage/issues/1798)) ([b3ffd77](https://github.com/googleapis/java-bigquerystorage/commit/b3ffd77e4b86708f241ba517c55bb3508964bc0e))
* Wire connection pool to stream writer without implementing updated schema  ([#1790](https://github.com/googleapis/java-bigquerystorage/issues/1790)) ([3eb1475](https://github.com/googleapis/java-bigquerystorage/commit/3eb147545db2415e5a68752b8ede1c4d342d1a84))

## [2.21.0](https://github.com/googleapis/java-bigquerystorage/compare/v2.20.1...v2.21.0) (2022-09-15)


### Features

* Add connection worker skeleton used for multiplexing client ([#1778](https://github.com/googleapis/java-bigquerystorage/issues/1778)) ([b26265e](https://github.com/googleapis/java-bigquerystorage/commit/b26265e56a47cda3fca1329d349ab4a18288d4cb))
* Add Load api for connection worker for multiplexing worker ([#1779](https://github.com/googleapis/java-bigquerystorage/issues/1779)) ([179930e](https://github.com/googleapis/java-bigquerystorage/commit/179930e6b0017f1fa12dcd3ef7c3efa374f41576))
* Add location to WriteStream and add WriteStreamView support ([#1771](https://github.com/googleapis/java-bigquerystorage/issues/1771)) ([f446ff4](https://github.com/googleapis/java-bigquerystorage/commit/f446ff4f7d3f9d217501201289be416cbfdbe937))
* Add proto annotation for non-ascii field mapping ([#1776](https://github.com/googleapis/java-bigquerystorage/issues/1776)) ([1a079ee](https://github.com/googleapis/java-bigquerystorage/commit/1a079ee0761bad2e942081f7f02b530f32e55afe))
* introducing connection worker to run a loop for fetching / sending requests in a queue. ([7dd447d](https://github.com/googleapis/java-bigquerystorage/commit/7dd447da206cdd7a403191bd15203bb4cc53ccb5))


### Bug Fixes

* **api:** Numeric/bignumeric conversion issue [#1757](https://github.com/googleapis/java-bigquerystorage/issues/1757) ([#1768](https://github.com/googleapis/java-bigquerystorage/issues/1768)) ([5cc96a0](https://github.com/googleapis/java-bigquerystorage/commit/5cc96a0c5da5c8b557e96cd1a25afdff9d583a0f))


### Dependencies

* Update dependency com.google.cloud:google-cloud-bigquery to v2.15.0 ([#1766](https://github.com/googleapis/java-bigquerystorage/issues/1766)) ([40e0ba0](https://github.com/googleapis/java-bigquerystorage/commit/40e0ba09527c564004fcbbb0c3af2fb97eb811c0))
* Update dependency com.google.cloud:google-cloud-bigquery to v2.16.0 ([#1777](https://github.com/googleapis/java-bigquerystorage/issues/1777)) ([08a7c8f](https://github.com/googleapis/java-bigquerystorage/commit/08a7c8f1dde71f48706bb0b1aa780f79012594bf))
* Update dependency com.google.cloud:google-cloud-bigquery to v2.16.1 ([#1781](https://github.com/googleapis/java-bigquerystorage/issues/1781)) ([7ff7099](https://github.com/googleapis/java-bigquerystorage/commit/7ff709951f40c3683da628a9bcf66a5fe0a2e368))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.2 ([#1772](https://github.com/googleapis/java-bigquerystorage/issues/1772)) ([3279ef4](https://github.com/googleapis/java-bigquerystorage/commit/3279ef42e915881c255a8db8e677799f530c5d53))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.3 ([#1780](https://github.com/googleapis/java-bigquerystorage/issues/1780)) ([ed2cd66](https://github.com/googleapis/java-bigquerystorage/commit/ed2cd66a3804140711b9f4aa05b67641f2494bc9))

## [2.20.1](https://github.com/googleapis/java-bigquerystorage/compare/v2.20.0...v2.20.1) (2022-08-24)


### Bug Fixes

* Add unit test for closing disconnected streamwriter. Also reduce wait from 5->3 minutes ([#1751](https://github.com/googleapis/java-bigquerystorage/issues/1751)) ([095d7d5](https://github.com/googleapis/java-bigquerystorage/commit/095d7d59b47becf72a5e9cd3ced383fa45b04b50))
* allow repeated field to have a null or missing json array ([#1760](https://github.com/googleapis/java-bigquerystorage/issues/1760)) ([ef24825](https://github.com/googleapis/java-bigquerystorage/commit/ef24825ca40e6156f6f3ce38c3c6051673a5f6cc))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v2.14.7 ([#1759](https://github.com/googleapis/java-bigquerystorage/issues/1759)) ([ac3f0b8](https://github.com/googleapis/java-bigquerystorage/commit/ac3f0b871a1db4bcbd5ce8fa019ae8e1559ed3ec))

## [2.20.0](https://github.com/googleapis/java-bigquerystorage/compare/v2.19.1...v2.20.0) (2022-08-17)


### Features

* introduce InflightLimitExceededException ([#1746](https://github.com/googleapis/java-bigquerystorage/issues/1746)) ([449353b](https://github.com/googleapis/java-bigquerystorage/commit/449353bd3b1fc78d46990c8203e1607d83f7ad03))


### Bug Fixes

* Add documentation to Exceptions ([#1745](https://github.com/googleapis/java-bigquerystorage/issues/1745)) ([3bc7aca](https://github.com/googleapis/java-bigquerystorage/commit/3bc7acaa4a110a0ce487e3976b5fd4ddb865ea24))
* Add missing field error to row error message ([#1752](https://github.com/googleapis/java-bigquerystorage/issues/1752)) ([186d213](https://github.com/googleapis/java-bigquerystorage/commit/186d2135cb7e18410b89c93e909b03dc8e92ac6c))
* Close based on whether connection is active, not status variable ([#1750](https://github.com/googleapis/java-bigquerystorage/issues/1750)) ([ce7f3e0](https://github.com/googleapis/java-bigquerystorage/commit/ce7f3e04046be6b4c1321be877034f5d0ab007f4))


### Dependencies

* fixing the test scope dependency to runtime ([#1742](https://github.com/googleapis/java-bigquerystorage/issues/1742)) ([878020b](https://github.com/googleapis/java-bigquerystorage/commit/878020b3667040aef1b8d610b37cd678ef932870))
* update dependency com.google.cloud:google-cloud-bigquery to v2.14.4 ([#1740](https://github.com/googleapis/java-bigquerystorage/issues/1740)) ([f842d51](https://github.com/googleapis/java-bigquerystorage/commit/f842d517b70847b8e67359257a213129586513f6))
* update dependency com.google.cloud:google-cloud-bigquery to v2.14.6 ([#1747](https://github.com/googleapis/java-bigquerystorage/issues/1747)) ([329bd9d](https://github.com/googleapis/java-bigquerystorage/commit/329bd9da268f48a4d18158845895b07a43c766ab))

## [2.19.1](https://github.com/googleapis/java-bigquerystorage/compare/v2.19.0...v2.19.1) (2022-08-06)


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v2.14.3 ([#1736](https://github.com/googleapis/java-bigquerystorage/issues/1736)) ([f36d4f0](https://github.com/googleapis/java-bigquerystorage/commit/f36d4f01b5529ca93ca5f713852bc8bd48c51cdc))

## [2.19.0](https://github.com/googleapis/java-bigquerystorage/compare/v2.18.0...v2.19.0) (2022-08-05)


### Features

* Add CANCELLED to StreamWriter retryable error code ([#1725](https://github.com/googleapis/java-bigquerystorage/issues/1725)) ([6d4c004](https://github.com/googleapis/java-bigquerystorage/commit/6d4c00474a4056d72544b5a8966de6acaf0eecd3))
* remove a dummy WriterClosedException ([0b3018d](https://github.com/googleapis/java-bigquerystorage/commit/0b3018d9e4cd64402f8d111aa9b4857224b8134e))


### Bug Fixes

* Switch integration test onto v1 write api ([#1731](https://github.com/googleapis/java-bigquerystorage/issues/1731)) ([2ccb96e](https://github.com/googleapis/java-bigquerystorage/commit/2ccb96ecd7431a53ccd3a1b2bfd7df5a8e76498e))


### Documentation

* **owlbot-java:** explaining why not using formatter in pom.xml ([#1511](https://github.com/googleapis/java-bigquerystorage/issues/1511)) ([#1723](https://github.com/googleapis/java-bigquerystorage/issues/1723)) ([eabfa93](https://github.com/googleapis/java-bigquerystorage/commit/eabfa937fbda2244e67765aa6a01399ae04b943a)), closes [#1502](https://github.com/googleapis/java-bigquerystorage/issues/1502)


### Dependencies

* update arrow.version to v9 (major) ([#1728](https://github.com/googleapis/java-bigquerystorage/issues/1728)) ([3694243](https://github.com/googleapis/java-bigquerystorage/commit/3694243b5f9e392b475c2a9fbb66979ff510781f))
* update dependency com.google.cloud:google-cloud-bigquery to v2.14.1 ([#1721](https://github.com/googleapis/java-bigquerystorage/issues/1721)) ([e27a9e9](https://github.com/googleapis/java-bigquerystorage/commit/e27a9e97ac2bf1e7a40bed17c67b3244f03c7d7a))
* update dependency com.google.cloud:google-cloud-bigquery to v2.14.2 ([#1734](https://github.com/googleapis/java-bigquerystorage/issues/1734)) ([0115e98](https://github.com/googleapis/java-bigquerystorage/commit/0115e98f8c11694183741c352ce97e0ab45894c7))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v3 ([#1718](https://github.com/googleapis/java-bigquerystorage/issues/1718)) ([940c613](https://github.com/googleapis/java-bigquerystorage/commit/940c613b1480948c3561df6e19a650b14dbf051f))
* update dependency org.apache.arrow:arrow-memory-netty to v9 ([#1729](https://github.com/googleapis/java-bigquerystorage/issues/1729)) ([297ee99](https://github.com/googleapis/java-bigquerystorage/commit/297ee998f8f868480477dabff0e0a4b3417d7129))
* update dependency org.apache.arrow:arrow-vector to v9 ([#1730](https://github.com/googleapis/java-bigquerystorage/issues/1730)) ([6010b42](https://github.com/googleapis/java-bigquerystorage/commit/6010b42c6d14f15681ee97a83c64136aefb75028))
* update dependency org.apache.avro:avro to v1.11.1 ([#1719](https://github.com/googleapis/java-bigquerystorage/issues/1719)) ([754296f](https://github.com/googleapis/java-bigquerystorage/commit/754296fd24635e20edccb7371b27474f825741ba))

## [2.18.0](https://github.com/googleapis/java-bigquerystorage/compare/v2.17.0...v2.18.0) (2022-07-27)


### Features

* Add another StreamWriterClosedException and remove RETRY_THRESHOLD ([#1713](https://github.com/googleapis/java-bigquerystorage/issues/1713)) ([f8d1bd9](https://github.com/googleapis/java-bigquerystorage/commit/f8d1bd901232a61ca87c2671e478136dfd4f2432))
* increase timeout waiting for done callback from 2 minutes to 5 … ([#1682](https://github.com/googleapis/java-bigquerystorage/issues/1682)) ([5171898](https://github.com/googleapis/java-bigquerystorage/commit/517189858263107ffc00cee5328ac958cb45a3f9))


### Documentation

* clarify size limitations for AppendRowsRequest ([#1714](https://github.com/googleapis/java-bigquerystorage/issues/1714)) ([ed3fe1f](https://github.com/googleapis/java-bigquerystorage/commit/ed3fe1fb20fc2e07c26da42b7564599642540317))

## [2.17.0](https://github.com/googleapis/java-bigquerystorage/compare/v2.16.1...v2.17.0) (2022-07-25)


### Features

* Return explicit StreamWriterClosedException ([#1709](https://github.com/googleapis/java-bigquerystorage/issues/1709)) ([57eb6d0](https://github.com/googleapis/java-bigquerystorage/commit/57eb6d0078a498e2f792d76b685c113a6a52ea8e))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v2.14.0 ([#1706](https://github.com/googleapis/java-bigquerystorage/issues/1706)) ([e92a8c0](https://github.com/googleapis/java-bigquerystorage/commit/e92a8c066130a6f28500fa887aef96da8a7af6df))

## [2.16.1](https://github.com/googleapis/java-bigquerystorage/compare/v2.16.0...v2.16.1) (2022-07-19)


### Bug Fixes

* enable longpaths support for windows test ([#1485](https://github.com/googleapis/java-bigquerystorage/issues/1485)) ([#1699](https://github.com/googleapis/java-bigquerystorage/issues/1699)) ([0cb05fd](https://github.com/googleapis/java-bigquerystorage/commit/0cb05fd3f9a732a0e7fc0cc494e1a305ce44805f))

## [2.16.0](https://github.com/googleapis/java-bigquerystorage/compare/v2.15.0...v2.16.0) (2022-07-11)


### Features

* expose row level serialization failures for JsonStreamWriter append ([#1686](https://github.com/googleapis/java-bigquerystorage/issues/1686)) ([bba0746](https://github.com/googleapis/java-bigquerystorage/commit/bba0746a13c785621c4e4cbd2239060d67ce155b))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v2.13.8 ([#1690](https://github.com/googleapis/java-bigquerystorage/issues/1690)) ([195670d](https://github.com/googleapis/java-bigquerystorage/commit/195670d677864ed310898fe9f4b00cc28d942237))

## [2.15.0](https://github.com/googleapis/java-bigquerystorage/compare/v2.14.2...v2.15.0) (2022-07-01)


### Features

* add fields to eventually contain row level errors ([ec3ea29](https://github.com/googleapis/java-bigquerystorage/commit/ec3ea29efae1cf6567055d43219690b3d2db8b5e))


### Bug Fixes

* Modify client lib retry policy for CreateWriteStream with longer backoff, more error code and longer overall time ([#1679](https://github.com/googleapis/java-bigquerystorage/issues/1679)) ([ec3ea29](https://github.com/googleapis/java-bigquerystorage/commit/ec3ea29efae1cf6567055d43219690b3d2db8b5e))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v2.13.3 ([#1678](https://github.com/googleapis/java-bigquerystorage/issues/1678)) ([740f2ae](https://github.com/googleapis/java-bigquerystorage/commit/740f2ae070454fbc2a87fdd7c01c7f90fc3867f3))
* update dependency com.google.cloud:google-cloud-bigquery to v2.13.4 ([#1680](https://github.com/googleapis/java-bigquerystorage/issues/1680)) ([de1c8df](https://github.com/googleapis/java-bigquerystorage/commit/de1c8df710b0510d66e91ac42d5d56eba4442bdb))
* update dependency com.google.cloud:google-cloud-bigquery to v2.13.6 ([#1684](https://github.com/googleapis/java-bigquerystorage/issues/1684)) ([05cdb38](https://github.com/googleapis/java-bigquerystorage/commit/05cdb380d27ab7484c7f81a0a490a58de67694c6))
* update dependency com.google.cloud:google-cloud-bigquery to v2.13.7 ([#1687](https://github.com/googleapis/java-bigquerystorage/issues/1687)) ([8795ae7](https://github.com/googleapis/java-bigquerystorage/commit/8795ae78e55bb4eb651a6e78a2645e3fe8df8d8e))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.13.0 ([#1683](https://github.com/googleapis/java-bigquerystorage/issues/1683)) ([2821ee9](https://github.com/googleapis/java-bigquerystorage/commit/2821ee9d6893ce1f2ac68615d99973e2c98e3678))

## [2.14.2](https://github.com/googleapis/java-bigquerystorage/compare/v2.14.1...v2.14.2) (2022-06-08)


### Bug Fixes

* **floating:** floating point numbers as numerics ([#1648](https://github.com/googleapis/java-bigquerystorage/issues/1648)) ([ecf8598](https://github.com/googleapis/java-bigquerystorage/commit/ecf8598bf66c0921524bbdb74d968edb389f197c))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v2.13.1 ([#1668](https://github.com/googleapis/java-bigquerystorage/issues/1668)) ([3eb8d4f](https://github.com/googleapis/java-bigquerystorage/commit/3eb8d4f0ab4db257899f7c72e02fef0a8b200c6e))
* update dependency com.google.cloud:google-cloud-bigquery to v2.13.2 ([#1671](https://github.com/googleapis/java-bigquerystorage/issues/1671)) ([2018ede](https://github.com/googleapis/java-bigquerystorage/commit/2018ede764ebf02e658f685922dd16438c70f69b))

## [2.14.1](https://github.com/googleapis/java-bigquerystorage/compare/v2.14.0...v2.14.1) (2022-06-01)


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v2.12.0 ([#1660](https://github.com/googleapis/java-bigquerystorage/issues/1660)) ([9d97a98](https://github.com/googleapis/java-bigquerystorage/commit/9d97a9848e87a32c1c4201243feb717d91a060ec))
* update dependency com.google.cloud:google-cloud-bigquery to v2.13.0 ([#1665](https://github.com/googleapis/java-bigquerystorage/issues/1665)) ([9c3a609](https://github.com/googleapis/java-bigquerystorage/commit/9c3a6099a2b622a08a4f94dd21846fa46c0fdde8))

## [2.14.0](https://github.com/googleapis/java-bigquerystorage/compare/v2.13.0...v2.14.0) (2022-05-19)


### Features

* add build scripts for native image testing in Java 17 ([#1440](https://github.com/googleapis/java-bigquerystorage/issues/1440)) ([#1655](https://github.com/googleapis/java-bigquerystorage/issues/1655)) ([ac2dfaf](https://github.com/googleapis/java-bigquerystorage/commit/ac2dfafa921fe489861e9767c360be413e5a2ec1))


### Bug Fixes

* Add a throwException behavior when the StreamWriter inflight queue is full ([#1642](https://github.com/googleapis/java-bigquerystorage/issues/1642)) ([4dcf0d5](https://github.com/googleapis/java-bigquerystorage/commit/4dcf0d5e161cd2530a5468c1e3b327db63c45185))
* add extra JsonWriterTest to show that the LimitBehavior addition is not breaking ([#1643](https://github.com/googleapis/java-bigquerystorage/issues/1643)) ([320f5fc](https://github.com/googleapis/java-bigquerystorage/commit/320f5fc6a2a180e361f1a5a375095a65ec62003f))
* ints/longs are numerics ([#1596](https://github.com/googleapis/java-bigquerystorage/issues/1596)) ([d046c8d](https://github.com/googleapis/java-bigquerystorage/commit/d046c8d5ff9943cd4731ac6fccc77956554820e1)), closes [#1516](https://github.com/googleapis/java-bigquerystorage/issues/1516)


### Dependencies

* update arrow.version to v8 ([#1645](https://github.com/googleapis/java-bigquerystorage/issues/1645)) ([06e3c34](https://github.com/googleapis/java-bigquerystorage/commit/06e3c3407cd94db1c9ded667d1f25153dc281ba5))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.12.0 ([#1654](https://github.com/googleapis/java-bigquerystorage/issues/1654)) ([ec4f60b](https://github.com/googleapis/java-bigquerystorage/commit/ec4f60bd5c00846f1061f2cc1a79518d6afebdc5))

## [2.13.0](https://github.com/googleapis/java-bigquerystorage/compare/v2.12.2...v2.13.0) (2022-05-05)


### Features

* add support to a few more specific StorageErrors for the Write API ([#1563](https://github.com/googleapis/java-bigquerystorage/issues/1563)) ([c26091e](https://github.com/googleapis/java-bigquerystorage/commit/c26091e48b6542cf2078d46e2dbfe3220ab031f6))
* next release from main branch is 2.12.2 ([#1624](https://github.com/googleapis/java-bigquerystorage/issues/1624)) ([b2aa2a4](https://github.com/googleapis/java-bigquerystorage/commit/b2aa2a43752e5a8a71f7bc434397b73d77d8eb58))


### Bug Fixes

* A stuck when the client fail to get DoneCallback ([#1637](https://github.com/googleapis/java-bigquerystorage/issues/1637)) ([3baa84e](https://github.com/googleapis/java-bigquerystorage/commit/3baa84e96671a14936d1667d0e036a1565fa5b7a))
* Fix a possible NULL PTR after introduced timeout on waitForDone ([#1638](https://github.com/googleapis/java-bigquerystorage/issues/1638)) ([e1c6ded](https://github.com/googleapis/java-bigquerystorage/commit/e1c6ded336effbe302eee56df056a56a9dbb6b2f))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v2.10.10 ([#1623](https://github.com/googleapis/java-bigquerystorage/issues/1623)) ([54b74b8](https://github.com/googleapis/java-bigquerystorage/commit/54b74b80368252b93fb445c481731e0edfe3f5c3))
* update dependency org.apache.avro:avro to v1.11.0 ([#1632](https://github.com/googleapis/java-bigquerystorage/issues/1632)) ([b47eea0](https://github.com/googleapis/java-bigquerystorage/commit/b47eea05d4db5acaa7337dc4e1faa018d8b4e40d))


### Documentation

* **samples:** update WriteComittedStream sample code to match best practices ([#1628](https://github.com/googleapis/java-bigquerystorage/issues/1628)) ([5d4c7e1](https://github.com/googleapis/java-bigquerystorage/commit/5d4c7e18b82ab85f7498e34a29920e9af765f918))
* **sample:** update WriteToDefaultStream sample to match best practices ([#1631](https://github.com/googleapis/java-bigquerystorage/issues/1631)) ([73ddd7b](https://github.com/googleapis/java-bigquerystorage/commit/73ddd7b4fd44dce4be434726df57ecd84e6e3e6a))

### [2.12.2](https://github.com/googleapis/java-bigquerystorage/compare/v2.12.1...v2.12.2) (2022-04-18)


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v2.10.7 ([#1614](https://github.com/googleapis/java-bigquerystorage/issues/1614)) ([ccdac87](https://github.com/googleapis/java-bigquerystorage/commit/ccdac87cc439b5f765d35af6d247b83122c1f40b))
* update dependency com.google.cloud:google-cloud-bigquery to v2.10.8 ([#1618](https://github.com/googleapis/java-bigquerystorage/issues/1618)) ([b9c50f1](https://github.com/googleapis/java-bigquerystorage/commit/b9c50f169d6092647becef5d99174be61b095ca8))
* update dependency com.google.cloud:google-cloud-bigquery to v2.10.9 ([#1620](https://github.com/googleapis/java-bigquerystorage/issues/1620)) ([7e1ae93](https://github.com/googleapis/java-bigquerystorage/commit/7e1ae93a1ee54a83d93a7421b438a53455dc89c2))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.10.0 ([#1619](https://github.com/googleapis/java-bigquerystorage/issues/1619)) ([55c4134](https://github.com/googleapis/java-bigquerystorage/commit/55c413459d029bf521eadf59f3c9fba9a7e876a1))

### [2.12.1](https://github.com/googleapis/java-bigquerystorage/compare/v2.12.0...v2.12.1) (2022-04-08)


### Bug Fixes

* even better ISO compilance ([#1607](https://github.com/googleapis/java-bigquerystorage/issues/1607)) ([5701597](https://github.com/googleapis/java-bigquerystorage/commit/570159799d8d464fbdb5bd617cc2a51f4f276f98))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v2.10.6 ([#1610](https://github.com/googleapis/java-bigquerystorage/issues/1610)) ([20e4225](https://github.com/googleapis/java-bigquerystorage/commit/20e4225734358bfce7c872e19c823ac6958d7905))

## [2.12.0](https://github.com/googleapis/java-bigquerystorage/compare/v2.11.1...v2.12.0) (2022-04-01)


### Features

* Deprecate format specific `row_count` field in Read API ([#1599](https://github.com/googleapis/java-bigquerystorage/issues/1599)) ([6f415f6](https://github.com/googleapis/java-bigquerystorage/commit/6f415f62685549f50f7382bc7d896e5f60c5285e))


### Bug Fixes

* better ISO8601 compliance ([#1589](https://github.com/googleapis/java-bigquerystorage/issues/1589)) ([29fa8b7](https://github.com/googleapis/java-bigquerystorage/commit/29fa8b73bc092a7ebe8e3951daf2026057d1d040))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v2.10.5 ([#1602](https://github.com/googleapis/java-bigquerystorage/issues/1602)) ([8787b5d](https://github.com/googleapis/java-bigquerystorage/commit/8787b5d36849981f9497ac2b0ddf8c5291b07fc8))

### [2.11.1](https://github.com/googleapis/java-bigquerystorage/compare/v2.11.0...v2.11.1) (2022-03-29)


### Bug Fixes

* Numerics cast from strings ([#1588](https://github.com/googleapis/java-bigquerystorage/issues/1588)) ([085768b](https://github.com/googleapis/java-bigquerystorage/commit/085768b41943237f50d5e47fa4ba5f22abff9fc6))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v2.10.0 ([#1578](https://github.com/googleapis/java-bigquerystorage/issues/1578)) ([adca54e](https://github.com/googleapis/java-bigquerystorage/commit/adca54eb0348d2ba02d3c272e180beebd9feb6c6))
* update dependency com.google.cloud:google-cloud-bigquery to v2.10.1 ([#1583](https://github.com/googleapis/java-bigquerystorage/issues/1583)) ([cc33d0e](https://github.com/googleapis/java-bigquerystorage/commit/cc33d0e539cc2ed53bf0ab265c5ebe55a0ac6c6e))
* update dependency com.google.cloud:google-cloud-bigquery to v2.10.2 ([#1587](https://github.com/googleapis/java-bigquerystorage/issues/1587)) ([d4ab7f6](https://github.com/googleapis/java-bigquerystorage/commit/d4ab7f64e32e4be8d1047d93b34cdadeccd98d90))
* update dependency com.google.cloud:google-cloud-bigquery to v2.10.3 ([#1591](https://github.com/googleapis/java-bigquerystorage/issues/1591)) ([0c62c85](https://github.com/googleapis/java-bigquerystorage/commit/0c62c85cf5fead39c04512c49db79d8e95fd44e6))
* update dependency com.google.cloud:google-cloud-bigquery to v2.10.4 ([#1594](https://github.com/googleapis/java-bigquerystorage/issues/1594)) ([05e9062](https://github.com/googleapis/java-bigquerystorage/commit/05e90620192747096854e60047cbca1fa6d81ea5))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.9.0 ([#1593](https://github.com/googleapis/java-bigquerystorage/issues/1593)) ([5234809](https://github.com/googleapis/java-bigquerystorage/commit/5234809e0482b05e40cbb6cecbb1154699255a59))

## [2.11.0](https://github.com/googleapis/java-bigquerystorage/compare/v2.10.1...v2.11.0) (2022-03-14)


### Features

* add JsonToProtoMessage support for TIMESTAMP ([#1574](https://github.com/googleapis/java-bigquerystorage/issues/1574)) ([6412fb2](https://github.com/googleapis/java-bigquerystorage/commit/6412fb2c03fc6b2c6d220d72bbd89e47922bf970)), closes [#1515](https://github.com/googleapis/java-bigquerystorage/issues/1515)


### Bug Fixes

* a possible race condition that we used table schema out of the lock. ([#1575](https://github.com/googleapis/java-bigquerystorage/issues/1575)) ([b587638](https://github.com/googleapis/java-bigquerystorage/commit/b58763833ad4bd51515c055bbcb8e29d9fea05a9))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v2.9.1 ([#1562](https://github.com/googleapis/java-bigquerystorage/issues/1562)) ([7efdbf0](https://github.com/googleapis/java-bigquerystorage/commit/7efdbf0df14ccc84409d09b5c93ac1058c95d50e))
* update dependency com.google.cloud:google-cloud-bigquery to v2.9.3 ([#1570](https://github.com/googleapis/java-bigquerystorage/issues/1570)) ([3d281d2](https://github.com/googleapis/java-bigquerystorage/commit/3d281d2e01f9170eac92ac51757fbd434d9b6b73))
* update dependency com.google.cloud:google-cloud-bigquery to v2.9.4 ([#1572](https://github.com/googleapis/java-bigquerystorage/issues/1572)) ([d3935cd](https://github.com/googleapis/java-bigquerystorage/commit/d3935cd3120f49aaae4c4e6839782bfa05836e90))

### [2.10.1](https://github.com/googleapis/java-bigquerystorage/compare/v2.10.0...v2.10.1) (2022-03-03)


### Bug Fixes

* change customer StorageException from RuntimeException to StatusRuntimeException ([#1559](https://github.com/googleapis/java-bigquerystorage/issues/1559)) ([523377e](https://github.com/googleapis/java-bigquerystorage/commit/523377e0bbfbae33165258b8eeed812c81cfeb82))


### Dependencies

* update actions/checkout action to v3 ([#1554](https://github.com/googleapis/java-bigquerystorage/issues/1554)) ([1371ac9](https://github.com/googleapis/java-bigquerystorage/commit/1371ac91bad55711b66e08ddeed6302598329a46))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.8.0 ([#1555](https://github.com/googleapis/java-bigquerystorage/issues/1555)) ([cc25162](https://github.com/googleapis/java-bigquerystorage/commit/cc25162021a2b05e68fd3dd1f98e252a10626f6b))


### Documentation

* improve documentation for write client ([#1560](https://github.com/googleapis/java-bigquerystorage/issues/1560)) ([fbb5321](https://github.com/googleapis/java-bigquerystorage/commit/fbb5321bd35bdd7ba81bcb95278d6cdd9abd3dee))

## [2.10.0](https://github.com/googleapis/java-bigquerystorage/compare/v2.9.1...v2.10.0) (2022-02-28)


### Features

* add trace_id for Read API ([#1544](https://github.com/googleapis/java-bigquerystorage/issues/1544)) ([5a92ade](https://github.com/googleapis/java-bigquerystorage/commit/5a92ade809d16e2770c07bd5287fbccb75645b21))


### Bug Fixes

* Add a e2e test on byte string array and remove a impossible case for byte array conversion ([#1546](https://github.com/googleapis/java-bigquerystorage/issues/1546)) ([adcb9bb](https://github.com/googleapis/java-bigquerystorage/commit/adcb9bb699e54d93da320e6a458caff79faa2f9f))
* add more idiomatic way to insert ARRAY<BYTES> data ([#1550](https://github.com/googleapis/java-bigquerystorage/issues/1550)) ([3ae4038](https://github.com/googleapis/java-bigquerystorage/commit/3ae40381aeacd21676f2c896216faa26eb1ef960))
* remove bigquery.readonly auth scope ([#1543](https://github.com/googleapis/java-bigquerystorage/issues/1543)) ([a70ae45](https://github.com/googleapis/java-bigquerystorage/commit/a70ae45c013a311aaeccd6885a9b9752bbcf57cc))


### Dependencies

* update actions/github-script action to v6 ([#1533](https://github.com/googleapis/java-bigquerystorage/issues/1533)) ([370c3b5](https://github.com/googleapis/java-bigquerystorage/commit/370c3b5bf236ab7853c4cc6d32393f93f5a165e4))
* update dependency com.google.cloud:google-cloud-bigquery to v2.9.0 ([#1538](https://github.com/googleapis/java-bigquerystorage/issues/1538)) ([43446b2](https://github.com/googleapis/java-bigquerystorage/commit/43446b24438526cc31542a0181fbed610df4b3c0))


### Documentation

* **tutorials:** Add STRUCT column to tutorial ([#1534](https://github.com/googleapis/java-bigquerystorage/issues/1534)) ([9595dab](https://github.com/googleapis/java-bigquerystorage/commit/9595dab89144cb13e812f4a277bb424d98c6591c))
* **tutorials:** Call append asynchronously instead of blocking ([#1542](https://github.com/googleapis/java-bigquerystorage/issues/1542)) ([c777e23](https://github.com/googleapis/java-bigquerystorage/commit/c777e236c21204300231c3d3cbfaa3760da643b8))

### [2.9.1](https://github.com/googleapis/java-bigquerystorage/compare/v2.9.0...v2.9.1) (2022-02-11)


### Bug Fixes

* rollback the reconnect after 10MB behavior after the fix for omg… ([#1530](https://github.com/googleapis/java-bigquerystorage/issues/1530)) ([737bd0e](https://github.com/googleapis/java-bigquerystorage/commit/737bd0e2c21332fd1c0c82a12e31ce5749a078fd))


### Dependencies

* update arrow.version to v7 (major) ([#1526](https://github.com/googleapis/java-bigquerystorage/issues/1526)) ([b6a4479](https://github.com/googleapis/java-bigquerystorage/commit/b6a4479e023c6c05bccd3451e929105a1f7b8b9d))
* update dependency org.apache.arrow:arrow-memory-netty to v7 ([#1527](https://github.com/googleapis/java-bigquerystorage/issues/1527)) ([06e927f](https://github.com/googleapis/java-bigquerystorage/commit/06e927f071271c12d7c1904b2d2c3f7f9e8338c7))
* update dependency org.apache.arrow:arrow-vector to v7 ([#1528](https://github.com/googleapis/java-bigquerystorage/issues/1528)) ([70297cc](https://github.com/googleapis/java-bigquerystorage/commit/70297ccd4828fc08bdf3b021af103aa01975ccb3))

## [2.9.0](https://github.com/googleapis/java-bigquerystorage/compare/v2.8.4...v2.9.0) (2022-02-08)


### Features

* add a indicator of how much time a request is waiting for inflight limit ([#1514](https://github.com/googleapis/java-bigquerystorage/issues/1514)) ([54874be](https://github.com/googleapis/java-bigquerystorage/commit/54874be945c2b88be6be03ae654277445c17741d))
* temp workaround for omg/48020 ([#1521](https://github.com/googleapis/java-bigquerystorage/issues/1521)) ([ff28f65](https://github.com/googleapis/java-bigquerystorage/commit/ff28f65328fbd433117a314cdff7510a28160591))


### Bug Fixes

* add a DATE type e2e test ([#1511](https://github.com/googleapis/java-bigquerystorage/issues/1511)) ([5eaf38e](https://github.com/googleapis/java-bigquerystorage/commit/5eaf38ee7fb9f84c454e0e9da5fe9092ff4c456a))


### Documentation

* **tutorials:** Add IT to JsonWriteDefaultStream tutorial ([#1522](https://github.com/googleapis/java-bigquerystorage/issues/1522)) ([9fd7aca](https://github.com/googleapis/java-bigquerystorage/commit/9fd7aca8b6032a2c02d0ea91dd063c9ac9e151aa))

### [2.8.4](https://github.com/googleapis/java-bigquerystorage/compare/v2.8.3...v2.8.4) (2022-02-03)


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v2.7.1 ([#1505](https://github.com/googleapis/java-bigquerystorage/issues/1505)) ([a700d92](https://github.com/googleapis/java-bigquerystorage/commit/a700d92c9f591f2b653aad6d79b2f61c4c44df98))
* update dependency com.google.cloud:google-cloud-bigquery to v2.8.0 ([#1508](https://github.com/googleapis/java-bigquerystorage/issues/1508)) ([b9ab6aa](https://github.com/googleapis/java-bigquerystorage/commit/b9ab6aac2f360f9ab541d83ad1f2d921657a56bf))


### Documentation

* **tutorials:** add integration test file structure for tutorials ([#1507](https://github.com/googleapis/java-bigquerystorage/issues/1507)) ([ecb1fbb](https://github.com/googleapis/java-bigquerystorage/commit/ecb1fbb1186a2bb22a2c27ba85ff6ecfab883011))
* **tutorials:** Add README, other small fixes to JsonWriterDefaultStream tutorial ([#1504](https://github.com/googleapis/java-bigquerystorage/issues/1504)) ([691eae5](https://github.com/googleapis/java-bigquerystorage/commit/691eae56f80a6751f25ef0db4f1d7b4bd6db2f66))

### [2.8.3](https://github.com/googleapis/java-bigquerystorage/compare/v2.8.2...v2.8.3) (2022-01-28)


### Dependencies

* **java:** update actions/github-script action to v5 ([#1339](https://github.com/googleapis/java-bigquerystorage/issues/1339)) ([#1491](https://github.com/googleapis/java-bigquerystorage/issues/1491)) ([7eea012](https://github.com/googleapis/java-bigquerystorage/commit/7eea012ee49ebba9c97273abd6331a63868bf72e))
* update actions/github-script action to v5 ([#1492](https://github.com/googleapis/java-bigquerystorage/issues/1492)) ([580c033](https://github.com/googleapis/java-bigquerystorage/commit/580c03363e5f3b8231e8ef491164badf0b126ca8))
* update dependency com.google.cloud:google-cloud-bigquery to v2.7.0 ([#1499](https://github.com/googleapis/java-bigquerystorage/issues/1499)) ([0d414f8](https://github.com/googleapis/java-bigquerystorage/commit/0d414f8eaca6daf89b3f981f2c727b217a59e658))
* upgrade google-cloud-shared-dependencies to v2.7.0 ([#1501](https://github.com/googleapis/java-bigquerystorage/issues/1501)) ([3f75e83](https://github.com/googleapis/java-bigquerystorage/commit/3f75e83cb5140f633204374a315831ccd09dfae3))


### Documentation

* **tutorials:** add a README.md ([#1500](https://github.com/googleapis/java-bigquerystorage/issues/1500)) ([c50c6a0](https://github.com/googleapis/java-bigquerystorage/commit/c50c6a039a47cc6e0a1e56966142b21e476074c8))
* **tutorials:** add new tutorials directory and JsonWriterDefaultStream tutorial ([#1498](https://github.com/googleapis/java-bigquerystorage/issues/1498)) ([fd1ecf2](https://github.com/googleapis/java-bigquerystorage/commit/fd1ecf2a8e7b96b7edbf5c9b6d12dedee8c9ba49))

### [2.8.2](https://github.com/googleapis/java-bigquerystorage/compare/v2.8.1...v2.8.2) (2022-01-25)


### Bug Fixes

* **java:** add reflection configuration for native-image testing ([#1488](https://github.com/googleapis/java-bigquerystorage/issues/1488)) ([d87fe28](https://github.com/googleapis/java-bigquerystorage/commit/d87fe282800b4ef4a9c5ecf918278a84eb20ce5d))


### Documentation

* **samples:** add finalize call to our samples ([#1471](https://github.com/googleapis/java-bigquerystorage/issues/1471)) ([47e3654](https://github.com/googleapis/java-bigquerystorage/commit/47e36543480bf495f4caea63419bb3b31ac7638c))
* **samples:** update to v1 in doc URls ([#1489](https://github.com/googleapis/java-bigquerystorage/issues/1489)) ([7efe427](https://github.com/googleapis/java-bigquerystorage/commit/7efe4273d9afebac6f67ed46763d5896b4b1bbcd))


### Dependencies

* exclude un-used runtime dependencies brought in by gax-grpc ([#1490](https://github.com/googleapis/java-bigquerystorage/issues/1490)) ([3e7833e](https://github.com/googleapis/java-bigquerystorage/commit/3e7833ea33ceac5f3e7cb9696a6e7ef6e914469b))
* update dependency com.google.cloud:google-cloud-bigquery to v2.6.1 ([#1473](https://github.com/googleapis/java-bigquerystorage/issues/1473)) ([f996cdb](https://github.com/googleapis/java-bigquerystorage/commit/f996cdbbc6cc9ad7c6a649ebb649ae005054f36e))
* update dependency com.google.cloud:google-cloud-bigquery to v2.6.2 ([#1475](https://github.com/googleapis/java-bigquerystorage/issues/1475)) ([37c1fd8](https://github.com/googleapis/java-bigquerystorage/commit/37c1fd887acfc5676ebb55e085b6e3514b6e5ca4))
* update dependency kr.motd.maven:os-maven-plugin to v1.7.0 ([#1476](https://github.com/googleapis/java-bigquerystorage/issues/1476)) ([e038151](https://github.com/googleapis/java-bigquerystorage/commit/e038151442c4fd86e94ab7f3d02989c73a23ee91))

### [2.8.1](https://www.github.com/googleapis/java-bigquerystorage/compare/v2.8.0...v2.8.1) (2022-01-07)


### Bug Fixes

* **java:** run Maven in plain console-friendly mode ([#1301](https://www.github.com/googleapis/java-bigquerystorage/issues/1301)) ([#1461](https://www.github.com/googleapis/java-bigquerystorage/issues/1461)) ([6b9e08c](https://www.github.com/googleapis/java-bigquerystorage/commit/6b9e08c4736cfdb4d98bf3c8f782a87ab68580ce))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v2.6.0 ([#1459](https://www.github.com/googleapis/java-bigquerystorage/issues/1459)) ([323813c](https://www.github.com/googleapis/java-bigquerystorage/commit/323813c88cd673bbf3f8631f03ac1732f7d3ac53))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.6.0 ([#1467](https://www.github.com/googleapis/java-bigquerystorage/issues/1467)) ([8ebb448](https://www.github.com/googleapis/java-bigquerystorage/commit/8ebb448ff0a1188124c1deeebe4bddbfe277e35b))

## [2.8.0](https://www.github.com/googleapis/java-bigquerystorage/compare/v2.7.0...v2.8.0) (2021-12-30)


### Features

* Add ignoreUnknownField support in JsonWriter ([#1455](https://www.github.com/googleapis/java-bigquerystorage/issues/1455)) ([4616adb](https://www.github.com/googleapis/java-bigquerystorage/commit/4616adb30d07d7be522b74837adae080eca103a6))
* Add reconnect support to v1 client lib. ([#1446](https://www.github.com/googleapis/java-bigquerystorage/issues/1446)) ([a5157fa](https://www.github.com/googleapis/java-bigquerystorage/commit/a5157faf37354ee48a0af930a68edf4823b5be6f))
* add schema update support in JsonStreamWriter ([#1447](https://www.github.com/googleapis/java-bigquerystorage/issues/1447)) ([973afcc](https://www.github.com/googleapis/java-bigquerystorage/commit/973afccc22507b8109b3920d3fc183692dcc66c2))
* support `append()` without offset in `StreamWriter` ([#1452](https://www.github.com/googleapis/java-bigquerystorage/issues/1452)) ([cb8b0ad](https://www.github.com/googleapis/java-bigquerystorage/commit/cb8b0ad25fbf07c3509b3d94244a999b9cb90e54))


### Bug Fixes

* allow all fields to be null values ([#1450](https://www.github.com/googleapis/java-bigquerystorage/issues/1450)) ([e47ac79](https://www.github.com/googleapis/java-bigquerystorage/commit/e47ac791765486f02f027d3c440645ef2a379ba9))
* finish BIGNUMERIC support ([#1449](https://www.github.com/googleapis/java-bigquerystorage/issues/1449)) ([d9d51cd](https://www.github.com/googleapis/java-bigquerystorage/commit/d9d51cd203733a972c80e312e9e279b50fb260fa))
* fix a NullPtr when user closes a writer without connection being ever established ([#1454](https://www.github.com/googleapis/java-bigquerystorage/issues/1454)) ([b774f5d](https://www.github.com/googleapis/java-bigquerystorage/commit/b774f5d0d00275278708d1299b4912b455be4bed))
* update storageError support due to server side enhancement ([#1456](https://www.github.com/googleapis/java-bigquerystorage/issues/1456)) ([6243ad5](https://www.github.com/googleapis/java-bigquerystorage/commit/6243ad5cba61d4dae7f4ceb60b09c625e7589215))

## [2.7.0](https://www.github.com/googleapis/java-bigquerystorage/compare/v2.6.5...v2.7.0) (2021-12-07)


### Features

* add write_mode support for BigQuery Storage Write API v1 ([#1441](https://www.github.com/googleapis/java-bigquerystorage/issues/1441)) ([ffe0670](https://www.github.com/googleapis/java-bigquerystorage/commit/ffe067011a79eb96e36f12cb738c34e2763e7c59))


### Bug Fixes

* **java:** add -ntp flag to native image testing command ([#1299](https://www.github.com/googleapis/java-bigquerystorage/issues/1299)) ([#1439](https://www.github.com/googleapis/java-bigquerystorage/issues/1439)) ([b6a880c](https://www.github.com/googleapis/java-bigquerystorage/commit/b6a880c90acd195d5f4294de343d81cffe8c359a))

### [2.6.5](https://www.github.com/googleapis/java-bigquerystorage/compare/v2.6.4...v2.6.5) (2021-12-05)


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v2.5.1 ([#1435](https://www.github.com/googleapis/java-bigquerystorage/issues/1435)) ([9116ecf](https://www.github.com/googleapis/java-bigquerystorage/commit/9116ecfc7257265ed575888c4cdc27d8fa4e7692))

### [2.6.4](https://www.github.com/googleapis/java-bigquerystorage/compare/v2.6.3...v2.6.4) (2021-12-03)


### Reverts

* "chore(deps): update dependency com.google.cloud.samples:shared-configuration to v1.0.24" ([#1431](https://www.github.com/googleapis/java-bigquerystorage/issues/1431)) ([b4fab5f](https://www.github.com/googleapis/java-bigquerystorage/commit/b4fab5f00b8d6a58b9768d32f16fb3a013265690))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v2.5.0 ([#1427](https://www.github.com/googleapis/java-bigquerystorage/issues/1427)) ([bc69fee](https://www.github.com/googleapis/java-bigquerystorage/commit/bc69fee6cfa1ef152ed1a6da61fb4728f1639aa8))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.5.1 ([#1429](https://www.github.com/googleapis/java-bigquerystorage/issues/1429)) ([543c63e](https://www.github.com/googleapis/java-bigquerystorage/commit/543c63e6c00da9a177994b4292ae5cda2ceeab65))

### [2.6.3](https://www.github.com/googleapis/java-bigquerystorage/compare/v2.6.2...v2.6.3) (2021-11-19)


### Dependencies

* update arrow.version to v6.0.1 ([#1417](https://www.github.com/googleapis/java-bigquerystorage/issues/1417)) ([e545cd2](https://www.github.com/googleapis/java-bigquerystorage/commit/e545cd242b5fb12a469a1e3cf389403d889e49cc))

### [2.6.2](https://www.github.com/googleapis/java-bigquerystorage/compare/v2.6.1...v2.6.2) (2021-11-17)


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v2.4.1 ([#1412](https://www.github.com/googleapis/java-bigquerystorage/issues/1412)) ([e862027](https://www.github.com/googleapis/java-bigquerystorage/commit/e862027ad85c337b352a99fcd669cceb14ceed8c))

### [2.6.1](https://www.github.com/googleapis/java-bigquerystorage/compare/v2.6.0...v2.6.1) (2021-11-17)


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v2.4.0 ([#1408](https://www.github.com/googleapis/java-bigquerystorage/issues/1408)) ([0ad6ce7](https://www.github.com/googleapis/java-bigquerystorage/commit/0ad6ce7311b9402fd0b4539833f3cf42e485873c))

## [2.6.0](https://www.github.com/googleapis/java-bigquerystorage/compare/v2.5.1...v2.6.0) (2021-11-15)


### Features

* add support for StorageError ([#1391](https://www.github.com/googleapis/java-bigquerystorage/issues/1391)) ([176dc8b](https://www.github.com/googleapis/java-bigquerystorage/commit/176dc8b1fa30cf9a9a98628bd83c9ab487ddb094))
* DATE and DOUBLE support more input formats ([#1397](https://www.github.com/googleapis/java-bigquerystorage/issues/1397)) ([9c8dc0a](https://www.github.com/googleapis/java-bigquerystorage/commit/9c8dc0aabb471fdb8580f434cc5a66bad585e8f2))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.5.0 ([#1406](https://www.github.com/googleapis/java-bigquerystorage/issues/1406)) ([38f5eb9](https://www.github.com/googleapis/java-bigquerystorage/commit/38f5eb9788e1f090c0034a789a512dcec2384fdb))

### [2.5.1](https://www.github.com/googleapis/java-bigquerystorage/compare/v2.5.0...v2.5.1) (2021-11-03)


### Dependencies

* update dependency org.apache.avro:avro to v1.11.0 ([#1387](https://www.github.com/googleapis/java-bigquerystorage/issues/1387)) ([117ad11](https://www.github.com/googleapis/java-bigquerystorage/commit/117ad11c91850c67c6b99bdecf729e48728bfbbe))

## [2.5.0](https://www.github.com/googleapis/java-bigquerystorage/compare/v2.4.2...v2.5.0) (2021-10-26)


### Features

* next release from main branch is 2.4.1 ([#1376](https://www.github.com/googleapis/java-bigquerystorage/issues/1376)) ([ca21447](https://www.github.com/googleapis/java-bigquerystorage/commit/ca21447e56dacbe2cec4722f037d441479ec2a8f))


### Bug Fixes

* BQ/proto schema names should be compared lowercase ([#1369](https://www.github.com/googleapis/java-bigquerystorage/issues/1369)) ([a0da90e](https://www.github.com/googleapis/java-bigquerystorage/commit/a0da90e8de89c5b9ef77183fee86e1e1a7389e00))


### Dependencies

* update arrow.version to v6 ([#1383](https://www.github.com/googleapis/java-bigquerystorage/issues/1383)) ([f2e3562](https://www.github.com/googleapis/java-bigquerystorage/commit/f2e3562fc1ed0a1a1e71c077dc6d37ae3fe6b3be))
* update dependency com.google.cloud:google-cloud-bigquery to v2.3.2 ([#1378](https://www.github.com/googleapis/java-bigquerystorage/issues/1378)) ([5983419](https://www.github.com/googleapis/java-bigquerystorage/commit/5983419a0d71849787876ecb5715c919f6ce04f9))
* update dependency com.google.cloud:google-cloud-bigquery to v2.3.3 ([#1382](https://www.github.com/googleapis/java-bigquerystorage/issues/1382)) ([8705af7](https://www.github.com/googleapis/java-bigquerystorage/commit/8705af7a11aa6a8f8182193011fc8bc7c4a28a4f))

### [2.4.2](https://www.github.com/googleapis/java-bigquerystorage/compare/v2.4.1...v2.4.2) (2021-10-20)


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v2.3.1 ([#1370](https://www.github.com/googleapis/java-bigquerystorage/issues/1370)) ([ba1a1ad](https://www.github.com/googleapis/java-bigquerystorage/commit/ba1a1ad1d9ce6d87ec8bdcfd3412792180c58742))

### [2.4.1](https://www.github.com/googleapis/java-bigquerystorage/compare/v2.4.0...v2.4.1) (2021-10-19)


### Bug Fixes

* remove excessive StreamWriter info logging ([#1359](https://www.github.com/googleapis/java-bigquerystorage/issues/1359)) ([0d27d5a](https://www.github.com/googleapis/java-bigquerystorage/commit/0d27d5a10ad62d506a646dcbf0a196e1d57740b0))


### Documentation

* **samples:** Update samples to v1 ([#1364](https://www.github.com/googleapis/java-bigquerystorage/issues/1364)) ([b705783](https://www.github.com/googleapis/java-bigquerystorage/commit/b705783d5939c1df96dc565cb763365e1989adb6))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v2.3.0 ([#1361](https://www.github.com/googleapis/java-bigquerystorage/issues/1361)) ([c8f0051](https://www.github.com/googleapis/java-bigquerystorage/commit/c8f00517a385461a2816afe7b95f8d5347e2fc10))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.4.0 ([#1365](https://www.github.com/googleapis/java-bigquerystorage/issues/1365)) ([69e96aa](https://www.github.com/googleapis/java-bigquerystorage/commit/69e96aaf8f13bd4887ec34af8db2bb5bf740282f))

## [2.4.0](https://www.github.com/googleapis/java-bigquerystorage/compare/v2.3.3...v2.4.0) (2021-10-12)


### Features

* Add INTERVAL and JSON type support to JsonStreamWriter ([#1351](https://www.github.com/googleapis/java-bigquerystorage/issues/1351)) ([f2121a7](https://www.github.com/googleapis/java-bigquerystorage/commit/f2121a796fa04d153124d87bd0d1041a401c0a42))

### [2.3.3](https://www.github.com/googleapis/java-bigquerystorage/compare/v2.3.2...v2.3.3) (2021-10-05)


### Bug Fixes

* add string to DATETIME, TIME, NUMERIC, BIGNUMERIC support in JsonStreamWriter v1 ([#1345](https://www.github.com/googleapis/java-bigquerystorage/issues/1345)) ([9d272dd](https://www.github.com/googleapis/java-bigquerystorage/commit/9d272dd711dfe8909a7b421dabdcdef30f1dc689))
* JsonWriter accepts string input for DATETIME, TIME, NUMERIC, BIGNUMERIC field ([#1339](https://www.github.com/googleapis/java-bigquerystorage/issues/1339)) ([691f078](https://www.github.com/googleapis/java-bigquerystorage/commit/691f078f09e32fa7784d4afeeee0e8071f78d6fd))
* Sample should show sending multiple rows in one request ([#1335](https://www.github.com/googleapis/java-bigquerystorage/issues/1335)) ([3f85a68](https://www.github.com/googleapis/java-bigquerystorage/commit/3f85a68d6812aac94ca8a266d76be2aa94cd0b32))


### Documentation

* **samples:** Add WriteAPI BUFFERED mode sample ([#1338](https://www.github.com/googleapis/java-bigquerystorage/issues/1338)) ([5dfd523](https://www.github.com/googleapis/java-bigquerystorage/commit/5dfd5231c1ffa68a1b92ba01a9608d8cee2c0596))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v2.2.0 ([#1346](https://www.github.com/googleapis/java-bigquerystorage/issues/1346)) ([9370eb8](https://www.github.com/googleapis/java-bigquerystorage/commit/9370eb8ea74547792f9597d20707546836c417b6))
* update dependency com.google.cloud:google-cloud-bigquery to v2.2.1 ([#1347](https://www.github.com/googleapis/java-bigquerystorage/issues/1347)) ([406f5d3](https://www.github.com/googleapis/java-bigquerystorage/commit/406f5d3d446d3a9639b2c95590b3c6c38118d741))

### [2.3.2](https://www.github.com/googleapis/java-bigquerystorage/compare/v2.3.1...v2.3.2) (2021-10-01)


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v2.1.13 ([#1336](https://www.github.com/googleapis/java-bigquerystorage/issues/1336)) ([8b2e46f](https://www.github.com/googleapis/java-bigquerystorage/commit/8b2e46f680d95b4e59734cc7793b8d9b69e718a8))

### [2.3.1](https://www.github.com/googleapis/java-bigquerystorage/compare/v2.3.0...v2.3.1) (2021-09-27)


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v2.1.12 ([#1327](https://www.github.com/googleapis/java-bigquerystorage/issues/1327)) ([67e694c](https://www.github.com/googleapis/java-bigquerystorage/commit/67e694c447bdea65baefb89dbe738239107f32d9))

## [2.3.0](https://www.github.com/googleapis/java-bigquerystorage/compare/v2.2.1...v2.3.0) (2021-09-24)


### Features

* writeapi v1 manual client lib ([#1323](https://www.github.com/googleapis/java-bigquerystorage/issues/1323)) ([baf8fb3](https://www.github.com/googleapis/java-bigquerystorage/commit/baf8fb3adc2e5135b71dd918ab30b619493a1b83))

### [2.2.1](https://www.github.com/googleapis/java-bigquerystorage/compare/v2.2.0...v2.2.1) (2021-09-23)


### Bug Fixes

* add missing read api retry setting on SplitReadStream ([#1315](https://www.github.com/googleapis/java-bigquerystorage/issues/1315)) ([015d6f4](https://www.github.com/googleapis/java-bigquerystorage/commit/015d6f4bbae4d7a4e8351e8173b25086372cfd8d))


### Documentation

* Align session length with public documentation feat: Expose estimated bytes that a session will scan. ([#1310](https://www.github.com/googleapis/java-bigquerystorage/issues/1310)) ([fff5c89](https://www.github.com/googleapis/java-bigquerystorage/commit/fff5c89738187bc4a34ce649ccf9c725a76282f7))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v2.1.10 ([#1318](https://www.github.com/googleapis/java-bigquerystorage/issues/1318)) ([f5d8b2d](https://www.github.com/googleapis/java-bigquerystorage/commit/f5d8b2d3fc3036de3b3e1167cd59bd826e451e45))
* update dependency com.google.cloud:google-cloud-bigquery to v2.1.11 ([#1320](https://www.github.com/googleapis/java-bigquerystorage/issues/1320)) ([12a2b03](https://www.github.com/googleapis/java-bigquerystorage/commit/12a2b03f0146173249c5b7c4e906e995e2fa6212))
* update dependency com.google.cloud:google-cloud-bigquery to v2.1.8 ([#1311](https://www.github.com/googleapis/java-bigquerystorage/issues/1311)) ([e5aa8fd](https://www.github.com/googleapis/java-bigquerystorage/commit/e5aa8fdcb4e1ba111f5eb23b82161b88a2012e31))
* update dependency com.google.cloud:google-cloud-bigquery to v2.1.9 ([#1317](https://www.github.com/googleapis/java-bigquerystorage/issues/1317)) ([600531d](https://www.github.com/googleapis/java-bigquerystorage/commit/600531d39f1642dcc4fda44790edc5dbb54d04f7))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.2.1 ([#1308](https://www.github.com/googleapis/java-bigquerystorage/issues/1308)) ([7be798d](https://www.github.com/googleapis/java-bigquerystorage/commit/7be798d3a1aa00bd7a4329b7539bf72cb301c844))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.3.0 ([#1319](https://www.github.com/googleapis/java-bigquerystorage/issues/1319)) ([2f2a44c](https://www.github.com/googleapis/java-bigquerystorage/commit/2f2a44cf649e29dce52ac36ffda91777158caf9a))

## [2.2.0](https://www.github.com/googleapis/java-bigquerystorage/compare/v2.1.2...v2.2.0) (2021-09-10)


### Features

* add trace id support to JsonWriter and add default trace id to help identify json writer users. ([#1302](https://www.github.com/googleapis/java-bigquerystorage/issues/1302)) ([0e749d9](https://www.github.com/googleapis/java-bigquerystorage/commit/0e749d9ee0201bc4653735ac34638452502a1c26))


### Bug Fixes

* Accept null json values in JsonToProtoMessage converter ([#1288](https://www.github.com/googleapis/java-bigquerystorage/issues/1288)) ([fb515ab](https://www.github.com/googleapis/java-bigquerystorage/commit/fb515ab0d8681bb7e559e3788f0ec8c0852b6e64))
* beta cleanup: remove deprecated classes and unused functionalities ([#1300](https://www.github.com/googleapis/java-bigquerystorage/issues/1300)) ([7d08d7b](https://www.github.com/googleapis/java-bigquerystorage/commit/7d08d7b96bc13b6bc72e795b0b975a77d7712882))
* Cannot share client between appendRows and other function becaus… ([#1290](https://www.github.com/googleapis/java-bigquerystorage/issues/1290)) ([c2dcf6f](https://www.github.com/googleapis/java-bigquerystorage/commit/c2dcf6fea0e6c5ed8085269fbec884deb5f32ad0))
* remove dependency on google-cloud-bigquery (cyclic dep) ([#1295](https://www.github.com/googleapis/java-bigquerystorage/issues/1295)) ([7ac47de](https://www.github.com/googleapis/java-bigquerystorage/commit/7ac47de0ad5a37fcc7bbb6ea7ce0f5b7e59d276c)), closes [#1249](https://www.github.com/googleapis/java-bigquerystorage/issues/1249)
* the request limit should be 10MB instead of 8MB ([#1289](https://www.github.com/googleapis/java-bigquerystorage/issues/1289)) ([ed1ea00](https://www.github.com/googleapis/java-bigquerystorage/commit/ed1ea00e25da1501d300f3c80ce0a17cc1f3d883))
* update comment to be consistent with code ([#1292](https://www.github.com/googleapis/java-bigquerystorage/issues/1292)) ([5669420](https://www.github.com/googleapis/java-bigquerystorage/commit/56694206740ded2edc115a88c0bf4bf4229b4fdf))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v2.1.7 ([#1298](https://www.github.com/googleapis/java-bigquerystorage/issues/1298)) ([c156410](https://www.github.com/googleapis/java-bigquerystorage/commit/c1564102147ceaf0bd77b9c86a9e5209dbc73174))


### Documentation

* Align session length with public documentation feat: Align ReadRows timeout with other versions of the API. ([#1281](https://www.github.com/googleapis/java-bigquerystorage/issues/1281)) ([b920cd5](https://www.github.com/googleapis/java-bigquerystorage/commit/b920cd59756b9db60026035605447236d4a0adf0))
* **samples:** update WriteToDefaultStream.java sample ([#1305](https://www.github.com/googleapis/java-bigquerystorage/issues/1305)) ([83c8e23](https://www.github.com/googleapis/java-bigquerystorage/commit/83c8e23b45ad233d82af89df1b61cc39b22ffe1c))

### [2.1.2](https://www.github.com/googleapis/java-bigquerystorage/compare/v2.1.1...v2.1.2) (2021-09-02)


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v2.1.5 ([#1279](https://www.github.com/googleapis/java-bigquerystorage/issues/1279)) ([59d031e](https://www.github.com/googleapis/java-bigquerystorage/commit/59d031ee1f4ab1f06bcc7b2d856bc11d29f13f53))
* update dependency com.google.cloud:google-cloud-bigquery to v2.1.6 ([#1284](https://www.github.com/googleapis/java-bigquerystorage/issues/1284)) ([8d62b9c](https://www.github.com/googleapis/java-bigquerystorage/commit/8d62b9c31db3077be62650873b81fe3a12110879))

### [2.1.1](https://www.github.com/googleapis/java-bigquerystorage/compare/v2.1.0...v2.1.1) (2021-08-31)


### Dependencies

* update dependency com.google.apis:google-api-services-bigquery to v2-rev20210819-1.32.1 ([#1273](https://www.github.com/googleapis/java-bigquerystorage/issues/1273)) ([0ab4bbb](https://www.github.com/googleapis/java-bigquerystorage/commit/0ab4bbbb1203f0dda49be721df7e2cee3838ec0b))
* update dependency com.google.cloud:google-cloud-bigquery to v2.1.3 ([#1266](https://www.github.com/googleapis/java-bigquerystorage/issues/1266)) ([e72d50f](https://www.github.com/googleapis/java-bigquerystorage/commit/e72d50f2d11c629c1bf51b99d6156b3c2004c669))
* update dependency com.google.cloud:google-cloud-bigquery to v2.1.4 ([#1269](https://www.github.com/googleapis/java-bigquerystorage/issues/1269)) ([c09c987](https://www.github.com/googleapis/java-bigquerystorage/commit/c09c9877008a2279878edf4e35b0a60e8a59c107))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.2.0 ([#1276](https://www.github.com/googleapis/java-bigquerystorage/issues/1276)) ([7254177](https://www.github.com/googleapis/java-bigquerystorage/commit/725417743876a766e8cd17b1f557540984c5d49b))

## [2.1.0](https://www.github.com/googleapis/java-bigquerystorage/compare/v2.0.4...v2.1.0) (2021-08-24)


### Features

* retry certain RESOURCE_EXHAUSTED errors observed during ReadRows and report retry attempts ([#1257](https://www.github.com/googleapis/java-bigquerystorage/issues/1257)) ([d56e1ca](https://www.github.com/googleapis/java-bigquerystorage/commit/d56e1caf91297d7c2e1e4a9ce1463c04e44619c0))


### Documentation

* **sample:** Remove `client` from `JsonStreamWriter` in `WriteCommittedStream` ([#1248](https://www.github.com/googleapis/java-bigquerystorage/issues/1248)) ([6d38bd5](https://www.github.com/googleapis/java-bigquerystorage/commit/6d38bd5e3ff383e55e852081bbea5807796f59dd))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.1.0 ([#1261](https://www.github.com/googleapis/java-bigquerystorage/issues/1261)) ([0edb25d](https://www.github.com/googleapis/java-bigquerystorage/commit/0edb25d4a55f5480d5717672f30b09e6433483b9))

### [2.0.4](https://www.github.com/googleapis/java-bigquerystorage/compare/v2.0.3...v2.0.4) (2021-08-19)


### Dependencies

* update dependency com.google.apis:google-api-services-bigquery to v2-rev20210813-1.32.1 ([#1253](https://www.github.com/googleapis/java-bigquerystorage/issues/1253)) ([b25c960](https://www.github.com/googleapis/java-bigquerystorage/commit/b25c96083b7a2910b5e3cfc92b5d77408e53ee66))

### [2.0.3](https://www.github.com/googleapis/java-bigquerystorage/compare/v2.0.2...v2.0.3) (2021-08-19)


### Dependencies

* update dependency com.google.apis:google-api-services-bigquery to v2-rev20210727-1.32.1 ([#1237](https://www.github.com/googleapis/java-bigquerystorage/issues/1237)) ([29e5204](https://www.github.com/googleapis/java-bigquerystorage/commit/29e52041a4d47cefbd92f51e4bf13cb160bd76da))
* update dependency com.google.cloud:google-cloud-bigquery to v2.1.2 ([#1239](https://www.github.com/googleapis/java-bigquerystorage/issues/1239)) ([5934277](https://www.github.com/googleapis/java-bigquerystorage/commit/593427798a13c6375db26f5656e7956e3dc10164))

### [2.0.2](https://www.github.com/googleapis/java-bigquerystorage/compare/v2.0.1...v2.0.2) (2021-08-12)


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v2.1.0 ([#1232](https://www.github.com/googleapis/java-bigquerystorage/issues/1232)) ([cef4fcb](https://www.github.com/googleapis/java-bigquerystorage/commit/cef4fcb6297dc94252ccb323205c34da7435a778))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.0.1 ([#1233](https://www.github.com/googleapis/java-bigquerystorage/issues/1233)) ([27169f0](https://www.github.com/googleapis/java-bigquerystorage/commit/27169f016ac8302b465a24e92995a54831197064))

### [2.0.1](https://www.github.com/googleapis/java-bigquerystorage/compare/v2.0.0...v2.0.1) (2021-08-10)


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v1.137.2 ([#1224](https://www.github.com/googleapis/java-bigquerystorage/issues/1224)) ([d8a312a](https://www.github.com/googleapis/java-bigquerystorage/commit/d8a312afdba4e2f81e25f9263d27e0c97f725f75))
* update dependency com.google.cloud:google-cloud-bigquery to v2 ([#1226](https://www.github.com/googleapis/java-bigquerystorage/issues/1226)) ([11c811e](https://www.github.com/googleapis/java-bigquerystorage/commit/11c811ecd44e375e4414578b666dc56d571e0502))

## [2.0.0](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.23.2...v2.0.0) (2021-08-05)


### ⚠ BREAKING CHANGES

* Java 8 breaking generator changes (#1222)

### Features

* Java 8 breaking generator changes ([#1222](https://www.github.com/googleapis/java-bigquerystorage/issues/1222)) ([ac9103c](https://www.github.com/googleapis/java-bigquerystorage/commit/ac9103c18b96933cb724ae9c96a46005bae8160d))


### Dependencies

* update dependency com.google.apis:google-api-services-bigquery to v2-rev20210726-1.32.1 ([#1217](https://www.github.com/googleapis/java-bigquerystorage/issues/1217)) ([2ae3d90](https://www.github.com/googleapis/java-bigquerystorage/commit/2ae3d90d25674e8520bf02c84b16efc7f40bfa83))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2 ([#1219](https://www.github.com/googleapis/java-bigquerystorage/issues/1219)) ([a83da41](https://www.github.com/googleapis/java-bigquerystorage/commit/a83da417b1260ab5086243905603152e5f8e0b97))

### [1.23.2](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.23.1...v1.23.2) (2021-07-29)


### Dependencies

* update arrow.version to v5 ([#1203](https://www.github.com/googleapis/java-bigquerystorage/issues/1203)) ([d56906e](https://www.github.com/googleapis/java-bigquerystorage/commit/d56906e10cc8109987358bcd18d26ac41a0cbdd9))

### [1.23.1](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.23.0...v1.23.1) (2021-07-22)


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v1.137.1 ([#1190](https://www.github.com/googleapis/java-bigquerystorage/issues/1190)) ([116460f](https://www.github.com/googleapis/java-bigquerystorage/commit/116460f722674bbc4b654da179885194dbe37e1b))

## [1.23.0](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.22.8...v1.23.0) (2021-07-14)


### Features

* Expand bytes field type handling ([#1180](https://www.github.com/googleapis/java-bigquerystorage/issues/1180)) ([aab33a5](https://www.github.com/googleapis/java-bigquerystorage/commit/aab33a55f3cb91003363ada1395f07868bc17ee5))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v1.136.0 ([#1176](https://www.github.com/googleapis/java-bigquerystorage/issues/1176)) ([95c77e2](https://www.github.com/googleapis/java-bigquerystorage/commit/95c77e24f2ed8319b0e08194f331a59e975369cc))
* update dependency com.google.cloud:google-cloud-bigquery to v1.137.0 ([#1184](https://www.github.com/googleapis/java-bigquerystorage/issues/1184)) ([8bf328c](https://www.github.com/googleapis/java-bigquerystorage/commit/8bf328c1e939b46b297c65359433bed8fbda03b2))

### [1.22.8](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.22.7...v1.22.8) (2021-07-07)


### Dependencies

* update dependency com.google.apis:google-api-services-bigquery to v2-rev20210617-1.32.1 ([#1168](https://www.github.com/googleapis/java-bigquerystorage/issues/1168)) ([61d52f0](https://www.github.com/googleapis/java-bigquerystorage/commit/61d52f02a91b698e2996b491f2da7eeba1dd7484))
* update dependency com.google.cloud:google-cloud-bigquery to v1.135.3 ([#1167](https://www.github.com/googleapis/java-bigquerystorage/issues/1167)) ([14bdcc4](https://www.github.com/googleapis/java-bigquerystorage/commit/14bdcc4809cb5cb39cc063fd8196e1c8a141c7fb))

### [1.22.7](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.22.6...v1.22.7) (2021-07-01)


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v1.135.2 ([#1163](https://www.github.com/googleapis/java-bigquerystorage/issues/1163)) ([9c11919](https://www.github.com/googleapis/java-bigquerystorage/commit/9c119195a4f64f8d737f71b47d7d2579d014dfd7))

### [1.22.6](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.22.5...v1.22.6) (2021-06-30)


### Documentation

* **sample:** add IT for WriteToDefaultStream ([#1158](https://www.github.com/googleapis/java-bigquerystorage/issues/1158)) ([3280d7a](https://www.github.com/googleapis/java-bigquerystorage/commit/3280d7a0495a25f2509c9d4719439253e0fbaa5d)), closes [#1156](https://www.github.com/googleapis/java-bigquerystorage/issues/1156)
* user-provided streamOrTableName for default write streams ([#1155](https://www.github.com/googleapis/java-bigquerystorage/issues/1155)) ([fc4a5c0](https://www.github.com/googleapis/java-bigquerystorage/commit/fc4a5c061f51d83e41109ebf04f4202276410e30))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v1.135.1 ([#1154](https://www.github.com/googleapis/java-bigquerystorage/issues/1154)) ([99f8ebb](https://www.github.com/googleapis/java-bigquerystorage/commit/99f8ebb2fde1fd86315a03dea5719e7a7744d081))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.4.0 ([#1159](https://www.github.com/googleapis/java-bigquerystorage/issues/1159)) ([7e1b206](https://www.github.com/googleapis/java-bigquerystorage/commit/7e1b2062f8cb13c05270d86c9ff6863934e7478d))

### [1.22.5](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.22.4...v1.22.5) (2021-06-28)


### Dependencies

* update dependency com.google.apis:google-api-services-bigquery to v2-rev20210617-1.31.5 ([#1147](https://www.github.com/googleapis/java-bigquerystorage/issues/1147)) ([0f4605f](https://www.github.com/googleapis/java-bigquerystorage/commit/0f4605ff5a5cb2cf8f2b961109c5a03a80508993))
* update dependency com.google.cloud:google-cloud-bigquery to v1.134.0 ([#1146](https://www.github.com/googleapis/java-bigquerystorage/issues/1146)) ([c7b3ca1](https://www.github.com/googleapis/java-bigquerystorage/commit/c7b3ca1894c7a6a9920887d05e6134cb7a9a0cfb))
* update dependency com.google.cloud:google-cloud-bigquery to v1.135.0 ([#1149](https://www.github.com/googleapis/java-bigquerystorage/issues/1149)) ([f220560](https://www.github.com/googleapis/java-bigquerystorage/commit/f220560a8c967ff2e09d044e377420d18b504be7))

### [1.22.4](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.22.3...v1.22.4) (2021-06-24)


### Bug Fixes

* Add `shopt -s nullglob` to dependencies script ([#1139](https://www.github.com/googleapis/java-bigquerystorage/issues/1139)) ([fef0aca](https://www.github.com/googleapis/java-bigquerystorage/commit/fef0acac23548ab521fcd98cde19ca1d022fad2b))
* Add google-api-services-bigquery to google-cloud-bigquerystorage-bom ([#1142](https://www.github.com/googleapis/java-bigquerystorage/issues/1142)) ([4e97130](https://www.github.com/googleapis/java-bigquerystorage/commit/4e97130dd1f703d0f710f27fceb577cef1b06b93))
* Update dependencies.sh to not break on mac ([#1134](https://www.github.com/googleapis/java-bigquerystorage/issues/1134)) ([85f8c9a](https://www.github.com/googleapis/java-bigquerystorage/commit/85f8c9af7928325fa3c32ec3896b8e3f87279901))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v1.133.1 ([#1136](https://www.github.com/googleapis/java-bigquerystorage/issues/1136)) ([7248e45](https://www.github.com/googleapis/java-bigquerystorage/commit/7248e459b7c9cdeac573f4bd03cb618d138a7618))

### [1.22.3](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.22.2...v1.22.3) (2021-06-11)


### Bug Fixes

* Make EOS Matching more robust ([#1128](https://www.github.com/googleapis/java-bigquerystorage/issues/1128)) ([3b5cdbe](https://www.github.com/googleapis/java-bigquerystorage/commit/3b5cdbe769fcebeebc571922c84c129066e76aaf))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v1.133.0 ([#1124](https://www.github.com/googleapis/java-bigquerystorage/issues/1124)) ([aea80e9](https://www.github.com/googleapis/java-bigquerystorage/commit/aea80e930ac5a9cb5fa8f751c977166d45f1341f))

### [1.22.2](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.22.1...v1.22.2) (2021-06-08)


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v1.132.1 ([#1114](https://www.github.com/googleapis/java-bigquerystorage/issues/1114)) ([845078e](https://www.github.com/googleapis/java-bigquerystorage/commit/845078e3f4e8cb273b893a11aaeb61f98120e10e))

### [1.22.1](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.22.0...v1.22.1) (2021-06-05)


### Bug Fixes

* call awaitTermination when close the stream writer ([#1111](https://www.github.com/googleapis/java-bigquerystorage/issues/1111)) ([0f7db50](https://www.github.com/googleapis/java-bigquerystorage/commit/0f7db50bdd8f653f8087550cb2d1eeb47975eadf))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v1.132.0 ([#1109](https://www.github.com/googleapis/java-bigquerystorage/issues/1109)) ([fc91b02](https://www.github.com/googleapis/java-bigquerystorage/commit/fc91b02a5361b7d80191489405967182445e3b44))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.3.0 ([#1108](https://www.github.com/googleapis/java-bigquerystorage/issues/1108)) ([05a936a](https://www.github.com/googleapis/java-bigquerystorage/commit/05a936a7c34c495010d18c2038d08d2662420958))

## [1.22.0](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.21.1...v1.22.0) (2021-05-31)


### ⚠ BREAKING CHANGES

* remove default deadline for AppendRows API (#1101)

### Features

* add `gcf-owl-bot[bot]` to `ignoreAuthors` ([#1092](https://www.github.com/googleapis/java-bigquerystorage/issues/1092)) ([9fe34d1](https://www.github.com/googleapis/java-bigquerystorage/commit/9fe34d1a7ea2b4c1f750fd8805251811a4b0111d))


### Bug Fixes

* More robust STREAM_RST logic ([#1102](https://www.github.com/googleapis/java-bigquerystorage/issues/1102)) ([dd67534](https://www.github.com/googleapis/java-bigquerystorage/commit/dd675343b20d614eaf715306f1151532a3a2c33f))
* remove default deadline for AppendRows API ([#1101](https://www.github.com/googleapis/java-bigquerystorage/issues/1101)) ([87cadf0](https://www.github.com/googleapis/java-bigquerystorage/commit/87cadf01edbdaf876699e98f027835d6594f8072))


### Dependencies

* update arrow.version to v4.0.1 ([#1103](https://www.github.com/googleapis/java-bigquerystorage/issues/1103)) ([b2e3489](https://www.github.com/googleapis/java-bigquerystorage/commit/b2e34894f443075ce375b822babcfc329b34c76c))
* update dependency com.google.truth:truth to v1.1.3 ([#1100](https://www.github.com/googleapis/java-bigquerystorage/issues/1100)) ([12c401f](https://www.github.com/googleapis/java-bigquerystorage/commit/12c401feec1fb7fbaf39ea7ccffee4a02faffeb3))

### [1.21.1](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.21.0...v1.21.1) (2021-05-19)


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v1.131.1 ([#1087](https://www.github.com/googleapis/java-bigquerystorage/issues/1087)) ([fd418bd](https://www.github.com/googleapis/java-bigquerystorage/commit/fd418bd525e929bb75b340137a95f06ea0977134))

## [1.21.0](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.20.6...v1.21.0) (2021-05-19)


### Features

* Add ZSTD compression as an option for Arrow proto changes ([d910a89](https://www.github.com/googleapis/java-bigquerystorage/commit/d910a8903d0eed6e8a8a4b7183dc7a0f401f66da))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v1.131.0 ([#1083](https://www.github.com/googleapis/java-bigquerystorage/issues/1083)) ([70ff6d5](https://www.github.com/googleapis/java-bigquerystorage/commit/70ff6d5ffaaa3ab3a2d6c940403b96ab6f711312))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.2.0 ([#1084](https://www.github.com/googleapis/java-bigquerystorage/issues/1084)) ([99fae33](https://www.github.com/googleapis/java-bigquerystorage/commit/99fae331b2d97ff63b61750d7284cd04f6abc2e6))

### [1.20.6](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.20.5...v1.20.6) (2021-05-18)


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v1.130.0 ([#1075](https://www.github.com/googleapis/java-bigquerystorage/issues/1075)) ([4cf3901](https://www.github.com/googleapis/java-bigquerystorage/commit/4cf39012afef9b2211aabbda891ffacba4344fb7))

### [1.20.5](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.20.4...v1.20.5) (2021-05-13)


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v1.129.0 ([#1065](https://www.github.com/googleapis/java-bigquerystorage/issues/1065)) ([b94e01f](https://www.github.com/googleapis/java-bigquerystorage/commit/b94e01f473dd99c34cc942a2f649973ba6325cb2))

### [1.20.4](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.20.3...v1.20.4) (2021-05-11)


### Bug Fixes

* migrate json writer to use StreamWriterV2 ([#1058](https://www.github.com/googleapis/java-bigquerystorage/issues/1058)) ([586777f](https://www.github.com/googleapis/java-bigquerystorage/commit/586777f289f3dc84d2d6237463f128d278d2465f))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.1.0 ([#1061](https://www.github.com/googleapis/java-bigquerystorage/issues/1061)) ([d6c3146](https://www.github.com/googleapis/java-bigquerystorage/commit/d6c3146d21282d1e0724583f68a31184d2d7167b))

### [1.20.3](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.20.2...v1.20.3) (2021-05-04)


### Bug Fixes

* remove schema update capability from jsonwriter and delete related tests ([#1047](https://www.github.com/googleapis/java-bigquerystorage/issues/1047)) ([21e399b](https://www.github.com/googleapis/java-bigquerystorage/commit/21e399bf4fca9b3ef84443ae1d32a6bfe393b61b))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v1.128.3 ([#1045](https://www.github.com/googleapis/java-bigquerystorage/issues/1045)) ([68beb48](https://www.github.com/googleapis/java-bigquerystorage/commit/68beb4896e5246389c216841dec519a9915362c3))

### [1.20.2](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.20.1...v1.20.2) (2021-04-27)


### Dependencies

* update arrow.version to v4 ([#1035](https://www.github.com/googleapis/java-bigquerystorage/issues/1035)) ([8e2225c](https://www.github.com/googleapis/java-bigquerystorage/commit/8e2225cf791a17deb674b12586e3ea041358d49c))
* update dependency com.google.cloud:google-cloud-bigquery to v1.128.1 ([#1033](https://www.github.com/googleapis/java-bigquerystorage/issues/1033)) ([776c670](https://www.github.com/googleapis/java-bigquerystorage/commit/776c670267d2c9bbc730c41f8187ac853b8525d3))

### [1.20.1](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.20.0...v1.20.1) (2021-04-24)


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1 ([#1030](https://www.github.com/googleapis/java-bigquerystorage/issues/1030)) ([7a00340](https://www.github.com/googleapis/java-bigquerystorage/commit/7a003405cfe301f3729cb373fe7f02da12506369))

## [1.20.0](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.19.0...v1.20.0) (2021-04-20)


### Features

* new JSON type through BigQuery Write ([#1013](https://www.github.com/googleapis/java-bigquerystorage/issues/1013)) ([357e811](https://www.github.com/googleapis/java-bigquerystorage/commit/357e811f5d429cacfce597be9a3e739e659f604a))


### Bug Fixes

* It seems GAPIC is not generated expected headers for bidi streaming client lib, apply a temp fix to unblock customers ([#1017](https://www.github.com/googleapis/java-bigquerystorage/issues/1017)) ([9c1ed55](https://www.github.com/googleapis/java-bigquerystorage/commit/9c1ed556c7e3a545932ec8ceff7b3c466e72d84f))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.21.1 ([#1018](https://www.github.com/googleapis/java-bigquerystorage/issues/1018)) ([827764e](https://www.github.com/googleapis/java-bigquerystorage/commit/827764ef215bdb73ccff0a2b9329c2295e5eef1f))

## [1.19.0](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.18.1...v1.19.0) (2021-04-15)


### ⚠ BREAKING CHANGES

* remove v1alpha2 library (#1003)

### Bug Fixes

* release scripts from issuing overlapping phases ([#1006](https://www.github.com/googleapis/java-bigquerystorage/issues/1006)) ([f338201](https://www.github.com/googleapis/java-bigquerystorage/commit/f3382013fa4e14eba89ecbc32bdad813b2880254))


### Code Refactoring

* remove v1alpha2 library ([#1003](https://www.github.com/googleapis/java-bigquerystorage/issues/1003)) ([98cd924](https://www.github.com/googleapis/java-bigquerystorage/commit/98cd924e335441f633ad87a0aed118de6951260c))

### [1.18.1](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.18.0...v1.18.1) (2021-04-10)


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v1.128.0 ([#993](https://www.github.com/googleapis/java-bigquerystorage/issues/993)) ([42989b5](https://www.github.com/googleapis/java-bigquerystorage/commit/42989b55b2fa9e2f2ce0a41092c9c151fb529ed6))

## [1.18.0](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.17.0...v1.18.0) (2021-04-09)


### Features

* add deprecated annotation and tag to bq storage alpha api ([#978](https://www.github.com/googleapis/java-bigquerystorage/issues/978)) ([c7da342](https://www.github.com/googleapis/java-bigquerystorage/commit/c7da34252ee8c243be3ce737d03e1e12f10a5eba))
* re-generated to pick up changes from googleapis. ([#982](https://www.github.com/googleapis/java-bigquerystorage/issues/982)) ([17bfbd8](https://www.github.com/googleapis/java-bigquerystorage/commit/17bfbd8dffd854356ea503adf3a6e065f1e1a4ee))


### Bug Fixes

* Cleanup JsonWriter bytes conversion code and add some test coverage ([#984](https://www.github.com/googleapis/java-bigquerystorage/issues/984)) ([e43df34](https://www.github.com/googleapis/java-bigquerystorage/commit/e43df3403c4d7644032cef6e1f1cf59e6ec1b5eb))


### Documentation

* update region tag for the storage quickstart ([#985](https://www.github.com/googleapis/java-bigquerystorage/issues/985)) ([1d0d6c3](https://www.github.com/googleapis/java-bigquerystorage/commit/1d0d6c3a877943b83775430d5a2bf7fcd24a1f21))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v1.127.12 ([#986](https://www.github.com/googleapis/java-bigquerystorage/issues/986)) ([d39bd79](https://www.github.com/googleapis/java-bigquerystorage/commit/d39bd79a69e987baa7721b907cdccb59d1ea4a74))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.21.0 ([#987](https://www.github.com/googleapis/java-bigquerystorage/issues/987)) ([4fa3dbb](https://www.github.com/googleapis/java-bigquerystorage/commit/4fa3dbba64586f6bf943ba67f225fad1b994e5a7))

## [1.17.0](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.16.1...v1.17.0) (2021-03-30)


### Features

* add a Arrow compression options (Only LZ4 for now) ([#972](https://www.github.com/googleapis/java-bigquerystorage/issues/972)) ([de0c0d2](https://www.github.com/googleapis/java-bigquerystorage/commit/de0c0d2c0a5e8b85a0f2aa5679a22fb8846a5fd0))
* BigDecimal and ByteString encoding ([#971](https://www.github.com/googleapis/java-bigquerystorage/issues/971)) ([82b556e](https://www.github.com/googleapis/java-bigquerystorage/commit/82b556e08d19a4dd969bda53409276c6408a4126))

### [1.16.1](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.16.0...v1.16.1) (2021-03-26)


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v1.127.11 ([#962](https://www.github.com/googleapis/java-bigquerystorage/issues/962)) ([87a821e](https://www.github.com/googleapis/java-bigquerystorage/commit/87a821ec7a6d6cf4fd2a214c1bbdc3691351ba61))

## [1.16.0](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.15.1...v1.16.0) (2021-03-25)


### Features

* Add CivilTimeEncoder to encode and decode DateTime/Time as numerics ([#937](https://www.github.com/googleapis/java-bigquerystorage/issues/937)) ([969b429](https://www.github.com/googleapis/java-bigquerystorage/commit/969b4290b9934b94b1a0113e04e37ff44b2a536e))


### Bug Fixes

* add a deprecation message on StreamWriter ([#922](https://www.github.com/googleapis/java-bigquerystorage/issues/922)) ([fce5289](https://www.github.com/googleapis/java-bigquerystorage/commit/fce52890c6948a9b78a62d2fe0e4f9768d10d401))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v1.127.10 ([#955](https://www.github.com/googleapis/java-bigquerystorage/issues/955)) ([c810c72](https://www.github.com/googleapis/java-bigquerystorage/commit/c810c7279bfbad31cb0f94f5ad5d4a74342d4481))
* update dependency com.google.cloud:google-cloud-bigquery to v1.127.9 ([#947](https://www.github.com/googleapis/java-bigquerystorage/issues/947)) ([d781dc5](https://www.github.com/googleapis/java-bigquerystorage/commit/d781dc5479602fee01eb971033978317e5669694))


### Documentation

* **samples:** Check for error from BatchCommitWriteStreams ([#940](https://www.github.com/googleapis/java-bigquerystorage/issues/940)) ([ab3c145](https://www.github.com/googleapis/java-bigquerystorage/commit/ab3c1453d3c1fb627e773d0e7ca4ec991f8d38b7))

### [1.15.1](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.15.0...v1.15.1) (2021-03-17)


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v1.127.8 ([#934](https://www.github.com/googleapis/java-bigquerystorage/issues/934)) ([626ae23](https://www.github.com/googleapis/java-bigquerystorage/commit/626ae2338a08aa9933badcd32d926cd51515e1e5))
* update dependency org.apache.avro:avro to v1.10.2 ([#942](https://www.github.com/googleapis/java-bigquerystorage/issues/942)) ([1554247](https://www.github.com/googleapis/java-bigquerystorage/commit/1554247cf55aa56281a530c721ab1650699a3efc))

## [1.15.0](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.14.0...v1.15.0) (2021-03-09)


### ⚠ BREAKING CHANGES

* remove deprecated append method in StreamWriterV2 (#924)

### Features

* remove deprecated append method in StreamWriterV2 ([#924](https://www.github.com/googleapis/java-bigquerystorage/issues/924)) ([f278775](https://www.github.com/googleapis/java-bigquerystorage/commit/f2787751bf03d91d1575ee6e007f407f91d97157))


### Bug Fixes

* Revive schema update e2e test and adjust some test names ([#921](https://www.github.com/googleapis/java-bigquerystorage/issues/921)) ([dd392e5](https://www.github.com/googleapis/java-bigquerystorage/commit/dd392e54953e0b75e780532a4dab2d143b8d8665))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.20.1 ([#931](https://www.github.com/googleapis/java-bigquerystorage/issues/931)) ([8c716c5](https://www.github.com/googleapis/java-bigquerystorage/commit/8c716c5d26420ef03f76a302c76892894045d4ad))

## [1.14.0](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.13.0...v1.14.0) (2021-03-04)


### Features

* update StreamWriterV2 to support trace id ([#895](https://www.github.com/googleapis/java-bigquerystorage/issues/895)) ([2e49ce8](https://www.github.com/googleapis/java-bigquerystorage/commit/2e49ce8c79cb059840c3307898ba16980f6892fa))


### Bug Fixes

* add schema update back to json writer ([#905](https://www.github.com/googleapis/java-bigquerystorage/issues/905)) ([a2adbf8](https://www.github.com/googleapis/java-bigquerystorage/commit/a2adbf80753161cbddd23d5a7db75e9250db58fa))
* Add unit test for concurrent issues we worried about, and fix some locking issues ([#854](https://www.github.com/googleapis/java-bigquerystorage/issues/854)) ([0870797](https://www.github.com/googleapis/java-bigquerystorage/commit/087079728195e20f93701e8d5e1e59ba29a7d21b))
* test failure testAppendWhileShutdownSuccess ([#904](https://www.github.com/googleapis/java-bigquerystorage/issues/904)) ([b80183e](https://www.github.com/googleapis/java-bigquerystorage/commit/b80183ea23c8b78611a42d22d8c62a4ba4904a80))
* testAppendWhileShutdownSuccess race ([#907](https://www.github.com/googleapis/java-bigquerystorage/issues/907)) ([d39443d](https://www.github.com/googleapis/java-bigquerystorage/commit/d39443d51d2625e4b3aee59d1e593229e9e449d3))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v1.127.6 ([#909](https://www.github.com/googleapis/java-bigquerystorage/issues/909)) ([505938b](https://www.github.com/googleapis/java-bigquerystorage/commit/505938bcba5a4a7af9e618572bbc41f365702f47))

## [1.13.0](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.12.0...v1.13.0) (2021-03-01)


### Features

* **generator:** update protoc to v3.15.3 ([#898](https://www.github.com/googleapis/java-bigquerystorage/issues/898)) ([2f277d6](https://www.github.com/googleapis/java-bigquerystorage/commit/2f277d650e8f617c6253843baf73d5d220713a61))
* in StreamWriterV2, supports new append, which takes rows and offset ([#894](https://www.github.com/googleapis/java-bigquerystorage/issues/894)) ([f3865b0](https://www.github.com/googleapis/java-bigquerystorage/commit/f3865b06ea7c61e95d3ee9bc7b46857d9d3080cc))
* StreamWriterV2 will handle schema/streamName attachment ([#877](https://www.github.com/googleapis/java-bigquerystorage/issues/877)) ([c54bcfe](https://www.github.com/googleapis/java-bigquerystorage/commit/c54bcfec1706eef58eaf9dad8b49dc79fc8da133))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v1.127.5 ([#896](https://www.github.com/googleapis/java-bigquerystorage/issues/896)) ([d211c76](https://www.github.com/googleapis/java-bigquerystorage/commit/d211c76dff747121d4560b55818c10bf595ef1c3))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.20.0 ([#892](https://www.github.com/googleapis/java-bigquerystorage/issues/892)) ([438f1c3](https://www.github.com/googleapis/java-bigquerystorage/commit/438f1c3b551e6b97a3241c69f2006a5a6be78c4f))

## [1.12.0](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.11.0...v1.12.0) (2021-02-25)


### Features

* StreamWriterV2 sets exception for response with error ([#884](https://www.github.com/googleapis/java-bigquerystorage/issues/884)) ([4677d7b](https://www.github.com/googleapis/java-bigquerystorage/commit/4677d7bd56db6c76106daeb7be38fa65f1c9c745))


### Documentation

* **sample:** Update parallel append sample to use StreamWriterV2 ([#883](https://www.github.com/googleapis/java-bigquerystorage/issues/883)) ([5c5c690](https://www.github.com/googleapis/java-bigquerystorage/commit/5c5c690fe39b3055596712dbd39064aed0b023da))

## [1.11.0](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.10.0...v1.11.0) (2021-02-24)


### Features

* Add max size check to StreamWriterV2 ([#873](https://www.github.com/googleapis/java-bigquerystorage/issues/873)) ([0261af4](https://www.github.com/googleapis/java-bigquerystorage/commit/0261af4e2dff5fd8515109c6336796815acb6c3c))
* Support building a BigQueryWriteClient within the StreamWriterV2 ([#876](https://www.github.com/googleapis/java-bigquerystorage/issues/876)) ([237c827](https://www.github.com/googleapis/java-bigquerystorage/commit/237c82711649672de1ce2e7382b909b74c0cd709))
* Support inflight control in StreamWriterV2 ([#875](https://www.github.com/googleapis/java-bigquerystorage/issues/875)) ([854c81e](https://www.github.com/googleapis/java-bigquerystorage/commit/854c81e20c3651295fd2dd5c9e87f48c67a9eeff))


### Documentation

* **samples:** add a new sample for parallel append ([#863](https://www.github.com/googleapis/java-bigquerystorage/issues/863)) ([ed1c265](https://www.github.com/googleapis/java-bigquerystorage/commit/ed1c26588ceb3e0d852fabefe8b3a89b8c74e6dd))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v1.127.4 ([#869](https://www.github.com/googleapis/java-bigquerystorage/issues/869)) ([de747ec](https://www.github.com/googleapis/java-bigquerystorage/commit/de747ec971f28919438b14c9f77ec7a2fa3a5628))

## [1.10.0](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.9.1...v1.10.0) (2021-02-23)


### Features

* Create Stream writer v2 - starting with core logics ([#867](https://www.github.com/googleapis/java-bigquerystorage/issues/867)) ([7c01f45](https://www.github.com/googleapis/java-bigquerystorage/commit/7c01f45ded1c516c23954b88103ca80b2132ecfc))


### Bug Fixes

* Remove flushAll method ([#850](https://www.github.com/googleapis/java-bigquerystorage/issues/850)) ([33a4502](https://www.github.com/googleapis/java-bigquerystorage/commit/33a450286b999c41459f92dd0177239f2a1b1f9a))
* temporally disable refreshAppend ([#853](https://www.github.com/googleapis/java-bigquerystorage/issues/853)) ([baf973d](https://www.github.com/googleapis/java-bigquerystorage/commit/baf973d84577cd490e275f6eebf91e25d5c34ccc))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v1.127.3 ([#861](https://www.github.com/googleapis/java-bigquerystorage/issues/861)) ([da95d18](https://www.github.com/googleapis/java-bigquerystorage/commit/da95d18a265950de437386870e5f1dba3be75743))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.19.0 ([#862](https://www.github.com/googleapis/java-bigquerystorage/issues/862)) ([4e390d7](https://www.github.com/googleapis/java-bigquerystorage/commit/4e390d7f5ca80ce87bfc0be3ce4ef4a33f9735ab))

### [1.9.1](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.9.0...v1.9.1) (2021-02-18)


### Bug Fixes

* remove reconnection feature from client library ([#849](https://www.github.com/googleapis/java-bigquerystorage/issues/849)) ([86dfc3a](https://www.github.com/googleapis/java-bigquerystorage/commit/86dfc3a1b1e3429a1e0932919a300a3bbbcb1ceb))

## [1.9.0](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.8.5...v1.9.0) (2021-02-17)


### Features

* generate sample code in the Java microgenerator ([#821](https://www.github.com/googleapis/java-bigquerystorage/issues/821)) ([3ab9a30](https://www.github.com/googleapis/java-bigquerystorage/commit/3ab9a309441a681e8adec88f8b8af1298a89cd74))


### Bug Fixes

* add dataflow trace id support ([#827](https://www.github.com/googleapis/java-bigquerystorage/issues/827)) ([8d22c58](https://www.github.com/googleapis/java-bigquerystorage/commit/8d22c586ed8a265558b84619297f5bd5b5ec4cb4))
* shutdown stuck when there is error on the flush path ([#831](https://www.github.com/googleapis/java-bigquerystorage/issues/831)) ([c2fd750](https://www.github.com/googleapis/java-bigquerystorage/commit/c2fd750e1309fb7b6eb862dea1ad8546dcd78bef))
* update repo name ([#818](https://www.github.com/googleapis/java-bigquerystorage/issues/818)) ([ba4b1a2](https://www.github.com/googleapis/java-bigquerystorage/commit/ba4b1a2d8eaa8f5408e476a3b570cb508aa94f57))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v1.127.0 ([#825](https://www.github.com/googleapis/java-bigquerystorage/issues/825)) ([36322fb](https://www.github.com/googleapis/java-bigquerystorage/commit/36322fb1f3d3d286cf8fc6b66f5aa1b97e754d72))
* update dependency com.google.cloud:google-cloud-bigquery to v1.127.1 ([#828](https://www.github.com/googleapis/java-bigquerystorage/issues/828)) ([c24a6ae](https://www.github.com/googleapis/java-bigquerystorage/commit/c24a6ae3d5a091b5276036d1d7f01e2777bbfd82))
* update dependency com.google.cloud:google-cloud-bigquery to v1.127.2 ([#830](https://www.github.com/googleapis/java-bigquerystorage/issues/830)) ([94c7848](https://www.github.com/googleapis/java-bigquerystorage/commit/94c78485baa383cd41ee7001206d5bc19f7746bf))
* update dependency junit:junit to v4.13.2 ([#829](https://www.github.com/googleapis/java-bigquerystorage/issues/829)) ([c2e429a](https://www.github.com/googleapis/java-bigquerystorage/commit/c2e429a591131cd2c89982c746f860a8fd0c7aef))

### [1.8.5](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.8.4...v1.8.5) (2021-01-17)


### Bug Fixes

* StreamWriter hang when we reach the inflight limit control and is doing a retry ([#799](https://www.github.com/googleapis/java-bigquerystorage/issues/799)) ([f8f9770](https://www.github.com/googleapis/java-bigquerystorage/commit/f8f97701e5ca698a170a1d3b6ecb3886e186f9d5))

### [1.8.4](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.8.3...v1.8.4) (2021-01-14)


### Bug Fixes

* default stream integration test failures due to production expected change ([#791](https://www.github.com/googleapis/java-bigquerystorage/issues/791)) ([1c2b5c1](https://www.github.com/googleapis/java-bigquerystorage/commit/1c2b5c1ef478305fe7f3d9f1843750cec18ba9f8))


### Documentation

* **samples:** jsonstreamwriter samples ([#756](https://www.github.com/googleapis/java-bigquerystorage/issues/756)) ([929b2ce](https://www.github.com/googleapis/java-bigquerystorage/commit/929b2cea1951bbe45eea596163f9a7a74d0ab041))


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v1.126.6 ([#794](https://www.github.com/googleapis/java-bigquerystorage/issues/794)) ([8e68546](https://www.github.com/googleapis/java-bigquerystorage/commit/8e68546f1e86553919766f9333ad911ba7da8442))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.18.0 ([#795](https://www.github.com/googleapis/java-bigquerystorage/issues/795)) ([86036bb](https://www.github.com/googleapis/java-bigquerystorage/commit/86036bb5caca125b38a64bd63acc5486a87b8e35))
* update protobuf ([#790](https://www.github.com/googleapis/java-bigquerystorage/issues/790)) ([792e925](https://www.github.com/googleapis/java-bigquerystorage/commit/792e925840e99033a1f194b2bfb372dae79d3d0d))

### [1.8.3](https://www.github.com/googleapis/java-bigquerystorage/compare/v1.8.2...v1.8.3) (2021-01-12)


### Dependencies

* update dependency com.google.cloud:google-cloud-bigquery to v1.126.4 ([#782](https://www.github.com/googleapis/java-bigquerystorage/issues/782)) ([ced40d0](https://www.github.com/googleapis/java-bigquerystorage/commit/ced40d09ed6f84ab86f83bec009b6d29f8d65358))

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
