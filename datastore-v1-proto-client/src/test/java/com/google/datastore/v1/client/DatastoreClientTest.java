/*
 * Copyright 2015 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.datastore.v1.client;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.datastore.v1.AllocateIdsRequest;
import com.google.datastore.v1.AllocateIdsResponse;
import com.google.datastore.v1.BeginTransactionRequest;
import com.google.datastore.v1.BeginTransactionResponse;
import com.google.datastore.v1.CommitRequest;
import com.google.datastore.v1.CommitResponse;
import com.google.datastore.v1.EntityResult;
import com.google.datastore.v1.LookupRequest;
import com.google.datastore.v1.LookupResponse;
import com.google.datastore.v1.QueryResultBatch;
import com.google.datastore.v1.ReserveIdsRequest;
import com.google.datastore.v1.ReserveIdsResponse;
import com.google.datastore.v1.RollbackRequest;
import com.google.datastore.v1.RollbackResponse;
import com.google.datastore.v1.RunAggregationQueryRequest;
import com.google.datastore.v1.RunAggregationQueryResponse;
import com.google.datastore.v1.RunQueryRequest;
import com.google.datastore.v1.RunQueryResponse;
import com.google.datastore.v1.client.testing.MockCredential;
import com.google.datastore.v1.client.testing.MockDatastoreFactory;
import com.google.protobuf.ByteString;
import com.google.protobuf.Message;
import com.google.rpc.Code;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.SocketTimeoutException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Tests for {@link DatastoreFactory} and {@link Datastore}. */
@RunWith(JUnit4.class)
public class DatastoreClientTest {
  private static final String PROJECT_ID = "project-id";

  private DatastoreFactory factory = new MockDatastoreFactory();
  private DatastoreOptions.Builder options =
      new DatastoreOptions.Builder().projectId(PROJECT_ID).credential(new MockCredential());

  @Test
  public void options_NoProjectIdOrProjectEndpoint() {
    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> factory.create(new DatastoreOptions.Builder().build()));
    assertThat(exception)
        .hasMessageThat()
        .contains("Either project ID or project endpoint must be provided");
    factory.create(options.build());
  }

  @Test
  public void options_ProjectIdAndProjectEndpoint() throws Exception {
    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                new DatastoreOptions.Builder()
                    .projectId(PROJECT_ID)
                    .projectEndpoint(
                        "http://localhost:1234/datastore/v1beta42/projects/project-id"));
    assertThat(exception)
        .hasMessageThat()
        .contains("Cannot set both project endpoint and project ID");
  }

  @Test
  public void options_LocalHostAndProjectEndpoint() throws Exception {
    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                new DatastoreOptions.Builder()
                    .localHost("localhost:8080")
                    .projectEndpoint(
                        "http://localhost:1234/datastore/v1beta42/projects/project-id"));
    assertThat(exception)
        .hasMessageThat()
        .contains("Can set at most one of project endpoint, host, and local host");
  }

  @Test
  public void options_HostAndProjectEndpoint() throws Exception {
    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                new DatastoreOptions.Builder()
                    .host("foo-datastore.googleapis.com")
                    .projectEndpoint(
                        "http://localhost:1234/datastore/v1beta42/projects/project-id"));
    assertThat(exception)
        .hasMessageThat()
        .contains("Can set at most one of project endpoint, host, and local host");
  }

  @Test
  public void options_HostAndLocalHost() throws Exception {
    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                new DatastoreOptions.Builder()
                    .host("foo-datastore.googleapis.com")
                    .localHost("localhost:8080"));
    assertThat(exception)
        .hasMessageThat()
        .contains("Can set at most one of project endpoint, host, and local host");
  }

  @Test
  public void options_InvalidLocalHost() throws Exception {
    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                factory.create(
                    new DatastoreOptions.Builder()
                        .projectId(PROJECT_ID)
                        .localHost("!not a valid url!")
                        .build()));
    assertThat(exception).hasMessageThat().contains("Illegal character");
  }

  @Test
  public void options_SchemeInLocalHost() {
    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> new DatastoreOptions.Builder().localHost("http://localhost:8080"));
    assertThat(exception)
        .hasMessageThat()
        .contains("Local host \"http://localhost:8080\" must not include scheme");
  }

  @Test
  public void options_InvalidHost() {
    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                factory.create(
                    new DatastoreOptions.Builder()
                        .projectId(PROJECT_ID)
                        .host("!not a valid url!")
                        .build()));
    assertThat(exception).hasMessageThat().contains("Illegal character");
  }

  @Test
  public void options_SchemeInHost() {
    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> new DatastoreOptions.Builder().host("http://foo-datastore.googleapis.com"));

    assertThat(exception)
        .hasMessageThat()
        .contains("Host \"http://foo-datastore.googleapis.com\" must not include scheme.");
  }

  @Test
  public void create_NullOptions() throws Exception {
    assertThrows(NullPointerException.class, () -> factory.create(null));
  }

  @Test
  public void create_Host() {
    Datastore datastore =
        factory.create(
            new DatastoreOptions.Builder()
                .projectId(PROJECT_ID)
                .host("foo-datastore.googleapis.com")
                .build());
    assertThat(datastore.remoteRpc.getUrl())
        .isEqualTo("https://foo-datastore.googleapis.com/v1/projects/project-id");
  }

  @Test
  public void create_LocalHost() {
    Datastore datastore =
        factory.create(
            new DatastoreOptions.Builder()
                .projectId(PROJECT_ID)
                .localHost("localhost:8080")
                .build());
    assertThat(datastore.remoteRpc.getUrl())
        .isEqualTo("http://localhost:8080/v1/projects/project-id");
  }

  @Test
  public void create_LocalHostIp() {
    Datastore datastore =
        factory.create(
            new DatastoreOptions.Builder()
                .projectId(PROJECT_ID)
                .localHost("127.0.0.1:8080")
                .build());
    assertThat(datastore.remoteRpc.getUrl())
        .isEqualTo("http://127.0.0.1:8080/v1/projects/project-id");
  }

  @Test
  public void create_DefaultHost() {
    Datastore datastore =
        factory.create(new DatastoreOptions.Builder().projectId(PROJECT_ID).build());
    assertThat(datastore.remoteRpc.getUrl())
        .isEqualTo("https://datastore.googleapis.com/v1/projects/project-id");
  }

  @Test
  public void create_ProjectEndpoint() {
    Datastore datastore =
        factory.create(
            new DatastoreOptions.Builder()
                .projectEndpoint("http://prom-qa/datastore/v1beta42/projects/project-id")
                .build());
    assertThat(datastore.remoteRpc.getUrl())
        .isEqualTo("http://prom-qa/datastore/v1beta42/projects/project-id");
  }

  @Test
  public void create_ProjectEndpointNoScheme() {
    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                factory.create(
                    new DatastoreOptions.Builder()
                        .projectEndpoint("localhost:1234/datastore/v1beta42/projects/project-id")
                        .build()));
    assertThat(exception)
        .hasMessageThat()
        .contains(
            "Project endpoint \"localhost:1234/datastore/v1beta42/projects/project-id\" must"
                + " include scheme.");
  }

  @Test
  public void initializer() throws Exception {
    options.initializer(
        new HttpRequestInitializer() {
          @Override
          public void initialize(HttpRequest request) {
            request.getHeaders().setCookie("magic");
          }
        });
    Datastore datastore = factory.create(options.build());
    MockDatastoreFactory mockClient = (MockDatastoreFactory) factory;
    AllocateIdsRequest request = AllocateIdsRequest.newBuilder().build();
    AllocateIdsResponse response = AllocateIdsResponse.newBuilder().build();
    mockClient.setNextResponse(response);
    assertEquals(response, datastore.allocateIds(request));
    assertEquals("magic", mockClient.getLastCookies().get(0));
  }

  @Test
  public void allocateIds() throws Exception {
    AllocateIdsRequest.Builder request = AllocateIdsRequest.newBuilder();
    AllocateIdsResponse.Builder response = AllocateIdsResponse.newBuilder();
    expectRpc("allocateIds", request.build(), response.build());
  }

  @Test
  public void lookup() throws Exception {
    LookupRequest.Builder request = LookupRequest.newBuilder();
    LookupResponse.Builder response = LookupResponse.newBuilder();
    expectRpc("lookup", request.build(), response.build());
  }

  @Test
  public void beginTransaction() throws Exception {
    BeginTransactionRequest.Builder request = BeginTransactionRequest.newBuilder();
    BeginTransactionResponse.Builder response = BeginTransactionResponse.newBuilder();
    response.setTransaction(ByteString.copyFromUtf8("project-id"));
    expectRpc("beginTransaction", request.build(), response.build());
  }

  @Test
  public void commit() throws Exception {
    CommitRequest.Builder request = CommitRequest.newBuilder();
    request.setTransaction(ByteString.copyFromUtf8("project-id"));
    CommitResponse.Builder response = CommitResponse.newBuilder();
    expectRpc("commit", request.build(), response.build());
  }

  @Test
  public void reserveIds() throws Exception {
    ReserveIdsRequest.Builder request = ReserveIdsRequest.newBuilder();
    ReserveIdsResponse.Builder response = ReserveIdsResponse.newBuilder();
    expectRpc("reserveIds", request.build(), response.build());
  }

  @Test
  public void rollback() throws Exception {
    RollbackRequest.Builder request = RollbackRequest.newBuilder();
    request.setTransaction(ByteString.copyFromUtf8("project-id"));
    RollbackResponse.Builder response = RollbackResponse.newBuilder();
    expectRpc("rollback", request.build(), response.build());
  }

  @Test
  public void runQuery() throws Exception {
    RunQueryRequest.Builder request = RunQueryRequest.newBuilder();
    request.getQueryBuilder();
    RunQueryResponse.Builder response = RunQueryResponse.newBuilder();
    response
        .getBatchBuilder()
        .setEntityResultType(EntityResult.ResultType.FULL)
        .setMoreResults(QueryResultBatch.MoreResultsType.NOT_FINISHED);
    expectRpc("runQuery", request.build(), response.build());
  }

  @Test
  public void runAggregationQuery() throws Exception {
    RunAggregationQueryRequest.Builder request = RunAggregationQueryRequest.newBuilder();
    RunAggregationQueryResponse.Builder response = RunAggregationQueryResponse.newBuilder();
    expectRpc("runAggregationQuery", request.build(), response.build());
  }

  private void expectRpc(String methodName, Message request, Message response) throws Exception {
    Datastore datastore = factory.create(options.build());
    MockDatastoreFactory mockClient = (MockDatastoreFactory) factory;

    mockClient.setNextResponse(response);
    @SuppressWarnings("rawtypes")
    Class[] methodArgs = {request.getClass()};
    Method call = Datastore.class.getMethod(methodName, methodArgs);
    Object[] callArgs = {request};
    assertEquals(response, call.invoke(datastore, callArgs));

    assertEquals("/v1/projects/project-id:" + methodName, mockClient.getLastPath());
    assertEquals("application/x-protobuf", mockClient.getLastMimeType());
    assertEquals("2", mockClient.getLastApiFormatHeaderValue());
    assertArrayEquals(request.toByteArray(), mockClient.getLastBody());
    assertEquals(1, datastore.getRpcCount());

    datastore.resetRpcCount();
    assertEquals(0, datastore.getRpcCount());

    mockClient.setNextError(400, Code.INVALID_ARGUMENT, "oops");
    try {
      call.invoke(datastore, callArgs);
      fail();
    } catch (InvocationTargetException targetException) {
      DatastoreException exception = (DatastoreException) targetException.getCause();
      assertEquals(Code.INVALID_ARGUMENT, exception.getCode());
      assertEquals(methodName, exception.getMethodName());
      assertEquals("oops", exception.getMessage());
    }

    SocketTimeoutException socketTimeoutException = new SocketTimeoutException("ste");
    mockClient.setNextException(socketTimeoutException);
    try {
      call.invoke(datastore, callArgs);
      fail();
    } catch (InvocationTargetException targetException) {
      DatastoreException exception = (DatastoreException) targetException.getCause();
      assertEquals(Code.DEADLINE_EXCEEDED, exception.getCode());
      assertEquals(methodName, exception.getMethodName());
      assertEquals("Deadline exceeded", exception.getMessage());
      assertSame(socketTimeoutException, exception.getCause());
    }

    IOException ioException = new IOException("ioe");
    mockClient.setNextException(ioException);
    try {
      call.invoke(datastore, callArgs);
      fail();
    } catch (InvocationTargetException targetException) {
      DatastoreException exception = (DatastoreException) targetException.getCause();
      assertEquals(Code.UNAVAILABLE, exception.getCode());
      assertEquals(methodName, exception.getMethodName());
      assertEquals("I/O error", exception.getMessage());
      assertSame(ioException, exception.getCause());
    }

    assertEquals(3, datastore.getRpcCount());
  }
}
