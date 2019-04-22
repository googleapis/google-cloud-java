/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.cloud.spanner.TransactionRunnerImpl.TransactionContextImpl;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.protobuf.ByteString;
import com.google.rpc.Code;
import com.google.rpc.Status;
import com.google.spanner.v1.ExecuteBatchDmlRequest;
import com.google.spanner.v1.ExecuteBatchDmlResponse;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

@RunWith(JUnit4.class)
public class TransactionContextImplTest {

  @Test(expected = AbortedException.class)
  public void batchDmlAborted() {
    batchDml(Code.ABORTED_VALUE);
  }

  @Test(expected = SpannerBatchUpdateException.class)
  public void batchDmlException() {
    batchDml(Code.FAILED_PRECONDITION_VALUE);
  }

  @SuppressWarnings("unchecked")
  private void batchDml(int status) {
    SessionImpl session = mock(SessionImpl.class);
    when(session.getName()).thenReturn("test");
    SpannerRpc rpc = mock(SpannerRpc.class);
    ExecuteBatchDmlResponse response =
        ExecuteBatchDmlResponse.newBuilder()
            .setStatus(Status.newBuilder().setCode(status).build())
            .build();
    Statement statement = Statement.of("UPDATE FOO SET BAR=1");

    when(rpc.executeBatchDml(Mockito.any(ExecuteBatchDmlRequest.class), Mockito.anyMap()))
        .thenReturn(response);
    try (TransactionContextImpl impl =
        new TransactionContextImpl(session, ByteString.copyFromUtf8("test"), rpc, 10)) {
      impl.batchUpdate(Arrays.asList(statement));
    }
  }
}
