/*
 * Copyright 2019 Google LLC
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

package com.google.cloud.storage;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertNotNull;

import com.google.api.core.ApiClock;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.Tuple;
import com.google.cloud.conformance.storage.v1.SigningV4Test;
import com.google.cloud.conformance.storage.v1.TestFile;
import com.google.cloud.conformance.storage.v1.UrlStyle;
import com.google.cloud.storage.Storage.SignUrlOption;
import com.google.cloud.storage.testing.RemoteStorageHelper;
import com.google.common.base.Charsets;
import com.google.protobuf.Timestamp;
import com.google.protobuf.util.JsonFormat;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class V4SigningTest {

  private static final String SERVICE_ACCOUNT_JSON_RESOURCE =
      "com/google/cloud/conformance/storage/v1/test_service_account.not-a-test.json";
  private static final String TEST_DATA_JSON_RESOURCE =
      "com/google/cloud/conformance/storage/v1/v4_signatures.json";

  private static class FakeClock implements ApiClock {
    private final AtomicLong currentNanoTime;

    public FakeClock(Timestamp timestamp) {
      this.currentNanoTime =
          new AtomicLong(
              TimeUnit.NANOSECONDS.convert(timestamp.getSeconds(), TimeUnit.SECONDS)
                  + timestamp.getNanos());
    }

    public long nanoTime() {
      return this.currentNanoTime.get();
    }

    public long millisTime() {
      return TimeUnit.MILLISECONDS.convert(this.nanoTime(), TimeUnit.NANOSECONDS);
    }
  }

  @Rule public TestName testName = new TestName();

  private final SigningV4Test testData;
  private final ServiceAccountCredentials serviceAccountCredentials;

  /**
   * @param testData The serialized test data representing the test case.
   * @param serviceAccountCredentials The credentials to use in this test.
   * @param description Not used by the test, but used by the parameterized test runner as the name
   *     of the test.
   */
  public V4SigningTest(
      SigningV4Test testData,
      ServiceAccountCredentials serviceAccountCredentials,
      @SuppressWarnings("unused") String description) {
    this.testData = testData;
    this.serviceAccountCredentials = serviceAccountCredentials;
  }

  @Test
  public void test() {
    Storage storage =
        RemoteStorageHelper.create().getOptions().toBuilder()
            .setCredentials(serviceAccountCredentials)
            .setClock(new FakeClock(testData.getTimestamp()))
            .build()
            .getService();

    BlobInfo blob = BlobInfo.newBuilder(testData.getBucket(), testData.getObject()).build();

    SignUrlOption style = SignUrlOption.withPathStyle();

    if (testData.getUrlStyle().equals(UrlStyle.VIRTUAL_HOSTED_STYLE)) {
      style = SignUrlOption.withVirtualHostedStyle();
    } else if (testData.getUrlStyle().equals(UrlStyle.PATH_STYLE)) {
      style = SignUrlOption.withPathStyle();
    } else if (testData.getUrlStyle().equals(UrlStyle.BUCKET_BOUND_HOSTNAME)) {
      style =
          SignUrlOption.withBucketBoundHostname(
              testData.getBucketBoundHostname(),
              Storage.UriScheme.valueOf(testData.getScheme().toUpperCase()));
    }

    final String signedUrl =
        storage
            .signUrl(
                blob,
                testData.getExpiration(),
                TimeUnit.SECONDS,
                SignUrlOption.httpMethod(HttpMethod.valueOf(testData.getMethod())),
                SignUrlOption.withExtHeaders(testData.getHeadersMap()),
                SignUrlOption.withV4Signature(),
                SignUrlOption.withQueryParams(testData.getQueryParametersMap()),
                style)
            .toString();
    SmarterUrl expected = SmarterUrl.of(URI.create(testData.getExpectedUrl()));
    SmarterUrl actual = SmarterUrl.of(URI.create(signedUrl));
    assertThat(actual).isEqualTo(expected);
  }

  /**
   * Load all of the tests and return a {@code Collection<Object[]>} representing the set of tests.
   * Each entry in the returned collection is the set of parameters to the constructor of this test
   * class.
   *
   * <p>The results of this method will then be run by JUnit's Parameterized test runner
   */
  @Parameters(name = "{2}")
  public static Collection<Object[]> testCases() throws IOException {
    ClassLoader cl = Thread.currentThread().getContextClassLoader();

    InputStream credentialsStream = cl.getResourceAsStream(SERVICE_ACCOUNT_JSON_RESOURCE);
    assertNotNull(
        String.format(
            Locale.US, "Unable to load service account json: %s", SERVICE_ACCOUNT_JSON_RESOURCE),
        credentialsStream);

    InputStream dataJson = cl.getResourceAsStream(TEST_DATA_JSON_RESOURCE);
    assertNotNull(
        String.format(Locale.US, "Unable to load test definition: %s", TEST_DATA_JSON_RESOURCE),
        dataJson);

    ServiceAccountCredentials serviceAccountCredentials =
        ServiceAccountCredentials.fromStream(credentialsStream);

    InputStreamReader reader = new InputStreamReader(dataJson, Charsets.UTF_8);
    TestFile.Builder testBuilder = TestFile.newBuilder();
    JsonFormat.parser().merge(reader, testBuilder);
    TestFile testFile = testBuilder.build();

    List<SigningV4Test> tests = testFile.getSigningV4TestsList();
    ArrayList<Object[]> data = new ArrayList<>(tests.size());
    for (SigningV4Test test : tests) {
      data.add(new Object[] {test, serviceAccountCredentials, test.getDescription()});
    }
    return data;
  }

  /**
   * Equals on {@link URI} or {@link java.net.URL} perform string comparison on the full query
   * string. However, query strings are not order dependent. This class essentially provides a
   * smarter equals and hashcode for a url taking into account a query string is not order
   * dependent.
   */
  private static final class SmarterUrl {
    private final String path;
    private final Map<String, String> queryStringParameters;

    private SmarterUrl(String path, Map<String, String> queryStringParameters) {
      this.path = path;
      this.queryStringParameters = queryStringParameters;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof SmarterUrl)) {
        return false;
      }
      SmarterUrl that = (SmarterUrl) o;
      return Objects.equals(path, that.path)
          && Objects.equals(queryStringParameters, that.queryStringParameters);
    }

    @Override
    public int hashCode() {
      return Objects.hash(path, queryStringParameters);
    }

    private static SmarterUrl of(URI uri) {
      String path = uri.getRawPath();
      String rawQuery = uri.getRawQuery();
      String[] split = rawQuery.split("&");
      Map<String, String> queryStringParameters =
          Arrays.stream(split)
              .map(
                  qp -> {
                    // use indexOf instead of split, just in case an equals is part of the value
                    int i = qp.indexOf('=');
                    String k = qp.substring(0, i);
                    String v = qp.substring(i + 1);
                    return Tuple.of(k, v);
                  })
              .collect(Collectors.toMap(Tuple::x, Tuple::y));
      return new SmarterUrl(path, queryStringParameters);
    }
  }
}
