package com.example.onlinebanking.tests;

import com.example.onlinebanking.base.BaseTest;
import com.example.onlinebanking.pages.DashboardPage;
import com.example.onlinebanking.pages.LoginPage;
import com.example.onlinebanking.pages.TransferPage;
import com.example.onlinebanking.utils.DBUtil;
import com.example.onlinebanking.utils.CSVDataProvider;
import org.testng.Assert;
import org.testng.annotations.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;

public class TransferTests extends BaseTest {

    private DBUtil db;

    @BeforeClass
    public void setupDb() throws Exception {
        db = new DBUtil();
        String sql = new String(Files.readAllBytes(Paths.get("db/banking_init.sql")));
        db.runScript(sql);
    }

    @AfterClass
    public void closeDb() throws Exception {
        db.close();
    }

    @Test(dataProvider = "transferData", dataProviderClass = CSVDataProvider.class)
    public void transferScenarios(String toAcc, String amount, String expectedMsg) throws Exception {
        // ensure logged in
        LoginPage lp = new LoginPage(driver);
        lp.open(baseUrl);
        lp.login("user1","pass1");
        try { Thread.sleep(300); } catch(Exception e){}

        DashboardPage dp = new DashboardPage(driver);
        dp.goToTransfer();
        TransferPage tp = new TransferPage(driver);
        tp.transfer(toAcc, amount);
        // small wait
        Thread.sleep(300);
        String msg = tp.getMessage();
        Assert.assertEquals(msg, expectedMsg);

        // Now check DB: for successful transfer (expectedMsg contains 'successful'), update DB accordingly
        if(expectedMsg.contains("successful")){
            // simulate DB update for demo since app uses localStorage: we'll update H2 to mimic backend update
            db.execute("UPDATE accounts SET balance = balance - " + amount + " WHERE id = 1");
            db.execute("INSERT INTO transactions (account_id, to_account, amount, tx_time) VALUES (1,'" + toAcc + "'," + amount + ", CURRENT_TIMESTAMP())");
            ResultSet rs = db.query("SELECT balance FROM accounts WHERE id = 1");
            if(rs.next()){
                double bal = rs.getDouble("balance");
                System.out.println("DB Balance after tx: " + bal);
            }
        }
    }
}
