package com.charroux.ethereum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.crypto.Credentials;
import org.web3j.greeter.Greeter;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.selectrain.SelecTrain;

import java.math.BigInteger;

public class SmartContractDeployment {

    private static Logger logger = LoggerFactory.getLogger(SmartContractDeployment.class);

    public static void main(String[] args) {

        /*try {
            Web3j web3j = Web3j.build(new HttpService("HTTP://127.0.0.1:7545"));
            logger.info("web3j = " + web3j);
            Greeter greeter = Greeter.deploy(web3j, Credentials.create("0xba915e64f14ff363abf52193444c30ae0cd2963034dc8a2448f02b95b33702f5"), new DefaultGasProvider(), "Hello").send();
            logger.info("deployed");
            greeter.newGreeting("Salut").send();
            String response = greeter.greet().send();
            logger.info("greeter = " + response);
            web3j.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        try {
            Web3j web3j = Web3j.build(new HttpService("HTTP://127.0.0.1:7545"));
            logger.info("web3j = " + web3j);
            SelecTrain selecTrain = SelecTrain.deploy(web3j, Credentials.create("0xba915e64f14ff363abf52193444c30ae0cd2963034dc8a2448f02b95b33702f5"), new DefaultGasProvider()).send();
            logger.info("deployed at: " + selecTrain.getContractAddress());
            SelecTrain.SelectedTrain selectedTrain = selecTrain.getTrain(BigInteger.valueOf(19)).send();
            logger.info("selectedTrain: + " + selectedTrain.number + ", " + selectedTrain.effectiveDepartureDate + ", " + selectedTrain.effectiveArrivalDate);
            web3j.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 0x57e612913108564d04cc39b2f6c9129d8a7ca5a1


    }


}
