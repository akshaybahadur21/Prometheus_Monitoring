package com.akshaybahadur21.iCoin;

import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class ICoinService {

    String data="{'transactions': None, 'proof-of-work': 4830557}";
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();
    String timestamp=dateFormat.format(date);
     private List<ICoin> iCoins= new ArrayList<>(Arrays.asList(
             new ICoin(0,data,"0",timestamp)
        ));

    public List<ICoin> getBlocks() {
        return iCoins;
    }

    public void requestTransaction(String request,int i) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String timestamp=dateFormat.format(date);
        ICoin iCoin=new ICoin(i,request,"0",timestamp);
        iCoins.add(iCoin);

    }

    public List<ICoin> mineBlocks(int i,String data) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String timestamp=dateFormat.format(date);
        ICoin iCoin=new ICoin(i,data,"0",timestamp);
        iCoins.add(iCoin);
        return iCoins;

    }
}
