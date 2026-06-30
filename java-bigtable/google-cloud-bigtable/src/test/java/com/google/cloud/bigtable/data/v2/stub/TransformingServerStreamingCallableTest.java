/*
 * Copyright 2024 Google LLC
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

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.bigtable.gaxx.testing.MockStreamingApi.MockResponseObserver;
import com.google.cloud.bigtable.gaxx.testing.MockStreamingApi.MockServerStreamingCall;
import com.google.cloud.bigtable.gaxx.testing.MockStreamingApi.MockServerStreamingCallable;
import com.google.common.base.Functions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TransformingServerStreamingCallableTest {
  @Test
  public void testReqTransform() {
    MockServerStreamingCallable<String, String> inner = new MockServerStreamingCallable<>();
    TransformingServerStreamingCallable<Integer, String, String, String> xform =
        new TransformingServerStreamingCallable<>(inner, Object::toString, Functions.identity());

    MockResponseObserver<String> responseObserver = new MockResponseObserver<>(true);
    xform.call(37, responseObserver);

    MockServerStreamingCall<String, String> call = inner.popLastCall();
    assertThat(call.getRequest()).isEqualTo("37");
  }

  @Test
  public void testRespTransform() {
    MockServerStreamingCallable<String, String> inner = new MockServerStreamingCallable<>();
    TransformingServerStreamingCallable<String, Integer, String, String> xform =
        new TransformingServerStreamingCallable<>(inner, Functions.identity(), Integer::parseInt);

    MockResponseObserver<Integer> outerObserver = new MockResponseObserver<>(true);
    xform.call("req", outerObserver);

    MockServerStreamingCall<String, String> call = inner.popLastCall();
    call.getController().getObserver().onResponse("37");

    assertThat(outerObserver.popNextResponse()).isEqualTo(37);
  }

  @Test
  public void testError() {
    MockServerStreamingCallable<String, String> inner = new MockServerStreamingCallable<>();
    TransformingServerStreamingCallable<String, String, String, String> xform =
        new TransformingServerStreamingCallable<>(
            inner, Functions.identity(), Functions.identity());

    MockResponseObserver<String> outerObserver = new MockResponseObserver<>(true);
    xform.call("req", outerObserver);

    MockServerStreamingCall<String, String> call = inner.popLastCall();
    RuntimeException e = new RuntimeException("fake error");
    call.getController().getObserver().onError(e);

    assertThat(outerObserver.getFinalError()).isEqualTo(e);
  }
}
