/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.aiplatform.v1beta1.stub;

import static com.google.cloud.aiplatform.v1beta1.VertexRagDataServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.VertexRagDataServiceClient.ListRagCorporaPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.VertexRagDataServiceClient.ListRagFilesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.CreateRagCorpusOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.CreateRagCorpusRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.DeleteRagCorpusRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteRagFileRequest;
import com.google.cloud.aiplatform.v1beta1.GetRagCorpusRequest;
import com.google.cloud.aiplatform.v1beta1.GetRagFileRequest;
import com.google.cloud.aiplatform.v1beta1.ImportRagFilesOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.ImportRagFilesRequest;
import com.google.cloud.aiplatform.v1beta1.ImportRagFilesResponse;
import com.google.cloud.aiplatform.v1beta1.ListRagCorporaRequest;
import com.google.cloud.aiplatform.v1beta1.ListRagCorporaResponse;
import com.google.cloud.aiplatform.v1beta1.ListRagFilesRequest;
import com.google.cloud.aiplatform.v1beta1.ListRagFilesResponse;
import com.google.cloud.aiplatform.v1beta1.RagCorpus;
import com.google.cloud.aiplatform.v1beta1.RagFile;
import com.google.cloud.aiplatform.v1beta1.UploadRagFileRequest;
import com.google.cloud.aiplatform.v1beta1.UploadRagFileResponse;
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
 * Base stub class for the VertexRagDataService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class VertexRagDataServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public OperationCallable<CreateRagCorpusRequest, RagCorpus, CreateRagCorpusOperationMetadata>
      createRagCorpusOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createRagCorpusOperationCallable()");
  }

  public UnaryCallable<CreateRagCorpusRequest, Operation> createRagCorpusCallable() {
    throw new UnsupportedOperationException("Not implemented: createRagCorpusCallable()");
  }

  public UnaryCallable<GetRagCorpusRequest, RagCorpus> getRagCorpusCallable() {
    throw new UnsupportedOperationException("Not implemented: getRagCorpusCallable()");
  }

  public UnaryCallable<ListRagCorporaRequest, ListRagCorporaPagedResponse>
      listRagCorporaPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listRagCorporaPagedCallable()");
  }

  public UnaryCallable<ListRagCorporaRequest, ListRagCorporaResponse> listRagCorporaCallable() {
    throw new UnsupportedOperationException("Not implemented: listRagCorporaCallable()");
  }

  public OperationCallable<DeleteRagCorpusRequest, Empty, DeleteOperationMetadata>
      deleteRagCorpusOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteRagCorpusOperationCallable()");
  }

  public UnaryCallable<DeleteRagCorpusRequest, Operation> deleteRagCorpusCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteRagCorpusCallable()");
  }

  public UnaryCallable<UploadRagFileRequest, UploadRagFileResponse> uploadRagFileCallable() {
    throw new UnsupportedOperationException("Not implemented: uploadRagFileCallable()");
  }

  public OperationCallable<
          ImportRagFilesRequest, ImportRagFilesResponse, ImportRagFilesOperationMetadata>
      importRagFilesOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: importRagFilesOperationCallable()");
  }

  public UnaryCallable<ImportRagFilesRequest, Operation> importRagFilesCallable() {
    throw new UnsupportedOperationException("Not implemented: importRagFilesCallable()");
  }

  public UnaryCallable<GetRagFileRequest, RagFile> getRagFileCallable() {
    throw new UnsupportedOperationException("Not implemented: getRagFileCallable()");
  }

  public UnaryCallable<ListRagFilesRequest, ListRagFilesPagedResponse> listRagFilesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listRagFilesPagedCallable()");
  }

  public UnaryCallable<ListRagFilesRequest, ListRagFilesResponse> listRagFilesCallable() {
    throw new UnsupportedOperationException("Not implemented: listRagFilesCallable()");
  }

  public OperationCallable<DeleteRagFileRequest, Empty, DeleteOperationMetadata>
      deleteRagFileOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteRagFileOperationCallable()");
  }

  public UnaryCallable<DeleteRagFileRequest, Operation> deleteRagFileCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteRagFileCallable()");
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
