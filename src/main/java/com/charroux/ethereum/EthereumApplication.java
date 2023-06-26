package com.charroux.ethereum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.EthGasPrice;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;

@SpringBootApplication
public class EthereumApplication implements CommandLineRunner {

	private static Logger logger = LoggerFactory.getLogger(EthereumApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EthereumApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Web3j web3 = Web3j.build(new HttpService("http://localhost:8545"));
		logger.info("Successfuly connected to Ethereum");

		try {
			// web3_clientVersion returns the current client version.
			Web3ClientVersion clientVersion = web3.web3ClientVersion().send();

			// eth_blockNumber returns the number of most recent block.
			EthBlockNumber blockNumber = web3.ethBlockNumber().send();

			// eth_gasPrice, returns the current price per gas in wei.
			EthGasPrice gasPrice = web3.ethGasPrice().send();

			// Print result
			logger.info("Client version: " + clientVersion.getWeb3ClientVersion());
			logger.info("Block number: " + blockNumber.getBlockNumber());
			logger.info("Gas price: " + gasPrice.getGasPrice());

		} catch (IOException ex) {
			throw new RuntimeException("Error whilst sending json-rpc requests", ex);
		}

	}
}
