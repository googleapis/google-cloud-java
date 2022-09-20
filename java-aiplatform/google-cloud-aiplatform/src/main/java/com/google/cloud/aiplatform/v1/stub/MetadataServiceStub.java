/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.aiplatform.v1.stub;

import static com.google.cloud.aiplatform.v1.MetadataServiceClient.ListArtifactsPagedResponse;
import static com.google.cloud.aiplatform.v1.MetadataServiceClient.ListContextsPagedResponse;
import static com.google.cloud.aiplatform.v1.MetadataServiceClient.ListExecutionsPagedResponse;
import static com.google.cloud.aiplatform.v1.MetadataServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1.MetadataServiceClient.ListMetadataSchemasPagedResponse;
import static com.google.cloud.aiplatform.v1.MetadataServiceClient.ListMetadataStoresPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1.AddContextArtifactsAndExecutionsRequest;
import com.google.cloud.aiplatform.v1.AddContextArtifactsAndExecutionsResponse;
import com.google.cloud.aiplatform.v1.AddContextChildrenRequest;
import com.google.cloud.aiplatform.v1.AddContextChildrenResponse;
import com.google.cloud.aiplatform.v1.AddExecutionEventsRequest;
import com.google.cloud.aiplatform.v1.AddExecutionEventsResponse;
import com.google.cloud.aiplatform.v1.Artifact;
import com.google.cloud.aiplatform.v1.Context;
import com.google.cloud.aiplatform.v1.CreateArtifactRequest;
import com.google.cloud.aiplatform.v1.CreateContextRequest;
import com.google.cloud.aiplatform.v1.CreateExecutionRequest;
import com.google.cloud.aiplatform.v1.CreateMetadataSchemaRequest;
import com.google.cloud.aiplatform.v1.CreateMetadataStoreOperationMetadata;
import com.google.cloud.aiplatform.v1.CreateMetadataStoreRequest;
import com.google.cloud.aiplatform.v1.DeleteArtifactRequest;
import com.google.cloud.aiplatform.v1.DeleteContextRequest;
import com.google.cloud.aiplatform.v1.DeleteExecutionRequest;
import com.google.cloud.aiplatform.v1.DeleteMetadataStoreOperationMetadata;
import com.google.cloud.aiplatform.v1.DeleteMetadataStoreRequest;
import com.google.cloud.aiplatform.v1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1.Execution;
import com.google.cloud.aiplatform.v1.GetArtifactRequest;
import com.google.cloud.aiplatform.v1.GetContextRequest;
import com.google.cloud.aiplatform.v1.GetExecutionRequest;
import com.google.cloud.aiplatform.v1.GetMetadataSchemaRequest;
import com.google.cloud.aiplatform.v1.GetMetadataStoreRequest;
import com.google.cloud.aiplatform.v1.LineageSubgraph;
import com.google.cloud.aiplatform.v1.ListArtifactsRequest;
import com.google.cloud.aiplatform.v1.ListArtifactsResponse;
import com.google.cloud.aiplatform.v1.ListContextsRequest;
import com.google.cloud.aiplatform.v1.ListContextsResponse;
import com.google.cloud.aiplatform.v1.ListExecutionsRequest;
import com.google.cloud.aiplatform.v1.ListExecutionsResponse;
import com.google.cloud.aiplatform.v1.ListMetadataSchemasRequest;
import com.google.cloud.aiplatform.v1.ListMetadataSchemasResponse;
import com.google.cloud.aiplatform.v1.ListMetadataStoresRequest;
import com.google.cloud.aiplatform.v1.ListMetadataStoresResponse;
import com.google.cloud.aiplatform.v1.MetadataSchema;
import com.google.cloud.aiplatform.v1.MetadataStore;
import com.google.cloud.aiplatform.v1.PurgeArtifactsMetadata;
import com.google.cloud.aiplatform.v1.PurgeArtifactsRequest;
import com.google.cloud.aiplatform.v1.PurgeArtifactsResponse;
import com.google.cloud.aiplatform.v1.PurgeContextsMetadata;
import com.google.cloud.aiplatform.v1.PurgeContextsRequest;
import com.google.cloud.aiplatform.v1.PurgeContextsResponse;
import com.google.cloud.aiplatform.v1.PurgeExecutionsMetadata;
import com.google.cloud.aiplatform.v1.PurgeExecutionsRequest;
import com.google.cloud.aiplatform.v1.PurgeExecutionsResponse;
import com.google.cloud.aiplatform.v1.QueryArtifactLineageSubgraphRequest;
import com.google.cloud.aiplatform.v1.QueryContextLineageSubgraphRequest;
import com.google.cloud.aiplatform.v1.QueryExecutionInputsAndOutputsRequest;
import com.google.cloud.aiplatform.v1.RemoveContextChildrenRequest;
import com.google.cloud.aiplatform.v1.RemoveContextChildrenResponse;
import com.google.cloud.aiplatform.v1.UpdateArtifactRequest;
import com.google.cloud.aiplatform.v1.UpdateContextRequest;
import com.google.cloud.aiplatform.v1.UpdateExecutionRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the MetadataService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class MetadataServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public OperationCallable<
          CreateMetadataStoreRequest, MetadataStore, CreateMetadataStoreOperationMetadata>
      createMetadataStoreOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createMetadataStoreOperationCallable()");
  }

  public UnaryCallable<CreateMetadataStoreRequest, Operation> createMetadataStoreCallable() {
    throw new UnsupportedOperationException("Not implemented: createMetadataStoreCallable()");
  }

  public UnaryCallable<GetMetadataStoreRequest, MetadataStore> getMetadataStoreCallable() {
    throw new UnsupportedOperationException("Not implemented: getMetadataStoreCallable()");
  }

  public UnaryCallable<ListMetadataStoresRequest, ListMetadataStoresPagedResponse>
      listMetadataStoresPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listMetadataStoresPagedCallable()");
  }

  public UnaryCallable<ListMetadataStoresRequest, ListMetadataStoresResponse>
      listMetadataStoresCallable() {
    throw new UnsupportedOperationException("Not implemented: listMetadataStoresCallable()");
  }

  public OperationCallable<DeleteMetadataStoreRequest, Empty, DeleteMetadataStoreOperationMetadata>
      deleteMetadataStoreOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteMetadataStoreOperationCallable()");
  }

  public UnaryCallable<DeleteMetadataStoreRequest, Operation> deleteMetadataStoreCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteMetadataStoreCallable()");
  }

  public UnaryCallable<CreateArtifactRequest, Artifact> createArtifactCallable() {
    throw new UnsupportedOperationException("Not implemented: createArtifactCallable()");
  }

  public UnaryCallable<GetArtifactRequest, Artifact> getArtifactCallable() {
    throw new UnsupportedOperationException("Not implemented: getArtifactCallable()");
  }

  public UnaryCallable<ListArtifactsRequest, ListArtifactsPagedResponse>
      listArtifactsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listArtifactsPagedCallable()");
  }

  public UnaryCallable<ListArtifactsRequest, ListArtifactsResponse> listArtifactsCallable() {
    throw new UnsupportedOperationException("Not implemented: listArtifactsCallable()");
  }

  public UnaryCallable<UpdateArtifactRequest, Artifact> updateArtifactCallable() {
    throw new UnsupportedOperationException("Not implemented: updateArtifactCallable()");
  }

  public OperationCallable<DeleteArtifactRequest, Empty, DeleteOperationMetadata>
      deleteArtifactOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteArtifactOperationCallable()");
  }

  public UnaryCallable<DeleteArtifactRequest, Operation> deleteArtifactCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteArtifactCallable()");
  }

  public OperationCallable<PurgeArtifactsRequest, PurgeArtifactsResponse, PurgeArtifactsMetadata>
      purgeArtifactsOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: purgeArtifactsOperationCallable()");
  }

  public UnaryCallable<PurgeArtifactsRequest, Operation> purgeArtifactsCallable() {
    throw new UnsupportedOperationException("Not implemented: purgeArtifactsCallable()");
  }

  public UnaryCallable<CreateContextRequest, Context> createContextCallable() {
    throw new UnsupportedOperationException("Not implemented: createContextCallable()");
  }

  public UnaryCallable<GetContextRequest, Context> getContextCallable() {
    throw new UnsupportedOperationException("Not implemented: getContextCallable()");
  }

  public UnaryCallable<ListContextsRequest, ListContextsPagedResponse> listContextsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listContextsPagedCallable()");
  }

  public UnaryCallable<ListContextsRequest, ListContextsResponse> listContextsCallable() {
    throw new UnsupportedOperationException("Not implemented: listContextsCallable()");
  }

  public UnaryCallable<UpdateContextRequest, Context> updateContextCallable() {
    throw new UnsupportedOperationException("Not implemented: updateContextCallable()");
  }

  public OperationCallable<DeleteContextRequest, Empty, DeleteOperationMetadata>
      deleteContextOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteContextOperationCallable()");
  }

  public UnaryCallable<DeleteContextRequest, Operation> deleteContextCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteContextCallable()");
  }

  public OperationCallable<PurgeContextsRequest, PurgeContextsResponse, PurgeContextsMetadata>
      purgeContextsOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: purgeContextsOperationCallable()");
  }

  public UnaryCallable<PurgeContextsRequest, Operation> purgeContextsCallable() {
    throw new UnsupportedOperationException("Not implemented: purgeContextsCallable()");
  }

  public UnaryCallable<
          AddContextArtifactsAndExecutionsRequest, AddContextArtifactsAndExecutionsResponse>
      addContextArtifactsAndExecutionsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: addContextArtifactsAndExecutionsCallable()");
  }

  public UnaryCallable<AddContextChildrenRequest, AddContextChildrenResponse>
      addContextChildrenCallable() {
    throw new UnsupportedOperationException("Not implemented: addContextChildrenCallable()");
  }

  public UnaryCallable<RemoveContextChildrenRequest, RemoveContextChildrenResponse>
      removeContextChildrenCallable() {
    throw new UnsupportedOperationException("Not implemented: removeContextChildrenCallable()");
  }

  public UnaryCallable<QueryContextLineageSubgraphRequest, LineageSubgraph>
      queryContextLineageSubgraphCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: queryContextLineageSubgraphCallable()");
  }

  public UnaryCallable<CreateExecutionRequest, Execution> createExecutionCallable() {
    throw new UnsupportedOperationException("Not implemented: createExecutionCallable()");
  }

  public UnaryCallable<GetExecutionRequest, Execution> getExecutionCallable() {
    throw new UnsupportedOperationException("Not implemented: getExecutionCallable()");
  }

  public UnaryCallable<ListExecutionsRequest, ListExecutionsPagedResponse>
      listExecutionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listExecutionsPagedCallable()");
  }

  public UnaryCallable<ListExecutionsRequest, ListExecutionsResponse> listExecutionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listExecutionsCallable()");
  }

  public UnaryCallable<UpdateExecutionRequest, Execution> updateExecutionCallable() {
    throw new UnsupportedOperationException("Not implemented: updateExecutionCallable()");
  }

  public OperationCallable<DeleteExecutionRequest, Empty, DeleteOperationMetadata>
      deleteExecutionOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteExecutionOperationCallable()");
  }

  public UnaryCallable<DeleteExecutionRequest, Operation> deleteExecutionCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteExecutionCallable()");
  }

  public OperationCallable<PurgeExecutionsRequest, PurgeExecutionsResponse, PurgeExecutionsMetadata>
      purgeExecutionsOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: purgeExecutionsOperationCallable()");
  }

  public UnaryCallable<PurgeExecutionsRequest, Operation> purgeExecutionsCallable() {
    throw new UnsupportedOperationException("Not implemented: purgeExecutionsCallable()");
  }

  public UnaryCallable<AddExecutionEventsRequest, AddExecutionEventsResponse>
      addExecutionEventsCallable() {
    throw new UnsupportedOperationException("Not implemented: addExecutionEventsCallable()");
  }

  public UnaryCallable<QueryExecutionInputsAndOutputsRequest, LineageSubgraph>
      queryExecutionInputsAndOutputsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: queryExecutionInputsAndOutputsCallable()");
  }

  public UnaryCallable<CreateMetadataSchemaRequest, MetadataSchema> createMetadataSchemaCallable() {
    throw new UnsupportedOperationException("Not implemented: createMetadataSchemaCallable()");
  }

  public UnaryCallable<GetMetadataSchemaRequest, MetadataSchema> getMetadataSchemaCallable() {
    throw new UnsupportedOperationException("Not implemented: getMetadataSchemaCallable()");
  }

  public UnaryCallable<ListMetadataSchemasRequest, ListMetadataSchemasPagedResponse>
      listMetadataSchemasPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listMetadataSchemasPagedCallable()");
  }

  public UnaryCallable<ListMetadataSchemasRequest, ListMetadataSchemasResponse>
      listMetadataSchemasCallable() {
    throw new UnsupportedOperationException("Not implemented: listMetadataSchemasCallable()");
  }

  public UnaryCallable<QueryArtifactLineageSubgraphRequest, LineageSubgraph>
      queryArtifactLineageSubgraphCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: queryArtifactLineageSubgraphCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsPagedCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsCallable()");
  }

  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    throw new UnsupportedOperationException("Not implemented: getLocationCallable()");
  }

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
