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

package com.google.cloud.channel.v1.stub;

import static com.google.cloud.channel.v1.CloudChannelReportsServiceClient.FetchReportResultsPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelReportsServiceClient.ListReportsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.channel.v1.FetchReportResultsRequest;
import com.google.cloud.channel.v1.FetchReportResultsResponse;
import com.google.cloud.channel.v1.ListReportsRequest;
import com.google.cloud.channel.v1.ListReportsResponse;
import com.google.cloud.channel.v1.OperationMetadata;
import com.google.cloud.channel.v1.RunReportJobRequest;
import com.google.cloud.channel.v1.RunReportJobResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the CloudChannelReportsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class CloudChannelReportsServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public OperationCallable<RunReportJobRequest, RunReportJobResponse, OperationMetadata>
      runReportJobOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: runReportJobOperationCallable()");
  }

  public UnaryCallable<RunReportJobRequest, Operation> runReportJobCallable() {
    throw new UnsupportedOperationException("Not implemented: runReportJobCallable()");
  }

  public UnaryCallable<FetchReportResultsRequest, FetchReportResultsPagedResponse>
      fetchReportResultsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchReportResultsPagedCallable()");
  }

  public UnaryCallable<FetchReportResultsRequest, FetchReportResultsResponse>
      fetchReportResultsCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchReportResultsCallable()");
  }

  public UnaryCallable<ListReportsRequest, ListReportsPagedResponse> listReportsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listReportsPagedCallable()");
  }

  public UnaryCallable<ListReportsRequest, ListReportsResponse> listReportsCallable() {
    throw new UnsupportedOperationException("Not implemented: listReportsCallable()");
  }

  @Override
  public abstract void close();
}
