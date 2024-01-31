# Mslm Java SDK

<a href="https://github.com/mslmio/sdk-java"><img src="https://img.shields.io/badge/build-passing-%231CB735"></a>
<a href="https://github.com/mslmio/sdk-java"><img src="https://img.shields.io/badge/Java-Doc-DE5C43.svg?logo=Java"></a>

The official Java SDK for Mslm APIs.

## Requirements

- Java 1.8 (or later)

## Authentication

Mslm's APIs require an API key. If you don't have one, please read [Authentication](https://mslm.io/docs/api/authentication) to understand how to get an API key before continuing.

## Installation

### Maven

Add the JitPack repository to your project's `pom.xml` file:

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
    <version>latest_version</version>
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
    implementation 'com.github.mslmio:sdk-java:latest_version'
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
    implementation 'com.github.mslmio:sdk-java:latest_version'
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
    implementation("com.github.mslmio:sdk-java:latest_version")
    // other dependencies...
}
```

## Usage

Let's go through how to start using the Mslm Java SDK with sample code.

### Import the SDK

In your Java file, import the library at the beginning of the file:

```Java
import io.mslm.mslm;
```

### Initialize the SDK

Create an instance of the `Mslm` class to use the entire Mslm SDK:

```Java
Mslm mslm = new Mslm();
```

### Using OTP

Sending OTP:

```Java
/* - Parameters:
   - phoneNumber: The phone number to which the OTP will be sent.
   - templateSMS: The template for the SMS containing the OTP.
   - tokenLength: The length of the OTP token.
   - expireSeconds: The expiration time of the OTP in seconds.
*/
try {
  OtpSendResp response = mslm.otp.sendOtp("+123456789", "Your OTP is", 6, 60);
  if (response.getCode() == 1000) {
    System.out.println("Success");
  } else {
    System.out.println("Failed");
    System.out.println(response.getMsg());
  }
} catch (Exception e) {
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
  OtpTokenVerifyResp response = mslm.otp.verify("+123456789", "1234");
  if (response.getCode() == 1000) {
    System.out.println("Success");
   } else {
     System.out.println("Failed");
     System.out.println(response.getMsg());
   }
} catch (Exception e) {
  throw new RuntimeException(e);
}
```

### Using Email Verify

```Java
try {
  SingleVerifyResp response = mslm.emailVerify.singleVerify("user@example.com");
  System.out.println("Success Response: " + response.toString());
} catch (Exception e) {
  System.out.println("Error: " + e.getMessage());
  throw new RuntimeException(e);
}
```

### Using Individual Clients

Selecting the Mslm package installs the full suite of Mslm products. If you only need specific functionalities (e.g., OTP or EmailVerify), you can choose individual products to minimize dependencies.

#### OTP

1. Import `OTP` in your Java file.

```Java
import io.mslm.otp;
```

2. Initialize the `OTP`

```Java
Otp otp = new Otp();
```

3. Make a call to the OTP

```Java
// Example function for sending OTP
try {
  OtpSendResp response = otp.sendOtp("+123456789", "Your OTP is", 6, 60);
  if (response.getCode() == 1000) {
    System.out.println("Success");
  } else {
    System.out.println("Failed");
    System.out.println(response.getMsg());
  }
} catch (Exception e) {
  throw new RuntimeException(e);
}
```

#### Email Verify

1. Import `EmailVerify` in your Java file.

```Java
import io.mslm.emailverify;
```

2. Initialize the `EmailVerify`

```Java
EmailVerify emailVerify = new EmailVerify();
```

3. Make a call to the EmailVerify

```Java
// Example function for email verification
try {
  SingleVerifyResp response = emailVerify.singleVerify("user@example.com");
  System.out.println("Success Response: " + response.toString());
} catch (Exception e) {
  System.out.println("Error: " + e.getMessage());
  throw new RuntimeException(e);
}
```

## Additional Resources

See the official [API Reference Documentation](https://mslm.io/docs/api) for
details on each API's actual interface, which is implemented by this SDK.

## Contributing

See [CONTRIBUTING](CONTRIBUTING.md) for more information.

## Security

See [Security Issue
Notifications](CONTRIBUTING.md#security-issue-notifications) for more
information.

## License

This project is licensed under the [MIT License](LICENSE).

## About Mslm

At Mslm, we're all about making things better. Where others see norm, we see
opportunity.

We build world-class solutions to the toughest problems. Excellence is a core
value that defines our approach from top to bottom.

We're all about creating positive value for ourselves, our partners and our
societies.

We do it by focusing on quality and the long-term, while intelligently
maneuvering the complex realities of day-to-day business.

Our partners share our perspective, and we jointly produce truly world-class
solutions to the toughest problems.

[![image](https://avatars.githubusercontent.com/u/50307970?s=200&v=4)](https://mslm.io/)