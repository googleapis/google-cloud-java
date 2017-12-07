/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

import static com.google.common.truth.Truth.assertThat;

import java.util.HashMap;
import java.util.Map;

import com.google.cloud.TransportOptions;

import io.grpc.ManagedChannel;
import io.grpc.netty.NettyChannelBuilder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

/** Unit tests for {@link com.google.cloud.spanner.SpannerOptions}. */
@RunWith(JUnit4.class)
public class SpannerOptionsTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  private static class TestChannelFactory implements SpannerOptions.RpcChannelFactory {
    @Override
    public ManagedChannel newChannel(String host, int port) {
      // Disable SSL to avoid a dependency on ALPN/NPN.
      return NettyChannelBuilder.forAddress(host, port).usePlaintext(true).build();
    }
  }

  @Test
  public void defaultBuilder() {
    // We need to set the project id since in test environment we cannot obtain a default project
    // id.
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setRpcChannelFactory(new TestChannelFactory())
            .build();
    assertThat(options.getHost()).isEqualTo("https://spanner.googleapis.com");
    assertThat(options.getPrefetchChunks()).isEqualTo(4);
    assertThat(options.getSessionLabels()).isNull();
  }

  @Test
  public void builder() {
    String host = "http://localhost:8000/";
    String projectId = "test-project";
    Map<String, String> labels = new HashMap<>();
    labels.put("env", "dev");
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setRpcChannelFactory(new TestChannelFactory())
            .setHost(host)
            .setProjectId(projectId)
            .setPrefetchChunks(2)
            .setSessionLabels(labels)
            .build();
    assertThat(options.getHost()).isEqualTo(host);
    assertThat(options.getProjectId()).isEqualTo(projectId);
    assertThat(options.getPrefetchChunks()).isEqualTo(2);
    assertThat(options.getSessionLabels()).containsExactlyEntriesIn(labels);
  }

  @Test
  public void testInvalidTransport() {
    thrown.expect(IllegalArgumentException.class);
    SpannerOptions.newBuilder().setTransportOptions(Mockito.mock(TransportOptions.class));
  }
  
  @Test
  public void testInvalidSessionLabels() {
    thrown.expect(NullPointerException.class);
    Map<String, String> labels = new HashMap<>();
    labels.put("env", null);
    SpannerOptions.newBuilder().setSessionLabels(labels);
  }
  
  @Test
  public void testNullSessionLabels() {
    thrown.expect(NullPointerException.class);
    SpannerOptions.newBuilder().setSessionLabels(null);
  }
}
