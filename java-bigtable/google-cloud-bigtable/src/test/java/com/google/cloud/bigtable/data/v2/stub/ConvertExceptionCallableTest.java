/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.InternalException;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ConvertExceptionCallableTest {

  @Test
  public void rstStreamExceptionConvertedToRetryableTest() {
    ApiException originalException =
        new InternalException(
            new StatusRuntimeException(
                Status.INTERNAL.withDescription(
                    "INTERNAL: HTTP/2 error code: INTERNAL_ERROR\nReceived Rst Stream")),
            GrpcStatusCode.of(Status.Code.INTERNAL),
            false);
    assertFalse(originalException.isRetryable());
    SettableExceptionCallable<String, String> settableExceptionCallable =
        new SettableExceptionCallable<>(originalException);
    ConvertExceptionCallable<String, String> convertStreamExceptionCallable =
        new ConvertExceptionCallable<>(settableExceptionCallable);

    Throwable actualError = null;
    try {
      convertStreamExceptionCallable.all().call("fake-request");
    } catch (Throwable t) {
      actualError = t;
    }
    assert actualError instanceof InternalException;
    InternalException actualException = (InternalException) actualError;
    assertTrue(actualException.isRetryable());
  }

  private static final class SettableExceptionCallable<RequestT, ResponseT>
      extends ServerStreamingCallable<RequestT, ResponseT> {
    private final Throwable throwable;

    public SettableExceptionCallable(Throwable throwable) {
      this.throwable = throwable;
    }

    @Override
    public void call(
        RequestT request, ResponseObserver<ResponseT> responseObserver, ApiCallContext context) {
      responseObserver.onError(throwable);
    }
  }
}
