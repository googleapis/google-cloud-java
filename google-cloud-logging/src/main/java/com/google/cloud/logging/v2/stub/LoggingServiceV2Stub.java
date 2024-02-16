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

package com.google.cloud.logging.v2.stub;

import static com.google.cloud.logging.v2.LoggingClient.ListLogEntriesPagedResponse;
import static com.google.cloud.logging.v2.LoggingClient.ListLogsPagedResponse;
import static com.google.cloud.logging.v2.LoggingClient.ListMonitoredResourceDescriptorsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.logging.v2.DeleteLogRequest;
import com.google.logging.v2.ListLogEntriesRequest;
import com.google.logging.v2.ListLogEntriesResponse;
import com.google.logging.v2.ListLogsRequest;
import com.google.logging.v2.ListLogsResponse;
import com.google.logging.v2.ListMonitoredResourceDescriptorsRequest;
import com.google.logging.v2.ListMonitoredResourceDescriptorsResponse;
import com.google.logging.v2.TailLogEntriesRequest;
import com.google.logging.v2.TailLogEntriesResponse;
import com.google.logging.v2.WriteLogEntriesRequest;
import com.google.logging.v2.WriteLogEntriesResponse;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the LoggingServiceV2 service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class LoggingServiceV2Stub implements BackgroundResource {

  public UnaryCallable<DeleteLogRequest, Empty> deleteLogCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteLogCallable()");
  }

  public UnaryCallable<WriteLogEntriesRequest, WriteLogEntriesResponse> writeLogEntriesCallable() {
    throw new UnsupportedOperationException("Not implemented: writeLogEntriesCallable()");
  }

  public UnaryCallable<ListLogEntriesRequest, ListLogEntriesPagedResponse>
      listLogEntriesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLogEntriesPagedCallable()");
  }

  public UnaryCallable<ListLogEntriesRequest, ListLogEntriesResponse> listLogEntriesCallable() {
    throw new UnsupportedOperationException("Not implemented: listLogEntriesCallable()");
  }

  public UnaryCallable<
          ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsPagedResponse>
      listMonitoredResourceDescriptorsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listMonitoredResourceDescriptorsPagedCallable()");
  }

  public UnaryCallable<
          ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse>
      listMonitoredResourceDescriptorsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listMonitoredResourceDescriptorsCallable()");
  }

  public UnaryCallable<ListLogsRequest, ListLogsPagedResponse> listLogsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLogsPagedCallable()");
  }

  public UnaryCallable<ListLogsRequest, ListLogsResponse> listLogsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLogsCallable()");
  }

  public BidiStreamingCallable<TailLogEntriesRequest, TailLogEntriesResponse>
      tailLogEntriesCallable() {
    throw new UnsupportedOperationException("Not implemented: tailLogEntriesCallable()");
  }

  @Override
  public abstract void close();
}
