package com.google.cloud.external;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.cloud.model.Interval;
import com.google.cloud.model.PullRequestStatistics;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class GitHubClientTest {

  private HttpResponse<String> response;
  private GitHubClient client;

  @Before
  public void setUp() throws IOException, InterruptedException {
    HttpClient httpClient = mock(HttpClient.class);
    client = new GitHubClient(httpClient);
    response = mock(HttpResponse.class);
    when(httpClient.send(any(HttpRequest.class), any(BodyHandler.class))).thenReturn(response);
  }

  @Test
  public void testListMonthlyPullRequestStatusSucceeds()
      throws URISyntaxException, IOException, InterruptedException {
    ZonedDateTime fixedNow = ZonedDateTime.parse("2024-05-22T09:33:52Z");
    ZonedDateTime lastMonth = ZonedDateTime.parse("2024-04-22T09:33:52Z");
    Instant prInstant = Instant.parse("2024-05-10T09:33:52Z");
    ZonedDateTime prTime = ZonedDateTime.parse("2024-05-10T09:33:52Z");
    String responseBody =
        Files.readString(Path.of("src/test/resources/pull_request_sample_response.txt"));

    try (MockedStatic<ZonedDateTime> mockedLocalDateTime = Mockito.mockStatic(ZonedDateTime.class);
        MockedStatic<Instant> mockedInstant = Mockito.mockStatic(Instant.class)) {
      mockedLocalDateTime.when(ZonedDateTime::now).thenReturn(fixedNow);
      mockedInstant.when(() -> Instant.parse(Mockito.anyString())).thenReturn(prInstant);
      when(fixedNow.minusDays(30)).thenReturn(lastMonth);
      when(prInstant.atZone(ZoneId.of("UTC"))).thenReturn(prTime);
      when(response.body()).thenReturn(responseBody);
      String org = "";
      String repo = "";
      PullRequestStatistics status = client.listMonthlyPullRequestStatusOf(org, repo);

      assertEquals(Interval.MONTHLY, status.interval());
      assertEquals(3, status.created());
      assertEquals(7, status.merged());
    }
  }
}
