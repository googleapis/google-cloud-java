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

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assume.assumeThat;

import com.google.api.core.ApiClock;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.conformance.storage.v1.SigningV4Test;
import com.google.cloud.conformance.storage.v1.TestFile;
import com.google.cloud.storage.Storage.SignUrlOption;
import com.google.cloud.storage.testing.RemoteStorageHelper;
import com.google.protobuf.Timestamp;
import com.google.protobuf.util.JsonFormat;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
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
    assumeThat(
        "Test skipped until b/136171758 is resolved",
        testName.getMethodName(),
        is(not("test[Headers should be trimmed]")));

    Storage storage =
        RemoteStorageHelper.create()
            .getOptions()
            .toBuilder()
            .setCredentials(serviceAccountCredentials)
            .setClock(new FakeClock(testData.getTimestamp()))
            .build()
            .getService();

    BlobInfo blob = BlobInfo.newBuilder(testData.getBucket(), testData.getObject()).build();

    final String signedUrl =
        storage
            .signUrl(
                blob,
                testData.getExpiration(),
                TimeUnit.SECONDS,
                SignUrlOption.httpMethod(HttpMethod.valueOf(testData.getMethod())),
                SignUrlOption.withExtHeaders(testData.getHeadersMap()),
                SignUrlOption.withV4Signature())
            .toString();
    assertEquals(testData.getExpectedUrl(), signedUrl);
  }

  /**
   * Attempt to load all of the tests and return a {@code Collection<Object[]>} representing the set
   * of tests. Each entry in the returned collection is the set of parameters to the constructor of
   * this test class.
   *
   * <p>The results of this method will then be ran by JUnit's Parameterized test runner
   */
  @Parameters(name = "{2}")
  public static Collection<Object[]> testCases() throws IOException {
    final ClassLoader cl = Thread.currentThread().getContextClassLoader();

    final InputStream credentialsStream = cl.getResourceAsStream(SERVICE_ACCOUNT_JSON_RESOURCE);
    assertNotNull(
        String.format("Unable to load service account json: %s", SERVICE_ACCOUNT_JSON_RESOURCE),
        credentialsStream);

    final InputStream dataJson = cl.getResourceAsStream(TEST_DATA_JSON_RESOURCE);
    assertNotNull(
        String.format("Unable to load test definition: %s", TEST_DATA_JSON_RESOURCE), dataJson);

    final ServiceAccountCredentials serviceAccountCredentials =
        ServiceAccountCredentials.fromStream(credentialsStream);

    final InputStreamReader reader = new InputStreamReader(dataJson);
    final TestFile.Builder testBuilder = TestFile.newBuilder();
    JsonFormat.parser().merge(reader, testBuilder);
    final TestFile testFile = testBuilder.build();

    final List<SigningV4Test> tests = testFile.getSigningV4TestsList();
    final ArrayList<Object[]> data = new ArrayList<>(tests.size());
    for (SigningV4Test test : tests) {
      data.add(new Object[] {test, serviceAccountCredentials, test.getDescription()});
    }
    return data;
  }
}
