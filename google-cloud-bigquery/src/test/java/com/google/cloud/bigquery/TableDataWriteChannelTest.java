/*
 * Copyright 2015 Google LLC
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

package com.google.cloud.bigquery;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.cloud.RestorableState;
import com.google.cloud.WriteChannel;
import com.google.cloud.bigquery.spi.BigQueryRpcFactory;
import com.google.cloud.bigquery.spi.v2.HttpBigQueryRpc;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Random;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TableDataWriteChannelTest {

  private static final String UPLOAD_ID = "uploadid";
  private static final TableId TABLE_ID = TableId.of("dataset", "table");
  private static final WriteChannelConfiguration LOAD_CONFIGURATION =
      WriteChannelConfiguration.newBuilder(TABLE_ID)
          .setCreateDisposition(JobInfo.CreateDisposition.CREATE_IF_NEEDED)
          .setWriteDisposition(JobInfo.WriteDisposition.WRITE_APPEND)
          .setFormatOptions(FormatOptions.json())
          .setIgnoreUnknownValues(true)
          .setMaxBadRecords(10)
          .build();
  private static final int MIN_CHUNK_SIZE = 256 * 1024;
  private static final int DEFAULT_CHUNK_SIZE = 60 * MIN_CHUNK_SIZE;
  private static final int CUSTOM_CHUNK_SIZE = 4 * MIN_CHUNK_SIZE;
  private static final Random RANDOM = new Random();
  private static final LoadJobConfiguration JOB_CONFIGURATION =
      LoadJobConfiguration.of(TABLE_ID, "URI");
  private static final JobInfo JOB_INFO = JobInfo.of(JobId.of(), JOB_CONFIGURATION);

  private BigQueryOptions options;
  private BigQueryRpcFactory rpcFactoryMock;
  private HttpBigQueryRpc bigqueryRpcMock;
  private BigQueryFactory bigqueryFactoryMock;
  private BigQuery bigqueryMock;
  private Job job;

  @Captor private ArgumentCaptor<byte[]> capturedBuffer;
  @Captor private ArgumentCaptor<Long> capturedPosition;

  private TableDataWriteChannel writer;

  @Before
  public void setUp() {
    rpcFactoryMock = mock(BigQueryRpcFactory.class);
    bigqueryRpcMock = mock(HttpBigQueryRpc.class);
    bigqueryFactoryMock = mock(BigQueryFactory.class);
    bigqueryMock = mock(BigQuery.class);
    when(bigqueryMock.getOptions()).thenReturn(options);
    job = new Job(bigqueryMock, new JobInfo.BuilderImpl(JOB_INFO));
    when(rpcFactoryMock.create(any(BigQueryOptions.class))).thenReturn(bigqueryRpcMock);
    when(bigqueryFactoryMock.create(any(BigQueryOptions.class))).thenReturn(bigqueryMock);
    options =
        BigQueryOptions.newBuilder()
            .setProjectId("projectid")
            .setServiceRpcFactory(rpcFactoryMock)
            .setServiceFactory(bigqueryFactoryMock)
            .build();
  }

  @Test
  public void testCreate() throws IOException {
    when(bigqueryRpcMock.openSkipExceptionTranslation(
            new com.google.api.services.bigquery.model.Job()
                .setJobReference(JOB_INFO.getJobId().toPb())
                .setConfiguration(LOAD_CONFIGURATION.toPb())))
        .thenReturn(UPLOAD_ID);
    writer = new TableDataWriteChannel(options, JOB_INFO.getJobId(), LOAD_CONFIGURATION);
    assertTrue(writer.isOpen());
    assertNull(writer.getJob());
    verify(bigqueryRpcMock)
        .openSkipExceptionTranslation(
            new com.google.api.services.bigquery.model.Job()
                .setJobReference(JOB_INFO.getJobId().toPb())
                .setConfiguration(LOAD_CONFIGURATION.toPb()));
  }

  @Test
  public void testCreateRetryableErrors() throws IOException {
    when(bigqueryRpcMock.openSkipExceptionTranslation(
            new com.google.api.services.bigquery.model.Job()
                .setJobReference(JOB_INFO.getJobId().toPb())
                .setConfiguration(LOAD_CONFIGURATION.toPb())))
        .thenThrow(new SocketException("Socket closed"))
        .thenThrow(new UnknownHostException())
        .thenThrow(new ConnectException())
        .thenReturn(UPLOAD_ID);
    writer = new TableDataWriteChannel(options, JOB_INFO.getJobId(), LOAD_CONFIGURATION);
    assertTrue(writer.isOpen());
    assertNull(writer.getJob());
    verify(bigqueryRpcMock, times(4))
        .openSkipExceptionTranslation(
            new com.google.api.services.bigquery.model.Job()
                .setJobReference(JOB_INFO.getJobId().toPb())
                .setConfiguration(LOAD_CONFIGURATION.toPb()));
  }

  @Test
  public void testCreateNonRetryableError() throws IOException {
    when(bigqueryRpcMock.openSkipExceptionTranslation(
            new com.google.api.services.bigquery.model.Job()
                .setJobReference(JOB_INFO.getJobId().toPb())
                .setConfiguration(LOAD_CONFIGURATION.toPb())))
        .thenThrow(new RuntimeException("expected"));
    try (TableDataWriteChannel channel =
        new TableDataWriteChannel(options, JOB_INFO.getJobId(), LOAD_CONFIGURATION)) {
      Assert.fail();
    } catch (RuntimeException expected) {
      Assert.assertEquals("java.lang.RuntimeException: expected", expected.getMessage());
    }
    verify(bigqueryRpcMock)
        .openSkipExceptionTranslation(
            new com.google.api.services.bigquery.model.Job()
                .setJobReference(JOB_INFO.getJobId().toPb())
                .setConfiguration(LOAD_CONFIGURATION.toPb()));
  }

  @Test
  public void testWriteWithoutFlush() throws IOException {
    when(bigqueryRpcMock.openSkipExceptionTranslation(
            new com.google.api.services.bigquery.model.Job()
                .setJobReference(JOB_INFO.getJobId().toPb())
                .setConfiguration(LOAD_CONFIGURATION.toPb())))
        .thenReturn(UPLOAD_ID);
    writer = new TableDataWriteChannel(options, JOB_INFO.getJobId(), LOAD_CONFIGURATION);
    assertEquals(MIN_CHUNK_SIZE, writer.write(ByteBuffer.allocate(MIN_CHUNK_SIZE)));
    assertNull(writer.getJob());
    verify(bigqueryRpcMock)
        .openSkipExceptionTranslation(
            new com.google.api.services.bigquery.model.Job()
                .setJobReference(JOB_INFO.getJobId().toPb())
                .setConfiguration(LOAD_CONFIGURATION.toPb()));
  }

  @Test
  public void testWriteWithFlush() throws IOException {
    when(bigqueryRpcMock.openSkipExceptionTranslation(
            new com.google.api.services.bigquery.model.Job()
                .setJobReference(JOB_INFO.getJobId().toPb())
                .setConfiguration(LOAD_CONFIGURATION.toPb())))
        .thenReturn(UPLOAD_ID);
    when(bigqueryRpcMock.writeSkipExceptionTranslation(
            eq(UPLOAD_ID),
            capturedBuffer.capture(),
            eq(0),
            eq(0L),
            eq(CUSTOM_CHUNK_SIZE),
            eq(false)))
        .thenReturn(null);
    writer = new TableDataWriteChannel(options, JOB_INFO.getJobId(), LOAD_CONFIGURATION);
    writer.setChunkSize(CUSTOM_CHUNK_SIZE);
    ByteBuffer buffer = randomBuffer(CUSTOM_CHUNK_SIZE);
    assertEquals(CUSTOM_CHUNK_SIZE, writer.write(buffer));
    assertArrayEquals(buffer.array(), capturedBuffer.getValue());
    assertNull(writer.getJob());
    verify(bigqueryRpcMock)
        .openSkipExceptionTranslation(
            new com.google.api.services.bigquery.model.Job()
                .setJobReference(JOB_INFO.getJobId().toPb())
                .setConfiguration(LOAD_CONFIGURATION.toPb()));
    verify(bigqueryRpcMock)
        .writeSkipExceptionTranslation(
            eq(UPLOAD_ID),
            capturedBuffer.capture(),
            eq(0),
            eq(0L),
            eq(CUSTOM_CHUNK_SIZE),
            eq(false));
  }

  @Test
  public void testWritesAndFlushRetryableErrors() throws IOException {
    when(bigqueryRpcMock.openSkipExceptionTranslation(
            new com.google.api.services.bigquery.model.Job()
                .setJobReference(JOB_INFO.getJobId().toPb())
                .setConfiguration(LOAD_CONFIGURATION.toPb())))
        .thenReturn(UPLOAD_ID);
    when(bigqueryRpcMock.writeSkipExceptionTranslation(
            eq(UPLOAD_ID),
            capturedBuffer.capture(),
            eq(0),
            eq(0L),
            eq(DEFAULT_CHUNK_SIZE),
            eq(false)))
        .thenThrow(new SocketException("Socket closed"))
        .thenThrow(new UnknownHostException())
        .thenThrow(new ConnectException())
        .thenReturn(null);
    writer = new TableDataWriteChannel(options, JOB_INFO.getJobId(), LOAD_CONFIGURATION);
    ByteBuffer[] buffers = new ByteBuffer[DEFAULT_CHUNK_SIZE / MIN_CHUNK_SIZE];
    for (int i = 0; i < buffers.length; i++) {
      buffers[i] = randomBuffer(MIN_CHUNK_SIZE);
      assertEquals(MIN_CHUNK_SIZE, writer.write(buffers[i]));
    }
    for (int i = 0; i < buffers.length; i++) {
      assertArrayEquals(
          buffers[i].array(),
          Arrays.copyOfRange(
              capturedBuffer.getValue(), MIN_CHUNK_SIZE * i, MIN_CHUNK_SIZE * (i + 1)));
    }
    assertNull(writer.getJob());
    verify(bigqueryRpcMock)
        .openSkipExceptionTranslation(
            new com.google.api.services.bigquery.model.Job()
                .setJobReference(JOB_INFO.getJobId().toPb())
                .setConfiguration(LOAD_CONFIGURATION.toPb()));
    verify(bigqueryRpcMock, times(4))
        .writeSkipExceptionTranslation(
            eq(UPLOAD_ID),
            capturedBuffer.capture(),
            eq(0),
            eq(0L),
            eq(DEFAULT_CHUNK_SIZE),
            eq(false));
  }

  @Test
  public void testWritesAndFlushNonRetryableError() throws IOException {
    when(bigqueryRpcMock.openSkipExceptionTranslation(
            new com.google.api.services.bigquery.model.Job()
                .setJobReference(JOB_INFO.getJobId().toPb())
                .setConfiguration(LOAD_CONFIGURATION.toPb())))
        .thenReturn(UPLOAD_ID);
    when(bigqueryRpcMock.writeSkipExceptionTranslation(
            eq(UPLOAD_ID),
            capturedBuffer.capture(),
            eq(0),
            eq(0L),
            eq(DEFAULT_CHUNK_SIZE),
            eq(false)))
        .thenThrow(new RuntimeException("expected"));
    try {
      writer = new TableDataWriteChannel(options, JOB_INFO.getJobId(), LOAD_CONFIGURATION);
      ByteBuffer[] buffers = new ByteBuffer[DEFAULT_CHUNK_SIZE / MIN_CHUNK_SIZE];
      for (int i = 0; i < buffers.length; i++) {
        buffers[i] = randomBuffer(MIN_CHUNK_SIZE);
        assertEquals(MIN_CHUNK_SIZE, writer.write(buffers[i]));
      }
      Assert.fail();
    } catch (RuntimeException expected) {
      Assert.assertEquals("java.lang.RuntimeException: expected", expected.getMessage());
    }
    verify(bigqueryRpcMock)
        .openSkipExceptionTranslation(
            new com.google.api.services.bigquery.model.Job()
                .setJobReference(JOB_INFO.getJobId().toPb())
                .setConfiguration(LOAD_CONFIGURATION.toPb()));
    verify(bigqueryRpcMock, times(1))
        .writeSkipExceptionTranslation(
            eq(UPLOAD_ID),
            capturedBuffer.capture(),
            eq(0),
            eq(0L),
            eq(DEFAULT_CHUNK_SIZE),
            eq(false));
  }

  @Test
  public void testCloseWithoutFlush() throws IOException {
    when(bigqueryRpcMock.openSkipExceptionTranslation(
            new com.google.api.services.bigquery.model.Job()
                .setJobReference(JOB_INFO.getJobId().toPb())
                .setConfiguration(LOAD_CONFIGURATION.toPb())))
        .thenReturn(UPLOAD_ID);
    when(bigqueryRpcMock.writeSkipExceptionTranslation(
            eq(UPLOAD_ID), capturedBuffer.capture(), eq(0), eq(0L), eq(0), eq(true)))
        .thenReturn(job.toPb());
    writer = new TableDataWriteChannel(options, JOB_INFO.getJobId(), LOAD_CONFIGURATION);
    assertTrue(writer.isOpen());
    writer.close();
    assertArrayEquals(new byte[0], capturedBuffer.getValue());
    assertTrue(!writer.isOpen());
    assertEquals(job, writer.getJob());
    verify(bigqueryRpcMock)
        .openSkipExceptionTranslation(
            new com.google.api.services.bigquery.model.Job()
                .setJobReference(JOB_INFO.getJobId().toPb())
                .setConfiguration(LOAD_CONFIGURATION.toPb()));
    verify(bigqueryRpcMock)
        .writeSkipExceptionTranslation(
            eq(UPLOAD_ID), capturedBuffer.capture(), eq(0), eq(0L), eq(0), eq(true));
  }

  @Test
  public void testCloseWithFlush() throws IOException {
    when(bigqueryRpcMock.openSkipExceptionTranslation(
            new com.google.api.services.bigquery.model.Job()
                .setJobReference(JOB_INFO.getJobId().toPb())
                .setConfiguration(LOAD_CONFIGURATION.toPb())))
        .thenReturn(UPLOAD_ID);
    ByteBuffer buffer = randomBuffer(MIN_CHUNK_SIZE);
    when(bigqueryRpcMock.writeSkipExceptionTranslation(
            eq(UPLOAD_ID), capturedBuffer.capture(), eq(0), eq(0L), eq(MIN_CHUNK_SIZE), eq(true)))
        .thenReturn(job.toPb());
    writer = new TableDataWriteChannel(options, JOB_INFO.getJobId(), LOAD_CONFIGURATION);
    assertTrue(writer.isOpen());
    writer.write(buffer);
    writer.close();
    assertEquals(DEFAULT_CHUNK_SIZE, capturedBuffer.getValue().length);
    assertArrayEquals(buffer.array(), Arrays.copyOf(capturedBuffer.getValue(), MIN_CHUNK_SIZE));
    assertTrue(!writer.isOpen());
    assertEquals(job, writer.getJob());
    verify(bigqueryRpcMock)
        .openSkipExceptionTranslation(
            new com.google.api.services.bigquery.model.Job()
                .setJobReference(JOB_INFO.getJobId().toPb())
                .setConfiguration(LOAD_CONFIGURATION.toPb()));
    verify(bigqueryRpcMock)
        .writeSkipExceptionTranslation(
            eq(UPLOAD_ID), capturedBuffer.capture(), eq(0), eq(0L), eq(MIN_CHUNK_SIZE), eq(true));
  }

  @Test
  public void testWriteClosed() throws IOException {
    when(bigqueryRpcMock.openSkipExceptionTranslation(
            new com.google.api.services.bigquery.model.Job()
                .setJobReference(JOB_INFO.getJobId().toPb())
                .setConfiguration(LOAD_CONFIGURATION.toPb())))
        .thenReturn(UPLOAD_ID);
    when(bigqueryRpcMock.writeSkipExceptionTranslation(
            eq(UPLOAD_ID), capturedBuffer.capture(), eq(0), eq(0L), eq(0), eq(true)))
        .thenReturn(job.toPb());
    writer = new TableDataWriteChannel(options, JOB_INFO.getJobId(), LOAD_CONFIGURATION);
    writer.close();
    assertEquals(job, writer.getJob());
    try {
      writer.write(ByteBuffer.allocate(MIN_CHUNK_SIZE));
      fail("Expected TableDataWriteChannel write to throw IOException");
    } catch (IOException ex) {
      // expected
    }
    verify(bigqueryRpcMock)
        .openSkipExceptionTranslation(
            new com.google.api.services.bigquery.model.Job()
                .setJobReference(JOB_INFO.getJobId().toPb())
                .setConfiguration(LOAD_CONFIGURATION.toPb()));
    verify(bigqueryRpcMock)
        .writeSkipExceptionTranslation(
            eq(UPLOAD_ID), capturedBuffer.capture(), eq(0), eq(0L), eq(0), eq(true));
  }

  @Test
  public void testSaveAndRestore() throws IOException {
    when(bigqueryRpcMock.openSkipExceptionTranslation(
            new com.google.api.services.bigquery.model.Job()
                .setJobReference(JOB_INFO.getJobId().toPb())
                .setConfiguration(LOAD_CONFIGURATION.toPb())))
        .thenReturn(UPLOAD_ID);
    when(bigqueryRpcMock.writeSkipExceptionTranslation(
            eq(UPLOAD_ID),
            capturedBuffer.capture(),
            eq(0),
            capturedPosition.capture(),
            eq(DEFAULT_CHUNK_SIZE),
            eq(false)))
        .thenReturn(null);
    ByteBuffer buffer1 = randomBuffer(DEFAULT_CHUNK_SIZE);
    ByteBuffer buffer2 = randomBuffer(DEFAULT_CHUNK_SIZE);
    writer = new TableDataWriteChannel(options, JOB_INFO.getJobId(), LOAD_CONFIGURATION);
    assertEquals(DEFAULT_CHUNK_SIZE, writer.write(buffer1));
    assertArrayEquals(buffer1.array(), capturedBuffer.getAllValues().get(0));
    assertEquals(new Long(0L), capturedPosition.getAllValues().get(0));
    assertNull(writer.getJob());
    RestorableState<WriteChannel> writerState = writer.capture();
    WriteChannel restoredWriter = writerState.restore();
    assertEquals(DEFAULT_CHUNK_SIZE, restoredWriter.write(buffer2));
    assertArrayEquals(buffer2.array(), capturedBuffer.getAllValues().get(1));
    assertEquals(new Long(DEFAULT_CHUNK_SIZE), capturedPosition.getAllValues().get(1));
    verify(bigqueryRpcMock)
        .openSkipExceptionTranslation(
            new com.google.api.services.bigquery.model.Job()
                .setJobReference(JOB_INFO.getJobId().toPb())
                .setConfiguration(LOAD_CONFIGURATION.toPb()));
    verify(bigqueryRpcMock, times(2))
        .writeSkipExceptionTranslation(
            eq(UPLOAD_ID),
            capturedBuffer.capture(),
            eq(0),
            capturedPosition.capture(),
            eq(DEFAULT_CHUNK_SIZE),
            eq(false));
  }

  @Test
  public void testSaveAndRestoreClosed() throws IOException {
    when(bigqueryRpcMock.openSkipExceptionTranslation(
            new com.google.api.services.bigquery.model.Job()
                .setJobReference(JOB_INFO.getJobId().toPb())
                .setConfiguration(LOAD_CONFIGURATION.toPb())))
        .thenReturn(UPLOAD_ID);
    when(bigqueryRpcMock.writeSkipExceptionTranslation(
            eq(UPLOAD_ID), capturedBuffer.capture(), eq(0), eq(0L), eq(0), eq(true)))
        .thenReturn(job.toPb());
    writer = new TableDataWriteChannel(options, JOB_INFO.getJobId(), LOAD_CONFIGURATION);
    writer.close();
    assertEquals(job, writer.getJob());
    RestorableState<WriteChannel> writerState = writer.capture();
    RestorableState<WriteChannel> expectedWriterState =
        TableDataWriteChannel.StateImpl.builder(options, LOAD_CONFIGURATION, UPLOAD_ID, job)
            .setBuffer(null)
            .setChunkSize(DEFAULT_CHUNK_SIZE)
            .setIsOpen(false)
            .setPosition(0)
            .build();
    WriteChannel restoredWriter = writerState.restore();
    assertArrayEquals(new byte[0], capturedBuffer.getValue());
    assertEquals(expectedWriterState, restoredWriter.capture());
    verify(bigqueryRpcMock)
        .openSkipExceptionTranslation(
            new com.google.api.services.bigquery.model.Job()
                .setJobReference(JOB_INFO.getJobId().toPb())
                .setConfiguration(LOAD_CONFIGURATION.toPb()));
    verify(bigqueryRpcMock)
        .writeSkipExceptionTranslation(
            eq(UPLOAD_ID), capturedBuffer.capture(), eq(0), eq(0L), eq(0), eq(true));
  }

  @Test
  public void testStateEquals() throws IOException {
    when(bigqueryRpcMock.openSkipExceptionTranslation(
            new com.google.api.services.bigquery.model.Job()
                .setJobReference(JOB_INFO.getJobId().toPb())
                .setConfiguration(LOAD_CONFIGURATION.toPb())))
        .thenReturn(UPLOAD_ID);
    writer = new TableDataWriteChannel(options, JOB_INFO.getJobId(), LOAD_CONFIGURATION);
    // avoid closing when you don't want partial writes upon failure
    @SuppressWarnings("resource")
    WriteChannel writer2 =
        new TableDataWriteChannel(options, JOB_INFO.getJobId(), LOAD_CONFIGURATION);
    RestorableState<WriteChannel> state = writer.capture();
    RestorableState<WriteChannel> state2 = writer2.capture();
    assertEquals(state, state2);
    assertEquals(state.hashCode(), state2.hashCode());
    assertEquals(state.toString(), state2.toString());
    verify(bigqueryRpcMock, times(2))
        .openSkipExceptionTranslation(
            new com.google.api.services.bigquery.model.Job()
                .setJobReference(JOB_INFO.getJobId().toPb())
                .setConfiguration(LOAD_CONFIGURATION.toPb()));
  }

  private static ByteBuffer randomBuffer(int size) {
    byte[] byteArray = new byte[size];
    RANDOM.nextBytes(byteArray);
    return ByteBuffer.wrap(byteArray);
  }
}
