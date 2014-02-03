package com.test.password_validator;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import dm.passwordvalidator.PasswordValidator;
import dm.passwordvalidator.RegexValidationRule;
import dm.passwordvalidator.ValidationResult;
import dm.passwordvalidator.ValidationRule;

public class ValidationTests {
	
	@Test
	public void testPasswordValidator() {
		PasswordValidator pv = new PasswordValidator();
		ValidationRule vr = new ValidationRule() {
			public boolean validate(String inPassword) {
				return false;
			}
			
			public String getMessage() {
				return "uh oh";
			}
			
		};		
		ValidationRule rvr = new RegexValidationRule("[a-z]", "foobar?");
		List<ValidationRule> rules = new ArrayList<ValidationRule>();
		rules.add(vr);
		rules.add(rvr);
		pv.setRules(rules);
		String testPass = "this will be inval1d n0 matter what";
		ValidationResult validity = pv.validateWithMessages(testPass);
		assertEquals(validity.getMessages().contains("uh oh"), true);
		assertEquals(validity.getMessages().contains("foobar?"), true);
	}
	
	@Test
	public void testSequenceRule() {
		PasswordValidator pv = new PasswordValidator();
		assertEquals(pv.validate("123123"), false);
		assertEquals(pv.validate("123abc123"), true);
		assertEquals(pv.validate("aa"), false);		
	}
	
	@Test
	public void testLengthRule() {
		PasswordValidator pv = new PasswordValidator();
		assertEquals(pv.validate("12345678901234a"), true);
		assertEquals(pv.validate("123456789012345a"), false);
		assertEquals(pv.validate("1a"), false);
		assertEquals(pv.validate("1234a"), true);
	}
	
	@Test
	public void testAtLeastOneNumber() {
		PasswordValidator pv = new PasswordValidator();
		assertEquals(pv.validate("abadsfas"), false);
		assertEquals(pv.validate("1abadsfa"), true);
		assertEquals(pv.validate("bja1414f"), true);
		assertEquals(pv.validate("#@)($*#@()$"), false);
	}
	
	@Test
	public void testAtLeastOneLowercaseLetter() {
		PasswordValidator pv = new PasswordValidator();
		assertEquals(pv.validate("ab14324234"), true);
		assertEquals(pv.validate("112312312"), false);
		assertEquals(pv.validate("badfkbja1414"), true);
		assertEquals(pv.validate("#@)($*#@()$"), false);
	}
	
	@Test
	public void testNumberLowercaseOnly() {
		PasswordValidator pv = new PasswordValidator();
		assertEquals(pv.validate("ab2342"), true);
		assertEquals(pv.validate("123ABSDLKBNSD"), false);
		assertEquals(pv.validate("@#$#$"), false);
		assertEquals(pv.validate("ABabc"), false);
	}
	
}
