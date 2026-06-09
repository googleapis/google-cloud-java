/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.spanner.omni.opaque;

import static java.nio.charset.StandardCharsets.UTF_8;

import com.google.crypto.tink.subtle.Hkdf;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.ec.CustomNamedCurves;
import org.bouncycastle.crypto.generators.Argon2BytesGenerator;
import org.bouncycastle.crypto.params.Argon2Parameters;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;

public class OpaqueUtil {

  public static final String LOGIN_DOMAIN_SEPARATION_TAG = "Spanner-Omni-Login";
  public static final String CURVE_NAME = "secp256r1";
  public static final String AUTH_KEY_INFO = "AuthKey";
  public static final String EXPORT_KEY_INFO = "ExportKey";
  public static final String PRIVATE_KEY_INFO = "PrivateKey";
  public static final String MASKING_KEY_INFO = "MaskingKey";
  public static final String DIFFIE_HELLMAN_KEY_INFO = "OPAQUE-DeriveDiffieHellmanKeyPair";
  public static final String HMAC_SHA256 = "HmacSHA256";

  private static final int NONCE_LENGTH = 16;
  private static final int MAC_TAG_LENGTH = 16;
  private static final int EXTRACT_OUTPUT_LENGTH = 32;
  private static final int STRETCH_OUTPUT_LENGTH = 32;

  // Argon2ID parameters.
  private static final int ARGON2_ITERATION_COUNT = 3;
  private static final int ARGON2_MEMORY_LIMIT = 64 * 1024;
  private static final int ARGON2_THREADS = 4;
  private static final int ARGON2_SALT_LENGTH = 32;

  private static final SecureRandom random = new SecureRandom();

  public static byte[] nonce() {
    byte[] nonce = new byte[NONCE_LENGTH];
    random.nextBytes(nonce);
    return nonce;
  }

  public static byte[] hmacSha256(byte[] key, byte[] message) throws GeneralSecurityException {
    Mac mac = Mac.getInstance(HMAC_SHA256);
    mac.init(new SecretKeySpec(key, HMAC_SHA256));
    return mac.doFinal(message);
  }

  public static byte[] sha256(byte[] message) throws NoSuchAlgorithmException {
    MessageDigest digest = MessageDigest.getInstance("SHA-256");
    return digest.digest(message);
  }

  private static final BigInteger p =
      new BigInteger(
          "115792089210356248762697446949407573530086143415290314195533631308867097853951");
  private static final BigInteger A = p.subtract(new BigInteger("3"));
  private static final BigInteger B =
      new BigInteger("5ac635d8aa3a93e7b3ebbd55769886bc651d06b0cc53b0f63bce3c3e27d2604b", 16);
  private static final BigInteger Z = p.subtract(BigInteger.valueOf(10));

  private static byte[] expandMessageXmd(byte[] msg, byte[] DST, int lenInBytes)
      throws GeneralSecurityException {
    try {
      MessageDigest md = MessageDigest.getInstance("SHA-256");
      int bInBytes = 32;
      int ell = (lenInBytes + bInBytes - 1) / bInBytes;

      byte[] dstPrime = new byte[DST.length + 1];
      System.arraycopy(DST, 0, dstPrime, 0, DST.length);
      dstPrime[DST.length] = (byte) DST.length;

      byte[] zPad = new byte[64];
      byte[] libStr = new byte[] {(byte) (lenInBytes >> 8), (byte) (lenInBytes & 0xFF)};

      md.update(zPad);
      md.update(msg);
      md.update(libStr);
      md.update((byte) 0);
      md.update(dstPrime);
      byte[] b0 = md.digest();

      byte[] bOut = new byte[ell * bInBytes];

      md.update(b0);
      md.update((byte) 1);
      md.update(dstPrime);
      byte[] b1 = md.digest();
      System.arraycopy(b1, 0, bOut, 0, bInBytes);

      byte[] bi = b1;
      for (int i = 2; i <= ell; i++) {
        byte[] bXor = new byte[bInBytes];
        for (int j = 0; j < bInBytes; j++) {
          bXor[j] = (byte) (b0[j] ^ bi[j]);
        }
        md.update(bXor);
        md.update((byte) i);
        md.update(dstPrime);
        bi = md.digest();
        System.arraycopy(bi, 0, bOut, (i - 1) * bInBytes, bInBytes);
      }

      byte[] res = new byte[lenInBytes];
      System.arraycopy(bOut, 0, res, 0, lenInBytes);
      return res;
    } catch (Exception e) {
      throw new GeneralSecurityException("Failed to expand message", e);
    }
  }

  private static int sgn0(BigInteger x) {
    return x.testBit(0) ? 1 : 0;
  }

  private static ECPoint mapToCurveSSWU(BigInteger u, ECCurve curve) {
    BigInteger u2 = u.multiply(u).mod(p);
    BigInteger z_u2 = Z.multiply(u2).mod(p);
    BigInteger z2_u4 = z_u2.multiply(z_u2).mod(p);
    BigInteger den = z2_u4.add(z_u2).mod(p);

    BigInteger tv1;
    if (den.equals(BigInteger.ZERO)) {
      tv1 = BigInteger.ZERO;
    } else {
      tv1 = den.modInverse(p);
    }

    BigInteger x1;
    if (tv1.equals(BigInteger.ZERO)) {
      BigInteger za = Z.multiply(A).mod(p);
      x1 = B.multiply(za.modInverse(p)).mod(p);
    } else {
      BigInteger negB_div_A = B.negate().multiply(A.modInverse(p)).mod(p);
      BigInteger one_plus_tv1 = BigInteger.ONE.add(tv1).mod(p);
      x1 = negB_div_A.multiply(one_plus_tv1).mod(p);
    }

    BigInteger gx1 = x1.pow(3).add(A.multiply(x1)).add(B).mod(p);
    BigInteger x2 = z_u2.multiply(x1).mod(p);
    BigInteger gx2 = x2.pow(3).add(A.multiply(x2)).add(B).mod(p);

    BigInteger c1 = p.add(BigInteger.ONE).divide(BigInteger.valueOf(4));
    BigInteger root1 = gx1.modPow(c1, p);
    boolean isSquare = root1.multiply(root1).mod(p).equals(gx1);

    BigInteger x, y;
    if (isSquare) {
      x = x1;
      y = root1;
    } else {
      x = x2;
      y = gx2.modPow(c1, p);
    }

    if (sgn0(u) != sgn0(y)) {
      y = y.negate().mod(p);
    }

    return curve.createPoint(x, y);
  }

  public static byte[] getHashToCurve(byte[] message, byte[] domain)
      throws GeneralSecurityException {
    // Implements hash-to-curve using the Simplified SWU (SSWU) mapping.
    // This securely and uniformly maps an arbitrary string (the password) onto the elliptic curve.
    byte[] uniformBytes = expandMessageXmd(message, domain, 96);
    byte[] u0Bytes = new byte[48];
    byte[] u1Bytes = new byte[48];
    System.arraycopy(uniformBytes, 0, u0Bytes, 0, 48);
    System.arraycopy(uniformBytes, 48, u1Bytes, 0, 48);

    BigInteger u0 = new BigInteger(1, u0Bytes).mod(p);
    BigInteger u1 = new BigInteger(1, u1Bytes).mod(p);

    X9ECParameters params = CustomNamedCurves.getByName(CURVE_NAME);
    ECCurve curve = params.getCurve();

    ECPoint q0 = mapToCurveSSWU(u0, curve);
    ECPoint q1 = mapToCurveSSWU(u1, curve);

    ECPoint r = q0.add(q1).normalize();
    return r.getEncoded(true);
  }

  public static byte[] blind(byte[] password, byte[] blindScalar) throws GeneralSecurityException {
    byte[] hashedPoint = getHashToCurve(password, LOGIN_DOMAIN_SEPARATION_TAG.getBytes(UTF_8));

    X9ECParameters params = CustomNamedCurves.getByName(CURVE_NAME);
    ECCurve curve = params.getCurve();

    ECPoint point = curve.decodePoint(hashedPoint);
    BigInteger scalar = new BigInteger(1, blindScalar);

    return point.multiply(scalar).getEncoded(true);
  }

  public static byte[] expand(byte[] keyMaterial, byte[] info, int size)
      throws GeneralSecurityException {
    return Hkdf.computeHkdf(HMAC_SHA256, keyMaterial, new byte[0], info, size);
  }

  public static byte[] stretch(byte[] input) throws GeneralSecurityException {
    // Stretches the OPRF evaluation using Argon2 (a memory-hard KDF).
    // This is computationally expensive by design to protect against offline dictionary attacks.
    byte[] salt = null;
    try {
      salt = expand(input, "Stretch".getBytes(UTF_8), ARGON2_SALT_LENGTH);
      Argon2Parameters params =
          new Argon2Parameters.Builder(Argon2Parameters.ARGON2_id)
              .withSalt(salt)
              .withParallelism(ARGON2_THREADS)
              .withMemoryAsKB(ARGON2_MEMORY_LIMIT)
              .withIterations(ARGON2_ITERATION_COUNT)
              .build();
      Argon2BytesGenerator generator = new Argon2BytesGenerator();
      generator.init(params);
      byte[] result = new byte[STRETCH_OUTPUT_LENGTH];
      generator.generateBytes(input, result);
      return result;
    } finally {
      if (salt != null) {
        Arrays.fill(salt, (byte) 0);
      }
    }
  }

  public static byte[] extract(byte[] inputKeyMaterial) throws GeneralSecurityException {
    return expand(inputKeyMaterial, "Extract".getBytes(UTF_8), EXTRACT_OUTPUT_LENGTH);
  }

  public static byte[] xorBytes(byte[] a, byte[] b) {
    if (a.length != b.length) {
      throw new IllegalArgumentException("Byte arrays must have same length");
    }
    byte[] result = new byte[a.length];
    for (int i = 0; i < a.length; i++) {
      result[i] = (byte) (a[i] ^ b[i]);
    }
    return result;
  }

  public static byte[] concat(byte[]... arrays) {
    int totalLength = 0;
    for (byte[] array : arrays) {
      totalLength += array.length;
    }
    byte[] result = new byte[totalLength];
    int currentIndex = 0;
    for (byte[] array : arrays) {
      System.arraycopy(array, 0, result, currentIndex, array.length);
      currentIndex += array.length;
    }
    return result;
  }

  public static byte[] mac(byte[] key, byte[] data) throws GeneralSecurityException {
    byte[] result = hmacSha256(key, data);
    byte[] truncated = new byte[MAC_TAG_LENGTH];
    System.arraycopy(result, 0, truncated, 0, MAC_TAG_LENGTH);
    return truncated;
  }

  public static byte[] finalize(byte[] blind, byte[] evaluatedMessage)
      throws GeneralSecurityException {
    BigInteger blindBigInt = new BigInteger(1, blind);
    X9ECParameters params = CustomNamedCurves.getByName(CURVE_NAME);
    BigInteger order = params.getN();
    BigInteger inverseBlind = blindBigInt.modInverse(order);

    ECCurve curve = params.getCurve();
    ECPoint evaluatedPoint = curve.decodePoint(evaluatedMessage);

    return evaluatedPoint.multiply(inverseBlind).getEncoded(true);
  }

  public static byte[] diffieHellman(byte[] privateKey, byte[] peerPublicKey)
      throws GeneralSecurityException {
    X9ECParameters params = CustomNamedCurves.getByName(CURVE_NAME);
    ECCurve curve = params.getCurve();
    ECPoint peerPublicPoint = curve.decodePoint(peerPublicKey);
    BigInteger priv = new BigInteger(1, privateKey);
    return peerPublicPoint.multiply(priv).getEncoded(true);
  }

  public static byte[] randomOracleSha256(byte[] x, BigInteger max)
      throws GeneralSecurityException {
    // Implements a random oracle mapping using iterated SHA-256 blocks.
    // Iteratively hashes the input and a block counter to generate a large uniformly distributed
    // integer,
    // which is then reduced modulo 'max'.
    int hashOutputLength = 256;
    int outputBitLength = max.bitLength() + hashOutputLength;
    int iterCount = (int) Math.ceil((double) outputBitLength / hashOutputLength);
    if (iterCount * hashOutputLength > 130048) {
      throw new GeneralSecurityException("the domain bit length must not be greater than 130048");
    }
    int excessBitCount = (iterCount * hashOutputLength) - outputBitLength;
    BigInteger hashOutput = BigInteger.ZERO;

    for (int i = 1; i <= iterCount; i++) {
      hashOutput = hashOutput.shiftLeft(hashOutputLength);
      byte[] iBytes = new byte[] {(byte) i};

      byte[] bignumBytes = concat(iBytes, x);
      byte[] hashedString;
      try {
        hashedString = sha256(bignumBytes);
      } finally {
        Arrays.fill(bignumBytes, (byte) 0);
      }

      // Ensure hashedString is treated as a positive integer
      BigInteger newBigNum = new BigInteger(1, hashedString);

      hashOutput = hashOutput.add(newBigNum);
    }

    hashOutput = hashOutput.shiftRight(excessBitCount);
    hashOutput = hashOutput.mod(max);

    byte[] scalarBytes = new byte[hashOutputLength / 8];
    byte[] hashOutputBytes = hashOutput.toByteArray();

    // Copy into 32 byte array
    if (hashOutputBytes.length <= scalarBytes.length) {
      System.arraycopy(
          hashOutputBytes,
          0,
          scalarBytes,
          scalarBytes.length - hashOutputBytes.length,
          hashOutputBytes.length);
    } else {
      // If hashOutputBytes is 33 bytes due to sign bit
      System.arraycopy(
          hashOutputBytes,
          hashOutputBytes.length - scalarBytes.length,
          scalarBytes,
          0,
          scalarBytes.length);
    }
    return scalarBytes;
  }

  public static byte[][] generateKeyPair(byte[] deriveInput) throws GeneralSecurityException {
    X9ECParameters params = CustomNamedCurves.getByName(CURVE_NAME);
    BigInteger order = params.getN();
    byte[] privateKeyBytes = randomOracleSha256(deriveInput, order);
    BigInteger privateKey = new BigInteger(1, privateKeyBytes);

    if (privateKey.equals(BigInteger.ZERO)) {
      privateKey = BigInteger.ONE;
      privateKeyBytes = new byte[32];
      privateKeyBytes[31] = 1;
    }
    ECPoint publicKey = params.getG().multiply(privateKey);
    return new byte[][] {privateKeyBytes, publicKey.getEncoded(true)};
  }
}
