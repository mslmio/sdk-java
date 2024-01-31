import io.mslm.emailverify.SingleVerifyResp;
import io.mslm.emailverify.SingleVerifyRespMx;
import io.mslm.mslm.Mslm;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class EmailVerifyTest {
    private Mslm c;

    @Before
    public void setup() {
        String apiKey = ""; //Your API key
        c = new Mslm(apiKey);
    }

    @Test
    public void testEmailVerifySvReal() throws Exception {
        SingleVerifyResp resp = c.emailVerify.singleVerify("support@mslm.io");
        assertEquals(resp.getEmail(), "support@mslm.io");
        assertEquals(resp.getEmail(), "support@mslm.io");
        assertEquals(resp.getUsername(), "support");
        assertEquals(resp.getDomain(), "mslm.io");
        assertFalse(resp.isMalformed());
        assertEquals(resp.getSuggestion(), "");
        assertTrue(resp.getSuggestion().isEmpty());
        assertEquals(resp.getStatus(), "real");
        assertTrue(resp.hasMailbox());
        assertFalse(resp.isAcceptAll());
        assertFalse(resp.isDisposable());
        assertFalse(resp.isFree());
        assertTrue(resp.isRole());
        List<SingleVerifyRespMx> mxList = resp.getMx();
        assertTrue(mxList.contains(new SingleVerifyRespMx("ASPMX.L.GOOGLE.COM.", 1)));
        assertTrue(mxList.contains(new SingleVerifyRespMx("ALT1.ASPMX.L.GOOGLE.COM.", 5)));
        assertTrue(mxList.contains(new SingleVerifyRespMx("ALT2.ASPMX.L.GOOGLE.COM.", 5)));
        assertTrue(mxList.contains(new SingleVerifyRespMx("ALT3.ASPMX.L.GOOGLE.COM.", 10)));
        assertTrue(mxList.contains(new SingleVerifyRespMx("ALT4.ASPMX.L.GOOGLE.COM.", 10)));

    }

    @Test
    public void testEmailVerifySvFake() throws Exception {
        SingleVerifyResp resp = c.emailVerify.singleVerify("fakefakefake@mslm.io");
        assertNotNull(resp);
        assertEquals("fakefakefake@mslm.io", resp.getEmail());
        assertEquals("fakefakefake", resp.getUsername());
        assertEquals("mslm.io", resp.getDomain());
        assertFalse(resp.isMalformed());
        assertEquals("", resp.getSuggestion());
        assertEquals("fake", resp.getStatus());
        assertFalse(resp.hasMailbox());
        assertFalse(resp.isAcceptAll());
        assertFalse(resp.isDisposable());
        assertFalse(resp.isFree());
        assertFalse(resp.isRole());
        List<SingleVerifyRespMx> mxList = resp.getMx();
        assertEquals(5, mxList.size());
        assertTrue(mxList.contains(new SingleVerifyRespMx("ASPMX.L.GOOGLE.COM.", 1)));
        assertTrue(mxList.contains(new SingleVerifyRespMx("ALT1.ASPMX.L.GOOGLE.COM.", 5)));
        assertTrue(mxList.contains(new SingleVerifyRespMx("ALT2.ASPMX.L.GOOGLE.COM.", 5)));
        assertTrue(mxList.contains(new SingleVerifyRespMx("ALT3.ASPMX.L.GOOGLE.COM.", 10)));
        assertTrue(mxList.contains(new SingleVerifyRespMx("ALT4.ASPMX.L.GOOGLE.COM.", 10)));
    }

    @Test
    public void testEmailVerifySvDisposable() throws Exception {
        SingleVerifyResp resp = c.emailVerify.singleVerify("asdfasdf@temp-mail.org");
        assertNotNull(resp);
        assertEquals("asdfasdf@temp-mail.org", resp.getEmail());
        assertEquals("asdfasdf", resp.getUsername());
        assertEquals("temp-mail.org", resp.getDomain());
        assertFalse(resp.isMalformed());
        assertEquals("", resp.getSuggestion());
        assertEquals("disposable", resp.getStatus());
        assertTrue(resp.hasMailbox());
        assertTrue(resp.isAcceptAll());
        assertTrue(resp.isDisposable());
        assertTrue(resp.isFree());
        assertFalse(resp.isRole());
        List<SingleVerifyRespMx> mxList = resp.getMx();
        assertEquals(1, mxList.size());
        assertTrue(mxList.contains(new SingleVerifyRespMx("mx.yandex.net.", 10)));
    }

    @Test
    public void testEmailVerifySvMalformed() throws Exception {
        SingleVerifyResp resp = c.emailVerify.singleVerify("malformedemail");
        assertNotNull(resp);
        assertEquals("malformedemail", resp.getEmail());
        assertEquals("", resp.getUsername());
        assertEquals("", resp.getDomain());
        assertTrue(resp.isMalformed());
        assertEquals("", resp.getSuggestion());
        assertEquals("fake", resp.getStatus());
        assertFalse(resp.hasMailbox());
        assertFalse(resp.isAcceptAll());
        assertFalse(resp.isDisposable());
        assertFalse(resp.isFree());
        assertFalse(resp.isRole());
        List<SingleVerifyRespMx> mxList = resp.getMx();
        assertTrue(mxList.isEmpty());
    }
}