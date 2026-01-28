/*
 * Copyright 2026 Google LLC
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
import static org.mockito.Mockito.mock;

import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.Field.Mode;
import com.google.cloud.bigquery.FieldList;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.storage.v1.ArrowRecordBatch;
import com.google.cloud.bigquery.storage.v1.ArrowSchema;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Struct;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import org.apache.arrow.memory.RootAllocator;
import org.apache.arrow.vector.BitVector;
import org.apache.arrow.vector.DateMilliVector;
import org.apache.arrow.vector.FieldVector;
import org.apache.arrow.vector.Float8Vector;
import org.apache.arrow.vector.IntVector;
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
import org.apache.arrow.vector.util.Text;
import org.junit.Before;
import org.junit.Test;

public class BigQueryArrowResultSetTest {

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
    float64Field.set(0, 1.1f);
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

  @Before
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
    Thread workerThread = new Thread();
    bigQueryArrowResultSet =
        BigQueryArrowResultSet.of(
            QUERY_SCHEMA, arrowSchema, 1, statement, buffer, workerThread, null);

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
            jsonStringArrayList.size());
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
    Thread workerThread = new Thread();
    // ResultSet with 1 row buffer and 1 total rows.
    BigQueryArrowResultSet bigQueryArrowResultSet2 =
        BigQueryArrowResultSet.of(
            QUERY_SCHEMA, arrowSchema, 1, statement, buffer, workerThread, null);

    assertThat(resultSetRowCount(bigQueryArrowResultSet2)).isEqualTo(1);
    // ResultSet with 2 rows buffer and 1 total rows.
    bigQueryArrowResultSet2 =
        BigQueryArrowResultSet.of(
            QUERY_SCHEMA, arrowSchema, 1, statement, bufferWithTwoRows, workerThread, null);

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

  private int resultSetRowCount(BigQueryArrowResultSet resultSet) throws SQLException {
    int rowCount = 0;
    while (resultSet.next()) {
      rowCount++;
    }
    return rowCount;
  }

  // TODO: Unit Test for iteration and getters
}
