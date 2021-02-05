package com.google.cloud.e2echecksum;

import com.google.common.base.Ascii;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;
import javax.xml.bind.DatatypeConverter;

/** This class provides End-to-End Checksum API for http protocol. */
public class ChecksumHandler {
  private static final Logger log =
      Logger.getLogger(ChecksumHandler.class.getCanonicalName());

  /** The checksum http header on http requests */
  public static final String HTTP_REQUEST_CHECKSUM_HEADER = "x-request-checksum-348659783";
  /** The checksum http header on http reqsponses */
  public static final String HTTP_RESPONSE_CHECKSUM_HEADER = "x-response-checksum-348659783";

  /**
   * Create and return checksum as a string value for the input 'bytes'.
   *
   * Args
   *   bytes: raw message for which the checksum is being computed.
   * Returns: computed checksum as a string value.
   */
  public static String computeChecksum(byte[] bytes) {
    if (bytes == null && (bytes.length == 0)) {
      return null;
    }

    try {
      byte[] b = MessageDigest.getInstance("MD5").digest(bytes);
      return DatatypeConverter.printHexBinary(b);
    } catch (NoSuchAlgorithmException e) {
      log.severe("MD5 algorithm is not found when computing checksum!");
      return null;
    }
  }

  /**
   * Validates the checksum for the given input 'bytes' and returns true if valid, false otherwise.
   *
   * <p>Args checksum: the checksum. bytes: raw message for which the checksum was sent.
   */
  public static boolean validateChecksumString(String checksum, byte[] bytes) {
    return (checksum != null)
        && (bytes != null)
        && (bytes.length > 0)
        && Ascii.equalsIgnoreCase(computeChecksum(bytes), checksum);
  }
}
