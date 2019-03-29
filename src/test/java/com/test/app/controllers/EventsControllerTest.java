package com.test.app.controllers;

import com.test.app.entities.EventModel;
import com.test.app.utils.JsonParser;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@FixMethodOrder(NAME_ASCENDING)
public class EventsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static EventModel request1Model;
    private static EventModel request2Model;

    @BeforeClass
    public static void initRequestObjects() throws IOException {
        request1Model = JsonParser.parseObjectJson(request1, EventModel.class);
        request2Model = JsonParser.parseObjectJson(request2, EventModel.class);
    }


    @Test
    public void clientActivatedEventsCreate() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .post("/events")
                .accept(MediaType.APPLICATION_JSON)
                .content(request1)
                .contentType(MediaType.APPLICATION_JSON));


        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$.eventId", is(request1Model.getEventId())))
                .andExpect(jsonPath("$.entityType", is(request1Model.getEntityType())))
                .andExpect(jsonPath("$.entityId", is(request1Model.getEntityId())))
                .andExpect(jsonPath("$.type", is(request1Model.getType())))
                .andExpect(jsonPath("$._links", notNullValue()))
                .andExpect(jsonPath("$._links.Client", notNullValue()))
                .andExpect(jsonPath("$._links.['Client.local']", notNullValue()));
    }

    @Test
    public void billerUpdateEventsCreate() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .post("/events")
                .accept(MediaType.APPLICATION_JSON)
                .content(request2)
                .contentType(MediaType.APPLICATION_JSON));


        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$.eventId", is(request2Model.getEventId())))
                .andExpect(jsonPath("$.entityType", is(request2Model.getEntityType())))
                .andExpect(jsonPath("$.entityId", is(request2Model.getEntityId())))
                .andExpect(jsonPath("$.type", is(request2Model.getType())))
                .andExpect(jsonPath("$._links", notNullValue()))
                .andExpect(jsonPath("$._links.Biller", notNullValue()))
                .andExpect(jsonPath("$._links.['Biller.local']", notNullValue()))
                .andExpect(jsonPath("$._links.self", notNullValue()))
                .andExpect(jsonPath("$._links.['self.local']", notNullValue()));
    }


    @Test
    public void clientActivatedEventsGet() throws Exception {
        clientActivatedEventsCreate();
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .get("/events/" + request1Model.getEventId()));


        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$.eventId", is(request1Model.getEventId())))
                .andExpect(jsonPath("$.entityType", is(request1Model.getEntityType())))
                .andExpect(jsonPath("$.entityId", is(request1Model.getEntityId())))
                .andExpect(jsonPath("$.type", is(request1Model.getType())))
                .andExpect(jsonPath("$._links", notNullValue()))
                .andExpect(jsonPath("$._links.Client", notNullValue()))
                .andExpect(jsonPath("$._links.['Client.local']", notNullValue()));
    }

    @Test
    public void billerUpdateEventsGet() throws Exception {
        billerUpdateEventsCreate();
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .get("/events/" + request2Model.getEventId()));

        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$.eventId", is(request2Model.getEventId())))
                .andExpect(jsonPath("$.entityType", is(request2Model.getEntityType())))
                .andExpect(jsonPath("$.entityId", is(request2Model.getEntityId())))
                .andExpect(jsonPath("$.type", is(request2Model.getType())))
                .andExpect(jsonPath("$._links", notNullValue()))
                .andExpect(jsonPath("$._links.Biller", notNullValue()))
                .andExpect(jsonPath("$._links.['Biller.local']", notNullValue()))
                .andExpect(jsonPath("$._links.self", notNullValue()))
                .andExpect(jsonPath("$._links.['self.local']", notNullValue()));
    }


    @Test
    public void clientActivatedEventsUpdate() throws Exception {
        clientActivatedEventsCreate();

        EventModel updatedModel = request1Model.setType("AnotherType");
        String json = JsonParser.prepareObjectJson(updatedModel);
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .put("/events")
                .accept(MediaType.APPLICATION_JSON)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON));


        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$.eventId", is(updatedModel.getEventId())))
                .andExpect(jsonPath("$.entityType", is(updatedModel.getEntityType())))
                .andExpect(jsonPath("$.entityId", is(updatedModel.getEntityId())))
                .andExpect(jsonPath("$.type", is(updatedModel.getType())))
                .andExpect(jsonPath("$._links", notNullValue()))
                .andExpect(jsonPath("$._links.Client", notNullValue()))
                .andExpect(jsonPath("$._links.['Client.local']", notNullValue()));
    }

    @Test
    public void billerUpdateEventsUpdate() throws Exception {
        billerUpdateEventsCreate();

        EventModel updatedModel = request2Model.setType("AnotherType2");
        String json = JsonParser.prepareObjectJson(updatedModel);

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .put("/events")
                .accept(MediaType.APPLICATION_JSON)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$.eventId", is(updatedModel.getEventId())))
                .andExpect(jsonPath("$.entityType", is(updatedModel.getEntityType())))
                .andExpect(jsonPath("$.entityId", is(updatedModel.getEntityId())))
                .andExpect(jsonPath("$.type", is(updatedModel.getType())))
                .andExpect(jsonPath("$._links", notNullValue()))
                .andExpect(jsonPath("$._links.Biller", notNullValue()))
                .andExpect(jsonPath("$._links.['Biller.local']", notNullValue()))
                .andExpect(jsonPath("$._links.self", notNullValue()))
                .andExpect(jsonPath("$._links.['self.local']", notNullValue()));
    }

    @Test
    public void clientActivatedEventsDelete() throws Exception {
        clientActivatedEventsCreate();
        String eventId = request1Model.getEventId();
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .delete("/events/" + eventId));

        resultActions.andExpect(status().isOk());

        resultActions = mockMvc.perform(MockMvcRequestBuilders
                .get("/events/" + eventId));
        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    public void billerUpdateEventsDelete() throws Exception {
        billerUpdateEventsCreate();
        String eventId = request2Model.getEventId();
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .delete("/events/" + eventId));

        resultActions.andExpect(status().isOk());

        resultActions = mockMvc.perform(MockMvcRequestBuilders
                .get("/events/" + eventId));
        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$").doesNotExist());
    }


    private static String request1 = "{\"eventId\":\"G5A1AY8MPHL3RGPSYAGWA6XJ9C\",\"entityId\":\"XJ0RF7TJHVQ9DJ3GR046DF2F8R\",\"type\":\"CLIENT_ACTIVATED\",\"entityType\":\"Client\",\"entity\":{\"identity\":{\"id\":\"XJ0RF7TJHVQ9DJ3GR046DF2F8R\",\"name\":\"sICcZIiOoiPOST\",\"description\":\"TEST Client Description POST\",\"code\":null},\"entity\":{\"parent\":{\"id\":null,\"name\":null,\"description\":null,\"code\":null},\"picture\":\"http://test.test.co\",\"type\":\"CLIENT\",\"state\":\"ACTIVE\",\"bindings\":[{\"identity\":{\"id\":\"T9C42JNA5BDR1QP75NVMTJ8N58\",\"name\":\"CLIENT\",\"description\":\"Test Binding Description POST\",\"code\":null},\"type\":\"CASHSTAR\",\"code\":\"tKhCDtoQydlhzO7g6Q\"}],\"history\":{\"createdDate\":\"2019-03-21T17:36:10.767+0000\",\"createdBy\":null,\"modifiedDate\":\"2019-03-21T17:36:10.821+0000\",\"modifiedBy\":null,\"reason\":null,\"auditSource\":null},\"source\":\"CASHSTAR\",\"inheritance\":null},\"type\":\"MERCHANT\",\"companyCode\":\"UdQrKzpFW1POST\",\"isBHNClient\":false,\"_links\":{\"self\":{\"href\":\"https://int.blackhawknetwork.com/account/v1/clients/XJ0RF7TJHVQ9DJ3GR046DF2F8R\"}}},\"attributes\":{},\"_links\":{\"Client\":{\"href\":\"https://int.blackhawknetwork.com/account/v1/clients/XJ0RF7TJHVQ9DJ3GR046DF2F8R\"},\"Client.local\":{\"href\":\"https://accountmanagement.local/clients/XJ0RF7TJHVQ9DJ3GR046DF2F8R\"}}}";

    private static String request2 = "{\"eventId\":\"9R4XL2H61MR6XZNHBL57LJ9TH8\",\"entityId\":\"41SC2XM1AX67KG0ZG3C2QV239M\",\"type\":\"BILLER_UPDATED\",\"entityType\":\"Biller\",\"created\":null,\"updated\":null,\"entity\":{\"identity\":{\"id\":\"41SC2XM1AX67KG0ZG3C2QV239M\",\"name\":\"backgroundtestDP\",\"description\":\"autotest DP\",\"code\":null},\"entity\":{\"parent\":{\"id\":\"A8DZTVDFXWRCZNHXL3K9HMFTB8\",\"name\":null,\"description\":null,\"code\":null},\"picture\":null,\"type\":\"BILLER\",\"state\":\"ACTIVE\",\"bindings\":[],\"history\":{\"createdDate\":\"2019-01-21T16:18:45.000+0000\",\"createdBy\":\"API\",\"modifiedDate\":\"2019-03-21T18:15:13.565+0000\",\"modifiedBy\":\"Mykhailo.Bestiuk@bhnetwork.com\",\"reason\":null,\"auditSource\":null},\"source\":null,\"inheritance\":null},\"legalEntity\":{\"id\":\"A8DZTVDFXWRCZNHXL3K9HMFTB8\",\"name\":null,\"description\":null,\"code\":null},\"clientId\":\"DCJQTJRVM25X087NN9S179VM2H\",\"billerName\":\"backgroundtestDP\",\"billerDescription\":\"autotest DP\",\"currencyCode\":\"USD\",\"billerType\":\"RECEIVABLE\",\"type\":\"RECEIVABLE\",\"biller\":null,\"billingType\":\"ALL\",\"businessUnit\":\"B072\",\"channel\":\"1100\",\"instrument\":null,\"currency\":\"USD\",\"fundingType\":\"PRE_PAY\",\"paymentType\":\"CREDIT_CARD\",\"interCompany\":null,\"deliveries\":[{\"identity\":{\"id\":\"GCV1STVV0AHFH2Y1531WX21RC0\",\"name\":\"Recurring\",\"description\":\"Recurring\",\"code\":null},\"times\":[{\"id\":\"0JGWB3SX2MGM6MQY4VW810YH08\",\"month\":\"*\",\"week\":null,\"day\":\"*\",\"weekDay\":\"?\",\"hour\":\"*\",\"minute\":\"21\",\"factors\":[{\"id\":\"ZCWYR2WS3D78W5CA6NR5C07044\",\"component\":\"5\",\"value\":null}]}],\"expression\":{\"id\":\"NQNAJ8VXK69K7LSTMDZGZGXZ68\",\"cronExpression\":\"0 21 * * * ?\",\"businessDescription\":\"At 21 minutes past the hour\",\"startDate\":null,\"type\":\"CRON\"},\"operations\":[{\"id\":\"WQFVXHD70NB9756N5YYVBMJMT0\",\"category\":\"EVENT\",\"type\":\"SUBSC\",\"format\":\"\",\"method\":null,\"deliveryDetail\":null,\"contacts\":[],\"unit\":null}]},{\"identity\":{\"id\":\"MSJNVAWS08NJK47DX3RN5VK050\",\"name\":\"Settle-Recon\",\"description\":\"Settle-Recon\",\"code\":null},\"times\":[{\"id\":\"997HBJF05TYANLXTRGS8549TMR\",\"month\":\"*\",\"week\":null,\"day\":\"*\",\"weekDay\":\"?\",\"hour\":\"*\",\"minute\":\"59\",\"factors\":[{\"id\":\"LAL4X9WP2H2J8J91XY0Y9ZAH4R\",\"component\":\"5\",\"value\":null}]}],\"expression\":{\"id\":\"8RNC3X4TXJG91NLDLBRMVT9LX4\",\"cronExpression\":\"59 59 * * * ? *\",\"businessDescription\":\"At 59 seconds past the minute, at 59 minutes past the hour\",\"startDate\":null,\"type\":\"CRON\"},\"operations\":[{\"id\":\"064548FQZLZCGX6SW29YJH182R\",\"category\":\"EVENT\",\"type\":\"RECON\",\"format\":\"BHNST20CSV\",\"method\":null,\"deliveryDetail\":null,\"contacts\":[],\"unit\":null},{\"id\":\"4FNDALSDC2HSPM7RK27FVR7K3C\",\"category\":\"ARTIFACT\",\"type\":\"INV\",\"format\":\"BHNST20STMT\",\"method\":\"FTP\",\"deliveryDetail\":\"backgroundtestdp\",\"contacts\":[\"RMR8093S3SGADSM197QLVPD768\"],\"unit\":null}]}],\"netTerms\":1,\"agedCancel\":false,\"emailDeliveries\":[],\"displayAs\":\"backgroundtestdp\",\"transactionDelay\":null,\"links\":[{\"rel\":\"self\",\"href\":\"https://int.blackhawknetwork.com/billing/v1/billers/41SC2XM1AX67KG0ZG3C2QV239M\",\"hreflang\":null,\"media\":null,\"title\":null,\"type\":null,\"deprecation\":null}]},\"selfLink\":{\"rel\":\"self.local\",\"href\":\"https://billingmanagement.local/billers/41SC2XM1AX67KG0ZG3C2QV239M/events/9R4XL2H61MR6XZNHBL57LJ9TH8\",\"hreflang\":null,\"media\":null,\"title\":null,\"type\":null,\"deprecation\":null},\"links\":[{\"rel\":\"self\",\"href\":\"https://int.blackhawknetwork.com/billing/v1/billers/41SC2XM1AX67KG0ZG3C2QV239M/events/9R4XL2H61MR6XZNHBL57LJ9TH8\",\"hreflang\":null,\"media\":null,\"title\":null,\"type\":null,\"deprecation\":null},{\"rel\":\"Biller\",\"href\":\"https://int.blackhawknetwork.com/billing/v1/billers/41SC2XM1AX67KG0ZG3C2QV239M\",\"hreflang\":null,\"media\":null,\"title\":null,\"type\":null,\"deprecation\":null},{\"rel\":\"self.local\",\"href\":\"https://billingmanagement.local/billers/41SC2XM1AX67KG0ZG3C2QV239M/events/9R4XL2H61MR6XZNHBL57LJ9TH8\",\"hreflang\":null,\"media\":null,\"title\":null,\"type\":null,\"deprecation\":null},{\"rel\":\"Biller.local\",\"href\":\"https://billingmanagement.local/billers/41SC2XM1AX67KG0ZG3C2QV239M\",\"hreflang\":null,\"media\":null,\"title\":null,\"type\":null,\"deprecation\":null}]}";


}