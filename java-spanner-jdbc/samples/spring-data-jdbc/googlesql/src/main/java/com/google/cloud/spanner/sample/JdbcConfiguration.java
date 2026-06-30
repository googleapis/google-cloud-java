/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.spanner.sample;

import java.sql.JDBCType;
import java.sql.SQLType;
import java.time.LocalDate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jdbc.core.convert.DefaultJdbcTypeFactory;
import org.springframework.data.jdbc.core.convert.JdbcConverter;
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;
import org.springframework.data.jdbc.core.convert.MappingJdbcConverter;
import org.springframework.data.jdbc.core.convert.RelationResolver;
import org.springframework.data.jdbc.core.dialect.JdbcArrayColumns;
import org.springframework.data.jdbc.core.dialect.JdbcDialect;
import org.springframework.data.jdbc.core.mapping.JdbcMappingContext;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.relational.core.dialect.Dialect;
import org.springframework.data.relational.core.mapping.RelationalPersistentProperty;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;

/**
 * This configuration class is registered as depending on OpenTelemetry, as the JDBC driver uses the
 * globally registered OpenTelemetry instance. It also overrides the default jdbcConverter
 * implementation to map LocalDate to the JDBC type DATE (the default implementation maps LocalDate
 * to TIMESTAMP).
 */
@DependsOn("openTelemetry")
@Configuration
public class JdbcConfiguration extends AbstractJdbcConfiguration {

  @Bean
  @Override
  public JdbcConverter jdbcConverter(
      JdbcMappingContext mappingContext,
      NamedParameterJdbcOperations operations,
      @Lazy RelationResolver relationResolver,
      JdbcCustomConversions conversions,
      Dialect dialect) {
    JdbcArrayColumns arrayColumns =
        dialect instanceof JdbcDialect
            ? ((JdbcDialect) dialect).getArraySupport()
            : JdbcArrayColumns.DefaultSupport.INSTANCE;
    DefaultJdbcTypeFactory jdbcTypeFactory =
        new DefaultJdbcTypeFactory(operations.getJdbcOperations(), arrayColumns);
    return new MappingJdbcConverter(
        mappingContext, relationResolver, conversions, jdbcTypeFactory) {
      @Override
      public SQLType getTargetSqlType(RelationalPersistentProperty property) {
        if (property.getActualType().equals(LocalDate.class)) {
          return JDBCType.DATE;
        }
        return super.getTargetSqlType(property);
      }
    };
  }
}
