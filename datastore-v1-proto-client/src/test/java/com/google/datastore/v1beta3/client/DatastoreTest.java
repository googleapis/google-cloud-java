/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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
package com.google.datastore.v1beta3.client;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpStatusCodes;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.api.client.testing.util.TestableByteArrayInputStream;
import com.google.common.collect.Iterables;
import com.google.datastore.v1beta3.AllocateIdsRequest;
import com.google.datastore.v1beta3.AllocateIdsResponse;
import com.google.datastore.v1beta3.BeginTransactionRequest;
import com.google.datastore.v1beta3.BeginTransactionResponse;
import com.google.datastore.v1beta3.CommitRequest;
import com.google.datastore.v1beta3.CommitResponse;
import com.google.datastore.v1beta3.EntityResult;
import com.google.datastore.v1beta3.LookupRequest;
import com.google.datastore.v1beta3.LookupResponse;
import com.google.datastore.v1beta3.QueryResultBatch;
import com.google.datastore.v1beta3.RollbackRequest;
import com.google.datastore.v1beta3.RollbackResponse;
import com.google.datastore.v1beta3.RunQueryRequest;
import com.google.datastore.v1beta3.RunQueryResponse;
import com.google.protobuf.ByteString;
import com.google.protobuf.Message;
import com.google.rpc.Code;
import com.google.rpc.Status;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Tests for {@link DatastoreFactory} and {@link Datastore}.
 */
@RunWith(JUnit4.class)
public class DatastoreTest {
  private static final String PROJECT_ID = "project-id";

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  private DatastoreFactory factory = new MockDatastoreFactory();
  private DatastoreOptions.Builder options = new DatastoreOptions.Builder()
      .projectId(PROJECT_ID)
      .credential(new MockCredential());

  @Test
  public void options_NoProjectIdOrProjectEndpoint() throws Exception {
    options = new DatastoreOptions.Builder();
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Either project ID or project endpoint must be provided");
    options.build();
  }

  @Test
  public void options_ProjectIdAndProjectEndpoint() throws Exception {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Cannot set both project endpoint and project ID");
    options = new DatastoreOptions.Builder()
        .projectId(PROJECT_ID)
        .projectEndpoint("http://prom-qa/datastore/v1beta42/projects/project-id");
  }

  @Test
  public void options_LocalHostAndProjectEndpoint() throws Exception {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Cannot set both project endpoint and local host");
    options = new DatastoreOptions.Builder()
        .localHost("localhost:8080")
        .projectEndpoint("http://prom-qa/datastore/v1beta42/projects/project-id");
  }

  @Test
  public void options_InvalidLocalHost() throws Exception {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Illegal character");
    new DatastoreOptions.Builder()
        .localHost("!not a valid url!");
  }

  @Test
  public void options_SchemeInLocalHost() {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Local host \"http://localhost:8080\" must not include scheme");
    new DatastoreOptions.Builder()
        .localHost("http://localhost:8080");
  }

  @Test
  public void create_NullOptions() throws Exception {
    thrown.expect(NullPointerException.class);
    factory.create(null);
  }

  @Test
  public void create_LocalHost() {
    Datastore datastore = factory.create(new DatastoreOptions.Builder()
        .projectId(PROJECT_ID)
        .localHost("localhost:8080")
        .build());
    assertThat(datastore.remoteRpc.getUrl())
        .isEqualTo("http://localhost:8080/datastore/v1beta3/projects/project-id");
  }

  @Test
  public void create_DefaultHost() {
    Datastore datastore = factory.create(new DatastoreOptions.Builder()
        .projectId(PROJECT_ID)
        .build());
    assertThat(datastore.remoteRpc.getUrl())
        .isEqualTo("https://datastore.googleapis.com/v1beta3/projects/project-id");
  }

  @Test
  public void create_ProjectEndpoint() {
    Datastore datastore = factory.create(new DatastoreOptions.Builder()
        .projectEndpoint("http://prom-qa/datastore/v1beta42/projects/project-id")
        .build());
    assertThat(datastore.remoteRpc.getUrl())
        .isEqualTo("http://prom-qa/datastore/v1beta42/projects/project-id");
  }

  @Test
  public void initializer() throws Exception {
    options.initializer(new HttpRequestInitializer() {
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
    assertEquals("magic", mockClient.lastCookies.get(0));
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
    response.getBatchBuilder()
        .setEntityResultType(EntityResult.ResultType.FULL)
        .setMoreResults(QueryResultBatch.MoreResultsType.NOT_FINISHED);
    expectRpc("runQuery", request.build(), response.build());
  }

  private void expectRpc(String methodName, Message request, Message response) throws Exception {
    Datastore datastore = factory.create(options.build());
    MockDatastoreFactory mockClient = (MockDatastoreFactory) factory;

    mockClient.setNextResponse(response);
    @SuppressWarnings("rawtypes")
    Class[] methodArgs = { request.getClass() };
    Method call = Datastore.class.getMethod(methodName, methodArgs);
    Object[] callArgs = { request };
    assertEquals(response, call.invoke(datastore, callArgs));

    assertEquals("/v1beta3/projects/project-id:" + methodName, mockClient.lastPath);
    assertEquals("application/x-protobuf", mockClient.lastMimeType);
    assertEquals("2", mockClient.lastApiFormatHeaderValue);
    assertArrayEquals(request.toByteArray(), mockClient.lastBody);
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

    IOException ioException = new IOException("non");
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

    assertEquals(2, datastore.getRpcCount());
  }

  private static class MockCredential extends Credential {
    MockCredential() {
      super(new AccessMethod() {
          @Override
          public void intercept(HttpRequest request, String accessToken) throws IOException {
          }
          @Override
          public String getAccessTokenFromRequest(HttpRequest request) {
            return "MockAccessToken";
          }
        });
    }
  }

  private static class MockDatastoreFactory extends DatastoreFactory {
    int nextStatus;
    Message nextResponse;
    Status nextError;
    IOException nextException;

    String lastPath;
    String lastMimeType;
    byte[] lastBody;
    List<String> lastCookies;
    String lastApiFormatHeaderValue;

    void setNextResponse(Message response) {
      nextStatus = HttpStatusCodes.STATUS_CODE_OK;
      nextResponse = response;
      nextError = null;
      nextException = null;
    }

    void setNextError(int status, Code code, String message) {
      nextStatus = status;
      nextResponse = null;
      nextError = makeErrorContent(message, code);
      nextException = null;
    }

    void setNextException(IOException exception) {
      nextStatus = 0;
      nextResponse = null;
      nextError = null;
      nextException = exception;
    }

    @Override
    public HttpRequestFactory makeClient(DatastoreOptions options) {
      HttpTransport transport = new MockHttpTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) {
            return new MockLowLevelHttpRequest(url) {
              @Override
              public LowLevelHttpResponse execute() throws IOException {
                lastPath = new GenericUrl(getUrl()).getRawPath();
                lastMimeType = getContentType();
                lastCookies = getHeaderValues("Cookie");
                lastApiFormatHeaderValue =
                    Iterables.getOnlyElement(getHeaderValues("X-Goog-Api-Format-Version"));
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                getStreamingContent().writeTo(out);
                lastBody = out.toByteArray();
                if (nextException != null) {
                  throw nextException;
                }
                MockLowLevelHttpResponse response = new MockLowLevelHttpResponse()
                    .setStatusCode(nextStatus)
                    .setContentType("application/x-protobuf");
                if (nextError != null) {
                  assertNull(nextResponse);
                  response.setContent(new TestableByteArrayInputStream(nextError.toByteArray()));
                } else {
                  response.setContent(new TestableByteArrayInputStream(nextResponse.toByteArray()));
                }
                return response;
              }
            };
          }
        };
      Credential credential = options.getCredential();
      return transport.createRequestFactory(credential);
    }
  }

  private static Status makeErrorContent(String message, Code code) {
    return Status.newBuilder().setCode(code.getNumber()).setMessage(message).build();
  }
}
