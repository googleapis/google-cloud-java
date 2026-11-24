/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.mockStatic;

import com.google.cloud.bigquery.exception.BigQueryJdbcException;
import com.google.cloud.bigquery.exception.BigQueryJdbcRuntimeException;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class DataSourceTest {

  @Test
  public void testWrapperMethods() throws SQLException {
    DataSource dataSource = new DataSource();
    assertTrue(dataSource.isWrapperFor(javax.sql.DataSource.class));
    assertTrue(dataSource.isWrapperFor(DataSource.class));
    assertFalse(dataSource.isWrapperFor(java.sql.Connection.class));
    assertFalse(dataSource.isWrapperFor(null));

    Object unwrappedDs = dataSource.unwrap(javax.sql.DataSource.class);
    assertSame(unwrappedDs, dataSource);

    Object unwrappedImpl = dataSource.unwrap(DataSource.class);
    assertSame(unwrappedImpl, dataSource);

    BigQueryJdbcException e =
        assertThrows(
            BigQueryJdbcException.class, () -> dataSource.unwrap(java.sql.Connection.class));
    assertTrue(e.getMessage().contains("Cannot unwrap to java.sql.Connection"));
  }

  @Test
  public void testMetadataFetchThreadCountValidation() {
    DataSource dataSource = new DataSource();

    // Setting positive values should succeed
    dataSource.setMetadataFetchThreadCount(1);
    assertEquals(1, dataSource.getMetadataFetchThreadCount());

    dataSource.setMetadataFetchThreadCount(5);
    assertEquals(5, dataSource.getMetadataFetchThreadCount());

    dataSource.setMetadataFetchThreadCount(null); // Should fallback to default
    assertEquals(
        BigQueryJdbcUrlUtility.DEFAULT_METADATA_FETCH_THREAD_COUNT_VALUE,
        dataSource.getMetadataFetchThreadCount());

    // Setting 0 or negative should throw BigQueryJdbcRuntimeException
    BigQueryJdbcRuntimeException ex0 =
        assertThrows(
            BigQueryJdbcRuntimeException.class, () -> dataSource.setMetadataFetchThreadCount(0));
    assertTrue(
        ex0.getMessage()
            .contains(
                "Invalid value for MetaDataFetchThreadCount. It must be greater than or equal to 1"));

    BigQueryJdbcRuntimeException exNeg =
        assertThrows(
            BigQueryJdbcRuntimeException.class, () -> dataSource.setMetadataFetchThreadCount(-5));
    assertTrue(
        exNeg
            .getMessage()
            .contains(
                "Invalid value for MetaDataFetchThreadCount. It must be greater than or equal to 1"));
  }

  @Test
  public void testUniverseDomainAndByoidTokenUriResolution() {
    try (MockedStatic<BigQueryJdbcUrlUtility> urlUtil =
        mockStatic(BigQueryJdbcUrlUtility.class, CALLS_REAL_METHODS)) {
      // 1. Neither URL/setter nor GOOGLE_CLOUD_UNIVERSE_DOMAIN is set -> null universeDomain
      urlUtil.when(BigQueryJdbcUrlUtility::getEnvUniverseDomain).thenReturn(null);
      DataSource ds = new DataSource();
      assertNull(ds.getUniverseDomain());
      assertNull(ds.getExplicitUniverseDomain());
      assertEquals("https://sts.googleapis.com/v1/token", ds.getByoidTokenUri());

      // 2. GOOGLE_CLOUD_UNIVERSE_DOMAIN is set, explicit universeDomain is omitted
      urlUtil.when(BigQueryJdbcUrlUtility::getEnvUniverseDomain).thenReturn("apis-tpczero.goog");
      assertEquals("apis-tpczero.goog", ds.getUniverseDomain());
      assertNull(ds.getExplicitUniverseDomain());
      assertEquals("https://sts.apis-tpczero.goog/v1/token", ds.getByoidTokenUri());

      // 3. Explicit universeDomain takes precedence over GOOGLE_CLOUD_UNIVERSE_DOMAIN
      ds.setUniverseDomain("explicit-tpc.goog");
      assertEquals("explicit-tpc.goog", ds.getUniverseDomain());
      assertEquals("explicit-tpc.goog", ds.getExplicitUniverseDomain());
      assertEquals("https://sts.explicit-tpc.goog/v1/token", ds.getByoidTokenUri());

      // 4. Explicit BYOID_TokenUri takes precedence over universeDomain derivation
      ds.setByoidTokenUri("https://custom-sts.internal/v1/token");
      assertEquals("https://custom-sts.internal/v1/token", ds.getByoidTokenUri());
    }
  }

  @Test
  public void testNormalizeUniverseDomain() {
    assertNull(BigQueryJdbcUrlUtility.normalizeUniverseDomain(null));
    assertNull(BigQueryJdbcUrlUtility.normalizeUniverseDomain(""));
    assertNull(BigQueryJdbcUrlUtility.normalizeUniverseDomain("   "));
    assertEquals(
        "apis-tpczero.goog", BigQueryJdbcUrlUtility.normalizeUniverseDomain(" apis-tpczero.goog "));
  }
}
