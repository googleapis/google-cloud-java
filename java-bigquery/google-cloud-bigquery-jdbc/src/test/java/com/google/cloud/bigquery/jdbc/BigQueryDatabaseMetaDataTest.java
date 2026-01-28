/*
 * Copyright 2024 Google LLC
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

import com.google.api.gax.paging.Page;
import com.google.cloud.bigquery.*;
import com.google.cloud.bigquery.BigQuery.RoutineListOption;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.regex.Pattern;
import org.junit.Before;
import org.junit.Test;

public class BigQueryDatabaseMetaDataTest {

  private BigQueryConnection bigQueryConnection;
  private BigQueryDatabaseMetaData dbMetadata;
  private BigQuery bigqueryClient;

  @Before
  public void setUp() throws SQLException {
    bigQueryConnection = mock(BigQueryConnection.class);
    bigqueryClient = mock(BigQuery.class);
    Statement mockStatement = mock(Statement.class);

    when(bigQueryConnection.getConnectionUrl()).thenReturn("jdbc:bigquery://test-project");
    when(bigQueryConnection.getBigQuery()).thenReturn(bigqueryClient);
    when(bigQueryConnection.createStatement()).thenReturn(mockStatement);

    dbMetadata = new BigQueryDatabaseMetaData(bigQueryConnection);
  }

  private Table mockBigQueryTable(
      String project, String dataset, String table, TableDefinition.Type type, String description) {
    Table mockTable = mock(Table.class);
    TableId mockTableId = TableId.of(project, dataset, table);
    TableDefinition mockDefinition = mock(TableDefinition.class);

    when(mockTable.getTableId()).thenReturn(mockTableId);
    when(mockTable.getDefinition()).thenReturn(mockDefinition);
    when(mockDefinition.getType()).thenReturn(type);
    when(mockTable.getDescription()).thenReturn(description);

    return mockTable;
  }

  private StandardSQLDataType mockStandardSQLDataType(StandardSQLTypeName typeKind) {
    StandardSQLDataType mockDataType = mock(StandardSQLDataType.class);
    when(mockDataType.getTypeKind()).thenReturn(typeKind.name());
    return mockDataType;
  }

  private RoutineArgument mockRoutineArgument(String name, StandardSQLTypeName type, String mode) {
    RoutineArgument mockArg = mock(RoutineArgument.class);
    when(mockArg.getName()).thenReturn(name);
    StandardSQLDataType mockDataType = mockStandardSQLDataType(type);
    when(mockArg.getDataType()).thenReturn(mockDataType);
    when(mockArg.getMode()).thenReturn(mode); // "IN", "OUT", "INOUT", or null
    return mockArg;
  }

  private Routine mockBigQueryRoutineWithArgs(
      String project,
      String dataset,
      String routineName,
      String routineType,
      String description,
      List<RoutineArgument> arguments) {
    Routine mockRoutine = mock(Routine.class);
    RoutineId mockRoutineId = RoutineId.of(project, dataset, routineName);
    when(mockRoutine.getRoutineId()).thenReturn(mockRoutineId);
    when(mockRoutine.getRoutineType()).thenReturn(routineType);
    when(mockRoutine.getDescription()).thenReturn(description);
    if (arguments != null) {
      when(mockRoutine.getArguments()).thenReturn(arguments);
    } else {
      when(mockRoutine.getArguments()).thenReturn(Collections.emptyList());
    }
    return mockRoutine;
  }

  private StandardSQLTableType mockStandardSQLTableType(List<StandardSQLField> columns) {
    StandardSQLTableType mockTableType = mock(StandardSQLTableType.class);
    when(mockTableType.getColumns()).thenReturn(columns);
    return mockTableType;
  }

  private StandardSQLField mockStandardSQLField(String name, StandardSQLTypeName type) {
    StandardSQLField mockField = mock(StandardSQLField.class);
    StandardSQLDataType mockedDataType = mockStandardSQLDataType(type);
    when(mockField.getName()).thenReturn(name);
    when(mockField.getDataType()).thenReturn(mockedDataType);
    return mockField;
  }

  @Test
  public void testBigqueryDatabaseMetaDataGetters() throws SQLException {
    BigQueryDatabaseMetaData dbMetadata = new BigQueryDatabaseMetaData(bigQueryConnection);
    assertEquals("GoogleJDBCDriverForGoogleBigQuery", dbMetadata.getDriverName());
    assertEquals("Google BigQuery", dbMetadata.getDatabaseProductName());
    assertEquals("2.0", dbMetadata.getDatabaseProductVersion());
    assertEquals("Dataset", dbMetadata.getSchemaTerm());
    assertEquals("Procedure", dbMetadata.getProcedureTerm());
    assertEquals("Project", dbMetadata.getCatalogTerm());
  }

  @Test
  public void testReadSqlFromFile() throws SQLException {
    BigQueryDatabaseMetaData dbMetadata = new BigQueryDatabaseMetaData(bigQueryConnection);

    String primaryKeysQuery =
        BigQueryDatabaseMetaData.readSqlFromFile("DatabaseMetaData_GetPrimaryKeys.sql");
    assertTrue(primaryKeysQuery.contains("pk$"));

    try {
      when(bigQueryConnection.prepareStatement(primaryKeysQuery)).thenCallRealMethod();
      String sql =
          dbMetadata.replaceSqlParameters(
              primaryKeysQuery, "project_name", "dataset_name", "table_name");
      assertTrue(sql.contains("project_name.dataset_name.INFORMATION_SCHEMA.KEY_COLUMN_USAGE"));
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  public void testNeedsListing() {
    assertTrue("Null pattern should require listing", dbMetadata.needsListing(null));
    assertTrue("Pattern with % should require listing", dbMetadata.needsListing("abc%def"));
    assertTrue("Pattern with _ should require listing", dbMetadata.needsListing("abc_def"));
    assertTrue("Pattern with both wildcards", dbMetadata.needsListing("a%c_d%f"));
    assertFalse("Empty pattern should not require listing", dbMetadata.needsListing(""));
    assertFalse("Pattern without wildcards", dbMetadata.needsListing("exactName"));
  }

  @Test
  public void testCompileSqlLikePattern() {
    // Null input -> Null pattern
    assertNull(dbMetadata.compileSqlLikePattern(null));

    // Empty input -> Pattern matching nothing ($^)
    Pattern emptyPattern = dbMetadata.compileSqlLikePattern("");
    assertNotNull(emptyPattern);
    assertFalse(emptyPattern.matcher("").matches());
    assertFalse(emptyPattern.matcher("a").matches());
    assertEquals("(?!)", emptyPattern.pattern());

    // Exact match
    Pattern exactPattern = dbMetadata.compileSqlLikePattern("tableName");
    assertNotNull(exactPattern);
    assertTrue(exactPattern.matcher("tableName").matches());
    assertTrue(exactPattern.matcher("TABLENAME").matches());
    assertFalse(exactPattern.matcher("tableNameX").matches());
    assertFalse(exactPattern.matcher("XtableName").matches());

    // Percent wildcard (%) -> .*
    Pattern percentPattern = dbMetadata.compileSqlLikePattern("table%");
    assertNotNull(percentPattern);
    assertTrue(percentPattern.matcher("table").matches());
    assertTrue(percentPattern.matcher("tableName").matches());
    assertTrue(percentPattern.matcher("TABLE_123").matches());
    assertFalse(percentPattern.matcher("myTable").matches());

    Pattern percentPattern2 = dbMetadata.compileSqlLikePattern("%Name");
    assertNotNull(percentPattern2);
    assertTrue(percentPattern2.matcher("Name").matches());
    assertTrue(percentPattern2.matcher("tableName").matches());
    assertTrue(percentPattern2.matcher("VIEW_NAME").matches());
    assertFalse(percentPattern2.matcher("NameSuffix").matches());

    Pattern percentPattern3 = dbMetadata.compileSqlLikePattern("ta%le");
    assertNotNull(percentPattern3);
    assertTrue(percentPattern3.matcher("table").matches());
    assertTrue(percentPattern3.matcher("TALLE").matches());
    assertTrue(percentPattern3.matcher("tale").matches());
    assertFalse(percentPattern3.matcher("table123").matches());

    // Underscore wildcard (_) -> .
    Pattern underscorePattern = dbMetadata.compileSqlLikePattern("t_ble");
    assertNotNull(underscorePattern);
    assertTrue(underscorePattern.matcher("table").matches());
    assertTrue(underscorePattern.matcher("tAble").matches());
    assertTrue(underscorePattern.matcher("tXble").matches());
    assertFalse(underscorePattern.matcher("tble").matches());
    assertFalse(underscorePattern.matcher("taable").matches());

    // Mixed wildcards
    Pattern mixedPattern = dbMetadata.compileSqlLikePattern("data_%_set%");
    assertNotNull(mixedPattern);
    assertTrue(mixedPattern.matcher("data_1_set").matches());
    assertTrue(mixedPattern.matcher("data_foo_set_bar").matches());
    assertTrue(mixedPattern.matcher("DATA_X_SET").matches());
    assertFalse(mixedPattern.matcher("dataset").matches());
    assertFalse(mixedPattern.matcher("data_set").matches());

    // Escaping regex metacharacters
    Pattern dotPattern = dbMetadata.compileSqlLikePattern("version_1.0");
    assertNotNull(dotPattern);
    assertTrue(dotPattern.matcher("version_1.0").matches());
    assertFalse(dotPattern.matcher("version_1X0").matches());

    Pattern bracketPattern = dbMetadata.compileSqlLikePattern("array[0]");
    assertNotNull(bracketPattern);
    assertTrue(bracketPattern.matcher("array[0]").matches());
    assertFalse(bracketPattern.matcher("array_0_").matches());
  }

  @Test
  public void testMapBigQueryTypeToJdbc_ScalarTypes() {
    // INT64 -> BIGINT
    Field fieldInt64 =
        Field.newBuilder("test_int", StandardSQLTypeName.INT64)
            .setMode(Field.Mode.NULLABLE)
            .build();
    BigQueryDatabaseMetaData.ColumnTypeInfo infoInt64 =
        dbMetadata.mapBigQueryTypeToJdbc(fieldInt64);
    assertEquals(Types.BIGINT, infoInt64.jdbcType);
    assertEquals("BIGINT", infoInt64.typeName);
    assertEquals(Integer.valueOf(19), infoInt64.columnSize);
    assertEquals(Integer.valueOf(0), infoInt64.decimalDigits);
    assertEquals(Integer.valueOf(10), infoInt64.numPrecRadix);

    // STRING -> NVARCHAR
    Field fieldString =
        Field.newBuilder("test_string", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build();
    BigQueryDatabaseMetaData.ColumnTypeInfo infoString =
        dbMetadata.mapBigQueryTypeToJdbc(fieldString);
    assertEquals(Types.NVARCHAR, infoString.jdbcType);
    assertEquals("NVARCHAR", infoString.typeName);
    assertNull(infoString.columnSize);
    assertNull(infoString.decimalDigits);
    assertNull(infoString.numPrecRadix);

    // BOOL -> BOOLEAN
    Field fieldBool =
        Field.newBuilder("test_bool", StandardSQLTypeName.BOOL)
            .setMode(Field.Mode.NULLABLE)
            .build();
    BigQueryDatabaseMetaData.ColumnTypeInfo infoBool = dbMetadata.mapBigQueryTypeToJdbc(fieldBool);
    assertEquals(Types.BOOLEAN, infoBool.jdbcType);
    assertEquals("BOOLEAN", infoBool.typeName);
    assertEquals(Integer.valueOf(1), infoBool.columnSize);

    // BYTES -> VARBINARY
    Field fieldBytes =
        Field.newBuilder("test_bytes", StandardSQLTypeName.BYTES)
            .setMode(Field.Mode.NULLABLE)
            .build();
    BigQueryDatabaseMetaData.ColumnTypeInfo infoBytes =
        dbMetadata.mapBigQueryTypeToJdbc(fieldBytes);
    assertEquals(Types.VARBINARY, infoBytes.jdbcType);
    assertEquals("VARBINARY", infoBytes.typeName);
    assertNull(infoBytes.columnSize);

    // TIMESTAMP -> TIMESTAMP
    Field fieldTimestamp =
        Field.newBuilder("test_ts", StandardSQLTypeName.TIMESTAMP)
            .setMode(Field.Mode.NULLABLE)
            .build();
    BigQueryDatabaseMetaData.ColumnTypeInfo infoTimestamp =
        dbMetadata.mapBigQueryTypeToJdbc(fieldTimestamp);
    assertEquals(Types.TIMESTAMP, infoTimestamp.jdbcType);
    assertEquals("TIMESTAMP", infoTimestamp.typeName);
    assertEquals(Integer.valueOf(29), infoTimestamp.columnSize);
    assertNull(infoTimestamp.decimalDigits);
    assertNull(infoTimestamp.numPrecRadix);

    // DATETIME -> TIMESTAMP
    Field fieldDateTime =
        Field.newBuilder("test_dt", StandardSQLTypeName.DATETIME)
            .setMode(Field.Mode.NULLABLE)
            .build();
    BigQueryDatabaseMetaData.ColumnTypeInfo infoDateTime =
        dbMetadata.mapBigQueryTypeToJdbc(fieldDateTime);
    assertEquals(Types.TIMESTAMP, infoDateTime.jdbcType);
    assertEquals("TIMESTAMP", infoDateTime.typeName);
    assertEquals(Integer.valueOf(29), infoDateTime.columnSize);
    assertNull(infoDateTime.decimalDigits);
    assertNull(infoDateTime.numPrecRadix);

    // NUMERIC -> NUMERIC
    Field fieldNumeric =
        Field.newBuilder("test_num", StandardSQLTypeName.NUMERIC)
            .setMode(Field.Mode.NULLABLE)
            .build();
    BigQueryDatabaseMetaData.ColumnTypeInfo infoNumeric =
        dbMetadata.mapBigQueryTypeToJdbc(fieldNumeric);
    assertEquals(Types.NUMERIC, infoNumeric.jdbcType);
    assertEquals("NUMERIC", infoNumeric.typeName);
    assertEquals(Integer.valueOf(38), infoNumeric.columnSize);
    assertEquals(Integer.valueOf(9), infoNumeric.decimalDigits);
    assertEquals(Integer.valueOf(10), infoNumeric.numPrecRadix);

    // BIGNUMERIC -> NUMERIC
    Field fieldBigNumeric =
        Field.newBuilder("test_bignum", StandardSQLTypeName.BIGNUMERIC)
            .setMode(Field.Mode.NULLABLE)
            .build();
    BigQueryDatabaseMetaData.ColumnTypeInfo infoBigNumeric =
        dbMetadata.mapBigQueryTypeToJdbc(fieldBigNumeric);
    assertEquals(Types.NUMERIC, infoBigNumeric.jdbcType);
    assertEquals("NUMERIC", infoBigNumeric.typeName);
    assertEquals(Integer.valueOf(77), infoBigNumeric.columnSize);
    assertEquals(Integer.valueOf(38), infoBigNumeric.decimalDigits);
    assertEquals(Integer.valueOf(10), infoBigNumeric.numPrecRadix);

    // GEOGRAPHY -> VARCHAR
    Field fieldGeo =
        Field.newBuilder("test_geo", StandardSQLTypeName.GEOGRAPHY)
            .setMode(Field.Mode.NULLABLE)
            .build();
    BigQueryDatabaseMetaData.ColumnTypeInfo infoGeo = dbMetadata.mapBigQueryTypeToJdbc(fieldGeo);
    assertEquals(Types.VARCHAR, infoGeo.jdbcType);
    assertEquals("VARCHAR", infoGeo.typeName);
    assertNull(infoGeo.columnSize);

    // DATE
    Field fieldDate =
        Field.newBuilder("test_date", StandardSQLTypeName.DATE)
            .setMode(Field.Mode.NULLABLE)
            .build();
    BigQueryDatabaseMetaData.ColumnTypeInfo infoDate = dbMetadata.mapBigQueryTypeToJdbc(fieldDate);
    assertEquals(Types.DATE, infoDate.jdbcType);
    assertEquals("DATE", infoDate.typeName);

    // TIME
    Field fieldTime =
        Field.newBuilder("test_time", StandardSQLTypeName.TIME)
            .setMode(Field.Mode.NULLABLE)
            .build();
    BigQueryDatabaseMetaData.ColumnTypeInfo infoTime = dbMetadata.mapBigQueryTypeToJdbc(fieldTime);
    assertEquals(Types.TIME, infoTime.jdbcType);
    assertEquals("TIME", infoTime.typeName);

    // STRUCT
    Field fieldStruct =
        Field.newBuilder(
                "test_struct",
                StandardSQLTypeName.STRUCT,
                Field.of("sub_field", StandardSQLTypeName.STRING))
            .setMode(Field.Mode.NULLABLE)
            .build();
    BigQueryDatabaseMetaData.ColumnTypeInfo infoStruct =
        dbMetadata.mapBigQueryTypeToJdbc(fieldStruct);
    assertEquals(Types.STRUCT, infoStruct.jdbcType);
    assertEquals("STRUCT", infoStruct.typeName);
  }

  @Test
  public void testMapBigQueryTypeToJdbc_ArrayType() {
    Field fieldArray =
        Field.newBuilder("test_array", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.REPEATED)
            .build();

    BigQueryDatabaseMetaData.ColumnTypeInfo infoArray =
        dbMetadata.mapBigQueryTypeToJdbc(fieldArray);
    assertEquals(Types.ARRAY, infoArray.jdbcType);
    assertEquals("ARRAY", infoArray.typeName);
    assertNull(infoArray.columnSize);
    assertNull(infoArray.decimalDigits);
    assertNull(infoArray.numPrecRadix);
  }

  @Test
  public void testCreateColumnRow() {
    Field realField =
        Field.newBuilder("user_name", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .setDescription("Name of the user")
            .build();

    String catalog = "test-project";
    String schema = "test_dataset";
    String table = "users";
    int ordinalPos = 3;

    List<FieldValue> row =
        dbMetadata.createColumnRow(catalog, schema, table, realField, ordinalPos);

    assertNotNull(row);
    assertEquals(24, row.size());

    assertEquals(catalog, row.get(0).getStringValue()); // 1. TABLE_CAT
    assertEquals(schema, row.get(1).getStringValue()); // 2. TABLE_SCHEM
    assertEquals(table, row.get(2).getStringValue()); // 3. TABLE_NAME
    assertEquals("user_name", row.get(3).getStringValue()); // 4. COLUMN_NAME
    assertEquals(String.valueOf(Types.NVARCHAR), row.get(4).getStringValue()); // 5. DATA_TYPE
    assertEquals("NVARCHAR", row.get(5).getStringValue()); // 6. TYPE_NAME
    assertTrue(row.get(6).isNull()); // 7. COLUMN_SIZE (was null for STRING)
    assertTrue(row.get(7).isNull()); // 8. BUFFER_LENGTH (always null)
    assertTrue(row.get(8).isNull()); // 9. DECIMAL_DIGITS (null for STRING)
    assertTrue(row.get(9).isNull()); // 10. NUM_PREC_RADIX (null for STRING)
    assertEquals(
        String.valueOf(DatabaseMetaData.columnNullable),
        row.get(10).getStringValue()); // 11. NULLABLE
    assertEquals("Name of the user", row.get(11).getStringValue()); // 12. REMARKS
    assertTrue(row.get(12).isNull()); // 13. COLUMN_DEF (null)
    // 14, 15 unused
    assertTrue(row.get(15).isNull()); // 16. CHAR_OCTET_LENGTH (was null)
    assertEquals(String.valueOf(ordinalPos), row.get(16).getStringValue()); // 17. ORDINAL_POSITION
    assertEquals("YES", row.get(17).getStringValue()); // 18. IS_NULLABLE (YES for NULLABLE mode)
    // 19-22 SCOPE/SOURCE (null)
    assertEquals("NO", row.get(22).getStringValue()); // 23. IS_AUTOINCREMENT (NO)
    assertEquals("NO", row.get(23).getStringValue()); // 24. IS_GENERATEDCOLUMN (NO)
  }

  @Test
  public void testCreateColumnRow_RequiredInt() {
    Field realField =
        Field.newBuilder("user_id", StandardSQLTypeName.INT64).setMode(Field.Mode.REQUIRED).build();

    String catalog = "p";
    String schema = "d";
    String table = "t";
    int ordinalPos = 1;

    List<FieldValue> row =
        dbMetadata.createColumnRow(catalog, schema, table, realField, ordinalPos);

    assertEquals(24, row.size());
    assertEquals("user_id", row.get(3).getStringValue()); // COLUMN_NAME
    assertEquals(String.valueOf(Types.BIGINT), row.get(4).getStringValue()); // DATA_TYPE
    assertEquals("BIGINT", row.get(5).getStringValue()); // TYPE_NAME
    assertEquals("19", row.get(6).getStringValue()); // COLUMN_SIZE
    assertEquals("0", row.get(8).getStringValue()); // DECIMAL_DIGITS
    assertEquals("10", row.get(9).getStringValue()); // NUM_PREC_RADIX
    assertEquals(
        String.valueOf(DatabaseMetaData.columnNoNulls), row.get(10).getStringValue()); // NULLABLE
    assertTrue(row.get(11).isNull()); // REMARKS (null description)
    assertEquals(String.valueOf(ordinalPos), row.get(16).getStringValue()); // ORDINAL_POSITION
    assertEquals("NO", row.get(17).getStringValue()); // IS_NULLABLE (NO for REQUIRED mode)
  }

  @Test
  public void testDefineGetTablesSchema() {
    Schema schema = dbMetadata.defineGetTablesSchema();
    assertNotNull(schema);
    FieldList fields = schema.getFields();
    assertEquals(10, fields.size());

    Field tableCat = fields.get("TABLE_CAT");
    assertEquals("TABLE_CAT", tableCat.getName());
    assertEquals(StandardSQLTypeName.STRING, tableCat.getType().getStandardType());
    assertEquals(Field.Mode.NULLABLE, tableCat.getMode());

    Field tableName = fields.get("TABLE_NAME");
    assertEquals("TABLE_NAME", tableName.getName());
    assertEquals(StandardSQLTypeName.STRING, tableName.getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, tableName.getMode());

    Field tableType = fields.get("TABLE_TYPE");
    assertEquals("TABLE_TYPE", tableType.getName());
    assertEquals(StandardSQLTypeName.STRING, tableType.getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, tableType.getMode());

    Field remarks = fields.get("REMARKS");
    assertEquals("REMARKS", remarks.getName());
    assertEquals(StandardSQLTypeName.STRING, remarks.getType().getStandardType());
    assertEquals(Field.Mode.NULLABLE, remarks.getMode());

    Field refGeneration = fields.get("REF_GENERATION");
    assertEquals("REF_GENERATION", refGeneration.getName());
    assertEquals(StandardSQLTypeName.STRING, refGeneration.getType().getStandardType());
    assertEquals(Field.Mode.NULLABLE, refGeneration.getMode());
  }

  @Test
  public void testProcessTableInfo_Basic() {
    Schema resultSchema = dbMetadata.defineGetTablesSchema();
    FieldList resultSchemaFields = resultSchema.getFields();
    List<FieldValueList> collectedResults = Collections.synchronizedList(new ArrayList<>());

    String catalog = "proj";
    String schema = "ds";
    String name = "my_table";
    TableDefinition.Type type = TableDefinition.Type.TABLE;
    String description = "My test table";

    Table table = mockBigQueryTable(catalog, schema, name, type, description);

    dbMetadata.processTableInfo(table, null, collectedResults, resultSchemaFields);

    assertEquals(1, collectedResults.size());
    FieldValueList row = collectedResults.get(0);
    assertNotNull(row);
    assertEquals(10, row.size());
    assertEquals(catalog, row.get("TABLE_CAT").getStringValue());
    assertEquals(schema, row.get("TABLE_SCHEM").getStringValue());
    assertEquals(name, row.get("TABLE_NAME").getStringValue());
    assertEquals(type.toString(), row.get("TABLE_TYPE").getStringValue());
    assertEquals(description, row.get("REMARKS").getStringValue());
    assertTrue(row.get("TYPE_CAT").isNull());
    assertTrue(row.get("TYPE_SCHEM").isNull());
    assertTrue(row.get("TYPE_NAME").isNull());
    assertTrue(row.get("SELF_REFERENCING_COL_NAME").isNull());
    assertTrue(row.get("REF_GENERATION").isNull());
  }

  @Test
  public void testProcessTableInfo_TypeFilterMatch() {
    Schema resultSchema = dbMetadata.defineGetTablesSchema();
    FieldList resultSchemaFields = resultSchema.getFields();
    List<FieldValueList> collectedResults = Collections.synchronizedList(new ArrayList<>());
    Set<String> requestedTypes = new HashSet<>(Arrays.asList("VIEW", "TABLE"));

    Table table = mockBigQueryTable("p", "d", "t", TableDefinition.Type.TABLE, "Desc");

    dbMetadata.processTableInfo(table, requestedTypes, collectedResults, resultSchemaFields);

    assertEquals(1, collectedResults.size());
    assertEquals("TABLE", collectedResults.get(0).get("TABLE_TYPE").getStringValue());
  }

  @Test
  public void testProcessTableInfo_TypeFilterMismatch() {
    Schema resultSchema = dbMetadata.defineGetTablesSchema();
    FieldList resultSchemaFields = resultSchema.getFields();
    List<FieldValueList> collectedResults = Collections.synchronizedList(new ArrayList<>());
    Set<String> requestedTypes = new HashSet<>(Collections.singletonList("VIEW"));

    Table table = mockBigQueryTable("p", "d", "t", TableDefinition.Type.TABLE, "Desc");

    dbMetadata.processTableInfo(table, requestedTypes, collectedResults, resultSchemaFields);

    assertEquals(0, collectedResults.size());
  }

  @Test
  public void testProcessTableInfo_NullDescription() {
    Schema resultSchema = dbMetadata.defineGetTablesSchema();
    FieldList resultSchemaFields = resultSchema.getFields();
    List<FieldValueList> collectedResults = Collections.synchronizedList(new ArrayList<>());

    Table table = mockBigQueryTable("p", "d", "t_no_desc", TableDefinition.Type.TABLE, null);

    dbMetadata.processTableInfo(table, null, collectedResults, resultSchemaFields);

    assertEquals(1, collectedResults.size());
    FieldValueList row = collectedResults.get(0);
    assertTrue(row.get("REMARKS").isNull());
  }

  private FieldValueList createTableRow(
      String cat, String schem, String name, String type, FieldList schemaFields) {
    List<FieldValue> values = new ArrayList<>();
    values.add(dbMetadata.createStringFieldValue(cat)); // TABLE_CAT
    values.add(dbMetadata.createStringFieldValue(schem)); // TABLE_SCHEM
    values.add(dbMetadata.createStringFieldValue(name)); // TABLE_NAME
    values.add(dbMetadata.createStringFieldValue(type)); // TABLE_TYPE
    values.add(dbMetadata.createStringFieldValue("Remark for " + name)); // REMARKS
    values.add(dbMetadata.createNullFieldValue()); // TYPE_CAT
    values.add(dbMetadata.createNullFieldValue()); // TYPE_SCHEM
    values.add(dbMetadata.createNullFieldValue()); // TYPE_NAME
    values.add(dbMetadata.createNullFieldValue()); // SELF_REFERENCING_COL_NAME
    values.add(dbMetadata.createNullFieldValue()); // REF_GENERATION
    return FieldValueList.of(values, schemaFields);
  }

  @Test
  public void testSortResults_Tables() {
    Schema resultSchema = dbMetadata.defineGetTablesSchema();
    FieldList schemaFields = resultSchema.getFields();
    List<FieldValueList> results = new ArrayList<>();

    // Add rows in unsorted order (based on TYPE, CAT, SCHEM, NAME)
    results.add(createTableRow("cat_a", "sch_z", "table_1", "TABLE", schemaFields));
    results.add(createTableRow("cat_b", "sch_a", "view_1", "VIEW", schemaFields));
    results.add(createTableRow("cat_a", "sch_c", "table_2", "TABLE", schemaFields));
    results.add(createTableRow(null, "sch_b", "table_0", "TABLE", schemaFields));
    results.add(createTableRow("cat_a", "sch_z", "table_0", "TABLE", schemaFields));
    results.add(createTableRow("cat_a", null, "view_0", "VIEW", schemaFields));

    Comparator<FieldValueList> comparator = dbMetadata.defineGetTablesComparator(schemaFields);
    dbMetadata.sortResults(results, comparator, "getTables", dbMetadata.LOG);

    // Expected order: TABLEs first, then VIEWs. Within type, sort by CAT, SCHEM, NAME
    assertEquals(6, results.size());

    // 1. Null cat, sch_b, table_0, TABLE
    assertTrue("Row 0 TABLE_CAT should be null", results.get(0).get("TABLE_CAT").isNull());
    assertEquals("sch_b", results.get(0).get("TABLE_SCHEM").getStringValue());
    assertEquals("table_0", results.get(0).get("TABLE_NAME").getStringValue());
    assertEquals("TABLE", results.get(0).get("TABLE_TYPE").getStringValue());

    // 2. cat_a, sch_c, table_2, TABLE
    assertEquals("cat_a", results.get(1).get("TABLE_CAT").getStringValue());
    assertEquals("sch_c", results.get(1).get("TABLE_SCHEM").getStringValue());
    assertEquals("table_2", results.get(1).get("TABLE_NAME").getStringValue());
    assertEquals("TABLE", results.get(1).get("TABLE_TYPE").getStringValue());

    // 3. cat_a, sch_z, table_0, TABLE
    assertEquals("cat_a", results.get(2).get("TABLE_CAT").getStringValue());
    assertEquals("sch_z", results.get(2).get("TABLE_SCHEM").getStringValue());
    assertEquals("table_0", results.get(2).get("TABLE_NAME").getStringValue());
    assertEquals("TABLE", results.get(2).get("TABLE_TYPE").getStringValue());

    // 4. cat_a, sch_z, table_1, TABLE
    assertEquals("cat_a", results.get(3).get("TABLE_CAT").getStringValue());
    assertEquals("sch_z", results.get(3).get("TABLE_SCHEM").getStringValue());
    assertEquals("table_1", results.get(3).get("TABLE_NAME").getStringValue());
    assertEquals("TABLE", results.get(3).get("TABLE_TYPE").getStringValue());

    // 5. cat_a, null, view_0, VIEW
    assertEquals("cat_a", results.get(4).get("TABLE_CAT").getStringValue());
    assertTrue("Row 4 TABLE_SCHEM should be null", results.get(4).get("TABLE_SCHEM").isNull());
    assertEquals("view_0", results.get(4).get("TABLE_NAME").getStringValue());
    assertEquals("VIEW", results.get(4).get("TABLE_TYPE").getStringValue());

    // 6. cat_b, sch_a, view_1, VIEW
    assertEquals("cat_b", results.get(5).get("TABLE_CAT").getStringValue());
    assertEquals("sch_a", results.get(5).get("TABLE_SCHEM").getStringValue());
    assertEquals("view_1", results.get(5).get("TABLE_NAME").getStringValue());
    assertEquals("VIEW", results.get(5).get("TABLE_TYPE").getStringValue());
  }

  @Test
  public void testSortResults_Tables_EmptyList() {
    Schema resultSchema = dbMetadata.defineGetTablesSchema();
    FieldList schemaFields = resultSchema.getFields();
    List<FieldValueList> results = new ArrayList<>();

    Comparator<FieldValueList> comparator = dbMetadata.defineGetTablesComparator(schemaFields);
    dbMetadata.sortResults(results, comparator, "getTables", dbMetadata.LOG);
    assertTrue(results.isEmpty());
  }

  @Test
  public void testDefineGetSchemasSchema() {
    Schema schema = dbMetadata.defineGetSchemasSchema();
    assertNotNull(schema);
    FieldList fields = schema.getFields();
    assertEquals(2, fields.size());

    Field tableSchem = fields.get("TABLE_SCHEM");
    assertEquals("TABLE_SCHEM", tableSchem.getName());
    assertEquals(StandardSQLTypeName.STRING, tableSchem.getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, tableSchem.getMode());

    Field tableCatalog = fields.get("TABLE_CATALOG");
    assertEquals("TABLE_CATALOG", tableCatalog.getName());
    assertEquals(StandardSQLTypeName.STRING, tableCatalog.getType().getStandardType());
    assertEquals(Field.Mode.NULLABLE, tableCatalog.getMode());
  }

  private Dataset mockBigQueryDataset(String project, String datasetName) {
    Dataset mockDataset = mock(Dataset.class);
    DatasetId mockDatasetId = DatasetId.of(project, datasetName);
    when(mockDataset.getDatasetId()).thenReturn(mockDatasetId);
    return mockDataset;
  }

  @Test
  public void testProcessSchemaInfo() {
    Schema resultSchema = dbMetadata.defineGetSchemasSchema();
    FieldList resultSchemaFields = resultSchema.getFields();
    List<FieldValueList> collectedResults = Collections.synchronizedList(new ArrayList<>());

    String catalog = "project-alpha";
    String schemaName = "dataset_beta";
    Dataset dataset = mockBigQueryDataset(catalog, schemaName);

    dbMetadata.processSchemaInfo(dataset, collectedResults, resultSchemaFields);

    assertEquals(1, collectedResults.size());
    FieldValueList row = collectedResults.get(0);
    assertNotNull(row);
    assertEquals(2, row.size());
    assertEquals(schemaName, row.get("TABLE_SCHEM").getStringValue());
    assertEquals(catalog, row.get("TABLE_CATALOG").getStringValue());
  }

  private FieldValueList createSchemaRow(String cat, String schem, FieldList schemaFields) {
    List<FieldValue> values = new ArrayList<>();
    values.add(dbMetadata.createStringFieldValue(schem)); // TABLE_SCHEM
    values.add(dbMetadata.createStringFieldValue(cat)); // TABLE_CATALOG
    return FieldValueList.of(values, schemaFields);
  }

  @Test
  public void testSortResults_Schemas() {
    Schema resultSchema = dbMetadata.defineGetSchemasSchema();
    FieldList schemaFields = resultSchema.getFields();
    List<FieldValueList> results = new ArrayList<>();

    results.add(createSchemaRow("proj_b", "schema_z", schemaFields));
    results.add(createSchemaRow("proj_a", "schema_y", schemaFields));
    results.add(createSchemaRow(null, "schema_x", schemaFields));
    results.add(createSchemaRow("proj_b", "schema_a", schemaFields));
    results.add(createSchemaRow("proj_a", "schema_c", schemaFields));

    Comparator<FieldValueList> comparator = dbMetadata.defineGetSchemasComparator(schemaFields);
    dbMetadata.sortResults(results, comparator, "getSchemas", dbMetadata.LOG);

    // Expected order: Sort by TABLE_CATALOG (nulls first), then TABLE_SCHEM
    assertEquals(5, results.size());

    // 1. Null catalog, schema_x
    assertTrue("Row 0 TABLE_CATALOG should be null", results.get(0).get("TABLE_CATALOG").isNull());
    assertEquals("schema_x", results.get(0).get("TABLE_SCHEM").getStringValue());

    // 2. proj_a, schema_c
    assertEquals("proj_a", results.get(1).get("TABLE_CATALOG").getStringValue());
    assertEquals("schema_c", results.get(1).get("TABLE_SCHEM").getStringValue());

    // 3. proj_a, schema_y
    assertEquals("proj_a", results.get(2).get("TABLE_CATALOG").getStringValue());
    assertEquals("schema_y", results.get(2).get("TABLE_SCHEM").getStringValue());

    // 4. proj_b, schema_a
    assertEquals("proj_b", results.get(3).get("TABLE_CATALOG").getStringValue());
    assertEquals("schema_a", results.get(3).get("TABLE_SCHEM").getStringValue());

    // 5. proj_b, schema_z
    assertEquals("proj_b", results.get(4).get("TABLE_CATALOG").getStringValue());
    assertEquals("schema_z", results.get(4).get("TABLE_SCHEM").getStringValue());
  }

  @Test
  public void testSortResults_Schemas_EmptyList() {
    Schema resultSchema = dbMetadata.defineGetSchemasSchema();
    FieldList schemaFields = resultSchema.getFields();
    List<FieldValueList> results = new ArrayList<>();

    Comparator<FieldValueList> comparator = dbMetadata.defineGetSchemasComparator(schemaFields);
    dbMetadata.sortResults(results, comparator, "getSchemas", dbMetadata.LOG);
    assertTrue(results.isEmpty());
  }

  private Routine mockBigQueryRoutine(
      String project, String dataset, String routineName, String routineType, String description) {
    Routine mockRoutine = mock(Routine.class);
    RoutineId mockRoutineId = RoutineId.of(project, dataset, routineName);
    when(mockRoutine.getRoutineId()).thenReturn(mockRoutineId);
    when(mockRoutine.getRoutineType()).thenReturn(routineType);
    when(mockRoutine.getDescription()).thenReturn(description);
    return mockRoutine;
  }

  @Test
  public void testDefineGetProceduresSchema() {
    Schema schema = dbMetadata.defineGetProceduresSchema();
    assertNotNull(schema);
    FieldList fields = schema.getFields();
    assertEquals(9, fields.size());

    Field procCat = fields.get("PROCEDURE_CAT");
    assertEquals("PROCEDURE_CAT", procCat.getName());
    assertEquals(StandardSQLTypeName.STRING, procCat.getType().getStandardType());
    assertEquals(Field.Mode.NULLABLE, procCat.getMode());

    Field procName = fields.get("PROCEDURE_NAME");
    assertEquals("PROCEDURE_NAME", procName.getName());
    assertEquals(StandardSQLTypeName.STRING, procName.getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, procName.getMode());

    Field remarks = fields.get("REMARKS");
    assertEquals("REMARKS", remarks.getName());
    assertEquals(StandardSQLTypeName.STRING, remarks.getType().getStandardType());
    assertEquals(Field.Mode.NULLABLE, remarks.getMode());

    Field procType = fields.get("PROCEDURE_TYPE");
    assertEquals("PROCEDURE_TYPE", procType.getName());
    assertEquals(StandardSQLTypeName.INT64, procType.getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, procType.getMode());

    Field specificName = fields.get("SPECIFIC_NAME");
    assertEquals("SPECIFIC_NAME", specificName.getName());
    assertEquals(StandardSQLTypeName.STRING, specificName.getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, specificName.getMode());
  }

  @Test
  public void testProcessProcedureInfo_BasicProcedure() {
    Schema resultSchema = dbMetadata.defineGetProceduresSchema();
    FieldList resultSchemaFields = resultSchema.getFields();
    List<FieldValueList> collectedResults = Collections.synchronizedList(new ArrayList<>());

    String catalog = "proj-1";
    String schema = "dataset_a";
    String name = "my_proc";
    String description = "A test procedure";

    Routine routine = mockBigQueryRoutine(catalog, schema, name, "PROCEDURE", description);

    dbMetadata.processProcedureInfo(routine, collectedResults, resultSchemaFields);

    assertEquals(1, collectedResults.size());
    FieldValueList row = collectedResults.get(0);
    assertNotNull(row);
    assertEquals(9, row.size());
    assertEquals(catalog, row.get("PROCEDURE_CAT").getStringValue());
    assertEquals(schema, row.get("PROCEDURE_SCHEM").getStringValue());
    assertEquals(name, row.get("PROCEDURE_NAME").getStringValue());
    assertTrue(row.get("reserved1").isNull());
    assertTrue(row.get("reserved2").isNull());
    assertTrue(row.get("reserved3").isNull());
    assertEquals(description, row.get("REMARKS").getStringValue());
    assertEquals(
        String.valueOf(DatabaseMetaData.procedureResultUnknown),
        row.get("PROCEDURE_TYPE").getStringValue());
    assertEquals(name, row.get("SPECIFIC_NAME").getStringValue());
  }

  @Test
  public void testProcessProcedureInfo_NullDescription() {
    Schema resultSchema = dbMetadata.defineGetProceduresSchema();
    FieldList resultSchemaFields = resultSchema.getFields();
    List<FieldValueList> collectedResults = Collections.synchronizedList(new ArrayList<>());

    String catalog = "proj-1";
    String schema = "dataset_a";
    String name = "proc_no_desc";

    Routine routine = mockBigQueryRoutine(catalog, schema, name, "PROCEDURE", null);

    dbMetadata.processProcedureInfo(routine, collectedResults, resultSchemaFields);

    assertEquals(1, collectedResults.size());
    FieldValueList row = collectedResults.get(0);
    assertTrue(row.get("REMARKS").isNull());
  }

  @Test
  public void testProcessProcedureInfo_SkipsNonProcedure() {
    Schema resultSchema = dbMetadata.defineGetProceduresSchema();
    FieldList resultSchemaFields = resultSchema.getFields();
    List<FieldValueList> collectedResults = Collections.synchronizedList(new ArrayList<>());

    Routine routine = mockBigQueryRoutine("p", "d", "my_func", "FUNCTION", "A function");

    dbMetadata.processProcedureInfo(routine, collectedResults, resultSchemaFields);

    assertTrue(collectedResults.isEmpty());
  }

  private FieldValueList createProcedureRow(
      String cat, String schem, String name, String specName, FieldList schemaFields) {
    List<FieldValue> values = new ArrayList<>();
    values.add(dbMetadata.createStringFieldValue(cat)); // PROCEDURE_CAT
    values.add(dbMetadata.createStringFieldValue(schem)); // PROCEDURE_SCHEM
    values.add(dbMetadata.createStringFieldValue(name)); // PROCEDURE_NAME
    values.add(dbMetadata.createNullFieldValue()); // reserved1
    values.add(dbMetadata.createNullFieldValue()); // reserved2
    values.add(dbMetadata.createNullFieldValue()); // reserved3
    values.add(dbMetadata.createStringFieldValue("Remark for " + name)); // REMARKS
    values.add(
        dbMetadata.createLongFieldValue(
            (long) DatabaseMetaData.procedureResultUnknown)); // PROCEDURE_TYPE
    values.add(dbMetadata.createStringFieldValue(specName)); // SPECIFIC_NAME
    return FieldValueList.of(values, schemaFields);
  }

  @Test
  public void testSortResults_Procedures() {
    Schema resultSchema = dbMetadata.defineGetProceduresSchema();
    FieldList schemaFields = resultSchema.getFields();
    List<FieldValueList> results = new ArrayList<>();

    // Add rows in unsorted order (Sort by CAT, SCHEM, NAME, SPECIFIC_NAME)
    results.add(createProcedureRow("cat_b", "sch_c", "proc_1", "proc_1_spec", schemaFields));
    results.add(
        createProcedureRow("cat_a", "sch_z", "proc_alpha", "proc_alpha_spec", schemaFields));
    results.add(createProcedureRow("cat_a", "sch_z", "proc_beta", "proc_beta_spec", schemaFields));
    results.add(createProcedureRow(null, "sch_y", "proc_gamma", "proc_gamma_spec", schemaFields));
    results.add(createProcedureRow("cat_a", null, "proc_delta", "proc_delta_spec", schemaFields));
    results.add(
        createProcedureRow("cat_a", "sch_z", "proc_alpha", "proc_alpha_spec_older", schemaFields));

    Comparator<FieldValueList> comparator = dbMetadata.defineGetProceduresComparator(schemaFields);
    dbMetadata.sortResults(results, comparator, "getProcedures", dbMetadata.LOG);

    // Expected Order: Null Cat, then Cat A (Null Schem, then sch_z), then Cat B. Within that, Name,
    // then Spec Name.
    assertEquals(6, results.size());

    // 1. Null cat, sch_y, proc_gamma, proc_gamma_spec
    assertTrue("Row 0 PROC_CAT should be null", results.get(0).get("PROCEDURE_CAT").isNull());
    assertEquals("sch_y", results.get(0).get("PROCEDURE_SCHEM").getStringValue());
    assertEquals("proc_gamma", results.get(0).get("PROCEDURE_NAME").getStringValue());
    assertEquals("proc_gamma_spec", results.get(0).get("SPECIFIC_NAME").getStringValue());

    // 2. cat_a, Null schem, proc_delta, proc_delta_spec
    assertEquals("cat_a", results.get(1).get("PROCEDURE_CAT").getStringValue());
    assertTrue("Row 1 PROC_SCHEM should be null", results.get(1).get("PROCEDURE_SCHEM").isNull());
    assertEquals("proc_delta", results.get(1).get("PROCEDURE_NAME").getStringValue());
    assertEquals("proc_delta_spec", results.get(1).get("SPECIFIC_NAME").getStringValue());

    // 3. cat_a, sch_z, proc_alpha, "proc_alpha_spec" (comes first lexicographically) <<< CORRECTED
    // EXPECTATION
    assertEquals("cat_a", results.get(2).get("PROCEDURE_CAT").getStringValue());
    assertEquals("sch_z", results.get(2).get("PROCEDURE_SCHEM").getStringValue());
    assertEquals("proc_alpha", results.get(2).get("PROCEDURE_NAME").getStringValue());
    assertEquals(
        "proc_alpha_spec", results.get(2).get("SPECIFIC_NAME").getStringValue()); // <<< CORRECTED

    // 4. cat_a, sch_z, proc_alpha, "proc_alpha_spec_older" (comes second lexicographically) <<<
    // CORRECTED EXPECTATION
    assertEquals("cat_a", results.get(3).get("PROCEDURE_CAT").getStringValue());
    assertEquals("sch_z", results.get(3).get("PROCEDURE_SCHEM").getStringValue());
    assertEquals("proc_alpha", results.get(3).get("PROCEDURE_NAME").getStringValue());
    assertEquals(
        "proc_alpha_spec_older",
        results.get(3).get("SPECIFIC_NAME").getStringValue()); // <<< CORRECTED

    // 5. cat_a, sch_z, proc_beta, proc_beta_spec
    assertEquals("cat_a", results.get(4).get("PROCEDURE_CAT").getStringValue());
    assertEquals("sch_z", results.get(4).get("PROCEDURE_SCHEM").getStringValue());
    assertEquals("proc_beta", results.get(4).get("PROCEDURE_NAME").getStringValue());
    assertEquals("proc_beta_spec", results.get(4).get("SPECIFIC_NAME").getStringValue());

    // 6. cat_b, sch_c, proc_1, proc_1_spec
    assertEquals("cat_b", results.get(5).get("PROCEDURE_CAT").getStringValue());
    assertEquals("sch_c", results.get(5).get("PROCEDURE_SCHEM").getStringValue());
    assertEquals("proc_1", results.get(5).get("PROCEDURE_NAME").getStringValue());
    assertEquals("proc_1_spec", results.get(5).get("SPECIFIC_NAME").getStringValue());
  }

  @Test
  public void testSortResults_Procedures_EmptyList() {
    Schema resultSchema = dbMetadata.defineGetProceduresSchema();
    FieldList schemaFields = resultSchema.getFields();
    List<FieldValueList> results = new ArrayList<>();

    Comparator<FieldValueList> comparator = dbMetadata.defineGetProceduresComparator(schemaFields);
    dbMetadata.sortResults(results, comparator, "getProcedures", dbMetadata.LOG);
    assertTrue(results.isEmpty());
  }

  @Test
  public void testFindMatchingBigQueryObjects_Routines_ListWithPattern() {
    String catalog = "p-cat";
    String schema = "d-sch";
    String pattern = "proc_%";
    DatasetId datasetId = DatasetId.of(catalog, schema);

    Routine proc1 = mockBigQueryRoutine(catalog, schema, "proc_abc", "PROCEDURE", "p1");
    Routine proc2 = mockBigQueryRoutine(catalog, schema, "proc_xyz", "PROCEDURE", "p2");
    Routine func1 = mockBigQueryRoutine(catalog, schema, "func_123", "FUNCTION", "f1");
    Routine otherProc = mockBigQueryRoutine(catalog, schema, "another_proc", "PROCEDURE", "p3");

    Page<Routine> page = mock(Page.class);
    when(page.iterateAll()).thenReturn(Arrays.asList(proc1, func1, proc2, otherProc));
    when(bigqueryClient.listRoutines(eq(datasetId), any(BigQuery.RoutineListOption.class)))
        .thenReturn(page);

    Pattern regex = dbMetadata.compileSqlLikePattern(pattern);
    assertNotNull(regex);

    List<Routine> results =
        dbMetadata.findMatchingBigQueryObjects(
            "Routine",
            () -> bigqueryClient.listRoutines(datasetId, BigQuery.RoutineListOption.pageSize(500)),
            (name) ->
                bigqueryClient.getRoutine(
                    RoutineId.of(datasetId.getProject(), datasetId.getDataset(), name)),
            (rt) -> rt.getRoutineId().getRoutine(),
            pattern,
            regex,
            dbMetadata.LOG);

    verify(bigqueryClient, times(1))
        .listRoutines(eq(datasetId), any(BigQuery.RoutineListOption.class));
    verify(bigqueryClient, never()).getRoutine(any(RoutineId.class));

    assertNotNull(results);
    List<Routine> resultList = new ArrayList<>(results);

    assertEquals("Should contain only matching routines", 2, resultList.size());
    assertTrue("Should contain proc_abc", resultList.contains(proc1));
    assertTrue("Should contain proc_xyz", resultList.contains(proc2));
    assertFalse("Should not contain func_123", resultList.contains(func1));
    assertFalse("Should not contain another_proc", resultList.contains(otherProc));
  }

  @Test
  public void testFindMatchingBigQueryObjects_Routines_ListNoPattern() {
    String catalog = "p-cat";
    String schema = "d-sch";
    String pattern = null;
    DatasetId datasetId = DatasetId.of(catalog, schema);

    Routine proc1 = mockBigQueryRoutine(catalog, schema, "proc_abc", "PROCEDURE", "p1");
    Routine func1 = mockBigQueryRoutine(catalog, schema, "func_123", "FUNCTION", "f1");

    Page<Routine> page = mock(Page.class);
    when(page.iterateAll()).thenReturn(Arrays.asList(proc1, func1));
    when(bigqueryClient.listRoutines(eq(datasetId), any(BigQuery.RoutineListOption.class)))
        .thenReturn(page);

    Pattern regex = dbMetadata.compileSqlLikePattern(pattern);
    List<Routine> results =
        dbMetadata.findMatchingBigQueryObjects(
            "Routine",
            () -> bigqueryClient.listRoutines(datasetId, BigQuery.RoutineListOption.pageSize(500)),
            (name) ->
                bigqueryClient.getRoutine(
                    RoutineId.of(datasetId.getProject(), datasetId.getDataset(), name)),
            (rt) -> rt.getRoutineId().getRoutine(),
            pattern,
            regex,
            dbMetadata.LOG);

    verify(bigqueryClient, times(1))
        .listRoutines(eq(datasetId), any(BigQuery.RoutineListOption.class));

    assertNotNull(results);
    List<Routine> resultList = new ArrayList<>(results);

    assertEquals("Should contain all routines when pattern is null", 2, resultList.size());
    assertTrue("Should contain proc_abc", resultList.contains(proc1));
    assertTrue("Should contain func_123", resultList.contains(func1));
  }

  @Test
  public void testFindMatchingBigQueryObjects_Routines_GetSpecific() {
    String catalog = "p-cat";
    String schema = "d-sch";
    String procNameExact = "exactprocname";
    DatasetId datasetId = DatasetId.of(catalog, schema);
    RoutineId routineId = RoutineId.of(catalog, schema, procNameExact);
    Routine mockRoutine = mockBigQueryRoutine(catalog, schema, procNameExact, "PROCEDURE", "desc");

    when(bigqueryClient.getRoutine(eq(routineId))).thenReturn(mockRoutine);
    Pattern regex = dbMetadata.compileSqlLikePattern(procNameExact);

    List<Routine> results =
        dbMetadata.findMatchingBigQueryObjects(
            "Routine",
            () -> bigqueryClient.listRoutines(datasetId, BigQuery.RoutineListOption.pageSize(500)),
            (name) ->
                bigqueryClient.getRoutine(
                    RoutineId.of(datasetId.getProject(), datasetId.getDataset(), name)),
            (rt) -> rt.getRoutineId().getRoutine(),
            procNameExact,
            regex,
            dbMetadata.LOG);

    verify(bigqueryClient, times(1)).getRoutine(eq(routineId));
    verify(bigqueryClient, never())
        .listRoutines(any(DatasetId.class), any(BigQuery.RoutineListOption.class));

    assertNotNull(results);
    List<Routine> resultList = new ArrayList<>(results);
    assertEquals(1, resultList.size());
    assertSame(mockRoutine, resultList.get(0));
  }

  @Test
  public void testDefineGetProcedureColumnsSchema() {
    Schema schema = dbMetadata.defineGetProcedureColumnsSchema();
    assertNotNull(schema);
    FieldList fields = schema.getFields();
    assertEquals(20, fields.size());

    Field procCat = fields.get("PROCEDURE_CAT");
    assertEquals("PROCEDURE_CAT", procCat.getName());
    assertEquals(StandardSQLTypeName.STRING, procCat.getType().getStandardType());
    assertEquals(Field.Mode.NULLABLE, procCat.getMode());

    Field colName = fields.get("COLUMN_NAME");
    assertEquals("COLUMN_NAME", colName.getName());
    assertEquals(StandardSQLTypeName.STRING, colName.getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, colName.getMode());

    Field colType = fields.get("COLUMN_TYPE");
    assertEquals("COLUMN_TYPE", colType.getName());
    assertEquals(StandardSQLTypeName.INT64, colType.getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, colType.getMode());

    Field dataType = fields.get("DATA_TYPE");
    assertEquals("DATA_TYPE", dataType.getName());
    assertEquals(StandardSQLTypeName.INT64, dataType.getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, dataType.getMode());

    Field typeName = fields.get("TYPE_NAME");
    assertEquals("TYPE_NAME", typeName.getName());
    assertEquals(StandardSQLTypeName.STRING, typeName.getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, typeName.getMode());

    Field ordinalPos = fields.get("ORDINAL_POSITION");
    assertEquals("ORDINAL_POSITION", ordinalPos.getName());
    assertEquals(StandardSQLTypeName.INT64, ordinalPos.getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, ordinalPos.getMode());

    Field isNullable = fields.get("IS_NULLABLE");
    assertEquals("IS_NULLABLE", isNullable.getName());
    assertEquals(StandardSQLTypeName.STRING, isNullable.getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, isNullable.getMode());

    Field specificName = fields.get("SPECIFIC_NAME");
    assertEquals("SPECIFIC_NAME", specificName.getName());
    assertEquals(StandardSQLTypeName.STRING, specificName.getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, specificName.getMode());
  }

  @Test
  public void testDetermineTypeInfoFromDataType() {
    // INT64
    StandardSQLDataType sqlInt64 = mockStandardSQLDataType(StandardSQLTypeName.INT64);
    BigQueryDatabaseMetaData.ColumnTypeInfo infoInt64 =
        dbMetadata.determineTypeInfoFromDataType(sqlInt64, "p", "c", 1);
    assertEquals(Types.BIGINT, infoInt64.jdbcType);
    assertEquals("BIGINT", infoInt64.typeName);

    // STRING
    StandardSQLDataType sqlString = mockStandardSQLDataType(StandardSQLTypeName.STRING);
    BigQueryDatabaseMetaData.ColumnTypeInfo infoString =
        dbMetadata.determineTypeInfoFromDataType(sqlString, "p", "c", 1);
    assertEquals(Types.NVARCHAR, infoString.jdbcType);
    assertEquals("NVARCHAR", infoString.typeName);

    // BOOL
    StandardSQLDataType sqlBool = mockStandardSQLDataType(StandardSQLTypeName.BOOL);
    BigQueryDatabaseMetaData.ColumnTypeInfo infoBool =
        dbMetadata.determineTypeInfoFromDataType(sqlBool, "p", "c", 1);
    assertEquals(Types.BOOLEAN, infoBool.jdbcType);
    assertEquals("BOOLEAN", infoBool.typeName);

    // STRUCT
    StandardSQLDataType sqlStruct = mockStandardSQLDataType(StandardSQLTypeName.STRUCT);
    BigQueryDatabaseMetaData.ColumnTypeInfo infoStruct =
        dbMetadata.determineTypeInfoFromDataType(sqlStruct, "p", "c", 1);
    assertEquals(Types.STRUCT, infoStruct.jdbcType);
    assertEquals("STRUCT", infoStruct.typeName);

    // Case: null typeKind from StandardSQLDataType (should default to VARCHAR)
    StandardSQLDataType sqlNullKind = mock(StandardSQLDataType.class);
    when(sqlNullKind.getTypeKind()).thenReturn(null);
    BigQueryDatabaseMetaData.ColumnTypeInfo infoNullKind =
        dbMetadata.determineTypeInfoFromDataType(sqlNullKind, "p", "c", 1);
    assertEquals(Types.VARCHAR, infoNullKind.jdbcType);
    assertEquals("VARCHAR", infoNullKind.typeName);

    // Case: unknown typeKind from StandardSQLDataType (should default to VARCHAR)
    StandardSQLDataType sqlUnknownKind = mock(StandardSQLDataType.class);
    when(sqlUnknownKind.getTypeKind()).thenReturn("SUPER_DOOPER_TYPE");
    BigQueryDatabaseMetaData.ColumnTypeInfo infoUnknownKind =
        dbMetadata.determineTypeInfoFromDataType(sqlUnknownKind, "p", "c", 1);
    assertEquals(Types.VARCHAR, infoUnknownKind.jdbcType);
    assertEquals("VARCHAR", infoUnknownKind.typeName);
  }

  @Test
  public void testCreateProcedureColumnRow_BasicInParam() {
    String catalog = "proj_x";
    String schema = "data_y";
    String procName = "proc_z";
    String specificName = "proc_z_specific";

    RoutineArgument arg = mockRoutineArgument("param_in", StandardSQLTypeName.STRING, "IN");
    int ordinalPos = 1;

    List<FieldValue> row =
        dbMetadata.createProcedureColumnRow(
            catalog, schema, procName, specificName, arg, ordinalPos, "param_in");

    assertNotNull(row);
    assertEquals(20, row.size());

    assertEquals(catalog, row.get(0).getStringValue()); // 1. PROCEDURE_CAT
    assertEquals(schema, row.get(1).getStringValue()); // 2. PROCEDURE_SCHEM
    assertEquals(procName, row.get(2).getStringValue()); // 3. PROCEDURE_NAME
    assertEquals("param_in", row.get(3).getStringValue()); // 4. COLUMN_NAME
    assertEquals(
        String.valueOf(DatabaseMetaData.procedureColumnIn),
        row.get(4).getStringValue()); // 5. COLUMN_TYPE
    assertEquals(String.valueOf(Types.NVARCHAR), row.get(5).getStringValue()); // 6. DATA_TYPE
    assertEquals("NVARCHAR", row.get(6).getStringValue()); // 7. TYPE_NAME
    assertTrue(row.get(7).isNull()); // 8. PRECISION
    assertTrue(row.get(8).isNull()); // 9. LENGTH
    assertTrue(row.get(9).isNull()); // 10. SCALE
    assertTrue(row.get(10).isNull()); // 11. RADIX
    assertEquals(
        String.valueOf(DatabaseMetaData.procedureNullable),
        row.get(11).getStringValue()); // 12. NULLABLE
    assertTrue(row.get(12).isNull()); // 13. REMARKS
    assertTrue(row.get(13).isNull()); // 14. COLUMN_DEF
    assertTrue(row.get(14).isNull()); // 15. SQL_DATA_TYPE
    assertTrue(row.get(15).isNull()); // 16. SQL_DATETIME_SUB
    assertTrue(row.get(16).isNull()); // 17. CHAR_OCTET_LENGTH
    assertEquals(String.valueOf(ordinalPos), row.get(17).getStringValue()); // 18. ORDINAL_POSITION
    assertEquals("YES", row.get(18).getStringValue()); // 19. IS_NULLABLE
    assertEquals(specificName, row.get(19).getStringValue()); // 20. SPECIFIC_NAME
  }

  @Test
  public void testCreateProcedureColumnRow_NumericOutParam() {
    RoutineArgument arg = mockRoutineArgument("param_out_num", StandardSQLTypeName.NUMERIC, "OUT");
    int ordinalPos = 2;

    List<FieldValue> row =
        dbMetadata.createProcedureColumnRow(
            "p", "d", "proc", "proc_spec", arg, ordinalPos, "param_out_num");

    assertEquals(
        String.valueOf(DatabaseMetaData.procedureColumnOut),
        row.get(4).getStringValue()); // COLUMN_TYPE
    assertEquals(String.valueOf(Types.NUMERIC), row.get(5).getStringValue()); // DATA_TYPE
    assertEquals("NUMERIC", row.get(6).getStringValue()); // TYPE_NAME
    assertEquals("38", row.get(7).getStringValue()); // PRECISION
    assertEquals("9", row.get(9).getStringValue()); // SCALE
    assertEquals("10", row.get(10).getStringValue()); // RADIX
  }

  @Test
  public void testCreateProcedureColumnRow_InOutTimestampParam() {
    RoutineArgument arg =
        mockRoutineArgument("param_inout_ts", StandardSQLTypeName.TIMESTAMP, "INOUT");
    List<FieldValue> row =
        dbMetadata.createProcedureColumnRow(
            "p", "d", "proc", "proc_spec", arg, 3, "param_inout_ts");

    assertEquals(
        String.valueOf(DatabaseMetaData.procedureColumnInOut), row.get(4).getStringValue());
    assertEquals(String.valueOf(Types.TIMESTAMP), row.get(5).getStringValue());
    assertEquals("TIMESTAMP", row.get(6).getStringValue());
    assertEquals("29", row.get(7).getStringValue()); // PRECISION for TIMESTAMP
  }

  @Test
  public void testCreateProcedureColumnRow_UnknownModeDefaultsToUnknownType() {
    RoutineArgument arg =
        mockRoutineArgument("param_unknown_mode", StandardSQLTypeName.BOOL, "UNKNOWN_MODE");
    List<FieldValue> row =
        dbMetadata.createProcedureColumnRow(
            "p", "d", "proc", "proc_spec", arg, 1, "param_unknown_mode");
    assertEquals(
        String.valueOf(DatabaseMetaData.procedureColumnUnknown), row.get(4).getStringValue());
  }

  @Test
  public void testCreateProcedureColumnRow_NullArgumentObject() {
    List<FieldValue> row =
        dbMetadata.createProcedureColumnRow(
            "cat", "schem", "proc", "spec", null, 1, "fallback_arg_name");

    assertNotNull(row);
    assertEquals(20, row.size());
    assertEquals("fallback_arg_name", row.get(3).getStringValue()); // COLUMN_NAME
    assertEquals(String.valueOf(Types.VARCHAR), row.get(5).getStringValue()); // DATA_TYPE
    assertEquals("VARCHAR", row.get(6).getStringValue()); // TYPE_NAME
    assertEquals(
        String.valueOf(DatabaseMetaData.procedureColumnUnknown), row.get(4).getStringValue());
  }

  @Test
  public void testCreateProcedureColumnRow_NullArgumentDataType() {
    RoutineArgument argWithNullDataType = mock(RoutineArgument.class);
    when(argWithNullDataType.getName()).thenReturn("arg_null_type");
    when(argWithNullDataType.getDataType()).thenReturn(null);
    when(argWithNullDataType.getMode()).thenReturn("IN");

    List<FieldValue> row =
        dbMetadata.createProcedureColumnRow(
            "cat", "schem", "proc", "spec", argWithNullDataType, 1, "arg_null_type");

    assertNotNull(row);
    assertEquals("arg_null_type", row.get(3).getStringValue());
    assertEquals(
        String.valueOf(Types.VARCHAR), row.get(5).getStringValue()); // DATA_TYPE should default
    assertEquals("VARCHAR", row.get(6).getStringValue()); // TYPE_NAME should default
  }

  @Test
  public void testProcessProcedureArguments_NoArguments() {
    Schema resultSchema = dbMetadata.defineGetProcedureColumnsSchema();
    FieldList resultFields = resultSchema.getFields();
    List<FieldValueList> collectedResults = Collections.synchronizedList(new ArrayList<>());
    Pattern noColumnNamePattern = null; // Match all columns

    Routine routine =
        mockBigQueryRoutineWithArgs(
            "p", "d", "proc_no_args", "PROCEDURE", "desc", Collections.emptyList()); // No arguments

    dbMetadata.processProcedureArguments(
        routine, noColumnNamePattern, collectedResults, resultFields);
    assertTrue(collectedResults.isEmpty());
  }

  @Test
  public void testProcessProcedureArguments_WithArgumentsNoFilter() {
    Schema resultSchema = dbMetadata.defineGetProcedureColumnsSchema();
    FieldList resultFields = resultSchema.getFields();
    List<FieldValueList> collectedResults = Collections.synchronizedList(new ArrayList<>());
    Pattern noColumnNamePattern = null;

    RoutineArgument arg1 = mockRoutineArgument("param1", StandardSQLTypeName.INT64, "IN");
    RoutineArgument arg2 = mockRoutineArgument("param2", StandardSQLTypeName.STRING, "OUT");
    Routine routine =
        mockBigQueryRoutineWithArgs(
            "p", "d", "proc_two_args", "PROCEDURE", "desc", Arrays.asList(arg1, arg2));

    dbMetadata.processProcedureArguments(
        routine, noColumnNamePattern, collectedResults, resultFields);
    assertEquals(2, collectedResults.size());
    assertEquals("param1", collectedResults.get(0).get("COLUMN_NAME").getStringValue());
    assertEquals("param2", collectedResults.get(1).get("COLUMN_NAME").getStringValue());
    assertEquals(
        String.valueOf(1), collectedResults.get(0).get("ORDINAL_POSITION").getStringValue());
    assertEquals(
        String.valueOf(2), collectedResults.get(1).get("ORDINAL_POSITION").getStringValue());
  }

  @Test
  public void testProcessProcedureArguments_WithColumnNameFilter() {
    Schema resultSchema = dbMetadata.defineGetProcedureColumnsSchema();
    FieldList resultFields = resultSchema.getFields();
    List<FieldValueList> collectedResults = Collections.synchronizedList(new ArrayList<>());
    Pattern columnNamePattern = Pattern.compile(".*_id"); // Match columns ending with _id

    RoutineArgument arg1 = mockRoutineArgument("user_id", StandardSQLTypeName.INT64, "IN");
    RoutineArgument arg2 = mockRoutineArgument("user_name", StandardSQLTypeName.STRING, "IN");
    RoutineArgument arg3 = mockRoutineArgument("session_id", StandardSQLTypeName.STRING, "INOUT");

    Routine routine =
        mockBigQueryRoutineWithArgs(
            "p", "d", "proc_filtered_args", "PROCEDURE", "desc", Arrays.asList(arg1, arg2, arg3));

    dbMetadata.processProcedureArguments(
        routine, columnNamePattern, collectedResults, resultFields);
    assertEquals(2, collectedResults.size());
    assertEquals("user_id", collectedResults.get(0).get("COLUMN_NAME").getStringValue());
    assertEquals("session_id", collectedResults.get(1).get("COLUMN_NAME").getStringValue());
  }

  @Test
  public void testProcessProcedureArguments_HandlesNullArgumentInList() {
    Schema resultSchema = dbMetadata.defineGetProcedureColumnsSchema();
    FieldList resultFields = resultSchema.getFields();
    List<FieldValueList> collectedResults = Collections.synchronizedList(new ArrayList<>());
    Pattern noColumnNamePattern = null;

    RoutineArgument arg1 = mockRoutineArgument("valid_arg", StandardSQLTypeName.INT64, "IN");
    List<RoutineArgument> argsWithNull = new ArrayList<>();
    argsWithNull.add(arg1);
    argsWithNull.add(null); // Add a null argument
    RoutineArgument arg3 =
        mockRoutineArgument("another_valid_arg", StandardSQLTypeName.STRING, "OUT");
    argsWithNull.add(arg3);

    Routine routine = mock(Routine.class);
    RoutineId routineId = RoutineId.of("p", "d", "proc_with_null_arg_in_list");
    when(routine.getRoutineId()).thenReturn(routineId);
    when(routine.getRoutineType()).thenReturn("PROCEDURE");
    when(routine.getArguments()).thenReturn(argsWithNull);

    dbMetadata.processProcedureArguments(
        routine, noColumnNamePattern, collectedResults, resultFields);

    assertEquals(3, collectedResults.size());
    assertEquals("valid_arg", collectedResults.get(0).get("COLUMN_NAME").getStringValue());
    // The fallback name generated by processProcedureArguments when arg is null in list
    assertEquals(
        "arg_retrieval_err_2", collectedResults.get(1).get("COLUMN_NAME").getStringValue());
    assertEquals(
        String.valueOf(Types.VARCHAR),
        collectedResults.get(1).get("DATA_TYPE").getStringValue()); // Default type for null arg
    assertEquals("another_valid_arg", collectedResults.get(2).get("COLUMN_NAME").getStringValue());
  }

  private FieldValueList createProcedureColumnRowForSortTest(
      String cat,
      String schem,
      String procName,
      String specName,
      String colName,
      int ordinal,
      FieldList schemaFields) {
    List<FieldValue> values = new ArrayList<>(20);
    values.add(dbMetadata.createStringFieldValue(cat)); // 1. PROC_CAT
    values.add(dbMetadata.createStringFieldValue(schem)); // 2. PROC_SCHEM
    values.add(dbMetadata.createStringFieldValue(procName)); // 3. PROC_NAME
    values.add(dbMetadata.createStringFieldValue(colName)); // 4. COLUMN_NAME
    values.add(
        dbMetadata.createLongFieldValue(
            (long) DatabaseMetaData.procedureColumnIn)); // 5. COLUMN_TYPE
    values.add(dbMetadata.createLongFieldValue((long) Types.VARCHAR)); // 6. DATA_TYPE
    values.add(dbMetadata.createStringFieldValue("VARCHAR")); // 7. TYPE_NAME
    values.add(dbMetadata.createNullFieldValue()); // 8. PRECISION
    values.add(dbMetadata.createNullFieldValue()); // 9. LENGTH
    values.add(dbMetadata.createNullFieldValue()); // 10. SCALE
    values.add(dbMetadata.createNullFieldValue()); // 11. RADIX
    values.add(
        dbMetadata.createLongFieldValue((long) DatabaseMetaData.procedureNullable)); // 12. NULLABLE
    values.add(dbMetadata.createStringFieldValue("Remark for " + colName)); // 13. REMARKS
    values.add(dbMetadata.createNullFieldValue()); // 14. COLUMN_DEF
    values.add(dbMetadata.createNullFieldValue()); // 15. SQL_DATA_TYPE
    values.add(dbMetadata.createNullFieldValue()); // 16. SQL_DATETIME_SUB
    values.add(dbMetadata.createNullFieldValue()); // 17. CHAR_OCTET_LENGTH
    values.add(dbMetadata.createLongFieldValue((long) ordinal)); // 18. ORDINAL_POSITION
    values.add(dbMetadata.createStringFieldValue("YES")); // 19. IS_NULLABLE
    values.add(dbMetadata.createStringFieldValue(specName)); // 20. SPECIFIC_NAME
    return FieldValueList.of(values, schemaFields);
  }

  @Test
  public void testDefineGetProcedureColumnsComparator() {
    Schema resultSchema = dbMetadata.defineGetProcedureColumnsSchema();
    FieldList schemaFields = resultSchema.getFields();
    List<FieldValueList> results = new ArrayList<>();

    // Order: PROC_CAT, PROC_SCHEM, PROC_NAME, SPECIFIC_NAME, COLUMN_NAME
    results.add(
        createProcedureColumnRowForSortTest(
            "cat_b", "sch_y", "proc_1", "proc_1_spec", "param_a", 1, schemaFields));
    results.add(
        createProcedureColumnRowForSortTest(
            "cat_a", "sch_z", "proc_alpha", "proc_alpha_spec", "arg_z", 2, schemaFields));
    results.add(
        createProcedureColumnRowForSortTest(
            "cat_a",
            "sch_z",
            "proc_alpha",
            "proc_alpha_spec",
            "arg_m",
            1,
            schemaFields)); // Same proc, different col
    results.add(
        createProcedureColumnRowForSortTest(
            null, "sch_x", "proc_beta", "proc_beta_spec", "col_first", 1, schemaFields));
    results.add(
        createProcedureColumnRowForSortTest(
            "cat_a", null, "proc_gamma", "proc_gamma_spec", "input1", 1, schemaFields));

    Comparator<FieldValueList> comparator =
        dbMetadata.defineGetProcedureColumnsComparator(schemaFields);
    assertNotNull(comparator);
    dbMetadata.sortResults(results, comparator, "getProcedureColumns", dbMetadata.LOG);

    assertEquals(5, results.size());

    // 1. Null cat, sch_x, proc_beta, proc_beta_spec, col_first
    assertTrue(results.get(0).get("PROCEDURE_CAT").isNull());
    assertEquals("sch_x", results.get(0).get("PROCEDURE_SCHEM").getStringValue());
    assertEquals("proc_beta", results.get(0).get("PROCEDURE_NAME").getStringValue());
    assertEquals("proc_beta_spec", results.get(0).get("SPECIFIC_NAME").getStringValue());
    assertEquals("col_first", results.get(0).get("COLUMN_NAME").getStringValue());

    // 2. cat_a, Null schem, proc_gamma, proc_gamma_spec, input1
    assertEquals("cat_a", results.get(1).get("PROCEDURE_CAT").getStringValue());
    assertTrue(results.get(1).get("PROCEDURE_SCHEM").isNull());
    assertEquals("proc_gamma", results.get(1).get("PROCEDURE_NAME").getStringValue());
    assertEquals("proc_gamma_spec", results.get(1).get("SPECIFIC_NAME").getStringValue());
    assertEquals("input1", results.get(1).get("COLUMN_NAME").getStringValue());

    // 3. cat_a, sch_z, proc_alpha, proc_alpha_spec, arg_m (m before z)
    assertEquals("cat_a", results.get(2).get("PROCEDURE_CAT").getStringValue());
    assertEquals("sch_z", results.get(2).get("PROCEDURE_SCHEM").getStringValue());
    assertEquals("proc_alpha", results.get(2).get("PROCEDURE_NAME").getStringValue());
    assertEquals("proc_alpha_spec", results.get(2).get("SPECIFIC_NAME").getStringValue());
    assertEquals("arg_m", results.get(2).get("COLUMN_NAME").getStringValue());

    // 4. cat_a, sch_z, proc_alpha, proc_alpha_spec, arg_z
    assertEquals("cat_a", results.get(3).get("PROCEDURE_CAT").getStringValue());
    assertEquals("sch_z", results.get(3).get("PROCEDURE_SCHEM").getStringValue());
    assertEquals("proc_alpha", results.get(3).get("PROCEDURE_NAME").getStringValue());
    assertEquals("proc_alpha_spec", results.get(3).get("SPECIFIC_NAME").getStringValue());
    assertEquals("arg_z", results.get(3).get("COLUMN_NAME").getStringValue());

    // 5. cat_b, sch_y, proc_1, proc_1_spec, param_a
    assertEquals("cat_b", results.get(4).get("PROCEDURE_CAT").getStringValue());
    assertEquals("sch_y", results.get(4).get("PROCEDURE_SCHEM").getStringValue());
    assertEquals("proc_1", results.get(4).get("PROCEDURE_NAME").getStringValue());
    assertEquals("proc_1_spec", results.get(4).get("SPECIFIC_NAME").getStringValue());
    assertEquals("param_a", results.get(4).get("COLUMN_NAME").getStringValue());
  }

  @Test
  public void testListMatchingProcedureIdsFromDatasets() throws Exception {
    String catalog = "test-proj";
    String schema1Name = "dataset1";
    String schema2Name = "dataset2";
    Dataset dataset1 = mockBigQueryDataset(catalog, schema1Name);
    Dataset dataset2 = mockBigQueryDataset(catalog, schema2Name);
    List<Dataset> datasetsToScan = Arrays.asList(dataset1, dataset2);

    Routine proc1_ds1 = mockBigQueryRoutine(catalog, schema1Name, "proc_a", "PROCEDURE", "desc a");
    Routine func1_ds1 = mockBigQueryRoutine(catalog, schema1Name, "func_b", "FUNCTION", "desc b");
    Routine proc2_ds2 = mockBigQueryRoutine(catalog, schema2Name, "proc_c", "PROCEDURE", "desc c");

    Page<Routine> page1 = mock(Page.class);
    when(page1.iterateAll()).thenReturn(Arrays.asList(proc1_ds1, func1_ds1));
    when(bigqueryClient.listRoutines(eq(dataset1.getDatasetId()), any(RoutineListOption.class)))
        .thenReturn(page1);

    Page<Routine> page2 = mock(Page.class);
    when(page2.iterateAll()).thenReturn(Collections.singletonList(proc2_ds2));
    when(bigqueryClient.listRoutines(eq(dataset2.getDatasetId()), any(RoutineListOption.class)))
        .thenReturn(page2);

    ExecutorService mockExecutor = mock(ExecutorService.class);
    doAnswer(
            invocation -> {
              Callable<?> callable = invocation.getArgument(0);
              @SuppressWarnings("unchecked") // Suppress warning for raw Future mock
              Future<Object> mockedFuture = mock(Future.class);

              try {
                Object result = callable.call();
                doReturn(result).when(mockedFuture).get();
              } catch (InterruptedException interruptedException) {
                doThrow(interruptedException).when(mockedFuture).get();
              } catch (Exception e) {
                doThrow(new ExecutionException(e)).when(mockedFuture).get();
              }
              return mockedFuture;
            })
        .when(mockExecutor)
        .submit(any(Callable.class));

    List<RoutineId> resultIds =
        dbMetadata.listMatchingProcedureIdsFromDatasets(
            datasetsToScan, null, null, mockExecutor, catalog, dbMetadata.LOG);

    assertEquals(2, resultIds.size());
    assertTrue(resultIds.contains(proc1_ds1.getRoutineId()));
    assertTrue(resultIds.contains(proc2_ds2.getRoutineId()));
    assertFalse(resultIds.contains(func1_ds1.getRoutineId())); // Should not contain functions

    verify(mockExecutor, times(2)).submit(any(Callable.class));
  }

  @Test
  public void testSubmitProcedureArgumentProcessingJobs_Basic() throws InterruptedException {
    String catalog = "p";
    String schemaName = "d";
    RoutineArgument arg1 = mockRoutineArgument("arg1_name", StandardSQLTypeName.STRING, "IN");
    Routine proc1 =
        mockBigQueryRoutineWithArgs(
            catalog, schemaName, "proc1", "PROCEDURE", "desc1", Collections.singletonList(arg1));
    Routine func1 =
        mockBigQueryRoutineWithArgs(
            catalog,
            schemaName,
            "func1",
            "FUNCTION",
            "desc_func",
            Collections.emptyList()); // Should be skipped
    Routine proc2 =
        mockBigQueryRoutineWithArgs(
            catalog, schemaName, "proc2", "PROCEDURE", "desc2", Collections.emptyList());

    List<Routine> fullRoutines = Arrays.asList(proc1, func1, proc2);
    Pattern columnNameRegex = null;
    List<FieldValueList> collectedResults = Collections.synchronizedList(new ArrayList<>());
    Schema resultSchema = dbMetadata.defineGetProcedureColumnsSchema();
    FieldList resultSchemaFields = resultSchema.getFields();

    ExecutorService mockExecutor = mock(ExecutorService.class);
    List<Future<?>> processingTaskFutures = new ArrayList<>();

    // Capture the runnable submitted to the executor
    List<Runnable> submittedRunnables = new ArrayList<>();
    doAnswer(
            invocation -> {
              Runnable runnable = invocation.getArgument(0);
              submittedRunnables.add(runnable);
              Future<?> future = mock(Future.class);
              return future;
            })
        .when(mockExecutor)
        .submit(any(Runnable.class));

    dbMetadata.submitProcedureArgumentProcessingJobs(
        fullRoutines,
        columnNameRegex,
        collectedResults,
        resultSchemaFields,
        mockExecutor,
        processingTaskFutures,
        dbMetadata.LOG);

    verify(mockExecutor, times(2)).submit(any(Runnable.class));
    assertEquals(2, processingTaskFutures.size());
  }

  @Test
  public void testDefineGetTableTypesSchema() {
    Schema schema = BigQueryDatabaseMetaData.defineGetTableTypesSchema();

    assertNotNull("Schema should not be null", schema);
    FieldList fields = schema.getFields();
    assertEquals("Should have one column", 1, fields.size());

    Field tableTypeField = fields.get("TABLE_TYPE");
    assertNotNull("TABLE_TYPE field should exist", tableTypeField);
    assertEquals("Field name should be TABLE_TYPE", "TABLE_TYPE", tableTypeField.getName());
    assertEquals(
        "Field type should be STRING",
        StandardSQLTypeName.STRING,
        tableTypeField.getType().getStandardType());
    assertEquals("Field mode should be REQUIRED", Field.Mode.REQUIRED, tableTypeField.getMode());
  }

  @Test
  public void testPrepareGetTableTypesRows() {
    Schema schema = BigQueryDatabaseMetaData.defineGetTableTypesSchema();
    List<FieldValueList> rows = BigQueryDatabaseMetaData.prepareGetTableTypesRows(schema);

    assertNotNull("Rows list should not be null", rows);
    String[] expectedTableTypes = {"EXTERNAL", "MATERIALIZED VIEW", "SNAPSHOT", "TABLE", "VIEW"};
    assertEquals(
        "Should have " + expectedTableTypes.length + " rows",
        expectedTableTypes.length,
        rows.size());

    Set<String> foundTypes = new HashSet<>();
    for (int i = 0; i < rows.size(); i++) {
      FieldValueList row = rows.get(i);
      assertEquals("Row " + i + " should have 1 field value", 1, row.size());
      assertFalse("FieldValue in row " + i + " should not be SQL NULL", row.get(0).isNull());

      String tableType = row.get(0).getStringValue();
      foundTypes.add(tableType);
    }

    assertEquals(
        "All expected table types should be present and correctly mapped",
        new HashSet<>(Arrays.asList(expectedTableTypes)),
        foundTypes);
  }

  @Test
  public void testGetTableTypes() throws SQLException {
    try (ResultSet rs = dbMetadata.getTableTypes()) {
      assertNotNull("ResultSet from getTableTypes() should not be null", rs);

      ResultSetMetaData rsmd = rs.getMetaData();
      assertNotNull("ResultSetMetaData should not be null", rsmd);
      assertEquals("Should have one column", 1, rsmd.getColumnCount());
      assertEquals("Column name should be TABLE_TYPE", "TABLE_TYPE", rsmd.getColumnName(1));
      assertEquals("Column type should be NVARCHAR", Types.NVARCHAR, rsmd.getColumnType(1));

      List<String> actualTableTypes = new ArrayList<>();
      while (rs.next()) {
        actualTableTypes.add(rs.getString("TABLE_TYPE"));
      }

      String[] expectedTableTypes = {"EXTERNAL", "MATERIALIZED VIEW", "SNAPSHOT", "TABLE", "VIEW"};
      assertEquals(
          "Number of table types should match", expectedTableTypes.length, actualTableTypes.size());

      Set<String> expectedSet = new HashSet<>(Arrays.asList(expectedTableTypes));
      Set<String> actualSet = new HashSet<>(actualTableTypes);
      assertEquals(
          "All expected table types should be present in the ResultSet", expectedSet, actualSet);
    }
  }

  @Test
  public void testDefineGetSuperTablesSchema() {
    Schema schema = dbMetadata.defineGetSuperTablesSchema();
    assertNotNull("Schema should not be null", schema);
    FieldList fields = schema.getFields();
    assertEquals("Schema should have 4 fields", 4, fields.size());

    Field tableCat = fields.get("TABLE_CAT");
    assertNotNull(tableCat);
    assertEquals("TABLE_CAT", tableCat.getName());
    assertEquals(StandardSQLTypeName.STRING, tableCat.getType().getStandardType());
    assertEquals(Field.Mode.NULLABLE, tableCat.getMode());

    Field tableSchem = fields.get("TABLE_SCHEM");
    assertNotNull(tableSchem);
    assertEquals("TABLE_SCHEM", tableSchem.getName());
    assertEquals(StandardSQLTypeName.STRING, tableSchem.getType().getStandardType());
    assertEquals(Field.Mode.NULLABLE, tableSchem.getMode());

    Field tableName = fields.get("TABLE_NAME");
    assertNotNull(tableName);
    assertEquals("TABLE_NAME", tableName.getName());
    assertEquals(StandardSQLTypeName.STRING, tableName.getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, tableName.getMode());

    Field superTableName = fields.get("SUPERTABLE_NAME");
    assertNotNull(superTableName);
    assertEquals("SUPERTABLE_NAME", superTableName.getName());
    assertEquals(StandardSQLTypeName.STRING, superTableName.getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, superTableName.getMode());
  }

  @Test
  public void testGetSuperTables_ReturnsEmptyResultSetWithCorrectMetadata() throws SQLException {
    try (ResultSet rs =
        dbMetadata.getSuperTables("testCatalog", "testSchemaPattern", "testTableNamePattern")) {
      assertNotNull("ResultSet should not be null", rs);
      assertFalse("ResultSet should be empty (next() should return false)", rs.next());

      ResultSetMetaData metaData = rs.getMetaData();
      assertNotNull("ResultSetMetaData should not be null", metaData);
      assertEquals("ResultSetMetaData should have 4 columns", 4, metaData.getColumnCount());

      // Column 1: TABLE_CAT
      assertEquals("TABLE_CAT", metaData.getColumnName(1));
      assertEquals(Types.NVARCHAR, metaData.getColumnType(1)); // Assuming STRING maps to VARCHAR
      assertEquals(ResultSetMetaData.columnNullable, metaData.isNullable(1));

      // Column 2: TABLE_SCHEM
      assertEquals("TABLE_SCHEM", metaData.getColumnName(2));
      assertEquals(Types.NVARCHAR, metaData.getColumnType(2));
      assertEquals(ResultSetMetaData.columnNullable, metaData.isNullable(2));

      // Column 3: TABLE_NAME
      assertEquals("TABLE_NAME", metaData.getColumnName(3));
      assertEquals(Types.NVARCHAR, metaData.getColumnType(3));
      assertEquals(ResultSetMetaData.columnNoNulls, metaData.isNullable(3)); // REQUIRED

      // Column 4: SUPERTABLE_NAME
      assertEquals("SUPERTABLE_NAME", metaData.getColumnName(4));
      assertEquals(Types.NVARCHAR, metaData.getColumnType(4));
      assertEquals(ResultSetMetaData.columnNoNulls, metaData.isNullable(4)); // REQUIRED
    }
  }

  @Test
  public void testDefineGetSuperTypesSchema() {
    Schema schema = dbMetadata.defineGetSuperTypesSchema();
    assertNotNull("Schema should not be null", schema);
    FieldList fields = schema.getFields();
    assertEquals("Schema should have 6 fields", 6, fields.size());

    Field typeCat = fields.get("TYPE_CAT");
    assertNotNull(typeCat);
    assertEquals("TYPE_CAT", typeCat.getName());
    assertEquals(StandardSQLTypeName.STRING, typeCat.getType().getStandardType());
    assertEquals(Field.Mode.NULLABLE, typeCat.getMode());

    Field typeSchem = fields.get("TYPE_SCHEM");
    assertNotNull(typeSchem);
    assertEquals("TYPE_SCHEM", typeSchem.getName());
    assertEquals(StandardSQLTypeName.STRING, typeSchem.getType().getStandardType());
    assertEquals(Field.Mode.NULLABLE, typeSchem.getMode());

    Field typeName = fields.get("TYPE_NAME");
    assertNotNull(typeName);
    assertEquals("TYPE_NAME", typeName.getName());
    assertEquals(StandardSQLTypeName.STRING, typeName.getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, typeName.getMode());

    Field superTypeCat = fields.get("SUPERTYPE_CAT");
    assertNotNull(superTypeCat);
    assertEquals("SUPERTYPE_CAT", superTypeCat.getName());
    assertEquals(StandardSQLTypeName.STRING, superTypeCat.getType().getStandardType());
    assertEquals(Field.Mode.NULLABLE, superTypeCat.getMode());

    Field superTypeSchem = fields.get("SUPERTYPE_SCHEM");
    assertNotNull(superTypeSchem);
    assertEquals("SUPERTYPE_SCHEM", superTypeSchem.getName());
    assertEquals(StandardSQLTypeName.STRING, superTypeSchem.getType().getStandardType());
    assertEquals(Field.Mode.NULLABLE, superTypeSchem.getMode());

    Field superTypeName = fields.get("SUPERTYPE_NAME");
    assertNotNull(superTypeName);
    assertEquals("SUPERTYPE_NAME", superTypeName.getName());
    assertEquals(StandardSQLTypeName.STRING, superTypeName.getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, superTypeName.getMode());
  }

  @Test
  public void testGetSuperTypes_ReturnsEmptyResultSetWithCorrectMetadata() throws SQLException {
    try (ResultSet rs =
        dbMetadata.getSuperTypes("testCatalog", "testSchemaPattern", "testTypeNamePattern")) {
      assertNotNull("ResultSet should not be null", rs);
      assertFalse("ResultSet should be empty (next() should return false)", rs.next());

      ResultSetMetaData metaData = rs.getMetaData();
      assertNotNull("ResultSetMetaData should not be null", metaData);
      assertEquals("ResultSetMetaData should have 6 columns", 6, metaData.getColumnCount());

      // Column 1: TYPE_CAT
      assertEquals("TYPE_CAT", metaData.getColumnName(1));
      assertEquals(Types.NVARCHAR, metaData.getColumnType(1));
      assertEquals(ResultSetMetaData.columnNullable, metaData.isNullable(1));

      // Column 2: TYPE_SCHEM
      assertEquals("TYPE_SCHEM", metaData.getColumnName(2));
      assertEquals(Types.NVARCHAR, metaData.getColumnType(2));
      assertEquals(ResultSetMetaData.columnNullable, metaData.isNullable(2));

      // Column 3: TYPE_NAME
      assertEquals("TYPE_NAME", metaData.getColumnName(3));
      assertEquals(Types.NVARCHAR, metaData.getColumnType(3));
      assertEquals(ResultSetMetaData.columnNoNulls, metaData.isNullable(3));

      // Column 4: SUPERTYPE_CAT
      assertEquals("SUPERTYPE_CAT", metaData.getColumnName(4));
      assertEquals(Types.NVARCHAR, metaData.getColumnType(4));
      assertEquals(ResultSetMetaData.columnNullable, metaData.isNullable(4));

      // Column 5: SUPERTYPE_SCHEM
      assertEquals("SUPERTYPE_SCHEM", metaData.getColumnName(5));
      assertEquals(Types.NVARCHAR, metaData.getColumnType(5));
      assertEquals(ResultSetMetaData.columnNullable, metaData.isNullable(5));

      // Column 6: SUPERTYPE_NAME
      assertEquals("SUPERTYPE_NAME", metaData.getColumnName(6));
      assertEquals(Types.NVARCHAR, metaData.getColumnType(6));
      assertEquals(ResultSetMetaData.columnNoNulls, metaData.isNullable(6));
    }
  }

  @Test
  public void testDefineGetAttributesSchema() {
    Schema schema = dbMetadata.defineGetAttributesSchema();
    assertNotNull("Schema should not be null", schema);
    FieldList fields = schema.getFields();
    assertEquals("Schema should have 21 fields", 21, fields.size());

    assertEquals("TYPE_CAT", fields.get(0).getName());
    assertEquals(StandardSQLTypeName.STRING, fields.get(0).getType().getStandardType());
    assertEquals(Field.Mode.NULLABLE, fields.get(0).getMode());

    assertEquals("ATTR_NAME", fields.get(3).getName());
    assertEquals(StandardSQLTypeName.STRING, fields.get(3).getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, fields.get(3).getMode());

    assertEquals("DATA_TYPE", fields.get(4).getName());
    assertEquals(StandardSQLTypeName.INT64, fields.get(4).getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, fields.get(4).getMode());

    assertEquals("ORDINAL_POSITION", fields.get(15).getName());
    assertEquals(StandardSQLTypeName.INT64, fields.get(15).getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, fields.get(15).getMode());

    assertEquals("IS_NULLABLE", fields.get(16).getName());
    assertEquals(StandardSQLTypeName.STRING, fields.get(16).getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, fields.get(16).getMode());

    assertEquals("SOURCE_DATA_TYPE", fields.get(20).getName());
    assertEquals(StandardSQLTypeName.INT64, fields.get(20).getType().getStandardType());
    assertEquals(Field.Mode.NULLABLE, fields.get(20).getMode());
  }

  @Test
  public void testGetAttributes_ReturnsEmptyResultSet() throws SQLException {
    try (ResultSet rs =
        dbMetadata.getAttributes("testCat", "testSchema", "testType", "testAttr%")) {
      assertNotNull("ResultSet should not be null", rs);
      assertFalse("ResultSet should be empty", rs.next());

      ResultSetMetaData metaData = rs.getMetaData();
      assertEquals("ResultSetMetaData should have 21 columns", 21, metaData.getColumnCount());

      assertEquals("TYPE_CAT", metaData.getColumnName(1));
      assertEquals(Types.NVARCHAR, metaData.getColumnType(1));
      assertEquals(ResultSetMetaData.columnNullable, metaData.isNullable(1));

      assertEquals("ATTR_NAME", metaData.getColumnName(4));
      assertEquals(Types.NVARCHAR, metaData.getColumnType(4));
      assertEquals(ResultSetMetaData.columnNoNulls, metaData.isNullable(4));

      assertEquals("DATA_TYPE", metaData.getColumnName(5));
      assertEquals(Types.BIGINT, metaData.getColumnType(5));
      assertEquals(ResultSetMetaData.columnNoNulls, metaData.isNullable(5));

      assertEquals("ORDINAL_POSITION", metaData.getColumnName(16));
      assertEquals(Types.BIGINT, metaData.getColumnType(16));
      assertEquals(ResultSetMetaData.columnNoNulls, metaData.isNullable(16));

      assertEquals("IS_NULLABLE", metaData.getColumnName(17));
      assertEquals(Types.NVARCHAR, metaData.getColumnType(17));
      assertEquals(ResultSetMetaData.columnNoNulls, metaData.isNullable(17));

      assertEquals("SOURCE_DATA_TYPE", metaData.getColumnName(21));
      assertEquals(Types.BIGINT, metaData.getColumnType(21));
      assertEquals(ResultSetMetaData.columnNullable, metaData.isNullable(21));
    }
  }

  @Test
  public void testDefineGetBestRowIdentifierSchema() {
    Schema schema = dbMetadata.defineGetBestRowIdentifierSchema();
    assertNotNull("Schema should not be null", schema);
    FieldList fields = schema.getFields();
    assertEquals("Schema should have 8 fields", 8, fields.size());

    assertEquals("SCOPE", fields.get(0).getName());
    assertEquals(StandardSQLTypeName.INT64, fields.get(0).getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, fields.get(0).getMode());

    assertEquals("COLUMN_NAME", fields.get(1).getName());
    assertEquals(StandardSQLTypeName.STRING, fields.get(1).getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, fields.get(1).getMode());

    assertEquals("DATA_TYPE", fields.get(2).getName());
    assertEquals(StandardSQLTypeName.INT64, fields.get(2).getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, fields.get(2).getMode());

    assertEquals("BUFFER_LENGTH", fields.get(5).getName());
    assertEquals(StandardSQLTypeName.INT64, fields.get(5).getType().getStandardType());
    assertEquals(Field.Mode.NULLABLE, fields.get(5).getMode());

    assertEquals("DECIMAL_DIGITS", fields.get(6).getName());
    assertEquals(StandardSQLTypeName.INT64, fields.get(6).getType().getStandardType());
    assertEquals(Field.Mode.NULLABLE, fields.get(6).getMode());

    assertEquals("PSEUDO_COLUMN", fields.get(7).getName());
    assertEquals(StandardSQLTypeName.INT64, fields.get(7).getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, fields.get(7).getMode());
  }

  @Test
  public void testGetBestRowIdentifier_ReturnsEmptyResultSetWithCorrectMetadata()
      throws SQLException {
    int testScope = DatabaseMetaData.bestRowSession;
    boolean testNullable = true;

    try (ResultSet rs =
        dbMetadata.getBestRowIdentifier(
            "testCat", "testSchema", "testTable", testScope, testNullable)) {
      assertNotNull("ResultSet should not be null", rs);
      assertFalse("ResultSet should be empty", rs.next());

      ResultSetMetaData metaData = rs.getMetaData();
      assertEquals("ResultSetMetaData should have 8 columns", 8, metaData.getColumnCount());

      assertEquals("SCOPE", metaData.getColumnName(1));
      assertEquals(Types.BIGINT, metaData.getColumnType(1));
      assertEquals(ResultSetMetaData.columnNoNulls, metaData.isNullable(1));

      assertEquals("COLUMN_NAME", metaData.getColumnName(2));
      assertEquals(Types.NVARCHAR, metaData.getColumnType(2));
      assertEquals(ResultSetMetaData.columnNoNulls, metaData.isNullable(2));

      assertEquals("DATA_TYPE", metaData.getColumnName(3));
      assertEquals(Types.BIGINT, metaData.getColumnType(3));
      assertEquals(ResultSetMetaData.columnNoNulls, metaData.isNullable(3));

      assertEquals("BUFFER_LENGTH", metaData.getColumnName(6));
      assertEquals(Types.BIGINT, metaData.getColumnType(6));
      assertEquals(ResultSetMetaData.columnNullable, metaData.isNullable(6));

      assertEquals("PSEUDO_COLUMN", metaData.getColumnName(8));
      assertEquals(Types.BIGINT, metaData.getColumnType(8));
      assertEquals(ResultSetMetaData.columnNoNulls, metaData.isNullable(8));
    }
  }

  @Test
  public void testDefineGetUDTsSchema() {
    Schema schema = dbMetadata.defineGetUDTsSchema();
    assertNotNull("Schema should not be null", schema);
    FieldList fields = schema.getFields();
    assertEquals("Schema should have 7 fields", 7, fields.size());

    assertEquals("TYPE_NAME", fields.get("TYPE_NAME").getName());
    assertEquals(StandardSQLTypeName.STRING, fields.get("TYPE_NAME").getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, fields.get("TYPE_NAME").getMode());

    assertEquals("CLASS_NAME", fields.get("CLASS_NAME").getName());
    assertEquals(StandardSQLTypeName.STRING, fields.get("CLASS_NAME").getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, fields.get("CLASS_NAME").getMode());

    assertEquals("DATA_TYPE", fields.get("DATA_TYPE").getName());
    assertEquals(StandardSQLTypeName.INT64, fields.get("DATA_TYPE").getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, fields.get("DATA_TYPE").getMode());

    assertEquals("BASE_TYPE", fields.get("BASE_TYPE").getName());
    assertEquals(StandardSQLTypeName.INT64, fields.get("BASE_TYPE").getType().getStandardType());
    assertEquals(Field.Mode.NULLABLE, fields.get("BASE_TYPE").getMode());
  }

  @Test
  public void testGetUDTs_ReturnsEmptyResultSet() throws SQLException {
    int[] types = {Types.STRUCT, Types.DISTINCT};
    try (ResultSet rs = dbMetadata.getUDTs("testCat", "testSchema%", "testType%", types)) {
      assertNotNull("ResultSet should not be null", rs);
      assertFalse("ResultSet should be empty", rs.next());

      ResultSetMetaData metaData = rs.getMetaData();
      assertEquals("ResultSetMetaData should have 7 columns", 7, metaData.getColumnCount());

      assertEquals("TYPE_NAME", metaData.getColumnName(3));
      assertEquals(Types.NVARCHAR, metaData.getColumnType(3));
      assertEquals(ResultSetMetaData.columnNoNulls, metaData.isNullable(3));

      assertEquals("DATA_TYPE", metaData.getColumnName(5));
      assertEquals(Types.BIGINT, metaData.getColumnType(5));
      assertEquals(ResultSetMetaData.columnNoNulls, metaData.isNullable(5));

      assertEquals("BASE_TYPE", metaData.getColumnName(7));
      assertEquals(Types.BIGINT, metaData.getColumnType(7));
      assertEquals(ResultSetMetaData.columnNullable, metaData.isNullable(7));
    }
  }

  @Test
  public void testDefineGetIndexInfoSchema() {
    Schema schema = dbMetadata.defineGetIndexInfoSchema();
    assertNotNull("Schema should not be null", schema);
    FieldList fields = schema.getFields();
    assertEquals("Schema should have 13 fields", 13, fields.size());

    assertEquals("TABLE_NAME", fields.get(2).getName());
    assertEquals(StandardSQLTypeName.STRING, fields.get(2).getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, fields.get(2).getMode());

    assertEquals("NON_UNIQUE", fields.get(3).getName());
    assertEquals(StandardSQLTypeName.BOOL, fields.get(3).getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, fields.get(3).getMode());

    assertEquals("TYPE", fields.get(6).getName());
    assertEquals(StandardSQLTypeName.INT64, fields.get(6).getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, fields.get(6).getMode());

    assertEquals("CARDINALITY", fields.get(10).getName());
    assertEquals(StandardSQLTypeName.INT64, fields.get(10).getType().getStandardType());
    assertEquals(Field.Mode.NULLABLE, fields.get(10).getMode());
  }

  @Test
  public void testGetIndexInfo_ReturnsEmptyResultSetWithCorrectMetadata() throws SQLException {
    try (ResultSet rs = dbMetadata.getIndexInfo("testCat", "testSchema", "testTable", true, true)) {
      assertNotNull("ResultSet should not be null", rs);
      assertFalse("ResultSet should be empty", rs.next());

      ResultSetMetaData metaData = rs.getMetaData();
      assertEquals("ResultSetMetaData should have 13 columns", 13, metaData.getColumnCount());

      assertEquals("TABLE_NAME", metaData.getColumnName(3));
      assertEquals(Types.NVARCHAR, metaData.getColumnType(3));
      assertEquals(ResultSetMetaData.columnNoNulls, metaData.isNullable(3));

      assertEquals("NON_UNIQUE", metaData.getColumnName(4));
      assertEquals(Types.BOOLEAN, metaData.getColumnType(4));
      assertEquals(ResultSetMetaData.columnNoNulls, metaData.isNullable(4));

      assertEquals("TYPE", metaData.getColumnName(7));
      assertEquals(Types.BIGINT, metaData.getColumnType(7));
      assertEquals(ResultSetMetaData.columnNoNulls, metaData.isNullable(7));

      assertEquals("CARDINALITY", metaData.getColumnName(11));
      assertEquals(Types.BIGINT, metaData.getColumnType(11));
      assertEquals(ResultSetMetaData.columnNullable, metaData.isNullable(11));
    }
  }

  @Test
  public void testDefineGetTablePrivilegesSchema() {
    Schema schema = dbMetadata.defineGetTablePrivilegesSchema();
    assertNotNull("Schema should not be null", schema);
    FieldList fields = schema.getFields();
    assertEquals("Schema should have 7 fields", 7, fields.size());

    assertEquals("TABLE_CAT", fields.get(0).getName());
    assertEquals(StandardSQLTypeName.STRING, fields.get(0).getType().getStandardType());
    assertEquals(Field.Mode.NULLABLE, fields.get(0).getMode());

    assertEquals("TABLE_NAME", fields.get(2).getName());
    assertEquals(StandardSQLTypeName.STRING, fields.get(2).getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, fields.get(2).getMode());

    assertEquals("GRANTEE", fields.get(4).getName());
    assertEquals(StandardSQLTypeName.STRING, fields.get(4).getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, fields.get(4).getMode());

    assertEquals("PRIVILEGE", fields.get(5).getName());
    assertEquals(StandardSQLTypeName.STRING, fields.get(5).getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, fields.get(5).getMode());

    assertEquals("IS_GRANTABLE", fields.get(6).getName());
    assertEquals(StandardSQLTypeName.STRING, fields.get(6).getType().getStandardType());
    assertEquals(Field.Mode.NULLABLE, fields.get(6).getMode());
  }

  @Test
  public void testGetTablePrivileges_ReturnsEmptyResultSetWithCorrectMetadata()
      throws SQLException {
    try (ResultSet rs = dbMetadata.getTablePrivileges("testCat", "testSchema%", "testTable%")) {
      assertNotNull("ResultSet should not be null", rs);
      assertFalse("ResultSet should be empty", rs.next());

      ResultSetMetaData metaData = rs.getMetaData();
      assertEquals("ResultSetMetaData should have 7 columns", 7, metaData.getColumnCount());

      assertEquals("TABLE_CAT", metaData.getColumnName(1));
      assertEquals(Types.NVARCHAR, metaData.getColumnType(1));
      assertEquals(ResultSetMetaData.columnNullable, metaData.isNullable(1));

      assertEquals("TABLE_NAME", metaData.getColumnName(3));
      assertEquals(Types.NVARCHAR, metaData.getColumnType(3));
      assertEquals(ResultSetMetaData.columnNoNulls, metaData.isNullable(3));

      assertEquals("GRANTEE", metaData.getColumnName(5));
      assertEquals(Types.NVARCHAR, metaData.getColumnType(5));
      assertEquals(ResultSetMetaData.columnNoNulls, metaData.isNullable(5));

      assertEquals("PRIVILEGE", metaData.getColumnName(6));
      assertEquals(Types.NVARCHAR, metaData.getColumnType(6));
      assertEquals(ResultSetMetaData.columnNoNulls, metaData.isNullable(6));

      assertEquals("IS_GRANTABLE", metaData.getColumnName(7));
      assertEquals(Types.NVARCHAR, metaData.getColumnType(7));
      assertEquals(ResultSetMetaData.columnNullable, metaData.isNullable(7));
    }
  }

  @Test
  public void testDefineGetColumnPrivilegesSchema() {
    Schema schema = dbMetadata.defineGetColumnPrivilegesSchema();
    assertNotNull("Schema should not be null", schema);
    FieldList fields = schema.getFields();
    assertEquals("Schema should have 8 fields", 8, fields.size());

    assertEquals("TABLE_SCHEM", fields.get(1).getName());
    assertEquals(StandardSQLTypeName.STRING, fields.get(1).getType().getStandardType());
    assertEquals(Field.Mode.NULLABLE, fields.get(1).getMode());

    assertEquals("COLUMN_NAME", fields.get(3).getName());
    assertEquals(StandardSQLTypeName.STRING, fields.get(3).getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, fields.get(3).getMode());

    assertEquals("GRANTOR", fields.get(4).getName());
    assertEquals(StandardSQLTypeName.STRING, fields.get(4).getType().getStandardType());
    assertEquals(Field.Mode.NULLABLE, fields.get(4).getMode());

    assertEquals("PRIVILEGE", fields.get(6).getName());
    assertEquals(StandardSQLTypeName.STRING, fields.get(6).getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, fields.get(6).getMode());

    assertEquals("IS_GRANTABLE", fields.get(7).getName());
    assertEquals(StandardSQLTypeName.STRING, fields.get(7).getType().getStandardType());
    assertEquals(Field.Mode.NULLABLE, fields.get(7).getMode());
  }

  @Test
  public void testGetColumnPrivileges_ReturnsEmptyResultSetWithCorrectMetadata()
      throws SQLException {
    try (ResultSet rs =
        dbMetadata.getColumnPrivileges("testCat", "testSchema", "testTable", "testCol%")) {
      assertNotNull("ResultSet should not be null", rs);
      assertFalse("ResultSet should be empty", rs.next());

      ResultSetMetaData metaData = rs.getMetaData();
      assertEquals("ResultSetMetaData should have 8 columns", 8, metaData.getColumnCount());

      assertEquals("TABLE_SCHEM", metaData.getColumnName(2));
      assertEquals(Types.NVARCHAR, metaData.getColumnType(2));
      assertEquals(ResultSetMetaData.columnNullable, metaData.isNullable(2));

      assertEquals("COLUMN_NAME", metaData.getColumnName(4));
      assertEquals(Types.NVARCHAR, metaData.getColumnType(4));
      assertEquals(ResultSetMetaData.columnNoNulls, metaData.isNullable(4));

      assertEquals("GRANTOR", metaData.getColumnName(5));
      assertEquals(Types.NVARCHAR, metaData.getColumnType(5));
      assertEquals(ResultSetMetaData.columnNullable, metaData.isNullable(5));

      assertEquals("PRIVILEGE", metaData.getColumnName(7));
      assertEquals(Types.NVARCHAR, metaData.getColumnType(7));
      assertEquals(ResultSetMetaData.columnNoNulls, metaData.isNullable(7));

      assertEquals("IS_GRANTABLE", metaData.getColumnName(8));
      assertEquals(Types.NVARCHAR, metaData.getColumnType(8));
      assertEquals(ResultSetMetaData.columnNullable, metaData.isNullable(8));
    }
  }

  @Test
  public void testDefineGetVersionColumnsSchema() {
    Schema schema = dbMetadata.defineGetVersionColumnsSchema();
    assertNotNull("Schema should not be null", schema);
    FieldList fields = schema.getFields();
    assertEquals("Schema should have 8 fields", 8, fields.size());

    assertEquals("SCOPE", fields.get(0).getName());
    assertEquals(StandardSQLTypeName.INT64, fields.get(0).getType().getStandardType());
    assertEquals(Field.Mode.NULLABLE, fields.get(0).getMode());

    assertEquals("COLUMN_NAME", fields.get(1).getName());
    assertEquals(StandardSQLTypeName.STRING, fields.get(1).getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, fields.get(1).getMode());

    assertEquals("DATA_TYPE", fields.get(2).getName());
    assertEquals(StandardSQLTypeName.INT64, fields.get(2).getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, fields.get(2).getMode());

    assertEquals("BUFFER_LENGTH", fields.get(5).getName());
    assertEquals(StandardSQLTypeName.INT64, fields.get(5).getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, fields.get(5).getMode());

    assertEquals("PSEUDO_COLUMN", fields.get(7).getName());
    assertEquals(StandardSQLTypeName.INT64, fields.get(7).getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, fields.get(7).getMode());
  }

  @Test
  public void testGetVersionColumns_ReturnsEmptyResultSetWithCorrectMetadata() throws SQLException {
    try (ResultSet rs = dbMetadata.getVersionColumns("testCat", "testSchema", "testTable")) {
      assertNotNull("ResultSet should not be null", rs);
      assertFalse("ResultSet should be empty", rs.next());

      ResultSetMetaData metaData = rs.getMetaData();
      assertEquals("ResultSetMetaData should have 8 columns", 8, metaData.getColumnCount());

      assertEquals("SCOPE", metaData.getColumnName(1));
      assertEquals(Types.BIGINT, metaData.getColumnType(1));
      assertEquals(ResultSetMetaData.columnNullable, metaData.isNullable(1));

      assertEquals("COLUMN_NAME", metaData.getColumnName(2));
      assertEquals(Types.NVARCHAR, metaData.getColumnType(2));
      assertEquals(ResultSetMetaData.columnNoNulls, metaData.isNullable(2));

      assertEquals("DATA_TYPE", metaData.getColumnName(3));
      assertEquals(Types.BIGINT, metaData.getColumnType(3));
      assertEquals(ResultSetMetaData.columnNoNulls, metaData.isNullable(3));

      assertEquals("BUFFER_LENGTH", metaData.getColumnName(6));
      assertEquals(Types.BIGINT, metaData.getColumnType(6));
      assertEquals(ResultSetMetaData.columnNoNulls, metaData.isNullable(6));

      assertEquals("PSEUDO_COLUMN", metaData.getColumnName(8));
      assertEquals(Types.BIGINT, metaData.getColumnType(8));
      assertEquals(ResultSetMetaData.columnNoNulls, metaData.isNullable(8));
    }
  }

  @Test
  public void testDefineGetPseudoColumnsSchema() {
    Schema schema = dbMetadata.defineGetPseudoColumnsSchema();
    assertNotNull("Schema should not be null", schema);
    FieldList fields = schema.getFields();
    assertEquals("Schema should have 12 fields", 12, fields.size());

    assertEquals("TABLE_NAME", fields.get(2).getName());
    assertEquals(StandardSQLTypeName.STRING, fields.get(2).getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, fields.get(2).getMode());

    assertEquals("COLUMN_NAME", fields.get(3).getName());
    assertEquals(StandardSQLTypeName.STRING, fields.get(3).getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, fields.get(3).getMode());

    assertEquals("DATA_TYPE", fields.get(4).getName());
    assertEquals(StandardSQLTypeName.INT64, fields.get(4).getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, fields.get(4).getMode());

    assertEquals("COLUMN_SIZE", fields.get(5).getName());
    assertEquals(StandardSQLTypeName.INT64, fields.get(5).getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, fields.get(5).getMode());

    assertEquals("COLUMN_USAGE", fields.get(8).getName());
    assertEquals(StandardSQLTypeName.STRING, fields.get(8).getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, fields.get(8).getMode());

    assertEquals("IS_NULLABLE", fields.get(11).getName());
    assertEquals(StandardSQLTypeName.STRING, fields.get(11).getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, fields.get(11).getMode());
  }

  @Test
  public void testGetPseudoColumns_ReturnsEmptyResultSet() throws SQLException {
    try (ResultSet rs = dbMetadata.getPseudoColumns("testCat", "testSchema%", "testTable%", "%")) {
      assertNotNull("ResultSet should not be null", rs);
      assertFalse("ResultSet should be empty", rs.next());

      ResultSetMetaData metaData = rs.getMetaData();
      assertEquals("ResultSetMetaData should have 12 columns", 12, metaData.getColumnCount());

      assertEquals("TABLE_NAME", metaData.getColumnName(3));
      assertEquals(Types.NVARCHAR, metaData.getColumnType(3));
      assertEquals(ResultSetMetaData.columnNoNulls, metaData.isNullable(3));

      assertEquals("COLUMN_NAME", metaData.getColumnName(4));
      assertEquals(Types.NVARCHAR, metaData.getColumnType(4));
      assertEquals(ResultSetMetaData.columnNoNulls, metaData.isNullable(4));

      assertEquals("DATA_TYPE", metaData.getColumnName(5));
      assertEquals(Types.BIGINT, metaData.getColumnType(5));
      assertEquals(ResultSetMetaData.columnNoNulls, metaData.isNullable(5));

      assertEquals("COLUMN_SIZE", metaData.getColumnName(6));
      assertEquals(Types.BIGINT, metaData.getColumnType(6));
      assertEquals(ResultSetMetaData.columnNoNulls, metaData.isNullable(6));

      assertEquals("COLUMN_USAGE", metaData.getColumnName(9));
      assertEquals(Types.NVARCHAR, metaData.getColumnType(9));
      assertEquals(ResultSetMetaData.columnNoNulls, metaData.isNullable(9));

      assertEquals("IS_NULLABLE", metaData.getColumnName(12));
      assertEquals(Types.NVARCHAR, metaData.getColumnType(12));
      assertEquals(ResultSetMetaData.columnNoNulls, metaData.isNullable(12));
    }
  }

  @Test
  public void testDefineGetFunctionsSchema() {
    Schema schema = dbMetadata.defineGetFunctionsSchema();
    assertNotNull(schema);
    FieldList fields = schema.getFields();
    assertEquals(6, fields.size());

    Field funcCat = fields.get("FUNCTION_CAT");
    assertEquals("FUNCTION_CAT", funcCat.getName());
    assertEquals(StandardSQLTypeName.STRING, funcCat.getType().getStandardType());
    assertEquals(Field.Mode.NULLABLE, funcCat.getMode());

    Field funcSchem = fields.get("FUNCTION_SCHEM");
    assertEquals("FUNCTION_SCHEM", funcSchem.getName());
    assertEquals(StandardSQLTypeName.STRING, funcSchem.getType().getStandardType());
    assertEquals(Field.Mode.NULLABLE, funcSchem.getMode());

    Field funcName = fields.get("FUNCTION_NAME");
    assertEquals("FUNCTION_NAME", funcName.getName());
    assertEquals(StandardSQLTypeName.STRING, funcName.getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, funcName.getMode());

    Field remarks = fields.get("REMARKS");
    assertEquals("REMARKS", remarks.getName());
    assertEquals(StandardSQLTypeName.STRING, remarks.getType().getStandardType());
    assertEquals(Field.Mode.NULLABLE, remarks.getMode());

    Field funcType = fields.get("FUNCTION_TYPE");
    assertEquals("FUNCTION_TYPE", funcType.getName());
    assertEquals(StandardSQLTypeName.INT64, funcType.getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, funcType.getMode());

    Field specificName = fields.get("SPECIFIC_NAME");
    assertEquals("SPECIFIC_NAME", specificName.getName());
    assertEquals(StandardSQLTypeName.STRING, specificName.getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, specificName.getMode());
  }

  @Test
  public void testProcessFunctionInfo_ScalarFunction() {
    Schema resultSchema = dbMetadata.defineGetFunctionsSchema();
    FieldList resultSchemaFields = resultSchema.getFields();
    List<FieldValueList> collectedResults = Collections.synchronizedList(new ArrayList<>());

    String catalog = "proj-func";
    String schema = "dataset_func";
    String name = "my_scalar_func";
    String description = "A test scalar function";

    Routine routine = mockBigQueryRoutine(catalog, schema, name, "SCALAR_FUNCTION", description);

    dbMetadata.processFunctionInfo(routine, collectedResults, resultSchemaFields);

    assertEquals(1, collectedResults.size());
    FieldValueList row = collectedResults.get(0);
    assertNotNull(row);
    assertEquals(6, row.size());
    assertEquals(catalog, row.get("FUNCTION_CAT").getStringValue());
    assertEquals(schema, row.get("FUNCTION_SCHEM").getStringValue());
    assertEquals(name, row.get("FUNCTION_NAME").getStringValue());
    assertEquals(description, row.get("REMARKS").getStringValue());
    assertEquals(
        String.valueOf(DatabaseMetaData.functionResultUnknown),
        row.get("FUNCTION_TYPE").getStringValue());
    assertEquals(name, row.get("SPECIFIC_NAME").getStringValue());
  }

  @Test
  public void testProcessFunctionInfo_TableFunction() {
    Schema resultSchema = dbMetadata.defineGetFunctionsSchema();
    FieldList resultSchemaFields = resultSchema.getFields();
    List<FieldValueList> collectedResults = Collections.synchronizedList(new ArrayList<>());

    String catalog = "proj-func";
    String schema = "dataset_func";
    String name = "my_table_func";
    String description = "A test Table function";

    Routine routine = mockBigQueryRoutine(catalog, schema, name, "TABLE_FUNCTION", description);

    dbMetadata.processFunctionInfo(routine, collectedResults, resultSchemaFields);

    assertEquals(1, collectedResults.size());
    FieldValueList row = collectedResults.get(0);
    assertNotNull(row);
    assertEquals(6, row.size());
    assertEquals(catalog, row.get("FUNCTION_CAT").getStringValue());
    assertEquals(schema, row.get("FUNCTION_SCHEM").getStringValue());
    assertEquals(name, row.get("FUNCTION_NAME").getStringValue());
    assertEquals(description, row.get("REMARKS").getStringValue());
    assertEquals(
        String.valueOf(DatabaseMetaData.functionReturnsTable),
        row.get("FUNCTION_TYPE").getStringValue());
    assertEquals(name, row.get("SPECIFIC_NAME").getStringValue());
  }

  private FieldValueList createFunctionRow(
      String cat,
      String schem,
      String name,
      String specName,
      int funcType,
      FieldList schemaFields) {
    List<FieldValue> values = new ArrayList<>();
    values.add(dbMetadata.createStringFieldValue(cat)); // FUNCTION_CAT
    values.add(dbMetadata.createStringFieldValue(schem)); // FUNCTION_SCHEM
    values.add(dbMetadata.createStringFieldValue(name)); // FUNCTION_NAME
    values.add(dbMetadata.createStringFieldValue("Remark for " + name)); // REMARKS
    values.add(dbMetadata.createLongFieldValue((long) funcType)); // FUNCTION_TYPE
    values.add(dbMetadata.createStringFieldValue(specName)); // SPECIFIC_NAME
    return FieldValueList.of(values, schemaFields);
  }

  @Test
  public void testSortResults_Functions() {
    Schema resultSchema = dbMetadata.defineGetFunctionsSchema();
    FieldList schemaFields = resultSchema.getFields();
    List<FieldValueList> results = new ArrayList<>();

    // Add rows in unsorted order
    results.add(
        createFunctionRow(
            "cat_b",
            "sch_c",
            "func_1",
            "func_1_spec",
            DatabaseMetaData.functionResultUnknown,
            schemaFields));
    results.add(
        createFunctionRow(
            "cat_a",
            "sch_z",
            "func_alpha",
            "func_alpha_spec",
            DatabaseMetaData.functionReturnsTable,
            schemaFields));
    results.add(
        createFunctionRow(
            "cat_a",
            "sch_z",
            "func_beta",
            "func_beta_spec",
            DatabaseMetaData.functionResultUnknown,
            schemaFields));
    results.add(
        createFunctionRow(
            null,
            "sch_y",
            "func_gamma",
            "func_gamma_spec",
            DatabaseMetaData.functionReturnsTable,
            schemaFields));
    results.add(
        createFunctionRow(
            "cat_a",
            null,
            "func_delta",
            "func_delta_spec",
            DatabaseMetaData.functionResultUnknown,
            schemaFields));
    results.add(
        createFunctionRow(
            "cat_a",
            "sch_z",
            "func_alpha",
            "func_alpha_spec_older",
            DatabaseMetaData.functionReturnsTable,
            schemaFields));

    Comparator<FieldValueList> comparator = dbMetadata.defineGetFunctionsComparator(schemaFields);
    dbMetadata.sortResults(results, comparator, "getFunctions", dbMetadata.LOG);

    // Expected Order: Null Cat, then Cat A (Null Schem, then sch_z), then Cat B. Within that, Name,
    // then Spec Name.
    assertEquals(6, results.size());

    // Check order based on the comparator (CAT, SCHEM, NAME, SPECIFIC_NAME)
    assertEquals("func_gamma", results.get(0).get("FUNCTION_NAME").getStringValue()); // null cat
    assertEquals(
        "func_delta", results.get(1).get("FUNCTION_NAME").getStringValue()); // cat_a, null schem
    assertEquals(
        "func_alpha",
        results.get(2).get("FUNCTION_NAME").getStringValue()); // cat_a, sch_z, alpha, spec
    assertEquals(
        "func_alpha",
        results.get(3).get("FUNCTION_NAME").getStringValue()); // cat_a, sch_z, alpha, spec_older
    assertEquals(
        "func_beta", results.get(4).get("FUNCTION_NAME").getStringValue()); // cat_a, sch_z, beta
    assertEquals("func_1", results.get(5).get("FUNCTION_NAME").getStringValue()); // cat_b
  }

  @Test
  public void testDefineGetTypeInfoSchema() {
    Schema schema = dbMetadata.defineGetTypeInfoSchema();
    assertNotNull("Schema should not be null", schema);
    FieldList fields = schema.getFields();
    assertEquals("Schema should have 18 fields", 18, fields.size());

    Field typeName = fields.get("TYPE_NAME");
    assertNotNull(typeName);
    assertEquals("TYPE_NAME", typeName.getName());
    assertEquals(StandardSQLTypeName.STRING, typeName.getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, typeName.getMode());

    Field dataType = fields.get("DATA_TYPE");
    assertNotNull(dataType);
    assertEquals("DATA_TYPE", dataType.getName());
    assertEquals(StandardSQLTypeName.INT64, dataType.getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, dataType.getMode());

    Field precision = fields.get("PRECISION");
    assertNotNull(precision);
    assertEquals("PRECISION", precision.getName());
    assertEquals(StandardSQLTypeName.INT64, precision.getType().getStandardType());
    assertEquals(Field.Mode.NULLABLE, precision.getMode());

    Field caseSensitive = fields.get("CASE_SENSITIVE");
    assertNotNull(caseSensitive);
    assertEquals("CASE_SENSITIVE", caseSensitive.getName());
    assertEquals(StandardSQLTypeName.BOOL, caseSensitive.getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, caseSensitive.getMode());

    Field numPrecRadix = fields.get("NUM_PREC_RADIX");
    assertNotNull(numPrecRadix);
    assertEquals("NUM_PREC_RADIX", numPrecRadix.getName());
    assertEquals(StandardSQLTypeName.INT64, numPrecRadix.getType().getStandardType());
    assertEquals(Field.Mode.NULLABLE, numPrecRadix.getMode());
  }

  @Test
  public void testPrepareGetTypeInfoRows() {
    Schema typeInfoSchema = dbMetadata.defineGetTypeInfoSchema();
    FieldList schemaFields = typeInfoSchema.getFields();
    List<FieldValueList> rows = dbMetadata.prepareGetTypeInfoRows(schemaFields);

    assertNotNull("Rows list should not be null", rows);
    assertEquals("Should have 17 rows for 17 types", 17, rows.size());

    // INT64 (should be BIGINT in JDBC)
    Optional<FieldValueList> int64RowOpt =
        rows.stream()
            .filter(row -> "INT64".equals(row.get("TYPE_NAME").getStringValue()))
            .findFirst();
    assertTrue("INT64 type info row should exist", int64RowOpt.isPresent());
    FieldValueList int64Row = int64RowOpt.get();
    assertEquals(String.valueOf(Types.BIGINT), int64Row.get("DATA_TYPE").getStringValue());
    assertEquals("19", int64Row.get("PRECISION").getStringValue());
    assertEquals(
        String.valueOf(DatabaseMetaData.typeNullable), int64Row.get("NULLABLE").getStringValue());
    assertEquals("0", int64Row.get("CASE_SENSITIVE").getStringValue());
    assertEquals("10", int64Row.get("NUM_PREC_RADIX").getStringValue());

    // BOOL (should be BOOLEAN in JDBC)
    Optional<FieldValueList> boolRowOpt =
        rows.stream()
            .filter(row -> "BOOL".equals(row.get("TYPE_NAME").getStringValue()))
            .findFirst();
    assertTrue("BOOL type info row should exist", boolRowOpt.isPresent());
    FieldValueList boolRow = boolRowOpt.get();
    assertEquals(String.valueOf(Types.BOOLEAN), boolRow.get("DATA_TYPE").getStringValue());
    assertEquals("1", boolRow.get("PRECISION").getStringValue());
    assertEquals(
        String.valueOf(DatabaseMetaData.typeNullable), boolRow.get("NULLABLE").getStringValue());
    assertEquals("0", boolRow.get("CASE_SENSITIVE").getStringValue()); // false
    assertTrue(boolRow.get("NUM_PREC_RADIX").isNull());

    // STRING (should be NVARCHAR in JDBC)
    Optional<FieldValueList> stringRowOpt =
        rows.stream()
            .filter(row -> "STRING".equals(row.get("TYPE_NAME").getStringValue()))
            .findFirst();
    assertTrue("STRING type info row should exist", stringRowOpt.isPresent());
    FieldValueList stringRow = stringRowOpt.get();
    assertEquals(String.valueOf(Types.NVARCHAR), stringRow.get("DATA_TYPE").getStringValue());
    assertTrue(stringRow.get("PRECISION").isNull()); // Precision is null for STRING
    assertEquals("'", stringRow.get("LITERAL_PREFIX").getStringValue());
    assertEquals("'", stringRow.get("LITERAL_SUFFIX").getStringValue());
    assertEquals("LENGTH", stringRow.get("CREATE_PARAMS").getStringValue());
    assertEquals(
        String.valueOf(DatabaseMetaData.typeNullable), stringRow.get("NULLABLE").getStringValue());
    assertEquals("1", stringRow.get("CASE_SENSITIVE").getStringValue()); // true
    assertTrue(stringRow.get("NUM_PREC_RADIX").isNull());
  }

  @Test
  public void testGetTypeInfo() throws SQLException {
    try (ResultSet rs = dbMetadata.getTypeInfo()) {
      assertNotNull("ResultSet from getTypeInfo() should not be null", rs);

      ResultSetMetaData rsmd = rs.getMetaData();
      assertNotNull("ResultSetMetaData should not be null", rsmd);
      assertEquals("Should have 18 columns", 18, rsmd.getColumnCount());
      assertEquals("TYPE_NAME", rsmd.getColumnName(1));
      assertEquals("DATA_TYPE", rsmd.getColumnName(2));
      assertEquals("PRECISION", rsmd.getColumnName(3));

      List<Integer> dataTypes = new ArrayList<>();
      int rowCount = 0;
      while (rs.next()) {
        rowCount++;
        dataTypes.add(rs.getInt("DATA_TYPE"));
        if ("INT64".equals(rs.getString("TYPE_NAME"))) {
          assertEquals(Types.BIGINT, rs.getInt("DATA_TYPE"));
          assertEquals(19, rs.getInt("PRECISION"));
        }
      }
      assertEquals("Should have 17 rows for 17 types", 17, rowCount);

      // Verify sorting by DATA_TYPE
      List<Integer> sortedDataTypes = new ArrayList<>(dataTypes);
      Collections.sort(sortedDataTypes);
      assertEquals("Results should be sorted by DATA_TYPE", sortedDataTypes, dataTypes);
    }
  }

  @Test
  public void testDefineGetFunctionColumnsSchema() {
    Schema schema = dbMetadata.defineGetFunctionColumnsSchema();
    assertNotNull(schema);
    FieldList fields = schema.getFields();
    assertEquals(17, fields.size());

    assertEquals("FUNCTION_CAT", fields.get(0).getName());
    assertEquals(StandardSQLTypeName.STRING, fields.get(0).getType().getStandardType());
    assertEquals(Field.Mode.NULLABLE, fields.get(0).getMode());

    assertEquals("COLUMN_NAME", fields.get(3).getName());
    assertEquals(StandardSQLTypeName.STRING, fields.get(3).getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, fields.get(3).getMode());

    assertEquals("COLUMN_TYPE", fields.get(4).getName());
    assertEquals(StandardSQLTypeName.INT64, fields.get(4).getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, fields.get(4).getMode());

    assertEquals("ORDINAL_POSITION", fields.get(14).getName());
    assertEquals(StandardSQLTypeName.INT64, fields.get(14).getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, fields.get(14).getMode());

    assertEquals("SPECIFIC_NAME", fields.get(16).getName());
    assertEquals(StandardSQLTypeName.STRING, fields.get(16).getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, fields.get(16).getMode());
  }

  @Test
  public void testCreateFunctionColumnRow() {
    StandardSQLDataType stringType = mockStandardSQLDataType(StandardSQLTypeName.STRING);
    List<FieldValue> row =
        dbMetadata.createFunctionColumnRow(
            "cat",
            "sch",
            "func",
            "func_spec",
            "param_in",
            DatabaseMetaData.functionColumnIn,
            stringType,
            1);

    assertEquals(17, row.size());
    assertEquals("cat", row.get(0).getStringValue());
    assertEquals("sch", row.get(1).getStringValue());
    assertEquals("func", row.get(2).getStringValue());
    assertEquals("param_in", row.get(3).getStringValue());
    assertEquals(String.valueOf(DatabaseMetaData.functionColumnIn), row.get(4).getStringValue());
    assertEquals(String.valueOf(Types.NVARCHAR), row.get(5).getStringValue()); // DATA_TYPE
    assertEquals("NVARCHAR", row.get(6).getStringValue()); // TYPE_NAME
    assertTrue(row.get(7).isNull()); // PRECISION
    assertTrue(row.get(8).isNull()); // LENGTH
    assertTrue(row.get(9).isNull()); // SCALE
    assertTrue(row.get(10).isNull()); // RADIX
    assertEquals(
        String.valueOf(DatabaseMetaData.functionNullableUnknown),
        row.get(11).getStringValue()); // NULLABLE
    assertTrue(row.get(12).isNull()); // REMARKS
    assertTrue(row.get(13).isNull()); // CHAR_OCTET_LENGTH (should be columnSize)
    assertEquals("1", row.get(14).getStringValue()); // ORDINAL_POSITION
    assertEquals("", row.get(15).getStringValue()); // IS_NULLABLE
    assertEquals("func_spec", row.get(16).getStringValue()); // SPECIFIC_NAME
  }

  @Test
  public void testProcessFunctionParametersAndReturnValue_ScalarFunctionWithArgs() {
    Schema resultSchema = dbMetadata.defineGetFunctionColumnsSchema();
    FieldList resultFields = resultSchema.getFields();
    List<FieldValueList> collectedResults = Collections.synchronizedList(new ArrayList<>());

    RoutineArgument arg1 = mockRoutineArgument("in_str", StandardSQLTypeName.STRING, "IN");
    RoutineArgument arg2 = mockRoutineArgument("in_int", StandardSQLTypeName.INT64, "IN");
    Routine scalarFunc =
        mockBigQueryRoutineWithArgs(
            "cat", "ds", "my_scalar", "SCALAR_FUNCTION", "desc", Arrays.asList(arg1, arg2));
    when(scalarFunc.getReturnTableType()).thenReturn(null); // No return table for scalar

    dbMetadata.processFunctionParametersAndReturnValue(
        scalarFunc, null, collectedResults, resultFields);

    assertEquals(2, collectedResults.size());
    // First argument
    assertEquals("in_str", collectedResults.get(0).get("COLUMN_NAME").getStringValue());
    assertEquals(
        String.valueOf(DatabaseMetaData.functionColumnIn),
        collectedResults.get(0).get("COLUMN_TYPE").getStringValue());
    assertEquals("1", collectedResults.get(0).get("ORDINAL_POSITION").getStringValue());
    // Second argument
    assertEquals("in_int", collectedResults.get(1).get("COLUMN_NAME").getStringValue());
    assertEquals(
        String.valueOf(DatabaseMetaData.functionColumnIn),
        collectedResults.get(1).get("COLUMN_TYPE").getStringValue());
    assertEquals("2", collectedResults.get(1).get("ORDINAL_POSITION").getStringValue());
  }

  @Test
  public void testProcessFunctionParametersAndReturnValue_TableFunctionWithReturnTable() {
    Schema resultSchema = dbMetadata.defineGetFunctionColumnsSchema();
    FieldList resultFields = resultSchema.getFields();
    List<FieldValueList> collectedResults = Collections.synchronizedList(new ArrayList<>());

    StandardSQLField returnCol1 = mockStandardSQLField("out_id", StandardSQLTypeName.INT64);
    StandardSQLField returnCol2 = mockStandardSQLField("out_val", StandardSQLTypeName.STRING);
    StandardSQLTableType returnTable =
        mockStandardSQLTableType(Arrays.asList(returnCol1, returnCol2));

    Routine tableFunc =
        mockBigQueryRoutineWithArgs(
            "cat", "ds", "my_table_func", "TABLE_FUNCTION", "desc", Collections.emptyList());
    when(tableFunc.getReturnTableType()).thenReturn(returnTable);

    dbMetadata.processFunctionParametersAndReturnValue(
        tableFunc, null, collectedResults, resultFields);

    assertEquals(2, collectedResults.size());
    // First return column
    assertEquals("out_id", collectedResults.get(0).get("COLUMN_NAME").getStringValue());
    assertEquals(
        String.valueOf(DatabaseMetaData.functionColumnResult),
        collectedResults.get(0).get("COLUMN_TYPE").getStringValue());
    assertEquals("1", collectedResults.get(0).get("ORDINAL_POSITION").getStringValue());
    // Second return column
    assertEquals("out_val", collectedResults.get(1).get("COLUMN_NAME").getStringValue());
    assertEquals(
        String.valueOf(DatabaseMetaData.functionColumnResult),
        collectedResults.get(1).get("COLUMN_TYPE").getStringValue());
    assertEquals("2", collectedResults.get(1).get("ORDINAL_POSITION").getStringValue());
  }

  @Test
  public void testProcessFunctionParametersAndReturnValue_ColumnNameFilter() {
    Schema resultSchema = dbMetadata.defineGetFunctionColumnsSchema();
    FieldList resultFields = resultSchema.getFields();
    List<FieldValueList> collectedResults = Collections.synchronizedList(new ArrayList<>());
    Pattern columnNamePattern = Pattern.compile("id_.*"); // Match columns starting with "id_"

    RoutineArgument arg1 = mockRoutineArgument("id_arg", StandardSQLTypeName.INT64, "IN");
    RoutineArgument arg2 = mockRoutineArgument("name_arg", StandardSQLTypeName.STRING, "IN");
    StandardSQLField returnCol1 = mockStandardSQLField("id_return", StandardSQLTypeName.BOOL);
    StandardSQLField returnCol2 = mockStandardSQLField("value_return", StandardSQLTypeName.FLOAT64);
    StandardSQLTableType returnTable =
        mockStandardSQLTableType(Arrays.asList(returnCol1, returnCol2));

    Routine tableFunc =
        mockBigQueryRoutineWithArgs(
            "cat", "ds", "filter_func", "TABLE_FUNCTION", "desc", Arrays.asList(arg1, arg2));
    when(tableFunc.getReturnTableType()).thenReturn(returnTable);

    dbMetadata.processFunctionParametersAndReturnValue(
        tableFunc, columnNamePattern, collectedResults, resultFields);

    assertEquals(2, collectedResults.size()); // Should match id_arg and id_return
    assertEquals("id_return", collectedResults.get(0).get("COLUMN_NAME").getStringValue());
    assertEquals("id_arg", collectedResults.get(1).get("COLUMN_NAME").getStringValue());
  }

  @Test
  public void testDefineGetClientInfoPropertiesSchema() {
    Schema schema = dbMetadata.defineGetClientInfoPropertiesSchema();
    assertNotNull("Schema should not be null", schema);
    FieldList fields = schema.getFields();
    assertEquals("Schema should have 4 fields", 4, fields.size());

    Field nameField = fields.get("NAME");
    assertNotNull(nameField);
    assertEquals("NAME", nameField.getName());
    assertEquals(StandardSQLTypeName.STRING, nameField.getType().getStandardType());
    assertEquals(Field.Mode.REQUIRED, nameField.getMode());

    Field maxLenField = fields.get("MAX_LEN");
    assertNotNull(maxLenField);
    assertEquals("MAX_LEN", maxLenField.getName());
    assertEquals(StandardSQLTypeName.INT64, maxLenField.getType().getStandardType());
    assertEquals(Field.Mode.NULLABLE, maxLenField.getMode());

    Field defaultValueField = fields.get("DEFAULT_VALUE");
    assertNotNull(defaultValueField);
    assertEquals("DEFAULT_VALUE", defaultValueField.getName());
    assertEquals(StandardSQLTypeName.STRING, defaultValueField.getType().getStandardType());
    assertEquals(Field.Mode.NULLABLE, defaultValueField.getMode());

    Field descriptionField = fields.get("DESCRIPTION");
    assertNotNull(descriptionField);
    assertEquals("DESCRIPTION", descriptionField.getName());
    assertEquals(StandardSQLTypeName.STRING, descriptionField.getType().getStandardType());
    assertEquals(Field.Mode.NULLABLE, descriptionField.getMode());
  }

  @Test
  public void testGetClientInfoProperties() throws SQLException {
    try (ResultSet rs = dbMetadata.getClientInfoProperties()) {
      assertNotNull("ResultSet from getClientInfoProperties() should not be null", rs);

      ResultSetMetaData rsmd = rs.getMetaData();
      assertNotNull("ResultSetMetaData should not be null", rsmd);
      assertEquals("Should have 4 columns", 4, rsmd.getColumnCount());
      assertEquals("NAME", rsmd.getColumnName(1));
      assertEquals(Types.NVARCHAR, rsmd.getColumnType(1));
      assertEquals("MAX_LEN", rsmd.getColumnName(2));
      assertEquals(Types.BIGINT, rsmd.getColumnType(2));
      assertEquals("DEFAULT_VALUE", rsmd.getColumnName(3));
      assertEquals(Types.NVARCHAR, rsmd.getColumnType(3));
      assertEquals("DESCRIPTION", rsmd.getColumnName(4));
      assertEquals(Types.NVARCHAR, rsmd.getColumnType(4));

      List<Map<String, Object>> actualRows = new ArrayList<>();
      while (rs.next()) {
        Map<String, Object> row = new HashMap<>();
        row.put("NAME", rs.getString("NAME"));
        row.put("MAX_LEN", rs.getLong("MAX_LEN"));
        row.put("DEFAULT_VALUE", rs.getObject("DEFAULT_VALUE"));
        row.put("DESCRIPTION", rs.getString("DESCRIPTION"));
        actualRows.add(row);
      }

      assertEquals("Should return 3 client info properties", 3, actualRows.size());

      Map<String, Object> appNameRow = actualRows.get(0);
      assertEquals("ApplicationName", appNameRow.get("NAME"));
      assertEquals(25L, appNameRow.get("MAX_LEN"));
      assertNull(appNameRow.get("DEFAULT_VALUE"));
      assertEquals(
          "The name of the application currently utilizing the connection.",
          appNameRow.get("DESCRIPTION"));

      Map<String, Object> clientHostnameRow = actualRows.get(1);
      assertEquals("ClientHostname", clientHostnameRow.get("NAME"));

      Map<String, Object> clientUserRow = actualRows.get(2);
      assertEquals("ClientUser", clientUserRow.get("NAME"));
    }
  }

  @Test
  public void testDefineGetCatalogsSchema() {
    Schema schema = dbMetadata.defineGetCatalogsSchema();
    assertNotNull("Schema should not be null", schema);
    FieldList fields = schema.getFields();
    assertEquals("Should have one column", 1, fields.size());

    Field tableCatField = fields.get("TABLE_CAT");
    assertNotNull("TABLE_CAT field should exist", tableCatField);
    assertEquals("Field name should be TABLE_CAT", "TABLE_CAT", tableCatField.getName());
    assertEquals(
        "Field type should be STRING",
        StandardSQLTypeName.STRING,
        tableCatField.getType().getStandardType());
    assertEquals("Field mode should be REQUIRED", Field.Mode.REQUIRED, tableCatField.getMode());
  }

  @Test
  public void testPrepareGetCatalogsRows() {
    Schema catalogsSchema = dbMetadata.defineGetCatalogsSchema();
    FieldList schemaFields = catalogsSchema.getFields();

    // Test with a valid catalog name
    List<String> testCatalogName = new ArrayList<>();
    testCatalogName.add("test_catalog");

    List<FieldValueList> rowsWithCatalog =
        dbMetadata.prepareGetCatalogsRows(schemaFields, testCatalogName);

    assertNotNull("Rows list should not be null when catalog name is provided", rowsWithCatalog);
    assertEquals("Should have one row when a catalog name is provided", 1, rowsWithCatalog.size());
    FieldValueList row = rowsWithCatalog.get(0);
    assertEquals("Row should have 1 field value", 1, row.size());
    assertFalse("FieldValue in row should not be SQL NULL", row.get(0).isNull());
    assertEquals(
        "TABLE_CAT should match the provided catalog name",
        testCatalogName.get(0),
        row.get(0).getStringValue());

    // Test with empty catalog name list
    List<String> testEmptyCatalogList = new ArrayList<>();
    List<FieldValueList> rowsWithNullCatalog =
        dbMetadata.prepareGetCatalogsRows(schemaFields, testEmptyCatalogList);
    assertNotNull("Rows list should not be null when catalog name is null", rowsWithNullCatalog);
    assertTrue("Should have zero rows when catalog name is null", rowsWithNullCatalog.isEmpty());
  }

  @Test
  public void testGetSchemas_NoArgs_DelegatesCorrectly() {
    BigQueryDatabaseMetaData spiedDbMetadata = spy(dbMetadata);
    ResultSet mockResultSet = mock(ResultSet.class);
    doReturn(mockResultSet).when(spiedDbMetadata).getSchemas(null, null);

    ResultSet rs = spiedDbMetadata.getSchemas();

    assertSame(
        "The returned ResultSet should be the one from the two-argument method", mockResultSet, rs);
    verify(spiedDbMetadata, times(1)).getSchemas(null, null);
  }

  // Non-Resultset DatabaseMetadata tests

  @Test
  public void testIdentifierQuoteString() {
    String actual = dbMetadata.getIdentifierQuoteString();
    assertEquals(BigQueryDatabaseMetaData.GOOGLE_SQL_QUOTED_IDENTIFIER, actual);
  }

  @Test
  public void testSQLKeyWords() {
    String actual = dbMetadata.getSQLKeywords();
    assertEquals(BigQueryDatabaseMetaData.GOOGLE_SQL_RESERVED_KEYWORDS, actual);
  }

  @Test
  public void testNumericFunctions() {
    String actual = dbMetadata.getNumericFunctions();
    assertEquals(BigQueryDatabaseMetaData.GOOGLE_SQL_NUMERIC_FNS, actual);
  }

  @Test
  public void testStringFunctions() {
    String actual = dbMetadata.getStringFunctions();
    assertEquals(BigQueryDatabaseMetaData.GOOGLE_SQL_STRING_FNS, actual);
  }

  @Test
  public void testTimeAndDateFunctions() {
    String actual = dbMetadata.getTimeDateFunctions();
    assertEquals(BigQueryDatabaseMetaData.GOOGLE_SQL_TIME_DATE_FNS, actual);
  }

  @Test
  public void testSystemFunctions() {
    String actual = dbMetadata.getSystemFunctions();
    assertNull(actual);
  }

  @Test
  public void testSearchStringEscape() {
    String actual = dbMetadata.getSearchStringEscape();
    assertEquals(BigQueryDatabaseMetaData.GOOGLE_SQL_ESCAPE, actual);
  }

  @Test
  public void testExtraNameChars() {
    String actual = dbMetadata.getExtraNameCharacters();
    assertNull(actual);
  }

  @Test
  public void testCatalogSeparator() {
    String actual = dbMetadata.getCatalogSeparator();
    assertEquals(BigQueryDatabaseMetaData.GOOGLE_SQL_CATALOG_SEPARATOR, actual);
  }

  @Test
  public void testMaxCharLiteralLength() {
    int actual = dbMetadata.getMaxCharLiteralLength();
    assertEquals(0, actual);
  }

  @Test
  public void testMaxBinaryLiteralLength() {
    int actual = dbMetadata.getMaxBinaryLiteralLength();
    assertEquals(0, actual);
  }

  @Test
  public void testMaxColumnNameLength() {
    int actual = dbMetadata.getMaxColumnNameLength();
    assertEquals(BigQueryDatabaseMetaData.GOOGLE_SQL_MAX_COL_NAME_LEN, actual);
  }

  @Test
  public void testMaxColumnsInTable() {
    int actual = dbMetadata.getMaxColumnsInTable();
    assertEquals(BigQueryDatabaseMetaData.GOOGLE_SQL_MAX_COLS_PER_TABLE, actual);
  }

  @Test
  public void testMaxColumnsInSelect() {
    int actual = dbMetadata.getMaxColumnsInSelect();
    assertEquals(0, actual);
  }

  @Test
  public void testMaxColumnsInGroupBy() {
    int actual = dbMetadata.getMaxColumnsInGroupBy();
    assertEquals(0, actual);
  }

  @Test
  public void testMaxColumnsInOrderBy() {
    int actual = dbMetadata.getMaxColumnsInOrderBy();
    assertEquals(0, actual);
  }

  @Test
  public void testMaxColumnsInIndex() {
    int actual = dbMetadata.getMaxColumnsInIndex();
    assertEquals(0, actual);
  }

  @Test
  public void testSupportsResultSetHoldabilitySupported() {
    assertTrue(dbMetadata.supportsResultSetHoldability(ResultSet.CLOSE_CURSORS_AT_COMMIT));
  }

  @Test
  public void testSupportsResultSetHoldabilityNotSupported() {
    assertFalse(dbMetadata.supportsResultSetHoldability(ResultSet.HOLD_CURSORS_OVER_COMMIT));
  }

  @Test
  public void testSupportsResultSetHoldabilityInvalid() {
    assertFalse(dbMetadata.supportsResultSetHoldability(-1));
  }

  @Test
  public void testResultSetHoldability() {
    int actual = dbMetadata.getResultSetHoldability();
    assertEquals(ResultSet.CLOSE_CURSORS_AT_COMMIT, actual);
  }

  @Test
  public void testDatabaseMajorVersion() {
    int actual = dbMetadata.getDatabaseMajorVersion();
    assertEquals(2, actual);
  }

  @Test
  public void testDatabaseMinorVersion() {
    int actual = dbMetadata.getDatabaseMinorVersion();
    assertEquals(0, actual);
  }

  @Test
  public void testAllProceduresAreCallable() throws SQLException {
    assertFalse(dbMetadata.allProceduresAreCallable());
  }

  @Test
  public void testAllTablesAreSelectable() throws SQLException {
    assertTrue(dbMetadata.allTablesAreSelectable());
  }

  @Test
  public void testGetDriverVersionInfoFromProperties() {
    Properties props = new Properties();
    String expectedVersionString = "0.0.0";
    int expectedMajor = 0;
    int expectedMinor = 0;

    try (InputStream input =
        getClass().getResourceAsStream("/com/google/cloud/bigquery/jdbc/dependencies.properties")) {
      if (input != null) {
        props.load(input);
        expectedVersionString = props.getProperty("version.jdbc");
        if (expectedVersionString != null) {
          String[] parts = expectedVersionString.split("\\.");
          expectedMajor = Integer.parseInt(parts[0]);
          expectedMinor = Integer.parseInt(parts[1].replaceAll("[^0-9].*", ""));
        }
      }
    } catch (IOException | NumberFormatException e) {
      fail(
          "Error reading or parsing dependencies.properties for testing driver version: "
              + e.getMessage());
    }
    assertEquals(expectedVersionString, dbMetadata.getDriverVersion());
    assertEquals(expectedMajor, dbMetadata.getDriverMajorVersion());
    assertEquals(expectedMinor, dbMetadata.getDriverMinorVersion());
  }

  @Test
  public void testSupportsUnion() throws SQLException {
    assertTrue(dbMetadata.supportsUnion());
  }

  @Test
  public void testSupportsUnionAll() throws SQLException {
    assertTrue(dbMetadata.supportsUnionAll());
  }

  @Test
  public void testGetMaxConnections() throws SQLException {
    assertEquals(0, dbMetadata.getMaxConnections());
  }

  @Test
  public void testGetMaxCursorNameLength() throws SQLException {
    assertEquals(0, dbMetadata.getMaxCursorNameLength());
  }

  @Test
  public void testGetMaxIndexLength() throws SQLException {
    assertEquals(0, dbMetadata.getMaxIndexLength());
  }

  @Test
  public void testGetMaxSchemaNameLength() throws SQLException {
    assertEquals(1024, dbMetadata.getMaxSchemaNameLength());
  }

  @Test
  public void testGetMaxProcedureNameLength() throws SQLException {
    assertEquals(256, dbMetadata.getMaxProcedureNameLength());
  }

  @Test
  public void testGetMaxCatalogNameLength() throws SQLException {
    assertEquals(30, dbMetadata.getMaxCatalogNameLength());
  }

  @Test
  public void testGetMaxRowSize() throws SQLException {
    assertEquals(0, dbMetadata.getMaxRowSize());
  }

  @Test
  public void testDoesMaxRowSizeIncludeBlobs() {
    assertFalse(dbMetadata.doesMaxRowSizeIncludeBlobs());
  }

  @Test
  public void testGetMaxStatementLength() throws SQLException {
    assertEquals(0, dbMetadata.getMaxStatementLength());
  }

  @Test
  public void testGetMaxStatements() throws SQLException {
    assertEquals(0, dbMetadata.getMaxStatements());
  }

  @Test
  public void testGetMaxTableNameLength() throws SQLException {
    assertEquals(1024, dbMetadata.getMaxTableNameLength());
  }

  @Test
  public void testGetMaxTablesInSelect() throws SQLException {
    assertEquals(1000, dbMetadata.getMaxTablesInSelect());
  }

  @Test
  public void testGetDefaultTransactionIsolation() throws SQLException {
    assertEquals(8, dbMetadata.getDefaultTransactionIsolation());
  }

  @Test
  public void testSupportsResultSetType() throws SQLException {
    assertTrue(dbMetadata.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY));
    assertFalse(dbMetadata.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE));
    assertFalse(dbMetadata.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE));
  }

  @Test
  public void testSupportsResultSetConcurrency() throws SQLException {
    assertTrue(
        dbMetadata.supportsResultSetConcurrency(
            ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY));
    assertFalse(
        dbMetadata.supportsResultSetConcurrency(
            ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE));
    assertFalse(
        dbMetadata.supportsResultSetConcurrency(
            ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY));
    assertFalse(
        dbMetadata.supportsResultSetConcurrency(
            ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE));
  }

  @Test
  public void testGetSQLStateType() throws SQLException {
    assertEquals(DatabaseMetaData.sqlStateSQL, dbMetadata.getSQLStateType());
  }
}
