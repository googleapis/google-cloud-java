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

import static java.time.ZoneId.systemDefault;

import com.google.common.collect.ImmutableList;
import java.sql.JDBCType;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Date;
import javax.annotation.Nonnull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.jdbc.core.mapping.JdbcValue;
import org.springframework.data.relational.core.dialect.AnsiDialect;
import org.springframework.data.relational.core.dialect.LimitClause;
import org.springframework.data.relational.core.sql.IdentifierProcessing;
import org.springframework.data.relational.core.sql.IdentifierProcessing.LetterCasing;
import org.springframework.data.relational.core.sql.IdentifierProcessing.Quoting;

/**
 * The Spanner GoogleSQL dialect is relatively close to the standard ANSI dialect. We therefore
 * create a custom dialect based on ANSI, but with a few overrides.
 */
public class SpannerDialect extends AnsiDialect {
  public static final SpannerDialect INSTANCE = new SpannerDialect();

  /** Spanner uses backticks for identifier quoting. */
  private static final Quoting QUOTING = new Quoting("`");

  /** Spanner supports mixed-case identifiers. */
  private static final IdentifierProcessing IDENTIFIER_PROCESSING =
      IdentifierProcessing.create(QUOTING, LetterCasing.AS_IS);

  private static final LimitClause LIMIT_CLAUSE =
      new LimitClause() {
        private static final long DEFAULT_LIMIT_FOR_OFFSET = Long.MAX_VALUE / 2;

        @Nonnull
        @Override
        public String getLimit(long limit) {
          return String.format("LIMIT %d", limit);
        }

        @Nonnull
        @Override
        public String getOffset(long offset) {
          // Spanner does not support an OFFSET clause without a LIMIT clause.
          return String.format("LIMIT %d OFFSET %d", DEFAULT_LIMIT_FOR_OFFSET, offset);
        }

        @Nonnull
        @Override
        public String getLimitOffset(long limit, long offset) {
          return String.format("LIMIT %d OFFSET %d", limit, offset);
        }

        @Nonnull
        @Override
        public Position getClausePosition() {
          return Position.AFTER_ORDER_BY;
        }
      };

  private SpannerDialect() {}

  @Nonnull
  @Override
  public IdentifierProcessing getIdentifierProcessing() {
    return IDENTIFIER_PROCESSING;
  }

  @Nonnull
  @Override
  public LimitClause limit() {
    return LIMIT_CLAUSE;
  }

  @Nonnull
  @Override
  public Collection<Object> getConverters() {
    return ImmutableList.of(
        TimestampAtUtcToOffsetDateTimeConverter.INSTANCE,
        OffsetDateTimeToTimestampJdbcValueConverter.INSTANCE,
        LocalDateTimeToDateConverter.INSTANCE);
  }

  @ReadingConverter
  enum TimestampAtUtcToOffsetDateTimeConverter implements Converter<Timestamp, OffsetDateTime> {
    INSTANCE;

    private static final ZoneId UTC = ZoneId.of("UTC");

    @Override
    public OffsetDateTime convert(Timestamp timestamp) {
      return OffsetDateTime.ofInstant(timestamp.toInstant(), UTC);
    }
  }

  @WritingConverter
  enum OffsetDateTimeToTimestampJdbcValueConverter implements Converter<OffsetDateTime, JdbcValue> {
    INSTANCE;

    @Override
    public JdbcValue convert(@Nonnull OffsetDateTime source) {
      return JdbcValue.of(source, JDBCType.TIMESTAMP);
    }
  }

  @ReadingConverter
  enum LocalDateTimeToDateConverter implements Converter<LocalDateTime, Date> {
    INSTANCE;

    @Nonnull
    @Override
    public Date convert(LocalDateTime source) {
      return Date.from(source.atZone(systemDefault()).toInstant());
    }
  }
}
