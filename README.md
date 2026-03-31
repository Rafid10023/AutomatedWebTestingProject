# Automated Web Testing Project

## Project Goal:
Our project goal is to test the functionality for the website: https://automationexercise.com/
 
The website itself is a mock-up of a store where a user can register to the website, add items to a shopping cart, verify those products in the shopping cart and then check out and place an order. Our project will outline and test how well a user it able to use the website under specific user stories and scenarios. 
 
Our testing methods will include using Exploratory Testing, Unit Testing and Gherkin to represent acceptance tests for our user stories. 
 

## How to set up the test framework:
The Poject SDK must be set under: 
21 Oracle OpenJDK 21.0.10

The Language level must be set under: 
21 - Record patterns, pattern matching for switch

<img width="707" height="86" alt="image" src="https://github.com/user-attachments/assets/3df9057c-1ba7-4b20-b29f-8691b8f36075" />


Required dependencies:
The following dependencies must be copied and synced in the pom.xml file of the project to run the tests:

- junit-jupiter 5.10.0
- hamcrest 2.2
- selenium-java 4.10.0
- slf4j-simple 2.0.7
- serenity-junit5 3.9.8
- webdrivermanager 5.8.0
- serenity-core 3.9.8
- serenity-cucumber 3.9.8
- serenity-junit5 3.9.8
- junit 4.13.2


```
 <dependencies>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>5.10.0</version>
        </dependency>
        <dependency>
            <groupId>org.hamcrest</groupId>
            <artifactId>hamcrest</artifactId>
            <version>2.2</version>
        </dependency>
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.10.0</version>
        </dependency>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-simple</artifactId>
            <version>2.0.7</version>
        </dependency>
        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-junit5</artifactId>
            <version>3.9.8</version>
        </dependency>
        <dependency>
            <groupId>io.github.bonigarcia</groupId>
            <artifactId>webdrivermanager</artifactId>
            <version>5.8.0</version>
        </dependency>
        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-core</artifactId>
            <version>3.9.8</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-cucumber</artifactId>
            <version>3.9.8</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-junit5</artifactId>
            <version>3.9.8</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.2</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
```

## Tests:

Tests | Description
------|------------
Test 1| Register a user
Test 2 | Login user with correct email and password
Test 3 | Login user with incorrect email and password
Test 4 | Logout user
Test 5 | Register user with existing email
Test 6 | Using the Contact Us Form
Test 7 | Verify All Products and product detail page
Test 8 | Filtering products
Test 9 | Verify Subscription in home page
Test 10 | Verify Subscription in Cart page
Test 11 | Add Products in Cart
Test 12 | Verify Product quantity in Cart
Test 13 | Checking out a product
Test 14 | Add review on product
Test 15 | Add cart from Recommended Items
Test 16 | Scroll Up using 'Arrow Button'






