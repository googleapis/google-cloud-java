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

package com.google.cloud.discoveryengine.v1beta.stub;

import static com.google.cloud.discoveryengine.v1beta.SampleQueryServiceClient.ListSampleQueriesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1beta.CreateSampleQueryRequest;
import com.google.cloud.discoveryengine.v1beta.DeleteSampleQueryRequest;
import com.google.cloud.discoveryengine.v1beta.GetSampleQueryRequest;
import com.google.cloud.discoveryengine.v1beta.ImportSampleQueriesMetadata;
import com.google.cloud.discoveryengine.v1beta.ImportSampleQueriesRequest;
import com.google.cloud.discoveryengine.v1beta.ImportSampleQueriesResponse;
import com.google.cloud.discoveryengine.v1beta.ListSampleQueriesRequest;
import com.google.cloud.discoveryengine.v1beta.ListSampleQueriesResponse;
import com.google.cloud.discoveryengine.v1beta.SampleQuery;
import com.google.cloud.discoveryengine.v1beta.UpdateSampleQueryRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the SampleQueryService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class SampleQueryServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<GetSampleQueryRequest, SampleQuery> getSampleQueryCallable() {
    throw new UnsupportedOperationException("Not implemented: getSampleQueryCallable()");
  }

  public UnaryCallable<ListSampleQueriesRequest, ListSampleQueriesPagedResponse>
      listSampleQueriesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSampleQueriesPagedCallable()");
  }

  public UnaryCallable<ListSampleQueriesRequest, ListSampleQueriesResponse>
      listSampleQueriesCallable() {
    throw new UnsupportedOperationException("Not implemented: listSampleQueriesCallable()");
  }

  public UnaryCallable<CreateSampleQueryRequest, SampleQuery> createSampleQueryCallable() {
    throw new UnsupportedOperationException("Not implemented: createSampleQueryCallable()");
  }

  public UnaryCallable<UpdateSampleQueryRequest, SampleQuery> updateSampleQueryCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSampleQueryCallable()");
  }

  public UnaryCallable<DeleteSampleQueryRequest, Empty> deleteSampleQueryCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSampleQueryCallable()");
  }

  public OperationCallable<
          ImportSampleQueriesRequest, ImportSampleQueriesResponse, ImportSampleQueriesMetadata>
      importSampleQueriesOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: importSampleQueriesOperationCallable()");
  }

  public UnaryCallable<ImportSampleQueriesRequest, Operation> importSampleQueriesCallable() {
    throw new UnsupportedOperationException("Not implemented: importSampleQueriesCallable()");
  }

  @Override
  public abstract void close();
}
