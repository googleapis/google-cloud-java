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

package com.google.cloud.storage;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.TextFormat;
import com.google.storage.v2.BidiReadObjectResponse;
import com.google.storage.v2.BidiWriteObjectRequest;
import com.google.storage.v2.BucketAccessControl;
import com.google.storage.v2.ChecksummedData;
import com.google.storage.v2.ObjectAccessControl;
import com.google.storage.v2.ObjectRangeData;
import com.google.storage.v2.ReadObjectRequest;
import com.google.storage.v2.ReadObjectResponse;
import com.google.storage.v2.WriteObjectRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.function.Predicate;
import org.checkerframework.checker.nullness.qual.NonNull;

final class StorageV2ProtoUtils {

  private static final String VALIDATION_TEMPLATE =
      "offset >= 0 && limit >= 0 (%s >= 0 && %s >= 0)";

  private StorageV2ProtoUtils() {}

  // TODO: can we eliminate this method all together?
  @NonNull
  static ReadObjectRequest seekReadObjectRequest(
      @NonNull ReadObjectRequest request, @NonNull ByteRangeSpec byteRangeSpec) {

    long offset = byteRangeSpec.beginOffset();
    long limit = byteRangeSpec.length();
    ReadObjectRequest req = request;

    boolean setOffset = (offset > 0 && offset != req.getReadOffset());
    boolean setLimit = (limit < ByteRangeSpec.EFFECTIVE_INFINITY && limit != req.getReadLimit());
    if (setOffset || setLimit) {
      req = byteRangeSpec.seekReadObjectRequest(req.toBuilder()).build();
    }
    return req;
  }

  @FunctionalInterface
  interface MsgFmt extends Function<MessageOrBuilder, String> {}

  @NonNull
  public static String fmtProto(@NonNull Object obj) {
    return fmtProtoWithFmt(obj, TextFormat.printer()::shortDebugString);
  }

  @NonNull
  public static String fmtProtoWithFmt(@NonNull Object obj, MsgFmt fmt) {
    if (obj instanceof WriteObjectRequest) {
      return fmtProtoWithFmt((WriteObjectRequest) obj, fmt);
    } else if (obj instanceof BidiWriteObjectRequest) {
      return fmtProtoWithFmt((BidiWriteObjectRequest) obj, fmt);
    } else if (obj instanceof ReadObjectResponse) {
      return fmtProtoWithFmt((ReadObjectResponse) obj, fmt);
    } else if (obj instanceof BidiReadObjectResponse) {
      return fmtProtoWithFmt((BidiReadObjectResponse) obj, fmt);
    } else if (obj instanceof ChecksummedData) {
      return fmtProtoWithFmt((ChecksummedData) obj, fmt);
    } else if (obj instanceof MessageOrBuilder) {
      return fmt.apply((MessageOrBuilder) obj);
    } else {
      return obj.toString();
    }
  }

  @NonNull
  private static String fmtProtoWithFmt(ChecksummedData data, MsgFmt fmt) {
    ByteString content = data.getContent();
    if (content.size() > 20) {
      ChecksummedData.Builder b = data.toBuilder();
      ByteString trim = snipBytes(content);
      b.setContent(trim);

      return fmt.apply(b.build());
    }
    return fmt.apply(data);
  }

  @NonNull
  private static String fmtProtoWithFmt(@NonNull WriteObjectRequest msg, MsgFmt fmt) {
    if (msg.hasChecksummedData()) {
      ByteString content = msg.getChecksummedData().getContent();
      if (content.size() > 20) {
        WriteObjectRequest.Builder b = msg.toBuilder();
        ByteString trim = snipBytes(content);
        b.getChecksummedDataBuilder().setContent(trim);

        return fmt.apply(b.build());
      }
    }
    return fmt.apply(msg);
  }

  @NonNull
  private static String fmtProtoWithFmt(@NonNull BidiWriteObjectRequest msg, MsgFmt fmt) {
    if (msg.hasChecksummedData()) {
      ByteString content = msg.getChecksummedData().getContent();
      if (content.size() > 20) {
        BidiWriteObjectRequest.Builder b = msg.toBuilder();
        ByteString trim = snipBytes(content);
        b.getChecksummedDataBuilder().setContent(trim);

        return fmt.apply(b.build());
      }
    }
    return fmt.apply(msg);
  }

  @NonNull
  private static String fmtProtoWithFmt(@NonNull ReadObjectResponse msg, MsgFmt fmt) {
    if (msg.hasChecksummedData()) {
      ByteString content = msg.getChecksummedData().getContent();
      if (content.size() > 20) {
        ReadObjectResponse.Builder b = msg.toBuilder();
        ByteString trim = snipBytes(content);
        b.getChecksummedDataBuilder().setContent(trim);

        return fmt.apply(b.build());
      }
    }
    return fmt.apply(msg);
  }

  @NonNull
  private static String fmtProtoWithFmt(@NonNull BidiReadObjectResponse msg, MsgFmt fmt) {
    List<ObjectRangeData> rangeData = msg.getObjectDataRangesList();
    if (!rangeData.isEmpty()) {
      List<ObjectRangeData> snips = new ArrayList<>();
      for (ObjectRangeData rd : rangeData) {
        if (rd.hasChecksummedData()) {
          ByteString content = rd.getChecksummedData().getContent();
          if (content.size() > 20) {
            ObjectRangeData.Builder b = rd.toBuilder();
            ByteString trim = snipBytes(content);
            b.getChecksummedDataBuilder().setContent(trim);
            snips.add(b.build());
          } else {
            snips.add(rd);
          }
        }
      }
      BidiReadObjectResponse snipped =
          msg.toBuilder().clearObjectDataRanges().addAllObjectDataRanges(snips).build();
      return fmt.apply(snipped);
    }
    return fmt.apply(msg);
  }

  private static ByteString snipBytes(ByteString content) {
    ByteString snip =
        ByteString.copyFromUtf8(java.lang.String.format(Locale.US, "<snip (%d)>", content.size()));
    return content.substring(0, 20).concat(snip);
  }

  /**
   * When evaluating an {@link ObjectAccessControl} entity, look at both {@code entity} (generally
   * project number format) and {@code entity_alt} (generally project id format).
   */
  static Predicate<ObjectAccessControl> objectAclEntityOrAltEq(String s) {
    return oAcl -> oAcl.getEntity().equals(s) || oAcl.getEntityAlt().equals(s);
  }

  /**
   * When evaluating an {@link BucketAccessControl} entity, look at both {@code entity} (generally
   * project number format) and {@code entity_alt} (generally project id format).
   */
  static Predicate<BucketAccessControl> bucketAclEntityOrAltEq(String s) {
    return oAcl -> oAcl.getEntity().equals(s) || oAcl.getEntityAlt().equals(s);
  }
}
