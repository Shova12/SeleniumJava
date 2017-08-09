package cucmberTest.transformation;

import cucumber.api.Transformer;

public class EmailTransformation extends Transformer<String>{
	
	@Override
	public String transform(String userName){
		return userName.concat("ea.com");
	}

}
