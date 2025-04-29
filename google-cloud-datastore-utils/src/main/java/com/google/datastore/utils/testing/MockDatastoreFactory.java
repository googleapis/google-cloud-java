/*
 * Copyright 2022 Google LLC
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
package com.google.datastore.utils.testing;

import static com.google.common.base.Preconditions.checkState;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.http.*;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.api.client.testing.util.TestableByteArrayInputStream;
import com.google.common.collect.Iterables;
import com.google.datastore.utils.DatastoreFactory;
import com.google.datastore.utils.DatastoreOptions;
import com.google.protobuf.Message;
import com.google.rpc.Code;
import com.google.rpc.Status;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

/** Fake Datastore factory used for testing purposes when a true Datastore service is not needed. */
public class MockDatastoreFactory extends DatastoreFactory {
  private int nextStatus;
  private Message nextResponse;
  private Status nextError;
  private IOException nextException;

  private String lastPath;
  private String lastMimeType;
  private byte[] lastBody;
  private List<String> lastCookies;
  private String lastApiFormatHeaderValue;

  public void setNextResponse(Message response) {
    nextStatus = HttpStatusCodes.STATUS_CODE_OK;
    nextResponse = response;
    nextError = null;
    nextException = null;
  }

  public void setNextError(int status, Code code, String message) {
    nextStatus = status;
    nextResponse = null;
    nextError = makeErrorContent(message, code);
    nextException = null;
  }

  public void setNextException(IOException exception) {
    nextStatus = 0;
    nextResponse = null;
    nextError = null;
    nextException = exception;
  }

  @Override
  public HttpRequestFactory makeClient(DatastoreOptions options) {
    HttpTransport transport =
        new MockHttpTransport() {
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
                MockLowLevelHttpResponse response =
                    new MockLowLevelHttpResponse()
                        .setStatusCode(nextStatus)
                        .setContentType("application/x-protobuf");
                if (nextError != null) {
                  checkState(nextResponse == null);
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

  public String getLastPath() {
    return lastPath;
  }

  public String getLastMimeType() {
    return lastMimeType;
  }

  public String getLastApiFormatHeaderValue() {
    return lastApiFormatHeaderValue;
  }

  public byte[] getLastBody() {
    return lastBody;
  }

  public List<String> getLastCookies() {
    return lastCookies;
  }

  private static Status makeErrorContent(String message, Code code) {
    return Status.newBuilder().setCode(code.getNumber()).setMessage(message).build();
  }
}
