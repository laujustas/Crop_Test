package helloworld;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class AppTest {
  @Test
  public void successfulResponse() {
    App app = new App();
    String result = app.handleRequest("https://getwallpapers.com/wallpaper/full/2/5/4/727006-best-windows-xp-desktop-backgrounds-3840x2160.jpg", null);
    assertNotNull(result);
  }
}
