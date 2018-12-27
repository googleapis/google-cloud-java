/*
 * Copyright 2019 Google LLC
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

package com.google.grpc.gcp;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.common.collect.ImmutableList;
import com.google.spanner.v1.CreateSessionRequest;
import com.google.spanner.v1.DeleteSessionRequest;
import com.google.spanner.v1.Session;
import com.google.spanner.v1.SpannerGrpc;
import com.google.spanner.v1.SpannerGrpc.SpannerBlockingStub;
import io.grpc.ManagedChannelBuilder;
import io.grpc.auth.MoreCallCredentials;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Integration tests for GcpManagedChannel with Spanner. */
@RunWith(JUnit4.class)
public final class SpannerIntegrationTest {
  private static final String OAUTH_SCOPE = "https://www.googleapis.com/auth/cloud-platform";
  private static final String SPANNER_TARGET = "spanner.googleapis.com";
  private static final String DATABASE =
      "projects/cloudprober-test/instances/test-instance/databases/test-db";

  private static final int MAX_CHANNEL = 10;
  private static final int MAX_STREAM = 100;

  private GcpManagedChannel gcpChannel;
  private ManagedChannelBuilder builder;
  private SpannerBlockingStub stub;

  private SpannerBlockingStub getSpannerStub() throws InterruptedException {
    GoogleCredentials creds;
    try {
      creds = GoogleCredentials.getApplicationDefault();
    } catch (Exception e) {
      return null;
    }
    ImmutableList<String> requiredScopes = ImmutableList.of(OAUTH_SCOPE);
    creds = creds.createScoped(requiredScopes);

    builder = ManagedChannelBuilder.forAddress(SPANNER_TARGET, 443);
    gcpChannel = new GcpManagedChannel(builder);
    SpannerBlockingStub stub =
        SpannerGrpc.newBlockingStub(gcpChannel)
            .withCallCredentials(MoreCallCredentials.from(creds));
    return stub;
  }

  private static void deleteSession(SpannerGrpc.SpannerBlockingStub stub, Session session) {
    if (session != null) {
      stub.deleteSession(DeleteSessionRequest.newBuilder().setName(session.getName()).build());
    }
  }

  @Before
  public void setup() throws InterruptedException {
    stub = getSpannerStub();
  }

  @After
  public void shutdownChannel() {
    gcpChannel.shutdownNow();
  }

  @Test
  public void testSpannerCreateSessionReuse() throws Exception {
    for (int i = 0; i < MAX_CHANNEL * 2; i++) {
      Session session =
          stub.createSession(CreateSessionRequest.newBuilder().setDatabase(DATABASE).build());
      assertThat(session).isNotEqualTo(null);
      assertEquals(1, gcpChannel.channelRefs.size());
      deleteSession(stub, session);
    }
  }
}
