# Changelog

## [1.25.0](https://github.com/googleapis/google-cloud-java/compare/v1.24.0...v1.25.0) (2023-12-04)


### ⚠ BREAKING CHANGES

* add FeatureViewDataFormat, FeatureViewDataKey to FeatureOnlineStoreService
* [recaptchaenterprise] added required annotations ([#10045](https://github.com/googleapis/google-cloud-java/issues/10045))
* change the resource pattern value to `properties/{property}/audienceLists/{audience_list}` for the resource definition `analyticsdata.googleapis.com/AudienceList`
* change the resource pattern value to `properties/{property}` for the resource definition `analyticsadmin.googleapis.com/Property`

### Features

* [aiplatform] add ComputeTokens and CountTokens API ([5352821](https://github.com/googleapis/google-cloud-java/commit/5352821b5cc151131728a072adeb3f146edee9fc))
* [aiplatform] add ComputeTokens API ([#10053](https://github.com/googleapis/google-cloud-java/issues/10053)) ([5352821](https://github.com/googleapis/google-cloud-java/commit/5352821b5cc151131728a072adeb3f146edee9fc))
* [aiplatform] add deployment_timeout to UploadModel ModelContainerSpec ([5352821](https://github.com/googleapis/google-cloud-java/commit/5352821b5cc151131728a072adeb3f146edee9fc))
* [aiplatform] add deployment_timeout to UploadModel ModelContainerSpec ([5352821](https://github.com/googleapis/google-cloud-java/commit/5352821b5cc151131728a072adeb3f146edee9fc))
* [aiplatform] add grpc_ports to UploadModel ModelContainerSpec ([#10065](https://github.com/googleapis/google-cloud-java/issues/10065)) ([de32d7a](https://github.com/googleapis/google-cloud-java/commit/de32d7a5c7738761b2cb30fb30b6b53836c9556c))
* [aiplatform] add grpc_ports to UploadModel ModelContainerSpec ([#10091](https://github.com/googleapis/google-cloud-java/issues/10091)) ([eeb5108](https://github.com/googleapis/google-cloud-java/commit/eeb510862b36a32523b385deda0b7a5207d052b6))
* [aiplatform] add protected_artifact_location_id to CustomJob ([5352821](https://github.com/googleapis/google-cloud-java/commit/5352821b5cc151131728a072adeb3f146edee9fc))
* [aiplatform] add protected_artifact_location_id to CustomJob ([5352821](https://github.com/googleapis/google-cloud-java/commit/5352821b5cc151131728a072adeb3f146edee9fc))
* [analyticsdata] add `CreateRecurringAudienceList`, `GetRecurringAudienceList`, `ListRecurringAudienceLists` methods to the Data API v1 alpha ([#10092](https://github.com/googleapis/google-cloud-java/issues/10092)) ([e4f430e](https://github.com/googleapis/google-cloud-java/commit/e4f430eb37c310c1f3caf1ddbc3b3b42bd7ae75f))
* [analyticsdata] add the `SheetExportAudienceList` method to the Data API v1 alpha ([#10047](https://github.com/googleapis/google-cloud-java/issues/10047)) ([a6880a0](https://github.com/googleapis/google-cloud-java/commit/a6880a0581983878ca13a287f8bd956a6262735e))
* [batch] add a CloudLoggingOption and use_generic_task_monitored_resource fields for users to opt out new batch monitored resource in cloud logging ([#10056](https://github.com/googleapis/google-cloud-java/issues/10056)) ([a9830d9](https://github.com/googleapis/google-cloud-java/commit/a9830d9373cad9d2235ed93a625ebee886ff6ff0))
* [batch] add a CloudLoggingOption and use_generic_task_monitored_resource fields for users to opt out new batch monitored resource in cloud logging ([#10073](https://github.com/googleapis/google-cloud-java/issues/10073)) ([5c91759](https://github.com/googleapis/google-cloud-java/commit/5c91759a2067bb7bf8d6ffe26f5aeef07c9cbb0a))
* [binaryauthorization] add container_name, container_type fields to Continuous Validation Logs ([#10085](https://github.com/googleapis/google-cloud-java/issues/10085)) ([ee237cd](https://github.com/googleapis/google-cloud-java/commit/ee237cd3a511aaa7b135d619892bdfe7ac307e75))
* [cloudprofiler] add client side retry config for export service ([#10060](https://github.com/googleapis/google-cloud-java/issues/10060)) ([1961c40](https://github.com/googleapis/google-cloud-java/commit/1961c40a135f0932aedb983ab3c75174f97a71d7))
* [confidentialcomputing] Add a new field `token_type` to `TokenOptions` message proto ([#10051](https://github.com/googleapis/google-cloud-java/issues/10051)) ([e8c974b](https://github.com/googleapis/google-cloud-java/commit/e8c974b8781c12ac67d7e878cd869324086e75c0))
* [dataplex] add data quality score to DataQualityResult ([#10108](https://github.com/googleapis/google-cloud-java/issues/10108)) ([fbbbc5c](https://github.com/googleapis/google-cloud-java/commit/fbbbc5c2aaa8fe3e38c4a507db075a65e3d83627))
* [dataplex] added DataQualityResult.score, dimension_score, column_score ([#10064](https://github.com/googleapis/google-cloud-java/issues/10064)) ([7a49d63](https://github.com/googleapis/google-cloud-java/commit/7a49d63e7318436ad652bf73475efd9018d83eeb))
* [dialogflow-cx] add agent answer feedback capability ([#10066](https://github.com/googleapis/google-cloud-java/issues/10066)) ([8cca9aa](https://github.com/googleapis/google-cloud-java/commit/8cca9aac54a8be5b7cce69c855c0b5d94c33f381))
* [dialogflow-cx] added Generator API ([#10089](https://github.com/googleapis/google-cloud-java/issues/10089)) ([bd47695](https://github.com/googleapis/google-cloud-java/commit/bd4769513ffb031f5c3d48b139d7ffaf8454a0ea))
* [discoveryengine] add data store and engine services ([#10054](https://github.com/googleapis/google-cloud-java/issues/10054)) ([5a71294](https://github.com/googleapis/google-cloud-java/commit/5a71294201f9007512a0c669bbc93f3eda04acba))
* [file] Added REGIONAL tier support in the v1 API ([7d1f4fe](https://github.com/googleapis/google-cloud-java/commit/7d1f4fe6c044fd7328c5fdd78ba16c166e801e00))
* [file] Added REGIONAL tier support in the v1beta1 API ([#10058](https://github.com/googleapis/google-cloud-java/issues/10058)) ([7d1f4fe](https://github.com/googleapis/google-cloud-java/commit/7d1f4fe6c044fd7328c5fdd78ba16c166e801e00))
* [recaptchaenterprise] added AnnotateAssessmentRequest.account_id ([#10077](https://github.com/googleapis/google-cloud-java/issues/10077)) ([9fe85ef](https://github.com/googleapis/google-cloud-java/commit/9fe85efadd651bfae22ff92d904762954ffa18fd))
* [securesourcemanager] new module for securesourcemanager ([#10032](https://github.com/googleapis/google-cloud-java/issues/10032)) ([64a3b28](https://github.com/googleapis/google-cloud-java/commit/64a3b289052a64c37a58503938e2ed3796c10812))
* [telcoautomation] new module for telcoautomation ([#10070](https://github.com/googleapis/google-cloud-java/issues/10070)) ([6188d44](https://github.com/googleapis/google-cloud-java/commit/6188d44761bcfa4dab77a02f51097474e2403e9d))
* add `creation_quota_tokens_charged`, `row_count`, `error_message` to the `AudienceList` resource ([a6880a0](https://github.com/googleapis/google-cloud-java/commit/a6880a0581983878ca13a287f8bd956a6262735e))
* add BatchDeletePipelineJobs, BatchDeletePipelineJobsRequest and BatchDeletePipelineJobsResponse to PipelineService ([5352821](https://github.com/googleapis/google-cloud-java/commit/5352821b5cc151131728a072adeb3f146edee9fc))
* add CountTokensRequest to PredictionService ([5352821](https://github.com/googleapis/google-cloud-java/commit/5352821b5cc151131728a072adeb3f146edee9fc))
* add FeatureGroup, FeatureOnlineStore, FeatureOnlineStoreAdminService, FeatureOnlineStoreService, FeatureRegistryService, FeatureView, FeatureViewSync ([5352821](https://github.com/googleapis/google-cloud-java/commit/5352821b5cc151131728a072adeb3f146edee9fc))
* add FeatureViewDataFormat, FeatureViewDataKey to FeatureOnlineStoreService ([5352821](https://github.com/googleapis/google-cloud-java/commit/5352821b5cc151131728a072adeb3f146edee9fc))
* add NumericRestriction to Index ([5352821](https://github.com/googleapis/google-cloud-java/commit/5352821b5cc151131728a072adeb3f146edee9fc))
* add NumericRestriction to Index ([5352821](https://github.com/googleapis/google-cloud-java/commit/5352821b5cc151131728a072adeb3f146edee9fc))
* add shared_memory_size_mb to UploadModel ModelContainerSpec ([5352821](https://github.com/googleapis/google-cloud-java/commit/5352821b5cc151131728a072adeb3f146edee9fc))
* add shared_memory_size_mb to UploadModel ModelContainerSpec ([5352821](https://github.com/googleapis/google-cloud-java/commit/5352821b5cc151131728a072adeb3f146edee9fc))
* add startup_probe, health_probe to UploadModel ModelContainerSpec ([5352821](https://github.com/googleapis/google-cloud-java/commit/5352821b5cc151131728a072adeb3f146edee9fc))
* add startup_probe, health_probe to UploadModel ModelContainerSpec ([5352821](https://github.com/googleapis/google-cloud-java/commit/5352821b5cc151131728a072adeb3f146edee9fc))
* add StudyTimeConstraint to Study ([5352821](https://github.com/googleapis/google-cloud-java/commit/5352821b5cc151131728a072adeb3f146edee9fc))
* add StudyTimeConstraint to Study ([5352821](https://github.com/googleapis/google-cloud-java/commit/5352821b5cc151131728a072adeb3f146edee9fc))
* add tpu_topology to MachineResources ([5352821](https://github.com/googleapis/google-cloud-java/commit/5352821b5cc151131728a072adeb3f146edee9fc))
* add tpu_topology to MachineSpec ([5352821](https://github.com/googleapis/google-cloud-java/commit/5352821b5cc151131728a072adeb3f146edee9fc))
* add value_type, version_column_name to Feature ([5352821](https://github.com/googleapis/google-cloud-java/commit/5352821b5cc151131728a072adeb3f146edee9fc))


### Bug Fixes

* [recaptchaenterprise] added required annotations ([#10045](https://github.com/googleapis/google-cloud-java/issues/10045)) ([27888dd](https://github.com/googleapis/google-cloud-java/commit/27888ddb1e49f606e317bede7ef033fff48fef84))
* add `optional` annotation to the `dimension_name` field of the `AudienceDimension` type ([a6880a0](https://github.com/googleapis/google-cloud-java/commit/a6880a0581983878ca13a287f8bd956a6262735e))
* add `optional` annotation to the `offset`, `limit` fields of the `QueryAudienceListRequest` type ([a6880a0](https://github.com/googleapis/google-cloud-java/commit/a6880a0581983878ca13a287f8bd956a6262735e))
* add `optional` annotation to the `page_token` field of the `ListAudienceListsRequest` type ([a6880a0](https://github.com/googleapis/google-cloud-java/commit/a6880a0581983878ca13a287f8bd956a6262735e))
* add `optional` annotation to the `property`, `date_ranges`, `funnel`, `funnel_breakdown`, `funnel_visualization_type`, `segments`, `dimension_filter`, `return_property_quota`, `limit` fields of the `RunFunnelReportRequest` type ([a6880a0](https://github.com/googleapis/google-cloud-java/commit/a6880a0581983878ca13a287f8bd956a6262735e))
* add `required` annotation to the `name` field of the `QueryAudienceListRequest` type ([a6880a0](https://github.com/googleapis/google-cloud-java/commit/a6880a0581983878ca13a287f8bd956a6262735e))
* change the resource pattern value to `properties/{property}/audienceLists/{audience_list}` for the resource definition `analyticsdata.googleapis.com/AudienceList` ([a6880a0](https://github.com/googleapis/google-cloud-java/commit/a6880a0581983878ca13a287f8bd956a6262735e))
* change the resource pattern value to `properties/{property}` for the resource definition `analyticsadmin.googleapis.com/Property` ([a6880a0](https://github.com/googleapis/google-cloud-java/commit/a6880a0581983878ca13a287f8bd956a6262735e))
* **deps:** [Many APIs] Update the Java code generator (gapic-generator-java) to 2.30.0 ([0d18fcc](https://github.com/googleapis/google-cloud-java/commit/0d18fcc847c3e26f9ed8809266d1acf349f92391))
* **deps:** [Many APIs] Update the Java code generator (gapic-generator-java) to 2.30.0 ([9d555bc](https://github.com/googleapis/google-cloud-java/commit/9d555bc118bcb9e34529df54c909dd0d4c17fa49))
* **deps:** [Many APIs] Update the Java code generator (gapic-generator-java) to 2.30.0 ([3756776](https://github.com/googleapis/google-cloud-java/commit/375677643b8a7fca86a5d12b4f34b2e9e5f2c3e1))
* **deps:** [Many APIs] Update the Java code generator (gapic-generator-java) to 2.30.0 ([8d05c8b](https://github.com/googleapis/google-cloud-java/commit/8d05c8b2ca4839923ac2362f11447ee49efa3002))
* **deps:** [Many APIs] Update the Java code generator (gapic-generator-java) to 2.30.0 ([7fe1280](https://github.com/googleapis/google-cloud-java/commit/7fe128038269013125901735b45a3af9ba0a146f))
* **deps:** [Many APIs] Update the Java code generator (gapic-generator-java) to 2.30.0 ([43bfb4b](https://github.com/googleapis/google-cloud-java/commit/43bfb4b2cd449f056c1bc3e2b0635043385b3d85))
* **deps:** [Many APIs] Update the Java code generator (gapic-generator-java) to 2.30.0 ([7651030](https://github.com/googleapis/google-cloud-java/commit/76510309dd1cc68b074ab8d99819cfb29e82aeca))
* **deps:** [Many APIs] Update the Java code generator (gapic-generator-java) to 2.30.0 ([9eac6a9](https://github.com/googleapis/google-cloud-java/commit/9eac6a96bde6806dd81faba026daa0166d2e7ff3))
* **deps:** [Many APIs] Update the Java code generator (gapic-generator-java) to 2.30.0 ([#10094](https://github.com/googleapis/google-cloud-java/issues/10094)) ([7651030](https://github.com/googleapis/google-cloud-java/commit/76510309dd1cc68b074ab8d99819cfb29e82aeca))
* **deps:** [Many APIs] Update the Java code generator (gapic-generator-java) to 2.30.0 ([#10095](https://github.com/googleapis/google-cloud-java/issues/10095)) ([9eac6a9](https://github.com/googleapis/google-cloud-java/commit/9eac6a96bde6806dd81faba026daa0166d2e7ff3))
* **deps:** [Many APIs] Update the Java code generator (gapic-generator-java) to 2.30.0 ([#10096](https://github.com/googleapis/google-cloud-java/issues/10096)) ([3756776](https://github.com/googleapis/google-cloud-java/commit/375677643b8a7fca86a5d12b4f34b2e9e5f2c3e1))
* **deps:** [Many APIs] Update the Java code generator (gapic-generator-java) to 2.30.0 ([#10097](https://github.com/googleapis/google-cloud-java/issues/10097)) ([8d05c8b](https://github.com/googleapis/google-cloud-java/commit/8d05c8b2ca4839923ac2362f11447ee49efa3002))
* **deps:** [Many APIs] Update the Java code generator (gapic-generator-java) to 2.30.0 ([#10098](https://github.com/googleapis/google-cloud-java/issues/10098)) ([43bfb4b](https://github.com/googleapis/google-cloud-java/commit/43bfb4b2cd449f056c1bc3e2b0635043385b3d85))
* **deps:** [Many APIs] Update the Java code generator (gapic-generator-java) to 2.30.0 ([#10099](https://github.com/googleapis/google-cloud-java/issues/10099)) ([7fe1280](https://github.com/googleapis/google-cloud-java/commit/7fe128038269013125901735b45a3af9ba0a146f))
* **deps:** [Many APIs] Update the Java code generator (gapic-generator-java) to 2.30.0 ([#10100](https://github.com/googleapis/google-cloud-java/issues/10100)) ([0d18fcc](https://github.com/googleapis/google-cloud-java/commit/0d18fcc847c3e26f9ed8809266d1acf349f92391))
* **deps:** [Many APIs] Update the Java code generator (gapic-generator-java) to 2.30.0 ([#10101](https://github.com/googleapis/google-cloud-java/issues/10101)) ([9d555bc](https://github.com/googleapis/google-cloud-java/commit/9d555bc118bcb9e34529df54c909dd0d4c17fa49))
* **deps:** [securesourcemanager] Update the Java code generator (gapic-generator-java) to 2.30.0 ([2a527e1](https://github.com/googleapis/google-cloud-java/commit/2a527e112e76737c5a11cdc1050854583eab9252))
* **deps:** [securesourcemanager] Update the Java code generator (gapic-generator-java) to 2.30.0 ([#10102](https://github.com/googleapis/google-cloud-java/issues/10102)) ([2a527e1](https://github.com/googleapis/google-cloud-java/commit/2a527e112e76737c5a11cdc1050854583eab9252))
* **deps:** update dependency com.google.apis:google-api-services-storage to v1-rev20231117-2.0.0 ([#10105](https://github.com/googleapis/google-cloud-java/issues/10105)) ([8fbbdbc](https://github.com/googleapis/google-cloud-java/commit/8fbbdbc48c23c841c031a6bc32f83211c1f036bc))
* **deps:** update dependency com.google.cloud:google-cloud-pubsub-bom to v1.125.12 ([#10084](https://github.com/googleapis/google-cloud-java/issues/10084)) ([6b0166b](https://github.com/googleapis/google-cloud-java/commit/6b0166b448d756f3c33597e071c92fcb1562e5ca))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.20.0 ([#10093](https://github.com/googleapis/google-cloud-java/issues/10093)) ([91a4e4e](https://github.com/googleapis/google-cloud-java/commit/91a4e4e20252f667b8fc6bda0d9ceaf947348274))
* **deps:** update dependency com.google.cloud:google-cloud-storage to v2.29.1 ([#10035](https://github.com/googleapis/google-cloud-java/issues/10035)) ([eefb1b2](https://github.com/googleapis/google-cloud-java/commit/eefb1b2fa83b77d87ae9020cdc9552e385e4ff6b))
* use path wildcards in java-iam owlbot yaml ([#10050](https://github.com/googleapis/google-cloud-java/issues/10050)) ([f89e45a](https://github.com/googleapis/google-cloud-java/commit/f89e45a3d72d85e8ec9720f54b8bf36de1a4e332))


### Documentation

* [cloudscheduler] correct timezone/offset information for Cloud Scheduler headers ([#10048](https://github.com/googleapis/google-cloud-java/issues/10048)) ([2511217](https://github.com/googleapis/google-cloud-java/commit/25112175ee71861a900b3d77a712d2e74bb90543))
* [contactcenterinsights] Update IngestConversations and BulkAnalyzeConversations comments ([#10069](https://github.com/googleapis/google-cloud-java/issues/10069)) ([8a2c241](https://github.com/googleapis/google-cloud-java/commit/8a2c241780711f745cdc393d698e040c9d55eb3e))
* [container] improve API documentation for Binary Authorization ([#10063](https://github.com/googleapis/google-cloud-java/issues/10063)) ([25aa532](https://github.com/googleapis/google-cloud-java/commit/25aa532caf161cceac7795ee8ddd3a03786b97ce))
* [dataplex] updated comments for `DataQualityResult.dimensions` field ([#10044](https://github.com/googleapis/google-cloud-java/issues/10044)) ([404a852](https://github.com/googleapis/google-cloud-java/commit/404a85295344cf2e8b3fe13d9f595279847630fa))
* [documentai] update comment for ProcessOptions.page_range ([#10076](https://github.com/googleapis/google-cloud-java/issues/10076)) ([84fe051](https://github.com/googleapis/google-cloud-java/commit/84fe051733c88f13d0db34080b3191b09c742527))
* [securitycenter] Modify documentation of SimulateSecurityHealthAnalyticsCustomModuleRequest ([#10075](https://github.com/googleapis/google-cloud-java/issues/10075)) ([8313e78](https://github.com/googleapis/google-cloud-java/commit/8313e78b3fa363068af9da4a2f43868bcb17e81d))
* keep the API doc up-to-date with recent changes ([5a71294](https://github.com/googleapis/google-cloud-java/commit/5a71294201f9007512a0c669bbc93f3eda04acba))

## [1.24.0](https://github.com/googleapis/google-cloud-java/compare/v1.23.0...v1.24.0) (2023-11-06)


### Features

* [aiplatform] add Optimized to FeatureOnlineStore ([#10040](https://github.com/googleapis/google-cloud-java/issues/10040)) ([cc0e248](https://github.com/googleapis/google-cloud-java/commit/cc0e248a9ee4658dbd3b2649d01381df218b4419))
* [aiplatform] Adding new fields for concurrent explanations ([#10016](https://github.com/googleapis/google-cloud-java/issues/10016)) ([d80aa3c](https://github.com/googleapis/google-cloud-java/commit/d80aa3c6cb96bbe8a16827b81699a15979cceed4))
* [alloydb] Add new field in `GenerateClientCertificate` v1 API to allow AlloyDB connectors request client certs with metadata exchange support ([#10024](https://github.com/googleapis/google-cloud-java/issues/10024)) ([bc8bbd0](https://github.com/googleapis/google-cloud-java/commit/bc8bbd0794170806bb059fc12b21068ad4b7688f))
* [cloudbuild] Add optional field "SourceFetcher" to choose source fetcher tool ([#10022](https://github.com/googleapis/google-cloud-java/issues/10022)) ([e336c70](https://github.com/googleapis/google-cloud-java/commit/e336c70660cd0663f91675a30ace51f42b5e60a1))
* [clouddeploy] add Automation API and Rollback API ([#10034](https://github.com/googleapis/google-cloud-java/issues/10034)) ([399cb6d](https://github.com/googleapis/google-cloud-java/commit/399cb6d106f710ae7d569160fd0f06dc231bc306))
* [contactcenterinsights] Launch BulkDelete API, and bulk audio import via the IngestConversations API ([#10039](https://github.com/googleapis/google-cloud-java/issues/10039)) ([dbdc8a1](https://github.com/googleapis/google-cloud-java/commit/dbdc8a128dd35a71cd476f03b04e0ae8a809b40d))
* [container] add ResourceManagerTags API to attach tags on the underlying Compute Engine VMs of GKE Nodes which can be used to selectively enforce Cloud Firewall network firewall policies ([#10008](https://github.com/googleapis/google-cloud-java/issues/10008)) ([aede3bd](https://github.com/googleapis/google-cloud-java/commit/aede3bde55b79edf0f6e403688ae6606460765b1))
* [container] added EnterpriseConfig ([#10021](https://github.com/googleapis/google-cloud-java/issues/10021)) ([9c2647b](https://github.com/googleapis/google-cloud-java/commit/9c2647b653085253c9b98853ee7d430363da5baa))
* [dataform] Support for ReleaseConfigs ([#9999](https://github.com/googleapis/google-cloud-java/issues/9999)) ([2021b5a](https://github.com/googleapis/google-cloud-java/commit/2021b5a92fdcb0907985a60301006576dfe51833))
* [datalineage] add open lineage support ([#10041](https://github.com/googleapis/google-cloud-java/issues/10041)) ([ceb26a1](https://github.com/googleapis/google-cloud-java/commit/ceb26a1f5b6b74963c7adeb9e2879a586ffcc801))
* [dataplex] DataQualityDimension is now part of the DataQualityDimensionResult message ([#10010](https://github.com/googleapis/google-cloud-java/issues/10010)) ([95a6f15](https://github.com/googleapis/google-cloud-java/commit/95a6f1585dbafa985788b714ff394cd4cb2d1f5c))
* [dataproc] support required_registration_fraction for secondary workers ([#10031](https://github.com/googleapis/google-cloud-java/issues/10031)) ([bb0964c](https://github.com/googleapis/google-cloud-java/commit/bb0964c3b3a199884ee3d8f1a90d2cea2d22a8f9))
* [dlp] Introduce Discovery API protos and methods ([#9996](https://github.com/googleapis/google-cloud-java/issues/9996)) ([36fd92b](https://github.com/googleapis/google-cloud-java/commit/36fd92bbcd9b7f38d3567e7146499d35cb0b41af))
* [maps-fleetengine-delivery] new module for maps-fleetengine-delivery ([#10028](https://github.com/googleapis/google-cloud-java/issues/10028)) ([09b31ad](https://github.com/googleapis/google-cloud-java/commit/09b31ad455e18d60148201a8f385b56f801222df))
* [maps-fleetengine] new module for maps-fleetengine ([#10033](https://github.com/googleapis/google-cloud-java/issues/10033)) ([53488e4](https://github.com/googleapis/google-cloud-java/commit/53488e4829ccab1337b879d202e66abeb332663b))
* [maps-places] new module for maps-places ([#9420](https://github.com/googleapis/google-cloud-java/issues/9420)) ([7e76fbc](https://github.com/googleapis/google-cloud-java/commit/7e76fbc65ef0d812b9dedbb022961614d9f61b06))
* [speech] add transcript normalization + m4a audio format support ([#10009](https://github.com/googleapis/google-cloud-java/issues/10009)) ([bda7841](https://github.com/googleapis/google-cloud-java/commit/bda78416ad7575ae92d81fc02068e7417f5ae624))
* [speech] Support MP3, TranscriptNormalization and SpeakerLabels in STT V1 API ([#10027](https://github.com/googleapis/google-cloud-java/issues/10027)) ([7ca3309](https://github.com/googleapis/google-cloud-java/commit/7ca3309c6ce48669b3979e8afdb020cdcadb855f))


### Bug Fixes

* **aiplatform/v1beta1:** [aiplatform] change CreateFeature metadata ([#10029](https://github.com/googleapis/google-cloud-java/issues/10029)) ([5067fe4](https://github.com/googleapis/google-cloud-java/commit/5067fe49e688515268104f55dfc74ee74ef1a9b5))
* **deps:** update dependency com.google.apis:google-api-services-storage to v1-rev20231028-2.0.0 ([#10012](https://github.com/googleapis/google-cloud-java/issues/10012)) ([2df5d78](https://github.com/googleapis/google-cloud-java/commit/2df5d7886acdf5153d85058220ed1a329a7297cc))
* **deps:** update dependency com.google.cloud:google-cloud-pubsub-bom to v1.125.11 ([#10023](https://github.com/googleapis/google-cloud-java/issues/10023)) ([7d010c3](https://github.com/googleapis/google-cloud-java/commit/7d010c3b5806d9cc7ab17450c2772f3187f667a4))
* **deps:** update dependency com.google.cloud:google-cloud-pubsub-bom to v1.125.9 ([#10007](https://github.com/googleapis/google-cloud-java/issues/10007)) ([8103c93](https://github.com/googleapis/google-cloud-java/commit/8103c93d12adce7f50b21ebc7d9de1c442c5a1e0))
* **deps:** update dependency com.google.cloud:google-cloud-shared-config to v1.6.1 ([#10014](https://github.com/googleapis/google-cloud-java/issues/10014)) ([7b1b742](https://github.com/googleapis/google-cloud-java/commit/7b1b742dab21139398032549fb03e127b1a03841))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.19.0 ([#10018](https://github.com/googleapis/google-cloud-java/issues/10018)) ([d9b705a](https://github.com/googleapis/google-cloud-java/commit/d9b705aaed8ea4447c7a02d5c54300f8909a30b1))


### Documentation

* [artifactregistry] use code font for resource name references ([#9997](https://github.com/googleapis/google-cloud-java/issues/9997)) ([baf18bd](https://github.com/googleapis/google-cloud-java/commit/baf18bd13715a18ec0f9dbb5812ba150695e34f6))
* [batch] update default max parallel tasks per job ([#10011](https://github.com/googleapis/google-cloud-java/issues/10011)) ([4edc21b](https://github.com/googleapis/google-cloud-java/commit/4edc21bc0e54f9b52eb367beac2d438197f23432))
* [documentai] updated comments ([#10015](https://github.com/googleapis/google-cloud-java/issues/10015)) ([2bd259f](https://github.com/googleapis/google-cloud-java/commit/2bd259f0bd17e9e059b4a1d7cd2acae6b5a254e8))
* fix Speech Recognition Client link ([#10001](https://github.com/googleapis/google-cloud-java/issues/10001)) ([e681bd2](https://github.com/googleapis/google-cloud-java/commit/e681bd252f796f733602bfa72b8b8d77bb9c024e))

## [1.23.0](https://github.com/googleapis/google-cloud-java/compare/v1.22.0...v1.23.0) (2023-10-25)


### ⚠ BREAKING CHANGES

* [analyticsadmin] delete `BatchDeleteUserLinks`, `DeleteUserLink`, `BatchUpdateUserLinks`, `UpdateUserLink`, `BatchCreateUserLinks`, `CreateUserLink`, `AuditUserLinks`, `ListUserLinks`, `BatchGetUserLinks`, `GetUserLink` from the Admin API v1 alph... ([#9982](https://github.com/googleapis/google-cloud-java/issues/9982))
* [merchantapi] non_product_performance_view table, seller segments in product_performance_view table, and entity ids in best_seller tables are removed ([#9981](https://github.com/googleapis/google-cloud-java/issues/9981))
* Destination enum is wrapped in a message
* Update go_package and Go importpath:
* `destination` field in the `product_performance_view` table is renamed to `marketing_method`
* `destination` term in the `product_view` table is renamed to `reporting_context`
* `predicted_gross_profit_change_fraction` and `predicted_monthly_gross_profit_change` fields are removed from the `price_insights_product_view` table
* `ReportGranularity`, `RelativeDemand`, `RelativeDemandChangeType`, `TrafficSource` enums are wrapped into messages
* Destination enum is wrapped in a message
* Update go_package and Go importpath:

### Features

* [batch] expose display_name to batch v1 API ([#9967](https://github.com/googleapis/google-cloud-java/issues/9967)) ([934c929](https://github.com/googleapis/google-cloud-java/commit/934c92940ec76f96aa71b13249a81cde58bab5ee))
* [clouddeploy] added platform log RolloutUpdateEvent ([#9979](https://github.com/googleapis/google-cloud-java/issues/9979)) ([ebdc309](https://github.com/googleapis/google-cloud-java/commit/ebdc30925e4bf247ede4f393fb268eaa8706eac0))
* [cloudoptimization] added the route modifiers ([#9963](https://github.com/googleapis/google-cloud-java/issues/9963)) ([1f558b0](https://github.com/googleapis/google-cloud-java/commit/1f558b06a7564d843148fb7a10be94df9d61578f))
* [discoveryengine] add v1alpha public library for discoveryengine ([#9953](https://github.com/googleapis/google-cloud-java/issues/9953)) ([f4b2dda](https://github.com/googleapis/google-cloud-java/commit/f4b2dda909a384ffcbe55b1498fe4e0259d09bcf))
* [merchantapi] `channel` field is added to the `product_view` table ([#9956](https://github.com/googleapis/google-cloud-java/issues/9956)) ([2a8403b](https://github.com/googleapis/google-cloud-java/commit/2a8403b4c948f315911384c46c74d33afcb2eb65))
* [merchantapi] Channel enum is added ([#9957](https://github.com/googleapis/google-cloud-java/issues/9957)) ([9135abe](https://github.com/googleapis/google-cloud-java/commit/9135abe92be0639bde65a98709cd9d9df6385ae7))
* [redis-cluster] new module for redis-cluster ([#9993](https://github.com/googleapis/google-cloud-java/issues/9993)) ([c280a9c](https://github.com/googleapis/google-cloud-java/commit/c280a9cf2c26e45dfabb60d45318fe40cd67a88a))
* [securitycenter] Add SimulateSecurityHealthAnalyticsCustomModule API for testing SHA custom module ([#9980](https://github.com/googleapis/google-cloud-java/issues/9980)) ([84afb01](https://github.com/googleapis/google-cloud-java/commit/84afb01dd57588ca316e852143b433d2e1c7fd81))
* A new message `MarketingMethod` is added ([2a8403b](https://github.com/googleapis/google-cloud-java/commit/2a8403b4c948f315911384c46c74d33afcb2eb65))
* Channel enum is added ([2a8403b](https://github.com/googleapis/google-cloud-java/commit/2a8403b4c948f315911384c46c74d33afcb2eb65))
* ReportingContext enum is added ([9135abe](https://github.com/googleapis/google-cloud-java/commit/9135abe92be0639bde65a98709cd9d9df6385ae7))
* ReportingContext enum is added ([2a8403b](https://github.com/googleapis/google-cloud-java/commit/2a8403b4c948f315911384c46c74d33afcb2eb65))


### Bug Fixes

* [analyticsadmin] delete `BatchDeleteUserLinks`, `DeleteUserLink`, `BatchUpdateUserLinks`, `UpdateUserLink`, `BatchCreateUserLinks`, `CreateUserLink`, `AuditUserLinks`, `ListUserLinks`, `BatchGetUserLinks`, `GetUserLink` from the Admin API v1 alph... ([#9982](https://github.com/googleapis/google-cloud-java/issues/9982)) ([75d2527](https://github.com/googleapis/google-cloud-java/commit/75d252766bdf96a47ac40e3ccca2ddcbbb930a11))
* [merchantapi] non_product_performance_view table, seller segments in product_performance_view table, and entity ids in best_seller tables are removed ([#9981](https://github.com/googleapis/google-cloud-java/issues/9981)) ([f242404](https://github.com/googleapis/google-cloud-java/commit/f242404af5d3a84b84bfd57937a06f9cbb99674c))
* `destination` field in the `product_performance_view` table is renamed to `marketing_method` ([2a8403b](https://github.com/googleapis/google-cloud-java/commit/2a8403b4c948f315911384c46c74d33afcb2eb65))
* `destination` term in the `product_view` table is renamed to `reporting_context` ([2a8403b](https://github.com/googleapis/google-cloud-java/commit/2a8403b4c948f315911384c46c74d33afcb2eb65))
* `predicted_gross_profit_change_fraction` and `predicted_monthly_gross_profit_change` fields are removed from the `price_insights_product_view` table ([2a8403b](https://github.com/googleapis/google-cloud-java/commit/2a8403b4c948f315911384c46c74d33afcb2eb65))
* `ReportGranularity`, `RelativeDemand`, `RelativeDemandChangeType`, `TrafficSource` enums are wrapped into messages ([2a8403b](https://github.com/googleapis/google-cloud-java/commit/2a8403b4c948f315911384c46c74d33afcb2eb65))
* convert java-talent integration test to v4 ([#9948](https://github.com/googleapis/google-cloud-java/issues/9948)) ([91c76e0](https://github.com/googleapis/google-cloud-java/commit/91c76e0429ee18cb517d757a06653a64ab904e62))
* **deps:** update dependency com.google.apis:google-api-services-cloudresourcemanager to v1-rev20231022-2.0.0 ([#9990](https://github.com/googleapis/google-cloud-java/issues/9990)) ([89dd580](https://github.com/googleapis/google-cloud-java/commit/89dd580c90ae8f710d8a0491ca141cc36c2b7d14))
* **deps:** update dependency com.google.apis:google-api-services-storage to v1-rev20231012-2.0.0 ([#9965](https://github.com/googleapis/google-cloud-java/issues/9965)) ([6accd08](https://github.com/googleapis/google-cloud-java/commit/6accd08c5db92e367973d580bd2764f3a08ca1da))
* **deps:** update dependency com.google.cloud:google-cloud-pubsub-bom to v1.125.6 ([#9954](https://github.com/googleapis/google-cloud-java/issues/9954)) ([7104b86](https://github.com/googleapis/google-cloud-java/commit/7104b86b9154e46fa00705c4442047f1dc6ce311))
* **deps:** update dependency com.google.cloud:google-cloud-pubsub-bom to v1.125.7 ([#9971](https://github.com/googleapis/google-cloud-java/issues/9971)) ([52b9c23](https://github.com/googleapis/google-cloud-java/commit/52b9c237df8d1c01619a09ad0bb99a7d0bb68313))
* **deps:** update dependency com.google.cloud:google-cloud-pubsub-bom to v1.125.8 ([#9987](https://github.com/googleapis/google-cloud-java/issues/9987)) ([81180df](https://github.com/googleapis/google-cloud-java/commit/81180df3f6d135417a3072f24c42fc142edb4eec))
* **deps:** update dependency com.google.cloud:google-cloud-shared-config to v1.6.0 ([#9969](https://github.com/googleapis/google-cloud-java/issues/9969)) ([9e2be39](https://github.com/googleapis/google-cloud-java/commit/9e2be39c5b2d7764421325f65a6d0d06351fcda5))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.18.0 ([#9984](https://github.com/googleapis/google-cloud-java/issues/9984)) ([9814dc0](https://github.com/googleapis/google-cloud-java/commit/9814dc092ad7edb7b1b21f87fa48d76a2423d731))
* **deps:** update dependency com.google.cloud:google-cloud-storage to v2.28.0 ([#9959](https://github.com/googleapis/google-cloud-java/issues/9959)) ([0d8d17e](https://github.com/googleapis/google-cloud-java/commit/0d8d17ef1bab873be8f6b34f3c6364d5d18d1198))
* **deps:** update dependency com.google.cloud:google-cloud-storage to v2.29.0 ([#9988](https://github.com/googleapis/google-cloud-java/issues/9988)) ([82fb240](https://github.com/googleapis/google-cloud-java/commit/82fb24020f6fa3b1572b8bd6d44839981cc47043))
* Destination enum is wrapped in a message ([9135abe](https://github.com/googleapis/google-cloud-java/commit/9135abe92be0639bde65a98709cd9d9df6385ae7))
* Destination enum is wrapped in a message ([2a8403b](https://github.com/googleapis/google-cloud-java/commit/2a8403b4c948f315911384c46c74d33afcb2eb65))
* lenient vision face annotation results ([#9947](https://github.com/googleapis/google-cloud-java/issues/9947)) ([b12f226](https://github.com/googleapis/google-cloud-java/commit/b12f226051bfc264b6f498aaed48ecca18f50196))
* Update go_package and Go importpath: ([9135abe](https://github.com/googleapis/google-cloud-java/commit/9135abe92be0639bde65a98709cd9d9df6385ae7))
* Update go_package and Go importpath: ([2a8403b](https://github.com/googleapis/google-cloud-java/commit/2a8403b4c948f315911384c46c74d33afcb2eb65))


### Documentation

* [documentai] minor clarification on fields related to page range ([#9955](https://github.com/googleapis/google-cloud-java/issues/9955)) ([ff54c9f](https://github.com/googleapis/google-cloud-java/commit/ff54c9fc8293782dc10af0622ea79f41dbcb007b))

## [1.22.0](https://github.com/googleapis/google-cloud-java/compare/v1.21.0...v1.22.0) (2023-10-11)


### Features

* [aiplatform] add DatasetVersion and dataset version RPCs to DatasetService ([#9922](https://github.com/googleapis/google-cloud-java/issues/9922)) ([1f45cd0](https://github.com/googleapis/google-cloud-java/commit/1f45cd036e0650aff38595a4a4f6afcb0d23b958))
* [batch] add InstancePolicy.reservation field for restricting jobs to a specific reservation ([#9933](https://github.com/googleapis/google-cloud-java/issues/9933)) ([42f3ee5](https://github.com/googleapis/google-cloud-java/commit/42f3ee5cc0fc747bc79e183077bd8e6807e3f9b6))
* [dataplex] DataQualityDimension is now part of the DataQualityDimensionResult message ([#9949](https://github.com/googleapis/google-cloud-java/issues/9949)) ([6557fc8](https://github.com/googleapis/google-cloud-java/commit/6557fc87ab26da76e59aa9297ef98824eba9fa2c))
* [dialogflow] Add the enable_partial_automated_agent_reply flag ([#9924](https://github.com/googleapis/google-cloud-java/issues/9924)) ([cfcf828](https://github.com/googleapis/google-cloud-java/commit/cfcf828228ac5b8355a7e24b70994298e2666958))
* [networkconnectivity] add Network Connectivity Center APIs related to VPC spokes ([#9927](https://github.com/googleapis/google-cloud-java/issues/9927)) ([2164568](https://github.com/googleapis/google-cloud-java/commit/2164568460df563f4a51d6696c39e1a8e58d68e2))
* [recaptchaenterprise] FirewallPolicy CRUD API ([#9937](https://github.com/googleapis/google-cloud-java/issues/9937)) ([3e9bd05](https://github.com/googleapis/google-cloud-java/commit/3e9bd057c7e7a613c8b5c25d69ee42a9d969d034))


### Bug Fixes

* **deps:** update dependency com.google.cloud:google-cloud-shared-config to v1.5.8 ([#9941](https://github.com/googleapis/google-cloud-java/issues/9941)) ([f818d26](https://github.com/googleapis/google-cloud-java/commit/f818d26968e1f19d302da1f1ea0145b2cc496ce0))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.17.0 ([#9942](https://github.com/googleapis/google-cloud-java/issues/9942)) ([2cc7888](https://github.com/googleapis/google-cloud-java/commit/2cc78885d76ae5e7dfc4cc9f3034c25fa22c6cc1))
* remove IoT integration tests ([#9944](https://github.com/googleapis/google-cloud-java/issues/9944)) ([237c070](https://github.com/googleapis/google-cloud-java/commit/237c070a9d0a3ecf6a25387648a4d5dd81d705c2))

## [1.21.0](https://github.com/googleapis/google-cloud-java/compare/v1.20.0...v1.21.0) (2023-09-28)


### Features

* [dialogflow-cx] add support for AdvancedSettings ([#9918](https://github.com/googleapis/google-cloud-java/issues/9918)) ([59f9d8c](https://github.com/googleapis/google-cloud-java/commit/59f9d8c7ad8fc498f13873fc2b348ea23984f87c))


### Bug Fixes

* **deps:** update dependency com.google.cloud:google-cloud-pubsub-bom to v1.125.4 ([#9915](https://github.com/googleapis/google-cloud-java/issues/9915)) ([58249cc](https://github.com/googleapis/google-cloud-java/commit/58249cca29b6a8a8b9075231c2e912a4553e5a2b))


### Documentation

* add links to rpc and rest documentation in repo-metadata.json ([#9913](https://github.com/googleapis/google-cloud-java/issues/9913)) ([453c1b7](https://github.com/googleapis/google-cloud-java/commit/453c1b77b721731cc9175d8c57b918fcd2de7be6))

## [1.20.0](https://github.com/googleapis/google-cloud-java/compare/v1.19.0...v1.20.0) (2023-09-28)


### Features

* [alloydb] Add support to generate client certificate and get connection info for auth proxy in AlloyDB v1 ([#9903](https://github.com/googleapis/google-cloud-java/issues/9903)) ([16f1b33](https://github.com/googleapis/google-cloud-java/commit/16f1b33260b142bc30511e798281c4bf85410e07))
* [dialogflow-cx] add support for AdvancedSettings ([#9905](https://github.com/googleapis/google-cloud-java/issues/9905)) ([f39cd4c](https://github.com/googleapis/google-cloud-java/commit/f39cd4ca6009c18172a2aef6c1814bb451fdfe47))
* [dialogflow] Add the enable_partial_automated_agent_reply flag ([#9906](https://github.com/googleapis/google-cloud-java/issues/9906)) ([e88fe30](https://github.com/googleapis/google-cloud-java/commit/e88fe30b5ed56f1614595cc888e44875992e6d03))


### Bug Fixes

* [run] Removes accidentally exposed field service.traffic_tags_cleanup_threshold in Cloud Run Service ([#9908](https://github.com/googleapis/google-cloud-java/issues/9908)) ([ad81708](https://github.com/googleapis/google-cloud-java/commit/ad8170803074465d8e4af3353eef3bdc31e5dad7))
* **deps:** update dependency com.google.apis:google-api-services-storage to v1-rev20230926-2.0.0 ([#9911](https://github.com/googleapis/google-cloud-java/issues/9911)) ([d7f5cc9](https://github.com/googleapis/google-cloud-java/commit/d7f5cc9e9871474e5a9b0b4d14681fe4b2f9d1bd))
* **deps:** update dependency com.google.cloud:google-cloud-pubsub-bom to v1.125.3 ([#9910](https://github.com/googleapis/google-cloud-java/issues/9910)) ([52dc784](https://github.com/googleapis/google-cloud-java/commit/52dc7849f9fbf21517c1f8a468c66a1f080122db))
* **deps:** update dependency com.google.cloud:google-cloud-pubsub-bom to v1.125.3 ([#9912](https://github.com/googleapis/google-cloud-java/issues/9912)) ([f49e2d9](https://github.com/googleapis/google-cloud-java/commit/f49e2d96183f80763e3a46e2a4a218959604ea6d))

## [1.19.0](https://github.com/googleapis/google-cloud-java/compare/v1.18.0...v1.19.0) (2023-09-27)


### Features

* [advisorynotifications] add new RPCs GetSettings, UpdateSettings and new messages Settings, NotificationSettings, GetSettingsRequest, UpdateSettingsRequest ([#9882](https://github.com/googleapis/google-cloud-java/issues/9882)) ([00babba](https://github.com/googleapis/google-cloud-java/commit/00babba91144ca0316e7dec6cad01a91a9aa28a0))
* [aiplatform] add feature.proto ([#9899](https://github.com/googleapis/google-cloud-java/issues/9899)) ([140047e](https://github.com/googleapis/google-cloud-java/commit/140047e73d507a4a17821620ed96eb9436603017))
* [alloydb] add metadata exchange support for AlloyDB beta connectors ([#9827](https://github.com/googleapis/google-cloud-java/issues/9827)) ([d1d5341](https://github.com/googleapis/google-cloud-java/commit/d1d5341998158b6eedd980bca7d6089b327d0f00))
* [alloydb] Added enum value for PG15 ([#9845](https://github.com/googleapis/google-cloud-java/issues/9845)) ([9b4dac0](https://github.com/googleapis/google-cloud-java/commit/9b4dac059922e314c2c465b89ec0673ba09bbf84))
* [analyticshub] add Subscription resource and RPCs ([#9883](https://github.com/googleapis/google-cloud-java/issues/9883)) ([17a5c8d](https://github.com/googleapis/google-cloud-java/commit/17a5c8de9555166b0e3c22d00f06f7d2249fcc13))
* [container] add SecurityPostureConfig Enterprise vuln mode to allow customers to enable Advanced Vulnerability Scanning for their clusters ([#9838](https://github.com/googleapis/google-cloud-java/issues/9838)) ([76f74c8](https://github.com/googleapis/google-cloud-java/commit/76f74c8f218f33220e846d777e3ddba8189eb6a6))
* [datacatalog]Enable Vertex AI Ingestion on DataPlex ([#9897](https://github.com/googleapis/google-cloud-java/issues/9897)) ([330056f](https://github.com/googleapis/google-cloud-java/commit/330056f3766c0fd76ee7b851ff853cd3f4eca184))
* [dataproc] add optional parameters (tarball_gcs_dir, diagnosis_interval, jobs, yarn_application_ids) in DiagnoseClusterRequest ([#9836](https://github.com/googleapis/google-cloud-java/issues/9836)) ([47f4031](https://github.com/googleapis/google-cloud-java/commit/47f40312a614c62d22e26cc3fcf35956d3c5d3ff))
* [documentai] added field Processor.processor_version_aliases ([#9863](https://github.com/googleapis/google-cloud-java/issues/9863)) ([848d53c](https://github.com/googleapis/google-cloud-java/commit/848d53c37131e0412e3224f86bcab3746d7f9544))
* [documentai] make `page_range` field public ([#9879](https://github.com/googleapis/google-cloud-java/issues/9879)) ([b63a4e5](https://github.com/googleapis/google-cloud-java/commit/b63a4e5eb905c1ea1bdad4cf03b74d9649c29748))
* [merchantapi] new module for merchantapi inventories ([#9891](https://github.com/googleapis/google-cloud-java/issues/9891)) ([3141daf](https://github.com/googleapis/google-cloud-java/commit/3141dafaaa59392d09ac9b63175b79dc77b537a2))
* [metastore] added EndpointLocation (v1, v1beta, v1alpha) ([#9898](https://github.com/googleapis/google-cloud-java/issues/9898)) ([8f538ed](https://github.com/googleapis/google-cloud-java/commit/8f538eddbb89c2a1ac3872fd209cc70aee18fe0d))
* [migrationcenter] added GenericInsight which exposes generic insights on assets ([#9843](https://github.com/googleapis/google-cloud-java/issues/9843)) ([82ca5cf](https://github.com/googleapis/google-cloud-java/commit/82ca5cf82205beae8529b025d79379cb2ff17c91))
* [networkconnectivity] add PolicyBasedRouting APIs ([#9825](https://github.com/googleapis/google-cloud-java/issues/9825)) ([26c3ef4](https://github.com/googleapis/google-cloud-java/commit/26c3ef423f514d4e98b4952f69117a8302f3daba))
* [run] Adds support for cancel Execution ([#9880](https://github.com/googleapis/google-cloud-java/issues/9880)) ([1122185](https://github.com/googleapis/google-cloud-java/commit/1122185299e33454a588035e450d6e603d84a601))
* [serviceusage] introduce resource class serviceusage.googleapis.com/Service ([#9841](https://github.com/googleapis/google-cloud-java/issues/9841)) ([59426b1](https://github.com/googleapis/google-cloud-java/commit/59426b156a78b953a0e6a5505298954299a21930))
* [shopping-merchant-reports] new module for shopping-merchant-reports ([#9896](https://github.com/googleapis/google-cloud-java/issues/9896)) ([abfd6a1](https://github.com/googleapis/google-cloud-java/commit/abfd6a1da5ad10c3c695a97806006a08eddb3680))
* [tpu] added new WAITING_FOR_RESOURCES state for QueuedResourceState ([#9855](https://github.com/googleapis/google-cloud-java/issues/9855)) ([dfd3dde](https://github.com/googleapis/google-cloud-java/commit/dfd3ddee9e5672a901b217da0a602988762f9a85))
* add `matched_token_page_indices` field in Document Warehouse API v1 ([#9886](https://github.com/googleapis/google-cloud-java/issues/9886)) ([255469c](https://github.com/googleapis/google-cloud-java/commit/255469c2d42822b88c58ccd8d17654a2666aa4c4))
* add `ROOT_FOLDER` field to Document Warehouse API v1 ([#9846](https://github.com/googleapis/google-cloud-java/issues/9846)) ([83a2e00](https://github.com/googleapis/google-cloud-java/commit/83a2e008d7b00e1d50f3942b55b242593a1e3a40))
* re-generate merchant inventories under new directory ([#9901](https://github.com/googleapis/google-cloud-java/issues/9901)) ([f26705e](https://github.com/googleapis/google-cloud-java/commit/f26705ef96d976fc55169663b5c5707276c82245))


### Bug Fixes

* [infra-manager] change the config service's Ruby namespace to avoid a collision with a base class in the Ruby client platform ([#9856](https://github.com/googleapis/google-cloud-java/issues/9856)) ([24ec31f](https://github.com/googleapis/google-cloud-java/commit/24ec31f2f588b02b5216a37ea2ef2f866ec47fcd))
* correct regex in `policy-troubleshooter`'s `OwlBot.yaml` ([#9884](https://github.com/googleapis/google-cloud-java/issues/9884)) ([724c6c1](https://github.com/googleapis/google-cloud-java/commit/724c6c1835925fa340d95de025bbbb00b7fe2668))
* **deps:** update dependency com.google.apis:google-api-services-storage to v1-rev20230922-2.0.0 ([#9842](https://github.com/googleapis/google-cloud-java/issues/9842)) ([80822cd](https://github.com/googleapis/google-cloud-java/commit/80822cd0417cde7aab7dd2cbe71763621fd2d295))
* **deps:** update dependency com.google.cloud:google-cloud-pubsub-bom to v1.125.2 ([#9833](https://github.com/googleapis/google-cloud-java/issues/9833)) ([1be75eb](https://github.com/googleapis/google-cloud-java/commit/1be75ebf7e3f58e8037cd961c3756ec0b96af357))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.16.0 ([#9866](https://github.com/googleapis/google-cloud-java/issues/9866)) ([aa36b2c](https://github.com/googleapis/google-cloud-java/commit/aa36b2c3c31b817052239fd771a21d20108b2c31))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.16.1 ([#9881](https://github.com/googleapis/google-cloud-java/issues/9881)) ([8a29511](https://github.com/googleapis/google-cloud-java/commit/8a2951166eb0305be040cc0ae38be105c437ba25))
* **deps:** update dependency com.google.cloud:google-cloud-storage to v2.27.0 ([#9834](https://github.com/googleapis/google-cloud-java/issues/9834)) ([c000864](https://github.com/googleapis/google-cloud-java/commit/c000864ab4566b1e260119fd959d35e0641fc6f7))
* **deps:** update dependency com.google.cloud:google-cloud-storage to v2.27.1 ([#9894](https://github.com/googleapis/google-cloud-java/issues/9894)) ([235df09](https://github.com/googleapis/google-cloud-java/commit/235df096081c036f9a66e00a301865035e54d791))


### Dependencies

* Remove gax-grpc from Compute ([#9864](https://github.com/googleapis/google-cloud-java/issues/9864)) ([e094b31](https://github.com/googleapis/google-cloud-java/commit/e094b3182fad9f8d9dbeca2c237d781f643710f5))


### Documentation

* [batch] update batch PD interface support ([#9888](https://github.com/googleapis/google-cloud-java/issues/9888)) ([8002742](https://github.com/googleapis/google-cloud-java/commit/8002742584f6153931dd2ceda2b03b3d9a7639b9))
* [bigquerydatatransfer] Update transferConfig.name description to indicate that it supports both formats ([#9824](https://github.com/googleapis/google-cloud-java/issues/9824)) ([6ab58e6](https://github.com/googleapis/google-cloud-java/commit/6ab58e6f2affd10023f3e591a6a23f9e8061e6ec))
* [cloudbilling] update service documentation ([#9857](https://github.com/googleapis/google-cloud-java/issues/9857)) ([15733af](https://github.com/googleapis/google-cloud-java/commit/15733af70f6c19d62042e876c93fc205165b046a))
* [documentai] update client libraries for Enterprise OCR add-ons ([#9829](https://github.com/googleapis/google-cloud-java/issues/9829)) ([86c71f8](https://github.com/googleapis/google-cloud-java/commit/86c71f88d42c5c42a68e7f81cbf0c04c6fcd6b3d))
* [rapidmigrationassessment] update comments ([#9847](https://github.com/googleapis/google-cloud-java/issues/9847)) ([fa7d672](https://github.com/googleapis/google-cloud-java/commit/fa7d67252bb528a3020245680cba5816069b65b5))

## [1.18.0](https://github.com/googleapis/google-cloud-java/compare/v1.17.0...v1.18.0) (2023-09-11)


### ⚠ BREAKING CHANGES

* Remove unused unsupported_policy_event event_type from ContinuousValidationPodEvent
* remove idle_replica_count from PersistentResource
* [analyticsadmin] rename the `enterprise_daily_export_enabled` field to `fresh_daily_export_enabled` in the `BigQueryLink` resource ([#9752](https://github.com/googleapis/google-cloud-java/issues/9752))
* add the missing `REQUIRED` annotation to the `update_mask` field of `UpdateMeasurementProtocolSecretRequest`
* [analyticsadmin] rename the `enterprise_daily_export_enabled` field to `fresh_daily_export_enabled` in the `BigQueryLink` resource
* [videostitcher] use correct child_type annotation ([#9774](https://github.com/googleapis/google-cloud-java/issues/9774))
* [analyticsadmin] rename the `enterprise_daily_export_enabled` field to `fresh_daily_export_enabled` in the `BigQueryLink` resource ([#9753](https://github.com/googleapis/google-cloud-java/issues/9753))
* add the missing `REQUIRED` annotation to the `update_mask` field of `UpdateMeasurementProtocolSecretRequest`
* [analyticsadmin] rename the `intraday_export_enabled` field to `enterprise_export_enabled`  in the `BigQueryLink` resource

### Features

* [aiplatform] add encryption_spec to index.proto and index_endpoint.proto ([#9805](https://github.com/googleapis/google-cloud-java/issues/9805)) ([1ce4fa6](https://github.com/googleapis/google-cloud-java/commit/1ce4fa6f87735c2b9d4351b0d8c542afc48e8aec))
* [aiplatform] add NVIDIA_H100_80GB and TPU_V5_LITEPOD to AcceleratorType ([48ac78c](https://github.com/googleapis/google-cloud-java/commit/48ac78c692cd145c8aafb6497b27054d069ed6ca))
* [aiplatform] add UpdatePersistentResourceRequest and add resource_pool_images and head_node_resource_pool_id to RaySpec ([#9769](https://github.com/googleapis/google-cloud-java/issues/9769)) ([48ac78c](https://github.com/googleapis/google-cloud-java/commit/48ac78c692cd145c8aafb6497b27054d069ed6ca))
* [aiplatform] update field_behavior for `name` to be IMMUTABLE instead of OUTPUT_ONLY in Context, ModelMonitor, Schedule, DeploymentResourcePool ([48ac78c](https://github.com/googleapis/google-cloud-java/commit/48ac78c692cd145c8aafb6497b27054d069ed6ca))
* [analyticsadmin] add `UpdateConversionEvent` method to the Admin API v1 beta ([12a9af7](https://github.com/googleapis/google-cloud-java/commit/12a9af79d1003572e590781988bd51700f2d41a8))
* [analyticsadmin] add `UpdateConversionEvent` method to the Admin API v1 beta ([08c1a7d](https://github.com/googleapis/google-cloud-java/commit/08c1a7d5de7de007b13c6618858890acc8c7b532))
* [batch] Add more compute resource API descriptions to match with VM's machine type field ([42b33d5](https://github.com/googleapis/google-cloud-java/commit/42b33d51fa9cdd0c2237825f009198a648e0e9c0))
* [batch] add stderr_snippet to indicate the real stderr output by runnables to the execution field of status event ([42b33d5](https://github.com/googleapis/google-cloud-java/commit/42b33d51fa9cdd0c2237825f009198a648e0e9c0))
* [batch] Clarify Batch API proto doc about pubsub notifications ([42b33d5](https://github.com/googleapis/google-cloud-java/commit/42b33d51fa9cdd0c2237825f009198a648e0e9c0))
* [bigquerydatapolicy] support using custom UDF in the data policy ([#9759](https://github.com/googleapis/google-cloud-java/issues/9759)) ([ca81520](https://github.com/googleapis/google-cloud-java/commit/ca8152000954e2299d85e17b6278a70ad1ae86ca))
* [billingbudgets] Supported project-level-budgets in Public Budget API V1 ([#9777](https://github.com/googleapis/google-cloud-java/issues/9777)) ([5fc8016](https://github.com/googleapis/google-cloud-java/commit/5fc8016ebddd7123182f1ab802daee571ea6a558))
* [billingbudgets] Supported project-level-budgets in Public Budget API V1Beta ([5fc8016](https://github.com/googleapis/google-cloud-java/commit/5fc8016ebddd7123182f1ab802daee571ea6a558))
* [binaryauthorization] Adds support for check-based platform policy evaluation to Binary Authorization Continuous Validation logs ([#9768](https://github.com/googleapis/google-cloud-java/issues/9768)) ([e434587](https://github.com/googleapis/google-cloud-java/commit/e434587eff639a1ebb08e2ec0b067514911b3dae))
* [cloudchannel] Launch QueryEligibleBillingAccounts API ([#9806](https://github.com/googleapis/google-cloud-java/issues/9806)) ([cb5f17e](https://github.com/googleapis/google-cloud-java/commit/cb5f17ea39dd511d9e9e3f9250a483c842bc0f24))
* [cloudchannel] mark ChannelPartnerGranularity as deprecated and offer alternatives ([#9807](https://github.com/googleapis/google-cloud-java/issues/9807)) ([13e9ee1](https://github.com/googleapis/google-cloud-java/commit/13e9ee123e26b31b6a24eeadf7def6abd76cd186))
* [cloudoptimization] added support for walking mode and cost_per_kilometer_below_soft_max ([#9803](https://github.com/googleapis/google-cloud-java/issues/9803)) ([52ef3cc](https://github.com/googleapis/google-cloud-java/commit/52ef3cc5b9b3f1301f7b18947ac0a5407b6d7f43))
* [confidentialcomputing] Add a new field `partial_errors` to `VerifyAttestationResponse` proto ([#9750](https://github.com/googleapis/google-cloud-java/issues/9750)) ([b898dcd](https://github.com/googleapis/google-cloud-java/commit/b898dcd352c348f8acf2aee635233a6df86bdf3e))
* [container] add APIs for GKE OOTB metrics packages ([b3fbe12](https://github.com/googleapis/google-cloud-java/commit/b3fbe124daa80410502cf6ef4c194285ba4cd272))
* [container] add APIs for GKE OOTB metrics packages ([b3fbe12](https://github.com/googleapis/google-cloud-java/commit/b3fbe124daa80410502cf6ef4c194285ba4cd272))
* [container] Add preview support for monitoring a cluster's pods for compliance with a provided Binary Authorization platform policy via Binary Authorization Continuous Validation ([b3fbe12](https://github.com/googleapis/google-cloud-java/commit/b3fbe124daa80410502cf6ef4c194285ba4cd272))
* [container] add support for NodeConfig Update ([b3fbe12](https://github.com/googleapis/google-cloud-java/commit/b3fbe124daa80410502cf6ef4c194285ba4cd272))
* [container] add UpdateNodePoolRequest.machine_type, disk_type, disk_size_gb ([#9745](https://github.com/googleapis/google-cloud-java/issues/9745)) ([b3fbe12](https://github.com/googleapis/google-cloud-java/commit/b3fbe124daa80410502cf6ef4c194285ba4cd272))
* [datamigration] Adding GenerateTcpProxyScript API ([#9799](https://github.com/googleapis/google-cloud-java/issues/9799)) ([8c2aacb](https://github.com/googleapis/google-cloud-java/commit/8c2aacb739e635b270b4cb970e0aae4104671b4e))
* [dataproc] support min_num_instances for primary worker and InstanceFlexibilityPolicy for secondary worker ([#9775](https://github.com/googleapis/google-cloud-java/issues/9775)) ([6e23c3a](https://github.com/googleapis/google-cloud-java/commit/6e23c3a406e19af410a1a1dd0d0487329875040e))
* [dialogflow-cx] added generative AI, safety/security and speech endpointing settings ([#9751](https://github.com/googleapis/google-cloud-java/issues/9751)) ([c1e969e](https://github.com/googleapis/google-cloud-java/commit/c1e969ee2d5dcead33ec5069b3bb7cf379d18559))
* [dialogflow] added baseline model version used to generate the summary ([411a707](https://github.com/googleapis/google-cloud-java/commit/411a707e2bf040ffeab897518d2d4781512012ca))
* [dialogflow] added baseline model version used to generate the summary ([411a707](https://github.com/googleapis/google-cloud-java/commit/411a707e2bf040ffeab897518d2d4781512012ca))
* [dialogflow] added speech endpointing setting ([411a707](https://github.com/googleapis/google-cloud-java/commit/411a707e2bf040ffeab897518d2d4781512012ca))
* [dialogflow] added speech endpointing setting ([#9760](https://github.com/googleapis/google-cloud-java/issues/9760)) ([411a707](https://github.com/googleapis/google-cloud-java/commit/411a707e2bf040ffeab897518d2d4781512012ca))
* [discoveryengine] support conversational / multi-turn search ([#9786](https://github.com/googleapis/google-cloud-java/issues/9786)) ([ea37f15](https://github.com/googleapis/google-cloud-java/commit/ea37f15e3d203779038230f7845b8014ebdca960))
* [discoveryengine] supported bring your own embedding feature ([ea37f15](https://github.com/googleapis/google-cloud-java/commit/ea37f15e3d203779038230f7845b8014ebdca960))
* [file] add SecurityFlavor to NfsExportOptions ([#9773](https://github.com/googleapis/google-cloud-java/issues/9773)) ([7619e47](https://github.com/googleapis/google-cloud-java/commit/7619e47f0df0bb5a42eb5b2a728096c67b31b507))
* [gameservices] Remove the gameservices APIs ([#9787](https://github.com/googleapis/google-cloud-java/issues/9787)) ([4a8106d](https://github.com/googleapis/google-cloud-java/commit/4a8106df19a7d00c1e6af3cb078929e2cec5d366))
* [infra-manager] new module for infra-manager ([#9802](https://github.com/googleapis/google-cloud-java/issues/9802)) ([3d82fb4](https://github.com/googleapis/google-cloud-java/commit/3d82fb4b24e210ad06eb5b1b9b2599a0326b0a20))
* [language] Add support for the v2 API ([#9758](https://github.com/googleapis/google-cloud-java/issues/9758)) ([c713970](https://github.com/googleapis/google-cloud-java/commit/c7139704e3de3b67a750c763419e08569ff7d494))
* [monitoring] Added support for retriggering notifications in AlertPolicy ([#9823](https://github.com/googleapis/google-cloud-java/issues/9823)) ([b1910b1](https://github.com/googleapis/google-cloud-java/commit/b1910b13fd24531e65b1ff8e9804a6d25b4ce2ae))
* [networkmanagement] add dynamic probing fields to v1 API ([8f6b372](https://github.com/googleapis/google-cloud-java/commit/8f6b372ad1d4d2f28cc3edf87aefe85ff0d66a99))
* [networkmanagement] add fields related to Google services to API ([8f6b372](https://github.com/googleapis/google-cloud-java/commit/8f6b372ad1d4d2f28cc3edf87aefe85ff0d66a99))
* [networkmanagement] add fields related to load balancers to API ([8f6b372](https://github.com/googleapis/google-cloud-java/commit/8f6b372ad1d4d2f28cc3edf87aefe85ff0d66a99))
* [networkmanagement] add fields related to PBR and NCC routes to API ([8f6b372](https://github.com/googleapis/google-cloud-java/commit/8f6b372ad1d4d2f28cc3edf87aefe85ff0d66a99))
* [networkmanagement] add new abort and drop causes to API ([8f6b372](https://github.com/googleapis/google-cloud-java/commit/8f6b372ad1d4d2f28cc3edf87aefe85ff0d66a99))
* [networkmanagement] add new enum values for network firewall policies to API ([#9749](https://github.com/googleapis/google-cloud-java/issues/9749)) ([8f6b372](https://github.com/googleapis/google-cloud-java/commit/8f6b372ad1d4d2f28cc3edf87aefe85ff0d66a99))
* [recommender] Add MarkRecommendationDismissed method ([#9791](https://github.com/googleapis/google-cloud-java/issues/9791)) ([b6c0df2](https://github.com/googleapis/google-cloud-java/commit/b6c0df298b039b4408e22224b1f45eabb433b412))
* [recommender] ListRecommenders and ListInsightTypes RPC methods ([#9798](https://github.com/googleapis/google-cloud-java/issues/9798)) ([aeb0588](https://github.com/googleapis/google-cloud-java/commit/aeb0588ccafcc245ad5f87bd3183ee88b5776c90))
* [tpu] Add ResetQueueResource to the TPU service ([#9748](https://github.com/googleapis/google-cloud-java/issues/9748)) ([9996b84](https://github.com/googleapis/google-cloud-java/commit/9996b84fec92ffb26bf3fa364e5010fc332a0e30))
* [tpu] publish boot_disk_config to support CHD with KMS ([#9795](https://github.com/googleapis/google-cloud-java/issues/9795)) ([87fc3d3](https://github.com/googleapis/google-cloud-java/commit/87fc3d3c8055b57c45582c43f4cb4e363d9fcec3))
* [workflowexecutions] add UNAVAILABLE and QUEUED to state enum ([#9771](https://github.com/googleapis/google-cloud-java/issues/9771)) ([f12a188](https://github.com/googleapis/google-cloud-java/commit/f12a18814bf2c1df4391080dcf14ebc872060064))
* [workflows] add UNAVAILABLE to state enum of workflow deployment ([#9767](https://github.com/googleapis/google-cloud-java/issues/9767)) ([d21a74c](https://github.com/googleapis/google-cloud-java/commit/d21a74cf5a41c3f1e2ef7c71bc0d23170b72ea4a))
* [workstations] add config service_account_scopes ([#9790](https://github.com/googleapis/google-cloud-java/issues/9790)) ([c087490](https://github.com/googleapis/google-cloud-java/commit/c087490cdbf264f65a23c9347b75cb6fbba30450))
* add `CoarseValue`, `ConversionValues`, `EventMapping`, `SKAdNetworkConversionValueSchema` types ([12a9af7](https://github.com/googleapis/google-cloud-java/commit/12a9af79d1003572e590781988bd51700f2d41a8))
* add `CoarseValue`, `ConversionValues`, `EventMapping`, `SKAdNetworkConversionValueSchema` types ([08c1a7d](https://github.com/googleapis/google-cloud-java/commit/08c1a7d5de7de007b13c6618858890acc8c7b532))
* add `disposition_time`, `legal_hold`, `document_is_retention_folder`, `document_is_legal_hold_folder`, `question_answer`, `document_name_filter` field to Document Warehouse API v1 ([1453bc7](https://github.com/googleapis/google-cloud-java/commit/1453bc7dfa863a9bc436d614e5f500b729367b35))
* add `GetSKAdNetworkConversionValueSchema`, `CreateSKAdNetworkConversionValueSchema`, `DeleteSKAdNetworkConversionValueSchema`, `UpdateSKAdNetworkConversionValueSchema`, `ListSKAdNetworkConversionValueSchemas` methods to the Admin API v1 alpha ([12a9af7](https://github.com/googleapis/google-cloud-java/commit/12a9af79d1003572e590781988bd51700f2d41a8))
* add `GetSKAdNetworkConversionValueSchema`, `CreateSKAdNetworkConversionValueSchema`, `DeleteSKAdNetworkConversionValueSchema`, `UpdateSKAdNetworkConversionValueSchema`, `ListSKAdNetworkConversionValueSchemas` methods to the Admin API v1 alpha ([08c1a7d](https://github.com/googleapis/google-cloud-java/commit/08c1a7d5de7de007b13c6618858890acc8c7b532))
* add `ON_CREATE_LINK`, `ON_DELETE_LINK` fields to support new rule engine triggers in Document Warehouse API v1 ([1453bc7](https://github.com/googleapis/google-cloud-java/commit/1453bc7dfa863a9bc436d614e5f500b729367b35))
* add `UpdateConversionEvent` method to the Admin API v1 alpha ([12a9af7](https://github.com/googleapis/google-cloud-java/commit/12a9af79d1003572e590781988bd51700f2d41a8))
* add `UpdateConversionEvent` method to the Admin API v1 alpha ([08c1a7d](https://github.com/googleapis/google-cloud-java/commit/08c1a7d5de7de007b13c6618858890acc8c7b532))
* add Batch Managed Container support for v1alpha ([42b33d5](https://github.com/googleapis/google-cloud-java/commit/42b33d51fa9cdd0c2237825f009198a648e0e9c0))
* add Batch Managed Container support for v1alpha ([42b33d5](https://github.com/googleapis/google-cloud-java/commit/42b33d51fa9cdd0c2237825f009198a648e0e9c0))
* add CountTokens to PredictionService ([48ac78c](https://github.com/googleapis/google-cloud-java/commit/48ac78c692cd145c8aafb6497b27054d069ed6ca))
* add DirectoryServicesConfig to Instance ([7619e47](https://github.com/googleapis/google-cloud-java/commit/7619e47f0df0bb5a42eb5b2a728096c67b31b507))
* add disk_type and disk_size_gb to PersistentDiskSpec ([48ac78c](https://github.com/googleapis/google-cloud-java/commit/48ac78c692cd145c8aafb6497b27054d069ed6ca))
* add disk_type and disk_size_gb to PersistentDiskSpec ([48ac78c](https://github.com/googleapis/google-cloud-java/commit/48ac78c692cd145c8aafb6497b27054d069ed6ca))
* add FileProtocol to Instance ([7619e47](https://github.com/googleapis/google-cloud-java/commit/7619e47f0df0bb5a42eb5b2a728096c67b31b507))
* add filter and order_by fields to ListExecutionsRequest ([f12a188](https://github.com/googleapis/google-cloud-java/commit/f12a18814bf2c1df4391080dcf14ebc872060064))
* add INVALID state to Backup ([7619e47](https://github.com/googleapis/google-cloud-java/commit/7619e47f0df0bb5a42eb5b2a728096c67b31b507))
* add LOG_NONE to call_log_level ([f12a188](https://github.com/googleapis/google-cloud-java/commit/f12a18814bf2c1df4391080dcf14ebc872060064))
* Add MultiNodeParams in TPU ([9996b84](https://github.com/googleapis/google-cloud-java/commit/9996b84fec92ffb26bf3fa364e5010fc332a0e30))
* add new Instance state values ([2b3e915](https://github.com/googleapis/google-cloud-java/commit/2b3e9157e3f931833e6269555934941103e5e8bf))
* add NFSShare resource and methods ([2b3e915](https://github.com/googleapis/google-cloud-java/commit/2b3e9157e3f931833e6269555934941103e5e8bf))
* add open_evaluation_pipeline to PublisherModel ([48ac78c](https://github.com/googleapis/google-cloud-java/commit/48ac78c692cd145c8aafb6497b27054d069ed6ca))
* add open_evaluation_pipeline to PublisherModel ([48ac78c](https://github.com/googleapis/google-cloud-java/commit/48ac78c692cd145c8aafb6497b27054d069ed6ca))
* add OsImage resource and methods ([2b3e915](https://github.com/googleapis/google-cloud-java/commit/2b3e9157e3f931833e6269555934941103e5e8bf))
* add Parent to PublisherModel ([48ac78c](https://github.com/googleapis/google-cloud-java/commit/48ac78c692cd145c8aafb6497b27054d069ed6ca))
* add Pipeline Service to Document Warehouse API v1 ([#9757](https://github.com/googleapis/google-cloud-java/issues/9757)) ([1453bc7](https://github.com/googleapis/google-cloud-java/commit/1453bc7dfa863a9bc436d614e5f500b729367b35))
* add ProvisioningConfig resource and methods ([2b3e915](https://github.com/googleapis/google-cloud-java/commit/2b3e9157e3f931833e6269555934941103e5e8bf))
* add ReadTensorboardSize to TensorboardService ([48ac78c](https://github.com/googleapis/google-cloud-java/commit/48ac78c692cd145c8aafb6497b27054d069ed6ca))
* add RPC EvictLune ([2b3e915](https://github.com/googleapis/google-cloud-java/commit/2b3e9157e3f931833e6269555934941103e5e8bf))
* add RPCs Enable/Disable InteractiveSerialConsole ([2b3e915](https://github.com/googleapis/google-cloud-java/commit/2b3e9157e3f931833e6269555934941103e5e8bf))
* add RPCs Rename/Evict Volume ([2b3e915](https://github.com/googleapis/google-cloud-java/commit/2b3e9157e3f931833e6269555934941103e5e8bf))
* add schedule_name to PipelineJob ([48ac78c](https://github.com/googleapis/google-cloud-java/commit/48ac78c692cd145c8aafb6497b27054d069ed6ca))
* add schedule_name to PipelineJob ([48ac78c](https://github.com/googleapis/google-cloud-java/commit/48ac78c692cd145c8aafb6497b27054d069ed6ca))
* add SSHKey resource and methods ([2b3e915](https://github.com/googleapis/google-cloud-java/commit/2b3e9157e3f931833e6269555934941103e5e8bf))
* add status, labels, duration and state_error fields to Execution ([f12a188](https://github.com/googleapis/google-cloud-java/commit/f12a18814bf2c1df4391080dcf14ebc872060064))
* add the `ConversionCountingMethod` enum ([12a9af7](https://github.com/googleapis/google-cloud-java/commit/12a9af79d1003572e590781988bd51700f2d41a8))
* add the `ConversionCountingMethod` enum ([12a9af7](https://github.com/googleapis/google-cloud-java/commit/12a9af79d1003572e590781988bd51700f2d41a8))
* add the `ConversionCountingMethod` enum ([08c1a7d](https://github.com/googleapis/google-cloud-java/commit/08c1a7d5de7de007b13c6618858890acc8c7b532))
* add the `ConversionCountingMethod` enum ([08c1a7d](https://github.com/googleapis/google-cloud-java/commit/08c1a7d5de7de007b13c6618858890acc8c7b532))
* add the `counting_method` field to the `ConversionEvent` type ([12a9af7](https://github.com/googleapis/google-cloud-java/commit/12a9af79d1003572e590781988bd51700f2d41a8))
* add the `counting_method` field to the `ConversionEvent` type ([12a9af7](https://github.com/googleapis/google-cloud-java/commit/12a9af79d1003572e590781988bd51700f2d41a8))
* add the `counting_method` field to the `ConversionEvent` type ([08c1a7d](https://github.com/googleapis/google-cloud-java/commit/08c1a7d5de7de007b13c6618858890acc8c7b532))
* add the `counting_method` field to the `ConversionEvent` type ([08c1a7d](https://github.com/googleapis/google-cloud-java/commit/08c1a7d5de7de007b13c6618858890acc8c7b532))
* add the `ITEM` option to the `DimensionScope` enum ([12a9af7](https://github.com/googleapis/google-cloud-java/commit/12a9af79d1003572e590781988bd51700f2d41a8))
* add the `ITEM` option to the `DimensionScope` enum ([08c1a7d](https://github.com/googleapis/google-cloud-java/commit/08c1a7d5de7de007b13c6618858890acc8c7b532))
* add the `skadnetwork_conversion_value_schema` field to the `ChangeHistoryResource.resource` oneof type ([12a9af7](https://github.com/googleapis/google-cloud-java/commit/12a9af79d1003572e590781988bd51700f2d41a8))
* add the `skadnetwork_conversion_value_schema` field to the `ChangeHistoryResource.resource` oneof type ([08c1a7d](https://github.com/googleapis/google-cloud-java/commit/08c1a7d5de7de007b13c6618858890acc8c7b532))
* add the `SKADNETWORK_CONVERSION_VALUE_SCHEMA` option to the `ChangeHistoryResourceType` enum ([12a9af7](https://github.com/googleapis/google-cloud-java/commit/12a9af79d1003572e590781988bd51700f2d41a8))
* add the `SKADNETWORK_CONVERSION_VALUE_SCHEMA` option to the `ChangeHistoryResourceType` enum ([08c1a7d](https://github.com/googleapis/google-cloud-java/commit/08c1a7d5de7de007b13c6618858890acc8c7b532))
* add Timestamp to Feature ([48ac78c](https://github.com/googleapis/google-cloud-java/commit/48ac78c692cd145c8aafb6497b27054d069ed6ca))
* add VolumeSnapshot resource and methods ([2b3e915](https://github.com/googleapis/google-cloud-java/commit/2b3e9157e3f931833e6269555934941103e5e8bf))
* add ZONAL tier to Instance ([7619e47](https://github.com/googleapis/google-cloud-java/commit/7619e47f0df0bb5a42eb5b2a728096c67b31b507))
* added iam troubleshooter v3 and v3beta api clients ([#9800](https://github.com/googleapis/google-cloud-java/issues/9800)) ([668032f](https://github.com/googleapis/google-cloud-java/commit/668032fad3d8a98058da9e214df9dae7168e53d7))
* added Knowledge Search API ([411a707](https://github.com/googleapis/google-cloud-java/commit/411a707e2bf040ffeab897518d2d4781512012ca))
* added Knowledge Search API ([411a707](https://github.com/googleapis/google-cloud-java/commit/411a707e2bf040ffeab897518d2d4781512012ca))
* added more options for search extractive content support ([ea37f15](https://github.com/googleapis/google-cloud-java/commit/ea37f15e3d203779038230f7845b8014ebdca960))
* added more skip reasons and details for search summarization ([ea37f15](https://github.com/googleapis/google-cloud-java/commit/ea37f15e3d203779038230f7845b8014ebdca960))
* added query expansion details in search response ([ea37f15](https://github.com/googleapis/google-cloud-java/commit/ea37f15e3d203779038230f7845b8014ebdca960))
* added query expansion details in search response ([ea37f15](https://github.com/googleapis/google-cloud-java/commit/ea37f15e3d203779038230f7845b8014ebdca960))
* added the platform of the virtual agent response messages ([411a707](https://github.com/googleapis/google-cloud-java/commit/411a707e2bf040ffeab897518d2d4781512012ca))
* added the platform of the virtual agent response messages ([411a707](https://github.com/googleapis/google-cloud-java/commit/411a707e2bf040ffeab897518d2d4781512012ca))
* Adds support for communicating configuration issues that prevent Continuous Validation from monitoring pods ([e434587](https://github.com/googleapis/google-cloud-java/commit/e434587eff639a1ebb08e2ec0b067514911b3dae))
* allow uri in user events ([ea37f15](https://github.com/googleapis/google-cloud-java/commit/ea37f15e3d203779038230f7845b8014ebdca960))
* allow uri in user events ([ea37f15](https://github.com/googleapis/google-cloud-java/commit/ea37f15e3d203779038230f7845b8014ebdca960))
* **baremetalsolution:** several new resources and RPCs ([2b3e915](https://github.com/googleapis/google-cloud-java/commit/2b3e9157e3f931833e6269555934941103e5e8bf))
* deprecate DB_CLOUD_SQL_POSTGRES in Document Warehouse API v1 ([1453bc7](https://github.com/googleapis/google-cloud-java/commit/1453bc7dfa863a9bc436d614e5f500b729367b35))
* Expose CreateDatasetVersionOperationMetadata and RestoreDatasetVersionOperationMetadata to DatasetService ([48ac78c](https://github.com/googleapis/google-cloud-java/commit/48ac78c692cd145c8aafb6497b27054d069ed6ca))
* Expose CreateDatasetVersionOperationMetadata and RestoreDatasetVersionOperationMetadata to DatasetService ([48ac78c](https://github.com/googleapis/google-cloud-java/commit/48ac78c692cd145c8aafb6497b27054d069ed6ca))
* make the field `default_uri` of `WebStreamData` mutable ([12a9af7](https://github.com/googleapis/google-cloud-java/commit/12a9af79d1003572e590781988bd51700f2d41a8))
* make the field `default_uri` of `WebStreamData` mutable ([08c1a7d](https://github.com/googleapis/google-cloud-java/commit/08c1a7d5de7de007b13c6618858890acc8c7b532))
* publicize tpu topology in v1 API ([b3fbe12](https://github.com/googleapis/google-cloud-java/commit/b3fbe124daa80410502cf6ef4c194285ba4cd272))
* support bring your own embedding feature ([ea37f15](https://github.com/googleapis/google-cloud-java/commit/ea37f15e3d203779038230f7845b8014ebdca960))
* support image search ([ea37f15](https://github.com/googleapis/google-cloud-java/commit/ea37f15e3d203779038230f7845b8014ebdca960))
* support search summarization ([ea37f15](https://github.com/googleapis/google-cloud-java/commit/ea37f15e3d203779038230f7845b8014ebdca960))
* support structural search features ([ea37f15](https://github.com/googleapis/google-cloud-java/commit/ea37f15e3d203779038230f7845b8014ebdca960))
* support tail suggestions in completion API ([ea37f15](https://github.com/googleapis/google-cloud-java/commit/ea37f15e3d203779038230f7845b8014ebdca960))
* update field_behavior for `name` to be IMMUTABLE instead of OUTPUT_ONLY in Context, ModelMonitor, Schedule, DeploymentResourcePool ([48ac78c](https://github.com/googleapis/google-cloud-java/commit/48ac78c692cd145c8aafb6497b27054d069ed6ca))
* updated summarization interface for multi-turn search ([ea37f15](https://github.com/googleapis/google-cloud-java/commit/ea37f15e3d203779038230f7845b8014ebdca960))


### Bug Fixes

* [analyticsadmin] rename the `enterprise_daily_export_enabled` field to `fresh_daily_export_enabled` in the `BigQueryLink` resource ([12a9af7](https://github.com/googleapis/google-cloud-java/commit/12a9af79d1003572e590781988bd51700f2d41a8))
* [analyticsadmin] rename the `enterprise_daily_export_enabled` field to `fresh_daily_export_enabled` in the `BigQueryLink` resource ([#9752](https://github.com/googleapis/google-cloud-java/issues/9752)) ([12a9af7](https://github.com/googleapis/google-cloud-java/commit/12a9af79d1003572e590781988bd51700f2d41a8))
* [analyticsadmin] rename the `enterprise_daily_export_enabled` field to `fresh_daily_export_enabled` in the `BigQueryLink` resource ([#9753](https://github.com/googleapis/google-cloud-java/issues/9753)) ([08c1a7d](https://github.com/googleapis/google-cloud-java/commit/08c1a7d5de7de007b13c6618858890acc8c7b532))
* [analyticsadmin] rename the `intraday_export_enabled` field to `enterprise_export_enabled`  in the `BigQueryLink` resource ([08c1a7d](https://github.com/googleapis/google-cloud-java/commit/08c1a7d5de7de007b13c6618858890acc8c7b532))
* [bigquerydatapolicy] sync the new PredefinedExpression types to the client library ([ca81520](https://github.com/googleapis/google-cloud-java/commit/ca8152000954e2299d85e17b6278a70ad1ae86ca))
* [cloudbilling] fixed resource_reference for name in GetProjectBillingInfo ([#9778](https://github.com/googleapis/google-cloud-java/issues/9778)) ([acfa7dc](https://github.com/googleapis/google-cloud-java/commit/acfa7dc1a6ae637ea148d21753ebcb49dbb90b74))
* [dialogflow-cx] Fix Ruby namespaces for generative AI classes ([#9813](https://github.com/googleapis/google-cloud-java/issues/9813)) ([0a2b63a](https://github.com/googleapis/google-cloud-java/commit/0a2b63a31be97490ecbfa9951134193514f08760))
* [videostitcher] use correct child_type annotation ([#9774](https://github.com/googleapis/google-cloud-java/issues/9774)) ([8414126](https://github.com/googleapis/google-cloud-java/commit/84141269f69deef3b57128570e609aacad1428ba))
* add the missing `REQUIRED` annotation to the `update_mask` field of `UpdateMeasurementProtocolSecretRequest` ([12a9af7](https://github.com/googleapis/google-cloud-java/commit/12a9af79d1003572e590781988bd51700f2d41a8))
* add the missing `REQUIRED` annotation to the `update_mask` field of `UpdateMeasurementProtocolSecretRequest` ([08c1a7d](https://github.com/googleapis/google-cloud-java/commit/08c1a7d5de7de007b13c6618858890acc8c7b532))
* **deps:** update dependency com.google.apis:google-api-services-cloudresourcemanager to v1-rev20230806-2.0.0 ([#9746](https://github.com/googleapis/google-cloud-java/issues/9746)) ([8ac1a59](https://github.com/googleapis/google-cloud-java/commit/8ac1a59edb4418cdb40f0f74bae5c4b49c152b54))
* **deps:** update dependency com.google.apis:google-api-services-dns to v1-rev20230807-2.0.0 ([#9754](https://github.com/googleapis/google-cloud-java/issues/9754)) ([65b8f95](https://github.com/googleapis/google-cloud-java/commit/65b8f95c4c6aa664dd0bff291f2f5767e3b0c41e))
* **deps:** update dependency com.google.apis:google-api-services-dns to v1-rev20230831-2.0.0 ([#9821](https://github.com/googleapis/google-cloud-java/issues/9821)) ([6933caf](https://github.com/googleapis/google-cloud-java/commit/6933caf753e04fb00e692bb40513d9b6b5c3d64d))
* **deps:** update dependency com.google.apis:google-api-services-storage to v1-rev20230710-2.0.0 ([#9761](https://github.com/googleapis/google-cloud-java/issues/9761)) ([a20135f](https://github.com/googleapis/google-cloud-java/commit/a20135f09db6a63ff0ff3739b74f6590e0b88740))
* **deps:** update dependency com.google.apis:google-api-services-storage to v1-rev20230907-2.0.0 ([#9822](https://github.com/googleapis/google-cloud-java/issues/9822)) ([56c3b6c](https://github.com/googleapis/google-cloud-java/commit/56c3b6c7195a01e8e215c9ccca68a98e9006aafe))
* **deps:** update dependency com.google.cloud:google-cloud-pubsub-bom to v1.124.2 ([#9733](https://github.com/googleapis/google-cloud-java/issues/9733)) ([85a5366](https://github.com/googleapis/google-cloud-java/commit/85a5366c044b47832fcd35542ee2b1df8e5d6f4c))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.15.0 ([#9809](https://github.com/googleapis/google-cloud-java/issues/9809)) ([09dbd85](https://github.com/googleapis/google-cloud-java/commit/09dbd855f683b40a462c4f918511bee4671e0174))
* **deps:** update dependency com.google.cloud:google-cloud-storage to v2.26.1 ([#9735](https://github.com/googleapis/google-cloud-java/issues/9735)) ([a3f2406](https://github.com/googleapis/google-cloud-java/commit/a3f240656d895c743820b8d1df6def7d1ba4b009))
* remove idle_replica_count from PersistentResource ([48ac78c](https://github.com/googleapis/google-cloud-java/commit/48ac78c692cd145c8aafb6497b27054d069ed6ca))
* Remove unused unsupported_policy_event event_type from ContinuousValidationPodEvent ([e434587](https://github.com/googleapis/google-cloud-java/commit/e434587eff639a1ebb08e2ec0b067514911b3dae))


### Documentation

* [batch] Revert HTML formats in comments ([42b33d5](https://github.com/googleapis/google-cloud-java/commit/42b33d51fa9cdd0c2237825f009198a648e0e9c0))
* [batch] Update description on size_gb in disk field ([42b33d5](https://github.com/googleapis/google-cloud-java/commit/42b33d51fa9cdd0c2237825f009198a648e0e9c0))
* [batch] Update description on size_gb in disk field ([#9744](https://github.com/googleapis/google-cloud-java/issues/9744)) ([42b33d5](https://github.com/googleapis/google-cloud-java/commit/42b33d51fa9cdd0c2237825f009198a648e0e9c0))
* [cloudkms] Minor formatting ([#9785](https://github.com/googleapis/google-cloud-java/issues/9785)) ([41e7eac](https://github.com/googleapis/google-cloud-java/commit/41e7eac13f452c989e42d8dfe2d8ee56f88ac5f1))
* [cloudkms] Minor formatting ([#9794](https://github.com/googleapis/google-cloud-java/issues/9794)) ([ab08654](https://github.com/googleapis/google-cloud-java/commit/ab086542826d7c0c75af03c34bfd2e50f4ffbd9c))
* [cloudoptimization] Minor formatting ([f07db1b](https://github.com/googleapis/google-cloud-java/commit/f07db1b2887582f676fb94e4fd8fd5198442a01b))
* [cloudoptimization] Minor formatting fix ([#9770](https://github.com/googleapis/google-cloud-java/issues/9770)) ([f07db1b](https://github.com/googleapis/google-cloud-java/commit/f07db1b2887582f676fb94e4fd8fd5198442a01b))
* [datacatalog] fix typo ([#9779](https://github.com/googleapis/google-cloud-java/issues/9779)) ([1285e8d](https://github.com/googleapis/google-cloud-java/commit/1285e8d1ee812be4f64d2ecfc958ed2a1b291e37))
* [storageinsights] Add link to documentation for ReportConfig proto fields ([#9756](https://github.com/googleapis/google-cloud-java/issues/9756)) ([bca9597](https://github.com/googleapis/google-cloud-java/commit/bca95978869eb75c4492ac6db66577f85f4e1151))
* Clarify Batch API proto doc about pubsub notifications ([42b33d5](https://github.com/googleapis/google-cloud-java/commit/42b33d51fa9cdd0c2237825f009198a648e0e9c0))
* Expand compute resource API docs to match with VM's machine type field ([42b33d5](https://github.com/googleapis/google-cloud-java/commit/42b33d51fa9cdd0c2237825f009198a648e0e9c0))
* keep the API doc up-to-date with recent changes ([ea37f15](https://github.com/googleapis/google-cloud-java/commit/ea37f15e3d203779038230f7845b8014ebdca960))
* keep the API doc up-to-date with recent changes ([ea37f15](https://github.com/googleapis/google-cloud-java/commit/ea37f15e3d203779038230f7845b8014ebdca960))
* update comments ([42b33d5](https://github.com/googleapis/google-cloud-java/commit/42b33d51fa9cdd0c2237825f009198a648e0e9c0))

## [1.17.0](https://github.com/googleapis/google-cloud-java/compare/v1.16.0...v1.17.0) (2023-08-08)


### ⚠ BREAKING CHANGES

* [analyticsadmin] update the `ReportingAttributionModel` enum to rename `CROSS_CHANNEL_DATA_DRIVEN` to `PAID_AND_ORGANIC_CHANNELS_DATA_DRIVEN`, `CROSS_CHANNEL_LAST_CLICK` to `PAID_AND_ORGANIC_CHANNELS_LAST_CLICK`, `CROSS_CHANNEL_FIRST_CLICK` to `P... ([#9705](https://github.com/googleapis/google-cloud-java/issues/9705))
* [analyticsadmin] update the `ReportingAttributionModel` enum to rename `CROSS_CHANNEL_DATA_DRIVEN` to `PAID_AND_ORGANIC_CHANNELS_DATA_DRIVEN`, `CROSS_CHANNEL_LAST_CLICK` to `PAID_AND_ORGANIC_CHANNELS_LAST_CLICK`, `CROSS_CHANNEL_FIRST_CLICK` to `P... ([#9706](https://github.com/googleapis/google-cloud-java/issues/9706))

### Features

* [advisorynotifications] adding notification types to advisorynotifications.googleapis.com libraries ([#9716](https://github.com/googleapis/google-cloud-java/issues/9716)) ([43f4842](https://github.com/googleapis/google-cloud-java/commit/43f4842a52887a0a8975a149903cecf50addce16))
* [aiplatform] add RaySepc to ResourceRuntimeSpec, and add ResourceRuntime to PersistentResource ([#9674](https://github.com/googleapis/google-cloud-java/issues/9674)) ([f7a6838](https://github.com/googleapis/google-cloud-java/commit/f7a683858ec4ff81e92828b39a683d6117c6b936))
* [alloydb connectors] new module for alloydb connectors ([#9737](https://github.com/googleapis/google-cloud-java/issues/9737)) ([bb4271e](https://github.com/googleapis/google-cloud-java/commit/bb4271e1c378c9ea2ce4540ccea2608f89b2506a))
* [batch] Add comment to the unsupported order_by field of ListTasksRequest ([#9684](https://github.com/googleapis/google-cloud-java/issues/9684)) ([c27566e](https://github.com/googleapis/google-cloud-java/commit/c27566e930b4165a6a468351021c222d677478c8))
* [batch] Clarify Batch API proto doc about pubsub notifications ([#9741](https://github.com/googleapis/google-cloud-java/issues/9741)) ([e580ede](https://github.com/googleapis/google-cloud-java/commit/e580ede1be613ac684f4d24f1c9c6d6a392f00b8))
* [bigquerydatatransfer] add EncryptionConfiguration to TransferConfig ([#9717](https://github.com/googleapis/google-cloud-java/issues/9717)) ([dbed6d2](https://github.com/googleapis/google-cloud-java/commit/dbed6d20bbdf0a4345a6fafceb1b02891d49c4e2))
* [cloudbuild] add update_mask to UpdateBuildTriggerRequest proto ([#9704](https://github.com/googleapis/google-cloud-java/issues/9704)) ([4659951](https://github.com/googleapis/google-cloud-java/commit/46599512aac9c0bf6974a6e74287ae979affdcb2))
* [cloudcommerceconsumerprocurement] Consumer Procurement API v1 ([#9681](https://github.com/googleapis/google-cloud-java/issues/9681)) ([4814ee4](https://github.com/googleapis/google-cloud-java/commit/4814ee44b6db283493e72de5dc3b2bddcf079162))
* [clouddeploy] added support for predeploy and postdeploy actions ([#9708](https://github.com/googleapis/google-cloud-java/issues/9708)) ([46dcfbe](https://github.com/googleapis/google-cloud-java/commit/46dcfbe8cf32a1364f528eb1257e7544fc116770))
* [compute] Update Compute Engine API to revision 20230711 ([#836](https://github.com/googleapis/google-cloud-java/issues/836)) ([#9696](https://github.com/googleapis/google-cloud-java/issues/9696)) ([0f6b9f2](https://github.com/googleapis/google-cloud-java/commit/0f6b9f21720123573e15449b618244d399d9e810))
* [confidentialcomputing] Added support for signed container image and custom audience and nonce requests ([#9701](https://github.com/googleapis/google-cloud-java/issues/9701)) ([c5c0b87](https://github.com/googleapis/google-cloud-java/commit/c5c0b87ada2ba59b1e7470ee982f642b2c50f6ba))
* [confidentialcomputing] Mark all fields `Optional` for `ContainerImageSignagure` proto ([#9736](https://github.com/googleapis/google-cloud-java/issues/9736)) ([39a8e82](https://github.com/googleapis/google-cloud-java/commit/39a8e8228258008df917af31669fab03d7771329))
* [container] add policy_name to PlacementPolicy message within a node pool ([#9676](https://github.com/googleapis/google-cloud-java/issues/9676)) ([a0715a8](https://github.com/googleapis/google-cloud-java/commit/a0715a816cb259e4518d97b243cfd357a3581078))
* [datacatalog] add support for admin_search in SearchCatalog() API method ([#9728](https://github.com/googleapis/google-cloud-java/issues/9728)) ([aee140e](https://github.com/googleapis/google-cloud-java/commit/aee140e0e4c22465129d4eab682c0112154be7fd))
* [dataplex] new service DataTaxonomyService and related messages ([#9688](https://github.com/googleapis/google-cloud-java/issues/9688)) ([205f373](https://github.com/googleapis/google-cloud-java/commit/205f373a32667b27a5f57f88adcb3245262a8f99))
* [datastream] Add precision and scale to MysqlColumn ([#9677](https://github.com/googleapis/google-cloud-java/issues/9677)) ([fd13336](https://github.com/googleapis/google-cloud-java/commit/fd13336adfd4a549e8a1995cf713e14027af4ab3))
* [discoveryengine] support conversational / multi-turn search ([#9710](https://github.com/googleapis/google-cloud-java/issues/9710)) ([e1fba2b](https://github.com/googleapis/google-cloud-java/commit/e1fba2bf5f4f308905eecc0ba9b234fc167dcf09))
* [documentai] exposed Import PV external_processor_version_source to v1beta3 public ([#9697](https://github.com/googleapis/google-cloud-java/issues/9697)) ([3e685df](https://github.com/googleapis/google-cloud-java/commit/3e685dfd3de05c408992f6fcae72dae6b35e02ff))
* [netapp] add initial version of NetApp v1 APIs ([#9713](https://github.com/googleapis/google-cloud-java/issues/9713)) ([1ecb036](https://github.com/googleapis/google-cloud-java/commit/1ecb036324b3b5ce0acbc530a04fe861634d8623))
* [netapp] add RestrictedAction to Volume ([#9734](https://github.com/googleapis/google-cloud-java/issues/9734)) ([d05cb98](https://github.com/googleapis/google-cloud-java/commit/d05cb9803a93dd6bb8b752a20a956da065826ce2))
* [servicemanagement] Add a proto message to describe the `resource_type` and `resource_permission` for an API method ([#9687](https://github.com/googleapis/google-cloud-java/issues/9687)) ([2c7313c](https://github.com/googleapis/google-cloud-java/commit/2c7313c7c0dc663e0a527f7f575a7528f0c30b62))
* [tpu] Add `spot` tier in v2alpha Create QueuedResource API request ([#9686](https://github.com/googleapis/google-cloud-java/issues/9686)) ([cbf3dd5](https://github.com/googleapis/google-cloud-java/commit/cbf3dd5720df2061fd0a32a42dea25966c8bb1d5))
* [translate] Added shadow removal and rotation correction options to Document Translation and Batch Document Translation API ([#9740](https://github.com/googleapis/google-cloud-java/issues/9740)) ([2b945d1](https://github.com/googleapis/google-cloud-java/commit/2b945d12c8050041ccba698cdf464e4a6d6ed43a))


### Bug Fixes

* [analyticsadmin] update the `ReportingAttributionModel` enum to rename `CROSS_CHANNEL_DATA_DRIVEN` to `PAID_AND_ORGANIC_CHANNELS_DATA_DRIVEN`, `CROSS_CHANNEL_LAST_CLICK` to `PAID_AND_ORGANIC_CHANNELS_LAST_CLICK`, `CROSS_CHANNEL_FIRST_CLICK` to `P... ([#9705](https://github.com/googleapis/google-cloud-java/issues/9705)) ([52c03af](https://github.com/googleapis/google-cloud-java/commit/52c03af95689a7a3c33158377e180ebcc8c27ff0))
* [analyticsadmin] update the `ReportingAttributionModel` enum to rename `CROSS_CHANNEL_DATA_DRIVEN` to `PAID_AND_ORGANIC_CHANNELS_DATA_DRIVEN`, `CROSS_CHANNEL_LAST_CLICK` to `PAID_AND_ORGANIC_CHANNELS_LAST_CLICK`, `CROSS_CHANNEL_FIRST_CLICK` to `P... ([#9706](https://github.com/googleapis/google-cloud-java/issues/9706)) ([f62e341](https://github.com/googleapis/google-cloud-java/commit/f62e3415fdf61ba42aea63fd4d3ebef7791a748d))
* [dataplex] remove unused annotation in results_table ([#9739](https://github.com/googleapis/google-cloud-java/issues/9739)) ([037b24a](https://github.com/googleapis/google-cloud-java/commit/037b24a80200ff99089279201fcfe13b7ece4d43))
* **deps:** update dependency com.google.cloud:google-cloud-pubsub-bom to v1.123.19 ([#9690](https://github.com/googleapis/google-cloud-java/issues/9690)) ([7f43cb6](https://github.com/googleapis/google-cloud-java/commit/7f43cb62b617f9b87d057e359871a69b54c6925b))
* **deps:** update dependency com.google.cloud:google-cloud-pubsub-bom to v1.123.20 ([#9699](https://github.com/googleapis/google-cloud-java/issues/9699)) ([2f431cd](https://github.com/googleapis/google-cloud-java/commit/2f431cd5a0abc56c02bc550ce9312d84795ffb47))
* **deps:** update dependency com.google.cloud:google-cloud-pubsub-bom to v1.124.0 ([#9709](https://github.com/googleapis/google-cloud-java/issues/9709)) ([1230b77](https://github.com/googleapis/google-cloud-java/commit/1230b77b84a5e475f6e327e777fdab353f348ac2))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.14.0 ([#9722](https://github.com/googleapis/google-cloud-java/issues/9722)) ([c7011db](https://github.com/googleapis/google-cloud-java/commit/c7011dbd69189330de1c2946b736cd712d5c1f4e))
* **deps:** update dependency com.google.cloud:google-cloud-storage to v2.25.0 ([#9682](https://github.com/googleapis/google-cloud-java/issues/9682)) ([db953a0](https://github.com/googleapis/google-cloud-java/commit/db953a092872ae404facc386d009f6f19142740a))
* remove netapp v1beta1 project remnants ([#9729](https://github.com/googleapis/google-cloud-java/issues/9729)) ([967bee2](https://github.com/googleapis/google-cloud-java/commit/967bee2e1e7e6311bbf9cdb101338b5ce7ddbdb0))


### Documentation

* [analyticsdata] Minor formatting ([#9738](https://github.com/googleapis/google-cloud-java/issues/9738)) ([47fbbd6](https://github.com/googleapis/google-cloud-java/commit/47fbbd653105b65c115836c032bc4494446df528))
* [cloudkms] Minor formatting ([#9726](https://github.com/googleapis/google-cloud-java/issues/9726)) ([94a00ba](https://github.com/googleapis/google-cloud-java/commit/94a00baea7f6f9db5de55f073c73dbeb81cb9f1c))
* [cloudtasks] minor formatting ([#9683](https://github.com/googleapis/google-cloud-java/issues/9683)) ([9ebc18f](https://github.com/googleapis/google-cloud-java/commit/9ebc18fefb698b317f6b3a66dfd28fc97c856eeb))
* [datacatalog] Minor formatting ([#9718](https://github.com/googleapis/google-cloud-java/issues/9718)) ([5103a7a](https://github.com/googleapis/google-cloud-java/commit/5103a7aae963998b651a49a91a5411e425cccb71))
* [dataproc] Minor formatting ([#9721](https://github.com/googleapis/google-cloud-java/issues/9721)) ([c14b376](https://github.com/googleapis/google-cloud-java/commit/c14b376c59298b2e7069c0e275f0e2d113087553))
* [dialogflow] Minor formatting ([#9719](https://github.com/googleapis/google-cloud-java/issues/9719)) ([c26f79b](https://github.com/googleapis/google-cloud-java/commit/c26f79b5ac3d78a2dde25f26178cb6a5ebea5da1))
* [dialogflow] Minor formatting ([#9731](https://github.com/googleapis/google-cloud-java/issues/9731)) ([c5ac114](https://github.com/googleapis/google-cloud-java/commit/c5ac114500fb68eb0e9e0e1bd7a91a3bebce9a1b))
* [gke-backup] Minor formatting ([#9725](https://github.com/googleapis/google-cloud-java/issues/9725)) ([d3a4a76](https://github.com/googleapis/google-cloud-java/commit/d3a4a76ac1f39168fb62afda7b20a48dcf3f9d6c))
* [translate] Minor formatting ([#9712](https://github.com/googleapis/google-cloud-java/issues/9712)) ([09a957d](https://github.com/googleapis/google-cloud-java/commit/09a957dd64ea09a4777b361301089b7cecbd146d))

## [1.16.0](https://github.com/googleapis/google-cloud-java/compare/v1.15.0...v1.16.0) (2023-07-21)


### ⚠ BREAKING CHANGES

* [documentai] removed id field from Document message ([#9642](https://github.com/googleapis/google-cloud-java/issues/9642))

### Features

* [aiplatform] add data_item_count to Dataset ([#9636](https://github.com/googleapis/google-cloud-java/issues/9636)) ([5a82003](https://github.com/googleapis/google-cloud-java/commit/5a82003b7e93ccccf8ff82753a0b3a275564fd96))
* [alloydb] add metadata exchange support for AlloyDB connectors ([#9639](https://github.com/googleapis/google-cloud-java/issues/9639)) ([c411402](https://github.com/googleapis/google-cloud-java/commit/c41140202e1474ee4436011d51bd607d42f15d5a))
* [cloudbuild] add git_file_source and git_repo_source to build_trigger ([#9673](https://github.com/googleapis/google-cloud-java/issues/9673)) ([6f96d9c](https://github.com/googleapis/google-cloud-java/commit/6f96d9c155fac34deecef125490430a7bc73fbe1))
* [cloudbuild] Add routing information in Cloud Build GRPC clients ([#9635](https://github.com/googleapis/google-cloud-java/issues/9635)) ([88ad198](https://github.com/googleapis/google-cloud-java/commit/88ad19815908dc995e4467f14fddc0f5c5dbeec5))
* [cloudkms] add interoperable symmetric encryption system ([#9667](https://github.com/googleapis/google-cloud-java/issues/9667)) ([a60caeb](https://github.com/googleapis/google-cloud-java/commit/a60caebee4af73c1cb86b4597fc69fb257c1cb20))
* [cloudtasks] increase timeout of RPC methods to 20s for v2 ([#9646](https://github.com/googleapis/google-cloud-java/issues/9646)) ([9caae4d](https://github.com/googleapis/google-cloud-java/commit/9caae4d63f52ae1305806623452a2cac62f05fc1))
* [container] Add Multi-networking API ([#9638](https://github.com/googleapis/google-cloud-java/issues/9638)) ([843b17b](https://github.com/googleapis/google-cloud-java/commit/843b17bd983002c94343aef0c27ff61d296f84b6))
* [documentai] removed id field from Document message ([#9642](https://github.com/googleapis/google-cloud-java/issues/9642)) ([0205042](https://github.com/googleapis/google-cloud-java/commit/02050426e9d69f17bc3a4e376086108f0d48ec28))
* [kmsinventory] add resource_types to SearchAllResources, to allow filtering by resource type ([#9641](https://github.com/googleapis/google-cloud-java/issues/9641)) ([1e8aa17](https://github.com/googleapis/google-cloud-java/commit/1e8aa175e7b41042cc4244380df765a2b78f60c2))
* [livestream] added support for slate events which allow users to create and insert a slate into a live stream to replace the main live stream content ([#9665](https://github.com/googleapis/google-cloud-java/issues/9665)) ([9679beb](https://github.com/googleapis/google-cloud-java/commit/9679beb02f6ca20e532cd4267c5773447b816b64))
* [netapp] new module for netapp ([#9668](https://github.com/googleapis/google-cloud-java/issues/9668)) ([b0c37db](https://github.com/googleapis/google-cloud-java/commit/b0c37db8afe9e922169c5590698e2dc0c014448c))
* [policysimulator] new module for policysimulator ([#9669](https://github.com/googleapis/google-cloud-java/issues/9669)) ([ebee6cb](https://github.com/googleapis/google-cloud-java/commit/ebee6cb75f23b99e296985037641dc8c66026686))
* [policytroubleshooter] include errors in troubleshoot response ([#9649](https://github.com/googleapis/google-cloud-java/issues/9649)) ([c7c7860](https://github.com/googleapis/google-cloud-java/commit/c7c786015b0a6ce0423ec58c645d4c1ce9a46a28))
* [servicedirectory] added network and uid fields in Endpoint message ([#9666](https://github.com/googleapis/google-cloud-java/issues/9666)) ([378391e](https://github.com/googleapis/google-cloud-java/commit/378391ec0294a59c7c1669d15d763cbecf75d1b6))


### Bug Fixes

* [policysimulator] add missing options for policysimulator ([#9672](https://github.com/googleapis/google-cloud-java/issues/9672)) ([56c3922](https://github.com/googleapis/google-cloud-java/commit/56c3922c321d70de3d867cf55569e47a4c044389))
* **deps:** update dependency com.google.cloud:google-cloud-pubsub-bom to v1.123.18 ([#9647](https://github.com/googleapis/google-cloud-java/issues/9647)) ([90e4d66](https://github.com/googleapis/google-cloud-java/commit/90e4d66fd9e3658df5bcae3bc89afdc25a458d65))
* **deps:** update dependency com.google.cloud:google-cloud-shared-config to v1.5.7 ([#9651](https://github.com/googleapis/google-cloud-java/issues/9651)) ([c88d623](https://github.com/googleapis/google-cloud-java/commit/c88d623d12a4342b74e31d6a6a05cde0debe871f))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.13.1 ([#9655](https://github.com/googleapis/google-cloud-java/issues/9655)) ([affebee](https://github.com/googleapis/google-cloud-java/commit/affebeeb37b1cf88ad5964684e1f112cababcab7))
* **deps:** update dependency com.google.cloud:google-cloud-storage to v2.24.0 ([#9571](https://github.com/googleapis/google-cloud-java/issues/9571)) ([7ab2869](https://github.com/googleapis/google-cloud-java/commit/7ab2869b697e3377d99b9e5a8b8ba7992c5c3141))


### Documentation

* [clouddeploy] small documentation updates ([#9653](https://github.com/googleapis/google-cloud-java/issues/9653)) ([e77037d](https://github.com/googleapis/google-cloud-java/commit/e77037d7d00798e8d8da5e3bcf7dd9bca3735472))
* [servicemanagement] update docs to existing services ([#9583](https://github.com/googleapis/google-cloud-java/issues/9583)) ([36f5b3c](https://github.com/googleapis/google-cloud-java/commit/36f5b3c40559421bfeaabcdc0f4275e7b4ad90c0))

## [1.15.0](https://github.com/googleapis/google-cloud-java/compare/v1.14.0...v1.15.0) (2023-07-11)


### Features

* [analyticsdata] add `CreateAudienceList`, `QueryAudienceList`,`GetAudienceList`,`ListAudienceLists` methods to the Data API v1 alpha ([#9632](https://github.com/googleapis/google-cloud-java/issues/9632)) ([86f2bb3](https://github.com/googleapis/google-cloud-java/commit/86f2bb3c25a6218738fb5a8a6f76e7103084c166))
* [batch] Add gpu driver version field ([#9609](https://github.com/googleapis/google-cloud-java/issues/9609)) ([79b80a3](https://github.com/googleapis/google-cloud-java/commit/79b80a34531fb60e3bd4e83ba67a3c24019b1229))
* [bigqueryconnection] add support for Salesforce connections, which are usable only by allowlisted partners ([#9621](https://github.com/googleapis/google-cloud-java/issues/9621)) ([d072400](https://github.com/googleapis/google-cloud-java/commit/d0724008036834954d14c940d470afdfab22fc70))
* [cloudbuild] Add GitLabConfig and fetchGitRefs for Cloud Build Repositories ([#9588](https://github.com/googleapis/google-cloud-java/issues/9588)) ([fb44667](https://github.com/googleapis/google-cloud-java/commit/fb44667ed5f259e69453310050d1c091f73d805a))
* [cloudbuild] add repositoryevent to buildtrigger ([fb44667](https://github.com/googleapis/google-cloud-java/commit/fb44667ed5f259e69453310050d1c091f73d805a))
* [cloudbuild] added e2-medium machine type ([#9620](https://github.com/googleapis/google-cloud-java/issues/9620)) ([9c52160](https://github.com/googleapis/google-cloud-java/commit/9c52160d40a182f2b09641e66f11eee8b441a66d))
* [cloudcommerceconsumerprocurement] permit duplicate display names ([#9615](https://github.com/googleapis/google-cloud-java/issues/9615)) ([491c157](https://github.com/googleapis/google-cloud-java/commit/491c1579092bc5552a8f1c3f8d753b2cbcea0366))
* [clouddeploy] added support routeUpdateWaitTime field for Deployment Strategies ([#9630](https://github.com/googleapis/google-cloud-java/issues/9630)) ([16d930f](https://github.com/googleapis/google-cloud-java/commit/16d930f612b8e37a46a2bf3807a49bfb0d6b7a28))
* [cloudkms] add interoperable symmetric encryption system ([#9598](https://github.com/googleapis/google-cloud-java/issues/9598)) ([04424f2](https://github.com/googleapis/google-cloud-java/commit/04424f2d0198826f1cb4a7c3d893b2b242df4ed8))
* [compute] Update Compute Engine API to revision 20230610 ([#820](https://github.com/googleapis/google-cloud-java/issues/820)) ([#9597](https://github.com/googleapis/google-cloud-java/issues/9597)) ([38b6cb1](https://github.com/googleapis/google-cloud-java/commit/38b6cb1f29ec51e277a5b77600abed465f27e3f8))
* [compute] Update Compute Engine API to revision 20230701 ([#821](https://github.com/googleapis/google-cloud-java/issues/821)) ([#9628](https://github.com/googleapis/google-cloud-java/issues/9628)) ([ca0d2db](https://github.com/googleapis/google-cloud-java/commit/ca0d2db0652b937b4bada719a25e705b7b859ddf))
* [contactcenterinsights] Support topic model type V2 ([#9616](https://github.com/googleapis/google-cloud-java/issues/9616)) ([0f4c25d](https://github.com/googleapis/google-cloud-java/commit/0f4c25da50fc00855faa712c30b8793039106cc6))
* [container] Add `KUBE_DNS` option to `DNSConfig.cluster_dns` ([ef39c21](https://github.com/googleapis/google-cloud-java/commit/ef39c217bd22fe28a5264cbadf4403e15ad95f50))
* [container] Add `KUBE_DNS` option to `DNSConfig.cluster_dns` ([#9592](https://github.com/googleapis/google-cloud-java/issues/9592)) ([ef39c21](https://github.com/googleapis/google-cloud-java/commit/ef39c217bd22fe28a5264cbadf4403e15ad95f50))
* [container] add a flag to toggle the Kubelet read only port ([#9608](https://github.com/googleapis/google-cloud-java/issues/9608)) ([333aff0](https://github.com/googleapis/google-cloud-java/commit/333aff0df2f131b2525e38ab1f68bfbbed032e9b))
* [datacatalog] added rpc RenameTagTemplateFieldEnumValue ([#9614](https://github.com/googleapis/google-cloud-java/issues/9614)) ([cc2e2ff](https://github.com/googleapis/google-cloud-java/commit/cc2e2ff1ae033ddb24c99ad0ece351b1129dadbe))
* [dialogflow-cx] added GitIntegrationSettings to the Agent ([#9624](https://github.com/googleapis/google-cloud-java/issues/9624)) ([2e5fde3](https://github.com/googleapis/google-cloud-java/commit/2e5fde30b7d72ce6d7a2ba11a0472714c3c6519f))
* [dialogflow-cx] added GitIntegrationSettings to the Agent ([#9631](https://github.com/googleapis/google-cloud-java/issues/9631)) ([68b12a0](https://github.com/googleapis/google-cloud-java/commit/68b12a0604b7205c6aa6c56ffa732028b33224df))
* [gke-backup] added new restore scope options ([#9586](https://github.com/googleapis/google-cloud-java/issues/9586)) ([c35bd0b](https://github.com/googleapis/google-cloud-java/commit/c35bd0b7d4a5dad90b7d228952b0fbd17d97a838))
* [maps-routing] Add HTML Navigation Instructions feature to ComputeRoutes ([#9589](https://github.com/googleapis/google-cloud-java/issues/9589)) ([7be2b86](https://github.com/googleapis/google-cloud-java/commit/7be2b864cd3180a464dd9b4f2aa7c439f9741013))
* [metastore] added Admin Interface (v1) ([#9612](https://github.com/googleapis/google-cloud-java/issues/9612)) ([9cb69a8](https://github.com/googleapis/google-cloud-java/commit/9cb69a817b44e7daa18e205c38a5046c845d0164))
* [run] Adds support for custom audiences ([#9618](https://github.com/googleapis/google-cloud-java/issues/9618)) ([29d1eb1](https://github.com/googleapis/google-cloud-java/commit/29d1eb102184d9fd6ea000ac13c8e5a098fb7e0a))
* [speech] add `model` and `language_codes` fields in `RecognitionConfig` message + enable default `_` recognizer ([#9613](https://github.com/googleapis/google-cloud-java/issues/9613)) ([d14537e](https://github.com/googleapis/google-cloud-java/commit/d14537ee70e82031a3a008e122a7c386a111eadc))
* [storagetransfer] add event driven transfer configuration ([#9585](https://github.com/googleapis/google-cloud-java/issues/9585)) ([9632eaf](https://github.com/googleapis/google-cloud-java/commit/9632eaf5b5dfb21d75f852c1422ce1a6fe44c5a4))
* [transcoder] added support for segment template manifest generation with DASH ([#9629](https://github.com/googleapis/google-cloud-java/issues/9629)) ([3c74216](https://github.com/googleapis/google-cloud-java/commit/3c74216586e53c04291d4d66f9235eb910a3446b))
* Add more navigation instruction maneuvers ([7be2b86](https://github.com/googleapis/google-cloud-java/commit/7be2b864cd3180a464dd9b4f2aa7c439f9741013))
* Add more toll pass values ([7be2b86](https://github.com/googleapis/google-cloud-java/commit/7be2b864cd3180a464dd9b4f2aa7c439f9741013))
* add Tier 1 cluster-level API network_performance_config ([ef39c21](https://github.com/googleapis/google-cloud-java/commit/ef39c217bd22fe28a5264cbadf4403e15ad95f50))
* add Tier 1 cluster-level API network_performance_config ([ef39c21](https://github.com/googleapis/google-cloud-java/commit/ef39c217bd22fe28a5264cbadf4403e15ad95f50))
* Add TrafficModel feature in ComputeRoutes and ComputeRouteMatrix ([7be2b86](https://github.com/googleapis/google-cloud-java/commit/7be2b864cd3180a464dd9b4f2aa7c439f9741013))
* Add Waypoint Optimization feature to ComputeRoutes ([7be2b86](https://github.com/googleapis/google-cloud-java/commit/7be2b864cd3180a464dd9b4f2aa7c439f9741013))
* Support returning localized values in ComputeRoutes and ComputeRouteMatrix ([7be2b86](https://github.com/googleapis/google-cloud-java/commit/7be2b864cd3180a464dd9b4f2aa7c439f9741013))
* Support Transit routes in ComputeRoutes and ComputeRouteMatrix ([7be2b86](https://github.com/googleapis/google-cloud-java/commit/7be2b864cd3180a464dd9b4f2aa7c439f9741013))


### Bug Fixes

* **deps:** update dependency com.google.apis:google-api-services-storage to v1-rev20230617-2.0.0 ([#9559](https://github.com/googleapis/google-cloud-java/issues/9559)) ([a698f51](https://github.com/googleapis/google-cloud-java/commit/a698f51b8ef94ebfa043f3d4e497c701b73ef30d))
* **deps:** update dependency com.google.cloud:google-cloud-pubsub-bom to v1.123.16 ([#9580](https://github.com/googleapis/google-cloud-java/issues/9580)) ([f4d8639](https://github.com/googleapis/google-cloud-java/commit/f4d8639b48199526485326a112ab9426869c7c76))
* **deps:** update dependency com.google.cloud:google-cloud-pubsub-bom to v1.123.17 ([#9584](https://github.com/googleapis/google-cloud-java/issues/9584)) ([4508367](https://github.com/googleapis/google-cloud-java/commit/450836784b90ec9ae3085b9b8f3f9977fde60d17))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.13.0 ([#9622](https://github.com/googleapis/google-cloud-java/issues/9622)) ([3ac3050](https://github.com/googleapis/google-cloud-java/commit/3ac3050250a706e8f9f2d1e435a4983c3cceab82))


### Documentation

* [dialogflow] added google.api.field_behavior for some fields in audio_config ([#9626](https://github.com/googleapis/google-cloud-java/issues/9626)) ([be099c7](https://github.com/googleapis/google-cloud-java/commit/be099c7692e9e179bde3737c09b97c8a01610628))
* [tpu] minor updates in comments ([#9619](https://github.com/googleapis/google-cloud-java/issues/9619)) ([6cebb8d](https://github.com/googleapis/google-cloud-java/commit/6cebb8d61fc6f9ee5edc0b0878efeac217e21fe8))
* **scc-samples:** update comments to include new parent types ([#9596](https://github.com/googleapis/google-cloud-java/issues/9596)) ([1927bfc](https://github.com/googleapis/google-cloud-java/commit/1927bfc0582dfbfb1ac3a3ae502362dd720416c4))

## [1.14.0](https://github.com/googleapis/google-cloud-java/compare/v1.13.0...v1.14.0) (2023-06-23)


### Features

* [aiplatform] add bias_configs to ModelEvaluation ([3c65d52](https://github.com/googleapis/google-cloud-java/commit/3c65d5290a69125c115e765cd13b2e67aa6f5783))
* [aiplatform] add UpdateExplanationDataset to aiplatform ([#9549](https://github.com/googleapis/google-cloud-java/issues/9549)) ([3c65d52](https://github.com/googleapis/google-cloud-java/commit/3c65d5290a69125c115e765cd13b2e67aa6f5783))
* [alloydb] Added new SSL modes ALLOW_UNENCRYPTED_AND_ENCRYPTED, ENCRYPTED_ONLY ([#9538](https://github.com/googleapis/google-cloud-java/issues/9538)) ([1dfd3f3](https://github.com/googleapis/google-cloud-java/commit/1dfd3f3eb12f114e626cc098d3ae7c1f7c5527e6))
* [batch] implement minCpuPlatform ([c235f3a](https://github.com/googleapis/google-cloud-java/commit/c235f3a4a2706c5e6a5bee97ebc62aef96d2e3e6))
* [cloudbilling] added resource_reference for name in GetProjectBillingInfoRequest message ([#9555](https://github.com/googleapis/google-cloud-java/issues/9555)) ([cf43432](https://github.com/googleapis/google-cloud-java/commit/cf43432340ad1b64633cec21d2d4fd4c37dedc10))
* [cloudchannel] Add support for ListSkuGroups and ListSkuGroupBillableSkus APIs in Cloud Channel APIs ([#9548](https://github.com/googleapis/google-cloud-java/issues/9548)) ([9c1a805](https://github.com/googleapis/google-cloud-java/commit/9c1a8055746f3e0b11390ba208e73118bef5857b))
* [clouddeploy] Add deploy parameters for cloud deploy ([#9570](https://github.com/googleapis/google-cloud-java/issues/9570)) ([c6b3360](https://github.com/googleapis/google-cloud-java/commit/c6b3360a32c98eca308559f5293f866a7b9e2a31))
* [container] add API for GPU driver installation config ([#9534](https://github.com/googleapis/google-cloud-java/issues/9534)) ([1c2b1d4](https://github.com/googleapis/google-cloud-java/commit/1c2b1d4a65e84e5926c319d951381dc5a4f472c4))
* [dialogflow-cx] added include_bigquery_export_settings to ExportAgentRequest ([#9537](https://github.com/googleapis/google-cloud-java/issues/9537)) ([7edc704](https://github.com/googleapis/google-cloud-java/commit/7edc704578221350c075febef00e4b4a7c3e7ef0))
* [dialogflow] added dialogflow_assist_answer ([0daa460](https://github.com/googleapis/google-cloud-java/commit/0daa460b5020a3bdde087d470ba4b20d85a93254))
* [dialogflow] added dialogflow_assist_answer ([#9565](https://github.com/googleapis/google-cloud-java/issues/9565)) ([0daa460](https://github.com/googleapis/google-cloud-java/commit/0daa460b5020a3bdde087d470ba4b20d85a93254))
* [discoveryengine] support extractive content in search ([#9554](https://github.com/googleapis/google-cloud-java/issues/9554)) ([af36e0a](https://github.com/googleapis/google-cloud-java/commit/af36e0ac5a36f277074ab6b1448170eb2ec50940))
* [documentai] add StyleInfo to document.proto ([#9551](https://github.com/googleapis/google-cloud-java/issues/9551)) ([c873d10](https://github.com/googleapis/google-cloud-java/commit/c873d103a625d41838c582737f4b98da6605d47f))
* [migrationcenter] Migration Center API ([#9532](https://github.com/googleapis/google-cloud-java/issues/9532)) ([07a8685](https://github.com/googleapis/google-cloud-java/commit/07a86854bd8a996b5835d086418189a8ac89c9ad))
* [networkmanagement] add forwarding_rule field to Connectivity Test Endpoint proto ([#9576](https://github.com/googleapis/google-cloud-java/issues/9576)) ([53e7f84](https://github.com/googleapis/google-cloud-java/commit/53e7f8498a9dfd4794ea081e410230cce3e969f8))
* [orchestration-airflow] added RPCs StopAirflowCommand, ExecuteAirflowCommand, PollAirflowCommand, DatabaseFailover, FetchDatabaseProperties ([#9543](https://github.com/googleapis/google-cloud-java/issues/9543)) ([1a2fab1](https://github.com/googleapis/google-cloud-java/commit/1a2fab1495e09d03276c7bf5dac44a429915048e))
* [securitycenter] Add user agent and DLP parent type fields to finding's list of attributes ([#9535](https://github.com/googleapis/google-cloud-java/issues/9535)) ([48b1b5d](https://github.com/googleapis/google-cloud-java/commit/48b1b5d4843f5fd334b80b754054770cf209e8a3))
* [securitycenter] Mark the Asset APIs as deprecated in client libraries ([#9575](https://github.com/googleapis/google-cloud-java/issues/9575)) ([0b25cfa](https://github.com/googleapis/google-cloud-java/commit/0b25cfaf7f9b668e7aea88a09d3eef49b8a9a7b3))
* [vmwareengine] Adding private connection CRUD, updating management subnets and time-limited PC features ([#9531](https://github.com/googleapis/google-cloud-java/issues/9531)) ([bb8a4bc](https://github.com/googleapis/google-cloud-java/commit/bb8a4bc8022d232a658c7a43fd57f8e976872143))
* add `AdsWebConversionDataExportScope` enum to the Admin API v1alpha ([a093cb3](https://github.com/googleapis/google-cloud-java/commit/a093cb3fae7c2c332c0654ce1fe9f6bb4c912d24))
* add `AdsWebConversionDataExportScope` enum to the Admin API v1alpha ([e2f7dc3](https://github.com/googleapis/google-cloud-java/commit/e2f7dc385da8bfa65b70ee096e708d2a2f9f0863))
* add redirected uri in search response ([af36e0a](https://github.com/googleapis/google-cloud-java/commit/af36e0ac5a36f277074ab6b1448170eb2ec50940))
* add the `ads_web_conversion_data_export_scope` field to the `ReportingAttributionModel` type ([a093cb3](https://github.com/googleapis/google-cloud-java/commit/a093cb3fae7c2c332c0654ce1fe9f6bb4c912d24))
* add the `ads_web_conversion_data_export_scope` field to the `ReportingAttributionModel` type ([e2f7dc3](https://github.com/googleapis/google-cloud-java/commit/e2f7dc385da8bfa65b70ee096e708d2a2f9f0863))
* added human_agent_side_config ([0daa460](https://github.com/googleapis/google-cloud-java/commit/0daa460b5020a3bdde087d470ba4b20d85a93254))
* added human_agent_side_config ([0daa460](https://github.com/googleapis/google-cloud-java/commit/0daa460b5020a3bdde087d470ba4b20d85a93254))
* added RPCs StopAirflowCommand, ExecuteAirflowCommand, PollAirflowCommand, DatabaseFailover, FetchDatabaseProperties ([1a2fab1](https://github.com/googleapis/google-cloud-java/commit/1a2fab1495e09d03276c7bf5dac44a429915048e))
* added session_ttl ([0daa460](https://github.com/googleapis/google-cloud-java/commit/0daa460b5020a3bdde087d470ba4b20d85a93254))
* added session_ttl ([0daa460](https://github.com/googleapis/google-cloud-java/commit/0daa460b5020a3bdde087d470ba4b20d85a93254))
* added suggest_dialogflow_assists_response ([0daa460](https://github.com/googleapis/google-cloud-java/commit/0daa460b5020a3bdde087d470ba4b20d85a93254))
* added suggest_dialogflow_assists_response ([0daa460](https://github.com/googleapis/google-cloud-java/commit/0daa460b5020a3bdde087d470ba4b20d85a93254))
* added suggest_entity_extraction_response ([0daa460](https://github.com/googleapis/google-cloud-java/commit/0daa460b5020a3bdde087d470ba4b20d85a93254))
* added suggest_entity_extraction_response ([0daa460](https://github.com/googleapis/google-cloud-java/commit/0daa460b5020a3bdde087d470ba4b20d85a93254))
* added suggestion_input ([0daa460](https://github.com/googleapis/google-cloud-java/commit/0daa460b5020a3bdde087d470ba4b20d85a93254))
* added suggestion_input ([0daa460](https://github.com/googleapis/google-cloud-java/commit/0daa460b5020a3bdde087d470ba4b20d85a93254))
* support docx/pptx/txt/csv in allowed data format ([af36e0a](https://github.com/googleapis/google-cloud-java/commit/af36e0ac5a36f277074ab6b1448170eb2ec50940))
* update TaskGroup doc ([c235f3a](https://github.com/googleapis/google-cloud-java/commit/c235f3a4a2706c5e6a5bee97ebc62aef96d2e3e6))
* update the `default_uri` field of the `WebStreamData` type to be mutable ([a093cb3](https://github.com/googleapis/google-cloud-java/commit/a093cb3fae7c2c332c0654ce1fe9f6bb4c912d24))
* update the `default_uri` field of the `WebStreamData` type to be mutable ([e2f7dc3](https://github.com/googleapis/google-cloud-java/commit/e2f7dc385da8bfa65b70ee096e708d2a2f9f0863))
* **v1:** [batch] Add support for scheduling_policy ([#9542](https://github.com/googleapis/google-cloud-java/issues/9542)) ([c235f3a](https://github.com/googleapis/google-cloud-java/commit/c235f3a4a2706c5e6a5bee97ebc62aef96d2e3e6))


### Bug Fixes

* [essentialcontacts] mark fields in Contacts message as REQUIRED ([#9572](https://github.com/googleapis/google-cloud-java/issues/9572)) ([ac62dbc](https://github.com/googleapis/google-cloud-java/commit/ac62dbc7ddb2bf3b037c07316730ba2ce2420c45))
* **ci:** CHANGELOG.md generation fix for 'no change' and yoshi-code-bot email ([#9566](https://github.com/googleapis/google-cloud-java/issues/9566)) ([6a5d805](https://github.com/googleapis/google-cloud-java/commit/6a5d80515d37aa6706caf8f6b7e9b5d50127c890))
* **ci:** specifying fetch depth in CHANGELOG.md generation  ([#9564](https://github.com/googleapis/google-cloud-java/issues/9564)) ([0158232](https://github.com/googleapis/google-cloud-java/commit/0158232c5a99773e87d365f568c432de7e83d80b))
* **deps:** [gke-backup] change dependency grpc-google-common-protos to test scope. ([594e965](https://github.com/googleapis/google-cloud-java/commit/594e96586cc13852ad38fb9725b39bc643cb5e20))
* **deps:** update dependency com.google.cloud:google-cloud-pubsub-bom to v1.123.14 ([#9522](https://github.com/googleapis/google-cloud-java/issues/9522)) ([78fbbe2](https://github.com/googleapis/google-cloud-java/commit/78fbbe2b03befda2cb3ed338ecdceeac74a4d103))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.12.0 ([#9577](https://github.com/googleapis/google-cloud-java/issues/9577)) ([9e9812a](https://github.com/googleapis/google-cloud-java/commit/9e9812a0ba19e5aa82a34f2a3049bb72892544a6))
* **deps:** update dependency com.google.cloud:google-cloud-storage to v2.22.4 ([#9518](https://github.com/googleapis/google-cloud-java/issues/9518)) ([36a2843](https://github.com/googleapis/google-cloud-java/commit/36a284334cd8b00da8aa71ec589fe1c6155fb64d))


### Documentation

* [analyticsadmin] announce the deprecation of first-click, linear, time-decay and position-based attribution models ([#9562](https://github.com/googleapis/google-cloud-java/issues/9562)) ([e2f7dc3](https://github.com/googleapis/google-cloud-java/commit/e2f7dc385da8bfa65b70ee096e708d2a2f9f0863))
* [analyticsadmin] announce the deprecation of first-click, linear, time-decay and position-based attribution models ([#9563](https://github.com/googleapis/google-cloud-java/issues/9563)) ([a093cb3](https://github.com/googleapis/google-cloud-java/commit/a093cb3fae7c2c332c0654ce1fe9f6bb4c912d24))
* [gke-backup] minor documentation fixes ([#9533](https://github.com/googleapis/google-cloud-java/issues/9533)) ([7709391](https://github.com/googleapis/google-cloud-java/commit/7709391fa7cedae835d87dc3f6bcb575068a6ad6))
* keep the API doc up-to-date with recent changes ([af36e0a](https://github.com/googleapis/google-cloud-java/commit/af36e0ac5a36f277074ab6b1448170eb2ec50940))
* **v1:** Minor clarifications for TaskGroup and min_cpu_platform ([c235f3a](https://github.com/googleapis/google-cloud-java/commit/c235f3a4a2706c5e6a5bee97ebc62aef96d2e3e6))

## [1.13.0](https://github.com/googleapis/google-cloud-java/compare/v1.12.0...v1.13.0) (2023-06-08)


### Features

* [aiplatform] add blocking_operation_ids to ImportFeatureValuesOperationMetadata ([#9481](https://github.com/googleapis/google-cloud-java/issues/9481)) ([ba2c590](https://github.com/googleapis/google-cloud-java/commit/ba2c590cc9970be41e5a663004d354b3881a69d9))
* [billingbudgets] Add resource_ancestors field to support filtering by folders & organizations ([#9501](https://github.com/googleapis/google-cloud-java/issues/9501)) ([0c3b677](https://github.com/googleapis/google-cloud-java/commit/0c3b6772868828a429f5f5010483567afe58db54))
* [clouddeploy] Add support for disabling Pod overprovisioning in the progressive deployment strategy configuration for a Kubernetes Target ([#9499](https://github.com/googleapis/google-cloud-java/issues/9499)) ([b7890c5](https://github.com/googleapis/google-cloud-java/commit/b7890c57859116d1f6033af9f485598d84428f44))
* [contactcenterinsights] Add the resource definition of a STT recognizer ([#9492](https://github.com/googleapis/google-cloud-java/issues/9492)) ([f2baa92](https://github.com/googleapis/google-cloud-java/commit/f2baa928c4f4d9959591ea905d7c9042320dbc71))
* [migrationcenter] new module for migrationcenter ([#9514](https://github.com/googleapis/google-cloud-java/issues/9514)) ([a268c80](https://github.com/googleapis/google-cloud-java/commit/a268c8016262a7a5a13be6a9983294f83d1ecc3f))


### Bug Fixes

* **deps:** update dependency com.google.cloud:google-cloud-pubsub-bom to v1.123.13 ([#9478](https://github.com/googleapis/google-cloud-java/issues/9478)) ([47778ff](https://github.com/googleapis/google-cloud-java/commit/47778ff0b2eb98b6354f237ee84df0dafc567bec))
* **deps:** update dependency com.google.cloud:google-cloud-shared-config to v1.5.6 ([#9494](https://github.com/googleapis/google-cloud-java/issues/9494)) ([739763f](https://github.com/googleapis/google-cloud-java/commit/739763f15ffa2434d7fa089899165f1e8fa5f870))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.11.0 ([#9505](https://github.com/googleapis/google-cloud-java/issues/9505)) ([30bc6f0](https://github.com/googleapis/google-cloud-java/commit/30bc6f0aef5b95549230dbd5b5246f2a8dab4ba4))
* **deps:** update dependency com.google.cloud:google-cloud-storage to v2.22.3 ([#9477](https://github.com/googleapis/google-cloud-java/issues/9477)) ([ce1ce33](https://github.com/googleapis/google-cloud-java/commit/ce1ce333f6e3e11a9382c8f29196b53c7afa21c2))


### Documentation

* update discoveryengine v1 docs link ([#9512](https://github.com/googleapis/google-cloud-java/issues/9512)) ([f172c7e](https://github.com/googleapis/google-cloud-java/commit/f172c7e692c7991b878968256b3fe7c538de7c00))

## [1.12.0](https://github.com/googleapis/google-cloud-java/compare/v1.11.0...v1.12.0) (2023-05-26)


### Features

* [aiplatform] add match service in aiplatform v1 ([#9438](https://github.com/googleapis/google-cloud-java/issues/9438)) ([4ab7b4f](https://github.com/googleapis/google-cloud-java/commit/4ab7b4fd466bf488a646ac0ee8a019ca78c42efe))
* [analyticsadmin] add `GetAdSenseLink`, `CreateAdSenseLink`, `DeleteAdSenseLink`, `ListAdSenseLinks` methods to the Admin API v1alpha ([#9434](https://github.com/googleapis/google-cloud-java/issues/9434)) ([d9f948e](https://github.com/googleapis/google-cloud-java/commit/d9f948ef915cf1a118085a783c3e072ba0b54ccc))
* [batch] add support for placement policies ([#9439](https://github.com/googleapis/google-cloud-java/issues/9439)) ([f30b899](https://github.com/googleapis/google-cloud-java/commit/f30b899f2b58945a33438fc35a207c51e4bf44a0))
* [batch] add TaskStatus's new terminated state UNEXECUTED ([720796b](https://github.com/googleapis/google-cloud-java/commit/720796b7e1218b9517a3f2ebcacd3119448e2e9c))
* [batch] support order_by in ListJobs and ListTasks requests ([720796b](https://github.com/googleapis/google-cloud-java/commit/720796b7e1218b9517a3f2ebcacd3119448e2e9c))
* [batch] support order_by in ListJobs and ListTasks requests ([#21](https://github.com/googleapis/google-cloud-java/issues/21)) ([720796b](https://github.com/googleapis/google-cloud-java/commit/720796b7e1218b9517a3f2ebcacd3119448e2e9c))
* [batch] support order_by in ListJobs and ListTasks requests ([#9359](https://github.com/googleapis/google-cloud-java/issues/9359)) ([720796b](https://github.com/googleapis/google-cloud-java/commit/720796b7e1218b9517a3f2ebcacd3119448e2e9c))
* [cloudchannel] added partition_keys field to filter results from FetchReportResults ([#9437](https://github.com/googleapis/google-cloud-java/issues/9437)) ([0857e33](https://github.com/googleapis/google-cloud-java/commit/0857e33e233232ac6e41de7ba3433036bdd0a2f6))
* [cloudfunctions] ListFunctions now include metadata which indicates whether a function is a `GEN_1` or `GEN_2` function ([#9462](https://github.com/googleapis/google-cloud-java/issues/9462)) ([d945618](https://github.com/googleapis/google-cloud-java/commit/d945618f4001d6e1853b84ab6964fcd026319c52))
* [cloudkms] added VerifyConnectivity RPC ([#9429](https://github.com/googleapis/google-cloud-java/issues/9429)) ([81b9849](https://github.com/googleapis/google-cloud-java/commit/81b9849a7d0145a5bd202de877f61e3fb4cfdf7d))
* [datamigration] add Oracle to PostgreSQL migration APIs ([#9442](https://github.com/googleapis/google-cloud-java/issues/9442)) ([d3ca29b](https://github.com/googleapis/google-cloud-java/commit/d3ca29ba6abcd21d7f276749d99b42cf2284bcd7))
* [discoveryengine] enable safe search feature for site search ([#9428](https://github.com/googleapis/google-cloud-java/issues/9428)) ([7b673de](https://github.com/googleapis/google-cloud-java/commit/7b673de22a253b4faeb995b46581208343f84abb))
* [language] Added client library support for ModerateText in the Natural Language API (V1) ([#9463](https://github.com/googleapis/google-cloud-java/issues/9463)) ([14fea71](https://github.com/googleapis/google-cloud-java/commit/14fea7158fa442bbd8df98e76972cbe5b508157f))
* [rapidmigrationassessment] new module for rapidmigrationassessment ([#9467](https://github.com/googleapis/google-cloud-java/issues/9467)) ([0123f56](https://github.com/googleapis/google-cloud-java/commit/0123f56bbc025baac61b2e220f28db29a688c29c))
* [webrisk] add SubmitUri endpoint ([#9443](https://github.com/googleapis/google-cloud-java/issues/9443)) ([dd5ddba](https://github.com/googleapis/google-cloud-java/commit/dd5ddbaa668f90cd6698ffd0accfde1168f64b6d))
* [workstations] add output field for the control plane IP address ([#9430](https://github.com/googleapis/google-cloud-java/issues/9430)) ([3cba89a](https://github.com/googleapis/google-cloud-java/commit/3cba89a945b5b5d85c5690bb500d078c351e90a1))
* add auditd support ([3cba89a](https://github.com/googleapis/google-cloud-java/commit/3cba89a945b5b5d85c5690bb500d078c351e90a1))
* add output field for the number of pooled instances ([3cba89a](https://github.com/googleapis/google-cloud-java/commit/3cba89a945b5b5d85c5690bb500d078c351e90a1))
* add scheduling_policy IN_ORDER enum to support sequential task executions ([720796b](https://github.com/googleapis/google-cloud-java/commit/720796b7e1218b9517a3f2ebcacd3119448e2e9c))
* add support for accelerators ([3cba89a](https://github.com/googleapis/google-cloud-java/commit/3cba89a945b5b5d85c5690bb500d078c351e90a1))
* add support for placement policies ([720796b](https://github.com/googleapis/google-cloud-java/commit/720796b7e1218b9517a3f2ebcacd3119448e2e9c))
* add support for readiness checks ([3cba89a](https://github.com/googleapis/google-cloud-java/commit/3cba89a945b5b5d85c5690bb500d078c351e90a1))
* add support for workstation-level environment variables ([3cba89a](https://github.com/googleapis/google-cloud-java/commit/3cba89a945b5b5d85c5690bb500d078c351e90a1))
* allow users to provide additional labels in search ([7b673de](https://github.com/googleapis/google-cloud-java/commit/7b673de22a253b4faeb995b46581208343f84abb))
* allow users to provide user info in search ([7b673de](https://github.com/googleapis/google-cloud-java/commit/7b673de22a253b4faeb995b46581208343f84abb))
* per-Runnable labels ([720796b](https://github.com/googleapis/google-cloud-java/commit/720796b7e1218b9517a3f2ebcacd3119448e2e9c))
* per-Runnable labels ([720796b](https://github.com/googleapis/google-cloud-java/commit/720796b7e1218b9517a3f2ebcacd3119448e2e9c))


### Bug Fixes

* [discoveryengine] fix the field name typo for search service user_labels ([#9440](https://github.com/googleapis/google-cloud-java/issues/9440)) ([eea5883](https://github.com/googleapis/google-cloud-java/commit/eea58838dfb351a853e4c639e690051d36456362))
* **deps:** update dependency com.google.cloud:google-cloud-pubsub-bom to v1.123.12 ([#9436](https://github.com/googleapis/google-cloud-java/issues/9436)) ([5df87b6](https://github.com/googleapis/google-cloud-java/commit/5df87b6be61c2892d07b1963512c15e64ededf27))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.10.0 ([#9461](https://github.com/googleapis/google-cloud-java/issues/9461)) ([d9fd655](https://github.com/googleapis/google-cloud-java/commit/d9fd6551394a5e19a7ab6e1c881e9ffc5ec77660))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.10.1 ([#9468](https://github.com/googleapis/google-cloud-java/issues/9468)) ([75847f7](https://github.com/googleapis/google-cloud-java/commit/75847f79ee79999fae3813d5189d33eeb7b1ab4a))
* **deps:** update dependency com.google.cloud:google-cloud-storage to v2.22.2 ([#9426](https://github.com/googleapis/google-cloud-java/issues/9426)) ([57a66df](https://github.com/googleapis/google-cloud-java/commit/57a66dfe16771ef3e995110715b5da5ff2104d9e))


### Documentation

* [container] clarified release channel defaulting behavior for create cluster requests when release channel is unspecified ([#9441](https://github.com/googleapis/google-cloud-java/issues/9441)) ([a9e8b90](https://github.com/googleapis/google-cloud-java/commit/a9e8b908d37ddede098a102af25587b7de4b2305))
* adjust documentation wording ([3cba89a](https://github.com/googleapis/google-cloud-java/commit/3cba89a945b5b5d85c5690bb500d078c351e90a1))
* fix `book disk` typo ([720796b](https://github.com/googleapis/google-cloud-java/commit/720796b7e1218b9517a3f2ebcacd3119448e2e9c))
* update block_external_network field comment to reduce confusion ([720796b](https://github.com/googleapis/google-cloud-java/commit/720796b7e1218b9517a3f2ebcacd3119448e2e9c))
* update comments on boot disk fields for clearer usage scope ([720796b](https://github.com/googleapis/google-cloud-java/commit/720796b7e1218b9517a3f2ebcacd3119448e2e9c))
* update disk and network field comment for better readability ([720796b](https://github.com/googleapis/google-cloud-java/commit/720796b7e1218b9517a3f2ebcacd3119448e2e9c))
* Update reservation field API doc ([720796b](https://github.com/googleapis/google-cloud-java/commit/720796b7e1218b9517a3f2ebcacd3119448e2e9c))

## [1.11.0](https://github.com/googleapis/google-cloud-java/compare/v1.10.0...v1.11.0) (2023-05-10)


### Features

* [aiplatform] add example_gcs_source to Examples in aiplatform v1beta1 explanation.proto ([#9392](https://github.com/googleapis/google-cloud-java/issues/9392)) ([78ea6c8](https://github.com/googleapis/google-cloud-java/commit/78ea6c83dac8d5ba68a8ecfe3438570c757c577d))
* [aiplatform] add model_garden_service.proto and publisher_model.proto to BUILD.bazel ([78ea6c8](https://github.com/googleapis/google-cloud-java/commit/78ea6c83dac8d5ba68a8ecfe3438570c757c577d))
* [aiplatform] add NVIDIA_L4 to AcceleratorType ([78ea6c8](https://github.com/googleapis/google-cloud-java/commit/78ea6c83dac8d5ba68a8ecfe3438570c757c577d))
* [aiplatform] add NVIDIA_L4 to AcceleratorType ([78ea6c8](https://github.com/googleapis/google-cloud-java/commit/78ea6c83dac8d5ba68a8ecfe3438570c757c577d))
* [aiplatform] support for Model Garden -- A single place to search, discover, and interact with a wide variety of foundation models from Google and Google partners, available on Vertex AI ([78ea6c8](https://github.com/googleapis/google-cloud-java/commit/78ea6c83dac8d5ba68a8ecfe3438570c757c577d))
* [cloudchannel] Add billing account to entitlement definitions for Cloud Channel API ([#9410](https://github.com/googleapis/google-cloud-java/issues/9410)) ([d841094](https://github.com/googleapis/google-cloud-java/commit/d8410942f9461ce2d6cd86450310afed0031a2aa))
* [clouddeploy] added support for DeployArtifacts ([#9398](https://github.com/googleapis/google-cloud-java/issues/9398)) ([bc3cddf](https://github.com/googleapis/google-cloud-java/commit/bc3cddf37545cc4ccca589ac4f1c7710294503c1))
* [cloudfunctions] added helper methods for long running operations, IAM, and locations ([#9421](https://github.com/googleapis/google-cloud-java/issues/9421)) ([0ebf4af](https://github.com/googleapis/google-cloud-java/commit/0ebf4af22c0f4269cfe5fa9cfc5a10005389b1f5))
* [cloudsupport] new module for cloudsupport ([#9399](https://github.com/googleapis/google-cloud-java/issues/9399)) ([531cf24](https://github.com/googleapis/google-cloud-java/commit/531cf24c1ca1a3e5a63106f732ae1329aac30620))
* [contactcenterinsights] support for generating summaries during conversation analysis ([#9391](https://github.com/googleapis/google-cloud-java/issues/9391)) ([bc46b1b](https://github.com/googleapis/google-cloud-java/commit/bc46b1b3f34dd721a322fded47107fde331dee4c))
* [container] add a new feature for fleet registration via cluster update in v1alpha1, v1beta1, v1 ([#9408](https://github.com/googleapis/google-cloud-java/issues/9408)) ([eeea875](https://github.com/googleapis/google-cloud-java/commit/eeea875d7a13920aef5ec3be6a30d9891bbf6677))
* [container] support fleet registration via cluster update ([eeea875](https://github.com/googleapis/google-cloud-java/commit/eeea875d7a13920aef5ec3be6a30d9891bbf6677))
* [dataplex] added new Dataplex APIs and new features for existing APIs (e.g. DataScans) ([#9402](https://github.com/googleapis/google-cloud-java/issues/9402)) ([b7c785a](https://github.com/googleapis/google-cloud-java/commit/b7c785a6e7552e75697536a4d9a100de38d856b1))
* [datastream] Max concurrent backfill tasks ([#9414](https://github.com/googleapis/google-cloud-java/issues/9414)) ([253ad50](https://github.com/googleapis/google-cloud-java/commit/253ad50f1e08461cee744ea276f601ec184ded33))
* [dialogflow-cx] extended CreateAgent timeout to 180 seconds ([20ddfda](https://github.com/googleapis/google-cloud-java/commit/20ddfda9258bbe089a978a17b37eca682f9d4a54))
* [dialogflow-cx] extended CreateAgent timeout to 180 seconds ([#9412](https://github.com/googleapis/google-cloud-java/issues/9412)) ([20ddfda](https://github.com/googleapis/google-cloud-java/commit/20ddfda9258bbe089a978a17b37eca682f9d4a54))
* [dialogflow] add baseline model configuration for conversation summarization ([e9944c5](https://github.com/googleapis/google-cloud-java/commit/e9944c5ded6890e6b97f3bce90740b19623e42b2))
* [dialogflow] add baseline model configuration for conversation summarization ([#9423](https://github.com/googleapis/google-cloud-java/issues/9423)) ([e9944c5](https://github.com/googleapis/google-cloud-java/commit/e9944c5ded6890e6b97f3bce90740b19623e42b2))
* [dialogflow] extended StreamingListCallCompanionEvents timeout to 600 seconds ([01db330](https://github.com/googleapis/google-cloud-java/commit/01db33038b1aeafd984f7cc174daee193a58915b))
* [dialogflow] extended StreamingListCallCompanionEvents timeout to 600 seconds ([#9415](https://github.com/googleapis/google-cloud-java/issues/9415)) ([01db330](https://github.com/googleapis/google-cloud-java/commit/01db33038b1aeafd984f7cc174daee193a58915b))
* [discoveryengine] add document purge API ([#9396](https://github.com/googleapis/google-cloud-java/issues/9396)) ([23b1396](https://github.com/googleapis/google-cloud-java/commit/23b1396e8b3efe2df7b6687277f10551cd41975d))
* [monitoring] Add ICMP pings ([#9409](https://github.com/googleapis/google-cloud-java/issues/9409)) ([94d5032](https://github.com/googleapis/google-cloud-java/commit/94d50327fd5d07f7aa234285cbdf8587d9172714))
* [run] Adds support for Startup CPU Boost (GA) ([#9397](https://github.com/googleapis/google-cloud-java/issues/9397)) ([a980e4d](https://github.com/googleapis/google-cloud-java/commit/a980e4dd693ed75c403329a52dcc8190e5f6237a))
* [servicecontrol] add a proto message used for batch mode resource info for ServiceController V2 ([#9387](https://github.com/googleapis/google-cloud-java/issues/9387)) ([78e1e17](https://github.com/googleapis/google-cloud-java/commit/78e1e172b763673fee873971d6ebc7d53bd40002))
* [speech] add processing strategy to batch recognition requests ([#9424](https://github.com/googleapis/google-cloud-java/issues/9424)) ([5e425bc](https://github.com/googleapis/google-cloud-java/commit/5e425bc3949df8ac94f28442b166f611372490c8))
* [workstations] add output field for the control plane IP address ([#9422](https://github.com/googleapis/google-cloud-java/issues/9422)) ([487e38d](https://github.com/googleapis/google-cloud-java/commit/487e38d8c4184c98fa714618274a295f677a3b98))
* Add basic http authentication ([94d5032](https://github.com/googleapis/google-cloud-java/commit/94d50327fd5d07f7aa234285cbdf8587d9172714))
* add experiment and experiment_run to CustomJobSpec ([78ea6c8](https://github.com/googleapis/google-cloud-java/commit/78ea6c83dac8d5ba68a8ecfe3438570c757c577d))
* add experiment and experiment_run to CustomJobSpec ([78ea6c8](https://github.com/googleapis/google-cloud-java/commit/78ea6c83dac8d5ba68a8ecfe3438570c757c577d))
* add GENIE to ModelSourceType ([78ea6c8](https://github.com/googleapis/google-cloud-java/commit/78ea6c83dac8d5ba68a8ecfe3438570c757c577d))
* add GENIE to ModelSourceType ([78ea6c8](https://github.com/googleapis/google-cloud-java/commit/78ea6c83dac8d5ba68a8ecfe3438570c757c577d))
* Add httpStatusCode ([94d5032](https://github.com/googleapis/google-cloud-java/commit/94d50327fd5d07f7aa234285cbdf8587d9172714))
* Add individual USA regions ([94d5032](https://github.com/googleapis/google-cloud-java/commit/94d50327fd5d07f7aa234285cbdf8587d9172714))
* Add json path matching capabilities ([94d5032](https://github.com/googleapis/google-cloud-java/commit/94d50327fd5d07f7aa234285cbdf8587d9172714))
* add last_scheduled_run_response to Schedule ([78ea6c8](https://github.com/googleapis/google-cloud-java/commit/78ea6c83dac8d5ba68a8ecfe3438570c757c577d))
* add MutateDeployedModel RPC to endpoint_service ([78ea6c8](https://github.com/googleapis/google-cloud-java/commit/78ea6c83dac8d5ba68a8ecfe3438570c757c577d))
* add MutateDeployedModel RPC to endpoint_service ([78ea6c8](https://github.com/googleapis/google-cloud-java/commit/78ea6c83dac8d5ba68a8ecfe3438570c757c577d))
* add offline_storage_ttl_days to EntityType ([78ea6c8](https://github.com/googleapis/google-cloud-java/commit/78ea6c83dac8d5ba68a8ecfe3438570c757c577d))
* add online_storage_ttl_days to FeatureStore ([78ea6c8](https://github.com/googleapis/google-cloud-java/commit/78ea6c83dac8d5ba68a8ecfe3438570c757c577d))
* add output field for the number of pooled instances ([487e38d](https://github.com/googleapis/google-cloud-java/commit/487e38d8c4184c98fa714618274a295f677a3b98))
* added debug info for StreamingDetectIntent ([01db330](https://github.com/googleapis/google-cloud-java/commit/01db33038b1aeafd984f7cc174daee193a58915b))
* added debug info for StreamingDetectIntent ([01db330](https://github.com/googleapis/google-cloud-java/commit/01db33038b1aeafd984f7cc174daee193a58915b))
* added debug info to StreamingDetectIntent ([20ddfda](https://github.com/googleapis/google-cloud-java/commit/20ddfda9258bbe089a978a17b37eca682f9d4a54))
* added debug info to StreamingDetectIntent ([20ddfda](https://github.com/googleapis/google-cloud-java/commit/20ddfda9258bbe089a978a17b37eca682f9d4a54))
* added dtmf digits to WebhookRequest ([20ddfda](https://github.com/googleapis/google-cloud-java/commit/20ddfda9258bbe089a978a17b37eca682f9d4a54))
* added dtmf digits to WebhookRequest ([20ddfda](https://github.com/googleapis/google-cloud-java/commit/20ddfda9258bbe089a978a17b37eca682f9d4a54))
* added FLOW as a new DiffType in TestRunDifference ([20ddfda](https://github.com/googleapis/google-cloud-java/commit/20ddfda9258bbe089a978a17b37eca682f9d4a54))
* added FLOW as a new DiffType in TestRunDifference ([20ddfda](https://github.com/googleapis/google-cloud-java/commit/20ddfda9258bbe089a978a17b37eca682f9d4a54))
* added GenerateStatelessSummary method ([01db330](https://github.com/googleapis/google-cloud-java/commit/01db33038b1aeafd984f7cc174daee193a58915b))
* added GenerateStatelessSummary method ([01db330](https://github.com/googleapis/google-cloud-java/commit/01db33038b1aeafd984f7cc174daee193a58915b))
* added support for in cluster verification ([bc3cddf](https://github.com/googleapis/google-cloud-java/commit/bc3cddf37545cc4ccca589ac4f1c7710294503c1))


### Bug Fixes

* [jobs] change timeout settings for SearchJobsForAlert ([#9401](https://github.com/googleapis/google-cloud-java/issues/9401)) ([27d6133](https://github.com/googleapis/google-cloud-java/commit/27d613374dcf2a0fd858adc7f9b61b6e16bdc04c))
* [tpu] restrict the visibility of an API ([#9406](https://github.com/googleapis/google-cloud-java/issues/9406)) ([3c9e001](https://github.com/googleapis/google-cloud-java/commit/3c9e001fd1619a8af96269d0e5084b73c4c1c726))
* **deps:** update dependency com.google.cloud:google-cloud-pubsub-bom to v1.123.11 ([#9390](https://github.com/googleapis/google-cloud-java/issues/9390)) ([51d198b](https://github.com/googleapis/google-cloud-java/commit/51d198b0b6efca375de8ae5e79abb3c51a139c7e))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.9.0 ([#9418](https://github.com/googleapis/google-cloud-java/issues/9418)) ([bc93613](https://github.com/googleapis/google-cloud-java/commit/bc936134f4a5135ea84c264b30bda75e7607cb4e))
* **deps:** update dependency com.google.cloud:google-cloud-storage to v2.22.1 ([#9386](https://github.com/googleapis/google-cloud-java/issues/9386)) ([5855ba3](https://github.com/googleapis/google-cloud-java/commit/5855ba3e6b74a21a6b3d2550d3367881ab0dbbcf))


### Documentation

* [cloudresourcemanager] Update formatting for `Purpose` class documentation ([#9395](https://github.com/googleapis/google-cloud-java/issues/9395)) ([9cf11de](https://github.com/googleapis/google-cloud-java/commit/9cf11de74686dff35e78cdce4e74d1444e4097c0))
* [cloudresourcemanager] Update the table format in SearchProjects docs ([9cf11de](https://github.com/googleapis/google-cloud-java/commit/9cf11de74686dff35e78cdce4e74d1444e4097c0))
* [texttospeech] update documentation to require certain fields ([#9417](https://github.com/googleapis/google-cloud-java/issues/9417)) ([270cc23](https://github.com/googleapis/google-cloud-java/commit/270cc239a39a488084255711c8a62d9ec0f7f6bd))
* Add documentation for additional acceptable formats for `namespaced_tag_key` and `namespaced_tag_value`in `EffectiveTag`, `parent` in `ListTagKeysRequest`, `parent` in `TagKey`, and `namespaced_name` in `TagValue` ([9cf11de](https://github.com/googleapis/google-cloud-java/commit/9cf11de74686dff35e78cdce4e74d1444e4097c0))
* adjust documentation wording ([487e38d](https://github.com/googleapis/google-cloud-java/commit/487e38d8c4184c98fa714618274a295f677a3b98))
* applied general style guide updates to descriptions ([0ebf4af](https://github.com/googleapis/google-cloud-java/commit/0ebf4af22c0f4269cfe5fa9cfc5a10005389b1f5))
* clarified that vpcConnector shortname is only returned if the connector is in the same project as the function ([0ebf4af](https://github.com/googleapis/google-cloud-java/commit/0ebf4af22c0f4269cfe5fa9cfc5a10005389b1f5))
* keep the API doc up-to-date with recent changes ([23b1396](https://github.com/googleapis/google-cloud-java/commit/23b1396e8b3efe2df7b6687277f10551cd41975d))
* updated comments for multiple Dataplex APIs ([b7c785a](https://github.com/googleapis/google-cloud-java/commit/b7c785a6e7552e75697536a4d9a100de38d856b1))

## [1.10.0](https://github.com/googleapis/google-cloud-java/compare/v1.9.0...v1.10.0) (2023-04-26)


### ⚠ BREAKING CHANGES

* [retail] fix the HTTP format for merchant center link service ([#9360](https://github.com/googleapis/google-cloud-java/issues/9360))

### Features

* [aiplatform] add is_default to Tensorboard in aiplatform v1 tensorboard.proto and v1beta1 tensorboard.proto ([#9355](https://github.com/googleapis/google-cloud-java/issues/9355)) ([3074871](https://github.com/googleapis/google-cloud-java/commit/3074871c8b1a4ef1d081940041a566bb187c928a))
* [analyticsadmin] add `FetchConnectedGa4Property` method to the Admin API v1alpha ([#9378](https://github.com/googleapis/google-cloud-java/issues/9378)) ([f3c56a9](https://github.com/googleapis/google-cloud-java/commit/f3c56a90254731d8edb3785ae2af27be4f4eb56a))
* [cloudbuild] Add PeeredNetworkIpRange to NetworkConfigs message ([#9358](https://github.com/googleapis/google-cloud-java/issues/9358)) ([3aeb0df](https://github.com/googleapis/google-cloud-java/commit/3aeb0df96fdb98c17dab2cc807a960583ef92c37))
* [cloudresourcemanager] add TagHolds, GetNamespacedTagKey, and GetNamespacedTagValue APIs. Adds support for project parented tags ([#9369](https://github.com/googleapis/google-cloud-java/issues/9369)) ([b47972a](https://github.com/googleapis/google-cloud-java/commit/b47972a741efd27b55ef99835eb77a624670b35d))
* [dataproc] update go_package to v2 in google.cloud.dataproc.v1 ([#9361](https://github.com/googleapis/google-cloud-java/issues/9361)) ([b76174e](https://github.com/googleapis/google-cloud-java/commit/b76174e3d2da090a80010ceeb507d751ad7618e1))
* [discoveryengine] add search, autocomplete and schema services ([#9374](https://github.com/googleapis/google-cloud-java/issues/9374)) ([73e9031](https://github.com/googleapis/google-cloud-java/commit/73e9031d446216da337edd19873d6cdaf793b7d3))
* [gkehub] add `monitoring_config` field ([#9370](https://github.com/googleapis/google-cloud-java/issues/9370)) ([80e0262](https://github.com/googleapis/google-cloud-java/commit/80e0262b3e57bf4db785f3d58d00e1fde2e0e1b3))
* [metastore] added ScalingConfig (v1) ([#9350](https://github.com/googleapis/google-cloud-java/issues/9350)) ([8174107](https://github.com/googleapis/google-cloud-java/commit/8174107daa84abed6e138daa4b25748e020d3302))
* [orchestration-airflow] add airflow_byoid_uri field to Cloud Composer API ([#9383](https://github.com/googleapis/google-cloud-java/issues/9383)) ([083a96b](https://github.com/googleapis/google-cloud-java/commit/083a96b6f7e687a57e3f30e72f9f10692e6e3c45))
* [securitycenter] add cloud_dlp_inspection and cloud_dlp_data_profile fields to finding's list of attributes ([#9371](https://github.com/googleapis/google-cloud-java/issues/9371)) ([9e1a89d](https://github.com/googleapis/google-cloud-java/commit/9e1a89d916134d9d3ed41b17138f7b3918d110e8))
* [storageinsights] new module for storageinsights ([#9367](https://github.com/googleapis/google-cloud-java/issues/9367)) ([149aef9](https://github.com/googleapis/google-cloud-java/commit/149aef940ad2a555c733301e78f86190bb64b01a))
* [tpu] make reservation_name parameter generally visible in QueuedResource message ([#9353](https://github.com/googleapis/google-cloud-java/issues/9353)) ([fd4b098](https://github.com/googleapis/google-cloud-java/commit/fd4b0987edbfe089d692caddd648928e254b4207))
* add unstructured document support (PDF/HTML) ([73e9031](https://github.com/googleapis/google-cloud-java/commit/73e9031d446216da337edd19873d6cdaf793b7d3))


### Bug Fixes

* [retail] fix the HTTP format for merchant center link service ([#9360](https://github.com/googleapis/google-cloud-java/issues/9360)) ([4725324](https://github.com/googleapis/google-cloud-java/commit/472532484ae5127ec40da1f95495db159374ddff))
* **deps:** update dependency com.google.apis:google-api-services-dns to v1-rev20230330-2.0.0 ([#9322](https://github.com/googleapis/google-cloud-java/issues/9322)) ([c02ff98](https://github.com/googleapis/google-cloud-java/commit/c02ff98d7664f36b433ce7c265da004d29ecec9a))
* **deps:** update dependency com.google.cloud:google-cloud-pubsub-bom to v1.123.10 ([#9311](https://github.com/googleapis/google-cloud-java/issues/9311)) ([047de7d](https://github.com/googleapis/google-cloud-java/commit/047de7de577f75ec8900ce0894216bfe9213e059))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.8.0 ([#9381](https://github.com/googleapis/google-cloud-java/issues/9381)) ([465bb96](https://github.com/googleapis/google-cloud-java/commit/465bb96eed2e9edea3b737f3cbc6e4e0cbf2c140))
* **deps:** update dependency com.google.cloud:google-cloud-storage to v2.22.0 ([#9309](https://github.com/googleapis/google-cloud-java/issues/9309)) ([e928167](https://github.com/googleapis/google-cloud-java/commit/e9281675d0021d051028bba52c2a7cf93bedd1a8))


### Documentation

* [container] Operation.Type is now documented in detail ([#9351](https://github.com/googleapis/google-cloud-java/issues/9351)) ([6bec519](https://github.com/googleapis/google-cloud-java/commit/6bec5191f4b4af615f1c94f4d047c3e46b62068c))
* [maps-addressvalidation] Update description of the postal address ([#9354](https://github.com/googleapis/google-cloud-java/issues/9354)) ([d6c0174](https://github.com/googleapis/google-cloud-java/commit/d6c0174c4888d057fed99df5b75c5c35bdd812f2))
* [networkmanagement] Update comments in Connectivity Test protos ([#9362](https://github.com/googleapis/google-cloud-java/issues/9362)) ([5c47061](https://github.com/googleapis/google-cloud-java/commit/5c470613686222a6fd11aeaca4b433396a32c122))
* keep the API doc up-to-date with recent changes ([73e9031](https://github.com/googleapis/google-cloud-java/commit/73e9031d446216da337edd19873d6cdaf793b7d3))

## [1.9.0](https://github.com/googleapis/google-cloud-java/compare/v1.8.0...v1.9.0) (2023-04-13)


### Features

* [aiplatform] add notification_channels in aiplatform v1beta1 model_monitoring.proto ([#9295](https://github.com/googleapis/google-cloud-java/issues/9295)) ([30618bd](https://github.com/googleapis/google-cloud-java/commit/30618bd6db6f6b0cb7c22914e699388344509fbe))
* [biglake] add BigQuery BigLake v1 API ([#9318](https://github.com/googleapis/google-cloud-java/issues/9318)) ([af5fdfc](https://github.com/googleapis/google-cloud-java/commit/af5fdfc854a42d851d66976b18ade44e34605986))
* [cloudasset] Add client library support for AssetService v1 AnalyzeOrgPolicies API ([#9296](https://github.com/googleapis/google-cloud-java/issues/9296)) ([1e50062](https://github.com/googleapis/google-cloud-java/commit/1e500627a9b05313ae66d94c2ac0770eb5ce5182))
* [confidentialcomputing] new module for confidentialcomputing ([#9335](https://github.com/googleapis/google-cloud-java/issues/9335)) ([4b824cc](https://github.com/googleapis/google-cloud-java/commit/4b824ccf54704ac7223dcfa6fb3d16e5bdc41672))
* [contactcenterinsights] Launch UploadConversation endpoint ([#9319](https://github.com/googleapis/google-cloud-java/issues/9319)) ([9dade7a](https://github.com/googleapis/google-cloud-java/commit/9dade7a7c212cc31e5cc4723935fcf7e71706131))
* [container] Add support for updating additional pod IPv4 ranges for Standard and Autopilot clusters ([#9303](https://github.com/googleapis/google-cloud-java/issues/9303)) ([e8cd90c](https://github.com/googleapis/google-cloud-java/commit/e8cd90c11ac336b819a40f645aa0f306b3214864))
* [containeranalysis] add enum for grafeas v1 cvss to support both cvss v2 and v3 ([#9341](https://github.com/googleapis/google-cloud-java/issues/9341)) ([121a9a9](https://github.com/googleapis/google-cloud-java/commit/121a9a91b6c1451b41ab4efba96f0ea538d23fe3))
* [privateca] added ignore_dependent_resources to DeleteCaPoolRequest, DeleteCertificateAuthorityRequest, DisableCertificateAuthorityRequest ([#9317](https://github.com/googleapis/google-cloud-java/issues/9317)) ([87dc1fc](https://github.com/googleapis/google-cloud-java/commit/87dc1fcceb23e0245b59648c986aa5b086539cc4))
* [retail] add merchant center link service ([#9328](https://github.com/googleapis/google-cloud-java/issues/9328)) ([30a8c33](https://github.com/googleapis/google-cloud-java/commit/30a8c33ac1ef00596fa08ccc37847f2ea65f1cbd))
* [securitycenter] released securitycenter/v1 SHA custom modules cloud libraries: Create, Get, List, Update, Delete ([#9331](https://github.com/googleapis/google-cloud-java/issues/9331)) ([287315c](https://github.com/googleapis/google-cloud-java/commit/287315c2bb62b05b7e8d0ffd40333131f4a3c7b2))
* [transcoder] add support for batch processing mode ([#9339](https://github.com/googleapis/google-cloud-java/issues/9339)) ([1f6ad2f](https://github.com/googleapis/google-cloud-java/commit/1f6ad2fd3fec18c82b2b107bd12be65919a49405))
* add php, csharp, ruby client library API support ([#9310](https://github.com/googleapis/google-cloud-java/issues/9310)) ([d7275b3](https://github.com/googleapis/google-cloud-java/commit/d7275b365e6b4063939649db531c5dda15171255))


### Bug Fixes

* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.7.0 ([#9332](https://github.com/googleapis/google-cloud-java/issues/9332)) ([accaab5](https://github.com/googleapis/google-cloud-java/commit/accaab5a12db3ba9ed6dcd5e96625d76af22a8f5))


### Documentation

* [appengine] point to Search Console for domain ownership verification ([#9302](https://github.com/googleapis/google-cloud-java/issues/9302)) ([98cfd14](https://github.com/googleapis/google-cloud-java/commit/98cfd14b5022a4a7adf3ff5453dcc59b438d6e41))
* [maps-addressvalidation] Update some Address Validation API proto descriptions to improve clarity ([#9327](https://github.com/googleapis/google-cloud-java/issues/9327)) ([b7d1d45](https://github.com/googleapis/google-cloud-java/commit/b7d1d45761cb6eb9a1d8ad331a2e2adceda384b1))
* [workstations] Adjust wording around service accounts and control planes ([#9321](https://github.com/googleapis/google-cloud-java/issues/9321)) ([cb475f3](https://github.com/googleapis/google-cloud-java/commit/cb475f3ba6711eefeb2b5fe408abb63fbacba0e0))
* README.md to have Libraries BOM usage guide ([#9301](https://github.com/googleapis/google-cloud-java/issues/9301)) ([c89fbe3](https://github.com/googleapis/google-cloud-java/commit/c89fbe3d59429c01de3e3130aad293cdaf6b5a5d))
* troubleshooting guide for logging ([#9315](https://github.com/googleapis/google-cloud-java/issues/9315)) ([971eb78](https://github.com/googleapis/google-cloud-java/commit/971eb785c3b63211ae28b604953db7f8238636fb))

## [1.8.0](https://github.com/googleapis/google-cloud-java/compare/v1.7.0...v1.8.0) (2023-03-30)


### Features

* [advisorynotifications] updating Cloud Client Libraries with new field NotificationType for advisorynotifications.googleapis.com ([#9290](https://github.com/googleapis/google-cloud-java/issues/9290)) ([3c73dee](https://github.com/googleapis/google-cloud-java/commit/3c73dee1834ae21fc6dc1b6d4638ba6c0b7d4715))


### Bug Fixes

* **deps:** update dependency com.google.cloud:google-cloud-pubsub-bom to v1.123.7 ([#9269](https://github.com/googleapis/google-cloud-java/issues/9269)) ([e018539](https://github.com/googleapis/google-cloud-java/commit/e018539a8d403033ddaf697838c952a22e2b5f44))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.6.0 ([#9282](https://github.com/googleapis/google-cloud-java/issues/9282)) ([f8a662a](https://github.com/googleapis/google-cloud-java/commit/f8a662ab38ec2c20c190cf0fabad3c7bdf4c76f9))
* **deps:** update dependency com.google.cloud:google-cloud-storage to v2.20.2 ([#9274](https://github.com/googleapis/google-cloud-java/issues/9274)) ([82b3cae](https://github.com/googleapis/google-cloud-java/commit/82b3cae8d98084327e46cf2f0673ad90fb0f4bad))

## [1.7.0](https://github.com/googleapis/google-cloud-java/compare/v1.6.0...v1.7.0) (2023-03-16)


### Features

* [aiplatform] add disable_container_logging to BatchPredictionJob in aiplatform v1,v1beta1 batch_prediction_job.proto ([#9184](https://github.com/googleapis/google-cloud-java/issues/9184)) ([7044b6c](https://github.com/googleapis/google-cloud-java/commit/7044b6c54b503b5120b6fe1434eed504c89c30c0))
* [aiplatform] add TPU_V4_POD to AcceleratorType in aiplatform v1 accelerator_type.proto ([7044b6c](https://github.com/googleapis/google-cloud-java/commit/7044b6c54b503b5120b6fe1434eed504c89c30c0))
* [aiplatform] add TPU_V4_POD to AcceleratorType in aiplatform v1beta1 accelerator_type.proto ([7044b6c](https://github.com/googleapis/google-cloud-java/commit/7044b6c54b503b5120b6fe1434eed504c89c30c0))
* [batch] added StatusEvent.task_state ([#9177](https://github.com/googleapis/google-cloud-java/issues/9177)) ([e9caf21](https://github.com/googleapis/google-cloud-java/commit/e9caf2145612488be4fd39c96ecefd765ef0db15))
* [batch] resource usage ([e9caf21](https://github.com/googleapis/google-cloud-java/commit/e9caf2145612488be4fd39c96ecefd765ef0db15))
* [biglake] new module for biglake ([#9237](https://github.com/googleapis/google-cloud-java/issues/9237)) ([c92a33e](https://github.com/googleapis/google-cloud-java/commit/c92a33e43c63537057d9b3fedd371d0f3ed37bca))
* [bigqueryconnection] add spark connection properties type ([#9242](https://github.com/googleapis/google-cloud-java/issues/9242)) ([b2fd7e3](https://github.com/googleapis/google-cloud-java/commit/b2fd7e3bd44baaf025ef9efab711604e38102de1))
* [cloudbuild] Add DefaultLogsBucketBehavior to BuildOptions ([#9196](https://github.com/googleapis/google-cloud-java/issues/9196)) ([fb87690](https://github.com/googleapis/google-cloud-java/commit/fb876902cb6ad7b19688d66df091d362a43f80f9))
* [cloudchannel] add show_future_offers to ListOffers ([#9212](https://github.com/googleapis/google-cloud-java/issues/9212)) ([752495f](https://github.com/googleapis/google-cloud-java/commit/752495fe41d7594c83b7c9e87f3851b0e3b423ae))
* [cloudfunctions] add `available_cpu ` field ([#9231](https://github.com/googleapis/google-cloud-java/issues/9231)) ([8e44284](https://github.com/googleapis/google-cloud-java/commit/8e44284d33ff8f43f28cea98dda509b5a798e543))
* [cloudkms] add support for Coordinated External Keys ([#9197](https://github.com/googleapis/google-cloud-java/issues/9197)) ([8f2119d](https://github.com/googleapis/google-cloud-java/commit/8f2119d35384184b1d3d8de850b195daefcf98a3))
* [cloudscheduler] Location API methods ([#9181](https://github.com/googleapis/google-cloud-java/issues/9181)) ([d9c7ee5](https://github.com/googleapis/google-cloud-java/commit/d9c7ee510a1c128584f4ce41644e125c33f156dc))
* [compute] Update Compute Engine API to revision 20230307 ([#770](https://github.com/googleapis/google-cloud-java/issues/770)) ([#9230](https://github.com/googleapis/google-cloud-java/issues/9230)) ([405cb92](https://github.com/googleapis/google-cloud-java/commit/405cb92007e1539c319460faecac743f7c38c54b))
* [contactcenterinsights] add a way to specify the conversation automatic analysis percentage for the UploadConversation API when creating Analyses in Insights ([a9bffaa](https://github.com/googleapis/google-cloud-java/commit/a9bffaa4fdefa1195a7da01c0c3c32406e5f265c))
* [containeranalysis] Add VULNERABILITY_ASSESSMENT Note type to grafeas v1 API, adds Vex_Assessment derived from the Note to resources' occurrences, VEX notes now be written to add CVE assessments ([#9183](https://github.com/googleapis/google-cloud-java/issues/9183)) ([460b25b](https://github.com/googleapis/google-cloud-java/commit/460b25be090ea2d1125bf0729eced9d632bd995d))
* [containeranalysis] Import of Grafeas from Github ([460b25b](https://github.com/googleapis/google-cloud-java/commit/460b25be090ea2d1125bf0729eced9d632bd995d))
* [datacatalog] add support for new ImportEntries() API, including format of the dump ([#9214](https://github.com/googleapis/google-cloud-java/issues/9214)) ([1cd532f](https://github.com/googleapis/google-cloud-java/commit/1cd532f0c79eb9627f4532a1aabb92969492393d))
* [dialogflow] added support for custom content types ([4e9b04a](https://github.com/googleapis/google-cloud-java/commit/4e9b04ae2cf2b6120bc186728797c63448f1e4e2))
* [dialogflow] added support for custom content types ([#9185](https://github.com/googleapis/google-cloud-java/issues/9185)) ([4e9b04a](https://github.com/googleapis/google-cloud-java/commit/4e9b04ae2cf2b6120bc186728797c63448f1e4e2))
* [documentai] added hints.language_hints field in OcrConfig ([a293c4e](https://github.com/googleapis/google-cloud-java/commit/a293c4e636aa2b7223e439900578ca086c04e5d4))
* [recaptchaenterprise] add reCAPTCHA Enterprise Fraud Prevention API ([#9241](https://github.com/googleapis/google-cloud-java/issues/9241)) ([dd84904](https://github.com/googleapis/google-cloud-java/commit/dd8490483ed36ac134c5e6f159e11bf6a231ea6b))
* [workstations] new module for workstations ([#9233](https://github.com/googleapis/google-cloud-java/issues/9233)) ([d7010bd](https://github.com/googleapis/google-cloud-java/commit/d7010bdbe1092c4ab9b39b30690c5c297f405d26))
* add BatchImportEvaluatedAnnotations rpc to aiplatform v1 model_service.proto ([7044b6c](https://github.com/googleapis/google-cloud-java/commit/7044b6c54b503b5120b6fe1434eed504c89c30c0))
* add BatchImportEvaluatedAnnotations rpc to aiplatform v1beta1 model_service.proto ([7044b6c](https://github.com/googleapis/google-cloud-java/commit/7044b6c54b503b5120b6fe1434eed504c89c30c0))
* add cpu_utilization_target to Featurestore.OnlineServingConfig.Scaling in aiplatform v1 featurestore.proto ([7044b6c](https://github.com/googleapis/google-cloud-java/commit/7044b6c54b503b5120b6fe1434eed504c89c30c0))
* add cpu_utilization_target to Featurestore.OnlineServingConfig.Scaling in aiplatform v1beta1 featurestore.proto ([7044b6c](https://github.com/googleapis/google-cloud-java/commit/7044b6c54b503b5120b6fe1434eed504c89c30c0))
* add evaluated_annotation.proto to aiplatform v1 ([7044b6c](https://github.com/googleapis/google-cloud-java/commit/7044b6c54b503b5120b6fe1434eed504c89c30c0))
* add evaluated_annotation.proto to aiplatform v1beta1 ([7044b6c](https://github.com/googleapis/google-cloud-java/commit/7044b6c54b503b5120b6fe1434eed504c89c30c0))
* add large_model_reference to Model in aiplatform v1beta1 model.proto ([7044b6c](https://github.com/googleapis/google-cloud-java/commit/7044b6c54b503b5120b6fe1434eed504c89c30c0))
* add offline_storage_ttl_days to EntityType in aiplatform v1 entity_type.proto ([7044b6c](https://github.com/googleapis/google-cloud-java/commit/7044b6c54b503b5120b6fe1434eed504c89c30c0))
* add online_storage_ttl_days to Featurestore in aiplatform v1 featurestore.proto ([7044b6c](https://github.com/googleapis/google-cloud-java/commit/7044b6c54b503b5120b6fe1434eed504c89c30c0))
* add slice_spec to ModelEvaluationSlice in aiplatform v1 model_evaluation_slice.proto ([7044b6c](https://github.com/googleapis/google-cloud-java/commit/7044b6c54b503b5120b6fe1434eed504c89c30c0))
* add slice_spec to ModelEvaluationSlice in aiplatform v1beta1 model_evaluation_slice.proto ([7044b6c](https://github.com/googleapis/google-cloud-java/commit/7044b6c54b503b5120b6fe1434eed504c89c30c0))
* add split to ExportDataConfig in aiplatform v1 dataset.proto ([7044b6c](https://github.com/googleapis/google-cloud-java/commit/7044b6c54b503b5120b6fe1434eed504c89c30c0))
* add split to ExportDataConfig in aiplatform v1beta1 dataset.proto ([7044b6c](https://github.com/googleapis/google-cloud-java/commit/7044b6c54b503b5120b6fe1434eed504c89c30c0))
* added enable_image_quality_scores field in OcrConfig ([a293c4e](https://github.com/googleapis/google-cloud-java/commit/a293c4e636aa2b7223e439900578ca086c04e5d4))
* added enable_symbol field in OcrConfig ([a293c4e](https://github.com/googleapis/google-cloud-java/commit/a293c4e636aa2b7223e439900578ca086c04e5d4))


### Bug Fixes

* [cloudbuild] Add service_yaml_parameters to `java_gapic_library` targets ([fb87690](https://github.com/googleapis/google-cloud-java/commit/fb876902cb6ad7b19688d66df091d362a43f80f9))
* [cloudbuild] change java package of Cloud Build v2 ([fb87690](https://github.com/googleapis/google-cloud-java/commit/fb876902cb6ad7b19688d66df091d362a43f80f9))
* [cloudbuild] change java package of Cloud Build v2 ([#9218](https://github.com/googleapis/google-cloud-java/issues/9218)) ([49da4af](https://github.com/googleapis/google-cloud-java/commit/49da4af1edcdafa021a57c395bff2a5ef04cac74))
* [contactcenterinsights] Add service_yaml_parameters to `java_gapic_library` targets ([#9176](https://github.com/googleapis/google-cloud-java/issues/9176)) ([a9bffaa](https://github.com/googleapis/google-cloud-java/commit/a9bffaa4fdefa1195a7da01c0c3c32406e5f265c))
* [dialogflow-cx] change java package of Cloud Build v2 ([#9195](https://github.com/googleapis/google-cloud-java/issues/9195)) ([aa813d5](https://github.com/googleapis/google-cloud-java/commit/aa813d581bb092cce53b067181c75d499040cbb7))
* [distributedcloudedge] Add service_yaml parameters to edgecontainer GAPIC targets ([#9189](https://github.com/googleapis/google-cloud-java/issues/9189)) ([b0d4320](https://github.com/googleapis/google-cloud-java/commit/b0d43200dd35d2311ed2a35658142b829266e56a))
* [documentai] Add service_yaml_parameters to `java_gapic_library` targets ([#9200](https://github.com/googleapis/google-cloud-java/issues/9200)) ([a293c4e](https://github.com/googleapis/google-cloud-java/commit/a293c4e636aa2b7223e439900578ca086c04e5d4))
* [file] set longer polling timeouts for filestore DeleteBackup ([#9216](https://github.com/googleapis/google-cloud-java/issues/9216)) ([2a51320](https://github.com/googleapis/google-cloud-java/commit/2a513204fd642de8023a2e231e5269a2fd8f4c63))
* [Many APIs] Add service_yaml_parameters to `java_gapic_library` targets ([#9203](https://github.com/googleapis/google-cloud-java/issues/9203)) ([6eca244](https://github.com/googleapis/google-cloud-java/commit/6eca244f800e84ac88cabe01982529074d6621b8))
* [Many APIs] Add service_yaml_parameters to `java_gapic_library` targets ([#9204](https://github.com/googleapis/google-cloud-java/issues/9204)) ([a98abeb](https://github.com/googleapis/google-cloud-java/commit/a98abeb76665699b84110a9b41c57c86c68ea455))
* [Many APIs] Add service_yaml_parameters to `java_gapic_library` targets ([#9205](https://github.com/googleapis/google-cloud-java/issues/9205)) ([ecb1a13](https://github.com/googleapis/google-cloud-java/commit/ecb1a1348db6835b277f2e81c10b75d7f8249600))
* [workflows] Add service_yaml_parameters to `java_gapic_library` targets ([#9206](https://github.com/googleapis/google-cloud-java/issues/9206)) ([64dc942](https://github.com/googleapis/google-cloud-java/commit/64dc942b7e813612980301d0863c5ebc1f0c60b9))
* **deps:** update dependency com.google.api:gapic-generator-java-bom to v2.15.3 ([#9217](https://github.com/googleapis/google-cloud-java/issues/9217)) ([0fbe3d1](https://github.com/googleapis/google-cloud-java/commit/0fbe3d1823285222b94b34c63cc50c8ee25a6971))
* **deps:** update dependency com.google.apis:google-api-services-storage to v1-rev20230301-2.0.0 ([#9224](https://github.com/googleapis/google-cloud-java/issues/9224)) ([531fd2b](https://github.com/googleapis/google-cloud-java/commit/531fd2b98259bad6a897364c0a8932221738be6c))
* **deps:** update dependency com.google.cloud:google-cloud-pubsub-bom to v1.123.5 ([#9191](https://github.com/googleapis/google-cloud-java/issues/9191)) ([f58e887](https://github.com/googleapis/google-cloud-java/commit/f58e8872cc17dc0be53de90b133ae09fcfff9539))
* **deps:** update dependency com.google.cloud:google-cloud-pubsub-bom to v1.123.6 ([#9240](https://github.com/googleapis/google-cloud-java/issues/9240)) ([8ea4ea3](https://github.com/googleapis/google-cloud-java/commit/8ea4ea35c9cf2d5aacb0bbbd3379cb1743871c41))
* **deps:** update dependency com.google.cloud:google-cloud-storage to v2.20.1 ([#9198](https://github.com/googleapis/google-cloud-java/issues/9198)) ([ca26089](https://github.com/googleapis/google-cloud-java/commit/ca260891703447a8129c250fa8e64aa05ce7a5d9))
* **deps:** update dependency com.google.http-client:google-http-client-bom to v1.43.1 ([#9213](https://github.com/googleapis/google-cloud-java/issues/9213)) ([f31a54d](https://github.com/googleapis/google-cloud-java/commit/f31a54d9dd334c89c82dac907a1b9efaa0f5a5d3))
* **deps:** update dependency org.checkerframework:checker-qual to v3.32.0 ([#9182](https://github.com/googleapis/google-cloud-java/issues/9182)) ([8c47ddc](https://github.com/googleapis/google-cloud-java/commit/8c47ddc92677997e4fb511a716a38753ebdad990))
* **speech:** increment retry setting values and test timeout values in IT ([#9188](https://github.com/googleapis/google-cloud-java/issues/9188)) ([b72fe9d](https://github.com/googleapis/google-cloud-java/commit/b72fe9d68c5892b587a5be36ba12b33165a71be9))


### Documentation

* [container] minor typo fix ([169bba9](https://github.com/googleapis/google-cloud-java/commit/169bba9c956cd2c30dd32cd89d7408a69bd77345))
* [container] minor typo fix ([#9190](https://github.com/googleapis/google-cloud-java/issues/9190)) ([169bba9](https://github.com/googleapis/google-cloud-java/commit/169bba9c956cd2c30dd32cd89d7408a69bd77345))
* [dialogflow-cx] clarified wording around quota usage ([#9209](https://github.com/googleapis/google-cloud-java/issues/9209)) ([bcb6df2](https://github.com/googleapis/google-cloud-java/commit/bcb6df25961316c739ab275e3538240a37aec5e7))
* [maps-routing] clarify usage of compute_alternative_routes in proto comment ([#9201](https://github.com/googleapis/google-cloud-java/issues/9201)) ([51bca7c](https://github.com/googleapis/google-cloud-java/commit/51bca7cc03768ee6e1064c184393ac914b5f013f))
* clarified wording around quota usage ([4e9b04a](https://github.com/googleapis/google-cloud-java/commit/4e9b04ae2cf2b6120bc186728797c63448f1e4e2))
* clarified wording around quota usage ([4e9b04a](https://github.com/googleapis/google-cloud-java/commit/4e9b04ae2cf2b6120bc186728797c63448f1e4e2))
* deprecated enable_restricted_image_training in NasJob in aiplatform v1beta1 nas_job.proto ([7044b6c](https://github.com/googleapis/google-cloud-java/commit/7044b6c54b503b5120b6fe1434eed504c89c30c0))
* update comments ([e9caf21](https://github.com/googleapis/google-cloud-java/commit/e9caf2145612488be4fd39c96ecefd765ef0db15))
* updated comments ([e9caf21](https://github.com/googleapis/google-cloud-java/commit/e9caf2145612488be4fd39c96ecefd765ef0db15))

## [1.6.0](https://github.com/googleapis/google-cloud-java/compare/v1.5.0...v1.6.0) (2023-03-01)


### Features

* [advisorynotifications] new module for advisorynotifications ([#9141](https://github.com/googleapis/google-cloud-java/issues/9141)) ([c84532c](https://github.com/googleapis/google-cloud-java/commit/c84532cb73633b1723c8adc5ba1cacfdc296b557))
* [aiplatform] add match service in aiplatform v1beta1 match_service.proto ([#9138](https://github.com/googleapis/google-cloud-java/issues/9138)) ([e20803d](https://github.com/googleapis/google-cloud-java/commit/e20803d4a47fb0dad3f7d85af27927e333f243a6))
* [alloydb] new module for alloydb ([#9170](https://github.com/googleapis/google-cloud-java/issues/9170)) ([7b6d3db](https://github.com/googleapis/google-cloud-java/commit/7b6d3db3a86e93bca2788e916de813eb0e023673))
* [analyticsadmin] add `CreateAccessBinding`, `GetAccessBinding`, `UpdateAccessBinding`, `DeleteAccessBinding`, `ListAccessBindings`, `BatchCreateAccessBindings`, `BatchGetAccessBindings`, `BatchUpdateAccessBindings`, `BatchDeleteAccessBindings` me... ([#9137](https://github.com/googleapis/google-cloud-java/issues/9137)) ([222829a](https://github.com/googleapis/google-cloud-java/commit/222829a721d680987f96fddb9b7dd0fa899ecc11))
* [bigquerymigration] Add SQL translation service to Bazel generation ([#9165](https://github.com/googleapis/google-cloud-java/issues/9165)) ([af85ace](https://github.com/googleapis/google-cloud-java/commit/af85ace90e0f3b69ab0d486dfc729bf7b804cafb))
* [dataproc] add support for new Dataproc features ([#9127](https://github.com/googleapis/google-cloud-java/issues/9127)) ([841366b](https://github.com/googleapis/google-cloud-java/commit/841366b8c25ed896de1c4c995ad85ae656d6b2ee))
* [dialogflow-cx] Added persist_parameter_changes field from `query_params` to MatchIntentRequest ([#9130](https://github.com/googleapis/google-cloud-java/issues/9130)) ([7fcde13](https://github.com/googleapis/google-cloud-java/commit/7fcde136372774152813b772d95269c0e135898f))
* [dialogflow-cx] Added persist_parameter_changes field from `query_params` to MatchIntentRequest ([#9168](https://github.com/googleapis/google-cloud-java/issues/9168)) ([c6d7b9a](https://github.com/googleapis/google-cloud-java/commit/c6d7b9a1eb0dcde3d3dac950c1c91659e64a1e14))
* [documentai] Added Training and Evaluation functions, request, responses and metadata to document_processor_service.proto ([#9145](https://github.com/googleapis/google-cloud-java/issues/9145)) ([79ee60b](https://github.com/googleapis/google-cloud-java/commit/79ee60b31f538d790a6aa0c3f8797921a50c7b42))
* [kmsinventory] new module for kmsinventory ([#9162](https://github.com/googleapis/google-cloud-java/issues/9162)) ([0fd61a4](https://github.com/googleapis/google-cloud-java/commit/0fd61a47f23a24e56f9516a444a524c877be16ed))
* [maps-mapsplatformdatasets] new module for maps-mapsplatformdatasets ([#9159](https://github.com/googleapis/google-cloud-java/issues/9159)) ([c8e3fc0](https://github.com/googleapis/google-cloud-java/commit/c8e3fc06ff043161db00900db1eab63ddf625e62))
* [speech] Voice Activity Detection: adding speech event time and speech event type ([#9154](https://github.com/googleapis/google-cloud-java/issues/9154)) ([bbc7ce4](https://github.com/googleapis/google-cloud-java/commit/bbc7ce43f3e03ac5ecef99b88054c0762c865f32))
* [transcoder] Specifying language code and display name for text and audio streams is now supported ([#9169](https://github.com/googleapis/google-cloud-java/issues/9169)) ([c998ac3](https://github.com/googleapis/google-cloud-java/commit/c998ac303fea009fdf4b1f8bde59128a728a6165))
* [translate] Add supported fields in document translation request and refresh translation v3 GA service proto documentation ([#9144](https://github.com/googleapis/google-cloud-java/issues/9144)) ([d6c639e](https://github.com/googleapis/google-cloud-java/commit/d6c639e1fe6d5765a3c890741716ea48fa17fd0d))


### Bug Fixes

* **deps:** update dependency com.google.cloud:google-cloud-pubsub-bom to v1.123.4 ([#9151](https://github.com/googleapis/google-cloud-java/issues/9151)) ([637e244](https://github.com/googleapis/google-cloud-java/commit/637e244b6dc924dd9344f814584ab043ff528f3d))
* **deps:** update dependency com.google.cloud:google-cloud-storage to v2.19.0 ([#9143](https://github.com/googleapis/google-cloud-java/issues/9143)) ([3ad0e70](https://github.com/googleapis/google-cloud-java/commit/3ad0e70bee0f70c8e8eb4bd935c34bf6735a1ac5))
* **deps:** update dependency com.google.http-client:google-http-client-bom to v1.43.0 ([#9157](https://github.com/googleapis/google-cloud-java/issues/9157)) ([f8f6ccf](https://github.com/googleapis/google-cloud-java/commit/f8f6ccffa55162529b8d6d67f17bc27648bad38d))
* **deps:** update dependency org.checkerframework:checker-qual to v3.31.0 ([#9136](https://github.com/googleapis/google-cloud-java/issues/9136)) ([82756bc](https://github.com/googleapis/google-cloud-java/commit/82756bc26d37c7aba371c5484fa44feb587e1ffa))


### Documentation

* [bigquerydatatransfer] minor comment update ([#9163](https://github.com/googleapis/google-cloud-java/issues/9163)) ([3015f71](https://github.com/googleapis/google-cloud-java/commit/3015f712b8de51a627bce50bbea712f31b6c7aae))
* [certificatemanager] corrected information about the limit of certificates that can be attached to a Certificate Map Entry ([#9167](https://github.com/googleapis/google-cloud-java/issues/9167)) ([74c459c](https://github.com/googleapis/google-cloud-java/commit/74c459cbfc31748ee461bffd6fc09d381c85c66d))
* [container] minor grammar improvements ([#9140](https://github.com/googleapis/google-cloud-java/issues/9140)) ([c4f8231](https://github.com/googleapis/google-cloud-java/commit/c4f8231aee5cb874190d396134decb3e88fb1f8c))

## [1.5.0](https://github.com/googleapis/google-cloud-java/compare/v1.4.0...v1.5.0) (2023-02-16)


### ⚠ BREAKING CHANGES

* The TrainProcessorVersion parent was incorrectly annotated.

### Features

* [analyticsadmin] add `GetSearchAds360Link`, `ListSearchAds360Links`, `CreateSearchAds360Link`, `DeleteSearchAds360Link`, `UpdateSearchAds360Link` methods to the Admin API v1alpha ([#9093](https://github.com/googleapis/google-cloud-java/issues/9093)) ([2c7e044](https://github.com/googleapis/google-cloud-java/commit/2c7e04488fc26db34a1972871455863da0ba8ecd))
* [artifactregistry] add format-specific resources `MavenArtifact`, `NpmPackage`, `KfpArtifact` and `PythonPackage` ([#9080](https://github.com/googleapis/google-cloud-java/issues/9080)) ([6e35902](https://github.com/googleapis/google-cloud-java/commit/6e35902716584603a61fe7253078188191c46d7d))
* [batch] support custom scopes for service account in v1 ([#9082](https://github.com/googleapis/google-cloud-java/issues/9082)) ([37a574a](https://github.com/googleapis/google-cloud-java/commit/37a574a11f78034d00e201ca6f8fecbc9cd6101c))
* [contactcenterinsights] Add IngestConversationsStats ([#9081](https://github.com/googleapis/google-cloud-java/issues/9081)) ([4175bea](https://github.com/googleapis/google-cloud-java/commit/4175bea0d87c75feced2e43421b3a2575840df9d))
* [dialogflow] added support for AssistQueryParameters and SynthesizeSpeechConfig ([#9123](https://github.com/googleapis/google-cloud-java/issues/9123)) ([aaf97a6](https://github.com/googleapis/google-cloud-java/commit/aaf97a6bbc7302e69315fdb1c434d69322b21853))
* [documentai] Added EvaluationReference to evaluation.proto ([#9085](https://github.com/googleapis/google-cloud-java/issues/9085)) ([935443d](https://github.com/googleapis/google-cloud-java/commit/935443d917998991dc6af62bd594091164017117))
* [privateca] add X.509 Name Constraints support ([#9117](https://github.com/googleapis/google-cloud-java/issues/9117)) ([146655a](https://github.com/googleapis/google-cloud-java/commit/146655ac1ae48b3741876740585395ca8d422041))


### Bug Fixes

* [cloudbuild] remove empty v2.CloudBuild definition ([#9077](https://github.com/googleapis/google-cloud-java/issues/9077)) ([bfc6efb](https://github.com/googleapis/google-cloud-java/commit/bfc6efb56d082e7b71e5977999f6ee4a7189e0b5))
* **deps:** update dependency com.google.api:gapic-generator-java-bom to v2.15.1 ([#9122](https://github.com/googleapis/google-cloud-java/issues/9122)) ([d00a849](https://github.com/googleapis/google-cloud-java/commit/d00a8493b7e18aa1792db8449f78d02258184668))
* **deps:** update dependency com.google.cloud:google-cloud-pubsub-bom to v1.123.2 ([#9084](https://github.com/googleapis/google-cloud-java/issues/9084)) ([5ca2b77](https://github.com/googleapis/google-cloud-java/commit/5ca2b7753d5ba8c5483759b74a499dfdbd805fcd))
* **deps:** update dependency com.google.cloud:google-cloud-storage to v2.18.0 ([#9086](https://github.com/googleapis/google-cloud-java/issues/9086)) ([6dee1ae](https://github.com/googleapis/google-cloud-java/commit/6dee1ae1f7d913a78930700ba6d910d5b2d01dbb))
* **deps:** update dependency com.google.cloud:grpc-gcp to v1.4.1 ([#9059](https://github.com/googleapis/google-cloud-java/issues/9059)) ([78d0522](https://github.com/googleapis/google-cloud-java/commit/78d05227d7b910aa0a514c1aef05a0b5fa1cbad9))
* enable java-bigqueryconnect ITSystemTest ([#9089](https://github.com/googleapis/google-cloud-java/issues/9089)) ([0b7209a](https://github.com/googleapis/google-cloud-java/commit/0b7209ac1f38aa4005d619249a6f93f44aef7ca7))
* **java-core:** capturing startup logs and writing them to the logger incase end of stream reached ([#9108](https://github.com/googleapis/google-cloud-java/issues/9108)) ([def8637](https://github.com/googleapis/google-cloud-java/commit/def8637962f82dfa6c9bbbc88951d1ae4777270b))


### Documentation

* [clouderrorreporting] removed link to the regionalization page ([#9079](https://github.com/googleapis/google-cloud-java/issues/9079)) ([eaef8f9](https://github.com/googleapis/google-cloud-java/commit/eaef8f978ec8d7666638a1fc581d56bc44c915a3))

## [1.4.0](https://github.com/googleapis/google-cloud-java/compare/v1.3.0...v1.4.0) (2023-02-03)


### ⚠ BREAKING CHANGES

* [networkconnectivity] remove policy based routing API ([#9036](https://github.com/googleapis/google-cloud-java/issues/9036))
* [vmwareengine] resource proto messages moved to new file ([#9044](https://github.com/googleapis/google-cloud-java/issues/9044))

### Features

* [aiplatform] add service_networking.proto to aiplatform v1 ([#9073](https://github.com/googleapis/google-cloud-java/issues/9073)) ([3cebec3](https://github.com/googleapis/google-cloud-java/commit/3cebec3f6958dbf611473df55947b3d33d2ea6db))
* [dialogflow-cx] added JSON_PACKAGE field to ExportAgentRequest ([#9025](https://github.com/googleapis/google-cloud-java/issues/9025)) ([10bb0cb](https://github.com/googleapis/google-cloud-java/commit/10bb0cb494f64b864408ede46834e1046351370c))
* [documentai] added advanced_ocr_options field in OcrConfig ([#9042](https://github.com/googleapis/google-cloud-java/issues/9042)) ([f845147](https://github.com/googleapis/google-cloud-java/commit/f8451473516eb45bdd7251d3533c28da4a31e652))
* [gke-multi-cloud] Added support for Azure workload identity federation ([#9055](https://github.com/googleapis/google-cloud-java/issues/9055)) ([374fd84](https://github.com/googleapis/google-cloud-java/commit/374fd84892fa30c77bb61c0eb50d02358c5cbcc1))


### Bug Fixes

* [certificatemanager] workaround crashes in gRPC for C++ ([#9033](https://github.com/googleapis/google-cloud-java/issues/9033)) ([2bf4ad6](https://github.com/googleapis/google-cloud-java/commit/2bf4ad6a6f59eec0b6944617721aa94352b25b0b))
* [networkconnectivity] remove policy based routing API ([#9036](https://github.com/googleapis/google-cloud-java/issues/9036)) ([20c36b2](https://github.com/googleapis/google-cloud-java/commit/20c36b2df369868f5a07db98a40e8d2a7432f6e7))
* [tpu] proper http bindings for v2 API ([#9035](https://github.com/googleapis/google-cloud-java/issues/9035)) ([ec05dad](https://github.com/googleapis/google-cloud-java/commit/ec05dad77119cf97adcfe1a7d067d2591e234b51))
* **deps:** update dependency com.fasterxml.jackson:jackson-bom to v2.14.2 ([#9057](https://github.com/googleapis/google-cloud-java/issues/9057)) ([05c4183](https://github.com/googleapis/google-cloud-java/commit/05c4183a4151d82a472a5f1c289d8006e5deb999))
* **deps:** update dependency com.google.api-client:google-api-client-bom to v2.2.0 ([#9058](https://github.com/googleapis/google-cloud-java/issues/9058)) ([6f02472](https://github.com/googleapis/google-cloud-java/commit/6f024724263bda464947ba1e377c157f5e88d1e9))
* **deps:** update dependency com.google.api:gapic-generator-java-bom to v2.15.0 ([#9060](https://github.com/googleapis/google-cloud-java/issues/9060)) ([77d7442](https://github.com/googleapis/google-cloud-java/commit/77d7442a8d315c7826bbca2a0da8a8dce379a929))
* **deps:** update dependency com.google.apis:google-api-services-cloudresourcemanager to v1-rev20230129-2.0.0 ([#9049](https://github.com/googleapis/google-cloud-java/issues/9049)) ([c56075c](https://github.com/googleapis/google-cloud-java/commit/c56075c32040b95b90508d8fcf09a44161255dd0))
* **deps:** update dependency com.google.apis:google-api-services-dns to v1-rev20230126-2.0.0 ([#9047](https://github.com/googleapis/google-cloud-java/issues/9047)) ([1500a14](https://github.com/googleapis/google-cloud-java/commit/1500a144c3ee1f62701eb12ef8831fc07add06df))
* **deps:** update dependency com.google.cloud:google-cloud-storage to v2.17.2 ([#9023](https://github.com/googleapis/google-cloud-java/issues/9023)) ([c82e099](https://github.com/googleapis/google-cloud-java/commit/c82e0999d622ca4a536a94b2d9bd1bb014f54abc))
* **deps:** update dependency org.checkerframework:checker-qual to v3.30.0 ([#9063](https://github.com/googleapis/google-cloud-java/issues/9063)) ([30ebd0d](https://github.com/googleapis/google-cloud-java/commit/30ebd0dd699dc5499d2990a3935a97aff84ce171))
* Outdated versioning info in README.md ([#979](https://github.com/googleapis/google-cloud-java/issues/979)) ([b92c43b](https://github.com/googleapis/google-cloud-java/commit/b92c43b0124f05431f547aeebdc7860a45accae3))


### Documentation

* [cloudoptimization] clarification for deprecated fields ([#9062](https://github.com/googleapis/google-cloud-java/issues/9062)) ([8816cde](https://github.com/googleapis/google-cloud-java/commit/8816cde0b23ef5e64adfbf75796ca0f17e537703))
* [cloudtrace] Remove html formatting (cleanup) ([#9027](https://github.com/googleapis/google-cloud-java/issues/9027)) ([9591b89](https://github.com/googleapis/google-cloud-java/commit/9591b891f6fe7ad47f3a94e45da1b7823539d86a))
* [container] Add clarification on whether `NodePool.version` is a required field ([#9074](https://github.com/googleapis/google-cloud-java/issues/9074)) ([2bccdf3](https://github.com/googleapis/google-cloud-java/commit/2bccdf3a5f68f27cf5ba914e6b5b0c00202cd6af))
* [container] clarified wording around the NodePoolUpdateStrategy default behavior ([#9046](https://github.com/googleapis/google-cloud-java/issues/9046)) ([55e4de1](https://github.com/googleapis/google-cloud-java/commit/55e4de106b8f6fc41a706248ad3817d564367777))
* [container] Improve `version` documentation for `NodePool` ([#9061](https://github.com/googleapis/google-cloud-java/issues/9061)) ([dd109d8](https://github.com/googleapis/google-cloud-java/commit/dd109d865193bfeb809cdcdd9a5043edac253e91))
* [dataplex] Improvements to DataScan API documentation ([#9054](https://github.com/googleapis/google-cloud-java/issues/9054)) ([2396d77](https://github.com/googleapis/google-cloud-java/commit/2396d77e8d2f93169f9e04b8235f20c7560e3c04))
* [dialogflow] Reformat some comments and documentation ([#9024](https://github.com/googleapis/google-cloud-java/issues/9024)) ([2c1bd38](https://github.com/googleapis/google-cloud-java/commit/2c1bd383046e895f30a4c720ebbef7a7c78c9e0c))
* [speech] Clarified boost usage ([#9032](https://github.com/googleapis/google-cloud-java/issues/9032)) ([fd273d6](https://github.com/googleapis/google-cloud-java/commit/fd273d671446aedbb7662c48222f2b573cbf837a))
* [vmwareengine] resource proto messages moved to new file ([#9044](https://github.com/googleapis/google-cloud-java/issues/9044)) ([32bd679](https://github.com/googleapis/google-cloud-java/commit/32bd679cb746824c37a8c9c408f430e3728fd0d0))
* README.md to point to Cloud site ([#9034](https://github.com/googleapis/google-cloud-java/issues/9034)) ([67a0c22](https://github.com/googleapis/google-cloud-java/commit/67a0c22e4c00c1dec0f26ab170fa070898d52708))
* **ruby:** [datalineage] fixed formatting for several literal expressions ([#9026](https://github.com/googleapis/google-cloud-java/issues/9026)) ([7d96c4e](https://github.com/googleapis/google-cloud-java/commit/7d96c4ed28ed2b34d61f0503dae4cea3b13bbd82))

## [1.3.0](https://github.com/googleapis/google-cloud-java/compare/v1.2.0...v1.3.0) (2023-01-23)


### Features

* [aiplatform] add enable_dashboard_access in aiplatform v1 and v1beta1 ([ffaad0e](https://github.com/googleapis/google-cloud-java/commit/ffaad0e76a6111a36b7be661277dbe5a3c6ebcfa))
* [compute] Update Compute Engine API to revision 20221224 ([#760](https://github.com/googleapis/google-cloud-java/issues/760)) ([#9012](https://github.com/googleapis/google-cloud-java/issues/9012)) ([dc5891c](https://github.com/googleapis/google-cloud-java/commit/dc5891c67f13b66d3058dc2fbcbfd518bb85647b))
* [compute] Update Compute Engine API to revision 20230103 ([#769](https://github.com/googleapis/google-cloud-java/issues/769)) ([#9018](https://github.com/googleapis/google-cloud-java/issues/9018)) ([51340ea](https://github.com/googleapis/google-cloud-java/commit/51340ea2ff90be99804df18612d6f17011bf9b01))
* [container] Add support for viewing the subnet IPv6 CIDR and services IPv6 CIDR assigned to dual stack clusters ([22983e0](https://github.com/googleapis/google-cloud-java/commit/22983e042e14c2657e298bb7a523b4b24eb59eff))
* [datalineage] new module for datalineage ([#8996](https://github.com/googleapis/google-cloud-java/issues/8996)) ([ea8d17b](https://github.com/googleapis/google-cloud-java/commit/ea8d17b7f18daefa103965592891cf7d29e9ee60))
* [dataproc] add SPOT to Preemptibility enum ([ede0030](https://github.com/googleapis/google-cloud-java/commit/ede0030ae81475f801918d4722e45c52c6a65710))
* [dialogflow-cx] ResponseMessage proto contains channel information ([b0b9eb0](https://github.com/googleapis/google-cloud-java/commit/b0b9eb0113850371ce0e2930d3fda96791d62f55))
* [dialogflow-cx] Update Compute Engine API to revision 20221224 ([#760](https://github.com/googleapis/google-cloud-java/issues/760)) ([#8985](https://github.com/googleapis/google-cloud-java/issues/8985)) ([b0b9eb0](https://github.com/googleapis/google-cloud-java/commit/b0b9eb0113850371ce0e2930d3fda96791d62f55))
* [dialogflow] Added SuggestConversationSummary RPC ([97d92e8](https://github.com/googleapis/google-cloud-java/commit/97d92e8845dd1743030add05843341a40128133a))
* [documentai] exposed GetProcessorType to v1 ([267aa2d](https://github.com/googleapis/google-cloud-java/commit/267aa2d725f7098eb3b0ba3a28d964366ff3c17b))
* [documentai] exposed GetProcessorType to v1beta3 ([267aa2d](https://github.com/googleapis/google-cloud-java/commit/267aa2d725f7098eb3b0ba3a28d964366ff3c17b))
* [java-maps-routing] Add ExtraComputations feature to ComputeRoutes and ComputeRouteMatrix ([ba2b787](https://github.com/googleapis/google-cloud-java/commit/ba2b7873ee8619f32c1591dd408db60c9c1eda37))
* [orgpolicy] support for OrgPolicy dry runs ([bdd19f6](https://github.com/googleapis/google-cloud-java/commit/bdd19f66c2e69eb5938c6bb32065713e328f6131))
* [run] Adding support for encryption_key_revocation_action and encryption_key_shutdown_duration for RevisionTemplate and ExecutionTemplate ([#9013](https://github.com/googleapis/google-cloud-java/issues/9013)) ([af47cbc](https://github.com/googleapis/google-cloud-java/commit/af47cbc9184a18ddf8775144a11b6813bdbe3db1))
* Policy Analyzer for Organization Policy is publicly available ([a4eb152](https://github.com/googleapis/google-cloud-java/commit/a4eb15234f7d1a1ff2e08b46c34fc8ae36e2e76e))


### Bug Fixes

* **deps:** update dependency com.google.cloud:google-cloud-pubsub-bom to v1.123.1 ([#9019](https://github.com/googleapis/google-cloud-java/issues/9019)) ([e5d3310](https://github.com/googleapis/google-cloud-java/commit/e5d331023cabfc5aa01a6d17355e12e537a2f270))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.1.2 ([#9014](https://github.com/googleapis/google-cloud-java/issues/9014)) ([73ba595](https://github.com/googleapis/google-cloud-java/commit/73ba5953ea876d9d98b69528a80f76c6882b1532))
* **deps:** update dependency com.google.cloud:google-cloud-storage to v2.17.1 ([#8982](https://github.com/googleapis/google-cloud-java/issues/8982)) ([748057a](https://github.com/googleapis/google-cloud-java/commit/748057a6c028d4ea1fa9ef3cdea229fa8fe39677))
* update owlbot configs to copy generated samples ([#8790](https://github.com/googleapis/google-cloud-java/issues/8790)) ([5a404a8](https://github.com/googleapis/google-cloud-java/commit/5a404a8a0de9e2123c65e83f3f24fb770387f639))


### Documentation

* [cloudasset] Brand and typo fixes ([a4eb152](https://github.com/googleapis/google-cloud-java/commit/a4eb15234f7d1a1ff2e08b46c34fc8ae36e2e76e))
* [securitycenter] Update documentation for Security Command Center *.assets.list "parent" parameter ([7542a0d](https://github.com/googleapis/google-cloud-java/commit/7542a0d2712cb956d26f092da768e9ca0c861bee))
* Documentation improvements, including clarification that v1 labels/annotations are rejected in v2 API ([af47cbc](https://github.com/googleapis/google-cloud-java/commit/af47cbc9184a18ddf8775144a11b6813bdbe3db1))
* updated go library package ([b0b9eb0](https://github.com/googleapis/google-cloud-java/commit/b0b9eb0113850371ce0e2930d3fda96791d62f55))
* updated go library package ([97d92e8](https://github.com/googleapis/google-cloud-java/commit/97d92e8845dd1743030add05843341a40128133a))

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
