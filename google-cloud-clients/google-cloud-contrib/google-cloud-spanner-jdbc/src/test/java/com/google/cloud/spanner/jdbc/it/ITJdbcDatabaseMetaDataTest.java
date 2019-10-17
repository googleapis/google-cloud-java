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

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import com.google.cloud.spanner.IntegrationTest;
import com.google.cloud.spanner.jdbc.ITAbstractJdbcTest;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Integration tests for {@link DatabaseMetaData} implementation for Spanner. */
@Category(IntegrationTest.class)
@RunWith(JUnit4.class)
public class ITJdbcDatabaseMetaDataTest extends ITAbstractJdbcTest {
  private static final String DEFAULT_CATALOG = "";
  private static final String DEFAULT_SCHEMA = "";
  private static final String SINGERS_TABLE = "Singers";
  private static final String ALBUMS_TABLE = "Albums";
  private static final String SONGS_TABLE = "Songs";
  private static final String TABLE_WITH_ALL_COLS = "TableWithAllColumnTypes";

  @Override
  protected boolean doCreateMusicTables() {
    return true;
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

    private Column(
        String name,
        int type,
        String typeName,
        Integer colSize,
        Integer decimalDigits,
        Integer radix,
        boolean nullable,
        Integer charOctetLength) {
      this.name = name;
      this.type = type;
      this.typeName = typeName;
      this.colSize = colSize;
      this.decimalDigits = decimalDigits;
      this.radix = radix;
      this.nullable = nullable;
      this.charOctetLength = charOctetLength;
    }
  }

  private static final List<Column> EXPECTED_COLUMNS =
      Arrays.asList(
          new Column("ColInt64", Types.BIGINT, "INT64", 19, null, 10, false, null),
          new Column("ColFloat64", Types.DOUBLE, "FLOAT64", 15, 16, 2, false, null),
          new Column("ColBool", Types.BOOLEAN, "BOOL", null, null, null, false, null),
          new Column("ColString", Types.NVARCHAR, "STRING(100)", 100, null, null, false, 100),
          new Column(
              "ColStringMax", Types.NVARCHAR, "STRING(MAX)", 2621440, null, null, false, 2621440),
          new Column("ColBytes", Types.BINARY, "BYTES(100)", 100, null, null, false, null),
          new Column("ColBytesMax", Types.BINARY, "BYTES(MAX)", 10485760, null, null, false, null),
          new Column("ColDate", Types.DATE, "DATE", 10, null, null, false, null),
          new Column("ColTimestamp", Types.TIMESTAMP, "TIMESTAMP", 35, null, null, false, null),
          new Column("ColCommitTS", Types.TIMESTAMP, "TIMESTAMP", 35, null, null, false, null),
          new Column("ColInt64Array", Types.ARRAY, "ARRAY<INT64>", 19, null, 10, true, null),
          new Column("ColFloat64Array", Types.ARRAY, "ARRAY<FLOAT64>", 15, 16, 2, true, null),
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
              "ColTimestampArray", Types.ARRAY, "ARRAY<TIMESTAMP>", 35, null, null, true, null));

  @Test
  public void testGetColumns() throws SQLException {
    try (Connection connection = createConnection()) {
      try (ResultSet rs =
          connection
              .getMetaData()
              .getColumns(DEFAULT_CATALOG, DEFAULT_SCHEMA, TABLE_WITH_ALL_COLS, null)) {
        int pos = 1;
        for (Column col : EXPECTED_COLUMNS) {
          assertThat(rs.next(), is(true));
          assertThat(rs.getString("TABLE_CAT"), is(equalTo(DEFAULT_CATALOG)));
          assertThat(rs.getString("TABLE_SCHEM"), is(equalTo(DEFAULT_SCHEMA)));
          assertThat(rs.getString("TABLE_NAME"), is(equalTo(TABLE_WITH_ALL_COLS)));
          assertThat(rs.getString("COLUMN_NAME"), is(equalTo(col.name)));
          assertThat(rs.getInt("DATA_TYPE"), is(equalTo(col.type)));
          assertThat(rs.getString("TYPE_NAME"), is(equalTo(col.typeName)));
          if (col.colSize == null) {
            assertThat(rs.getInt("COLUMN_SIZE"), is(equalTo(0)));
            assertThat(rs.wasNull(), is(true));
          } else {
            assertThat(rs.getInt("COLUMN_SIZE"), is(equalTo(col.colSize)));
          }
          rs.getObject("BUFFER_LENGTH"); // just assert that it exists
          if (col.decimalDigits == null) {
            assertThat(rs.getInt("DECIMAL_DIGITS"), is(equalTo(0)));
            assertThat(rs.wasNull(), is(true));
          } else {
            assertThat(rs.getInt("DECIMAL_DIGITS"), is(equalTo(col.decimalDigits)));
          }
          if (col.radix == null) {
            assertThat(rs.getInt("NUM_PREC_RADIX"), is(equalTo(0)));
            assertThat(rs.wasNull(), is(true));
          } else {
            assertThat(rs.getInt("NUM_PREC_RADIX"), is(equalTo(col.radix)));
          }
          assertThat(
              rs.getInt("NULLABLE"),
              is(
                  equalTo(
                      col.nullable
                          ? DatabaseMetaData.columnNullable
                          : DatabaseMetaData.columnNoNulls)));
          assertThat(rs.getString("REMARKS"), is(nullValue()));
          assertThat(rs.getString("COLUMN_DEF"), is(nullValue()));
          assertThat(rs.getInt("SQL_DATA_TYPE"), is(equalTo(0)));
          assertThat(rs.getInt("SQL_DATETIME_SUB"), is(equalTo(0)));
          if (col.charOctetLength == null) {
            assertThat(rs.getInt("CHAR_OCTET_LENGTH"), is(equalTo(0)));
            assertThat(rs.wasNull(), is(true));
          } else {
            assertThat(rs.getInt("CHAR_OCTET_LENGTH"), is(equalTo(col.charOctetLength)));
          }
          assertThat(rs.getInt("ORDINAL_POSITION"), is(equalTo(pos)));
          assertThat(rs.getString("IS_NULLABLE"), is(equalTo(col.nullable ? "YES" : "NO")));
          assertThat(rs.getString("SCOPE_CATALOG"), is(nullValue()));
          assertThat(rs.getString("SCOPE_SCHEMA"), is(nullValue()));
          assertThat(rs.getString("SCOPE_TABLE"), is(nullValue()));
          assertThat(rs.getShort("SOURCE_DATA_TYPE"), is(equalTo((short) 0)));
          assertThat(rs.wasNull(), is(true));
          assertThat(rs.getString("IS_AUTOINCREMENT"), is(equalTo("NO")));
          assertThat(rs.getString("IS_GENERATEDCOLUMN"), is(equalTo("NO")));
          assertThat(rs.getMetaData().getColumnCount(), is(equalTo(24)));

          pos++;
        }
        assertThat(rs.next(), is(false));
      }
    }
  }

  @Test
  public void testGetCrossReferences() throws SQLException {
    try (Connection connection = createConnection()) {
      try (ResultSet rs =
          connection
              .getMetaData()
              .getCrossReference(
                  DEFAULT_CATALOG,
                  DEFAULT_SCHEMA,
                  SINGERS_TABLE,
                  DEFAULT_CATALOG,
                  DEFAULT_SCHEMA,
                  ALBUMS_TABLE)) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getString("PKTABLE_CAT"), is(equalTo("")));
        assertThat(rs.getString("PKTABLE_SCHEM"), is(equalTo("")));
        assertThat(rs.getString("PKTABLE_NAME"), is(equalTo("Singers")));
        assertThat(rs.getString("PKCOLUMN_NAME"), is(equalTo("SingerId")));
        assertThat(rs.getString("FKTABLE_CAT"), is(equalTo("")));
        assertThat(rs.getString("FKTABLE_SCHEM"), is(equalTo("")));
        assertThat(rs.getString("FKTABLE_NAME"), is(equalTo("Albums")));
        assertThat(rs.getString("FKCOLUMN_NAME"), is(equalTo("SingerId")));
        assertThat(rs.getShort("KEY_SEQ"), is(equalTo((short) 1)));
        assertThat(
            rs.getShort("UPDATE_RULE"), is(equalTo((short) DatabaseMetaData.importedKeyNoAction)));
        assertThat(
            rs.getShort("DELETE_RULE"), is(equalTo((short) DatabaseMetaData.importedKeyCascade)));
        assertThat(rs.getString("FK_NAME"), is(nullValue()));
        assertThat(rs.getString("PK_NAME"), is(equalTo("PRIMARY_KEY")));
        assertThat(
            rs.getShort("DEFERRABILITY"),
            is(equalTo((short) DatabaseMetaData.importedKeyNotDeferrable)));
      }
      try (ResultSet rs =
          connection
              .getMetaData()
              .getCrossReference(
                  DEFAULT_CATALOG,
                  DEFAULT_SCHEMA,
                  ALBUMS_TABLE,
                  DEFAULT_CATALOG,
                  DEFAULT_SCHEMA,
                  SONGS_TABLE)) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getString("PKTABLE_CAT"), is(equalTo("")));
        assertThat(rs.getString("PKTABLE_SCHEM"), is(equalTo("")));
        assertThat(rs.getString("PKTABLE_NAME"), is(equalTo("Albums")));
        assertThat(rs.getString("PKCOLUMN_NAME"), is(equalTo("SingerId")));
        assertThat(rs.getString("FKTABLE_CAT"), is(equalTo("")));
        assertThat(rs.getString("FKTABLE_SCHEM"), is(equalTo("")));
        assertThat(rs.getString("FKTABLE_NAME"), is(equalTo("Songs")));
        assertThat(rs.getString("FKCOLUMN_NAME"), is(equalTo("SingerId")));
        assertThat(rs.getShort("KEY_SEQ"), is(equalTo((short) 1)));
        assertThat(
            rs.getShort("UPDATE_RULE"), is(equalTo((short) DatabaseMetaData.importedKeyNoAction)));
        assertThat(
            rs.getShort("DELETE_RULE"), is(equalTo((short) DatabaseMetaData.importedKeyCascade)));
        assertThat(rs.getString("FK_NAME"), is(nullValue()));
        assertThat(rs.getString("PK_NAME"), is(equalTo("PRIMARY_KEY")));
        assertThat(
            rs.getShort("DEFERRABILITY"),
            is(equalTo((short) DatabaseMetaData.importedKeyNotDeferrable)));

        assertThat(rs.next(), is(true));
        assertThat(rs.getString("PKTABLE_CAT"), is(equalTo("")));
        assertThat(rs.getString("PKTABLE_SCHEM"), is(equalTo("")));
        assertThat(rs.getString("PKTABLE_NAME"), is(equalTo("Albums")));
        assertThat(rs.getString("PKCOLUMN_NAME"), is(equalTo("AlbumId")));
        assertThat(rs.getString("FKTABLE_CAT"), is(equalTo("")));
        assertThat(rs.getString("FKTABLE_SCHEM"), is(equalTo("")));
        assertThat(rs.getString("FKTABLE_NAME"), is(equalTo("Songs")));
        assertThat(rs.getString("FKCOLUMN_NAME"), is(equalTo("AlbumId")));
        assertThat(rs.getShort("KEY_SEQ"), is(equalTo((short) 2)));
        assertThat(
            rs.getShort("UPDATE_RULE"), is(equalTo((short) DatabaseMetaData.importedKeyNoAction)));
        assertThat(
            rs.getShort("DELETE_RULE"), is(equalTo((short) DatabaseMetaData.importedKeyCascade)));
        assertThat(rs.getString("FK_NAME"), is(nullValue()));
        assertThat(rs.getString("PK_NAME"), is(equalTo("PRIMARY_KEY")));
        assertThat(
            rs.getShort("DEFERRABILITY"),
            is(equalTo((short) DatabaseMetaData.importedKeyNotDeferrable)));
      }
      // try getting self-references
      try (ResultSet rs =
          connection
              .getMetaData()
              .getCrossReference(
                  DEFAULT_CATALOG,
                  DEFAULT_SCHEMA,
                  ALBUMS_TABLE,
                  DEFAULT_CATALOG,
                  DEFAULT_SCHEMA,
                  ALBUMS_TABLE)) {
        assertThat(rs.next(), is(false));
      }
      // try getting all cross-references in the database
      try (ResultSet rs =
          connection.getMetaData().getCrossReference(null, null, null, null, null, null)) {
        for (int i = 0; i < 3; i++) {
          assertThat(rs.next(), is(true));
        }
        assertThat(rs.next(), is(false));
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
          new IndexInfo("TableWithAllColumnTypes", false, "PRIMARY_KEY", 1, "ColInt64", "A"));

  @Test
  public void testGetIndexInfo() throws SQLException {
    try (Connection connection = createConnection()) {
      try (ResultSet rs =
          connection
              .getMetaData()
              .getIndexInfo(DEFAULT_CATALOG, DEFAULT_SCHEMA, null, false, false)) {

        for (IndexInfo index : EXPECTED_INDICES) {
          assertThat(rs.next(), is(true));
          assertThat(rs.getString("TABLE_CAT"), is(equalTo(DEFAULT_CATALOG)));
          assertThat(rs.getString("TABLE_SCHEM"), is(equalTo(DEFAULT_SCHEMA)));
          assertThat(rs.getString("TABLE_NAME"), is(equalTo(index.tableName)));
          assertThat(rs.getBoolean("NON_UNIQUE"), is(index.nonUnique));
          assertThat(rs.getString("INDEX_QUALIFIER"), is(equalTo(DEFAULT_CATALOG)));
          assertThat(rs.getString("INDEX_NAME"), is(equalTo(index.indexName)));
          if (index.indexName.equals("PRIMARY_KEY")) {
            assertThat(rs.getShort("TYPE"), is(equalTo(DatabaseMetaData.tableIndexClustered)));
          } else {
            assertThat(rs.getShort("TYPE"), is(equalTo(DatabaseMetaData.tableIndexHashed)));
          }
          assertThat(rs.getShort("ORDINAL_POSITION"), is(equalTo(index.ordinalPosition)));
          if (index.ordinalPosition == 0) {
            assertThat(rs.wasNull(), is(true));
          }
          assertThat(rs.getString("COLUMN_NAME"), is(equalTo(index.columnName)));
          assertThat(rs.getString("ASC_OR_DESC"), is(equalTo(index.ascDesc)));
          assertThat(rs.getInt("CARDINALITY"), is(equalTo(-1)));
          assertThat(rs.getInt("PAGES"), is(equalTo(-1)));
          assertThat(rs.getString("FILTER_CONDITION"), is(nullValue()));
        }
        // all indices found
        assertThat(rs.next(), is(false));
      }
    }
  }

  @Test
  public void testGetExportedKeys() throws SQLException {
    try (Connection connection = createConnection()) {
      try (ResultSet rs =
          connection
              .getMetaData()
              .getExportedKeys(DEFAULT_CATALOG, DEFAULT_SCHEMA, SINGERS_TABLE)) {
        assertKeysSingersAlbums(rs);
      }
      try (ResultSet rs =
          connection.getMetaData().getExportedKeys(DEFAULT_CATALOG, DEFAULT_SCHEMA, ALBUMS_TABLE)) {
        assertKeysAlbumsSongs(rs);
      }
    }
  }

  @Test
  public void testGetImportedKeys() throws SQLException {
    try (Connection connection = createConnection()) {
      try (ResultSet rs =
          connection.getMetaData().getImportedKeys(DEFAULT_CATALOG, DEFAULT_SCHEMA, ALBUMS_TABLE)) {
        assertKeysSingersAlbums(rs);
      }
      try (ResultSet rs =
          connection.getMetaData().getImportedKeys(DEFAULT_CATALOG, DEFAULT_SCHEMA, SONGS_TABLE)) {
        assertKeysAlbumsSongs(rs);
      }
    }
  }

  private void assertKeysSingersAlbums(ResultSet rs) throws SQLException {
    assertThat(rs.next(), is(true));
    assertThat(rs.getString("PKTABLE_CAT"), is(equalTo(DEFAULT_CATALOG)));
    assertThat(rs.getString("PKTABLE_SCHEM"), is(equalTo(DEFAULT_SCHEMA)));
    assertThat(rs.getString("PKTABLE_NAME"), is(equalTo(SINGERS_TABLE)));
    assertThat(rs.getString("PKCOLUMN_NAME"), is(equalTo("SingerId")));
    assertThat(rs.getString("FKTABLE_CAT"), is(equalTo(DEFAULT_CATALOG)));
    assertThat(rs.getString("FKTABLE_SCHEM"), is(equalTo(DEFAULT_SCHEMA)));
    assertThat(rs.getString("FKTABLE_NAME"), is(equalTo(ALBUMS_TABLE)));
    assertThat(rs.getString("FKCOLUMN_NAME"), is(equalTo("SingerId")));
    assertThat(rs.getShort("KEY_SEQ"), is(equalTo((short) 1)));
    assertThat(rs.getInt("UPDATE_RULE"), is(equalTo(DatabaseMetaData.importedKeyRestrict)));
    assertThat(rs.getInt("DELETE_RULE"), is(equalTo(DatabaseMetaData.importedKeyCascade)));
    assertThat(rs.getString("FK_NAME"), is(nullValue()));
    assertThat(rs.getString("PK_NAME"), is(equalTo("PRIMARY_KEY")));
    assertThat(rs.getInt("DEFERRABILITY"), is(equalTo(DatabaseMetaData.importedKeyNotDeferrable)));
    assertThat(rs.next(), is(false));
  }

  private void assertKeysAlbumsSongs(ResultSet rs) throws SQLException {
    assertThat(rs.next(), is(true));
    assertThat(rs.getString("PKTABLE_CAT"), is(equalTo(DEFAULT_CATALOG)));
    assertThat(rs.getString("PKTABLE_SCHEM"), is(equalTo(DEFAULT_SCHEMA)));
    assertThat(rs.getString("PKTABLE_NAME"), is(equalTo(ALBUMS_TABLE)));
    assertThat(rs.getString("PKCOLUMN_NAME"), is(equalTo("SingerId")));
    assertThat(rs.getString("FKTABLE_CAT"), is(equalTo(DEFAULT_CATALOG)));
    assertThat(rs.getString("FKTABLE_SCHEM"), is(equalTo(DEFAULT_SCHEMA)));
    assertThat(rs.getString("FKTABLE_NAME"), is(equalTo(SONGS_TABLE)));
    assertThat(rs.getString("FKCOLUMN_NAME"), is(equalTo("SingerId")));
    assertThat(rs.getShort("KEY_SEQ"), is(equalTo((short) 1)));
    assertThat(rs.getInt("UPDATE_RULE"), is(equalTo(DatabaseMetaData.importedKeyRestrict)));
    assertThat(rs.getInt("DELETE_RULE"), is(equalTo(DatabaseMetaData.importedKeyCascade)));
    assertThat(rs.getString("FK_NAME"), is(nullValue()));
    assertThat(rs.getString("PK_NAME"), is(equalTo("PRIMARY_KEY")));
    assertThat(rs.getInt("DEFERRABILITY"), is(equalTo(DatabaseMetaData.importedKeyNotDeferrable)));

    assertThat(rs.next(), is(true));
    assertThat(rs.getString("PKTABLE_CAT"), is(equalTo(DEFAULT_CATALOG)));
    assertThat(rs.getString("PKTABLE_SCHEM"), is(equalTo(DEFAULT_SCHEMA)));
    assertThat(rs.getString("PKTABLE_NAME"), is(equalTo(ALBUMS_TABLE)));
    assertThat(rs.getString("PKCOLUMN_NAME"), is(equalTo("AlbumId")));
    assertThat(rs.getString("FKTABLE_CAT"), is(equalTo(DEFAULT_CATALOG)));
    assertThat(rs.getString("FKTABLE_SCHEM"), is(equalTo(DEFAULT_SCHEMA)));
    assertThat(rs.getString("FKTABLE_NAME"), is(equalTo(SONGS_TABLE)));
    assertThat(rs.getString("FKCOLUMN_NAME"), is(equalTo("AlbumId")));
    assertThat(rs.getShort("KEY_SEQ"), is(equalTo((short) 2)));
    assertThat(rs.getInt("UPDATE_RULE"), is(equalTo(DatabaseMetaData.importedKeyRestrict)));
    assertThat(rs.getInt("DELETE_RULE"), is(equalTo(DatabaseMetaData.importedKeyCascade)));
    assertThat(rs.getString("FK_NAME"), is(nullValue()));
    assertThat(rs.getString("PK_NAME"), is(equalTo("PRIMARY_KEY")));
    assertThat(rs.getInt("DEFERRABILITY"), is(equalTo(DatabaseMetaData.importedKeyNotDeferrable)));
    assertThat(rs.next(), is(false));
  }

  @Test
  public void testGetPrimaryKeys() throws SQLException {
    try (Connection connection = createConnection()) {
      try (ResultSet rs =
          connection.getMetaData().getPrimaryKeys(DEFAULT_CATALOG, DEFAULT_SCHEMA, SINGERS_TABLE)) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getString("TABLE_CAT"), is(equalTo(DEFAULT_CATALOG)));
        assertThat(rs.getString("TABLE_SCHEM"), is(equalTo(DEFAULT_SCHEMA)));
        assertThat(rs.getString("TABLE_NAME"), is(equalTo(SINGERS_TABLE)));
        assertThat(rs.getString("COLUMN_NAME"), is(equalTo("SingerId")));
        assertThat(rs.getInt("KEY_SEQ"), is(equalTo(1)));
        assertThat(rs.getString("PK_NAME"), is(equalTo("PRIMARY_KEY")));
        assertThat(rs.next(), is(false));
      }
      try (ResultSet rs =
          connection.getMetaData().getPrimaryKeys(DEFAULT_CATALOG, DEFAULT_SCHEMA, ALBUMS_TABLE)) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getString("TABLE_CAT"), is(equalTo(DEFAULT_CATALOG)));
        assertThat(rs.getString("TABLE_SCHEM"), is(equalTo(DEFAULT_SCHEMA)));
        assertThat(rs.getString("TABLE_NAME"), is(equalTo(ALBUMS_TABLE)));
        assertThat(rs.getString("COLUMN_NAME"), is(equalTo("SingerId")));
        assertThat(rs.getInt("KEY_SEQ"), is(equalTo(1)));
        assertThat(rs.getString("PK_NAME"), is(equalTo("PRIMARY_KEY")));
        assertThat(rs.next(), is(true));
        assertThat(rs.getString("TABLE_CAT"), is(equalTo(DEFAULT_CATALOG)));
        assertThat(rs.getString("TABLE_SCHEM"), is(equalTo(DEFAULT_SCHEMA)));
        assertThat(rs.getString("TABLE_NAME"), is(equalTo(ALBUMS_TABLE)));
        assertThat(rs.getString("COLUMN_NAME"), is(equalTo("AlbumId")));
        assertThat(rs.getInt("KEY_SEQ"), is(equalTo(2)));
        assertThat(rs.getString("PK_NAME"), is(equalTo("PRIMARY_KEY")));
        assertThat(rs.next(), is(false));
      }
    }
  }

  @Test
  public void testGetSchemas() throws SQLException {
    try (Connection connection = createConnection()) {
      try (ResultSet rs = connection.getMetaData().getSchemas()) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getString("TABLE_SCHEM"), is(equalTo(DEFAULT_SCHEMA)));
        assertThat(rs.getString("TABLE_CATALOG"), is(equalTo(DEFAULT_CATALOG)));
        assertThat(rs.next(), is(true));
        assertThat(rs.getString("TABLE_SCHEM"), is(equalTo("INFORMATION_SCHEMA")));
        assertThat(rs.getString("TABLE_CATALOG"), is(equalTo(DEFAULT_CATALOG)));
        assertThat(rs.next(), is(true));
        assertThat(rs.getString("TABLE_SCHEM"), is(equalTo("SPANNER_SYS")));
        assertThat(rs.getString("TABLE_CATALOG"), is(equalTo(DEFAULT_CATALOG)));
      }
    }
  }

  private static final class Table {
    private final String name;

    private Table(String name) {
      this.name = name;
    }
  }

  private static final List<Table> EXPECTED_TABLES =
      Arrays.asList(
          new Table("Albums"),
          new Table("Concerts"),
          new Table("Singers"),
          new Table("Songs"),
          new Table("TableWithAllColumnTypes"));

  @Test
  public void testGetTables() throws SQLException {
    try (Connection connection = createConnection()) {
      try (ResultSet rs =
          connection.getMetaData().getTables(DEFAULT_CATALOG, DEFAULT_SCHEMA, null, null)) {
        for (Table table : EXPECTED_TABLES) {
          assertThat(rs.next(), is(true));
          assertThat(rs.getString("TABLE_CAT"), is(equalTo(DEFAULT_CATALOG)));
          assertThat(rs.getString("TABLE_SCHEM"), is(equalTo(DEFAULT_SCHEMA)));
          assertThat(rs.getString("TABLE_NAME"), is(equalTo(table.name)));
          assertThat(rs.getString("TABLE_TYPE"), is(equalTo("TABLE")));
          assertThat(rs.getString("REMARKS"), is(nullValue()));
          assertThat(rs.getString("TYPE_CAT"), is(nullValue()));
          assertThat(rs.getString("TYPE_SCHEM"), is(nullValue()));
          assertThat(rs.getString("TYPE_NAME"), is(nullValue()));
          assertThat(rs.getString("SELF_REFERENCING_COL_NAME"), is(nullValue()));
          assertThat(rs.getString("REF_GENERATION"), is(nullValue()));
        }
        assertThat(rs.next(), is(false));
      }
    }
  }
}
