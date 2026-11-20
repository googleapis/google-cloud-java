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

package com.google.cloud.bigquery.jdbc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.FieldList;
import com.google.cloud.bigquery.FieldValue;
import com.google.cloud.bigquery.FieldValue.Attribute;
import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.LegacySQLTypeName;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.stream.Stream;
import org.apache.arrow.vector.util.JsonStringArrayList;
import org.apache.arrow.vector.util.JsonStringHashMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class BigQueryJdbcCustomLoggerTest extends BigQueryJdbcLoggingBaseTest {

  private BigQueryJdbcCustomLogger logger;
  private TestHandler testHandler;

  private static final int OBJECT_COUNT = 1_000;

  private static class TestHandler extends Handler {
    private final List<LogRecord> records = new ArrayList<>();

    @Override
    public void publish(LogRecord record) {
      records.add(record);
    }

    @Override
    public void flush() {}

    @Override
    public void close() throws SecurityException {}

    public List<LogRecord> getRecords() {
      return records;
    }
  }

  @BeforeEach
  public void setUp() {
    logger = new BigQueryJdbcCustomLogger("TestLogger");
    testHandler = new TestHandler();
    logger.addHandler(testHandler);
    logger.setLevel(Level.ALL);
  }

  @AfterEach
  public void tearDown() {
    if (logger != null && testHandler != null) {
      logger.removeHandler(testHandler);
    }
  }

  @Test
  public void testLogWithCallerInference() {
    logger.fine("Test message with format %s", "arg");

    List<LogRecord> records = testHandler.getRecords();
    assertEquals(1, records.size());
    LogRecord record = records.get(0);

    assertEquals("testLogWithCallerInference", record.getSourceMethodName());
    assertEquals(BigQueryJdbcCustomLoggerTest.class.getName(), record.getSourceClassName());
  }

  @Test
  public void testLazyCallerInference() {
    logger.fine("Lazy log message");

    List<LogRecord> records = testHandler.getRecords();
    assertEquals(1, records.size());
    LogRecord record = records.get(0);

    assertTrue(record instanceof BigQueryJdbcCustomLogger.BigQueryJdbcLogRecord);
    BigQueryJdbcCustomLogger.BigQueryJdbcLogRecord lazyRecord =
        (BigQueryJdbcCustomLogger.BigQueryJdbcLogRecord) record;

    // Verify stack walk has not been executed yet
    assertTrue(!lazyRecord.isCallerInferred());

    // Trigger stack walk
    String className = record.getSourceClassName();
    String methodName = record.getSourceMethodName();

    // Verify stack walk has executed and correct caller was inferred
    assertTrue(lazyRecord.isCallerInferred());
    assertEquals(BigQueryJdbcCustomLoggerTest.class.getName(), className);
    assertEquals("testLazyCallerInference", methodName);
  }

  @Test
  public void testCallerInferenceWithPerConnectionFileHandler(@TempDir Path tempDir) {
    PerConnectionFileHandler perConnHandler =
        new PerConnectionFileHandler(tempDir.toString(), Level.ALL);
    try {
      logger.fine("Message through PerConnectionFileHandler");

      List<LogRecord> records = testHandler.getRecords();
      assertEquals(1, records.size());
      LogRecord record = records.get(0);

      // Publish record via PerConnectionFileHandler to put PerConnectionFileHandler on stack trace
      perConnHandler.publish(record);

      // Verify that caller inference skips PerConnectionFileHandler frame
      assertEquals(BigQueryJdbcCustomLoggerTest.class.getName(), record.getSourceClassName());
      assertEquals("testCallerInferenceWithPerConnectionFileHandler", record.getSourceMethodName());
    } finally {
      perConnHandler.close();
    }
  }

  @Test
  public void testHotPathLoggerLogToDefaultWhenContextIsNull() {
    BigQueryJdbcCustomLogger hotpathLogger =
        new BigQueryJdbcCustomLogger("com.google.cloud.bigquery.jdbc.BigQueryArrowResultSet");
    TestHandler hotpathHandler = new TestHandler();
    hotpathLogger.addHandler(hotpathHandler);
    hotpathLogger.setLevel(Level.ALL);

    BigQueryJdbcMdc.clear(); // Ensure context is null
    hotpathLogger.fine("This should log to default");

    List<LogRecord> records = hotpathHandler.getRecords();
    assertEquals(1, records.size()); // Logged successfully, not dropped!
    assertEquals("This should log to default", records.get(0).getMessage());
  }

  @Test
  public void testHotPathLoggerNotSilencedWhenContextIsPresent() {
    BigQueryJdbcCustomLogger hotpathLogger =
        new BigQueryJdbcCustomLogger("com.google.cloud.bigquery.jdbc.BigQueryArrowResultSet");
    TestHandler hotpathHandler = new TestHandler();
    hotpathLogger.addHandler(hotpathHandler);
    hotpathLogger.setLevel(Level.ALL);

    BigQueryJdbcMdc.registerInstance("TestConnection"); // Set active context
    hotpathLogger.fine("This should not be silenced");

    List<LogRecord> records = hotpathHandler.getRecords();
    assertEquals(1, records.size()); // Allowed!
    assertEquals("This should not be silenced", records.get(0).getMessage());
  }

  @Test
  public void testLogWithException() {
    Exception ex = new Exception("Test exception");
    logger.severe("Error occurred: %s", ex, "detail");

    List<LogRecord> records = testHandler.getRecords();
    assertEquals(1, records.size());
    LogRecord record = records.get(0);

    assertEquals("testLogWithException", record.getSourceMethodName());
    assertEquals(BigQueryJdbcCustomLoggerTest.class.getName(), record.getSourceClassName());
    assertTrue(record.getMessage().contains("Error occurred: detail"));
    assertEquals(ex, record.getThrown());
  }

  @Test
  public void testResultSetLoggerTrace() {
    BigQueryJdbcResultSetLogger rsLogger =
        BigQueryJdbcResultSetLogger.getLogger(BigQueryBaseResultSet.class);
    TestHandler rsHandler = new TestHandler();
    rsLogger.delegate().addHandler(rsHandler);
    rsLogger.delegate().setLevel(Level.ALL);
    try {

      rsLogger.finestTrace("customMethod", "Hello finest trace message");

      List<LogRecord> records = rsHandler.getRecords();
      assertEquals(1, records.size());
      LogRecord record = records.get(0);

      assertEquals(Level.FINEST, record.getLevel());
      assertEquals("customMethod", record.getSourceMethodName());
      assertEquals(BigQueryBaseResultSet.class.getName(), record.getSourceClassName());
      assertEquals("Hello finest trace message", record.getMessage());
    } finally {
      rsLogger.delegate().removeHandler(rsHandler);
      rsLogger.delegate().setLevel(null);
    }
  }

  @Test
  public void testResultSetLoggerStandardMethods() {
    BigQueryJdbcResultSetLogger rsLogger =
        BigQueryJdbcResultSetLogger.getLogger(BigQueryBaseResultSet.class);
    TestHandler rsHandler = new TestHandler();
    rsLogger.delegate().addHandler(rsHandler);
    rsLogger.delegate().setLevel(Level.ALL);
    try {
      rsLogger.finest("Finest msg");
      rsLogger.finer("Finer msg");
      rsLogger.fine("Fine msg");

      List<LogRecord> records = rsHandler.getRecords();
      assertEquals(3, records.size());

      LogRecord r1 = records.get(0);
      assertEquals(Level.FINEST, r1.getLevel());
      assertEquals("unknown", r1.getSourceMethodName());
      assertEquals(BigQueryBaseResultSet.class.getName(), r1.getSourceClassName());
      assertEquals("Finest msg", r1.getMessage());

      LogRecord r2 = records.get(1);
      assertEquals(Level.FINER, r2.getLevel());
      assertEquals("unknown", r2.getSourceMethodName());
      assertEquals("Finer msg", r2.getMessage());

      LogRecord r3 = records.get(2);
      assertEquals(Level.FINE, r3.getLevel());
      assertEquals("unknown", r3.getSourceMethodName());
      assertEquals("Fine msg", r3.getMessage());
    } finally {
      rsLogger.delegate().removeHandler(rsHandler);
      rsLogger.delegate().setLevel(null);
    }
  }

  @Test
  public void testCustomLoggerSupplierMethods() {
    logger.fine(() -> "Lazy fine message");

    List<LogRecord> records = testHandler.getRecords();
    assertEquals(1, records.size());
    LogRecord record = records.get(0);

    assertEquals(Level.FINE, record.getLevel());
    assertEquals("testCustomLoggerSupplierMethods", record.getSourceMethodName());
    assertEquals(BigQueryJdbcCustomLoggerTest.class.getName(), record.getSourceClassName());
    assertEquals("Lazy fine message", record.getMessage());
  }

  @Test
  public void testResultSetLoggerSupplierMethods() {
    BigQueryJdbcResultSetLogger rsLogger =
        BigQueryJdbcResultSetLogger.getLogger(BigQueryBaseResultSet.class);
    TestHandler rsHandler = new TestHandler();
    rsLogger.delegate().addHandler(rsHandler);
    rsLogger.delegate().setLevel(Level.ALL);
    try {
      rsLogger.finest(() -> "Lazy finest RS message");

      List<LogRecord> records = rsHandler.getRecords();
      assertEquals(1, records.size());
      LogRecord record = records.get(0);

      assertEquals(Level.FINEST, record.getLevel());
      assertEquals("unknown", record.getSourceMethodName());
      assertEquals(BigQueryBaseResultSet.class.getName(), record.getSourceClassName());
      assertEquals("Lazy finest RS message", record.getMessage());
    } finally {
      rsLogger.delegate().removeHandler(rsHandler);
      rsLogger.delegate().setLevel(null);
    }
  }

  @Test
  public void testSupplierNotEvaluatedWhenDisabled() {
    logger.setLevel(Level.INFO); // Disables FINE, FINER, FINEST

    boolean[] evaluated = {false};
    logger.fine(
        () -> {
          evaluated[0] = true;
          return "This should not be evaluated";
        });

    assertEquals(0, testHandler.getRecords().size());
    assertEquals(false, evaluated[0]);
  }

  @Test
  public void testResultSetLoggerSupplierTraceMethods() {
    BigQueryJdbcResultSetLogger rsLogger =
        BigQueryJdbcResultSetLogger.getLogger(BigQueryBaseResultSet.class);
    TestHandler rsHandler = new TestHandler();
    rsLogger.delegate().addHandler(rsHandler);
    rsLogger.delegate().setLevel(Level.ALL);
    try {
      rsLogger.finestTrace("customTraceMethod", () -> "Lazy finest RS trace message");

      List<LogRecord> records = rsHandler.getRecords();
      assertEquals(1, records.size());
      LogRecord record = records.get(0);

      assertEquals(Level.FINEST, record.getLevel());
      assertEquals("customTraceMethod", record.getSourceMethodName());
      assertEquals(BigQueryBaseResultSet.class.getName(), record.getSourceClassName());
      assertEquals("Lazy finest RS trace message", record.getMessage());
    } finally {
      rsLogger.delegate().removeHandler(rsHandler);
      rsLogger.delegate().setLevel(null);
    }
  }

  @Test
  public void testResultSetLoggerCachingBehavior() {
    // Global facades (no connection ID) are shared.
    BigQueryJdbcResultSetLogger globalLogger1 =
        BigQueryJdbcResultSetLogger.getLogger(BigQueryBaseResultSet.class);
    BigQueryJdbcResultSetLogger globalLogger2 =
        BigQueryJdbcResultSetLogger.getLogger(BigQueryBaseResultSet.class);
    BigQueryJdbcResultSetLogger emptyIdLogger =
        BigQueryJdbcResultSetLogger.getLogger(BigQueryBaseResultSet.class, "");
    assertSame(globalLogger1, globalLogger2);
    assertSame(globalLogger1, emptyIdLogger);
    // Connection-scoped facades are distinct lightweight objects, but they all forward to the
    // single registered logger for the class — that is what prevents the registration leak.
    BigQueryJdbcResultSetLogger connLogger1 =
        BigQueryJdbcResultSetLogger.getLogger(BigQueryBaseResultSet.class, "conn-123");
    BigQueryJdbcResultSetLogger connLogger2 =
        BigQueryJdbcResultSetLogger.getLogger(BigQueryBaseResultSet.class, "conn-456");
    assertNotSame(connLogger1, connLogger2);
    assertSame(connLogger1.delegate(), connLogger2.delegate());
    assertSame(globalLogger1.delegate(), connLogger1.delegate());
  }

  @Test
  public void testResultSetLoggerParameterPreservation() {
    BigQueryJdbcResultSetLogger rsLogger =
        BigQueryJdbcResultSetLogger.getLogger(BigQueryBaseResultSet.class, "conn-123");
    TestHandler rsHandler = new TestHandler();
    rsLogger.delegate().addHandler(rsHandler);
    rsLogger.delegate().setLevel(Level.ALL);

    try {

      LogRecord record = new LogRecord(Level.INFO, "Processing job {0}");
      record.setParameters(new Object[] {"job-999"});
      rsLogger.log(record);
      // Calling log() again with an already-stamped record must be idempotent.
      rsLogger.log(record);

      List<LogRecord> records = rsHandler.getRecords();
      assertEquals(2, records.size());
      LogRecord loggedRecord = records.get(1);

      Object[] params = loggedRecord.getParameters();
      assertEquals(2, params.length);
      assertTrue(params[0] instanceof ConnectionLogContext);
      assertEquals("conn-123", ((ConnectionLogContext) params[0]).connectionId());
      assertEquals("job-999", params[1]);
    } finally {
      rsLogger.delegate().removeHandler(rsHandler);
      rsLogger.delegate().setLevel(null);
    }
  }

  private void assertConnectionIdPropagated(
      BigQueryJdbcResultSetLogger logger,
      String connectionId,
      String expectedMessage,
      Runnable action) {
    Level originalRootLevel = BigQueryJdbcRootLogger.getRootLogger().getLevel();
    Level originalLoggerLevel = logger.delegate().getLevel();
    Map<Handler, Level> originalHandlerLevels = new HashMap<>();
    for (Handler h : BigQueryJdbcRootLogger.getRootLogger().getHandlers()) {
      originalHandlerLevels.put(h, h.getLevel());
      h.setLevel(Level.ALL);
    }

    BigQueryJdbcRootLogger.getRootLogger().setLevel(Level.ALL);
    logger.delegate().setLevel(Level.ALL);

    try {
      capturedLogs.clear();
      action.run();
      assertEquals(1, capturedLogs.size());
      Object firstParam = capturedLogs.get(0).getParameters()[0];
      assertTrue(firstParam instanceof ConnectionLogContext);
      assertEquals(connectionId, ((ConnectionLogContext) firstParam).connectionId());
      assertTrue(assertLogContains(expectedMessage));
    } finally {
      BigQueryJdbcRootLogger.getRootLogger().setLevel(originalRootLevel);
      logger.delegate().setLevel(originalLoggerLevel);
      for (Entry<Handler, Level> entry : originalHandlerLevels.entrySet()) {
        entry.getKey().setLevel(entry.getValue());
      }
    }
  }

  @Test
  public void testArrowArrayConnectionIdPropagation() {
    String connectionId = "conn-arrow-999";
    BigQueryJdbcResultSetLogger logger =
        BigQueryJdbcResultSetLogger.getLogger(BigQueryArrowArray.class, connectionId);

    Field arraySchema = Field.of("name", LegacySQLTypeName.INTEGER);
    JsonStringArrayList<Object> arrayValues = new JsonStringArrayList<>();
    arrayValues.add(123L);
    BigQueryArrowArray array = new BigQueryArrowArray(arraySchema, arrayValues, false, logger);

    assertConnectionIdPropagated(
        logger, connectionId, "Log from Arrow Array", () -> array.LOG.fine("Log from Arrow Array"));
  }

  @Test
  public void testArrowStructConnectionIdPropagation() {
    String connectionId = "conn-arrow-999";
    BigQueryJdbcResultSetLogger structLogger =
        BigQueryJdbcResultSetLogger.getLogger(BigQueryArrowStruct.class, connectionId);

    FieldList structSchema = FieldList.of(Field.of("col", LegacySQLTypeName.INTEGER));
    JsonStringHashMap<String, Object> structValues = new JsonStringHashMap<>();
    structValues.put("col", 456L);
    BigQueryArrowStruct struct =
        new BigQueryArrowStruct(structSchema, structValues, false, structLogger);

    assertConnectionIdPropagated(
        structLogger,
        connectionId,
        "Log from Arrow Struct",
        () -> struct.LOG.fine("Log from Arrow Struct"));
  }

  @Test
  public void testNestedStructInArrowArrayConnectionIdPropagation() throws Exception {
    String connectionId = "conn-arrow-999";
    BigQueryJdbcResultSetLogger logger =
        BigQueryJdbcResultSetLogger.getLogger(BigQueryArrowArray.class, connectionId);

    FieldList subFields = FieldList.of(Field.of("sub_col", LegacySQLTypeName.INTEGER));
    Field arrayNestedSchema =
        Field.newBuilder("struct_arr", LegacySQLTypeName.RECORD, subFields)
            .setMode(Field.Mode.REPEATED)
            .build();
    JsonStringHashMap<String, Object> map = new JsonStringHashMap<>();
    map.put("sub_col", 456L);
    JsonStringArrayList<Object> nestedValues = new JsonStringArrayList<>();
    nestedValues.add(map);
    BigQueryArrowArray arrayWithNested =
        new BigQueryArrowArray(arrayNestedSchema, nestedValues, false, logger);

    Object[] result = (Object[]) arrayWithNested.getArray();
    BigQueryArrowStruct nestedStruct = (BigQueryArrowStruct) result[0];

    BigQueryJdbcResultSetLogger structLogger =
        BigQueryJdbcResultSetLogger.getLogger(BigQueryArrowStruct.class, connectionId);
    assertConnectionIdPropagated(
        structLogger,
        connectionId,
        "Log from Nested Struct",
        () -> nestedStruct.LOG.fine("Log from Nested Struct"));
  }

  @Test
  public void testNestedArrayInArrowStructConnectionIdPropagation() throws Exception {
    String connectionId = "conn-arrow-999";
    BigQueryJdbcResultSetLogger structLogger =
        BigQueryJdbcResultSetLogger.getLogger(BigQueryArrowStruct.class, connectionId);

    Field arrayField =
        Field.newBuilder("array_col", LegacySQLTypeName.INTEGER)
            .setMode(Field.Mode.REPEATED)
            .build();
    FieldList nestedSchema = FieldList.of(arrayField);
    JsonStringArrayList<Object> arrayVal = new JsonStringArrayList<>();
    arrayVal.add(123L);
    JsonStringHashMap<String, Object> values = new JsonStringHashMap<>();
    values.put("array_col", arrayVal);

    BigQueryArrowStruct structWithNestedArray =
        new BigQueryArrowStruct(nestedSchema, values, false, structLogger);
    Object[] attributes = structWithNestedArray.getAttributes();
    BigQueryArrowArray nestedArray = (BigQueryArrowArray) attributes[0];

    BigQueryJdbcResultSetLogger arrayLogger =
        BigQueryJdbcResultSetLogger.getLogger(BigQueryArrowArray.class, connectionId);
    assertConnectionIdPropagated(
        arrayLogger,
        connectionId,
        "Log from Nested Array",
        () -> nestedArray.LOG.fine("Log from Nested Array"));
  }

  @Test
  public void testJsonArrayConnectionIdPropagation() {
    String connectionId = "conn-json-888";
    BigQueryJdbcResultSetLogger logger =
        BigQueryJdbcResultSetLogger.getLogger(BigQueryJsonArray.class, connectionId);

    Field arraySchema = Field.of("name", LegacySQLTypeName.INTEGER);
    FieldValue arrayValue =
        FieldValue.of(
            Attribute.REPEATED,
            FieldValueList.of(
                Collections.singletonList(FieldValue.of(Attribute.PRIMITIVE, "123"))));
    BigQueryJsonArray array = new BigQueryJsonArray(arraySchema, arrayValue, false, logger);

    assertConnectionIdPropagated(
        logger, connectionId, "Log from JSON Array", () -> array.LOG.fine("Log from JSON Array"));
  }

  @Test
  public void testJsonStructConnectionIdPropagation() {
    String connectionId = "conn-json-888";
    BigQueryJdbcResultSetLogger structLogger =
        BigQueryJdbcResultSetLogger.getLogger(BigQueryJsonStruct.class, connectionId);

    FieldList structSchema = FieldList.of(Field.of("col", LegacySQLTypeName.INTEGER));
    FieldValue structValue =
        FieldValue.of(
            Attribute.RECORD,
            FieldValueList.of(
                Collections.singletonList(FieldValue.of(Attribute.PRIMITIVE, "456"))));
    BigQueryJsonStruct struct =
        new BigQueryJsonStruct(structSchema, structValue, false, structLogger);

    assertConnectionIdPropagated(
        structLogger,
        connectionId,
        "Log from JSON Struct",
        () -> struct.LOG.fine("Log from JSON Struct"));
  }

  @Test
  public void testNestedStructInJsonArrayConnectionIdPropagation() throws Exception {
    String connectionId = "conn-json-888";
    BigQueryJdbcResultSetLogger logger =
        BigQueryJdbcResultSetLogger.getLogger(BigQueryJsonArray.class, connectionId);

    FieldList subFields = FieldList.of(Field.of("sub_col", LegacySQLTypeName.INTEGER));
    Field arrayNestedSchema =
        Field.newBuilder("struct_arr", LegacySQLTypeName.RECORD, subFields)
            .setMode(Field.Mode.REPEATED)
            .build();
    FieldValue recordVal =
        FieldValue.of(
            Attribute.RECORD,
            FieldValueList.of(
                Collections.singletonList(FieldValue.of(Attribute.PRIMITIVE, "789"))));
    FieldValue listVal =
        FieldValue.of(Attribute.REPEATED, FieldValueList.of(Collections.singletonList(recordVal)));
    BigQueryJsonArray arrayWithNested =
        new BigQueryJsonArray(arrayNestedSchema, listVal, false, logger);

    Object[] result = (Object[]) arrayWithNested.getArray();
    BigQueryJsonStruct nestedStruct = (BigQueryJsonStruct) result[0];

    BigQueryJdbcResultSetLogger structLogger =
        BigQueryJdbcResultSetLogger.getLogger(BigQueryJsonStruct.class, connectionId);
    assertConnectionIdPropagated(
        structLogger,
        connectionId,
        "Log from Nested JSON Struct",
        () -> nestedStruct.LOG.fine("Log from Nested JSON Struct"));
  }

  @Test
  public void testNestedArrayInJsonStructConnectionIdPropagation() throws Exception {
    String connectionId = "conn-json-888";
    BigQueryJdbcResultSetLogger structLogger =
        BigQueryJdbcResultSetLogger.getLogger(BigQueryJsonStruct.class, connectionId);

    Field arrayField =
        Field.newBuilder("array_col", LegacySQLTypeName.INTEGER)
            .setMode(Field.Mode.REPEATED)
            .build();
    FieldList nestedSchema = FieldList.of(arrayField);
    FieldValue arrayVal =
        FieldValue.of(
            Attribute.REPEATED,
            FieldValueList.of(
                Collections.singletonList(FieldValue.of(Attribute.PRIMITIVE, "123"))));
    FieldValue rootVal =
        FieldValue.of(Attribute.RECORD, FieldValueList.of(Collections.singletonList(arrayVal)));

    BigQueryJsonStruct structWithNestedArray =
        new BigQueryJsonStruct(nestedSchema, rootVal, false, structLogger);
    Object[] attributes = structWithNestedArray.getAttributes();
    BigQueryJsonArray nestedArray = (BigQueryJsonArray) attributes[0];

    BigQueryJdbcResultSetLogger arrayLogger =
        BigQueryJdbcResultSetLogger.getLogger(BigQueryJsonArray.class, connectionId);
    assertConnectionIdPropagated(
        arrayLogger,
        connectionId,
        "Log from Nested JSON Array",
        () -> nestedArray.LOG.fine("Log from Nested JSON Array"));
  }

  @Test
  public void testLoggerIsParentedToDriverRootLogger() {
    assertSame(
        BigQueryJdbcRootLogger.getRootLogger(),
        new BigQueryJdbcCustomLogger("ParentCheck").getParent());
  }

  @Test
  public void testCreatingStatementsDoesNotRegisterChildLoggers() throws Exception {
    BigQueryConnection connection = mock(BigQueryConnection.class);
    doReturn("leak-test-connection").when(connection).getConnectionId();
    doReturn(BigQueryConnection.SessionState.empty()).when(connection).getSessionStateSnapshot();

    Logger rootLogger = BigQueryJdbcRootLogger.getRootLogger();
    // Warm up so that any one-time, class-level logger is registered before we measure.
    new BigQueryStatement(connection);
    int childrenBefore = childLoggerCount(rootLogger);

    for (int i = 0; i < OBJECT_COUNT; i++) {
      new BigQueryStatement(connection);
    }

    assertEquals(
        childrenBefore,
        childLoggerCount(rootLogger),
        "Creating "
            + OBJECT_COUNT
            + " statements must not register additional child loggers on the driver root logger");
  }

  @Test
  public void testCreatingPreparedAndCallableStatementsDoesNotRegisterChildLoggers()
      throws Exception {
    BigQueryConnection connection = mock(BigQueryConnection.class);
    doReturn("leak-test-connection").when(connection).getConnectionId();
    doReturn(BigQueryConnection.SessionState.empty()).when(connection).getSessionStateSnapshot();

    Logger rootLogger = BigQueryJdbcRootLogger.getRootLogger();
    // Warm up so that any one-time, class-level logger is registered before we measure.
    new BigQueryPreparedStatement(connection, "SELECT 1");
    new BigQueryCallableStatement(connection, "CALL my_proc()");
    int childrenBefore = childLoggerCount(rootLogger);

    for (int i = 0; i < OBJECT_COUNT; i++) {
      new BigQueryPreparedStatement(connection, "SELECT 1");
      new BigQueryCallableStatement(connection, "CALL my_proc()");
    }

    assertEquals(
        childrenBefore,
        childLoggerCount(rootLogger),
        "Creating "
            + OBJECT_COUNT
            + " PreparedStatements and CallableStatements must not register additional child"
            + " loggers on the driver root logger");
  }

  @Test
  public void testCreatingParameterHandlersAndBulkInsertWritersDoesNotRegisterChildLoggers()
      throws ReflectiveOperationException {
    Logger rootLogger = BigQueryJdbcRootLogger.getRootLogger();
    // Warm up so that any one-time, class-level logger is registered before we measure.
    new BigQueryParameterHandler(1);
    new BigQueryJdbcBulkInsertWriter();
    int childrenBefore = childLoggerCount(rootLogger);

    for (int i = 0; i < OBJECT_COUNT; i++) {
      new BigQueryParameterHandler(1);
      new BigQueryJdbcBulkInsertWriter();
    }

    assertEquals(
        childrenBefore,
        childLoggerCount(rootLogger),
        "Creating "
            + OBJECT_COUNT
            + " ParameterHandlers and BulkInsertWriters must not register additional child loggers"
            + " on the driver root logger");
  }

  @Test
  public void testCreatingDatabaseMetaDataDoesNotRegisterChildLoggers()
      throws ReflectiveOperationException {
    BigQueryConnection connection = mock(BigQueryConnection.class);
    doReturn("leak-test-connection").when(connection).getConnectionId();

    Logger rootLogger = BigQueryJdbcRootLogger.getRootLogger();
    new BigQueryDatabaseMetaData(connection);
    int childrenBefore = childLoggerCount(rootLogger);

    for (int i = 0; i < OBJECT_COUNT; i++) {
      new BigQueryDatabaseMetaData(connection);
    }

    assertEquals(
        childrenBefore,
        childLoggerCount(rootLogger),
        "Creating "
            + OBJECT_COUNT
            + " DatabaseMetaData objects must not register additional child loggers on the driver"
            + " root logger");
  }

  @Test
  public void testConnectionScopedResultSetLoggersDoNotRegisterChildLoggers()
      throws ReflectiveOperationException {
    Logger rootLogger = BigQueryJdbcRootLogger.getRootLogger();
    // Warm up so the per-class delegates (and their one-time registration) exist before measuring.
    BigQueryJdbcResultSetLogger.getLogger(BigQueryArrowResultSet.class, "warm-up")
        .getArrowStructLogger()
        .getArrowArrayLogger();
    int childrenBefore = childLoggerCount(rootLogger);

    for (int i = 0; i < OBJECT_COUNT; i++) {
      BigQueryJdbcResultSetLogger.getLogger(BigQueryArrowResultSet.class, "conn-" + i)
          .getArrowStructLogger()
          .getArrowArrayLogger();
    }

    assertEquals(
        childrenBefore,
        childLoggerCount(rootLogger),
        "Connection-scoped result-set loggers must not register child loggers on the driver root");
  }

  @Test
  public void testGate1ShortCircuitsDisabledAndHigherThresholdConnectionsWhileFinestIsActive(
      @TempDir Path tempDir) throws Exception {
    Logger rootLogger = BigQueryJdbcRootLogger.getRootLogger();
    rootLogger.removeHandler(this.handler);
    logger.removeHandler(testHandler);

    String finestConn = "conn-gate1-finest";
    String infoConn = "conn-gate1-info";
    String offConn = "conn-gate1-off";

    try {
      BigQueryJdbcRootLogger.registerConnection(
          finestConn, Level.FINEST, tempDir.resolve("finest").toString());
      BigQueryJdbcRootLogger.registerConnection(
          infoConn, Level.INFO, tempDir.resolve("info").toString());
      BigQueryJdbcRootLogger.registerConnection(offConn, Level.OFF, null);

      assertFalse(BigQueryJdbcRootLogger.hasExternalHandler());
      assertEquals(Level.FINEST, rootLogger.getLevel());
      assertFalse(logger.isLoggable(null));

      AtomicInteger supplierEvaluations = new AtomicInteger();
      BigQueryJdbcResultSetLogger globalRsLogger =
          BigQueryJdbcResultSetLogger.getLogger(BigQueryResultSetMetadata.class);

      // 1. CustomLogger + Global ResultSetLogger + MDC path
      try (BigQueryJdbcMdc.MdcCloseable offMdc = BigQueryJdbcMdc.registerInstance(offConn)) {
        assertFalse(logger.isLoggable(Level.SEVERE));
        assertFalse(globalRsLogger.isLoggable(Level.FINEST));
        logger.fine(
            () -> {
              supplierEvaluations.incrementAndGet();
              return "Should not evaluate on OFF connection";
            });
        globalRsLogger.finestTrace(
            "getColumnCount",
            () -> {
              supplierEvaluations.incrementAndGet();
              return "Should not evaluate on global RS facade under OFF MDC";
            });
      }
      try (BigQueryJdbcMdc.MdcCloseable infoMdc = BigQueryJdbcMdc.registerInstance(infoConn)) {
        assertFalse(logger.isLoggable(Level.FINE));
        assertFalse(globalRsLogger.isLoggable(Level.FINE));
        assertTrue(logger.isLoggable(Level.INFO));
        assertTrue(globalRsLogger.isLoggable(Level.INFO));
        logger.fine(
            () -> {
              supplierEvaluations.incrementAndGet();
              return "Should not evaluate FINE on INFO connection";
            });
      }
      assertEquals(0, supplierEvaluations.get());

      // 2. Connection-scoped ResultSetLogger + child Struct/Array loggers
      BigQueryJdbcResultSetLogger offRsLogger =
          BigQueryJdbcResultSetLogger.getLogger(BigQueryBaseResultSet.class, offConn);
      BigQueryJdbcResultSetLogger offStructLogger = offRsLogger.getArrowStructLogger();
      BigQueryJdbcResultSetLogger infoRsLogger =
          BigQueryJdbcResultSetLogger.getLogger(BigQueryBaseResultSet.class, infoConn);
      BigQueryJdbcResultSetLogger finestRsLogger =
          BigQueryJdbcResultSetLogger.getLogger(BigQueryBaseResultSet.class, finestConn);

      assertFalse(offRsLogger.isLoggable(null));
      assertFalse(offRsLogger.isLoggable(Level.FINEST));
      assertFalse(offStructLogger.isLoggable(Level.FINEST));
      assertFalse(infoRsLogger.isLoggable(Level.FINEST));
      assertTrue(infoRsLogger.isLoggable(Level.INFO));
      assertTrue(finestRsLogger.isLoggable(Level.FINEST));

      offRsLogger.finestTrace(
          "getInt",
          () -> {
            supplierEvaluations.incrementAndGet();
            return "Skipped on OFF RS";
          });
      offStructLogger.finest(
          () -> {
            supplierEvaluations.incrementAndGet();
            return "Skipped on OFF Struct";
          });
      infoRsLogger.finestTrace(
          "getString",
          () -> {
            supplierEvaluations.incrementAndGet();
            return "Skipped on INFO RS";
          });
      assertEquals(0, supplierEvaluations.get());

      // 3. Closing FINEST connection leaves rootLogger at Level.INFO (from infoConn), so
      // super.isLoggable(SEVERE/WARNING) is still true, yet finestRsLogger's flipped OFF_VALUE
      // context short-circuits SEVERE and WARNING at Gate 1!
      BigQueryJdbcRootLogger.closeConnectionHandler(finestConn);
      assertEquals(Level.INFO, rootLogger.getLevel());
      assertNullSafeDelegateDefaultLevel(finestRsLogger);
      assertFalse(finestRsLogger.isLoggable(Level.SEVERE));
      assertFalse(finestRsLogger.isLoggable(Level.WARNING));
      finestRsLogger.warning("Post-close warning %s", "skipped");
      assertEquals(0, supplierEvaluations.get());
    } finally {
      BigQueryJdbcRootLogger.closeConnectionHandler(finestConn);
      BigQueryJdbcRootLogger.closeConnectionHandler(infoConn);
      BigQueryJdbcRootLogger.closeConnectionHandler(offConn);
      restoreTestHandlers(rootLogger);
    }
  }

  @Test
  public void testGate1NestedMdcIsolationWritesToResultSetLogAndRestoresMdc(@TempDir Path tempDir)
      throws Exception {
    Logger rootLogger = BigQueryJdbcRootLogger.getRootLogger();
    rootLogger.removeHandler(this.handler);
    logger.removeHandler(testHandler);

    String finestConn = "conn-nested-finest";
    String offConn = "conn-nested-off";
    Path finestDir = tempDir.resolve("finest");
    Path offDir = tempDir.resolve("off");

    try {
      BigQueryJdbcRootLogger.registerConnection(finestConn, Level.FINEST, finestDir.toString());
      BigQueryJdbcRootLogger.registerConnection(offConn, Level.OFF, offDir.toString());

      BigQueryJdbcResultSetLogger finestRsLogger =
          BigQueryJdbcResultSetLogger.getLogger(BigQueryBaseResultSet.class, finestConn);
      BigQueryJdbcResultSetLogger offRsLogger =
          BigQueryJdbcResultSetLogger.getLogger(BigQueryBaseResultSet.class, offConn);

      // FINEST ResultSet nested inside an OFF MDC must actually write to finestDir and restore MDC
      try (BigQueryJdbcMdc.MdcCloseable offMdc = BigQueryJdbcMdc.registerInstance(offConn)) {
        finestRsLogger.finestTrace("getInt", () -> "Nested FINEST RS marker");
        assertEquals(offConn, BigQueryJdbcMdc.getConnectionId());
      }

      // OFF ResultSet nested inside a FINEST MDC must skip warning formatting, manual records, and
      // null records without writing to finestDir or creating offDir
      try (BigQueryJdbcMdc.MdcCloseable finestMdc = BigQueryJdbcMdc.registerInstance(finestConn)) {
        offRsLogger.warning("Should not appear in finest log %s", "ever");
        offRsLogger.log(new LogRecord(Level.SEVERE, "Manual OFF record skipped"));
        offRsLogger.log(null);
        assertEquals(finestConn, BigQueryJdbcMdc.getConnectionId());
      }

      BigQueryJdbcRootLogger.closeConnectionHandler(finestConn);
      assertFalse(Files.exists(offDir));

      List<Path> finestFiles;
      try (Stream<Path> s = Files.list(finestDir)) {
        finestFiles = Arrays.asList(s.toArray(Path[]::new));
      }
      assertEquals(1, finestFiles.size());
      String content = new String(Files.readAllBytes(finestFiles.get(0)), StandardCharsets.UTF_8);
      assertTrue(content.contains("Nested FINEST RS marker"));
      assertTrue(content.contains("[" + finestConn + "]"));
      assertFalse(content.contains("Should not appear in finest log"));
      assertFalse(content.contains("Manual OFF record skipped"));
    } finally {
      BigQueryJdbcRootLogger.closeConnectionHandler(finestConn);
      BigQueryJdbcRootLogger.closeConnectionHandler(offConn);
      restoreTestHandlers(rootLogger);
    }
  }

  @Test
  public void testGate1OverridesAsyncPropagationUseParentHandlersAndFallbackScan(
      @TempDir Path tempDir) throws Exception {
    Logger rootLogger = BigQueryJdbcRootLogger.getRootLogger();
    rootLogger.removeHandler(this.handler);
    logger.removeHandler(testHandler);

    String finestConn = "conn-branch-finest";
    String offConn = "conn-branch-off";
    String inheritConn = "conn-branch-inherit";

    try {
      BigQueryJdbcRootLogger.registerConnection(
          finestConn, Level.FINEST, tempDir.resolve("finest").toString());
      BigQueryJdbcRootLogger.registerConnection(offConn, Level.OFF, null);
      BigQueryJdbcResultSetLogger offRsLogger =
          BigQueryJdbcResultSetLogger.getLogger(BigQueryBaseResultSet.class, offConn);

      // 1. Unattributed (ctx == null) and 1-arg INHERIT_VALUE connections defer to rootLogger
      BigQueryJdbcMdc.clear();
      assertTrue(logger.isLoggable(Level.FINEST));
      try (BigQueryJdbcMdc.MdcCloseable noopMdc = BigQueryJdbcMdc.registerAndBindConnection(null)) {
        assertEquals(null, BigQueryJdbcMdc.getConnectionId());
      }
      try (BigQueryJdbcMdc.MdcCloseable inheritMdc =
          BigQueryJdbcMdc.registerAndBindConnection(inheritConn)) {
        assertTrue(logger.isLoggable(Level.FINEST));
      }

      // 2. Child logger with its own handler bypasses per-connection OFF filter
      logger.addHandler(testHandler);
      try (BigQueryJdbcMdc.MdcCloseable offMdc = BigQueryJdbcMdc.registerInstance(offConn)) {
        assertTrue(logger.isLoggable(Level.FINE));
      }
      logger.removeHandler(testHandler);
      try (BigQueryJdbcMdc.MdcCloseable offMdc = BigQueryJdbcMdc.registerInstance(offConn)) {
        assertFalse(logger.isLoggable(Level.FINE));
      }

      // 3. Async MdcThreadPoolExecutor submit() and execute() propagate ConnectionLogContext
      ExecutorService pool = BigQueryJdbcMdc.newFixedThreadPool("gate1-test", 1);
      try {
        Future<Boolean> offCallable;
        CountDownLatch offExecDone = new CountDownLatch(1);
        AtomicBoolean offExecLoggable = new AtomicBoolean(true);
        try (BigQueryJdbcMdc.MdcCloseable offMdc = BigQueryJdbcMdc.registerInstance(offConn)) {
          offCallable = pool.submit(() -> logger.isLoggable(Level.FINE));
          pool.execute(
              () -> {
                offExecLoggable.set(logger.isLoggable(Level.FINE));
                offExecDone.countDown();
              });
        }
        assertFalse(offCallable.get());
        assertTrue(offExecDone.await(5, TimeUnit.SECONDS));
        assertFalse(offExecLoggable.get());

        Future<Boolean> finestCallable;
        try (BigQueryJdbcMdc.MdcCloseable finestMdc =
            BigQueryJdbcMdc.registerInstance(finestConn)) {
          finestCallable = pool.submit(() -> logger.isLoggable(Level.FINEST));
        }
        assertTrue(finestCallable.get());
      } finally {
        pool.shutdownNow();
      }

      // 4. Explicit global setLevel overrides OFF down to that global floor
      BigQueryJdbcRootLogger.setLevel(Level.FINE, tempDir.resolve("global").toString());
      assertTrue(offRsLogger.isLoggable(Level.FINE));
      assertFalse(offRsLogger.isLoggable(Level.FINEST));
      BigQueryJdbcRootLogger.setLevel(Level.OFF, null);

      // 5. Enabling useParentHandlers on rootLogger treats parent delegation as an external sink
      rootLogger.setUseParentHandlers(true);
      assertTrue(BigQueryJdbcRootLogger.hasExternalHandler());
      assertTrue(offRsLogger.isLoggable(Level.FINEST));
      rootLogger.setUseParentHandlers(false);
      assertFalse(BigQueryJdbcRootLogger.hasExternalHandler());
      assertFalse(offRsLogger.isLoggable(Level.FINEST));

      // 6. Direct verification of scanForExternalHandler on a plain non-RootDriverLogger Logger
      Logger plainLogger = new Logger("test.plain.bigquery", null) {};
      plainLogger.setUseParentHandlers(false);
      plainLogger.addHandler(new OpenTelemetryJulHandler());
      assertFalse(BigQueryJdbcRootLogger.scanForExternalHandler(plainLogger));
      TestHandler plainExternal = new TestHandler();
      plainLogger.addHandler(plainExternal);
      assertTrue(BigQueryJdbcRootLogger.scanForExternalHandler(plainLogger));
      plainLogger.removeHandler(plainExternal);
      assertFalse(BigQueryJdbcRootLogger.scanForExternalHandler(plainLogger));
      plainLogger.setUseParentHandlers(true);
      assertTrue(BigQueryJdbcRootLogger.scanForExternalHandler(plainLogger));

      // 7. Re-attaching an external JUL handler on rootLogger restores visibility
      rootLogger.addHandler(this.handler);
      rootLogger.setLevel(Level.ALL);
      assertTrue(BigQueryJdbcRootLogger.hasExternalHandler());
      assertTrue(offRsLogger.isLoggable(Level.FINEST));
    } finally {
      rootLogger.setUseParentHandlers(false);
      BigQueryJdbcRootLogger.setLevel(Level.OFF, null);
      BigQueryJdbcRootLogger.closeConnectionHandler(finestConn);
      BigQueryJdbcRootLogger.closeConnectionHandler(offConn);
      BigQueryJdbcRootLogger.closeConnectionHandler(inheritConn);
      restoreTestHandlers(rootLogger);
    }
  }

  private void assertNullSafeDelegateDefaultLevel(BigQueryJdbcResultSetLogger rsLogger) {
    assertEquals(null, rsLogger.delegate().getLevel());
  }

  private void restoreTestHandlers(Logger rootLogger) {
    if (!Arrays.asList(rootLogger.getHandlers()).contains(this.handler)) {
      rootLogger.addHandler(this.handler);
    }
    if (!Arrays.asList(logger.getHandlers()).contains(testHandler)) {
      logger.addHandler(testHandler);
    }
    rootLogger.setLevel(Level.ALL);
  }

  /**
   * Reads the JDK-internal {@code Logger.kids} list. This field is private to {@code java.logging},
   * so the surefire {@code argLine} opens {@code java.util.logging} to the test classpath.
   */
  private static int childLoggerCount(Logger logger) throws ReflectiveOperationException {
    // Qualified because this file already imports com.google.cloud.bigquery.Field.
    java.lang.reflect.Field kids = Logger.class.getDeclaredField("kids");
    kids.setAccessible(true);
    List<?> children = (List<?>) kids.get(logger);
    return children == null ? 0 : children.size();
  }
}
