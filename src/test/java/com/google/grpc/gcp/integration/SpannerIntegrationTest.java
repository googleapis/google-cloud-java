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
import com.google.common.util.concurrent.ListenableFuture;
import com.google.protobuf.Empty;
import com.google.spanner.v1.CreateSessionRequest;
import com.google.spanner.v1.DeleteSessionRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.GetSessionRequest;
import com.google.spanner.v1.ListSessionsRequest;
import com.google.spanner.v1.ListSessionsResponse;
import com.google.spanner.v1.PartialResultSet;
import com.google.spanner.v1.ResultSet;
import com.google.spanner.v1.Session;
import com.google.spanner.v1.SpannerGrpc;
import com.google.spanner.v1.SpannerGrpc.SpannerBlockingStub;
import com.google.spanner.v1.SpannerGrpc.SpannerFutureStub;
import com.google.spanner.v1.SpannerGrpc.SpannerStub;
import io.grpc.ManagedChannelBuilder;
import io.grpc.auth.MoreCallCredentials;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
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
  private static final String USERNAME = "test_username";
  private static final String DATABASE =
      "projects/cloudprober-test/instances/test-instance/databases/test-db";
  private static final String API_FILE = "src/test/resources/apiconfigtests/apiconfig.json";

  private static final int MAX_CHANNEL = 5;
  private static final int MAX_STREAM = 2;

  private static final ManagedChannelBuilder builder =
      ManagedChannelBuilder.forAddress(SPANNER_TARGET, 443);
  private GcpManagedChannel gcpChannel;

  private GoogleCredentials getCreds() {
    GoogleCredentials creds;
    try {
      creds = GoogleCredentials.getApplicationDefault();
    } catch (Exception e) {
      return null;
    }
    ImmutableList<String> requiredScopes = ImmutableList.of(OAUTH_SCOPE);
    creds = creds.createScoped(requiredScopes);
    return creds;
  }

  /** Helper functions for BlockingStub. */
  private SpannerBlockingStub getSpannerBlockingStub() throws InterruptedException {
    GoogleCredentials creds = getCreds();
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

  /** Helper functions for Stub(async calls). */
  private SpannerStub getSpannerStub() throws InterruptedException {
    GoogleCredentials creds = getCreds();
    SpannerStub stub =
        SpannerGrpc.newStub(gcpChannel).withCallCredentials(MoreCallCredentials.from(creds));
    return stub;
  }

  private List<String> createAsyncSessions(SpannerStub stub) throws Exception {
    List<AsyncResponseObserver<Session>> resps = new ArrayList<>();
    List<String> respNames = new ArrayList<>();

    // Check CreateSession with multiple channels and streams,
    CreateSessionRequest req = CreateSessionRequest.newBuilder().setDatabase(DATABASE).build();
    for (int i = 0; i < MAX_CHANNEL * MAX_STREAM; i++) {
      AsyncResponseObserver<Session> resp = new AsyncResponseObserver<Session>();
      stub.createSession(req, resp);
      resps.add(resp);
    }
    checkChannelRefs(MAX_CHANNEL, MAX_STREAM, 0);
    for (AsyncResponseObserver<Session> resp : resps) {
      respNames.add(resp.get().getName());
    }
    // Since createSession will bind the key, check the number of keys bound with channels.
    assertEquals(MAX_CHANNEL * MAX_STREAM, gcpChannel.affinityKeyToChannelRef.size());
    checkChannelRefs(MAX_CHANNEL, 0, MAX_STREAM);
    return respNames;
  }

  private void deleteAsyncSessions(SpannerStub stub, List<String> respNames) throws Exception {
    for (String respName : respNames) {
      AsyncResponseObserver<Empty> resp = new AsyncResponseObserver<>();
      stub.deleteSession(DeleteSessionRequest.newBuilder().setName(respName).build(), resp);
      resp.get();
    }
    checkChannelRefs(MAX_CHANNEL, 0, 0);
    assertEquals(0, gcpChannel.affinityKeyToChannelRef.size());
  }

  /** Helper Functions for FutureStub. */
  private SpannerFutureStub getSpannerFutureStub() throws InterruptedException {
    GoogleCredentials creds = getCreds();
    SpannerFutureStub stub =
        SpannerGrpc.newFutureStub(gcpChannel).withCallCredentials(MoreCallCredentials.from(creds));
    return stub;
  }

  private List<String> createFutureSessions(SpannerFutureStub stub) throws Exception {
    List<ListenableFuture<Session>> futures = new ArrayList<>();
    List<String> futureNames = new ArrayList<>();

    // Check CreateSession with multiple channels and streams,
    CreateSessionRequest req = CreateSessionRequest.newBuilder().setDatabase(DATABASE).build();
    for (int i = 0; i < MAX_CHANNEL * MAX_STREAM; i++) {
      ListenableFuture<Session> future = stub.createSession(req);
      futures.add(future);
    }
    checkChannelRefs(MAX_CHANNEL, MAX_STREAM, 0);
    for (ListenableFuture<Session> future : futures) {
      futureNames.add(future.get().getName());
    }
    // Since createSession will bind the key, check the number of keys bound with channels.
    assertEquals(MAX_CHANNEL * MAX_STREAM, gcpChannel.affinityKeyToChannelRef.size());
    checkChannelRefs(MAX_CHANNEL, 0, MAX_STREAM);
    return futureNames;
  }

  private void deleteFutureSessions(SpannerFutureStub stub, List<String> futureNames)
      throws Exception {
    for (String futureName : futureNames) {
      ListenableFuture<Empty> future =
          stub.deleteSession(DeleteSessionRequest.newBuilder().setName(futureName).build());
      future.get();
    }
    checkChannelRefs(MAX_CHANNEL, 0, 0);
    assertEquals(0, gcpChannel.affinityKeyToChannelRef.size());
  }

  /** A wrapper checking the status of each channelRef in the gcpChannel. */
  private void checkChannelRefs(int channels, int streams, int affinities) {
    assertEquals(channels, gcpChannel.channelRefs.size());
    for (int i = 0; i < channels; i++) {
      assertEquals(streams, gcpChannel.channelRefs.get(i).getActiveStreamsCount());
      assertEquals(affinities, gcpChannel.channelRefs.get(i).getAffinityCount());
    }
  }

  @Before
  public void setup() throws InterruptedException {
    gcpChannel = new GcpManagedChannel(builder, API_FILE);
  }

  @After
  public void shutdownChannel() {
    gcpChannel.shutdownNow();
  }

  @Test
  public void testCreateAndGetSessionBlocking() throws Exception {
    // System.out.println("blocking");
    SpannerBlockingStub stub = getSpannerBlockingStub();
    CreateSessionRequest req = CreateSessionRequest.newBuilder().setDatabase(DATABASE).build();
    for (int i = 0; i < MAX_CHANNEL * 2; i++) {
      Session session = stub.createSession(req);
      assertThat(session).isNotEqualTo(null);
      checkChannelRefs(1, 0, 1);

      Session responseGet =
          stub.getSession(GetSessionRequest.newBuilder().setName(session.getName()).build());
      assertEquals(responseGet.getName(), session.getName());
      checkChannelRefs(1, 0, 1);

      deleteSession(stub, session);
      checkChannelRefs(1, 0, 0);
    }
  }

  @Test
  public void testListAndDeleteSessionsBlocking() throws Exception {
    SpannerBlockingStub stub = getSpannerBlockingStub();
    // Delete all the sessions and check all sessions are deleted.
    ListSessionsResponse responseList =
        stub.listSessions(ListSessionsRequest.newBuilder().setDatabase(DATABASE).build());
    for (Session s : responseList.getSessionsList()) {
      deleteSession(stub, s);
    }
    responseList =
        stub.listSessions(ListSessionsRequest.newBuilder().setDatabase(DATABASE).build());
    assertEquals(0, responseList.getSessionsList().size());
  }

  @Test
  public void testListSessionsFuture() throws Exception {
    SpannerFutureStub stub = getSpannerFutureStub();
    List<String> futureNames = createFutureSessions(stub);
    ListSessionsResponse responseList =
        stub.listSessions(ListSessionsRequest.newBuilder().setDatabase(DATABASE).build()).get();
    Set<String> trueNames = new HashSet<>();
    for (Session s : responseList.getSessionsList()) {
      trueNames.add(s.getName());
    }
    for (String name : futureNames) {
      assertThat(trueNames).contains(name);
    }
    deleteFutureSessions(stub, futureNames);
  }

  @Test
  public void testCreateAndListSessionsAsync() throws Exception {
    SpannerStub stub = getSpannerStub();
    List<String> respNames = createAsyncSessions(stub);
    AsyncResponseObserver<ListSessionsResponse> respList = new AsyncResponseObserver<>();
    stub.listSessions(ListSessionsRequest.newBuilder().setDatabase(DATABASE).build(), respList);
    ListSessionsResponse responseList = respList.get();
    Set<String> trueNames = new HashSet<>();
    for (Session s : responseList.getSessionsList()) {
      trueNames.add(s.getName());
    }
    for (String name : respNames) {
      assertThat(trueNames).contains(name);
    }
    deleteAsyncSessions(stub, respNames);
  }

  /** Since Future and Blocking share the same mechanism, test Future only. */
  @Test
  public void testExecuteSqlFuture() throws Exception {
    SpannerFutureStub stub = getSpannerFutureStub();
    List<String> futureNames = createFutureSessions(stub);
    for (String futureName : futureNames) {
      ResultSet response =
          stub.executeSql(
                  ExecuteSqlRequest.newBuilder()
                      .setSession(futureName)
                      .setSql("select * FROM jenny")
                      .build())
              .get();
      assertEquals(1, response.getRowsCount());
      assertEquals(USERNAME, response.getRows(0).getValuesList().get(0).getStringValue());
    }
    deleteFutureSessions(stub, futureNames);
  }

  @Test
  public void testExecuteSqlAsync() throws Exception {
    SpannerStub stub = getSpannerStub();
    List<String> respNames = createAsyncSessions(stub);
    for (String respName : respNames) {
      AsyncResponseObserver<PartialResultSet> resp = new AsyncResponseObserver<>();
      stub.executeStreamingSql(
          ExecuteSqlRequest.newBuilder().setSession(respName).setSql("select * FROM jenny").build(),
          resp);
      assertEquals(USERNAME, resp.get().getValues(0).getStringValue());
    }
    deleteAsyncSessions(stub, respNames);
  }

  private static class AsyncResponseObserver<RespT> implements StreamObserver<RespT> {
    private final CountDownLatch finishLatch = new CountDownLatch(1);
    private RespT response;

    private AsyncResponseObserver() {
      response = null;
    }

    public RespT get() throws InterruptedException, ExecutionException, TimeoutException {
      finishLatch.await(1, TimeUnit.MINUTES);
      return response;
    }

    @Override
    public void onNext(RespT response) {
      this.response = response;
    }

    @Override
    public void onError(Throwable t) {
      finishLatch.countDown();
    }

    @Override
    public void onCompleted() {
      finishLatch.countDown();
    }
  }
}
