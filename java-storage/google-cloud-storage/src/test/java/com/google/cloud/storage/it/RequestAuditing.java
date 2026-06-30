/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.storage.it;

import static com.google.common.truth.Truth.assertWithMessage;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.MultipartContent;
import com.google.api.client.http.MultipartContent.Part;
import com.google.api.client.http.json.JsonHttpContent;
import com.google.api.client.json.GenericJson;
import com.google.cloud.ServiceOptions;
import com.google.cloud.http.HttpTransportOptions;
import com.google.cloud.storage.it.CSEKSupport.EncryptionKeyTuple;
import com.google.common.collect.ImmutableList;
import com.google.common.truth.IterableSubject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class RequestAuditing extends HttpTransportOptions implements AssertRequestHeaders {

  private final List<HttpRequest> requests;

  public RequestAuditing() {
    super(HttpTransportOptions.newBuilder());
    requests = Collections.synchronizedList(new ArrayList<>());
  }

  @Override
  public HttpRequestInitializer getHttpRequestInitializer(ServiceOptions<?, ?> serviceOptions) {
    HttpRequestInitializer delegate = super.getHttpRequestInitializer(serviceOptions);
    return request -> {
      requests.add(request);
      delegate.initialize(request);
    };
  }

  public ImmutableList<HttpRequest> getRequests() {
    return ImmutableList.copyOf(requests);
  }

  public void clear() {
    requests.clear();
  }

  void assertQueryParam(String paramName, String expectedValue) {
    assertQueryParam(paramName, ImmutableList.of(expectedValue), Function.identity());
  }

  void assertQueryParam(String paramName, ImmutableList<String> expectedValue) {
    assertQueryParam(paramName, expectedValue, Function.identity());
  }

  <T> void assertQueryParam(String paramName, T expected, Function<String, T> transform) {
    assertQueryParam(paramName, ImmutableList.of(expected), transform);
  }

  private <T> void assertQueryParam(
      String paramName, ImmutableList<T> expected, Function<String, T> transform) {
    ImmutableList<HttpRequest> requests = getRequests();

    List<T> actual =
        requests.stream()
            .map(HttpRequest::getUrl)
            // When a multipart (http, not MPU) request is sent it will show up as multiple requests
            // de-dupe before processing
            .distinct()
            .map(u -> (String) u.getFirst(paramName))
            .filter(Objects::nonNull)
            .map(transform)
            .collect(Collectors.toList());

    assertWithMessage("Query Param " + paramName).that(actual).isEqualTo(expected);
  }

  void assertPathParam(String resourceName, String expectedValue) {
    ImmutableList<HttpRequest> requests = getRequests();

    List<String> actual =
        requests.stream()
            .map(HttpRequest::getUrl)
            // When a multipart (http, not MPU) request is sent it will show up as multiple requests
            // de-dupe before processing
            .distinct()
            .map(GenericUrl::getRawPath)
            .map(
                s -> {
                  int resourceNameIndex = s.indexOf(resourceName);
                  if (resourceNameIndex >= 0) {
                    int valueBegin = resourceNameIndex + resourceName.length() + 1;
                    int nextSlashIdx = s.indexOf("/", valueBegin);

                    if (nextSlashIdx > valueBegin) {
                      return s.substring(valueBegin, nextSlashIdx);
                    } else {
                      return s.substring(nextSlashIdx + 1);
                    }
                  } else {
                    return null;
                  }
                })
            .filter(Objects::nonNull)
            .collect(Collectors.toList());

    assertWithMessage("Path Param " + resourceName)
        .that(actual)
        .isEqualTo(ImmutableList.of(expectedValue));
  }

  void assertNoContentEncoding() {
    ImmutableList<HttpRequest> requests = getRequests();

    List<String> actual =
        requests.stream()
            .map(HttpRequest::getHeaders)
            .map(HttpHeaders::getContentType)
            .filter(Objects::nonNull)
            .collect(Collectors.toList());

    assertWithMessage("Header Content-Encoding").that(actual).isEmpty();
  }

  void assertEncryptionKeyHeaders(EncryptionKeyTuple tuple) {
    ImmutableList<HttpRequest> requests = getRequests();

    List<EncryptionKeyTuple> actual =
        requests.stream()
            .map(HttpRequest::getHeaders)
            .map(
                h ->
                    new EncryptionKeyTuple(
                        (String) h.get("x-goog-encryption-algorithm"),
                        (String) h.get("x-goog-encryption-key"),
                        (String) h.get("x-goog-encryption-key-sha256")))
            .collect(Collectors.toList());

    // When a multipart (http, not MPU) request is sent it will show up as multiple requests,
    // constrain our assertion to contains rather than exact matching
    assertWithMessage("Headers x-goog-encryption-*")
        .that(actual)
        .containsAtLeastElementsIn(ImmutableList.of(tuple));
  }

  void assertMultipartContentJsonAndText() {
    List<String> actual =
        getRequests().stream()
            .filter(r -> r.getContent() instanceof MultipartContent)
            .map(r -> (MultipartContent) r.getContent())
            .flatMap(c -> c.getParts().stream())
            .map(Part::getContent)
            .map(HttpContent::getType)
            .collect(Collectors.toList());

    assertWithMessage("Multipart Content-Type")
        .that(actual)
        .isEqualTo(ImmutableList.of("application/json; charset=UTF-8", "text/plain"));
  }

  void assertMultipartJsonField(String jsonField, Object expectedValue) {
    List<Object> collect =
        getRequests().stream()
            .filter(r -> r.getContent() instanceof MultipartContent)
            .map(r -> (MultipartContent) r.getContent())
            .flatMap(c -> c.getParts().stream())
            .map(Part::getContent)
            .filter(content -> "application/json; charset=UTF-8".equals(content.getType()))
            .filter(c -> c instanceof JsonHttpContent)
            .map(c -> (JsonHttpContent) c)
            .map(c -> (GenericJson) c.getData())
            .map(json -> json.get(jsonField))
            .collect(Collectors.toList());
    assertWithMessage("Multipart json field " + jsonField)
        .that(collect)
        .isEqualTo(ImmutableList.of(expectedValue));
  }

  @Override
  public IterableSubject assertRequestHeader(String headerName, FilteringPolicy filteringPolicy) {
    Function<Stream<Object>, Stream<Object>> filter;
    switch (filteringPolicy) {
      case DISTINCT:
        filter = Stream::distinct;
        break;
      case NO_FILTER:
        filter = Function.identity();
        break;
      default:
        throw new IllegalStateException("Unhandled enum value: " + filteringPolicy);
    }

    ImmutableList<HttpRequest> requests = getRequests();

    Stream<Object> stream =
        requests.stream()
            .map(HttpRequest::getHeaders)
            .map(headers -> headers.get(headerName))
            .filter(Objects::nonNull);
    List<Object> actual = filter.apply(stream).collect(Collectors.toList());

    return assertWithMessage(String.format(Locale.US, "Headers %s", headerName)).that(actual);
  }
}
