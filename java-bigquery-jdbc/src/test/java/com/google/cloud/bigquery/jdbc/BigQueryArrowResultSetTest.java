/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import static com.google.cloud.bigquery.jdbc.utils.ArrowUtilities.serializeSchema;
import static com.google.cloud.bigquery.jdbc.utils.ArrowUtilities.serializeVectorSchemaRoot;
import static com.google.common.truth.Truth.assertThat;
import static org.apache.arrow.vector.types.Types.MinorType.INT;
import static org.apache.arrow.vector.types.Types.MinorType.VARCHAR;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.Field.Mode;
import com.google.cloud.bigquery.FieldList;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.jdbc.rules.TimeZoneRule;
import com.google.cloud.bigquery.storage.v1.ArrowRecordBatch;
import com.google.cloud.bigquery.storage.v1.ArrowSchema;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Array;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Struct;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.stream.Stream;
import org.apache.arrow.memory.RootAllocator;
import org.apache.arrow.vector.BitVector;
import org.apache.arrow.vector.DateDayVector;
import org.apache.arrow.vector.DateMilliVector;
import org.apache.arrow.vector.FieldVector;
import org.apache.arrow.vector.Float8Vector;
import org.apache.arrow.vector.IntVector;
import org.apache.arrow.vector.TimeMicroVector;
import org.apache.arrow.vector.TimeMilliVector;
import org.apache.arrow.vector.TimeStampMicroVector;
import org.apache.arrow.vector.VarBinaryVector;
import org.apache.arrow.vector.VarCharVector;
import org.apache.arrow.vector.VectorSchemaRoot;
import org.apache.arrow.vector.complex.ListVector;
import org.apache.arrow.vector.complex.StructVector;
import org.apache.arrow.vector.complex.impl.UnionListWriter;
import org.apache.arrow.vector.types.pojo.FieldType;
import org.apache.arrow.vector.util.JsonStringArrayList;
import org.apache.arrow.vector.util.JsonStringHashMap;
import org.apache.arrow.vector.util.Text;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class BigQueryArrowResultSetTest {

  static {
    TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    TimeZoneCache.reset();
  }

  @RegisterExtension public static final TimeZoneRule timeZoneRule = new TimeZoneRule("UTC");

  private static final FieldList fieldList =
      FieldList.of(
          Field.of("boolField", StandardSQLTypeName.BOOL),
          Field.of("int64Filed", StandardSQLTypeName.INT64),
          Field.of("float64Field", StandardSQLTypeName.FLOAT64),
          Field.of("stringField", StandardSQLTypeName.STRING),
          Field.of("timeStampField", StandardSQLTypeName.TIMESTAMP),
          Field.of("bytesField", StandardSQLTypeName.BYTES),
          Field.newBuilder("intArrayField", StandardSQLTypeName.INT64)
              .setMode(Field.Mode.REPEATED)
              .build(),
          Field.of(
              "structField",
              StandardSQLTypeName.STRUCT,
              Field.of("name", StandardSQLTypeName.STRING),
              Field.of("age", StandardSQLTypeName.INT64)),
          Field.of("numericField", StandardSQLTypeName.BIGNUMERIC),
          Field.of("timeField", StandardSQLTypeName.TIME),
          Field.of("dateField", StandardSQLTypeName.DATE));

  private BigQueryArrowBatchWrapper arrowBatchWrapper;
  private BigQueryArrowBatchWrapper arrowBatchWrapperLast;

  private BigQueryStatement statement;

  private BlockingQueue<BigQueryArrowBatchWrapper> buffer;
  private BlockingQueue<BigQueryArrowBatchWrapper> bufferWithTwoRows;
  private static final Schema QUERY_SCHEMA = Schema.of(fieldList);

  private VectorSchemaRoot vectorSchemaRoot;
  private BigQueryArrowResultSet bigQueryArrowResultSet;
  private BigQueryArrowResultSet bigQueryArrowResultSetNested;

  private VectorSchemaRoot getTestVectorSchemaRoot() {
    RootAllocator allocator = new RootAllocator();
    BitVector boolField =
        new BitVector("boolField", allocator); // Mapped with StandardSQLTypeName.BOOL
    boolField.allocateNew(2);
    boolField.set(0, 0);
    boolField.setValueCount(1);
    IntVector int64Filed =
        new IntVector("int64Filed", allocator); // Mapped with StandardSQLTypeName.INT64
    int64Filed.allocateNew(2);
    int64Filed.set(0, 1);
    int64Filed.setValueCount(1);
    Float8Vector float64Field =
        new Float8Vector("float64Field", allocator); // Mapped with StandardSQLTypeName.FLOAT64
    float64Field.allocateNew(2);
    float64Field.set(0, 1.1);
    float64Field.setValueCount(1);
    VarCharVector stringField =
        new VarCharVector("stringField", allocator); // Mapped with StandardSQLTypeName.STRING
    stringField.allocateNew(2);
    stringField.set(0, new Text("text1"));
    stringField.setValueCount(1);
    TimeStampMicroVector timeStampField =
        new TimeStampMicroVector(
            "timeStampField", allocator); // Mapped with StandardSQLTypeName.TIMESTAMP
    timeStampField.allocateNew(2);
    timeStampField.set(0, 10000L);
    timeStampField.setValueCount(1);
    VarBinaryVector bytesField =
        new VarBinaryVector("bytesField", allocator); // Mapped with StandardSQLTypeName.BYTES
    bytesField.allocateNew(2);
    bytesField.set(0, "text1".getBytes());
    bytesField.setValueCount(1);

    ListVector listVector = ListVector.empty("intArrayField", allocator);
    UnionListWriter listWriter = listVector.getWriter();
    listWriter.setPosition(0);
    listWriter.startList();
    listWriter.writeBigInt(10L);
    listWriter.writeBigInt(20L);
    listWriter.setValueCount(2);
    listWriter.endList();
    listVector.setValueCount(1);

    StructVector structVector = StructVector.empty("structField", allocator);
    VarCharVector nameVector =
        structVector.addOrGet(
            "name", FieldType.notNullable(VARCHAR.getType()), VarCharVector.class);
    IntVector ageVector =
        structVector.addOrGet("age", FieldType.notNullable(INT.getType()), IntVector.class);
    structVector.allocateNew();

    nameVector.set(0, new Text("Jon Doe"));
    nameVector.setValueCount(1);

    ageVector.set(0, 29);
    ageVector.setValueCount(1);

    structVector.setValueCount(1);
    structVector.setIndexDefined(0);

    IntVector numericField =
        new IntVector("numericField", allocator); // Mapped with  StandardSQLTypeName.BIGNUMERIC
    numericField.allocateNew(1000);
    numericField.set(0, 1);
    numericField.setValueCount(1);
    TimeMilliVector timeField =
        new TimeMilliVector("timeField", allocator); // Mapped with  StandardSQLTypeName.TIME
    timeField.allocateNew(2);
    timeField.set(0, 1234);
    timeField.setValueCount(1);
    DateMilliVector dateField =
        new DateMilliVector("dateField", allocator); // Mapped with  StandardSQLTypeName.DATE
    dateField.allocateNew(2);
    dateField.set(0, 5000);
    dateField.setValueCount(1);

    List<FieldVector> fieldVectors =
        ImmutableList.of(
            boolField,
            int64Filed,
            float64Field,
            stringField,
            timeStampField,
            bytesField,
            listVector,
            structVector,
            numericField,
            timeField,
            dateField);
    return new VectorSchemaRoot(fieldVectors);
  }

  private JsonStringArrayList<Long> getJsonStringArrayList() {
    JsonStringArrayList<Long> jsonStringArrayList = new JsonStringArrayList<>();
    jsonStringArrayList.addAll(Arrays.asList(10L, 20L));
    return jsonStringArrayList;
  }

  @BeforeEach
  public void setUp() throws SQLException, IOException {
    buffer = new LinkedBlockingDeque<>();
    bufferWithTwoRows = new LinkedBlockingDeque<>();
    vectorSchemaRoot = getTestVectorSchemaRoot();
    ArrowRecordBatch batch =
        ArrowRecordBatch.newBuilder()
            .setSerializedRecordBatch(serializeVectorSchemaRoot(vectorSchemaRoot))
            .build();
    arrowBatchWrapper = BigQueryArrowBatchWrapper.of(batch);
    arrowBatchWrapperLast = BigQueryArrowBatchWrapper.of(null, true); // last flag
    buffer.add(arrowBatchWrapper);
    buffer.add(arrowBatchWrapperLast);
    bufferWithTwoRows.add(arrowBatchWrapper);
    bufferWithTwoRows.add(arrowBatchWrapperLast);

    statement = mock(BigQueryStatement.class);
    ArrowSchema arrowSchema =
        ArrowSchema.newBuilder()
            .setSerializedSchema(serializeSchema(vectorSchemaRoot.getSchema()))
            .build();
    Future<?> workerTask = mock(Future.class);
    bigQueryArrowResultSet =
        BigQueryArrowResultSet.of(
            QUERY_SCHEMA, arrowSchema, 1, statement, buffer, workerTask, null);

    // nested result set data setup
    JsonStringArrayList<Long> jsonStringArrayList = getJsonStringArrayList();
    Schema arraySchema =
        Schema.of(
            Field.newBuilder("integerArray", StandardSQLTypeName.INT64)
                .setMode(Mode.REPEATED)
                .build());
    bigQueryArrowResultSetNested =
        BigQueryArrowResultSet.getNestedResultSet(
            arraySchema,
            BigQueryArrowBatchWrapper.getNestedFieldValueListWrapper(jsonStringArrayList),
            0,
            jsonStringArrayList.size(),
            false);
  }

  @Test
  public void testVectorSchemaRoot() {
    assertThat(vectorSchemaRoot).isNotNull();
    assertThat(vectorSchemaRoot.getRowCount()).isEqualTo(1);
  }

  @Test
  public void testBufferSize() {
    assertThat(buffer).isNotNull();
    assertThat(buffer.size()).isEqualTo(2);
  }

  @Test
  public void testRowCount() throws SQLException, IOException {
    ArrowSchema arrowSchema =
        ArrowSchema.newBuilder()
            .setSerializedSchema(serializeSchema(vectorSchemaRoot.getSchema()))
            .build();
    Future<?> workerTask = mock(Future.class);
    // ResultSet with 1 row buffer and 1 total rows.
    BigQueryArrowResultSet bigQueryArrowResultSet2 =
        BigQueryArrowResultSet.of(
            QUERY_SCHEMA, arrowSchema, 1, statement, buffer, workerTask, null);

    assertThat(resultSetRowCount(bigQueryArrowResultSet2)).isEqualTo(1);
    // ResultSet with 2 rows buffer and 1 total rows.
    bigQueryArrowResultSet2 =
        BigQueryArrowResultSet.of(
            QUERY_SCHEMA, arrowSchema, 1, statement, bufferWithTwoRows, workerTask, null);

    assertThat(resultSetRowCount(bigQueryArrowResultSet2)).isEqualTo(1);
  }

  @Test
  // This method tests iteration and Resultset's type getters
  public void testIteration() throws SQLException {
    int cnt = 0;
    assertThat(bigQueryArrowResultSet.isBeforeFirst()).isTrue();
    while (bigQueryArrowResultSet.next()) {
      cnt++;
      assertThat(bigQueryArrowResultSet.isLast()).isTrue(); // we have one test row
      assertThat(bigQueryArrowResultSet.isFirst()).isTrue(); // we have one test row

      assertThat(bigQueryArrowResultSet.getString(4)).isEqualTo("text1");

      // array
      assertThat(bigQueryArrowResultSet.getArray("intArrayField").getArray())
          .isEqualTo(new Object[] {10L, 20L});
      assertThat(bigQueryArrowResultSet.getArray(7).getArray()).isEqualTo(new Object[] {10L, 20L});
      assertThat(((Array) bigQueryArrowResultSet.getObject("intArrayField")).getArray())
          .isEqualTo(new Object[] {10L, 20L});
      assertThat(((Array) bigQueryArrowResultSet.getObject(7)).getArray())
          .isEqualTo(new Object[] {10L, 20L});

      // struct
      assertThat(((Struct) bigQueryArrowResultSet.getObject("structField")).getAttributes())
          .isEqualTo(new Object[] {"Jon Doe", 29L});
      assertThat(((Struct) bigQueryArrowResultSet.getObject(8)).getAttributes())
          .isEqualTo(new Object[] {"Jon Doe", 29L});
    }
    assertThat(cnt).isEqualTo(1);
    assertThat(bigQueryArrowResultSet.next()).isFalse();
    assertThat(bigQueryArrowResultSet.isAfterLast()).isTrue();
  }

  @Test
  public void testIsClosed() {
    assertThat(bigQueryArrowResultSet.isClosed()).isFalse();
  }

  @Test
  public void testCloseCancelsProducerClearsBufferAndIsIdempotent()
      throws SQLException, IOException {
    ArrowSchema arrowSchema =
        ArrowSchema.newBuilder()
            .setSerializedSchema(serializeSchema(vectorSchemaRoot.getSchema()))
            .build();
    Future<?> workerTask = mock(Future.class);
    BlockingQueue<BigQueryArrowBatchWrapper> queue = new LinkedBlockingDeque<>(4);
    queue.add(arrowBatchWrapper);
    queue.add(arrowBatchWrapperLast);

    BigQueryArrowResultSet rs =
        BigQueryArrowResultSet.of(QUERY_SCHEMA, arrowSchema, 1, statement, queue, workerTask, null);

    assertThat(rs.isClosed()).isFalse();
    assertThat(queue).hasSize(2);

    rs.close();
    assertThat(rs.isClosed()).isTrue();
    assertThat(queue).hasSize(1);
    assertThat(queue.peek().getCurrentArrowBatch()).isNull();
    assertThat(queue.peek().isLast()).isTrue();
    verify(workerTask, times(1)).cancel(true);

    // Second close() call should be a no-op
    rs.close();
    verify(workerTask, times(1)).cancel(true);
  }

  @Test
  public void testResultSetHoldability() throws SQLException {
    assertThat(bigQueryArrowResultSet.getHoldability())
        .isEqualTo(bigQueryArrowResultSet.HOLD_CURSORS_OVER_COMMIT);
  }

  @Test
  public void testStatement() throws SQLException {
    assertThat(bigQueryArrowResultSet.getStatement()).isEqualTo(statement);
    assertThat(bigQueryArrowResultSetNested.getStatement()).isNull();
  }

  @Test
  public void testConcurrencyTypeColumn() throws SQLException {
    assertThat(bigQueryArrowResultSet.getConcurrency()).isEqualTo(ResultSet.CONCUR_READ_ONLY);
    assertThat(bigQueryArrowResultSet.getType()).isEqualTo(ResultSet.TYPE_FORWARD_ONLY);
    assertThat(bigQueryArrowResultSet.findColumn("boolField")).isEqualTo(1);
  }

  @Test
  public void testIterationNested() throws SQLException {
    int cnt = 0;
    assertThat(bigQueryArrowResultSetNested.isBeforeFirst()).isTrue();
    while (bigQueryArrowResultSetNested.next()) {
      cnt++;
      if (cnt == 1) {
        assertThat(bigQueryArrowResultSetNested.isFirst()).isTrue();

      } else { // 2nd row is the last row
        assertThat(bigQueryArrowResultSetNested.isLast()).isTrue();
      }
      assertThat(bigQueryArrowResultSetNested.getInt(1))
          .isEqualTo(cnt); // the first column is index 1
      assertThat(bigQueryArrowResultSetNested.getInt(2))
          .isEqualTo(cnt * 10); // second column has values 10 and 20
    }
    assertThat(cnt).isEqualTo(2);
    assertThat(bigQueryArrowResultSetNested.next()).isFalse();
    assertThat(bigQueryArrowResultSetNested.isAfterLast()).isTrue();
  }

  public static Stream<Arguments> successfulCoercionCases() {
    return Stream.of(
        Arguments.of("dateField", LocalDate.class, LocalDate.of(1970, 1, 1)),
        Arguments.of(11, LocalDate.class, LocalDate.of(1970, 1, 1)),
        Arguments.of("timeField", LocalTime.class, LocalTime.of(0, 0, 1, 234_000_000)),
        Arguments.of(10, LocalTime.class, LocalTime.of(0, 0, 1, 234_000_000)),
        Arguments.of(
            "timeStampField",
            LocalDateTime.class,
            LocalDateTime.of(1970, 1, 1, 0, 0, 0, 10_000_000)),
        Arguments.of(5, LocalDateTime.class, LocalDateTime.of(1970, 1, 1, 0, 0, 0, 10_000_000)),
        Arguments.of("boolField", Boolean.class, false),
        Arguments.of(1, Boolean.class, false),
        Arguments.of("int64Filed", Long.class, 1L),
        Arguments.of(2, Integer.class, 1),
        Arguments.of(2, String.class, "1"),
        Arguments.of("float64Field", Double.class, 1.1),
        Arguments.of("stringField", String.class, "text1"),
        Arguments.of("numericField", BigDecimal.class, BigDecimal.ONE),
        Arguments.of(9, Long.class, 1L),
        Arguments.of("timeField", Time.class, new Time(1234L)),
        Arguments.of(10, Time.class, new Time(1234L)),
        Arguments.of("timeStampField", Timestamp.class, new Timestamp(10L)),
        Arguments.of(5, Timestamp.class, new Timestamp(10L)),
        Arguments.of("dateField", Date.class, new Date(0L)),
        Arguments.of(11, Date.class, new Date(0L)));
  }

  public static Stream<Arguments> failingCoercionCases() {
    return Stream.of(
        Arguments.of("boolField", LocalDate.class),
        Arguments.of("dateField", Boolean.class),
        Arguments.of("stringField", BigDecimal.class));
  }

  @ParameterizedTest
  @MethodSource("successfulCoercionCases")
  public void testGetObjectWithType_success(Object column, Class<?> type, Object expectedValue)
      throws SQLException {
    assertThat(bigQueryArrowResultSet.next()).isTrue();
    if (column instanceof String) {
      assertThat(bigQueryArrowResultSet.getObject((String) column, type)).isEqualTo(expectedValue);
    } else {
      assertThat(bigQueryArrowResultSet.getObject((Integer) column, type)).isEqualTo(expectedValue);
    }
  }

  @ParameterizedTest
  @MethodSource("failingCoercionCases")
  public void testGetObjectWithType_failure(Object column, Class<?> type) throws SQLException {
    assertThat(bigQueryArrowResultSet.next()).isTrue();
    if (column instanceof String) {
      assertThrows(
          SQLException.class, () -> bigQueryArrowResultSet.getObject((String) column, type));
    } else {
      assertThrows(
          SQLException.class, () -> bigQueryArrowResultSet.getObject((Integer) column, type));
    }
  }

  private int resultSetRowCount(BigQueryArrowResultSet resultSet) throws SQLException {
    int rowCount = 0;
    while (resultSet.next()) {
      rowCount++;
    }
    return rowCount;
  }

  private VectorSchemaRoot getPicosVectorSchemaRoot() {
    RootAllocator allocator = new RootAllocator();
    VarCharVector picosCol = new VarCharVector("picosTimestamp", allocator);
    picosCol.allocateNew(1);
    picosCol.set(0, new Text("2026-04-08T10:00:00.123456789123Z"));
    picosCol.setValueCount(1);
    return new VectorSchemaRoot(ImmutableList.of(picosCol));
  }

  @Test
  public void testTimestampPicosEnabled() throws SQLException, IOException {
    VectorSchemaRoot root = getPicosVectorSchemaRoot();
    ArrowRecordBatch batch =
        ArrowRecordBatch.newBuilder()
            .setSerializedRecordBatch(serializeVectorSchemaRoot(root))
            .build();
    BlockingQueue<BigQueryArrowBatchWrapper> picosBuffer = new LinkedBlockingDeque<>();
    picosBuffer.add(BigQueryArrowBatchWrapper.of(batch));
    picosBuffer.add(BigQueryArrowBatchWrapper.of(null, true));

    BigQueryStatement picosStmt = mock(BigQueryStatement.class);
    doReturn(true).when(picosStmt).isEnableTimestampPicos();

    Schema schema =
        Schema.of(
            Field.newBuilder("picosTimestamp", StandardSQLTypeName.TIMESTAMP)
                .setTimestampPrecision(12L)
                .build());
    ArrowSchema arrowSchema =
        ArrowSchema.newBuilder().setSerializedSchema(serializeSchema(root.getSchema())).build();

    BigQueryArrowResultSet rs =
        BigQueryArrowResultSet.of(
            schema, arrowSchema, 1, picosStmt, picosBuffer, mock(Future.class), null);

    assertThat(rs.next()).isTrue();
    assertThat(rs.getString("picosTimestamp")).isEqualTo("2026-04-08 10:00:00.123456789123");
    assertThat(rs.getString(1)).isEqualTo("2026-04-08 10:00:00.123456789123");
    assertThat(rs.getObject("picosTimestamp")).isEqualTo("2026-04-08 10:00:00.123456789123");
    assertThat(rs.getObject(1)).isEqualTo("2026-04-08 10:00:00.123456789123");
    assertThat(rs.getObject("picosTimestamp", String.class))
        .isEqualTo("2026-04-08 10:00:00.123456789123");

    Timestamp expectedTs = Timestamp.valueOf("2026-04-08 10:00:00.123456789");
    assertThat(rs.getTimestamp("picosTimestamp")).isEqualTo(expectedTs);
    assertThat(rs.getObject("picosTimestamp", Timestamp.class)).isEqualTo(expectedTs);
  }

  @Test
  public void testTimestampPicosDisabled() throws SQLException, IOException {
    VectorSchemaRoot root = getPicosVectorSchemaRoot();
    ArrowRecordBatch batch =
        ArrowRecordBatch.newBuilder()
            .setSerializedRecordBatch(serializeVectorSchemaRoot(root))
            .build();
    BlockingQueue<BigQueryArrowBatchWrapper> picosBuffer = new LinkedBlockingDeque<>();
    picosBuffer.add(BigQueryArrowBatchWrapper.of(batch));
    picosBuffer.add(BigQueryArrowBatchWrapper.of(null, true));

    BigQueryStatement disabledStmt = mock(BigQueryStatement.class);
    doReturn(false).when(disabledStmt).isEnableTimestampPicos();

    Schema schema =
        Schema.of(
            Field.newBuilder("picosTimestamp", StandardSQLTypeName.TIMESTAMP)
                .setTimestampPrecision(12L)
                .build());
    ArrowSchema arrowSchema =
        ArrowSchema.newBuilder().setSerializedSchema(serializeSchema(root.getSchema())).build();

    BigQueryArrowResultSet rs =
        BigQueryArrowResultSet.of(
            schema, arrowSchema, 1, disabledStmt, picosBuffer, mock(Future.class), null);

    assertThat(rs.next()).isTrue();
    assertThat(rs.getString("picosTimestamp")).isEqualTo("2026-04-08 10:00:00.123456");
    assertThat(rs.getString(1)).isEqualTo("2026-04-08 10:00:00.123456");
    Timestamp expectedTs = Timestamp.valueOf("2026-04-08 10:00:00.123456789");
    assertThat(rs.getObject("picosTimestamp")).isEqualTo(expectedTs);
    assertThat(rs.getTimestamp("picosTimestamp")).isEqualTo(expectedTs);
  }

  @Test
  public void testStandardMicrosecondTimestampWithPicosEnabled() throws SQLException, IOException {
    VectorSchemaRoot root = getTestVectorSchemaRoot();
    ArrowRecordBatch batch =
        ArrowRecordBatch.newBuilder()
            .setSerializedRecordBatch(serializeVectorSchemaRoot(root))
            .build();
    BlockingQueue<BigQueryArrowBatchWrapper> picosBuffer = new LinkedBlockingDeque<>();
    picosBuffer.add(BigQueryArrowBatchWrapper.of(batch));
    picosBuffer.add(BigQueryArrowBatchWrapper.of(null, true));

    BigQueryStatement picosStmt = mock(BigQueryStatement.class);
    doReturn(true).when(picosStmt).isEnableTimestampPicos();

    ArrowSchema arrowSchema =
        ArrowSchema.newBuilder().setSerializedSchema(serializeSchema(root.getSchema())).build();

    BigQueryArrowResultSet rs =
        BigQueryArrowResultSet.of(
            QUERY_SCHEMA, arrowSchema, 1, picosStmt, picosBuffer, mock(Future.class), null);

    assertThat(rs.next()).isTrue();
    assertThat(rs.getString("timeStampField")).isEqualTo("1970-01-01 00:00:00.010000");
    assertThat(rs.getObject("timeStampField")).isEqualTo(new Timestamp(10L));
  }

  private BigQueryArrowResultSet createTemporalArrowResultSet(Instant ref)
      throws SQLException, IOException {
    RootAllocator allocator = new RootAllocator();
    DateDayVector dateVec = new DateDayVector("d", allocator);
    dateVec.allocateNew(1);
    dateVec.set(0, (int) LocalDate.of(2000, 2, 16).toEpochDay());
    dateVec.setValueCount(1);

    TimeMicroVector timeVec = new TimeMicroVector("t", allocator);
    timeVec.allocateNew(1);
    timeVec.set(0, LocalTime.of(10, 30, 46).toNanoOfDay() / 1_000L);
    timeVec.setValueCount(1);

    long refMicros = ref.getEpochSecond() * 1_000_000L + ref.getNano() / 1_000L;
    TimeStampMicroVector dtVec = new TimeStampMicroVector("dt", allocator);
    dtVec.allocateNew(1);
    dtVec.set(0, refMicros);
    dtVec.setValueCount(1);

    TimeStampMicroVector tsVec = new TimeStampMicroVector("ts", allocator);
    tsVec.allocateNew(1);
    tsVec.set(0, refMicros);
    tsVec.setValueCount(1);

    VectorSchemaRoot root = new VectorSchemaRoot(ImmutableList.of(dateVec, timeVec, dtVec, tsVec));
    ArrowRecordBatch batch =
        ArrowRecordBatch.newBuilder()
            .setSerializedRecordBatch(serializeVectorSchemaRoot(root))
            .build();
    BlockingQueue<BigQueryArrowBatchWrapper> arrowBuffer = new LinkedBlockingDeque<>();
    arrowBuffer.add(BigQueryArrowBatchWrapper.of(batch));
    arrowBuffer.add(BigQueryArrowBatchWrapper.of(null, true));

    Schema schema =
        Schema.of(
            Field.of("d", StandardSQLTypeName.DATE),
            Field.of("t", StandardSQLTypeName.TIME),
            Field.of("dt", StandardSQLTypeName.DATETIME),
            Field.of("ts", StandardSQLTypeName.TIMESTAMP));
    ArrowSchema arrowSchema =
        ArrowSchema.newBuilder().setSerializedSchema(serializeSchema(root.getSchema())).build();

    return BigQueryArrowResultSet.of(
        schema, arrowSchema, 1, statement, arrowBuffer, mock(Future.class), null);
  }

  @ParameterizedTest
  @ValueSource(strings = {"UTC", "America/New_York", "Asia/Tokyo"})
  public void testCalendarGettersOnWallClockTypesUseCalendarZone(String jvmZone)
      throws SQLException, IOException {
    TimeZone originalDefault = TimeZone.getDefault();
    try {
      TimeZone.setDefault(TimeZone.getTimeZone(ZoneId.of(jvmZone)));
      BigQueryArrowResultSet rs =
          createTemporalArrowResultSet(Instant.parse("2025-01-01T12:34:56.123Z"));
      assertThat(rs.next()).isTrue();

      Calendar utcCal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
      Calendar laCal = Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles"));
      ZoneId laZone = ZoneId.of("America/Los_Angeles");

      assertThat(rs.getDate("d", utcCal).getTime()).isEqualTo(950659200000L);
      assertThat(rs.getDate("d", laCal).getTime()).isEqualTo(950688000000L);
      assertThat(rs.getTime("t", utcCal).getTime()).isEqualTo(37846000L);
      assertThat(rs.getTime("t", laCal).getTime()).isEqualTo(66646000L);

      LocalDateTime dtDigits = LocalDateTime.of(2025, 1, 1, 12, 34, 56, 123_000_000);
      assertThat(rs.getTimestamp("dt", laCal).toInstant())
          .isEqualTo(dtDigits.atZone(laZone).toInstant());
      assertThat(
              Instant.ofEpochMilli(rs.getDate("dt", laCal).getTime()).atZone(laZone).toLocalDate())
          .isEqualTo(LocalDate.of(2025, 1, 1));
      assertThat(
              Instant.ofEpochMilli(rs.getTime("dt", laCal).getTime())
                  .atZone(laZone)
                  .toLocalTime()
                  .withNano(0))
          .isEqualTo(LocalTime.of(12, 34, 56));
    } finally {
      TimeZone.setDefault(originalDefault);
    }
  }

  @ParameterizedTest
  @ValueSource(strings = {"UTC", "America/New_York", "Asia/Tokyo"})
  public void testCalendarGettersOnTimestampIgnoreCalendar(String jvmZone)
      throws SQLException, IOException {
    TimeZone originalDefault = TimeZone.getDefault();
    try {
      TimeZone.setDefault(TimeZone.getTimeZone(ZoneId.of(jvmZone)));
      Instant ref = Instant.parse("2025-01-01T12:34:56.123Z");
      BigQueryArrowResultSet rs = createTemporalArrowResultSet(ref);
      assertThat(rs.next()).isTrue();

      Calendar laCal = Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles"));
      ZonedDateTime local = ref.atZone(ZoneId.of(jvmZone));

      assertThat(rs.getTimestamp("ts", laCal).toInstant()).isEqualTo(ref);
      assertThat(rs.getDate("ts", laCal).toLocalDate()).isEqualTo(local.toLocalDate());
      assertThat(rs.getTime("ts", laCal).toLocalTime()).isEqualTo(local.toLocalTime().withNano(0));
    } finally {
      TimeZone.setDefault(originalDefault);
    }
  }

  @ParameterizedTest
  @ValueSource(strings = {"UTC", "America/New_York", "Asia/Tokyo"})
  public void testGetStringOnTimestampAndDatetimeAcrossJvmZones(String jvmZone)
      throws SQLException, IOException {
    TimeZone originalDefault = TimeZone.getDefault();
    try {
      TimeZone.setDefault(TimeZone.getTimeZone(ZoneId.of(jvmZone)));
      Instant ref = Instant.parse("2025-01-01T12:34:56.123Z");
      BigQueryArrowResultSet rs = createTemporalArrowResultSet(ref);
      assertThat(rs.next()).isTrue();

      assertThat(rs.getString("ts")).isEqualTo("2025-01-01 12:34:56.123000");
      assertThat(rs.getObject("ts", String.class)).isEqualTo("2025-01-01 12:34:56.123000");
      assertThat(rs.getString("dt")).isEqualTo("2025-01-01 12:34:56.123000");

      long tsMicros = ref.getEpochSecond() * 1_000_000L + ref.getNano() / 1_000L;
      LocalDateTime dtLocal = LocalDateTime.of(2025, 1, 1, 12, 34, 56, 123_000_000);

      Field tsArraySchema =
          Field.newBuilder("ts_array", StandardSQLTypeName.TIMESTAMP)
              .setMode(Field.Mode.REPEATED)
              .build();
      JsonStringArrayList<Long> tsList = new JsonStringArrayList<>();
      tsList.add(tsMicros);
      BigQueryArrowArray tsArrowArray = new BigQueryArrowArray(tsArraySchema, tsList);
      assertThat(tsArrowArray.toString()).isEqualTo("[2025-01-01 12:34:56.123]");
      try (ResultSet nestedTsRs = tsArrowArray.getResultSet()) {
        assertThat(nestedTsRs.next()).isTrue();
        assertThat(nestedTsRs.getString(2)).isEqualTo("2025-01-01 12:34:56.123000");
      }

      Field dtArraySchema =
          Field.newBuilder("dt_array", StandardSQLTypeName.DATETIME)
              .setMode(Field.Mode.REPEATED)
              .build();
      JsonStringArrayList<LocalDateTime> dtList = new JsonStringArrayList<>();
      dtList.add(dtLocal);
      BigQueryArrowArray dtArrowArray = new BigQueryArrowArray(dtArraySchema, dtList);
      assertThat(dtArrowArray.toString()).isEqualTo("[2025-01-01 12:34:56.123]");

      FieldList structSchema =
          FieldList.of(
              Field.of("ts", StandardSQLTypeName.TIMESTAMP),
              Field.of("dt", StandardSQLTypeName.DATETIME));
      JsonStringHashMap<String, Object> structValues = new JsonStringHashMap<>();
      structValues.put("ts", tsMicros);
      structValues.put("dt", dtLocal);
      BigQueryArrowStruct arrowStruct = new BigQueryArrowStruct(structSchema, structValues);
      assertThat(arrowStruct.toString())
          .isEqualTo("{\"ts\":\"2025-01-01 12:34:56.123\",\"dt\":\"2025-01-01 12:34:56.123\"}");
    } finally {
      TimeZone.setDefault(originalDefault);
    }
  }

  @ParameterizedTest
  @ValueSource(strings = {"UTC", "America/New_York", "Asia/Tokyo"})
  public void testTimestampPicosAccessorsAcrossJvmZones(String jvmZone)
      throws SQLException, IOException {
    TimeZone originalDefault = TimeZone.getDefault();
    try {
      TimeZone.setDefault(TimeZone.getTimeZone(ZoneId.of(jvmZone)));
      VectorSchemaRoot root = getPicosVectorSchemaRoot();
      ArrowRecordBatch batch =
          ArrowRecordBatch.newBuilder()
              .setSerializedRecordBatch(serializeVectorSchemaRoot(root))
              .build();
      BlockingQueue<BigQueryArrowBatchWrapper> picosBuffer = new LinkedBlockingDeque<>();
      picosBuffer.add(BigQueryArrowBatchWrapper.of(batch));
      picosBuffer.add(BigQueryArrowBatchWrapper.of(null, true));

      BigQueryStatement picosStmt = mock(BigQueryStatement.class);
      doReturn(true).when(picosStmt).isEnableTimestampPicos();

      Schema schema =
          Schema.of(
              Field.newBuilder("picosTimestamp", StandardSQLTypeName.TIMESTAMP)
                  .setTimestampPrecision(12L)
                  .build());
      ArrowSchema arrowSchema =
          ArrowSchema.newBuilder().setSerializedSchema(serializeSchema(root.getSchema())).build();

      BigQueryArrowResultSet rs =
          BigQueryArrowResultSet.of(
              schema, arrowSchema, 1, picosStmt, picosBuffer, mock(Future.class), null);
      assertThat(rs.next()).isTrue();

      Instant expectedInstant = Instant.parse("2026-04-08T10:00:00.123456789Z");
      ZonedDateTime expectedLocal = expectedInstant.atZone(ZoneId.of(jvmZone));
      Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));

      assertThat(rs.getString("picosTimestamp")).isEqualTo("2026-04-08 10:00:00.123456789123");
      assertThat(rs.getTimestamp("picosTimestamp").toInstant()).isEqualTo(expectedInstant);
      assertThat(rs.getTimestamp("picosTimestamp", cal).toInstant()).isEqualTo(expectedInstant);
      assertThat(rs.getObject("picosTimestamp", Instant.class)).isEqualTo(expectedInstant);
      assertThat(rs.getObject("picosTimestamp", OffsetDateTime.class).toInstant())
          .isEqualTo(expectedInstant);
      assertThat(rs.getObject("picosTimestamp", LocalDateTime.class))
          .isEqualTo(expectedLocal.toLocalDateTime());
      assertThat(rs.getDate("picosTimestamp").toLocalDate()).isEqualTo(expectedLocal.toLocalDate());
      assertThat(rs.getDate("picosTimestamp", cal).toLocalDate())
          .isEqualTo(expectedLocal.toLocalDate());
      assertThat(rs.getTime("picosTimestamp").toLocalTime())
          .isEqualTo(expectedLocal.toLocalTime().withNano(0));
      assertThat(rs.getTime("picosTimestamp", cal).toLocalTime())
          .isEqualTo(expectedLocal.toLocalTime().withNano(0));
    } finally {
      TimeZone.setDefault(originalDefault);
    }
  }
}
