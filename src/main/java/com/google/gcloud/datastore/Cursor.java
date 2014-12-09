package com.google.gcloud.datastore;

import static com.google.common.base.Preconditions.checkNotNull;
import static java.nio.charset.StandardCharsets.UTF_8;

import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.protobuf.ByteString;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;

/**
 * A Google Cloud Datastore cursor.
 * The cursor can be used to as a starting point or an ending point for a {@link Query}
 */
public final class Cursor implements Serializable {

  private static final long serialVersionUID = -1423744878777486541L;

  private final byte[] bytes;

  public Cursor(byte[] bytes) {
    this.bytes = checkNotNull(bytes);
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(bytes);
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Cursor)) {
      return false;
    }

    return Arrays.equals(bytes, ((Cursor) obj).bytes);
  }

  @Override
  public String toString() {
    ToStringHelper toStringHelper = MoreObjects.toStringHelper(this);
    StringBuilder stBuilder = new StringBuilder();
    for (byte b : bytes) {
      stBuilder.append(String.format("%02x", b));
    }
    return toStringHelper.add("bytes", stBuilder.toString()).toString();
  }

  /**
   * Returns the cursor in an encoded form that can be used as part of a URL.
   */
  public String toUrlSafe() {
    try {
      return URLEncoder.encode(toString(), UTF_8.name());
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException("Unxpeced encoding exception", e);
    }
  }

  ByteString toPb() {
    return ByteString.copyFrom(bytes);
  }

  /**
   * Create a {@code Cursor} given its URL safe encoded form.
   */
  public static Cursor fromUrlSafe(String urlSafe) {
    try {
      String utf8Str = URLDecoder.decode(urlSafe, UTF_8.name());
      ByteString byteString = ByteString.copyFromUtf8(utf8Str);
      return fromPb(byteString);
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException("Unxpeced decoding exception", e);
    }
  }

  private static Cursor fromPb(ByteString byteString) {
    return new Cursor(byteString.toByteArray());
  }
}
