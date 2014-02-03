Password Validator
=========

This is a basic password validation library designed for Spring.

### What you can do with it

1. Define your own validations using XML with regex.
2. Define your own validations programatically by implementing the ValidationRule interface.
3. Define your own messages for your validations
4. Use it for the default validations it comes with

### Quick Start

Password Validator requires Maven version 3.0.4. 

To setup, open up a terminal and type:

1. git clone https://github.com/suisha/password-validator.git
2. cd password-validator 
3. mvn package
4. mvn install
5. Include the following in your application's pom.xml and then build:

			<dependency>
        	<groupId>dm.passwordvalidator</groupId>
					<artifactId>password-validator</artifactId>
					<version>0.0.1-SNAPSHOT</version>
      </dependency>

## Using the library

The simplest way to use the validator is to just run it with the default validations, which validathe following:

				- Must consist of a mixture of lowercase letters and numerical digits only, with at least one of each.
				- Must be between 5 and 12 characters in length.
				- Must not contain any sequence of characters immediately followed by the same sequence.

All you have to do is define it as a bean somewhere inside your context:

		<bean id="passwordValidator" class="dm.passwordvalidator.PasswordValidator"/>

You can validate your password string with the bean's validate method (if all you need is a boolean back), or validateWithMessages if you need the messages associated with the validations.

## Defining custom validations

If you want to use a custom regex rule, you can define your rule using the built in RegexValidationRule class in your configuration like this: 

	<bean id="lengthRule" class="dm.passwordvalidator.RegexValidationRule">
		<property name="regex" value=".{5,15}"/>
		<property name="message" value="Your password needs to be between 5 to 15 characters"/>
	</bean>
		
	<bean id="passwordValidator" class="dm.passwordvalidator.PasswordValidator">
		<property name="rules">
			<list>
				<ref bean="lengthRule" />             
			</list>
		</property>
	</bean> 

The RegexValidationRule class simply checks if the password string matches the regex or not. It's designed to make common validations easy to do with just XML.

If you need to write validations programmatically, you can create a custom validation by implementing the ValidationRule interface. You can then define these rules as beans and then put them inside the validation list the same way you would with the regex validations.
