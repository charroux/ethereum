# Java Ethereum

## Ganache node

Lauch a Ganache node

Create a new workspace in order to increase the GAS limit: 

<img src="images/gaslimit.png">

## Project configuration

Java 17 is required.

Web3j as a Gradle plugin:

```
plugins {
    id 'java'
    id 'org.springframework.boot' version '3.1.1'
    id 'io.spring.dependency-management' version '1.1.0'
    id 'org.web3j' version '4.10.0'
}
```

See https://github.com/charroux/ethereum/blob/main/build.gradle



