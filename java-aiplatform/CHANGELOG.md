# Changelog

## 3.43.0 (2024-04-25)

### Features

* delete the deprecated field for model monitor
* An existing field `rag_context_recall_input` is removed from message `.google.cloud.aiplatform.v1beta1.EvaluateInstancesRequest`
* An existing field `response_recall_result` is removed from message `.google.cloud.aiplatform.v1beta1.EvaluateInstancesResponse`
* An existing field `rag_context_recall_result` is removed from message `.google.cloud.aiplatform.v1beta1.EvaluateInstancesResponse`
* An existing message `ResponseRecallInput` is removed
* An existing message `ResponseRecallInstance` is removed
* An existing message `ResponseRecallSpec` is removed
* An existing message `ResponseRecallResult` is removed
* Changed field behavior for an existing field `context` in message `.google.cloud.aiplatform.v1beta1.QuestionAnsweringQualityInstance`
* Changed field behavior for an existing field `context` in message `.google.cloud.aiplatform.v1beta1.PairwiseQuestionAnsweringQualityInstance`
* An existing message `RagContextRecallInput` is removed
* An existing message `RagContextRecallInstance` is removed
* An existing message `RagContextRecallSpec` is removed
* An existing message `RagContextRecallResult` is removed
* An existing message `NoAuth` is removed
* An existing field `response_recall_input` is removed from message `.google.cloud.aiplatform.v1beta1.EvaluateInstancesRequest`
* A new enum `HarmBlockMethod` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new enum `HarmBlockMethod` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new field `default` is added to message `.google.cloud.aiplatform.v1.Schema` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new field `default` is added to message `.google.cloud.aiplatform.v1beta1.Schema` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new field `disable_explanations` is added to message `.google.cloud.aiplatform.v1.DeployedModel` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new field `frequency_penalty` is added to message `.google.cloud.aiplatform.v1.GenerationConfig` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new field `frequency_penalty` is added to message `.google.cloud.aiplatform.v1beta1.GenerationConfig` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new field `index_config` is added to message `.google.cloud.aiplatform.v1beta1.FeatureView` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new field `max_items` is added to message `.google.cloud.aiplatform.v1.Schema` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new field `max_items` is added to message `.google.cloud.aiplatform.v1beta1.Schema` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new field `max_length` is added to message `.google.cloud.aiplatform.v1.Schema` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new field `max_length` is added to message `.google.cloud.aiplatform.v1beta1.Schema` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new field `max_properties` is added to message `.google.cloud.aiplatform.v1.Schema` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new field `max_properties` is added to message `.google.cloud.aiplatform.v1beta1.Schema` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new field `maximum` is added to message `.google.cloud.aiplatform.v1.Schema` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new field `maximum` is added to message `.google.cloud.aiplatform.v1beta1.Schema` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new field `method` is added to message `.google.cloud.aiplatform.v1.SafetySetting` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new field `method` is added to message `.google.cloud.aiplatform.v1beta1.SafetySetting` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new field `min_items` is added to message `.google.cloud.aiplatform.v1.Schema` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new field `min_items` is added to message `.google.cloud.aiplatform.v1beta1.Schema` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new field `min_length` is added to message `.google.cloud.aiplatform.v1.Schema` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new field `min_length` is added to message `.google.cloud.aiplatform.v1beta1.Schema` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new field `min_properties` is added to message `.google.cloud.aiplatform.v1.Schema` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new field `min_properties` is added to message `.google.cloud.aiplatform.v1beta1.Schema` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new field `minimum` is added to message `.google.cloud.aiplatform.v1.Schema` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new field `minimum` is added to message `.google.cloud.aiplatform.v1beta1.Schema` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new field `pattern` is added to message `.google.cloud.aiplatform.v1.Schema` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new field `pattern` is added to message `.google.cloud.aiplatform.v1beta1.Schema` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new field `persistent_resource_id` is added to message `.google.cloud.aiplatform.v1.CustomJobSpec` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new field `presence_penalty` is added to message `.google.cloud.aiplatform.v1.GenerationConfig` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new field `presence_penalty` is added to message `.google.cloud.aiplatform.v1beta1.GenerationConfig` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new field `response_mime_type` is added to message `.google.cloud.aiplatform.v1.GenerationConfig` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new field `response_mime_type` is added to message `.google.cloud.aiplatform.v1beta1.GenerationConfig` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new field `retrieval_queries` is added to message `.google.cloud.aiplatform.v1beta1.GroundingMetadata` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new field `retrieved_context` is added to message `.google.cloud.aiplatform.v1beta1.GroundingAttribution` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new field `system_instruction` is added to message `.google.cloud.aiplatform.v1.GenerateContentRequest` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new field `system_instruction` is added to message `.google.cloud.aiplatform.v1beta1.GenerateContentRequest` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new field `title` is added to message `.google.cloud.aiplatform.v1.Schema` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new field `title` is added to message `.google.cloud.aiplatform.v1beta1.Schema` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new field `vertex_rag_store` is added to message `.google.cloud.aiplatform.v1beta1.Retrieval` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new message `ChatCompletionsRequest` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new message `CreatePersistentResourceOperationMetadata` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new message `CreatePersistentResourceRequest` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new message `CreateRagCorpusOperationMetadata` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new message `CreateRagCorpusRequest` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new message `DeletePersistentResourceRequest` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new message `DeleteRagCorpusRequest` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new message `DeleteRagFileRequest` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new message `DirectUploadSource` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new message `GetPersistentResourceRequest` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new message `GetRagCorpusRequest` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new message `GetRagFileRequest` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new message `GoogleDriveSource` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new message `ImportRagFilesConfig` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new message `ImportRagFilesOperationMetadata` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new message `ImportRagFilesRequest` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new message `ImportRagFilesResponse` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new message `IndexConfig` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new message `ListPersistentResourcesRequest` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new message `ListPersistentResourcesResponse` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new message `ListRagCorporaRequest` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new message `ListRagCorporaResponse` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new message `ListRagFilesRequest` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new message `ListRagFilesResponse` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new message `PersistentResource` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new message `RagContexts` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new message `RagCorpus` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new message `RagFile` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new message `RagFileChunkingConfig` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new message `RagQuery` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new message `RaySpec` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new message `RebootPersistentResourceOperationMetadata` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new message `RebootPersistentResourceRequest` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new message `ResourcePool` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new message `ResourceRuntime` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new message `ResourceRuntimeSpec` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new message `RetrieveContextsRequest` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new message `RetrieveContextsResponse` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new message `RetrievedContext` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new message `ServiceAccountSpec` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new message `UpdatePersistentResourceOperationMetadata` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new message `UpdatePersistentResourceRequest` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new message `UploadRagFileConfig` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new message `UploadRagFileRequest` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new message `UploadRagFileResponse` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new message `VertexRagStore` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new method `ChatCompletions` is added to service `PredictionService` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new resource_definition `aiplatform.googleapis.com/PersistentResource` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new resource_definition `aiplatform.googleapis.com/RagCorpus` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new resource_definition `aiplatform.googleapis.com/RagFile` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new service `PersistentResourceService` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new service `VertexRagDataService` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new service `VertexRagService` is added ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new value `BLOCKLIST` is added to enum `BlockedReason` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new value `BLOCKLIST` is added to enum `BlockedReason` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new value `PROHIBITED_CONTENT` is added to enum `BlockedReason` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* A new value `PROHIBITED_CONTENT` is added to enum `BlockedReason` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* add model_monitor resource and APIs to public v1beta1 client library ([a1e72bb](https://github.com/googleapis/google-cloud-java/commit/a1e72bb1f08d20ff2580ccd1b280c77fa49dbdeb))
* add NotebookRuntime resource and APIs to public v1 client library ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* add NotebookRuntime resource and APIs to public v1beta1 client library ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* add Persistent Resource reboot api call to v1beta1 ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* GenAiTuningService aiplatform v1 initial release ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* An existing field `rag_context_recall_input` is removed from message `.google.cloud.aiplatform.v1beta1.EvaluateInstancesRequest` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* An existing field `rag_context_recall_result` is removed from message `.google.cloud.aiplatform.v1beta1.EvaluateInstancesResponse` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* An existing field `response_recall_input` is removed from message `.google.cloud.aiplatform.v1beta1.EvaluateInstancesRequest` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* An existing field `response_recall_result` is removed from message `.google.cloud.aiplatform.v1beta1.EvaluateInstancesResponse` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* An existing message `NoAuth` is removed ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* An existing message `RagContextRecallInput` is removed ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* An existing message `RagContextRecallInstance` is removed ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* An existing message `RagContextRecallResult` is removed ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* An existing message `RagContextRecallSpec` is removed ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* An existing message `ResponseRecallInput` is removed ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* An existing message `ResponseRecallInstance` is removed ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* An existing message `ResponseRecallResult` is removed ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* An existing message `ResponseRecallSpec` is removed ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* Changed field behavior for an existing field `context` in message `.google.cloud.aiplatform.v1beta1.PairwiseQuestionAnsweringQualityInstance` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* Changed field behavior for an existing field `context` in message `.google.cloud.aiplatform.v1beta1.QuestionAnsweringQualityInstance` ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* delete the deprecated field for model monitor ([f6dbac7](https://github.com/googleapis/google-cloud-java/commit/f6dbac748c5feea83eb917c4f6827787d27a69a9))
* A comment for field `service_account` in message `.google.cloud.aiplatform.v1beta1.ServiceAccountSpec` is changed ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* documentation updates ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))
* Documentation updates ([5423c11](https://github.com/googleapis/google-cloud-java/commit/5423c116cb584c4fdccc8538f1dfe6607f00341f))



## 3.42.0 (2024-04-04)

* No change


## 3.40.0 (2024-03-28)

### Features

* Add data_key field in feature online store service ([a6882fb](https://github.com/googleapis/google-cloud-java/commit/a6882fb9b3883424eb608eda94d7e6b7ff6f5ea6))
* Add dedicated_serving_endpoint ([a6882fb](https://github.com/googleapis/google-cloud-java/commit/a6882fb9b3883424eb608eda94d7e6b7ff6f5ea6))
* Add index_config field ([a6882fb](https://github.com/googleapis/google-cloud-java/commit/a6882fb9b3883424eb608eda94d7e6b7ff6f5ea6))
* Add Optimized feature store proto ([a6882fb](https://github.com/googleapis/google-cloud-java/commit/a6882fb9b3883424eb608eda94d7e6b7ff6f5ea6))
* add Vertex AI extension registry and execution related API and services to v1beta1 client ([15f7640](https://github.com/googleapis/google-cloud-java/commit/15f7640949d113e2b4124ec23584d8d3bca270ef))
* Evaluation Service aiplatform v1beta1 initial release ([15f7640](https://github.com/googleapis/google-cloud-java/commit/15f7640949d113e2b4124ec23584d8d3bca270ef))
* Update comment for `name` and `parameters` in message `.google.cloud.aiplatform.v1beta1.FunctionDeclaration` ([15f7640](https://github.com/googleapis/google-cloud-java/commit/15f7640949d113e2b4124ec23584d8d3bca270ef))



## 3.39.0 (2024-03-22)

### Features

* An existing field `preflight_validations` is removed from message `.google.cloud.aiplatform.v1beta1.CreatePipelineJobRequest`
* A new enum `HarmSeverity` is added ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new enum `HarmSeverity` is added ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new field `base_model_source` is added to message `.google.cloud.aiplatform.v1.Model` ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new field `base_model_source` is added to message `.google.cloud.aiplatform.v1beta1.Model` ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new field `display_name` is added to message `.google.cloud.aiplatform.v1.DatasetVersion` ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new field `display_name` is added to message `.google.cloud.aiplatform.v1beta1.DatasetVersion` ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new field `google_search_retrieval` is added to message `.google.cloud.aiplatform.v1.Tool` ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new field `grounding_metadata` is added to message `.google.cloud.aiplatform.v1.Candidate` ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new field `metadata` is added to message `.google.cloud.aiplatform.v1.DatasetVersion` ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new field `metadata` is added to message `.google.cloud.aiplatform.v1beta1.DatasetVersion` ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new field `preflight_validations` is added to message `.google.cloud.aiplatform.v1beta1.PipelineJob` ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new field `probability_score` is added to message `.google.cloud.aiplatform.v1.SafetyRating` ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new field `probability_score` is added to message `.google.cloud.aiplatform.v1beta1.SafetyRating` ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new field `progress_message` is added to message `.google.cloud.aiplatform.v1beta1.CreatePersistentResourceOperationMetadata` ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new field `progress_message` is added to message `.google.cloud.aiplatform.v1beta1.UpdatePersistentResourceOperationMetadata` ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new field `project_number` is added to message `.google.cloud.aiplatform.v1.FeatureView` ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new field `project_number` is added to message `.google.cloud.aiplatform.v1beta1.FeatureView` ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new field `retrieval` is added to message `.google.cloud.aiplatform.v1.Tool` ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new field `severity_score` is added to message `.google.cloud.aiplatform.v1.SafetyRating` ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new field `severity_score` is added to message `.google.cloud.aiplatform.v1beta1.SafetyRating` ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new field `severity` is added to message `.google.cloud.aiplatform.v1.SafetyRating` ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new field `severity` is added to message `.google.cloud.aiplatform.v1beta1.SafetyRating` ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new field `sync_summary` is added to message `.google.cloud.aiplatform.v1.FeatureViewSync` ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new field `sync_summary` is added to message `.google.cloud.aiplatform.v1beta1.FeatureViewSync` ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new message `BaseModelSource` is added ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new message `BaseModelSource` is added ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new message `BatchCancelPipelineJobsOperationMetadata` is added ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new message `BatchCancelPipelineJobsRequest` is added ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new message `BatchCancelPipelineJobsResponse` is added ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new message `BatchDeletePipelineJobsRequest` is added ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new message `BatchDeletePipelineJobsResponse` is added ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new message `GenieSource` is added ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new message `GenieSource` is added ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new message `GoogleSearchRetrieval` is added ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new message `GroundingAttribution` is added ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new message `GroundingMetadata` is added ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new message `ModelGardenSource` is added ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new message `ModelGardenSource` is added ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new message `Retrieval` is added ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new message `Segment` is added ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new message `SyncSummary` is added ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new message `SyncSummary` is added ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new message `VertexAISearch` is added ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new method `BatchCancelPipelineJobs` is added to service `PipelineService` ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new method `BatchDeletePipelineJobs` is added to service `PipelineService` ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new value `BLOCKLIST` is added to enum `FinishReason` ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new value `BLOCKLIST` is added to enum `FinishReason` ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new value `NOT_EQUAL` is added to enum `Operator` ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new value `NOT_EQUAL` is added to enum `Operator` ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new value `NVIDIA_H100_80GB` is added to enum `AcceleratorType` ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new value `PROHIBITED_CONTENT` is added to enum `FinishReason` ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new value `PROHIBITED_CONTENT` is added to enum `FinishReason` ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new value `SPII` is added to enum `FinishReason` ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* A new value `SPII` is added to enum `FinishReason` ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* add function_calling_config to ToolConfig ([1be133f](https://github.com/googleapis/google-cloud-java/commit/1be133f4dc818dece35518a8df15813dbb68052c))
* add tool_config to GenerateContentRequest ([1be133f](https://github.com/googleapis/google-cloud-java/commit/1be133f4dc818dece35518a8df15813dbb68052c))
* add v1beta1 StreamingFetchFeatureValues API ([43b143a](https://github.com/googleapis/google-cloud-java/commit/43b143a3db8c20484289b3cbb7c7cee0815078a0))
* Reasoning Engine v1beta1 GAPIC release ([d514d9a](https://github.com/googleapis/google-cloud-java/commit/d514d9a31c38829bca636af5f1d94e7143e4db5c))
* An existing field `preflight_validations` is removed from message `.google.cloud.aiplatform.v1beta1.CreatePipelineJobRequest` ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* Update the description for reasoning engine ([b5e8e3d](https://github.com/googleapis/google-cloud-java/commit/b5e8e3d989558a941897d7eedf196778bf0629ad))
* various documentation improvements ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))
* various documentation improvements ([392ff2d](https://github.com/googleapis/google-cloud-java/commit/392ff2db6665c3aa998ea94da1dfbc70c47df0f2))



## 3.38.0 (2024-03-06)

### Features

* Update docs for FeatureView Service Agents ([#10420](https://github.com/googleapis/google-cloud-java/issues/10420)) ([282ea4f](https://github.com/googleapis/google-cloud-java/commit/282ea4f36bf2977c038cad90e20c6c44aa133e72))



## 3.37.0 (2024-02-20)

### Features

* Add Grounding feature to PredictionService.GenerateContent ([#10358](https://github.com/googleapis/google-cloud-java/issues/10358)) ([0ee1383](https://github.com/googleapis/google-cloud-java/commit/0ee13836cad20260d744c4604a3c4cd68f817e74))



## 3.36.0 (2024-02-09)

### Features

* Add generateContent Unary API for aiplatform_v1 ([#10319](https://github.com/googleapis/google-cloud-java/issues/10319)) ([08700f2](https://github.com/googleapis/google-cloud-java/commit/08700f26d7db4c880e96786786936f42051f1bca))
* add SearchNearestEntities rpc to FeatureOnlineStoreService in aiplatform v1 ([#10347](https://github.com/googleapis/google-cloud-java/issues/10347)) ([e9c48d9](https://github.com/googleapis/google-cloud-java/commit/e9c48d9b25f4c39c9f22ace1c00acb24ff6a288d))



## 3.35.0 (2024-01-23)

### Features

* Fix rpc tensorboard_service.proto definitions for BatchCreateTensorboardTimeSeries and BatchReadTensorboardTimeSeriesData ([#10221](https://github.com/googleapis/google-cloud-java/issues/10221))
* Fix rpc tensorboard_service.proto definitions for BatchCreateTensorboardTimeSeries and BatchReadTensorboardTimeSeriesData ([#10221](https://github.com/googleapis/google-cloud-java/issues/10221)) ([90a9033](https://github.com/googleapis/google-cloud-java/commit/90a9033eba3cd4242cc75dddff11d60fec92b0a6))



## 3.34.0 (2024-01-10)

* No change


## 3.33.0 (2023-12-12)

### Features

* add Content ([#10116](https://github.com/googleapis/google-cloud-java/issues/10116)) ([b6c07b9](https://github.com/googleapis/google-cloud-java/commit/b6c07b96a10c1d1920138b8eae06385af14823f1))



## 3.32.0 (2023-12-04)

### Features

* add ComputeTokens and CountTokens API ([5352821](https://github.com/googleapis/google-cloud-java/commit/5352821b5cc151131728a072adeb3f146edee9fc))
* add ComputeTokens API ([#10053](https://github.com/googleapis/google-cloud-java/issues/10053)) ([5352821](https://github.com/googleapis/google-cloud-java/commit/5352821b5cc151131728a072adeb3f146edee9fc))
* add deployment_timeout to UploadModel ModelContainerSpec ([5352821](https://github.com/googleapis/google-cloud-java/commit/5352821b5cc151131728a072adeb3f146edee9fc))
* add deployment_timeout to UploadModel ModelContainerSpec ([5352821](https://github.com/googleapis/google-cloud-java/commit/5352821b5cc151131728a072adeb3f146edee9fc))
* add grpc_ports to UploadModel ModelContainerSpec ([#10065](https://github.com/googleapis/google-cloud-java/issues/10065)) ([de32d7a](https://github.com/googleapis/google-cloud-java/commit/de32d7a5c7738761b2cb30fb30b6b53836c9556c))
* add grpc_ports to UploadModel ModelContainerSpec ([#10091](https://github.com/googleapis/google-cloud-java/issues/10091)) ([eeb5108](https://github.com/googleapis/google-cloud-java/commit/eeb510862b36a32523b385deda0b7a5207d052b6))
* add protected_artifact_location_id to CustomJob ([5352821](https://github.com/googleapis/google-cloud-java/commit/5352821b5cc151131728a072adeb3f146edee9fc))
* add protected_artifact_location_id to CustomJob ([5352821](https://github.com/googleapis/google-cloud-java/commit/5352821b5cc151131728a072adeb3f146edee9fc))

### Dependencies

* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.20.0 ([#10093](https://github.com/googleapis/google-cloud-java/issues/10093)) ([91a4e4e](https://github.com/googleapis/google-cloud-java/commit/91a4e4e20252f667b8fc6bda0d9ceaf947348274))


## 3.31.0 (2023-11-06)

### Features

* add Optimized to FeatureOnlineStore ([#10040](https://github.com/googleapis/google-cloud-java/issues/10040)) ([cc0e248](https://github.com/googleapis/google-cloud-java/commit/cc0e248a9ee4658dbd3b2649d01381df218b4419))
* Adding new fields for concurrent explanations ([#10016](https://github.com/googleapis/google-cloud-java/issues/10016)) ([d80aa3c](https://github.com/googleapis/google-cloud-java/commit/d80aa3c6cb96bbe8a16827b81699a15979cceed4))
* change CreateFeature metadata ([#10029](https://github.com/googleapis/google-cloud-java/issues/10029)) ([5067fe4](https://github.com/googleapis/google-cloud-java/commit/5067fe49e688515268104f55dfc74ee74ef1a9b5))

### Dependencies

* **deps:** update dependency com.google.cloud:google-cloud-shared-config to v1.6.1 ([#10014](https://github.com/googleapis/google-cloud-java/issues/10014)) ([7b1b742](https://github.com/googleapis/google-cloud-java/commit/7b1b742dab21139398032549fb03e127b1a03841))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.19.0 ([#10018](https://github.com/googleapis/google-cloud-java/issues/10018)) ([d9b705a](https://github.com/googleapis/google-cloud-java/commit/d9b705aaed8ea4447c7a02d5c54300f8909a30b1))


## 3.30.0 (2023-10-25)

### Dependencies

* **deps:** update dependency com.google.cloud:google-cloud-shared-config to v1.6.0 ([#9969](https://github.com/googleapis/google-cloud-java/issues/9969)) ([9e2be39](https://github.com/googleapis/google-cloud-java/commit/9e2be39c5b2d7764421325f65a6d0d06351fcda5))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.18.0 ([#9984](https://github.com/googleapis/google-cloud-java/issues/9984)) ([9814dc0](https://github.com/googleapis/google-cloud-java/commit/9814dc092ad7edb7b1b21f87fa48d76a2423d731))


## 3.29.0 (2023-10-11)

### Features

* add DatasetVersion and dataset version RPCs to DatasetService ([#9922](https://github.com/googleapis/google-cloud-java/issues/9922)) ([1f45cd0](https://github.com/googleapis/google-cloud-java/commit/1f45cd036e0650aff38595a4a4f6afcb0d23b958))

### Dependencies

* **deps:** update dependency com.google.cloud:google-cloud-shared-config to v1.5.8 ([#9941](https://github.com/googleapis/google-cloud-java/issues/9941)) ([f818d26](https://github.com/googleapis/google-cloud-java/commit/f818d26968e1f19d302da1f1ea0145b2cc496ce0))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.17.0 ([#9942](https://github.com/googleapis/google-cloud-java/issues/9942)) ([2cc7888](https://github.com/googleapis/google-cloud-java/commit/2cc78885d76ae5e7dfc4cc9f3034c25fa22c6cc1))


## 3.28.0 (2023-09-28)

* No change


## 3.26.0 (2023-09-27)

### Features

* add feature.proto ([#9899](https://github.com/googleapis/google-cloud-java/issues/9899)) ([140047e](https://github.com/googleapis/google-cloud-java/commit/140047e73d507a4a17821620ed96eb9436603017))

### Dependencies

* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.16.0 ([#9866](https://github.com/googleapis/google-cloud-java/issues/9866)) ([aa36b2c](https://github.com/googleapis/google-cloud-java/commit/aa36b2c3c31b817052239fd771a21d20108b2c31))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.16.1 ([#9881](https://github.com/googleapis/google-cloud-java/issues/9881)) ([8a29511](https://github.com/googleapis/google-cloud-java/commit/8a2951166eb0305be040cc0ae38be105c437ba25))


## 3.25.0 (2023-09-11)

### Features

* add encryption_spec to index.proto and index_endpoint.proto ([#9805](https://github.com/googleapis/google-cloud-java/issues/9805)) ([1ce4fa6](https://github.com/googleapis/google-cloud-java/commit/1ce4fa6f87735c2b9d4351b0d8c542afc48e8aec))
* add NVIDIA_H100_80GB and TPU_V5_LITEPOD to AcceleratorType ([48ac78c](https://github.com/googleapis/google-cloud-java/commit/48ac78c692cd145c8aafb6497b27054d069ed6ca))
* add UpdatePersistentResourceRequest and add resource_pool_images and head_node_resource_pool_id to RaySpec ([#9769](https://github.com/googleapis/google-cloud-java/issues/9769)) ([48ac78c](https://github.com/googleapis/google-cloud-java/commit/48ac78c692cd145c8aafb6497b27054d069ed6ca))
* update field_behavior for `name` to be IMMUTABLE instead of OUTPUT_ONLY in Context, ModelMonitor, Schedule, DeploymentResourcePool ([48ac78c](https://github.com/googleapis/google-cloud-java/commit/48ac78c692cd145c8aafb6497b27054d069ed6ca))

### Dependencies

* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.15.0 ([#9809](https://github.com/googleapis/google-cloud-java/issues/9809)) ([09dbd85](https://github.com/googleapis/google-cloud-java/commit/09dbd855f683b40a462c4f918511bee4671e0174))


## 3.24.0 (2023-08-08)

### Features

* add RaySepc to ResourceRuntimeSpec, and add ResourceRuntime to PersistentResource ([#9674](https://github.com/googleapis/google-cloud-java/issues/9674)) ([f7a6838](https://github.com/googleapis/google-cloud-java/commit/f7a683858ec4ff81e92828b39a683d6117c6b936))

### Dependencies

* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.14.0 ([#9722](https://github.com/googleapis/google-cloud-java/issues/9722)) ([c7011db](https://github.com/googleapis/google-cloud-java/commit/c7011dbd69189330de1c2946b736cd712d5c1f4e))


## 3.23.0 (2023-07-21)

### Features

* add data_item_count to Dataset ([#9636](https://github.com/googleapis/google-cloud-java/issues/9636)) ([5a82003](https://github.com/googleapis/google-cloud-java/commit/5a82003b7e93ccccf8ff82753a0b3a275564fd96))

### Dependencies

* **deps:** update dependency com.google.cloud:google-cloud-shared-config to v1.5.7 ([#9651](https://github.com/googleapis/google-cloud-java/issues/9651)) ([c88d623](https://github.com/googleapis/google-cloud-java/commit/c88d623d12a4342b74e31d6a6a05cde0debe871f))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.13.1 ([#9655](https://github.com/googleapis/google-cloud-java/issues/9655)) ([affebee](https://github.com/googleapis/google-cloud-java/commit/affebeeb37b1cf88ad5964684e1f112cababcab7))


## 3.22.0 (2023-07-11)

### Dependencies

* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.13.0 ([#9622](https://github.com/googleapis/google-cloud-java/issues/9622)) ([3ac3050](https://github.com/googleapis/google-cloud-java/commit/3ac3050250a706e8f9f2d1e435a4983c3cceab82))


## 3.21.0 (2023-06-23)

### Features

* add bias_configs to ModelEvaluation ([3c65d52](https://github.com/googleapis/google-cloud-java/commit/3c65d5290a69125c115e765cd13b2e67aa6f5783))
* add UpdateExplanationDataset to aiplatform ([#9549](https://github.com/googleapis/google-cloud-java/issues/9549)) ([3c65d52](https://github.com/googleapis/google-cloud-java/commit/3c65d5290a69125c115e765cd13b2e67aa6f5783))

### Dependencies

* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.12.0 ([#9577](https://github.com/googleapis/google-cloud-java/issues/9577)) ([9e9812a](https://github.com/googleapis/google-cloud-java/commit/9e9812a0ba19e5aa82a34f2a3049bb72892544a6))


## [3.6.0](https://github.com/googleapis/google-cloud-java/compare/google-cloud-aiplatform-v3.5.1-SNAPSHOT...google-cloud-aiplatform-v3.6.0) (2022-10-24)


### Features

* [aiplatform] add deleteFeatureValues in aiplatform v1beta1 featurestore_service.proto ([#8409](https://github.com/googleapis/google-cloud-java/issues/8409)) ([a9183e5](https://github.com/googleapis/google-cloud-java/commit/a9183e5abca764897776409d431331c3fe7999e4))
* [aiplatform] add model_monitoring_stats_anomalies,model_monitoring_status to BatchPredictionJob in aiplatform v1beta1 batch_prediction_job.proto ([#8242](https://github.com/googleapis/google-cloud-java/issues/8242)) ([148fcb1](https://github.com/googleapis/google-cloud-java/commit/148fcb1e3767634ce527f0b4000699770a33f382))
* [aiplatform] add model_source_info to Model in aiplatform v1 model.proto ([#8441](https://github.com/googleapis/google-cloud-java/issues/8441)) ([86683e4](https://github.com/googleapis/google-cloud-java/commit/86683e443e001293612497cd7dee4db5d9899d66))
* [aiplatform] add model_source_info to Model in aiplatform v1beta1 model.proto ([#8452](https://github.com/googleapis/google-cloud-java/issues/8452)) ([18c0ade](https://github.com/googleapis/google-cloud-java/commit/18c0ade7d8ed66b604b577559fb74893b5b70d91))
* [aiplatform] add timestamp_outside_retention_rows_count to ImportFeatureValuesResponse and ImportFeatureValuesOperationMetadata in aiplatform v1 featurestore_service.proto ([#8429](https://github.com/googleapis/google-cloud-java/issues/8429)) ([045035f](https://github.com/googleapis/google-cloud-java/commit/045035fa705ad8932d520ed7b39ab3d4e0191b76))
* [aiplatform] add timestamp_outside_retention_rows_count to ImportFeatureValuesResponse and ImportFeatureValuesOperationMetadata in aiplatform v1beta1 featurestore_service.proto ([045035f](https://github.com/googleapis/google-cloud-java/commit/045035fa705ad8932d520ed7b39ab3d4e0191b76))
* [analyticsdata] add `subject_to_thresholding` field to `ResponseMetadata` type ([#8545](https://github.com/googleapis/google-cloud-java/issues/8545)) ([8fdc6c1](https://github.com/googleapis/google-cloud-java/commit/8fdc6c1f10f88f30f4d1407579d645f75366b4cf))
* add `tokens_per_project_per_hour` field to `PropertyQuota` type ([8fdc6c1](https://github.com/googleapis/google-cloud-java/commit/8fdc6c1f10f88f30f4d1407579d645f75366b4cf))
* add InputArtifact to RuntimeConfig in aiplatform v1beta1 pipeline_job.proto ([045035f](https://github.com/googleapis/google-cloud-java/commit/045035fa705ad8932d520ed7b39ab3d4e0191b76))
* add order_by to ListArtifactsRequest, ListContextsRequest, and ListExecutionsRequest in aiplatform v1 metadata_service.proto ([045035f](https://github.com/googleapis/google-cloud-java/commit/045035fa705ad8932d520ed7b39ab3d4e0191b76))
* add order_by to ListArtifactsRequest, ListContextsRequest, and ListExecutionsRequest in aiplatform v1beta1 metadata_service.proto ([045035f](https://github.com/googleapis/google-cloud-java/commit/045035fa705ad8932d520ed7b39ab3d4e0191b76))
* add read_mask to ListPipelineJobsRequest in aiplatform v1beta1 pipeline_service.proto ([045035f](https://github.com/googleapis/google-cloud-java/commit/045035fa705ad8932d520ed7b39ab3d4e0191b76))
* add RemoveContextChildren rpc to aiplatform v1 metadata_service.proto ([045035f](https://github.com/googleapis/google-cloud-java/commit/045035fa705ad8932d520ed7b39ab3d4e0191b76))
* add RemoveContextChildren rpc to aiplatform v1beta1 metadata_service.proto ([045035f](https://github.com/googleapis/google-cloud-java/commit/045035fa705ad8932d520ed7b39ab3d4e0191b76))
* add TransferLearningConfig in aiplatform v1beta1 study.proto ([045035f](https://github.com/googleapis/google-cloud-java/commit/045035fa705ad8932d520ed7b39ab3d4e0191b76))


### Bug Fixes

* **deps:** update dependency com.google.cloud:google-cloud-bigquery to v2.15.0 ([#8231](https://github.com/googleapis/google-cloud-java/issues/8231)) ([2c0b9ad](https://github.com/googleapis/google-cloud-java/commit/2c0b9ad05b4ff658ac7a08bde6637653825d2802))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.2 ([#8325](https://github.com/googleapis/google-cloud-java/issues/8325)) ([01f492b](https://github.com/googleapis/google-cloud-java/commit/01f492be424acdb90edb23ba66656aeff7cf39eb))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.4 ([#8528](https://github.com/googleapis/google-cloud-java/issues/8528)) ([bd36199](https://github.com/googleapis/google-cloud-java/commit/bd361998ac4eb7c78eef3b3eac39aef31a0cf44e))
* owl-bot-staging should not be commited ([#8337](https://github.com/googleapis/google-cloud-java/issues/8337)) ([c9bb4a9](https://github.com/googleapis/google-cloud-java/commit/c9bb4a97aa19032b78c86c951fe9920f24ac4eec))
* revert reverting [Many APIs] Update WORKSPACE files for rules_gapic, gax_java, generator_java versions ([#8340](https://github.com/googleapis/google-cloud-java/issues/8340)) ([dedef71](https://github.com/googleapis/google-cloud-java/commit/dedef71f600e85b1c38e7110f5ffd44bf2ba32b4))


### Dependencies

* reverting renovate bot pull requests ([#8417](https://github.com/googleapis/google-cloud-java/issues/8417)) ([8f0c60b](https://github.com/googleapis/google-cloud-java/commit/8f0c60bde446acccc665eb7894723632eefc3503))

## [3.5.0](https://github.com/googleapis/google-cloud-java/compare/google-cloud-aiplatform-v3.4.2...google-cloud-aiplatform-v3.5.0) (2022-10-17)


### Features

* [aiplatform] add deleteFeatureValues in aiplatform v1beta1 featurestore_service.proto ([#8409](https://github.com/googleapis/google-cloud-java/issues/8409)) ([a9183e5](https://github.com/googleapis/google-cloud-java/commit/a9183e5abca764897776409d431331c3fe7999e4))
* [aiplatform] add model_monitoring_stats_anomalies,model_monitoring_status to BatchPredictionJob in aiplatform v1beta1 batch_prediction_job.proto ([#8242](https://github.com/googleapis/google-cloud-java/issues/8242)) ([148fcb1](https://github.com/googleapis/google-cloud-java/commit/148fcb1e3767634ce527f0b4000699770a33f382))
* [aiplatform] add model_source_info to Model in aiplatform v1 model.proto ([#8441](https://github.com/googleapis/google-cloud-java/issues/8441)) ([86683e4](https://github.com/googleapis/google-cloud-java/commit/86683e443e001293612497cd7dee4db5d9899d66))
* [aiplatform] add model_source_info to Model in aiplatform v1beta1 model.proto ([#8452](https://github.com/googleapis/google-cloud-java/issues/8452)) ([18c0ade](https://github.com/googleapis/google-cloud-java/commit/18c0ade7d8ed66b604b577559fb74893b5b70d91))
* [aiplatform] add timestamp_outside_retention_rows_count to ImportFeatureValuesResponse and ImportFeatureValuesOperationMetadata in aiplatform v1 featurestore_service.proto ([#8429](https://github.com/googleapis/google-cloud-java/issues/8429)) ([045035f](https://github.com/googleapis/google-cloud-java/commit/045035fa705ad8932d520ed7b39ab3d4e0191b76))
* [aiplatform] add timestamp_outside_retention_rows_count to ImportFeatureValuesResponse and ImportFeatureValuesOperationMetadata in aiplatform v1beta1 featurestore_service.proto ([045035f](https://github.com/googleapis/google-cloud-java/commit/045035fa705ad8932d520ed7b39ab3d4e0191b76))
* [analyticsdata] add `subject_to_thresholding` field to `ResponseMetadata` type ([#8545](https://github.com/googleapis/google-cloud-java/issues/8545)) ([8fdc6c1](https://github.com/googleapis/google-cloud-java/commit/8fdc6c1f10f88f30f4d1407579d645f75366b4cf))
* add `tokens_per_project_per_hour` field to `PropertyQuota` type ([8fdc6c1](https://github.com/googleapis/google-cloud-java/commit/8fdc6c1f10f88f30f4d1407579d645f75366b4cf))
* add InputArtifact to RuntimeConfig in aiplatform v1beta1 pipeline_job.proto ([045035f](https://github.com/googleapis/google-cloud-java/commit/045035fa705ad8932d520ed7b39ab3d4e0191b76))
* add order_by to ListArtifactsRequest, ListContextsRequest, and ListExecutionsRequest in aiplatform v1 metadata_service.proto ([045035f](https://github.com/googleapis/google-cloud-java/commit/045035fa705ad8932d520ed7b39ab3d4e0191b76))
* add order_by to ListArtifactsRequest, ListContextsRequest, and ListExecutionsRequest in aiplatform v1beta1 metadata_service.proto ([045035f](https://github.com/googleapis/google-cloud-java/commit/045035fa705ad8932d520ed7b39ab3d4e0191b76))
* add read_mask to ListPipelineJobsRequest in aiplatform v1beta1 pipeline_service.proto ([045035f](https://github.com/googleapis/google-cloud-java/commit/045035fa705ad8932d520ed7b39ab3d4e0191b76))
* add RemoveContextChildren rpc to aiplatform v1 metadata_service.proto ([045035f](https://github.com/googleapis/google-cloud-java/commit/045035fa705ad8932d520ed7b39ab3d4e0191b76))
* add RemoveContextChildren rpc to aiplatform v1beta1 metadata_service.proto ([045035f](https://github.com/googleapis/google-cloud-java/commit/045035fa705ad8932d520ed7b39ab3d4e0191b76))
* add TransferLearningConfig in aiplatform v1beta1 study.proto ([045035f](https://github.com/googleapis/google-cloud-java/commit/045035fa705ad8932d520ed7b39ab3d4e0191b76))


### Bug Fixes

* **deps:** update dependency com.google.cloud:google-cloud-bigquery to v2.15.0 ([#8231](https://github.com/googleapis/google-cloud-java/issues/8231)) ([2c0b9ad](https://github.com/googleapis/google-cloud-java/commit/2c0b9ad05b4ff658ac7a08bde6637653825d2802))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.2 ([#8325](https://github.com/googleapis/google-cloud-java/issues/8325)) ([01f492b](https://github.com/googleapis/google-cloud-java/commit/01f492be424acdb90edb23ba66656aeff7cf39eb))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.4 ([#8528](https://github.com/googleapis/google-cloud-java/issues/8528)) ([bd36199](https://github.com/googleapis/google-cloud-java/commit/bd361998ac4eb7c78eef3b3eac39aef31a0cf44e))
* owl-bot-staging should not be commited ([#8337](https://github.com/googleapis/google-cloud-java/issues/8337)) ([c9bb4a9](https://github.com/googleapis/google-cloud-java/commit/c9bb4a97aa19032b78c86c951fe9920f24ac4eec))
* revert reverting [Many APIs] Update WORKSPACE files for rules_gapic, gax_java, generator_java versions ([#8340](https://github.com/googleapis/google-cloud-java/issues/8340)) ([dedef71](https://github.com/googleapis/google-cloud-java/commit/dedef71f600e85b1c38e7110f5ffd44bf2ba32b4))


### Dependencies

* reverting renovate bot pull requests ([#8417](https://github.com/googleapis/google-cloud-java/issues/8417)) ([8f0c60b](https://github.com/googleapis/google-cloud-java/commit/8f0c60bde446acccc665eb7894723632eefc3503))

## [3.4.2](https://github.com/googleapis/java-aiplatform/compare/v3.4.1...v3.4.2) (2022-10-10)


### Dependencies

* Update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.20.1 ([#1091](https://github.com/googleapis/java-aiplatform/issues/1091)) ([de61e5b](https://github.com/googleapis/java-aiplatform/commit/de61e5bd7ff16e326f39d4a9b51182aaf667d76e))
* Update dependency com.google.cloud:google-cloud-bigquery to v2.17.1 ([#1092](https://github.com/googleapis/java-aiplatform/issues/1092)) ([ff34c82](https://github.com/googleapis/java-aiplatform/commit/ff34c82582905a03a385d522173e897f3ea19e36))

## [3.4.1](https://github.com/googleapis/java-aiplatform/compare/v3.4.0...v3.4.1) (2022-10-10)


### Dependencies

* Update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.20.0 ([#1086](https://github.com/googleapis/java-aiplatform/issues/1086)) ([dc84f01](https://github.com/googleapis/java-aiplatform/commit/dc84f0124663049769216b1f1f5bbd984a31bb57))
* Update dependency com.google.cloud:google-cloud-bigquery to v2.17.0 ([#1082](https://github.com/googleapis/java-aiplatform/issues/1082)) ([eb38e92](https://github.com/googleapis/java-aiplatform/commit/eb38e929ffe00675f2ffedf68063b8c13edda3c7))
* Update dependency com.google.cloud:google-cloud-storage to v2.13.0 ([#1087](https://github.com/googleapis/java-aiplatform/issues/1087)) ([a786ef8](https://github.com/googleapis/java-aiplatform/commit/a786ef8bb8347251725d2a1e9e85c732b56ad542))

## [3.4.0](https://github.com/googleapis/java-aiplatform/compare/v3.3.0...v3.4.0) (2022-10-03)


### Features

* Add deleteFeatureValues in aiplatform v1beta1 featurestore_service.proto ([#1048](https://github.com/googleapis/java-aiplatform/issues/1048)) ([bf46023](https://github.com/googleapis/java-aiplatform/commit/bf4602300aa3599ff171641e102547a504a1735c))
* add InputArtifact to RuntimeConfig in aiplatform v1beta1 pipeline_job.proto ([57258ee](https://github.com/googleapis/java-aiplatform/commit/57258ee35e76c29aba2d4cf8cfce9d2edad0823c))
* Add model_source_info to Model in aiplatform v1 model.proto ([#1054](https://github.com/googleapis/java-aiplatform/issues/1054)) ([16ca835](https://github.com/googleapis/java-aiplatform/commit/16ca835ef9f494e8eb6d3c5a87335d5095db0a92))
* Add model_source_info to Model in aiplatform v1beta1 model.proto ([#1055](https://github.com/googleapis/java-aiplatform/issues/1055)) ([b8cbe32](https://github.com/googleapis/java-aiplatform/commit/b8cbe32917d55d6f27d6b5c6b5533af9e1d47a7e))
* add order_by to ListArtifactsRequest, ListContextsRequest, and ListExecutionsRequest in aiplatform v1 metadata_service.proto ([57258ee](https://github.com/googleapis/java-aiplatform/commit/57258ee35e76c29aba2d4cf8cfce9d2edad0823c))
* add order_by to ListArtifactsRequest, ListContextsRequest, and ListExecutionsRequest in aiplatform v1beta1 metadata_service.proto ([57258ee](https://github.com/googleapis/java-aiplatform/commit/57258ee35e76c29aba2d4cf8cfce9d2edad0823c))
* add read_mask to ListPipelineJobsRequest in aiplatform v1beta1 pipeline_service.proto ([57258ee](https://github.com/googleapis/java-aiplatform/commit/57258ee35e76c29aba2d4cf8cfce9d2edad0823c))
* add RemoveContextChildren rpc to aiplatform v1 metadata_service.proto ([57258ee](https://github.com/googleapis/java-aiplatform/commit/57258ee35e76c29aba2d4cf8cfce9d2edad0823c))
* add RemoveContextChildren rpc to aiplatform v1beta1 metadata_service.proto ([57258ee](https://github.com/googleapis/java-aiplatform/commit/57258ee35e76c29aba2d4cf8cfce9d2edad0823c))
* Add timestamp_outside_retention_rows_count to ImportFeatureValuesResponse and ImportFeatureValuesOperationMetadata in aiplatform v1 featurestore_service.proto ([#1053](https://github.com/googleapis/java-aiplatform/issues/1053)) ([57258ee](https://github.com/googleapis/java-aiplatform/commit/57258ee35e76c29aba2d4cf8cfce9d2edad0823c))
* add timestamp_outside_retention_rows_count to ImportFeatureValuesResponse and ImportFeatureValuesOperationMetadata in aiplatform v1beta1 featurestore_service.proto ([57258ee](https://github.com/googleapis/java-aiplatform/commit/57258ee35e76c29aba2d4cf8cfce9d2edad0823c))
* add TransferLearningConfig in aiplatform v1beta1 study.proto ([57258ee](https://github.com/googleapis/java-aiplatform/commit/57258ee35e76c29aba2d4cf8cfce9d2edad0823c))
* **sample:** Featurestore node updates ([#1028](https://github.com/googleapis/java-aiplatform/issues/1028)) ([000f6a5](https://github.com/googleapis/java-aiplatform/commit/000f6a56b71392de61ebfb713d1c515488a725fd))


### Dependencies

* Update dependency cachetools to v5 ([#1077](https://github.com/googleapis/java-aiplatform/issues/1077)) ([eb5b9f1](https://github.com/googleapis/java-aiplatform/commit/eb5b9f1b8b83a766d004bef0f60face9d580ec48))
* Update dependency certifi to v2022.9.24 ([#1059](https://github.com/googleapis/java-aiplatform/issues/1059)) ([be80906](https://github.com/googleapis/java-aiplatform/commit/be8090676d4e0bcd27b3c60e4727a596e9158930))
* Update dependency charset-normalizer to v2.1.1 ([#1064](https://github.com/googleapis/java-aiplatform/issues/1064)) ([9777478](https://github.com/googleapis/java-aiplatform/commit/977747818b779eeceb1796e706303a8f0a4a386c))
* Update dependency click to v8.1.3 ([#1067](https://github.com/googleapis/java-aiplatform/issues/1067)) ([f5e9f6a](https://github.com/googleapis/java-aiplatform/commit/f5e9f6ad0a496d7ee1c7fa221fba71b6a681192c))
* Update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.19.0 ([#1051](https://github.com/googleapis/java-aiplatform/issues/1051)) ([4dff0fe](https://github.com/googleapis/java-aiplatform/commit/4dff0fee5f601804903fa74016b887ec901d86a2))
* Update dependency com.google.cloud:google-cloud-bigquery to v2.16.1 ([#1046](https://github.com/googleapis/java-aiplatform/issues/1046)) ([cd7ac86](https://github.com/googleapis/java-aiplatform/commit/cd7ac868b3c0b0d400d7499ad0fa76e5455ff1e0))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.4 ([#1081](https://github.com/googleapis/java-aiplatform/issues/1081)) ([b1c16ae](https://github.com/googleapis/java-aiplatform/commit/b1c16ae7ec08ac7424280c8121edde14376ad515))
* Update dependency com.google.cloud:google-cloud-storage to v2.12.0 ([#1047](https://github.com/googleapis/java-aiplatform/issues/1047)) ([2a7caf9](https://github.com/googleapis/java-aiplatform/commit/2a7caf984d41e7ead0cb0939c3ab1b953c4ddfd0))
* Update dependency gcp-releasetool to v1.8.8 ([#1060](https://github.com/googleapis/java-aiplatform/issues/1060)) ([0a91ea1](https://github.com/googleapis/java-aiplatform/commit/0a91ea14ea2c6c2d362786dab8107b621eee4862))
* Update dependency google-api-core to v2.10.1 ([#1068](https://github.com/googleapis/java-aiplatform/issues/1068)) ([283880c](https://github.com/googleapis/java-aiplatform/commit/283880c0b17ab117989952b3d317282faef4608d))
* Update dependency google-auth to v2.11.1 ([#1061](https://github.com/googleapis/java-aiplatform/issues/1061)) ([1b4291d](https://github.com/googleapis/java-aiplatform/commit/1b4291db89106a8cccf03095bbde2eab84df0e3f))
* Update dependency google-cloud-core to v2.3.2 ([#1062](https://github.com/googleapis/java-aiplatform/issues/1062)) ([687d1d0](https://github.com/googleapis/java-aiplatform/commit/687d1d052227d2b1d0b57e933f94ff9ee91926e9))
* Update dependency google-cloud-storage to v2.5.0 ([#1069](https://github.com/googleapis/java-aiplatform/issues/1069)) ([6a59ca8](https://github.com/googleapis/java-aiplatform/commit/6a59ca85067c82096f391de2d52284df8f816900))
* Update dependency google-crc32c to v1.5.0 ([#1070](https://github.com/googleapis/java-aiplatform/issues/1070)) ([ce56dc7](https://github.com/googleapis/java-aiplatform/commit/ce56dc71610f9d2089f81ec502a3f3a664afae3f))
* Update dependency googleapis-common-protos to v1.56.4 ([#1063](https://github.com/googleapis/java-aiplatform/issues/1063)) ([c2f3b3e](https://github.com/googleapis/java-aiplatform/commit/c2f3b3ea31b1e312d28f9a9e66408f72619a5e06))
* Update dependency jinja2 to v3.1.2 ([#1065](https://github.com/googleapis/java-aiplatform/issues/1065)) ([74d12bc](https://github.com/googleapis/java-aiplatform/commit/74d12bcbf8cf9930803007d1d85f1d2274045048))
* Update dependency keyring to v23.9.3 ([#1066](https://github.com/googleapis/java-aiplatform/issues/1066)) ([b28f00e](https://github.com/googleapis/java-aiplatform/commit/b28f00e80a0e65df2c40ddc151614cc8ffde0a03))
* Update dependency markupsafe to v2.1.1 ([#1073](https://github.com/googleapis/java-aiplatform/issues/1073)) ([5d0e322](https://github.com/googleapis/java-aiplatform/commit/5d0e32293ef76d13a4d88971c3f9074d4c675faf))
* Update dependency protobuf to v3.20.2 ([#1074](https://github.com/googleapis/java-aiplatform/issues/1074)) ([287bba9](https://github.com/googleapis/java-aiplatform/commit/287bba902ac28569f1d939e568c03aac74eb3e37))
* Update dependency protobuf to v4 ([#1078](https://github.com/googleapis/java-aiplatform/issues/1078)) ([99e4505](https://github.com/googleapis/java-aiplatform/commit/99e4505e6c178f3b01400e00e8b504d74da012f2))
* Update dependency pyjwt to v2.5.0 ([#1071](https://github.com/googleapis/java-aiplatform/issues/1071)) ([eaceb75](https://github.com/googleapis/java-aiplatform/commit/eaceb755f111bf8e8c75c520d8982cf89f657ea0))
* Update dependency requests to v2.28.1 ([#1072](https://github.com/googleapis/java-aiplatform/issues/1072)) ([bb437cd](https://github.com/googleapis/java-aiplatform/commit/bb437cdadc04c87d8dacf56c6b4911abefb2cb96))
* Update dependency typing-extensions to v4.3.0 ([#1075](https://github.com/googleapis/java-aiplatform/issues/1075)) ([3b71889](https://github.com/googleapis/java-aiplatform/commit/3b718898232787c3fb8044eed2eccfa9bb3c8c6f))
* Update dependency zipp to v3.8.1 ([#1076](https://github.com/googleapis/java-aiplatform/issues/1076)) ([c77b0d3](https://github.com/googleapis/java-aiplatform/commit/c77b0d3fe5f892549729024df3fdcb1dcc05ebb9))

## [3.3.0](https://github.com/googleapis/java-aiplatform/compare/v3.2.0...v3.3.0) (2022-09-15)


### Features

* add input_artifacts to PipelineJob.runtime_config in aiplatform v1 pipeline_job ([def077e](https://github.com/googleapis/java-aiplatform/commit/def077e48fca7fedb788a9703dbc7e02f03c0f32))
* Add model_monitoring_stats_anomalies,model_monitoring_status to BatchPredictionJob in aiplatform v1beta1 batch_prediction_job.proto ([#1041](https://github.com/googleapis/java-aiplatform/issues/1041)) ([1b72b9d](https://github.com/googleapis/java-aiplatform/commit/1b72b9d0a4cdff5372cf8bc588c1b38a3fbb3c30))
* Add read_mask to ListPipelineJobsRequest in aiplatform v1 pipeline_service ([#1032](https://github.com/googleapis/java-aiplatform/issues/1032)) ([def077e](https://github.com/googleapis/java-aiplatform/commit/def077e48fca7fedb788a9703dbc7e02f03c0f32))
* Add UpsertDatapoints and RemoveDatapoints rpcs to IndexService in aiplatform v1 index_service.proto ([#1030](https://github.com/googleapis/java-aiplatform/issues/1030)) ([fddedd5](https://github.com/googleapis/java-aiplatform/commit/fddedd58455ec6aebe347400344e9b9e42fed922))
* add UpsertDatapoints and RemoveDatapoints rpcs to IndexService in aiplatform v1beta1 index_service.proto ([fddedd5](https://github.com/googleapis/java-aiplatform/commit/fddedd58455ec6aebe347400344e9b9e42fed922))
* Add WriteFeatureValues in aiplatform v1beta1 featurestore_online_service.proto ([#1022](https://github.com/googleapis/java-aiplatform/issues/1022)) ([cf79830](https://github.com/googleapis/java-aiplatform/commit/cf79830711e635b4d9cf21c273d15d7e44a02105))


### Dependencies

* Update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.18.0 ([#1021](https://github.com/googleapis/java-aiplatform/issues/1021)) ([ff85984](https://github.com/googleapis/java-aiplatform/commit/ff85984cb4313de3b39da74e5666b171f3ce483b))
* Update dependency com.google.cloud:google-cloud-bigquery to v2.14.5 ([#1016](https://github.com/googleapis/java-aiplatform/issues/1016)) ([d54f337](https://github.com/googleapis/java-aiplatform/commit/d54f3372e5d8d28730a324a419327f9fb331614a))
* Update dependency com.google.cloud:google-cloud-bigquery to v2.14.6 ([#1026](https://github.com/googleapis/java-aiplatform/issues/1026)) ([a8efb8e](https://github.com/googleapis/java-aiplatform/commit/a8efb8e439492d19b49f9743f00927ff986b0391))
* Update dependency com.google.cloud:google-cloud-bigquery to v2.14.7 ([#1031](https://github.com/googleapis/java-aiplatform/issues/1031)) ([bbf4f3f](https://github.com/googleapis/java-aiplatform/commit/bbf4f3f7be282fd53ba9e45cb2e23140647991f1))
* Update dependency com.google.cloud:google-cloud-bigquery to v2.15.0 ([#1040](https://github.com/googleapis/java-aiplatform/issues/1040)) ([ec530d9](https://github.com/googleapis/java-aiplatform/commit/ec530d904887ac365bd4e6d1b0c775a639706c80))
* Update dependency com.google.cloud:google-cloud-bigquery to v2.16.0 ([#1044](https://github.com/googleapis/java-aiplatform/issues/1044)) ([09594bb](https://github.com/googleapis/java-aiplatform/commit/09594bbba9e0e7722249a9d81fd99140e1529316))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.2 ([#1043](https://github.com/googleapis/java-aiplatform/issues/1043)) ([af4797b](https://github.com/googleapis/java-aiplatform/commit/af4797bb44d7016d2d5ae4170c072f11a232c07a))
* Update dependency com.google.cloud:google-cloud-shared-dependencies to v3.0.3 ([#1045](https://github.com/googleapis/java-aiplatform/issues/1045)) ([bf6138f](https://github.com/googleapis/java-aiplatform/commit/bf6138fbeef298f73f2fa70cd12ae45f91562a5e))
* Update dependency com.google.cloud:google-cloud-storage to v2.11.3 ([#1015](https://github.com/googleapis/java-aiplatform/issues/1015)) ([112a827](https://github.com/googleapis/java-aiplatform/commit/112a827210a8c184a6075b9f7ad037b31ccf2b1d))

## [3.2.0](https://github.com/googleapis/java-aiplatform/compare/v3.1.0...v3.2.0) (2022-08-09)


### Features

* add a DeploymentResourcePool API resource_definition ([#997](https://github.com/googleapis/java-aiplatform/issues/997)) ([f3e6d4f](https://github.com/googleapis/java-aiplatform/commit/f3e6d4fe833160ab34ef0d87bd58dadf62aef502))
* add DeploymentResourcePool in aiplatform v1beta1 deployment_resource_pool.proto ([#998](https://github.com/googleapis/java-aiplatform/issues/998)) ([49fb069](https://github.com/googleapis/java-aiplatform/commit/49fb069d61270657145130470d3546ea3a33490d))
* add DeploymentResourcePoolService in aiplatform v1beta1 deployment_resource_pool_service.proto ([49fb069](https://github.com/googleapis/java-aiplatform/commit/49fb069d61270657145130470d3546ea3a33490d))
* add shared_resources for supported prediction_resources ([f3e6d4f](https://github.com/googleapis/java-aiplatform/commit/f3e6d4fe833160ab34ef0d87bd58dadf62aef502))
* add SHARED_RESOURCES to DeploymentResourcesType in aiplatform v1beta1 model.proto ([49fb069](https://github.com/googleapis/java-aiplatform/commit/49fb069d61270657145130470d3546ea3a33490d))
* added SHARED_RESOURCES enum to aiplatform v1 model.proto ([3935d8f](https://github.com/googleapis/java-aiplatform/commit/3935d8f04c4585b02f1614149803ef8eed87d4e2))
* DeploymentResourcePool and DeployementResourcePoolService added to aiplatform v1beta1 model.proto (cl/463147866) ([3935d8f](https://github.com/googleapis/java-aiplatform/commit/3935d8f04c4585b02f1614149803ef8eed87d4e2))
* making network arg optional in aiplatform v1 custom_job.proto ([#999](https://github.com/googleapis/java-aiplatform/issues/999)) ([3935d8f](https://github.com/googleapis/java-aiplatform/commit/3935d8f04c4585b02f1614149803ef8eed87d4e2))
* making network arg optional in aiplatform v1beta1 custom_job.proto ([3935d8f](https://github.com/googleapis/java-aiplatform/commit/3935d8f04c4585b02f1614149803ef8eed87d4e2))
* **samples:** add all feature samples ([#980](https://github.com/googleapis/java-aiplatform/issues/980)) ([a932cf8](https://github.com/googleapis/java-aiplatform/commit/a932cf813708d23a1cc4adb4d383f66cdb7c9801))
* **samples:** add all feature values samples ([#981](https://github.com/googleapis/java-aiplatform/issues/981)) ([818acab](https://github.com/googleapis/java-aiplatform/commit/818acab3e0186ceaea2032b9f04ca9b47e8f753e))


### Bug Fixes

* declaring test-scope artifact as runtime ([#1014](https://github.com/googleapis/java-aiplatform/issues/1014)) ([f90cc12](https://github.com/googleapis/java-aiplatform/commit/f90cc12441d31fa9b17806824003f9adc2604d60))


### Documentation

* doc edits to aiplatform v1 dataset_service.proto, job_service.proto, model_service.proto, pipeline_service.proto, saved_query.proto, study.proto, types.proto ([3935d8f](https://github.com/googleapis/java-aiplatform/commit/3935d8f04c4585b02f1614149803ef8eed87d4e2))
* doc edits to aiplatform v1beta1 job_service.proto, model_service.proto, pipeline_service.proto, saved_query.proto, study.proto, types.proto ([3935d8f](https://github.com/googleapis/java-aiplatform/commit/3935d8f04c4585b02f1614149803ef8eed87d4e2))


### Dependencies

* update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.17.0 ([#1003](https://github.com/googleapis/java-aiplatform/issues/1003)) ([c2b98d9](https://github.com/googleapis/java-aiplatform/commit/c2b98d9d1c4bb896590eacb38ed5193d1e507b26))
* update dependency com.google.cloud:google-cloud-bigquery to v2.14.1 ([#1006](https://github.com/googleapis/java-aiplatform/issues/1006)) ([2c959b9](https://github.com/googleapis/java-aiplatform/commit/2c959b9d72bcfe69d6429a6f9a6d0f145a2fe022))
* update dependency com.google.cloud:google-cloud-bigquery to v2.14.3 ([#1009](https://github.com/googleapis/java-aiplatform/issues/1009)) ([b170504](https://github.com/googleapis/java-aiplatform/commit/b1705042c34be9c41125de8671339ebec7ceac86))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v3 ([#1000](https://github.com/googleapis/java-aiplatform/issues/1000)) ([6fb1534](https://github.com/googleapis/java-aiplatform/commit/6fb1534896ef3e7ec66575a92e7a8d2b2f97912b))
* update dependency com.google.cloud:google-cloud-storage to v2.10.0 ([#1004](https://github.com/googleapis/java-aiplatform/issues/1004)) ([b6e2ab4](https://github.com/googleapis/java-aiplatform/commit/b6e2ab4fb4c169b4e31ecfec01765db94916f739))
* update dependency com.google.cloud:google-cloud-storage to v2.11.0 ([#1005](https://github.com/googleapis/java-aiplatform/issues/1005)) ([26391a3](https://github.com/googleapis/java-aiplatform/commit/26391a3ebfb87163a3054207fc7cf337c2eb5fa0))
* update dependency com.google.cloud:google-cloud-storage to v2.11.1 ([#1008](https://github.com/googleapis/java-aiplatform/issues/1008)) ([cba42d1](https://github.com/googleapis/java-aiplatform/commit/cba42d176e36ee2dd704efd91b4cb57029154863))
* update dependency com.google.cloud:google-cloud-storage to v2.11.2 ([#1010](https://github.com/googleapis/java-aiplatform/issues/1010)) ([4f35eed](https://github.com/googleapis/java-aiplatform/commit/4f35eedfd485674f6e25bf92e0ad8d7c70777e1a))
* update dependency com.google.code.gson:gson to v2.9.1 ([#1001](https://github.com/googleapis/java-aiplatform/issues/1001)) ([f12c313](https://github.com/googleapis/java-aiplatform/commit/f12c313505552a93db12c6f6d4c7986b34650069))

## [3.1.0](https://github.com/googleapis/java-aiplatform/compare/v3.0.0...v3.1.0) (2022-07-13)


### Features

* **samples:** add remaining featurestore api samples ([#974](https://github.com/googleapis/java-aiplatform/issues/974)) ([872efb4](https://github.com/googleapis/java-aiplatform/commit/872efb44a685153f366533c48a79b112bfe6543e))
* **samples:** added all entity type samples ([#976](https://github.com/googleapis/java-aiplatform/issues/976)) ([b75963f](https://github.com/googleapis/java-aiplatform/commit/b75963f7cf8435212c80b516601a0d433f3fc708))


### Bug Fixes

* enable longpaths support for windows test ([#1485](https://github.com/googleapis/java-aiplatform/issues/1485)) ([#991](https://github.com/googleapis/java-aiplatform/issues/991)) ([858e68b](https://github.com/googleapis/java-aiplatform/commit/858e68b96f0a4a391a44a69944186d2b06dc4ab3))

## [3.0.0](https://github.com/googleapis/java-aiplatform/compare/v2.9.8...v3.0.0) (2022-07-01)


### ⚠ BREAKING CHANGES

* added packaging options for C#, Ruby, and PHP

### Features

* add BatchImportModelEvaluationSlices API in aiplatform v1 model_service.proto ([#972](https://github.com/googleapis/java-aiplatform/issues/972)) ([3041b97](https://github.com/googleapis/java-aiplatform/commit/3041b97659d2ffccb8ff016ba0939cd1453a82aa))
* add BatchImportModelEvaluationSlices API in aiplatform v1beta1 model_service.proto ([3041b97](https://github.com/googleapis/java-aiplatform/commit/3041b97659d2ffccb8ff016ba0939cd1453a82aa))
* add display_name and metadata to ModelEvaluation in aiplatform model_evaluation.proto ([0ae5d15](https://github.com/googleapis/java-aiplatform/commit/0ae5d15dfc9475c113ad97a2973c70a9da8dfdcd))
* add ListSavedQueries rpc to aiplatform v1 dataset_service.proto ([#975](https://github.com/googleapis/java-aiplatform/issues/975)) ([85be17b](https://github.com/googleapis/java-aiplatform/commit/85be17bbec3e368685f39a8efde69405a239ce5e))
* add ListSavedQueries rpc to aiplatform v1beta1 dataset_service.proto ([85be17b](https://github.com/googleapis/java-aiplatform/commit/85be17bbec3e368685f39a8efde69405a239ce5e))
* add model_monitoring_config to BatchPredictionJob in aiplatform v1beta1 batch_prediction_job.proto ([#892](https://github.com/googleapis/java-aiplatform/issues/892)) ([0ae5d15](https://github.com/googleapis/java-aiplatform/commit/0ae5d15dfc9475c113ad97a2973c70a9da8dfdcd))
* add model_version_id to BatchPredictionJob in aiplatform v1 batch_prediction_job.proto ([3041b97](https://github.com/googleapis/java-aiplatform/commit/3041b97659d2ffccb8ff016ba0939cd1453a82aa))
* add model_version_id to DeployedModel in aiplatform v1 endpoint.proto ([3041b97](https://github.com/googleapis/java-aiplatform/commit/3041b97659d2ffccb8ff016ba0939cd1453a82aa))
* add model_version_id to PredictResponse in aiplatform v1 prediction_service.proto ([3041b97](https://github.com/googleapis/java-aiplatform/commit/3041b97659d2ffccb8ff016ba0939cd1453a82aa))
* add saved_query_id to InputDataConfig in aiplatform v1 training_pipeline.proto ([85be17b](https://github.com/googleapis/java-aiplatform/commit/85be17bbec3e368685f39a8efde69405a239ce5e))
* add saved_query_id to InputDataConfig in aiplatform v1beta1 training_pipeline.proto ([85be17b](https://github.com/googleapis/java-aiplatform/commit/85be17bbec3e368685f39a8efde69405a239ce5e))
* add saved_query.proto to aiplatform v1 ([85be17b](https://github.com/googleapis/java-aiplatform/commit/85be17bbec3e368685f39a8efde69405a239ce5e))
* add saved_query.proto to aiplatform v1beta1 ([85be17b](https://github.com/googleapis/java-aiplatform/commit/85be17bbec3e368685f39a8efde69405a239ce5e))
* add template_metadata to PipelineJob in aiplatform v1beta1 pipeline_job.proto ([0ae5d15](https://github.com/googleapis/java-aiplatform/commit/0ae5d15dfc9475c113ad97a2973c70a9da8dfdcd))
* **samples:** add create-featurestore sample ([#948](https://github.com/googleapis/java-aiplatform/issues/948)) ([ac7ca36](https://github.com/googleapis/java-aiplatform/commit/ac7ca36f20c0a0051b262689b1ea7c80a3146721))


### Bug Fixes

* added packaging options for C#, Ruby, and PHP ([0ae5d15](https://github.com/googleapis/java-aiplatform/commit/0ae5d15dfc9475c113ad97a2973c70a9da8dfdcd))
* update gapic-generator-java with mock service generation fixes ([#979](https://github.com/googleapis/java-aiplatform/issues/979)) ([745b9cd](https://github.com/googleapis/java-aiplatform/commit/745b9cdfadf07f37ccf038761345817884a5b5ef))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.13.0 ([#973](https://github.com/googleapis/java-aiplatform/issues/973)) ([87b311d](https://github.com/googleapis/java-aiplatform/commit/87b311d47db0b2f0e89cfba5854e41c7d317c360))

## [2.9.8](https://github.com/googleapis/java-aiplatform/compare/v2.9.7...v2.9.8) (2022-06-21)


### Dependencies

* update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.15.7 ([#954](https://github.com/googleapis/java-aiplatform/issues/954)) ([906be50](https://github.com/googleapis/java-aiplatform/commit/906be50a6fe0ad4b72fecd23007bc88a6f83c83e))

## [2.9.7](https://github.com/googleapis/java-aiplatform/compare/v2.9.6...v2.9.7) (2022-06-13)


### Dependencies

* update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.15.6 ([#942](https://github.com/googleapis/java-aiplatform/issues/942)) ([4e1b0ec](https://github.com/googleapis/java-aiplatform/commit/4e1b0ecf8554d1c98f4071a588898516a3b8792c))

## [2.9.6](https://github.com/googleapis/java-aiplatform/compare/v2.9.5...v2.9.6) (2022-06-06)


### Dependencies

* update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.15.5 ([#936](https://github.com/googleapis/java-aiplatform/issues/936)) ([b3809ed](https://github.com/googleapis/java-aiplatform/commit/b3809ed85b19eb3b3dd90e30ea2013c9c399a5de))

## [2.9.5](https://github.com/googleapis/java-aiplatform/compare/v2.9.4...v2.9.5) (2022-05-27)


### Dependencies

* update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.15.4 ([#932](https://github.com/googleapis/java-aiplatform/issues/932)) ([718bbcc](https://github.com/googleapis/java-aiplatform/commit/718bbcc920f2fa3cc50cbd67fd7b98c70fd79a03))

### [2.9.4](https://github.com/googleapis/java-aiplatform/compare/v2.9.3...v2.9.4) (2022-05-27)


### Dependencies

* update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.15.3 ([#928](https://github.com/googleapis/java-aiplatform/issues/928)) ([f145548](https://github.com/googleapis/java-aiplatform/commit/f1455488a3fe87a5de5365cd6b4a1d27fab638c6))

### [2.9.3](https://github.com/googleapis/java-aiplatform/compare/v2.9.2...v2.9.3) (2022-05-27)


### Dependencies

* update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.15.2 ([#924](https://github.com/googleapis/java-aiplatform/issues/924)) ([9d7157a](https://github.com/googleapis/java-aiplatform/commit/9d7157aab5bf37f0d31517bb7a27fed9a939acf7))

### [2.9.2](https://github.com/googleapis/java-aiplatform/compare/v2.9.1...v2.9.2) (2022-05-26)


### Dependencies

* update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.15.1 ([#920](https://github.com/googleapis/java-aiplatform/issues/920)) ([6513dcc](https://github.com/googleapis/java-aiplatform/commit/6513dccabc7c6d851d7f0dd639609fb6aa31f811))

### [2.9.1](https://github.com/googleapis/java-aiplatform/compare/v2.9.0...v2.9.1) (2022-05-25)


### Dependencies

* update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.15.0 ([#915](https://github.com/googleapis/java-aiplatform/issues/915)) ([920a1fe](https://github.com/googleapis/java-aiplatform/commit/920a1fe99c205d240f18ecf21fe0e584d9da85df))
* update dependency com.google.cloud:google-cloud-storage to v2.7.0 ([#916](https://github.com/googleapis/java-aiplatform/issues/916)) ([916cfa7](https://github.com/googleapis/java-aiplatform/commit/916cfa74b4d21edc4571ab19d1fd107c56a01e57))

## [2.9.0](https://github.com/googleapis/java-aiplatform/compare/v2.8.9...v2.9.0) (2022-05-24)


### Features

* add build scripts for native image testing in Java 17 ([#1440](https://github.com/googleapis/java-aiplatform/issues/1440)) ([#894](https://github.com/googleapis/java-aiplatform/issues/894)) ([4d7349e](https://github.com/googleapis/java-aiplatform/commit/4d7349eae73cf2ed918ffd7188560bfed6ccf039))
* add ConvexAutomatedStoppingSpec to StudySpec in aiplatform v1 study.proto ([78bcdac](https://github.com/googleapis/java-aiplatform/commit/78bcdacf91ec1a80dfe237190bbf173d4279c5a6))
* add ConvexAutomatedStoppingSpec to StudySpec in aiplatform v1beta1 study.proto ([78bcdac](https://github.com/googleapis/java-aiplatform/commit/78bcdacf91ec1a80dfe237190bbf173d4279c5a6))
* add JOB_STATE_UPDATING to JobState in aiplatform v1 job_state.proto ([78bcdac](https://github.com/googleapis/java-aiplatform/commit/78bcdacf91ec1a80dfe237190bbf173d4279c5a6))
* add JOB_STATE_UPDATING to JobState in aiplatform v1beta1 job_state.proto ([78bcdac](https://github.com/googleapis/java-aiplatform/commit/78bcdacf91ec1a80dfe237190bbf173d4279c5a6))
* add LatestMonitoringPipelineMetadata to ModelDeploymentMonitoringJob in aiplatform v1beta1 model_deployment_monitoring_job.proto ([78bcdac](https://github.com/googleapis/java-aiplatform/commit/78bcdacf91ec1a80dfe237190bbf173d4279c5a6))
* add ListModelVersion, DeleteModelVersion, and MergeVersionAliases rpcs to aiplatform v1beta1 model_service.proto ([78bcdac](https://github.com/googleapis/java-aiplatform/commit/78bcdacf91ec1a80dfe237190bbf173d4279c5a6))
* add MfsMount in aiplatform v1 machine_resources.proto ([78bcdac](https://github.com/googleapis/java-aiplatform/commit/78bcdacf91ec1a80dfe237190bbf173d4279c5a6))
* add MfsMount in aiplatform v1beta1 machine_resources.proto ([78bcdac](https://github.com/googleapis/java-aiplatform/commit/78bcdacf91ec1a80dfe237190bbf173d4279c5a6))
* add model_id and parent_model to TrainingPipeline in aiplatform v1beta1 training_pipeline.proto ([78bcdac](https://github.com/googleapis/java-aiplatform/commit/78bcdacf91ec1a80dfe237190bbf173d4279c5a6))
* add model_version_id to DeployedModel in aiplatform v1beta1 endpoint.proto ([78bcdac](https://github.com/googleapis/java-aiplatform/commit/78bcdacf91ec1a80dfe237190bbf173d4279c5a6))
* add model_version_id to PredictResponse in aiplatform v1beta1 prediction_service.proto ([78bcdac](https://github.com/googleapis/java-aiplatform/commit/78bcdacf91ec1a80dfe237190bbf173d4279c5a6))
* add model_version_id to UploadModelRequest and UploadModelResponse in aiplatform v1beta1 model_service.proto ([78bcdac](https://github.com/googleapis/java-aiplatform/commit/78bcdacf91ec1a80dfe237190bbf173d4279c5a6))
* add nfs_mounts to WorkPoolSpec in aiplatform v1 custom_job.proto ([78bcdac](https://github.com/googleapis/java-aiplatform/commit/78bcdacf91ec1a80dfe237190bbf173d4279c5a6))
* add nfs_mounts to WorkPoolSpec in aiplatform v1beta1 custom_job.proto ([78bcdac](https://github.com/googleapis/java-aiplatform/commit/78bcdacf91ec1a80dfe237190bbf173d4279c5a6))
* add PredictRequestResponseLoggingConfig to aiplatform v1beta1 endpoint.proto ([78bcdac](https://github.com/googleapis/java-aiplatform/commit/78bcdacf91ec1a80dfe237190bbf173d4279c5a6))
* add reserved_ip_ranges to CustomJobSpec in aiplatform v1 custom_job.proto ([78bcdac](https://github.com/googleapis/java-aiplatform/commit/78bcdacf91ec1a80dfe237190bbf173d4279c5a6))
* add reserved_ip_ranges to CustomJobSpec in aiplatform v1beta1 custom_job.proto ([78bcdac](https://github.com/googleapis/java-aiplatform/commit/78bcdacf91ec1a80dfe237190bbf173d4279c5a6))
* add version_id to Model in aiplatform v1beta1 model.proto ([78bcdac](https://github.com/googleapis/java-aiplatform/commit/78bcdacf91ec1a80dfe237190bbf173d4279c5a6))
* remove several `REQUIRED` field annotations in featurestore.proto, metadata.proto, and pipeline_job.proto ([78bcdac](https://github.com/googleapis/java-aiplatform/commit/78bcdacf91ec1a80dfe237190bbf173d4279c5a6))
* remove several `REQUIRED` field annotations in featurestore.proto, metadata.proto, and pipeline_job.proto ([78bcdac](https://github.com/googleapis/java-aiplatform/commit/78bcdacf91ec1a80dfe237190bbf173d4279c5a6))
* rename Similarity to Examples, and similarity to examples in ExplanationParameters in aiplatform v1beta1 explanation.proto ([78bcdac](https://github.com/googleapis/java-aiplatform/commit/78bcdacf91ec1a80dfe237190bbf173d4279c5a6))


### Dependencies

* update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.14.9 ([#890](https://github.com/googleapis/java-aiplatform/issues/890)) ([bedf5d9](https://github.com/googleapis/java-aiplatform/commit/bedf5d91b42a68983504115b4e7c64eab641c769))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.11.0 ([#893](https://github.com/googleapis/java-aiplatform/issues/893)) ([fd5d001](https://github.com/googleapis/java-aiplatform/commit/fd5d001202adb240114bb27b147cdb0c519331b6))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.12.0 ([#912](https://github.com/googleapis/java-aiplatform/issues/912)) ([32c47cc](https://github.com/googleapis/java-aiplatform/commit/32c47cca36f365f33158bd16e91ea54a6682a913))

### [2.8.9](https://github.com/googleapis/java-aiplatform/compare/v2.8.8...v2.8.9) (2022-04-29)


### Dependencies

* update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.14.8 ([#883](https://github.com/googleapis/java-aiplatform/issues/883)) ([734cb3a](https://github.com/googleapis/java-aiplatform/commit/734cb3a8d541bdef6c5f4884f6383586881bbf3a))

### [2.8.8](https://github.com/googleapis/java-aiplatform/compare/v2.8.7...v2.8.8) (2022-04-22)


### Dependencies

* update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.14.7 ([#879](https://github.com/googleapis/java-aiplatform/issues/879)) ([5c16819](https://github.com/googleapis/java-aiplatform/commit/5c16819080cd337b8bc32b4fa6524f45495febcc))

### [2.8.7](https://github.com/googleapis/java-aiplatform/compare/v2.8.6...v2.8.7) (2022-04-21)


### Dependencies

* update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.14.6 ([#875](https://github.com/googleapis/java-aiplatform/issues/875)) ([83be067](https://github.com/googleapis/java-aiplatform/commit/83be06751bcd43649351b13e36151e93f51d28d8))

### [2.8.6](https://github.com/googleapis/java-aiplatform/compare/v2.8.5...v2.8.6) (2022-04-21)


### Dependencies

* update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.14.5 ([#869](https://github.com/googleapis/java-aiplatform/issues/869)) ([eee9bc2](https://github.com/googleapis/java-aiplatform/commit/eee9bc2619ac2fc417e3dfe58bfb4da20d32cd76))

### [2.8.5](https://github.com/googleapis/java-aiplatform/compare/v2.8.4...v2.8.5) (2022-04-19)


### Dependencies

* update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.14.4 ([#860](https://github.com/googleapis/java-aiplatform/issues/860)) ([528df50](https://github.com/googleapis/java-aiplatform/commit/528df50759441e13962030cbb6ee59654fb27bd4))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.10.0 ([#862](https://github.com/googleapis/java-aiplatform/issues/862)) ([9a1fa4d](https://github.com/googleapis/java-aiplatform/commit/9a1fa4d9a29d9e9e0298e4427950017273e9e2f3))
* update dependency com.google.cloud:google-cloud-storage to v2.6.1 ([#863](https://github.com/googleapis/java-aiplatform/issues/863)) ([01c8b90](https://github.com/googleapis/java-aiplatform/commit/01c8b907526798858422fa94954cfea68831a054))

### [2.8.4](https://github.com/googleapis/java-aiplatform/compare/v2.8.3...v2.8.4) (2022-04-13)


### Dependencies

* update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.14.3 ([#856](https://github.com/googleapis/java-aiplatform/issues/856)) ([5273f85](https://github.com/googleapis/java-aiplatform/commit/5273f859ab561c06ba42ebb0957021aeccba787e))

### [2.8.3](https://github.com/googleapis/java-aiplatform/compare/v2.8.2...v2.8.3) (2022-04-12)


### Dependencies

* update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.14.2 ([#852](https://github.com/googleapis/java-aiplatform/issues/852)) ([cc8b4b2](https://github.com/googleapis/java-aiplatform/commit/cc8b4b22f4dfc5d9e2bea6d7c12f7a75a31559d2))

### [2.8.2](https://github.com/googleapis/java-aiplatform/compare/v2.8.1...v2.8.2) (2022-04-11)


### Dependencies

* update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.14.1 ([#847](https://github.com/googleapis/java-aiplatform/issues/847)) ([c197ba5](https://github.com/googleapis/java-aiplatform/commit/c197ba570004ff31b51b9c9c98e097063d205885))

### [2.8.1](https://github.com/googleapis/java-aiplatform/compare/v2.8.0...v2.8.1) (2022-04-07)


### Dependencies

* update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.14.0 ([#839](https://github.com/googleapis/java-aiplatform/issues/839)) ([4e03049](https://github.com/googleapis/java-aiplatform/commit/4e03049feb20d4fcd876f39ccd5d2fc28af45430))
* update dependency com.google.cloud:google-cloud-storage to v2.6.0 ([#840](https://github.com/googleapis/java-aiplatform/issues/840)) ([a035ccf](https://github.com/googleapis/java-aiplatform/commit/a035ccf3921b0a2954b1ea66e8874da51504ec1b))

## [2.8.0](https://github.com/googleapis/java-aiplatform/compare/v2.7.4...v2.8.0) (2022-03-29)


### Features

* add `service_account` to `BatchPredictionJob` in aiplatform `v1beta1` `batch_prediction_job.proto` ([#831](https://github.com/googleapis/java-aiplatform/issues/831)) ([cd12452](https://github.com/googleapis/java-aiplatform/commit/cd1245213594655ed434f72901fa576da75a8f79))
* add ImportModelEvaluation in aiplatform v1 model_service.proto ([#832](https://github.com/googleapis/java-aiplatform/issues/832)) ([e720ecc](https://github.com/googleapis/java-aiplatform/commit/e720eccdae90bbe7d6841d3f858ddc25b45907a6))
* add monitoring_config to EntityType in aiplatform v1 entity_type.proto ([#830](https://github.com/googleapis/java-aiplatform/issues/830)) ([139a839](https://github.com/googleapis/java-aiplatform/commit/139a83950f7a846b6216539b7cad2242384166a9))
* add PredictRequestResponseLoggingConfig to Endpoint in aiplatform v1 endpoint.proto ([#824](https://github.com/googleapis/java-aiplatform/issues/824)) ([2ac62d6](https://github.com/googleapis/java-aiplatform/commit/2ac62d6574845824f09e6b2af30c2e750b334f9b))


### Dependencies

* update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.13.4 ([#829](https://github.com/googleapis/java-aiplatform/issues/829)) ([f31367a](https://github.com/googleapis/java-aiplatform/commit/f31367ab045811832e2f008a753921366f6b3529))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.9.0 ([#836](https://github.com/googleapis/java-aiplatform/issues/836)) ([320e320](https://github.com/googleapis/java-aiplatform/commit/320e320dac6cc3fd5a2a93f3077134d73060cb70))
* update dependency com.google.cloud:google-cloud-storage to v2.5.0 ([#834](https://github.com/googleapis/java-aiplatform/issues/834)) ([9dd2b5d](https://github.com/googleapis/java-aiplatform/commit/9dd2b5d796efe0a491dc11c1186414e767e52621))
* update dependency com.google.cloud:google-cloud-storage to v2.5.1 ([#835](https://github.com/googleapis/java-aiplatform/issues/835)) ([8857925](https://github.com/googleapis/java-aiplatform/commit/8857925ae6f07a15228de1a2cb3b724670ea1041))

### [2.7.4](https://github.com/googleapis/java-aiplatform/compare/v2.7.3...v2.7.4) (2022-03-10)


### Dependencies

* update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.13.3 ([#823](https://github.com/googleapis/java-aiplatform/issues/823)) ([18cc472](https://github.com/googleapis/java-aiplatform/commit/18cc472b2f082f2bfb151ccf86ff26491e24a113))

### [2.7.3](https://github.com/googleapis/java-aiplatform/compare/v2.7.2...v2.7.3) (2022-03-09)


### Dependencies

* update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.13.2 ([#817](https://github.com/googleapis/java-aiplatform/issues/817)) ([57d3ea5](https://github.com/googleapis/java-aiplatform/commit/57d3ea5df7420d397326e88ee1ed11a06ec0af81))
* update dependency com.google.cloud:google-cloud-storage to v2.4.5 ([#818](https://github.com/googleapis/java-aiplatform/issues/818)) ([d8cad94](https://github.com/googleapis/java-aiplatform/commit/d8cad946463ff3a6b604182299f713d9cf508575))

### [2.7.2](https://github.com/googleapis/java-aiplatform/compare/v2.7.1...v2.7.2) (2022-03-08)


### Dependencies

* update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.13.1 ([#812](https://github.com/googleapis/java-aiplatform/issues/812)) ([9d7097f](https://github.com/googleapis/java-aiplatform/commit/9d7097f24009dac6a9f5a1034ec89f6f4a2c0dc6))

### [2.7.1](https://github.com/googleapis/java-aiplatform/compare/v2.7.0...v2.7.1) (2022-03-08)


### Dependencies

* update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.13.0 ([#808](https://github.com/googleapis/java-aiplatform/issues/808)) ([5bd64b9](https://github.com/googleapis/java-aiplatform/commit/5bd64b9d13349fce11992d8fdd7197f51bf8dce5))

## [2.7.0](https://github.com/googleapis/java-aiplatform/compare/v2.6.0...v2.7.0) (2022-03-03)


### Features

* add TPU_V2 & TPU_V3 values to AcceleratorType in aiplatform v1/v1beta1 accelerator_type.proto ([#796](https://github.com/googleapis/java-aiplatform/issues/796)) ([019a774](https://github.com/googleapis/java-aiplatform/commit/019a7748d194aa6ccadd18492bb38c1ed35a6362))


### Dependencies

* update actions/github-script action to v6 ([#791](https://github.com/googleapis/java-aiplatform/issues/791)) ([fec15cf](https://github.com/googleapis/java-aiplatform/commit/fec15cfe528a5ae2efd2523201558a18f24be4e5))
* update actions/setup-java action to v3 ([#798](https://github.com/googleapis/java-aiplatform/issues/798)) ([d27b5da](https://github.com/googleapis/java-aiplatform/commit/d27b5da83263e4f708c10ba5dd208b0ed5c17494))
* update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.12.0 ([#782](https://github.com/googleapis/java-aiplatform/issues/782)) ([a32771e](https://github.com/googleapis/java-aiplatform/commit/a32771ef61ae4bf654e90243e342e96a82297b50))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.8.0 ([#804](https://github.com/googleapis/java-aiplatform/issues/804)) ([92a51e5](https://github.com/googleapis/java-aiplatform/commit/92a51e59a1b678dc4f14e607fbf0e40dd4b423a8))
* update dependency com.google.cloud:google-cloud-storage to v2.4.0 ([#783](https://github.com/googleapis/java-aiplatform/issues/783)) ([c91ab37](https://github.com/googleapis/java-aiplatform/commit/c91ab3765d49637635f174a87e41ff2bfb41bc73))
* update dependency com.google.cloud:google-cloud-storage to v2.4.4 ([#801](https://github.com/googleapis/java-aiplatform/issues/801)) ([1f98d03](https://github.com/googleapis/java-aiplatform/commit/1f98d03485c9b007faa6a5e106631c11239f8b82))
* update dependency com.google.code.gson:gson to v2.9.0 ([#792](https://github.com/googleapis/java-aiplatform/issues/792)) ([46b6e19](https://github.com/googleapis/java-aiplatform/commit/46b6e1931125aaaca7c7449b41467db5eef9d9d9))

## [2.6.0](https://github.com/googleapis/java-aiplatform/compare/v2.5.3...v2.6.0) (2022-02-03)


### Features

* add dedicated_resources to DeployedIndex in aiplatform v1beta1 index_endpoint.proto feat: add Scaling to OnlineServingConfig in aiplatform v1beta1 featurestore.proto chore: sort imports ([#779](https://github.com/googleapis/java-aiplatform/issues/779)) ([0c49a03](https://github.com/googleapis/java-aiplatform/commit/0c49a035e2ff1d3312ac61acfba893e9a8c0123c))
* add dedicated_resources to DeployedIndex message in aiplatform v1 index_endpoint.proto chore: sort imports ([#778](https://github.com/googleapis/java-aiplatform/issues/778)) ([d70e48c](https://github.com/googleapis/java-aiplatform/commit/d70e48c59422d85d34d05be06d8a9dc5b09b7522))


### Dependencies

* **java:** update actions/github-script action to v5 ([#1339](https://github.com/googleapis/java-aiplatform/issues/1339)) ([#775](https://github.com/googleapis/java-aiplatform/issues/775)) ([76578f1](https://github.com/googleapis/java-aiplatform/commit/76578f1d161e2360fba581aa775c63ab40365a2f))
* update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.11.3 ([#762](https://github.com/googleapis/java-aiplatform/issues/762)) ([d233eae](https://github.com/googleapis/java-aiplatform/commit/d233eae839c4edfc9572bb2c792029e273ec34ef))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.7.0 ([#777](https://github.com/googleapis/java-aiplatform/issues/777)) ([bfc1a15](https://github.com/googleapis/java-aiplatform/commit/bfc1a15e937a681795fdd1a49ba18296c66de978))
* update dependency com.google.cloud:google-cloud-storage to v2.2.3 ([#764](https://github.com/googleapis/java-aiplatform/issues/764)) ([2b99b4a](https://github.com/googleapis/java-aiplatform/commit/2b99b4ac94cae72278c594189bd1f9d4704c1b04))
* update dependency com.google.cloud:google-cloud-storage to v2.3.0 ([#773](https://github.com/googleapis/java-aiplatform/issues/773)) ([d824684](https://github.com/googleapis/java-aiplatform/commit/d8246842dde67035800aa033e4ba7103499bea74))

### [2.5.3](https://www.github.com/googleapis/java-aiplatform/compare/v2.5.2...v2.5.3) (2022-01-07)


### Bug Fixes

* **java:** add -ntp flag to native image testing command ([#1299](https://www.github.com/googleapis/java-aiplatform/issues/1299)) ([#745](https://www.github.com/googleapis/java-aiplatform/issues/745)) ([30b2026](https://www.github.com/googleapis/java-aiplatform/commit/30b2026e612de04720c2895f511a61fb452ecd45))
* **java:** run Maven in plain console-friendly mode ([#1301](https://www.github.com/googleapis/java-aiplatform/issues/1301)) ([#756](https://www.github.com/googleapis/java-aiplatform/issues/756)) ([720665d](https://www.github.com/googleapis/java-aiplatform/commit/720665d04bafd6f98c1bb2507b340a3180791a02))


### Dependencies

* update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.11.2 ([#744](https://www.github.com/googleapis/java-aiplatform/issues/744)) ([da767b8](https://www.github.com/googleapis/java-aiplatform/commit/da767b803d5079d3b145f3b0cd88840df34dba4f))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.6.0 ([#759](https://www.github.com/googleapis/java-aiplatform/issues/759)) ([7bce375](https://www.github.com/googleapis/java-aiplatform/commit/7bce3755ba8251b06aedaef85e673deee79b1abd))
* update dependency com.google.cloud:google-cloud-storage to v2.2.2 ([#747](https://www.github.com/googleapis/java-aiplatform/issues/747)) ([b89815f](https://www.github.com/googleapis/java-aiplatform/commit/b89815fe52e94935ce8c10ffd1cc14d490cd4a81))

### [2.5.2](https://www.github.com/googleapis/java-aiplatform/compare/v2.5.1...v2.5.2) (2021-12-03)


### Dependencies

* update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.11.0 ([#740](https://www.github.com/googleapis/java-aiplatform/issues/740)) ([55647b1](https://www.github.com/googleapis/java-aiplatform/commit/55647b19870ce186a5c4d71fda5493d1ae9b2e94))

### [2.5.1](https://www.github.com/googleapis/java-aiplatform/compare/v2.5.0...v2.5.1) (2021-12-03)


### Dependencies

* update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.10.0 ([#733](https://www.github.com/googleapis/java-aiplatform/issues/733)) ([8c1fde1](https://www.github.com/googleapis/java-aiplatform/commit/8c1fde15e082341656ef2ba016c6e8a7aaebb45f))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.5.1 ([#737](https://www.github.com/googleapis/java-aiplatform/issues/737)) ([98c11a2](https://www.github.com/googleapis/java-aiplatform/commit/98c11a250108ca9422eeaa143aac1bc14653ed41))

## [2.5.0](https://www.github.com/googleapis/java-aiplatform/compare/v2.4.0...v2.5.0) (2021-12-02)


### Features

* add enable_private_service_connect field to Endpoint feat: add id field to DeployedModel feat: add service_attachment field to PrivateEndpoints feat: add endpoint_id to CreateEndpointRequest and method signature to CreateEndpoint feat: add method... ([#728](https://www.github.com/googleapis/java-aiplatform/issues/728)) ([bf5dc50](https://www.github.com/googleapis/java-aiplatform/commit/bf5dc50407f1a38bd89e888cb7c5944736d4cb05))
* add enable_private_service_connect field to Endpoint feat: add id field to DeployedModel feat: add service_attachment field to PrivateEndpoints feat: add endpoint_id to CreateEndpointRequest and method signature to CreateEndpoint feat: add method... ([#729](https://www.github.com/googleapis/java-aiplatform/issues/729)) ([2b79994](https://www.github.com/googleapis/java-aiplatform/commit/2b79994249bb572aa72336acdbc38f6f16aa86b4))

## [2.4.0](https://www.github.com/googleapis/java-aiplatform/compare/v2.3.0...v2.4.0) (2021-12-02)


### Features

* Adds support for `google.protobuf.Value` pipeline parameters in the `parameter_values` field ([#708](https://www.github.com/googleapis/java-aiplatform/issues/708)) ([a2237b6](https://www.github.com/googleapis/java-aiplatform/commit/a2237b631bc953f1cdf9c4ed75da862a477eecc9))
* Adds support for `google.protobuf.Value` pipeline parameters in the `parameter_values` field ([#709](https://www.github.com/googleapis/java-aiplatform/issues/709)) ([a21302c](https://www.github.com/googleapis/java-aiplatform/commit/a21302c3a8fb0ed2a3a827ae21546426e180ca66))
* tensorboard v1 protos release ([#723](https://www.github.com/googleapis/java-aiplatform/issues/723)) ([d35a846](https://www.github.com/googleapis/java-aiplatform/commit/d35a84686fd5b7769d410b9371e235d42d81c01b))


### Bug Fixes

* **java:** java 17 dependency arguments ([#1266](https://www.github.com/googleapis/java-aiplatform/issues/1266)) ([#705](https://www.github.com/googleapis/java-aiplatform/issues/705)) ([74283f7](https://www.github.com/googleapis/java-aiplatform/commit/74283f7ff14eedb4217091d7425fbd6b4ad62b02))


### Dependencies

* update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.9.0 ([#703](https://www.github.com/googleapis/java-aiplatform/issues/703)) ([783da35](https://www.github.com/googleapis/java-aiplatform/commit/783da35f2bfca77b071ed94d06df2983620495f4))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.5.0 ([#721](https://www.github.com/googleapis/java-aiplatform/issues/721)) ([b0d79cd](https://www.github.com/googleapis/java-aiplatform/commit/b0d79cdc391dbbb72850d3acd1cbcef2ab3a9d67))
* update dependency com.google.cloud:google-cloud-storage to v2.2.0 ([#710](https://www.github.com/googleapis/java-aiplatform/issues/710)) ([e3adb9d](https://www.github.com/googleapis/java-aiplatform/commit/e3adb9dd5c961136d4c503489cccdadd0b5b87e9))
* update dependency com.google.cloud:google-cloud-storage to v2.2.1 ([#722](https://www.github.com/googleapis/java-aiplatform/issues/722)) ([db19ef3](https://www.github.com/googleapis/java-aiplatform/commit/db19ef30c163327edaa146d44baa15fdaa0d081e))
* update dependency com.google.code.gson:gson to v2.8.9 ([#707](https://www.github.com/googleapis/java-aiplatform/issues/707)) ([16db0be](https://www.github.com/googleapis/java-aiplatform/commit/16db0be51865407f521e460c812743adbf78e41b))


### Documentation

* Added evalId comment to samples ([#727](https://www.github.com/googleapis/java-aiplatform/issues/727)) ([8826252](https://www.github.com/googleapis/java-aiplatform/commit/8826252d3f116a70bac4f342e318c78f0c3f73c1))

## [2.3.0](https://www.github.com/googleapis/java-aiplatform/compare/v2.2.4...v2.3.0) (2021-10-21)


### Features

* add featurestore service to aiplatform v1 feat: add metadata service to aiplatform v1 ([#692](https://www.github.com/googleapis/java-aiplatform/issues/692)) ([1ecc5d1](https://www.github.com/googleapis/java-aiplatform/commit/1ecc5d1288fdb9ca909d54ca5ad16586af9648d4))
* add Similarity to explanation in aiplatform v1beta1 feat: add EncryptionSpec to featurestore in aiplatform v1beta1 feat: add PipelineTaskStatus to pipeline_job in aiplatform v1beta1 feat: add BatchReadTensorboardTimeSeriesData to tensorboard_serv... ([#691](https://www.github.com/googleapis/java-aiplatform/issues/691)) ([a215d7b](https://www.github.com/googleapis/java-aiplatform/commit/a215d7b0aa1d0e2909d7a1218ded4094f4a31a44))
* add vizier service to aiplatform v1 BUILD.bazel ([#688](https://www.github.com/googleapis/java-aiplatform/issues/688)) ([4fcfca6](https://www.github.com/googleapis/java-aiplatform/commit/4fcfca6dc1e9ddab8f991804a02c6370ddb16b35))


### Bug Fixes

* Remove invalid resource annotations ([#699](https://www.github.com/googleapis/java-aiplatform/issues/699)) ([5ece66d](https://www.github.com/googleapis/java-aiplatform/commit/5ece66dd33c5195169e8e5a559ee04864a45827d))


### Dependencies

* update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.8.4 ([#682](https://www.github.com/googleapis/java-aiplatform/issues/682)) ([2309a27](https://www.github.com/googleapis/java-aiplatform/commit/2309a27f48051707d34f9121980e633e465681b9))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.4.0 ([#697](https://www.github.com/googleapis/java-aiplatform/issues/697)) ([29abdbd](https://www.github.com/googleapis/java-aiplatform/commit/29abdbdfbeec4d6928922e27a1ec2b25c62530d5))
* update dependency com.google.cloud:google-cloud-storage to v2.1.6 ([#683](https://www.github.com/googleapis/java-aiplatform/issues/683)) ([e1419a3](https://www.github.com/googleapis/java-aiplatform/commit/e1419a3f3fd092c9108622c34ee68bdc62bed3f5))
* update dependency com.google.cloud:google-cloud-storage to v2.1.7 ([#689](https://www.github.com/googleapis/java-aiplatform/issues/689)) ([56ab398](https://www.github.com/googleapis/java-aiplatform/commit/56ab398d3dc440150b0e771b606c783db50e4513))
* update dependency com.google.cloud:google-cloud-storage to v2.1.8 ([#696](https://www.github.com/googleapis/java-aiplatform/issues/696)) ([ae93da9](https://www.github.com/googleapis/java-aiplatform/commit/ae93da916ff20d6191729d7afb05b123009163d6))
* update dependency com.google.cloud:google-cloud-storage to v2.1.9 ([#698](https://www.github.com/googleapis/java-aiplatform/issues/698)) ([e762a46](https://www.github.com/googleapis/java-aiplatform/commit/e762a46d8a2b8fc5687da25aced63798427bcf45))

### [2.2.4](https://www.github.com/googleapis/java-aiplatform/compare/v2.2.3...v2.2.4) (2021-09-24)


### Dependencies

* update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.8.3 ([#678](https://www.github.com/googleapis/java-aiplatform/issues/678)) ([3066ff2](https://www.github.com/googleapis/java-aiplatform/commit/3066ff26568e8e2f21b1e1a14a23c4d551116f2f))

### [2.2.3](https://www.github.com/googleapis/java-aiplatform/compare/v2.2.2...v2.2.3) (2021-09-24)


### Dependencies

* update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.8.2 ([#666](https://www.github.com/googleapis/java-aiplatform/issues/666)) ([a14e253](https://www.github.com/googleapis/java-aiplatform/commit/a14e253fd79762a6a0f424bf61eb6a060fdcc7bf))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.3.0 ([#672](https://www.github.com/googleapis/java-aiplatform/issues/672)) ([55d3f3b](https://www.github.com/googleapis/java-aiplatform/commit/55d3f3b94e6a555d605a06093c53281c771aad6a))
* update dependency com.google.cloud:google-cloud-storage to v2.1.3 ([#667](https://www.github.com/googleapis/java-aiplatform/issues/667)) ([3c84064](https://www.github.com/googleapis/java-aiplatform/commit/3c84064419f7881fce7a70696cc21c4bf2796347))
* update dependency com.google.cloud:google-cloud-storage to v2.1.4 ([#669](https://www.github.com/googleapis/java-aiplatform/issues/669)) ([f0e7793](https://www.github.com/googleapis/java-aiplatform/commit/f0e7793a7137086a6af1eb397f52a56ce67f2fcc))
* update dependency com.google.cloud:google-cloud-storage to v2.1.5 ([#673](https://www.github.com/googleapis/java-aiplatform/issues/673)) ([f472ef9](https://www.github.com/googleapis/java-aiplatform/commit/f472ef92db50b8dc01a69e85fd5a72258d808d1b))

### [2.2.2](https://www.github.com/googleapis/java-aiplatform/compare/v2.2.1...v2.2.2) (2021-09-14)


### Dependencies

* update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.8.1 ([#661](https://www.github.com/googleapis/java-aiplatform/issues/661)) ([ab4d5a0](https://www.github.com/googleapis/java-aiplatform/commit/ab4d5a03c1b793c13afc9c68c0667560d898057a))
* update dependency com.google.cloud:google-cloud-storage to v2.1.2 ([#662](https://www.github.com/googleapis/java-aiplatform/issues/662)) ([4f2fed2](https://www.github.com/googleapis/java-aiplatform/commit/4f2fed26d9cf3056568be9ea1d7bc8fcce38c2dd))

### [2.2.1](https://www.github.com/googleapis/java-aiplatform/compare/v2.2.0...v2.2.1) (2021-09-14)


### Dependencies

* update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.8.0 ([#641](https://www.github.com/googleapis/java-aiplatform/issues/641)) ([3c1d817](https://www.github.com/googleapis/java-aiplatform/commit/3c1d817b4a6c3c51caf31f14c122b8ab06b82fab))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.2.1 ([#656](https://www.github.com/googleapis/java-aiplatform/issues/656)) ([242614c](https://www.github.com/googleapis/java-aiplatform/commit/242614c09c71bf5761309e9a90261ade97d28d49))

## [2.2.0](https://www.github.com/googleapis/java-aiplatform/compare/v2.1.0...v2.2.0) (2021-09-07)


### Features

* add Vizier service to aiplatform v1 ([#642](https://www.github.com/googleapis/java-aiplatform/issues/642)) ([6173518](https://www.github.com/googleapis/java-aiplatform/commit/6173518e9b74c9742ef1b8fc6d91d59b5b9b063e))


### Dependencies

* update dependency com.google.cloud:google-cloud-storage to v2.1.1 ([#644](https://www.github.com/googleapis/java-aiplatform/issues/644)) ([d4cd890](https://www.github.com/googleapis/java-aiplatform/commit/d4cd890ea128676b8a30230a2013a9fc6e65ab9f))

## [2.1.0](https://www.github.com/googleapis/java-aiplatform/compare/v2.0.2...v2.1.0) (2021-08-31)


### Features

* add prediction service RPC RawPredict to aiplatform_v1beta1 feat: add tensorboard service RPCs to aiplatform_v1beta1: BatchCreateTensorboardRuns, BatchCreateTensorboardTimeSeries, WriteTensorboardExperimentData feat: add model_deployment_monitori... ([#636](https://www.github.com/googleapis/java-aiplatform/issues/636)) ([eee1532](https://www.github.com/googleapis/java-aiplatform/commit/eee15324226022cc097167d1f3d5e718262a0d65))
* add XAI, model monitoring, and index services to aiplatform v1 ([#635](https://www.github.com/googleapis/java-aiplatform/issues/635)) ([8d4a0bc](https://www.github.com/googleapis/java-aiplatform/commit/8d4a0bc3304095c8495ea92b97289e3fa6443e6e))
* Remove use of deprecated gradle command in java README ([#1196](https://www.github.com/googleapis/java-aiplatform/issues/1196)) ([#633](https://www.github.com/googleapis/java-aiplatform/issues/633)) ([a2410d1](https://www.github.com/googleapis/java-aiplatform/commit/a2410d119996d0b855ea2311fd52dc1ac708c9b4))


### Dependencies

* update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.6.2 ([#629](https://www.github.com/googleapis/java-aiplatform/issues/629)) ([30554f2](https://www.github.com/googleapis/java-aiplatform/commit/30554f25a95eb13a8bcc80d0cebfa4886b2c93d8))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.2.0 ([#638](https://www.github.com/googleapis/java-aiplatform/issues/638)) ([0e3745f](https://www.github.com/googleapis/java-aiplatform/commit/0e3745f970bf8117c41cd95be52770027d725e7b))
* update dependency com.google.cloud:google-cloud-storage to v2.1.0 ([#630](https://www.github.com/googleapis/java-aiplatform/issues/630)) ([b52f11e](https://www.github.com/googleapis/java-aiplatform/commit/b52f11e47b1a432d736e01bc7d368807ded9ad9c))

### [2.0.2](https://www.github.com/googleapis/java-aiplatform/compare/v2.0.1...v2.0.2) (2021-08-24)


### Dependencies

* update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.6.1 ([#617](https://www.github.com/googleapis/java-aiplatform/issues/617)) ([5180b67](https://www.github.com/googleapis/java-aiplatform/commit/5180b67c919c6d5158dc4118afb3117a50e2674d))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.1.0 ([#624](https://www.github.com/googleapis/java-aiplatform/issues/624)) ([8b033fc](https://www.github.com/googleapis/java-aiplatform/commit/8b033fca7f4f5e696b2681f9ddcf3c18ffc56d3b))
* update dependency com.google.cloud:google-cloud-storage to v2.0.2 ([#621](https://www.github.com/googleapis/java-aiplatform/issues/621)) ([f987977](https://www.github.com/googleapis/java-aiplatform/commit/f987977b07596102ad6ceee00bed47d6753b7a86))
* update dependency com.google.code.gson:gson to v2.8.8 ([#622](https://www.github.com/googleapis/java-aiplatform/issues/622)) ([a906429](https://www.github.com/googleapis/java-aiplatform/commit/a9064293a9c700465a07e6ec737e7b072eda1f60))

### [2.0.1](https://www.github.com/googleapis/java-aiplatform/compare/v2.0.0...v2.0.1) (2021-08-12)


### Dependencies

* update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.6.0 ([#608](https://www.github.com/googleapis/java-aiplatform/issues/608)) ([63d3620](https://www.github.com/googleapis/java-aiplatform/commit/63d3620473aa493a8445170d55f497c2a4ef79ac))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2.0.1 ([#611](https://www.github.com/googleapis/java-aiplatform/issues/611)) ([22c3a1c](https://www.github.com/googleapis/java-aiplatform/commit/22c3a1c674c47278b5d59d16bdf0e70823604360))
* update dependency com.google.cloud:google-cloud-storage to v1.118.1 ([#607](https://www.github.com/googleapis/java-aiplatform/issues/607)) ([adc2bc6](https://www.github.com/googleapis/java-aiplatform/commit/adc2bc6cb19edb5cd30e5a7dca490b1e26f6cb85))
* update dependency com.google.cloud:google-cloud-storage to v2 ([#610](https://www.github.com/googleapis/java-aiplatform/issues/610)) ([0c727f1](https://www.github.com/googleapis/java-aiplatform/commit/0c727f13b02482435fa4ab01ac51426dd51505bf))
* update dependency com.google.cloud:google-cloud-storage to v2.0.1 ([#612](https://www.github.com/googleapis/java-aiplatform/issues/612)) ([096525f](https://www.github.com/googleapis/java-aiplatform/commit/096525f737e343ba6dc7c547299992cd5ba78f0d))

## [2.0.0](https://www.github.com/googleapis/java-aiplatform/compare/v1.0.2...v2.0.0) (2021-08-06)


### ⚠ BREAKING CHANGES

* Removes breaking change from v1 version of AI Platform protos
* release gapic-generator-java v2.0.0 (#603)

### Features

* Adds BigQuery output table field to batch prediction job output config [#449](https://www.github.com/googleapis/java-aiplatform/issues/449) ([a00087e](https://www.github.com/googleapis/java-aiplatform/commit/a00087eeb93ba3d1f158bfa00f02aad9b413a132))
* Adds CustomJob.web_access_uris, CustomJob.enable_web_access fields ([a00087e](https://www.github.com/googleapis/java-aiplatform/commit/a00087eeb93ba3d1f158bfa00f02aad9b413a132))
* Adds Endpoint.network, Endpoint.private_endpoints fields and PrivateEndpoints message ([a00087e](https://www.github.com/googleapis/java-aiplatform/commit/a00087eeb93ba3d1f158bfa00f02aad9b413a132))
* Adds Execution.State constants: CACHED and CANCELLED ([a00087e](https://www.github.com/googleapis/java-aiplatform/commit/a00087eeb93ba3d1f158bfa00f02aad9b413a132))
* Adds Feature Store features ([a00087e](https://www.github.com/googleapis/java-aiplatform/commit/a00087eeb93ba3d1f158bfa00f02aad9b413a132))
* Adds fields to Study message ([a00087e](https://www.github.com/googleapis/java-aiplatform/commit/a00087eeb93ba3d1f158bfa00f02aad9b413a132))
* Adds IndexEndpoint.private_ip_ranges field ([a00087e](https://www.github.com/googleapis/java-aiplatform/commit/a00087eeb93ba3d1f158bfa00f02aad9b413a132))
* Adds IndexEndpointService.deployed_index_id field ([a00087e](https://www.github.com/googleapis/java-aiplatform/commit/a00087eeb93ba3d1f158bfa00f02aad9b413a132))
* Adds MetadataService.DeleteArtifact and DeleteExecution methods ([a00087e](https://www.github.com/googleapis/java-aiplatform/commit/a00087eeb93ba3d1f158bfa00f02aad9b413a132))
* Adds ModelMonitoringObjectConfig.explanation_config field and ModelMonitoringObjectConfig.ExplanationConfig message ([a00087e](https://www.github.com/googleapis/java-aiplatform/commit/a00087eeb93ba3d1f158bfa00f02aad9b413a132))
* Adds ModelMonitoringObjectiveConfig.TrainingPredictionSkewDetectionConfig.attribution_score_skew_thresholds and ModelMonitoringObjectiveConfig.PredictionDriftDetectionConfig.attribution_score_drift_threshold fields ([a00087e](https://www.github.com/googleapis/java-aiplatform/commit/a00087eeb93ba3d1f158bfa00f02aad9b413a132))
* release gapic-generator-java v2.0.0 ([#603](https://www.github.com/googleapis/java-aiplatform/issues/603)) ([a00087e](https://www.github.com/googleapis/java-aiplatform/commit/a00087eeb93ba3d1f158bfa00f02aad9b413a132))
* Removes breaking change from v1 version of AI Platform protos ([a00087e](https://www.github.com/googleapis/java-aiplatform/commit/a00087eeb93ba3d1f158bfa00f02aad9b413a132))


### Bug Fixes

* add check exceptions for removing accelerator types ([#446](https://www.github.com/googleapis/java-aiplatform/issues/446)) ([789e343](https://www.github.com/googleapis/java-aiplatform/commit/789e34331d00ff4416eac2ac612e1cdd70a4cbd1))


### Dependencies

* update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.5.2 ([#434](https://www.github.com/googleapis/java-aiplatform/issues/434)) ([14100d8](https://www.github.com/googleapis/java-aiplatform/commit/14100d8c4d2f585213137fc3219df6fb9424c071))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v2 ([#602](https://www.github.com/googleapis/java-aiplatform/issues/602)) ([ad91862](https://www.github.com/googleapis/java-aiplatform/commit/ad918628a999521a1da0b5cb9e8478ed8d7e18cd))
* update dependency com.google.cloud:google-cloud-storage to v1.118.0 ([#440](https://www.github.com/googleapis/java-aiplatform/issues/440)) ([bd94ebc](https://www.github.com/googleapis/java-aiplatform/commit/bd94ebc1586e742c1d7fc8037e5b127f224325dc))

### [1.0.2](https://www.github.com/googleapis/java-aiplatform/compare/v1.0.1...v1.0.2) (2021-07-07)


### Dependencies

* update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.5.1 ([#428](https://www.github.com/googleapis/java-aiplatform/issues/428)) ([4d9b774](https://www.github.com/googleapis/java-aiplatform/commit/4d9b774e9f57c2b9e30512dcc0ec9197aa9c173f))

### [1.0.1](https://www.github.com/googleapis/java-aiplatform/compare/v1.0.0...v1.0.1) (2021-07-05)


### Bug Fixes

* Add `shopt -s nullglob` to dependencies script ([#1130](https://www.github.com/googleapis/java-aiplatform/issues/1130)) ([#417](https://www.github.com/googleapis/java-aiplatform/issues/417)) ([dc73fad](https://www.github.com/googleapis/java-aiplatform/commit/dc73fad8c067081ef7b078229c2b1e933a02cbb6))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.4.0 ([#423](https://www.github.com/googleapis/java-aiplatform/issues/423)) ([0ff042a](https://www.github.com/googleapis/java-aiplatform/commit/0ff042a41d257ad1034fd343dcbb164de28cc996))
* update dependency com.google.cloud:google-cloud-storage to v1.117.1 ([#422](https://www.github.com/googleapis/java-aiplatform/issues/422)) ([f9e4e42](https://www.github.com/googleapis/java-aiplatform/commit/f9e4e42823f646c5e81641436ed5423a177a1049))

## [1.0.0](https://www.github.com/googleapis/java-aiplatform/compare/v0.4.1...v1.0.0) (2021-06-09)


### ⚠ BREAKING CHANGES

* remove display_name from FeatureStore

### Features

* add `gcf-owl-bot[bot]` to `ignoreAuthors` ([#362](https://www.github.com/googleapis/java-aiplatform/issues/362)) ([778f54a](https://www.github.com/googleapis/java-aiplatform/commit/778f54afcf852da2cdb371fc1b2303ce54589e02))
* add aiplatform API Vizier service ([fee522f](https://www.github.com/googleapis/java-aiplatform/commit/fee522f6184de7ae89c1cc471142fbab44116aff))
* add featurestore, index, metadata, monitoring, pipeline, and tensorboard services to aiplatform v1beta1 ([#341](https://www.github.com/googleapis/java-aiplatform/issues/341)) ([ca54151](https://www.github.com/googleapis/java-aiplatform/commit/ca541512ffd89f43d236eab8a657f7b8f4bade3d))
* add invalid_row_count to ImportFeatureValuesResponse and ImportFeatureValuesOperationMetadata ([d73ec5a](https://www.github.com/googleapis/java-aiplatform/commit/d73ec5afeb71ce752dbec975ac7562b92ef2ceef))
* adds enhanced protos for time series forecasting ([#356](https://www.github.com/googleapis/java-aiplatform/issues/356)) ([d73ec5a](https://www.github.com/googleapis/java-aiplatform/commit/d73ec5afeb71ce752dbec975ac7562b92ef2ceef))
* promote to 1.0.0 ([#402](https://www.github.com/googleapis/java-aiplatform/issues/402)) ([b22d40b](https://www.github.com/googleapis/java-aiplatform/commit/b22d40ba091698eb14ed9f421a8749ba62a1c6fd))
* remove unsupported accelerator types ([fee522f](https://www.github.com/googleapis/java-aiplatform/commit/fee522f6184de7ae89c1cc471142fbab44116aff))
* removes unneeded protos and files from v1beta1 ([#198](https://www.github.com/googleapis/java-aiplatform/issues/198)) ([5c0de9f](https://www.github.com/googleapis/java-aiplatform/commit/5c0de9f6ac27685170644f467610dc89d2f0e34b))


### Bug Fixes

* configuring timeouts for aiplatform v1 methods ([fee522f](https://www.github.com/googleapis/java-aiplatform/commit/fee522f6184de7ae89c1cc471142fbab44116aff))
* release scripts from issuing overlapping phases ([#245](https://www.github.com/googleapis/java-aiplatform/issues/245)) ([43ec06b](https://www.github.com/googleapis/java-aiplatform/commit/43ec06bd4809bc97dda6f5a913452381389541d1))
* remove display_name from FeatureStore ([d73ec5a](https://www.github.com/googleapis/java-aiplatform/commit/d73ec5afeb71ce752dbec975ac7562b92ef2ceef))


### Documentation

* changes product name to 'Vertex AI' ([#367](https://www.github.com/googleapis/java-aiplatform/issues/367)) ([0141e15](https://www.github.com/googleapis/java-aiplatform/commit/0141e15e6cdd0428d65ebd99842ee66fd917d627))
* changes product name to 'Vertex AI' ([#397](https://www.github.com/googleapis/java-aiplatform/issues/397)) ([348a87f](https://www.github.com/googleapis/java-aiplatform/commit/348a87fb714f7be84befe57d461857b0409a804f))
* correct link to fieldmask ([0141e15](https://www.github.com/googleapis/java-aiplatform/commit/0141e15e6cdd0428d65ebd99842ee66fd917d627))
* removes tinyurl links ([348a87f](https://www.github.com/googleapis/java-aiplatform/commit/348a87fb714f7be84befe57d461857b0409a804f))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.21.1 ([#253](https://www.github.com/googleapis/java-aiplatform/issues/253)) ([f8e020f](https://www.github.com/googleapis/java-aiplatform/commit/f8e020f7750511bfc3358dd44d465c03d9becf62))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1 ([#329](https://www.github.com/googleapis/java-aiplatform/issues/329)) ([591c274](https://www.github.com/googleapis/java-aiplatform/commit/591c274ff3ffca5e0d964148eaeebaca5551ecaa))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.1.0 ([#346](https://www.github.com/googleapis/java-aiplatform/issues/346)) ([d2aec6c](https://www.github.com/googleapis/java-aiplatform/commit/d2aec6c92e56362a5bfb2601dc1558bc081f3dae))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.2.0 ([#361](https://www.github.com/googleapis/java-aiplatform/issues/361)) ([e1506a8](https://www.github.com/googleapis/java-aiplatform/commit/e1506a804d82f1289c60a9d5056f20df1cd6c11f))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v1.3.0 ([#398](https://www.github.com/googleapis/java-aiplatform/issues/398)) ([dafca5d](https://www.github.com/googleapis/java-aiplatform/commit/dafca5d9fc1c0d77fc0c3f26c08c6827e53492a3))
* update dependency com.google.cloud:google-cloud-storage to v1.113.16 ([#334](https://www.github.com/googleapis/java-aiplatform/issues/334)) ([5659ceb](https://www.github.com/googleapis/java-aiplatform/commit/5659cebd87fd1ccd730a817049c05865b8ce240c))
* update dependency com.google.cloud:google-cloud-storage to v1.114.0 ([#349](https://www.github.com/googleapis/java-aiplatform/issues/349)) ([596eb79](https://www.github.com/googleapis/java-aiplatform/commit/596eb795a30cfe319daed0dde7492ea55b1737a2))
* update dependency com.google.cloud:google-cloud-storage to v1.115.0 ([#396](https://www.github.com/googleapis/java-aiplatform/issues/396)) ([8e2f7cc](https://www.github.com/googleapis/java-aiplatform/commit/8e2f7cc9b83fbd2f3cc326f1370b27d30cde636a))
* update dependency com.google.code.gson:gson to v2.8.7 ([#382](https://www.github.com/googleapis/java-aiplatform/issues/382)) ([90bfc56](https://www.github.com/googleapis/java-aiplatform/commit/90bfc56459cf1da02b9c6efde01791742b5e5161))

### [0.4.1](https://www.github.com/googleapis/java-aiplatform/compare/v0.4.0...v0.4.1) (2021-04-15)


### Dependencies

* update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.4.0 ([#210](https://www.github.com/googleapis/java-aiplatform/issues/210)) ([931c3bb](https://www.github.com/googleapis/java-aiplatform/commit/931c3bbfa9fa523a3152d2a9a885ae62b3fca65b))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.21.0 ([#227](https://www.github.com/googleapis/java-aiplatform/issues/227)) ([6be4f2c](https://www.github.com/googleapis/java-aiplatform/commit/6be4f2c5a69efa17a00db7664c2d4e772fb2d637))
* update dependency com.google.cloud:google-cloud-storage to v1.113.15 ([#232](https://www.github.com/googleapis/java-aiplatform/issues/232)) ([7f56ead](https://www.github.com/googleapis/java-aiplatform/commit/7f56ead94e1d6eeb605891c898c5051e0045fbdf))

## [0.4.0](https://www.github.com/googleapis/java-aiplatform/compare/v0.3.0...v0.4.0) (2021-03-12)


### Features

* add encryption_spec to aiplatform v1beta1 ([#176](https://www.github.com/googleapis/java-aiplatform/issues/176)) ([faff19b](https://www.github.com/googleapis/java-aiplatform/commit/faff19b2820146d6cf49525f49ae187449171641))


### Dependencies

* update dependency com.google.api.grpc:proto-google-cloud-aiplatform-v1beta1 to v0.3.0 ([#189](https://www.github.com/googleapis/java-aiplatform/issues/189)) ([5bdf3d0](https://www.github.com/googleapis/java-aiplatform/commit/5bdf3d04f365cb27446456e6df2a691ce1441434))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.20.1 ([#203](https://www.github.com/googleapis/java-aiplatform/issues/203)) ([761e878](https://www.github.com/googleapis/java-aiplatform/commit/761e878b02eb0268b16d1325749d399e66a487df))
* update dependency com.google.cloud:google-cloud-storage to v1.113.12 ([#186](https://www.github.com/googleapis/java-aiplatform/issues/186)) ([3fae117](https://www.github.com/googleapis/java-aiplatform/commit/3fae117a6c9d73d292b879c05ba849f0846af73d))
* update dependency com.google.cloud:google-cloud-storage to v1.113.14 ([#202](https://www.github.com/googleapis/java-aiplatform/issues/202)) ([767cf1d](https://www.github.com/googleapis/java-aiplatform/commit/767cf1d9624e65970f30094484bbc571bd8c858b))

## [0.3.0](https://www.github.com/googleapis/java-aiplatform/compare/v0.2.0...v0.3.0) (2021-02-26)


### Features

* add encryption_spec to aiplatform v1beta1  ([#167](https://www.github.com/googleapis/java-aiplatform/issues/167)) ([f1523a2](https://www.github.com/googleapis/java-aiplatform/commit/f1523a2be87331d2298d740da041eb5275fb4813))
* add encryption_spec to aiplatform v1beta1 ([#155](https://www.github.com/googleapis/java-aiplatform/issues/155)) ([fbeb273](https://www.github.com/googleapis/java-aiplatform/commit/fbeb273ac6e21ca01a39de3b4964cf28cc441efd))
* updates library for v1 service ([#157](https://www.github.com/googleapis/java-aiplatform/issues/157)) ([587b2fa](https://www.github.com/googleapis/java-aiplatform/commit/587b2fab293ca50fe42512569cf35997f9099269))


### Bug Fixes

* reduces image object detection test resource file size ([#154](https://www.github.com/googleapis/java-aiplatform/issues/154)) ([8cf8cc6](https://www.github.com/googleapis/java-aiplatform/commit/8cf8cc6b36e127c8dfdc9677906195c49065c7ea))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.18.0 ([#131](https://www.github.com/googleapis/java-aiplatform/issues/131)) ([d56e6ab](https://www.github.com/googleapis/java-aiplatform/commit/d56e6ab0c7022ef508c96ba04330b1926a08088d))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.19.0 ([#172](https://www.github.com/googleapis/java-aiplatform/issues/172)) ([871e976](https://www.github.com/googleapis/java-aiplatform/commit/871e9761e560b2220d9e3611f48d58c0091b966e))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.20.0 ([#184](https://www.github.com/googleapis/java-aiplatform/issues/184)) ([e79f59d](https://www.github.com/googleapis/java-aiplatform/commit/e79f59d4d46b7193eed00032b349b86c14213825))
* update dependency com.google.cloud:google-cloud-storage to v1.113.10 ([#164](https://www.github.com/googleapis/java-aiplatform/issues/164)) ([c49ac84](https://www.github.com/googleapis/java-aiplatform/commit/c49ac8463d342c141cf59af5c19f1ef7f28fd8a5))
* update dependency com.google.cloud:google-cloud-storage to v1.113.11 ([#175](https://www.github.com/googleapis/java-aiplatform/issues/175)) ([74efed2](https://www.github.com/googleapis/java-aiplatform/commit/74efed25aba13f526b3745baeb9b1146c3a6c357))
* update dependency com.google.cloud:google-cloud-storage to v1.113.9 ([#132](https://www.github.com/googleapis/java-aiplatform/issues/132)) ([bc8826a](https://www.github.com/googleapis/java-aiplatform/commit/bc8826aea48191fea3a2a392f2beaaa192edc777))


### Documentation

* updates prediction to new hostname ([#173](https://www.github.com/googleapis/java-aiplatform/issues/173)) ([ea1afeb](https://www.github.com/googleapis/java-aiplatform/commit/ea1afeba05cc830a30c27032e8b71b270183656e))

## [0.2.0](https://www.github.com/googleapis/java-aiplatform/compare/v0.1.0...v0.2.0) (2021-01-07)


### Features

* add enhanced types for library ([#74](https://www.github.com/googleapis/java-aiplatform/issues/74)) ([7835807](https://www.github.com/googleapis/java-aiplatform/commit/783580731c9699266ca79b0ed50b035696921abf))
* adds ValueConverter utility and demo samples ([#108](https://www.github.com/googleapis/java-aiplatform/issues/108)) ([cf0b763](https://www.github.com/googleapis/java-aiplatform/commit/cf0b763ab3c43449090b4621a8f7e9a97ada4bc6))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.16.0 ([#102](https://www.github.com/googleapis/java-aiplatform/issues/102)) ([f0145cd](https://www.github.com/googleapis/java-aiplatform/commit/f0145cd5c32f961ae2e8c9eb688c37ed5722eaeb))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.16.1 ([#113](https://www.github.com/googleapis/java-aiplatform/issues/113)) ([e2d8e42](https://www.github.com/googleapis/java-aiplatform/commit/e2d8e42b9237f7a7c22826101f05c58bc26e2923))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.17.0 ([#116](https://www.github.com/googleapis/java-aiplatform/issues/116)) ([f8a115a](https://www.github.com/googleapis/java-aiplatform/commit/f8a115a4ea2423bd9d39e79a6d55d5e253bf763e))

## 0.1.0 (2020-11-12)


### ⚠ BREAKING CHANGES

* sampled_shapley_attribution moved into a oneof in explanation.proto. field min renamed to min_value in ExplanationMetadata.InputMetadata.FeatureValueDomain in explanation_metadata.proto. field max renamed to max_value in ExplanationMetadata.InputMetadata.FeatureValueDomain in explanation_metadata.proto.

### Features

* aiplatform v1beta1 regeneration  ([#43](https://www.github.com/googleapis/java-aiplatform/issues/43)) ([64b027c](https://www.github.com/googleapis/java-aiplatform/commit/64b027cbcd51995c87fc530909fde799d52789dc))
* initial code generation ([a5494b0](https://www.github.com/googleapis/java-aiplatform/commit/a5494b0e45f6e1eef50ce80fa3482d8e5afc58dd))


### Documentation

* fix generated typos ([#49](https://www.github.com/googleapis/java-aiplatform/issues/49)) ([bbb67ad](https://www.github.com/googleapis/java-aiplatform/commit/bbb67ada1eddc0c7ca34080a70c3fc8da58ac481))


### Dependencies

* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.10.0 ([#3](https://www.github.com/googleapis/java-aiplatform/issues/3)) ([ac5f6f7](https://www.github.com/googleapis/java-aiplatform/commit/ac5f6f79a3baf0cf3d1058d17758b21a87b3793b))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.10.2 ([#28](https://www.github.com/googleapis/java-aiplatform/issues/28)) ([ddcc914](https://www.github.com/googleapis/java-aiplatform/commit/ddcc914bd66bbef724ebf4af54aca0be3bee9b06))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.12.1 ([#32](https://www.github.com/googleapis/java-aiplatform/issues/32)) ([ee6a621](https://www.github.com/googleapis/java-aiplatform/commit/ee6a6217770b73ae3c9d230f02c978b83d419323))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.13.0 ([#34](https://www.github.com/googleapis/java-aiplatform/issues/34)) ([3de26d4](https://www.github.com/googleapis/java-aiplatform/commit/3de26d48b297f1bb7229a9ed3ca4edd4d66473cb))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.14.1 ([#42](https://www.github.com/googleapis/java-aiplatform/issues/42)) ([d550f43](https://www.github.com/googleapis/java-aiplatform/commit/d550f436bbd6dec93357d8b9647829ddd90a50dc))
* update dependency com.google.cloud:google-cloud-shared-dependencies to v0.15.0 ([#56](https://www.github.com/googleapis/java-aiplatform/issues/56)) ([270c331](https://www.github.com/googleapis/java-aiplatform/commit/270c331619d30447b48d1e7216bfc2a5a7c4599b))
* update dependency com.google.cloud:google-cloud-storage to v1.113.2 ([#38](https://www.github.com/googleapis/java-aiplatform/issues/38)) ([b3a04e1](https://www.github.com/googleapis/java-aiplatform/commit/b3a04e135aee8415d4d67d6967273bace0991a64))
