package com.real.athletic.index.utils;

import java.util.Arrays;
import java.util.List;

import org.passay.CharacterData;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.PasswordGenerator;
import org.passay.PasswordValidator;
import org.passay.RuleResult;
import org.passay.WhitespaceRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.real.athletic.index.constant.RealAIConstants;

public class RandomPasswordGeneratorUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(RandomPasswordGeneratorUtils.class);

	private RandomPasswordGeneratorUtils() {
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String generateRandomPassword() {

		List rules = Arrays.asList(new CharacterRule(EnglishCharacterData.UpperCase, 2),
				new CharacterRule(EnglishCharacterData.Alphabetical, 2),
				new CharacterRule(EnglishCharacterData.LowerCase, 1), new CharacterRule(EnglishCharacterData.Digit, 2),
				new CharacterRule(new CharacterData() {
					@Override
					public String getErrorCode() {
						return null;
					}

					@Override
					public String getCharacters() {
						return RealAIConstants.POSSIBLE_CHARACTERS;
					}
				}, 1));

		PasswordGenerator generator = new PasswordGenerator();
		return generator.generatePassword(8, rules);
	}

	public static boolean isPasswordValid(String password) {
		boolean isPasswordValid = false;
		PasswordValidator validator = new PasswordValidator(
				Arrays.asList(new LengthRule(8, 16), new CharacterRule(EnglishCharacterData.UpperCase, 1),
						new CharacterRule(EnglishCharacterData.LowerCase, 1),
						new CharacterRule(EnglishCharacterData.Digit, 1), new CharacterRule(new CharacterData() {
							@Override
							public String getErrorCode() {
								return null;
							}

							@Override
							public String getCharacters() {
								return RealAIConstants.POSSIBLE_CHARACTERS;
							}
						}, 1), new WhitespaceRule()));

		RuleResult result = validator.validate(new PasswordData(password));
		if (result.isValid()) {
			isPasswordValid = true;
			LOGGER.info("The supplied password - is valid {}", password);
		} else {
			isPasswordValid = false;
			final StringBuilder message = new StringBuilder();
			validator.getMessages(result).stream().forEach(message::append);
			LOGGER.info("The supplied password - is not invalid : {} because -> {}", password, message);
		}
		return isPasswordValid;
	}

}
