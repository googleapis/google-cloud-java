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

package com.google.ads.admanager.v1.stub;

import com.google.ads.admanager.v1.ExportSavedReportMetadata;
import com.google.ads.admanager.v1.ExportSavedReportRequest;
import com.google.ads.admanager.v1.ExportSavedReportResponse;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.stub.OperationsStub;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.Operation;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ReportService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ReportServiceStub implements BackgroundResource {

  public OperationsStub getHttpJsonOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getHttpJsonOperationsStub()");
  }

  public OperationCallable<
          ExportSavedReportRequest, ExportSavedReportResponse, ExportSavedReportMetadata>
      exportSavedReportOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: exportSavedReportOperationCallable()");
  }

  public UnaryCallable<ExportSavedReportRequest, Operation> exportSavedReportCallable() {
    throw new UnsupportedOperationException("Not implemented: exportSavedReportCallable()");
  }

  @Override
  public abstract void close();
}
