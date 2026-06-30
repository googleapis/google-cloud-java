/*
 * Copyright 2019 Google LLC
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

package com.google.cloud.spanner.jdbc.it;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.cloud.spanner.testing.EmulatorSpannerHelper;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Integration tests for {@link DatabaseMetaData} implementation for Spanner. */
@Category(ParallelIntegrationTest.class)
@RunWith(JUnit4.class)
public class ITJdbcDatabaseMetaDataTest extends ITAbstractJdbcTest {
  private static final String DEFAULT_CATALOG = "";
  private static final String DEFAULT_SCHEMA = "";
  private static final String SINGERS_TABLE = "Singers";
  private static final String ALBUMS_TABLE = "Albums";
  private static final String SONGS_TABLE = "Songs";
  private static final String CONCERTS_TABLE = "Concerts";
  private static final String TABLE_WITH_ALL_COLS = "TableWithAllColumnTypes";
  private static final String TABLE_WITH_REF = "TableWithRef";

  @ClassRule public static JdbcIntegrationTestEnv env = new JdbcIntegrationTestEnv();

  private static Database database;

  @BeforeClass
  public static void setup() throws Exception {
    database =
        env.getOrCreateDatabase(
            Dialect.GOOGLE_STANDARD_SQL, getMusicTablesDdl(Dialect.GOOGLE_STANDARD_SQL));

    // Create the same tables in an additional 'test' schema.
    DatabaseAdminClient client = env.getTestHelper().getClient().getDatabaseAdminClient();
    List<String> tables =
        getMusicTablesDdl(Dialect.GOOGLE_STANDARD_SQL).stream()
            .map(statement -> statement.replace("CREATE TABLE ", "CREATE TABLE test."))
            .map(statement -> statement.replace("CREATE INDEX ", "CREATE INDEX test."))
            .map(
                statement -> statement.replace("CREATE UNIQUE INDEX ", "CREATE UNIQUE INDEX test."))
            .map(statement -> statement.replace("CREATE VIEW ", "CREATE VIEW test."))
            .map(statement -> statement.replace("FROM ", "FROM test."))
            .map(
                statement ->
                    statement.replace("INTERLEAVE IN PARENT ", "INTERLEAVE IN PARENT test."))
            .map(statement -> statement.replace("INTERLEAVE IN ", "INTERLEAVE IN test."))
            .map(
                statement -> statement.replace("INTERLEAVE IN test.PARENT", "INTERLEAVE IN PARENT"))
            .map(statement -> statement.replace(" ON ", " ON test."))
            .map(statement -> statement.replace(" ON test.DELETE", " ON DELETE"))
            .map(statement -> statement.replace(" REFERENCES ", " REFERENCES test."))
            .map(
                statement ->
                    EmulatorSpannerHelper.isUsingEmulator()
                        ? statement.replace("Fk_Concerts_Singer", "test_Fk_Concerts_Singer")
                        : statement)
            .map(
                statement ->
                    EmulatorSpannerHelper.isUsingEmulator()
                        ? statement.replace(
                            "Fk_TableWithRef_TableWithAllColumnTypes",
                            "test_Fk_TableWithRef_TableWithAllColumnTypes")
                        : statement)
            .collect(Collectors.toList());
    tables.add(0, "create schema test");
    client
        .updateDatabaseDdl(
            database.getId().getInstanceId().getInstance(),
            database.getId().getDatabase(),
            tables,
            null)
        .get();
  }

  private static final class Column {
    private final String name;
    private final int type;
    private final String typeName;
    private final Integer colSize;
    private final Integer decimalDigits;
    private final Integer radix;
    private final boolean nullable;
    private final Integer charOctetLength;
    private final boolean computed;
    private final String defaultValue;
    private final boolean autoIncrement;

    private Column(
        String name,
        int type,
        String typeName,
        Integer colSize,
        Integer decimalDigits,
        Integer radix,
        boolean nullable,
        Integer charOctetLength) {
      this(
          name,
          type,
          typeName,
          colSize,
          decimalDigits,
          radix,
          nullable,
          charOctetLength,
          false,
          null,
          false);
    }

    private Column(
        String name,
        int type,
        String typeName,
        Integer colSize,
        Integer decimalDigits,
        Integer radix,
        boolean nullable,
        Integer charOctetLength,
        boolean computed,
        String defaultValue,
        boolean autoIncrement) {
      this.name = name;
      this.type = type;
      this.typeName = typeName;
      this.colSize = colSize;
      this.decimalDigits = decimalDigits;
      this.radix = radix;
      this.nullable = nullable;
      this.charOctetLength = charOctetLength;
      this.computed = computed;
      this.defaultValue = defaultValue;
      this.autoIncrement = autoIncrement;
    }
  }

  private static final List<Column> EXPECTED_COLUMNS =
      Arrays.asList(
          new Column("ColInt64", Types.BIGINT, "INT64", 19, null, 10, false, null),
          new Column(
              "ColFloat64", Types.DOUBLE, "FLOAT64", 15, 16, 2, false, null, false, "0.0", false),
          new Column(
              "ColFloat32", Types.REAL, "FLOAT32", 15, 16, 2, false, null, false, "0.0", false),
          new Column("ColBool", Types.BOOLEAN, "BOOL", null, null, null, false, null),
          new Column(
              "ColString",
              Types.NVARCHAR,
              "STRING(100)",
              100,
              null,
              null,
              false,
              100,
              false,
              "'Hello World!'",
              false),
          new Column(
              "ColStringMax", Types.NVARCHAR, "STRING(MAX)", 2621440, null, null, false, 2621440),
          new Column("ColBytes", Types.BINARY, "BYTES(100)", 100, null, null, false, null),
          new Column("ColBytesMax", Types.BINARY, "BYTES(MAX)", 10485760, null, null, false, null),
          new Column(
              "ColDate",
              Types.DATE,
              "DATE",
              10,
              null,
              null,
              false,
              null,
              false,
              "DATE '2000-01-01'",
              false),
          new Column("ColTimestamp", Types.TIMESTAMP, "TIMESTAMP", 35, null, null, false, null),
          new Column("ColCommitTS", Types.TIMESTAMP, "TIMESTAMP", 35, null, null, false, null),
          new Column("ColNumeric", Types.NUMERIC, "NUMERIC", 15, null, 10, false, null),
          new Column("ColJson", Types.NVARCHAR, "JSON", 2621440, null, null, false, 2621440),
          new Column("ColInt64Array", Types.ARRAY, "ARRAY<INT64>", 19, null, 10, true, null),
          new Column("ColFloat64Array", Types.ARRAY, "ARRAY<FLOAT64>", 15, 16, 2, true, null),
          new Column("ColFloat32Array", Types.ARRAY, "ARRAY<FLOAT32>", 15, 16, 2, true, null),
          new Column("ColBoolArray", Types.ARRAY, "ARRAY<BOOL>", null, null, null, true, null),
          new Column(
              "ColStringArray", Types.ARRAY, "ARRAY<STRING(100)>", 100, null, null, true, 100),
          new Column(
              "ColStringMaxArray",
              Types.ARRAY,
              "ARRAY<STRING(MAX)>",
              2621440,
              null,
              null,
              true,
              2621440),
          new Column(
              "ColBytesArray", Types.ARRAY, "ARRAY<BYTES(100)>", 100, null, null, true, null),
          new Column(
              "ColBytesMaxArray",
              Types.ARRAY,
              "ARRAY<BYTES(MAX)>",
              10485760,
              null,
              null,
              true,
              null),
          new Column("ColDateArray", Types.ARRAY, "ARRAY<DATE>", 10, null, null, true, null),
          new Column(
              "ColTimestampArray", Types.ARRAY, "ARRAY<TIMESTAMP>", 35, null, null, true, null),
          new Column("ColNumericArray", Types.ARRAY, "ARRAY<NUMERIC>", 15, null, 10, true, null),
          new Column(
              "ColJsonArray", Types.ARRAY, "ARRAY<JSON>", 2621440, null, null, true, 2621440),
          new Column(
              "ColComputed",
              Types.NVARCHAR,
              "STRING(MAX)",
              2621440,
              null,
              null,
              true,
              2621440,
              true,
              null,
              false),
          new Column(
              "ColIdentity", Types.BIGINT, "INT64", 19, null, 10, true, null, false, null, true));

  @Test
  public void testGetColumns() throws SQLException {
    try (Connection connection = createConnection(env, database)) {
      for (String schema : new String[] {DEFAULT_SCHEMA, "test"}) {
        try (ResultSet rs =
            connection
                .getMetaData()
                .getColumns(DEFAULT_CATALOG, schema, TABLE_WITH_ALL_COLS, null)) {
          int ordinalPosition = 0;
          for (Column col : EXPECTED_COLUMNS) {
            assertTrue(rs.next());
            assertEquals(DEFAULT_CATALOG, rs.getString("TABLE_CAT"));
            assertEquals(schema, rs.getString("TABLE_SCHEM"));
            assertEquals(TABLE_WITH_ALL_COLS, rs.getString("TABLE_NAME"));
            assertEquals(col.name, rs.getString("COLUMN_NAME"));
            assertEquals(col.type, rs.getInt("DATA_TYPE"));
            assertEquals(col.typeName, rs.getString("TYPE_NAME"));
            if (col.colSize == null) {
              assertEquals(0, rs.getInt("COLUMN_SIZE"));
              assertTrue(rs.wasNull());
            } else {
              assertEquals(col.colSize.intValue(), rs.getInt("COLUMN_SIZE"));
            }
            rs.getObject("BUFFER_LENGTH"); // just assert that it exists
            if (col.decimalDigits == null) {
              assertEquals(0, rs.getInt("DECIMAL_DIGITS"));
              assertTrue(rs.wasNull());
            } else {
              assertEquals(col.decimalDigits.intValue(), rs.getInt("DECIMAL_DIGITS"));
            }
            if (col.radix == null) {
              assertEquals(0, rs.getInt("NUM_PREC_RADIX"));
              assertTrue(rs.wasNull());
            } else {
              assertEquals(col.radix.intValue(), rs.getInt("NUM_PREC_RADIX"));
            }
            assertEquals(
                col.nullable ? DatabaseMetaData.columnNullable : DatabaseMetaData.columnNoNulls,
                rs.getInt("NULLABLE"));
            assertNull(rs.getString("REMARKS"));
            assertEquals(col.defaultValue, rs.getString("COLUMN_DEF"));
            assertEquals(0, rs.getInt("SQL_DATA_TYPE"));
            assertEquals(0, rs.getInt("SQL_DATETIME_SUB"));
            if (col.charOctetLength == null) {
              assertEquals(0, rs.getInt("CHAR_OCTET_LENGTH"));
              assertTrue(rs.wasNull());
            } else {
              assertEquals(col.charOctetLength.intValue(), rs.getInt("CHAR_OCTET_LENGTH"));
            }
            assertEquals(++ordinalPosition, rs.getInt("ORDINAL_POSITION"));
            assertEquals(col.nullable ? "YES" : "NO", rs.getString("IS_NULLABLE"));
            assertNull(rs.getString("SCOPE_CATALOG"));
            assertNull(rs.getString("SCOPE_SCHEMA"));
            assertNull(rs.getString("SCOPE_TABLE"));
            assertEquals(0, rs.getShort("SOURCE_DATA_TYPE"));
            assertTrue(rs.wasNull());
            assertEquals(col.computed ? "YES" : "NO", rs.getString("IS_GENERATEDCOLUMN"));
            assertEquals(24, rs.getMetaData().getColumnCount());
          }
          assertFalse(rs.next());
        }
      }
    }
  }

  @Test
  public void testGetCrossReferences() throws SQLException {
    try (Connection connection = createConnection(env, database)) {
      for (String schema : new String[] {DEFAULT_SCHEMA, "test"}) {
        try (ResultSet rs =
            connection
                .getMetaData()
                .getCrossReference(
                    DEFAULT_CATALOG,
                    schema,
                    SINGERS_TABLE,
                    DEFAULT_CATALOG,
                    schema,
                    ALBUMS_TABLE)) {
          assertTrue(rs.next());
          assertEquals("", rs.getString("PKTABLE_CAT"));
          assertEquals(schema, rs.getString("PKTABLE_SCHEM"));
          assertEquals("Singers", rs.getString("PKTABLE_NAME"));
          assertEquals("SingerId", rs.getString("PKCOLUMN_NAME"));
          assertEquals("", rs.getString("FKTABLE_CAT"));
          assertEquals(schema, rs.getString("FKTABLE_SCHEM"));
          assertEquals("Albums", rs.getString("FKTABLE_NAME"));
          assertEquals("SingerId", rs.getString("FKCOLUMN_NAME"));
          assertEquals(1, rs.getShort("KEY_SEQ"));
          assertEquals(DatabaseMetaData.importedKeyNoAction, rs.getShort("UPDATE_RULE"));
          assertEquals(DatabaseMetaData.importedKeyCascade, rs.getShort("DELETE_RULE"));
          assertNull(rs.getString("FK_NAME"));
          assertEquals("PRIMARY_KEY", rs.getString("PK_NAME"));
          assertEquals(DatabaseMetaData.importedKeyNotDeferrable, rs.getShort("DEFERRABILITY"));
        }
        try (ResultSet rs =
            connection
                .getMetaData()
                .getCrossReference(
                    DEFAULT_CATALOG, schema, ALBUMS_TABLE, DEFAULT_CATALOG, schema, SONGS_TABLE)) {
          assertTrue(rs.next());
          assertEquals("", rs.getString("PKTABLE_CAT"));
          assertEquals(schema, rs.getString("PKTABLE_SCHEM"));
          assertEquals("Albums", rs.getString("PKTABLE_NAME"));
          assertEquals("SingerId", rs.getString("PKCOLUMN_NAME"));
          assertEquals("", rs.getString("FKTABLE_CAT"));
          assertEquals(schema, rs.getString("FKTABLE_SCHEM"));
          assertEquals("Songs", rs.getString("FKTABLE_NAME"));
          assertEquals("SingerId", rs.getString("FKCOLUMN_NAME"));
          assertEquals(1, rs.getShort("KEY_SEQ"));
          assertEquals(DatabaseMetaData.importedKeyNoAction, rs.getShort("UPDATE_RULE"));
          assertEquals(DatabaseMetaData.importedKeyCascade, rs.getShort("DELETE_RULE"));
          assertNull(rs.getString("FK_NAME"));
          assertEquals("PRIMARY_KEY", rs.getString("PK_NAME"));
          assertEquals(DatabaseMetaData.importedKeyNotDeferrable, rs.getShort("DEFERRABILITY"));

          assertTrue(rs.next());
          assertEquals("", rs.getString("PKTABLE_CAT"));
          assertEquals(schema, rs.getString("PKTABLE_SCHEM"));
          assertEquals("Albums", rs.getString("PKTABLE_NAME"));
          assertEquals("AlbumId", rs.getString("PKCOLUMN_NAME"));
          assertEquals("", rs.getString("FKTABLE_CAT"));
          assertEquals(schema, rs.getString("FKTABLE_SCHEM"));
          assertEquals("Songs", rs.getString("FKTABLE_NAME"));
          assertEquals("AlbumId", rs.getString("FKCOLUMN_NAME"));
          assertEquals(2, rs.getShort("KEY_SEQ"));
          assertEquals(DatabaseMetaData.importedKeyNoAction, rs.getShort("UPDATE_RULE"));
          assertEquals(DatabaseMetaData.importedKeyCascade, rs.getShort("DELETE_RULE"));
          assertNull(rs.getString("FK_NAME"));
          assertEquals("PRIMARY_KEY", rs.getString("PK_NAME"));
          assertEquals(DatabaseMetaData.importedKeyNotDeferrable, rs.getShort("DEFERRABILITY"));
        }

        try (ResultSet rs =
            connection
                .getMetaData()
                .getCrossReference(
                    DEFAULT_CATALOG,
                    schema,
                    SINGERS_TABLE,
                    DEFAULT_CATALOG,
                    schema,
                    CONCERTS_TABLE)) {
          assertTrue(rs.next());
          assertEquals("", rs.getString("PKTABLE_CAT"));
          assertEquals(schema, rs.getString("PKTABLE_SCHEM"));
          assertEquals("Singers", rs.getString("PKTABLE_NAME"));
          assertEquals("SingerId", rs.getString("PKCOLUMN_NAME"));
          assertEquals("", rs.getString("FKTABLE_CAT"));
          assertEquals(schema, rs.getString("FKTABLE_SCHEM"));
          assertEquals("Concerts", rs.getString("FKTABLE_NAME"));
          assertEquals("SingerId", rs.getString("FKCOLUMN_NAME"));
          assertEquals(1, rs.getShort("KEY_SEQ"));
          assertEquals(DatabaseMetaData.importedKeyNoAction, rs.getShort("UPDATE_RULE"));
          assertEquals(DatabaseMetaData.importedKeyNoAction, rs.getShort("DELETE_RULE"));
          if (EmulatorSpannerHelper.isUsingEmulator() && "test".equals(schema)) {
            assertEquals("test_Fk_Concerts_Singer", rs.getString("FK_NAME"));
          } else {
            assertEquals("Fk_Concerts_Singer", rs.getString("FK_NAME"));
          }
          assertEquals("PK_Singers", rs.getString("PK_NAME"));
          assertEquals(DatabaseMetaData.importedKeyNotDeferrable, rs.getShort("DEFERRABILITY"));
          assertFalse(rs.next());
        }

        try (ResultSet rs =
            connection
                .getMetaData()
                .getCrossReference(
                    DEFAULT_CATALOG,
                    schema,
                    TABLE_WITH_ALL_COLS,
                    DEFAULT_CATALOG,
                    schema,
                    TABLE_WITH_REF)) {

          assertTrue(rs.next());
          assertEquals("", rs.getString("PKTABLE_CAT"));
          assertEquals(schema, rs.getString("PKTABLE_SCHEM"));
          assertEquals(TABLE_WITH_ALL_COLS, rs.getString("PKTABLE_NAME"));
          assertEquals("ColFloat64", rs.getString("PKCOLUMN_NAME"));
          assertEquals("", rs.getString("FKTABLE_CAT"));
          assertEquals(schema, rs.getString("FKTABLE_SCHEM"));
          assertEquals(TABLE_WITH_REF, rs.getString("FKTABLE_NAME"));
          assertEquals("RefFloat", rs.getString("FKCOLUMN_NAME"));
          assertEquals(1, rs.getShort("KEY_SEQ"));
          assertEquals(DatabaseMetaData.importedKeyNoAction, rs.getShort("UPDATE_RULE"));
          assertEquals(DatabaseMetaData.importedKeyNoAction, rs.getShort("DELETE_RULE"));
          if (EmulatorSpannerHelper.isUsingEmulator() && "test".equals(schema)) {
            assertEquals("test_Fk_TableWithRef_TableWithAllColumnTypes", rs.getString("FK_NAME"));
          } else {
            assertEquals("Fk_TableWithRef_TableWithAllColumnTypes", rs.getString("FK_NAME"));
          }
          assertEquals(DatabaseMetaData.importedKeyNotDeferrable, rs.getShort("DEFERRABILITY"));

          assertTrue(rs.next());
          assertEquals("", rs.getString("PKTABLE_CAT"));
          assertEquals(schema, rs.getString("PKTABLE_SCHEM"));
          assertEquals(TABLE_WITH_ALL_COLS, rs.getString("PKTABLE_NAME"));
          assertEquals("ColString", rs.getString("PKCOLUMN_NAME"));
          assertEquals("", rs.getString("FKTABLE_CAT"));
          assertEquals(schema, rs.getString("FKTABLE_SCHEM"));
          assertEquals(TABLE_WITH_REF, rs.getString("FKTABLE_NAME"));
          assertEquals("RefString", rs.getString("FKCOLUMN_NAME"));
          assertEquals(2, rs.getShort("KEY_SEQ"));
          assertEquals(DatabaseMetaData.importedKeyNoAction, rs.getShort("UPDATE_RULE"));
          assertEquals(DatabaseMetaData.importedKeyNoAction, rs.getShort("DELETE_RULE"));
          if (EmulatorSpannerHelper.isUsingEmulator() && "test".equals(schema)) {
            assertEquals("test_Fk_TableWithRef_TableWithAllColumnTypes", rs.getString("FK_NAME"));
          } else {
            assertEquals("Fk_TableWithRef_TableWithAllColumnTypes", rs.getString("FK_NAME"));
          }
          assertEquals(DatabaseMetaData.importedKeyNotDeferrable, rs.getShort("DEFERRABILITY"));

          assertTrue(rs.next());
          assertEquals("", rs.getString("PKTABLE_CAT"));
          assertEquals(schema, rs.getString("PKTABLE_SCHEM"));
          assertEquals(TABLE_WITH_ALL_COLS, rs.getString("PKTABLE_NAME"));
          assertEquals("ColDate", rs.getString("PKCOLUMN_NAME"));
          assertEquals("", rs.getString("FKTABLE_CAT"));
          assertEquals(schema, rs.getString("FKTABLE_SCHEM"));
          assertEquals(TABLE_WITH_REF, rs.getString("FKTABLE_NAME"));
          assertEquals("RefDate", rs.getString("FKCOLUMN_NAME"));
          assertEquals(3, rs.getShort("KEY_SEQ"));
          assertEquals(DatabaseMetaData.importedKeyNoAction, rs.getShort("UPDATE_RULE"));
          assertEquals(DatabaseMetaData.importedKeyNoAction, rs.getShort("DELETE_RULE"));
          if (EmulatorSpannerHelper.isUsingEmulator() && "test".equals(schema)) {
            assertEquals("test_Fk_TableWithRef_TableWithAllColumnTypes", rs.getString("FK_NAME"));
          } else {
            assertEquals("Fk_TableWithRef_TableWithAllColumnTypes", rs.getString("FK_NAME"));
          }
          assertEquals(DatabaseMetaData.importedKeyNotDeferrable, rs.getShort("DEFERRABILITY"));

          assertFalse(rs.next());
        }
        // try getting self-references
        try (ResultSet rs =
            connection
                .getMetaData()
                .getCrossReference(
                    DEFAULT_CATALOG, schema, ALBUMS_TABLE, DEFAULT_CATALOG, schema, ALBUMS_TABLE)) {
          assertFalse(rs.next());
        }
        // try getting all cross-references in the database
        try (ResultSet rs =
            connection.getMetaData().getCrossReference(null, null, null, null, null, null)) {
          for (int i = 0; i < 14; i++) {
            assertTrue(rs.next());
          }
          assertFalse(rs.next());
        }
      }
    }
  }

  private static final class IndexInfo {
    private final String tableName;
    private final boolean nonUnique;
    private final String indexName;
    private final short ordinalPosition;
    private final String columnName;
    private final String ascDesc;

    private IndexInfo(
        String tableName,
        boolean nonUnique,
        String indexName,
        int ordinalPosition,
        String columnName,
        String ascDesc) {
      this.tableName = tableName;
      this.nonUnique = nonUnique;
      this.indexName = indexName;
      this.ordinalPosition = (short) ordinalPosition;
      this.columnName = columnName;
      this.ascDesc = ascDesc;
    }
  }

  private static final List<IndexInfo> EXPECTED_INDICES =
      Arrays.asList(
          new IndexInfo("Albums", false, "PRIMARY_KEY", 1, "SingerId", "A"),
          new IndexInfo("Albums", false, "PRIMARY_KEY", 2, "AlbumId", "A"),
          new IndexInfo("Albums", true, "AlbumsByAlbumTitle", 1, "AlbumTitle", "A"),
          new IndexInfo("Albums", true, "AlbumsByAlbumTitle2", 0, "MarketingBudget", null),
          new IndexInfo("Albums", true, "AlbumsByAlbumTitle2", 1, "AlbumTitle", "A"),
          new IndexInfo("Concerts", false, "PRIMARY_KEY", 1, "VenueId", "A"),
          new IndexInfo("Concerts", false, "PRIMARY_KEY", 2, "SingerId", "A"),
          new IndexInfo("Concerts", false, "PRIMARY_KEY", 3, "ConcertDate", "A"),
          new IndexInfo(
              "Concerts",
              true,
              "FOREIGN_KEY",
              1,
              "SingerId",
              "A"), // Index automatically added by Cloud Spanner for the referencing column.
          new IndexInfo("Singers", false, "PRIMARY_KEY", 1, "SingerId", "A"),
          new IndexInfo("Singers", true, "SingersByFirstLastName", 1, "FirstName", "A"),
          new IndexInfo("Singers", true, "SingersByFirstLastName", 2, "LastName", "A"),
          new IndexInfo("Songs", false, "PRIMARY_KEY", 1, "SingerId", "A"),
          new IndexInfo("Songs", false, "PRIMARY_KEY", 2, "AlbumId", "A"),
          new IndexInfo("Songs", false, "PRIMARY_KEY", 3, "TrackId", "A"),
          new IndexInfo("Songs", false, "SongsBySingerAlbumSongNameDesc", 1, "SingerId", "A"),
          new IndexInfo("Songs", false, "SongsBySingerAlbumSongNameDesc", 2, "AlbumId", "A"),
          new IndexInfo("Songs", false, "SongsBySingerAlbumSongNameDesc", 3, "SongName", "D"),
          new IndexInfo("Songs", true, "SongsBySongName", 1, "SongName", "A"),
          new IndexInfo(
              "TableWithAllColumnTypes",
              false,
              "GENERATED",
              1,
              "ColFloat64",
              "A"), // Index automatically added by Cloud Spanner for the referencing foreign key.
          new IndexInfo("TableWithAllColumnTypes", false, "GENERATED", 2, "ColString", "A"),
          new IndexInfo("TableWithAllColumnTypes", false, "GENERATED", 3, "ColDate", "A"),
          new IndexInfo("TableWithAllColumnTypes", false, "PRIMARY_KEY", 1, "ColInt64", "A"),
          new IndexInfo("TableWithRef", false, "PRIMARY_KEY", 1, "Id", "A"),
          new IndexInfo("TableWithRef", true, "FOREIGN_KEY", 1, "RefFloat", "A"),
          new IndexInfo("TableWithRef", true, "FOREIGN_KEY", 2, "RefString", "A"),
          new IndexInfo("TableWithRef", true, "FOREIGN_KEY", 3, "RefDate", "A"),
          new IndexInfo("all_nullable_types", false, "PRIMARY_KEY", 1, "ColInt64", "A"));

  @Test
  public void testGetIndexInfo() throws SQLException {
    try (Connection connection = createConnection(env, database)) {
      for (String schema : new String[] {DEFAULT_SCHEMA, "test"}) {
        try (ResultSet rs =
            connection.getMetaData().getIndexInfo(DEFAULT_CATALOG, schema, null, false, false)) {

          for (IndexInfo index : EXPECTED_INDICES) {
            assertTrue(rs.next());
            assertEquals(DEFAULT_CATALOG, rs.getString("TABLE_CAT"));
            assertEquals(schema, rs.getString("TABLE_SCHEM"));
            assertEquals(index.tableName, rs.getString("TABLE_NAME"));
            assertEquals(index.nonUnique, rs.getBoolean("NON_UNIQUE"));
            assertEquals(DEFAULT_CATALOG, rs.getString("INDEX_QUALIFIER"));
            // Foreign key index names are automatically generated.
            if (!"FOREIGN_KEY".equals(index.indexName) && !"GENERATED".equals(index.indexName)) {
              assertEquals(index.indexName, rs.getString("INDEX_NAME"));
            }
            if (index.indexName.equals("PRIMARY_KEY")) {
              assertEquals(DatabaseMetaData.tableIndexClustered, rs.getShort("TYPE"));
            } else {
              assertEquals(DatabaseMetaData.tableIndexHashed, rs.getShort("TYPE"));
            }
            assertEquals(index.ordinalPosition, rs.getShort("ORDINAL_POSITION"));
            if (index.ordinalPosition == 0) {
              assertTrue(rs.wasNull());
            }
            assertEquals(index.columnName, rs.getString("COLUMN_NAME"));
            assertEquals(index.ascDesc, rs.getString("ASC_OR_DESC"));
            assertEquals(-1, rs.getInt("CARDINALITY"));
            assertEquals(-1, rs.getInt("PAGES"));
            assertNull(rs.getString("FILTER_CONDITION"));
          }
          // all indices found
          assertFalse(rs.next());
        }
      }
    }
  }

  @Test
  public void testGetExportedKeys() throws SQLException {
    try (Connection connection = createConnection(env, database)) {
      for (String schema : new String[] {DEFAULT_SCHEMA, "test"}) {
        try (ResultSet rs =
            connection.getMetaData().getExportedKeys(DEFAULT_CATALOG, schema, SINGERS_TABLE)) {
          assertExportedKeysSingers(schema, rs);
        }
        try (ResultSet rs =
            connection.getMetaData().getExportedKeys(DEFAULT_CATALOG, schema, ALBUMS_TABLE)) {
          assertKeysAlbumsSongs(schema, rs);
        }
      }
    }
  }

  @Test
  public void testGetImportedKeys() throws SQLException {
    try (Connection connection = createConnection(env, database)) {
      for (String schema : new String[] {DEFAULT_SCHEMA, "test"}) {
        try (ResultSet rs =
            connection.getMetaData().getImportedKeys(DEFAULT_CATALOG, schema, SINGERS_TABLE)) {
          assertImportedKeysSingers(rs);
        }
        try (ResultSet rs =
            connection.getMetaData().getImportedKeys(DEFAULT_CATALOG, schema, ALBUMS_TABLE)) {
          assertImportedKeysAlbums(schema, rs);
        }
        try (ResultSet rs =
            connection.getMetaData().getImportedKeys(DEFAULT_CATALOG, schema, CONCERTS_TABLE)) {
          assertImportedKeysConcerts(schema, rs);
        }
        try (ResultSet rs =
            connection.getMetaData().getImportedKeys(DEFAULT_CATALOG, schema, SONGS_TABLE)) {
          assertKeysAlbumsSongs(schema, rs);
        }
        try (ResultSet rs =
            connection.getMetaData().getImportedKeys(DEFAULT_CATALOG, schema, TABLE_WITH_REF)) {
          assertImportedKeysTableWithRef(schema, rs);
        }
      }
    }
  }

  private void assertImportedKeysSingers(ResultSet rs) throws SQLException {
    assertFalse(rs.next());
  }

  private void assertImportedKeysTableWithRef(String schema, ResultSet rs) throws SQLException {
    assertTrue(rs.next());
    assertEquals(DEFAULT_CATALOG, rs.getString("PKTABLE_CAT"));
    assertEquals(schema, rs.getString("PKTABLE_SCHEM"));
    assertEquals(TABLE_WITH_ALL_COLS, rs.getString("PKTABLE_NAME"));
    assertEquals("ColFloat64", rs.getString("PKCOLUMN_NAME"));
    assertEquals(DEFAULT_CATALOG, rs.getString("FKTABLE_CAT"));
    assertEquals(schema, rs.getString("FKTABLE_SCHEM"));
    assertEquals(TABLE_WITH_REF, rs.getString("FKTABLE_NAME"));
    assertEquals("RefFloat", rs.getString("FKCOLUMN_NAME"));
    assertEquals(1, rs.getShort("KEY_SEQ"));
    assertEquals(DatabaseMetaData.importedKeyRestrict, rs.getInt("UPDATE_RULE"));
    assertEquals(DatabaseMetaData.importedKeyRestrict, rs.getInt("DELETE_RULE"));
    if (EmulatorSpannerHelper.isUsingEmulator() && "test".equals(schema)) {
      assertEquals("test_Fk_TableWithRef_TableWithAllColumnTypes", rs.getString("FK_NAME"));
    } else {
      assertEquals("Fk_TableWithRef_TableWithAllColumnTypes", rs.getString("FK_NAME"));
    }
    assertNotNull(rs.getString("PK_NAME")); // Index name is generated.
    assertEquals(DatabaseMetaData.importedKeyNotDeferrable, rs.getInt("DEFERRABILITY"));

    assertTrue(rs.next());
    assertEquals(DEFAULT_CATALOG, rs.getString("PKTABLE_CAT"));
    assertEquals(schema, rs.getString("PKTABLE_SCHEM"));
    assertEquals(TABLE_WITH_ALL_COLS, rs.getString("PKTABLE_NAME"));
    assertEquals("ColString", rs.getString("PKCOLUMN_NAME"));
    assertEquals(DEFAULT_CATALOG, rs.getString("FKTABLE_CAT"));
    assertEquals(schema, rs.getString("FKTABLE_SCHEM"));
    assertEquals(TABLE_WITH_REF, rs.getString("FKTABLE_NAME"));
    assertEquals("RefString", rs.getString("FKCOLUMN_NAME"));
    assertEquals(2, rs.getShort("KEY_SEQ"));
    assertEquals(DatabaseMetaData.importedKeyRestrict, rs.getInt("UPDATE_RULE"));
    assertEquals(DatabaseMetaData.importedKeyRestrict, rs.getInt("DELETE_RULE"));
    if (EmulatorSpannerHelper.isUsingEmulator() && "test".equals(schema)) {
      assertEquals("test_Fk_TableWithRef_TableWithAllColumnTypes", rs.getString("FK_NAME"));
    } else {
      assertEquals("Fk_TableWithRef_TableWithAllColumnTypes", rs.getString("FK_NAME"));
    }
    assertNotNull(rs.getString("PK_NAME")); // Index name is generated.
    assertEquals(DatabaseMetaData.importedKeyNotDeferrable, rs.getInt("DEFERRABILITY"));

    assertTrue(rs.next());
    assertEquals(DEFAULT_CATALOG, rs.getString("PKTABLE_CAT"));
    assertEquals(schema, rs.getString("PKTABLE_SCHEM"));
    assertEquals(TABLE_WITH_ALL_COLS, rs.getString("PKTABLE_NAME"));
    assertEquals("ColDate", rs.getString("PKCOLUMN_NAME"));
    assertEquals(DEFAULT_CATALOG, rs.getString("FKTABLE_CAT"));
    assertEquals(schema, rs.getString("FKTABLE_SCHEM"));
    assertEquals(TABLE_WITH_REF, rs.getString("FKTABLE_NAME"));
    assertEquals("RefDate", rs.getString("FKCOLUMN_NAME"));
    assertEquals(3, rs.getShort("KEY_SEQ"));
    assertEquals(DatabaseMetaData.importedKeyRestrict, rs.getInt("UPDATE_RULE"));
    assertEquals(DatabaseMetaData.importedKeyRestrict, rs.getInt("DELETE_RULE"));
    if (EmulatorSpannerHelper.isUsingEmulator() && "test".equals(schema)) {
      assertEquals("test_Fk_TableWithRef_TableWithAllColumnTypes", rs.getString("FK_NAME"));
    } else {
      assertEquals("Fk_TableWithRef_TableWithAllColumnTypes", rs.getString("FK_NAME"));
    }
    assertNotNull(rs.getString("PK_NAME")); // Index name is generated.
    assertEquals(DatabaseMetaData.importedKeyNotDeferrable, rs.getInt("DEFERRABILITY"));

    assertFalse(rs.next());
  }

  private void assertImportedKeysAlbums(String schema, ResultSet rs) throws SQLException {
    assertTrue(rs.next());
    assertEquals(DEFAULT_CATALOG, rs.getString("PKTABLE_CAT"));
    assertEquals(schema, rs.getString("PKTABLE_SCHEM"));
    assertEquals(SINGERS_TABLE, rs.getString("PKTABLE_NAME"));
    assertEquals("SingerId", rs.getString("PKCOLUMN_NAME"));
    assertEquals(DEFAULT_CATALOG, rs.getString("FKTABLE_CAT"));
    assertEquals(schema, rs.getString("FKTABLE_SCHEM"));
    assertEquals(ALBUMS_TABLE, rs.getString("FKTABLE_NAME"));
    assertEquals("SingerId", rs.getString("FKCOLUMN_NAME"));
    assertEquals(1, rs.getShort("KEY_SEQ"));
    assertEquals(DatabaseMetaData.importedKeyRestrict, rs.getInt("UPDATE_RULE"));
    assertEquals(DatabaseMetaData.importedKeyCascade, rs.getInt("DELETE_RULE"));
    assertNull(rs.getString("FK_NAME"));
    assertEquals("PRIMARY_KEY", rs.getString("PK_NAME"));
    assertEquals(DatabaseMetaData.importedKeyNotDeferrable, rs.getInt("DEFERRABILITY"));

    assertFalse(rs.next());
  }

  private void assertImportedKeysConcerts(String schema, ResultSet rs) throws SQLException {
    assertTrue(rs.next());
    assertEquals(DEFAULT_CATALOG, rs.getString("PKTABLE_CAT"));
    assertEquals(schema, rs.getString("PKTABLE_SCHEM"));
    assertEquals(SINGERS_TABLE, rs.getString("PKTABLE_NAME"));
    assertEquals("SingerId", rs.getString("PKCOLUMN_NAME"));
    assertEquals(DEFAULT_CATALOG, rs.getString("FKTABLE_CAT"));
    assertEquals(schema, rs.getString("FKTABLE_SCHEM"));
    assertEquals(CONCERTS_TABLE, rs.getString("FKTABLE_NAME"));
    assertEquals("SingerId", rs.getString("FKCOLUMN_NAME"));
    assertEquals(1, rs.getShort("KEY_SEQ"));
    assertEquals(DatabaseMetaData.importedKeyRestrict, rs.getInt("UPDATE_RULE"));
    assertEquals(DatabaseMetaData.importedKeyRestrict, rs.getInt("DELETE_RULE"));
    if (EmulatorSpannerHelper.isUsingEmulator() && "test".equals(schema)) {
      assertEquals("test_Fk_Concerts_Singer", rs.getString("FK_NAME"));
    } else {
      assertEquals("Fk_Concerts_Singer", rs.getString("FK_NAME"));
    }
    assertEquals("PK_Singers", rs.getString("PK_NAME"));
    assertEquals(DatabaseMetaData.importedKeyNotDeferrable, rs.getInt("DEFERRABILITY"));

    assertFalse(rs.next());
  }

  private void assertExportedKeysSingers(String schema, ResultSet rs) throws SQLException {
    assertTrue(rs.next());
    assertEquals(DEFAULT_CATALOG, rs.getString("PKTABLE_CAT"));
    assertEquals(schema, rs.getString("PKTABLE_SCHEM"));
    assertEquals(SINGERS_TABLE, rs.getString("PKTABLE_NAME"));
    assertEquals("SingerId", rs.getString("PKCOLUMN_NAME"));
    assertEquals(DEFAULT_CATALOG, rs.getString("FKTABLE_CAT"));
    assertEquals(schema, rs.getString("FKTABLE_SCHEM"));
    assertEquals(ALBUMS_TABLE, rs.getString("FKTABLE_NAME"));
    assertEquals("SingerId", rs.getString("FKCOLUMN_NAME"));
    assertEquals(1, rs.getShort("KEY_SEQ"));
    assertEquals(DatabaseMetaData.importedKeyRestrict, rs.getInt("UPDATE_RULE"));
    assertEquals(DatabaseMetaData.importedKeyCascade, rs.getInt("DELETE_RULE"));
    assertNull(rs.getString("FK_NAME"));
    assertEquals("PRIMARY_KEY", rs.getString("PK_NAME"));
    assertEquals(DatabaseMetaData.importedKeyNotDeferrable, rs.getInt("DEFERRABILITY"));

    assertTrue(rs.next());
    assertEquals(DEFAULT_CATALOG, rs.getString("PKTABLE_CAT"));
    assertEquals(schema, rs.getString("PKTABLE_SCHEM"));
    assertEquals(SINGERS_TABLE, rs.getString("PKTABLE_NAME"));
    assertEquals("SingerId", rs.getString("PKCOLUMN_NAME"));
    assertEquals(DEFAULT_CATALOG, rs.getString("FKTABLE_CAT"));
    assertEquals(schema, rs.getString("FKTABLE_SCHEM"));
    assertEquals(CONCERTS_TABLE, rs.getString("FKTABLE_NAME"));
    assertEquals("SingerId", rs.getString("FKCOLUMN_NAME"));
    assertEquals(1, rs.getShort("KEY_SEQ"));
    assertEquals(DatabaseMetaData.importedKeyRestrict, rs.getInt("UPDATE_RULE"));
    assertEquals(DatabaseMetaData.importedKeyRestrict, rs.getInt("DELETE_RULE"));
    if (EmulatorSpannerHelper.isUsingEmulator() && "test".equals(schema)) {
      assertEquals("test_Fk_Concerts_Singer", rs.getString("FK_NAME"));
    } else {
      assertEquals("Fk_Concerts_Singer", rs.getString("FK_NAME"));
    }
    assertEquals("PK_Singers", rs.getString("PK_NAME"));
    assertEquals(DatabaseMetaData.importedKeyNotDeferrable, rs.getInt("DEFERRABILITY"));

    assertFalse(rs.next());
  }

  private void assertKeysAlbumsSongs(String schema, ResultSet rs) throws SQLException {
    assertTrue(rs.next());
    assertEquals(DEFAULT_CATALOG, rs.getString("PKTABLE_CAT"));
    assertEquals(schema, rs.getString("PKTABLE_SCHEM"));
    assertEquals(ALBUMS_TABLE, rs.getString("PKTABLE_NAME"));
    assertEquals("SingerId", rs.getString("PKCOLUMN_NAME"));
    assertEquals(DEFAULT_CATALOG, rs.getString("FKTABLE_CAT"));
    assertEquals(schema, rs.getString("FKTABLE_SCHEM"));
    assertEquals(SONGS_TABLE, rs.getString("FKTABLE_NAME"));
    assertEquals("SingerId", rs.getString("FKCOLUMN_NAME"));
    assertEquals(1, rs.getShort("KEY_SEQ"));
    assertEquals(DatabaseMetaData.importedKeyRestrict, rs.getInt("UPDATE_RULE"));
    assertEquals(DatabaseMetaData.importedKeyCascade, rs.getInt("DELETE_RULE"));
    assertNull(rs.getString("FK_NAME"));
    assertEquals("PRIMARY_KEY", rs.getString("PK_NAME"));
    assertEquals(DatabaseMetaData.importedKeyNotDeferrable, rs.getInt("DEFERRABILITY"));

    assertTrue(rs.next());
    assertEquals(DEFAULT_CATALOG, rs.getString("PKTABLE_CAT"));
    assertEquals(schema, rs.getString("PKTABLE_SCHEM"));
    assertEquals(ALBUMS_TABLE, rs.getString("PKTABLE_NAME"));
    assertEquals("AlbumId", rs.getString("PKCOLUMN_NAME"));
    assertEquals(DEFAULT_CATALOG, rs.getString("FKTABLE_CAT"));
    assertEquals(schema, rs.getString("FKTABLE_SCHEM"));
    assertEquals(SONGS_TABLE, rs.getString("FKTABLE_NAME"));
    assertEquals("AlbumId", rs.getString("FKCOLUMN_NAME"));
    assertEquals(2, rs.getShort("KEY_SEQ"));
    assertEquals(DatabaseMetaData.importedKeyRestrict, rs.getInt("UPDATE_RULE"));
    assertEquals(DatabaseMetaData.importedKeyCascade, rs.getInt("DELETE_RULE"));
    assertNull(rs.getString("FK_NAME"));
    assertEquals("PRIMARY_KEY", rs.getString("PK_NAME"));
    assertEquals(DatabaseMetaData.importedKeyNotDeferrable, rs.getInt("DEFERRABILITY"));
    assertFalse(rs.next());
  }

  @Test
  public void testGetPrimaryKeys() throws SQLException {
    try (Connection connection = createConnection(env, database)) {
      for (String schema : new String[] {DEFAULT_SCHEMA, "test"}) {
        try (ResultSet rs =
            connection.getMetaData().getPrimaryKeys(DEFAULT_CATALOG, schema, SINGERS_TABLE)) {
          assertTrue(rs.next());
          assertEquals(DEFAULT_CATALOG, rs.getString("TABLE_CAT"));
          assertEquals(schema, rs.getString("TABLE_SCHEM"));
          assertEquals(SINGERS_TABLE, rs.getString("TABLE_NAME"));
          assertEquals("SingerId", rs.getString("COLUMN_NAME"));
          assertEquals(1, rs.getInt("KEY_SEQ"));
          assertEquals("PRIMARY_KEY", rs.getString("PK_NAME"));
          assertFalse(rs.next());
        }
        try (ResultSet rs =
            connection.getMetaData().getPrimaryKeys(DEFAULT_CATALOG, schema, ALBUMS_TABLE)) {
          assertTrue(rs.next());
          assertEquals(DEFAULT_CATALOG, rs.getString("TABLE_CAT"));
          assertEquals(schema, rs.getString("TABLE_SCHEM"));
          assertEquals(ALBUMS_TABLE, rs.getString("TABLE_NAME"));
          assertEquals("SingerId", rs.getString("COLUMN_NAME"));
          assertEquals(1, rs.getInt("KEY_SEQ"));
          assertEquals("PRIMARY_KEY", rs.getString("PK_NAME"));
          assertTrue(rs.next());
          assertEquals(DEFAULT_CATALOG, rs.getString("TABLE_CAT"));
          assertEquals(schema, rs.getString("TABLE_SCHEM"));
          assertEquals(ALBUMS_TABLE, rs.getString("TABLE_NAME"));
          assertEquals("AlbumId", rs.getString("COLUMN_NAME"));
          assertEquals(2, rs.getInt("KEY_SEQ"));
          assertEquals("PRIMARY_KEY", rs.getString("PK_NAME"));
          assertFalse(rs.next());
        }
      }
    }
  }

  @Test
  public void testGetViews() throws SQLException {
    try (Connection connection = createConnection(env, database)) {
      for (String schema : new String[] {DEFAULT_SCHEMA, "test"}) {
        try (ResultSet rs =
            connection
                .getMetaData()
                .getTables(DEFAULT_CATALOG, schema, null, new String[] {"VIEW"})) {
          assertTrue(rs.next());
          assertEquals(schema, rs.getString("TABLE_SCHEM"));
          assertEquals(DEFAULT_CATALOG, rs.getString("TABLE_CAT"));
          assertEquals("SingersView", rs.getString("TABLE_NAME"));
          assertFalse(rs.next());
        }
      }
    }
  }

  @Test
  public void testGetSchemas() throws SQLException {
    try (Connection connection = createConnection(env, database)) {
      assertEquals("", connection.getSchema());
      try (ResultSet schemas = connection.getMetaData().getSchemas()) {
        assertTrue(schemas.next());
        assertEquals(DEFAULT_SCHEMA, schemas.getString("TABLE_SCHEM"));
        assertEquals(DEFAULT_CATALOG, schemas.getString("TABLE_CATALOG"));

        assertTrue(schemas.next());
        assertEquals("INFORMATION_SCHEMA", schemas.getString("TABLE_SCHEM"));
        assertEquals(DEFAULT_CATALOG, schemas.getString("TABLE_CATALOG"));

        assertTrue(schemas.next());
        assertEquals("SPANNER_SYS", schemas.getString("TABLE_SCHEM"));
        assertEquals(DEFAULT_CATALOG, schemas.getString("TABLE_CATALOG"));

        assertTrue(schemas.next());
        assertEquals("test", schemas.getString("TABLE_SCHEM"));
        assertEquals(DEFAULT_CATALOG, schemas.getString("TABLE_CATALOG"));

        assertFalse(schemas.next());
      }
    }
  }

  @Test
  public void testGetCatalogs() throws SQLException {
    try (Connection connection = createConnection(env, database)) {
      assertEquals("", connection.getCatalog());
      try (ResultSet rs = connection.getMetaData().getCatalogs()) {
        assertTrue(rs.next());
        assertEquals("", rs.getString("TABLE_CAT"));

        assertFalse(rs.next());
      }
    }
  }

  private static final class Table {
    private final String name;
    private final String type;

    private Table(String name) {
      this(name, "TABLE");
    }

    private Table(String name, String type) {
      this.name = name;
      this.type = type;
    }
  }

  private static final List<Table> EXPECTED_TABLES =
      Arrays.asList(
          new Table("Albums"),
          new Table("Concerts"),
          new Table("Singers"),
          new Table("SingersView", "VIEW"),
          new Table("Songs"),
          new Table("TableWithAllColumnTypes"),
          new Table("TableWithRef"),
          new Table("all_nullable_types"));

  @Test
  public void testGetTables() throws SQLException {
    try (Connection connection = createConnection(env, database)) {
      for (String schema : new String[] {DEFAULT_SCHEMA, "test"}) {
        try (ResultSet rs =
            connection.getMetaData().getTables(DEFAULT_CATALOG, schema, null, null)) {
          for (Table table : EXPECTED_TABLES) {
            assertTrue(rs.next());
            assertEquals(DEFAULT_CATALOG, rs.getString("TABLE_CAT"));
            assertEquals(schema, rs.getString("TABLE_SCHEM"));
            assertEquals(table.name, rs.getString("TABLE_NAME"));
            assertEquals(table.type, rs.getString("TABLE_TYPE"));
            assertNull(rs.getString("REMARKS"));
            assertNull(rs.getString("TYPE_CAT"));
            assertNull(rs.getString("TYPE_SCHEM"));
            assertNull(rs.getString("TYPE_NAME"));
            assertNull(rs.getString("SELF_REFERENCING_COL_NAME"));
            assertNull(rs.getString("REF_GENERATION"));
          }
          assertFalse(rs.next());
        }
      }
    }
  }
}
