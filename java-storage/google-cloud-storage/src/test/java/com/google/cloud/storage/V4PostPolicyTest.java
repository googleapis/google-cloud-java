/*
 * Copyright 2020 Google LLC
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.google.api.core.ApiClock;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.conformance.storage.v1.PolicyConditions;
import com.google.cloud.conformance.storage.v1.PolicyInput;
import com.google.cloud.conformance.storage.v1.PostPolicyV4Test;
import com.google.cloud.conformance.storage.v1.TestFile;
import com.google.cloud.conformance.storage.v1.UrlStyle;
import com.google.cloud.storage.testing.RemoteStorageHelper;
import com.google.common.base.Charsets;
import com.google.common.io.BaseEncoding;
import com.google.protobuf.Timestamp;
import com.google.protobuf.util.JsonFormat;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class V4PostPolicyTest {

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

  private final PostPolicyV4Test testData;
  private final ServiceAccountCredentials serviceAccountCredentials;

  /**
   * @param testData the serialized test data representing the test case.
   * @param serviceAccountCredentials The credentials to use in this test.
   * @param description Not used by the test, but used by the parameterized test runner as the name
   *     of the test.
   */
  public V4PostPolicyTest(
      PostPolicyV4Test testData,
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
            .setClock(new FakeClock(testData.getPolicyInput().getTimestamp()))
            .build()
            .getService();

    BlobInfo blob =
        BlobInfo.newBuilder(
                testData.getPolicyInput().getBucket(), testData.getPolicyInput().getObject())
            .build();

    PolicyInput policyInput = testData.getPolicyInput();
    PostPolicyV4.PostConditionsV4.Builder builder = PostPolicyV4.PostConditionsV4.newBuilder();

    Map<String, String> fields = policyInput.getFieldsMap();

    PolicyConditions conditions = policyInput.getConditions();

    if (conditions != null) {
      if (!conditions.getStartsWithList().isEmpty()) {
        builder.addCustomCondition(
            PostPolicyV4.ConditionV4Type.STARTS_WITH,
            conditions.getStartsWith(0).replace("$", ""),
            conditions.getStartsWith(1));
      }
      if (!conditions.getContentLengthRangeList().isEmpty()) {
        builder.addContentLengthRangeCondition(
            conditions.getContentLengthRange(0), conditions.getContentLengthRange(1));
      }
    }

    PostPolicyV4.PostFieldsV4 v4Fields = PostPolicyV4.PostFieldsV4.of(fields);

    Storage.PostPolicyV4Option style = Storage.PostPolicyV4Option.withPathStyle();

    if (policyInput.getUrlStyle().equals(UrlStyle.VIRTUAL_HOSTED_STYLE)) {
      style = Storage.PostPolicyV4Option.withVirtualHostedStyle();
    } else if (policyInput.getUrlStyle().equals(UrlStyle.PATH_STYLE)) {
      style = Storage.PostPolicyV4Option.withPathStyle();
    } else if (policyInput.getUrlStyle().equals(UrlStyle.BUCKET_BOUND_HOSTNAME)) {
      style =
          Storage.PostPolicyV4Option.withBucketBoundHostname(
              policyInput.getBucketBoundHostname(),
              Storage.UriScheme.valueOf(policyInput.getScheme().toUpperCase()));
    }

    PostPolicyV4 policy =
        storage.generateSignedPostPolicyV4(
            blob,
            testData.getPolicyInput().getExpiration(),
            TimeUnit.SECONDS,
            v4Fields,
            builder.build(),
            style);

    String expectedPolicy = testData.getPolicyOutput().getExpectedDecodedPolicy();

    StringBuilder escapedPolicy = new StringBuilder();

    // Java automatically unescapes the unicode escapes in the conformance tests, so we need to
    // manually re-escape them
    char[] expectedPolicyArray = expectedPolicy.toCharArray();
    for (int i = 0; i < expectedPolicyArray.length; i++) {
      char c = expectedPolicyArray[i];
      if (c >= 128) {
        escapedPolicy.append(String.format(Locale.US, "\\u%04x", (int) c));
      } else {
        switch (c) {
          case '\\':
            // quotes aren't unescaped, so leave any "\"" found alone
            if (expectedPolicyArray[i + 1] == '"') {
              escapedPolicy.append("\\");
            } else {
              escapedPolicy.append("\\\\");
            }
            break;
          case '\b':
            escapedPolicy.append("\\b");
            break;
          case '\f':
            escapedPolicy.append("\\f");
            break;
          case '\n':
            escapedPolicy.append("\\n");
            break;
          case '\r':
            escapedPolicy.append("\\r");
            break;
          case '\t':
            escapedPolicy.append("\\t");
            break;
          case '\u000b':
            escapedPolicy.append("\\v");
            break;
          default:
            escapedPolicy.append(c);
        }
      }
    }
    assertEquals(testData.getPolicyOutput().getFieldsMap(), policy.getFields());

    assertEquals(
        escapedPolicy.toString(),
        new String(BaseEncoding.base64().decode(policy.getFields().get("policy"))));
    assertEquals(testData.getPolicyOutput().getUrl(), policy.getUrl());
  }

  /**
   * Loads all of the tests and return a {@code Collection<Object[]>} representing the set of tests.
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

    List<PostPolicyV4Test> tests = testFile.getPostPolicyV4TestsList();
    ArrayList<Object[]> data = new ArrayList<>(tests.size());
    for (PostPolicyV4Test test : tests) {
      data.add(new Object[] {test, serviceAccountCredentials, test.getDescription()});
    }
    return data;
  }
}
