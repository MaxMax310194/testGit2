package validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<CustomPhone, String> {

	@Override
	public void initialize(CustomPhone cp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String tele, ConstraintValidatorContext contextValid) {
		
		if (tele.matches("\\d{10}")) {
			return true;
		}else {
			return false;
		}
	}
	

}
