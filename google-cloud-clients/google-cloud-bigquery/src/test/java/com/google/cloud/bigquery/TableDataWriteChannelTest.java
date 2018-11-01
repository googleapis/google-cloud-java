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

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.capture;
import static org.easymock.EasyMock.captureLong;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.cloud.RestorableState;
import com.google.cloud.WriteChannel;
import com.google.cloud.bigquery.spi.BigQueryRpcFactory;
import com.google.cloud.bigquery.spi.v2.BigQueryRpc;
import java.io.IOException;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Random;
import org.easymock.Capture;
import org.easymock.CaptureType;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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
  private static final int DEFAULT_CHUNK_SIZE = 8 * MIN_CHUNK_SIZE;
  private static final int CUSTOM_CHUNK_SIZE = 4 * MIN_CHUNK_SIZE;
  private static final Random RANDOM = new Random();
  private static final LoadJobConfiguration JOB_CONFIGURATION =
      LoadJobConfiguration.of(TABLE_ID, "URI");
  private static final JobInfo JOB_INFO = JobInfo.of(JobId.of(), JOB_CONFIGURATION);

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  private BigQueryOptions options;
  private BigQueryRpcFactory rpcFactoryMock;
  private BigQueryRpc bigqueryRpcMock;
  private BigQueryFactory bigqueryFactoryMock;
  private BigQuery bigqueryMock;
  private Job job;

  private TableDataWriteChannel writer;

  @Before
  public void setUp() {
    rpcFactoryMock = createMock(BigQueryRpcFactory.class);
    bigqueryRpcMock = createMock(BigQueryRpc.class);
    bigqueryFactoryMock = createMock(BigQueryFactory.class);
    bigqueryMock = createMock(BigQuery.class);
    expect(bigqueryMock.getOptions()).andReturn(options).anyTimes();
    replay(bigqueryMock);
    job = new Job(bigqueryMock, new JobInfo.BuilderImpl(JOB_INFO));
    expect(rpcFactoryMock.create(anyObject(BigQueryOptions.class))).andReturn(bigqueryRpcMock);
    expect(bigqueryFactoryMock.create(anyObject(BigQueryOptions.class))).andReturn(bigqueryMock)
        .anyTimes();
    replay(rpcFactoryMock, bigqueryFactoryMock);
    options = BigQueryOptions.newBuilder()
        .setProjectId("projectid")
        .setServiceRpcFactory(rpcFactoryMock)
        .setServiceFactory(bigqueryFactoryMock)
        .build();
  }

  @After
  public void tearDown() throws Exception {
    verify(rpcFactoryMock, bigqueryRpcMock, bigqueryFactoryMock, bigqueryMock);
  }

  @Test
  public void testCreate() {
    expect(
            bigqueryRpcMock.open(
                new com.google.api.services.bigquery.model.Job()
                    .setJobReference(JOB_INFO.getJobId().toPb())
                    .setConfiguration(LOAD_CONFIGURATION.toPb())))
        .andReturn(UPLOAD_ID);
    replay(bigqueryRpcMock);
    writer = new TableDataWriteChannel(options, JOB_INFO.getJobId(), LOAD_CONFIGURATION);
    assertTrue(writer.isOpen());
    assertNull(writer.getJob());
  }

  @Test
  public void testCreateRetryableError() {
    BigQueryException exception = new BigQueryException(new SocketException("Socket closed"));
    expect(
            bigqueryRpcMock.open(
                new com.google.api.services.bigquery.model.Job()
                    .setJobReference(JOB_INFO.getJobId().toPb())
                    .setConfiguration(LOAD_CONFIGURATION.toPb())))
        .andThrow(exception);
    expect(
            bigqueryRpcMock.open(
                new com.google.api.services.bigquery.model.Job()
                    .setJobReference(JOB_INFO.getJobId().toPb())
                    .setConfiguration(LOAD_CONFIGURATION.toPb())))
        .andReturn(UPLOAD_ID);
    replay(bigqueryRpcMock);
    writer = new TableDataWriteChannel(options, JOB_INFO.getJobId(), LOAD_CONFIGURATION);
    assertTrue(writer.isOpen());
    assertNull(writer.getJob());
  }

  @Test
  public void testCreateNonRetryableError() {
    expect(
            bigqueryRpcMock.open(
                new com.google.api.services.bigquery.model.Job()
                    .setJobReference(JOB_INFO.getJobId().toPb())
                    .setConfiguration(LOAD_CONFIGURATION.toPb())))
        .andThrow(new RuntimeException());
    replay(bigqueryRpcMock);
    thrown.expect(RuntimeException.class);
    new TableDataWriteChannel(options, JOB_INFO.getJobId(), LOAD_CONFIGURATION);
  }

  @Test
  public void testWriteWithoutFlush() throws IOException {
    expect(
            bigqueryRpcMock.open(
                new com.google.api.services.bigquery.model.Job()
                    .setJobReference(JOB_INFO.getJobId().toPb())
                    .setConfiguration(LOAD_CONFIGURATION.toPb())))
        .andReturn(UPLOAD_ID);
    replay(bigqueryRpcMock);
    writer = new TableDataWriteChannel(options, JOB_INFO.getJobId(), LOAD_CONFIGURATION);
    assertEquals(MIN_CHUNK_SIZE, writer.write(ByteBuffer.allocate(MIN_CHUNK_SIZE)));
    assertNull(writer.getJob());
  }

  @Test
  public void testWriteWithFlush() throws IOException {
    expect(
            bigqueryRpcMock.open(
                new com.google.api.services.bigquery.model.Job()
                    .setJobReference(JOB_INFO.getJobId().toPb())
                    .setConfiguration(LOAD_CONFIGURATION.toPb())))
        .andReturn(UPLOAD_ID);
    Capture<byte[]> capturedBuffer = Capture.newInstance();
    expect(bigqueryRpcMock.write(eq(UPLOAD_ID), capture(capturedBuffer), eq(0), eq(0L),
        eq(CUSTOM_CHUNK_SIZE), eq(false))).andReturn(null);
    replay(bigqueryRpcMock);
    writer = new TableDataWriteChannel(options, JOB_INFO.getJobId(), LOAD_CONFIGURATION);
    writer.setChunkSize(CUSTOM_CHUNK_SIZE);
    ByteBuffer buffer = randomBuffer(CUSTOM_CHUNK_SIZE);
    assertEquals(CUSTOM_CHUNK_SIZE, writer.write(buffer));
    assertArrayEquals(buffer.array(), capturedBuffer.getValue());
    assertNull(writer.getJob());
  }

  @Test
  public void testWritesAndFlush() throws IOException {
    expect(
            bigqueryRpcMock.open(
                new com.google.api.services.bigquery.model.Job()
                    .setJobReference(JOB_INFO.getJobId().toPb())
                    .setConfiguration(LOAD_CONFIGURATION.toPb())))
        .andReturn(UPLOAD_ID);
    Capture<byte[]> capturedBuffer = Capture.newInstance();
    expect(bigqueryRpcMock.write(eq(UPLOAD_ID), capture(capturedBuffer), eq(0), eq(0L),
        eq(DEFAULT_CHUNK_SIZE), eq(false))).andReturn(null);
    replay(bigqueryRpcMock);
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
  }

  @Test
  public void testCloseWithoutFlush() throws IOException {
    expect(
            bigqueryRpcMock.open(
                new com.google.api.services.bigquery.model.Job()
                    .setJobReference(JOB_INFO.getJobId().toPb())
                    .setConfiguration(LOAD_CONFIGURATION.toPb())))
        .andReturn(UPLOAD_ID);
    Capture<byte[]> capturedBuffer = Capture.newInstance();
    expect(bigqueryRpcMock.write(
        eq(UPLOAD_ID), capture(capturedBuffer), eq(0), eq(0L), eq(0), eq(true)))
        .andReturn(job.toPb());
    replay(bigqueryRpcMock);
    writer = new TableDataWriteChannel(options, JOB_INFO.getJobId(), LOAD_CONFIGURATION);
    assertTrue(writer.isOpen());
    writer.close();
    assertArrayEquals(new byte[0], capturedBuffer.getValue());
    assertTrue(!writer.isOpen());
    assertEquals(job, writer.getJob());
  }

  @Test
  public void testCloseWithFlush() throws IOException {
    expect(
            bigqueryRpcMock.open(
                new com.google.api.services.bigquery.model.Job()
                    .setJobReference(JOB_INFO.getJobId().toPb())
                    .setConfiguration(LOAD_CONFIGURATION.toPb())))
        .andReturn(UPLOAD_ID);
    Capture<byte[]> capturedBuffer = Capture.newInstance();
    ByteBuffer buffer = randomBuffer(MIN_CHUNK_SIZE);
    expect(bigqueryRpcMock.write(
        eq(UPLOAD_ID), capture(capturedBuffer), eq(0), eq(0L), eq(MIN_CHUNK_SIZE), eq(true)))
        .andReturn(job.toPb());
    replay(bigqueryRpcMock);
    writer = new TableDataWriteChannel(options, JOB_INFO.getJobId(), LOAD_CONFIGURATION);
    assertTrue(writer.isOpen());
    writer.write(buffer);
    writer.close();
    assertEquals(DEFAULT_CHUNK_SIZE, capturedBuffer.getValue().length);
    assertArrayEquals(buffer.array(), Arrays.copyOf(capturedBuffer.getValue(), MIN_CHUNK_SIZE));
    assertTrue(!writer.isOpen());
    assertEquals(job, writer.getJob());
  }

  @Test
  public void testWriteClosed() throws IOException {
    expect(
            bigqueryRpcMock.open(
                new com.google.api.services.bigquery.model.Job()
                    .setJobReference(JOB_INFO.getJobId().toPb())
                    .setConfiguration(LOAD_CONFIGURATION.toPb())))
        .andReturn(UPLOAD_ID);
    Capture<byte[]> capturedBuffer = Capture.newInstance();
    expect(bigqueryRpcMock.write(
        eq(UPLOAD_ID), capture(capturedBuffer), eq(0), eq(0L), eq(0), eq(true)))
        .andReturn(job.toPb());
    replay(bigqueryRpcMock);
    writer = new TableDataWriteChannel(options, JOB_INFO.getJobId(), LOAD_CONFIGURATION);
    writer.close();
    assertEquals(job, writer.getJob());
    try {
      writer.write(ByteBuffer.allocate(MIN_CHUNK_SIZE));
      fail("Expected TableDataWriteChannel write to throw IOException");
    } catch (IOException ex) {
      // expected
    }
  }

  @Test
  public void testSaveAndRestore() throws IOException {
    expect(
            bigqueryRpcMock.open(
                new com.google.api.services.bigquery.model.Job()
                    .setJobReference(JOB_INFO.getJobId().toPb())
                    .setConfiguration(LOAD_CONFIGURATION.toPb())))
        .andReturn(UPLOAD_ID);
    Capture<byte[]> capturedBuffer = Capture.newInstance(CaptureType.ALL);
    Capture<Long> capturedPosition = Capture.newInstance(CaptureType.ALL);
    expect(bigqueryRpcMock.write(eq(UPLOAD_ID), capture(capturedBuffer), eq(0),
        captureLong(capturedPosition), eq(DEFAULT_CHUNK_SIZE), eq(false))).andReturn(null).times(2);
    replay(bigqueryRpcMock);
    ByteBuffer buffer1 = randomBuffer(DEFAULT_CHUNK_SIZE);
    ByteBuffer buffer2 = randomBuffer(DEFAULT_CHUNK_SIZE);
    writer = new TableDataWriteChannel(options, JOB_INFO.getJobId(), LOAD_CONFIGURATION);
    assertEquals(DEFAULT_CHUNK_SIZE, writer.write(buffer1));
    assertArrayEquals(buffer1.array(), capturedBuffer.getValues().get(0));
    assertEquals(new Long(0L), capturedPosition.getValues().get(0));
    assertNull(writer.getJob());
    RestorableState<WriteChannel> writerState = writer.capture();
    WriteChannel restoredWriter = writerState.restore();
    assertEquals(DEFAULT_CHUNK_SIZE, restoredWriter.write(buffer2));
    assertArrayEquals(buffer2.array(), capturedBuffer.getValues().get(1));
    assertEquals(new Long(DEFAULT_CHUNK_SIZE), capturedPosition.getValues().get(1));
  }

  @Test
  public void testSaveAndRestoreClosed() throws IOException {
    expect(
            bigqueryRpcMock.open(
                new com.google.api.services.bigquery.model.Job()
                    .setJobReference(JOB_INFO.getJobId().toPb())
                    .setConfiguration(LOAD_CONFIGURATION.toPb())))
        .andReturn(UPLOAD_ID);
    Capture<byte[]> capturedBuffer = Capture.newInstance();
    expect(bigqueryRpcMock.write(
        eq(UPLOAD_ID), capture(capturedBuffer), eq(0), eq(0L), eq(0), eq(true)))
        .andReturn(job.toPb());
    replay(bigqueryRpcMock);
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
  }

  @Test
  public void testStateEquals() {
    expect(
            bigqueryRpcMock.open(
                new com.google.api.services.bigquery.model.Job()
                    .setJobReference(JOB_INFO.getJobId().toPb())
                    .setConfiguration(LOAD_CONFIGURATION.toPb())))
        .andReturn(UPLOAD_ID)
        .times(2);
    replay(bigqueryRpcMock);
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
  }

  private static ByteBuffer randomBuffer(int size) {
    byte[] byteArray = new byte[size];
    RANDOM.nextBytes(byteArray);
    return ByteBuffer.wrap(byteArray);
  }
}
