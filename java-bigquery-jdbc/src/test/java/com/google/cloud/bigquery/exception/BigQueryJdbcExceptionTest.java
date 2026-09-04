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

package com.google.cloud.bigquery.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.cloud.bigquery.BigQueryException;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BigQueryJdbcExceptionTest {

  @FunctionalInterface
  interface ExceptionCreator {
    Throwable create(String message, Throwable cause);
  }

  static Stream<Arguments> exceptionProvider() {
    return Stream.of(
        Arguments.of(
            (ExceptionCreator)
                (msg, cause) -> new BigQueryJdbcException(msg, (BigQueryException) cause)),
        Arguments.of((ExceptionCreator) BigQueryJdbcException::new),
        Arguments.of((ExceptionCreator) BigQueryJdbcRuntimeException::new),
        Arguments.of((ExceptionCreator) BigQueryConversionException::new),
        Arguments.of(
            (ExceptionCreator)
                (msg, cause) -> new BigQueryJdbcCoercionException((Exception) cause)),
        Arguments.of(
            (ExceptionCreator)
                (msg, cause) ->
                    new BigQueryJdbcSqlSyntaxErrorException(msg, (BigQueryException) cause)));
  }

  @ParameterizedTest
  @MethodSource("exceptionProvider")
  public void testExceptionMessageFormatting(ExceptionCreator creator) {
    String message = "Custom error message";
    Throwable cause = new BigQueryException(500, "Underlying error");

    Throwable ex = creator.create(message, cause);

    String expectedPrefix =
        ex instanceof BigQueryJdbcCoercionException ? "Coercion error" : message;
    String expectedMessage = expectedPrefix + "\n" + cause.getMessage();

    assertEquals(expectedMessage, ex.getMessage());
    assertEquals(cause, ex.getCause());
  }

  @Test
  public void testException_withCauseHavingNullMessage() {
    String message = "Custom error message";
    Throwable cause = new RuntimeException(); // Null message

    BigQueryJdbcException ex = new BigQueryJdbcException(message, cause);

    String expectedMessage = message + "\n" + cause.toString();
    assertEquals(expectedMessage, ex.getMessage());
  }
}
