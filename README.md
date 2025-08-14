#  Telecom Subscription Plan Analyzer

A Java implementation of the **Visitor Design Pattern** for analyzing and comparing telecom subscription plans. This project demonstrates how to use the visitor pattern to perform different operations on telecom objects without modifying their core structure.

## 📋 Overview

The Telecom Plan Visitor allows you to analyze different telecom subscription plans (Smart, Globe, and Dito) by applying various visitor operations. The system uses the Visitor pattern to separate algorithms from the objects they operate on, making it easy to add new analysis operations without changing the telecom plan classes.

## 🏗️ Architecture

This project implements the **Visitor Design Pattern** with the following components:

- **TelcoSubscription Interface**: Defines the contract for all telecom subscription objects
- **Telco Class**: Concrete implementation of telecom subscription with data allowance, pricing, and unlimited call/text features
- **Visitor Interfaces**: `UsagePromo` and `UnliCallsTextOffer` define different types of operations
- **Concrete Visitors**: `TelcoAllowance` and `UnliCallTextPackage` implement specific analysis operations
- **Main Application**: Demonstrates the visitor pattern in action

### Design Pattern Benefits

- **Extensibility**: Easy to add new operations without modifying existing telecom classes
- **Separation of Concerns**: Algorithm logic is separated from data structure
- **Type Safety**: Strong typing for visitor operations
- **Maintainability**: Clean, well-structured code that's easy to understand and modify

## 📊 UML Class Diagram
<img width="964" height="575" alt="UML Class Diagram" src="https://github.com/user-attachments/assets/14bbcc23-869a-4d69-89ae-937bd8c842e2" />

The following diagram illustrates:
- The architecture of the Telecom Plan Visitor
- Relationships between the core components:
  - The `TelcoSubscription` interface
  - The `Telco` concrete implementation
  - Visitor interfaces: `UsagePromo` and `UnliCallsTextOffer`
  - Concrete visitors: `TelcoAllowance` and `UnliCallTextPackage`
- How the Visitor design pattern is applied in this project

## 🚀 Features

- **Multiple Telecom Providers**: Support for Smart, Globe, and Dito plans
- **Flexible Analysis Operations**: Different visitor types for various analyses
- **Data Allowance Analysis**: Compare data packages and pricing across providers
- **Unlimited Call/Text Analysis**: Evaluate unlimited calling and texting features
- **Extensible Design**: Easy to add new telecom providers and analysis operations
- **Clean Architecture**: Well-structured, maintainable code following design patterns

## 📁 Project Structure

```
telecom-plan-visitor/
├── src/
│   ├── TelcoSubscription.java         # Interface for telecom subscriptions
│   ├── Telco.java                     # Concrete telecom implementation
│   ├── UsagePromo.java                # Visitor interface for usage analysis
│   ├── UnliCallsTextOffer.java        # Visitor interface for unlimited features
│   ├── TelcoAllowance.java            # Concrete visitor for data allowance analysis
│   ├── UnliCallTextPackage.java       # Concrete visitor for unlimited features analysis
│   └── TelcoPromo.java                # Main application demo
└── README.md                          # Project documentation
```

## 🛠️ Installation & Setup

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code, etc.)

### Getting Started

1. **Clone or download** the project files
2. **Navigate** to the project directory
3. **Compile** the Java files:
   ```bash
   javac src/*.java
   ```
4. **Run** the application:
   ```bash
   java -cp src TelcoPromo
   ```

## 📖 Usage

### Basic Usage

The main application (`TelcoPromo.java`) demonstrates how to use the visitor pattern:

```java
// Create telecom subscription objects
TelcoSubscription smart = new Telco(15, 500, "Smart", false);
TelcoSubscription globe = new Telco(10, 450, "Globe", true);
TelcoSubscription dito = new Telco(8, 400, "Dito", true);

// Create visitor objects
UsagePromo promo = new TelcoAllowance();
UnliCallsTextOffer unli = new UnliCallTextPackage();

// Apply visitors to analyze data allowance
System.out.println("Smart Data Usage Offer and price: " + 
    promo.showAllowance(smart.getTelcoName(), smart.getPromoPrice()));

// Apply visitors to analyze unlimited features
System.out.println("Smart unlimited calls and text package: " + 
    unli.showUnliCallsTextOffer(smart.getTelcoName(), smart.getUnliCallText()));
```

### Expected Output

When you run the application, you'll see:

```
Smart Data Usage Offer and price: 15GB for ₱500.0 per month
Globe Data Usage Offer and price: 10GB for ₱450.0 per month
Dito Data Usage Offer and price: 8GB for ₱400.0 per month

Smart unlimited calls and text package: Does not offer any free calls or texts, and you will be charged per use.
Globe unlimited calls and text package: comes with unlimited calls and texts to subscribers within their network. Calls and texts to other networks are charged extra.
Dito unlimited calls and text package: This plan includes unlimited calls and texts to all networks within the country.
```

## 🔧 Extending the Project

### Adding New Telecom Providers

To add a new telecom provider (e.g., `Sun`):

1. **Create** a new `Telco` instance with appropriate parameters
2. **Add** the provider to the visitor maps in `TelcoAllowance` and `UnliCallTextPackage`
3. **Apply** visitors to analyze the new provider

Example:
```java
TelcoSubscription sun = new Telco(12, 480, "Sun", true);

// Add to TelcoAllowance map
promoMap.put("Sun", 12);

// Add to UnliCallTextPackage map
unliPackageMap.put("Sun", "Offers unlimited calls and texts with some restrictions.");
```

### Adding New Visitor Operations

To add a new analysis operation (e.g., `NetworkCoverage`):

1. **Create** a new visitor interface
2. **Implement** the concrete visitor class
3. **Add** the `accept` method to `TelcoSubscription` interface
4. **Implement** the `accept` method in `Telco` class

Example:
```java
public interface NetworkCoverage {
    String showCoverage(String telcoName, String region);
}

public class CoverageAnalyzer implements NetworkCoverage {
    @Override
    public String showCoverage(String telcoName, String region) {
        // Implementation for coverage analysis
    }
}
```

## 🎯 Design Patterns Used

### Visitor Pattern
- **Purpose**: Separate algorithms from the objects they operate on
- **Benefits**: Allows adding new operations without modifying existing classes
- **Implementation**: Telecom objects accept visitors, and visitors perform operations on the objects

### Strategy Pattern (Visitor Variations)
- **Purpose**: Different visitor types represent different analysis strategies
- **Benefits**: Encapsulates different algorithms and makes them interchangeable
- **Implementation**: `UsagePromo` and `UnliCallsTextOffer` represent different analysis strategies

## 📊 Telecom Plan Comparison

| Provider | Data Allowance | Price (₱) | Unlimited Calls/Texts |
|----------|----------------|-----------|----------------------|
| Smart    | 15 GB          | 500       | No                   |
| Globe    | 10 GB          | 450       | Within network only   |
| Dito     | 8 GB           | 400       | All networks         |

## 🤝 Contributing

Feel free to contribute to this project by:
- Adding new telecom providers
- Creating new visitor operations for different analyses
- Improving documentation
- Adding unit tests
- Enhancing the visitor pattern implementation

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

---

**Note**: This implementation demonstrates clean code principles and design patterns best practices. The Visitor pattern is particularly useful when you need to perform different operations on a set of objects without modifying their classes, making it perfect for analyzing telecom plans with various criteria.
