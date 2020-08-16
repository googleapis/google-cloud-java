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
package com.google.cloud.bigquery.storage.v1alpha2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.cloud.bigquery.storage.test.Test.*;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.threeten.bp.Instant;
import org.threeten.bp.temporal.ChronoUnit;

@RunWith(JUnit4.class)
public class JsonWriterCacheTest {
  private static final Logger LOG = Logger.getLogger(JsonWriterCacheTest.class.getName());

  private static final String TEST_TABLE = "projects/p/datasets/d/tables/t";
  private static final String TEST_STREAM = "projects/p/datasets/d/tables/t/streams/s";
  private static final String TEST_STREAM_2 = "projects/p/datasets/d/tables/t/streams/s2";
  private static final String TEST_STREAM_3 = "projects/p/datasets/d/tables/t/streams/s3";
  private static final String TEST_STREAM_4 = "projects/p/datasets/d/tables/t/streams/s4";
  private static final String TEST_TABLE_2 = "projects/p/datasets/d/tables/t2";
  private static final String TEST_STREAM_21 = "projects/p/datasets/d/tables/t2/streams/s1";
  private static final String TEST_TABLE_3 = "projects/p/datasets/d/tables/t3";
  private static final String TEST_STREAM_31 = "projects/p/datasets/d/tables/t3/streams/s1";

  private static MockBigQueryWrite mockBigQueryWrite;
  private static MockServiceHelper serviceHelper;
  @Mock private static SchemaCompatibility mockSchemaCheck;
  private BigQueryWriteClient client;
  private LocalChannelProvider channelProvider;

  private final Table.TableFieldSchema FOO =
      Table.TableFieldSchema.newBuilder()
          .setType(Table.TableFieldSchema.Type.STRING)
          .setMode(Table.TableFieldSchema.Mode.NULLABLE)
          .setName("foo")
          .build();
  private final Table.TableSchema TABLE_SCHEMA =
      Table.TableSchema.newBuilder().addFields(0, FOO).build();

  @BeforeClass
  public static void startStaticServer() {
    mockBigQueryWrite = new MockBigQueryWrite();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockBigQueryWrite));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    channelProvider = serviceHelper.createChannelProvider();
    BigQueryWriteSettings settings =
        BigQueryWriteSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = BigQueryWriteClient.create(settings);
    MockitoAnnotations.initMocks(this);
  }

  /** Response mocks for create a new writer */
  void WriterCreationResponseMock(String testStreamName) {
    // Response from CreateWriteStream
    Stream.WriteStream expectedResponse =
        Stream.WriteStream.newBuilder()
            .setName(testStreamName)
            .setTableSchema(TABLE_SCHEMA)
            .build();
    mockBigQueryWrite.addResponse(expectedResponse);

    // Response from GetWriteStream
    Instant time = Instant.now();
    Timestamp timestamp =
        Timestamp.newBuilder().setSeconds(time.getEpochSecond()).setNanos(time.getNano()).build();
    Stream.WriteStream expectedResponse2 =
        Stream.WriteStream.newBuilder()
            .setName(testStreamName)
            .setType(Stream.WriteStream.Type.COMMITTED)
            .setCreateTime(timestamp)
            .build();
    mockBigQueryWrite.addResponse(expectedResponse2);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void testRejectBadTableName() throws Exception {
    JsonWriterCache cache = JsonWriterCache.getTestInstance(client, 10);
    try {
      cache.getTableWriter("abc");
      fail();
    } catch (IllegalArgumentException expected) {
      assertEquals(expected.getMessage(), "Invalid table name: abc");
    }
  }

  @Test
  public void testCreateNewWriter() throws Exception {
    JsonWriterCache cache = JsonWriterCache.getTestInstance(client, 10);
    WriterCreationResponseMock(TEST_STREAM);
    JsonStreamWriter writer = cache.getTableWriter(TEST_TABLE);
    List<AbstractMessage> actualRequests = mockBigQueryWrite.getRequests();
    assertEquals(2, actualRequests.size());
    assertEquals(
        TEST_TABLE, ((Storage.CreateWriteStreamRequest) actualRequests.get(0)).getParent());
    assertEquals(
        Stream.WriteStream.Type.COMMITTED,
        ((Storage.CreateWriteStreamRequest) actualRequests.get(0)).getWriteStream().getType());
    assertEquals(TEST_STREAM, ((Storage.GetWriteStreamRequest) actualRequests.get(1)).getName());

    assertEquals(TEST_STREAM, writer.getStreamName());
    assertEquals(1, cache.cachedTableCount());
    cache.clear();
  }

  @Test
  public void testWriterExpired() throws Exception {
    JsonWriterCache cache = JsonWriterCache.getTestInstance(client, 10);
    // Response from CreateWriteStream
    Stream.WriteStream expectedResponse =
        Stream.WriteStream.newBuilder().setName(TEST_STREAM).build();
    mockBigQueryWrite.addResponse(expectedResponse);

    // Response from GetWriteStream
    Instant time = Instant.now().minus(2, ChronoUnit.DAYS);
    Timestamp timestamp =
        Timestamp.newBuilder().setSeconds(time.getEpochSecond()).setNanos(time.getNano()).build();
    Stream.WriteStream expectedResponse2 =
        Stream.WriteStream.newBuilder()
            .setName(TEST_STREAM)
            .setType(Stream.WriteStream.Type.COMMITTED)
            .setCreateTime(timestamp)
            .build();
    mockBigQueryWrite.addResponse(expectedResponse2);

    try {
      JsonStreamWriter writer = cache.getTableWriter(TEST_TABLE);
      fail("Should fail");
    } catch (IllegalStateException e) {
      assertEquals(
          "Cannot write to a stream that is already expired: projects/p/datasets/d/tables/t/streams/s",
          e.getMessage());
    }
    cache.clear();
  }

  @Test
  public void testWriterWithDifferentTable() throws Exception {
    JsonWriterCache cache = JsonWriterCache.getTestInstance(client, 2);
    WriterCreationResponseMock(TEST_STREAM);
    WriterCreationResponseMock(TEST_STREAM_21);
    JsonStreamWriter writer1 = cache.getTableWriter(TEST_TABLE);
    JsonStreamWriter writer2 = cache.getTableWriter(TEST_TABLE_2);

    List<AbstractMessage> actualRequests = mockBigQueryWrite.getRequests();
    assertEquals(4, actualRequests.size());
    assertEquals(
        TEST_TABLE, ((Storage.CreateWriteStreamRequest) actualRequests.get(0)).getParent());
    assertEquals(TEST_STREAM, ((Storage.GetWriteStreamRequest) actualRequests.get(1)).getName());
    assertEquals(
        TEST_TABLE_2, ((Storage.CreateWriteStreamRequest) actualRequests.get(2)).getParent());
    Assert.assertEquals(
        TEST_STREAM_21, ((Storage.GetWriteStreamRequest) actualRequests.get(3)).getName());
    assertEquals(TEST_STREAM, writer1.getStreamName());
    assertEquals(TEST_STREAM_21, writer2.getStreamName());
    assertEquals(2, cache.cachedTableCount());

    // Still able to get the FooType writer.
    JsonStreamWriter writer3 = cache.getTableWriter(TEST_TABLE_2);
    Assert.assertEquals(TEST_STREAM_21, writer3.getStreamName());

    // Create a writer with a even new schema.
    WriterCreationResponseMock(TEST_STREAM_31);
    WriterCreationResponseMock(TEST_STREAM);
    JsonStreamWriter writer4 = cache.getTableWriter(TEST_TABLE_3);
    // This would cause a new stream to be created since the old entry is evicted.
    JsonStreamWriter writer5 = cache.getTableWriter(TEST_TABLE);
    assertEquals(TEST_STREAM_31, writer4.getStreamName());
    assertEquals(TEST_STREAM, writer5.getStreamName());
    assertEquals(2, cache.cachedTableCount());
    cache.clear();
  }

  @Test
  public void testConcurrentAccess() throws Exception {
    final JsonWriterCache cache = JsonWriterCache.getTestInstance(client, 2);
    // Make sure getting the same table writer in multiple thread only cause create to be called
    // once.
    WriterCreationResponseMock(TEST_STREAM);
    ExecutorService executor = Executors.newFixedThreadPool(10);
    for (int i = 0; i < 10; i++) {
      executor.execute(
          new Runnable() {
            @Override
            public void run() {
              try {
                assertTrue(cache.getTableWriter(TEST_TABLE) != null);
              } catch (Exception e) {
                fail(e.getMessage());
              }
            }
          });
    }
    executor.shutdown();
    try {
      executor.awaitTermination(1, TimeUnit.MINUTES);
    } catch (InterruptedException e) {
      LOG.info(e.toString());
    }
  }
}
