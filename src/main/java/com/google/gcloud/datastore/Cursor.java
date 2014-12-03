package com.google.gcloud.datastore;

import static com.google.api.client.repackaged.com.google.common.base.Preconditions.checkNotNull;
import static java.nio.charset.StandardCharsets.UTF_8;

import com.google.protobuf.ByteString;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;

public final class Cursor implements Serializable {

  private static final long serialVersionUID = -1423744878777486541L;

  private byte[] bytes;

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
    return toPb().toString();
  }

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
