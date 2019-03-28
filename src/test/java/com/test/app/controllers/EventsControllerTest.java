package com.test.app.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventsControllerTest {

    @Autowired
    private EventsController controller;

//    @Autowired
//    private TestRestTemplate restTemplate;

    @Test
    public void testCreate() throws Exception {
        URI uri = new URI("http://localhost:8080/events/create");
//        ResponseEntity<String> response = this.restTemplate.postForEntity(uri, request1, String.class);
//
//        System.out.println(respoz);
    }


    private String request1 = "{\n" +
            "\t\"eventId\": \"G5A1AY8MPHL3RGPSYAGWA6XJ9C\",\n" +
            "\t\"entityId\": \"XJ0RF7TJHVQ9DJ3GR046DF2F8R\",\n" +
            "\t\"type\": \"CLIENT_ACTIVATED\",\n" +
            "\t\"entityType\": \"Client\",\n" +
            "\t\"entity\": {\n" +
            "\t\t\"identity\": {\n" +
            "\t\t\t\"id\": \"XJ0RF7TJHVQ9DJ3GR046DF2F8R\",\n" +
            "\t\t\t\"name\": \"sICcZIiOoiPOST\",\n" +
            "\t\t\t\"description\": \"TEST Client Description POST\",\n" +
            "\t\t\t\"code\": null\n" +
            "\t\t},\n" +
            "\t\t\"entity\": {\n" +
            "\t\t\t\"parent\": {\n" +
            "\t\t\t\t\"id\": null,\n" +
            "\t\t\t\t\"name\": null,\n" +
            "\t\t\t\t\"description\": null,\n" +
            "\t\t\t\t\"code\": null\n" +
            "\t\t\t},\n" +
            "\t\t\t\"picture\": \"http://test.test.co\",\n" +
            "\t\t\t\"type\": \"CLIENT\",\n" +
            "\t\t\t\"state\": \"ACTIVE\",\n" +
            "\t\t\t\"bindings\": [{\n" +
            "\t\t\t\t\"identity\": {\n" +
            "\t\t\t\t\t\"id\": \"T9C42JNA5BDR1QP75NVMTJ8N58\",\n" +
            "\t\t\t\t\t\"name\": \"CLIENT\",\n" +
            "\t\t\t\t\t\"description\": \"Test Binding Description POST\",\n" +
            "\t\t\t\t\t\"code\": null\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"type\": \"CASHSTAR\",\n" +
            "\t\t\t\t\"code\": \"tKhCDtoQydlhzO7g6Q\"\n" +
            "\t\t\t}],\n" +
            "\t\t\t\"history\": {\n" +
            "\t\t\t\t\"createdDate\": \"2019-03-21T17:36:10.767+0000\",\n" +
            "\t\t\t\t\"createdBy\": null,\n" +
            "\t\t\t\t\"modifiedDate\": \"2019-03-21T17:36:10.821+0000\",\n" +
            "\t\t\t\t\"modifiedBy\": null,\n" +
            "\t\t\t\t\"reason\": null,\n" +
            "\t\t\t\t\"auditSource\": null\n" +
            "\t\t\t},\n" +
            "\t\t\t\"source\": \"CASHSTAR\",\n" +
            "\t\t\t\"inheritance\": null\n" +
            "\t\t},\n" +
            "\t\t\"type\": \"MERCHANT\",\n" +
            "\t\t\"companyCode\": \"UdQrKzpFW1POST\",\n" +
            "\t\t\"isBHNClient\": false,\n" +
            "\t\t\"_links\": {\n" +
            "\t\t\t\"self\": {\n" +
            "\t\t\t\t\"href\": \"https://int.blackhawknetwork.com/account/v1/clients/XJ0RF7TJHVQ9DJ3GR046DF2F8R\"\n" +
            "\t\t\t}\n" +
            "\t\t}\n" +
            "\t},\n" +
            "\t\"attributes\": {\n" +
            "\n" +
            "\t},\n" +
            "\t\"_links\": {\n" +
            "\t\t\"Client\": {\n" +
            "\t\t\t\"href\": \"https://int.blackhawknetwork.com/account/v1/clients/XJ0RF7TJHVQ9DJ3GR046DF2F8R\"\n" +
            "\t\t},\n" +
            "\t\t\"Client.local\": {\n" +
            "\t\t\t\"href\": \"https://accountmanagement.local/clients/XJ0RF7TJHVQ9DJ3GR046DF2F8R\"\n" +
            "\t\t}\n" +
            "\t}\n" +
            "}";

    private String request2 = "{\n" +
            "\t\"eventId\": \"9R4XL2H61MR6XZNHBL57LJ9TH8\",\n" +
            "\t\"entityId\": \"41SC2XM1AX67KG0ZG3C2QV239M\",\n" +
            "\t\"type\": \"BILLER_UPDATED\",\n" +
            "\t\"entityType\": \"Biller\",\n" +
            "\t\"created\": null,\n" +
            "\t\"updated\": null,\n" +
            "\t\"entity\": {\n" +
            "\t\t\"identity\": {\n" +
            "\t\t\t\"id\": \"41SC2XM1AX67KG0ZG3C2QV239M\",\n" +
            "\t\t\t\"name\": \"backgroundtestDP\",\n" +
            "\t\t\t\"description\": \"autotest DP\",\n" +
            "\t\t\t\"code\": null\n" +
            "\t\t},\n" +
            "\t\t\"entity\": {\n" +
            "\t\t\t\"parent\": {\n" +
            "\t\t\t\t\"id\": \"A8DZTVDFXWRCZNHXL3K9HMFTB8\",\n" +
            "\t\t\t\t\"name\": null,\n" +
            "\t\t\t\t\"description\": null,\n" +
            "\t\t\t\t\"code\": null\n" +
            "\t\t\t},\n" +
            "\t\t\t\"picture\": null,\n" +
            "\t\t\t\"type\": \"BILLER\",\n" +
            "\t\t\t\"state\": \"ACTIVE\",\n" +
            "\t\t\t\"bindings\": [\n" +
            "\n" +
            "\t\t\t],\n" +
            "\t\t\t\"history\": {\n" +
            "\t\t\t\t\"createdDate\": \"2019-01-21T16:18:45.000+0000\",\n" +
            "\t\t\t\t\"createdBy\": \"API\",\n" +
            "\t\t\t\t\"modifiedDate\": \"2019-03-21T18:15:13.565+0000\",\n" +
            "\t\t\t\t\"modifiedBy\": \"Mykhailo.Bestiuk@bhnetwork.com\",\n" +
            "\t\t\t\t\"reason\": null,\n" +
            "\t\t\t\t\"auditSource\": null\n" +
            "\t\t\t},\n" +
            "\t\t\t\"source\": null,\n" +
            "\t\t\t\"inheritance\": null\n" +
            "\t\t},\n" +
            "\t\t\"legalEntity\": {\n" +
            "\t\t\t\"id\": \"A8DZTVDFXWRCZNHXL3K9HMFTB8\",\n" +
            "\t\t\t\"name\": null,\n" +
            "\t\t\t\"description\": null,\n" +
            "\t\t\t\"code\": null\n" +
            "\t\t},\n" +
            "\t\t\"clientId\": \"DCJQTJRVM25X087NN9S179VM2H\",\n" +
            "\t\t\"billerName\": \"backgroundtestDP\",\n" +
            "\t\t\"billerDescription\": \"autotest DP\",\n" +
            "\t\t\"currencyCode\": \"USD\",\n" +
            "\t\t\"billerType\": \"RECEIVABLE\",\n" +
            "\t\t\"type\": \"RECEIVABLE\",\n" +
            "\t\t\"biller\": null,\n" +
            "\t\t\"billingType\": \"ALL\",\n" +
            "\t\t\"businessUnit\": \"B072\",\n" +
            "\t\t\"channel\": \"1100\",\n" +
            "\t\t\"instrument\": null,\n" +
            "\t\t\"currency\": \"USD\",\n" +
            "\t\t\"fundingType\": \"PRE_PAY\",\n" +
            "\t\t\"paymentType\": \"CREDIT_CARD\",\n" +
            "\t\t\"interCompany\": null,\n" +
            "\t\t\"deliveries\": [{\n" +
            "\t\t\t\t\"identity\": {\n" +
            "\t\t\t\t\t\"id\": \"GCV1STVV0AHFH2Y1531WX21RC0\",\n" +
            "\t\t\t\t\t\"name\": \"Recurring\",\n" +
            "\t\t\t\t\t\"description\": \"Recurring\",\n" +
            "\t\t\t\t\t\"code\": null\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"times\": [{\n" +
            "\t\t\t\t\t\"id\": \"0JGWB3SX2MGM6MQY4VW810YH08\",\n" +
            "\t\t\t\t\t\"month\": \"*\",\n" +
            "\t\t\t\t\t\"week\": null,\n" +
            "\t\t\t\t\t\"day\": \"*\",\n" +
            "\t\t\t\t\t\"weekDay\": \"?\",\n" +
            "\t\t\t\t\t\"hour\": \"*\",\n" +
            "\t\t\t\t\t\"minute\": \"21\",\n" +
            "\t\t\t\t\t\"factors\": [{\n" +
            "\t\t\t\t\t\t\"id\": \"ZCWYR2WS3D78W5CA6NR5C07044\",\n" +
            "\t\t\t\t\t\t\"component\": \"5\",\n" +
            "\t\t\t\t\t\t\"value\": null\n" +
            "\t\t\t\t\t}]\n" +
            "\t\t\t\t}],\n" +
            "\t\t\t\t\"expression\": {\n" +
            "\t\t\t\t\t\"id\": \"NQNAJ8VXK69K7LSTMDZGZGXZ68\",\n" +
            "\t\t\t\t\t\"cronExpression\": \"0 21 * * * ?\",\n" +
            "\t\t\t\t\t\"businessDescription\": \"At 21 minutes past the hour\",\n" +
            "\t\t\t\t\t\"startDate\": null,\n" +
            "\t\t\t\t\t\"type\": \"CRON\"\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"operations\": [{\n" +
            "\t\t\t\t\t\"id\": \"WQFVXHD70NB9756N5YYVBMJMT0\",\n" +
            "\t\t\t\t\t\"category\": \"EVENT\",\n" +
            "\t\t\t\t\t\"type\": \"SUBSC\",\n" +
            "\t\t\t\t\t\"format\": \"\",\n" +
            "\t\t\t\t\t\"method\": null,\n" +
            "\t\t\t\t\t\"deliveryDetail\": null,\n" +
            "\t\t\t\t\t\"contacts\": [\n" +
            "\n" +
            "\t\t\t\t\t],\n" +
            "\t\t\t\t\t\"unit\": null\n" +
            "\t\t\t\t}]\n" +
            "\t\t\t},\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"identity\": {\n" +
            "\t\t\t\t\t\"id\": \"MSJNVAWS08NJK47DX3RN5VK050\",\n" +
            "\t\t\t\t\t\"name\": \"Settle-Recon\",\n" +
            "\t\t\t\t\t\"description\": \"Settle-Recon\",\n" +
            "\t\t\t\t\t\"code\": null\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"times\": [{\n" +
            "\t\t\t\t\t\"id\": \"997HBJF05TYANLXTRGS8549TMR\",\n" +
            "\t\t\t\t\t\"month\": \"*\",\n" +
            "\t\t\t\t\t\"week\": null,\n" +
            "\t\t\t\t\t\"day\": \"*\",\n" +
            "\t\t\t\t\t\"weekDay\": \"?\",\n" +
            "\t\t\t\t\t\"hour\": \"*\",\n" +
            "\t\t\t\t\t\"minute\": \"59\",\n" +
            "\t\t\t\t\t\"factors\": [{\n" +
            "\t\t\t\t\t\t\"id\": \"LAL4X9WP2H2J8J91XY0Y9ZAH4R\",\n" +
            "\t\t\t\t\t\t\"component\": \"5\",\n" +
            "\t\t\t\t\t\t\"value\": null\n" +
            "\t\t\t\t\t}]\n" +
            "\t\t\t\t}],\n" +
            "\t\t\t\t\"expression\": {\n" +
            "\t\t\t\t\t\"id\": \"8RNC3X4TXJG91NLDLBRMVT9LX4\",\n" +
            "\t\t\t\t\t\"cronExpression\": \"59 59 * * * ? *\",\n" +
            "\t\t\t\t\t\"businessDescription\": \"At 59 seconds past the minute, at 59 minutes past the hour\",\n" +
            "\t\t\t\t\t\"startDate\": null,\n" +
            "\t\t\t\t\t\"type\": \"CRON\"\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"operations\": [{\n" +
            "\t\t\t\t\t\t\"id\": \"064548FQZLZCGX6SW29YJH182R\",\n" +
            "\t\t\t\t\t\t\"category\": \"EVENT\",\n" +
            "\t\t\t\t\t\t\"type\": \"RECON\",\n" +
            "\t\t\t\t\t\t\"format\": \"BHNST20CSV\",\n" +
            "\t\t\t\t\t\t\"method\": null,\n" +
            "\t\t\t\t\t\t\"deliveryDetail\": null,\n" +
            "\t\t\t\t\t\t\"contacts\": [\n" +
            "\n" +
            "\t\t\t\t\t\t],\n" +
            "\t\t\t\t\t\t\"unit\": null\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"id\": \"4FNDALSDC2HSPM7RK27FVR7K3C\",\n" +
            "\t\t\t\t\t\t\"category\": \"ARTIFACT\",\n" +
            "\t\t\t\t\t\t\"type\": \"INV\",\n" +
            "\t\t\t\t\t\t\"format\": \"BHNST20STMT\",\n" +
            "\t\t\t\t\t\t\"method\": \"FTP\",\n" +
            "\t\t\t\t\t\t\"deliveryDetail\": \"backgroundtestdp\",\n" +
            "\t\t\t\t\t\t\"contacts\": [\n" +
            "\t\t\t\t\t\t\t\"RMR8093S3SGADSM197QLVPD768\"\n" +
            "\t\t\t\t\t\t],\n" +
            "\t\t\t\t\t\t\"unit\": null\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t]\n" +
            "\t\t\t}\n" +
            "\t\t],\n" +
            "\t\t\"netTerms\": 1,\n" +
            "\t\t\"agedCancel\": false,\n" +
            "\t\t\"emailDeliveries\": [\n" +
            "\n" +
            "\t\t],\n" +
            "\t\t\"displayAs\": \"backgroundtestdp\",\n" +
            "\t\t\"transactionDelay\": null,\n" +
            "\t\t\"links\": [{\n" +
            "\t\t\t\"rel\": \"self\",\n" +
            "\t\t\t\"href\": \"https://int.blackhawknetwork.com/billing/v1/billers/41SC2XM1AX67KG0ZG3C2QV239M\",\n" +
            "\t\t\t\"hreflang\": null,\n" +
            "\t\t\t\"media\": null,\n" +
            "\t\t\t\"title\": null,\n" +
            "\t\t\t\"type\": null,\n" +
            "\t\t\t\"deprecation\": null\n" +
            "\t\t}]\n" +
            "\t},\n" +
            "\t\"selfLink\": {\n" +
            "\t\t\"rel\": \"self.local\",\n" +
            "\t\t\"href\": \"https://billingmanagement.local/billers/41SC2XM1AX67KG0ZG3C2QV239M/events/9R4XL2H61MR6XZNHBL57LJ9TH8\",\n" +
            "\t\t\"hreflang\": null,\n" +
            "\t\t\"media\": null,\n" +
            "\t\t\"title\": null,\n" +
            "\t\t\"type\": null,\n" +
            "\t\t\"deprecation\": null\n" +
            "\t},\n" +
            "\t\"links\": [{\n" +
            "\t\t\t\"rel\": \"self\",\n" +
            "\t\t\t\"href\": \"https://int.blackhawknetwork.com/billing/v1/billers/41SC2XM1AX67KG0ZG3C2QV239M/events/9R4XL2H61MR6XZNHBL57LJ9TH8\",\n" +
            "\t\t\t\"hreflang\": null,\n" +
            "\t\t\t\"media\": null,\n" +
            "\t\t\t\"title\": null,\n" +
            "\t\t\t\"type\": null,\n" +
            "\t\t\t\"deprecation\": null\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"rel\": \"Biller\",\n" +
            "\t\t\t\"href\": \"https://int.blackhawknetwork.com/billing/v1/billers/41SC2XM1AX67KG0ZG3C2QV239M\",\n" +
            "\t\t\t\"hreflang\": null,\n" +
            "\t\t\t\"media\": null,\n" +
            "\t\t\t\"title\": null,\n" +
            "\t\t\t\"type\": null,\n" +
            "\t\t\t\"deprecation\": null\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"rel\": \"self.local\",\n" +
            "\t\t\t\"href\": \"https://billingmanagement.local/billers/41SC2XM1AX67KG0ZG3C2QV239M/events/9R4XL2H61MR6XZNHBL57LJ9TH8\",\n" +
            "\t\t\t\"hreflang\": null,\n" +
            "\t\t\t\"media\": null,\n" +
            "\t\t\t\"title\": null,\n" +
            "\t\t\t\"type\": null,\n" +
            "\t\t\t\"deprecation\": null\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"rel\": \"Biller.local\",\n" +
            "\t\t\t\"href\": \"https://billingmanagement.local/billers/41SC2XM1AX67KG0ZG3C2QV239M\",\n" +
            "\t\t\t\"hreflang\": null,\n" +
            "\t\t\t\"media\": null,\n" +
            "\t\t\t\"title\": null,\n" +
            "\t\t\t\"type\": null,\n" +
            "\t\t\t\"deprecation\": null\n" +
            "\t\t}\n" +
            "\t]\n" +
            "}";


}