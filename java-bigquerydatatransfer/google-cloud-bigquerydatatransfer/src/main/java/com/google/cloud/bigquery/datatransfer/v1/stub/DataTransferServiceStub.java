/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.bigquery.datatransfer.v1.stub;

import static com.google.cloud.bigquery.datatransfer.v1.DataTransferServiceClient.ListDataSourcesPagedResponse;
import static com.google.cloud.bigquery.datatransfer.v1.DataTransferServiceClient.ListTransferConfigsPagedResponse;
import static com.google.cloud.bigquery.datatransfer.v1.DataTransferServiceClient.ListTransferLogsPagedResponse;
import static com.google.cloud.bigquery.datatransfer.v1.DataTransferServiceClient.ListTransferRunsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsRequest;
import com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsResponse;
import com.google.cloud.bigquery.datatransfer.v1.CreateTransferConfigRequest;
import com.google.cloud.bigquery.datatransfer.v1.DataSource;
import com.google.cloud.bigquery.datatransfer.v1.DeleteTransferConfigRequest;
import com.google.cloud.bigquery.datatransfer.v1.DeleteTransferRunRequest;
import com.google.cloud.bigquery.datatransfer.v1.GetDataSourceRequest;
import com.google.cloud.bigquery.datatransfer.v1.GetTransferConfigRequest;
import com.google.cloud.bigquery.datatransfer.v1.GetTransferRunRequest;
import com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesRequest;
import com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesResponse;
import com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsRequest;
import com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsResponse;
import com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsRequest;
import com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsResponse;
import com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsRequest;
import com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsResponse;
import com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsRequest;
import com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsResponse;
import com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsRequest;
import com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsResponse;
import com.google.cloud.bigquery.datatransfer.v1.TransferConfig;
import com.google.cloud.bigquery.datatransfer.v1.TransferRun;
import com.google.cloud.bigquery.datatransfer.v1.UpdateTransferConfigRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the DataTransferService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class DataTransferServiceStub implements BackgroundResource {

  public UnaryCallable<GetDataSourceRequest, DataSource> getDataSourceCallable() {
    throw new UnsupportedOperationException("Not implemented: getDataSourceCallable()");
  }

  public UnaryCallable<ListDataSourcesRequest, ListDataSourcesPagedResponse>
      listDataSourcesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataSourcesPagedCallable()");
  }

  public UnaryCallable<ListDataSourcesRequest, ListDataSourcesResponse> listDataSourcesCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataSourcesCallable()");
  }

  public UnaryCallable<CreateTransferConfigRequest, TransferConfig> createTransferConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: createTransferConfigCallable()");
  }

  public UnaryCallable<UpdateTransferConfigRequest, TransferConfig> updateTransferConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: updateTransferConfigCallable()");
  }

  public UnaryCallable<DeleteTransferConfigRequest, Empty> deleteTransferConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTransferConfigCallable()");
  }

  public UnaryCallable<GetTransferConfigRequest, TransferConfig> getTransferConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: getTransferConfigCallable()");
  }

  public UnaryCallable<ListTransferConfigsRequest, ListTransferConfigsPagedResponse>
      listTransferConfigsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listTransferConfigsPagedCallable()");
  }

  public UnaryCallable<ListTransferConfigsRequest, ListTransferConfigsResponse>
      listTransferConfigsCallable() {
    throw new UnsupportedOperationException("Not implemented: listTransferConfigsCallable()");
  }

  public UnaryCallable<ScheduleTransferRunsRequest, ScheduleTransferRunsResponse>
      scheduleTransferRunsCallable() {
    throw new UnsupportedOperationException("Not implemented: scheduleTransferRunsCallable()");
  }

  public UnaryCallable<StartManualTransferRunsRequest, StartManualTransferRunsResponse>
      startManualTransferRunsCallable() {
    throw new UnsupportedOperationException("Not implemented: startManualTransferRunsCallable()");
  }

  public UnaryCallable<GetTransferRunRequest, TransferRun> getTransferRunCallable() {
    throw new UnsupportedOperationException("Not implemented: getTransferRunCallable()");
  }

  public UnaryCallable<DeleteTransferRunRequest, Empty> deleteTransferRunCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTransferRunCallable()");
  }

  public UnaryCallable<ListTransferRunsRequest, ListTransferRunsPagedResponse>
      listTransferRunsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listTransferRunsPagedCallable()");
  }

  public UnaryCallable<ListTransferRunsRequest, ListTransferRunsResponse>
      listTransferRunsCallable() {
    throw new UnsupportedOperationException("Not implemented: listTransferRunsCallable()");
  }

  public UnaryCallable<ListTransferLogsRequest, ListTransferLogsPagedResponse>
      listTransferLogsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listTransferLogsPagedCallable()");
  }

  public UnaryCallable<ListTransferLogsRequest, ListTransferLogsResponse>
      listTransferLogsCallable() {
    throw new UnsupportedOperationException("Not implemented: listTransferLogsCallable()");
  }

  public UnaryCallable<CheckValidCredsRequest, CheckValidCredsResponse> checkValidCredsCallable() {
    throw new UnsupportedOperationException("Not implemented: checkValidCredsCallable()");
  }

  @Override
  public abstract void close();
}
