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

import com.google.auth.oauth2.GoogleCredentials;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.grpc.gcp.GcpManagedChannelBuilder;
import com.google.protobuf.Empty;
import com.google.spanner.v1.CreateSessionRequest;
import com.google.spanner.v1.DeleteSessionRequest;
import com.google.spanner.v1.ListSessionsRequest;
import com.google.spanner.v1.ListSessionsResponse;
import com.google.spanner.v1.Session;
import com.google.spanner.v1.SpannerGrpc;
import com.google.spanner.v1.SpannerGrpc.SpannerFutureStub;
import com.google.spanner.v1.SpannerGrpc.SpannerStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.auth.MoreCallCredentials;
import io.grpc.stub.StreamObserver;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/** Integration tests for GcpManagedChannel with Spanner. */
public final class SpannerLoadTest {
  private static final String OAUTH_SCOPE = "https://www.googleapis.com/auth/cloud-platform";
  private static final String SPANNER_TARGET = "spanner.googleapis.com";
  private static final String DATABASE =
      "projects/cloudprober-test/instances/test-instance/databases/test-db";
  private static final String API_FILE = "spannertest.json";

  private static final int MAX_CHANNEL = 10;
  private static final int MAX_STREAM = 10;

  private static final Logger logger = Logger.getLogger(SpannerLoadTest.class.getName());

  private static final ManagedChannelBuilder builder =
      ManagedChannelBuilder.forAddress(SPANNER_TARGET, 443);

  private static GoogleCredentials getCreds() {
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

  /** Helper functions for Stub(async calls). */
  private static SpannerStub getSpannerStub(ManagedChannel channel) {
    GoogleCredentials creds = getCreds();
    SpannerStub stub =
        SpannerGrpc.newStub(channel).withCallCredentials(MoreCallCredentials.from(creds));
    return stub;
  }

  private static List<String> createAsyncSessions(SpannerStub stub) throws InterruptedException {
    List<AsyncResponseObserver<Session>> resps = new ArrayList<>();
    List<String> respNames = new ArrayList<>();

    CreateSessionRequest req = CreateSessionRequest.newBuilder().setDatabase(DATABASE).build();
    for (int i = 0; i < MAX_CHANNEL * MAX_STREAM / 2; i++) {
      AsyncResponseObserver<Session> resp = new AsyncResponseObserver<Session>();
      stub.createSession(req, resp);
      resps.add(resp);
    }
    for (AsyncResponseObserver<Session> resp : resps) {
      respNames.add(resp.get().getName());
    }
    return respNames;
  }

  private static void deleteAsyncSessions(SpannerStub stub, List<String> respNames)
      throws InterruptedException {
    for (String respName : respNames) {
      AsyncResponseObserver<Empty> resp = new AsyncResponseObserver<>();
      stub.deleteSession(DeleteSessionRequest.newBuilder().setName(respName).build(), resp);
      resp.get();
    }
  }

  /** Helper Functions for FutureStub. */
  private static SpannerFutureStub getSpannerFutureStub(ManagedChannel channel) {
    GoogleCredentials creds = getCreds();
    SpannerFutureStub stub =
        SpannerGrpc.newFutureStub(channel).withCallCredentials(MoreCallCredentials.from(creds));
    return stub;
  }

  private static List<String> createFutureSessions(SpannerFutureStub stub)
      throws ExecutionException, InterruptedException {
    List<ListenableFuture<Session>> futures = new ArrayList<>();
    List<String> futureNames = new ArrayList<>();

    // Check CreateSession with multiple channels and streams,
    CreateSessionRequest req = CreateSessionRequest.newBuilder().setDatabase(DATABASE).build();
    for (int i = 0; i < MAX_CHANNEL * MAX_STREAM / 2; i++) {
      ListenableFuture<Session> future = stub.createSession(req);
      futures.add(future);
    }
    for (ListenableFuture<Session> future : futures) {
      futureNames.add(future.get().getName());
    }

    return futureNames;
  }

  private static void deleteFutureSessions(SpannerFutureStub stub, List<String> futureNames)
      throws ExecutionException, InterruptedException {
    for (String futureName : futureNames) {
      ListenableFuture<Empty> future =
          stub.deleteSession(DeleteSessionRequest.newBuilder().setName(futureName).build());
      future.get();
    }
  }

  public static void testListSessionsFuture() throws InterruptedException, ExecutionException {
    logger.info("Start testing ListSessions Future..");
    File configFile =
        new File(SpannerLoadTest.class.getClassLoader().getResource(API_FILE).getFile());
    ManagedChannel channel =
        GcpManagedChannelBuilder.forDelegateBuilder(builder)
            .withApiConfigJsonFile(configFile)
            .build();
    SpannerFutureStub stub = getSpannerFutureStub(channel);
    List<String> futureNames = createFutureSessions(stub);
    ListSessionsResponse responseList =
        stub.listSessions(ListSessionsRequest.newBuilder().setDatabase(DATABASE).build()).get();
    Set<String> trueNames = new HashSet<>();
    for (Session s : responseList.getSessionsList()) {
      trueNames.add(s.getName());
    }
    for (String name : futureNames) {
      if (!trueNames.contains(name)) {
        logger.warning(String.format("Listed Sessions doesn't contain session %s", name));
      }
    }
    deleteFutureSessions(stub, futureNames);
  }

  public static void testListSessionsAsync() throws InterruptedException {
    logger.info("Start testing ListSessions StreamObserver..");
    File configFile =
        new File(SpannerLoadTest.class.getClassLoader().getResource(API_FILE).getFile());
    ManagedChannel channel =
        GcpManagedChannelBuilder.forDelegateBuilder(builder)
            .withApiConfigJsonFile(configFile)
            .build();
    SpannerStub stub = getSpannerStub(channel);
    List<String> respNames = createAsyncSessions(stub);
    AsyncResponseObserver<ListSessionsResponse> respList = new AsyncResponseObserver<>();
    stub.listSessions(ListSessionsRequest.newBuilder().setDatabase(DATABASE).build(), respList);
    ListSessionsResponse responseList = respList.get();
    Set<String> trueNames = new HashSet<>();
    for (Session s : responseList.getSessionsList()) {
      trueNames.add(s.getName());
    }
    for (String name : respNames) {
      if (!trueNames.contains(name)) {
        logger.warning(String.format("Listed Sessions doesn't contain session %s", name));
      }
    }
    deleteAsyncSessions(stub, respNames);
  }

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    testListSessionsFuture();
    testListSessionsAsync();
  }

  private static class AsyncResponseObserver<RespT> implements StreamObserver<RespT> {
    private final CountDownLatch finishLatch = new CountDownLatch(1);
    private RespT response = null;

    private AsyncResponseObserver() {}

    public RespT get() throws InterruptedException {
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
