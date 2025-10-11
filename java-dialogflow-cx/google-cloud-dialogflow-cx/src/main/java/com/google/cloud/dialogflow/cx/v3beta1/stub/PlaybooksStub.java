/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.dialogflow.cx.v3beta1.stub;

import static com.google.cloud.dialogflow.cx.v3beta1.PlaybooksClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3beta1.PlaybooksClient.ListPlaybookVersionsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3beta1.PlaybooksClient.ListPlaybooksPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.cx.v3beta1.CreatePlaybookRequest;
import com.google.cloud.dialogflow.cx.v3beta1.CreatePlaybookVersionRequest;
import com.google.cloud.dialogflow.cx.v3beta1.DeletePlaybookRequest;
import com.google.cloud.dialogflow.cx.v3beta1.DeletePlaybookVersionRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ExportPlaybookRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ExportPlaybookResponse;
import com.google.cloud.dialogflow.cx.v3beta1.GetPlaybookRequest;
import com.google.cloud.dialogflow.cx.v3beta1.GetPlaybookVersionRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ImportPlaybookRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ImportPlaybookResponse;
import com.google.cloud.dialogflow.cx.v3beta1.ListPlaybookVersionsRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListPlaybookVersionsResponse;
import com.google.cloud.dialogflow.cx.v3beta1.ListPlaybooksRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListPlaybooksResponse;
import com.google.cloud.dialogflow.cx.v3beta1.Playbook;
import com.google.cloud.dialogflow.cx.v3beta1.PlaybookVersion;
import com.google.cloud.dialogflow.cx.v3beta1.RestorePlaybookVersionRequest;
import com.google.cloud.dialogflow.cx.v3beta1.RestorePlaybookVersionResponse;
import com.google.cloud.dialogflow.cx.v3beta1.UpdatePlaybookRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import com.google.protobuf.Struct;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Playbooks service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class PlaybooksStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<CreatePlaybookRequest, Playbook> createPlaybookCallable() {
    throw new UnsupportedOperationException("Not implemented: createPlaybookCallable()");
  }

  public UnaryCallable<DeletePlaybookRequest, Empty> deletePlaybookCallable() {
    throw new UnsupportedOperationException("Not implemented: deletePlaybookCallable()");
  }

  public UnaryCallable<ListPlaybooksRequest, ListPlaybooksPagedResponse>
      listPlaybooksPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPlaybooksPagedCallable()");
  }

  public UnaryCallable<ListPlaybooksRequest, ListPlaybooksResponse> listPlaybooksCallable() {
    throw new UnsupportedOperationException("Not implemented: listPlaybooksCallable()");
  }

  public UnaryCallable<GetPlaybookRequest, Playbook> getPlaybookCallable() {
    throw new UnsupportedOperationException("Not implemented: getPlaybookCallable()");
  }

  public OperationCallable<ExportPlaybookRequest, ExportPlaybookResponse, Struct>
      exportPlaybookOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: exportPlaybookOperationCallable()");
  }

  public UnaryCallable<ExportPlaybookRequest, Operation> exportPlaybookCallable() {
    throw new UnsupportedOperationException("Not implemented: exportPlaybookCallable()");
  }

  public OperationCallable<ImportPlaybookRequest, ImportPlaybookResponse, Struct>
      importPlaybookOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: importPlaybookOperationCallable()");
  }

  public UnaryCallable<ImportPlaybookRequest, Operation> importPlaybookCallable() {
    throw new UnsupportedOperationException("Not implemented: importPlaybookCallable()");
  }

  public UnaryCallable<UpdatePlaybookRequest, Playbook> updatePlaybookCallable() {
    throw new UnsupportedOperationException("Not implemented: updatePlaybookCallable()");
  }

  public UnaryCallable<CreatePlaybookVersionRequest, PlaybookVersion>
      createPlaybookVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: createPlaybookVersionCallable()");
  }

  public UnaryCallable<GetPlaybookVersionRequest, PlaybookVersion> getPlaybookVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: getPlaybookVersionCallable()");
  }

  public UnaryCallable<RestorePlaybookVersionRequest, RestorePlaybookVersionResponse>
      restorePlaybookVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: restorePlaybookVersionCallable()");
  }

  public UnaryCallable<ListPlaybookVersionsRequest, ListPlaybookVersionsPagedResponse>
      listPlaybookVersionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPlaybookVersionsPagedCallable()");
  }

  public UnaryCallable<ListPlaybookVersionsRequest, ListPlaybookVersionsResponse>
      listPlaybookVersionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listPlaybookVersionsCallable()");
  }

  public UnaryCallable<DeletePlaybookVersionRequest, Empty> deletePlaybookVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: deletePlaybookVersionCallable()");
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
