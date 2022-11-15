# Changelog

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
