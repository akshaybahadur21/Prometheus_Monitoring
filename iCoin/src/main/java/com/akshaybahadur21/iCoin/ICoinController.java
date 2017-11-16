package com.akshaybahadur21.iCoin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.prometheus.client.Counter;
import io.prometheus.client.Gauge;

import java.util.Arrays;
import java.util.List;

@RestController
public class ICoinController {

    private static final Counter iCoinGetAllBlocks=Counter
            .build("iCoin_get_All_blocks","Total number of GetBlock Requests")
            .register();
    private static final Counter iCoinMine=Counter
            .build("iCoin_Mine_New_Block","Total time mining has been done")
            .register();
    private static final Counter iCoinPOSTTransaction=Counter
            .build("iCoin_pst_transaction","Total number of POST Requests")
            .register();
    private static final Gauge iCoinResponseTime=Gauge
            .build("time_for_request","Response time for each REST request")
            .register();

    int i=0;
    @Autowired
    private ICoinService iCoinService;


    @RequestMapping("/blocks")
    public List<ICoin> getBlocks()
    {
        iCoinGetAllBlocks.inc();
        iCoinResponseTime.setToCurrentTime();
        iCoinResponseTime.startTimer();
        return iCoinService.getBlocks();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/request_transaction")
    public String requestTransaction(@RequestBody String request)
    {
        iCoinPOSTTransaction.inc();
        iCoinResponseTime.setToCurrentTime();
        iCoinResponseTime.startTimer();
        i++;
        iCoinService.requestTransaction(request,i);
        return "Transaction added to Ledger. Mine for Transaction";
    }

    @RequestMapping("/mine")
    public List<ICoin> mineBlocks()
    {
        iCoinMine.inc();
        iCoinResponseTime.setToCurrentTime();
        iCoinResponseTime.startTimer();
        i++;
        String data="{'to': 'frufhi55kefj-akshay-address-ndji45jjg6', 'amount': 1, 'from': 'System'}";
        return iCoinService.mineBlocks(i,data);

    }
}
