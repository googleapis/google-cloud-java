/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.spanner.connection;

import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.common.base.Strings;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import com.google.spanner.v1.DirectedReadOptions;

public class DirectedReadOptionsUtil {
  static class DirectedReadOptionsConverter
      implements ClientSideStatementValueConverter<DirectedReadOptions> {
    static DirectedReadOptionsConverter INSTANCE = new DirectedReadOptionsConverter();

    @Override
    public Class<DirectedReadOptions> getParameterClass() {
      return DirectedReadOptions.class;
    }

    @Override
    public DirectedReadOptions convert(String value) {
      try {
        return parse(value);
      } catch (Throwable ignore) {
        // ClientSideStatementValueConverters should return null if the value cannot be converted.
        return null;
      }
    }
  }

  /**
   * Generates a valid JSON string for the given {@link DirectedReadOptions} that can be used with
   * the JDBC driver.
   */
  public static String toString(DirectedReadOptions directedReadOptions) {
    if (directedReadOptions == null
        || DirectedReadOptions.getDefaultInstance().equals(directedReadOptions)) {
      return "";
    }
    try {
      return JsonFormat.printer().omittingInsignificantWhitespace().print(directedReadOptions);
    } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
      throw SpannerExceptionFactory.asSpannerException(invalidProtocolBufferException);
    }
  }

  static DirectedReadOptions parse(String json) {
    if (Strings.isNullOrEmpty(json)) {
      return DirectedReadOptions.getDefaultInstance();
    }
    DirectedReadOptions.Builder builder = DirectedReadOptions.newBuilder();
    try {
      JsonFormat.parser().merge(json, builder);
      return builder.build();
    } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
      throw SpannerExceptionFactory.asSpannerException(invalidProtocolBufferException);
    }
  }
}
