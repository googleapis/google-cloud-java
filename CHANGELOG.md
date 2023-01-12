# Changelog

## [1.2.0](https://github.com/googleapis/google-cloud-java/compare/v1.1.0...v1.2.0) (2023-01-12)


### Features

* [aiplatform] add instance_config to BatchPredictionJob in aiplatform v1 batch_prediction_job.proto ([#8953](https://github.com/googleapis/google-cloud-java/issues/8953)) ([51e4b33](https://github.com/googleapis/google-cloud-java/commit/51e4b33514d09b64f5b5941779681ae31ec7dd51))
* [batch] add InstancePolicy.boot_disk ([4f5c3de](https://github.com/googleapis/google-cloud-java/commit/4f5c3de69e30fd711fa9f794681efa10e7982ad3))
* [bigquerydatatransfer] Add location methods ([#8945](https://github.com/googleapis/google-cloud-java/issues/8945)) ([5117e77](https://github.com/googleapis/google-cloud-java/commit/5117e77068711779c988e54f7a475cb67197a2e7))
* [cloudchannel] Add support for granular repricing configurations via SkuGroups in Cloud Channel Repricing APIs ([#8900](https://github.com/googleapis/google-cloud-java/issues/8900)) ([0d027d0](https://github.com/googleapis/google-cloud-java/commit/0d027d0fdd96a5371b1046b1ccb8831ae9e377f4))
* [cloudscheduler] Updated Client Libraries for Cloud Scheduler ([#8911](https://github.com/googleapis/google-cloud-java/issues/8911)) ([c432bdd](https://github.com/googleapis/google-cloud-java/commit/c432bddefa25394a085c7b0a36723b1500754636))
* [contactcenterinsights] add Configurable Analysis, Bulk Upload, Bulk Analyze, Delete Issue Apis ([#8910](https://github.com/googleapis/google-cloud-java/issues/8910)) ([765a8bf](https://github.com/googleapis/google-cloud-java/commit/765a8bf090936359da84a1d224bc06132fc47910))
* [container] add etags for cluster and node pool update operations ([#8930](https://github.com/googleapis/google-cloud-java/issues/8930)) ([bcd0111](https://github.com/googleapis/google-cloud-java/commit/bcd0111fe0f7fa1478a45fc695bb56f82c3fc2c4))
* [container] Add field for enabled Beta K8s APIs in proto ([#8960](https://github.com/googleapis/google-cloud-java/issues/8960)) ([d52e525](https://github.com/googleapis/google-cloud-java/commit/d52e5250e5c1f58eebae5042c6941030a99d2e2a))
* [container] Add support for specifying stack type for clusters. This will allow clusters to be created as dual stack or toggled between IPV4 and dual stack ([033567f](https://github.com/googleapis/google-cloud-java/commit/033567f1f61b29d339cc86b2c2f6892e77535029))
* [container] Add support for specifying stack type for clusters. This will allow clusters to be created as dual stack or toggled between IPV4 and dual stack ([#8917](https://github.com/googleapis/google-cloud-java/issues/8917)) ([033567f](https://github.com/googleapis/google-cloud-java/commit/033567f1f61b29d339cc86b2c2f6892e77535029))
* [container] add WindowsNodeConfig field to v1alpha1, v1beta1, v1 ([a4d2cf0](https://github.com/googleapis/google-cloud-java/commit/a4d2cf03fb7cc177c023765277fb4d816c715328))
* [container] Release GKE CloudDNS Cluster Scope ([#8928](https://github.com/googleapis/google-cloud-java/issues/8928)) ([a4d2cf0](https://github.com/googleapis/google-cloud-java/commit/a4d2cf03fb7cc177c023765277fb4d816c715328))
* [dataplex] DataScans service ([#8902](https://github.com/googleapis/google-cloud-java/issues/8902)) ([77e6526](https://github.com/googleapis/google-cloud-java/commit/77e652621668df7128f52aa949db1be1a9ed9e5c))
* [dataproc] added node groups API protos ([#8908](https://github.com/googleapis/google-cloud-java/issues/8908)) ([91aac16](https://github.com/googleapis/google-cloud-java/commit/91aac1604e156fabcbd501c2a3260bb87e3de2fd))
* [dialogflow-cx] ResponseMessage proto contains channel information ([#8978](https://github.com/googleapis/google-cloud-java/issues/8978)) ([55b45c1](https://github.com/googleapis/google-cloud-java/commit/55b45c1a88aa6df8413dab3c351feb6f39829524))
* [documentai] added sharding_config field in DocumentOutputConfig.GcsOutputConfig in document_io.proto ([ff2f100](https://github.com/googleapis/google-cloud-java/commit/ff2f100e4dc2a259b9d15a3122262feeeb0e12aa))
* [documentai] added sharding_config field in DocumentOutputConfig.GcsOutputConfig in document_io.proto ([ff2f100](https://github.com/googleapis/google-cloud-java/commit/ff2f100e4dc2a259b9d15a3122262feeeb0e12aa))
* [documentai] added sharding_config field in DocumentOutputConfig.GcsOutputConfig in document_io.proto ([ff2f100](https://github.com/googleapis/google-cloud-java/commit/ff2f100e4dc2a259b9d15a3122262feeeb0e12aa))
* [documentai] added sharding_config field in DocumentOutputConfig.GcsOutputConfig in document_io.proto ([#8909](https://github.com/googleapis/google-cloud-java/issues/8909)) ([ff2f100](https://github.com/googleapis/google-cloud-java/commit/ff2f100e4dc2a259b9d15a3122262feeeb0e12aa))
* [gke-multi-cloud] Support AttachedClusters ([#8924](https://github.com/googleapis/google-cloud-java/issues/8924)) ([b7f1f6d](https://github.com/googleapis/google-cloud-java/commit/b7f1f6d5640c5dc3a23fc1399d668bf07e4396a7))
* [metastore] added RemoveIamPolicy API ([#8922](https://github.com/googleapis/google-cloud-java/issues/8922)) ([84d9aa0](https://github.com/googleapis/google-cloud-java/commit/84d9aa0a2d1df3af904129c93c2af13bebc501be))
* [monitoring-dashboards] added support for horizontal bar rendering and column settings on time series tables ([#8975](https://github.com/googleapis/google-cloud-java/issues/8975)) ([cecd944](https://github.com/googleapis/google-cloud-java/commit/cecd9446fdea65ba132323488aa2fa85821519d3))
* [retail] support async write mode for WriteUserEvent API ([580a683](https://github.com/googleapis/google-cloud-java/commit/580a6839a9b8a30d121a593134d448f1a293b3c0))
* [retail] support async write mode for WriteUserEvent API ([580a683](https://github.com/googleapis/google-cloud-java/commit/580a6839a9b8a30d121a593134d448f1a293b3c0))
* [retail] support async write mode for WriteUserEvent API ([#8918](https://github.com/googleapis/google-cloud-java/issues/8918)) ([580a683](https://github.com/googleapis/google-cloud-java/commit/580a6839a9b8a30d121a593134d448f1a293b3c0))
* [secretmanager] update public API to include annotation support ([#8921](https://github.com/googleapis/google-cloud-java/issues/8921)) ([262aeee](https://github.com/googleapis/google-cloud-java/commit/262aeee09e7dd0760f1b652564ae1231debf2e50))
* [securitycenter] add user_name field to the finding access ([#8913](https://github.com/googleapis/google-cloud-java/issues/8913)) ([a8a49a7](https://github.com/googleapis/google-cloud-java/commit/a8a49a784ad4d6876cb4e5430abd259cebb0073b))
* add EphemeralStorageLocalSsdConfig and LocalNvmeSsdBlockConfig APIs to v1alpha1, v1beta1, v1 ([a4d2cf0](https://github.com/googleapis/google-cloud-java/commit/a4d2cf03fb7cc177c023765277fb4d816c715328))
* add EphemeralStorageLocalSsdConfig and LocalNvmeSsdBlockConfig APIs to v1alpha1, v1beta1, v1 ([a4d2cf0](https://github.com/googleapis/google-cloud-java/commit/a4d2cf03fb7cc177c023765277fb4d816c715328))
* added AlterMetadataResourceLocation API ([84d9aa0](https://github.com/googleapis/google-cloud-java/commit/84d9aa0a2d1df3af904129c93c2af13bebc501be))
* added MoveTableToDatabase API ([84d9aa0](https://github.com/googleapis/google-cloud-java/commit/84d9aa0a2d1df3af904129c93c2af13bebc501be))
* added process_options field in ProcessRequest in document_processor_service.proto ([ff2f100](https://github.com/googleapis/google-cloud-java/commit/ff2f100e4dc2a259b9d15a3122262feeeb0e12aa))
* added process_options field in ProcessRequest in document_processor_service.proto ([ff2f100](https://github.com/googleapis/google-cloud-java/commit/ff2f100e4dc2a259b9d15a3122262feeeb0e12aa))
* added QueryMetadata API ([84d9aa0](https://github.com/googleapis/google-cloud-java/commit/84d9aa0a2d1df3af904129c93c2af13bebc501be))
* added sample_document_uris field in ProcessorType in processor_type.proto ([ff2f100](https://github.com/googleapis/google-cloud-java/commit/ff2f100e4dc2a259b9d15a3122262feeeb0e12aa))
* added sample_document_uris field in ProcessorType in processor_type.proto ([ff2f100](https://github.com/googleapis/google-cloud-java/commit/ff2f100e4dc2a259b9d15a3122262feeeb0e12aa))
* added StorageFormat.iceberg ([77e6526](https://github.com/googleapis/google-cloud-java/commit/77e652621668df7128f52aa949db1be1a9ed9e5c))
* allow set feed id in merchant center link ([580a683](https://github.com/googleapis/google-cloud-java/commit/580a6839a9b8a30d121a593134d448f1a293b3c0))
* allow set feed id in merchant center link ([580a683](https://github.com/googleapis/google-cloud-java/commit/580a6839a9b8a30d121a593134d448f1a293b3c0))
* deprecate retrievable_fields in product attribute ([580a683](https://github.com/googleapis/google-cloud-java/commit/580a6839a9b8a30d121a593134d448f1a293b3c0))
* deprecate retrievable_fields in product attribute ([580a683](https://github.com/googleapis/google-cloud-java/commit/580a6839a9b8a30d121a593134d448f1a293b3c0))
* deprecate retrievable_fields in product attribute ([580a683](https://github.com/googleapis/google-cloud-java/commit/580a6839a9b8a30d121a593134d448f1a293b3c0))
* expose the local inventory data in product data retrieval ([580a683](https://github.com/googleapis/google-cloud-java/commit/580a6839a9b8a30d121a593134d448f1a293b3c0))
* return personal product labels in search response ([580a683](https://github.com/googleapis/google-cloud-java/commit/580a6839a9b8a30d121a593134d448f1a293b3c0))
* support attribute suggestion in autocomplete ([580a683](https://github.com/googleapis/google-cloud-java/commit/580a6839a9b8a30d121a593134d448f1a293b3c0))
* support batch remove catalog attribute config ([580a683](https://github.com/googleapis/google-cloud-java/commit/580a6839a9b8a30d121a593134d448f1a293b3c0))
* support collect and import GA4 event format with prebuilt whistle rule ([580a683](https://github.com/googleapis/google-cloud-java/commit/580a6839a9b8a30d121a593134d448f1a293b3c0))
* support collect and import GA4 event format with prebuilt whistle rule ([580a683](https://github.com/googleapis/google-cloud-java/commit/580a6839a9b8a30d121a593134d448f1a293b3c0))
* support collect GA4 event format with prebuilt whistle rule ([580a683](https://github.com/googleapis/google-cloud-java/commit/580a6839a9b8a30d121a593134d448f1a293b3c0))
* support data output to GCS ([580a683](https://github.com/googleapis/google-cloud-java/commit/580a6839a9b8a30d121a593134d448f1a293b3c0))
* support data output to GCS ([580a683](https://github.com/googleapis/google-cloud-java/commit/580a6839a9b8a30d121a593134d448f1a293b3c0))
* support diversity type in serving config ([580a683](https://github.com/googleapis/google-cloud-java/commit/580a6839a9b8a30d121a593134d448f1a293b3c0))
* support diversity type in serving config ([580a683](https://github.com/googleapis/google-cloud-java/commit/580a6839a9b8a30d121a593134d448f1a293b3c0))
* support diversity type in serving config ([580a683](https://github.com/googleapis/google-cloud-java/commit/580a6839a9b8a30d121a593134d448f1a293b3c0))
* support exact searchable and retrievable in catalog attribute config ([580a683](https://github.com/googleapis/google-cloud-java/commit/580a6839a9b8a30d121a593134d448f1a293b3c0))
* support exact searchable and retrievable in catalog attribute config ([580a683](https://github.com/googleapis/google-cloud-java/commit/580a6839a9b8a30d121a593134d448f1a293b3c0))
* support exact searchable and retrievable in catalog attribute config ([580a683](https://github.com/googleapis/google-cloud-java/commit/580a6839a9b8a30d121a593134d448f1a293b3c0))


### Bug Fixes

* **deps:** update dependency com.google.cloud:google-cloud-pubsub-bom to v1.122.2 ([#8919](https://github.com/googleapis/google-cloud-java/issues/8919)) ([e689a26](https://github.com/googleapis/google-cloud-java/commit/e689a2686c6a67f78bd1c3c4de3583b7832d3581))
* **deps:** update dependency com.google.cloud:google-cloud-pubsub-bom to v1.123.0 ([#8963](https://github.com/googleapis/google-cloud-java/issues/8963)) ([6f76db4](https://github.com/googleapis/google-cloud-java/commit/6f76db42165ae33e707e4eaa2510fac8c8381055))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.1.1 ([#8959](https://github.com/googleapis/google-cloud-java/issues/8959)) ([2d5d4fa](https://github.com/googleapis/google-cloud-java/commit/2d5d4fadb4529bde8b5b3f535423fc203d4f91fe))
* remove unsupported HTTP bindings for IAMPolicy RPCs ([4f5c3de](https://github.com/googleapis/google-cloud-java/commit/4f5c3de69e30fd711fa9f794681efa10e7982ad3))
* removed unused endpoints for IAM methods ([4f5c3de](https://github.com/googleapis/google-cloud-java/commit/4f5c3de69e30fd711fa9f794681efa10e7982ad3))
* ServiceAccount.scopes is no longer deprecated ([4f5c3de](https://github.com/googleapis/google-cloud-java/commit/4f5c3de69e30fd711fa9f794681efa10e7982ad3))


### Documentation

* [batch] updated documentation for message NetworkInterface ([4f5c3de](https://github.com/googleapis/google-cloud-java/commit/4f5c3de69e30fd711fa9f794681efa10e7982ad3))
* [batch] updated documentation for message NetworkInterface ([#8915](https://github.com/googleapis/google-cloud-java/issues/8915)) ([4f5c3de](https://github.com/googleapis/google-cloud-java/commit/4f5c3de69e30fd711fa9f794681efa10e7982ad3))
* [dataplex] fix minor docstring formatting ([77e6526](https://github.com/googleapis/google-cloud-java/commit/77e652621668df7128f52aa949db1be1a9ed9e5c))
* [java-maps-routing] updated comment for ComputeRoutesRequest and ComputeRouteMatrixRequest ([#8912](https://github.com/googleapis/google-cloud-java/issues/8912)) ([1591535](https://github.com/googleapis/google-cloud-java/commit/15915353520fc532cf1702feed9643c8ac045d29))
* [java-maps-routing] updated comment for Route.route_token ([1591535](https://github.com/googleapis/google-cloud-java/commit/15915353520fc532cf1702feed9643c8ac045d29))
* [java-vmwareengine] update location in docstrings to use `us-central1` ([#8962](https://github.com/googleapis/google-cloud-java/issues/8962)) ([a6ed63d](https://github.com/googleapis/google-cloud-java/commit/a6ed63d89e350a064a93568a04bf7e1691b40130))
* [texttospeech] fix minor docstring formatting ([#8914](https://github.com/googleapis/google-cloud-java/issues/8914)) ([ed0f974](https://github.com/googleapis/google-cloud-java/commit/ed0f974bb0fd3390b7fc4a1a15d4eb3574042c63))
* [tpu] fix minor docstring formatting ([#8920](https://github.com/googleapis/google-cloud-java/issues/8920)) ([1ed54ab](https://github.com/googleapis/google-cloud-java/commit/1ed54abe36f274d60d81c4c829dadc8aece72950))
* keep the API doc up-to-date with recent changes ([580a683](https://github.com/googleapis/google-cloud-java/commit/580a6839a9b8a30d121a593134d448f1a293b3c0))
* keep the API doc up-to-date with recent changes ([580a683](https://github.com/googleapis/google-cloud-java/commit/580a6839a9b8a30d121a593134d448f1a293b3c0))
* keep the API doc up-to-date with recent changes ([580a683](https://github.com/googleapis/google-cloud-java/commit/580a6839a9b8a30d121a593134d448f1a293b3c0))
* updated comment for RouteTravelMode ([1591535](https://github.com/googleapis/google-cloud-java/commit/15915353520fc532cf1702feed9643c8ac045d29))

## [1.1.0](https://github.com/googleapis/google-cloud-java/compare/v1.0.0...v1.1.0) (2022-12-09)


### ⚠ BREAKING CHANGES

* fix incorrect resource annotations for TPU v2alpha1 API

### Features

* [accesscontextmanager] added AccessPolicy.scopes, EgressTo.external_resources, and IAM methods ([#8749](https://github.com/googleapis/google-cloud-java/issues/8749)) ([8cea32a](https://github.com/googleapis/google-cloud-java/commit/8cea32a6c1c390314d8adb674818bb70692cfde5))
* [addressvalidation] new module for addressvalidation ([#8850](https://github.com/googleapis/google-cloud-java/issues/8850)) ([bde6af5](https://github.com/googleapis/google-cloud-java/commit/bde6af566824013ccbd42f537e619cc0ec46d6a0))
* [aiplatform] add SearchDataItems RPC in aiplatform version v1 and v1beta1 dataset_service.proto ([#8859](https://github.com/googleapis/google-cloud-java/issues/8859)) ([b68a7c1](https://github.com/googleapis/google-cloud-java/commit/b68a7c19a20927530e90cb829fedbc54bd3d6cf8))
* [aiplatform] add service_account to batch_prediction_job in aiplatform v1 batch_prediction_job.proto ([#8780](https://github.com/googleapis/google-cloud-java/issues/8780)) ([7304a6b](https://github.com/googleapis/google-cloud-java/commit/7304a6b6cada0a0f6257405b390f2d512ec35fe0))
* [aiplatform] add service_account to UploadModelRequest in aiplatform v1beta1 model_service.proto ([#8895](https://github.com/googleapis/google-cloud-java/issues/8895)) ([d7d94be](https://github.com/googleapis/google-cloud-java/commit/d7d94be78efa64df7e626132e43da56d8ca198e8))
* [batch] Adds named reservation to InstancePolicy ([aaaa624](https://github.com/googleapis/google-cloud-java/commit/aaaa62406bed418c0f7ca709912aafcd4f086399))
* [batch] Adds named reservation to InstancePolicy ([#8822](https://github.com/googleapis/google-cloud-java/issues/8822)) ([aaaa624](https://github.com/googleapis/google-cloud-java/commit/aaaa62406bed418c0f7ca709912aafcd4f086399))
* [bigquerydatatransfer] added Location API methods ([#8805](https://github.com/googleapis/google-cloud-java/issues/8805)) ([862afab](https://github.com/googleapis/google-cloud-java/commit/862afabbbea7c5920ac8dfeeaad59b508adb4a9c))
* [cloudbilling] added Sku.geo_taxonomy ([#8787](https://github.com/googleapis/google-cloud-java/issues/8787)) ([c9b8282](https://github.com/googleapis/google-cloud-java/commit/c9b8282b83723d75e673915e2dc25e9e7ed0b7ea))
* [cloudkms] add SHA-2 import methods ([#8835](https://github.com/googleapis/google-cloud-java/issues/8835)) ([a70dbea](https://github.com/googleapis/google-cloud-java/commit/a70dbea4caf1cb9a2e16fc132eee6c180af01723))
* [cloudkms] add support for additional HMAC algorithms ([#8792](https://github.com/googleapis/google-cloud-java/issues/8792)) ([ba8a75f](https://github.com/googleapis/google-cloud-java/commit/ba8a75f2edf4e6c1ee0fcefb4cc4acf171a290ab))
* [cloudshell] add CloudShellErrorCode.ENVIRONMENT_UNAVAILABLE enum value ([#8806](https://github.com/googleapis/google-cloud-java/issues/8806)) ([2003d7f](https://github.com/googleapis/google-cloud-java/commit/2003d7f2864f9be7442860c85149644a23b07188))
* [compute] Update Compute Engine API to revision 20221101 ([#751](https://github.com/googleapis/google-cloud-java/issues/751)) ([#8825](https://github.com/googleapis/google-cloud-java/issues/8825)) ([0683411](https://github.com/googleapis/google-cloud-java/commit/0683411d49cb90dc1039126593c06e9550d076e8))
* [compute] Update Compute Engine API to revision 20221126 ([#757](https://github.com/googleapis/google-cloud-java/issues/757)) ([#8885](https://github.com/googleapis/google-cloud-java/issues/8885)) ([fd71883](https://github.com/googleapis/google-cloud-java/commit/fd7188353fd5a476ef74ebcba1dde4c64563fd1a))
* [container] add a FastSocket API ([#8842](https://github.com/googleapis/google-cloud-java/issues/8842)) ([3a6094c](https://github.com/googleapis/google-cloud-java/commit/3a6094c402f8ed7d26266e6f5164aa49bd51526b))
* [container] add a FastSocket API ([#8845](https://github.com/googleapis/google-cloud-java/issues/8845)) ([184ae92](https://github.com/googleapis/google-cloud-java/commit/184ae9270b9ecd4d5af4bff19675f558d6141e82))
* [container] add compact placement feature for node pools ([#8786](https://github.com/googleapis/google-cloud-java/issues/8786)) ([d50169d](https://github.com/googleapis/google-cloud-java/commit/d50169ddac281e7c3c38424db996ab5e41ce0927))
* [dialogflow] added cx_current_page field to AutomatedAgentReply ([#8820](https://github.com/googleapis/google-cloud-java/issues/8820)) ([f7d5c7f](https://github.com/googleapis/google-cloud-java/commit/f7d5c7f51f53057347db6cd7d861845c2ba34d27))
* [dialogflow] added cx_current_page field to AutomatedAgentReply ([#8830](https://github.com/googleapis/google-cloud-java/issues/8830)) ([7b7faf3](https://github.com/googleapis/google-cloud-java/commit/7b7faf395cee2c6256dbaa4e43812da4bc13bb38))
* [dlp] ExcludeByHotword added as an ExclusionRule type, NEW_ZEALAND added as a LocationCategory value ([#8766](https://github.com/googleapis/google-cloud-java/issues/8766)) ([ff64c8e](https://github.com/googleapis/google-cloud-java/commit/ff64c8e5a2f8d1dfccb14c55f76275af14bf9a66))
* [documentai] added field_mask field in DocumentOutputConfig.GcsOutputConfig in document_io.proto ([#8781](https://github.com/googleapis/google-cloud-java/issues/8781)) ([85717c2](https://github.com/googleapis/google-cloud-java/commit/85717c2e9e4bf61040fbe62af6192222b2584691))
* [eventarc] Add CMEK support to Eventarc client library ([#8731](https://github.com/googleapis/google-cloud-java/issues/8731)) ([7e32e27](https://github.com/googleapis/google-cloud-java/commit/7e32e278c2fae7b07a9040e74afaf3cf7417642e))
* [file] add polling timeouts config for RevertInstance operation ([#8826](https://github.com/googleapis/google-cloud-java/issues/8826)) ([d07adff](https://github.com/googleapis/google-cloud-java/commit/d07adff871d937518bcf5252e606ff81e8c86bf3))
* [file] new APIs added to reflect updates to the filestore service ([#8762](https://github.com/googleapis/google-cloud-java/issues/8762)) ([16cf573](https://github.com/googleapis/google-cloud-java/commit/16cf5734289507cee2bfb8f3ed17be94f8eb39dc))
* [lifesciences] add Pipeline.secret_environment, Action.secret_environment, VirtualMachine.reservation ([#8782](https://github.com/googleapis/google-cloud-java/issues/8782)) ([7aaef3c](https://github.com/googleapis/google-cloud-java/commit/7aaef3c75ef667b061c8b108282eb6264a0b4ad4))
* [maps-routing] new module for maps-routing ([#8811](https://github.com/googleapis/google-cloud-java/issues/8811)) ([2bf8d50](https://github.com/googleapis/google-cloud-java/commit/2bf8d508df55a3300a369bb76fd2625871967078))
* [memcache] maintenance schedules ([#8803](https://github.com/googleapis/google-cloud-java/issues/8803)) ([a3ea65a](https://github.com/googleapis/google-cloud-java/commit/a3ea65a369e648ee551535815fdafc755768bff9))
* [metastore] added federation API ([#8840](https://github.com/googleapis/google-cloud-java/issues/8840)) ([998d5f3](https://github.com/googleapis/google-cloud-java/commit/998d5f3c7d0d2daa421f1786f7f78ab7d30dae59))
* [monitoring-metricsscope] new module for monitoring-metricsscope ([#8875](https://github.com/googleapis/google-cloud-java/issues/8875)) ([3437b1c](https://github.com/googleapis/google-cloud-java/commit/3437b1cee0aab0be09cd1ecf55e9d04f8ddd4e81))
* [notebooks] added UpdateRuntime, UpgradeRuntime, DiagnoseRuntime, DiagnoseInstance to v1 API ([#8804](https://github.com/googleapis/google-cloud-java/issues/8804)) ([fd86bad](https://github.com/googleapis/google-cloud-java/commit/fd86bade171bda8f7d2461cf6a67bd23425fb40e))
* [oslogin] added CreateSshPublicKey RPC ([#8783](https://github.com/googleapis/google-cloud-java/issues/8783)) ([de74b58](https://github.com/googleapis/google-cloud-java/commit/de74b58947381d9df7ba7078606b92f9f9541007))
* [recaptchaenterprise] add account_verification field to Assessment for MFA ([#8888](https://github.com/googleapis/google-cloud-java/issues/8888)) ([604a32e](https://github.com/googleapis/google-cloud-java/commit/604a32e481dc0f1cbfe8522798ad83bf625189c8))
* [securitycenter] Add files field to finding's list of attributes ([#8773](https://github.com/googleapis/google-cloud-java/issues/8773)) ([d8e47d3](https://github.com/googleapis/google-cloud-java/commit/d8e47d301c82ef7b98c9a9a39d606512542becb2))
* [securitycenter] add kernel_rootkit field to finding's list of attributes ([#8878](https://github.com/googleapis/google-cloud-java/issues/8878)) ([0d6e1cc](https://github.com/googleapis/google-cloud-java/commit/0d6e1cc0c1b742544ec3ee82069f3ead3e4c1620))
* [speech] Added new fields to facilitate debugging ([#8867](https://github.com/googleapis/google-cloud-java/issues/8867)) ([e0b7a86](https://github.com/googleapis/google-cloud-java/commit/e0b7a8602db56ca3dd33c42be7fc141da4bfa818))
* [texttospeech] add LRS API ([#8881](https://github.com/googleapis/google-cloud-java/issues/8881)) ([a1d5df0](https://github.com/googleapis/google-cloud-java/commit/a1d5df0523c80e086714a54a0fe117fa888fe7e5))
* [texttospeech] add LRS API ([#8887](https://github.com/googleapis/google-cloud-java/issues/8887)) ([d68e8e0](https://github.com/googleapis/google-cloud-java/commit/d68e8e0d2a2f35463cccabd5835404f6f22b1ea5))
* [tpu] publishing TPU v2 API ([#8851](https://github.com/googleapis/google-cloud-java/issues/8851)) ([21fe669](https://github.com/googleapis/google-cloud-java/commit/21fe6697a41873fb4d51c68e2670429797f4f8f3))
* [transcoder] add PreprocessingConfig.deinterlace ([#8812](https://github.com/googleapis/google-cloud-java/issues/8812)) ([9e9cf68](https://github.com/googleapis/google-cloud-java/commit/9e9cf68063d690cfd568d7c0f0465cee84648868))
* [vmwareengine] new module for vmwareengine ([#8837](https://github.com/googleapis/google-cloud-java/issues/8837)) ([d61b54a](https://github.com/googleapis/google-cloud-java/commit/d61b54a212a592c9884b3886c0fea8b4b65c65fb))
* added DatabaseType field ([998d5f3](https://github.com/googleapis/google-cloud-java/commit/998d5f3c7d0d2daa421f1786f7f78ab7d30dae59))
* added EncryptionConfig field ([998d5f3](https://github.com/googleapis/google-cloud-java/commit/998d5f3c7d0d2daa421f1786f7f78ab7d30dae59))
* added NetworkConfig field ([998d5f3](https://github.com/googleapis/google-cloud-java/commit/998d5f3c7d0d2daa421f1786f7f78ab7d30dae59))
* added TelemetryConfiguration field ([998d5f3](https://github.com/googleapis/google-cloud-java/commit/998d5f3c7d0d2daa421f1786f7f78ab7d30dae59))


### Bug Fixes

* **deps:** update dependency com.google.apis:google-api-services-dns to v1-rev20221110-2.0.0 ([#8789](https://github.com/googleapis/google-cloud-java/issues/8789)) ([d3cd2c9](https://github.com/googleapis/google-cloud-java/commit/d3cd2c9d907e62ebc1c600480269b4592fb1b99d))
* **deps:** update dependency com.google.cloud:google-cloud-pubsub-bom to v1.121.0 ([#8815](https://github.com/googleapis/google-cloud-java/issues/8815)) ([aa1a33d](https://github.com/googleapis/google-cloud-java/commit/aa1a33d0a05248198e036d4e1f2de42e3ffe75bc))
* **deps:** update dependency com.google.cloud:google-cloud-pubsub-bom to v1.121.1 ([#8829](https://github.com/googleapis/google-cloud-java/issues/8829)) ([70697ce](https://github.com/googleapis/google-cloud-java/commit/70697ce1056fedf31f09ed38d9a528e8d632dc77))
* **deps:** update dependency com.google.cloud:google-cloud-pubsub-bom to v1.122.1 ([#8869](https://github.com/googleapis/google-cloud-java/issues/8869)) ([699ff89](https://github.com/googleapis/google-cloud-java/commit/699ff897916e8accabefc37bf36789efdc3af918))
* **deps:** update dependency com.google.cloud:google-cloud-shared-config to v1.5.5 ([#8861](https://github.com/googleapis/google-cloud-java/issues/8861)) ([515a3ac](https://github.com/googleapis/google-cloud-java/commit/515a3ac03c3a5057520236ecd999b9eb15209668))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.1.0 ([#8876](https://github.com/googleapis/google-cloud-java/issues/8876)) ([b79a23f](https://github.com/googleapis/google-cloud-java/commit/b79a23f38e933fb0c3a54127bbc362fae3ee145a))
* **deps:** update dependency com.google.cloud:google-cloud-storage to v2.15.1 ([#8816](https://github.com/googleapis/google-cloud-java/issues/8816)) ([8bd4b93](https://github.com/googleapis/google-cloud-java/commit/8bd4b93f0702f9df8723441ee586052cdb32c8eb))
* **deps:** update dependency com.google.cloud:google-cloud-storage to v2.16.0 ([#8886](https://github.com/googleapis/google-cloud-java/issues/8886)) ([46ff49d](https://github.com/googleapis/google-cloud-java/commit/46ff49d88473a618727be0ffd38d001b78fadc86))
* fix incorrect resource annotations for TPU v2alpha1 API ([21fe669](https://github.com/googleapis/google-cloud-java/commit/21fe6697a41873fb4d51c68e2670429797f4f8f3))
* **github:** remove 'Terraform Integration' requirement to prepare for only single 'Integration' required stage. ([#8810](https://github.com/googleapis/google-cloud-java/issues/8810)) ([df64317](https://github.com/googleapis/google-cloud-java/commit/df6431799365d83789f770ff2f9103892c7cf376))
* rename addressvalidation module to maps-addressvalidation ([#8880](https://github.com/googleapis/google-cloud-java/issues/8880)) ([0020df6](https://github.com/googleapis/google-cloud-java/commit/0020df607fb59292fb20ae13cb0257ab4c3a30c9))


### Dependencies

* Updating gapic-bom, jar & pom-parent versions. ([#8827](https://github.com/googleapis/google-cloud-java/issues/8827)) ([4e77219](https://github.com/googleapis/google-cloud-java/commit/4e77219472f16610db44c0cf8747e2c9171aca18))


### Documentation

* [batch] fix minor docstring formatting ([#8828](https://github.com/googleapis/google-cloud-java/issues/8828)) ([6789235](https://github.com/googleapis/google-cloud-java/commit/67892355444d8935eede0711398ebb64020cc88c))
* [bigquerydatapolicy] fix minor docstring formatting ([#8860](https://github.com/googleapis/google-cloud-java/issues/8860)) ([933f260](https://github.com/googleapis/google-cloud-java/commit/933f26070dd0ec685bd3e6284f5f4c954ca2023c))
* [cloudasset] Small change for documentation ([#8831](https://github.com/googleapis/google-cloud-java/issues/8831)) ([2ab9395](https://github.com/googleapis/google-cloud-java/commit/2ab9395bb6e69b086072eb8589acd063ff768f2c))
* [cloudasset] Small change for documentation ([#8838](https://github.com/googleapis/google-cloud-java/issues/8838)) ([3642eff](https://github.com/googleapis/google-cloud-java/commit/3642eff3ab0bb9bbdcaf9b27885a8f5ccc8b5a21))
* [dialogflow-cx] Clarified Agent Assist max retention is 30 days ([#8813](https://github.com/googleapis/google-cloud-java/issues/8813)) ([3ae47ae](https://github.com/googleapis/google-cloud-java/commit/3ae47ae323b455c30da4f909ea913c1633bebc97))
* [dialogflow-cx] Clarified Agent Assist max retention is 30 days ([#8821](https://github.com/googleapis/google-cloud-java/issues/8821)) ([ebe3f8a](https://github.com/googleapis/google-cloud-java/commit/ebe3f8a230d66c2fe8effb14e5c07001ecc6b0fd))
* [java-maps-addressvalidation] Document that PREMISE_PROXIMITY is a valid value for an address granularity ([#8883](https://github.com/googleapis/google-cloud-java/issues/8883)) ([1169d9e](https://github.com/googleapis/google-cloud-java/commit/1169d9e998b37f3e3130ba81241370bfff812b9b))
* [Many APIs] fix minor docstring formatting ([#8798](https://github.com/googleapis/google-cloud-java/issues/8798)) ([5360184](https://github.com/googleapis/google-cloud-java/commit/53601847ef2c9e258fbb8cc8011ec97e3f580fbc))
* [notebooks] fix minor docstring formatting ([#8846](https://github.com/googleapis/google-cloud-java/issues/8846)) ([2b48de2](https://github.com/googleapis/google-cloud-java/commit/2b48de2ce1c3f8776c4ace587866d431dd5d1d02))
* [translate] fix minor docstring formatting ([#8884](https://github.com/googleapis/google-cloud-java/issues/8884)) ([29d1889](https://github.com/googleapis/google-cloud-java/commit/29d1889efd05ad21eac234e23655b716fd3637a2))
* clarified docs for Sentiment ([7b7faf3](https://github.com/googleapis/google-cloud-java/commit/7b7faf395cee2c6256dbaa4e43812da4bc13bb38))
* clarified docs for Sentiment ([f7d5c7f](https://github.com/googleapis/google-cloud-java/commit/f7d5c7f51f53057347db6cd7d861845c2ba34d27))
* correct min required Java version 7 -&gt; 8 ([#8872](https://github.com/googleapis/google-cloud-java/issues/8872)) ([6ae35d9](https://github.com/googleapis/google-cloud-java/commit/6ae35d943aa49c5a0836c79c5756344b11fcb02a))
* library generation example of Geo ([#8745](https://github.com/googleapis/google-cloud-java/issues/8745)) ([dab41cb](https://github.com/googleapis/google-cloud-java/commit/dab41cbea02f20af1516d63ee86a1d4050a3be89))
* minor updates in comments ([21fe669](https://github.com/googleapis/google-cloud-java/commit/21fe6697a41873fb4d51c68e2670429797f4f8f3))
* update the job id format requirement ([aaaa624](https://github.com/googleapis/google-cloud-java/commit/aaaa62406bed418c0f7ca709912aafcd4f086399))
* update the job id format requirement ([aaaa624](https://github.com/googleapis/google-cloud-java/commit/aaaa62406bed418c0f7ca709912aafcd4f086399))

## [0.201.0](https://github.com/googleapis/google-cloud-java/compare/v0.200.0...v0.201.0) (2022-11-15)


### Features

* [aiplatform] add annotation_labels to ImportDataConfig in aiplatform v1 dataset.proto ([#8725](https://github.com/googleapis/google-cloud-java/issues/8725)) ([57025df](https://github.com/googleapis/google-cloud-java/commit/57025df108263c3a9ec30d8cc696ddda4892384d))
* [aiplatform] add instance_config to batch_prediction_job in aiplatform v1beta1 batch_prediction_job.proto ([#8759](https://github.com/googleapis/google-cloud-java/issues/8759)) ([fd8bfdd](https://github.com/googleapis/google-cloud-java/commit/fd8bfdd721ddcd68e77765cbd90ff3dae5fb0676))
* [cloudbuild] Add allow_failure, exit_code, and allow_exit_code to BuildStep message ([#8694](https://github.com/googleapis/google-cloud-java/issues/8694)) ([334b050](https://github.com/googleapis/google-cloud-java/commit/334b050defd55291c22b023ea8269b9f0db439f9))
* [cloudbuild] Integration of Cloud Build with Artifact Registry ([#8702](https://github.com/googleapis/google-cloud-java/issues/8702)) ([f2b15e1](https://github.com/googleapis/google-cloud-java/commit/f2b15e12fa9b94d6216a9f875c9379f49c502cb5))
* [cloudchannel] add deal_code field to message Offer ([#8760](https://github.com/googleapis/google-cloud-java/issues/8760)) ([6a84b71](https://github.com/googleapis/google-cloud-java/commit/6a84b714172a48bd4e85c0e462cb107a31d64305))
* [container] add APIs for GKE Control Plane Logs ([#8728](https://github.com/googleapis/google-cloud-java/issues/8728)) ([ba1a887](https://github.com/googleapis/google-cloud-java/commit/ba1a887469ddd5c18ae877c4315c9116ff3cd91d))
* [dialogflow] Added StreamingAnalyzeContent API ([#8684](https://github.com/googleapis/google-cloud-java/issues/8684)) ([97a0958](https://github.com/googleapis/google-cloud-java/commit/97a095884b05d093ff52feadb8cf9cc0a7a9e3cb))
* [documentai] added font_family to document.proto ([#8744](https://github.com/googleapis/google-cloud-java/issues/8744)) ([5f9858d](https://github.com/googleapis/google-cloud-java/commit/5f9858dc74a8dfb4cabecee37f60d139cef209df))
* [eventarcpublishing] Introduce the event publishing using JSON representation of CloudEvents ([#8730](https://github.com/googleapis/google-cloud-java/issues/8730)) ([ae2f0fe](https://github.com/googleapis/google-cloud-java/commit/ae2f0fea9c32db279c4f4121b394d13c75924bfd))
* [java-discoveryengine] allow recommendation users to set user labels in the request ([#8689](https://github.com/googleapis/google-cloud-java/issues/8689)) ([1b54799](https://github.com/googleapis/google-cloud-java/commit/1b547998dba6289ac4bb8af2ac6f8a1285845dbf))
* [java-enterpriseknowledgegraph] add PHP, Ruby, C# library rules for the Cloud EKG API ([#8697](https://github.com/googleapis/google-cloud-java/issues/8697)) ([9503270](https://github.com/googleapis/google-cloud-java/commit/9503270fcef3113c0b8aeb06b826260958f03e28))
* [java-enterpriseknowledgegraph] publish Google Cloud's Cloud Knowledge Graph (CKG) API ([#8758](https://github.com/googleapis/google-cloud-java/issues/8758)) ([9e4ace2](https://github.com/googleapis/google-cloud-java/commit/9e4ace25d84097f66c8720190c416c7fd5adc24a))
* [maps-routing] new module for maps-routing ([#8727](https://github.com/googleapis/google-cloud-java/issues/8727)) ([ecd6ab4](https://github.com/googleapis/google-cloud-java/commit/ecd6ab4ab7e5b2626f4ec3a04b7b9fcb63fa9f49))
* [maps-routiting] new module for maps-routiting ([#8724](https://github.com/googleapis/google-cloud-java/issues/8724)) ([4e67caa](https://github.com/googleapis/google-cloud-java/commit/4e67caa3b64c019d98b26bdffe5756b739f22f9e))
* [monitoring-dashboards] Added support for PromQL queries ([#8688](https://github.com/googleapis/google-cloud-java/issues/8688)) ([0635008](https://github.com/googleapis/google-cloud-java/commit/063500892aaa9db8b6676dbcc878ef69c26386e7))
* [run] Adds Cloud Run Jobs v2 API client libraries ([#8723](https://github.com/googleapis/google-cloud-java/issues/8723)) ([f857175](https://github.com/googleapis/google-cloud-java/commit/f857175540627347e7c3f0b9869caf9038af1d2b))
* [run] Adds gRPC probe support to Cloud Run v2 API client libraries ([#8729](https://github.com/googleapis/google-cloud-java/issues/8729)) ([0f2a881](https://github.com/googleapis/google-cloud-java/commit/0f2a881108f38d0941925ca5fd63e709f886182a))
* [videostitcher] Add support for Media CDN ([#8690](https://github.com/googleapis/google-cloud-java/issues/8690)) ([54f750d](https://github.com/googleapis/google-cloud-java/commit/54f750dc86bdd13bf258cfdcd8b4c32f1a333dea))
* added ImageQualityScores message to document.proto ([5f9858d](https://github.com/googleapis/google-cloud-java/commit/5f9858dc74a8dfb4cabecee37f60d139cef209df))
* added PropertyMetadata and EntityTypeMetadata to document_schema.proto ([5f9858d](https://github.com/googleapis/google-cloud-java/commit/5f9858dc74a8dfb4cabecee37f60d139cef209df))


### Bug Fixes

* Add centralized retries to all java-vision integration tests. Simplify. ([#8740](https://github.com/googleapis/google-cloud-java/issues/8740)) ([5622215](https://github.com/googleapis/google-cloud-java/commit/5622215e5c6606f8437f1d71475d701a06627406))
* **deps:** update dependency com.google.cloud:google-cloud-pubsub-bom to v1.120.24 ([#8693](https://github.com/googleapis/google-cloud-java/issues/8693)) ([fdecae4](https://github.com/googleapis/google-cloud-java/commit/fdecae4fbbae9ff1c1be0181eaaf23d427498d59))
* **deps:** update dependency com.google.cloud:google-cloud-pubsub-bom to v1.120.25 ([#8770](https://github.com/googleapis/google-cloud-java/issues/8770)) ([be2edac](https://github.com/googleapis/google-cloud-java/commit/be2edac0a0b2baf9fa865a325f5fdfe99e11860c))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.6 ([#8736](https://github.com/googleapis/google-cloud-java/issues/8736)) ([6ce987f](https://github.com/googleapis/google-cloud-java/commit/6ce987f897f7590f5684cf3d3a15bca200336ee0))
* **deps:** update dependency com.google.cloud:google-cloud-storage to v2.14.0 ([#8692](https://github.com/googleapis/google-cloud-java/issues/8692)) ([f4504bb](https://github.com/googleapis/google-cloud-java/commit/f4504bb23881b7c32b1a8a0dc83b2ee096f69a26))
* **deps:** update dependency com.google.cloud:google-cloud-storage to v2.15.0 ([#8738](https://github.com/googleapis/google-cloud-java/issues/8738)) ([66cf4d3](https://github.com/googleapis/google-cloud-java/commit/66cf4d35e49c2d89febdfc0c63c001f1e663ba00))
* **deps:** update dependency io.perfmark:perfmark-api to v0.26.0 ([#8751](https://github.com/googleapis/google-cloud-java/issues/8751)) ([14c1ec2](https://github.com/googleapis/google-cloud-java/commit/14c1ec2fb0e27e026f088fdd5a7984103b17ef3a))
* Enable java-notification integration test ([#8742](https://github.com/googleapis/google-cloud-java/issues/8742)) ([e170de2](https://github.com/googleapis/google-cloud-java/commit/e170de25520f45671b5a2fe37d7ff9c277ebdbd2))
* Make predestroy.sh scripts have executable permissions ([#8746](https://github.com/googleapis/google-cloud-java/issues/8746)) ([7c7adb5](https://github.com/googleapis/google-cloud-java/commit/7c7adb5329fef4d5e257940fe2a5950b87bf304c))
* Terraform job type is now terraform-integration ([#8743](https://github.com/googleapis/google-cloud-java/issues/8743)) ([65f126f](https://github.com/googleapis/google-cloud-java/commit/65f126fb9238dc24a8d00c627af5e2a7f32c6ee6))


### Documentation

* [batch] fix minor docstring formatting ([#8761](https://github.com/googleapis/google-cloud-java/issues/8761)) ([090ca64](https://github.com/googleapis/google-cloud-java/commit/090ca64d5c60814181beffd3a6227a4aa3dac315))
* [datacatalog] documentation updates ([#8733](https://github.com/googleapis/google-cloud-java/issues/8733)) ([9e4d6db](https://github.com/googleapis/google-cloud-java/commit/9e4d6db673f092f715943f9f4d80cdcc97b3e217))
* [jobs] marking keyword_searchable_job_custom_attributes on the company object as deprecated ([b1e181e](https://github.com/googleapis/google-cloud-java/commit/b1e181e496de06ed8e7568f1aa78aa3a318a0d8d))
* [jobs] marking keyword_searchable_job_custom_attributes on the company object as deprecated ([#8739](https://github.com/googleapis/google-cloud-java/issues/8739)) ([b1e181e](https://github.com/googleapis/google-cloud-java/commit/b1e181e496de06ed8e7568f1aa78aa3a318a0d8d))
* fix minor docstring formatting ([#8756](https://github.com/googleapis/google-cloud-java/issues/8756)) ([800cb54](https://github.com/googleapis/google-cloud-java/commit/800cb54165dc61d9e33366ce127d3e66027ace6c))
* marking company_size histogram facet as deprecated ([b1e181e](https://github.com/googleapis/google-cloud-java/commit/b1e181e496de06ed8e7568f1aa78aa3a318a0d8d))
* marking company_size histogram facet as deprecated ([b1e181e](https://github.com/googleapis/google-cloud-java/commit/b1e181e496de06ed8e7568f1aa78aa3a318a0d8d))
