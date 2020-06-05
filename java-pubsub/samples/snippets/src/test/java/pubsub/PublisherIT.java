package pubsub;

import static com.google.common.truth.Truth.assertThat;
import static junit.framework.TestCase.assertNotNull;

import com.google.cloud.pubsub.v1.TopicAdminClient;
import com.google.pubsub.v1.Topic;
import com.google.pubsub.v1.TopicName;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.UUID;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class PublisherIT {
  private ByteArrayOutputStream bout;
  private PrintStream out;

  private static final String projectId = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String _suffix = UUID.randomUUID().toString();
  private static final String topicId = "publisher-test-topic-" + _suffix;
  private static final TopicName topicName = TopicName.of(projectId, topicId);

  private static void requireEnvVar(String varName) {
    assertNotNull(
        "Environment variable " + varName + " is required to perform these tests.",
        System.getenv(varName));
  }

  @Rule public Timeout globalTimeout = Timeout.seconds(300); // 5 minute timeout

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("GOOGLE_CLOUD_PROJECT");
  }

  @Before
  public void setUp() throws Exception {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);

    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
      Topic topic = Topic.newBuilder().setName(topicName.toString()).build();
      topicAdminClient.createTopic(topic);
    }
  }

  @After
  public void tearDown() throws Exception {
    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
      topicAdminClient.deleteTopic(topicName.toString());
    }

    System.setOut(null);
  }

  @Test
  public void testPublisher() throws Exception {
    // Test publish with error handling
    PublishWithErrorHandlerExample.publishWithErrorHandlerExample(projectId, topicId);
    assertThat(bout.toString()).contains("Published message ID: ");

    bout.reset();
    // Test publish with custom attributes.
    PublishWithCustomAttributesExample.publishWithCustomAttributesExample(projectId, topicId);
    assertThat(bout.toString()).contains("Published a message with custom attributes: ");

    bout.reset();
    // Test publish with batch settings.
    PublishWithBatchSettingsExample.publishWithBatchSettingsExample(projectId, topicId);
    assertThat(bout.toString()).contains("Published 100 messages with batch settings.");

    bout.reset();
    // Test publish with concurrency control.
    PublishWithConcurrencyControlExample.publishWithConcurrencyControlExample(projectId, topicId);
    assertThat(bout.toString()).contains("Published 100 messages with concurrency control.");

    bout.reset();
    // Test publish with Retry settings.
    PublishWithRetrySettingsExample.publishWithRetrySettingsExample(projectId, topicId);
    assertThat(bout.toString()).contains("Published a message with retry settings: ");
  }
}
