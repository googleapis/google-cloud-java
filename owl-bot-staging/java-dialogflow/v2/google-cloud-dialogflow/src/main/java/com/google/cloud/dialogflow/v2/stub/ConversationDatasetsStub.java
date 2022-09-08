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

package com.google.cloud.dialogflow.v2.stub;

import static com.google.cloud.dialogflow.v2.ConversationDatasetsClient.ListConversationDatasetsPagedResponse;
import static com.google.cloud.dialogflow.v2.ConversationDatasetsClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2.ConversationDataset;
import com.google.cloud.dialogflow.v2.CreateConversationDatasetOperationMetadata;
import com.google.cloud.dialogflow.v2.CreateConversationDatasetRequest;
import com.google.cloud.dialogflow.v2.DeleteConversationDatasetOperationMetadata;
import com.google.cloud.dialogflow.v2.DeleteConversationDatasetRequest;
import com.google.cloud.dialogflow.v2.GetConversationDatasetRequest;
import com.google.cloud.dialogflow.v2.ImportConversationDataOperationMetadata;
import com.google.cloud.dialogflow.v2.ImportConversationDataOperationResponse;
import com.google.cloud.dialogflow.v2.ImportConversationDataRequest;
import com.google.cloud.dialogflow.v2.ListConversationDatasetsRequest;
import com.google.cloud.dialogflow.v2.ListConversationDatasetsResponse;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ConversationDatasets service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ConversationDatasetsStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public OperationCallable<
          CreateConversationDatasetRequest,
          ConversationDataset,
          CreateConversationDatasetOperationMetadata>
      createConversationDatasetOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createConversationDatasetOperationCallable()");
  }

  public UnaryCallable<CreateConversationDatasetRequest, Operation>
      createConversationDatasetCallable() {
    throw new UnsupportedOperationException("Not implemented: createConversationDatasetCallable()");
  }

  public UnaryCallable<GetConversationDatasetRequest, ConversationDataset>
      getConversationDatasetCallable() {
    throw new UnsupportedOperationException("Not implemented: getConversationDatasetCallable()");
  }

  public UnaryCallable<ListConversationDatasetsRequest, ListConversationDatasetsPagedResponse>
      listConversationDatasetsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listConversationDatasetsPagedCallable()");
  }

  public UnaryCallable<ListConversationDatasetsRequest, ListConversationDatasetsResponse>
      listConversationDatasetsCallable() {
    throw new UnsupportedOperationException("Not implemented: listConversationDatasetsCallable()");
  }

  public OperationCallable<
          DeleteConversationDatasetRequest, Empty, DeleteConversationDatasetOperationMetadata>
      deleteConversationDatasetOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteConversationDatasetOperationCallable()");
  }

  public UnaryCallable<DeleteConversationDatasetRequest, Operation>
      deleteConversationDatasetCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteConversationDatasetCallable()");
  }

  public OperationCallable<
          ImportConversationDataRequest,
          ImportConversationDataOperationResponse,
          ImportConversationDataOperationMetadata>
      importConversationDataOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: importConversationDataOperationCallable()");
  }

  public UnaryCallable<ImportConversationDataRequest, Operation> importConversationDataCallable() {
    throw new UnsupportedOperationException("Not implemented: importConversationDataCallable()");
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

  @Override
  public abstract void close();
}
