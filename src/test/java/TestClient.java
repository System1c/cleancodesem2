import com.apiit.assignment.client.ClientHandler;
import org.junit.Assert;
import org.junit.Test;

public class TestClient {
    ClientHandler cln = new ClientHandler();

    @Test
    public void testClient1() throws Exception {
        int res = cln.Client(3, 25, null);
        Assert.assertEquals(89, res);
    }

    @Test
    public void testClient2() throws Exception {
        int res = cln.Client(3, 50, null);
        Assert.assertEquals(227, res);
    }

    @Test
    public void testClient3() throws Exception {
        int res = cln.Client(3, 75, null);
        Assert.assertEquals(373, res);
    }
    @Test
    public void testClient4() throws Exception {
        int res = cln.Client(3, 100, null);
        Assert.assertEquals(523, res);
    }
    @Test
    public void testClient5() throws Exception {
        int res = cln.Client(3, 125, null);
        Assert.assertEquals(683, res);
    }




}
