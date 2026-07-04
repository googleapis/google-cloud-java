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

package com.google.cloud.spanner.omni;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Arrays;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.ec.CustomNamedCurves;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class OpaqueUtilTest {

  @Test
  public void testNonce() {
    byte[] nonce1 = OpaqueUtil.nonce();
    byte[] nonce2 = OpaqueUtil.nonce();
    assertEquals(32, nonce1.length);
    assertEquals(32, nonce2.length);
    assertTrue(!Arrays.equals(nonce1, nonce2));
  }

  @Test
  public void testConcat() {
    byte[] a = new byte[] {1, 2};
    byte[] b = new byte[] {3, 4, 5};
    byte[] result = OpaqueUtil.concat(a, b);
    assertArrayEquals(new byte[] {1, 2, 3, 4, 5}, result);
  }

  @Test
  public void testRandomOracleSha256() throws Exception {
    BigInteger max = new BigInteger(String.valueOf(Long.MAX_VALUE));
    byte[][] inputs =
        new byte[][] {
          "key".getBytes(StandardCharsets.UTF_8),
          "key2".getBytes(StandardCharsets.UTF_8),
          new byte[] {97, 97, 98, 99, 100, 101}
        };
    for (byte[] input : inputs) {
      byte[] expectedOutput = OpaqueUtil.randomOracleSha256(input, max);
      for (int i = 0; i < 1000; i++) {
        byte[] output = OpaqueUtil.randomOracleSha256(input, max);
        assertArrayEquals(expectedOutput, output);
        assertEquals(32, output.length);
      }
    }
  }

  @Test
  public void testMac() throws Exception {
    byte[][] keys =
        new byte[][] {
          "key".getBytes(StandardCharsets.UTF_8),
          "key".getBytes(StandardCharsets.UTF_8),
          new byte[] {97, 97, 98, 99, 100, 101}
        };
    byte[][] data =
        new byte[][] {
          "data".getBytes(StandardCharsets.UTF_8),
          "data2".getBytes(StandardCharsets.UTF_8),
          new byte[] {102, 103, 104, 105, 106, 107}
        };
    for (int i = 0; i < keys.length; i++) {
      byte[] mac1 = OpaqueUtil.mac(keys[i], data[i]);
      byte[] mac2 = OpaqueUtil.mac(keys[i], data[i]);
      assertArrayEquals(mac1, mac2);
      assertEquals(32, mac1.length);
    }
  }

  @Test
  public void testXorBytes() {
    byte[][] inputs =
        new byte[][] {
          "abc".getBytes(StandardCharsets.UTF_8),
          new byte[] {97, 97, 98, 99, 100, 101},
          new byte[] {97, 97, 98, 99, 100, 101},
          new byte[0]
        };
    byte[][] masks =
        new byte[][] {
          "def".getBytes(StandardCharsets.UTF_8),
          new byte[] {102, 103, 104, 105, 106, 107},
          new byte[] {0, 0, 0, 0, 0, 0},
          new byte[0]
        };
    for (int i = 0; i < inputs.length; i++) {
      byte[] xored = OpaqueUtil.xorBytes(inputs[i], masks[i]);
      assertEquals(inputs[i].length, xored.length);
      byte[] original = OpaqueUtil.xorBytes(xored, masks[i]);
      assertArrayEquals(inputs[i], original);
    }

    try {
      OpaqueUtil.xorBytes(
          "abc".getBytes(StandardCharsets.UTF_8), "defghi".getBytes(StandardCharsets.UTF_8));
      fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // Expected
    }
  }

  @Test
  public void testDeriveKeyPair() throws Exception {
    byte[][] seeds =
        new byte[][] {
          "seed".getBytes(StandardCharsets.UTF_8),
          "seed2".getBytes(StandardCharsets.UTF_8),
          "seed".getBytes(StandardCharsets.UTF_8),
          "seed".getBytes(StandardCharsets.UTF_8),
          "seed".getBytes(StandardCharsets.UTF_8)
        };
    byte[][] infos =
        new byte[][] {
          "info".getBytes(StandardCharsets.UTF_8),
          "info".getBytes(StandardCharsets.UTF_8),
          "info2".getBytes(StandardCharsets.UTF_8),
          "info2".getBytes(StandardCharsets.UTF_8),
          "info2".getBytes(StandardCharsets.UTF_8)
        };
    byte[][] seeds2 =
        new byte[][] {
          "seed".getBytes(StandardCharsets.UTF_8),
          "seed2".getBytes(StandardCharsets.UTF_8),
          "seed".getBytes(StandardCharsets.UTF_8),
          "different".getBytes(StandardCharsets.UTF_8),
          "seed".getBytes(StandardCharsets.UTF_8)
        };
    byte[][] infos2 =
        new byte[][] {
          "info".getBytes(StandardCharsets.UTF_8),
          "info".getBytes(StandardCharsets.UTF_8),
          "info2".getBytes(StandardCharsets.UTF_8),
          "info2".getBytes(StandardCharsets.UTF_8),
          "info1".getBytes(StandardCharsets.UTF_8)
        };
    boolean[] wantDifferent = new boolean[] {false, false, false, true, true};

    for (int i = 0; i < seeds.length; i++) {
      byte[] deriveInput1 = OpaqueUtil.expand(seeds[i], infos[i], 32);
      byte[][] keyPair1 = OpaqueUtil.generateKeyPair(deriveInput1);

      byte[] deriveInput2 = OpaqueUtil.expand(seeds2[i], infos2[i], 32);
      byte[][] keyPair2 = OpaqueUtil.generateKeyPair(deriveInput2);

      if (wantDifferent[i]) {
        assertTrue(!Arrays.equals(keyPair1[0], keyPair2[0]));
        assertTrue(!Arrays.equals(keyPair1[1], keyPair2[1]));
      } else {
        assertArrayEquals(keyPair1[0], keyPair2[0]);
        assertArrayEquals(keyPair1[1], keyPair2[1]);
      }
    }
  }

  @Test
  public void testStretch() throws Exception {
    byte[] longInput = new byte[1024];
    for (int i = 0; i < longInput.length; i++) {
      longInput[i] = (byte) i;
    }

    byte[][] inputs =
        new byte[][] {
          new byte[0],
          "input".getBytes(StandardCharsets.UTF_8),
          new byte[] {97, 97, 98, 99, 100, 101},
          longInput
        };

    byte[][] expectedOutputs =
        new byte[][] {
          new byte[] {
            58,
            79,
            24,
            (byte) 130,
            103,
            (byte) 150,
            112,
            31,
            (byte) 225,
            5,
            114,
            28,
            (byte) 242,
            (byte) 137,
            98,
            117,
            (byte) 167,
            104,
            (byte) 218,
            (byte) 239,
            25,
            (byte) 212,
            74,
            (byte) 212,
            113,
            (byte) 147,
            (byte) 148,
            46,
            59,
            (byte) 221,
            (byte) 252,
            (byte) 143
          },
          new byte[] {
            (byte) 206,
            (byte) 152,
            (byte) 222,
            (byte) 237,
            64,
            101,
            (byte) 230,
            (byte) 180,
            (byte) 153,
            2,
            (byte) 150,
            (byte) 231,
            (byte) 211,
            0,
            4,
            (byte) 139,
            (byte) 220,
            (byte) 255,
            41,
            (byte) 134,
            (byte) 215,
            (byte) 211,
            28,
            84,
            55,
            (byte) 192,
            (byte) 152,
            (byte) 188,
            125,
            (byte) 204,
            (byte) 217,
            33
          },
          new byte[] {
            (byte) 218,
            (byte) 137,
            (byte) 175,
            71,
            100,
            (byte) 236,
            (byte) 151,
            (byte) 150,
            23,
            63,
            116,
            6,
            (byte) 250,
            111,
            (byte) 152,
            19,
            101,
            6,
            8,
            87,
            98,
            (byte) 215,
            110,
            90,
            46,
            106,
            79,
            (byte) 225,
            89,
            (byte) 247,
            115,
            104
          },
          new byte[] {
            40,
            (byte) 142,
            (byte) 197,
            (byte) 252,
            20,
            122,
            126,
            93,
            (byte) 205,
            3,
            122,
            (byte) 181,
            (byte) 159,
            (byte) 241,
            108,
            (byte) 153,
            (byte) 139,
            (byte) 172,
            35,
            (byte) 182,
            9,
            59,
            (byte) 165,
            48,
            48,
            29,
            9,
            (byte) 169,
            99,
            (byte) 186,
            (byte) 242,
            97
          }
        };

    com.google.cloud.spanner.omni.Authentication.HashParameters hashParams =
        com.google.cloud.spanner.omni.Authentication.HashParameters.newBuilder()
            .setArgon2IdParameters(
                com.google.cloud.spanner.omni.Authentication.HashParameters.Argon2IdParameters
                    .newBuilder()
                    .setIterationCount(3)
                    .setMemoryUsage(65536)
                    .setParallelism(4)
                    .setHashSize(32)
                    .build())
            .build();

    for (int i = 0; i < inputs.length; i++) {
      byte[] stretched = OpaqueUtil.stretch(inputs[i], hashParams);
      assertEquals(32, stretched.length);
      assertArrayEquals("Failed on index " + i, expectedOutputs[i], stretched);
    }
  }

  @Test
  public void testDiffieHellman() throws Exception {
    byte[][] serverSeeds =
        new byte[][] {
          new byte[0],
          "server-seed".getBytes(StandardCharsets.UTF_8),
          "server-seed2".getBytes(StandardCharsets.UTF_8),
          "no-need-to-be-the-same-length".getBytes(StandardCharsets.UTF_8)
        };
    byte[][] clientSeeds =
        new byte[][] {
          new byte[0],
          "client-seed".getBytes(StandardCharsets.UTF_8),
          "client-seed2".getBytes(StandardCharsets.UTF_8),
          "im-a-shorter-seed".getBytes(StandardCharsets.UTF_8)
        };

    for (int i = 0; i < serverSeeds.length; i++) {
      byte[] serverDeriveInput =
          OpaqueUtil.expand(
              serverSeeds[i],
              "OPAQUE-DeriveDiffieHellmanKeyPair".getBytes(StandardCharsets.UTF_8),
              32);
      byte[][] serverKeyPair = OpaqueUtil.generateKeyPair(serverDeriveInput);

      byte[] clientDeriveInput =
          OpaqueUtil.expand(
              clientSeeds[i],
              "OPAQUE-DeriveDiffieHellmanKeyPair".getBytes(StandardCharsets.UTF_8),
              32);
      byte[][] clientKeyPair = OpaqueUtil.generateKeyPair(clientDeriveInput);

      byte[] serverSharedSecret = OpaqueUtil.diffieHellman(serverKeyPair[0], clientKeyPair[1]);
      byte[] clientSharedSecret = OpaqueUtil.diffieHellman(clientKeyPair[0], serverKeyPair[1]);

      assertArrayEquals(serverSharedSecret, clientSharedSecret);
    }
  }

  @Test
  public void testExtract() throws Exception {
    byte[] longInput = new byte[1024];
    for (int i = 0; i < longInput.length; i++) {
      longInput[i] = (byte) i;
    }

    byte[][] inputs =
        new byte[][] {
          new byte[0],
          "input".getBytes(StandardCharsets.UTF_8),
          new byte[] {97, 97, 98, 99, 100, 101},
          longInput
        };

    byte[][] expectedOutputs =
        new byte[][] {
          new byte[] {
            99,
            (byte) 252,
            (byte) 241,
            111,
            84,
            (byte) 209,
            (byte) 178,
            (byte) 181,
            88,
            96,
            91,
            (byte) 194,
            (byte) 149,
            79,
            (byte) 240,
            (byte) 143,
            (byte) 252,
            68,
            (byte) 135,
            (byte) 177,
            69,
            (byte) 144,
            33,
            115,
            (byte) 195,
            (byte) 224,
            100,
            31,
            46,
            (byte) 160,
            (byte) 150,
            41
          },
          new byte[] {
            94,
            113,
            123,
            114,
            (byte) 170,
            (byte) 250,
            (byte) 213,
            (byte) 241,
            (byte) 247,
            (byte) 203,
            (byte) 160,
            (byte) 141,
            111,
            (byte) 233,
            68,
            (byte) 240,
            123,
            33,
            (byte) 207,
            (byte) 139,
            115,
            44,
            (byte) 249,
            (byte) 217,
            77,
            34,
            6,
            (byte) 254,
            77,
            75,
            20,
            99
          },
          new byte[] {
            48,
            112,
            (byte) 244,
            9,
            53,
            2,
            10,
            (byte) 147,
            (byte) 218,
            (byte) 132,
            43,
            (byte) 198,
            (byte) 200,
            101,
            20,
            3,
            71,
            (byte) 158,
            (byte) 227,
            3,
            (byte) 161,
            15,
            (byte) 215,
            112,
            (byte) 251,
            (byte) 195,
            (byte) 187,
            96,
            11,
            (byte) 203,
            (byte) 226,
            (byte) 210
          },
          new byte[] {
            (byte) 246,
            (byte) 148,
            (byte) 220,
            16,
            96,
            62,
            53,
            (byte) 189,
            96,
            83,
            (byte) 146,
            84,
            (byte) 233,
            (byte) 183,
            89,
            12,
            (byte) 235,
            31,
            24,
            113,
            (byte) 148,
            25,
            (byte) 213,
            33,
            (byte) 167,
            78,
            (byte) 147,
            (byte) 162,
            (byte) 223,
            115,
            38,
            117
          }
        };

    for (int i = 0; i < inputs.length; i++) {
      byte[] extracted = OpaqueUtil.extract(inputs[i]);
      assertEquals(32, extracted.length);
      assertArrayEquals(expectedOutputs[i], extracted);
    }
  }

  @Test
  public void testOpfrEvaluate() throws Exception {
    String username = "username";
    byte[] password = "password1234".getBytes(StandardCharsets.UTF_8);
    byte[] oprfSeed = OpaqueUtil.nonce();
    byte[] seed =
        OpaqueUtil.expand(oprfSeed, (username + "OprfKey").getBytes(StandardCharsets.UTF_8), 32);

    byte[] deriveInput =
        OpaqueUtil.expand(seed, "OPAQUE-DeriveKeyPair".getBytes(StandardCharsets.UTF_8), 32);
    byte[][] keyPair = OpaqueUtil.generateKeyPair(deriveInput);
    byte[] serverPrivateKey = keyPair[0];

    byte[] blind = new byte[32];
    new SecureRandom().nextBytes(blind);
    byte[] blindedElement = OpaqueUtil.blind(password, blind);

    // Server blindEvaluate
    X9ECParameters params = CustomNamedCurves.getByName(OpaqueUtil.CURVE_NAME);
    ECCurve curve = params.getCurve();
    ECPoint blindElement = curve.decodePoint(blindedElement);
    BigInteger scalar = new BigInteger(1, serverPrivateKey);
    byte[] evaluatedElement = blindElement.multiply(scalar).getEncoded(true);

    byte[] oprf = OpaqueUtil.finalize(blind, evaluatedElement);

    // Evaluate non-obliviously
    byte[] inputElement =
        OpaqueUtil.getHashToCurve(
            password, OpaqueUtil.LOGIN_DOMAIN_SEPARATION_TAG.getBytes(StandardCharsets.UTF_8));
    ECPoint point = curve.decodePoint(inputElement);
    byte[] prf = point.multiply(scalar).getEncoded(true);

    assertArrayEquals(oprf, prf);
  }
}
