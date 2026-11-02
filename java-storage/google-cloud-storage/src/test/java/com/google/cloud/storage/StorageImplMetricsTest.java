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

import static com.google.cloud.storage.StorageClientMetrics.KEY_ERROR_TYPE;
import static com.google.cloud.storage.StorageClientMetrics.KEY_GCP_STORAGE_OPERATION;
import static com.google.cloud.storage.StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS;
import static com.google.cloud.storage.StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_OPERATIONS;
import static com.google.cloud.storage.StorageErrorTypeMapper.STATUS_NOT_FOUND;
import static com.google.cloud.storage.StorageErrorTypeMapper.STATUS_OK;
import static com.google.cloud.storage.StorageErrorTypeMapper.STATUS_UNAVAILABLE;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.when;

import com.google.api.core.SettableApiFuture;
import com.google.api.gax.paging.Page;
import com.google.api.services.storage.model.BucketAccessControl;
import com.google.api.services.storage.model.ObjectAccessControl;
import com.google.api.services.storage.model.StorageObject;
import com.google.cloud.ReadChannel;
import com.google.cloud.RestorableState;
import com.google.cloud.ServiceOptions;
import com.google.cloud.Tuple;
import com.google.cloud.WriteChannel;
import com.google.cloud.storage.Acl.User;
import com.google.cloud.storage.BufferedWritableByteChannelSession.BufferedWritableByteChannel;
import com.google.cloud.storage.UnifiedOpts.Opts;
import com.google.cloud.storage.spi.StorageRpcFactory;
import com.google.cloud.storage.spi.v1.StorageRpc;
import com.google.common.collect.ImmutableList;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.data.LongPointData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class StorageImplMetricsTest {

  private static final String BUCKET_NAME = "b1";
  private static final String BLOB_NAME = "n1";
  private static final BlobId BLOB_ID = BlobId.of(BUCKET_NAME, BLOB_NAME, 123L);
  private static final BlobInfo BLOB_INFO = BlobInfo.newBuilder(BUCKET_NAME, BLOB_NAME).build();
  private static final BlobInfo RESULT_INFO =
      BlobInfo.newBuilder(BUCKET_NAME, BLOB_NAME).setContentType("type").build();
  private static final Acl.Entity ACL_ENTITY = new User("user@example.com");

  private HttpStorageOptions options;
  private StorageRpcFactory rpcFactoryMock;
  private StorageRpc storageRpcMock;

  @Before
  public void setUp() {
    rpcFactoryMock = Mockito.mock(StorageRpcFactory.class);
    storageRpcMock = Mockito.mock(StorageRpc.class);
    when(rpcFactoryMock.create(any(StorageOptions.class))).thenReturn(storageRpcMock);
    options =
        HttpStorageOptions.newBuilder()
            .setProjectId("projectid")
            .setServiceRpcFactory(rpcFactoryMock)
            .setRetrySettings(ServiceOptions.getNoRetrySettings())
            .build();
  }

  @Test
  public void testReadChannelPreservesReadFailureOnClose() throws Exception {
    InMemoryMetricReader metricReader = InMemoryMetricReader.create();
    SdkMeterProvider meterProvider =
        SdkMeterProvider.builder().registerMetricReader(metricReader).build();
    StorageClientMetrics clientMetrics = StorageClientMetrics.create(meterProvider, true, false);
    StorageMetricsContext metricsContext =
        StorageClientMetrics.createMultiStepContext(clientMetrics, "ReadObject");

    @SuppressWarnings("unchecked")
    ReadableByteChannelSession<ReadableByteChannel, StorageObject> sessionMock =
        Mockito.mock(ReadableByteChannelSession.class);
    ReadableByteChannel channelMock = Mockito.mock(ReadableByteChannel.class);
    when(sessionMock.open()).thenReturn(channelMock);
    when(sessionMock.getResult()).thenReturn(SettableApiFuture.create());
    when(channelMock.isOpen()).thenReturn(true);
    when(channelMock.read(any(ByteBuffer.class))).thenThrow(new StorageException(404, "Not Found"));

    BaseStorageReadChannel<StorageObject> readChannel =
        new BaseStorageReadChannel<StorageObject>(
            Conversions.json().blobInfo(), metricsContext, clientMetrics) {
          @Override
          public RestorableState<ReadChannel> capture() {
            return null;
          }

          @Override
          protected LazyReadChannel<?, StorageObject> newLazyReadChannel() {
            return new LazyReadChannel<>(() -> sessionMock);
          }
        };

    assertThrows(IOException.class, () -> readChannel.read(ByteBuffer.allocate(16)));
    readChannel.close();

    Collection<MetricData> metrics = metricReader.collectAllMetrics();
    assertThat(
            getCounterValueWithAttr(
                metrics, METRIC_GCP_STORAGE_CLIENT_OPERATIONS, KEY_ERROR_TYPE, STATUS_NOT_FOUND))
        .isEqualTo(1L);
    assertThat(
            getCounterValueWithAttr(
                metrics, METRIC_GCP_STORAGE_CLIENT_OPERATIONS, KEY_ERROR_TYPE, STATUS_OK))
        .isEqualTo(0L);
  }

  @Test
  public void testReadChannel416TreatedAsNormalEofOnClose() throws Exception {
    InMemoryMetricReader metricReader = InMemoryMetricReader.create();
    SdkMeterProvider meterProvider =
        SdkMeterProvider.builder().registerMetricReader(metricReader).build();
    StorageClientMetrics clientMetrics = StorageClientMetrics.create(meterProvider, true, false);
    StorageMetricsContext metricsContext =
        StorageClientMetrics.createMultiStepContext(clientMetrics, "ReadObject");

    @SuppressWarnings("unchecked")
    ReadableByteChannelSession<ReadableByteChannel, StorageObject> sessionMock =
        Mockito.mock(ReadableByteChannelSession.class);
    ReadableByteChannel channelMock = Mockito.mock(ReadableByteChannel.class);
    when(sessionMock.open()).thenReturn(channelMock);
    when(sessionMock.getResult()).thenReturn(SettableApiFuture.create());
    when(channelMock.isOpen()).thenReturn(true);
    when(channelMock.read(any(ByteBuffer.class)))
        .thenThrow(new StorageException(416, "Range Not Satisfiable"));

    BaseStorageReadChannel<StorageObject> readChannel =
        new BaseStorageReadChannel<StorageObject>(
            Conversions.json().blobInfo(), metricsContext, clientMetrics) {
          @Override
          public RestorableState<ReadChannel> capture() {
            return null;
          }

          @Override
          protected LazyReadChannel<?, StorageObject> newLazyReadChannel() {
            return new LazyReadChannel<>(() -> sessionMock);
          }
        };

    assertThat(readChannel.read(ByteBuffer.allocate(16))).isEqualTo(-1);
    readChannel.close();

    Collection<MetricData> metrics = metricReader.collectAllMetrics();
    assertThat(
            getCounterValueWithAttr(
                metrics, METRIC_GCP_STORAGE_CLIENT_OPERATIONS, KEY_ERROR_TYPE, STATUS_OK))
        .isEqualTo(1L);
  }

  @Test
  public void testWriteChannelPreservesWriteFailureOnClose() throws Exception {
    InMemoryMetricReader metricReader = InMemoryMetricReader.create();
    SdkMeterProvider meterProvider =
        SdkMeterProvider.builder().registerMetricReader(metricReader).build();
    StorageClientMetrics clientMetrics = StorageClientMetrics.create(meterProvider, true, false);
    StorageMetricsContext metricsContext =
        StorageClientMetrics.createMultiStepContext(clientMetrics, "WriteObject");

    @SuppressWarnings("unchecked")
    BufferedWritableByteChannelSession<StorageObject> sessionMock =
        Mockito.mock(BufferedWritableByteChannelSession.class);
    BufferedWritableByteChannel channelMock = Mockito.mock(BufferedWritableByteChannel.class);
    when(sessionMock.open()).thenReturn(channelMock);
    when(sessionMock.getResult()).thenReturn(SettableApiFuture.create());
    when(channelMock.isOpen()).thenReturn(true);
    when(channelMock.write(any(ByteBuffer.class)))
        .thenThrow(new StorageException(503, "Service Unavailable"));

    BaseStorageWriteChannel<StorageObject> writeChannel =
        new BaseStorageWriteChannel<StorageObject>(
            Conversions.json().blobInfo(), metricsContext, clientMetrics) {
          @Override
          public RestorableState<WriteChannel> capture() {
            return null;
          }

          @Override
          protected LazyWriteChannel<StorageObject> newLazyWriteChannel() {
            return new LazyWriteChannel<>(() -> sessionMock);
          }
        };

    assertThrows(IOException.class, () -> writeChannel.write(ByteBuffer.wrap(new byte[] {1, 2})));
    writeChannel.close();

    Collection<MetricData> metrics = metricReader.collectAllMetrics();
    assertThat(
            getCounterValueWithAttr(
                metrics, METRIC_GCP_STORAGE_CLIENT_OPERATIONS, KEY_ERROR_TYPE, STATUS_UNAVAILABLE))
        .isEqualTo(1L);
    assertThat(
            getCounterValueWithAttr(
                metrics, METRIC_GCP_STORAGE_CLIENT_OPERATIONS, KEY_ERROR_TYPE, STATUS_OK))
        .isEqualTo(0L);
  }

  @Test
  public void testStorageImplPaginationRecordsSingleOperationAcrossPages() {
    InMemoryMetricReader metricReader = InMemoryMetricReader.create();
    SdkMeterProvider meterProvider =
        SdkMeterProvider.builder().registerMetricReader(metricReader).build();
    HttpStorageOptions metricsOptions =
        options.toBuilder().setEnableOtelMetrics(true).setMeterProvider(meterProvider).build();
    Storage storage = metricsOptions.getService();

    StorageObject obj1 = Conversions.json().blobInfo().encode(BLOB_INFO);
    StorageObject obj2 = Conversions.json().blobInfo().encode(RESULT_INFO);
    when(storageRpcMock.list(eq(BUCKET_NAME), anyMap()))
        .thenReturn(Tuple.of("page-2", ImmutableList.of(obj1)))
        .thenReturn(Tuple.of(null, ImmutableList.of(obj2)));

    Page<Blob> firstPage = storage.list(BUCKET_NAME);
    Page<Blob> secondPage = firstPage.getNextPage();
    assertThat(secondPage).isNotNull();

    Collection<MetricData> metrics = metricReader.collectAllMetrics();
    assertThat(
            getCounterValueWithAttr(
                metrics,
                METRIC_GCP_STORAGE_CLIENT_OPERATIONS,
                KEY_GCP_STORAGE_OPERATION,
                "ListObjects"))
        .isEqualTo(1L);
    assertThat(
            getCounterValueWithAttr(
                metrics,
                METRIC_GCP_STORAGE_CLIENT_ATTEMPTS,
                KEY_GCP_STORAGE_OPERATION,
                "ListObjects"))
        .isEqualTo(2L);
  }

  @Test
  public void testStorageImplPcuSubOperationsDoNotEmitTopLevelOperations() {
    InMemoryMetricReader metricReader = InMemoryMetricReader.create();
    SdkMeterProvider meterProvider =
        SdkMeterProvider.builder().registerMetricReader(metricReader).build();
    HttpStorageOptions metricsOptions =
        options.toBuilder().setEnableOtelMetrics(true).setMeterProvider(meterProvider).build();
    StorageImpl storage = (StorageImpl) metricsOptions.getService();

    StorageObject encodedResult = Conversions.json().blobInfo().encode(RESULT_INFO);
    when(storageRpcMock.create(any(StorageObject.class), any(InputStream.class), anyMap()))
        .thenReturn(encodedResult);
    when(storageRpcMock.get(any(StorageObject.class), anyMap())).thenReturn(encodedResult);
    when(storageRpcMock.delete(any(StorageObject.class), anyMap())).thenReturn(true);

    storage.create(BLOB_INFO, new byte[] {1, 2, 3});
    storage.internalDirectUpload(BLOB_INFO, Opts.empty(), ByteBuffer.wrap(new byte[] {4, 5}));
    storage.internalObjectGet(BLOB_ID, Opts.empty());
    storage.internalObjectDelete(BLOB_ID, Opts.empty());

    Collection<MetricData> metrics = metricReader.collectAllMetrics();
    assertThat(
            getCounterValueWithAttr(
                metrics,
                METRIC_GCP_STORAGE_CLIENT_OPERATIONS,
                KEY_GCP_STORAGE_OPERATION,
                "WriteObject"))
        .isEqualTo(1L);
    assertThat(
            getCounterValueWithAttr(
                metrics,
                METRIC_GCP_STORAGE_CLIENT_OPERATIONS,
                KEY_GCP_STORAGE_OPERATION,
                "GetObject"))
        .isEqualTo(0L);
    assertThat(
            getCounterValueWithAttr(
                metrics,
                METRIC_GCP_STORAGE_CLIENT_OPERATIONS,
                KEY_GCP_STORAGE_OPERATION,
                "DeleteObject"))
        .isEqualTo(0L);
  }

  @Test
  public void testNullableGettersAndRestoreRecordNotFoundWhenRpcReturnsNull() {
    InMemoryMetricReader metricReader = InMemoryMetricReader.create();
    SdkMeterProvider meterProvider =
        SdkMeterProvider.builder().registerMetricReader(metricReader).build();
    HttpStorageOptions metricsOptions =
        options.toBuilder().setEnableOtelMetrics(true).setMeterProvider(meterProvider).build();
    Storage storage = metricsOptions.getService();

    when(storageRpcMock.get(any(com.google.api.services.storage.model.Bucket.class), anyMap()))
        .thenReturn(null);
    when(storageRpcMock.get(any(StorageObject.class), anyMap())).thenReturn(null);
    when(storageRpcMock.restore(any(StorageObject.class), anyMap())).thenReturn(null);
    when(storageRpcMock.getAcl(anyString(), anyString(), anyMap())).thenReturn(null);
    when(storageRpcMock.getDefaultAcl(anyString(), anyString())).thenReturn(null);
    when(storageRpcMock.getAcl(anyString(), anyString(), nullable(Long.class), anyString()))
        .thenReturn(null);
    when(storageRpcMock.getNotification(anyString(), anyString())).thenReturn(null);

    assertThat(storage.get(BUCKET_NAME)).isNull();
    assertThat(storage.get(BLOB_ID)).isNull();
    assertThat(storage.restore(BLOB_ID)).isNull();
    assertThat(storage.getAcl(BUCKET_NAME, ACL_ENTITY)).isNull();
    assertThat(storage.getDefaultAcl(BUCKET_NAME, ACL_ENTITY)).isNull();
    assertThat(storage.getAcl(BLOB_ID, ACL_ENTITY)).isNull();
    assertThat(storage.getNotification(BUCKET_NAME, "notif-1")).isNull();

    Collection<MetricData> metrics = metricReader.collectAllMetrics();
    assertOperationErrorType(metrics, "GetBucket", STATUS_NOT_FOUND, 1L);
    assertOperationErrorType(metrics, "GetObject", STATUS_NOT_FOUND, 1L);
    assertOperationErrorType(metrics, "RestoreObject", STATUS_NOT_FOUND, 1L);
    assertOperationErrorType(metrics, "GetBucketACL", STATUS_NOT_FOUND, 1L);
    assertOperationErrorType(metrics, "GetDefaultObjectACL", STATUS_NOT_FOUND, 1L);
    assertOperationErrorType(metrics, "GetObjectACL", STATUS_NOT_FOUND, 1L);
    assertOperationErrorType(metrics, "GetNotification", STATUS_NOT_FOUND, 1L);
    assertThat(
            getCounterValueWithAttr(
                metrics, METRIC_GCP_STORAGE_CLIENT_OPERATIONS, KEY_ERROR_TYPE, STATUS_OK))
        .isEqualTo(0L);
  }

  @Test
  public void testBooleanDeletesRecordNotFoundWhenRpcReturnsFalse() {
    InMemoryMetricReader metricReader = InMemoryMetricReader.create();
    SdkMeterProvider meterProvider =
        SdkMeterProvider.builder().registerMetricReader(metricReader).build();
    HttpStorageOptions metricsOptions =
        options.toBuilder().setEnableOtelMetrics(true).setMeterProvider(meterProvider).build();
    Storage storage = metricsOptions.getService();

    when(storageRpcMock.delete(any(com.google.api.services.storage.model.Bucket.class), anyMap()))
        .thenReturn(false);
    when(storageRpcMock.delete(any(StorageObject.class), anyMap())).thenReturn(false);
    when(storageRpcMock.deleteAcl(anyString(), anyString(), anyMap())).thenReturn(false);
    when(storageRpcMock.deleteDefaultAcl(anyString(), anyString())).thenReturn(false);
    when(storageRpcMock.deleteAcl(anyString(), anyString(), nullable(Long.class), anyString()))
        .thenReturn(false);
    when(storageRpcMock.deleteNotification(anyString(), anyString())).thenReturn(false);

    assertThat(storage.delete(BUCKET_NAME)).isFalse();
    assertThat(storage.delete(BLOB_ID)).isFalse();
    assertThat(storage.deleteAcl(BUCKET_NAME, ACL_ENTITY)).isFalse();
    assertThat(storage.deleteDefaultAcl(BUCKET_NAME, ACL_ENTITY)).isFalse();
    assertThat(storage.deleteAcl(BLOB_ID, ACL_ENTITY)).isFalse();
    assertThat(storage.deleteNotification(BUCKET_NAME, "notif-1")).isFalse();

    Collection<MetricData> metrics = metricReader.collectAllMetrics();
    assertOperationErrorType(metrics, "DeleteBucket", STATUS_NOT_FOUND, 1L);
    assertOperationErrorType(metrics, "DeleteObject", STATUS_NOT_FOUND, 1L);
    assertOperationErrorType(metrics, "DeleteBucketACL", STATUS_NOT_FOUND, 1L);
    assertOperationErrorType(metrics, "DeleteDefaultObjectACL", STATUS_NOT_FOUND, 1L);
    assertOperationErrorType(metrics, "DeleteObjectACL", STATUS_NOT_FOUND, 1L);
    assertOperationErrorType(metrics, "DeleteNotification", STATUS_NOT_FOUND, 1L);
    assertThat(
            getCounterValueWithAttr(
                metrics, METRIC_GCP_STORAGE_CLIENT_OPERATIONS, KEY_ERROR_TYPE, STATUS_OK))
        .isEqualTo(0L);
  }

  @Test
  public void testNullableGettersAndBooleanDeletesRecordOkOnFoundAndRecordExceptionOnThrow() {
    InMemoryMetricReader metricReader = InMemoryMetricReader.create();
    SdkMeterProvider meterProvider =
        SdkMeterProvider.builder().registerMetricReader(metricReader).build();
    HttpStorageOptions metricsOptions =
        options.toBuilder().setEnableOtelMetrics(true).setMeterProvider(meterProvider).build();
    Storage storage = metricsOptions.getService();

    StorageObject encodedResult = Conversions.json().blobInfo().encode(RESULT_INFO);
    BucketAccessControl bucketAclPb =
        new BucketAccessControl().setEntity("user-user@example.com").setRole("READER");
    ObjectAccessControl objectAclPb =
        new ObjectAccessControl().setEntity("user-user@example.com").setRole("READER");

    when(storageRpcMock.get(any(StorageObject.class), anyMap()))
        .thenReturn(encodedResult)
        .thenThrow(new StorageException(503, "Service Unavailable"));
    when(storageRpcMock.delete(any(StorageObject.class), anyMap()))
        .thenReturn(true)
        .thenThrow(new StorageException(503, "Service Unavailable"));
    when(storageRpcMock.getAcl(anyString(), anyString(), anyMap())).thenReturn(bucketAclPb);
    when(storageRpcMock.getAcl(anyString(), anyString(), nullable(Long.class), anyString()))
        .thenReturn(objectAclPb);

    assertThat(storage.get(BLOB_ID)).isNotNull();
    assertThat(storage.delete(BLOB_ID)).isTrue();
    assertThat(storage.getAcl(BUCKET_NAME, ACL_ENTITY)).isNotNull();
    assertThat(storage.getAcl(BLOB_ID, ACL_ENTITY)).isNotNull();
    assertThrows(StorageException.class, () -> storage.get(BLOB_ID));
    assertThrows(StorageException.class, () -> storage.delete(BLOB_ID));

    Collection<MetricData> metrics = metricReader.collectAllMetrics();
    assertOperationErrorType(metrics, "GetObject", STATUS_OK, 1L);
    assertOperationErrorType(metrics, "GetObject", STATUS_UNAVAILABLE, 1L);
    assertOperationErrorType(metrics, "DeleteObject", STATUS_OK, 1L);
    assertOperationErrorType(metrics, "DeleteObject", STATUS_UNAVAILABLE, 1L);
    assertOperationErrorType(metrics, "GetBucketACL", STATUS_OK, 1L);
    assertOperationErrorType(metrics, "GetObjectACL", STATUS_OK, 1L);
  }

  private static void assertOperationErrorType(
      Collection<MetricData> metrics,
      String operationName,
      String expectedErrorType,
      long expectedCount) {
    long actual = 0L;
    for (MetricData md : metrics) {
      if (md.getName().equals(METRIC_GCP_STORAGE_CLIENT_OPERATIONS)
          || md.getName().equals(METRIC_GCP_STORAGE_CLIENT_OPERATIONS.replace(".", "/"))) {
        actual +=
            md.getLongSumData().getPoints().stream()
                .filter(
                    p ->
                        operationName.equals(p.getAttributes().get(KEY_GCP_STORAGE_OPERATION))
                            && expectedErrorType.equals(p.getAttributes().get(KEY_ERROR_TYPE)))
                .mapToLong(LongPointData::getValue)
                .sum();
      }
    }
    assertThat(actual).isEqualTo(expectedCount);
  }

  private static long getCounterValueWithAttr(
      Collection<MetricData> metrics,
      String metricName,
      AttributeKey<String> key,
      String expectedValue) {
    for (MetricData md : metrics) {
      if (md.getName().equals(metricName) || md.getName().equals(metricName.replace(".", "/"))) {
        return md.getLongSumData().getPoints().stream()
            .filter(p -> expectedValue.equals(p.getAttributes().get(key)))
            .mapToLong(LongPointData::getValue)
            .sum();
      }
    }
    return 0L;
  }
}
