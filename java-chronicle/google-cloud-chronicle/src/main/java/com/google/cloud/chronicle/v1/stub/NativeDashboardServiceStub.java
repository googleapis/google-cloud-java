/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.chronicle.v1.stub;

import static com.google.cloud.chronicle.v1.NativeDashboardServiceClient.ListNativeDashboardsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.chronicle.v1.AddChartRequest;
import com.google.cloud.chronicle.v1.AddChartResponse;
import com.google.cloud.chronicle.v1.CreateNativeDashboardRequest;
import com.google.cloud.chronicle.v1.DeleteNativeDashboardRequest;
import com.google.cloud.chronicle.v1.DuplicateChartRequest;
import com.google.cloud.chronicle.v1.DuplicateChartResponse;
import com.google.cloud.chronicle.v1.DuplicateNativeDashboardRequest;
import com.google.cloud.chronicle.v1.EditChartRequest;
import com.google.cloud.chronicle.v1.EditChartResponse;
import com.google.cloud.chronicle.v1.ExportNativeDashboardsRequest;
import com.google.cloud.chronicle.v1.ExportNativeDashboardsResponse;
import com.google.cloud.chronicle.v1.GetNativeDashboardRequest;
import com.google.cloud.chronicle.v1.ImportNativeDashboardsRequest;
import com.google.cloud.chronicle.v1.ImportNativeDashboardsResponse;
import com.google.cloud.chronicle.v1.ListNativeDashboardsRequest;
import com.google.cloud.chronicle.v1.ListNativeDashboardsResponse;
import com.google.cloud.chronicle.v1.NativeDashboard;
import com.google.cloud.chronicle.v1.RemoveChartRequest;
import com.google.cloud.chronicle.v1.UpdateNativeDashboardRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the NativeDashboardService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class NativeDashboardServiceStub implements BackgroundResource {

  public UnaryCallable<CreateNativeDashboardRequest, NativeDashboard>
      createNativeDashboardCallable() {
    throw new UnsupportedOperationException("Not implemented: createNativeDashboardCallable()");
  }

  public UnaryCallable<GetNativeDashboardRequest, NativeDashboard> getNativeDashboardCallable() {
    throw new UnsupportedOperationException("Not implemented: getNativeDashboardCallable()");
  }

  public UnaryCallable<ListNativeDashboardsRequest, ListNativeDashboardsPagedResponse>
      listNativeDashboardsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listNativeDashboardsPagedCallable()");
  }

  public UnaryCallable<ListNativeDashboardsRequest, ListNativeDashboardsResponse>
      listNativeDashboardsCallable() {
    throw new UnsupportedOperationException("Not implemented: listNativeDashboardsCallable()");
  }

  public UnaryCallable<UpdateNativeDashboardRequest, NativeDashboard>
      updateNativeDashboardCallable() {
    throw new UnsupportedOperationException("Not implemented: updateNativeDashboardCallable()");
  }

  public UnaryCallable<DuplicateNativeDashboardRequest, NativeDashboard>
      duplicateNativeDashboardCallable() {
    throw new UnsupportedOperationException("Not implemented: duplicateNativeDashboardCallable()");
  }

  public UnaryCallable<DeleteNativeDashboardRequest, Empty> deleteNativeDashboardCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteNativeDashboardCallable()");
  }

  public UnaryCallable<AddChartRequest, AddChartResponse> addChartCallable() {
    throw new UnsupportedOperationException("Not implemented: addChartCallable()");
  }

  public UnaryCallable<RemoveChartRequest, NativeDashboard> removeChartCallable() {
    throw new UnsupportedOperationException("Not implemented: removeChartCallable()");
  }

  public UnaryCallable<EditChartRequest, EditChartResponse> editChartCallable() {
    throw new UnsupportedOperationException("Not implemented: editChartCallable()");
  }

  public UnaryCallable<DuplicateChartRequest, DuplicateChartResponse> duplicateChartCallable() {
    throw new UnsupportedOperationException("Not implemented: duplicateChartCallable()");
  }

  public UnaryCallable<ExportNativeDashboardsRequest, ExportNativeDashboardsResponse>
      exportNativeDashboardsCallable() {
    throw new UnsupportedOperationException("Not implemented: exportNativeDashboardsCallable()");
  }

  public UnaryCallable<ImportNativeDashboardsRequest, ImportNativeDashboardsResponse>
      importNativeDashboardsCallable() {
    throw new UnsupportedOperationException("Not implemented: importNativeDashboardsCallable()");
  }

  @Override
  public abstract void close();
}
