# Mslm Java SDK

<p>
<a href="https://github.com/mslmio/sdk-java"><img src="https://img.shields.io/badge/build-passing-%231CB735"></a>
<a href="https://github.com/mslmio/sdk-java"><img src="https://img.shields.io/badge/Java-Doc-DE5C43.svg?logo=Java"></a>
</p>
The official Java SDK for Mslm APIs.

## Requirements

- Java 1.8 (or later)

## Authentication

Mslm's APIs require an API key. If you don't have one, please
read [Authentication](https://mslm.io/docs/api/authentication) to understand how to get an API key before continuing.

## Installation

Replace `1.0.0` with the version you want to use. You can find the latest version on
the [SDK-Java GitHub releases page](https://github.com/mslmio/sdk-java/releases).

### Maven

Add the JitPack repository to your project's pom.xml file:

```xml 

<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

Then, add the following dependency:

```xml

<dependency>
    <groupId>com.github.mslmio</groupId>
    <artifactId>sdk-java</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Gradle

Add the JitPack repository and the following dependency to your project's `build.gradle` (or `build.gradle.kts` for
Kotlin DSL):

```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}

dependencies {
    implementation 'com.github.mslmio:sdk-java:1.0.0'
}
```

### Android

#### Gradle (Groovy DSL)

Add the JitPack repository to your project's `build.gradle` file:

```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Add the following dependency to your app module's `build.gradle` file:

```groovy
android {
    ...
}

dependencies {
    implementation 'com.github.mslmio:sdk-java:1.0.0'
}
```

#### Gradle (Kotlin DSL)

Add the JitPack repository to your project's `build.gradle.kts` file:

```kotlin
allprojects {
    repositories {
        ...
        maven("https://jitpack.io")
    }
}
```

Add the following dependency to your app module's build.gradle.kts file:

```kotlin
plugins {
    // other plugins...
}

android {
    // android configuration...
}

dependencies {
    implementation("com.github.mslmio:sdk-java:1.0.0")
    // other dependencies...
}
```

## Usage

Let's go through how to start using the Mslm Java SDK with sample code.

### 1. Import the SDK

In your Java file, import the library at the beginning of the file:

```Java
import io.mslm.mslm;
```

### 2. Initialize the SDK

Create an instance of the `Mslm` class to use the entire Mslm SDK:

```Java
Mslm mslm = new Mslm("YOUR_API_KEY");
```

### 3. OTP Usage

Sending OTP:

```Java
    /* - Parameters:
       - phoneNumber: The phone number to which the OTP will be sent.
       - templateSMS: The template for the SMS containing the OTP.
       - tokenLength: The length of the OTP token.
       - expireSeconds: The expiration time of the OTP in seconds.
    */
      try {
          OtpSendResp response=mslm.otp.sendOtp("+123456789","Your OTP is",6,60);
          if(response.getCode()==1000){
              System.out.println("Success");
              }else {
              System.out.println("Failed");
              System.out.println(response.getMsg());
              }
         } catch(Exception e){
              throw new RuntimeException(e);
              }
```

Verifying OTP:

```Java
/* - Parameters:
   - phone: The phone number to which the OTP was sent.
   - token: The OTP token to be verified.
   - consume: A flag indicating whether to consume the token after verification (default is `true`).
*/
     try {
         OtpTokenVerifyResp response=mslm.otp.verify("+123456789","1234");
         if(response.getCode()==1000){
             System.out.println("Success");
             }else {
             System.out.println("Failed");
             System.out.println(response.getMsg());
             }
         } catch(Exception e){
             throw new RuntimeException(e);
             }
```

### 4. Email Verification

```Java
    try {
        SingleVerifyResp response=mslm.emailVerify.singleVerify("user@example.com");
        System.out.println("Success Response: "+response.toString());
        } catch(Exception e){
        System.out.println("Error: "+e.getMessage());
        throw new RuntimeException(e);
        }
```

### 5. Using Only OTP or Email Verification

When integrating the Mslm package, the complete suite of Mslm products is included. However, if your project requires
only specific functionalities, such as OTP or Email Verification, you have the flexibility of leveraging individual
components.

#### OTP:

1. Import the OTP in your Java file.

```Java
import io.mslm.otp;
```

2. Initialize the Otp SDK

```Java
Otp otp = new Otp("Your_API_KEY");
```

3. Make a call to the OTP

```Java
    try {
        OtpSendResp response=otp.sendOtp("+123456789","Your OTP is",6,60);
        if(response.getCode()==1000){
            System.out.println("Success");
            }else {
            System.out.println("Failed");
            System.out.println(response.getMsg());
            }
        } catch(Exception e){
        throw new RuntimeException(e);
        }
```

4. Make a call to verify the OTP

```Java
    try {
        OtpTokenVerifyResp response=otp.verify("+123456789","12345");
        if(response.getCode()==1000){
            System.out.println("Success");
            }else {
            System.out.println("Failed");
            System.out.println(response.getMsg());
            }
        } catch(Exception e){
        throw new RuntimeException(e);
        }
```

#### Email:

1. Import the EmailVerify in your Java file.

```Java
import io.mslm.emailverify;
```

2. Initialize the EmailVerify SDK

```Java
EmailVerify emailVerify = new EmailVerify("YOUR_API_KEY");
```

3. Make a call to the EmailVerify

```Java
     try {
        SingleVerifyResp response=emailVerify.singleVerify("user@example.com");
        System.out.println("Success Response: "+response.toString());
        }
        catch(Exception e){
        System.out.println("Error: "+e.getMessage());
        throw new RuntimeException(e);
        }

```

## About Mslm

Mslm focuses on producing world-class business solutions. It’s the bread-and-butter of our business to prioritize
quality on everything we touch. Excellence is a core value that defines our culture from top to bottom.

[![image](https://avatars.githubusercontent.com/u/50307970?s=200&v=4)](https://mslm.io/)
