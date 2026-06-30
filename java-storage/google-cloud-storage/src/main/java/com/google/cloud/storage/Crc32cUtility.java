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

class Crc32cUtility {
  private Crc32cUtility() {}

  // Castagnoli polynomial and its degree.
  private static final long CASTAGNOLI_POLY = 4812730177L;
  private static final int DEGREE = 32;

  // Table storing values of x^(2^k) mod CASTANOLI_POLY for all k < 31. This is sufficient since
  // x^(2^31) = x.
  private static final long[] X_POW_2K_TABLE = {
    2L, 4L, 16L, 256L, 65536L, 517762881L, 984302966L,
    408362264L, 1503875210L, 2862076957L, 3884826397L, 1324787473L, 621200174L, 1758783527L,
    1416537776L, 1180494764L, 648569364L, 2521473789L, 994858823L, 1728245375L, 3498467999L,
    4059169852L, 3345064394L, 2828422810L, 2429203150L, 3336788029L, 860151998L, 2102628683L,
    1033187991L, 4243778976L, 1123580069L
  };

  // Multiplies two polynomials together modulo CASTAGNOLI_POLY.
  private static int multiply(int p, int q) {
    long q64 = q;
    int result = 0;
    long topBit = (1L << DEGREE);
    for (int i = 0; i < DEGREE; i++) {
      if ((p & 1) != 0) {
        result ^= (int) q64;
      }
      q64 <<= 1; // Multiply by x.

      // If multiplying by x gave q64 a non-zero 32nd coefficient, it no longer encodes the desired
      // representative of that polynomial modulo CASTAGNOLI_POLY, so we subtract the generator.
      if ((q64 & topBit) != 0) {
        q64 ^= CASTAGNOLI_POLY;
      }
      p >>= 1;
    }
    return result;
  }

  // Given crc representing polynomial P(x), compute P(x)*x^numBits.
  private static int extendByZeros(int crc, long numBits) {
    // Begin by reversing the bits to most-significant coefficient first for comprehensibility.
    crc = Integer.reverse(crc);
    int i = 0;
    // Iterate over the binary representation of numBits, multiplying by x^(2^k) for numBits_k = 1.
    while (numBits != 0) {
      if ((numBits & 1) != 0) {
        crc = multiply(crc, (int) X_POW_2K_TABLE[i % X_POW_2K_TABLE.length]);
      }
      i += 1;
      numBits >>= 1;
    }
    crc = Integer.reverse(crc); // Return to the standard bit-order.
    return crc;
  }

  /**
   * Efficiently computes CRC32C for concat(A, B) given crc(A), crc(B) and len(B).
   *
   * @param crcA A 32-bit integer representing crc(A) with least-significant coefficient first.
   * @param crcB Same as crcA for B.
   * @param numBytesInB Length of B in bytes.
   * @return CRC32C for concat(A, B) PiperOrigin-RevId: 158626905
   */
  public static int concatCrc32c(int crcA, int crcB, long numBytesInB) {
    if (numBytesInB == 0) {
      return crcA;
    }
    return extendByZeros(crcA, 8 * numBytesInB) ^ crcB;
  }
}
