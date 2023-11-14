/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigquery.storage.v1;

import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.protobuf.AbstractMessage;
import io.grpc.ServerServiceDefinition;
import io.grpc.Status;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Supplier;
import org.threeten.bp.Duration;

/**
 * A fake implementation of {@link MockGrpcService}, that can be used to test clients of a
 * StreamWriter. It forwards calls to the real implementation (@link FakeBigQueryWriteImpl}.
 */
public class FakeBigQueryWrite implements MockGrpcService {
  private final FakeBigQueryWriteImpl serviceImpl;

  public FakeBigQueryWrite() {
    serviceImpl = new FakeBigQueryWriteImpl();
  }

  @Override
  public List<AbstractMessage> getRequests() {
    return new LinkedList<AbstractMessage>(serviceImpl.getCapturedRequests());
  }

  public void waitForResponseScheduled() throws InterruptedException {
    serviceImpl.waitForResponseScheduled();
  }

  public List<AppendRowsRequest> getAppendRequests() {
    return serviceImpl.getCapturedRequests();
  }

  public List<GetWriteStreamRequest> getWriteStreamRequests() {
    return serviceImpl.getCapturedWriteRequests();
  }

  @Override
  public void addResponse(AbstractMessage response) {
    if (response instanceof AppendRowsResponse) {
      serviceImpl.addResponse((AppendRowsResponse) response);
    } else if (response instanceof WriteStream) {
      serviceImpl.addWriteStreamResponse((WriteStream) response);
    } else if (response instanceof FlushRowsResponse) {
      serviceImpl.addFlushRowsResponse((FlushRowsResponse) response);
    } else {
      throw new IllegalStateException("Unsupported service");
    }
  }

  /**
   * Add a response supplier to end of list. This supplier can be used to simulate retries or other
   * forms of behavior.
   */
  public void addResponse(Supplier<FakeBigQueryWriteImpl.Response> response) {
    serviceImpl.addResponse(response);
  }

  @Override
  public void addException(Exception exception) {
    serviceImpl.addConnectionError(exception);
  }

  public void addStatusException(com.google.rpc.Status status) {
    serviceImpl.addException(status);
  }

  @Override
  public ServerServiceDefinition getServiceDefinition() {
    return serviceImpl.bindService();
  }

  @Override
  public void reset() {
    serviceImpl.reset();
  }

  public void setResponseSleep(Duration sleep) {
    serviceImpl.setResponseSleep(sleep);
  }

  public void setCloseEveryNAppends(long closeAfter) {
    serviceImpl.setCloseEveryNAppends(closeAfter);
  }

  public void setTimesToClose(long numberTimesToClose) {
    serviceImpl.setTimesToClose(numberTimesToClose);
  }

  public void setCloseForeverAfter(long closeForeverAfter) {
    serviceImpl.setCloseForeverAfter(closeForeverAfter);
  }

  public long getConnectionCount() {
    return serviceImpl.getConnectionCount();
  }

  public void setExecutor(ScheduledExecutorService executor) {
    serviceImpl.setExecutor(executor);
  }

  public void setFailedStatus(Status failedStatus) {
    serviceImpl.setFailedStatus(failedStatus);
  }

  public void setReturnErrorDuringExclusiveStreamRetry(boolean retryOnError) {
    serviceImpl.setReturnErrorDuringExclusiveStreamRetry(retryOnError);
  }

  public void setVerifyOffset(boolean verifyOffset) {
    serviceImpl.setVerifyOffset(verifyOffset);
  }

  public ArrayList<Instant> getLatestRequestReceivedInstants() {
    return serviceImpl.getLatestRequestReceivedInstants();
  }
}
