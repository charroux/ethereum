package com.charroux.ethereum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.selectrain.SelecTrain;
import org.web3j.tx.gas.DefaultGasProvider;

import java.math.BigInteger;

public class SmartContractInteraction {

    private static Logger logger = LoggerFactory.getLogger(SmartContractInteraction.class);

    public static void main(String[] args) {

        try {
            Web3j web3j = Web3j.build(new HttpService("HTTP://127.0.0.1:7545"));
            logger.info("web3j = " + web3j);
            SelecTrain selecTrain = SelecTrain.load("0x89eda8e7dd57c87de6c74a72b74483826ec4269d", web3j, Credentials.create("0xba915e64f14ff363abf52193444c30ae0cd2963034dc8a2448f02b95b33702f5"), new DefaultGasProvider());
            logger.info("deployed at: " + selecTrain.getContractAddress());
            SelecTrain.SelectedTrain selectedTrain = selecTrain.getTrain(BigInteger.valueOf(19)).send();
            logger.info("selectedTrain: + " + selectedTrain.number + ", " + selectedTrain.effectiveDepartureDate + ", " + selectedTrain.effectiveArrivalDate);
            web3j.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
