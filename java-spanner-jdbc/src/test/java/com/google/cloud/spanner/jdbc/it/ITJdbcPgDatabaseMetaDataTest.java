/*
 * Copyright 2022 Google LLC
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
import static org.junit.Assume.assumeFalse;

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

/** Integration tests for {@link DatabaseMetaData} implementation for Spangres. */
@Category(ParallelIntegrationTest.class)
@RunWith(JUnit4.class)
public class ITJdbcPgDatabaseMetaDataTest extends ITAbstractJdbcTest {
  @ClassRule public static JdbcIntegrationTestEnv env = new JdbcIntegrationTestEnv();

  private static final String DEFAULT_SCHEMA = "public";
  private static final String SINGERS_TABLE = "Singers";
  private static final String ALBUMS_TABLE = "Albums";
  private static final String SONGS_TABLE = "Songs";
  private static final String CONCERTS_TABLE = "Concerts";
  private static final String TABLE_WITH_ALL_COLS = "TableWithAllColumnTypes";
  private static final String TABLE_WITH_REF = "TableWithRef";

  private static Database database;

  @BeforeClass
  public static void setup() throws Exception {
    assumeFalse(
        "PostgreSQL dialect is not yet supported on the emulator",
        EmulatorSpannerHelper.isUsingEmulator());

    database = env.getOrCreateDatabase(Dialect.POSTGRESQL, getMusicTablesDdl(Dialect.POSTGRESQL));

    // Create the same tables in an additional 'test' schema.
    DatabaseAdminClient client = env.getTestHelper().getClient().getDatabaseAdminClient();
    List<String> tables =
        getMusicTablesDdl(Dialect.POSTGRESQL).stream()
            .map(statement -> statement.replace("CREATE TABLE ", "CREATE TABLE test."))
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

  @Override
  public Dialect getDialect() {
    return Dialect.POSTGRESQL;
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

    private Column(
        String name,
        int type,
        String typeName,
        Integer colSize,
        Integer decimalDigits,
        Integer radix,
        boolean nullable,
        Integer charOctetLength) {
      this(name, type, typeName, colSize, decimalDigits, radix, nullable, charOctetLength, false);
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
        boolean computed) {
      this.name = name;
      this.type = type;
      this.typeName = typeName;
      this.colSize = colSize;
      this.decimalDigits = decimalDigits;
      this.radix = radix;
      this.nullable = nullable;
      this.charOctetLength = charOctetLength;
      this.computed = computed;
    }
  }

  private static final List<Column> EXPECTED_COLUMNS =
      Arrays.asList(
          new Column("colint64", Types.BIGINT, "bigint", 19, null, 10, false, null),
          new Column("colfloat64", Types.DOUBLE, "double precision", 15, 16, 2, false, null),
          new Column("colfloat32", Types.REAL, "real", 15, 16, 2, false, null),
          new Column("colbool", Types.BOOLEAN, "boolean", null, null, null, false, null),
          new Column("colstring", Types.NVARCHAR, "character varying", 100, null, null, false, 100),
          new Column(
              "colstringmax", Types.NVARCHAR, "character varying", null, null, null, true, null),
          new Column("colbytes", Types.BINARY, "bytea", 10485760, null, null, false, null),
          new Column("coldate", Types.DATE, "date", 10, null, null, false, null),
          new Column(
              "coltimestamp",
              Types.TIMESTAMP,
              "timestamp with time zone",
              35,
              null,
              null,
              true,
              null),
          new Column("colnumeric", Types.NUMERIC, "numeric", 15, 16383, 10, false, null),
          // TODO: Update this to typeName=jsonb and colSize=2621440
          new Column(
              "coljson", Types.NVARCHAR, "character varying", null, null, null, false, null));

  @Test
  public void testGetColumns() throws SQLException {
    try (Connection connection = createConnection(env, database)) {
      for (String schema : new String[] {DEFAULT_SCHEMA, "test"}) {
        try (ResultSet rs =
            connection
                .getMetaData()
                .getColumns(getDefaultCatalog(database), schema, TABLE_WITH_ALL_COLS, null)) {
          int pos = 1;
          for (Column col : EXPECTED_COLUMNS) {
            assertTrue(rs.next());
            assertEquals(getDefaultCatalog(database), rs.getString("TABLE_CAT"));
            assertEquals(schema, rs.getString("TABLE_SCHEM"));
            assertEquals("tablewithallcolumntypes", rs.getString("TABLE_NAME"));
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
                "Nullable difference for " + col.name,
                col.nullable ? DatabaseMetaData.columnNullable : DatabaseMetaData.columnNoNulls,
                rs.getInt("NULLABLE"));
            assertNull(rs.getString("REMARKS"));
            assertNull(rs.getString("COLUMN_DEF"));
            assertEquals(0, rs.getInt("SQL_DATA_TYPE"));
            assertEquals(0, rs.getInt("SQL_DATETIME_SUB"));
            if (col.charOctetLength == null) {
              assertEquals(0, rs.getInt("CHAR_OCTET_LENGTH"));
              assertTrue(rs.wasNull());
            } else {
              assertEquals(col.charOctetLength.intValue(), rs.getInt("CHAR_OCTET_LENGTH"));
            }
            assertEquals(pos, rs.getInt("ORDINAL_POSITION"));
            assertEquals(col.nullable ? "YES" : "NO", rs.getString("IS_NULLABLE"));
            assertNull(rs.getString("SCOPE_CATALOG"));
            assertNull(rs.getString("SCOPE_SCHEMA"));
            assertNull(rs.getString("SCOPE_TABLE"));

            assertEquals((short) 0, rs.getShort("SOURCE_DATA_TYPE"));
            assertTrue(rs.wasNull());

            assertEquals("NO", rs.getString("IS_AUTOINCREMENT"));
            assertEquals(col.computed ? "YES" : "NO", rs.getString("IS_GENERATEDCOLUMN"));
            assertEquals(24, rs.getMetaData().getColumnCount());

            pos++;
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
                    getDefaultCatalog(database),
                    schema,
                    SINGERS_TABLE,
                    getDefaultCatalog(database),
                    schema,
                    ALBUMS_TABLE)) {
          assertTrue(rs.next());

          assertEquals(getDefaultCatalog(database), rs.getString("PKTABLE_CAT"));
          assertEquals(schema, rs.getString("PKTABLE_SCHEM"));
          assertEquals("singers", rs.getString("PKTABLE_NAME"));
          assertEquals("singerid", rs.getString("PKCOLUMN_NAME"));
          assertEquals(getDefaultCatalog(database), rs.getString("FKTABLE_CAT"));
          assertEquals(schema, rs.getString("FKTABLE_SCHEM"));
          assertEquals("albums", rs.getString("FKTABLE_NAME"));
          assertEquals("singerid", rs.getString("FKCOLUMN_NAME"));
          assertEquals((short) 1, rs.getShort("KEY_SEQ"));
          assertEquals((short) DatabaseMetaData.importedKeyNoAction, rs.getShort("UPDATE_RULE"));
          assertEquals((short) DatabaseMetaData.importedKeyNoAction, rs.getShort("DELETE_RULE"));
          assertNotNull(rs.getString("FK_NAME"));
          assertEquals("PK_singers", rs.getString("PK_NAME"));
          assertEquals(
              (short) DatabaseMetaData.importedKeyNotDeferrable, rs.getShort("DEFERRABILITY"));
        }
        try (ResultSet rs =
            connection
                .getMetaData()
                .getCrossReference(
                    getDefaultCatalog(database),
                    schema,
                    ALBUMS_TABLE,
                    getDefaultCatalog(database),
                    schema,
                    SONGS_TABLE)) {
          assertTrue(rs.next());
          assertEquals(getDefaultCatalog(database), rs.getString("PKTABLE_CAT"));
          assertEquals(schema, rs.getString("PKTABLE_SCHEM"));
          assertEquals("albums", rs.getString("PKTABLE_NAME"));
          assertEquals("singerid", rs.getString("PKCOLUMN_NAME"));
          assertEquals(getDefaultCatalog(database), rs.getString("FKTABLE_CAT"));
          assertEquals(schema, rs.getString("FKTABLE_SCHEM"));
          assertEquals("songs", rs.getString("FKTABLE_NAME"));
          assertEquals("singerid", rs.getString("FKCOLUMN_NAME"));
          assertEquals((short) 1, rs.getShort("KEY_SEQ"));
          assertEquals((short) DatabaseMetaData.importedKeyNoAction, rs.getShort("UPDATE_RULE"));
          assertEquals((short) DatabaseMetaData.importedKeyNoAction, rs.getShort("DELETE_RULE"));
          assertNotNull(rs.getString("FK_NAME"));
          assertEquals("PK_albums", rs.getString("PK_NAME"));
          assertEquals(
              (short) DatabaseMetaData.importedKeyNotDeferrable, rs.getShort("DEFERRABILITY"));

          assertTrue(rs.next());
          assertEquals(getDefaultCatalog(database), rs.getString("PKTABLE_CAT"));
          assertEquals(schema, rs.getString("PKTABLE_SCHEM"));
          assertEquals("albums", rs.getString("PKTABLE_NAME"));
          assertEquals("albumid", rs.getString("PKCOLUMN_NAME"));
          assertEquals(getDefaultCatalog(database), rs.getString("FKTABLE_CAT"));
          assertEquals(schema, rs.getString("FKTABLE_SCHEM"));
          assertEquals("songs", rs.getString("FKTABLE_NAME"));
          assertEquals("albumid", rs.getString("FKCOLUMN_NAME"));
          assertEquals((short) 2, rs.getShort("KEY_SEQ"));
          assertEquals((short) DatabaseMetaData.importedKeyNoAction, rs.getShort("UPDATE_RULE"));
          assertEquals((short) DatabaseMetaData.importedKeyNoAction, rs.getShort("DELETE_RULE"));
          assertNotNull(rs.getString("FK_NAME"));
          assertEquals("PK_albums", rs.getString("PK_NAME"));
          assertEquals(
              (short) DatabaseMetaData.importedKeyNotDeferrable, rs.getShort("DEFERRABILITY"));

          assertFalse(rs.next());
        }

        try (ResultSet rs =
            connection
                .getMetaData()
                .getCrossReference(
                    getDefaultCatalog(database),
                    schema,
                    SINGERS_TABLE,
                    getDefaultCatalog(database),
                    schema,
                    CONCERTS_TABLE)) {
          assertTrue(rs.next());
          assertEquals(getDefaultCatalog(database), rs.getString("PKTABLE_CAT"));
          assertEquals(schema, rs.getString("PKTABLE_SCHEM"));
          assertEquals("singers", rs.getString("PKTABLE_NAME"));
          assertEquals("singerid", rs.getString("PKCOLUMN_NAME"));
          assertEquals(getDefaultCatalog(database), rs.getString("FKTABLE_CAT"));
          assertEquals(schema, rs.getString("FKTABLE_SCHEM"));
          assertEquals("concerts", rs.getString("FKTABLE_NAME"));
          assertEquals("singerid", rs.getString("FKCOLUMN_NAME"));
          assertEquals((short) 1, rs.getShort("KEY_SEQ"));
          assertEquals((short) DatabaseMetaData.importedKeyNoAction, rs.getShort("UPDATE_RULE"));
          assertEquals((short) DatabaseMetaData.importedKeyNoAction, rs.getShort("DELETE_RULE"));
          assertNotNull(rs.getString("FK_NAME"));
          assertEquals("PK_singers", rs.getString("PK_NAME"));
          assertEquals(
              (short) DatabaseMetaData.importedKeyNotDeferrable, rs.getShort("DEFERRABILITY"));

          assertFalse(rs.next());
        }

        try (ResultSet rs =
            connection
                .getMetaData()
                .getCrossReference(
                    getDefaultCatalog(database),
                    schema,
                    TABLE_WITH_ALL_COLS,
                    getDefaultCatalog(database),
                    schema,
                    TABLE_WITH_REF)) {

          assertTrue(schema, rs.next());
          assertEquals(getDefaultCatalog(database), rs.getString("PKTABLE_CAT"));
          assertEquals(schema, rs.getString("PKTABLE_SCHEM"));
          assertEquals("tablewithallcolumntypes", rs.getString("PKTABLE_NAME"));
          assertEquals("colfloat64", rs.getString("PKCOLUMN_NAME"));
          assertEquals(getDefaultCatalog(database), rs.getString("FKTABLE_CAT"));
          assertEquals(schema, rs.getString("FKTABLE_SCHEM"));
          assertEquals("tablewithref", rs.getString("FKTABLE_NAME"));
          assertEquals("reffloat", rs.getString("FKCOLUMN_NAME"));
          assertEquals((short) 1, rs.getShort("KEY_SEQ"));
          assertEquals((short) DatabaseMetaData.importedKeyNoAction, rs.getShort("UPDATE_RULE"));
          assertEquals((short) DatabaseMetaData.importedKeyNoAction, rs.getShort("DELETE_RULE"));
          assertEquals("fk_tablewithref_tablewithallcolumntypes", rs.getString("FK_NAME"));
          assertEquals(
              (short) DatabaseMetaData.importedKeyNotDeferrable, rs.getShort("DEFERRABILITY"));

          assertTrue(rs.next());
          assertEquals(getDefaultCatalog(database), rs.getString("PKTABLE_CAT"));
          assertEquals(schema, rs.getString("PKTABLE_SCHEM"));
          assertEquals("tablewithallcolumntypes", rs.getString("PKTABLE_NAME"));
          assertEquals("colstring", rs.getString("PKCOLUMN_NAME"));
          assertEquals(getDefaultCatalog(database), rs.getString("FKTABLE_CAT"));
          assertEquals(schema, rs.getString("FKTABLE_SCHEM"));
          assertEquals("tablewithref", rs.getString("FKTABLE_NAME"));
          assertEquals("refstring", rs.getString("FKCOLUMN_NAME"));
          assertEquals((short) 2, rs.getShort("KEY_SEQ"));
          assertEquals((short) DatabaseMetaData.importedKeyNoAction, rs.getShort("UPDATE_RULE"));
          assertEquals((short) DatabaseMetaData.importedKeyNoAction, rs.getShort("DELETE_RULE"));
          assertEquals("fk_tablewithref_tablewithallcolumntypes", rs.getString("FK_NAME"));
          assertEquals(
              (short) DatabaseMetaData.importedKeyNotDeferrable, rs.getShort("DEFERRABILITY"));

          assertFalse(rs.next());
        }
        // try getting self-references
        try (ResultSet rs =
            connection
                .getMetaData()
                .getCrossReference(
                    getDefaultCatalog(database),
                    schema,
                    ALBUMS_TABLE,
                    getDefaultCatalog(database),
                    schema,
                    ALBUMS_TABLE)) {
          assertFalse(rs.next());
        }
      }
      // try getting all cross-references in the database
      try (ResultSet rs =
          connection.getMetaData().getCrossReference(null, null, null, null, null, null)) {
        int count = 0;
        while (rs.next()) {
          count++;
        }
        assertEquals(12, count);
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
          new IndexInfo("albums", false, "PRIMARY_KEY", 1, "singerid", "A"),
          new IndexInfo("albums", false, "PRIMARY_KEY", 2, "albumid", "A"),
          new IndexInfo("albums", true, "albumsbyalbumtitle", 1, "albumtitle", "A"),
          new IndexInfo("all_nullable_types", false, "PRIMARY_KEY", 1, "colint64", "A"),
          new IndexInfo("concerts", false, "PRIMARY_KEY", 1, "venueid", "A"),
          new IndexInfo("concerts", false, "PRIMARY_KEY", 2, "singerid", "A"),
          new IndexInfo("concerts", false, "PRIMARY_KEY", 3, "concertdate", "A"),
          new IndexInfo("concerts", true, "GENERATED", 1, "singerid", "A"),
          new IndexInfo("singers", false, "PRIMARY_KEY", 1, "singerid", "A"),
          new IndexInfo("singers", true, "singersbyfirstlastname", 1, "firstname", "A"),
          new IndexInfo("singers", true, "singersbyfirstlastname", 2, "lastname", "A"),
          new IndexInfo("songs", false, "PRIMARY_KEY", 1, "singerid", "A"),
          new IndexInfo("songs", false, "PRIMARY_KEY", 2, "albumid", "A"),
          new IndexInfo("songs", false, "PRIMARY_KEY", 3, "trackid", "A"),
          new IndexInfo("songs", false, "songsbysingeralbumsongnamedesc", 1, "singerid", "A"),
          new IndexInfo("songs", false, "songsbysingeralbumsongnamedesc", 2, "albumid", "A"),
          new IndexInfo("songs", false, "songsbysingeralbumsongnamedesc", 3, "songname", "D"),
          new IndexInfo("songs", true, "songsbysongname", 1, "songname", "A"),
          new IndexInfo(
              "tablewithallcolumntypes",
              false,
              "GENERATED",
              1,
              "colfloat64",
              "A"), // Index automatically added by Cloud Spanner for the referencing foreign key.
          new IndexInfo("tablewithallcolumntypes", false, "GENERATED", 2, "colstring", "A"),
          new IndexInfo("tablewithallcolumntypes", false, "PRIMARY_KEY", 1, "colint64", "A"),
          new IndexInfo("tablewithref", false, "PRIMARY_KEY", 1, "id", "A"),
          new IndexInfo("tablewithref", true, "FOREIGN_KEY", 1, "reffloat", "A"),
          new IndexInfo("tablewithref", true, "FOREIGN_KEY", 2, "refstring", "A"));

  @Test
  public void testGetIndexInfo() throws SQLException {
    try (Connection connection = createConnection(env, database)) {
      for (String schema : new String[] {DEFAULT_SCHEMA, "test"}) {
        try (ResultSet rs =
            connection
                .getMetaData()
                .getIndexInfo(getDefaultCatalog(database), schema, null, false, false)) {

          for (IndexInfo index : EXPECTED_INDICES) {
            assertTrue(rs.next());
            assertEquals(getDefaultCatalog(database), rs.getString("TABLE_CAT"));
            assertEquals(schema, rs.getString("TABLE_SCHEM"));
            assertEquals(index.tableName, rs.getString("TABLE_NAME"));
            assertEquals(index.nonUnique, rs.getBoolean("NON_UNIQUE"));
            assertEquals(getDefaultCatalog(database), rs.getString("INDEX_QUALIFIER"));

            // Foreign key index names are automatically generated.
            if (!"FOREIGN_KEY".equals(index.indexName) && !"GENERATED".equals(index.indexName)) {
              assertEquals(index.indexName, rs.getString("INDEX_NAME"));
            }
            assertEquals(DatabaseMetaData.tableIndexHashed, rs.getShort("TYPE"));
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
            connection
                .getMetaData()
                .getExportedKeys(getDefaultCatalog(database), schema, SINGERS_TABLE)) {
          assertExportedKeysSingers(schema, rs);
        }
        try (ResultSet rs =
            connection
                .getMetaData()
                .getExportedKeys(getDefaultCatalog(database), schema, ALBUMS_TABLE)) {
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
            connection
                .getMetaData()
                .getImportedKeys(getDefaultCatalog(database), schema, SINGERS_TABLE)) {
          assertImportedKeysSingers(schema, rs);
        }
        try (ResultSet rs =
            connection
                .getMetaData()
                .getImportedKeys(getDefaultCatalog(database), schema, ALBUMS_TABLE)) {
          assertImportedKeysAlbums(schema, rs);
        }
        try (ResultSet rs =
            connection
                .getMetaData()
                .getImportedKeys(getDefaultCatalog(database), schema, CONCERTS_TABLE)) {
          assertImportedKeysConcerts(schema, rs);
        }
        try (ResultSet rs =
            connection
                .getMetaData()
                .getImportedKeys(getDefaultCatalog(database), schema, SONGS_TABLE)) {
          assertKeysAlbumsSongs(schema, rs);
        }
        try (ResultSet rs =
            connection
                .getMetaData()
                .getImportedKeys(getDefaultCatalog(database), schema, TABLE_WITH_REF)) {
          assertImportedKeysTableWithRef(schema, rs);
        }
      }
    }
  }

  private void assertImportedKeysSingers(String schema, ResultSet rs) throws SQLException {
    assertFalse(rs.next());
  }

  private void assertImportedKeysTableWithRef(String schema, ResultSet rs) throws SQLException {
    assertTrue(rs.next());
    assertEquals(getDefaultCatalog(database), rs.getString("PKTABLE_CAT"));
    assertEquals(schema, rs.getString("PKTABLE_SCHEM"));
    assertEquals("tablewithallcolumntypes", rs.getString("PKTABLE_NAME"));
    assertEquals("colfloat64", rs.getString("PKCOLUMN_NAME"));
    assertEquals(getDefaultCatalog(database), rs.getString("FKTABLE_CAT"));
    assertEquals(schema, rs.getString("FKTABLE_SCHEM"));
    assertEquals("tablewithref", rs.getString("FKTABLE_NAME"));
    assertEquals("reffloat", rs.getString("FKCOLUMN_NAME"));
    assertEquals((short) 1, rs.getShort("KEY_SEQ"));
    assertEquals(DatabaseMetaData.importedKeyRestrict, rs.getInt("UPDATE_RULE"));
    assertEquals(DatabaseMetaData.importedKeyRestrict, rs.getInt("DELETE_RULE"));
    assertEquals("fk_tablewithref_tablewithallcolumntypes", rs.getString("FK_NAME"));
    assertNotNull(rs.getString("PK_NAME"));
    assertEquals(DatabaseMetaData.importedKeyNotDeferrable, rs.getInt("DEFERRABILITY"));

    assertTrue(rs.next());
    assertEquals(getDefaultCatalog(database), rs.getString("PKTABLE_CAT"));
    assertEquals(schema, rs.getString("PKTABLE_SCHEM"));
    assertEquals("tablewithallcolumntypes", rs.getString("PKTABLE_NAME"));
    assertEquals("colstring", rs.getString("PKCOLUMN_NAME"));
    assertEquals(getDefaultCatalog(database), rs.getString("FKTABLE_CAT"));
    assertEquals(schema, rs.getString("FKTABLE_SCHEM"));
    assertEquals("tablewithref", rs.getString("FKTABLE_NAME"));
    assertEquals("refstring", rs.getString("FKCOLUMN_NAME"));
    assertEquals((short) 2, rs.getShort("KEY_SEQ"));
    assertEquals(DatabaseMetaData.importedKeyRestrict, rs.getInt("UPDATE_RULE"));
    assertEquals(DatabaseMetaData.importedKeyRestrict, rs.getInt("DELETE_RULE"));
    assertEquals("fk_tablewithref_tablewithallcolumntypes", rs.getString("FK_NAME"));
    assertNotNull(rs.getString("PK_NAME"));
    assertEquals(DatabaseMetaData.importedKeyNotDeferrable, rs.getInt("DEFERRABILITY"));

    assertFalse(rs.next());
  }

  private void assertImportedKeysAlbums(String schema, ResultSet rs) throws SQLException {
    assertTrue(rs.next());
    assertEquals(getDefaultCatalog(database), rs.getString("PKTABLE_CAT"));
    assertEquals(schema, rs.getString("PKTABLE_SCHEM"));
    assertEquals("singers", rs.getString("PKTABLE_NAME"));
    assertEquals("singerid", rs.getString("PKCOLUMN_NAME"));
    assertEquals(getDefaultCatalog(database), rs.getString("FKTABLE_CAT"));
    assertEquals(schema, rs.getString("FKTABLE_SCHEM"));
    assertEquals("albums", rs.getString("FKTABLE_NAME"));
    assertEquals("singerid", rs.getString("FKCOLUMN_NAME"));
    assertEquals((short) 1, rs.getShort("KEY_SEQ"));
    assertEquals(DatabaseMetaData.importedKeyRestrict, rs.getInt("UPDATE_RULE"));
    assertEquals(DatabaseMetaData.importedKeyRestrict, rs.getInt("DELETE_RULE"));
    assertNotNull(rs.getString("FK_NAME")); // FK name is generated.
    assertEquals("PK_singers", rs.getString("PK_NAME"));
    assertEquals(DatabaseMetaData.importedKeyNotDeferrable, rs.getInt("DEFERRABILITY"));

    assertFalse(rs.next());
  }

  private void assertImportedKeysConcerts(String schema, ResultSet rs) throws SQLException {
    assertTrue(rs.next());
    assertEquals(getDefaultCatalog(database), rs.getString("PKTABLE_CAT"));
    assertEquals(schema, rs.getString("PKTABLE_SCHEM"));
    assertEquals("singers", rs.getString("PKTABLE_NAME"));
    assertEquals("singerid", rs.getString("PKCOLUMN_NAME"));
    assertEquals(getDefaultCatalog(database), rs.getString("FKTABLE_CAT"));
    assertEquals(schema, rs.getString("FKTABLE_SCHEM"));
    assertEquals("concerts", rs.getString("FKTABLE_NAME"));
    assertEquals("singerid", rs.getString("FKCOLUMN_NAME"));
    assertEquals((short) 1, rs.getShort("KEY_SEQ"));
    assertEquals(DatabaseMetaData.importedKeyRestrict, rs.getInt("UPDATE_RULE"));
    assertEquals(DatabaseMetaData.importedKeyRestrict, rs.getInt("DELETE_RULE"));
    assertEquals("PK_singers", rs.getString("PK_NAME"));
    assertEquals(DatabaseMetaData.importedKeyNotDeferrable, rs.getInt("DEFERRABILITY"));

    assertFalse(rs.next());
  }

  private void assertExportedKeysSingers(String schema, ResultSet rs) throws SQLException {
    assertTrue(rs.next());
    assertEquals(getDefaultCatalog(database), rs.getString("PKTABLE_CAT"));
    assertEquals(schema, rs.getString("PKTABLE_SCHEM"));
    assertEquals("singers", rs.getString("PKTABLE_NAME"));
    assertEquals("singerid", rs.getString("PKCOLUMN_NAME"));
    assertEquals(getDefaultCatalog(database), rs.getString("FKTABLE_CAT"));
    assertEquals(schema, rs.getString("FKTABLE_SCHEM"));
    assertEquals("albums", rs.getString("FKTABLE_NAME"));
    assertEquals("singerid", rs.getString("FKCOLUMN_NAME"));
    assertEquals((short) 1, rs.getShort("KEY_SEQ"));
    assertEquals(DatabaseMetaData.importedKeyRestrict, rs.getInt("UPDATE_RULE"));
    assertEquals(DatabaseMetaData.importedKeyRestrict, rs.getInt("DELETE_RULE"));
    assertNotNull(rs.getString("FK_NAME")); // FK name is generated.
    assertEquals("PK_singers", rs.getString("PK_NAME"));
    assertEquals(DatabaseMetaData.importedKeyNotDeferrable, rs.getInt("DEFERRABILITY"));

    assertTrue(rs.next());
    assertEquals(getDefaultCatalog(database), rs.getString("PKTABLE_CAT"));
    assertEquals(schema, rs.getString("PKTABLE_SCHEM"));
    assertEquals("singers", rs.getString("PKTABLE_NAME"));
    assertEquals("singerid", rs.getString("PKCOLUMN_NAME"));
    assertEquals(getDefaultCatalog(database), rs.getString("FKTABLE_CAT"));
    assertEquals(schema, rs.getString("FKTABLE_SCHEM"));
    assertEquals("concerts", rs.getString("FKTABLE_NAME"));
    assertEquals("singerid", rs.getString("FKCOLUMN_NAME"));
    assertEquals((short) 1, rs.getShort("KEY_SEQ"));
    assertEquals(DatabaseMetaData.importedKeyRestrict, rs.getInt("UPDATE_RULE"));
    assertEquals(DatabaseMetaData.importedKeyRestrict, rs.getInt("DELETE_RULE"));
    assertNotNull(rs.getString("FK_NAME"));
    assertEquals("PK_singers", rs.getString("PK_NAME"));
    assertEquals(DatabaseMetaData.importedKeyNotDeferrable, rs.getInt("DEFERRABILITY"));

    assertFalse(rs.next());
  }

  private void assertKeysAlbumsSongs(String schema, ResultSet rs) throws SQLException {
    assertTrue(rs.next());
    assertEquals(getDefaultCatalog(database), rs.getString("PKTABLE_CAT"));
    assertEquals(schema, rs.getString("PKTABLE_SCHEM"));
    assertEquals("albums", rs.getString("PKTABLE_NAME"));
    assertEquals("singerid", rs.getString("PKCOLUMN_NAME"));
    assertEquals(getDefaultCatalog(database), rs.getString("FKTABLE_CAT"));
    assertEquals(schema, rs.getString("FKTABLE_SCHEM"));
    assertEquals("songs", rs.getString("FKTABLE_NAME"));
    assertEquals("singerid", rs.getString("FKCOLUMN_NAME"));
    assertEquals((short) 1, rs.getShort("KEY_SEQ"));
    assertEquals(DatabaseMetaData.importedKeyRestrict, rs.getInt("UPDATE_RULE"));
    assertEquals(DatabaseMetaData.importedKeyRestrict, rs.getInt("DELETE_RULE"));
    assertNotNull(rs.getString("FK_NAME")); // FK name is generated.
    assertEquals("PK_albums", rs.getString("PK_NAME"));
    assertEquals(DatabaseMetaData.importedKeyNotDeferrable, rs.getInt("DEFERRABILITY"));

    assertTrue(rs.next());
    assertEquals(getDefaultCatalog(database), rs.getString("PKTABLE_CAT"));
    assertEquals(schema, rs.getString("PKTABLE_SCHEM"));
    assertEquals("albums", rs.getString("PKTABLE_NAME"));
    assertEquals("albumid", rs.getString("PKCOLUMN_NAME"));
    assertEquals(getDefaultCatalog(database), rs.getString("FKTABLE_CAT"));
    assertEquals(schema, rs.getString("FKTABLE_SCHEM"));
    assertEquals("songs", rs.getString("FKTABLE_NAME"));
    assertEquals("albumid", rs.getString("FKCOLUMN_NAME"));
    assertEquals((short) 2, rs.getShort("KEY_SEQ"));
    assertEquals(DatabaseMetaData.importedKeyRestrict, rs.getInt("UPDATE_RULE"));
    assertEquals(DatabaseMetaData.importedKeyRestrict, rs.getInt("DELETE_RULE"));
    assertNotNull(rs.getString("FK_NAME")); // FK name is generated.
    assertEquals("PK_albums", rs.getString("PK_NAME"));
    assertEquals(DatabaseMetaData.importedKeyNotDeferrable, rs.getInt("DEFERRABILITY"));

    assertFalse(rs.next());
  }

  @Test
  public void testGetPrimaryKeys() throws SQLException {
    try (Connection connection = createConnection(env, database)) {
      for (String schema : new String[] {DEFAULT_SCHEMA, "test"}) {
        try (ResultSet rs =
            connection
                .getMetaData()
                .getPrimaryKeys(getDefaultCatalog(database), schema, SINGERS_TABLE)) {
          assertTrue(rs.next());
          assertEquals(getDefaultCatalog(database), rs.getString("TABLE_CAT"));
          assertEquals(schema, rs.getString("TABLE_SCHEM"));
          assertEquals("singers", rs.getString("TABLE_NAME"));
          assertEquals("singerid", rs.getString("COLUMN_NAME"));
          assertEquals(1, rs.getInt("KEY_SEQ"));
          assertEquals("PRIMARY_KEY", rs.getString("PK_NAME"));
          assertFalse(rs.next());
        }

        try (ResultSet rs =
            connection
                .getMetaData()
                .getPrimaryKeys(getDefaultCatalog(database), schema, ALBUMS_TABLE)) {
          assertTrue(rs.next());
          assertEquals(getDefaultCatalog(database), rs.getString("TABLE_CAT"));
          assertEquals(schema, rs.getString("TABLE_SCHEM"));
          assertEquals("albums", rs.getString("TABLE_NAME"));
          assertEquals("singerid", rs.getString("COLUMN_NAME"));
          assertEquals(1, rs.getInt("KEY_SEQ"));
          assertEquals("PRIMARY_KEY", rs.getString("PK_NAME"));
          assertTrue(rs.next());
          assertEquals(getDefaultCatalog(database), rs.getString("TABLE_CAT"));
          assertEquals(schema, rs.getString("TABLE_SCHEM"));
          assertEquals("albums", rs.getString("TABLE_NAME"));
          assertEquals("albumid", rs.getString("COLUMN_NAME"));
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
                .getTables(getDefaultCatalog(database), schema, null, new String[] {"VIEW"})) {
          assertTrue(rs.next());
          assertEquals(getDefaultCatalog(database), rs.getString("TABLE_CAT"));
          assertEquals(schema, rs.getString("TABLE_SCHEM"));
          assertEquals("singersview", rs.getString("TABLE_NAME"));
          assertFalse(rs.next());
        }
      }
    }
  }

  @Test
  public void testGetSchemas() throws SQLException {
    try (Connection connection = createConnection(env, database)) {
      assertEquals("public", connection.getSchema());
      try (ResultSet schemas = connection.getMetaData().getSchemas()) {
        assertTrue(schemas.next());
        assertEquals(getDefaultCatalog(database), schemas.getString("TABLE_CATALOG"));
        assertEquals("information_schema", schemas.getString("TABLE_SCHEM"));

        assertTrue(schemas.next());
        assertEquals(getDefaultCatalog(database), schemas.getString("TABLE_CATALOG"));
        assertEquals("pg_catalog", schemas.getString("TABLE_SCHEM"));

        assertTrue(schemas.next());
        assertEquals(getDefaultCatalog(database), schemas.getString("TABLE_CATALOG"));
        assertEquals("public", schemas.getString("TABLE_SCHEM"));

        assertTrue(schemas.next());
        assertEquals(getDefaultCatalog(database), schemas.getString("TABLE_CATALOG"));
        assertEquals("spanner_sys", schemas.getString("TABLE_SCHEM"));

        assertTrue(schemas.next());
        assertEquals(getDefaultCatalog(database), schemas.getString("TABLE_CATALOG"));
        assertEquals("test", schemas.getString("TABLE_SCHEM"));

        assertFalse(schemas.next());
      }
    }
  }

  @Test
  public void testGetCatalogs() throws SQLException {
    try (Connection connection = createConnection(env, database)) {
      assertEquals(database.getId().getDatabase(), connection.getCatalog());
      try (ResultSet rs = connection.getMetaData().getCatalogs()) {
        assertTrue(rs.next());
        assertEquals(database.getId().getDatabase(), rs.getString("TABLE_CAT"));

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
          new Table("albums"),
          new Table("all_nullable_types"),
          new Table("concerts"),
          new Table("singers"),
          new Table("singersview", "VIEW"),
          new Table("songs"),
          new Table("tablewithallcolumntypes"),
          new Table("tablewithref"));

  @Test
  public void testGetTables() throws SQLException {
    try (Connection connection = createConnection(env, database)) {
      try (ResultSet rs =
          connection
              .getMetaData()
              .getTables(getDefaultCatalog(database), DEFAULT_SCHEMA, null, null)) {
        for (Table table : EXPECTED_TABLES) {
          assertTrue(rs.next());
          assertEquals(getDefaultCatalog(database), rs.getString("TABLE_CAT"));
          assertEquals(DEFAULT_SCHEMA, rs.getString("TABLE_SCHEM"));
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
