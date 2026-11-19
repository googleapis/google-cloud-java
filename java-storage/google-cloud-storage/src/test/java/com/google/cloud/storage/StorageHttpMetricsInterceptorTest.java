/*
 * Copyright 2026 Google LLC
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
import static com.google.common.truth.Truth.assertWithMessage;
import static org.junit.Assert.assertThrows;

import com.google.api.client.googleapis.batch.BatchCallback;
import com.google.api.client.googleapis.batch.BatchRequest;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.api.core.ApiClock;
import com.google.cloud.NoCredentials;
import com.google.cloud.ServiceOptions;
import com.google.cloud.WriteChannel;
import com.google.cloud.http.HttpTransportOptions;
import com.google.common.collect.ImmutableList;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.api.trace.TraceFlags;
import io.opentelemetry.api.trace.TraceState;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.Scope;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.data.DoubleExemplarData;
import io.opentelemetry.sdk.metrics.data.HistogramPointData;
import io.opentelemetry.sdk.metrics.data.LongPointData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.Before;
import org.junit.Test;

public final class StorageHttpMetricsInterceptorTest {

  private InMemoryMetricReader reader;
  private FakeClock clock;
  private HttpStorageOptions httpOptions;
  private StorageClientMetrics metrics;

  @Before
  public void setUp() {
    reader = InMemoryMetricReader.create();
    SdkMeterProvider meterProvider =
        SdkMeterProvider.builder().registerMetricReader(reader).build();
    clock = new FakeClock();
    httpOptions =
        StorageOptions.http()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .setClock(clock)
            .setEnableOtelMetrics(true)
            .setMeterProvider(meterProvider)
            .build();
    metrics = httpOptions.getStorageClientMetrics();
  }

  @Test
  public void extractUrlTemplate_cases() {
    String[][] cases = {
      {"https://storage.googleapis.com", "/"},
      {"https://storage.googleapis.com/", "/"},
      {
        "https://storage.googleapis.com/upload/storage/v1/b/my-b/o",
        "/upload/storage/v1/b/{bucket}/o"
      },
      {
        "https://storage.googleapis.com/download/storage/v1/b/my-b/o/my-obj",
        "/download/storage/v1/b/{bucket}/o/{object}"
      },
      {"https://storage.googleapis.com/batch/storage/v1", "/batch/storage/v1"},
      {"https://storage.googleapis.com/storage/v1/b", "/storage/v1/b"},
      {"https://storage.googleapis.com/storage/v1/b/my-b", "/storage/v1/b/{bucket}"},
      {"https://storage.googleapis.com/storage/v1/b/my-b/o", "/storage/v1/b/{bucket}/o"},
      {
        "https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj",
        "/storage/v1/b/{bucket}/o/{object}"
      },
      {
        "https://storage.googleapis.com/storage/v1/b/my-b/o/dir/sub/file.txt",
        "/storage/v1/b/{bucket}/o/{object}"
      },
      {
        "https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj/compose",
        "/storage/v1/b/{bucket}/o/{object}/compose"
      },
      {
        "https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj/restore",
        "/storage/v1/b/{bucket}/o/{object}/restore"
      },
      {
        "https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj/acl",
        "/storage/v1/b/{bucket}/o/{object}/acl"
      },
      {
        "https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj/acl/allUsers",
        "/storage/v1/b/{bucket}/o/{object}/acl/{entity}"
      },
      {
        "https://storage.googleapis.com/storage/v1/b/b1/o/o1/rewriteTo/b/b2/o/o2",
        "/storage/v1/b/{bucket}/o/{object}/rewriteTo/b/{bucket}/o/{object}"
      },
      {
        "https://storage.googleapis.com/storage/v1/b/b1/o/o1/moveTo/o/o2",
        "/storage/v1/b/{bucket}/o/{object}/moveTo/o/{object}"
      },
      {"https://storage.googleapis.com/storage/v1/b/b1/acl", "/storage/v1/b/{bucket}/acl"},
      {
        "https://storage.googleapis.com/storage/v1/b/b1/acl/allUsers",
        "/storage/v1/b/{bucket}/acl/{entity}"
      },
      {
        "https://storage.googleapis.com/storage/v1/b/b1/defaultObjectAcl",
        "/storage/v1/b/{bucket}/defaultObjectAcl"
      },
      {
        "https://storage.googleapis.com/storage/v1/b/b1/defaultObjectAcl/allUsers",
        "/storage/v1/b/{bucket}/defaultObjectAcl/{entity}"
      },
      {
        "https://storage.googleapis.com/storage/v1/b/b1/notificationConfigs",
        "/storage/v1/b/{bucket}/notificationConfigs"
      },
      {
        "https://storage.googleapis.com/storage/v1/b/b1/notificationConfigs/notif1",
        "/storage/v1/b/{bucket}/notificationConfigs/{notification}"
      },
      {"https://storage.googleapis.com/storage/v1/b/b1/iam", "/storage/v1/b/{bucket}/iam"},
      {
        "https://storage.googleapis.com/storage/v1/b/b1/iam/testPermissions",
        "/storage/v1/b/{bucket}/iam/testPermissions"
      },
      {
        "https://storage.googleapis.com/storage/v1/projects/my-p/hmacKeys/key1",
        "/storage/v1/projects/{project}/hmacKeys/{access_id}"
      },
      {
        "https://storage.googleapis.com/storage/v1/projects/my-p/serviceAccount",
        "/storage/v1/projects/{project}/serviceAccount"
      },
      {"https://storage.googleapis.com/my-b", "/{bucket}"},
      {"https://storage.googleapis.com/my-b/my-obj", "/{bucket}/{object}"},
      {"https://my-bucket.storage.googleapis.com/", "/"},
      {"https://my-bucket.storage.googleapis.com/my-obj", "/{object}"},
      {"https://my-bucket.storage.googleapis.com/dir/my-obj", "/{object}"},
    };

    for (String[] testCase : cases) {
      String url = testCase[0];
      String expectedTemplate = testCase[1];
      assertWithMessage(url)
          .that(StorageHttpMetricsInterceptor.extractUrlTemplate(new GenericUrl(url)))
          .isEqualTo(expectedTemplate);
    }
  }

  @Test
  public void isMediaDownloadRequest_cases() throws IOException {
    HttpRequestFactory factory = new MockHttpTransport().createRequestFactory();
    Object[][] cases = {
      {"GET", "https://storage.googleapis.com/download/storage/v1/b/my-b/o/my-obj", true},
      {"GET", "https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj?alt=media", true},
      {"GET", "https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj?alt=json", false},
      {"GET", "https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj", false},
      {"GET", "https://storage.googleapis.com", false},
      {"POST", "https://storage.googleapis.com/download/storage/v1/b/my-b/o/my-obj", false},
    };

    for (Object[] testCase : cases) {
      String method = (String) testCase[0];
      String url = (String) testCase[1];
      boolean expected = (boolean) testCase[2];
      HttpRequest request = factory.buildRequest(method, new GenericUrl(url), null);
      assertWithMessage("%s %s", method, url)
          .that(StorageHttpMetricsInterceptor.isMediaDownloadRequest(request))
          .isEqualTo(expected);
    }
  }

  @Test
  public void isMediaUploadRequest_cases() throws IOException {
    HttpRequestFactory factory = new MockHttpTransport().createRequestFactory();
    Object[][] cases = {
      {
        "POST",
        "https://storage.googleapis.com/upload/storage/v1/b/my-b/o?uploadType=multipart",
        true
      },
      {
        "POST",
        "https://storage.googleapis.com/upload/storage/v1/b/my-b/o?uploadType=resumable",
        true
      },
      {
        "PUT",
        "https://storage.googleapis.com/upload/storage/v1/b/my-b/o?uploadType=resumable&upload_id=u1",
        true
      },
      {"POST", "https://storage.googleapis.com/my-b/my-obj?uploadType=resumable", true},
      {"PUT", "https://storage.googleapis.com/my-b/my-obj?upload_id=u1", true},
      {"POST", "https://storage.googleapis.com/storage/v1/b/my-b/o", false},
      {"GET", "https://storage.googleapis.com/upload/storage/v1/b/my-b/o", false},
      {"DELETE", "https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj", false},
    };

    for (Object[] testCase : cases) {
      String method = (String) testCase[0];
      String url = (String) testCase[1];
      boolean expected = (boolean) testCase[2];
      HttpRequest request = factory.buildRequest(method, new GenericUrl(url), null);
      assertWithMessage("%s %s", method, url)
          .that(StorageHttpMetricsInterceptor.isMediaUploadRequest(request))
          .isEqualTo(expected);
    }
  }

  @Test
  public void resolveOperationName_cases() throws IOException {
    HttpRequestFactory factory = new MockHttpTransport().createRequestFactory();
    String[][] cases = {
      {"GET", "https://storage.googleapis.com/download/storage/v1/b/my-b/o/my-obj", "ReadObject"},
      {"GET", "https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj?alt=media", "ReadObject"},
      {
        "POST",
        "https://storage.googleapis.com/upload/storage/v1/b/my-b/o?uploadType=multipart",
        "WriteObject"
      },
      {
        "PUT",
        "https://storage.googleapis.com/upload/storage/v1/b/my-b/o?uploadType=resumable&upload_id=u1",
        "WriteObject"
      },
      {"PUT", "https://storage.googleapis.com/my-b/my-obj?upload_id=u1", "WriteObject"},
      {"POST", "https://storage.googleapis.com/batch/storage/v1", "Batch"},
      {"POST", "https://storage.googleapis.com/storage/v1/b", "CreateBucket"},
      {"GET", "https://storage.googleapis.com/storage/v1/b", "ListBuckets"},
      {"GET", "https://storage.googleapis.com/storage/v1/b/my-b", "GetBucket"},
      {"PATCH", "https://storage.googleapis.com/storage/v1/b/my-b", "UpdateBucket"},
      {"DELETE", "https://storage.googleapis.com/storage/v1/b/my-b", "DeleteBucket"},
      {
        "POST",
        "https://storage.googleapis.com/storage/v1/b/my-b/lockRetentionPolicy",
        "LockBucketRetentionPolicy"
      },
      {"GET", "https://storage.googleapis.com/storage/v1/b/my-b/iam", "GetIamPolicy"},
      {"PUT", "https://storage.googleapis.com/storage/v1/b/my-b/iam", "SetIamPolicy"},
      {
        "GET",
        "https://storage.googleapis.com/storage/v1/b/my-b/iam/testPermissions",
        "TestIamPermissions"
      },
      {"POST", "https://storage.googleapis.com/storage/v1/b/my-b/acl", "CreateBucketACL"},
      {"GET", "https://storage.googleapis.com/storage/v1/b/my-b/acl", "ListBucketACLs"},
      {"GET", "https://storage.googleapis.com/storage/v1/b/my-b/acl/allUsers", "GetBucketACL"},
      {"PATCH", "https://storage.googleapis.com/storage/v1/b/my-b/acl/allUsers", "UpdateBucketACL"},
      {
        "DELETE", "https://storage.googleapis.com/storage/v1/b/my-b/acl/allUsers", "DeleteBucketACL"
      },
      {
        "POST",
        "https://storage.googleapis.com/storage/v1/b/my-b/defaultObjectAcl",
        "CreateDefaultObjectACL"
      },
      {
        "GET",
        "https://storage.googleapis.com/storage/v1/b/my-b/defaultObjectAcl",
        "ListDefaultObjectACLs"
      },
      {
        "GET",
        "https://storage.googleapis.com/storage/v1/b/my-b/defaultObjectAcl/allUsers",
        "GetDefaultObjectACL"
      },
      {
        "PATCH",
        "https://storage.googleapis.com/storage/v1/b/my-b/defaultObjectAcl/allUsers",
        "UpdateDefaultObjectACL"
      },
      {
        "DELETE",
        "https://storage.googleapis.com/storage/v1/b/my-b/defaultObjectAcl/allUsers",
        "DeleteDefaultObjectACL"
      },
      {
        "POST",
        "https://storage.googleapis.com/storage/v1/b/my-b/notificationConfigs",
        "CreateNotification"
      },
      {
        "GET",
        "https://storage.googleapis.com/storage/v1/b/my-b/notificationConfigs",
        "ListNotifications"
      },
      {
        "GET",
        "https://storage.googleapis.com/storage/v1/b/my-b/notificationConfigs/n1",
        "GetNotification"
      },
      {
        "DELETE",
        "https://storage.googleapis.com/storage/v1/b/my-b/notificationConfigs/n1",
        "DeleteNotification"
      },
      {"POST", "https://storage.googleapis.com/storage/v1/b/my-b/o", "WriteObject"},
      {"GET", "https://storage.googleapis.com/storage/v1/b/my-b/o", "ListObjects"},
      {"GET", "https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj", "GetObject"},
      {"PATCH", "https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj", "UpdateObject"},
      {"DELETE", "https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj", "DeleteObject"},
      {
        "POST", "https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj/compose", "ComposeObject"
      },
      {
        "POST", "https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj/restore", "RestoreObject"
      },
      {
        "POST",
        "https://storage.googleapis.com/storage/v1/b/b1/o/o1/rewriteTo/b/b2/o/o2",
        "RewriteObject"
      },
      {"POST", "https://storage.googleapis.com/storage/v1/b/b1/o/o1/moveTo/o/o2", "MoveObject"},
      {"POST", "https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj/acl", "CreateObjectACL"},
      {"GET", "https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj/acl", "ListObjectACLs"},
      {
        "GET",
        "https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj/acl/allUsers",
        "GetObjectACL"
      },
      {
        "PATCH",
        "https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj/acl/allUsers",
        "UpdateObjectACL"
      },
      {
        "DELETE",
        "https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj/acl/allUsers",
        "DeleteObjectACL"
      },
      {"POST", "https://storage.googleapis.com/storage/v1/projects/my-p/hmacKeys", "CreateHMACKey"},
      {"GET", "https://storage.googleapis.com/storage/v1/projects/my-p/hmacKeys", "ListHMACKeys"},
      {"GET", "https://storage.googleapis.com/storage/v1/projects/my-p/hmacKeys/k1", "GetHMACKey"},
      {
        "PUT",
        "https://storage.googleapis.com/storage/v1/projects/my-p/hmacKeys/k1",
        "UpdateHMACKey"
      },
      {
        "DELETE",
        "https://storage.googleapis.com/storage/v1/projects/my-p/hmacKeys/k1",
        "DeleteHMACKey"
      },
      {
        "GET",
        "https://storage.googleapis.com/storage/v1/projects/my-p/serviceAccount",
        "GetServiceAccount"
      },
      {"POST", "https://storage.googleapis.com/my-b/my-obj?uploadType=resumable", "WriteObject"},
      {"PUT", "https://my-b.storage.googleapis.com/my-obj?upload_id=u1", "WriteObject"},
      {"GET", "https://storage.googleapis.com/my-b/my-obj?uploadId=u1", "UNKNOWN"},
      {"GET", "https://storage.googleapis.com/", "UNKNOWN"},
    };

    for (String[] testCase : cases) {
      String method = testCase[0];
      String url = testCase[1];
      String expectedOp = testCase[2];
      GenericUrl genericUrl = new GenericUrl(url);
      HttpRequest request = factory.buildRequest(method, genericUrl, null);
      String urlTemplate = StorageHttpMetricsInterceptor.extractUrlTemplate(genericUrl);
      assertWithMessage("%s %s", method, url)
          .that(StorageHttpMetricsInterceptor.resolveOperationName(request, urlTemplate))
          .isEqualTo(expectedOp);
    }

    // Verify X-HTTP-Method-Override (applied by MethodOverride on NetHttpTransport for PATCH and
    // >2048-char GET URLs) resolves to the logical HTTP method rather than wire POST.
    String[][] overrideCases = {
      {"PATCH", "https://storage.googleapis.com/storage/v1/b/my-b", "UpdateBucket"},
      {"PATCH", "https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj", "UpdateObject"},
      {"GET", "https://storage.googleapis.com/storage/v1/b/my-b/o", "ListObjects"},
      {"GET", "https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj?alt=media", "ReadObject"},
    };
    for (String[] testCase : overrideCases) {
      String logicalMethod = testCase[0];
      String url = testCase[1];
      String expectedOp = testCase[2];
      GenericUrl genericUrl = new GenericUrl(url);
      HttpRequest request = factory.buildPostRequest(genericUrl, null);
      request.getHeaders().set("X-HTTP-Method-Override", logicalMethod);
      String urlTemplate = StorageHttpMetricsInterceptor.extractUrlTemplate(genericUrl);
      assertWithMessage("override=%s %s", logicalMethod, url)
          .that(StorageHttpMetricsInterceptor.resolveOperationName(request, urlTemplate))
          .isEqualTo(expectedOp);
    }

    GenericUrl bucketUrl = new GenericUrl("https://storage.googleapis.com/storage/v1/b/my-b");
    HttpRequest bucketGet = factory.buildGetRequest(bucketUrl);
    String bucketTemplate = StorageHttpMetricsInterceptor.extractUrlTemplate(bucketUrl);
    try (Scope ignore = StorageMetricsContext.create("UpdateBucket").makeCurrent()) {
      assertThat(StorageHttpMetricsInterceptor.resolveOperationName(bucketGet, bucketTemplate))
          .isEqualTo("UpdateBucket");
    }
    assertThat(StorageHttpMetricsInterceptor.resolveOperationName(bucketGet, bucketTemplate))
        .isEqualTo("GetBucket");
  }

  @Test
  public void initialize_statusCodes_recordsDurationAndErrorType() throws IOException {
    Object[][] cases = {
      {
        308,
        "PUT",
        "https://storage.googleapis.com/upload/storage/v1/b/my-b/o?uploadType=resumable&upload_id=u1",
        "/upload/storage/v1/b/{bucket}/o",
        "OK",
        "WriteObject"
      },
      {
        503,
        "GET",
        "https://storage.googleapis.com/storage/v1/b/my-b",
        "/storage/v1/b/{bucket}",
        "UNAVAILABLE",
        "GetBucket"
      },
      {
        200,
        "GET",
        "https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj?alt=media",
        "/storage/v1/b/{bucket}/o/{object}",
        "OK",
        "ReadObject"
      },
    };

    for (Object[] testCase : cases) {
      int statusCode = (int) testCase[0];
      String method = (String) testCase[1];
      String url = (String) testCase[2];
      AtomicBoolean delegateCalled = new AtomicBoolean(false);
      AtomicBoolean execCalled = new AtomicBoolean(false);
      AtomicBoolean respCalled = new AtomicBoolean(false);
      HttpRequestInitializer delegate =
          request -> {
            delegateCalled.set(true);
            request.setInterceptor(req -> execCalled.set(true));
            request.setResponseInterceptor(
                resp -> {
                  clock.advanceNanos(50_000_000L);
                  respCalled.set(true);
                });
          };
      HttpRequestInitializer interceptor = httpOptions.decorateWithMetrics(delegate);

      HttpTransport transport = createAdvancingTransport(statusCode, 250_000_000L);
      HttpRequest request =
          transport
              .createRequestFactory(interceptor)
              .buildRequest(method, new GenericUrl(url), null);
      if (statusCode != 200) {
        request.setThrowExceptionOnExecuteError(false);
      }
      request.execute();

      assertWithMessage("status=%s", statusCode).that(delegateCalled.get()).isTrue();
      assertWithMessage("status=%s", statusCode).that(execCalled.get()).isTrue();
      assertWithMessage("status=%s", statusCode).that(respCalled.get()).isTrue();
    }

    List<HistogramPointData> points = durationPoints();
    assertThat(points).hasSize(cases.length);
    List<HistogramPointData> ttfb = ttfbPoints();
    assertThat(ttfb).hasSize(cases.length);

    for (Object[] testCase : cases) {
      long statusCode = (int) testCase[0];
      String expectedMethod = (String) testCase[1];
      String expectedTemplate = (String) testCase[3];
      String expectedErrorType = (String) testCase[4];
      String expectedOperation = (String) testCase[5];

      HistogramPointData point = findPointByStatus(points, statusCode);
      assertWithMessage("status=%s", statusCode).that(point.getCount()).isEqualTo(1L);
      assertWithMessage("status=%s", statusCode).that(point.getSum()).isWithin(1e-6).of(0.25);

      Attributes attrs = point.getAttributes();
      assertThat(attrs.get(StorageClientMetrics.KEY_GCP_CLIENT_SERVICE))
          .isEqualTo(StorageClientMetrics.SERVICE_STORAGE);
      assertThat(attrs.get(StorageClientMetrics.KEY_GCP_CLIENT_VERSION))
          .isEqualTo(StorageOptions.version());
      assertThat(attrs.get(StorageClientMetrics.KEY_GCP_CLIENT_ARTIFACT))
          .isEqualTo(StorageClientMetrics.ARTIFACT_STORAGE);
      assertThat(attrs.get(StorageClientMetrics.KEY_RPC_SYSTEM_NAME)).isEqualTo("http");
      assertThat(attrs.get(StorageClientMetrics.KEY_HTTP_REQUEST_METHOD)).isEqualTo(expectedMethod);
      assertThat(attrs.get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE))
          .isEqualTo(statusCode);
      assertThat(attrs.get(StorageClientMetrics.KEY_NETWORK_PATH))
          .isEqualTo(StorageClientMetrics.NETWORK_PATH_CLOUDPATH);
      assertThat(attrs.get(StorageClientMetrics.KEY_URL_TEMPLATE)).isEqualTo(expectedTemplate);
      assertThat(attrs.get(StorageClientMetrics.KEY_SERVER_ADDRESS))
          .isEqualTo("storage.googleapis.com");
      assertWithMessage("status=%s", statusCode)
          .that(attrs.get(StorageClientMetrics.KEY_ERROR_TYPE))
          .isEqualTo(expectedErrorType);

      HistogramPointData ttfbPoint = findTtfbPointByOperation(ttfb, expectedOperation);
      assertWithMessage("op=%s", expectedOperation).that(ttfbPoint.getCount()).isEqualTo(1L);
      assertWithMessage("op=%s", expectedOperation)
          .that(ttfbPoint.getSum())
          .isWithin(1e-6)
          .of(0.25);
      assertThat(ttfbPoint.getAttributes())
          .isEqualTo(
              Attributes.builder()
                  .put(
                      StorageClientMetrics.KEY_GCP_CLIENT_SERVICE,
                      StorageClientMetrics.SERVICE_STORAGE)
                  .put(StorageClientMetrics.KEY_GCP_CLIENT_VERSION, StorageOptions.version())
                  .put(
                      StorageClientMetrics.KEY_GCP_CLIENT_ARTIFACT,
                      StorageClientMetrics.ARTIFACT_STORAGE)
                  .put(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "http")
                  .put(StorageClientMetrics.KEY_GCP_STORAGE_OPERATION, expectedOperation)
                  .put(
                      StorageClientMetrics.KEY_NETWORK_PATH,
                      StorageClientMetrics.NETWORK_PATH_CLOUDPATH)
                  .put(StorageClientMetrics.KEY_SERVER_ADDRESS, "storage.googleapis.com")
                  .build());
    }
  }

  @Test
  public void initialize_altMediaAddedAfterBuildGetRequest_recordsTtfb() throws IOException {
    HttpRequestInitializer interceptor = httpOptions.decorateWithMetrics(null);

    HttpTransport transport = createAdvancingTransport(200, 120_000_000L);
    HttpRequest request =
        transport
            .createRequestFactory(interceptor)
            .buildGetRequest(
                new GenericUrl("https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj"));
    request.getUrl().put("alt", "media");
    request.execute();

    List<HistogramPointData> ttfb = ttfbPoints();
    assertThat(ttfb).hasSize(1);
    HistogramPointData ttfbPoint = ttfb.get(0);
    assertThat(ttfbPoint.getCount()).isEqualTo(1L);
    assertThat(ttfbPoint.getSum()).isWithin(1e-6).of(0.12);
    assertThat(ttfbPoint.getAttributes().get(StorageClientMetrics.KEY_GCP_STORAGE_OPERATION))
        .isEqualTo("ReadObject");
    assertThat(ttfbPoint.getAttributes().get(StorageClientMetrics.KEY_SERVER_ADDRESS))
        .isEqualTo("storage.googleapis.com");
    assertThat(retriesPoints()).isEmpty();
  }

  @Test
  public void initialize_unsuccessfulResponseHandlerReturnsFalseOn404_recordsOnce()
      throws IOException {
    AtomicBoolean handlerCalled = new AtomicBoolean(false);
    HttpRequestInitializer delegate =
        request ->
            request.setUnsuccessfulResponseHandler(
                (req, response, supportsRetry) -> {
                  handlerCalled.set(true);
                  return false;
                });
    StorageHttpMetricsInterceptor interceptor =
        new StorageHttpMetricsInterceptor(delegate, metrics, clock);

    HttpTransport transport = createAdvancingTransport(404, 80_000_000L);
    HttpRequest request =
        transport
            .createRequestFactory(interceptor)
            .buildGetRequest(
                new GenericUrl(
                    "https://storage.googleapis.com/download/storage/v1/b/my-b/o/missing-obj?alt=media"));
    request.setThrowExceptionOnExecuteError(false);
    request.execute();

    assertThat(handlerCalled.get()).isTrue();

    List<HistogramPointData> points = durationPoints();
    assertThat(points).hasSize(1);
    HistogramPointData point = points.get(0);
    assertThat(point.getCount()).isEqualTo(1L);
    assertThat(point.getSum()).isWithin(1e-6).of(0.08);
    Attributes attrs = point.getAttributes();
    assertThat(attrs.get(StorageClientMetrics.KEY_RPC_SYSTEM_NAME)).isEqualTo("http");
    assertThat(attrs.get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE)).isEqualTo(404L);
    assertThat(attrs.get(StorageClientMetrics.KEY_URL_TEMPLATE))
        .isEqualTo("/download/storage/v1/b/{bucket}/o/{object}");
    assertThat(attrs.get(StorageClientMetrics.KEY_ERROR_TYPE)).isEqualTo("NOT_FOUND");
    assertThat(attrs.get(StorageClientMetrics.KEY_SERVER_ADDRESS))
        .isEqualTo("storage.googleapis.com");

    List<HistogramPointData> ttfb = ttfbPoints();
    assertThat(ttfb).hasSize(1);
    HistogramPointData ttfbPoint = ttfb.get(0);
    assertThat(ttfbPoint.getCount()).isEqualTo(1L);
    assertThat(ttfbPoint.getSum()).isWithin(1e-6).of(0.08);
    assertThat(ttfbPoint.getAttributes().get(StorageClientMetrics.KEY_GCP_STORAGE_OPERATION))
        .isEqualTo("ReadObject");
    assertThat(ttfbPoint.getAttributes().get(StorageClientMetrics.KEY_SERVER_ADDRESS))
        .isEqualTo("storage.googleapis.com");
    assertThat(retriesPoints()).isEmpty();
  }

  @Test
  public void initialize_ioExceptionThenRetrySucceeds_recordsTwoPoints() throws IOException {
    AtomicBoolean firstAttempt = new AtomicBoolean(true);
    HttpRequestInitializer retryDelegate =
        request -> request.setIOExceptionHandler((req, supportsRetry) -> true);
    StorageHttpMetricsInterceptor interceptor =
        new StorageHttpMetricsInterceptor(retryDelegate, metrics, clock);

    HttpTransport transport =
        new MockHttpTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) {
            return new MockLowLevelHttpRequest() {
              @Override
              public LowLevelHttpResponse execute() throws IOException {
                if (firstAttempt.compareAndSet(true, false)) {
                  clock.advanceNanos(100_000_000L);
                  throw new IOException("Connection reset by peer");
                }
                clock.advanceNanos(200_000_000L);
                MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
                response.setStatusCode(200);
                return response;
              }
            };
          }
        };

    HttpRequest req =
        transport
            .createRequestFactory(interceptor)
            .buildGetRequest(new GenericUrl("https://storage.googleapis.com/storage/v1/b/my-b"));
    req.execute();

    List<HistogramPointData> points = durationPoints();
    assertThat(points).hasSize(2);

    HistogramPointData errorPoint = findPointByStatus(points, 0L);
    assertThat(errorPoint.getSum()).isWithin(1e-6).of(0.10);
    assertThat(errorPoint.getAttributes().get(StorageClientMetrics.KEY_RPC_SYSTEM_NAME))
        .isEqualTo("http");
    assertThat(errorPoint.getAttributes().get(StorageClientMetrics.KEY_SERVER_ADDRESS))
        .isEqualTo("storage.googleapis.com");
    assertThat(errorPoint.getAttributes().get(StorageClientMetrics.KEY_ERROR_TYPE))
        .isEqualTo(StorageErrorTypeMapper.STATUS_CONNECTION_ERROR);

    HistogramPointData okPoint = findPointByStatus(points, 200L);
    assertThat(okPoint.getSum()).isWithin(1e-6).of(0.20);
    assertThat(okPoint.getAttributes().get(StorageClientMetrics.KEY_ERROR_TYPE))
        .isEqualTo(StorageErrorTypeMapper.STATUS_OK);

    List<HistogramPointData> ttfb = ttfbPoints();
    assertThat(ttfb).hasSize(1);
    HistogramPointData ttfbPoint = ttfb.get(0);
    assertThat(ttfbPoint.getCount()).isEqualTo(1L);
    assertThat(ttfbPoint.getSum()).isWithin(1e-6).of(0.20);
    assertThat(ttfbPoint.getAttributes().get(StorageClientMetrics.KEY_GCP_STORAGE_OPERATION))
        .isEqualTo("GetBucket");

    List<LongPointData> retries = retriesPoints();
    assertThat(retries).hasSize(1);
    assertThat(retries.get(0).getValue()).isEqualTo(1L);
    assertThat(retries.get(0).getAttributes())
        .isEqualTo(
            expectedRetryAttributes("GetBucket", StorageErrorTypeMapper.STATUS_CONNECTION_ERROR));
  }

  @Test
  public void initialize_401RefreshRetryThen200_recordsBothAttempts() throws IOException {
    AtomicBoolean firstAttempt = new AtomicBoolean(true);
    HttpRequestInitializer refreshDelegate =
        request ->
            request.setUnsuccessfulResponseHandler(
                (req, response, supportsRetry) -> {
                  if (response.getStatusCode() == 401) {
                    // Simulate token refresh latency inside the UnsuccessfulResponseHandler;
                    // the 401 request duration and TTFB must be captured before this handler runs.
                    clock.advanceNanos(200_000_000L);
                    return true;
                  }
                  return false;
                });
    StorageHttpMetricsInterceptor interceptor =
        new StorageHttpMetricsInterceptor(refreshDelegate, metrics, clock);

    HttpTransport transport =
        new MockHttpTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) {
            return new MockLowLevelHttpRequest() {
              @Override
              public LowLevelHttpResponse execute() {
                MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
                if (firstAttempt.compareAndSet(true, false)) {
                  clock.advanceNanos(90_000_000L);
                  response.setStatusCode(401);
                } else {
                  clock.advanceNanos(180_000_000L);
                  response.setStatusCode(200);
                }
                return response;
              }
            };
          }
        };

    HttpRequest req =
        transport
            .createRequestFactory(interceptor)
            .buildGetRequest(
                new GenericUrl(
                    "https://storage.googleapis.com/download/storage/v1/b/my-b/o/my-obj?alt=media"));
    req.execute();

    List<HistogramPointData> points = durationPoints();
    assertThat(points).hasSize(2);

    HistogramPointData unauthorizedPoint = findPointByStatus(points, 401L);
    assertThat(unauthorizedPoint.getSum()).isWithin(1e-6).of(0.09);
    assertThat(unauthorizedPoint.getAttributes().get(StorageClientMetrics.KEY_URL_TEMPLATE))
        .isEqualTo("/download/storage/v1/b/{bucket}/o/{object}");
    assertThat(unauthorizedPoint.getAttributes().get(StorageClientMetrics.KEY_ERROR_TYPE))
        .isEqualTo("UNAUTHENTICATED");

    HistogramPointData okPoint = findPointByStatus(points, 200L);
    assertThat(okPoint.getSum()).isWithin(1e-6).of(0.18);
    assertThat(okPoint.getAttributes().get(StorageClientMetrics.KEY_URL_TEMPLATE))
        .isEqualTo("/download/storage/v1/b/{bucket}/o/{object}");
    assertThat(okPoint.getAttributes().get(StorageClientMetrics.KEY_ERROR_TYPE))
        .isEqualTo(StorageErrorTypeMapper.STATUS_OK);

    List<HistogramPointData> ttfb = ttfbPoints();
    assertThat(ttfb).hasSize(1);
    HistogramPointData ttfbPoint = ttfb.get(0);
    assertThat(ttfbPoint.getCount()).isEqualTo(2L);
    assertThat(ttfbPoint.getSum()).isWithin(1e-6).of(0.27);
    assertThat(ttfbPoint.getAttributes().get(StorageClientMetrics.KEY_GCP_STORAGE_OPERATION))
        .isEqualTo("ReadObject");
    assertThat(ttfbPoint.getAttributes().get(StorageClientMetrics.KEY_SERVER_ADDRESS))
        .isEqualTo("storage.googleapis.com");

    List<LongPointData> retries = retriesPoints();
    assertThat(retries).hasSize(1);
    assertThat(retries.get(0).getValue()).isEqualTo(1L);
    assertThat(retries.get(0).getAttributes())
        .isEqualTo(expectedRetryAttributes("ReadObject", "UNAUTHENTICATED"));
  }

  @Test
  public void initialize_supportsRetryFalse_doesNotRecordRetry() throws IOException {
    HttpRequestInitializer delegate =
        request -> {
          request.setUnsuccessfulResponseHandler((req, response, supportsRetry) -> true);
          request.setIOExceptionHandler((req, supportsRetry) -> true);
        };
    StorageHttpMetricsInterceptor interceptor =
        new StorageHttpMetricsInterceptor(delegate, metrics, clock);

    // 401 where handler returns true (like HttpCredentialsAdapter) but retries are exhausted.
    HttpTransport unauthorizedTransport = createAdvancingTransport(401, 50_000_000L);
    HttpRequest req401 =
        unauthorizedTransport
            .createRequestFactory(interceptor)
            .buildGetRequest(new GenericUrl("https://storage.googleapis.com/storage/v1/b/my-b"));
    req401.setNumberOfRetries(0);
    req401.setThrowExceptionOnExecuteError(false);
    req401.execute();

    // IOException where handler returns true but retries are exhausted.
    HttpTransport ioTransport =
        new MockHttpTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) {
            return new MockLowLevelHttpRequest() {
              @Override
              public LowLevelHttpResponse execute() throws IOException {
                clock.advanceNanos(50_000_000L);
                throw new IOException("connection reset");
              }
            };
          }
        };
    HttpRequest reqIo =
        ioTransport
            .createRequestFactory(interceptor)
            .buildGetRequest(new GenericUrl("https://storage.googleapis.com/storage/v1/b/my-b"));
    reqIo.setNumberOfRetries(0);
    assertThrows(IOException.class, reqIo::execute);

    assertThat(durationPoints()).hasSize(2);
    assertThat(retriesPoints()).isEmpty();
  }

  @Test
  public void initialize_batchPart401_doesNotRecordPartDuration() throws IOException {
    AtomicBoolean refreshHandlerCalled = new AtomicBoolean(false);
    AtomicBoolean partSucceeded = new AtomicBoolean(false);
    AtomicBoolean firstBatch = new AtomicBoolean(true);

    HttpRequestInitializer refreshDelegate =
        request ->
            request.setUnsuccessfulResponseHandler(
                (req, response, supportsRetry) -> {
                  if (response.getStatusCode() == 401) {
                    refreshHandlerCalled.set(true);
                    return true;
                  }
                  return false;
                });
    StorageHttpMetricsInterceptor partInterceptor =
        new StorageHttpMetricsInterceptor(refreshDelegate, metrics, clock);
    StorageHttpMetricsInterceptor batchInterceptor =
        new StorageHttpMetricsInterceptor(null, metrics, clock);

    HttpTransport transport =
        new MockHttpTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) {
            return new MockLowLevelHttpRequest() {
              @Override
              public LowLevelHttpResponse execute() {
                clock.advanceNanos(100_000_000L);
                String partStatusLine =
                    firstBatch.compareAndSet(true, false)
                        ? "HTTP/1.1 401 Unauthorized"
                        : "HTTP/1.1 200 OK";
                String body =
                    "--batch_boundary\r\n"
                        + "Content-Type: application/http\r\n"
                        + "\r\n"
                        + partStatusLine
                        + "\r\n"
                        + "\r\n"
                        + "--batch_boundary--\r\n";
                MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
                response.setStatusCode(200);
                response.setContentType("multipart/mixed; boundary=batch_boundary");
                response.setContent(body);
                return response;
              }
            };
          }
        };

    HttpRequest partRequest =
        transport
            .createRequestFactory(partInterceptor)
            .buildGetRequest(
                new GenericUrl("https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj"));

    BatchRequest batchRequest = new BatchRequest(transport, batchInterceptor);
    batchRequest.setBatchUrl(new GenericUrl("https://storage.googleapis.com/batch/storage/v1"));
    batchRequest.setSleeper(millis -> {});
    batchRequest.queue(
        partRequest,
        Void.class,
        Void.class,
        new BatchCallback<Void, Void>() {
          @Override
          public void onSuccess(Void t, HttpHeaders responseHeaders) {
            partSucceeded.set(true);
          }

          @Override
          public void onFailure(Void e, HttpHeaders responseHeaders) {
            throw new AssertionError("Expected retried batch part to succeed");
          }
        });

    batchRequest.execute();

    assertThat(refreshHandlerCalled.get()).isTrue();
    assertThat(partSucceeded.get()).isTrue();

    List<HistogramPointData> points = durationPoints();
    assertThat(points).hasSize(1);
    HistogramPointData point = points.get(0);
    assertThat(point.getCount()).isEqualTo(2L);
    assertThat(point.getSum()).isWithin(1e-6).of(0.20);
    Attributes attrs = point.getAttributes();
    assertThat(attrs.get(StorageClientMetrics.KEY_URL_TEMPLATE)).isEqualTo("/batch/storage/v1");
    assertThat(attrs.get(StorageClientMetrics.KEY_HTTP_REQUEST_METHOD)).isEqualTo("POST");
    assertThat(attrs.get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE)).isEqualTo(200L);
    assertThat(attrs.get(StorageClientMetrics.KEY_ERROR_TYPE))
        .isEqualTo(StorageErrorTypeMapper.STATUS_OK);

    List<HistogramPointData> ttfb = ttfbPoints();
    assertThat(ttfb).hasSize(1);
    HistogramPointData batchTtfb = findTtfbPointByOperation(ttfb, "Batch");
    assertThat(batchTtfb.getCount()).isEqualTo(2L);
    assertThat(batchTtfb.getSum()).isWithin(1e-6).of(0.20);
    assertThat(retriesPoints()).isEmpty();
  }

  @Test
  public void endToEnd_storageImplUnaryAndResumableWrite_recordsHttpTtfb() throws Exception {
    byte[] directPayload = "hello".getBytes(StandardCharsets.UTF_8);
    byte[] resumablePayload = new byte[300 * 1024];
    String uploadId =
        "https://storage.googleapis.com/upload/storage/v1/b/my-b/o?uploadType=resumable&upload_id=session-1";
    String traceId = "0123456789abcdef0123456789abcdef";
    String spanId = "0123456789abcdef";
    Context tracedContext =
        Context.root()
            .with(
                Span.wrap(
                    SpanContext.create(
                        traceId, spanId, TraceFlags.getSampled(), TraceState.getDefault())));

    HttpTransport transport =
        new MockHttpTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) {
            return new MockLowLevelHttpRequest(url) {
              @Override
              public LowLevelHttpResponse execute() {
                clock.advanceNanos(100_000_000L);
                MockLowLevelHttpResponse resp = new MockLowLevelHttpResponse();
                if ("GET".equals(method) && url.contains("/storage/v1/b/my-b")) {
                  resp.setStatusCode(200);
                  resp.setContentType("application/json; charset=UTF-8");
                  resp.setContent("{\"name\":\"my-b\"}");
                } else if ("POST".equals(method) && url.contains("uploadType=multipart")) {
                  resp.setStatusCode(200);
                  resp.setContentType("application/json; charset=UTF-8");
                  resp.setContent(
                      "{\"bucket\":\"my-b\",\"name\":\"direct.txt\",\"size\":\""
                          + directPayload.length
                          + "\"}");
                } else if ("POST".equals(method) && url.contains("uploadType=resumable")) {
                  resp.setStatusCode(200);
                  resp.addHeader("Location", uploadId);
                } else if ("PUT".equals(method) && url.contains("upload_id=session-1")) {
                  String contentRange = getFirstHeaderValue("Content-Range");
                  if (contentRange != null && contentRange.endsWith("/*")) {
                    resp.setStatusCode(308);
                    resp.addHeader("Range", "bytes=0-262143");
                  } else {
                    resp.setStatusCode(200);
                    resp.setContentType("application/json; charset=UTF-8");
                    resp.addHeader("Content-Type", "application/json; charset=UTF-8");
                    resp.setContent(
                        "{\"bucket\":\"my-b\",\"name\":\"resumable.txt\",\"size\":\""
                            + resumablePayload.length
                            + "\"}");
                  }
                } else {
                  throw new AssertionError("Unexpected request: " + method + " " + url);
                }
                return resp;
              }
            };
          }
        };

    try (Storage storage =
        httpOptions.toBuilder()
            .setTransportOptions(
                HttpTransportOptions.newBuilder().setHttpTransportFactory(() -> transport).build())
            .setRetrySettings(ServiceOptions.getNoRetrySettings())
            .build()
            .getService()) {
      // 1. Unmodified BucketInfo.update executes GET /storage/v1/b/my-b with "UpdateBucket" context
      // and propagates the active trace exemplar through StorageMetricsContext.makeCurrent().
      try (Scope ignore = tracedContext.makeCurrent()) {
        Bucket updated = storage.update(BucketInfo.of("my-b"));
        assertThat(updated.getName()).isEqualTo("my-b");
      }

      // 2. Direct upload executes multipart POST
      Blob created =
          storage.create(BlobInfo.newBuilder("my-b", "direct.txt").build(), directPayload);
      assertThat(created.getName()).isEqualTo("direct.txt");

      // 3. Resumable upload executes open POST + 256 KiB chunk PUT (308) + final PUT (200)
      try (WriteChannel writer =
          storage.writer(BlobInfo.newBuilder("my-b", "resumable.txt").build())) {
        writer.setChunkSize(256 * 1024);
        writer.write(ByteBuffer.wrap(resumablePayload));
      }

      List<HistogramPointData> ttfb = ttfbPoints();
      assertThat(ttfb).hasSize(2);

      HistogramPointData updateBucketTtfb = findTtfbPointByOperation(ttfb, "UpdateBucket");
      assertThat(updateBucketTtfb.getCount()).isEqualTo(1L);
      assertThat(updateBucketTtfb.getSum()).isWithin(1e-6).of(0.10);
      assertThat(updateBucketTtfb.getExemplars()).isNotEmpty();
      DoubleExemplarData exemplar = (DoubleExemplarData) updateBucketTtfb.getExemplars().get(0);
      assertThat(exemplar.getSpanContext().getTraceId()).isEqualTo(traceId);
      assertThat(exemplar.getSpanContext().getSpanId()).isEqualTo(spanId);

      HistogramPointData writeObjectTtfb = findTtfbPointByOperation(ttfb, "WriteObject");
      assertThat(writeObjectTtfb.getCount()).isEqualTo(4L);
      assertThat(writeObjectTtfb.getSum()).isWithin(1e-6).of(0.40);
    }
  }

  private List<HistogramPointData> durationPoints() {
    return histogramPoints(StorageClientMetrics.METRIC_HTTP_CLIENT_REQUEST_DURATION);
  }

  private List<HistogramPointData> ttfbPoints() {
    return histogramPoints(StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_TTFB);
  }

  private List<LongPointData> retriesPoints() {
    return reader.collectAllMetrics().stream()
        .filter(m -> m.getName().equals(StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_RETRIES))
        .findFirst()
        .map(m -> ImmutableList.copyOf(m.getLongSumData().getPoints()))
        .orElse(ImmutableList.of());
  }

  private static Attributes expectedRetryAttributes(String operationName, String errorType) {
    return Attributes.builder()
        .put(StorageClientMetrics.KEY_GCP_CLIENT_SERVICE, StorageClientMetrics.SERVICE_STORAGE)
        .put(StorageClientMetrics.KEY_GCP_CLIENT_VERSION, StorageOptions.version())
        .put(StorageClientMetrics.KEY_GCP_CLIENT_ARTIFACT, StorageClientMetrics.ARTIFACT_STORAGE)
        .put(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "http")
        .put(StorageClientMetrics.KEY_SERVER_ADDRESS, "storage.googleapis.com")
        .put(StorageClientMetrics.KEY_GCP_STORAGE_OPERATION, operationName)
        .put(StorageClientMetrics.KEY_NETWORK_PATH, StorageClientMetrics.NETWORK_PATH_CLOUDPATH)
        .put(StorageClientMetrics.KEY_ERROR_TYPE, errorType)
        .build();
  }

  private List<HistogramPointData> histogramPoints(String metricName) {
    return reader.collectAllMetrics().stream()
        .filter(m -> m.getName().equals(metricName))
        .findFirst()
        .map(m -> ImmutableList.copyOf(m.getHistogramData().getPoints()))
        .orElse(ImmutableList.of());
  }

  private static HistogramPointData findPointByStatus(
      List<HistogramPointData> points, long statusCode) {
    return points.stream()
        .filter(
            p ->
                Objects.equals(
                    p.getAttributes().get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE),
                    statusCode))
        .findFirst()
        .orElseThrow(() -> new AssertionError("No point for status " + statusCode));
  }

  private static HistogramPointData findTtfbPointByOperation(
      List<HistogramPointData> points, String operationName) {
    return points.stream()
        .filter(
            p ->
                Objects.equals(
                    p.getAttributes().get(StorageClientMetrics.KEY_GCP_STORAGE_OPERATION),
                    operationName))
        .findFirst()
        .orElseThrow(() -> new AssertionError("No TTFB point for operation " + operationName));
  }

  private HttpTransport createAdvancingTransport(int statusCode, long advanceNanos) {
    return new MockHttpTransport() {
      @Override
      public LowLevelHttpRequest buildRequest(String method, String url) {
        return new MockLowLevelHttpRequest() {
          @Override
          public LowLevelHttpResponse execute() {
            clock.advanceNanos(advanceNanos);
            MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
            response.setStatusCode(statusCode);
            return response;
          }
        };
      }
    };
  }

  private static final class FakeClock implements ApiClock {
    private final AtomicLong nanos = new AtomicLong(1_000_000_000L);

    @Override
    public long nanoTime() {
      return nanos.get();
    }

    @Override
    public long millisTime() {
      return nanos.get() / 1_000_000L;
    }

    void advanceNanos(long amount) {
      nanos.addAndGet(amount);
    }
  }
}
