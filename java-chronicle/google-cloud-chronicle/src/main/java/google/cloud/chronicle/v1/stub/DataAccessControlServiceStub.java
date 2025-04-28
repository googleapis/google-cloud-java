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

package google.cloud.chronicle.v1.stub;

import static google.cloud.chronicle.v1.DataAccessControlServiceClient.ListDataAccessLabelsPagedResponse;
import static google.cloud.chronicle.v1.DataAccessControlServiceClient.ListDataAccessScopesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.Empty;
import google.cloud.chronicle.v1.CreateDataAccessLabelRequest;
import google.cloud.chronicle.v1.CreateDataAccessScopeRequest;
import google.cloud.chronicle.v1.DataAccessLabel;
import google.cloud.chronicle.v1.DataAccessScope;
import google.cloud.chronicle.v1.DeleteDataAccessLabelRequest;
import google.cloud.chronicle.v1.DeleteDataAccessScopeRequest;
import google.cloud.chronicle.v1.GetDataAccessLabelRequest;
import google.cloud.chronicle.v1.GetDataAccessScopeRequest;
import google.cloud.chronicle.v1.ListDataAccessLabelsRequest;
import google.cloud.chronicle.v1.ListDataAccessLabelsResponse;
import google.cloud.chronicle.v1.ListDataAccessScopesRequest;
import google.cloud.chronicle.v1.ListDataAccessScopesResponse;
import google.cloud.chronicle.v1.UpdateDataAccessLabelRequest;
import google.cloud.chronicle.v1.UpdateDataAccessScopeRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the DataAccessControlService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class DataAccessControlServiceStub implements BackgroundResource {

  public UnaryCallable<CreateDataAccessLabelRequest, DataAccessLabel>
      createDataAccessLabelCallable() {
    throw new UnsupportedOperationException("Not implemented: createDataAccessLabelCallable()");
  }

  public UnaryCallable<GetDataAccessLabelRequest, DataAccessLabel> getDataAccessLabelCallable() {
    throw new UnsupportedOperationException("Not implemented: getDataAccessLabelCallable()");
  }

  public UnaryCallable<ListDataAccessLabelsRequest, ListDataAccessLabelsPagedResponse>
      listDataAccessLabelsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataAccessLabelsPagedCallable()");
  }

  public UnaryCallable<ListDataAccessLabelsRequest, ListDataAccessLabelsResponse>
      listDataAccessLabelsCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataAccessLabelsCallable()");
  }

  public UnaryCallable<UpdateDataAccessLabelRequest, DataAccessLabel>
      updateDataAccessLabelCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDataAccessLabelCallable()");
  }

  public UnaryCallable<DeleteDataAccessLabelRequest, Empty> deleteDataAccessLabelCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDataAccessLabelCallable()");
  }

  public UnaryCallable<CreateDataAccessScopeRequest, DataAccessScope>
      createDataAccessScopeCallable() {
    throw new UnsupportedOperationException("Not implemented: createDataAccessScopeCallable()");
  }

  public UnaryCallable<GetDataAccessScopeRequest, DataAccessScope> getDataAccessScopeCallable() {
    throw new UnsupportedOperationException("Not implemented: getDataAccessScopeCallable()");
  }

  public UnaryCallable<ListDataAccessScopesRequest, ListDataAccessScopesPagedResponse>
      listDataAccessScopesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataAccessScopesPagedCallable()");
  }

  public UnaryCallable<ListDataAccessScopesRequest, ListDataAccessScopesResponse>
      listDataAccessScopesCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataAccessScopesCallable()");
  }

  public UnaryCallable<UpdateDataAccessScopeRequest, DataAccessScope>
      updateDataAccessScopeCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDataAccessScopeCallable()");
  }

  public UnaryCallable<DeleteDataAccessScopeRequest, Empty> deleteDataAccessScopeCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDataAccessScopeCallable()");
  }

  @Override
  public abstract void close();
}
