/*
 * Copyright 2015 Google LLC
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

package com.google.cloud;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.testing.http.HttpTesting;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.api.core.ApiClock;
import com.google.api.core.CurrentMillisClock;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.spi.ServiceRpcFactory;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.io.Files;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;

class ServiceOptionsTest {
  private static GoogleCredentials credentials;
  private static GoogleCredentials credentialsWithProjectId;
  private static GoogleCredentials credentialsWithQuotaProject;
  private static GoogleCredentials credentialsNotInGDU;

  private static final String SA_JSON_KEY =
      "{\n"
          + "  \"private_key_id\": \"somekeyid\",\n"
          + "  \"private_key\": \"-----BEGIN PRIVATE KEY-----\\nMIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggS"
          + "kAgEAAoIBAQC+K2hSuFpAdrJI\\nnCgcDz2M7t7bjdlsadsasad+fvRSW6TjNQZ3p5LLQY1kSZRqBqylRkzteMOyHg"
          + "aR\\n0Pmxh3ILCND5men43j3h4eDbrhQBuxfEMalkG92sL+PNQSETY2tnvXryOvmBRwa/\\nQP/9dJfIkIDJ9Fw9N4"
          + "Bhhhp6mCcRpdQjV38H7JsyJ7lih/oNjECgYAt\\nknddadwkwewcVxHFhcZJO+XWf6ofLUXpRwiTZakGMn8EE1uVa2"
          + "LgczOjwWHGi99MFjxSer5m9\\n1tCa3/KEGKiS/YL71JvjwX3mb+cewlkcmweBKZHM2JPTk0ZednFSpVZMtycjkbLa"
          + "\\ndYOS8V85AgMBewECggEBAKksaldajfDZDV6nGqbFjMiizAKJolr/M3OQw16K6o3/\\n0S31xIe3sSlgW0+UbYlF"
          + "4U8KifhManD1apVSC3csafaspP4RZUHFhtBywLO9pR5c\\nr6S5aLp+gPWFyIp1pfXbWGvc5VY/v9x7ya1VEa6rXvL"
          + "sKupSeWAW4tMj3eo/64ge\\nsdaceaLYw52KeBYiT6+vpsnYrEkAHO1fF/LavbLLOFJmFTMxmsNaG0tuiJHgjshB\\"
          + "n82DpMCbXG9YcCgI/DbzuIjsdj2JC1cascSP//3PmefWysucBQe7Jryb6NQtASmnv\\nCdDw/0jmZTEjpe4S1lxfHp"
          + "lAhHFtdgYTvyYtaLZiVVkCgYEA8eVpof2rceecw/I6\\n5ng1q3Hl2usdWV/4mZMvR0fOemacLLfocX6IYxT1zA1FF"
          + "JlbXSRsJMf/Qq39mOR2\\nSpW+hr4jCoHeRVYLgsbggtrevGmILAlNoqCMpGZ6vDmJpq6ECV9olliDvpPgWOP+\\nm"
          + "YPDreFBGxWvQrADNbRt2dmGsrsCgYEAyUHqB2wvJHFqdmeBsaacewzV8x9WgmeX\\ngUIi9REwXlGDW0Mz50dxpxcK"
          + "CAYn65+7TCnY5O/jmL0VRxU1J2mSWyWTo1C+17L0\\n3fUqjxL1pkefwecxwecvC+gFFYdJ4CQ/MHHXU81Lwl1iWdF"
          + "Cd2UoGddYaOF+KNeM\\nHC7cmqra+JsCgYEAlUNywzq8nUg7282E+uICfCB0LfwejuymR93CtsFgb7cRd6ak\\nECR"
          + "8FGfCpH8ruWJINllbQfcHVCX47ndLZwqv3oVFKh6pAS/vVI4dpOepP8++7y1u\\ncoOvtreXCX6XqfrWDtKIvv0vjl"
          + "HBhhhp6mCcRpdQjV38H7JsyJ7lih/oNjECgYAt\\nkndj5uNl5SiuVxHFhcZJO+XWf6ofLUregtevZakGMn8EE1uVa"
          + "2AY7eafmoU/nZPT\\n00YB0TBATdCbn/nBSuKDESkhSg9s2GEKQZG5hBmL5uCMfo09z3SfxZIhJdlerreP\\nJ7gSi"
          + "dI12N+EZxYd4xIJh/HFDgp7RRO87f+WJkofMQKBgGTnClK1VMaCRbJZPriw\\nEfeFCoOX75MxKwXs6xgrw4W//AYG"
          + "GUjDt83lD6AZP6tws7gJ2IwY/qP7+lyhjEqN\\nHtfPZRGFkGZsdaksdlaksd323423d+15/UvrlRSFPNj1tWQmNKk"
          + "XyRDW4IG1Oa2p\\nrALStNBx5Y9t0/LQnFI4w3aG\\n-----END PRIVATE KEY-----\\n\",\n"
          + "  \"client_email\": \"someclientid@developer.gserviceaccount.com\",\n"
          + "  \"client_id\": \"someclientid.apps.googleusercontent.com\",\n"
          + "  \"type\": \"service_account\",\n"
          + "  \"universe_domain\": \"googleapis.com\"\n"
          + "}";

  private static final String SA_JSON_KEY_PROJECT_ID =
      "{\n"
          + "  \"private_key_id\": \"somekeyid\",\n"
          + "  \"private_key\": \"-----BEGIN PRIVATE KEY-----\\nMIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggS"
          + "kAgEAAoIBAQC+K2hSuFpAdrJI\\nnCgcDz2M7t7bjdlsadsasad+fvRSW6TjNQZ3p5LLQY1kSZRqBqylRkzteMOyHg"
          + "aR\\n0Pmxh3ILCND5men43j3h4eDbrhQBuxfEMalkG92sL+PNQSETY2tnvXryOvmBRwa/\\nQP/9dJfIkIDJ9Fw9N4"
          + "Bhhhp6mCcRpdQjV38H7JsyJ7lih/oNjECgYAt\\nknddadwkwewcVxHFhcZJO+XWf6ofLUXpRwiTZakGMn8EE1uVa2"
          + "LgczOjwWHGi99MFjxSer5m9\\n1tCa3/KEGKiS/YL71JvjwX3mb+cewlkcmweBKZHM2JPTk0ZednFSpVZMtycjkbLa"
          + "\\ndYOS8V85AgMBewECggEBAKksaldajfDZDV6nGqbFjMiizAKJolr/M3OQw16K6o3/\\n0S31xIe3sSlgW0+UbYlF"
          + "4U8KifhManD1apVSC3csafaspP4RZUHFhtBywLO9pR5c\\nr6S5aLp+gPWFyIp1pfXbWGvc5VY/v9x7ya1VEa6rXvL"
          + "sKupSeWAW4tMj3eo/64ge\\nsdaceaLYw52KeBYiT6+vpsnYrEkAHO1fF/LavbLLOFJmFTMxmsNaG0tuiJHgjshB\\"
          + "n82DpMCbXG9YcCgI/DbzuIjsdj2JC1cascSP//3PmefWysucBQe7Jryb6NQtASmnv\\nCdDw/0jmZTEjpe4S1lxfHp"
          + "lAhHFtdgYTvyYtaLZiVVkCgYEA8eVpof2rceecw/I6\\n5ng1q3Hl2usdWV/4mZMvR0fOemacLLfocX6IYxT1zA1FF"
          + "JlbXSRsJMf/Qq39mOR2\\nSpW+hr4jCoHeRVYLgsbggtrevGmILAlNoqCMpGZ6vDmJpq6ECV9olliDvpPgWOP+\\nm"
          + "YPDreFBGxWvQrADNbRt2dmGsrsCgYEAyUHqB2wvJHFqdmeBsaacewzV8x9WgmeX\\ngUIi9REwXlGDW0Mz50dxpxcK"
          + "CAYn65+7TCnY5O/jmL0VRxU1J2mSWyWTo1C+17L0\\n3fUqjxL1pkefwecxwecvC+gFFYdJ4CQ/MHHXU81Lwl1iWdF"
          + "Cd2UoGddYaOF+KNeM\\nHC7cmqra+JsCgYEAlUNywzq8nUg7282E+uICfCB0LfwejuymR93CtsFgb7cRd6ak\\nECR"
          + "8FGfCpH8ruWJINllbQfcHVCX47ndLZwqv3oVFKh6pAS/vVI4dpOepP8++7y1u\\ncoOvtreXCX6XqfrWDtKIvv0vjl"
          + "HBhhhp6mCcRpdQjV38H7JsyJ7lih/oNjECgYAt\\nkndj5uNl5SiuVxHFhcZJO+XWf6ofLUregtevZakGMn8EE1uVa"
          + "2AY7eafmoU/nZPT\\n00YB0TBATdCbn/nBSuKDESkhSg9s2GEKQZG5hBmL5uCMfo09z3SfxZIhJdlerreP\\nJ7gSi"
          + "dI12N+EZxYd4xIJh/HFDgp7RRO87f+WJkofMQKBgGTnClK1VMaCRbJZPriw\\nEfeFCoOX75MxKwXs6xgrw4W//AYG"
          + "GUjDt83lD6AZP6tws7gJ2IwY/qP7+lyhjEqN\\nHtfPZRGFkGZsdaksdlaksd323423d+15/UvrlRSFPNj1tWQmNKk"
          + "XyRDW4IG1Oa2p\\nrALStNBx5Y9t0/LQnFI4w3aG\\n-----END PRIVATE KEY-----\\n\",\n"
          + "  \"project_id\": \"someprojectid\",\n"
          + "  \"client_email\": \"someclientid@developer.gserviceaccount.com\",\n"
          + "  \"client_id\": \"someclientid.apps.googleusercontent.com\",\n"
          + "  \"type\": \"service_account\",\n"
          + "  \"universe_domain\": \"googleapis.com\"\n"
          + "}";

  private static final String SA_JSON_KEY_QUOTA_PROJECT_ID =
      "{\n"
          + "  \"private_key_id\": \"somekeyid\",\n"
          + "  \"private_key\": \"-----BEGIN PRIVATE KEY-----\\nMIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggS"
          + "kAgEAAoIBAQC+K2hSuFpAdrJI\\nnCgcDz2M7t7bjdlsadsasad+fvRSW6TjNQZ3p5LLQY1kSZRqBqylRkzteMOyHg"
          + "aR\\n0Pmxh3ILCND5men43j3h4eDbrhQBuxfEMalkG92sL+PNQSETY2tnvXryOvmBRwa/\\nQP/9dJfIkIDJ9Fw9N4"
          + "Bhhhp6mCcRpdQjV38H7JsyJ7lih/oNjECgYAt\\nknddadwkwewcVxHFhcZJO+XWf6ofLUXpRwiTZakGMn8EE1uVa2"
          + "LgczOjwWHGi99MFjxSer5m9\\n1tCa3/KEGKiS/YL71JvjwX3mb+cewlkcmweBKZHM2JPTk0ZednFSpVZMtycjkbLa"
          + "\\ndYOS8V85AgMBewECggEBAKksaldajfDZDV6nGqbFjMiizAKJolr/M3OQw16K6o3/\\n0S31xIe3sSlgW0+UbYlF"
          + "4U8KifhManD1apVSC3csafaspP4RZUHFhtBywLO9pR5c\\nr6S5aLp+gPWFyIp1pfXbWGvc5VY/v9x7ya1VEa6rXvL"
          + "sKupSeWAW4tMj3eo/64ge\\nsdaceaLYw52KeBYiT6+vpsnYrEkAHO1fF/LavbLLOFJmFTMxmsNaG0tuiJHgjshB\\"
          + "n82DpMCbXG9YcCgI/DbzuIjsdj2JC1cascSP//3PmefWysucBQe7Jryb6NQtASmnv\\nCdDw/0jmZTEjpe4S1lxfHp"
          + "lAhHFtdgYTvyYtaLZiVVkCgYEA8eVpof2rceecw/I6\\n5ng1q3Hl2usdWV/4mZMvR0fOemacLLfocX6IYxT1zA1FF"
          + "JlbXSRsJMf/Qq39mOR2\\nSpW+hr4jCoHeRVYLgsbggtrevGmILAlNoqCMpGZ6vDmJpq6ECV9olliDvpPgWOP+\\nm"
          + "YPDreFBGxWvQrADNbRt2dmGsrsCgYEAyUHqB2wvJHFqdmeBsaacewzV8x9WgmeX\\ngUIi9REwXlGDW0Mz50dxpxcK"
          + "CAYn65+7TCnY5O/jmL0VRxU1J2mSWyWTo1C+17L0\\n3fUqjxL1pkefwecxwecvC+gFFYdJ4CQ/MHHXU81Lwl1iWdF"
          + "Cd2UoGddYaOF+KNeM\\nHC7cmqra+JsCgYEAlUNywzq8nUg7282E+uICfCB0LfwejuymR93CtsFgb7cRd6ak\\nECR"
          + "8FGfCpH8ruWJINllbQfcHVCX47ndLZwqv3oVFKh6pAS/vVI4dpOepP8++7y1u\\ncoOvtreXCX6XqfrWDtKIvv0vjl"
          + "HBhhhp6mCcRpdQjV38H7JsyJ7lih/oNjECgYAt\\nkndj5uNl5SiuVxHFhcZJO+XWf6ofLUregtevZakGMn8EE1uVa"
          + "2AY7eafmoU/nZPT\\n00YB0TBATdCbn/nBSuKDESkhSg9s2GEKQZG5hBmL5uCMfo09z3SfxZIhJdlerreP\\nJ7gSi"
          + "dI12N+EZxYd4xIJh/HFDgp7RRO87f+WJkofMQKBgGTnClK1VMaCRbJZPriw\\nEfeFCoOX75MxKwXs6xgrw4W//AYG"
          + "GUjDt83lD6AZP6tws7gJ2IwY/qP7+lyhjEqN\\nHtfPZRGFkGZsdaksdlaksd323423d+15/UvrlRSFPNj1tWQmNKk"
          + "XyRDW4IG1Oa2p\\nrALStNBx5Y9t0/LQnFI4w3aG\\n-----END PRIVATE KEY-----\\n\",\n"
          + "  \"project_id\": \"someprojectid\",\n"
          + "  \"client_email\": \"someclientid@developer.gserviceaccount.com\",\n"
          + "  \"client_id\": \"someclientid.apps.googleusercontent.com\",\n"
          + "  \"type\": \"service_account\",\n"
          + "  \"quota_project_id\": \"some-quota-project-id\",\n"
          + "  \"universe_domain\": \"googleapis.com\"\n"
          + "}";

  // Key added by copying the keys above and adding in the universe domain field
  private static final String SA_JSON_KEY_NON_GDU =
      "{\n"
          + "  \"private_key_id\": \"somekeyid\",\n"
          + "  \"private_key\": \"-----BEGIN PRIVATE KEY-----\\nMIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggS"
          + "kAgEAAoIBAQC+K2hSuFpAdrJI\\nnCgcDz2M7t7bjdlsadsasad+fvRSW6TjNQZ3p5LLQY1kSZRqBqylRkzteMOyHg"
          + "aR\\n0Pmxh3ILCND5men43j3h4eDbrhQBuxfEMalkG92sL+PNQSETY2tnvXryOvmBRwa/\\nQP/9dJfIkIDJ9Fw9N4"
          + "Bhhhp6mCcRpdQjV38H7JsyJ7lih/oNjECgYAt\\nknddadwkwewcVxHFhcZJO+XWf6ofLUXpRwiTZakGMn8EE1uVa2"
          + "LgczOjwWHGi99MFjxSer5m9\\n1tCa3/KEGKiS/YL71JvjwX3mb+cewlkcmweBKZHM2JPTk0ZednFSpVZMtycjkbLa"
          + "\\ndYOS8V85AgMBewECggEBAKksaldajfDZDV6nGqbFjMiizAKJolr/M3OQw16K6o3/\\n0S31xIe3sSlgW0+UbYlF"
          + "4U8KifhManD1apVSC3csafaspP4RZUHFhtBywLO9pR5c\\nr6S5aLp+gPWFyIp1pfXbWGvc5VY/v9x7ya1VEa6rXvL"
          + "sKupSeWAW4tMj3eo/64ge\\nsdaceaLYw52KeBYiT6+vpsnYrEkAHO1fF/LavbLLOFJmFTMxmsNaG0tuiJHgjshB\\"
          + "n82DpMCbXG9YcCgI/DbzuIjsdj2JC1cascSP//3PmefWysucBQe7Jryb6NQtASmnv\\nCdDw/0jmZTEjpe4S1lxfHp"
          + "lAhHFtdgYTvyYtaLZiVVkCgYEA8eVpof2rceecw/I6\\n5ng1q3Hl2usdWV/4mZMvR0fOemacLLfocX6IYxT1zA1FF"
          + "JlbXSRsJMf/Qq39mOR2\\nSpW+hr4jCoHeRVYLgsbggtrevGmILAlNoqCMpGZ6vDmJpq6ECV9olliDvpPgWOP+\\nm"
          + "YPDreFBGxWvQrADNbRt2dmGsrsCgYEAyUHqB2wvJHFqdmeBsaacewzV8x9WgmeX\\ngUIi9REwXlGDW0Mz50dxpxcK"
          + "CAYn65+7TCnY5O/jmL0VRxU1J2mSWyWTo1C+17L0\\n3fUqjxL1pkefwecxwecvC+gFFYdJ4CQ/MHHXU81Lwl1iWdF"
          + "Cd2UoGddYaOF+KNeM\\nHC7cmqra+JsCgYEAlUNywzq8nUg7282E+uICfCB0LfwejuymR93CtsFgb7cRd6ak\\nECR"
          + "8FGfCpH8ruWJINllbQfcHVCX47ndLZwqv3oVFKh6pAS/vVI4dpOepP8++7y1u\\ncoOvtreXCX6XqfrWDtKIvv0vjl"
          + "HBhhhp6mCcRpdQjV38H7JsyJ7lih/oNjECgYAt\\nkndj5uNl5SiuVxHFhcZJO+XWf6ofLUregtevZakGMn8EE1uVa"
          + "2AY7eafmoU/nZPT\\n00YB0TBATdCbn/nBSuKDESkhSg9s2GEKQZG5hBmL5uCMfo09z3SfxZIhJdlerreP\\nJ7gSi"
          + "dI12N+EZxYd4xIJh/HFDgp7RRO87f+WJkofMQKBgGTnClK1VMaCRbJZPriw\\nEfeFCoOX75MxKwXs6xgrw4W//AYG"
          + "GUjDt83lD6AZP6tws7gJ2IwY/qP7+lyhjEqN\\nHtfPZRGFkGZsdaksdlaksd323423d+15/UvrlRSFPNj1tWQmNKk"
          + "XyRDW4IG1Oa2p\\nrALStNBx5Y9t0/LQnFI4w3aG\\n-----END PRIVATE KEY-----\\n\",\n"
          + "  \"client_email\": \"someclientid@developer.gserviceaccount.com\",\n"
          + "  \"client_id\": \"someclientid.apps.googleusercontent.com\",\n"
          + "  \"type\": \"service_account\",\n"
          + "  \"universe_domain\": \"random.com\"\n"
          + "}";

  static {
    credentials = loadServiceAccountCredentials(SA_JSON_KEY);
    credentialsWithProjectId = loadServiceAccountCredentials(SA_JSON_KEY_PROJECT_ID);
    credentialsWithQuotaProject = loadServiceAccountCredentials(SA_JSON_KEY_QUOTA_PROJECT_ID);
    credentialsNotInGDU = loadServiceAccountCredentials(SA_JSON_KEY_NON_GDU);
  }

  static GoogleCredentials loadServiceAccountCredentials(String credentialFile) {
    try {
      InputStream keyStream = new ByteArrayInputStream(credentialFile.getBytes());
      return ServiceAccountCredentials.fromStream(keyStream);
    } catch (IOException e) {
      fail("Couldn't create fake JSON credentials.");
    }
    return null;
  }

  private static final ApiClock TEST_CLOCK = new TestClock();
  private static final TestServiceOptions OPTIONS =
      TestServiceOptions.newBuilder()
          .setCredentials(credentials)
          .setClock(TEST_CLOCK)
          .setHost("host")
          .setProjectId("project-id")
          .setRetrySettings(ServiceOptions.getNoRetrySettings())
          .setQuotaProjectId("quota-project-id")
          .build();
  private static final TestServiceOptions OPTIONS_NO_CREDENTIALS =
      TestServiceOptions.newBuilder()
          .setCredentials(NoCredentials.getInstance())
          .setClock(TEST_CLOCK)
          .setHost("host")
          .setProjectId("project-id")
          .setRetrySettings(ServiceOptions.getNoRetrySettings())
          .setQuotaProjectId("quota-project-id")
          .build();
  private static final TestServiceOptions DEFAULT_OPTIONS =
      TestServiceOptions.newBuilder().setProjectId("project-id").build();
  private static final TestServiceOptions OPTIONS_COPY = OPTIONS.toBuilder().build();
  private static final String LIBRARY_NAME = "gcloud-java";
  private static final Pattern APPLICATION_NAME_PATTERN = Pattern.compile(LIBRARY_NAME + "/.*");

  private static class TestClock implements ApiClock {
    @Override
    public long nanoTime() {
      return 123_456_789_000_000L;
    }

    @Override
    public long millisTime() {
      return 123_456_789L;
    }
  }

  interface TestService extends Service<TestServiceOptions> {}

  private static class TestServiceImpl extends BaseService<TestServiceOptions>
      implements TestService {
    private TestServiceImpl(TestServiceOptions options) {
      super(options);
    }
  }

  public interface TestServiceFactory extends ServiceFactory<TestService, TestServiceOptions> {}

  private static class DefaultTestServiceFactory implements TestServiceFactory {
    private static final TestServiceFactory INSTANCE = new DefaultTestServiceFactory();

    @Override
    public TestService create(TestServiceOptions options) {
      return new TestServiceImpl(options);
    }
  }

  public interface TestServiceRpcFactory extends ServiceRpcFactory<TestServiceOptions> {}

  private static class DefaultTestServiceRpcFactory implements TestServiceRpcFactory {
    private static final TestServiceRpcFactory INSTANCE = new DefaultTestServiceRpcFactory();

    @Override
    public TestServiceRpc create(TestServiceOptions options) {
      return new DefaultTestServiceRpc(options);
    }
  }

  private interface TestServiceRpc extends ServiceRpc {}

  private static class DefaultTestServiceRpc implements TestServiceRpc {
    DefaultTestServiceRpc(TestServiceOptions options) {}
  }

  static class TestServiceOptions extends ServiceOptions<TestService, TestServiceOptions> {
    private static class Builder
        extends ServiceOptions.Builder<TestService, TestServiceOptions, Builder> {
      private Builder() {}

      private Builder(TestServiceOptions options) {
        super(options);
      }

      @Override
      protected TestServiceOptions build() {
        return new TestServiceOptions(this);
      }
    }

    private TestServiceOptions(Builder builder) {
      super(
          TestServiceFactory.class,
          TestServiceRpcFactory.class,
          builder,
          new TestServiceDefaults());
    }

    private static class TestServiceDefaults
        implements ServiceDefaults<TestService, TestServiceOptions> {

      @Override
      public TestServiceFactory getDefaultServiceFactory() {
        return DefaultTestServiceFactory.INSTANCE;
      }

      @Override
      public TestServiceRpcFactory getDefaultRpcFactory() {
        return DefaultTestServiceRpcFactory.INSTANCE;
      }

      @Override
      public TransportOptions getDefaultTransportOptions() {
        return new TransportOptions() {};
      }
    }

    @Override
    protected Set<String> getScopes() {
      return null;
    }

    @Override
    public Builder toBuilder() {
      return new Builder(this);
    }

    private static Builder newBuilder() {
      return new Builder();
    }

    @Override
    public boolean equals(Object obj) {
      return obj instanceof TestServiceOptions && baseEquals((TestServiceOptions) obj);
    }

    @Override
    public int hashCode() {
      return baseHashCode();
    }
  }

  @Test
  public void testBuilder() {
    assertSame(credentials, OPTIONS.getCredentials());
    assertSame(TEST_CLOCK, OPTIONS.getClock());
    assertEquals("host", OPTIONS.getHost());
    assertEquals("project-id", OPTIONS.getProjectId());
    assertSame(ServiceOptions.getNoRetrySettings(), OPTIONS.getRetrySettings());
    assertSame(CurrentMillisClock.getDefaultClock(), DEFAULT_OPTIONS.getClock());
    assertEquals("https://www.googleapis.com", DEFAULT_OPTIONS.getHost());
    assertSame(ServiceOptions.getDefaultRetrySettings(), DEFAULT_OPTIONS.getRetrySettings());
  }

  @Test
  public void testBuilder_quotaProjectServiceOptionTakesPrecedence() {
    TestServiceOptions noCredsWithQuotaProject =
        TestServiceOptions.newBuilder()
            .setCredentials(NoCredentials.getInstance())
            .setProjectId("project-id")
            .setQuotaProjectId("quota-project-id")
            .build();
    TestServiceOptions quotaProjectCredsWithQuotaProject =
        TestServiceOptions.newBuilder()
            .setQuotaProjectId("quota-project-id")
            .setCredentials(credentialsWithQuotaProject)
            .build();
    TestServiceOptions quotaProjectCredsWithQuotaProject2 =
        TestServiceOptions.newBuilder()
            .setCredentials(credentialsWithQuotaProject)
            .setQuotaProjectId("quota-project-id")
            .build();
    TestServiceOptions quotaProjectCreds =
        TestServiceOptions.newBuilder().setCredentials(credentialsWithQuotaProject).build();
    TestServiceOptions none =
        TestServiceOptions.newBuilder()
            .setCredentials(NoCredentials.getInstance())
            .setProjectId("project-id")
            .build();

    assertEquals("quota-project-id", noCredsWithQuotaProject.getQuotaProjectId());
    assertEquals("quota-project-id", quotaProjectCredsWithQuotaProject.getQuotaProjectId());
    assertEquals("quota-project-id", quotaProjectCredsWithQuotaProject2.getQuotaProjectId());
    assertEquals("some-quota-project-id", quotaProjectCreds.getQuotaProjectId());
    assertNull(none.getQuotaProjectId());
  }

  @Test
  void testBuilderNoCredentials() {
    assertEquals(NoCredentials.getInstance(), OPTIONS_NO_CREDENTIALS.getCredentials());
    assertEquals(NoCredentials.getInstance(), OPTIONS_NO_CREDENTIALS.getCredentials());
    assertNotEquals(NoCredentials.getInstance(), OPTIONS.getCredentials());
    assertNotNull(NoCredentials.getInstance());
    assertSame(TEST_CLOCK, OPTIONS_NO_CREDENTIALS.getClock());
    assertEquals("host", OPTIONS_NO_CREDENTIALS.getHost());
    assertEquals("project-id", OPTIONS_NO_CREDENTIALS.getProjectId());
    assertSame(ServiceOptions.getNoRetrySettings(), OPTIONS_NO_CREDENTIALS.getRetrySettings());
    assertEquals("quota-project-id", OPTIONS.getQuotaProjectId());
  }

  @Test
  void testBuilderNullCredentials() {
    assertThrows(
        NullPointerException.class,
        () -> TestServiceOptions.newBuilder().setCredentials(null).build());
  }

  @Test
  void testBuilderServiceAccount_setsProjectId() {
    TestServiceOptions options =
        TestServiceOptions.newBuilder().setCredentials(credentialsWithProjectId).build();
    assertEquals("someprojectid", options.getProjectId());
  }

  @Test
  void testBuilderServiceAccount_explicitSetProjectIdBefore() {
    TestServiceOptions options =
        TestServiceOptions.newBuilder()
            .setProjectId("override-project-id")
            .setCredentials(credentialsWithProjectId)
            .build();
    assertEquals("override-project-id", options.getProjectId());
  }

  @Test
  void testBuilderServiceAccount_explicitSetProjectIdAfter() {
    TestServiceOptions options =
        TestServiceOptions.newBuilder()
            .setCredentials(credentialsWithProjectId)
            .setProjectId("override-project-id")
            .build();
    assertEquals("override-project-id", options.getProjectId());
  }

  @Test
  void testGetProjectIdRequired() {
    assertTrue(OPTIONS.projectIdRequired());
  }

  @Test
  void testService() {
    assertTrue(OPTIONS.getService() instanceof TestServiceImpl);
  }

  @Test
  void testRpc() {
    assertTrue(OPTIONS.getRpc() instanceof DefaultTestServiceRpc);
  }

  @Test
  void testBaseEquals() {
    assertEquals(OPTIONS, OPTIONS_COPY);
    assertNotEquals(DEFAULT_OPTIONS, OPTIONS);
  }

  @Test
  void testLibraryName() {
    assertEquals(LIBRARY_NAME, ServiceOptions.getLibraryName());
  }

  @Test
  void testApplicationName() {
    assertTrue(APPLICATION_NAME_PATTERN.matcher(OPTIONS.getApplicationName()).matches());
  }

  @Test
  void testBaseHashCode() {
    assertEquals(OPTIONS.hashCode(), OPTIONS_COPY.hashCode());
    assertNotEquals(DEFAULT_OPTIONS.hashCode(), OPTIONS.hashCode());
  }

  @Test
  void testGetServiceAccountProjectId() throws Exception {
    File credentialsFile = File.createTempFile("credentials", ".json");
    credentialsFile.deleteOnExit();
    Files.write("{\"project_id\":\"my-project-id\"}".getBytes(), credentialsFile);

    assertEquals(
        "my-project-id",
        ServiceOptions.getValueFromCredentialsFile(credentialsFile.getPath(), "project_id"));
  }

  @Test
  void testGetServiceAccountProjectId_badJson() throws Exception {
    File credentialsFile = File.createTempFile("credentials", ".json");
    credentialsFile.deleteOnExit();
    Files.write("asdfghj".getBytes(StandardCharsets.UTF_8), credentialsFile);

    String valueFromCredentialsFile =
        ServiceOptions.getValueFromCredentialsFile(credentialsFile.getPath(), "project_id");
    assertNull(valueFromCredentialsFile);
  }

  @Test
  void testGetServiceAccountProjectId_nonExistentFile() throws Exception {
    File credentialsFile = new File("/doesnotexist");

    assertNull(ServiceOptions.getValueFromCredentialsFile(credentialsFile.getPath(), "project_id"));
  }

  @Test
  void testResponseHeaderContainsMetaDataFlavor() throws Exception {
    Multimap<String, String> headers = ArrayListMultimap.create();
    headers.put("Metadata-Flavor", "Google");
    HttpResponse httpResponse = createHttpResponseWithHeader(headers);
    assertThat(ServiceOptions.headerContainsMetadataFlavor(httpResponse)).isTrue();
  }

  @Test
  void testResponseHeaderDoesNotContainMetaDataFlavor() throws Exception {
    Multimap<String, String> headers = ArrayListMultimap.create();
    HttpResponse httpResponse = createHttpResponseWithHeader(headers);
    assertThat(ServiceOptions.headerContainsMetadataFlavor(httpResponse)).isFalse();
  }

  @Test
  void testGetResolvedEndpoint_noUniverseDomain() {
    TestServiceOptions options = TestServiceOptions.newBuilder().setProjectId("project-id").build();
    assertThat(options.getResolvedHost("service")).isEqualTo("https://service.googleapis.com");
  }

  @Test
  void testGetResolvedEndpoint_emptyUniverseDomain() {
    TestServiceOptions options =
        TestServiceOptions.newBuilder().setUniverseDomain("").setProjectId("project-id").build();
    IllegalArgumentException exception =
        assertThrows(IllegalArgumentException.class, () -> options.getResolvedHost("service"));
    assertThat(exception.getMessage()).isEqualTo("The universe domain cannot be empty");
  }

  @Test
  void testGetResolvedEndpoint_customUniverseDomain() {
    TestServiceOptions options =
        TestServiceOptions.newBuilder()
            .setUniverseDomain("test.com")
            .setProjectId("project-id")
            .build();
    assertThat(options.getResolvedHost("service")).isEqualTo("https://service.test.com");
  }

  @Test
  void testGetResolvedEndpoint_customUniverseDomain_customHost() {
    TestServiceOptions options =
        TestServiceOptions.newBuilder()
            .setUniverseDomain("test.com")
            .setHost("https://service.random.com/")
            .setProjectId("project-id")
            .build();
    assertThat(options.getResolvedHost("service")).isEqualTo("https://service.random.com/");
  }

  @Test
  void testGetResolvedApiaryHost_noUniverseDomain() {
    TestServiceOptions options = TestServiceOptions.newBuilder().setProjectId("project-id").build();
    assertThat(options.getResolvedApiaryHost("service"))
        .isEqualTo("https://service.googleapis.com/");
  }

  @Test
  void testGetResolvedApiaryHost_customUniverseDomain_noHost() {
    TestServiceOptions options =
        TestServiceOptions.newBuilder()
            .setUniverseDomain("test.com")
            .setHost(null)
            .setProjectId("project-id")
            .build();
    assertThat(options.getResolvedApiaryHost("service")).isEqualTo("https://service.test.com/");
  }

  @Test
  void testGetResolvedApiaryHost_customUniverseDomain_customHost() {
    TestServiceOptions options =
        TestServiceOptions.newBuilder()
            .setUniverseDomain("test.com")
            .setHost("https://service.random.com/")
            .setProjectId("project-id")
            .build();
    assertThat(options.getResolvedApiaryHost("service")).isEqualTo("https://service.random.com/");
  }

  // No User Configuration = GDU, Default Credentials = GDU
  @Test
  void testIsValidUniverseDomain_noUserUniverseDomainConfig_defaultCredentials()
      throws IOException {
    TestServiceOptions options =
        TestServiceOptions.newBuilder()
            .setProjectId("project-id")
            .setHost("https://test.random.com")
            .setCredentials(credentials)
            .build();
    assertThat(options.hasValidUniverseDomain()).isTrue();
  }

  // No User Configuration = GDU, non Default Credentials = random.com
  // non-GDU Credentials could be any domain, the tests use random.com
  @Test
  void testIsValidUniverseDomain_noUserUniverseDomainConfig_nonGDUCredentials() throws IOException {
    TestServiceOptions options =
        TestServiceOptions.newBuilder()
            .setProjectId("project-id")
            .setHost("https://test.random.com")
            .setCredentials(credentialsNotInGDU)
            .build();
    assertThat(options.hasValidUniverseDomain()).isFalse();
  }

  // User Configuration = random.com, Default Credentials = GDU
  // User Credentials could be set to any domain, the tests use random.com
  @Test
  void testIsValidUniverseDomain_userUniverseDomainConfig_defaultCredentials() throws IOException {
    TestServiceOptions options =
        TestServiceOptions.newBuilder()
            .setProjectId("project-id")
            .setHost("https://test.random.com")
            .setUniverseDomain("random.com")
            .setCredentials(credentials)
            .build();
    assertThat(options.hasValidUniverseDomain()).isFalse();
  }

  // User Configuration = random.com, non Default Credentials = random.com
  // User Credentials and non GDU Credentials could be set to any domain,
  // the tests use random.com
  @Test
  void testIsValidUniverseDomain_userUniverseDomainConfig_nonGDUCredentials() throws IOException {
    TestServiceOptions options =
        TestServiceOptions.newBuilder()
            .setProjectId("project-id")
            .setHost("https://test.random.com")
            .setUniverseDomain("random.com")
            .setCredentials(credentialsNotInGDU)
            .build();
    assertThat(options.hasValidUniverseDomain()).isTrue();
  }

  private HttpResponse createHttpResponseWithHeader(final Multimap<String, String> headers)
      throws Exception {
    HttpTransport mockHttpTransport =
        new MockHttpTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) throws IOException {
            return new MockLowLevelHttpRequest() {
              @Override
              public LowLevelHttpResponse execute() throws IOException {
                MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
                for (Map.Entry<String, String> entry : headers.entries()) {
                  response.addHeader(entry.getKey(), entry.getValue());
                }
                return response;
              }
            };
          }
        };
    HttpRequest request =
        mockHttpTransport.createRequestFactory().buildGetRequest(HttpTesting.SIMPLE_GENERIC_URL);
    return request.execute();
  }
}
